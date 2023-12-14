package com.app.exterms.personal.server.service.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.server.vo.Psnl0122VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0122DAO.java
 * @Description : Psnl0122 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0122DAO")
public class Psnl0122DAO extends EgovAbstractDAO {

	/**
	 * PSNL0122을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0122VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//    @Transactional
//    public String insertPsnl0122(Psnl0122DTO dto) throws Exception {
//        return (String)insert("psnl0122DAO.insertPsnl0122", dto);
//    }
    
    @Transactional
    public String insertPsnl0122(Psnl0122VO psnl0122Vo) throws Exception {
        return (String)insert("psnl0122DAO.insertPsnl0122", psnl0122Vo);
    }

    /**
	 * PSNL0122을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0122VO
	 * @return void형
	 * @exception Exception
	 */
//    @Transactional
//    public void updatePsnl0122(Psnl0122DTO dto) throws Exception {
//        update("psnl0122DAO.updatePsnl0122", dto);
//    }
    
    @Transactional
    public void updatePsnl0122(Psnl0122VO psnl0122Vo) throws Exception {
        update("psnl0122DAO.updatePsnl0122", psnl0122Vo);
    }

    /**
	 * PSNL0122을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0122VO
	 * @return void형 
	 * @exception Exception
	 */
//    @Transactional
//    public void deletePsnl0122(Psnl0122DTO dto) throws Exception {
//        delete("psnl0122DAO.deletePsnl0122", dto);
//    }
    
    @Transactional
    public void deletePsnl0122(Psnl0122VO psnl0122Vo) throws Exception {
        delete("psnl0122DAO.deletePsnl0122", psnl0122Vo);
    }

    /**
	 * PSNL0122을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0122VO
	 * @return 조회한 PSNL0122
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectPsnl0122(HashMap<String, String> hMap) throws Exception {
        return list("psnl0122DAO.selectPsnl0122", hMap);
    }

   

}
