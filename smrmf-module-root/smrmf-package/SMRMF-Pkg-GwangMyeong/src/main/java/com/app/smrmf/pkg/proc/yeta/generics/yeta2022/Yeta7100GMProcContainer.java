package com.app.smrmf.pkg.proc.yeta.generics.yeta2022;

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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe160510_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161005_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161030_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161040_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161050_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161055_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161060_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161070_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161080_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161090_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162030_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162040_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162510_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162520_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162530_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe164010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165030_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe166010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe166020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe169010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161010_2022_VO;
import com.app.smrmf.pkg.yeta.yeta2022.create.Yeta7100PkgProcContainer;
import com.app.smrmf.pkg.yeta.yeta2022.tax.service.Yeta7100PayrService;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0350VO;
import com.ext.constants.PropPayGenConfs;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta7100GMProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta7100GMProcContainer.class);
	  
	 
  
    @Resource(name = "Yeta7100PayrService")
    protected Yeta7100PayrService  yeta7100PayrService;
    
//    @Resource(name = "YetaPayr6430Service")
//    protected YetaPayr6430Service  yetaPayr6430Service;
  
    
//    @Resource(name = "RetirementCalculstionService")
//    protected RetirementCalculstionService remtCalcService;
//
 
	
    public Yeta7100GMProcContainer() {
    	
    }
    
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 단위사업장 맵핑
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */	
    public PagingLoadResult<ShowMessageBM> execUpDpopYeta_2022_Insert(HttpServletRequest request, List<InfcPkgYe161010_2022_VO> listYe161010VO)  throws Exception  {
  	    
    		Yeta7100PkgProcContainer yeta7100 = new Yeta7100PkgProcContainer(); 
	  	    return  yeta7100.execUpDpopYeta_2022_Insert(request,  listYe161010VO);
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
    public PagingLoadResult<ShowMessageBM> execYeta7100_All_2022_Create(HttpServletRequest request, List<InfcPkgYe161010_2022_VO> listYe161010VO)  throws Exception  {
  	    
    	Yeta7100PkgProcContainer yeta7100 = new Yeta7100PkgProcContainer(); 
  	    return  yeta7100.execYeta7100_All_2022_Create(request,  listYe161010VO);
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
	public PagingLoadResult<ShowMessageBM> execPayrToYeta_2022_Insert(HttpServletRequest request, List<InfcPkgYe161010_2022_VO> lstInfcPkgYe161010Vo)throws Exception {

		Yeta7100PkgProcContainer yeta7100 = new Yeta7100PkgProcContainer();   
		return yeta7100.execPayrToYeta_2022_Insert(request, lstInfcPkgYe161010Vo);
	
	}  
    
    
}