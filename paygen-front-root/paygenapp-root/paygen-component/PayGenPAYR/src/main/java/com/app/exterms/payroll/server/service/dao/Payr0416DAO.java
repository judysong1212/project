package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.payroll.server.vo.Payr0416SrhVO;
import com.app.exterms.payroll.server.vo.Payr0416VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0416DAO.java
 * @Description : Payr0416 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.12.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0416DAO")
public class Payr0416DAO extends EgovAbstractDAO {

	 
    public String insertPayr0416(Payr0416VO vo) throws Exception {
        return (String)insert("payr0416DAO.insertPayr0416_S", vo);
    }
    
    /** 직종세 이관 **/
    public String insertPayr0416Copy(Payr0416VO vo) throws Exception {
        return (String)insert("payr0416DAO.insertPayr0416_COPY", vo);
    }
    
    

   
    public void updatePayr0416(Payr0416VO vo) throws Exception {
        update("payr0416DAO.updatePayr0416_S", vo);
    }

     
    public void deletePayr0416(Payr0416VO vo) throws Exception {
        delete("payr0416DAO.deletePayr0416_S", vo);
    }

     
    public Payr0416VO selectPayr0416(Payr0416VO vo) throws Exception {
        return (Payr0416VO) selectByPk("payr0416DAO.selectPayr0416_S", vo);
    }

   
    public List<?> selectPayr0416List(Payr0416SrhVO searchVO) throws Exception {
        return list("payr0416DAO.selectPayr0416List_D", searchVO);
    }
    
    /** 이전년도 직종세 조회**/
    public List<?> selectBeforePayr0416List(Payr0416SrhVO searchVO) throws Exception {
        return list("payr0416DAO.selectBeforePayr0416List_D", searchVO);
    }
    public int selectBeforePayr0416ListTotCnt(Payr0416SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0416DAO.selectBeforePayr0416ListTotCnt_S", searchVO);
    }
    
    
    
     
    public List<?> selectXlsPayr0416List(Payr0416SrhVO searchVO) throws Exception {
        return list("payr0416DAO.selectXlsPayr0416List", searchVO);
    }

    
    public int selectPayr0416ListTotCnt(Payr0416SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0416DAO.selectPayr0416ListTotCnt_S", searchVO);
    }
    
    
    /**
     * 직종세지급항목설정일괄생성
     * */
    public List selectPayr525002ToPayr0416List(Payr0416SrhVO searchVO) throws Exception {
        return list("payr0416DAO.selectPayr5250002ToPayr0416List_D", searchVO);
    }
    /**
     * 직종세지급항목설정일괄생성
     * */
    public int selectPayr525002ToPayr0416ListTotCnt(Payr0416SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0416DAO.selectPayr5250002ToPayr0416ListTotCnt_S", searchVO);
    }
    
    
    /**
	 * PAYR0416 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0416 목록
	 * @exception Exception
	 */
    public List selectPayr0416PayYrList(Payr0416SrhVO searchVO) throws Exception {
        return list("payr0416DAO.selectPayr0416PayYrList_D", searchVO);
    }

    /**
	 * PAYR0416 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0416 총 갯수
	 * @exception
	 */
    public int selectPayr0416PayYrListTotCnt(Payr0416SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0416DAO.selectPayr0416PayYrListTotCnt_S", searchVO);
    }
    
    /**
	 * PAYR0416 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0416 목록
	 * @exception Exception
	 */
    public Payr0416VO selectPayrP525003ToPayr0416PayYrList(Payr0416SrhVO searchVO) throws Exception {
        return (Payr0416VO) selectByPk("payr0416DAO.selectPayrP525003ToPayr0416List_D", searchVO);
    }
    

}
