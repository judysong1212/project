package com.app.exterms.personal.server.service.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.server.vo.Psnl0119VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0119DAO.java
 * @Description : Psnl0119 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0119DAO")
public class Psnl0119DAO extends EgovAbstractDAO {

	/**
	 * PSNL0119을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0119VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//    @Transactional
//	public String insertPsnl0119(Psnl0119DTO dto) throws Exception {
//        return (String)insert("psnl0119DAO.insertPsnl0119", dto);
//    }
    
    @Transactional
	public String insertPsnl0119(Psnl0119VO psnl0119Vo) throws Exception {
        return (String)insert("psnl0119DAO.insertPsnl0119", psnl0119Vo);
    }

    /**
	 * PSNL0119을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0119VO
	 * @return void형
	 * @exception Exception
	 */
//    @Transactional
//    public int updatePsnl0119(Psnl0119DTO dto) throws Exception {
//        return update("psnl0119DAO.updatePsnl0119", dto);
//    }

    @Transactional
    public int updatePsnl0119(Psnl0119VO psnl0119Vo) throws Exception {
        return update("psnl0119DAO.updatePsnl0119", psnl0119Vo);
    }
    /**
	 * PSNL0119을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0119VO
	 * @return void형 
	 * @exception Exception
	 */
//    @Transactional
//    public int deletePsnl0119(Psnl0119DTO dto) throws Exception {
//    	return delete("psnl0119DAO.deletePsnl0119", dto);
//    }
    
    @Transactional
    public int deletePsnl0119(Psnl0119VO psnl0119Vo) throws Exception {
    	return delete("psnl0119DAO.deletePsnl0119", psnl0119Vo);
    }
    
    /**
  	 * PSNL0119을 삭제한다.
  	 * @param HashMap - 삭제할 정보가 담긴 hMap
  	 * @return void형 
  	 * @exception Exception
  	 */
      @Transactional
      public int deletePsnl0119(HashMap hMap) throws Exception {
      	return delete("psnl0119DAO.deletePsnl0119_H", hMap);
      }

    /**
	 * PSNL0119을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0119VO
	 * @return 조회한 PSNL0119
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectPsnl0119(HashMap<String, String> hMap) throws Exception {
        return list("psnl0119DAO.selectPsnl0119", hMap);
    }

 
}
