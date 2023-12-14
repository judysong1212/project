package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161080_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe166030Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe166030_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye166030_2021_DAO.java
 * @Description : Ye166030 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe166030_2021_DAO")
public class InfcPkgYe166030_2021_DAO extends EgovAbstractDAO {

	
	
	//실손보험금 
	@Transactional
    public String PdfYeta6200_B201Y_YE166030_Insert(InfcPkgYe166030_2021_VO infcPkgYe166030Vo) throws Exception {
        return (String)insert("infcPkgYe166030_2021_DAO.PdfYeta6200_B201Y_YE166030_Insert_S", infcPkgYe166030Vo);
    }
	
	
	@Transactional
    public String PdfYeta6200_B201Y_YE166030_Delete(InfcPkgYe166030_2021_VO infcPkgYe166030Vo) throws Exception {
           delete("infcPkgYe166030_2021_DAO.PdfYeta6200_B201Y_YE166030_Delete_S", infcPkgYe166030Vo);
           
           return "";
    }
	
	
	//A_실손보험금지급명세
	@Transactional
    public String incTaxDeducDec_nts_Yeta2021_Ye166030_Insert(InfcPkgYe166030_2021_VO  infcPkgYe166030Vo) throws Exception {
        return (String)insert("infcPkgYe166030_2021_DAO.incTaxDeducDec_nts_Yeta2021_Ye166030_Insert_S", infcPkgYe166030Vo);
    }
	
	 
	/**
	 * YE166030?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye166030VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe166030(InfcPkgYe166030_2021_VO vo) throws Exception {
        return (String)insert("infcPkgYe166030_2021_DAO.insertYe166030_S", vo);
    }

    /**
	 * YE166030?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye166030VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe166030(InfcPkgYe166030_2021_VO vo) throws Exception {
        update("infcPkgYe166030_2021_DAO.updateYe166030_S", vo);
    }

    /**
	 * YE166030?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye166030VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe166030(InfcPkgYe166030_2021_VO vo) throws Exception {
        delete("infcPkgYe166030_2021_DAO.deleteYe166030_S", vo);
    }

    /**
	 * YE166030?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye166030VO
	 * @return 조회?�� YE166030
	 * @exception Exception
	 */
    public InfcPkgYe166030_2021_VO selectYe166030(InfcPkgYe166030_2021_VO vo) throws Exception {
        return (InfcPkgYe166030_2021_VO) selectByPk("infcPkgYe166030_2021_DAO.selectYe166030_S", vo);
    }

    /**
	 * YE166030 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE166030 목록
	 * @exception Exception
	 */
    public List<?> selectYe166030List(InfcPkgYe166030Srh_2021_VO searchVO) throws Exception {
        return list("infcPkgYe166030_2021_DAO.selectYe166030List_D", searchVO);
    }

    /**
	 * YE166030 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE166030 �? �??��
	 * @exception
	 */
    public int selectYe166030ListTotCnt(InfcPkgYe166030Srh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe166030_2021_DAO.selectYe166030ListTotCnt_S", searchVO);
    }

}
