package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye162520Srh_2018_VO;
import com.app.exterms.yearendtax.server.vo.Ye162520_2018_VO;
import com.app.exterms.yearendtax.server.vo.Ye162520_2018_VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye162520_2018_DAO.java
 * @Description : Ye162520 DAO Class
 * @Modification Information
 *
 * @author Kim ji eun
 * @since 2016.12.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye162520_2018_DAO")
public class Ye162520_2018_DAO extends EgovAbstractDAO implements IsSerializable {
	
	
	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE162520 목록을 조회한다.
	 * @param Ye162520SrhVO - 조회할 정보가 담긴 ye162520SrhVo
	 * @return YE162520 목록
	 * @exception Exception
	 */
	public List selectYetaP33004ToYe162520List(Ye162520Srh_2018_VO ye162520SrhVo)throws Exception {
		return list("ye162520_2018_DAO.seleteYetaP33004ToYe162520_D", ye162520SrhVo);
	}

	/**
	 * YE162520 총 갯수를 조회한다.
	 * @param Ye162520SrhVO - 조회할 정보가 담긴 ye162520SrhVo
	 * @return YE162520 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectYetaP33004ToYe162520ListTotCnt(Ye162520Srh_2018_VO ye162520SrhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ye162520_2018_DAO.seleteYetaP33004ToYe162520ListCnt_S", ye162520SrhVo);
	}	
	
	
	/**
	 * YE162520 을 등록한다.
	 * @param Ye162520VO - 등록할 정보가 담긴 Ye162520VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYetaP33004ToYe162520(Ye162520_2018_VO vo) throws Exception {
        return (String)insert("ye162520_2018_DAO.insertYetaP33004ToYe162520_S", vo);
    }
    
	/**
	 * YE162520 을 수정한다.
	 * @param Ye162520VO - 수정할 정보가 담긴 Ye162520VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYetaP33004ToYe162520(Ye162520_2018_VO vo) throws Exception {
        update("ye162520_2018_DAO.updateYetaP33004ToYe162520_S", vo);
    }
    
	/**
	 * YE162520 을 삭제한다.
	 * @param Ye162520VO - 삭제할 정보가 담긴 Ye162520VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYetaP33004ToYe162520(Ye162520_2018_VO vo) throws Exception {
        delete("ye162520_2018_DAO.deleteYetaP33004ToYe162520_S", vo);	
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
    
    public void deleteYetaP310001_Ye162520VO_2018_Delete(Ye162520_2018_VO vo) throws Exception {
        delete("ye162520_2018_DAO.deleteYetaP310001_Ye162520VO_2018_Delete_S", vo);	
    }
    
     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
      ***********************************************************************************/	
	
    
	

	  
    /**
	 * YE162520 목록을 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 금전소비대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162520 목록
	 * @exception Exception
	 */
    public List selectYetaP03004To162520List(Ye162520_2018_VO searchVO) throws Exception {
        return list("ye162520_2018_DAO.selectYetaP03004To162520List_D", searchVO);
    }

    /**
	 * YE162520 총 갯수를 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 금전소비대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162520 총 갯수
	 * @exception
	 */
    public int selectYetaP03004To162520ListTotCnt(Ye162520_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye162520_2018_DAO.selectYetaP03004To162520ListTotCnt_S", searchVO);
    }


}