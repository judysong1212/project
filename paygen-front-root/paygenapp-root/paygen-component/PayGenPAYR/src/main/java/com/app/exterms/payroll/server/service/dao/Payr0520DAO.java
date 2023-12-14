package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.client.dto.Payr0520DTO;
import com.app.exterms.payroll.server.vo.Payr0520SrhVO;
import com.app.exterms.payroll.server.vo.Payr0520VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0520DAO.java
 * @Description : Payr0520 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0520DAO")
public class Payr0520DAO extends EgovAbstractDAO {
	
	//jungmin 2014.09.25 사회보험 기본대상관리 관련 쿼리 시작
	@SuppressWarnings("unchecked")
	public List<Payr0520DTO> getPayr0520List(Payr0520DTO dto) throws Exception{
		return list("payr0520DAO.getPayr0520List", dto);
	}
	@Transactional
	public int updatePayr0520(Payr0520DTO dto) throws Exception{
		return update("payr0520DAO.updatePayr0520", dto);
	}
	@Transactional
	public String insertPayr0520(Payr0520DTO dto) throws Exception{
		return (String)insert("payr0520DAO.insertPayr0520", dto);
	}
	//jungmin 2014.09.25 사회보험 기본대상관리 관련 쿼리 끝
	
	public int selectPayr0520CehckCnt(Payr0520VO vo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0520DAO.selectPayr0520CehckCnt_S", vo);
    }
	
	
	/**
	 * PAYR0520을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0520VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String insertPayr0520(Payr0520VO vo) throws Exception {
        return (String)insert("payr0520DAO.insertPayr0520_S", vo);
    }

    /**
	 * PAYR0520을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0520VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
    public void updatePayr0520(Payr0520VO vo) throws Exception {
        update("payr0520DAO.updatePayr0520_S", vo);
    }

    /**
	 * PAYR0520을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0520VO
	 * @return void형 
	 * @exception Exception
	 */
	@Transactional
    public void deletePayr0520(Payr0520VO vo) throws Exception {
        delete("payr0520DAO.deletePayr0520_S", vo);
    }

    /**
	 * PAYR0520을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0520VO
	 * @return 조회한 PAYR0520
	 * @exception Exception
	 */
    public Payr0520VO selectPayr0520(Payr0520VO vo) throws Exception {
        return (Payr0520VO) selectByPk("payr0520DAO.selectPayr0520_S", vo);
    }

    /**
	 * PAYR0520 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0520 목록
	 * @exception Exception
	 */
    public List selectPayr0520List(Payr0520SrhVO searchVO) throws Exception {
        return list("payr0520DAO.selectPayr0520List_D", searchVO);
    }
    
    
    

    /**
	 * PAYR0520 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0520 총 갯수
	 * @exception
	 */
    public int selectPayr0520ListTotCnt(Payr0520SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0520DAO.selectPayr0520ListTotCnt_S", searchVO);
    }
    
    /**
     * PAYR0520 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0520 목록
     * @exception Exception
     */
    public List selectPayr0520ToPayr3200DducdivcdList(Payr0520SrhVO searchVO) throws Exception {
        return list("payr0520DAO.selectPayr0520ToPayr3200DducdivcdList_D", searchVO);
    }
    
    /**
     * PAYR0520 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0520 목록
     * @exception Exception
     */
    public List selectPayr0520ToPayr5400ExtpyCdList(Payr0520SrhVO searchVO) throws Exception {
        return list("payr0520DAO.selectPayr0520ToPayr5400ExtpyCdList_D", searchVO);
    }
    
    
    

    /**
     * PAYR0520 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0520 총 갯수
     * @exception
     */
    public int selectPayr0520ToPayr3200DducdivcdListTotCnt(Payr0520SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0520DAO.selectPayr0520ToPayr3200DducdivcdListTotCnt_S", searchVO);
    }
     
    /**
     * PAYR0520 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0520 총 갯수
     * @exception
     */
    public int selectPayr0520ToPayr5400ExtpyCdListTotCnt(Payr0520SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0520DAO.selectPayr0520ToPayr5400ExtpyCdListTotCnt_S", searchVO);
    }
    
    /**
     * PAYR0520 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0520 목록
     * @exception Exception
     */
    public List selectPayr0520ToPayr3200List(Payr0520SrhVO searchVO) throws Exception {
        return list("payr0520DAO.selectPayr0520ToPayr3200List_D", searchVO);
    }
    
    public List selectPayr0520ToPayr5400List(Payr0520SrhVO searchVO) throws Exception {
        return list("payr0520DAO.selectPayr0520ToPayr5400List_D", searchVO);
    }
    
    
    

    /**
     * PAYR0520 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0520 총 갯수
     * @exception
     */
    public int selectPayr0520ToPayr3200ListTotCnt(Payr0520SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0520DAO.selectPayr0520ToPayr3200ListTotCnt_S", searchVO);
    }
    
    public int selectPayr0520ToPayr5400ListTotCnt(Payr0520SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0520DAO.selectPayr0520ToPayr5400ListTotCnt_S", searchVO);
    }


    public List selectPayr0520ToPayrCalcList(Payr0520SrhVO searchVO) throws Exception {
        return list("payr0520DAO.selectPayr0520ToPayrCalcList_D", searchVO);
    }
    
    
    
    /**
	 * 수당공제 리스트 엑셀 양식 출력
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0520 목록
	 * @exception Exception
	 */
    public List selectXlsPayr0520List(Payr0520VO payr0520Vo) throws Exception {
        return list("payr0520DAO.selectXlsPayr0520List", payr0520Vo);
    }
    
    
    
	/**
	 * PAYR0520을 등록한다.(엑셀)
	 * @param vo - 등록할 정보가 담긴 Payr0520VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String xlsInsertPayr0520(Payr0520VO vo) throws Exception {
        return (String)insert("payr0520DAO.xlsInsertPayr0520_S", vo);
    }
	
    /**
	 * PAYR0520을 삭제한다.(엑셀)
	 * @param vo - 삭제할 정보가 담긴 Payr0520VO
	 * @return void형 
	 * @exception Exception
	 */
	@Transactional
    public void xlsDeletePayr0520(Payr0520VO vo) throws Exception {
        delete("payr0520DAO.xlsDeletePayr0520_S", vo);
    }
    
    

}
