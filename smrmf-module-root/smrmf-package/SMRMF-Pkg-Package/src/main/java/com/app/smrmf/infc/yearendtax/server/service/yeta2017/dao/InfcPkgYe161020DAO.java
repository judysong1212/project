package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161020SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161020VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161020DAO.java
 * @Description : Ye161020 DAO Class
 * @Modification Information
 *
 * @author DaEun, Bae
 * @since 2017.01.04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe161020DAO")
public class InfcPkgYe161020DAO extends EgovAbstractDAO {
	
	
	@Transactional
    public String fnYeta2100_YE161020_2017_CREATE_Insert(InfcPkgYe161020VO infcPkgYe161020Vo) throws Exception {
        return (String)insert("infcPkgYe161020DAO.fnYeta2100_YE161020_2017_CREATE_Insert_S", infcPkgYe161020Vo);
    }
	
	
	// A_인적소득공제기본 
	@Transactional
    public int incTaxDeducDec_nts_Yeta2017_Ye161020_update(InfcPkgYe161020VO infcPkgYe161020Vo) throws Exception {
        return  (int)update("infcPkgYe161020DAO.incTaxDeducDec_nts_Yeta2017_Ye161020_updatet_S", infcPkgYe161020Vo);
    }
	
	 
	
	/**
	 * YE161020???�록?�다.
	 * @param vo - ?�록???�보�??�긴 Ye161020VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertYe161020(InfcPkgYe161020VO vo) throws Exception {
        return (String)insert("infcPkgYe161020DAO.insertYe161020_S", vo);
    }

    /**
	 * YE161020???�정?�다.
	 * @param vo - ?�정???�보�??�긴 Ye161020VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe161020(InfcPkgYe161020VO vo) throws Exception {
        update("infcPkgYe161020DAO.updateYe161020_S", vo);
    }
    
    /**
     * YE161020???�정?�다.
     * @param vo - ?�정???�보�??�긴 Ye161020VO
     * @return void??
     * @exception Exception
     */
    public void updateYe161020YN(InfcPkgYe161020VO vo) throws Exception {
    	update("infcPkgYe161020DAO.updateYe161020YN_S", vo);
    }

    /**
	 * YE161020????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye161020VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe161020(InfcPkgYe161020VO vo) throws Exception {
        delete("infcPkgYe161020DAO.deleteYe161020_S", vo);
    }

//    /**
//	 * YE161020??조회?�다.
//	 * @param vo - 조회???�보�??�긴 Ye161020VO
//	 * @return 조회??YE161020
//	 * @exception Exception
//	 */
//    public Ye161020VO selectYe161020(Ye161020VO vo) throws Exception {
//        return (Ye161020VO) select("infcPkgYe161020DAO.selectYe161020_S", vo);
//    }

    /**
	 * YE161020 목록??조회?�다.
	 * @param searchMap - 조회???�보�??�긴 Map
	 * @return YE161020 목록
	 * @exception Exception
	 */
    public List<?> selectYe161020List(InfcPkgYe161020SrhVO searchVO) throws Exception {
        return list("infcPkgYe161020DAO.selectYe161020List_D", searchVO);
    }

//    /**
//	 * YE161020 �?�?���?조회?�다.
//	 * @param searchMap - 조회???�보�??�긴 Map
//	 * @return YE161020 �?�?��
//	 * @exception
//	 */
//    public int selectYe161020ListTotCnt(Ye161020SrhVO searchVO) {
//        return (Integer)select("infcPkgYe161020DAO.selectYe161020ListTotCnt_S", searchVO);
//    }

}
