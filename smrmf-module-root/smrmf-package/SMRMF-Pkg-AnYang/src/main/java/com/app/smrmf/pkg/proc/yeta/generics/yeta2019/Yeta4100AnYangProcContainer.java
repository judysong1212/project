package com.app.smrmf.pkg.proc.yeta.generics.yeta2019;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161010_2019_VO;
import com.app.smrmf.pkg.yeta.yeta2019.create.Yeta4100PkgProcContainer;
import com.app.smrmf.pkg.yeta.yeta2019.tax.service.Yeta4100PayrService;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta4100AnYangProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta4100AnYangProcContainer.class);
	  
	 
  
    @Resource(name = "Yeta4100PayrService")
    protected Yeta4100PayrService  yeta4100PayrService;
    
    public Yeta4100AnYangProcContainer() {
    	
    }
    
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 단위사업장 맵핑
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */	
    public PagingLoadResult<ShowMessageBM> execUpDpopYeta_2019_Insert(HttpServletRequest request, List<InfcPkgYe161010_2019_VO> listYe161010VO)  throws Exception  {
  	    
    		Yeta4100PkgProcContainer yeta4100 = new Yeta4100PkgProcContainer(); 
	  	    return  yeta4100.execUpDpopYeta_2019_Insert(request,  listYe161010VO);
	}
    
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 연말정산 대상자생성 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */	
    public PagingLoadResult<ShowMessageBM> execYeta4100_All_Create(HttpServletRequest request, List<InfcPkgYe161010_2019_VO> listYe161010VO)  throws Exception  {
  	    
    	Yeta4100PkgProcContainer yeta4100 = new Yeta4100PkgProcContainer(); 
  	    return  yeta4100.execYeta4100_All_2019_Create(request,  listYe161010VO);
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
	public PagingLoadResult<ShowMessageBM> execPayrToYeta_2019_Insert(HttpServletRequest request, List<InfcPkgYe161010_2019_VO> lstInfcPkgYe161010Vo)throws Exception {

		Yeta4100PkgProcContainer yeta4100 = new Yeta4100PkgProcContainer();   
		return yeta4100.execPayrToYeta_2019_Insert(request, lstInfcPkgYe161010Vo);
	
	}  
    
	 
}