package com.app.exterms.prgm.server.service.dao;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.app.exterms.prgm.server.vo.PrgmComBass0300VO;
import com.app.exterms.prgm.server.vo.PrgmComSearchVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
//import com.googlecode.ehcache.annotations.Cacheable;

/**
 * @Class Name : Bass0300DAO.java
 * @Description : Bass0300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PrgmComBass0300DAO")
public class PrgmComBass0300DAO extends EgovAbstractDAO  {

	  
    /**
	 * BASS0300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0300VO
	 * @return 조회한 BASS0300
	 * @exception Exception
	 */
 
    public PrgmComBass0300VO selectBass0300(PrgmComBass0300VO vo) throws Exception {
        return (PrgmComBass0300VO) selectByPk("prgmComBass0300DAO.selectBass0300_S", vo);
    }

    
    
    
    /**
	 * BASS0300 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0300 목록
	 * @exception Exception
	 * ,#searchVO.mangeItem01,#searchVO.mangeItem02,#searchVO.mangeItem03,#searchVO.mangeItem04,#searchVO.mangeItem05,#searchVO.mangeItem06,#searchVO.mangeItem07,#searchVO.mangeItem08,#searchVO.mangeItem09,#searchVO.mangeItem10
	 */
   @Cacheable(value = "msfcomCache", key="#searchVO.commKey")
    public List selectBass0300ComboList(PrgmComSearchVO searchVO) throws Exception {
        return list("prgmComBass0300DAO.selectBass0300List_D", searchVO);
    }
    

    /**
     * BASS0300 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0300 목록
     * @exception Exception
     */
   
    public List selectBass0300List(PrgmComSearchVO searchVO) throws Exception {
        return list("prgmComBass0300DAO.selectBass0300List_D", searchVO);
    }

    /**
	 * BASS0300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0300 총 갯수
	 * @exception
	 */ 
   
    
    public int selectBass0300ListTotCnt(PrgmComSearchVO searchVO) throws Exception {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmComBass0300DAO.selectBass0300ListTotCnt_S", searchVO);
    }

}
