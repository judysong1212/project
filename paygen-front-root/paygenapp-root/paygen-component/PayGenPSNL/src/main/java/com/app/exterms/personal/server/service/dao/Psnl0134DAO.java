package com.app.exterms.personal.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.server.vo.Psnl0134SrhVO;
import com.app.exterms.personal.server.vo.Psnl0134VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0134DAO.java
 * @Description : Psnl0134 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0134DAO")
public class Psnl0134DAO extends EgovAbstractDAO {
	

	/**
	 * PSNL0134을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0134VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPsnl0134(Psnl0134VO psnl0134Vo) throws Exception {
        return (String)insert("psnl0134DAO.insertPsnl0134", psnl0134Vo);
    }

    /**
	 * PSNL0134을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0134VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePsnl0134(Psnl0134VO psnl0134Vo) throws Exception {
        update("psnl0134DAO.updatePsnl0134", psnl0134Vo);
    }

    /**
	 * PSNL0134을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0134VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePsnl0134(Psnl0134VO psnl0134Vo) throws Exception {
        delete("psnl0134DAO.deletePsnl0134", psnl0134Vo);
    }

    /**
	 * PSNL0134을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0134VO
	 * @return 조회한 PSNL0134
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectPsnl0134(Psnl0134SrhVO psnl0134SrhVo) throws Exception {
        return list("psnl0134DAO.selectPsnl0134", psnl0134SrhVo);
    }

   

}
