package com.app.smrmf.pkg.proc.yeta.generics.yeta2020;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;
import com.app.smrmf.pkg.yeta.yeta2020.create.Yeta5100PkgProcContainer;
import com.app.smrmf.pkg.yeta.yeta2020.tax.service.Yeta5100PayrService;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta5100AnSeongProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta5100AnSeongProcContainer.class);
	  
	 
  
    @Resource(name = "Yeta5100PayrService")
    protected Yeta5100PayrService  yeta5100PayrService;
    
//    @Resource(name = "YetaPayr6430Service")
//    protected YetaPayr6430Service  yetaPayr6430Service;
  
    
//    @Resource(name = "RetirementCalculstionService")
//    protected RetirementCalculstionService remtCalcService;
//
 
	
    public Yeta5100AnSeongProcContainer() {
    	
    }
    
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 단위사업장 맵핑
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */	
    public PagingLoadResult<ShowMessageBM> execUpDpopYeta_2020_Insert(HttpServletRequest request, List<InfcPkgYe161010_2020_VO> listYe161010VO)  throws Exception  {
  	    
    		Yeta5100PkgProcContainer yeta5100 = new Yeta5100PkgProcContainer(); 
	  	    return  yeta5100.execUpDpopYeta_2020_Insert(request,  listYe161010VO);
	}
    
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 연말정산 대상자생성 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */	
    public PagingLoadResult<ShowMessageBM> execYeta5100_All_Create(HttpServletRequest request,  List<InfcPkgYe161010_2020_VO> listYe161010VO)  throws Exception  {
  	    
    	Yeta5100PkgProcContainer yeta5100 = new Yeta5100PkgProcContainer(); 
  	    return  yeta5100.execYeta5100_All_2020_Create(request,  listYe161010VO);
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
	public PagingLoadResult<ShowMessageBM> execPayrToYeta_2020_Insert(HttpServletRequest request, List<InfcPkgYe161010_2020_VO> lstInfcPkgYe161010Vo)throws Exception {

		Yeta5100PkgProcContainer yeta5100 = new Yeta5100PkgProcContainer();   
		return yeta5100.execPayrToYeta_2020_Insert(request, lstInfcPkgYe161010Vo);
	
	}  
    
	 
}