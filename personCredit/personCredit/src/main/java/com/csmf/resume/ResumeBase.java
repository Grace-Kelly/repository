package com.csmf.resume;

import java.io.InputStream;

import com.csmf.dto.Resume;

public interface ResumeBase {
	
	public Resume parseDoc(InputStream in);

}
