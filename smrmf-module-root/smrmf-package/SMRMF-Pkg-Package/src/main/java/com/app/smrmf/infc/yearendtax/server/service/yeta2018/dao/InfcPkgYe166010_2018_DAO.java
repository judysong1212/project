package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe166010Srh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe166010_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye166010_2018_DAO.java
 * @Description : Ye166010 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe166010_2018_DAO")
public class InfcPkgYe166010_2018_DAO extends EgovAbstractDAO {

	
	@Transactional
    public String fnYeta3100_YE166010_2018_CREATE_Insert(InfcPkgYe166010_2018_VO infcPkgYe166010Vo) throws Exception {
        return (String)insert("infcPkgYe166010_2018_DAO.fnYeta3100_YE166010_2018_CREATE_Insert_S", infcPkgYe166010Vo);
    }
	 
	 // 신용카드등소득공제명세
	@Transactional
    public String incTaxDeducDec_nts_Yeta2018_Ye166010_Insert(InfcPkgYe166010_2018_VO  infcPkgYe166010Vo) throws Exception {
        return (String)insert("infcPkgYe166010_2018_DAO.incTaxDeducDec_nts_Yeta2018_Ye166010_Insert_S", infcPkgYe166010Vo);
    }
	  
	/********************************************************************************************************
	 * 소득공제관리화면에서처리 하는부분 
	 ********************************************************************************************************/ 	
	@Transactional
    public String incDdcYeta2018_YE166010_2018_CREATE_Insert(InfcPkgYe166010_2018_VO infcPkgYe166010Vo) throws Exception {
        return (String)insert("infcPkgYe166010_2018_DAO.fnYeta3100_YE166010_2018_CREATE_Insert_S", infcPkgYe166010Vo);
    }
	
	@Transactional
    public int incDdcYeta2018_YE166010_2018_CREATE_Delete(InfcPkgYe166010_2018_VO vo) throws Exception {
        return delete("infcPkgYe166010_2018_DAO.fnYeta3100_YE166010_2018_CREATE_Delete_S", vo);
    }
	
	
	
		
	/**
	 * YE166010?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye166010VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe166010(InfcPkgYe166010_2018_VO vo) throws Exception {
        return (String)insert("infcPkgYe166010_2018_DAO.insertYe166010_S", vo);
    }

    /**
	 * YE166010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye166010VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe166010(InfcPkgYe166010_2018_VO vo) throws Exception {
        update("infcPkgYe166010_2018_DAO.updateYe166010_S", vo);
    }

    /**
	 * YE166010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye166010VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe166010(InfcPkgYe166010_2018_VO vo) throws Exception {
        delete("infcPkgYe166010_2018_DAO.deleteYe166010_S", vo);
    }

    /**
	 * YE166010?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye166010VO
	 * @return 조회?�� YE166010
	 * @exception Exception
	 */
    public InfcPkgYe166010_2018_VO selectYe166010(InfcPkgYe166010_2018_VO vo) throws Exception {
        return (InfcPkgYe166010_2018_VO) selectByPk("infcPkgYe166010_2018_DAO.selectYe166010_S", vo);
    }

    /**
	 * YE166010 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE166010 목록
	 * @exception Exception
	 */
    public List<?> selectYe166010List(InfcPkgYe166010Srh_2018_VO searchVO) throws Exception {
        return list("infcPkgYe166010_2018_DAO.selectYe166010List_D", searchVO);
    }

    /**
	 * YE166010 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE166010 �? �??��
	 * @exception
	 */
    public int selectYe166010ListTotCnt(InfcPkgYe166010Srh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe166010_2018_DAO.selectYe166010ListTotCnt_S", searchVO);
    }

}
