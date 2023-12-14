package com.app.exterms.prgm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.prgm.server.vo.PrgmComBass0150SrhVO;
import com.app.exterms.prgm.server.vo.PrgmComBass0150VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0150DAO.java
 * @Description : Bass0150 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PrgmComBass0150DAO")
public class PrgmComBass0150DAO extends EgovAbstractDAO {

	/**
	 * BASS0150을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0150VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBass0150(PrgmComBass0150VO vo) throws Exception {
        return (String)insert("bass0150DAO.insertBass0150_S", vo);
    }

    /**
	 * BASS0150을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0150VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBass0150(PrgmComBass0150VO vo) throws Exception {
        update("bass0150DAO.updateBass0150_S", vo);
    }

    /**
	 * BASS0150을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0150VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBass0150(PrgmComBass0150VO vo) throws Exception {
        delete("bass0150DAO.deleteBass0150_S", vo);
    }

    /**
	 * BASS0150을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0150VO
	 * @return 조회한 BASS0150
	 * @exception Exception
	 */
    
    public PrgmComBass0150VO selectBass0150(PrgmComBass0150VO vo) throws Exception {
        return (PrgmComBass0150VO) selectByPk("bass0150DAO.selectBass0150_S", vo);
    }

    /**
	 * BASS0150 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0150 목록
	 * @exception Exception
	 */
    //@Cacheable(cacheName = "msfcomCache")  
    public List selectBass0150List(PrgmComBass0150SrhVO searchVO) throws Exception {
        return list("prgmBass0150DAO.selectBass0150List_D", searchVO);
    }

    /**
	 * BASS0150 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0150 총 갯수
	 * @exception
	 */
   // @Cacheable(cacheName = "msfcomCache")  
    public int selectBass0150ListTotCnt(PrgmComBass0150SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmBass0150DAO.selectBass0150ListTotCnt_S", searchVO);
    }

}
