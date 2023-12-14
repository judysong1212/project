package com.app.exterms.personal.server.service.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.client.dto.Psnl0112DTO;
import com.app.exterms.personal.server.vo.Psnl0112VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : Psnl0112DAO.java
 * @Description : Psnl0112 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0112DAO")
public class Psnl0112DAO extends EgovAbstractDAO {

	/**
	 * PSNL0112을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0112VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public int insertPsnl0112(Psnl0112DTO dto) throws Exception {
        return (Integer)insert("psnl0112DAO.insertPsnl0112", dto);
    }

    /**
	 * PSNL0112을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0112VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public int updatePsnl0112(Psnl0112DTO dto) throws Exception {
        return update("psnl0112DAO.updatePsnl0112", dto);
    }

    /**
	 * PSNL0112을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0112VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public int deletePsnl0112(Psnl0112DTO dto) throws Exception {
        return delete("psnl0112DAO.deletePsnl0112", dto);
    }
    
    /**
	 * PSNL0112을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0112VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public int deletePsnl0112(HashMap hMap) throws Exception {
        return delete("psnl0112DAO.deletePsnl0112_H", hMap);
    }

    /**
	 * PSNL0112을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0112VO
	 * @return 조회한 PSNL0112
	 * @exception Exception
	 */
    public EgovMap selectPsnl0112(Psnl0112DTO dto) throws Exception {
    	return (EgovMap) selectByPk("psnl0112DAO.selectPsnl0112", dto);
    }

    @Transactional
	public int savePsnl0112(Psnl0112DTO dto) {
		// TODO Auto-generated method stub
		return update("psnl0112DAO.savePsnl0112", dto);
	}

    /**
   	 * PSNL0112을 수정한다.
   	 * @param vo - 수정할 정보가 담긴 Psnl0112VO
   	 * @return void형
   	 * @exception Exception
   	 */
       @Transactional
       public int updatePsnl0320ToPsnl0112(Psnl0112VO vo) throws Exception {
           return update("psnl0112DAO.updatePsnl0320ToPsnl0112", vo);
       }

}
