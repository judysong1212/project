package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr6100SrhVO;
import com.app.exterms.insurance.server.vo.Insr6100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr6100DAO.java
 * @Description : Insr6100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr6100DAO")
public class Insr6100DAO extends EgovAbstractDAO {

	/**
	 * INSR6100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr6100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr6100(Insr6100VO vo) throws Exception {
        return (String)insert("insr6100DAO.insertInsr6100_S", vo);
    }

    /**
	 * INSR6100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr6100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr6100(Insr6100VO vo) throws Exception {
        update("insr6100DAO.updateInsr6100_S", vo);
    }

    /**
	 * INSR6100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr6100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr6100(Insr6100VO vo) throws Exception {
        delete("insr6100DAO.deleteInsr6100_S", vo);
    }

    /**
	 * INSR6100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr6100VO
	 * @return 조회한 INSR6100
	 * @exception Exception
	 */
    public Insr6100VO selectInsr6100(Insr6100VO vo) throws Exception {
        return (Insr6100VO) selectByPk("insr6100DAO.selectInsr6100_S", vo);
    }

    /**
	 * INSR6100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR6100 목록
	 * @exception Exception
	 */
    public List<?> selectInsr6100List(Insr6100SrhVO searchVO) throws Exception {
        return list("insr6100DAO.selectInsr6100List_D", searchVO);
    }

    /**
	 * INSR6100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR6100 총 갯수
	 * @exception
	 */
    public int selectInsr6100ListTotCnt(Insr6100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr6100DAO.selectInsr6100ListTotCnt_S", searchVO);
    }

}
