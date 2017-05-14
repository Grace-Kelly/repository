package com.csmf.resume;

import java.io.File;
import java.util.Map;

public interface ResumeUploadService {

	public Map<String,Object> resumeZipParse(File file,String companyId) throws Exception;
	
}
