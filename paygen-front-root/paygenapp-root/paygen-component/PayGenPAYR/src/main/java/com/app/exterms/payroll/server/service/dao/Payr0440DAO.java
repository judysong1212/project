package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0440SrhVO;
import com.app.exterms.payroll.server.vo.Payr0440VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0440DAO.java
 * @Description : Payr0440 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0440DAO")
public class Payr0440DAO extends EgovAbstractDAO {

	/**
	 * PAYR0440을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0440VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0440(Payr0440VO vo) throws Exception {
        return (String)insert("payr0440DAO.insertPayr0440_S", vo);
    }

    /**
	 * PAYR0440을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0440VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0440(Payr0440VO vo) throws Exception {
        update("payr0440DAO.updatePayr0440_S", vo);
    }

    /**
	 * PAYR0440을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0440VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0440(Payr0440VO vo) throws Exception {
        delete("payr0440DAO.deletePayr0440_S", vo);
    }

    /**
	 * PAYR0440을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0440VO
	 * @return 조회한 PAYR0440
	 * @exception Exception
	 */
    public Payr0440VO selectPayr0440(Payr0440VO vo) throws Exception {
        return (Payr0440VO) selectByPk("payr0440DAO.selectPayr0440_S", vo);
    }

    /**
	 * PAYR0440 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0440 목록
	 * @exception Exception
	 */
    public List selectPayr0440List(Payr0440SrhVO searchVO) throws Exception {
        return list("payr0440DAO.selectPayr0440List_D", searchVO);
    }

    /**
	 * PAYR0440 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0440 총 갯수
	 * @exception
	 */
    public int selectPayr0440ListTotCnt(Payr0440SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0440DAO.selectPayr0440ListTotCnt_S", searchVO);
    }
    
    /**
	 * PAYR0440 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0440 목록
	 * @exception Exception
	 */
    public List selectPayr0440ToPayr5100List(Payr0440SrhVO searchVO) throws Exception {
        return list("payr0440DAO.selectPayr0440ToPayr5100List_D", searchVO);
    }

    /**
	 * PAYR0440 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0440 총 갯수
	 * @exception
	 */
    public int selectPayr0440ToPayr5100ListTotCnt(Payr0440SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0440DAO.selectPayr0440ToPayr5100ListTotCnt_S", searchVO);
    }
    
    /**
  	 * PAYR0440 목록을 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return PAYR0440 목록
  	 * @exception Exception
  	 */
      public List selectPayr0440ToPayr5200List(Payr0440SrhVO searchVO) throws Exception {
          return list("payr0440DAO.selectPayr0440ToPayr5200List_D", searchVO);
      }

      /**
  	 * PAYR0440 총 갯수를 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return PAYR0440 총 갯수
  	 * @exception
  	 */
      public int selectPayr0440ToPayr5200ListTotCnt(Payr0440SrhVO searchVO) {
          return (Integer)getSqlMapClientTemplate().queryForObject("payr0440DAO.selectPayr0440ToPayr5200ListTotCnt_S", searchVO);
      }
      
      /**
    	 * PAYR0440 목록을 조회한다.
    	 * @param searchMap - 조회할 정보가 담긴 Map
    	 * @return PAYR0440 목록
    	 * @exception Exception
    	 */
        public List selectPayr0440PayYrList(Payr0440SrhVO searchVO) throws Exception {
            return list("payr0440DAO.selectPayr0440PayYrList_D", searchVO);
        }

        /**
    	 * PAYR0440 총 갯수를 조회한다.
    	 * @param searchMap - 조회할 정보가 담긴 Map
    	 * @return PAYR0440 총 갯수
    	 * @exception
    	 */
        public int selectPayr0440PayYrListTotCnt(Payr0440SrhVO searchVO) {
            return (Integer)getSqlMapClientTemplate().queryForObject("payr0440DAO.selectPayr0440PayYrListTotCnt_S", searchVO);
        }
        
        
        
        /**
      	 * PAYR0440 목록을 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PAYR0440 목록
      	 * @exception Exception
      	 */
          public List selectPayr0440UcstDgmApptnDtList(Payr0440SrhVO searchVO) throws Exception {
              return list("payr0440DAO.selectPayr0440UcstDgmApptnDtList_D", searchVO);
          }

          /**
      	 * PAYR0440 총 갯수를 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PAYR0440 총 갯수
      	 * @exception
      	 */
          public int selectPayr0440UcstDgmApptnDtListTotCnt(Payr0440SrhVO searchVO) {
              return (Integer)getSqlMapClientTemplate().queryForObject("payr0440DAO.selectPayr0440UcstDgmApptnDtListTotCnt_S", searchVO);
          }
      
    
      

}
