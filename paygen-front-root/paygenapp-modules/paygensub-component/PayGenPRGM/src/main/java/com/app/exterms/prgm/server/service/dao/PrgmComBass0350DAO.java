package com.app.exterms.prgm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.prgm.server.vo.PrgmComBass0350VO;
import com.app.exterms.prgm.server.vo.PrgmComSearchVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
//import com.googlecode.ehcache.annotations.Cacheable;

/**
 * @Class Name : Bass0350DAO.java
 * @Description : Bass0350 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PrgmComBass0350DAO")
public class PrgmComBass0350DAO extends EgovAbstractDAO {

	/**
	 * BASS0350을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0350VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBass0350(PrgmComBass0350VO vo) throws Exception {
        return (String)insert("prgmComBass0350DAO.insertBass0350_S", vo);
    }

    /**
	 * BASS0350을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0350VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBass0350(PrgmComBass0350VO vo) throws Exception {
        update("prgmComBass0350DAO.updateBass0350_S", vo);
    }

    /**
	 * BASS0350을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0350VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBass0350(PrgmComBass0350VO vo) throws Exception {
        delete("prgmComBass0350DAO.deleteBass0350_S", vo);
    }

    /**
	 * BASS0350을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0350VO
	 * @return 조회한 BASS0350
	 * @exception Exception
	 */
    
    public PrgmComBass0350VO selectBass0350(PrgmComBass0350VO vo) throws Exception {
        return (PrgmComBass0350VO) selectByPk("prgmComBass0350DAO.selectBass0350_S", vo);
    }

    /**
	 * BASS0350 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0350 목록
	 * @exception Exception
	 */
  //  @Cacheable(cacheName = "typOccuCdCache")  
    public List selectBass0350List(PrgmComSearchVO searchVO) throws Exception {
        return list("prgmComBass0350DAO.selectBass0350List_D", searchVO);
    }

    /**
	 * BASS0350 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0350 총 갯수
	 * @exception
	 */
   // @Cacheable(cacheName = "typOccuCdCache")  
    public int selectBass0350ListTotCnt(PrgmComSearchVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmComBass0350DAO.selectBass0350ListTotCnt_S", searchVO);
    }
    
    /**
   	 * BASS0350 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return BASS0350 목록
   	 * @exception Exception
   	 */
     //  @Cacheable(cacheName = "typOccuCdCache")  
       public List selectNonBass0350List(PrgmComSearchVO searchVO) throws Exception {
           return list("prgmComBass0350DAO.selectNonBass0350List_D", searchVO);
       }

       /**
   	 * BASS0350 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return BASS0350 총 갯수
   	 * @exception
   	 */
      // @Cacheable(cacheName = "typOccuCdCache")  
       public int selectNonBass0350ListTotCnt(PrgmComSearchVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("prgmComBass0350DAO.selectNonBass0350ListTotCnt_S", searchVO);
       }
     
    
    /**
     * BASS0350 목록을 조회한다.팝업처리시 사용
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0350 목록
     * @exception Exception
     */ 
    public List selectBass0350PopupList(PrgmComSearchVO searchVO) throws Exception {
        return list("prgmComBass0350DAO.selectBass0350PopupList_D", searchVO);
    }

    /**
     * BASS0350 총 갯수를 조회한다.팝업처리시 사용
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0350 총 갯수
     * @exception
     */ 
    public int selectBass0350PopupListTotCnt(PrgmComSearchVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmComBass0350DAO.selectBass0350PopupListTotCnt_S", searchVO);
    }
    
     
    
    /**
     * 급여 BASS0350 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0350 목록
     * @exception Exception
     */
   
    public List selectPayrBass0350List(PrgmComSearchVO searchVO) throws Exception {
        return list("prgmComBass0350DAO.selectPayrBass0350List_D", searchVO);
    }

    /**
     * 급여BASS0350 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0350 총 갯수
     * @exception
     */
    
    public int selectPayrBass0350ListTotCnt(PrgmComSearchVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmComBass0350DAO.selectPayrBass0350ListTotCnt_S", searchVO);
    }
    
    
}
