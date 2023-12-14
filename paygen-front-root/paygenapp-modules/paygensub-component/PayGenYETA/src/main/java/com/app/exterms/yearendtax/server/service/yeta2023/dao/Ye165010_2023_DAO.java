package com.app.exterms.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye165010Srh_2023_VO;
import com.app.exterms.yearendtax.server.vo.Ye165010_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye165010_2023_DAO.java
 * @since : 2017. 12. 28. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye165010_2023_DAO")
public class Ye165010_2023_DAO extends EgovAbstractDAO {
	
	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE165010 목록을 조회한다.
	 * @param Ye165010SrhVO - 조회할 정보가 담긴 ye165010SrhVo
	 * @return YE165010 목록
	 * @exception Exception
	 */
	public List selectYetaP83003ToYe165010List(Ye165010Srh_2023_VO ye165010SrhVo)throws Exception {
		return list("ye165010_2023_DAO.seleteYetaP83003ToYe165010_D", ye165010SrhVo);
	}

	/**
	 * YE165010 총 갯수를 조회한다.
	 * @param Ye165010SrhVO - 조회할 정보가 담긴 ye165010SrhVo
	 * @return YE165010 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectYetaP83003ToYe165010ListTotCnt(Ye165010Srh_2023_VO ye165010SrhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ye165010_2023_DAO.seleteYetaP83003ToYe165010ListCnt_S", ye165010SrhVo);
	}	
	
	
	/**
	 * YE165010 을 등록한다.
	 * @param Ye165010VO - 등록할 정보가 담긴 Ye165010VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYetaP83003ToYe165010(Ye165010_2023_VO vo) throws Exception {
        return (String)insert("ye165010_2023_DAO.insertYetaP83003ToYe165010_S", vo);
    }
    
	/**
	 * YE165010 을 수정한다.
	 * @param Ye165010VO - 수정할 정보가 담긴 Ye165010VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYetaP83003ToYe165010(Ye165010_2023_VO vo) throws Exception {
        update("ye165010_2023_DAO.updateYetaP83003ToYe165010_S", vo);
    }
    
	/**
	 * YE165010 을 삭제한다.
	 * @param Ye165010VO - 삭제할 정보가 담긴 Ye165010VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYetaP83003ToYe165010(Ye165010_2023_VO vo) throws Exception {
        delete("ye165010_2023_DAO.deleteYetaP83003ToYe165010_S", vo);	
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

    public void deleteYetaP810001_Ye165010VO_2023_Delete(Ye165010_2023_VO vo) throws Exception {
        delete("ye165010_2023_DAO.deleteYetaP810001_Ye165010VO_2023_Delete_S", vo);
    }

     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
      ***********************************************************************************/	
	
    

	/**
	 * YE165010?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye165010VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe165010(Ye165010_2023_VO vo) throws Exception {
        return (String)insert("ye165010_2023_DAO.insertYe165010_S", vo);
    }

    /**
	 * YE165010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165010VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe165010(Ye165010_2023_VO vo) throws Exception {
        update("ye165010_2023_DAO.updateYe165010_S", vo);
    }

    /**
	 * YE165010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165010VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe165010(Ye165010_2023_VO vo) throws Exception {
        delete("ye165010_2023_DAO.deleteYe165010_S", vo);
    }

    /**
	 * YE165010?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye165010VO
	 * @return 조회?�� YE165010
	 * @exception Exception
	 */
    public Ye165010_2023_VO selectYe165010(Ye165010_2023_VO vo) throws Exception {
        return (Ye165010_2023_VO) selectByPk("ye165010_2023_DAO.selectYe165010_S", vo);
    }

    /**
	 * YE165010 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165010 목록
	 * @exception Exception
	 */
    public List<?> selectYe165010List(Ye165010Srh_2023_VO searchVO) throws Exception {
        return list("ye165010_2023_DAO.selectYe165010List_D", searchVO);
    }

    /**
	 * YE165010 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165010 �? �??��
	 * @exception
	 */
    public int selectYe165010ListTotCnt(Ye165010Srh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye165010_2023_DAO.selectYe165010ListTotCnt_S", searchVO);
    }

}
