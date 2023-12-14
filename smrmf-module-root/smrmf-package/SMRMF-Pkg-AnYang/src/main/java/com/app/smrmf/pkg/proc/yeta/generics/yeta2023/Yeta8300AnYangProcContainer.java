package com.app.smrmf.pkg.proc.yeta.generics.yeta2023;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161010_2023_VO;
import com.app.smrmf.pkg.yeta.yeta2023.tax.Yeta8300PkgProcContainer;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta8300AnYangProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta8300AnYangProcContainer.class);
	   
     
	
    public Yeta8300AnYangProcContainer() {
    	
    }
    
  
    public PagingLoadResult<ShowMessageBM> execfnYeta8300Payr06430CalcTax(HttpServletRequest request,List<InfcPkgYe161010_2023_VO> listYe161010VO)  throws Exception  {
  	    
  	  Yeta8300PkgProcContainer yeta8300 = new Yeta8300PkgProcContainer();
	  	  return  yeta8300.execfnYeta8300Payr06430CalcTax(request,  listYe161010VO);
	}
  
   
    
    public PagingLoadResult<ShowMessageBM> execfnYeta8300YetaTableCalcUpdate(HttpServletRequest request,InfcPkgYe161010_2023_VO  ye161010VO,String serviceDiv)  throws Exception  {
  	    
  	  Yeta8300PkgProcContainer yeta8300 = new Yeta8300PkgProcContainer();
	  	  return  yeta8300.execfnYeta8300YetaTableCalcUpdate(request,  ye161010VO,serviceDiv);
	}
    
  
 
}