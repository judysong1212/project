package com.app.exterms.prgm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.prgm.server.vo.PrgmComBass0200VO;
import com.app.exterms.prgm.server.vo.PrgmComSearchVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0200DAO.java
 * @Description : Bass0200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PrgmComBass0200DAO")
public class PrgmComBass0200DAO extends EgovAbstractDAO {

	/**
	 * BASS0200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBass0200(PrgmComBass0200VO vo) throws Exception {
        return (String)insert("prgmComBass0200DAO.insertBass0200_S", vo);
    }

    /**
	 * BASS0200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0200VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBass0200(PrgmComBass0200VO vo) throws Exception {
        update("prgmComBass0200DAO.updateBass0200_S", vo);
    }

    /**
	 * BASS0200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0200VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBass0200(PrgmComBass0200VO vo) throws Exception {
        delete("prgmComBass0200DAO.deleteBass0200_S", vo);
    }

    /**
	 * BASS0200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0200VO
	 * @return 조회한 BASS0200
	 * @exception Exception
	 */
    public PrgmComBass0200VO selectBass0200(PrgmComBass0200VO vo) throws Exception {
        return (PrgmComBass0200VO) selectByPk("prgmComBass0200DAO.selectBass0200_S", vo);
    }

    /**
	 * BASS0200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0200 목록
	 * @exception Exception
	 */
    public List selectBass0200List(PrgmComSearchVO searchVO) throws Exception {
        return list("prgmComBass0200DAO.selectBass0200List_D", searchVO);
    }

    /**
	 * BASS0200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0200 총 갯수
	 * @exception
	 */
    public int selectBass0200ListTotCnt(PrgmComSearchVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmComBass0200DAO.selectBass0200ListTotCnt_S", searchVO);
    }

}
