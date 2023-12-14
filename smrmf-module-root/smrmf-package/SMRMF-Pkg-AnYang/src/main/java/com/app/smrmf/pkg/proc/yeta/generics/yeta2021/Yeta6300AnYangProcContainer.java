package com.app.smrmf.pkg.proc.yeta.generics.yeta2021;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161010_2021_VO;
import com.app.smrmf.pkg.yeta.yeta2021.tax.Yeta6300PkgProcContainer;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta6300AnYangProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta6300AnYangProcContainer.class);
	   
     
	
    public Yeta6300AnYangProcContainer() {
    	
    }
    
  
    public PagingLoadResult<ShowMessageBM> execfnYeta6300Payr06430CalcTax(HttpServletRequest request,List<InfcPkgYe161010_2021_VO> listYe161010VO)  throws Exception  {
  	    
  	  Yeta6300PkgProcContainer yeta6300 = new Yeta6300PkgProcContainer();
	  	  return  yeta6300.execfnYeta6300Payr06430CalcTax(request,  listYe161010VO);
	}
  
   
    
    public PagingLoadResult<ShowMessageBM> execfnYeta6300YetaTableCalcUpdate(HttpServletRequest request,InfcPkgYe161010_2021_VO  ye161010VO,String serviceDiv)  throws Exception  {
  	    
  	  Yeta6300PkgProcContainer yeta6300 = new Yeta6300PkgProcContainer();
	  	  return  yeta6300.execfnYeta6300YetaTableCalcUpdate(request,  ye161010VO,serviceDiv);
	}
    
  
 
}