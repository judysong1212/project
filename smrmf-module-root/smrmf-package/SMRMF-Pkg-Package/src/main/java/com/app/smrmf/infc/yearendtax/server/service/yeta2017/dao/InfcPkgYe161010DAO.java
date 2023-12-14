package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161010DAO.java
 * @Description : Ye161010 DAO Class
 * @Modification Information
 *
 * @author DaEun, Bae
 * @since 2017.01.04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe161010DAO")
public class InfcPkgYe161010DAO extends EgovAbstractDAO {

	
	@Transactional
    public String fnYeta2100_YE161010_2017_CREATE_Insert(InfcPkgYe161010VO infcPkgYe161010Vo) throws Exception {
        return (String)insert("infcPkgYe161010DAO.fnYeta2100_YE161010_2017_CREATE_Insert_S", infcPkgYe161010Vo);
    }
	
	@Transactional
	public int incTaxDeducDec_nts_Yeta2017_YetaAll_Delete(InfcPkgYe161010VO  infcPkgYe161010Vo) throws Exception {
		return delete("infcPkgYe161010DAO.incTaxDeducDec_nts_Yeta2017_YetaAll_Delete_S", infcPkgYe161010Vo);
	}
	 
	
  public HashMap selectBass0360SearchList(InfcPkgYe161010SrhVO infcPkgYe161010SrhVo) throws Exception {
  return (HashMap) selectByPk("infcPkgYe161010DAO.selectBass0360SearchList_S", infcPkgYe161010SrhVo);
}
	
  
  public HashMap selectBass0500SearchList(InfcPkgYe161010SrhVO infcPkgYe161010SrhVo) throws Exception {
	  return (HashMap) selectByPk("infcPkgYe161010DAO.selectBass0500SearchList_S", infcPkgYe161010SrhVo);
  }
  
  
  public void fnYeta2100_YE161010_UtDpobCd_2017_Update(InfcPkgYe161010VO infcPkgYe161010Vo) throws Exception {
      update("infcPkgYe161010DAO.fnYeta2100_YE161010_UtDpobCd_2017_Update_S", infcPkgYe161010Vo);
  }
   
	
	/**
	 * YE161010???�록?�다.
	 * @param vo - ?�록???�보�??�긴 Ye161010VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertYe161010(InfcPkgYe161010VO vo) throws Exception {
        return (String)insert("infcPkgYe161010DAO.insertYe161010_S", vo);
    }

    /**
	 * YE161010???�정?�다.
	 * @param vo - ?�정???�보�??�긴 Ye161010VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe161010(InfcPkgYe161010VO vo) throws Exception {
        update("infcPkgYe161010DAO.updateYe161010_S", vo);
    }

    /**
	 * YE161010????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye161010VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe161010(InfcPkgYe161010VO vo) throws Exception {
        delete("infcPkgYe161010DAO.deleteYe161010_S", vo);
    }

//    /**
//	 * YE161010??조회?�다.
//	 * @param vo - 조회???�보�??�긴 Ye161010VO
//	 * @return 조회??YE161010
//	 * @exception Exception
//	 */
//    public Ye161010VO selectYe161010(Ye161010VO vo) throws Exception {
//        return (Ye161010VO) select("infcPkgYe161010DAO.selectYe161010_S", vo);
//    }

    /**
	 * YE161010 목록??조회?�다.
	 * @param searchMap - 조회???�보�??�긴 Map
	 * @return YE161010 목록
	 * @exception Exception
	 */
    public List<?> selectYe161010List(InfcPkgYe161010SrhVO searchVO) throws Exception {
        return list("infcPkgYe161010DAO.selectYe161010List_D", searchVO);
    }

//    /**
//	 * YE161010 �?�?���?조회?�다.
//	 * @param searchMap - 조회???�보�??�긴 Map
//	 * @return YE161010 �?�?��
//	 * @exception
//	 */
//    public int selectYe161010ListTotCnt(Ye161010SrhVO searchVO) {
//        return (Integer)select("infcPkgYe161010DAO.selectYe161010ListTotCnt_S", searchVO);
//    }
    
    @Transactional
	public int PdfYeta2200_AllDelete(InfcPkgYe161010VO  infcPkgYe161010Vo) throws Exception {
		return delete("infcPkgYe161010DAO.PdfYeta2200_AllDelete_D", infcPkgYe161010Vo);
	}

}
