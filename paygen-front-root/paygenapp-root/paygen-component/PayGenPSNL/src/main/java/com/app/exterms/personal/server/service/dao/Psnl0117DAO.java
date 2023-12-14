package com.app.exterms.personal.server.service.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.client.dto.Psnl0117DTO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0117DAO.java
 * @Description : Psnl0117 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.0527
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0117DAO")
public class Psnl0117DAO extends EgovAbstractDAO {

	/**
	 * PSNL0117을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0117VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPsnl0117(Psnl0117DTO dto) throws Exception {
        return (String)insert("psnl0117DAO.insertPsnl0117", dto);
    }

    /**
	 * PSNL0117을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0117VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public int updatePsnl0117(Psnl0117DTO dto) throws Exception {
        return update("psnl0117DAO.updatePsnl0117", dto);
    }

    /**
	 * PSNL0117을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0117VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public int deletePsnl0117(Psnl0117DTO dto) throws Exception {
        return delete("psnl0117DAO.deletePsnl0117", dto);
    }

    /**
	 * PSNL0117을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0117VO
	 * @return 조회한 PSNL0117
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectPsnl0117(HashMap<String, String> hMap) throws Exception {
        return list("psnl0117DAO.selectPsnl0117", hMap);
    }


}
