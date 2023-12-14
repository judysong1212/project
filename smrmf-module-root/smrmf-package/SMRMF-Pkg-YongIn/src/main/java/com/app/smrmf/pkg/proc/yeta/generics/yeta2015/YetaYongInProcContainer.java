package com.app.smrmf.pkg.proc.yeta.generics.yeta2015;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.gwtrpcspring.RemoteServiceUtil;
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
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3170SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3170VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3180VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3190VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3200VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3210VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3220VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3300VO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.YetaPayr6420Service;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.YetaPayr6430Service;
import com.ext.constants.PropPayGenConfs;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class YetaYongInProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(YetaYongInProcContainer.class);
	  
	 
  
    @Resource(name = "YetaPayr6420CreateService")
    protected YetaPayr6420Service  yetaPayr6420Create;
    
    @Resource(name = "YetaPayr6430Service")
    protected YetaPayr6430Service  yetaPayr6430Service;
    
    
    
//    @Resource(name = "RetirementCalculstionService")
//    protected RetirementCalculstionService remtCalcService;
//
 
	
    public YetaYongInProcContainer() {
    	
    }
    
 
    public PagingLoadResult<ShowMessageBM> execYetaPayr06420_All_Create(HttpServletRequest request,InfcPkgYeta1000VO yetaPrc1000Vo)  throws Exception  {
  	    
	  	  return  funcYetaPayr06420_All_Create(request,  yetaPrc1000Vo);
	}
    
    public PagingLoadResult<ShowMessageBM> execYetaPayr06420_All_Add_Create(HttpServletRequest request,InfcPkgYeta1000VO yetaPrc1000Vo)  throws Exception  {
  	    
	  	  return  funcYetaPayr06420_All_Add_Create(request,  yetaPrc1000Vo);
	}
    
    
    public PagingLoadResult<ShowMessageBM> execPayrToYeta_Insert(HttpServletRequest request,List<InfcPkgYeta2000VO>  lstInfcPkgYeta2000Vo)  throws Exception  {
  	    
	  	  return  funcPayrToYeta_Insert(request,  lstInfcPkgYeta2000Vo);
	}
    
    
    public PagingLoadResult<ShowMessageBM> execfnYeta0300Payr06430CalcTax(HttpServletRequest request,List<InfcPkgYeta2000VO>  lstInfcPkgYeta2000Vo)  throws Exception  {
  	    
	  	  return  funcYeta0300Payr06430CalcTax(request,  lstInfcPkgYeta2000Vo);
	}
    
//    //저장루틴에 따른 변동사항 재저장 처리를 위한 처리부 
//    public PagingLoadResult<ShowMessageBM> execRemt0100ToRemtCalc2000(HttpServletRequest request, InfcRemt2000VO  remt2000)  throws Exception  {
//  	    
//	  	  return  funcRemt0100ToRemtCalc2000(request,remt2000);
//	} 
//     
//  
//    //저장루틴에 따른 변동사항 재저장 처리를 위한 처리부 
//    public PagingLoadResult<ShowMessageBM> execActivityOnPayrCalc(HttpServletRequest request, List<InfcRemt2000VO> listRemt2000Vo)  throws Exception  {
//  	    
//	  	  return  funcActivityOnPayrCalc(request,listRemt2000Vo);
//	} 
//    
//    //급여내역 시간 변경에 따른 데이타 재계산 처리를 위한 루틴 추가 
//    public Long execActivityOnUpdateRemt0100ToPayrCalc(HttpServletRequest request, List<InfcRemt2200VO> lstInfcRemt2200Vo)  throws Exception  {
//  	    
//	  	  return  funcActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo);
//	} 
//    
//    /**
//     * 후생복지비에 따른 계산 처리 
//     * @param request
//     * @param lstInfcRemt2200Vo
//     * @return
//     * @throws Exception
//     */
//    public Long execActivityOnUpdateRemt0100ToPayrWfepCalc(HttpServletRequest request, List<InfcRemt2200VO> lstInfcRemt2200Vo)  throws Exception  {
//  	    
//	  	  return  funcActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo);
//	} 
//     
//      
//    //퇴직정산 
//    public PagingLoadResult<ShowMessageBM> execRemtTxCalculation(HttpServletRequest request,List<InfcRemt3000VO> lstInfcRemt3000TgtVo)  throws Exception  {
//  	    
//	  	  return  funcRemtTxCalculation(request,lstInfcRemt3000TgtVo);
//	}
//   
//    
   /**
    * 
    * <pre>
    * 1. 개요 : yeta0100 연말정산 대상자 생성  
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : funcYetaPayr06420_All_Create
    * @date : Jan 26, 2016
    * @author : leeheuisung
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	Jan 26, 2016		leeheuisung				최초 작성 
    *	-----------------------------------------------------------------------
    * YetaPayr06420_Al_Add_Create
    * @param request
    * @param yetaPrc1000Vo
    * @return
    * @throws Exception
    */
    private PagingLoadResult<ShowMessageBM> funcYetaPayr06420_All_Create(HttpServletRequest request,InfcPkgYeta1000VO yetaPrc1000Vo)  throws Exception  {
    	
    	  PagingLoadResult<ShowMessageBM> retval = null; 
	      List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	  	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
	  	  
	 	InfcPkgYeta1000VO tpInfcPkgYeta1000Vo = new InfcPkgYeta1000VO();  //마감테이블   
        InfcPkgYeta3120VO yetaPrc3120Vo = new InfcPkgYeta3120VO();  //거주자주택자금_금전소비대차  
        InfcPkgYeta3160VO yetaPrc3160Vo = new InfcPkgYeta3160VO();  //거주자주택자금_임대차  
        InfcPkgYeta3100VO yetaPrc3100Vo = new InfcPkgYeta3100VO();  //연금_저축공제
        InfcPkgYeta3130VO yetaPrc3130Vo = new InfcPkgYeta3130VO();  //주택자금_월세
        InfcPkgYeta3140VO yetaPrc3140Vo = new InfcPkgYeta3140VO();  //의료비
  	    InfcPkgYeta3180VO yetaPrc3180Vo = new InfcPkgYeta3180VO();  //기부금 명세 
  	    InfcPkgYeta3170VO yetaPrc3170Vo = new InfcPkgYeta3170VO();  //이월기부금명세
  	    InfcPkgYeta3190VO yetaPrc3190Vo = new InfcPkgYeta3190VO();  //이월기부금temp
  	    InfcPkgYeta3110VO yetaPrc3110Vo = new InfcPkgYeta3110VO();  //종전근무지명세 
  	    InfcPkgYeta3200VO yetaPrc3200Vo = new InfcPkgYeta3200VO();  //비과세감면소득  
  	    InfcPkgYeta3220VO yetaPrc3220Vo = new InfcPkgYeta3220VO();  //가족사항  
  	    InfcPkgYeta3150VO yetaPrc3150Vo = new InfcPkgYeta3150VO();  //교육비
  	    InfcPkgYeta3210VO yetaPrc3210Vo = new InfcPkgYeta3210VO();  //급여내역
  	    InfcPkgYeta3300VO yetaPrc3300Vo = new InfcPkgYeta3300VO();  //비과세감면소득정산  
  	    InfcPkgYeta3000VO yetaPrc3000Vo = new InfcPkgYeta3000VO();  //연말정산결과  
        InfcPkgYeta2000VO yetaPrc2000Vo = new InfcPkgYeta2000VO();  //연말정산기본  
        
         String dataCheck = "";
        
	  	  try { 
	  		   
		  	   if  (yetaPayr6420Create == null) { 
	               WebApplicationContext wac = WebApplicationContextUtils.
	                       getRequiredWebApplicationContext( request.getSession().getServletContext());
	   
	               yetaPayr6420Create = (YetaPayr6420Service) wac.getBean("YetaPayr6420CreateService"); 
	              
	            }
		  	   
		  	 
		        if (MSFSharedUtils.paramNull(yetaPrc1000Vo.getSystemkey()))  { 
		         
		           // {마감정보 생성 }

		           //   {**************************마감정보 1********************************} 

					yetaPrc1000Vo.setEdacRvyy(yetaPrc1000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
					yetaPrc1000Vo.setSettGbcd(yetaPrc1000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
					yetaPrc1000Vo.setEdacSeilNum(yetaPrc1000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
					yetaPrc1000Vo.setPayrMangDeptCd(yetaPrc1000Vo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
					yetaPrc1000Vo.setDeptCd(yetaPrc1000Vo.getDeptCd());    /** column 부서코드 : deptCd */
					yetaPrc1000Vo.setTypOccuCd(yetaPrc1000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
					yetaPrc1000Vo.setDtilOccuClsDivCd(yetaPrc1000Vo.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
					yetaPrc1000Vo.setPyspGrdeCd(yetaPrc1000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
					yetaPrc1000Vo.setDtilOccuInttnCd(yetaPrc1000Vo.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
					yetaPrc1000Vo.setBusinCd(yetaPrc1000Vo.getBusinCd());    /** column 사업코드 : businCd */
					yetaPrc1000Vo.setEmymtDivCd(yetaPrc1000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
					yetaPrc1000Vo.setPernChrgEmpIdenNum(sessionUser.getUsrId());    /** column 생성직원번호 : pernChrgEmpIdenNum yetaPrc1000Vo.getPernChrgEmpIdenNum()*/
					yetaPrc1000Vo.setClosFlag(yetaPrc1000Vo.getClosFlag());    /** column 마감여부 : closFlag */
					yetaPrc1000Vo.setClosCont(yetaPrc1000Vo.getClosCont());    /** column 마감건수 : closCont */
					yetaPrc1000Vo.setClosDate(yetaPrc1000Vo.getClosDate());    /** column 마감일자 : closDate */
					yetaPrc1000Vo.setEdacPrdt(yetaPrc1000Vo.getEdacPrdt());    /** column 연말정산제출일자 : edacPrdt */
					yetaPrc1000Vo.setReprName(yetaPrc1000Vo.getReprName());    /** column 대표자성명 : reprName */
					yetaPrc1000Vo.setJuriName(yetaPrc1000Vo.getJuriName());    /** column 법인명_상호 : juriName */
					yetaPrc1000Vo.setBusiNumb(yetaPrc1000Vo.getBusiNumb());    /** column 사업자등록번호 : busiNumb */
					yetaPrc1000Vo.setResuNumb(yetaPrc1000Vo.getResuNumb());    /** column 주민등록번호 : resuNumb */
					yetaPrc1000Vo.setJuriNumb(yetaPrc1000Vo.getJuriNumb());    /** column 법인번호 : juriNumb */
					yetaPrc1000Vo.setIncmPost(yetaPrc1000Vo.getIncmPost());    /** column 소득신고의무자우편번호 : incmPost */
					yetaPrc1000Vo.setIncmAddr(yetaPrc1000Vo.getIncmAddr());    /** column 소득신고의무자기본주소 : incmAddr */
					yetaPrc1000Vo.setIncmAdtl(yetaPrc1000Vo.getIncmAdtl());    /** column 소득신고의무자상세주소 : incmAdtl */
					yetaPrc1000Vo.setTaxaCode(yetaPrc1000Vo.getTaxaCode());    /** column 관할세무서코드 : taxaCode */
					yetaPrc1000Vo.setIncmGbcd(yetaPrc1000Vo.getIncmGbcd());    /** column 제출자구분코드 : incmGbcd */
					yetaPrc1000Vo.setTaxaDnum(yetaPrc1000Vo.getTaxaDnum());    /** column 세무대리인번호 : taxaDnum */
					yetaPrc1000Vo.setHomeTxid(yetaPrc1000Vo.getHomeTxid());    /** column 홈텍스ID : homeTxid */
					yetaPrc1000Vo.setTaxaPrcd(yetaPrc1000Vo.getTaxaPrcd());    /** column 세무프로그램코드 : taxaPrcd */
					yetaPrc1000Vo.setCharDept(yetaPrc1000Vo.getCharDept());    /** column 담당자부서명 : charDept */
					yetaPrc1000Vo.setCharName(yetaPrc1000Vo.getCharName());    /** column 담당자성명 : charName */
					yetaPrc1000Vo.setCharTele(yetaPrc1000Vo.getCharTele());    /** column 담당자전화번호 : charTele */
					yetaPrc1000Vo.setFilePass(yetaPrc1000Vo.getFilePass());    /** column FILE_PASS : filePass */
					yetaPrc1000Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
				    yetaPrc1000Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
				    yetaPrc1000Vo.setUsrId(sessionUser.getUsrId());  
			              
			            
			       /******************************** 권한 ************************************************************************/
			              
			       yetaPrc1000Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(yetaPrc1000Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
			       yetaPrc1000Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(yetaPrc1000Vo.getDtilOccuInttnCd()).replace(",", ""));  
			            
			       if (yetaPrc1000Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(yetaPrc1000Vo.getDeptCd()))) { 
                       yetaPrc1000Vo.setDeptCd("");  //부서코드
                     } 
			       
					yetaPrc1000Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
					yetaPrc1000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
					yetaPrc1000Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
					yetaPrc1000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
		  	   
					InfcPkgYeta1000VO creInfcPkgYeta1000Vo = new InfcPkgYeta1000VO();  //마감테이블  
				 
					//신규 생성시 데이터가존재하는경우 처리 
					//creInfcPkgYeta1000Vo = yetaPayr6420Create.selectYeta0100ToChkInfcPkgYeta1000(yetaPrc1000Vo);   //yeta1000
					
					
					dataCheck = yetaPayr6420Create.fnPayr06420_PAYR420_2014_CREATE_Insert(yetaPrc1000Vo);   //yeta1000
		  	        
		  	        
		  	        
		        }    
		        
              if (MSFSharedUtils.paramNull(dataCheck)) {
            	  
			  	        tpInfcPkgYeta1000Vo = yetaPayr6420Create.selectYeta0100ToCreateYetaPrc1000(yetaPrc1000Vo);   //yeta1000
			  	        
			  	      if (MSFSharedUtils.paramNotNull(tpInfcPkgYeta1000Vo)) {
			  	    	   yetaPrc1000Vo.setEdacSeilNum(tpInfcPkgYeta1000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
					  	      // {급여내역생성 -417}
					         //  {**************************급여내역 생성 2********************************}
					        yetaPrc3210Vo.setDpobCd(yetaPrc1000Vo.getDpobCd());     /** 사업장코드 */
					        yetaPrc3210Vo.setEdacRvyy(yetaPrc1000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
					        yetaPrc3210Vo.setSettGbcd(yetaPrc1000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
					        yetaPrc3210Vo.setSystemkey( yetaPrc1000Vo.getSystemkey());    /** column systemkey : systemkey */
					      //  yetaPrc3210Vo.setEdacSeilNum(yetaPrc1000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
					        yetaPrc3210Vo.setPayrMangDeptCd(yetaPrc1000Vo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
					        yetaPrc3210Vo.setDeptCd(yetaPrc1000Vo.getDeptCd());    /** column 부서코드 : deptCd */
					        yetaPrc3210Vo.setTypOccuCd(yetaPrc1000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
					        yetaPrc3210Vo.setDtilOccuClsDivCd(yetaPrc1000Vo.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
					        yetaPrc3210Vo.setPyspGrdeCd(yetaPrc1000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
					        yetaPrc3210Vo.setDtilOccuInttnCd(yetaPrc1000Vo.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
					        yetaPrc3210Vo.setBusinCd(yetaPrc1000Vo.getBusinCd());    /** column 사업코드 : businCd */
					        yetaPrc3210Vo.setEmymtDivCd(yetaPrc1000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */ 
					        
					        yetaPrc3210Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
					        yetaPrc3210Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
					        yetaPrc3210Vo.setUsrId(sessionUser.getUsrId());  
					              
					            
					       /******************************** 권한 ************************************************************************/
					              
					        yetaPrc3210Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(yetaPrc1000Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
					        yetaPrc3210Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(yetaPrc1000Vo.getDtilOccuInttnCd()).replace(",", ""));  
					            
					        if (yetaPrc1000Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(yetaPrc1000Vo.getDeptCd()))) { 
					        	yetaPrc3210Vo.setDeptCd("");  //부서코드
			                } 
					       
					        yetaPrc3210Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
					        yetaPrc3210Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
					        yetaPrc3210Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
					        yetaPrc3210Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
					        dataCheck = "";
					        dataCheck = yetaPayr6420Create.fnPayr06420_PAYR417_2014_CREATE_Insert(yetaPrc3210Vo);   //yetaPrc3210Vo  
					  	    
					  	     bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "급여내역생성.","데이타확인","")); 
					  	 // {연말정산기본생성 - 415}
				         //    {**************************연말정산기본생성 [3]********************************}
					  	    
					  	   if (MSFSharedUtils.paramNull(dataCheck)) {
					  		   
					  	   
									yetaPrc2000Vo.setDpobCd(yetaPrc1000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
									yetaPrc2000Vo.setEdacRvyy(yetaPrc1000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
									yetaPrc2000Vo.setSettGbcd(yetaPrc1000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
									yetaPrc2000Vo.setSystemkey(yetaPrc1000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
									yetaPrc2000Vo.setEdacSeilNum(yetaPrc1000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
									yetaPrc2000Vo.setPayrMangDeptCd(yetaPrc1000Vo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
									yetaPrc2000Vo.setEmymtDivCd(yetaPrc1000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
									//yetaPrc2000Vo.setHanNm(yetaPrc1000Vo.getHanNm());    /** column 한글성명 : hanNm */
									//yetaPrc2000Vo.setResnRegnNum(yetaPrc1000Vo.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
									yetaPrc2000Vo.setDeptCd(yetaPrc1000Vo.getDeptCd());    /** column 부서코드 : deptCd */
									yetaPrc2000Vo.setBusinCd(yetaPrc1000Vo.getBusinCd());    /** column 사업코드 : businCd */
									yetaPrc2000Vo.setTypOccuCd(yetaPrc1000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
									yetaPrc2000Vo.setDtilOccuInttnCd(yetaPrc1000Vo.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
									yetaPrc2000Vo.setDtilOccuClsDivCd(yetaPrc1000Vo.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
									//yetaPrc2000Vo.setOdtyCd(yetaPrc1000Vo.getOdtyCd());    /** column 직책코드 : odtyCd */
									//yetaPrc2000Vo.setPyspCd(yetaPrc1000Vo.getPyspCd());    /** column 호봉코드 : pyspCd */
									yetaPrc2000Vo.setPyspGrdeCd(yetaPrc1000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
									
									yetaPrc2000Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
									yetaPrc2000Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
									yetaPrc2000Vo.setUsrId(sessionUser.getUsrId());  
								              
								               
								     /******************************** 권한 ************************************************************************/
								              
									yetaPrc2000Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(yetaPrc1000Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
									yetaPrc2000Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(yetaPrc1000Vo.getDtilOccuInttnCd()).replace(",", ""));  
								        
									 if (yetaPrc1000Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(yetaPrc1000Vo.getDeptCd()))) { 
										 yetaPrc2000Vo.setDeptCd("");  //부서코드
						                } 
								        
									yetaPrc2000Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
									yetaPrc2000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
									yetaPrc2000Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
									yetaPrc2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */ 
									dataCheck = "";
									dataCheck = yetaPayr6420Create.fnPayr06420_PAYR415_2014_CREATE_Insert(yetaPrc2000Vo);   //yetaPrc2000Vo 
						  	        bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "연말정산기본정보생성.","데이타확인","")); 
										  	        //{비과세 감면 인서트 }
								              //	 {**************************연말정산기본 비과세 감면 생성  [4]********************************} 
										  	        
						  	      if (MSFSharedUtils.paramNull(dataCheck)) {
						  	    	  
						  	    	dataCheck = "";
						  	    	dataCheck =   yetaPayr6420Create.fnPayr06420_YETA3200_2015_CREATE_Insert(yetaPrc2000Vo);   //yetaPrc3200Vo 
										  	        
										  	       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "비과세감면 생성.","데이타확인","")); 
								
										   if (MSFSharedUtils.paramNull(dataCheck)) {	  	       
										  	       //      {가족사항 인서트 410 }
										    //     {**************************가족사항 [4]********************************}
										          //2015년 한부모공제 추가
										  	     dataCheck = "";
										  	     dataCheck =   yetaPayr6420Create.fnPayr06430_PAYR410_2014_CREATE_Insert(yetaPrc2000Vo);   //yetaPrc3220Vo   
										  	    
										  	       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "가족사항 생성.","데이타확인","")); 
										   if (MSFSharedUtils.paramNull(dataCheck)) {       
										  	    // {가족사항 업데이트 410 고용/건강보험료외 업데이트  }
										        // {**************************가족사항 [4_1]********************************}
										          //2014년 고용건강보험료외 업데이트 
										  	       yetaPayr6420Create.fnPayr06430_PAYR410_2014_INSU_FETC_Update(yetaPrc2000Vo);   //yetaPrc3220Vo   
										  	       
										  	       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "가족사항 생성.","데이타확인",""));
										  	       
										  	  // {**************************부녀자공제 [5]********************************}
									          // {부녀자공제란 여성근로소득자 본인인경우 업데이트 처리 }/
									           
										  	       yetaPayr6420Create.fnPayr06430_PAYR410_2014_CREATE_Update(yetaPrc2000Vo);   //yetaPrc3220Vo   
									               bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "가족사항 수정.","데이타확인",""));
									          
									           //{**************************이월기부금  [6]********************************}
										       //   {이월기부금  443 인서트 }
									       if (MSFSharedUtils.paramNull(dataCheck)) {
									               dataCheck = "";
										  	    	dataCheck =    yetaPayr6420Create.fnPayr06430_PAYR443_2014_CREATE_Insert(yetaPrc2000Vo);   //yetaPrc3190Vo   
									              bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "이월기부금 생성.","데이타확인",""));
									           
									        //   {**************************연말정산상세  [7]********************************}
										     //    {연말정산상세 425 인서트 } 
									              if (MSFSharedUtils.paramNull(dataCheck)) {
									                 dataCheck = "";
										  	    	dataCheck =    yetaPayr6420Create.fnPayr06430_PAYR425_2014_CREATE_Insert(yetaPrc2000Vo);   //yetaPrc3000Vo   
									                 bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "연말정산 정산일부.","데이타확인",""));
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
	   	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
   	 
      } 
	  	   
	  	  return  retval;
    }
    
    
    /**
     * 
     * <pre>
     * 1. 개요 : yeta0100 연말정산 대상자 생성  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : funcYetaPayr06420_All_Create
     * @date : Jan 26, 2016
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Jan 26, 2016		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param request
     * @param yetaPrc1000Vo
     * @return
     * @throws Exception
     */
     private PagingLoadResult<ShowMessageBM> funcYetaPayr06420_All_Add_Create(HttpServletRequest request,InfcPkgYeta1000VO yetaPrc1000Vo)  throws Exception  {
     	
     	  PagingLoadResult<ShowMessageBM> retval = null; 
 	      List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
 	  	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
 	  	  
 	 	InfcPkgYeta1000VO tpInfcPkgYeta1000Vo = new InfcPkgYeta1000VO();  //마감테이블   
         InfcPkgYeta3120VO yetaPrc3120Vo = new InfcPkgYeta3120VO();  //거주자주택자금_금전소비대차  
         InfcPkgYeta3160VO yetaPrc3160Vo = new InfcPkgYeta3160VO();  //거주자주택자금_임대차  
         InfcPkgYeta3100VO yetaPrc3100Vo = new InfcPkgYeta3100VO();  //연금_저축공제
         InfcPkgYeta3130VO yetaPrc3130Vo = new InfcPkgYeta3130VO();  //주택자금_월세
         InfcPkgYeta3140VO yetaPrc3140Vo = new InfcPkgYeta3140VO();  //의료비
   	    InfcPkgYeta3180VO yetaPrc3180Vo = new InfcPkgYeta3180VO();  //기부금 명세 
   	    InfcPkgYeta3170VO yetaPrc3170Vo = new InfcPkgYeta3170VO();  //이월기부금명세
   	    InfcPkgYeta3190VO yetaPrc3190Vo = new InfcPkgYeta3190VO();  //이월기부금temp
   	    InfcPkgYeta3110VO yetaPrc3110Vo = new InfcPkgYeta3110VO();  //종전근무지명세 
   	    InfcPkgYeta3200VO yetaPrc3200Vo = new InfcPkgYeta3200VO();  //비과세감면소득  
   	    InfcPkgYeta3220VO yetaPrc3220Vo = new InfcPkgYeta3220VO();  //가족사항  
   	    InfcPkgYeta3150VO yetaPrc3150Vo = new InfcPkgYeta3150VO();  //교육비
   	    InfcPkgYeta3210VO yetaPrc3210Vo = new InfcPkgYeta3210VO();  //급여내역
   	    InfcPkgYeta3300VO yetaPrc3300Vo = new InfcPkgYeta3300VO();  //비과세감면소득정산  
   	    InfcPkgYeta3000VO yetaPrc3000Vo = new InfcPkgYeta3000VO();  //연말정산결과  
         InfcPkgYeta2000VO yetaPrc2000Vo = new InfcPkgYeta2000VO();  //연말정산기본  
         
         String dataCheck = ""; 
 	  	  try { 
 	  		   
 		  	   if  (yetaPayr6420Create == null) { 
 	               WebApplicationContext wac = WebApplicationContextUtils.
 	                       getRequiredWebApplicationContext( request.getSession().getServletContext());
 	   
 	               yetaPayr6420Create = (YetaPayr6420Service) wac.getBean("YetaPayr6420CreateService"); 
 	              
 	            }
 		  	   
 		  	 
 		     //   if (MSFSharedUtils.paramNull(yetaPrc1000Vo.getSystemkey()))  { 
 		         
 		           // {마감정보 생성 }

 		           //   {**************************마감정보 1********************************} 

 					yetaPrc1000Vo.setEdacRvyy(yetaPrc1000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
 					yetaPrc1000Vo.setSettGbcd(yetaPrc1000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
 					yetaPrc1000Vo.setEdacSeilNum(yetaPrc1000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
 					yetaPrc1000Vo.setPayrMangDeptCd(yetaPrc1000Vo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
 					yetaPrc1000Vo.setDeptCd(yetaPrc1000Vo.getDeptCd());    /** column 부서코드 : deptCd */
 					yetaPrc1000Vo.setTypOccuCd(yetaPrc1000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
 					yetaPrc1000Vo.setDtilOccuClsDivCd(yetaPrc1000Vo.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
 					yetaPrc1000Vo.setPyspGrdeCd(yetaPrc1000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
 					yetaPrc1000Vo.setDtilOccuInttnCd(yetaPrc1000Vo.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
 					yetaPrc1000Vo.setBusinCd(yetaPrc1000Vo.getBusinCd());    /** column 사업코드 : businCd */
 					yetaPrc1000Vo.setEmymtDivCd(yetaPrc1000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
 					yetaPrc1000Vo.setPernChrgEmpIdenNum(sessionUser.getUsrId());    /** column 생성직원번호 : pernChrgEmpIdenNum yetaPrc1000Vo.getPernChrgEmpIdenNum()*/
// 					yetaPrc1000Vo.setClosFlag(yetaPrc1000Vo.getClosFlag());    /** column 마감여부 : closFlag */
// 					yetaPrc1000Vo.setClosCont(yetaPrc1000Vo.getClosCont());    /** column 마감건수 : closCont */
// 					yetaPrc1000Vo.setClosDate(yetaPrc1000Vo.getClosDate());    /** column 마감일자 : closDate */
// 					yetaPrc1000Vo.setEdacPrdt(yetaPrc1000Vo.getEdacPrdt());    /** column 연말정산제출일자 : edacPrdt */
// 					yetaPrc1000Vo.setReprName(yetaPrc1000Vo.getReprName());    /** column 대표자성명 : reprName */
// 					yetaPrc1000Vo.setJuriName(yetaPrc1000Vo.getJuriName());    /** column 법인명_상호 : juriName */
// 					yetaPrc1000Vo.setBusiNumb(yetaPrc1000Vo.getBusiNumb());    /** column 사업자등록번호 : busiNumb */
// 					yetaPrc1000Vo.setResuNumb(yetaPrc1000Vo.getResuNumb());    /** column 주민등록번호 : resuNumb */
// 					yetaPrc1000Vo.setJuriNumb(yetaPrc1000Vo.getJuriNumb());    /** column 법인번호 : juriNumb */
// 					yetaPrc1000Vo.setIncmPost(yetaPrc1000Vo.getIncmPost());    /** column 소득신고의무자우편번호 : incmPost */
// 					yetaPrc1000Vo.setIncmAddr(yetaPrc1000Vo.getIncmAddr());    /** column 소득신고의무자기본주소 : incmAddr */
// 					yetaPrc1000Vo.setIncmAdtl(yetaPrc1000Vo.getIncmAdtl());    /** column 소득신고의무자상세주소 : incmAdtl */
// 					yetaPrc1000Vo.setTaxaCode(yetaPrc1000Vo.getTaxaCode());    /** column 관할세무서코드 : taxaCode */
// 					yetaPrc1000Vo.setIncmGbcd(yetaPrc1000Vo.getIncmGbcd());    /** column 제출자구분코드 : incmGbcd */
// 					yetaPrc1000Vo.setTaxaDnum(yetaPrc1000Vo.getTaxaDnum());    /** column 세무대리인번호 : taxaDnum */
// 					yetaPrc1000Vo.setHomeTxid(yetaPrc1000Vo.getHomeTxid());    /** column 홈텍스ID : homeTxid */
// 					yetaPrc1000Vo.setTaxaPrcd(yetaPrc1000Vo.getTaxaPrcd());    /** column 세무프로그램코드 : taxaPrcd */
// 					yetaPrc1000Vo.setCharDept(yetaPrc1000Vo.getCharDept());    /** column 담당자부서명 : charDept */
// 					yetaPrc1000Vo.setCharName(yetaPrc1000Vo.getCharName());    /** column 담당자성명 : charName */
// 					yetaPrc1000Vo.setCharTele(yetaPrc1000Vo.getCharTele());    /** column 담당자전화번호 : charTele */
// 					yetaPrc1000Vo.setFilePass(yetaPrc1000Vo.getFilePass());    /** column FILE_PASS : filePass */
 					yetaPrc1000Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
 				    yetaPrc1000Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
 				    yetaPrc1000Vo.setUsrId(sessionUser.getUsrId());  
 			              
 			            
 			       /******************************** 권한 ************************************************************************/
 			              
 			       yetaPrc1000Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(yetaPrc1000Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
 			       yetaPrc1000Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(yetaPrc1000Vo.getDtilOccuInttnCd()).replace(",", ""));  
 			            
 			       if (yetaPrc1000Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(yetaPrc1000Vo.getDeptCd()))) { 
                        yetaPrc1000Vo.setDeptCd("");  //부서코드
                      } 
 			       
 					yetaPrc1000Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
 					yetaPrc1000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
 					yetaPrc1000Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
 					yetaPrc1000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
 		  	   
 					InfcPkgYeta1000VO creInfcPkgYeta1000Vo = new InfcPkgYeta1000VO();  //마감테이블  
 				 
 					//신규 생성시 데이터가존재하는경우 처리 
 					//creInfcPkgYeta1000Vo = yetaPayr6420Create.selectYeta0100ToChkInfcPkgYeta1000(yetaPrc1000Vo);   //yeta1000
 					
 					
 		  	      //  yetaPayr6420Create.fnPayr06420_PAYR420_2014_CREATE_Insert(yetaPrc1000Vo);   //yeta1000
 		  	        
 		  	        
 		  	        tpInfcPkgYeta1000Vo = yetaPayr6420Create.selectYeta0100ToCreateYetaPrc1000(yetaPrc1000Vo);   //yeta1000
 		  	       
 		  	        yetaPrc1000Vo.setEdacSeilNum(tpInfcPkgYeta1000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
 		  	      
 		  	        
 		  	        yetaPrc1000Vo.setAddCheck("ADD");   //추가 여부에 따른 기존데이타 스킾처리하는 루틴 추가 
 		  	        
 		    //    }    
 		  	   
 		  	      
 		  	      
 		  	      // {급여내역생성 -417}
 		         //  {**************************급여내역 생성 2********************************}
 		        yetaPrc3210Vo.setDpobCd(yetaPrc1000Vo.getDpobCd());     /** 사업장코드 */
 		        yetaPrc3210Vo.setEdacRvyy(yetaPrc1000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
 		        yetaPrc3210Vo.setSettGbcd(yetaPrc1000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
 		        yetaPrc3210Vo.setSystemkey( yetaPrc1000Vo.getSystemkey());    /** column systemkey : systemkey */
 		      //  yetaPrc3210Vo.setEdacSeilNum(yetaPrc1000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
 		        yetaPrc3210Vo.setPayrMangDeptCd(yetaPrc1000Vo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
 		        yetaPrc3210Vo.setDeptCd(yetaPrc1000Vo.getDeptCd());    /** column 부서코드 : deptCd */
 		        yetaPrc3210Vo.setTypOccuCd(yetaPrc1000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
 		        yetaPrc3210Vo.setDtilOccuClsDivCd(yetaPrc1000Vo.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
 		        yetaPrc3210Vo.setPyspGrdeCd(yetaPrc1000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
 		        yetaPrc3210Vo.setDtilOccuInttnCd(yetaPrc1000Vo.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
 		        yetaPrc3210Vo.setBusinCd(yetaPrc1000Vo.getBusinCd());    /** column 사업코드 : businCd */
 		        yetaPrc3210Vo.setEmymtDivCd(yetaPrc1000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */ 
 		        
 		        yetaPrc3210Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
 		        yetaPrc3210Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
 		        yetaPrc3210Vo.setUsrId(sessionUser.getUsrId());  
 		       yetaPrc3210Vo.setAddCheck("ADD");   //추가 여부에 따른 기존데이타 스킾처리하는 루틴 추가 
 		            
 		       /******************************** 권한 ************************************************************************/
 		              
 		        yetaPrc3210Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(yetaPrc1000Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
 		        yetaPrc3210Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(yetaPrc1000Vo.getDtilOccuInttnCd()).replace(",", ""));  
 		            
 		        if (yetaPrc1000Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(yetaPrc1000Vo.getDeptCd()))) { 
 		        	yetaPrc3210Vo.setDeptCd("");  //부서코드
                 } 
 		       
 		        yetaPrc3210Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
 		        yetaPrc3210Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
 		        yetaPrc3210Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
 		        yetaPrc3210Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
 		     
 		        dataCheck = "";
	  	    	dataCheck =  yetaPayr6420Create.fnPayr06420_PAYR417_2014_CREATE_Insert(yetaPrc3210Vo);   //yetaPrc3210Vo  
 		  	    
 		  	     bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "급여내역생성.","데이타확인","")); 
 		  	
 		  	  if (MSFSharedUtils.paramNull(dataCheck)) {   
 		  	     // {연말정산기본생성 - 415}
 	         //    {**************************연말정산기본생성 [3]********************************}
 		  	    

 					yetaPrc2000Vo.setDpobCd(yetaPrc1000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
 					yetaPrc2000Vo.setEdacRvyy(yetaPrc1000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
 					yetaPrc2000Vo.setSettGbcd(yetaPrc1000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
 					yetaPrc2000Vo.setSystemkey(yetaPrc1000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
 					yetaPrc2000Vo.setEdacSeilNum(yetaPrc1000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
 					yetaPrc2000Vo.setPayrMangDeptCd(yetaPrc1000Vo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
 					yetaPrc2000Vo.setEmymtDivCd(yetaPrc1000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
 					//yetaPrc2000Vo.setHanNm(yetaPrc1000Vo.getHanNm());    /** column 한글성명 : hanNm */
 					//yetaPrc2000Vo.setResnRegnNum(yetaPrc1000Vo.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
 					yetaPrc2000Vo.setDeptCd(yetaPrc1000Vo.getDeptCd());    /** column 부서코드 : deptCd */
 					yetaPrc2000Vo.setBusinCd(yetaPrc1000Vo.getBusinCd());    /** column 사업코드 : businCd */
 					yetaPrc2000Vo.setTypOccuCd(yetaPrc1000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
 					yetaPrc2000Vo.setDtilOccuInttnCd(yetaPrc1000Vo.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
 					yetaPrc2000Vo.setDtilOccuClsDivCd(yetaPrc1000Vo.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
 					//yetaPrc2000Vo.setOdtyCd(yetaPrc1000Vo.getOdtyCd());    /** column 직책코드 : odtyCd */
 					//yetaPrc2000Vo.setPyspCd(yetaPrc1000Vo.getPyspCd());    /** column 호봉코드 : pyspCd */
 					yetaPrc2000Vo.setPyspGrdeCd(yetaPrc1000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
 					
 					yetaPrc2000Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
 					yetaPrc2000Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
 					yetaPrc2000Vo.setUsrId(sessionUser.getUsrId());  
 				              
 					yetaPrc2000Vo.setAddCheck("ADD");   //추가 여부에 따른 기존데이타 스킾처리하는 루틴 추가 
 				     /******************************** 권한 ************************************************************************/
 				              
 					yetaPrc2000Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(yetaPrc1000Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
 					yetaPrc2000Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(yetaPrc1000Vo.getDtilOccuInttnCd()).replace(",", ""));  
 				        
 					 if (yetaPrc1000Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(yetaPrc1000Vo.getDeptCd()))) { 
 						 yetaPrc2000Vo.setDeptCd("");  //부서코드
 		                } 
 				        
 					yetaPrc2000Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
 					yetaPrc2000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
 					yetaPrc2000Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
 					yetaPrc2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */ 
 		  	    
 					
 					dataCheck = "";
 		  	    	dataCheck = yetaPayr6420Create.fnPayr06420_PAYR415_2014_CREATE_Insert(yetaPrc2000Vo);   //yetaPrc2000Vo 
 		  	        bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "연말정산기본정보생성.","데이타확인","")); 
 		  	 
 		  	     if (MSFSharedUtils.paramNull(dataCheck)) {   
 		  	        //{비과세 감면 인서트 }
               //	 {**************************연말정산기본 비과세 감면 생성  [4]********************************} 
 		  	        
 		  	        
 		  	    	dataCheck = "";
 		  	    	dataCheck = yetaPayr6420Create.fnPayr06420_YETA3200_2015_CREATE_Insert(yetaPrc2000Vo);   //yetaPrc3200Vo 
 		  	        
 		  	       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "비과세감면 생성.","데이타확인","")); 
 		  	
 		  	     if (MSFSharedUtils.paramNull(dataCheck)) {   
 		  	       //      {가족사항 인서트 410 }
 		           //     {**************************가족사항 [4]********************************}
 		          //2015년 한부모공제 추가
 		  	    	dataCheck = "";
 		  	    	dataCheck =  yetaPayr6420Create.fnPayr06430_PAYR410_2014_CREATE_Insert(yetaPrc2000Vo);   //yetaPrc3220Vo   
 		  	    
 		  	       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "가족사항 생성.","데이타확인","")); 
 		  	    if (MSFSharedUtils.paramNull(dataCheck)) {         
		 		  	    // {가족사항 업데이트 410 고용/건강보험료외 업데이트  }
		 		        // {**************************가족사항 [4_1]********************************}
		 		          //2014년 고용건강보험료외 업데이트 
		 		  	       yetaPayr6420Create.fnPayr06430_PAYR410_2014_INSU_FETC_Update(yetaPrc2000Vo);   //yetaPrc3220Vo   
		 		  	       
		 		  	       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "가족사항 생성.","데이타확인",""));
		 		  	       
		 		  	  // {**************************부녀자공제 [5]********************************}
		 	          // {부녀자공제란 여성근로소득자 본인인경우 업데이트 처리 }/
		 	           
		 	               yetaPayr6420Create.fnPayr06430_PAYR410_2014_CREATE_Update(yetaPrc2000Vo);   //yetaPrc3220Vo   
		 	               bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "가족사항 수정.","데이타확인",""));
		 	          
		 	           //{**************************이월기부금  [6]********************************}
		 		       //   {이월기부금  443 인서트 }
		 	              if (MSFSharedUtils.paramNull(dataCheck)) {        
			 	              dataCheck = "";
			 		  	    	dataCheck = yetaPayr6420Create.fnPayr06430_PAYR443_2014_CREATE_Insert(yetaPrc2000Vo);   //yetaPrc3190Vo   
			 	              bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "이월기부금 생성.","데이타확인",""));
			 	           
			 	        //   {**************************연말정산상세  [7]********************************}
			 		     //    {연말정산상세 425 인서트 } 
			 	             if (MSFSharedUtils.paramNull(dataCheck)) {    
				 	             dataCheck = "";
				 		  	    	dataCheck = yetaPayr6420Create.fnPayr06430_PAYR425_2014_CREATE_Insert(yetaPrc2000Vo);   //yetaPrc3000Vo   
				 	             bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "연말정산 정산일부.","데이타확인",""));
			 	             }
		 	              }
 		  	        }
 		  	     }
 		  	     }
 		  	  } 
 	             bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "대상자 생성이 완료되었습니다.","데이타확인",""));  
 		  	        
 	  	} catch (Exception ex) {
            
 	   	   ShowMessageBM smBm = new ShowMessageBM();
 	   	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
 	   	   smBm.setMenu("Yeta");
 	   	   smBm.setPhase("[연말정산대상자]대상자생성에러");
 	   	   smBm.setMessage(ex.getLocalizedMessage());
 	   	   smBm.setContent(ex.getMessage());
 	   	   bmResult.add(smBm);  
 	   	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
    	 
       } 
 	  	   
 	  	  return  retval;
     }
    
    
    /**
     * 
     * <pre>
     * 1. 개요 : 대상자 별 세액 계산   
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : funcYeta0300Payr06430CalcTax
     * @date : Jan 26, 2016
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Jan 26, 2016		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param request
     * @param lstInfcPkgYeta2000Vo
     * @return
     * @throws Exception
     */
    private PagingLoadResult<ShowMessageBM> funcYeta0300Payr06430CalcTax(HttpServletRequest request,List<InfcPkgYeta2000VO>  lstInfcPkgYeta2000Vo)  throws Exception  {
    	
  	      PagingLoadResult<ShowMessageBM> retval = null; 
	      List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	  	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
	  	  
//	 	InfcPkgYeta1000VO tpInfcPkgYeta1000Vo = new InfcPkgYeta1000VO();  //마감테이블   
//        InfcPkgYeta3120VO yetaPrc3120Vo = new InfcPkgYeta3120VO();  //거주자주택자금_금전소비대차  
//        InfcPkgYeta3160VO yetaPrc3160Vo = new InfcPkgYeta3160VO();  //거주자주택자금_임대차  
//        InfcPkgYeta3100VO yetaPrc3100Vo = new InfcPkgYeta3100VO();  //연금_저축공제
//        InfcPkgYeta3130VO yetaPrc3130Vo = new InfcPkgYeta3130VO();  //주택자금_월세
//        InfcPkgYeta3140VO yetaPrc3140Vo = new InfcPkgYeta3140VO();  //의료비
//	    InfcPkgYeta3180VO yetaPrc3180Vo = new InfcPkgYeta3180VO();  //기부금 명세 
//	    InfcPkgYeta3170VO yetaPrc3170Vo = new InfcPkgYeta3170VO();  //이월기부금명세
//	    InfcPkgYeta3190VO yetaPrc3190Vo = new InfcPkgYeta3190VO();  //이월기부금temp
//	    InfcPkgYeta3110VO yetaPrc3110Vo = new InfcPkgYeta3110VO();  //종전근무지명세 
//	    InfcPkgYeta3200VO yetaPrc3200Vo = new InfcPkgYeta3200VO();  //비과세감면소득  
//	    InfcPkgYeta3220VO yetaPrc3220Vo = new InfcPkgYeta3220VO();  //가족사항  
//	    InfcPkgYeta3150VO yetaPrc3150Vo = new InfcPkgYeta3150VO();  //교육비
//	    InfcPkgYeta3210VO yetaPrc3210Vo = new InfcPkgYeta3210VO();  //급여내역
//	    InfcPkgYeta3300VO yetaPrc3300Vo = new InfcPkgYeta3300VO();  //비과세감면소득정산  
      
//	    
//        InfcPkgYeta2000VO yetaPrc2000Vo = new InfcPkgYeta2000VO();  //연말정산기본  
      
        
        
        // 변수선언 
	  	int statCnt = 0;
	  	String dataCheck = "";
	  	BigDecimal  mTemp14Data10 = BigDecimal.ZERO;
 
         BigDecimal  mTemp14Data40 = BigDecimal.ZERO;
         BigDecimal  mTemp14Data41 = BigDecimal.ZERO;
        BigDecimal mTempData10  = BigDecimal.ZERO;
        BigDecimal mTempData30  = BigDecimal.ZERO; 
        BigDecimal  mTempData  = BigDecimal.ZERO;
        BigDecimal  mTempData31  = BigDecimal.ZERO; 
        BigDecimal mTempData40  = BigDecimal.ZERO; 
        BigDecimal mTempData41  = BigDecimal.ZERO;
        BigDecimal mTempData42  = BigDecimal.ZERO;
        BigDecimal mTempOData10   = BigDecimal.ZERO;
        BigDecimal mTempOData40  = BigDecimal.ZERO; 
        BigDecimal mTempOData41  = BigDecimal.ZERO;
        BigDecimal mTempOData42  = BigDecimal.ZERO;
        BigDecimal exPRDD_TAXN   = BigDecimal.ZERO;
        BigDecimal exTAXD_ICAX   = BigDecimal.ZERO;
        BigDecimal exTAXD_SPCT   = BigDecimal.ZERO;
        BigDecimal exTXLG_CL30   = BigDecimal.ZERO;
        BigDecimal exTXLG_HXTT   = BigDecimal.ZERO;
        BigDecimal exTAXD_TSUM   = BigDecimal.ZERO;
        BigDecimal exTAXD_WKEN   = BigDecimal.ZERO;
        BigDecimal exADDR_MCCR   = BigDecimal.ZERO;
        BigDecimal exJRTR_HICT   = BigDecimal.ZERO;
        BigDecimal exJRTR_PSRN   = BigDecimal.ZERO;
        BigDecimal exJRTR_HNSV    = BigDecimal.ZERO;
        BigDecimal exSPCI_RTDE   = BigDecimal.ZERO;
        BigDecimal exSPCI_TXCR   = BigDecimal.ZERO;
        BigDecimal exSPED_TXCR   = BigDecimal.ZERO;
        BigDecimal exTAXD_PLTC   = BigDecimal.ZERO;
        BigDecimal exSPCI_PLTC   = BigDecimal.ZERO;
        BigDecimal exSPCI_FBAM   = BigDecimal.ZERO;
        BigDecimal  exSPCI_RFAM  = BigDecimal.ZERO;
        BigDecimal exSPCI_NAMT   = BigDecimal.ZERO;
        BigDecimal exSPCI_DCTO   = BigDecimal.ZERO;
        BigDecimal exSPCI_DDCT   = BigDecimal.ZERO;
        BigDecimal exTAXD_UNIN   = BigDecimal.ZERO;
        BigDecimal exTAXD_LOAN   = BigDecimal.ZERO;
        BigDecimal exTAXD_PAID   = BigDecimal.ZERO;
        BigDecimal exSPCI_RTAM   = BigDecimal.ZERO;                  
        BigDecimal exTAXD_CSUM   = BigDecimal.ZERO;
        BigDecimal exTpPRDD_TAXN   = BigDecimal.ZERO;
        BigDecimal exSPCI_YAMT   = BigDecimal.ZERO;
        BigDecimal exADDR_CHLD   = BigDecimal.ZERO; 
        BigDecimal exADDR_BRTH   = BigDecimal.ZERO;
        BigDecimal exSPCI_GURT   = BigDecimal.ZERO;
        BigDecimal exSPCI_HDRC   = BigDecimal.ZERO;
        
      
	  	  try { 
	  		   
		  	   if  (yetaPayr6430Service == null) { 
	               WebApplicationContext wac = WebApplicationContextUtils.
	                       getRequiredWebApplicationContext( request.getSession().getServletContext());
	   
	               yetaPayr6430Service = (YetaPayr6430Service) wac.getBean("YetaPayr6430Service"); 
	              
	            }
		  	   
		  	  
		  	  /************************* 대상자별로 루프 시작 ***************************************************/ 
		  	   for (int iCnt01 = 0;iCnt01 < lstInfcPkgYeta2000Vo.size();iCnt01++) {
		  		    
		  		 InfcPkgYeta2000VO yetaPrc2000Vo = new InfcPkgYeta2000VO(); 
		  		 yetaPrc2000Vo = lstInfcPkgYeta2000Vo.get(iCnt01);  
		  		 yetaPrc2000Vo.setSpciDdctCheck("FALSE");
		        
		  		 //{의료비/기부금/교육비데이타 자료정리 루틴 추가 }
		  		 
		  		  statCnt = 0;
		  		  statCnt = yetaPayr6430Service.fnPayr06420_Yeta3140_ReTax_2015_CREATE_01_Update(yetaPrc2000Vo);  
		  	
		  	    if (statCnt >= 0) {
		  		  //{retax-1}
		  		 /**####################### fnPayr06420_PAYR415_ReTax_2014_CREATE_01_Update ##############*/ 
		  		 
		 		statCnt = 0;
		  		statCnt = yetaPayr6430Service.fnPayr06420_PAYR415_ReTax_2014_CREATE_01_Update(yetaPrc2000Vo);  
		  		
		  		//{retax-1-0}
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06420_Yeta3300_ReTax_2015_CREATE_01_1_Delete(yetaPrc2000Vo);
		  		  //{retax-1-1}
		  		  yetaPayr6430Service.fnPayr06420_Yeta3300_ReTax_2015_CREATE_01_1_Insert(yetaPrc2000Vo);
		  		 
                  //{retax-2}
                 /**####################### 연금/소득공제 추가 로직 ############################################*/  
                 //주택자금원리금상환액_거주자 /월세액납부
		  		if (statCnt >= 0) {   
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06420_PAYR415_ReTax_2014_CREATE_02_1_Update(yetaPrc2000Vo);  
                  

                
                 // {retax-3}
                 /**####################### 연연금/저축생성 신규추가 ############################################*/  
		  		if (statCnt >= 0) {  
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06420_PAYR415_ReTax_2014_CREATE_02_2_Update(yetaPrc2000Vo);  
               
 
                //{retax-4}
                 /**####################### 단계별금액 합계 ############################################*/ 
		  		if (statCnt >= 0) {  
		  		statCnt = 0;
		  		statCnt = yetaPayr6430Service.fnPayr06420_PAYR415_ReTax_2014_CREATE_02_Update(yetaPrc2000Vo); 
                 
                
                 // {공제대상금액 계산 루틴 추가 해야함...단계별 } 
                 // 공제계산하기 시작
                //{retax-5} 
                  /**####################### 공제단계 시작 01 ############################################*/ 
		  		if (statCnt >= 0) {  
		  		statCnt = 0;
		  		statCnt = yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_01_Update(yetaPrc2000Vo); 
                  
                   //소득공제 
                //  fnPayr06430_PAYR425_2014_CREATE_02_Update
                // {retax-6}
                 /**#######################  {공제단계 시작 -소득공제 02} ############################################*/ 
		  		if (statCnt >= 0) { 
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_02_Update(yetaPrc2000Vo); 
                   
                   // {retax-7}
                   /**#######################  {공제단계 시작 -연금보험료공제 03} ############################################*/ 
                 //      ---------------------------연금보험료공제--------------------------------------
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_03_Update(yetaPrc2000Vo); 
                  
                 //    {retax-8}
                 /**#######################  {공제단계 시작 -연금보험료공제 03} ############################################*/ 
                 //  ------------------------- 특별공제 - 보험료 -----------------------------------------
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_04_02_Update(yetaPrc2000Vo); 
                  
//               {retax-9} 
                  /**#######################  {공제단계 시작 -특별공제 - 주택임차차임금 상환액  09 } ############################################*/ 
                  //   ------------------특별공제 - 주택임차차임금 상환액---------------------------
		  		if (statCnt >= 0) { 
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_07_Update(yetaPrc2000Vo); 
                 
                //  {retax-10}
                 //   ------------------기타공제)주택마련저축---------------------------
                  /**#######################  {공제단계 시작 -특별공제 - 주택마련저축  10 } ############################################*/ 
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt = yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_07_1_Update(yetaPrc2000Vo); 
                  
                  //  {retax-11}
                  /**#######################  {공제단계 시작 -특별공제 - 주택마련저축 합계  10-1 } ############################################*/ 
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_07_3_Update(yetaPrc2000Vo); 
                  
                 //    {retax-12}
                 /**#######################  {공제단계 시작 -특별공제 - 장기주택이자상환액  10-2 } ############################################*/
		  		if (statCnt >= 0) { 
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_07_2_Update(yetaPrc2000Vo); 
                  
                  //    {retax-13}
                 /**#######################  {공제단계 시작 -특별공제 - 장기주택이자상환액 고정금리 비거치  10-3 } ############################################*/
		  		if (statCnt >= 0) { 
		  		statCnt = 0;
		  		statCnt = yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_07_4_Update(yetaPrc2000Vo); 
                  
                  //  {retax-14}
                  /**#######################  {공제단계 시작 -특별공제 - 장기주택이자상환액 기타 대출  10-4 } ############################################*/
		  		if (statCnt >= 0) { 
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_07_5_Update(yetaPrc2000Vo); 
                  
                 //{14-1}
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt = yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_07_5_1_Update(yetaPrc2000Vo);  
                 
                 
                  //  {retax-15}
                 /**#######################  기타로직  등 계산 로직 ############################################*/
		  		if (statCnt >= 0) { 
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_11_Update(yetaPrc2000Vo); 
                  
                  //  {retax-16}
                 /**#######################  신용카드  등 계산 로직  ############################################*/
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_11_1_Update(yetaPrc2000Vo); 
                  
                //  {retax-17}
                 /**#######################  {공제단계 시작 -연금보험료공제 연금보험료공제  대상금액 04}  ############################################*/
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_03_1_TG_Update(yetaPrc2000Vo); 
                  
                 //  {retax-18}
                   /**#######################  {공제단계 시작 -연금보험료공제 03_1 대상금액 구하는 로직 추가  05}############################################*/
                 // ---------------------------연금보험료공제--------------------------------------
		  		if (statCnt >= 0) { 
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_03_1_Update(yetaPrc2000Vo); 
                  
		  
                 //  {retax-19}
                 /**#######################  {공제단계 시작 -특별공제 - 보험료  06} ############################################*/
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt = yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_04_1_Update(yetaPrc2000Vo); 
                  
                 //{retax-20}
                 /**#######################  특별공제 - 보험료 ############################################*/
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt = yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_04_Update(yetaPrc2000Vo); 
                  
                 //  {retax-21}
                 /**#######################  {공제단계 시작 -특별공제 - 의료비 대상금액  07 - 1} ############################################*/
		  		if (statCnt >= 0) { 
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_05_01_Update(yetaPrc2000Vo); 
                  
                
                 //  {retax-22}
                  /**#######################  {공제단계 시작 -특별공제 - 의료비   07 -2 } ############################################*/
//               -----------------------특별공제 - 의료비 ------------------
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_05_Update(yetaPrc2000Vo); 
                 
              
                 
                 //    {retax-23}
                 /**####################### {공제단계 시작 -특별공제 - 교육비   08 -1 }  ############################################*/   
                  //    ----------------------특별공제 - 교육비 ---------------------
		  		if (statCnt >= 0) { 
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_06_01_Update(yetaPrc2000Vo); 
                  
                  
                  //    {retax-24}
                 //    ----------------------특별공제 - 교육비 ---------------------
                 /**#######################  {공제단계 시작 -특별공제 - 교육비 공제  08 -2 }  ############################################*/
		  		if (statCnt >= 0) { 
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_06_Update(yetaPrc2000Vo); 
                 
                  
                  
                 //     {retax-25}
		        /**####################### {공제단계 시작 -특별공제 - 기부금관계코드 오류 정정  11 }  ############################################*/
                 //   -------------------------기부금관계코드 오류 정정  ------------------------------
		  		if (statCnt >= 0) { 
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_06_1_Update(yetaPrc2000Vo); 
                  
               
                //   {retax-26}
                  /**#######################  {공제단계 시작 -특별공제 - 기부금공제   12   }  ############################################*/
                 //   -------------------------기부금공제 1 -이전월 포함.------------------------------
		  		if (statCnt >= 0) {  
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_08_Update(yetaPrc2000Vo); 
                 
                // {retax-27}
                 /**#######################  기부금공제 1 -귀속년도 법정기부금 ############################################*/
		  		if (statCnt >= 0) { 
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_08_01_Update(yetaPrc2000Vo); 
                 
                 
                   //{retax-28}
                   /**#######################  기부금공제 1 -귀속년도 법정기부금. ############################################*/
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_08_02_Update(yetaPrc2000Vo); 
                 
                 
               
                  // {retax-29}
                 /**#######################  이전월 기부금공제 특례기부금공제, 현재년도 우리사주조합2 ############################################*/
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_09_01_Update(yetaPrc2000Vo); 
                 
                 // {retax-29 - 1}
                 /**#######################   현재년도 우리사주조합 대상금액 구하기  ############################################*/
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_08_03_Update(yetaPrc2000Vo); 
                 
                 
                
                   // {retax-30}
                 /**#######################  기부금공제 2013년도 이전 종교단체/외 이월 기부금  ############################################*/
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_09_Update(yetaPrc2000Vo); 
                 
                
                 //  {retax-31}
                   /**#######################  기부금공제 특례기부금공제,당해년도 종교단체기부금 대상금액 ############################################*/
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_09_02_Update(yetaPrc2000Vo); 
                 
                 //  {retax-31}
                 /**#######################  기부금공제  2014 년도 종교단체기부금 대상금액 ############################################*/
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_09_03_Update(yetaPrc2000Vo); 
                 
                 
               
                 // {retax-32}
                 /**#######################  기부금공제 3 ############################################*/
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_10_Update(yetaPrc2000Vo); 
                  

                 
                 
                 /**$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ 기부금 처리 단계 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */
                // {*********공제단계 시작   ******************* }
               //  {2011년도 기부금 내역 정보 삭제  443 테이블에 필요없는데이터 삭제 - 삭제하면 다른 데이타 삭제로 제거  }
               //   {retax-33} TODO 확인 차후 추가하던지 하기 
                // yetaPayr6430Service.fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(yetaPrc2000Vo); 
                  
 
                 
                 // {공제단계 시작 -  기부금 내역 정보 삭제  442  -- 13 }
                 //   {retax-34}
                 /**#######################  기부금공제 3 ############################################*/
		  		if (statCnt >= 0) { 
		  		statCnt = 0;
		  		statCnt =   yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_10_1_Delete(yetaPrc2000Vo); 
                 
                
                   // {retax-35}
                   // {2011년도 이전 이월정산정리 작업 443 -> 442로이관}
               /**#######################  공제단계 시작 - 이전 이월정산정리 작업 443 -> 442로이관    -- 14 ############################################*/
		  		if (statCnt >= 0) {      
		  			dataCheck = "";
		  			dataCheck =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_10_2_Update(yetaPrc2000Vo); 
              
                 
                   //  {retax-36}
                   //  {2011년도 기부금 내역 정보 정산....00  }
                   //  {공제단계 시작 - 기부금 내역 정보 정산.     15 - 1 }
                     /**#######################  공제단계 시작 - 기부금 내역 정보 정산.     15 - 1 ############################################*/
		  	  if (MSFSharedUtils.paramNull(dataCheck)) {           
		  		dataCheck = "";
	  			dataCheck =   yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_10_1_Update(yetaPrc2000Vo); 
                 
                // {retax-37}
                // {  기부금 이월정산정리 작업 }
                // {2011-추가기능 시작 }

                 /**#######################   기부금 이월정산정리 작업 ############################################*/
                 
                 List listYetaGibu = yetaPayr6430Service.fnPayr06430_PAYR442_PAYR425_ReTax_2014_SelectFind(yetaPrc2000Vo);
                  
                 
                 if  (listYetaGibu.size() > 0) {

                	   Iterator<Map<String, Object>> iter = listYetaGibu.iterator(); 
    	        	   
    		            while ( iter.hasNext() ) { 
    		            	
    		               Map<String, Object> mapYetaGibu = (Map<String, Object>) iter.next(); 
                          // for(int iCnt = 0; iCnt < listYetaGibu.size();iCnt++) {
    		               
                         mTempData10 = BigDecimal.ZERO;
                         mTemp14Data10 = BigDecimal.ZERO;
                         mTempData30 = BigDecimal.ZERO;
                         mTempData31 = BigDecimal.ZERO;
                         mTempData40 = BigDecimal.ZERO;
                         mTempData41 = BigDecimal.ZERO;
                         mTempData42 = BigDecimal.ZERO;
                         mTemp14Data40 = BigDecimal.ZERO;
                         mTemp14Data41 = BigDecimal.ZERO;
                         mTempOData10 = BigDecimal.ZERO;
                         mTempOData40 = BigDecimal.ZERO;
                         mTempOData41 = BigDecimal.ZERO;
                         //mTempOData42 = BigDecimal.ZERO;

                         mTempData10  = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg10"),"0"));//oraQrySelect04.FieldByName('SPCI_FBTG_10').AsFloat;
                         mTemp14Data10  = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFb1410"),"0")); //2014
                         mTempData30  = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciExam30"),"0"));//oraQrySelect04.FieldByName('SPCI_EXAM_30').AsFloat;
                         mTempData31  = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciUnon31"),"0"));//oraQrySelect04.FieldByName('SPCI_UNON_31').AsFloat;
                         mTempData40  = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg40"),"0"));//oraQrySelect04.FieldByName('SPCI_NATG_40').AsFloat;
                         mTempData41  = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg41"),"0"));//oraQrySelect04.FieldByName('SPCI_YATG_41').AsFloat;
                         mTemp14Data40  = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa1440"),"0"));//oraQrySelect04.FieldByName('SPCI_NATG_40').AsFloat;
                         mTemp14Data41  = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa1441"),"0"));//oraQrySelect04.FieldByName('SPCI_YATG_41').AsFloat;
                         mTempData42  = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciHftg42"),"0"));   //우리사주조합기부금 
                       //  mTempData42 = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciRfam42"),"0"));//oraQrySelect04.FieldByName('SPCI_YATG_41').AsFloat;
                         mTempOData10 = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciObam10"),"0"));//oraQrySelect04.FieldByName('SPCI_OBAM_10').AsFloat;
                         mTempOData40 = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciOnam40"),"0"));//oraQrySelect04.FieldByName('SPCI_ONAM_40').AsFloat;
                         mTempOData41 = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciOyam41"),"0"));//oraQrySelect04.FieldByName('SPCI_OYAM_41').AsFloat;
                         //TODO 수정 
                        // mTempOData42 = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciExam30"),"0"));//oraQrySelect04.FieldByName('SPCI_OYAM_41').AsFloat;
                         
                         
                         // - 값 가지고 오기
                         //  {retax-38}
                         InfcPkgYeta3170SrhVO yetaPrc3170SrhVo =  new InfcPkgYeta3170SrhVO(); 
                         
                         yetaPrc3170SrhVo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                         yetaPrc3170SrhVo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                         yetaPrc3170SrhVo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                         yetaPrc3170SrhVo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                         
                         List listYeta3170 = yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_SelectFind(yetaPrc3170SrhVo);
                       
                        
                         if  (listYeta3170.size() > 0) {  

                             
                        	 //============================2014년도 기부금 정리 ================================
                             // 2014년도 다시 한번 루프 돌리기
                       	 for(int iCnt = 0; iCnt < listYeta3170.size();iCnt++) {
                               //2014
                             //    {retax-43}
                       		InfcPkgYeta3170VO yetaPrc3170Vo =  new InfcPkgYeta3170VO();
                       		InfcPkgYeta3170VO upInfcPkgYeta3170Vo =  new InfcPkgYeta3170VO(); 
                       	 
                       		Map tempMap = (Map)listYeta3170.get(iCnt);  

							yetaPrc3170Vo.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    /** column 사업장코드 : dpobCd */
							yetaPrc3170Vo.setEdacRvyy(MSFSharedUtils.allowNulls(tempMap.get("edacRvyy")));    /** column 연말정산귀속년도 : edacRvyy */
							yetaPrc3170Vo.setSettGbcd(MSFSharedUtils.allowNulls(tempMap.get("settGbcd")));    /** column 정산구분코드 : settGbcd */
							yetaPrc3170Vo.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));    /** column SYSTEMKEY : systemkey */
							yetaPrc3170Vo.setCtrbSeqn(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ctrbSeqn"),"0")));    /** column 기부조정명세일련번호 : ctrbSeqn */
							yetaPrc3170Vo.setCtrbDdcd(MSFSharedUtils.allowNulls(tempMap.get("ctrbDdcd")));    /** column 기부조정명세유형구분코드 : ctrbDdcd */
							yetaPrc3170Vo.setCtrbTycd(MSFSharedUtils.allowNulls(tempMap.get("ctrbTycd")));    /** column 기부조정명세유형코드 : ctrbTycd */
							yetaPrc3170Vo.setCtrbYrmn(MSFSharedUtils.allowNulls(tempMap.get("ctrbYrmn")));    /** column 기부조정명세기부연도 : ctrbYrmn */
							yetaPrc3170Vo.setCtrbAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ctrbAmnt"),"0")));    /** column 기부조정명세기부금액 : ctrbAmnt */
							yetaPrc3170Vo.setBfyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("bfyrDeam"),"0")));    /** column 전년도_공제금액 : bfyrDeam */
							yetaPrc3170Vo.setDetrAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("detrAmnt"),"0")));    /** column 공제대상금액 : detrAmnt */
							yetaPrc3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("dyyrDeam"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
							yetaPrc3170Vo.setDyyrOtam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("dyyrOtam"),"0")));    /** column 해당년도_미공제소멸금액 : dyyrOtam */
							yetaPrc3170Vo.setAyyrNtam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ayyrNtam"),"0")));    /** column 해당년도_미공제이월금액 : ayyrNtam */
							yetaPrc3170Vo.setKybdr(MSFSharedUtils.allowNulls(tempMap.get("kybdr")));    /** column 입력자 : kybdr */
							yetaPrc3170Vo.setInptDt(MSFSharedUtils.allowNulls(tempMap.get("inptDt")));    /** column 입력일자 : inptDt */
							yetaPrc3170Vo.setInptAddr(MSFSharedUtils.allowNulls(tempMap.get("inptAddr")));    /** column 입력주소 : inptAddr */
							yetaPrc3170Vo.setIsmt(MSFSharedUtils.allowNulls(tempMap.get("ismt")));    /** column 수정자 : ismt */
							yetaPrc3170Vo.setRevnDt(MSFSharedUtils.allowNulls(tempMap.get("revnDt")));    /** column 수정일자 : revnDt */
							yetaPrc3170Vo.setRevnAddr(MSFSharedUtils.allowNulls(tempMap.get("revnAddr")));    /** column 수정주소 : revnAddr */

                       		 
                       		 //yetaPrc3170Vo = (InfcPkgYeta3170VO)listYeta3170.get(iCnt); 
                       		BeanUtils.copyProperties(upInfcPkgYeta3170Vo, yetaPrc3170Vo); 

                             if (yetaPrc3170Vo.getCtrbYrmn().equals("2014"))  {  //if  oraQrySelect05.FieldByName('CTRB_YRMN').AsString = '2014' then
                               
                               	  mTempData = BigDecimal.ZERO;
                               	  if (yetaPrc3170Vo.getCtrbTycd().equals("10"))  {  //if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '10' then
                                         

                               		  if ( mTempOData10.compareTo(BigDecimal.ZERO) < 0) { //if  mTempOData10 < 0 then
                                     
                                           mTempData    = mTemp14Data10;
                                           mTemp14Data10  = yetaPrc3170Vo.getDetrAmnt().subtract((mTempData.multiply(new BigDecimal("-1")))) ; 
                                           //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1);


                                           if  (mTemp14Data10.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempOData10 >= 0 then

                                           	   upInfcPkgYeta3170Vo.setDyyrDeam((mTempData.multiply(new BigDecimal("-1"))));    /** column 해당연도공제금액 : dyyrDeam */
        											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
        											 upInfcPkgYeta3170Vo.setAyyrNtam(mTemp14Data10);    /** column 해당년도_미공제이월금액 : ayyrNtam */
        											 
                                            // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
                                            // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData10) ;

                                           }
                                           else
                                           {
                                           	 upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */  
    											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
    										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
    										   
                                            // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                            // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                           }

                                           upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                           upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                           upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                           upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                           upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                           //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                           //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                           //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                           //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                           //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                           //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                            
                                            
                                           upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                           upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                           upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                           
                                           statCnt = 0;
                           		  		   statCnt =   yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  

                               		  }
                                         else
                                         {
                                           //연산된값이 + 인경우

                                        	 mTemp14Data10  = yetaPrc3170Vo.getDetrAmnt().subtract(mTemp14Data10);  
                                                 //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempOData10 ;
                                            
                                             if  (mTemp14Data10.compareTo(BigDecimal.ZERO) >= 0)  {  // if  mTempOData10 >= 0 then
                                            
                                            	upInfcPkgYeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFb1410"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
     											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
                                        	    upInfcPkgYeta3170Vo.setAyyrNtam(mTemp14Data10);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                        	   
                                               //oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_OBAM_10').AsString;
                                               //oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData10) ;

                                             }
                                             else
                                             {
                                           	  upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */   
       											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
       										     upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
       										     
                                             //  oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                             //  oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                             }
                                             
                                             upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                             upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                             upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                             upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                             upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                             //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                             //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                             //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                             //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                             //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                             //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                              
                                              
                                             upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                             upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                             upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                             
                                             statCnt = 0;
                             		  		statCnt = yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  


                                         }

                                      }
//                              {     else  if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '30' then
//                                   begin
//
//                                      mTempData30  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempData30;
//
//                                      if  mTempData30 >= 0 then
//                                      begin
//
//                                        oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_EXAM_30').AsString;
//                                        oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData30) ;
//
//                                      end
//                                      else
//                                      begin
//
//                                        oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                        oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                      end;
//
//                                      oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                      oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                      oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                      oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString;
//
//                                      oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                      oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                      oraQryUpdate.Execute;
//
//                                   end
//                                   else  if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '31' then
//                                   begin
//
//                                      mTempData31  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempData31;
//
//                                      if  mTempData31 >= 0 then
//                                      begin
//
//                                        oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_UNON_31').AsString;
//                                        oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData31) ;
//
//                                      end
//                                      else
//                                      begin
//
//                                        oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                        oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                      end;
//
//                                      oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                      oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                      oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                      oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;
//
//                                      oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                      oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                      oraQryUpdate.Execute;
//
//                                   end }
                                    else  if (yetaPrc3170Vo.getCtrbTycd().equals("40"))  {  //if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '40' then
                                    
                                   	if ( mTemp14Data40.compareTo(BigDecimal.ZERO) < 0) { // if  mTempData40 < 0 then
                                        
                                                mTempData    = mTemp14Data40;
                                                mTemp14Data40  = yetaPrc3170Vo.getDetrAmnt().subtract((mTempData.multiply(new BigDecimal("-1")))) ; 
                                                    //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;


                                                if  (mTemp14Data40.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempOData40 >= 0 then
                                            
                                               	  upInfcPkgYeta3170Vo.setDyyrDeam((mTempData.multiply(new BigDecimal("-1"))));    /** column 해당연도공제금액 : dyyrDeam */
           											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
           										  upInfcPkgYeta3170Vo.setAyyrNtam(mTemp14Data40);    /** column 해당년도_미공제이월금액 : ayyrNtam */
           											 
                                                //oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=    FloatToStr((mTempData * -1));
                                                //oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData40) ;

                                                }
                                              else
                                              {
                                           	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */  
      											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
      										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
      										   
                                                //oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                                //oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                              }

                                              upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                              upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                              upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                              upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                              upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                              //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                              //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                              //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                              //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                              //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                              //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                               
                                               
                                              upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                              upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                              upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                              
                                            statCnt = 0;
                              		  		statCnt =   yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  
                                              
                                   	}
                                          else
                                          {
                                            //연산된값이 + 인경우

                                        	  mTemp14Data40  =  yetaPrc3170Vo.getDetrAmnt().subtract(mTemp14Data40); 
                                                //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempOData40 ;

                                                if  (mTemp14Data40.compareTo(BigDecimal.ZERO) >= 0)  {   //if  mTempOData40 >= 0 then
                                               
                                               	 upInfcPkgYeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa1440"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
        											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
                                           	   upInfcPkgYeta3170Vo.setAyyrNtam(mTemp14Data40);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                           	   
                                                  //oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_NATG_40').AsString;
                                                  //oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData40) ;

                                                }
                                                else
                                                {
                                               	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */   
            											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
            										     upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                                 
            										     //oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                                        //oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                                }

                                                upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                                upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                                upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                                //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                                //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                                //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                                //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                                //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                                //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                                 
                                                 
                                                upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                                upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                                upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                                
                                                statCnt = 0;
                                		  		statCnt =    yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  

                                          }


                                   }
                                   else if (yetaPrc3170Vo.getCtrbTycd().equals("41"))  {  // if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '41' then
                                

                                   	if ( mTemp14Data41.compareTo(BigDecimal.ZERO) < 0) { // if  mTempOData41 < 0 then
                                          
                                                mTempData    = mTemp14Data41;
                                                mTemp14Data41  =  yetaPrc3170Vo.getDetrAmnt().subtract((mTempData.multiply(new BigDecimal("-1")))) ;
                                               		 //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;


                                                if  (mTemp14Data41.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempOData41 >= 0 then
                                                
                                               	 upInfcPkgYeta3170Vo.setDyyrDeam((mTempData.multiply(new BigDecimal("-1"))));    /** column 해당연도공제금액 : dyyrDeam */
          											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
          											 upInfcPkgYeta3170Vo.setAyyrNtam(mTemp14Data41);    /** column 해당년도_미공제이월금액 : ayyrNtam */
          											 
                                                 // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
                                                 // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=  FloatToStr( mTempOData41) ;

                                                }
                                                else
                                                {

                                                  upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */  
         											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
         										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
         										   
         										   //oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                                  //oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                                }

                                                upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                                upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                                upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                                //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                                //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                                //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                                //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                                //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                                //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                                 
                                                 
                                                upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                                upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                                upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                                
                                                statCnt = 0;
                                		  		statCnt =    yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  
                                                
                                   	   }  
                                          else
                                          {
                                            //연산된값이 + 인경우
                                          
                                        	  mTemp14Data41  =  yetaPrc3170Vo.getDetrAmnt().subtract(mTemp14Data41);  
                                                 //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempOData41 ;

                                             if  (mTemp14Data41.compareTo(BigDecimal.ZERO) >= 0)  {  //if  mTempOData41 >= 0 then
                                           
                                           	  upInfcPkgYeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa1441"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
     											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
                                        	     upInfcPkgYeta3170Vo.setAyyrNtam(mTemp14Data41);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                        	   
                                               // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_YATG_41').AsString;
                                               // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData41) ;

                                              }
                                              else
                                              {

                                           	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */   
        											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
        										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
        										     
                                               // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                               // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                              }
                                             
                                              upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                              upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                              upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                              upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                              upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                              //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                              //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                              //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                              //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                              //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                              //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                               
                                               
                                              upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                              upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                              upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                              
                                              statCnt = 0;
                              		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  

                                          } 

                                   }


                               }

                       	 } 
                       	 
                       	 //============================2015년도 기부금 정리 ================================
                       	 
                       	 // 2015년도 다시 한번 루프 돌리기
                       	 for(int iCnt = 0; iCnt < listYeta3170.size();iCnt++) {
                               //2015
                             //    {retax-43}
                       		 InfcPkgYeta3170VO yetaPrc3170Vo =  new InfcPkgYeta3170VO();
                       		 InfcPkgYeta3170VO upInfcPkgYeta3170Vo =  new InfcPkgYeta3170VO(); 
                       	 
                       		Map tempMap = (Map)listYeta3170.get(iCnt);  

							yetaPrc3170Vo.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    /** column 사업장코드 : dpobCd */
							yetaPrc3170Vo.setEdacRvyy(MSFSharedUtils.allowNulls(tempMap.get("edacRvyy")));    /** column 연말정산귀속년도 : edacRvyy */
							yetaPrc3170Vo.setSettGbcd(MSFSharedUtils.allowNulls(tempMap.get("settGbcd")));    /** column 정산구분코드 : settGbcd */
							yetaPrc3170Vo.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));    /** column SYSTEMKEY : systemkey */
							yetaPrc3170Vo.setCtrbSeqn(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ctrbSeqn"),"0")));    /** column 기부조정명세일련번호 : ctrbSeqn */
							yetaPrc3170Vo.setCtrbDdcd(MSFSharedUtils.allowNulls(tempMap.get("ctrbDdcd")));    /** column 기부조정명세유형구분코드 : ctrbDdcd */
							yetaPrc3170Vo.setCtrbTycd(MSFSharedUtils.allowNulls(tempMap.get("ctrbTycd")));    /** column 기부조정명세유형코드 : ctrbTycd */
							yetaPrc3170Vo.setCtrbYrmn(MSFSharedUtils.allowNulls(tempMap.get("ctrbYrmn")));    /** column 기부조정명세기부연도 : ctrbYrmn */
							yetaPrc3170Vo.setCtrbAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ctrbAmnt"),"0")));    /** column 기부조정명세기부금액 : ctrbAmnt */
							yetaPrc3170Vo.setBfyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("bfyrDeam"),"0")));    /** column 전년도_공제금액 : bfyrDeam */
							yetaPrc3170Vo.setDetrAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("detrAmnt"),"0")));    /** column 공제대상금액 : detrAmnt */
							yetaPrc3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("dyyrDeam"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
							yetaPrc3170Vo.setDyyrOtam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("dyyrOtam"),"0")));    /** column 해당년도_미공제소멸금액 : dyyrOtam */
							yetaPrc3170Vo.setAyyrNtam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ayyrNtam"),"0")));    /** column 해당년도_미공제이월금액 : ayyrNtam */
							yetaPrc3170Vo.setKybdr(MSFSharedUtils.allowNulls(tempMap.get("kybdr")));    /** column 입력자 : kybdr */
							yetaPrc3170Vo.setInptDt(MSFSharedUtils.allowNulls(tempMap.get("inptDt")));    /** column 입력일자 : inptDt */
							yetaPrc3170Vo.setInptAddr(MSFSharedUtils.allowNulls(tempMap.get("inptAddr")));    /** column 입력주소 : inptAddr */
							yetaPrc3170Vo.setIsmt(MSFSharedUtils.allowNulls(tempMap.get("ismt")));    /** column 수정자 : ismt */
							yetaPrc3170Vo.setRevnDt(MSFSharedUtils.allowNulls(tempMap.get("revnDt")));    /** column 수정일자 : revnDt */
							yetaPrc3170Vo.setRevnAddr(MSFSharedUtils.allowNulls(tempMap.get("revnAddr")));    /** column 수정주소 : revnAddr */

                       		 
                       		 //yetaPrc3170Vo = (InfcPkgYeta3170VO)listYeta3170.get(iCnt); 
                       		  BeanUtils.copyProperties(upInfcPkgYeta3170Vo, yetaPrc3170Vo); 

                               if (yetaPrc3170Vo.getCtrbYrmn().equals("2015"))  {  // if  oraQrySelect05.FieldByName('CTRB_YRMN').AsString = '2015' then
                            
                               	 mTempData = BigDecimal.ZERO;
                               	 if (yetaPrc3170Vo.getCtrbTycd().equals("10"))  {  //if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '10' then
                                 
                                      mTempData10  = yetaPrc3170Vo.getDetrAmnt().subtract(mTempData10) ;
                                   		   
                                   		 //  oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempData10 ;

                                      if  (mTempData10.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempData10 >= 0 then

                                   	   upInfcPkgYeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg10"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
											 upInfcPkgYeta3170Vo.setAyyrNtam(mTempData10);    /** column 해당년도_미공제이월금액 : ayyrNtam */
											 
                                       // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_FBTG_10').AsString;
                                       // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData10) ;

                                      }
                                      else
                                      {

                                   	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */  
											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
										   
                                       // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                       // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                      }
                                     
                                      upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                      upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                      upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                      upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                      upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                      //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                      //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                      //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                      //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                      //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                      //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                       
                                       
                                      upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                      upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                      upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                      
                                      statCnt = 0;
                      		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  

                               	 }
//                              {     else  if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '30' then
//                                   begin
//
//                                      mTempData30  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempData30;
//
//                                      if  mTempData30 >= 0 then
//                                      begin
//
//                                        oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_EXAM_30').AsString;
//                                        oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData30) ;
//
//                                      end
//                                      else
//                                      begin
//
//                                        oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                        oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                      end;
//
//                                      oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                      oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                      oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                      oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString;
//
//                                      oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                      oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                      oraQryUpdate.Execute;
//
//                                   end
//                                   else  if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '31' then
//                                   begin
//
//                                      mTempData31  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempData31;
//
//                                      if  mTempData31 >= 0 then
//                                      begin
//
//                                        oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_UNON_31').AsString;
//                                        oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData31) ;
//
//                                      end
//                                      else
//                                      begin
//
//                                        oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                        oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                      end;
//
//                                      oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                      oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                      oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                      oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;
//
//                                      oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                      oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                      oraQryUpdate.Execute;
//
//                                   end }
                                   else  if (yetaPrc3170Vo.getCtrbTycd().equals("40"))  {  //if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '40' then
                                   

                                   	 if ( mTempData40.compareTo(BigDecimal.ZERO) < 0) { // if  mTempData40 < 0 then
                                          
                                                mTempData    = mTempData40;
                                                mTempData40  = yetaPrc3170Vo.getDetrAmnt().subtract((mTempData.multiply(new BigDecimal("-1")))) ; 
                                                   //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;


                                                if  (mTempData40.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempData40 >= 0 then
                                              
                                               	 upInfcPkgYeta3170Vo.setDyyrDeam((mTempData.multiply(new BigDecimal("-1"))));    /** column 해당연도공제금액 : dyyrDeam */
          											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
          											 upInfcPkgYeta3170Vo.setAyyrNtam(mTempData40);    /** column 해당년도_미공제이월금액 : ayyrNtam */

                                               // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=    FloatToStr((mTempData * -1));
                                               // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData40) ;

                                                }
                                              else
                                              {
                                           	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */  
      											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
      										      upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
      										   
                                               // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                               // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                              }

                                              upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                              upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                              upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                              upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                              upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                              //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                              //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                              //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                              //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                              //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                              //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                               
                                               
                                              upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                              upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                              upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                              
                                              statCnt = 0;
                              		  		statCnt =    yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  
                                              
                                   	   }
                                          else
                                          {
                                            //연산된값이 + 인경우

                                                mTempData40  = yetaPrc3170Vo.getDetrAmnt().subtract(mTempData40); 
                                               		// oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempData40 ;

                                                if  (mTempData40.compareTo(BigDecimal.ZERO) >= 0)  {   //if  mTempData40 >= 0 then
                                               
                                               	 upInfcPkgYeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg40"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
        											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
                                           	     upInfcPkgYeta3170Vo.setAyyrNtam(mTempData40);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                           	   
                                                //  oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_NATG_40').AsString;
                                                //  oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData40) ;

                                                }
                                                else
                                                {

                                               	 upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */   
          											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
          										     upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
          										     
                                                //  oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                                //  oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                                }

                                                upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                                upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                                upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                                //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                                //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                                //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                                //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                                //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                                //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                                 
                                                 
                                                upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                                upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                                upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                                
                                                statCnt = 0;
                                		  		statCnt =   yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  

                                          }


                                   }
                                   else if (yetaPrc3170Vo.getCtrbTycd().equals("41"))  {  // if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '41' then
                                   

                                   	if ( mTempData41.compareTo(BigDecimal.ZERO) < 0) { // if  mTempData41 < 0 then
                                         
                                                mTempData    = mTempData41;
                                                mTempData41  = yetaPrc3170Vo.getDetrAmnt().subtract((mTempData.multiply(new BigDecimal("-1")))) ; 
                                                   //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;


                                                if  (mTempData41.compareTo(BigDecimal.ZERO) >= 0)  { // if  mTempData41 >= 0 then
                                              
                                               	 upInfcPkgYeta3170Vo.setDyyrDeam((mTempData.multiply(new BigDecimal("-1"))));    /** column 해당연도공제금액 : dyyrDeam */
          											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
          											 upInfcPkgYeta3170Vo.setAyyrNtam(mTempData41);    /** column 해당년도_미공제이월금액 : ayyrNtam */
          											 
                                                 // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
                                                 // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=  FloatToStr( mTempData41) ;

                                                }
                                                else
                                                {

                                               	 upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */  
        											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
        										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
        										   
                                                //  oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                                //  oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                                }

                                                upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                                upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                                upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                                //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                                //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                                //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                                //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                                //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                                //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                                 
                                                 
                                                upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                                upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                                upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                                
                                                statCnt = 0;
                                		  		statCnt =     yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  
                                                
                                   	}
                                          else
                                          {
                                            //연산된값이 + 인경우
                                          
                                              mTempData41  =  yetaPrc3170Vo.getDetrAmnt().subtract(mTempData41);  
                                                  //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempData41 ;

                                              if  (mTempData41.compareTo(BigDecimal.ZERO) >= 0)  {  // if  mTempData41 >= 0 then
                                           	
                                           	   
                                           	   upInfcPkgYeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg41"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
      											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
                                         	      upInfcPkgYeta3170Vo.setAyyrNtam(mTempData41);    /** column 해당년도_미공제이월금액 : ayyrNtam */

                                               // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_YATG_41').AsString;
                                               // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData41) ;

                                              }
                                              else
                                              {
                                           	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */   
        											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
        										     upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
        										     
                                               // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                               // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                              }
                                              
                                              upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                              upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                              upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                              upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                              upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                              //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                              //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                              //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                              //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                              //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                              //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                               
                                               
                                              upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                              upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                              upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                              
                                              statCnt = 0;
                              		  		statCnt =   yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  

                                          }

                                   } else if (yetaPrc3170Vo.getCtrbTycd().equals("42"))  {  //if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '10' then
                                       
                                       mTempData42  = yetaPrc3170Vo.getDetrAmnt().subtract(mTempData42) ;
                                    		   
                                    		 //  oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempData10 ;

                                       if  (mTempData42.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempData10 >= 0 then

                                    	   upInfcPkgYeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciHftg42"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
 										   upInfcPkgYeta3170Vo.setDyyrOtam(mTempData42);    /** column 해당년도_미공제소멸금액 : dyyrOtam */
 										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
 											  

                                       }
                                       else
                                       {

                                    	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */  
 											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
 										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
 										 

                                       }
                                      
                                       upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                       upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                       upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                       upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                       upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                       //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                       //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                       //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                       //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                       //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                       //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                        
                                        
                                       upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                       upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                       upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                       
                                       statCnt = 0;
                       		  		   statCnt =  yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  

                                	 }


                               }

                       	 }
                        	 
                        	 // 2010년도 다시 한번 루프 돌리기

                        	 for(int iCnt = 0; iCnt < listYeta3170.size();iCnt++) {
                        		 InfcPkgYeta3170VO yetaPrc3170Vo =  new InfcPkgYeta3170VO();
                        		 InfcPkgYeta3170VO upInfcPkgYeta3170Vo =  new InfcPkgYeta3170VO(); 
                        		 //   {retax-39}
                        			Map tempMap = (Map)listYeta3170.get(iCnt);  

        							yetaPrc3170Vo.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    /** column 사업장코드 : dpobCd */
        							yetaPrc3170Vo.setEdacRvyy(MSFSharedUtils.allowNulls(tempMap.get("edacRvyy")));    /** column 연말정산귀속년도 : edacRvyy */
        							yetaPrc3170Vo.setSettGbcd(MSFSharedUtils.allowNulls(tempMap.get("settGbcd")));    /** column 정산구분코드 : settGbcd */
        							yetaPrc3170Vo.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));    /** column SYSTEMKEY : systemkey */
        							yetaPrc3170Vo.setCtrbSeqn(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ctrbSeqn"),"0")));    /** column 기부조정명세일련번호 : ctrbSeqn */
        							yetaPrc3170Vo.setCtrbDdcd(MSFSharedUtils.allowNulls(tempMap.get("ctrbDdcd")));    /** column 기부조정명세유형구분코드 : ctrbDdcd */
        							yetaPrc3170Vo.setCtrbTycd(MSFSharedUtils.allowNulls(tempMap.get("ctrbTycd")));    /** column 기부조정명세유형코드 : ctrbTycd */
        							yetaPrc3170Vo.setCtrbYrmn(MSFSharedUtils.allowNulls(tempMap.get("ctrbYrmn")));    /** column 기부조정명세기부연도 : ctrbYrmn */
        							yetaPrc3170Vo.setCtrbAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ctrbAmnt"),"0")));    /** column 기부조정명세기부금액 : ctrbAmnt */
        							yetaPrc3170Vo.setBfyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("bfyrDeam"),"0")));    /** column 전년도_공제금액 : bfyrDeam */
        							yetaPrc3170Vo.setDetrAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("detrAmnt"),"0")));    /** column 공제대상금액 : detrAmnt */
        							yetaPrc3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("dyyrDeam"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
        							yetaPrc3170Vo.setDyyrOtam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("dyyrOtam"),"0")));    /** column 해당년도_미공제소멸금액 : dyyrOtam */
        							yetaPrc3170Vo.setAyyrNtam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ayyrNtam"),"0")));    /** column 해당년도_미공제이월금액 : ayyrNtam */
        							yetaPrc3170Vo.setKybdr(MSFSharedUtils.allowNulls(tempMap.get("kybdr")));    /** column 입력자 : kybdr */
        							yetaPrc3170Vo.setInptDt(MSFSharedUtils.allowNulls(tempMap.get("inptDt")));    /** column 입력일자 : inptDt */
        							yetaPrc3170Vo.setInptAddr(MSFSharedUtils.allowNulls(tempMap.get("inptAddr")));    /** column 입력주소 : inptAddr */
        							yetaPrc3170Vo.setIsmt(MSFSharedUtils.allowNulls(tempMap.get("ismt")));    /** column 수정자 : ismt */
        							yetaPrc3170Vo.setRevnDt(MSFSharedUtils.allowNulls(tempMap.get("revnDt")));    /** column 수정일자 : revnDt */
        							yetaPrc3170Vo.setRevnAddr(MSFSharedUtils.allowNulls(tempMap.get("revnAddr")));    /** column 수정주소 : revnAddr */

                               		 
                               		 //yetaPrc3170Vo = (InfcPkgYeta3170VO)listYeta3170.get(iCnt); 
                               		BeanUtils.copyProperties(upInfcPkgYeta3170Vo, yetaPrc3170Vo);  
                        		 
                        		 //============================2010년도 기부금 정리 ================================
                                if (yetaPrc3170Vo.getCtrbYrmn().equals("2010"))  {   //oraQrySelect05.FieldByName('CTRB_YRMN').AsString = '' 
                                //2010
                                    mTempData = BigDecimal.ZERO;
//                                    if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '10' then
//                                    begin
//
//                                       if  mTempOData10 < 0 then
//                                       begin
//                                         mTempData    := mTempOData10;
//                                         mTempOData10  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1);
//
//
//                                         if  mTempOData10 >= 0 then
//                                         begin
//
//                                           oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
//                                           oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData10) ;
//
//                                         end
//                                         else
//                                         begin
//
//                                           oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                           oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                         end;
//
//                                         oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                         oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                         oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                         oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString;
//
//                                         oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                         oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                         oraQryUpdate.Execute;
//
//                                       end
//                                       else
//                                       begin
//                                         //연산된값이 + 인경우
//
//                                           mTempOData10  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempOData10 ;
//                                           if  mTempOData10 >= 0 then
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_OBAM_10').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData10) ;
//
//                                           end
//                                           else
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                           end;
//                                           oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                           oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                           oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                           oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;
//
//                                           oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                           oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                           oraQryUpdate.Execute;
//
//
//                                       end;
//
//                                    end
//                                  {  else  if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '30' then
//                                    begin
//
//                                    
//                                       if  mTempData30 < 0 then
//                                       begin
//                                         mTempData    := mTempData30;
//                                         mTempData30  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;
//
//                                         if  mTempData30 >= 0 then
//                                         begin
//
//                                           oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
//                                           oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData30) ;
//
//                                         end
//                                         else
//                                         begin
//
//                                           oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                           oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                         end;
//
//                                         oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                         oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                         oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                         oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString;
//
//                                         oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                         oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                         oraQryUpdate.Execute;
//                                        end
//                                       else
//                                       begin
//                                         //연산된값이 + 인경우
//                                            mTempData30  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempData30;
//
//                                           if  mTempData30 >= 0 then
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_EXAM_30').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData30) ;
//
//                                           end
//                                           else
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                           end;
//
//                                           oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                           oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                           oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                           oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString;
//
//                                           oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                           oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                           oraQryUpdate.Execute;
//
//                                       end;
//                                    end
//                                    else  if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '31' then
//                                    begin
//
//                                       if  mTempData31 < 0 then
//                                       begin
//                                             mTempData    := mTempData31;
//                                             mTempData31  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;
//
//
//                                           if  mTempData31 >= 0 then
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData31) ;
//
//                                           end
//                                           else
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                           end;
//
//                                           oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                           oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                           oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                           oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString;
//
//                                           oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                           oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                           oraQryUpdate.Execute;
//                                         end
//                                       else
//                                       begin
//                                         //연산된값이 + 인경우
//
//                                          mTempData31  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempData31;
//
//                                           if  mTempData31 >= 0 then
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_UNON_31').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData31) ;
//
//                                           end
//                                           else
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                           end;
//
//                                           oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                           oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                           oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                           oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;
//
//                                           oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                           oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                           oraQryUpdate.Execute;
//                                       end;
//                                    end }
                                    if (yetaPrc3170Vo.getCtrbTycd().equals("40"))  {   //if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '40' then
                                    
                                       if ( mTempOData40.compareTo(BigDecimal.ZERO) < 0) {
                                             mTempData    = mTempOData40;
                                             mTempOData40 = yetaPrc3170Vo.getDetrAmnt().subtract((mTempData.multiply(new BigDecimal("-1")))) ;  //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;


                                           if  (mTempOData40.compareTo(BigDecimal.ZERO) >= 0)  {

                                        	   upInfcPkgYeta3170Vo.setDyyrDeam((mTempData.multiply(new BigDecimal("-1"))));    /** column 해당연도공제금액 : dyyrDeam */
   											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
                                        	   upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData40);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                            

                                           }
                                           else
                                           {
                                        	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */  //oraQrySelect05.FieldByName('DETR_AMNT').AsString;
     											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
                                        	   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
     											  
                                           }


                                           upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                           upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                           upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                           upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                           upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                           //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                           //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                           //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                           //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                           //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                           //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                            
                                            
                                           upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                           upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                           upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                           
                                           statCnt = 0;
                           		  		statCnt =   yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  
                                            
 
                                       }
                                       else
                                       {
                                         //연산된값이 + 인경우

                                           mTempOData40  =  yetaPrc3170Vo.getDetrAmnt().subtract(mTempOData40);    //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempOData40 ;
                                         
                                           if  (mTempOData40.compareTo(BigDecimal.ZERO) >= 0)  {   //  if  mTempOData40 >= 0 then
                                          

                                        	   upInfcPkgYeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciOnam40"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
     											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
                                        	   upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData40);    /** column 해당년도_미공제이월금액 : ayyrNtam */
     											 
                                             //oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_ONAM_40').AsString;
                                             //oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData40) ;

                                           }
                                           else
                                           {
                                        	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */   
   											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
   										     upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                            
   										     //oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                             //oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                           }


                                           upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                           upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                           upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                           upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                           upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  


                                           //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                           //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                           //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                           //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                           //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                           //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                            
                                            
                                           upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                           upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                           upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                           
                                           statCnt = 0;
                           		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  
                                            

                                       }
                                    }
                                    else   if (yetaPrc3170Vo.getCtrbTycd().equals("41"))  { //if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '41' then
                                    
                                    	if ( mTempOData41.compareTo(BigDecimal.ZERO) < 0) { // if  mTempOData41 < 0 then
                                    	 
                                             mTempData    = mTempOData41;
                                             mTempOData41  =  yetaPrc3170Vo.getDetrAmnt().subtract((mTempData.multiply(new BigDecimal("-1")))) ; //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;


                                             if  (mTempOData41.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempOData41 >= 0 then
                                             
                                            	 upInfcPkgYeta3170Vo.setDyyrDeam((mTempData.multiply(new BigDecimal("-1"))));    /** column 해당연도공제금액 : dyyrDeam */
       											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
       											 upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData41);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                               //oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
                                               //oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=  FloatToStr( mTempOData41) ;

                                             }
                                             else
                                             {
                                            	 upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */  
     											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
     										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
     										   
                                              // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                              // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                             }

                                             upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                             upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                             upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                             upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                             upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                             //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                             //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                             //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                             //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                             //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                             //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                              
                                              
                                             upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                             upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                             upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                             
                                             statCnt = 0;
                             		  		statCnt =   yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);    
                                    	}
                                       else
                                       {
                                         //연산된값이 + 인경우
                                         mTempOData41  =  yetaPrc3170Vo.getDetrAmnt().subtract(mTempOData40);  
                                        		// oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempOData41 ;

                                         if  (mTempOData41.compareTo(BigDecimal.ZERO) >= 0)  {  // if  mTempOData41 >= 0 then
                                         
                                        	  upInfcPkgYeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciOyam41"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
  											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
                                     	   upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData41);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                     	   
                                         //  oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_OYAM_41').AsString;
                                          // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData41) ;

                                         }
                                         else
                                         {
                                        	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */   
     											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
     										     upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                         //  oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                         //  oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                         }
                                      
                                         upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                         upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                         upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                         upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                         upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                         //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                         //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                         //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                         //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                         //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                         //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                          
                                          
                                         upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                         upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                         upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                         
                                         statCnt = 0;
                         		  		statCnt = yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  

                                       }
                                    } 

                                }
                         }
                        	 //============================2011년도 기부금 정리 ================================
                             // 2011년도 다시 한번 루프 돌리기
                            
                        	 for(int iCnt = 0; iCnt < listYeta3170.size();iCnt++) {
                              
                        		 InfcPkgYeta3170VO yetaPrc3170Vo =  new InfcPkgYeta3170VO();
                        		 InfcPkgYeta3170VO upInfcPkgYeta3170Vo =  new InfcPkgYeta3170VO(); 
                        		 //   {retax-39}
                        			Map tempMap = (Map)listYeta3170.get(iCnt);  

        							yetaPrc3170Vo.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    /** column 사업장코드 : dpobCd */
        							yetaPrc3170Vo.setEdacRvyy(MSFSharedUtils.allowNulls(tempMap.get("edacRvyy")));    /** column 연말정산귀속년도 : edacRvyy */
        							yetaPrc3170Vo.setSettGbcd(MSFSharedUtils.allowNulls(tempMap.get("settGbcd")));    /** column 정산구분코드 : settGbcd */
        							yetaPrc3170Vo.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));    /** column SYSTEMKEY : systemkey */
        							yetaPrc3170Vo.setCtrbSeqn(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ctrbSeqn"),"0")));    /** column 기부조정명세일련번호 : ctrbSeqn */
        							yetaPrc3170Vo.setCtrbDdcd(MSFSharedUtils.allowNulls(tempMap.get("ctrbDdcd")));    /** column 기부조정명세유형구분코드 : ctrbDdcd */
        							yetaPrc3170Vo.setCtrbTycd(MSFSharedUtils.allowNulls(tempMap.get("ctrbTycd")));    /** column 기부조정명세유형코드 : ctrbTycd */
        							yetaPrc3170Vo.setCtrbYrmn(MSFSharedUtils.allowNulls(tempMap.get("ctrbYrmn")));    /** column 기부조정명세기부연도 : ctrbYrmn */
        							yetaPrc3170Vo.setCtrbAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ctrbAmnt"),"0")));    /** column 기부조정명세기부금액 : ctrbAmnt */
        							yetaPrc3170Vo.setBfyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("bfyrDeam"),"0")));    /** column 전년도_공제금액 : bfyrDeam */
        							yetaPrc3170Vo.setDetrAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("detrAmnt"),"0")));    /** column 공제대상금액 : detrAmnt */
        							yetaPrc3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("dyyrDeam"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
        							yetaPrc3170Vo.setDyyrOtam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("dyyrOtam"),"0")));    /** column 해당년도_미공제소멸금액 : dyyrOtam */
        							yetaPrc3170Vo.setAyyrNtam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ayyrNtam"),"0")));    /** column 해당년도_미공제이월금액 : ayyrNtam */
        							yetaPrc3170Vo.setKybdr(MSFSharedUtils.allowNulls(tempMap.get("kybdr")));    /** column 입력자 : kybdr */
        							yetaPrc3170Vo.setInptDt(MSFSharedUtils.allowNulls(tempMap.get("inptDt")));    /** column 입력일자 : inptDt */
        							yetaPrc3170Vo.setInptAddr(MSFSharedUtils.allowNulls(tempMap.get("inptAddr")));    /** column 입력주소 : inptAddr */
        							yetaPrc3170Vo.setIsmt(MSFSharedUtils.allowNulls(tempMap.get("ismt")));    /** column 수정자 : ismt */
        							yetaPrc3170Vo.setRevnDt(MSFSharedUtils.allowNulls(tempMap.get("revnDt")));    /** column 수정일자 : revnDt */
        							yetaPrc3170Vo.setRevnAddr(MSFSharedUtils.allowNulls(tempMap.get("revnAddr")));    /** column 수정주소 : revnAddr */

                               		 
                               		 //yetaPrc3170Vo = (InfcPkgYeta3170VO)listYeta3170.get(iCnt); 
                               		BeanUtils.copyProperties(upInfcPkgYeta3170Vo, yetaPrc3170Vo); 
                        		 
                              //    {retax-40} 
                              if (yetaPrc3170Vo.getCtrbYrmn().equals("2011"))  {  //if  oraQrySelect05.FieldByName('CTRB_YRMN').AsString = '2011'
                               
                                //2011
                                    mTempData = BigDecimal.ZERO;
//                                    if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '10' then
//                                    begin
//
//                                       if  mTempOData10 < 0 then
//                                       begin
//                                         mTempData    := mTempOData10;
//                                         mTempOData10  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1);
//
//
//                                         if  mTempOData10 >= 0 then
//                                         begin
//
//                                           oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
//                                           oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData10) ;
//
//                                         end
//                                         else
//                                         begin
//
//                                           oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                           oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                         end;
//
//                                         oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                         oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                         oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                         oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString;
//
//                                         oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                         oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                         oraQryUpdate.Execute;
//
//                                       end
//                                       else
//                                       begin
//                                         //연산된값이 + 인경우
//
//                                           mTempOData10  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempOData10 ;
//                                           if  mTempOData10 >= 0 then
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_OBAM_10').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData10) ;
//
//                                           end
//                                           else
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                           end;
//                                           oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                           oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                           oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                           oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;
//
//                                           oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                           oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                           oraQryUpdate.Execute;
//
//
//                                       end;
//
//                                    end
//                                 {   else  if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '30' then
//                                    begin
//
//                                    
//                                       if  mTempData30 < 0 then
//                                       begin
//                                         mTempData    := mTempData30;
//                                         mTempData30  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;
//
//                                         if  mTempData30 >= 0 then
//                                         begin
//
//                                           oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
//                                           oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData30) ;
//
//                                         end
//                                         else
//                                         begin
//
//                                           oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                           oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                         end;
//
//                                         oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                         oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                         oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                         oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString;
//
//                                         oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                         oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                         oraQryUpdate.Execute;
//                                        end
//                                       else
//                                       begin
//                                         //연산된값이 + 인경우
//                                            mTempData30  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempData30;
//
//                                           if  mTempData30 >= 0 then
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_EXAM_30').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData30) ;
//
//                                           end
//                                           else
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                           end;
//
//                                           oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                           oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                           oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                           oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString;
//
//                                           oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                           oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                           oraQryUpdate.Execute;
//
//                                       end;
//                                    end }
                                    if (yetaPrc3170Vo.getCtrbTycd().equals("31"))  {   // if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '31' then
                                   

                                    	if ( mTempData31.compareTo(BigDecimal.ZERO) < 0) {   //if  mTempData31 < 0 then
                                      
                                             mTempData    = mTempData31;
                                             mTempData31  =  yetaPrc3170Vo.getDetrAmnt().subtract((mTempData.multiply(new BigDecimal("-1")))) ; 
                                             //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;


                                            if  (mTempData31.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempData31 >= 0 then
                                         
                                            	  upInfcPkgYeta3170Vo.setDyyrDeam((mTempData.multiply(new BigDecimal("-1"))));    /** column 해당연도공제금액 : dyyrDeam */
        											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
        											 upInfcPkgYeta3170Vo.setAyyrNtam(mTempData31);    /** column 해당년도_미공제이월금액 : ayyrNtam */
        											 
                                            // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
                                            // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData31) ;

                                            }
                                           else
                                           {
                                        	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */  
   											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
   										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
   										   
                                            // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                            // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                           }

                                            upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                            upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                            upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                            upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                            upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                            //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                            //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                            //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                            //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                            //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                            //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                             
                                             
                                            upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                            upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                            upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                            
                                            statCnt = 0;
                            		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  
                                    	}
                                       else
                                       {
                                         //연산된값이 + 인경우

                                          mTempData31  = yetaPrc3170Vo.getDetrAmnt().subtract(mTempData31);  
                                               //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempData31;

                                          if  (mTempData31.compareTo(BigDecimal.ZERO) >= 0)  {    //if  mTempData31 >= 0 then
                                          
                                        	 upInfcPkgYeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciUnon31"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
  											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
                                     	     upInfcPkgYeta3170Vo.setAyyrNtam(mTempData31);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                     	   
                                             //oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_UNON_31').AsString;
                                             //oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData31) ;

                                           }
                                           else
                                           {
                                        	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */   
     											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
     										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
     										     
                                          //   oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                          //   oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                           }

                                           upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                           upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                           upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                           upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                           upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                           //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                           //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                           //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                           //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                           //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                           //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                            
                                            
                                           upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                           upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                           upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                           
                                           statCnt = 0;
                           		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  
                                       }
                                    }
                                    else if (yetaPrc3170Vo.getCtrbTycd().equals("40"))  {  //if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '40' then
                                    
                                       if  (mTempOData40.compareTo(BigDecimal.ZERO) < 0)  {
                                             mTempData   = mTempOData40;
                                             mTempOData40  = yetaPrc3170Vo.getDetrAmnt().subtract((mTempData.multiply(new BigDecimal("-1")))) ;
                                            		 //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;


                                           if  (mTempOData40.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempOData40 >= 0 then
                                           
                                        	 upInfcPkgYeta3170Vo.setDyyrDeam((mTempData.multiply(new BigDecimal("-1"))));    /** column 해당연도공제금액 : dyyrDeam */
     											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
     										 upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData40);    /** column 해당년도_미공제이월금액 : ayyrNtam */
     											 
                                            // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=    FloatToStr((mTempData * -1));
                                            // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData40) ;

                                           }
                                           else
                                           {

                                        	  upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */  
   											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
   										      upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
   										   
                                            // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                            // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                           }

                                           upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                           upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                           upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                           upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                           upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                           //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                           //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                           //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                           //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                           //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                           //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                            
                                            
                                           upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                           upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                           upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                           
                                           statCnt = 0;
                           		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  
                                           
                                       }
                                       else
                                       {
                                         //연산된값이 + 인경우

                                           mTempOData40  =  yetaPrc3170Vo.getDetrAmnt().subtract(mTempOData40); 
                                        		   //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempOData40 ;

                                           if  (mTempOData40.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempOData40 >= 0 then
                                            
                                        	   upInfcPkgYeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciOnam40"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
   											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
                                      	   upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData40);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                      	   
                                            // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_ONAM_40').AsString;
                                            // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData40) ;

                                           }
                                           else
                                           {
                                        	    
                                        	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */   
     											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
     										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
     										     
                                            // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                            // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                           }

                                           upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                           upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                           upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                           upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                           upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                           //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                           //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                           //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                           //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                           //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                           //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                            
                                            
                                           upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                           upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                           upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                           
                                           statCnt = 0;
                           		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  

                                       }
                                     }
                                    else   if (yetaPrc3170Vo.getCtrbTycd().equals("41"))  {  //if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '41' then
                                    
                                        
                                    	if ( mTempOData41.compareTo(BigDecimal.ZERO) < 0) { // if  mTempOData41 < 0 then
                                       
                                             mTempData    = mTempOData41;
                                             mTempOData41  = yetaPrc3170Vo.getDetrAmnt().subtract((mTempData.multiply(new BigDecimal("-1")))) ; 
                                             //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;


                                             if  (mTempOData41.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempOData41 >= 0 then
                                            
                                            	 upInfcPkgYeta3170Vo.setDyyrDeam((mTempData.multiply(new BigDecimal("-1"))));    /** column 해당연도공제금액 : dyyrDeam */
       											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
       											 upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData41);    /** column 해당년도_미공제이월금액 : ayyrNtam */
       											 
                                              // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
                                              // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=  FloatToStr( mTempOData41) ;

                                             }
                                             else
                                             {

                                              upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */  
      											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
      										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
      										   
                                              // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                              // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                             }

                                             upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                             upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                             upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                             upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                             upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                             //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                             //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                             //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                             //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                             //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                             //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                              
                                              
                                             upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                             upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                             upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                             
                                             statCnt = 0;
                             		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  
                                    	}
                                       else
                                       {
                                         //연산된값이 + 인경우
                                         mTempOData41  =  yetaPrc3170Vo.getDetrAmnt().subtract(mTempOData41);  
                                         //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempOData41 ;

                                         if  (mTempOData41.compareTo(BigDecimal.ZERO) >= 0)  {   // if  mTempOData41 >= 0 then

                                        	 upInfcPkgYeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciOyam41"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
 											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
                                    	    upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData41);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                    	   
                                          // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_OYAM_41').AsString;
                                          // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData41) ;

                                         }
                                         else
                                         {

                                        	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */   
     											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
     										     upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
     										     
                                          // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                          // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                         }
                                        
                                         upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                         upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                         upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                         upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                         upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                         //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                         //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                         //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                         //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                         //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                         //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                          
                                          
                                         upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                         upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                         upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                         
                                         statCnt = 0;
                         		  		 statCnt = yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  

                                       }
                                    }
                               }
                                
                        	 }

                        	 //============================2012년도 기부금 정리 ================================
                             // 2012년도 다시 한번 루프 돌리기
                        	 for(int iCnt = 0; iCnt < listYeta3170.size();iCnt++) {
                              //    {retax-41}
                        		 InfcPkgYeta3170VO yetaPrc3170Vo =  new InfcPkgYeta3170VO();
                        		 InfcPkgYeta3170VO upInfcPkgYeta3170Vo =  new InfcPkgYeta3170VO(); 
                        	 
                        			Map tempMap = (Map)listYeta3170.get(iCnt);  

        							yetaPrc3170Vo.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    /** column 사업장코드 : dpobCd */
        							yetaPrc3170Vo.setEdacRvyy(MSFSharedUtils.allowNulls(tempMap.get("edacRvyy")));    /** column 연말정산귀속년도 : edacRvyy */
        							yetaPrc3170Vo.setSettGbcd(MSFSharedUtils.allowNulls(tempMap.get("settGbcd")));    /** column 정산구분코드 : settGbcd */
        							yetaPrc3170Vo.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));    /** column SYSTEMKEY : systemkey */
        							yetaPrc3170Vo.setCtrbSeqn(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ctrbSeqn"),"0")));    /** column 기부조정명세일련번호 : ctrbSeqn */
        							yetaPrc3170Vo.setCtrbDdcd(MSFSharedUtils.allowNulls(tempMap.get("ctrbDdcd")));    /** column 기부조정명세유형구분코드 : ctrbDdcd */
        							yetaPrc3170Vo.setCtrbTycd(MSFSharedUtils.allowNulls(tempMap.get("ctrbTycd")));    /** column 기부조정명세유형코드 : ctrbTycd */
        							yetaPrc3170Vo.setCtrbYrmn(MSFSharedUtils.allowNulls(tempMap.get("ctrbYrmn")));    /** column 기부조정명세기부연도 : ctrbYrmn */
        							yetaPrc3170Vo.setCtrbAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ctrbAmnt"),"0")));    /** column 기부조정명세기부금액 : ctrbAmnt */
        							yetaPrc3170Vo.setBfyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("bfyrDeam"),"0")));    /** column 전년도_공제금액 : bfyrDeam */
        							yetaPrc3170Vo.setDetrAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("detrAmnt"),"0")));    /** column 공제대상금액 : detrAmnt */
        							yetaPrc3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("dyyrDeam"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
        							yetaPrc3170Vo.setDyyrOtam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("dyyrOtam"),"0")));    /** column 해당년도_미공제소멸금액 : dyyrOtam */
        							yetaPrc3170Vo.setAyyrNtam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ayyrNtam"),"0")));    /** column 해당년도_미공제이월금액 : ayyrNtam */
        							yetaPrc3170Vo.setKybdr(MSFSharedUtils.allowNulls(tempMap.get("kybdr")));    /** column 입력자 : kybdr */
        							yetaPrc3170Vo.setInptDt(MSFSharedUtils.allowNulls(tempMap.get("inptDt")));    /** column 입력일자 : inptDt */
        							yetaPrc3170Vo.setInptAddr(MSFSharedUtils.allowNulls(tempMap.get("inptAddr")));    /** column 입력주소 : inptAddr */
        							yetaPrc3170Vo.setIsmt(MSFSharedUtils.allowNulls(tempMap.get("ismt")));    /** column 수정자 : ismt */
        							yetaPrc3170Vo.setRevnDt(MSFSharedUtils.allowNulls(tempMap.get("revnDt")));    /** column 수정일자 : revnDt */
        							yetaPrc3170Vo.setRevnAddr(MSFSharedUtils.allowNulls(tempMap.get("revnAddr")));    /** column 수정주소 : revnAddr */

                               		 
                               		 //yetaPrc3170Vo = (InfcPkgYeta3170VO)listYeta3170.get(iCnt); 
                               		BeanUtils.copyProperties(upInfcPkgYeta3170Vo, yetaPrc3170Vo); 

                              if (yetaPrc3170Vo.getCtrbYrmn().equals("2012"))  {  //if  oraQrySelect05.FieldByName('CTRB_YRMN').AsString = '2012'
                                
                                //2012
                                     mTempData = BigDecimal.ZERO;
                            
                                    if (yetaPrc3170Vo.getCtrbTycd().equals("10"))  {  //if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '10' then
                                    

                                    	if ( mTempOData10.compareTo(BigDecimal.ZERO) < 0) { // if  mTempOData10 < 0 then
                                       
                                         mTempData    = mTempOData10;
                                         mTempOData10  =  yetaPrc3170Vo.getDetrAmnt().subtract((mTempData.multiply(new BigDecimal("-1")))) ;  
                                        		// oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1);


                                         if  (mTempOData10.compareTo(BigDecimal.ZERO) >= 0)  { // if  mTempOData10 >= 0 then

                                        	 upInfcPkgYeta3170Vo.setDyyrDeam((mTempData.multiply(new BigDecimal("-1"))));    /** column 해당연도공제금액 : dyyrDeam */
   											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
   											 upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData10);    /** column 해당년도_미공제이월금액 : ayyrNtam */
   											 
                                           //oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
                                           //oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData10) ;

                                         }
                                         else
                                         {

                                        	 upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */  
 											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
 										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
 										   
                                         //  oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                         //  oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                         }

                                         upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                         upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                         upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                         upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                         upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                         //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                         //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                         //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                         //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                         //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                         //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                          
                                          
                                         upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                         upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                         upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                         
                                         statCnt = 0;
                         		  		statCnt = yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  

                                    	}
                                       else
                                       {
                                         //연산된값이 + 인경우

                                           mTempOData10  =  yetaPrc3170Vo.getDetrAmnt().subtract(mTempOData10); 
                                        		   //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempOData10 ;
                                          
                                           if  (mTempOData10.compareTo(BigDecimal.ZERO) >= 0)  {  // if  mTempOData10 >= 0 then
                                          
                                        	   upInfcPkgYeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciObam10"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
   											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
                                      	   upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData10);    /** column 해당년도_미공제이월금액 : ayyrNtam */
   											 
                                            // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_OBAM_10').AsString;
                                            // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData10) ;

                                           }
                                           else
                                           {
                                        	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */   
     											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
     										     upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
     										     
                                            // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                            // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                           }
                                           
                                           upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                           upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                           upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                           upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                           upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                           //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                           //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                           //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                           //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                           //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                           //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                            
                                            
                                           upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                           upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                           upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                           
                                           statCnt = 0;
                           		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  

                                       }

                                    }
//                                 {   else  if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '30' then
//                                    begin
//
//                                    
//                                       if  mTempData30 < 0 then
//                                       begin
//                                         mTempData    := mTempData30;
//                                         mTempData30  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;
//
//                                         if  mTempData30 >= 0 then
//                                         begin
//
//                                           oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
//                                           oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData30) ;
//
//                                         end
//                                         else
//                                         begin
//
//                                           oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                           oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                         end;
//
//                                         oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                         oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                         oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                         oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString;
//
//                                         oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                         oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                         oraQryUpdate.Execute;
//                                        end
//                                       else
//                                       begin
//                                         //연산된값이 + 인경우
//                                            mTempData30  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempData30;
//
//                                           if  mTempData30 >= 0 then
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_EXAM_30').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData30) ;
//
//                                           end
//                                           else
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                           end;
//
//                                           oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                           oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                           oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                           oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString;
//
//                                           oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                           oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                           oraQryUpdate.Execute;
//
//                                       end;
//                                    end }
//                                    else  if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '31' then
//                                    begin
//
//                                       if  mTempData31 < 0 then
//                                       begin
//                                             mTempData    := mTempData31;
//                                             mTempData31  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;
//
//
//                                           if  mTempData31 >= 0 then
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData31) ;
//
//                                           end
//                                           else
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                           end;
//
//                                           oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                           oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                           oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                           oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString;
//
//                                           oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                           oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                           oraQryUpdate.Execute;
//                                         end
//                                       else
//                                       begin
//                                         //연산된값이 + 인경우
//
//                                          mTempData31  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempData31;
//
//                                           if  mTempData31 >= 0 then
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_UNON_31').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData31) ;
//
//                                           end
//                                           else
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                           end;
//
//                                           oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                           oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                           oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                           oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;
//
//                                           oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                           oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                           oraQryUpdate.Execute;
//                                       end;
//                                    end
                                    else   if (yetaPrc3170Vo.getCtrbTycd().equals("40"))  {  //if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '40' then
                                     

                                    	if ( mTempOData40.compareTo(BigDecimal.ZERO) < 0) { // if  mTempOData40 < 0 then
                                      
                                             mTempData    = mTempOData40;
                                             mTempOData40   = yetaPrc3170Vo.getDetrAmnt().subtract((mTempData.multiply(new BigDecimal("-1")))) ;
                                            		// oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;


                                             if  (mTempOData40.compareTo(BigDecimal.ZERO) >= 0)  {  // if  mTempOData40 >= 0 then
                                            
                                            	 upInfcPkgYeta3170Vo.setDyyrDeam((mTempData.multiply(new BigDecimal("-1"))));    /** column 해당연도공제금액 : dyyrDeam */
       											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
       											 upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData40);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                            
       											 //oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=    FloatToStr((mTempData * -1));
                                             //oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData40) ;

                                             }
                                             else
                                             {
                                            	 upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */  
     											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
     										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
     										   
                                            // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                            // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                             }

                                           upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                           upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                           upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                           upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                           upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                           //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                           //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                           //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                           //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                           //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                           //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                            
                                            
                                           upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                           upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                           upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                           
                                           statCnt = 0;
                           		  		statCnt = yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  
                                           
                                    	}
                                       else
                                       {
                                         //연산된값이 + 인경우

                                           mTempOData40  = yetaPrc3170Vo.getDetrAmnt().subtract(mTempOData40);   
                                               //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempOData40 ;

                                           if  (mTempOData40.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempOData40 >= 0 then
                                           
                                        	   upInfcPkgYeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciOnam40"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
   											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
                                      	   upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData40);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                      	   
                                            // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_ONAM_40').AsString;
                                            // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData40) ;

                                           }
                                           else
                                           {
                                        	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */   
     											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
     										     upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
     										     
                                            // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                            // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                           }

                                           upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                           upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                           upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                           upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                           upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                           //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                           //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                           //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                           //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                           //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                           //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                            
                                            
                                           upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                           upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                           upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                           
                                           statCnt = 0;
                           		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  

                                       }
                                    }
                                    else   if (yetaPrc3170Vo.getCtrbTycd().equals("41"))  {  //if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '41' then
                                   
                                    	if ( mTempOData41.compareTo(BigDecimal.ZERO) < 0) { //if  mTempOData41 < 0 then
                                      
                                             mTempData    = mTempOData41;
                                             mTempOData41  =  yetaPrc3170Vo.getDetrAmnt().subtract((mTempData.multiply(new BigDecimal("-1")))) ; 
                                                //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;


                                             if  (mTempOData41.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempOData41 >= 0 then
                                              
                                            	  upInfcPkgYeta3170Vo.setDyyrDeam((mTempData.multiply(new BigDecimal("-1"))));    /** column 해당연도공제금액 : dyyrDeam */
        											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
        											 upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData41);    /** column 해당년도_미공제이월금액 : ayyrNtam */
        											 
                                              // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
                                              // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=  FloatToStr( mTempOData41) ;

                                             }
                                             else
                                             {
                                               upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */  
     											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
     										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
     										   
                                               //oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                               //oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                             }

                                             upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                             upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                             upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                             upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                             upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                             //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                             //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                             //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                             //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                             //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                             //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                              
                                              
                                             upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                             upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                             upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                             
                                             statCnt = 0;
                             		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  
                                             
                                    	}
                                       else
                                       {
                                         //연산된값이 + 인경우
                                         mTempOData41  = yetaPrc3170Vo.getDetrAmnt().subtract(mTempOData41);   
                                         //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempOData41 ;

                                         if  (mTempOData41.compareTo(BigDecimal.ZERO) >= 0)  { // if  mTempOData41 >= 0 then
                                        
                                        	  upInfcPkgYeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciOyam41"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
  											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
                                     	   upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData41);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                     	   
                                         //  oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_OYAM_41').AsString;
                                         //  oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData41) ;

                                        }
                                         else
                                         {
                                        	  upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */   
    											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
    										     upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                             
    										     
                                         //  oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                          // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                        }
                                       
                                         upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                         upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                         upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                         upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                         upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                         //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                         //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                         //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                         //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                         //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                         //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                          
                                          
                                         upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                         upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                         upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                         
                                         statCnt = 0;
                         		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  

                                      }
                                    }

                              }

                        	 }
                        	 //============================2013년도 기부금 정리 ================================
//                                2013년도 다시 한번 루프 돌리기
                        	 for(int iCnt = 0; iCnt < listYeta3170.size();iCnt++) {
                             //    {retax-42}
                        		 InfcPkgYeta3170VO yetaPrc3170Vo =  new InfcPkgYeta3170VO();
                        		 InfcPkgYeta3170VO upInfcPkgYeta3170Vo =  new InfcPkgYeta3170VO(); 
                        	 
                        			Map tempMap = (Map)listYeta3170.get(iCnt);  

        							yetaPrc3170Vo.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    /** column 사업장코드 : dpobCd */
        							yetaPrc3170Vo.setEdacRvyy(MSFSharedUtils.allowNulls(tempMap.get("edacRvyy")));    /** column 연말정산귀속년도 : edacRvyy */
        							yetaPrc3170Vo.setSettGbcd(MSFSharedUtils.allowNulls(tempMap.get("settGbcd")));    /** column 정산구분코드 : settGbcd */
        							yetaPrc3170Vo.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));    /** column SYSTEMKEY : systemkey */
        							yetaPrc3170Vo.setCtrbSeqn(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ctrbSeqn"),"0")));    /** column 기부조정명세일련번호 : ctrbSeqn */
        							yetaPrc3170Vo.setCtrbDdcd(MSFSharedUtils.allowNulls(tempMap.get("ctrbDdcd")));    /** column 기부조정명세유형구분코드 : ctrbDdcd */
        							yetaPrc3170Vo.setCtrbTycd(MSFSharedUtils.allowNulls(tempMap.get("ctrbTycd")));    /** column 기부조정명세유형코드 : ctrbTycd */
        							yetaPrc3170Vo.setCtrbYrmn(MSFSharedUtils.allowNulls(tempMap.get("ctrbYrmn")));    /** column 기부조정명세기부연도 : ctrbYrmn */
        							yetaPrc3170Vo.setCtrbAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ctrbAmnt"),"0")));    /** column 기부조정명세기부금액 : ctrbAmnt */
        							yetaPrc3170Vo.setBfyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("bfyrDeam"),"0")));    /** column 전년도_공제금액 : bfyrDeam */
        							yetaPrc3170Vo.setDetrAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("detrAmnt"),"0")));    /** column 공제대상금액 : detrAmnt */
        							yetaPrc3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("dyyrDeam"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
        							yetaPrc3170Vo.setDyyrOtam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("dyyrOtam"),"0")));    /** column 해당년도_미공제소멸금액 : dyyrOtam */
        							yetaPrc3170Vo.setAyyrNtam(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ayyrNtam"),"0")));    /** column 해당년도_미공제이월금액 : ayyrNtam */
        							yetaPrc3170Vo.setKybdr(MSFSharedUtils.allowNulls(tempMap.get("kybdr")));    /** column 입력자 : kybdr */
        							yetaPrc3170Vo.setInptDt(MSFSharedUtils.allowNulls(tempMap.get("inptDt")));    /** column 입력일자 : inptDt */
        							yetaPrc3170Vo.setInptAddr(MSFSharedUtils.allowNulls(tempMap.get("inptAddr")));    /** column 입력주소 : inptAddr */
        							yetaPrc3170Vo.setIsmt(MSFSharedUtils.allowNulls(tempMap.get("ismt")));    /** column 수정자 : ismt */
        							yetaPrc3170Vo.setRevnDt(MSFSharedUtils.allowNulls(tempMap.get("revnDt")));    /** column 수정일자 : revnDt */
        							yetaPrc3170Vo.setRevnAddr(MSFSharedUtils.allowNulls(tempMap.get("revnAddr")));    /** column 수정주소 : revnAddr */

                               		 
                               		 //yetaPrc3170Vo = (InfcPkgYeta3170VO)listYeta3170.get(iCnt); 
                               		BeanUtils.copyProperties(upInfcPkgYeta3170Vo, yetaPrc3170Vo);  

                              if (yetaPrc3170Vo.getCtrbYrmn().equals("2013"))  {  // if  oraQrySelect05.FieldByName('CTRB_YRMN').AsString = '2013'
                                //2013
                                    mTempData = BigDecimal.ZERO;
                                 if (yetaPrc3170Vo.getCtrbTycd().equals("10"))  {  //if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '10' then
                                   
                                	 if ( mTempOData10.compareTo(BigDecimal.ZERO) < 0) { // if  mTempOData10 < 0 then
                                       
                                         mTempData    = mTempOData10;
                                         mTempOData10  = yetaPrc3170Vo.getDetrAmnt().subtract((mTempData.multiply(new BigDecimal("-1")))) ; 
                                         //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1);


                                         if  (mTempOData10.compareTo(BigDecimal.ZERO) >= 0)  { // if  mTempOData10 >= 0 then
                                        
                                        	 upInfcPkgYeta3170Vo.setDyyrDeam((mTempData.multiply(new BigDecimal("-1"))));    /** column 해당연도공제금액 : dyyrDeam */
   											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
   											 upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData10);    /** column 해당년도_미공제이월금액 : ayyrNtam */
   											 
                                           //oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
                                           //oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData10) ;

                                         }
                                         else
                                         {

                                           upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */  
 											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
 										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
 										   
                                           //oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                           //oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                         }

                                         upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                         upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                         upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                         upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                         upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                         //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                         //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                         //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                         //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                         //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                         //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                          
                                          
                                         upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                         upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                         upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                         
                                         statCnt = 0;
                         		  		statCnt = yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  

                                	  }
                                       else
                                       {
                                         //연산된값이 + 인경우

                                           mTempOData10  = yetaPrc3170Vo.getDetrAmnt().subtract(mTempOData10);    
                                        		   //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempOData10 ;
                                         
                                           if  (mTempOData10.compareTo(BigDecimal.ZERO) >= 0)  {  // if  mTempOData10 >= 0 then
                                         
                                        	   upInfcPkgYeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciObam10"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
   											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
                                      	      upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData10);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                      	   
                                             //oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_OBAM_10').AsString;
                                             //oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData10) ;

                                           }
                                           else
                                           {

                                        	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */   
     											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
     										     upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
     										     
                                           //  oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                           //  oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                           }
                                           
                                           upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                           upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                           upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                           upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                           upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                           //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                           //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                           //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                           //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                           //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                           //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                            
                                            
                                           upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                           upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                           upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                           
                                           statCnt = 0;
                           		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  


                                       }

                                }
//                                 {   else  if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '30' then
//                                    begin
//
//                                    
//                                       if  mTempData30 < 0 then
//                                       begin
//                                         mTempData    := mTempData30;
//                                         mTempData30  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;
//
//                                         if  mTempData30 >= 0 then
//                                         begin
//
//                                           oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
//                                           oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData30) ;
//
//                                         end
//                                         else
//                                         begin
//
//                                           oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                           oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                         end;
//
//                                         oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                         oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                         oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                         oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString;
//
//                                         oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                         oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                         oraQryUpdate.Execute;
//                                        end
//                                       else
//                                       begin
//                                         //연산된값이 + 인경우
//                                            mTempData30  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempData30;
//
//                                           if  mTempData30 >= 0 then
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_EXAM_30').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData30) ;
//
//                                           end
//                                           else
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                           end;
//
//                                           oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                           oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                           oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                           oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString;
//
//                                           oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                           oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                           oraQryUpdate.Execute;
//
//                                       end;
//                                    end }
//                                    else  if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '31' then
//                                    begin
//
//                                       if  mTempData31 < 0 then
//                                       begin
//                                             mTempData    := mTempData31;
//                                             mTempData31  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;
//
//
//                                           if  mTempData31 >= 0 then
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData31) ;
//
//                                           end
//                                           else
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                           end;
//
//                                           oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                           oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                           oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                           oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString;
//
//                                           oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                           oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                           oraQryUpdate.Execute;
//                                         end
//                                       else
//                                       begin
//                                         //연산된값이 + 인경우
//
//                                          mTempData31  := oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempData31;
//
//                                           if  mTempData31 >= 0 then
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_UNON_31').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempData31) ;
//
//                                           end
//                                           else
//                                           begin
//
//                                             oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
//                                             oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;
//
//                                           end;
//
//                                           oraQryUpdate.ParamByName('EDAC_RVYY').AsString :=   Cells[2, jRow] ;
//                                           oraQryUpdate.ParamByName('SETT_GBCD').AsString :=   Cells[3, jRow] ;
//                                           oraQryUpdate.ParamByName('PSNL_NUMB').AsString :=   Cells[4, jRow] ;
//                                           oraQryUpdate.ParamByName('CTRB_SEQN').AsString :=  oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;
//
//                                           oraQryUpdate.ParamByName('UPDT_USID').AsString := _mUserId;
//                                           oraQryUpdate.ParamByName('UPDT_ADDR').AsString := ' ';
//
//                                           oraQryUpdate.Execute;
//                                       end;
//                                    end
                                    else  if (yetaPrc3170Vo.getCtrbTycd().equals("40"))  {  // if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '40' then
                                   
                                    	 if ( mTempOData40.compareTo(BigDecimal.ZERO) < 0) { // if  mTempOData40 < 0 then
                                      
                                             mTempData    = mTempOData40;
                                             mTempOData40 = yetaPrc3170Vo.getDetrAmnt().subtract((mTempData.multiply(new BigDecimal("-1")))) ;
                                             //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;


                                             if  (mTempOData40.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempOData40 >= 0 then
                                          
                                            	  upInfcPkgYeta3170Vo.setDyyrDeam((mTempData.multiply(new BigDecimal("-1"))));    /** column 해당연도공제금액 : dyyrDeam */
        											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
        											 upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData40);    /** column 해당년도_미공제이월금액 : ayyrNtam */

                                            // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=    FloatToStr((mTempData * -1));
                                            // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData40) ;

                                             }
                                           else
                                           {

                                        	 upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */  
   											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
   										     upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
   										   
                                           //  oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                            // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                           }

                                           upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                           upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                           upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                           upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                           upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                           //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                           //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                           //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                           //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                           //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                           //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                            
                                            
                                           upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                           upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                           upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                           
                                           statCnt = 0;
                           		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  ;
 
                                    	 }
                                       else
                                       {
                                         //연산된값이 + 인경우

                                           mTempOData40  = yetaPrc3170Vo.getDetrAmnt().subtract(mTempOData40); 
                                               //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempOData40 ;

                                           if  (mTempOData40.compareTo(BigDecimal.ZERO) >= 0)  {   //if  mTempOData40 >= 0 then
                                          
                                        	 upInfcPkgYeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciOnam40"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
   											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
                                      	     upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData40);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                      	   
                                            // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_ONAM_40').AsString;
                                            // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData40) ;

                                           }
                                           else
                                           {
                                        	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */   
     											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
     										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
     										     
                                            // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                            // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                           }

                                           upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                           upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                           upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                           upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                           upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                           //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                           //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                           //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                           //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                           //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                           //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                            
                                            
                                           upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                           upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                           upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                           
                                           statCnt = 0;
                           		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  

                                       }
                                    }
                                    else  if (yetaPrc3170Vo.getCtrbTycd().equals("41"))  {  // if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '41' then
                                    
                                        
                                    	if ( mTempOData41.compareTo(BigDecimal.ZERO) < 0) { // if  mTempOData41 < 0 then
                                        
                                             mTempData    = mTempOData41;
                                             mTempOData41 =  yetaPrc3170Vo.getDetrAmnt().subtract((mTempData.multiply(new BigDecimal("-1")))) ;  
                                                 //oraQrySelect05.FieldByName('DETR_AMNT').AsFloat   - (mTempData * -1) ;


                                             if  (mTempOData41.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempOData41 >= 0 then
                                            
                                            	 upInfcPkgYeta3170Vo.setDyyrDeam((mTempData.multiply(new BigDecimal("-1"))));    /** column 해당연도공제금액 : dyyrDeam */
       											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
       											 upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData41);    /** column 해당년도_미공제이월금액 : ayyrNtam */
       											 
                                             //  oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   FloatToStr((mTempData * -1));
                                             //  oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=  FloatToStr( mTempOData41) ;

                                             }
                                             else
                                             {
                                            	  upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */  
      											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
      										   upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
      										   
                                              // oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                              // oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                             }

                                             upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                             upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                             upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                             upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                             upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                             //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                             //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                             //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                             //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                             //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                             //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                              
                                              
                                             upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                             upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                             upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                             
                                             statCnt = 0;
                             		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  
                                    	}
                                       else
                                       {
                                         //연산된값이 + 인경우
                                         mTempOData41  =  yetaPrc3170Vo.getDetrAmnt().subtract(mTempOData41);   
                                           // oraQrySelect05.FieldByName('DETR_AMNT').AsFloat  - mTempOData41 ;

                                         if  (mTempOData41.compareTo(BigDecimal.ZERO) >= 0)  {  // if  mTempOData41 >= 0 then
                                        
                                        	 upInfcPkgYeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciOyam41"),"0")));    /** column 해당연도공제금액 : dyyrDeam */
 											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
                                    	   upInfcPkgYeta3170Vo.setAyyrNtam(mTempOData41);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                    	   
                                           //oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect04.FieldByName('SPCI_OYAM_41').AsString;
                                           //oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   FloatToStr(mTempOData41) ;

                                         }
                                         else
                                         {
                                        	   upInfcPkgYeta3170Vo.setDyyrDeam(yetaPrc3170Vo.getDetrAmnt());    /** column 해당연도공제금액 : dyyrDeam */   
     											 //upInfcPkgYeta3170Vo.setDyyrOtam(yeta3170Dto.getDyyrOtam());    /** column 해당년도_미공제소멸금액 : dyyrOtam */
     										     upInfcPkgYeta3170Vo.setAyyrNtam(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
                                              
                                         //  oraQryUpdate.ParamByName('DYYR_DEAM').AsString :=   oraQrySelect05.FieldByName('DETR_AMNT').AsString;
                                         //  oraQryUpdate.ParamByName('AYYR_NTAM').AsString :=   '0' ;

                                         }
                                        
                                         upInfcPkgYeta3170Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                         upInfcPkgYeta3170Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
                                         upInfcPkgYeta3170Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
                                         upInfcPkgYeta3170Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                         upInfcPkgYeta3170Vo.setCtrbSeqn(yetaPrc3170Vo.getCtrbSeqn());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;


                                         //upInfcPkgYeta3170Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
                                         //upInfcPkgYeta3170Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
                                         //upInfcPkgYeta3170Vo.setCtrbYrmn(yeta3170Dto.getCtrbYrmn());    /** column 기부조정명세기부연도 : ctrbYrmn */
                                         //upInfcPkgYeta3170Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
                                         //upInfcPkgYeta3170Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
                                         //upInfcPkgYeta3170Vo.setDetrAmnt(yeta3170Dto.getDetrAmnt());    /** column 공제대상금액 : detrAmnt */
                                          
                                          
                                         upInfcPkgYeta3170Vo.setIsmt(yetaPrc2000Vo.getIsmt());    /** column 수정자 : ismt */
                                         upInfcPkgYeta3170Vo.setRevnDt(yetaPrc2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                         upInfcPkgYeta3170Vo.setRevnAddr(yetaPrc2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                         
                                         statCnt = 0;
                         		  		statCnt = yetaPayr6430Service.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);  

                                       } 
                                    }
                                }
                        	 }
                             
                        	 
                         }
                        
                   }


                 }

                 //{2011-추가기능 끝   }
                 /**$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ 기부금 처리 단계 종료 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */
                  
                  
                 //  {retax-44}
                   /**#######################  공제 대상금액  구하는 부분 ############################################*/
               if (MSFSharedUtils.paramNull(dataCheck)) {         
                 statCnt = 0;
 		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR415_ReTax_2014_CREATE_12_1_Update(yetaPrc2000Vo); 
                  
 		  		if (statCnt >= 0) {   
 		  			 
 		  	    // {retax-45} 
 		       /**#######################  공제계  합산 부분 구하는 부분 ############################################*/
 		  			statCnt = 0;
 	 		 		statCnt = yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_12_Update(yetaPrc2000Vo);
 	 		         

 		      // {retax-46}
 		       /**#######################  차감소득금액 ############################################*/
 		   //  -----------------'차감소득금액     ----------------------------------
 		        
 		 		if (statCnt >= 0) {
 		 		statCnt = 0;
 		 		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_10_3_Update(yetaPrc2000Vo); 
 		       
 		      //  {retax-47}
 		       /**#######################  그밖의 소득공제 계 ############################################*/
 		 		if (statCnt >= 0) {  
 		 		statCnt = 0;
 		 		statCnt = yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_13_Update(yetaPrc2000Vo);
 	 		 		
 		 		if (statCnt >= 0) {     
 		  	    statCnt = 0;
 		  	    statCnt = YetaTaxCreateUpdate(yetaPrc2000Vo);
 		  		/****   여기 부터 표준세액공제 때문에 공통으로 처리 해야 함 0으로 처리 해야 할부분 에 대해 업데이트 처리도 해야함 검증을 위한쿼리 추가 ****/
 		  		 
		  		 /**####################### 표준세액공제에 대한 값 처리 ############################################*/
 		  	  if (statCnt >= 0) {
    		     
                  InfcPkgYeta3000VO tpYetaDscnPrc3000Vo = new InfcPkgYeta3000VO();  //연말정산결과  
           
            
                 tpYetaDscnPrc3000Vo = yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2015_DCSN_INCM_Select(yetaPrc2000Vo);
		  		
                 if (MSFSharedUtils.paramNotNull(tpYetaDscnPrc3000Vo) || MSFSharedUtils.paramNotNull(tpYetaDscnPrc3000Vo.getTdcsnIncm())) { 
                	 
                	    if (!"2".equals(tpYetaDscnPrc3000Vo.getResdFlag())) {
					                	 BigDecimal rtnAlryPinx01 = BigDecimal.ZERO; //표준공제로 뺀값 
					                	 BigDecimal rtnAlryPinx02 = BigDecimal.ZERO; //정상계산으로처히한값 
					                	 
					                	 if (tpYetaDscnPrc3000Vo.getTdcsnIncm().compareTo(BigDecimal.ZERO) < 0) {
					                		 rtnAlryPinx01 =  BigDecimal.ZERO.subtract(tpYetaDscnPrc3000Vo.getAlryPinx());
					                	 } else {
					                		 rtnAlryPinx01 =  tpYetaDscnPrc3000Vo.getTdcsnIncm().subtract(tpYetaDscnPrc3000Vo.getAlryPinx());
					                	 } 
					                	 //정상처리 
					                	 rtnAlryPinx02 = tpYetaDscnPrc3000Vo.getDcsnIncm().subtract(tpYetaDscnPrc3000Vo.getAlryPinx());
					                	 
					                	 if (rtnAlryPinx01.compareTo(rtnAlryPinx02) <  0) {
					                		 /**
					                		  * 1. 0으로 처리해야 하는 부분 업데이트 하기            
					                		  */
					                		    InfcPkgYeta3000VO dscnPrc3000Vo = new InfcPkgYeta3000VO(); 
					                		    dscnPrc3000Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
					                		    dscnPrc3000Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
					                		    dscnPrc3000Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
					                		    dscnPrc3000Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
					  
					                		    dscnPrc3000Vo.setSpciBhth(BigDecimal.ZERO);    /** column 특별공제_종건강보험료 : spciBhth */
					                		    dscnPrc3000Vo.setSpciJhth(BigDecimal.ZERO);    /** column 특별공제_주건강보험료 : spciJhth */
					                		    dscnPrc3000Vo.setSpciBepf(BigDecimal.ZERO);    /** column 특별공제_종고용보험료 : spciBepf */
					                		    dscnPrc3000Vo.setSpciJepf(BigDecimal.ZERO);    /** column 특별공제_주고용보험료 : spciJepf */
					                		    dscnPrc3000Vo.setSpciGurt(BigDecimal.ZERO);    /** column 특별공제_일반보장성보험료 : spciGurt */
					                		    dscnPrc3000Vo.setSpciHdrc(BigDecimal.ZERO);    /** column 특별공제_장애인보장성보험료 : spciHdrc */
					                		    dscnPrc3000Vo.setSpciRtde(BigDecimal.ZERO);    /** column 특별공제_보장성보혐료세액공제금액 : spciRtde */
					                	         
					                		    dscnPrc3000Vo.setSpciTxcr(BigDecimal.ZERO);    /** column 특별공제_의료비세액공제액 : spciTxcr */
					                		    dscnPrc3000Vo.setSpedTxcr(BigDecimal.ZERO);    /** column 특별공제_교육비세액공제금액 : spedTxcr */
					                		    dscnPrc3000Vo.setSpciRefn(BigDecimal.ZERO);    /** column 특별공제_차입금원리금상환액_대출기관 : spciRefn */
					                		    dscnPrc3000Vo.setSpciResf(BigDecimal.ZERO);    /** column 특별공제_차입금원리금상환액_거주자 : spciResf */
					                		    dscnPrc3000Vo.setSpciRtam(BigDecimal.ZERO);    /** column 특별공제_주택자금월세공제액 : spciRtam */ 
					                		    dscnPrc3000Vo.setSpciTgrt(BigDecimal.ZERO);    /** column 특별공제_주택자금월세공제액 : SPCI_TGRT */ 
					                		    
					                		    dscnPrc3000Vo.setSpchRe15(BigDecimal.ZERO);    /** column 특별공제_11장기주택저당차입금15 : spchRe15 */
					                		    dscnPrc3000Vo.setSpchRe29(BigDecimal.ZERO);    /** column 특별공제_11장기주택저당차입금29 : spchRe29 */
					                		    dscnPrc3000Vo.setSpchRe30(BigDecimal.ZERO);    /** column 특별공제_11장기주택저당차입금30 : spchRe30 */
					                	        dscnPrc3000Vo.setSpciRefx(BigDecimal.ZERO);    /** column 특별공제_12장기주택저당차입금_고정 : spciRefx */
					                	        dscnPrc3000Vo.setSpciReec(BigDecimal.ZERO);    /** column 특별공제_12장기주택저당차입금_기타 : spciReec */
					                	        dscnPrc3000Vo.setSpci15fx(BigDecimal.ZERO);    /** column 특별공제_15장기주택저당_15고정AND비거치상환 : spci15fx */
					                	        dscnPrc3000Vo.setSpci15fb(BigDecimal.ZERO);    /** column 특별공제_15장기주택저당_15고정OR비거치상환 : spci15fb */
					                	        dscnPrc3000Vo.setSpci15ec(BigDecimal.ZERO);    /** column 특별공제_15장기주택저당_15기타대출 : spci15ec */
					                	        dscnPrc3000Vo.setSpci10fb(BigDecimal.ZERO);    /** column 특별공제_15장기주택저당_10고정OR비거치상환 : spci10fb */
					                	        dscnPrc3000Vo.setSpci10ec(BigDecimal.ZERO);    /** column 특별공제_15장기주택저당_10기타대출 : spci10ec */ 
					                	        dscnPrc3000Vo.setSpciFbam(BigDecimal.ZERO);    /** column 특별공제_기부금_법정 : spciFbam */
					 
					                	        dscnPrc3000Vo.setSpciYamt(BigDecimal.ZERO);    /** column 특별공제_기부금_종교단체 : spciYamt */
					                	        dscnPrc3000Vo.setSpciNamt(BigDecimal.ZERO);    /** column 특별공제_기부금_종교단체외 : spciNamt */ 
					                	        dscnPrc3000Vo.setSpciSsum(BigDecimal.ZERO);    /** column 특별공제_이월기부금공제액계 : spciSsum */
					                	        
					                	         statCnt = 0;
					                		  	 statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_DCSN_INCM_Update(dscnPrc3000Vo); 
					                		 
					                		  	if (statCnt >= 0) {  	 
					                		  	 
					                		  	 InfcPkgYeta2000VO dscnPrc2000Vo = new InfcPkgYeta2000VO(); 
					                		  	dscnPrc2000Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
					                		  	dscnPrc2000Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
					                		  	dscnPrc2000Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
					                		  	dscnPrc2000Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
						                		  
					                			dscnPrc2000Vo.setSpciRttg(BigDecimal.ZERO);    /** column 특별공제_보장성보험료공제대상금액 : spciRttg */
					                			dscnPrc2000Vo.setSpciHdtg(BigDecimal.ZERO);    /** column 특별공제_장애인보장성대상금액 : spciHdtg */
												dscnPrc2000Vo.setSpciDetg(BigDecimal.ZERO);    /** column 특별공제_보장성보험료대상금액 : spciDetg */
												dscnPrc2000Vo.setSpciDtar(BigDecimal.ZERO);    /** column 특별공제_의료비세액공제대상금액 : spciDtar */
												dscnPrc2000Vo.setSpedEtar(BigDecimal.ZERO);    /** column 특별공제_교육비공제대상금액 : spedEtar  */
												dscnPrc2000Vo.setSpciFbtg(BigDecimal.ZERO);    /** column 특별공제_기부금_법정대상금액 : spciFbtg */
												dscnPrc2000Vo.setSpciFb14(BigDecimal.ZERO);    /** column 법정기부금2014대상금액 : spciFb14   */
												dscnPrc2000Vo.setSpciYa14(BigDecimal.ZERO);    /** column 종교단체2014대상금액 : spciYa14    */
												dscnPrc2000Vo.setSpciNa14(BigDecimal.ZERO);    /** column 총교단체외2014대상금액 : spciNa14   */
												dscnPrc2000Vo.setSpciNatg(BigDecimal.ZERO);    /** column 종교단체외지정대상금액 : spciNatg */
												dscnPrc2000Vo.setSpciYatg(BigDecimal.ZERO);    /** column 종교단체지정대상금액 : spciYatg */
												  
												
					                		  	 statCnt = 0;
					                		  	 statCnt =  yetaPayr6430Service.yeta2000_ReTax_2015_DCSN_INCM_Update(dscnPrc2000Vo); 
					                		  	 
					                	 }
					                		   if (statCnt >= 0) {
					                			  // {retax-45} 
					                		       /**#######################  공제계  합산 부분 구하는 부분 ############################################*/
					                		  			statCnt = 0;
					                	 		 		statCnt = yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_12_Update(yetaPrc2000Vo);
					                	 		          
					                		      // {retax-46}
					                		       /**#######################  차감소득금액 ############################################*/
					                		   //  -----------------'차감소득금액     ----------------------------------
					                		        
					                		 		if (statCnt >= 0) {
					                		 		statCnt = 0;
					                		 		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_10_3_Update(yetaPrc2000Vo); 
					                		        
					                		 		
									           	 		 	  if (statCnt >= 0) {
									           	 		 		  yetaPrc2000Vo.setSpciDdctCheck("TRUE");
									           	 		 		  statCnt = 0;
									           	 		 		  statCnt =  YetaSubtCreateUpdate(yetaPrc2000Vo); 
										               		  	    
									           	 		 	 //  {retax-47}
									                		       /**#######################  그밖의 소득공제 계 ############################################*/
									                		 		if (statCnt >= 0) {  
									                		 		statCnt = 0;
									                		 		statCnt = yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_13_Update(yetaPrc2000Vo);
									                		 		
											               		       if (statCnt >= 0) {
											               		  	    statCnt = 0;
											               		  	    statCnt =  YetaTaxCreateUpdate(yetaPrc2000Vo);
											               		  	    }
									                		 		}
									           	 		 	    }  
					                		      }
					                		  }
					                	 } else  {
					                		 yetaPrc2000Vo.setSpciDdctCheck("FALSE");
					                		  if (statCnt >= 0) {
					                			 
					                			    statCnt = 0;
					                 		  	    statCnt = YetaSubtCreateUpdate(yetaPrc2000Vo);
					                 		  	  if (statCnt >= 0) {	    
					                 		  	  //  {retax-47}
					                 		       /**#######################  그밖의 소득공제 계 ############################################*/ 
					                 		 		statCnt = 0;
					                 		 		statCnt = yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_13_Update(yetaPrc2000Vo);
					                 		 	  
					               		  	       } 
					                		  }	  
					                	}	  
			                	 } else {
			                		  yetaPrc2000Vo.setSpciDdctCheck("FALSE");
			                		 if (statCnt >= 0) {
			                			 
			                			    statCnt = 0;
			                 		  	    statCnt = YetaSubtCreateUpdate(yetaPrc2000Vo);
			                 		  	  if (statCnt >= 0) {	    
			                 		  	  //  {retax-47}
			                 		       /**#######################  그밖의 소득공제 계 ############################################*/ 
			                 		 		statCnt = 0;
			                 		 		statCnt = yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_13_Update(yetaPrc2000Vo);
			                 		 	  
			               		  	  } 
			                		 }	  	  
			                  }  
                 
                
                 // {retax-62}
                  /**#######################  //납부또는 환급세액 ############################################*/ 
		  		if (statCnt >= 0) {  
		  		statCnt = 0;
		  		statCnt =   yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_18_Update(yetaPrc2000Vo); 
                 
                
                // {retax-63}
                 /**####################### 차감징수세액 총계  ############################################*/ 
		  		if (statCnt >= 0) {
		  		statCnt = 0;
		  		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_19_Update(yetaPrc2000Vo); 
		  		}
		  		}
                 }  
               }
		  	   }
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  		}
		  	    }
		  		}
		  	    }
		  		}
		  	    }
		  	   }
		  	   }
		  	 /************************* 대상자별로 루프 종료 ***************************************************/ 
		  	 
		  	 bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + String.valueOf(lstInfcPkgYeta2000Vo.size()) + "명처리완료","데이타확인",""));  
		  	 retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());  
		  	   
	  	} catch (Exception ex) {
           ex.printStackTrace();
	   	   ShowMessageBM smBm = new ShowMessageBM();
	   	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
	   	   smBm.setMenu("Yeta");
	   	   smBm.setPhase("[연말정산세액계산]세액계산 에러");
	   	   smBm.setMessage(ex.getLocalizedMessage());
	   	   smBm.setContent(ex.getMessage());
	   	   bmResult.add(smBm);  
	   	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
 	 
    } 
	  	   
	  	  return  retval;
  }
    
    
   /**
    * 
    * <pre>
    * 1. 개요 :  그 밖의 소득공제 처리  
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : YetaSubtCreateUpdate
    * @date : Feb 25, 2016
    * @author : leeheuisung
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	Feb 25, 2016		leeheuisung				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @param yetaPrc2000Vo
    * @return
    * @throws Exception
    */
    private  int YetaSubtCreateUpdate(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
		 
      int statCnt = 0;
   	  String dataCheck = "";
   	     
   	  BigDecimal exSUBT_ERAM = BigDecimal.ZERO;
      BigDecimal exTpSUBT_ERAM = BigDecimal.ZERO;
      BigDecimal exETCP_PSNV = BigDecimal.ZERO; 
      BigDecimal exETCH_PREP = BigDecimal.ZERO;
      BigDecimal exETCS_COMP = BigDecimal.ZERO;
      BigDecimal exETWK_SBAM = BigDecimal.ZERO;
      BigDecimal exETWK_SVAM = BigDecimal.ZERO;
          
      BigDecimal exETGD_DDAM = BigDecimal.ZERO;
      BigDecimal exETCC_CARD = BigDecimal.ZERO;
      BigDecimal exETCK_UNON = BigDecimal.ZERO;
      BigDecimal exETCK_UNCR = BigDecimal.ZERO;
      BigDecimal exETEP_MSAM = BigDecimal.ZERO;
      BigDecimal exETGD_HTRA = BigDecimal.ZERO;
      BigDecimal exETEP_SECR = BigDecimal.ZERO;
    	
   	  /******************************************************************************************
	        차감소득금액에 따른 공제 금액 처리 루틴 추가  따른 세액공제 0처리 및 단계별 빼기 작업을 위한 구현 부
	      
	      *******************************************************************************************/  
		      InfcPkgYeta3000VO subInfcPkgYeta3000Vo = new InfcPkgYeta3000VO();  //연말정산결과  
		      InfcPkgYeta3000VO tpSubInfcPkgYeta3000Vo = new InfcPkgYeta3000VO();  //연말정산결과  
		      
		      
		      subInfcPkgYeta3000Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
		      subInfcPkgYeta3000Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
		      subInfcPkgYeta3000Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
		      subInfcPkgYeta3000Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
		      
		      tpSubInfcPkgYeta3000Vo = yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_SPCI_Select_Update(subInfcPkgYeta3000Vo); 
		  
		       
		      
		      if (MSFSharedUtils.paramNotNull(tpSubInfcPkgYeta3000Vo) && MSFSharedUtils.paramNotNull(tpSubInfcPkgYeta3000Vo.getSystemkey())) {
		     
		    	  // 차감소득금액 처리 루틴 추가  
		    	  exSUBT_ERAM  = tpSubInfcPkgYeta3000Vo.getSubtEram() ;    //차감소득금액 

		          exTpSUBT_ERAM  = exSUBT_ERAM;
		    	  
		          exETCP_PSNV  = tpSubInfcPkgYeta3000Vo.getEtcpPsnv();        /* (38)column 개인연금저축불입액_2000년이전 : ETCP_PSNV */
		          if (exTpSUBT_ERAM.compareTo(exETCP_PSNV) > 0) {
		             exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETCP_PSNV);
		          }
		          else
		          {
		             exETCP_PSNV = BigDecimal.ZERO;
		             if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
		                 exETCP_PSNV = exTpSUBT_ERAM;
		                 exTpSUBT_ERAM = BigDecimal.ZERO;
		             }

		          }
		          exETCH_PREP  = tpSubInfcPkgYeta3000Vo.getEtchPrep();       /* (39) column 기타공제_소기업공제불입금 : ETCH_PREP */
		           if (exTpSUBT_ERAM.compareTo(exETCH_PREP) > 0) {
		             exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETCH_PREP);
		           }
		           else
		           {
		             exETCH_PREP = BigDecimal.ZERO;
		              if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
		                 exETCH_PREP = exTpSUBT_ERAM;
		                 exTpSUBT_ERAM = BigDecimal.ZERO;
		              }
		          }
		          exETCS_COMP   = tpSubInfcPkgYeta3000Vo.getEtcsComp(); /*(40)-가 column 기타공제_주택마련저축_청약저축 : ETCS_COMP */
		           if (exTpSUBT_ERAM.compareTo(exETCS_COMP) > 0)   {
		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETCS_COMP);
		           }
		           else
		           {
		              exETCS_COMP = BigDecimal.ZERO;
		             if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
		                 exETCS_COMP = exTpSUBT_ERAM;
		                 exTpSUBT_ERAM = BigDecimal.ZERO;
		             }
		           }
		           
		          exETWK_SBAM  = tpSubInfcPkgYeta3000Vo.getEtwkSbam(); /* (40)-나column 기타공제_주택마련저축_주택청약종합저축 : ETWK_SBAM */
		        if (exTpSUBT_ERAM.compareTo(exETWK_SBAM) > 0)  {
		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETWK_SBAM);
		        }
		        else
		        {
		           exETWK_SBAM = BigDecimal.ZERO;
		              if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
		                exETWK_SBAM   = exTpSUBT_ERAM;
		                exTpSUBT_ERAM = BigDecimal.ZERO;
		              }
		        }
		      
		          exETWK_SVAM  = tpSubInfcPkgYeta3000Vo.getEtwkSvam();    /*(40)-다 column 기타공제_주택마련저축_근로자주택마련저축 : ETWK_SVAM */
		          if (exTpSUBT_ERAM.compareTo(exETWK_SVAM) > 0)  {   
		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETWK_SVAM);
		          }
		          else
		          {
		            exETWK_SVAM = BigDecimal.ZERO;
		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
		                 exETWK_SVAM  = exTpSUBT_ERAM;
		                 exTpSUBT_ERAM = BigDecimal.ZERO;
		            }
		          }
		          exETGD_DDAM  = tpSubInfcPkgYeta3000Vo.getEtgdDdam(); /* (41) column 기타공제_투자조합출자공제액계 : ETGD_DDAM */
		        if (exTpSUBT_ERAM.compareTo(exETGD_DDAM) > 0)   {
		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETGD_DDAM);
		        }
		        else
		        {
		           exETGD_DDAM = BigDecimal.ZERO;
		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
		                exETGD_DDAM   = exTpSUBT_ERAM;
		                exTpSUBT_ERAM = BigDecimal.ZERO;
		            }
		        }

		        exETCC_CARD  = tpSubInfcPkgYeta3000Vo.getEtccCard() ; /*(42) column 기타공제_신용카드등사용액소득공제 : ETCC_CARD */
		        if (exTpSUBT_ERAM.compareTo(exETCC_CARD) > 0)      {
		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETCC_CARD);
		        }
		        else
		        {
		           exETCC_CARD = BigDecimal.ZERO;
		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
		                exETCC_CARD   = exTpSUBT_ERAM;
		                exTpSUBT_ERAM = BigDecimal.ZERO;
		            }
		        }

		            exETCK_UNON  = tpSubInfcPkgYeta3000Vo.getEtckUnon(); /*(43) column 기타공제_우리사주출연금공제 : ETCK_UNON */
		        if (exTpSUBT_ERAM.compareTo(exETCK_UNON) > 0) {
		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETCK_UNON);
		        }
		        else
		        {
		           exETCK_UNON = BigDecimal.ZERO;
		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO)  > 0) {
		                exETCK_UNON   = exTpSUBT_ERAM;
		                exTpSUBT_ERAM = BigDecimal.ZERO;
		            }
		        } 
		        
		          exETCK_UNCR  = tpSubInfcPkgYeta3000Vo.getEtckUncr();  /*(44) column 기타공제_우리사주조합기부금공제2014이전 : ETCK_UNCR */
		           if (exTpSUBT_ERAM.compareTo(exETCK_UNCR ) > 0) {
		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETCK_UNCR);
		           }
		        else
		        {
		           exETCK_UNCR  = BigDecimal.ZERO;
		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO)  > 0) {
		               exETCK_UNCR    = exTpSUBT_ERAM;
		               exTpSUBT_ERAM  = BigDecimal.ZERO;
		            }
		        }

		        exETEP_MSAM  = tpSubInfcPkgYeta3000Vo.getEtepMsam(); /*(45) column 기타공제_고용유지중소기업근로자임금삭감공제액 : ETEP_MSAM */
		           if (exTpSUBT_ERAM.compareTo(exETEP_MSAM ) > 0) {
		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETEP_MSAM);
		           }
		        else
		        {
		           exETEP_MSAM  = BigDecimal.ZERO;
		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO)  > 0) {
		               exETEP_MSAM    = exTpSUBT_ERAM;
		               exTpSUBT_ERAM  = BigDecimal.ZERO;
		            }
		        }
		       
		          exETGD_HTRA  = tpSubInfcPkgYeta3000Vo.getEtgdHtra(); /*(46) column 기타공제_목돈안드는전세이자상환소득공제액 : ETGD_HTRA */
		        if (exTpSUBT_ERAM.compareTo(exETGD_HTRA ) > 0) {
		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETGD_HTRA);
		          }
		        else
		        {
		           exETGD_HTRA  = BigDecimal.ZERO;
		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO)  > 0)  {
		              exETGD_HTRA     = exTpSUBT_ERAM;
		              exTpSUBT_ERAM  = BigDecimal.ZERO;
		            }
		        }
		        
		          exETEP_SECR  = tpSubInfcPkgYeta3000Vo.getEtepSecr(); /*(47) column 기타공제_장기집합투자증권저축공제액 : ETEP_SECR */
		          if (exTpSUBT_ERAM.compareTo(exETEP_SECR) > 0)  {
		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETEP_SECR);
		          }
		        else
		        {
		           exETEP_SECR  = BigDecimal.ZERO;
		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO)  > 0) {
		                exETEP_SECR   = exTpSUBT_ERAM;
		                exTpSUBT_ERAM  = BigDecimal.ZERO;
		            }
		        }
		       
		         
		          //   {retax-57}
					/**#######################      ############################################*/
		          subInfcPkgYeta3000Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
		          subInfcPkgYeta3000Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
		          subInfcPkgYeta3000Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
		          subInfcPkgYeta3000Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
		     
 
	 		        subInfcPkgYeta3000Vo.setEtcpPsnv(exETCP_PSNV);    /** column 개인연금저축불입액_2000년이전 : etcpPsnv */  
			        subInfcPkgYeta3000Vo.setEtchPrep(exETCH_PREP);    /** column 기타공제_소기업공제불입금 : etchPrep */
			        subInfcPkgYeta3000Vo.setEtcsComp(exETCS_COMP);    /** column 기타공제_주택마련저축_청약저축 : etcsComp */
			        subInfcPkgYeta3000Vo.setEtwkSbam(exETWK_SBAM);    /** column 기타공제_주택마련저축_주택청약종합저축 : etwkSbam */
			        subInfcPkgYeta3000Vo.setEtwkSvam(exETWK_SVAM);    /** column 기타공제_주택마련저축_근로자주택마련저축 : etwkSvam */  
			        subInfcPkgYeta3000Vo.setEtgdDdam(exETGD_DDAM);    /** column 기타공제_투자조합출자공제액계 : etgdDdam */
			        subInfcPkgYeta3000Vo.setEtccCard(exETCC_CARD);    /** column 기타공제_신용카드등사용액소득공제 : etccCard */
			        subInfcPkgYeta3000Vo.setEtckUnon(exETCK_UNON);    /** column 기타공제_우리사주출연금공제 : etckUnon */
			        subInfcPkgYeta3000Vo.setEtckUncr(exETCK_UNCR);    /** column 기타공제_우리사주조합기부금공제2014이전 : etckUncr */
			        subInfcPkgYeta3000Vo.setEtepMsam(exETEP_MSAM);    /** column 기타공제_고용유지중소기업근로자임금삭감공제액 : etepMsam */
			        subInfcPkgYeta3000Vo.setEtgdHtra(exETGD_HTRA);    /** column 기타공제_목돈안드는전세이자상환소득공제액 : etgdHtra */
			        subInfcPkgYeta3000Vo.setEtepSecr(exETEP_SECR);    /** column 기타공제_장기집합투자증권저축공제액 : etepSecr */ 
			     
		        
		        statCnt = 0;
			  	statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2015_SUBT_Update(subInfcPkgYeta3000Vo); 
			  	
			  	
			  	 
		      }
   	    return statCnt;
    }
  private  int YetaTaxCreateUpdate(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	  
	  int statCnt = 0;
	  String dataCheck = "";
 
      BigDecimal exPRDD_TAXN   = BigDecimal.ZERO;
      BigDecimal exTAXD_ICAX   = BigDecimal.ZERO;
      BigDecimal exTAXD_SPCT   = BigDecimal.ZERO;
      BigDecimal exTXLG_CL30   = BigDecimal.ZERO;
      BigDecimal exTXLG_HXTT   = BigDecimal.ZERO;
      BigDecimal exTAXD_TSUM   = BigDecimal.ZERO;
      BigDecimal exTAXD_WKEN   = BigDecimal.ZERO;
      BigDecimal exADDR_MCCR   = BigDecimal.ZERO;
      BigDecimal exJRTR_HICT   = BigDecimal.ZERO;
      BigDecimal exJRTR_PSRN   = BigDecimal.ZERO;
      BigDecimal exJRTR_HNSV    = BigDecimal.ZERO;
      BigDecimal exSPCI_RTDE   = BigDecimal.ZERO;
      BigDecimal exSPCI_TXCR   = BigDecimal.ZERO;
      BigDecimal exSPED_TXCR   = BigDecimal.ZERO;
      BigDecimal exTAXD_PLTC   = BigDecimal.ZERO;
      BigDecimal exSPCI_PLTC   = BigDecimal.ZERO;
      BigDecimal exSPCI_FBAM   = BigDecimal.ZERO;
      BigDecimal  exSPCI_RFAM  = BigDecimal.ZERO;
      BigDecimal exSPCI_NAMT   = BigDecimal.ZERO;
      BigDecimal exSPCI_DCTO   = BigDecimal.ZERO;
      BigDecimal exSPCI_DDCT   = BigDecimal.ZERO;
      BigDecimal exTAXD_UNIN   = BigDecimal.ZERO;
      BigDecimal exTAXD_LOAN   = BigDecimal.ZERO;
      BigDecimal exTAXD_PAID   = BigDecimal.ZERO;
      BigDecimal exSPCI_RTAM   = BigDecimal.ZERO;                  
      BigDecimal exTAXD_CSUM   = BigDecimal.ZERO;
      BigDecimal exTpPRDD_TAXN   = BigDecimal.ZERO;
      BigDecimal exSPCI_YAMT   = BigDecimal.ZERO;
      BigDecimal exADDR_CHLD   = BigDecimal.ZERO; 
      BigDecimal exADDR_BRTH   = BigDecimal.ZERO;
      BigDecimal exSPCI_GURT   = BigDecimal.ZERO;
      BigDecimal exSPCI_HDRC   = BigDecimal.ZERO;
	  
  
       
     //   {retax-48}
      /**#######################  특별공제 종합한도초과액 - 기타공제계 ############################################*/
      //   ---------------------특별공제 종합한도초과액 - 기타공제계-----------------
		if (statCnt >= 0) {
		statCnt = 0;
		statCnt = yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_13_4_Update(yetaPrc2000Vo);
       
      //    {retax-49}
      /**#######################  종합소득과세표준  기타공제계 ############################################*/
		if (statCnt >= 0) {
		statCnt = 0;
		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_13_1_Update(yetaPrc2000Vo);
       
      // {retax-50}
       /**#######################  산출세액- 기타공제계- ############################################*/
		if (statCnt >= 0) {    
		statCnt = 0;
		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_13_2_Update(yetaPrc2000Vo);
        
      //   {retax-51}
      /**#######################  산출세액-세액감면  ############################################*/
		if (statCnt >= 0) {  
		statCnt = 0;
		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_14_TX_Update(yetaPrc2000Vo);
       
      //  {retax-52}
      /**#######################  세액공제 -근로소득공제 감면세액계   ############################################*/
		if (statCnt >= 0) {
		statCnt = 0;
		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_14_Update(yetaPrc2000Vo);
        
     //     {retax-53}
      /**#######################  세액공제 주택차입금 ----- 외국납부 TODO  결과값 확인 쿼리수정   ############################################*/
		if (statCnt >= 0) { 
		statCnt = 0;
		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_14_1_Update(yetaPrc2000Vo);
       
       //   {retax-54}
          /**#######################      ############################################*/
		if (statCnt >= 0) {
		statCnt = 0;
		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_BEF_12_1_Update(yetaPrc2000Vo); 
       
     //   {retax-55}
      /**#######################      ############################################*/
		if (statCnt >= 0) {
	 
			if ("TRUE".equals(yetaPrc2000Vo.getSpciDdctCheck())) {
				yetaPrc2000Vo.setSpciDdct(new BigDecimal("130000"));
			} else {
				yetaPrc2000Vo.setSpciDdct(BigDecimal.ZERO);
			}
		statCnt = 0;
		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_BEF01_12_1_Update(yetaPrc2000Vo); 
       
      /******************************************************************************************
      산출세액에 따른 세액공제 0처리 및 단계별 빼기 작업을 위한 구현 부
      
      *******************************************************************************************/  
		if (statCnt >= 0) {
		// {retax-56}
     /**#######################      ############################################*/
      InfcPkgYeta3000VO yetaPrc3000Vo = new InfcPkgYeta3000VO();  //연말정산결과  
      InfcPkgYeta3000VO tpInfcPkgYeta3000Vo = new InfcPkgYeta3000VO();  //연말정산결과  
      
      
      yetaPrc3000Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
      yetaPrc3000Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
      yetaPrc3000Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
      yetaPrc3000Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
      
      tpInfcPkgYeta3000Vo = yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_SPCI_Select_Update(yetaPrc3000Vo); 
  
       
      if (MSFSharedUtils.paramNotNull(tpInfcPkgYeta3000Vo) && MSFSharedUtils.paramNotNull(tpInfcPkgYeta3000Vo.getSystemkey())) {
      
    	  
          exTpPRDD_TAXN  = BigDecimal.ZERO;
          
          exPRDD_TAXN  = tpInfcPkgYeta3000Vo.getPrddTaxn() ;    //산출세액

          exTpPRDD_TAXN  = exPRDD_TAXN;

          exTAXD_ICAX  = tpInfcPkgYeta3000Vo.getTaxdIcax(); //oraQrySelect05.FieldByName('TAXD_ICAX').AsFloat;     //소득세법
          if (exTpPRDD_TAXN.compareTo(exTAXD_ICAX) > 0) {
             exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_ICAX);
          }
          else
          {
             exTAXD_ICAX = BigDecimal.ZERO;
             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
                 exTAXD_ICAX = exTpPRDD_TAXN;
                 exTpPRDD_TAXN = BigDecimal.ZERO;
             }

          }
          exTAXD_SPCT  = tpInfcPkgYeta3000Vo.getTaxdSpct(); //oraQrySelect05.FieldByName('TAXD_SPCT').AsFloat;      //조세특례법54제회
           if (exTpPRDD_TAXN.compareTo(exTAXD_SPCT) > 0) {
             exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_SPCT);
           }
           else
           {
             exTAXD_SPCT = BigDecimal.ZERO;
              if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
                 exTAXD_SPCT = exTpPRDD_TAXN;
                 exTpPRDD_TAXN = BigDecimal.ZERO;
              }
          }
          exTXLG_CL30   = tpInfcPkgYeta3000Vo.getTxlgCl30(); //oraQrySelect05.FieldByName('TXLG_CL30').AsFloat;      //조특법 제30조
           if (exTpPRDD_TAXN.compareTo(exTXLG_CL30) > 0)   {
           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTXLG_CL30);
           }
           else
           {
              exTXLG_CL30 = BigDecimal.ZERO;
             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
                 exTXLG_CL30 = exTpPRDD_TAXN;
                 exTpPRDD_TAXN = BigDecimal.ZERO;
             }
           }
           
          exTXLG_HXTT  = tpInfcPkgYeta3000Vo.getTxlgHxtt(); //oraQrySelect05.FieldByName('TXLG_HXTT').AsFloat;      //조세조약
        if (exTpPRDD_TAXN.compareTo(exTXLG_HXTT) > 0)  {
           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTXLG_HXTT);
        }
        else
        {
           exTXLG_HXTT = BigDecimal.ZERO;
              if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
                exTXLG_HXTT   = exTpPRDD_TAXN;
                exTpPRDD_TAXN = BigDecimal.ZERO;
              }
        }
       //   exTAXD_TSUM  := oraQrySelect05.FieldByName('TAXD_TSUM').AsFloat;      //세액감면계
          exTAXD_WKEN  = tpInfcPkgYeta3000Vo.getTaxdWken();   // oraQrySelect05.FieldByName('TAXD_WKEN').AsFloat;       //근로소득세액공제
          if (exTpPRDD_TAXN.compareTo(exTAXD_WKEN) > 0)  {   
           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_WKEN);
          }
          else
          {
            exTAXD_WKEN = BigDecimal.ZERO;
            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
                 exTAXD_WKEN  = exTpPRDD_TAXN;
                 exTpPRDD_TAXN = BigDecimal.ZERO;
            }
          }
          exADDR_MCCR  = tpInfcPkgYeta3000Vo.getAddrMccr(); //oraQrySelect05.FieldByName('ADDR_MCCR').AsFloat;       //자녀세액공제
        if (exTpPRDD_TAXN.compareTo(exADDR_MCCR) > 0)   {
           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exADDR_MCCR);
        }
        else
        {
           exADDR_MCCR = BigDecimal.ZERO;
            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
                exADDR_MCCR   = exTpPRDD_TAXN;
                exTpPRDD_TAXN = BigDecimal.ZERO;
            }
        }

        exADDR_CHLD  = tpInfcPkgYeta3000Vo.getAddrChld() ; //oraQrySelect05.FieldByName('ADDR_CHLD').AsFloat;       //추가공제_자녀양육비
        if (exTpPRDD_TAXN.compareTo(exADDR_CHLD) > 0)      {
           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exADDR_CHLD);
        }
        else
        {
           exADDR_CHLD = BigDecimal.ZERO;
            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
                exADDR_CHLD   = exTpPRDD_TAXN;
                exTpPRDD_TAXN = BigDecimal.ZERO;
            }
        }

            exADDR_BRTH  = tpInfcPkgYeta3000Vo.getAddrBrth() ; //oraQrySelect05.FieldByName('ADDR_BRTH').AsFloat;      //추가공제_출산자녀양육비
        if (exTpPRDD_TAXN.compareTo(exADDR_BRTH) > 0) {
           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exADDR_BRTH);
        }
        else
        {
           exADDR_BRTH = BigDecimal.ZERO;
            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
                exADDR_BRTH   = exTpPRDD_TAXN;
                exTpPRDD_TAXN = BigDecimal.ZERO;
            }
        }


        
          exSPCI_GURT  = tpInfcPkgYeta3000Vo.getSpciGurt(); // oraQrySelect05.FieldByName('SPCI_GURT').AsFloat;        //특별공제 보장성보험료공제
           if (exTpPRDD_TAXN.compareTo(exSPCI_GURT ) > 0) {
           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_GURT);
           }
        else
        {
           exSPCI_GURT  = BigDecimal.ZERO;
            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
               exSPCI_GURT    = exTpPRDD_TAXN;
               exTpPRDD_TAXN  = BigDecimal.ZERO;
            }
        }

        exSPCI_HDRC  = tpInfcPkgYeta3000Vo.getSpciHdrc(); //oraQrySelect05.FieldByName('SPCI_HDRC').AsFloat;        //특별공제 보장성보험료공제장애인
           if (exTpPRDD_TAXN.compareTo(exSPCI_HDRC ) > 0) {
           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_HDRC);
           }
        else
        {
           exSPCI_HDRC  = BigDecimal.ZERO;
            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
               exSPCI_HDRC    = exTpPRDD_TAXN;
               exTpPRDD_TAXN  = BigDecimal.ZERO;
            }
        }
        //보장성보험료 합계 수정 처리 루틴 추가 
        exSPCI_RTDE =   exSPCI_GURT.add(exSPCI_HDRC) ;

          exSPCI_TXCR  = tpInfcPkgYeta3000Vo.getSpciTxcr(); //oraQrySelect05.FieldByName('SPCI_TXCR').AsFloat;          //의료비세액공제
        if (exTpPRDD_TAXN.compareTo(exSPCI_TXCR ) > 0) {
           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_TXCR);
          }
        else
        {
           exSPCI_TXCR  = BigDecimal.ZERO;
            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
              exSPCI_TXCR     = exTpPRDD_TAXN;
              exTpPRDD_TAXN  = BigDecimal.ZERO;
            }
        }
        
          exSPED_TXCR  = tpInfcPkgYeta3000Vo.getSpedTxcr(); //oraQrySelect05.FieldByName('SPED_TXCR').AsFloat;         //교육비 세액공제
          if (exTpPRDD_TAXN.compareTo(exSPED_TXCR) > 0)  {
           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPED_TXCR);
          }
        else
        {
           exSPED_TXCR  = BigDecimal.ZERO;
            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
                exSPED_TXCR   = exTpPRDD_TAXN;
                exTpPRDD_TAXN  = BigDecimal.ZERO;
            }
        }
        
          exTAXD_PLTC  = tpInfcPkgYeta3000Vo.getTaxdPltc(); //oraQrySelect05.FieldByName('TAXD_PLTC').AsFloat;         //정치기부금 10만원이하 공제
          if (exTpPRDD_TAXN.compareTo(exTAXD_PLTC ) > 0) {
           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_PLTC);
          }
        else
        {
           exTAXD_PLTC  = BigDecimal.ZERO;
            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
               exTAXD_PLTC    = exTpPRDD_TAXN;
               exTpPRDD_TAXN  = BigDecimal.ZERO;
            }
        }
        
          exSPCI_PLTC  = tpInfcPkgYeta3000Vo.getSpciPltc(); //oraQrySelect05.FieldByName('SPCI_PLTC').AsFloat;         //정치기부금 10만원 초과 공제
           if (exTpPRDD_TAXN.compareTo(exSPCI_PLTC ) > 0)  {
           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_PLTC);
           }
        else
        {
           exSPCI_PLTC  = BigDecimal.ZERO;
            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
               exSPCI_PLTC    = exTpPRDD_TAXN;
               exTpPRDD_TAXN  = BigDecimal.ZERO;
            }
        }
      
        //  exSPCI_DCTO  := oraQrySelect05.FieldByName('SPCI_DCTO').AsFloat;          //특별세액공제계
          exSPCI_DDCT  = tpInfcPkgYeta3000Vo.getSpciDdct(); //oraQrySelect05.FieldByName('SPCI_DDCT').AsFloat;           //표준세액공제
         if (exTpPRDD_TAXN.compareTo(exSPCI_DDCT ) > 0)  {
           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_DDCT);
         }
        else
        {
           exSPCI_DDCT  = BigDecimal.ZERO;
            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
               exSPCI_DDCT    = exTpPRDD_TAXN;
               exTpPRDD_TAXN  = BigDecimal.ZERO;
            }
        }
          exTAXD_UNIN  = tpInfcPkgYeta3000Vo.getTaxdUnin(); //oraQrySelect05.FieldByName('TAXD_UNIN').AsFloat;           //납세조합공제
           if (exTpPRDD_TAXN.compareTo(exTAXD_UNIN ) > 0) {
           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_UNIN);
           }
        else
        {
           exTAXD_UNIN  = BigDecimal.ZERO;
            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
               exTAXD_UNIN    = exTpPRDD_TAXN;
               exTpPRDD_TAXN  = BigDecimal.ZERO;
            }
        }
          exTAXD_LOAN  = tpInfcPkgYeta3000Vo.getTaxdLoan(); //oraQrySelect05.FieldByName('TAXD_LOAN').AsFloat;            //주책차입금
          if (exTpPRDD_TAXN.compareTo(exTAXD_LOAN) > 0)  {
           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_LOAN);
          }
        else
        {
           exTAXD_LOAN = BigDecimal.ZERO;
            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
                exTAXD_LOAN   = exTpPRDD_TAXN;
                exTpPRDD_TAXN = BigDecimal.ZERO;
            }
        }
      
      
          exSPCI_RTAM  = tpInfcPkgYeta3000Vo.getSpciRtam(); //oraQrySelect05.FieldByName('SPCI_RTAM').AsFloat;            //월세액공제
        //  exTAXD_CSUM  := oraQrySelect05.FieldByName('TAXD_CSUM').AsFloat;
         if (exTpPRDD_TAXN.compareTo(exSPCI_RTAM) > 0)   {
           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_RTAM);
      }
        else
        {
           exSPCI_RTAM  = BigDecimal.ZERO;
            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
              exSPCI_RTAM    = exTpPRDD_TAXN;
              exTpPRDD_TAXN  = BigDecimal.ZERO;
            }
      }
         

         exSPCI_FBAM  = tpInfcPkgYeta3000Vo.getSpciFbam(); //oraQrySelect05.FieldByName('SPCI_FBAM').AsFloat;          //기부금_법정기부금_세액공제
       if (exTpPRDD_TAXN.compareTo(exSPCI_FBAM ) > 0)  {
        exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_FBAM);
       }
     else
     {
        exSPCI_FBAM  = BigDecimal.ZERO;
         if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
              exSPCI_FBAM  = exTpPRDD_TAXN;
              exTpPRDD_TAXN  = BigDecimal.ZERO;
         }
     }
      
       exSPCI_RFAM  =tpInfcPkgYeta3000Vo.getSpciRfam(); // oraQrySelect05.FieldByName('SPCI_RFAM').AsFloat;          //우리사주조합부금_세액공제
      if (exTpPRDD_TAXN.compareTo(exSPCI_RFAM ) > 0)  {
        exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_RFAM);
      }
     else
     {
  	   exSPCI_RFAM  = BigDecimal.ZERO;
         if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
      	   exSPCI_RFAM     = exTpPRDD_TAXN;
           exTpPRDD_TAXN  = BigDecimal.ZERO;
         }
     }
      
       
       exSPCI_NAMT  =tpInfcPkgYeta3000Vo.getSpciNamt(); // oraQrySelect05.FieldByName('SPCI_NAMT').AsFloat;          //지정기부금_세액공제
      if (exTpPRDD_TAXN.compareTo(exSPCI_NAMT ) > 0)  {
        exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_NAMT);
      }
     else
     {
        exSPCI_NAMT  = BigDecimal.ZERO;
         if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
           exSPCI_NAMT     = exTpPRDD_TAXN;
           exTpPRDD_TAXN  = BigDecimal.ZERO;
         }
     }
      
        exSPCI_YAMT  = tpInfcPkgYeta3000Vo.getSpciYamt(); //oraQrySelect05.FieldByName('SPCI_YAMT').AsFloat;          //지정기부금_세액공제
      if (exTpPRDD_TAXN.compareTo(exSPCI_YAMT ) > 0)  {
        exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_YAMT);
      }
     else
     {
        exSPCI_YAMT  = BigDecimal.ZERO;
         if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
            exSPCI_YAMT    = exTpPRDD_TAXN;
            exTpPRDD_TAXN  = BigDecimal.ZERO;
         }
     }
         
         exTAXD_PAID  = tpInfcPkgYeta3000Vo.getTaxdPaid(); //oraQrySelect05.FieldByName('TAXD_PAID').AsFloat;            //외국납부
         if (exTpPRDD_TAXN.compareTo(exTAXD_PAID) > 0)  {
          exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_PAID);
       }
       else
       {
          exTAXD_PAID  = BigDecimal.ZERO;
           if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
              exTAXD_PAID    = exTpPRDD_TAXN;
              exTpPRDD_TAXN  = BigDecimal.ZERO;
           }
     }
         

         exJRTR_HICT  = tpInfcPkgYeta3000Vo.getJrtrHict(); //oraQrySelect05.FieldByName('JRTR_HICT').AsFloat;        //연금계좌_과학기술인공제
         if (exTpPRDD_TAXN.compareTo(exJRTR_HICT ) > 0) {
          exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exJRTR_HICT);
         }
       else
       {
          exJRTR_HICT  = BigDecimal.ZERO;
           if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
               exJRTR_HICT   = exTpPRDD_TAXN;
               exTpPRDD_TAXN  = BigDecimal.ZERO;
           }
       }
       
         exJRTR_PSRN  = tpInfcPkgYeta3000Vo.getJrtrPsrn(); //oraQrySelect05.FieldByName('JRTR_PSRN').AsFloat;        //연금계좌_근로자퇴직급여보장법 세액공제
         if (exTpPRDD_TAXN.compareTo(exJRTR_PSRN) > 0) {
          exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exJRTR_PSRN);
         }
       else
       {
          exJRTR_PSRN  = BigDecimal.ZERO;
           if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
             exJRTR_PSRN     = exTpPRDD_TAXN;
             exTpPRDD_TAXN  = BigDecimal.ZERO;
           }
       }
       
         exJRTR_HNSV  = tpInfcPkgYeta3000Vo.getJrtrHnsv(); //oraQrySelect05.FieldByName('JRTR_HNSV').AsFloat;        //연금계좌_연금저축_공제
         if (exTpPRDD_TAXN.compareTo(exJRTR_HNSV ) > 0) {
          exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exJRTR_HNSV);
         }
       else
       {
          exJRTR_HNSV  = BigDecimal.ZERO;
           if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
             exJRTR_HNSV     = exTpPRDD_TAXN;
             exTpPRDD_TAXN  = BigDecimal.ZERO;
           }
       }
       
       

          //   {retax-57}
			/**#######################      ############################################*/
        
        yetaPrc3000Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
        yetaPrc3000Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
        yetaPrc3000Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
        yetaPrc3000Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
     
//        yetaPrc3000Vo.setBefoScnt(yeta3000Dto.getBefoScnt());    /** column 종전근무지수 : befoScnt */
//        yetaPrc3000Vo.setPayrTamt(yeta3000Dto.getPayrTamt());    /** column 주근무지_급여총액 : payrTamt */
//        yetaPrc3000Vo.setBonsToam(yeta3000Dto.getBonsToam());    /** column 주근무지_상여총액 : bonsToam */
//        yetaPrc3000Vo.setDtmnBsam(yeta3000Dto.getDtmnBsam());    /** column 주근무지_인정상여총액 : dtmnBsam */
//        yetaPrc3000Vo.setStckPrft(yeta3000Dto.getStckPrft());    /** column 주근무지_주식행사이익 : stckPrft */
//        yetaPrc3000Vo.setCurrTots(yeta3000Dto.getCurrTots());    /** column 주근무지총급여액 : currTots */
//        yetaPrc3000Vo.setTaxmSfam(yeta3000Dto.getTaxmSfam());    /** column 비과세_자가운전보조금액_del : taxmSfam */
//        yetaPrc3000Vo.setTaxmEtam(yeta3000Dto.getTaxmEtam());    /** column 비과세_급양비금액_del : taxmEtam */
//        yetaPrc3000Vo.setTaxmBoin(yeta3000Dto.getTaxmBoin());    /** column 비과세_보육수당_del : taxmBoin */
//        yetaPrc3000Vo.setTxecAmnt(yeta3000Dto.getTxecAmnt());    /** column 비과세_외국인소득금액_del : txecAmnt */
//        yetaPrc3000Vo.setTotlSala(yeta3000Dto.getTotlSala());    /** column 총급여_현_전 : totlSala */
//        yetaPrc3000Vo.setWkerDdct(yeta3000Dto.getWkerDdct());    /** column 근로소득공제 : wkerDdct */
//        yetaPrc3000Vo.setWkerAmnt(yeta3000Dto.getWkerAmnt());    /** column 근로소득금액 : wkerAmnt */
//        yetaPrc3000Vo.setBaseSelf(yeta3000Dto.getBaseSelf());    /** column 기본공제_본인 : baseSelf */
//        yetaPrc3000Vo.setBaseWife(yeta3000Dto.getBaseWife());    /** column 기본공제_배우자 : baseWife */
//        yetaPrc3000Vo.setBaseFyam(yeta3000Dto.getBaseFyam());    /** column 기본공제_부양가족 : baseFyam */
//        yetaPrc3000Vo.setAddrHdam(yeta3000Dto.getAddrHdam());    /** column 추가공제_장애인 : addrHdam */
//        yetaPrc3000Vo.setAddrRpt70(yeta3000Dto.getAddrRpt70());    /** column 추가공제_경로우대70 : addrRpt70 */
//        yetaPrc3000Vo.setAddrFame(yeta3000Dto.getAddrFame());    /** column 추가공제_부녀자 : addrFame */
         yetaPrc3000Vo.setAddrChld(exADDR_CHLD);    /** column 추가공제_자녀양육비 : addrChld */
         yetaPrc3000Vo.setAddrBrth(exADDR_BRTH);    /** column 추가공제_출산자녀양육비 : addrBrth */
//        yetaPrc3000Vo.setPantOnam(yeta3000Dto.getPantOnam());    /** column 추가공제_한부모공제금액 : pantOnam */
//        yetaPrc3000Vo.setAddrMcam(yeta3000Dto.getAddrMcam());    /** column 추가공제_다자녀 : addrMcam */
//        yetaPrc3000Vo.setBnatDdct(yeta3000Dto.getBnatDdct());    /** column 종근무지_국민연금보험료공제 : bnatDdct */
//        yetaPrc3000Vo.setJnatDdct(yeta3000Dto.getJnatDdct());    /** column 주근무지_국민연금보험료공제 : jnatDdct */
//        yetaPrc3000Vo.setBpssDdct(yeta3000Dto.getBpssDdct());    /** column 종근무지_별정우체국연금보험료공제 : bpssDdct */
//        yetaPrc3000Vo.setBpssHsol(yeta3000Dto.getBpssHsol());    /** column 종근무지_국민연금외군인연금공제 : bpssHsol */
//        yetaPrc3000Vo.setBpssHtec(yeta3000Dto.getBpssHtec());    /** column 종근무지_국민연금외교직원연금공제 : bpssHtec */
//        yetaPrc3000Vo.setBpssHpul(yeta3000Dto.getBpssHpul());    /** column 종근무지_국민연금외공무원연금공제 : bpssHpul */
//        yetaPrc3000Vo.setJpssDdct(yeta3000Dto.getJpssDdct());    /** column 주근무지_별정우체국연금보험료공제 : jpssDdct */
//        yetaPrc3000Vo.setJpssHsol(yeta3000Dto.getJpssHsol());    /** column 주근무지_국민연금외군인연금공제 : jpssHsol */
//        yetaPrc3000Vo.setJpssHtec(yeta3000Dto.getJpssHtec());    /** column 주근무지_국민연금외교직원연금공제 : jpssHtec */
//        yetaPrc3000Vo.setJpssHpul(yeta3000Dto.getJpssHpul());    /** column 주근무지_공무원연금보험료공제 : jpssHpul */
//        yetaPrc3000Vo.setBrtrHict(yeta3000Dto.getBrtrHict());    /** column 종근무지_퇴직연금과학기술인공제 : brtrHict */
//        yetaPrc3000Vo.setBrtrPsrn(yeta3000Dto.getBrtrPsrn());    /** column 종근무지_퇴직연금근로자퇴직급여보장법공제 : brtrPsrn */
//        yetaPrc3000Vo.setBrtrHnsv(yeta3000Dto.getBrtrHnsv());    /** column 종근무지_퇴직연금연금계좌저축공제 : brtrHnsv */
          yetaPrc3000Vo.setJrtrHict(exJRTR_HICT);    /** column 주근무지_퇴직연금과학기술인공제 : jrtrHict */
          yetaPrc3000Vo.setJrtrPsrn(exJRTR_PSRN);    /** column 주근무지_퇴직연금근로자퇴직급여보장법공제 : jrtrPsrn */
          yetaPrc3000Vo.setJrtrHnsv(exJRTR_HNSV);    /** column 주근무지_퇴직연금연금계좌저축공제 : jrtrHnsv */
//        yetaPrc3000Vo.setRrptYnam(yeta3000Dto.getRrptYnam());    /** column 연금보험료공제계 : rrptYnam */
//        yetaPrc3000Vo.setSpciBhth(yeta3000Dto.getSpciBhth());    /** column 특별공제_종건강보험료 : spciBhth */
//        yetaPrc3000Vo.setSpciJhth(yeta3000Dto.getSpciJhth());    /** column 특별공제_주건강보험료 : spciJhth */
//        yetaPrc3000Vo.setSpciBepf(yeta3000Dto.getSpciBepf());    /** column 특별공제_종고용보험료 : spciBepf */
//        yetaPrc3000Vo.setSpciJepf(yeta3000Dto.getSpciJepf());    /** column 특별공제_주고용보험료 : spciJepf */
          yetaPrc3000Vo.setSpciGurt(exSPCI_GURT);    /** column 특별공제_일반보장성보험료 : spciGurt */
          yetaPrc3000Vo.setSpciHdrc(exSPCI_HDRC);    /** column 특별공제_장애인보장성보험료 : spciHdrc */
          yetaPrc3000Vo.setSpciRtde(exSPCI_RTDE);    /** column 특별공제_보장성보혐료세액공제금액 : spciRtde */
//        yetaPrc3000Vo.setSpciHrto(yeta3000Dto.getSpciHrto());    /** column 특별공제_보험료계 : spciHrto */
//        yetaPrc3000Vo.setSpciSelf(yeta3000Dto.getSpciSelf());    /** column 특별공제_의료비_본인 : spciSelf */
//        yetaPrc3000Vo.setSpciHe65(yeta3000Dto.getSpciHe65());    /** column 특별공제_의료비_경로65세이상 : spciHe65 */
//        yetaPrc3000Vo.setSpciHbps(yeta3000Dto.getSpciHbps());    /** column 특별공제_의료비_장애인 : spciHbps */
//        yetaPrc3000Vo.setSpciDetc(yeta3000Dto.getSpciDetc());    /** column 특별공제_의료비_기타공제대상자 : spciDetc */
         yetaPrc3000Vo.setSpciTxcr(exSPCI_TXCR);    /** column 특별공제_의료비세액공제액 : spciTxcr */
//        yetaPrc3000Vo.setSpciMeto(yeta3000Dto.getSpciMeto());    /** column 특별공제_의료비계 : spciMeto */
//        yetaPrc3000Vo.setSpedSelf(yeta3000Dto.getSpedSelf());    /** column 특별공제_교육비_본인 : spedSelf */
//        yetaPrc3000Vo.setSpedGrde(yeta3000Dto.getSpedGrde());    /** column 특별공제_교육비_취학전아동 : spedGrde */
//        yetaPrc3000Vo.setSpedGdto(yeta3000Dto.getSpedGdto());    /** column 특별공제_교육비_초중고 : spedGdto */
//        yetaPrc3000Vo.setSpedCldv(yeta3000Dto.getSpedCldv());    /** column 특별공제_교육비_대학교 : spedCldv */
//        yetaPrc3000Vo.setSpciSpec(yeta3000Dto.getSpciSpec());    /** column 특별공제_장애인특수교육비 : spciSpec */
         yetaPrc3000Vo.setSpedTxcr(exSPED_TXCR);    /** column 특별공제_교육비세액공제금액 : spedTxcr */
//        yetaPrc3000Vo.setSpedToam(yeta3000Dto.getSpedToam());    /** column 특별공제_교육비계 : spedToam */
//        yetaPrc3000Vo.setSpciRefn(yeta3000Dto.getSpciRefn());    /** column 특별공제_차입금원리금상환액_대출기관 : spciRefn */
//        yetaPrc3000Vo.setSpciResf(yeta3000Dto.getSpciResf());    /** column 특별공제_차입금원리금상환액_거주자 : spciResf */
//        yetaPrc3000Vo.setSpciTgrt(yeta3000Dto.getSpciTgrt());    /** column 특별공제_월세세액공제대상금액 : spciTgrt */
         yetaPrc3000Vo.setSpciRtam(exSPCI_RTAM);    /** column 특별공제_주택자금월세공제액 : spciRtam */
//        yetaPrc3000Vo.setSpchRefn(yeta3000Dto.getSpchRefn());    /** column 특별공제_장기주택이자상환액 : spchRefn */
//        yetaPrc3000Vo.setSpchRe15(yeta3000Dto.getSpchRe15());    /** column 특별공제_11장기주택저당차입금15 : spchRe15 */
//        yetaPrc3000Vo.setSpchRe29(yeta3000Dto.getSpchRe29());    /** column 특별공제_11장기주택저당차입금29 : spchRe29 */
//        yetaPrc3000Vo.setSpchRe30(yeta3000Dto.getSpchRe30());    /** column 특별공제_11장기주택저당차입금30 : spchRe30 */
//        yetaPrc3000Vo.setSpciRefx(yeta3000Dto.getSpciRefx());    /** column 특별공제_12장기주택저당차입금_고정 : spciRefx */
//        yetaPrc3000Vo.setSpciReec(yeta3000Dto.getSpciReec());    /** column 특별공제_12장기주택저당차입금_기타 : spciReec */
//        yetaPrc3000Vo.setSpci15fx(yeta3000Dto.getSpci15fx());    /** column 특별공제_15장기주택저당_15고정AND비거치상환 : spci15fx */
//        yetaPrc3000Vo.setSpci15fb(yeta3000Dto.getSpci15fb());    /** column 특별공제_15장기주택저당_15고정OR비거치상환 : spci15fb */
//        yetaPrc3000Vo.setSpci15ec(yeta3000Dto.getSpci15ec());    /** column 특별공제_15장기주택저당_15기타대출 : spci15ec */
//        yetaPrc3000Vo.setSpci10fb(yeta3000Dto.getSpci10fb());    /** column 특별공제_15장기주택저당_10고정OR비거치상환 : spci10fb */
//        yetaPrc3000Vo.setSpci10ec(yeta3000Dto.getSpci10ec());    /** column 특별공제_15장기주택저당_10기타대출 : spci10ec */
//        yetaPrc3000Vo.setSpchReto(yeta3000Dto.getSpchReto());    /** column 특별공제_주택자금공제액계 : spchReto */
         yetaPrc3000Vo.setTaxdPltc(exTAXD_PLTC);    /** column 세액공제_기부정치자금 : taxdPltc */
         yetaPrc3000Vo.setSpciPltc(exSPCI_PLTC);    /** column 특별공제_기부금_정치 : spciPltc */
         yetaPrc3000Vo.setSpciFbam(exSPCI_FBAM);    /** column 특별공제_기부금_법정 : spciFbam */
//        yetaPrc3000Vo.setSpciExam(yeta3000Dto.getSpciExam());    /** column 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
//        yetaPrc3000Vo.setSpciUnon(yeta3000Dto.getSpciUnon());    /** column 특별공제_기부금_공익법인신탁특례 : spciUnon */
         yetaPrc3000Vo.setSpciRfam(exSPCI_RFAM);    /** column 특별공제_기부금_우리사주조합2015이후 : spciRfam */
         yetaPrc3000Vo.setSpciYamt(exSPCI_YAMT);    /** column 특별공제_기부금_종교단체 : spciYamt */
         yetaPrc3000Vo.setSpciNamt(exSPCI_NAMT);    /** column 특별공제_기부금_종교단체외 : spciNamt */
//        yetaPrc3000Vo.setSpciDgcr(yeta3000Dto.getSpciDgcr());    /** column 특별공제_지정기부금세액공제금액 : spciDgcr */
//        yetaPrc3000Vo.setSpciSsum(yeta3000Dto.getSpciSsum());    /** column 특별공제_기부금공제액계 : spciSsum */
         yetaPrc3000Vo.setSpciDdct(exSPCI_DDCT);    /** column 특별공제_표준공제 : spciDdct */
//        yetaPrc3000Vo.setSubtEram(yeta3000Dto.getSubtEram());    /** column 차감소득금액 : subtEram */
//        yetaPrc3000Vo.setEtcpPsnv(yeta3000Dto.getEtcpPsnv());    /** column 개인연금저축불입액_2000년이전 : etcpPsnv */
//        yetaPrc3000Vo.setEtcpNsav(yeta3000Dto.getEtcpNsav());    /** column 개인연금저축불입액_2001이후_삭제 : etcpNsav */
//        yetaPrc3000Vo.setPrcmToam(yeta3000Dto.getPrcmToam());    /** column 연금저축공제액계 : prcmToam */
//        yetaPrc3000Vo.setEtchPrep(yeta3000Dto.getEtchPrep());    /** column 기타공제_소기업공제불입금 : etchPrep */
//        yetaPrc3000Vo.setEtcsComp(yeta3000Dto.getEtcsComp());    /** column 기타공제_주택마련저축_청약저축 : etcsComp */
//        yetaPrc3000Vo.setEtwkSbam(yeta3000Dto.getEtwkSbam());    /** column 기타공제_주택마련저축_주택청약종합저축 : etwkSbam */
//        yetaPrc3000Vo.setEtwkSvam(yeta3000Dto.getEtwkSvam());    /** column 기타공제_주택마련저축_근로자주택마련저축 : etwkSvam */
//        yetaPrc3000Vo.setEtwkLgam(yeta3000Dto.getEtwkLgam());    /** column 기타공제_주택마련저축_장기주택마련저축 : etwkLgam */
//        yetaPrc3000Vo.setEtwkBdam(yeta3000Dto.getEtwkBdam());    /** column 기타공제_주택마련저축소득공제계 : etwkBdam */
//        yetaPrc3000Vo.setEtctConc(yeta3000Dto.getEtctConc());    /** column 기타공제_투자조합출자소득공제_2011이전 : etctConc */
//        yetaPrc3000Vo.setEtgd09af(yeta3000Dto.getEtgd09af());    /** column 기타공제_투자조합출자소득공제_2012년도 : etgd09af */
//        yetaPrc3000Vo.setEtgdH13h(yeta3000Dto.getEtgdH13h());    /** column 기타공제_투자조합출자소득공제_2013년도 : etgdH13h */
//        yetaPrc3000Vo.setEtgdD14f(yeta3000Dto.getEtgdD14f());    /** column 기타공제_투자조합출자소득공제_2014년이후 : etgdD14f */
//        yetaPrc3000Vo.setEtgdD15f(yeta3000Dto.getEtgdD15f());    /** column 기타공제_투자조합출자금액_2015년이후 : etgdD15f */
//        yetaPrc3000Vo.setEtgdDdam(yeta3000Dto.getEtgdDdam());    /** column 기타공제_투자조합출자공제액계 : etgdDdam */
//        yetaPrc3000Vo.setEtccCard(yeta3000Dto.getEtccCard());    /** column 기타공제_신용카드등사용액소득공제 : etccCard */
//        yetaPrc3000Vo.setEtckUnon(yeta3000Dto.getEtckUnon());    /** column 기타공제_우리사주출연금공제 : etckUnon */
//        yetaPrc3000Vo.setEtckUncr(yeta3000Dto.getEtckUncr());    /** column 기타공제_우리사주조합기부금공제2014이전 : etckUncr */
//        yetaPrc3000Vo.setEtepMsam(yeta3000Dto.getEtepMsam());    /** column 기타공제_고용유지중소기업근로자임금삭감공제액 : etepMsam */
//        yetaPrc3000Vo.setEtgdHtra(yeta3000Dto.getEtgdHtra());    /** column 기타공제_목돈안드는전세이자상환소득공제액 : etgdHtra */
//        yetaPrc3000Vo.setEtepSecr(yeta3000Dto.getEtepSecr());    /** column 기타공제_장기집합투자증권저축공제액 : etepSecr */
//        yetaPrc3000Vo.setEtclTo01(yeta3000Dto.getEtclTo01());    /** column 기타공제_장기주식형저축_1년차공제_삭제 : etclTo01 */
//        yetaPrc3000Vo.setEtclTo02(yeta3000Dto.getEtclTo02());    /** column 기타공제_장기주식형저축_2년차공제_삭제 : etclTo02 */
//        yetaPrc3000Vo.setEtclTo03(yeta3000Dto.getEtclTo03());    /** column 기타공제_장기주식형저축_3년차공제_삭제 : etclTo03 */
//        yetaPrc3000Vo.setEtclHmto(yeta3000Dto.getEtclHmto());    /** column 기타공제_장기주식형저축소득공제_삭제 : etclHmto */
//        yetaPrc3000Vo.setEtcdTsum(yeta3000Dto.getEtcdTsum());    /** column 기타공제_공제계 : etcdTsum */
//        yetaPrc3000Vo.setSpchExli(yeta3000Dto.getSpchExli());    /** column 특별공제_종합한도초과금액 : spchExli */
//        yetaPrc3000Vo.setStndIncm(yeta3000Dto.getStndIncm());    /** column 종합소득과세표준 : stndIncm */
//        yetaPrc3000Vo.setPrddTaxn(yeta3000Dto.getPrddTaxn());    /** column 산출세액 : prddTaxn */
         yetaPrc3000Vo.setTaxdIcax(exTAXD_ICAX);    /** column 세액감면_소득세법 : taxdIcax */
         yetaPrc3000Vo.setTaxdSpct(exTAXD_SPCT);    /** column 세액감면_조세특례법 : taxdSpct */
         yetaPrc3000Vo.setTxlgCl30(exTXLG_CL30);    /** column 세액감면_조세특례법제30조 : txlgCl30 */
         yetaPrc3000Vo.setTxlgHxtt(exTXLG_HXTT);    /** column 세액감면_조세조약 : txlgHxtt */
         yetaPrc3000Vo.setTaxdTsum(exTAXD_TSUM);    /** column 세액감면_감면세액계 : taxdTsum */
         yetaPrc3000Vo.setTaxdWken(exTAXD_WKEN);    /** column 세액공제_근로소득세액공제 : taxdWken */
         yetaPrc3000Vo.setTaxdUnin(exTAXD_UNIN);    /** column 세액공제_납세조합공제 : taxdUnin */
         yetaPrc3000Vo.setTaxdLoan(exTAXD_LOAN);    /** column 세액공제_주택차입금 : taxdLoan */
         yetaPrc3000Vo.setTaxdPaid(exTAXD_PAID);    /** column 세액공제_외국납부 : taxdPaid */
//        yetaPrc3000Vo.setTaxdRedu(yeta3000Dto.getTaxdRedu());    /** column 세액공제_외국인감면세액 : taxdRedu */
         yetaPrc3000Vo.setAddrMccr(exADDR_MCCR);    /** column 세액공제_자녀세액공제금액 : addrMccr */
         yetaPrc3000Vo.setSpciDcto(exSPCI_DCTO);    /** column 특별세액공제계 : spciDcto */
         yetaPrc3000Vo.setTaxdCsum(exTAXD_CSUM);    /** column 세액공제_공제계 : taxdCsum */
//        yetaPrc3000Vo.setDcsnIncm(yeta3000Dto.getDcsnIncm());    /** column 결정세액_소득세 : dcsnIncm */
//        yetaPrc3000Vo.setDcsnInhb(yeta3000Dto.getDcsnInhb());    /** column 결정세액_주민세_지방소득세 : dcsnInhb */
//        yetaPrc3000Vo.setDcsnFafv(yeta3000Dto.getDcsnFafv());    /** column 결정세액_농특세 : dcsnFafv */
//        yetaPrc3000Vo.setAlryPinx(yeta3000Dto.getAlryPinx());    /** column 기납부세액_소득세 : alryPinx */
//        yetaPrc3000Vo.setAlryPhbx(yeta3000Dto.getAlryPhbx());    /** column 기납부세액_주민세_지방소득세 : alryPhbx */
//        yetaPrc3000Vo.setAlryYvtx(yeta3000Dto.getAlryYvtx());    /** column 기납부세액_농특세 : alryYvtx */
//        yetaPrc3000Vo.setDcsnTots(yeta3000Dto.getDcsnTots());    /** column 이전근무지_총급여 : dcsnTots */
//        yetaPrc3000Vo.setDcsnItax(yeta3000Dto.getDcsnItax());    /** column 이전근무지_소득세 : dcsnItax */
//        yetaPrc3000Vo.setDcsnBtax(yeta3000Dto.getDcsnBtax());    /** column 이전근무지_주민세_지방소득세 : dcsnBtax */
//        yetaPrc3000Vo.setFafvTaxi(yeta3000Dto.getFafvTaxi());    /** column 이전근무지_농특세 : fafvTaxi */
//        yetaPrc3000Vo.setSubtEtax(yeta3000Dto.getSubtEtax());    /** column 차감징수_소득세 : subtEtax */
//        yetaPrc3000Vo.setSubtInhb(yeta3000Dto.getSubtInhb());    /** column 차감징수_주민세_지방소득세 : subtInhb */
//        yetaPrc3000Vo.setSubtFafv(yeta3000Dto.getSubtFafv());    /** column 차감징수_농특세 : subtFafv */
//        yetaPrc3000Vo.setSubtAmsu(yeta3000Dto.getSubtAmsu());    /** column 차감징수_세액계 : subtAmsu */
//        yetaPrc3000Vo.setJrtrHnto(yeta3000Dto.getJrtrHnto());    /** column 연금계좌세액공제계 : jrtrHnto */
//        yetaPrc3000Vo.setSpciOnon(yeta3000Dto.getSpciOnon());    /** column 이월특례기부금_공익신탁금액 : spciOnon */
//        yetaPrc3000Vo.setSpciObam(yeta3000Dto.getSpciObam());    /** column 이월법정기부금액 : spciObam */
//        yetaPrc3000Vo.setSpciOyam(yeta3000Dto.getSpciOyam());    /** column 이월종교단체기부금 : spciOyam */
//        yetaPrc3000Vo.setSpciOnam(yeta3000Dto.getSpciOnam());    /** column 이월종교단체외기부금 : spciOnam */
//        yetaPrc3000Vo.setKybdr(yeta3000Dto.getKybdr());    /** column 입력자 : kybdr */
//        yetaPrc3000Vo.setInptDt(yeta3000Dto.getInptDt());    /** column 입력일자 : inptDt */
//        yetaPrc3000Vo.setInptAddr(yeta3000Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//        yetaPrc3000Vo.setIsmt(yeta3000Dto.getIsmt());    /** column 수정자 : ismt */
//        yetaPrc3000Vo.setRevnDt(yeta3000Dto.getRevnDt());    /** column 수정일자 : revnDt */
//        yetaPrc3000Vo.setRevnAddr(yeta3000Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//        yetaPrc3000Vo.setTempPrddTaxn(yeta3000Dto.getTempPrddTaxn());    /** column null : tempPrddTaxn */
        
         statCnt = 0;
	  	 statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_SPCI_Update(yetaPrc3000Vo); 
      
      }   
       
     //      {retax-58}
      /**#######################  특별공제)특별 세액공제계 -표준세액 공제 ############################################*/
      
  	if (statCnt >= 0) {
        statCnt = 0;
		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_12_1_Update(yetaPrc2000Vo); 
     
       
       //{retax-59} 
      /**#######################  세액감면 세액공제- ############################################*/
      
		if (statCnt >= 0) {
		statCnt = 0;
		statCnt = yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_15_Update(yetaPrc2000Vo); 
       
     //   {retax-60}
    /**#######################  농어촌특별세 계산 ############################################*/ 
		if (statCnt >= 0) { 
		statCnt = 0;
		statCnt =  yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_16_Update(yetaPrc2000Vo); 
       
       //   {retax-61}
      /**#######################  결정세액 ############################################*/ 
		if (statCnt >= 0) { 
			statCnt = 0;
			statCnt = yetaPayr6430Service.fnPayr06430_PAYR425_ReTax_2014_CREATE_17_Update(yetaPrc2000Vo); 
			 
		}
		}
		}
		}
  	   }
		}
		}
		}
		}
		}
		}
		}
		}
		 
		 
		return statCnt;
		 
  }
    
    
    
    private PagingLoadResult<ShowMessageBM> funcPayrToYeta_Insert(HttpServletRequest request,List<InfcPkgYeta2000VO>  lstInfcPkgYeta2000Vo)  throws Exception  {
    	
  	      PagingLoadResult<ShowMessageBM> retval = null; 
	      List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	  	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
	  	  
	  	  
	  	  InfcPkgYeta3210VO yetaPrc3210Vo = new InfcPkgYeta3210VO();  //급여내역
	  	  //InfcPkgYeta3200VO yetaPrc3200Vo = new InfcPkgYeta3200VO();  //비과세감면소득 
	  	
	  	 try { 
	  		   
		  	   if  (yetaPayr6430Service == null) { 
	               WebApplicationContext wac = WebApplicationContextUtils.
	                       getRequiredWebApplicationContext( request.getSession().getServletContext());
	   
	               yetaPayr6430Service = (YetaPayr6430Service) wac.getBean("YetaPayr6430Service"); 
	              
	            }
		  	   
		  	  
		  	  /************************* 대상자별로 루프 시작 ***************************************************/ 
		  	   for (int iCnt01 = 0;iCnt01 < lstInfcPkgYeta2000Vo.size();iCnt01++) {
		  		    
		  		 InfcPkgYeta2000VO yetaPrc2000Vo = new InfcPkgYeta2000VO(); 
		  		 yetaPrc2000Vo = lstInfcPkgYeta2000Vo.get(iCnt01);  
		  		
		  		 
		  		 //{******************************급여자료 이관 - 급여내역 생성  [2]*******************************************}
		         // {급여내역생성 -417}
		            yetaPrc3210Vo.setDpobCd(yetaPrc2000Vo.getDpobCd());     /** 사업장코드 */
			        yetaPrc3210Vo.setEdacRvyy(yetaPrc2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
			        yetaPrc3210Vo.setSettGbcd(yetaPrc2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
			        yetaPrc3210Vo.setSystemkey(yetaPrc2000Vo.getSystemkey());    /** column 정산구분코드 : settGbcd */
			     //   yetaPrc3210Vo.setEdacSeilNum(yetaPrc2000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
			        yetaPrc3210Vo.setPayrMangDeptCd(yetaPrc2000Vo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
			        yetaPrc3210Vo.setDeptCd(yetaPrc2000Vo.getDeptCd());    /** column 부서코드 : deptCd */
			        yetaPrc3210Vo.setTypOccuCd(yetaPrc2000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
			        yetaPrc3210Vo.setDtilOccuClsDivCd(yetaPrc2000Vo.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
			        yetaPrc3210Vo.setPyspGrdeCd(yetaPrc2000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
			        yetaPrc3210Vo.setDtilOccuInttnCd(yetaPrc2000Vo.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
			        yetaPrc3210Vo.setBusinCd(yetaPrc2000Vo.getBusinCd());    /** column 사업코드 : businCd */
			        yetaPrc3210Vo.setEmymtDivCd(yetaPrc2000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */ 
			        
			        yetaPrc3210Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
			        yetaPrc3210Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
			        yetaPrc3210Vo.setUsrId(sessionUser.getUsrId());  
			              
			            
			       /******************************** 권한 ************************************************************************/
			              
			        yetaPrc3210Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(yetaPrc2000Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
			        yetaPrc3210Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(yetaPrc2000Vo.getDtilOccuInttnCd()).replace(",", ""));  
			            
			        if (yetaPrc3210Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(yetaPrc2000Vo.getDeptCd()))) { 
			        	yetaPrc3210Vo.setDeptCd("");  //부서코드
	               } 
			       
			        yetaPrc3210Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
			        yetaPrc3210Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
			        yetaPrc3210Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
			        yetaPrc3210Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
			  	        
			        //급여이관 
			  	    yetaPayr6420Create.fnPayr06420_PAYR417_2014_CREATE_Insert(yetaPrc3210Vo);   //yetaPrc3210Vo  
		        
		  		 // 415 업데이트
		        // {******************************급여자료 이관 - 연말정산 업데이트   [3]*******************************************}
		      
			  	  
			  	    yetaPayr6420Create.fnPayr06520_PAYR415_2015_CREATE1_Update(yetaPrc2000Vo);   //yetaPrc3210Vo 
			  	     
			  	  //{비과세 감면 인서트 }
		          //{**************************연말정산기본 비과세 감면 업데이트   [4]********************************} 
				  	        
				  	        
				   yetaPayr6420Create.fnPayr06420_YETA3200_2015_CREATE1_Update(yetaPrc2000Vo);   //yetaPrc3200Vo 
			  	    
		         
		       // {******************************급여자료 이관 - 연말정산 425 업데이트   [4]*******************************************}
		         //425 업데이트
		        
				  yetaPayr6420Create.fnPayr06530_PAYR425_2015_CREATE1_Update(yetaPrc2000Vo);   //yetaPrc3210Vo 
				  
				    
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
	   	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
 	 
    } 
	  	   
	  	  return  retval;
  }
   
 
}