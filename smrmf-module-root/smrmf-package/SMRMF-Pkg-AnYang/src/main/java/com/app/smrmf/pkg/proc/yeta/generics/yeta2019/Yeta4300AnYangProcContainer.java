package com.app.smrmf.pkg.proc.yeta.generics.yeta2019;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161010_2019_VO;
import com.app.smrmf.pkg.yeta.yeta2019.tax.Yeta4300PkgProcContainer;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta4300AnYangProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta4300AnYangProcContainer.class);
	   
     
	
    public Yeta4300AnYangProcContainer() {
    	
    }
    
  
    public PagingLoadResult<ShowMessageBM> execfnYeta4300Payr06430CalcTax(HttpServletRequest request,List<InfcPkgYe161010_2019_VO> listYe161010VO)  throws Exception  {
  	    
  	  Yeta4300PkgProcContainer yeta4300 = new Yeta4300PkgProcContainer();
	  	  return  yeta4300.execfnYeta4300Payr06430CalcTax(request,  listYe161010VO);
	}
  
   
    
    public PagingLoadResult<ShowMessageBM> execfnYeta4300YetaTableCalcUpdate(HttpServletRequest request,InfcPkgYe161010_2019_VO  ye161010VO,String serviceDiv)  throws Exception  {
  	    
  	  Yeta4300PkgProcContainer yeta4300 = new Yeta4300PkgProcContainer();
	  	  return  yeta4300.execfnYeta4300YetaTableCalcUpdate(request,  ye161010VO,serviceDiv);
	}
    
  
 
}