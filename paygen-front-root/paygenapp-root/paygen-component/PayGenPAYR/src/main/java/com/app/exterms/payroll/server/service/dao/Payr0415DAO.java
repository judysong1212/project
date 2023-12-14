package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0415SrhVO;
import com.app.exterms.payroll.server.vo.Payr0415VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Payr0415DAO.java
 * @Description : Payr0415 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2014.07.31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0415DAO")
public class Payr0415DAO extends EgovAbstractDAO {
 
	/**
	 * PAYR0415을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0415VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0415(Payr0415VO vo) throws Exception {
        return (String)insert("payr0415DAO.insertPayr0415_S", vo);
    }

    /**
	 * PAYR0415을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0415VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0415Copy(Payr0415VO vo) throws Exception {
        return (String)insert("payr0415DAO.insertPayr0415Copy_S", vo);
    }
    
    /**
	 * PAYR0415을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0415VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0415(Payr0415VO vo) throws Exception {
        update("payr0415DAO.updatePayr0415_S", vo);
    }

    /**
	 * PAYR0415을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0415VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0415(Payr0415VO vo) throws Exception {
        delete("payr0415DAO.deletePayr0415_S", vo);
    }
    
    
    /**
     * PAYR0415을 삭제한다.(이관)
     * @param vo - 삭제할 정보가 담긴 Payr0415VO
     * @return void형 
     * @exception Exception
     */
    @Transactional
    public void deleteBfToNewPayr0415(Payr0415VO vo) throws Exception {
        delete("payr0415DAO.deleteBfToNewPayr0415_S", vo);
    }
     
  

    /**
	 * PAYR0415을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0415VO
	 * @return 조회한 PAYR0415
	 * @exception Exception
	 */
    public Payr0415VO selectPayr0415(Payr0415VO vo) throws Exception {
        return (Payr0415VO) selectByPk("payr0415DAO.selectPayr0415_S", vo);
    }

    /**
	 * PAYR0415 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0415 목록
	 * @exception Exception
	 */
    public List selectPayr0415List(Payr0415SrhVO searchVO) throws Exception {
        return list("payr0415DAO.selectPayr0415List_D", searchVO);
    }

    /**
	 * PAYR0415 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0415 총 갯수
	 * @exception
	 */
    public int selectPayr0415ListTotCnt(Payr0415SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0415DAO.selectPayr0415ListTotCnt_S", searchVO);
    }
    
    /**
	 * PAYR0415 총 갯수를 조회한다.
	 * 조회 시 PAYR_MANG_DEPT_CD가 payr0410에 있는지 판단
	 * 판단하여 있으면 조회시 PAYR_MANG_DEPT_CD 파라미터를 넘기고
	 * 없으면 넘기지 않는다.
	 * ( 데이터 삭제 후 직종세 생성시 payr0410에 데이터가 없으므로 조회되지 않는 문제를 처리하기 위해)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0415 총 갯수
	 * @exception
	 */
    public int selectPayr0415Check(Payr0415SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0415DAO.selectPayr0415Check", searchVO);
    }
    
    /**
	 * PAYR0415 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0415 목록
	 * @exception Exception
	 */
    public List selectPayr0415PayYrList(Payr0415SrhVO searchVO) throws Exception {
        return list("payr0415DAO.selectPayr0415PayYrList_D", searchVO);
    }

    /**
	 * PAYR0415 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0415 총 갯수
	 * @exception
	 */
    public int selectPayr0415PayYrListTotCnt(Payr0415SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0415DAO.selectPayr0415PayYrListTotCnt_S", searchVO);
    }
    
    
    

}
