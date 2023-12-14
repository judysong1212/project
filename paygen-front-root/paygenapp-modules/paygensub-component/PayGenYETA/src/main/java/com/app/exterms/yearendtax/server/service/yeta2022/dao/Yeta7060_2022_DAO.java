package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.client.dto.yeta2022.Yeta7060DTO;
import com.app.exterms.yearendtax.server.vo.Yeta3060Srh_2022_VO;
import com.app.exterms.yearendtax.server.vo.Yeta3060_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta7060DAO.java
 * @Description : Yeta7060 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta7060_2022_DAO")
public class Yeta7060_2022_DAO extends EgovAbstractDAO {
	
	@SuppressWarnings("rawtypes")
	public List getParentDpobCd() throws Exception{
		return list("Yeta7060_2022_DAO.getParentDpobCd", null);
	} 
	
	// 시스템 사업장 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List getSysDpobCd() throws Exception{
		return list("Yeta7060_2022_DAO.getSysDpobCd", null);
	}
	
	@SuppressWarnings("rawtypes")
	public List getParentRetryCllnDebrDivCd() throws Exception{
		return list("Yeta7060_2022_DAO.selectYeta7060RetryCllnDebrDivCdList", null);
	}

	// 사용 시스템 구분 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List selectYeta7060sysDivCdList() throws Exception{
		return list("Yeta7060_2022_DAO.getUseSysDivCd", null);
	}
	/**		
	@Transactional
	public int saveYeta7060(InfcYeta7060DTO dto) throws Exception{
		return update("Yeta7060DAO.saveYeta7060", dto);
	}
	 */	
	
	@Transactional
	public int saveYeta7060(Yeta7060DTO dto) throws Exception{
		return update("Yeta7060_2022_DAO.saveYeta7060", dto);
	}
	/**
	 * Yeta7060을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta7060VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String insertYeta7060(Yeta3060_2022_VO vo) throws Exception {
        return (String)insert("Yeta7060_2022_DAO.insertYeta7060_S", vo);
    }

    /**
	 * Yeta7060을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta7060VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
    public void updateYeta7060(Yeta3060_2022_VO vo) throws Exception {
        update("Yeta7060_2022_DAO.updateYeta7060_S", vo);
    }

    /**
	 * Yeta7060을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta7060VO
	 * @return void형 
	 * @exception Exception
	 */
	/**
	@Transactional
    public int deleteYeta7060(InfcYeta7060DTO dto) throws Exception {
        return delete("Yeta7060DAO.deleteYeta7060_S", dto);
    }
	*/
	@Transactional
    public int deleteYeta7060(Yeta7060DTO dto) throws Exception {
        return delete("Yeta7060_2022_DAO.deleteYeta7060_S", dto);
    }

    /**
	 * Yeta7060을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta7060VO
	 * @return 조회한 Yeta7060
	 * @exception Exception
	 */
    public Yeta3060_2022_VO selectYeta7060(Yeta3060_2022_VO vo) throws Exception {
        return (Yeta3060_2022_VO) selectByPk("Yeta7060_2022_DAO.selectYeta7060_S", vo);
    }

    /**
	 * Yeta7060 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return Yeta7060 목록
	 * @exception Exception
	 */
    public List selectYeta7060List(Yeta3060Srh_2022_VO searchVO) throws Exception {
        return list("Yeta7060_2022_DAO.selectYeta7060List_D", searchVO);
    }

    /**
	 * Yeta7060 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return Yeta7060 총 갯수
	 * @exception
	 */
    public int selectYeta7060ListTotCnt(Yeta3060Srh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("Yeta7060_2022_DAO.selectYeta7060ListTotCnt_S", searchVO);
    }

    /**
     * Yeta7060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta7060 목록
     * @exception Exception
     */
    public List selectYetaM706001List(Yeta3060Srh_2022_VO searchVO) throws Exception {
    	return list("Yeta7060_2022_DAO.selectYetaM706001List_D", searchVO);
    }
    
    /**
     * Yeta7060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta7060 총 갯수
     * @exception
     */
    public int selectYetaM706001ListTotCnt(Yeta3060Srh_2022_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta7060_2022_DAO.selectYetaM706001ListTotCnt_S", searchVO);
    }
    
    /**
     * Yeta7060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta7060 목록
     * @exception Exception
     */
    public List selectYetaS706001List(Yeta3060Srh_2022_VO searchVO) throws Exception {
    	return list("Yeta7060_2022_DAO.selectYetaS706001List_D", searchVO);
    }
    
    /**
     * Yeta7060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta7060 총 갯수
     * @exception
     */
    public int selectYetaS706001ListTotCnt(Yeta3060Srh_2022_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta7060_2022_DAO.selectYetaS706001ListTotCnt_S", searchVO);
    }
    
    @Transactional
    public int deleteYeta706001(Yeta3060_2022_VO vo) throws Exception {
        return update("Yeta7060_2022_DAO.deleteYeta706001_S", vo);
    }
    
    @Transactional
    public int insertYetaS706001(Yeta3060_2022_VO vo) throws Exception {
        return update("Yeta7060_2022_DAO.insertYetaS706001_S", vo);
    }
    
    @Transactional
    public int updateNumYetaS706001(Yeta3060_2022_VO vo) throws Exception {
    	return update("Yeta7060_2022_DAO.updateNumYetaS706001_S", vo);
    }

    public int sum(int a, int b){
    	return a+b;
    }
}
