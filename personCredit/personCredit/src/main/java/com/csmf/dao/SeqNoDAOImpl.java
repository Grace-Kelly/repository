package com.csmf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.csmf.dto.SerialNumberConfigDto;
import com.csmf.util.SerialNumberType;

@Component("seqNoDAO")
public class SeqNoDAOImpl extends SqlSessionDaoSupport implements ISeqNoDAO {
    // 创建日志对象
    private final Log log = LogFactory.getLog(this.getClass());
    
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
             super.setSqlSessionFactory(sqlSessionFactory);
    }
    
    
//    static {
//        try {
//        	reader  = Resources.getResourceAsReader("sqlMapConfig.xml");
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally{
//        	if(reader != null){
//        		try {
//        			reader.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//        	}
//        }
//    }

    /**
     * 
     * @TODO 获取流水号
     * @param config
     * @return
     * @throws Exception
     * 
     */
    public String getFlwNo(SerialNumberConfigDto config) {
        Connection connection = null;
        // CallableStatement cs = null;
        String flowNo = null;
        try {
            // 获取connection连接
        	SqlSessionTemplate st = (SqlSessionTemplate) getSqlSession();
        	connection = SqlSessionUtils.getSqlSession(
                    st.getSqlSessionFactory(), st.getExecutorType(),
                    st.getPersistenceExceptionTranslator()).getConnection();
            SerialNumberConfigDto[] serialNumberConfigs = new SerialNumberConfigDto[3];
            serialNumberConfigs[0] = new SerialNumberConfigDto(config.getDefaultValue(), SerialNumberType.DEFAULT);
            serialNumberConfigs[1] = new SerialNumberConfigDto(config.getType());
            serialNumberConfigs[2] = new SerialNumberConfigDto(SerialNumberType.SEQNO, config.getSeqNoName(),
                    config.getLength());
            flowNo = builderSerialNo(connection, serialNumberConfigs);
        } catch (Exception e) {
            log.error("获取流水号异常：" + e.getMessage());
        }
        return flowNo;
    }

    public  String builderSerialNo(Connection connection, SerialNumberConfigDto[] serialNumberConfigs) {
        String serialNo = "";
        for (SerialNumberConfigDto config : serialNumberConfigs) {
            SerialNumberType type = config.getType();
            switch (type) {
            case NULL: {
                break;
            }
            case DEFAULT: {
                serialNo += config.getDefaultValue();
                break;
            }
            case yyyyMMdd: {
                serialNo += (new SimpleDateFormat("yyyyMMdd")).format(new Date());
                break;
            }
            case yyyyMMddHHmmss: {
                serialNo += (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
                break;
            }
            case yyyyMMddHHmmSSS: {
                serialNo += (new SimpleDateFormat("yyyyMMddHHmmSSS")).format(new Date());
                break;
            }
            case SEQNO: {
                serialNo += String.format("%0" + config.getLength() + "d", getSeqNo(connection, config.getSeqNoName()));
                break;
            }
            }
        }
        return serialNo;
    }

    private  Integer getSeqNo(Connection connection, String seqNoName) {
        Integer seqNo = 0;
        String sql = "SELECT NAME,CURRENT_VALUE,INCREMENT from t_sys_sequence where name='" + seqNoName + "'";
        Statement statement = null;
        ResultSet res = null;
        try {
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            res = statement.executeQuery(sql);
            if (res.next()) {
                Integer currentValue = res.getInt(2);
                Integer increment = res.getInt(3);
                seqNo = currentValue + increment;
                res.updateInt(2, seqNo);
                res.updateRow();
            }
            connection.commit();
        } catch (SQLException e) {
        	e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            seqNo = -1;
        }finally {
			/*if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}*/
		} 
        return seqNo;
    }
    
    
    
    /**
     * 生成序列号：
     * seqNoName : 数据库sys_sequence的name
     * defaultVaule : 拼接 
     * {seqNoName：defaultVaule}
     * {"CSMF","F"}为表obj_file文件路径表的id
     * {"PS","I"}为表t_person_info的id
     * {"PS","E"}为表t_person_edu_info的id
     * {"PS","W"}为表t_person_work_expe_info的id
     * {"PS","P"}为表t_person_proj_expe_info的id
     * {"PS","T"}为表t_person_training_info的id
     * {"PS","C"}为表t_certificate的id
     * {"PS","S"}为表t_person_all_skill的id
     */
    @Transactional(propagation = Propagation.REQUIRED, timeout = 20, rollbackFor = Exception.class)
    public String getFlwNo(String seqNoName,String defaultValue) throws Exception {
    	if(seqNoName!=null && !seqNoName.equals("") && defaultValue!=null && !defaultValue.equals("")){
    		SerialNumberConfigDto dto = new SerialNumberConfigDto();
        	dto.setDefaultValue(defaultValue);
        	dto.setLength(12);
        	dto.setSeqNoName(seqNoName);
        	dto.setType(SerialNumberType.NULL);
        	return getFlwNo(dto);
    	}else{
    		throw new Exception("生成序列号失败");
    	}
    	
    	
    }
}

