package org.msf.exterms.xls.service;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.insurance.server.vo.Insr3000SrhVO;
import com.app.exterms.insurance.server.vo.Insr3000VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface Insr4100ExcelService {
    
    /**
     * 국민연금기본리스트 출력  
     * @param  
     * @return
     * @throws Exception
     */
     List selectXlsInsr3000List(Insr3000SrhVO insr3000SrhVO) throws Exception;
	
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
	 * 엑셀파일을 등록한다._jxls
	 * @param  hMap
	 * @throws Exception
	 */
	
    /**
	 *  엑셀파일을 등록한다.
	 * @param  hashmap
	 * @throws Exception
	 */
	Long updateXlsInsr4100(List<Insr3000VO> insr3000List, HttpServletRequest request) throws MSFException;
}
