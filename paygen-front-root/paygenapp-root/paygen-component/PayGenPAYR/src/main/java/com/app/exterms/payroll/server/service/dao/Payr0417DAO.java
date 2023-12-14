package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.payroll.server.vo.Payr0417SrhVO;
import com.app.exterms.payroll.server.vo.Payr0417VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0417DAO.java
 * @Description : Payr0417 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.12.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0417DAO")
public class Payr0417DAO extends EgovAbstractDAO {

	/**
	 * PAYR0417?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Payr0417VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPayr0417(Payr0417VO vo) throws Exception {
        return (String)insert("payr0417DAO.insertPayr0417_S", vo);
    }

    /**
	 * PAYR0417?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Payr0417VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePayr0417(Payr0417VO vo) throws Exception {
        update("payr0417DAO.updatePayr0417_S", vo);
    }

    /**
	 * PAYR0417?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Payr0417VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePayr0417(Payr0417VO vo) throws Exception {
        delete("payr0417DAO.deletePayr0417_S", vo);
    }
    
    public void deletePayr0417_D(Payr0417VO vo) throws Exception {
        delete("payr0417DAO.deletePayr0417", vo);
    }
    
    /** 직종세지급공제항목일괄생성 삭제처리**/
    public void pP525002ToDeletePayr0417_D(Payr0417VO vo) throws Exception {
        delete("payr0417DAO.pP525002ToDeletePayr0417", vo);
    }  

    /**
	 * PAYR0417?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Payr0417VO
	 * @return 조회?�� PAYR0417
	 * @exception Exception
	 */
    public Payr0417VO selectPayr0417(Payr0417VO vo) throws Exception {
        return (Payr0417VO) selectByPk("payr0417DAO.selectPayr0417_S", vo);
    }

    /**
	 * PAYR0417 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PAYR0417 목록
	 * @exception Exception
	 */
    public List<?> selectPayr0417List(Payr0417SrhVO searchVO) throws Exception {
        return list("payr0417DAO.selectPayr0417List_D", searchVO);
    }

    /**
	 * PAYR0417 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PAYR0417 �? �??��
	 * @exception
	 */
    public int selectPayr0417ListTotCnt(Payr0417SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0417DAO.selectPayr0417ListTotCnt_S", searchVO);
    }
    
    public List<?> selectPayrP525003ToPayr0417List(Payr0417SrhVO searchVO) throws Exception {
    	return list("payr0417DAO.selectPayrP525003ToPayr0417List_D", searchVO);
    }
    
    public int selectPayrP525003ToPayr0417ListTotCnt(Payr0417SrhVO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("payr0417DAO.selectPayrP525003ToPayr0417ListTotCnt_S", searchVO);
    }
    
    public String insertPayrP525003ToPayr0417(Payr0417VO vo) throws Exception {
        return (String)insert("payr0417DAO.insertPayrP525003ToPayr0417_S", vo);
    }

}
