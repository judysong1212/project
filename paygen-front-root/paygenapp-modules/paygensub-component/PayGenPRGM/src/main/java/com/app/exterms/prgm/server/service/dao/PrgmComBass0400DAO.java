package com.app.exterms.prgm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.prgm.server.vo.PrgmComBass0400VO;
import com.app.exterms.prgm.server.vo.PrgmComSearchVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
//import com.googlecode.ehcache.annotations.Cacheable;

/**
 * @Class Name : Bass0400DAO.java
 * @Description : Bass0400 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PrgmComBass0400DAO")
public class PrgmComBass0400DAO extends EgovAbstractDAO {

	/**
	 * BASS0400을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0400VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBass0400(PrgmComBass0400VO vo) throws Exception {
        return (String)insert("prgmComBass0400DAO.insertBass0400_S", vo);
    }

    /**
	 * BASS0400을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0400VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBass0400(PrgmComBass0400VO vo) throws Exception {
        update("prgmComBass0400DAO.updateBass0400_S", vo);
    }

    /**
	 * BASS0400을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0400VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBass0400(PrgmComBass0400VO vo) throws Exception {
        delete("prgmComBass0400DAO.deleteBass0400_S", vo);
    }

    /**
	 * BASS0400을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0400VO
	 * @return 조회한 BASS0400
	 * @exception Exception
	 */
    
    public PrgmComBass0400VO selectBass0400(PrgmComBass0400VO vo) throws Exception {
        return (PrgmComBass0400VO) selectByPk("prgmComBass0400DAO.selectBass0400_S", vo);
    }

    /**
	 * BASS0400 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0400 목록
	 * @exception Exception
	 */
    
    public List selectBass0400List(PrgmComSearchVO searchVO) throws Exception {
        return list("prgmComBass0400DAO.selectBass0400List_D", searchVO);
    }
    
    /**
     * BASS0400 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0400 목록
     * @exception Exception
     */
  //  @Cacheable(value = "deptCache")  
    public List selectBass0400ComboList(PrgmComSearchVO searchVO) throws Exception {
        return list("prgmComBass0400DAO.selectBass0400List_D", searchVO);
    } 
    

    /**
	 * BASS0400 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0400 총 갯수
	 * @exception
	 */
   // @Cacheable(cacheName = "deptCache")  
    public int selectBass0400ListTotCnt(PrgmComSearchVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmComBass0400DAO.selectBass0400ListTotCnt_S", searchVO);
    }

    

    /**
	 * 관리부서 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 관리부서 목록
	 * @exception Exception
	 */
  //  @Cacheable(cacheName = "deptCache")  
    public List selectPrgmComMangDeptBass0400List(PrgmComSearchVO searchVO) throws Exception {
        return list("prgmComBass0400DAO.selectMangDeptBass0400List_D", searchVO);
    }

    /**
	 * 관리부서 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 관리부서 총 갯수
	 * @exception
	 */
   // @Cacheable(cacheName = "deptCache")  
    public int selectPrgmComMangDeptBass0400ListTotCnt(PrgmComSearchVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmComBass0400DAO.selectMangDeptBass0400ListTotCnt_S", searchVO);
    }
    
    
    /**
     * BASS0400 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0400 목록
     * @exception Exception
     */
    
    public List selectPayrWithBass0400List(PrgmComSearchVO searchVO) throws Exception {
        return list("prgmComBass0400DAO.selectPayrWithBass0400List_D", searchVO);
    }
     

    /**
     * BASS0400 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0400 총 갯수
     * @exception
     */
   // @Cacheable(cacheName = "deptCache")  
    public int selectPayrWithBass0400ListTotCnt(PrgmComSearchVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmComBass0400DAO.selectPayrWithBass0400ListTotCnt_S", searchVO);
    }

}
