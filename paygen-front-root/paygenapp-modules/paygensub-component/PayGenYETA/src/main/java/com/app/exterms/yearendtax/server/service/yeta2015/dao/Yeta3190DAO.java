package com.app.exterms.yearendtax.server.service.yeta2015.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Yeta3190SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3190VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3190DAO.java
 * @Description : Yeta3190 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta3190DAO")
public class Yeta3190DAO extends EgovAbstractDAO {

	/**
	 * YETA3190을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3190VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3190(Yeta3190VO vo) throws Exception {
        return (String)insert("yeta3190DAO.insertYeta3190_S", vo);
    }

    /**
	 * YETA3190을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3190VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3190(Yeta3190VO vo) throws Exception {
        update("yeta3190DAO.updateYeta3190_S", vo);
    }

    /**
	 * YETA3190을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3190VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3190(Yeta3190VO vo) throws Exception {
        delete("yeta3190DAO.deleteYeta3190_S", vo);
    }
    
    /**
  	 * YETA3190을 삭제한다.
  	 * @param vo - 삭제할 정보가 담긴 Yeta3190VO
  	 * @return void형 
  	 * @exception Exception
  	 */
	  @Transactional
      public void fnPayr06430_PAYR443_CREATE_Delete(Yeta3190VO vo) throws Exception {
          delete("yeta3190DAO.fnPayr06430_PAYR443_CREATE_Delete_S", vo);
      } 
    

    /**
	 * YETA3190을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3190VO
	 * @return 조회한 YETA3190
	 * @exception Exception
	 */
    public Yeta3190VO selectYeta3190(Yeta3190VO vo) throws Exception {
        return (Yeta3190VO) selectByPk("yeta3190DAO.selectYeta3190_S", vo);
    }

    /**
	 * YETA3190 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3190 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3190List(Yeta3190SrhVO searchVO) throws Exception {
        return list("yeta3190DAO.selectYeta3190List_D", searchVO);
    }

    /**
	 * YETA3190 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3190 총 갯수
	 * @exception
	 */
    public int selectYeta3190ListTotCnt(Yeta3190SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta3190DAO.selectYeta3190ListTotCnt_S", searchVO);
    }

}
