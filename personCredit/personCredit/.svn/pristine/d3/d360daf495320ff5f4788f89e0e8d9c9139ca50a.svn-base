package com.csmf.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class DateToJson implements JsonValueProcessor {
	
	private String format ="yyyy/MM/dd";  
	
	public DateToJson() {  
        super();  
    }
	
	public DateToJson(String format) {  
        super();  
        this.format = format;  
    }  
	
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		return process(arg0);
	}

	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		return process(arg0); 
	}
	
	private Object process(Object value){  
        if(value instanceof Date){    
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(value);  
        }    
        return value == null ? "" : value.toString();    
    } 
}
