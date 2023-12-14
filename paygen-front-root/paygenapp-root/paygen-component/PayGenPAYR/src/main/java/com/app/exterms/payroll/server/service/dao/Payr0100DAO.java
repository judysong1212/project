package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0100SrhVO;
import com.app.exterms.payroll.server.vo.Payr0100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0100DAO.java
 * @Description : Payr0100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0100DAO")
public class Payr0100DAO extends EgovAbstractDAO {

	/**
	 * PAYR0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0100(Payr0100VO vo) throws Exception {
        return (String)insert("payr0100DAO.insertPayr0100_S", vo);
    }
    
	/**
	 * PAYR0100을 등록한다.(간이소득세액이관)
	 * @param vo - 등록할 정보가 담긴 Payr0100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0100_T(Payr0100VO vo) throws Exception {
        return (String)insert("payr0100DAO.transferPayr0100_S", vo);
    }
    
    /**
	 * PAYR0100을 삭제한다.(간이소득세액이관)
	 * @param vo - 삭제할 정보가 담긴 Payr0100VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0100_T(Payr0100VO vo) throws Exception {
        delete("payr0100DAO.transferPayr0100_D", vo);
    }
    
	/**
	 * PAYR0100을 등록한다.(엑셀업로드)
	 * @param vo - 등록할 정보가 담긴 Payr0100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertXlsPayr0100(Payr0100VO vo) throws Exception {
        return (String)insert("payr0100DAO.insertXlsPayr0100_S", vo);
    }
    
    /**
	 * PAYR0100을 삭제한다.(엑셀업로드)
	 * @param vo - 삭제할 정보가 담긴 Payr0100VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteXlsPayr0100(Payr0100VO vo) throws Exception {
        delete("payr0100DAO.deleteXlsPayr0100_S", vo);
    }
    
    /**
	 * PAYR0100 목록을 조회한다.(엑셀)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0100 목록
	 * @exception Exception
	 */
    public List selectXlsPayr0100List(Payr0100SrhVO searchVO) throws Exception {
        return list("payr0100DAO.selectXlsPayr0100List_D", searchVO);
    }
    
    

    /**
	 * PAYR0100을 수정한다.(간이세액표 마감처리)
	 * @param vo - 수정할 정보가 담긴 Payr0100VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0100_apptnStdEndDt(Payr0100VO vo) throws Exception {
        update("payr0100DAO.updatePayr0100_APPTN_STD_END_DT", vo);
    }
    
    /**
	 * PAYR0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0100VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0100(Payr0100VO vo) throws Exception {
        update("payr0100DAO.updatePayr0100_S", vo);
    }

    /**
	 * PAYR0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0100VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0100(Payr0100VO vo) throws Exception {
        delete("payr0100DAO.deletePayr0100_S", vo);
    }

    /**
	 * PAYR0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0100VO
	 * @return 조회한 PAYR0100
	 * @exception Exception
	 */
    public Payr0100VO selectPayr0100(Payr0100VO vo) throws Exception {
        return (Payr0100VO) selectByPk("payr0100DAO.selectPayr0100_S", vo);
    }

    /**
	 * PAYR0100 목록을 조회한다.(이전 날짜 중 가장 최근 데이터의 마감처리 안된 년도를 가져옴)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0100 목록
	 * @exception Exception
	 
    public List getPayr0100ApptnYrList(Payr0100SrhVO searchVO) throws Exception {
        return list("payr0100DAO.getPayr0100ApptnYrList", searchVO);
    }
    */
    
    /**
	 * PAYR0100 목록을 조회한다.(이관할 데이터 가져옴)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0100 목록
	 * @exception Exception
	 */
    public List getPayr0100BeforeList(Payr0100SrhVO searchVO) throws Exception {
        return list("payr0100DAO.getPayr0100BeforeList", searchVO);
    }
    
    
    /**
	 * PAYR0100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0100 목록
	 * @exception Exception
	 */
    public List selectPayr0100List(Payr0100SrhVO searchVO) throws Exception {
        return list("payr0100DAO.selectPayr0100List_D", searchVO);
    }

    /**
	 * PAYR0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0100 총 갯수
	 * @exception
	 */
    public int selectPayr0100ListTotCnt(Payr0100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0100DAO.selectPayr0100ListTotCnt_S", searchVO);
    }
    
    /**
   	 * PAYR0100 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0100 목록
   	 * @exception Exception
   	 */
	public List selectPayr0100ApptnYrList(Payr0100SrhVO searchVO) throws Exception {
           return list("payr0100DAO.selectPayr0100ApptnYrList_D", searchVO);
	} 
       
       /**
   	 * PAYR0100 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0100 총 갯수
   	 * @exception
   	 */
       public int selectPayr0100ApptnYrListTotCnt(Payr0100SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("payr0100DAO.selectPayr0100ApptnYrListTotCnt_S", searchVO);
       }
       
       /**
      	 * PAYR0100 목록을 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PAYR0100 목록
      	 * @exception Exception
      	 */
          public List selectPayr0100ApptnStdBgnnDtList(Payr0100SrhVO searchVO) throws Exception {
              return list("payr0100DAO.selectPayr0100ApptnStdBgnnDtList_D", searchVO);
          } 
          
          /**
      	 * PAYR0100 총 갯수를 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PAYR0100 총 갯수
      	 * @exception
      	 */
          public int selectPayr0100ApptnStdBgnnDtListTotCnt(Payr0100SrhVO searchVO) {
              return (Integer)getSqlMapClientTemplate().queryForObject("payr0100DAO.selectPayr0100ApptnStdBgnnDtListTotCnt_S", searchVO);
          }
       
       

}
