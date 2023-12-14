package com.app.smrmf.pkg.yeta.yeta2022.file;

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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161005_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161020_2022_VO;
import com.app.smrmf.pkg.yeta.yeta2022.file.service.Yeta7400PayrService;

import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class Yeta7400PkgFileController {

    private static final Logger logger = LoggerFactory.getLogger(Yeta7400PkgFileController.class);  
    
    @Resource(name = "Yeta7400PayrService")
    private Yeta7400PayrService yeta7400PayrService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService; 
    
    
    public Yeta7400PkgFileController() {
    	
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
	public int fnYeta7400_Tax_Ye161010_File_Create(HttpServletRequest request,InfcPkgYe161010_2022_VO  ye161010VO,HttpServletResponse response) throws Exception  {

		if  (yeta7400PayrService== null) {
			WebApplicationContext wac = WebApplicationContextUtils.
			getRequiredWebApplicationContext( request.getSession().getServletContext());

			yeta7400PayrService = (Yeta7400PayrService) wac.getBean("Yeta7400PayrService");
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
		InfcPkgYe161005_2022_VO    infcPkgYe161005Vo	 = new InfcPkgYe161005_2022_VO();	//A_원천세신고기본
		BeanUtils.copyProperties(infcPkgYe161005Vo, ye161010VO);

		infcPkgYe161005Vo  = yeta7400PayrService.selectYe161005(ye161010VO);

		//인적기본데이터를 가지고온다. 조회처리 루틴 추가 
		InfcPkgYe161020_2022_VO    infcPkgYe161020Vo	 = new InfcPkgYe161020_2022_VO();	//A_인적소득공제기본
		BeanUtils.copyProperties(infcPkgYe161020Vo, ye161010VO);
		//{근로소득지급명세서}
		/********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		/********************************************************암호화 처리 를 위해 반드시 해야 함................................*/   

		DEFIN = "C"; //근로소득
       
        defBUNS_LINS = StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-","");   //사업자번호
      
		A_Record = ("A" + "20" + infcPkgYe161005Vo.getTxOffcCd() //레코드구분 : A, 1BYTE + 자료구븐 : 20, 2BYTE + 세무서코드 : 3BYTE = 6BYTE
					+ String.format("%08d", Long.parseLong(StringUtils.replace(ye161010VO.getEdacPrdt(),"-",""))) //제출년월일 : 8BYYTE
                    + String.format("%01d", Long.parseLong( infcPkgYe161005Vo.getPentrSeptCd() )) //제출자구분 : 1BYTE
                    + String.format("%-6s", MSFSharedUtils.defaultNulls(infcPkgYe161005Vo.getTxDeptyMangeNum(),"")) //세무대리인관리번호 : 6BYTE
                    + Han1(infcPkgYe161005Vo.getHmtxId(), 20) //홈텍스 ID : 20BYTE  
                    + String.format("%-4s", infcPkgYe161005Vo.getTxPgmCd()) //세무프로그램코드 : 4BYTE
                    + String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-","")) //사업자등록번호 : 10BYTE
                    + Han1(infcPkgYe161005Vo.getCorpFmnmNm(), 60) //법인명 : 60BYTE  
                    + Han1(infcPkgYe161005Vo.getPernChrgDeptNm(), 30) //담당자부서 : 30BYTE 
                    + Han1(infcPkgYe161005Vo.getPernChrgNm(), 30)  //담당자성명 : 30BYTE 
                    + String.format("%-15s", infcPkgYe161005Vo.getPernChrgPhnNum()) //담당자전화번호 : 15BYTE 
                    + "2022" //귀속년도 : 4BYTE
                    + String.format("%05d", 1) + "101" //신고의무자수 : 5BYTE + 사용한글코드 : 3BYTE
                    + String.format("%1808s", "")); //공란 : 1808BYTE

		TOT_Record.add(A_Record);
		
		B_Cnt = 1;
		mTempData01 = 0L;
        
		try {
			Map mapYetaB = yeta7400PayrService.fnPayrB_ReTax_Total_Select(infcPkgYe161020Vo); 

			if (mapYetaB.isEmpty()) { 
//           showMessage('B레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.');
//           Result = -1;
//           Exit;
			}
    	  
			if (!"2".equals(MSFSharedUtils.defaultNulls(infcPkgYe161005Vo.getPentrSeptCd(),""))) { //제출자구분코드 

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
 

			B_RecStr = "B" + "20" + infcPkgYe161005Vo.getTxOffcCd() +  String.format("%06d", B_Cnt)  //레코드구분 : B, 1BYTE + 자료구분 : 20, 2BYTE + 세무서코드 : 3BYTE + 일련번호 : 6BYTE = 12BYTE
						+ String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-","")) //사업자등록번호 : 10BYTE
					    + Han1(infcPkgYe161005Vo.getCorpFmnmNm(), 60) //법인명 : 60BYTE
                        + Han1(infcPkgYe161005Vo.getReprName(), 30)  //대표자성명 : 30BYTE
                        + String.format("%-13s", StringUtils.replace(RSNOSTR,"-","")) + "2022"; //주민번호 : 13BYTE + 귀속년도 : 4BYTE = 17BYTE
			
			mTempData01 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("psnlJuCnt"),"0"));
			B_RecStr =  B_RecStr + String.format("%07d", mTempData01);    //주근무지 레코드 수 : 7BYTE
			
			mTempData01 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("psnlJungCnt"),"0"));  
			B_RecStr =  B_RecStr + String.format("%07d", mTempData01);     //종전근무지 레코드 수 : 7BYTE

			mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("yeta0c63"),"0")); 
			B_RecStr =  B_RecStr + String.format("%014d", mTempData01);   //총급여 총계_현전 : 14BYTE
			
			mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("yetaC159"),"0"));  
			B_RecStr =  B_RecStr   +  String.format("%013d", mTempData01);    //결정세액 소득세 : 13BYTE
			
			mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("yetaC160"),"0"));    
			B_RecStr =  B_RecStr  + String.format("%013d", mTempData01);   //결정세액 지방소득세 : 13BYTE
			
			mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("yetaC161"),"0"));  
			B_RecStr =  B_RecStr   + String.format("%013d", mTempData01);    //결정세액 농특세 : 13BYTE
			
			mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("yetaSumAll"),"0")); 
			B_RecStr =  B_RecStr  + String.format("%013d", mTempData01);    //결정세액 총계 : 13BYTE
			B_RecStr =  B_RecStr  + "1"; //체출기간 : 1BYTE
			B_RecStr =  B_RecStr +  String.format("%1800s", "");     //공란 : 1800BYTE

			TOT_Record.add(B_RecStr);

			C_Cnt =  1;
           
            //c레코드 주현근무처 레코드 fnPayrC_ReTax_Total_Select
			List listYetaC = yeta7400PayrService.fnPayrC_ReTax_Total_Select(infcPkgYe161020Vo);
            
			if (listYetaC.size() <= 0) {  
				throw new Exception("C레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.");  
			} 

			Iterator<Map<String, Object>> iter = listYetaC.iterator(); 
			while ( iter.hasNext() ) { 
				Map<String, Object> mapYetaC = (Map<String, Object>) iter.next();  
               
				mTempData02 = 0L;
				C_RecStr = "";
               //  oraQrySelect01.FieldByName('CITY_SEQN').AsString; Format('%.11d', [])
				C_RecStr = "C" ;   //레코드구분 : C, 1BYTE
				C_RecStr = C_RecStr + "20"; //자료구분 : 20, 2BYTE
				C_RecStr = C_RecStr   + infcPkgYe161005Vo.getTxOffcCd(); //세무서코드  : 3BYTE
				C_RecStr = C_RecStr + String.format("%06d", C_Cnt);    //일련번호 : 6BYTE
				C_RecStr = C_RecStr  +  String.format("%-10s", StringUtils.replace(MSFSharedUtils.allowNulls(mapYetaC.get("bsnoEncCntn")),"-",""));  //사업자등록번호 : 10BYTE
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta00c6"),"0"));              
				C_RecStr = C_RecStr  + String.format("%02d",mTempData02);	//종전근무처 수 : 2BYTE
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("rsdtClCd"),"1"));        
				C_RecStr = C_RecStr  + String.format("%01d", mTempData02);	//거주구분코드 : 1BYTE
				C_RecStr = C_RecStr  + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaC.get("redtGbcd"),"")  ); //거주지국코드 : 2BYTE   
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta00c9"),"2")); 
				C_RecStr = C_RecStr  + String.format("%01d", mTempData02) ; //외국인단일세율적용여부 : 1BYTE

				C_RecStr = C_RecStr  + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c9a"),"2")  );    //외국법인소속 파견근로자여부 : 1BYTE

				C_RecStr = C_RecStr  + Han1(mapYetaC.get("fnm"), 30);    //성명 : 30BYTE
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("nnfClCd"),"1")); 
				C_RecStr = C_RecStr  +  String.format("%01d",  mTempData02) ;	//내외국인구분코드 : 1BYTE //총BYTE : 60BYTE
                             
				// 주민번호(복호화)
				String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

				C_RecStr = C_RecStr  + String.format("%-13s",rrnDecCrypt);     //주민등록번호	 : 13BYTE
				C_RecStr = C_RecStr  + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaC.get("rsplNtnInfrCd"),"") ); //국적코드 : 2BYTE
				C_RecStr = C_RecStr  + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("hshrClCd"),"") ); //세대주구분코드 : 1BYTE
				C_RecStr = C_RecStr   + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("hoofStcd"),"")) ; //연말정산구분 : 1BYTE
				C_RecStr = C_RecStr   + "2";	//사업자단위 과세여부 : 1BYTE
				C_RecStr = C_RecStr   + String.format("%-4s", "") + "2";	//종사업장 일련번호 : 4BYTE + 종교관련종사자여부 : 1BYTE = 5BYTE
				C_RecStr = C_RecStr   + String.format("%-10s", StringUtils.replace(MSFSharedUtils.allowNulls(mapYetaC.get("bsnoEncCntn")),"-","")) ; //주현근무처-사업자등록번호 : 10BYTE
				C_RecStr = C_RecStr   + Han1(mapYetaC.get("tnm"),60) ;	//주현근무처-근무처명 : 60BYTE //총BYTE : 153BYTE


				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dtyStrtDt"),"0"));	
				C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);	//근무기간시작연월일 : 8BYTE
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dtyEndDt"),"0"));			
				C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);	//근무기간종료연월일 : 8BYTE
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("reStrtDt"),"0"));		
				C_RecStr = C_RecStr  +  String.format("%08d",  mTempData02) ;	//감면기간시작일자 : 8BYTE
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("reEndDt"),"0"));			
				C_RecStr = C_RecStr  +  String.format("%08d", mTempData02);	//감면기간종료일자 : 8BYTE
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c22"),"0"));			
				C_RecStr = C_RecStr  + String.format("%011d", mTempData02); //급여총액 : 11BYTE
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c23"),"0"));			
				C_RecStr = C_RecStr  + String.format("%011d",  mTempData02); //상여총액 : 11BYTE
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c24"),"0"));		
				C_RecStr = C_RecStr  + String.format("%011d",  mTempData02); //인정상여 : 11BYTE
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c25"),"0"));			
				C_RecStr = C_RecStr  + String.format("%011d",  mTempData02) ; //주식행사이익 : 11BYTE
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c26"),"0"));			
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02); //우리사주조합인출금 : 11BYTE
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c27"),"0"));			
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);	//임원 퇴직소득금액 한도초과액 : 11BYTE

				C_RecStr = C_RecStr   + String.format("%011d", 0);	//직무발명보상금 : 11BYTE

				C_RecStr = C_RecStr   + String.format("%022d", 0);	//공란 : 11BYTE + 공란 : 11BYTE = 22BYTE

				C_RecStr = C_RecStr   +  String.format("%011d", Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c29"),"0"))) ; //계 : 11BYTE //총BYTE : 295BYTE
				
			

				//주현근무처 비과세소득 및 감면소득  
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta_C30G01"),"0"));  
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02); //비과세학자금 : 10BYTE
				
				//2022연말정산_추가 : 해당항목삭제
				//mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta_C31H01"),"0"));	
				//C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02); //무보수  위원수당 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta_C32H05"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02); //경호승선수당 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta_C33H06"),"0"));
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);	//유아초중등 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta_C34H07"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ; //고등교육법 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta_C35H08"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ; //특별법 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC36H09"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ; //연구기관등 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC37H10"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ; //기업부설연구소 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC38H14"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02); //보육교사근무환경개선비 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC39H15"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ; //사립유치원수석교사,교사의인건비 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC40H11"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ; //취재수당 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC41H12"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02)  ; //벽지수당 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC42H13"),"0"));  
				C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;	//재해관련급여 : 10BYTE
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC43H16"),"0"));  
				C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02) ;	//정부공공기관지방이전기관종사자 이주수당 : 10BYTE

				C_RecStr = C_RecStr   + String.format("%010d", 0);	//종교활동비 : 10BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC44I01"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02); //외국정부등근무자 : 10BYTE
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC45K01"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ; //외국주둔군인등 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC46M01"),"0")); 
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ; //국외근로100만원 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC47M02"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ; //국외근로300만원 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC48M03"),"0"));  
				C_RecStr = C_RecStr  +  String.format("%010d",  mTempData02) ; //국외근로 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC49O01"),"0")); 
				C_RecStr = C_RecStr   +  String.format("%010d", mTempData02)  ; //야간근로수당 : 10BYTE
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC50Q01"),"0")); 
				C_RecStr = C_RecStr  +  String.format("%010d", mTempData02) ;	//출산보육수당 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC51R10"),"0")); 
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ; //근로장학금 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC52R11"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02); //직무발명보상금 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC53S01"),"0")); 
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;	//주식매수선택권 : 10BYTE

				C_RecStr = C_RecStr   + String.format("%010d", 0);	//벤처기업 주식매수선택권 : 10BYTE //총BYTE : 555BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC55Y02"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02); //우리사주조합인출금50% : 10BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC56Y03"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02); //우리사주조합인출금75% : 10BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC56aY04"),"0"));  
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02); //우리사주조합인출금100% : 10BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC57Y22"),"0")); 
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02); //전공의수련보조수당 : 10BYTE
				
				C_RecStr = C_RecStr   + String.format("%010d", 0);	//외국인기술자소득세감면50%_T01 : 10BYTE
				
				C_RecStr = C_RecStr   + String.format("%010d", 0);	//외국인기술자소득세감면70%_T02 : 10BYTE

				C_RecStr = C_RecStr   + String.format("%010d", 0); // 성과공유중소기업경영성과급_T30 : 10BYTE
				
				C_RecStr = C_RecStr   + String.format("%010d", 0); // 중소기업핵심인력성과보상기금소득세감면_T40	 : 10BYTE
				
				//2021연말정산_추가
				C_RecStr = C_RecStr   + String.format("%010d", 0); // 중소기업핵심인력성과보상기금소득세감면_T41	 : 10BYTE
				
				//2022연말정산_추가
				C_RecStr = C_RecStr   + String.format("%010d", 0); // 중소기업핵심인력성과보상기금소득세감면_T42	 : 10BYTE
				C_RecStr = C_RecStr   + String.format("%010d", 0); // 중소기업핵심인력성과보상기금소득세감면_T43	 : 10BYTE
				//2020연말정산_추가
				C_RecStr = C_RecStr   + String.format("%010d", 0); //내국인 우수인력 국내복귀 소득세감면 : 10BYTE
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC58aT11"),"0")); 
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02); //중소기업취업자소득세감면50% : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC58bT12"),"0")); 
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02); //중소기업취업자소득세감면70% : 10BYTE

				C_RecStr = C_RecStr   + String.format("%010d", 0);	//중소기업 취업청년 소득세 감면90% : 10BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC59T20"),"0")); 
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02); //조세조약상교직자감면 : 10BYTE
				
				
				//2021연말정산_변경
				C_RecStr = C_RecStr   + String.format("%010d", 0); //공란 : 10BYTE 

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c60"),"0"));    //비과세계
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02); //비과세계 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c61"),"0"));   //감면소득계
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02); //감면소득계 : 10BYTE

				//정산명세 처리 시작    
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c63"),"0"));        
				C_RecStr = C_RecStr   +  String.format("%011d", mTempData02); //총급여 : 11BYTE
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c64"),"0"));   
				C_RecStr = C_RecStr   +  String.format("%010d", mTempData02); //근로소득공제 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c65"),"0"));      
				C_RecStr = C_RecStr   +  String.format("%011d", mTempData02); //근로소득금액 : 11BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c66"),"0"));         
				C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02); //본인공제금액 : 8BYTE
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c67"),"0"));       
				C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02); //배우자공제금액 : 8BYTE
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c68"),"0")); 
				C_RecStr = C_RecStr   + String.format("%02d", mTempData02) ; //부양가족공제인원 : 2BYTE
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c69"),"0"));      
				C_RecStr = C_RecStr   + String.format("%08d",mTempData02)  ; //부양가족공제금액 : 8BYTE
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c70"),"0"));      
				C_RecStr = C_RecStr   + String.format("%02d",mTempData02); //경로우대공제인원 : 2BYTE
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c71"),"0"));   
				C_RecStr = C_RecStr   + String.format("%08d", mTempData02) ; //경로우대공제금액 : 8BYTE
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c72"),"0"));  
				C_RecStr = C_RecStr   + String.format("%02d",mTempData02); //장애인공제인원 : 2BYTE
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c73"),"0"));     
				C_RecStr = C_RecStr   + String.format("%08d", mTempData02); //장애인공제금액 : 8BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c74"),"0"));      
				C_RecStr = C_RecStr   + String.format("%08d", mTempData02); //부녀자공제금액 : 8BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c75"),"0"));           
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //한부모가족공제금액 : 10BYTE //총BYTE : 831BYTE

				//연금보험료공제 
				//2022연말정산_추가 : 국민연금 납입액계 수정필요
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c76y"),"0"));          
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ; //국민연금보험료공제_대상금액 : 10BYTE
				////
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c76"),"0"));        
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ; //국민연금보험료공제_공제금액 : 10BYTE

				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c77"),"0"));    
				C_RecStr = C_RecStr  + String.format("%010d",  mTempData02); //공적연금보험료공제_공무원연금_대상금액 : 10BYTE
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c77"),"0"));      
				C_RecStr = C_RecStr  + String.format("%010d",  mTempData02); //공적연금보험료공제_공무원연금_공제금액 : 10BYTE

				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c78"),"0"));      
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //공적연금보험료공제_군인연금_대상금액 : 10BYTE
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c78"),"0"));    
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //공적연금보험료공제_군인연금_공제금액 : 10BYTE

				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c79"),"0"));  
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ; //공적연금보험료공제_사립학교교직원연금_대상금액 : 10BYTE
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c79"),"0"));   
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ; //공적연금보험료공제_사립학교교직원연금_공제연금 : 10BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c80"),"0"));         
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02); //공적연금보험료공제_별정우체국연금_대상금액 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c80"),"0"));        
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02); //공적연금보험료공제_별정우체국연금_공제금액 : 10BYTE	 

				//특별소득공제 
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c81"),"0"));     
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ; //보험료_건강보험료_대상금액 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c81"),"0"));   
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ; //보험료_건강보험료_공제금액 : 10BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c82"),"0"));  
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02); //보험료_고용보험료_대상금액 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c82"),"0"));    
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02); //보험료_고용보험료_공제금액 : 10BYTE	
				//
				// 주택자금(주택임차차입금,장기주택저당차입금,주택마련저축) 관련공통사항 
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c83"),"0"));              
				C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ; //주택자금_주택임차차입금원리금상환액_대출기관 : 8BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c84"),"0"));                
				C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ; //주택자금_주택임차차입금원리금상환액_거주자 : 8BYTE
	   
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c85"),"0"));    
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02); //11년이전_주택자금_장기주택저당차입금이자상환액_15년미만 : 8BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c86"),"0"));        
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02); //11년이전_주택자금_장기주택저당차입금이자상환액_15년~29년 : 8BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c87"),"0"));      
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02); //11년이전_주택자금_장기주택저당차입금이자상환액_30년이상 : 8BYTE
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c88"),"0"));      
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02); //12년이후_고정금리,비거치식상환대출_15년이상 : 8BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c89"),"0"));   
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02); //12년이후_기타대출_15년이상 : 8BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c90"),"0"));  
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02); //15년이후_고정금리이면서비거치식상환대출_15년이상 : 8BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c91"),"0"));    
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02); //15년이후_고정금리이거나비거치식상환대출_15년이상 : 8BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c92"),"0"));    
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02); //15년이후_그밖의대출_15년이상 : 8BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c93"),"0"));     
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02); //15년이후_고정금리이거나비거치식상환대출_10~15년 : 8BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c94"),"0"));     
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02); //기부금(이월분) : 11BYTE

				C_RecStr = C_RecStr   + String.format("%022d", 0);	//공란 : 11BYTE + 공란 : 11BYTE = 22BYTE

				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c96"),"0")); 
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02); //특별소득공제계 : 11BYTE
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c97"),"0"));      
				C_RecStr = C_RecStr  + String.format("%011d", mTempData02); //차감소득금액 : 11BYTE

				//그 밖의 소득공제  
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c98"),"0"));       
				C_RecStr = C_RecStr   + String.format("%08d", mTempData02); //개인연금저축소득공제 : 8BYTE
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c99"),"0"));      
				C_RecStr = C_RecStr  + String.format("%010d", mTempData02); //소기업소상공인공제부금 : 10BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC100"),"0"));     
				C_RecStr = C_RecStr  + String.format("%010d",  mTempData02) ; //주택마련저축소득공제_청약저축 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC101"),"0"));         
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //주택마련저축소득공제_주택청약종합저축 : 10BYTE
				mTempData02 =Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC102"),"0"));   
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02); //주택마련저축소득공제_근로자주택마련저축 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC103"),"0"));        
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //투자조합출자등소득공제 : 10BYTE //총BYTE : 1172BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC104"),"0"));    
				C_RecStr = C_RecStr   + String.format("%08d", mTempData02) ; //신용카드등소득공제 : 8BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC105"),"0"));        
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02); //우리사주조합출연금 : 10BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC107"),"0"));        
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02); //고용유지중소기업근로자소득공제 : 10BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC109"),"0"));      
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02)  ; //장기집합투자증권저축 : 10BYTE
				
				//2022연말정산_추가 : 청년형장기집합투자증권저축 추가필요
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC109y"),"0"));      
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02)  ; //청년형장기집합투자증권저축 : 10BYTE
				///

				C_RecStr = C_RecStr   + String.format("%010d", 0);	//공란 : 10BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC110"),"0"));      
				C_RecStr = C_RecStr  + String.format("%011d",  mTempData02); //그밖의소득공제계 : 11BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC111"),"0"));       
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02) ; //소득공제종합한도초과액 : 11BYTE


				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC112"),"0"));            
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02) ; //종합소득과세표준 : 11BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC113"),"0"));           
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02) ; //산출세액 : 11BYTE

				//------------------------ 세액감면 ------------------------------ 
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC114"),"0"));       
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ; //소득세법 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC115"),"0"));          
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02)  ; //조특법 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC116"),"0"));     
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02)  ; //조특법30조 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC117"),"0"));   
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ; //조세조약 : 10BYTE

				C_RecStr = C_RecStr   + String.format("%020d", 0);	//공란 : 10BYTE + 공란 : 10BYTE = 20BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC119"),"0"));          
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02); //세액감면계 : 10BYTE //총BYTE : 1344BYTE


				// ------------------------ 세액공제 -------------------------------------------------------
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC120"),"0"));      
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //근로소득세액공제 : 10BYTE

				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC121"),"0"));             
				C_RecStr = C_RecStr   + String.format("%02d",  mTempData02); //자녀세액공제인원 : 2BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC122"),"0"));              
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //자녀세액공제 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC125"),"0"));              
				C_RecStr = C_RecStr   + String.format("%02d", mTempData02) ; //출산입양세액공제인원 :2BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC126"),"0"));            
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ; //출산입양세액공제 : 10BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC127"),"0"));                  
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //연금계좌_과학기술인공제회법에따른퇴직연금_공제대상금액 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC128"),"0"));                  
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //연금계좌_과학기술인공제회법에따른퇴직연금_세액공제액 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC129"),"0"));               
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //연금계좌_근로자퇴직급여보장법에따른퇴직연금_공제대상금액 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC130"),"0"));                
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //연금계좌_근로자퇴직급여보장법에따른퇴직연금_세액공제액 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC131"),"0"));              
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //연금계좌_연금저축_공제대상금액 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC132"),"0"));             
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //연금계좌_연금저축_세액공제금액 : 10BYTE
				
				//2021연말정산_추가
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC13a"),"0"));             
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //ISA계좌만기시추가납입액_공제대상금액 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC13b"),"0"));             
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //ISA계좌만기시추가납입액_세액공제금액 : 10BYTE
				
				//특별세액공제
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC133"),"0"));                
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //특별세액공제_보장성보험료_공제대상금액 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC134"),"0"));              
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //특별세액공제_보장성보험료_세액공제계 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC135"),"0"));              
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //특별세액공제_장애인전용보장성보험료_공제대상금액 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC136"),"0"));                  
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //특별세액공제_장애인전용보장성보험료_세액공제금액 : 10BYTE
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC137"),"0"));                 
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //특별세액공제_의료비_공제대상금액 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC138"),"0")); 
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //특별세액공제_의료비_세액공제금액 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC139"),"0"));                 
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //특별세액공제_교육비_공제대상금액 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC140"),"0"));                 
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //특별세액공제_교육비_세액공제금액 : 10BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC141"),"0"));                
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //특별세액공제_기부금_정치자금_10만원이하_공제대상금액 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC142"),"0"));                  
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //특별세액공제_기부금_정치자금_10만원이하_세액공제금액 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC143"),"0"));                   
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ; //특별세액공제_기부금_정치자금_10만원초과_공제대상금액 : 11BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC144"),"0"));                
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //특별세액공제_기부금_정치자금_10만원초과_세액공제금액 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC145"),"0"));                 
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ; //특별세액공제_기부금_소득세법제34조 제2항 제1호에 따른 기부금_공제대상금액(법정기부금) : 11BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC146"),"0"));   
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //특별세액공제_기부금_소득세법제34조 제2항 제1호에 따른 기부금_세액공제금액(법정기부금) : 10BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC147"),"0"));   
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ; //특별세액공제_기부금_우리사주조합기부금_공제대상금액 : 11BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC148"),"0"));   
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //특별세액공제_기부금_우리사주조합기부금_세액공제금액 : 10BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC149"),"0"));                
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ; //특별세액공제_기부금_소득세법제34조 제3항 제1호의 기부금_공제대상금액(종교단체외) : 11BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC150"),"0"));                 
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //특별세액공제_기부금_소득세법제34조 제3항 제1호의 기부금_세액공제금액(종교단체외) : 10BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC150a"),"0"));                 
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ; //특별세액공제_기부금_소득세법제34조 제3항 제1호의 기부금_공제대상금액(종교단체) : 11BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC150b"),"0"));                
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //특별세액공제_기부금_소득세법제34조 제3항 제1호의 기부금_세액공제금액(종교단체) : 10BYTE

				// SPCI_NATG	종교단체외지정대상금액	 
				// SPCI_YATG	종교단체지정대상금액	 

				C_RecStr = C_RecStr   + String.format("%011d", 0);	//공란 : 11BYTE //총BYTE : 1674BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC151"),"0"));                 
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //특별세액공제계 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC152"),"0"));              
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; //표준세액공제금액 : 10BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC153"),"0"));               
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ; //납세조합공제 : 10BYTE
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC154"),"0"));              
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ; //주택차입금 : 10BYTE
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC155"),"0"));              
				C_RecStr = C_RecStr  + String.format("%010d",  mTempData02) ; //외국납부 : 10BYTE


				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC156"),"0"));      
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;  //월세세액공제대상금액 : 10BYTE    
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC157"),"0"));            
				C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ; //월세세액공제액 : 8BYTE

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC158"),"0"));               
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ; //세액공제계 : 10BYTE

				//결정세액
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC159"),"0"));               
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02); //소득세 : 11BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC160"),"0"));               
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02); //지방소득세 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC161"),"0"));                 
				C_RecStr = C_RecStr    + String.format("%010d", mTempData02); //농특세 : 10BYTE //총BYTE : 1783BYTE
				
				C_RecStr = C_RecStr +  
						StringUtils.replace(String.format("%04.1f",((Double.parseDouble(MSFSharedUtils.defaultNulls
								  (mapYetaC.get("yetaC159"),"0.00")))/(Double.parseDouble(MSFSharedUtils.defaultNulls
				        				  (mapYetaC.get("yeta0c63"),"0.00"))))*100),".",""); //실효세율 : 3BYTE
				
				//기납부세액 - 주현근무지  
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC162"),"0"));      
				C_RecStr = C_RecStr    + String.format("%011d",  mTempData02); //소득세 : 11BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC163"),"0"));                  
				C_RecStr = C_RecStr    + String.format("%010d", mTempData02); //지방소득세 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC164"),"0"));               
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02); //농특세 : 10BYTE

				//납부특례세액
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC165"),"0"));               
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02); //소득세 : 11BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC166"),"0"));               
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02); //지방소득세 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC167"),"0"));           
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02); //농특세 : 10BYTE

				//차감징수세액
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtEtaxb"),"0"));           
				C_RecStr = C_RecStr   + String.format("%01d",  mTempData02)  ; //소득세 부호 : 1BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC168"),"0"));        
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ; //소득세 : 11BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtInhbb"),"0"));          
				C_RecStr = C_RecStr  + String.format("%01d", mTempData02); //지방소득세 부호 : 1BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC169"),"0"));         
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02); //지방소득세 : 10BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtFafvb"),"0"));           
				C_RecStr = C_RecStr   + String.format("%01d", mTempData02); //농특세 부호 : 1BYTE
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC170"),"0"));            
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02); //농특세 : 10BYTE
				
				C_RecStr = C_RecStr   + String.format("%-128s", "") ; //공란 : 128BYTE //총BYTE : 2010BYTE

              
				TOT_Record.add(C_RecStr);

				D_Cnt = 1; 

				//fnPayrD_ReTax_Total_Select
				infcPkgYe161020Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
				List listYetaD = yeta7400PayrService.fnPayrD_ReTax_Total_Select(infcPkgYe161020Vo);
				//D 레코드 처리 화면  
				if (listYetaD.size() > 0) { 
					Iterator<Map<String, Object>> iter01 = listYetaD.iterator(); 

					while ( iter01.hasNext() ) { 

						Map<String, Object> mapYetaD = (Map<String, Object>) iter01.next(); 

						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

						mTempData02 = 0L;
						D_RecStr = "";
						D_RecStr = "D" + "20" + infcPkgYe161005Vo.getTxOffcCd(); //레코드구분 : 1BYTE + 자료구분 : 2BYTE + 세무서코드 : 3BYTE = 6BYTE
						D_RecStr = D_RecStr +   String.format("%06d", C_Cnt);  //일련번호 : 6BYTE
						D_RecStr = D_RecStr +  String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-","")); //사업자등록번호 : 10BYTE
						D_RecStr = D_RecStr + String.format("%-13s", StringUtils.replace(MSFSharedUtils.defaultNulls(rrnDecCrypt,""),"-","")); //소득자주민등록번호 : 13BYTE

						//2021연말정산_추가
						D_RecStr = D_RecStr + "2" ; //종교관련종사자여부 : 1BYTE
						
						D_RecStr = D_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaD.get("prcspTxpyrAsocYn"),"2")) ;  //납세조합여부 : 1BYTE
						D_RecStr = D_RecStr + Han1(mapYetaD.get("prcspFmnmNm"),60) ; //법인명 : 60BYTE
						D_RecStr = D_RecStr + String.format("%-10s", MSFSharedUtils.defaultNulls(mapYetaD.get("prcspBusoprRgstnum"),""))  ; //사업자등록번호 : 10BYTE
						D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspDutyBgnnDt"),"0"))); //근무기간시작연월일 : 8BYTE
						D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspDutyEndDt"),"0"))); //근무기간종료연월일 : 8BYTE
						D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspReduBgnnDt"),"0"))); //감면기간시작연월일 : 8BYTE
						D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspReduEndDt"),"0"))); //감면기간종료연월일 : 8BYTE
                               
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspPaySum"),"0"));  
						D_RecStr = D_RecStr +  String.format("%011d",mTempData02);//급여 : 11BYTE
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspAllwBnusSum"),"0")); 
						D_RecStr = D_RecStr +  String.format("%011d",mTempData02);//상여 : 11BYTE
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspRcgtnBnusSum"),"0")); 
						D_RecStr = D_RecStr +  String.format("%011d", mTempData02);//인정상여 : 11BYTE
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspStckEvntPrftSum"),"0")); 
						D_RecStr = D_RecStr +  String.format("%011d",mTempData02);//주식매수선택권행사이익 : 11BYTE
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspEmpStkscWdrwSum"),"0")); 
						D_RecStr = D_RecStr +  String.format("%011d",mTempData02);//우리사주조합인출금 : 11BYTE

						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspEcteRsgtnExceSum"),"0")); 
						D_RecStr = D_RecStr +  String.format("%011d",mTempData02);//임원퇴직소득한도초과액 : 11BYTE
						
						D_RecStr = D_RecStr +  String.format("%011d",0);	//직무발명보상금 : 11BYTE

						D_RecStr = D_RecStr +  String.format("%022d",0);	//공란 : 11BYTE + 공란 : 11BYTE = 22BYTE

						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspAggrSum"),"0")); 
						D_RecStr = D_RecStr +  String.format("%011d",mTempData02);	//계 : 11BYTE

						//종전근무지 비과세소득 및 감면소득  
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSg01Jong"),"0"));  
						D_RecStr = D_RecStr   + String.format("%010d", mTempData02);	//비과세학자금 : 10BYTE
						//2022연말정산_추가 : 해당항목삭제
						//mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh01Jong"),"0"));  
						//D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02); //무보수위원수당 : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh05Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ; //경호승선수당 : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh06Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02); //유아초중등 : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh07Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ; //고등교육법 : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh08Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ; //특별법 : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh09Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02)  ; //연구기관등 : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh10Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02)  ;	//기업부설연구소 : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh14Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02); //보육교사근무환경개선비 : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh15Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ; //시립유치원수석교사인건비 : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh11Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;	//취재수당 : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh12Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02)  ; //벽지수당 : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh13Jong"),"0"));  
						D_RecStr = D_RecStr    +  String.format("%010d",  mTempData02) ; //재해관련급여 : 10BYTE
						mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh16Jong"),"0"));  
						D_RecStr = D_RecStr    +  String.format("%010d",  mTempData02) ;	//정부공공기관지방이전기관종사자이주수당 : 10BYTE

						D_RecStr = D_RecStr +  String.format("%010d",0);	//종교활동비 : 10BYTE

						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSi01Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02); //외국정부등근무자 : 10BYTE
						mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSk01Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ; //외국주둔군인등 : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm01Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ; //국외근로100만원 : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm02Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;	//국외근로300만원 : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm03Jong"),"0"));  
						D_RecStr = D_RecStr  +  String.format("%010d",  mTempData02) ; //국외근로 : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSo01Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d", mTempData02)  ; //야간근로수당 : 10BYTE
						mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSq01Jong"),"0")); 
						D_RecStr = D_RecStr  +  String.format("%010d", mTempData02) ; //출산보육수당 : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSr10Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ; //근로장학금 : 10BYTE

						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSr11Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ; //직무발명보상금 : 10BYTE

						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSs01Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	//주식매수선택권 : 10BYTE

						D_RecStr = D_RecStr +  String.format("%010d",0);	//벤처기업 주식매수 선택권 : 10BYTE

						mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy02Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ; //우리사주조합인출금50% : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy03Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	//우리사주조합인출금75% : 10BYTE

						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy04Jong"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	//우리사주조합인출금100% : 10BYTE

						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy22Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02); //전공의수련보조수당 : 10BYTE
						 
						D_RecStr = D_RecStr   +  String.format("%010d",  0);	//외국인기술자소득세감면50% : 10BYTE
						
						//2022연말정산_추가
						D_RecStr = D_RecStr   +  String.format("%010d",  0);	//외국인기술자소득세감면70% : 10BYTE
						
						//2019귀속 추가
						D_RecStr = D_RecStr   +  String.format("%010d",  0);	//성과공유중소기업경영성과급 : 10BYTE
						
						//2022연말정산_추가
						D_RecStr = D_RecStr   +  String.format("%010d",  0);	//T40중소기업청년근로자및핵심인력성과보상기금소득세감면 : 10BYTE
						D_RecStr = D_RecStr   +  String.format("%010d",  0);	//T41중견기업청년근로자및핵심인력성과보상기금소득세감면 : 10BYTE
						D_RecStr = D_RecStr   +  String.format("%010d",  0);	//T42중소기업청년근로자및핵심인력성과보상기금소득세감면 : 10BYTE
						D_RecStr = D_RecStr   +  String.format("%010d",  0);	//T43중견기업청년근로자및핵심인력성과보상기금소득세감면 : 10BYTE
									
						//2021연말정산_추가
						D_RecStr = D_RecStr   +  String.format("%010d",  0); //내국인우수인력 국내복귀소득세감면 : 10BYTE
						
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt11Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	//중소기업 취업 청년소득세 감면 50% : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt12Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	//중소기업 취업 청년소득세 감면 70% : 10BYTE

						D_RecStr = D_RecStr +  String.format("%010d",0);	//중소기업 취업 청년소득세 감면 90% : 10BYTE

						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt20Jong"),"0")); 
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	//조세조약상교직자감면 : 10BYTE
						
						
						D_RecStr = D_RecStr +  String.format("%010d",0); //공란 : 10BYTE
						
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("freeDtyAggrSum"),"0"));   
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02); //비과세계 : 10BYTE
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("reduIncmAggrSum"),"0"));  
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02); //감면소득계 : 10BYTE

						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspIncmTxSum"),"0")); 
						D_RecStr = D_RecStr +  String.format("%011d", mTempData02); //소득세 : 11BYTE
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspRgonIncmTxSum"),"0")); 
						D_RecStr = D_RecStr +  String.format("%010d", mTempData02); //지방소득세 : 10BYTE
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspNnksSum"),"0")); 
						D_RecStr = D_RecStr +  String.format("%010d", mTempData02);	//농특세 : 10BYTE
						D_RecStr = D_RecStr +  String.format("%02d",  D_Cnt);	//종전근무처일련번호 : 2BYTE
						D_RecStr = D_RecStr + String.format("%1288s", ""); 	//공란 : 1288BYTE

						TOT_Record.add(D_RecStr);

						D_Cnt = D_Cnt + 1;
					}
				}
				
				//E레코드
				E_Cnt = 1;
				E_RowCnt = 1;
				E_RecStr = "";

				infcPkgYe161020Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));

				List listYetaE = yeta7400PayrService.fnPayrE_ReTax_Total_Select(infcPkgYe161020Vo);

				// E레코드 파일처리 
				 
				if ( listYetaE.size() > 0) { 
					Iterator<Map<String, Object>> iter03 = listYetaE.iterator(); 
					while ( iter03.hasNext() ) { 
                    	
						Map<String, Object> mapYetaE = (Map<String, Object>) iter03.next(); 

						mTempData02 = 0L;

						// 주민번호(복호화)
						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

						E_RecStr =  "E" + "20" + infcPkgYe161005Vo.getTxOffcCd() + String.format("%06d", C_Cnt)
                                 +  String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-",""))
                                 + String.format("%-13s", StringUtils.replace(rrnDecCrypt,"-",""));	
						//레코드구분(1byte) + 자료구분(2byte) + 세무서코드(3byte) + 일련번호(6byte) + 사업자등록번호(10byte) + 주민등록번호(13byte) = 35byte

						if (listYetaE.size() + 1 > E_RowCnt)  {

							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("suptFmlyRltClCd")," ");    //연말정산부양관계코드(1byte) = 36byte 
							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("nnfClCd")," "); //내외국인구분코드(1byte) = 37byte
							E_RecStr = E_RecStr + Han1(mapYetaE.get("txprNm") ,30)   ;	//이름(30byte) = 67byte
							// 주민번호(복호화)
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("txprDscmNoCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
							E_RecStr = E_RecStr+ String.format("%-13s",rrnDecCrypt);  //주민번호(13byte) = 80byte

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bscDdcClCd")," ");  	//기본공제(1byte) = 81byte
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcClCd")," ");  //장애인공제(1byte) = 82byte
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("wmnDdcClCd")," ");   	//부녀자공제(1byte) = 83byte
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("sccDdcClCd")," ");	//경로우대공제 (1byte) = 84byte

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("snprntFmlyDdcClCd")," ");  //한부모가족공제(1byte) = 85byte

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("chbtAtprDdcClCd")," ");  //출산.입양공제(1byte) = 86byte
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("childLt")," "); //자녀공제(1byte) = 87byte
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("eduDdcDvcd")," ");	//교육비공제(1byte) = 88byte
							
							//소득공제국세청자료 
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("hifeDdcTrgt01"),"0"));    //보험료 _건강(10byte) = 98byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mcurUiTrgt01"),"0"));  //보험료 고용보험(10byte) = 108byte	
							if("0".equals(mapYetaE.get("suptFmlyRltClCd")))
								E_RecStr = E_RecStr+   String.format("%010d", mTempData02);	//본인일경우 고용보험금액 그대로 나옴
							else
								E_RecStr = E_RecStr+   String.format("%010d", 0);	//본인이 아닐경우 0 입력
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cvrgInscDdcTrgt01"),"0"));   //보험료 _보장성(10byte) = 118byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcTrgt01"),"0"));    //보험료 _장애인보장성 국세청(10byte) = 128byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;	

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsDdcTrgt01"),"0"));        // 의료비(10byte) = 138byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							//2022연말정산_추가
							E_RecStr = E_RecStr+   String.format("%010d", 0); //선천성미숙아 10byte
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsSftXpnsDdcTrgt01"),"0")); //의료비_난임(10byte) = 148byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02);		
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxps65DsbrDdcTrgt01"),"0")); //의료비_65세이상,장애인(10byte) = 158byte
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);	
							mTempData02 = Math.abs(Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsLsInsrDdcTrgt01"),"0"))); //의료비_실손의료(10byte) = 168byte
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);  

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDdcTrgt01"),"0"));         //교육비(10byte) = 178byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02);
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDsbrDdcTrgt01"),"0")); //교육비_장애인특수교육비(10byte) = 188byte
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt01"),"0"));       
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt01"),"0"));       
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cshptDdcTrgt01"),"0"));          
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt01"),"0"));       
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt01"),"0"));      
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							
							//2022연말정산_추가 : 대중교통 상하반기로 분리 필요
							//mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt01"),"0"));
							//E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ; //대중교통사용분 : 10BYTE
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tfhyPbtAmt01"),"0"));        
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("shfyPbtAmt01"),"0"));        
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							////////////
							
							//2021연말정산_추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totCrdcPreSum01"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	//소비증가분_2021년 전체사용분 : 10BYTE
							
							//2022연말정산_추가 : 21년 전통시장 사용금액 추가 필요
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totTdmrPreSum01"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							/////////
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totCrdcCurrSum01"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	//소비증가분_2022년 전체사용분 : 10BYTE
							
							//2022연말정산_추가 : 22년 전통시장 사용금액 추가 필요
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totTdmrCurrSum01"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							/////////
							

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("conbDdcTrgt01"),"0"));       //기부금(13byte) = 381byte
							E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;	

							//소득공제자료 기타자료 
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("hifeDdcTrgt02"),"0"));          //보험료 _ 건강보험(10byte) = 391byte
							E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;

							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mcurUiTrgt02"),"0"));  //보험료_고용보험(10byte) = 401byte	
							if("0".equals(mapYetaE.get("suptFmlyRltClCd")))
								E_RecStr = E_RecStr+   String.format("%010d", mTempData02);	//본인일경우 고용보험금액 그대로 나옴
							else
								E_RecStr = E_RecStr+   String.format("%010d", 0);	//본인이 아닐경우 0 입력

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cvrgInscDdcTrgt02"),"0"));     //보험료 _ 보장성(10byte) = 411byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcTrgt02"),"0"));         //보험료 _장애인보장성 외(10byte) = 421byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02);

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsDdcTrgt02"),"0"));        //의료비 외(10byte) = 431byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
							//2022연말정산_추가
							E_RecStr = E_RecStr+   String.format("%010d", 0); //미숙아10byte
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsSftXpnsDdcTrgt02"),"0")); //의료비 난임(10byte) = 441byte
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);		
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxps65DsbrDdcTrgt02"),"0")); //의료비 장애인.건강보험산정 특례자(10byte) = 451byte	
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);
							//2020귀속 추가
							E_RecStr = E_RecStr+   String.format("%01d", 0); //실손의료보험금(1byte) = 461byte
							mTempData02 = Math.abs(Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsLsInsrDdcTrgt02"),"0"))); //실손(10byte) = 461byte
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);  

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDdcTrgt02"),"0"));           //교육비 외(10byte) = 471byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDsbrDdcTrgt02"),"0")); //교육비 장애인 특수교육(10byte) = 481byte
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);	
							
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt02"),"0"));
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ; //신용카드 : 10BYTE
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt02"),"0")); 
							E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ; //직불카드 : 10BYTE //총BYTE : 402BYTE

							//2019년추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt02"),"0"));
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ; //도서공연등사용분 : 10BYTE

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt02"),"0"));      
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ; //전통시장사용분 : 10BYTE

							//2022연말정산_추가 : 대중교통 상하반기로 분리 필요
							//mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt02"),"0"));
							//E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ; //대중교통사용분 : 10BYTE
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tfhyPbtAmt02"),"0"));        
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("shfyPbtAmt02"),"0"));        
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							//////////
							
							
							//2021연말정산_추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totCrdcPreSum02"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	//소비증가분_2021년 전체사용분 : 10BYTE
							
							//2022연말정산_추가 : 21년 전통시장사용분 추가 필요
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totTdmrPreSum02"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							///////////////
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totCrdcCurrSum02"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	//소비증가분_2022년 전체사용분 : 10BYTE
							
							//2022연말정산_추가 : 22년 전통시장사용분 추가 필요
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totTdmrCurrSum02"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							///////////////
							

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("conbDdcTrgt02"),"0"));      // 기부금외(13byte) = 644byte
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
							E_RecStr = E_RecStr + String.format("%1s","") //관계 
                                  + String.format("%1s","") //내외국인
                                  + String.format("%30s","") //이름
                                  + String.format("%13s","") //주민번호
                                  + String.format("%1s","") //기본공제 
                                  + String.format("%1s","") //장애인
                                  + String.format("%1s","") //부녀자
                                  + String.format("%1s","") //경로우대
                                  + String.format("%1s","") //한부모
                                  + String.format("%1s","") //출산입양공제
                                  + String.format("%1s","") //자녀공제
                                  + String.format("%1s","") //교육비공제
                                  + String.format("%010d", 0) //건강보험 
                                  + String.format("%010d", 0) //고용보험
                                  + String.format("%010d", 0) //보장성보험
                                  + String.format("%010d", 0) //장애인보장성보험
                                  + String.format("%010d", 0) //의료비일반
                                  + String.format("%010d", 0) //의료비미숙아
                                  + String.format("%010d", 0) //의료비난임
                                  + String.format("%010d", 0) //의료비65이상
                                  + String.format("%010d", 0) //의료비실손의료보험금
                                  + String.format("%010d", 0) //교육비일반
                                  + String.format("%010d", 0) //교육비장애인
                                  + String.format("%010d", 0) //신용카드
                                  + String.format("%010d", 0) //직불카드
                                  + String.format("%010d", 0) //현금영수증
                                  + String.format("%010d", 0) //도서공연
                                  + String.format("%010d", 0) //전통시장
                                  + String.format("%010d", 0) //대중교통상반기
                                  + String.format("%010d", 0) //대중교통하반기
                                  + String.format("%010d", 0) //21년전체사용분
                                  + String.format("%010d", 0) //21년전통시장
                                  + String.format("%010d", 0) //22년전체사용분
                                  + String.format("%010d", 0) //22년전통시장
                                  + String.format("%013d", 0) //기부금 
                                  + String.format("%010d", 0) //건강보험
                                  + String.format("%010d", 0) //고용보험
                                  + String.format("%010d", 0) //보장성보험
                                  + String.format("%010d", 0) //장애인보장성보험
                                  + String.format("%010d", 0) //의료비일반
                                  + String.format("%010d", 0) //의료비미숙아
                                  + String.format("%010d", 0) //의료비난임
                                  + String.format("%010d", 0) //의료비65세
                                  + String.format("%01d", 0)  //실손의료보험금구분자
                                  + String.format("%010d", 0) //실손의료보험금
                                  + String.format("%010d", 0) //교육비일반
                                  + String.format("%010d", 0) //교육비_장애인
                                  + String.format("%010d", 0) //신용카드
                                  + String.format("%010d", 0) //직불카드
                                  + String.format("%010d", 0) //도서공연
                                  + String.format("%010d", 0) //전통시장
                                  + String.format("%010d", 0) //대중교통상반기
                                  + String.format("%010d", 0) //대중교통하반기
                                  + String.format("%010d", 0) //21년전체사용분
                                  + String.format("%010d", 0) //21년전통시장
                                  + String.format("%010d", 0) //22년전체사용분
                                  + String.format("%010d", 0) //22년전통시장
                                  + String.format("%013d", 0); //기부금 
 
							E_RowCnt =  E_RowCnt + 1;
						}
                 
						if (listYetaE.size() + 1 > E_RowCnt)  {

							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("suptFmlyRltClCd")," ");    //연말정산부양관계코드(1byte) = 36byte 
							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("nnfClCd")," "); //내외국인구분코드(1byte) = 37byte
							E_RecStr = E_RecStr + Han1(mapYetaE.get("txprNm") ,30)   ;	//이름(30byte) = 67byte
							// 주민번호(복호화)
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("txprDscmNoCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
							E_RecStr = E_RecStr+ String.format("%-13s",rrnDecCrypt);  //주민번호(13byte) = 80byte

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bscDdcClCd")," ");  	//기본공제(1byte) = 81byte
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcClCd")," ");  //장애인공제(1byte) = 82byte
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("wmnDdcClCd")," ");   	//부녀자공제(1byte) = 83byte
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("sccDdcClCd")," ");	//경로우대공제 (1byte) = 84byte

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("snprntFmlyDdcClCd")," ");  //한부모가족공제(1byte) = 85byte

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("chbtAtprDdcClCd")," ");  //출산.입양공제(1byte) = 86byte
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("childLt")," "); //자녀공제(1byte) = 87byte
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("eduDdcDvcd")," ");	//교육비공제(1byte) = 88byte
							
							//소득공제국세청자료 
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("hifeDdcTrgt01"),"0"));    //보험료 _건강(10byte) = 98byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mcurUiTrgt01"),"0"));  //보험료 고용보험(10byte) = 108byte	
							if("0".equals(mapYetaE.get("suptFmlyRltClCd")))
								E_RecStr = E_RecStr+   String.format("%010d", mTempData02);	//본인일경우 고용보험금액 그대로 나옴
							else
								E_RecStr = E_RecStr+   String.format("%010d", 0);	//본인이 아닐경우 0 입력
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cvrgInscDdcTrgt01"),"0"));   //보험료 _보장성(10byte) = 118byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcTrgt01"),"0"));    //보험료 _장애인보장성 국세청(10byte) = 128byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;	

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsDdcTrgt01"),"0"));        // 의료비(10byte) = 138byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;	
							//2022연말정산_추가
							E_RecStr = E_RecStr+   String.format("%010d", 0); //미숙아
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsSftXpnsDdcTrgt01"),"0")); //의료비_난임(10byte) = 148byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02);		
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxps65DsbrDdcTrgt01"),"0")); //의료비_본인,65세이상,장애인(10byte) = 158byte
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);	
							mTempData02 = Math.abs(Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsLsInsrDdcTrgt01"),"0"))); //의료비_실손의료(10byte) = 168byte
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02); 

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDdcTrgt01"),"0"));         //교육비(10byte) = 178byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02);
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDsbrDdcTrgt01"),"0")); //교육비_장애인특수교육비(10byte) = 188byte
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt01"),"0"));       
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt01"),"0"));       
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cshptDdcTrgt01"),"0"));         
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt01"),"0"));       
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt01"),"0"));     
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							
							//2022연말정산_추가 : 대중교통 상하반기로 분리 필요
							//mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt01"),"0"));        
							//E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tfhyPbtAmt01"),"0"));        
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("shfyPbtAmt01"),"0"));        
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							////////////
							
							//2021연말정산_추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totCrdcPreSum01"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	//소비증가분_2021년 전체사용분 : 10BYTE
							
							//2022연말정산_추가 : 21년전통시장사용분 추가 필요
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totTdmrPreSum01"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							/////////////
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totCrdcCurrSum01"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	//소비증가분_2022년 전체사용분 : 10BYTE
							
							//2022연말정산_추가 : 22년전통시장사용분 추가 필요
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totTdmrCurrSum01"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							/////////////
							

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("conbDdcTrgt01"),"0"));       //기부금(13byte) = 381byte
							E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;	

							//소득공제자료 기타자료 
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("hifeDdcTrgt02"),"0"));          //보험료 _ 건강보험(10byte) = 391byte
							E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;

							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mcurUiTrgt02"),"0"));  //보험료_고용보험(10byte) = 401byte	
							if("0".equals(mapYetaE.get("suptFmlyRltClCd")))
								E_RecStr = E_RecStr+   String.format("%010d", mTempData02);	//본인일경우 고용보험금액 그대로 나옴
							else
								E_RecStr = E_RecStr+   String.format("%010d", 0);	//본인이 아닐경우 0 입력

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cvrgInscDdcTrgt02"),"0"));     //보험료 _ 보장성(10byte) = 411byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcTrgt02"),"0"));         //보험료 _장애인보장성 외(10byte) = 421byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02);

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsDdcTrgt02"),"0"));        //의료비 외(10byte) = 431byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
							//2022연말정산_추가
							E_RecStr = E_RecStr+   String.format("%010d", 0); //미숙아
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsSftXpnsDdcTrgt02"),"0")); //의료비 난임(10byte) = 441byte
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);		
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxps65DsbrDdcTrgt02"),"0")); //의료비 장애인.건강보험산정 특례자(10byte) = 451byte	
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);		
							//2020귀속 추가
							E_RecStr = E_RecStr+   String.format("%01d", 0); //실손의료보험금(1byte)
							mTempData02 = Math.abs(Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsLsInsrDdcTrgt02"),"0"))); //실손(10byte) = 461byte
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);  

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDdcTrgt02"),"0"));           //교육비 외(10byte) = 471byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDsbrDdcTrgt02"),"0")); //교육비 장애인 특수교육(10byte) = 481byte
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);	
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt02"),"0"));
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ; //신용카드 : 10BYTE
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt02"),"0")); 
							E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ; //직불카드 : 10BYTE //총BYTE : 402BYTE

							//2019년추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt02"),"0"));
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ; //도서공연등사용분 : 10BYTE

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt02"),"0"));      
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ; //전통시장사용분 : 10BYTE

							//2022연말정산_추가 : 대중교통 상하반기 분리 필요
							//mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt02"),"0"));
							//E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ; //대중교통사용분 : 10BYTE
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tfhyPbtAmt02"),"0"));        
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("shfyPbtAmt02"),"0"));        
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							////////////////
							
							//2021연말정산_추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totCrdcPreSum02"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	//소비증가분_2021년 전체사용분 : 10BYTE
							
							//2022연말정산_추가 : 21년 전통시장사용분 필요
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totTdmrPreSum02"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							/////////
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totCrdcCurrSum02"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	//소비증가분_2022년 전체사용분 : 10BYTE
							
							//2022연말정산_추가 : 21년 전통시장사용분 필요
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totTdmrCurrSum02"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							/////////

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("conbDdcTrgt02"),"0"));      // 기부금외(13byte) = 644byte
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
							E_RecStr = E_RecStr + String.format("%1s","") //관계 1byte
									+ String.format("%1s","") //2byte
	                                  + String.format("%30s","") //32byte
	                                  + String.format("%13s","") //45byte
	                                  + String.format("%1s","") //기본공제 46byte
	                                  + String.format("%1s","") //47byte
	                                  + String.format("%1s","") //48byte
	                                  + String.format("%1s","") //49byte
	                                  + String.format("%1s","") //50byte
	                                  + String.format("%1s","") //출산입양공제 //51byte
	                                  + String.format("%1s","")
	                                  + String.format("%1s","")
	                                  + String.format("%010d", 0) //건강보험 63byte
	                                  + String.format("%010d", 0) //73byte
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0) //의료비
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0) //교육비_장애인 153byte
	                                  + String.format("%010d", 0) //신용카드
	                                  + String.format("%010d", 0) //직불카드
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0) //전통시장
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0) //21년소비증가분
	                                  + String.format("%010d", 0) 
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%013d", 0) //기부금 346byte
	                                  + String.format("%010d", 0) //건강보험
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0) //의료비
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%01d", 0) //실손의료보험금구분자
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0) //교육비_장애인 446byte
	                                  + String.format("%010d", 0) //신용카드
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0) //대중교통상반기
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0) 
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%013d", 0); //기부금 609byte
	 
								E_RowCnt =  E_RowCnt + 1;
						}

						if (listYetaE.size() + 1 > E_RowCnt)  {

							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("suptFmlyRltClCd")," ");    //연말정산부양관계코드(1byte) = 36byte 
							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("nnfClCd")," "); //내외국인구분코드(1byte) = 37byte
							E_RecStr = E_RecStr + Han1(mapYetaE.get("txprNm") ,30)   ;	//이름(30byte) = 67byte
							// 주민번호(복호화)
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaE.get("txprDscmNoCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
							E_RecStr = E_RecStr+ String.format("%-13s",rrnDecCrypt);  //주민번호(13byte) = 80byte

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("bscDdcClCd")," ");  	//기본공제(1byte) = 81byte
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcClCd")," ");  //장애인공제(1byte) = 82byte
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("wmnDdcClCd")," ");   	//부녀자공제(1byte) = 83byte
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("sccDdcClCd")," ");	//경로우대공제 (1byte) = 84byte

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("snprntFmlyDdcClCd")," ");  //한부모가족공제(1byte) = 85byte

							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("chbtAtprDdcClCd")," ");  //출산.입양공제(1byte) = 86byte
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("childLt")," "); //자녀공제(1byte) = 87byte
							E_RecStr = E_RecStr+ MSFSharedUtils.defaultNulls(mapYetaE.get("eduDdcDvcd")," ");	//교육비공제(1byte) = 88byte
							
							//소득공제국세청자료 
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("hifeDdcTrgt01"),"0"));    //보험료 _건강(10byte) = 98byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mcurUiTrgt01"),"0"));  //보험료 고용보험(10byte) = 108byte	
							if("0".equals(mapYetaE.get("suptFmlyRltClCd")))
								E_RecStr = E_RecStr+   String.format("%010d", mTempData02);	//본인일경우 고용보험금액 그대로 나옴
							else
								E_RecStr = E_RecStr+   String.format("%010d", 0);	//본인이 아닐경우 0 입력
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cvrgInscDdcTrgt01"),"0"));   //보험료 _보장성(10byte) = 118byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcTrgt01"),"0"));    //보험료 _장애인보장성 국세청(10byte) = 128byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;	

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsDdcTrgt01"),"0"));        // 의료비(10byte) = 138byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;	
							//2022연말정산_추가
							E_RecStr = E_RecStr+   String.format("%010d", 0); //미숙아
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsSftXpnsDdcTrgt01"),"0")); //의료비_난임(10byte) = 148byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02);		
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxps65DsbrDdcTrgt01"),"0")); //의료비_본인,65세이상,장애인(10byte) = 158byte
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);	
							mTempData02 = Math.abs(Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsLsInsrDdcTrgt01"),"0"))); //의료비_실손의료(10byte) = 168byte
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02); 

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDdcTrgt01"),"0"));         //교육비(10byte) = 178byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02);
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDsbrDdcTrgt01"),"0")); //교육비_장애인특수교육비(10byte) = 188byte
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt01"),"0"));     
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt01"),"0"));        
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cshptDdcTrgt01"),"0"));         
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt01"),"0"));        
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt01"),"0"));     
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							
							//2022연말정산_추가 : 대중교통 상하반기 분리 필요
							//mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt01"),"0"));   
							//E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tfhyPbtAmt01"),"0"));        
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("shfyPbtAmt01"),"0"));        
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							/////////////////
							
							//2021연말정산_추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totCrdcPreSum01"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	//소비증가분_2021년 전체사용분 : 10BYTE
							
							//2022연말정산_추가 : 21년전통시장사용분 추가 필요
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totTdmrPreSum01"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							/////////////////
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totCrdcCurrSum01"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	//소비증가분_2022년 전체사용분 : 10BYTE
							
							//2022연말정산_추가 : 22년전통시장사용분 추가 필요
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totTdmrCurrSum01"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							/////////////////
							

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("conbDdcTrgt01"),"0"));       //기부금(13byte) = 381byte
							E_RecStr = E_RecStr+   String.format("%013d", mTempData02)  ;	

							//소득공제자료 기타자료 
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("hifeDdcTrgt02"),"0"));          //보험료 _ 건강보험(10byte) = 391byte
							E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ;

							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mcurUiTrgt02"),"0"));  //보험료_고용보험(10byte) = 401byte	
							if("0".equals(mapYetaE.get("suptFmlyRltClCd")))
								E_RecStr = E_RecStr+   String.format("%010d", mTempData02);	//본인일경우 고용보험금액 그대로 나옴
							else
								E_RecStr = E_RecStr+   String.format("%010d", 0);	//본인이 아닐경우 0 입력

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cvrgInscDdcTrgt02"),"0"));     //보험료 _ 보장성(10byte) = 411byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("dsbrDdcTrgt02"),"0"));         //보험료 _장애인보장성 외(10byte) = 421byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02);

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsDdcTrgt02"),"0"));        //의료비 외(10byte) = 431byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02) ;
							//2022연말정산_추가
							E_RecStr = E_RecStr+   String.format("%010d", 0); //미숙아
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsSftXpnsDdcTrgt02"),"0")); //의료비 난임(10byte) = 441byte
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);		
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxps65DsbrDdcTrgt02"),"0")); //의료비 장애인.건강보험산정 특례자(10byte) = 451byte	
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);		
							//2020귀속 추가
							E_RecStr = E_RecStr+   String.format("%01d", 0); //실손의로보험금(1byte)
							mTempData02 = Math.abs(Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("mdxpsLsInsrDdcTrgt02"),"0"))); //실손(10byte) = 461byte
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);  

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDdcTrgt02"),"0"));           //교육비 외(10byte) = 471byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("scxpsDsbrDdcTrgt02"),"0")); //교육비 장애인 특수교육(10byte) = 481byte
							E_RecStr = E_RecStr+ String.format("%010d", mTempData02);	
							
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt02"),"0"));
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02)  ; //신용카드 : 10BYTE
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt02"),"0")); 
							E_RecStr = E_RecStr+  String.format("%010d",mTempData02)  ; //직불카드 : 10BYTE //총BYTE : 402BYTE

							//2019년추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt02"),"0"));
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ; //도서공연등사용분 : 10BYTE

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt02"),"0"));      
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ; //전통시장사용분 : 10BYTE

							//2022연말정산_추가 : 대중교통 상하반기 분리 필요
							//mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt02"),"0"));
							//E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ; //대중교통사용분 : 10BYTE
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tfhyPbtAmt02"),"0"));        
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("shfyPbtAmt02"),"0"));        
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							///////////////
							
							//2021연말정산_추가
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totCrdcPreSum02"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	//소비증가분_2021년 전체사용분 : 10BYTE
							
							//2022연말정산_추가 : 21년전통시장 추가 필요
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totTdmrPreSum02"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							/////////////
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totCrdcCurrSum02"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;	//소비증가분_2022년 전체사용분 : 10BYTE
							
							//2022연말정산_추가 : 22년전통시장 추가 필요
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("totTdmrCurrSum02"),"0")); 
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							/////////////

							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("conbDdcTrgt02"),"0"));      // 기부금외(13byte) = 644byte
							E_RecStr = E_RecStr+   String.format("%013d",mTempData02);

							E_RowCnt =  E_RowCnt + 1;
							//try {
							//mapYetaE = (Map<String, Object>) iter03.next(); 
							//} catch (NoSuchElementException e) {
							//e.printStackTrace();
							//}   

						}
						else
						{
							E_RecStr = E_RecStr + String.format("%1s","") //관계 1byte
									+ String.format("%1s","") //내외국인2byte
	                                  + String.format("%30s","") //이름32byte
	                                  + String.format("%13s","") //주민번호 45byte
	                                  + String.format("%1s","") //기본공제 46byte
	                                  + String.format("%1s","") //장애인47byte
	                                  + String.format("%1s","") //부녀자48byte
	                                  + String.format("%1s","") //경로우대49byte
	                                  + String.format("%1s","") //한부모50byte
	                                  + String.format("%1s","") //출산입양공제 //51byte
	                                  + String.format("%1s","") //자녀
	                                  + String.format("%1s","") //장애인공제
	                                  + String.format("%010d", 0) //건강보험 63byte
	                                  + String.format("%010d", 0) //고용보험73byte
	                                  + String.format("%010d", 0) //보장성보험
	                                  + String.format("%010d", 0) //장애인보장성보험
	                                  + String.format("%010d", 0) //의료비일반
	                                  + String.format("%010d", 0) //미숙아
	                                  + String.format("%010d", 0) //난임
	                                  + String.format("%010d", 0) //65세
	                                  + String.format("%010d", 0) //실손
	                                  + String.format("%010d", 0) //교육비일반
	                                  + String.format("%010d", 0) //교육비_장애인 153byte
	                                  + String.format("%010d", 0) //신용카드
	                                  + String.format("%010d", 0) //직불카드
	                                  + String.format("%010d", 0) //현금
	                                  + String.format("%010d", 0) //도서공연
	                                  + String.format("%010d", 0) //전통시장
	                                  + String.format("%010d", 0) //대중교통상반기
	                                  + String.format("%010d", 0) //대중교통하반기
	                                  + String.format("%010d", 0) //21년사용액
	                                  + String.format("%010d", 0) //21년전통시장
	                                  + String.format("%010d", 0) //22년사용액
	                                  + String.format("%010d", 0) //22년전통시장
	                                  + String.format("%013d", 0) //기부금 346byte
	                                  + String.format("%010d", 0) //건강
	                                  + String.format("%010d", 0) //고용
	                                  + String.format("%010d", 0) //보장성
	                                  + String.format("%010d", 0) //장애인보장성
	                                  + String.format("%010d", 0) //의료비일반
	                                  + String.format("%010d", 0) //미숙아
	                                  + String.format("%010d", 0) //난임
	                                  + String.format("%010d", 0) //65세
	                                  + String.format("%01d", 0) //실손의료보험금구분자
	                                  + String.format("%010d", 0) //실손
	                                  + String.format("%010d", 0) //교육비일반
	                                  + String.format("%010d", 0) //교육비_장애인 446byte
	                                  + String.format("%010d", 0) //신용카드
	                                  + String.format("%010d", 0) //직불
	                                  + String.format("%010d", 0) //도서공연
	                                  + String.format("%010d", 0) //전통시장
	                                  + String.format("%010d", 0) //대중교통상반기
	                                  + String.format("%010d", 0) //대중교통하반기
	                                  + String.format("%010d", 0) //21년사용액
	                                  + String.format("%010d", 0) //21년전통시장
	                                  + String.format("%010d", 0) //22년사용액
	                                  + String.format("%010d", 0) //22년전통시장
	                                  + String.format("%013d", 0); //기부금 609byte
	 
								E_RowCnt =  E_RowCnt + 1;
						}
						
						E_RecStr = E_RecStr +  String.format("%02d",  E_Cnt); 
						E_RecStr = E_RecStr +  String.format("%443s",""); //공란
                        
						TOT_Record.add(E_RecStr);
						E_Cnt = E_Cnt + 1;
						E_RecStr = ""; 

					}
				}

				// F레코드  - 연금저축등 소득세액공제명세 레코드 

				F_Cnt = 1;
				F_RowCnt = 1;
				F_RecStr = "";

				infcPkgYe161020Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));

				List listYetaF = yeta7400PayrService.fnPayrF_ReTax_Total_Select(infcPkgYe161020Vo);

				if ( listYetaF.size() > 0) { 

					Iterator<Map<String, Object>> iter04 = listYetaF.iterator(); 

					while ( iter04.hasNext() ) { 
                    	
						Map<String, Object> mapYetaF = (Map<String, Object>) iter04.next(); 

						mTempData02 = 0L;

						// 주민번호(복호화)
						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

						F_RecStr =  "F" + "20" + infcPkgYe161005Vo.getTxOffcCd() 
									+  String.format("%06d", C_Cnt) 
									+ String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-",""))
                                  	+ String.format("%-13s",rrnDecCrypt ) ; //레코드구분 : 1BYTE + 자료구분 : 2BYTE + 세무서코드 : 3BYTE + 일련번호 : 6BYTE + 사업자등록번호 : 10BYTE + 소득자주민번호 : 13BYTE = 35BYTE
 
						if (listYetaF.size() + 1 > F_RowCnt)  { //1
                  
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))  //소득공제구분 : 2BYTE 
										+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  //금융기관코드 : 3BYTE
										+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  //금융기관상호 : 60BYTE
										+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ; //계좌번호 : 20BYTE
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0")); 
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //납입금액 : 10BYTE
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +  String.format("%010d",0) ; //중소기업창업투자조합출자의 경우는 0값이 나와야함
							else
								F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //소득,세액공제금액 : 10BYTE
							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%04d", mTempData02); //중소기업창업투자조합출자의 경우는 년도가 들어감
							else
								F_RecStr = F_RecStr +  String.format("%04d",0);	//투자연도 : 4BYTE
							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%01d", mTempData02); //중소기업창업투자조합출자인경우 1,2,3중 하나
							else
								F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분 : 1BYTE
							
							//2022연말정산_추가 : 청년형장기집합투자증권저축 가입일,계약기간 추가 필요
							//가입일, 청년형 제외 나머지는 00000000
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
							if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%08d", mTempData02); //청년형장기집합투자증권저축 가입일
							else
								F_RecStr = F_RecStr +  String.format("%08d",0);	//가입일 
							//계약기간, 청년형 제외 나머지는 00
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("ctrTermMmCnt"),"0"));
							if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%02d", mTempData02); //청년형장기집합투자증권저축 계약기간
							else
								F_RecStr = F_RecStr +  String.format("%02d",0);	//계약기간 
							////////

							F_RowCnt =  F_RowCnt + 1;
                          
							try {
								mapYetaF = (Map<String, Object>) iter04.next(); 
							} catch (NoSuchElementException e) {
								//e.printStackTrace();
							}      
                          
						}
						else
						{//공제금액이 0인경우 기재하지 않음
							F_RecStr = F_RecStr + String.format("%-2s","") //소득공제구분
                                   + String.format("%-3s","") //금융기관코드
                                   +  String.format("%-60s","") //금융기관상호
                                   + String.format("%-20s","") //계좌번호
                                   +  String.format("%010d", 0) //납입금액
                                   +  String.format("%010d", 0) //공제금액
								+  String.format("%04d", 0) //투자연도
								+  String.format("%1s","") //투자구분
								+  String.format("%08d", 0) //가입일
								+  String.format("%02d", 0); //계약기간

							F_RowCnt =  F_RowCnt + 1;
						}

						if (listYetaF.size() + 1 > F_RowCnt)  { //2
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))  //소득공제구분 : 2BYTE 
									+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  //금융기관코드 : 3BYTE
									+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  //금융기관상호 : 60BYTE
									+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ; //계좌번호 : 20BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0")); 
						F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //납입금액 : 10BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +  String.format("%010d",0) ; //중소기업창업투자조합출자의 경우는 0값이 나와야함
						else
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //소득,세액공제금액 : 10BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%04d", mTempData02); //중소기업창업투자조합출자의 경우는 년도가 들어감
						else
							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자연도 : 4BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%01d", mTempData02); //중소기업창업투자조합출자인경우 1,2,3중 하나
						else
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분 : 1BYTE
						
						//2022연말정산_추가 : 청년형장기집합투자증권저축 가입일,계약기간 추가 필요
						//가입일, 청년형 제외 나머지는 00000000
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%08d", mTempData02); //청년형장기집합투자증권저축 가입일
						else
							F_RecStr = F_RecStr +  String.format("%08d",0);	//가입일 
						//계약기간, 청년형 제외 나머지는 00
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("ctrTermMmCnt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%02d", mTempData02); //청년형장기집합투자증권저축 계약기간
						else
							F_RecStr = F_RecStr +  String.format("%02d",0);	//계약기간 
						////////


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
								+  String.format("%1s","")
								+  String.format("%08d", 0) //가입일
								+  String.format("%02d", 0); //계약기간

							F_RowCnt =  F_RowCnt + 1;
						}

						if (listYetaF.size() + 1 > F_RowCnt)  { //3
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))  //소득공제구분 : 2BYTE 
									+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  //금융기관코드 : 3BYTE
									+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  //금융기관상호 : 60BYTE
									+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ; //계좌번호 : 20BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0")); 
						F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //납입금액 : 10BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +  String.format("%010d",0) ; //중소기업창업투자조합출자의 경우는 0값이 나와야함
						else
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //소득,세액공제금액 : 10BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%04d", mTempData02); //중소기업창업투자조합출자의 경우는 년도가 들어감
						else
							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자연도 : 4BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%01d", mTempData02); //중소기업창업투자조합출자인경우 1,2,3중 하나
						else
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분 : 1BYTE
						
						//2022연말정산_추가 : 청년형장기집합투자증권저축 가입일,계약기간 추가 필요
						//가입일, 청년형 제외 나머지는 00000000
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%08d", mTempData02); //청년형장기집합투자증권저축 가입일
						else
							F_RecStr = F_RecStr +  String.format("%08d",0);	//가입일 
						//계약기간, 청년형 제외 나머지는 00
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("ctrTermMmCnt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%02d", mTempData02); //청년형장기집합투자증권저축 계약기간
						else
							F_RecStr = F_RecStr +  String.format("%02d",0);	//계약기간 
						////////


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
								+  String.format("%1s","")
								+  String.format("%08d", 0) //가입일
								+  String.format("%02d", 0); //계약기간

							F_RowCnt =  F_RowCnt + 1;
						}

						if (listYetaF.size() + 1 > F_RowCnt)  { //4
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))  //소득공제구분 : 2BYTE 
									+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  //금융기관코드 : 3BYTE
									+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  //금융기관상호 : 60BYTE
									+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ; //계좌번호 : 20BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0")); 
						F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //납입금액 : 10BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +  String.format("%010d",0) ; //중소기업창업투자조합출자의 경우는 0값이 나와야함
						else
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //소득,세액공제금액 : 10BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%04d", mTempData02); //중소기업창업투자조합출자의 경우는 년도가 들어감
						else
							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자연도 : 4BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%01d", mTempData02); //중소기업창업투자조합출자인경우 1,2,3중 하나
						else
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분 : 1BYTE
						
						//2022연말정산_추가 : 청년형장기집합투자증권저축 가입일,계약기간 추가 필요
						//가입일, 청년형 제외 나머지는 00000000
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%08d", mTempData02); //청년형장기집합투자증권저축 가입일
						else
							F_RecStr = F_RecStr +  String.format("%08d",0);	//가입일 
						//계약기간, 청년형 제외 나머지는 00
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("ctrTermMmCnt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%02d", mTempData02); //청년형장기집합투자증권저축 계약기간
						else
							F_RecStr = F_RecStr +  String.format("%02d",0);	//계약기간 
						////////


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
								+  String.format("%1s","")
								+  String.format("%08d", 0) //가입일
								+  String.format("%02d", 0); //계약기간

							F_RowCnt =  F_RowCnt + 1;
						}

						if (listYetaF.size() + 1 > F_RowCnt)  { //5
		                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))  //소득공제구분 : 2BYTE 
									+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  //금융기관코드 : 3BYTE
									+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  //금융기관상호 : 60BYTE
									+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ; //계좌번호 : 20BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0")); 
						F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //납입금액 : 10BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +  String.format("%010d",0) ; //중소기업창업투자조합출자의 경우는 0값이 나와야함
						else
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //소득,세액공제금액 : 10BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%04d", mTempData02); //중소기업창업투자조합출자의 경우는 년도가 들어감
						else
							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자연도 : 4BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%01d", mTempData02); //중소기업창업투자조합출자인경우 1,2,3중 하나
						else
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분 : 1BYTE
						
						//2022연말정산_추가 : 청년형장기집합투자증권저축 가입일,계약기간 추가 필요
						//가입일, 청년형 제외 나머지는 00000000
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%08d", mTempData02); //청년형장기집합투자증권저축 가입일
						else
							F_RecStr = F_RecStr +  String.format("%08d",0);	//가입일 
						//계약기간, 청년형 제외 나머지는 00
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("ctrTermMmCnt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%02d", mTempData02); //청년형장기집합투자증권저축 계약기간
						else
							F_RecStr = F_RecStr +  String.format("%02d",0);	//계약기간 
						////////


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
								+  String.format("%1s","")
								+  String.format("%08d", 0) //가입일
								+  String.format("%02d", 0); //계약기간

							F_RowCnt =  F_RowCnt + 1;
						}
						if (listYetaF.size() + 1 > F_RowCnt)  { //6
		                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))  //소득공제구분 : 2BYTE 
									+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  //금융기관코드 : 3BYTE
									+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  //금융기관상호 : 60BYTE
									+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ; //계좌번호 : 20BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0")); 
						F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //납입금액 : 10BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +  String.format("%010d",0) ; //중소기업창업투자조합출자의 경우는 0값이 나와야함
						else
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //소득,세액공제금액 : 10BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%04d", mTempData02); //중소기업창업투자조합출자의 경우는 년도가 들어감
						else
							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자연도 : 4BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%01d", mTempData02); //중소기업창업투자조합출자인경우 1,2,3중 하나
						else
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분 : 1BYTE
						
						//2022연말정산_추가 : 청년형장기집합투자증권저축 가입일,계약기간 추가 필요
						//가입일, 청년형 제외 나머지는 00000000
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%08d", mTempData02); //청년형장기집합투자증권저축 가입일
						else
							F_RecStr = F_RecStr +  String.format("%08d",0);	//가입일 
						//계약기간, 청년형 제외 나머지는 00
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("ctrTermMmCnt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%02d", mTempData02); //청년형장기집합투자증권저축 계약기간
						else
							F_RecStr = F_RecStr +  String.format("%02d",0);	//계약기간 
						////////

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
								+  String.format("%1s","")
								+  String.format("%08d", 0) //가입일
								+  String.format("%02d", 0); //계약기간

							F_RowCnt =  F_RowCnt + 1;
						}

						if (listYetaF.size() + 1 > F_RowCnt)  { //7
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))  //소득공제구분 : 2BYTE 
									+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  //금융기관코드 : 3BYTE
									+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  //금융기관상호 : 60BYTE
									+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ; //계좌번호 : 20BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0")); 
						F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //납입금액 : 10BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +  String.format("%010d",0) ; //중소기업창업투자조합출자의 경우는 0값이 나와야함
						else
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //소득,세액공제금액 : 10BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%04d", mTempData02); //중소기업창업투자조합출자의 경우는 년도가 들어감
						else
							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자연도 : 4BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%01d", mTempData02); //중소기업창업투자조합출자인경우 1,2,3중 하나
						else
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분 : 1BYTE
						
						//2022연말정산_추가 : 청년형장기집합투자증권저축 가입일,계약기간 추가 필요
						//가입일, 청년형 제외 나머지는 00000000
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%08d", mTempData02); //청년형장기집합투자증권저축 가입일
						else
							F_RecStr = F_RecStr +  String.format("%08d",0);	//가입일 
						//계약기간, 청년형 제외 나머지는 00
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("ctrTermMmCnt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%02d", mTempData02); //청년형장기집합투자증권저축 계약기간
						else
							F_RecStr = F_RecStr +  String.format("%02d",0);	//계약기간 
						////////


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
								+  String.format("%1s","")
								+  String.format("%08d", 0) //가입일
								+  String.format("%02d", 0); //계약기간

							F_RowCnt =  F_RowCnt + 1;
						}
						if (listYetaF.size() + 1 > F_RowCnt)  { //8
		                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))  //소득공제구분 : 2BYTE 
									+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  //금융기관코드 : 3BYTE
									+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  //금융기관상호 : 60BYTE
									+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ; //계좌번호 : 20BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0")); 
						F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //납입금액 : 10BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +  String.format("%010d",0) ; //중소기업창업투자조합출자의 경우는 0값이 나와야함
						else
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //소득,세액공제금액 : 10BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%04d", mTempData02); //중소기업창업투자조합출자의 경우는 년도가 들어감
						else
							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자연도 : 4BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%01d", mTempData02); //중소기업창업투자조합출자인경우 1,2,3중 하나
						else
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분 : 1BYTE
						
						
						//2022연말정산_추가 : 청년형장기집합투자증권저축 가입일,계약기간 추가 필요
						//가입일, 청년형 제외 나머지는 00000000
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%08d", mTempData02); //청년형장기집합투자증권저축 가입일
						else
							F_RecStr = F_RecStr +  String.format("%08d",0);	//가입일 
						//계약기간, 청년형 제외 나머지는 00
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("ctrTermMmCnt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%02d", mTempData02); //청년형장기집합투자증권저축 계약기간
						else
							F_RecStr = F_RecStr +  String.format("%02d",0);	//계약기간 
						////////


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
								+  String.format("%1s","")
								+  String.format("%08d", 0) //가입일
								+  String.format("%02d", 0); //계약기간

							F_RowCnt =  F_RowCnt + 1;
						}

						if (listYetaF.size() + 1 > F_RowCnt)  { //9
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))  //소득공제구분 : 2BYTE 
									+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  //금융기관코드 : 3BYTE
									+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  //금융기관상호 : 60BYTE
									+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ; //계좌번호 : 20BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0")); 
						F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //납입금액 : 10BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +  String.format("%010d",0) ; //중소기업창업투자조합출자의 경우는 0값이 나와야함
						else
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //소득,세액공제금액 : 10BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%04d", mTempData02); //중소기업창업투자조합출자의 경우는 년도가 들어감
						else
							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자연도 : 4BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%01d", mTempData02); //중소기업창업투자조합출자인경우 1,2,3중 하나
						else
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분 : 1BYTE
						
						//2022연말정산_추가 : 청년형장기집합투자증권저축 가입일,계약기간 추가 필요
						//가입일, 청년형 제외 나머지는 00000000
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%08d", mTempData02); //청년형장기집합투자증권저축 가입일
						else
							F_RecStr = F_RecStr +  String.format("%08d",0);	//가입일 
						//계약기간, 청년형 제외 나머지는 00
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("ctrTermMmCnt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%02d", mTempData02); //청년형장기집합투자증권저축 계약기간
						else
							F_RecStr = F_RecStr +  String.format("%02d",0);	//계약기간 
						////////

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
								+  String.format("%1s","")
								+  String.format("%08d", 0) //가입일
								+  String.format("%02d", 0); //계약기간

							F_RowCnt =  F_RowCnt + 1;
						}
						if (listYetaF.size() + 1 > F_RowCnt)  { //10
		                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))  //소득공제구분 : 2BYTE 
									+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  //금융기관코드 : 3BYTE
									+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  //금융기관상호 : 60BYTE
									+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ; //계좌번호 : 20BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0")); 
						F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //납입금액 : 10BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +  String.format("%010d",0) ; //중소기업창업투자조합출자의 경우는 0값이 나와야함
						else
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //소득,세액공제금액 : 10BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%04d", mTempData02); //중소기업창업투자조합출자의 경우는 년도가 들어감
						else
							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자연도 : 4BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%01d", mTempData02); //중소기업창업투자조합출자인경우 1,2,3중 하나
						else
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분 : 1BYTE
						
						//2022연말정산_추가 : 청년형장기집합투자증권저축 가입일,계약기간 추가 필요
						//가입일, 청년형 제외 나머지는 00000000
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%08d", mTempData02); //청년형장기집합투자증권저축 가입일
						else
							F_RecStr = F_RecStr +  String.format("%08d",0);	//가입일 
						//계약기간, 청년형 제외 나머지는 00
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("ctrTermMmCnt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%02d", mTempData02); //청년형장기집합투자증권저축 계약기간
						else
							F_RecStr = F_RecStr +  String.format("%02d",0);	//계약기간 
						////////

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
								+  String.format("%1s","")
								+  String.format("%08d", 0) //가입일
								+  String.format("%02d", 0); //계약기간

							F_RowCnt =  F_RowCnt + 1;
						}

						if (listYetaF.size() + 1 > F_RowCnt)  { //11
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))  //소득공제구분 : 2BYTE 
									+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  //금융기관코드 : 3BYTE
									+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  //금융기관상호 : 60BYTE
									+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ; //계좌번호 : 20BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0")); 
						F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //납입금액 : 10BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +  String.format("%010d",0) ; //중소기업창업투자조합출자의 경우는 0값이 나와야함
						else
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //소득,세액공제금액 : 10BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%04d", mTempData02); //중소기업창업투자조합출자의 경우는 년도가 들어감
						else
							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자연도 : 4BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%01d", mTempData02); //중소기업창업투자조합출자인경우 1,2,3중 하나
						else
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분 : 1BYTE
						
						//2022연말정산_추가 : 청년형장기집합투자증권저축 가입일,계약기간 추가 필요
						//가입일, 청년형 제외 나머지는 00000000
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%08d", mTempData02); //청년형장기집합투자증권저축 가입일
						else
							F_RecStr = F_RecStr +  String.format("%08d",0);	//가입일 
						//계약기간, 청년형 제외 나머지는 00
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("ctrTermMmCnt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%02d", mTempData02); //청년형장기집합투자증권저축 계약기간
						else
							F_RecStr = F_RecStr +  String.format("%02d",0);	//계약기간 
						////////


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
								+  String.format("%1s","")
								+  String.format("%08d", 0) //가입일
								+  String.format("%02d", 0); //계약기간

							F_RowCnt =  F_RowCnt + 1;
						}

						if (listYetaF.size() + 1 > F_RowCnt)  { //12
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))  //소득공제구분 : 2BYTE 
									+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  //금융기관코드 : 3BYTE
									+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  //금융기관상호 : 60BYTE
									+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ; //계좌번호 : 20BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0")); 
						F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //납입금액 : 10BYTE
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +  String.format("%010d",0) ; //중소기업창업투자조합출자의 경우는 0값이 나와야함
						else
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //소득,세액공제금액 : 10BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%04d", mTempData02); //중소기업창업투자조합출자의 경우는 년도가 들어감
						else
							F_RecStr = F_RecStr +  String.format("%04d",0);	//투자연도 : 4BYTE
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%01d", mTempData02); //중소기업창업투자조합출자인경우 1,2,3중 하나
						else
							F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분 : 1BYTE
						
						//2022연말정산_추가 : 청년형장기집합투자증권저축 가입일,계약기간 추가 필요
						//가입일, 청년형 제외 나머지는 00000000
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%08d", mTempData02); //청년형장기집합투자증권저축 가입일
						else
							F_RecStr = F_RecStr +  String.format("%08d",0);	//가입일 
						//계약기간, 청년형 제외 나머지는 00
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("ctrTermMmCnt"),"0"));
						if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%02d", mTempData02); //청년형장기집합투자증권저축 계약기간
						else
							F_RecStr = F_RecStr +  String.format("%02d",0);	//계약기간 
						////////


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
								+  String.format("%1s","")
								+  String.format("%08d", 0) //가입일
								+  String.format("%02d", 0); //계약기간

					F_RowCnt =  F_RowCnt + 1;
				}

				if (listYetaF.size() + 1 > F_RowCnt)  { //13
					F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))  //소득공제구분 : 2BYTE 
							+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  //금융기관코드 : 3BYTE
							+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  //금융기관상호 : 60BYTE
							+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ; //계좌번호 : 20BYTE
				mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0")); 
				F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //납입금액 : 10BYTE
				mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
				if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
					F_RecStr = F_RecStr +  String.format("%010d",0) ; //중소기업창업투자조합출자의 경우는 0값이 나와야함
				else
					F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //소득,세액공제금액 : 10BYTE
				
				//2020귀속 추가
				mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
				if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
					F_RecStr = F_RecStr +   String.format("%04d", mTempData02); //중소기업창업투자조합출자의 경우는 년도가 들어감
				else
					F_RecStr = F_RecStr +  String.format("%04d",0);	//투자연도 : 4BYTE
				
				//2020귀속 추가
				mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));
				if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
					F_RecStr = F_RecStr +   String.format("%01d", mTempData02); //중소기업창업투자조합출자인경우 1,2,3중 하나
				else
					F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분 : 1BYTE
				
				//2022연말정산_추가 : 청년형장기집합투자증권저축 가입일,계약기간 추가 필요
				//가입일, 청년형 제외 나머지는 00000000
				mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
				if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
					F_RecStr = F_RecStr +   String.format("%08d", mTempData02); //청년형장기집합투자증권저축 가입일
				else
					F_RecStr = F_RecStr +  String.format("%08d",0);	//가입일 
				//계약기간, 청년형 제외 나머지는 00
				mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("ctrTermMmCnt"),"0"));
				if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
					F_RecStr = F_RecStr +   String.format("%02d", mTempData02); //청년형장기집합투자증권저축 계약기간
				else
					F_RecStr = F_RecStr +  String.format("%02d",0);	//계약기간 
				////////


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
								+  String.format("%1s","")
								+  String.format("%08d", 0) //가입일
								+  String.format("%02d", 0); //계약기간

					F_RowCnt =  F_RowCnt + 1;
				}

				if (listYetaF.size() + 1 > F_RowCnt)  { //14
                     
					F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))  //소득공제구분 : 2BYTE 
							+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  //금융기관코드 : 3BYTE
							+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  //금융기관상호 : 60BYTE
							+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ; //계좌번호 : 20BYTE
				mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0")); 
				F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //납입금액 : 10BYTE
				mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
				if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
					F_RecStr = F_RecStr +  String.format("%010d",0) ; //중소기업창업투자조합출자의 경우는 0값이 나와야함
				else
					F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //소득,세액공제금액 : 10BYTE
				
				//2020귀속 추가
				mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
				if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
					F_RecStr = F_RecStr +   String.format("%04d", mTempData02); //중소기업창업투자조합출자의 경우는 년도가 들어감
				else
					F_RecStr = F_RecStr +  String.format("%04d",0);	//투자연도 : 4BYTE
				
				//2020귀속 추가
				mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));
				if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
					F_RecStr = F_RecStr +   String.format("%01d", mTempData02); //중소기업창업투자조합출자인경우 1,2,3중 하나
				else
					F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분 : 1BYTE
				
				//2022연말정산_추가 : 청년형장기집합투자증권저축 가입일,계약기간 추가 필요
				//가입일, 청년형 제외 나머지는 00000000
				mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
				if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
					F_RecStr = F_RecStr +   String.format("%08d", mTempData02); //청년형장기집합투자증권저축 가입일
				else
					F_RecStr = F_RecStr +  String.format("%08d",0);	//가입일 
				//계약기간, 청년형 제외 나머지는 00
				mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("ctrTermMmCnt"),"0"));
				if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
					F_RecStr = F_RecStr +   String.format("%02d", mTempData02); //청년형장기집합투자증권저축 계약기간
				else
					F_RecStr = F_RecStr +  String.format("%02d",0);	//계약기간 
				////////


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
								+  String.format("%1s","")
								+  String.format("%08d", 0) //가입일
								+  String.format("%02d", 0); //계약기간

					F_RowCnt =  F_RowCnt + 1;
				}

				if (listYetaF.size() + 1 > F_RowCnt)  { //15
                     
					F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))  //소득공제구분 : 2BYTE 
							+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  //금융기관코드 : 3BYTE
							+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  //금융기관상호 : 60BYTE
							+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ; //계좌번호 : 20BYTE
				mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0")); 
				F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //납입금액 : 10BYTE
				mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
				if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
					F_RecStr = F_RecStr +  String.format("%010d",0) ; //중소기업창업투자조합출자의 경우는 0값이 나와야함
				else
					F_RecStr = F_RecStr +  String.format("%010d",mTempData02); //소득,세액공제금액 : 10BYTE
				
				//2020귀속 추가
				mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
				if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
					F_RecStr = F_RecStr +   String.format("%04d", mTempData02); //중소기업창업투자조합출자의 경우는 년도가 들어감
				else
					F_RecStr = F_RecStr +  String.format("%04d",0);	//투자연도 : 4BYTE
				
				//2020귀속 추가
				mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));
				if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
					F_RecStr = F_RecStr +   String.format("%01d", mTempData02); //중소기업창업투자조합출자인경우 1,2,3중 하나
				else
					F_RecStr = F_RecStr +  String.format("%1s","");	//투자구분 : 1BYTE
				
				//2022연말정산_추가 : 청년형장기집합투자증권저축 가입일,계약기간 추가 필요
				//가입일, 청년형 제외 나머지는 00000000
				mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));
				if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
					F_RecStr = F_RecStr +   String.format("%08d", mTempData02); //청년형장기집합투자증권저축 가입일
				else
					F_RecStr = F_RecStr +  String.format("%08d",0);	//가입일 
				//계약기간, 청년형 제외 나머지는 00
				mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("ctrTermMmCnt"),"0"));
				if("81".equals(mapYetaF.get("rtpnAccRtpnCl")))
					F_RecStr = F_RecStr +   String.format("%02d", mTempData02); //청년형장기집합투자증권저축 계약기간
				else
					F_RecStr = F_RecStr +  String.format("%02d",0);	//계약기간 
				////////


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
								+  String.format("%1s","")
								+  String.format("%08d", 0) //가입일
								+  String.format("%02d", 0); //계약기간

					F_RowCnt =  F_RowCnt + 1;
				}


				F_RecStr = F_RecStr +  String.format("%02d",  F_RowCnt); //연금저축레코드 일련번호 : 2BYTE
				F_RecStr = F_RecStr + String.format("%-173s",""); //공란 : 323BYTE
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
               
               List listYetaG = yeta7400PayrService.fnPayrG_ReTax_Total_Select(infcPkgYe161020Vo);
                
 
               if ( listYetaG.size() > 0) { 
 
              	   Iterator<Map<String, Object>> iter05 = listYetaG.iterator(); 
             	   
                   while ( iter05.hasNext() ) { 
                    	
                     Map<String, Object> mapYetaG = (Map<String, Object>) iter05.next(); 
                       
                     if ((listYetaG.size() > 0) &&  (MSFSharedUtils.paramNotNull( mapYetaG.get("mnthRnttyBurRgsum")) 
                     ||  MSFSharedUtils.paramNotNull( mapYetaG.get("comrCdtrNm")) || MSFSharedUtils.paramNotNull( mapYetaG.get("rntlCttLehdrNm"))))  {
                     
                    	// 주민번호(복호화)
         				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
         		          	 
                       mTempData02 = 0L;

                       G_RecStr =  "G" + "20" + infcPkgYe161005Vo.getTxOffcCd()  +  String.format("%06d", C_Cnt) //레코드구분 : 1BYTE + 자료구분 : 2BYTE + 세무서코드 : 3BYTE + 일련번호 : 6BYTE
                    		   		+  String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-","")) //사업자등록번호 : 10BYTE
                                    + String.format("%-13s",rrnDecCrypt) 	//주민등록번호 : 13BYTE 
                       				//= 35BYTE
                                    
                                    //2021연말정산_추가
                       				+  String.format("%02d", 01); //무주택자해당여부 : 2BYTE
                       
                       if (listYetaG.size() + 1 > G_RowCnt)  {
                      
                    	  //월세액세액공제명세
          				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyBurRgsum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
          		          G_RecStr = G_RecStr + Han1(mapYetaG.get("mnthRnttyLehdrNm"),60)  //임대인성명 : 60BYTE
                                     +  String.format("%-13s", rrnDecCrypt);	//주민등록번호 : 13BYTE
                                   
                          G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyHusFrmCd"),"") ); //유형 : 1BYTE
                          G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyHusCnttArea"),"0.00")))),".",""); //계약면적 : 5BYTE

                          G_RecStr = G_RecStr +  Han1(mapYetaG.get("mnthRnttyRntlAddr"),150)  ; //주소지 : 150BYTE

                          G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlBgnnDt"),"") ;	//임대차계약기간개시일 : 8BYTE
                          G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlEndDt"),"") ;	//임대차계약기간종료일 : 8BYTE

                          mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyYrlyMnthSum"),"0"));  
                          G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	//연간월세액 : 10BYTE
                          mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyTxDducSum"),"0"));   
                          G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;	//세액공제금액 : 10BYTE //총 : 302BYTE

                          
                          //거주자간 주택임차차입금 원리금 상환액 소득공제명세 - 금전소비대차
                          rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("comrCdtrResnRegnNum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                      
                          G_RecStr = G_RecStr + Han1(mapYetaG.get("comrCdtrNm"),60) //대주성명 : 60BYTE
                                     + String.format("%-13s", rrnDecCrypt ) ;	//대주주민번호 : 13BYTE
                          G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("comrCnttPridBgnnDt"),"") ;	//계약기간개시일 : 8BYTE
                          G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("comrCnttPridEndDt"),"")  ;	//계약기간종료일 : 8BYTE

                          G_RecStr = G_RecStr +  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("comrLoanItrtRate"),"0.00")))),".","") ; //차입금이자율 : 4BYTE

                          mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrPclttAmtftAggr"),"0")); 
                          G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;	//원리금상환액계 : 10BYTE
                          mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrPrnilSum"),"0"));
                          G_RecStr = G_RecStr +  String.format("%010d",mTempData02); //원금 : 10BYTE
                          mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrItrtSum"),"0"));
                          G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ; //이자 : 10BYTE
                          mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrDducSum"),"0"));
                          G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	//공제금액 : 10BYTE //총 : 435BYTE

                          
                          //거주자간 주택임차차입금 원리금 상환액 소득공제명세 - 임대차계약
                          rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttBusoprRgstnum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                       
                          G_RecStr = G_RecStr + Han1(mapYetaG.get("rntlCttLehdrNm"),60)  //임대인성명 : 60BYTE
                                     + String.format("%-13s", rrnDecCrypt  );	//주민등록번호 : 13BYTE

                          G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttHusFrmCd"),"")   );	//유형 : 1BYTE
                          G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttHusCnttArea"),"0.00")))),".","")  ; //계약면적 : 5BYTE

                          G_RecStr = G_RecStr +  Han1(mapYetaG.get("rntlCttAddr"),150) ; //주소지 : 150BYTE
                          G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttPridBgnnDt"),"") ;	//계약기간개시일 : 8BYTE
                          G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttPridEndDt"),"")  ;	//계약기간종료일 : 8BYTE

                          mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttChrtrGrnteSum"),"0")); 
                          G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	//전세보증금 : 10BYTE //총 : 690BYTE

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
                                       + String.format("%-150s","")
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
                                       +  String.format("%-150s","")
                                       +  "00000000"
                                       +  "00000000"
                                       +  "0000000000";

                            G_RowCnt =  G_RowCnt + 1;
                     }
                       if (listYetaG.size() + 1 > G_RowCnt)  {
                    	   
                    	 //월세액세액공제명세
           				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyBurRgsum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
           		          G_RecStr = G_RecStr + Han1(mapYetaG.get("mnthRnttyLehdrNm"),60)  //임대인성명 : 60BYTE
                                      +  String.format("%-13s", rrnDecCrypt);	//주민등록번호 : 13BYTE
                                    
                           G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyHusFrmCd"),"") ); //유형 : 1BYTE
                           G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyHusCnttArea"),"0.00")))),".",""); //계약면적 : 5BYTE

                           G_RecStr = G_RecStr +  Han1(mapYetaG.get("mnthRnttyRntlAddr"),150)  ; //주소지 : 150BYTE

                           G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlBgnnDt"),"") ;	//임대차계약기간개시일 : 8BYTE
                           G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlEndDt"),"") ;	//임대차계약기간종료일 : 8BYTE

                           mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyYrlyMnthSum"),"0"));  
                           G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	//연간월세액 : 10BYTE
                           mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyTxDducSum"),"0"));   
                           G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;	//세액공제금액 : 10BYTE

                           
                           //거주자간 주택임차차입금 원리금 상환액 소득공제명세 - 금전소비대차
                           rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("comrCdtrResnRegnNum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                       
                           G_RecStr = G_RecStr + Han1(mapYetaG.get("comrCdtrNm"),60) //대주성명 : 60BYTE
                                      + String.format("%-13s", rrnDecCrypt ) ;	//대주주민번호 : 13BYTE
                           G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("comrCnttPridBgnnDt"),"") ;	//계약기간개시일 : 8BYTE
                           G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("comrCnttPridEndDt"),"")  ;	//계약기간종료일 : 8BYTE

                           G_RecStr = G_RecStr +  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("comrLoanItrtRate"),"0.00")))),".","") ; //차입금이자율 : 4BYTE

                           mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrPclttAmtftAggr"),"0")); 
                           G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;	//원리금상환액계 : 10BYTE
                           mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrPrnilSum"),"0"));
                           G_RecStr = G_RecStr +  String.format("%010d",mTempData02); //원금 : 10BYTE
                           mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrItrtSum"),"0"));
                           G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ; //이자 : 10BYTE
                           mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrDducSum"),"0"));
                           G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	//공제금액 : 10BYTE

                           
                           //거주자간 주택임차차입금 원리금 상환액 소득공제명세 - 임대차계약
                           rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttBusoprRgstnum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                        
                           G_RecStr = G_RecStr + Han1(mapYetaG.get("rntlCttLehdrNm"),60)  //임대인성명 : 60BYTE
                                      + String.format("%-13s", rrnDecCrypt  );	//주민등록번호 : 13BYTE

                           G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttHusFrmCd"),"")   );	//유형 : 1BYTE
                           G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttHusCnttArea"),"0.00")))),".","")  ; //계약면적 : 5BYTE

                           G_RecStr = G_RecStr +  Han1(mapYetaG.get("rntlCttAddr"),150) ; //주소지 : 150BYTE
                           G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttPridBgnnDt"),"") ;	//계약기간개시일 : 8BYTE
                           G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttPridEndDt"),"")  ;	//계약기간종료일 : 8BYTE

                           mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttChrtrGrnteSum"),"0")); 
                           G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	//전세보증금 : 10BYTE //총 : 1343BYTE

                           G_RowCnt =  G_RowCnt + 1;
                     
                           try {
                        	   mapYetaG = (Map<String, Object>) iter05.next(); 
                           } catch (NoSuchElementException e) {
                    		//e.printStackTrace();
                           }     
                       }else
                       {
                    	   G_RecStr = G_RecStr + String.format("%-60s","")
                                   + String.format("%-13s","")
                                   + String.format("%-1s","")
                                   +  "00000"
                                   + String.format("%-150s","")
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
                                   +  String.format("%-150s","")
                                   +  "00000000"
                                   +  "00000000"
                                   +  "0000000000";

	                   G_RowCnt =  G_RowCnt + 1;
                       }
                       if (listYetaG.size() + 1 > G_RowCnt)  {
                    	   
                    	 //월세액세액공제명세
            				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyBurRgsum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
            		          G_RecStr = G_RecStr + Han1(mapYetaG.get("mnthRnttyLehdrNm"),60)  //임대인성명 : 60BYTE
                                       +  String.format("%-13s", rrnDecCrypt);	//주민등록번호 : 13BYTE
                                     
                            G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyHusFrmCd"),"") ); //유형 : 1BYTE
                            G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyHusCnttArea"),"0.00")))),".",""); //계약면적 : 5BYTE

                            G_RecStr = G_RecStr +  Han1(mapYetaG.get("mnthRnttyRntlAddr"),150)  ; //주소지 : 150BYTE

                            G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlBgnnDt"),"") ;	//임대차계약기간개시일 : 8BYTE
                            G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlEndDt"),"") ;	//임대차계약기간종료일 : 8BYTE

                            mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyYrlyMnthSum"),"0"));  
                            G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	//연간월세액 : 10BYTE
                            mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyTxDducSum"),"0"));   
                            G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;	//세액공제금액 : 10BYTE

                            
                            //거주자간 주택임차차입금 원리금 상환액 소득공제명세 - 금전소비대차
                            rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("comrCdtrResnRegnNum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                        
                            G_RecStr = G_RecStr + Han1(mapYetaG.get("comrCdtrNm"),60) //대주성명 : 60BYTE
                                       + String.format("%-13s", rrnDecCrypt ) ;	//대주주민번호 : 13BYTE
                            G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("comrCnttPridBgnnDt"),"") ;	//계약기간개시일 : 8BYTE
                            G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("comrCnttPridEndDt"),"")  ;	//계약기간종료일 : 8BYTE

                            G_RecStr = G_RecStr +  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("comrLoanItrtRate"),"0.00")))),".","") ; //차입금이자율 : 4BYTE

                            mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrPclttAmtftAggr"),"0")); 
                            G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;	//원리금상환액계 : 10BYTE
                            mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrPrnilSum"),"0"));
                            G_RecStr = G_RecStr +  String.format("%010d",mTempData02); //원금 : 10BYTE
                            mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrItrtSum"),"0"));
                            G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ; //이자 : 10BYTE
                            mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrDducSum"),"0"));
                            G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	//공제금액 : 10BYTE

                            
                            //거주자간 주택임차차입금 원리금 상환액 소득공제명세 - 임대차계약
                            rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttBusoprRgstnum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                         
                            G_RecStr = G_RecStr + Han1(mapYetaG.get("rntlCttLehdrNm"),60)  //임대인성명 : 60BYTE
                                       + String.format("%-13s", rrnDecCrypt  );	//주민등록번호 : 13BYTE

                            G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttHusFrmCd"),"")   );	//유형 : 1BYTE
                            G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttHusCnttArea"),"0.00")))),".","")  ; //계약면적 : 5BYTE

                            G_RecStr = G_RecStr +  Han1(mapYetaG.get("rntlCttAddr"),150) ; //주소지 : 150BYTE
                            G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttPridBgnnDt"),"") ;	//계약기간개시일 : 8BYTE
                            G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttPridEndDt"),"")  ;	//계약기간종료일 : 8BYTE

                            mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttChrtrGrnteSum"),"0")); 
                            G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	//전세보증금 : 10BYTE //총 : 1996BYTE

                           G_RowCnt =  G_RowCnt + 1;
                     
                           try {
                        	   mapYetaG = (Map<String, Object>) iter05.next(); 
                           } catch (NoSuchElementException e) {
                    		//e.printStackTrace();
                           }     
                       }else
                       {
                    	   G_RecStr = G_RecStr + String.format("%-60s","")
                                   + String.format("%-13s","")
                                   + String.format("%-1s","")
                                   +  "00000"
                                   + String.format("%-150s","")
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
                                   +  String.format("%-150s","")
                                   +  "00000000"
                                   +  "00000000"
                                   +  "0000000000";

	                   G_RowCnt =  G_RowCnt + 1;
                       }

                       G_RecStr = G_RecStr +  String.format("%02d", G_Cnt) //월세액,거주자간주택임차차입금레코드 일련번호 : 2BYTE
                                      + String.format("%-12s",""); //공란 : 12BYTE //총 :ㅣ 2010BYTE

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
	            List listHCData = yeta7400PayrService.fnPayrHC_ReTax_Total_Select(infcPkgYe161020Vo);  
	             
	            
	            if (listHCData.size() <= 0) { 
	            	 
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
		               strTempDataH = "";
		               mTempDataH  = 0L;

		               strTempDataH =  "H" + "20" ; //레코드구분 : 1BYTE + 자료구분 : 2BYTE = 3BYTE
		               strTempDataH = strTempDataH + infcPkgYe161005Vo.getTxOffcCd(); //세무서코드 : 3BYTE
		               mTempDataH = Long.parseLong(String.valueOf(C_Cnt)); 
		               strTempDataH = strTempDataH +   String.format("%06d", mTempDataH);  //소득자일련번호 : 6BYTE
		               strTempDataH = strTempDataH  +  String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-","")) //사업자등록번호 : 10BYTE
		            		   		  + String.format("%-13s",rrnDecCrypt ) ;  //주민등록번호 : 13BYTE
		               mTempDataH =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("nnfClCd"),"1"));  
		               strTempDataH = strTempDataH +   String.format("%01d", mTempDataH); //내외국인구분코드 : 1BYTE  
		               
		               if ((1 != mTempDataH) && (9 != mTempDataH)) {
                     	
		               }  
		               
		               strTempDataH = strTempDataH  +   Han1(mapHCData.get("fnm"),30); //성명 : 30BYTE
		               strTempDataH = strTempDataH  +  String.format("%-2s",  MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),"")); //코드 : 2BYTE
                  
		               if (!"10".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))
		            		   && !"20".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	
		            		   && !"40".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	
		            		   && !"41".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	
		            		   && !"42".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	) {
		               }
                     
		               mTempDataH =  Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("attrYr"),"0")); 
		               strTempDataH = strTempDataH  +   String.format("%04d", mTempDataH);    //기부연도 : 4BYTE
                     
		               mTempDataH =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("useAmt"),"0"));   
		               strTempDataH = strTempDataH  +  String.format("%013d", mTempDataH);   //기부금액 : 13BYTE
		               mTempDataH =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("pyrDdcAmt"),"0"));   
		               strTempDataH = strTempDataH  +  String.format("%013d", mTempDataH);  //전년까지공제된금액 : 13BYTE
		               mTempDataH =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("ddcTrgtAmt"),"0"));   
		               strTempDataH = strTempDataH  + String.format("%013d", mTempDataH);  //공제대상금액  : 13BYTE
                     
		               strTempDataH = strTempDataH  + "0000000000000" ;   //해당년도공제금액 필요경비 : 13BYTE
                     
		               mTempDataH =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("thcYrDdcAmt"),"0"));  
		               strTempDataH = strTempDataH  + String.format("%013d", mTempDataH);//해당년도공제금액세액(소득)공제 : 13BYTE                        
		               mTempDataH =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("thcYrNducExtnAmt"),"0"));   
		               strTempDataH = strTempDataH  + String.format("%013d", mTempDataH); //해당년도공제받지못한금액소멸금액 : 13BYTE
		               mTempDataH =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("thcYrNducCrfwAmt"),"0"));   
		               strTempDataH = strTempDataH  + String.format("%013d", mTempDataH); //해당년도에 공제받지못한금액_이월금액  : 13BYTE
		               strTempDataH = strTempDataH  + String.format("%05d", H_RowCnt);       //기부금조정명세일련번호 : 5BYTE
		               strTempDataH = strTempDataH  + String.format("%1842s", ""); //공란 : 1842BYTE

	                   TOT_Record.add(strTempDataH);
	                   H_RowCnt = H_RowCnt + 1;

		          }
 
	               //---------------------------------------------------------------------------------
	               //I레코드 - 해당년도기부금 레코드  
	               //---------------------------------------------------------------------------------  
		          I_Cnt = 1;
		             
		          infcPkgYe161020Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
	              //I레코드 - 해당연도 기부명세 레코드  
	              List listHDData = yeta7400PayrService.fnPayrHD_ReTax_Total_Select(infcPkgYe161020Vo); 
	               
	             if (listHCData.size() > 0) { 
	              
	              Iterator<Map<String, Object>> iter02 = listHDData.iterator(); 
	        	   
		          while ( iter02.hasNext() ) { 
		            	
		            Map<String, Object> mapHDData = (Map<String, Object>) iter02.next();

	                strTempDataI = "";
	                mTempDataI  = 0L;

	                // 주민번호(복호화)
	                rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	                
	                strTempDataI =  "I" + "20"; //레코드구분 : 1BYTE + 자료구분 : 2BYTE
	                strTempDataI = strTempDataI + infcPkgYe161005Vo.getTxOffcCd();  //세무서코드 : 3BYTE
	                strTempDataI = strTempDataI + String.format("%06d", C_Cnt);     //소득자일련번호 : 6BYTE
	                strTempDataI = strTempDataI + String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-",""));   //사업자등록번호  : 10BYTE
                       
	                strTempDataI = strTempDataI +  String.format("%-13s", rrnDecCrypt);      //소득자주민등록번호 : 13BYTE
	                strTempDataI = strTempDataI +  String.format("%-2s",  MSFSharedUtils.defaultNulls(mapHDData.get("conbChgCd"),""));     //유형코드 : 2BYTE
	                
	                strTempDataI = strTempDataI +  String.format("%01d", 1);      //기부내용 :1BYTE
					   
                       
	                strTempDataI = strTempDataI +  String.format("%-13s", StringUtils.replace(MSFSharedUtils.defaultNulls(mapHDData.get("bsnoEncCntn"),""),"-",""));    //사업자등록번호 : 13BYTE

	                strTempDataI = strTempDataI + Han1(mapHDData.get("coplNm"),60);	//상호 : 60BYTE
                                        
	                strTempDataI = strTempDataI +  String.format("%-1s",  MSFSharedUtils.defaultNulls(mapHDData.get("cnbtRltChgCd"),""));  //관계코드 : 1BYTE
	                strTempDataI = strTempDataI +  String.format("%-1s",  MSFSharedUtils.defaultNulls(mapHDData.get("nnfClCd"),""));     //내외국인구분코드 : 1BYTE
                    strTempDataI = strTempDataI +  Han1(mapHDData.get("cnbtFnm"),30); 	//성명 : 30BYTE
                    // 주민번호(복호화)
                    rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapHDData.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                    
                    strTempDataI = strTempDataI +  String.format("%-13s", rrnDecCrypt);    //기부자주민등록번호 : 13BYTE
                    mTempDataI =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("dntScnt"),"1"));   
                    strTempDataI = strTempDataI +  String.format("%05d", mTempDataI);   //건수 : 5BYTE
                    
                    mTempDataI = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("useSumAmt"),"0"));   
                    strTempDataI = strTempDataI +  String.format("%013d", mTempDataI);     //기부금액 : 13BYTE

                    //2016년 추가 -----
                    mTempDataI = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ddcTrgtConbAmt"),"0"));   
                    strTempDataI = strTempDataI +  String.format("%013d", mTempDataI);     //공제대상기부금액 : 13BYTE
                    mTempDataI = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("conbSumAmt"),"0"));   
                    strTempDataI = strTempDataI +  String.format("%013d", mTempDataI);     //기부장려신청금액 : 13BYTE
                    
                    strTempDataI = strTempDataI +  "0000000000000";	//기타 : 13BYTE
                       
                    strTempDataI = strTempDataI + String.format("%05d", I_Cnt);    //일련번호 : 5BYTE
                       
                    strTempDataI = strTempDataI +  String.format("%1792s", "");    //공란 : 1792BYTE

	                   TOT_Record.add(strTempDataI);

	                      I_Cnt = I_Cnt + 1;
		           }
	             } 

	         
               C_Cnt = C_Cnt + 1;  
               
               //파일생성전 제출일자업데이트 쿼리 추가 
               // infcPkgYeta17FileDAO.updateYeta7400ToYe161010_S
              ye161010VO.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey"))); 
              yeta7400PayrService.updateYeta7400ToYe161010(ye161010VO); 

          } 
          
       
          
          File dir = new File("C:/EOSDATA/2022/");
          //디렉토리가 없으면 생성
          if(!dir.isDirectory()){
           dir.mkdirs();
          }
          
//        TOT_Record.SaveToFile('C:\EOSDATA\' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3) + '.denc');
          String fileDir = "C:/EOSDATA/2022/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc";
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
          
          File objFile = new File("C:/EOSDATA/2022/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc");
          
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
         

	   } catch (Exception ex) { 
		   ex.printStackTrace();
		   state = -1;   
 	   }
       return state;
    }
  
  public int fnYeta7400_Tax_Ye1611010_File_Create(HttpServletRequest request,InfcPkgYe161010_2022_VO  ye161010VO,HttpServletResponse response) throws Exception  {
	 
	  if  (yeta7400PayrService== null) {
		    WebApplicationContext wac = WebApplicationContextUtils.
		    		getRequiredWebApplicationContext( request.getSession().getServletContext());
		  
		    yeta7400PayrService = (Yeta7400PayrService) wac.getBean("Yeta7400PayrService");
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
	  
	  
	  return state;
  }
    
     /**
      * 
      * <pre>
      * 1. 개요 :  의료비 지급명세서 전자파일  
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : fnYeta1400_ReTax_Yeta7140_Create
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
  public int fnYeta7400_Tax_Ye164010_File_Create(HttpServletRequest request,InfcPkgYe161010_2022_VO  ye161010VO,HttpServletResponse response) throws Exception  {
    	
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
    		
    		 if  (yeta7400PayrService== null) {
    			    WebApplicationContext wac = WebApplicationContextUtils.
    			    		getRequiredWebApplicationContext( request.getSession().getServletContext());
    			  
    			    yeta7400PayrService = (Yeta7400PayrService) wac.getBean("Yeta7400PayrService");
    			}
    		  
    		
    		 InfcPkgYe161005_2022_VO    infcPkgYe161005Vo	 = new InfcPkgYe161005_2022_VO();	//A_원천세신고기본
    		 BeanUtils.copyProperties(infcPkgYe161005Vo, ye161010VO);
    		    
    		 infcPkgYe161005Vo  = yeta7400PayrService.selectYe161005(ye161010VO);

        	   String defBUNS_LINS = StringUtils.replace(MSFSharedUtils.allowNulls(infcPkgYe161005Vo.getBusoprRgstnum()),"-","") ; //사업자번호  
        	   
    		    
    	    InfcPkgYe161020_2022_VO    infcPkgYe161020Vo	 = new InfcPkgYe161020_2022_VO();	//A_인적소득공제기본
    	    BeanUtils.copyProperties(infcPkgYe161020Vo, ye161010VO);
    	     
    		// A레코드 - 의료비지급명세서 레코드
    		List listYetaCA = yeta7400PayrService.fnPayrPSNL_ReTax_CA_Total_Select(infcPkgYe161020Vo);

    		if  (listYetaCA.size() > 0) { 
 
    		 	A_Cnt = 1;
    		
    			  Iterator<Map<String, Object>> iter = listYetaCA.iterator(); 
    	      	   
    	          while ( iter.hasNext() ) { 
    	          
    	            Map<String, Object> mapCAData = (Map<String, Object>) iter.next();  
    		  //	for (int i = 0 ; i < listYeta1.size() ; i++) { 
    	            
    	            infcPkgYe161020Vo.setSystemkey(MSFSharedUtils.allowNulls(mapCAData.get("systemkey"))); 
    	            
    	            //A레코드 - 의료비지급명세서 레코드  내역 
    	            List listCAYeta = yeta7400PayrService.fnPayrCA_ReTax_Total_Select(infcPkgYe161020Vo);
    				
    	            Iterator<Map<String, Object>> iter01 = listCAYeta.iterator(); 
     	      	   
      	            while ( iter01.hasNext() ) { 
      	            	
      	            Map<String, Object> mapCAYeta = (Map<String, Object>) iter01.next(); 
      	            
	    				A_RecStr = "";
						A_RecStr = "A" + "26" + infcPkgYe161005Vo.getTxOffcCd(); //레코드구분 : 1BYTE + 자료구분 : 2BYTE + 세무서코드 : 3BYTE = 6BYTE
						A_RecStr = A_RecStr + String.format("%06d", A_Cnt); //일련번호 : 6BYTE
						A_RecStr = A_RecStr + StringUtils.replace(MSFSharedUtils.allowNulls(ye161010VO.getEdacPrdt()) ,"-","") ; //제출년월일 : 8BYTE
						A_RecStr = A_RecStr + defBUNS_LINS; //사업자등록번호 : 10BYTE
						A_RecStr = A_RecStr + String.format("%-20s", infcPkgYe161005Vo.getHmtxId()); //홈텍스ID : 20BYTE
						A_RecStr = A_RecStr + String.format("%-4s", infcPkgYe161005Vo.getTxPgmCd()); //세무프로그램코드 : 4BYTE
						A_RecStr = A_RecStr + "2022"; //귀속년도 : 4BYTE
						A_RecStr = A_RecStr + defBUNS_LINS; //사업자등록번호 : 10BYTE
						A_RecStr = A_RecStr + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(infcPkgYe161005Vo.getCorpFmnmNm() ,38),40," ") ; //상호 : 40BYTE

						/* 
						10번까지는 화면에서 받아온 vo (ye161010VO) 이용
						이후는 select 결과 vo (infcPkgYeta7140Vo) 이용*/

						// 주민번호(복호화)
						 String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapCAData.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						    		          	
						
						A_RecStr = A_RecStr +    String.format("%-13s",rrnDecCrypt ); //소득자주민등록번호 : 13BYTE
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAData.get("orgNnfClCd"),"1")); //내외국인코드 : 1BYTE
						A_RecStr = A_RecStr + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapCAData.get("fnm"),""),28),30 ," "); //성명 : 30BYTE
						
						A_RecStr = A_RecStr + String.format("%-10s", StringUtils.replace(MSFSharedUtils.defaultNulls(mapCAYeta.get("bsnoEncCntn"),""),"-",""));  //지급처사업자등록번호 : 10BYTE
						A_RecStr = A_RecStr + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapCAYeta.get("plymNm"),"") ,38),40," "); //지급처상호 : 40BYTE
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.allowNulls(mapCAYeta.get("mdxpsPrfClCd"))); //의료증빙코드 : 1BYTE
						//203
						mTempData01 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapCAYeta.get("scnt"),"0"));  
						A_RecStr = A_RecStr + String.format("%05d", mTempData01); //건수 : 5BYTE
						
						mTempData01 = Math.abs(Long.parseLong(MSFSharedUtils.defaultNulls(mapCAYeta.get("useAmt"),"0")));   
						A_RecStr = A_RecStr + String.format("%011d", mTempData01); //금액 : 11BYTE
						
						//2022연말정산_추가
						A_RecStr = A_RecStr + String.format("%-1s", ""); //미숙아
						
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAYeta.get("yn2"),""));   //난임시술비해당여부 : 1BYTE
						//220
						
						// 주민번호(복호화)
						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapCAYeta.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						   
						A_RecStr = A_RecStr + String.format("%-13s",rrnDecCrypt ); //주민번호 : 13BYTE				
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAYeta.get("nnfClCd"),"1")); //내외국인코드 : 1BYTE
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAYeta.get("yn"),"2")); //본인등해당여부 : 1BYTE
						A_RecStr = A_RecStr + "1"; //제출대상기간코드 : 1BYTE
										
						TOT_Record.add(A_RecStr);
							    
						A_Cnt = A_Cnt + 1;
	    				}
    			}
    		}
    		else {
    			throw new Exception("의료비 A레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.");  
    			//showMessage('의료비 A레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.');
    		}
    		
    		 File dir = new File("C:/EOSDATA/2022/");
	          //디렉토리가 없으면 생성
	          if(!dir.isDirectory()){
	           dir.mkdirs();
	          }
	          
    		//TOT_Record.SaveToFile('C:\EOSDATA\' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3) + '.denc');
    		      String fileDir = "C:/EOSDATA/2022/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc";
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
    	          
    	          File objFile = new File("C:/EOSDATA/2022/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc");
    	          
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
    	
 	   } catch (Exception ex) {
		   ex.printStackTrace();
		   state = -1;  
      }
    	
    	return state; 
    }
    
   
 /**
  * 
  * <pre>
  * 1. 개요 : 기부금 지급 명세서  
  * 2. 처리내용 : 
  * </pre>
  * @Method Name : fnYeta1400_ReTax_Yeta7180_Create
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
  public int fnYeta7400_Tax_Ye165010_File_Create(HttpServletRequest request,InfcPkgYe161010_2022_VO  ye161010VO,HttpServletResponse response) throws Exception { 
  
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
// 	       Map mapHb = yeta7400PayrService.fnPayrHB_ReTax_Total_Select(ye161010VO);
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
//	          mTempDataB =    Long.parseLong( MSFSharedUtils.defaultNulls(mapHb.get("yeta7180Cnt"),"0"));     
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
// 	         List listTotData01 = yeta7400PayrService.fnPayrPSNL_ReTax_Total_Select(ye161010VO);
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
//	            List listHCData = yeta7400PayrService.fnPayrHC_ReTax_Total_Select(ye161010VO);  
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
// 	              List listHDData = yeta7400PayrService.fnPayrHD_ReTax_Total_Select(ye161010VO); 
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
 
  
 

  public List<YetaMessageVO> fnYeta7400_Tax_Ye161010_File_Check(HttpServletRequest request,InfcPkgYe161010_2022_VO  ye161010VO,HttpServletResponse response) throws Exception  {
	  
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
      
       return bmResult;
    }
    
     /**
      * 
      * <pre>
      * 1. 개요 :  의료비 지급명세서 전자파일  
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : fnYeta1400_ReTax_Yeta7140_Create
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
  public List<YetaMessageVO> fnYeta7400_Tax_Ye164010_File_Check(HttpServletRequest request,InfcPkgYe161010_2022_VO  ye161010VO,HttpServletResponse response) throws Exception  {
    	
    	 List<YetaMessageVO>  bmResult = new ArrayList<YetaMessageVO>();
    	
    	String DEFIN = "CA";
   // 	String defBUNS_LINS = StringUtils.replace(ye161010VO.getBusiNumb(),"-","") ; //사업자번호
    	String A_RecStr;
    	ArrayList<String> A_Record = new ArrayList<String>();    	
    	ArrayList<String> TOT_Record = new ArrayList<String>();
    	int A_Cnt;
    	Long mTempData01;    	
    	return bmResult; 
    }
    
   
 /**
  * 
  * <pre>
  * 1. 개요 : 기부금 지급 명세서  
  * 2. 처리내용 : 
  * </pre>
  * @Method Name : fnYeta1400_ReTax_Yeta7180_Create
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
 public List<YetaMessageVO> fnYeta7400_Tax_Ye165010_File_Check(HttpServletRequest request,InfcPkgYe161010_2022_VO  ye161010VO,HttpServletResponse response) throws Exception { 
  
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
