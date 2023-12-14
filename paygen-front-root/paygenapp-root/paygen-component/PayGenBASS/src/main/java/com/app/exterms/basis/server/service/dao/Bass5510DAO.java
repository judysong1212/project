package com.app.exterms.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.basis.server.vo.Bass5510SrhVO;
import com.app.exterms.basis.server.vo.Bass5510VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass5510DAO.java
 * @Description : Bass5510 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass5510DAO")
public class Bass5510DAO extends EgovAbstractDAO {

	/**
	 * PAYR0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass5510VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBass5510(Bass5510VO vo) throws Exception {
        return (String)insert("bass5510DAO.insertBass5510_S", vo);
    }
    
	/**
	 * PAYR0100을 등록한다.(간이소득세액이관)
	 * @param vo - 등록할 정보가 담긴 Bass5510VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBass5510_T(Bass5510VO vo) throws Exception {
        return (String)insert("bass5510DAO.transferBass5510_S", vo);
    }
    
    /**
	 * PAYR0100을 삭제한다.(간이소득세액이관)
	 * @param vo - 삭제할 정보가 담긴 Bass5510VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBass5510_T(Bass5510VO vo) throws Exception {
        delete("bass5510DAO.transferBass5510_D", vo);
    }
    
	/**
	 * PAYR0100을 등록한다.(엑셀업로드)
	 * @param vo - 등록할 정보가 담긴 Bass5510VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertXlsBass5510(Bass5510VO vo) throws Exception {
        return (String)insert("bass5510DAO.insertXlsBass5510_S", vo);
    }
    
    /**
	 * PAYR0100을 삭제한다.(엑셀업로드)
	 * @param vo - 삭제할 정보가 담긴 Bass5510VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteXlsBass5510(Bass5510VO vo) throws Exception {
        delete("bass5510DAO.deleteXlsBass5510_S", vo);
    }
    
    /**
	 * PAYR0100 목록을 조회한다.(엑셀)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0100 목록
	 * @exception Exception
	 */
    public List selectXlsBass5510List(Bass5510SrhVO searchVO) throws Exception {
        return list("bass5510DAO.selectXlsBass5510List_D", searchVO);
    }
    
    

    /**
	 * PAYR0100을 수정한다.(간이세액표 마감처리)
	 * @param vo - 수정할 정보가 담긴 Bass5510VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBass5510_apptnStdEndDt(Bass5510VO vo) throws Exception {
        update("bass5510DAO.updateBass5510_APPTN_STD_END_DT", vo);
    }
    
    /**
	 * PAYR0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass5510VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBass5510(Bass5510VO vo) throws Exception {
        update("bass5510DAO.updateBass5510_S", vo);
    }

    /**
	 * PAYR0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass5510VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBass5510(Bass5510VO vo) throws Exception {
        delete("bass5510DAO.deleteBass5510_S", vo);
    }

    /**
	 * PAYR0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass5510VO
	 * @return 조회한 PAYR0100
	 * @exception Exception
	 */
    public Bass5510VO selectBass5510(Bass5510VO vo) throws Exception {
        return (Bass5510VO) selectByPk("bass5510DAO.selectBass5510_S", vo);
    }

    /**
	 * PAYR0100 목록을 조회한다.(이전 날짜 중 가장 최근 데이터의 마감처리 안된 년도를 가져옴)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0100 목록
	 * @exception Exception
	 
    public List getBass5510ApptnYrList(Bass5510SrhVO searchVO) throws Exception {
        return list("bass5510DAO.getBass5510ApptnYrList", searchVO);
    }
    */
    
    /**
	 * PAYR0100 목록을 조회한다.(이관할 데이터 가져옴)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0100 목록
	 * @exception Exception
	 */
    public List getBass5510BeforeList(Bass5510SrhVO searchVO) throws Exception {
        return list("bass5510DAO.getBass5510BeforeList", searchVO);
    }
    
    
    /**
	 * PAYR0100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0100 목록
	 * @exception Exception
	 */
    public List selectBass5510List(Bass5510SrhVO searchVO) throws Exception {
        return list("bass5510DAO.selectBass5510List_D", searchVO);
    }

    /**
	 * PAYR0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0100 총 갯수
	 * @exception
	 */
    public int selectBass5510ListTotCnt(Bass5510SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass5510DAO.selectBass5510ListTotCnt_S", searchVO);
    }
    
    /**
   	 * PAYR0100 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0100 목록
   	 * @exception Exception
   	 */
	public List selectBass5510ApptnYrList(Bass5510SrhVO searchVO) throws Exception {
           return list("bass5510DAO.selectBass5510ApptnYrList_D", searchVO);
	} 
       
       /**
   	 * PAYR0100 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0100 총 갯수
   	 * @exception
   	 */
       public int selectBass5510ApptnYrListTotCnt(Bass5510SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("bass5510DAO.selectBass5510ApptnYrListTotCnt_S", searchVO);
       }
       
       /**
      	 * PAYR0100 목록을 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PAYR0100 목록
      	 * @exception Exception
      	 */
          public List selectBass5510ApptnStdBgnnDtList(Bass5510SrhVO searchVO) throws Exception {
              return list("bass5510DAO.selectBass5510ApptnStdBgnnDtList_D", searchVO);
          } 
          
          /**
      	 * PAYR0100 총 갯수를 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PAYR0100 총 갯수
      	 * @exception
      	 */
          public int selectBass5510ApptnStdBgnnDtListTotCnt(Bass5510SrhVO searchVO) {
              return (Integer)getSqlMapClientTemplate().queryForObject("bass5510DAO.selectBass5510ApptnStdBgnnDtListTotCnt_S", searchVO);
          }
       
       

}
