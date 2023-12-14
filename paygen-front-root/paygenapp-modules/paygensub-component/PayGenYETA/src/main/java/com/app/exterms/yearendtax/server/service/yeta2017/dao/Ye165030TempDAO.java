package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye165030TempSrhVO;
import com.app.exterms.yearendtax.server.vo.Ye165030TempVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye165030TempDAO.java
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

@Repository("Ye165030TempDAO")
public class Ye165030TempDAO extends EgovAbstractDAO {

	
	
	/***********************************************************************************
	 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
	 ***********************************************************************************/
	   
	  /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/      
    public void deleteYetaP210001_Ye165030TempVO_2017_Delete(Ye165030TempVO vo) throws Exception {
        delete("ye165030TempDAO.deleteYetaP210001_Ye165030TempVO_2017_Delete_S", vo);
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
        return (String)insert("ye165030TempDAO.insertYe165030Temp_S", vo);
    }

    /**
	 * YE165030_TEMP?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165030TempVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe165030Temp(Ye165030TempVO vo) throws Exception {
        update("ye165030TempDAO.updateYe165030Temp_S", vo);
    }

    /**
	 * YE165030_TEMP?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165030TempVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe165030Temp(Ye165030TempVO vo) throws Exception {
        delete("ye165030TempDAO.deleteYe165030Temp_S", vo);
    }

    /**
	 * YE165030_TEMP?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye165030TempVO
	 * @return 조회?�� YE165030_TEMP
	 * @exception Exception
	 */
    public Ye165030TempVO selectYe165030Temp(Ye165030TempVO vo) throws Exception {
        return (Ye165030TempVO) selectByPk("ye165030TempDAO.selectYe165030Temp_S", vo);
    }

    /**
	 * YE165030_TEMP 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165030_TEMP 목록
	 * @exception Exception
	 */
    public List<?> selectYe165030TempList(Ye165030TempSrhVO searchVO) throws Exception {
        return list("ye165030TempDAO.selectYe165030TempList_D", searchVO);
    }

    /**
	 * YE165030_TEMP �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165030_TEMP �? �??��
	 * @exception
	 */
    public int selectYe165030TempListTotCnt(Ye165030TempSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye165030TempDAO.selectYe165030TempListTotCnt_S", searchVO);
    }

}
