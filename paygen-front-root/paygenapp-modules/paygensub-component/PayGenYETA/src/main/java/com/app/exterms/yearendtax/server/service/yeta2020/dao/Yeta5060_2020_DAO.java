package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.client.dto.yeta2020.Yeta5060DTO;
import com.app.exterms.yearendtax.server.vo.Yeta3060Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Yeta3060_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta5060DAO.java
 * @Description : Yeta5060 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta5060_2020_DAO")
public class Yeta5060_2020_DAO extends EgovAbstractDAO {
	
	@SuppressWarnings("rawtypes")
	public List getParentDpobCd() throws Exception{
		return list("Yeta5060_2020_DAO.getParentDpobCd", null);
	} 
	
	// 시스템 사업장 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List getSysDpobCd() throws Exception{
		return list("Yeta5060_2020_DAO.getSysDpobCd", null);
	}
	
	@SuppressWarnings("rawtypes")
	public List getParentRetryCllnDebrDivCd() throws Exception{
		return list("Yeta5060_2020_DAO.selectYeta5060RetryCllnDebrDivCdList", null);
	}

	// 사용 시스템 구분 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List selectYeta5060sysDivCdList() throws Exception{
		return list("Yeta5060_2020_DAO.getUseSysDivCd", null);
	}
	/**		
	@Transactional
	public int saveYeta5060(InfcYeta5060DTO dto) throws Exception{
		return update("Yeta5060DAO.saveYeta5060", dto);
	}
	 */	
	
	@Transactional
	public int saveYeta5060(Yeta5060DTO dto) throws Exception{
		return update("Yeta5060_2020_DAO.saveYeta5060", dto);
	}
	/**
	 * Yeta5060을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta5060VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String insertYeta5060(Yeta3060_2020_VO vo) throws Exception {
        return (String)insert("Yeta5060_2020_DAO.insertYeta5060_S", vo);
    }

    /**
	 * Yeta5060을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta5060VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
    public void updateYeta5060(Yeta3060_2020_VO vo) throws Exception {
        update("Yeta5060_2020_DAO.updateYeta5060_S", vo);
    }

    /**
	 * Yeta5060을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta5060VO
	 * @return void형 
	 * @exception Exception
	 */
	/**
	@Transactional
    public int deleteYeta5060(InfcYeta5060DTO dto) throws Exception {
        return delete("Yeta5060DAO.deleteYeta5060_S", dto);
    }
	*/
	@Transactional
    public int deleteYeta5060(Yeta5060DTO dto) throws Exception {
        return delete("Yeta5060_2020_DAO.deleteYeta5060_S", dto);
    }

    /**
	 * Yeta5060을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta5060VO
	 * @return 조회한 Yeta5060
	 * @exception Exception
	 */
    public Yeta3060_2020_VO selectYeta5060(Yeta3060_2020_VO vo) throws Exception {
        return (Yeta3060_2020_VO) selectByPk("Yeta5060_2020_DAO.selectYeta5060_S", vo);
    }

    /**
	 * Yeta5060 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return Yeta5060 목록
	 * @exception Exception
	 */
    public List selectYeta5060List(Yeta3060Srh_2020_VO searchVO) throws Exception {
        return list("Yeta5060_2020_DAO.selectYeta5060List_D", searchVO);
    }

    /**
	 * Yeta5060 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return Yeta5060 총 갯수
	 * @exception
	 */
    public int selectYeta5060ListTotCnt(Yeta3060Srh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("Yeta5060_2020_DAO.selectYeta5060ListTotCnt_S", searchVO);
    }

    /**
     * Yeta5060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta5060 목록
     * @exception Exception
     */
    public List selectYetaM506001List(Yeta3060Srh_2020_VO searchVO) throws Exception {
    	return list("Yeta5060_2020_DAO.selectYetaM506001List_D", searchVO);
    }
    
    /**
     * Yeta5060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta5060 총 갯수
     * @exception
     */
    public int selectYetaM506001ListTotCnt(Yeta3060Srh_2020_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta5060_2020_DAO.selectYetaM506001ListTotCnt_S", searchVO);
    }
    
    /**
     * Yeta5060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta5060 목록
     * @exception Exception
     */
    public List selectYetaS506001List(Yeta3060Srh_2020_VO searchVO) throws Exception {
    	return list("Yeta5060_2020_DAO.selectYetaS506001List_D", searchVO);
    }
    
    /**
     * Yeta5060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta5060 총 갯수
     * @exception
     */
    public int selectYetaS506001ListTotCnt(Yeta3060Srh_2020_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta5060_2020_DAO.selectYetaS506001ListTotCnt_S", searchVO);
    }
    
    @Transactional
    public int deleteYeta506001(Yeta3060_2020_VO vo) throws Exception {
        return update("Yeta5060_2020_DAO.deleteYeta506001_S", vo);
    }
    
    @Transactional
    public int insertYetaS506001(Yeta3060_2020_VO vo) throws Exception {
        return update("Yeta5060_2020_DAO.insertYetaS506001_S", vo);
    }
    
    @Transactional
    public int updateNumYetaS506001(Yeta3060_2020_VO vo) throws Exception {
    	return update("Yeta5060_2020_DAO.updateNumYetaS506001_S", vo);
    }

    public int sum(int a, int b){
    	return a+b;
    }
}
