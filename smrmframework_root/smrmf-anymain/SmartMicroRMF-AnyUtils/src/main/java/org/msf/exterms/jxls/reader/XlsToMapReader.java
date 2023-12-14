/*
 * Copyright yysvip.tistory.com.,LTD.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of yysvip.tistory.com.,LTD. ("Confidential Information").
 */
package org.msf.exterms.jxls.reader; 

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;

/**
 * <pre>
 * org.msf.exterms.xls.web 
 *    |_ testReader.java
 * 
 * </pre>
 * @date : Nov 24, 2015 4:12:33 AM
 * @version : 
 * @author : leeheuisung
 */
public class XlsToMapReader {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	
    private static XlsToMapReader oneXlsRE;  
 	  
    private  XlsToMapReader () {
 	
    }
    
    public static XlsToMapReader getInstance() {
        if(oneXlsRE==null) {
        	oneXlsRE = new XlsToMapReader();
        }
        return oneXlsRE;
    }
    
	/**
	 * <pre>
	 * 1. 개요 : 엑셀업로드 메서드 
	 * 2. 처리내용 : 업로드한 엑셀 파일을 xml에설정된 정보를 바탕으로 읽어 결과값을 맵에 담아 리턴 한다. 
	 *             mapRtnData.put("statusOK", readStatus.isStatusOK()) 결과를 담아 리턴 한다. 
	 * </pre>
	 * @Method Name : readExcel
	 * @date : Nov 24, 2015
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Nov 24, 2015		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param request  HttpServletRequest
	 * @param xmlConfig xml xls리더 설정정보
	 * @param fis  업로드 파일(읽을 엑셀파일정보)
	 * @param mapRtnData  읽은 결과 값을 받을 객체을 맵으로 넘기고 결과값을 받기 위한 객체 
	 * @return map 
	 * @throws IOException
	 * @throws SAXException
	 * @throws InvalidFormatException
	 */ 	
	public Map<String,Object> readXlsExcel(HttpServletRequest request, String xmlConfig,InputStream fis,Map<String,Object> mapRtnData)  throws IOException, SAXException, InvalidFormatException {
		InputStream inputXML = null;
		InputStream inputXLS = null;
		try { 
	       	
			inputXML = new BufferedInputStream(new FileInputStream(xmlConfig));  //TestReader.class.getResourceAsStream()
            XLSReader mainReader = ReaderBuilder.buildFromXML( inputXML );
            inputXLS = new BufferedInputStream(fis); 
            
            XLSReadStatus readStatus = mainReader.read(inputXLS, mapRtnData);
            
            mapRtnData.put("statusOK", readStatus.isStatusOK()); //
            
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 if (inputXML != null)    // 2011.11.1 보안점검 후속조치
				 inputXML.close();
			 if (inputXLS != null)    // 2011.11.1 보안점검 후속조치
				 inputXLS.close();
		}
		
		return mapRtnData;
	}
	  

}
