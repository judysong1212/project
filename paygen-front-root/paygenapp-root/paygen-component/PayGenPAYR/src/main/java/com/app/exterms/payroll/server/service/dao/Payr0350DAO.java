package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.payroll.server.vo.Payr0350SrhVO;
import com.app.exterms.payroll.server.vo.Payr0350VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0350DAO.java
 * @Description : Payr0350 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.09.22
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0350DAO")
public class Payr0350DAO extends EgovAbstractDAO {

	/**
	 * PAYR0350을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0350VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertPayr0350(Payr0350VO vo) throws Exception {
        return (String)insert("payr0350DAO.insertPayr0350_S", vo);
    }

    /**
	 * PAYR0350을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0350VO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePayr0350(Payr0350VO vo) throws Exception {
        update("payr0350DAO.updatePayr0350_S", vo);
    }

    /**
	 * PAYR0350을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0350VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePayr0350(Payr0350VO vo) throws Exception {
        delete("payr0350DAO.deletePayr0350_S", vo);
    }

    public void deletePayr4210ToPayr0350(Payr0350VO vo) throws Exception {
        delete("payr0350DAO.deletePayr4210ToPayr0350_S", vo);
    }
    
    /**
	 * PAYR0350을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0350VO
	 * @return 조회한 PAYR0350
	 * @exception Exception
	 */
    public Payr0350VO selectPayr0350(Payr0350VO vo) throws Exception {
        return (Payr0350VO) selectByPk("payr0350DAO.selectPayr0350_S", vo);
    }

    /**
	 * PAYR0350 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0350 목록
	 * @exception Exception
	 */
    public List<?> selectPayr0350List(Payr0350SrhVO searchVO) throws Exception {
        return list("payr0350DAO.selectPayr0350List_D", searchVO);
    }

    /**
	 * PAYR0350 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0350 총 갯수
	 * @exception
	 */
    public int selectPayr0350ListTotCnt(Payr0350SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0350DAO.selectPayr0350ListTotCnt_S", searchVO);
    }
    

    /**
	 * PAYR0350 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0350 목록
	 * @exception Exception
	 */
    public List<?> selectPayr4210ToPayr0350List(Payr0350SrhVO searchVO) throws Exception {
        return list("payr0350DAO.selectPayr4210ToPayr0350List_D", searchVO);
    }

    /**
	 * PAYR0350 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0350 총 갯수
	 * @exception
	 */
    public int selectPayr4210ToPayr0350ListTotCnt(Payr0350SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0350DAO.selectPayr4210ToPayr0350ListTotCnt_S", searchVO);
    }
    
    /**
     * payr4210 화면 엑셀저장 쿼리 호출 
     * @param payr0350SrhVO
     * @return
     * @throws Exception
     */
    public List  selectXlsPayr4210List(Payr0350SrhVO   payr0350SrhVO) throws Exception {
    	  return list("payr0350DAO.selectXlsPayr4210List_D", payr0350SrhVO); 
    	 
      } 
    
    

    /**
	 * PAYR0350 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0350 목록
	 * @exception Exception
	 */
    public List<?> selectPayr4220ToPayr0350TgtList(Payr0350SrhVO searchVO) throws Exception {
        return list("payr0350DAO.selectPayr4220ToPayr0350TgtList_D", searchVO);
    }

    /**
	 * PAYR0350 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0350 총 갯수
	 * @exception
	 */
    public int selectPayr4220ToPayr0350TgtListTotCnt(Payr0350SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0350DAO.selectPayr4220ToPayr0350TgtListTotCnt_S", searchVO);
    }
    
    /**
	 * PAYR0350 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0350 목록
	 * @exception Exception
	 */
    public List<?> selectPayr4220ToPayr0350SumList(Payr0350SrhVO searchVO) throws Exception {
        return list("payr0350DAO.selectPayr4220ToPayr0350SumList_D", searchVO);
    }

    /**
	 * PAYR0350 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0350 총 갯수
	 * @exception
	 */
    public int selectPayr4220ToPayr0350SumListTotCnt(Payr0350SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0350DAO.selectPayr4220ToPayr0350SumListTotCnt_S", searchVO);
    }
      

}
