package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161050SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161050VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161050DAO.java
 * @Description : Ye161050 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe161050DAO")
public class InfcPkgYe161050DAO extends EgovAbstractDAO {

	
	// 연금보험료공제
	@Transactional
	public int fnYeta2300_Ye161050_PAYR_2017_CREATE_Insert(InfcPkgYe161050VO infcPkgYe161050Vo) throws Exception {
		 return update("infcPkgYe161050DAO.fnYeta2300_YE161050_2017_Update_S", infcPkgYe161050Vo);
	 
   }
	
	@Transactional
	public String fnYeta2100_Ye161050_PAYR_2017_CREATE_Insert(InfcPkgYe160401VO yePrc160401Vo) throws Exception {
		 return (String)insert("infcPkgYe161050DAO.fnYeta2100_Ye161050_PAYR_2017_CREATE_Insert_S", yePrc160401Vo);
	 
   }
	
	//YE161055 국민연금 주사업장 
		@Transactional
	    public int fnYeta2200_P102M_YE161050_2017_Update(InfcPkgYe161050VO infcPkgYe161050Vo) throws Exception {
			return update("infcPkgYe161060DAO.fnYeta2200_P102M_YE161050_2017_Update_S", infcPkgYe161050Vo);
	          
	    } 
		
 // C_연금보험료공제
		@Transactional
	    public String incTaxDeducDec_nts_Yeta2017_Ye161050_Insert(InfcPkgYe161050VO infcPkgYe161050Vo) throws Exception {
			return  (String)insert("infcPkgYe161060DAO.incTaxDeducDec_nts_Yeta2017_Ye161050_Insert_S", infcPkgYe161050Vo);
	           
	             
	    } 
	 
	
	/**
	 * YE161050?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161050VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161050(InfcPkgYe161050VO vo) throws Exception {
        return (String)insert("infcPkgYe161050DAO.insertYe161050_S", vo);
    }

    /**
	 * YE161050?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161050VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161050(InfcPkgYe161050VO vo) throws Exception {
        update("infcPkgYe161050DAO.updateYe161050_S", vo);
    }

    /**
	 * YE161050?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161050VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161050(InfcPkgYe161050VO vo) throws Exception {
        delete("infcPkgYe161050DAO.deleteYe161050_S", vo);
    }

    /**
	 * YE161050?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161050VO
	 * @return 조회?�� YE161050
	 * @exception Exception
	 */
    public InfcPkgYe161050VO selectYe161050(InfcPkgYe161050VO vo) throws Exception {
        return (InfcPkgYe161050VO) selectByPk("infcPkgYe161050DAO.selectYe161050_S", vo);
    }

    /**
	 * YE161050 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161050 목록
	 * @exception Exception
	 */
    public List<?> selectYe161050List(InfcPkgYe161050SrhVO searchVO) throws Exception {
        return list("infcPkgYe161050DAO.selectYe161050List_D", searchVO);
    }

    /**
	 * YE161050 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161050 �? �??��
	 * @exception
	 */
    public int selectYe161050ListTotCnt(InfcPkgYe161050SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe161050DAO.selectYe161050ListTotCnt_S", searchVO);
    }

}
