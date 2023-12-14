package com.app.exterms.yearendtax.server.service.yeta2015.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Yeta3150SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3150VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3150DAO.java
 * @Description : Yeta3150 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta3150DAO")
public class Yeta3150DAO extends EgovAbstractDAO implements IsSerializable  {
	
	/**
	 * YETA3150을 등록한다.(가족교육비 grid)
	 * @param vo - 등록할 정보가 담긴 Yeta3150VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta0300ToYeta3150(Yeta3150VO vo) throws Exception {
        return (String)insert("yeta3150DAO.insertYeta3150_S", vo);
    }

    /**
	 * YETA3150을 수정한다.(가족교육비 grid)
	 * @param vo - 수정할 정보가 담긴 Yeta3150VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta0300ToYeta3150(Yeta3150VO vo) throws Exception {
        update("yeta3150DAO.updateYeta3150_S", vo);
    }

    /**
	 * YETA3150을 삭제한다.(가족교육비 grid)
	 * @param vo - 삭제할 정보가 담긴 Yeta3150VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta0300ToYeta3150(Yeta3150VO vo) throws Exception {
        delete("yeta3150DAO.deleteYeta3150_S", vo);
    }
	  
	/**
	 * YETA3150 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3150 목록
	 * @exception Exception
	 */
	public List selectYeta0300To3150List(Yeta3150SrhVO searchVO) throws Exception {
		return list("yeta3150DAO.selectYeta3150_S", searchVO);
	}	 
	
	
	
	

	/**
	 * YETA3150을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3150VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3150(Yeta3150VO vo) throws Exception {
        return (String)insert("yeta3150DAO.insertYeta3150_S", vo);
    }

    /**
	 * YETA3150을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3150VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3150(Yeta3150VO vo) throws Exception {
        update("yeta3150DAO.updateYeta3150_S", vo);
    }

    /**
	 * YETA3150을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3150VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteYeta3150(Yeta3150VO vo) throws Exception {
        delete("yeta3150DAO.deleteYeta3150_S", vo);
    }

    /**
	 * YETA3150을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3150VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void fnPayr06430_PAYR445_CREATE_Delete(Yeta3150VO vo) throws Exception {
        delete("yeta3150DAO.fnPayr06430_PAYR445_CREATE_Delete_S", vo);
    }  
    

    /**
	 * YETA3150을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3150VO
	 * @return 조회한 YETA3150
	 * @exception Exception
	 */
    public Yeta3150VO selectYeta3150(Yeta3150VO vo) throws Exception {
        return (Yeta3150VO) selectByPk("yeta3150DAO.selectYeta3150_S", vo);
    }

    /**
	 * YETA3150 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3150 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3150List(Yeta3150SrhVO searchVO) throws Exception {
        return list("yeta3150DAO.selectYeta3150List_D", searchVO);
    }

    /**
	 * YETA3150 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3150 총 갯수
	 * @exception
	 */
    public int selectYeta3150ListTotCnt(Yeta3150SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta3150DAO.selectYeta3150ListTotCnt_S", searchVO);
    }

}
