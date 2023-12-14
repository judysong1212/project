package com.app.smrmf.pkg.proc.yeta.generics.yeta2016;

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
import com.app.smrmf.pkg.yeta.yeta2016.tax.service.Yeta1100PayrService;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0350VO;
import com.ext.constants.PropPayGenConfs;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta1100AnYangProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta1100AnYangProcContainer.class);
	  
	 
  
    @Resource(name = "Yeta1100PayrService")
    protected Yeta1100PayrService  yeta1100PayrService;
    
//    @Resource(name = "YetaPayr6430Service")
//    protected YetaPayr6430Service  yetaPayr6430Service;
  
    
//    @Resource(name = "RetirementCalculstionService")
//    protected RetirementCalculstionService remtCalcService;
//
 
	
    public Yeta1100AnYangProcContainer() {
    	
    }
    
    
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 연말정산 대상자생성 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */	
    public PagingLoadResult<ShowMessageBM> execYeta1100_All_Create(HttpServletRequest request, List<InfcPkgYeta1000VO> listYetaPrc1000Vo)  throws Exception  {
  	    
	  	  return  funcYetaYeta1100_All_Create(request,  listYetaPrc1000Vo);
	}
    
    private PagingLoadResult<ShowMessageBM> funcYetaYeta1100_All_Create(HttpServletRequest request, List<InfcPkgYeta1000VO>  listYetaPrc1000Vo)  throws Exception  {
    	
		PagingLoadResult<ShowMessageBM> retval = null;
		List<ShowMessageBM> bmResult = new ArrayList<ShowMessageBM>();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		
		Boolean yeta100Chk = true;
		InfcPkgYeta1000VO infcPkgYeta1000Vo = new InfcPkgYeta1000VO();
		InfcPkgYeta1000VO tpYetaPrc1000Vo = new InfcPkgYeta1000VO(); 	// 마감테이블
		InfcPkgYeta3120VO infcPkgYeta3120Vo = new InfcPkgYeta3120VO(); 		// 거주자주택자금_금전소비대차
		InfcPkgYeta3160VO infcPkgYeta3160Vo = new InfcPkgYeta3160VO(); 		// 거주자주택자금_임대차
		InfcPkgYeta3100VO infcPkgYeta3100Vo = new InfcPkgYeta3100VO(); 		// 연금_저축공제
		InfcPkgYeta3130VO infcPkgYeta3130Vo = new InfcPkgYeta3130VO(); 		// 주택자금_월세
		InfcPkgYeta3140VO infcPkgYeta3140Vo = new InfcPkgYeta3140VO(); 		// 의료비
		InfcPkgYeta3180VO infcPkgYeta3180Vo = new InfcPkgYeta3180VO(); 		// 기부금 명세
		InfcPkgYeta3170VO infcPkgYeta3170Vo = new InfcPkgYeta3170VO(); 		// 이월기부금명세
		InfcPkgYeta3190VO infcPkgYeta3190Vo = new InfcPkgYeta3190VO(); 		// 이월기부금temp
		InfcPkgYeta3110VO infcPkgYeta3110Vo = new InfcPkgYeta3110VO(); 		// 종전근무지명세
//		InfcPkgYeta3200VO infcPkgYeta3200Vo = new InfcPkgYeta3200VO(); 		// 비과세감면소득
		InfcPkgYeta3220VO infcPkgYeta3220Vo = new InfcPkgYeta3220VO(); 		// 가족사항
		InfcPkgYeta3150VO infcPkgYeta3150Vo = new InfcPkgYeta3150VO(); 		// 교육비
//		InfcPkgYeta3210VO infcPkgYeta3210Vo = new InfcPkgYeta3210VO(); 		// 급여내역
		InfcPkgYe160401VO infcPkgYe160401Vo = new InfcPkgYe160401VO(); 		// 현근무지 급여지급 명세
//		InfcPkgYeta3300VO yetaPrc3300Vo = new InfcPkgYeta3300VO(); 		// 비과세감면소득정산
		InfcPkgYe160402VO infcPkgYe160402Vo = new InfcPkgYe160402VO(); 		// 과세감면소득정산  
		InfcPkgYe160403VO infcPkgYe160403Vo = new InfcPkgYe160403VO(); 		// 비과세감면소득정산  
		InfcPkgYeta3000VO infcPkgYeta3000Vo = new InfcPkgYeta3000VO(); 		// 연말정산결과
		InfcPkgYeta2000VO infcPkgYeta2000Vo = new InfcPkgYeta2000VO(); 		// 연말정산기본 
      
		String dataCheck = "";
		
		System.out.println("+++++++++++++용인 로직 시작");

		try {

			if (yeta1100PayrService == null) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());

				yeta1100PayrService = (Yeta1100PayrService) wac.getBean("Yeta1100PayrService");

			}
			
			System.out.println("+++++++++++++용인 로직 시작2");
			// 선택한 대상자의 수 만큼 대상자를 생성한다.
			for (int iYetaCnt = 0; iYetaCnt < listYetaPrc1000Vo.size(); iYetaCnt++) {

				infcPkgYeta1000Vo = new InfcPkgYeta1000VO();
				infcPkgYeta1000Vo = listYetaPrc1000Vo.get(iYetaCnt);
				
				
				if (yeta100Chk) {
					System.out.println("+++++++++++++용인 로직 시작3");
					// yeta1000 처음에 한 번만 생성해주기 위해.
					yeta100Chk = false;
                	
//                	if (MSFSharedUtils.paramNull(infcPkgYeta1000Vo.getSystemkey()))  { 
                		
   		         
	                	// {마감정보 생성 }
	                	// {**************************마감정보 1********************************} 
                		infcPkgYeta1000Vo.setDpobCd(infcPkgYeta1000Vo.getDpobCd());
	   					infcPkgYeta1000Vo.setEdacRvyy(infcPkgYeta1000Vo.getEdacRvyy());    					/** column 연말정산귀속년도 : edacRvyy */
	   					infcPkgYeta1000Vo.setSettGbcd(infcPkgYeta1000Vo.getSettGbcd());    					/** column 정산구분코드 : settGbcd */
	   					infcPkgYeta1000Vo.setEdacSeilNum(infcPkgYeta1000Vo.getEdacSeilNum());    			/** column 연말정산마감일련번호 : edacSeilNum */
	   					infcPkgYeta1000Vo.setPayrMangDeptCd(infcPkgYeta1000Vo.getSrhPayrMangDeptCd());    	/** column 급여관리부서코드 : payrMangDeptCd */
	   					infcPkgYeta1000Vo.setDeptCd(infcPkgYeta1000Vo.getSrhDeptCd());    					/** column 부서코드 : deptCd */
	   					infcPkgYeta1000Vo.setTypOccuCd(infcPkgYeta1000Vo.getSrhTypOccuCd());    			/** column 직종코드 : typOccuCd */
	   					infcPkgYeta1000Vo.setDtilOccuClsDivCd(infcPkgYeta1000Vo.getSrhDtilOccuClsDivCd());  /** column 직종세구분코드 : dtilOccuClsDivCd */
	   					infcPkgYeta1000Vo.setPyspGrdeCd(infcPkgYeta1000Vo.getPyspGrdeCd());    				/** column 호봉등급코드 : pyspGrdeCd */
	   					infcPkgYeta1000Vo.setDtilOccuInttnCd(infcPkgYeta1000Vo.getSrhDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
	   					infcPkgYeta1000Vo.setBusinCd(infcPkgYeta1000Vo.getSrhBusinCd());    				/** column 사업코드 : businCd */
	   					infcPkgYeta1000Vo.setEmymtDivCd(infcPkgYeta1000Vo.getSrhEmymtDivCd());    			/** column 고용구분코드 : emymtDivCd */
	   					infcPkgYeta1000Vo.setPernChrgEmpIdenNum(sessionUser.getUsrId());    				/** column 생성직원번호 : pernChrgEmpIdenNum infcPkgYeta1000Vo.getPernChrgEmpIdenNum()*/
	   					infcPkgYeta1000Vo.setClosFlag(infcPkgYeta1000Vo.getClosFlag());    					/** column 마감여부 : closFlag */
	   					infcPkgYeta1000Vo.setClosCont(infcPkgYeta1000Vo.getClosCont());    					/** column 마감건수 : closCont */
	   					infcPkgYeta1000Vo.setClosDate(infcPkgYeta1000Vo.getClosDate());    					/** column 마감일자 : closDate */
	   					infcPkgYeta1000Vo.setEdacPrdt(infcPkgYeta1000Vo.getEdacPrdt());    					/** column 연말정산제출일자 : edacPrdt */
	   					infcPkgYeta1000Vo.setReprName(infcPkgYeta1000Vo.getReprName());    					/** column 대표자성명 : reprName */
	   					infcPkgYeta1000Vo.setJuriName(infcPkgYeta1000Vo.getJuriName());    					/** column 법인명_상호 : juriName */
	   					infcPkgYeta1000Vo.setBusiNumb(infcPkgYeta1000Vo.getBusiNumb());    					/** column 사업자등록번호 : busiNumb */
	   					infcPkgYeta1000Vo.setResuNumb(infcPkgYeta1000Vo.getResuNumb());    					/** column 주민등록번호 : resuNumb */
	   					infcPkgYeta1000Vo.setJuriNumb(infcPkgYeta1000Vo.getJuriNumb());    					/** column 법인번호 : juriNumb */
	   					infcPkgYeta1000Vo.setIncmPost(infcPkgYeta1000Vo.getIncmPost());    					/** column 소득신고의무자우편번호 : incmPost */
	   					infcPkgYeta1000Vo.setIncmAddr(infcPkgYeta1000Vo.getIncmAddr());    					/** column 소득신고의무자기본주소 : incmAddr */
	   					infcPkgYeta1000Vo.setIncmAdtl(infcPkgYeta1000Vo.getIncmAdtl());    					/** column 소득신고의무자상세주소 : incmAdtl */
	   					infcPkgYeta1000Vo.setTaxaCode(infcPkgYeta1000Vo.getTaxaCode());    					/** column 관할세무서코드 : taxaCode */
	   					infcPkgYeta1000Vo.setIncmGbcd(infcPkgYeta1000Vo.getIncmGbcd());    					/** column 제출자구분코드 : incmGbcd */
	   					infcPkgYeta1000Vo.setTaxaDnum(infcPkgYeta1000Vo.getTaxaDnum());    					/** column 세무대리인번호 : taxaDnum */
	   					infcPkgYeta1000Vo.setHomeTxid(infcPkgYeta1000Vo.getHomeTxid());    					/** column 홈텍스ID : homeTxid */
	   					infcPkgYeta1000Vo.setTaxaPrcd(infcPkgYeta1000Vo.getTaxaPrcd());    					/** column 세무프로그램코드 : taxaPrcd */
	   					infcPkgYeta1000Vo.setCharDept(infcPkgYeta1000Vo.getCharDept());    					/** column 담당자부서명 : charDept */
	   					infcPkgYeta1000Vo.setCharName(infcPkgYeta1000Vo.getCharName());    					/** column 담당자성명 : charName */
	   					infcPkgYeta1000Vo.setCharTele(infcPkgYeta1000Vo.getCharTele());    					/** column 담당자전화번호 : charTele */
	   					infcPkgYeta1000Vo.setFilePass(infcPkgYeta1000Vo.getFilePass());    					/** column FILE_PASS : filePass */
	   				    infcPkgYeta1000Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	   				    infcPkgYeta1000Vo.setUsrId(sessionUser.getUsrId());  
	   			      
	   				    /******************************** 권한 ************************************************************************/
	   				  //  infcPkgYeta1000Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getSrhDeptCd()).replace(",", ""));  //권한처리를위해 추가  
	   				  //  infcPkgYeta1000Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getSrhDtilOccuInttnCd()).replace(",", ""));  
	   			            
	   				  //  if (infcPkgYeta1000Vo.getSrhPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getSrhDeptCd()))) { 
	   				   // 	infcPkgYeta1000Vo.setDeptCd("");  //부서코드
	   				  //  } 
	   			       
	   					infcPkgYeta1000Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
	   					infcPkgYeta1000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */
	   					infcPkgYeta1000Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
	   					infcPkgYeta1000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 수정주소 : revnAddr */
	   					System.out.println("1. 마감테이블 INSERT 시작 ");
//	   					YetaPrc1000VO creYetaPrc1000Vo = new YetaPrc1000VO();  //마감테이블  
	   					dataCheck = yeta1100PayrService.fnYeta1100_YETA1000_2016_CREATE_Insert(infcPkgYeta1000Vo);   //yeta1000
	   					System.out.println("1. 마감테이블 INSERT 종료 ");
	   					
//                	} 
				}
				
					infcPkgYeta1000Vo.setPayrMangDeptCd(infcPkgYeta1000Vo.getSrhPayrMangDeptCd());    		/** column 급여관리부서코드 : payrMangDeptCd */
					infcPkgYeta1000Vo.setDeptCd(infcPkgYeta1000Vo.getSrhDeptCd());    						/** column 부서코드 : deptCd */
					infcPkgYeta1000Vo.setTypOccuCd(infcPkgYeta1000Vo.getSrhTypOccuCd());    				/** column 직종코드 : typOccuCd */
					infcPkgYeta1000Vo.setDtilOccuClsDivCd(infcPkgYeta1000Vo.getSrhDtilOccuClsDivCd());  	/** column 직종세구분코드 : dtilOccuClsDivCd */
					infcPkgYeta1000Vo.setPyspGrdeCd(infcPkgYeta1000Vo.getPyspGrdeCd());    				/** column 호봉등급코드 : pyspGrdeCd */
					infcPkgYeta1000Vo.setDtilOccuInttnCd(infcPkgYeta1000Vo.getSrhDtilOccuInttnCd());    	/** column 직종세통합코드 : dtilOccuInttnCd */
					infcPkgYeta1000Vo.setBusinCd(infcPkgYeta1000Vo.getSrhBusinCd());    					/** column 사업코드 : businCd */
					infcPkgYeta1000Vo.setEmymtDivCd(infcPkgYeta1000Vo.getSrhEmymtDivCd());    				/** column 고용구분코드 : emymtDivCd */
				    infcPkgYeta1000Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getSrhDeptCd()).replace(",", ""));  //권한처리를위해 추가  
				    infcPkgYeta1000Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getSrhDtilOccuInttnCd()).replace(",", ""));  
			            
				    if (infcPkgYeta1000Vo.getSrhPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getSrhDeptCd()))) { 
				    	infcPkgYeta1000Vo.setDeptCd("");  //부서코드
				    } 
				
	            if (MSFSharedUtils.paramNull(dataCheck)) {
	            	  
	            	tpYetaPrc1000Vo = yeta1100PayrService.selectYeta1100ToCreateYetaPrc1000(infcPkgYeta1000Vo);   //yeta1000
	            	
	            	infcPkgYeta1000Vo.setEdacSeilNum(tpYetaPrc1000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
	            	infcPkgYeta1000Vo.setAddCheck("ADD");   //추가 여부에 따른 기존데이타 스킾처리하는 루틴 추가 
				  	        
	            	if (MSFSharedUtils.paramNotNull(tpYetaPrc1000Vo)) {
//	            		infcPkgYeta1000Vo.setEdacSeilNum(tpYetaPrc1000Vo.getEdacSeilNum());    			/** column 연말정산마감일련번호 : edacSeilNum */
						// {급여내역생성 - YE160401}
						//  {**************************급여내역 생성 2********************************}
	            		infcPkgYe160401Vo.setDpobCd(infcPkgYeta1000Vo.getDpobCd());    						/** column 사업장코드 : dpobCd */
	            		infcPkgYe160401Vo.setYrtxBlggYr(infcPkgYeta1000Vo.getEdacRvyy());    				/** column 귀속연도 : yrtxBlggYr */
	            		infcPkgYe160401Vo.setClutSeptCd(infcPkgYeta1000Vo.getSettGbcd());    				/** column 연말정산구분코드 : clutSeptCd */
	            		infcPkgYe160401Vo.setSystemkey(infcPkgYeta1000Vo.getSystemkey());    				/** column SYSTEMKEY : systemkey */
	            		 
					    //  infcPkgYe160401Vo.setEdacSeilNum(yetaPrc1000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
	            		infcPkgYe160401Vo.setPayrMangDeptCd(infcPkgYeta1000Vo.getSrhPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
	            		infcPkgYe160401Vo.setDeptCd(infcPkgYeta1000Vo.getSrhDeptCd());    /** column 부서코드 : deptCd */
	            		infcPkgYe160401Vo.setTypOccuCd(infcPkgYeta1000Vo.getSrhTypOccuCd());    /** column 직종코드 : typOccuCd */
	            	//	infcPkgYe160401Vo.setDtilOccuClsDivCd(infcPkgYeta1000Vo.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
	            	//	infcPkgYe160401Vo.setPyspGrdeCd(infcPkgYeta1000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
	            		infcPkgYe160401Vo.setDtilOccuInttnCd(infcPkgYeta1000Vo.getSrhDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
	            		infcPkgYe160401Vo.setBusinCd(infcPkgYeta1000Vo.getSrhBusinCd());    /** column 사업코드 : businCd */
	            		infcPkgYe160401Vo.setEmymtDivCd(infcPkgYeta1000Vo.getSrhEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */ 
					          
	            	   	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
//	        	      	SysIfBass0320VO  sysIfBass0320Vo = new SysIfBass0320VO();
//	        	     	 List<String> listTypCd = new ArrayList<String>(); 
//	        	     	 
//	        	     	sysIfBass0320Vo.setYmdGb("Y");
//	        	     	sysIfBass0320Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYr")));
//	        	     	sysIfBass0320Vo.setTypOccuCd(psnl0100SrhVO.getTypOccuCd());
//	        	     	sysIfBass0320Vo.setTypOccuCdArr(lstTypeOccuCd); 
//	        	     	
//	        	     	listTypCd = SysifPkgServiceUtils.funcArrBeforTypOccuCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0320Vo);
	        	     	
	            	   	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getSrhTypOccuCd()));  
	        	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getSrhDtilOccuInttnCd())); 
	        	      	
	        	     	SysIfBass0350VO  sysIfBass0350Vo = new SysIfBass0350VO();
	        	     //	 List<String> listTyInttnCd = new ArrayList<String>(); 
	        	     	sysIfBass0350Vo.setDpobCd(sessionUser.getDpobCd());
	        	     	sysIfBass0350Vo.setYmdGb("Y");
	        	     	sysIfBass0350Vo.setStrDate(infcPkgYeta1000Vo.getEdacRvyy());
	        	     	sysIfBass0350Vo.setTypOccuCd(infcPkgYeta1000Vo.getSrhTypOccuCd());
	        	     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
	        	    	sysIfBass0350Vo.setDtilOccuInttnCd(infcPkgYeta1000Vo.getSrhDtilOccuInttnCd());
	        	     	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        	     	
	        	     	sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(request,sysIfBass0350Vo); 
	        	     
	        	     	infcPkgYe160401Vo.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
	        	     	infcPkgYe160401Vo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
	        	     	
	        	     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
	          
	        	      	
//	            		infcPkgYe160401Vo.setElctYymm(ye160401Dto.getElctYymm());    					/** column 지급년월 : elctYymm */
//	            		infcPkgYe160401Vo.setElctDate(ye160401Dto.getElctDate());    					/** column 급여지급일자 : elctDate */
//	            		infcPkgYe160401Vo.setSuprTxam(ye160401Dto.getSuprTxam());    					/** column 급여지급금액_과세 : suprTxam */
//	            		infcPkgYe160401Vo.setBuamTxam(ye160401Dto.getBuamTxam());    					/** column 현근무지상여금_과세 : buamTxam */
//	            		infcPkgYe160401Vo.setInbsAmnt(ye160401Dto.getInbsAmnt());    					/** column 현근무지인정상여금액 : inbsAmnt */
//	            		infcPkgYe160401Vo.setStckInam(ye160401Dto.getStckInam());    					/** column 현근무지주식매수선택권행사이익금액 : stckInam */
//	            		infcPkgYe160401Vo.setSpbmTxam(ye160401Dto.getSpbmTxam());    					/** column 현근무지과세합계금액 : spbmTxam */
//	            		infcPkgYe160401Vo.setEcinTxam(ye160401Dto.getEcinTxam());    					/** column 외국인소득금액_과세 : ecinTxam */
//	    	         	infcPkgYe160401Vo.setTaxmEcin(ye160401Dto.getTaxmEcin());    					/** column 외국인소득금액_비과세 : taxmEcin */
//	    	         	infcPkgYe160401Vo.setSpciHlth(ye160401Dto.getSpciHlth());    					/** column 현근무지건강보험료금액 : spciHlth */
//	    	         	infcPkgYe160401Vo.setSpciEmpf(ye160401Dto.getSpciEmpf());    					/** column 현근무지고용보험료금액 : spciEmpf */
//	    	         	infcPkgYe160401Vo.setNatnPsnf(ye160401Dto.getNatnPsnf());    					/** column 현근무지국민연금금액 : natnPsnf */
//	    	         	infcPkgYe160401Vo.setEarnTaxn(ye160401Dto.getEarnTaxn());    					/** column 현근무지소득세 : earnTaxn */
//	    	         	infcPkgYe160401Vo.setIhtxTaxn(ye160401Dto.getIhtxTaxn());    					/** column 현근무지지방소득세 : ihtxTaxn */
//	    	         	infcPkgYe160401Vo.setNnksSsum(ye160401Dto.getNnksSsum());    					/** column 현근무지농특세 : nnksSsum */
//	    	         	infcPkgYe160401Vo.setEtccTxam(ye160401Dto.getEtccTxam());    					/** column 현근무지기타금액_과세 : etccTxam */
//	    	         	infcPkgYe160401Vo.setEtccEtam(ye160401Dto.getEtccEtam());    					/** column 현근무지기타금액_비과세 : etccEtam */
//	    	         	infcPkgYe160401Vo.setPayPymtSumTotAmnt(ye160401Dto.getPayPymtSumTotAmnt());    							/** column 급여지급금액총액 : payPymtSumTotAmnt */
//	    	         	infcPkgYe160401Vo.setPayPymtFreeDtySum(ye160401Dto.getPayPymtFreeDtySum());    							/** column 급여지급금액_비과세 : payPymtFreeDtySum */
//	    	         	infcPkgYe160401Vo.setCurrWorkFreeDtusAmnt(ye160401Dto.getCurrWorkFreeDtusAmnt());    					/** column 현근무지상여금_비과세 : currWorkFreeDtusAmnt */
//	    	         	infcPkgYe160401Vo.setCurrWorkEmptkWdrwSum(ye160401Dto.getCurrWorkEmptkWdrwSum());    					/** column 현근무지우리사주조합인출금액 : currWorkEmptkWdrwSum */
//	    	         	infcPkgYe160401Vo.setCurrWorkEcteRetceSum(ye160401Dto.getCurrWorkEcteRetceSum());    					/** column 현근무지임원퇴직소득금액한도초과금액 : currWorkEcteRetceSum */
//	    	         	infcPkgYe160401Vo.setCurrWorkRcpInsurSum(ye160401Dto.getCurrWorkRcpInsurSum());    						/** column 현근무지요양보험료금액 : currWorkRcpInsurSum */
//	    	         	infcPkgYe160401Vo.setCurrWorkRcpAggrSum(ye160401Dto.getCurrWorkRcpAggrSum());    						/** column 현근무지건강요양보험료합계금액 : currWorkRcpAggrSum */
	    	         	infcPkgYe160401Vo.setKybdr(sessionUser.getUsrId());    													/** column 입력자 : kybdr */
	    	         	infcPkgYe160401Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
	    	         	infcPkgYe160401Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
	    	         	infcPkgYe160401Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
	    	         	infcPkgYe160401Vo.setAddCheck("ADD");   //추가 여부에 따른 기존데이타 스킾처리하는 루틴 추가       
						
	    	        	infcPkgYe160401Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	    	         	infcPkgYe160401Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	    	         	infcPkgYe160401Vo.setUsrId(sessionUser.getUsrId());  
						/******************************** 권한 ************************************************************************/
	    	         	infcPkgYe160401Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getSrhDeptCd()).replace(",", ""));  //권한처리를위해 추가  
	    	         	infcPkgYe160401Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getSrhDtilOccuInttnCd()).replace(",", ""));  
						            
						if (infcPkgYeta1000Vo.getSrhPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getSrhDeptCd()))) { 
							infcPkgYe160401Vo.setDeptCd("");  //부서코드
						} 
						System.out.println("2. 급여내역 INSERT 시작 ");
						dataCheck = "";
						//dataCheck = yeta1100PayrService.fnYeta1100_YE160401_2016_CREATE_Insert(infcPkgYe160401Vo);   //infcPkgYe160401Vo  
						dataCheck = yeta1100PayrService.fnYeta1100_YE160401_PAYR_2016_CREATE_Insert(infcPkgYe160401Vo);  
						
						System.out.println("2. 급여내역 INSERT 종료 ");  	    
						bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "급여내역생성.","데이타확인","")); 
						
						// {연말정산기본생성 - YETA2000}
					 	// {**************************연말정산기본생성 [3]********************************}
						if (MSFSharedUtils.paramNull(dataCheck)) {
						  	   
							infcPkgYeta2000Vo.setDpobCd(infcPkgYeta1000Vo.getDpobCd());    					/** column 사업장코드 : dpobCd */
							infcPkgYeta2000Vo.setEdacRvyy(infcPkgYeta1000Vo.getEdacRvyy());    				/** column 연말정산귀속년도 : edacRvyy */
							infcPkgYeta2000Vo.setSettGbcd(infcPkgYeta1000Vo.getSettGbcd());    				/** column 정산구분코드 : settGbcd */
							infcPkgYeta2000Vo.setSystemkey(infcPkgYeta1000Vo.getSystemkey());    			/** column SYSTEMKEY : systemkey */
							infcPkgYeta2000Vo.setEdacSeilNum(tpYetaPrc1000Vo.getEdacSeilNum());    		/** column 연말정산마감일련번호 : edacSeilNum */
							infcPkgYeta2000Vo.setPayrMangDeptCd(infcPkgYeta1000Vo.getSrhPayrMangDeptCd());    	/** column 급여관리부서코드 : payrMangDeptCd */
							infcPkgYeta2000Vo.setEmymtDivCd(infcPkgYeta1000Vo.getSrhEmymtDivCd());    			/** column 고용구분코드 : emymtDivCd */
							//infcPkgYeta2000Vo.setHanNm(infcPkgYeta1000Vo.getHanNm());    /** column 한글성명 : hanNm */
							//infcPkgYeta2000Vo.setResnRegnNum(infcPkgYeta1000Vo.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
							infcPkgYeta2000Vo.setDeptCd(infcPkgYeta1000Vo.getSrhDeptCd());    					/** column 부서코드 : deptCd */
							infcPkgYeta2000Vo.setBusinCd(infcPkgYeta1000Vo.getSrhBusinCd());    				/** column 사업코드 : businCd */
							infcPkgYeta2000Vo.setTypOccuCd(infcPkgYeta1000Vo.getSrhTypOccuCd());    			/** column 직종코드 : typOccuCd */
							infcPkgYeta2000Vo.setDtilOccuInttnCd(infcPkgYeta1000Vo.getSrhDtilOccuInttnCd());	/** column 직종세통합코드 : dtilOccuInttnCd */
							infcPkgYeta2000Vo.setDtilOccuClsDivCd(infcPkgYeta1000Vo.getSrhDtilOccuClsDivCd());	/** column 직종세구분코드 : dtilOccuClsDivCd */
							//infcPkgYeta2000Vo.setOdtyCd(infcPkgYeta1000Vo.getOdtyCd());    /** column 직책코드 : odtyCd */
							//infcPkgYeta2000Vo.setPyspCd(infcPkgYeta1000Vo.getPyspCd());    /** column 호봉코드 : pyspCd */
							infcPkgYeta2000Vo.setPyspGrdeCd(infcPkgYeta1000Vo.getPyspGrdeCd());    			/** column 호봉등급코드 : pyspGrdeCd */
							infcPkgYeta2000Vo.setAddCheck("ADD");   //추가 여부에 따른 기존데이타 스킾처리하는 루틴 추가  			
							infcPkgYeta2000Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  	//단위기관담당자여부 
							infcPkgYeta2000Vo.setUsrId(sessionUser.getUsrId());  
									              
							

							infcPkgYeta2000Vo.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
							infcPkgYeta2000Vo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
		        	     	
							/******************************** 권한 ************************************************************************/
									              
							infcPkgYeta2000Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getSrhDeptCd()).replace(",", ""));  //권한처리를위해 추가  
							infcPkgYeta2000Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getSrhDtilOccuInttnCd()).replace(",", ""));  
									        
							if (infcPkgYeta1000Vo.getSrhPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getSrhDeptCd()))) { 
								infcPkgYeta2000Vo.setDeptCd("");  //부서코드
							} 
									        
							infcPkgYeta2000Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
							infcPkgYeta2000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */
							infcPkgYeta2000Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
							infcPkgYeta2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 수정주소 : revnAddr */ 
							dataCheck = "";
							System.out.println("3. 연말정산기본 INSERT 시작 ");
							dataCheck = yeta1100PayrService.fnYeta1100_YETA2000_2016_CREATE_Insert(infcPkgYeta2000Vo);   //infcPkgYeta2000Vo 
							bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "연말정산기본정보생성.","데이타확인","")); 
							System.out.println("3. 연말정산기본 INSERT 종료 ");
							// {비과세, 과세 감면 인서트 }
							// {**************************연말정산기본 비과세, 과세 감면 생성  [4]********************************} 
											  	        
							if (MSFSharedUtils.paramNull(dataCheck)) {
								System.out.println("4-1. 과세 INSERT 시작 ");
								// 과세
								dataCheck = "";
								dataCheck =  yeta1100PayrService.fnYeta1100_YE160402_2016_CREATE_Insert(infcPkgYeta2000Vo);   
								bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "과세감면 생성.","데이타확인","")); 
								System.out.println("4-1. 과세 INSERT 종료 ");
								
								
								
								System.out.println("4-2. 비과세 INSERT 시작 ");
								// 비과세
//								if (MSFSharedUtils.paramNull(dataCheck)) {
								dataCheck = "";
								dataCheck =  yeta1100PayrService.fnYeta1100_YE160403_2016_CREATE_Insert(infcPkgYeta2000Vo);   
								bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "비과세감면 생성.","데이타확인",""));
//								}
								System.out.println("4-2. 비과세 INSERT 종료 ");
								
								if (MSFSharedUtils.paramNull(dataCheck)) {	
									System.out.println("5. 가족사항 INSERT 시작 ");
									// 	{가족사항 인서트 YETA3220 }
									//	{**************************가족사항 [5]********************************}
									dataCheck = "";
									dataCheck = yeta1100PayrService.fnYeta1100_YETA3220_2016_CREATE_Insert(infcPkgYeta2000Vo);   //infcPkgYeta3220Vo   
									bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "가족사항 생성.","데이타확인","")); 
									System.out.println("5. 가족사항 INSERT 종료 ");
									if (MSFSharedUtils.paramNull(dataCheck)) {       
										// {가족사항 업데이트 YETA3220 고용/건강보험료외 업데이트  }
										// {**************************가족사항 [5_1]********************************}
										//2014년 고용건강보험료외 업데이트
										System.out.println("5-1. 고용건강보험료외 UPDATE 시작 ");
										yeta1100PayrService.fnYeta1100_YETA3220_2016_INSU_FETC_Update(infcPkgYeta2000Vo);   //infcPkgYeta3220Vo   
										bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "가족사항 생성.","데이타확인",""));
										System.out.println("5-2. 고용건강보험료외 UPDATE 종료 ");	  	       
										// {**************************부녀자공제 [6]********************************}
										// {부녀자공제란 여성근로소득자 본인인경우 업데이트 처리 }/
										System.out.println("6. 부녀자공제 UPDATE 시작 ");
										yeta1100PayrService.fnYeta1100_YETA3220_2016_CREATE_Update(infcPkgYeta2000Vo);   //infcPkgYeta3220Vo   
										bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "가족사항 수정.","데이타확인",""));
										System.out.println("6. 부녀자공제 UPDATE 종료 ");          
										//	{**************************이월기부금  [7]********************************}
										//	{이월기부금  YETA3190 인서트 }
										if (MSFSharedUtils.paramNull(dataCheck)) {
											dataCheck = "";
											System.out.println("7. 이월기부금 INSERT 시작 ");
											dataCheck =    yeta1100PayrService.fnYeta1100_YETA3190_2016_CREATE_Insert(infcPkgYeta2000Vo);   //infcPkgYeta3190Vo   
											bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "이월기부금 생성.","데이타확인",""));
											System.out.println("7. 이월기부금 INSERT 종료");
										//	{**************************연말정산상세  [8]********************************}
										// 	{연말정산상세 YETA3000 인서트 } 
										if (MSFSharedUtils.paramNull(dataCheck)) {
											dataCheck = "";
											System.out.println("8. 연말정산 상세 INSERT 시작 ");
											dataCheck =    yeta1100PayrService.fnYeta1100_YETA3000_2016_CREATE_Insert(infcPkgYeta2000Vo);   //infcPkgYeta3000Vo   
											bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "연말정산 정산일부.","데이타확인",""));
											System.out.println("8. 연말정산 상세 INSERT 종료 ");
											}
										}
									}
								}
							}
						}
					}
				}
	            
			}

			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "대상자 생성이 완료되었습니다.","데이타확인",""));  
		  	        
		} catch (Exception ex) {
			ex.printStackTrace();
			ShowMessageBM smBm = new ShowMessageBM();
			smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
			smBm.setMenu("Yeta");
			smBm.setPhase("[연말정산대상자]대상자생성에러");
			smBm.setMessage(ex.getLocalizedMessage());
			smBm.setContent(ex.getMessage());
			bmResult.add(smBm);
			retval = new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());

		}

		return retval;
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
	public PagingLoadResult<ShowMessageBM> execPayrToYeta_2016_Insert(HttpServletRequest request, List<InfcPkgYeta2000VO> lstYeta2000Vo)throws Exception {

		return funcPayrToYeta_2016_Insert(request, lstYeta2000Vo);
	}  
    
	private PagingLoadResult<ShowMessageBM> funcPayrToYeta_2016_Insert(HttpServletRequest request,List<InfcPkgYeta2000VO>  lstYeta2000Vo)  throws Exception  {
	    	
		PagingLoadResult<ShowMessageBM> retval = null;
		List<ShowMessageBM> bmResult = new ArrayList<ShowMessageBM>();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		  	  
		InfcPkgYe160401VO infcPkgYe160401Vo = new InfcPkgYe160401VO(); 		// 현근무지 급여지급 명세
//		InfcPkgYeta3300VO yetaPrc3300Vo = new InfcPkgYeta3300VO(); 		// 비과세감면소득정산
		InfcPkgYe160402VO infcPkgYe160402Vo = new InfcPkgYe160402VO(); 		// 과세감면소득정산  
		InfcPkgYe160403VO infcPkgYe160403Vo = new InfcPkgYe160403VO(); 		// 비과세감면소득정산 
		  	
		try { 
		  		   
			if  (yeta1100PayrService == null) { 
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( request.getSession().getServletContext());
				yeta1100PayrService = (Yeta1100PayrService) wac.getBean("Yeta1100PayrService"); 
		              
			}
			  	   
			  	  
			/************************* 대상자별로 루프 시작 ***************************************************/ 
			for (int iCnt01 = 0; iCnt01 < lstYeta2000Vo.size(); iCnt01++) {

				InfcPkgYeta2000VO infcPkgYeta2000Vo = new InfcPkgYeta2000VO();
				infcPkgYeta2000Vo = lstYeta2000Vo.get(iCnt01);
		  		
		  		 
				//{******************************급여자료 이관 [2]*******************************************}
				// {급여내역이관 - ye160401}
				infcPkgYe160401Vo.setDpobCd(infcPkgYeta2000Vo.getDpobCd());    			/** column 사업장코드 : dpobCd */
		  		infcPkgYe160401Vo.setYrtxBlggYr(infcPkgYeta2000Vo.getEdacRvyy());    	/** column 귀속연도 : yrtxBlggYr */
		  		infcPkgYe160401Vo.setClutSeptCd(infcPkgYeta2000Vo.getSettGbcd());    	/** column 연말정산구분코드 : clutSeptCd */
		  		infcPkgYe160401Vo.setSystemkey(infcPkgYeta2000Vo.getSystemkey());    	/** column SYSTEMKEY : systemkey */
		  		
		  		
		  		infcPkgYe160401Vo.setPayrMangDeptCd(infcPkgYe160401Vo.getPayrMangDeptCd());    			/** column 급여관리부서코드 : payrMangDeptCd */
		  		infcPkgYe160401Vo.setDeptCd(infcPkgYe160401Vo.getDeptCd());    							/** column 부서코드 : deptCd */
		  		infcPkgYe160401Vo.setTypOccuCd(infcPkgYe160401Vo.getTypOccuCd());    					/** column 직종코드 : typOccuCd */
//		  		infcPkgYe160401Vo.setDtilOccuInttnCd(infcPkgYe160401Vo.getDtilOccuInttnCd());   		/** column 직종세통합코드 : dtilOccuInttnCd */
//		  		infcPkgYe160401Vo.setPyspGrdeCd(infcPkgYe160401Vo.getPyspGrdeCd());   				 	/** column 호봉등급코드 : pyspGrdeCd */
		        infcPkgYe160401Vo.setDtilOccuInttnCd(infcPkgYe160401Vo.getDtilOccuInttnCd());    		/** column 직종세통합코드 : dtilOccuInttnCd */
		        infcPkgYe160401Vo.setBusinCd(infcPkgYe160401Vo.getBusinCd());    						/** column 사업코드 : businCd */
		        infcPkgYe160401Vo.setEmymtDivCd(infcPkgYe160401Vo.getEmymtDivCd());    					/** column 고용구분코드 : emymtDivCd */ 
		        
		        infcPkgYe160401Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
		        infcPkgYe160401Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
		        infcPkgYe160401Vo.setUsrId(sessionUser.getUsrId());  
		              
		            
		         
        	   	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
 
        	   	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(infcPkgYe160401Vo.getTypOccuCd()));  
    	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(infcPkgYe160401Vo.getDtilOccuInttnCd())); 
    	      	
    	     	SysIfBass0350VO  sysIfBass0350Vo = new SysIfBass0350VO();
    	     //	 List<String> listTyInttnCd = new ArrayList<String>(); 
    	     	sysIfBass0350Vo.setDpobCd(sessionUser.getDpobCd());
    	     	sysIfBass0350Vo.setYmdGb("Y");
    	     	sysIfBass0350Vo.setStrDate(infcPkgYeta2000Vo.getEdacRvyy());
    	     	sysIfBass0350Vo.setTypOccuCd(infcPkgYe160401Vo.getTypOccuCd());
    	     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
    	    	sysIfBass0350Vo.setDtilOccuInttnCd(infcPkgYe160401Vo.getDtilOccuInttnCd());
    	     	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
    	     	
    	     	sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(request,sysIfBass0350Vo); 
    	     
    	     	infcPkgYe160401Vo.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
    	     	infcPkgYe160401Vo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
    	     	
    	     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
      
    	     	
		       /******************************** 권한 ************************************************************************/
		              
		        infcPkgYe160401Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(infcPkgYe160401Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
		        infcPkgYe160401Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(infcPkgYe160401Vo.getDtilOccuInttnCd()).replace(",", ""));  
		            
		        if (infcPkgYe160401Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(infcPkgYe160401Vo.getDeptCd()))) { 
		        	infcPkgYe160401Vo.setDeptCd("");  //부서코드
               } 		  		
		  		
		  		
//		  		infcPkgYe160401Vo.setElctYymm(infcPkgYe160401Vo.getElctYymm());    	/** column 지급년월 : elctYymm */
//		  		infcPkgYe160401Vo.setElctDate(ye160401Vo.getElctDate());    /** column 급여지급일자 : elctDate */
//		  		infcPkgYe160401Vo.setSuprTxam(ye160401Vo.getSuprTxam());    /** column 급여지급금액_과세 : suprTxam */
//		  		infcPkgYe160401Vo.setBuamTxam(ye160401Vo.getBuamTxam());    /** column 현근무지상여금_과세 : buamTxam */
//		  		ye160401Vo.setInbsAmnt(ye160401Vo.getInbsAmnt());    /** column 현근무지인정상여금액 : inbsAmnt */
//		  		ye160401Vo.setStckInam(ye160401Vo.getStckInam());    /** column 현근무지주식매수선택권행사이익금액 : stckInam */
//		  		ye160401Vo.setSpbmTxam(ye160401Vo.getSpbmTxam());    /** column 현근무지과세합계금액 : spbmTxam */
//		  		ye160401Vo.setEcinTxam(ye160401Vo.getEcinTxam());    /** column 외국인소득금액_과세 : ecinTxam */
//		  		ye160401Vo.setTaxmEcin(ye160401Vo.getTaxmEcin());    /** column 외국인소득금액_비과세 : taxmEcin */
//		  		ye160401Vo.setSpciHlth(ye160401Vo.getSpciHlth());    /** column 현근무지건강보험료금액 : spciHlth */
//		  		ye160401Vo.setSpciEmpf(ye160401Vo.getSpciEmpf());    /** column 현근무지고용보험료금액 : spciEmpf */
//		  		ye160401Vo.setNatnPsnf(ye160401Vo.getNatnPsnf());    /** column 현근무지국민연금금액 : natnPsnf */
//		  		ye160401Vo.setEarnTaxn(ye160401Vo.getEarnTaxn());    /** column 현근무지소득세 : earnTaxn */
//		  		ye160401Vo.setIhtxTaxn(ye160401Vo.getIhtxTaxn());    /** column 현근무지지방소득세 : ihtxTaxn */
//		  		ye160401Vo.setNnksSsum(ye160401Vo.getNnksSsum());    /** column 현근무지농특세 : nnksSsum */
//		  		ye160401Vo.setEtccTxam(ye160401Vo.getEtccTxam());    /** column 현근무지기타금액_과세 : etccTxam */
//		  		ye160401Vo.setEtccEtam(ye160401Vo.getEtccEtam());    /** column 현근무지기타금액_비과세 : etccEtam */
//		  		ye160401Vo.setPayPymtSumTotAmnt(ye160401Vo.getPayPymtSumTotAmnt());    /** column 급여지급금액총액 : payPymtSumTotAmnt */
//		  		ye160401Vo.setPayPymtFreeDtySum(ye160401Vo.getPayPymtFreeDtySum());    /** column 급여지급금액_비과세 : payPymtFreeDtySum */
//		  		ye160401Vo.setCurrWorkFreeDtusAmnt(ye160401Vo.getCurrWorkFreeDtusAmnt());    /** column 현근무지상여금_비과세 : currWorkFreeDtusAmnt */
//		  		ye160401Vo.setCurrWorkEmptkWdrwSum(ye160401Vo.getCurrWorkEmptkWdrwSum());    /** column 현근무지우리사주조합인출금액 : currWorkEmptkWdrwSum */
//		  		ye160401Vo.setCurrWorkEcteRetceSum(ye160401Vo.getCurrWorkEcteRetceSum());    /** column 현근무지임원퇴직소득금액한도초과금액 : currWorkEcteRetceSum */
//		  		ye160401Vo.setCurrWorkRcpInsurSum(ye160401Vo.getCurrWorkRcpInsurSum());    /** column 현근무지요양보험료금액 : currWorkRcpInsurSum */
//		  		ye160401Vo.setCurrWorkRcpAggrSum(ye160401Vo.getCurrWorkRcpAggrSum());    /** column 현근무지건강요양보험료합계금액 : currWorkRcpAggrSum */
		  		
		  		infcPkgYe160401Vo.setKybdr(sessionUser.getUsrId());    											/** column 입력자 : kybdr */
		  		infcPkgYe160401Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */
		  		infcPkgYe160401Vo.setIsmt(sessionUser.getUsrId());    											/** column 수정자 : ismt */
		  		infcPkgYe160401Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 수정주소 : revnAddr */
			  	        
		  		yeta1100PayrService.fnYeta1100_YE160401_PAYR_2016_CREATE_Insert(infcPkgYe160401Vo);   //yetaPrc3210Vo  
//		         
		  	// {******************************급여자료 이관 - 연말정산 기본 업데이트   [3]*******************************************}
		  		yeta1100PayrService.fnYeta1100_YETA2000_PAYR_2016_CREATE_Update(infcPkgYe160401Vo);   //yetaPrc3210Vo  
		  		 
		  		
		  		//{과세 감면 인서트 }
		  		//{**************************연말정산기본 과세 감면 인서트   [4-1]********************************} 
		  		
		  		infcPkgYe160402Vo = new InfcPkgYe160402VO(); // 과세감면소득
		  		infcPkgYe160402Vo.setDpobCd(infcPkgYe160401Vo.getDpobCd());    									/** column 사업장코드 : dpobCd */
		  		infcPkgYe160402Vo.setYrtxBlggYr(infcPkgYe160401Vo.getYrtxBlggYr());    							/** column 귀속연도 : yrtxBlggYr */
		  		infcPkgYe160402Vo.setClutSeptCd(infcPkgYe160401Vo.getClutSeptCd());    							/** column 연말정산구분코드 : clutSeptCd */
		  		infcPkgYe160402Vo.setSystemkey(infcPkgYe160401Vo.getSystemkey());    							/** column SYSTEMKEY : systemkey */
		  		
		  		infcPkgYe160402Vo.setPayrMangDeptCd(infcPkgYe160401Vo.getPayrMangDeptCd());    					/** column 급여관리부서코드 : payrMangDeptCd */
		  		infcPkgYe160402Vo.setDeptCd(infcPkgYe160401Vo.getDeptCd());    									/** column 부서코드 : deptCd */
		  		infcPkgYe160402Vo.setTypOccuCd(infcPkgYe160401Vo.getTypOccuCd());    							/** column 직종코드 : typOccuCd */
//		  		infcPkgYe160401Vo.setDtilOccuInttnCd(infcPkgYe160401Vo.getDtilOccuInttnCd());   		/** column 직종세통합코드 : dtilOccuInttnCd */
//		  		infcPkgYe160401Vo.setPyspGrdeCd(infcPkgYe160401Vo.getPyspGrdeCd());   				 	/** column 호봉등급코드 : pyspGrdeCd */
		  		infcPkgYe160402Vo.setDtilOccuInttnCd(infcPkgYe160401Vo.getDtilOccuInttnCd());    				/** column 직종세통합코드 : dtilOccuInttnCd */
		  		infcPkgYe160402Vo.setBusinCd(infcPkgYe160401Vo.getBusinCd());    								/** column 사업코드 : businCd */
		  		infcPkgYe160402Vo.setEmymtDivCd(infcPkgYe160401Vo.getEmymtDivCd());    							/** column 고용구분코드 : emymtDivCd */ 
		        
		  		infcPkgYe160402Vo.setDpobCd(sessionUser.getDpobCd());  					//사업장코드
		  		infcPkgYe160402Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  	//단위기관담당자여부 
		  		infcPkgYe160402Vo.setUsrId(sessionUser.getUsrId());  
		              
		  		infcPkgYe160402Vo.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
		  		infcPkgYe160402Vo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());
		            
		       /******************************** 권한 ************************************************************************/
		              
		  		infcPkgYe160402Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(infcPkgYe160401Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
		  		infcPkgYe160402Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(infcPkgYe160401Vo.getDtilOccuInttnCd()).replace(",", ""));  
		            
		        if (infcPkgYe160402Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(infcPkgYe160401Vo.getDeptCd()))) { 
		        	infcPkgYe160402Vo.setDeptCd("");  //부서코드
               } 	
		  		
		  		infcPkgYe160402Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
		  		infcPkgYe160402Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */
		  		infcPkgYe160402Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
		  		infcPkgYe160402Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 수정주소 : revnAddr */
		  		
		  		yeta1100PayrService.fnYeta1100_YE160402_PAYR_2016_CREATE_Insert(infcPkgYe160402Vo);   //infcPkgYe160402Vo 
		  		
		  		
		  		
		  		//{비과세 감면 인서트 }
		  		//{**************************연말정산기본 비과세 감면 인서트   [4-2]********************************} 
		  		
		  		infcPkgYe160403Vo = new InfcPkgYe160403VO(); // 비과세 감면소득
		  		infcPkgYe160403Vo.setDpobCd(infcPkgYe160401Vo.getDpobCd());    									/** column 사업장코드 : dpobCd */
		  		infcPkgYe160403Vo.setYrtxBlggYr(infcPkgYe160401Vo.getYrtxBlggYr());    							/** column 귀속연도 : yrtxBlggYr */
		  		infcPkgYe160403Vo.setClutSeptCd(infcPkgYe160401Vo.getClutSeptCd());    							/** column 연말정산구분코드 : clutSeptCd */
		  		infcPkgYe160403Vo.setSystemkey(infcPkgYe160401Vo.getSystemkey());    							/** column SYSTEMKEY : systemkey */
		  		
		  		infcPkgYe160403Vo.setPayrMangDeptCd(infcPkgYe160401Vo.getPayrMangDeptCd());    					/** column 급여관리부서코드 : payrMangDeptCd */
		  		infcPkgYe160403Vo.setDeptCd(infcPkgYe160401Vo.getDeptCd());    									/** column 부서코드 : deptCd */
		  		infcPkgYe160403Vo.setTypOccuCd(infcPkgYe160401Vo.getTypOccuCd());    							/** column 직종코드 : typOccuCd */
//		  		infcPkgYe160401Vo.setDtilOccuInttnCd(infcPkgYe160401Vo.getDtilOccuInttnCd());   		/** column 직종세통합코드 : dtilOccuInttnCd */
//		  		infcPkgYe160401Vo.setPyspGrdeCd(infcPkgYe160401Vo.getPyspGrdeCd());   				 	/** column 호봉등급코드 : pyspGrdeCd */
		  		infcPkgYe160403Vo.setDtilOccuInttnCd(infcPkgYe160401Vo.getDtilOccuInttnCd());    				/** column 직종세통합코드 : dtilOccuInttnCd */
		  		infcPkgYe160403Vo.setBusinCd(infcPkgYe160401Vo.getBusinCd());    								/** column 사업코드 : businCd */
		  		infcPkgYe160403Vo.setEmymtDivCd(infcPkgYe160401Vo.getEmymtDivCd());    							/** column 고용구분코드 : emymtDivCd */ 
		        
		  		infcPkgYe160403Vo.setDpobCd(sessionUser.getDpobCd());  					//사업장코드
		  		infcPkgYe160403Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  	//단위기관담당자여부 
		  		infcPkgYe160403Vo.setUsrId(sessionUser.getUsrId());  
		  		/******************************** 권한 ************************************************************************/
		              

		  		infcPkgYe160403Vo.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
		  		infcPkgYe160403Vo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());
		            
		  		
		  		infcPkgYe160402Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(infcPkgYe160401Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
		  		infcPkgYe160402Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(infcPkgYe160401Vo.getDtilOccuInttnCd()).replace(",", ""));  
		            
		        if (infcPkgYe160402Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(infcPkgYe160401Vo.getDeptCd()))) { 
		        	infcPkgYe160402Vo.setDeptCd("");  //부서코드
		        } 	
		  		infcPkgYe160403Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
		  		infcPkgYe160403Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */
		  		infcPkgYe160403Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
		  		infcPkgYe160403Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 수정주소 : revnAddr */
		  		
		  		yeta1100PayrService.fnYeta1100_YE160403_PAYR_2016_CREATE_Insert(infcPkgYe160403Vo);   //yetaPrc3200Vo 
		         
		  		
		  		
		  		// {******************************급여자료 이관 - 연말정산상세 YETA3000 업데이트   [5]*******************************************}
		  		// YETA3000 업데이트
		  		yeta1100PayrService.fnYeta1100_YETA3000_PAYR_2016_CREATE_Update(infcPkgYe160401Vo);   //yetaPrc3210Vo 
				    
		  	   	}  
			/************************* 대상자별로 루프 종료 ***************************************************/        
		} catch (Exception ex) {
			ex.printStackTrace();
			ShowMessageBM smBm = new ShowMessageBM();
			smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
			smBm.setMenu("Yeta");
			smBm.setPhase("[연말정산 급여이관]대상자급여이관에러");
			smBm.setMessage(ex.getLocalizedMessage());
			smBm.setContent(ex.getMessage());
			bmResult.add(smBm);
			retval = new BasePagingLoadResult<ShowMessageBM>(bmResult, 0,bmResult.size());
		}

		return retval;
	}    
 
//    public PagingLoadResult<ShowMessageBM> execYetaPayr06420_All_Create(HttpServletRequest request,InfcPkgYeta1000VO infcPkgYeta1000Vo)  throws Exception  {
//  	    
//	  	  return  funcYetaPayr06420_All_Create(request,  infcPkgYeta1000Vo);
//	}
//    
//    public PagingLoadResult<ShowMessageBM> execYetaPayr06420_All_Add_Create(HttpServletRequest request,InfcPkgYeta1000VO infcPkgYeta1000Vo)  throws Exception  {
//  	    
//	  	  return  funcYetaPayr06420_All_Add_Create(request,  infcPkgYeta1000Vo);
//	}
//    
//    
//    public PagingLoadResult<ShowMessageBM> execPayrToYeta_Insert(HttpServletRequest request,List<InfcPkgYeta2000VO>  lstInfcPkgYeta2000Vo)  throws Exception  {
//  	    
//	  	  return  funcPayrToYeta_Insert(request,  lstInfcPkgYeta2000Vo);
//	}
      
//   /**
//    * 
//    * <pre>
//    * 1. 개요 : yeta0100 연말정산 대상자 생성  
//    * 2. 처리내용 : 
//    * </pre>
//    * @Method Name : funcYetaPayr06420_All_Create
//    * @date : Jan 26, 2016
//    * @author : leeheuisung
//    * @history : 
//    *	-----------------------------------------------------------------------
//    *	변경일				작성자						변경내용  
//    *	----------- ------------------- ---------------------------------------
//    *	Jan 26, 2016		leeheuisung				최초 작성 
//    *	-----------------------------------------------------------------------
//    * YetaPayr06420_Al_Add_Create
//    * @param request
//    * @param infcPkgYeta1000Vo
//    * @return
//    * @throws Exception
//    */
//    private PagingLoadResult<ShowMessageBM> funcYetaPayr06420_All_Create(HttpServletRequest request,InfcPkgYeta1000VO infcPkgYeta1000Vo)  throws Exception  {
//    	
//    	  PagingLoadResult<ShowMessageBM> retval = null; 
//	      List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
//	  	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//	  	  
//	 	InfcPkgYeta1000VO tpInfcPkgYeta1000Vo = new InfcPkgYeta1000VO();  //마감테이블   
//        InfcPkgYeta3120VO infcPkgYeta3120Vo = new InfcPkgYeta3120VO();  //거주자주택자금_금전소비대차  
//        InfcPkgYeta3160VO infcPkgYeta3160Vo = new InfcPkgYeta3160VO();  //거주자주택자금_임대차  
//        InfcPkgYeta3100VO infcPkgYeta3100Vo = new InfcPkgYeta3100VO();  //연금_저축공제
//        InfcPkgYeta3130VO infcPkgYeta3130Vo = new InfcPkgYeta3130VO();  //주택자금_월세
//        InfcPkgYeta3140VO infcPkgYeta3140Vo = new InfcPkgYeta3140VO();  //의료비
//  	    InfcPkgYeta3180VO infcPkgYeta3180Vo = new InfcPkgYeta3180VO();  //기부금 명세 
//  	    InfcPkgYeta3170VO infcPkgYeta3170Vo = new InfcPkgYeta3170VO();  //이월기부금명세
//  	    InfcPkgYeta3190VO infcPkgYeta3190Vo = new InfcPkgYeta3190VO();  //이월기부금temp
//  	    InfcPkgYeta3110VO infcPkgYeta3110Vo = new InfcPkgYeta3110VO();  //종전근무지명세 
//  	    InfcPkgYeta3200VO infcPkgYeta3200Vo = new InfcPkgYeta3200VO();  //비과세감면소득  
//  	    InfcPkgYeta3220VO infcPkgYeta3220Vo = new InfcPkgYeta3220VO();  //가족사항  
//  	    InfcPkgYeta3150VO infcPkgYeta3150Vo = new InfcPkgYeta3150VO();  //교육비
//  	    InfcPkgYeta3210VO infcPkgYeta3210Vo = new InfcPkgYeta3210VO();  //급여내역
//  	    InfcPkgYeta3300VO yetaPrc3300Vo = new InfcPkgYeta3300VO();  //비과세감면소득정산  
//  	    InfcPkgYeta3000VO infcPkgYeta3000Vo = new InfcPkgYeta3000VO();  //연말정산결과  
//        InfcPkgYeta2000VO infcPkgYeta2000Vo = new InfcPkgYeta2000VO();  //연말정산기본  
//        
//         String dataCheck = "";
//        
//	  	  try { 
//	  		   
//		  	   if  (yeta1100PayrService == null) { 
//	               WebApplicationContext wac = WebApplicationContextUtils.
//	                       getRequiredWebApplicationContext( request.getSession().getServletContext());
//	   
//	               yeta1100PayrService = (Yeta1100PayrService) wac.getBean("YetaPayr6420CreateService"); 
//	              
//	            }
//		  	   
//		  	 
//		        if (MSFSharedUtils.paramNull(infcPkgYeta1000Vo.getSystemkey()))  { 
//		         
//		           // {마감정보 생성 }
//
//		           //   {**************************마감정보 1********************************} 
//
//					infcPkgYeta1000Vo.setEdacRvyy(infcPkgYeta1000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
//					infcPkgYeta1000Vo.setSettGbcd(infcPkgYeta1000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
//					infcPkgYeta1000Vo.setEdacSeilNum(infcPkgYeta1000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
//					infcPkgYeta1000Vo.setPayrMangDeptCd(infcPkgYeta1000Vo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
//					infcPkgYeta1000Vo.setDeptCd(infcPkgYeta1000Vo.getDeptCd());    /** column 부서코드 : deptCd */
//					infcPkgYeta1000Vo.setTypOccuCd(infcPkgYeta1000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//					infcPkgYeta1000Vo.setDtilOccuClsDivCd(infcPkgYeta1000Vo.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
//					infcPkgYeta1000Vo.setPyspGrdeCd(infcPkgYeta1000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
//					infcPkgYeta1000Vo.setDtilOccuInttnCd(infcPkgYeta1000Vo.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
//					infcPkgYeta1000Vo.setBusinCd(infcPkgYeta1000Vo.getBusinCd());    /** column 사업코드 : businCd */
//					infcPkgYeta1000Vo.setEmymtDivCd(infcPkgYeta1000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
//					infcPkgYeta1000Vo.setPernChrgEmpIdenNum(sessionUser.getUsrId());    /** column 생성직원번호 : pernChrgEmpIdenNum infcPkgYeta1000Vo.getPernChrgEmpIdenNum()*/
//					infcPkgYeta1000Vo.setClosFlag(infcPkgYeta1000Vo.getClosFlag());    /** column 마감여부 : closFlag */
//					infcPkgYeta1000Vo.setClosCont(infcPkgYeta1000Vo.getClosCont());    /** column 마감건수 : closCont */
//					infcPkgYeta1000Vo.setClosDate(infcPkgYeta1000Vo.getClosDate());    /** column 마감일자 : closDate */
//					infcPkgYeta1000Vo.setEdacPrdt(infcPkgYeta1000Vo.getEdacPrdt());    /** column 연말정산제출일자 : edacPrdt */
//					infcPkgYeta1000Vo.setReprName(infcPkgYeta1000Vo.getReprName());    /** column 대표자성명 : reprName */
//					infcPkgYeta1000Vo.setJuriName(infcPkgYeta1000Vo.getJuriName());    /** column 법인명_상호 : juriName */
//					infcPkgYeta1000Vo.setBusiNumb(infcPkgYeta1000Vo.getBusiNumb());    /** column 사업자등록번호 : busiNumb */
//					infcPkgYeta1000Vo.setResuNumb(infcPkgYeta1000Vo.getResuNumb());    /** column 주민등록번호 : resuNumb */
//					infcPkgYeta1000Vo.setJuriNumb(infcPkgYeta1000Vo.getJuriNumb());    /** column 법인번호 : juriNumb */
//					infcPkgYeta1000Vo.setIncmPost(infcPkgYeta1000Vo.getIncmPost());    /** column 소득신고의무자우편번호 : incmPost */
//					infcPkgYeta1000Vo.setIncmAddr(infcPkgYeta1000Vo.getIncmAddr());    /** column 소득신고의무자기본주소 : incmAddr */
//					infcPkgYeta1000Vo.setIncmAdtl(infcPkgYeta1000Vo.getIncmAdtl());    /** column 소득신고의무자상세주소 : incmAdtl */
//					infcPkgYeta1000Vo.setTaxaCode(infcPkgYeta1000Vo.getTaxaCode());    /** column 관할세무서코드 : taxaCode */
//					infcPkgYeta1000Vo.setIncmGbcd(infcPkgYeta1000Vo.getIncmGbcd());    /** column 제출자구분코드 : incmGbcd */
//					infcPkgYeta1000Vo.setTaxaDnum(infcPkgYeta1000Vo.getTaxaDnum());    /** column 세무대리인번호 : taxaDnum */
//					infcPkgYeta1000Vo.setHomeTxid(infcPkgYeta1000Vo.getHomeTxid());    /** column 홈텍스ID : homeTxid */
//					infcPkgYeta1000Vo.setTaxaPrcd(infcPkgYeta1000Vo.getTaxaPrcd());    /** column 세무프로그램코드 : taxaPrcd */
//					infcPkgYeta1000Vo.setCharDept(infcPkgYeta1000Vo.getCharDept());    /** column 담당자부서명 : charDept */
//					infcPkgYeta1000Vo.setCharName(infcPkgYeta1000Vo.getCharName());    /** column 담당자성명 : charName */
//					infcPkgYeta1000Vo.setCharTele(infcPkgYeta1000Vo.getCharTele());    /** column 담당자전화번호 : charTele */
//					infcPkgYeta1000Vo.setFilePass(infcPkgYeta1000Vo.getFilePass());    /** column FILE_PASS : filePass */
//					infcPkgYeta1000Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//				    infcPkgYeta1000Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//				    infcPkgYeta1000Vo.setUsrId(sessionUser.getUsrId());  
//			              
//			            
//			       /******************************** 권한 ************************************************************************/
//			              
//			       infcPkgYeta1000Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
//			       infcPkgYeta1000Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getDtilOccuInttnCd()).replace(",", ""));  
//			            
//			       if (infcPkgYeta1000Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getDeptCd()))) { 
//                       infcPkgYeta1000Vo.setDeptCd("");  //부서코드
//                     } 
//			       
//					infcPkgYeta1000Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
//					infcPkgYeta1000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
//					infcPkgYeta1000Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
//					infcPkgYeta1000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
//		  	   
//					InfcPkgYeta1000VO creInfcPkgYeta1000Vo = new InfcPkgYeta1000VO();  //마감테이블  
//				 
//					//신규 생성시 데이터가존재하는경우 처리 
//					//creInfcPkgYeta1000Vo = yeta1100PayrService.selectYeta0100ToChkInfcPkgYeta1000(infcPkgYeta1000Vo);   //yeta1000
//					
//					
//					dataCheck = yeta1100PayrService.fnPayr06420_PAYR420_2014_CREATE_Insert(infcPkgYeta1000Vo);   //yeta1000
//		  	        
//		  	        
//		  	        
//		        }    
//		        
//              if (MSFSharedUtils.paramNull(dataCheck)) {
//            	  
//			  	        tpInfcPkgYeta1000Vo = yeta1100PayrService.selectYeta0100ToCreateYetaPrc1000(infcPkgYeta1000Vo);   //yeta1000
//			  	        
//			  	      if (MSFSharedUtils.paramNotNull(tpInfcPkgYeta1000Vo)) {
//			  	    	   infcPkgYeta1000Vo.setEdacSeilNum(tpInfcPkgYeta1000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
//					  	      // {급여내역생성 -417}
//					         //  {**************************급여내역 생성 2********************************}
//					        infcPkgYeta3210Vo.setDpobCd(infcPkgYeta1000Vo.getDpobCd());     /** 사업장코드 */
//					        infcPkgYeta3210Vo.setEdacRvyy(infcPkgYeta1000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
//					        infcPkgYeta3210Vo.setSettGbcd(infcPkgYeta1000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
//					        infcPkgYeta3210Vo.setSystemkey( infcPkgYeta1000Vo.getSystemkey());    /** column systemkey : systemkey */
//					      //  infcPkgYeta3210Vo.setEdacSeilNum(infcPkgYeta1000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
//					        infcPkgYeta3210Vo.setPayrMangDeptCd(infcPkgYeta1000Vo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
//					        infcPkgYeta3210Vo.setDeptCd(infcPkgYeta1000Vo.getDeptCd());    /** column 부서코드 : deptCd */
//					        infcPkgYeta3210Vo.setTypOccuCd(infcPkgYeta1000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//					        infcPkgYeta3210Vo.setDtilOccuClsDivCd(infcPkgYeta1000Vo.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
//					        infcPkgYeta3210Vo.setPyspGrdeCd(infcPkgYeta1000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
//					        infcPkgYeta3210Vo.setDtilOccuInttnCd(infcPkgYeta1000Vo.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
//					        infcPkgYeta3210Vo.setBusinCd(infcPkgYeta1000Vo.getBusinCd());    /** column 사업코드 : businCd */
//					        infcPkgYeta3210Vo.setEmymtDivCd(infcPkgYeta1000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */ 
//					        
//					        infcPkgYeta3210Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//					        infcPkgYeta3210Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//					        infcPkgYeta3210Vo.setUsrId(sessionUser.getUsrId());  
//					              
//					            
//					       /******************************** 권한 ************************************************************************/
//					              
//					        infcPkgYeta3210Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
//					        infcPkgYeta3210Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getDtilOccuInttnCd()).replace(",", ""));  
//					            
//					        if (infcPkgYeta1000Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getDeptCd()))) { 
//					        	infcPkgYeta3210Vo.setDeptCd("");  //부서코드
//			                } 
//					       
//					        infcPkgYeta3210Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
//					        infcPkgYeta3210Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
//					        infcPkgYeta3210Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
//					        infcPkgYeta3210Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
//					        dataCheck = "";
//					        dataCheck = yeta1100PayrService.fnPayr06420_PAYR417_2014_CREATE_Insert(infcPkgYeta3210Vo);   //infcPkgYeta3210Vo  
//					  	    
//					  	     bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "급여내역생성.","데이타확인","")); 
//					  	 // {연말정산기본생성 - 415}
//				         //    {**************************연말정산기본생성 [3]********************************}
//					  	    
//					  	   if (MSFSharedUtils.paramNull(dataCheck)) {
//					  		   
//					  	   
//									infcPkgYeta2000Vo.setDpobCd(infcPkgYeta1000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//									infcPkgYeta2000Vo.setEdacRvyy(infcPkgYeta1000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
//									infcPkgYeta2000Vo.setSettGbcd(infcPkgYeta1000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
//									infcPkgYeta2000Vo.setSystemkey(infcPkgYeta1000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//									infcPkgYeta2000Vo.setEdacSeilNum(infcPkgYeta1000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
//									infcPkgYeta2000Vo.setPayrMangDeptCd(infcPkgYeta1000Vo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
//									infcPkgYeta2000Vo.setEmymtDivCd(infcPkgYeta1000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
//									//infcPkgYeta2000Vo.setHanNm(infcPkgYeta1000Vo.getHanNm());    /** column 한글성명 : hanNm */
//									//infcPkgYeta2000Vo.setResnRegnNum(infcPkgYeta1000Vo.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
//									infcPkgYeta2000Vo.setDeptCd(infcPkgYeta1000Vo.getDeptCd());    /** column 부서코드 : deptCd */
//									infcPkgYeta2000Vo.setBusinCd(infcPkgYeta1000Vo.getBusinCd());    /** column 사업코드 : businCd */
//									infcPkgYeta2000Vo.setTypOccuCd(infcPkgYeta1000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//									infcPkgYeta2000Vo.setDtilOccuInttnCd(infcPkgYeta1000Vo.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
//									infcPkgYeta2000Vo.setDtilOccuClsDivCd(infcPkgYeta1000Vo.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
//									//infcPkgYeta2000Vo.setOdtyCd(infcPkgYeta1000Vo.getOdtyCd());    /** column 직책코드 : odtyCd */
//									//infcPkgYeta2000Vo.setPyspCd(infcPkgYeta1000Vo.getPyspCd());    /** column 호봉코드 : pyspCd */
//									infcPkgYeta2000Vo.setPyspGrdeCd(infcPkgYeta1000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
//									
//									infcPkgYeta2000Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//									infcPkgYeta2000Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//									infcPkgYeta2000Vo.setUsrId(sessionUser.getUsrId());  
//								              
//								               
//								     /******************************** 권한 ************************************************************************/
//								              
//									infcPkgYeta2000Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
//									infcPkgYeta2000Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getDtilOccuInttnCd()).replace(",", ""));  
//								        
//									 if (infcPkgYeta1000Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getDeptCd()))) { 
//										 infcPkgYeta2000Vo.setDeptCd("");  //부서코드
//						                } 
//								        
//									infcPkgYeta2000Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
//									infcPkgYeta2000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
//									infcPkgYeta2000Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
//									infcPkgYeta2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */ 
//									dataCheck = "";
//									dataCheck = yeta1100PayrService.fnPayr06420_PAYR415_2014_CREATE_Insert(infcPkgYeta2000Vo);   //infcPkgYeta2000Vo 
//						  	        bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "연말정산기본정보생성.","데이타확인","")); 
//										  	        //{비과세 감면 인서트 }
//								              //	 {**************************연말정산기본 비과세 감면 생성  [4]********************************} 
//										  	        
//						  	      if (MSFSharedUtils.paramNull(dataCheck)) {
//						  	    	  
//						  	    	dataCheck = "";
//						  	    	dataCheck =   yeta1100PayrService.fnPayr06420_YETA3200_2015_CREATE_Insert(infcPkgYeta2000Vo);   //infcPkgYeta3200Vo 
//										  	        
//										  	       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "비과세감면 생성.","데이타확인","")); 
//								
//										   if (MSFSharedUtils.paramNull(dataCheck)) {	  	       
//										  	       //      {가족사항 인서트 410 }
//										    //     {**************************가족사항 [4]********************************}
//										          //2015년 한부모공제 추가
//										  	     dataCheck = "";
//										  	     dataCheck =   yeta1100PayrService.fnPayr06430_PAYR410_2014_CREATE_Insert(infcPkgYeta2000Vo);   //infcPkgYeta3220Vo   
//										  	    
//										  	       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "가족사항 생성.","데이타확인","")); 
//										   if (MSFSharedUtils.paramNull(dataCheck)) {       
//										  	    // {가족사항 업데이트 410 고용/건강보험료외 업데이트  }
//										        // {**************************가족사항 [4_1]********************************}
//										          //2014년 고용건강보험료외 업데이트 
//										  	       yeta1100PayrService.fnPayr06430_PAYR410_2014_INSU_FETC_Update(infcPkgYeta2000Vo);   //infcPkgYeta3220Vo   
//										  	       
//										  	       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "가족사항 생성.","데이타확인",""));
//										  	       
//										  	  // {**************************부녀자공제 [5]********************************}
//									          // {부녀자공제란 여성근로소득자 본인인경우 업데이트 처리 }/
//									           
//										  	       yeta1100PayrService.fnPayr06430_PAYR410_2014_CREATE_Update(infcPkgYeta2000Vo);   //infcPkgYeta3220Vo   
//									               bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "가족사항 수정.","데이타확인",""));
//									          
//									           //{**************************이월기부금  [6]********************************}
//										       //   {이월기부금  443 인서트 }
//									       if (MSFSharedUtils.paramNull(dataCheck)) {
//									               dataCheck = "";
//										  	    	dataCheck =    yeta1100PayrService.fnPayr06430_PAYR443_2014_CREATE_Insert(infcPkgYeta2000Vo);   //infcPkgYeta3190Vo   
//									              bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "이월기부금 생성.","데이타확인",""));
//									           
//									        //   {**************************연말정산상세  [7]********************************}
//										     //    {연말정산상세 425 인서트 } 
//									              if (MSFSharedUtils.paramNull(dataCheck)) {
//									                 dataCheck = "";
//										  	    	dataCheck =    yeta1100PayrService.fnPayr06430_PAYR425_2014_CREATE_Insert(infcPkgYeta2000Vo);   //infcPkgYeta3000Vo   
//									                 bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "연말정산 정산일부.","데이타확인",""));
//									              }
//									         }       
//										   }  
//										   }       
//						  	      }            
//					  	   } 
//			  	      }      
//                }
//	           bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "대상자 생성이 완료되었습니다.","데이타확인",""));  
//		  	        
//	  	} catch (Exception ex) {
//	  		ex.printStackTrace();
//	   	   ShowMessageBM smBm = new ShowMessageBM();
//	   	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
//	   	   smBm.setMenu("Yeta");
//	   	   smBm.setPhase("[연말정산대상자]대상자생성에러");
//	   	   smBm.setMessage(ex.getLocalizedMessage());
//	   	   smBm.setContent(ex.getMessage());
//	   	   bmResult.add(smBm);  
//	   	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
//   	 
//      } 
//	  	   
//	  	  return  retval;
//    }
//    
//    
//    /**
//     * 
//     * <pre>
//     * 1. 개요 : yeta0100 연말정산 대상자 생성  
//     * 2. 처리내용 : 
//     * </pre>
//     * @Method Name : funcYetaPayr06420_All_Create
//     * @date : Jan 26, 2016
//     * @author : leeheuisung
//     * @history : 
//     *	-----------------------------------------------------------------------
//     *	변경일				작성자						변경내용  
//     *	----------- ------------------- ---------------------------------------
//     *	Jan 26, 2016		leeheuisung				최초 작성 
//     *	-----------------------------------------------------------------------
//     * 
//     * @param request
//     * @param infcPkgYeta1000Vo
//     * @return
//     * @throws Exception
//     */
//     private PagingLoadResult<ShowMessageBM> funcYetaPayr06420_All_Add_Create(HttpServletRequest request,InfcPkgYeta1000VO infcPkgYeta1000Vo)  throws Exception  {
//     	
//		PagingLoadResult<ShowMessageBM> retval = null;
//		List<ShowMessageBM> bmResult = new ArrayList<ShowMessageBM>();
//		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//
//		InfcPkgYeta1000VO tpInfcPkgYeta1000Vo = new InfcPkgYeta1000VO(); 	// 마감테이블
//		InfcPkgYeta3120VO infcPkgYeta3120Vo = new InfcPkgYeta3120VO(); 			// 거주자주택자금_금전소비대차
//		InfcPkgYeta3160VO infcPkgYeta3160Vo = new InfcPkgYeta3160VO(); 			// 거주자주택자금_임대차
//		InfcPkgYeta3100VO infcPkgYeta3100Vo = new InfcPkgYeta3100VO(); 			// 연금_저축공제
//		InfcPkgYeta3130VO infcPkgYeta3130Vo = new InfcPkgYeta3130VO(); 			// 주택자금_월세
//		InfcPkgYeta3140VO infcPkgYeta3140Vo = new InfcPkgYeta3140VO(); 			// 의료비
//		InfcPkgYeta3180VO infcPkgYeta3180Vo = new InfcPkgYeta3180VO(); 			// 기부금 명세
//		InfcPkgYeta3170VO infcPkgYeta3170Vo = new InfcPkgYeta3170VO(); 			// 이월기부금명세
//		InfcPkgYeta3190VO infcPkgYeta3190Vo = new InfcPkgYeta3190VO(); 			// 이월기부금temp
//		InfcPkgYeta3110VO infcPkgYeta3110Vo = new InfcPkgYeta3110VO(); 			// 종전근무지명세
//		InfcPkgYeta3200VO infcPkgYeta3200Vo = new InfcPkgYeta3200VO(); 			// 비과세감면소득
//		InfcPkgYeta3220VO infcPkgYeta3220Vo = new InfcPkgYeta3220VO(); 			// 가족사항
//		InfcPkgYeta3150VO infcPkgYeta3150Vo = new InfcPkgYeta3150VO(); 			// 교육비
//		InfcPkgYeta3210VO infcPkgYeta3210Vo = new InfcPkgYeta3210VO(); 			// 급여내역
//		InfcPkgYeta3300VO yetaPrc3300Vo = new InfcPkgYeta3300VO(); 			// 비과세감면소득정산
//		InfcPkgYeta3000VO infcPkgYeta3000Vo = new InfcPkgYeta3000VO(); 			// 연말정산결과
//		InfcPkgYeta2000VO infcPkgYeta2000Vo = new InfcPkgYeta2000VO(); 			// 연말정산기본
//
//         String dataCheck = ""; 
// 	  	  try { 
// 	  		   
// 		  	   if  (yeta1100PayrService == null) { 
// 	               WebApplicationContext wac = WebApplicationContextUtils.
// 	                       getRequiredWebApplicationContext( request.getSession().getServletContext());
// 	   
// 	               yeta1100PayrService = (Yeta1100PayrService) wac.getBean("YetaPayr6420CreateService"); 
// 	              
// 	            }
// 		  	   
// 		  	 
// 		     //   if (MSFSharedUtils.paramNull(infcPkgYeta1000Vo.getSystemkey()))  { 
// 		         
// 		           // {마감정보 생성 }
//
// 		           //   {**************************마감정보 1********************************} 
//
// 					infcPkgYeta1000Vo.setEdacRvyy(infcPkgYeta1000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
// 					infcPkgYeta1000Vo.setSettGbcd(infcPkgYeta1000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
// 					infcPkgYeta1000Vo.setEdacSeilNum(infcPkgYeta1000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
// 					infcPkgYeta1000Vo.setPayrMangDeptCd(infcPkgYeta1000Vo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
// 					infcPkgYeta1000Vo.setDeptCd(infcPkgYeta1000Vo.getDeptCd());    /** column 부서코드 : deptCd */
// 					infcPkgYeta1000Vo.setTypOccuCd(infcPkgYeta1000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
// 					infcPkgYeta1000Vo.setDtilOccuClsDivCd(infcPkgYeta1000Vo.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
// 					infcPkgYeta1000Vo.setPyspGrdeCd(infcPkgYeta1000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
// 					infcPkgYeta1000Vo.setDtilOccuInttnCd(infcPkgYeta1000Vo.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
// 					infcPkgYeta1000Vo.setBusinCd(infcPkgYeta1000Vo.getBusinCd());    /** column 사업코드 : businCd */
// 					infcPkgYeta1000Vo.setEmymtDivCd(infcPkgYeta1000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
// 					infcPkgYeta1000Vo.setPernChrgEmpIdenNum(sessionUser.getUsrId());    /** column 생성직원번호 : pernChrgEmpIdenNum infcPkgYeta1000Vo.getPernChrgEmpIdenNum()*/
//// 					infcPkgYeta1000Vo.setClosFlag(infcPkgYeta1000Vo.getClosFlag());    /** column 마감여부 : closFlag */
//// 					infcPkgYeta1000Vo.setClosCont(infcPkgYeta1000Vo.getClosCont());    /** column 마감건수 : closCont */
//// 					infcPkgYeta1000Vo.setClosDate(infcPkgYeta1000Vo.getClosDate());    /** column 마감일자 : closDate */
//// 					infcPkgYeta1000Vo.setEdacPrdt(infcPkgYeta1000Vo.getEdacPrdt());    /** column 연말정산제출일자 : edacPrdt */
//// 					infcPkgYeta1000Vo.setReprName(infcPkgYeta1000Vo.getReprName());    /** column 대표자성명 : reprName */
//// 					infcPkgYeta1000Vo.setJuriName(infcPkgYeta1000Vo.getJuriName());    /** column 법인명_상호 : juriName */
//// 					infcPkgYeta1000Vo.setBusiNumb(infcPkgYeta1000Vo.getBusiNumb());    /** column 사업자등록번호 : busiNumb */
//// 					infcPkgYeta1000Vo.setResuNumb(infcPkgYeta1000Vo.getResuNumb());    /** column 주민등록번호 : resuNumb */
//// 					infcPkgYeta1000Vo.setJuriNumb(infcPkgYeta1000Vo.getJuriNumb());    /** column 법인번호 : juriNumb */
//// 					infcPkgYeta1000Vo.setIncmPost(infcPkgYeta1000Vo.getIncmPost());    /** column 소득신고의무자우편번호 : incmPost */
//// 					infcPkgYeta1000Vo.setIncmAddr(infcPkgYeta1000Vo.getIncmAddr());    /** column 소득신고의무자기본주소 : incmAddr */
//// 					infcPkgYeta1000Vo.setIncmAdtl(infcPkgYeta1000Vo.getIncmAdtl());    /** column 소득신고의무자상세주소 : incmAdtl */
//// 					infcPkgYeta1000Vo.setTaxaCode(infcPkgYeta1000Vo.getTaxaCode());    /** column 관할세무서코드 : taxaCode */
//// 					infcPkgYeta1000Vo.setIncmGbcd(infcPkgYeta1000Vo.getIncmGbcd());    /** column 제출자구분코드 : incmGbcd */
//// 					infcPkgYeta1000Vo.setTaxaDnum(infcPkgYeta1000Vo.getTaxaDnum());    /** column 세무대리인번호 : taxaDnum */
//// 					infcPkgYeta1000Vo.setHomeTxid(infcPkgYeta1000Vo.getHomeTxid());    /** column 홈텍스ID : homeTxid */
//// 					infcPkgYeta1000Vo.setTaxaPrcd(infcPkgYeta1000Vo.getTaxaPrcd());    /** column 세무프로그램코드 : taxaPrcd */
//// 					infcPkgYeta1000Vo.setCharDept(infcPkgYeta1000Vo.getCharDept());    /** column 담당자부서명 : charDept */
//// 					infcPkgYeta1000Vo.setCharName(infcPkgYeta1000Vo.getCharName());    /** column 담당자성명 : charName */
//// 					infcPkgYeta1000Vo.setCharTele(infcPkgYeta1000Vo.getCharTele());    /** column 담당자전화번호 : charTele */
//// 					infcPkgYeta1000Vo.setFilePass(infcPkgYeta1000Vo.getFilePass());    /** column FILE_PASS : filePass */
// 					infcPkgYeta1000Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
// 				    infcPkgYeta1000Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
// 				    infcPkgYeta1000Vo.setUsrId(sessionUser.getUsrId());  
// 			              
// 			            
// 			       /******************************** 권한 ************************************************************************/
// 			              
// 			       infcPkgYeta1000Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
// 			       infcPkgYeta1000Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getDtilOccuInttnCd()).replace(",", ""));  
// 			            
// 			       if (infcPkgYeta1000Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getDeptCd()))) { 
//                        infcPkgYeta1000Vo.setDeptCd("");  //부서코드
//                      } 
// 			       
// 					infcPkgYeta1000Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
// 					infcPkgYeta1000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
// 					infcPkgYeta1000Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
// 					infcPkgYeta1000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
// 		  	   
// 					InfcPkgYeta1000VO creInfcPkgYeta1000Vo = new InfcPkgYeta1000VO();  //마감테이블  
// 				 
// 					//신규 생성시 데이터가존재하는경우 처리 
// 					//creInfcPkgYeta1000Vo = yeta1100PayrService.selectYeta0100ToChkInfcPkgYeta1000(infcPkgYeta1000Vo);   //yeta1000
// 					
// 					
// 		  	      //  yeta1100PayrService.fnPayr06420_PAYR420_2014_CREATE_Insert(infcPkgYeta1000Vo);   //yeta1000
// 		  	        
// 		  	        
// 		  	        tpInfcPkgYeta1000Vo = yeta1100PayrService.selectYeta0100ToCreateYetaPrc1000(infcPkgYeta1000Vo);   //yeta1000
// 		  	       
// 		  	        infcPkgYeta1000Vo.setEdacSeilNum(tpInfcPkgYeta1000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
// 		  	      
// 		  	        
// 		  	        infcPkgYeta1000Vo.setAddCheck("ADD");   //추가 여부에 따른 기존데이타 스킾처리하는 루틴 추가 
// 		  	        
// 		    //    }    
// 		  	   
// 		  	      
// 		  	      
// 		  	      // {급여내역생성 -417}
// 		         //  {**************************급여내역 생성 2********************************}
// 		        infcPkgYeta3210Vo.setDpobCd(infcPkgYeta1000Vo.getDpobCd());     /** 사업장코드 */
// 		        infcPkgYeta3210Vo.setEdacRvyy(infcPkgYeta1000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
// 		        infcPkgYeta3210Vo.setSettGbcd(infcPkgYeta1000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
// 		        infcPkgYeta3210Vo.setSystemkey( infcPkgYeta1000Vo.getSystemkey());    /** column systemkey : systemkey */
// 		      //  infcPkgYeta3210Vo.setEdacSeilNum(infcPkgYeta1000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
// 		        infcPkgYeta3210Vo.setPayrMangDeptCd(infcPkgYeta1000Vo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
// 		        infcPkgYeta3210Vo.setDeptCd(infcPkgYeta1000Vo.getDeptCd());    /** column 부서코드 : deptCd */
// 		        infcPkgYeta3210Vo.setTypOccuCd(infcPkgYeta1000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
// 		        infcPkgYeta3210Vo.setDtilOccuClsDivCd(infcPkgYeta1000Vo.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
// 		        infcPkgYeta3210Vo.setPyspGrdeCd(infcPkgYeta1000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
// 		        infcPkgYeta3210Vo.setDtilOccuInttnCd(infcPkgYeta1000Vo.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
// 		        infcPkgYeta3210Vo.setBusinCd(infcPkgYeta1000Vo.getBusinCd());    /** column 사업코드 : businCd */
// 		        infcPkgYeta3210Vo.setEmymtDivCd(infcPkgYeta1000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */ 
// 		        
// 		        infcPkgYeta3210Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
// 		        infcPkgYeta3210Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
// 		        infcPkgYeta3210Vo.setUsrId(sessionUser.getUsrId());  
// 		       infcPkgYeta3210Vo.setAddCheck("ADD");   //추가 여부에 따른 기존데이타 스킾처리하는 루틴 추가 
// 		            
// 		       /******************************** 권한 ************************************************************************/
// 		              
// 		        infcPkgYeta3210Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
// 		        infcPkgYeta3210Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getDtilOccuInttnCd()).replace(",", ""));  
// 		            
// 		        if (infcPkgYeta1000Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getDeptCd()))) { 
// 		        	infcPkgYeta3210Vo.setDeptCd("");  //부서코드
//                 } 
// 		       
// 		        infcPkgYeta3210Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
// 		        infcPkgYeta3210Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
// 		        infcPkgYeta3210Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
// 		        infcPkgYeta3210Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
// 		     
// 		        dataCheck = "";
//	  	    	dataCheck =  yeta1100PayrService.fnPayr06420_PAYR417_2014_CREATE_Insert(infcPkgYeta3210Vo);   //infcPkgYeta3210Vo  
// 		  	    
// 		  	     bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "급여내역생성.","데이타확인","")); 
// 		  	
// 		  	  if (MSFSharedUtils.paramNull(dataCheck)) {   
// 		  	     // {연말정산기본생성 - 415}
// 	         //    {**************************연말정산기본생성 [3]********************************}
// 		  	    
//
// 					infcPkgYeta2000Vo.setDpobCd(infcPkgYeta1000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
// 					infcPkgYeta2000Vo.setEdacRvyy(infcPkgYeta1000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
// 					infcPkgYeta2000Vo.setSettGbcd(infcPkgYeta1000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
// 					infcPkgYeta2000Vo.setSystemkey(infcPkgYeta1000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
// 					infcPkgYeta2000Vo.setEdacSeilNum(infcPkgYeta1000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
// 					infcPkgYeta2000Vo.setPayrMangDeptCd(infcPkgYeta1000Vo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
// 					infcPkgYeta2000Vo.setEmymtDivCd(infcPkgYeta1000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
// 					//infcPkgYeta2000Vo.setHanNm(infcPkgYeta1000Vo.getHanNm());    /** column 한글성명 : hanNm */
// 					//infcPkgYeta2000Vo.setResnRegnNum(infcPkgYeta1000Vo.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
// 					infcPkgYeta2000Vo.setDeptCd(infcPkgYeta1000Vo.getDeptCd());    /** column 부서코드 : deptCd */
// 					infcPkgYeta2000Vo.setBusinCd(infcPkgYeta1000Vo.getBusinCd());    /** column 사업코드 : businCd */
// 					infcPkgYeta2000Vo.setTypOccuCd(infcPkgYeta1000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
// 					infcPkgYeta2000Vo.setDtilOccuInttnCd(infcPkgYeta1000Vo.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
// 					infcPkgYeta2000Vo.setDtilOccuClsDivCd(infcPkgYeta1000Vo.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
// 					//infcPkgYeta2000Vo.setOdtyCd(infcPkgYeta1000Vo.getOdtyCd());    /** column 직책코드 : odtyCd */
// 					//infcPkgYeta2000Vo.setPyspCd(infcPkgYeta1000Vo.getPyspCd());    /** column 호봉코드 : pyspCd */
// 					infcPkgYeta2000Vo.setPyspGrdeCd(infcPkgYeta1000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
// 					
// 					infcPkgYeta2000Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
// 					infcPkgYeta2000Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
// 					infcPkgYeta2000Vo.setUsrId(sessionUser.getUsrId());  
// 				              
// 					infcPkgYeta2000Vo.setAddCheck("ADD");   //추가 여부에 따른 기존데이타 스킾처리하는 루틴 추가 
// 				     /******************************** 권한 ************************************************************************/
// 				              
// 					infcPkgYeta2000Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
// 					infcPkgYeta2000Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getDtilOccuInttnCd()).replace(",", ""));  
// 				        
// 					 if (infcPkgYeta1000Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(infcPkgYeta1000Vo.getDeptCd()))) { 
// 						 infcPkgYeta2000Vo.setDeptCd("");  //부서코드
// 		                } 
// 				        
// 					infcPkgYeta2000Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
// 					infcPkgYeta2000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
// 					infcPkgYeta2000Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
// 					infcPkgYeta2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */ 
// 		  	    
// 					
// 					dataCheck = "";
// 		  	    	dataCheck = yeta1100PayrService.fnPayr06420_PAYR415_2014_CREATE_Insert(infcPkgYeta2000Vo);   //infcPkgYeta2000Vo 
// 		  	        bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "연말정산기본정보생성.","데이타확인","")); 
// 		  	 
// 		  	     if (MSFSharedUtils.paramNull(dataCheck)) {   
// 		  	        //{비과세 감면 인서트 }
//               //	 {**************************연말정산기본 비과세 감면 생성  [4]********************************} 
// 		  	        
// 		  	        
// 		  	    	dataCheck = "";
// 		  	    	dataCheck = yeta1100PayrService.fnPayr06420_YETA3200_2015_CREATE_Insert(infcPkgYeta2000Vo);   //infcPkgYeta3200Vo 
// 		  	        
// 		  	       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "비과세감면 생성.","데이타확인","")); 
// 		  	
// 		  	     if (MSFSharedUtils.paramNull(dataCheck)) {   
// 		  	       //      {가족사항 인서트 410 }
// 		           //     {**************************가족사항 [4]********************************}
// 		          //2015년 한부모공제 추가
// 		  	    	dataCheck = "";
// 		  	    	dataCheck =  yeta1100PayrService.fnPayr06430_PAYR410_2014_CREATE_Insert(infcPkgYeta2000Vo);   //infcPkgYeta3220Vo   
// 		  	    
// 		  	       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "가족사항 생성.","데이타확인","")); 
// 		  	    if (MSFSharedUtils.paramNull(dataCheck)) {         
//		 		  	    // {가족사항 업데이트 410 고용/건강보험료외 업데이트  }
//		 		        // {**************************가족사항 [4_1]********************************}
//		 		          //2014년 고용건강보험료외 업데이트 
//		 		  	       yeta1100PayrService.fnPayr06430_PAYR410_2014_INSU_FETC_Update(infcPkgYeta2000Vo);   //infcPkgYeta3220Vo   
//		 		  	       
//		 		  	       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "가족사항 생성.","데이타확인",""));
//		 		  	       
//		 		  	  // {**************************부녀자공제 [5]********************************}
//		 	          // {부녀자공제란 여성근로소득자 본인인경우 업데이트 처리 }/
//		 	           
//		 	               yeta1100PayrService.fnPayr06430_PAYR410_2014_CREATE_Update(infcPkgYeta2000Vo);   //infcPkgYeta3220Vo   
//		 	               bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "가족사항 수정.","데이타확인",""));
//		 	          
//		 	           //{**************************이월기부금  [6]********************************}
//		 		       //   {이월기부금  443 인서트 }
//		 	              if (MSFSharedUtils.paramNull(dataCheck)) {        
//			 	              dataCheck = "";
//			 		  	    	dataCheck = yeta1100PayrService.fnPayr06430_PAYR443_2014_CREATE_Insert(infcPkgYeta2000Vo);   //infcPkgYeta3190Vo   
//			 	              bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "이월기부금 생성.","데이타확인",""));
//			 	           
//			 	        //   {**************************연말정산상세  [7]********************************}
//			 		     //    {연말정산상세 425 인서트 } 
//			 	             if (MSFSharedUtils.paramNull(dataCheck)) {    
//				 	             dataCheck = "";
//				 		  	    	dataCheck = yeta1100PayrService.fnPayr06430_PAYR425_2014_CREATE_Insert(infcPkgYeta2000Vo);   //infcPkgYeta3000Vo   
//				 	             bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "연말정산 정산일부.","데이타확인",""));
//			 	             }
//		 	              }
// 		  	        }
// 		  	     }
// 		  	     }
// 		  	  } 
// 	             bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "대상자 생성이 완료되었습니다.","데이타확인",""));  
// 		  	        
// 	  	} catch (Exception ex) {
//            
// 	   	   ShowMessageBM smBm = new ShowMessageBM();
// 	   	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
// 	   	   smBm.setMenu("Yeta");
// 	   	   smBm.setPhase("[연말정산대상자]대상자생성에러");
// 	   	   smBm.setMessage(ex.getLocalizedMessage());
// 	   	   smBm.setContent(ex.getMessage());
// 	   	   bmResult.add(smBm);  
// 	   	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
//    	 
//       } 
// 	  	   
// 	  	  return  retval;
//     }
//    
//    
//     
//    
//    private PagingLoadResult<ShowMessageBM> funcPayrToYeta_Insert(HttpServletRequest request,List<InfcPkgYeta2000VO>  lstInfcPkgYeta2000Vo)  throws Exception  {
//    	
//  	      PagingLoadResult<ShowMessageBM> retval = null; 
//	      List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
//	  	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//	  	  
//	  	  
//	  	  InfcPkgYeta3210VO infcPkgYeta3210Vo = new InfcPkgYeta3210VO();  //급여내역
//	  	  //InfcPkgYeta3200VO infcPkgYeta3200Vo = new InfcPkgYeta3200VO();  //비과세감면소득 
//	  	
//	  	 try { 
//	  		   
//		  	   if  (yeta1100PayrService == null) { 
//	               WebApplicationContext wac = WebApplicationContextUtils.
//	                       getRequiredWebApplicationContext( request.getSession().getServletContext());
//	   
//	               yeta1100PayrService = (Yeta1100PayrService) wac.getBean("Yeta1100PayrService"); 
//	              
//	            }
//		  	   
//		  	  
//		  	  /************************* 대상자별로 루프 시작 ***************************************************/ 
//		  	   for (int iCnt01 = 0;iCnt01 < lstInfcPkgYeta2000Vo.size();iCnt01++) {
//		  		    
//		  		 InfcPkgYeta2000VO infcPkgYeta2000Vo = new InfcPkgYeta2000VO(); 
//		  		 infcPkgYeta2000Vo = lstInfcPkgYeta2000Vo.get(iCnt01);  
//		  		
//		  		 
//		  		 //{******************************급여자료 이관 - 급여내역 생성  [2]*******************************************}
//		         // {급여내역생성 -417}
//		            infcPkgYeta3210Vo.setDpobCd(infcPkgYeta2000Vo.getDpobCd());     /** 사업장코드 */
//			        infcPkgYeta3210Vo.setEdacRvyy(infcPkgYeta2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
//			        infcPkgYeta3210Vo.setSettGbcd(infcPkgYeta2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
//			        infcPkgYeta3210Vo.setSystemkey(infcPkgYeta2000Vo.getSystemkey());    /** column 정산구분코드 : settGbcd */
//			     //   infcPkgYeta3210Vo.setEdacSeilNum(infcPkgYeta2000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
//			        infcPkgYeta3210Vo.setPayrMangDeptCd(infcPkgYeta2000Vo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
//			        infcPkgYeta3210Vo.setDeptCd(infcPkgYeta2000Vo.getDeptCd());    /** column 부서코드 : deptCd */
//			        infcPkgYeta3210Vo.setTypOccuCd(infcPkgYeta2000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//			        infcPkgYeta3210Vo.setDtilOccuClsDivCd(infcPkgYeta2000Vo.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
//			        infcPkgYeta3210Vo.setPyspGrdeCd(infcPkgYeta2000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
//			        infcPkgYeta3210Vo.setDtilOccuInttnCd(infcPkgYeta2000Vo.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
//			        infcPkgYeta3210Vo.setBusinCd(infcPkgYeta2000Vo.getBusinCd());    /** column 사업코드 : businCd */
//			        infcPkgYeta3210Vo.setEmymtDivCd(infcPkgYeta2000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */ 
//			        
//			        infcPkgYeta3210Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//			        infcPkgYeta3210Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//			        infcPkgYeta3210Vo.setUsrId(sessionUser.getUsrId());  
//			              
//			            
//			       /******************************** 권한 ************************************************************************/
//			              
//			        infcPkgYeta3210Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta2000Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
//			        infcPkgYeta3210Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(infcPkgYeta2000Vo.getDtilOccuInttnCd()).replace(",", ""));  
//			            
//			        if (infcPkgYeta3210Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(infcPkgYeta2000Vo.getDeptCd()))) { 
//			        	infcPkgYeta3210Vo.setDeptCd("");  //부서코드
//	               } 
//			       
//			        infcPkgYeta3210Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
//			        infcPkgYeta3210Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
//			        infcPkgYeta3210Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
//			        infcPkgYeta3210Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
//			  	        
//			  	    yeta1100PayrService.fnPayr06420_PAYR417_2014_CREATE_Insert(infcPkgYeta3210Vo);   //infcPkgYeta3210Vo  
//		        
//		  		 // 415 업데이트
//		        // {******************************급여자료 이관 - 연말정산 업데이트   [3]*******************************************}
//		      
//			  	  
//			  	    yeta1100PayrService.fnPayr06520_PAYR415_2015_CREATE1_Update(infcPkgYeta2000Vo);   //infcPkgYeta3210Vo 
//			  	     
//			  	  //{비과세 감면 인서트 }
//		          //{**************************연말정산기본 비과세 감면 업데이트   [4]********************************} 
//				  	        
//				  	        
//				   yeta1100PayrService.fnPayr06420_YETA3200_2015_CREATE1_Update(infcPkgYeta2000Vo);   //infcPkgYeta3200Vo 
//			  	    
//		         
//		       // {******************************급여자료 이관 - 연말정산 425 업데이트   [4]*******************************************}
//		         //425 업데이트
//		        
//				  yeta1100PayrService.fnPayr06530_PAYR425_2015_CREATE1_Update(infcPkgYeta2000Vo);   //infcPkgYeta3210Vo 
//				  
//				    
//		  	   }  
//		  	 /************************* 대상자별로 루프 종료 ***************************************************/      
//	  	} catch (Exception ex) {
//           ex.printStackTrace();
//	   	   ShowMessageBM smBm = new ShowMessageBM();
//	   	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
//	   	   smBm.setMenu("Yeta");
//	   	   smBm.setPhase("[연말정산 급여이관]대상자급여이관에러");
//	   	   smBm.setMessage(ex.getLocalizedMessage());
//	   	   smBm.setContent(ex.getMessage());
//	   	   bmResult.add(smBm);  
//	   	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
// 	 
//    } 
//	  	   
//	  	  return  retval;
//  }
   
 
}