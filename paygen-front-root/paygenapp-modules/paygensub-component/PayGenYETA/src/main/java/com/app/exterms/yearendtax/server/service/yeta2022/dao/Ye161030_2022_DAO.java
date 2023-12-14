package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye161030Srh_2022_VO;
import com.app.exterms.yearendtax.server.vo.Ye161030_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye161030_2022_DAO.java
 * @since : 2017. 12. 17. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye161030_2022_DAO")
public class Ye161030_2022_DAO extends EgovAbstractDAO {

	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE161030 목록을 조회한다.
	 * @param Ye161030Srh_2022_VO - 조회할 정보가 담긴 ye161030SrhVo
	 * @return YE161030 목록
	 * @exception Exception
	 */
	public List selectYeta73001ToYe161030List(Ye161030Srh_2022_VO ye161030SrhVo)throws Exception {
		return list("ye161030_2022_DAO.seleteYeta7300ToYe161030_D", ye161030SrhVo);
	}

	/**
	 * YE161030 총 갯수를 조회한다.(종전근무지 팝업)
	 * @param Ye161030Srh_2022_VO - 조회할 정보가 담긴 ye161030SrhVo
	 * @return YE161030 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectYeta73001ToYe161030ListtTotCnt(Ye161030Srh_2022_VO ye161030SrhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ye161030_2022_DAO.seleteYeta7300ToYe161030ListCnt_S", ye161030SrhVo);
	}	
	
	
	/**
	 * YE161030 을 등록한다.
	 * @param Ye161030_2022_VO - 등록할 정보가 담긴 Ye161030_2022_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYeta7300ToYe161030(Ye161030_2022_VO vo) throws Exception {
        return (String)insert("ye161030_2022_DAO.insertYeta7300ToYe161030_S", vo);
    }
    
	/**
	 * YE161030 을 수정한다.
	 * @param Ye161030_2022_VO - 수정할 정보가 담긴 Ye161030_2022_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYeta7300ToYe161030(Ye161030_2022_VO vo) throws Exception {
        update("ye161030_2022_DAO.updateYeta7300ToYe161030_S", vo);
    }
    
	/**
	 * YE161030 을 삭제한다.
	 * @param Ye161030_2022_VO - 삭제할 정보가 담긴 Ye161030_2022_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYeta7300ToYe161030(Ye161030_2022_VO vo) throws Exception {
        delete("ye161030_2022_DAO.deleteYeta7300ToYe161030_S", vo);
    }	
	
	
    /** +++++++++++++++++++++++++++++YetaP710001 화면호출 +++++++++++++++++++++++++++  **/ 
    
    public void deleteYetaP710001_Ye161030_2022_VO_2022_Delete(Ye161030_2022_VO vo) throws Exception {
        delete("ye161030_2022_DAO.deleteYetaP710001_Ye161030_2022_VO_2022_Delete_S", vo);
    }
    
    
    
    
	/**    
     * #############################################
     * 2017년도 연말정산 구현 종료
     * #############################################
     *   **/	

}
