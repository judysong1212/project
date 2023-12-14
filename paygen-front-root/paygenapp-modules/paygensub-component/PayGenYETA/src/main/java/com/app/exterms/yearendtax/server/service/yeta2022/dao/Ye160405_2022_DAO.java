package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye160405Srh_2022_VO;
import com.app.exterms.yearendtax.server.vo.Ye160405_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye160405_2022_DAO.java
 * @Description : Ye160405 DAO Class
 * @Modification Information
 *
 * @author DaEun
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye160405_2022_DAO")
public class Ye160405_2022_DAO extends EgovAbstractDAO {
	
	
	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * Ye160405 목록을 조회한다.
	 * @param Ye160405Srh_2022_VO - 조회할 정보가 담긴 Ye160405SrhVo
	 * @return Ye160405 목록
	 * @exception Exception
	 */
	public List selectYetaP730010ToYe160405List(Ye160405Srh_2022_VO Ye160405SrhVo)throws Exception {
		return list("ye160405_2022_DAO.seleteYetaP730010ToYe160405_D", Ye160405SrhVo);
	}

//	/**
//	 * Ye160405 총 갯수를 조회한다.
//	 * @param Ye160405Srh_2022_VO - 조회할 정보가 담긴 Ye160405SrhVo
//	 * @return Ye160405 총 갯수
//	 * @exception
//	 */
//	@SuppressWarnings("deprecation")
//	public int selectYetaP730010ToYe160405ListtTotCnt(Ye160405Srh_2022_VO Ye160405SrhVo) {
//		return (Integer) getSqlMapClientTemplate().queryForObject("Ye160405_2022_DAO.seleteYetaP730010ToYe160405ListCnt_S", Ye160405SrhVo);
//	}	
//	
//	
	/**
	 * Ye160405 을 등록한다.
	 * @param Ye160405_2022_VO - 등록할 정보가 담긴 Ye160405_2022_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYetaP73006ToYe160405(Ye160405_2022_VO vo) throws Exception {
        return (String)insert("ye160405_2022_DAO.insertYetaP73006ToYe160405_S", vo);
    }
    
	/**
	 * Ye160405 을 수정한다.
	 * @param Ye160405_2022_VO - 수정할 정보가 담긴 Ye160405_2022_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public int updateYetaP730010ToYe160405(Ye160405_2022_VO vo) throws Exception {
      return update("ye160405_2022_DAO.updateYetaP730010ToYe160405_S", vo);
    }
    
	/**
	 * Ye160405 을 삭제한다.
	 * @param Ye160405_2022_VO - 삭제할 정보가 담긴 Ye160405_2022_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYetaP73006ToYe160405(Ye160405_2022_VO vo) throws Exception {
        delete("ye160405_2022_DAO.deleteYetaP73006ToYe160405_S", vo);
    }	
	
	/**    
     * #############################################
     * 2017년도 연말정산 구현 종료
     * #############################################
     *   **/		
	
	

	/**
	 * YE160405???�록?�다.
	 * @param vo - ?�록???�보�??�긴 Ye160405_2022_VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertYe160405(Ye160405_2022_VO vo) throws Exception {
        return (String)insert("ye160405_2022_DAO.insertYe160405_S", vo);
    }

    /**
	 * YE160405???�정?�다.
	 * @param vo - ?�정???�보�??�긴 Ye160405_2022_VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe160405(Ye160405_2022_VO vo) throws Exception {
        update("ye160405_2022_DAO.updateYe160405_S", vo);
    }

    /**
	 * YE160405????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160405_2022_VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe160405(Ye160405_2022_VO vo) throws Exception {
        delete("ye160405_2022_DAO.deleteYe160405_S", vo);
    }


/***********************************************************************************
 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
 ***********************************************************************************/
       
    /**
     * 
     * <pre>
     * 1. 개요 :  D_종전근무처비과세_감면소득_비과세  
     * 2. 처리내용 : D_종전근무처비과세_감면소득_비과세  삭제 
     * </pre>
     * @Method Name : deleteYetaP710001_Ye160405_2022_VO_2022_Delete
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
    public void deleteYetaP710001_Ye160405_2022_VO_2022_Delete(Ye160405_2022_VO vo) throws Exception {
        delete("ye160405_2022_DAO.deleteYetaP710001_Ye160405_2022_VO_2022_Delete_S", vo);
    }
    
/***********************************************************************************
 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
 ***********************************************************************************/
    

}