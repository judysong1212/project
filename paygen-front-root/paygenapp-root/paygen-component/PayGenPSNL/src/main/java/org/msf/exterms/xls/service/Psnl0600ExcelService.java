package org.msf.exterms.xls.service;

import java.util.HashMap;
import java.util.List;

import com.app.exterms.personal.server.vo.Psnl0600SrhVO;

public interface Psnl0600ExcelService {
	
	
	
    /**
     *  인사통합출력 엑셀저장
     * @param Psnl0600SrhVO
     * @return
     * @throws Exception
     */
    List selectXlsPsnl0600SelList(Psnl0600SrhVO psnl0600SrhVo) throws Exception;
	
	
    
    /**
     *  인사통합출력 엑셀저장(기본)
     * @param Psnl0600SrhVO
     * @return
     * @throws Exception
     */
    //List selectXlsPsnl0600List(Psnl0100SrhVO psnl0100SrhVo) throws Exception;
    
    List selectXlsPsnl0600List(Psnl0600SrhVO psnl0600SrhVo) throws Exception;
    
    /**
     *  인사통합출력 엑셀저장(병역)
     * @param Psnl0600SrhVO
     * @return
     * @throws Exception
     */
    List selectXlsPsnl0600ToPsnl0112List(Psnl0600SrhVO psnl0600SrhVo) throws Exception;
    
    /**
     *  인사통합출력 엑셀저장(단체)
     * @param Psnl0600SrhVO
     * @return
     * @throws Exception
     */
    List selectXlsPsnl0600ToPsnl0114List(Psnl0600SrhVO psnl0600SrhVo) throws Exception;
    
    /**
     *  인사통합출력 엑셀저장(학력)
     * @param Psnl0600SrhVO
     * @return
     * @throws Exception
     */
    List selectXlsPsnl0600ToPsnl0116List(Psnl0600SrhVO psnl0600SrhVo) throws Exception;
    
    /**
     *  인사통합출력 엑셀저장(경력)
     * @param Psnl0600SrhVO
     * @return
     * @throws Exception
     */
    List selectXlsPsnl0600ToPsnl0119List(Psnl0600SrhVO psnl0600SrhVo) throws Exception;
    
    /**
     *  인사통합출력 엑셀저장(자격)
     * @param Psnl0600SrhVO
     * @return
     * @throws Exception
     */
    List selectXlsPsnl0600ToPsnl0118List(Psnl0600SrhVO psnl0600SrhVo) throws Exception;
    
    /**
     *  인사통합출력 엑셀저장(교육)
     * @param Psnl0600SrhVO
     * @return
     * @throws Exception
     */
    List selectXlsPsnl0600ToPsnl0120List(Psnl0600SrhVO psnl0600SrhVo) throws Exception;
    
    /**
     *  인사통합출력 엑셀저장(포상)
     * @param Psnl0600SrhVO
     * @return
     * @throws Exception
     */
    List selectXlsPsnl0600ToPsnl0121List(Psnl0600SrhVO psnl0600SrhVo) throws Exception;
    
    /**
     *  인사통합출력 엑셀저장(징계)
     * @param Psnl0600SrhVO
     * @return
     * @throws Exception
     */
    List selectXlsPsnl0600ToPsnl0122List(Psnl0600SrhVO psnl0600SrhVo) throws Exception;
    
    /**
     *  인사통합출력 엑셀저장(휴직)
     * @param Psnl0600SrhVO
     * @return
     * @throws Exception
     */
    List selectXlsPsnl0600ToPsnl0123List(Psnl0600SrhVO psnl0600SrhVo) throws Exception;
    
    
    
    
    /**
     *  리스트 
     * @param payr0250SrhVo
     * @return
     * @throws Exception
     */
    List selectXlsPsnl0600List(HashMap<String, String> param) throws Exception;
    
   
}
