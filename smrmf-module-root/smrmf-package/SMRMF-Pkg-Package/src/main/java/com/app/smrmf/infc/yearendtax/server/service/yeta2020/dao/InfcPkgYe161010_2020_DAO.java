package com.app.smrmf.infc.yearendtax.server.service.yeta2020.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010Srh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161010_2020_DAO.java
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

@Repository("InfcPkgYe161010_2020_DAO")
public class InfcPkgYe161010_2020_DAO extends EgovAbstractDAO {

	
	@Transactional
    public String fnYeta5100_YE161010_2020_CREATE_Insert(InfcPkgYe161010_2020_VO infcPkgYe161010Vo) throws Exception {
        return (String)insert("infcPkgYe161010_2020_DAO.fnYeta5100_YE161010_2020_CREATE_Insert_S", infcPkgYe161010Vo);
    }
	
	@Transactional
	public int incTaxDeducDec_nts_Yeta2020_YetaAll_Delete(InfcPkgYe161010_2020_VO  infcPkgYe161010Vo) throws Exception {
		return delete("infcPkgYe161010_2020_DAO.incTaxDeducDec_nts_Yeta2020_YetaAll_Delete_S", infcPkgYe161010Vo);
	}
	 
	
  public HashMap selectBass0360SearchList(InfcPkgYe161010Srh_2020_VO infcPkgYe161010SrhVo) throws Exception {
  return (HashMap) selectByPk("infcPkgYe161010_2020_DAO.selectBass0360SearchList_S", infcPkgYe161010SrhVo);
}
	
  
  public HashMap selectBass0500SearchList(InfcPkgYe161010Srh_2020_VO infcPkgYe161010SrhVo) throws Exception {
	  return (HashMap) selectByPk("infcPkgYe161010_2020_DAO.selectBass0500SearchList_S", infcPkgYe161010SrhVo);
  }
  
  
  public void fnYeta5100_YE161010_UtDpobCd_2020_Update(InfcPkgYe161010_2020_VO infcPkgYe161010Vo) throws Exception {
      update("infcPkgYe161010_2020_DAO.fnYeta5100_YE161010_UtDpobCd_2020_Update_S", infcPkgYe161010Vo);
  }
   
	
	/**
	 * YE161010???�록?�다.
	 * @param vo - ?�록???�보�??�긴 Ye161010VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertYe161010(InfcPkgYe161010_2020_VO vo) throws Exception {
        return (String)insert("infcPkgYe161010_2020_DAO.insertYe161010_S", vo);
    }

    /**
	 * YE161010???�정?�다.
	 * @param vo - ?�정???�보�??�긴 Ye161010VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe161010(InfcPkgYe161010_2020_VO vo) throws Exception {
        update("infcPkgYe161010_2020_DAO.updateYe161010_S", vo);
    }

    /**
	 * YE161010????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye161010VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe161010(InfcPkgYe161010_2020_VO vo) throws Exception {
        delete("infcPkgYe161010_2020_DAO.deleteYe161010_S", vo);
    }

//    /**
//	 * YE161010??조회?�다.
//	 * @param vo - 조회???�보�??�긴 Ye161010VO
//	 * @return 조회??YE161010
//	 * @exception Exception
//	 */
//    public Ye161010_2020_VO selectYe161010(Ye161010_2020_VO vo) throws Exception {
//        return (Ye161010_2020_VO) select("infcPkgYe161010_2020_DAO.selectYe161010_S", vo);
//    }

    /**
	 * YE161010 목록??조회?�다.
	 * @param searchMap - 조회???�보�??�긴 Map
	 * @return YE161010 목록
	 * @exception Exception
	 */
    public List<?> selectYe161010List(InfcPkgYe161010Srh_2020_VO searchVO) throws Exception {
        return list("infcPkgYe161010_2020_DAO.selectYe161010List_D", searchVO);
    }

//    /**
//	 * YE161010 �?�?���?조회?�다.
//	 * @param searchMap - 조회???�보�??�긴 Map
//	 * @return YE161010 �?�?��
//	 * @exception
//	 */
//    public int selectYe161010ListTotCnt(Ye161010Srh_2020_VO searchVO) {
//        return (Integer)select("infcPkgYe161010_2020_DAO.selectYe161010ListTotCnt_S", searchVO);
//    }
    
    @Transactional
	public int PdfYeta5200_AllDelete(InfcPkgYe161010_2020_VO  infcPkgYe161010Vo) throws Exception {
		return delete("infcPkgYe161010_2020_DAO.PdfYeta5200_AllDelete_D", infcPkgYe161010Vo);
	}

}
