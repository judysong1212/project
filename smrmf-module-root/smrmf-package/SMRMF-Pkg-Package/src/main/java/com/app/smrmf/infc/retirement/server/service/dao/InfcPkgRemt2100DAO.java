package com.app.smrmf.infc.retirement.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2100SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Remt2100DAO.java
 * @Description : Remt2100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgRemt2100DAO")
public class InfcPkgRemt2100DAO extends EgovAbstractDAO {

	/**
	 * REMT2100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt2100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRemt2100(InfcPkgRemt2100VO vo) throws Exception {
        return (String)insert("infcPkgRemt2100DAO.insertRemt2100_S", vo);
    }

    /**
	 * REMT2100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt2100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRemt2100(InfcPkgRemt2100VO vo) throws Exception {
        update("infcPkgRemt2100DAO.updateRemt2100_S", vo);
    }

    /**
	 * REMT2100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt2100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt2100(InfcPkgRemt2100VO vo) throws Exception {
        delete("infcPkgRemt2100DAO.deleteRemt2100_S", vo);
    }

    /**
	 * REMT2100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt2100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt0100CalcRemt2100(InfcPkgRemt2100VO vo) throws Exception {
        delete("infcPkgRemt2100DAO.deleteRemt0100CalcRemt2100_S", vo);
    }

    
    /**
	 * REMT2100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt2100VO
	 * @return 조회한 REMT2100
	 * @exception Exception
	 */
    public InfcPkgRemt2100VO selectRemt2100(InfcPkgRemt2100VO vo) throws Exception {
        return (InfcPkgRemt2100VO) selectByPk("infcPkgRemt2100DAO.selectRemt2100_S", vo);
    }

    /**
	 * REMT2100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2100 목록
	 * @exception Exception
	 */
    public List<?> selectRemt2100List(InfcPkgRemt2100SrhVO searchVO) throws Exception {
        return list("infcPkgRemt2100DAO.selectRemt2100List_D", searchVO);
    }

    /**
	 * REMT2100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2100 총 갯수
	 * @exception
	 */
    public int selectRemt2100ListTotCnt(InfcPkgRemt2100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgRemt2100DAO.selectRemt2100ListTotCnt_S", searchVO);
    }
    
    public int selectMarTotAmntDays(InfcPkgRemt2100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgRemt2100DAO.selectMarTotAmntDays_S", searchVO);
    }
    
    
    /**
	 * remt0100 화면에서 산정개월수 정보를 가지고 온다. REMT2100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2100 목록
	 * @exception Exception
	 */
    public List<?> selectRemt0100ToRemt2100List(InfcPkgRemt2100SrhVO searchVO) throws Exception {
        return list("infcPkgRemt2100DAO.selectRemt0100ToRemt2100List_D", searchVO);
    } 
    
}
