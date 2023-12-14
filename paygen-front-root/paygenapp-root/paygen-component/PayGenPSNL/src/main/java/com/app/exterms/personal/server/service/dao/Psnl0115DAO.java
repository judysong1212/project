package com.app.exterms.personal.server.service.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.server.vo.Psnl0115VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0115DAO.java
 * @Description : Psnl0115 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0115DAO")
public class Psnl0115DAO extends EgovAbstractDAO {

	/**
	 * PSNL0115을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0115VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//    @Transactional
//    public String insertPsnl0115(Psnl0115DTO dto) throws Exception {
//        return (String)insert("psnl0115DAO.insertPsnl0115", dto);
//    }
    
    @Transactional
    public String insertPsnl0115(Psnl0115VO psnl0115Vo) throws Exception {
        return (String)insert("psnl0115DAO.insertPsnl0115", psnl0115Vo);
    }

    /**
	 * PSNL0115을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0115VO
	 * @return void형
	 * @exception Exception
	 */
//    @Transactional
//    public int updatePsnl0115(Psnl0115DTO dto) throws Exception {
//        return update("psnl0115DAO.updatePsnl0115", dto);
//    }
    
    @Transactional
    public int updatePsnl0115(Psnl0115VO psnl0115Vo) throws Exception {
        return update("psnl0115DAO.updatePsnl0115", psnl0115Vo);
    }

    /**
	 * PSNL0115을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0115VO
	 * @return void형 
	 * @exception Exception
	 */
//    @Transactional
//    public int deletePsnl0115(Psnl0115DTO dto) throws Exception {
//        return delete("psnl0115DAO.deletePsnl0115", dto);
//    }
    
    @Transactional
    public int deletePsnl0115(Psnl0115VO psnl0115Vo) throws Exception {
        return delete("psnl0115DAO.deletePsnl0115", psnl0115Vo);
    }
    
    /**
   	 * PSNL0115을 삭제한다.
   	 * @param vo - 삭제할 정보가 담긴 Psnl0115VO
   	 * @return void형 
   	 * @exception Exception
   	 */
       @Transactional
       public int deletePsnl0115(HashMap hMap) throws Exception {
           return delete("psnl0115DAO.deletePsnl0115_H", hMap);
       }

    /**
	 * PSNL0115을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0115VO
	 * @return 조회한 PSNL0115
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectPsnl0115(HashMap<String, String> hMap) throws Exception {
        return list("psnl0115DAO.selectPsnl0115", hMap);
    }

    

}
