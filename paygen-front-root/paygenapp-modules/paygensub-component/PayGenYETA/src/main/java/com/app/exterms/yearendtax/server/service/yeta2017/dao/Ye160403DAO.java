package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye160403SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye160403VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye160403DAO.java
 * @since : 2018. 1. 7. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye160403DAO")
public class Ye160403DAO extends EgovAbstractDAO {
	
	

	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * Ye160403 목록을 조회한다.
	 * @param Ye160403SrhVO - 조회할 정보가 담긴 Ye160403SrhVo
	 * @return Ye160403 목록
	 * @exception Exception
	 */
	public List selectYetaP23008ToYe160403List(Ye160403SrhVO Ye160403SrhVo)throws Exception {
		return list("ye160403DAO.seleteYetaP23008ToYe160403_D", Ye160403SrhVo);
	}

//	/**
//	 * Ye160403 총 갯수를 조회한다.
//	 * @param Ye160403SrhVO - 조회할 정보가 담긴 Ye160403SrhVo
//	 * @return Ye160403 총 갯수
//	 * @exception
//	 */
//	@SuppressWarnings("deprecation")
//	public int selectYetaP23008ToYe160403ListtTotCnt(Ye160403SrhVO Ye160403SrhVo) {
//		return (Integer) getSqlMapClientTemplate().queryForObject("Ye160403DAO.seleteYetaP23008ToYe160403ListCnt_S", Ye160403SrhVo);
//	}	
//	
//	
//	/**
//	 * Ye160403 을 등록한다.
//	 * @param Ye160403VO - 등록할 정보가 담긴 Ye160403VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String insertYetaP23008ToYe160403(Ye160403VO vo) throws Exception {
//        return (String)insert("Ye160403DAO.insertYetaP23008ToYe160403_S", vo);
//    }
    
	/**
	 * Ye160403 을 수정한다.
	 * @param Ye160403VO - 수정할 정보가 담긴 Ye160403VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYetaP23008ToYe160403(Ye160403VO vo) throws Exception {
        update("ye160403DAO.updateYetaP23008ToYe160403_S", vo);
    }
    
	/**
	 * Ye160403 을 삭제한다.
	 * @param Ye160403VO - 삭제할 정보가 담긴 Ye160403VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYetaP23008ToYe160403(Ye160403VO vo) throws Exception {
        delete("ye160403DAO.deleteYetaP23008ToYe160403_S", vo);
    }	
	
	/**    
     * #############################################
     * 2017년도 연말정산 구현 종료
     * #############################################
     *   **/	
	
	
	
	
	

	/**
	 * YE160403???�록?�다.
	 * @param vo - ?�록???�보�??�긴 Ye160403VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertYe160403(Ye160403VO vo) throws Exception {
        return (String)insert("ye160403DAO.insertYe160403_S", vo);
    }

    /**
	 * YE160403???�정?�다.
	 * @param vo - ?�정???�보�??�긴 Ye160403VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe160403(Ye160403VO vo) throws Exception {
        update("ye160403DAO.updateYe160403_S", vo);
    }

    /**
	 * YE160403????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160403VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe160403(Ye160403VO vo) throws Exception {
        delete("ye160403DAO.deleteYe160403_S", vo);
    }
    
    
    public void deleteYetaP110001_Ye160403_2016_CREATE_Delete(Ye160403VO vo) throws Exception {
        delete("ye16Ta160403DAO.fnYeta1100_YE160403_2016_CREATE_Delete_S", vo);
    }
    
    
    /**
	 * YE160403????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160403VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYeta2100ToYe160403(Ye160403VO vo) throws Exception {
        delete("ye160403DAO.deleteYeta2100ToYe160403_S", vo);
    }
    
    
    
    /**
	 * YE160402????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160402VO
	 * @return void??
	 * @exception Exception
	 */
    public void fnYeta2100_Ye160403_CREATE_Delete(Ye160403VO vo) throws Exception {
        delete("ye160403DAO.fnYeta2100_Ye160403_CREATE_Delete", vo);
    }
    
 
    /***********************************************************************************
     * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
     ***********************************************************************************/
   	
    /**
     *     
     * <pre>
     * 1. 개요 : 현근무지비과세_감면소득_비과세
     * 2. 처리내용 : 현근무지비과세_감면소득_비과세 삭제 
     * </pre>
     * @Method Name : deleteYetaP210001_Ye160403VO_2017_Delete
     * @date : 2018. 1. 8.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2018. 1. 8.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param  Ye160403VO vo
     * @throws Exception
     */
    public void deleteYetaP210001_Ye160403VO_2017_Delete(Ye160403VO vo) throws Exception {
        delete("ye160403DAO.deleteYetaP210001_Ye160403VO_2017_Delete_S", vo);
    }
    
     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
      ***********************************************************************************/
    

}
