package com.csmf.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;


public class IdCardValidation {
	final static Map<Integer, String> province = new HashMap<Integer, String>();
    static {
        province.put(11, "北京");
        province.put(12, "天津");
        province.put(13, "河北");
        province.put(14, "山西");
        province.put(15, "内蒙古");
        province.put(21, "辽宁");
        province.put(22, "吉林");
        province.put(23, "黑龙江");
        province.put(31, "上海");
        province.put(32, "江苏");
        province.put(33, "浙江");
        province.put(34, "安徽");
        province.put(35, "福建");
        province.put(36, "江西");
        province.put(37, "山东");
        province.put(41, "河南");
        province.put(42, "湖北");
        province.put(43, "湖南");
        province.put(44, "广东");
        province.put(45, "广西");
        province.put(46, "海南");
        province.put(50, "重庆");
        province.put(51, "四川");
        province.put(52, "贵州");
        province.put(53, "云南");
        province.put(54, "西藏");
        province.put(61, "陕西");
        province.put(62, "甘肃");
        province.put(63, "青海");
        province.put(64, "新疆");
        province.put(71, "台湾");
        province.put(81, "香港");
        province.put(82, "澳门");
        province.put(91, "外国");
    }
     
    final static int[] PARITYBIT = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
    final static int[] POWER_LIST = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 
        5, 8, 4, 2};
     
    /**
     * 身份证验证
     *@param s  号码内容
     *@return 是否有效 null和"" 都是false 
     */
    public static boolean isIDCard(String certNo){
        if(certNo == null || (certNo.length() != 15 && certNo.length() != 18))
            return false;
        final char[] cs = certNo.toUpperCase().toCharArray();
        //校验位数
        int power = 0;
        for(int i=0; i<cs.length; i++){
            if(i==cs.length-1 && cs[i] == 'X')
                break;//最后一位可以 是X或x
            if(cs[i]<'0' || cs[i]>'9')
                return false;
            if(i < cs.length -1){
                power += (cs[i] - '0') * POWER_LIST[i];
            }
        }
         
        //校验区位码
        if(!province.containsKey(Integer.valueOf(certNo.substring(0,2)))){
            return false;
        }
         
        //校验年份
        String year = certNo.length() == 15 ? getIdcardCalendar() + certNo.substring(6,8) :certNo.substring(6, 10);
         
        final int iyear = Integer.parseInt(year);
        if(iyear < 1900 || iyear > Calendar.getInstance().get(Calendar.YEAR))
            return false;//1900年的PASS，超过今年的PASS
         
        //校验月份
        String month = certNo.length() == 15 ? certNo.substring(8, 10) : certNo.substring(10,12);
        final int imonth = Integer.parseInt(month);
        if(imonth <1 || imonth >12){
            return false;
        }
         
        //校验天数      
        String day = certNo.length() ==15 ? certNo.substring(10, 12) : certNo.substring(12, 14);
        final int iday = Integer.parseInt(day);
        if(iday < 1 || iday > 31)
            return false;       
         
        //校验"校验码"
        if(certNo.length() == 15)
            return true;
        return cs[cs.length -1 ] == PARITYBIT[power % 11];
    }
     
    private static int getIdcardCalendar() {        
         GregorianCalendar curDay = new GregorianCalendar();
         int curYear = curDay.get(Calendar.YEAR);
         int year2bit = Integer.parseInt(String.valueOf(curYear).substring(2));          
         return  year2bit;
    } 
}
