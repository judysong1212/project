package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye160403Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye169010Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye169010_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye169010aSrh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye169010a_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye169010a_2020_DAO.java
 * @Description : Ye169010a DAO Class
 * @Modification Information
 *
 * @author atres
 * @since atres
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye169010a_2020_DAO")
public class Ye169010a_2020_DAO extends EgovAbstractDAO {

	
	/***********************************************************************************
	 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
	 ***********************************************************************************/
	
	
	  /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/      
	   public void deleteYetaP510001_Ye169010aVO_2020_Delete(Ye169010a_2020_VO vo) throws Exception {
	        delete("ye169010a_2020_DAO.deleteYetaP510001_Ye169010aVO_2020_Delete_S", vo);
	    }
	   
	   
	   /** ++++++++++++++++++++++++++++++++yeta2300 화면처리  ++++++++++++++++++++++++++++ **/  	   
		public int selectYeta5300ToYe169010aListTotCnt(Ye169010Srh_2020_VO ye169010SrhVo) {
			return (Integer) getSqlMapClientTemplate().queryForObject("ye169010a_2020_DAO.seleteYeta5300ToYe169010aListCnt_S", ye169010SrhVo);
		}	
		
		public List selectYeta5300ToYe169010aList(Ye169010Srh_2020_VO ye169010SrhVo)throws Exception {
			return list("ye169010a_2020_DAO.seleteYeta5300ToYe169010_D", ye169010SrhVo);
		}

	   

	 /***********************************************************************************
	  * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
	  ***********************************************************************************/	
	
	
	/**
	 * YE169010A?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye169010aVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe169010a(Ye169010a_2020_VO vo) throws Exception {
        return (String)insert("ye169010a_2020_DAO.insertYe169010a_S", vo);
    }

    /**
	 * YE169010A?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye169010aVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe169010a(Ye169010a_2020_VO vo) throws Exception {
        update("ye169010a_2020_DAO.updateYe169010a_S", vo);
    }

    /**
	 * YE169010A?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye169010aVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe169010a(Ye169010a_2020_VO vo) throws Exception {
        delete("ye169010a_2020_DAO.deleteYe169010a_S", vo);
    }

    /**
	 * YE169010A?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye169010aVO
	 * @return 조회?�� YE169010A
	 * @exception Exception
	 */
    public Ye169010a_2020_VO selectYe169010a(Ye169010a_2020_VO vo) throws Exception {
        return (Ye169010a_2020_VO) selectByPk("ye169010a_2020_DAO.selectYe169010a_S", vo);
    }

    /**
	 * YE169010A 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE169010A 목록
	 * @exception Exception
	 */
    public List<?> selectYe169010aList(Ye169010aSrh_2020_VO searchVO) throws Exception {
        return list("ye169010a_2020_DAO.selectYe169010aList_D", searchVO);
    }

    /**
	 * YE169010A �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE169010A �? �??��
	 * @exception
	 */
    public int selectYe169010aListTotCnt(Ye169010aSrh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye169010a_2020_DAO.selectYe169010aListTotCnt_S", searchVO);
    }
    
    public List selectYetaP53017ToYe169010List(Ye169010aSrh_2020_VO searchVO)throws Exception {
		return list("ye169010a_2020_DAO.seleteYetaP53017ToYe169010_D", searchVO);
	}

}