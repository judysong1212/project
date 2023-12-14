package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.client.dto.yeta2018.Yeta3060DTO;
import com.app.exterms.yearendtax.server.vo.Yeta3060Srh_2018_VO;
import com.app.exterms.yearendtax.server.vo.Yeta3060_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3060DAO.java
 * @Description : Yeta3060 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta3060_2018_DAO")
public class Yeta3060_2018_DAO extends EgovAbstractDAO {
	
	@SuppressWarnings("rawtypes")
	public List getParentDpobCd() throws Exception{
		return list("Yeta3060_2018_DAO.getParentDpobCd", null);
	} 
	
	// 시스템 사업장 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List getSysDpobCd() throws Exception{
		return list("Yeta3060_2018_DAO.getSysDpobCd", null);
	}
	
	@SuppressWarnings("rawtypes")
	public List getParentRetryCllnDebrDivCd() throws Exception{
		return list("Yeta3060_2018_DAO.selectYeta3060RetryCllnDebrDivCdList", null);
	}

	// 사용 시스템 구분 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List selectYeta3060sysDivCdList() throws Exception{
		return list("Yeta3060_2018_DAO.getUseSysDivCd", null);
	}
	/**		
	@Transactional
	public int saveYeta3060(InfcYeta3060DTO dto) throws Exception{
		return update("Yeta3060DAO.saveYeta3060", dto);
	}
	 */	
	
	@Transactional
	public int saveYeta3060(Yeta3060DTO dto) throws Exception{
		return update("Yeta3060_2018_DAO.saveYeta3060", dto);
	}
	/**
	 * Yeta3060을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3060VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String insertYeta3060(Yeta3060_2018_VO vo) throws Exception {
        return (String)insert("Yeta3060_2018_DAO.insertYeta3060_S", vo);
    }

    /**
	 * Yeta3060을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3060VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
    public void updateYeta3060(Yeta3060_2018_VO vo) throws Exception {
        update("Yeta3060_2018_DAO.updateYeta3060_S", vo);
    }

    /**
	 * Yeta3060을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3060VO
	 * @return void형 
	 * @exception Exception
	 */
	/**
	@Transactional
    public int deleteYeta3060(InfcYeta3060DTO dto) throws Exception {
        return delete("Yeta3060DAO.deleteYeta3060_S", dto);
    }
	*/
	@Transactional
    public int deleteYeta3060(Yeta3060DTO dto) throws Exception {
        return delete("Yeta3060_2018_DAO.deleteYeta3060_S", dto);
    }

    /**
	 * Yeta3060을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3060VO
	 * @return 조회한 Yeta3060
	 * @exception Exception
	 */
    public Yeta3060_2018_VO selectYeta3060(Yeta3060_2018_VO vo) throws Exception {
        return (Yeta3060_2018_VO) selectByPk("Yeta3060_2018_DAO.selectYeta3060_S", vo);
    }

    /**
	 * Yeta3060 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return Yeta3060 목록
	 * @exception Exception
	 */
    public List selectYeta3060List(Yeta3060Srh_2018_VO searchVO) throws Exception {
        return list("Yeta3060_2018_DAO.selectYeta3060List_D", searchVO);
    }

    /**
	 * Yeta3060 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return Yeta3060 총 갯수
	 * @exception
	 */
    public int selectYeta3060ListTotCnt(Yeta3060Srh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("Yeta3060_2018_DAO.selectYeta3060ListTotCnt_S", searchVO);
    }

    /**
     * Yeta3060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta3060 목록
     * @exception Exception
     */
    public List selectYetaM306001List(Yeta3060Srh_2018_VO searchVO) throws Exception {
    	return list("Yeta3060_2018_DAO.selectYetaM306001List_D", searchVO);
    }
    
    /**
     * Yeta3060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta3060 총 갯수
     * @exception
     */
    public int selectYetaM306001ListTotCnt(Yeta3060Srh_2018_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta3060_2018_DAO.selectYetaM306001ListTotCnt_S", searchVO);
    }
    
    /**
     * Yeta3060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta3060 목록
     * @exception Exception
     */
    public List selectYetaS306001List(Yeta3060Srh_2018_VO searchVO) throws Exception {
    	return list("Yeta3060_2018_DAO.selectYetaS306001List_D", searchVO);
    }
    
    /**
     * Yeta3060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta3060 총 갯수
     * @exception
     */
    public int selectYetaS306001ListTotCnt(Yeta3060Srh_2018_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta3060_2018_DAO.selectYetaS306001ListTotCnt_S", searchVO);
    }
    
    @Transactional
    public int deleteYeta306001(Yeta3060_2018_VO vo) throws Exception {
        return update("Yeta3060_2018_DAO.deleteYeta306001_S", vo);
    }
    
    @Transactional
    public int insertYetaS306001(Yeta3060_2018_VO vo) throws Exception {
        return update("Yeta3060_2018_DAO.insertYetaS306001_S", vo);
    }
    
    @Transactional
    public int updateNumYetaS306001(Yeta3060_2018_VO vo) throws Exception {
    	return update("Yeta3060_2018_DAO.updateNumYetaS306001_S", vo);
    }

    public int sum(int a, int b){
    	return a+b;
    }
}
