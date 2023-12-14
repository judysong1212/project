package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye161030Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161030_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye161030_2020_DAO.java
 * @since : 2017. 12. 17. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye161030_2020_DAO")
public class Ye161030_2020_DAO extends EgovAbstractDAO {

	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE161030 목록을 조회한다.
	 * @param Ye161030Srh_2020_VO - 조회할 정보가 담긴 ye161030SrhVo
	 * @return YE161030 목록
	 * @exception Exception
	 */
	public List selectYeta53001ToYe161030List(Ye161030Srh_2020_VO ye161030SrhVo)throws Exception {
		return list("ye161030_2020_DAO.seleteYeta5300ToYe161030_D", ye161030SrhVo);
	}

	/**
	 * YE161030 총 갯수를 조회한다.(종전근무지 팝업)
	 * @param Ye161030Srh_2020_VO - 조회할 정보가 담긴 ye161030SrhVo
	 * @return YE161030 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectYeta53001ToYe161030ListtTotCnt(Ye161030Srh_2020_VO ye161030SrhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ye161030_2020_DAO.seleteYeta5300ToYe161030ListCnt_S", ye161030SrhVo);
	}	
	
	
	/**
	 * YE161030 을 등록한다.
	 * @param Ye161030_2020_VO - 등록할 정보가 담긴 Ye161030_2020_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYeta5300ToYe161030(Ye161030_2020_VO vo) throws Exception {
        return (String)insert("ye161030_2020_DAO.insertYeta5300ToYe161030_S", vo);
    }
    
	/**
	 * YE161030 을 수정한다.
	 * @param Ye161030_2020_VO - 수정할 정보가 담긴 Ye161030_2020_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYeta5300ToYe161030(Ye161030_2020_VO vo) throws Exception {
        update("ye161030_2020_DAO.updateYeta5300ToYe161030_S", vo);
    }
    
	/**
	 * YE161030 을 삭제한다.
	 * @param Ye161030_2020_VO - 삭제할 정보가 담긴 Ye161030_2020_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYeta5300ToYe161030(Ye161030_2020_VO vo) throws Exception {
        delete("ye161030_2020_DAO.deleteYeta5300ToYe161030_S", vo);
    }	
	
	
    /** +++++++++++++++++++++++++++++YetaP510001 화면호출 +++++++++++++++++++++++++++  **/ 
    
    public void deleteYetaP510001_Ye161030_2020_VO_2020_Delete(Ye161030_2020_VO vo) throws Exception {
        delete("ye161030_2020_DAO.deleteYetaP510001_Ye161030_2020_VO_2020_Delete_S", vo);
    }
    
    
    
    
	/**    
     * #############################################
     * 2017년도 연말정산 구현 종료
     * #############################################
     *   **/	

}
