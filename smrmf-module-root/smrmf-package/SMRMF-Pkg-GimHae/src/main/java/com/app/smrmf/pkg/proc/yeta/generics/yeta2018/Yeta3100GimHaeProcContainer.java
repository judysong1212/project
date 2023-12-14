package com.app.smrmf.pkg.proc.yeta.generics.yeta2018;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161010_2018_VO;
import com.app.smrmf.pkg.yeta.yeta2018.create.Yeta3100PkgProcContainer;
import com.app.smrmf.pkg.yeta.yeta2018.tax.service.Yeta3100PayrService;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta3100GimHaeProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta3100GimHaeProcContainer.class);
	  
	 
  
    @Resource(name = "Yeta3100PayrService")
    protected Yeta3100PayrService  yeta3100PayrService;
    
//    @Resource(name = "YetaPayr6430Service")
//    protected YetaPayr6430Service  yetaPayr6430Service;
  
    
//    @Resource(name = "RetirementCalculstionService")
//    protected RetirementCalculstionService remtCalcService;
//
 
	
    public Yeta3100GimHaeProcContainer() {
    	
    }
    
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 단위사업장 맵핑
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */	
    public PagingLoadResult<ShowMessageBM> execUpDpopYeta_2018_Insert(HttpServletRequest request, List<InfcPkgYe161010_2018_VO> listYe161010VO)  throws Exception  {
  	    
    		Yeta3100PkgProcContainer yeta3100 = new Yeta3100PkgProcContainer(); 
	  	    return  yeta3100.execUpDpopYeta_2018_Insert(request,  listYe161010VO);
	}
     

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 연말정산 대상자생성 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */	
    public PagingLoadResult<ShowMessageBM> execYeta3100_All_Create(HttpServletRequest request, List<InfcPkgYe161010_2018_VO> listYe161010VO)  throws Exception  {
    	Yeta3100PkgProcContainer yeta3100 = new Yeta3100PkgProcContainer(); 
  	    return  yeta3100.execYeta3100_All_2018_Create(request,  listYe161010VO);
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
	public PagingLoadResult<ShowMessageBM> execPayrToYeta_2018_Insert(HttpServletRequest request, List<InfcPkgYe161010_2018_VO> lstInfcPkgYe161010Vo)throws Exception {
		
		Yeta3100PkgProcContainer yeta3100 = new Yeta3100PkgProcContainer();   
		return yeta3100.execPayrToYeta_2018_Insert(request, lstInfcPkgYe161010Vo);
	}  
    
}