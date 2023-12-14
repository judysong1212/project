package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr6500SrhVO;
import com.app.exterms.insurance.server.vo.Insr6500VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr6500DAO.java
 * @Description : Insr6500 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr6500DAO")
public class Insr6500DAO extends EgovAbstractDAO {

	/**
	 * INSR6500을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr6500VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr6500(Insr6500VO vo) throws Exception {
        return (String)insert("insr6500DAO.insertInsr6500_S", vo);
    }

    /**
	 * INSR6500을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr6500VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr6500(Insr6500VO vo) throws Exception {
        update("insr6500DAO.updateInsr6500_S", vo);
    }

    /**
	 * INSR6500을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr6500VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr6500(Insr6500VO vo) throws Exception {
        delete("insr6500DAO.deleteInsr6500_S", vo);
    }

    /**
	 * INSR6500을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr6500VO
	 * @return 조회한 INSR6500
	 * @exception Exception
	 */
    public Insr6500VO selectInsr6500(Insr6500VO vo) throws Exception {
        return (Insr6500VO) selectByPk("insr6500DAO.selectInsr6500_S", vo);
    }

    /**
	 * INSR6500 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR6500 목록
	 * @exception Exception
	 */
    public List<?> selectInsr6500List(Insr6500SrhVO searchVO) throws Exception {
        return list("insr6500DAO.selectInsr6500List_D", searchVO);
    }

    /**
	 * INSR6500 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR6500 총 갯수
	 * @exception
	 */
    public int selectInsr6500ListTotCnt(Insr6500SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr6500DAO.selectInsr6500ListTotCnt_S", searchVO);
    }

}
