package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye161030SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye161030VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye161030DAO.java
 * @since : 2017. 12. 17. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye161030DAO")
public class Ye161030DAO extends EgovAbstractDAO {

	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE161030 목록을 조회한다.
	 * @param Ye161030SrhVO - 조회할 정보가 담긴 ye161030SrhVo
	 * @return YE161030 목록
	 * @exception Exception
	 */
	public List selectYeta23001ToYe161030List(Ye161030SrhVO ye161030SrhVo)throws Exception {
		return list("ye161030DAO.seleteYeta2300ToYe161030_D", ye161030SrhVo);
	}

	/**
	 * YE161030 총 갯수를 조회한다.(종전근무지 팝업)
	 * @param Ye161030SrhVO - 조회할 정보가 담긴 ye161030SrhVo
	 * @return YE161030 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectYeta23001ToYe161030ListtTotCnt(Ye161030SrhVO ye161030SrhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ye161030DAO.seleteYeta2300ToYe161030ListCnt_S", ye161030SrhVo);
	}	
	
	
	/**
	 * YE161030 을 등록한다.
	 * @param Ye161030VO - 등록할 정보가 담긴 Ye161030VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYeta2300ToYe161030(Ye161030VO vo) throws Exception {
        return (String)insert("ye161030DAO.insertYeta2300ToYe161030_S", vo);
    }
    
	/**
	 * YE161030 을 수정한다.
	 * @param Ye161030VO - 수정할 정보가 담긴 Ye161030VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYeta2300ToYe161030(Ye161030VO vo) throws Exception {
        update("ye161030DAO.updateYeta2300ToYe161030_S", vo);
    }
    
	/**
	 * YE161030 을 삭제한다.
	 * @param Ye161030VO - 삭제할 정보가 담긴 Ye161030VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYeta2300ToYe161030(Ye161030VO vo) throws Exception {
        delete("ye161030DAO.deleteYeta2300ToYe161030_S", vo);
    }	
	
	
    /** +++++++++++++++++++++++++++++YetaP210001 화면호출 +++++++++++++++++++++++++++  **/ 
    
    public void deleteYetaP210001_Ye161030VO_2017_Delete(Ye161030VO vo) throws Exception {
        delete("ye161030DAO.deleteYetaP210001_Ye161030VO_2017_Delete_S", vo);
    }
    
    
    
    
	/**    
     * #############################################
     * 2017년도 연말정산 구현 종료
     * #############################################
     *   **/	

}
