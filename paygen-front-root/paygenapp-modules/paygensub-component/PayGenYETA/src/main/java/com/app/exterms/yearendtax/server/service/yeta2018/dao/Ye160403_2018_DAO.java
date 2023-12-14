package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye160403Srh_2018_VO;
import com.app.exterms.yearendtax.server.vo.Ye160403_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye160403_2018_DAO.java
 * @since : 2018. 1. 7. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye160403_2018_DAO")
public class Ye160403_2018_DAO extends EgovAbstractDAO {
	
	

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
	public List selectYetaP33008ToYe160403List(Ye160403Srh_2018_VO Ye160403SrhVo)throws Exception {
		return list("ye160403_2018_DAO.seleteYetaP33008ToYe160403_D", Ye160403SrhVo);
	}

//	/**
//	 * Ye160403 총 갯수를 조회한다.
//	 * @param Ye160403SrhVO - 조회할 정보가 담긴 Ye160403SrhVo
//	 * @return Ye160403 총 갯수
//	 * @exception
//	 */
//	@SuppressWarnings("deprecation")
//	public int selectYetaP33008ToYe160403ListtTotCnt(Ye160403SrhVO Ye160403SrhVo) {
//		return (Integer) getSqlMapClientTemplate().queryForObject("Ye160403_2018_DAO.seleteYetaP33008ToYe160403ListCnt_S", Ye160403SrhVo);
//	}	
//	
//	
//	/**
//	 * Ye160403 을 등록한다.
//	 * @param Ye160403VO - 등록할 정보가 담긴 Ye160403VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String insertYetaP33008ToYe160403(Ye160403VO vo) throws Exception {
//        return (String)insert("Ye160403_2018_DAO.insertYetaP33008ToYe160403_S", vo);
//    }
    
	/**
	 * Ye160403 을 수정한다.
	 * @param Ye160403VO - 수정할 정보가 담긴 Ye160403VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYetaP33008ToYe160403(Ye160403_2018_VO vo) throws Exception {
        update("ye160403_2018_DAO.updateYetaP33008ToYe160403_S", vo);
    }
    
	/**
	 * Ye160403 을 삭제한다.
	 * @param Ye160403VO - 삭제할 정보가 담긴 Ye160403VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYetaP33008ToYe160403(Ye160403_2018_VO vo) throws Exception {
        delete("ye160403_2018_DAO.deleteYetaP33008ToYe160403_S", vo);
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
    public String insertYe160403(Ye160403_2018_VO vo) throws Exception {
        return (String)insert("ye160403_2018_DAO.insertYe160403_S", vo);
    }

    /**
	 * YE160403???�정?�다.
	 * @param vo - ?�정???�보�??�긴 Ye160403VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe160403(Ye160403_2018_VO vo) throws Exception {
        update("ye160403_2018_DAO.updateYe160403_S", vo);
    }

    /**
	 * YE160403????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160403VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe160403(Ye160403_2018_VO vo) throws Exception {
        delete("ye160403_2018_DAO.deleteYe160403_S", vo);
    }
    
    
    public void deleteYetaP110001_Ye160403_2016_CREATE_Delete(Ye160403_2018_VO vo) throws Exception {
        delete("ye16Ta160403_2018_DAO.fnYeta1100_YE160403_2016_CREATE_Delete_S", vo);
    }
    
    
    /**
	 * YE160403????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160403VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYeta3100ToYe160403(Ye160403_2018_VO vo) throws Exception {
        delete("ye160403_2018_DAO.deleteYeta3100ToYe160403_S", vo);
    }
    
    
    
    /**
	 * YE160402????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160402VO
	 * @return void??
	 * @exception Exception
	 */
    public void fnYeta3100_Ye160403_CREATE_Delete(Ye160403_2018_VO vo) throws Exception {
        delete("ye160403_2018_DAO.fnYeta3100_Ye160403_CREATE_Delete", vo);
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
     * @Method Name : deleteYetaP310001_Ye160403VO_2018_Delete
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
    public void deleteYetaP310001_Ye160403VO_2018_Delete(Ye160403_2018_VO vo) throws Exception {
        delete("ye160403_2018_DAO.deleteYetaP310001_Ye160403VO_2018_Delete_S", vo);
    }
    
     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
      ***********************************************************************************/
    

}
