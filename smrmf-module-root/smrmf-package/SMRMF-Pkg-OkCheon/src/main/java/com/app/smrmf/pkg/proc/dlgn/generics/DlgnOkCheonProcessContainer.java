package com.app.smrmf.pkg.proc.dlgn.generics;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0100SrhVO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0100VO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0200SrhVO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0200VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO;
import com.app.smrmf.pkg.proc.dlgn.manage.commute.ManageCommuteService;
import com.app.smrmf.props.ExtermsProps;
import com.ibm.icu.math.BigDecimal;
/**
 * 각 근태합산 관련 실제 로직을 처리 하는 부분
 */
 
public class DlgnOkCheonProcessContainer {
	

	private static final Logger logger = LoggerFactory.getLogger(DlgnOkCheonProcessContainer.class);
	   
    @Resource(name = "ManageCommuteService")
    protected ManageCommuteService manageCommuteService;

    public DlgnOkCheonProcessContainer() {
    	
        
    }
    

    /**
     * infcDlgn0100 근무시간 업데이트 쿼리 적용 집계처리를 위한 부분 
     * @param infcDlgn0100SrhVo
     * @return
     * @throws Exception
     */
    public int setUpdateManageInfcDlgn0100CommuteService(HttpServletRequest request,InfcPkgDlgn0100VO infcDlgn0100Vo) throws Exception{
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (manageCommuteService == null) { 
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            manageCommuteService = (ManageCommuteService) wac.getBean("ManageCommuteService" ); 
           
       }
       
        int result = 0;
        InfcPkgDlgn0100SrhVO infcDlgn0100SrhVo = new InfcPkgDlgn0100SrhVO(); 
        
        
        try {
            
            infcDlgn0100SrhVo.setDpobCd(infcDlgn0100Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
            infcDlgn0100SrhVo.setSystemkey(infcDlgn0100Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
            infcDlgn0100SrhVo.setDilnlazYrMnth(infcDlgn0100Vo.getDilnlazYrMnth());    /** column 근태년월 : dilnlazYrMnth */
            infcDlgn0100SrhVo.setPayCd(infcDlgn0100Vo.getPayCd());    /** column 급여구분코드 : payCd */
            infcDlgn0100SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(infcDlgn0100Vo.getEmymtDivCd())  );    /** column 고용구분코드 : emymtDivCd */
            infcDlgn0100SrhVo.setDeptCd(infcDlgn0100Vo.getDeptCd());    /** column 부서코드 : deptCd */
            infcDlgn0100SrhVo.setBusinCd(infcDlgn0100Vo.getBusinCd());    /** column 사업코드 : businCd */
            infcDlgn0100SrhVo.setTypOccuCd(infcDlgn0100Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
            infcDlgn0100SrhVo.setMangeDeptCd(infcDlgn0100Vo.getMangeDeptCd());    /** column 관리부서코드  mangeDeptCd */
            infcDlgn0100SrhVo.setDtilOccuInttnCd(infcDlgn0100Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
         
            
            List list =  manageCommuteService.selectInfcDlgn0110TotList(infcDlgn0100SrhVo); 
            
            Iterator<Map<String, Object>> iter = list.iterator(); 
        
            while ( iter.hasNext() ) {
                Map<String, Object> mapInfcDlgn0100Tot = (Map<String, Object>) iter.next();
                BigDecimal totDutyNumDys =  BigDecimal.ZERO;
                InfcPkgDlgn0100VO upInfcDlgn0100Vo = new InfcPkgDlgn0100VO(); 
                
                upInfcDlgn0100Vo.setDpobCd(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("dpobCd")));                  /** column 사업장코드 : dpobCd */
                upInfcDlgn0100Vo.setSystemkey(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("systemkey")));            /** column SYSTEMKEY : systemkey */
                upInfcDlgn0100Vo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("dilnlazYrMnth")));    /** column 근태년월 : dilnlazYrMnth */
                upInfcDlgn0100Vo.setPayCd(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("payCd")));                    /** column 급여구분코드 : payCd */
              //  upInfcDlgn0100Vo.setEmymtDivCd(infcDlgn0100Vo.getEmymtDivCd());                /** column 고용구분코드 : emymtDivCd */
              //  upInfcDlgn0100Vo.setDeptCd(infcDlgn0100Vo.getDeptCd());                        /** column 부서코드 : deptCd */
              //  upInfcDlgn0100Vo.setBusinCd(infcDlgn0100Vo.getBusinCd());                      /** column 사업코드 : businCd */
              //  upInfcDlgn0100Vo.setTypOccuCd(infcDlgn0100Vo.getTypOccuCd());                  /** column 직종코드 : typOccuCd */
              //   upInfcDlgn0100Vo.setPyspGrdeCd(infcDlgn0100Vo.getPyspGrdeCd());                /** column 호봉등급코드 : pyspGrdeCd */
              //  upInfcDlgn0100Vo.setDtilOccuInttnCd(infcDlgn0100Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
              //  upInfcDlgn0100Vo.setDilnlazDutyBgnnDt(infcDlgn0100Vo.getDilnlazDutyBgnnDt());  /** column 근태_근무시작일자 : dilnlazDutyBgnnDt */
              //  upInfcDlgn0100Vo.setDilnlazDutyEndDt(infcDlgn0100Vo.getDilnlazDutyEndDt());    /** column 근태_근무종료일자 : dilnlazDutyEndDt */
              //  upInfcDlgn0100Vo.setDilnlazDutyNumDys(infcDlgn0100Vo.getDilnlazDutyNumDys());  /** column 근태_근무일수 : dilnlazDutyNumDys */
                
                //TODO 연계처리 완료후 수정 할것 
                upInfcDlgn0100Vo.setDilnlazLvsgNumDys("0");          /** column 근태_연가일수 : dilnlazLvsgNumDys */
                upInfcDlgn0100Vo.setDilnlazAbnceNumDys(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazAbnceCnt"),"0"));        /** column 근태_결근일수 : dilnlazAbnceNumDys */
                upInfcDlgn0100Vo.setDilnlazSckleaNumDys(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazSckleaCnt"),"0"));      /** column 근태_병가일수 : dilnlazSckleaNumDys */
                upInfcDlgn0100Vo.setDilnlazOffvaNumDys(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazOffvaCnt"),"0"));        /** column 근태_공가일수 : dilnlazOffvaNumDys */
                upInfcDlgn0100Vo.setDilnlazFmlyEvntNumDys(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazFmlyEvntCnt"),"0"));  /** column 근태_경조사일수 : dilnlazFmlyEvntNumDys */
              
                
                //보건 - 태아검진 유급, 여성보건휴가 무급 
                upInfcDlgn0100Vo.setDilnlazHlthCreNumDys(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazHlthCreCnt"),"0"));    /** column 근태_보건일수 : dilnlazHlthCreNumDys */
                 
                if (ExtermsProps.getProps("EMYMT_DIVCD_02").equals(infcDlgn0100Vo.getEmymtDivCd())) {
	                //totDutyNumDys =(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazDutyTmSm"),"0"))).divide(new BigDecimal(ExtermsProps.PAYR_BASS_WKTM_201401_01), 2, BigDecimal.ROUND_HALF_UP) ;
	                totDutyNumDys =(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazTotDutyNumDys"),"0"))) ;
	                
	                totDutyNumDys = totDutyNumDys ; //.subtract(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("pubcHodyYnCnt"),"0")))
	                   // .add(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("paidPubcHodyYnCnt"),"0"))); // 휴일관리시 포함된 일수 임. 
	                  
	                //TODO --  시간으로 8시간근무로 따져서 일수 계산 하는로직으로 변경 
	                upInfcDlgn0100Vo.setDilnlazTotDutyNumDys(String.valueOf(totDutyNumDys));                                                     /** column 근태_총근무일수 : dilnlazTotDutyNumDys */
              
	                BigDecimal dilnlazTfcAssCstNumDys = BigDecimal.ZERO;
	                dilnlazTfcAssCstNumDys = (new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazTfcAssCstNumDys"),"0"))) ;
	                //dilnlazTfcAssCstNumDys = dilnlazTfcAssCstNumDys; //.subtract(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("pubcHodyYnCnt"),"0")));
	                
	                upInfcDlgn0100Vo.setDilnlazTfcAssCstNumDys(String.valueOf(dilnlazTfcAssCstNumDys));    /** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
	                
	                BigDecimal dilnlazLnchDys = BigDecimal.ZERO;
	                dilnlazLnchDys = (new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazLnchDys"),"0"))) ;
	                //dilnlazLnchDys = dilnlazLnchDys; //.subtract(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("pubcHodyYnCnt"),"0")));
	                upInfcDlgn0100Vo.setDilnlazLnchDys(String.valueOf(dilnlazLnchDys));    /** column 근태_급식비일수 : dilnlazLnchDys */
	                 
	                upInfcDlgn0100Vo.setDilnlazWklyHldyNumDys(MSFSharedUtils.defaultNulls(infcDlgn0100Vo.getDilnlazWklyHldyNumDys(),"0")); 
	                
	                /******************** 휴일근무 일수 괴산군청은 무조건 전 공무직은 적용 함 **********************************************************/
	                // TODO 만근인 경우 처리인지 확인 하여 로직 수정 
	               // upInfcDlgn0100Vo.setDilnlazPaidPubcHodyNum("1");                      /** column 근태_유급휴일수 : dilnlazPaidPubcHodyNum */ 
	                
                } else {
                	
                	  //BigDecimal dutyNumDays = BigDecimal.ZERO;
                	  //dutyNumDays = new BigDecimal(infcDlgn0100Vo.getDilnlazDutyNumDys());
                	  //upInfcDlgn0100Vo.setDilnlazTotDutyNumDys(String.valueOf(dutyNumDays.subtract(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazAbnceCnt"),"0")))));  
                	//  totDutyNumDys =(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazDutyTmSm"),"0"))).divide(new BigDecimal(ExtermsProps.PAYR_BASS_WKTM_201401_01))
                      //        .add(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("offdayCnt"),"0")));
                	  
                	  totDutyNumDys =(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazTotDutyNumDys"),"0"))) 
                              .add(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("offdayCnt"),"0")))
                               .add(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazAbnceDutyRcgtnCnt"),"0")))    /** 결근인정 추가 차후 확인   */
                               .add(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazSckleaCnt"),"0")))    /** 병가추가 차후 확인   */
                               .add(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazHlthCreCnt"),"0")))    /** 보건추가 차후 확인   */
                              .add(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("paidPubcHodyYnCnt"),"0")));
         
                      upInfcDlgn0100Vo.setDilnlazTotDutyNumDys(String.valueOf(totDutyNumDys));                                                     /** column 근태_총근무일수 : dilnlazTotDutyNumDys */
                      
                      upInfcDlgn0100Vo.setDilnlazTfcAssCstNumDys("0");    /** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
  	                  upInfcDlgn0100Vo.setDilnlazLnchDys("0");    /** column 근태_급식비일수 : dilnlazLnchDys */
  	                  
  	                upInfcDlgn0100Vo.setDilnlazWklyHldyNumDys("0"); 
  	                
                }
                //넘어온값으로 처리 하는 루틴으로 수정   
                 upInfcDlgn0100Vo.setDilnlazPaidHodyNumDys( MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazLvsgCnt"),"0"));                       /** column 근태_유급휴가일수  : dilnlazPaidHodyNumDys */
                                      /** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
            
                upInfcDlgn0100Vo.setDilnlazSpclHodyNumDys(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("dilnlazSpclHodyCnt")));              /** column 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
              //--  upInfcDlgn0100Vo.setDilnlazSatDutyNumDys(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("payCd")));                        /** column 총토요근무일수 : dilnlazSatDutyNumDys */
                upInfcDlgn0100Vo.setDilnlazHodyDutyNumDys(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("dilnlazHodyDutyNumDys")));   /** column 총휴일일수 : dilnlazHodyDutyNumDys */
                upInfcDlgn0100Vo.setDilnlazWkdDutyNumDys(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("dilnlazWkdDutyNumDys")));   /**   column 실근무일수 : dilnlazWkdDutyNumDys */
                //dilnlaz_etc_div_cd - 복무기타구분코드 (결근인정인경우) 
                upInfcDlgn0100Vo.setDilnlazAbnceDutyRcgtnDys(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("dilnlazAbnceDutyRcgtnCnt")));     /** column 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */ 
                upInfcDlgn0100Vo.setDilnlazTotDutyTm(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("dilnlazDutyTmSm")));                      /** column 근태_총근무시간 : dilnlazTotDutyTm */
              //  upInfcDlgn0100Vo.setDilnlazDdlnePrcsYn(infcDlgn0100Vo.getDilnlazDdlnePrcsYn());                                                /** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
              //  upInfcDlgn0100Vo.setDilnlazNoteCtnt(infcDlgn0100Vo.getDilnlazNoteCtnt());                                                      /** column 근태_비고내용 : dilnlazNoteCtnt */
//                upInfcDlgn0100Vo.setKybdr(infcDlgn0100Vo.getKybdr());          /** column 입력자 : kybdr     */
//                upInfcDlgn0100Vo.setInptDt(infcDlgn0100Vo.getInptDt());        /** column 입력일자 : inptDt   */
//                upInfcDlgn0100Vo.setInptAddr(infcDlgn0100Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                upInfcDlgn0100Vo.setIsmt(infcDlgn0100Vo.getIsmt());            /** column 수정자 : ismt      */
//                upInfcDlgn0100Vo.setRevnDt(infcDlgn0100Vo.getRevnDt());        /** column 수정일자 : revnDt   */
//                upInfcDlgn0100Vo.setRevnAddr(infcDlgn0100Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                manageCommuteService.updateManageCommuteInfcDlgn0100(upInfcDlgn0100Vo);
            }  
//            for(int iliCnt =0;iliCnt < list.size();iliCnt++) {
//                 
//            } 
            
        
        } catch (Exception ex) {
             
              //  throw MSFServerUtils.getOperationException("", ex, logger);
        }
         
        return result;
    }
    
    /**
     * 근태기본관리 - 기본근무내역을 가지고 온다.
     * @param payr0250Vo
     * @return
     * @throws Exception
     */
    public int setSelectManageInfcDlgn0100CommuteService(HttpServletRequest request,InfcPkgPayr0250VO payr0250Vo) throws Exception{
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (manageCommuteService == null) { 
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            manageCommuteService = (ManageCommuteService) wac.getBean("ManageCommuteService" ); 
           
       }
        
        int result = 0;
        try {
            
             InfcPkgDlgn0100SrhVO infcDlgn0100SrhVo = new InfcPkgDlgn0100SrhVO(); 
           
            //TODO 
            //result = manageCommuteService.updateManageCommuteInfcDlgn0100(searchVO);
        
        } catch (Exception ex) {
             
              //  throw MSFServerUtils.getOperationException("", ex, logger);
        }
         
        return result;
    }
    
    /**
     * infcDlgn0200 - 시간외 근무 업데이트 쿼리 적용 집계처리를 위한 부분 
     * @param payr0250Vo
     * @return
     * @throws Exception
     */
    public int setUpdateManageInfcDlgn0200CommuteService(HttpServletRequest request,InfcPkgDlgn0200VO infcDlgn0200Vo) throws Exception{
    	
    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (manageCommuteService == null) { 
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            manageCommuteService = (ManageCommuteService) wac.getBean("ManageCommuteService" ); 
           
       }
       
        int result = 0;
        InfcPkgDlgn0200SrhVO infcDlgn0200SrhVo = new InfcPkgDlgn0200SrhVO(); 
        
        
        try {
            
            infcDlgn0200SrhVo.setDpobCd(infcDlgn0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
            infcDlgn0200SrhVo.setSystemkey(infcDlgn0200Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
            infcDlgn0200SrhVo.setDilnlazExceDutyYrMnth(infcDlgn0200Vo.getDilnlazExceDutyYrMnth());    /** column 근태년월 : dilnlazYrMnth */
            infcDlgn0200SrhVo.setPayCd(infcDlgn0200Vo.getPayCd());    /** column 급여구분코드 : payCd */
            infcDlgn0200SrhVo.setEmymtDivCd(infcDlgn0200Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
            infcDlgn0200SrhVo.setDeptCd(infcDlgn0200Vo.getDeptCd());    /** column 부서코드 : deptCd */
            infcDlgn0200SrhVo.setBusinCd(infcDlgn0200Vo.getBusinCd());    /** column 사업코드 : businCd */
            infcDlgn0200SrhVo.setTypOccuCd(infcDlgn0200Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
            infcDlgn0200SrhVo.setDtilOccuInttnCd(infcDlgn0200Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
            infcDlgn0200SrhVo.setMangeDeptCd(infcDlgn0200Vo.getMangeDeptCd());    /** column 관리부서코드  mangeDeptCd */
            
            List list =  manageCommuteService.selectInfcDlgn0210TotList(infcDlgn0200SrhVo); 
            
            Iterator<Map<String, Object>> iter = list.iterator(); 
        
            while ( iter.hasNext() ) {
                Map<String, Object> mapInfcDlgn0200Tot = (Map<String, Object>) iter.next();
                BigDecimal totDutyNumDys =  BigDecimal.ZERO;
                BigDecimal hodyYnTm = BigDecimal.ZERO;
                BigDecimal hodyYnTT = BigDecimal.ZERO;
                InfcPkgDlgn0200VO upInfcDlgn0200Vo = new InfcPkgDlgn0200VO(); 
                
                upInfcDlgn0200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("dpobCd")));                  /** column 사업장코드 : dpobCd */
                upInfcDlgn0200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("systemkey")));            /** column SYSTEMKEY : systemkey */
                upInfcDlgn0200Vo.setDilnlazExceDutyYrMnth(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("dilnlazExceDutyYrMnth")));    /** column 근태년월 : dilnlazExceDutyYrMnth */
                upInfcDlgn0200Vo.setPayCd(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("payCd")));                    /** column 급여구분코드 : payCd */              
 
//                upInfcDlgn0200Vo.setEmymtDivCd(infcDlgn0200Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
//                upInfcDlgn0200Vo.setDeptCd(infcDlgn0200Vo.getDeptCd());    /** column 부서코드 : deptCd */
//                upInfcDlgn0200Vo.setBusinCd(infcDlgn0200Vo.getBusinCd());    /** column 사업코드 : businCd */
//                upInfcDlgn0200Vo.setTypOccuCd(infcDlgn0200Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//                upInfcDlgn0200Vo.setPyspGrdeCd(infcDlgn0200Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
//                upInfcDlgn0200Vo.setDtilOccuInttnCd(infcDlgn0200Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
//                upInfcDlgn0200Vo.setDilnlazExceDutyBgnnDt(infcDlgn0200Vo.getDilnlazExceDutyBgnnDt());    /** column 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
//                upInfcDlgn0200Vo.setDilnlazExceDutyEndDt(infcDlgn0200Vo.getDilnlazExceDutyEndDt());    /** column 근태_초과근무종료일자 : dilnlazExceDutyEndDt */
                
                if (ExtermsProps.getProps("EMYMT_DIVCD_02").equals(infcDlgn0200Vo.getEmymtDivCd())) {
                	 /******************** 휴일근무 일수 괴산군청은 무조건 전 공무직은 적용 함 **********************************************************/ 
                	hodyYnTm =(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0200Tot.get("dilnlazHodyYnTm"),"0"))); 
                    
                    /******************** 휴일근무 일수 괴산군청은 무조건 전 공무직은 적용 함 **********************************************************/ 
                      hodyYnTT =(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0200Tot.get("dilnlazPubcHodyDutyTm"),"0"))); 
                } else {
                	 /******************** 휴일근무 일수 괴산군청은 무조건 전 공무직은 적용 함 **********************************************************/ 
                      hodyYnTm =(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0200Tot.get("dilnlazHodyYnTm"),"0"))) 
                           .add(new BigDecimal("1")); 
                    
                    /******************** 휴일근무 일수 괴산군청은 무조건 전 공무직은 적용 함 **********************************************************/ 
                      hodyYnTT =(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0200Tot.get("dilnlazPubcHodyDutyTm"),"0"))) 
                           .add(new BigDecimal("8")); 
                }
                
               upInfcDlgn0200Vo.setDilnlazPubcHodyDutyNumDys(MSFSharedUtils.defaultNulls(String.valueOf(hodyYnTm),"0"));     /** column 근태_휴일근무일수 : dilnlazPubcHodyDutyNumDys */
              
               upInfcDlgn0200Vo.setDilnlazPubcHodyDutyTm(MSFSharedUtils.defaultNulls(String.valueOf(hodyYnTT),"0")); /** column 근태_휴일근무시간 : dilnlazHodyDutySum */
             //  upInfcDlgn0200Vo.setDilnlazPubcHodyDutyTm(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("dilnlazPubcHodyDutyTm"))); /** column 근태_휴일근무시간 : dilnlazHodyDutySum */
               upInfcDlgn0200Vo.setDilnlazHodyTotNtotTm(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("dilnlazHodyTotNtotTm")));  /** set 근태_휴일총연장근무시간 : dilnlazHodyTotNtotTm */
            
             //   upInfcDlgn0200Vo.setDilnlazPubcHodyDutyNumDys(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("dilnlazHodyYnTm")));    /** column 근태_휴일근무일수 : dilnlazPubcHodyDutyNumDys */
                upInfcDlgn0200Vo.setDilnlazSatDutyNumDys("0");    /** column 근태_토요근무일수 : dilnlazSatDutyNumDys */
                upInfcDlgn0200Vo.setDilnlazTotNtotNumDys(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("dilnlazNtotCnt")));    /** column 근태_총야근일수 : dilnlazTotNtotNumDys */
                upInfcDlgn0200Vo.setDilnlazTotNtotTm(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("dilnlazNtotSum")));        /** column 근태_총야근시간 : dilnlazTotNtotTm */
               // upInfcDlgn0200Vo.setDilnlazFndtnTmRstDutyTm(ExtermsProps.PAYR_OVER_WKTM_201401); 
                upInfcDlgn0200Vo.setDilnlazFndtnTmRstDutyTm("0"); /** column 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
                upInfcDlgn0200Vo.setDilnlazTmRstDutyTm(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("dilnlazTmRstDutyTm")));      /** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
                upInfcDlgn0200Vo.setDilnlazTotTmRstDutyTm(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("dilnlazTmRstDutyTm")));   /** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */
//                upInfcDlgn0200Vo.setDilnlazDdlnePrcsYn(infcDlgn0200Vo.getDilnlazDdlnePrcsYn());    /** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
//                upInfcDlgn0200Vo.setDilnlazNoteCtnt(infcDlgn0200Vo.getDilnlazNoteCtnt());    /** column 근태_비고내용 : dilnlazNoteCtnt */
//                upInfcDlgn0200Vo.setKybdr(infcDlgn0200Vo.getKybdr());    /** column 입력자 : kybdr */
//                upInfcDlgn0200Vo.setInptDt(infcDlgn0200Vo.getInptDt());    /** column 입력일자 : inptDt */
//                upInfcDlgn0200Vo.setInptAddr(infcDlgn0200Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                upInfcDlgn0200Vo.setIsmt(infcDlgn0200Vo.getIsmt());    /** column 수정자 : ismt */
//                upInfcDlgn0200Vo.setRevnDt(infcDlgn0200Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                upInfcDlgn0200Vo.setRevnAddr(infcDlgn0200Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
               // upInfcDlgn0200Vo.setDilnlazPubcHodyDutyTm(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("dilnlazHodyDutySum"))); /** column 근태_휴일근무시간 : dilnlazHodyDutySum */
               
                manageCommuteService.updateManageCommuteInfcDlgn0200(upInfcDlgn0200Vo);
            }  
//            for(int iliCnt =0;iliCnt < list.size();iliCnt++) {
//                 
//            } 
           
        
        } catch (Exception ex) {
             
             //  throw MSFServerUtils.getOperationException("", ex, logger);
        }
         
        return result;
	}
    
    /**
     * infcDlgn0200 시간외 근무 집계 내역을 가지고 온다.
     * @param payr0250Vo
     * @return
     * @throws Exception
     */
    public int setSelectManageInfcDlgn0200CommuteService(HttpServletRequest request,InfcPkgPayr0250VO payr0250Vo) throws Exception{
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (manageCommuteService == null) { 
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            manageCommuteService = (ManageCommuteService) wac.getBean("ManageCommuteService" ); 
           
       }
        //Payr0250VO payr0250Vo = new Payr0250VO(); 
        int result = 0;
        try {
            
            InfcPkgDlgn0200SrhVO infcDlgn0200SrhVo = new InfcPkgDlgn0200SrhVO(); 
            
//            Payr0305SrhVO searchVO = new Payr0305SrhVO();
//            searchVO.setDpobCd(""); 
            //TODO 
            //result = manageCommuteService.updateManageCommuteInfcDlgn0100(searchVO);
        
        } catch (Exception ex) {
             
              //  throw MSFServerUtils.getOperationException("", ex, logger);
        }
         
        return result;
    }
   
    

   /**
    * 
    * <pre>
    * 1. 개요 : 기본근무관리 분단위 집계처리 메서드  
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : setUpdateManageInfcDlgn0100HHMiCommuteService
    * @date : 2017. 4. 12.
    * @author : paygen
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	2017. 4. 12.		paygen				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @param request
    * @param infcDlgn0100Vo
    * @return
    * @throws Exception
    */
    public int setUpdateManageInfcDlgn0100HHMiCommuteService(HttpServletRequest request,InfcPkgDlgn0100VO infcDlgn0100Vo) throws Exception{
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (manageCommuteService == null) { 
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            manageCommuteService = (ManageCommuteService) wac.getBean("ManageCommuteService" ); 
           
       }
       
        int result = 0;
        InfcPkgDlgn0100SrhVO infcDlgn0100SrhVo = new InfcPkgDlgn0100SrhVO(); 
        
        
        try {
            
            infcDlgn0100SrhVo.setDpobCd(infcDlgn0100Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
            infcDlgn0100SrhVo.setSystemkey(infcDlgn0100Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
            infcDlgn0100SrhVo.setDilnlazYrMnth(infcDlgn0100Vo.getDilnlazYrMnth());    /** column 근태년월 : dilnlazYrMnth */
            infcDlgn0100SrhVo.setPayCd(infcDlgn0100Vo.getPayCd());    /** column 급여구분코드 : payCd */
            infcDlgn0100SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(infcDlgn0100Vo.getEmymtDivCd())  );    /** column 고용구분코드 : emymtDivCd */
            infcDlgn0100SrhVo.setDeptCd(infcDlgn0100Vo.getDeptCd());    /** column 부서코드 : deptCd */
            infcDlgn0100SrhVo.setBusinCd(infcDlgn0100Vo.getBusinCd());    /** column 사업코드 : businCd */
            infcDlgn0100SrhVo.setTypOccuCd(infcDlgn0100Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
            infcDlgn0100SrhVo.setMangeDeptCd(infcDlgn0100Vo.getMangeDeptCd());    /** column 관리부서코드  mangeDeptCd */
            infcDlgn0100SrhVo.setDtilOccuInttnCd(infcDlgn0100Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
         
            
            List list =  manageCommuteService.selectInfcDlgn0110HHMiTotList(infcDlgn0100SrhVo); 
            
            Iterator<Map<String, Object>> iter = list.iterator(); 
        
            while ( iter.hasNext() ) {
                Map<String, Object> mapInfcDlgn0100Tot = (Map<String, Object>) iter.next();
                BigDecimal totDutyNumDys =  BigDecimal.ZERO;
                InfcPkgDlgn0100VO upInfcDlgn0100Vo = new InfcPkgDlgn0100VO(); 
                
                upInfcDlgn0100Vo.setDpobCd(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("dpobCd")));                  /** column 사업장코드 : dpobCd */
                upInfcDlgn0100Vo.setSystemkey(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("systemkey")));            /** column SYSTEMKEY : systemkey */
                upInfcDlgn0100Vo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("dilnlazYrMnth")));    /** column 근태년월 : dilnlazYrMnth */
                upInfcDlgn0100Vo.setPayCd(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("payCd")));                    /** column 급여구분코드 : payCd */
              //  upInfcDlgn0100Vo.setEmymtDivCd(infcDlgn0100Vo.getEmymtDivCd());                /** column 고용구분코드 : emymtDivCd */
              //  upInfcDlgn0100Vo.setDeptCd(infcDlgn0100Vo.getDeptCd());                        /** column 부서코드 : deptCd */
              //  upInfcDlgn0100Vo.setBusinCd(infcDlgn0100Vo.getBusinCd());                      /** column 사업코드 : businCd */
              //  upInfcDlgn0100Vo.setTypOccuCd(infcDlgn0100Vo.getTypOccuCd());                  /** column 직종코드 : typOccuCd */
              //   upInfcDlgn0100Vo.setPyspGrdeCd(infcDlgn0100Vo.getPyspGrdeCd());                /** column 호봉등급코드 : pyspGrdeCd */
              //  upInfcDlgn0100Vo.setDtilOccuInttnCd(infcDlgn0100Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
              //  upInfcDlgn0100Vo.setDilnlazDutyBgnnDt(infcDlgn0100Vo.getDilnlazDutyBgnnDt());  /** column 근태_근무시작일자 : dilnlazDutyBgnnDt */
              //  upInfcDlgn0100Vo.setDilnlazDutyEndDt(infcDlgn0100Vo.getDilnlazDutyEndDt());    /** column 근태_근무종료일자 : dilnlazDutyEndDt */
              //  upInfcDlgn0100Vo.setDilnlazDutyNumDys(infcDlgn0100Vo.getDilnlazDutyNumDys());  /** column 근태_근무일수 : dilnlazDutyNumDys */
                
                //TODO 연계처리 완료후 수정 할것 
                upInfcDlgn0100Vo.setDilnlazLvsgNumDys("0");          /** column 근태_연가일수 : dilnlazLvsgNumDys */
                upInfcDlgn0100Vo.setDilnlazAbnceNumDys(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazAbnceCnt"),"0"));        /** column 근태_결근일수 : dilnlazAbnceNumDys */
                upInfcDlgn0100Vo.setDilnlazSckleaNumDys(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazSckleaCnt"),"0"));      /** column 근태_병가일수 : dilnlazSckleaNumDys */
                upInfcDlgn0100Vo.setDilnlazOffvaNumDys(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazOffvaCnt"),"0"));        /** column 근태_공가일수 : dilnlazOffvaNumDys */
                upInfcDlgn0100Vo.setDilnlazFmlyEvntNumDys(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazFmlyEvntCnt"),"0"));  /** column 근태_경조사일수 : dilnlazFmlyEvntNumDys */
              
                
                //보건 - 태아검진 유급, 여성보건휴가 무급 
                upInfcDlgn0100Vo.setDilnlazHlthCreNumDys(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazHlthCreCnt"),"0"));    /** column 근태_보건일수 : dilnlazHlthCreNumDys */
                 
                if (ExtermsProps.getProps("EMYMT_DIVCD_02").equals(infcDlgn0100Vo.getEmymtDivCd())) {
	                //totDutyNumDys =(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazDutyTmSm"),"0"))).divide(new BigDecimal(ExtermsProps.PAYR_BASS_WKTM_201401_01), 2, BigDecimal.ROUND_HALF_UP) ;
	                totDutyNumDys =(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazTotDutyNumDys"),"0"))) ;
	                
	                totDutyNumDys = totDutyNumDys ; //.subtract(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("pubcHodyYnCnt"),"0")))
	                    //.add(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("paidPubcHodyYnCnt"),"0"))); // 휴일관리시 포함된 일수 임. 
	                  
	                //TODO --  시간으로 8시간근무로 따져서 일수 계산 하는로직으로 변경 
	                upInfcDlgn0100Vo.setDilnlazTotDutyNumDys(String.valueOf(totDutyNumDys));                                                     /** column 근태_총근무일수 : dilnlazTotDutyNumDys */
              
	                BigDecimal dilnlazTfcAssCstNumDys = BigDecimal.ZERO;
	                dilnlazTfcAssCstNumDys = (new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazTfcAssCstNumDys"),"0"))) ;
	                //dilnlazTfcAssCstNumDys = dilnlazTfcAssCstNumDys; //.subtract(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("pubcHodyYnCnt"),"0")));
	                
	                upInfcDlgn0100Vo.setDilnlazTfcAssCstNumDys(String.valueOf(dilnlazTfcAssCstNumDys));    /** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
	                
	                BigDecimal dilnlazLnchDys = BigDecimal.ZERO;
	                dilnlazLnchDys = (new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazLnchDys"),"0"))) ;
	                //dilnlazLnchDys = dilnlazLnchDys; //.subtract(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("pubcHodyYnCnt"),"0")));
	                upInfcDlgn0100Vo.setDilnlazLnchDys(String.valueOf(dilnlazLnchDys));    /** column 근태_급식비일수 : dilnlazLnchDys */
	                 
	                upInfcDlgn0100Vo.setDilnlazWklyHldyNumDys(MSFSharedUtils.defaultNulls(infcDlgn0100Vo.getDilnlazWklyHldyNumDys(),"0")); 
	                
	                /******************** 휴일근무 일수 괴산군청은 무조건 전 공무직은 적용 함 **********************************************************/
	                // TODO 만근인 경우 처리인지 확인 하여 로직 수정 
	               // upInfcDlgn0100Vo.setDilnlazPaidPubcHodyNum("1");                      /** column 근태_유급휴일수 : dilnlazPaidPubcHodyNum */ 
	                
                } else {
                	
                	  //BigDecimal dutyNumDays = BigDecimal.ZERO;
                	  //dutyNumDays = new BigDecimal(infcDlgn0100Vo.getDilnlazDutyNumDys());
                	  //upInfcDlgn0100Vo.setDilnlazTotDutyNumDys(String.valueOf(dutyNumDays.subtract(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazAbnceCnt"),"0")))));  
                	//  totDutyNumDys =(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazDutyTmSm"),"0"))).divide(new BigDecimal(ExtermsProps.PAYR_BASS_WKTM_201401_01))
                      //        .add(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("offdayCnt"),"0")));
                	  
                	  totDutyNumDys =(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazTotDutyNumDys"),"0"))) 
                              .add(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("offdayCnt"),"0")))
                               .add(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazAbnceDutyRcgtnCnt"),"0")))    /** 결근인정 추가 차후 확인   */
                               .add(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazSckleaCnt"),"0")))    /** 병가추가 차후 확인   */
                               .add(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazHlthCreCnt"),"0")))    /** 보건추가 차후 확인   */
                              .add(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("paidPubcHodyYnCnt"),"0")));
         
                      upInfcDlgn0100Vo.setDilnlazTotDutyNumDys(String.valueOf(totDutyNumDys));                                                     /** column 근태_총근무일수 : dilnlazTotDutyNumDys */
                      
                      upInfcDlgn0100Vo.setDilnlazTfcAssCstNumDys("0");    /** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
  	                  upInfcDlgn0100Vo.setDilnlazLnchDys("0");    /** column 근태_급식비일수 : dilnlazLnchDys */
  	                  
  	                upInfcDlgn0100Vo.setDilnlazWklyHldyNumDys("0"); 
  	                
                }
                //넘어온값으로 처리 하는 루틴으로 수정   
                 upInfcDlgn0100Vo.setDilnlazPaidHodyNumDys( MSFSharedUtils.defaultNulls(mapInfcDlgn0100Tot.get("dilnlazLvsgCnt"),"0"));                       /** column 근태_유급휴가일수  : dilnlazPaidHodyNumDys */
                                      /** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
                upInfcDlgn0100Vo.setDilnlazSpclHodyNumDys(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("dilnlazSpclHodyCnt")));              /** column 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
              //--  upInfcDlgn0100Vo.setDilnlazSatDutyNumDys(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("payCd")));                        /** column 총토요근무일수 : dilnlazSatDutyNumDys */
                upInfcDlgn0100Vo.setDilnlazHodyDutyNumDys(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("dilnlazHodyDutyNumDys")));   /** column 총휴일일수 : dilnlazHodyDutyNumDys */
                upInfcDlgn0100Vo.setDilnlazWkdDutyNumDys(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("dilnlazWkdDutyNumDys")));   /**   column 실근무일수 : dilnlazWkdDutyNumDys */
                //dilnlaz_etc_div_cd - 복무기타구분코드 (결근인정인경우) 
                upInfcDlgn0100Vo.setDilnlazAbnceDutyRcgtnDys(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("dilnlazAbnceDutyRcgtnCnt")));     /** column 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */ 
                upInfcDlgn0100Vo.setDilnlazTotDutyTm(MSFSharedUtils.allowNulls(mapInfcDlgn0100Tot.get("dilnlazDutyTmSm")));                      /** column 근태_총근무시간 : dilnlazTotDutyTm */
              //  upInfcDlgn0100Vo.setDilnlazDdlnePrcsYn(infcDlgn0100Vo.getDilnlazDdlnePrcsYn());                                                /** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
              //  upInfcDlgn0100Vo.setDilnlazNoteCtnt(infcDlgn0100Vo.getDilnlazNoteCtnt());                                                      /** column 근태_비고내용 : dilnlazNoteCtnt */
//                upInfcDlgn0100Vo.setKybdr(infcDlgn0100Vo.getKybdr());          /** column 입력자 : kybdr     */
//                upInfcDlgn0100Vo.setInptDt(infcDlgn0100Vo.getInptDt());        /** column 입력일자 : inptDt   */
//                upInfcDlgn0100Vo.setInptAddr(infcDlgn0100Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                upInfcDlgn0100Vo.setIsmt(infcDlgn0100Vo.getIsmt());            /** column 수정자 : ismt      */
//                upInfcDlgn0100Vo.setRevnDt(infcDlgn0100Vo.getRevnDt());        /** column 수정일자 : revnDt   */
//                upInfcDlgn0100Vo.setRevnAddr(infcDlgn0100Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                manageCommuteService.updateManageCommuteInfcDlgn0100(upInfcDlgn0100Vo);
            }  
//            for(int iliCnt =0;iliCnt < list.size();iliCnt++) {
//                 
//            } 
            
        
        } catch (Exception ex) {
             
              //  throw MSFServerUtils.getOperationException("", ex, logger);
        }
         
        return result;
    }
    
    /**
     * 
     * <pre>
     * 1. 개요 : 기본근무관리 분단위 집계 처리 메서드  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : setSelectManageInfcDlgn0100HHMiCommuteService
     * @date : 2017. 4. 12.
     * @author : paygen
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 4. 12.		paygen				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param request
     * @param payr0250Vo
     * @return
     * @throws Exception
     */
    public int setSelectManageInfcDlgn0100HHMiCommuteService(HttpServletRequest request,InfcPkgPayr0250VO payr0250Vo) throws Exception{
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (manageCommuteService == null) { 
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            manageCommuteService = (ManageCommuteService) wac.getBean("ManageCommuteService" ); 
           
       }
        
        int result = 0;
        try {
            
             InfcPkgDlgn0100SrhVO infcDlgn0100SrhVo = new InfcPkgDlgn0100SrhVO(); 
           
            //TODO 
            //result = manageCommuteService.updateManageCommuteInfcDlgn0100(searchVO);
        
        } catch (Exception ex) {
             
              //  throw MSFServerUtils.getOperationException("", ex, logger);
        }
         
        return result;
    }
    
    /**
     * 
     * <pre>
     * 1. 개요 : 시간외 근무 분단위 집계 처리 메서드  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : setUpdateManageInfcDlgn0200HHMiCommuteService
     * @date : 2017. 4. 12.
     * @author : paygen
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 4. 12.		paygen				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param request
     * @param infcDlgn0200Vo
     * @return
     * @throws Exception
     */
    public int setUpdateManageInfcDlgn0200HHMiCommuteService(HttpServletRequest request,InfcPkgDlgn0200VO infcDlgn0200Vo) throws Exception{
    	
    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (manageCommuteService == null) { 
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            manageCommuteService = (ManageCommuteService) wac.getBean("ManageCommuteService" ); 
           
       }
       
        int result = 0;
        InfcPkgDlgn0200SrhVO infcDlgn0200SrhVo = new InfcPkgDlgn0200SrhVO(); 
        
        
        try {
            
            infcDlgn0200SrhVo.setDpobCd(infcDlgn0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
            infcDlgn0200SrhVo.setSystemkey(infcDlgn0200Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
            infcDlgn0200SrhVo.setDilnlazExceDutyYrMnth(infcDlgn0200Vo.getDilnlazExceDutyYrMnth());    /** column 근태년월 : dilnlazYrMnth */
            infcDlgn0200SrhVo.setPayCd(infcDlgn0200Vo.getPayCd());    /** column 급여구분코드 : payCd */
            infcDlgn0200SrhVo.setEmymtDivCd(infcDlgn0200Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
            infcDlgn0200SrhVo.setDeptCd(infcDlgn0200Vo.getDeptCd());    /** column 부서코드 : deptCd */
            infcDlgn0200SrhVo.setBusinCd(infcDlgn0200Vo.getBusinCd());    /** column 사업코드 : businCd */
            infcDlgn0200SrhVo.setTypOccuCd(infcDlgn0200Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
            infcDlgn0200SrhVo.setDtilOccuInttnCd(infcDlgn0200Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
            infcDlgn0200SrhVo.setMangeDeptCd(infcDlgn0200Vo.getMangeDeptCd());    /** column 관리부서코드  mangeDeptCd */
            
            List list =  manageCommuteService.selectInfcDlgn0210HHMiTotList(infcDlgn0200SrhVo); 
            
            Iterator<Map<String, Object>> iter = list.iterator(); 
        
            while ( iter.hasNext() ) {
                Map<String, Object> mapInfcDlgn0200Tot = (Map<String, Object>) iter.next();
                BigDecimal totDutyNumDys =  BigDecimal.ZERO;
                BigDecimal hodyYnTm = BigDecimal.ZERO;
                BigDecimal hodyYnTT = BigDecimal.ZERO;
                InfcPkgDlgn0200VO upInfcDlgn0200Vo = new InfcPkgDlgn0200VO(); 
                
                upInfcDlgn0200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("dpobCd")));                  /** column 사업장코드 : dpobCd */
                upInfcDlgn0200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("systemkey")));            /** column SYSTEMKEY : systemkey */
                upInfcDlgn0200Vo.setDilnlazExceDutyYrMnth(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("dilnlazExceDutyYrMnth")));    /** column 근태년월 : dilnlazExceDutyYrMnth */
                upInfcDlgn0200Vo.setPayCd(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("payCd")));                    /** column 급여구분코드 : payCd */              
 
//                upInfcDlgn0200Vo.setEmymtDivCd(infcDlgn0200Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
//                upInfcDlgn0200Vo.setDeptCd(infcDlgn0200Vo.getDeptCd());    /** column 부서코드 : deptCd */
//                upInfcDlgn0200Vo.setBusinCd(infcDlgn0200Vo.getBusinCd());    /** column 사업코드 : businCd */
//                upInfcDlgn0200Vo.setTypOccuCd(infcDlgn0200Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//                upInfcDlgn0200Vo.setPyspGrdeCd(infcDlgn0200Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
//                upInfcDlgn0200Vo.setDtilOccuInttnCd(infcDlgn0200Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
//                upInfcDlgn0200Vo.setDilnlazExceDutyBgnnDt(infcDlgn0200Vo.getDilnlazExceDutyBgnnDt());    /** column 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
//                upInfcDlgn0200Vo.setDilnlazExceDutyEndDt(infcDlgn0200Vo.getDilnlazExceDutyEndDt());    /** column 근태_초과근무종료일자 : dilnlazExceDutyEndDt */
                
                if (ExtermsProps.getProps("EMYMT_DIVCD_02").equals(infcDlgn0200Vo.getEmymtDivCd())) {
                	  /******************** 휴일근무 일수 괴산군청은 무조건 전 공무직은 적용 함 **********************************************************/ 
                    hodyYnTm =(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0200Tot.get("dilnlazHodyYnTm"),"0"))); 
                  /******************** 휴일근무 일수 괴산군청은 무조건 전 공무직은 적용 함  1일 무조건 적용해서 처리 **********************************************************/ 
                    hodyYnTT =(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0200Tot.get("dilnlazPubcHodyDutyTm"),"0")));  
                } else {
                 /******************** 휴일근무 일수 괴산군청은 무조건 전 공무직은 적용 함 **********************************************************/ 
                   hodyYnTm =(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0200Tot.get("dilnlazHodyYnTm"),"0"))) 
                        .add(new BigDecimal("1")); 
                 /******************** 휴일근무 일수 괴산군청은 무조건 전 공무직은 적용 함  1일 무조건 적용해서 처리 **********************************************************/ 
                   hodyYnTT =(new BigDecimal(MSFSharedUtils.defaultNulls(mapInfcDlgn0200Tot.get("dilnlazPubcHodyDutyTm"),"0"))) 
                        .add(new BigDecimal("480"));  
                
                }
                 
                 upInfcDlgn0200Vo.setDilnlazPubcHodyDutyNumDys(MSFSharedUtils.defaultNulls(String.valueOf(hodyYnTm),"0"));    /** column 근태_휴일근무일수 : dilnlazPubcHodyDutyNumDys */
                 
                 upInfcDlgn0200Vo.setDilnlazPubcHodyDutyTm(MSFSharedUtils.defaultNulls(String.valueOf(hodyYnTT),"0")); /** column 근태_휴일근무시간 : dilnlazHodyDutySum */
                 upInfcDlgn0200Vo.setDilnlazHodyTotNtotTm(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("dilnlazHodyTotNtotTm")));  /** set 근태_휴일총연장근무시간 : dilnlazHodyTotNtotTm */
                 
                
                
                upInfcDlgn0200Vo.setDilnlazSatDutyNumDys("0");    /** column 근태_토요근무일수 : dilnlazSatDutyNumDys */
                upInfcDlgn0200Vo.setDilnlazTotNtotNumDys(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("dilnlazNtotCnt")));    /** column 근태_총야근일수 : dilnlazTotNtotNumDys */
                upInfcDlgn0200Vo.setDilnlazTotNtotTm(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("dilnlazNtotSum")));        /** column 근태_총야근시간 : dilnlazTotNtotTm */
               // upInfcDlgn0200Vo.setDilnlazFndtnTmRstDutyTm(ExtermsProps.PAYR_OVER_WKTM_201401); 
                upInfcDlgn0200Vo.setDilnlazFndtnTmRstDutyTm("0"); /** column 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
                upInfcDlgn0200Vo.setDilnlazTmRstDutyTm(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("dilnlazTmRstDutyTm")));      /** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
                upInfcDlgn0200Vo.setDilnlazTotTmRstDutyTm(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("dilnlazTmRstDutyTm")));   /** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */
//                upInfcDlgn0200Vo.setDilnlazDdlnePrcsYn(infcDlgn0200Vo.getDilnlazDdlnePrcsYn());    /** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
//                upInfcDlgn0200Vo.setDilnlazNoteCtnt(infcDlgn0200Vo.getDilnlazNoteCtnt());    /** column 근태_비고내용 : dilnlazNoteCtnt */
//                upInfcDlgn0200Vo.setKybdr(infcDlgn0200Vo.getKybdr());    /** column 입력자 : kybdr */
//                upInfcDlgn0200Vo.setInptDt(infcDlgn0200Vo.getInptDt());    /** column 입력일자 : inptDt */
//                upInfcDlgn0200Vo.setInptAddr(infcDlgn0200Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                upInfcDlgn0200Vo.setIsmt(infcDlgn0200Vo.getIsmt());    /** column 수정자 : ismt */
//                upInfcDlgn0200Vo.setRevnDt(infcDlgn0200Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                upInfcDlgn0200Vo.setRevnAddr(infcDlgn0200Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
              //  upInfcDlgn0200Vo.setDilnlazPubcHodyDutyTm(MSFSharedUtils.allowNulls(mapInfcDlgn0200Tot.get("dilnlazHodyDutySum"))); /** column 근태_휴일근무시간 : dilnlazHodyDutySum */
               
              
                manageCommuteService.updateManageCommuteInfcDlgn0200(upInfcDlgn0200Vo);
            }  
//            for(int iliCnt =0;iliCnt < list.size();iliCnt++) {
//                 
//            } 
           
        
        } catch (Exception ex) {
             
             //  throw MSFServerUtils.getOperationException("", ex, logger);
        }
         
        return result;
	}
    
    /**
     * 
     * <pre>
     * 1. 개요 : 시간외 근무 집계 분단위 처리 메서드  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : setSelectManageInfcDlgn0200HHMiCommuteService
     * @date : 2017. 4. 12.
     * @author : paygen
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 4. 12.		paygen				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param request
     * @param payr0250Vo
     * @return
     * @throws Exception
     */
    public int setSelectManageInfcDlgn0200HHMiCommuteService(HttpServletRequest request,InfcPkgPayr0250VO payr0250Vo) throws Exception{
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (manageCommuteService == null) { 
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            manageCommuteService = (ManageCommuteService) wac.getBean("ManageCommuteService" ); 
           
       }
        //Payr0250VO payr0250Vo = new Payr0250VO(); 
        int result = 0;
        try {
            
            InfcPkgDlgn0200SrhVO infcDlgn0200SrhVo = new InfcPkgDlgn0200SrhVO(); 
            
//            Payr0305SrhVO searchVO = new Payr0305SrhVO();
//            searchVO.setDpobCd(""); 
            //TODO 
            //result = manageCommuteService.updateManageCommuteInfcDlgn0100(searchVO);
        
        } catch (Exception ex) {
             
              //  throw MSFServerUtils.getOperationException("", ex, logger);
        }
         
        return result;
    }   

}