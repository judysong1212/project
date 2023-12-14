package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye161020Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161020_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161020_2020_DAO.java
 * @Description : Ye161020 DAO Class
 * @Modification Information
 *
 * @author DaEun, Bae
 * @since 2017.01.04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye161020_2020_DAO")
public class Ye161020_2020_DAO extends EgovAbstractDAO {
	
	
	
	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE161020 목록을 조회한다.
	 * @param Ye161020Srh_2020_VO - 조회할 정보가 담긴 ye161020SrhVo
	 * @return YE161020 목록
	 * @exception Exception
	 */
	public List selectYeta5300ToYe161020Data(Ye161020Srh_2020_VO ye161020SrhVo)throws Exception {
		return list("ye161020_2020_DAO.seleteYeta5300ToYe161020_D", ye161020SrhVo);
	}

	/**
	 * YE161020 총 갯수를 조회한다.
	 * @param Ye161020Srh_2020_VO - 조회할 정보가 담긴 ye161020SrhVo
	 * @return YE161020 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectYeta5300ToYe161020ListtTotCnt(Ye161020Srh_2020_VO ye161020SrhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ye161020_2020_DAO.seleteYeta5300ToYe161020ListCnt_S", ye161020SrhVo);
	}	
//	
//	
//	/**
//	 * YE161020 을 등록한다.
//	 * @param Ye161020_2020_VO - 등록할 정보가 담긴 Ye161020_2020_VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String insertYeta5300ToYe161020(Ye161020_2020_VO vo) throws Exception {
//        return (String)insert("ye161020_2020_DAO.insertYeta5300ToYe161020_S", vo);
//    }
    
	/**
	 * YE161020 을 수정한다.
	 * @param Ye161020_2020_VO - 수정할 정보가 담긴 Ye161020_2020_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYeta5300Item01ToYe161020(Ye161020_2020_VO vo) throws Exception {
        update("ye161020_2020_DAO.updateYeta5300Item01ToYe161020_S", vo);
    }
    
    public void updateYeta5300Item02ToYe161020(Ye161020_2020_VO vo) throws Exception {
        update("ye161020_2020_DAO.updateYeta5300Item02ToYe161020_S", vo);
    }
    
    
    public void updateYetaP510002ToYe161020(Ye161020_2020_VO vo) throws Exception {
        update("ye161020_2020_DAO.updateYetaP510002ToYe161020_S", vo);
    }
    
//	/**
//	 * YE161020 을 삭제한다.
//	 * @param Ye161020_2020_VO - 삭제할 정보가 담긴 Ye161020_2020_VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public void deleteYeta5300ToYe161020(Ye161020_2020_VO vo) throws Exception {
//        delete("ye161020_2020_DAO.deleteYeta5300ToYe161020_S", vo);
//    }	
	
    public void deleteYetaP510001_Ye161020_2020_VO_2020_Delete(Ye161020_2020_VO vo) throws Exception {
        delete("ye161020_2020_DAO.deleteYetaP510001_Ye161020_2020_VO_2020_Delete_S", vo);
    }
    
    
    
	/**    
     * #############################################
     * 2017년도 연말정산 구현 종료
     * #############################################
     *   **/	
	
	
	
	
	

	/**
	 * YE161020???�록?�다.
	 * @param vo - ?�록???�보�??�긴 Ye161020_2020_VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertYe161020(Ye161020_2020_VO vo) throws Exception {
        return (String)insert("ye161020_2020_DAO.insertYe161020_S", vo);
    }

    /**
	 * YE161020???�정?�다.
	 * @param vo - ?�정???�보�??�긴 Ye161020_2020_VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe161020(Ye161020_2020_VO vo) throws Exception {
        update("ye161020_2020_DAO.updateYe161020_S", vo);
    }

    /**
	 * YE161020????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye161020_2020_VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe161020(Ye161020_2020_VO vo) throws Exception {
        delete("ye161020_2020_DAO.deleteYe161020_S", vo);
    }
    
    
    /**
	 * YE161020????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye161020_2020_VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYeta5100ToYe161020(Ye161020_2020_VO vo) throws Exception {
        delete("ye161020_2020_DAO.deleteYe161020_S", vo);
    }

//    /**
//	 * YE161020??조회?�다.
//	 * @param vo - 조회???�보�??�긴 Ye161020_2020_VO
//	 * @return 조회??YE161020
//	 * @exception Exception
//	 */
//    public Ye161020_2020_VO selectYe161020(Ye161020_2020_VO vo) throws Exception {
//        return (Ye161020_2020_VO) select("ye161020_2020_DAO.selectYe161020_S", vo);
//    }

    /**
	 * YE161020 목록??조회?�다.
	 * @param searchMap - 조회???�보�??�긴 Map
	 * @return YE161020 목록
	 * @exception Exception
	 */
    public List<?> selectYe161020List(Ye161020Srh_2020_VO search_2020_VO) throws Exception {
        return list("ye161020_2020_DAO.selectYe161020List_D", search_2020_VO);
    }

//    /**
//	 * YE161020 �?�?���?조회?�다.
//	 * @param searchMap - 조회???�보�??�긴 Map
//	 * @return YE161020 �?�?��
//	 * @exception
//	 */
//    public int selectYe161020ListTotCnt(Ye161020Srh_2020_VO search_2020_VO) {
//        return (Integer)select("ye161020_2020_DAO.selectYe161020ListTotCnt_S", search_2020_VO);
//    }
    public List getYeta5300TxDdcYnToYe161020Data(Ye161020Srh_2020_VO ye161020SrhVo)throws Exception {
		return list("ye161020_2020_DAO.getYeta5300TxDdcYnToYe161020Data", ye161020SrhVo);
	}

}