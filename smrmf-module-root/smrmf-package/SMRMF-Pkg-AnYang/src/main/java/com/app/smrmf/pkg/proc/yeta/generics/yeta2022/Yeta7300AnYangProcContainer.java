package com.app.smrmf.pkg.proc.yeta.generics.yeta2022;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161010_2022_VO;
import com.app.smrmf.pkg.yeta.yeta2022.tax.Yeta7300PkgProcContainer;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta7300AnYangProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta7300AnYangProcContainer.class);
	   
     
	
    public Yeta7300AnYangProcContainer() {
    	
    }
    
  
    public PagingLoadResult<ShowMessageBM> execfnYeta7300Payr06430CalcTax(HttpServletRequest request,List<InfcPkgYe161010_2022_VO> listYe161010VO)  throws Exception  {
  	    
  	  Yeta7300PkgProcContainer yeta7300 = new Yeta7300PkgProcContainer();
	  	  return  yeta7300.execfnYeta7300Payr06430CalcTax(request,  listYe161010VO);
	}
  
   
    
    public PagingLoadResult<ShowMessageBM> execfnYeta7300YetaTableCalcUpdate(HttpServletRequest request,InfcPkgYe161010_2022_VO  ye161010VO,String serviceDiv)  throws Exception  {
  	    
  	  Yeta7300PkgProcContainer yeta7300 = new Yeta7300PkgProcContainer();
	  	  return  yeta7300.execfnYeta7300YetaTableCalcUpdate(request,  ye161010VO,serviceDiv);
	}
    
  
 
}