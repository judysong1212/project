package com.app.exterms.personal.server.service.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.client.dto.Psnl0127DTO;
import com.app.exterms.personal.server.vo.Psnl0127SrhVO;
import com.app.exterms.personal.server.vo.Psnl0127VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0127DAO.java
 * @Description : Psnl0127 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0127DAO")
public class Psnl0127DAO extends EgovAbstractDAO {

	/**
	 * @param hMap
	 * @return
	 * @throws Exception
	 */
    @Transactional
	public String insertPsnl0127(Psnl0127DTO dto) throws Exception {
        return (String)insert("psnl0127DAO.insertPsnl0127", dto);
    }

    /**
     * @param hMap
     * @throws Exception
     */
    @Transactional
    public int updatePsnl0127(Psnl0127DTO dto) throws Exception {
    	return update("psnl0127DAO.updatePsnl0127", dto);
    }
    
    /**
     * 급여대상자관리에 기본정보 수정시 처리 업데이트 
     * @param hMap
     * @throws Exception
     */
    @Transactional
    public int updatePsnl0127ToPayr4100(Psnl0127VO vo) throws Exception {
        return update("psnl0127DAO.updatePsnl0127ToPayr4100_S", vo);
    }

    /**
     * @param hMap
     * @throws Exception
     */
    @Transactional
    public int deletePsnl0127(Psnl0127DTO dto) throws Exception {
        return delete("psnl0127DAO.deletePsnl0127", dto);
    }

    /**
	 * PSNL0127을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0127VO
	 * @return 조회한 PSNL0127
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectPsnl0127(HashMap<String, String> hMap) throws Exception {
        return list("psnl0127DAO.selectPsnl0127", hMap);
    }
    

    /**
     * PSNL0127을 등록한다.
     * @param vo - 등록할 정보가 담긴 Psnl0127VO
     * @return 등록 결과
     * @exception Exception
     */
    @Transactional
    public String insertPsnl0127(Psnl0127VO vo) throws Exception {
        return (String)insert("psnl0127DAO.insertPsnl0127_S", vo);
    }

    /**
     * PSNL0127을 수정한다.
     * @param vo - 수정할 정보가 담긴 Psnl0127VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updatePsnl0127(Psnl0127VO vo) throws Exception {
        update("psnl0127DAO.updatePsnl0127_S", vo);
    }

    /**
     * PSNL0127을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Psnl0127VO
     * @return void형 
     * @exception Exception
     */
    @Transactional
    public void deletePsnl0127(Psnl0127VO vo) throws Exception {
        delete("psnl0127DAO.deletePsnl0127_S", vo);
    }
    
    /**
     * PSNL0127을 조회한다.
     * @param vo - 조회할 정보가 담긴 Psnl0127VO
     * @return 조회한 PSNL0127
     * @exception Exception
     */
    public Psnl0127VO selectPsnl0127Data(Psnl0127SrhVO Psnl0127SrhVo) throws Exception {
        return (Psnl0127VO) selectByPk("psnl0127DAO.selectPsnl0127Data", Psnl0127SrhVo);
    }

    /**
     * PSNL0127을 조회한다.
     * @param vo - 조회할 정보가 담긴 Psnl0127VO
     * @return 조회한 PSNL0127
     * @exception Exception
     */
    public Psnl0127VO selectPsnl0127(Psnl0127VO vo) throws Exception {
        return (Psnl0127VO) selectByPk("psnl0127DAO.selectPsnl0127_S", vo);
    }
    


}
