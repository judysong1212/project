package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2016.file.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.egov.comutils.payr.PkgFuncUtils;
import com.app.smrmf.infc.sysif.msfpackage.server.utils.SysifPkgServiceUtils;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta1000VO;
import com.app.smrmf.infc.yearendtax.server.vo.YetaMessageVO;
import com.app.smrmf.pkg.yeta.yeta2016.file.service.Yeta1400PayrService;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0350VO;

import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class Yeta1400FileController {


    private static final Logger logger = LoggerFactory.getLogger(Yeta1400FileController.class);  
 
    
    @Resource(name = "Yeta1400PayrService")
    private Yeta1400PayrService yeta1400PayrService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService; 
    
    @RequestMapping(value = "/exp/FileYeta1400Export.do")
    public String expYeta1400Export(@ModelAttribute("InfcPkgYeta1000VO") InfcPkgYeta1000VO yeta1000VO,final HttpServletRequest request,final HttpServletResponse response
            , Map commandMap , Model model) throws Exception {
         
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        String sResult = "";
        int state = 0;
    	  
        if  (yeta1400PayrService == null) { 
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            yeta1400PayrService = (Yeta1400PayrService) wac.getBean("Yeta1400PayrService" ); 
           
       }
        
         
        try	{ 
        	
        	
         List<String> listDeptCd = new ArrayList<String>(); 
         yeta1000VO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
         yeta1000VO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 

     	 yeta1000VO.setDeptCdAuth(MSFSharedUtils.allowNulls(yeta1000VO.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
     	 yeta1000VO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(yeta1000VO.getDtilOccuInttnCd()).replace(",", ""));   
        
     	 yeta1000VO.setUsrId(sessionUser.getUsrId());
   	   	 /******************************** 권한 ************************************************************************/
   	   	 String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
   	   	 	
   	   	 if ("FALSE".equals(chkDeptCd)) {
   	   		 
   	   		 yeta1000VO.setDeptCd(sessionUser.getDeptCd()); 
   		   	 listDeptCd.add(sessionUser.getDeptCd());
   		   	 yeta1000VO.setDeptCdArr(listDeptCd);     //부서코드    
   		   	 yeta1000VO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
   		        
   	   	 } else {
   	     	    
   	   		 yeta1000VO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(yeta1000VO.getPayrMangDeptCd())) ;   //단위기관코드   
   	   	 		
   	   	 	if (yeta1000VO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(yeta1000VO.getDeptCd()))) { 
   	   	 		listDeptCd = null; 
   	   	 		yeta1000VO.setDeptCdArr(listDeptCd);     //부서코드 
   	   	 		yeta1000VO.setDeptCd("");  //부서코드
   	   	 	} else {
   	   	 		yeta1000VO.setDeptCd(MSFSharedUtils.allowNulls(yeta1000VO.getDeptCd()));
   	            listDeptCd = SmrmfUtils.getStrToArrayList(yeta1000VO.getDeptCd());  
   	            yeta1000VO.setDeptCdArr(listDeptCd);     //부서코드   
   	        } 
   	   	 }
   	     
   	     
   	     
   	   	 /******************************** 권한 ************************************************************************/
   	  	
   	    List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta1000VO.getTypOccuCd())); 
   	    yeta1000VO.setTypOccuCdArr(lstTypeOccuCd); 
   	    yeta1000VO.setTypOccuCd(MSFSharedUtils.allowNulls(yeta1000VO.getTypOccuCd()));  	//직종
	        
//	  	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	  	psnl0100SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	  	psnl0100SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	          
	   	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta1000VO.getDtilOccuInttnCd())); 
	   	yeta1000VO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	   	yeta1000VO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(yeta1000VO.getDtilOccuInttnCd())); //직종세
	        
		List<String> lstBusinCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta1000VO.getBusinCd())); 
		yeta1000VO.setBusinCdArr(lstBusinCd);   
		yeta1000VO.setBusinCd(MSFSharedUtils.allowNulls(yeta1000VO.getBusinCd()));   //사업코드
		
		yeta1000VO.setYetaDpcd(MSFSharedUtils.allowNulls(yeta1000VO.getYetaDpcd()));				//원천신고부서
		yeta1000VO.setBusoprRgstnum(MSFSharedUtils.allowNulls(yeta1000VO.getBusoprRgstnum()));	//사업자등록번호
		
		

     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
//      	SysIfBass0320VO  sysIfBass0320Vo = new SysIfBass0320VO();
//     	 List<String> listTypCd = new ArrayList<String>(); 
//     	 
//     	sysIfBass0320Vo.setYmdGb("Y");
//     	sysIfBass0320Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYr")));
//     	sysIfBass0320Vo.setTypOccuCd(psnl0100SrhVO.getTypOccuCd());
//     	sysIfBass0320Vo.setTypOccuCdArr(lstTypeOccuCd); 
//     	
//     	listTypCd = SysifPkgServiceUtils.funcArrBeforTypOccuCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0320Vo);
     	
     	SysIfBass0350VO  sysIfBass0350Vo = new SysIfBass0350VO();
     //	 List<String> listTyInttnCd = new ArrayList<String>(); 
     	sysIfBass0350Vo.setDpobCd(sessionUser.getDpobCd());
     	sysIfBass0350Vo.setYmdGb("Y");
     	sysIfBass0350Vo.setStrDate(MSFSharedUtils.allowNulls(yeta1000VO.getEdacRvyy()));
     	sysIfBass0350Vo.setTypOccuCd(yeta1000VO.getTypOccuCd());
     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
    	sysIfBass0350Vo.setDtilOccuInttnCd(yeta1000VO.getDtilOccuInttnCd());
     	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
     	
     	sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0350Vo); 
     
     	yeta1000VO.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
     	yeta1000VO.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
     	
     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/

     	

		       	 if (yeta1000VO.getCreFile().equals("Y0090001")) {
		       		 //근로소득지급명세서 호출 
		       		  state = fnYeta1400_ReTax_Payr3000_Create(yeta1000VO,response) ;
		//       		 if state = 0 then
		//			          begin
		//			            ShowMessage('근로소득지급명세서 파일생성이 완료되었습니다.');
		//			          end;
		       	 
		       	 } else if (yeta1000VO.getCreFile().equals("Y0090002")) {
		       		 //의료비지급명세서 
		       		state = fnYeta1400_ReTax_Yeta3140_Create(yeta1000VO,response) ;
		       	   
		//	          if state = 0 then
		//	          begin
		//	            ShowMessage('의료비지급명세서 파일생성이 완료되었습니다.');
		//	          end;
		       		
		       	 } else if (yeta1000VO.getCreFile().equals("Y0090003")) {
		       		 //기부금지급명세서 
		       		state = fnYeta1400_ReTax_Yeta3180_Create(yeta1000VO,  response) ;
		           
		 
		//	          if state = 0 then
		//	          begin
		//	            ShowMessage('기부금지급명세서 파일생성이 완료되었습니다.');
		//	          end;
		       	 }  
                 
		       	 sResult = "success";
                      
        } catch(Exception ex) {
        	ex.printStackTrace(); 
        	sResult = "error";
        } 
   
        response.sendRedirect(sResult);
        return sResult;
 
    }  
   

   /**
    *  
    * <pre>
    * 1. 개요 : 근로소득원천징수영수증 처리  
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : fnYeta1400_ReTax_Payr3000_Create
    * @date : Feb 11, 2016
    * @author : leeheuisung
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	Feb 11, 2016		leeheuisung				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @param yeta1000Vo
    */
  private int fnYeta1400_ReTax_Payr3000_Create(InfcPkgYeta1000VO yeta1000Vo,HttpServletResponse response) throws Exception  {
 	  
	 int state = 0;
	  
 	String DEFIN = "";
    String defBUNS_LINS = "";
    String A_Record  = "";
    String B_Record  = "";
    String C_Record  = "";
    String D_Record  = "";
    String E_Record  = "";
    String F_Record  = "";
    String G_Record  = "";
    ArrayList<String> TOT_Record = new ArrayList<String>();
    
    int B_Cnt = 0;
    int C_Cnt = 0;
    int D_Cnt = 0;
    int E_Cnt = 0;
    int F_Cnt = 0;
    int G_Cnt = 0;
    int E_RowCnt = 0;
    int F_RowCnt = 0;
    int G_RowCnt = 0;   
    String RSNOSTR = "";
    String E_RecStr = "";
    String F_RecStr = "";
    String G_RecStr = "";
    String B_RecStr = ""; 
    String C_RecStr = "";
    String D_RecStr = "";
    Long mTempData01 = 0L;
    Long mTempData02 = 0L;

    // ==== 주의 ====
    // PChar타입이 유니코드 문자열을 의미하는
    // 델파이 2009부터는 PChar 대신 PAnsiChar 를 사용하십시오.
//    ret : LongInt;
//    hWnd : LongWord;
//    pszInputFilePath : PChar;
//    pszOutputFilePath : PChar;
//    pszPassword : PChar;
//    option : LongInt;
//
//    mStream: TMemoryStream;
//
//    resultString : string;
  
  //{근로소득지급명세서}
	   /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
	    // 1. 암호화 객체 생성
	     String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
	     /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/   

        DEFIN = "C"; //근로소득
        defBUNS_LINS = StringUtils.replace(yeta1000Vo.getBusiNumb(),"-","");   //사업자번호
      
        InfcPkgYeta1000VO infcPkgYeta1000Vo = new InfcPkgYeta1000VO();

         A_Record = ("A" + "20" + yeta1000Vo.getTaxaCode() + String.format("%08d", Long.parseLong(StringUtils.replace(yeta1000Vo.getEdacPrdt(),"-","")))
                       + String.format("%01d", Long.parseLong( yeta1000Vo.getIncmGbcd() ))   + String.format("%-6s", MSFSharedUtils.defaultNulls(yeta1000Vo.getTaxaDnum(),"")) 
                       +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(yeta1000Vo.getHomeTxid() ,20),20," ")  
                       +  String.format("%-4s", yeta1000Vo.getTaxaPrcd()) 
                       +  String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""))
                       +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(yeta1000Vo.getJuriName() ,38),40," ")  
                       +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(yeta1000Vo.getCharDept() ,28),30," ") 
                       +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(yeta1000Vo.getCharName(),28),30," ")    
                       +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(yeta1000Vo.getCharTele() ,15),15," ")  
                       +  String.format("%05d", 1) + "101"
                       +  String.format("%1442s", ""));

        TOT_Record.add(A_Record);

        B_Cnt = 1;
        mTempData01 = 0L;
        
      try {

      
    	  Map mapYetaB = yeta1400PayrService.fnPayrB_ReTax_Total_Select(yeta1000Vo); 

    	  if (mapYetaB.isEmpty()) { 
//           showMessage('B레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.');
//           Result = -1;
//           Exit;
    	  }
    	  
    	  
     	   if (!"2".equals(MSFSharedUtils.defaultNulls(yeta1000Vo.getIncmGbcd(),""))) {

    	//  if (MSFSharedUtils.paramNull(StringUtils.replace(yeta1000Vo.getJuriNumb(),"-","")) || StringUtils.replace(yeta1000Vo.getJuriNumb(),"-","").equals("null")) {

    	   	//  RSNOSTR = StringUtils.replace(yeta1000Vo.getResuNumb(),"-","");    //사업자주민번호 
    		// 주민번호(복호화)
    		String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(yeta1000Vo.getResuNumb()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
    		          	 
    		RSNOSTR	  = rrnDecCrypt;
            
           }
           else
           {
              RSNOSTR =  StringUtils.replace(yeta1000Vo.getJuriNumb(),"-","");   //법인번호
           }
    	  
          B_RecStr = "";
          mTempData01 = 0L ;
 

              B_RecStr = "B" + "20" + yeta1000Vo.getTaxaCode() +  String.format("%06d", B_Cnt)   +   String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""))
                           + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(yeta1000Vo.getJuriName() ,38),40," ")  
                           + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(yeta1000Vo.getReprName() ,28),30," ")  
                           + String.format("%-13s", StringUtils.replace(RSNOSTR,"-",""))  ;
                            mTempData01 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("psnlJuCnt"),"0"));
              B_RecStr =  B_RecStr  +  String.format("%07d", mTempData01);    //주근무지 레코드 수 
                            mTempData01 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("psnlJungCnt"),"0"));  
              B_RecStr =  B_RecStr + String.format("%07d", mTempData01);     //종전근무지 레코드 수 

              mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("totlSala"),"0")); 
              B_RecStr =  B_RecStr + String.format("%014d", mTempData01);   //총급여 총계_현전
              mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("dcsnIncm"),"0"));  
              B_RecStr =  B_RecStr   +  String.format("%013d", mTempData01);    //결정세액 소득세 
            //  mTempData01 =  oraQrySelect01.FieldByName('GONG_TEMP01').AsFloat;
            //  B_RecStr =  B_RecStr  + FormatFloat('0000000000000', mTempData01);
              mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("desnInhb"),"0"));    
              B_RecStr =  B_RecStr  + String.format("%013d", mTempData01);   //결정세액 지방소득세
              mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("dcsnFafv"),"0"));  
              B_RecStr =  B_RecStr   + String.format("%013d", mTempData01);    //결정세액 농특세
              mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("dcsnTotl"),"0")); 
              B_RecStr =  B_RecStr  + String.format("%013d", mTempData01);    //결정세액 총계
              B_RecStr =  B_RecStr  + "1"; //체출기간 연간합산제출등 코드로 등록하여 처리 하게 수정 필요 
              B_RecStr =  B_RecStr +  String.format("%1434s", "");     //공란 
               
              TOT_Record.add(B_RecStr);

              C_Cnt =  1;
           
            //c레코드 주현근무처 레코드 fnPayrC_ReTax_Total_Select
           List listYetaC = yeta1400PayrService.fnPayrC_ReTax_Total_Select(yeta1000Vo);
            
     	  if (listYetaC.size() <= 0) {  
     		  throw new Exception("C레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.");  
     	  } 

     	  Iterator<Map<String, Object>> iter = listYetaC.iterator(); 
    	   
          while ( iter.hasNext() ) { 
           	
           Map<String, Object> mapYetaC = (Map<String, Object>) iter.next();  
               
               mTempData02 = 0L;
               C_RecStr = "";
               //  oraQrySelect01.FieldByName('CITY_SEQN').AsString; Format('%.11d', [])
                             C_RecStr = "C" ;   //레코드구분
                             C_RecStr = C_RecStr + "20"; //자료구분 
                             C_RecStr = C_RecStr   + yeta1000Vo.getTaxaCode(); //세무서코드 
                             C_RecStr = C_RecStr + String.format("%06d", C_Cnt);    //원천징수읨주별로 1부터 순차부여 
                             C_RecStr = C_RecStr  +  String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""));  //사업자등록번호 
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("befoScnt"),"0"));             /*  종전근무처수 */    
                             C_RecStr = C_RecStr  + String.format("%02d",mTempData02);
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("resdFlag"),"1"));        //거주자구분코드
                             C_RecStr = C_RecStr  + String.format("%01d", mTempData02);
                             C_RecStr = C_RecStr  + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaC.get("redtGbcd"),"")  );    //거주지국코드
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("frnrSgyn"),"2"));                        //단일세율적용여부
                             C_RecStr = C_RecStr  + String.format("%01d", mTempData02) ;
                             //2016귀속 추가 ㄴ
                             C_RecStr = C_RecStr  + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("frnrRnyn"),"2")  );    //외국법인소속 파견근로자여부 
                             
                             C_RecStr = C_RecStr  + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaC.get("kornName"),"") ,28),30," ") ;    //성명
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("frnrYeno"),"1"));                                 //내외국인구부노드
                             C_RecStr = C_RecStr  +  String.format("%01d",  mTempData02) ;
                             
                          // 주민번호(복호화)
             				String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaC.get("resnRegnNum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
             		          	 
                             C_RecStr = C_RecStr  + String.format("%-13s",rrnDecCrypt);     //주민등록번호
                             
                             
                             C_RecStr = C_RecStr  + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaC.get("natnNbcd"),"") );       //국적코드
                             C_RecStr = C_RecStr  + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("gnanSgtf"),"") );       //세대주구분코드
                             C_RecStr = C_RecStr   + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("hoofStcd"),"")) ;       //연말정산구분 계속근로,중도퇴사
                             C_RecStr = C_RecStr   + String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-","")) ;            //주현근무처-사업자등록번호
                             C_RecStr = C_RecStr   + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(yeta1000Vo.getJuriName() ,38),40," ") ;                                     //주현근무처-근무처명
                         
                            
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("reymStdt"),"0"));                                  //근무기간시작연월일
                            C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("reymEddt"),"0"));                                 //근무기간 종료일자
                            C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("rutrStdt"),"0"));                                  //감면기간시작일자
                             C_RecStr = C_RecStr  +  String.format("%08d",  mTempData02) ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("rutrEddt"),"0"));                                    //감면기간종료일자
                             C_RecStr = C_RecStr  +  String.format("%08d", mTempData02);
                             mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTamt"),"0"));                                 //급여총액
                             C_RecStr = C_RecStr  + String.format("%011d", mTempData02);
                             mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("bonsToam"),"0"));                                   //상여총액
                             C_RecStr = C_RecStr  + String.format("%011d",  mTempData02);
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dtmnBsam"),"0"));                               //인정상여
                             C_RecStr = C_RecStr  + String.format("%011d",  mTempData02);
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("stckPrft"),"0"));                                //주식행사이익
                             C_RecStr = C_RecStr  + String.format("%011d",  mTempData02) ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp26"),"0"));                               //우리사주조합인출금
                            C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp27"),"0"));                                 //임원 퇴직소득금액 한도초과액
                            C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);

                             C_RecStr = C_RecStr  + "000000000000000000000";
                            C_RecStr = C_RecStr   +  String.format("%011d", Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaC.get("currTots"),"0"))) ;                    //계
               
                            //주현근무처 비과세소득 및 감면소득  
                     //       mTempData02 = oraQrySelect02.FieldByName('PAYR_TEMP29').AsFloat;
                     //       C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSg01"),"0"));  
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh01"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh05"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh06"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh07"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh08"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh09"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh10"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh14"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh15"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh11"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh12"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh13"),"0"));  
                           C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;
                           mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh16"),"0"));  
                           C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;
                           mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSi01"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSk01"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm01"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm02"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm03"),"0"));  
                             C_RecStr = C_RecStr  +  String.format("%010d",  mTempData02) ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSo01"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d", mTempData02)  ;
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSq01"),"0")); 
                             C_RecStr = C_RecStr  +  String.format("%010d", mTempData02) ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSr10"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSs01"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt01"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy02"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy03"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            //2016년 귀속 추가 
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy04"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy21"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy22"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt10"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            
                            //2016년귀속 추가 
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt11"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt12"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            
                            
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt20"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp60"),"0"));    //비과세계
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp61"),"0"));   //감면소득계
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                
                          //  C_RecStr = C_RecStr   + "0000000000";//공란 0으로 10자리       
                            
                            //정산명세 처리 시작    
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("totlSala"),"0"));         /*(16 합계)(21)번  column 총급여_현_전 : TOTL_SALA */          
                            C_RecStr = C_RecStr   +  String.format("%011d", mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("wkerDdct"),"0"));    /* (22) column 근로소득공제 : WKER_DDCT */    
                            C_RecStr = C_RecStr   +  String.format("%010d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("wkerAmnt"),"0"));      /*(23) column 근로소득금액 : WKER_AMNT */  
                            C_RecStr = C_RecStr   +  String.format("%011d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("baseSelf"),"0"));  /*(24) column 기본공제_본인 : BASE_SELF */         
                            C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("baseWife"),"0")); /*(25) column 기본공제_배우자 : BASE_WIFE */         
                            C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("baseFmly"),"0"));   /*(26) column 기본공제_부양가족수 : BASE_FMLY */  
                            C_RecStr = C_RecStr   + String.format("%02d", mTempData02) ;
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("baseFyam"),"0"));   /*(26) column 기본공제_부양가족 : BASE_FYAM */     
                            C_RecStr = C_RecStr   + String.format("%08d",mTempData02)  ;
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrCt70"),"0"));  /*(70) column 추가공제_경로우대_70세이상수 : ADDR_CT70 경로우대공제인원 */       
                            C_RecStr = C_RecStr   + String.format("%02d",mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrRpt70"),"0"));  /*(27) column 추가공제_경로우대70 : ADDR_RPT70 1946.12.31 */   
                            C_RecStr = C_RecStr   + String.format("%08d", mTempData02) ;
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrHdrc"),"0"));  /*(28) column 추가공제_장애인수 : ADDR_HDRC */    
                            C_RecStr = C_RecStr   + String.format("%02d",mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrHdam"),"0"));   /*(28) column 추가공제_장애인 금액 : ADDR_HDAM */     
                            C_RecStr = C_RecStr   + String.format("%08d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrFame"),"0")); /*(29) column 추가공제_부녀자  금액 : ADDR_FAME */      
                            C_RecStr = C_RecStr   + String.format("%08d", mTempData02);


                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("pantOnam"),"0"));   /*(30) column 추가공제_한부모공제금액 : PANT_ONAM */         
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
 
                            //연금보험료공제 
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jbnatDdct"),"0"));    /*(31) column_국민연금보험료공제 : JNAT_DDCT */       
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jpssHpul"),"0"));    /*(32)-가 column  _공무원연금보험료공제 : JPSS_HPUL */   
                            C_RecStr = C_RecStr  + String.format("%010d",  mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jpssHsol"),"0"));    /*(32)-나 column 주근무지_국민연금외군인연금공제 : JPSS_HSOL */  
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jpssHtec"),"0"));    /*(32)-다 column 주근무지_국민연금외교직원연금공제 : JPSS_HTEC */ 
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jbssDdct"),"0"));        /*(32)-라 column_별정우체국연금보험료공제 : JPSS_DDCT */   
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
                            
                        //  mTempData02 = oraQrySelect02.FieldByName('JRTR_HICT').AsFloat ;                //퇴직연금-과학기술인공제  ---
                        //  C_RecStr = C_RecStr  + FormatFloat('0000000000', mTempData02) ;
                        //  mTempData02 = oraQrySelect02.FieldByName('JBRTR_PSRN').AsFloat;                 //퇴직연금-근로자보장법  ----
                        //  C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02) ; 
                        //  mTempData02 = oraQrySelect02.FieldByName('JRTR_HNSV').AsFloat;                 //퇴직연금-연금저축  --------
                        //  C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02) ;

                            //특별소득공제 
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciJbhth"),"0"));   /*(33)-가 column 특별공제_주건강보험료 : SPCI_JHTH */   
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciJbepf"),"0"));    /*(33)-나 column 특별공제_주고용보험료 : SPCI_JEPF */   
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
                         //   mTempData02 = oraQrySelect02.FieldByName('SPCI_GURT').AsFloat ;                  //일반보장성보험료
                         //   C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
                         //   mTempData02 = oraQrySelect02.FieldByName('SPCI_HDRC').AsFloat;                   //장애인전용보험료
                         //   C_RecStr = C_RecStr  + FormatFloat('0000000000', mTempData02);
                         //  mTempData02 = oraQrySelect02.FieldByName('SPCI_HBPS').AsFloat ;                  //의료비공제금액_장애인
                         //  C_RecStr = C_RecStr  + FormatFloat('0000000000', mTempData02) ;
                         //   mTempData02 = oraQrySelect02.FieldByName('SPCI_METO').AsFloat ;                  //의료비공제금액
                         //  C_RecStr = C_RecStr  + FormatFloat('0000000000', mTempData02) ;
                         //  mTempData02 = oraQrySelect02.FieldByName('SPCI_SPEC').AsFloat ;                  //교육비공제금액_장애인
                         //  C_RecStr = C_RecStr   + FormatFloat('00000000', mTempData02)  ;
                         //   mTempData02 = oraQrySelect02.FieldByName('SPED_TOAM').AsFloat ;                  //교육비공제금액
                         //   C_RecStr = C_RecStr   + FormatFloat('00000000', mTempData02)  ;

                            
                           // 주택자금(주택임차차입금,장기주택저당차입금,주택마련저축) 관련공통사항 
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciRefn"),"0"));            /*(34)-가 column 특별공제_차입금원리금상환액_대출기관 : SPCI_REFN */   
                            C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciResf"),"0"));               /*(34)-가 column 특별공제_차입금원리금상환액_거주자 : SPCI_RESF */ 
                            C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ; 
                            
                           // mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("befoScnt"),"0")); oraQrySelect02.FieldByName('SPCI_HTAM').AsFloat ;                   //주택자금-월세액 대상금액
                           // C_RecStr = C_RecStr   + FormatFloat('00000000', mTempData02); 
                                                       
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spchRe15"),"0"));    /*(34)-나 column 특별공제_11장기주택저당차입금15 : SPCH_RE15 */  
                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spchRe29"),"0"));      /*(34)-나 column 특별공제_11장기주택저당차입금29 : SPCH_RE29 */   
                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spchRe30"),"0"));      /* (34)-나column 특별공제_11장기주택저당차입금30 : SPCH_RE30 */   
                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02); 
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciRefx"),"0"));     /*(34)-나 column 특별공제_12장기주택저당차입금_고정 : SPCI_REFX */     
                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciReec"),"0"));    /*(34)나 column 특별공제_12장기주택저당차입금_기타 : SPCI_REEC */
                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
                            
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spci15fx"),"0"));   /*(34)-나 column 특별공제_15장기주택저당_15고정AND비거치상환 : SPCI_15FX */
                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spci15fb"),"0"));     /*(34)-나 column 특별공제_15장기주택저당_15고정OR비거치상환 : SPCI_15FB */
                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spci15ec"),"0"));     /*(34)-나 column 특별공제_15장기주택저당_15기타대출 : SPCI_15EC */
                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spci10fb"),"0"));      /*(34)-나 column 특별공제_15장기주택저당_10고정OR비거치상환 : SPCI_10FB */
                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
 
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciSsum"),"0"));     /*(35) column 이월분  특별공제_기부금공제액계 : SPCI_SSUM */    
                            C_RecStr = C_RecStr   + String.format("%011d", mTempData02);

                            // mTempData02 = oraQrySelect02.FieldByName('SPCI_PLTC').AsFloat ;                  //기부금공제금액 _정치
                           // C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
                           //  mTempData02 = oraQrySelect02.FieldByName('SPCI_FBAM').AsFloat ;                  //기부금공제금액_법정
                           // C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
                          //   mTempData02 = oraQrySelect02.FieldByName('SPCI_RFAM').AsFloat ;                  //기부금공제금액_우리사주조합기부금
                           // C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
                           //  mTempData02 = oraQrySelect02.FieldByName('SPCI_NYAM').AsFloat ;                  //기부금공제금액_지정기부금
                          //  C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
                           // C_RecStr = C_RecStr   + "00000000000000000000" ;  //공란 

                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spsmTotl"),"0"));   /*96  (36)    //특별소득공제 계  */
                            C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);
                            //mTempData02 =  oraQrySelect02.FieldByName('SPCI_DDCT').AsFloat;                 //표준공제
                            //C_RecStr = C_RecStr  + FormatFloat('00000000', mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtEram"),"0"));       /* (97) column 차감소득금액 : SUBT_ERAM */  
                            C_RecStr = C_RecStr  + String.format("%011d", mTempData02);
                            
                            //그 밖의 소득공제  
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etcpPsnv"),"0"));     /* (98)column 개인연금저축불입액_2000년이전 : ETCP_PSNV */  
                            C_RecStr = C_RecStr   + String.format("%08d", mTempData02);
                       //     mTempData02 = oraQrySelect02.FieldByName('ETCP_NSAV').AsFloat;                 //연금저축소득공제
                        //    C_RecStr = C_RecStr  + FormatFloat('00000000', mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etchPrep"),"0"));    /* (99) column 기타공제_소기업공제불입금 : ETCH_PREP */    
                            C_RecStr = C_RecStr  + String.format("%010d", mTempData02);

                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etcsComp"),"0"));   /*(100)-가 column 기타공제_주택마련저축_청약저축 : ETCS_COMP */       
                            C_RecStr = C_RecStr  + String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etwkSbam"),"0"));    /* (101)-나column 기타공제_주택마련저축_주택청약종합저축 : ETWK_SBAM */       
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                          //  mTempData02 = oraQrySelect02.FieldByName('ETWK_LGAM').AsFloat ;                  //장기주택마련저축
                          //  C_RecStr = C_RecStr   + FormatFloat('0000000000',mTempData02) ;
                            mTempData02 =Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etwkSvam"),"0"));   /*(102)-다 column 기타공제_주택마련저축_근로자주택마련저축 : ETWK_SVAM */
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etgdDdam"),"0"));        /* (103) column 기타공제_투자조합출자공제액 : ETGD_DDAM */   
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etccCard"),"0"));     /*(104) column 기타공제_신용카드등사용액소득공제 : ETCC_CARD */ 
                            C_RecStr = C_RecStr   + String.format("%08d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etckUnon"),"0"));       /*(105) column 기타공제_우리사주출연금공제 : ETCK_UNON */      
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);

                          //  mTempData02 = Long.parseLong("0");                  //우리사주조합기부금
                          //  C_RecStr = C_RecStr   + "00000000000";

                            //mTempData02 = oraQrySelect02.FieldByName('ETCL_HMTO').AsFloat  ;                 //장기주식형저축소득공제
                           // C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);

                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etepMsam"),"0"));       /*(45) column 기타공제_고용유지중소기업근로자임금삭감공제액 : ETEP_MSAM */ 
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);

                          //  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etgdHtra"),"0"));       /*(46) column 기타공제_목돈안드는전세이자상환소득공제액 : ETGD_HTRA */        
                            C_RecStr = C_RecStr   + "0000000000";                                                       //String.format("%010d",  mTempData02)  ;

                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etepSecr"),"0"));      /*(47) column 기타공제_장기집합투자증권저축공제액 : ETEP_SECR */  
                             C_RecStr = C_RecStr   + String.format("%010d",  mTempData02)  ;

                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etclTotl"),"0"));      /*(48) column 기타공제_공제계 : ETCD_TSUM */   
                            C_RecStr = C_RecStr  + String.format("%011d",  mTempData02);

                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spchExli"),"0"));     /*(49) column 특별공제_종합한도초과금액 : SPCH_EXLI */     
                            C_RecStr = C_RecStr   + String.format("%011d",  mTempData02) ;


                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("stndIncm"),"0"));     /*(50) column 종합소득과세표준 : STND_INCM */        
                            C_RecStr = C_RecStr   + String.format("%011d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("prddTaxn"),"0"));         /*(51) column 산출세액 : PRDD_TAXN */         
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;

                            //------------------------ 세액감면 ------------------------------ 
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdIcax"),"0"));     /*(52) column 세액감면_소득세법 : TAXD_ICAX */    
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdSpct"),"0"));     /*(53) column 세액감면_조세특례법 : TAXD_SPCT */        
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02)  ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("txlgCl30"),"0"));  /*(54) column 세액감면_조세특례법제30조 : TXLG_CL30 */   
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02)  ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("txlgHxtt"),"0"));    /*(55) column 세액감면_조세조약 : TXLG_HXTT */   
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
                         //   mTempData02 = oraQrySelect02.FieldByName('PAYR_TEMP126').AsFloat ;              // 공란
                         //   C_RecStr = C_RecStr   +  "0000000000"  ; 
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdTsum"),"0"));       /*(56) column 세액감면_감면세액계 : TAXD_TSUM */     
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);


                            // ------------------------ 세액공제 -------------------------------------------------------
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdWken"),"0"));      /*(57) column 세액공제_근로소득세액공제 : TAXD_WKEN */ 
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;

                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrMrct"),"0"));               //다자녀추가공제인원 -----
                             C_RecStr = C_RecStr   + String.format("%02d", mTempData02);
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrMccr"),"0"));         //자녀세액공제
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;


                       //     mTempData02 = oraQrySelect02.FieldByName('ADDR_MCAM').AsFloat;                 //다자녀추가공제금액 ------
                      //      C_RecStr = C_RecStr  + FormatFloat('00000000', mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrClct"),"0"));             //6세이하공제인원  -----
                            C_RecStr = C_RecStr   + String.format("%02d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrChld"),"0"));              //6세이하공제금액 -------
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrBhct"),"0"));              //출산입양자공제인원 --------
                            C_RecStr = C_RecStr   + String.format("%02d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrBrth"),"0"));            // 출산입양자공제금액 ---------
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;



                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrCtar"),"0"));                  //연금계좌_과학기술인공제_공제대상금액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrHict"),"0"));                  //연금계좌_과학기술인공제_세액공제액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrPtar"),"0"));               //연금계좌_근로자퇴직 급여보장법에 따른 퇴직급여 공제대상금액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrPsrn"),"0"));                //연금계좌_근로자퇴직 급여보장법에 따른 퇴직급여 공제액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrAtar"),"0"));               //연금계좌_ 연금저축 공제대상금액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrHnsv"),"0"));              //연금계좌_연금저축 세액공제액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;

                            //mTempData02 = oraQrySelect02.FieldByName('SPCI_DETG').AsFloat ;                 //특별세액공제_보장성보험료_공제대상금액
                            //C_RecStr = C_RecStr   + FormatFloat('0000000000',mTempData02) ;
                            //mTempData02 = oraQrySelect02.FieldByName('SPCI_RTDE').AsFloat ;                 //특별세액공제_보장성보험효 세액공제액
                            //C_RecStr = C_RecStr   + FormatFloat('0000000000',mTempData02) ;

                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciRttg"),"0"));                //특별세액공제_보장성보험료_공제대상금액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciGurt"),"0"));               // //특별공제_일반보장성보험료 세액공제액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciHdtg"),"0"));              //특별공제_장애인보장성대상금액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciHdrc"),"0"));                  //특특별공제_장애인보장성보험료 세액공제액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;


                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciDtar"),"0"));                 //특별세액공제_의료비_공제대상금액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciTxcr"),"0"));               //특별세액공제_의료비_세액공제액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spedEtar"),"0"));                 //특별세액공제_교육비_공제대상금액SPED_SFTR
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spedTxcr"),"0"));                 //특별세액공제_교육비_세액공제
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxd10tg"),"0"));                //특별세액공제_기부금_정치자금_10만원이하 공제 대상금액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;

                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdPltc"),"0"));                  //특별세액공제_기부금_정치자금_10만원이하 공제
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciPltg"),"0"));                   //특별세액공제_기부금_정치자금_10만원초과  공제 대상금액
                            C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciPltc"),"0"));                 //특별세액공제_기부금_정치자금_10만원초과  공제
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciFbtg"),"0"));                 //특별세액공제_기부금_법정기부금 공제 대상금액
                            C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciFbam"),"0"));                 //특별세액공제_기부금_법정기부금 공제
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciHftg"),"0"));   /* (65)-다column 우리사주종합기부대상금액 : SPCI_HFTG */
                            C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spcirfam"),"0"));    /*(65)-다 column 특별공제_기부금_우리사주조합세액공제액 : SPCI_RFAM */
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                             

                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciNatg"),"0"));                /*(65)-라 column  2014년이후 기부금합게 종교단체외지정대상금액 : SPCI_NATG */
                            C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciNamt"),"0"));                 /*(65)-라 column 특별공제_기부금_특별공제_기부금_종교단체외 : SPCI_NAMT */
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            
                            
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciYatg"),"0"));                 /*(65)-라 column  2014년이후 기부금합게 종교단체지정대상금액 : SPCI_YATG */
                            C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ; 
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciYamt"),"0"));                /*(65)-라 column 특별공제_기부금_특별공제_기부금_종교단체 : SPCI_YAMT */
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                          
                            
                            
                        //     mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciNyag"),"0"));                 //특별세액공제_기부금_지정기부금 공제대상금액
                        //    C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
                        //     mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciNyam"),"0"));                 //특별세액공제_기부금 지정기부금 세액
                        //    C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                           
                            
                           // SPCI_NATG	종교단체외지정대상금액	 
                           // SPCI_YATG	종교단체지정대상금액	 
                            
                            
                            
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciDcto"),"0"));                 //특별세액공제 계
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciDdct"),"0"));              //표준 세액 공제
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;




                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdUnin"),"0"));               //납세조합공제
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdLoan"),"0"));              //주택차입금
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
                         //   mTempData02 = oraQrySelect02.FieldByName('TAXD_PLTC').AsFloat ;                  //기부정치자금
                          //  C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdPaid"),"0"));               //외국납부
                            C_RecStr = C_RecStr  + String.format("%010d",  mTempData02) ;
                            
                            
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciTgrt"),"0"));     /*(71) column 특별공제_월세세액공제대상금액 : SPCI_TGRT */ 
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;        
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciRtam"),"0"));            //    월세 세액 공제
                            C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdCsum"),"0"));               //세액공제계
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;

                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dcsnIncm"),"0"));               //소득세
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dcsnInhb"),"0"));                //지방소득세
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dcsnFafv"),"0"));                  //농특세
                            C_RecStr = C_RecStr    + String.format("%010d", mTempData02);
                         //   mTempData02 = oraQrySelect02.FieldByName('DCSN_TOTL').AsFloat;                  //합계
                         //   C_RecStr = C_RecStr    + FormatFloat('0000000000', mTempData02) ;
                            
                            //기납부세액 - 주현근무지  
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("alryPinx"),"0"));       //기납부소득세
                            C_RecStr = C_RecStr    + String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("alryPhbx"),"0"));                  //기납부지방소득세
                            C_RecStr = C_RecStr    + String.format("%010d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("alryYvtx"),"0"));               //기납부농특세
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);

                            
                            //계산에 의해처리 해야 함......todo 
                             C_RecStr = C_RecStr   +  "0000000000"  ;          //납부특례세액 _소득세
                             C_RecStr = C_RecStr   +  "0000000000"  ;            //납부특례세액 _지방소득세
                             C_RecStr = C_RecStr   +  "0000000000"  ;           //납부특례세액 _농특세 


                         //   mTempData02 = oraQrySelect02.FieldByName('ALRY_TOTL').AsFloat ;
                         //   C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtEtaxb"),"0"));           //소득세음양
                            C_RecStr = C_RecStr   + String.format("%01d",  mTempData02)  ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtEtax"),"0"));        //소득세
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtInhbb"),"0"));          //지방소득세음양
                            C_RecStr = C_RecStr  + String.format("%01d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtInhb"),"0"));          //지방소득세
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtFafvb"),"0"));           //농특세음양
                            C_RecStr = C_RecStr   + String.format("%01d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtFafv"),"0"));              //농특세
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
                         //   mTempData02 = oraQrySelect02.FieldByName('SUBT_AMSUB').AsFloat ;
                        //    C_RecStr = C_RecStr   + FormatFloat('0', mTempData02);
                         //   mTempData02 = oraQrySelect02.FieldByName('SUBT_AMSU').AsFloat;
                        //    C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
                            C_RecStr = C_RecStr   + String.format("%-15s", "") ;
                             
              
               TOT_Record.add(C_RecStr);

               D_Cnt = 1; 
               
               //fnPayrD_ReTax_Total_Select
               yeta1000Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
               
               List listYetaD = yeta1400PayrService.fnPayrD_ReTax_Total_Select(yeta1000Vo);
               
          	 
 
               if (listYetaD.size() > 0) { 

              	  Iterator<Map<String, Object>> iter01 = listYetaD.iterator(); 
             	   
                   while ( iter01.hasNext() ) { 
                    	
                     Map<String, Object> mapYetaD = (Map<String, Object>) iter01.next(); 
                     
                     mTempData02 = 0L;
                     D_RecStr = "";
                     D_RecStr = "D" + "20" + yeta1000Vo.getTaxaCode();
                                 D_RecStr = D_RecStr +   String.format("%06d", C_Cnt);  
                                 D_RecStr = D_RecStr +  String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""));
                                 D_RecStr = D_RecStr + String.format("%50s", "")  + String.format("%-13s", StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnRegnNum"),""),"-",""));
                            
                                 //근무처별 소득 명세 - 종전근무처 
                                 D_RecStr = D_RecStr + "2" ;  //todo 납세조합구분자 필요 
                                 D_RecStr = D_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaD.get("siteCtnt"),"") ,38),40," ") ;
                                 D_RecStr = D_RecStr + String.format("%-10s", MSFSharedUtils.defaultNulls(mapYetaD.get("siteNumb"),""))  ;
                                 D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("jeymStdt"),"0"))); 
                                 D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("jeymEddt"),"0"))); 
                                 D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("jutrStdt"),"0"))); 
                                 D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("jutrEddt"),"0"))); 
                               
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("payrTotl"),"0"));  
                                 D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("bonsAmnt"),"0")); 
                                 D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("dtmnBtam"),"0")); 
                                 D_RecStr = D_RecStr +  String.format("%011d", mTempData02);
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("stckPrft"),"0")); 
                                 D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("unonAmnt"),"0")); 
                                 D_RecStr = D_RecStr +  String.format("%011d",mTempData02);

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("ofrrExli"),"0")); 
                                 D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
 
                                 D_RecStr = D_RecStr + "0000000000000000000000" ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("payrBtot"),"0")); 
                                 D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
                                  
                                 //종전근무지 비과세소득 및 감면소득  
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSg01"),"0"));  
                                 C_RecStr = C_RecStr   + String.format("%010d", mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh01"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh05"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh06"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh07"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh08"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh09"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh10"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh14"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh15"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh11"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh12"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh13"),"0"));  
                                C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;
                                mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh16"),"0"));  
                                C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;
                                mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSi01"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSk01"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm01"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm02"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm03"),"0"));  
                                  C_RecStr = C_RecStr  +  String.format("%010d",  mTempData02) ;
                                  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSo01"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d", mTempData02)  ;
                                 mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSq01"),"0")); 
                                  C_RecStr = C_RecStr  +  String.format("%010d", mTempData02) ;
                                  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSr10"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSs01"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt01"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy02"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy03"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy04"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy21"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy22"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt10"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt11"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt12"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 
                                 
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt20"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp51"),"0"));    //비과세계
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp52"),"0"));   //감면소득계
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                     

                                // mTempData02 = oLong.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("JUTR_EDDT"),"0"));raQrySelect03.FieldByName('TAXE_TOTL').AsFloat ;
                              //   D_RecStr = D_RecStr +  FormatFloat('0000000000', mTempData02);
                                //  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("JUTR_EDDT"),"0"));oraQrySelect03.FieldByName('PAYR_TEMP55').AsFloat ;
                                 D_RecStr = D_RecStr + "0000000000";
                                 
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("EARN_TAXN"),"0")); 
                                 D_RecStr = D_RecStr +  String.format("%010d", mTempData02);
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("IHTX_TAXN"),"0")); 
                                 D_RecStr = D_RecStr +  String.format("%010d", mTempData02);
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("FARM_TAXN"),"0")); 
                                 D_RecStr = D_RecStr +  String.format("%010d", mTempData02);
                                // mTempData02 =  oraQrySelect03.FieldByName('FARM_BTOT').AsFloat ;
                               //  D_RecStr = D_RecStr  +  FormatFloat('0000000000',mTempData02);
                                 D_RecStr = D_RecStr +  String.format("%02d",  D_Cnt);
                                 D_RecStr = D_RecStr + String.format("%961s", ""); 
 
                     
                      TOT_Record.add(D_RecStr);

                    
                    D_Cnt = D_Cnt + 1;
                   }
               }

               //E레코드
               E_Cnt = 1;
               E_RowCnt = 1;
               E_RecStr = "";

              yeta1000Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
               
               List listYetaE = yeta1400PayrService.fnPayrE_ReTax_Total_Select(yeta1000Vo);
               
          	 
 
               if ( listYetaE.size() > 0) { 

              	  Iterator<Map<String, Object>> iter03 = listYetaE.iterator(); 
             	   
                   while ( iter03.hasNext() ) { 
                    	
                     Map<String, Object> mapYetaE = (Map<String, Object>) iter03.next(); 
                     
               
                      mTempData02 = 0L;
                      
                   // 주민번호(복호화)
      				 rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaC.get("resnRegnNum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
      		          	 
                      
                      E_RecStr =  "E" + "20" + yeta1000Vo.getTaxaCode() +  String.format("%06d", C_Cnt)
                                 +  String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""))
                                 + String.format("%-13s", StringUtils.replace(rrnDecCrypt,"-",""));

                 if (listYetaE.size() + 1 > E_RowCnt)  {

                          // E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  
                      
                      /** (CASE WHEN YETA3220.RELH_CODE IN ('A0190001')  THEN 0       
				           WHEN YETA3220.RELH_CODE IN ('A0190003','A0190004','A0190009','A0190010','A0190017','A0190018','A0190019','A0190053','A0190054','A0190055','A0190056','A0190051','A0190050','A0190078','A0190079')  THEN 1  
				           WHEN YETA3220.RELH_CODE IN ('A0190011','A0190012','A0190013')  THEN 2                                                                                         
				           WHEN YETA3220.RELH_CODE IN ('A0190002','A0190007')  THEN 3                                                                                                                          
				           WHEN YETA3220.RELH_CODE IN ('A0190005')  THEN 4   
				           WHEN YETA3220.RELH_CODE IN ('A0190040','A0190032','A0190099','A0190076' ,'A0190100')  THEN 5                                                                                                                         
				           WHEN YETA3220.RELH_CODE IN ('A0190038','A0190022','A0190021','A0190020','A0190023','A0190025','A0190033','A0190035','A0190037','A0190051','A0190052','A0190089','A0190053','A0190090','A0190091','A0190032')  THEN 6            
				           WHEN YETA3220.RELH_CODE IN ('A0190109')  THEN 7                            
				           WHEN YETA3220.RELH_CODE IN ('A0190100')  THEN 8  END )  AS RELH_CODE,  */
                      
                                  E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드 
                                  E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," "); 
                                  E_RecStr = E_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")   ;
                               
                               // 주민번호(복호화)
                  				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                  		          	 
                                  E_RecStr = E_RecStr+ rrnDecCrypt;  
                                  
                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  

                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  

                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  

                                  //소득공제국세청자료 
                                  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;

                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;


                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
                                  E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;

                                  //소득공제자료 기타자료 
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
                                  E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                    mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;


                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
                                  E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;


                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
                                   E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                    mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
                                  E_RecStr = E_RecStr+   String.format("%013d",mTempData02);
                                
                                  E_RowCnt =  E_RowCnt + 1;
                                 try {
                                	  mapYetaE = (Map<String, Object>) iter03.next(); 
                              	 } catch (NoSuchElementException e) {
                              		//e.printStackTrace();
                              	 }   

                 }
                 else
                 {
                       E_RecStr = E_RecStr + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%20s","")
                                  + String.format("%13s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000000";
 
                        E_RowCnt =  E_RowCnt + 1;
                 }
                 
                 if (listYetaE.size() + 1 > E_RowCnt)  {

                  //   E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," "); 
                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드 
                                 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," ");   
                                 E_RecStr = E_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")  ;
                                
                                 // 주민번호(복호화)
                 				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                 		          	 
                 				  
                                 E_RecStr = E_RecStr+ rrnDecCrypt;  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  

                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  

                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  

                                 mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;


                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
                                 E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;


                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;


                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
                                 E_RecStr = E_RecStr+   String.format("%013d",mTempData02);
                                 E_RowCnt =  E_RowCnt + 1;
                                 try {
                               	  mapYetaE = (Map<String, Object>) iter03.next(); 
                             	 } catch (NoSuchElementException e) {
                             		//e.printStackTrace();
                             	 }     
                     

                }
                else
                {
                      E_RecStr = E_RecStr + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%20s","")
                                 + String.format("%13s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000000";

                       E_RowCnt =  E_RowCnt + 1;
                }

                 if (listYetaE.size() + 1 > E_RowCnt)  {

                     //E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  
                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드   
                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," ");   
                                 E_RecStr = E_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")  ;
                               
                                 // 주민번호(복호화)
                				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                		          
                				  
                                 E_RecStr = E_RecStr+ rrnDecCrypt;  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  

                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  

                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  

                                 mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;


                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
                                 E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;


                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;


                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
                                 E_RecStr = E_RecStr+   String.format("%013d",mTempData02);
                                 E_RowCnt =  E_RowCnt + 1;
                                 try {
                               	  mapYetaE = (Map<String, Object>) iter03.next(); 
                             	 } catch (NoSuchElementException e) {
                             		//e.printStackTrace();
                             	 }     
                       

                }
                else
                {
                      E_RecStr = E_RecStr + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%20s","")
                                 + String.format("%13s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000000";

                       E_RowCnt =  E_RowCnt + 1;
                }
                 if (listYetaE.size() + 1 > E_RowCnt)  {

                    // E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  
                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드  
                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," ");   
                                 E_RecStr = E_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")   ;
                                
                                 // 주민번호(복호화)
               				     rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
               		          
                                 E_RecStr = E_RecStr+ rrnDecCrypt;  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  

                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  

                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  

                                 mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;


                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
                                 E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;


                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;


                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
                                 E_RecStr = E_RecStr+   String.format("%013d",mTempData02);
                                 E_RowCnt =  E_RowCnt + 1;
                                 try {
                               	  mapYetaE = (Map<String, Object>) iter03.next(); 
                             	 } catch (NoSuchElementException e) {
                             		//e.printStackTrace();
                             	 }     
                     

                }
                else
                {
                      E_RecStr = E_RecStr + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%20s","")
                                 + String.format("%13s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000000";

                       E_RowCnt =  E_RowCnt + 1;
                }
                 
                 if (listYetaE.size() + 1 > E_RowCnt)  {

                   //  E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  
                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드 
                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," ");   
                                 E_RecStr = E_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")  ;
                               
                                 // 주민번호(복호화)
               				     rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
               		          
                                 
                                 E_RecStr = E_RecStr+ rrnDecCrypt;  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  

                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  

                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  

                                 mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;


                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
                                 E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;


                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;


                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
                                 E_RecStr = E_RecStr+   String.format("%013d",mTempData02);

//                                 try {
//                               	  mapYetaE = (Map<String, Object>) iter03.next(); 
//                             	 } catch (NoSuchElementException e) {
//                             		//e.printStackTrace();
//                             	 }      
                       E_RowCnt =  E_RowCnt + 1;

                }
                else
                {
                      E_RecStr = E_RecStr + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%20s","")
                                 + String.format("%13s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000000";

                       E_RowCnt =  E_RowCnt + 1;
                }
                 E_RecStr = E_RecStr +  String.format("%02d",  E_Cnt)
                                  + String.format("%293s", "") ;

                       TOT_Record.add(E_RecStr);

                       E_Cnt = E_Cnt + 1;
                       E_RecStr = ""; 

                   }
               }

              // F레코드  - 연금저축등 소득세액공제명세 레코드 

               F_Cnt = 1;
               F_RowCnt = 1;
               F_RecStr = "";
              
               yeta1000Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
               
               List listYetaF = yeta1400PayrService.fnPayrF_ReTax_Total_Select(yeta1000Vo);
                
 
               if ( listYetaF.size() > 0) { 

              	  Iterator<Map<String, Object>> iter04 = listYetaF.iterator(); 
             	   
                   while ( iter04.hasNext() ) { 
                    	
                     Map<String, Object> mapYetaF = (Map<String, Object>) iter04.next(); 
    
                    mTempData02 = 0L;

                 // 주민번호(복호화)
    				 rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnRegnNum"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
    		          	 
                   F_RecStr =  "F" + "20" + yeta1000Vo.getTaxaCode() +  String.format("%06d", C_Cnt) + String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""))
                                  + String.format("%-13s",rrnDecCrypt ) ;
 
                   
                 if (listYetaF.size() + 1 > F_RowCnt)  {
                  
                                F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                                   + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                                   + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                                   + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
                                   mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                                   F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                                   mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                                   F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


                          F_RowCnt =  F_RowCnt + 1;
                          
                          try {
                        	  mapYetaF = (Map<String, Object>) iter04.next(); 
                         	 } catch (NoSuchElementException e) {
                         		//e.printStackTrace();
                         	 }      
                          
                 }
                 else
                 {
                        F_RecStr = F_RecStr + String.format("%-2s","")
                                   + String.format("%-3s","")
                                   +  String.format("%-50s","")
                                   + String.format("%-20s","")
                                   +  "0000000000"
                                   +  "0000000000";

                        F_RowCnt =  F_RowCnt + 1;
                 }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                         + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                         + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                         + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                         + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                         + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                         + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                         + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                         + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                         + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
//               try {
//             	  mapYetaF = (Map<String, Object>) iter04.next(); 
//              	 } catch (NoSuchElementException e) {
//              		//e.printStackTrace();
//              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }


                 F_RecStr = F_RecStr + String.format("%-160s","");
                       TOT_Record.add(F_RecStr);


                       F_Cnt = F_Cnt + 1;

                       F_RecStr = "";  

                   }
               }


               //---------------------------------------------------------------------------------
               //G레코드 - 월세 거주간 주택임차 차입금 원리금 상환액 소득공제명세 레코드  
               //---------------------------------------------------------------------------------
               
               G_Cnt = 1;
               G_RowCnt = 1;
               G_RecStr = "";
               
               yeta1000Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
               
               List listYetaG = yeta1400PayrService.fnPayrG_ReTax_Total_Select(yeta1000Vo);
                
 
               if ( listYetaG.size() > 0) { 
 
              	   Iterator<Map<String, Object>> iter05 = listYetaG.iterator(); 
             	   
                   while ( iter05.hasNext() ) { 
                    	
                     Map<String, Object> mapYetaG = (Map<String, Object>) iter05.next(); 
                           
                    
                     if ((listYetaG.size() > 0) &&  (MSFSharedUtils.paramNotNull( mapYetaG.get("mnrnName")) 
                     ||  MSFSharedUtils.paramNotNull( mapYetaG.get("cnclName")) || MSFSharedUtils.paramNotNull( mapYetaG.get("leasName"))))  {
                     
                    	// 주민번호(복호화)
         				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnRegnNum"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
         		          	 
                       mTempData02 = 0L;

                       G_RecStr =  "G" + "20" + yeta1000Vo.getTaxaCode()  +  String.format("%06d", C_Cnt) +  String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""))
                                      + String.format("%-13s",rrnDecCrypt) ;

                       
                       if (listYetaG.size() + 1 > G_RowCnt)  {
                      
                    	// 주민번호(복호화)
          				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnRsno"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
          		          	 
                                    G_RecStr = G_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnName"),""),18),20," ")  
                                       +  String.format("%-13s", rrnDecCrypt);
                                   
                                       G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnTyhu"),"") );
                                       G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnArea"),"0.00")))),".","");     //소숫점처리

                                       G_RecStr = G_RecStr +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAddr"),"") ,98),100," ")  ;

                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnStdt"),"") ;
                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnEddt"),"") ;

                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAmnt"),"0"));  
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnDuam"),"0"));   
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;


                                        G_RecStr = G_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclName"),"") ,18),20," ") 
                                       + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRsno"),"") ) ;
                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclStdt"),"") ;
                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclEddt"),"")  ;

                                       G_RecStr = G_RecStr +  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItro"),"0.00")))),".","") ;     //소숫점처리

                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRdmt"),"0")); 
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
                                        mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclPrpl"),"0"));
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItrt"),"0"));
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclDuam"),"0"));
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02);


                                      G_RecStr = G_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("leasName"),"") ,18),20," ")  
                                       + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("leasRsno"),"")  );

                                       G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("leasTyhu"),"")   );
                                       G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("leasArea"),"0.00")))),".","")  ;     //소숫점처리

                                       G_RecStr = G_RecStr +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("leasAddr"),"") ,98),100," ") ;
                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasStdt"),"") ;
                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasEddt"),"")  ;

                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("leasDpst"),"0"));   
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02);

                              G_RowCnt =  G_RowCnt + 1;
                              try {
                            	  mapYetaG = (Map<String, Object>) iter05.next(); 
                             	 } catch (NoSuchElementException e) {
                             		//e.printStackTrace();
                             	 }     
                              
                       }
                     else
                     {
                            G_RecStr = G_RecStr + String.format("%-20s","")
                                       + String.format("%-13s","")
                                       + String.format("%-1s","")
                                       +  "00000"
                                       + String.format("%-100s","")
                                       +  "00000000"
                                       +  "00000000"
                                       +  "0000000000"
                                       +  "0000000000"
                                       + String.format("%-20s","")
                                       + String.format("%-13s","")
                                       +  "00000000"
                                       +  "00000000"
                                       +  "0000"
                                       +  "0000000000"
                                       +  "0000000000"
                                       +  "0000000000"
                                       +  "0000000000"
                                        + String.format("%-20s","")
                                       +  String.format("%-13s","")
                                       +  String.format("%-1s","")
                                       +  "00000"
                                       +  String.format("%-100s","")
                                       +  "00000000"
                                       +  "00000000"
                                       +  "0000000000";

                            G_RowCnt =  G_RowCnt + 1;
                     }
                       if (listYetaG.size() + 1 > G_RowCnt)  {
                           

                       	// 주민번호(복호화)
             				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnRsno"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
             		          	
             				  
                           G_RecStr = G_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnName"),"") ,18),20," ")   
                              +  String.format("%-13s",  rrnDecCrypt);

                              G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnTyhu"),"") );
                              G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnArea"),"0.00")))),".","");     //소숫점처리

                              G_RecStr = G_RecStr +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAddr"),"") ,98),100," ") ;

                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnStdt"),"") ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnEddt"),"") ;

                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAmnt"),"0"));  
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnDuam"),"0"));   
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;


                               G_RecStr = G_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("cnclName"),"") ,18),20," ")   
                              + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRsno"),"") ) ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclStdt"),"") ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclEddt"),"")  ;

                              G_RecStr = G_RecStr +  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItro"),"0.00")))),".","") ;     //소숫점처리

                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRdmt"),"0")); 
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
                               mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclPrpl"),"0"));
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItrt"),"0"));
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclDuam"),"0"));
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);


                             G_RecStr = G_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("leasName"),"") ,18),20," ")  
                              + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("leasRsno"),"")  );

                              G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("leasTyhu"),"")   );
                              G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("leasArea"),"0.00")))),".","")  ;     //소숫점처리

                              G_RecStr = G_RecStr +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("leasAddr"),"") ,98),100," ") ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasStdt"),"") ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasEddt"),"")  ;

                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("leasDpst"),"0"));   
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);

                     G_RowCnt =  G_RowCnt + 1;
                     try {
                   	  mapYetaG = (Map<String, Object>) iter05.next(); 
                    	 } catch (NoSuchElementException e) {
                    		//e.printStackTrace();
                    	 }     
              }
            else
            {
                   G_RecStr = G_RecStr + String.format("%-20s","")
                              + String.format("%-13s","")
                              + String.format("%-1s","")
                              +  "00000"
                              + String.format("%-100s","")
                              +  "00000000"
                              +  "00000000"
                              +  "0000000000"
                              +  "0000000000"
                              + String.format("%-20s","")
                              + String.format("%-13s","")
                              +  "00000000"
                              +  "00000000"
                              +  "0000"
                              +  "0000000000"
                              +  "0000000000"
                              +  "0000000000"
                              +  "0000000000"
                               + String.format("%-20s","")
                              +  String.format("%-13s","")
                              +  String.format("%-1s","")
                              +  "00000"
                              +  String.format("%-100s","")
                              +  "00000000"
                              +  "00000000"
                              +  "0000000000";

                   G_RowCnt =  G_RowCnt + 1;
            }
                       if (listYetaG.size() + 1 > G_RowCnt)  {
                           

                          	// 주민번호(복호화)
                				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnRsno"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                		          	
                				  
                           G_RecStr = G_RecStr +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnName"),"") ,18),20," ")  
                              +  String.format("%-13s",  rrnDecCrypt);

                              G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnTyhu"),"") );
                              G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnArea"),"0.00")))),".","");     //소숫점처리

                              G_RecStr = G_RecStr +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAddr"),"") ,98),100," ") ;

                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnStdt"),"") ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnEddt"),"") ;

                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAmnt"),"0"));  
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnDuam"),"0"));   
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;


                               G_RecStr = G_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclName"),"") ,18),20," ")  
                              + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRsno"),"") ) ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclStdt"),"") ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclEddt"),"")  ;

                              G_RecStr = G_RecStr +  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItro"),"0.00")))),".","") ;     //소숫점처리

                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRdmt"),"0")); 
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
                               mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclPrpl"),"0"));
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItrt"),"0"));
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclDuam"),"0"));
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);


                             G_RecStr = G_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("leasName"),""),18),20," ")  
                              + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("leasRsno"),"")  );

                              G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("leasTyhu"),"")   );
                              G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("leasArea"),"0.00")))),".","")  ;     //소숫점처리

                              G_RecStr = G_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("leasAddr"),""),98),100," ")  ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasStdt"),"") ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasEddt"),"")  ;

                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("leasDpst"),"0"));   
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);

                     G_RowCnt =  G_RowCnt + 1;
//                     try {
//                   	  mapYetaG = (Map<String, Object>) iter05.next(); 
//                    	 } catch (NoSuchElementException e) {
//                    		//e.printStackTrace();
//                    	 }     
              }
            else
            {
                   G_RecStr = G_RecStr + String.format("%-20s","")
                              + String.format("%-13s","")
                              + String.format("%-1s","")
                              +  "00000"
                              + String.format("%-100s","")
                              +  "00000000"
                              +  "00000000"
                              +  "0000000000"
                              +  "0000000000"
                              + String.format("%-20s","")
                              + String.format("%-13s","")
                              +  "00000000"
                              +  "00000000"
                              +  "0000"
                              +  "0000000000"
                              +  "0000000000"
                              +  "0000000000"
                              +  "0000000000"
                               + String.format("%-20s","")
                              +  String.format("%-13s","")
                              +  String.format("%-1s","")
                              +  "00000"
                              +  String.format("%-100s","")
                              +  "00000000"
                              +  "00000000"
                              +  "0000000000";

                   G_RowCnt =  G_RowCnt + 1;
            }          

                       G_RecStr = G_RecStr +  String.format("%02d", G_Cnt)
                                      + String.format("%-284s","");

                           TOT_Record.add(G_RecStr); 

                           G_Cnt = G_Cnt + 1;

                           G_RecStr = "";
                          

                     }
                   }
               }
 
               C_Cnt = C_Cnt + 1;  

          } 

          File dir = new File("C:/EOSDATA/2016/");
          //디렉토리가 없으면 생성
          if(!dir.isDirectory()){
           dir.mkdirs();
          }
          
//        TOT_Record.SaveToFile('C:\EOSDATA\' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3) + '.denc');
          String fileDir = "C:/EOSDATA/2016/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc";
          FileWriter fw = new FileWriter(fileDir ); // 절대주소 경로 가능
          BufferedWriter bw = new BufferedWriter(fw);
          

          for (int iCnt=0;iCnt < TOT_Record.size();iCnt++) {
        	 String strWr = "";
        	 
        	 strWr = TOT_Record.get(iCnt);
        	 bw.write(strWr);  //\n + "\r"
        	 if ((TOT_Record.size() - 1) != iCnt) {
	              bw.newLine(); // 줄바꿈
	        	 }
          }
          
          bw.close();
          
          
          File objFile = new File("C:/EOSDATA/2016/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc");
          
          // 파일 다운로드
          response.setContentType("application/x-msdownload");
          
          String strFileName = URLEncoder.encode(new String(objFile.getName().getBytes("8859_1"), "euc-kr"), "euc-kr");
          response.setHeader("Content-Disposition", "attachment;filename=" + strFileName + ";");
          
          int nRead = 0;
          byte btReadByte[] = new byte[(int)objFile.length()];

          if(objFile.length() > 0 && objFile.isFile())
          {
              BufferedInputStream objBIS = new BufferedInputStream(new FileInputStream(objFile));
              BufferedOutputStream objBOS = new BufferedOutputStream(response.getOutputStream());

              while((nRead = objBIS.read(btReadByte)) != -1)
                  objBOS.write(btReadByte, 0, nRead);
          
              objBOS.flush();
              objBOS.close();
              objBIS.close();
          }
          
//          // set parameters.
//        hWnd = Application.MainForm.Handle;
//
//        pszInputFilePath  = PChar('C:/EOSDATA/' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3) + '.denc');
//        pszOutputFilePath = PChar('C:/EOSDATA/' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3));
//        pszPassword = PChar(edFILE_PASS.Text);
//        option = 1;          // DSFC_OPT_OVERWRITE_OUTPUT
//
//        mStream=TMemoryStream.Create;
//        mStream.LoadFromFile(pszInputFilePath);
//
//        ret = DSFC_EncryptData(hWnd, mStream.Memory, mStream.Size, pszOutputFilePath, pszPassword, option);
//      //  resultString = 'result code : '  + IntToStr(ret);
//        if Assigned(mStream) then FreeAndNil(mStream);
//       // Application.MessageBox(PChar(resultString), '확인', MB_OK);

	   } catch (Exception ex) {
		   ex.printStackTrace();
		   state = -1;  
//	   	   ShowMessageBM smBm = new ShowMessageBM();
//	   	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
//	   	   smBm.setMenu("Yeta");
//	   	   smBm.setPhase("[연말정산대상자]대상자생성에러");
//	   	   smBm.setMessage(ex.getLocalizedMessage());
//	   	   smBm.setContent(ex.getMessage());
//	   	   bmResult.add(smBm);  
//	   	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
 	 
      }
      
       return state;
    }
    
     /**
      * 
      * <pre>
      * 1. 개요 :  의료비 지급명세서 전자파일  
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : fnYeta1400_ReTax_Yeta3140_Create
      * @date : Feb 11, 2016
      * @author : leeheuisung
      * @history : 
      *	-----------------------------------------------------------------------
      *	변경일				작성자						변경내용  
      *	----------- ------------------- ---------------------------------------
      *	Feb 11, 2016		leeheuisung				최초 작성 
      *	-----------------------------------------------------------------------
      * 
      * @param yeta1000Vo
      */
    private int fnYeta1400_ReTax_Yeta3140_Create(InfcPkgYeta1000VO yeta1000Vo,HttpServletResponse response) throws Exception  {
    	
    	int state = 0;
    	
    	String DEFIN = "CA";
    	String defBUNS_LINS = StringUtils.replace(yeta1000Vo.getBusiNumb(),"-","") ; //사업자번호
    	String A_RecStr;
    	ArrayList<String> A_Record = new ArrayList<String>();    	
    	ArrayList<String> TOT_Record = new ArrayList<String>();
    	int A_Cnt;
    	Long mTempData01;    	

		//	==== 주의 ====
		//	PChar타입이 유니코드 문자열을 의미하는
		//	델파이 2009부터는 PChar 대신 PAnsiChar 를 사용하십시오.
		//  ret : LongInt;
		//	hWnd : LongWord;
		//	pszInputFilePath : PChar;
		//	pszOutputFilePath : PChar;
		//	pszPassword : PChar;
		//	option : LongInt;
		//	mStream: TMemoryStream;
    	 /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
	    // 1. 암호화 객체 생성
	     String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
	     /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/   
    	
    	try {
    		// A레코드 - 의료비지급명세서 레코드
    		List listYetaCA = yeta1400PayrService.fnPayrPSNL_ReTax_CA_Total_Select(yeta1000Vo);

    		if  (listYetaCA.size() > 0) { 
 
    		 	A_Cnt = 1;
    		
    			  Iterator<Map<String, Object>> iter = listYetaCA.iterator(); 
    	      	   
    	          while ( iter.hasNext() ) { 
    	            	
    	            Map<String, Object> mapCAData = (Map<String, Object>) iter.next(); 
    	            
    		  //	for (int i = 0 ; i < listYeta1.size() ; i++) {
    	            
    	            yeta1000Vo.setSystemkey(MSFSharedUtils.allowNulls(mapCAData.get("systemkey"))); 
    	            
    	            //A레코드 - 의료비지급명세서 레코드  내역 
    	            List listCAYeta = yeta1400PayrService.fnPayrCA_ReTax_Total_Select(yeta1000Vo);
    				
    	            Iterator<Map<String, Object>> iter01 = listCAYeta.iterator(); 
     	      	   
      	            while ( iter01.hasNext() ) { 
      	            	
      	            Map<String, Object> mapCAYeta = (Map<String, Object>) iter01.next(); 
      	            
    				//for (int j = 0 ; j < listYeta2.size() ; j++) {
    				//	infcPkgYeta3140Vo = (InfcPkgYeta3140VO)listYeta2.get(j);
    					
	    				A_RecStr = "";
						A_RecStr = "A" + "26" + yeta1000Vo.getTaxaCode(); // 3 세무서 코드 
						A_RecStr = A_RecStr + String.format("%06d", A_Cnt); // 4 순번
						A_RecStr = A_RecStr + StringUtils.replace(yeta1000Vo.getEdacPrdt(),"-","") ; // 5 제출년월일 
						A_RecStr = A_RecStr + defBUNS_LINS; // 6 사업자 등록번호
						A_RecStr = A_RecStr + String.format("%-20s", yeta1000Vo.getHomeTxid()); // 7 홈텍스 ID
						A_RecStr = A_RecStr + String.format("%-4s", yeta1000Vo.getTaxaPrcd()); // 8 세무프로그램 코드 
						A_RecStr = A_RecStr + defBUNS_LINS; // 9 사업자 등록번호
						A_RecStr = A_RecStr + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(yeta1000Vo.getJuriName() ,38),40," ") ; // 10 상호

						/* 
						10번까지는 화면에서 받아온 vo (yeta1000Vo) 이용
						이후는 select 결과 vo (infcPkgYeta3140Vo) 이용*/

						// 주민번호(복호화)
						 String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapCAData.get("resnRegnNum"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						    		          	
						
						A_RecStr = A_RecStr +    String.format("%-13s",rrnDecCrypt );     // 11 소득자 주민번호 
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAData.get("frnrYeno"),"1")); // 12 내,외국인 코드
						A_RecStr = A_RecStr + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapCAData.get("kornName"),""),28),30 ," "); // 13 성명
						
						A_RecStr = A_RecStr + String.format("%-10s", StringUtils.replace(MSFSharedUtils.defaultNulls(mapCAYeta.get("vendNumb"),""),"-",""));  // 14 지급처 사업자등록번호
						A_RecStr = A_RecStr + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapCAYeta.get("vendName"),"") ,38),40," "); // 15 지급처 상호
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.allowNulls(mapCAYeta.get("mediCfcd")));// 16 의료증빙 코드
								
						mTempData01 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapCAYeta.get("cashUect"),"0"));  
						A_RecStr = A_RecStr + String.format("%05d", mTempData01); //건수
						//A_RecStr = A_RecStr + String.format("%05d", infcPkgYeta3140Vo.getMediCfcd()); // 17 건수
						
						mTempData01 = Long.parseLong(MSFSharedUtils.defaultNulls(mapCAYeta.get("cashUeam"),"0"));   
						A_RecStr = A_RecStr + String.format("%011d", mTempData01); //금액
						//A_RecStr = A_RecStr + String.format("%011d", infcPkgYeta3140Vo.getCashUeam()); // 18 금액
						
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAYeta.get("ctifTrea"),""));   // 19 난임시술비 해당 여부
						
						// 주민번호(복호화)
						 rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapCAYeta.get("rsnoNumb"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						   
						A_RecStr = A_RecStr + String.format("%-13s",rrnDecCrypt ); // 20 주민번호 번호						
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAYeta.get("frnrCode"),"1")); // 21 내,외국인 코드
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAYeta.get("psclHpyn"),"2")); // 22 본인 등 해당여부
						A_RecStr = A_RecStr + "1"; // todo 내용 처리 23 제출대상기간 코드
						A_RecStr = A_RecStr + String.format("%19s", "");  ; // 24 공란
						
					 					
						TOT_Record.add(A_RecStr);
						
//					     String source = MSFSharedUtils.defaultNulls(mapCAYeta.get("vendName"),"");
//						
//						CharBuffer cbuffer = CharBuffer.wrap((new String(source.getBytes("EUC-KR"), "ksc5601")).toCharArray());
//						Charset utf8charset = Charset.forName("UTF-8");
//						ByteBuffer bbuffer = utf8charset.encode(cbuffer);
//					 
//					    System.out.println("vvvv[" + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(bbuffer.toString() ,38),40," ") + "]");
//						
//						CharBuffer cbuffer1 = CharBuffer.wrap((new String(source.getBytes(), "EUC-KR")).toCharArray());
//						Charset utf8charset1 = Charset.forName("ksc5601");
//						ByteBuffer bbuffer1 = utf8charset1.encode(cbuffer1);
//					 
//					    System.out.println("aaaaa[" + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(bbuffer1.toString() ,38),40," ") + "]");
//						
//					    String hex_utf8 =  encode(source, "UTF-8");
//					    System.out.println(hex_utf8);        
//					    System.out.println( decode(hex_utf8, "UTF-8").getBytes().length);
//					             
//					    String hex_euckr =  encode(source, "EUC-KR");
//					    System.out.println(hex_euckr);
//					    System.out.println( decode(hex_euckr, "EUC-KR").getBytes().length);
//					    System.out.println("ccccc[" + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(decode(hex_euckr, "EUC-KR") ,38),40," ") + "]");
//					    System.out.println( changeCharset(source, "UTF-8"));
//					    System.out.println("aaaaa[" + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(changeCharset(source, "UTF-8") ,38),40," ") + "]");
//						        
//					    System.out.println( changeCharset(source, "EUC-KR"));
//					    System.out.println("vvvvc[" + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(changeCharset(source, "EUC-KR") ,38),40," ") + "]");
						
					    
						A_Cnt = A_Cnt + 1;
	    				}
    			}
    		}
    		else {
    			throw new Exception("의료비 A레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.");  
    			//showMessage('의료비 A레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.');
    		}
    		
    		 File dir = new File("C:/EOSDATA/2016/");
	          //디렉토리가 없으면 생성
	          if(!dir.isDirectory()){
	           dir.mkdirs();
	          }
	          
    		//TOT_Record.SaveToFile('C:\EOSDATA\' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3) + '.denc');
    		      String fileDir = "C:/EOSDATA/2016/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc";
    	          FileWriter fw = new FileWriter(fileDir); // 절대주소 경로 가능
    	          BufferedWriter bw = new BufferedWriter(fw);
    	          

    	          for (int iCnt=0;iCnt < TOT_Record.size();iCnt++) {
    	        	 String strWr = "";
    	        	 
    	        	 strWr = TOT_Record.get(iCnt);
    	        	 bw.write(strWr);  // + "\r\n"
    	        	 if ((TOT_Record.size() - 1) != iCnt) {
    	              bw.newLine(); // 줄바꿈
    	        	 }
    	          }
    	          
    	          bw.close();
    	          
    	          File objFile = new File("C:/EOSDATA/2016/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc");
    	          
    	          // 파일 다운로드
    	          response.setContentType("application/x-msdownload");
    	          
    	          String strFileName = URLEncoder.encode(new String(objFile.getName().getBytes("8859_1"), "euc-kr"), "euc-kr");
    	          response.setHeader("Content-Disposition", "attachment;filename=" + strFileName + ";");
    	          
    	          int nRead = 0;
    	          byte btReadByte[] = new byte[(int)objFile.length()];

    	          if(objFile.length() > 0 && objFile.isFile())
    	          {
    	              BufferedInputStream objBIS = new BufferedInputStream(new FileInputStream(objFile));
    	              BufferedOutputStream objBOS = new BufferedOutputStream(response.getOutputStream());

    	              while((nRead = objBIS.read(btReadByte)) != -1)
    	                  objBOS.write(btReadByte, 0, nRead);
    	          
    	              objBOS.flush();
    	              objBOS.close();
    	              objBIS.close();
    	          }
    		
			// set parameters.
//			hWnd = Application.MainForm.Handle;			
//			pszInputFilePath  = PChar('C:/EOSDATA/' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3) + '.denc');
//			pszOutputFilePath = PChar('C:/EOSDATA/' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3));
//			pszPassword = PChar(edFILE_PASS.Text);
//			option = 1;          // DSFC_OPT_OVERWRITE_OUTPUT			
//			mStream=TMemoryStream.Create;
//			mStream.LoadFromFile(pszInputFilePath);			
//			ret = DSFC_EncryptData(hWnd, mStream.Memory, mStream.Size, pszOutputFilePath, pszPassword, option);
//			if Assigned(mStream) then FreeAndNil(mStream);
 	    	 
 	   } catch (Exception ex) {
		   ex.printStackTrace();
		   state = -1;  
//	   	   ShowMessageBM smBm = new ShowMessageBM();
//	   	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
//	   	   smBm.setMenu("Yeta");
//	   	   smBm.setPhase("[연말정산대상자]대상자생성에러");
//	   	   smBm.setMessage(ex.getLocalizedMessage());
//	   	   smBm.setContent(ex.getMessage());
//	   	   bmResult.add(smBm);  
//	   	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
 	 
      }
    	
    	return state; 
    }
    
   
 /**
  * 
  * <pre>
  * 1. 개요 : 기부금 지급 명세서  
  * 2. 처리내용 : 
  * </pre>
  * @Method Name : fnYeta1400_ReTax_Yeta3180_Create
  * @date : 2017. 1. 20.
  * @author : atres-pc
  * @history : 
  *	-----------------------------------------------------------------------
  *	변경일				작성자						변경내용  
  *	----------- ------------------- ---------------------------------------
  *	2017. 1. 20.		atres-pc				최초 작성 
  *	-----------------------------------------------------------------------
  * 
  * @param yeta1000Vo
  * @param response
  * @return
  * @throws Exception
  */
 private int fnYeta1400_ReTax_Yeta3180_Create(InfcPkgYeta1000VO yeta1000Vo,HttpServletResponse response) throws Exception { 
  
	  int state = 0;
	  String defBUNS_LINS  = "";
 	  String DEFIN = ""; 
 	  String A_Record = "";
 	  String B_Record = "";
 	  String C_Record = "";
 	  String D_Record = "";
 	  String E_Record = "";
 	  String F_Record = "";
 	  ArrayList<String> TOT_Record = new ArrayList<String>();
 	  int B_Cnt = 0;
 	  int C_Cnt = 0;
 	  int D_Cnt = 0;
 	  int E_Cnt = 0;
 	  int F_Cnt = 0;
 	  int E_RowCnt = 0;
 	  int C_rowCnt = 0;
 	  String RSNOSTR = "";
 	  String E_RecStr = "";
 	  String F_RecStr = "";
 	  String strTempDataA = "";
 	  String strTempDataB = "";
 	  String strTempDataC = "";
 	  String strTempDataD = ""; 
 	  Long mTempDataA = 0L;
 	  Long mTempDataB = 0L;
 	  Long mTempDataC = 0L;
 	  Long mTempDataD = 0L;
 	 
 	  // ==== 주의 ====
 	  // PChar타입이 유니코드 문자열을 의미하는
 	  // 델파이 2009부터는 PChar 대신 PAnsiChar 를 사용하십시오.
// 	  ret : LongInt;
// 	  hWnd : LongWord;
// 	  pszInputFilePath : PChar;
// 	  pszOutputFilePath : PChar;
// 	  pszPassword : PChar;
// 	  option : LongInt; 
//
// 	  mStream: TMemoryStream;

 	 // resultString : string;
  
 	//{기부금지급명세서} 
 	  
 	 /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
	    // 1. 암호화 객체 생성
	     String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
	     /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/   

	     

 	        DEFIN = "H"; //기부금 

 	        defBUNS_LINS = StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""); //StringReplace(edBUNS_LINS.Text,'-','',[rfReplaceALL]);   //사업자번호
 	        strTempDataA = "";
 	        strTempDataB = "";
 	        strTempDataC = "";
 	        strTempDataD = "";
 	        mTempDataA = 0L;
 	        mTempDataB = 0L;
 	        mTempDataC = 0L;
 	        mTempDataD = 0L;

 	        A_Record = "";

 	        strTempDataA = "A" + "27";

 	        strTempDataA = strTempDataA + yeta1000Vo.getTaxaCode();   //edTAXO_FFIE.Text ;   //세무서코드 
 	                       mTempDataA    =  Long.parseLong(StringUtils.replace(yeta1000Vo.getEdacPrdt(),"-",""));//StrToInt(StringReplace(edINCO_OUDT.Text,'-','',[rfReplaceALL]));  //제출년월일 
 	        strTempDataA = strTempDataA  +  String.format("%08d", mTempDataA);  //FormatFloat('00000000', mTempDataA) ;   //제출년월일
 	                       mTempDataA    =  Long.parseLong( yeta1000Vo.getIncmGbcd() );   //StrToInt(edEXPT_GBUN.Text);
 	        strTempDataA = strTempDataA  +  String.format("%01d", mTempDataA);  //FormatFloat('0', mTempDataA);   //제출자구분

 	        strTempDataA = strTempDataA  + String.format("%-6s", MSFSharedUtils.defaultNulls(yeta1000Vo.getTaxaDnum(),""));   //Format('%-6s', [edTXOF_NUMB.Text]) ; //세무대리인번호(7)
 	        strTempDataA = strTempDataA  + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(yeta1000Vo.getHomeTxid(),18),20," "); // String.format("%-20s", yeta1000Vo.getHomeTxid()); //Format('%-20s', [edHOME_TXID.Text]) ;  //홈텍스아이디 
 	        strTempDataA = strTempDataA  + String.format("%-4s", yeta1000Vo.getTaxaPrcd()) ;//Format('%-4s', [edTAXP_CODE.Text])  ; //세무프로그램코드
 	        strTempDataA = strTempDataA  + String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-","")) ; //Format('%-10s', [StringReplace(edBUNS_LINS.Text,'-','',[rfReplaceALL])]) ; //사업자등록번호
 	        strTempDataA = strTempDataA  +  PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(yeta1000Vo.getJuriName(),38),40," "); //String.format("%-40s", yeta1000Vo.getJuriName()); //  Format('%-40s', [edPROF_RSNM.Text])   ; //법인명
 	        strTempDataA = strTempDataA  + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(yeta1000Vo.getCharDept(),28),30," "); //String.format("%-30s", yeta1000Vo.getCharDept());  //Format('%-30s', [edSELF_DEPT.Text]) ;  //담당자부서
 	        strTempDataA = strTempDataA  + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(yeta1000Vo.getCharName(),28),30," "); 
 	        	//	String.format("%-30s", yeta1000Vo.getCharName());  //Format('%-30s', [edSELF_NAME.Text])   ; //담당자성명
 	        strTempDataA = strTempDataA  + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(yeta1000Vo.getCharTele(),15),15," ")  ;  //Format('%-15s', [edSELF_TELE.Text]) ;   //담당자전화번호
 	        mTempDataA = 1L;
 	        strTempDataA = strTempDataA  + String.format("%05d", mTempDataA);  //FormatFloat('00000',mTempDataA);  //신고자수
 	        strTempDataA = strTempDataA  + "101" ;   //사용한글코드
 	        strTempDataA = strTempDataA  + String.format("%12s", "");  //Format('%2s', ['']);  //공란
 
 	        TOT_Record.add(strTempDataA);

 	        B_Cnt = 1;
 	       
 	    try {
 	       
 	    	//B레코드 - 원천징수의무자별 집계레코드 
 	       Map mapHb = yeta1400PayrService.fnPayrHB_ReTax_Total_Select(yeta1000Vo);
 	        
// 	      if oraQrySelect01.Eof = True then
// 	      begin
// 	         showMessage('B레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.');
// 	          Result = -1;
// 	         Exit;
// 	      end;
 	       if (!"2".equals(MSFSharedUtils.defaultNulls(yeta1000Vo.getIncmGbcd(),""))) {
 	     //  if (MSFSharedUtils.paramNull(StringUtils.replace(yeta1000Vo.getJuriNumb(),"-","")) || StringUtils.replace(yeta1000Vo.getJuriNumb(),"-","").equals("null")) {
              
              RSNOSTR = StringUtils.replace(yeta1000Vo.getResuNumb(),"-","");    //사업자주민번호 
           }
           else
           {
              RSNOSTR =  StringUtils.replace(yeta1000Vo.getJuriNumb(),"-","");   //법인번호
           }
    	  
            
 	      
 	        mTempDataB = 0L;
 	        strTempDataB = "";

 	         strTempDataB   = "B" + "27";   //레코드 구분 /자료구분 
 	         strTempDataB   =  strTempDataB + yeta1000Vo.getTaxaCode();    //세무서코드 
 	         strTempDataB   = strTempDataB  + String.format("%06d", B_Cnt);   //일련번호 
	         strTempDataB  = strTempDataB +  String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""));  //사업자등록번호 10
	         strTempDataB  = strTempDataB +  PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(yeta1000Vo.getJuriName(),38),40," ")  ;
	        		 //String.format("%-40s", yeta1000Vo.getJuriName()); //Format('%-40s', [edPROF_RSNM.Text]);   //상호(40)
	         mTempDataB   =  Long.parseLong( MSFSharedUtils.defaultNulls(mapHb.get("ctrbCnt"),"0"));  
	         strTempDataB = strTempDataB + String.format("%07d", mTempDataB);     //기부금조정명세레코드수(9[7])
	          mTempDataB =    Long.parseLong( MSFSharedUtils.defaultNulls(mapHb.get("yeta3180Cnt"),"0"));     
	         strTempDataB = strTempDataB +  String.format("%07d", mTempDataB);   //해당연도 기부명세레코드
	         mTempDataB =   Long.parseLong( MSFSharedUtils.defaultNulls(mapHb.get("ctrbAmnt"),"0"));   
	         strTempDataB = strTempDataB + String.format("%013d", mTempDataB);    //기부금액 총계
	          mTempDataB =  Long.parseLong( MSFSharedUtils.defaultNulls(mapHb.get("detrAmnt"),"0"));   
	         strTempDataB = strTempDataB + String.format("%013d", mTempDataB);     //공제대상금액 총계
	         strTempDataB = strTempDataB + "1" ;   //todo 제출대상기간코드
	         strTempDataB = strTempDataB + String.format("%87s", "");     //공란

 	          
 	         TOT_Record.add(strTempDataB);

 	          C_Cnt =  0;
 	        
 	          
 	         //C 레코드 - 기부금 조정명세 레코드  
 	         List listTotData01 = yeta1400PayrService.fnPayrPSNL_ReTax_Total_Select(yeta1000Vo);
 	          

 	          if (listTotData01.size() <= 0) { 
 	        	 throw new Exception("기부금명세서 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.");  
// 	             showMessage('기부금명세서 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.');
// 	             Result = -1;
// 	             Exit;
 	          } 
 	          
 	          Iterator<Map<String, Object>> iter = listTotData01.iterator(); 
      	   
	          while ( iter.hasNext() ) { 
	            	
	            Map<String, Object> mapTotData01 = (Map<String, Object>) iter.next();  
	          
	            yeta1000Vo.setSystemkey(MSFSharedUtils.allowNulls(mapTotData01.get("systemkey")));
 	              //SYSTEMKEY 가지고 데이타 가져오기 
	            //C 레코드 - 기부금 조정명세 레코드  YETA3170
	            List listHCData = yeta1400PayrService.fnPayrHC_ReTax_Total_Select(yeta1000Vo);  
	             
// 	               { if oraQrySelect02.Eof = True then
// 	                begin
// 	                   showMessage('C레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.');
// 	                   Result = -1;
// 	                   Exit;
// 	                end; }

 	               C_rowCnt = 1;
 	             
 	              if (listHCData.size() > 0) { 
 	                  C_Cnt = C_Cnt + 1;
 	              }
 	               
 	              Iterator<Map<String, Object>> iter01 = listHCData.iterator(); 
 	        	   
 		          while ( iter01.hasNext() ) { 
 		            	
 		            Map<String, Object> mapHCData = (Map<String, Object>) iter01.next(); 
 		            


 		               // 주민번호(복호화)
 		               String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapTotData01.get("resnRegnNum"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
 		            		          	 
 	                    strTempDataC = "";
 	                    mTempDataC  = 0L;

 	                    strTempDataC =  "C" + "27" ;
 	                    strTempDataC = strTempDataC + yeta1000Vo.getTaxaCode(); //세무서코드 
                        mTempDataC = Long.parseLong(String.valueOf(C_Cnt));
                        strTempDataC = strTempDataC +   String.format("%06d", mTempDataC);    //소득자일련번호 
                        strTempDataC = strTempDataC  +  String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-","")); //사업자등록번호
                        strTempDataC = strTempDataC  +  String.format("%-13s", rrnDecCrypt);     //소득자주민등록번호
                        mTempDataC =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("frnrYeno"),"1"));   //oraQrySelect01.FieldByName('FRNR_YENO').AsFloat;    
                        strTempDataC = strTempDataC  +  String.format("%01d", mTempDataC);     //내외국인구분코드 
                        strTempDataC = strTempDataC  +   PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapTotData01.get("kornName"),""),28),30," "); 
                        		//String.format("%-30s",  MSFSharedUtils.defaultNulls(mapHCData.get("kornName"),""));  //성명
                        strTempDataC = strTempDataC  +  String.format("%-2s",  MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""));    //유형코드
                        mTempDataC =  Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbYrmn"),"0"));   
                        strTempDataC = strTempDataC  +   String.format("%04d", mTempDataC);    //기부연도
                        mTempDataC =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbAmnt"),"0"));   
                        strTempDataC = strTempDataC  +  String.format("%013d", mTempDataC);   //기부금액 - 13
                        mTempDataC =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("bfyrDeam"),"0"));   
                        strTempDataC = strTempDataC  +  String.format("%013d", mTempDataC);  //전년까지공제된금액 -13
                        mTempDataC =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("detrAmnt"),"0"));   
                        strTempDataC = strTempDataC  + String.format("%013d", mTempDataC);  //공제대상금액  -13
                        
                        strTempDataC = strTempDataC  + "0000000000000" ;   //해당년도공제금액 필요경비 
                        
                        mTempDataC =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("dyyrDeam"),"0"));  
                        strTempDataC = strTempDataC  + String.format("%013d", mTempDataC);//해당년도공제금액세액금액 -13                        
                        mTempDataC =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("dyyrOtam"),"0"));   
                        strTempDataC = strTempDataC  + String.format("%013d", mTempDataC); //해당년도공제받지못한금액소멸금액 -13
                        mTempDataC =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("ayyrNtam"),"0"));   
                        strTempDataC = strTempDataC  + String.format("%013d", mTempDataC); //해당년도에 공제받지못한금액_이월금액 -3
                        strTempDataC = strTempDataC  + String.format("%05d", C_rowCnt);       //기부금조정명세일련번호 -5
                        strTempDataC = strTempDataC  + String.format("%22s", "");      //공란 -25
 
 	                   TOT_Record.add(strTempDataC);
 	                   C_rowCnt = C_rowCnt + 1;
 
 		          }

 	               D_Cnt = 1;
 	             
 	              //D레코드 - 해당연도 기부명세 레코드  
 	              List listHDData = yeta1400PayrService.fnPayrHD_ReTax_Total_Select(yeta1000Vo); 
 	               
 	             if (listHCData.size() > 0) { 
	              
	              Iterator<Map<String, Object>> iter02 = listHDData.iterator(); 
	        	   
		          while ( iter02.hasNext() ) { 
		            	
		            Map<String, Object> mapHDData = (Map<String, Object>) iter02.next();
 
 	                     strTempDataD = "";
 	                     mTempDataD  = 0L;

 	                    // 주민번호(복호화)
 	 		               String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapTotData01.get("resnRegnNum"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
 	 		            		   
 	                      strTempDataD =  "D" + "27";
 	                      strTempDataD = strTempDataD + yeta1000Vo.getTaxaCode();  //세무서코드 
                          strTempDataD = strTempDataD + String.format("%06d", C_Cnt);     //소득자일련번호 
                          strTempDataD = strTempDataD + String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""));   //사업자등록번호 
                          
                          strTempDataD = strTempDataD +  String.format("%-13s", rrnDecCrypt);      //소득자주민등록번호
                          strTempDataD = strTempDataD +  String.format("%-2s",  MSFSharedUtils.defaultNulls(mapHDData.get("ctrbTycd"),""));     //유형코드
                          
                          strTempDataD = strTempDataD +  String.format("%-13s", StringUtils.replace(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbBsnu"),""),"-",""));    //사업자등록번호
 
                          strTempDataD = strTempDataD + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbName"),""),28),30," ");
                          //String.format("%-30s", StringUtils.left(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbName"),""),30));    //상호 - 30
                                           
                          strTempDataD = strTempDataD +  String.format("%-1s",  MSFSharedUtils.defaultNulls(mapHDData.get("crtbCncd"),""));  //관계코드
                          strTempDataD = strTempDataD +  String.format("%-1s",  MSFSharedUtils.defaultNulls(mapHDData.get("frnrCode"),""));     //내외국인구분코드
                          strTempDataD = strTempDataD +  PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapHDData.get("cbtgName"),""),18),20," "); 
                          //String.format("%-20s", MSFSharedUtils.defaultNulls(mapHDData.get("cbtgName"),""));   //성명 - 20
                          // 주민번호(복호화)
	 		                 rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapHDData.get("rsnoNumb"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	 		            		   
                          strTempDataD = strTempDataD +  String.format("%-13s", rrnDecCrypt);    //기부자주민등록번호 
                          mTempDataD =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbNcnt"),"1"));   
                          strTempDataD = strTempDataD +  String.format("%05d", mTempDataD);   //건수 - 5
                       
                          mTempDataD = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbAmnt"),"0"));   
                          strTempDataD = strTempDataD +  String.format("%013d", mTempDataD);     //기부금액 - 13

                          //2016년 추가 -----
                          mTempDataD = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbTgam"),"0"));   
                          strTempDataD = strTempDataD +  String.format("%013d", mTempDataD);     //공제대상기부금액
                          mTempDataD = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ctjaCham"),"0"));   
                          strTempDataD = strTempDataD +  String.format("%013d", mTempDataD);     //기부장려신청금액
 
                          
                          strTempDataD = strTempDataD + String.format("%05d", D_Cnt);    //일련번호 
                          
                          strTempDataD = strTempDataD +  String.format("%26s", "");    //공란 42
 
 	                      TOT_Record.add(strTempDataD);
 
 	                    D_Cnt = D_Cnt + 1;
		           }
 	             } 

	         }



        //  파일저장 암호화 루틴 
// 	      TOT_Record.SaveToFile('C:\EOSDATA\' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3) + '.denc');
	     
	          File dir = new File("C:/EOSDATA/2016/");
	          //디렉토리가 없으면 생성
	          if(!dir.isDirectory()){
	           dir.mkdirs();
	          }
	         
	          String fileDir = "C:/EOSDATA/2016/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc";
	          FileWriter fw = new FileWriter(fileDir); // 절대주소 경로 가능
	          BufferedWriter bw = new BufferedWriter(fw);
	          

	          for (int iCnt=0;iCnt < TOT_Record.size();iCnt++) {
	        	 String strWr = "";
	        	 
	        	 strWr = TOT_Record.get(iCnt);
	             bw.write(strWr); //\n + "\r"
	             if ((TOT_Record.size() - 1) != iCnt) {
   	              bw.newLine(); // 줄바꿈
   	        	 }
	          }
	          
	          bw.close();
	          
	          File objFile = new File("C:/EOSDATA/2016/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc");
	          
	          // 파일 다운로드
	          response.setContentType("application/x-msdownload");
	          
	          String strFileName = URLEncoder.encode(new String(objFile.getName().getBytes("8859_1"), "euc-kr"), "euc-kr");
	          response.setHeader("Content-Disposition", "attachment;filename=" + strFileName + ";");
	          
	          int nRead = 0;
	          byte btReadByte[] = new byte[(int)objFile.length()];

	          if(objFile.length() > 0 && objFile.isFile())
	          {
	              BufferedInputStream objBIS = new BufferedInputStream(new FileInputStream(objFile));
	              BufferedOutputStream objBOS = new BufferedOutputStream(response.getOutputStream());

	              while((nRead = objBIS.read(btReadByte)) != -1)
	                  objBOS.write(btReadByte, 0, nRead);
	          
	              objBOS.flush();
	              objBOS.close();
	              objBIS.close();
	          }
	          
//	          FileOutputStream fos = null;
//	          InputStream is = null;
//	          try {
//	              fos = new FileOutputStream("C:/EOSDATA/2015/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc");
//	   
//	              URL url = new URL("http://192.168.0.9:8080/");
//	              URLConnection urlConnection = url.openConnection();
//	              is = urlConnection.getInputStream();
//	              byte[] buffer = new byte[1024];
//	              int readBytes;
//	              while ((readBytes = is.read(buffer)) != -1) {
//	                  fos.write(buffer, 0, readBytes);
//	              }
//	          } catch (FileNotFoundException e) {
//	              e.printStackTrace();
//	          } catch (MalformedURLException e) {
//	              e.printStackTrace();
//	          } catch (IOException e) {
//	              e.printStackTrace();
//	          } finally {
//	              try {
//	                  if (fos != null) {
//	                      fos.close();
//	                  }
//	                  if (is != null) {
//	                      is.close();
//	                  }
//	              } catch (IOException e) {
//	                  e.printStackTrace();
//	              }
//	          }
	          
// 	        // set parameters.
// 	      hWnd = Application.MainForm.Handle;
//
// 	      pszInputFilePath  = PChar('C:/EOSDATA/' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3) + '.denc');
// 	      pszOutputFilePath = PChar('C:/EOSDATA/' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3));
// 	      pszPassword = PChar(edFILE_PASS.Text);
// 	      option = 1;          // DSFC_OPT_OVERWRITE_OUTPUT
//
// 	      mStream=TMemoryStream.Create;
// 	      mStream.LoadFromFile(pszInputFilePath);
//
// 	      ret = DSFC_EncryptData(hWnd, mStream.Memory, mStream.Size, pszOutputFilePath, pszPassword, option);
// 	    //  resultString = 'result code : '  + IntToStr(ret);
// 	      if Assigned(mStream) then FreeAndNil(mStream);
// 	     // Application.MessageBox(PChar(resultString), '확인', MB_OK);


	   } catch (Exception ex) {
		   ex.printStackTrace();
		   state = -1;  
//	   	   ShowMessageBM smBm = new ShowMessageBM();
//	   	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
//	   	   smBm.setMenu("Yeta");
//	   	   smBm.setPhase("[연말정산대상자]대상자생성에러");
//	   	   smBm.setMessage(ex.getLocalizedMessage());
//	   	   smBm.setContent(ex.getMessage());
//	   	   bmResult.add(smBm);  
//	   	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
 	 
      } 
 	     

 	     return state; 
    } 
 
  
 @RequestMapping(value = "/exp/Yeta1400Verifiction.do")
 public String yeta1400Verifiction(@ModelAttribute("InfcPkgYeta1000VO") InfcPkgYeta1000VO yeta1000VO,final HttpServletRequest request,final HttpServletResponse response
         , Map commandMap , Model model) throws Exception {
      
     MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
     
     List<YetaMessageVO>  rtnResult = new ArrayList<YetaMessageVO>();
 	  
     if  (yeta1400PayrService == null) { 
         WebApplicationContext wac = WebApplicationContextUtils.
                 getRequiredWebApplicationContext( request.getSession().getServletContext());

         yeta1400PayrService = (Yeta1400PayrService) wac.getBean("Yeta1400PayrService" ); 
        
     }
     
      
     try	{ 
     	
     	
      List<String> listDeptCd = new ArrayList<String>(); 
      yeta1000VO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
      yeta1000VO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 

  	  yeta1000VO.setDeptCdAuth(MSFSharedUtils.allowNulls(yeta1000VO.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
  	  yeta1000VO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(yeta1000VO.getDtilOccuInttnCd()).replace(",", ""));   
     
  	  yeta1000VO.setUsrId(sessionUser.getUsrId());
	   	 /******************************** 권한 ************************************************************************/
	   	 String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	   	 	
	   	 if ("FALSE".equals(chkDeptCd)) {
	   		 
	   		 yeta1000VO.setDeptCd(sessionUser.getDeptCd()); 
		   	 listDeptCd.add(sessionUser.getDeptCd());
		   	 yeta1000VO.setDeptCdArr(listDeptCd);     //부서코드    
		   	 yeta1000VO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
		        
	   	 } else {
	     	    
	   		 yeta1000VO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(yeta1000VO.getPayrMangDeptCd())) ;   //단위기관코드   
	   	 		
	   	 	if (yeta1000VO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(yeta1000VO.getDeptCd()))) { 
	   	 		listDeptCd = null; 
	   	 		yeta1000VO.setDeptCdArr(listDeptCd);     //부서코드 
	   	 		yeta1000VO.setDeptCd("");  //부서코드
	   	 	} else {
	   	 		yeta1000VO.setDeptCd(MSFSharedUtils.allowNulls(yeta1000VO.getDeptCd()));
	            listDeptCd = SmrmfUtils.getStrToArrayList(yeta1000VO.getDeptCd());  
	            yeta1000VO.setDeptCdArr(listDeptCd);     //부서코드   
	        } 
	   	 }
	     
	     
	     
	   	 /******************************** 권한 ************************************************************************/
	  	
	    List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta1000VO.getTypOccuCd())); 
	    yeta1000VO.setTypOccuCdArr(lstTypeOccuCd); 
	    yeta1000VO.setTypOccuCd(MSFSharedUtils.allowNulls(yeta1000VO.getTypOccuCd()));  	//직종
	        
//	  	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	  	psnl0100SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	  	psnl0100SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	          
	   	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta1000VO.getDtilOccuInttnCd())); 
	   	yeta1000VO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	   	yeta1000VO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(yeta1000VO.getDtilOccuInttnCd())); //직종세
	        
		List<String> lstBusinCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta1000VO.getBusinCd())); 
		yeta1000VO.setBusinCdArr(lstBusinCd);   
		yeta1000VO.setBusinCd(MSFSharedUtils.allowNulls(yeta1000VO.getBusinCd()));   //사업코드
		
		yeta1000VO.setYetaDpcd(MSFSharedUtils.allowNulls(yeta1000VO.getYetaDpcd()));				//원천신고부서
		yeta1000VO.setBusoprRgstnum(MSFSharedUtils.allowNulls(yeta1000VO.getBusoprRgstnum()));	//사업자등록번호 
		

     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
//      	SysIfBass0320VO  sysIfBass0320Vo = new SysIfBass0320VO();
//     	 List<String> listTypCd = new ArrayList<String>(); 
//     	 
//     	sysIfBass0320Vo.setYmdGb("Y");
//     	sysIfBass0320Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYr")));
//     	sysIfBass0320Vo.setTypOccuCd(psnl0100SrhVO.getTypOccuCd());
//     	sysIfBass0320Vo.setTypOccuCdArr(lstTypeOccuCd); 
//     	
//     	listTypCd = SysifPkgServiceUtils.funcArrBeforTypOccuCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0320Vo);
     	
     	SysIfBass0350VO  sysIfBass0350Vo = new SysIfBass0350VO();
     //	 List<String> listTyInttnCd = new ArrayList<String>(); 
     	sysIfBass0350Vo.setDpobCd(sessionUser.getDpobCd());
     	sysIfBass0350Vo.setYmdGb("Y");
     	sysIfBass0350Vo.setStrDate(MSFSharedUtils.allowNulls(yeta1000VO.getEdacRvyy()));
     	sysIfBass0350Vo.setTypOccuCd(yeta1000VO.getTypOccuCd());
     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
    	sysIfBass0350Vo.setDtilOccuInttnCd(yeta1000VO.getDtilOccuInttnCd());
     	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
     	
     	sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0350Vo); 
     
     	yeta1000VO.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
     	yeta1000VO.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
     	
     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
     	

		       	 if (yeta1000VO.getCreFile().equals("Y0090001")) {
		       		 //근로소득지급명세서 검증  
		       		rtnResult = fnYeta1400_ReTax_Payr3000_Check(yeta1000VO,response) ;
		 
		       	 
		       	 } else if (yeta1000VO.getCreFile().equals("Y0090002")) {
		       		 //의료비지급명세서 검증 
		       		rtnResult = fnYeta1400_ReTax_Yeta3140_Check(yeta1000VO,response) ;
		       	    
		       		
		       	 } else if (yeta1000VO.getCreFile().equals("Y0090003")) {
		       		 //기부금지급명세서 검증 
		       		rtnResult = fnYeta1400_ReTax_Yeta3180_Check(yeta1000VO,  response) ;
		            
		       	 }  
               
                   
     } catch(Exception ex) {
     	ex.printStackTrace();  
     	
     }  
     
     //jsp 파일 호출로 변경 해야 함. 
     return "";

 }  

 private List<YetaMessageVO> fnYeta1400_ReTax_Payr3000_Check(InfcPkgYeta1000VO yeta1000Vo,HttpServletResponse response) throws Exception  {
	  
	 List<YetaMessageVO>  bmResult = new ArrayList<YetaMessageVO>();
	  
 	String DEFIN = "";
    String defBUNS_LINS = "";
    String A_Record  = "";
    String B_Record  = "";
    String C_Record  = "";
    String D_Record  = "";
    String E_Record  = "";
    String F_Record  = "";
    String G_Record  = "";
    ArrayList<String> TOT_Record = new ArrayList<String>();
    
    int B_Cnt = 0;
    int C_Cnt = 0;
    int D_Cnt = 0;
    int E_Cnt = 0;
    int F_Cnt = 0;
    int G_Cnt = 0;
    int E_RowCnt = 0;
    int F_RowCnt = 0;
    int G_RowCnt = 0;   
    String RSNOSTR = "";
    String E_RecStr = "";
    String F_RecStr = "";
    String G_RecStr = "";
    String B_RecStr = ""; 
    String C_RecStr = "";
    String D_RecStr = "";
    Long mTempData01 = 0L;
    Long mTempData02 = 0L;

    // ==== 주의 ====
    // PChar타입이 유니코드 문자열을 의미하는
    // 델파이 2009부터는 PChar 대신 PAnsiChar 를 사용하십시오.
//    ret : LongInt;
//    hWnd : LongWord;
//    pszInputFilePath : PChar;
//    pszOutputFilePath : PChar;
//    pszPassword : PChar;
//    option : LongInt;
//
//    mStream: TMemoryStream;
//
//    resultString : string;
  
  //{근로소득지급명세서}
	   /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
	    // 1. 암호화 객체 생성
	     String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
	     /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/   

        DEFIN = "C"; //근로소득
        defBUNS_LINS = StringUtils.replace(yeta1000Vo.getBusiNumb(),"-","");   //사업자번호
      
        InfcPkgYeta1000VO infcPkgYeta1000Vo = new InfcPkgYeta1000VO();

         A_Record = ("A" + "20" + yeta1000Vo.getTaxaCode() + String.format("%08d", Long.parseLong(StringUtils.replace(yeta1000Vo.getEdacPrdt(),"-","")))
                       + String.format("%01d", Long.parseLong( yeta1000Vo.getIncmGbcd() ))   + String.format("%-6s", MSFSharedUtils.defaultNulls(yeta1000Vo.getTaxaDnum(),"")) 
                       +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(yeta1000Vo.getHomeTxid() ,20),20," ")  
                       +  String.format("%-4s", yeta1000Vo.getTaxaPrcd()) 
                       +  String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""))
                       +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(yeta1000Vo.getJuriName() ,38),40," ")  
                       +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(yeta1000Vo.getCharDept() ,28),30," ") 
                       +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(yeta1000Vo.getCharName(),28),30," ")    
                       +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(yeta1000Vo.getCharTele() ,15),15," ")  
                       +  String.format("%05d", 1) + "101"
                       +  String.format("%1442s", ""));

        TOT_Record.add(A_Record);

        B_Cnt = 1;
        mTempData01 = 0L;
        
      try {

      
    	  Map mapYetaB = yeta1400PayrService.fnPayrB_ReTax_Total_Select(yeta1000Vo); 

    	  if (mapYetaB.isEmpty()) { 
//           showMessage('B레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.');
//           Result = -1;
//           Exit;
    	  }
    	  
    	  if (MSFSharedUtils.paramNull(StringUtils.replace(yeta1000Vo.getJuriNumb(),"-","")) || StringUtils.replace(yeta1000Vo.getJuriNumb(),"-","").equals("null")) {

    	   	//  RSNOSTR = StringUtils.replace(yeta1000Vo.getResuNumb(),"-","");    //사업자주민번호 
    		// 주민번호(복호화)
    		String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(yeta1000Vo.getResuNumb()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
    		          	 
    		RSNOSTR	  = rrnDecCrypt;
            
           }
           else
           {
              RSNOSTR =  StringUtils.replace(yeta1000Vo.getJuriNumb(),"-","");   //법인번호
           }
    	  
          B_RecStr = "";
          mTempData01 = 0L ;
 

              B_RecStr = "B" + "20" + yeta1000Vo.getTaxaCode() +  String.format("%06d", B_Cnt)   +   String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""))
                           + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(yeta1000Vo.getJuriName() ,38),40," ")  
                           + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(yeta1000Vo.getReprName() ,28),30," ")  
                           + String.format("%-13s", StringUtils.replace(RSNOSTR,"-",""))  ; 
                            mTempData01 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("psnlJuCnt"),"0"));
              B_RecStr =  B_RecStr  +  String.format("%07d", mTempData01);    //주근무지 레코드 수 
                            mTempData01 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("psnlJungCnt"),"0"));  
              B_RecStr =  B_RecStr + String.format("%07d", mTempData01);     //종전근무지 레코드 수 

              mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("totlSala"),"0")); 
              B_RecStr =  B_RecStr + String.format("%014d", mTempData01);   //총급여 총계_현전
              mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("dcsnIncm"),"0"));  
              B_RecStr =  B_RecStr   +  String.format("%013d", mTempData01);    //결정세액 소득세 
            //  mTempData01 =  oraQrySelect01.FieldByName('GONG_TEMP01').AsFloat;
            //  B_RecStr =  B_RecStr  + FormatFloat('0000000000000', mTempData01);
              mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("desnInhb"),"0"));    
              B_RecStr =  B_RecStr  + String.format("%013d", mTempData01);   //결정세액 지방소득세
              mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("dcsnFafv"),"0"));  
              B_RecStr =  B_RecStr   + String.format("%013d", mTempData01);    //결정세액 농특세
              mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("dcsnTotl"),"0")); 
              B_RecStr =  B_RecStr  + String.format("%013d", mTempData01);    //결정세액 총계
              B_RecStr =  B_RecStr  + "1"; //체출기간 연간합산제출등 코드로 등록하여 처리 하게 수정 필요 
              B_RecStr =  B_RecStr +  String.format("%1434s", "");     //공란 
               
              TOT_Record.add(B_RecStr);

              C_Cnt =  1;
           
            //c레코드 주현근무처 레코드 fnPayrC_ReTax_Total_Select
           List listYetaC = yeta1400PayrService.fnPayrC_ReTax_Total_Select(yeta1000Vo);
            
     	  if (listYetaC.size() <= 0) {  
     		  throw new Exception("C레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.");  
     	  } 

     	  Iterator<Map<String, Object>> iter = listYetaC.iterator(); 
    	   
          while ( iter.hasNext() ) { 
           	
           Map<String, Object> mapYetaC = (Map<String, Object>) iter.next();  
               
               mTempData02 = 0L;
               C_RecStr = "";
               //  oraQrySelect01.FieldByName('CITY_SEQN').AsString; Format('%.11d', [])
                             C_RecStr = "C" ;   //레코드구분
                             C_RecStr = C_RecStr + "20"; //자료구분 
                             C_RecStr = C_RecStr   + yeta1000Vo.getTaxaCode(); //세무서코드 
                             C_RecStr = C_RecStr + String.format("%06d", C_Cnt);    //원천징수읨주별로 1부터 순차부여 
                             C_RecStr = C_RecStr  +  String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""));  //사업자등록번호 
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("befoScnt"),"0"));             /*  종전근무처수 */    
                             C_RecStr = C_RecStr  + String.format("%02d",mTempData02);
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("resdFlag"),"1"));        //거주자구분코드
                             C_RecStr = C_RecStr  + String.format("%01d", mTempData02);
                             C_RecStr = C_RecStr  + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaC.get("redtGbcd"),"")  );    //거주지국코드
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("frnrSgyn"),"2"));                        //단일세율적용여부
                             C_RecStr = C_RecStr  + String.format("%01d", mTempData02) ;
                             //2016귀속 추가 ㄴ
                             C_RecStr = C_RecStr  + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("frnrRnyn"),"2")  );    //외국법인소속 파견근로자여부 
                             
                             C_RecStr = C_RecStr  + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaC.get("kornName"),"") ,28),30," ") ;    //성명
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("frnrYeno"),"1"));                                 //내외국인구부노드
                             C_RecStr = C_RecStr  +  String.format("%01d",  mTempData02) ;
                             
                          // 주민번호(복호화)
             				String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaC.get("resnRegnNum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
             		          	 
                             C_RecStr = C_RecStr  + String.format("%-13s",rrnDecCrypt);     //주민등록번호
                             
                             
                             C_RecStr = C_RecStr  + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaC.get("natnNbcd"),"") );       //국적코드
                             C_RecStr = C_RecStr  + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("gnanSgtf"),"") );       //세대주구분코드
                             C_RecStr = C_RecStr   + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("hoofStcd"),"")) ;       //연말정산구분 계속근로,중도퇴사
                             C_RecStr = C_RecStr   + String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-","")) ;            //주현근무처-사업자등록번호
                             C_RecStr = C_RecStr   + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(yeta1000Vo.getJuriName() ,38),40," ") ;                                     //주현근무처-근무처명
                         
                            
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("reymStdt"),"0"));                                  //근무기간시작연월일
                            C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("reymEddt"),"0"));                                 //근무기간 종료일자
                            C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("rutrStdt"),"0"));                                  //감면기간시작일자
                             C_RecStr = C_RecStr  +  String.format("%08d",  mTempData02) ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("rutrEddt"),"0"));                                    //감면기간종료일자
                             C_RecStr = C_RecStr  +  String.format("%08d", mTempData02);
                             mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTamt"),"0"));                                 //급여총액
                             C_RecStr = C_RecStr  + String.format("%011d", mTempData02);
                             mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("bonsToam"),"0"));                                   //상여총액
                             C_RecStr = C_RecStr  + String.format("%011d",  mTempData02);
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dtmnBsam"),"0"));                               //인정상여
                             C_RecStr = C_RecStr  + String.format("%011d",  mTempData02);
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("stckPrft"),"0"));                                //주식행사이익
                             C_RecStr = C_RecStr  + String.format("%011d",  mTempData02) ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp26"),"0"));                               //우리사주조합인출금
                            C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp27"),"0"));                                 //임원 퇴직소득금액 한도초과액
                            C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);

                             C_RecStr = C_RecStr  + "000000000000000000000";
                            C_RecStr = C_RecStr   +  String.format("%011d", Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaC.get("currTots"),"0"))) ;                    //계
               
                            //주현근무처 비과세소득 및 감면소득  
                     //       mTempData02 = oraQrySelect02.FieldByName('PAYR_TEMP29').AsFloat;
                     //       C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSg01"),"0"));  
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh01"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh05"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh06"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh07"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh08"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh09"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh10"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh14"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh15"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh11"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh12"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh13"),"0"));  
                           C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;
                           mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh16"),"0"));  
                           C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;
                           mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSi01"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSk01"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm01"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm02"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm03"),"0"));  
                             C_RecStr = C_RecStr  +  String.format("%010d",  mTempData02) ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSo01"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d", mTempData02)  ;
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSq01"),"0")); 
                             C_RecStr = C_RecStr  +  String.format("%010d", mTempData02) ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSr10"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSs01"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt01"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy02"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy03"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            //2016년 귀속 추가 
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy04"),"0"));  
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy21"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy22"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt10"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            
                            //2016년귀속 추가 
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt11"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt12"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            
                            
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt20"),"0")); 
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp60"),"0"));    //비과세계
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp61"),"0"));   //감면소득계
                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                
                          //  C_RecStr = C_RecStr   + "0000000000";//공란 0으로 10자리       
                            
                            //정산명세 처리 시작    
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("totlSala"),"0"));         /*(16 합계)(21)번  column 총급여_현_전 : TOTL_SALA */          
                            C_RecStr = C_RecStr   +  String.format("%011d", mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("wkerDdct"),"0"));    /* (22) column 근로소득공제 : WKER_DDCT */    
                            C_RecStr = C_RecStr   +  String.format("%010d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("wkerAmnt"),"0"));      /*(23) column 근로소득금액 : WKER_AMNT */  
                            C_RecStr = C_RecStr   +  String.format("%011d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("baseSelf"),"0"));  /*(24) column 기본공제_본인 : BASE_SELF */         
                            C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("baseWife"),"0")); /*(25) column 기본공제_배우자 : BASE_WIFE */         
                            C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("baseFmly"),"0"));   /*(26) column 기본공제_부양가족수 : BASE_FMLY */  
                            C_RecStr = C_RecStr   + String.format("%02d", mTempData02) ;
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("baseFyam"),"0"));   /*(26) column 기본공제_부양가족 : BASE_FYAM */     
                            C_RecStr = C_RecStr   + String.format("%08d",mTempData02)  ;
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrCt70"),"0"));  /*(70) column 추가공제_경로우대_70세이상수 : ADDR_CT70 경로우대공제인원 */       
                            C_RecStr = C_RecStr   + String.format("%02d",mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrRpt70"),"0"));  /*(27) column 추가공제_경로우대70 : ADDR_RPT70 1946.12.31 */   
                            C_RecStr = C_RecStr   + String.format("%08d", mTempData02) ;
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrHdrc"),"0"));  /*(28) column 추가공제_장애인수 : ADDR_HDRC */    
                            C_RecStr = C_RecStr   + String.format("%02d",mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrHdam"),"0"));   /*(28) column 추가공제_장애인 금액 : ADDR_HDAM */     
                            C_RecStr = C_RecStr   + String.format("%08d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrFame"),"0")); /*(29) column 추가공제_부녀자  금액 : ADDR_FAME */      
                            C_RecStr = C_RecStr   + String.format("%08d", mTempData02);


                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("pantOnam"),"0"));   /*(30) column 추가공제_한부모공제금액 : PANT_ONAM */         
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
 
                            //연금보험료공제 
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jbnatDdct"),"0"));    /*(31) column_국민연금보험료공제 : JNAT_DDCT */       
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jpssHpul"),"0"));    /*(32)-가 column  _공무원연금보험료공제 : JPSS_HPUL */   
                            C_RecStr = C_RecStr  + String.format("%010d",  mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jpssHsol"),"0"));    /*(32)-나 column 주근무지_국민연금외군인연금공제 : JPSS_HSOL */  
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jpssHtec"),"0"));    /*(32)-다 column 주근무지_국민연금외교직원연금공제 : JPSS_HTEC */ 
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jbssDdct"),"0"));        /*(32)-라 column_별정우체국연금보험료공제 : JPSS_DDCT */   
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
                            
                        //  mTempData02 = oraQrySelect02.FieldByName('JRTR_HICT').AsFloat ;                //퇴직연금-과학기술인공제  ---
                        //  C_RecStr = C_RecStr  + FormatFloat('0000000000', mTempData02) ;
                        //  mTempData02 = oraQrySelect02.FieldByName('JBRTR_PSRN').AsFloat;                 //퇴직연금-근로자보장법  ----
                        //  C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02) ; 
                        //  mTempData02 = oraQrySelect02.FieldByName('JRTR_HNSV').AsFloat;                 //퇴직연금-연금저축  --------
                        //  C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02) ;

                            //특별소득공제 
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciJbhth"),"0"));   /*(33)-가 column 특별공제_주건강보험료 : SPCI_JHTH */   
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciJbepf"),"0"));    /*(33)-나 column 특별공제_주고용보험료 : SPCI_JEPF */   
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
                         //   mTempData02 = oraQrySelect02.FieldByName('SPCI_GURT').AsFloat ;                  //일반보장성보험료
                         //   C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
                         //   mTempData02 = oraQrySelect02.FieldByName('SPCI_HDRC').AsFloat;                   //장애인전용보험료
                         //   C_RecStr = C_RecStr  + FormatFloat('0000000000', mTempData02);
                         //  mTempData02 = oraQrySelect02.FieldByName('SPCI_HBPS').AsFloat ;                  //의료비공제금액_장애인
                         //  C_RecStr = C_RecStr  + FormatFloat('0000000000', mTempData02) ;
                         //   mTempData02 = oraQrySelect02.FieldByName('SPCI_METO').AsFloat ;                  //의료비공제금액
                         //  C_RecStr = C_RecStr  + FormatFloat('0000000000', mTempData02) ;
                         //  mTempData02 = oraQrySelect02.FieldByName('SPCI_SPEC').AsFloat ;                  //교육비공제금액_장애인
                         //  C_RecStr = C_RecStr   + FormatFloat('00000000', mTempData02)  ;
                         //   mTempData02 = oraQrySelect02.FieldByName('SPED_TOAM').AsFloat ;                  //교육비공제금액
                         //   C_RecStr = C_RecStr   + FormatFloat('00000000', mTempData02)  ;

                            
                           // 주택자금(주택임차차입금,장기주택저당차입금,주택마련저축) 관련공통사항 
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciRefn"),"0"));            /*(34)-가 column 특별공제_차입금원리금상환액_대출기관 : SPCI_REFN */   
                            C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciResf"),"0"));               /*(34)-가 column 특별공제_차입금원리금상환액_거주자 : SPCI_RESF */ 
                            C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ; 
                            
                           // mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("befoScnt"),"0")); oraQrySelect02.FieldByName('SPCI_HTAM').AsFloat ;                   //주택자금-월세액 대상금액
                           // C_RecStr = C_RecStr   + FormatFloat('00000000', mTempData02); 
                                                       
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spchRe15"),"0"));    /*(34)-나 column 특별공제_11장기주택저당차입금15 : SPCH_RE15 */  
                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spchRe29"),"0"));      /*(34)-나 column 특별공제_11장기주택저당차입금29 : SPCH_RE29 */   
                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spchRe30"),"0"));      /* (34)-나column 특별공제_11장기주택저당차입금30 : SPCH_RE30 */   
                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02); 
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciRefx"),"0"));     /*(34)-나 column 특별공제_12장기주택저당차입금_고정 : SPCI_REFX */     
                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciReec"),"0"));    /*(34)나 column 특별공제_12장기주택저당차입금_기타 : SPCI_REEC */
                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
                            
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spci15fx"),"0"));   /*(34)-나 column 특별공제_15장기주택저당_15고정AND비거치상환 : SPCI_15FX */
                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spci15fb"),"0"));     /*(34)-나 column 특별공제_15장기주택저당_15고정OR비거치상환 : SPCI_15FB */
                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spci15ec"),"0"));     /*(34)-나 column 특별공제_15장기주택저당_15기타대출 : SPCI_15EC */
                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spci10fb"),"0"));      /*(34)-나 column 특별공제_15장기주택저당_10고정OR비거치상환 : SPCI_10FB */
                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
 
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciSsum"),"0"));     /*(35) column 이월분  특별공제_기부금공제액계 : SPCI_SSUM */    
                            C_RecStr = C_RecStr   + String.format("%011d", mTempData02);

                            // mTempData02 = oraQrySelect02.FieldByName('SPCI_PLTC').AsFloat ;                  //기부금공제금액 _정치
                           // C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
                           //  mTempData02 = oraQrySelect02.FieldByName('SPCI_FBAM').AsFloat ;                  //기부금공제금액_법정
                           // C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
                          //   mTempData02 = oraQrySelect02.FieldByName('SPCI_RFAM').AsFloat ;                  //기부금공제금액_우리사주조합기부금
                           // C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
                           //  mTempData02 = oraQrySelect02.FieldByName('SPCI_NYAM').AsFloat ;                  //기부금공제금액_지정기부금
                          //  C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
                           // C_RecStr = C_RecStr   + "00000000000000000000" ;  //공란 

                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spsmTotl"),"0"));   /*96  (36)    //특별소득공제 계  */
                            C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);
                            //mTempData02 =  oraQrySelect02.FieldByName('SPCI_DDCT').AsFloat;                 //표준공제
                            //C_RecStr = C_RecStr  + FormatFloat('00000000', mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtEram"),"0"));       /* (97) column 차감소득금액 : SUBT_ERAM */  
                            C_RecStr = C_RecStr  + String.format("%011d", mTempData02);
                            
                            //그 밖의 소득공제  
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etcpPsnv"),"0"));     /* (98)column 개인연금저축불입액_2000년이전 : ETCP_PSNV */  
                            C_RecStr = C_RecStr   + String.format("%08d", mTempData02);
                       //     mTempData02 = oraQrySelect02.FieldByName('ETCP_NSAV').AsFloat;                 //연금저축소득공제
                        //    C_RecStr = C_RecStr  + FormatFloat('00000000', mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etchPrep"),"0"));    /* (99) column 기타공제_소기업공제불입금 : ETCH_PREP */    
                            C_RecStr = C_RecStr  + String.format("%010d", mTempData02);

                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etcsComp"),"0"));   /*(100)-가 column 기타공제_주택마련저축_청약저축 : ETCS_COMP */       
                            C_RecStr = C_RecStr  + String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etwkSbam"),"0"));    /* (101)-나column 기타공제_주택마련저축_주택청약종합저축 : ETWK_SBAM */       
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                          //  mTempData02 = oraQrySelect02.FieldByName('ETWK_LGAM').AsFloat ;                  //장기주택마련저축
                          //  C_RecStr = C_RecStr   + FormatFloat('0000000000',mTempData02) ;
                            mTempData02 =Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etwkSvam"),"0"));   /*(102)-다 column 기타공제_주택마련저축_근로자주택마련저축 : ETWK_SVAM */
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etgdDdam"),"0"));        /* (103) column 기타공제_투자조합출자공제액 : ETGD_DDAM */   
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etccCard"),"0"));     /*(104) column 기타공제_신용카드등사용액소득공제 : ETCC_CARD */ 
                            C_RecStr = C_RecStr   + String.format("%08d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etckUnon"),"0"));       /*(105) column 기타공제_우리사주출연금공제 : ETCK_UNON */      
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);

                          //  mTempData02 = Long.parseLong("0");                  //우리사주조합기부금
                          //  C_RecStr = C_RecStr   + "00000000000";

                            //mTempData02 = oraQrySelect02.FieldByName('ETCL_HMTO').AsFloat  ;                 //장기주식형저축소득공제
                           // C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);

                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etepMsam"),"0"));       /*(45) column 기타공제_고용유지중소기업근로자임금삭감공제액 : ETEP_MSAM */ 
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);

                          //  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etgdHtra"),"0"));       /*(46) column 기타공제_목돈안드는전세이자상환소득공제액 : ETGD_HTRA */        
                            C_RecStr = C_RecStr   + "0000000000";                                                       //String.format("%010d",  mTempData02)  ;

                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etepSecr"),"0"));      /*(47) column 기타공제_장기집합투자증권저축공제액 : ETEP_SECR */  
                             C_RecStr = C_RecStr   + String.format("%010d",  mTempData02)  ;

                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etclTotl"),"0"));      /*(48) column 기타공제_공제계 : ETCD_TSUM */   
                            C_RecStr = C_RecStr  + String.format("%011d",  mTempData02);

                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spchExli"),"0"));     /*(49) column 특별공제_종합한도초과금액 : SPCH_EXLI */     
                            C_RecStr = C_RecStr   + String.format("%011d",  mTempData02) ;


                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("stndIncm"),"0"));     /*(50) column 종합소득과세표준 : STND_INCM */        
                            C_RecStr = C_RecStr   + String.format("%011d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("prddTaxn"),"0"));         /*(51) column 산출세액 : PRDD_TAXN */         
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;

                            //------------------------ 세액감면 ------------------------------ 
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdIcax"),"0"));     /*(52) column 세액감면_소득세법 : TAXD_ICAX */    
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdSpct"),"0"));     /*(53) column 세액감면_조세특례법 : TAXD_SPCT */        
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02)  ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("txlgCl30"),"0"));  /*(54) column 세액감면_조세특례법제30조 : TXLG_CL30 */   
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02)  ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("txlgHxtt"),"0"));    /*(55) column 세액감면_조세조약 : TXLG_HXTT */   
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
                         //   mTempData02 = oraQrySelect02.FieldByName('PAYR_TEMP126').AsFloat ;              // 공란
                         //   C_RecStr = C_RecStr   +  "0000000000"  ; 
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdTsum"),"0"));       /*(56) column 세액감면_감면세액계 : TAXD_TSUM */     
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);


                            // ------------------------ 세액공제 -------------------------------------------------------
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdWken"),"0"));      /*(57) column 세액공제_근로소득세액공제 : TAXD_WKEN */ 
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;

                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrMrct"),"0"));               //다자녀추가공제인원 -----
                             C_RecStr = C_RecStr   + String.format("%02d", mTempData02);
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrMccr"),"0"));         //자녀세액공제
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;


                       //     mTempData02 = oraQrySelect02.FieldByName('ADDR_MCAM').AsFloat;                 //다자녀추가공제금액 ------
                      //      C_RecStr = C_RecStr  + FormatFloat('00000000', mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrClct"),"0"));             //6세이하공제인원  -----
                            C_RecStr = C_RecStr   + String.format("%02d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrChld"),"0"));              //6세이하공제금액 -------
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrBhct"),"0"));              //출산입양자공제인원 --------
                            C_RecStr = C_RecStr   + String.format("%02d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrBrth"),"0"));            // 출산입양자공제금액 ---------
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;



                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrCtar"),"0"));                  //연금계좌_과학기술인공제_공제대상금액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrHict"),"0"));                  //연금계좌_과학기술인공제_세액공제액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrPtar"),"0"));               //연금계좌_근로자퇴직 급여보장법에 따른 퇴직급여 공제대상금액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrPsrn"),"0"));                //연금계좌_근로자퇴직 급여보장법에 따른 퇴직급여 공제액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrAtar"),"0"));               //연금계좌_ 연금저축 공제대상금액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrHnsv"),"0"));              //연금계좌_연금저축 세액공제액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;

                            //mTempData02 = oraQrySelect02.FieldByName('SPCI_DETG').AsFloat ;                 //특별세액공제_보장성보험료_공제대상금액
                            //C_RecStr = C_RecStr   + FormatFloat('0000000000',mTempData02) ;
                            //mTempData02 = oraQrySelect02.FieldByName('SPCI_RTDE').AsFloat ;                 //특별세액공제_보장성보험효 세액공제액
                            //C_RecStr = C_RecStr   + FormatFloat('0000000000',mTempData02) ;

                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciRttg"),"0"));                //특별세액공제_보장성보험료_공제대상금액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciGurt"),"0"));               // //특별공제_일반보장성보험료 세액공제액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciHdtg"),"0"));              //특별공제_장애인보장성대상금액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciHdrc"),"0"));                  //특특별공제_장애인보장성보험료 세액공제액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;


                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciDtar"),"0"));                 //특별세액공제_의료비_공제대상금액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciTxcr"),"0"));               //특별세액공제_의료비_세액공제액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spedEtar"),"0"));                 //특별세액공제_교육비_공제대상금액SPED_SFTR
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spedTxcr"),"0"));                 //특별세액공제_교육비_세액공제
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxd10tg"),"0"));                //특별세액공제_기부금_정치자금_10만원이하 공제 대상금액
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;

                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdPltc"),"0"));                  //특별세액공제_기부금_정치자금_10만원이하 공제
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciPltg"),"0"));                   //특별세액공제_기부금_정치자금_10만원초과  공제 대상금액
                            C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciPltc"),"0"));                 //특별세액공제_기부금_정치자금_10만원초과  공제
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciFbtg"),"0"));                 //특별세액공제_기부금_법정기부금 공제 대상금액
                            C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciFbam"),"0"));                 //특별세액공제_기부금_법정기부금 공제
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciHftg"),"0"));   /* (65)-다column 우리사주종합기부대상금액 : SPCI_HFTG */
                            C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spcirfam"),"0"));    /*(65)-다 column 특별공제_기부금_우리사주조합세액공제액 : SPCI_RFAM */
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                             

                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciNatg"),"0"));                /*(65)-라 column  2014년이후 기부금합게 종교단체외지정대상금액 : SPCI_NATG */
                            C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciNamt"),"0"));                 /*(65)-라 column 특별공제_기부금_특별공제_기부금_종교단체외 : SPCI_NAMT */
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            
                            
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciYatg"),"0"));                 /*(65)-라 column  2014년이후 기부금합게 종교단체지정대상금액 : SPCI_YATG */
                            C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ; 
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciYamt"),"0"));                /*(65)-라 column 특별공제_기부금_특별공제_기부금_종교단체 : SPCI_YAMT */
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                          
                            
                            
                        //     mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciNyag"),"0"));                 //특별세액공제_기부금_지정기부금 공제대상금액
                        //    C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
                        //     mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciNyam"),"0"));                 //특별세액공제_기부금 지정기부금 세액
                        //    C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                           
                            
                           // SPCI_NATG	종교단체외지정대상금액	 
                           // SPCI_YATG	종교단체지정대상금액	 
                            
                            
                            
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciDcto"),"0"));                 //특별세액공제 계
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciDdct"),"0"));              //표준 세액 공제
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;




                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdUnin"),"0"));               //납세조합공제
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdLoan"),"0"));              //주택차입금
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
                         //   mTempData02 = oraQrySelect02.FieldByName('TAXD_PLTC').AsFloat ;                  //기부정치자금
                          //  C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdPaid"),"0"));               //외국납부
                            C_RecStr = C_RecStr  + String.format("%010d",  mTempData02) ;
                            
                            
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciTgrt"),"0"));     /*(71) column 특별공제_월세세액공제대상금액 : SPCI_TGRT */ 
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;        
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciRtam"),"0"));            //    월세 세액 공제
                            C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdCsum"),"0"));               //세액공제계
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;

                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dcsnIncm"),"0"));               //소득세
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dcsnInhb"),"0"));                //지방소득세
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dcsnFafv"),"0"));                  //농특세
                            C_RecStr = C_RecStr    + String.format("%010d", mTempData02);
                         //   mTempData02 = oraQrySelect02.FieldByName('DCSN_TOTL').AsFloat;                  //합계
                         //   C_RecStr = C_RecStr    + FormatFloat('0000000000', mTempData02) ;
                            
                            //기납부세액 - 주현근무지  
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("alryPinx"),"0"));       //기납부소득세
                            C_RecStr = C_RecStr    + String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("alryPhbx"),"0"));                  //기납부지방소득세
                            C_RecStr = C_RecStr    + String.format("%010d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("alryYvtx"),"0"));               //기납부농특세
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);

                            
                            //계산에 의해처리 해야 함......todo 
                             C_RecStr = C_RecStr   +  "0000000000"  ;          //납부특례세액 _소득세
                             C_RecStr = C_RecStr   +  "0000000000"  ;            //납부특례세액 _지방소득세
                             C_RecStr = C_RecStr   +  "0000000000"  ;           //납부특례세액 _농특세 


                         //   mTempData02 = oraQrySelect02.FieldByName('ALRY_TOTL').AsFloat ;
                         //   C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtEtaxb"),"0"));           //소득세음양
                            C_RecStr = C_RecStr   + String.format("%01d",  mTempData02)  ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtEtax"),"0"));        //소득세
                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtInhbb"),"0"));          //지방소득세음양
                            C_RecStr = C_RecStr  + String.format("%01d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtInhb"),"0"));          //지방소득세
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtFafvb"),"0"));           //농특세음양
                            C_RecStr = C_RecStr   + String.format("%01d", mTempData02);
                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtFafv"),"0"));              //농특세
                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
                         //   mTempData02 = oraQrySelect02.FieldByName('SUBT_AMSUB').AsFloat ;
                        //    C_RecStr = C_RecStr   + FormatFloat('0', mTempData02);
                         //   mTempData02 = oraQrySelect02.FieldByName('SUBT_AMSU').AsFloat;
                        //    C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
                            C_RecStr = C_RecStr   + String.format("%-15s", "") ;
                             
              
               TOT_Record.add(C_RecStr);

               D_Cnt = 1; 
               
               //fnPayrD_ReTax_Total_Select
               yeta1000Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
               
               List listYetaD = yeta1400PayrService.fnPayrD_ReTax_Total_Select(yeta1000Vo);
               
          	 
 
               if (listYetaD.size() > 0) { 

              	  Iterator<Map<String, Object>> iter01 = listYetaD.iterator(); 
             	   
                   while ( iter01.hasNext() ) { 
                    	
                     Map<String, Object> mapYetaD = (Map<String, Object>) iter01.next(); 
                     
                     mTempData02 = 0L;
                     D_RecStr = "";
                     D_RecStr = "D" + "20" + yeta1000Vo.getTaxaCode();
                                 D_RecStr = D_RecStr +   String.format("%06d", C_Cnt);  
                                 D_RecStr = D_RecStr +  String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""));
                                 D_RecStr = D_RecStr + String.format("%50s", "")  + String.format("%-13s", StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnRegnNum"),""),"-",""));
                            
                                 //근무처별 소득 명세 - 종전근무처 
                                 D_RecStr = D_RecStr + "2" ;  //todo 납세조합구분자 필요 
                                 D_RecStr = D_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaD.get("siteCtnt"),"") ,38),40," ") ;
                                 D_RecStr = D_RecStr + String.format("%-10s", MSFSharedUtils.defaultNulls(mapYetaD.get("siteNumb"),""))  ;
                                 D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("jeymStdt"),"0"))); 
                                 D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("jeymEddt"),"0"))); 
                                 D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("jutrStdt"),"0"))); 
                                 D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("jutrEddt"),"0"))); 
                               
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("payrTotl"),"0"));  
                                 D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("bonsAmnt"),"0")); 
                                 D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("dtmnBtam"),"0")); 
                                 D_RecStr = D_RecStr +  String.format("%011d", mTempData02);
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("stckPrft"),"0")); 
                                 D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("unonAmnt"),"0")); 
                                 D_RecStr = D_RecStr +  String.format("%011d",mTempData02);

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("ofrrExli"),"0")); 
                                 D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
 
                                 D_RecStr = D_RecStr + "0000000000000000000000" ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("payrBtot"),"0")); 
                                 D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
                                  
                                 //종전근무지 비과세소득 및 감면소득  
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSg01"),"0"));  
                                 C_RecStr = C_RecStr   + String.format("%010d", mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh01"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh05"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh06"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh07"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh08"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh09"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh10"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh14"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh15"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh11"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh12"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh13"),"0"));  
                                C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;
                                mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh16"),"0"));  
                                C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;
                                mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSi01"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSk01"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm01"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm02"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm03"),"0"));  
                                  C_RecStr = C_RecStr  +  String.format("%010d",  mTempData02) ;
                                  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSo01"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d", mTempData02)  ;
                                 mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSq01"),"0")); 
                                  C_RecStr = C_RecStr  +  String.format("%010d", mTempData02) ;
                                  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSr10"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSs01"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt01"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy02"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy03"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy04"),"0"));  
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy21"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy22"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt10"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt11"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt12"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 
                                 
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt20"),"0")); 
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp51"),"0"));    //비과세계
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp52"),"0"));   //감면소득계
                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
                                     

                                // mTempData02 = oLong.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("JUTR_EDDT"),"0"));raQrySelect03.FieldByName('TAXE_TOTL').AsFloat ;
                              //   D_RecStr = D_RecStr +  FormatFloat('0000000000', mTempData02);
                                //  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("JUTR_EDDT"),"0"));oraQrySelect03.FieldByName('PAYR_TEMP55').AsFloat ;
                                 D_RecStr = D_RecStr + "0000000000";
                                 
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("EARN_TAXN"),"0")); 
                                 D_RecStr = D_RecStr +  String.format("%010d", mTempData02);
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("IHTX_TAXN"),"0")); 
                                 D_RecStr = D_RecStr +  String.format("%010d", mTempData02);
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("FARM_TAXN"),"0")); 
                                 D_RecStr = D_RecStr +  String.format("%010d", mTempData02);
                                // mTempData02 =  oraQrySelect03.FieldByName('FARM_BTOT').AsFloat ;
                               //  D_RecStr = D_RecStr  +  FormatFloat('0000000000',mTempData02);
                                 D_RecStr = D_RecStr +  String.format("%02d",  D_Cnt);
                                 D_RecStr = D_RecStr + String.format("%961s", ""); 
 
                     
                      TOT_Record.add(D_RecStr);

                    
                    D_Cnt = D_Cnt + 1;
                   }
               }

               //E레코드
               E_Cnt = 1;
               E_RowCnt = 1;
               E_RecStr = "";

              yeta1000Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
               
               List listYetaE = yeta1400PayrService.fnPayrE_ReTax_Total_Select(yeta1000Vo);
               
          	 
 
               if ( listYetaE.size() > 0) { 

              	  Iterator<Map<String, Object>> iter03 = listYetaE.iterator(); 
             	   
                   while ( iter03.hasNext() ) { 
                    	
                     Map<String, Object> mapYetaE = (Map<String, Object>) iter03.next(); 
                     
               
                      mTempData02 = 0L;
                      
                   // 주민번호(복호화)
      				 rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaC.get("resnRegnNum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
      		          	 
                      
                      E_RecStr =  "E" + "20" + yeta1000Vo.getTaxaCode() +  String.format("%06d", C_Cnt)
                                 +  String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""))
                                 + String.format("%-13s", StringUtils.replace(rrnDecCrypt,"-",""));

                 if (listYetaE.size() + 1 > E_RowCnt)  {

                          // E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  
                      
                      /** (CASE WHEN YETA3220.RELH_CODE IN ('A0190001')  THEN 0       
				           WHEN YETA3220.RELH_CODE IN ('A0190003','A0190004','A0190009','A0190010','A0190017','A0190018','A0190019','A0190053','A0190054','A0190055','A0190056','A0190051','A0190050','A0190078','A0190079')  THEN 1  
				           WHEN YETA3220.RELH_CODE IN ('A0190011','A0190012','A0190013')  THEN 2                                                                                         
				           WHEN YETA3220.RELH_CODE IN ('A0190002','A0190007')  THEN 3                                                                                                                          
				           WHEN YETA3220.RELH_CODE IN ('A0190005')  THEN 4   
				           WHEN YETA3220.RELH_CODE IN ('A0190040','A0190032','A0190099','A0190076' ,'A0190100')  THEN 5                                                                                                                         
				           WHEN YETA3220.RELH_CODE IN ('A0190038','A0190022','A0190021','A0190020','A0190023','A0190025','A0190033','A0190035','A0190037','A0190051','A0190052','A0190089','A0190053','A0190090','A0190091','A0190032')  THEN 6            
				           WHEN YETA3220.RELH_CODE IN ('A0190109')  THEN 7                            
				           WHEN YETA3220.RELH_CODE IN ('A0190100')  THEN 8  END )  AS RELH_CODE,  */
                      
                                  E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드 
                                  E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," "); 
                                  E_RecStr = E_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")   ;
                               
                               // 주민번호(복호화)
                  				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                  		          	 
                                  E_RecStr = E_RecStr+ rrnDecCrypt;  
                                  
                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  

                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  

                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  

                                  //소득공제국세청자료 
                                  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;

                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;


                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
                                  E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;

                                  //소득공제자료 기타자료 
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
                                  E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                    mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;


                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
                                  E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;


                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
                                   E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                    mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
                                  E_RecStr = E_RecStr+   String.format("%013d",mTempData02);
                                
                                  E_RowCnt =  E_RowCnt + 1;
                                 try {
                                	  mapYetaE = (Map<String, Object>) iter03.next(); 
                              	 } catch (NoSuchElementException e) {
                              		//e.printStackTrace();
                              	 }   

                 }
                 else
                 {
                       E_RecStr = E_RecStr + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%20s","")
                                  + String.format("%13s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000"
                                  + "0000000000000";
 
                        E_RowCnt =  E_RowCnt + 1;
                 }
                 
                 if (listYetaE.size() + 1 > E_RowCnt)  {

                  //   E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," "); 
                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드 
                                 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," ");   
                                 E_RecStr = E_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")  ;
                                
                                 // 주민번호(복호화)
                 				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                 		          	 
                 				  
                                 E_RecStr = E_RecStr+ rrnDecCrypt;  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  

                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  

                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  

                                 mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;


                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
                                 E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;


                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;


                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
                                 E_RecStr = E_RecStr+   String.format("%013d",mTempData02);
                                 E_RowCnt =  E_RowCnt + 1;
                                 try {
                               	  mapYetaE = (Map<String, Object>) iter03.next(); 
                             	 } catch (NoSuchElementException e) {
                             		//e.printStackTrace();
                             	 }     
                     

                }
                else
                {
                      E_RecStr = E_RecStr + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%20s","")
                                 + String.format("%13s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000000";

                       E_RowCnt =  E_RowCnt + 1;
                }

                 if (listYetaE.size() + 1 > E_RowCnt)  {

                     //E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  
                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드   
                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," ");   
                                 E_RecStr = E_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")  ;
                               
                                 // 주민번호(복호화)
                				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                		          
                				  
                                 E_RecStr = E_RecStr+ rrnDecCrypt;  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  

                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  

                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  

                                 mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;


                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
                                 E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;


                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;


                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
                                 E_RecStr = E_RecStr+   String.format("%013d",mTempData02);
                                 E_RowCnt =  E_RowCnt + 1;
                                 try {
                               	  mapYetaE = (Map<String, Object>) iter03.next(); 
                             	 } catch (NoSuchElementException e) {
                             		//e.printStackTrace();
                             	 }     
                       

                }
                else
                {
                      E_RecStr = E_RecStr + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%20s","")
                                 + String.format("%13s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000000";

                       E_RowCnt =  E_RowCnt + 1;
                }
                 if (listYetaE.size() + 1 > E_RowCnt)  {

                    // E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  
                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드  
                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," ");   
                                 E_RecStr = E_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")   ;
                                
                                 // 주민번호(복호화)
               				     rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
               		          
                                 E_RecStr = E_RecStr+ rrnDecCrypt;  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  

                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  

                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  

                                 mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;


                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
                                 E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;


                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;


                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
                                 E_RecStr = E_RecStr+   String.format("%013d",mTempData02);
                                 E_RowCnt =  E_RowCnt + 1;
                                 try {
                               	  mapYetaE = (Map<String, Object>) iter03.next(); 
                             	 } catch (NoSuchElementException e) {
                             		//e.printStackTrace();
                             	 }     
                     

                }
                else
                {
                      E_RecStr = E_RecStr + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%20s","")
                                 + String.format("%13s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000000";

                       E_RowCnt =  E_RowCnt + 1;
                }
                 
                 if (listYetaE.size() + 1 > E_RowCnt)  {

                   //  E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  
                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드 
                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," ");   
                                 E_RecStr = E_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")  ;
                               
                                 // 주민번호(복호화)
               				     rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
               		          
                                 
                                 E_RecStr = E_RecStr+ rrnDecCrypt;  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  

                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  

                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  

                                 mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;


                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
                                 E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;


                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;


                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
                                 E_RecStr = E_RecStr+   String.format("%013d",mTempData02);

//                                 try {
//                               	  mapYetaE = (Map<String, Object>) iter03.next(); 
//                             	 } catch (NoSuchElementException e) {
//                             		//e.printStackTrace();
//                             	 }      
                       E_RowCnt =  E_RowCnt + 1;

                }
                else
                {
                      E_RecStr = E_RecStr + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%20s","")
                                 + String.format("%13s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + String.format("%1s","")
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000"
                                 + "0000000000000";

                       E_RowCnt =  E_RowCnt + 1;
                }
                 E_RecStr = E_RecStr +  String.format("%02d",  E_Cnt)
                                  + String.format("%293s", "") ;

                       TOT_Record.add(E_RecStr);

                       E_Cnt = E_Cnt + 1;
                       E_RecStr = ""; 

                   }
               }

              // F레코드  - 연금저축등 소득세액공제명세 레코드 

               F_Cnt = 1;
               F_RowCnt = 1;
               F_RecStr = "";
              
               yeta1000Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
               
               List listYetaF = yeta1400PayrService.fnPayrF_ReTax_Total_Select(yeta1000Vo);
                
 
               if ( listYetaF.size() > 0) { 

              	  Iterator<Map<String, Object>> iter04 = listYetaF.iterator(); 
             	   
                   while ( iter04.hasNext() ) { 
                    	
                     Map<String, Object> mapYetaF = (Map<String, Object>) iter04.next(); 
    
                    mTempData02 = 0L;

                 // 주민번호(복호화)
    				 rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnRegnNum"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
    		          	 
                   F_RecStr =  "F" + "20" + yeta1000Vo.getTaxaCode() +  String.format("%06d", C_Cnt) + String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""))
                                  + String.format("%-13s",rrnDecCrypt ) ;
 
                   
                 if (listYetaF.size() + 1 > F_RowCnt)  {
                  
                                F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                                   + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                                   + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                                   + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
                                   mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                                   F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                                   mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                                   F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


                          F_RowCnt =  F_RowCnt + 1;
                          
                          try {
                        	  mapYetaF = (Map<String, Object>) iter04.next(); 
                         	 } catch (NoSuchElementException e) {
                         		//e.printStackTrace();
                         	 }      
                          
                 }
                 else
                 {
                        F_RecStr = F_RecStr + String.format("%-2s","")
                                   + String.format("%-3s","")
                                   +  String.format("%-50s","")
                                   + String.format("%-20s","")
                                   +  "0000000000"
                                   +  "0000000000";

                        F_RowCnt =  F_RowCnt + 1;
                 }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                         + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                         + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                         + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                         + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                         + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                         + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                         + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                         + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                         + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
               try {
             	  mapYetaF = (Map<String, Object>) iter04.next(); 
              	 } catch (NoSuchElementException e) {
              		//e.printStackTrace();
              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }

                 if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
                        + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;


               F_RowCnt =  F_RowCnt + 1;
//               try {
//             	  mapYetaF = (Map<String, Object>) iter04.next(); 
//              	 } catch (NoSuchElementException e) {
//              		//e.printStackTrace();
//              	 }     
      }
      else
      {
             F_RecStr = F_RecStr + String.format("%-2s","")
                        + String.format("%-3s","")
                        +  String.format("%-50s","")
                        + String.format("%-20s","")
                        +  "0000000000"
                        +  "0000000000";

             F_RowCnt =  F_RowCnt + 1;
      }


                 F_RecStr = F_RecStr + String.format("%-160s","");
                       TOT_Record.add(F_RecStr);


                       F_Cnt = F_Cnt + 1;

                       F_RecStr = "";  

                   }
               }


               //---------------------------------------------------------------------------------
               //G레코드 - 월세 거주간 주택임차 차입금 원리금 상환액 소득공제명세 레코드  
               //---------------------------------------------------------------------------------
               
               G_Cnt = 1;
               G_RowCnt = 1;
               G_RecStr = "";
               
               yeta1000Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
               
               List listYetaG = yeta1400PayrService.fnPayrG_ReTax_Total_Select(yeta1000Vo);
                
 
               if ( listYetaG.size() > 0) { 
 
              	   Iterator<Map<String, Object>> iter05 = listYetaG.iterator(); 
             	   
                   while ( iter05.hasNext() ) { 
                    	
                     Map<String, Object> mapYetaG = (Map<String, Object>) iter05.next(); 
                           
                    
                     if ((listYetaG.size() > 0) &&  (MSFSharedUtils.paramNotNull( mapYetaG.get("mnrnName")) 
                     ||  MSFSharedUtils.paramNotNull( mapYetaG.get("cnclName")) || MSFSharedUtils.paramNotNull( mapYetaG.get("leasName"))))  {
                     
                    	// 주민번호(복호화)
         				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnRegnNum"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
         		          	 
                       mTempData02 = 0L;

                       G_RecStr =  "G" + "20" + yeta1000Vo.getTaxaCode()  +  String.format("%06d", C_Cnt) +  String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""))
                                      + String.format("%-13s",rrnDecCrypt) ;

                       
                       if (listYetaG.size() + 1 > G_RowCnt)  {
                      
                    	// 주민번호(복호화)
          				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnRsno"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
          		          	 
                                    G_RecStr = G_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnName"),""),18),20," ")  
                                       +  String.format("%-13s", rrnDecCrypt);
                                   
                                       G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnTyhu"),"") );
                                       G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnArea"),"0.00")))),".","");     //소숫점처리

                                       G_RecStr = G_RecStr +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAddr"),"") ,98),100," ")  ;

                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnStdt"),"") ;
                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnEddt"),"") ;

                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAmnt"),"0"));  
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnDuam"),"0"));   
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;


                                        G_RecStr = G_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclName"),"") ,18),20," ") 
                                       + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRsno"),"") ) ;
                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclStdt"),"") ;
                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclEddt"),"")  ;

                                       G_RecStr = G_RecStr +  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItro"),"0.00")))),".","") ;     //소숫점처리

                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRdmt"),"0")); 
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
                                        mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclPrpl"),"0"));
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItrt"),"0"));
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclDuam"),"0"));
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02);


                                      G_RecStr = G_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("leasName"),"") ,18),20," ")  
                                       + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("leasRsno"),"")  );

                                       G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("leasTyhu"),"")   );
                                       G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("leasArea"),"0.00")))),".","")  ;     //소숫점처리

                                       G_RecStr = G_RecStr +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("leasAddr"),"") ,98),100," ") ;
                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasStdt"),"") ;
                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasEddt"),"")  ;

                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("leasDpst"),"0"));   
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02);

                              G_RowCnt =  G_RowCnt + 1;
                              try {
                            	  mapYetaG = (Map<String, Object>) iter05.next(); 
                             	 } catch (NoSuchElementException e) {
                             		//e.printStackTrace();
                             	 }     
                              
                       }
                     else
                     {
                            G_RecStr = G_RecStr + String.format("%-20s","")
                                       + String.format("%-13s","")
                                       + String.format("%-1s","")
                                       +  "00000"
                                       + String.format("%-100s","")
                                       +  "00000000"
                                       +  "00000000"
                                       +  "0000000000"
                                       +  "0000000000"
                                       + String.format("%-20s","")
                                       + String.format("%-13s","")
                                       +  "00000000"
                                       +  "00000000"
                                       +  "0000"
                                       +  "0000000000"
                                       +  "0000000000"
                                       +  "0000000000"
                                       +  "0000000000"
                                        + String.format("%-20s","")
                                       +  String.format("%-13s","")
                                       +  String.format("%-1s","")
                                       +  "00000"
                                       +  String.format("%-100s","")
                                       +  "00000000"
                                       +  "00000000"
                                       +  "0000000000";

                            G_RowCnt =  G_RowCnt + 1;
                     }
                       if (listYetaG.size() + 1 > G_RowCnt)  {
                           

                       	// 주민번호(복호화)
             				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnRsno"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
             		          	
             				  
                           G_RecStr = G_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnName"),"") ,18),20," ")   
                              +  String.format("%-13s",  rrnDecCrypt);

                              G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnTyhu"),"") );
                              G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnArea"),"0.00")))),".","");     //소숫점처리

                              G_RecStr = G_RecStr +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAddr"),"") ,98),100," ") ;

                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnStdt"),"") ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnEddt"),"") ;

                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAmnt"),"0"));  
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnDuam"),"0"));   
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;


                               G_RecStr = G_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("cnclName"),"") ,18),20," ")   
                              + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRsno"),"") ) ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclStdt"),"") ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclEddt"),"")  ;

                              G_RecStr = G_RecStr +  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItro"),"0.00")))),".","") ;     //소숫점처리

                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRdmt"),"0")); 
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
                               mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclPrpl"),"0"));
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItrt"),"0"));
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclDuam"),"0"));
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);


                             G_RecStr = G_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("leasName"),"") ,18),20," ")  
                              + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("leasRsno"),"")  );

                              G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("leasTyhu"),"")   );
                              G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("leasArea"),"0.00")))),".","")  ;     //소숫점처리

                              G_RecStr = G_RecStr +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("leasAddr"),"") ,98),100," ") ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasStdt"),"") ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasEddt"),"")  ;

                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("leasDpst"),"0"));   
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);

                     G_RowCnt =  G_RowCnt + 1;
                     try {
                   	  mapYetaG = (Map<String, Object>) iter05.next(); 
                    	 } catch (NoSuchElementException e) {
                    		//e.printStackTrace();
                    	 }     
              }
            else
            {
                   G_RecStr = G_RecStr + String.format("%-20s","")
                              + String.format("%-13s","")
                              + String.format("%-1s","")
                              +  "00000"
                              + String.format("%-100s","")
                              +  "00000000"
                              +  "00000000"
                              +  "0000000000"
                              +  "0000000000"
                              + String.format("%-20s","")
                              + String.format("%-13s","")
                              +  "00000000"
                              +  "00000000"
                              +  "0000"
                              +  "0000000000"
                              +  "0000000000"
                              +  "0000000000"
                              +  "0000000000"
                               + String.format("%-20s","")
                              +  String.format("%-13s","")
                              +  String.format("%-1s","")
                              +  "00000"
                              +  String.format("%-100s","")
                              +  "00000000"
                              +  "00000000"
                              +  "0000000000";

                   G_RowCnt =  G_RowCnt + 1;
            }
                       if (listYetaG.size() + 1 > G_RowCnt)  {
                           

                          	// 주민번호(복호화)
                				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnRsno"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                		          	
                				  
                           G_RecStr = G_RecStr +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnName"),"") ,18),20," ")  
                              +  String.format("%-13s",  rrnDecCrypt);

                              G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnTyhu"),"") );
                              G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnArea"),"0.00")))),".","");     //소숫점처리

                              G_RecStr = G_RecStr +  PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAddr"),"") ,98),100," ") ;

                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnStdt"),"") ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnEddt"),"") ;

                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAmnt"),"0"));  
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnDuam"),"0"));   
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;


                               G_RecStr = G_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclName"),"") ,18),20," ")  
                              + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRsno"),"") ) ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclStdt"),"") ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclEddt"),"")  ;

                              G_RecStr = G_RecStr +  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItro"),"0.00")))),".","") ;     //소숫점처리

                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRdmt"),"0")); 
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
                               mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclPrpl"),"0"));
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItrt"),"0"));
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclDuam"),"0"));
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);


                             G_RecStr = G_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("leasName"),""),18),20," ")  
                              + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("leasRsno"),"")  );

                              G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("leasTyhu"),"")   );
                              G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("leasArea"),"0.00")))),".","")  ;     //소숫점처리

                              G_RecStr = G_RecStr + PkgFuncUtils.getRPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("leasAddr"),""),98),100," ")  ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasStdt"),"") ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasEddt"),"")  ;

                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("leasDpst"),"0"));   
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);

                     G_RowCnt =  G_RowCnt + 1;
//                     try {
//                   	  mapYetaG = (Map<String, Object>) iter05.next(); 
//                    	 } catch (NoSuchElementException e) {
//                    		//e.printStackTrace();
//                    	 }     
              }
            else
            {
                   G_RecStr = G_RecStr + String.format("%-20s","")
                              + String.format("%-13s","")
                              + String.format("%-1s","")
                              +  "00000"
                              + String.format("%-100s","")
                              +  "00000000"
                              +  "00000000"
                              +  "0000000000"
                              +  "0000000000"
                              + String.format("%-20s","")
                              + String.format("%-13s","")
                              +  "00000000"
                              +  "00000000"
                              +  "0000"
                              +  "0000000000"
                              +  "0000000000"
                              +  "0000000000"
                              +  "0000000000"
                               + String.format("%-20s","")
                              +  String.format("%-13s","")
                              +  String.format("%-1s","")
                              +  "00000"
                              +  String.format("%-100s","")
                              +  "00000000"
                              +  "00000000"
                              +  "0000000000";

                   G_RowCnt =  G_RowCnt + 1;
            }          

                       G_RecStr = G_RecStr +  String.format("%02d", G_Cnt)
                                      + String.format("%-284s","");

                           TOT_Record.add(G_RecStr); 

                           G_Cnt = G_Cnt + 1;

                           G_RecStr = "";
                          

                     }
                   }
               }
 
               C_Cnt = C_Cnt + 1;  

          } 

         
	   } catch (Exception ex) {
		   ex.printStackTrace();
		   return bmResult;
      }
      
       return bmResult;
    }
    
     /**
      * 
      * <pre>
      * 1. 개요 :  의료비 지급명세서 전자파일  
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : fnYeta1400_ReTax_Yeta3140_Create
      * @date : Feb 11, 2016
      * @author : leeheuisung
      * @history : 
      *	-----------------------------------------------------------------------
      *	변경일				작성자						변경내용  
      *	----------- ------------------- ---------------------------------------
      *	Feb 11, 2016		leeheuisung				최초 작성 
      *	-----------------------------------------------------------------------
      * 
      * @param yeta1000Vo
      */
    private List<YetaMessageVO> fnYeta1400_ReTax_Yeta3140_Check(InfcPkgYeta1000VO yeta1000Vo,HttpServletResponse response) throws Exception  {
    	
    	 List<YetaMessageVO>  bmResult = new ArrayList<YetaMessageVO>();
    	
    	String DEFIN = "CA";
    	String defBUNS_LINS = StringUtils.replace(yeta1000Vo.getBusiNumb(),"-","") ; //사업자번호
    	String A_RecStr;
    	ArrayList<String> A_Record = new ArrayList<String>();    	
    	ArrayList<String> TOT_Record = new ArrayList<String>();
    	int A_Cnt;
    	Long mTempData01;    	

		//	==== 주의 ====
		//	PChar타입이 유니코드 문자열을 의미하는
		//	델파이 2009부터는 PChar 대신 PAnsiChar 를 사용하십시오.
		//  ret : LongInt;
		//	hWnd : LongWord;
		//	pszInputFilePath : PChar;
		//	pszOutputFilePath : PChar;
		//	pszPassword : PChar;
		//	option : LongInt;
		//	mStream: TMemoryStream;
    	 /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
	    // 1. 암호화 객체 생성
	     String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
	     /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/   
    	
    	try {
    		// A레코드 - 의료비지급명세서 레코드
    		List listYetaCA = yeta1400PayrService.fnPayrPSNL_ReTax_CA_Total_Select(yeta1000Vo);

    		if  (listYetaCA.size() > 0) { 
 
    		 	A_Cnt = 1;
    		
    			  Iterator<Map<String, Object>> iter = listYetaCA.iterator(); 
    	      	   
    	          while ( iter.hasNext() ) { 
    	            	
    	            Map<String, Object> mapCAData = (Map<String, Object>) iter.next(); 
    	            
    		  //	for (int i = 0 ; i < listYeta1.size() ; i++) {
    	            
    	            yeta1000Vo.setSystemkey(MSFSharedUtils.allowNulls(mapCAData.get("systemkey"))); 
    	            
    	            //A레코드 - 의료비지급명세서 레코드  내역 
    	            List listCAYeta = yeta1400PayrService.fnPayrCA_ReTax_Total_Select(yeta1000Vo);
    				
    	            Iterator<Map<String, Object>> iter01 = listCAYeta.iterator(); 
     	      	   
      	            while ( iter01.hasNext() ) { 
      	            	
      	            Map<String, Object> mapCAYeta = (Map<String, Object>) iter01.next(); 
      	            
    				//for (int j = 0 ; j < listYeta2.size() ; j++) {
    				//	infcPkgYeta3140Vo = (InfcPkgYeta3140VO)listYeta2.get(j);
    					
	    				A_RecStr = "";
						A_RecStr = "A" + "26" + yeta1000Vo.getTaxaCode(); // 3 세무서 코드 
						A_RecStr = A_RecStr + String.format("%06d", A_Cnt); // 4 순번
						A_RecStr = A_RecStr + StringUtils.replace(yeta1000Vo.getEdacPrdt(),"-","") ; // 5 제출년월일 
						A_RecStr = A_RecStr + defBUNS_LINS; // 6 사업자 등록번호
						A_RecStr = A_RecStr + String.format("%-20s", yeta1000Vo.getHomeTxid()); // 7 홈텍스 ID
						A_RecStr = A_RecStr + String.format("%-4s", yeta1000Vo.getTaxaPrcd()); // 8 세무프로그램 코드 
						A_RecStr = A_RecStr + defBUNS_LINS; // 9 사업자 등록번호
						A_RecStr = A_RecStr + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(yeta1000Vo.getJuriName() ,38),40," ") ; // 10 상호

						/* 
						10번까지는 화면에서 받아온 vo (yeta1000Vo) 이용
						이후는 select 결과 vo (infcPkgYeta3140Vo) 이용*/

						// 주민번호(복호화)
						 String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapCAData.get("resnRegnNum"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						    		          	
						
						A_RecStr = A_RecStr +    String.format("%-13s",rrnDecCrypt );     // 11 소득자 주민번호 
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAData.get("frnrYeno"),"1")); // 12 내,외국인 코드
						A_RecStr = A_RecStr + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapCAData.get("kornName"),""),28),30 ," "); // 13 성명
						
						A_RecStr = A_RecStr + String.format("%-10s", StringUtils.replace(MSFSharedUtils.defaultNulls(mapCAYeta.get("vendNumb"),""),"-",""));  // 14 지급처 사업자등록번호
						A_RecStr = A_RecStr + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapCAYeta.get("vendName"),"") ,38),40," "); // 15 지급처 상호
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.allowNulls(mapCAYeta.get("mediCfcd")));// 16 의료증빙 코드
								
						mTempData01 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapCAYeta.get("cashUect"),"0"));  
						A_RecStr = A_RecStr + String.format("%05d", mTempData01); //건수
						//A_RecStr = A_RecStr + String.format("%05d", infcPkgYeta3140Vo.getMediCfcd()); // 17 건수
						
						mTempData01 = Long.parseLong(MSFSharedUtils.defaultNulls(mapCAYeta.get("cashUeam"),"0"));   
						A_RecStr = A_RecStr + String.format("%011d", mTempData01); //금액
						//A_RecStr = A_RecStr + String.format("%011d", infcPkgYeta3140Vo.getCashUeam()); // 18 금액
						
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAYeta.get("ctifTrea"),""));   // 19 난임시술비 해당 여부
						
						// 주민번호(복호화)
						 rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapCAYeta.get("rsnoNumb"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						   
						A_RecStr = A_RecStr + String.format("%-13s",rrnDecCrypt ); // 20 주민번호 번호						
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAYeta.get("frnrCode"),"1")); // 21 내,외국인 코드
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAYeta.get("psclHpyn"),"2")); // 22 본인 등 해당여부
						A_RecStr = A_RecStr + "1"; // todo 내용 처리 23 제출대상기간 코드
						A_RecStr = A_RecStr + String.format("%19s", "");  ; // 24 공란
						
					 					
						TOT_Record.add(A_RecStr);
						
//					     String source = MSFSharedUtils.defaultNulls(mapCAYeta.get("vendName"),"");
//						
//						CharBuffer cbuffer = CharBuffer.wrap((new String(source.getBytes("EUC-KR"), "ksc5601")).toCharArray());
//						Charset utf8charset = Charset.forName("UTF-8");
//						ByteBuffer bbuffer = utf8charset.encode(cbuffer);
//					 
//					    System.out.println("vvvv[" + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(bbuffer.toString() ,38),40," ") + "]");
//						
//						CharBuffer cbuffer1 = CharBuffer.wrap((new String(source.getBytes(), "EUC-KR")).toCharArray());
//						Charset utf8charset1 = Charset.forName("ksc5601");
//						ByteBuffer bbuffer1 = utf8charset1.encode(cbuffer1);
//					 
//					    System.out.println("aaaaa[" + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(bbuffer1.toString() ,38),40," ") + "]");
//						
//					    String hex_utf8 =  encode(source, "UTF-8");
//					    System.out.println(hex_utf8);        
//					    System.out.println( decode(hex_utf8, "UTF-8").getBytes().length);
//					             
//					    String hex_euckr =  encode(source, "EUC-KR");
//					    System.out.println(hex_euckr);
//					    System.out.println( decode(hex_euckr, "EUC-KR").getBytes().length);
//					    System.out.println("ccccc[" + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(decode(hex_euckr, "EUC-KR") ,38),40," ") + "]");
//					    System.out.println( changeCharset(source, "UTF-8"));
//					    System.out.println("aaaaa[" + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(changeCharset(source, "UTF-8") ,38),40," ") + "]");
//						        
//					    System.out.println( changeCharset(source, "EUC-KR"));
//					    System.out.println("vvvvc[" + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(changeCharset(source, "EUC-KR") ,38),40," ") + "]");
						
					    
						A_Cnt = A_Cnt + 1;
	    				}
    			}
    		}
    		else {
    			throw new Exception("의료비 A레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.");  
    			//showMessage('의료비 A레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.');
    		} 
 	    	 
 	   } catch (Exception ex) {
		   ex.printStackTrace();
		   return bmResult;
 
 	 
      }
    	
    	return bmResult; 
    }
    
   
 /**
  * 
  * <pre>
  * 1. 개요 : 기부금 지급 명세서  
  * 2. 처리내용 : 
  * </pre>
  * @Method Name : fnYeta1400_ReTax_Yeta3180_Create
  * @date : 2017. 1. 20.
  * @author : atres-pc
  * @history : 
  *	-----------------------------------------------------------------------
  *	변경일				작성자						변경내용  
  *	----------- ------------------- ---------------------------------------
  *	2017. 1. 20.		atres-pc				최초 작성 
  *	-----------------------------------------------------------------------
  * 
  * @param yeta1000Vo
  * @param response
  * @return
  * @throws Exception
  */
 private List<YetaMessageVO> fnYeta1400_ReTax_Yeta3180_Check(InfcPkgYeta1000VO yeta1000Vo,HttpServletResponse response) throws Exception { 
  
	  List<YetaMessageVO>  bmResult = new ArrayList<YetaMessageVO>();
	 
	  String defBUNS_LINS  = "";
 	  String DEFIN = ""; 
 	  String A_Record = "";
 	  String B_Record = "";
 	  String C_Record = "";
 	  String D_Record = "";
 	  String E_Record = "";
 	  String F_Record = "";
 	  ArrayList<String> TOT_Record = new ArrayList<String>();
 	  int B_Cnt = 0;
 	  int C_Cnt = 0;
 	  int D_Cnt = 0;
 	  int E_Cnt = 0;
 	  int F_Cnt = 0;
 	  int E_RowCnt = 0;
 	  int C_rowCnt = 0;
 	  String RSNOSTR = "";
 	//  String E_RecStr = "";
 	//  String F_RecStr = "";
 	  String strTempDataA = "";
 	  String strTempDataB = "";
 	  String strTempDataC = "";
 	  String strTempDataD = ""; 
 	  Long mTempDataA = 0L;
 	  Long mTempDataB = 0L;
 	  Long mTempDataC = 0L;
 	  Long mTempDataD = 0L;
 	 
 
 	//{기부금지급명세서} 
 	  
 	     /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
	    // 1. 암호화 객체 생성
	     String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
	     /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/   

	     

 	        DEFIN = "H"; //기부금 

 	        defBUNS_LINS = StringUtils.replace(yeta1000Vo.getBusiNumb(),"-","");  //사업자번호
 	        strTempDataA = "";
 	        strTempDataB = "";
 	        strTempDataC = "";
 	        strTempDataD = "";
 	        mTempDataA = 0L;
 	        mTempDataB = 0L;
 	        mTempDataC = 0L;
 	        mTempDataD = 0L;

 	        A_Record = "";

// 	        strTempDataA = "A" + "27";
//
// 	        strTempDataA = strTempDataA + yeta1000Vo.getTaxaCode();   //edTAXO_FFIE.Text ;   //세무서코드 
// 	                       mTempDataA    =  Long.parseLong(StringUtils.replace(yeta1000Vo.getEdacPrdt(),"-",""));//StrToInt(StringReplace(edINCO_OUDT.Text,'-','',[rfReplaceALL]));  //제출년월일 
// 	        strTempDataA = strTempDataA  +  String.format("%08d", mTempDataA);  //FormatFloat('00000000', mTempDataA) ;   //제출년월일
// 	                       mTempDataA    =  Long.parseLong( yeta1000Vo.getIncmGbcd() );   //StrToInt(edEXPT_GBUN.Text);
// 	        strTempDataA = strTempDataA  +  String.format("%01d", mTempDataA);  //FormatFloat('0', mTempDataA);   //제출자구분
//
// 	        strTempDataA = strTempDataA  + String.format("%-6s", MSFSharedUtils.defaultNulls(yeta1000Vo.getTaxaDnum(),""));   //Format('%-6s', [edTXOF_NUMB.Text]) ; //세무대리인번호(7)
// 	        strTempDataA = strTempDataA  + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(yeta1000Vo.getHomeTxid(),18),20," "); // String.format("%-20s", yeta1000Vo.getHomeTxid()); //Format('%-20s', [edHOME_TXID.Text]) ;  //홈텍스아이디 
// 	        strTempDataA = strTempDataA  + String.format("%-4s", yeta1000Vo.getTaxaPrcd()) ;//Format('%-4s', [edTAXP_CODE.Text])  ; //세무프로그램코드
// 	        strTempDataA = strTempDataA  + String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-","")) ; //Format('%-10s', [StringReplace(edBUNS_LINS.Text,'-','',[rfReplaceALL])]) ; //사업자등록번호
// 	        strTempDataA = strTempDataA  +  PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(yeta1000Vo.getJuriName(),38),40," "); //String.format("%-40s", yeta1000Vo.getJuriName()); //  Format('%-40s', [edPROF_RSNM.Text])   ; //법인명
// 	        strTempDataA = strTempDataA  + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(yeta1000Vo.getCharDept(),28),30," "); //String.format("%-30s", yeta1000Vo.getCharDept());  //Format('%-30s', [edSELF_DEPT.Text]) ;  //담당자부서
// 	        strTempDataA = strTempDataA  + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(yeta1000Vo.getCharName(),28),30," "); 
// 	        	//	String.format("%-30s", yeta1000Vo.getCharName());  //Format('%-30s', [edSELF_NAME.Text])   ; //담당자성명
// 	        strTempDataA = strTempDataA  + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(yeta1000Vo.getCharTele(),15),15," ")  ;  //Format('%-15s', [edSELF_TELE.Text]) ;   //담당자전화번호
// 	        mTempDataA = 1L;
// 	        strTempDataA = strTempDataA  + String.format("%05d", mTempDataA);  //FormatFloat('00000',mTempDataA);  //신고자수
// 	        strTempDataA = strTempDataA  + "101" ;   //사용한글코드
// 	        strTempDataA = strTempDataA  + String.format("%12s", "");  //Format('%2s', ['']);  //공란
// 
// 	        TOT_Record.add(strTempDataA);

 	        B_Cnt = 1;
 	       
 	    try {
 	       
 	    	//B레코드 - 원천징수의무자별 집계레코드 
 	       Map mapHb = yeta1400PayrService.fnPayrHB_ReTax_Total_Select(yeta1000Vo);
 	        
 	      if (MSFSharedUtils.paramNull(mapHb)) { 
 	      	YetaMessageVO yetaMessVo = new YetaMessageVO();
 	         
 	      	yetaMessVo.setDispWindow("YETA1400");
 	      	yetaMessVo.setVeriRec("B레코드");
 	      	yetaMessVo.setVeriRecCtnt("원천징수의무자별집계레코드");
 	      	yetaMessVo.setVeriTgtName("집계");
 	      	yetaMessVo.setVeriError("B레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다.");
 	      	yetaMessVo.setVeriModCtnt("세액계산  작업 후 다시 생성 하십시요.");
 	      	
 	      	bmResult.add(yetaMessVo);
 	      }

 	       if (MSFSharedUtils.paramNull(StringUtils.replace(yeta1000Vo.getJuriNumb(),"-","")) || StringUtils.replace(yeta1000Vo.getJuriNumb(),"-","").equals("null")) {
              
              RSNOSTR = StringUtils.replace(yeta1000Vo.getResuNumb(),"-","");    //사업자주민번호 
           }
           else
           {
              RSNOSTR =  StringUtils.replace(yeta1000Vo.getJuriNumb(),"-","");   //법인번호
           } 
            
 	      
 	      //  mTempDataB = 0L;
 	       
// 	         strTempDataB   = "B" + "27";   //레코드 구분 /자료구분 
// 	         strTempDataB   =  strTempDataB + yeta1000Vo.getTaxaCode();    //세무서코드 
// 	         strTempDataB   = strTempDataB  + String.format("%06d", B_Cnt);   //일련번호 
//	         strTempDataB  = strTempDataB +  String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""));  //사업자등록번호 10
//	         strTempDataB  = strTempDataB +  PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(yeta1000Vo.getJuriName(),38),40," ");   //상호(40)
	   
	         mTempDataB   =  Long.parseLong( MSFSharedUtils.defaultNulls(mapHb.get("ctrbCnt"),"0"));    //기부금조정명세레코드수(9[7])
	         
	         mTempDataB =    Long.parseLong( MSFSharedUtils.defaultNulls(mapHb.get("yeta3180Cnt"),"0"));  //해당연도 기부명세레코드    
	          
	         mTempDataB =   Long.parseLong( MSFSharedUtils.defaultNulls(mapHb.get("ctrbAmnt"),"0"));   //기부금액총게    
	         
	         mTempDataB =  Long.parseLong( MSFSharedUtils.defaultNulls(mapHb.get("detrAmnt"),"0"));   //공제대상금액 총계 
	              
	        // strTempDataB = strTempDataB + "1" ;   //todo 제출대상기간코드
	        // strTempDataB = strTempDataB + String.format("%87s", "");     //공란
 
 
	         C_Cnt =  0; 
 	          
 	         //C 레코드 - 기부금 조정명세 레코드  
 	          List listTotData01 = yeta1400PayrService.fnPayrPSNL_ReTax_Total_Select(yeta1000Vo); 

 	          if (listTotData01.size() <= 0) { 
 	        	  
 	        	YetaMessageVO yetaMessVo = new YetaMessageVO();
 	 	         
 	 	      	yetaMessVo.setDispWindow("YETA1400");
 	 	      	yetaMessVo.setVeriRec("C레코드");
 	 	      	yetaMessVo.setVeriRecCtnt("기부금조정명세레코드");
 	 	      	yetaMessVo.setVeriTgtName("대상자");
 	 	      	yetaMessVo.setVeriError("C레코드 생성을 위한 정산대상자가 생성되지 않은것 같습니다.");
 	 	      	yetaMessVo.setVeriModCtnt("세액계산  작업 후 다시 생성 하십시요."); 
 
 			    bmResult.add(yetaMessVo);
 			 
 	          } 
 	          
 	          Iterator<Map<String, Object>> iter = listTotData01.iterator(); 
      	   
	          while ( iter.hasNext() ) { 
	            	
	            Map<String, Object> mapTotData01 = (Map<String, Object>) iter.next();  
	          
	            yeta1000Vo.setSystemkey(MSFSharedUtils.allowNulls(mapTotData01.get("systemkey")));
 	              //SYSTEMKEY 가지고 데이타 가져오기 
	            //C 레코드 - 기부금 조정명세 레코드  YETA3170
	            List listHCData = yeta1400PayrService.fnPayrHC_ReTax_Total_Select(yeta1000Vo);  
	             
	            
	            if (listHCData.size() <= 0) { 
	            		YetaMessageVO yetaMessVo = new YetaMessageVO();
	    	 	         
	     	 	      	yetaMessVo.setDispWindow("YETA1400");
	     	 	      	yetaMessVo.setVeriRec("C레코드");
	     	 	      	yetaMessVo.setVeriRecCtnt("기부금조정명세레코드");
	     	 	      	yetaMessVo.setVeriTgtName(MSFSharedUtils.allowNulls(mapTotData01.get("kornName")));
	     	 	      	yetaMessVo.setVeriError("C레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다.");
	     	 	      	yetaMessVo.setVeriModCtnt("세액계산  작업 후 다시 생성 하십시요."); 
	     
	     			    bmResult.add(yetaMessVo);
	            	 
	             }
 	              

 	               C_rowCnt = 1;
 	             
 	              if (listHCData.size() > 0) { 
 	                  C_Cnt = C_Cnt + 1;
 	              }
 	               
 	              Iterator<Map<String, Object>> iter01 = listHCData.iterator(); 
 	        	   
 		          while ( iter01.hasNext() ) { 
 		            	
 		            Map<String, Object> mapHCData = (Map<String, Object>) iter01.next(); 
 		             

 		               // 주민번호(복호화)
 		               String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapTotData01.get("resnRegnNum"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
 		            		          	 
 	                   // strTempDataC = "";
 	                   // mTempDataC  = 0L;

 	                   // strTempDataC =  "C" + "27" ;
 	                  //  strTempDataC = strTempDataC + yeta1000Vo.getTaxaCode(); //세무서코드 
                      //  mTempDataC = Long.parseLong(String.valueOf(C_Cnt));
                      //  strTempDataC = strTempDataC +   String.format("%06d", mTempDataC);    //소득자일련번호 
                      //  strTempDataC = strTempDataC  +  String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-","")); //사업자등록번호
 		               
                         //소득자주민등록번호
                        if (!rrno_check(rrnDecCrypt)) {
                        	
                        	YetaMessageVO yetaMessVo = new YetaMessageVO();
                        	
                        	yetaMessVo.setDispWindow("YETA1400");
    	     	 	      	yetaMessVo.setVeriRec("C레코드");
    	     	 	      	yetaMessVo.setVeriRecCtnt("기부금조정명세레코드");
    	     	 	        yetaMessVo.setVeriTgtName(MSFSharedUtils.allowNulls(mapTotData01.get("kornName")));
    	     	 	      	yetaMessVo.setVeriError("소득자 주민등록번호 오류");
    	     	 	      	yetaMessVo.setVeriModCtnt("소득자 본인 주민번호 확인 !"); 
    	     	 	        //세액감면및세액공제1->기부금->이월기부금
    	     			    bmResult.add(yetaMessVo);
                        } 
                        
                        
                        
                        mTempDataC =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("frnrYeno"),"1"));   //oraQrySelect01.FieldByName('FRNR_YENO').AsFloat;    
                      
                         if ((1 != mTempDataC) && (9 != mTempDataC)) {
                        	
                        	YetaMessageVO yetaMessVo = new YetaMessageVO();
                        	
                        	yetaMessVo.setDispWindow("YETA1400");
    	     	 	      	yetaMessVo.setVeriRec("C레코드");
    	     	 	      	yetaMessVo.setVeriRecCtnt("기부금조정명세레코드");
    	     	 	        yetaMessVo.setVeriTgtName(MSFSharedUtils.allowNulls(mapTotData01.get("kornName")));
    	     	 	      	yetaMessVo.setVeriError("내외국인구분코드 오류 [" + MSFSharedUtils.defaultNulls(mapHCData.get("frnrYeno"),"값없음") + "]" );
    	     	 	      	yetaMessVo.setVeriModCtnt("인적공제 탭 소득자 본인 내외국인 확인 !"); 
    	     	 	        //세액감면및세액공제1->기부금->이월기부금
    	     			    bmResult.add(yetaMessVo);
                        }  

                        
                       // strTempDataC = strTempDataC  +   PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapTotData01.get("kornName"),""),28),30," "); 
                        		//String.format("%-30s",  MSFSharedUtils.defaultNulls(mapHCData.get("kornName"),""));  //성명
                        //strTempDataC = strTempDataC  +  String.format("%-2s",  MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""));    //유형코드
                     
                         if (!"10".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))
                        	 && !"20".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	
                        	 && !"40".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	
                        	 && !"41".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	
                        	 && !"42".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	) {
                        	 
                        	 YetaMessageVO yetaMessVo = new YetaMessageVO();
                         	
                         	 yetaMessVo.setDispWindow("YETA1400");
     	     	 	      	 yetaMessVo.setVeriRec("C레코드");
     	     	 	      	 yetaMessVo.setVeriRecCtnt("기부금조정명세레코드");
     	     	 	         yetaMessVo.setVeriTgtName(MSFSharedUtils.allowNulls(mapTotData01.get("kornName")));
     	     	 	      	 yetaMessVo.setVeriError("유형코드 오류 [" + MSFSharedUtils.defaultNulls(mapHCData.get("frnrYeno"),"값없음") + "]" );
     	     	 	      	 yetaMessVo.setVeriModCtnt("세액감면및세액공제1->기부금->이월기부금등록에 기부금조정명세확인 !<br>[10,20,40,41,42]가 아닌 유형코드 존재 "); 
     	     	 	         //
     	     			     bmResult.add(yetaMessVo);
     	     			    
                         }
                        
                        mTempDataC =  Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbYrmn"),"0")); 
                        
                        //strTempDataC = strTempDataC  +   String.format("%04d", mTempDataC);    //기부연도
                        mTempDataC =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbAmnt"),"0"));   
                        strTempDataC = strTempDataC  +  String.format("%013d", mTempDataC);   //기부금액 - 13
                        mTempDataC =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("bfyrDeam"),"0"));   
                        strTempDataC = strTempDataC  +  String.format("%013d", mTempDataC);  //전년까지공제된금액 -13
                        mTempDataC =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("detrAmnt"),"0"));   
                        strTempDataC = strTempDataC  + String.format("%013d", mTempDataC);  //공제대상금액  -13
                        
                        strTempDataC = strTempDataC  + "0000000000000" ;   //해당년도공제금액 필요경비 
                        
                        mTempDataC =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("dyyrDeam"),"0"));  
                        strTempDataC = strTempDataC  + String.format("%013d", mTempDataC);//해당년도공제금액세액금액 -13                        
                        mTempDataC =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("dyyrOtam"),"0"));   
                        strTempDataC = strTempDataC  + String.format("%013d", mTempDataC); //해당년도공제받지못한금액소멸금액 -13
                        mTempDataC =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("ayyrNtam"),"0"));   
                        strTempDataC = strTempDataC  + String.format("%013d", mTempDataC); //해당년도에 공제받지못한금액_이월금액 -3
                        strTempDataC = strTempDataC  + String.format("%05d", C_rowCnt);       //기부금조정명세일련번호 -5
                        strTempDataC = strTempDataC  + String.format("%22s", "");      //공란 -25
 
 	                   TOT_Record.add(strTempDataC);
 	                   C_rowCnt = C_rowCnt + 1;
 
 		          }

 	               D_Cnt = 1;
 	             
 	              //D레코드 - 해당연도 기부명세 레코드  
 	              List listHDData = yeta1400PayrService.fnPayrHD_ReTax_Total_Select(yeta1000Vo); 
 	               
 	             if (listHCData.size() > 0) { 
	              
	              Iterator<Map<String, Object>> iter02 = listHDData.iterator(); 
	        	   
		          while ( iter02.hasNext() ) { 
		            	
		            Map<String, Object> mapHDData = (Map<String, Object>) iter02.next();
 
 	                     strTempDataD = "";
 	                     mTempDataD  = 0L;

 	                    // 주민번호(복호화)
 	 		               String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapTotData01.get("resnRegnNum"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
 	 		            		   
 	                      strTempDataD =  "D" + "27";
 	                      strTempDataD = strTempDataD + yeta1000Vo.getTaxaCode();  //세무서코드 
                          strTempDataD = strTempDataD + String.format("%06d", C_Cnt);     //소득자일련번호 
                          strTempDataD = strTempDataD + String.format("%-10s", StringUtils.replace(yeta1000Vo.getBusiNumb(),"-",""));   //사업자등록번호 
                          
                          strTempDataD = strTempDataD +  String.format("%-13s", rrnDecCrypt);      //소득자주민등록번호
                          strTempDataD = strTempDataD +  String.format("%-2s",  MSFSharedUtils.defaultNulls(mapHDData.get("ctrbTycd"),""));     //유형코드
                          
                          strTempDataD = strTempDataD +  String.format("%-13s", StringUtils.replace(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbBsnu"),""),"-",""));    //사업자등록번호
 
                          strTempDataD = strTempDataD + PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbName"),""),28),30," ");
                          //String.format("%-30s", StringUtils.left(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbName"),""),30));    //상호 - 30
                                           
                          strTempDataD = strTempDataD +  String.format("%-1s",  MSFSharedUtils.defaultNulls(mapHDData.get("crtbCncd"),""));  //관계코드
                          strTempDataD = strTempDataD +  String.format("%-1s",  MSFSharedUtils.defaultNulls(mapHDData.get("frnrCode"),""));     //내외국인구분코드
                          strTempDataD = strTempDataD +  PkgFuncUtils.getRPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapHDData.get("cbtgName"),""),18),20," "); 
                          //String.format("%-20s", MSFSharedUtils.defaultNulls(mapHDData.get("cbtgName"),""));   //성명 - 20
                          // 주민번호(복호화)
	 		                 rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapHDData.get("rsnoNumb"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	 		            		   
                          strTempDataD = strTempDataD +  String.format("%-13s", rrnDecCrypt);    //기부자주민등록번호 
                          mTempDataD =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbNcnt"),"1"));   
                          strTempDataD = strTempDataD +  String.format("%05d", mTempDataD);   //건수 - 5
                       
                          mTempDataD = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbAmnt"),"0"));   
                          strTempDataD = strTempDataD +  String.format("%013d", mTempDataD);     //기부금액 - 13

                          //2016년 추가 -----
                          mTempDataD = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbTgam"),"0"));   
                          strTempDataD = strTempDataD +  String.format("%013d", mTempDataD);     //공제대상기부금액
                          mTempDataD = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ctjaCham"),"0"));   
                          strTempDataD = strTempDataD +  String.format("%013d", mTempDataD);     //기부장려신청금액
 
                          
                          strTempDataD = strTempDataD + String.format("%05d", D_Cnt);    //일련번호 
                          
                          strTempDataD = strTempDataD +  String.format("%26s", "");    //공란 42
 
 	                      TOT_Record.add(strTempDataD);
 
 	                    D_Cnt = D_Cnt + 1;
		           }
 	             } 

	         } 
 

	   } catch (Exception ex) {
		   ex.printStackTrace(); 
		   return bmResult; 
 	 
      }  
 	    
 	   return bmResult;
 	      
    } 
 

/**
 * 
 * <pre>
 * 1. 개요  : 주민번호 체크 정규식 표현  
 * 2. 처리내용 : 
 * </pre>
 * @Method Name : rrno_check
 * @date : 2017. 2. 21.
 * @author : atres-pc
 * @history : 
 *	-----------------------------------------------------------------------
 *	변경일				작성자						변경내용  
 *	----------- ------------------- ---------------------------------------
 *	2017. 2. 21.		atres-pc				최초 작성 
 *	-----------------------------------------------------------------------
 * 
 * @param rrno
 * @return
 */
public boolean rrno_check(String rrno) {
    boolean rrnoChk = true ;   
	Scanner scan = new Scanner(rrno);
	while(true){ 
		String juminNo = scan.nextLine();
		if(juminNo.trim().equals("0")) break; // 문자열.trim() : 앞뒤공백을 제거해라

		// 정규 표현식을 이용한 유효성 검사하기
		Pattern p = Pattern.compile("^\\d{6}[1-4]\\d{6}$");
		Matcher m = p.matcher(juminNo);
		if(!m.matches()){ 
			rrnoChk = false;
			continue;
		}

		// 여기까지 내려오면 숫자로만 이루어진 13자리이다.
		int sum=0;
		for(int i=0;i<juminNo.length()-1;i++){
			sum += (juminNo.charAt(i)-'0') * (i<8 ? i+2 : i-6);
		}
		sum = (11 - sum%11)%10;
		// 문자열.substring(n,m) : n부터 m전까지 잘라내기, 문자열.substring(n) : n번째부터 끝까지
		 
		if(juminNo.charAt(12)-'0' == sum)
			rrnoChk = true;
		else
			rrnoChk = false;
	}
	scan.close(); 
	
   return rrnoChk;	
} 
 
 
}
