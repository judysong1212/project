package com.app.smrmf.pkg.yeta.yeta2017.tax;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.pkg.yeta.yeta2017.tax.service.Yeta2300PayrService;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta2300PkgProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta2300PkgProcContainer.class);
	   
    @Resource(name = "Yeta2300PayrService")
    protected Yeta2300PayrService  infcPkgYeta2300;
    
//	@Resource(name = "Yeta2200XmlService")
//	private static Yeta2200XmlService yetaPayr2200Service;
//	
//
//    @Resource(name = "Yeta2100PayrService")
//    protected Yeta2100PayrService  yeta2100PayrService;
      
    public Yeta2300PkgProcContainer() {
    	
    } 
    
    public PagingLoadResult<ShowMessageBM> execfnYeta2300Payr06430CalcTax(HttpServletRequest request,List<InfcPkgYe161010VO> listYe161010VO)  throws Exception  {
  	    
    	    Yeta2300TaxPkgProc pkgYeta2300TaxPkgProc = new Yeta2300TaxPkgProc();
	  	 
    	   return  pkgYeta2300TaxPkgProc.execfnYeta2300TaxPkgProc(request,  listYe161010VO);
	}
     
   
    
    /**
     * 
     * <pre>
     * 1. 개요 :  데이타 변경에 따른 처리  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : execfnYeta2300YetaTableCalcUpdate
     * @date : 2018. 1. 31.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2018. 1. 31.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param request
     * @param listYe161010VO
     * @param serviceDiv
     * @return
     * @throws Exception
     */
    public PagingLoadResult<ShowMessageBM> execfnYeta2300YetaTableCalcUpdate(HttpServletRequest request,InfcPkgYe161010VO  ye161010VO,String serviceDiv)  throws Exception  {
  	    
    	Yeta2300IncDdcPkgProc pkgIncDdcPkgProc = new Yeta2300IncDdcPkgProc();
	  	  return  pkgIncDdcPkgProc.funcYeta2300IncDdcPkgProc(request,  ye161010VO,serviceDiv);
	}
     
 
}