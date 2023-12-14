package com.app.smrmf.pkg.yeta.yeta2023.tax;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161010_2023_VO;
import com.app.smrmf.pkg.yeta.yeta2023.tax.service.Yeta8300PayrService;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta8300PkgProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta8300PkgProcContainer.class);
	   
    @Resource(name = "Yeta8300PayrService")
    protected Yeta8300PayrService  infcPkgYeta8300;
    
//	@Resource(name = "Yeta2200XmlService")
//	private static Yeta2200XmlService yetaPayr2200Service;
//	
//
//    @Resource(name = "Yeta2100PayrService")
//    protected Yeta2100PayrService  yeta2100PayrService;
      
    public Yeta8300PkgProcContainer() {
    	
    } 
    //세액계산 클릭 시
    public PagingLoadResult<ShowMessageBM> execfnYeta8300Payr06430CalcTax(HttpServletRequest request,List<InfcPkgYe161010_2023_VO> listYe161010VO)  throws Exception  {
  	    
    	    Yeta8300TaxPkgProc pkgYeta8300TaxPkgProc = new Yeta8300TaxPkgProc();
	  	 
    	   return  pkgYeta8300TaxPkgProc.execfnYeta8300TaxPkgProc(request,  listYe161010VO);
	}
     
   
    
    /**
     * 
     * <pre>
     * 1. 개요 :  데이타 변경에 따른 처리  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : execfnYeta8300YetaTableCalcUpdate
     * @date : 2023. 1. 31.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2023. 1. 31.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param request
     * @param listYe161010VO
     * @param serviceDiv
     * @return
     * @throws Exception
     */
    public PagingLoadResult<ShowMessageBM> execfnYeta8300YetaTableCalcUpdate(HttpServletRequest request,InfcPkgYe161010_2023_VO  ye161010VO,String serviceDiv)  throws Exception  {
  	    
    	Yeta8300IncDdcPkgProc pkgIncDdcPkgProc = new Yeta8300IncDdcPkgProc();
	  	  return  pkgIncDdcPkgProc.funcYeta8300IncDdcPkgProc(request,  ye161010VO,serviceDiv);
	}
     
 
}