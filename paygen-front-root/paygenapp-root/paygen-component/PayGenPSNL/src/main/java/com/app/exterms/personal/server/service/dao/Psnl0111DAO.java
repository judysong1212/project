package com.app.exterms.personal.server.service.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.client.dto.Psnl0111DTO;
import com.app.exterms.personal.server.vo.Psnl0111VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0111DAO.java
 * @Description : Psnl0111 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0111DAO")
public class Psnl0111DAO extends EgovAbstractDAO {
	
	
	
	/**
	 * PSNL0111을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0111VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public int insertPsnl0111(HashMap<String, String> hMap) throws Exception {
        return (Integer)insert("psnl0111DAO.insertPsnl0111", hMap);
    }
    
    @Transactional
    public String insertPsnl0111_S(Psnl0111VO psnl0111Vo) throws Exception {
        return (String)insert("psnl0111DAO.insertPsnl0111_S", psnl0111Vo);
    }


    /**
	 * PSNL0111을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0111VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public int updatePsnl0111(HashMap<String, String> hMap) throws Exception {
        return update("psnl0111DAO.updatePsnl0111", hMap);
    }

    /**
	 * PSNL0111을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0111VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public int deletePsnl0111(HashMap<String, String> hMap) throws Exception {
        return delete("psnl0111DAO.deletePsnl0111", hMap);
    }

    /**
	 * PSNL0111을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0111VO
	 * @return 조회한 PSNL0111
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectPsnl0111(HashMap<String, String> hMap) throws Exception {
        return list("psnl0111DAO.selectPsnl0111", hMap);
    }

    @Transactional
	public int savePsnl0111(Psnl0111DTO psnl0111Dto) throws Exception {
		// TODO Auto-generated method stub
		return update("psnl0111DAO.savePsnl0111",psnl0111Dto);
	}

   
}
