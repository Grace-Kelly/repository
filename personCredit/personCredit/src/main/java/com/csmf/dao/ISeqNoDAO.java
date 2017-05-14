package com.csmf.dao;

import com.csmf.dto.SerialNumberConfigDto;

public interface ISeqNoDAO {
    String getFlwNo(SerialNumberConfigDto config);

    String getFlwNo(String string, String string2)  throws Exception;
}
