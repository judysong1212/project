package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161005_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161020_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta1000_2023_DAO.java
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

@Repository("InfcPkgYeta17File_2023_DAO")
public class InfcPkgYeta17File_2023_DAO extends EgovAbstractDAO { 
	  
    public InfcPkgYe161005_2023_VO selectYe161005(InfcPkgYe161010_2023_VO ye161010VO) throws Exception {
        return (InfcPkgYe161005_2023_VO) selectByPk("infcPkgYeta17File_2023_DAO.selectYe161005_S", ye161010VO);
    }
		  
		   
   /** 
    * 
    * <pre>
    * 1. 개요 : B레코드 - 원천징수의무자별 집계레코드 
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : fnPayrHB_ReTax_Total_Select
    * @date : 2017. 1. 20.
    * @author : atres-pc
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	2017. 1. 20.		atres-pc				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @param vo
    * @return
    * @throws Exception
    */
    public Map fnPayrHB_ReTax_Total_Select(InfcPkgYe161020_2023_VO vo) throws Exception {
	     return (Map) selectByPk("infcPkgYeta17File_2023_DAO.fnPayrHB_ReTax_Total_Select", vo);
	 }
    
    /**
     * 
     * <pre>
     * 1. 개요 :  전자파일 B 레코드 원천징수의무자별 집계레코드  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : fnPayrB_ReTax_Total_Select
     * @date : 2017. 1. 20.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 1. 20.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @return
     * @throws Exception
     */
    public Map fnPayrB_ReTax_Total_Select(InfcPkgYe161020_2023_VO vo) throws Exception {
	     return (Map) selectByPk("infcPkgYeta17File_2023_DAO.fnPayrB_ReTax_Total_Select", vo);
	 } 
    
    /**
     * 
     * <pre>
     * 1. 개요 : C 레코드 - 기부금 조정명세 레코드 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : fnPayrPSNL_ReTax_Total_Select
     * @date : 2017. 1. 20.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 1. 20.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param searchVO
     * @return
     * @throws Exception
     */
    public List fnPayrPSNL_ReTax_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
         return list("infcPkgYeta17File_2023_DAO.fnPayrPSNL_ReTax_Total_Select", searchVO);
    }
    
    /**
     * 
     * <pre>
     * 1. 개요 : C 레코드 - 기부금 조정명세 레코드  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : fnPayrHC_ReTax_Total_Select
     * @date : 2017. 1. 20.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 1. 20.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param searchVO
     * @return
     * @throws Exception
     */
    public List fnPayrHC_ReTax_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
        return list("infcPkgYeta17File_2023_DAO.fnPayrHC_ReTax_Total_Select", searchVO);
   }
    
    /**
     * 
     * <pre>
     * 1. 개요 : D레코드 - 해당연도 기부명세 레코드  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : fnPayrHD_ReTax_Total_Select
     * @date : 2017. 1. 20.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 1. 20.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param searchVO
     * @return
     * @throws Exception
     */
    public List fnPayrHD_ReTax_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
        return list("infcPkgYeta17File_2023_DAO.fnPayrHD_ReTax_Total_Select", searchVO);
   }
    
    /**
     * 
     * <pre>
     * 1. 개요 : A레코드 - 의료비지급명세서 레코드  인원 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : fnPayrPSNL_ReTax_CA_Total_Select
     * @date : 2017. 1. 20.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 1. 20.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param searchVO
     * @return
     * @throws Exception
     */
    public List fnPayrPSNL_ReTax_CA_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
        return list("infcPkgYeta17File_2023_DAO.fnPayrPSNL_ReTax_CA_Total_Select", searchVO);
   }
    
    /**
     * 
     * <pre>
     * 1. 개요 : A레코드 - 의료비지급명세서 레코드  내역 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : fnPayrCA_ReTax_Total_Select
     * @date : 2017. 1. 20.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 1. 20.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param searchVO
     * @return
     * @throws Exception
     */
    public List fnPayrCA_ReTax_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
        return list("infcPkgYeta17File_2023_DAO.fnPayrCA_ReTax_Total_Select", searchVO);
   }
        
    public List fnPayrC_ReTax_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
        return list("infcPkgYeta17File_2023_DAO.fnPayrC_ReTax_Total_Select", searchVO);
   }
    
    /**
     * 
     * <pre>
     * 1. 개요 : D 레코드 종전근무처 레코드 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : fnPayrD_ReTax_Total_Select
     * @date : 2017. 1. 20.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 1. 20.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param searchVO
     * @return
     * @throws Exception
     */
    public List fnPayrD_ReTax_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
        return list("infcPkgYeta17File_2023_DAO.fnPayrD_ReTax_Total_Select", searchVO);
   }
    
    /**
     * 
     * <pre>
     * 1. 개요 :  E레코드 -소득공제명세 레코드 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : fnPayrE_ReTax_Total_Select
     * @date : 2017. 1. 20.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 1. 20.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param searchVO
     * @return
     * @throws Exception
     */
    public List fnPayrE_ReTax_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
        return list("infcPkgYeta17File_2023_DAO.fnPayrE_ReTax_Total_Select", searchVO);
   }   
    
    /**
     * 
     * <pre>
     * 1. 개요 : F레코드  - 연금저축등 소득세액공제명세 레코드  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : fnPayrF_ReTax_Total_Select
     * @date : 2017. 1. 20.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 1. 20.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param searchVO
     * @return
     * @throws Exception
     */
    public List fnPayrF_ReTax_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
        return list("infcPkgYeta17File_2023_DAO.fnPayrF_ReTax_Total_Select", searchVO);
   }  
    
    /**
     * 
     * <pre>
     * 1. 개요 : G레코드 - 월세 거주간 주택임차 차입금 원리금 상환액 소득공제명세 레코드 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : fnPayrG_ReTax_Total_Select
     * @date : 2017. 1. 20.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 1. 20.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param searchVO
     * @return
     * @throws Exception
     */
    public List fnPayrG_ReTax_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
        return list("infcPkgYeta17File_2023_DAO.fnPayrG_ReTax_Total_Select", searchVO);
   }  
    
    public int updateYeta8400ToYe161010(InfcPkgYe161010_2023_VO ye161010VO) throws Exception {
         return update("infcPkgYeta17File_2023_DAO.updateYeta8400ToYe161010_S", ye161010VO);
    }   
    
    
	    
//	 /**
//		 * YETa4300을 등록한다.
//		 * @param vo - 등록할 정보가 담긴 Yeta4300VO
//		 * @return 등록 결과
//		 * @exception Exception
//		 */
//		  @Transactional
//	    public String insertYeta4300(YetaPrc3300_2023_VO vo) throws Exception {
//	        return (String)insert("infcPkgYeta4300_2023_DAO.insertYetaPrc3300_S", vo);
//	    }
//
//	    /**
//		 * YETa4300을 수정한다.
//		 * @param vo - 수정할 정보가 담긴 Yeta4300VO
//		 * @return void형
//		 * @exception Exception
//		 */
//		  @Transactional
//	    public void updateYeta4300(YetaPrc3300_2023_VO vo) throws Exception {
//	        update("infcPkgYeta4300_2023_DAO.updateYetaPrc3300_S", vo);
//	    }
//
//	    /**
//		 * YETa4300을 삭제한다.
//		 * @param vo - 삭제할 정보가 담긴 Yeta4300VO
//		 * @return void형 
//		 * @exception Exception
//		 */
//		  @Transactional
//	    public void deleteYeta4300(YetaPrc3300_2023_VO vo) throws Exception {
//	        delete("infcPkgYeta4300_2023_DAO.deleteYetaPrc3300_S", vo);
//	    }
//
//	    /**
//		 * YETa4300을 삭제한다.
//		 * @param vo - 삭제할 정보가 담긴 Yeta4300VO
//		 * @return void형 
//		 * @exception Exception
//		 */
//		  @Transactional
//	    public void fnPayr06430_Yeta4300_CREATE_Delete(YetaPrc3300_2023_VO vo) throws Exception {
//	        delete("infcPkgYeta4300_2023_DAO.fnPayr06430_Yeta4300_CREATE_Delete_S", vo);
//	    } 
//	    
//	    /**
//		 * YETa4300을 조회한다.
//		 * @param vo - 조회할 정보가 담긴 Yeta4300VO
//		 * @return 조회한 YETa4300
//		 * @exception Exception
//		 */
//		  
//	    public YetaPrc3300_2023_VO selectYeta4300(YetaPrc3300_2023_VO vo) throws Exception {
//	        return (YetaPrc3300_2023_VO) selectByPk("infcPkgYeta4300_2023_DAO.selectYetaPrc3300_S", vo);
//	    }
//
//	    /**
//		 * YETa4300 목록을 조회한다.
//		 * @param searchMap - 조회할 정보가 담긴 Map
//		 * @return YETa4300 목록
//		 * @exception Exception
//		 */
//	    public List<?> selectYeta4300List(YetaPrc3300Srh_2023_VO searchVO) throws Exception {
//	        return list("infcPkgYeta4300_2023_DAO.selectYetaPrc3300List_D", searchVO);
//	    }
//
//	    /**
//		 * YETa4300 총 갯수를 조회한다.
//		 * @param searchMap - 조회할 정보가 담긴 Map
//		 * @return YETa4300 총 갯수
//		 * @exception
//		 */
//	    public int selectYeta4300ListTotCnt(YetaPrc3300Srh_2023_VO searchVO) {
//	        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYeta4300_2023_DAO.selectYetaPrc3300ListTotCnt_S", searchVO);
//	    }
	
}
