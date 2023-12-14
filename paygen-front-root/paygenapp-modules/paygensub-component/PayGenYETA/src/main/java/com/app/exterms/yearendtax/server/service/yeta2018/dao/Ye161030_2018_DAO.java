package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye161030Srh_2018_VO;
import com.app.exterms.yearendtax.server.vo.Ye161030_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye161030_2018_DAO.java
 * @since : 2017. 12. 17. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye161030_2018_DAO")
public class Ye161030_2018_DAO extends EgovAbstractDAO {

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
	public List selectYeta33001ToYe161030List(Ye161030Srh_2018_VO ye161030SrhVo)throws Exception {
		return list("ye161030_2018_DAO.seleteYeta3300ToYe161030_D", ye161030SrhVo);
	}

	/**
	 * YE161030 총 갯수를 조회한다.(종전근무지 팝업)
	 * @param Ye161030SrhVO - 조회할 정보가 담긴 ye161030SrhVo
	 * @return YE161030 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectYeta33001ToYe161030ListtTotCnt(Ye161030Srh_2018_VO ye161030SrhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ye161030_2018_DAO.seleteYeta3300ToYe161030ListCnt_S", ye161030SrhVo);
	}	
	
	
	/**
	 * YE161030 을 등록한다.
	 * @param Ye161030VO - 등록할 정보가 담긴 Ye161030VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYeta3300ToYe161030(Ye161030_2018_VO vo) throws Exception {
        return (String)insert("ye161030_2018_DAO.insertYeta3300ToYe161030_S", vo);
    }
    
	/**
	 * YE161030 을 수정한다.
	 * @param Ye161030VO - 수정할 정보가 담긴 Ye161030VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYeta3300ToYe161030(Ye161030_2018_VO vo) throws Exception {
        update("ye161030_2018_DAO.updateYeta3300ToYe161030_S", vo);
    }
    
	/**
	 * YE161030 을 삭제한다.
	 * @param Ye161030VO - 삭제할 정보가 담긴 Ye161030VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYeta3300ToYe161030(Ye161030_2018_VO vo) throws Exception {
        delete("ye161030_2018_DAO.deleteYeta3300ToYe161030_S", vo);
    }	
	
	
    /** +++++++++++++++++++++++++++++YetaP310001 화면호출 +++++++++++++++++++++++++++  **/ 
    
    public void deleteYetaP310001_Ye161030VO_2018_Delete(Ye161030_2018_VO vo) throws Exception {
        delete("ye161030_2018_DAO.deleteYetaP310001_Ye161030VO_2018_Delete_S", vo);
    }
    
    
    
    
	/**    
     * #############################################
     * 2017년도 연말정산 구현 종료
     * #############################################
     *   **/	

}
