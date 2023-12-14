package com.app.smrmf.infc.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0100SrhVO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0100DAO.java
 * @Description : Bass0100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.07.01
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgBass0100DAO")
public class InfcPkgBass0100DAO extends EgovAbstractDAO {

	/**
	 * BASS0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 InfcBass0100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertBass0100(InfcPkgBass0100VO vo) throws Exception {
        return (String)insert("infcPkgBass0100DAO.insertBass0100_S", vo);
    }

    /**
	 * BASS0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 InfcBass0100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateBass0100(InfcPkgBass0100VO vo) throws Exception {
        update("infcPkgBass0100DAO.updateBass0100_S", vo);
    }

    /**
	 * BASS0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 InfcBass0100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBass0100(InfcPkgBass0100VO vo) throws Exception {
        delete("infcPkgBass0100DAO.deleteBass0100_S", vo);
    }

    /**
	 * BASS0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 InfcBass0100VO
	 * @return 조회한 BASS0100
	 * @exception Exception
	 */
    public InfcPkgBass0100VO selectBass0100(InfcPkgBass0100VO vo) throws Exception {
        return (InfcPkgBass0100VO) selectByPk("infcPkgBass0100DAO.selectBass0100_S", vo);
    }

    /**
	 * BASS0100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0100 목록
	 * @exception Exception
	 */
    public List<?> selectBass0100List(InfcPkgBass0100SrhVO searchVO) throws Exception {
        return list("infcPkgBass0100DAO.selectBass0100List_D", searchVO);
    }

    /**
	 * BASS0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0100 총 갯수
	 * @exception
	 */
    public int selectBass0100ListTotCnt(InfcPkgBass0100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgBass0100DAO.selectBass0100ListTotCnt_S", searchVO);
    }

}
