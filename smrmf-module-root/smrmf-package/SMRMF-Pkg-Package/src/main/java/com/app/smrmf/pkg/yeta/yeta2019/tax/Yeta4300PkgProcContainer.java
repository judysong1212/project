package com.app.smrmf.pkg.yeta.yeta2019.tax;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161010_2019_VO;
import com.app.smrmf.pkg.yeta.yeta2019.tax.service.Yeta4300PayrService;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta4300PkgProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta4300PkgProcContainer.class);
	   
    @Resource(name = "Yeta4300PayrService")
    protected Yeta4300PayrService  infcPkgYeta4300;
    
//	@Resource(name = "Yeta2200XmlService")
//	private static Yeta2200XmlService yetaPayr2200Service;
//	
//
//    @Resource(name = "Yeta2100PayrService")
//    protected Yeta2100PayrService  yeta2100PayrService;
      
    public Yeta4300PkgProcContainer() {
    	
    } 
    // 용인 세액계산 클릭 시
    public PagingLoadResult<ShowMessageBM> execfnYeta4300Payr06430CalcTax(HttpServletRequest request,List<InfcPkgYe161010_2019_VO> listYe161010VO)  throws Exception  {
  	    
    	    Yeta4300TaxPkgProc pkgYeta4300TaxPkgProc = new Yeta4300TaxPkgProc();
	  	 
    	   return  pkgYeta4300TaxPkgProc.execfnYeta4300TaxPkgProc(request,  listYe161010VO);
	}
     
   
    
    /**
     * 
     * <pre>
     * 1. 개요 :  데이타 변경에 따른 처리  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : execfnYeta4300YetaTableCalcUpdate
     * @date : 2019. 1. 31.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2019. 1. 31.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param request
     * @param listYe161010VO
     * @param serviceDiv
     * @return
     * @throws Exception
     */
    public PagingLoadResult<ShowMessageBM> execfnYeta4300YetaTableCalcUpdate(HttpServletRequest request,InfcPkgYe161010_2019_VO  ye161010VO,String serviceDiv)  throws Exception  {
  	    
    	Yeta4300IncDdcPkgProc pkgIncDdcPkgProc = new Yeta4300IncDdcPkgProc();
	  	  return  pkgIncDdcPkgProc.funcYeta4300IncDdcPkgProc(request,  ye161010VO,serviceDiv);
	}
     
 
}