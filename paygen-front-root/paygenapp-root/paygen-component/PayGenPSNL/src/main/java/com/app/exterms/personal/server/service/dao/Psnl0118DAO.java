package com.app.exterms.personal.server.service.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.server.vo.Psnl0118VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0118DAO.java
 * @Description : Psnl0118 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0118DAO")
public class Psnl0118DAO extends EgovAbstractDAO {

	/**
	 * PSNL0118을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0118VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//    @Transactional
//    public String insertPsnl0118(Psnl0118DTO dto) throws Exception {
//        return (String)insert("psnl0118DAO.insertPsnl0118", dto);
//    }
    
    @Transactional
    public String insertPsnl0118(Psnl0118VO psnl0118Vo) throws Exception {
        return (String)insert("psnl0118DAO.insertPsnl0118", psnl0118Vo);
    }

    /**
	 * PSNL0118을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0118VO
	 * @return void형
	 * @exception Exception
	 */
//    @Transactional
//    public int updatePsnl0118(Psnl0118DTO dto) throws Exception {
//        return update("psnl0118DAO.updatePsnl0118", dto);
//    }
    
    @Transactional
    public int updatePsnl0118(Psnl0118VO psnl0118Vo) throws Exception {
        return update("psnl0118DAO.updatePsnl0118", psnl0118Vo);
    }

    /**
	 * PSNL0118을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0118VO
	 * @return void형 
	 * @exception Exception
	 */
//    @Transactional
//    public int deletePsnl0118(Psnl0118DTO dto) throws Exception {
//        return delete("psnl0118DAO.deletePsnl0118", dto);
//    }
    
    @Transactional
    public int deletePsnl0118(Psnl0118VO psnl0118Vo) throws Exception {
        return delete("psnl0118DAO.deletePsnl0118", psnl0118Vo);
    }

    /**
	 * PSNL0118을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0118VO
	 * @return 조회한 PSNL0118
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectPsnl0118(HashMap<String, String> hMap) throws Exception {
        return list("psnl0118DAO.selectPsnl0118", hMap);
    }

    
}
