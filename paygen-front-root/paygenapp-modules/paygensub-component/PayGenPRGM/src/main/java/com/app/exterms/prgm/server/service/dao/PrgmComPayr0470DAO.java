package com.app.exterms.prgm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.prgm.server.vo.PrgmComPayr0470SrhVO;
import com.app.exterms.prgm.server.vo.PrgmComPayr0470VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PrgmComPayr0470DAO.java
 * @Description : PrgmComPayr0470 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PrgmComPayr0470DAO")
public class PrgmComPayr0470DAO extends EgovAbstractDAO {

	/**
	 * PAYR0470을 등록한다.
	 * @param vo - 등록할 정보가 담긴 PrgmComPayr0470VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPrgmComPayr0470(PrgmComPayr0470VO vo) throws Exception {
        return (String)insert("prgmComPayr0470DAO.insertPrgmComPayr0470_S", vo);
    }

    /**
	 * PAYR0470을 수정한다.
	 * @param vo - 수정할 정보가 담긴 PrgmComPayr0470VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePrgmComPayr0470(PrgmComPayr0470VO vo) throws Exception {
        update("prgmComPayr0470DAO.updatePrgmComPayr0470_S", vo);
    }

    /**
	 * PAYR0470을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 PrgmComPayr0470VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePrgmComPayr0470(PrgmComPayr0470VO vo) throws Exception {
        delete("prgmComPayr0470DAO.deletePrgmComPayr0470_S", vo);
    }

    /**
	 * PAYR0470을 조회한다.
	 * @param vo - 조회할 정보가 담긴 PrgmComPayr0470VO
	 * @return 조회한 PAYR0470
	 * @exception Exception
	 */
    public PrgmComPayr0470VO selectPrgmComPayr0470(PrgmComPayr0470VO vo) throws Exception {
        return (PrgmComPayr0470VO) selectByPk("prgmComPayr0470DAO.selectPrgmComPayr0470_S", vo);
    }

    /**
	 * PAYR0470 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0470 목록
	 * @exception Exception
	 */
    public List selectPrgmComPayr0470List(PrgmComPayr0470SrhVO searchVO) throws Exception {
        return list("prgmComPayr0470DAO.selectPrgmComPayr0470List_D", searchVO);
    }

    /**
	 * PAYR0470 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0470 총 갯수
	 * @exception
	 */
    public int selectPrgmComPayr0470ListTotCnt(PrgmComPayr0470SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmComPayr0470DAO.selectPrgmComPayr0470ListTotCnt_S", searchVO);
    }
    
//    /**
//   	 * PAYR0470 목록을 조회한다.
//   	 * @param searchMap - 조회할 정보가 담긴 Map
//   	 * @return PAYR0470 목록
//   	 * @exception Exception
//   	 */
//       public List selectPrgmComPayr0470ToPayr4450List(PrgmComPayr0470SrhVO searchVO) throws Exception {
//           return list("prgmComPayr0470DAO.selectPrgmComPayr0470ToPayr4450List_D", searchVO);
//       }
//
//       /**
//   	 * PAYR0470 총 갯수를 조회한다.
//   	 * @param searchMap - 조회할 정보가 담긴 Map
//   	 * @return PAYR0470 총 갯수
//   	 * @exception
//   	 */
//       public int selectPrgmComPayr0470ToPayr4450ListTotCnt(PrgmComPayr0470SrhVO searchVO) {
//           return (Integer)getSqlMapClientTemplate().queryForObject("prgmComPayr0470DAO.selectPrgmComPayr0470ToPayr4450ListTotCnt_S", searchVO);
//       }

}
