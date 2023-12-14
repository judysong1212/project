package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr2510SrhVO;
import com.app.exterms.insurance.server.vo.Insr2510VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr2510DAO.java
 * @Description : Insr2510 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr2510DAO")
public class Insr2510DAO extends EgovAbstractDAO {

	/**
	 * INSR2510을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr2510VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr2510(Insr2510VO vo) throws Exception {
        return (String)insert("insr2510DAO.insertInsr2510_S", vo);
    }

    /**
	 * INSR2510을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr2510VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr2510(Insr2510VO vo) throws Exception {
        update("insr2510DAO.updateInsr2510_S", vo);
    }

    /**
	 * INSR2510을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr2510VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr2510(Insr2510VO vo) throws Exception {
        delete("insr2510DAO.deleteInsr2510_S", vo);
    }

    /**
	 * INSR2510을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr2510VO
	 * @return 조회한 INSR2510
	 * @exception Exception
	 */
    public Insr2510VO selectInsr2510(Insr2510VO vo) throws Exception {
        return (Insr2510VO) selectByPk("insr2510DAO.selectInsr2510_S", vo);
    }

    /**
	 * INSR2510 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR2510 목록
	 * @exception Exception
	 */
    public List<?> selectInsr2510List(Insr2510SrhVO searchVO) throws Exception {
        return list("insr2510DAO.selectInsr2510List_D", searchVO);
    }

    /**
	 * INSR2510 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR2510 총 갯수
	 * @exception
	 */
    public int selectInsr2510ListTotCnt(Insr2510SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr2510DAO.selectInsr2510ListTotCnt_S", searchVO);
    }

}
