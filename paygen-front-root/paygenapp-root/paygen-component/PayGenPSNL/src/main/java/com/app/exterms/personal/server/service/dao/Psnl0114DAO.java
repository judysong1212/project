package com.app.exterms.personal.server.service.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.server.vo.Psnl0114VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0114DAO.java
 * @Description : Psnl0114 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0114DAO")
public class Psnl0114DAO extends EgovAbstractDAO {

	/**
	 * PSNL0114을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0114VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//    @Transactional
//    public String insertPsnl0114(Psnl0114DTO dto) throws Exception {
//        return (String)insert("psnl0114DAO.insertPsnl0114", dto);
//    }
	
    @Transactional
    public String insertPsnl0114(Psnl0114VO psnl0114Vo) throws Exception {
        return (String)insert("psnl0114DAO.insertPsnl0114", psnl0114Vo);
    }

    /**
	 * PSNL0114을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0114VO
	 * @return void형
	 * @exception Exception
	 */
//    @Transactional
//    public int updatePsnl0114(Psnl0114DTO dto) throws Exception {
//        return update("psnl0114DAO.updatePsnl0114", dto);
//    }
    
    @Transactional
    public int updatePsnl0114(Psnl0114VO psnl0114Vo) throws Exception {
        return update("psnl0114DAO.updatePsnl0114", psnl0114Vo);
    }

    /**
	 * PSNL0114을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0114VO
	 * @return void형 
	 * @exception Exception
	 */
//    @Transactional
//    public int deletePsnl0114(Psnl0114DTO dto) throws Exception {
//        return delete("psnl0114DAO.deletePsnl0114", dto);
//    }
    @Transactional
    public int deletePsnl0114(Psnl0114VO psnl0114Vo ) throws Exception {
        return delete("psnl0114DAO.deletePsnl0114", psnl0114Vo);
    }

    /**
	 * PSNL0114을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0114VO
	 * @return 조회한 PSNL0114
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectPsnl0114(HashMap<String, String> hMap) throws Exception {
        return list("psnl0114DAO.selectPsnl0114", hMap);
    }
    
    
    /**
	 * PAYR0470을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0114VO
	 * @return 조회한 PAYR0470
	 * @exception Exception
	 */
	public List getPayrDducCd() throws Exception {
		return list("psnl0114DAO.getPayrDducCd", null);
	}

    
}
