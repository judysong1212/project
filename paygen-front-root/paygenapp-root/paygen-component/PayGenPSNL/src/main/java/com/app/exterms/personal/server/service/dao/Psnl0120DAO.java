package com.app.exterms.personal.server.service.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.client.dto.Psnl0120DTO;
import com.app.exterms.personal.server.vo.Psnl0120VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0120DAO.java
 * @Description : Psnl0120 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0120DAO")
public class Psnl0120DAO extends EgovAbstractDAO {
	
	public String insertPsnl0120Excel(Psnl0120DTO dto) throws Exception {
        return (String)insert("psnl0120DAO.insertPsnl0120Excel", dto);
    }
	/**
	 * PSNL0120을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0120VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//	@Transactional
//    public String insertPsnl0120(Psnl0120DTO dto) throws Exception {
//        return (String)insert("psnl0120DAO.insertPsnl0120", dto);
//    }
	
	@Transactional
    public String insertPsnl0120(Psnl0120VO psnl0120Vo) throws Exception {
        return (String)insert("psnl0120DAO.insertPsnl0120", psnl0120Vo);
    }

    /**
	 * PSNL0120을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0120VO
	 * @return void형
	 * @exception Exception
	 */
//	@Transactional
//    public void updatePsnl0120(Psnl0120DTO dto) throws Exception {
//        update("psnl0120DAO.updatePsnl0120", dto);
//    }
	
	@Transactional
    public void updatePsnl0120(Psnl0120VO psnl0120Vo) throws Exception {
        update("psnl0120DAO.updatePsnl0120", psnl0120Vo);
    }

    /**
	 * PSNL0120을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0120VO
	 * @return void형 
	 * @exception Exception
	 */
//	@Transactional
//    public void deletePsnl0120(Psnl0120DTO dto) throws Exception {
//        delete("psnl0120DAO.deletePsnl0120", dto);
//    }
	
	@Transactional
    public void deletePsnl0120(Psnl0120VO psnl0120Vo) throws Exception {
        delete("psnl0120DAO.deletePsnl0120", psnl0120Vo);
    }

    /**
	 * PSNL0120을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0120VO
	 * @return 조회한 PSNL0120
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectPsnl0120(HashMap<String, String> hMap) throws Exception {
        return list("psnl0120DAO.selectPsnl0120", hMap);
    }



}
