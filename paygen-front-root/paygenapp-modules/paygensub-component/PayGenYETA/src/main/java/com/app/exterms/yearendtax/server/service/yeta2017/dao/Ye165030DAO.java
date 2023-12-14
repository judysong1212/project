package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye165030SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye165030VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye165030DAO.java
 * @since : 2017. 12. 27. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye165030DAO")
public class Ye165030DAO extends EgovAbstractDAO {
	
	
	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE165030 목록을 조회한다.
	 * @param Ye165030SrhVO - 조회할 정보가 담긴 ye165030SrhVo
	 * @return YE165030 목록
	 * @exception Exception
	 */
	public List selectYetaP23001ToYe165030List(Ye165030SrhVO ye165030SrhVo)throws Exception {
		return list("ye165030DAO.seleteYetaP23001ToYe165030_D", ye165030SrhVo);
	}

	/**
	 * YE165030 총 갯수를 조회한다.
	 * @param Ye165030SrhVO - 조회할 정보가 담긴 ye165030SrhVo
	 * @return YE165030 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectYetaP23001ToYe165030ListTotCnt(Ye165030SrhVO ye165030SrhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ye165030DAO.seleteYetaP23001ToYe165030ListCnt_S", ye165030SrhVo);
	}	
	
	
	/**
	 * YE165030 을 등록한다.
	 * @param Ye165030VO - 등록할 정보가 담긴 Ye165030VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYetaP23001ToYe165030(Ye165030VO vo) throws Exception {
        return (String)insert("ye165030DAO.insertYetaP23001ToYe165030_S", vo);
    }
    
	/**
	 * YE165030 을 수정한다.
	 * @param Ye165030VO - 수정할 정보가 담긴 Ye165030VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYetaP23001ToYe165030(Ye165030VO vo) throws Exception {
        update("ye165030DAO.updateYetaP23001ToYe165030_S", vo);
    }
    
	/**
	 * YE165030 을 삭제한다.
	 * @param Ye165030VO - 삭제할 정보가 담긴 Ye165030VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYetaP23001ToYe165030(Ye165030VO vo) throws Exception {
        delete("ye165030DAO.deleteYetaP23001ToYe165030_S", vo);	
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

    public void deleteYetaP210001_Ye165030VO_2017_Delete(Ye165030VO vo) throws Exception {
        delete("ye165030DAO.deleteYetaP210001_Ye165030VO_2017_Delete_S", vo);
    }

     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
      ***********************************************************************************/
    
    
	

	/**
	 * YE165030?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye165030VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe165030(Ye165030VO vo) throws Exception {
        return (String)insert("ye165030DAO.insertYe165030_S", vo);
    }

    /**
	 * YE165030?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165030VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe165030(Ye165030VO vo) throws Exception {
        update("ye165030DAO.updateYe165030_S", vo);
    }

    /**
	 * YE165030?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165030VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe165030(Ye165030VO vo) throws Exception {
        delete("ye165030DAO.deleteYe165030_S", vo);
    }

    /**
	 * YE165030?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye165030VO
	 * @return 조회?�� YE165030
	 * @exception Exception
	 */
    public Ye165030VO selectYe165030(Ye165030VO vo) throws Exception {
        return (Ye165030VO) selectByPk("ye165030DAO.selectYe165030_S", vo);
    }

    /**
	 * YE165030 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165030 목록
	 * @exception Exception
	 */
    public List<?> selectYe165030List(Ye165030SrhVO searchVO) throws Exception {
        return list("ye165030DAO.selectYe165030List_D", searchVO);
    }

    /**
	 * YE165030 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165030 �? �??��
	 * @exception
	 */
    public int selectYe165030ListTotCnt(Ye165030SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye165030DAO.selectYe165030ListTotCnt_S", searchVO);
    }

}
