package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr2100SrhVO;
import com.app.exterms.insurance.server.vo.Insr2100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : Insr2100DAO.java
 * @Description : Insr2100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr2100DAO")
public class Insr2100DAO extends EgovAbstractDAO {

	/**
	 * INSR2100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr2100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr2100(Insr2100VO vo) throws Exception {
        return (String)insert("insr2100DAO.insertInsr2100_S", vo);
    }

    /**
	 * INSR2100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr2100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr2100(Insr2100VO vo) throws Exception {
        update("insr2100DAO.updateInsr2100_S", vo);
    }
    
    /**
	 * INSR2100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr2100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr2100LssDt(Insr2100VO vo) throws Exception {
        update("insr2100DAO.updateInsr2100LssDt", vo);
    }
    
    /**
	 * INSR2100을 수정한다.(4대 보험별)
	 * @param vo - 수정할 정보가 담긴 Insr2100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr2100Each(Insr2100VO vo) throws Exception {
        update("insr2100DAO.updateInsr2100Each_S", vo);
    }


    /**
	 * INSR2100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr2100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr2100(Insr2100VO vo) throws Exception {
        delete("insr2100DAO.deleteInsr2100_S", vo);
    }

    /**
	 * INSR2100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr2100VO
	 * @return 조회한 INSR2100
	 * @exception Exception
	 */
    public Insr2100VO selectInsr2100(Insr2100VO vo) throws Exception {
        return (Insr2100VO) selectByPk("insr2100DAO.selectInsr2100_S", vo);
    }
    
    /**
	 * INSR2100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr2100VO
	 * @return 조회한 INSR2100
	 * @exception Exception
	 */
    public EgovMap selectInsr2100ToEtc(Insr2100VO vo) throws Exception {
        return (EgovMap) selectByPk("insr2100DAO.selectInsr2100ToEtc_S", vo);
    }
    

    /**
	 * INSR2100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr2100VO
	 * @return 조회한 INSR2100
	 * @exception Exception
	 */
    public int selectInsr2100Chk(Insr2100VO vo) throws Exception {
        return (Integer) selectByPk("insr2100DAO.selectInsr2100Chk_S", vo);
    }
    
    
    /**
	 * INSR2100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR2100 목록
	 * @exception Exception
	 */
    public List<?> selectInsr2100List(Insr2100SrhVO searchVO) throws Exception {
        return list("insr2100DAO.selectInsr2100List_D", searchVO);
    }

    /**
	 * INSR2100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR2100 총 갯수
	 * @exception
	 */
    public int selectInsr2100ListTotCnt(Insr2100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr2100DAO.selectInsr2100ListTotCnt_S", searchVO);
    }
    
    /**
   	 * 자격상실신고데이터를 가지고 온다. insr2300화면 INSR2100 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR2100 목록
   	 * @exception Exception
   	 */
       public List<?> selectInsr2300ToInsr2100List(Insr2100SrhVO searchVO) throws Exception {
           return list("insr2100DAO.selectInsr2300ToInsr2100List_D", searchVO);
       }

       /**
   	 * 자격상실신고데이터를 가지고 온다. insr2300화면 
   	 * INSR2100 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR2100 총 갯수
   	 * @exception
   	 */
       public int selectInsr2300ToInsr2100ListTotCnt(Insr2100SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("insr2100DAO.selectInsr2300ToInsr2100ListTotCnt_S", searchVO);
       }
       
       /**
   	 * 
   	 * 대상자찾기에서 넘어온 key 로 자격취득신고데이터를 가지고 온다. insr2300화면 
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR1100 목록
   	 * @exception
   	 */
       public EgovMap selectInsr2300ToInsr1100And1200(Insr2100SrhVO searchVO) {
    	   
    	   return (EgovMap) selectByPk("insr2100DAO.selectInsr2300ToInsr1100And1200_D", searchVO);
    	   
          // return (Integer)getSqlMapClientTemplate().queryForObject("insr2100DAO.selectInsr2300ToInsr1100And1200_D", searchVO);
       }
    
       /**
   	 * 
   	 * 대상자찾기에서 넘어온 key 로 자격취득신고데이터를 가지고 온다. insr2300화면 
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR1100 목록
   	 * @exception
   	 */
       public EgovMap selectInsr2300ToPsnl0110(Insr2100SrhVO searchVO) {
    	   
    	   return (EgovMap) selectByPk("insr2100DAO.selectInsr2300ToPsnl0110_D", searchVO);
    	   
          // return (Integer)getSqlMapClientTemplate().queryForObject("insr2100DAO.selectInsr2300ToInsr1100And1200_D", searchVO);
       }

}
