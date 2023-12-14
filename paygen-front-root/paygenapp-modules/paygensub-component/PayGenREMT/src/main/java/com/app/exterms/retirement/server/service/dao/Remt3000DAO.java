package com.app.exterms.retirement.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.retirement.server.vo.Remt3000SrhVO;
import com.app.exterms.retirement.server.vo.Remt3000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Remt3000DAO.java
 * @Description : Remt3000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Remt3000DAO")
public class Remt3000DAO extends EgovAbstractDAO {

	/**
	 * REMT3000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt3000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRemt3000(Remt3000VO vo) throws Exception {
        return (String)insert("remt3000DAO.insertRemt3000_S", vo);
    }

    /**
	 * REMT3000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt3000VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRemt3000(Remt3000VO vo) throws Exception {
        update("remt3000DAO.updateRemt3000_S", vo);
    }
    
    public void updateRemt0200ToRemt3000(Remt3000VO vo) throws Exception {
        update("remt3000DAO.updateRemt0200ToRemt3000_S", vo);
    }
 
	
    public void updateRemt0200ToDDlne(Remt3000VO vo) throws Exception {
        update("remt3000DAO.updateRemt0200ToDDlne_S", vo);
    }

    
    public void deleteRemt0200ToDDlne(Remt3000VO vo) throws Exception {
        update("remt3000DAO.deleteRemt0200ToDDlne_S", vo);
    }
 
	   
    /**
	 * REMT3000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt3000VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt3000(Remt3000VO vo) throws Exception {
        delete("remt3000DAO.deleteRemt3000_S", vo);
    }

    /**
	 * REMT3000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt3000VO
	 * @return 조회한 REMT3000
	 * @exception Exception
	 */
    public Remt3000VO selectRemt3000(Remt3000VO vo) throws Exception {
        return (Remt3000VO) selectByPk("remt3000DAO.selectRemt3000_S", vo);
    }

    /**
	 * REMT3000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT3000 목록
	 * @exception Exception
	 */
    public List<?> selectRemt3000List(Remt3000SrhVO searchVO) throws Exception {
        return list("remt3000DAO.selectRemt3000List_D", searchVO);
    }

    /**
	 * REMT3000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT3000 총 갯수
	 * @exception
	 */
    public int selectRemt3000ListTotCnt(Remt3000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("remt3000DAO.selectRemt3000ListTotCnt_S", searchVO);
    }
    
   
       /**
      	 * 퇴직정산 -퇴직 대상자조회 REMT3000 목록을 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return REMT3000 목록
      	 * @exception Exception
      	 */
          public List<?> selectRemt0200ToRemt3000List(Remt3000SrhVO searchVO) throws Exception {
              return list("remt3000DAO.selectRemt0200ToRemt3000List_D", searchVO);
          }

          /**
      	 * 퇴직정산 - 퇴직대상자 조회 REMT3000 총 갯수를 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return REMT3000 총 갯수
      	 * @exception
      	 */
          public int selectRemt0200ToRemt3000ListTotCnt(Remt3000SrhVO searchVO) {
              return (Integer)getSqlMapClientTemplate().queryForObject("remt3000DAO.selectRemt0200ToRemt3000ListTotCnt_S", searchVO);
          }
       
       
       

}
