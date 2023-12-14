package org.msf.exterms.xls.service;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.insurance.server.vo.Insr5100SrhVO;
import com.app.exterms.insurance.server.vo.Insr5100VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface Insr5100ExcelService {
    
    /**
     * 국민연금기본리스트 출력  
     * @param  
     * @return
     * @throws Exception
     */
     List selectXlsInsr5100List(Insr5100SrhVO insr5100SrhVO) throws Exception;
	
	  /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    void insertXlsInsr4300(InputStream file) throws Exception;
    
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    void insertXlsInsr4100(InputStream file) throws Exception;
    
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    void insertXlsPsnl0127(InputStream file) throws Exception;
    
     
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    void insertXSSFInsr4300(InputStream file) throws Exception;

    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    void insertXSSFInsr4100(InputStream file) throws Exception;

    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    void insertXSSFPsnl0127(InputStream file) throws Exception;
     
    /**
	 *  엑셀파일을 등록한다.
	 * @param  hashmap
	 * @throws Exception
	 */
	Long updateXlsInsr5100(List<Insr5100VO> insr5100List, HttpServletRequest request) throws MSFException;

     
}
