package com.app.exterms.personal.server.service.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.client.dto.Psnl0100DTO;
import com.app.exterms.personal.server.vo.Psnl0100SrhVO;
import com.app.exterms.personal.server.vo.Psnl0100VO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0400VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0100DAO.java
 * @Description : Psnl0100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0100DAO")
public class Psnl0100DAO extends EgovAbstractDAO implements IsSerializable{
	
	@SuppressWarnings("rawtypes")
	public List selectPsnl0100Check(Psnl0100DTO dto) {
		return list("psnl0100DAO.selectPsnl0100Check", dto);
	}
	
	public String getPayDeptCd(HashMap<String, String> hMap) throws Exception{
		return (String)selectByPk("psnl0100DAO.getPayDeptCd", hMap);
	}
	
	public String getNewSystemkey(String dpobCd) throws Exception{
		return (String)selectByPk("psnl0100DAO.getNewSystemkey", dpobCd);
	}
	
	public String getSystemkey(Psnl0100VO psnl0100SVo) throws Exception{
		return (String)selectByPk("psnl0100DAO.getSystemkey", psnl0100SVo);
	}
	
//	public int selectPsnl0100PagingTotCnt(HashMap<String, String> hMap) throws Exception{
//		return (Integer)getSqlMapClient().queryForObject("psnl0100DAO.selectPsnl0100PagingTotCnt", hMap);
//	}
	
	public int selectPsnl0100PagingTotCnt(Psnl0100SrhVO psnl0100SrhVo) throws Exception{
		return (Integer)getSqlMapClient().queryForObject("psnl0100DAO.selectPsnl0100PagingTotCnt", psnl0100SrhVo);
	}
	
//	@SuppressWarnings("rawtypes")
//	public List selectPsnl0100Paging(HashMap<String, String> hMap) throws Exception{
//		return list("psnl0100DAO.selectPsnl0100Paging",hMap);
//		
//	}
	
	@SuppressWarnings("rawtypes")
	public List selectPsnl0100Paging(Psnl0100SrhVO psnl0100SrhVo) throws Exception{
		return list("psnl0100DAO.selectPsnl0100Paging", psnl0100SrhVo);
		
	}
	
	//호봉재획정 업데이트
	@Transactional
	public int updatePsnl0320ToPsnl0100(Psnl0100VO psnl0100Vo) throws Exception{
		return update("psnl0100DAO.updatePsnl0320ToPsnl0100", psnl0100Vo);
	}
	
	
	/********* 근로자 고용구분 및 재직상태 변경 ********/
	@Transactional
	public int updatePsnl0100Status(Psnl0100VO psnl0100Vo) throws Exception{
		return update("psnl0100DAO.updatePsnl0100Status", psnl0100Vo);
	}
	
	@Transactional
	public String insertPsnl0100(Psnl0100DTO psnl0100Dto) throws Exception{
		return (String) insert("psnl0100DAO.insertPsnl0100",psnl0100Dto);
	}
	@Transactional
	public int updatePsnl0100(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.updatePsnl0100", psnl0100Dto);
	}
	@Transactional
	public int updatePsnl0100ToPayr0500(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.updatePsnl0100ToPayr0500", psnl0100Dto);
	}
	@Transactional
	public int deletePsnl0100(HashMap<String, String> hMap) throws Exception{
		return delete("psnl0100DAO.deletePsnl0100",hMap);
		
	}

	public List selectPsnl0100(HashMap<String, String> param) {
		// TODO Auto-generated method stub
		return list("psnl0100DAO.selectPsnl0100", param);
	}

	//########################## 고용 및 학교 저장시 업데이트 처리 시작 #############################
	/** 고용구분 **/
	@Transactional
	public int updatePsnl0100EMYMT_DIV_CD(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.EMYMT_DIV_CD", psnl0100Dto);
	}
	
	/** 최초고용일자 **/
	@Transactional
	public int updatePsnl0100FRST_EMYMT_DT(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.FRST_EMYMT_DT", psnl0100Dto);
	}
	
	
	
	/** 고용일괄등록 시 신규 데이터 마스터 INSERT **/
	public String insertXlsPsnl0100(Psnl0100VO psnl0100Vo) throws Exception{
		return (String) insert("psnl0100DAO.insertXlsPsnl0100",psnl0100Vo);
	}
	
	/** 현소속부서코드 **/
	@Transactional
	public int updatePsnl0100CURR_AFFN_DEPT_CD(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.CURR_AFFN_DEPT_CD", psnl0100Dto);
	}
	
	/** 현관리부서코드 **/
	@Transactional
	public int updatePsnl0100DEPT_CD(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.DEPT_CD", psnl0100Dto);
	}
	
	/** 현부서발령일자 **/
	@Transactional
	public int updatePsnl0100CURR_DEPT_APPMT_DT(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.CURR_DEPT_APPMT_DT", psnl0100Dto);
	}
	
	/** 직종코드 **/
	@Transactional
	public int updatePsnl0100TYP_OCCU_CD(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.TYP_OCCU_CD", psnl0100Dto);
	}
	
	/** 통합직종세코드 **/
	@Transactional
	public int updatePsnl0100DTIL_OCCU_INTTN_CD(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.DTIL_OCCU_INTTN_CD", psnl0100Dto);
	}
	
	/** 사업코드 **/
	@Transactional
	public int updatePsnl0100BUSIN_CD(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.BUSIN_CD", psnl0100Dto);
	}
	
	/** 고용해제사유 **/
	@Transactional
	public int updatePsnl0100RETRY_REAS_CTNT(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.RETRY_REAS_CTNT", psnl0100Dto);
	}
	
	/** 직책코드 **/
	@Transactional
	public int updatePsnl0100ODTY_CD(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.ODTY_CD", psnl0100Dto);
	}
	
	/** 고용시작일자 **/
	@Transactional
	public int updatePsnl0100EMYMT_BGNN_DT(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.EMYMT_BGNN_DT", psnl0100Dto);
	}
	
	/** 고용종료일자 **/
	@Transactional
	public int updatePsnl0100EMYMT_END_DT(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.EMYMT_END_DT", psnl0100Dto);
	}
	
	/** 퇴직일자 **/
	@Transactional
	public int updatePsnl0100RETRY_DT(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.RETRY_DT", psnl0100Dto);
	}
	
	/** 재직상태코드 **/
	@Transactional
	public int updatePsnl0100HDOFC_CODTN_CD(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.HDOFC_CODTN_CD", psnl0100Dto);
	}
	
	/** 재직상태코드 - 재직 고정 **/
	@Transactional
	public int updatePsnl0100HDOFC_CODTN_CD_A0030010(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.HDOFC_CODTN_CD_A0030010", psnl0100Dto);
	}
	
	/** 최종학교 **/
	@Transactional
	public int updatePsnl0100END_SCHL(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.END_SCHL", psnl0100Dto);
	}
	
	/** 최종학위구분코드 **/
	@Transactional
	public int updatePsnl0100END_DEGR_DIV_CD(Psnl0100DTO psnl0100Dto) throws Exception{
		return update("psnl0100DAO.END_DEGR_DIV_CD", psnl0100Dto);
	}
	//########################## 고용 및 학교 저장시 업데이트 처리 종료 #############################
	
	
	
	/** ++++++++++++++++++++++ 고용구분시 마스터 데이터 초기화 ++++++++++++++++++++++ **/
	/** 사업 초기화 **/
	@Transactional
	public int resetPsnl0100BUSIN_CD(Psnl0100VO psnl0100Vo) throws Exception{
		return update("psnl0100DAO.RESET_BUSIN_CD", psnl0100Vo);
	}
	
	/** 근속년월 초기화 초기화 **/
	@Transactional
	public int resetPsnl0100LOG_SVC_CD(Psnl0100VO psnl0100Vo) throws Exception{
		return update("psnl0100DAO.RESET_LOG_SVC_CD", psnl0100Vo);
	}
	
	/** 직종 초기화 초기화 **/
	@Transactional
	public int resetPsnl0100TYP_OCCU_CD(Psnl0100VO psnl0100Vo) throws Exception{
		return update("psnl0100DAO.RESET_TYP_OCCU_CD", psnl0100Vo);
	}
	
	/** 직종세통합코드 초기화 **/
	@Transactional
	public int resetPsnl0100DTIL_OCCU_INTTN_CD(Psnl0100VO psnl0100Vo) throws Exception{
		return update("psnl0100DAO.RESET_DTIL_OCCU_INTTN_CD", psnl0100Vo);
	}
	
	
	/** 현부서발령일 초기화 **/
	@Transactional
	public int resetPsnl0100CURR_DEPT_APPMT_DT(Psnl0100VO psnl0100Vo) throws Exception{
		return update("psnl0100DAO.RESET_CURR_DEPT_APPMT_DT", psnl0100Vo);
	}
	
	/** 현소속부서 초기화 **/
	@Transactional
	public int resetPsnl0100CURR_AFFN_DEPT_CD(Psnl0100VO psnl0100Vo) throws Exception{
		return update("psnl0100DAO.RESET_CURR_AFFN_DEPT_CD", psnl0100Vo);
	}
	
	/** 고용해제사유 초기화 **/
	@Transactional
	public int resetPsnl0100RETRY_REAS_CTNT(Psnl0100VO psnl0100Vo) throws Exception{
		return update("psnl0100DAO.RESET_RETRY_REAS_CTNT", psnl0100Vo);
	}
	
	/** 최초고용일 초기화 **/
	@Transactional
	public int resetPsnl0100FRST_EMYMT_DT(Psnl0100VO psnl0100Vo) throws Exception{
		return update("psnl0100DAO.RESET_FRST_EMYMT_DT", psnl0100Vo);
	}
	
	/** 퇴직일자 초기화 **/
	@Transactional
	public int resetPsnl0100RESET_RETRY_DT(Psnl0100VO psnl0100Vo) throws Exception{
		return update("psnl0100DAO.RESET_RETRY_DT", psnl0100Vo);
	}
	/** ++++++++++++++++++++++ 고용구분시 마스터 데이터 초기화 ++++++++++++++++++++++ **/
	
	@SuppressWarnings("rawtypes")
	public List getMemberInfo(Psnl0100DTO dto) throws Exception{
		return list("psnl0100DAO.getMemberInfo", dto);
	}
	

    public Psnl0100VO selectPsnl0100ToPsnl0123(Psnl0100VO psnl0100Vo) {
        // TODO Auto-generated method stub
        return  (Psnl0100VO) selectByPk("psnl0100DAO.selectPsnl0100ToPsnl0123", psnl0100Vo);
    }
	 
    
    @Transactional
    public int updatePsnl0100ToPsnlStat(Psnl0100DTO psnl0100Dto) throws Exception{
        return update("psnl0100DAO.Psnl0100ToPsnlStat", psnl0100Dto);
    }
    
    
    /**
	 * GET PSNL0100 TO PSNL0250 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0100 목록
	 * @exception Exception
	 */
    public List selectPsnl0100To0250List(Psnl0100SrhVO searchVO) throws Exception {
        return list("psnl0100DAO.selectPsnl0100To0250List_P", searchVO);
    }
    
    /**
	 * GET PSNL0100 TO PSNL0250 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0100 총 갯수
	 */
    public int selectPsnl0100To0250ListTotCnt(Psnl0100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0100DAO.selectPsnl0100To0250ListTotCnt_S", searchVO);
    }
    
    
    /**
	 * 노조 가입 여부 update
	 * @param searchMap - 조회할 정보가 담긴 Map
	 */
	public int resetPsnl0100UNN_MBSP_STT_YN(Psnl0100VO psnl0100Vo) throws Exception{
		return update("psnl0100DAO.UNN_MBSP_STT_YN", psnl0100Vo);
	}
	
	
	
	/**
	 * 기간제근로자 단위기관 코드를 가져온다.
	 * */
	@SuppressWarnings("unchecked")
	public List getPayrMangDeptCd_02(InfcPkgBass0400VO infcBass0400SrhVo) throws Exception {
        return list("psnl0100DAO.getPayrMangDeptCd_02", infcBass0400SrhVo);
	} 

    
}
