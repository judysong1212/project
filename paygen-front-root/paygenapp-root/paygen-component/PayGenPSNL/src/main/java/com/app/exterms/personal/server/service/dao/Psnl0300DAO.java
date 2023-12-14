package com.app.exterms.personal.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.client.dto.Psnl0300DTO;
import com.app.exterms.personal.server.vo.Psnl0110VO;
import com.app.exterms.personal.server.vo.Psnl0300SrhVO;
import com.app.exterms.personal.server.vo.Psnl0300VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0300DAO.java
 * @Description : Psnl0300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0300DAO")
public class Psnl0300DAO extends EgovAbstractDAO implements IsSerializable {
	
	
    /**
	 * PSNL0300 총 갯수를 조회한다.(발령관리)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0300 총 갯수
	 */
    public int selectPsnl0300ListTotCnt(Psnl0300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0300DAO.selectPsnl0300ListTotCnt_S", searchVO);
    }
    
	/**
	 * PSNL0300 목록을 조회한다.(발령관리)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0300 목록
	 * @exception Exception
	 */
    public List selectPsnl0300List(Psnl0300SrhVO searchVO) throws Exception {
        return list("psnl0300DAO.selectPsnl0300List", searchVO);
    }
    
    
	/**
	 * PSNL0300 목록을 조회한다.(일괄발령)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0300 목록
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectPsnlP0300List(Psnl0300SrhVO searchVO) throws Exception {
        return list("psnl0300DAO.selectPsnlP0300List", searchVO);
    }
    
    @SuppressWarnings("deprecation")
	public int selectPsnlP0300ListTotCnt(Psnl0300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0300DAO.selectPsnlP0300ListTotCnt_S", searchVO);
    }
    
	@SuppressWarnings("rawtypes")
	public List selectPsnlP0300MasterList(Psnl0300SrhVO searchVO) throws Exception{
		return list("psnl0300DAO.selectPsnlP0300MasterList", searchVO);
	}
    
    @SuppressWarnings("deprecation")
	public int selectPsnlP0300MasterListTotCnt(Psnl0300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0300DAO.selectPsnlP0300MasterListTotCnt_S", searchVO);
    }
    
    
    

	@SuppressWarnings("rawtypes")
	public List selectPsnl0300(Psnl0300DTO dto) throws Exception{
		return list("psnl0300DAO.selectPsnl0300", dto);
	}
	
	@Transactional
	public int deletePsnl0300(Psnl0300DTO dto) throws Exception{
		return delete("psnl0300DAO.deletePsnl0300", dto);
	}
	
	@Transactional
	public int deletePsnl0310(Psnl0300DTO dto) throws Exception{
		return delete("psnl0300DAO.deletePsnl0310", dto);
	}
	
	
	/** 발령 종료일자 **/
	@Transactional
	public int updatePsnl0300(Psnl0300DTO dto) throws Exception{
		return update("psnl0300DAO.updatePsnl0300", dto);
	}
	
	@Transactional
	public int updatePsnl0300_END_DT(Psnl0300VO psnl0300Vo) throws Exception{
		return update("psnl0300DAO.updatePsnl0300_END_DT", psnl0300Vo);
	}
	
	/** 발령 여부 **/
	@Transactional
	public int updatePsnl0310(Psnl0300DTO dto) throws Exception{
		return update("psnl0300DAO.updatePsnl0310", dto);
	}
	
	@Transactional
	public int updatePsnl0110(Psnl0300DTO dto) throws Exception{
		return update("psnl0300DAO.updatePsnl0110", dto);
	}
	
	
	@Transactional
	public String insertPsnl0110(Psnl0300DTO dto) throws Exception{
		return (String)insert("psnl0300DAO.insertPsnl0110", dto);
	}
	
	
	/** 발령 데이터 고용 테이블에 반영**/
	@Transactional
	public String insertPsnl0110_S(Psnl0110VO psnl0110Vo) throws Exception{
		return (String)insert("psnl0300DAO.insertPsnl0110_S", psnl0110Vo);
	}
	
	/** 발령 직전 데이터 고용종료일자 마감 처리**/
	@Transactional
	public int updatePsnl0110_EMYMT_END_DT(Psnl0110VO psnl0110Vo) throws Exception{
		return update("psnl0300DAO.updatePsnl0110_EMYMT_END_DT", psnl0110Vo);
	}
	
	
	
	
	public String getMaxAppmtSeilNum() throws Exception{
		return (String)getSqlMapClientTemplate().queryForObject("psnl0300DAO.getMaxAppmtSeilNum");
	}
	
	
	/** 발령 확정 **/
	@Transactional
//	public String insertPsnl0300(Psnl0300DTO dto) throws Exception{
//		return (String)insert("psnl0300DAO.inserPsnl0300", dto);
//	}
	public String insertPsnl0300(Psnl0300VO psnl0300Vo) throws Exception{
		return (String)insert("psnl0300DAO.inserPsnl0300", psnl0300Vo);
	}
//	@Transactional
//	public String inserPsnl0310(Psnl0300DTO dto) throws Exception{
//		return (String)insert("psnl0300DAO.inserPsnl0310", dto);
//	}
	

	
	@Transactional
	public int updatePsnl0100(Psnl0300DTO dto) throws Exception{
		return update("psnl0300DAO.updatePsnl0100", dto);
	}
	
	@SuppressWarnings("rawtypes")
	public List selectPsnlP0300(Psnl0300DTO dto) throws Exception{
		return list("psnl0300DAO.selectPsnlP0300", dto);
	}
	
	@SuppressWarnings("rawtypes")
	public List selectPsnlP0300Master(Psnl0300DTO dto) throws Exception{
		return list("psnl0300DAO.selectPsnlP0300Master", dto);
	}
	
	
}
