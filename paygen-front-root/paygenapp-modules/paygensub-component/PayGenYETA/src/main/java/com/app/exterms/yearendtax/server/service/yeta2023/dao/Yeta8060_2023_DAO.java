package com.app.exterms.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.client.dto.yeta2023.Yeta8060DTO;
import com.app.exterms.yearendtax.server.vo.Yeta3060Srh_2023_VO;
import com.app.exterms.yearendtax.server.vo.Yeta3060_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta8060DAO.java
 * @Description : Yeta8060 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta8060_2023_DAO")
public class Yeta8060_2023_DAO extends EgovAbstractDAO {
	
	@SuppressWarnings("rawtypes")
	public List getParentDpobCd() throws Exception{
		return list("Yeta8060_2023_DAO.getParentDpobCd", null);
	} 
	
	// 시스템 사업장 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List getSysDpobCd() throws Exception{
		return list("Yeta8060_2023_DAO.getSysDpobCd", null);
	}
	
	@SuppressWarnings("rawtypes")
	public List getParentRetryCllnDebrDivCd() throws Exception{
		return list("Yeta8060_2023_DAO.selectYeta8060RetryCllnDebrDivCdList", null);
	}

	// 사용 시스템 구분 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List selectYeta8060sysDivCdList() throws Exception{
		return list("Yeta8060_2023_DAO.getUseSysDivCd", null);
	}
	/**		
	@Transactional
	public int saveYeta8060(InfcYeta8060DTO dto) throws Exception{
		return update("Yeta8060DAO.saveYeta8060", dto);
	}
	 */	
	
	@Transactional
	public int saveYeta8060(Yeta8060DTO dto) throws Exception{
		return update("Yeta8060_2023_DAO.saveYeta8060", dto);
	}
	/**
	 * Yeta8060을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta8060VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String insertYeta8060(Yeta3060_2023_VO vo) throws Exception {
        return (String)insert("Yeta8060_2023_DAO.insertYeta8060_S", vo);
    }

    /**
	 * Yeta8060을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta8060VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
    public void updateYeta8060(Yeta3060_2023_VO vo) throws Exception {
        update("Yeta8060_2023_DAO.updateYeta8060_S", vo);
    }

    /**
	 * Yeta8060을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta8060VO
	 * @return void형 
	 * @exception Exception
	 */
	/**
	@Transactional
    public int deleteYeta8060(InfcYeta8060DTO dto) throws Exception {
        return delete("Yeta8060DAO.deleteYeta8060_S", dto);
    }
	*/
	@Transactional
    public int deleteYeta8060(Yeta8060DTO dto) throws Exception {
        return delete("Yeta8060_2023_DAO.deleteYeta8060_S", dto);
    }

    /**
	 * Yeta8060을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta8060VO
	 * @return 조회한 Yeta8060
	 * @exception Exception
	 */
    public Yeta3060_2023_VO selectYeta8060(Yeta3060_2023_VO vo) throws Exception {
        return (Yeta3060_2023_VO) selectByPk("Yeta8060_2023_DAO.selectYeta8060_S", vo);
    }

    /**
	 * Yeta8060 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return Yeta8060 목록
	 * @exception Exception
	 */
    public List selectYeta8060List(Yeta3060Srh_2023_VO searchVO) throws Exception {
        return list("Yeta8060_2023_DAO.selectYeta8060List_D", searchVO);
    }

    /**
	 * Yeta8060 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return Yeta8060 총 갯수
	 * @exception
	 */
    public int selectYeta8060ListTotCnt(Yeta3060Srh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("Yeta8060_2023_DAO.selectYeta8060ListTotCnt_S", searchVO);
    }

    /**
     * Yeta8060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta8060 목록
     * @exception Exception
     */
    public List selectYetaM806001List(Yeta3060Srh_2023_VO searchVO) throws Exception {
    	return list("Yeta8060_2023_DAO.selectYetaM806001List_D", searchVO);
    }
    
    /**
     * Yeta8060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta8060 총 갯수
     * @exception
     */
    public int selectYetaM806001ListTotCnt(Yeta3060Srh_2023_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta8060_2023_DAO.selectYetaM806001ListTotCnt_S", searchVO);
    }
    
    /**
     * Yeta8060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta8060 목록
     * @exception Exception
     */
    public List selectYetaS806001List(Yeta3060Srh_2023_VO searchVO) throws Exception {
    	return list("Yeta8060_2023_DAO.selectYetaS806001List_D", searchVO);
    }
    
    /**
     * Yeta8060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta8060 총 갯수
     * @exception
     */
    public int selectYetaS806001ListTotCnt(Yeta3060Srh_2023_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta8060_2023_DAO.selectYetaS806001ListTotCnt_S", searchVO);
    }
    
    @Transactional
    public int deleteYeta806001(Yeta3060_2023_VO vo) throws Exception {
        return update("Yeta8060_2023_DAO.deleteYeta806001_S", vo);
    }
    
    @Transactional
    public int insertYetaS806001(Yeta3060_2023_VO vo) throws Exception {
        return update("Yeta8060_2023_DAO.insertYetaS806001_S", vo);
    }
    
    @Transactional
    public int updateNumYetaS806001(Yeta3060_2023_VO vo) throws Exception {
    	return update("Yeta8060_2023_DAO.updateNumYetaS806001_S", vo);
    }

    public int sum(int a, int b){
    	return a+b;
    }
}
