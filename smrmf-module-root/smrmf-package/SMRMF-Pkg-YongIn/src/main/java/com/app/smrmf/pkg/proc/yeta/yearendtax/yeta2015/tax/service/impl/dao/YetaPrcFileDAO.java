package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta1000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta1000DAO.java
 * @Description : Yeta1000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("YetaPrcFileDAO")
public class YetaPrcFileDAO extends EgovAbstractDAO { 
	  
  
	    public Map fnPayrHB_ReTax_Total_Select(InfcPkgYeta1000VO vo) throws Exception {
		     return (Map) selectByPk("yetaPrcFileDAO.fnPayrHB_ReTax_Total_Select", vo);
		 }
	    
	    public Map fnPayrB_ReTax_Total_Select(InfcPkgYeta1000VO vo) throws Exception {
		     return (Map) selectByPk("yetaPrcFileDAO.fnPayrB_ReTax_Total_Select", vo);
		 } 
	    
	    
	    public List fnPayrPSNL_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
             return list("yetaPrcFileDAO.fnPayrPSNL_ReTax_Total_Select", searchVO);
        }
	    
	    
	    public List fnPayrHC_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
            return list("yetaPrcFileDAO.fnPayrHC_ReTax_Total_Select", searchVO);
       }
	    
	    public List fnPayrHD_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
            return list("yetaPrcFileDAO.fnPayrHD_ReTax_Total_Select", searchVO);
       }
	    
	    public List fnPayrPSNL_ReTax_CA_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
            return list("yetaPrcFileDAO.fnPayrPSNL_ReTax_CA_Total_Select", searchVO);
       }
	    
	    public List fnPayrCA_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
            return list("yetaPrcFileDAO.fnPayrCA_ReTax_Total_Select", searchVO);
       }
	        
	    public List fnPayrC_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
            return list("yetaPrcFileDAO.fnPayrC_ReTax_Total_Select", searchVO);
       }
	    
	    public List fnPayrD_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
            return list("yetaPrcFileDAO.fnPayrD_ReTax_Total_Select", searchVO);
       }
	    public List fnPayrE_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
            return list("yetaPrcFileDAO.fnPayrE_ReTax_Total_Select", searchVO);
       }   
	    
	    public List fnPayrF_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
            return list("yetaPrcFileDAO.fnPayrF_ReTax_Total_Select", searchVO);
       }  
	    
	    public List fnPayrG_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
            return list("yetaPrcFileDAO.fnPayrG_ReTax_Total_Select", searchVO);
       }  
	    
//	 /**
//		 * YETA3300을 등록한다.
//		 * @param vo - 등록할 정보가 담긴 Yeta3300VO
//		 * @return 등록 결과
//		 * @exception Exception
//		 */
//		  @Transactional
//	    public String insertYeta3300(YetaPrc3300VO vo) throws Exception {
//	        return (String)insert("yetaPrc3300DAO.insertYetaPrc3300_S", vo);
//	    }
//
//	    /**
//		 * YETA3300을 수정한다.
//		 * @param vo - 수정할 정보가 담긴 Yeta3300VO
//		 * @return void형
//		 * @exception Exception
//		 */
//		  @Transactional
//	    public void updateYeta3300(YetaPrc3300VO vo) throws Exception {
//	        update("yetaPrc3300DAO.updateYetaPrc3300_S", vo);
//	    }
//
//	    /**
//		 * YETA3300을 삭제한다.
//		 * @param vo - 삭제할 정보가 담긴 Yeta3300VO
//		 * @return void형 
//		 * @exception Exception
//		 */
//		  @Transactional
//	    public void deleteYeta3300(YetaPrc3300VO vo) throws Exception {
//	        delete("yetaPrc3300DAO.deleteYetaPrc3300_S", vo);
//	    }
//
//	    /**
//		 * YETA3300을 삭제한다.
//		 * @param vo - 삭제할 정보가 담긴 Yeta3300VO
//		 * @return void형 
//		 * @exception Exception
//		 */
//		  @Transactional
//	    public void fnPayr06430_Yeta3300_CREATE_Delete(YetaPrc3300VO vo) throws Exception {
//	        delete("yetaPrc3300DAO.fnPayr06430_Yeta3300_CREATE_Delete_S", vo);
//	    } 
//	    
//	    /**
//		 * YETA3300을 조회한다.
//		 * @param vo - 조회할 정보가 담긴 Yeta3300VO
//		 * @return 조회한 YETA3300
//		 * @exception Exception
//		 */
//		  
//	    public YetaPrc3300VO selectYeta3300(YetaPrc3300VO vo) throws Exception {
//	        return (YetaPrc3300VO) selectByPk("yetaPrc3300DAO.selectYetaPrc3300_S", vo);
//	    }
//
//	    /**
//		 * YETA3300 목록을 조회한다.
//		 * @param searchMap - 조회할 정보가 담긴 Map
//		 * @return YETA3300 목록
//		 * @exception Exception
//		 */
//	    public List<?> selectYeta3300List(YetaPrc3300SrhVO searchVO) throws Exception {
//	        return list("yetaPrc3300DAO.selectYetaPrc3300List_D", searchVO);
//	    }
//
//	    /**
//		 * YETA3300 총 갯수를 조회한다.
//		 * @param searchMap - 조회할 정보가 담긴 Map
//		 * @return YETA3300 총 갯수
//		 * @exception
//		 */
//	    public int selectYeta3300ListTotCnt(YetaPrc3300SrhVO searchVO) {
//	        return (Integer)getSqlMapClientTemplate().queryForObject("yetaPrc3300DAO.selectYetaPrc3300ListTotCnt_S", searchVO);
//	    }
	
}
