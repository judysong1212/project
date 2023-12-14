package com.app.smrmf.pkg.yeta.yeta2021.tax;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161010_2021_VO;
import com.app.smrmf.pkg.yeta.yeta2021.tax.service.Yeta6300PayrService;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta6300PkgProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta6300PkgProcContainer.class);
	   
    @Resource(name = "Yeta6300PayrService")
    protected Yeta6300PayrService  infcPkgYeta6300;
    
//	@Resource(name = "Yeta2200XmlService")
//	private static Yeta2200XmlService yetaPayr2200Service;
//	
//
//    @Resource(name = "Yeta2100PayrService")
//    protected Yeta2100PayrService  yeta2100PayrService;
      
    public Yeta6300PkgProcContainer() {
    	
    } 
    //세액계산 클릭 시
    public PagingLoadResult<ShowMessageBM> execfnYeta6300Payr06430CalcTax(HttpServletRequest request,List<InfcPkgYe161010_2021_VO> listYe161010VO)  throws Exception  {
  	    
    	    Yeta6300TaxPkgProc pkgYeta6300TaxPkgProc = new Yeta6300TaxPkgProc();
	  	 
    	   return  pkgYeta6300TaxPkgProc.execfnYeta6300TaxPkgProc(request,  listYe161010VO);
	}
     
   
    
    /**
     * 
     * <pre>
     * 1. 개요 :  데이타 변경에 따른 처리  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : execfnYeta6300YetaTableCalcUpdate
     * @date : 2021. 1. 31.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2021. 1. 31.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param request
     * @param listYe161010VO
     * @param serviceDiv
     * @return
     * @throws Exception
     */
    public PagingLoadResult<ShowMessageBM> execfnYeta6300YetaTableCalcUpdate(HttpServletRequest request,InfcPkgYe161010_2021_VO  ye161010VO,String serviceDiv)  throws Exception  {
  	    
    	Yeta6300IncDdcPkgProc pkgIncDdcPkgProc = new Yeta6300IncDdcPkgProc();
	  	  return  pkgIncDdcPkgProc.funcYeta6300IncDdcPkgProc(request,  ye161010VO,serviceDiv);
	}
     
 
}