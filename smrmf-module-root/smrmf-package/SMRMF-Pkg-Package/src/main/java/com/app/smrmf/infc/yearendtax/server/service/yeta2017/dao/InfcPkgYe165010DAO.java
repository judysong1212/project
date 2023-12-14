package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165010SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165010VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye165010DAO.java
 * @Description : Ye165010 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe165010DAO")
public class InfcPkgYe165010DAO extends EgovAbstractDAO {

	@Transactional
    public String PdfYeta2200_L102Y_YE165010_Delete(InfcPkgYe165010VO infcPkgYe165010Vo) throws Exception {
           delete("infcPkgYe165010DAO.PdfYeta2200_L102Y_YE165010_Delete_S", infcPkgYe165010Vo);
           
           return "";
    }	
	@Transactional
    public String PdfYeta2200_L102Y_YE165010_Insert(InfcPkgYe165010VO infcPkgYe165010Vo) throws Exception {
        return (String)insert("infcPkgYe165010DAO.PdfYeta2200_L102Y_YE165010_Insert_S", infcPkgYe165010Vo);
    }
	
	// I_해당연도기부금명세
	@Transactional
    public String incTaxDeducDec_nts_Yeta2017_Ye165010_Insert(InfcPkgYe165010VO infcPkgYe165010Vo) throws Exception {
        return (String)insert("infcPkgYe165010DAO.incTaxDeducDec_nts_Yeta2017_Ye165010_Insert_S", infcPkgYe165010Vo);
    }
	
	
	
	// 급여 노조회비 기부금 반영 건
	@Transactional
    public int fnYeta2100_YE165010_2017_PAYR_CREATE_DELETE(InfcPkgYe165010VO infcPkgYe165010Vo) throws Exception {
		return  delete("infcPkgYe165010DAO.fnYeta2100_YE165010_2017_PAYR_Delete_S", infcPkgYe165010Vo);
    }	
	@Transactional
    public String fnYeta2100_YE165010_2017_PAYR_CREATE_INSERT(InfcPkgYe165010VO infcPkgYe165010Vo) throws Exception {
        return (String)insert("infcPkgYe165010DAO.fnYeta2100_YE165010_2017_PAYR_Insert_S", infcPkgYe165010Vo);
    }
	
	 
 
	/**
	 * YE165010?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye165010VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe165010(InfcPkgYe165010VO vo) throws Exception {
        return (String)insert("infcPkgYe165010DAO.insertYe165010_S", vo);
    }

    /**
	 * YE165010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165010VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe165010(InfcPkgYe165010VO vo) throws Exception {
        update("infcPkgYe165010DAO.updateYe165010_S", vo);
    }

    /**
	 * YE165010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165010VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe165010(InfcPkgYe165010VO vo) throws Exception {
        delete("infcPkgYe165010DAO.deleteYe165010_S", vo);
    }

    /**
	 * YE165010?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye165010VO
	 * @return 조회?�� YE165010
	 * @exception Exception
	 */
    public InfcPkgYe165010VO selectYe165010(InfcPkgYe165010VO vo) throws Exception {
        return (InfcPkgYe165010VO) selectByPk("infcPkgYe165010DAO.selectYe165010_S", vo);
    }

    /**
	 * YE165010 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165010 목록
	 * @exception Exception
	 */
    public List<?> selectYe165010List(InfcPkgYe165010SrhVO searchVO) throws Exception {
        return list("infcPkgYe165010DAO.selectYe165010List_D", searchVO);
    }

    /**
	 * YE165010 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165010 �? �??��
	 * @exception
	 */
    public int selectYe165010ListTotCnt(InfcPkgYe165010SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe165010DAO.selectYe165010ListTotCnt_S", searchVO);
    }

}
