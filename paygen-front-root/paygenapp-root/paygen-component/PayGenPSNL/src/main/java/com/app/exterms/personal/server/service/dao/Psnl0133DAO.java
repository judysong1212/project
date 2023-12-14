package com.app.exterms.personal.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.server.vo.Psnl0133SrhVO;
import com.app.exterms.personal.server.vo.Psnl0133VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0133DAO.java
 * @Description : Psnl0133 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0133DAO")
public class Psnl0133DAO extends EgovAbstractDAO {
	

	/**
	 * PSNL0133을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0133VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPsnl0133(Psnl0133VO psnl0133Vo) throws Exception {
        return (String)insert("psnl0133DAO.insertPsnl0133", psnl0133Vo);
    }

    /**
	 * PSNL0133을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0133VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePsnl0133(Psnl0133VO psnl0133Vo) throws Exception {
        update("psnl0133DAO.updatePsnl0133", psnl0133Vo);
    }

    /**
	 * PSNL0133을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0133VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePsnl0133(Psnl0133VO psnl0133Vo) throws Exception {
        delete("psnl0133DAO.deletePsnl0133", psnl0133Vo);
    }

    /**
	 * PSNL0133을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0133VO
	 * @return 조회한 PSNL0133
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectPsnl0133(Psnl0133SrhVO psnl0133SrhVo) throws Exception {
        return list("psnl0133DAO.selectPsnl0133", psnl0133SrhVo);
    }

   

}
