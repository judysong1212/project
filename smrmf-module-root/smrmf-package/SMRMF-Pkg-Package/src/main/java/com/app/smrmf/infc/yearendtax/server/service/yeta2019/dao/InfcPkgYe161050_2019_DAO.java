package com.app.smrmf.infc.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161050Srh_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161050_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161050_2019_DAO.java
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

@Repository("InfcPkgYe161050_2019_DAO")
public class InfcPkgYe161050_2019_DAO extends EgovAbstractDAO {

	
	// 연금보험료공제
	@Transactional
	public int fnYeta4300_Ye161050_PAYR_2019_CREATE_Insert(InfcPkgYe161050_2019_VO infcPkgYe161050Vo) throws Exception {
		 return update("infcPkgYe161050_2019_DAO.fnYeta4300_YE161050_2019_Update_S", infcPkgYe161050Vo);
	 
   }
	
	@Transactional
	public String fnYeta4100_Ye161050_PAYR_2019_CREATE_Insert(InfcPkgYe160401VO yePrc160401Vo) throws Exception {
		 return (String)insert("infcPkgYe161050_2019_DAO.fnYeta4100_Ye161050_PAYR_2019_CREATE_Insert_S", yePrc160401Vo);
	 
   }
	
	//YE161055 국민연금 주사업장 
		@Transactional
	    public int fnYeta4200_P102M_YE161050_2019_Update(InfcPkgYe161050_2019_VO infcPkgYe161050Vo) throws Exception {
			return update("infcPkgYe161060_2019_DAO.fnYeta4200_P102M_YE161050_2019_Update_S", infcPkgYe161050Vo);
	          
	    } 
		
 // C_연금보험료공제
		@Transactional
	    public String incTaxDeducDec_nts_Yeta2019_Ye161050_Insert(InfcPkgYe161050_2019_VO infcPkgYe161050Vo) throws Exception {
			return  (String)insert("infcPkgYe161060_2019_DAO.incTaxDeducDec_nts_Yeta2019_Ye161050_Insert_S", infcPkgYe161050Vo);
	           
	             
	    } 
	 
	
	/**
	 * YE161050?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161050VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161050(InfcPkgYe161050_2019_VO vo) throws Exception {
        return (String)insert("infcPkgYe161050_2019_DAO.insertYe161050_S", vo);
    }

    /**
	 * YE161050?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161050VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161050(InfcPkgYe161050_2019_VO vo) throws Exception {
        update("infcPkgYe161050_2019_DAO.updateYe161050_S", vo);
    }

    /**
	 * YE161050?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161050VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161050(InfcPkgYe161050_2019_VO vo) throws Exception {
        delete("infcPkgYe161050_2019_DAO.deleteYe161050_S", vo);
    }

    /**
	 * YE161050?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161050VO
	 * @return 조회?�� YE161050
	 * @exception Exception
	 */
    public InfcPkgYe161050_2019_VO selectYe161050(InfcPkgYe161050_2019_VO vo) throws Exception {
        return (InfcPkgYe161050_2019_VO) selectByPk("infcPkgYe161050_2019_DAO.selectYe161050_S", vo);
    }

    /**
	 * YE161050 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161050 목록
	 * @exception Exception
	 */
    public List<?> selectYe161050List(InfcPkgYe161050Srh_2019_VO searchVO) throws Exception {
        return list("infcPkgYe161050_2019_DAO.selectYe161050List_D", searchVO);
    }

    /**
	 * YE161050 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161050 �? �??��
	 * @exception
	 */
    public int selectYe161050ListTotCnt(InfcPkgYe161050Srh_2019_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe161050_2019_DAO.selectYe161050ListTotCnt_S", searchVO);
    }

}