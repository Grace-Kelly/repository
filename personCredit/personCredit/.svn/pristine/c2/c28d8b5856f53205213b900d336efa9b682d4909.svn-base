package com.csmf.util;

import java.util.HashMap;
import java.util.Map;

public class PagingUtil {
    public static final int pageSize = 10;

    public static Map<String, Integer> getPaging(String currentPage) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int currentPages = Integer.parseInt(currentPage);
        int startRow = currentPages * PagingUtil.pageSize - PagingUtil.pageSize;
        int endRow = currentPages * PagingUtil.pageSize;
        map.put("startRow", startRow);
        map.put("endRow", endRow);
        return map;
    }
}
