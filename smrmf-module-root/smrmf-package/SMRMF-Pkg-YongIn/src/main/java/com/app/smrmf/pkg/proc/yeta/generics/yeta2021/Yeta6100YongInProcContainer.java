package com.app.smrmf.pkg.proc.yeta.generics.yeta2021;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.server.utils.SysifPkgServiceUtils;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160402VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160403VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta1000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3100VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3110VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3120VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3130VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3140VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3150VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3160VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3170VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3180VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3190VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3220VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe160510_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161005_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161020_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161030_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161040_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161050_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161055_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161060_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161070_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161080_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161090_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162020_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162030_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162040_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162510_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162520_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162530_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe164010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe165010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe165020_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe165030_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe166010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe166020_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe169010_2021_VO;
import com.app.smrmf.pkg.yeta.yeta2021.create.Yeta6100PkgProcContainer;
import com.app.smrmf.pkg.yeta.yeta2021.tax.service.Yeta6100PayrService;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0350VO;
import com.ext.constants.PropPayGenConfs;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta6100YongInProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta6100YongInProcContainer.class);
	  
	 
  
    @Resource(name = "Yeta6100PayrService")
    protected Yeta6100PayrService  yeta2100PayrService;
    
//    @Resource(name = "YetaPayr6430Service")
//    protected YetaPayr6430Service  yetaPayr6430Service;
  
    
//    @Resource(name = "RetirementCalculstionService")
//    protected RetirementCalculstionService remtCalcService;
//
 
	
    public Yeta6100YongInProcContainer() {
    	
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
	 * 단위사업장 맵핑 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 연말정산 대상자생성 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */	
    public PagingLoadResult<ShowMessageBM> execYeta6100_All_2021_Create(HttpServletRequest request,  List<InfcPkgYe161010_2021_VO> listYe161010VO)  throws Exception  {
  	    
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
	public PagingLoadResult<ShowMessageBM> execPayrToYeta_2021_Insert(HttpServletRequest request,List<InfcPkgYe161010_2021_VO> listYe161010VO)throws Exception {

		Yeta6100PkgProcContainer yeta6100 = new Yeta6100PkgProcContainer();   
		return yeta6100.execPayrToYeta_2021_Insert(request, listYe161010VO);
	
	}  
    
	 
}