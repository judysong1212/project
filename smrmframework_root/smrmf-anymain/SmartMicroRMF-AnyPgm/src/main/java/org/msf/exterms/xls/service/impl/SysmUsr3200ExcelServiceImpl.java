package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.msf.exterms.xls.service.SysmUsr3200ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.sysm.server.service.dao.SysmHist0200DAO;
import com.app.smrmf.sysm.server.vo.SysIfHist0200SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("SysmUsr3200ExcelService")
public class SysmUsr3200ExcelServiceImpl extends AbstractServiceImpl implements SysmUsr3200ExcelService {
	
	 private static final Logger logger = LoggerFactory.getLogger(SysmUsr3200ExcelServiceImpl.class);
	 private static final String calledClass = SysmUsr3200ExcelServiceImpl.class.getName();
	 

	// 점검내역 엑셀 추가_hieju 07.31
	  private static ServletContext sevltContext; 
	  private static ServletConfig sevltConfig;
	  
	  @Override
	    public void setServletConfig(ServletConfig servletConfig) {
	        this.sevltConfig = servletConfig;

	    }

	    @Override
	    public void setServletContext(ServletContext servletContext) {
	        this.sevltContext = servletContext;

	    }
	    
	 // ************끝
   
   @Autowired 
   @Resource(name="SysmHist0200DAO")
   private SysmHist0200DAO hist0200DAO;
    
//    @Autowired 
//    @Resource(name="stts0100DAO")
//    private Stts0100DAO stts0100DAO;
	
    
    //엑셀파일 저장
	public List  selectXlsFileHist0200List(SysIfHist0200SrhVO hist0200SrhVo) throws Exception {
		return hist0200DAO.selectHist0200ExlList(hist0200SrhVo);
	}
	
	public List<SysIfHist0200SrhVO> selectXlsSysm3200List(SysIfHist0200SrhVO oracleDb0100) throws Exception {
	      return hist0200DAO.selectXlsSysm3200List(oracleDb0100);
	  } 
	  
	  //엑셀 다운로드
	  public List  selectXlsFileSysm3200List(SysIfHist0200SrhVO oracleDb0100) throws Exception {
	      return hist0200DAO.selectXlsFileSysm3200List(oracleDb0100);
	  }

	@Override
	public List<SysIfHist0200SrhVO> selectXlsSysm3200List1(
			SysIfHist0200SrhVO oracleDb0100) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectXlsFileSysm3200List1(SysIfHist0200SrhVO oracleDb0100)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}   
	// *********끝
	
	

  
}
