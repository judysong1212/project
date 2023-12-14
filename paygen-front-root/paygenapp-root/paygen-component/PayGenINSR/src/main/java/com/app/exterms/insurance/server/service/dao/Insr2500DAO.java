package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr2200SrhVO;
import com.app.exterms.insurance.server.vo.Insr2500SrhVO;
import com.app.exterms.insurance.server.vo.Insr2500VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr2500DAO.java
 * @Description : Insr2500 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr2500DAO")
public class Insr2500DAO extends EgovAbstractDAO {

	/**
	 * INSR2500을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr2500VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr2500(Insr2500VO vo) throws Exception {
        return (String)insert("insr2500DAO.insertInsr2500_S", vo);
    }

    /**
	 * INSR2500을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr2500VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr2500(Insr2500VO vo) throws Exception {
        update("insr2500DAO.updateInsr2500_S", vo);
    }

    /**
	 * INSR2500을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr2500VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr2500(Insr2500VO vo) throws Exception {
        delete("insr2500DAO.deleteInsr2500_S", vo);
    }

    /**
	 * INSR2500을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr2500VO
	 * @return 조회한 INSR2500
	 * @exception Exception
	 */
    public Insr2500VO selectInsr2500(Insr2500VO vo) throws Exception {
        return (Insr2500VO) selectByPk("insr2500DAO.selectInsr2500_S", vo);
    }

    /**
	 * INSR2500 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR2500 목록
	 * @exception Exception
	 */
    public List<?> selectInsr2500List(Insr2500SrhVO searchVO) throws Exception {
        return list("insr2500DAO.selectInsr2500List_D", searchVO);
    }

    /**
	 * INSR2500 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR2500 총 갯수
	 * @exception
	 */
    public int selectInsr2500ListTotCnt(Insr2500SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr2500DAO.selectInsr2500ListTotCnt_S", searchVO);
    }
    
    /**
     *  자격취득내역 엑셀저장 처리 루틴 호출 
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return INSR1200 목록
     * @exception Exception
     */
    public List  selectXlsInsr2500List(Insr2200SrhVO searchVO) throws Exception {
 	   return list("insr2500DAO.selectInsr2500ExcelList_D", searchVO);
    }
    
    /**
     *  자격취득내역 엑셀저장 처리 루틴 호출 
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return INSR1200 목록
     * @exception Exception
     */
    public List  selectXlsInsrP230006(Insr2200SrhVO searchVO) throws Exception {
 	   return list("insr2500DAO.selectInsrP230006Excel_D", searchVO);
    }

}
