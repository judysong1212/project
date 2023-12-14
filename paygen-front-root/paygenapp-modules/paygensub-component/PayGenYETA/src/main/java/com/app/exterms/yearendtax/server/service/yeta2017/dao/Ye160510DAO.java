package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye160510SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye160510VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye160510DAO.java
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

@Repository("Ye160510DAO")
public class Ye160510DAO extends EgovAbstractDAO {

	/**
	 * YE160510?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye160510VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe160510(Ye160510VO vo) throws Exception {
        return (String)insert("ye160510DAO.insertYe160510_S", vo);
    }

    /**
	 * YE160510?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye160510VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe160510(Ye160510VO vo) throws Exception {
        update("ye160510DAO.updateYe160510_S", vo);
    }

    /**
	 * YE160510?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye160510VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe160510(Ye160510VO vo) throws Exception {
        delete("ye160510DAO.deleteYe160510_S", vo);
    }

    /**
	 * YE160510?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye160510VO
	 * @return 조회?�� YE160510
	 * @exception Exception
	 */
    public Ye160510VO selectYe160510(Ye160510VO vo) throws Exception {
        return (Ye160510VO) selectByPk("ye160510DAO.selectYe160510_S", vo);
    }

    /**
	 * YE160510 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE160510 목록
	 * @exception Exception
	 */
    public List<?> selectYe160510List(Ye160510SrhVO searchVO) throws Exception {
        return list("ye160510DAO.selectYe160510List_D", searchVO);
    }

    /**
	 * YE160510 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE160510 �? �??��
	 * @exception
	 */
    public int selectYe160510ListTotCnt(Ye160510SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye160510DAO.selectYe160510ListTotCnt_S", searchVO);
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
     * @Method Name : deleteYetaP210001_Ye160510VO_2017_Delete
     * @date : 2018. 1. 8.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2018. 1. 8.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @throws Exception
     */
    public void deleteYetaP210001_Ye160510VO_2017_Delete(Ye160510VO vo) throws Exception {
        delete("ye160510DAO.deleteYetaP210001_Ye160510VO_2017_Delete_S", vo);
    }       
        
     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
      ***********************************************************************************/
    
}
