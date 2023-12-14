package org.msf.exterms.xls.service;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.insurance.server.vo.Insr4100SrhVO;
import com.app.exterms.insurance.server.vo.Insr4100VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface Insr3100ExcelService {
    
    /**
     * 국민연금기본리스트 출력  
     * @param  
     * @return
     * @throws Exception
     */
     List selectXlsInsr4100List(Insr4100SrhVO insr4100SrhVO) throws Exception;
	
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
	Long updateXlsInsr3100(List<Insr4100VO> insr4100List, HttpServletRequest request) throws MSFException;
}
