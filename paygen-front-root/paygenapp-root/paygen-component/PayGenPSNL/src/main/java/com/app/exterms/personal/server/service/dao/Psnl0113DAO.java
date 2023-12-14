package com.app.exterms.personal.server.service.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.client.dto.Psnl0113DTO;
import com.app.exterms.personal.server.vo.Psnl0113SrhVO;
import com.app.exterms.personal.server.vo.Psnl0113VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : Psnl0113DAO.java
 * @Description : Psnl0113 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0113DAO")
public class Psnl0113DAO extends EgovAbstractDAO {

	/**
	 * PSNL0113을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0113VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPsnl0113(Psnl0113DTO dto) throws Exception {
        return (String) insert("psnl0113DAO.insertPsnl0113", dto);
    }	
    
    /**
	 * PSNL0113을 등록한다.(신규고용엑셀업로드시)
	 * @param vo - 등록할 정보가 담긴 Psnl0113VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPsnl0113_S(Psnl0113VO psnl0113Vo) throws Exception {
        return (String) insert("psnl0113DAO.insertPsnl0113_S", psnl0113Vo);
    }
    
    

    /**
	 * PSNL0113을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0113VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public int updatePsnl0113(Psnl0113DTO dto) throws Exception {
        return update("psnl0113DAO.updatePsnl0113", dto);
    }

    /**
	 * PSNL0113을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0113VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public int deletePsnl0113(Psnl0113DTO dto) throws Exception {
        return delete("psnl0113DAO.deletePsnl0113", dto);
    }
    
    /**
	 * PSNL0113을 삭제한다.
	 * @param hMap - 삭제할 정보가 담긴 HashMap
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public int deletePsnl0113(HashMap hMap) throws Exception {
        return delete("psnl0113DAO.deletePsnl0113_H", hMap);
    }

    /**
	 * PSNL0113을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0113VO
	 * @return 조회한 PSNL0113
	 * @exception Exception
	 */
    public EgovMap selectPsnl0113(Psnl0113DTO dto) throws Exception {
        return (EgovMap) selectByPk("psnl0113DAO.selectPsnl0113", dto);
    }

    @Transactional
	public int savePsnl0113(Psnl0113DTO dto) {
		// TODO Auto-generated method stub
		return update("psnl0113DAO.savePsnl0113", dto);
		
	}
    
    
    /**
	 * PSNL0113 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0100 총 갯수
	 */
    public int selectPsnl0113ListTotCnt(Psnl0113SrhVO psnl0113SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0113DAO.selectPsnl0113ListTotCnt_S", psnl0113SrhVo);
    }

    

}
