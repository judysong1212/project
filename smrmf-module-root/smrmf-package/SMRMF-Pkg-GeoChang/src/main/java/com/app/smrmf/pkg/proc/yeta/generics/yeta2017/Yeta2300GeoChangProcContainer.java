package com.app.smrmf.pkg.proc.yeta.generics.yeta2017;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.pkg.yeta.yeta2017.tax.Yeta2300PkgProcContainer;
import com.app.smrmf.pkg.yeta.yeta2017.tax.service.Yeta2300PayrService;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta2300GeoChangProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta2300GeoChangProcContainer.class);
	  
  
    @Resource(name = "Yeta2300PayrService")
    protected Yeta2300PayrService  yeta2300;
    
     
	
    public Yeta2300GeoChangProcContainer() {
    	
    }
    
  
    
    public PagingLoadResult<ShowMessageBM> execfnYeta2300Payr06430CalcTax(HttpServletRequest request,List<InfcPkgYe161010VO> listYe161010VO)  throws Exception  {
  	    
    	  Yeta2300PkgProcContainer yeta2300 = new Yeta2300PkgProcContainer();
	  	  return  yeta2300.execfnYeta2300Payr06430CalcTax(request,  listYe161010VO);
	}
    
    
    public PagingLoadResult<ShowMessageBM> execfnYeta2300YetaTableCalcUpdate(HttpServletRequest request,InfcPkgYe161010VO  ye161010VO,String serviceDiv)  throws Exception  {
  	    
    	  Yeta2300PkgProcContainer yeta2300 = new Yeta2300PkgProcContainer();
  	  	  return  yeta2300.execfnYeta2300YetaTableCalcUpdate(request,  ye161010VO,serviceDiv);
  	}

  
 
}