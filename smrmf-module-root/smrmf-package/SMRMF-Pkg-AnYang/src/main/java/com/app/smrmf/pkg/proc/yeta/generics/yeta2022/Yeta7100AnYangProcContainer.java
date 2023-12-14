package com.app.smrmf.pkg.proc.yeta.generics.yeta2022;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161010_2022_VO;
import com.app.smrmf.pkg.yeta.yeta2022.create.Yeta7100PkgProcContainer;
import com.app.smrmf.pkg.yeta.yeta2022.tax.service.Yeta7100PayrService;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta7100AnYangProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta7100AnYangProcContainer.class);
	  
	 
  
    @Resource(name = "Yeta7100PayrService")
    protected Yeta7100PayrService  yeta7100PayrService;
    
    public Yeta7100AnYangProcContainer() {
    	
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
	 * 연말정산 대상자생성 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */	
    public PagingLoadResult<ShowMessageBM> execYeta7100_All_Create(HttpServletRequest request, List<InfcPkgYe161010_2022_VO> listYe161010VO)  throws Exception  {
  	    
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