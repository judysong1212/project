package com.app.exterms.yearendtax.server.service.yeta2015.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Yeta3210SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3210VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3210DAO.java
 * @Description : Yeta3210 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta3210DAO")
public class Yeta3210DAO extends EgovAbstractDAO {

	
	/**
	 * YETA3210을 등록한다.(종전근무지 팝업)
	 * @param vo - 등록할 정보가 담긴 Yeta3210VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
	public String insertYetaP03009To3210(Yeta3210VO vo) {
		return (String)insert("yeta3210DAO.insertYeta3210_S", vo);
	}

	
    /**
	 * YETA3210을 수정한다.(주현근무지 팝업)
	 * @param vo - 수정할 정보가 담긴 Yeta3210VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
	public void updateYetaP03009To3210(Yeta3210VO vo) {
		update("yeta3210DAO.updateYeta3210_S", vo);
	}

	
    /**
	 * YETA3210을 삭제한다.(주현근무지 팝업)
	 * @param vo - 삭제할 정보가 담긴 Yeta3210VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
	public void deleteYetaP03009To3210(Yeta3210VO vo) {
		delete("yeta3210DAO.deleteYeta3210_S", vo);
	}
	
	
	
	/**
	 * YETA3210을 등록한다.(주현근무지 팝업)
	 * @param vo - 등록할 정보가 담긴 Yeta3210VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3210(Yeta3210VO vo) throws Exception {
        return (String)insert("yeta3210DAO.insertYeta3210_S", vo);
    }

    /**
	 * YETA3210을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3210VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3210(Yeta3210VO vo) throws Exception {
        update("yeta3210DAO.updateYeta3210_S", vo);
    }

    /**
	 * YETA3210을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3210VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3210(Yeta3210VO vo) throws Exception {
        delete("yeta3210DAO.deleteYeta3210_S", vo);
    }

    /**
 	 * YETA3210을 삭제한다.
 	 * @param vo - 삭제할 정보가 담긴 Yeta3210VO
 	 * @return void형 
 	 * @exception Exception
 	 */
	  @Transactional
     public void fnPayr06420_PAYR417_CREATE_Delete(Yeta3210VO vo) throws Exception {
         delete("yeta3210DAO.fnPayr06420_PAYR417_CREATE_Delete_S", vo);
     }
  
    
    /**
	 * YETA3210을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3210VO
	 * @return 조회한 YETA3210
	 * @exception Exception
	 */
    public Yeta3210VO selectYeta3210(Yeta3210VO vo) throws Exception {
        return (Yeta3210VO) selectByPk("yeta3210DAO.selectYeta3210_S", vo);
    }

    /**
	 * YETA3210 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3210 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3210List(Yeta3210SrhVO searchVO) throws Exception {
        return list("yeta3210DAO.selectYeta3210List_D", searchVO);
    }

    /**
	 * YETA3210 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3210 총 갯수
	 * @exception
	 */
    public int selectYeta3210ListTotCnt(Yeta3210SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta3210DAO.selectYeta3210ListTotCnt_S", searchVO);
    }

}
