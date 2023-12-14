package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.client.dto.yeta2017.Yeta2060DTO;
import com.app.exterms.yearendtax.server.vo.Yeta2060SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta2060VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta2060DAO.java
 * @Description : Yeta2060 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta2060DAO")
public class Yeta2060DAO extends EgovAbstractDAO {
	
	@SuppressWarnings("rawtypes")
	public List getParentDpobCd() throws Exception{
		return list("Yeta2060DAO.getParentDpobCd", null);
	} 
	
	// 시스템 사업장 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List getSysDpobCd() throws Exception{
		return list("Yeta2060DAO.getSysDpobCd", null);
	}
	
	@SuppressWarnings("rawtypes")
	public List getParentRetryCllnDebrDivCd() throws Exception{
		return list("Yeta2060DAO.selectYeta2060RetryCllnDebrDivCdList", null);
	}

	// 사용 시스템 구분 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List selectYeta2060sysDivCdList() throws Exception{
		return list("Yeta2060DAO.getUseSysDivCd", null);
	}
	/**		
	@Transactional
	public int saveYeta2060(InfcYeta2060DTO dto) throws Exception{
		return update("Yeta2060DAO.saveYeta2060", dto);
	}
	 */	
	
	@Transactional
	public int saveYeta2060(Yeta2060DTO dto) throws Exception{
		return update("Yeta2060DAO.saveYeta2060", dto);
	}
	/**
	 * Yeta2060을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta2060VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String insertYeta2060(Yeta2060VO vo) throws Exception {
        return (String)insert("Yeta2060DAO.insertYeta2060_S", vo);
    }

    /**
	 * Yeta2060을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta2060VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
    public void updateYeta2060(Yeta2060VO vo) throws Exception {
        update("Yeta2060DAO.updateYeta2060_S", vo);
    }

    /**
	 * Yeta2060을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta2060VO
	 * @return void형 
	 * @exception Exception
	 */
	/**
	@Transactional
    public int deleteYeta2060(InfcYeta2060DTO dto) throws Exception {
        return delete("Yeta2060DAO.deleteYeta2060_S", dto);
    }
	*/
	@Transactional
    public int deleteYeta2060(Yeta2060DTO dto) throws Exception {
        return delete("Yeta2060DAO.deleteYeta2060_S", dto);
    }

    /**
	 * Yeta2060을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta2060VO
	 * @return 조회한 Yeta2060
	 * @exception Exception
	 */
    public Yeta2060VO selectYeta2060(Yeta2060VO vo) throws Exception {
        return (Yeta2060VO) selectByPk("Yeta2060DAO.selectYeta2060_S", vo);
    }

    /**
	 * Yeta2060 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return Yeta2060 목록
	 * @exception Exception
	 */
    public List selectYeta2060List(Yeta2060SrhVO searchVO) throws Exception {
        return list("Yeta2060DAO.selectYeta2060List_D", searchVO);
    }

    /**
	 * Yeta2060 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return Yeta2060 총 갯수
	 * @exception
	 */
    public int selectYeta2060ListTotCnt(Yeta2060SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("Yeta2060DAO.selectYeta2060ListTotCnt_S", searchVO);
    }
    
    /**
     * Yeta2060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta2060 목록
     * @exception Exception
     */
    public List selectYetaM206001List(Yeta2060SrhVO searchVO) throws Exception {
    	return list("Yeta2060DAO.selectYetaM206001List_D", searchVO);
    }
    
    /**
     * Yeta2060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta2060 총 갯수
     * @exception
     */
    public int selectYetaM206001ListTotCnt(Yeta2060SrhVO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta2060DAO.selectYetaM206001ListTotCnt_S", searchVO);
    }
    
    /**
     * Yeta2060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta2060 목록
     * @exception Exception
     */
    public List selectYetaS206001List(Yeta2060SrhVO searchVO) throws Exception {
    	return list("Yeta2060DAO.selectYetaS206001List_D", searchVO);
    }
    
    /**
     * Yeta2060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta2060 총 갯수
     * @exception
     */
    public int selectYetaS206001ListTotCnt(Yeta2060SrhVO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta2060DAO.selectYetaS206001ListTotCnt_S", searchVO);
    }
    
    @Transactional
    public int deleteYeta206001(Yeta2060VO vo) throws Exception {
        return update("Yeta2060DAO.deleteYeta206001_S", vo);
    }
    
    @Transactional
    public int insertYetaS206001(Yeta2060VO vo) throws Exception {
        return update("Yeta2060DAO.insertYetaS206001_S", vo);
    }
    
    @Transactional
    public int updateNumYetaS206001(Yeta2060VO vo) throws Exception {
    	return update("Yeta2060DAO.updateNumYetaS206001_S", vo);
    }

    public int sum(int a, int b){
    	return a+b;
    }
}
