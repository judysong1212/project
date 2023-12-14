package com.app.smrmf.pkg.yeta.yeta2022.tax;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161010_2022_VO;
import com.app.smrmf.pkg.yeta.yeta2022.tax.service.Yeta7300PayrService;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta7300PkgProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta7300PkgProcContainer.class);
	   
    @Resource(name = "Yeta7300PayrService")
    protected Yeta7300PayrService  infcPkgYeta7300;
    
//	@Resource(name = "Yeta2200XmlService")
//	private static Yeta2200XmlService yetaPayr2200Service;
//	
//
//    @Resource(name = "Yeta2100PayrService")
//    protected Yeta2100PayrService  yeta2100PayrService;
      
    public Yeta7300PkgProcContainer() {
    	
    } 
    //세액계산 클릭 시
    public PagingLoadResult<ShowMessageBM> execfnYeta7300Payr06430CalcTax(HttpServletRequest request,List<InfcPkgYe161010_2022_VO> listYe161010VO)  throws Exception  {
  	    
    	    Yeta7300TaxPkgProc pkgYeta7300TaxPkgProc = new Yeta7300TaxPkgProc();
	  	 
    	   return  pkgYeta7300TaxPkgProc.execfnYeta7300TaxPkgProc(request,  listYe161010VO);
	}
     
   
    
    /**
     * 
     * <pre>
     * 1. 개요 :  데이타 변경에 따른 처리  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : execfnYeta7300YetaTableCalcUpdate
     * @date : 2022. 1. 31.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2022. 1. 31.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param request
     * @param listYe161010VO
     * @param serviceDiv
     * @return
     * @throws Exception
     */
    public PagingLoadResult<ShowMessageBM> execfnYeta7300YetaTableCalcUpdate(HttpServletRequest request,InfcPkgYe161010_2022_VO  ye161010VO,String serviceDiv)  throws Exception  {
  	    
    	Yeta7300IncDdcPkgProc pkgIncDdcPkgProc = new Yeta7300IncDdcPkgProc();
	  	  return  pkgIncDdcPkgProc.funcYeta7300IncDdcPkgProc(request,  ye161010VO,serviceDiv);
	}
     
 
}