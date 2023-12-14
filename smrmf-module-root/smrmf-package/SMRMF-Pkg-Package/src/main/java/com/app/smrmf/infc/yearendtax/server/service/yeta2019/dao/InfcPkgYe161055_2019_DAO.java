package com.app.smrmf.infc.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161055Srh_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161055_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161055_2019_DAO.java
 * @Description : Ye161055 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe161055_2019_DAO")
public class InfcPkgYe161055_2019_DAO extends EgovAbstractDAO {

	
	// 공적연금상세
	@Transactional
	public int fnYeta4300_Ye161055_PAYR_2019_CREATE_Insert(InfcPkgYe161055_2019_VO infcPkgYe161055Vo) throws Exception {
		 return update("infcPkgYe161055_2019_DAO.fnYeta4300_YE161055_2019_Update_S", infcPkgYe161055Vo);
	 
   }
	
	
	@Transactional
	public String fnYeta4100_Ye161055_PAYR_2019_Y0130001_Insert(InfcPkgYe160401VO yePrc160401Vo) throws Exception {
		 return (String)insert("infcPkgYe161055_2019_DAO.fnYeta4100_Ye161055_PAYR_2019_Y0130001_Insert_S", yePrc160401Vo);
	 
   }
	
	@Transactional
	public String fnYeta4100_Ye161055_PAYR_2019_Y0130002_Insert(InfcPkgYe160401VO yePrc160401Vo) throws Exception {
		 return (String)insert("infcPkgYe161055_2019_DAO.fnYeta4100_Ye161055_PAYR_2019_Y0130002_Insert_S", yePrc160401Vo);
	 
   }
	
	//YE161055 국민연금 주사업장 
	@Transactional
    public String PdfYeta2019_P102M_YE161055_Update(InfcPkgYe161055_2019_VO infcPkgYe161055Vo) throws Exception {
           update("infcPkgYe161055_2019_DAO.PdfYeta2019_P102M_YE161055_Update_S", infcPkgYe161055Vo);
           
           return "";
    } 
	 
	
	// C_연금보험료_공적연금상세 
	@Transactional
	public String incTaxDeducDec_nts_Yeta2019_Ye161055_Insert(InfcPkgYe161055_2019_VO infcPkgYe161055Vo) throws Exception {
		 return (String)insert("infcPkgYe161055_2019_DAO.incTaxDeducDec_nts_Yeta2019_Ye161055_Insert_S", infcPkgYe161055Vo);
	 
   }
	
	@Transactional
	public String fnYeta4100_Ye161055_PAYR_2019_Y0130002_Insert(InfcPkgYe161055_2019_VO infcPkgYe161055Vo) throws Exception {
		 return (String)insert("infcPkgYe161055_2019_DAO.fnYeta4100_Ye161055_PAYR_2019_Y0130002_Insert_S", infcPkgYe161055Vo);
	 
   }
	
	//종사업장 정리 
	@Transactional
    public int delete_YETA2300_2019_Ye161055(InfcPkgYe161055_2019_VO infcPkgYe161055Vo) throws Exception {
        return delete("infcPkgYe161055_2019_DAO.delete_YETA2300_2019_Ye161055_S", infcPkgYe161055Vo);
    }

	@Transactional
	public String insert_YETA2300_2019_Ye161055(InfcPkgYe161055_2019_VO infcPkgYe161055Vo) throws Exception {
		 return (String)insert("infcPkgYe161055_2019_DAO.insert_YETA2300_2019_Ye161055_S", infcPkgYe161055Vo);
	 
   } 
	
	/**
	 * YE161055?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161055VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161055(InfcPkgYe161055_2019_VO vo) throws Exception {
        return (String)insert("infcPkgYe161055_2019_DAO.insertYe161055_S", vo);
    }

    /**
	 * YE161055?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161055VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161055(InfcPkgYe161055_2019_VO vo) throws Exception {
        update("infcPkgYe161055_2019_DAO.updateYe161055_S", vo);
    }

    /**
	 * YE161055?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161055VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161055(InfcPkgYe161055_2019_VO vo) throws Exception {
        delete("infcPkgYe161055_2019_DAO.deleteYe161055_S", vo);
    }

    /**
	 * YE161055?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161055VO
	 * @return 조회?�� YE161055
	 * @exception Exception
	 */
    public InfcPkgYe161055_2019_VO selectYe161055(InfcPkgYe161055_2019_VO vo) throws Exception {
        return (InfcPkgYe161055_2019_VO) selectByPk("infcPkgYe161055_2019_DAO.selectYe161055_S", vo);
    }

    /**
	 * YE161055 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161055 목록
	 * @exception Exception
	 */
    public List<?> selectYe161055List(InfcPkgYe161055Srh_2019_VO searchVO) throws Exception {
        return list("infcPkgYe161055_2019_DAO.selectYe161055List_D", searchVO);
    }

    /**
	 * YE161055 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161055 �? �??��
	 * @exception
	 */
    public int selectYe161055ListTotCnt(InfcPkgYe161055Srh_2019_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe161055_2019_DAO.selectYe161055ListTotCnt_S", searchVO);
    }

}
