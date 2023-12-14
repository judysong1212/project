package com.app.smrmf.pkg.proc.yeta.generics.yeta2017;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.pkg.yeta.yeta2017.create.Yeta2100PkgProcContainer;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta2100GimHaeProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta2100GimHaeProcContainer.class);
	   
	
    public Yeta2100GimHaeProcContainer() {
    	
    }
    
    		
    
    

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 단위사업장 맵핑
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */	
    public PagingLoadResult<ShowMessageBM> execUpDpopYeta_Insert(HttpServletRequest request, List<InfcPkgYe161010VO> listYe161010VO)  throws Exception  {
  	    
    		Yeta2100PkgProcContainer yeta2100 = new Yeta2100PkgProcContainer(); 
	  	    return  yeta2100.execUpDpopYeta_Insert(request,  listYe161010VO);
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
    public PagingLoadResult<ShowMessageBM> execYeta2100_All_Create(HttpServletRequest request, List<InfcPkgYe161010VO> listYe161010VO)  throws Exception  {
  	    
    		Yeta2100PkgProcContainer yeta2100 = new Yeta2100PkgProcContainer(); 
	  	    return  yeta2100.execYeta2100_All_Create(request,  listYe161010VO);
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
	public PagingLoadResult<ShowMessageBM> execPayrToYeta_2017_Insert(HttpServletRequest request, List<InfcPkgYe161010VO> listYe161010VO)throws Exception {
		
		Yeta2100PkgProcContainer yeta2100 = new Yeta2100PkgProcContainer();   
		return yeta2100.execPayrToYeta_2017_Insert(request, listYe161010VO);
	}  
    
}