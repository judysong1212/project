package com.app.smrmf.infc.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161030Srh_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161030_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161030_2019_DAO.java
 * @Description : Ye161030 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe161030_2019_DAO")
public class InfcPkgYe161030_2019_DAO extends EgovAbstractDAO {

	@Transactional
    public String fnYeta4100_YE161030_2019_CREATE_Insert(InfcPkgYe161030_2019_VO infcPkgYe161030Vo) throws Exception {
        return (String)insert("infcPkgYe161030_2019_DAO.fnYeta4100_YE161030_2019_CREATE_Insert_S", infcPkgYe161030Vo);
    }
	
	@Transactional
    public int fnYeta4100_YE161030_2019_CREATE_Update(InfcPkgYe161030_2019_VO infcPkgYe161030Vo) throws Exception {
       return update("infcPkgYe161030_2019_DAO.fnYeta4100_YE161030_2019_CREATE_Update_S", infcPkgYe161030Vo);
        
    }
	
	
	@Transactional
    public int incDdcYeta4100_YE161030_2019_CREATE_Update(InfcPkgYe161030_2019_VO infcPkgYe161030Vo) throws Exception {
       return update("infcPkgYe161030_2019_DAO.fnYeta4100_YE161030_2019_CREATE_Update_S", infcPkgYe161030Vo);
        
    }
	
	//  E_인적공제명세
	@Transactional
    public String incTaxDeducDec_nts_Yeta2019_Ye161030_Insert(InfcPkgYe161030_2019_VO infcPkgYe161030Vo) throws Exception {
        return  (String)insert("infcPkgYe161030_2019_DAO.incTaxDeducDec_nts_Yeta2019_Ye161030_insert_S", infcPkgYe161030Vo);
    }
	 
	/**
	 * YE161030?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161030VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161030(InfcPkgYe161030_2019_VO vo) throws Exception {
        return (String)insert("infcPkgYe161030_2019_DAO.insertYe161030_S", vo);
    }

    /**
	 * YE161030?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161030VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161030(InfcPkgYe161030_2019_VO vo) throws Exception {
        update("infcPkgYe161030_2019_DAO.updateYe161030_S", vo);
    }

    /**
	 * YE161030?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161030VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161030(InfcPkgYe161030_2019_VO vo) throws Exception {
        delete("infcPkgYe161030_2019_DAO.deleteYe161030_S", vo);
    }

    /**
	 * YE161030?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161030VO
	 * @return 조회?�� YE161030
	 * @exception Exception
	 */
    public InfcPkgYe161030_2019_VO selectYe161030(InfcPkgYe161030_2019_VO vo) throws Exception {
        return (InfcPkgYe161030_2019_VO) selectByPk("infcPkgYe161030_2019_DAO.selectYe161030_S", vo);
    }

    /**
	 * YE161030 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161030 목록
	 * @exception Exception
	 */
    public List<?> selectYe161030List(InfcPkgYe161030Srh_2019_VO searchVO) throws Exception {
        return list("infcPkgYe161030_2019_DAO.selectYe161030List_D", searchVO);
    }

    /**
	 * YE161030 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161030 �? �??��
	 * @exception
	 */
    public int selectYe161030ListTotCnt(InfcPkgYe161030Srh_2019_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe161030_2019_DAO.selectYe161030ListTotCnt_S", searchVO);
    }

}
