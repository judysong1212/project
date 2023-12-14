package com.app.exterms.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.client.dto.yeta2019.Yeta4060DTO;
import com.app.exterms.yearendtax.server.vo.Yeta3060Srh_2019_VO;
import com.app.exterms.yearendtax.server.vo.Yeta3060_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta4060DAO.java
 * @Description : Yeta4060 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta4060_2019_DAO")
public class Yeta4060_2019_DAO extends EgovAbstractDAO {
	
	@SuppressWarnings("rawtypes")
	public List getParentDpobCd() throws Exception{
		return list("Yeta4060_2019_DAO.getParentDpobCd", null);
	} 
	
	// 시스템 사업장 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List getSysDpobCd() throws Exception{
		return list("Yeta4060_2019_DAO.getSysDpobCd", null);
	}
	
	@SuppressWarnings("rawtypes")
	public List getParentRetryCllnDebrDivCd() throws Exception{
		return list("Yeta4060_2019_DAO.selectYeta4060RetryCllnDebrDivCdList", null);
	}

	// 사용 시스템 구분 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List selectYeta4060sysDivCdList() throws Exception{
		return list("Yeta4060_2019_DAO.getUseSysDivCd", null);
	}
	/**		
	@Transactional
	public int saveYeta4060(InfcYeta4060DTO dto) throws Exception{
		return update("Yeta4060DAO.saveYeta4060", dto);
	}
	 */	
	
	@Transactional
	public int saveYeta4060(Yeta4060DTO dto) throws Exception{
		return update("Yeta4060_2019_DAO.saveYeta4060", dto);
	}
	/**
	 * Yeta4060을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta4060VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String insertYeta4060(Yeta3060_2019_VO vo) throws Exception {
        return (String)insert("Yeta4060_2019_DAO.insertYeta4060_S", vo);
    }

    /**
	 * Yeta4060을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta4060VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
    public void updateYeta4060(Yeta3060_2019_VO vo) throws Exception {
        update("Yeta4060_2019_DAO.updateYeta4060_S", vo);
    }

    /**
	 * Yeta4060을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta4060VO
	 * @return void형 
	 * @exception Exception
	 */
	/**
	@Transactional
    public int deleteYeta4060(InfcYeta4060DTO dto) throws Exception {
        return delete("Yeta4060DAO.deleteYeta4060_S", dto);
    }
	*/
	@Transactional
    public int deleteYeta4060(Yeta4060DTO dto) throws Exception {
        return delete("Yeta4060_2019_DAO.deleteYeta4060_S", dto);
    }

    /**
	 * Yeta4060을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta4060VO
	 * @return 조회한 Yeta4060
	 * @exception Exception
	 */
    public Yeta3060_2019_VO selectYeta4060(Yeta3060_2019_VO vo) throws Exception {
        return (Yeta3060_2019_VO) selectByPk("Yeta4060_2019_DAO.selectYeta4060_S", vo);
    }

    /**
	 * Yeta4060 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return Yeta4060 목록
	 * @exception Exception
	 */
    public List selectYeta4060List(Yeta3060Srh_2019_VO searchVO) throws Exception {
        return list("Yeta4060_2019_DAO.selectYeta4060List_D", searchVO);
    }

    /**
	 * Yeta4060 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return Yeta4060 총 갯수
	 * @exception
	 */
    public int selectYeta4060ListTotCnt(Yeta3060Srh_2019_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("Yeta4060_2019_DAO.selectYeta4060ListTotCnt_S", searchVO);
    }

    /**
     * Yeta4060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta4060 목록
     * @exception Exception
     */
    public List selectYetaM406001List(Yeta3060Srh_2019_VO searchVO) throws Exception {
    	return list("Yeta4060_2019_DAO.selectYetaM406001List_D", searchVO);
    }
    
    /**
     * Yeta4060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta4060 총 갯수
     * @exception
     */
    public int selectYetaM406001ListTotCnt(Yeta3060Srh_2019_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta4060_2019_DAO.selectYetaM406001ListTotCnt_S", searchVO);
    }
    
    /**
     * Yeta4060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta4060 목록
     * @exception Exception
     */
    public List selectYetaS406001List(Yeta3060Srh_2019_VO searchVO) throws Exception {
    	return list("Yeta4060_2019_DAO.selectYetaS406001List_D", searchVO);
    }
    
    /**
     * Yeta4060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta4060 총 갯수
     * @exception
     */
    public int selectYetaS406001ListTotCnt(Yeta3060Srh_2019_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta4060_2019_DAO.selectYetaS406001ListTotCnt_S", searchVO);
    }
    
    @Transactional
    public int deleteYeta406001(Yeta3060_2019_VO vo) throws Exception {
        return update("Yeta4060_2019_DAO.deleteYeta406001_S", vo);
    }
    
    @Transactional
    public int insertYetaS406001(Yeta3060_2019_VO vo) throws Exception {
        return update("Yeta4060_2019_DAO.insertYetaS406001_S", vo);
    }
    
    @Transactional
    public int updateNumYetaS406001(Yeta3060_2019_VO vo) throws Exception {
    	return update("Yeta4060_2019_DAO.updateNumYetaS406001_S", vo);
    }

    public int sum(int a, int b){
    	return a+b;
    }
}
