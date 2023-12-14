package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye161020SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye161020VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161020DAO.java
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

@Repository("Ye161020DAO")
public class Ye161020DAO extends EgovAbstractDAO {
	
	
	
	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE161020 목록을 조회한다.
	 * @param Ye161020SrhVO - 조회할 정보가 담긴 ye161020SrhVo
	 * @return YE161020 목록
	 * @exception Exception
	 */
	public List selectYeta2300ToYe161020Data(Ye161020SrhVO ye161020SrhVo)throws Exception {
		return list("ye161020DAO.seleteYeta2300ToYe161020_D", ye161020SrhVo);
	}

	/**
	 * YE161020 총 갯수를 조회한다.
	 * @param Ye161020SrhVO - 조회할 정보가 담긴 ye161020SrhVo
	 * @return YE161020 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectYeta2300ToYe161020ListtTotCnt(Ye161020SrhVO ye161020SrhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ye161020DAO.seleteYeta2300ToYe161020ListCnt_S", ye161020SrhVo);
	}	
//	
//	
//	/**
//	 * YE161020 을 등록한다.
//	 * @param Ye161020VO - 등록할 정보가 담긴 Ye161020VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String insertYeta2300ToYe161020(Ye161020VO vo) throws Exception {
//        return (String)insert("ye161020DAO.insertYeta2300ToYe161020_S", vo);
//    }
    
	/**
	 * YE161020 을 수정한다.
	 * @param Ye161020VO - 수정할 정보가 담긴 Ye161020VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYeta2300Item01ToYe161020(Ye161020VO vo) throws Exception {
        update("ye161020DAO.updateYeta2300Item01ToYe161020_S", vo);
    }
    
    public void updateYeta2300Item02ToYe161020(Ye161020VO vo) throws Exception {
        update("ye161020DAO.updateYeta2300Item02ToYe161020_S", vo);
    }
    
    
    public void updateYetaP210002ToYe161020(Ye161020VO vo) throws Exception {
        update("ye161020DAO.updateYetaP210002ToYe161020_S", vo);
    }
    
//	/**
//	 * YE161020 을 삭제한다.
//	 * @param Ye161020VO - 삭제할 정보가 담긴 Ye161020VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public void deleteYeta2300ToYe161020(Ye161020VO vo) throws Exception {
//        delete("ye161020DAO.deleteYeta2300ToYe161020_S", vo);
//    }	
	
    public void deleteYetaP210001_Ye161020VO_2017_Delete(Ye161020VO vo) throws Exception {
        delete("ye161020DAO.deleteYetaP210001_Ye161020VO_2017_Delete_S", vo);
    }
    
    
    
	/**    
     * #############################################
     * 2017년도 연말정산 구현 종료
     * #############################################
     *   **/	
	
	
	
	
	

	/**
	 * YE161020???�록?�다.
	 * @param vo - ?�록???�보�??�긴 Ye161020VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertYe161020(Ye161020VO vo) throws Exception {
        return (String)insert("ye161020DAO.insertYe161020_S", vo);
    }

    /**
	 * YE161020???�정?�다.
	 * @param vo - ?�정???�보�??�긴 Ye161020VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe161020(Ye161020VO vo) throws Exception {
        update("ye161020DAO.updateYe161020_S", vo);
    }

    /**
	 * YE161020????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye161020VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe161020(Ye161020VO vo) throws Exception {
        delete("ye161020DAO.deleteYe161020_S", vo);
    }
    
    
    /**
	 * YE161020????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye161020VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYeta2100ToYe161020(Ye161020VO vo) throws Exception {
        delete("ye161020DAO.deleteYe161020_S", vo);
    }

//    /**
//	 * YE161020??조회?�다.
//	 * @param vo - 조회???�보�??�긴 Ye161020VO
//	 * @return 조회??YE161020
//	 * @exception Exception
//	 */
//    public Ye161020VO selectYe161020(Ye161020VO vo) throws Exception {
//        return (Ye161020VO) select("ye161020DAO.selectYe161020_S", vo);
//    }

    /**
	 * YE161020 목록??조회?�다.
	 * @param searchMap - 조회???�보�??�긴 Map
	 * @return YE161020 목록
	 * @exception Exception
	 */
    public List<?> selectYe161020List(Ye161020SrhVO searchVO) throws Exception {
        return list("ye161020DAO.selectYe161020List_D", searchVO);
    }

//    /**
//	 * YE161020 �?�?���?조회?�다.
//	 * @param searchMap - 조회???�보�??�긴 Map
//	 * @return YE161020 �?�?��
//	 * @exception
//	 */
//    public int selectYe161020ListTotCnt(Ye161020SrhVO searchVO) {
//        return (Integer)select("ye161020DAO.selectYe161020ListTotCnt_S", searchVO);
//    }
    public List getYeta2300TxDdcYnToYe161020Data(Ye161020SrhVO ye161020SrhVo)throws Exception {
		return list("ye161020DAO.getYeta2300TxDdcYnToYe161020Data", ye161020SrhVo);
	}

}
