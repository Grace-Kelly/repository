package com.csmf.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

public class RequestJsonFormat {
	private static Log log = LogFactory.getLog(RequestJsonFormat.class);
	private static JsonConfig config = new JsonConfig();
	static {
		config.setJavaPropertyFilter(new PropertyFilter() {

			public boolean apply(Object paramObject1, String paramString,
					Object paramObject2) {
				if (paramString.equals("chk")) {
					return false;
				}
				return true;
			}
		});
	};

	public static JSONObject toJsonObject(HttpServletRequest request) throws Exception {
		String encoding = request.getCharacterEncoding();
		// 上送报文
		BufferedInputStream in = null;
		ByteArrayOutputStream out = null;
		try {
			byte buf[] = new byte[1024];
			in = new BufferedInputStream(request.getInputStream());
			out = new ByteArrayOutputStream(10240);
			int len;
			while ((len = in.read(buf)) >= 0) {
				out.write(buf, 0, len);
			}
			String jsonStr = new String(out.toByteArray(),
					encoding == null ? "utf-8" : encoding);
			if (jsonStr == null || "".equals(jsonStr)) {
				return null;
			}
			log.info("accept json string:【" + jsonStr + "】");
			return JSONObject.fromObject(jsonStr);
		} catch (IOException ex) {
			throw new Exception(ex);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
