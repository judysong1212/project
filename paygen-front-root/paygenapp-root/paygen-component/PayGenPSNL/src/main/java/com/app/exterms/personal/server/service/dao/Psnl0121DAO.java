package com.app.exterms.personal.server.service.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.server.vo.Psnl0121VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0121DAO.java
 * @Description : Psnl0121 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0121DAO")
public class Psnl0121DAO extends EgovAbstractDAO {

	/**
	 * PSNL0121을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0121VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//    @Transactional
//    public String insertPsnl0121(Psnl0121DTO dto) throws Exception {
//        return (String)insert("psnl0121DAO.insertPsnl0121", dto);
//    }
    
    @Transactional
    public String insertPsnl0121(Psnl0121VO psnl0121Vo) throws Exception {
        return (String)insert("psnl0121DAO.insertPsnl0121", psnl0121Vo);
    }

    /**
	 * PSNL0121을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0121VO
	 * @return void형
	 * @exception Exception
	 */
//    @Transactional
//    public int updatePsnl0121(Psnl0121DTO dto) throws Exception {
//        return update("psnl0121DAO.updatePsnl0121", dto);
//    }
    
    @Transactional
    public int updatePsnl0121(Psnl0121VO psnl0121Vo) throws Exception {
        return update("psnl0121DAO.updatePsnl0121", psnl0121Vo);
    }

    /**
	 * PSNL0121을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0121VO
	 * @return void형 
	 * @exception Exception
	 */
//    @Transactional
//    public int deletePsnl0121(Psnl0121DTO dto) throws Exception {
//        return delete("psnl0121DAO.deletePsnl0121", dto);
//    }
    
    @Transactional
    public int deletePsnl0121(Psnl0121VO psnl0121Vo) throws Exception {
        return delete("psnl0121DAO.deletePsnl0121", psnl0121Vo);
    }

    /**
	 * PSNL0121을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0121VO
	 * @return 조회한 PSNL0121
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectPsnl0121(HashMap<String,String> hMap) throws Exception {
        return list("psnl0121DAO.selectPsnl0121", hMap);
    }

    
}
