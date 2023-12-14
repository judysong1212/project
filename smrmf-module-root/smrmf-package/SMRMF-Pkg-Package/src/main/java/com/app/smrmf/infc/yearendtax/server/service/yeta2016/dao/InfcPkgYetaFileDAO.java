package com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao;

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

@Repository("InfcPkgYetaFileDAO")
public class InfcPkgYetaFileDAO extends EgovAbstractDAO { 
	  
	 
			   
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
	    public Map fnPayrHB_ReTax_Total_Select(InfcPkgYeta1000VO vo) throws Exception {
		     return (Map) selectByPk("infcPkgYetaFileDAO.fnPayrHB_ReTax_Total_Select", vo);
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
	    public Map fnPayrB_ReTax_Total_Select(InfcPkgYeta1000VO vo) throws Exception {
		     return (Map) selectByPk("infcPkgYetaFileDAO.fnPayrB_ReTax_Total_Select", vo);
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
	    public List fnPayrPSNL_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
             return list("infcPkgYetaFileDAO.fnPayrPSNL_ReTax_Total_Select", searchVO);
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
	    public List fnPayrHC_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
            return list("infcPkgYetaFileDAO.fnPayrHC_ReTax_Total_Select", searchVO);
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
	    public List fnPayrHD_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
            return list("infcPkgYetaFileDAO.fnPayrHD_ReTax_Total_Select", searchVO);
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
	    public List fnPayrPSNL_ReTax_CA_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
            return list("infcPkgYetaFileDAO.fnPayrPSNL_ReTax_CA_Total_Select", searchVO);
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
	    public List fnPayrCA_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
            return list("infcPkgYetaFileDAO.fnPayrCA_ReTax_Total_Select", searchVO);
       }
	        
	    public List fnPayrC_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
            return list("infcPkgYetaFileDAO.fnPayrC_ReTax_Total_Select", searchVO);
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
	    public List fnPayrD_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
            return list("infcPkgYetaFileDAO.fnPayrD_ReTax_Total_Select", searchVO);
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
	    public List fnPayrE_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
            return list("infcPkgYetaFileDAO.fnPayrE_ReTax_Total_Select", searchVO);
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
	    public List fnPayrF_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
            return list("infcPkgYetaFileDAO.fnPayrF_ReTax_Total_Select", searchVO);
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
	    public List fnPayrG_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
            return list("infcPkgYetaFileDAO.fnPayrG_ReTax_Total_Select", searchVO);
       }  
	    
//	 /**
//		 * YETA3300을 등록한다.
//		 * @param vo - 등록할 정보가 담긴 Yeta3300VO
//		 * @return 등록 결과
//		 * @exception Exception
//		 */
//		  @Transactional
//	    public String insertYeta3300(YetaPrc3300VO vo) throws Exception {
//	        return (String)insert("infcPkgYeta3300DAO.insertYetaPrc3300_S", vo);
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
//	        update("infcPkgYeta3300DAO.updateYetaPrc3300_S", vo);
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
//	        delete("infcPkgYeta3300DAO.deleteYetaPrc3300_S", vo);
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
//	        delete("infcPkgYeta3300DAO.fnPayr06430_Yeta3300_CREATE_Delete_S", vo);
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
//	        return (YetaPrc3300VO) selectByPk("infcPkgYeta3300DAO.selectYetaPrc3300_S", vo);
//	    }
//
//	    /**
//		 * YETA3300 목록을 조회한다.
//		 * @param searchMap - 조회할 정보가 담긴 Map
//		 * @return YETA3300 목록
//		 * @exception Exception
//		 */
//	    public List<?> selectYeta3300List(YetaPrc3300SrhVO searchVO) throws Exception {
//	        return list("infcPkgYeta3300DAO.selectYetaPrc3300List_D", searchVO);
//	    }
//
//	    /**
//		 * YETA3300 총 갯수를 조회한다.
//		 * @param searchMap - 조회할 정보가 담긴 Map
//		 * @return YETA3300 총 갯수
//		 * @exception
//		 */
//	    public int selectYeta3300ListTotCnt(YetaPrc3300SrhVO searchVO) {
//	        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYeta3300DAO.selectYetaPrc3300ListTotCnt_S", searchVO);
//	    }
	
}
