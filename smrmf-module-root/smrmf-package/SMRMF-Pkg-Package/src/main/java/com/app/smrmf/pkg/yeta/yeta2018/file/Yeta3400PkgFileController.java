package com.app.smrmf.pkg.yeta.yeta2018.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
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

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.egov.comutils.payr.PkgFuncUtils;
import com.app.smrmf.infc.yearendtax.server.vo.YetaMessageVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161005_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161020_2018_VO;
import com.app.smrmf.pkg.yeta.yeta2018.file.service.Yeta3400PayrService;

import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class Yeta3400PkgFileController {

    private static final Logger logger = LoggerFactory.getLogger(Yeta3400PkgFileController.class);  
    
    @Resource(name = "Yeta3400PayrService")
    private Yeta3400PayrService yeta3400PayrService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService; 
    
    
    public Yeta3400PkgFileController() {
    	
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
    * @param ye161010VO
    */
	public int fnYeta3400_Tax_Ye161010_File_Create(HttpServletRequest request,InfcPkgYe161010_2018_VO  ye161010VO,HttpServletResponse response) throws Exception  {

		if  (yeta3400PayrService== null) {
			WebApplicationContext wac = WebApplicationContextUtils.
			getRequiredWebApplicationContext( request.getSession().getServletContext());

			yeta3400PayrService = (Yeta3400PayrService) wac.getBean("Yeta3400PayrService");
		}

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
		String H_Record  = "";
		String I_Record  = "";
		ArrayList<String> TOT_Record = new ArrayList<String>();

		int B_Cnt = 0;
		int C_Cnt = 0;
		int D_Cnt = 0;
		int E_Cnt = 0;
		int F_Cnt = 0;
		int G_Cnt = 0;
		int H_Cnt = 0;
		int I_Cnt = 0;
		int E_RowCnt = 0;
		int F_RowCnt = 0;
		int G_RowCnt = 0;
		int H_RowCnt = 0;
		int I_RowCnt = 0;
		String RSNOSTR = "";
		String B_RecStr = ""; 
		String C_RecStr = "";
		String D_RecStr = "";
		String E_RecStr = "";
		String F_RecStr = "";
		String G_RecStr = "";
		String H_RecStr = "";
		String I_RecStr = "";
		Long mTempData01 = 0L;
		Long mTempData02 = 0L;
		String strTempDataH = "";
		String strTempDataI = "";  
		Long mTempDataH = 0L;
		Long mTempDataI = 0L;
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
      

       // InfcPkgye161010VO infcPkgye161010VO = new InfcPkgye161010VO(); 
		InfcPkgYe161005_2018_VO    infcPkgYe161005Vo	 = new InfcPkgYe161005_2018_VO();	//A_원천세신고기본
		BeanUtils.copyProperties(infcPkgYe161005Vo, ye161010VO);

		infcPkgYe161005Vo  = yeta3400PayrService.selectYe161005(ye161010VO);

		//인적기본데이터를 가지고온다. 조회처리 루틴 추가 
		InfcPkgYe161020_2018_VO    infcPkgYe161020Vo	 = new InfcPkgYe161020_2018_VO();	//A_인적소득공제기본
		BeanUtils.copyProperties(infcPkgYe161020Vo, ye161010VO);
		//{근로소득지급명세서}
		/********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		/********************************************************암호화 처리 를 위해 반드시 해야 함................................*/   

		DEFIN = "C"; //근로소득
       
        defBUNS_LINS = StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-","");   //사업자번호
      
		A_Record = ("A" + "20" + infcPkgYe161005Vo.getTxOffcCd() + String.format("%08d", Long.parseLong(StringUtils.replace(ye161010VO.getEdacPrdt(),"-","")))
                       + String.format("%01d", Long.parseLong( infcPkgYe161005Vo.getPentrSeptCd() ))   + String.format("%-6s", MSFSharedUtils.defaultNulls(infcPkgYe161005Vo.getTxDeptyMangeNum(),"")) 
                       //+  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(infcPkgYe161005Vo.getHmtxId() ,20),20," ")  
+  Han1(infcPkgYe161005Vo.getHmtxId(), 20)   
                       +  String.format("%-4s", infcPkgYe161005Vo.getTxPgmCd()) 
                       +  String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-",""))
                       //+  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(infcPkgYe161005Vo.getCorpFmnmNm() ,58),60," ")  
+  Han1(infcPkgYe161005Vo.getCorpFmnmNm(), 60)   
                       //+  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(infcPkgYe161005Vo.getPernChrgDeptNm() ,28),30," ") 
+  Han1(infcPkgYe161005Vo.getPernChrgDeptNm(), 30)   
                       //+  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(infcPkgYe161005Vo.getPernChrgNm(),28),30," ")    
+  Han1(infcPkgYe161005Vo.getPernChrgNm(), 30)   
                       //+  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(infcPkgYe161005Vo.getPernChrgPhnNum() ,15),15," ")  
					+  String.format("%-15s", infcPkgYe161005Vo.getPernChrgPhnNum()) 
                       +  String.format("%05d", 1) + "101"
                       +  String.format("%1684s", " "));

		TOT_Record.add(A_Record);
//System.out.println("=======AAAA 1["+A_Record+"][");
//System.out.println("=======AAAA 2["+A_Record.length());
		B_Cnt = 1;
		mTempData01 = 0L;
        
		try {

      
			Map mapYetaB = yeta3400PayrService.fnPayrB_ReTax_Total_Select(infcPkgYe161020Vo); 

			if (mapYetaB.isEmpty()) { 
//           showMessage('B레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.');
//           Result = -1;
//           Exit;
			}
    	  
    	  
			if (!"2".equals(MSFSharedUtils.defaultNulls(infcPkgYe161005Vo.getPentrSeptCd(),""))) { //제출자구분코드 

			//  if (MSFSharedUtils.paramNull(StringUtils.replace(ye161010VO.getJuriNumb(),"-","")) || StringUtils.replace(ye161010VO.getJuriNumb(),"-","").equals("null")) {

			//  RSNOSTR = StringUtils.replace(ye161010VO.getResuNumb(),"-","");    //사업자주민번호 
			// 주민번호(복호화)
				String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(infcPkgYe161005Vo.getResuNumb()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

				RSNOSTR	  = rrnDecCrypt;
			}
			else
			{
				RSNOSTR =  StringUtils.replace(infcPkgYe161005Vo.getCorpNum(),"-","");   //법인번호
			}
    	  
            B_RecStr = "";
            mTempData01 = 0L ;
 

			B_RecStr = "B" + "20" + infcPkgYe161005Vo.getTxOffcCd() +  String.format("%06d", B_Cnt)   +   String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-",""))
					   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(infcPkgYe161005Vo.getCorpFmnmNm() ,58),60," ")  
+  Han1(infcPkgYe161005Vo.getCorpFmnmNm(), 60)  
                           //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(infcPkgYe161005Vo.getReprName() ,28),30," ")  
+  Han1(infcPkgYe161005Vo.getReprName(), 30)  
                           + String.format("%-13s", StringUtils.replace(RSNOSTR,"-",""))  ; 
			mTempData01 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("psnlJuCnt"),"0"));
			B_RecStr =  B_RecStr + String.format("%07d", mTempData01);    //주근무지 레코드 수 
			mTempData01 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("psnlJungCnt"),"0"));  
			B_RecStr =  B_RecStr + String.format("%07d", mTempData01);     //종전근무지 레코드 수 

			mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("yeta0c63"),"0")); 
			B_RecStr =  B_RecStr + String.format("%014d", mTempData01);   //총급여 총계_현전
			mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("yetaC159"),"0"));  
			B_RecStr =  B_RecStr   +  String.format("%013d", mTempData01);    //결정세액 소득세 
            //  mTempData01 =  oraQrySelect01.FieldByName('GONG_TEMP01').AsFloat;
            //  B_RecStr =  B_RecStr  + FormatFloat('0000000000000', mTempData01);
			mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("yetaC160"),"0"));    
			B_RecStr =  B_RecStr  + String.format("%013d", mTempData01);   //결정세액 지방소득세
			mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("yetaC161"),"0"));  
			B_RecStr =  B_RecStr   + String.format("%013d", mTempData01);    //결정세액 농특세
			mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("yetaSumAll"),"0")); 
			B_RecStr =  B_RecStr  + String.format("%013d", mTempData01);    //결정세액 총계
			B_RecStr =  B_RecStr  + "1"; //체출기간 연간합산제출등 코드로 등록하여 처리 하게 수정 필요 
			B_RecStr =  B_RecStr +  String.format("%1676s", "");     //공란 

			TOT_Record.add(B_RecStr);

			C_Cnt =  1;
           
            //c레코드 주현근무처 레코드 fnPayrC_ReTax_Total_Select
			List listYetaC = yeta3400PayrService.fnPayrC_ReTax_Total_Select(infcPkgYe161020Vo);
            
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
				C_RecStr = C_RecStr   + infcPkgYe161005Vo.getTxOffcCd(); //세무서코드 // - 누적길이 6
				C_RecStr = C_RecStr + String.format("%06d", C_Cnt);    //원천징수읨주별로 1부터 순차부여	- 누적길이 12  
				C_RecStr = C_RecStr  +  String.format("%-10s", StringUtils.replace(MSFSharedUtils.allowNulls(mapYetaC.get("bsnoEncCntn")),"-",""));  //사업자등록번호 	- 누적길이 22 
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta00c6"),"0"));             /*  종전근무처수 */    
				C_RecStr = C_RecStr  + String.format("%02d",mTempData02);	//	- 누적길이 24
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("rsdtClCd"),"1"));        //거주자구분코드
				C_RecStr = C_RecStr  + String.format("%01d", mTempData02);	//	- 누적길이 25
				C_RecStr = C_RecStr  + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaC.get("redtGbcd"),"")  );    //거주지국코드	//	- 누적길이 27
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta00c9"),"2"));                        //단일세율적용여부
				C_RecStr = C_RecStr  + String.format("%01d", mTempData02) ;
				//2016귀속 추가 ㄴ
				C_RecStr = C_RecStr  + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c9a"),"2")  );    //외국법인소속 파견근로자여부 

				//C_RecStr = C_RecStr  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaC.get("fnm"),"") ,28),30," ") ;    //성명	- 누적길이 59
C_RecStr = C_RecStr  + Han1(mapYetaC.get("fnm"), 30);    //성명	- 누적길이 59
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("nnfClCd"),"1"));                                 //내외국인구부노드
				C_RecStr = C_RecStr  +  String.format("%01d",  mTempData02) ;	// - 누적길이 60
                             
				// 주민번호(복호화)
				String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

				C_RecStr = C_RecStr  + String.format("%-13s",rrnDecCrypt);     //주민등록번호	// - 누적길이 73


				C_RecStr = C_RecStr  + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaC.get("rsplNtnInfrCd"),"") );       //국적코드
				C_RecStr = C_RecStr  + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("hshrClCd"),"") );       //세대주구분코드
				C_RecStr = C_RecStr   + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("hoofStcd"),"")) ;       //연말정산구분 계속근로,중도퇴사
C_RecStr = C_RecStr   + "2";	//사업자단위 과세여부	// - 누적길이 78
C_RecStr = C_RecStr   + String.format("%-4s", "");	//종사업장 일련번호	// - 누적길이 82
				C_RecStr = C_RecStr   + String.format("%-10s", StringUtils.replace(MSFSharedUtils.allowNulls(mapYetaC.get("bsnoEncCntn")),"-","")) ;            //주현근무처-사업자등록번호	// - 누적길이 92
				//C_RecStr = C_RecStr   + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.allowNulls(mapYetaC.get("tnm")) ,58),60," ") ;                                     //주현근무처-근무처명	// - 누적길이 152
C_RecStr = C_RecStr   + Han1(mapYetaC.get("tnm"),60) ;                                     //주현근무처-근무처명	// - 누적길이 152


				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dtyStrtDt"),"0"));                                  //근무기간시작연월일
				C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);	// - 누적길이 160
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dtyEndDt"),"0"));                                 //근무기간 종료일자
				C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);	// - 누적길이 168
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("reStrtDt"),"0"));                                  //감면기간시작일자
				C_RecStr = C_RecStr  +  String.format("%08d",  mTempData02) ;	// - 누적길이 176
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("reEndDt"),"0"));                                    //감면기간종료일자
				C_RecStr = C_RecStr  +  String.format("%08d", mTempData02);	// - 누적길이 184
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c22"),"0"));                                 //급여총액
				C_RecStr = C_RecStr  + String.format("%011d", mTempData02);
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c23"),"0"));                                   //상여총액
				C_RecStr = C_RecStr  + String.format("%011d",  mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c24"),"0"));                               //인정상여
				C_RecStr = C_RecStr  + String.format("%011d",  mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c25"),"0"));                                //주식행사이익
				C_RecStr = C_RecStr  + String.format("%011d",  mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c26"),"0"));                               //우리사주조합인출금
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c27"),"0"));                                 //임원 퇴직소득금액 한도초과액
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);	// - 누적길이 250

C_RecStr = C_RecStr   + String.format("%011d", 0);	//직무발명보상금	// - 누적길이 261

C_RecStr = C_RecStr   + String.format("%022d", 0);	// - 누적길이 283

				C_RecStr = C_RecStr   +  String.format("%011d", Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c29"),"0"))) ;      	// - 누적길이 294              //계

				//주현근무처 비과세소득 및 감면소득  
				//       mTempData02 = oraQrySelect02.FieldByName('PAYR_TEMP29').AsFloat;
				//       C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta_C30G01"),"0"));  //비과세학자금
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta_C31H01"),"0"));	//무보수  위원수당
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta_C32H05"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta_C33H06"),"0"));	//유아초중동  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);	// - 누적길이 334
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta_C34H07"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta_C35H08"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC36H09"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC37H10"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC38H14"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC39H15"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC40H11"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC41H12"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC42H13"),"0"));  
				C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;	// - 누적길이 424
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC43H16"),"0"));  
				C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;	// - 누적길이 434

C_RecStr = C_RecStr   + String.format("%010d", 0);	//종교활동비	// - 누적길이 444

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC44I01"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC45K01"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC46M01"),"0")); 
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC47M02"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC48M03"),"0"));  
				C_RecStr = C_RecStr  +  String.format("%010d",  mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC49O01"),"0")); 
				C_RecStr = C_RecStr   +  String.format("%010d", mTempData02)  ;
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC50Q01"),"0")); 
				C_RecStr = C_RecStr  +  String.format("%010d", mTempData02) ;	// - 누적길이 514
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC51R10"),"0")); 
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC52R11"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC53S01"),"0")); 
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;	// - 누적길이 544

C_RecStr = C_RecStr   + String.format("%010d", 0);	//벤처기업 주식매수선택권	// - 누적길이 554

				//mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC54T01"),"0")); 
				//C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC55Y02"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				//2016년 귀속 추가 
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC56Y03"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				//2017년추가 
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC56aY04"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);

				//mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC56Y21"),"0")); 
				//C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC57Y22"),"0")); 
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				
C_RecStr = C_RecStr   + String.format("%010d", 0);	//외국인기술자	// - 누적길이 604
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC58T10"),"0")); 
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);	// - 누적길이 614

				//2016년귀속 추가 
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC58aT11"),"0")); 
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC58bT12"),"0")); 
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);// - 누적길이 634

C_RecStr = C_RecStr   + String.format("%010d", 0);	//중소기업 취업청년 소득세 감면// - 누적길이 644

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC59T20"),"0")); 
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);

				C_RecStr = C_RecStr   + String.format("%020d", 0);	//공란// - 누적길이 674

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c60"),"0"));    //비과세계
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c61"),"0"));   //감면소득계
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);// - 누적길이 694

				//  C_RecStr = C_RecStr   + "0000000000";//공란 0으로 10자리       

				//정산명세 처리 시작    
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c63"),"0"));         /*(16 합계)(21)번  column 총급여_현_전 : TOTL_SALA */          
				C_RecStr = C_RecStr   +  String.format("%011d", mTempData02);// - 누적길이 705
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c64"),"0"));    /* (22) column 근로소득공제 : WKER_DDCT */    
				C_RecStr = C_RecStr   +  String.format("%010d", mTempData02);// - 누적길이 715
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c65"),"0"));      /*(23) column 근로소득금액 : WKER_AMNT */  
				C_RecStr = C_RecStr   +  String.format("%011d", mTempData02);// - 누적길이 726
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c66"),"0"));  /*(24) column 기본공제_본인 : BASE_SELF */         
				C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);// - 누적길이 734
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c67"),"0")); /*(25) column 기본공제_배우자 : BASE_WIFE */         
				C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);// - 누적길이 742
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c68"),"0"));   /*(26) column 기본공제_부양가족수 : BASE_FMLY */  
				C_RecStr = C_RecStr   + String.format("%02d", mTempData02) ;// - 누적길이 744
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c69"),"0"));   /*(26) column 기본공제_부양가족 : BASE_FYAM */     
				C_RecStr = C_RecStr   + String.format("%08d",mTempData02)  ;// - 누적길이 752
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c70"),"0"));  /*(70) column 추가공제_경로우대_70세이상수 : ADDR_CT70 경로우대공제인원 */       
				C_RecStr = C_RecStr   + String.format("%02d",mTempData02);// - 누적길이 754
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c71"),"0"));  /*(27) column 추가공제_경로우대70 : ADDR_RPT70 1946.12.31 */   
				C_RecStr = C_RecStr   + String.format("%08d", mTempData02) ;// - 누적길이 762
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c72"),"0"));  /*(28) column 추가공제_장애인수 : ADDR_HDRC */    
				C_RecStr = C_RecStr   + String.format("%02d",mTempData02);// - 누적길이 764
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c73"),"0"));   /*(28) column 추가공제_장애인 금액 : ADDR_HDAM */     
				C_RecStr = C_RecStr   + String.format("%08d", mTempData02);// - 누적길이 772
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c74"),"0")); /*(29) column 추가공제_부녀자  금액 : ADDR_FAME */      
				C_RecStr = C_RecStr   + String.format("%08d", mTempData02);// - 누적길이 780


				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c75"),"0"));   /*(30) column 추가공제_한부모공제금액 : PANT_ONAM */         
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 790

				//연금보험료공제 
mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c76"),"0"));    /*(31) column_국민연금보험료공제 대상금액 : JNAT_DDCT */       
C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c76"),"0"));    /*(31) column_국민연금보험료공제 공제금액 : JNAT_DDCT */       
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;

mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c77"),"0"));    /*(32)-가 column  _공무원연금보험료공제 대상금액 : JPSS_HPUL */   
C_RecStr = C_RecStr  + String.format("%010d",  mTempData02);// - 누적길이 820
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c77"),"0"));    /*(32)-가 column  _공무원연금보험료공제 공제금액 : JPSS_HPUL */   
				C_RecStr = C_RecStr  + String.format("%010d",  mTempData02);

mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c78"),"0"));    /*(32)-나 column 주근무지_국민연금외군인연금공제 대상금액 : JPSS_HSOL */  
C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c78"),"0"));    /*(32)-나 column 주근무지_국민연금외군인연금공제 공제금액 : JPSS_HSOL */  
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;

mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c79"),"0"));    /*(32)-다 column 주근무지_국민연금외교직원연금공제 대상금액 : JPSS_HTEC */ 
C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c79"),"0"));    /*(32)-다 column 주근무지_국민연금외교직원연금공제 공제금액 : JPSS_HTEC */ 
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;

mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c80"),"0"));        /*(32)-라 column_별정우체국연금보험료공제 대상금액 : JPSS_DDCT */   
C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);// - 누적길이 880
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c80"),"0"));        /*(32)-라 column_별정우체국연금보험료공제 공제금액 : JPSS_DDCT */   
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);

				//  mTempData02 = oraQrySelect02.FieldByName('JRTR_HICT').AsFloat ;                //퇴직연금-과학기술인공제  ---
				//  C_RecStr = C_RecStr  + FormatFloat('0000000000', mTempData02) ;
				//  mTempData02 = oraQrySelect02.FieldByName('JBRTR_PSRN').AsFloat;                 //퇴직연금-근로자보장법  ----
				//  C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02) ; 
				//  mTempData02 = oraQrySelect02.FieldByName('JRTR_HNSV').AsFloat;                 //퇴직연금-연금저축  --------
				//  C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02) ;

				//특별소득공제 
mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c81"),"0"));   /*(33)-가 column 특별공제_주건강보험료 대상금액 : SPCI_JHTH */   
C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;// - 누적길이 900
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c81"),"0"));   /*(33)-가 column 특별공제_주건강보험료 공제금액 : SPCI_JHTH */   
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;

mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c82"),"0"));    /*(33)-나 column 특별공제_주고용보험료 대상금액 : SPCI_JEPF */   
C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);// - 누적길이 920
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c82"),"0"));    /*(33)-나 column 특별공제_주고용보험료 공제금액 : SPCI_JEPF */   
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
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c83"),"0"));            /*(34)-가 column 특별공제_차입금원리금상환액_대출기관 : SPCI_REFN */   
				C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ;// - 누적길이 938
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c84"),"0"));               /*(34)-가 column 특별공제_차입금원리금상환액_거주자 : SPCI_RESF */ 
				C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ; // - 누적길이 946

				// mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("befoScnt"),"0")); oraQrySelect02.FieldByName('SPCI_HTAM').AsFloat ;                   //주택자금-월세액 대상금액
				// C_RecStr = C_RecStr   + FormatFloat('00000000', mTempData02); 
								   
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c85"),"0"));    /*(34)-나 column 특별공제_11장기주택저당차입금15 : SPCH_RE15 */  
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02);// - 누적길이 954
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c86"),"0"));      /*(34)-나 column 특별공제_11장기주택저당차입금29 : SPCH_RE29 */   
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02);// - 누적길이 962
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c87"),"0"));      /* (34)-나column 특별공제_11장기주택저당차입금30 : SPCH_RE30 */   
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02); // - 누적길이 970
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c88"),"0"));     /*(34)-나 column 특별공제_12장기주택저당차입금_고정 : SPCI_REFX */     
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02);// - 누적길이 978
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c89"),"0"));    /*(34)나 column 특별공제_12장기주택저당차입금_기타 : SPCI_REEC */
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02);// - 누적길이 986

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c90"),"0"));   /*(34)-나 column 특별공제_15장기주택저당_15고정AND비거치상환 : SPCI_15FX */
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02);// - 누적길이 994
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c91"),"0"));     /*(34)-나 column 특별공제_15장기주택저당_15고정OR비거치상환 : SPCI_15FB */
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02);// - 누적길이 1002
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c92"),"0"));     /*(34)-나 column 특별공제_15장기주택저당_15기타대출 : SPCI_15EC */
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02);// - 누적길이 1010
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c93"),"0"));      /*(34)-나 column 특별공제_15장기주택저당_10고정OR비거치상환 : SPCI_10FB */
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02);// - 누적길이 1018

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c94"),"0"));     /*(35) column 이월분  특별공제_기부금공제액계 : SPCI_SSUM */    
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02);// - 누적길이 1029

				// mTempData02 = oraQrySelect02.FieldByName('SPCI_PLTC').AsFloat ;                  //기부금공제금액 _정치
				// C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
				//  mTempData02 = oraQrySelect02.FieldByName('SPCI_FBAM').AsFloat ;                  //기부금공제금액_법정
				// C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
				//   mTempData02 = oraQrySelect02.FieldByName('SPCI_RFAM').AsFloat ;                  //기부금공제금액_우리사주조합기부금
				// C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
				//  mTempData02 = oraQrySelect02.FieldByName('SPCI_NYAM').AsFloat ;                  //기부금공제금액_지정기부금
				//  C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
				// C_RecStr = C_RecStr   + "00000000000000000000" ;  //공란 

				C_RecStr = C_RecStr   + String.format("%022d", 0);	//공란// - 누적길이 1051

				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c96"),"0"));   /*96  (36)    //특별소득공제 계  */
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);
				//mTempData02 =  oraQrySelect02.FieldByName('SPCI_DDCT').AsFloat;                 //표준공제
				//C_RecStr = C_RecStr  + FormatFloat('00000000', mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c97"),"0"));       /* (97) column 차감소득금액 : SUBT_ERAM */  
				C_RecStr = C_RecStr  + String.format("%011d", mTempData02);// - 누적길이 1073

				//그 밖의 소득공제  
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c98"),"0"));     /* (98)column 개인연금저축불입액_2000년이전 : ETCP_PSNV */  
				C_RecStr = C_RecStr   + String.format("%08d", mTempData02);// - 누적길이 1081
				//     mTempData02 = oraQrySelect02.FieldByName('ETCP_NSAV').AsFloat;                 //연금저축소득공제
				//    C_RecStr = C_RecStr  + FormatFloat('00000000', mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c99"),"0"));    /* (99) column 기타공제_소기업공제불입금 : ETCH_PREP */    
				C_RecStr = C_RecStr  + String.format("%010d", mTempData02);// - 누적길이 1091

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC100"),"0"));   /*(100)-가 column 기타공제_주택마련저축_청약저축 : ETCS_COMP */       
				C_RecStr = C_RecStr  + String.format("%010d",  mTempData02) ;// - 누적길이 1101
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC101"),"0"));    /* (101)-나column 기타공제_주택마련저축_주택청약종합저축 : ETWK_SBAM */       
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1111
				//  mTempData02 = oraQrySelect02.FieldByName('ETWK_LGAM').AsFloat ;                  //장기주택마련저축
				//  C_RecStr = C_RecStr   + FormatFloat('0000000000',mTempData02) ;
				mTempData02 =Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC102"),"0"));   /*(102)-다 column 기타공제_주택마련저축_근로자주택마련저축 : ETWK_SVAM */
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC103"),"0"));        /* (103) column 기타공제_투자조합출자공제액 : ETGD_DDAM */   
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1131

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC104"),"0"));     /*(104) column 기타공제_신용카드등사용액소득공제 : ETCC_CARD */ 
				C_RecStr = C_RecStr   + String.format("%08d", mTempData02) ;// - 누적길이 1139
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC105"),"0"));       /*(105) column 기타공제_우리사주출연금공제 : ETCK_UNON */      
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);// - 누적길이 1149

				//  mTempData02 = Long.parseLong("0");                  //우리사주조합기부금
				//  C_RecStr = C_RecStr   + "00000000000";

				//mTempData02 = oraQrySelect02.FieldByName('ETCL_HMTO').AsFloat  ;                 //장기주식형저축소득공제
				//C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC107"),"0"));       /*(45) column 기타공제_고용유지중소기업근로자임금삭감공제액 : ETEP_MSAM */ 
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);

				//  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC108"),"0"));       /*(46) column 기타공제_목돈안드는전세이자상환소득공제액 : ETGD_HTRA */        
				//C_RecStr = C_RecStr   + "0000000000";                                                       //String.format("%010d",  mTempData02)  ;

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC109"),"0"));      /*(47) column 기타공제_장기집합투자증권저축공제액 : ETEP_SECR */  
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02)  ;// - 누적길이 1169

				C_RecStr = C_RecStr   + String.format("%020d", 0);	//공란// - 누적길이 1189

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC110"),"0"));      /*(48) column 기타공제_공제계 : ETCD_TSUM */   
				C_RecStr = C_RecStr  + String.format("%011d",  mTempData02);// - 누적길이 1200

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC111"),"0"));     /*(49) column 특별공제_종합한도초과금액 : SPCH_EXLI */     
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02) ;// - 누적길이 1211


				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC112"),"0"));     /*(50) column 종합소득과세표준 : STND_INCM */        
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02) ;// - 누적길이 1222
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC113"),"0"));         /*(51) column 산출세액 : PRDD_TAXN */         
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;// - 누적길이 1232

				//------------------------ 세액감면 ------------------------------ 
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC114"),"0"));     /*(52) column 세액감면_소득세법 : TAXD_ICAX */    
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC115"),"0"));     /*(53) column 세액감면_조세특례법 : TAXD_SPCT */        
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02)  ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC116"),"0"));  /*(54) column 세액감면_조세특례법제30조 : TXLG_CL30 */   
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02)  ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC117"),"0"));    /*(55) column 세액감면_조세조약 : TXLG_HXTT */   
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;// - 누적길이 1272
				//   mTempData02 = oraQrySelect02.FieldByName('PAYR_TEMP126').AsFloat ;              // 공란
				//   C_RecStr = C_RecStr   +  "0000000000"  ;

				C_RecStr = C_RecStr   + String.format("%020d", 0);	//공란// - 누적길이 1292

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC119"),"0"));       /*(56) column 세액감면_감면세액계 : TAXD_TSUM */     
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);


				// ------------------------ 세액공제 -------------------------------------------------------
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC120"),"0"));      /*(57) column 세액공제_근로소득세액공제 : TAXD_WKEN */ 
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1312

				//mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC121"),"0"));               //다자녀추가공제인원 -----
				//C_RecStr = C_RecStr   + String.format("%02d", mTempData02);
				//mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC122"),"0"));         //자녀세액공제
				//C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1324


				//     mTempData02 = oraQrySelect02.FieldByName('ADDR_MCAM').AsFloat;                 //다자녀추가공제금액 ------
				//      C_RecStr = C_RecStr  + FormatFloat('00000000', mTempData02);
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC123"),"0"));             //6세이하공제인원  -----
				C_RecStr = C_RecStr   + String.format("%02d",  mTempData02);// - 누적길이 1314
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC124"),"0"));              //6세이하공제금액 -------
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1324
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC125"),"0"));              //출산입양자공제인원 --------
				C_RecStr = C_RecStr   + String.format("%02d", mTempData02) ;// - 누적길이 1326
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC126"),"0"));            // 출산입양자공제금액 ---------
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;// - 누적길이 1336



				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC127"),"0"));                  //연금계좌_과학기술인공제_공제대상금액
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1346
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC128"),"0"));                  //연금계좌_과학기술인공제_세액공제액
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1356
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC129"),"0"));               //연금계좌_근로자퇴직 급여보장법에 따른 퇴직급여 공제대상금액
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1366
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC130"),"0"));                //연금계좌_근로자퇴직 급여보장법에 따른 퇴직급여 공제액
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1376
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC131"),"0"));               //연금계좌_ 연금저축 공제대상금액
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1386
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC132"),"0"));              //연금계좌_연금저축 세액공제액
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1396

				//mTempData02 = oraQrySelect02.FieldByName('SPCI_DETG').AsFloat ;                 //특별세액공제_보장성보험료_공제대상금액
				//C_RecStr = C_RecStr   + FormatFloat('0000000000',mTempData02) ;
				//mTempData02 = oraQrySelect02.FieldByName('SPCI_RTDE').AsFloat ;                 //특별세액공제_보장성보험효 세액공제액
				//C_RecStr = C_RecStr   + FormatFloat('0000000000',mTempData02) ;

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC133"),"0"));                //특별세액공제_보장성보험료_공제대상금액
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1406
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC134"),"0"));               // //특별공제_일반보장성보험료 세액공제액
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1416
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC135"),"0"));              //특별공제_장애인보장성대상금액
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1426
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC136"),"0"));                  //특특별공제_장애인보장성보험료 세액공제액
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1436


				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC137"),"0"));                 //특별세액공제_의료비_공제대상금액
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC138"),"0"));               //특별세액공제_의료비_세액공제액
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC139"),"0"));                 //특별세액공제_교육비_공제대상금액SPED_SFTR
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC140"),"0"));                 //특별세액공제_교육비_세액공제
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1476


				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC141"),"0"));                //특별세액공제_기부금_정치자금_10만원이하 공제 대상금액
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC142"),"0"));                  //특별세액공제_기부금_정치자금_10만원이하 공제
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1496
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC143"),"0"));                   //특별세액공제_기부금_정치자금_10만원초과  공제 대상금액
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;// - 누적길이1507
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC144"),"0"));                 //특별세액공제_기부금_정치자금_10만원초과  공제
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC145"),"0"));                 //특별세액공제_기부금_법정기부금 공제 대상금액
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;// - 누적길이 1528
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC146"),"0"));                 //특별세액공제_기부금_법정기부금 공제
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1538

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC147"),"0"));   /* (65)-다column 우리사주종합기부대상금액 : SPCI_HFTG */
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;// - 누적길이 1549
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC148"),"0"));    /*(65)-다 column 특별공제_기부금_우리사주조합세액공제액 : SPCI_RFAM */
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1559


				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC149"),"0"));                /*(65)-라 column  2014년이후 기부금합게 종교단체외지정대상금액 : SPCI_NATG */
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC150"),"0"));                 /*(65)-라 column 특별공제_기부금_특별공제_기부금_종교단체외 : SPCI_NAMT */
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1580


				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC150a"),"0"));                 /*(65)-라 column  2014년이후 기부금합게 종교단체지정대상금액 : SPCI_YATG */
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ; // - 누적길이 1591
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC150b"),"0"));                /*(65)-라 column 특별공제_기부금_특별공제_기부금_종교단체 : SPCI_YAMT */
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1601


				//     mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciNyag"),"0"));                 //특별세액공제_기부금_지정기부금 공제대상금액
				//    C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
				//     mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciNyam"),"0"));                 //특별세액공제_기부금 지정기부금 세액
				//    C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;


				// SPCI_NATG	종교단체외지정대상금액	 
				// SPCI_YATG	종교단체지정대상금액	 

				C_RecStr = C_RecStr   + String.format("%022d", 0);	//공란// - 누적길이 1623

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC151"),"0"));                 //특별세액공제 계
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC152"),"0"));              //표준 세액 공제
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;




				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC153"),"0"));               //납세조합공제
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;// - 누적길이 1653
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC154"),"0"));              //주택차입금
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
				//   mTempData02 = oraQrySelect02.FieldByName('TAXD_PLTC').AsFloat ;                  //기부정치자금
				//  C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC155"),"0"));               //외국납부
				C_RecStr = C_RecStr  + String.format("%010d",  mTempData02) ;


				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC156"),"0"));     /*(71) column 특별공제_월세세액공제대상금액 : SPCI_TGRT */ 
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;  // - 누적길이 1683      
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC157"),"0"));            //    월세 세액 공제
				C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ;// - 누적길이 1691

				C_RecStr = C_RecStr   + String.format("%020d", 0);	//공란// - 누적길이 1711

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC158"),"0"));               //세액공제계
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC159"),"0"));               //소득세
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC160"),"0"));                //지방소득세
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC161"),"0"));                  //농특세
				C_RecStr = C_RecStr    + String.format("%010d", mTempData02);// - 누적길이 1751
				//   mTempData02 = oraQrySelect02.FieldByName('DCSN_TOTL').AsFloat;                  //합계
				//   C_RecStr = C_RecStr    + FormatFloat('0000000000', mTempData02) ;

				//기납부세액 - 주현근무지  
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC162"),"0"));       //기납부소득세
				C_RecStr = C_RecStr    + String.format("%010d",  mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC163"),"0"));                  //기납부지방소득세
				C_RecStr = C_RecStr    + String.format("%010d", mTempData02);// - 누적길이 1771
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC164"),"0"));               //기납부농특세
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);


				//계산에 의해처리 해야 함......todo 
				//   C_RecStr = C_RecStr   +  "0000000000"  ;          //납부특례세액 _소득세
				//  C_RecStr = C_RecStr   +  "0000000000"  ;            //납부특례세액 _지방소득세
				//  C_RecStr = C_RecStr   +  "0000000000"  ;           //납부특례세액 _농특세 
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC165"),"0"));                //납부특례세액 _소득세
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC166"),"0"));               //납부특례세액 _지방소득세
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC167"),"0"));           //납부특례세액 _농특세 
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);// - 누적길이 1811


				//   mTempData02 = oraQrySelect02.FieldByName('ALRY_TOTL').AsFloat ;
				//   C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtEtaxb"),"0"));           //소득세음양
				C_RecStr = C_RecStr   + String.format("%01d",  mTempData02)  ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC168"),"0"));        //소득세
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;// - 누적길이 1822
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtInhbb"),"0"));          //지방소득세음양
				C_RecStr = C_RecStr  + String.format("%01d", mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC169"),"0"));          //지방소득세
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);// - 누적길이 1833
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtFafvb"),"0"));           //농특세음양
				C_RecStr = C_RecStr   + String.format("%01d", mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC170"),"0"));              //농특세
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);// - 누적길이 1844
				//C_RecStr = C_RecStr+ MSFSharedUtils.defaultNulls(mapYetaC.get("upDpobUtynC171"),"2");                              
				//C_RecStr = C_RecStr+ String.format("%-4s", MSFSharedUtils.defaultNulls(mapYetaC.get("mtstDpobSeilNumC172"),"")) ;
				
				//   mTempData02 = oraQrySelect02.FieldByName('SUBT_AMSUB').AsFloat ;
				//    C_RecStr = C_RecStr   + FormatFloat('0', mTempData02);
				//   mTempData02 = oraQrySelect02.FieldByName('SUBT_AMSU').AsFloat;
				//    C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
				C_RecStr = C_RecStr   + String.format("%-38s", "") ;

              
				TOT_Record.add(C_RecStr);

				D_Cnt = 1; 

				//fnPayrD_ReTax_Total_Select
				infcPkgYe161020Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
				List listYetaD = yeta3400PayrService.fnPayrD_ReTax_Total_Select(infcPkgYe161020Vo);
				//D 레코드 처리 화면  
				if (listYetaD.size() > 0) { 
					Iterator<Map<String, Object>> iter01 = listYetaD.iterator(); 

					while ( iter01.hasNext() ) { 

						Map<String, Object> mapYetaD = (Map<String, Object>) iter01.next(); 

						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

						mTempData02 = 0L;
						D_RecStr = "";
						D_RecStr = "D" + "20" + infcPkgYe161005Vo.getTxOffcCd();// - 누적길이 6
						D_RecStr = D_RecStr +   String.format("%06d", C_Cnt);  // - 누적길이12
						D_RecStr = D_RecStr +  String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-",""));// - 누적길이 22
						//D_RecStr = D_RecStr + String.format("%50s", "")  + String.format("%-13s", StringUtils.replace(MSFSharedUtils.defaultNulls(rrnDecCrypt,""),"-",""));
						D_RecStr = D_RecStr + String.format("%-13s", StringUtils.replace(MSFSharedUtils.defaultNulls(rrnDecCrypt,""),"-",""));// - 누적길이 35

						//근무처별 소득 명세 - 종전근무처  ,AD03.TAX_ASSO_YN 사용안함 
						D_RecStr = D_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaD.get("prcspTxpyrAsocYn"),"2")) ;  //todo 납세조합구분자 필요 
						//D_RecStr = D_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspFmnmNm"),"") ,58),60," ") ;
D_RecStr = D_RecStr + Han1(mapYetaD.get("prcspFmnmNm"),60) ;
						D_RecStr = D_RecStr + String.format("%-10s", MSFSharedUtils.defaultNulls(mapYetaD.get("prcspBusoprRgstnum"),""))  ;// - 누적길이 106
						D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspDutyBgnnDt"),"0"))); // - 누적길이 114
						D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspDutyEndDt"),"0"))); // - 누적길이 122
						D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspReduBgnnDt"),"0"))); 
						D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspReduEndDt"),"0"))); // - 누적길이 138
                               
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspPaySum"),"0"));  
						D_RecStr = D_RecStr +  String.format("%011d",mTempData02);// - 누적길이 149
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspAllwBnusSum"),"0")); 
						D_RecStr = D_RecStr +  String.format("%011d",mTempData02);// - 누적길이160
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspRcgtnBnusSum"),"0")); 
						D_RecStr = D_RecStr +  String.format("%011d", mTempData02);// - 누적길이171
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspStckEvntPrftSum"),"0")); 
						D_RecStr = D_RecStr +  String.format("%011d",mTempData02);// - 누적길이182
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspEmpStkscWdrwSum"),"0")); 
						D_RecStr = D_RecStr +  String.format("%011d",mTempData02);// - 누적길이193

						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspEcteRsgtnExceSum"),"0")); 
						D_RecStr = D_RecStr +  String.format("%011d",mTempData02);// - 누적길이204
						
						D_RecStr = D_RecStr +  String.format("%011d",0);	//직무발명 보상금	// - 누적길이 215

						D_RecStr = D_RecStr +  String.format("%022d",0);	// - 누적길이 237

						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspAggrSum"),"0")); 
						D_RecStr = D_RecStr +  String.format("%011d",mTempData02);	// - 누적길이 248

						//종전근무지 비과세소득 및 감면소득  
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSg01Jong"),"0"));  
						D_RecStr = D_RecStr   + String.format("%010d", mTempData02);	// - 누적길이 258
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh01Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh05Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh06Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh07Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh08Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh09Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02)  ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh10Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02)  ;	// - 누적길이 328
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh14Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh15Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh11Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;	// - 누적길이 358
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh12Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02)  ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh13Jong"),"0"));  
						D_RecStr = D_RecStr    +  String.format("%010d",  mTempData02) ;
						mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh16Jong"),"0"));  
						D_RecStr = D_RecStr    +  String.format("%010d",  mTempData02) ;	// - 누적길이 388

						D_RecStr = D_RecStr +  String.format("%010d",0);	//종교활동비	// - 누적길이 398

						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSi01Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);
						mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSk01Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm01Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm02Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;	// - 누적길이 438
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm03Jong"),"0"));  
						D_RecStr = D_RecStr  +  String.format("%010d",  mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSo01Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d", mTempData02)  ;
						mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSq01Jong"),"0")); 
						D_RecStr = D_RecStr  +  String.format("%010d", mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSr10Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;

						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSr11Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;

						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSs01Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	// - 누적길이 498

						D_RecStr = D_RecStr +  String.format("%010d",0);	//벤처기업 주식매수 선택권	// - 누적길이 508

						//mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt01Jong"),"0")); 
						//D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;
						mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy02Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy03Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	// - 누적길이 528

						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy04Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	// - 누적길이 538

						//  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy21"),"0")); 
						//  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy22Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);
						 
D_RecStr = D_RecStr   +  String.format("%010d",  0);	//외국인기술자	// - 누적길이 558
						
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt10Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	//중소기업 취업 청년소득세 감면 100%	// - 누적길이 568

						
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt11Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	//중소기업 취업 청년소득세 감면 50%	// - 누적길이 578
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt12Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	//중소기업 취업 청년소득세 감면 70%	// - 누적길이 588

						D_RecStr = D_RecStr +  String.format("%010d",0);	//중소기업 취업 청년소득세 감면 90%	// - 누적길이 598


						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt20Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	// - 누적길이 608

						D_RecStr = D_RecStr +  String.format("%020d",0);	// - 누적길이 628

						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("freeDtyAggrSum"),"0"));    //비과세계
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("reduIncmAggrSum"),"0"));   //감면소득계
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	// - 누적길이 648


						// mTempData02 = oLong.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("JUTR_EDDT"),"0"));raQrySelect03.FieldByName('TAXE_TOTL').AsFloat ;
						//   D_RecStr = D_RecStr +  FormatFloat('0000000000', mTempData02);
						//  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("JUTR_EDDT"),"0"));oraQrySelect03.FieldByName('PAYR_TEMP55').AsFloat ;
						//D_RecStr = D_RecStr + "0000000000";

						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspIncmTxSum"),"0")); 
						D_RecStr = D_RecStr +  String.format("%010d", mTempData02);
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspRgonIncmTxSum"),"0")); 
						D_RecStr = D_RecStr +  String.format("%010d", mTempData02);
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspNnksSum"),"0")); 
						D_RecStr = D_RecStr +  String.format("%010d", mTempData02);	// - 누적길이 678
						// mTempData02 =  oraQrySelect03.FieldByName('FARM_BTOT').AsFloat ;
						//  D_RecStr = D_RecStr  +  FormatFloat('0000000000',mTempData02);
						D_RecStr = D_RecStr +  String.format("%02d",  D_Cnt);	// - 누적길이 680
						D_RecStr = D_RecStr + String.format("%1202s", ""); 	// - 누적길이 1882


						TOT_Record.add(D_RecStr);


						D_Cnt = D_Cnt + 1;
					}
				}

				//E레코드
				E_Cnt = 1;
				E_RowCnt = 1;
				E_RecStr = "";

				infcPkgYe161020Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));

				List listYetaE = yeta3400PayrService.fnPayrE_ReTax_Total_Select(infcPkgYe161020Vo);

				// E레코드 파일처리 
 
				if ( listYetaE.size() > 0) { 
					Iterator<Map<String, Object>> iter03 = listYetaE.iterator(); 
					while ( iter03.hasNext() ) { 
                    	
						Map<String, Object> mapYetaE = (Map<String, Object>) iter03.next(); 

						mTempData02 = 0L;

						// 주민번호(복호화)
						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

						E_RecStr =  "E" + "20" + infcPkgYe161005Vo.getTxOffcCd() +  String.format("%06d", C_Cnt)
                                 +  String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-",""))
                                 + String.format("%-13s", StringUtils.replace(rrnDecCrypt,"-",""));	// - 누적길이 35

						if (listYetaE.size() + 1 > E_RowCnt)  {

							// E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  

							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("suptFmlyRltClCd")," ");    //연말정산부양관계코드 
							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("nnfClCd")," "); 
							//E_RecStr = E_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("txprNm"),"") ,28),30," ")   ;	// - 누적길이 67
E_RecStr = E_RecStr + Han1(mapYetaE.get("txprNm") ,30)   ;	// - 누적길이 67
//System.out.println("=======EEEE"+E_RecStr+"]["+E_RecStr.length());
							// 주민번호(복호화)
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("txprDscmNoCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

							E_RecStr = E_RecStr+ String.format("%-13s",rrnDecCrypt);  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bscDdcClCd")," ");  	// - 누적길이 81
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcClCd")," ");  
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("wmnDdcClCd")," ");   	// - 누적길이 83
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("sccDdcClCd")," ");	//경로우대공제  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("snprntFmlyDdcClCd")," ");  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("chbtAtprDdcClCd")," ");  //출산.입양공제	// - 누적길이 86
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("age6Lt")," ");  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("eduDdcDvcd")," ");	// - 누적길이 88 

							//소득공제국세청자료 
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("hifeDdcTrgt01"),"0"));          //보험료 _건강
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;	// - 누적길이 98

mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mcurUiTrgt02"),"0"));          //보험료 고용보험	
if("0".equals(mapYetaE.get("suptFmlyRltClCd")))
	E_RecStr = E_RecStr+   String.format("%010d", mTempData02);	// - 누적길이 108
else
	E_RecStr = E_RecStr+   String.format("%010d", 0);	// - 누적길이 108

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cvrgInscDdcTrgt01"),"0"));          //보험료 _보장성
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;	// - 누적길이 118

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcTrgt01"),"0"));          //보험료 _장애인보장성 국세청
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;	// - 누적길이 128

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsDdcTrgt01"),"0"));        // 의료비
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;	// - 누적길이 138

E_RecStr = E_RecStr+   String.format("%010d", 0);	//의료비 난임	// - 누적길이 148
E_RecStr = E_RecStr+ String.format("%010d", 0);	//의료비 장애인.건강보험산정특례자	// - 누적길이 158

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDdcTrgt01"),"0"));         //교육비
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;	// - 누적길이 168

							E_RecStr = E_RecStr+ String.format("%010d", 0);	//교육비 장애인 특수교육비	// - 누적길이 178

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt01"),"0"));        // 신용카드
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt01"),"0"));        //직불카드
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cshptDdcTrgt01"),"0"));          // 현금영수증
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;	// - 누적길이 208

							//2018년추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt01"),"0"));        //도서공연
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;	// - 누적길이 218

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt01"),"0"));        //전통시장
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;


							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt01"),"0"));        //대중교통
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	// - 누적길이 238

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("conbDdcTrgt01"),"0"));       //기부금
							E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;	// - 누적길이 251

							//소득공제자료 기타자료 
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("hifeDdcTrgt02"),"0"));          //보험료 _ 건강고용등외
							E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;	// - 누적길이 261

							E_RecStr = E_RecStr+ String.format("%010d", 0);	//보험료 고용보험	// - 누적길이 271

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cvrgInscDdcTrgt02"),"0"));     //보험료 _ 보장성
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	// - 누적길이 281

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcTrgt02"),"0"));         //보험료 _장애인보장성 외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	// - 누적길이 291


							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsDdcTrgt02"),"0"));        //의료비 외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;	// - 누적길이 301

							E_RecStr = E_RecStr+ String.format("%010d", 0);	//의료비 난임	// - 누적길이 311
							E_RecStr = E_RecStr+ String.format("%010d", 0);	//의료비 장애인.건강보험산정 특례자	// - 누적길이 321

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDdcTrgt02"),"0"));           //교육비 외
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;	// - 누적길이331

							E_RecStr = E_RecStr+ String.format("%010d", 0);	//교육비 장애인 특수교육	// - 누적길이 341

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt02"),"0"));       // 신용카드 외
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;	// - 누적길이351
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt02"),"0"));      //직북선불카드 외
							E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;	// - 누적길이 361

							//2018년추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt02"),"0"));      //도서공연
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	// - 누적길이 371

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt02"),"0"));      //전통시장 사용액 외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt02"),"0"));        //대중교통외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	// - 누적길이 391

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("conbDdcTrgt02"),"0"));      // 기부금외
							E_RecStr = E_RecStr+   String.format("%013d",mTempData02);	// - 누적길이 404

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
                                  + String.format("%30s","")
                                  + String.format("%13s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
                                  + String.format("%013d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%013d", 0);
 
							E_RowCnt =  E_RowCnt + 1;
						}
                 
						if (listYetaE.size() + 1 > E_RowCnt)  {

							// E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  

							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("suptFmlyRltClCd")," ");    //연말정산부양관계코드 
							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("nnfClCd")," "); 	// - 누적길이 406
							//E_RecStr = E_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("txprNm"),"") ,28),30," ")   ;	// - 누적길이 436
E_RecStr = E_RecStr + Han1(mapYetaE.get("txprNm"),30)   ;	// - 누적길이 436

							// 주민번호(복호화)
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("txprDscmNoCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);	// - 누적길이 449

							E_RecStr = E_RecStr+ String.format("%-13s",rrnDecCrypt);  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bscDdcClCd")," ");  
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcClCd")," ");  
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("wmnDdcClCd")," ");   
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("sccDdcClCd")," ");	//경로우대공제  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("snprntFmlyDdcClCd")," ");  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("chbtAtprDdcClCd")," ");  //출산.입양공제
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("age6Lt")," ");  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("eduDdcDvcd")," "); 	// - 누적길이 457

							//소득공제국세청자료 
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("hifeDdcTrgt01"),"0"));          //보험료 _건강
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;	// - 누적길이 467

							E_RecStr = E_RecStr+   String.format("%010d", 0);	//보험료 고용보험	// - 누적길이 477

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cvrgInscDdcTrgt01"),"0"));          //보험료 _보장성
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcTrgt01"),"0"));          //보험료 _장애인보장성 국세청
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsDdcTrgt01"),"0"));        // 의료비
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;	// - 누적길이 507

							E_RecStr = E_RecStr+   String.format("%010d", 0);	//의료비 난임	// - 누적길이 517
							E_RecStr = E_RecStr+ String.format("%010d", 0);	//의료비 장애인.건강보험산정특례자	// - 누적길이 527

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDdcTrgt01"),"0"));         //교육비
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;

							E_RecStr = E_RecStr+ String.format("%010d", 0);	//교육비 장애인 특수교육비	// - 누적길이 547

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt01"),"0"));        // 신용카드
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt01"),"0"));        //직불카드
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cshptDdcTrgt01"),"0"));          // 현금영수증
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;	// - 누적길이 577

							//2018년추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt01"),"0"));        //도서공연
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;	// - 누적길이 587

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt01"),"0"));        //전통시장
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;	// - 누적길이 597


							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt01"),"0"));        //대중교통
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("conbDdcTrgt01"),"0"));       //기부금
							E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;	// - 누적길이 620

							//소득공제자료 기타자료 
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("hifeDdcTrgt02"),"0"));          //보험료 _ 건강고용등외
							E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;	// - 누적길이 630

mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mcurUiTrgt02"),"0"));          //보험료 고용보험	
if("0".equals(mapYetaE.get("suptFmlyRltClCd")))
	E_RecStr = E_RecStr+   String.format("%010d", mTempData02);	// - 누적길이 640
else
	E_RecStr = E_RecStr+   String.format("%010d", 0);	// - 누적길이 640

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cvrgInscDdcTrgt02"),"0"));     //보험료 _ 보장성
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcTrgt02"),"0"));         //보험료 _장애인보장성 외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;


							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsDdcTrgt02"),"0"));        //의료비 외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;	// - 누적길이 670

							E_RecStr = E_RecStr+ String.format("%010d", 0);	//의료비 난임	// - 누적길이 680
							E_RecStr = E_RecStr+ String.format("%010d", 0);	//의료비 장애인.건강보험산정 특례자	// - 누적길이 690

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDdcTrgt02"),"0"));           //교육비 외
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;	// - 누적길이 700

							E_RecStr = E_RecStr+ String.format("%010d", 0);	//교육비 장애인 특수교육	// - 누적길이 710

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt02"),"0"));       // 신용카드 외
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt02"),"0"));      //직북선불카드 외
							E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;	// - 누적길이 730

							//2018년추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt02"),"0"));      //도서공연
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt02"),"0"));      //전통시장 사용액 외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt02"),"0"));        //대중교통외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	// - 누적길이 760

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("conbDdcTrgt02"),"0"));      // 기부금외
							E_RecStr = E_RecStr+   String.format("%013d",mTempData02);	// - 누적길이 773

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
                                  + String.format("%30s","")
                                  + String.format("%13s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
                                  + String.format("%013d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%013d", 0);

							E_RowCnt =  E_RowCnt + 1;
						}

						if (listYetaE.size() + 1 > E_RowCnt)  {

							// E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  

							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("suptFmlyRltClCd")," ");    //연말정산부양관계코드 	// - 누적길이 774
							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("nnfClCd")," "); 
							//E_RecStr = E_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("txprNm"),"") ,28),30," ")   ;	// - 누적길이 805
E_RecStr = E_RecStr + Han1(mapYetaE.get("txprNm"),30)   ;

							// 주민번호(복호화)
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("txprDscmNoCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

							E_RecStr = E_RecStr+ String.format("%-13s",rrnDecCrypt);  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bscDdcClCd")," ");  	// - 누적길이 819
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcClCd")," ");  
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("wmnDdcClCd")," ");   
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("sccDdcClCd")," ");	//경로우대공제  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("snprntFmlyDdcClCd")," ");  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("chbtAtprDdcClCd")," ");  //출산.입양공제
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("age6Lt")," ");  	// - 누적길이 825

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("eduDdcDvcd")," "); 	// - 누적길이 826

							//소득공제국세청자료 
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("hifeDdcTrgt01"),"0"));          //보험료 _건강
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;	// - 누적길이 836

							E_RecStr = E_RecStr+   String.format("%010d", 0);	//보험료 고용보험	// - 누적길이 846

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cvrgInscDdcTrgt01"),"0"));          //보험료 _보장성
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcTrgt01"),"0"));          //보험료 _장애인보장성 국세청
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsDdcTrgt01"),"0"));        // 의료비
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;	// - 누적길이 876

							E_RecStr = E_RecStr+   String.format("%010d", 0);	//의료비 난임	// - 누적길이 886
							E_RecStr = E_RecStr+ String.format("%010d", 0);	//의료비 장애인.건강보험산정특례자	// - 누적길이 896

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDdcTrgt01"),"0"));         //교육비
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;

							E_RecStr = E_RecStr+ String.format("%010d", 0);	//교육비 장애인 특수교육비	// - 누적길이 916

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt01"),"0"));        // 신용카드
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt01"),"0"));        //직불카드
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cshptDdcTrgt01"),"0"));          // 현금영수증
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;	// - 누적길이 946

							//2018년추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt01"),"0"));        //도서공연
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt01"),"0"));        //전통시장
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;


							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt01"),"0"));        //대중교통
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	// - 누적길이 976

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("conbDdcTrgt01"),"0"));       //기부금
							E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;	// - 누적길이 989

							//소득공제자료 기타자료 
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("hifeDdcTrgt02"),"0"));          //보험료 _ 건강고용등외
							E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;

mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mcurUiTrgt02"),"0"));          //보험료 고용보험	
if("0".equals(mapYetaE.get("suptFmlyRltClCd")))
	E_RecStr = E_RecStr+   String.format("%010d", mTempData02);	// - 누적길이 1009
else
	E_RecStr = E_RecStr+   String.format("%010d", 0);	// - 누적길이 1009

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cvrgInscDdcTrgt02"),"0"));     //보험료 _ 보장성
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcTrgt02"),"0"));         //보험료 _장애인보장성 외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;


							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsDdcTrgt02"),"0"));        //의료비 외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;	// - 누적길이 1039

							E_RecStr = E_RecStr+ String.format("%010d", 0);	//의료비 난임	// - 누적길이 1049
							E_RecStr = E_RecStr+ String.format("%010d", 0);	//의료비 장애인.건강보험산정 특례자	// - 누적길이 1059

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDdcTrgt02"),"0"));           //교육비 외
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;

							E_RecStr = E_RecStr+ String.format("%010d", 0);	//교육비 장애인 특수교육	// - 누적길이 1079

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt02"),"0"));       // 신용카드 외
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt02"),"0"));      //직북선불카드 외
							E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;	// - 누적길이 1099

							//2018년추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt02"),"0"));      //도서공연
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt02"),"0"));      //전통시장 사용액 외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt02"),"0"));        //대중교통외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	// - 누적길이 1129

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("conbDdcTrgt02"),"0"));      // 기부금외
							E_RecStr = E_RecStr+   String.format("%013d",mTempData02);	// - 누적길이 1142

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
                                  + String.format("%30s","")
                                  + String.format("%13s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
                                  + String.format("%013d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%013d", 0);

							E_RowCnt =  E_RowCnt + 1;
						}
						if (listYetaE.size() + 1 > E_RowCnt)  {

							// E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  

							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("suptFmlyRltClCd")," ");    //연말정산부양관계코드 
							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("nnfClCd")," "); 
							//E_RecStr = E_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("txprNm"),"") ,28),30," ")   ;
E_RecStr = E_RecStr + Han1(mapYetaE.get("txprNm"),30)   ;

							// 주민번호(복호화)
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("txprDscmNoCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

							E_RecStr = E_RecStr+ String.format("%-13s",rrnDecCrypt);  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bscDdcClCd")," ");  
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcClCd")," ");  
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("wmnDdcClCd")," ");   
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("sccDdcClCd")," ");	//경로우대공제  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("snprntFmlyDdcClCd")," ");  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("chbtAtprDdcClCd")," ");  //출산.입양공제
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("age6Lt")," ");  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("eduDdcDvcd")," "); 	// - 누적길이 1195

							//소득공제국세청자료 
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("hifeDdcTrgt01"),"0"));          //보험료 _건강
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

							E_RecStr = E_RecStr+   String.format("%010d", 0);	//보험료 고용보험	// - 누적길이 1215

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cvrgInscDdcTrgt01"),"0"));          //보험료 _보장성
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcTrgt01"),"0"));          //보험료 _장애인보장성 국세청
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsDdcTrgt01"),"0"));        // 의료비
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;	// - 누적길이 1245

							E_RecStr = E_RecStr+   String.format("%010d", 0);	//의료비 난임
							E_RecStr = E_RecStr+ String.format("%010d", 0);	//의료비 장애인.건강보험산정특례자	// - 누적길이 1265

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDdcTrgt01"),"0"));         //교육비
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;

							E_RecStr = E_RecStr+ String.format("%010d", 0);	//교육비 장애인 특수교육비	// - 누적길이 1285

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt01"),"0"));        // 신용카드
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt01"),"0"));        //직불카드
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cshptDdcTrgt01"),"0"));          // 현금영수증
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;	// - 누적길이 1325

							//2018년추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt01"),"0"));        //도서공연
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt01"),"0"));        //전통시장
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;


							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt01"),"0"));        //대중교통
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("conbDdcTrgt01"),"0"));       //기부금
							E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;	// - 누적길이 1358

							//소득공제자료 기타자료 
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("hifeDdcTrgt02"),"0"));          //보험료 _ 건강고용등외
							E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;

mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mcurUiTrgt02"),"0"));          //보험료 고용보험	
if("0".equals(mapYetaE.get("suptFmlyRltClCd")))
	E_RecStr = E_RecStr+   String.format("%010d", mTempData02);
else
	E_RecStr = E_RecStr+   String.format("%010d", 0);

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cvrgInscDdcTrgt02"),"0"));     //보험료 _ 보장성
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcTrgt02"),"0"));         //보험료 _장애인보장성 외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;


							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsDdcTrgt02"),"0"));        //의료비 외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;	// - 누적길이 1408

							E_RecStr = E_RecStr+ String.format("%010d", 0);	//의료비 난임	// - 누적길이 1418
							E_RecStr = E_RecStr+ String.format("%010d", 0);	//의료비 장애인.건강보험산정 특례자

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDdcTrgt02"),"0"));           //교육비 외
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;	// - 누적길이 1438

							E_RecStr = E_RecStr+ String.format("%010d", 0);	//교육비 장애인 특수교육	// - 누적길이 1448

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt02"),"0"));       // 신용카드 외
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt02"),"0"));      //직북선불카드 외
							E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;

							//2018년추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt02"),"0"));      //도서공연
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	// - 누적길이 1478

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt02"),"0"));      //전통시장 사용액 외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt02"),"0"));        //대중교통외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("conbDdcTrgt02"),"0"));      // 기부금외
							E_RecStr = E_RecStr+   String.format("%013d",mTempData02);	// - 누적길이 1511

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
                                  + String.format("%30s","")
                                  + String.format("%13s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
                                  + String.format("%013d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%013d", 0);

							E_RowCnt =  E_RowCnt + 1;
						}
                 
						if (listYetaE.size() + 1 > E_RowCnt)  {

							// E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  

							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("suptFmlyRltClCd")," ");    //연말정산부양관계코드 
							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("nnfClCd")," "); 
							//E_RecStr = E_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("txprNm"),"") ,28),30," ")   ;
E_RecStr = E_RecStr + Han1(mapYetaE.get("txprNm"),30)   ;

							// 주민번호(복호화)
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("txprDscmNoCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

							E_RecStr = E_RecStr+ String.format("%-13s",rrnDecCrypt);  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bscDdcClCd")," ");  
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcClCd")," ");  
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("wmnDdcClCd")," ");   
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("sccDdcClCd")," ");	//경로우대공제  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("snprntFmlyDdcClCd")," ");  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("chbtAtprDdcClCd")," ");  //출산.입양공제
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("age6Lt")," ");  

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("eduDdcDvcd")," "); 

							//소득공제국세청자료 
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("hifeDdcTrgt01"),"0"));          //보험료 _건강
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;	// - 누적길이 1574

mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mcurUiTrgt02"),"0"));          //보험료 고용보험	
if("0".equals(mapYetaE.get("suptFmlyRltClCd")))
	E_RecStr = E_RecStr+   String.format("%010d", mTempData02);
else
	E_RecStr = E_RecStr+   String.format("%010d", 0);

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cvrgInscDdcTrgt01"),"0"));          //보험료 _보장성
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcTrgt01"),"0"));          //보험료 _장애인보장성 국세청
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsDdcTrgt01"),"0"));        // 의료비
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

							E_RecStr = E_RecStr+   String.format("%010d", 0);	//의료비 난임
							E_RecStr = E_RecStr+ String.format("%010d", 0);	//의료비 장애인.건강보험산정특례자

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDdcTrgt01"),"0"));         //교육비
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;

							E_RecStr = E_RecStr+ String.format("%010d", 0);	//교육비 장애인 특수교육비

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt01"),"0"));        // 신용카드
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt01"),"0"));        //직불카드
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cshptDdcTrgt01"),"0"));          // 현금영수증
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

							//2018년추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt01"),"0"));        //도서공연
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt01"),"0"));        //전통시장
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;


							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt01"),"0"));        //대중교통
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("conbDdcTrgt01"),"0"));       //기부금
							E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;

							//소득공제자료 기타자료 
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("hifeDdcTrgt02"),"0"));          //보험료 _ 건강고용등외
							E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;

							E_RecStr = E_RecStr+ String.format("%010d", 0);	//보험료 고용보험

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cvrgInscDdcTrgt02"),"0"));     //보험료 _ 보장성
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcTrgt02"),"0"));         //보험료 _장애인보장성 외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;


							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsDdcTrgt02"),"0"));        //의료비 외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;

							E_RecStr = E_RecStr+ String.format("%010d", 0);	//의료비 난임
							E_RecStr = E_RecStr+ String.format("%010d", 0);	//의료비 장애인.건강보험산정 특례자

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDdcTrgt02"),"0"));           //교육비 외
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;

							E_RecStr = E_RecStr+ String.format("%010d", 0);	//교육비 장애인 특수교육

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt02"),"0"));       // 신용카드 외
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt02"),"0"));      //직북선불카드 외
							E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;

							//2018년추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt02"),"0"));      //도서공연
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt02"),"0"));      //전통시장 사용액 외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt02"),"0"));        //대중교통외
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("conbDdcTrgt02"),"0"));      // 기부금외
							E_RecStr = E_RecStr+   String.format("%013d",mTempData02);

							E_RowCnt =  E_RowCnt + 1;
//							try {
//							mapYetaE = (Map<String, Object>) iter03.next(); 
//							} catch (NoSuchElementException e) {
//							//e.printStackTrace();
//							}   

						}
						else
						{
							E_RecStr = E_RecStr + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%30s","")
                                  + String.format("%13s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%1s","")
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
                                  + String.format("%013d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%013d", 0);

							E_RowCnt =  E_RowCnt + 1;
						}
						E_RecStr = E_RecStr +  String.format("%02d",  E_Cnt);
                                  //+ String.format("%288s", "") ;

						TOT_Record.add(E_RecStr);
//System.out.println("=======E["+E_RecStr.length());
						E_Cnt = E_Cnt + 1;
						E_RecStr = ""; 

					}
				}

				// F레코드  - 연금저축등 소득세액공제명세 레코드 

				F_Cnt = 1;
				F_RowCnt = 1;
				F_RecStr = "";

				infcPkgYe161020Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));

				List listYetaF = yeta3400PayrService.fnPayrF_ReTax_Total_Select(infcPkgYe161020Vo);


				if ( listYetaF.size() > 0) { 

					Iterator<Map<String, Object>> iter04 = listYetaF.iterator(); 

					while ( iter04.hasNext() ) { 
                    	
						Map<String, Object> mapYetaF = (Map<String, Object>) iter04.next(); 

						mTempData02 = 0L;

						// 주민번호(복호화)
						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

						F_RecStr =  "F" + "20" + infcPkgYe161005Vo.getTxOffcCd() +  String.format("%06d", C_Cnt) + String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-",""))
                                  + String.format("%-13s",rrnDecCrypt ) ;
 
                   
						if (listYetaF.size() + 1 > F_RowCnt)  {
                  
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
                                   + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccFnnCmp"),""),58),60," ")  
+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccAccno"),""),18),20," ") ; 	// - 누적길이 120
+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;

							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자년도
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분	// - 누적길이 145

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
                                   +  String.format("%-60s","")
                                   + String.format("%-20s","")
                                   +  String.format("%010d", 0)
                                   +  String.format("%010d", 0)
								+  String.format("%04d", 0)
								+  String.format("%1s","");

							F_RowCnt =  F_RowCnt + 1;
						}

						if (listYetaF.size() + 1 > F_RowCnt)  {
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
									+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
									 //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccFnnCmp"),""),58),60," ")  
+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
									//+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccAccno"),""),18),20," ") ; 
+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);	// - 누적길이 240
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;

							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자년도
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분	// - 누적길이 255


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
                                   +  String.format("%-60s","")
                                   + String.format("%-20s","")
                                   +  String.format("%010d", 0)
                                   +  String.format("%010d", 0)
								+  String.format("%04d", 0)
								+  String.format("%1s","");

							F_RowCnt =  F_RowCnt + 1;
						}

						if (listYetaF.size() + 1 > F_RowCnt)  {
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
									+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccFnnCmp"),""),58),60," ")  
+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccAccno"),""),18),20," ") ;
+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;

							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자년도
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분	// - 누적길이 365


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
                                   +  String.format("%-60s","")
                                   + String.format("%-20s","")
                                   +  String.format("%010d", 0)
                                   +  String.format("%010d", 0)
								+  String.format("%04d", 0)
								+  String.format("%1s","");

							F_RowCnt =  F_RowCnt + 1;
						}

						if (listYetaF.size() + 1 > F_RowCnt)  {
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
								+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccFnnCmp"),""),58),60," ")  
+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccAccno"),""),18),20," ") ;
+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;

							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자년도
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분	// - 누적길이 475


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
                                   +  String.format("%-60s","")
                                   + String.format("%-20s","")
                                   +  String.format("%010d", 0)
                                   +  String.format("%010d", 0)
								+  String.format("%04d", 0)
								+  String.format("%1s","");

							F_RowCnt =  F_RowCnt + 1;
						}

						if (listYetaF.size() + 1 > F_RowCnt)  {
		                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
								+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccFnnCmp"),""),58),60," ")  
+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60) 
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccAccno"),""),18),20," ") ;
+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;

							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자년도
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분	// - 누적길이 585


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
                                   +  String.format("%-60s","")
                                   + String.format("%-20s","")
                                   +  String.format("%010d", 0)
                                   +  String.format("%010d", 0)
								+  String.format("%04d", 0)
								+  String.format("%1s","");

							F_RowCnt =  F_RowCnt + 1;
						}
						if (listYetaF.size() + 1 > F_RowCnt)  {
		                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
								+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccFnnCmp"),""),58),60," ")  
+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60) 
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccAccno"),""),18),20," ") ;
+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;

							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자년도
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분	// - 누적길이 695


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
                                   +  String.format("%-60s","")
                                   + String.format("%-20s","")
                                   +  String.format("%010d", 0)
                                   +  String.format("%010d", 0)
								+  String.format("%04d", 0)
								+  String.format("%1s","");

							F_RowCnt =  F_RowCnt + 1;
						}

						if (listYetaF.size() + 1 > F_RowCnt)  {
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
								+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccFnnCmp"),""),58),60," ")  
+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccAccno"),""),18),20," ") ;
+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;

							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자년도
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분	// - 누적길이 805


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
                                   +  String.format("%-60s","")
                                   + String.format("%-20s","")
                                   +  String.format("%010d", 0)
                                   +  String.format("%010d", 0)
								+  String.format("%04d", 0)
								+  String.format("%1s","");

							F_RowCnt =  F_RowCnt + 1;
						}
						if (listYetaF.size() + 1 > F_RowCnt)  {
		                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
								+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccFnnCmp"),""),58),60," ")  
+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccAccno"),""),18),20," ") ;
+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;

							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자년도
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분	// - 누적길이 915


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
                                   +  String.format("%-60s","")
                                   + String.format("%-20s","")
                                   +  String.format("%010d", 0)
                                   +  String.format("%010d", 0)
								+  String.format("%04d", 0)
								+  String.format("%1s","");

							F_RowCnt =  F_RowCnt + 1;
						}

						if (listYetaF.size() + 1 > F_RowCnt)  {
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
								+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccFnnCmp"),""),58),60," ")  
+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccAccno"),""),18),20," ") ;
+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;

							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자년도
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분	// - 누적길이 1025


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
                                   +  String.format("%-60s","")
                                   + String.format("%-20s","")
                                   +  String.format("%010d", 0)
                                   +  String.format("%010d", 0)
								+  String.format("%04d", 0)
								+  String.format("%1s","");

							F_RowCnt =  F_RowCnt + 1;
						}
						if (listYetaF.size() + 1 > F_RowCnt)  {
		                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
								+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccFnnCmp"),""),58),60," ")  
+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccAccno"),""),18),20," ") ;
+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;

							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자년도
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분	// - 누적길이 1135


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
                                   +  String.format("%-60s","")
                                   + String.format("%-20s","")
                                   +  String.format("%010d", 0)
                                   +  String.format("%010d", 0)
								+  String.format("%04d", 0)
								+  String.format("%1s","");

							F_RowCnt =  F_RowCnt + 1;
						}

						if (listYetaF.size() + 1 > F_RowCnt)  {
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
								+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccFnnCmp"),""),58),60," ")  
+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccAccno"),""),18),20," ") ;
+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;

							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자년도
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분	// - 누적길이 1245


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
                                   +  String.format("%-60s","")
                                   + String.format("%-20s","")
                                   +  String.format("%010d", 0)
                                   +  String.format("%010d", 0)
								+  String.format("%04d", 0)
								+  String.format("%1s","");

							F_RowCnt =  F_RowCnt + 1;
						}

						if (listYetaF.size() + 1 > F_RowCnt)  {
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccFnnCmp"),""),58),60," ")  
+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccAccno"),""),18),20," ") ;
+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;

					F_RecStr = F_RecStr +  String.format("%04d",0);	//투자년도
					F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분	// - 누적길이 1355


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
                                   +  String.format("%-60s","")
                                   + String.format("%-20s","")
                                   +  String.format("%010d", 0)
                                   +  String.format("%010d", 0)
								+  String.format("%04d", 0)
								+  String.format("%1s","");

					F_RowCnt =  F_RowCnt + 1;
				}

				if (listYetaF.size() + 1 > F_RowCnt)  {
					F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccFnnCmp"),""),58),60," ")  
+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccAccno"),""),18),20," ") ;
+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
					mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
					F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
					mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
					F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;

					F_RecStr = F_RecStr +  String.format("%04d",0);	//투자년도
					F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분	// - 누적길이 1465


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
                                   +  String.format("%-60s","")
                                   + String.format("%-20s","")
                                   +  String.format("%010d", 0)
                                   +  String.format("%010d", 0)
								+  String.format("%04d", 0)
								+  String.format("%1s","");

					F_RowCnt =  F_RowCnt + 1;
				}

				if (listYetaF.size() + 1 > F_RowCnt)  {
                     
					F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccFnnCmp"),""),58),60," ")  
+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccAccno"),""),18),20," ") ;
+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
					mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
					F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
					mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
					F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;

					F_RecStr = F_RecStr +  String.format("%04d",0);	//투자년도
					F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분	// - 누적길이 1575


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
                                   +  String.format("%-60s","")
                                   + String.format("%-20s","")
                                   +  String.format("%010d", 0)
                                   +  String.format("%010d", 0)
								+  String.format("%04d", 0)
								+  String.format("%1s","");

					F_RowCnt =  F_RowCnt + 1;
				}

				if (listYetaF.size() + 1 > F_RowCnt)  {
                     
					F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccFnnCmp"),""),58),60," ")  
+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
                                   //+ PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccAccno"),""),18),20," ") ;
+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
					mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
					F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
					mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
					F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;

					F_RecStr = F_RecStr +  String.format("%04d",0);	//투자년도
					F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분	// - 누적길이 1685


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
                                   +  String.format("%-60s","")
                                   + String.format("%-20s","")
                                   +  String.format("%010d", 0)
                                   +  String.format("%010d", 0)
								+  String.format("%04d", 0)
								+  String.format("%1s","");

					F_RowCnt =  F_RowCnt + 1;
				}


				F_RecStr = F_RecStr +  String.format("%02d",  F_RowCnt);
				F_RecStr = F_RecStr + String.format("%-195s","");
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
               
               infcPkgYe161020Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
               
               List listYetaG = yeta3400PayrService.fnPayrG_ReTax_Total_Select(infcPkgYe161020Vo);
                
 
               if ( listYetaG.size() > 0) { 
 
              	   Iterator<Map<String, Object>> iter05 = listYetaG.iterator(); 
             	   
                   while ( iter05.hasNext() ) { 
                    	
                     Map<String, Object> mapYetaG = (Map<String, Object>) iter05.next(); 
                           
                    
                     if ((listYetaG.size() > 0) &&  (MSFSharedUtils.paramNotNull( mapYetaG.get("mnthRnttyBurRgsum")) 
                     ||  MSFSharedUtils.paramNotNull( mapYetaG.get("comrCdtrNm")) || MSFSharedUtils.paramNotNull( mapYetaG.get("rntlCttLehdrNm"))))  {
                     
                    	// 주민번호(복호화)
         				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
         		          	 
                       mTempData02 = 0L;

                       G_RecStr =  "G" + "20" + infcPkgYe161005Vo.getTxOffcCd()  +  String.format("%06d", C_Cnt) +  String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-",""))
                                      + String.format("%-13s",rrnDecCrypt) ;	// - 누적길이 35

                       
                       if (listYetaG.size() + 1 > G_RowCnt)  {
                      
                    	// 주민번호(복호화)
          				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyBurRgsum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
          		          	 
                                    //G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyLehdrNm"),""),58),60," ")  
G_RecStr = G_RecStr + Han1(mapYetaG.get("mnthRnttyLehdrNm"),60)  
                                       +  String.format("%-13s", rrnDecCrypt);	// - 누적길이 108
                                   
                                       G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyHusFrmCd"),"") );
                                       G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyHusCnttArea"),"0.00")))),".","");     //소숫점처리

                                       //G_RecStr = G_RecStr +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlAddr"),"") ,98),100," ")  ;
G_RecStr = G_RecStr +  Han1(mapYetaG.get("mnthRnttyRntlAddr"),100)  ;

                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlBgnnDt"),"") ;	// - 누적길이 222
                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlEndDt"),"") ;	// - 누적길이 230

                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyYrlyMnthSum"),"0"));  
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	// - 누적길이 240
                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyTxDducSum"),"0"));   
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;	// - 누적길이 250

                                       rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("comrCdtrResnRegnNum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                                      
                                        //G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("comrCdtrNm"),"") ,58),60," ") 
G_RecStr = G_RecStr + Han1(mapYetaG.get("comrCdtrNm"),60) 
                                       + String.format("%-13s", rrnDecCrypt ) ;	// - 누적길이 323
                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("comrCnttPridBgnnDt"),"") ;	// - 누적길이 331
                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("comrCnttPridEndDt"),"")  ;	// - 누적길이 339

                                       G_RecStr = G_RecStr +  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("comrLoanItrtRate"),"0.00")))),".","") ;     //소숫점처리

                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrPclttAmtftAggr"),"0")); 
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;	// - 누적길이 353
                                        mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrPrnilSum"),"0"));
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrItrtSum"),"0"));
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrDducSum"),"0"));
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	// - 누적길이 383

                                       rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttBusoprRgstnum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                                       

                                       //G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttLehdrNm"),"") ,58),60," ")  
G_RecStr = G_RecStr + Han1(mapYetaG.get("rntlCttLehdrNm"),60)  
                                       + String.format("%-13s", rrnDecCrypt  );	// - 누적길이 456

                                       G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttHusFrmCd"),"")   );	// - 누적길이 457
                                       G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttHusCnttArea"),"0.00")))),".","")  ;     //소숫점처리

                                       //G_RecStr = G_RecStr +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttAddr"),"") ,98),100," ") ;	// - 누적길이 562
G_RecStr = G_RecStr +  Han1(mapYetaG.get("rntlCttAddr"),100) ;	// - 누적길이 562
                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttPridBgnnDt"),"") ;	// - 누적길이 570
                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttPridEndDt"),"")  ;	// - 누적길이 578

                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttChrtrGrnteSum"),"0"));
                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	// - 누적길이 588

                              G_RowCnt =  G_RowCnt + 1;
                              try {
                            	  mapYetaG = (Map<String, Object>) iter05.next(); 
                             	 } catch (NoSuchElementException e) {
                             		//e.printStackTrace();
                             	 }     
                              
                       }
                     else
                     {
                            G_RecStr = G_RecStr + String.format("%-60s","")
                                       + String.format("%-13s","")
                                       + String.format("%-1s","")
                                       +  "00000"
                                       + String.format("%-100s","")
                                       +  "00000000"
                                       +  "00000000"
                                       +  "0000000000"
                                       +  "0000000000"
                                       + String.format("%-60s","")
                                       + String.format("%-13s","")
                                       +  "00000000"
                                       +  "00000000"
                                       +  "0000"
                                       +  "0000000000"
                                       +  "0000000000"
                                       +  "0000000000"
                                       +  "0000000000"
                                        + String.format("%-60s","")
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
             				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyBurRgsum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
             		          	
             				  
                           //G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyLehdrNm"),"") ,58),60," ")   
G_RecStr = G_RecStr + Han1(mapYetaG.get("mnthRnttyLehdrNm"),60)   
                              +  String.format("%-13s",  rrnDecCrypt);	// - 누적길이 661

                              G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyHusFrmCd"),"") );
                              G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyHusCnttArea"),"0.00")))),".","");     //소숫점처리

                              //G_RecStr = G_RecStr +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlAddr"),"") ,98),100," ") ;
G_RecStr = G_RecStr +  Han1(mapYetaG.get("mnthRnttyRntlAddr"),100) ;

                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlBgnnDt"),"") ;	// - 누적길이 775
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlEndDt"),"") ;	// - 누적길이 783

                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyYrlyMnthSum"),"0"));  
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	// - 누적길이 793
                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyTxDducSum"),"0"));   
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;	// - 누적길이 803


                              rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("comrCdtrResnRegnNum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                             
                               //G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("comrCdtrNm"),"") ,58),60," ")   
G_RecStr = G_RecStr + Han1(mapYetaG.get("comrCdtrNm"),60)   
                              + String.format("%-13s", rrnDecCrypt ) ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("comrCnttPridBgnnDt"),"") ;	// - 누적길이 884
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("comrCnttPridEndDt"),"")  ;	// - 누적길이 892

                              G_RecStr = G_RecStr +  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("comrLoanItrtRate"),"0.00")))),".","") ;     //소숫점처리

                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrPclttAmtftAggr"),"0")); 
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;	// - 누적길이 906
                               mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrPrnilSum"),"0"));
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrItrtSum"),"0"));
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrDducSum"),"0"));
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	// - 누적길이 936

                              rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttBusoprRgstnum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                              

                             //G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttLehdrNm"),"") ,58),60," ")  
G_RecStr = G_RecStr + Han1(mapYetaG.get("rntlCttLehdrNm"),60)  
                              + String.format("%-13s", rrnDecCrypt );

                              G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttHusFrmCd"),"")   );
                              G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttHusCnttArea"),"0.00")))),".","")  ;     //소숫점처리

                              //G_RecStr = G_RecStr +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttAddr"),"") ,98),100," ") ;
G_RecStr = G_RecStr +  Han1(mapYetaG.get("rntlCttAddr"),100) ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttPridBgnnDt"),"") ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttPridEndDt"),"")  ;

                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttChrtrGrnteSum"),"0"));   
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	// - 누적길이 1141

                     G_RowCnt =  G_RowCnt + 1;
                     try {
                   	  mapYetaG = (Map<String, Object>) iter05.next(); 
                    	 } catch (NoSuchElementException e) {
                    		//e.printStackTrace();
                    	 }     
              }
            else
            {
                   G_RecStr = G_RecStr + String.format("%-60s","")
                              + String.format("%-13s","")
                              + String.format("%-1s","")
                              +  "00000"
                              + String.format("%-100s","")
                              +  "00000000"
                              +  "00000000"
                              +  "0000000000"
                              +  "0000000000"
                              + String.format("%-60s","")
                              + String.format("%-13s","")
                              +  "00000000"
                              +  "00000000"
                              +  "0000"
                              +  "0000000000"
                              +  "0000000000"
                              +  "0000000000"
                              +  "0000000000"
                               + String.format("%-60s","")
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
                				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyBurRgsum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                		          	
                				  
                           //G_RecStr = G_RecStr +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyLehdrNm"),"") ,58),60," ")  
G_RecStr = G_RecStr +  Han1(mapYetaG.get("mnthRnttyLehdrNm"),60)  
                              +  String.format("%-13s",  rrnDecCrypt);

                              G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyHusFrmCd"),"") );	// - 누적길이 1215
                              G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyHusCnttArea"),"0.00")))),".","");     //소숫점처리

                              //G_RecStr = G_RecStr +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlAddr"),"") ,98),100," ") ;
G_RecStr = G_RecStr +  Han1(mapYetaG.get("mnthRnttyRntlAddr"),100) ;

                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlBgnnDt"),"") ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlEndDt"),"") ;

                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyYrlyMnthSum"),"0"));  
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyTxDducSum"),"0"));   
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;	// - 누적길이 1356


                              rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("comrCdtrResnRegnNum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                             
                               //G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("comrCdtrNm"),"") ,58),60," ")  
G_RecStr = G_RecStr + Han1(mapYetaG.get("comrCdtrNm"),60)  
                              + String.format("%-13s", rrnDecCrypt ) ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("comrCnttPridBgnnDt"),"") ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("comrCnttPridEndDt"),"")  ;	// - 누적길이1445

                              G_RecStr = G_RecStr +  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("comrLoanItrtRate"),"0.00")))),".","") ;     //소숫점처리

                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrPclttAmtftAggr"),"0")); 
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
                               mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrPrnilSum"),"0"));
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrItrtSum"),"0"));
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrDducSum"),"0"));
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	// - 누적길이 1489


                              rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttBusoprRgstnum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                              
                             //G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttLehdrNm"),""),58),60," ")  
G_RecStr = G_RecStr + Han1(mapYetaG.get("rntlCttLehdrNm"),60)  
                              + String.format("%-13s", rrnDecCrypt );

                              G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttHusFrmCd"),"")   );
                              G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttHusCnttArea"),"0.00")))),".","")  ;     //소숫점처리

                              //G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttAddr"),""),98),100," ")  ;
G_RecStr = G_RecStr + Han1(mapYetaG.get("rntlCttAddr"),100)  ;
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttPridBgnnDt"),"") ;	// - 누적길이 1676
                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttPridEndDt"),"")  ;

                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttChrtrGrnteSum"),"0"));   
                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	// - 누적길이 1694

                     G_RowCnt =  G_RowCnt + 1;
//                     try {
//                   	  mapYetaG = (Map<String, Object>) iter05.next(); 
//                    	 } catch (NoSuchElementException e) {
//                    		//e.printStackTrace();
//                    	 }     
              }
            else
            {
                   G_RecStr = G_RecStr + String.format("%-60s","")
                              + String.format("%-13s","")
                              + String.format("%-1s","")
                              +  "00000"
                              + String.format("%-100s","")
                              +  "00000000"
                              +  "00000000"
                              +  "0000000000"
                              +  "0000000000"
                              + String.format("%-60s","")
                              + String.format("%-13s","")
                              +  "00000000"
                              +  "00000000"
                              +  "0000"
                              +  "0000000000"
                              +  "0000000000"
                              +  "0000000000"
                              +  "0000000000"
                               + String.format("%-60s","")
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
                                      + String.format("%-186s","");

                           TOT_Record.add(G_RecStr); 

                           G_Cnt = G_Cnt + 1;

                           G_RecStr = "";
                          

                     }
                   }
               }
 
               
               
               
               //---------------------------------------------------------------------------------
               //H레코드 - 기부금조정명세레코드 
               //---------------------------------------------------------------------------------

     	  //      DEFIN = "H"; //기부금  
            
	        //    Map<String, Object> mapTotData01 = (Map<String, Object>) iter.next();  
	          
     	        infcPkgYe161020Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
	              //SYSTEMKEY 가지고 데이타 가져오기 
	            //C 레코드 - 기부금 조정명세 레코드  YETA3170
	            List listHCData = yeta3400PayrService.fnPayrHC_ReTax_Total_Select(infcPkgYe161020Vo);  
	             
	            
	            if (listHCData.size() <= 0) { 
//	            		YetaMessageVO yetaMessVo = new YetaMessageVO();
//	    	 	         
//	     	 	      	yetaMessVo.setDispWindow("YETA2400");
//	     	 	      	yetaMessVo.setVeriRec("H레코드");
//	     	 	      	yetaMessVo.setVeriRecCtnt("기부금조정명세레코드");
//	     	 	      	yetaMessVo.setVeriTgtName(MSFSharedUtils.allowNulls(mapTotData01.get("kornName")));
//	     	 	      	yetaMessVo.setVeriError("C레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다.");
//	     	 	      	yetaMessVo.setVeriModCtnt("세액계산  작업 후 다시 생성 하십시요."); 
//	     
//	     			    bmResult.add(yetaMessVo);
	            	 
	             }
	              

	              H_RowCnt = 1;
	             
	              if (listHCData.size() > 0) { 
	                  H_Cnt = H_Cnt + 1;
	              }
	               
	              Iterator<Map<String, Object>> iter01 = listHCData.iterator(); 
	        	   
		          while ( iter01.hasNext() ) { 
		            	
		            Map<String, Object> mapHCData = (Map<String, Object>) iter01.next(); 
		             

		               // 주민번호(복호화)
		               rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		            		    
		               //소득자주민등록번호
//	                     if (!rrno_check(rrnDecCrypt)) {
	                     	
//	                     	YetaMessageVO yetaMessVo = new YetaMessageVO();
//	                     	
//	                     	yetaMessVo.setDispWindow("YETA1400");
//	 	     	 	      	yetaMessVo.setVeriRec("C레코드");
//	 	     	 	      	yetaMessVo.setVeriRecCtnt("기부금조정명세레코드");
//	 	     	 	        yetaMessVo.setVeriTgtName(MSFSharedUtils.allowNulls(mapTotData01.get("kornName")));
//	 	     	 	      	yetaMessVo.setVeriError("소득자 주민등록번호 오류");
//	 	     	 	      	yetaMessVo.setVeriModCtnt("소득자 본인 주민번호 확인 !"); 
//	 	     	 	        //세액감면및세액공제1->기부금->이월기부금
//	 	     			    bmResult.add(yetaMessVo);
//	                     } 
	                     
	                    strTempDataH = "";
	                    mTempDataH  = 0L;

	                    strTempDataH =  "H" + "20" ;
	                    strTempDataH = strTempDataH + infcPkgYe161005Vo.getTxOffcCd(); //세무서코드 	// - 누적길이 6
                     mTempDataH = Long.parseLong(String.valueOf(C_Cnt));
                     strTempDataH = strTempDataH +   String.format("%06d", mTempDataH);    //소득자일련번호 	// - 누적길이 12
                     strTempDataH = strTempDataH  +  String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-",""))
                     + String.format("%-13s",rrnDecCrypt ) ; //사업자등록번호	// - 누적길이 35
		               
                  
                     
                     
                     
                     mTempDataH =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("nnfClCd"),"1"));   //oraQrySelect01.FieldByName('FRNR_YENO').AsFloat;    
                     strTempDataH = strTempDataH +   String.format("%01d", mTempDataH);   	// - 누적길이 36  
                      if ((1 != mTempDataH) && (9 != mTempDataH)) {
                     	
//                     	YetaMessageVO yetaMessVo = new YetaMessageVO();
//                     	
//                     	yetaMessVo.setDispWindow("YETA1400");
// 	     	 	      	yetaMessVo.setVeriRec("C레코드");
// 	     	 	      	yetaMessVo.setVeriRecCtnt("기부금조정명세레코드");
// 	     	 	        yetaMessVo.setVeriTgtName(MSFSharedUtils.allowNulls(mapTotData01.get("kornName")));
// 	     	 	      	yetaMessVo.setVeriError("내외국인구분코드 오류 [" + MSFSharedUtils.defaultNulls(mapHCData.get("frnrYeno"),"값없음") + "]" );
// 	     	 	      	yetaMessVo.setVeriModCtnt("인적공제 탭 소득자 본인 내외국인 확인 !"); 
// 	     	 	        //세액감면및세액공제1->기부금->이월기부금
// 	     			    bmResult.add(yetaMessVo);
                     }  

                     
                     //strTempDataH = strTempDataH  +   PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapHCData.get("fnm"),""),28),30," "); 
strTempDataH = strTempDataH  +   Han1(mapHCData.get("fnm"),30); 
                     		//String.format("%-30s",  MSFSharedUtils.defaultNulls(mapHCData.get("kornName"),""));  //성명
                     strTempDataH = strTempDataH  +  String.format("%-2s",  MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""));    //유형코드	// - 누적길이 68
                  
                      if (!"10".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))
                     	 && !"20".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	
                     	 && !"40".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	
                     	 && !"41".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	
                     	 && !"42".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	) {
                     	 
//                     	 YetaMessageVO yetaMessVo = new YetaMessageVO();
//                      	
//                      	 yetaMessVo.setDispWindow("YETA1400");
//  	     	 	      	 yetaMessVo.setVeriRec("C레코드");
//  	     	 	      	 yetaMessVo.setVeriRecCtnt("기부금조정명세레코드");
//  	     	 	         yetaMessVo.setVeriTgtName(MSFSharedUtils.allowNulls(mapTotData01.get("kornName")));
//  	     	 	      	 yetaMessVo.setVeriError("유형코드 오류 [" + MSFSharedUtils.defaultNulls(mapHCData.get("frnrYeno"),"값없음") + "]" );
//  	     	 	      	 yetaMessVo.setVeriModCtnt("세액감면및세액공제1->기부금->이월기부금등록에 기부금조정명세확인 !<br>[10,20,40,41,42]가 아닌 유형코드 존재 "); 
//  	     	 	         //
//  	     			     bmResult.add(yetaMessVo);
  	     			    
                      }
                     
                     mTempDataH =  Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("attrYr"),"0")); 
                     strTempDataH = strTempDataH  +   String.format("%04d", mTempDataH);    //기부연도	// - 누적길이 72
                     
                     mTempDataH =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("useAmt"),"0"));   
                     strTempDataH = strTempDataH  +  String.format("%013d", mTempDataH);   //기부금액 - 13
                     mTempDataH =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("pyrDdcAmt"),"0"));   
                     strTempDataH = strTempDataH  +  String.format("%013d", mTempDataH);  //전년까지공제된금액 -13
                     mTempDataH =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("ddcTrgtAmt"),"0"));   
                     strTempDataH = strTempDataH  + String.format("%013d", mTempDataH);  //공제대상금액  -13	// - 누적길이 111
                     
                     strTempDataH = strTempDataH  + "0000000000000" ;   //해당년도공제금액 필요경비 THC_YR_DDC_AMT_ND_XPS	// - 누적길이 124
                     
                     mTempDataH =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("thcYrDdcAmt"),"0"));  
                     strTempDataH = strTempDataH  + String.format("%013d", mTempDataH);//해당년도공제금액세액금액 -13                        
                     mTempDataH =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("thcYrNducExtnAmt"),"0"));   
                     strTempDataH = strTempDataH  + String.format("%013d", mTempDataH); //해당년도공제받지못한금액소멸금액 -13
                     mTempDataH =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("thcYrNducCrfwAmt"),"0"));   
                     strTempDataH = strTempDataH  + String.format("%013d", mTempDataH); //해당년도에 공제받지못한금액_이월금액 -3	// - 누적길이 163
                     strTempDataH = strTempDataH  + String.format("%05d", H_RowCnt);       //기부금조정명세일련번호 -5	// - 누적길이 168
                     strTempDataH = strTempDataH  + String.format("%1714s", "");      //공란 -25

	                   TOT_Record.add(strTempDataH);
	                   H_RowCnt = H_RowCnt + 1;

		          }

	          
	               
	               //---------------------------------------------------------------------------------
	               //I레코드 - 해당년도기부금 레코드  
	               //---------------------------------------------------------------------------------  
		          I_Cnt = 1;
		             
		          infcPkgYe161020Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
	              //I레코드 - 해당연도 기부명세 레코드  
	              List listHDData = yeta3400PayrService.fnPayrHD_ReTax_Total_Select(infcPkgYe161020Vo); 
	               
	             if (listHCData.size() > 0) { 
	              
	              Iterator<Map<String, Object>> iter02 = listHDData.iterator(); 
	        	   
		          while ( iter02.hasNext() ) { 
		            	
		            Map<String, Object> mapHDData = (Map<String, Object>) iter02.next();

	                     strTempDataI = "";
	                     mTempDataI  = 0L;

	                    // 주민번호(복호화)
	 		              rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	 		            		   
	                      strTempDataI =  "I" + "20";
	                      strTempDataI = strTempDataI + infcPkgYe161005Vo.getTxOffcCd();  //세무서코드 
                        strTempDataI = strTempDataI + String.format("%06d", C_Cnt);     //소득자일련번호 
                       strTempDataI = strTempDataI + String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-",""));   //사업자등록번호 
                       
                       strTempDataI = strTempDataI +  String.format("%-13s", rrnDecCrypt);      //소득자주민등록번호
                       strTempDataI = strTempDataI +  String.format("%-2s",  MSFSharedUtils.defaultNulls(mapHDData.get("conbChgCd"),""));     //유형코드
                       
					   strTempDataI = strTempDataI +  String.format("%01d", 1);      //기부내용	// - 누적길이 38
                        
                       
                       strTempDataI = strTempDataI +  String.format("%-13s", StringUtils.replace(MSFSharedUtils.defaultNulls(mapHDData.get("bsnoEncCntn"),""),"-",""));    //사업자등록번호	// - 누적길이 51

                       //strTempDataI = strTempDataI + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapHDData.get("coplNm"),""),58),60," ");	// - 누적길이 111
strTempDataI = strTempDataI + Han1(mapHDData.get("coplNm"),60);	// - 누적길이 111
                       //String.format("%-30s", StringUtils.left(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbName"),""),30));    //상호 - 30
                                        
                       strTempDataI = strTempDataI +  String.format("%-1s",  MSFSharedUtils.defaultNulls(mapHDData.get("cnbtRltChgCd"),""));  //관계코드
                       strTempDataI = strTempDataI +  String.format("%-1s",  MSFSharedUtils.defaultNulls(mapHDData.get("nnfClCd"),""));     //내외국인구분코드
                       //strTempDataI = strTempDataI +  PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapHDData.get("cnbtFnm"),""),28),30," "); 	// - 누적길이 143
strTempDataI = strTempDataI +  Han1(mapHDData.get("cnbtFnm"),30); 	// - 누적길이 143
                       //String.format("%-20s", MSFSharedUtils.defaultNulls(mapHDData.get("cbtgName"),""));   //성명 - 20
                       // 주민번호(복호화)
	 		                 rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapHDData.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	 		            		   
                       strTempDataI = strTempDataI +  String.format("%-13s", rrnDecCrypt);    //기부자주민등록번호 	// - 누적길이 156
                       mTempDataI =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("dntScnt"),"1"));   
                       strTempDataI = strTempDataI +  String.format("%05d", mTempDataI);   //건수 - 5
                    
                       mTempDataI = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("useSumAmt"),"0"));   
                       strTempDataI = strTempDataI +  String.format("%013d", mTempDataI);     //기부금액 - 13

                       //2016년 추가 -----
                       mTempDataI = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ddcTrgtConbAmt"),"0"));   
                       strTempDataI = strTempDataI +  String.format("%013d", mTempDataI);     //공제대상기부금액
                       mTempDataI = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("conbSumAmt"),"0"));   
                       strTempDataI = strTempDataI +  String.format("%013d", mTempDataI);     //기부장려신청금액	// - 누적길이 200

                       strTempDataI = strTempDataI +  "0000000000000";	// - 누적길이213
                       
                       strTempDataI = strTempDataI + String.format("%05d", I_Cnt);    //일련번호 
                       
                       strTempDataI = strTempDataI +  String.format("%1664s", "");    //공란 42

	                   TOT_Record.add(strTempDataI);

	                      I_Cnt = I_Cnt + 1;
		           }
	             } 

	         
               C_Cnt = C_Cnt + 1;  
               
               //파일생성전 제출일자업데이트 쿼리 추가 
               // infcPkgYeta17FileDAO.updateYeta3400ToYe161010_S
              ye161010VO.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey"))); 
              yeta3400PayrService.updateYeta3400ToYe161010(ye161010VO); 

          } 
          
       
          
          File dir = new File("C:/EOSDATA/2018/");
          //디렉토리가 없으면 생성
          if(!dir.isDirectory()){
           dir.mkdirs();
          }
          
//        TOT_Record.SaveToFile('C:\EOSDATA\' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3) + '.denc');
          String fileDir = "C:/EOSDATA/2018/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc";
         // FileWriter fw = new FileWriter(fileDir); // 절대주소 경로 가능
          OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(fileDir),"EUC-KR");
          BufferedWriter bw = new BufferedWriter(osw);
          

          for (int iCnt=0;iCnt < TOT_Record.size();iCnt++) {
        	 String strWr = "";
        	 
        	 strWr = TOT_Record.get(iCnt);
        	 bw.write(strWr);  //\n + "\r"
        	 if ((TOT_Record.size() - 1) != iCnt) {
	              bw.newLine(); // 줄바꿈
	        	 }
          }
          
          bw.close();
          
          File objFile = new File("C:/EOSDATA/2018/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc");
          
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
  
  public int fnYeta3400_Tax_Ye1611010_File_Create(HttpServletRequest request,InfcPkgYe161010_2018_VO  ye161010VO,HttpServletResponse response) throws Exception  {
	 
	  if  (yeta3400PayrService== null) {
		    WebApplicationContext wac = WebApplicationContextUtils.
		    		getRequiredWebApplicationContext( request.getSession().getServletContext());
		  
		    yeta3400PayrService = (Yeta3400PayrService) wac.getBean("Yeta3400PayrService");
		}
	  
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
	  
//	  //{근로소득지급명세서}
//	  /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
//	  // 1. 암호화 객체 생성
//	  String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//	  
//	  /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/   
//	  
//	  DEFIN = "C"; //근로소득
//	  defBUNS_LINS = StringUtils.replace(ye161010VO.getBusiNumb(),"-","");   //사업자번호
//	  
//	  InfcPkgye161010VO infcPkgye161010VO = new InfcPkgye161010VO();
//	  
//	  A_Record = ("A" + "20" + ye161010VO.getTaxaCode() + String.format("%08d", Long.parseLong(StringUtils.replace(ye161010VO.getEdacPrdt(),"-","")))
//			  + String.format("%01d", Long.parseLong( ye161010VO.getIncmGbcd() ))   + String.format("%-6s", MSFSharedUtils.defaultNulls(ye161010VO.getTaxaDnum(),"")) 
//			  +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(ye161010VO.getHomeTxid() ,20),20," ")  
//			  +  String.format("%-4s", ye161010VO.getTaxaPrcd()) 
//			  +  String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-",""))
//			  +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(ye161010VO.getJuriName() ,38),40," ")  
//			  +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(ye161010VO.getCharDept() ,28),30," ") 
//			  +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(ye161010VO.getCharName(),28),30," ")    
//			  +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(ye161010VO.getCharTele() ,15),15," ")  
//			  +  String.format("%05d", 1) + "101"
//			  +  String.format("%1442s", ""));
//	  
//	  TOT_Record.add(A_Record);
//	  
//	  B_Cnt = 1;
//	  mTempData01 = 0L;
//	  
//	  try {
//		  
//		  
//		  Map mapYetaB = yeta3400PayrService.fnPayrB_ReTax_Total_Select(ye161010VO); 
//		  
//		  if (mapYetaB.isEmpty()) { 
////           showMessage('B레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.');
////           Result = -1;
////           Exit;
//		  }
//		  
//		  
//		  if (!"2".equals(MSFSharedUtils.defaultNulls(ye161010VO.getIncmGbcd(),""))) {
//			  
//			  //  if (MSFSharedUtils.paramNull(StringUtils.replace(ye161010VO.getJuriNumb(),"-","")) || StringUtils.replace(ye161010VO.getJuriNumb(),"-","").equals("null")) {
//			  
//			  //  RSNOSTR = StringUtils.replace(ye161010VO.getResuNumb(),"-","");    //사업자주민번호 
//			  // 주민번호(복호화)
//			  String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(ye161010VO.getResuNumb()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//			  
//			  RSNOSTR	  = rrnDecCrypt;
//			  
//		  }
//		  else
//		  {
//			  RSNOSTR =  StringUtils.replace(ye161010VO.getJuriNumb(),"-","");   //법인번호
//		  }
//		  
//		  B_RecStr = "";
//		  mTempData01 = 0L ;
//		  
//		  
//		  B_RecStr = "B" + "20" + ye161010VO.getTaxaCode() +  String.format("%06d", B_Cnt)   +   String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-",""))
//				  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(ye161010VO.getJuriName() ,38),40," ")  
//				  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(ye161010VO.getReprName() ,28),30," ")  
//				  + String.format("%-13s", StringUtils.replace(RSNOSTR,"-",""))  ;
//		  mTempData01 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("psnlJuCnt"),"0"));
//		  B_RecStr =  B_RecStr  +  String.format("%07d", mTempData01);    //주근무지 레코드 수 
//		  mTempData01 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("psnlJungCnt"),"0"));  
//		  B_RecStr =  B_RecStr + String.format("%07d", mTempData01);     //종전근무지 레코드 수 
//		  
//		  mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("totlSala"),"0")); 
//		  B_RecStr =  B_RecStr + String.format("%014d", mTempData01);   //총급여 총계_현전
//		  mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("dcsnIncm"),"0"));  
//		  B_RecStr =  B_RecStr   +  String.format("%013d", mTempData01);    //결정세액 소득세 
//		  //  mTempData01 =  oraQrySelect01.FieldByName('GONG_TEMP01').AsFloat;
//		  //  B_RecStr =  B_RecStr  + FormatFloat('0000000000000', mTempData01);
//		  mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("desnInhb"),"0"));    
//		  B_RecStr =  B_RecStr  + String.format("%013d", mTempData01);   //결정세액 지방소득세
//		  mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("dcsnFafv"),"0"));  
//		  B_RecStr =  B_RecStr   + String.format("%013d", mTempData01);    //결정세액 농특세
//		  mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("dcsnTotl"),"0")); 
//		  B_RecStr =  B_RecStr  + String.format("%013d", mTempData01);    //결정세액 총계
//		  B_RecStr =  B_RecStr  + "1"; //체출기간 연간합산제출등 코드로 등록하여 처리 하게 수정 필요 
//		  B_RecStr =  B_RecStr +  String.format("%1434s", "");     //공란 
//		  
//		  TOT_Record.add(B_RecStr);
//		  
//		  C_Cnt =  1;
//		  
//		  //c레코드 주현근무처 레코드 fnPayrC_ReTax_Total_Select
//		  List listYetaC = yeta3400PayrService.fnPayrC_ReTax_Total_Select(ye161010VO);
//		  
//		  if (listYetaC.size() <= 0) {  
//			  throw new Exception("C레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.");  
//		  } 
//		  
//		  Iterator<Map<String, Object>> iter = listYetaC.iterator(); 
//		  
//		  while ( iter.hasNext() ) { 
//			  
//			  Map<String, Object> mapYetaC = (Map<String, Object>) iter.next();  
//			  
//			  mTempData02 = 0L;
//			  C_RecStr = "";
//			  //  oraQrySelect01.FieldByName('CITY_SEQN').AsString; Format('%.11d', [])
//			  C_RecStr = "C" ;   //레코드구분
//			  C_RecStr = C_RecStr + "20"; //자료구분 
//			  C_RecStr = C_RecStr   + ye161010VO.getTaxaCode(); //세무서코드 
//			  C_RecStr = C_RecStr + String.format("%06d", C_Cnt);    //원천징수읨주별로 1부터 순차부여 
//			  C_RecStr = C_RecStr  +  String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-",""));  //사업자등록번호 
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("befoScnt"),"0"));             /*  종전근무처수 */    
//			  C_RecStr = C_RecStr  + String.format("%02d",mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("resdFlag"),"1"));        //거주자구분코드
//			  C_RecStr = C_RecStr  + String.format("%01d", mTempData02);
//			  C_RecStr = C_RecStr  + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaC.get("redtGbcd"),"")  );    //거주지국코드
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("frnrSgyn"),"2"));                        //단일세율적용여부
//			  C_RecStr = C_RecStr  + String.format("%01d", mTempData02) ;
//			  //2016귀속 추가 ㄴ
//			  C_RecStr = C_RecStr  + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("frnrRnyn"),"2")  );    //외국법인소속 파견근로자여부 
//			  
//			  C_RecStr = C_RecStr  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaC.get("kornName"),"") ,28),30," ") ;    //성명
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("frnrYeno"),"1"));                                 //내외국인구부노드
//			  C_RecStr = C_RecStr  +  String.format("%01d",  mTempData02) ;
//			  
//			  // 주민번호(복호화)
//			  String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//			  
//			  C_RecStr = C_RecStr  + String.format("%-13s",rrnDecCrypt);     //주민등록번호
//			  
//			  
//			  C_RecStr = C_RecStr  + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaC.get("natnNbcd"),"") );       //국적코드
//			  C_RecStr = C_RecStr  + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("gnanSgtf"),"") );       //세대주구분코드
//			  C_RecStr = C_RecStr   + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("hoofStcd"),"")) ;       //연말정산구분 계속근로,중도퇴사
//			  C_RecStr = C_RecStr   + String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-","")) ;            //주현근무처-사업자등록번호
//			  C_RecStr = C_RecStr   + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(ye161010VO.getJuriName() ,38),40," ") ;                                     //주현근무처-근무처명
//			  
//			  
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("reymStdt"),"0"));                                  //근무기간시작연월일
//			  C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("reymEddt"),"0"));                                 //근무기간 종료일자
//			  C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("rutrStdt"),"0"));                                  //감면기간시작일자
//			  C_RecStr = C_RecStr  +  String.format("%08d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("rutrEddt"),"0"));                                    //감면기간종료일자
//			  C_RecStr = C_RecStr  +  String.format("%08d", mTempData02);
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTamt"),"0"));                                 //급여총액
//			  C_RecStr = C_RecStr  + String.format("%011d", mTempData02);
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("bonsToam"),"0"));                                   //상여총액
//			  C_RecStr = C_RecStr  + String.format("%011d",  mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dtmnBsam"),"0"));                               //인정상여
//			  C_RecStr = C_RecStr  + String.format("%011d",  mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("stckPrft"),"0"));                                //주식행사이익
//			  C_RecStr = C_RecStr  + String.format("%011d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp26"),"0"));                               //우리사주조합인출금
//			  C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp27"),"0"));                                 //임원 퇴직소득금액 한도초과액
//			  C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);
//			  
//			  C_RecStr = C_RecStr  + "000000000000000000000";
//			  C_RecStr = C_RecStr   +  String.format("%011d", Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaC.get("currTots"),"0"))) ;                    //계
//			  
//			  //주현근무처 비과세소득 및 감면소득  
//			  //       mTempData02 = oraQrySelect02.FieldByName('PAYR_TEMP29').AsFloat;
//			  //       C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSg01"),"0"));  
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh01"),"0"));  
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh05"),"0"));  
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh06"),"0"));  
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh07"),"0"));  
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh08"),"0"));  
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh09"),"0"));  
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh10"),"0"));  
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh14"),"0"));  
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh15"),"0"));  
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh11"),"0"));  
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh12"),"0"));  
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh13"),"0"));  
//			  C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh16"),"0"));  
//			  C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSi01"),"0"));  
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSk01"),"0"));  
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm01"),"0")); 
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm02"),"0"));  
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm03"),"0"));  
//			  C_RecStr = C_RecStr  +  String.format("%010d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSo01"),"0")); 
//			  C_RecStr = C_RecStr   +  String.format("%010d", mTempData02)  ;
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSq01"),"0")); 
//			  C_RecStr = C_RecStr  +  String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSr10"),"0")); 
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSs01"),"0"));  
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt01"),"0")); 
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy02"),"0")); 
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy03"),"0"));  
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//			  //2016년 귀속 추가 
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy04"),"0"));  
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy21"),"0")); 
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy22"),"0")); 
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt10"),"0")); 
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//			  
//			  //2016년귀속 추가 
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt11"),"0")); 
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt12"),"0")); 
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//			  
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt20"),"0")); 
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp60"),"0"));    //비과세계
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp61"),"0"));   //감면소득계
//			  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//			  
//			  //  C_RecStr = C_RecStr   + "0000000000";//공란 0으로 10자리       
//			  
//			  //정산명세 처리 시작    
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("totlSala"),"0"));         /*(16 합계)(21)번  column 총급여_현_전 : TOTL_SALA */          
//			  C_RecStr = C_RecStr   +  String.format("%011d", mTempData02);
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("wkerDdct"),"0"));    /* (22) column 근로소득공제 : WKER_DDCT */    
//			  C_RecStr = C_RecStr   +  String.format("%010d", mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("wkerAmnt"),"0"));      /*(23) column 근로소득금액 : WKER_AMNT */  
//			  C_RecStr = C_RecStr   +  String.format("%011d", mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("baseSelf"),"0"));  /*(24) column 기본공제_본인 : BASE_SELF */         
//			  C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("baseWife"),"0")); /*(25) column 기본공제_배우자 : BASE_WIFE */         
//			  C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("baseFmly"),"0"));   /*(26) column 기본공제_부양가족수 : BASE_FMLY */  
//			  C_RecStr = C_RecStr   + String.format("%02d", mTempData02) ;
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("baseFyam"),"0"));   /*(26) column 기본공제_부양가족 : BASE_FYAM */     
//			  C_RecStr = C_RecStr   + String.format("%08d",mTempData02)  ;
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrCt70"),"0"));  /*(70) column 추가공제_경로우대_70세이상수 : ADDR_CT70 경로우대공제인원 */       
//			  C_RecStr = C_RecStr   + String.format("%02d",mTempData02);
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrRpt70"),"0"));  /*(27) column 추가공제_경로우대70 : ADDR_RPT70 1946.12.31 */   
//			  C_RecStr = C_RecStr   + String.format("%08d", mTempData02) ;
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrHdrc"),"0"));  /*(28) column 추가공제_장애인수 : ADDR_HDRC */    
//			  C_RecStr = C_RecStr   + String.format("%02d",mTempData02);
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrHdam"),"0"));   /*(28) column 추가공제_장애인 금액 : ADDR_HDAM */     
//			  C_RecStr = C_RecStr   + String.format("%08d", mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrFame"),"0")); /*(29) column 추가공제_부녀자  금액 : ADDR_FAME */      
//			  C_RecStr = C_RecStr   + String.format("%08d", mTempData02);
//			  
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("pantOnam"),"0"));   /*(30) column 추가공제_한부모공제금액 : PANT_ONAM */         
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  
//			  //연금보험료공제 
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jbnatDdct"),"0"));    /*(31) column_국민연금보험료공제 : JNAT_DDCT */       
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jpssHpul"),"0"));    /*(32)-가 column  _공무원연금보험료공제 : JPSS_HPUL */   
//			  C_RecStr = C_RecStr  + String.format("%010d",  mTempData02);
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jpssHsol"),"0"));    /*(32)-나 column 주근무지_국민연금외군인연금공제 : JPSS_HSOL */  
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jpssHtec"),"0"));    /*(32)-다 column 주근무지_국민연금외교직원연금공제 : JPSS_HTEC */ 
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jbssDdct"),"0"));        /*(32)-라 column_별정우체국연금보험료공제 : JPSS_DDCT */   
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//			  
//			  //  mTempData02 = oraQrySelect02.FieldByName('JRTR_HICT').AsFloat ;                //퇴직연금-과학기술인공제  ---
//			  //  C_RecStr = C_RecStr  + FormatFloat('0000000000', mTempData02) ;
//			  //  mTempData02 = oraQrySelect02.FieldByName('JBRTR_PSRN').AsFloat;                 //퇴직연금-근로자보장법  ----
//			  //  C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02) ; 
//			  //  mTempData02 = oraQrySelect02.FieldByName('JRTR_HNSV').AsFloat;                 //퇴직연금-연금저축  --------
//			  //  C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02) ;
//			  
//			  //특별소득공제 
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciJbhth"),"0"));   /*(33)-가 column 특별공제_주건강보험료 : SPCI_JHTH */   
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciJbepf"),"0"));    /*(33)-나 column 특별공제_주고용보험료 : SPCI_JEPF */   
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//			  //   mTempData02 = oraQrySelect02.FieldByName('SPCI_GURT').AsFloat ;                  //일반보장성보험료
//			  //   C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
//			  //   mTempData02 = oraQrySelect02.FieldByName('SPCI_HDRC').AsFloat;                   //장애인전용보험료
//			  //   C_RecStr = C_RecStr  + FormatFloat('0000000000', mTempData02);
//			  //  mTempData02 = oraQrySelect02.FieldByName('SPCI_HBPS').AsFloat ;                  //의료비공제금액_장애인
//			  //  C_RecStr = C_RecStr  + FormatFloat('0000000000', mTempData02) ;
//			  //   mTempData02 = oraQrySelect02.FieldByName('SPCI_METO').AsFloat ;                  //의료비공제금액
//			  //  C_RecStr = C_RecStr  + FormatFloat('0000000000', mTempData02) ;
//			  //  mTempData02 = oraQrySelect02.FieldByName('SPCI_SPEC').AsFloat ;                  //교육비공제금액_장애인
//			  //  C_RecStr = C_RecStr   + FormatFloat('00000000', mTempData02)  ;
//			  //   mTempData02 = oraQrySelect02.FieldByName('SPED_TOAM').AsFloat ;                  //교육비공제금액
//			  //   C_RecStr = C_RecStr   + FormatFloat('00000000', mTempData02)  ;
//			  
//			  
//			  // 주택자금(주택임차차입금,장기주택저당차입금,주택마련저축) 관련공통사항 
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciRefn"),"0"));            /*(34)-가 column 특별공제_차입금원리금상환액_대출기관 : SPCI_REFN */   
//			  C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciResf"),"0"));               /*(34)-가 column 특별공제_차입금원리금상환액_거주자 : SPCI_RESF */ 
//			  C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ; 
//			  
//			  // mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("befoScnt"),"0")); oraQrySelect02.FieldByName('SPCI_HTAM').AsFloat ;                   //주택자금-월세액 대상금액
//			  // C_RecStr = C_RecStr   + FormatFloat('00000000', mTempData02); 
//			  
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spchRe15"),"0"));    /*(34)-나 column 특별공제_11장기주택저당차입금15 : SPCH_RE15 */  
//			  C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spchRe29"),"0"));      /*(34)-나 column 특별공제_11장기주택저당차입금29 : SPCH_RE29 */   
//			  C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spchRe30"),"0"));      /* (34)-나column 특별공제_11장기주택저당차입금30 : SPCH_RE30 */   
//			  C_RecStr = C_RecStr  + String.format("%08d", mTempData02); 
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciRefx"),"0"));     /*(34)-나 column 특별공제_12장기주택저당차입금_고정 : SPCI_REFX */     
//			  C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciReec"),"0"));    /*(34)나 column 특별공제_12장기주택저당차입금_기타 : SPCI_REEC */
//			  C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spci15fx"),"0"));   /*(34)-나 column 특별공제_15장기주택저당_15고정AND비거치상환 : SPCI_15FX */
//			  C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spci15fb"),"0"));     /*(34)-나 column 특별공제_15장기주택저당_15고정OR비거치상환 : SPCI_15FB */
//			  C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spci15ec"),"0"));     /*(34)-나 column 특별공제_15장기주택저당_15기타대출 : SPCI_15EC */
//			  C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spci10fb"),"0"));      /*(34)-나 column 특별공제_15장기주택저당_10고정OR비거치상환 : SPCI_10FB */
//			  C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciSsum"),"0"));     /*(35) column 이월분  특별공제_기부금공제액계 : SPCI_SSUM */    
//			  C_RecStr = C_RecStr   + String.format("%011d", mTempData02);
//			  
//			  // mTempData02 = oraQrySelect02.FieldByName('SPCI_PLTC').AsFloat ;                  //기부금공제금액 _정치
//			  // C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
//			  //  mTempData02 = oraQrySelect02.FieldByName('SPCI_FBAM').AsFloat ;                  //기부금공제금액_법정
//			  // C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
//			  //   mTempData02 = oraQrySelect02.FieldByName('SPCI_RFAM').AsFloat ;                  //기부금공제금액_우리사주조합기부금
//			  // C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
//			  //  mTempData02 = oraQrySelect02.FieldByName('SPCI_NYAM').AsFloat ;                  //기부금공제금액_지정기부금
//			  //  C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
//			  // C_RecStr = C_RecStr   + "00000000000000000000" ;  //공란 
//			  
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spsmTotl"),"0"));   /*96  (36)    //특별소득공제 계  */
//			  C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);
//			  //mTempData02 =  oraQrySelect02.FieldByName('SPCI_DDCT').AsFloat;                 //표준공제
//			  //C_RecStr = C_RecStr  + FormatFloat('00000000', mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtEram"),"0"));       /* (97) column 차감소득금액 : SUBT_ERAM */  
//			  C_RecStr = C_RecStr  + String.format("%011d", mTempData02);
//			  
//			  //그 밖의 소득공제  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etcpPsnv"),"0"));     /* (98)column 개인연금저축불입액_2000년이전 : ETCP_PSNV */  
//			  C_RecStr = C_RecStr   + String.format("%08d", mTempData02);
//			  //     mTempData02 = oraQrySelect02.FieldByName('ETCP_NSAV').AsFloat;                 //연금저축소득공제
//			  //    C_RecStr = C_RecStr  + FormatFloat('00000000', mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etchPrep"),"0"));    /* (99) column 기타공제_소기업공제불입금 : ETCH_PREP */    
//			  C_RecStr = C_RecStr  + String.format("%010d", mTempData02);
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etcsComp"),"0"));   /*(100)-가 column 기타공제_주택마련저축_청약저축 : ETCS_COMP */       
//			  C_RecStr = C_RecStr  + String.format("%010d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etwkSbam"),"0"));    /* (101)-나column 기타공제_주택마련저축_주택청약종합저축 : ETWK_SBAM */       
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  //  mTempData02 = oraQrySelect02.FieldByName('ETWK_LGAM').AsFloat ;                  //장기주택마련저축
//			  //  C_RecStr = C_RecStr   + FormatFloat('0000000000',mTempData02) ;
//			  mTempData02 =Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etwkSvam"),"0"));   /*(102)-다 column 기타공제_주택마련저축_근로자주택마련저축 : ETWK_SVAM */
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etgdDdam"),"0"));        /* (103) column 기타공제_투자조합출자공제액 : ETGD_DDAM */   
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etccCard"),"0"));     /*(104) column 기타공제_신용카드등사용액소득공제 : ETCC_CARD */ 
//			  C_RecStr = C_RecStr   + String.format("%08d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etckUnon"),"0"));       /*(105) column 기타공제_우리사주출연금공제 : ETCK_UNON */      
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//			  
//			  //  mTempData02 = Long.parseLong("0");                  //우리사주조합기부금
//			  //  C_RecStr = C_RecStr   + "00000000000";
//			  
//			  //mTempData02 = oraQrySelect02.FieldByName('ETCL_HMTO').AsFloat  ;                 //장기주식형저축소득공제
//			  // C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etepMsam"),"0"));       /*(45) column 기타공제_고용유지중소기업근로자임금삭감공제액 : ETEP_MSAM */ 
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//			  
//			  //  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etgdHtra"),"0"));       /*(46) column 기타공제_목돈안드는전세이자상환소득공제액 : ETGD_HTRA */        
//			  C_RecStr = C_RecStr   + "0000000000";                                                       //String.format("%010d",  mTempData02)  ;
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etepSecr"),"0"));      /*(47) column 기타공제_장기집합투자증권저축공제액 : ETEP_SECR */  
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02)  ;
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etclTotl"),"0"));      /*(48) column 기타공제_공제계 : ETCD_TSUM */   
//			  C_RecStr = C_RecStr  + String.format("%011d",  mTempData02);
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spchExli"),"0"));     /*(49) column 특별공제_종합한도초과금액 : SPCH_EXLI */     
//			  C_RecStr = C_RecStr   + String.format("%011d",  mTempData02) ;
//			  
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("stndIncm"),"0"));     /*(50) column 종합소득과세표준 : STND_INCM */        
//			  C_RecStr = C_RecStr   + String.format("%011d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("prddTaxn"),"0"));         /*(51) column 산출세액 : PRDD_TAXN */         
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//			  
//			  //------------------------ 세액감면 ------------------------------ 
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdIcax"),"0"));     /*(52) column 세액감면_소득세법 : TAXD_ICAX */    
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdSpct"),"0"));     /*(53) column 세액감면_조세특례법 : TAXD_SPCT */        
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02)  ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("txlgCl30"),"0"));  /*(54) column 세액감면_조세특례법제30조 : TXLG_CL30 */   
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02)  ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("txlgHxtt"),"0"));    /*(55) column 세액감면_조세조약 : TXLG_HXTT */   
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//			  //   mTempData02 = oraQrySelect02.FieldByName('PAYR_TEMP126').AsFloat ;              // 공란
//			  //   C_RecStr = C_RecStr   +  "0000000000"  ; 
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdTsum"),"0"));       /*(56) column 세액감면_감면세액계 : TAXD_TSUM */     
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//			  
//			  
//			  // ------------------------ 세액공제 -------------------------------------------------------
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdWken"),"0"));      /*(57) column 세액공제_근로소득세액공제 : TAXD_WKEN */ 
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrMrct"),"0"));               //다자녀추가공제인원 -----
//			  C_RecStr = C_RecStr   + String.format("%02d", mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrMccr"),"0"));         //자녀세액공제
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  
//			  
//			  //     mTempData02 = oraQrySelect02.FieldByName('ADDR_MCAM').AsFloat;                 //다자녀추가공제금액 ------
//			  //      C_RecStr = C_RecStr  + FormatFloat('00000000', mTempData02);
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrClct"),"0"));             //6세이하공제인원  -----
//			  C_RecStr = C_RecStr   + String.format("%02d",  mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrChld"),"0"));              //6세이하공제금액 -------
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrBhct"),"0"));              //출산입양자공제인원 --------
//			  C_RecStr = C_RecStr   + String.format("%02d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrBrth"),"0"));            // 출산입양자공제금액 ---------
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//			  
//			  
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrCtar"),"0"));                  //연금계좌_과학기술인공제_공제대상금액
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrHict"),"0"));                  //연금계좌_과학기술인공제_세액공제액
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrPtar"),"0"));               //연금계좌_근로자퇴직 급여보장법에 따른 퇴직급여 공제대상금액
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrPsrn"),"0"));                //연금계좌_근로자퇴직 급여보장법에 따른 퇴직급여 공제액
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrAtar"),"0"));               //연금계좌_ 연금저축 공제대상금액
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrHnsv"),"0"));              //연금계좌_연금저축 세액공제액
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  
//			  //mTempData02 = oraQrySelect02.FieldByName('SPCI_DETG').AsFloat ;                 //특별세액공제_보장성보험료_공제대상금액
//			  //C_RecStr = C_RecStr   + FormatFloat('0000000000',mTempData02) ;
//			  //mTempData02 = oraQrySelect02.FieldByName('SPCI_RTDE').AsFloat ;                 //특별세액공제_보장성보험효 세액공제액
//			  //C_RecStr = C_RecStr   + FormatFloat('0000000000',mTempData02) ;
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciRttg"),"0"));                //특별세액공제_보장성보험료_공제대상금액
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciGurt"),"0"));               // //특별공제_일반보장성보험료 세액공제액
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciHdtg"),"0"));              //특별공제_장애인보장성대상금액
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciHdrc"),"0"));                  //특특별공제_장애인보장성보험료 세액공제액
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciDtar"),"0"));                 //특별세액공제_의료비_공제대상금액
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciTxcr"),"0"));               //특별세액공제_의료비_세액공제액
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spedEtar"),"0"));                 //특별세액공제_교육비_공제대상금액SPED_SFTR
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spedTxcr"),"0"));                 //특별세액공제_교육비_세액공제
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxd10tg"),"0"));                //특별세액공제_기부금_정치자금_10만원이하 공제 대상금액
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdPltc"),"0"));                  //특별세액공제_기부금_정치자금_10만원이하 공제
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciPltg"),"0"));                   //특별세액공제_기부금_정치자금_10만원초과  공제 대상금액
//			  C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciPltc"),"0"));                 //특별세액공제_기부금_정치자금_10만원초과  공제
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciFbtg"),"0"));                 //특별세액공제_기부금_법정기부금 공제 대상금액
//			  C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciFbam"),"0"));                 //특별세액공제_기부금_법정기부금 공제
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciHftg"),"0"));   /* (65)-다column 우리사주종합기부대상금액 : SPCI_HFTG */
//			  C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spcirfam"),"0"));    /*(65)-다 column 특별공제_기부금_우리사주조합세액공제액 : SPCI_RFAM */
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciNatg"),"0"));                /*(65)-라 column  2014년이후 기부금합게 종교단체외지정대상금액 : SPCI_NATG */
//			  C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciNamt"),"0"));                 /*(65)-라 column 특별공제_기부금_특별공제_기부금_종교단체외 : SPCI_NAMT */
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciYatg"),"0"));                 /*(65)-라 column  2014년이후 기부금합게 종교단체지정대상금액 : SPCI_YATG */
//			  C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ; 
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciYamt"),"0"));                /*(65)-라 column 특별공제_기부금_특별공제_기부금_종교단체 : SPCI_YAMT */
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  
//			  
//			  
//			  //     mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciNyag"),"0"));                 //특별세액공제_기부금_지정기부금 공제대상금액
//			  //    C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
//			  //     mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciNyam"),"0"));                 //특별세액공제_기부금 지정기부금 세액
//			  //    C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  
//			  
//			  // SPCI_NATG	종교단체외지정대상금액	 
//			  // SPCI_YATG	종교단체지정대상금액	 
//			  
//			  
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciDcto"),"0"));                 //특별세액공제 계
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciDdct"),"0"));              //표준 세액 공제
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  
//			  
//			  
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdUnin"),"0"));               //납세조합공제
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdLoan"),"0"));              //주택차입금
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//			  //   mTempData02 = oraQrySelect02.FieldByName('TAXD_PLTC').AsFloat ;                  //기부정치자금
//			  //  C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
//			  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdPaid"),"0"));               //외국납부
//			  C_RecStr = C_RecStr  + String.format("%010d",  mTempData02) ;
//			  
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciTgrt"),"0"));     /*(71) column 특별공제_월세세액공제대상금액 : SPCI_TGRT */ 
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;        
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciRtam"),"0"));            //    월세 세액 공제
//			  C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdCsum"),"0"));               //세액공제계
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//			  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dcsnIncm"),"0"));               //소득세
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dcsnInhb"),"0"));                //지방소득세
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dcsnFafv"),"0"));                  //농특세
//			  C_RecStr = C_RecStr    + String.format("%010d", mTempData02);
//			  //   mTempData02 = oraQrySelect02.FieldByName('DCSN_TOTL').AsFloat;                  //합계
//			  //   C_RecStr = C_RecStr    + FormatFloat('0000000000', mTempData02) ;
//			  
//			  //기납부세액 - 주현근무지  
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("alryPinx"),"0"));       //기납부소득세
//			  C_RecStr = C_RecStr    + String.format("%010d",  mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("alryPhbx"),"0"));                  //기납부지방소득세
//			  C_RecStr = C_RecStr    + String.format("%010d", mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("alryYvtx"),"0"));               //기납부농특세
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//			  
//			  
//			  //계산에 의해처리 해야 함......todo 
//			  C_RecStr = C_RecStr   +  "0000000000"  ;          //납부특례세액 _소득세
//			  C_RecStr = C_RecStr   +  "0000000000"  ;            //납부특례세액 _지방소득세
//			  C_RecStr = C_RecStr   +  "0000000000"  ;           //납부특례세액 _농특세 
//			  
//			  
//			  //   mTempData02 = oraQrySelect02.FieldByName('ALRY_TOTL').AsFloat ;
//			  //   C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtEtaxb"),"0"));           //소득세음양
//			  C_RecStr = C_RecStr   + String.format("%01d",  mTempData02)  ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtEtax"),"0"));        //소득세
//			  C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtInhbb"),"0"));          //지방소득세음양
//			  C_RecStr = C_RecStr  + String.format("%01d", mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtInhb"),"0"));          //지방소득세
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtFafvb"),"0"));           //농특세음양
//			  C_RecStr = C_RecStr   + String.format("%01d", mTempData02);
//			  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtFafv"),"0"));              //농특세
//			  C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//			  //   mTempData02 = oraQrySelect02.FieldByName('SUBT_AMSUB').AsFloat ;
//			  //    C_RecStr = C_RecStr   + FormatFloat('0', mTempData02);
//			  //   mTempData02 = oraQrySelect02.FieldByName('SUBT_AMSU').AsFloat;
//			  //    C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
//			  C_RecStr = C_RecStr   + String.format("%-15s", "") ;
//			  
//			  
//			  TOT_Record.add(C_RecStr);
//			  
//			  D_Cnt = 1; 
//			  
//			  //fnPayrD_ReTax_Total_Select
//			  ye161010VO.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
//			  
//			  List listYetaD = yeta3400PayrService.fnPayrD_ReTax_Total_Select(ye161010VO);
//			  
//			  
//			  
//			  if (listYetaD.size() > 0) { 
//				  
//				  Iterator<Map<String, Object>> iter01 = listYetaD.iterator(); 
//				  
//				  while ( iter01.hasNext() ) { 
//					  
//					  Map<String, Object> mapYetaD = (Map<String, Object>) iter01.next(); 
//					  
//					  mTempData02 = 0L;
//					  D_RecStr = "";
//					  D_RecStr = "D" + "20" + ye161010VO.getTaxaCode();
//					  D_RecStr = D_RecStr +   String.format("%06d", C_Cnt);  
//					  D_RecStr = D_RecStr +  String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-",""));
//					  D_RecStr = D_RecStr + String.format("%50s", "")  + String.format("%-13s", StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),""),"-",""));
//					  
//					  //근무처별 소득 명세 - 종전근무처 
//					  D_RecStr = D_RecStr + "2" ;  //todo 납세조합구분자 필요 
//					  D_RecStr = D_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaD.get("siteCtnt"),"") ,38),40," ") ;
//					  D_RecStr = D_RecStr + String.format("%-10s", MSFSharedUtils.defaultNulls(mapYetaD.get("siteNumb"),""))  ;
//					  D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("jeymStdt"),"0"))); 
//					  D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("jeymEddt"),"0"))); 
//					  D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("jutrStdt"),"0"))); 
//					  D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("jutrEddt"),"0"))); 
//					  
//					  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("payrTotl"),"0"));  
//					  D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
//					  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("bonsAmnt"),"0")); 
//					  D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
//					  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("dtmnBtam"),"0")); 
//					  D_RecStr = D_RecStr +  String.format("%011d", mTempData02);
//					  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("stckPrft"),"0")); 
//					  D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
//					  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("unonAmnt"),"0")); 
//					  D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
//					  
//					  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("ofrrExli"),"0")); 
//					  D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
//					  
//					  D_RecStr = D_RecStr + "0000000000000000000000" ;
//					  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("payrBtot"),"0")); 
//					  D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
//					  
//					  //종전근무지 비과세소득 및 감면소득  
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSg01"),"0"));  
//					  C_RecStr = C_RecStr   + String.format("%010d", mTempData02);
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh01"),"0"));  
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh05"),"0"));  
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh06"),"0"));  
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh07"),"0"));  
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh08"),"0"));  
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh09"),"0"));  
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh10"),"0"));  
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh14"),"0"));  
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh15"),"0"));  
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh11"),"0"));  
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh12"),"0"));  
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh13"),"0"));  
//					  C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;
//					  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh16"),"0"));  
//					  C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSi01"),"0"));  
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//					  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSk01"),"0"));  
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm01"),"0")); 
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm02"),"0"));  
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm03"),"0"));  
//					  C_RecStr = C_RecStr  +  String.format("%010d",  mTempData02) ;
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSo01"),"0")); 
//					  C_RecStr = C_RecStr   +  String.format("%010d", mTempData02)  ;
//					  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSq01"),"0")); 
//					  C_RecStr = C_RecStr  +  String.format("%010d", mTempData02) ;
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSr10"),"0")); 
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSs01"),"0"));  
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt01"),"0")); 
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//					  mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy02"),"0")); 
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy03"),"0"));  
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//					  
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy04"),"0"));  
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//					  
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy21"),"0")); 
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy22"),"0")); 
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt10"),"0")); 
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//					  
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt11"),"0")); 
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt12"),"0")); 
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//					  
//					  
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt20"),"0")); 
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp51"),"0"));    //비과세계
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//					  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp52"),"0"));   //감면소득계
//					  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//					  
//					  
//					  // mTempData02 = oLong.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("JUTR_EDDT"),"0"));raQrySelect03.FieldByName('TAXE_TOTL').AsFloat ;
//					  //   D_RecStr = D_RecStr +  FormatFloat('0000000000', mTempData02);
//					  //  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("JUTR_EDDT"),"0"));oraQrySelect03.FieldByName('PAYR_TEMP55').AsFloat ;
//					  D_RecStr = D_RecStr + "0000000000";
//					  
//					  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("EARN_TAXN"),"0")); 
//					  D_RecStr = D_RecStr +  String.format("%010d", mTempData02);
//					  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("IHTX_TAXN"),"0")); 
//					  D_RecStr = D_RecStr +  String.format("%010d", mTempData02);
//					  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("FARM_TAXN"),"0")); 
//					  D_RecStr = D_RecStr +  String.format("%010d", mTempData02);
//					  // mTempData02 =  oraQrySelect03.FieldByName('FARM_BTOT').AsFloat ;
//					  //  D_RecStr = D_RecStr  +  FormatFloat('0000000000',mTempData02);
//					  D_RecStr = D_RecStr +  String.format("%02d",  D_Cnt);
//					  D_RecStr = D_RecStr + String.format("%961s", ""); 
//					  
//					  
//					  TOT_Record.add(D_RecStr);
//					  
//					  
//					  D_Cnt = D_Cnt + 1;
//				  }
//			  }
//			  
//			  //E레코드
//			  E_Cnt = 1;
//			  E_RowCnt = 1;
//			  E_RecStr = "";
//			  
//			  ye161010VO.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
//			  
//			  List listYetaE = yeta3400PayrService.fnPayrE_ReTax_Total_Select(ye161010VO);
//			  
//			  
//			  
//			  if ( listYetaE.size() > 0) { 
//				  
//				  Iterator<Map<String, Object>> iter03 = listYetaE.iterator(); 
//				  
//				  while ( iter03.hasNext() ) { 
//					  
//					  Map<String, Object> mapYetaE = (Map<String, Object>) iter03.next(); 
//					  
//					  
//					  mTempData02 = 0L;
//					  
//					  // 주민번호(복호화)
//					  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//					  
//					  
//					  E_RecStr =  "E" + "20" + ye161010VO.getTaxaCode() +  String.format("%06d", C_Cnt)
//							  +  String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-",""))
//							  + String.format("%-13s", StringUtils.replace(rrnDecCrypt,"-",""));
//					  
//					  if (listYetaE.size() + 1 > E_RowCnt)  {
//						  
//						  // E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  
//						  
//						  /** (CASE WHEN YETA3220.RELH_CODE IN ('A0190001')  THEN 0       
//				           WHEN YETA3220.RELH_CODE IN ('A0190003','A0190004','A0190009','A0190010','A0190017','A0190018','A0190019','A0190053','A0190054','A0190055','A0190056','A0190051','A0190050','A0190078','A0190079')  THEN 1  
//				           WHEN YETA3220.RELH_CODE IN ('A0190011','A0190012','A0190013')  THEN 2                                                                                         
//				           WHEN YETA3220.RELH_CODE IN ('A0190002','A0190007')  THEN 3                                                                                                                          
//				           WHEN YETA3220.RELH_CODE IN ('A0190005')  THEN 4   
//				           WHEN YETA3220.RELH_CODE IN ('A0190040','A0190032','A0190099','A0190076' ,'A0190100')  THEN 5                                                                                                                         
//				           WHEN YETA3220.RELH_CODE IN ('A0190038','A0190022','A0190021','A0190020','A0190023','A0190025','A0190033','A0190035','A0190037','A0190051','A0190052','A0190089','A0190053','A0190090','A0190091','A0190032')  THEN 6            
//				           WHEN YETA3220.RELH_CODE IN ('A0190109')  THEN 7                            
//				           WHEN YETA3220.RELH_CODE IN ('A0190100')  THEN 8  END )  AS RELH_CODE,  */
//						  
//						  E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드 
//						  E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," "); 
//						  E_RecStr = E_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")   ;
//						  
//						  // 주민번호(복호화)
//						  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//						  
//						  E_RecStr = E_RecStr+ rrnDecCrypt;  
//						  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  
//						  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  
//						  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  
//						  
//						  //소득공제국세청자료 
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
//						  E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;
//						  
//						  //소득공제자료 기타자료 
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
//						  E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
//						  E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//						  
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
//						  E_RecStr = E_RecStr+   String.format("%013d",mTempData02);
//						  
//						  E_RowCnt =  E_RowCnt + 1;
//						  try {
//							  mapYetaE = (Map<String, Object>) iter03.next(); 
//						  } catch (NoSuchElementException e) {
//							  //e.printStackTrace();
//						  }   
//						  
//					  }
//					  else
//					  {
//						  E_RecStr = E_RecStr + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%20s","")
//								  + String.format("%13s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000000";
//						  
//						  E_RowCnt =  E_RowCnt + 1;
//					  }
//					  
//					  if (listYetaE.size() + 1 > E_RowCnt)  {
//						  
//						  //   E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," "); 
//						  E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드 
//						  E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," ");   
//						  E_RecStr = E_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")  ;
//						  
//						  // 주민번호(복호화)
//						  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//						  
//						  
//						  E_RecStr = E_RecStr+ rrnDecCrypt;  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  
//						  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  
//						  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  
//						  
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
//						  E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
//						  E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
//						  E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//						  
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
//						  E_RecStr = E_RecStr+   String.format("%013d",mTempData02);
//						  E_RowCnt =  E_RowCnt + 1;
//						  try {
//							  mapYetaE = (Map<String, Object>) iter03.next(); 
//						  } catch (NoSuchElementException e) {
//							  //e.printStackTrace();
//						  }     
//						  
//						  
//					  }
//					  else
//					  {
//						  E_RecStr = E_RecStr + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%20s","")
//								  + String.format("%13s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000000";
//						  
//						  E_RowCnt =  E_RowCnt + 1;
//					  }
//					  
//					  if (listYetaE.size() + 1 > E_RowCnt)  {
//						  
//						  //E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  
//						  E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드   
//						  E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," ");   
//						  E_RecStr = E_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")  ;
//						  
//						  // 주민번호(복호화)
//						  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//						  
//						  
//						  E_RecStr = E_RecStr+ rrnDecCrypt;  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  
//						  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  
//						  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  
//						  
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
//						  E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
//						  E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
//						  E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//						  
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
//						  E_RecStr = E_RecStr+   String.format("%013d",mTempData02);
//						  E_RowCnt =  E_RowCnt + 1;
//						  try {
//							  mapYetaE = (Map<String, Object>) iter03.next(); 
//						  } catch (NoSuchElementException e) {
//							  //e.printStackTrace();
//						  }     
//						  
//						  
//					  }
//					  else
//					  {
//						  E_RecStr = E_RecStr + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%20s","")
//								  + String.format("%13s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000000";
//						  
//						  E_RowCnt =  E_RowCnt + 1;
//					  }
//					  if (listYetaE.size() + 1 > E_RowCnt)  {
//						  
//						  // E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  
//						  E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드  
//						  E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," ");   
//						  E_RecStr = E_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")   ;
//						  
//						  // 주민번호(복호화)
//						  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//						  
//						  E_RecStr = E_RecStr+ rrnDecCrypt;  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  
//						  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  
//						  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  
//						  
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
//						  E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
//						  E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
//						  E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//						  
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
//						  E_RecStr = E_RecStr+   String.format("%013d",mTempData02);
//						  E_RowCnt =  E_RowCnt + 1;
//						  try {
//							  mapYetaE = (Map<String, Object>) iter03.next(); 
//						  } catch (NoSuchElementException e) {
//							  //e.printStackTrace();
//						  }     
//						  
//						  
//					  }
//					  else
//					  {
//						  E_RecStr = E_RecStr + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%20s","")
//								  + String.format("%13s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000000";
//						  
//						  E_RowCnt =  E_RowCnt + 1;
//					  }
//					  
//					  if (listYetaE.size() + 1 > E_RowCnt)  {
//						  
//						  //  E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  
//						  E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드 
//						  E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," ");   
//						  E_RecStr = E_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")  ;
//						  
//						  // 주민번호(복호화)
//						  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//						  
//						  
//						  E_RecStr = E_RecStr+ rrnDecCrypt;  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  
//						  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  
//						  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
//						  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  
//						  
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//						  
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
//						  E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
//						  E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
//						  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
//						  E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//						  
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
//						  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//						  
//						  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
//						  E_RecStr = E_RecStr+   String.format("%013d",mTempData02);
//						  
////                                 try {
////                               	  mapYetaE = (Map<String, Object>) iter03.next(); 
////                             	 } catch (NoSuchElementException e) {
////                             		//e.printStackTrace();
////                             	 }      
//						  E_RowCnt =  E_RowCnt + 1;
//						  
//					  }
//					  else
//					  {
//						  E_RecStr = E_RecStr + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%20s","")
//								  + String.format("%13s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + String.format("%1s","")
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000"
//								  + "0000000000000";
//						  
//						  E_RowCnt =  E_RowCnt + 1;
//					  }
//					  E_RecStr = E_RecStr +  String.format("%02d",  E_Cnt)
//							  + String.format("%293s", "") ;
//					  
//					  TOT_Record.add(E_RecStr);
//					  
//					  E_Cnt = E_Cnt + 1;
//					  E_RecStr = ""; 
//					  
//				  }
//			  }
//			  
//			  // F레코드  - 연금저축등 소득세액공제명세 레코드 
//			  
//			  F_Cnt = 1;
//			  F_RowCnt = 1;
//			  F_RecStr = "";
//			  
//			  ye161010VO.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
//			  
//			  List listYetaF = yeta3400PayrService.fnPayrF_ReTax_Total_Select(ye161010VO);
//			  
//			  
//			  if ( listYetaF.size() > 0) { 
//				  
//				  Iterator<Map<String, Object>> iter04 = listYetaF.iterator(); 
//				  
//				  while ( iter04.hasNext() ) { 
//					  
//					  Map<String, Object> mapYetaF = (Map<String, Object>) iter04.next(); 
//					  
//					  mTempData02 = 0L;
//					  
//					  // 주민번호(복호화)
//					  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//					  
//					  F_RecStr =  "F" + "20" + ye161010VO.getTaxaCode() +  String.format("%06d", C_Cnt) + String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-",""))
//							  + String.format("%-13s",rrnDecCrypt ) ;
//					  
//					  
//					  if (listYetaF.size() + 1 > F_RowCnt)  {
//						  
//						  F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//								  + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//						  
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//						  
//						  try {
//							  mapYetaF = (Map<String, Object>) iter04.next(); 
//						  } catch (NoSuchElementException e) {
//							  //e.printStackTrace();
//						  }      
//						  
//					  }
//					  else
//					  {
//						  F_RecStr = F_RecStr + String.format("%-2s","")
//								  + String.format("%-3s","")
//								  +  String.format("%-50s","")
//								  + String.format("%-20s","")
//								  +  "0000000000"
//								  +  "0000000000";
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//					  }
//					  
//					  if (listYetaF.size() + 1 > F_RowCnt)  {
//						  
//						  F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//								  + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//						  
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//						  try {
//							  mapYetaF = (Map<String, Object>) iter04.next(); 
//						  } catch (NoSuchElementException e) {
//							  //e.printStackTrace();
//						  }     
//					  }
//					  else
//					  {
//						  F_RecStr = F_RecStr + String.format("%-2s","")
//								  + String.format("%-3s","")
//								  +  String.format("%-50s","")
//								  + String.format("%-20s","")
//								  +  "0000000000"
//								  +  "0000000000";
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//					  }
//					  
//					  if (listYetaF.size() + 1 > F_RowCnt)  {
//						  
//						  F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//								  + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//						  
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//						  try {
//							  mapYetaF = (Map<String, Object>) iter04.next(); 
//						  } catch (NoSuchElementException e) {
//							  //e.printStackTrace();
//						  }     
//					  }
//					  else
//					  {
//						  F_RecStr = F_RecStr + String.format("%-2s","")
//								  + String.format("%-3s","")
//								  +  String.format("%-50s","")
//								  + String.format("%-20s","")
//								  +  "0000000000"
//								  +  "0000000000";
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//					  }
//					  
//					  if (listYetaF.size() + 1 > F_RowCnt)  {
//						  
//						  F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//								  + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//						  
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//						  try {
//							  mapYetaF = (Map<String, Object>) iter04.next(); 
//						  } catch (NoSuchElementException e) {
//							  //e.printStackTrace();
//						  }     
//					  }
//					  else
//					  {
//						  F_RecStr = F_RecStr + String.format("%-2s","")
//								  + String.format("%-3s","")
//								  +  String.format("%-50s","")
//								  + String.format("%-20s","")
//								  +  "0000000000"
//								  +  "0000000000";
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//					  }
//					  
//					  if (listYetaF.size() + 1 > F_RowCnt)  {
//						  
//						  F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//								  + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//						  
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//						  try {
//							  mapYetaF = (Map<String, Object>) iter04.next(); 
//						  } catch (NoSuchElementException e) {
//							  //e.printStackTrace();
//						  }     
//					  }
//					  else
//					  {
//						  F_RecStr = F_RecStr + String.format("%-2s","")
//								  + String.format("%-3s","")
//								  +  String.format("%-50s","")
//								  + String.format("%-20s","")
//								  +  "0000000000"
//								  +  "0000000000";
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//					  }
//					  
//					  if (listYetaF.size() + 1 > F_RowCnt)  {
//						  
//						  F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//								  + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//						  
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//						  try {
//							  mapYetaF = (Map<String, Object>) iter04.next(); 
//						  } catch (NoSuchElementException e) {
//							  //e.printStackTrace();
//						  }     
//					  }
//					  else
//					  {
//						  F_RecStr = F_RecStr + String.format("%-2s","")
//								  + String.format("%-3s","")
//								  +  String.format("%-50s","")
//								  + String.format("%-20s","")
//								  +  "0000000000"
//								  +  "0000000000";
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//					  }
//					  
//					  if (listYetaF.size() + 1 > F_RowCnt)  {
//						  
//						  F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//								  + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//						  
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//						  try {
//							  mapYetaF = (Map<String, Object>) iter04.next(); 
//						  } catch (NoSuchElementException e) {
//							  //e.printStackTrace();
//						  }     
//					  }
//					  else
//					  {
//						  F_RecStr = F_RecStr + String.format("%-2s","")
//								  + String.format("%-3s","")
//								  +  String.format("%-50s","")
//								  + String.format("%-20s","")
//								  +  "0000000000"
//								  +  "0000000000";
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//					  }
//					  
//					  if (listYetaF.size() + 1 > F_RowCnt)  {
//						  
//						  F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//								  + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//						  
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//						  try {
//							  mapYetaF = (Map<String, Object>) iter04.next(); 
//						  } catch (NoSuchElementException e) {
//							  //e.printStackTrace();
//						  }     
//					  }
//					  else
//					  {
//						  F_RecStr = F_RecStr + String.format("%-2s","")
//								  + String.format("%-3s","")
//								  +  String.format("%-50s","")
//								  + String.format("%-20s","")
//								  +  "0000000000"
//								  +  "0000000000";
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//					  }
//					  
//					  if (listYetaF.size() + 1 > F_RowCnt)  {
//						  
//						  F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//								  + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//						  
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//						  try {
//							  mapYetaF = (Map<String, Object>) iter04.next(); 
//						  } catch (NoSuchElementException e) {
//							  //e.printStackTrace();
//						  }     
//					  }
//					  else
//					  {
//						  F_RecStr = F_RecStr + String.format("%-2s","")
//								  + String.format("%-3s","")
//								  +  String.format("%-50s","")
//								  + String.format("%-20s","")
//								  +  "0000000000"
//								  +  "0000000000";
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//					  }
//					  
//					  if (listYetaF.size() + 1 > F_RowCnt)  {
//						  
//						  F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//								  + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//						  
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//						  try {
//							  mapYetaF = (Map<String, Object>) iter04.next(); 
//						  } catch (NoSuchElementException e) {
//							  //e.printStackTrace();
//						  }     
//					  }
//					  else
//					  {
//						  F_RecStr = F_RecStr + String.format("%-2s","")
//								  + String.format("%-3s","")
//								  +  String.format("%-50s","")
//								  + String.format("%-20s","")
//								  +  "0000000000"
//								  +  "0000000000";
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//					  }
//					  
//					  if (listYetaF.size() + 1 > F_RowCnt)  {
//						  
//						  F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//								  + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//						  
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//						  try {
//							  mapYetaF = (Map<String, Object>) iter04.next(); 
//						  } catch (NoSuchElementException e) {
//							  //e.printStackTrace();
//						  }     
//					  }
//					  else
//					  {
//						  F_RecStr = F_RecStr + String.format("%-2s","")
//								  + String.format("%-3s","")
//								  +  String.format("%-50s","")
//								  + String.format("%-20s","")
//								  +  "0000000000"
//								  +  "0000000000";
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//					  }
//					  
//					  if (listYetaF.size() + 1 > F_RowCnt)  {
//						  
//						  F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//								  + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//						  
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//						  try {
//							  mapYetaF = (Map<String, Object>) iter04.next(); 
//						  } catch (NoSuchElementException e) {
//							  //e.printStackTrace();
//						  }     
//					  }
//					  else
//					  {
//						  F_RecStr = F_RecStr + String.format("%-2s","")
//								  + String.format("%-3s","")
//								  +  String.format("%-50s","")
//								  + String.format("%-20s","")
//								  +  "0000000000"
//								  +  "0000000000";
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//					  }
//					  
//					  if (listYetaF.size() + 1 > F_RowCnt)  {
//						  
//						  F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//								  + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//						  
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//						  try {
//							  mapYetaF = (Map<String, Object>) iter04.next(); 
//						  } catch (NoSuchElementException e) {
//							  //e.printStackTrace();
//						  }     
//					  }
//					  else
//					  {
//						  F_RecStr = F_RecStr + String.format("%-2s","")
//								  + String.format("%-3s","")
//								  +  String.format("%-50s","")
//								  + String.format("%-20s","")
//								  +  "0000000000"
//								  +  "0000000000";
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//					  }
//					  
//					  if (listYetaF.size() + 1 > F_RowCnt)  {
//						  
//						  F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//								  + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//						  
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//						  try {
//							  mapYetaF = (Map<String, Object>) iter04.next(); 
//						  } catch (NoSuchElementException e) {
//							  //e.printStackTrace();
//						  }     
//					  }
//					  else
//					  {
//						  F_RecStr = F_RecStr + String.format("%-2s","")
//								  + String.format("%-3s","")
//								  +  String.format("%-50s","")
//								  + String.format("%-20s","")
//								  +  "0000000000"
//								  +  "0000000000";
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//					  }
//					  
//					  if (listYetaF.size() + 1 > F_RowCnt)  {
//						  
//						  F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//								  + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//								  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//						  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//						  F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//						  
//						  
//						  F_RowCnt =  F_RowCnt + 1;
////               try {
////             	  mapYetaF = (Map<String, Object>) iter04.next(); 
////              	 } catch (NoSuchElementException e) {
////              		//e.printStackTrace();
////              	 }     
//					  }
//					  else
//					  {
//						  F_RecStr = F_RecStr + String.format("%-2s","")
//								  + String.format("%-3s","")
//								  +  String.format("%-50s","")
//								  + String.format("%-20s","")
//								  +  "0000000000"
//								  +  "0000000000";
//						  
//						  F_RowCnt =  F_RowCnt + 1;
//					  }
//					  
//					  
//					  F_RecStr = F_RecStr + String.format("%-160s","");
//					  TOT_Record.add(F_RecStr);
//					  
//					  
//					  F_Cnt = F_Cnt + 1;
//					  
//					  F_RecStr = "";  
//					  
//				  }
//			  }
//			  
//			  
//			  //---------------------------------------------------------------------------------
//			  //G레코드 - 월세 거주간 주택임차 차입금 원리금 상환액 소득공제명세 레코드  
//			  //---------------------------------------------------------------------------------
//			  
//			  G_Cnt = 1;
//			  G_RowCnt = 1;
//			  G_RecStr = "";
//			  
//			  ye161010VO.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
//			  
//			  List listYetaG = yeta3400PayrService.fnPayrG_ReTax_Total_Select(ye161010VO);
//			  
//			  
//			  if ( listYetaG.size() > 0) { 
//				  
//				  Iterator<Map<String, Object>> iter05 = listYetaG.iterator(); 
//				  
//				  while ( iter05.hasNext() ) { 
//					  
//					  Map<String, Object> mapYetaG = (Map<String, Object>) iter05.next(); 
//					  
//					  
//					  if ((listYetaG.size() > 0) &&  (MSFSharedUtils.paramNotNull( mapYetaG.get("mnrnName")) 
//							  ||  MSFSharedUtils.paramNotNull( mapYetaG.get("cnclName")) || MSFSharedUtils.paramNotNull( mapYetaG.get("leasName"))))  {
//						  
//						  // 주민번호(복호화)
//						  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//						  
//						  mTempData02 = 0L;
//						  
//						  G_RecStr =  "G" + "20" + ye161010VO.getTaxaCode()  +  String.format("%06d", C_Cnt) +  String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-",""))
//								  + String.format("%-13s",rrnDecCrypt) ;
//						  
//						  
//						  if (listYetaG.size() + 1 > G_RowCnt)  {
//							  
//							  // 주민번호(복호화)
//							  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyBurRgsum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//							  
//							  G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnName"),""),18),20," ")  
//									  +  String.format("%-13s", rrnDecCrypt);
//							  
//							  G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnTyhu"),"") );
//							  G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnArea"),"0.00")))),".","");     //소숫점처리
//							  
//							  G_RecStr = G_RecStr +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAddr"),"") ,98),100," ")  ;
//							  
//							  G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnStdt"),"") ;
//							  G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnEddt"),"") ;
//							  
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAmnt"),"0"));  
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnDuam"),"0"));   
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
//							  
//							  
//							  G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclName"),"") ,18),20," ") 
//									  + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRsno"),"") ) ;
//							  G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclStdt"),"") ;
//							  G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclEddt"),"")  ;
//							  
//							  G_RecStr = G_RecStr +  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItro"),"0.00")))),".","") ;     //소숫점처리
//							  
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRdmt"),"0")); 
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclPrpl"),"0"));
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItrt"),"0"));
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclDuam"),"0"));
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//							  
//							  
//							  G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("leasName"),"") ,18),20," ")  
//									  + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("leasRsno"),"")  );
//							  
//							  G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("leasTyhu"),"")   );
//							  G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("leasArea"),"0.00")))),".","")  ;     //소숫점처리
//							  
//							  G_RecStr = G_RecStr +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("leasAddr"),"") ,98),100," ") ;
//							  G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasStdt"),"") ;
//							  G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasEddt"),"")  ;
//							  
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("leasDpst"),"0"));   
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//							  
//							  G_RowCnt =  G_RowCnt + 1;
//							  try {
//								  mapYetaG = (Map<String, Object>) iter05.next(); 
//							  } catch (NoSuchElementException e) {
//								  //e.printStackTrace();
//							  }     
//							  
//						  }
//						  else
//						  {
//							  G_RecStr = G_RecStr + String.format("%-20s","")
//									  + String.format("%-13s","")
//									  + String.format("%-1s","")
//									  +  "00000"
//									  + String.format("%-100s","")
//									  +  "00000000"
//									  +  "00000000"
//									  +  "0000000000"
//									  +  "0000000000"
//									  + String.format("%-20s","")
//									  + String.format("%-13s","")
//									  +  "00000000"
//									  +  "00000000"
//									  +  "0000"
//									  +  "0000000000"
//									  +  "0000000000"
//									  +  "0000000000"
//									  +  "0000000000"
//									  + String.format("%-20s","")
//									  +  String.format("%-13s","")
//									  +  String.format("%-1s","")
//									  +  "00000"
//									  +  String.format("%-100s","")
//									  +  "00000000"
//									  +  "00000000"
//									  +  "0000000000";
//							  
//							  G_RowCnt =  G_RowCnt + 1;
//						  }
//						  if (listYetaG.size() + 1 > G_RowCnt)  {
//							  
//							  
//							  // 주민번호(복호화)
//							  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyBurRgsum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//							  
//							  
//							  G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnName"),"") ,18),20," ")   
//									  +  String.format("%-13s",  rrnDecCrypt);
//							  
//							  G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnTyhu"),"") );
//							  G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnArea"),"0.00")))),".","");     //소숫점처리
//							  
//							  G_RecStr = G_RecStr +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAddr"),"") ,98),100," ") ;
//							  
//							  G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnStdt"),"") ;
//							  G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnEddt"),"") ;
//							  
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAmnt"),"0"));  
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnDuam"),"0"));   
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
//							  
//							  
//							  G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("cnclName"),"") ,18),20," ")   
//									  + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRsno"),"") ) ;
//							  G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclStdt"),"") ;
//							  G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclEddt"),"")  ;
//							  
//							  G_RecStr = G_RecStr +  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItro"),"0.00")))),".","") ;     //소숫점처리
//							  
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRdmt"),"0")); 
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclPrpl"),"0"));
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItrt"),"0"));
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclDuam"),"0"));
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//							  
//							  
//							  G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("leasName"),"") ,18),20," ")  
//									  + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("leasRsno"),"")  );
//							  
//							  G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("leasTyhu"),"")   );
//							  G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("leasArea"),"0.00")))),".","")  ;     //소숫점처리
//							  
//							  G_RecStr = G_RecStr +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("leasAddr"),"") ,98),100," ") ;
//							  G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasStdt"),"") ;
//							  G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasEddt"),"")  ;
//							  
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("leasDpst"),"0"));   
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//							  
//							  G_RowCnt =  G_RowCnt + 1;
//							  try {
//								  mapYetaG = (Map<String, Object>) iter05.next(); 
//							  } catch (NoSuchElementException e) {
//								  //e.printStackTrace();
//							  }     
//						  }
//						  else
//						  {
//							  G_RecStr = G_RecStr + String.format("%-20s","")
//									  + String.format("%-13s","")
//									  + String.format("%-1s","")
//									  +  "00000"
//									  + String.format("%-100s","")
//									  +  "00000000"
//									  +  "00000000"
//									  +  "0000000000"
//									  +  "0000000000"
//									  + String.format("%-20s","")
//									  + String.format("%-13s","")
//									  +  "00000000"
//									  +  "00000000"
//									  +  "0000"
//									  +  "0000000000"
//									  +  "0000000000"
//									  +  "0000000000"
//									  +  "0000000000"
//									  + String.format("%-20s","")
//									  +  String.format("%-13s","")
//									  +  String.format("%-1s","")
//									  +  "00000"
//									  +  String.format("%-100s","")
//									  +  "00000000"
//									  +  "00000000"
//									  +  "0000000000";
//							  
//							  G_RowCnt =  G_RowCnt + 1;
//						  }
//						  if (listYetaG.size() + 1 > G_RowCnt)  {
//							  
//							  
//							  // 주민번호(복호화)
//							  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyBurRgsum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//							  
//							  
//							  G_RecStr = G_RecStr +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnName"),"") ,18),20," ")  
//									  +  String.format("%-13s",  rrnDecCrypt);
//							  
//							  G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnTyhu"),"") );
//							  G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnArea"),"0.00")))),".","");     //소숫점처리
//							  
//							  G_RecStr = G_RecStr +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAddr"),"") ,98),100," ") ;
//							  
//							  G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnStdt"),"") ;
//							  G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnEddt"),"") ;
//							  
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAmnt"),"0"));  
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnDuam"),"0"));   
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
//							  
//							  
//							  G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclName"),"") ,18),20," ")  
//									  + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRsno"),"") ) ;
//							  G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclStdt"),"") ;
//							  G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclEddt"),"")  ;
//							  
//							  G_RecStr = G_RecStr +  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItro"),"0.00")))),".","") ;     //소숫점처리
//							  
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRdmt"),"0")); 
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclPrpl"),"0"));
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItrt"),"0"));
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclDuam"),"0"));
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//							  
//							  
//							  G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("leasName"),""),18),20," ")  
//									  + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("leasRsno"),"")  );
//							  
//							  G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("leasTyhu"),"")   );
//							  G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("leasArea"),"0.00")))),".","")  ;     //소숫점처리
//							  
//							  G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("leasAddr"),""),98),100," ")  ;
//							  G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasStdt"),"") ;
//							  G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasEddt"),"")  ;
//							  
//							  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("leasDpst"),"0"));   
//							  G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//							  
//							  G_RowCnt =  G_RowCnt + 1;
////                     try {
////                   	  mapYetaG = (Map<String, Object>) iter05.next(); 
////                    	 } catch (NoSuchElementException e) {
////                    		//e.printStackTrace();
////                    	 }     
//						  }
//						  else
//						  {
//							  G_RecStr = G_RecStr + String.format("%-20s","")
//									  + String.format("%-13s","")
//									  + String.format("%-1s","")
//									  +  "00000"
//									  + String.format("%-100s","")
//									  +  "00000000"
//									  +  "00000000"
//									  +  "0000000000"
//									  +  "0000000000"
//									  + String.format("%-20s","")
//									  + String.format("%-13s","")
//									  +  "00000000"
//									  +  "00000000"
//									  +  "0000"
//									  +  "0000000000"
//									  +  "0000000000"
//									  +  "0000000000"
//									  +  "0000000000"
//									  + String.format("%-20s","")
//									  +  String.format("%-13s","")
//									  +  String.format("%-1s","")
//									  +  "00000"
//									  +  String.format("%-100s","")
//									  +  "00000000"
//									  +  "00000000"
//									  +  "0000000000";
//							  
//							  G_RowCnt =  G_RowCnt + 1;
//						  }          
//						  
//						  G_RecStr = G_RecStr +  String.format("%02d", G_Cnt)
//								  + String.format("%-284s","");
//						  
//						  TOT_Record.add(G_RecStr); 
//						  
//						  G_Cnt = G_Cnt + 1;
//						  
//						  G_RecStr = "";
//						  
//						  
//					  }
//				  }
//			  }
//			  
//			  C_Cnt = C_Cnt + 1;  
//			  
//		  } 
//		  
//		  File dir = new File("C:/EOSDATA/2016/");
//		  //디렉토리가 없으면 생성
//		  if(!dir.isDirectory()){
//			  dir.mkdirs();
//		  }
//		  
////        TOT_Record.SaveToFile('C:\EOSDATA\' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3) + '.denc');
//		  String fileDir = "C:/EOSDATA/2016/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc";
//		  FileWriter fw = new FileWriter(fileDir ); // 절대주소 경로 가능
//		  BufferedWriter bw = new BufferedWriter(fw);
//		  
//		  
//		  for (int iCnt=0;iCnt < TOT_Record.size();iCnt++) {
//			  String strWr = "";
//			  
//			  strWr = TOT_Record.get(iCnt);
//			  bw.write(strWr);  //\n + "\r"
//			  if ((TOT_Record.size() - 1) != iCnt) {
//				  bw.newLine(); // 줄바꿈
//			  }
//		  }
//		  
//		  bw.close();
//		  
//		  
//		  File objFile = new File("C:/EOSDATA/2016/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc");
//		  
//		  // 파일 다운로드
//		  response.setContentType("application/x-msdownload");
//		  
//		  String strFileName = URLEncoder.encode(new String(objFile.getName().getBytes("8859_1"), "euc-kr"), "euc-kr");
//		  response.setHeader("Content-Disposition", "attachment;filename=" + strFileName + ";");
//		  
//		  int nRead = 0;
//		  byte btReadByte[] = new byte[(int)objFile.length()];
//		  
//		  if(objFile.length() > 0 && objFile.isFile())
//		  {
//			  BufferedInputStream objBIS = new BufferedInputStream(new FileInputStream(objFile));
//			  BufferedOutputStream objBOS = new BufferedOutputStream(response.getOutputStream());
//			  
//			  while((nRead = objBIS.read(btReadByte)) != -1)
//				  objBOS.write(btReadByte, 0, nRead);
//			  
//			  objBOS.flush();
//			  objBOS.close();
//			  objBIS.close();
//		  }
//		  
////          // set parameters.
////        hWnd = Application.MainForm.Handle;
////
////        pszInputFilePath  = PChar('C:/EOSDATA/' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3) + '.denc');
////        pszOutputFilePath = PChar('C:/EOSDATA/' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3));
////        pszPassword = PChar(edFILE_PASS.Text);
////        option = 1;          // DSFC_OPT_OVERWRITE_OUTPUT
////
////        mStream=TMemoryStream.Create;
////        mStream.LoadFromFile(pszInputFilePath);
////
////        ret = DSFC_EncryptData(hWnd, mStream.Memory, mStream.Size, pszOutputFilePath, pszPassword, option);
////      //  resultString = 'result code : '  + IntToStr(ret);
////        if Assigned(mStream) then FreeAndNil(mStream);
////       // Application.MessageBox(PChar(resultString), '확인', MB_OK);
//		  
//	  } catch (Exception ex) {
//		  ex.printStackTrace();
//		  state = -1;  
////	   	   ShowMessageBM smBm = new ShowMessageBM();
////	   	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
////	   	   smBm.setMenu("Yeta");
////	   	   smBm.setPhase("[연말정산대상자]대상자생성에러");
////	   	   smBm.setMessage(ex.getLocalizedMessage());
////	   	   smBm.setContent(ex.getMessage());
////	   	   bmResult.add(smBm);  
////	   	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
//		  
//	  }
	  
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
      * @param ye161010VO
      */
  public int fnYeta3400_Tax_Ye164010_File_Create(HttpServletRequest request,InfcPkgYe161010_2018_VO  ye161010VO,HttpServletResponse response) throws Exception  {
    	
    	int state = 0;
    	
    	String DEFIN = "CA"; 
    	String A_RecStr;
    	ArrayList<String> A_Record = new ArrayList<String>();    	
    	ArrayList<String> TOT_Record = new ArrayList<String>();
    	int A_Cnt;
    	Long mTempData01;    	

	 
    	 /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
	    // 1. 암호화 객체 생성
	     String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
	     /********************************************************암호화 처리 를 위해 반드시 해야 함 ................................*/   
    	
    	try {
    		
    		 if  (yeta3400PayrService== null) {
    			    WebApplicationContext wac = WebApplicationContextUtils.
    			    		getRequiredWebApplicationContext( request.getSession().getServletContext());
    			  
    			    yeta3400PayrService = (Yeta3400PayrService) wac.getBean("Yeta3400PayrService");
    			}
    		  
    		
    		 InfcPkgYe161005_2018_VO    infcPkgYe161005Vo	 = new InfcPkgYe161005_2018_VO();	//A_원천세신고기본
    		 BeanUtils.copyProperties(infcPkgYe161005Vo, ye161010VO);
    		    
    		 infcPkgYe161005Vo  = yeta3400PayrService.selectYe161005(ye161010VO);

        	   String defBUNS_LINS = StringUtils.replace(MSFSharedUtils.allowNulls(infcPkgYe161005Vo.getBusoprRgstnum()),"-","") ; //사업자번호  
        	   
    		    
    	    InfcPkgYe161020_2018_VO    infcPkgYe161020Vo	 = new InfcPkgYe161020_2018_VO();	//A_인적소득공제기본
    	    BeanUtils.copyProperties(infcPkgYe161020Vo, ye161010VO);
    	     
    		// A레코드 - 의료비지급명세서 레코드
    		List listYetaCA = yeta3400PayrService.fnPayrPSNL_ReTax_CA_Total_Select(infcPkgYe161020Vo);

    		if  (listYetaCA.size() > 0) { 
 
    		 	A_Cnt = 1;
    		
    			  Iterator<Map<String, Object>> iter = listYetaCA.iterator(); 
    	      	   
    	          while ( iter.hasNext() ) { 
    	          
    	            Map<String, Object> mapCAData = (Map<String, Object>) iter.next();  
    		  //	for (int i = 0 ; i < listYeta1.size() ; i++) { 
    	            
    	            infcPkgYe161020Vo.setSystemkey(MSFSharedUtils.allowNulls(mapCAData.get("systemkey"))); 
    	            
    	            //A레코드 - 의료비지급명세서 레코드  내역 
    	            List listCAYeta = yeta3400PayrService.fnPayrCA_ReTax_Total_Select(infcPkgYe161020Vo);
    				
    	            Iterator<Map<String, Object>> iter01 = listCAYeta.iterator(); 
     	      	   
      	            while ( iter01.hasNext() ) { 
      	            	
      	            Map<String, Object> mapCAYeta = (Map<String, Object>) iter01.next(); 
      	            
    				//for (int j = 0 ; j < listYeta2.size() ; j++) {
    				//	infcPkgYeta3140Vo = (InfcPkgYeta3140VO)listYeta2.get(j);
    					
	    				A_RecStr = "";
						A_RecStr = "A" + "26" + infcPkgYe161005Vo.getTxOffcCd(); // 3 세무서 코드 
						A_RecStr = A_RecStr + String.format("%06d", A_Cnt); // 4 순번
						A_RecStr = A_RecStr + StringUtils.replace(MSFSharedUtils.allowNulls(ye161010VO.getEdacPrdt()) ,"-","") ; // 5 제출년월일 
						A_RecStr = A_RecStr + defBUNS_LINS; // 6 사업자 등록번호
						A_RecStr = A_RecStr + String.format("%-20s", infcPkgYe161005Vo.getHmtxId()); // 7 홈텍스 ID
						A_RecStr = A_RecStr + String.format("%-4s", infcPkgYe161005Vo.getTxPgmCd()); // 8 세무프로그램 코드 
						A_RecStr = A_RecStr + defBUNS_LINS; // 9 사업자 등록번호
						A_RecStr = A_RecStr + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(infcPkgYe161005Vo.getCorpFmnmNm() ,38),40," ") ; // 10 상호

						/* 
						10번까지는 화면에서 받아온 vo (ye161010VO) 이용
						이후는 select 결과 vo (infcPkgYeta3140Vo) 이용*/

						// 주민번호(복호화)
						 String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapCAData.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						    		          	
						
						A_RecStr = A_RecStr +    String.format("%-13s",rrnDecCrypt );     // 11 소득자 주민번호 
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAData.get("orgNnfClCd"),"1")); // 12 내,외국인 코드
						A_RecStr = A_RecStr + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapCAData.get("fnm"),""),28),30 ," "); // 13 성명
						
						A_RecStr = A_RecStr + String.format("%-10s", StringUtils.replace(MSFSharedUtils.defaultNulls(mapCAYeta.get("bsnoEncCntn"),""),"-",""));  // 14 지급처 사업자등록번호
						A_RecStr = A_RecStr + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapCAYeta.get("plymNm"),"") ,38),40," "); // 15 지급처 상호
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.allowNulls(mapCAYeta.get("mdxpsPrfClCd")));// 16 의료증빙 코드
								
						mTempData01 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapCAYeta.get("scnt"),"0"));  
						A_RecStr = A_RecStr + String.format("%05d", mTempData01); //건수
						//A_RecStr = A_RecStr + String.format("%05d", infcPkgYeta3140Vo.getMediCfcd()); // 17 건수
						
						mTempData01 = Long.parseLong(MSFSharedUtils.defaultNulls(mapCAYeta.get("useAmt"),"0"));   
						A_RecStr = A_RecStr + String.format("%011d", mTempData01); //금액
						//A_RecStr = A_RecStr + String.format("%011d", infcPkgYeta3140Vo.getCashUeam()); // 18 금액
						
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAYeta.get("yn2"),""));   // 19 난임시술비 해당 여부
						
						// 주민번호(복호화)
						 rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapCAYeta.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						   
						A_RecStr = A_RecStr + String.format("%-13s",rrnDecCrypt ); // 20 주민번호 번호						
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAYeta.get("nnfClCd"),"1")); // 21 내,외국인 코드
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAYeta.get("yn"),"2")); // 22 본인 등 해당여부
						A_RecStr = A_RecStr + "1"; // todo 내용 처리 23 제출대상기간 코드
						A_RecStr = A_RecStr + String.format("%19s", "");  ; // 24 공란
						
					 					
						TOT_Record.add(A_RecStr);
						
//					     String source = MSFSharedUtils.defaultNulls(mapCAYeta.get("vendName"),"");
//						
//						CharBuffer cbuffer = CharBuffer.wrap((new String(source.getBytes("EUC-KR"), "ksc5601")).toCharArray());
//						Charset utf8charset = Charset.forName("UTF-8");
//						ByteBuffer bbuffer = utf8charset.encode(cbuffer);
//					 
//					    System.out.println("vvvv[" + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(bbuffer.toString() ,38),40," ") + "]");
//						
//						CharBuffer cbuffer1 = CharBuffer.wrap((new String(source.getBytes(), "EUC-KR")).toCharArray());
//						Charset utf8charset1 = Charset.forName("ksc5601");
//						ByteBuffer bbuffer1 = utf8charset1.encode(cbuffer1);
//					 
//					    System.out.println("aaaaa[" + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(bbuffer1.toString() ,38),40," ") + "]");
//						
//					    String hex_utf8 =  encode(source, "UTF-8");
//					    System.out.println(hex_utf8);        
//					    System.out.println( decode(hex_utf8, "UTF-8").getBytes().length);
//					             
//					    String hex_euckr =  encode(source, "EUC-KR");
//					    System.out.println(hex_euckr);
//					    System.out.println( decode(hex_euckr, "EUC-KR").getBytes().length);
//					    System.out.println("ccccc[" + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(decode(hex_euckr, "EUC-KR") ,38),40," ") + "]");
//					    System.out.println( changeCharset(source, "UTF-8"));
//					    System.out.println("aaaaa[" + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(changeCharset(source, "UTF-8") ,38),40," ") + "]");
//						        
//					    System.out.println( changeCharset(source, "EUC-KR"));
//					    System.out.println("vvvvc[" + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(changeCharset(source, "EUC-KR") ,38),40," ") + "]");
						
					    
						A_Cnt = A_Cnt + 1;
	    				}
    			}
    		}
    		else {
    			throw new Exception("의료비 A레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.");  
    			//showMessage('의료비 A레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.');
    		}
    		
    		 File dir = new File("C:/EOSDATA/2018/");
	          //디렉토리가 없으면 생성
	          if(!dir.isDirectory()){
	           dir.mkdirs();
	          }
	          
    		//TOT_Record.SaveToFile('C:\EOSDATA\' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3) + '.denc');
    		      String fileDir = "C:/EOSDATA/2018/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc";
    	          //FileWriter fw = new FileWriter(fileDir); // 절대주소 경로 가능
    		      OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(fileDir),"EUC-KR");
    	          BufferedWriter bw = new BufferedWriter(osw);
    		     

    	          for (int iCnt=0;iCnt < TOT_Record.size();iCnt++) {
    	        	 String strWr = "";
    	        	 
    	        	 strWr = TOT_Record.get(iCnt);
    	        	 bw.write(strWr);  // + "\r\n"
    	        	 if ((TOT_Record.size() - 1) != iCnt) {
    	              bw.newLine(); // 줄바꿈
    	        	 }
    	          }
    	          
    	          bw.close();
    	          
    	          File objFile = new File("C:/EOSDATA/2018/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc");
    	          
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
  * @param ye161010VO
  * @param response
  * @return
  * @throws Exception
  */
  public int fnYeta3400_Tax_Ye165010_File_Create(HttpServletRequest request,InfcPkgYe161010_2018_VO  ye161010VO,HttpServletResponse response) throws Exception { 
  
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
 	  
// 	 /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
//	    // 1. 암호화 객체 생성
//	     String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//			
//	     /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/   
//
//	     
//
// 	        DEFIN = "H"; //기부금 
//
// 	        defBUNS_LINS = StringUtils.replace(ye161010VO.getBusiNumb(),"-",""); //StringReplace(edBUNS_LINS.Text,'-','',[rfReplaceALL]);   //사업자번호
// 	        strTempDataA = "";
// 	        strTempDataB = "";
// 	        strTempDataC = "";
// 	        strTempDataD = "";
// 	        mTempDataA = 0L;
// 	        mTempDataB = 0L;
// 	        mTempDataC = 0L;
// 	        mTempDataD = 0L;
//
// 	        A_Record = "";
//
// 	        strTempDataA = "A" + "27";
//
// 	        strTempDataA = strTempDataA + ye161010VO.getTaxaCode();   //edTAXO_FFIE.Text ;   //세무서코드 
// 	                       mTempDataA    =  Long.parseLong(StringUtils.replace(ye161010VO.getEdacPrdt(),"-",""));//StrToInt(StringReplace(edINCO_OUDT.Text,'-','',[rfReplaceALL]));  //제출년월일 
// 	        strTempDataA = strTempDataA  +  String.format("%08d", mTempDataA);  //FormatFloat('00000000', mTempDataA) ;   //제출년월일
// 	                       mTempDataA    =  Long.parseLong( ye161010VO.getIncmGbcd() );   //StrToInt(edEXPT_GBUN.Text);
// 	        strTempDataA = strTempDataA  +  String.format("%01d", mTempDataA);  //FormatFloat('0', mTempDataA);   //제출자구분
//
// 	        strTempDataA = strTempDataA  + String.format("%-6s", MSFSharedUtils.defaultNulls(ye161010VO.getTaxaDnum(),""));   //Format('%-6s', [edTXOF_NUMB.Text]) ; //세무대리인번호(7)
// 	        strTempDataA = strTempDataA  + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(ye161010VO.getHomeTxid(),18),20," "); // String.format("%-20s", ye161010VO.getHomeTxid()); //Format('%-20s', [edHOME_TXID.Text]) ;  //홈텍스아이디 
// 	        strTempDataA = strTempDataA  + String.format("%-4s", ye161010VO.getTaxaPrcd()) ;//Format('%-4s', [edTAXP_CODE.Text])  ; //세무프로그램코드
// 	        strTempDataA = strTempDataA  + String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-","")) ; //Format('%-10s', [StringReplace(edBUNS_LINS.Text,'-','',[rfReplaceALL])]) ; //사업자등록번호
// 	        strTempDataA = strTempDataA  +  PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(ye161010VO.getJuriName(),38),40," "); //String.format("%-40s", ye161010VO.getJuriName()); //  Format('%-40s', [edPROF_RSNM.Text])   ; //법인명
// 	        strTempDataA = strTempDataA  + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(ye161010VO.getCharDept(),28),30," "); //String.format("%-30s", ye161010VO.getCharDept());  //Format('%-30s', [edSELF_DEPT.Text]) ;  //담당자부서
// 	        strTempDataA = strTempDataA  + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(ye161010VO.getCharName(),28),30," "); 
// 	        	//	String.format("%-30s", ye161010VO.getCharName());  //Format('%-30s', [edSELF_NAME.Text])   ; //담당자성명
// 	        strTempDataA = strTempDataA  + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(ye161010VO.getCharTele(),15),15," ")  ;  //Format('%-15s', [edSELF_TELE.Text]) ;   //담당자전화번호
// 	        mTempDataA = 1L;
// 	        strTempDataA = strTempDataA  + String.format("%05d", mTempDataA);  //FormatFloat('00000',mTempDataA);  //신고자수
// 	        strTempDataA = strTempDataA  + "101" ;   //사용한글코드
// 	        strTempDataA = strTempDataA  + String.format("%12s", "");  //Format('%2s', ['']);  //공란
// 
// 	        TOT_Record.add(strTempDataA);
//
// 	        B_Cnt = 1;
// 	       
// 	    try {
// 	       
// 	    	//B레코드 - 원천징수의무자별 집계레코드 
// 	       Map mapHb = yeta3400PayrService.fnPayrHB_ReTax_Total_Select(ye161010VO);
// 	        
//// 	      if oraQrySelect01.Eof = True then
//// 	      begin
//// 	         showMessage('B레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.');
//// 	          Result = -1;
//// 	         Exit;
//// 	      end;
// 	       if (!"2".equals(MSFSharedUtils.defaultNulls(ye161010VO.getIncmGbcd(),""))) {
// 	     //  if (MSFSharedUtils.paramNull(StringUtils.replace(ye161010VO.getJuriNumb(),"-","")) || StringUtils.replace(ye161010VO.getJuriNumb(),"-","").equals("null")) {
//              
//              RSNOSTR = StringUtils.replace(ye161010VO.getResuNumb(),"-","");    //사업자주민번호 
//           }
//           else
//           {
//              RSNOSTR =  StringUtils.replace(ye161010VO.getJuriNumb(),"-","");   //법인번호
//           }
//    	  
//            
// 	      
// 	        mTempDataB = 0L;
// 	        strTempDataB = "";
//
// 	         strTempDataB   = "B" + "27";   //레코드 구분 /자료구분 
// 	         strTempDataB   =  strTempDataB + ye161010VO.getTaxaCode();    //세무서코드 
// 	         strTempDataB   = strTempDataB  + String.format("%06d", B_Cnt);   //일련번호 
//	         strTempDataB  = strTempDataB +  String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-",""));  //사업자등록번호 10
//	         strTempDataB  = strTempDataB +  PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(ye161010VO.getJuriName(),38),40," ")  ;
//	        		 //String.format("%-40s", ye161010VO.getJuriName()); //Format('%-40s', [edPROF_RSNM.Text]);   //상호(40)
//	         mTempDataB   =  Long.parseLong( MSFSharedUtils.defaultNulls(mapHb.get("ctrbCnt"),"0"));  
//	         strTempDataB = strTempDataB + String.format("%07d", mTempDataB);     //기부금조정명세레코드수(9[7])
//	          mTempDataB =    Long.parseLong( MSFSharedUtils.defaultNulls(mapHb.get("yeta3180Cnt"),"0"));     
//	         strTempDataB = strTempDataB +  String.format("%07d", mTempDataB);   //해당연도 기부명세레코드
//	         mTempDataB =   Long.parseLong( MSFSharedUtils.defaultNulls(mapHb.get("ctrbAmnt"),"0"));   
//	         strTempDataB = strTempDataB + String.format("%013d", mTempDataB);    //기부금액 총계
//	          mTempDataB =  Long.parseLong( MSFSharedUtils.defaultNulls(mapHb.get("detrAmnt"),"0"));   
//	         strTempDataB = strTempDataB + String.format("%013d", mTempDataB);     //공제대상금액 총계
//	         strTempDataB = strTempDataB + "1" ;   //todo 제출대상기간코드
//	         strTempDataB = strTempDataB + String.format("%87s", "");     //공란
//
// 	          
// 	         TOT_Record.add(strTempDataB);
//
// 	          C_Cnt =  0;
// 	        
// 	          
// 	         //C 레코드 - 기부금 조정명세 레코드  
// 	         List listTotData01 = yeta3400PayrService.fnPayrPSNL_ReTax_Total_Select(ye161010VO);
// 	          
//
// 	          if (listTotData01.size() <= 0) { 
// 	        	 throw new Exception("기부금명세서 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.");  
//// 	             showMessage('기부금명세서 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.');
//// 	             Result = -1;
//// 	             Exit;
// 	          } 
// 	          
// 	          Iterator<Map<String, Object>> iter = listTotData01.iterator(); 
//      	   
//	          while ( iter.hasNext() ) { 
//	            	
//	            Map<String, Object> mapTotData01 = (Map<String, Object>) iter.next();  
//	          
//	            ye161010VO.setSystemkey(MSFSharedUtils.allowNulls(mapTotData01.get("systemkey")));
// 	              //SYSTEMKEY 가지고 데이타 가져오기 
//	            //C 레코드 - 기부금 조정명세 레코드  YETA3170
//	            List listHCData = yeta3400PayrService.fnPayrHC_ReTax_Total_Select(ye161010VO);  
//	             
//// 	               { if oraQrySelect02.Eof = True then
//// 	                begin
//// 	                   showMessage('C레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.');
//// 	                   Result = -1;
//// 	                   Exit;
//// 	                end; }
//
// 	               C_rowCnt = 1;
// 	             
// 	              if (listHCData.size() > 0) { 
// 	                  C_Cnt = C_Cnt + 1;
// 	              }
// 	               
// 	              Iterator<Map<String, Object>> iter01 = listHCData.iterator(); 
// 	        	   
// 		          while ( iter01.hasNext() ) { 
// 		            	
// 		            Map<String, Object> mapHCData = (Map<String, Object>) iter01.next(); 
// 		            
//
//
// 		               // 주민번호(복호화)
// 		               String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapTotData01.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
// 		            		          	 
// 	                    strTempDataC = "";
// 	                    mTempDataC  = 0L;
//
// 	                    strTempDataC =  "C" + "27" ;
// 	                    strTempDataC = strTempDataC + ye161010VO.getTaxaCode(); //세무서코드 
//                        mTempDataC = Long.parseLong(String.valueOf(C_Cnt));
//                        strTempDataC = strTempDataC +   String.format("%06d", mTempDataC);    //소득자일련번호 
//                        strTempDataC = strTempDataC  +  String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-","")); //사업자등록번호
//                        strTempDataC = strTempDataC  +  String.format("%-13s", rrnDecCrypt);     //소득자주민등록번호
//                        mTempDataC =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("frnrYeno"),"1"));   //oraQrySelect01.FieldByName('FRNR_YENO').AsFloat;    
//                        strTempDataC = strTempDataC  +  String.format("%01d", mTempDataC);     //내외국인구분코드 
//                        strTempDataC = strTempDataC  +   PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapTotData01.get("kornName"),""),28),30," "); 
//                        		//String.format("%-30s",  MSFSharedUtils.defaultNulls(mapHCData.get("kornName"),""));  //성명
//                        strTempDataC = strTempDataC  +  String.format("%-2s",  MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""));    //유형코드
//                        mTempDataC =  Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbYrmn"),"0"));   
//                        strTempDataC = strTempDataC  +   String.format("%04d", mTempDataC);    //기부연도
//                        mTempDataC =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbAmnt"),"0"));   
//                        strTempDataC = strTempDataC  +  String.format("%013d", mTempDataC);   //기부금액 - 13
//                        mTempDataC =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("bfyrDeam"),"0"));   
//                        strTempDataC = strTempDataC  +  String.format("%013d", mTempDataC);  //전년까지공제된금액 -13
//                        mTempDataC =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("detrAmnt"),"0"));   
//                        strTempDataC = strTempDataC  + String.format("%013d", mTempDataC);  //공제대상금액  -13
//                        
//                        strTempDataC = strTempDataC  + "0000000000000" ;   //해당년도공제금액 필요경비 
//                        
//                        mTempDataC =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("dyyrDeam"),"0"));  
//                        strTempDataC = strTempDataC  + String.format("%013d", mTempDataC);//해당년도공제금액세액금액 -13                        
//                        mTempDataC =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("dyyrOtam"),"0"));   
//                        strTempDataC = strTempDataC  + String.format("%013d", mTempDataC); //해당년도공제받지못한금액소멸금액 -13
//                        mTempDataC =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("ayyrNtam"),"0"));   
//                        strTempDataC = strTempDataC  + String.format("%013d", mTempDataC); //해당년도에 공제받지못한금액_이월금액 -3
//                        strTempDataC = strTempDataC  + String.format("%05d", C_rowCnt);       //기부금조정명세일련번호 -5
//                        strTempDataC = strTempDataC  + String.format("%22s", "");      //공란 -25
// 
// 	                   TOT_Record.add(strTempDataC);
// 	                   C_rowCnt = C_rowCnt + 1;
// 
// 		          }
//
// 	               D_Cnt = 1;
// 	             
// 	              //D레코드 - 해당연도 기부명세 레코드  
// 	              List listHDData = yeta3400PayrService.fnPayrHD_ReTax_Total_Select(ye161010VO); 
// 	               
// 	             if (listHCData.size() > 0) { 
//	              
//	              Iterator<Map<String, Object>> iter02 = listHDData.iterator(); 
//	        	   
//		          while ( iter02.hasNext() ) { 
//		            	
//		            Map<String, Object> mapHDData = (Map<String, Object>) iter02.next();
// 
// 	                     strTempDataD = "";
// 	                     mTempDataD  = 0L;
//
// 	                    // 주민번호(복호화)
// 	 		               String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapTotData01.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
// 	 		            		   
// 	                      strTempDataD =  "D" + "27";
// 	                      strTempDataD = strTempDataD + ye161010VO.getTaxaCode();  //세무서코드 
//                          strTempDataD = strTempDataD + String.format("%06d", C_Cnt);     //소득자일련번호 
//                          strTempDataD = strTempDataD + String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-",""));   //사업자등록번호 
//                          
//                          strTempDataD = strTempDataD +  String.format("%-13s", rrnDecCrypt);      //소득자주민등록번호
//                          strTempDataD = strTempDataD +  String.format("%-2s",  MSFSharedUtils.defaultNulls(mapHDData.get("ctrbTycd"),""));     //유형코드
//                          
//                          strTempDataD = strTempDataD +  String.format("%-13s", StringUtils.replace(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbBsnu"),""),"-",""));    //사업자등록번호
// 
//                          strTempDataD = strTempDataD + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbName"),""),28),30," ");
//                          //String.format("%-30s", StringUtils.left(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbName"),""),30));    //상호 - 30
//                                           
//                          strTempDataD = strTempDataD +  String.format("%-1s",  MSFSharedUtils.defaultNulls(mapHDData.get("crtbCncd"),""));  //관계코드
//                          strTempDataD = strTempDataD +  String.format("%-1s",  MSFSharedUtils.defaultNulls(mapHDData.get("frnrCode"),""));     //내외국인구분코드
//                          strTempDataD = strTempDataD +  PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapHDData.get("cbtgName"),""),18),20," "); 
//                          //String.format("%-20s", MSFSharedUtils.defaultNulls(mapHDData.get("cbtgName"),""));   //성명 - 20
//                          // 주민번호(복호화)
//	 		                 rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapHDData.get("rsnoNumb"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//	 		            		   
//                          strTempDataD = strTempDataD +  String.format("%-13s", rrnDecCrypt);    //기부자주민등록번호 
//                          mTempDataD =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbNcnt"),"1"));   
//                          strTempDataD = strTempDataD +  String.format("%05d", mTempDataD);   //건수 - 5
//                       
//                          mTempDataD = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbAmnt"),"0"));   
//                          strTempDataD = strTempDataD +  String.format("%013d", mTempDataD);     //기부금액 - 13
//
//                          //2016년 추가 -----
//                          mTempDataD = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbTgam"),"0"));   
//                          strTempDataD = strTempDataD +  String.format("%013d", mTempDataD);     //공제대상기부금액
//                          mTempDataD = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ctjaCham"),"0"));   
//                          strTempDataD = strTempDataD +  String.format("%013d", mTempDataD);     //기부장려신청금액
// 
//                          
//                          strTempDataD = strTempDataD + String.format("%05d", D_Cnt);    //일련번호 
//                          
//                          strTempDataD = strTempDataD +  String.format("%26s", "");    //공란 42
// 
// 	                      TOT_Record.add(strTempDataD);
// 
// 	                    D_Cnt = D_Cnt + 1;
//		           }
// 	             } 
//
//	         }
//
//
//
//        //  파일저장 암호화 루틴 
//// 	      TOT_Record.SaveToFile('C:\EOSDATA\' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3) + '.denc');
//	     
//	          File dir = new File("C:/EOSDATA/2016/");
//	          //디렉토리가 없으면 생성
//	          if(!dir.isDirectory()){
//	           dir.mkdirs();
//	          }
//	         
//	          String fileDir = "C:/EOSDATA/2016/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc";
//	          FileWriter fw = new FileWriter(fileDir); // 절대주소 경로 가능
//	          BufferedWriter bw = new BufferedWriter(fw);
//	          
//
//	          for (int iCnt=0;iCnt < TOT_Record.size();iCnt++) {
//	        	 String strWr = "";
//	        	 
//	        	 strWr = TOT_Record.get(iCnt);
//	             bw.write(strWr); //\n + "\r"
//	             if ((TOT_Record.size() - 1) != iCnt) {
//   	              bw.newLine(); // 줄바꿈
//   	        	 }
//	          }
//	          
//	          bw.close();
//	          
//	          File objFile = new File("C:/EOSDATA/2016/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc");
//	          
//	          // 파일 다운로드
//	          response.setContentType("application/x-msdownload");
//	          
//	          String strFileName = URLEncoder.encode(new String(objFile.getName().getBytes("8859_1"), "euc-kr"), "euc-kr");
//	          response.setHeader("Content-Disposition", "attachment;filename=" + strFileName + ";");
//	          
//	          int nRead = 0;
//	          byte btReadByte[] = new byte[(int)objFile.length()];
//
//	          if(objFile.length() > 0 && objFile.isFile())
//	          {
//	              BufferedInputStream objBIS = new BufferedInputStream(new FileInputStream(objFile));
//	              BufferedOutputStream objBOS = new BufferedOutputStream(response.getOutputStream());
//
//	              while((nRead = objBIS.read(btReadByte)) != -1)
//	                  objBOS.write(btReadByte, 0, nRead);
//	          
//	              objBOS.flush();
//	              objBOS.close();
//	              objBIS.close();
//	          }
//	          
////	          FileOutputStream fos = null;
////	          InputStream is = null;
////	          try {
////	              fos = new FileOutputStream("C:/EOSDATA/2015/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc");
////	   
////	              URL url = new URL("http://192.168.0.9:8080/");
////	              URLConnection urlConnection = url.openConnection();
////	              is = urlConnection.getInputStream();
////	              byte[] buffer = new byte[1024];
////	              int readBytes;
////	              while ((readBytes = is.read(buffer)) != -1) {
////	                  fos.write(buffer, 0, readBytes);
////	              }
////	          } catch (FileNotFoundException e) {
////	              e.printStackTrace();
////	          } catch (MalformedURLException e) {
////	              e.printStackTrace();
////	          } catch (IOException e) {
////	              e.printStackTrace();
////	          } finally {
////	              try {
////	                  if (fos != null) {
////	                      fos.close();
////	                  }
////	                  if (is != null) {
////	                      is.close();
////	                  }
////	              } catch (IOException e) {
////	                  e.printStackTrace();
////	              }
////	          }
//	          
//// 	        // set parameters.
//// 	      hWnd = Application.MainForm.Handle;
////
//// 	      pszInputFilePath  = PChar('C:/EOSDATA/' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3) + '.denc');
//// 	      pszOutputFilePath = PChar('C:/EOSDATA/' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3));
//// 	      pszPassword = PChar(edFILE_PASS.Text);
//// 	      option = 1;          // DSFC_OPT_OVERWRITE_OUTPUT
////
//// 	      mStream=TMemoryStream.Create;
//// 	      mStream.LoadFromFile(pszInputFilePath);
////
//// 	      ret = DSFC_EncryptData(hWnd, mStream.Memory, mStream.Size, pszOutputFilePath, pszPassword, option);
//// 	    //  resultString = 'result code : '  + IntToStr(ret);
//// 	      if Assigned(mStream) then FreeAndNil(mStream);
//// 	     // Application.MessageBox(PChar(resultString), '확인', MB_OK);
//
//
//	   } catch (Exception ex) {
//		   ex.printStackTrace();
//		   state = -1;  
////	   	   ShowMessageBM smBm = new ShowMessageBM();
////	   	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
////	   	   smBm.setMenu("Yeta");
////	   	   smBm.setPhase("[연말정산대상자]대상자생성에러");
////	   	   smBm.setMessage(ex.getLocalizedMessage());
////	   	   smBm.setContent(ex.getMessage());
////	   	   bmResult.add(smBm);  
////	   	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
// 	 
//      } 
 	     

 	     return state; 
    } 
 
  
 

  public List<YetaMessageVO> fnYeta3400_Tax_Ye161010_File_Check(HttpServletRequest request,InfcPkgYe161010_2018_VO  ye161010VO,HttpServletResponse response) throws Exception  {
	  
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
  
//  //{근로소득지급명세서}
//	   /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
//	    // 1. 암호화 객체 생성
//	     String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//			
//	     /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/   
//
//        DEFIN = "C"; //근로소득
//        defBUNS_LINS = StringUtils.replace(ye161010VO.getBusiNumb(),"-","");   //사업자번호
//      
//        InfcPkgye161010VO infcPkgye161010VO = new InfcPkgye161010VO();
//
//         A_Record = ("A" + "20" + ye161010VO.getTaxaCode() + String.format("%08d", Long.parseLong(StringUtils.replace(ye161010VO.getEdacPrdt(),"-","")))
//                       + String.format("%01d", Long.parseLong( ye161010VO.getIncmGbcd() ))   + String.format("%-6s", MSFSharedUtils.defaultNulls(ye161010VO.getTaxaDnum(),"")) 
//                       +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(ye161010VO.getHomeTxid() ,20),20," ")  
//                       +  String.format("%-4s", ye161010VO.getTaxaPrcd()) 
//                       +  String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-",""))
//                       +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(ye161010VO.getJuriName() ,38),40," ")  
//                       +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(ye161010VO.getCharDept() ,28),30," ") 
//                       +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(ye161010VO.getCharName(),28),30," ")    
//                       +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(ye161010VO.getCharTele() ,15),15," ")  
//                       +  String.format("%05d", 1) + "101"
//                       +  String.format("%1442s", ""));
//
//        TOT_Record.add(A_Record);
//
//        B_Cnt = 1;
//        mTempData01 = 0L;
//        
//      try {
//
//      
//    	  Map mapYetaB = yeta3400PayrService.fnPayrB_ReTax_Total_Select(ye161010VO); 
//
//    	  if (mapYetaB.isEmpty()) { 
////           showMessage('B레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.');
////           Result = -1;
////           Exit;
//    	  }
//    	  
//    	  if (MSFSharedUtils.paramNull(StringUtils.replace(ye161010VO.getJuriNumb(),"-","")) || StringUtils.replace(ye161010VO.getJuriNumb(),"-","").equals("null")) {
//
//    	   	//  RSNOSTR = StringUtils.replace(ye161010VO.getResuNumb(),"-","");    //사업자주민번호 
//    		// 주민번호(복호화)
//    		String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(ye161010VO.getResuNumb()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//    		          	 
//    		RSNOSTR	  = rrnDecCrypt;
//            
//           }
//           else
//           {
//              RSNOSTR =  StringUtils.replace(ye161010VO.getJuriNumb(),"-","");   //법인번호
//           }
//    	  
//          B_RecStr = "";
//          mTempData01 = 0L ;
// 
//
//              B_RecStr = "B" + "20" + ye161010VO.getTaxaCode() +  String.format("%06d", B_Cnt)   +   String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-",""))
//                           + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(ye161010VO.getJuriName() ,38),40," ")  
//                           + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(ye161010VO.getReprName() ,28),30," ")  
//                           + String.format("%-13s", StringUtils.replace(RSNOSTR,"-",""))  ; 
//                            mTempData01 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("psnlJuCnt"),"0"));
//              B_RecStr =  B_RecStr  +  String.format("%07d", mTempData01);    //주근무지 레코드 수 
//                            mTempData01 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("psnlJungCnt"),"0"));  
//              B_RecStr =  B_RecStr + String.format("%07d", mTempData01);     //종전근무지 레코드 수 
//
//              mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("totlSala"),"0")); 
//              B_RecStr =  B_RecStr + String.format("%014d", mTempData01);   //총급여 총계_현전
//              mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("dcsnIncm"),"0"));  
//              B_RecStr =  B_RecStr   +  String.format("%013d", mTempData01);    //결정세액 소득세 
//            //  mTempData01 =  oraQrySelect01.FieldByName('GONG_TEMP01').AsFloat;
//            //  B_RecStr =  B_RecStr  + FormatFloat('0000000000000', mTempData01);
//              mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("desnInhb"),"0"));    
//              B_RecStr =  B_RecStr  + String.format("%013d", mTempData01);   //결정세액 지방소득세
//              mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("dcsnFafv"),"0"));  
//              B_RecStr =  B_RecStr   + String.format("%013d", mTempData01);    //결정세액 농특세
//              mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("dcsnTotl"),"0")); 
//              B_RecStr =  B_RecStr  + String.format("%013d", mTempData01);    //결정세액 총계
//              B_RecStr =  B_RecStr  + "1"; //체출기간 연간합산제출등 코드로 등록하여 처리 하게 수정 필요 
//              B_RecStr =  B_RecStr +  String.format("%1434s", "");     //공란 
//               
//              TOT_Record.add(B_RecStr);
//
//              C_Cnt =  1;
//           
//            //c레코드 주현근무처 레코드 fnPayrC_ReTax_Total_Select
//           List listYetaC = yeta3400PayrService.fnPayrC_ReTax_Total_Select(ye161010VO);
//            
//     	  if (listYetaC.size() <= 0) {  
//     		  throw new Exception("C레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.");  
//     	  } 
//
//     	  Iterator<Map<String, Object>> iter = listYetaC.iterator(); 
//    	   
//          while ( iter.hasNext() ) { 
//           	
//           Map<String, Object> mapYetaC = (Map<String, Object>) iter.next();  
//               
//               mTempData02 = 0L;
//               C_RecStr = "";
//               //  oraQrySelect01.FieldByName('CITY_SEQN').AsString; Format('%.11d', [])
//                             C_RecStr = "C" ;   //레코드구분
//                             C_RecStr = C_RecStr + "20"; //자료구분 
//                             C_RecStr = C_RecStr   + ye161010VO.getTaxaCode(); //세무서코드 
//                             C_RecStr = C_RecStr + String.format("%06d", C_Cnt);    //원천징수읨주별로 1부터 순차부여 
//                             C_RecStr = C_RecStr  +  String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-",""));  //사업자등록번호 
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("befoScnt"),"0"));             /*  종전근무처수 */    
//                             C_RecStr = C_RecStr  + String.format("%02d",mTempData02);
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("resdFlag"),"1"));        //거주자구분코드
//                             C_RecStr = C_RecStr  + String.format("%01d", mTempData02);
//                             C_RecStr = C_RecStr  + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaC.get("redtGbcd"),"")  );    //거주지국코드
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("frnrSgyn"),"2"));                        //단일세율적용여부
//                             C_RecStr = C_RecStr  + String.format("%01d", mTempData02) ;
//                             //2016귀속 추가 ㄴ
//                             C_RecStr = C_RecStr  + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("frnrRnyn"),"2")  );    //외국법인소속 파견근로자여부 
//                             
//                             C_RecStr = C_RecStr  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaC.get("kornName"),"") ,28),30," ") ;    //성명
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("frnrYeno"),"1"));                                 //내외국인구부노드
//                             C_RecStr = C_RecStr  +  String.format("%01d",  mTempData02) ;
//                             
//                          // 주민번호(복호화)
//             				String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//             		          	 
//                             C_RecStr = C_RecStr  + String.format("%-13s",rrnDecCrypt);     //주민등록번호
//                             
//                             
//                             C_RecStr = C_RecStr  + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaC.get("natnNbcd"),"") );       //국적코드
//                             C_RecStr = C_RecStr  + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("gnanSgtf"),"") );       //세대주구분코드
//                             C_RecStr = C_RecStr   + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("hoofStcd"),"")) ;       //연말정산구분 계속근로,중도퇴사
//                             C_RecStr = C_RecStr   + String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-","")) ;            //주현근무처-사업자등록번호
//                             C_RecStr = C_RecStr   + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(ye161010VO.getJuriName() ,38),40," ") ;                                     //주현근무처-근무처명
//                         
//                            
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("reymStdt"),"0"));                                  //근무기간시작연월일
//                            C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("reymEddt"),"0"));                                 //근무기간 종료일자
//                            C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("rutrStdt"),"0"));                                  //감면기간시작일자
//                             C_RecStr = C_RecStr  +  String.format("%08d",  mTempData02) ;
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("rutrEddt"),"0"));                                    //감면기간종료일자
//                             C_RecStr = C_RecStr  +  String.format("%08d", mTempData02);
//                             mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTamt"),"0"));                                 //급여총액
//                             C_RecStr = C_RecStr  + String.format("%011d", mTempData02);
//                             mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("bonsToam"),"0"));                                   //상여총액
//                             C_RecStr = C_RecStr  + String.format("%011d",  mTempData02);
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dtmnBsam"),"0"));                               //인정상여
//                             C_RecStr = C_RecStr  + String.format("%011d",  mTempData02);
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("stckPrft"),"0"));                                //주식행사이익
//                             C_RecStr = C_RecStr  + String.format("%011d",  mTempData02) ;
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp26"),"0"));                               //우리사주조합인출금
//                            C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp27"),"0"));                                 //임원 퇴직소득금액 한도초과액
//                            C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);
//
//                             C_RecStr = C_RecStr  + "000000000000000000000";
//                            C_RecStr = C_RecStr   +  String.format("%011d", Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaC.get("currTots"),"0"))) ;                    //계
//               
//                            //주현근무처 비과세소득 및 감면소득  
//                     //       mTempData02 = oraQrySelect02.FieldByName('PAYR_TEMP29').AsFloat;
//                     //       C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSg01"),"0"));  
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh01"),"0"));  
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh05"),"0"));  
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh06"),"0"));  
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh07"),"0"));  
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh08"),"0"));  
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh09"),"0"));  
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh10"),"0"));  
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh14"),"0"));  
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh15"),"0"));  
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh11"),"0"));  
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh12"),"0"));  
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh13"),"0"));  
//                           C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;
//                           mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh16"),"0"));  
//                           C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;
//                           mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSi01"),"0"));  
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSk01"),"0"));  
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm01"),"0")); 
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm02"),"0"));  
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm03"),"0"));  
//                             C_RecStr = C_RecStr  +  String.format("%010d",  mTempData02) ;
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSo01"),"0")); 
//                            C_RecStr = C_RecStr   +  String.format("%010d", mTempData02)  ;
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSq01"),"0")); 
//                             C_RecStr = C_RecStr  +  String.format("%010d", mTempData02) ;
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSr10"),"0")); 
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSs01"),"0"));  
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt01"),"0")); 
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy02"),"0")); 
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy03"),"0"));  
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                            //2016년 귀속 추가 
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy04"),"0"));  
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                            
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy21"),"0")); 
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy22"),"0")); 
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt10"),"0")); 
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                            
//                            //2016년귀속 추가 
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt11"),"0")); 
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt12"),"0")); 
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                            
//                            
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt20"),"0")); 
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp60"),"0"));    //비과세계
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp61"),"0"));   //감면소득계
//                            C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                                
//                          //  C_RecStr = C_RecStr   + "0000000000";//공란 0으로 10자리       
//                            
//                            //정산명세 처리 시작    
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("totlSala"),"0"));         /*(16 합계)(21)번  column 총급여_현_전 : TOTL_SALA */          
//                            C_RecStr = C_RecStr   +  String.format("%011d", mTempData02);
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("wkerDdct"),"0"));    /* (22) column 근로소득공제 : WKER_DDCT */    
//                            C_RecStr = C_RecStr   +  String.format("%010d", mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("wkerAmnt"),"0"));      /*(23) column 근로소득금액 : WKER_AMNT */  
//                            C_RecStr = C_RecStr   +  String.format("%011d", mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("baseSelf"),"0"));  /*(24) column 기본공제_본인 : BASE_SELF */         
//                            C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("baseWife"),"0")); /*(25) column 기본공제_배우자 : BASE_WIFE */         
//                            C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("baseFmly"),"0"));   /*(26) column 기본공제_부양가족수 : BASE_FMLY */  
//                            C_RecStr = C_RecStr   + String.format("%02d", mTempData02) ;
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("baseFyam"),"0"));   /*(26) column 기본공제_부양가족 : BASE_FYAM */     
//                            C_RecStr = C_RecStr   + String.format("%08d",mTempData02)  ;
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrCt70"),"0"));  /*(70) column 추가공제_경로우대_70세이상수 : ADDR_CT70 경로우대공제인원 */       
//                            C_RecStr = C_RecStr   + String.format("%02d",mTempData02);
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrRpt70"),"0"));  /*(27) column 추가공제_경로우대70 : ADDR_RPT70 1946.12.31 */   
//                            C_RecStr = C_RecStr   + String.format("%08d", mTempData02) ;
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrHdrc"),"0"));  /*(28) column 추가공제_장애인수 : ADDR_HDRC */    
//                            C_RecStr = C_RecStr   + String.format("%02d",mTempData02);
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrHdam"),"0"));   /*(28) column 추가공제_장애인 금액 : ADDR_HDAM */     
//                            C_RecStr = C_RecStr   + String.format("%08d", mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrFame"),"0")); /*(29) column 추가공제_부녀자  금액 : ADDR_FAME */      
//                            C_RecStr = C_RecStr   + String.format("%08d", mTempData02);
//
//
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("pantOnam"),"0"));   /*(30) column 추가공제_한부모공제금액 : PANT_ONAM */         
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
// 
//                            //연금보험료공제 
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jbnatDdct"),"0"));    /*(31) column_국민연금보험료공제 : JNAT_DDCT */       
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jpssHpul"),"0"));    /*(32)-가 column  _공무원연금보험료공제 : JPSS_HPUL */   
//                            C_RecStr = C_RecStr  + String.format("%010d",  mTempData02);
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jpssHsol"),"0"));    /*(32)-나 column 주근무지_국민연금외군인연금공제 : JPSS_HSOL */  
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jpssHtec"),"0"));    /*(32)-다 column 주근무지_국민연금외교직원연금공제 : JPSS_HTEC */ 
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jbssDdct"),"0"));        /*(32)-라 column_별정우체국연금보험료공제 : JPSS_DDCT */   
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//                            
//                        //  mTempData02 = oraQrySelect02.FieldByName('JRTR_HICT').AsFloat ;                //퇴직연금-과학기술인공제  ---
//                        //  C_RecStr = C_RecStr  + FormatFloat('0000000000', mTempData02) ;
//                        //  mTempData02 = oraQrySelect02.FieldByName('JBRTR_PSRN').AsFloat;                 //퇴직연금-근로자보장법  ----
//                        //  C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02) ; 
//                        //  mTempData02 = oraQrySelect02.FieldByName('JRTR_HNSV').AsFloat;                 //퇴직연금-연금저축  --------
//                        //  C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02) ;
//
//                            //특별소득공제 
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciJbhth"),"0"));   /*(33)-가 column 특별공제_주건강보험료 : SPCI_JHTH */   
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciJbepf"),"0"));    /*(33)-나 column 특별공제_주고용보험료 : SPCI_JEPF */   
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//                         //   mTempData02 = oraQrySelect02.FieldByName('SPCI_GURT').AsFloat ;                  //일반보장성보험료
//                         //   C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
//                         //   mTempData02 = oraQrySelect02.FieldByName('SPCI_HDRC').AsFloat;                   //장애인전용보험료
//                         //   C_RecStr = C_RecStr  + FormatFloat('0000000000', mTempData02);
//                         //  mTempData02 = oraQrySelect02.FieldByName('SPCI_HBPS').AsFloat ;                  //의료비공제금액_장애인
//                         //  C_RecStr = C_RecStr  + FormatFloat('0000000000', mTempData02) ;
//                         //   mTempData02 = oraQrySelect02.FieldByName('SPCI_METO').AsFloat ;                  //의료비공제금액
//                         //  C_RecStr = C_RecStr  + FormatFloat('0000000000', mTempData02) ;
//                         //  mTempData02 = oraQrySelect02.FieldByName('SPCI_SPEC').AsFloat ;                  //교육비공제금액_장애인
//                         //  C_RecStr = C_RecStr   + FormatFloat('00000000', mTempData02)  ;
//                         //   mTempData02 = oraQrySelect02.FieldByName('SPED_TOAM').AsFloat ;                  //교육비공제금액
//                         //   C_RecStr = C_RecStr   + FormatFloat('00000000', mTempData02)  ;
//
//                            
//                           // 주택자금(주택임차차입금,장기주택저당차입금,주택마련저축) 관련공통사항 
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciRefn"),"0"));            /*(34)-가 column 특별공제_차입금원리금상환액_대출기관 : SPCI_REFN */   
//                            C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciResf"),"0"));               /*(34)-가 column 특별공제_차입금원리금상환액_거주자 : SPCI_RESF */ 
//                            C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ; 
//                            
//                           // mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("befoScnt"),"0")); oraQrySelect02.FieldByName('SPCI_HTAM').AsFloat ;                   //주택자금-월세액 대상금액
//                           // C_RecStr = C_RecStr   + FormatFloat('00000000', mTempData02); 
//                                                       
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spchRe15"),"0"));    /*(34)-나 column 특별공제_11장기주택저당차입금15 : SPCH_RE15 */  
//                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spchRe29"),"0"));      /*(34)-나 column 특별공제_11장기주택저당차입금29 : SPCH_RE29 */   
//                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spchRe30"),"0"));      /* (34)-나column 특별공제_11장기주택저당차입금30 : SPCH_RE30 */   
//                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02); 
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciRefx"),"0"));     /*(34)-나 column 특별공제_12장기주택저당차입금_고정 : SPCI_REFX */     
//                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciReec"),"0"));    /*(34)나 column 특별공제_12장기주택저당차입금_기타 : SPCI_REEC */
//                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
//                            
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spci15fx"),"0"));   /*(34)-나 column 특별공제_15장기주택저당_15고정AND비거치상환 : SPCI_15FX */
//                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spci15fb"),"0"));     /*(34)-나 column 특별공제_15장기주택저당_15고정OR비거치상환 : SPCI_15FB */
//                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spci15ec"),"0"));     /*(34)-나 column 특별공제_15장기주택저당_15기타대출 : SPCI_15EC */
//                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spci10fb"),"0"));      /*(34)-나 column 특별공제_15장기주택저당_10고정OR비거치상환 : SPCI_10FB */
//                            C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
// 
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciSsum"),"0"));     /*(35) column 이월분  특별공제_기부금공제액계 : SPCI_SSUM */    
//                            C_RecStr = C_RecStr   + String.format("%011d", mTempData02);
//
//                            // mTempData02 = oraQrySelect02.FieldByName('SPCI_PLTC').AsFloat ;                  //기부금공제금액 _정치
//                           // C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
//                           //  mTempData02 = oraQrySelect02.FieldByName('SPCI_FBAM').AsFloat ;                  //기부금공제금액_법정
//                           // C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
//                          //   mTempData02 = oraQrySelect02.FieldByName('SPCI_RFAM').AsFloat ;                  //기부금공제금액_우리사주조합기부금
//                           // C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
//                           //  mTempData02 = oraQrySelect02.FieldByName('SPCI_NYAM').AsFloat ;                  //기부금공제금액_지정기부금
//                          //  C_RecStr = C_RecStr   + FormatFloat('00000000000',mTempData02);
//                           // C_RecStr = C_RecStr   + "00000000000000000000" ;  //공란 
//
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spsmTotl"),"0"));   /*96  (36)    //특별소득공제 계  */
//                            C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);
//                            //mTempData02 =  oraQrySelect02.FieldByName('SPCI_DDCT').AsFloat;                 //표준공제
//                            //C_RecStr = C_RecStr  + FormatFloat('00000000', mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtEram"),"0"));       /* (97) column 차감소득금액 : SUBT_ERAM */  
//                            C_RecStr = C_RecStr  + String.format("%011d", mTempData02);
//                            
//                            //그 밖의 소득공제  
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etcpPsnv"),"0"));     /* (98)column 개인연금저축불입액_2000년이전 : ETCP_PSNV */  
//                            C_RecStr = C_RecStr   + String.format("%08d", mTempData02);
//                       //     mTempData02 = oraQrySelect02.FieldByName('ETCP_NSAV').AsFloat;                 //연금저축소득공제
//                        //    C_RecStr = C_RecStr  + FormatFloat('00000000', mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etchPrep"),"0"));    /* (99) column 기타공제_소기업공제불입금 : ETCH_PREP */    
//                            C_RecStr = C_RecStr  + String.format("%010d", mTempData02);
//
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etcsComp"),"0"));   /*(100)-가 column 기타공제_주택마련저축_청약저축 : ETCS_COMP */       
//                            C_RecStr = C_RecStr  + String.format("%010d",  mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etwkSbam"),"0"));    /* (101)-나column 기타공제_주택마련저축_주택청약종합저축 : ETWK_SBAM */       
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                          //  mTempData02 = oraQrySelect02.FieldByName('ETWK_LGAM').AsFloat ;                  //장기주택마련저축
//                          //  C_RecStr = C_RecStr   + FormatFloat('0000000000',mTempData02) ;
//                            mTempData02 =Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etwkSvam"),"0"));   /*(102)-다 column 기타공제_주택마련저축_근로자주택마련저축 : ETWK_SVAM */
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etgdDdam"),"0"));        /* (103) column 기타공제_투자조합출자공제액 : ETGD_DDAM */   
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etccCard"),"0"));     /*(104) column 기타공제_신용카드등사용액소득공제 : ETCC_CARD */ 
//                            C_RecStr = C_RecStr   + String.format("%08d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etckUnon"),"0"));       /*(105) column 기타공제_우리사주출연금공제 : ETCK_UNON */      
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//
//                          //  mTempData02 = Long.parseLong("0");                  //우리사주조합기부금
//                          //  C_RecStr = C_RecStr   + "00000000000";
//
//                            //mTempData02 = oraQrySelect02.FieldByName('ETCL_HMTO').AsFloat  ;                 //장기주식형저축소득공제
//                           // C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
//
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etepMsam"),"0"));       /*(45) column 기타공제_고용유지중소기업근로자임금삭감공제액 : ETEP_MSAM */ 
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//
//                          //  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etgdHtra"),"0"));       /*(46) column 기타공제_목돈안드는전세이자상환소득공제액 : ETGD_HTRA */        
//                            C_RecStr = C_RecStr   + "0000000000";                                                       //String.format("%010d",  mTempData02)  ;
//
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etepSecr"),"0"));      /*(47) column 기타공제_장기집합투자증권저축공제액 : ETEP_SECR */  
//                             C_RecStr = C_RecStr   + String.format("%010d",  mTempData02)  ;
//
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("etclTotl"),"0"));      /*(48) column 기타공제_공제계 : ETCD_TSUM */   
//                            C_RecStr = C_RecStr  + String.format("%011d",  mTempData02);
//
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spchExli"),"0"));     /*(49) column 특별공제_종합한도초과금액 : SPCH_EXLI */     
//                            C_RecStr = C_RecStr   + String.format("%011d",  mTempData02) ;
//
//
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("stndIncm"),"0"));     /*(50) column 종합소득과세표준 : STND_INCM */        
//                            C_RecStr = C_RecStr   + String.format("%011d",  mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("prddTaxn"),"0"));         /*(51) column 산출세액 : PRDD_TAXN */         
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//
//                            //------------------------ 세액감면 ------------------------------ 
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdIcax"),"0"));     /*(52) column 세액감면_소득세법 : TAXD_ICAX */    
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdSpct"),"0"));     /*(53) column 세액감면_조세특례법 : TAXD_SPCT */        
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02)  ;
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("txlgCl30"),"0"));  /*(54) column 세액감면_조세특례법제30조 : TXLG_CL30 */   
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02)  ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("txlgHxtt"),"0"));    /*(55) column 세액감면_조세조약 : TXLG_HXTT */   
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//                         //   mTempData02 = oraQrySelect02.FieldByName('PAYR_TEMP126').AsFloat ;              // 공란
//                         //   C_RecStr = C_RecStr   +  "0000000000"  ; 
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdTsum"),"0"));       /*(56) column 세액감면_감면세액계 : TAXD_TSUM */     
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//
//
//                            // ------------------------ 세액공제 -------------------------------------------------------
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdWken"),"0"));      /*(57) column 세액공제_근로소득세액공제 : TAXD_WKEN */ 
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrMrct"),"0"));               //다자녀추가공제인원 -----
//                             C_RecStr = C_RecStr   + String.format("%02d", mTempData02);
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrMccr"),"0"));         //자녀세액공제
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//
//
//                       //     mTempData02 = oraQrySelect02.FieldByName('ADDR_MCAM').AsFloat;                 //다자녀추가공제금액 ------
//                      //      C_RecStr = C_RecStr  + FormatFloat('00000000', mTempData02);
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrClct"),"0"));             //6세이하공제인원  -----
//                            C_RecStr = C_RecStr   + String.format("%02d",  mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrChld"),"0"));              //6세이하공제금액 -------
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrBhct"),"0"));              //출산입양자공제인원 --------
//                            C_RecStr = C_RecStr   + String.format("%02d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("addrBrth"),"0"));            // 출산입양자공제금액 ---------
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//
//
//
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrCtar"),"0"));                  //연금계좌_과학기술인공제_공제대상금액
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrHict"),"0"));                  //연금계좌_과학기술인공제_세액공제액
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrPtar"),"0"));               //연금계좌_근로자퇴직 급여보장법에 따른 퇴직급여 공제대상금액
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrPsrn"),"0"));                //연금계좌_근로자퇴직 급여보장법에 따른 퇴직급여 공제액
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrAtar"),"0"));               //연금계좌_ 연금저축 공제대상금액
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("jrtrHnsv"),"0"));              //연금계좌_연금저축 세액공제액
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//
//                            //mTempData02 = oraQrySelect02.FieldByName('SPCI_DETG').AsFloat ;                 //특별세액공제_보장성보험료_공제대상금액
//                            //C_RecStr = C_RecStr   + FormatFloat('0000000000',mTempData02) ;
//                            //mTempData02 = oraQrySelect02.FieldByName('SPCI_RTDE').AsFloat ;                 //특별세액공제_보장성보험효 세액공제액
//                            //C_RecStr = C_RecStr   + FormatFloat('0000000000',mTempData02) ;
//
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciRttg"),"0"));                //특별세액공제_보장성보험료_공제대상금액
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciGurt"),"0"));               // //특별공제_일반보장성보험료 세액공제액
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciHdtg"),"0"));              //특별공제_장애인보장성대상금액
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciHdrc"),"0"));                  //특특별공제_장애인보장성보험료 세액공제액
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//
//
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciDtar"),"0"));                 //특별세액공제_의료비_공제대상금액
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciTxcr"),"0"));               //특별세액공제_의료비_세액공제액
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spedEtar"),"0"));                 //특별세액공제_교육비_공제대상금액SPED_SFTR
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spedTxcr"),"0"));                 //특별세액공제_교육비_세액공제
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxd10tg"),"0"));                //특별세액공제_기부금_정치자금_10만원이하 공제 대상금액
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdPltc"),"0"));                  //특별세액공제_기부금_정치자금_10만원이하 공제
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciPltg"),"0"));                   //특별세액공제_기부금_정치자금_10만원초과  공제 대상금액
//                            C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciPltc"),"0"));                 //특별세액공제_기부금_정치자금_10만원초과  공제
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciFbtg"),"0"));                 //특별세액공제_기부금_법정기부금 공제 대상금액
//                            C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciFbam"),"0"));                 //특별세액공제_기부금_법정기부금 공제
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                            
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciHftg"),"0"));   /* (65)-다column 우리사주종합기부대상금액 : SPCI_HFTG */
//                            C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spcirfam"),"0"));    /*(65)-다 column 특별공제_기부금_우리사주조합세액공제액 : SPCI_RFAM */
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                             
//
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciNatg"),"0"));                /*(65)-라 column  2014년이후 기부금합게 종교단체외지정대상금액 : SPCI_NATG */
//                            C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciNamt"),"0"));                 /*(65)-라 column 특별공제_기부금_특별공제_기부금_종교단체외 : SPCI_NAMT */
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                            
//                            
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciYatg"),"0"));                 /*(65)-라 column  2014년이후 기부금합게 종교단체지정대상금액 : SPCI_YATG */
//                            C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ; 
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciYamt"),"0"));                /*(65)-라 column 특별공제_기부금_특별공제_기부금_종교단체 : SPCI_YAMT */
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                          
//                            
//                            
//                        //     mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciNyag"),"0"));                 //특별세액공제_기부금_지정기부금 공제대상금액
//                        //    C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
//                        //     mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciNyam"),"0"));                 //특별세액공제_기부금 지정기부금 세액
//                        //    C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                           
//                            
//                           // SPCI_NATG	종교단체외지정대상금액	 
//                           // SPCI_YATG	종교단체지정대상금액	 
//                            
//                            
//                            
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciDcto"),"0"));                 //특별세액공제 계
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                             mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciDdct"),"0"));              //표준 세액 공제
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//
//
//
//
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdUnin"),"0"));               //납세조합공제
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdLoan"),"0"));              //주택차입금
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//                         //   mTempData02 = oraQrySelect02.FieldByName('TAXD_PLTC').AsFloat ;                  //기부정치자금
//                          //  C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
//                            mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdPaid"),"0"));               //외국납부
//                            C_RecStr = C_RecStr  + String.format("%010d",  mTempData02) ;
//                            
//                            
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciTgrt"),"0"));     /*(71) column 특별공제_월세세액공제대상금액 : SPCI_TGRT */ 
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;        
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("spciRtam"),"0"));            //    월세 세액 공제
//                            C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxdCsum"),"0"));               //세액공제계
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
//
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dcsnIncm"),"0"));               //소득세
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dcsnInhb"),"0"));                //지방소득세
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dcsnFafv"),"0"));                  //농특세
//                            C_RecStr = C_RecStr    + String.format("%010d", mTempData02);
//                         //   mTempData02 = oraQrySelect02.FieldByName('DCSN_TOTL').AsFloat;                  //합계
//                         //   C_RecStr = C_RecStr    + FormatFloat('0000000000', mTempData02) ;
//                            
//                            //기납부세액 - 주현근무지  
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("alryPinx"),"0"));       //기납부소득세
//                            C_RecStr = C_RecStr    + String.format("%010d",  mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("alryPhbx"),"0"));                  //기납부지방소득세
//                            C_RecStr = C_RecStr    + String.format("%010d", mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("alryYvtx"),"0"));               //기납부농특세
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//
//                            
//                            //계산에 의해처리 해야 함......todo 
//                             C_RecStr = C_RecStr   +  "0000000000"  ;          //납부특례세액 _소득세
//                             C_RecStr = C_RecStr   +  "0000000000"  ;            //납부특례세액 _지방소득세
//                             C_RecStr = C_RecStr   +  "0000000000"  ;           //납부특례세액 _농특세 
//
//
//                         //   mTempData02 = oraQrySelect02.FieldByName('ALRY_TOTL').AsFloat ;
//                         //   C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtEtaxb"),"0"));           //소득세음양
//                            C_RecStr = C_RecStr   + String.format("%01d",  mTempData02)  ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtEtax"),"0"));        //소득세
//                            C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtInhbb"),"0"));          //지방소득세음양
//                            C_RecStr = C_RecStr  + String.format("%01d", mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtInhb"),"0"));          //지방소득세
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtFafvb"),"0"));           //농특세음양
//                            C_RecStr = C_RecStr   + String.format("%01d", mTempData02);
//                            mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtFafv"),"0"));              //농특세
//                            C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
//                         //   mTempData02 = oraQrySelect02.FieldByName('SUBT_AMSUB').AsFloat ;
//                        //    C_RecStr = C_RecStr   + FormatFloat('0', mTempData02);
//                         //   mTempData02 = oraQrySelect02.FieldByName('SUBT_AMSU').AsFloat;
//                        //    C_RecStr = C_RecStr   + FormatFloat('0000000000', mTempData02);
//                            C_RecStr = C_RecStr   + String.format("%-15s", "") ;
//                             
//              
//               TOT_Record.add(C_RecStr);
//
//               D_Cnt = 1; 
//               
//               //fnPayrD_ReTax_Total_Select
//               ye161010VO.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
//               
//               List listYetaD = yeta3400PayrService.fnPayrD_ReTax_Total_Select(ye161010VO);
//               
//          	 
// 
//               if (listYetaD.size() > 0) { 
//
//              	  Iterator<Map<String, Object>> iter01 = listYetaD.iterator(); 
//             	   
//                   while ( iter01.hasNext() ) { 
//                    	
//                     Map<String, Object> mapYetaD = (Map<String, Object>) iter01.next(); 
//                     
//                     mTempData02 = 0L;
//                     D_RecStr = "";
//                     D_RecStr = "D" + "20" + ye161010VO.getTaxaCode();
//                                 D_RecStr = D_RecStr +   String.format("%06d", C_Cnt);  
//                                 D_RecStr = D_RecStr +  String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-",""));
//                                 D_RecStr = D_RecStr + String.format("%50s", "")  + String.format("%-13s", StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),""),"-",""));
//                            
//                                 //근무처별 소득 명세 - 종전근무처 
//                                 D_RecStr = D_RecStr + "2" ;  //todo 납세조합구분자 필요 
//                                 D_RecStr = D_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaD.get("siteCtnt"),"") ,38),40," ") ;
//                                 D_RecStr = D_RecStr + String.format("%-10s", MSFSharedUtils.defaultNulls(mapYetaD.get("siteNumb"),""))  ;
//                                 D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("jeymStdt"),"0"))); 
//                                 D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("jeymEddt"),"0"))); 
//                                 D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("jutrStdt"),"0"))); 
//                                 D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("jutrEddt"),"0"))); 
//                               
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("payrTotl"),"0"));  
//                                 D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("bonsAmnt"),"0")); 
//                                 D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("dtmnBtam"),"0")); 
//                                 D_RecStr = D_RecStr +  String.format("%011d", mTempData02);
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("stckPrft"),"0")); 
//                                 D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("unonAmnt"),"0")); 
//                                 D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("ofrrExli"),"0")); 
//                                 D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
// 
//                                 D_RecStr = D_RecStr + "0000000000000000000000" ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("payrBtot"),"0")); 
//                                 D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
//                                  
//                                 //종전근무지 비과세소득 및 감면소득  
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSg01"),"0"));  
//                                 C_RecStr = C_RecStr   + String.format("%010d", mTempData02);
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh01"),"0"));  
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh05"),"0"));  
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh06"),"0"));  
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh07"),"0"));  
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh08"),"0"));  
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh09"),"0"));  
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh10"),"0"));  
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh14"),"0"));  
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh15"),"0"));  
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh11"),"0"));  
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh12"),"0"));  
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ;
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh13"),"0"));  
//                                C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;
//                                mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh16"),"0"));  
//                                C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;
//                                mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSi01"),"0"));  
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                                 mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSk01"),"0"));  
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm01"),"0")); 
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm02"),"0"));  
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm03"),"0"));  
//                                  C_RecStr = C_RecStr  +  String.format("%010d",  mTempData02) ;
//                                  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSo01"),"0")); 
//                                 C_RecStr = C_RecStr   +  String.format("%010d", mTempData02)  ;
//                                 mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSq01"),"0")); 
//                                  C_RecStr = C_RecStr  +  String.format("%010d", mTempData02) ;
//                                  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSr10"),"0")); 
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSs01"),"0"));  
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt01"),"0")); 
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                                 mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy02"),"0")); 
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy03"),"0"));  
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                                 
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy04"),"0"));  
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                                 
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy21"),"0")); 
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy22"),"0")); 
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt10"),"0")); 
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                                 
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt11"),"0")); 
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt12"),"0")); 
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                                 
//                                 
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt20"),"0")); 
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp51"),"0"));    //비과세계
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                                 mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("payrTemp52"),"0"));   //감면소득계
//                                 C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
//                                     
//
//                                // mTempData02 = oLong.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("JUTR_EDDT"),"0"));raQrySelect03.FieldByName('TAXE_TOTL').AsFloat ;
//                              //   D_RecStr = D_RecStr +  FormatFloat('0000000000', mTempData02);
//                                //  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("JUTR_EDDT"),"0"));oraQrySelect03.FieldByName('PAYR_TEMP55').AsFloat ;
//                                 D_RecStr = D_RecStr + "0000000000";
//                                 
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("EARN_TAXN"),"0")); 
//                                 D_RecStr = D_RecStr +  String.format("%010d", mTempData02);
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("IHTX_TAXN"),"0")); 
//                                 D_RecStr = D_RecStr +  String.format("%010d", mTempData02);
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("FARM_TAXN"),"0")); 
//                                 D_RecStr = D_RecStr +  String.format("%010d", mTempData02);
//                                // mTempData02 =  oraQrySelect03.FieldByName('FARM_BTOT').AsFloat ;
//                               //  D_RecStr = D_RecStr  +  FormatFloat('0000000000',mTempData02);
//                                 D_RecStr = D_RecStr +  String.format("%02d",  D_Cnt);
//                                 D_RecStr = D_RecStr + String.format("%961s", ""); 
// 
//                     
//                      TOT_Record.add(D_RecStr);
//
//                    
//                    D_Cnt = D_Cnt + 1;
//                   }
//               }
//
//               //E레코드
//               E_Cnt = 1;
//               E_RowCnt = 1;
//               E_RecStr = "";
//
//              ye161010VO.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
//               
//               List listYetaE = yeta3400PayrService.fnPayrE_ReTax_Total_Select(ye161010VO);
//               
//          	 
// 
//               if ( listYetaE.size() > 0) { 
//
//              	  Iterator<Map<String, Object>> iter03 = listYetaE.iterator(); 
//             	   
//                   while ( iter03.hasNext() ) { 
//                    	
//                     Map<String, Object> mapYetaE = (Map<String, Object>) iter03.next(); 
//                     
//               
//                      mTempData02 = 0L;
//                      
//                   // 주민번호(복호화)
//      				 rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//      		          	 
//                      
//                      E_RecStr =  "E" + "20" + ye161010VO.getTaxaCode() +  String.format("%06d", C_Cnt)
//                                 +  String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-",""))
//                                 + String.format("%-13s", StringUtils.replace(rrnDecCrypt,"-",""));
//
//                 if (listYetaE.size() + 1 > E_RowCnt)  {
//
//                          // E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  
//                      
//                      /** (CASE WHEN YETA3220.RELH_CODE IN ('A0190001')  THEN 0       
//				           WHEN YETA3220.RELH_CODE IN ('A0190003','A0190004','A0190009','A0190010','A0190017','A0190018','A0190019','A0190053','A0190054','A0190055','A0190056','A0190051','A0190050','A0190078','A0190079')  THEN 1  
//				           WHEN YETA3220.RELH_CODE IN ('A0190011','A0190012','A0190013')  THEN 2                                                                                         
//				           WHEN YETA3220.RELH_CODE IN ('A0190002','A0190007')  THEN 3                                                                                                                          
//				           WHEN YETA3220.RELH_CODE IN ('A0190005')  THEN 4   
//				           WHEN YETA3220.RELH_CODE IN ('A0190040','A0190032','A0190099','A0190076' ,'A0190100')  THEN 5                                                                                                                         
//				           WHEN YETA3220.RELH_CODE IN ('A0190038','A0190022','A0190021','A0190020','A0190023','A0190025','A0190033','A0190035','A0190037','A0190051','A0190052','A0190089','A0190053','A0190090','A0190091','A0190032')  THEN 6            
//				           WHEN YETA3220.RELH_CODE IN ('A0190109')  THEN 7                            
//				           WHEN YETA3220.RELH_CODE IN ('A0190100')  THEN 8  END )  AS RELH_CODE,  */
//                      
//                                  E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드 
//                                  E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," "); 
//                                  E_RecStr = E_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")   ;
//                               
//                               // 주민번호(복호화)
//                  				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//                  		          	 
//                                  E_RecStr = E_RecStr+ rrnDecCrypt;  
//                                  
//                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
//                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
//                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
//                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  
//
//                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  
//
//                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
//                                  E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  
//
//                                  //소득공제국세청자료 
//                                  mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
//                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
//                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//
//                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
//                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
//                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
//                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
//                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
//                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
//                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
//                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//
//
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
//                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
//                                  E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;
//
//                                  //소득공제자료 기타자료 
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
//                                  E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
//                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                    mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
//                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
//                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
//                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
//                                  E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
//                                  E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//
//
//                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
//                                   E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                    mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
//                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
//                                  E_RecStr = E_RecStr+   String.format("%013d",mTempData02);
//                                
//                                  E_RowCnt =  E_RowCnt + 1;
//                                 try {
//                                	  mapYetaE = (Map<String, Object>) iter03.next(); 
//                              	 } catch (NoSuchElementException e) {
//                              		//e.printStackTrace();
//                              	 }   
//
//                 }
//                 else
//                 {
//                       E_RecStr = E_RecStr + String.format("%1s","")
//                                  + String.format("%1s","")
//                                  + String.format("%20s","")
//                                  + String.format("%13s","")
//                                  + String.format("%1s","")
//                                  + String.format("%1s","")
//                                  + String.format("%1s","")
//                                  + String.format("%1s","")
//                                  + String.format("%1s","")
//                                  + String.format("%1s","")
//                                  + String.format("%1s","")
//                                  + "0000000000"
//                                  + "0000000000"
//                                  + "0000000000"
//                                  + "0000000000"
//                                  + "0000000000"
//                                  + "0000000000"
//                                  + "0000000000"
//                                  + "0000000000"
//                                  + "0000000000"
//                                  + "0000000000"
//                                  + "0000000000000"
//                                  + "0000000000"
//                                  + "0000000000"
//                                  + "0000000000"
//                                  + "0000000000"
//                                  + "0000000000"
//                                  + "0000000000"
//                                  + "0000000000"
//                                  + "0000000000"
//                                  + "0000000000"
//                                  + "0000000000000";
// 
//                        E_RowCnt =  E_RowCnt + 1;
//                 }
//                 
//                 if (listYetaE.size() + 1 > E_RowCnt)  {
//
//                  //   E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," "); 
//                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드 
//                                 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," ");   
//                                 E_RecStr = E_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")  ;
//                                
//                                 // 주민번호(복호화)
//                 				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//                 		          	 
//                 				  
//                                 E_RecStr = E_RecStr+ rrnDecCrypt;  
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  
//
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  
//
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  
//
//                                 mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
//                                 E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
//                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
//                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//
//
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
//                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
//                                 E_RecStr = E_RecStr+   String.format("%013d",mTempData02);
//                                 E_RowCnt =  E_RowCnt + 1;
//                                 try {
//                               	  mapYetaE = (Map<String, Object>) iter03.next(); 
//                             	 } catch (NoSuchElementException e) {
//                             		//e.printStackTrace();
//                             	 }     
//                     
//
//                }
//                else
//                {
//                      E_RecStr = E_RecStr + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%20s","")
//                                 + String.format("%13s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000000";
//
//                       E_RowCnt =  E_RowCnt + 1;
//                }
//
//                 if (listYetaE.size() + 1 > E_RowCnt)  {
//
//                     //E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  
//                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드   
//                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," ");   
//                                 E_RecStr = E_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")  ;
//                               
//                                 // 주민번호(복호화)
//                				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//                		          
//                				  
//                                 E_RecStr = E_RecStr+ rrnDecCrypt;  
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  
//
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  
//
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  
//
//                                 mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
//                                 E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
//                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
//                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//
//
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
//                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
//                                 E_RecStr = E_RecStr+   String.format("%013d",mTempData02);
//                                 E_RowCnt =  E_RowCnt + 1;
//                                 try {
//                               	  mapYetaE = (Map<String, Object>) iter03.next(); 
//                             	 } catch (NoSuchElementException e) {
//                             		//e.printStackTrace();
//                             	 }     
//                       
//
//                }
//                else
//                {
//                      E_RecStr = E_RecStr + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%20s","")
//                                 + String.format("%13s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000000";
//
//                       E_RowCnt =  E_RowCnt + 1;
//                }
//                 if (listYetaE.size() + 1 > E_RowCnt)  {
//
//                    // E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  
//                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드  
//                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," ");   
//                                 E_RecStr = E_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")   ;
//                                
//                                 // 주민번호(복호화)
//               				     rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//               		          
//                                 E_RecStr = E_RecStr+ rrnDecCrypt;  
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  
//
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  
//
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  
//
//                                 mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
//                                 E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
//                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
//                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//
//
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
//                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
//                                 E_RecStr = E_RecStr+   String.format("%013d",mTempData02);
//                                 E_RowCnt =  E_RowCnt + 1;
//                                 try {
//                               	  mapYetaE = (Map<String, Object>) iter03.next(); 
//                             	 } catch (NoSuchElementException e) {
//                             		//e.printStackTrace();
//                             	 }     
//                     
//
//                }
//                else
//                {
//                      E_RecStr = E_RecStr + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%20s","")
//                                 + String.format("%13s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000000";
//
//                       E_RowCnt =  E_RowCnt + 1;
//                }
//                 
//                 if (listYetaE.size() + 1 > E_RowCnt)  {
//
//                   //  E_RecStr =  E_RecStr + MSFSharedUtils.defaultNulls(mapYetaE.get("relhCode")," ");  
//                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("famySupptRelaDivCd")," ");    //연말정산부양관계코드 
//                	 E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("frnrCode")," ");   
//                                 E_RecStr = E_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaE.get("kornName"),"") ,18),20," ")  ;
//                               
//                                 // 주민번호(복호화)
//               				     rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("rsnoNumb"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//               		          
//                                 
//                                 E_RecStr = E_RecStr+ rrnDecCrypt;  
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("baseDdyn")," ");  
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("psclDdyn")," ");  
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("faddCtyn")," ");   
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("rpctDdyn")," ");  
//
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("pantOnyn")," ");  
//
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bithDdyn")," ");  
//                                 E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("brddCtyn")," ");  
//
//                                 mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuPayr"),"0"));          //보험료 _건강
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtyr"),"0"));          //보험료 _보장성
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurr"),"0"));          //보험료 _장애인보장성 국세청
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediCost"),"0"));        // 의료비
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educCost"),"0"));         //교육비
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCard"),"0"));        // 신용카드
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCard"),"0"));        //직불카드
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cashRece"),"0"));          // 현금영수증
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntStvd"),"0"));        //전통시장
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
//
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAmnt"),"0"));        //대중교통
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmnt"),"0"));       //기부금
//                                 E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuFetc"),"0"));          //보험료 _ 건강고용등외
//                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("insuRtet"),"0"));     //보험료 _ 보장성
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("psclIurt"),"0"));         //보험료 _장애인보장성 외
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mediExps"),"0"));        //의료비 외
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("educOtec"),"0"));           //교육비 외
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cdteCdec"),"0"));       // 신용카드 외
//                                 E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("jiblCdec"),"0"));      //직북선불카드 외
//                                 E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;
//
//
//                                  mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mgntSdec"),"0"));      //전통시장 사용액 외
//                                  E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                   mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("grpyAtec"),"0"));        //대중교통외
//                                 E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
//
//                                 mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("ctrbAmec"),"0"));      // 기부금외
//                                 E_RecStr = E_RecStr+   String.format("%013d",mTempData02);
//
////                                 try {
////                               	  mapYetaE = (Map<String, Object>) iter03.next(); 
////                             	 } catch (NoSuchElementException e) {
////                             		//e.printStackTrace();
////                             	 }      
//                       E_RowCnt =  E_RowCnt + 1;
//
//                }
//                else
//                {
//                      E_RecStr = E_RecStr + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%20s","")
//                                 + String.format("%13s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + String.format("%1s","")
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000"
//                                 + "0000000000000";
//
//                       E_RowCnt =  E_RowCnt + 1;
//                }
//                 E_RecStr = E_RecStr +  String.format("%02d",  E_Cnt)
//                                  + String.format("%293s", "") ;
//
//                       TOT_Record.add(E_RecStr);
//
//                       E_Cnt = E_Cnt + 1;
//                       E_RecStr = ""; 
//
//                   }
//               }
//
//              // F레코드  - 연금저축등 소득세액공제명세 레코드 
//
//               F_Cnt = 1;
//               F_RowCnt = 1;
//               F_RecStr = "";
//              
//               ye161010VO.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
//               
//               List listYetaF = yeta3400PayrService.fnPayrF_ReTax_Total_Select(ye161010VO);
//                
// 
//               if ( listYetaF.size() > 0) { 
//
//              	  Iterator<Map<String, Object>> iter04 = listYetaF.iterator(); 
//             	   
//                   while ( iter04.hasNext() ) { 
//                    	
//                     Map<String, Object> mapYetaF = (Map<String, Object>) iter04.next(); 
//    
//                    mTempData02 = 0L;
//
//                 // 주민번호(복호화)
//    				 rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//    		          	 
//                   F_RecStr =  "F" + "20" + ye161010VO.getTaxaCode() +  String.format("%06d", C_Cnt) + String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-",""))
//                                  + String.format("%-13s",rrnDecCrypt ) ;
// 
//                   
//                 if (listYetaF.size() + 1 > F_RowCnt)  {
//                  
//                                F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//                                   + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//                                   + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//                                   + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
//                                   mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//                                   F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//                                   mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//                                   F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//
//
//                          F_RowCnt =  F_RowCnt + 1;
//                          
//                          try {
//                        	  mapYetaF = (Map<String, Object>) iter04.next(); 
//                         	 } catch (NoSuchElementException e) {
//                         		//e.printStackTrace();
//                         	 }      
//                          
//                 }
//                 else
//                 {
//                        F_RecStr = F_RecStr + String.format("%-2s","")
//                                   + String.format("%-3s","")
//                                   +  String.format("%-50s","")
//                                   + String.format("%-20s","")
//                                   +  "0000000000"
//                                   +  "0000000000";
//
//                        F_RowCnt =  F_RowCnt + 1;
//                 }
//
//                 if (listYetaF.size() + 1 > F_RowCnt)  {
//                     
//                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//                         + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//
//
//               F_RowCnt =  F_RowCnt + 1;
//               try {
//             	  mapYetaF = (Map<String, Object>) iter04.next(); 
//              	 } catch (NoSuchElementException e) {
//              		//e.printStackTrace();
//              	 }     
//      }
//      else
//      {
//             F_RecStr = F_RecStr + String.format("%-2s","")
//                        + String.format("%-3s","")
//                        +  String.format("%-50s","")
//                        + String.format("%-20s","")
//                        +  "0000000000"
//                        +  "0000000000";
//
//             F_RowCnt =  F_RowCnt + 1;
//      }
//
//                 if (listYetaF.size() + 1 > F_RowCnt)  {
//                     
//                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//                         + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//
//
//               F_RowCnt =  F_RowCnt + 1;
//               try {
//             	  mapYetaF = (Map<String, Object>) iter04.next(); 
//              	 } catch (NoSuchElementException e) {
//              		//e.printStackTrace();
//              	 }     
//      }
//      else
//      {
//             F_RecStr = F_RecStr + String.format("%-2s","")
//                        + String.format("%-3s","")
//                        +  String.format("%-50s","")
//                        + String.format("%-20s","")
//                        +  "0000000000"
//                        +  "0000000000";
//
//             F_RowCnt =  F_RowCnt + 1;
//      }
//
//                 if (listYetaF.size() + 1 > F_RowCnt)  {
//                     
//                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//                         + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//
//
//               F_RowCnt =  F_RowCnt + 1;
//               try {
//             	  mapYetaF = (Map<String, Object>) iter04.next(); 
//              	 } catch (NoSuchElementException e) {
//              		//e.printStackTrace();
//              	 }     
//      }
//      else
//      {
//             F_RecStr = F_RecStr + String.format("%-2s","")
//                        + String.format("%-3s","")
//                        +  String.format("%-50s","")
//                        + String.format("%-20s","")
//                        +  "0000000000"
//                        +  "0000000000";
//
//             F_RowCnt =  F_RowCnt + 1;
//      }
//
//                 if (listYetaF.size() + 1 > F_RowCnt)  {
//                     
//                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//                         + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//
//
//               F_RowCnt =  F_RowCnt + 1;
//               try {
//             	  mapYetaF = (Map<String, Object>) iter04.next(); 
//              	 } catch (NoSuchElementException e) {
//              		//e.printStackTrace();
//              	 }     
//      }
//      else
//      {
//             F_RecStr = F_RecStr + String.format("%-2s","")
//                        + String.format("%-3s","")
//                        +  String.format("%-50s","")
//                        + String.format("%-20s","")
//                        +  "0000000000"
//                        +  "0000000000";
//
//             F_RowCnt =  F_RowCnt + 1;
//      }
//
//                 if (listYetaF.size() + 1 > F_RowCnt)  {
//                     
//                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//                         + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//
//
//               F_RowCnt =  F_RowCnt + 1;
//               try {
//             	  mapYetaF = (Map<String, Object>) iter04.next(); 
//              	 } catch (NoSuchElementException e) {
//              		//e.printStackTrace();
//              	 }     
//      }
//      else
//      {
//             F_RecStr = F_RecStr + String.format("%-2s","")
//                        + String.format("%-3s","")
//                        +  String.format("%-50s","")
//                        + String.format("%-20s","")
//                        +  "0000000000"
//                        +  "0000000000";
//
//             F_RowCnt =  F_RowCnt + 1;
//      }
//
//                 if (listYetaF.size() + 1 > F_RowCnt)  {
//                     
//                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//                         + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//
//
//               F_RowCnt =  F_RowCnt + 1;
//               try {
//             	  mapYetaF = (Map<String, Object>) iter04.next(); 
//              	 } catch (NoSuchElementException e) {
//              		//e.printStackTrace();
//              	 }     
//      }
//      else
//      {
//             F_RecStr = F_RecStr + String.format("%-2s","")
//                        + String.format("%-3s","")
//                        +  String.format("%-50s","")
//                        + String.format("%-20s","")
//                        +  "0000000000"
//                        +  "0000000000";
//
//             F_RowCnt =  F_RowCnt + 1;
//      }
//
//                 if (listYetaF.size() + 1 > F_RowCnt)  {
//                     
//                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//
//
//               F_RowCnt =  F_RowCnt + 1;
//               try {
//             	  mapYetaF = (Map<String, Object>) iter04.next(); 
//              	 } catch (NoSuchElementException e) {
//              		//e.printStackTrace();
//              	 }     
//      }
//      else
//      {
//             F_RecStr = F_RecStr + String.format("%-2s","")
//                        + String.format("%-3s","")
//                        +  String.format("%-50s","")
//                        + String.format("%-20s","")
//                        +  "0000000000"
//                        +  "0000000000";
//
//             F_RowCnt =  F_RowCnt + 1;
//      }
//
//                 if (listYetaF.size() + 1 > F_RowCnt)  {
//                     
//                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//                         + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//
//
//               F_RowCnt =  F_RowCnt + 1;
//               try {
//             	  mapYetaF = (Map<String, Object>) iter04.next(); 
//              	 } catch (NoSuchElementException e) {
//              		//e.printStackTrace();
//              	 }     
//      }
//      else
//      {
//             F_RecStr = F_RecStr + String.format("%-2s","")
//                        + String.format("%-3s","")
//                        +  String.format("%-50s","")
//                        + String.format("%-20s","")
//                        +  "0000000000"
//                        +  "0000000000";
//
//             F_RowCnt =  F_RowCnt + 1;
//      }
//
//                 if (listYetaF.size() + 1 > F_RowCnt)  {
//                     
//                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//
//
//               F_RowCnt =  F_RowCnt + 1;
//               try {
//             	  mapYetaF = (Map<String, Object>) iter04.next(); 
//              	 } catch (NoSuchElementException e) {
//              		//e.printStackTrace();
//              	 }     
//      }
//      else
//      {
//             F_RecStr = F_RecStr + String.format("%-2s","")
//                        + String.format("%-3s","")
//                        +  String.format("%-50s","")
//                        + String.format("%-20s","")
//                        +  "0000000000"
//                        +  "0000000000";
//
//             F_RowCnt =  F_RowCnt + 1;
//      }
//
//                 if (listYetaF.size() + 1 > F_RowCnt)  {
//                     
//                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//                         + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//
//
//               F_RowCnt =  F_RowCnt + 1;
//               try {
//             	  mapYetaF = (Map<String, Object>) iter04.next(); 
//              	 } catch (NoSuchElementException e) {
//              		//e.printStackTrace();
//              	 }     
//      }
//      else
//      {
//             F_RecStr = F_RecStr + String.format("%-2s","")
//                        + String.format("%-3s","")
//                        +  String.format("%-50s","")
//                        + String.format("%-20s","")
//                        +  "0000000000"
//                        +  "0000000000";
//
//             F_RowCnt =  F_RowCnt + 1;
//      }
//
//                 if (listYetaF.size() + 1 > F_RowCnt)  {
//                     
//                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//                         + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//
//
//               F_RowCnt =  F_RowCnt + 1;
//               try {
//             	  mapYetaF = (Map<String, Object>) iter04.next(); 
//              	 } catch (NoSuchElementException e) {
//              		//e.printStackTrace();
//              	 }     
//      }
//      else
//      {
//             F_RecStr = F_RecStr + String.format("%-2s","")
//                        + String.format("%-3s","")
//                        +  String.format("%-50s","")
//                        + String.format("%-20s","")
//                        +  "0000000000"
//                        +  "0000000000";
//
//             F_RowCnt =  F_RowCnt + 1;
//      }
//
//                 if (listYetaF.size() + 1 > F_RowCnt)  {
//                     
//                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ;  
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//
//
//               F_RowCnt =  F_RowCnt + 1;
//               try {
//             	  mapYetaF = (Map<String, Object>) iter04.next(); 
//              	 } catch (NoSuchElementException e) {
//              		//e.printStackTrace();
//              	 }     
//      }
//      else
//      {
//             F_RecStr = F_RecStr + String.format("%-2s","")
//                        + String.format("%-3s","")
//                        +  String.format("%-50s","")
//                        + String.format("%-20s","")
//                        +  "0000000000"
//                        +  "0000000000";
//
//             F_RowCnt =  F_RowCnt + 1;
//      }
//
//                 if (listYetaF.size() + 1 > F_RowCnt)  {
//                     
//                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//
//
//               F_RowCnt =  F_RowCnt + 1;
//               try {
//             	  mapYetaF = (Map<String, Object>) iter04.next(); 
//              	 } catch (NoSuchElementException e) {
//              		//e.printStackTrace();
//              	 }     
//      }
//      else
//      {
//             F_RecStr = F_RecStr + String.format("%-2s","")
//                        + String.format("%-3s","")
//                        +  String.format("%-50s","")
//                        + String.format("%-20s","")
//                        +  "0000000000"
//                        +  "0000000000";
//
//             F_RowCnt =  F_RowCnt + 1;
//      }
//
//                 if (listYetaF.size() + 1 > F_RowCnt)  {
//                     
//                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("imdeTxcd"),""))   
//                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("finaTxcd"),""))  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("finaName"),""),48),50," ")  
//                        + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaF.get("acntNumb"),""),18),20," ") ; 
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("paytAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
//                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("deduAmnt"),"0"));  
//                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02) ;
//
//
//               F_RowCnt =  F_RowCnt + 1;
////               try {
////             	  mapYetaF = (Map<String, Object>) iter04.next(); 
////              	 } catch (NoSuchElementException e) {
////              		//e.printStackTrace();
////              	 }     
//      }
//      else
//      {
//             F_RecStr = F_RecStr + String.format("%-2s","")
//                        + String.format("%-3s","")
//                        +  String.format("%-50s","")
//                        + String.format("%-20s","")
//                        +  "0000000000"
//                        +  "0000000000";
//
//             F_RowCnt =  F_RowCnt + 1;
//      }
//
//
//                 F_RecStr = F_RecStr + String.format("%-160s","");
//                       TOT_Record.add(F_RecStr);
//
//
//                       F_Cnt = F_Cnt + 1;
//
//                       F_RecStr = "";  
//
//                   }
//               }
//
//
//               //---------------------------------------------------------------------------------
//               //G레코드 - 월세 거주간 주택임차 차입금 원리금 상환액 소득공제명세 레코드  
//               //---------------------------------------------------------------------------------
//               
//               G_Cnt = 1;
//               G_RowCnt = 1;
//               G_RecStr = "";
//               
//               ye161010VO.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
//               
//               List listYetaG = yeta3400PayrService.fnPayrG_ReTax_Total_Select(ye161010VO);
//                
// 
//               if ( listYetaG.size() > 0) { 
// 
//              	   Iterator<Map<String, Object>> iter05 = listYetaG.iterator(); 
//             	   
//                   while ( iter05.hasNext() ) { 
//                    	
//                     Map<String, Object> mapYetaG = (Map<String, Object>) iter05.next(); 
//                           
//                    
//                     if ((listYetaG.size() > 0) &&  (MSFSharedUtils.paramNotNull( mapYetaG.get("mnrnName")) 
//                     ||  MSFSharedUtils.paramNotNull( mapYetaG.get("cnclName")) || MSFSharedUtils.paramNotNull( mapYetaG.get("leasName"))))  {
//                     
//                    	// 주민번호(복호화)
//         				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//         		          	 
//                       mTempData02 = 0L;
//
//                       G_RecStr =  "G" + "20" + ye161010VO.getTaxaCode()  +  String.format("%06d", C_Cnt) +  String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-",""))
//                                      + String.format("%-13s",rrnDecCrypt) ;
//
//                       
//                       if (listYetaG.size() + 1 > G_RowCnt)  {
//                      
//                    	// 주민번호(복호화)
//          				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyBurRgsum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//          		          	 
//                                    G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnName"),""),18),20," ")  
//                                       +  String.format("%-13s", rrnDecCrypt);
//                                   
//                                       G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnTyhu"),"") );
//                                       G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnArea"),"0.00")))),".","");     //소숫점처리
//
//                                       G_RecStr = G_RecStr +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAddr"),"") ,98),100," ")  ;
//
//                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnStdt"),"") ;
//                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnEddt"),"") ;
//
//                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAmnt"),"0"));  
//                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnDuam"),"0"));   
//                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
//
//
//                                        G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclName"),"") ,18),20," ") 
//                                       + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRsno"),"") ) ;
//                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclStdt"),"") ;
//                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclEddt"),"")  ;
//
//                                       G_RecStr = G_RecStr +  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItro"),"0.00")))),".","") ;     //소숫점처리
//
//                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRdmt"),"0")); 
//                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
//                                        mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclPrpl"),"0"));
//                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItrt"),"0"));
//                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
//                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclDuam"),"0"));
//                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//
//
//                                      G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("leasName"),"") ,18),20," ")  
//                                       + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("leasRsno"),"")  );
//
//                                       G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("leasTyhu"),"")   );
//                                       G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("leasArea"),"0.00")))),".","")  ;     //소숫점처리
//
//                                       G_RecStr = G_RecStr +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("leasAddr"),"") ,98),100," ") ;
//                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasStdt"),"") ;
//                                       G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasEddt"),"")  ;
//
//                                       mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("leasDpst"),"0"));   
//                                       G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//
//                              G_RowCnt =  G_RowCnt + 1;
//                              try {
//                            	  mapYetaG = (Map<String, Object>) iter05.next(); 
//                             	 } catch (NoSuchElementException e) {
//                             		//e.printStackTrace();
//                             	 }     
//                              
//                       }
//                     else
//                     {
//                            G_RecStr = G_RecStr + String.format("%-20s","")
//                                       + String.format("%-13s","")
//                                       + String.format("%-1s","")
//                                       +  "00000"
//                                       + String.format("%-100s","")
//                                       +  "00000000"
//                                       +  "00000000"
//                                       +  "0000000000"
//                                       +  "0000000000"
//                                       + String.format("%-20s","")
//                                       + String.format("%-13s","")
//                                       +  "00000000"
//                                       +  "00000000"
//                                       +  "0000"
//                                       +  "0000000000"
//                                       +  "0000000000"
//                                       +  "0000000000"
//                                       +  "0000000000"
//                                        + String.format("%-20s","")
//                                       +  String.format("%-13s","")
//                                       +  String.format("%-1s","")
//                                       +  "00000"
//                                       +  String.format("%-100s","")
//                                       +  "00000000"
//                                       +  "00000000"
//                                       +  "0000000000";
//
//                            G_RowCnt =  G_RowCnt + 1;
//                     }
//                       if (listYetaG.size() + 1 > G_RowCnt)  {
//                           
//
//                       	// 주민번호(복호화)
//             				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyBurRgsum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//             		          	
//             				  
//                           G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnName"),"") ,18),20," ")   
//                              +  String.format("%-13s",  rrnDecCrypt);
//
//                              G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnTyhu"),"") );
//                              G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnArea"),"0.00")))),".","");     //소숫점처리
//
//                              G_RecStr = G_RecStr +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAddr"),"") ,98),100," ") ;
//
//                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnStdt"),"") ;
//                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnEddt"),"") ;
//
//                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAmnt"),"0"));  
//                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnDuam"),"0"));   
//                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
//
//
//                               G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("cnclName"),"") ,18),20," ")   
//                              + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRsno"),"") ) ;
//                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclStdt"),"") ;
//                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclEddt"),"")  ;
//
//                              G_RecStr = G_RecStr +  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItro"),"0.00")))),".","") ;     //소숫점처리
//
//                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRdmt"),"0")); 
//                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
//                               mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclPrpl"),"0"));
//                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItrt"),"0"));
//                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
//                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclDuam"),"0"));
//                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//
//
//                             G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("leasName"),"") ,18),20," ")  
//                              + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("leasRsno"),"")  );
//
//                              G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("leasTyhu"),"")   );
//                              G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("leasArea"),"0.00")))),".","")  ;     //소숫점처리
//
//                              G_RecStr = G_RecStr +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("leasAddr"),"") ,98),100," ") ;
//                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasStdt"),"") ;
//                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasEddt"),"")  ;
//
//                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("leasDpst"),"0"));   
//                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//
//                     G_RowCnt =  G_RowCnt + 1;
//                     try {
//                   	  mapYetaG = (Map<String, Object>) iter05.next(); 
//                    	 } catch (NoSuchElementException e) {
//                    		//e.printStackTrace();
//                    	 }     
//              }
//            else
//            {
//                   G_RecStr = G_RecStr + String.format("%-20s","")
//                              + String.format("%-13s","")
//                              + String.format("%-1s","")
//                              +  "00000"
//                              + String.format("%-100s","")
//                              +  "00000000"
//                              +  "00000000"
//                              +  "0000000000"
//                              +  "0000000000"
//                              + String.format("%-20s","")
//                              + String.format("%-13s","")
//                              +  "00000000"
//                              +  "00000000"
//                              +  "0000"
//                              +  "0000000000"
//                              +  "0000000000"
//                              +  "0000000000"
//                              +  "0000000000"
//                               + String.format("%-20s","")
//                              +  String.format("%-13s","")
//                              +  String.format("%-1s","")
//                              +  "00000"
//                              +  String.format("%-100s","")
//                              +  "00000000"
//                              +  "00000000"
//                              +  "0000000000";
//
//                   G_RowCnt =  G_RowCnt + 1;
//            }
//                       if (listYetaG.size() + 1 > G_RowCnt)  {
//                           
//
//                          	// 주민번호(복호화)
//                				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyBurRgsum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//                		          	
//                				  
//                           G_RecStr = G_RecStr +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnName"),"") ,18),20," ")  
//                              +  String.format("%-13s",  rrnDecCrypt);
//
//                              G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnTyhu"),"") );
//                              G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnArea"),"0.00")))),".","");     //소숫점처리
//
//                              G_RecStr = G_RecStr +  PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAddr"),"") ,98),100," ") ;
//
//                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnStdt"),"") ;
//                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnEddt"),"") ;
//
//                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnAmnt"),"0"));  
//                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnrnDuam"),"0"));   
//                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
//
//
//                               G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclName"),"") ,18),20," ")  
//                              + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRsno"),"") ) ;
//                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclStdt"),"") ;
//                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("cnclEddt"),"")  ;
//
//                              G_RecStr = G_RecStr +  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItro"),"0.00")))),".","") ;     //소숫점처리
//
//                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclRdmt"),"0")); 
//                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
//                               mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclPrpl"),"0"));
//                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclItrt"),"0"));
//                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
//                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("cnclDuam"),"0"));
//                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//
//
//                             G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("leasName"),""),18),20," ")  
//                              + String.format("%-13s", MSFSharedUtils.defaultNulls(mapYetaG.get("leasRsno"),"")  );
//
//                              G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("leasTyhu"),"")   );
//                              G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("leasArea"),"0.00")))),".","")  ;     //소숫점처리
//
//                              G_RecStr = G_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaG.get("leasAddr"),""),98),100," ")  ;
//                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasStdt"),"") ;
//                              G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("leasEddt"),"")  ;
//
//                              mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("leasDpst"),"0"));   
//                              G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
//
//                     G_RowCnt =  G_RowCnt + 1;
////                     try {
////                   	  mapYetaG = (Map<String, Object>) iter05.next(); 
////                    	 } catch (NoSuchElementException e) {
////                    		//e.printStackTrace();
////                    	 }     
//              }
//            else
//            {
//                   G_RecStr = G_RecStr + String.format("%-20s","")
//                              + String.format("%-13s","")
//                              + String.format("%-1s","")
//                              +  "00000"
//                              + String.format("%-100s","")
//                              +  "00000000"
//                              +  "00000000"
//                              +  "0000000000"
//                              +  "0000000000"
//                              + String.format("%-20s","")
//                              + String.format("%-13s","")
//                              +  "00000000"
//                              +  "00000000"
//                              +  "0000"
//                              +  "0000000000"
//                              +  "0000000000"
//                              +  "0000000000"
//                              +  "0000000000"
//                               + String.format("%-20s","")
//                              +  String.format("%-13s","")
//                              +  String.format("%-1s","")
//                              +  "00000"
//                              +  String.format("%-100s","")
//                              +  "00000000"
//                              +  "00000000"
//                              +  "0000000000";
//
//                   G_RowCnt =  G_RowCnt + 1;
//            }          
//
//                       G_RecStr = G_RecStr +  String.format("%02d", G_Cnt)
//                                      + String.format("%-284s","");
//
//                           TOT_Record.add(G_RecStr); 
//
//                           G_Cnt = G_Cnt + 1;
//
//                           G_RecStr = "";
//                          
//
//                     }
//                   }
//               }
// 
//               C_Cnt = C_Cnt + 1;  
//
//          } 
//
//         
//	   } catch (Exception ex) {
//		   ex.printStackTrace();
//		   return bmResult;
//      }
      
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
      * @param ye161010VO
      */
  public List<YetaMessageVO> fnYeta3400_Tax_Ye164010_File_Check(HttpServletRequest request,InfcPkgYe161010_2018_VO  ye161010VO,HttpServletResponse response) throws Exception  {
    	
    	 List<YetaMessageVO>  bmResult = new ArrayList<YetaMessageVO>();
    	
    	String DEFIN = "CA";
   // 	String defBUNS_LINS = StringUtils.replace(ye161010VO.getBusiNumb(),"-","") ; //사업자번호
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
//    	 /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
//	    // 1. 암호화 객체 생성
//	     String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//			
//	     /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/   
//    	
//    	try {
//    		// A레코드 - 의료비지급명세서 레코드
//    		List listYetaCA = yeta3400PayrService.fnPayrPSNL_ReTax_CA_Total_Select(ye161010VO);
//
//    		if  (listYetaCA.size() > 0) { 
// 
//    		 	A_Cnt = 1;
//    		
//    			  Iterator<Map<String, Object>> iter = listYetaCA.iterator(); 
//    	      	   
//    	          while ( iter.hasNext() ) { 
//    	            	
//    	            Map<String, Object> mapCAData = (Map<String, Object>) iter.next(); 
//    	            
//    		  //	for (int i = 0 ; i < listYeta1.size() ; i++) {
//    	            
//    	            ye161010VO.setSystemkey(MSFSharedUtils.allowNulls(mapCAData.get("systemkey"))); 
//    	            
//    	            //A레코드 - 의료비지급명세서 레코드  내역 
//    	            List listCAYeta = yeta3400PayrService.fnPayrCA_ReTax_Total_Select(ye161010VO);
//    				
//    	            Iterator<Map<String, Object>> iter01 = listCAYeta.iterator(); 
//     	      	   
//      	            while ( iter01.hasNext() ) { 
//      	            	
//      	            Map<String, Object> mapCAYeta = (Map<String, Object>) iter01.next(); 
//      	            
//    				//for (int j = 0 ; j < listYeta2.size() ; j++) {
//    				//	infcPkgYeta3140Vo = (InfcPkgYeta3140VO)listYeta2.get(j);
//    					
//	    				A_RecStr = "";
//						A_RecStr = "A" + "26" + ye161010VO.getTaxaCode(); // 3 세무서 코드 
//						A_RecStr = A_RecStr + String.format("%06d", A_Cnt); // 4 순번
//						A_RecStr = A_RecStr + StringUtils.replace(ye161010VO.getEdacPrdt(),"-","") ; // 5 제출년월일 
//						A_RecStr = A_RecStr + defBUNS_LINS; // 6 사업자 등록번호
//						A_RecStr = A_RecStr + String.format("%-20s", ye161010VO.getHomeTxid()); // 7 홈텍스 ID
//						A_RecStr = A_RecStr + String.format("%-4s", ye161010VO.getTaxaPrcd()); // 8 세무프로그램 코드 
//						A_RecStr = A_RecStr + defBUNS_LINS; // 9 사업자 등록번호
//						A_RecStr = A_RecStr + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(ye161010VO.getJuriName() ,38),40," ") ; // 10 상호
//
//						/* 
//						10번까지는 화면에서 받아온 vo (ye161010VO) 이용
//						이후는 select 결과 vo (infcPkgYeta3140Vo) 이용*/
//
//						// 주민번호(복호화)
//						 String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapCAData.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//						    		          	
//						
//						A_RecStr = A_RecStr +    String.format("%-13s",rrnDecCrypt );     // 11 소득자 주민번호 
//						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAData.get("frnrYeno"),"1")); // 12 내,외국인 코드
//						A_RecStr = A_RecStr + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapCAData.get("kornName"),""),28),30 ," "); // 13 성명
//						
//						A_RecStr = A_RecStr + String.format("%-10s", StringUtils.replace(MSFSharedUtils.defaultNulls(mapCAYeta.get("vendNumb"),""),"-",""));  // 14 지급처 사업자등록번호
//						A_RecStr = A_RecStr + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapCAYeta.get("vendName"),"") ,38),40," "); // 15 지급처 상호
//						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.allowNulls(mapCAYeta.get("mediCfcd")));// 16 의료증빙 코드
//								
//						mTempData01 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapCAYeta.get("cashUect"),"0"));  
//						A_RecStr = A_RecStr + String.format("%05d", mTempData01); //건수
//						//A_RecStr = A_RecStr + String.format("%05d", infcPkgYeta3140Vo.getMediCfcd()); // 17 건수
//						
//						mTempData01 = Long.parseLong(MSFSharedUtils.defaultNulls(mapCAYeta.get("cashUeam"),"0"));   
//						A_RecStr = A_RecStr + String.format("%011d", mTempData01); //금액
//						//A_RecStr = A_RecStr + String.format("%011d", infcPkgYeta3140Vo.getCashUeam()); // 18 금액
//						
//						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAYeta.get("ctifTrea"),""));   // 19 난임시술비 해당 여부
//						
//						// 주민번호(복호화)
//						 rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapCAYeta.get("rsnoNumb"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//						   
//						A_RecStr = A_RecStr + String.format("%-13s",rrnDecCrypt ); // 20 주민번호 번호						
//						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAYeta.get("frnrCode"),"1")); // 21 내,외국인 코드
//						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAYeta.get("psclHpyn"),"2")); // 22 본인 등 해당여부
//						A_RecStr = A_RecStr + "1"; // todo 내용 처리 23 제출대상기간 코드
//						A_RecStr = A_RecStr + String.format("%19s", "");  ; // 24 공란
//						
//					 					
//						TOT_Record.add(A_RecStr);
//						
////					     String source = MSFSharedUtils.defaultNulls(mapCAYeta.get("vendName"),"");
////						
////						CharBuffer cbuffer = CharBuffer.wrap((new String(source.getBytes("EUC-KR"), "ksc5601")).toCharArray());
////						Charset utf8charset = Charset.forName("UTF-8");
////						ByteBuffer bbuffer = utf8charset.encode(cbuffer);
////					 
////					    System.out.println("vvvv[" + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(bbuffer.toString() ,38),40," ") + "]");
////						
////						CharBuffer cbuffer1 = CharBuffer.wrap((new String(source.getBytes(), "EUC-KR")).toCharArray());
////						Charset utf8charset1 = Charset.forName("ksc5601");
////						ByteBuffer bbuffer1 = utf8charset1.encode(cbuffer1);
////					 
////					    System.out.println("aaaaa[" + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(bbuffer1.toString() ,38),40," ") + "]");
////						
////					    String hex_utf8 =  encode(source, "UTF-8");
////					    System.out.println(hex_utf8);        
////					    System.out.println( decode(hex_utf8, "UTF-8").getBytes().length);
////					             
////					    String hex_euckr =  encode(source, "EUC-KR");
////					    System.out.println(hex_euckr);
////					    System.out.println( decode(hex_euckr, "EUC-KR").getBytes().length);
////					    System.out.println("ccccc[" + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(decode(hex_euckr, "EUC-KR") ,38),40," ") + "]");
////					    System.out.println( changeCharset(source, "UTF-8"));
////					    System.out.println("aaaaa[" + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(changeCharset(source, "UTF-8") ,38),40," ") + "]");
////						        
////					    System.out.println( changeCharset(source, "EUC-KR"));
////					    System.out.println("vvvvc[" + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(changeCharset(source, "EUC-KR") ,38),40," ") + "]");
//						
//					    
//						A_Cnt = A_Cnt + 1;
//	    				}
//    			}
//    		}
//    		else {
//    			throw new Exception("의료비 A레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.");  
//    			//showMessage('의료비 A레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.');
//    		} 
// 	    	 
// 	   } catch (Exception ex) {
//		   ex.printStackTrace();
//		   return bmResult;
// 
// 	 
//      }
    	
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
  * @param ye161010VO
  * @param response
  * @return
  * @throws Exception
  */
 public List<YetaMessageVO> fnYeta3400_Tax_Ye165010_File_Check(HttpServletRequest request,InfcPkgYe161010_2018_VO  ye161010VO,HttpServletResponse response) throws Exception { 
  
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
 	 
 
// 	//{기부금지급명세서} 
// 	  
// 	     /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
//	    // 1. 암호화 객체 생성
//	     String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//			
//	     /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/   
//
//	     
//
// 	        DEFIN = "H"; //기부금 
//
// 	        defBUNS_LINS = StringUtils.replace(ye161010VO.getBusiNumb(),"-","");  //사업자번호
// 	        strTempDataA = "";
// 	        strTempDataB = "";
// 	        strTempDataC = "";
// 	        strTempDataD = "";
// 	        mTempDataA = 0L;
// 	        mTempDataB = 0L;
// 	        mTempDataC = 0L;
// 	        mTempDataD = 0L;
//
// 	        A_Record = "";
//
//// 	        strTempDataA = "A" + "27";
////
//// 	        strTempDataA = strTempDataA + ye161010VO.getTaxaCode();   //edTAXO_FFIE.Text ;   //세무서코드 
//// 	                       mTempDataA    =  Long.parseLong(StringUtils.replace(ye161010VO.getEdacPrdt(),"-",""));//StrToInt(StringReplace(edINCO_OUDT.Text,'-','',[rfReplaceALL]));  //제출년월일 
//// 	        strTempDataA = strTempDataA  +  String.format("%08d", mTempDataA);  //FormatFloat('00000000', mTempDataA) ;   //제출년월일
//// 	                       mTempDataA    =  Long.parseLong( ye161010VO.getIncmGbcd() );   //StrToInt(edEXPT_GBUN.Text);
//// 	        strTempDataA = strTempDataA  +  String.format("%01d", mTempDataA);  //FormatFloat('0', mTempDataA);   //제출자구분
////
//// 	        strTempDataA = strTempDataA  + String.format("%-6s", MSFSharedUtils.defaultNulls(ye161010VO.getTaxaDnum(),""));   //Format('%-6s', [edTXOF_NUMB.Text]) ; //세무대리인번호(7)
//// 	        strTempDataA = strTempDataA  + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(ye161010VO.getHomeTxid(),18),20," "); // String.format("%-20s", ye161010VO.getHomeTxid()); //Format('%-20s', [edHOME_TXID.Text]) ;  //홈텍스아이디 
//// 	        strTempDataA = strTempDataA  + String.format("%-4s", ye161010VO.getTaxaPrcd()) ;//Format('%-4s', [edTAXP_CODE.Text])  ; //세무프로그램코드
//// 	        strTempDataA = strTempDataA  + String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-","")) ; //Format('%-10s', [StringReplace(edBUNS_LINS.Text,'-','',[rfReplaceALL])]) ; //사업자등록번호
//// 	        strTempDataA = strTempDataA  +  PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(ye161010VO.getJuriName(),38),40," "); //String.format("%-40s", ye161010VO.getJuriName()); //  Format('%-40s', [edPROF_RSNM.Text])   ; //법인명
//// 	        strTempDataA = strTempDataA  + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(ye161010VO.getCharDept(),28),30," "); //String.format("%-30s", ye161010VO.getCharDept());  //Format('%-30s', [edSELF_DEPT.Text]) ;  //담당자부서
//// 	        strTempDataA = strTempDataA  + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(ye161010VO.getCharName(),28),30," "); 
//// 	        	//	String.format("%-30s", ye161010VO.getCharName());  //Format('%-30s', [edSELF_NAME.Text])   ; //담당자성명
//// 	        strTempDataA = strTempDataA  + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(ye161010VO.getCharTele(),15),15," ")  ;  //Format('%-15s', [edSELF_TELE.Text]) ;   //담당자전화번호
//// 	        mTempDataA = 1L;
//// 	        strTempDataA = strTempDataA  + String.format("%05d", mTempDataA);  //FormatFloat('00000',mTempDataA);  //신고자수
//// 	        strTempDataA = strTempDataA  + "101" ;   //사용한글코드
//// 	        strTempDataA = strTempDataA  + String.format("%12s", "");  //Format('%2s', ['']);  //공란
//// 
//// 	        TOT_Record.add(strTempDataA);
//
// 	        B_Cnt = 1;
// 	       
// 	    try {
// 	       
// 	    	//B레코드 - 원천징수의무자별 집계레코드 
// 	       Map mapHb = yeta3400PayrService.fnPayrHB_ReTax_Total_Select(ye161010VO);
// 	        
// 	      if (MSFSharedUtils.paramNull(mapHb)) { 
// 	      	YetaMessageVO yetaMessVo = new YetaMessageVO();
// 	         
// 	      	yetaMessVo.setDispWindow("YETA1400");
// 	      	yetaMessVo.setVeriRec("B레코드");
// 	      	yetaMessVo.setVeriRecCtnt("원천징수의무자별집계레코드");
// 	      	yetaMessVo.setVeriTgtName("집계");
// 	      	yetaMessVo.setVeriError("B레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다.");
// 	      	yetaMessVo.setVeriModCtnt("세액계산  작업 후 다시 생성 하십시요.");
// 	      	
// 	      	bmResult.add(yetaMessVo);
// 	      }
//
// 	       if (MSFSharedUtils.paramNull(StringUtils.replace(ye161010VO.getJuriNumb(),"-","")) || StringUtils.replace(ye161010VO.getJuriNumb(),"-","").equals("null")) {
//              
//              RSNOSTR = StringUtils.replace(ye161010VO.getResuNumb(),"-","");    //사업자주민번호 
//           }
//           else
//           {
//              RSNOSTR =  StringUtils.replace(ye161010VO.getJuriNumb(),"-","");   //법인번호
//           } 
//            
// 	      
// 	      //  mTempDataB = 0L;
// 	       
//// 	         strTempDataB   = "B" + "27";   //레코드 구분 /자료구분 
//// 	         strTempDataB   =  strTempDataB + ye161010VO.getTaxaCode();    //세무서코드 
//// 	         strTempDataB   = strTempDataB  + String.format("%06d", B_Cnt);   //일련번호 
////	         strTempDataB  = strTempDataB +  String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-",""));  //사업자등록번호 10
////	         strTempDataB  = strTempDataB +  PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(ye161010VO.getJuriName(),38),40," ");   //상호(40)
//	   
//	         mTempDataB   =  Long.parseLong( MSFSharedUtils.defaultNulls(mapHb.get("ctrbCnt"),"0"));    //기부금조정명세레코드수(9[7])
//	         
//	         mTempDataB =    Long.parseLong( MSFSharedUtils.defaultNulls(mapHb.get("yeta3180Cnt"),"0"));  //해당연도 기부명세레코드    
//	          
//	         mTempDataB =   Long.parseLong( MSFSharedUtils.defaultNulls(mapHb.get("ctrbAmnt"),"0"));   //기부금액총게    
//	         
//	         mTempDataB =  Long.parseLong( MSFSharedUtils.defaultNulls(mapHb.get("detrAmnt"),"0"));   //공제대상금액 총계 
//	              
//	        // strTempDataB = strTempDataB + "1" ;   //todo 제출대상기간코드
//	        // strTempDataB = strTempDataB + String.format("%87s", "");     //공란
// 
// 
//	         C_Cnt =  0; 
// 	          
// 	         //C 레코드 - 기부금 조정명세 레코드  
// 	          List listTotData01 = yeta3400PayrService.fnPayrPSNL_ReTax_Total_Select(ye161010VO); 
//
// 	          if (listTotData01.size() <= 0) { 
// 	        	  
// 	        	YetaMessageVO yetaMessVo = new YetaMessageVO();
// 	 	         
// 	 	      	yetaMessVo.setDispWindow("YETA1400");
// 	 	      	yetaMessVo.setVeriRec("C레코드");
// 	 	      	yetaMessVo.setVeriRecCtnt("기부금조정명세레코드");
// 	 	      	yetaMessVo.setVeriTgtName("대상자");
// 	 	      	yetaMessVo.setVeriError("C레코드 생성을 위한 정산대상자가 생성되지 않은것 같습니다.");
// 	 	      	yetaMessVo.setVeriModCtnt("세액계산  작업 후 다시 생성 하십시요."); 
// 
// 			    bmResult.add(yetaMessVo);
// 			 
// 	          } 
// 	          
// 	          Iterator<Map<String, Object>> iter = listTotData01.iterator(); 
//      	   
//	          while ( iter.hasNext() ) { 
//	            	
//	            Map<String, Object> mapTotData01 = (Map<String, Object>) iter.next();  
//	          
//	            ye161010VO.setSystemkey(MSFSharedUtils.allowNulls(mapTotData01.get("systemkey")));
// 	              //SYSTEMKEY 가지고 데이타 가져오기 
//	            //C 레코드 - 기부금 조정명세 레코드  YETA3170
//	            List listHCData = yeta3400PayrService.fnPayrHC_ReTax_Total_Select(ye161010VO);  
//	             
//	            
//	            if (listHCData.size() <= 0) { 
//	            		YetaMessageVO yetaMessVo = new YetaMessageVO();
//	    	 	         
//	     	 	      	yetaMessVo.setDispWindow("YETA1400");
//	     	 	      	yetaMessVo.setVeriRec("C레코드");
//	     	 	      	yetaMessVo.setVeriRecCtnt("기부금조정명세레코드");
//	     	 	      	yetaMessVo.setVeriTgtName(MSFSharedUtils.allowNulls(mapTotData01.get("kornName")));
//	     	 	      	yetaMessVo.setVeriError("C레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다.");
//	     	 	      	yetaMessVo.setVeriModCtnt("세액계산  작업 후 다시 생성 하십시요."); 
//	     
//	     			    bmResult.add(yetaMessVo);
//	            	 
//	             }
// 	              
//
// 	               C_rowCnt = 1;
// 	             
// 	              if (listHCData.size() > 0) { 
// 	                  C_Cnt = C_Cnt + 1;
// 	              }
// 	               
// 	              Iterator<Map<String, Object>> iter01 = listHCData.iterator(); 
// 	        	   
// 		          while ( iter01.hasNext() ) { 
// 		            	
// 		            Map<String, Object> mapHCData = (Map<String, Object>) iter01.next(); 
// 		             
//
// 		               // 주민번호(복호화)
// 		               String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapTotData01.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
// 		            		          	 
// 	                   // strTempDataC = "";
// 	                   // mTempDataC  = 0L;
//
// 	                   // strTempDataC =  "C" + "27" ;
// 	                  //  strTempDataC = strTempDataC + ye161010VO.getTaxaCode(); //세무서코드 
//                      //  mTempDataC = Long.parseLong(String.valueOf(C_Cnt));
//                      //  strTempDataC = strTempDataC +   String.format("%06d", mTempDataC);    //소득자일련번호 
//                      //  strTempDataC = strTempDataC  +  String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-","")); //사업자등록번호
// 		               
//                         //소득자주민등록번호
//                        if (!rrno_check(rrnDecCrypt)) {
//                        	
//                        	YetaMessageVO yetaMessVo = new YetaMessageVO();
//                        	
//                        	yetaMessVo.setDispWindow("YETA1400");
//    	     	 	      	yetaMessVo.setVeriRec("C레코드");
//    	     	 	      	yetaMessVo.setVeriRecCtnt("기부금조정명세레코드");
//    	     	 	        yetaMessVo.setVeriTgtName(MSFSharedUtils.allowNulls(mapTotData01.get("kornName")));
//    	     	 	      	yetaMessVo.setVeriError("소득자 주민등록번호 오류");
//    	     	 	      	yetaMessVo.setVeriModCtnt("소득자 본인 주민번호 확인 !"); 
//    	     	 	        //세액감면및세액공제1->기부금->이월기부금
//    	     			    bmResult.add(yetaMessVo);
//                        } 
//                        
//                        
//                        
//                        mTempDataC =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("frnrYeno"),"1"));   //oraQrySelect01.FieldByName('FRNR_YENO').AsFloat;    
//                      
//                         if ((1 != mTempDataC) && (9 != mTempDataC)) {
//                        	
//                        	YetaMessageVO yetaMessVo = new YetaMessageVO();
//                        	
//                        	yetaMessVo.setDispWindow("YETA1400");
//    	     	 	      	yetaMessVo.setVeriRec("C레코드");
//    	     	 	      	yetaMessVo.setVeriRecCtnt("기부금조정명세레코드");
//    	     	 	        yetaMessVo.setVeriTgtName(MSFSharedUtils.allowNulls(mapTotData01.get("kornName")));
//    	     	 	      	yetaMessVo.setVeriError("내외국인구분코드 오류 [" + MSFSharedUtils.defaultNulls(mapHCData.get("frnrYeno"),"값없음") + "]" );
//    	     	 	      	yetaMessVo.setVeriModCtnt("인적공제 탭 소득자 본인 내외국인 확인 !"); 
//    	     	 	        //세액감면및세액공제1->기부금->이월기부금
//    	     			    bmResult.add(yetaMessVo);
//                        }  
//
//                        
//                       // strTempDataC = strTempDataC  +   PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapTotData01.get("kornName"),""),28),30," "); 
//                        		//String.format("%-30s",  MSFSharedUtils.defaultNulls(mapHCData.get("kornName"),""));  //성명
//                        //strTempDataC = strTempDataC  +  String.format("%-2s",  MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""));    //유형코드
//                     
//                         if (!"10".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))
//                        	 && !"20".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	
//                        	 && !"40".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	
//                        	 && !"41".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	
//                        	 && !"42".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	) {
//                        	 
//                        	 YetaMessageVO yetaMessVo = new YetaMessageVO();
//                         	
//                         	 yetaMessVo.setDispWindow("YETA1400");
//     	     	 	      	 yetaMessVo.setVeriRec("C레코드");
//     	     	 	      	 yetaMessVo.setVeriRecCtnt("기부금조정명세레코드");
//     	     	 	         yetaMessVo.setVeriTgtName(MSFSharedUtils.allowNulls(mapTotData01.get("kornName")));
//     	     	 	      	 yetaMessVo.setVeriError("유형코드 오류 [" + MSFSharedUtils.defaultNulls(mapHCData.get("frnrYeno"),"값없음") + "]" );
//     	     	 	      	 yetaMessVo.setVeriModCtnt("세액감면및세액공제1->기부금->이월기부금등록에 기부금조정명세확인 !<br>[10,20,40,41,42]가 아닌 유형코드 존재 "); 
//     	     	 	         //
//     	     			     bmResult.add(yetaMessVo);
//     	     			    
//                         }
//                        
//                        mTempDataC =  Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbYrmn"),"0")); 
//                        
//                        //strTempDataC = strTempDataC  +   String.format("%04d", mTempDataC);    //기부연도
//                        mTempDataC =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbAmnt"),"0"));   
//                        strTempDataC = strTempDataC  +  String.format("%013d", mTempDataC);   //기부금액 - 13
//                        mTempDataC =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("bfyrDeam"),"0"));   
//                        strTempDataC = strTempDataC  +  String.format("%013d", mTempDataC);  //전년까지공제된금액 -13
//                        mTempDataC =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("detrAmnt"),"0"));   
//                        strTempDataC = strTempDataC  + String.format("%013d", mTempDataC);  //공제대상금액  -13
//                        
//                        strTempDataC = strTempDataC  + "0000000000000" ;   //해당년도공제금액 필요경비 
//                        
//                        mTempDataC =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("dyyrDeam"),"0"));  
//                        strTempDataC = strTempDataC  + String.format("%013d", mTempDataC);//해당년도공제금액세액금액 -13                        
//                        mTempDataC =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("dyyrOtam"),"0"));   
//                        strTempDataC = strTempDataC  + String.format("%013d", mTempDataC); //해당년도공제받지못한금액소멸금액 -13
//                        mTempDataC =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("ayyrNtam"),"0"));   
//                        strTempDataC = strTempDataC  + String.format("%013d", mTempDataC); //해당년도에 공제받지못한금액_이월금액 -3
//                        strTempDataC = strTempDataC  + String.format("%05d", C_rowCnt);       //기부금조정명세일련번호 -5
//                        strTempDataC = strTempDataC  + String.format("%22s", "");      //공란 -25
// 
// 	                   TOT_Record.add(strTempDataC);
// 	                   C_rowCnt = C_rowCnt + 1;
// 
// 		          }
//
// 	               D_Cnt = 1;
// 	             
// 	              //D레코드 - 해당연도 기부명세 레코드  
// 	              List listHDData = yeta3400PayrService.fnPayrHD_ReTax_Total_Select(ye161010VO); 
// 	               
// 	             if (listHCData.size() > 0) { 
//	              
//	              Iterator<Map<String, Object>> iter02 = listHDData.iterator(); 
//	        	   
//		          while ( iter02.hasNext() ) { 
//		            	
//		            Map<String, Object> mapHDData = (Map<String, Object>) iter02.next();
// 
// 	                     strTempDataD = "";
// 	                     mTempDataD  = 0L;
//
// 	                    // 주민번호(복호화)
// 	 		               String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapTotData01.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
// 	 		            		   
// 	                      strTempDataD =  "D" + "27";
// 	                      strTempDataD = strTempDataD + ye161010VO.getTaxaCode();  //세무서코드 
//                          strTempDataD = strTempDataD + String.format("%06d", C_Cnt);     //소득자일련번호 
//                          strTempDataD = strTempDataD + String.format("%-10s", StringUtils.replace(ye161010VO.getBusiNumb(),"-",""));   //사업자등록번호 
//                          
//                          strTempDataD = strTempDataD +  String.format("%-13s", rrnDecCrypt);      //소득자주민등록번호
//                          strTempDataD = strTempDataD +  String.format("%-2s",  MSFSharedUtils.defaultNulls(mapHDData.get("ctrbTycd"),""));     //유형코드
//                          
//                          strTempDataD = strTempDataD +  String.format("%-13s", StringUtils.replace(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbBsnu"),""),"-",""));    //사업자등록번호
// 
//                          strTempDataD = strTempDataD + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbName"),""),28),30," ");
//                          //String.format("%-30s", StringUtils.left(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbName"),""),30));    //상호 - 30
//                                           
//                          strTempDataD = strTempDataD +  String.format("%-1s",  MSFSharedUtils.defaultNulls(mapHDData.get("crtbCncd"),""));  //관계코드
//                          strTempDataD = strTempDataD +  String.format("%-1s",  MSFSharedUtils.defaultNulls(mapHDData.get("frnrCode"),""));     //내외국인구분코드
//                          strTempDataD = strTempDataD +  PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapHDData.get("cbtgName"),""),18),20," "); 
//                          //String.format("%-20s", MSFSharedUtils.defaultNulls(mapHDData.get("cbtgName"),""));   //성명 - 20
//                          // 주민번호(복호화)
//	 		                 rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapHDData.get("rsnoNumb"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//	 		            		   
//                          strTempDataD = strTempDataD +  String.format("%-13s", rrnDecCrypt);    //기부자주민등록번호 
//                          mTempDataD =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbNcnt"),"1"));   
//                          strTempDataD = strTempDataD +  String.format("%05d", mTempDataD);   //건수 - 5
//                       
//                          mTempDataD = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbAmnt"),"0"));   
//                          strTempDataD = strTempDataD +  String.format("%013d", mTempDataD);     //기부금액 - 13
//
//                          //2016년 추가 -----
//                          mTempDataD = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ctrbTgam"),"0"));   
//                          strTempDataD = strTempDataD +  String.format("%013d", mTempDataD);     //공제대상기부금액
//                          mTempDataD = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ctjaCham"),"0"));   
//                          strTempDataD = strTempDataD +  String.format("%013d", mTempDataD);     //기부장려신청금액
// 
//                          
//                          strTempDataD = strTempDataD + String.format("%05d", D_Cnt);    //일련번호 
//                          
//                          strTempDataD = strTempDataD +  String.format("%26s", "");    //공란 42
// 
// 	                      TOT_Record.add(strTempDataD);
// 
// 	                    D_Cnt = D_Cnt + 1;
//		           }
// 	             } 
//
//	         } 
// 
//
//	   } catch (Exception ex) {
//		   ex.printStackTrace(); 
//		   return bmResult; 
// 	 
//      }  
 	    
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
private boolean rrno_check(String rrno) { 
    boolean rrnoChk = true ; 
    
     if (SmrmfUtils.isNumeric(rrno)) {   
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
    } else { 
    	rrnoChk = false;
    }
     
   return rrnoChk;	
}

private String Han1(String s1, int len) { 
    String r1 = "", r2 = ""; 
    r1 = MSFSharedUtils.defaultNulls(s1,"");
	return Han2(r1, len);
/*    int len1 = r1.getBytes().length;
    
    r1 =r1.format("%s", s1);
    for(int i=0;i<len - len1;i++){
    	r2 += " ";
    }
    r1 += r2;
*/    
} 
 
private String Han1(Object s1, int len) { 
    String r1 = "", r2 = ""; 
    r1 = MSFSharedUtils.defaultNulls(s1,"");
	return Han2(r1, len);
/*
    int len1 = r1.getBytes().length;
    
    r1 =r1.format("%s", r1);
    for(int i=0;i<len - len1;i++){
    	r2 += " ";
    }
    r1 += r2;
*/    
} 

private String Han2(String s1, int len1) { 
    String r1 = "", r2 = ""; 
	if("".equals(s1)){
		for(int i=0;i<len1;i++){
			s1 += " ";
		}
		return s1;
	}

// 바이트 체크 (영문 1, 한글 2, 특문 1)
	int en = 0;
	int ko = 0;
	int etc = 0;

	char[] txtChar = s1.toCharArray();
	for (int j = 0; j < txtChar.length; j++) {
		//if (txtChar[j] >= 'A' && txtChar[j] <= 'z') {
		if (txtChar[j] >= ' ' && txtChar[j] <= '~') {
			en++;
		//} else if (txtChar[j] >= '\uAC00' && txtChar[j] <= '\uD7A3') {
		//	ko++;
		//	ko++;
		} else {
			//etc++;
			ko++;
			ko++;
		}
	}

	int txtByte = en + ko + etc;

    r1 =r1.format("%s", s1);
    for(int i=0;i<len1 - txtByte;i++){
    	r2 += " ";
    }
    r1 += r2;
   return r1;	
} 

}
