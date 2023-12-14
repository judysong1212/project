package com.app.exterms.personal.server.service.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.server.vo.Psnl0116VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0116DAO.java
 * @Description : Psnl0116 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0116DAO")
public class Psnl0116DAO extends EgovAbstractDAO {

	/**
	 * PSNL0116을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0116VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//    @Transactional
//    public String insertPsnl0116(Psnl0116DTO dto) throws Exception {
//        return (String)insert("psnl0116DAO.insertPsnl0116", dto);
//    }
    
    @Transactional
    public String insertPsnl0116(Psnl0116VO Psnl0116Vo) throws Exception {
        return (String)insert("psnl0116DAO.insertPsnl0116", Psnl0116Vo);
    }

    /**
	 * PSNL0116을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0116VO
	 * @return void형
	 * @exception Exception
	 */
//    @Transactional
//    public int updatePsnl0116(Psnl0116DTO dto) throws Exception {
//        return update("psnl0116DAO.updatePsnl0116", dto);
//    }
    
    @Transactional
    public int updatePsnl0116(Psnl0116VO Psnl0116Vo) throws Exception {
        return update("psnl0116DAO.updatePsnl0116", Psnl0116Vo);
    }

    /**
	 * PSNL0116을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0116VO
	 * @return void형 
	 * @exception Exception
	 */
//    @Transactional
//    public int deletePsnl0116(Psnl0116DTO dto) throws Exception {
//        return delete("psnl0116DAO.deletePsnl0116", dto);
//    }
    @Transactional
    public int deletePsnl0116(Psnl0116VO Psnl0116Vo) throws Exception {
        return delete("psnl0116DAO.deletePsnl0116", Psnl0116Vo);
    }   
    
    
    /**
   	 * PSNL0116을 삭제한다.
   	 * @param vo - 삭제할 정보가 담긴 Psnl0116VO
   	 * @return void형 
   	 * @exception Exception
   	 */
       @Transactional
       public int deletePsnl0116(HashMap hMap) throws Exception {
           return delete("psnl0116DAO.deletePsnl0116_H", hMap);
       }

    /**
	 * PSNL0116을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0116VO
	 * @return 조회한 PSNL0116
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectPsnl0116(HashMap<String, String> hMap) throws Exception {
        return list("psnl0116DAO.selectPsnl0116", hMap);
    }

}
