package com.csmf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * Hello world!
 *
 */
public class App {
	
	public static Map<String,String>  FILE_TYPE_MAP = new HashMap<String,String>();
	
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
	
	
    public static void main( String[] args ){
    	getTextFromWord("D:\\我的简历.doc");
    	/*try {
			canExtractImage();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
    }
    
	/**
	 * 
	 * @Title: getTextFromWord
	 * @Description: 读取word
	 * @param filePath 文件路径
	 * @return: String 读出的Word的内容
	 */
	public static String getTextFromWord(String filePath) {
		String result = null;
		File file = new File(filePath);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			@SuppressWarnings("resource")
			WordExtractor wordExtractor = new WordExtractor(fis);
			result = wordExtractor.getText();
			//System.out.println(result);
			String[] s = wordExtractor.getCommentsText();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public static void canExtractImage() throws IOException {


		InputStream is = new FileInputStream("D:\\我的简历.doc");
		XWPFDocument document = new XWPFDocument(is);


		XHTMLOptions options = XHTMLOptions.create();// .indent( 4 );
		// Extract image
		File imageFolder = new File("d:/test.html");
		options.setExtractor(new FileImageExtractor(imageFolder));
		// URI resolver
		options.URIResolver(new FileURIResolver(imageFolder));


		OutputStream out = new FileOutputStream(new File("d:/test.html"));
		XHTMLConverter.getInstance().convert(document, out, options);




		InputStream i1s = new FileInputStream("d:/test.html");

		java.io.BufferedReader in = null;
		StringBuffer sb = new StringBuffer();
		try {
			in = new java.io.BufferedReader(new java.io.InputStreamReader(i1s));
	
			for (String line; (line = in.readLine()) != null;) {
				sb.append(line);
			}
		} finally {
			if (in != null) {
			in.close();
		}
		}

		System.out.println(sb.toString());
	}
	
	
	

	
}


