package com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161080_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe166040Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe166040_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye166040_2022_DAO.java
 * @Description : Ye166040 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe166040_2022_DAO")
public class InfcPkgYe166040_2022_DAO extends EgovAbstractDAO {

	
	
	//벤처기업투자신탁
	@Transactional
    public String PdfYeta7200_Q101Y_YE166040_Insert(InfcPkgYe166040_2022_VO infcPkgYe166040Vo) throws Exception {
        return (String)insert("infcPkgYe166040_2022_DAO.PdfYeta7200_Q101Y_YE166040_Insert_S", infcPkgYe166040Vo);
    }
	
	
	@Transactional
    public String PdfYeta7200_Q101Y_YE166040_Delete(InfcPkgYe166040_2022_VO infcPkgYe166040Vo) throws Exception {
           delete("infcPkgYe166040_2022_DAO.PdfYeta7200_Q101Y_YE166040_Delete_S", infcPkgYe166040Vo);
           
           return "";
    }
	
	
	@Transactional
    public String PdfYeta7200_Q201Y_YE166040_Delete(InfcPkgYe166040_2022_VO infcPkgYe166040Vo) throws Exception {
           delete("infcPkgYe166040_2022_DAO.PdfYeta7200_Q201Y_YE166040_Delete_S", infcPkgYe166040Vo);
           
           return "";
    }
	
	@Transactional
    public String PdfYeta7200_Q201Y_YE166040_Insert(InfcPkgYe166040_2022_VO infcPkgYe166040Vo) throws Exception {
        return (String)insert("infcPkgYe166040_2022_DAO.PdfYeta7200_Q201Y_YE166040_Insert_S", infcPkgYe166040Vo);
    }
	
	
	@Transactional
    public String PdfYeta7200_Q301Y_YE166040_Delete(InfcPkgYe166040_2022_VO infcPkgYe166040Vo) throws Exception {
           delete("infcPkgYe166040_2022_DAO.PdfYeta7200_Q301Y_YE166040_Delete_S", infcPkgYe166040Vo);
           
           return "";
    }
	
	@Transactional
    public String PdfYeta7200_Q301Y_YE166040_Insert(InfcPkgYe166040_2022_VO infcPkgYe166040Vo) throws Exception {
        return (String)insert("infcPkgYe166040_2022_DAO.PdfYeta7200_Q301Y_YE166040_Insert_S", infcPkgYe166040Vo);
    }
	
	
	
	
	
	
	//벤처기업투자신탁 지급명세
	@Transactional
    public String incTaxDeducDec_nts_Yeta2022_Ye166040_Insert(InfcPkgYe166040_2022_VO  infcPkgYe166040Vo) throws Exception {
        return (String)insert("infcPkgYe166040_2022_DAO.incTaxDeducDec_nts_Yeta2022_Ye166040_Insert_S", infcPkgYe166040Vo);
    }
	
	 
	/**
	 * YE166040?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye166040VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe166040(InfcPkgYe166040_2022_VO vo) throws Exception {
        return (String)insert("infcPkgYe166040_2022_DAO.insertYe166040_S", vo);
    }

    /**
	 * YE166040?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye166040VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe166040(InfcPkgYe166040_2022_VO vo) throws Exception {
        update("infcPkgYe166040_2022_DAO.updateYe166040_S", vo);
    }

    /**
	 * YE166040?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye166040VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe166040(InfcPkgYe166040_2022_VO vo) throws Exception {
        delete("infcPkgYe166040_2022_DAO.deleteYe166040_S", vo);
    }

    /**
	 * YE166040?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye166040VO
	 * @return 조회?�� YE166040
	 * @exception Exception
	 */
    public InfcPkgYe166040_2022_VO selectYe166040(InfcPkgYe166040_2022_VO vo) throws Exception {
        return (InfcPkgYe166040_2022_VO) selectByPk("infcPkgYe166040_2022_DAO.selectYe166040_S", vo);
    }

    /**
	 * YE166040 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE166040 목록
	 * @exception Exception
	 */
    public List<?> selectYe166040List(InfcPkgYe166040Srh_2022_VO searchVO) throws Exception {
        return list("infcPkgYe166040_2022_DAO.selectYe166040List_D", searchVO);
    }

    /**
	 * YE166040 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE166040 �? �??��
	 * @exception
	 */
    public int selectYe166040ListTotCnt(InfcPkgYe166040Srh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe166040_2022_DAO.selectYe166040ListTotCnt_S", searchVO);
    }

}
