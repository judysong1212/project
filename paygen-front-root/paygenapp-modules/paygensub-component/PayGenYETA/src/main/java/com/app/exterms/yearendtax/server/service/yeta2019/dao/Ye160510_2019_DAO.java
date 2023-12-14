package com.app.exterms.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye160510Srh_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye160510_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye160510_2019_DAO.java
 * @Description : Ye160510 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye160510_2019_DAO")
public class Ye160510_2019_DAO extends EgovAbstractDAO {

	/**
	 * YE160510?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye160510_2019_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe160510(Ye160510_2019_VO vo) throws Exception {
        return (String)insert("ye160510_2019_DAO.insertYe160510_S", vo);
    }

    /**
	 * YE160510?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye160510_2019_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe160510(Ye160510_2019_VO vo) throws Exception {
        update("ye160510_2019_DAO.updateYe160510_S", vo);
    }

    /**
	 * YE160510?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye160510_2019_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe160510(Ye160510_2019_VO vo) throws Exception {
        delete("ye160510_2019_DAO.deleteYe160510_S", vo);
    }

    /**
	 * YE160510?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye160510_2019_VO
	 * @return 조회?�� YE160510
	 * @exception Exception
	 */
    public Ye160510_2019_VO selectYe160510(Ye160510_2019_VO vo) throws Exception {
        return (Ye160510_2019_VO) selectByPk("ye160510_2019_DAO.selectYe160510_S", vo);
    }

    /**
	 * YE160510 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE160510 목록
	 * @exception Exception
	 */
    public List<?> selectYe160510List(Ye160510Srh_2019_VO search_2019_VO) throws Exception {
        return list("ye160510_2019_DAO.selectYe160510List_D", search_2019_VO);
    }

    /**
	 * YE160510 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE160510 �? �??��
	 * @exception
	 */
    public int selectYe160510ListTotCnt(Ye160510Srh_2019_VO search_2019_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye160510_2019_DAO.selectYe160510ListTotCnt_S", search_2019_VO);
    }

  
    /***********************************************************************************
     * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
     ***********************************************************************************/

    /**
     * 
     * <pre>
     * 1. 개요 : 근무지별비과세_감면소득 
     * 2. 처리내용 : 근무지별비과세_감면소득 
     * </pre>
     * @Method Name : deleteYetaP410001_Ye160510_2019_VO_2019_Delete
     * @date : 2019. 1. 8.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2019. 1. 8.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @throws Exception
     */
    public void deleteYetaP410001_Ye160510_2019_VO_2019_Delete(Ye160510_2019_VO vo) throws Exception {
        delete("ye160510_2019_DAO.deleteYetaP410001_Ye160510_2019_VO_2019_Delete_S", vo);
    }       
        
     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
      ***********************************************************************************/
    
}
