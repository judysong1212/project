package com.app.exterms.personal.server.service.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.personal.server.vo.Psnl0100SrhVO;
import com.app.exterms.personal.server.vo.Psnl0600SrhVO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("psnl0600DAO")
public class Psnl0600DAO extends EgovAbstractDAO implements IsSerializable {
	
	
	
	//엑셀저장
	@SuppressWarnings("rawtypes")
	public List selectPsnl0600(Psnl0100SrhVO psnl0100SrhVo) {
		return list("psnl0600DAO.selectPsnl0600", psnl0100SrhVo);
	}
	
	
	/**************** 인사통합검색 시작 ****************/ 
//	/** 기본 **/
//	@SuppressWarnings("rawtypes")
//	public List selectPsnl0600List(Psnl0600SrhVO psnl0600SrhVo) {
//		return list("psnl0600DAO.selectPsnl0600List", psnl0600SrhVo);
//	}
//	
//    public int selectPsnl0600ListTotCnt(Psnl0600SrhVO psnl0600SrhVo) {
//        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0600DAO.selectPsnl0600ListTotCnt_S", psnl0600SrhVo);
//    }
//    
//    /** 병역 **/
//	@SuppressWarnings("rawtypes")
//	public List selectPsnl0112List(Psnl0600SrhVO psnl0600SrhVo) {
//		return list("psnl0600DAO.selectPsnl0112List", psnl0600SrhVo);
//	}
//    public int selectPsnl0112ListTotCnt(Psnl0600SrhVO psnl0600SrhVo) {
//        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0600DAO.selectPsnl0112ListTotCnt_S", psnl0600SrhVo);
//    }
//	
//	
//    /** 단체 **/
//	@SuppressWarnings("rawtypes")
//	public List selectPsnl0114List(Psnl0600SrhVO psnl0600SrhVo) {
//		return list("psnl0600DAO.selectPsnl0114List", psnl0600SrhVo);
//	}
//	 public int selectPsnl0114ListTotCnt(Psnl0600SrhVO psnl0600SrhVo) {
//	        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0600DAO.selectPsnl0114ListTotCnt_S", psnl0600SrhVo);
//	    }
//	
//	
//	
//	
//	//학력
//	@SuppressWarnings("rawtypes")
//	public List selectPsnl0116(Psnl0600SrhVO psnl0600SrhVo) {
//		return list("psnl0600DAO.selectPsnl0116", psnl0600SrhVo);
//	}
//	//자격
//	@SuppressWarnings("rawtypes")
//	public List selectPsnl0118(Psnl0600SrhVO psnl0600SrhVo) {
//		return list("psnl0600DAO.selectPsnl0118", psnl0600SrhVo);
//	}
//	//경력
//	@SuppressWarnings("rawtypes")
//	public List selectPsnl0119(Psnl0600SrhVO psnl0600SrhVo) {
//		return list("psnl0600DAO.selectPsnl0119", psnl0600SrhVo);
//	}
//	//교육
//	@SuppressWarnings("rawtypes")
//	public List selectPsnl0120(Psnl0600SrhVO psnl0600SrhVo) {
//		return list("psnl0600DAO.selectPsnl0120", psnl0600SrhVo);
//	}
//	//포상
//	@SuppressWarnings("rawtypes")
//	public List selectPsnl0121(Psnl0600SrhVO psnl0600SrhVo) {
//		return list("psnl0600DAO.selectPsnl0121", psnl0600SrhVo);
//	}
//	//징계
//	@SuppressWarnings("rawtypes")
//	public List selectPsnl0122(Psnl0600SrhVO psnl0600SrhVo) {
//		return list("psnl0600DAO.selectPsnl0122", psnl0600SrhVo);
//	}
//	//휴직
//	@SuppressWarnings("rawtypes")
//	public List selectPsnl0123(Psnl0600SrhVO psnl0600SrhVo) {
//		return list("psnl0600DAO.selectPsnl0123", psnl0600SrhVo);
//	}
	/**************** 인사통합검색 종료 ****************/ 
	
	
	
	/**************** 인사통합검색 시작 ****************/ 
	//기본
	@SuppressWarnings("rawtypes")
	public List selectPsnl0600(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0600List", psnl0600SrhVo);
	}
	
	//기본-기간제
	@SuppressWarnings("rawtypes")
	public List selectPsnl0600ToA0410020(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0600ToA0410020List", psnl0600SrhVo);
	}
	
	public int selectPsnl0600ListTotCnt(Psnl0600SrhVO psnl0600SrhVo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("psnl0600DAO.selectPsnl0600ListTotCnt_S", psnl0600SrhVo);
	}

	//병역
	@SuppressWarnings("rawtypes")
	public List selectPsnl0112(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0112", psnl0600SrhVo);
	}
	//병역
	@SuppressWarnings("rawtypes")
	public List selectPsnl0112ToA0410020(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0112ToA0410020", psnl0600SrhVo);
	}
	
	public int selectPsnl0112ListTotCnt(Psnl0600SrhVO psnl0600SrhVo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("psnl0600DAO.selectPsnl0112ListTotCnt_S", psnl0600SrhVo);
	}
	
	
	//단체
	@SuppressWarnings("rawtypes")
	public List selectPsnl0114(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0114", psnl0600SrhVo);
	}
	
	public int selectPsnl0114ListTotCnt(Psnl0600SrhVO psnl0600SrhVo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("psnl0600DAO.selectPsnl0114ListTotCnt_S", psnl0600SrhVo);
	}
	
	//학력
	@SuppressWarnings("rawtypes")
	public List selectPsnl0116(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0116", psnl0600SrhVo);
	}
	
	public int selectPsnl0116ListTotCnt(Psnl0600SrhVO psnl0600SrhVo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("psnl0600DAO.selectPsnl0116ListTotCnt_S", psnl0600SrhVo);
	}
	
	
	//자격
	@SuppressWarnings("rawtypes")
	public List selectPsnl0118(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0118", psnl0600SrhVo);
	}
	
	public int selectPsnl0118ListTotCnt(Psnl0600SrhVO psnl0600SrhVo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("psnl0600DAO.selectPsnl0118ListTotCnt_S", psnl0600SrhVo);
	}
	
	//경력
	@SuppressWarnings("rawtypes")
	public List selectPsnl0119(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0119", psnl0600SrhVo);
	}
	
	public int selectPsnl0119ListTotCnt(Psnl0600SrhVO psnl0600SrhVo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("psnl0600DAO.selectPsnl0119ListTotCnt_S", psnl0600SrhVo);
	}
	

	//교육
	@SuppressWarnings("rawtypes")
	public List selectPsnl0120(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0120", psnl0600SrhVo);
	}
	
	public int selectPsnl0120ListTotCnt(Psnl0600SrhVO psnl0600SrhVo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("psnl0600DAO.selectPsnl0120ListTotCnt_S", psnl0600SrhVo);
	}
	
	//포상
	@SuppressWarnings("rawtypes")
	public List selectPsnl0121(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0121", psnl0600SrhVo);
	}
	
	public int selectPsnl0121ListTotCnt(Psnl0600SrhVO psnl0600SrhVo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("psnl0600DAO.selectPsnl0121ListTotCnt_S", psnl0600SrhVo);
	}
	
	//징계
	@SuppressWarnings("rawtypes")
	public List selectPsnl0122(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0122", psnl0600SrhVo);
	}
	
	public int selectPsnl0122ListTotCnt(Psnl0600SrhVO psnl0600SrhVo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("psnl0600DAO.selectPsnl0122ListTotCnt_S", psnl0600SrhVo);
	}
	
	//휴직
	@SuppressWarnings("rawtypes")
	public List selectPsnl0123(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0123", psnl0600SrhVo);
	}
	
	public int selectPsnl0123ListTotCnt(Psnl0600SrhVO psnl0600SrhVo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("psnl0600DAO.selectPsnl0123ListTotCnt_S", psnl0600SrhVo);
	}
	/**************** 인사통합검색 종료 ****************/ 
	
	
	
	/**************** 인사통합검색 엑셀 다운 시작 ****************/ 
	
	//통합
	@SuppressWarnings("rawtypes")
	public List selPsnl0600Xls(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selPsnl0600ListXls", psnl0600SrhVo);
	}
	
	//기본
	@SuppressWarnings("rawtypes")
	public List selectPsnl0600Xls(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0600ListXls", psnl0600SrhVo);
	}
	
	//병역
	@SuppressWarnings("rawtypes")
	public List selectPsnl0112Xls(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0112Xls", psnl0600SrhVo);
	}
	
	//단체
	@SuppressWarnings("rawtypes")
	public List selectPsnl0114Xls(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0114Xls", psnl0600SrhVo);
	}
	
	//학력
	@SuppressWarnings("rawtypes")
	public List selectPsnl0116Xls(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0116Xls", psnl0600SrhVo);
	}
	
	
	//자격
	@SuppressWarnings("rawtypes")
	public List selectPsnl0118Xls(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0118Xls", psnl0600SrhVo);
	}
	
	//경력
	@SuppressWarnings("rawtypes")
	public List selectPsnl0119Xls(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0119Xls", psnl0600SrhVo);
	}

	//교육
	@SuppressWarnings("rawtypes")
	public List selectPsnl0120Xls(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0120Xls", psnl0600SrhVo);
	}
	
	//포상
	@SuppressWarnings("rawtypes")
	public List selectPsnl0121Xls(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0121Xls", psnl0600SrhVo);
	}
	
	//징계
	@SuppressWarnings("rawtypes")
	public List selectPsnl0122Xls(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0122Xls", psnl0600SrhVo);
	}
	
	//휴직
	@SuppressWarnings("rawtypes")
	public List selectPsnl0123Xls(Psnl0600SrhVO psnl0600SrhVo) {
		return list("psnl0600DAO.selectPsnl0123Xls", psnl0600SrhVo);
	}
	/**************** 인사통합검색 엑셀 다운 종료  ****************/ 
	
	
	
	@SuppressWarnings("rawtypes")
	public List selectPsnl0600(HashMap<String, String> param) {
		return list("psnl0600DAO.selectPsnl0600", param);
	}
	
	/**
	
	@SuppressWarnings("rawtypes")
	public List selectPsnl0112(HashMap<String, String> param) {
		return list("psnl0600DAO.selectPsnl0112", param);
	}
	@SuppressWarnings("rawtypes")
	public List selectPsnl0114(HashMap<String, String> param) {
		return list("psnl0600DAO.selectPsnl0114", param);
	}
	@SuppressWarnings("rawtypes")
	public List selectPsnl0116(HashMap<String, String> param) {
		return list("psnl0600DAO.selectPsnl0116", param);
	}
	@SuppressWarnings("rawtypes")
	public List selectPsnl0118(HashMap<String, String> param) {
		return list("psnl0600DAO.selectPsnl0118", param);
	}
	@SuppressWarnings("rawtypes")
	public List selectPsnl0119(HashMap<String, String> param) {
		return list("psnl0600DAO.selectPsnl0119", param);
	}
	@SuppressWarnings("rawtypes")
	public List selectPsnl0120(HashMap<String, String> param) {
		return list("psnl0600DAO.selectPsnl0120", param);
	}
	@SuppressWarnings("rawtypes")
	public List selectPsnl0121(HashMap<String, String> param) {
		return list("psnl0600DAO.selectPsnl0121", param);
	}
	@SuppressWarnings("rawtypes")
	public List selectPsnl0122(HashMap<String, String> param) {
		return list("psnl0600DAO.selectPsnl0122", param);
	}
	@SuppressWarnings("rawtypes")
	public List selectPsnl0123(HashMap<String, String> param) {
		return list("psnl0600DAO.selectPsnl0123", param);
	}
	
	*/
	
	
}
