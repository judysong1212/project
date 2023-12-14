package org.msf.exterms.xls.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Psnl0600ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.personal.server.service.dao.Psnl0600DAO;
import com.app.exterms.personal.server.vo.Psnl0600SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("psnl0600ExcelService")
public class Psnl0600ExcelServiceImpl extends AbstractServiceImpl implements Psnl0600ExcelService {
    
    
    @Autowired
    @Resource(name="psnl0600DAO")
    private Psnl0600DAO psnl0600DAO;
     
  public List selectXlsPsnl0600List(HashMap<String, String> param) throws Exception {
      return psnl0600DAO.selectPsnl0600(param);
  } 
  
  //엑셀파일 저장_jxls
//	public List  selectXlsPsnl0600List(Psnl0100SrhVO psnl0100SrhVo) throws Exception {
//		return psnl0600DAO.selectPsnl0600(psnl0100SrhVo);
//	}
  
  
	/** 인사통합검색 엑셀저장 **/
	public List  selectXlsPsnl0600SelList(Psnl0600SrhVO psnl0600SrhVo) throws Exception {
		return psnl0600DAO.selPsnl0600Xls(psnl0600SrhVo);
	}
	
	/** 인사통합검색 엑셀저장(기본) **/
	public List  selectXlsPsnl0600List(Psnl0600SrhVO psnl0600SrhVo) throws Exception {
		return psnl0600DAO.selectPsnl0600Xls(psnl0600SrhVo);
	}
	
	/** 인사통합검색 엑셀저장(병역) **/
	public List  selectXlsPsnl0600ToPsnl0112List(Psnl0600SrhVO psnl0600SrhVo) throws Exception {
		return psnl0600DAO.selectPsnl0112Xls(psnl0600SrhVo);
	}
	
	/** 인사통합검색 엑셀저장(단체) **/
	public List  selectXlsPsnl0600ToPsnl0114List(Psnl0600SrhVO psnl0600SrhVo) throws Exception {
		return psnl0600DAO.selectPsnl0114Xls(psnl0600SrhVo);
	}
	
	/** 인사통합검색 엑셀저장(학력) **/
	public List  selectXlsPsnl0600ToPsnl0116List(Psnl0600SrhVO psnl0600SrhVo) throws Exception {
		return psnl0600DAO.selectPsnl0116Xls(psnl0600SrhVo);
	}
	
	/** 인사통합검색 엑셀저장(경력) **/
	public List  selectXlsPsnl0600ToPsnl0119List(Psnl0600SrhVO psnl0600SrhVo) throws Exception {
		return psnl0600DAO.selectPsnl0119Xls(psnl0600SrhVo);
	}
	
	/** 인사통합검색 엑셀저장(자격) **/
	public List  selectXlsPsnl0600ToPsnl0118List(Psnl0600SrhVO psnl0600SrhVo) throws Exception {
		return psnl0600DAO.selectPsnl0118Xls(psnl0600SrhVo);
	}
	
	/** 인사통합검색 엑셀저장(교육) **/
	public List  selectXlsPsnl0600ToPsnl0120List(Psnl0600SrhVO psnl0600SrhVo) throws Exception {
		return psnl0600DAO.selectPsnl0120Xls(psnl0600SrhVo);
	}
	
	/** 인사통합검색 엑셀저장(포상) **/
	public List  selectXlsPsnl0600ToPsnl0121List(Psnl0600SrhVO psnl0600SrhVo) throws Exception {
		return psnl0600DAO.selectPsnl0121Xls(psnl0600SrhVo);
	}
	
	/** 인사통합검색 엑셀저장(징계) **/
	public List  selectXlsPsnl0600ToPsnl0122List(Psnl0600SrhVO psnl0600SrhVo) throws Exception {
		return psnl0600DAO.selectPsnl0122Xls(psnl0600SrhVo);
	}
	
	/** 인사통합검색 엑셀저장(휴직) **/
	public List  selectXlsPsnl0600ToPsnl0123List(Psnl0600SrhVO psnl0600SrhVo) throws Exception {
		return psnl0600DAO.selectPsnl0123Xls(psnl0600SrhVo);
	}

 
}
