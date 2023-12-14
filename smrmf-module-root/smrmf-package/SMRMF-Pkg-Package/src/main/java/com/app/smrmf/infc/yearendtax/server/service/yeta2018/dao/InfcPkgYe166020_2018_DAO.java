package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161070_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe166010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe166020Srh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe166020_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye166020_2018_DAO.java
 * @Description : Ye166020 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe166020_2018_DAO")
public class InfcPkgYe166020_2018_DAO extends EgovAbstractDAO {
 
	
	@Transactional
    public String fnYeta3100_YE166020_2018_CREATE_Insert01(InfcPkgYe166020_2018_VO infcPkgYe166020Vo) throws Exception {
        return (String)insert("infcPkgYe166020_2018_DAO.fnYeta3100_YE166020_2018_CREATE_Insert01_S", infcPkgYe166020Vo);
    }

	@Transactional
    public String fnYeta3100_YE166020_2018_CREATE_Insert02(InfcPkgYe166020_2018_VO infcPkgYe166020Vo) throws Exception {
        return (String)insert("infcPkgYe166020_2018_DAO.fnYeta3100_YE166020_2018_CREATE_Insert02_S", infcPkgYe166020Vo);
    }
	
	@Transactional
	 public String PdfYeta3200_G106Y_YE166020_Update(InfcPkgYe166020_2018_VO infcPkgYe166020Vo) throws Exception {
		update("infcPkgYe166020_2018_DAO.PdfYeta3200_G106Y_YE166020_Update_S", infcPkgYe166020Vo);
	        return "";
	    }
	@Transactional
	 public String PdfYeta3200_G107Y_YE166020_Update(InfcPkgYe166020_2018_VO infcPkgYe166020Vo) throws Exception {
		update("infcPkgYe166020_2018_DAO.PdfYeta3200_G107Y_YE166020_Update_S", infcPkgYe166020Vo);
	        return "";
	    }

	//신용카드등소득공제상세 
	@Transactional
    public String incTaxDeducDec_nts_Yeta2018_Ye166020_Insert(InfcPkgYe166020_2018_VO     infcPkgYe166020Vo) throws Exception {
        return (String)insert("infcPkgYe166020_2018_DAO.incTaxDeducDec_nts_Yeta2018_Ye166020_Insert_S", infcPkgYe166020Vo);
    }
	
	
	/********************************************************************************************************
	 * 소득공제관리화면에서처리 하는부분 
	 ********************************************************************************************************/ 
	@Transactional
	 public int incDdcYeta2018_G107Y_YE166020_Update(InfcPkgYe166020_2018_VO infcPkgYe166020Vo) throws Exception {
		return update("infcPkgYe166020_2018_DAO.PdfYeta3200_G107Y_YE166020_Update_S",
				infcPkgYe166020Vo);
	}
	
	@Transactional
    public int incDdcYeta2018_YE166020_2018_CREATE_Delete(InfcPkgYe166020_2018_VO vo) throws Exception {
        return delete("infcPkgYe166020_2018_DAO.fnYeta3100_YE166020_2018_CREATE_Delete_S", vo);
    } 
	
	
	@Transactional
    public int incDdcYeta2018_G107Y_YE166020_Delete(InfcPkgYe166020_2018_VO vo) throws Exception {
        return delete("infcPkgYe166020_2018_DAO.PdfYeta3200_G107Y_YE166020_Delete_S", vo);
    }
	
	@Transactional
    public String incDdcYeta2018_YE166020_2018_CREATE_Insert01(InfcPkgYe166020_2018_VO infcPkgYe166020Vo) throws Exception {
        return (String)insert("infcPkgYe166020_2018_DAO.fnYeta3100_YE166020_2018_CREATE_Insert01_S", infcPkgYe166020Vo);
    }

	@Transactional
    public String incDdcYeta2018_YE166020_2018_CREATE_Insert02(InfcPkgYe166020_2018_VO infcPkgYe166020Vo) throws Exception {
        return (String)insert("infcPkgYe166020_2018_DAO.fnYeta3100_YE166020_2018_CREATE_Insert02_S", infcPkgYe166020Vo);
    }
	
	
	/**
	 * YE166020?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye166020VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe166020(InfcPkgYe166020_2018_VO vo) throws Exception {
        return (String)insert("infcPkgYe166020_2018_DAO.insertYe166020_S", vo);
    }

    /**
	 * YE166020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye166020VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe166020(InfcPkgYe166020_2018_VO vo) throws Exception {
        update("infcPkgYe166020_2018_DAO.updateYe166020_S", vo);
    }

    /**
	 * YE166020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye166020VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe166020(InfcPkgYe166020_2018_VO vo) throws Exception {
        delete("infcPkgYe166020_2018_DAO.deleteYe166020_S", vo);
    }

    /**
	 * YE166020?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye166020VO
	 * @return 조회?�� YE166020
	 * @exception Exception
	 */
    public InfcPkgYe166020_2018_VO selectYe166020(InfcPkgYe166020_2018_VO vo) throws Exception {
        return (InfcPkgYe166020_2018_VO) selectByPk("infcPkgYe166020_2018_DAO.selectYe166020_S", vo);
    }

    /**
	 * YE166020 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE166020 목록
	 * @exception Exception
	 */
    public List<?> selectYe166020List(InfcPkgYe166020Srh_2018_VO searchVO) throws Exception {
        return list("infcPkgYe166020_2018_DAO.selectYe166020List_D", searchVO);
    }

    /**
	 * YE166020 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE166020 �? �??��
	 * @exception
	 */
    public int selectYe166020ListTotCnt(InfcPkgYe166020Srh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe166020_2018_DAO.selectYe166020ListTotCnt_S", searchVO);
    }

}
