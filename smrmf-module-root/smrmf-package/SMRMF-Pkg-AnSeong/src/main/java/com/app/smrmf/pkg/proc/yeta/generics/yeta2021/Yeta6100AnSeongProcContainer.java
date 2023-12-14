package com.app.smrmf.pkg.proc.yeta.generics.yeta2021;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161010_2021_VO;
import com.app.smrmf.pkg.yeta.yeta2021.create.Yeta6100PkgProcContainer;
import com.app.smrmf.pkg.yeta.yeta2021.tax.service.Yeta6100PayrService;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta6100AnSeongProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta6100AnSeongProcContainer.class);
	  
	 
  
    @Resource(name = "Yeta6100PayrService")
    protected Yeta6100PayrService  yeta6100PayrService;
    
//    @Resource(name = "YetaPayr6430Service")
//    protected YetaPayr6430Service  yetaPayr6430Service;
  
    
//    @Resource(name = "RetirementCalculstionService")
//    protected RetirementCalculstionService remtCalcService;
//
 
	
    public Yeta6100AnSeongProcContainer() {
    	
    }
    
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 단위사업장 맵핑
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */	
    public PagingLoadResult<ShowMessageBM> execUpDpopYeta_2021_Insert(HttpServletRequest request, List<InfcPkgYe161010_2021_VO> listYe161010VO)  throws Exception  {
  	    
    		Yeta6100PkgProcContainer yeta6100 = new Yeta6100PkgProcContainer(); 
	  	    return  yeta6100.execUpDpopYeta_2021_Insert(request,  listYe161010VO);
	}
    
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 연말정산 대상자생성 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */	
    public PagingLoadResult<ShowMessageBM> execYeta6100_All_Create(HttpServletRequest request,  List<InfcPkgYe161010_2021_VO> listYe161010VO)  throws Exception  {
  	    
    	Yeta6100PkgProcContainer yeta6100 = new Yeta6100PkgProcContainer(); 
  	    return  yeta6100.execYeta6100_All_2021_Create(request,  listYe161010VO);
	}
    
     
    /**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 연말정산 대상자생성 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */		  
    
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 연말정산 급여자료이관 인터페이스 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */
	public PagingLoadResult<ShowMessageBM> execPayrToYeta_2021_Insert(HttpServletRequest request, List<InfcPkgYe161010_2021_VO> lstInfcPkgYe161010Vo)throws Exception {

		Yeta6100PkgProcContainer yeta6100 = new Yeta6100PkgProcContainer();   
		return yeta6100.execPayrToYeta_2021_Insert(request, lstInfcPkgYe161010Vo);
	
	}  
    
	 
}