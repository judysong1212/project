package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye160403SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye169010SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye169010VO;
import com.app.exterms.yearendtax.server.vo.Ye169010aSrhVO;
import com.app.exterms.yearendtax.server.vo.Ye169010aVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye169010aDAO.java
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

@Repository("Ye169010aDAO")
public class Ye169010aDAO extends EgovAbstractDAO {

	
	/***********************************************************************************
	 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
	 ***********************************************************************************/
	
	
	  /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/      
	   public void deleteYetaP210001_Ye169010aVO_2017_Delete(Ye169010aVO vo) throws Exception {
	        delete("ye169010aDAO.deleteYetaP210001_Ye169010aVO_2017_Delete_S", vo);
	    }
	   
	   
	   /** ++++++++++++++++++++++++++++++++yeta2300 화면처리  ++++++++++++++++++++++++++++ **/  	   
		public int selectYeta2300ToYe169010aListTotCnt(Ye169010SrhVO ye169010SrhVo) {
			return (Integer) getSqlMapClientTemplate().queryForObject("ye169010aDAO.seleteYeta2300ToYe169010aListCnt_S", ye169010SrhVo);
		}	
		
		public List selectYeta2300ToYe169010aList(Ye169010SrhVO ye169010SrhVo)throws Exception {
			return list("ye169010aDAO.seleteYeta2300ToYe169010_D", ye169010SrhVo);
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
    public String insertYe169010a(Ye169010aVO vo) throws Exception {
        return (String)insert("ye169010aDAO.insertYe169010a_S", vo);
    }

    /**
	 * YE169010A?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye169010aVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe169010a(Ye169010aVO vo) throws Exception {
        update("ye169010aDAO.updateYe169010a_S", vo);
    }

    /**
	 * YE169010A?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye169010aVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe169010a(Ye169010aVO vo) throws Exception {
        delete("ye169010aDAO.deleteYe169010a_S", vo);
    }

    /**
	 * YE169010A?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye169010aVO
	 * @return 조회?�� YE169010A
	 * @exception Exception
	 */
    public Ye169010aVO selectYe169010a(Ye169010aVO vo) throws Exception {
        return (Ye169010aVO) selectByPk("ye169010aDAO.selectYe169010a_S", vo);
    }

    /**
	 * YE169010A 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE169010A 목록
	 * @exception Exception
	 */
    public List<?> selectYe169010aList(Ye169010aSrhVO searchVO) throws Exception {
        return list("ye169010aDAO.selectYe169010aList_D", searchVO);
    }

    /**
	 * YE169010A �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE169010A �? �??��
	 * @exception
	 */
    public int selectYe169010aListTotCnt(Ye169010aSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye169010aDAO.selectYe169010aListTotCnt_S", searchVO);
    }
    
    public List selectYetaP23017ToYe169010List(Ye169010aSrhVO searchVO)throws Exception {
		return list("ye169010aDAO.seleteYetaP23017ToYe169010_D", searchVO);
	}

}
