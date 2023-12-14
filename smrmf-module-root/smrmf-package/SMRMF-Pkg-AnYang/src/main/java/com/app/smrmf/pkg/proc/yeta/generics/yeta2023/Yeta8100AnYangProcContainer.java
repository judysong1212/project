package com.app.smrmf.pkg.proc.yeta.generics.yeta2023;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161010_2023_VO;
import com.app.smrmf.pkg.yeta.yeta2023.create.Yeta8100PkgProcContainer;
import com.app.smrmf.pkg.yeta.yeta2023.tax.service.Yeta8100PayrService;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta8100AnYangProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta8100AnYangProcContainer.class);
	  
	 
  
    @Resource(name = "Yeta8100PayrService")
    protected Yeta8100PayrService  yeta8100PayrService;
    
    public Yeta8100AnYangProcContainer() {
    	
    }
    
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 단위사업장 맵핑
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */	
    public PagingLoadResult<ShowMessageBM> execUpDpopYeta_2023_Insert(HttpServletRequest request, List<InfcPkgYe161010_2023_VO> listYe161010VO)  throws Exception  {
  	    
    		Yeta8100PkgProcContainer yeta8100 = new Yeta8100PkgProcContainer(); 
	  	    return  yeta8100.execUpDpopYeta_2023_Insert(request,  listYe161010VO);
	}
    
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 연말정산 대상자생성 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */	
    public PagingLoadResult<ShowMessageBM> execYeta8100_All_Create(HttpServletRequest request, List<InfcPkgYe161010_2023_VO> listYe161010VO)  throws Exception  {
  	    
    	Yeta8100PkgProcContainer yeta8100 = new Yeta8100PkgProcContainer(); 
  	    return  yeta8100.execYeta8100_All_2023_Create(request,  listYe161010VO);
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
	public PagingLoadResult<ShowMessageBM> execPayrToYeta_2023_Insert(HttpServletRequest request, List<InfcPkgYe161010_2023_VO> lstInfcPkgYe161010Vo)throws Exception {

		Yeta8100PkgProcContainer yeta8100 = new Yeta8100PkgProcContainer();   
		return yeta8100.execPayrToYeta_2023_Insert(request, lstInfcPkgYe161010Vo);
	
	}  
    
	 
}