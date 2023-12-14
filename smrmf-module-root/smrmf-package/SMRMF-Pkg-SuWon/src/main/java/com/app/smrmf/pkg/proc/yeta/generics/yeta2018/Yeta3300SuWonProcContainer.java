package com.app.smrmf.pkg.proc.yeta.generics.yeta2018;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161010_2018_VO;
import com.app.smrmf.pkg.yeta.yeta2018.tax.service.Yeta3300PayrService;
import com.app.smrmf.pkg.yeta.yeta2018.tax.Yeta3300PkgProcContainer;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta3300SuWonProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta3300SuWonProcContainer.class);
	  
  
    @Resource(name = "Yeta3300PayrService")
    protected Yeta3300PayrService  yeta3300;
    
     
	
    public Yeta3300SuWonProcContainer() {
    	
    }
    
  
    
    public PagingLoadResult<ShowMessageBM> execfnYeta3300Payr06430CalcTax(HttpServletRequest request,List<InfcPkgYe161010_2018_VO> listYe161010VO)  throws Exception  {
  	    
  	  Yeta3300PkgProcContainer yeta3300 = new Yeta3300PkgProcContainer();
	  	  return  yeta3300.execfnYeta3300Payr06430CalcTax(request,  listYe161010VO);
	}
  
  
  public PagingLoadResult<ShowMessageBM> execfnYeta3300YetaTableCalcUpdate(HttpServletRequest request,InfcPkgYe161010_2018_VO ye161010VO,String serviceDiv)  throws Exception  {
	    
	  Yeta3300PkgProcContainer yeta3300 = new Yeta3300PkgProcContainer();
	  	  return  yeta3300.execfnYeta3300YetaTableCalcUpdate(request,  ye161010VO,serviceDiv);
	}
 
}