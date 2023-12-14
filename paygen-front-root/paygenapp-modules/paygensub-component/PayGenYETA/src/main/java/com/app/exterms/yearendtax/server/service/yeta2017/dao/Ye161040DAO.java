package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Ye161040SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye161040VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0530VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye161040DAO.java
 * @since : 2017. 12. 20. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye161040DAO")
public class Ye161040DAO extends EgovAbstractDAO {
	
	
	
	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE161040 목록을 조회한다.
	 * @param Ye161040SrhVO - 조회할 정보가 담긴 ye161040SrhVo
	 * @return YE161040 목록
	 * @exception Exception
	 */
	public List selectYeta2300ToYe161040List(Ye161040SrhVO ye161040SrhVo)throws Exception {
		return list("ye161040DAO.seleteYeta2300ToYe161040_D", ye161040SrhVo);
	}

	/**
	 * YE161040 총 갯수를 조회한다.
	 * @param Ye161040SrhVO - 조회할 정보가 담긴 ye161040SrhVo
	 * @return YE161040 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectYeta2300ToYe161040ListTotCnt(Ye161040SrhVO ye161040SrhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ye161040DAO.seleteYeta2300ToYe161040ListCnt_S", ye161040SrhVo);
	}	
	
	
	/**
	 * YE161040 을 등록한다.
	 * @param Ye161040VO - 등록할 정보가 담긴 Ye161040VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYeta2300ToYe161040(Ye161040VO vo) throws Exception {
        return (String)insert("ye161040DAO.insertYeta2300ToYe161040_S", vo);
    }
    
    public String insertYeta2300ToYe161040_01(Ye161040VO vo) throws Exception {
        return (String)insert("ye161040DAO.yeta2300_YE161040_Insert01_S", vo);
    }
    
    public String insertYeta2300ToYe161040_02(Ye161040VO vo) throws Exception {
        return (String)insert("ye161040DAO.yeta2300_YE161040_Insert02_S", vo);
    }
    
    public InfcPkgPayr0530VO selectPayr0530Check(InfcPkgPayr0530VO vo) throws Exception {
        return (InfcPkgPayr0530VO) selectByPk("infcPayr0530DAO.selectPayr0530Check_S", vo);
    }
    
    @Transactional
    public String insertPayr0530(InfcPkgPayr0530VO vo) throws Exception {
        return (String)insert("infcPayr0530DAO.insertPayr0530_S", vo);
    }
    
    
    
	/**
	 * YE161040 을 수정한다.
	 * @param Ye161040VO - 수정할 정보가 담긴 Ye161040VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYeta2300ToYe161040(Ye161040VO vo) throws Exception {
        update("ye161040DAO.updateYeta2300ToYe161040_S", vo);
    }
    
	/**
	 * YE161040 을 삭제한다.
	 * @param Ye161040VO - 삭제할 정보가 담긴 Ye161040VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYeta2300ToYe161040(Ye161040VO vo) throws Exception {
        delete("ye161040DAO.deleteYeta2300ToYe161040_S", vo);	
    }
	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 종료
	 * #############################################
	 * **/

    /***********************************************************************************
     * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
     ***********************************************************************************/
    /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/   
	
    
    public void deleteYetaP210001_Ye161040VO_2017_Delete(Ye161040VO vo) throws Exception {
        delete("ye161040DAO.deleteYetaP210001_Ye161040VO_2017_Delete_S", vo);	
    }
    
    /***********************************************************************************
     * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
     ***********************************************************************************/
    
    
    
//	/**
//	 * YE161040?�� ?��록한?��.
//	 * @param vo - ?��록할 ?��보�? ?���? Ye161040VO
//	 * @return ?���? 결과
//	 * @exception Exception
//	 */
//    public String insertYe161040(Ye161040VO vo) throws Exception {
//        return (String)insert("ye161040DAO.insertYe161040_S", vo);
//    }
//
//    /**
//	 * YE161040?�� ?��?��?��?��.
//	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161040VO
//	 * @return void?��
//	 * @exception Exception
//	 */
//    public void updateYe161040(Ye161040VO vo) throws Exception {
//        update("ye161040DAO.updateYe161040_S", vo);
//    }
//
//    /**
//	 * YE161040?�� ?��?��?��?��.
//	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161040VO
//	 * @return void?�� 
//	 * @exception Exception
//	 */
//    public void deleteYe161040(Ye161040VO vo) throws Exception {
//        delete("ye161040DAO.deleteYe161040_S", vo);
//    }
//
//    /**
//	 * YE161040?�� 조회?��?��.
//	 * @param vo - 조회?�� ?��보�? ?���? Ye161040VO
//	 * @return 조회?�� YE161040
//	 * @exception Exception
//	 */
//    public Ye161040VO selectYe161040(Ye161040VO vo) throws Exception {
//        return (Ye161040VO) selectByPk("ye161040DAO.selectYe161040_S", vo);
//    }
//
//    /**
//	 * YE161040 목록?�� 조회?��?��.
//	 * @param searchMap - 조회?�� ?��보�? ?���? Map
//	 * @return YE161040 목록
//	 * @exception Exception
//	 */
//    public List<?> selectYe161040List(Ye161040SrhVO searchVO) throws Exception {
//        return list("ye161040DAO.selectYe161040List_D", searchVO);
//    }
//
//    /**
//	 * YE161040 �? �??���? 조회?��?��.
//	 * @param searchMap - 조회?�� ?��보�? ?���? Map
//	 * @return YE161040 �? �??��
//	 * @exception
//	 */
//    public int selectYe161040ListTotCnt(Ye161040SrhVO searchVO) {
//        return (Integer)getSqlMapClientTemplate().queryForObject("ye161040DAO.selectYe161040ListTotCnt_S", searchVO);
//    }

}
