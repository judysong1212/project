package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye162010SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye162010VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye162010DAO.java
 * @since : 2017. 12. 20. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye162010DAO")
public class Ye162010DAO extends EgovAbstractDAO {
	
	
	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE162010 목록을 조회한다.
	 * @param Ye162010SrhVO - 조회할 정보가 담긴 ye162010SrhVo
	 * @return YE162010 목록
	 * @exception Exception
	 */
	public List selectYetaP23007ToYe162010List(Ye162010SrhVO ye162010SrhVo)throws Exception {
		return list("ye162010DAO.seleteYetaP23007ToYe162010_D", ye162010SrhVo);
	}

	/**
	 * YE162010 총 갯수를 조회한다.
	 * @param Ye162010SrhVO - 조회할 정보가 담긴 ye162010SrhVo
	 * @return YE162010 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectYetaP23007ToYe162010ListTotCnt(Ye162010SrhVO ye162010SrhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ye162010DAO.seleteYetaP23007ToYe162010ListCnt_S", ye162010SrhVo);
	}	
	
	
	/**
	 * YE162010 을 등록한다.
	 * @param Ye162010VO - 등록할 정보가 담긴 Ye162010VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYetaP23007ToYe162010(Ye162010VO vo) throws Exception {
        return (String)insert("ye162010DAO.insertYetaP23007ToYe162010_S", vo);
    }
    
	/**
	 * YE162010 을 수정한다.
	 * @param Ye162010VO - 수정할 정보가 담긴 Ye162010VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYetaP23007ToYe162010(Ye162010VO vo) throws Exception {
        update("ye162010DAO.updateYetaP23007ToYe162010_S", vo);
    }
    
	/**
	 * YE162010 을 삭제한다.
	 * @param Ye162010VO - 삭제할 정보가 담긴 Ye162010VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYetaP23007ToYe162010(Ye162010VO vo) throws Exception {
        delete("ye162010DAO.deleteYetaP23007ToYe162010_S", vo);	
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
    
    public void deleteYetaP210001_Ye162010VO_2017_Delete(Ye162010VO vo) throws Exception {
        delete("ye162010DAO.deleteYetaP210001_Ye162010VO_2017_Delete_S", vo);	
    }
    
     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
      ***********************************************************************************/
    
    
    


}
