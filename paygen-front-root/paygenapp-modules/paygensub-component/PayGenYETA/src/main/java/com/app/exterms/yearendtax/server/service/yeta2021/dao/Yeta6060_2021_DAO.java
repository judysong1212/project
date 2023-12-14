package com.app.exterms.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.client.dto.yeta2021.Yeta6060DTO;
import com.app.exterms.yearendtax.server.vo.Yeta3060Srh_2021_VO;
import com.app.exterms.yearendtax.server.vo.Yeta3060_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta6060DAO.java
 * @Description : Yeta6060 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta6060_2021_DAO")
public class Yeta6060_2021_DAO extends EgovAbstractDAO {
	
	@SuppressWarnings("rawtypes")
	public List getParentDpobCd() throws Exception{
		return list("Yeta6060_2021_DAO.getParentDpobCd", null);
	} 
	
	// 시스템 사업장 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List getSysDpobCd() throws Exception{
		return list("Yeta6060_2021_DAO.getSysDpobCd", null);
	}
	
	@SuppressWarnings("rawtypes")
	public List getParentRetryCllnDebrDivCd() throws Exception{
		return list("Yeta6060_2021_DAO.selectYeta6060RetryCllnDebrDivCdList", null);
	}

	// 사용 시스템 구분 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List selectYeta6060sysDivCdList() throws Exception{
		return list("Yeta6060_2021_DAO.getUseSysDivCd", null);
	}
	/**		
	@Transactional
	public int saveYeta6060(InfcYeta6060DTO dto) throws Exception{
		return update("Yeta6060DAO.saveYeta6060", dto);
	}
	 */	
	
	@Transactional
	public int saveYeta6060(Yeta6060DTO dto) throws Exception{
		return update("Yeta6060_2021_DAO.saveYeta6060", dto);
	}
	/**
	 * Yeta6060을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta6060VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String insertYeta6060(Yeta3060_2021_VO vo) throws Exception {
        return (String)insert("Yeta6060_2021_DAO.insertYeta6060_S", vo);
    }

    /**
	 * Yeta6060을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta6060VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
    public void updateYeta6060(Yeta3060_2021_VO vo) throws Exception {
        update("Yeta6060_2021_DAO.updateYeta6060_S", vo);
    }

    /**
	 * Yeta6060을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta6060VO
	 * @return void형 
	 * @exception Exception
	 */
	/**
	@Transactional
    public int deleteYeta6060(InfcYeta6060DTO dto) throws Exception {
        return delete("Yeta6060DAO.deleteYeta6060_S", dto);
    }
	*/
	@Transactional
    public int deleteYeta6060(Yeta6060DTO dto) throws Exception {
        return delete("Yeta6060_2021_DAO.deleteYeta6060_S", dto);
    }

    /**
	 * Yeta6060을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta6060VO
	 * @return 조회한 Yeta6060
	 * @exception Exception
	 */
    public Yeta3060_2021_VO selectYeta6060(Yeta3060_2021_VO vo) throws Exception {
        return (Yeta3060_2021_VO) selectByPk("Yeta6060_2021_DAO.selectYeta6060_S", vo);
    }

    /**
	 * Yeta6060 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return Yeta6060 목록
	 * @exception Exception
	 */
    public List selectYeta6060List(Yeta3060Srh_2021_VO searchVO) throws Exception {
        return list("Yeta6060_2021_DAO.selectYeta6060List_D", searchVO);
    }

    /**
	 * Yeta6060 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return Yeta6060 총 갯수
	 * @exception
	 */
    public int selectYeta6060ListTotCnt(Yeta3060Srh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("Yeta6060_2021_DAO.selectYeta6060ListTotCnt_S", searchVO);
    }

    /**
     * Yeta6060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta6060 목록
     * @exception Exception
     */
    public List selectYetaM606001List(Yeta3060Srh_2021_VO searchVO) throws Exception {
    	return list("Yeta6060_2021_DAO.selectYetaM606001List_D", searchVO);
    }
    
    /**
     * Yeta6060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta6060 총 갯수
     * @exception
     */
    public int selectYetaM606001ListTotCnt(Yeta3060Srh_2021_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta6060_2021_DAO.selectYetaM606001ListTotCnt_S", searchVO);
    }
    
    /**
     * Yeta6060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta6060 목록
     * @exception Exception
     */
    public List selectYetaS606001List(Yeta3060Srh_2021_VO searchVO) throws Exception {
    	return list("Yeta6060_2021_DAO.selectYetaS606001List_D", searchVO);
    }
    
    /**
     * Yeta6060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta6060 총 갯수
     * @exception
     */
    public int selectYetaS606001ListTotCnt(Yeta3060Srh_2021_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta6060_2021_DAO.selectYetaS606001ListTotCnt_S", searchVO);
    }
    
    @Transactional
    public int deleteYeta606001(Yeta3060_2021_VO vo) throws Exception {
        return update("Yeta6060_2021_DAO.deleteYeta606001_S", vo);
    }
    
    @Transactional
    public int insertYetaS606001(Yeta3060_2021_VO vo) throws Exception {
        return update("Yeta6060_2021_DAO.insertYetaS606001_S", vo);
    }
    
    @Transactional
    public int updateNumYetaS606001(Yeta3060_2021_VO vo) throws Exception {
    	return update("Yeta6060_2021_DAO.updateNumYetaS606001_S", vo);
    }

    public int sum(int a, int b){
    	return a+b;
    }
}
