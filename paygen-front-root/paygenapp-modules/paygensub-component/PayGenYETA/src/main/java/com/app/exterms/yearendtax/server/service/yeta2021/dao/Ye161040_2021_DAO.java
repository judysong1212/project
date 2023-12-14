package com.app.exterms.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Ye161040Srh_2021_VO;
import com.app.exterms.yearendtax.server.vo.Ye161040_2021_VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0530VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye161040_2021_DAO.java
 * @since : 2017. 12. 20. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye161040_2021_DAO")
public class Ye161040_2021_DAO extends EgovAbstractDAO {
	
	
	
	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE161040 목록을 조회한다.
	 * @param Ye161040Srh_2021_VO - 조회할 정보가 담긴 ye161040SrhVo
	 * @return YE161040 목록
	 * @exception Exception
	 */
	public List selectYeta6300ToYe161040List(Ye161040Srh_2021_VO ye161040SrhVo)throws Exception {
		return list("ye161040_2021_DAO.seleteYeta6300ToYe161040_D", ye161040SrhVo);
	}

	/**
	 * YE161040 총 갯수를 조회한다.
	 * @param Ye161040Srh_2021_VO - 조회할 정보가 담긴 ye161040SrhVo
	 * @return YE161040 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectYeta6300ToYe161040ListTotCnt(Ye161040Srh_2021_VO ye161040SrhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ye161040_2021_DAO.seleteYeta6300ToYe161040ListCnt_S", ye161040SrhVo);
	}	
	
	
	/**
	 * YE161040 을 등록한다.
	 * @param Ye161040_2021_VO - 등록할 정보가 담긴 Ye161040_2021_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYeta6300ToYe161040(Ye161040_2021_VO vo) throws Exception {
        return (String)insert("ye161040_2021_DAO.insertYeta6300ToYe161040_S", vo);
    }
    
    public String insertYeta6300ToYe161040_01(Ye161040_2021_VO vo) throws Exception {
        return (String)insert("ye161040_2021_DAO.yeta6300_YE161040_Insert01_S", vo);
    }
    
    public String insertYeta6300ToYe161040_02(Ye161040_2021_VO vo) throws Exception {
        return (String)insert("ye161040_2021_DAO.yeta6300_YE161040_Insert02_S", vo);
    }
    
    public InfcPkgPayr0530VO selectPayr0530Check(InfcPkgPayr0530VO vo) throws Exception {
        return (InfcPkgPayr0530VO) selectByPk("infcPayr0530_2021_DAO.selectPayr0530Check_S", vo);
    }
    
    @Transactional
    public String insertPayr0530(InfcPkgPayr0530VO vo) throws Exception {
        return (String)insert("infcPayr0530_2021_DAO.insertPayr0530_S", vo);
    }
    
    
    
	/**
	 * YE161040 을 수정한다.
	 * @param Ye161040_2021_VO - 수정할 정보가 담긴 Ye161040_2021_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYeta6300ToYe161040(Ye161040_2021_VO vo) throws Exception {
        update("ye161040_2021_DAO.updateYeta6300ToYe161040_S", vo);
    }
    
	/**
	 * YE161040 을 삭제한다.
	 * @param Ye161040_2021_VO - 삭제할 정보가 담긴 Ye161040_2021_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYeta6300ToYe161040(Ye161040_2021_VO vo) throws Exception {
        delete("ye161040_2021_DAO.deleteYeta6300ToYe161040_S", vo);	
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
	
    
    public void deleteYetaP610001_Ye161040_2021_VO_2021_Delete(Ye161040_2021_VO vo) throws Exception {
        delete("ye161040_2021_DAO.deleteYetaP610001_Ye161040_2021_VO_2021_Delete_S", vo);	
    }
    
    /***********************************************************************************
     * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
     ***********************************************************************************/
    
    
    
//	/**
//	 * YE161040?�� ?��록한?��.
//	 * @param vo - ?��록할 ?��보�? ?���? Ye161040_2021_VO
//	 * @return ?���? 결과
//	 * @exception Exception
//	 */
//    public String insertYe161040(Ye161040_2021_VO vo) throws Exception {
//        return (String)insert("ye161040_2021_DAO.insertYe161040_S", vo);
//    }
//
//    /**
//	 * YE161040?�� ?��?��?��?��.
//	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161040_2021_VO
//	 * @return void?��
//	 * @exception Exception
//	 */
//    public void updateYe161040(Ye161040_2021_VO vo) throws Exception {
//        update("ye161040_2021_DAO.updateYe161040_S", vo);
//    }
//
//    /**
//	 * YE161040?�� ?��?��?��?��.
//	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161040_2021_VO
//	 * @return void?�� 
//	 * @exception Exception
//	 */
//    public void deleteYe161040(Ye161040_2021_VO vo) throws Exception {
//        delete("ye161040_2021_DAO.deleteYe161040_S", vo);
//    }
//
//    /**
//	 * YE161040?�� 조회?��?��.
//	 * @param vo - 조회?�� ?��보�? ?���? Ye161040_2021_VO
//	 * @return 조회?�� YE161040
//	 * @exception Exception
//	 */
//    public Ye161040_2021_VO selectYe161040(Ye161040_2021_VO vo) throws Exception {
//        return (Ye161040_2021_VO) selectByPk("ye161040_2021_DAO.selectYe161040_S", vo);
//    }
//
//    /**
//	 * YE161040 목록?�� 조회?��?��.
//	 * @param searchMap - 조회?�� ?��보�? ?���? Map
//	 * @return YE161040 목록
//	 * @exception Exception
//	 */
//    public List<?> selectYe161040List(Ye161040Srh_2021_VO search_2021_VO) throws Exception {
//        return list("ye161040_2021_DAO.selectYe161040List_D", search_2021_VO);
//    }
//
//    /**
//	 * YE161040 �? �??���? 조회?��?��.
//	 * @param searchMap - 조회?�� ?��보�? ?���? Map
//	 * @return YE161040 �? �??��
//	 * @exception
//	 */
//    public int selectYe161040ListTotCnt(Ye161040Srh_2021_VO search_2021_VO) {
//        return (Integer)getSqlMapClientTemplate().queryForObject("ye161040_2021_DAO.selectYe161040ListTotCnt_S", search_2021_VO);
//    }

}