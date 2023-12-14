package com.app.exterms.yearendtax.server.service.yeta2016.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Yeta3300SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3300VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3300DAO.java
 * @Description : Yeta3300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye16Ta3300DAO")
public class Ye16Ta3300DAO extends EgovAbstractDAO {

	/**
	 * YETA3300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3300(Yeta3300VO vo) throws Exception {
        return (String)insert("ye16Ta3300DAO.insertYeta3300_S", vo);
    }

    /**
	 * YETA3300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3300VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3300(Yeta3300VO vo) throws Exception {
        update("ye16Ta3300DAO.updateYeta3300_S", vo);
    }

    /**
	 * YETA3300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3300VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3300(Yeta3300VO vo) throws Exception {
        delete("ye16Ta3300DAO.deleteYeta3300_S", vo);
    }

    /**
	 * YETA3300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3300VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06430_Yeta3300_CREATE_Delete(Yeta3300VO vo) throws Exception {
        delete("ye16Ta3300DAO.fnPayr06430_Yeta3300_CREATE_Delete_S", vo);
    } 
    
    /**
	 * YETA3300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3300VO
	 * @return 조회한 YETA3300
	 * @exception Exception
	 */
    public Yeta3300VO selectYeta3300(Yeta3300VO vo) throws Exception {
        return (Yeta3300VO) selectByPk("ye16Ta3300DAO.selectYeta3300_S", vo);
    }

    /**
	 * YETA3300 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3300 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3300List(Yeta3300SrhVO searchVO) throws Exception {
        return list("ye16Ta3300DAO.selectYeta3300List_D", searchVO);
    }

    /**
	 * YETA3300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3300 총 갯수
	 * @exception
	 */
    public int selectYeta3300ListTotCnt(Yeta3300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye16Ta3300DAO.selectYeta3300ListTotCnt_S", searchVO);
    }

}
