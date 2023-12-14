package com.app.exterms.retirement.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.retirement.server.vo.Remt3100SrhVO;
import com.app.exterms.retirement.server.vo.Remt3100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Remt3100DAO.java
 * @Description : Remt3100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Remt3100DAO")
public class Remt3100DAO extends EgovAbstractDAO {

	/**
	 * REMT3100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt3100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRemt3100(Remt3100VO vo) throws Exception {
        return (String)insert("remt3100DAO.insertRemt3100_S", vo);
    }

    /**
	 * REMT3100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt3100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRemt3100(Remt3100VO vo) throws Exception {
        update("remt3100DAO.updateRemt3100_S", vo);
    }
    
    public void updateRemt0200ToRemt3100(Remt3100VO vo) throws Exception {
        update("remt3100DAO.updateRemt0200ToRemt3100_S", vo);
    }
    
    public void updateRemt0200ToRemt3100Anty(Remt3100VO vo) throws Exception {
        update("remt3100DAO.updateRemt0200ToRemt3100Anty_S", vo);
    }
    
    
    
  
		
    /**
	 * REMT3100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt3100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt3100(Remt3100VO vo) throws Exception {
        delete("remt3100DAO.deleteRemt3100_S", vo);
    }

    /**
	 * REMT3100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt3100VO
	 * @return 조회한 REMT3100
	 * @exception Exception
	 */
    public Remt3100VO selectRemt3100(Remt3100VO vo) throws Exception {
        return (Remt3100VO) selectByPk("remt3100DAO.selectRemt3100_S", vo);
    }

    /**
	 * REMT3100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT3100 목록
	 * @exception Exception
	 */
    public List<?> selectRemt3100List(Remt3100SrhVO searchVO) throws Exception {
        return list("remt3100DAO.selectRemt3100List_D", searchVO);
    }

    /**
	 * REMT3100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT3100 총 갯수
	 * @exception
	 */
    public int selectRemt3100ListTotCnt(Remt3100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("remt3100DAO.selectRemt3100ListTotCnt_S", searchVO);
    }
    
    
    /**
	 * 중간정산, 퇴직정산 조회 REMT3100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT3100 목록
	 * @exception Exception
	 */
    public List<?> selectRemt0100ToRemt3100List(Remt3100SrhVO searchVO) throws Exception {
        return list("remt3100DAO.selectRemt0100ToRemt3100List_D", searchVO);
    }

    /**
	 * 중간정산, 퇴직정산 조회 REMT3100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT3100 총 갯수
	 * @exception
	 */
    public int selectRemt0100ToRemt3100ListTotCnt(Remt3100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("remt3100DAO.selectRemt0100ToRemt3100ListTotCnt_S", searchVO);
    }

    
    /**
   	 * 퇴직정산 결과 조회 REMT3100 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return REMT3100 목록
   	 * @exception Exception
   	 */
       public List<?> selectRemt0200ToRemt3100List(Remt3100SrhVO searchVO) throws Exception {
           return list("remt3100DAO.selectRemt0200ToRemt3100List_D", searchVO);
       }

       /**
   	 * 퇴직정산결과 조회 REMT3100 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return REMT3100 총 갯수
   	 * @exception
   	 */
       public int selectRemt0200ToRemt3100ListTotCnt(Remt3100SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("remt3100DAO.selectRemt0200ToRemt3100ListTotCnt_S", searchVO);
       }
       
       
       
       /**
      	 * 퇴직정산 결과 조회 REMT3100 목록을 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return REMT3100 목록
      	 * @exception Exception
      	 */
          public List<?> selectRemtPymtSubtn0200ToRemt3100List(Remt3100SrhVO searchVO) throws Exception {
              return list("remt3100DAO.selectRemtPymtSubtn0200ToRemt3100List_D", searchVO);
          }

          /**
      	 * 퇴직정산결과 조회 REMT3100 총 갯수를 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return REMT3100 총 갯수
      	 * @exception
      	 */
          public int selectRemtPymtSubtn0200ToRemt3100ListTotCnt(Remt3100SrhVO searchVO) {
              return (Integer)getSqlMapClientTemplate().queryForObject("remt3100DAO.selectRemtPymtSubtn0200ToRemt3100ListTotCnt_S", searchVO);
          }
       

       /**
      	 * REMT3000 목록을 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return REMT3000 목록
      	 * @exception Exception
      	 */
          public List<?> selectRemt0300ToRemt3100List(Remt3100SrhVO searchVO) throws Exception {
              return list("remt3100DAO.selectRemt0300ToRemt3100List_D", searchVO);
          }

          /**
      	 * REMT3000 총 갯수를 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return REMT3000 총 갯수
      	 * @exception
      	 */
          public int selectRemt0300ToRemt3100ListTotCnt(Remt3100SrhVO searchVO) {
              return (Integer)getSqlMapClientTemplate().queryForObject("remt3100DAO.selectRemt0300ToRemt3100ListTotCnt_S", searchVO);
          }
          
          /**
        	 * REMT3000 목록을 조회한다.
        	 * @param searchMap - 조회할 정보가 담긴 Map
        	 * @return REMT3000 목록
        	 * @exception Exception
        	 */
            public List<?> selectXlsRemt0300List(Remt3100SrhVO searchVO) throws Exception {
                return list("remt3100DAO.selectXlsRemt0300List_D", searchVO);
            }

    
          
}
