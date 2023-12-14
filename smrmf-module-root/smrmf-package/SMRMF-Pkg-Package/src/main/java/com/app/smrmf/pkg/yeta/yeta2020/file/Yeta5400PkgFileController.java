package com.app.smrmf.pkg.yeta.yeta2020.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.text.DecimalFormat;
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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161005_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161020_2020_VO;
import com.app.smrmf.pkg.yeta.yeta2020.file.service.Yeta5400PayrService;

import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class Yeta5400PkgFileController {

    private static final Logger logger = LoggerFactory.getLogger(Yeta5400PkgFileController.class);  
    
    @Resource(name = "Yeta5400PayrService")
    private Yeta5400PayrService yeta5400PayrService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService; 
    
    
    public Yeta5400PkgFileController() {
    	
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
	public int fnYeta5400_Tax_Ye161010_File_Create(HttpServletRequest request,InfcPkgYe161010_2020_VO  ye161010VO,HttpServletResponse response) throws Exception  {

		if  (yeta5400PayrService== null) {
			WebApplicationContext wac = WebApplicationContextUtils.
			getRequiredWebApplicationContext( request.getSession().getServletContext());

			yeta5400PayrService = (Yeta5400PayrService) wac.getBean("Yeta5400PayrService");
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
		String mTempData03 = "";
		Long sTempData01 = 0L;
		Long sTempData02 = 0L;
		Long sTempData03 = 0L;
		Long sTempData04 = 0L;
		Long sTempData05 = 0L;
		Long sTempData06 = 0L;
		Long sTempData07 = 0L;
		Long sTempData08 = 0L;
		Long sTempData09 = 0L;
		Long sTempData10 = 0L;
		Long sTempData11 = 0L;
		Long sTempData12 = 0L;
		Long sTempData13 = 0L;
		Long sTempData14 = 0L;
		Long sTempData15 = 0L;
		Long sTempData16 = 0L;
		Long sTempData17 = 0L;
		Long sTempData18 = 0L;
		Long sTempData19 = 0L;
		Long sTempData20 = 0L;
		
		Long pTempData03 = 0L;
		Long pTempData04 = 0L;
		Long pTempData05 = 0L;
		Long pTempData06 = 0L;
		Long pTempData07 = 0L;
		Long pTempData08 = 0L;
		Long pTempData09 = 0L;
		Long pTempData10 = 0L;
		Long pTempData11 = 0L;
		Long pTempData12 = 0L;
		Long pTempData13 = 0L;
		Long pTempData14 = 0L;
		Long pTempData15 = 0L;
		Long pTempData16 = 0L;
		Long pTempData17 = 0L;
		Long pTempData18 = 0L;
		Long pTempData19 = 0L;
		Long pTempData20 = 0L;
		
		Long hTempData01 = 0L;
		Long hTempData02 = 0L;
		Long hTempData03 = 0L;
		Long hTempData04 = 0L;
		Long hTempData05 = 0L;
		Long hTempData06 = 0L;
		Long hTempData07 = 0L;
		Long hTempData08 = 0L;
		Long hTempData09 = 0L;
		Long hTempData10 = 0L;
		Long hTempData11 = 0L;
		Long hTempData12 = 0L;
		Long hTempData13 = 0L;
		Long hTempData14 = 0L;
		Long hTempData15 = 0L;
		Long hTempData16 = 0L;
		Long hTempData17 = 0L;
		Long hTempData18 = 0L;
		Long hTempData19 = 0L;
		Long hTempData20 = 0L;
		Long hTempData21 = 0L;
		Long hTempData22 = 0L;
		Long hTempData23 = 0L;
		Long hTempData24 = 0L;
		Long hTempData25 = 0L;
		Long hTempData26 = 0L;
		Long hTempData27 = 0L;
		
		Long hSumTempData = 0L;
		
		Long oTempData09 = 0L;
		
		Long eTempData01 = 0L;
		Long eTempData02 = 0L;
		Long eTempData03 = 0L;
		Long eTempData04 = 0L;
		Long eTempData05 = 0L;
		Long eTempData06 = 0L;
		Long eTempData07 = 0L;
		Long eTempData08 = 0L;
		Long eTempData09 = 0L;
		Long eTempData10 = 0L;
		
		Long eSumTempData = 0L;
		
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
		InfcPkgYe161005_2020_VO    infcPkgYe161005Vo	 = new InfcPkgYe161005_2020_VO();	//A_원천세신고기본
		BeanUtils.copyProperties(infcPkgYe161005Vo, ye161010VO);

		infcPkgYe161005Vo  = yeta5400PayrService.selectYe161005(ye161010VO);

		//인적기본데이터를 가지고온다. 조회처리 루틴 추가 
		InfcPkgYe161020_2020_VO    infcPkgYe161020Vo	 = new InfcPkgYe161020_2020_VO();	//A_인적소득공제기본
		BeanUtils.copyProperties(infcPkgYe161020Vo, ye161010VO);
		//{근로소득지급명세서}
		/********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		/********************************************************암호화 처리 를 위해 반드시 해야 함................................*/   

		DEFIN = "C"; //근로소득
       
        defBUNS_LINS = StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-","");   //사업자번호
      
		A_Record = ("A" + "20" + infcPkgYe161005Vo.getTxOffcCd() //레코드타입(1byte)  + 근로소득구분(2byte) + 세무서코드(3byte) = 6byte
					+ String.format("%08d", Long.parseLong(StringUtils.replace(ye161010VO.getEdacPrdt(),"-",""))) //제출년월일(8byte) = 14byte
                    + String.format("%01d", Long.parseLong( infcPkgYe161005Vo.getPentrSeptCd() )) //제출자구분(1byte) : 1(세무대리인), 2(법인), 3(개인) = 15byte
                    + String.format("%-6s", MSFSharedUtils.defaultNulls(infcPkgYe161005Vo.getTxDeptyMangeNum(),"")) //세무대리인관리번호(6byte), 필수공란  = 21byte
                    + Han1(infcPkgYe161005Vo.getHmtxId(), 20) //홈텍스id(20byte) 아이디필수,남는자리공란  = 41byte
                    + String.format("%-4s", infcPkgYe161005Vo.getTxPgmCd()) //세무프로그램코드(4byte) , 기타프로그램 9000 = 45byte
                    + String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-","")) //사업자등록번호(10byte), 공란,오타이면 오류  = 55byte
                    + Han1(infcPkgYe161005Vo.getCorpFmnmNm(), 60)  //법인명(60byte) 공란시 오류  = 115byte
                    + Han1(infcPkgYe161005Vo.getPernChrgDeptNm(), 30)   //담당부서(30byte) 공란시 오류 = 145byte
                    + Han1(infcPkgYe161005Vo.getPernChrgNm(), 30)  //담당자이름(30byte) = 175byte 
                    + String.format("%-15s", infcPkgYe161005Vo.getPernChrgPhnNum()) //담당자전화번호(15byte) 공란시 오류 = 190byte
                    + "2020" //귀속년도(4byte) , 2020 = 194byte
                    + String.format("%05d", 1) + "101" //신고의무자 수(5byte), B레코드수와 다를시 오류 + 사용한글코드(3byte), 101아니면 오류 = 202byte
                    + String.format("%1691s", "")); //기존 "%1880s" -> 변경 후 "%1691s" ,공란아니면 오류

		TOT_Record.add(A_Record);
		
		B_Cnt = 1;
		mTempData01 = 0L;
        
		try {
			Map mapYetaB = yeta5400PayrService.fnPayrB_ReTax_Total_Select(infcPkgYe161020Vo); 

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
 

			B_RecStr = "B" + "20" + infcPkgYe161005Vo.getTxOffcCd() +  String.format("%06d", B_Cnt)  
						//레코드구분(1byte) + 자료구분(2byte),20아니면 오류 + 세무서코드(3byte) + 일련번호(6byte) ,1부터 순차부여 공란없음 = 12byte
						+ String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-","")) // 사업자등록번호(10byte) = 22byte
					    + Han1(infcPkgYe161005Vo.getCorpFmnmNm(), 60)  //법인명(60byte) = 82byte
                        + Han1(infcPkgYe161005Vo.getReprName(), 30) //대표자성명(30byte) = 112byte
                        + String.format("%-13s", StringUtils.replace(RSNOSTR,"-","")) + "2020"; //주민등록번호(13byte) + 귀속년도(4byte),2020 = 129byte
			
			mTempData01 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("psnlJuCnt"),"0"));
			B_RecStr =  B_RecStr + String.format("%07d", mTempData01);    //주근무지 레코드 수 (7byte) = 136byte
			
			mTempData01 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("psnlJungCnt"),"0"));  
			B_RecStr =  B_RecStr + String.format("%07d", mTempData01);     //종전근무지 레코드 수 (7byte) = 143byte

			mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("yeta0c63"),"0")); 
			B_RecStr =  B_RecStr + String.format("%014d", mTempData01);   //총급여 총계_현전(14byte) = 157byte, 총급여금액 정상출력됨
			
			mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("yetaC159"),"0"));  
			B_RecStr =  B_RecStr   +  String.format("%013d", mTempData01);    //결정세액 소득세 (13byte) = 170byte
			
			mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("yetaC160"),"0"));    
			B_RecStr =  B_RecStr  + String.format("%013d", mTempData01);   //결정세액 지방소득세(13byte) = 183byte
			
			mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("yetaC161"),"0"));  
			B_RecStr =  B_RecStr   + String.format("%013d", mTempData01);    //결정세액 농특세(13byte) = 196byte
			
			mTempData01 =   Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaB.get("yetaSumAll"),"0")); 
			B_RecStr =  B_RecStr  + String.format("%013d", mTempData01);    //결정세액 총계(13byte) = 209byte
			B_RecStr =  B_RecStr  + "1"; //체출기간 연간합산제출등 코드로 등록하여 처리 하게 수정 필요  제출대상기간코드(1byte), 1 : 연간 합산제출 = 210byte
			B_RecStr =  B_RecStr +  String.format("%1683s", "");     //공란(1872byte) -> 공란 (1683byte)변경

			TOT_Record.add(B_RecStr);

			C_Cnt =  1;
           
            //c레코드 주현근무처 레코드 fnPayrC_ReTax_Total_Select
			List listYetaC = yeta5400PayrService.fnPayrC_ReTax_Total_Select(infcPkgYe161020Vo);
            
			if (listYetaC.size() <= 0) {  
				throw new Exception("C레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.");  
			} 

			Iterator<Map<String, Object>> iter = listYetaC.iterator(); 
			while ( iter.hasNext() ) { 
				Map<String, Object> mapYetaC = (Map<String, Object>) iter.next();  
				
				mTempData02 = 0L;
				mTempData03 = "";
				
				sTempData01 = 0L;
				sTempData02 = 0L;
				sTempData03 = 0L;
				sTempData04 = 0L;
				sTempData05 = 0L;
				sTempData06 = 0L;
				sTempData07 = 0L;
				sTempData08 = 0L;
				sTempData09 = 0L;
				sTempData10 = 0L;
				sTempData11 = 0L;
				sTempData12 = 0L;
				sTempData13 = 0L;
				sTempData14 = 0L;
				sTempData15 = 0L;
				sTempData16 = 0L;
				sTempData17 = 0L;
				sTempData18 = 0L;
				sTempData19 = 0L;
				sTempData20 = 0L;
				
				pTempData03 = 0L;
				pTempData04 = 0L;
				pTempData05 = 0L;
				pTempData06 = 0L;
				pTempData07 = 0L;
				pTempData08 = 0L;
				pTempData09 = 0L;
				pTempData10 = 0L;
				pTempData11 = 0L;
				pTempData12 = 0L;
				pTempData13 = 0L;
				pTempData14 = 0L;
				pTempData15 = 0L;
				pTempData16 = 0L;
				pTempData17 = 0L;
				pTempData18 = 0L;
				pTempData19 = 0L;
				pTempData20 = 0L;
				
				logger.debug("sTempData01 = " + sTempData01 );
				logger.debug("sTempData02 = " + sTempData02 );
				logger.debug("sTempData03 = " + sTempData03 );
				logger.debug("sTempData04 = " + sTempData04 );
				logger.debug("sTempData05 = " + sTempData05 );
				logger.debug("sTempData06 = " + sTempData06 );
				logger.debug("sTempData07 = " + sTempData07 );
				logger.debug("sTempData08 = " + sTempData08 );
				logger.debug("sTempData09 = " + sTempData09 );
				logger.debug("sTempData10 = " + sTempData10 );
				logger.debug("sTempData11 = " + sTempData11 );
				logger.debug("sTempData12 = " + sTempData12 );
				logger.debug("sTempData13 = " + sTempData13 );
				logger.debug("sTempData14 = " + sTempData14 );
				logger.debug("sTempData15 = " + sTempData15 );
				logger.debug("sTempData16 = " + sTempData16 );
				logger.debug("sTempData17 = " + sTempData17 );
				logger.debug("sTempData18 = " + sTempData18 );
				logger.debug("sTempData19 = " + sTempData19 );
				logger.debug("sTempData20 = " + sTempData20 );
				
				logger.debug("pTempData03 = " + pTempData03 );
				logger.debug("pTempData04 = " + pTempData04 );
				logger.debug("pTempData05 = " + pTempData05 );
				logger.debug("pTempData06 = " + pTempData06 );
				logger.debug("pTempData07 = " + pTempData07 );
				logger.debug("pTempData08 = " + pTempData08 );
				logger.debug("pTempData09 = " + pTempData09 );
				logger.debug("pTempData10 = " + pTempData10 );
				logger.debug("pTempData11 = " + pTempData11 );
				logger.debug("pTempData12 = " + pTempData12 );
				logger.debug("pTempData13 = " + pTempData13 );
				logger.debug("pTempData14 = " + pTempData14 );
				logger.debug("pTempData15 = " + pTempData15 );
				logger.debug("pTempData16 = " + pTempData16 );
				logger.debug("pTempData17 = " + pTempData17 );
				logger.debug("pTempData18 = " + pTempData18 );
				logger.debug("pTempData19 = " + pTempData19 );
				logger.debug("pTempData20 = " + pTempData20 );
				
				
				
				C_RecStr = "";
				
				//2020귀속 추가
				//변수 추가 후 산출세액에서 세액공제차감하기
				//산출세액 YETA_C113
				sTempData01 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC113"),"0"));    
				//근로소득세액공제 - YE169010 = YETA_C120 -C
				sTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC120"),"0"));    
				//자녀세액공제 - YETA_C122 -C
				sTempData03 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC122"),"0"));    
				//출산입양공제 - YETA_C125 -C
				sTempData04 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC126"),"0"));    
				//연금계좌 과학기술인 세액공제액 - YETA_C128 -C
				sTempData05 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC128"),"0"));   
				//연금계좌 퇴직연금 세액공제액 - YETA_C130 -C
				sTempData06 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC130"),"0"));    
				//연금계좌 연금저축 세액공제액 - YETA_C132 -C
				sTempData07 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC132"),"0"));    
				//특별세액공제 보장성보험료 세액공제액(장애인적용 보장성 보험료 포함) - YETA_C134 + YETA_C136 -C(레코드에서는 각 항목별 세액공제액이 따로있다)
				sTempData08 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC134"),"0"));    
				sTempData09 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC136"),"0"));    
				//특별세액공제 의료비 세액공제액 - YETA_C138 -C
				sTempData10 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC138"),"0"));    
				//특별세액공제 교육비 세액공제액 - YETA_C140 -C
				sTempData11 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC140"),"0"));    
				//특별세액공제 정치자금기부금(10만이하) 세액공제액 - YETA_C142 -C
				sTempData12 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC142"),"0"));    
				//특별세액공제 정치자금기부금(10만초과) 세액공제액 - YETA_C144 -C
				sTempData13 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC144"),"0"));    
				//특별세액공제 법정기부금 세액공제액 - YETA_C146 -C
				sTempData14 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC146"),"0"));    
				//특별세액공제 우리사주조합기부금 세액공제액 - YETA_C148 -C
				sTempData15 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC148"),"0"));    
				//특별세액공제 지정기부금 세액공제액 - YETA_C150 + YETA_C150B(종교단체외 + 종교단체) -C(레코드에서는 각 항목별 세액공제액이 따로있다)
				sTempData16 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC150"),"0"));    
				sTempData17 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC150b"),"0"));
				//월세액
				sTempData18 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC157"),"0"));
				
				//특별세액공제계 - 보장성보험세액공제액 + 장애인전용보험세액공제액 + 의료비세액공제액 + 교육비세액공제액 + 정치자금기부금세액공제액_10만원이하분 + 
				//			정치자금기부금세액공제액_10만원초과분 + 법정기부금_세액공제액 + 우리사주조합기부금_세액공제액 + 지정기부금_세액공제액	
				//			YETA_C151
				sTempData19 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC151"),"0")); 
				
				//세액공제계 - 근로소득+자녀+출산･입양자+연금계좌(과학기술인+근로자퇴직급여+연금저축)+
				//		    특별세액공제(보장성보험료+장애인전용보장성보험료+의료비+교육비+정치자금기부금_10만원이하+정치자금기부금_10만원초과+법정기부금+우리사주조합기부금+지정기부금)
				//		  +표준세액공제+납세조합공제+주택차입금+외국납부+월세세액공제
				// 	      YETA_C158
				sTempData20 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC158"),"0"));
				
				logger.debug("sTempData011 = " + sTempData01 );
				logger.debug("sTempData021 = " + sTempData02 );
				logger.debug("sTempData031 = " + sTempData03 );
				logger.debug("sTempData041 = " + sTempData04 );
				logger.debug("sTempData051 = " + sTempData05 );
				logger.debug("sTempData061 = " + sTempData06 );
				logger.debug("sTempData071 = " + sTempData07 );
				logger.debug("sTempData081 = " + sTempData08 );
				logger.debug("sTempData091 = " + sTempData09 );
				logger.debug("sTempData101 = " + sTempData10 );
				logger.debug("sTempData111 = " + sTempData11 );
				logger.debug("sTempData121 = " + sTempData12 );
				logger.debug("sTempData131 = " + sTempData13 );
				logger.debug("sTempData141 = " + sTempData14 );
				logger.debug("sTempData151 = " + sTempData15 );
				logger.debug("sTempData161 = " + sTempData16 );
				logger.debug("sTempData171 = " + sTempData17 );
				logger.debug("sTempData181 = " + sTempData18 );
				logger.debug("sTempData191 = " + sTempData19 );
				logger.debug("sTempData201 = " + sTempData20 );
				
				//자녀세액공제금액 정하기
				if(sTempData01 - sTempData02 == 0){ //산출세액 - 근로소득공제금액이 0 이면
					pTempData03 = 0L;	// 자녀세액공제금액은 0 
				}
				else if((sTempData01 - sTempData02 > 0)&&(sTempData01 - sTempData02 - sTempData03 >= 0))
				{ //산출세액-근로소득공제금액이 0보다 크고 (그 금액 - 자녀세액공제금액이 0 보다 크거나 같으면)
					pTempData03 = sTempData03; //자녀세액공제금액 그대로
				}
				else if((sTempData01 - sTempData02 > 0)&&(sTempData01 - sTempData02 - sTempData03 < 0)){
					//산출세액 - 근로소득공제금액이 0보다 크고 그금액 - 자녀세액공제금액이 0보다 작으면
					pTempData03 = sTempData01 - sTempData02;
					//자녀세액공제금액은 산출세액 - 근로소득금액
				}
				
				logger.debug("pTempData03 = " + pTempData03 );
				
				//출산입양세액공제정하기
				if(sTempData01 - sTempData02 - pTempData03 == 0){
					pTempData04 = 0L;	
				}
				else if((sTempData01 - sTempData02 - pTempData03 > 0)&&(sTempData01 - sTempData02 - pTempData03 - sTempData04 >= 0))
				{
					pTempData04 = sTempData04;
				}
				else if((sTempData01 - sTempData02 - pTempData03 > 0)&&(sTempData01 - sTempData02 - pTempData03 - sTempData04 < 0)){
					pTempData04 = sTempData01 - sTempData02 - pTempData03;
				}
				
				logger.debug("pTempData04 = " + pTempData04 );
				
				//연금계좌과학기술인 세액공제
				if(sTempData01 - sTempData02 - pTempData03 - pTempData04 == 0){
					pTempData05 = 0L;	
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 > 0)&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - sTempData05 >= 0))
				{
					pTempData05 = sTempData05;
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 > 0)&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - sTempData05 < 0)){
					pTempData05 = sTempData01 - sTempData02 - pTempData03 - pTempData04;
				}
				
				logger.debug("pTempData05 = " + pTempData05 );
				
				//연금계좌퇴직연금세액공제금액
				if(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 == 0){
					pTempData06 = 0L;	
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - sTempData06 >= 0))
				{
					pTempData06 = sTempData06;
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - sTempData06 < 0)){
					pTempData06 = sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05;
				}
				
				logger.debug("pTempData06 = " + pTempData06 );
				
				//연금저축세액공제금액
				if(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 == 0){
					pTempData07 = 0L;	
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - sTempData07 >= 0))
				{
					pTempData07 = sTempData07;
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - sTempData07 < 0)){
					pTempData07 = sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06;
				}
				
				logger.debug("pTempData07 = " + pTempData07 );
				
				//보장성보험료세액공제금액
				if(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 == 0){
					pTempData08 = 0L;	
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - sTempData08 >= 0))
				{
					pTempData08 = sTempData08;
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - sTempData08 < 0)){
					
					pTempData08 = sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07;
				}
				
				logger.debug("pTempData08 = " + pTempData08 );
				
				//장애인보장성보험
				if(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 == 0){
					pTempData09 = 0L;	
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 - sTempData09 >= 0))
				{
					pTempData09 = sTempData09;
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 - sTempData09 < 0)){
					
					pTempData09 = sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08;
				}
				
				logger.debug("pTempData09 = " + pTempData09 );
				
				//의료비세액공제
				if(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 - pTempData09 == 0){
					pTempData10 = 0L;	
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 - pTempData09 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 - pTempData09 - sTempData10 >= 0))
				{
					pTempData10 = sTempData10;
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 - pTempData09 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 - pTempData09 - sTempData10 < 0)){
					
					pTempData10 = sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 - pTempData09;
				}
				
				logger.debug("pTempData10 = " + pTempData10 );
				
				//교육비세액공제
				if(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 - pTempData09 - pTempData10 == 0){
					pTempData11 = 0L;	
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 - pTempData09 - pTempData10 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
								- pTempData09 - pTempData10 - sTempData11 >= 0))
				{
					pTempData11 = sTempData11;
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 - pTempData09 - pTempData10 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
								- pTempData09 - pTempData10 - sTempData11 < 0)){
					
					pTempData11 = sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 - pTempData09 - pTempData10;
				}
				
				logger.debug("pTempData11 = " + pTempData11 );
				
				//정치자금기부금(10만이하) 세액공제
				if(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 - pTempData09 - pTempData10 - pTempData11 == 0){
					pTempData12 = 0L;	
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 - pTempData09 - pTempData10 - pTempData11 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
								- pTempData09 - pTempData10 - pTempData11 - sTempData12 >= 0))
				{
					pTempData12 = sTempData12;
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 - pTempData09 - pTempData10 - pTempData11 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
								- pTempData09 - pTempData10 - pTempData11 - sTempData12 < 0)){
					
					pTempData12 = sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 
							- pTempData07 - pTempData08 - pTempData09 - pTempData10 - pTempData11;
				}
				
				logger.debug("pTempData12 = " + pTempData12 );
				
				
				//정치자금(10만초과) 세액공제
				if(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
						- pTempData09 - pTempData10 - pTempData11 - pTempData12 == 0){
					pTempData13 = 0L;	
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 
						- pTempData08 - pTempData09 - pTempData10 - pTempData11 - pTempData12 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
								- pTempData09 - pTempData10 - pTempData11 - pTempData12 - sTempData13 >= 0))
				{
					pTempData13 = sTempData13;
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 
						- pTempData08 - pTempData09 - pTempData10 - pTempData11 - pTempData12 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
								- pTempData09 - pTempData10 - pTempData11 - pTempData12 - sTempData13 < 0)){
					
					pTempData13 = sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 
							- pTempData07 - pTempData08 - pTempData09 - pTempData10 - pTempData11 - pTempData12;
				}
				
				logger.debug("pTempData13 = " + pTempData13 );
				
				
				//법정기부금
				if(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
						- pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 == 0){
					pTempData14 = 0L;	
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 
						- pTempData08 - pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
								- pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - sTempData14 >= 0))
				{
					pTempData14 = sTempData14;
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 
						- pTempData08 - pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
								- pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - sTempData14 < 0)){
					
					pTempData14 = sTempData01 - sTempData02  - pTempData03 - pTempData04 - pTempData05 - pTempData06 
							- pTempData07 - pTempData08 - pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13;
				}
				
				logger.debug("pTempData14 = " + pTempData14 );
				
				
				//우리사주기부금
				if(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
						- pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 == 0){
					pTempData15 = 0L;	
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 
						- pTempData08 - pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
								- pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - sTempData15 >= 0))
				{
					pTempData15 = sTempData15;
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 
						- pTempData08 - pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
								- pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - sTempData15 < 0)){
					
					pTempData15 = sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 
							- pTempData07 - pTempData08 - pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14;
				}
				
				logger.debug("pTempData15 = " + pTempData15 );
				
				
				//지정기부금(종교외)
				if(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
						- pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - pTempData15 == 0){
					pTempData16 = 0L;	
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 
						- pTempData08 - pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - pTempData15 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
								- pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - pTempData15 - sTempData16 >= 0))
				{
					pTempData16 = sTempData16;
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 
						- pTempData08 - pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - pTempData15 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
								- pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - pTempData15 - sTempData16 < 0)){
					
					pTempData16 = sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 
							- pTempData07 - pTempData08 - pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - pTempData15;
				}
				
				logger.debug("pTempData16 = " + pTempData16 );
				
				//지정기부금(종교)
				if(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
						- pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - pTempData15 - pTempData16 == 0){
					pTempData17 = 0L;	
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 
						- pTempData08 - pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - pTempData15 - pTempData16 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
								- pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - pTempData15 - pTempData16 - sTempData17 >= 0))
				{
					pTempData17 = sTempData17;
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 
						- pTempData08 - pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - pTempData15 - pTempData16 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
								- pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - pTempData15 - pTempData16 - sTempData17 < 0)){
					
					pTempData17 = sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 
							- pTempData07 - pTempData08 - pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - pTempData15 - pTempData16;
				}
				
				logger.debug("pTempData17 = " + pTempData17 );
				
				
				//특별세액공제계
				pTempData20 = pTempData08 + pTempData09 + pTempData10 + pTempData11 + pTempData12 + pTempData13 + pTempData14 + pTempData15 + pTempData16 + pTempData17;
				
				logger.debug("pTempData20 = " + pTempData20 );
				
				//월세액공제금액
				if(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
						- pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - pTempData15 - pTempData16 - pTempData17 == 0){
					pTempData18 = 0L;	
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 
						- pTempData08 - pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - pTempData15 - pTempData16 - pTempData17 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
								- pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - pTempData15 - pTempData16 - pTempData17 - sTempData18 >= 0))
				{
					pTempData18 = sTempData18;
				}
				else if((sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 
						- pTempData08 - pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - pTempData15 - pTempData16 - pTempData17 > 0)
						&&(sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 - pTempData07 - pTempData08 
								- pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - pTempData15 - pTempData16 - pTempData17 - sTempData18 < 0)){
					
					pTempData18 = sTempData01 - sTempData02 - pTempData03 - pTempData04 - pTempData05 - pTempData06 
							- pTempData07 - pTempData08 - pTempData09 - pTempData10 - pTempData11 - pTempData12 - pTempData13 - pTempData14 - pTempData15 - pTempData16 - pTempData17;
				}
				
				logger.debug("pTempData18 = " + pTempData18 );
				
				//세액공제계 = 근로소득공제 + 자녀 + 출산입양 + 연금 + 특별세액 + 표준세액 + 납세조합공제 + 주택차입금 + 외국납부 + 월세액
				pTempData19 = sTempData02 + pTempData20 + pTempData03 + pTempData04 + pTempData05 + pTempData06 + pTempData07 
						+ pTempData18 + Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC152"),"0"))
						+ Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC153"),"0"));
				
				
				logger.debug("pTempData19 = " + pTempData19 );
				
				
				
				
				hTempData01 = 0L;
				hTempData02 = 0L;
				hTempData03 = 0L;
				hTempData04 = 0L;
				hTempData05 = 0L;
				hTempData06 = 0L;
				hTempData07 = 0L;
				hTempData08 = 0L;
				hTempData09 = 0L;
				hTempData10 = 0L;
				hTempData11 = 0L;
				hTempData12 = 0L;
				hTempData13 = 0L;
				hTempData14 = 0L;
				hTempData15 = 0L;
				hTempData16 = 0L;
				hTempData17 = 0L;
				hTempData18 = 0L;
				hTempData19 = 0L;
				hTempData20 = 0L;
				hTempData21 = 0L;
				hTempData22 = 0L;
				hTempData23 = 0L;
				hTempData24 = 0L;
				hTempData25 = 0L;
				hTempData26 = 0L;
				hTempData27 = 0L;
				
				hSumTempData = 0L;
				
				oTempData09 = 0L;
				
				hTempData01 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c65"),"0")); //근로소득공제금액
				hTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c66"),"0"));  //본인공제금액
				hTempData03 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c67"),"0")); //배우자공제금액
				hTempData04 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c69"),"0"));   //부양가족공제금액
				hTempData05 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c71"),"0"));  //경로우대공제금액
				hTempData06 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c73"),"0"));   //장애인공제금액
				hTempData07 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c74"),"0")); //부녀자공제금액
				hTempData08 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c75"),"0"));   //한부모가족공제금액
				hTempData09 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c76"),"0"));    //국민연금보험료공제_공제금액
				hTempData10 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c77"),"0"));    //공무원연금_공제금액
				hTempData11 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c78"),"0"));    //군인연금_공제금액
				hTempData12 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c79"),"0"));    //사립학교교직원연금_공제금액
				hTempData13 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c80"),"0")); //별정우체국연금_공제금액
				hTempData14 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c81"),"0"));   //건강보험료_공제금액
				hTempData15 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c82"),"0"));    //고용보험료_공제금액
				hTempData16 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c83"),"0"));  //주택임차차입금_원리금상환액_대출기관
				hTempData17 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c84"),"0"));  //주택임차차입금_원리금상환액_거주자
				hTempData18 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c85"),"0"));    //특별공제_11장기주택저당차입금15
				hTempData19 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c86"),"0"));      //특별공제_11장기주택저당차입금29
				hTempData20 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c87"),"0"));      //특별공제_11장기주택저당차입금30
				hTempData21 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c88"),"0"));     //특별공제_12장기주택저당차입금_고정
				hTempData22 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c89"),"0"));    //특별공제_12장기주택저당차입금_기타
				hTempData23 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c90"),"0"));   //특별공제_15장기주택저당_15고정AND비거치상환
				hTempData24 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c91"),"0"));     //특별공제_15장기주택저당_15고정OR비거치상환
				hTempData25 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c92"),"0"));     //특별공제_15장기주택저당_15기타대출
				hTempData26 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c93"),"0"));      //특별공제_15장기주택저당_10고정OR비거치상환
				hTempData27 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c94"),"0"));     //이월분  특별공제_기부금공제액계
				
				hSumTempData = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c97"),"0")); //차감소득금액
						/*hTempData01 - (hTempData02+hTempData03+hTempData04+hTempData05
						+hTempData06+hTempData07+hTempData08+hTempData10+hTempData11+hTempData12+hTempData13+hTempData14+hTempData15+hTempData16+hTempData17+hTempData18
						+hTempData19+hTempData20+hTempData21+hTempData22+hTempData23+hTempData24+hTempData25+hTempData26+hTempData27);*/
				
				
				eTempData01 = 0L;
				eTempData02 = 0L;
				eTempData03 = 0L;
				eTempData04 = 0L;
				eTempData05 = 0L;
				eTempData06 = 0L;
				eTempData07 = 0L;
				eTempData08 = 0L;
				eTempData09 = 0L;
				eTempData10 = 0L;
				
				eSumTempData = 0L;
				
				eTempData01 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c98"),"0"));     //개인연금저축불입액_2000년이전
				eTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c99"),"0"));    //소기업,소상공인공제부금
				eTempData03 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC100"),"0"));   //기타공제_주택마련저축_청약저축
				eTempData04 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC101"),"0"));    //기타공제_주택마련저축_주택청약종합저축
				eTempData05 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC102"),"0"));   //기타공제_주택마련저축_근로자주택마련저축
				eTempData06 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC103"),"0"));        //기타공제_투자조합출자공제액
				eTempData07 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC104"),"0"));     //타공제_신용카드등사용액소득공제
				eTempData08 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC105"),"0"));       //기타공제_우리사주출연금공제
				eTempData09 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC107"),"0"));       //기타공제_고용유지중소기업근로자임금삭감공제액
				eTempData10 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC109"),"0"));      //기타공제_장기집합투자증권저축공제액
				
				eSumTempData = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC110"),"0"));      //그밖의소득공제계
				
				
				
				
				if(hSumTempData <= 0){
					//근로소득금액 <= 국민연금을 제외한 인적공제,추가공제,연금보험료공제,특별소득공제금액의 합 이면
					
					//이후 그밖의소득공제금액에 관한 항목과 그밖의소득공제계는 전부 0이 되어야한다
					eTempData01 = 0L;
					eTempData02 = 0L;
					eTempData03 = 0L;
					eTempData04 = 0L;
					eTempData05 = 0L;
					eTempData06 = 0L;
					eTempData07 = 0L;
					eTempData08 = 0L;
					eTempData09 = 0L;
					eTempData10 = 0L;
					
					eSumTempData = 0L;
					
				}else if(hSumTempData > 0){
					//근로소득금액  > 국민연금을 제외한 인적공제,추가공제,연금보험료공제,특별소득공제금액의 합 이면
					//그밖의 소득공제액에서 나머지 금액을 순차적으로 공제해준다
					//그래도 남으면 국민연금 공제액을 이후 나머지금액에서 공제해준다
					if(hSumTempData - eTempData01 <= 0){
						
						eTempData01 = hSumTempData;
						
					}else if(hSumTempData - eTempData01 > 0){
						
						eTempData01 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c98"),"0"));
						
						if(hSumTempData - eTempData01 - eTempData02 <= 0){
							
							eTempData02 = hSumTempData - eTempData01;
							
						}else if(hSumTempData - eTempData01 - eTempData02 > 0){
							
							eTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c99"),"0"));
							
							if(hSumTempData - eTempData01 - eTempData02 - eTempData03 <= 0){
								
								eTempData03 = hSumTempData - eTempData01 - eTempData02;
								
							}else if(hSumTempData - eTempData01 - eTempData02 - eTempData03 > 0){
								
								eTempData03 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC100"),"0"));
								
								if(hSumTempData - eTempData01 - eTempData02 - eTempData03 - eTempData04 <= 0){
									
									eTempData04 = hSumTempData - eTempData01 - eTempData02 - eTempData03;
									
								}else if(hSumTempData - eTempData01 - eTempData02 - eTempData03 - eTempData04 > 0){
									
									eTempData04 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC101"),"0"));
									
									if(hSumTempData - eTempData01 - eTempData02 - eTempData03 - eTempData04 - eTempData05 <= 0){
										
										eTempData05 = hSumTempData - eTempData01 - eTempData02 - eTempData03 - eTempData04;
										
									}else if(hSumTempData - eTempData01 - eTempData02 - eTempData03 - eTempData04 - eTempData05 > 0){
										
										eTempData05 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC102"),"0"));
										
										if(hSumTempData - eTempData01 - eTempData02 - eTempData03 - eTempData04 - eTempData05 - eTempData06  <= 0){
											
											eTempData06 = hSumTempData - eTempData01 - eTempData02 - eTempData03 - eTempData04 - eTempData05;
											
										}else if(hSumTempData - eTempData01 - eTempData02 - eTempData03 - eTempData04 - eTempData05 - eTempData06  > 0){
											
											eTempData06 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC103"),"0"));
											
											if(hSumTempData - eTempData01 - eTempData02 - eTempData03 - eTempData04 - eTempData05 - eTempData06 - eTempData07  <= 0){
												
												eTempData07 = hSumTempData - eTempData01 - eTempData02 - eTempData03 - eTempData04 - eTempData05 - eTempData06;
												
											}else if(hSumTempData - eTempData01 - eTempData02 - eTempData03 - eTempData04 - eTempData05 - eTempData06 - eTempData07 > 0){
												
												eTempData07 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC104"),"0"));     //타공제_신용카드등사용액소득공제
												
												if(hSumTempData - eTempData01 - eTempData02 - eTempData03 - eTempData04 - eTempData05 - eTempData06 
														- eTempData07 - eTempData08  <= 0){
													
													eTempData08 = hSumTempData - eTempData01 - eTempData02 - eTempData03 - eTempData04 - eTempData05 - eTempData06 - eTempData07;
													
												}else if(hSumTempData - eTempData01 - eTempData02 - eTempData03 - eTempData04 - eTempData05 
														- eTempData06 - eTempData07 - eTempData08  <= 0){
													
													eTempData08 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC105"),"0"));
													
													if(hSumTempData - eTempData01 - eTempData02 - eTempData03 - eTempData04 - eTempData05 - eTempData06 
															- eTempData07 - eTempData08 - eTempData09  <= 0){
														
														eTempData09 = hSumTempData - eTempData01 - eTempData02 - eTempData03 
																- eTempData04 - eTempData05 - eTempData06 - eTempData07 - eTempData08;
														
													}else if(hSumTempData - eTempData01 - eTempData02 - eTempData03 - eTempData04 - eTempData05 - eTempData06 
															- eTempData07 - eTempData08 - eTempData09  > 0){
														
														eTempData09 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC107"),"0"));
														
														if(hSumTempData - eTempData01 - eTempData02 - eTempData03 - eTempData04 - eTempData05 - eTempData06 
																- eTempData07 - eTempData08 - eTempData09 - eTempData10  <= 0){
															
															eTempData10 = hSumTempData - eTempData01 - eTempData02 - eTempData03 
																	- eTempData04 - eTempData05 - eTempData06 - eTempData07 - eTempData08 - eTempData09;
															
														}else if(hSumTempData - eTempData01 - eTempData02 - eTempData03 - eTempData04 - eTempData05 - eTempData06 
																- eTempData07 - eTempData08 - eTempData09 - eTempData10  > 0){
															
															eTempData10 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC109"),"0"));
															
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
					
					eSumTempData = eTempData01 + eTempData02 + eTempData03 + eTempData04 + eTempData05 + eTempData06 + eTempData07 + eTempData08 + eTempData09 + eTempData10;
				}
				
				
				
				
               //  oraQrySelect01.FieldByName('CITY_SEQN').AsString; Format('%.11d', [])
				C_RecStr = "C" ;   //레코드구분(1byte) = 1byte
				C_RecStr = C_RecStr + "20"; //자료구분 (2byte) = 3byte
				C_RecStr = C_RecStr   + infcPkgYe161005Vo.getTxOffcCd(); //세무서코드(3byte) = 6byte
				C_RecStr = C_RecStr + String.format("%06d", C_Cnt);    //일련번호(6byte) = 12byte
				C_RecStr = C_RecStr  +  String.format("%-10s", StringUtils.replace(MSFSharedUtils.allowNulls(mapYetaC.get("bsnoEncCntn")),"-",""));  //사업자등록번호(10byte) = 22byte 
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta00c6"),"0")); //종전근무처 수(2byte) = 24byte  
				C_RecStr = C_RecStr  + String.format("%02d",mTempData02);	
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("rsdtClCd"),"1")); //거주구분코드(1byte) = 25byte
				C_RecStr = C_RecStr  + String.format("%01d", mTempData02);
				
				C_RecStr = C_RecStr  + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaC.get("redtGbcd"),"")  ); //거주지국코드(2byte) = 27byte
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta00c9"),"2"));  //외국인단일세율적용여부(1byte), 1 or 2 = 28byte
				C_RecStr = C_RecStr  + String.format("%01d", mTempData02) ;

				C_RecStr = C_RecStr  + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c9a"),"2")  );  //외국법인소속 파견근로자여부(1byte), 1 or 2 = 29byte  

				//C_RecStr = C_RecStr  + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaC.get("fnm"),"") ,28),30," ") ;    //성명	- 누적길이 59
				C_RecStr = C_RecStr  + Han1(mapYetaC.get("fnm"), 30);    //성명(30byte) = 59byte
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("nnfClCd"),"1"));  //내외국인구부노드(1byte) , 1 or 9 = 60byte
				C_RecStr = C_RecStr  +  String.format("%01d",  mTempData02) ;
                             
				// 주민번호(복호화)
				String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				C_RecStr = C_RecStr  + String.format("%-13s",rrnDecCrypt);     //주민등록번호	(13byte) = 73byte
				
				C_RecStr = C_RecStr  + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaC.get("rsplNtnInfrCd"),"") ); //국적코드(2byte) = 75byte
				C_RecStr = C_RecStr  + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("hshrClCd"),"") ); //세대주구분코드(1byte) , 1 or 2 = 76byte
				C_RecStr = C_RecStr   + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaC.get("hoofStcd"),"")) ; //연말정산구분(1byte) , 1 or 2 = 77byte
				C_RecStr = C_RecStr   + "2";	//사업자단위 과세여부(1byte) , 1 or 2 = 78byte
				C_RecStr = C_RecStr   + String.format("%-4s", "") + "2"; //종사업장 일련번호(4byte) + 종교관련종사자여부(1byte) , 1 or 2 = 83byte
				C_RecStr = C_RecStr   + String.format("%-10s", StringUtils.replace(MSFSharedUtils.allowNulls(mapYetaC.get("bsnoEncCntn")),"-","")) ;//주현근무처 사업자등록번호	(10byte) = 93byte
				C_RecStr = C_RecStr   + Han1(mapYetaC.get("tnm"),60) ;	//주현근무처 근무처명(60byte) = 153byte


				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dtyStrtDt"),"0"));	//근무기간시작연월일(8byte) = 161byte
				C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);	
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("dtyEndDt"),"0"));	//근무기간 종료일자(8byte) = 169byte
				C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);	
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("reStrtDt"),"0"));	//감면기간시작일자(8byte) = 177byte(0으로나옴)
				C_RecStr = C_RecStr  +  String.format("%08d",  mTempData02) ;	
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("reEndDt"),"0")); //감면기간종료일자(8byte) = 185byte(0으로나옴)
				C_RecStr = C_RecStr  +  String.format("%08d", mTempData02);
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c22"),"0"));	//급여총액(11byte) = 196byte
				C_RecStr = C_RecStr  + String.format("%011d", mTempData02);
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c23"),"0"));	//상여총액(11byte) = 207byte
				C_RecStr = C_RecStr  + String.format("%011d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c24"),"0")); //인정상여(11byte) = 218byte
				C_RecStr = C_RecStr  + String.format("%011d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c25"),"0"));	//주식행사이익(11byte) = 229byte
				C_RecStr = C_RecStr  + String.format("%011d",  mTempData02) ;
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c26"),"0"));	//우리사주조합인출금(11byte) = 240byte
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c27"),"0"));	//임원 퇴직소득금액 한도초과액(11byte) = 251byte
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);

				C_RecStr = C_RecStr   + String.format("%011d", 0);	//직무발명보상금(11byte) = 262byte

				C_RecStr = C_RecStr   + String.format("%022d", 0);	//공란(11byte) + 공란(11byte) = 284byte

				C_RecStr = C_RecStr   +  String.format("%011d", Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c29"),"0"))) ; //주현근무처 소득합계(11byte) = 295byte

				//주현근무처 비과세소득 및 감면소득  
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta_C30G01"),"0"));  //비과세학자금(10byte) = 305byte
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta_C31H01"),"0"));	//무보수  위원수당(10byte) = 315byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta_C32H05"),"0"));  //경호,승선수당(10byte) = 325byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta_C33H06"),"0"));	//유아,초중등(10byte) = 335byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta_C34H07"),"0"));  //고등교육법(10byte) = 345byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta_C35H08"),"0"));  //특별법(10byte) = 355byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC36H09"),"0"));  //연구기관등(10byte) = 365byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC37H10"),"0"));  //기업부설연구소(10byte) = 375byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC38H14"),"0"));  //보육교사근무환경개선금액(10byte) = 385byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC39H15"),"0"));  //사립유치원수석교사,인건비(10byte) = 395byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC40H11"),"0"));  //취재수당(10byte) = 405byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC41H12"),"0"));  //벽지수당(10byte) = 415byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC42H13"),"0"));  //재해관련급여(10byte) = 425byte
				C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02);	
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC43H16"),"0"));  //공공기관지방이전기관종사자 이주수당(10byte) = 435byte
				C_RecStr = C_RecStr    +  String.format("%010d",  mTempData02);	

				C_RecStr = C_RecStr   + String.format("%010d", 0);	//종교활동비(10byte) = 445byte

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC44I01"),"0"));  //외국정부등근무자(10byte) = 455byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC45K01"),"0"));  //외국주둔군인등(10byte) = 465byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC46M01"),"0")); //국외근로100만원(10byte) = 475byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC47M02"),"0"));  //국외근로300만원(10byte) = 485byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC48M03"),"0"));  //국외근로(10byte) = 495byte
				C_RecStr = C_RecStr  +  String.format("%010d",  mTempData02) ;
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC49O01"),"0")); //야간근로수당(10bytte) = 505byte
				C_RecStr = C_RecStr   +  String.format("%010d", mTempData02)  ;
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC50Q01"),"0")); //출산보육수당(10byte) = 515byte
				C_RecStr = C_RecStr  +  String.format("%010d", mTempData02) ;	
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC51R10"),"0")); //근로장학금(10byte) = 525byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC52R11"),"0"));  //직무발명보상금(10byte) = 535byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC53S01"),"0")); //주식매수선택권(10byte) = 545byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02) ;	

				C_RecStr = C_RecStr   + String.format("%010d", 0);	//벤처기업 주식매수선택권(10byte) = 555byte

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC55Y02"),"0"));  //우리사주조합인출금 50%(10byte) = 565byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				//2016년 귀속 추가 
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC56Y03"),"0"));  //우리사주조합인출금 75%(10byte) = 575byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				//2017년추가 
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC56aY04"),"0"));  //우리사주조합인출금 100%(10byte) = 585byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC57Y22"),"0")); //전공의수련 보조수당(10byte) = 595byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				
				C_RecStr = C_RecStr   + String.format("%010d", 0);	//외국인기술자소득세감면 50%(10byte) = 605byte
				//2019 귀속 추가
				C_RecStr = C_RecStr   + String.format("%010d", 0); // 성과공유중소기업경영성과급(10byte) = 615byte			
				C_RecStr = C_RecStr   + String.format("%010d", 0); // 중소기업핵심인력성과보상기금소득세감면(10byte) = 625byte
				
				//2020귀속추가
				C_RecStr = C_RecStr   + String.format("%010d", 0); //내국인 우수인력 국내복귀 소득세감면(10byte) = 635byte
				
				//2016년귀속 추가 
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC58aT11"),"0")); //중소기업취업자 소득세감면 50%(10byte) = 645byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC58bT12"),"0")); //중소기업취업자 소득세감면 70%(10byte) = 655byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);

				C_RecStr = C_RecStr   + String.format("%010d", 0);	//중소기업취업자 소득세감면 90%(10byte) = 665byte

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC59T20"),"0")); //조세조약상 고직자감면(10byte) = 675byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				
				//2020귀속추가
				C_RecStr = C_RecStr   + String.format("%010d", 0); //외국인기술자 소득세감면 70%(10byte) = 685byte
				
				//2020귀속추가
				C_RecStr = C_RecStr   + String.format("%030d", 0); //공란(10byte) + 공란(10byte) + 공란(10byte) = 715byte

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c60"),"0"));    //비과세계(10byte) = 725byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c61"),"0"));   //감면소득계(10byte) = 735byte
				C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);

				//정산명세 처리 시작    
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c63"),"0"));  //총급여(11byte) = 746byte         
				C_RecStr = C_RecStr   +  String.format("%011d", mTempData02);
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c64"),"0"));   //근로소득공제(10byte) = 756byte    
				C_RecStr = C_RecStr   +  String.format("%010d", mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c65"),"0"));    //근로소득금액(11byte) = 767byte
				C_RecStr = C_RecStr   +  String.format("%011d", mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c66"),"0"));  //본인공제금액(8byte) = 775byte      
				C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c67"),"0")); //배우자공제금액(8byte) = 783byte         
				C_RecStr = C_RecStr   +  String.format("%08d",  mTempData02);
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c68"),"0"));   //부양가족공제인원(2byte) = 785byte 
				C_RecStr = C_RecStr   + String.format("%02d", mTempData02) ;
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c69"),"0"));   //부양가족공제금액(8byte) = 793byte    
				C_RecStr = C_RecStr   + String.format("%08d",mTempData02)  ;
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c70"),"0"));  //경로우대공제인원(2byte) = 795byte       
				C_RecStr = C_RecStr   + String.format("%02d",mTempData02);
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c71"),"0"));  //경로우대공제금액(8byte) = 803byte 
				C_RecStr = C_RecStr   + String.format("%08d", mTempData02) ;
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c72"),"0"));  //장애인공제인원(2byte) = 805byte   
				C_RecStr = C_RecStr   + String.format("%02d",mTempData02);
				
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c73"),"0"));   //장애인공제금액(8byte) = 813byte     
				C_RecStr = C_RecStr   + String.format("%08d", mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c74"),"0")); //부녀자공제금액(8byte) = 821byte      
				C_RecStr = C_RecStr   + String.format("%08d", mTempData02);

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c75"),"0"));   //한부모가족공제금액(10byte) = 831byte         
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;

				//연금보험료공제 
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c76"),"0"));    //국민연금보험료공제_대상금액(10byte) = 841byte       
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c76"),"0"));    //국민연금보험료공제_공제금액(10byte) = 851byte       
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;

				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c77"),"0"));    //공무원연금_대상금액(10byte) = 861byte
				C_RecStr = C_RecStr  + String.format("%010d",  mTempData02);
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c77"),"0"));    //공무원연금_공제금액(10byte) = 871byte   
				C_RecStr = C_RecStr  + String.format("%010d",  mTempData02);

				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c78"),"0"));    //군인연금_대상금액(10byte) = 881byte 
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c78"),"0"));    //군인연금_공제금액(10byte) = 891byte  
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ; 

				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c79"),"0"));    //사립학교교직원연금_대상금액(10byte) = 901byte
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c79"),"0"));    //사립학교교직원연금_공제금액(10byte) = 911byte
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c80"),"0"));        //별정우체국연금_대상금액(10byte) = 921byte 
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c80"),"0"));        //별정우체국연금_공제금액(10byte) = 931byte 
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);

				//특별소득공제 
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c81"),"0"));   //건강보험료_대상금액(10byte) = 941byte  
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c81"),"0"));   //건강보험료_공제금액(10byte) = 951byte   
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;	

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c82"),"0"));    //고용보험료_대상금액(10byte) = 961byte 
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c82"),"0"));    //고용보험료_공제금액(10byte) = 971byte
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);	
				
				// 주택자금(주택임차차입금,장기주택저당차입금,주택마련저축) 관련공통사항 
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c83"),"0"));  //주택임차차입금_원리금상환액_대출기관(8byte) = 979byte  
				C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c84"),"0"));  //주택임차차입금_원리금상환액_거주자(8byte) = 987byte
				C_RecStr = C_RecStr   + String.format("%08d",  mTempData02) ; 
	   
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c85"),"0"));    //특별공제_11장기주택저당차입금15(8byte) = 995byte  
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c86"),"0"));      //특별공제_11장기주택저당차입금29(8byte) = 1003byte   
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c87"),"0"));      //특별공제_11장기주택저당차입금30(8byte) = 1011byte   
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02); 
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c88"),"0"));     //특별공제_12장기주택저당차입금_고정 (8byte) = 1019byte    
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c89"),"0"));    //특별공제_12장기주택저당차입금_기타 (8byte) = 1027byte
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02);

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c90"),"0"));   //특별공제_15장기주택저당_15고정AND비거치상환 (8byte) = 1035byte
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c91"),"0"));     //특별공제_15장기주택저당_15고정OR비거치상환(8byte) = 1043byte
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c92"),"0"));     //특별공제_15장기주택저당_15기타대출(8byte) = 1051byte
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c93"),"0"));      //특별공제_15장기주택저당_10고정OR비거치상환 (8byte) = 1059byte
				C_RecStr = C_RecStr  + String.format("%08d", mTempData02);

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c94"),"0"));     //이월분  특별공제_기부금공제액계(11byte) = 1070byte   
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02);

				C_RecStr = C_RecStr   + String.format("%022d", 0);	//공란(11byte) + 공란(11byte) = 1092byte

				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c96"),"0"));   //특별소득공제계(11byte) = 1103byte
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c97"),"0"));       //차감소득금액(11byte) = 1114byte
				C_RecStr = C_RecStr  + String.format("%011d", mTempData02);

				//그 밖의 소득공제  
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c98"),"0"));     //개인연금저축불입액_2000년이전(8byte) = 1122byte
				C_RecStr = C_RecStr   + String.format("%08d", eTempData01);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c99"),"0"));    //소기업,소상공인공제부금(10byte) = 1132byte    
				C_RecStr = C_RecStr  + String.format("%010d", eTempData02);

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC100"),"0"));   //기타공제_주택마련저축_청약저축(10byte) = 1142byte     
				C_RecStr = C_RecStr  + String.format("%010d",  eTempData03) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC101"),"0"));    //기타공제_주택마련저축_주택청약종합저축 (10byte) = 1152byte     
				C_RecStr = C_RecStr   + String.format("%010d", eTempData04) ;
				mTempData02 =Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC102"),"0"));   //기타공제_주택마련저축_근로자주택마련저축 (10byte) = 1162byte
				C_RecStr = C_RecStr   + String.format("%010d",  eTempData05);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC103"),"0"));        //기타공제_투자조합출자공제액 (10byte) = 1172byte 
				C_RecStr = C_RecStr   + String.format("%010d", eTempData06) ;

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC104"),"0"));     //타공제_신용카드등사용액소득공제(8byte) = 1180byte
				C_RecStr = C_RecStr   + String.format("%08d", eTempData07) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC105"),"0"));       //기타공제_우리사주출연금공제 (10byte) = 1190byte     
				C_RecStr = C_RecStr   + String.format("%010d",  eTempData08);

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC107"),"0"));       //기타공제_고용유지중소기업근로자임금삭감공제액(10byte) = 1200byte
				C_RecStr = C_RecStr   + String.format("%010d",  eTempData09);

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC109"),"0"));      //기타공제_장기집합투자증권저축공제액(10byte) = 1210byte  
				C_RecStr = C_RecStr   + String.format("%010d",  eTempData10)  ;

				C_RecStr = C_RecStr   + String.format("%020d", 0);	//공란(10byte) + 공란(10byte) = 1230byte

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC110"),"0"));      //그밖의소득공제계(11byte) = 1241byte  
				C_RecStr = C_RecStr  + String.format("%011d",  eSumTempData);

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC111"),"0"));     //소득공제종합한도초과금액(11byte) = 1252byte   
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02) ;


				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC112"),"0"));     //종합소득과세표준(11byte) = 1263byte      
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC113"),"0"));         //산출세액 (11byte) = 1274byte      
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02) ;

				//------------------------ 세액감면 ------------------------------ 
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC114"),"0"));     //세액감면_소득세법(10byte) = 1284byte    
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC115"),"0"));     //세액감면_조세특례법(10byte) = 1294byte       
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02)  ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC116"),"0"));  //세액감면_조세특례법제30조(10byte) = 1304byte  
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02)  ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC117"),"0"));    //세액감면_조세조약(10byte) = 1314byte  
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;

				C_RecStr = C_RecStr   + String.format("%020d", 0);	//공란(10byte) + 공란(10byte) = 1334byte

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC119"),"0"));       //세액감면_세액감면계(10byte) = 1344byte    
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);


				// ------------------------ 세액공제 -------------------------------------------------------
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC120"),"0"));      //세액공제_근로소득세액공제 (10byte) = 1354byte
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;

				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC121"),"0"));             //자녀세액인원(2byte) = 1356byte
				C_RecStr = C_RecStr   + String.format("%02d",  mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC122"),"0"));              //자녀세액금액(10byte) = 1366byte
				C_RecStr = C_RecStr   + String.format("%010d", pTempData03) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC125"),"0"));              //출산입양자공제인원(2byte) = 1368byte
				C_RecStr = C_RecStr   + String.format("%02d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC126"),"0"));            // 출산입양자공제금액 (10byte) = 1378byte
				C_RecStr = C_RecStr   + String.format("%010d",  pTempData04) ;

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC127"),"0"));                  //연금계좌_과학기술인공제_공제대상금액(10byte) = 1388byte
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC128"),"0"));                  //연금계좌_과학기술인공제_세액공제액(10byte) = 1398byte
				C_RecStr = C_RecStr   + String.format("%010d", pTempData05) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC129"),"0"));               //연금계좌_근로자퇴직 급여보장법에 따른 퇴직급여 공제대상금액(10byte) = 1408byte
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC130"),"0"));                //연금계좌_근로자퇴직 급여보장법에 따른 퇴직급여 공제액(10byte) = 1418byte
				C_RecStr = C_RecStr   + String.format("%010d", pTempData06) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC131"),"0"));               //연금계좌_ 연금저축 공제대상금액(10byte) = 1428byte
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC132"),"0"));              //연금계좌_연금저축 세액공제액(10byte) = 1438byte
				C_RecStr = C_RecStr   + String.format("%010d", pTempData07) ;

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC133"),"0"));                //특별세액공제_보장성보험료_공제대상금액(10byte) = 1448byte
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC134"),"0"));               // //특별공제_일반보장성보험료 세액공제액(10byte) = 1458byte
				C_RecStr = C_RecStr   + String.format("%010d", pTempData08) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC135"),"0"));              //특별공제_장애인보장성대상금액(10byte) = 1468byte
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC136"),"0"));                  //특특별공제_장애인보장성보험료 세액공제액(10byte) = 1478byte
				C_RecStr = C_RecStr   + String.format("%010d", pTempData09) ;

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC137"),"0"));                 //특별세액공제_의료비_공제대상금액(10byte) = 1488byte
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC138"),"0"));               //특별세액공제_의료비_세액공제액(10byte) = 1498byte
				C_RecStr = C_RecStr   + String.format("%010d", pTempData10) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC139"),"0"));                 //특별세액공제_교육비_공제대상금액(10byte) = 1508byte
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC140"),"0"));                 //특별세액공제_교육비_세액공제(10byte) = 1518byte
				C_RecStr = C_RecStr   + String.format("%010d", pTempData11) ;

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC141"),"0"));                //특별세액공제_기부금_정치자금_10만원이하 공제 대상금액(10byte) = 1528byte
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC142"),"0"));                  //특별세액공제_기부금_정치자금_10만원이하 공제(10byte) = 1538byte
				C_RecStr = C_RecStr   + String.format("%010d", pTempData12) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC143"),"0"));                   //특별세액공제_기부금_정치자금_10만원초과  공제 대상금액(11byte) = 1549byte
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC144"),"0"));                 //특별세액공제_기부금_정치자금_10만원초과  공제(10byte) = 1559byte
				C_RecStr = C_RecStr   + String.format("%010d", pTempData13) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC145"),"0"));                 //특별세액공제_기부금_법정기부금 공제 대상금액(11byte) = 1570byte
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC146"),"0"));                 //특별세액공제_기부금_법정기부금 공제(10byte) = 1580byte
				C_RecStr = C_RecStr   + String.format("%010d", pTempData14) ;

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC147"),"0"));   //우리사주종합기부대상금액(11byte) = 1591byte
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC148"),"0"));    //우리사주조합세액공제액(10byte) = 1601byte
				C_RecStr = C_RecStr   + String.format("%010d", pTempData15) ;

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC149"),"0")); //지정기부금_종교단체외공제대상금액(11byte) = 1612byte
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC150"),"0")); //지정기부금_종교단체외세액공제액(10byte) = 1622byte
				C_RecStr = C_RecStr   + String.format("%010d", pTempData16) ;

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC150a"),"0"));   //지정기부금_종교단체공제대상금액(11byte) = 1633byte
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC150b"),"0"));   //지정기부금_종교단체세액공제액(10byte) = 1643byte
				C_RecStr = C_RecStr   + String.format("%010d", pTempData17) ;

				// SPCI_NATG	종교단체외지정대상금액	 
				// SPCI_YATG	종교단체지정대상금액	 

				C_RecStr = C_RecStr   + String.format("%022d", 0);	//공란(11byte) + 공란(11byte) = 1665byte

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC151"),"0"));                 //특별세액공제(10byte) = 1675byte
				C_RecStr = C_RecStr   + String.format("%010d", pTempData20) ;
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC152"),"0"));              //표준 세액 공제(10byte) = 1685byte
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02) ;

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC153"),"0"));               //납세조합공제(10byte) = 1695byte
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC154"),"0"));              //주택차입금(10byte) = 1705byte
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;
				mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC155"),"0"));               //외국납부(10byte) = 1715byte
				C_RecStr = C_RecStr  + String.format("%010d",  mTempData02) ;


				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC156"),"0"));     //월세세액공제대상금액 (10byte) = 1725byte
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02) ;      
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC157"),"0"));            //월세 세액 공제(8byte) = 1733byte
				C_RecStr = C_RecStr   + String.format("%08d",  pTempData18) ;

				C_RecStr = C_RecStr   + String.format("%020d", 0);	//공란(10byte) + 공란(10byte) = 1753byte

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC158"),"0"));               //세액공제계(10byte) = 1763byte
				C_RecStr = C_RecStr   + String.format("%010d",  pTempData19) ;

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC159"),"0"));               //소득세(11byte) = 1774byte
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC160"),"0"));                //지방소득세(10byte) = 1784byte
				C_RecStr = C_RecStr   + String.format("%010d", mTempData02);
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC161"),"0"));                  //농특세(10byte) = 1797byte
				C_RecStr = C_RecStr    + String.format("%010d", mTempData02);
				
				//2020귀속추가
				//실효세율(3byte) = 1797byte
				//(소득세_결정세액/총급여)*100 = 실효세율, 정수2자리+소수1자리기재, ex)0% -> 000, 35% -> 350
				/*logger.debug("(1)" + MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC159"),"0")); //0값
				logger.debug("(2)" + MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c63"),"0")); //52551810
				logger.debug("(3)" + Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC159"),"0"))); //0
				logger.debug("(4)" + Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c63"),"0"))); //52551810
				logger.debug("(5)" + 
						((Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC159"),"0"))
								/Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c63"),"0")))*100)); //0
*/				
				/*mTempData02 = ((Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC159"),"0"))
						/Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yeta0c63"),"0")))*100);
				
				DecimalFormat numberForm = new DecimalFormat("00.0");
				
				mTempData03 = numberForm.format(mTempData02);
				
				logger.debug("numberForm" + numberForm.format(mTempData02));
				logger.debug("mTempData03" + mTempData03);
				C_RecStr = C_RecStr    +  mTempData03.replace(".", ""); //실효세율(3byte) = 1797byte
*/				
				logger.debug("실효세율_1 = " + Double.parseDouble(MSFSharedUtils.defaultNulls
        				  (mapYetaC.get("yetaC159"),"0.00")));
				logger.debug("실효세율_2 = " + Double.parseDouble(MSFSharedUtils.defaultNulls
				  (mapYetaC.get("yeta0c63"),"0.00")));
				logger.debug("실효세율_3 = " + (Double.parseDouble(MSFSharedUtils.defaultNulls
				  (mapYetaC.get("yetaC159"),"0.00")))/(Double.parseDouble(MSFSharedUtils.defaultNulls
        				  (mapYetaC.get("yeta0c63"),"0.00"))));
				logger.debug("실효세율_4 = " + ((Double.parseDouble(MSFSharedUtils.defaultNulls
				  (mapYetaC.get("yetaC159"),"0.00")))/(Double.parseDouble(MSFSharedUtils.defaultNulls
        				  (mapYetaC.get("yeta0c63"),"0.00"))))*100);
				
				/*StringUtils.replace(String.format("%04.1f",((Double.parseDouble(MSFSharedUtils.defaultNulls
						  (mapYetaC.get("yetaC159"),"0.00")))/(Double.parseDouble(MSFSharedUtils.defaultNulls
		        				  (mapYetaC.get("yeta0c63"),"0.00"))))*100),".","");*/
				
				logger.debug("실효세율_5 = " + String.format("%05.2f",((Double.parseDouble(MSFSharedUtils.defaultNulls
				  (mapYetaC.get("yetaC159"),"0.00")))/(Double.parseDouble(MSFSharedUtils.defaultNulls
        				  (mapYetaC.get("yeta0c63"),"0.00"))))*100));
				logger.debug("실효세율_6 = " + StringUtils.replace(String.format("%05.2f",((Double.parseDouble(MSFSharedUtils.defaultNulls
				  (mapYetaC.get("yetaC159"),"0.00")))/(Double.parseDouble(MSFSharedUtils.defaultNulls
        				  (mapYetaC.get("yeta0c63"),"0.00"))))*100),".",""));
				logger.debug("실효세율_7 = " + StringUtils.replace(String.format("%04.2f",((Double.parseDouble(MSFSharedUtils.defaultNulls
			  (mapYetaC.get("yetaC159"),"0.00")))/(Double.parseDouble(MSFSharedUtils.defaultNulls
        				  (mapYetaC.get("yeta0c63"),"0.00"))))*100),".",""));
				C_RecStr = C_RecStr +  
						StringUtils.replace(String.format("%04.1f",((Double.parseDouble(MSFSharedUtils.defaultNulls
								  (mapYetaC.get("yetaC159"),"0.00")))/(Double.parseDouble(MSFSharedUtils.defaultNulls
				        				  (mapYetaC.get("yeta0c63"),"0.00"))))*100),".",""); //실효세율(3byte) = 1797byte
				
				
				//기납부세액 - 주현근무지  
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC162"),"0"));       //기납부소득세(11byte) = 1808byte
				C_RecStr = C_RecStr    + String.format("%011d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC163"),"0"));                  //기납부지방소득세(10byte) = 1818byte
				C_RecStr = C_RecStr    + String.format("%010d", mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC164"),"0"));               //기납부농특세(10byte) = 1828byte
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC165"),"0"));                //납부특례세액 _소득세(11byte) = 1839byte
				C_RecStr = C_RecStr   + String.format("%011d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC166"),"0"));               //납부특례세액 _지방소득세(10byte) = 1849byte
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC167"),"0"));           //납부특례세액 _농특세 (10byte) = 1859byte
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);

				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtEtaxb"),"0"));           //소득세음양(1byte) = 1860byte
				C_RecStr = C_RecStr   + String.format("%01d",  mTempData02)  ;
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC168"),"0"));        //소득세(11byte) = 1871byte
				C_RecStr = C_RecStr   + String.format("%011d", mTempData02) ;
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtInhbb"),"0"));          //지방소득세음양(1byte) = 1872byte
				C_RecStr = C_RecStr  + String.format("%01d", mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC169"),"0"));          //지방소득세(10byte) = 1882byte
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("subtFafvb"),"0"));           //농특세음양(1byte) = 1883byte
				C_RecStr = C_RecStr   + String.format("%01d", mTempData02);
				
				mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("yetaC170"),"0"));              //농특세(10byte) = 1893byte
				C_RecStr = C_RecStr   + String.format("%010d",  mTempData02);
				
				/*C_RecStr = C_RecStr   + String.format("%-248s", "") ;*/

              
				TOT_Record.add(C_RecStr);

				D_Cnt = 1; 

				//fnPayrD_ReTax_Total_Select
				infcPkgYe161020Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
				List listYetaD = yeta5400PayrService.fnPayrD_ReTax_Total_Select(infcPkgYe161020Vo);
				//D 레코드 처리 화면  
				if (listYetaD.size() > 0) { 
					Iterator<Map<String, Object>> iter01 = listYetaD.iterator(); 

					while ( iter01.hasNext() ) { 

						Map<String, Object> mapYetaD = (Map<String, Object>) iter01.next(); 

						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

						mTempData02 = 0L;
						D_RecStr = "";
						D_RecStr = "D" + "20" + infcPkgYe161005Vo.getTxOffcCd(); //레코드구분(1byte) + 자료구분(2byte) + 세무서코드(3byte) = 6byte
						D_RecStr = D_RecStr +   String.format("%06d", C_Cnt);  //일련번호(6byte) = 12byte
						D_RecStr = D_RecStr +  String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-",""));//사업자등록번호(10byte) = 22byte
						//D_RecStr = D_RecStr + String.format("%50s", "")  + String.format("%-13s", StringUtils.replace(MSFSharedUtils.defaultNulls(rrnDecCrypt,""),"-",""));
						D_RecStr = D_RecStr + String.format("%-13s", StringUtils.replace(MSFSharedUtils.defaultNulls(rrnDecCrypt,""),"-",""));//소득자주민등록번호(13byte) = 35byte

						//근무처별 소득 명세 - 종전근무처  ,AD03.TAX_ASSO_YN 사용안함 
						D_RecStr = D_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaD.get("prcspTxpyrAsocYn"),"2")) ;  //납세조합여부(1byte) = 36byte
						//D_RecStr = D_RecStr + PkgFuncUtils.getRHanPad( PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspFmnmNm"),"") ,58),60," ") ;
						D_RecStr = D_RecStr + Han1(mapYetaD.get("prcspFmnmNm"),60) ; //법인명(60byte) = 96byte
						D_RecStr = D_RecStr + String.format("%-10s", MSFSharedUtils.defaultNulls(mapYetaD.get("prcspBusoprRgstnum"),""))  ;//사업자등록번호(10byte) = 106byte
						D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspDutyBgnnDt"),"0"))); //근무기간시작연월일(8byte) = 114byte
						D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspDutyEndDt"),"0"))); //근무기간종료연월일(8byte) = 122byte
						D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspReduBgnnDt"),"0"))); //감면기간시작연월일(8byte) = 130byte
						D_RecStr = D_RecStr + String.format("%08d",Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspReduEndDt"),"0"))); //감면기간종료연월일(8byte) = 138byte
                               
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspPaySum"),"0"));  //급여(11byte) = 149byte
						D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspAllwBnusSum"),"0")); //상여(11byte) = 160byte
						D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspRcgtnBnusSum"),"0")); //인정상여(11byte) = 171byte
						D_RecStr = D_RecStr +  String.format("%011d", mTempData02);
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspStckEvntPrftSum"),"0")); //주식매수선택권 행사이익(11byte) = 182byte
						D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspEmpStkscWdrwSum"),"0")); //우리사주조합인출금(11byte) = 193byte
						D_RecStr = D_RecStr +  String.format("%011d",mTempData02);

						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspEcteRsgtnExceSum"),"0")); //임원퇴직소득한도 초과액(11byte) = 204byte
						D_RecStr = D_RecStr +  String.format("%011d",mTempData02);
						
						D_RecStr = D_RecStr +  String.format("%011d",0);	//직무발명 보상금(11byte) = 215byte

						D_RecStr = D_RecStr +  String.format("%022d",0);	// 공란(11byte) + 공란(11byte) = 237byte

						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspAggrSum"),"0")); //합계(11byte) = 248byte
						D_RecStr = D_RecStr +  String.format("%011d",mTempData02);	

						//종전근무지 비과세소득 및 감면소득  
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSg01Jong"),"0"));   //비과세학자금(10byte) = 258byte
						D_RecStr = D_RecStr   + String.format("%010d", mTempData02);	
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh01Jong"),"0"));  //무보수위원수당(10byte) = 268byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh05Jong"),"0"));  //경호승선수당(10byte) = 278byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh06Jong"),"0"));  //유아초중등(10byte) = 288byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh07Jong"),"0"));  //고등교육법(10byte) = 298byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh08Jong"),"0"));  //특별법(10byte) = 308byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh09Jong"),"0"));  //연구기관등(10byte) = 318byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02)  ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh10Jong"),"0"));  //기업부설연구소(10byte) = 328byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02)  ;	
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh14Jong"),"0"));  //보육교사근무환경 개선비(10byte) = 338byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh15Jong"),"0"));  //사립유치원수석교사 인건비(10byte) = 348byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh11Jong"),"0"));  //취재수당(10byte) = 358byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh12Jong"),"0"));  //벽지수당(10byte) = 368byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02)  ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh13Jong"),"0"));  //재해관련급여(10byte) = 378byte
						D_RecStr = D_RecStr    +  String.format("%010d",  mTempData02) ;
						mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSh16Jong"),"0"));  //정부,공공기관 지방이전기관 종사자 이주수당(10byte) = 388byte
						D_RecStr = D_RecStr    +  String.format("%010d",  mTempData02) ;	

						D_RecStr = D_RecStr +  String.format("%010d",0);	//종교활동비(10byte) = 398byte

						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSi01Jong"),"0"));  //외국정부등근무자(10byte) = 408byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);
						mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSk01Jong"),"0"));  //외국주둔군인등(10byte) = 418byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm01Jong"),"0")); //극외근로100만원(10byte) = 428byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm02Jong"),"0"));  //국외근로300만원(10byte) = 438byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;	
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSm03Jong"),"0"));  //국외근로(10byte) = 448byte
						D_RecStr = D_RecStr  +  String.format("%010d",  mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSo01Jong"),"0")); //야간근로수당(10byte) = 458byte
						D_RecStr = D_RecStr   +  String.format("%010d", mTempData02)  ;
						mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSq01Jong"),"0")); //출산보육수당(10byte) = 468byte
						D_RecStr = D_RecStr  +  String.format("%010d", mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSr10Jong"),"0")); //근로장학금(10byte) = 478byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;

						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSr11Jong"),"0")); //직무발명보상금(10byte) = 488byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;

						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSs01Jong"),"0"));  //주식매수선택권(10byte) = 498byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);

						D_RecStr = D_RecStr +  String.format("%010d",0);	//벤처기업 주식매수 선택권(10byte) = 508byte

						//mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt01Jong"),"0")); 
						//D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;
						mTempData02 =  Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy02Jong"),"0")); //우리사주조합인출금 50%(10byte) = 518byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02) ;
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy03Jong"),"0"));  //우리사주조합인출금 75%(10byte) = 528byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	

						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy04Jong"),"0"));  //우리사주조합인출금 100%(10byte) = 538byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	

						//  mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy21"),"0")); 
						//  C_RecStr = C_RecStr   +  String.format("%010d",  mTempData02);
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSy22Jong"),"0")); //전공의수련보조수당(10byte) = 548byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);
						 
						D_RecStr = D_RecStr   +  String.format("%010d",  0);	//외국인기술자 소득세감면 50%(10byte) = 558byte
						
						//2019귀속 추가
						D_RecStr = D_RecStr   +  String.format("%010d",  0);	//성과공유중소기업경영성과급(10byte) = 568byte
						D_RecStr = D_RecStr   +  String.format("%010d",  0);	//중소기업핵심인력성과보상기금수령액(10byte) = 578byte
						
						//2020귀속 추가
						D_RecStr = D_RecStr   +  String.format("%010d",  0); //내국인우수인력 국내복귀 소득세감면(10byte) = 588byte
						
						
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt11Jong"),"0")); //중소기업 취업 청년소득세 감면 50%(10byte) = 598byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt12Jong"),"0")); //중소기업 취업 청년소득세 감면 70%(10byte) = 608byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	

						D_RecStr = D_RecStr +  String.format("%010d",0);	//중소기업 취업 청년소득세 감면 90%(10byte) = 618byte

						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("taxmSt20Jong"),"0")); //조세조약상 교직자감면(10byte) = 628byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);
						
						
						//2020귀속 추가
						D_RecStr = D_RecStr   +  String.format("%010d",  0); //외국인기술자 소득세감면 70%(10byte) = 638byte
						D_RecStr = D_RecStr   +  String.format("%030d",  0); //공란(10byte) + 공란(10byte) + 공란(10byte) = 668byte

						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("freeDtyAggrSum"),"0"));    //비과세계(10byte) = 678byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);
						mTempData02 = Long.parseLong( MSFSharedUtils.defaultNulls(mapYetaC.get("reduIncmAggrSum"),"0"));   //감면소득계(10byte) = 688byte
						D_RecStr = D_RecStr   +  String.format("%010d",  mTempData02);	

						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspIncmTxSum"),"0")); //소득세(11byte) = 699byte
						D_RecStr = D_RecStr +  String.format("%011d", mTempData02);
						
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspRgonIncmTxSum"),"0")); //지방소득세(10byte) = 709byte
						D_RecStr = D_RecStr +  String.format("%010d", mTempData02);
						
						mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaD.get("prcspNnksSum"),"0")); //농특세(10byte) = 719byte
						D_RecStr = D_RecStr +  String.format("%010d", mTempData02);	
						
						D_RecStr = D_RecStr +  String.format("%02d",  D_Cnt);	//종전근무처일련번호(2byte) = 721byte
						D_RecStr = D_RecStr + String.format("%1172s", ""); 	//공란(1172byte) = 1893byte

						TOT_Record.add(D_RecStr);

						D_Cnt = D_Cnt + 1;
					}
				}

				//E레코드
				E_Cnt = 1;
				E_RowCnt = 1;
				E_RecStr = "";

				infcPkgYe161020Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));

				List listYetaE = yeta5400PayrService.fnPayrE_ReTax_Total_Select(infcPkgYe161020Vo);

				// E레코드 파일처리 
 
				if ( listYetaE.size() > 0) { 
					Iterator<Map<String, Object>> iter03 = listYetaE.iterator(); 
					logger.debug("listYetaE.size()1 = " + listYetaE.size());
					logger.debug("E_RowCnt1 = " + E_RowCnt);
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
							logger.debug("listYetaE.size()1_1 = " + listYetaE.size());
							logger.debug("E_RowCnt1_1 = " + E_RowCnt);

							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("suptFmlyRltClCd")," ");    //연말정산부양관계코드(1byte) = 36byte 
							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("nnfClCd")," "); //내외국인구분코드(1byte) = 37byte
							E_RecStr = E_RecStr + Han1(mapYetaE.get("txprNm") ,30)   ;	//이름(30byte) = 67byte
							logger.debug("이름1 = " + mapYetaE.get("txprNm"));
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
							
							//2020귀속 추가
							//순서 ->
							//신용카드3월,직불카드3월(제로페이3월 합산금액),현금영수증3월,도서공연사용분3월,전통시장3월,대중교통3월
							//신용카드4~7월,직불카드4~7월(제로페이4~7월 합산금액),현금영수증4~7월,도서공연사용분4~7월,전통시장4~7월,대중교통4~7월
							//신용카드그외월,직불카드그외월(제로페이그외월 합산금액),현금영수증그외월,도서공연사용분그외월,전통시장그외월,대중교통그외월
							//신용카드 등 전체금액은 없어지고 월별구분금액이 들어감
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt301"),"0"));        // 신용카드3월_국세청자료(10byte) = 198byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt301"),"0"));        //직불카드3월_국세청자료(10byte) = 208byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cshptDdcTrgt301"),"0"));          // 현금영수증3월_국세청자료(10byte) = 218byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt301"),"0"));        //도서공연3월_국세청자료(10byte) = 228byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt301"),"0"));        //전통시장3월_국세청자료(10byte) = 238byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt301"),"0"));        //대중교통3월_국세청자료(10byte) = 248byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt4701"),"0"));        // 신용카드4~7월_국세청자료(10byte) = 258byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt4701"),"0"));        //직불카드4~7월_국세청자료(10byte) = 268byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cshptDdcTrgt4701"),"0"));          // 현금영수증4~7월_국세청자료(10byte) = 278byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt4701"),"0"));        //도서공연4~7월_국세청자료(10byte) = 288byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt4701"),"0"));        //전통시장4~7월_국세청자료(10byte) = 298byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt4701"),"0"));        //대중교통4~7월_국세청자료(10byte) = 308byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgtOth01"),"0"));        // 신용카드그외월_국세청자료(10byte) = 318byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgtOth01"),"0"));        //직불카드그외월_국세청자료(10byte) = 328byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cshptDdcTrgtOth01"),"0"));          // 현금영수증그외월_국세청자료(10byte) = 338byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgtOth01"),"0"));        //도서공연그외월_국세청자료(10byte) = 348byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgtOth01"),"0"));        //전통시장그외월_국세청자료(10byte) = 358byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgtOth01"),"0"));        //대중교통그외월_국세청자료(10byte) = 368byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							

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
							
							
							//2020귀속 추가
							//순서 ->
							//신용카드3월,직불카드3월(제로페이3월 합산금액),현금영수증3월,도서공연사용분3월,전통시장3월,대중교통3월
							//신용카드4~7월,직불카드4~7월(제로페이4~7월 합산금액),현금영수증4~7월,도서공연사용분4~7월,전통시장4~7월,대중교통4~7월
							//신용카드그외월,직불카드그외월(제로페이그외월 합산금액),현금영수증그외월,도서공연사용분그외월,전통시장그외월,대중교통그외월
							//신용카드 등 전체금액은 없어지고 월별구분금액이 들어감
							//기타자료는 따로 입력란이 없기때문에 그냥 0값들어가도록 한다
							
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//신용카드3월(10byte) = 491byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//직불카드3월(10byte) = 501byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//도서공연3월(10byte) = 511byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//전통시장3월(10byte) = 521byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//대중교통3월(10byte) = 531byte
							
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//신용카드4~7월(10byte) = 541byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//직불카드4~7월(10byte) = 551byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//도서공연4~7월(10byte) = 561byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//전통시장4~7월(10byte) = 571byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//대중교통4~7월(10byte) = 581byte
							
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//신용카드그외월(10byte) = 591byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//직불카드그외월(10byte) = 601byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//도서공연그외월(10byte) = 611byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//전통시장그외월(10byte) = 621byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//대중교통그외월(10byte) = 631byte
							

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
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0) //교육비_장애인 153byte
                                  + String.format("%010d", 0) //신용카드3월
                                  + String.format("%010d", 0) //직불카드3월
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0) //213byte
								+ String.format("%010d", 0) //신용카드4~7월
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0) //대중교통4~7월
								+ String.format("%010d", 0) //283byte
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0)
								+ String.format("%010d", 0) //333byte
                                  + String.format("%013d", 0) //기부금 346byte
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%01d", 0) //실손의료보험금
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0) //교육비_장애인 446byte
                                  + String.format("%010d", 0) //신용카드3월
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0) //신용카드4~7월
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0) //신용카드그외월
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0)
                                  + String.format("%010d", 0) //596byte
                                  + String.format("%013d", 0); //기부금 609byte + 35byte = 644byte
 
							E_RowCnt =  E_RowCnt + 1;
						}
                 
						if (listYetaE.size() + 1 > E_RowCnt)  {
							logger.debug("listYetaE.size()2 = " + listYetaE.size());
							logger.debug("E_RowCnt2 = " + E_RowCnt);

							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("suptFmlyRltClCd")," ");    //연말정산부양관계코드(1byte) = 36byte 
							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("nnfClCd")," "); //내외국인구분코드(1byte) = 37byte
							E_RecStr = E_RecStr + Han1(mapYetaE.get("txprNm") ,30)   ;	//이름(30byte) = 67byte
							logger.debug("이름2 = " + mapYetaE.get("txprNm"));
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
							
							//2020귀속 추가
							//순서 ->
							//신용카드3월,직불카드3월(제로페이3월 합산금액),현금영수증3월,도서공연사용분3월,전통시장3월,대중교통3월
							//신용카드4~7월,직불카드4~7월(제로페이4~7월 합산금액),현금영수증4~7월,도서공연사용분4~7월,전통시장4~7월,대중교통4~7월
							//신용카드그외월,직불카드그외월(제로페이그외월 합산금액),현금영수증그외월,도서공연사용분그외월,전통시장그외월,대중교통그외월
							//신용카드 등 전체금액은 없어지고 월별구분금액이 들어감
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt301"),"0"));        // 신용카드3월_국세청자료(10byte) = 198byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt301"),"0"));        //직불카드3월_국세청자료(10byte) = 208byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cshptDdcTrgt301"),"0"));          // 현금영수증3월_국세청자료(10byte) = 218byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt301"),"0"));        //도서공연3월_국세청자료(10byte) = 228byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt301"),"0"));        //전통시장3월_국세청자료(10byte) = 238byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt301"),"0"));        //대중교통3월_국세청자료(10byte) = 248byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt4701"),"0"));        // 신용카드4~7월_국세청자료(10byte) = 258byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt4701"),"0"));        //직불카드4~7월_국세청자료(10byte) = 268byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cshptDdcTrgt4701"),"0"));          // 현금영수증4~7월_국세청자료(10byte) = 278byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt4701"),"0"));        //도서공연4~7월_국세청자료(10byte) = 288byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt4701"),"0"));        //전통시장4~7월_국세청자료(10byte) = 298byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt4701"),"0"));        //대중교통4~7월_국세청자료(10byte) = 308byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgtOth01"),"0"));        // 신용카드그외월_국세청자료(10byte) = 318byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgtOth01"),"0"));        //직불카드그외월_국세청자료(10byte) = 328byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cshptDdcTrgtOth01"),"0"));          // 현금영수증그외월_국세청자료(10byte) = 338byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgtOth01"),"0"));        //도서공연그외월_국세청자료(10byte) = 348byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgtOth01"),"0"));        //전통시장그외월_국세청자료(10byte) = 358byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgtOth01"),"0"));        //대중교통그외월_국세청자료(10byte) = 368byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							

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
							
							
							//2020귀속 추가
							//순서 ->
							//신용카드3월,직불카드3월(제로페이3월 합산금액),현금영수증3월,도서공연사용분3월,전통시장3월,대중교통3월
							//신용카드4~7월,직불카드4~7월(제로페이4~7월 합산금액),현금영수증4~7월,도서공연사용분4~7월,전통시장4~7월,대중교통4~7월
							//신용카드그외월,직불카드그외월(제로페이그외월 합산금액),현금영수증그외월,도서공연사용분그외월,전통시장그외월,대중교통그외월
							//신용카드 등 전체금액은 없어지고 월별구분금액이 들어감
							//기타자료는 따로 입력란이 없기때문에 그냥 0값들어가도록 한다
							
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//신용카드3월(10byte) = 491byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//직불카드3월(10byte) = 501byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//도서공연3월(10byte) = 511byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//전통시장3월(10byte) = 521byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//대중교통3월(10byte) = 531byte
							
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//신용카드4~7월(10byte) = 541byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//직불카드4~7월(10byte) = 551byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//도서공연4~7월(10byte) = 561byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//전통시장4~7월(10byte) = 571byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//대중교통4~7월(10byte) = 581byte
							
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//신용카드그외월(10byte) = 591byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//직불카드그외월(10byte) = 601byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//도서공연그외월(10byte) = 611byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//전통시장그외월(10byte) = 621byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//대중교통그외월(10byte) = 631byte
							

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
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0) //교육비_장애인 153byte
	                                  + String.format("%010d", 0) //신용카드3월
	                                  + String.format("%010d", 0) //직불카드3월
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
									+ String.format("%010d", 0)
									+ String.format("%010d", 0) //213byte
									+ String.format("%010d", 0) //신용카드4~7월
									+ String.format("%010d", 0)
									+ String.format("%010d", 0)
									+ String.format("%010d", 0)
									+ String.format("%010d", 0)
									+ String.format("%010d", 0) //대중교통4~7월
									+ String.format("%010d", 0) //283byte
									+ String.format("%010d", 0)
									+ String.format("%010d", 0)
									+ String.format("%010d", 0)
									+ String.format("%010d", 0)
									+ String.format("%010d", 0) //333byte
	                                  + String.format("%013d", 0) //기부금 346byte
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%01d", 0) //실손의료보험금
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0) //교육비_장애인 446byte
	                                  + String.format("%010d", 0) //신용카드3월
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0) //신용카드4~7월
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0) //신용카드그외월
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0) //596byte
	                                  + String.format("%013d", 0); //기부금 609byte + 35byte = 644byte
	 
								E_RowCnt =  E_RowCnt + 1;
						}

						if (listYetaE.size() + 1 > E_RowCnt)  {
							logger.debug("listYetaE.size()3 = " + listYetaE.size());
							logger.debug("E_RowCnt3 = " + E_RowCnt);

							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("suptFmlyRltClCd")," ");    //연말정산부양관계코드(1byte) = 36byte 
							E_RecStr = E_RecStr   +  MSFSharedUtils.defaultNulls(mapYetaE.get("nnfClCd")," "); //내외국인구분코드(1byte) = 37byte
							E_RecStr = E_RecStr + Han1(mapYetaE.get("txprNm") ,30)   ;	//이름(30byte) = 67byte
							logger.debug("이름3 = " + mapYetaE.get("txprNm"));
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
							
							//2020귀속 추가
							//순서 ->
							//신용카드3월,직불카드3월(제로페이3월 합산금액),현금영수증3월,도서공연사용분3월,전통시장3월,대중교통3월
							//신용카드4~7월,직불카드4~7월(제로페이4~7월 합산금액),현금영수증4~7월,도서공연사용분4~7월,전통시장4~7월,대중교통4~7월
							//신용카드그외월,직불카드그외월(제로페이그외월 합산금액),현금영수증그외월,도서공연사용분그외월,전통시장그외월,대중교통그외월
							//신용카드 등 전체금액은 없어지고 월별구분금액이 들어감
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt301"),"0"));        // 신용카드3월_국세청자료(10byte) = 198byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt301"),"0"));        //직불카드3월_국세청자료(10byte) = 208byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cshptDdcTrgt301"),"0"));          // 현금영수증3월_국세청자료(10byte) = 218byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt301"),"0"));        //도서공연3월_국세청자료(10byte) = 228byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt301"),"0"));        //전통시장3월_국세청자료(10byte) = 238byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt301"),"0"));        //대중교통3월_국세청자료(10byte) = 248byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgt4701"),"0"));        // 신용카드4~7월_국세청자료(10byte) = 258byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgt4701"),"0"));        //직불카드4~7월_국세청자료(10byte) = 268byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cshptDdcTrgt4701"),"0"));          // 현금영수증4~7월_국세청자료(10byte) = 278byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgt4701"),"0"));        //도서공연4~7월_국세청자료(10byte) = 288byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgt4701"),"0"));        //전통시장4~7월_국세청자료(10byte) = 298byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgt4701"),"0"));        //대중교통4~7월_국세청자료(10byte) = 308byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("crdcDdcTrgtOth01"),"0"));        // 신용카드그외월_국세청자료(10byte) = 318byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("drtpCardDdcTrgtOth01"),"0"));        //직불카드그외월_국세청자료(10byte) = 328byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("cshptDdcTrgtOth01"),"0"));          // 현금영수증그외월_국세청자료(10byte) = 338byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("bookDdcTrgtOth01"),"0"));        //도서공연그외월_국세청자료(10byte) = 348byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("tdmrDdcTrgtOth01"),"0"));        //전통시장그외월_국세청자료(10byte) = 358byte
							E_RecStr = E_RecStr+   String.format("%010d", mTempData02) ;
							mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaE.get("pbtDdcTrgtOth01"),"0"));        //대중교통그외월_국세청자료(10byte) = 368byte
							E_RecStr = E_RecStr+   String.format("%010d",mTempData02)  ;
							

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
							
							
							//2020귀속 추가
							//순서 ->
							//신용카드3월,직불카드3월(제로페이3월 합산금액),현금영수증3월,도서공연사용분3월,전통시장3월,대중교통3월
							//신용카드4~7월,직불카드4~7월(제로페이4~7월 합산금액),현금영수증4~7월,도서공연사용분4~7월,전통시장4~7월,대중교통4~7월
							//신용카드그외월,직불카드그외월(제로페이그외월 합산금액),현금영수증그외월,도서공연사용분그외월,전통시장그외월,대중교통그외월
							//신용카드 등 전체금액은 없어지고 월별구분금액이 들어감
							//기타자료는 따로 입력란이 없기때문에 그냥 0값들어가도록 한다
							
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//신용카드3월(10byte) = 491byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//직불카드3월(10byte) = 501byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//도서공연3월(10byte) = 511byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//전통시장3월(10byte) = 521byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//대중교통3월(10byte) = 531byte
							
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//신용카드4~7월(10byte) = 541byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//직불카드4~7월(10byte) = 551byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//도서공연4~7월(10byte) = 561byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//전통시장4~7월(10byte) = 571byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//대중교통4~7월(10byte) = 581byte
							
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//신용카드그외월(10byte) = 591byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//직불카드그외월(10byte) = 601byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//도서공연그외월(10byte) = 611byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//전통시장그외월(10byte) = 621byte
							E_RecStr = E_RecStr+   String.format("%010d", 0);	//대중교통그외월(10byte) = 631byte
							

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
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0) //교육비_장애인 153byte
	                                  + String.format("%010d", 0) //신용카드3월
	                                  + String.format("%010d", 0) //직불카드3월
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
									+ String.format("%010d", 0)
									+ String.format("%010d", 0) //213byte
									+ String.format("%010d", 0) //신용카드4~7월
									+ String.format("%010d", 0)
									+ String.format("%010d", 0)
									+ String.format("%010d", 0)
									+ String.format("%010d", 0)
									+ String.format("%010d", 0) //대중교통4~7월
									+ String.format("%010d", 0) //283byte
									+ String.format("%010d", 0)
									+ String.format("%010d", 0)
									+ String.format("%010d", 0)
									+ String.format("%010d", 0)
									+ String.format("%010d", 0) //333byte
	                                  + String.format("%013d", 0) //기부금 346byte
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%01d", 0) //실손의료보험금
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0) //교육비_장애인 446byte
	                                  + String.format("%010d", 0) //신용카드3월
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0) //신용카드4~7월
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0) //신용카드그외월
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0)
	                                  + String.format("%010d", 0) //596byte
	                                  + String.format("%013d", 0); //기부금 609byte + 35byte = 644byte
	 
								E_RowCnt =  E_RowCnt + 1;
						}
						
						E_RecStr = E_RecStr +  String.format("%02d",  E_Cnt); //1864byte
						E_RecStr = E_RecStr +  String.format("%26s",""); //공란(26byte) = 1893byte
                        
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

				List listYetaF = yeta5400PayrService.fnPayrF_ReTax_Total_Select(infcPkgYe161020Vo);

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
                                  	+ String.format("%-13s",rrnDecCrypt ) ; //레코드구분(1byte) + 자료구분(2byte) + 세무서코드(3byte) + 일련번호(6byte) + 사업자등록번호(10byte) + 주민번호(13byte) = 35byte
 
						if (listYetaF.size() + 1 > F_RowCnt)  { //1
                  
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
										+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
										+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
										+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ; //소득공제구분(2byte) + 금융기관코드(3byte) + 금융기관상호(60byte) + 계좌번호(20byte) = 120byte
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  //납입금액(10byte) = 130byte
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  //소득,세액공제금액(10byte) = 140byte
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +  String.format("%010d",0) ;
							else
								F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							

							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));//투자년도(4byte) = 144byte
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%04d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%04d",0);	
							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));//투자구분(1byte) = 145byte */
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%01d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%1s","");	

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
                                   + String.format("%-3s","")
                                   +  String.format("%-60s","")
                                   + String.format("%-20s","")
                                   +  String.format("%010d", 0)
                                   +  String.format("%010d", 0)
								+  String.format("%04d", 0)
								+  String.format("%1s","");

							F_RowCnt =  F_RowCnt + 1;
						}

						if (listYetaF.size() + 1 > F_RowCnt)  { //2
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
									+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
									+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
									+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);	
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +  String.format("%010d",0) ;
							else
								F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							

							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));//투자년도(4byte) = 144byte
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%04d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%04d",0);	
							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));//투자구분(1byte) = 145byte */
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%01d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%1s","");	


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

						if (listYetaF.size() + 1 > F_RowCnt)  { //3
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
									+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
									+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
									+ Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +  String.format("%010d",0) ;
							else
								F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							

							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));//투자년도(4byte) = 144byte
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%04d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%04d",0);	
							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));//투자구분(1byte) = 145byte */
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%01d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%1s","");


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

						if (listYetaF.size() + 1 > F_RowCnt)  { //4
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
								+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                + Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
                                + Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +  String.format("%010d",0) ;
							else
								F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							

							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));//투자년도(4byte) = 144byte
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%04d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%04d",0);	
							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));//투자구분(1byte) = 145byte */
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%01d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%1s","");


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

						if (listYetaF.size() + 1 > F_RowCnt)  { //5
		                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
								+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                + Han1(mapYetaF.get("rtpnAccFnnCmp"),60) 
                                + Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +  String.format("%010d",0) ;
							else
								F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							

							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));//투자년도(4byte) = 144byte
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%04d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%04d",0);	
							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));//투자구분(1byte) = 145byte */
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%01d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%1s","");	


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
						if (listYetaF.size() + 1 > F_RowCnt)  { //6
		                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
								+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                + Han1(mapYetaF.get("rtpnAccFnnCmp"),60) 
                                + Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +  String.format("%010d",0) ;
							else
								F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							

							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));//투자년도(4byte) = 144byte
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%04d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%04d",0);	
							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));//투자구분(1byte) = 145byte */
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%01d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%1s","");	

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

						if (listYetaF.size() + 1 > F_RowCnt)  { //7
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
								+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                + Han1(mapYetaF.get("rtpnAccFnnCmp"),60)
                                + Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +  String.format("%010d",0) ;
							else
								F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							

							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));//투자년도(4byte) = 144byte
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%04d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%04d",0);	
							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));//투자구분(1byte) = 145byte */
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%01d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%1s","");


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
						if (listYetaF.size() + 1 > F_RowCnt)  { //8
		                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
								+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
								+ Han1(mapYetaF.get("rtpnAccFnnCmp"),60)
                                + Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +  String.format("%010d",0) ;
							else
								F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							

							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));//투자년도(4byte) = 144byte
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%04d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%04d",0);	
							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));//투자구분(1byte) = 145byte */
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%01d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%1s","");


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

						if (listYetaF.size() + 1 > F_RowCnt)  { //9
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
								+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                + Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
                                + Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +  String.format("%010d",0) ;
							else
								F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							

							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));//투자년도(4byte) = 144byte
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%04d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%04d",0);	
							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));//투자구분(1byte) = 145byte */
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%01d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%1s","");	


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
						if (listYetaF.size() + 1 > F_RowCnt)  { //10
		                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
								+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                + Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
                                + Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +  String.format("%010d",0) ;
							else
								F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							

							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));//투자년도(4byte) = 144byte
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%04d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%04d",0);	
							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));//투자구분(1byte) = 145byte */
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%01d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%1s","");

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

						if (listYetaF.size() + 1 > F_RowCnt)  { //11
                     
							F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
								+ String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                                + Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
                                + Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +  String.format("%010d",0) ;
							else
								F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
							

							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));//투자년도(4byte) = 144byte
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%04d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%04d",0);	
							
							//2020귀속 추가
							mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));//투자구분(1byte) = 145byte */
							if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
								F_RecStr = F_RecStr +   String.format("%01d", mTempData02);
							else
								F_RecStr = F_RecStr +  String.format("%1s","");


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

						if (listYetaF.size() + 1 > F_RowCnt)  { //12
                     
                     F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                        + Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
                        + Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
                        F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
                        mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
                        if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +  String.format("%010d",0) ;
						else
							F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
						

						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));//투자년도(4byte) = 144byte
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%04d", mTempData02);
						else
							F_RecStr = F_RecStr +  String.format("%04d",0);	
						
						//2020귀속 추가
						mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));//투자구분(1byte) = 145byte */
						if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
							F_RecStr = F_RecStr +   String.format("%01d", mTempData02);
						else
							F_RecStr = F_RecStr +  String.format("%1s","");


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

				if (listYetaF.size() + 1 > F_RowCnt)  { //13
					F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                        + Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
                        + Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
					mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
					F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
					mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
					if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
						F_RecStr = F_RecStr +  String.format("%010d",0) ;
					else
						F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
					

					
					//2020귀속 추가
					mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));//투자년도(4byte) = 144byte
					if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
						F_RecStr = F_RecStr +   String.format("%04d", mTempData02);
					else
						F_RecStr = F_RecStr +  String.format("%04d",0);	
					
					//2020귀속 추가
					mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));//투자구분(1byte) = 145byte */
					if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
						F_RecStr = F_RecStr +   String.format("%01d", mTempData02);
					else
						F_RecStr = F_RecStr +  String.format("%1s","");


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

				if (listYetaF.size() + 1 > F_RowCnt)  { //14
                     
					F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                        + Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
                        + Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
					mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
					F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
					mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
					if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
						F_RecStr = F_RecStr +  String.format("%010d",0) ;
					else
						F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
					

					
					//2020귀속 추가
					mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));//투자년도(4byte) = 144byte
					if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
						F_RecStr = F_RecStr +   String.format("%04d", mTempData02);
					else
						F_RecStr = F_RecStr +  String.format("%04d",0);	
					
					//2020귀속 추가
					mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));//투자구분(1byte) = 145byte */
					if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
						F_RecStr = F_RecStr +   String.format("%01d", mTempData02);
					else
						F_RecStr = F_RecStr +  String.format("%1s","");


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

				if (listYetaF.size() + 1 > F_RowCnt)  { //15
                     
					F_RecStr = F_RecStr + String.format("%-2s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccRtpnCl"),""))   
                        + String.format("%-3s", MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnFnnOrgnCd"),""))  
                        + Han1(mapYetaF.get("rtpnAccFnnCmp"),60)  
                        + Han1(mapYetaF.get("rtpnAccAccno"),20)  ;
					mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccPymAmt"),"0"));  
					F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
					mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("rtpnAccTxamtDdcAmt"),"0"));  
					if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
						F_RecStr = F_RecStr +  String.format("%010d",0) ;
					else
						F_RecStr = F_RecStr +  String.format("%010d",mTempData02);
					

					
					//2020귀속 추가
					mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("regDt"),"0"));//투자년도(4byte) = 144byte
					if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
						F_RecStr = F_RecStr +   String.format("%04d", mTempData02);
					else
						F_RecStr = F_RecStr +  String.format("%04d",0);	
					
					//2020귀속 추가
					mTempData02 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaF.get("vntAsctClCd"),"0"));//투자구분(1byte) = 145byte */
					if("61".equals(mapYetaF.get("rtpnAccRtpnCl")))
						F_RecStr = F_RecStr +   String.format("%01d", mTempData02);
					else
						F_RecStr = F_RecStr +  String.format("%1s","");


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


				F_RecStr = F_RecStr +  String.format("%02d",  F_RowCnt); //연금저축레코드 일련번호(2byte) = 1687byte
				F_RecStr = F_RecStr + String.format("%-206s",""); //공란(206byte) = 1893byte
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
               
               List listYetaG = yeta5400PayrService.fnPayrG_ReTax_Total_Select(infcPkgYe161020Vo);
                
 
               if ( listYetaG.size() > 0) { 
 
              	   Iterator<Map<String, Object>> iter05 = listYetaG.iterator(); 
             	   
                   while ( iter05.hasNext() ) { 
                    	
                     Map<String, Object> mapYetaG = (Map<String, Object>) iter05.next(); 
                       
                     if ((listYetaG.size() > 0) &&  (MSFSharedUtils.paramNotNull( mapYetaG.get("mnthRnttyBurRgsum")) 
                     ||  MSFSharedUtils.paramNotNull( mapYetaG.get("comrCdtrNm")) || MSFSharedUtils.paramNotNull( mapYetaG.get("rntlCttLehdrNm"))))  {
                     
                    	// 주민번호(복호화)
         				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
         		          	 
                       mTempData02 = 0L;

                       G_RecStr =  "G" + "20" + infcPkgYe161005Vo.getTxOffcCd()  +  String.format("%06d", C_Cnt) 
                    		   		+  String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-",""))
                                    + String.format("%-13s",rrnDecCrypt) ;	//레코드구분(1byte) + 자료구분(2byte) + 세무서코드(3byte) + 일련번호(6byte) + 사업자등록번호(10byte) + 주민번호(13byte) = 35byte

                       
                       if (listYetaG.size() + 1 > G_RowCnt)  { //1
                      
                    	// 주민번호(복호화)
          				  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyBurRgsum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
          		          G_RecStr = G_RecStr + Han1(mapYetaG.get("mnthRnttyLehdrNm"),60)  //임대인이름(상호)(60byte) = 95byte
                                     +  String.format("%-13s", rrnDecCrypt);	//주민번호(13byte) = 108byte
                                   
                          G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyHusFrmCd"),"") );//유형(1byte) = 109byte
                          G_RecStr = G_RecStr +   
                        		  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls
                        				  (mapYetaG.get("mnthRnttyHusCnttArea"),"0.00")))),".","");   //계약면적(5byte), 소수점처리 = 114byte

                          G_RecStr = G_RecStr +  Han1(mapYetaG.get("mnthRnttyRntlAddr"),100)  ; //임대차계약서상주소지(100byte) = 214byte

                          G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlBgnnDt"),"") ;	//계약기간개시일(8byte) = 222byte
                          G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlEndDt"),"") ;	//계약기간종료일(8byte) = 230byte

                          mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyYrlyMnthSum"),"0"));  //연간월세액(10byte) = 240byte
                          G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	
                          mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyTxDducSum"),"0"));   //세액공제금액(10byte) = 250byte
                          G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;	

                          rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("comrCdtrResnRegnNum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                      
                          G_RecStr = G_RecStr + Han1(mapYetaG.get("comrCdtrNm"),60) //대주성명(60byte) = 310byte
                                     + String.format("%-13s", rrnDecCrypt ) ;	//주민번호(13byte) = 323byte
                          G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("comrCnttPridBgnnDt"),"") ;	//개시일(8byte) = 331byte
                          G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("comrCnttPridEndDt"),"")  ;	//종료일(8byte) = 339byte

                          G_RecStr = G_RecStr +  
                        		  StringUtils.replace(String.format("%05.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls
                        				  (mapYetaG.get("comrLoanItrtRate"),"0.00")))),".","") ;     //차입금이자율(4byte), 소수점자리  = 343byte

                          mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrPclttAmtftAggr"),"0")); //원리금상환액(10byte) = 353byte
                          G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;	
                          mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrPrnilSum"),"0")); //원금(10byte) = 363byte
                          G_RecStr = G_RecStr +  String.format("%010d",mTempData02);
                          mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrItrtSum"),"0")); //이자(10byte) = 373byte
                          G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;
                          mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("comrDducSum"),"0")); //공제금액(10byte) = 383byte
                          G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	

                          rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttBusoprRgstnum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                       
                          G_RecStr = G_RecStr + Han1(mapYetaG.get("rntlCttLehdrNm"),60)  //임대인성명(60byte) =443byte
                                     + String.format("%-13s", rrnDecCrypt  );	//주민번호(13byte) = 456byte

                          G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttHusFrmCd"),"")   );	//유형(1byte) = 457byte
                          G_RecStr = G_RecStr +  
                        		  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls
                        				  (mapYetaG.get("rntlCttHusCnttArea"),"0.00")))),".","")  ;     //계약면적(5byte), 소수점자리 = 462byte

                          G_RecStr = G_RecStr +  Han1(mapYetaG.get("rntlCttAddr"),100) ;	//주소지(100byte) = 562byte
                          G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttPridBgnnDt"),"") ;	//개시일(8byte) = 570byte
                          G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttPridEndDt"),"")  ;	//종료일(8byte) = 578byte

                          mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttChrtrGrnteSum"),"0")); //전세보증금(10byte) = 588byte
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
                       if (listYetaG.size() + 1 > G_RowCnt)  { //2
                    	   // 주민번호(복호화)
                    	   rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyBurRgsum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                    	   G_RecStr = G_RecStr + Han1(mapYetaG.get("mnthRnttyLehdrNm"),60)   
                    			   	  +  String.format("%-13s",  rrnDecCrypt);	// - 누적길이 661

                    	   G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyHusFrmCd"),"") );
                    	   G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyHusCnttArea"),"0.00")))),".","");     //소숫점처리

                           G_RecStr = G_RecStr +  Han1(mapYetaG.get("mnthRnttyRntlAddr"),100) ;

                           G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlBgnnDt"),"") ;	// - 누적길이 775
                           G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlEndDt"),"") ;	// - 누적길이 783

                           mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyYrlyMnthSum"),"0"));  
                           G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	// - 누적길이 793
                           mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyTxDducSum"),"0"));   
                           G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;	// - 누적길이 803

                           rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("comrCdtrResnRegnNum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                             
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
                          
                           G_RecStr = G_RecStr + Han1(mapYetaG.get("rntlCttLehdrNm"),60)  
                        		   	  + String.format("%-13s", rrnDecCrypt );

                           G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttHusFrmCd"),"")   );
                           G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttHusCnttArea"),"0.00")))),".","")  ;     //소숫점처리
                           
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
                       }else
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
                       if (listYetaG.size() + 1 > G_RowCnt)  { //3
                    	   // 주민번호(복호화)
                    	   rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyBurRgsum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                    	   G_RecStr = G_RecStr + Han1(mapYetaG.get("mnthRnttyLehdrNm"),60)   
                    			   	  +  String.format("%-13s",  rrnDecCrypt);	// - 누적길이 661

                    	   G_RecStr = G_RecStr +   String.format("%-1s", MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyHusFrmCd"),"") );
                    	   G_RecStr = G_RecStr +   StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyHusCnttArea"),"0.00")))),".","");     //소숫점처리

                           G_RecStr = G_RecStr +  Han1(mapYetaG.get("mnthRnttyRntlAddr"),100) ;

                           G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlBgnnDt"),"") ;	// - 누적길이 775
                           G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyRntlEndDt"),"") ;	// - 누적길이 783

                           mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyYrlyMnthSum"),"0"));  
                           G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	// - 누적길이 793
                           mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("mnthRnttyTxDducSum"),"0"));   
                           G_RecStr = G_RecStr +  String.format("%010d",mTempData02) ;	// - 누적길이 803

                           rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapYetaG.get("comrCdtrResnRegnNum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                             
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
                          
                           G_RecStr = G_RecStr + Han1(mapYetaG.get("rntlCttLehdrNm"),60)  
                        		   	  + String.format("%-13s", rrnDecCrypt );

                           G_RecStr = G_RecStr +  String.format("%-1s",MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttHusFrmCd"),"")   );
                           G_RecStr = G_RecStr +  StringUtils.replace(String.format("%06.2f",(Double.parseDouble(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttHusCnttArea"),"0.00")))),".","")  ;     //소숫점처리
                           
                           G_RecStr = G_RecStr +  Han1(mapYetaG.get("rntlCttAddr"),100) ;
                           G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttPridBgnnDt"),"") ;
                           G_RecStr = G_RecStr + MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttPridEndDt"),"")  ;

                           mTempData02 = Long.parseLong(MSFSharedUtils.defaultNulls(mapYetaG.get("rntlCttChrtrGrnteSum"),"0"));   
                           G_RecStr = G_RecStr +  String.format("%010d",mTempData02);	// - 누적길이 1684

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

                       G_RecStr = G_RecStr +  String.format("%02d", G_Cnt) //일련번호(2byte) = 1696byte
                                      + String.format("%-197s",""); //공란(197byte) = 1893byte

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
	            List listHCData = yeta5400PayrService.fnPayrHC_ReTax_Total_Select(infcPkgYe161020Vo);  
	             
	            
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

		               strTempDataH =  "H" + "20" ; //레코드구분(1byte) + 자료구분(2byte) = 3byte
		               strTempDataH = strTempDataH + infcPkgYe161005Vo.getTxOffcCd(); //세무서코드 (3byte) = 6byte
		               mTempDataH = Long.parseLong(String.valueOf(C_Cnt));
		               strTempDataH = strTempDataH +   String.format("%06d", mTempDataH);    //소득자일련번호(6byte) = 12byte
		               strTempDataH = strTempDataH  +  String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-",""))
		            		   		  + String.format("%-13s",rrnDecCrypt ) ; //사업자등록번호	(10byte) + 주민번호(13byte) = 35byte
		               mTempDataH =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("nnfClCd"),"1"));   //oraQrySelect01.FieldByName('FRNR_YENO').AsFloat;    
		               strTempDataH = strTempDataH +   String.format("%01d", mTempDataH);   	//내외국인구분(1byte) = 36byte 
		               
		               if ((1 != mTempDataH) && (9 != mTempDataH)) {
                     	
		               }  
		               
		               strTempDataH = strTempDataH  +   Han1(mapHCData.get("fnm"),30); //성명(30byte) = 66byte
		               strTempDataH = strTempDataH  +  String.format("%-2s",  MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""));    //유형코드(2byte) = 68byte
                  
		               if (!"10".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))
		            		   && !"20".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	
		            		   && !"40".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	
		            		   && !"41".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	
		            		   && !"42".equals(MSFSharedUtils.defaultNulls(mapHCData.get("ctrbTycd"),""))	) {
		               }
                     
		               mTempDataH =  Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("attrYr"),"0")); 
		               strTempDataH = strTempDataH  +   String.format("%04d", mTempDataH);    //기부연도(4byte) = 72byte
                     
		               mTempDataH =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("useAmt"),"0"));   
		               strTempDataH = strTempDataH  +  String.format("%013d", mTempDataH);   //기부금액(13byte) = 85byte
		               mTempDataH =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("pyrDdcAmt"),"0"));   
		               strTempDataH = strTempDataH  +  String.format("%013d", mTempDataH);  //전년까지공제된금액(13byte) 98byte
		               mTempDataH =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("ddcTrgtAmt"),"0"));   
		               strTempDataH = strTempDataH  + String.format("%013d", mTempDataH);  //공제대상금액 (13byte) = 111byte
                     
		               strTempDataH = strTempDataH  + "0000000000000" ;   //해당년도공제금액 필요경비(13byte) = 124byte
                     
		               mTempDataH =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("thcYrDdcAmt"),"0"));  
		               strTempDataH = strTempDataH  + String.format("%013d", mTempDataH);//해당년도공제금액세액금액(13byte) = 137byte                       
		               mTempDataH =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("thcYrNducExtnAmt"),"0"));   
		               strTempDataH = strTempDataH  + String.format("%013d", mTempDataH); //해당년도공제받지못한금액소멸금액(13byte) = 150byte
		               mTempDataH =    Long.parseLong(MSFSharedUtils.defaultNulls(mapHCData.get("thcYrNducCrfwAmt"),"0"));   
		               strTempDataH = strTempDataH  + String.format("%013d", mTempDataH); //해당년도에 공제받지못한금액_이월금액(13byte) = 163byte
		               strTempDataH = strTempDataH  + String.format("%05d", H_RowCnt);       //기부금조정명세일련번호(5byte) = 168byte
		               strTempDataH = strTempDataH  + String.format("%1725s", "");      //공란(1725byte) = 1893byte

	                   TOT_Record.add(strTempDataH);
	                   H_RowCnt = H_RowCnt + 1;

		          }
 
	               //---------------------------------------------------------------------------------
	               //I레코드 - 해당년도기부금 레코드  
	               //---------------------------------------------------------------------------------  
		          I_Cnt = 1;
		             
		          infcPkgYe161020Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey")));
	              //I레코드 - 해당연도 기부명세 레코드  
	              List listHDData = yeta5400PayrService.fnPayrHD_ReTax_Total_Select(infcPkgYe161020Vo); 
	               
	             if (listHCData.size() > 0) { 
	              
	              Iterator<Map<String, Object>> iter02 = listHDData.iterator(); 
	        	   
		          while ( iter02.hasNext() ) { 
		            	
		            Map<String, Object> mapHDData = (Map<String, Object>) iter02.next();

	                strTempDataI = "";
	                mTempDataI  = 0L;

	                // 주민번호(복호화)
	                rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapYetaC.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	                
	                strTempDataI =  "I" + "20"; //레코드구분(1byte) + 자료구분(2byte) = 3byte
	                strTempDataI = strTempDataI + infcPkgYe161005Vo.getTxOffcCd();  //세무서코드 (3byte) = 6byte
	                strTempDataI = strTempDataI + String.format("%06d", C_Cnt);     //소득자일련번호 (6byte) = 12byte
	                strTempDataI = strTempDataI + String.format("%-10s", StringUtils.replace(infcPkgYe161005Vo.getBusoprRgstnum(),"-",""));   //사업자등록번호 (10byte) = 22byte
                       
	                strTempDataI = strTempDataI +  String.format("%-13s", rrnDecCrypt);      //소득자주민등록번호(13byte) = 35byte
	                strTempDataI = strTempDataI +  String.format("%-2s",  MSFSharedUtils.defaultNulls(mapHDData.get("conbChgCd"),""));     //유형코드(2byte) = 37byte
	                
	                strTempDataI = strTempDataI +  String.format("%01d", 1);      //기부내용(1byte) = 38byte
					   
                       
	                strTempDataI = strTempDataI 
	                		+  String.format("%-13s", StringUtils.replace(MSFSharedUtils.defaultNulls
	                				(mapHDData.get("bsnoEncCntn"),""),"-",""));    //사업자등록번호(13byte) = 51byte

	                strTempDataI = strTempDataI + Han1(mapHDData.get("coplNm"),60);	//상호(60byte) = 111byte
                                        
	                strTempDataI = strTempDataI +  String.format("%-1s",  MSFSharedUtils.defaultNulls(mapHDData.get("cnbtRltChgCd"),""));  //관계코드(1byte) = 112byte
	                strTempDataI = strTempDataI +  String.format("%-1s",  MSFSharedUtils.defaultNulls(mapHDData.get("nnfClCd"),""));     //내외국인구분코드(1byte) = 113byte
                    strTempDataI = strTempDataI +  Han1(mapHDData.get("cnbtFnm"),30); 	//성명(30byte) = 143byte
                    // 주민번호(복호화)
                    rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapHDData.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                    
                    strTempDataI = strTempDataI +  String.format("%-13s", rrnDecCrypt);    //기부자주민등록번호(13byte) = 156byte
                    mTempDataI =   Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("dntScnt"),"1"));   
                    strTempDataI = strTempDataI +  String.format("%05d", mTempDataI);   //건수(5byte) = 161byte
                    
                    mTempDataI = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("useSumAmt"),"0"));   
                    strTempDataI = strTempDataI +  String.format("%013d", mTempDataI);     //기부금액합계 (13byte) = 174byte

                    //2016년 추가 -----
                    mTempDataI = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("ddcTrgtConbAmt"),"0"));   
                    strTempDataI = strTempDataI +  String.format("%013d", mTempDataI);     //공제대상기부금액(13byte) = 187byte
                    mTempDataI = Long.parseLong(MSFSharedUtils.defaultNulls(mapHDData.get("conbSumAmt"),"0"));   
                    strTempDataI = strTempDataI +  String.format("%013d", mTempDataI);     //기부장려신청금액(13byte) = 200byte
                    
                    strTempDataI = strTempDataI +  "0000000000000";	//기타(13byte) = 213byte
                       
                    strTempDataI = strTempDataI + String.format("%05d", I_Cnt);    //일련번호 (5byte) = 218byte
                       
                    strTempDataI = strTempDataI +  String.format("%1675s", "");    //공란 (1675byte) = 1893byte

	                   TOT_Record.add(strTempDataI);

	                      I_Cnt = I_Cnt + 1;
		           }
	             } 

	         
               C_Cnt = C_Cnt + 1;  
               
               //파일생성전 제출일자업데이트 쿼리 추가 
               // infcPkgYeta17FileDAO.updateYeta5400ToYe161010_S
              ye161010VO.setSystemkey(MSFSharedUtils.allowNulls(mapYetaC.get("systemkey"))); 
              yeta5400PayrService.updateYeta5400ToYe161010(ye161010VO); 

          } 
          
       
          
          File dir = new File("C:/EOSDATA/2020/");
          //디렉토리가 없으면 생성
          if(!dir.isDirectory()){
           dir.mkdirs();
          }
          
//        TOT_Record.SaveToFile('C:\EOSDATA\' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3) + '.denc');
          String fileDir = "C:/EOSDATA/2020/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc";
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
          
          File objFile = new File("C:/EOSDATA/2020/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc");
          
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
  
  public int fnYeta5400_Tax_Ye1611010_File_Create(HttpServletRequest request,InfcPkgYe161010_2020_VO  ye161010VO,HttpServletResponse response) throws Exception  {
	 
	  if  (yeta5400PayrService== null) {
		    WebApplicationContext wac = WebApplicationContextUtils.
		    		getRequiredWebApplicationContext( request.getSession().getServletContext());
		  
		    yeta5400PayrService = (Yeta5400PayrService) wac.getBean("Yeta5400PayrService");
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
      * @Method Name : fnYeta1400_ReTax_Yeta4140_Create
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
  public int fnYeta5400_Tax_Ye164010_File_Create(HttpServletRequest request,InfcPkgYe161010_2020_VO  ye161010VO,HttpServletResponse response) throws Exception  {
    	
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
    		
    		 if  (yeta5400PayrService== null) {
    			    WebApplicationContext wac = WebApplicationContextUtils.
    			    		getRequiredWebApplicationContext( request.getSession().getServletContext());
    			  
    			    yeta5400PayrService = (Yeta5400PayrService) wac.getBean("Yeta5400PayrService");
    			}
    		  
    		
    		 InfcPkgYe161005_2020_VO    infcPkgYe161005Vo	 = new InfcPkgYe161005_2020_VO();	//A_원천세신고기본
    		 BeanUtils.copyProperties(infcPkgYe161005Vo, ye161010VO);
    		    
    		 infcPkgYe161005Vo  = yeta5400PayrService.selectYe161005(ye161010VO);

        	   String defBUNS_LINS = StringUtils.replace(MSFSharedUtils.allowNulls(infcPkgYe161005Vo.getBusoprRgstnum()),"-","") ; //사업자번호  
        	   
    		    
    	    InfcPkgYe161020_2020_VO    infcPkgYe161020Vo	 = new InfcPkgYe161020_2020_VO();	//A_인적소득공제기본
    	    BeanUtils.copyProperties(infcPkgYe161020Vo, ye161010VO);
    	     
    		// A레코드 - 의료비지급명세서 레코드
    		List listYetaCA = yeta5400PayrService.fnPayrPSNL_ReTax_CA_Total_Select(infcPkgYe161020Vo);

    		if  (listYetaCA.size() > 0) { 
 
    		 	A_Cnt = 1;
    		
    			  Iterator<Map<String, Object>> iter = listYetaCA.iterator(); 
    	      	   
    	          while ( iter.hasNext() ) { 
    	          
    	            Map<String, Object> mapCAData = (Map<String, Object>) iter.next();  
    		  //	for (int i = 0 ; i < listYeta1.size() ; i++) { 
    	            
    	            infcPkgYe161020Vo.setSystemkey(MSFSharedUtils.allowNulls(mapCAData.get("systemkey"))); 
    	            
    	            //A레코드 - 의료비지급명세서 레코드  내역 
    	            List listCAYeta = yeta5400PayrService.fnPayrCA_ReTax_Total_Select(infcPkgYe161020Vo);
    				
    	            Iterator<Map<String, Object>> iter01 = listCAYeta.iterator(); 
     	      	   
      	            while ( iter01.hasNext() ) { 
      	            	
      	            Map<String, Object> mapCAYeta = (Map<String, Object>) iter01.next(); 
      	            
	    				A_RecStr = "";
						A_RecStr = "A" + "26" + infcPkgYe161005Vo.getTxOffcCd(); //레코드구분(1byte) + 자료구분(2byte) + 세무서코드(3byte) = 6byte
						A_RecStr = A_RecStr + String.format("%06d", A_Cnt); //일련번호(6byte) = 12byte
						A_RecStr = A_RecStr + StringUtils.replace(MSFSharedUtils.allowNulls(ye161010VO.getEdacPrdt()) ,"-","") ; //제출년월일(8byte) = 20byte
						A_RecStr = A_RecStr + defBUNS_LINS; //사업자등록번호(10byte) = 30byte
						A_RecStr = A_RecStr + String.format("%-20s", infcPkgYe161005Vo.getHmtxId()); //홈텍스id(20byte) = 50byte
						A_RecStr = A_RecStr + String.format("%-4s", infcPkgYe161005Vo.getTxPgmCd()); //세무프로그램코드(4byte) = 54byte
						A_RecStr = A_RecStr + "2020"; //년도(4byte) = 58byte
						A_RecStr = A_RecStr + defBUNS_LINS; //사업자등록번호(10byte) = 68byte
						A_RecStr = A_RecStr + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(infcPkgYe161005Vo.getCorpFmnmNm() ,38),40," ") ; //상호(40byte) = 108byte

						/* 
						10번까지는 화면에서 받아온 vo (ye161010VO) 이용
						이후는 select 결과 vo (infcPkgYeta4140Vo) 이용*/

						// 주민번호(복호화)
						 String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapCAData.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						    		          	
						
						A_RecStr = A_RecStr +    String.format("%-13s",rrnDecCrypt );     //주민번호(13byte) = 121byte
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAData.get("orgNnfClCd"),"1")); //내외국인코드(1byte) = 122byte
						A_RecStr = A_RecStr + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes(MSFSharedUtils.defaultNulls(mapCAData.get("fnm"),""),28),30 ," "); //이름(30byte) = 152byte
						
						A_RecStr = A_RecStr + String.format("%-10s", StringUtils.replace(MSFSharedUtils.defaultNulls(mapCAYeta.get("bsnoEncCntn"),""),"-",""));  //사업자등록번호(10byte) = 162byte
						A_RecStr = A_RecStr + PkgFuncUtils.getRHanPad(PkgFuncUtils.subStringBytes( MSFSharedUtils.defaultNulls(mapCAYeta.get("plymNm"),"") ,38),40," "); //상호(40byte) = 202byte
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.allowNulls(mapCAYeta.get("mdxpsPrfClCd")));//의료증빙코드(1byte) = 203byte
						//203
						mTempData01 =  Long.parseLong(MSFSharedUtils.defaultNulls(mapCAYeta.get("scnt"),"0"));  
						A_RecStr = A_RecStr + String.format("%05d", mTempData01); //건수(5byte) = 208byte
						//A_RecStr = A_RecStr + String.format("%05d", infcPkgYeta4140Vo.getMediCfcd()); // 17 건수
						
						mTempData01 = Math.abs(Long.parseLong(MSFSharedUtils.defaultNulls(mapCAYeta.get("useAmt"),"0")));   
						A_RecStr = A_RecStr + String.format("%011d", mTempData01); //금액(11byte) = 219byte
						//A_RecStr = A_RecStr + String.format("%011d", infcPkgYeta4140Vo.getCashUeam()); // 18 금액
						
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAYeta.get("yn2"),""));   //난임여부(1byte) = 220byte
						//220
						
						// 주민번호(복호화)
						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,StringUtils.replace(MSFSharedUtils.defaultNulls(mapCAYeta.get("resnoEncCntn"),""),"-","").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						   
						A_RecStr = A_RecStr + String.format("%-13s",rrnDecCrypt ); // 20 주민번호 번호	(13byte) = 233byte					
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAYeta.get("nnfClCd"),"1")); // 21 내,외국인 코드(1byte) = 234byte
						A_RecStr = A_RecStr + String.format("%-1s", MSFSharedUtils.defaultNulls(mapCAYeta.get("yn"),"2")); // 22 본인 등 해당여부(1byte) = 235byte
						A_RecStr = A_RecStr + "1"; // todo 내용 처리 23 제출대상기간 코드(1byte) = 236byte
										
						TOT_Record.add(A_RecStr);
							    
						A_Cnt = A_Cnt + 1;
	    				}
    			}
    		}
    		else {
    			throw new Exception("의료비 A레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.");  
    			//showMessage('의료비 A레코드 생성을 위한 정산데이터가 생성되지 않은것 같습니다. 확인후 파일생성을 해 주십시요.');
    		}
    		
    		 File dir = new File("C:/EOSDATA/2020/");
	          //디렉토리가 없으면 생성
	          if(!dir.isDirectory()){
	           dir.mkdirs();
	          }
	          
    		//TOT_Record.SaveToFile('C:\EOSDATA\' + DEFIN + leftStr(defBUNS_LINS,7) + '.' + rightStr(defBUNS_LINS,3) + '.denc');
    		      String fileDir = "C:/EOSDATA/2020/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc";
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
    	          
    	          File objFile = new File("C:/EOSDATA/2020/" + DEFIN + StringUtils.left(defBUNS_LINS,7) + "." + StringUtils.right(defBUNS_LINS,3) + ".denc");
    	          
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
  * @Method Name : fnYeta1400_ReTax_Yeta4180_Create
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
  public int fnYeta5400_Tax_Ye165010_File_Create(HttpServletRequest request,InfcPkgYe161010_2020_VO  ye161010VO,HttpServletResponse response) throws Exception { 
  
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
// 	       Map mapHb = yeta5400PayrService.fnPayrHB_ReTax_Total_Select(ye161010VO);
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
//	          mTempDataB =    Long.parseLong( MSFSharedUtils.defaultNulls(mapHb.get("yeta4180Cnt"),"0"));     
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
// 	         List listTotData01 = yeta5400PayrService.fnPayrPSNL_ReTax_Total_Select(ye161010VO);
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
//	            List listHCData = yeta5400PayrService.fnPayrHC_ReTax_Total_Select(ye161010VO);  
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
// 	              List listHDData = yeta5400PayrService.fnPayrHD_ReTax_Total_Select(ye161010VO); 
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
 
  
 

  public List<YetaMessageVO> fnYeta5400_Tax_Ye161010_File_Check(HttpServletRequest request,InfcPkgYe161010_2020_VO  ye161010VO,HttpServletResponse response) throws Exception  {
	  
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
      * @Method Name : fnYeta1400_ReTax_Yeta4140_Create
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
  public List<YetaMessageVO> fnYeta5400_Tax_Ye164010_File_Check(HttpServletRequest request,InfcPkgYe161010_2020_VO  ye161010VO,HttpServletResponse response) throws Exception  {
    	
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
  * @Method Name : fnYeta1400_ReTax_Yeta4180_Create
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
 public List<YetaMessageVO> fnYeta5400_Tax_Ye165010_File_Check(HttpServletRequest request,InfcPkgYe161010_2020_VO  ye161010VO,HttpServletResponse response) throws Exception { 
  
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
