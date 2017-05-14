package com.csmf.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FileUtil {
	
	private static Map<String,String>  FILE_TYPE_MAP = new HashMap<String,String>();
	
	static{
		getAllFileType();
	}
	
	/**   
	 * Discription:[getAllFileType,常见文件头信息] 
	 */     
	private static void getAllFileType(){     
	    FILE_TYPE_MAP.put("3c68746d6c20786d6c6e", "htm");//猎聘、智联简历.htm
	    FILE_TYPE_MAP.put("46726f6d3a3cd3c920cd", "mht");//51job简历.mht
	}  
	
	/**
	 * 获取简历信息转换成json格式
	 * 
	 * @param is
	 * @return
	 */
	public static Object getFileInfoToJson(InputStream is){
		String fileType = getFileType(is);
		/*switch (fileType) {
		case "htm":
			
			break;
		case "mht":
			
			break;
		default:
			break;
		}*/
		return "";
	}
	
	/** 
     * 根据文件路径获取文件头信息 
     *  
     * @param filePath 
     *            文件路径 
     * @return 文件头信息 
     */  
    public static String getFileHeader(InputStream is) {  
        //FileInputStream is = null;  
        String value = null;  
        try {  
            //is = new FileInputStream(filePath);  
            byte[] b = new byte[4];  
            /* 
             * int read() 从此输入流中读取一个数据字节。 int read(byte[] b) 从此输入流中将最多 b.length 
             * 个字节的数据读入一个 byte 数组中。 int read(byte[] b, int off, int len) 
             * 从此输入流中将最多 len 个字节的数据读入一个 byte 数组中。 
             */  
            is.read(b, 0, b.length);  
            value = bytesToHexString(b);  
        } catch (Exception e) {  
        	e.printStackTrace();
        } finally {  
            if (null != is) {  
                try {  
                    is.close();  
                } catch (IOException e) {  
                	e.printStackTrace();
                }  
            }  
        }  
        return value;  
    }  
  
    /** 
     * 将要读取文件头信息的文件的byte数组转换成string类型表示 
     *  
     * @param src 
     *            要读取文件头信息的文件的byte数组 
     * @return 文件头信息 
     */  
    private static String bytesToHexString(byte[] src) {  
        StringBuilder builder = new StringBuilder();  
        if (src == null || src.length <= 0) {  
            return null;  
        }  
        String hv;  
        for (int i = 0; i < src.length; i++) {  
            // 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式，并转换为大写  
            hv = Integer.toHexString(src[i] & 0xFF).toUpperCase();  
            if (hv.length() < 2) {  
                builder.append(0);  
            }  
            builder.append(hv);  
        }  
        System.out.println(builder.toString());  
        return builder.toString();  
    } 
    
    /**
     * 根据制定文件的文件头判断其文件类型
     * @param filePaht
     * @return
     */
    public static String getFileType(InputStream is){
        String res = null;
        try {
            //FileInputStream is = new FileInputStream(filePaht);
            byte[] b = new byte[10];
            is.read(b, 0, b.length);
            String fileCode = bytesToHexString(b);               
            System.out.println(fileCode);                      
            //这种方法在字典的头代码不够位数的时候可以用但是速度相对慢一点
            Iterator<String> keyIter = FILE_TYPE_MAP.keySet().iterator();
            while(keyIter.hasNext()){
                String key = keyIter.next();
                if(key.toLowerCase().startsWith(fileCode.toLowerCase()) || fileCode.toLowerCase().startsWith(key.toLowerCase())){
                    res = FILE_TYPE_MAP.get(key);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
    
}
