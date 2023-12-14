package com.app.exterms.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye165030TempSrh_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye165030TempVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye165030Temp_2019_DAO.java
 * @Description : Ye165030Temp DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye165030Temp_2019_DAO")
public class Ye165030Temp_2019_DAO extends EgovAbstractDAO {

	
	
	/***********************************************************************************
	 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
	 ***********************************************************************************/
	   
	  /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/      
    public void deleteYetaP410001_Ye165030TempVO_2019_Delete(Ye165030TempVO vo) throws Exception {
        delete("ye165030Temp_2019_DAO.deleteYetaP410001_Ye165030TempVO_2019_Delete_S", vo);
    }

	 /***********************************************************************************
	  * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
	  ***********************************************************************************/
	 
	/**
	 * YE165030_TEMP?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye165030TempVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe165030Temp(Ye165030TempVO vo) throws Exception {
        return (String)insert("ye165030Temp_2019_DAO.insertYe165030Temp_S", vo);
    }

    /**
	 * YE165030_TEMP?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165030TempVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe165030Temp(Ye165030TempVO vo) throws Exception {
        update("ye165030Temp_2019_DAO.updateYe165030Temp_S", vo);
    }

    /**
	 * YE165030_TEMP?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165030TempVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe165030Temp(Ye165030TempVO vo) throws Exception {
        delete("ye165030Temp_2019_DAO.deleteYe165030Temp_S", vo);
    }

    /**
	 * YE165030_TEMP?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye165030TempVO
	 * @return 조회?�� YE165030_TEMP
	 * @exception Exception
	 */
    public Ye165030TempVO selectYe165030Temp(Ye165030TempVO vo) throws Exception {
        return (Ye165030TempVO) selectByPk("ye165030Temp_2019_DAO.selectYe165030Temp_S", vo);
    }

    /**
	 * YE165030_TEMP 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165030_TEMP 목록
	 * @exception Exception
	 */
    public List<?> selectYe165030TempList(Ye165030TempSrh_2019_VO searchVO) throws Exception {
        return list("ye165030Temp_2019_DAO.selectYe165030TempList_D", searchVO);
    }

    /**
	 * YE165030_TEMP �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165030_TEMP �? �??��
	 * @exception
	 */
    public int selectYe165030TempListTotCnt(Ye165030TempSrh_2019_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye165030Temp_2019_DAO.selectYe165030TempListTotCnt_S", searchVO);
    }

}
