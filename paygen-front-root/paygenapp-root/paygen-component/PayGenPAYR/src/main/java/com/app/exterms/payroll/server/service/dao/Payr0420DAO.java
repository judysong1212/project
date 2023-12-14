package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0420SrhVO;
import com.app.exterms.payroll.server.vo.Payr0420VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0420DAO.java
 * @Description : Payr0420 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0420DAO")
public class Payr0420DAO extends EgovAbstractDAO {

	/**
	 * PAYR0420을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0420VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0420(Payr0420VO vo) throws Exception {
        return (String)insert("payr0420DAO.insertPayr0420_S", vo);
    }

    /**
	 * PAYR0420을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0420VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0420(Payr0420VO vo) throws Exception {
        update("payr0420DAO.updatePayr0420_S", vo);
    }

    /**
	 * PAYR0420을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0420VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0420(Payr0420VO vo) throws Exception {
        delete("payr0420DAO.deletePayr0420_S", vo);
    }

    /**
	 * PAYR0420을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0420VO
	 * @return 조회한 PAYR0420
	 * @exception Exception
	 */
    public Payr0420VO selectPayr0420(Payr0420VO vo) throws Exception {
        return (Payr0420VO) selectByPk("payr0420DAO.selectPayr0420_S", vo);
    }

//    /**
//	 * PAYR0420 목록을 조회한다.
//	 * @param searchMap - 조회할 정보가 담긴 Map
//	 * @return PAYR0420 목록
//	 * @exception Exception
//	 */
//    public List selectPayr0420List(Payr0420SrhVO searchVO) throws Exception {
//        return list("payr0420DAO.selectPayr0420List_D", searchVO);
//    }
//
//    /**
//	 * PAYR0420 총 갯수를 조회한다.
//	 * @param searchMap - 조회할 정보가 담긴 Map
//	 * @return PAYR0420 총 갯수
//	 * @exception
//	 */
//    public int selectPayr0420ListTotCnt(Payr0420SrhVO searchVO) {
//        return (Integer)getSqlMapClientTemplate().queryForObject("payr0420DAO.selectPayr0420ListTotCnt_S", searchVO);
//    }
    
    /**
  	 * PAYR0420 목록을 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return PAYR0420 목록
  	 * @exception Exception
  	 */
      public List selectPayr0420LeftList(Payr0420SrhVO searchVO) throws Exception {
          return list("payr0420DAO.selectPayr0420LeftList_D", searchVO);
      }

      /**
  	 * PAYR0420 총 갯수를 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return PAYR0420 총 갯수
  	 * @exception
  	 */
      public int selectPayr0420LeftListTotCnt(Payr0420SrhVO searchVO) {
          return (Integer)getSqlMapClientTemplate().queryForObject("payr0420DAO.selectPayr0420LeftListTotCnt_S", searchVO);
      }
      
      /**
    	 * PAYR0420 목록을 조회한다.
    	 * @param searchMap - 조회할 정보가 담긴 Map
    	 * @return PAYR0420 목록
    	 * @exception Exception
    	 */
        public List selectPayr0420CtrList(Payr0420SrhVO searchVO) throws Exception {
            return list("payr0420DAO.selectPayr0420CtrList_D", searchVO);
        }

        /**
    	 * PAYR0420 총 갯수를 조회한다.
    	 * @param searchMap - 조회할 정보가 담긴 Map
    	 * @return PAYR0420 총 갯수
    	 * @exception
    	 */
        public int selectPayr0420CtrListTotCnt(Payr0420SrhVO searchVO) {
            return (Integer)getSqlMapClientTemplate().queryForObject("payr0420DAO.selectPayr0420CtrListTotCnt_S", searchVO);
        }
        
        
        /**
    	 * PAYR0420 목록을 조회한다.
    	 * @param searchMap - 조회할 정보가 담긴 Map
    	 * @return PAYR0420 목록
    	 * @exception Exception
    	 */
        public List selectPayr0420OccuClssPayStdList(Payr0420SrhVO searchVO) throws Exception {
            return list("payr0420DAO.selectPayr0420OccuClssPayStdList_D", searchVO);
        }

        /**
    	 * PAYR0420 총 갯수를 조회한다.
    	 * @param searchMap - 조회할 정보가 담긴 Map
    	 * @return PAYR0420 총 갯수
    	 * @exception
    	 */
        public int selectPayr0420OccuClssPayStdListTotCnt(Payr0420SrhVO searchVO) {
            return (Integer)getSqlMapClientTemplate().queryForObject("payr0420DAO.selectPayr0420OccuClssPayStdListTotCnt_S", searchVO);
        }
    
      

}
