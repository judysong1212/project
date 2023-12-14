package com.app.exterms.prgm.server.utils;

import java.util.ArrayList;
import java.util.List;

import org.msf.utils.SmrmfUtils;

public class PrgmComServerUtils {
     
    /**
     * in조건 쿼리 를 위한 스트링으로 넘어온 데이터 를 list로 변환 하여 검색조건으로 넘기기 위한 처리 
     * @param strValue
     * @return
     */
    public static List<String> getStrToArrayList(String strValue) {
         
        List<String> listValue = new ArrayList<String>(); 
        if (SmrmfUtils.dataNotNull(strValue)) {
	        String[] rayDeptCd = strValue.substring(0, strValue.length()).split(",");
	        
	        for (int i=0; i<rayDeptCd.length; i++){ 
	            listValue.add(rayDeptCd[i]);
	        }  
        } else {
        	listValue.add("");
        }
        return listValue;
        
    }

}
