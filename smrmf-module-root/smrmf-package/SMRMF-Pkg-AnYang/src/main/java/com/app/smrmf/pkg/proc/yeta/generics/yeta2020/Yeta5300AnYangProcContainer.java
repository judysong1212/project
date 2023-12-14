package com.app.smrmf.pkg.proc.yeta.generics.yeta2020;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;
import com.app.smrmf.pkg.yeta.yeta2020.tax.Yeta5300PkgProcContainer;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta5300AnYangProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta5300AnYangProcContainer.class);
	   
     
	
    public Yeta5300AnYangProcContainer() {
    	
    }
    
  
    public PagingLoadResult<ShowMessageBM> execfnYeta5300Payr06430CalcTax(HttpServletRequest request,List<InfcPkgYe161010_2020_VO> listYe161010VO)  throws Exception  {
  	    
  	  Yeta5300PkgProcContainer yeta5300 = new Yeta5300PkgProcContainer();
	  	  return  yeta5300.execfnYeta5300Payr06430CalcTax(request,  listYe161010VO);
	}
  
   
    
    public PagingLoadResult<ShowMessageBM> execfnYeta5300YetaTableCalcUpdate(HttpServletRequest request,InfcPkgYe161010_2020_VO  ye161010VO,String serviceDiv)  throws Exception  {
  	    
  	  Yeta5300PkgProcContainer yeta5300 = new Yeta5300PkgProcContainer();
	  	  return  yeta5300.execfnYeta5300YetaTableCalcUpdate(request,  ye161010VO,serviceDiv);
	}
    
  
 
}