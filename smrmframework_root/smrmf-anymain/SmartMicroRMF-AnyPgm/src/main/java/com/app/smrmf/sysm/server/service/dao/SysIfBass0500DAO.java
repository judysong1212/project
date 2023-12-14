package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.service.vo.SysComSearchVO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0500VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
//import com.googlecode.ehcache.annotations.Cacheable; 

/**
 * @Class Name : Bass0500DAO.java
 * @Description : Bass0500 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SysIfBass0500DAO")
public class SysIfBass0500DAO extends EgovAbstractDAO {

	/**
	 * BASS0500을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0500VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBass0500(SysIfBass0500VO vo) throws Exception {
        return (String)insert("sysIfBass0500DAO.insertBass0500_S", vo);
    }

    /**
	 * BASS0500을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0500VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBass0500(SysIfBass0500VO vo) throws Exception {
        update("sysIfBass0500DAO.updateBass0500_S", vo);
    }

    /**
	 * BASS0500을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0500VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBass0500(SysIfBass0500VO vo) throws Exception {
        delete("sysIfBass0500DAO.deleteBass0500_S", vo);
    }

    /**
	 * BASS0500을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0500VO
	 * @return 조회한 BASS0500
	 * @exception Exception
	 */
    public SysIfBass0500VO selectBass0500(SysIfBass0500VO vo) throws Exception {
        return (SysIfBass0500VO) selectByPk("sysIfBass0500DAO.selectBass0500_S", vo);
    }

    
    /**
	 * BASS0500 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0500 목록
	 * @exception Exception
	 */
   // @Cacheable(cacheName = "binsnCache") 
    public List selectSysComWithBusinApptnYr(SysComSearchVO searchVO) throws Exception {
        return list("sysIfBass0500DAO.selectSysComWithBusinApptnYr_D", searchVO);
    }
    
    
    /**
	 * BASS0500 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0500 목록
	 * @exception Exception
	 */
    //@Cacheable(cacheName = "binsnCache") 
    public List selectBass0500List(SysComSearchVO searchVO) throws Exception {
        return list("sysIfBass0500DAO.selectBass0500List_D", searchVO);
    }
    public List selectMultiBass0500List(SysComSearchVO searchVO) throws Exception {
        return list("sysIfBass0500DAO.selectMultiBass0500List_D", searchVO);
    }
    

    /**
	 * BASS0500 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0500 총 갯수
	 * @exception
	 */
    //@Cacheable(cacheName = "binsnCache") 
    public int selectBass0500ListTotCnt(SysComSearchVO   sysIfSrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysIfBass0500DAO.selectBass0500ListTotCnt_S", sysIfSrhVo);
    }
    
    public int selectMultiBass0500ListTotCnt(SysComSearchVO  sysIfSrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysIfBass0500DAO.selectMultiBass0500ListTotCnt_S", sysIfSrhVo);
    }
    
    
    /**
     * BASS0500 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0500 목록
     * @exception Exception
     */
    //@Cacheable(cacheName = "binsnCache") 
    public List selectBass0500ToPayr5300List(SysComSearchVO searchVO) throws Exception {
        return list("sysIfBass0500DAO.selectBass0500ToPayr5300List_D", searchVO);
    }

    /**
     * BASS0500 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0500 총 갯수
     * @exception
     */
    //@Cacheable(cacheName = "binsnCache") 
    public int selectBass0500ToPayr5300ListTotCnt(SysComSearchVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysIfBass0500DAO.selectBass0500ToPayr5300ListTotCnt_S", searchVO);
    }
    
    
    

}
