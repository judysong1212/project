package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2016.pdf.xml.web;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.egov.comutils.payr.PkgFuncUtils;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3100VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3140VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3150VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3180VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3220SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3220VO;
import com.app.smrmf.pkg.yeta.yeta2016.pdfxml.service.YetaPayr1200Service;
//import com.app.smrmf.props.ExtermsProps;
import com.dreamsecurity.exception.DVException;
import com.dreamsecurity.verify.DSTSPDFSig;
import com.epapyrus.api.ExportCustomFile;

import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class Yeta1200XmlController {


    private static final Logger logger = LoggerFactory.getLogger(Yeta1200XmlController.class);  
 
    
    @Resource(name = "YetaPayr1200Service")
    private YetaPayr1200Service yetaPayr1200Service;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    private String p_pwd = "";  // 비밀번호
    private String key = "XML";  //key 

    
    @RequestMapping(value = "/imp/XmlYeta1200Import.do")
    public String xmlYeta1200Import(@ModelAttribute("InfcPkgYeta2000VO") InfcPkgYeta2000VO yeta2000VO,final HttpServletRequest request
            , Map commandMap , Model model) throws Exception {
    	
    	String p_pwd = "";
        String sResult = "";
    	  
        if  (yetaPayr1200Service == null) { 
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            yetaPayr1200Service = (YetaPayr1200Service) wac.getBean("YetaPayr1200Service" ); 
           
       }
        
         
        try	{

        	/* 업로드 파일 정의 부분(해당 시스템에서 사용하는  파일 업로드 패키지에 따라 수정 필요) */
        	//DiskFileUpload fileUpload = new DiskFileUpload();

        	/* 업로드 컨텐츠 목록 추출 */
        	//List fileItemList   = fileUpload.parseRequest(request);

        	/* 업로드 컨텐츠 종류에 따라 반복 처리 */
        	//int v_fileCnt = fileItemList.size();
        	//for(int i = 0 ; i < v_fileCnt ; i++) {

            
            final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            final Map<String, MultipartFile> files = multiRequest.getFileMap();
           // InputStream fis = null; // 2011.11.1 보안점검 후속조치 
 
            Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
            MultipartFile file; 
    		
            
            while (itr.hasNext()) {
                Entry<String, MultipartFile> entry = itr.next();

                file = entry.getValue();
                
             	
            	// 	FileItem fileItem = (FileItem) fileItemList.get(i);

            		/* 문서 비밀번호 가져오기(비밀번호 없는 문서일 경우 생략 가능. 이 때 p_pwd="") */
            		// 방식1.사용자 입력 방식인 경우(폼필드 입력값 추출)
            	//	if (fileItem.isFormField()) {
            	//		if (fileItem.getFieldName().equals("p_pwd")) {
            	//			p_pwd = fileItem.getString();
            		//		continue;
            		//	}
            		//}
                // 방식2.파일명등의 정보를 기준으로 인사DB 등에서 가져오는 경우
        		// 비밀번호를 가져오는 로직 구현 
                if (Boolean.TRUE.equals(yeta2000VO.getCreOriginYn())) {
            	   p_pwd = yeta2000VO.getCrePasswd();  // 인사정보 등에서 가져오기
                } 
                
            	// path 제외한 파일명만 취득
        		//String[] filePath = fileItem.getName().split("\\\\");
        		//String fileName = filePath[filePath.length -1]; //파일명(ex:abcd.pdf)
        		//System.out.println("\n\n<!-- [" + fileName + "] -->");

        		// PDF파일이 아닌 경우 skip
//        		if (!fileName.toUpperCase().endsWith(".PDF")) {
//        			out.println("<!-- PDF 파일이 아닙니다. -->");
//        			continue;
//        		}
        		
                if (!"".equals(file.getOriginalFilename())) {
                    // 2011.10.07 업로드 파일에 대한 확장자를 체크
                    if (file.getOriginalFilename().toUpperCase().endsWith(".PDF") ) {
                    	
                     	// 파일내용을 읽음
                		byte[] pdfBytes = file.getBytes();   //fileItem.get();
                		boolean isSuccess = false;
                    if (Boolean.TRUE.equals(yeta2000VO.getCreOriginYn())) {
                		/* [Step1] 전자문서 위변조 검증 */
                		try {
                			
                			DSTSPDFSig dstsPdfsig = new DSTSPDFSig();
                			
                			dstsPdfsig.init(pdfBytes);
                			dstsPdfsig.tokenParse();

                			isSuccess = dstsPdfsig.tokenVerify();
                			
                			if( isSuccess ) {
                				System.out.println("<!-- 검증 완료(진본) -->");
                			} else {
                				String msg = dstsPdfsig.getTstVerifyFailInfo();
                				System.out.println(msg);
                				sResult =  "success";
                			}
                		} catch (DVException e) {
                			System.out.println("에러 코드 : "+ e.getLastError());
                			System.out.println("에러 메시지 : "+ e.getMessage());
                			sResult = "error";
                		}
                     } else {
                    	 isSuccess = true;
                     }
                		/* [Step2] XML(or SAM) 데이터 추출 */

                		try {
                			if (isSuccess) {
                				ExportCustomFile pdf = new ExportCustomFile();
                	
                				// 데이터 추출
                				byte[] buf = pdf.NTS_GetFileBufEx(pdfBytes, p_pwd, key, false );
                				int v_ret = pdf.NTS_GetLastError();
                	
                				if (v_ret == 1) {
                					String strXml = new String( buf, "UTF-8" );
                					// 정상적으로 추출된 데이터 활용하는 로직 구현 부분 
                					System.out.print(strXml.replace("<", "&lt;")
                							.replace(">", "&gt;")
                							.replace(" ", "&nbsp;")
                							.replace("\n", "<br/>")
                							.replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"));   // 예  화면에 출력
                					
                					  //DOM Document 객체 생성하기 위한 메서드 
                		               DocumentBuilderFactory factory   = DocumentBuilderFactory.newInstance();
                		               //DOM 파서로부터 입력받은 파일을 파싱하도록 요청
                		               DocumentBuilder builder = factory.newDocumentBuilder(); 
                		            
                		               Document xmlDoc = null; 
                		               //DOM 파서로부터 입력받은 파일을 파싱하도록 요청 
                		               //*****************************************************
                		               xmlDoc  =  builder.parse(new InputSource(new StringReader(strXml)));
                		               //*****************************************************
                		               xmlDoc.getDocumentElement().normalize(); 
                		               
                		               PayrXmlDataInsert(yeta2000VO, xmlDoc, commandMap);
                		               
                		               sResult =  "success";
                					
                				} else if (v_ret == 0) {
                					System.out.println("연말정산간소화 표준 전자문서가 아닙니다.");
                					sResult =  "error";
                				} else if (v_ret == -1) {
                					System.out.println("비밀번호가 틀립니다.");
                					sResult =  "error";
                				} else if (v_ret == -2) {
                					System.out.println("PDF문서가 아니거나 손상된 문서입니다.");
                					sResult =  "error";
                				} else {
                					System.out.println("데이터 추출에 실패하였습니다.");
                					sResult =  "error";
                				}
                			}
                			
                		} catch (Exception e) {
                			sResult =  "error";
                			System.out.println("[Step2] 데이터 추출 실패(" + e.toString() + ")");
                			continue;
                		}
                    	
                   }else{
                        logger.info("PDF 파일 타입만 등록이 가능합니다."); 
                        sResult =  "error";
                   }
                }
            }    
                        
                      
        } catch(Exception e) {
        	e.printStackTrace();
        	System.out.println("Exception" + e.getMessage());
        	sResult = "error";
        } 
   
        return sResult;
 
    }  
    

    @RequestMapping(value = "/imp/XmlYeta1200UpImport.do")
    public String xmlYeta1200UpImport(@ModelAttribute("InfcPkgYeta2000VO") InfcPkgYeta2000VO yeta2000VO,final HttpServletRequest request
            , Map commandMap , Model model) throws Exception {
         
    	String p_pwd = "";
        String sResult = "";
    	  
        if  (yetaPayr1200Service == null) { 
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            yetaPayr1200Service = (YetaPayr1200Service) wac.getBean("YetaPayr1200Service" ); 
           
       }
        
         
        try	{

        	/* 업로드 파일 정의 부분(해당 시스템에서 사용하는  파일 업로드 패키지에 따라 수정 필요) */
        	//DiskFileUpload fileUpload = new DiskFileUpload();

        	/* 업로드 컨텐츠 목록 추출 */
        	//List fileItemList   = fileUpload.parseRequest(request);

        	/* 업로드 컨텐츠 종류에 따라 반복 처리 */
        	//int v_fileCnt = fileItemList.size();
        	//for(int i = 0 ; i < v_fileCnt ; i++) {

            
            final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            final Map<String, MultipartFile> files = multiRequest.getFileMap();
           // InputStream fis = null; // 2011.11.1 보안점검 후속조치 
 
            Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
            MultipartFile file; 
    		
            
            while (itr.hasNext()) {
                Entry<String, MultipartFile> entry = itr.next();

                file = entry.getValue();
                
             	
            	// 	FileItem fileItem = (FileItem) fileItemList.get(i);

            		/* 문서 비밀번호 가져오기(비밀번호 없는 문서일 경우 생략 가능. 이 때 p_pwd="") */
            		// 방식1.사용자 입력 방식인 경우(폼필드 입력값 추출)
            	//	if (fileItem.isFormField()) {
            	//		if (fileItem.getFieldName().equals("p_pwd")) {
            	//			p_pwd = fileItem.getString();
            		//		continue;
            		//	}
            		//}
                // 방식2.파일명등의 정보를 기준으로 인사DB 등에서 가져오는 경우
        		// 비밀번호를 가져오는 로직 구현 
                if (Boolean.TRUE.equals(yeta2000VO.getCreOriginYn())) {
            	   p_pwd = yeta2000VO.getCrePasswd();  // 인사정보 등에서 가져오기
                } 
                
            	// path 제외한 파일명만 취득
        		//String[] filePath = fileItem.getName().split("\\\\");
        		//String fileName = filePath[filePath.length -1]; //파일명(ex:abcd.pdf)
        		//System.out.println("\n\n<!-- [" + fileName + "] -->");

        		// PDF파일이 아닌 경우 skip
//        		if (!fileName.toUpperCase().endsWith(".PDF")) {
//        			out.println("<!-- PDF 파일이 아닙니다. -->");
//        			continue;
//        		}
        		
                if (!"".equals(file.getOriginalFilename())) {
                    // 2011.10.07 업로드 파일에 대한 확장자를 체크
                    if (file.getOriginalFilename().toUpperCase().endsWith(".PDF") ) {
                    	
                     	// 파일내용을 읽음
                		byte[] pdfBytes = file.getBytes();   //fileItem.get();
                		boolean isSuccess = false;
                    if (Boolean.TRUE.equals(yeta2000VO.getCreOriginYn())) {
                		/* [Step1] 전자문서 위변조 검증 */
                		try {
                			
                			DSTSPDFSig dstsPdfsig = new DSTSPDFSig();
                			
                			dstsPdfsig.init(pdfBytes);
                			dstsPdfsig.tokenParse();

                			isSuccess = dstsPdfsig.tokenVerify();
                			
                			if( isSuccess ) {
                				System.out.println("<!-- 검증 완료(진본) -->");
                			} else {
                				String msg = dstsPdfsig.getTstVerifyFailInfo();
                				System.out.println(msg);
                				sResult =  "success";
                			}
                		} catch (DVException e) {
                			System.out.println("에러 코드 : "+ e.getLastError());
                			System.out.println("에러 메시지 : "+ e.getMessage());
                			sResult = "error";
                		}
                     } else {
                    	 isSuccess = true;
                     }
                		/* [Step2] XML(or SAM) 데이터 추출 */ 
                		try {
                			if (isSuccess) {
                				ExportCustomFile pdf = new ExportCustomFile();
                	
                				// 데이터 추출
                				byte[] buf = pdf.NTS_GetFileBufEx(pdfBytes, p_pwd, key, false );
                				int v_ret = pdf.NTS_GetLastError();
                	
                				if (v_ret == 1) {
                					String strXml = new String( buf, "UTF-8" );
                					// 정상적으로 추출된 데이터 활용하는 로직 구현 부분 
                					System.out.print(strXml.replace("<", "&lt;")
                							.replace(">", "&gt;")
                							.replace(" ", "&nbsp;")
                							.replace("\n", "<br/>")
                							.replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"));   // 예  화면에 출력
                					
                					  //DOM Document 객체 생성하기 위한 메서드 
                		               DocumentBuilderFactory factory   = DocumentBuilderFactory.newInstance();
                		               //DOM 파서로부터 입력받은 파일을 파싱하도록 요청
                		               DocumentBuilder builder = factory.newDocumentBuilder(); 
                		            
                		               Document xmlDoc = null; 
                		               //DOM 파서로부터 입력받은 파일을 파싱하도록 요청 
                		               //*****************************************************
                		               xmlDoc  =  builder.parse(new InputSource(new StringReader(strXml)));
                		               //*****************************************************
                		               xmlDoc.getDocumentElement().normalize(); 
                		               
                		               PayrXmlDataUpdate(yeta2000VO, xmlDoc, commandMap);
                		               
                		               sResult =  "success";
                					
                				} else if (v_ret == 0) {
                					System.out.println("연말정산간소화 표준 전자문서가 아닙니다.");
                					sResult =  "error";
                				} else if (v_ret == -1) {
                					System.out.println("비밀번호가 틀립니다.");
                					sResult =  "error";
                				} else if (v_ret == -2) {
                					System.out.println("PDF문서가 아니거나 손상된 문서입니다.");
                					sResult =  "error";
                				} else {
                					System.out.println("데이터 추출에 실패하였습니다.");
                					sResult =  "error";
                				}
                			}
                			
                		} catch (Exception e) {
                			sResult =  "error";
                			System.out.println("[Step2] 데이터 추출 실패(" + e.toString() + ")");
                			continue;
                		}
                    	
                   }else{
                        logger.info("PDF 파일 타입만 등록이 가능합니다."); 
                        sResult =  "error";
                   }
                }
            }    
                        
                      
        } catch(Exception e) {
        	e.printStackTrace();
        	System.out.println("Exception" + e.getMessage());
        	sResult = "error";
        } 
   
        return sResult;
 
    }  
    
    	 
   private void PayrXmlDataInsert(InfcPkgYeta2000VO yeta2000Vo, Document xmlDoc, Map commandMap) {
	 
	   List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	  // int i,j,k,l  = 0;
	   boolean boolLogin = false ;
	   String FileName = "";
	   
	   
	   Node xmlItemDoc = null;
	   Element  xmlItemMain  = null;
	   Element  xmlelDoc  = null;
	 
	   NodeList xmlItemForm = null;
	   
	   Node subXmlItemForm = null;
	   Element  subXmlElForm = null; 
	   NodeList subXmlElChildForm = null;
	   
	   Node subXmlItemMan = null;
	   Element subXmlElMan = null;
	   NodeList subXmlElChildMan = null;
	   NodeList subXmlElChildSum = null;
	   
	   Node subXmlItemData = null;
	   Node subXmlItemSum = null;
	   Element subXmlElData = null;
	   Element subXmlElSum = null;
	   
	   NodeList subXmlItemDD = null;
	   
	   String dataType = "";
	   String dataPrDate  = "";
	   String dataYear = "";
	   String dataFrmMm = "";
	   String dataToMm = "";
	   String dataInqrMm = "";
	   
	   String  strFormCd  = "";
	   String strDatCd = "";
	   String strSum = "";
	   
	   Boolean MediBoolean = false;
	   
	   
	   //TODO 건강보험료 및 국민연금보험료 변수 
	   String strHiYrs = ""; //건강보험연말정산금액
	   String strItrmYrs = ""; //장기요양연말정산금액
	   String strHiNtf = ""; //건강보험(보수월액)고지금액합계
	   String strItrmNtf = ""; //장기요양(보수월액)고지금액합계
	   String strHiPmt = ""; //건강보험(소득월액)납부금액합계
	   String strItrmPmt = ""; //장기요양(소득월액)납부금액합계
	   
	   String strNtf = ""; //직장가입자 고지금액 합계_국민연금
	   String strPmt = ""; //지역가입자 등 납부금액 합계_국민연금
	   
	   BigDecimal edSpciGurtSum = BigDecimal.ZERO; // 보장성 보험료 총 합계 금액 
	   BigDecimal  edSpciHdrcSum = BigDecimal.ZERO; // 장애인전용보장성보험료 총 합계 금액
	   
	   BigDecimal edSpciGurtSum01 = BigDecimal.ZERO; // 보장성 보험료 총 합계 금액(본인 외)
	   BigDecimal  edSpciHdrcSum01 = BigDecimal.ZERO; // 장애인전용보장성보험료 총 합계 금액(본인 외)
	   
	   BigDecimal edSpciGurtSum02 = BigDecimal.ZERO; // 보장성 보험료 총 합계 금액(본인 외)
	   BigDecimal  edSpciHdrcSum02 = BigDecimal.ZERO; // 장애인전용보장성보험료 총 합계 금액(본인 외)
	   
	   
	   int ddCnt = 0; 
	   BigDecimal ddCnt1 = BigDecimal.ZERO;
	   String schBrith = "";
	   String strBusnid = ""; 
	   String strResid = "";
	   BigDecimal exCASH_UEAM = BigDecimal.ZERO;
	   BigDecimal edSpedSelf = BigDecimal.ZERO;
	   BigDecimal  edSpciScam  = BigDecimal.ZERO;
	   String strEduTp = "";
	   String[][] arrPayr445 = new String[10][4];
	   
	   BigDecimal edEDAC_OTAM01 = BigDecimal.ZERO;
	   BigDecimal edEDAC_OTAM02 = BigDecimal.ZERO;
	   BigDecimal edEDAC_OTAM03 = BigDecimal.ZERO; 
	    
	   BigDecimal edSpedEdam  = BigDecimal.ZERO;
	   BigDecimal edSpedGdam  = BigDecimal.ZERO;
	   BigDecimal edSpedCvam = BigDecimal.ZERO;
	   BigDecimal edPrvm20be  = BigDecimal.ZERO;
       
	   String strSql = "";
	   BigDecimal edPrvm21af   = BigDecimal.ZERO;
	   BigDecimal edJrtrPsct  = BigDecimal.ZERO;
	   BigDecimal edJRTR_CICT  = BigDecimal.ZERO;
	   BigDecimal edTemp      = BigDecimal.ZERO;
	   BigDecimal edETCT_CARD  = BigDecimal.ZERO;
	   BigDecimal edETCH_MGVD = BigDecimal.ZERO;
	   BigDecimal edETCH_UEAM = BigDecimal.ZERO;
	   BigDecimal edETCH_BCBS = BigDecimal.ZERO;
	   BigDecimal edETCH_BCED  = BigDecimal.ZERO; 
	   BigDecimal edSpciRefn  = BigDecimal.ZERO;
	   BigDecimal edSpchRe06  = BigDecimal.ZERO;
	   BigDecimal edSpchRe10 = BigDecimal.ZERO;
	   BigDecimal edSpchRe15 = BigDecimal.ZERO;
	   BigDecimal edSPCH_REFX = BigDecimal.ZERO; 
	   BigDecimal edSPCH_REEC  = BigDecimal.ZERO; 
	   BigDecimal edETCS_COMP = BigDecimal.ZERO; 
	   BigDecimal edETWK_HSBM = BigDecimal.ZERO;
	   BigDecimal edMonyItre  = BigDecimal.ZERO;
	   BigDecimal edEtchPrep  = BigDecimal.ZERO;
	   BigDecimal edSpciHhLh  = BigDecimal.ZERO;
	   BigDecimal edJnatPsnf  = BigDecimal.ZERO;
	   BigDecimal edEtchPrepStartDt = BigDecimal.ZERO;
	   BigDecimal edEtchPrepEndDt = BigDecimal.ZERO;
	   BigDecimal edCARD_MONI = BigDecimal.ZERO; 
	   BigDecimal edCARD_BCED  = BigDecimal.ZERO;
       
	   BigDecimal edSPCH_15FX = BigDecimal.ZERO;
	   BigDecimal edSPCH_15FB = BigDecimal.ZERO;
	   BigDecimal edSPCH_15EC = BigDecimal.ZERO;
	   BigDecimal edSPCH_10FB = BigDecimal.ZERO;
       
	   int ldCnt = 0;
	   
	   BigDecimal edCARD_ET13 = BigDecimal.ZERO;
	   BigDecimal edCARD_ET14  = BigDecimal.ZERO;
	   BigDecimal edETAD_DD13  = BigDecimal.ZERO;
	   BigDecimal edETAD_D14L = BigDecimal.ZERO;
	   
	   BigDecimal edCARD_ET15 = BigDecimal.ZERO;
	   BigDecimal edETAD_D15H = BigDecimal.ZERO;
	   BigDecimal edETAD_D15L = BigDecimal.ZERO;
	   
	   BigDecimal edETAD_D16L = BigDecimal.ZERO; //신용카드 2016년도 상반기 본인 추가공제율
	   
	   BigDecimal edSpciFbam = BigDecimal.ZERO;
	   BigDecimal edSpciPltc = BigDecimal.ZERO;
	   BigDecimal edSpciExam = BigDecimal.ZERO;
	   BigDecimal edSpciUnon = BigDecimal.ZERO;
	   BigDecimal edSpciNamt = BigDecimal.ZERO;
	   BigDecimal edSpciYamt = BigDecimal.ZERO;
	   BigDecimal edSPCI_HFAM = BigDecimal.ZERO;
	 
	   BigDecimal edETWK_HSVM  = BigDecimal.ZERO;
	   BigDecimal edETEP_SEST   = BigDecimal.ZERO;
	   String[][] arrCARD_PAY = new String[10][4];  
	   String[][] arrMONI_PAY = new String[10][4]; 
	   String[][] arrBCBS_PAY = new String[10][4];  
	   String[][] arrSPCI_PAY = new String[10][4];  
	   String[][] arrHDRC_PAY = new String[10][4];  
	   String[][] arrCASH_PAY = new String[10][4];  

	 

	       edSpedSelf = BigDecimal.ZERO;
	       edSpciScam  = BigDecimal.ZERO;
	       edEDAC_OTAM01 = BigDecimal.ZERO;
	       edEDAC_OTAM02  = BigDecimal.ZERO;
	       edEDAC_OTAM03  = BigDecimal.ZERO;
	       edETEP_SEST  = BigDecimal.ZERO;
	      // edETWK_HSVM  = BigDecimal.ZERO;
	       edPrvm21af  = BigDecimal.ZERO;
	       edJrtrPsct  = BigDecimal.ZERO;
	       edJRTR_CICT  = BigDecimal.ZERO;
	       edTemp  = BigDecimal.ZERO;
	       edETCT_CARD  = BigDecimal.ZERO;
	       edETCH_MGVD   = BigDecimal.ZERO;
	       edETCH_BCED  = BigDecimal.ZERO;  //대중교통
	       edETCH_UEAM   = BigDecimal.ZERO;
	       edETCH_BCBS  = BigDecimal.ZERO;
	       edSpciRefn   = BigDecimal.ZERO;

	       edCARD_ET13  = BigDecimal.ZERO;
	       edCARD_ET14  = BigDecimal.ZERO;
	       edETAD_DD13  = BigDecimal.ZERO;
	       edETAD_D14L  = BigDecimal.ZERO;

	       edSpchRe06   = BigDecimal.ZERO;
	       edSpchRe10   = BigDecimal.ZERO;
	       edSpchRe15    = BigDecimal.ZERO;
	       edSPCH_REFX   = BigDecimal.ZERO;
	       edSPCH_REEC   = BigDecimal.ZERO;
	       
	       edSPCH_15FX = BigDecimal.ZERO;
           edSPCH_15FB = BigDecimal.ZERO;
           edSPCH_15EC = BigDecimal.ZERO;
           edSPCH_10FB = BigDecimal.ZERO;

	       edETCS_COMP   = BigDecimal.ZERO;
	       edETWK_HSBM  = BigDecimal.ZERO;
	       edETWK_HSVM  = BigDecimal.ZERO;
	       edMonyItre   = BigDecimal.ZERO; //목돈안드는이자상환금액
	       edEtchPrep  = BigDecimal.ZERO;
	       ldCnt     = 0;

	       edSpciFbam  = BigDecimal.ZERO;
	       edSpciPltc  = BigDecimal.ZERO;
	       edSpciExam   = BigDecimal.ZERO;
	       edSpciUnon   = BigDecimal.ZERO;
	       edSpciNamt   = BigDecimal.ZERO;
	       edSpciYamt   = BigDecimal.ZERO;
	       edSPCI_HFAM   = BigDecimal.ZERO;
	       edCARD_MONI  = BigDecimal.ZERO;
	       edCARD_BCED  = BigDecimal.ZERO;

           //2016 주민번호 암호화에 따른 복호화 처리 루틴 
	        String rrnDecCrypt = "";
	        String tmpRrnDecCrypt = "";
	        for (int m = 0; m < 10 ;m++) { 
	          arrPayr445[m][2] = "0"; 
	          arrPayr445[m][3] = "0"; 
	          arrCARD_PAY[m][1] = "0"; 
	          arrCARD_PAY[m][2] = "0"; 
	          arrCARD_PAY[m][3] = "0"; 
	          arrMONI_PAY[m][1] = "0"; 
	          arrMONI_PAY[m][2] = "0"; 
	          arrMONI_PAY[m][3] = "0"; 
	          arrBCBS_PAY[m][1] = "0"; 
	          arrBCBS_PAY[m][2] = "0"; 
	          arrBCBS_PAY[m][3] = "0"; 
	          arrHDRC_PAY[m][1] = "0"; 
	          arrHDRC_PAY[m][2] = "0"; 
	          arrSPCI_PAY[m][3] = "0"; 
	          arrSPCI_PAY[m][1] = "0"; 
	          arrSPCI_PAY[m][2] = "0"; 
	          arrCASH_PAY[m][1] = "0"; 
	          arrCASH_PAY[m][2] = "0"; 
	        }
	    
	     try {
	         try {

	          // FileName := 'C:\EOSDATA\2015\' + trim(lblFILE_SAVE.Caption) + '_' + trim(edKORN_NAME.Text); // + '.xml';
	          // Memo_XML_EUC_KR.Lines.Clear;
	         //  Memo_XML_EUC_KR.Lines.LoadFromFile(ChangeFileExt(FileName, '.xml'));
	         //  CONNXML.LoadFromFile(ChangeFileExt(FileName, '.xml'));
	          // CONNXML.Root.AsString := Memo_XML_EUC_KR.Lines.Text;
	          // ecxmlPdf.LoadFromFile(FileName);
	            xmlItemMain = xmlDoc.getDocumentElement();
	     
	            xmlItemDoc = xmlItemMain.getElementsByTagName("doc").item(0); 
	            xmlelDoc = (Element)xmlItemDoc;	 
	        
	            dataType = PkgFuncUtils.getXmlTagValue("doc_type", xmlelDoc);    //문서종류   
	            dataPrDate =  PkgFuncUtils.getXmlTagValue("seq", xmlelDoc); //일련번호 
	            dataYear = PkgFuncUtils.getXmlTagValue("att_year", xmlelDoc);   //귀속년도 
	            dataFrmMm = PkgFuncUtils.getXmlTagValue("att_FrmMm", xmlelDoc);   //시작월
	            dataToMm = PkgFuncUtils.getXmlTagValue("att_ToMm", xmlelDoc);   //종료월
	            dataInqrMm = PkgFuncUtils.getXmlTagValue("att_inqrMm", xmlelDoc);   //월 기간

	           if (!dataYear.equals("2016")) {
//	              bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Yeta","[연말정산]에러","PDF 전자문서이상","연말정산 귀속년도가 상이합니다. 확인하십시요." )); 
	              //에러처리 
	        		 throw new Exception();  
	           }
	         
	            xmlItemForm =  xmlItemMain.getElementsByTagName("form");    
	           //FORM
	             for(int i=0;i < xmlItemForm.getLength();i++) { 
	         
                    /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
		    	    // 1. 암호화 객체 생성
		    	     String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		    			
		    	     /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/   
		    	    	
	            	 subXmlItemForm = xmlItemForm.item(i); 
	            	 subXmlElForm  = (Element) subXmlItemForm;
	            	 
	                 strFormCd  = subXmlElForm.getAttribute("form_cd"); 
	               /**+++++++++++보험료(A102Y/A102M)+++++++++++++++++++++++++++++++++++++++++++++++++++*/
	                 //보험료(A102Y/A102M)
	                if ((strFormCd.equals("A102Y")) || (strFormCd.equals("A102M"))) { 
	                //보장성보험(G0001) , 장애인전용보장성 보험(G0002). 기본내역
	                 edSpciGurtSum = BigDecimal.ZERO;
	                 edSpciHdrcSum = BigDecimal.ZERO;
	                 
	                 edSpciGurtSum02 = BigDecimal.ZERO;
	                 edSpciHdrcSum02 = BigDecimal.ZERO;
	                 ddCnt = 0;
	                 subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
	                
	                 //인원별 반복구간
	                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
 
		            	 
	                       subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
	                       subXmlElMan  = (Element) subXmlItemMan;
	                       
	                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
	                      
	                       arrHDRC_PAY[ddCnt][0]  = strResid;

	                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
	                       
	                       edSpciGurtSum01 = BigDecimal.ZERO;
	    	               edSpciHdrcSum01 = BigDecimal.ZERO;
	    	                 
	                        //상품별 반복구간
	                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
	                        
	                         subXmlItemData =  subXmlElChildMan.item(k); 
	                         subXmlElData  = (Element) subXmlItemData;
	                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
	                         
	                         if (strDatCd.equals("G0001")) { //보장성 총 금액
	                        	 
	                        	 edSpciGurtSum = edSpciGurtSum.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
	                        	 edSpciGurtSum01 = edSpciGurtSum01.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
	                        	 arrHDRC_PAY[ddCnt][1] =  String.valueOf(new BigDecimal(arrHDRC_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                        	 
	                         }else if (strDatCd.equals("G0002")) { //장애인전용 총 금액
	                        	
	                        	 edSpciHdrcSum = edSpciHdrcSum.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
	                        	 edSpciHdrcSum01 = edSpciHdrcSum01.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
	                        	 arrHDRC_PAY[ddCnt][2] =  String.valueOf(new BigDecimal(arrHDRC_PAY[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));  
	                         }
	                         
	                       }
	                        ddCnt = ddCnt + 1;
	                       
	                         InfcPkgYeta3220VO yetaPrc3220Vo = new InfcPkgYeta3220VO();
	                         
	                         yetaPrc3220Vo.setInsuRtyr(edSpciGurtSum01);	/** column 보장성보험합계 : insuRtyr */ 
	                         yetaPrc3220Vo.setPsclIurr(edSpciHdrcSum01);  /** column 장애인전용보험합계 : psclIurr */ 

	                 		 String strValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
	                 		
	                         yetaPrc3220Vo.setRsnoNumb(strValue);    /** column 주민등록번호 : rsnoNumb */ 
	                         yetaPrc3220Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
	                         yetaPrc3220Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
	                         yetaPrc3220Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
	                         yetaPrc3220Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
	                         
	                         yetaPayr1200Service.fnPayr06425_YE3220_2016_Update(yetaPrc3220Vo);
	                         
	                 }
	                 
	                 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
	                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
	                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
	                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
	                 yeta2000Vo.setSpciGurt(edSpciGurtSum);  						/** column 보장성보험료금액 : spciGurt */
	                 yeta2000Vo.setSpciHdrc(edSpciHdrcSum); 						/** column 장애인보장성보험료금액 : spciHdrc */
	                 
	                 yetaPayr1200Service.fnPayr06425_PAYR415_2016_Update(yeta2000Vo);

	                //보험료 종료
	                } 
	                else if ((strFormCd.equals("B101Y")) || (strFormCd.equals("B101D"))) {
	                	
	               /**+++++++++++의료비시작+++++++++++++++++++++++++++++++++++++++++++++++++++*/
	                 //의료비시작
	                 //의료비 . 기본내역 (B01의료비 ) B03,B04,B05
	                 strDatCd = "";
	                 ldCnt = 0;
	                 MediBoolean = false;  
	                 subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
	                 
	                 
	                 InfcPkgYeta3140VO yetaPrc3140Vo = new InfcPkgYeta3140VO();
                     

						//yetaPrc3140Vo.setMediSeqn(yeta2000Vo.getMediSeqn());    /** column 의료비지급일련번호 : mediSeqn */
						yetaPrc3140Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
						yetaPrc3140Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
						yetaPrc3140Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
						yetaPrc3140Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */
						//yetaPrc3140Vo.setVendNumb(subXmlElData.getAttribute("busnid"));    /** column 거래처번호 : vendNumb */
						yetaPrc3140Vo.setMediCfcd("1");    /** column 의료증빙코드 : mediCfcd  국세청자료구분 */

						//yetaPrc3140Vo.setRsnoNumb(strEncValue);    /** column 주민등록번호 : rsnoNumb */
						
						//국세청자료인경우 delete
						yetaPayr1200Service.fnPayr06430_PAYR430_2015_Delete(yetaPrc3140Vo);
				 
	                 //인원별 반복구간
	                 for (int j= 0;j < subXmlElChildForm.getLength();j++)  {

	                	   subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
	                       subXmlElMan  = (Element) subXmlItemMan;
	                       
	                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
	                         
	                        arrCASH_PAY[ldCnt][0]  = strResid;
	                       //기관별반복구간 
	                        subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
	                        //상품별 반복구간
	                        for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
	                       
	                         ddCnt = 0;
	                      
	                         subXmlItemData =  subXmlElChildMan.item(k); 
	                         subXmlElData  = (Element) subXmlItemData;
	                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
	                          
	                         exCASH_UEAM = BigDecimal.ZERO;
	                         
	                         if (strDatCd.equals("G0003")) { //의료비
	                         
	                          exCASH_UEAM =   new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)) ;

	                        } else if  (strDatCd.equals("G0025")) {  //의료기기 구입비용
	                       
	                          exCASH_UEAM =   new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)) ;  
	                         }
	                         else if  (strDatCd.equals("G0026")) {   // 안경 또는 콘텍트렌즈 구입비용
	                        
	                         exCASH_UEAM  =  new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)) ;  
	                         }
	                         else if  (strDatCd.equals("G0027")) {  //보청기 또는 장애인 보장구 구입비용
	                         
	                          exCASH_UEAM =  new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)) ;  
	                         }
	                         ddCnt = 0;
	                         if (strFormCd.equals("B101D"))  { 
	                        	 
	                        	 NodeList subXmlEldd =  subXmlElData.getElementsByTagName("amt");
	                        	 
	                            ddCnt =   subXmlEldd.getLength();
	                         }
	                         else
	                         {
	                            ddCnt = 1;
	                         }

	                         arrCASH_PAY[ldCnt][1] =   String.valueOf(new BigDecimal(arrCASH_PAY[ldCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
	                             

	                         yetaPrc3140Vo = new InfcPkgYeta3140VO();
	                         

								//yetaPrc3140Vo.setMediSeqn(yeta2000Vo.getMediSeqn());    /** column 의료비지급일련번호 : mediSeqn */
								yetaPrc3140Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
								yetaPrc3140Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
								yetaPrc3140Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
								yetaPrc3140Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */
								yetaPrc3140Vo.setVendNumb(subXmlElData.getAttribute("busnid"));    /** column 거래처번호 : vendNumb */

		                 		String strEncValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
		                 		
								yetaPrc3140Vo.setRsnoNumb(strEncValue);    /** column 주민등록번호 : rsnoNumb */
								
								yetaPayr1200Service.fnPayr06430_PAYR430_2015_Delete(yetaPrc3140Vo);
								 

		                 		String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
		                 		
		                 			
		                 		if (strResid.equals(strDecValue)) {
		                 			MediBoolean = true;  
									   yetaPrc3140Vo.setPsclHpyn("1");/** column 본인등해당여부 : psclHpyn */ 
									   
				                       // oraQryInsert.ParamByName('PSCL_HPYN').AsString := '1';
								  } else   if (((strResid.substring(0,7).equals("1")) || (strResid.substring(0,7).equals("2"))) && (!strResid.equals(strDecValue))) {
									  MediBoolean = true;  
									  schBrith =  ("19").concat(strResid.substring(0,7));
									  
			                          if  (schBrith.compareTo("19511231") <= 0) {
			                        		yetaPrc3140Vo.setPsclHpyn("1"); /** column 본인등해당여부 : psclHpyn */ 
			                           } else {
			                          	   yetaPrc3140Vo.setPsclHpyn("2"); /** column 본인등해당여부 : psclHpyn */ 
			                           }
			                       
				                  }
				                  else{
				                	  MediBoolean = true;  
		                         	   yetaPrc3140Vo.setPsclHpyn("2"); /** column 본인등해당여부 : psclHpyn */ 
		                              // oraQryInsert.ParamByName('PSCL_HPYN').AsString := '2';
				                  }  //장애인유무는 저장시 다시 확인  필요함. 
		                 		
								yetaPrc3140Vo.setVendNumb(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("busnid")).replace("-", ""));    /** column 거래처번호 : vendNumb */	
								yetaPrc3140Vo.setVendName(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("trade_nm")));    /** column 거래처명 : vendName */
	                            yetaPrc3140Vo.setMediCfcd("1");    /** column 의료증빙코드 : mediCfcd */
	                            yetaPrc3140Vo.setCashUect(new BigDecimal(ddCnt));    /** column 지급건수 : cashUect */
								yetaPrc3140Vo.setCashUeam(exCASH_UEAM);    /** column 지급금액 : cashUeam */
								yetaPrc3140Vo.setCtifTrea("0");    /** column 난임시술비해당여부 : ctifTrea */
								 
//								yetaPrc3140Vo.setIsmt(yeta3140Dto.getIsmt());    /** column 수정자 : ismt */
//								yetaPrc3140Vo.setRevnDt(yeta3140Dto.getRevnDt());    /** column 수정일자 : revnDt */
//								yetaPrc3140Vo.setRevnAddr(yeta3140Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
 											
								yetaPayr1200Service.fnPayr06430_PAYR430_2015_Insert(yetaPrc3140Vo);
								
								
		                 	
	                     }
	                        ldCnt = ldCnt + 1;     
	                   }
	                 
//	                 if(MediBoolean){
//	                	 
//	                	 yetaPrc3140Vo = new InfcPkgYeta3140VO();
//	                	 
//	                	 //yetaPrc3140Vo.setMediSeqn(yeta2000Vo.getMediSeqn());    /** column 의료비지급일련번호 : mediSeqn */
//							yetaPrc3140Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
//							yetaPrc3140Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
//							yetaPrc3140Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
//							yetaPrc3140Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */
//							//yetaPrc3140Vo.setVendNumb(subXmlElData.getAttribute("busnid"));    /** column 거래처번호 : vendNumb */
//							yetaPrc3140Vo.setMediCfcd("1");    /** column 의료증빙코드 : mediCfcd  국세청자료구분 */
//
//							//yetaPrc3140Vo.setRsnoNumb(strEncValue);    /** column 주민등록번호 : rsnoNumb */
//							
//							//국세청자료인경우 delete
//							yetaPayr1200Service.fnPayr06430_PAYR430_2015_Delete(yetaPrc3140Vo);
	                 
//	                 }else{
	                	 MediBoolean = false; 
//	                 } 
	                 
	                 //의료비 종료
	                }
	                else if ((strFormCd.equals("C101Y")) || (strFormCd.equals("C101M")) ||  (strFormCd.equals("C202Y")) 
                                ||   (strFormCd.equals("C202M")) ||  (strFormCd.equals("C301Y"))  || ( strFormCd.equals("C301M")))  {
	                	/**+++++++++++교육비 시작+++++++++++++++++++++++++++++++++++++++++++++++++++*/
	              
	                  // 교육비 시작
	                     //교육비 - 유초중고,대학,기타
	                    if ((strFormCd.equals("C101Y")) || (strFormCd.equals("C101M"))) {
	                    /**+++++++++++/교육비  기본 타입 있음...초중고 구분등+++++++++++++++++++++++++++++++++++++++++++++++++++*/
	                       //교육비  기본 타입 있음...초중고 구분등
	                     //  {G0004 교육비-유초중고 본인+가족(시도교육청)
	                     //   G0006 교육비-대학 본인+가족
	                     //   G0007 교육비-기타 본인+가족}
	                        ddCnt = 0;
	                        subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
	                        for (int j = 0; j < subXmlElChildForm.getLength();j++) { 

	                           strResid = "";

	                           subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
		                       subXmlElMan  = (Element) subXmlItemMan;
		                       
		                       strResid = subXmlElMan.getAttribute("resid");   //주민번호 
	                           arrPayr445[ddCnt][0]  = strResid;
	                           
	                           subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
		                        //상품별 반복구간
		                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
	                           
		                    	strEduTp = "";
	                            strDatCd = "";

	                            subXmlItemData =  subXmlElChildMan.item(k); 
		                         subXmlElData  = (Element) subXmlItemData;
		                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
		                         strEduTp =  subXmlElData.getAttribute("edu_tp");  //교육비종류 
	                           

		                 		 String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
		                 		
	                            if (strResid.equals(strDecValue)) {
	                         
	                                 if  (strEduTp.equals("H"))  {
	                                   arrPayr445[9][3] =  String.valueOf(new BigDecimal(arrPayr445[9][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                		   //floattostr(strtofloat(arrPayr445[10][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                 // edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                 }
	                                   else if ( strEduTp.equals("J"))  {
	                                 
	                                   arrPayr445[9][3]  =  String.valueOf(new BigDecimal(arrPayr445[9][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                		   //floattostr(strtofloat(arrPayr445[10][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                 // edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                   }
	                                   else if  (strEduTp.equals("K"))  {
	                                 
	                                    arrPayr445[9][3] = String.valueOf(new BigDecimal(arrPayr445[9][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
	                                    		   //floattostr(strtofloat(arrPayr445[10][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  //edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                   }
	                                  else
	                                  {
	                                     edSpedSelf = edSpedSelf.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
	                                     arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
	                                    		  //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                            }
	                            else
	                            {

	                                 if (strDatCd.equals("G0004")) { 

	                                  if ( strEduTp.equals("1")) {
	                                   arrPayr445[ddCnt][1] = "Y0030010";
	                                   arrPayr445[ddCnt][2] =   String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                		   //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                                  else if ( strEduTp.equals("2")) {
	                                    arrPayr445[ddCnt][1]  = "Y0030020";
	                                    arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
	                                    		//floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                                  else if ( strEduTp.equals("3")) {
	                                  arrPayr445[ddCnt][1]  = "Y0030020";
	                                  arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                		  //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                                  else if ( strEduTp.equals("4")) {
	                                  arrPayr445[ddCnt][1]  = "Y0030020";
	                                  arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                		  //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                                  else if ( strEduTp.equals("8")) {
	                                  arrPayr445[ddCnt][1]  = "Y0030010";
	                                  arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                		  // floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                                  else if ( strEduTp.equals("F")) {
	                                  arrPayr445[ddCnt][1]  = "Y0030010";
	                                  arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                		  //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                                  else if ( strEduTp.equals("G")) {
	                                   arrPayr445[ddCnt][1] = "Y0030010";
	                                   arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                		   //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                                  else if  (strEduTp.equals("H")) {
	                                   arrPayr445[ddCnt][3] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                		   //floattostr(strtofloat(arrPayr445[ddCnt][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                 // edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                  }
	                                   else if ( strEduTp.equals("J")) {
	                                   arrPayr445[ddCnt][3] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                		   
	                                		   // floattostr(strtofloat(arrPayr445[ddCnt][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                 // edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                   }
	                                   else if ( strEduTp.equals("K")) {
	                                    arrPayr445[ddCnt][3] =   String.valueOf(new BigDecimal(arrPayr445[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		//floattostr(strtofloat(arrPayr445[ddCnt][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  //edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                   }
	                                   }
	                                 else if ( strDatCd.equals("G0006")) {
	                                  // C03 교육비-대학 본인+가족
	                                    if ( strEduTp.equals("5")) {
	                                    arrPayr445[ddCnt][1]  = "Y0030030";
	                                    arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		//floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                    else if ( strEduTp.equals("6")) {
	                                    arrPayr445[ddCnt][1]  = "Y0030030";
	                                     arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                    else if ( strEduTp.equals("7")) {
	                                    arrPayr445[ddCnt][1]  = "Y0030030";
	                                     arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
	                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                    else if ( strEduTp.equals("C")) {
	                                    arrPayr445[ddCnt][1]  = "Y0030030";
	                                     arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		 // floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                    else if ( strEduTp.equals("D")) {
	                                    arrPayr445[ddCnt][1]  = "Y0030030";
	                                    arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
	                                    		//floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                    else if ( strEduTp.equals("E")) {
	                                     arrPayr445[ddCnt][1] = "Y0030030";
	                                     arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		 // floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                    else if ( strEduTp.equals("H")) {
	                                       arrPayr445[ddCnt][3] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		   //floattostr(strtofloat(arrPayr445[ddCnt][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                     //edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                    }
	                                     else if ( strEduTp.equals("J")) {
	                                       arrPayr445[ddCnt][3] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		   // floattostr(strtofloat(arrPayr445[ddCnt][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                     //edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                     }
	                                     else if ( strEduTp.equals("K")) {
	                                      arrPayr445[ddCnt][3] =   String.valueOf(new BigDecimal(arrPayr445[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		  //floattostr(strtofloat(arrPayr445[ddCnt][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                   // edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                     }
	                                 }
	                                 else if ( strDatCd.equals("G0007")) {
	                                    // C04 교육비-기타 본인+가족
	                                    if ( strEduTp.equals("1")) {
	                                     arrPayr445[ddCnt][1]  = "Y0030010";
	                                     arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		 // floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                    else if ( strEduTp.equals("2")) {
	                                    arrPayr445[ddCnt][1]  = "Y0030020";
	                                     arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                    else if ( strEduTp.equals("3")) {
	                                    arrPayr445[ddCnt][1]  = "Y0030020";
	                                     arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                    else if ( strEduTp.equals("4")) {
	                                    arrPayr445[ddCnt][1]  = "Y0030020";
	                                    arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		// floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                    else if ( strEduTp.equals("8")) {
	                                    arrPayr445[ddCnt][1]  = "Y0030010";
	                                    arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
	                                    		//floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                    else if ( strEduTp.equals("F")) {
	                                    arrPayr445[ddCnt][1]  = "Y0030010";
	                                     arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		 // floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                    else if ( strEduTp.equals("G")) {
	                                    arrPayr445[ddCnt][1]  = "Y0030010";
	                                     arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
	                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                    else if ( strEduTp.equals("5")) {
	                                    arrPayr445[ddCnt][1]  = "Y0030030";
	                                     arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		 // floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                    else if ( strEduTp.equals("6")) {
	                                     arrPayr445[ddCnt][1]  = "Y0030030";
	                                     arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		 // floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                    else if ( strEduTp.equals("7")) {
	                                    arrPayr445[ddCnt][1]  = "Y0030030";
	                                     arrPayr445[ddCnt][2] =String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		 // floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                    else if ( strEduTp.equals("C")) {
	                                     arrPayr445[ddCnt][1]  = "Y0030030";
	                                    arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		//floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                    else if ( strEduTp.equals("D")) {
	                                     arrPayr445[ddCnt][1]  = "Y0030030";
	                                     arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                    else if  (strEduTp.equals("E")) {
	                                     arrPayr445[ddCnt][1] = "Y0030030";
	                                     arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    }
	                                     else if ( strEduTp.equals("H")) {
	                                     arrPayr445[ddCnt][3] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
	                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    //edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                     }
	                                     else if ( strEduTp.equals("J")) {
	                                     arrPayr445[ddCnt][3] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
	                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    //edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                     }
	                                     else if ( strEduTp.equals("K")) {
	                                     arrPayr445[ddCnt][3] =   String.valueOf(new BigDecimal(arrPayr445[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                    // edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                     }
	                                 }

	                                 }

	                            }
		                       
		                       ddCnt = ddCnt + 1;
	                        }

	                    }
	                    else if ((strFormCd.equals("C202Y")) || (strFormCd.equals("C202M"))) {
	                    	/**+++++++++++/직업훈련비(본인교육비에 해당)  C02 직업훈련비 본인+++++++++++++++++++++++++++++++++++++++++++++++++++*/
	                         //직업훈련비(본인교육비에 해당)  C02 직업훈련비 본인
	                         strDatCd =  "";
	                         //인원별 반복구간
	                         subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
	     	                
	    	                 //인원별 반복구간
	    	                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 


		                           subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			                       subXmlElMan  = (Element) subXmlItemMan;
			                       
			                       strResid = subXmlElMan.getAttribute("resid");   //주민번호 
		                           
		                           subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
	  	                      //과정별반복구간
		                      
		                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {   
	                             
		                    	     subXmlItemData =  subXmlElChildMan.item(k); 
			                         subXmlElData  = (Element) subXmlItemData;
			                         strDatCd = subXmlElData.getAttribute("dat_cd"); 

			                         String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
				                 		
	                                 if (strDatCd.equals("G0005")) {
	                                	 if (strResid.equals(strDecValue)) { 
	                                	 
	                                     edSpedSelf = edSpedSelf.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
//	                                     arrPayr445[9][3] =   String.valueOf(new BigDecimal(arrPayr445[9][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                        //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                	 }
	                                 }
		                       }

	    	                 }
	                    }
	                    else if  ((strFormCd.equals("C301Y")) || ( strFormCd.equals("C301M")))  {
	                    	/**+++++++++++//교복구입비  연간합계 3101M 일별 C06 교복구입비 본인+가족(기본)+++++++++++++++++++++++++++++++++++++++++++++++++++*/
	                         //교복구입비  연간합계 3101M 일별 C06 교복구입비 본인+가족(기본)
	                         strDatCd  = "";
	                         
	                         subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
	     	                
	    	                 //인원별 반복구간
	    	                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 


		                           subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			                       subXmlElMan  = (Element) subXmlItemMan;
			                       
			                       strResid = subXmlElMan.getAttribute("resid");   //주민번호 
		                           
		                           subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
	  	                        // 기관별 반복구간
		                          for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
		                    	 
		                        	 subXmlItemData =  subXmlElChildMan.item(k); 
		 	                         subXmlElData  = (Element) subXmlItemData;
		 	                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
		 	                     
		 	                         String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			                 		
	                                 if (strDatCd.equals("G0024")) {
	                                	 if (strResid.equals(strDecValue)) { 
	                                		 edSpedSelf = edSpedSelf.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
//	                                		 arrPayr445[9][3] =   String.valueOf(new BigDecimal(arrPayr445[9][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                				 //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                	 }
	                                   else
	                                   {
	                                	   boolean chkData = false;
	                                	   for(int l = 0; l < arrPayr445.length;l++) { 
	                                       
	                                		  if (MSFSharedUtils.paramNotNull(arrPayr445[l][0])) {
		                                           if(arrPayr445[l][0].equals(strResid))  {
		                                             arrPayr445[l][1]  = "Y0030020";
		                                             arrPayr445[l][2] =  String.valueOf(new BigDecimal(arrPayr445[l][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                            		 //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                             chkData = true;
		                                           }
	                                		  } 
	                                	   }
	                                	   
	                                	   if (!chkData) {
	                                		 
	                                		   for(int l = 0; l < arrPayr445.length;l++) {  
		 	                                       if (MSFSharedUtils.paramNull(arrPayr445[l][0])) {
		                                		     arrPayr445[l][0] =  strResid ;
		                                		     arrPayr445[l][1]  = "Y0030020";
		                                             arrPayr445[l][2] =  String.valueOf(new BigDecimal(arrPayr445[l][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                             break;
		 	                                       }
		 	                                       
	 	                                	  }
	                                	   }
	                                   }
	                                 }
	                                 
		                          }

	    	                 }

	                    }

	                  //교육비 종료
	                }
	                else if( (strFormCd.equals("D101Y") ) || (strFormCd.equals("D101M"))) {
	                	/**+++++++++++개인연금저축 시작++++++++++++++++++++++++++++++++++++++++++++++++++*/
	                
	                   // 개인연금저축 시작
	                  //개인연금저축 D101Y 연간합계 D101M 월별 D01 개인연금저축 본인
	                  //근로자 본인 명의로 2000.12.31 이전에 가입하여 해당 과세기간에 불입한 금액
	                  //Y0040030	Y004 	0030	개인연금저축					21
	                   strDatCd = "";
	                   
	                   InfcPkgYeta3100VO yetaPrc3100Vo = new InfcPkgYeta3100VO();
	                   
	                   yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
	                   yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
	                   yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
	                   yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
	                   yetaPrc3100Vo.setImdeGbcd("Y0040030");    /** column 소득공제구분코드 : imdeGbcd */
	                   
	                   yetaPayr1200Service.fnPayr06430_Payr418_2015_Delete(yetaPrc3100Vo);
 
	                    
	                   subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		                
		                 //인원별 반복구간
		                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 

		                	 subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
		                       subXmlElMan  = (Element) subXmlItemMan;
		                       
		                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
		                       
		                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
		                        //상품별 반복구간
		                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
		                    	   
		                      
		                    	     subXmlItemData =  subXmlElChildMan.item(k); 
			                         subXmlElData  = (Element) subXmlItemData;
			                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
			                         String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
				                 		
		                              if (strDatCd.equals("G0009")) {
		                        	   if (strResid.equals(strDecValue)) { 
	
		                                 edPrvm20be = edPrvm20be.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                                		 //+   strtofloat(subXmlItemData.NamedItem['sum'].Text);
	 
		                                yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
		          	                    yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
		          	                    yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
		          	                    yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
		          	                    yetaPrc3100Vo.setImdeGbcd("Y0040030");    /** column 소득공제구분코드 : imdeGbcd */
										yetaPrc3100Vo.setFinaSeqn(BigDecimal.ZERO);    /** column 연금_저축일련번호 : finaSeqn */ 
										yetaPrc3100Vo.setFinaCode(PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관코드 : finaCode */
										yetaPrc3100Vo.setFinaName(subXmlElData.getAttribute("trade_nm") );    /** column 금융기관상호 : finaName */
										yetaPrc3100Vo.setAcntNumb(subXmlElData.getAttribute("acc_no") );    /** column 계좌번호 : acntNumb */
										yetaPrc3100Vo.setIcnmYear("");    /** column 납입연차 : icnmYear */
										yetaPrc3100Vo.setPaytAmnt(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));    /** column 불입금액 : paytAmnt */
										yetaPrc3100Vo.setDeduAmnt(BigDecimal.ZERO);    /** column 세액공제금액 : deduAmnt */
										yetaPrc3100Vo.setImdeTxcd("21");    /** column 소득공제구분국세청코드 : imdeTxcd */
										yetaPrc3100Vo.setFinaTxcd( PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관국세청코드 : finaTxcd */
//										yetaPrc3100Vo.setKybdr(yeta3100Dto.getKybdr());    /** column 입력자 : kybdr */
//										yetaPrc3100Vo.setInptDt(yeta3100Dto.getInptDt());    /** column 입력일자 : inptDt */
//										yetaPrc3100Vo.setInptAddr(yeta3100Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//										yetaPrc3100Vo.setIsmt(yeta3100Dto.getIsmt());    /** column 수정자 : ismt */
//										yetaPrc3100Vo.setRevnDt(yeta3100Dto.getRevnDt());    /** column 수정일자 : revnDt */
//										yetaPrc3100Vo.setRevnAddr(yeta3100Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
	
	 
		                                  //FINA_SEQN
//		                                oraQryInsert.ParamByName('IMDE_GBCD').AsString := 'B0110030';   // 개인	연금저축
//		                                oraQryInsert.ParamByName('IMDE_TXCD').AsString := '21' ;  //개인 연금저축 구분번호
//		                              //  oraQryInsert.ParamByName('IMDE_GBNM').AsString := Cells[4,jRow];
//		                                oraQryInsert.ParamByName('FINA_CODE').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//		                                oraQryInsert.ParamByName('FINA_TXCD').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//		                                oraQryInsert.ParamByName('FINA_NAME').AsString := subXmlItemData.Params.Values['trade_nm'];
//		                                oraQryInsert.ParamByName('ACNT_NUMB').AsString := subXmlItemData.Params.Values['acc_no'];
//		                                oraQryInsert.ParamByName('ICNM_YEAR').AsString := '';
//		                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemData.NamedItem['sum'].Text;
//		                                oraQryInsert.ParamByName('DEDU_AMNT').AsString := '0';
										yetaPayr1200Service.fnPayr06430_Payr418_2016_Insert(yetaPrc3100Vo);
	
		                        	   }
		                              }
		                       }
	
		                 } 
		               
		                yeta2000Vo.setPrvm20be(edPrvm20be);     
		              
						 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
		                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
		                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
		                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
		                 
		                yetaPayr1200Service.fnPayr06425_Payr415_2016_Update(yeta2000Vo);
		                      
	                  //개인 연금 저축 종료
	                }
	                else if ((strFormCd.equals("E102Y"))  || (strFormCd.equals("E102M")) ) {
	                	/**+++++++++++2012년도 : 연금저축 E101Y 연간합계 E101M+++++++++++++++++++++++++++++++++++++++++++++++++*/
	               
	                    // 2012년도 : 연금저축 E101Y 연간합계 E101M
	                    // 연금 저축 시작
	                    //월별 E01 연금저축 본인
	                    //근로자 본인 명의로 2001.1.1 이후에 가입하여 해당 과세기간에 불입한 금액
	                    //Y0040040  	B011	0040	연금저축					22

	                    strDatCd = "";
	                    
	                    
	                    InfcPkgYeta3100VO yetaPrc3100Vo = new InfcPkgYeta3100VO();
	                   
	                   yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
	                   yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
	                   yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
	                   yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
	                   yetaPrc3100Vo.setImdeGbcd("Y0040040");    /** column 소득공제구분코드 : imdeGbcd */
	                   
	                   yetaPayr1200Service.fnPayr06430_Payr418_2015_Delete(yetaPrc3100Vo);

//	                    oraQryDelete.Close;
//	                    oraQryDelete.SQL.Clear;
//	                    oraQryDelete.SQL.Add(fnPayr06430_Payr418_2016_Delete);
//	                    oraQryDelete.SQL.Add(' AND  IMDE_GBCD = :IMDE_GBCD   ');
//
//	                    oraQryDelete.ParamByName('EDAC_RVYY').AsString :=  lblEDAC_RVYY.Caption;
//	                    oraQryDelete.ParamByName('SETT_GBCD').AsString :=  lblSETT_GBCD.Caption;
//	                    oraQryDelete.ParamByName('PSNL_NUMB').AsString :=  lblPSNL_NUMB.Caption;
//	                    oraQryDelete.ParamByName('IMDE_GBCD').AsString := 'B0110040';   //	B011	0040	연금저축
 
	                   subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		                
		                 //인원별 반복구간
		                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
		                	 
		                
		                	 subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
		                       subXmlElMan  = (Element) subXmlItemMan;
		                       
		                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
	                         // 상품별 반복구간
		                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
		                        //상품별 반복구간
		                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
		                        
		                         subXmlItemData =  subXmlElChildMan.item(k); 
		                         subXmlElData  = (Element) subXmlItemData;
		                         strDatCd = subXmlElData.getAttribute("dat_cd"); 

		                         String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			                 		    
	                           if (strDatCd.equals("G0010")) { 
	                        	 
	                           if (strResid.equals(strDecValue)) { 
	                        	 
	                                edPrvm21af = edPrvm21af.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("ddct_bs_ass_amt", subXmlElData))) ;
	                                		//+   strtofloat(subXmlItemData.NamedItem['ddct_bs_ass_amt'].Text);

	                           yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
        	                     yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
        	                    yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
        	                    yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
        	                    yetaPrc3100Vo.setImdeGbcd("Y0040040");    /** column 소득공제구분코드 : imdeGbcd */
								yetaPrc3100Vo.setFinaSeqn(BigDecimal.ZERO);    /** column 연금_저축일련번호 : finaSeqn */ 
								yetaPrc3100Vo.setFinaCode(PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관코드 : finaCode */
								yetaPrc3100Vo.setFinaName(subXmlElData.getAttribute("trade_nm") );    /** column 금융기관상호 : finaName */
								yetaPrc3100Vo.setAcntNumb(subXmlElData.getAttribute("acc_no") );    /** column 계좌번호 : acntNumb */
								yetaPrc3100Vo.setIcnmYear("");    /** column 납입연차 : icnmYear */
								yetaPrc3100Vo.setPaytAmnt(new BigDecimal(PkgFuncUtils.getXmlTagValue("ddct_bs_ass_amt", subXmlElData)));    /** column 불입금액 : paytAmnt */
								yetaPrc3100Vo.setDeduAmnt(BigDecimal.ZERO);    /** column 세액공제금액 : deduAmnt */
								yetaPrc3100Vo.setImdeTxcd("22");    /** column 소득공제구분국세청코드 : imdeTxcd */
								yetaPrc3100Vo.setFinaTxcd( PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관국세청코드 : finaTxcd */
//								yetaPrc3100Vo.setKybdr(yeta3100Dto.getKybdr());    /** column 입력자 : kybdr */
//								yetaPrc3100Vo.setInptDt(yeta3100Dto.getInptDt());    /** column 입력일자 : inptDt */
//								yetaPrc3100Vo.setInptAddr(yeta3100Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//								yetaPrc3100Vo.setIsmt(yeta3100Dto.getIsmt());    /** column 수정자 : ismt */
//								yetaPrc3100Vo.setRevnDt(yeta3100Dto.getRevnDt());    /** column 수정일자 : revnDt */
//								yetaPrc3100Vo.setRevnAddr(yeta3100Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
 

	                                  //FINA_SEQN
//	                                oraQryInsert.ParamByName('IMDE_GBCD').AsString := 'B0110040';   //	B011	0040	연금저축
//	                                oraQryInsert.ParamByName('IMDE_TXCD').AsString := '22' ;
//	                              //  oraQryInsert.ParamByName('IMDE_GBNM').AsString := Cells[4,jRow];
//	                                oraQryInsert.ParamByName('FINA_CODE').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//	                                oraQryInsert.ParamByName('FINA_TXCD').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//	                                oraQryInsert.ParamByName('FINA_NAME').AsString := subXmlItemData.Params.Values['trade_nm'];
//	                                oraQryInsert.ParamByName('ACNT_NUMB').AsString := subXmlItemData.Params.Values['acc_no'];
//	                                oraQryInsert.ParamByName('ICNM_YEAR').AsString := '';
//	                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemData.NamedItem['ddct_bs_ass_amt'].Text;
//	                                oraQryInsert.ParamByName('DEDU_AMNT').AsString := '0';

	                                yetaPayr1200Service.fnPayr06430_Payr418_2016_Insert(yetaPrc3100Vo);
	                           }
	                           }
		                       }

		                 }
 

	                    //  oraQryUpdate.ParamByName('JRTR_ANSV').AsFloat :=  ;
		            	 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
		                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
		                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
		                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
		                 
	                      
	                        yeta2000Vo.setJrtrAnsv(edPrvm21af);  
			              
			                yetaPayr1200Service.fnPayr06425_JrtrAnsv_2016_Update(yeta2000Vo);
			                
			                
	                  //연금저축 종료
	                }
	                else if ((strFormCd.equals("F102Y")) || (strFormCd.equals("F102M"))) {
	                	/**+++++++++++퇴직연금 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
	                 
	                    // 퇴직연금 시작
	                    // 2012년도  : 퇴직연금 F101Y 연간합계 F101M
	                    //  월별 F01 퇴직연금 본인
	                    // Y0040010	B011	0010	근로자퇴직연금보장법.	11
	                    // Y0040020	B011	0020	과학기술인공제회	12
	                    // B0110025	B011	0025	확정기여형퇴직연금.	13  ---삭제 ,''B0110025''

	                     strDatCd = "";

	                     
	                     InfcPkgYeta3100VO yetaPrc3100Vo = new InfcPkgYeta3100VO();
		                   
		                   yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
		                   yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
		                   yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
		                   yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
		                   yetaPrc3100Vo.setImdeGbcd("Y0040010");    /** column 소득공제구분코드 : imdeGbcd */
		                   
		                   yetaPayr1200Service.fnPayr06430_Payr418_2015_Delete(yetaPrc3100Vo);
		                
		                   
		                   yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
		                   yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
		                   yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
		                   yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
		                   yetaPrc3100Vo.setImdeGbcd("Y0040020");    /** column 소득공제구분코드 : imdeGbcd */
		                   
		                   yetaPayr1200Service.fnPayr06430_Payr418_2015_Delete(yetaPrc3100Vo);
		                   
	                     
	                   // oraQryDelete.SQL.Add(' AND  IMDE_GBCD IN (''B0110010'',''B0110020'')   ');

	                    
		                   subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
			                
			                 //인원별 반복구간
			                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
		 
				            	 
			                       subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			                       subXmlElMan  = (Element) subXmlItemMan;
			                       
			                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
			                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			                        //상품별 반복구간
			                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
			                        
			                         subXmlItemData =  subXmlElChildMan.item(k); 
			                         subXmlElData  = (Element) subXmlItemData;
			                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
			                         
		                           if (strDatCd.equals("G0011")) {
		                        	   
		                        	   String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
				                 		
		                        	   if (strResid.equals(strDecValue)) { 
	
		                                if ((PkgFuncUtils.getXmlTagValue("pension_cd", subXmlElData)).equals("11")) {
		                                     // Y0040010	B011	0010	근로자퇴직연금보장법.	11
		                                      edJrtrPsct = edJrtrPsct.add(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("ddct_bs_ass_amt", subXmlElData),"0"))) ;
		                                    		  // +   strtofloat(subXmlItemData.NamedItem['ddct_bs_ass_amt'].Text);
		                                }
		                                else if ((PkgFuncUtils.getXmlTagValue("pension_cd", subXmlElData)).equals("12")) {
		                                
		                                  // Y0040020	B011	0020	과학기술인공제회	12
		                                   edJRTR_CICT = edJRTR_CICT.add(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("ddct_bs_ass_amt", subXmlElData),"0"))) ;  
		                                		   //+   strtofloat(subXmlItemData.NamedItem['ddct_bs_ass_amt'].Text);
		                                }
		                                //else  if (subXmlItemData.NamedItem['pension_cd'].Text)  = '13' then
		                                //begin
		                                  // edTemp := edTemp +   strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                  // B0110025	B011	0025	확정기여형퇴직연금.	13     edTemp
		                                //end; 
	
		                                // Y0040010	B011	0010	근로자퇴직연금보장법.	11   edJrtrPsct
		                                // Y0040020	B011	0020	과학기술인공제회	12       edJRTR_CICT
		                                // B0110025	B011	0025	확정기여형퇴직연금.	13     edTemp
	 

		 	                            yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
		         	                     yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
		         	                    yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
		         	                    yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
		         	                   
		         	                   
		                                  //FINA_SEQN
		                                if ((PkgFuncUtils.getXmlTagValue("pension_cd", subXmlElData)).equals("11")) {
		                                	
		                              
		                                     // Y0040010	B011	0010	근로자퇴직연금보장법.	11
		                                	   yetaPrc3100Vo.setImdeGbcd("Y0040010");    /** column 소득공제구분코드 : imdeGbcd */
				         	                   yetaPrc3100Vo.setImdeTxcd(PkgFuncUtils.getXmlTagValue("pension_cd", subXmlElData));    /** column 소득공제구분국세청코드 : imdeTxcd */
				         	                   
		                                     //  oraQryInsert.ParamByName('IMDE_GBCD').AsString := 'Y0040010';    
		                                     //  oraQryInsert.ParamByName('IMDE_TXCD').AsString := subXmlItemData.NamedItem['pension_cd'].Text;
		                                }
		                                else if ((PkgFuncUtils.getXmlTagValue("pension_cd", subXmlElData)).equals("12")) {
		                                  // Y0040020	B011	0020	과학기술인공제회	12
		                                	  yetaPrc3100Vo.setImdeGbcd("Y0040020");    /** column 소득공제구분코드 : imdeGbcd */
				         	                   yetaPrc3100Vo.setImdeTxcd(PkgFuncUtils.getXmlTagValue("pension_cd", subXmlElData));    /** column 소득공제구분국세청코드 : imdeTxcd */
				         	                   
		                                  //  oraQryInsert.ParamByName('IMDE_GBCD').AsString := 'Y0040020';
		                                  //  oraQryInsert.ParamByName('IMDE_TXCD').AsString := subXmlItemData.NamedItem['pension_cd'].Text;
		                                }
//		                                else  if (subXmlItemData.NamedItem['pension_cd'].Text)  = '13' then
//		                                begin
//		                                     oraQryInsert.ParamByName('IMDE_GBCD').AsString := 'B0110025';
//		                                     oraQryInsert.ParamByName('IMDE_TXCD').AsString := subXmlItemData.NamedItem['pension_cd'].Text;
//		                                  // B0110025	B011	0025	확정기여형퇴직연금.	13     edTemp
//		                                end;
	

		 								yetaPrc3100Vo.setFinaSeqn(BigDecimal.ZERO);    /** column 연금_저축일련번호 : finaSeqn */ 
		 								yetaPrc3100Vo.setFinaCode(PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관코드 : finaCode */
		 								yetaPrc3100Vo.setFinaName(subXmlElData.getAttribute("trade_nm") );    /** column 금융기관상호 : finaName */
		 								yetaPrc3100Vo.setAcntNumb(subXmlElData.getAttribute("acc_no") );    /** column 계좌번호 : acntNumb */
		 								yetaPrc3100Vo.setIcnmYear("");    /** column 납입연차 : icnmYear */
		 								yetaPrc3100Vo.setPaytAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("ddct_bs_ass_amt", subXmlElData),"0")));    /** column 불입금액 : paytAmnt */
		 								yetaPrc3100Vo.setDeduAmnt(BigDecimal.ZERO);    /** column 세액공제금액 : deduAmnt */
		 								
		 								yetaPrc3100Vo.setFinaTxcd( PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관국세청코드 : finaTxcd */
//		 								yetaPrc3100Vo.setKybdr(yeta3100Dto.getKybdr());    /** column 입력자 : kybdr */
//		 								yetaPrc3100Vo.setInptDt(yeta3100Dto.getInptDt());    /** column 입력일자 : inptDt */
//		 								yetaPrc3100Vo.setInptAddr(yeta3100Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//		 								yetaPrc3100Vo.setIsmt(yeta3100Dto.getIsmt());    /** column 수정자 : ismt */
//		 								yetaPrc3100Vo.setRevnDt(yeta3100Dto.getRevnDt());    /** column 수정일자 : revnDt */
//		 								yetaPrc3100Vo.setRevnAddr(yeta3100Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
		                             
		 								//  oraQryInsert.ParamByName('IMDE_GBNM').AsString := Cells[4,jRow];
//		                                oraQryInsert.ParamByName('FINA_CODE').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//		                                oraQryInsert.ParamByName('FINA_TXCD').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//		                                oraQryInsert.ParamByName('FINA_NAME').AsString := subXmlItemData.Params.Values['trade_nm'];
//		                                oraQryInsert.ParamByName('ACNT_NUMB').AsString := subXmlItemData.Params.Values['acc_no'];
//		                                oraQryInsert.ParamByName('ICNM_YEAR').AsString := '';
//		                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemData.NamedItem['ddct_bs_ass_amt'].Text;
//		                                oraQryInsert.ParamByName('DEDU_AMNT').AsString := '0';
 
		 								  yetaPayr1200Service.fnPayr06430_Payr418_2016_Insert(yetaPrc3100Vo);
		                        	   }
		                             }
			                       }
	
			                 }
	 
	
//		                      oraQryUpdate.ParamByName('JRTR_PSCT').AsFloat :=  edJrtrPsct;
//		                      oraQryUpdate.ParamByName('JRTR_CICT').AsFloat :=  edJRTR_CICT;
			            	 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
			                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
			                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
			                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
			                 
		                      yeta2000Vo.setJrtrPsct(edJrtrPsct);
		                      yeta2000Vo.setJrtrCict(edJRTR_CICT);
				              
				             yetaPayr1200Service.fnPayr06425_JrtrCict_2016_Update(yeta2000Vo);

	                   //퇴직연금 종료 
	                }
	                else if ((strFormCd.equals("G104Y")) ||  (strFormCd.equals("G104M")))  {
	                	/**+++++++++++신용카드 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
	                 
	                    //  신용카드 시작
	                    //신용카드  연간합계 G102M 월별 G01 신용카드 본인+가족
	                    //종류확인
	                       strDatCd = "";
	                       ddCnt = 0;
	                       subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
	                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
	   	                
	  	                   //인원별 반복구간
	  	                   for (int j = 0; j < subXmlElChildForm.getLength();j++) { 

	  	                	   subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
		                       subXmlElMan  = (Element) subXmlItemMan;
		                       
		                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
		                       
		                       String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
		                 		 
		                       if (strResid.equals(strDecValue)) { 
	                               
		                    	     //2014 년도 신용카드 전체합계
	                                  edCARD_ET14 =  edCARD_ET14.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tot_amt"),"0"))); //일반
	                                  //+ strtofloat(subXmlItemMan.Params.Values['ftyr_tot_amt']);
	                                  edCARD_ET14 =  edCARD_ET14.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_market_tot_amt"),"0"))); //전통시장
	                                        //+ strtofloat(subXmlItemMan.Params.Values['ftyr_market_tot_amt']);
	                                  edCARD_ET14 =  edCARD_ET14.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tmoney_tot_amt"),"0"))); //대중교통 
	                                        ///+ strtofloat(subXmlItemMan.Params.Values['ftyr_tmoney_tot_amt']); 2014년도 본인 신용카드 사용계 총합
	                                  
	                                  //2014 년도 본인추가 공제율
	                                 // edETAD_DD13 =  edETAD_DD13.add(new BigDecimal(subXmlElMan.getAttribute("ftyr_tot_amt") ));
	                                  edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_market_tot_amt"),"0"))); 
	                                  		//+ strtofloat(subXmlItemMan.Params.Values['ftyr_market_tot_amt']);
	                                  edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tmoney_tot_amt"),"0")));
	                                  		//+ strtofloat(subXmlItemMan.Params.Values['ftyr_tmoney_tot_amt']);
	                                  

		                    	     //2015 년도 전체합계
	                                  edCARD_ET15 =  edCARD_ET15.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tot_amt"),"0"))); 
	                                  				//+ strtofloat(subXmlItemMan.Params.Values['pre_tot_amt']);
	                                  edCARD_ET15 =  edCARD_ET15.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_market_tot_amt"),"0"))); 
	                                  				//+ strtofloat(subXmlItemMan.Params.Values['pre_market_tot_amt']);
	                                  edCARD_ET15 =  edCARD_ET15.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tmoney_tot_amt"),"0"))); 
	                                  				//+ strtofloat(subXmlItemMan.Params.Values['pre_tmoney_tot_amt']);
	                                  
		                       
		                       } 
	                            
	                             arrCARD_PAY[ddCnt][0]  = strResid;
	                             // 상품별 반복구간
	                             subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
	 	                        //상품별 반복구간
	 	                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
	 	                        
	 	                         subXmlItemData =  subXmlElChildMan.item(k); 
	 	                         subXmlElData  = (Element) subXmlItemData;
	 	                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
	 	                         
	 	                        if (strDatCd.equals("G0012")) { // if strDatCd  = 'G01' then
	 	                        	
	 	                        	String str1DecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
	 		                 		
	 	                        	
	                                  if ((subXmlElData.getAttribute("use_place_cd") ).equals("1") )  { 
	                                  	 
	                                      edETCT_CARD = edETCT_CARD.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
	                                      
	                                      arrCARD_PAY[ddCnt][1]   = String.valueOf(new BigDecimal(arrCARD_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
	                                    		  //floattostr(strtofloat(arrCARD_PAY[ddCnt][1]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                                  else  if ((subXmlElData.getAttribute("use_place_cd")).equals("2") )  { 
	                                 
	                                      edETCH_MGVD = edETCH_MGVD.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
	                                      
	                                      arrCARD_PAY[ddCnt][2]   =  String.valueOf(new BigDecimal(arrCARD_PAY[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		  //floattostr(strtofloat(arrCARD_PAY[ddCnt][2]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));

	  	 	                        	//2016년도 추가공제율 상반기
	  	 	                        	if (strResid.equals(str1DecValue)) { 
	  	                                	  edETAD_D16L =  edETAD_D16L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("first_year_tot_amt"),"0")));
	  	 	                         	}
	                                  
	                                  }
	                                  else  if ((subXmlElData.getAttribute("use_place_cd")).equals("3") )  { 
	                               
	                                      edETCH_BCED = edETCH_BCED.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));  
	                                      arrCARD_PAY[ddCnt][3]   =  String.valueOf(new BigDecimal(arrCARD_PAY[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		  //floattostr(strtofloat(arrCARD_PAY[ddCnt][3]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));

	  	 	                        	//2016년도 추가공제율 상반기
	  	 	                        	if (strResid.equals(str1DecValue)) { 
	  	                                	  edETAD_D16L =  edETAD_D16L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("first_year_tot_amt"),"0")));
	  	 	                         	}

	                                  }
	 	                        } 
	 	                      
	 	                       }
	 	                      ddCnt = ddCnt + 1;
	  	                   } 

	                      //oraQryUpdate.ParamByName('ETCT_CARD').AsFloat := edETCT_CARD ; 
	                      
	                      yeta2000Vo.setEtctCard(edETCT_CARD);
	 	                 
	 	                 yetaPayr1200Service.fnPayr06425_PAYR415_2016_06_Update(yeta2000Vo);
	                      

	                   //신용카드 종료
	                }
	                else if (strFormCd.equals("G205M")) {
	                 /**+++++++++++현금 영수증 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
	                 
	                   //  현금 영수증 시작
	                  //현금영수증 - - G203M 월별 G02 현금영수증 본인+가족
	                  //종류확인.  기본서직없음. 상세...
	                       strDatCd = "";
	                       ddCnt = 0;
	                       
	                       subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
	   	                
	  	                 //인원별 반복구간
	  	                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
	   
	  		            	 
	  	                       subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
	  	                       subXmlElMan  = (Element) subXmlItemMan;
	  	                       
	  	                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
	  	                    
	  	                       String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
		                 		
	                            if (strResid.equals(strDecValue)) { 
	                             //2014 년도 전체합계
	                            	edCARD_ET14 =  edCARD_ET14.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tot_amt"),"0") ));
                                 //+ strtofloat(subXmlItemMan.Params.Values['ftyr_tot_amt']);
	                            	edCARD_ET14 =  edCARD_ET14.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_market_tot_amt"),"0") ));
                                       //+ strtofloat(subXmlItemMan.Params.Values['ftyr_market_tot_amt']);
	                            	edCARD_ET14 =  edCARD_ET14.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tmoney_tot_amt"),"0") ));
                                       ///+ strtofloat(subXmlItemMan.Params.Values['ftyr_tmoney_tot_amt']);
	                            	
                                 //2014 년도 본인추가 공제율
	                            	edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tot_amt"),"0") ));
	                            	edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_market_tot_amt"),"0") )); 
                                 		//+ strtofloat(subXmlItemMan.Params.Values['ftyr_market_tot_amt']);
	                            	edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tmoney_tot_amt"),"0") ));
                                 		//+ strtofloat(subXmlItemMan.Params.Values['ftyr_tmoney_tot_amt']);
	                            	
	                    	     //2015 년도 전체합계
	                            	edCARD_ET15 =  edCARD_ET15.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tot_amt"),"0") )); 
                                 				//+ strtofloat(subXmlItemMan.Params.Values['pre_tot_amt']);
	                            	edCARD_ET15 =  edCARD_ET15.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_market_tot_amt"),"0") )); 
                                 				//+ strtofloat(subXmlItemMan.Params.Values['pre_market_tot_amt']);
	                            	edCARD_ET15 =  edCARD_ET15.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tmoney_tot_amt"),"0") )); 
                                 				//+ strtofloat(subXmlItemMan.Params.Values['pre_tmoney_tot_amt']);

//                          //이전년도 전체합계
//                          edCARD_ET13 :=  edCARD_ET13 + strtofloat(subXmlItemMan.Params.Values['pre_tot_amt']);
//                          edCARD_ET13 :=  edCARD_ET13 + strtofloat(subXmlItemMan.Params.Values['pre_market_tot_amt']);
//                          edCARD_ET13 :=  edCARD_ET13 + strtofloat(subXmlItemMan.Params.Values['pre_tmoney_tot_amt']);
//                          //이전년도 본인추가 공제율
//                          edETAD_DD13 :=  edETAD_DD13 + strtofloat(subXmlItemMan.Params.Values['pre_tot_amt']);
//                          edETAD_DD13 :=  edETAD_DD13 + strtofloat(subXmlItemMan.Params.Values['pre_market_tot_amt']);
//                          edETAD_DD13 :=  edETAD_DD13 + strtofloat(subXmlItemMan.Params.Values['pre_tmoney_tot_amt']);
	                            	
	                            	
	                            	
	                            }
	                           
	                             arrMONI_PAY[ddCnt][0]  = strResid;
	                         
	                             // 상품별 반복구간
	                             subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
	 	                        //상품별 반복구간
	 	                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
	 	                        
	 	                         subXmlItemData =  subXmlElChildMan.item(k); 
	 	                         subXmlElData  = (Element) subXmlItemData;
	 	                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
	 	                         
	 	                         
	 	                        if (strDatCd.equals("G0013")) { //if strDatCd  = 'G02' then
	 	                        	
	 	                        	String str1DecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
	 		                 		
	 	                        	//2016년도 추가공제율 상반기
	 	                        	if (strResid.equals(str1DecValue)) { 
	                                	  edETAD_D16L =  edETAD_D16L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("first_year_tot_amt"),"0")));
	 	                         	}
	 	                        	
	                                  if ((subXmlElData.getAttribute("use_place_cd")).equals("1") )  { 
	                                  
	                                      edETCH_UEAM = edETCH_UEAM.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
	                                      

	                                      arrMONI_PAY[ddCnt][1]   =  String.valueOf(new BigDecimal(arrMONI_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                         //floattostr(strtofloat(arrMONI_PAY[ddCnt][1]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                                  else  if ((subXmlElData.getAttribute("use_place_cd")).equals("2") )  { 
	                                  
	                                       edETCH_MGVD = edETCH_MGVD.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));  
	                                       
	                                      arrMONI_PAY[ddCnt][2]   =  String.valueOf(new BigDecimal(arrMONI_PAY[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
	                                      //floattostr(strtofloat(arrMONI_PAY[ddCnt][2]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                                   else  if ((subXmlElData.getAttribute("use_place_cd")).equals("3") )  { 
	                                 
	                                      edETCH_BCED = edETCH_BCED.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));  
	                                      arrMONI_PAY[ddCnt][3]   =  String.valueOf(new BigDecimal(arrMONI_PAY[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		//  floattostr(strtofloat(arrMONI_PAY[ddCnt][3]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                   }
	 	                        }
	 	                      
	 	                       }
	 	                      ddCnt = ddCnt + 1;
	  	                 }
 
	                     // oraQryUpdate.ParamByName('ETCH_UEAM').AsFloat :=  edETCH_UEAM; 
	                      
	                      yeta2000Vo.setEtchUeam(edETCH_UEAM);
		 	                 
		 	              yetaPayr1200Service.fnPayr06425_PAYR415_2016_07_Update(yeta2000Vo);
		 	                 
		 	                 
	                   //현금 영수증 종료
	                }
	                else if ((strFormCd.equals("G304Y"))  || (strFormCd.equals("G304M"))) {
	                	/**+++++++++++  직불카드 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
	                	//    직불카드 시작
	                 //직불카드등  연간합계 G302M 월별 G03 직불카드 등 본인+가족
	                       strDatCd = "";
	                       ddCnt = 0;
	                       //인별 반복구간
	                       
	  	                 subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
	  	                
	  	                 //인원별 반복구간
	  	                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
	   
	  		            	 
	  	                       subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
	  	                       subXmlElMan  = (Element) subXmlItemMan;
	  	                       
	  	                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
	  	                   
	  	                       String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
		                 		
	                        if (strResid.equals(strDecValue)) { 
	                             
	                             //2014 년도 전체합계
	                        	edCARD_ET14 =  edCARD_ET14.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tot_amt"),"0") ));
                                 //+ strtofloat(subXmlItemMan.Params.Values['ftyr_tot_amt']);
	                        	edCARD_ET14 =  edCARD_ET14.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_market_tot_amt"),"0") ));
                                       //+ strtofloat(subXmlItemMan.Params.Values['ftyr_market_tot_amt']);
	                        	edCARD_ET14 =  edCARD_ET14.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tmoney_tot_amt"),"0") ));
                                       ///+ strtofloat(subXmlItemMan.Params.Values['ftyr_tmoney_tot_amt']);
	                        	
                                 //2014 년도 본인추가 공제율
	                        	edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tot_amt"),"0")  ));
	                        	edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_market_tot_amt"),"0")  )); 
                                 		//+ strtofloat(subXmlItemMan.Params.Values['ftyr_market_tot_amt']);
	                        	edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tmoney_tot_amt"),"0")  ));
                                 		//+ strtofloat(subXmlItemMan.Params.Values['ftyr_tmoney_tot_amt']);
	                    	   
	                    	     //2015 년도 전체합계
	                        	edCARD_ET15 =  edCARD_ET15.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tot_amt"),"0")  )); 
                                 				//+ strtofloat(subXmlItemMan.Params.Values['pre_tot_amt']);
	                        	edCARD_ET15 =  edCARD_ET15.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_market_tot_amt"),"0")  )); 
                                 				//+ strtofloat(subXmlItemMan.Params.Values['pre_market_tot_amt']);
	                        	edCARD_ET15 =  edCARD_ET15.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tmoney_tot_amt"),"0") )); 
                                 				//+ strtofloat(subXmlItemMan.Params.Values['pre_tmoney_tot_amt']);
                                 
                                 //2015 이전년도 본인추가 공제율
//                                 edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tot_amt"),"0") ));
//                                 edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_market_tot_amt"),"0") )); 
//                                 				//+ strtofloat(subXmlItemMan.Params.Values['pre_market_tot_amt']);
//                                 edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tmoney_tot_amt"),"0") )); 
                                 				//+ strtofloat(subXmlItemMan.Params.Values['pre_tmoney_tot_amt']);
                                 
//	                                  //이전년도 전체합계
//	                                  edCARD_ET13 :=  edCARD_ET13 + strtofloat(subXmlItemMan.Params.Values['pre_tot_amt']);
//	                                  edCARD_ET13 :=  edCARD_ET13 + strtofloat(subXmlItemMan.Params.Values['pre_market_tot_amt']);
//	                                  edCARD_ET13 :=  edCARD_ET13 + strtofloat(subXmlItemMan.Params.Values['pre_tmoney_tot_amt']);
//	                                  //이전년도 본인추가 공제율
//	                                  edETAD_DD13 :=  edETAD_DD13 + strtofloat(subXmlItemMan.Params.Values['pre_tot_amt']);
//	                                  edETAD_DD13 :=  edETAD_DD13 + strtofloat(subXmlItemMan.Params.Values['pre_market_tot_amt']);
//	                                  edETAD_DD13 :=  edETAD_DD13 + strtofloat(subXmlItemMan.Params.Values['pre_tmoney_tot_amt']);

	                        }
	                             
	                             arrBCBS_PAY[ddCnt][0]  = strResid;
	                             // 상품별 반복구간
	                             subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
	 	                        //상품별 반복구간
	 	                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
	 	                        
	 	                         subXmlItemData =  subXmlElChildMan.item(k); 
	 	                         subXmlElData  = (Element) subXmlItemData;
	 	                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
	 	                         
	 	                        if (strDatCd.equals("G0014")) { //  if strDatCd  = 'G03' then
	 	                        	
	 	                        	 String str2DecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
	 		                 		
	 	                        	//2016년도 추가공제율 상반기
	 	                        	if (strResid.equals(str2DecValue)) { 
	                                	  edETAD_D16L =  edETAD_D16L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("first_year_tot_amt"),"0")));
	 	                         	}

	                                  if ((subXmlElData.getAttribute("use_place_cd")).equals("1") )  { 
	                                
	                                      edETCH_BCBS = edETCH_BCBS.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
	                                      
	                                      arrBCBS_PAY[ddCnt][1]   = String.valueOf(new BigDecimal(arrBCBS_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
	                                    		  //floattostr(strtofloat(arrBCBS_PAY[ddCnt][1]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                                  else  if ((subXmlElData.getAttribute("use_place_cd")).equals("2") )  { 
	                                 
	                                      edETCH_MGVD = edETCH_MGVD.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));  
	                                      
	                                      arrBCBS_PAY[ddCnt][2]   =  String.valueOf(new BigDecimal(arrBCBS_PAY[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));  
	                                      //floattostr(strtofloat(arrBCBS_PAY[ddCnt][2]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                                  else  if ((subXmlElData.getAttribute("use_place_cd")).equals("3") )  { 
	                                 
	                                      edETCH_BCED = edETCH_BCED.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
	                                      
	                                      arrBCBS_PAY[ddCnt][3]   =  String.valueOf(new BigDecimal(arrBCBS_PAY[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                      //floattostr(strtofloat(arrBCBS_PAY[ddCnt][4]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	 	                        }
	 	                      
	 	                       }
	 	                      ddCnt = ddCnt + 1;
	  	                 }
	                      

	                    //  oraQryUpdate.ParamByName('ETCH_BCBS').AsFloat :=  edETCH_BCBS;
 
	                      
	                      yeta2000Vo.setEtchBcbs(edETCH_BCBS);
		 	                 
		 	              yetaPayr1200Service.fnPayr06425_PAYR415_2016_08_Update(yeta2000Vo);
		 	              
		 	              
	                    //직불카드 종료
	                }
	                else if ((strFormCd.equals("J101Y")) || (strFormCd.equals("J101M")))  {
	                	/**+++++++++++  주책 임차 차입금 원리금 상환 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
	              
	                   //  주책 임차 차입금 원리금 상환 시작
	                   //주택임차차입금 원리금상환액 J101Y 연간합계 J101M 월별 J01 주택임차차입금 원리금 본인
	                      strDatCd = "";
	                        // 인별 반복구간
	                      
	 	                 subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
	 	                
	 	                 //인원별 반복구간
	 	                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
	  
	 		            	 
	 	                       subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
	 	                       subXmlElMan  = (Element) subXmlItemMan;
	 	                       
	 	                       strResid = subXmlElMan.getAttribute("resid");   //주민번호

	 	                      subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
		                        //상품별 반복구간
		                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
		                        
		                         subXmlItemData =  subXmlElChildMan.item(k); 
		                         subXmlElData  = (Element) subXmlItemData;
		                         strDatCd = subXmlElData.getAttribute("dat_cd"); 

	                               if (strDatCd.equals("G0016")) {

	                                 edSpciRefn = edSpciRefn.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
	                                 // + strtofloat(subXmlItemData.NamedItem['sum'].Text);

	                               }
		                       }

	 	                 } 

	                     // oraQryUpdate.ParamByName('SPCI_REFN').AsFloat :=  edSpciRefn;
  
	                      
	                     yeta2000Vo.setSpciRefn(edSpciRefn);
	 					 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
		                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
		                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
		                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
		                 
	 	                 yetaPayr1200Service.fnPayr06425_PAYR415_spciRefn_2016_Update(yeta2000Vo);
	 	                 
	 	                 
	                     //  주택 임차 차입금 원리금 상환 종료
	                }
	                else if ((strFormCd.equals("J203Y")) || (strFormCd.equals("J203M")))  {
	                	/**+++++++++++  장기 주택 차입금 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
	                
	                  //  장기 주택 차입금 시작
	                  // 장기주택저당차입금 이자상환액 J203Y 연간합계 J203M 월별 J02 장기주택저당차입금 이자상환 본인
	                  //2010년:J201Y -> 2011년:J202Y -> 2012년:J203Y

	                     strDatCd = "";
	                       // 인별 반복구간
	                     subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
	 	                
		                 //인원별 반복구간
		                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 

		                	   subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
		                       subXmlElMan  = (Element) subXmlItemMan;
		                       
		                       strResid = subXmlElMan.getAttribute("resid");   //주민번호

		                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
		                        //상품별 반복구간
		                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
		                        
		                         subXmlItemData =  subXmlElChildMan.item(k); 
		                         subXmlElData  = (Element) subXmlItemData;
		                         strDatCd = subXmlElData.getAttribute("dat_cd"); 

	                               if (strDatCd.equals("G0017")) {

	                                 if ((  (PkgFuncUtils.getXmlTagValue("start_dt", subXmlElData)).compareTo("20120101") < 0) 
	                                		 && (( (new BigDecimal(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData))).compareTo(new BigDecimal("0")) >= 0) 
	                                	 	&& ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData))).compareTo(new BigDecimal("15")) < 0) 
	                                		 )) {
	                                 //’11년도 이전 차입분으로 상환기간 15년 미만인
	                                   edSpchRe06  = edSpchRe06.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
	                                		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                 }
	                                 else if  (((PkgFuncUtils.getXmlTagValue("start_dt", subXmlElData)).compareTo("20120101") < 0) 
	                                		 && (( (new BigDecimal(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData))).compareTo(new BigDecimal("15")) >= 0)   
	                                				 && ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData))).compareTo(new BigDecimal("29")) < 0)   )) {
	                                 //’11년도 이전 차입분으로 다음에 해당하는 경우 공제한도는 연 1,000만원을 적용함
	                                 //- 상환기간 15년 이상 29년 미만인 경우
	                                   edSpchRe10   = edSpchRe10.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
	                                		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                 }
	                                 else if  (((PkgFuncUtils.getXmlTagValue("start_dt", subXmlElData)).compareTo("20120101") < 0)   
	                                	    && ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData))).compareTo(new BigDecimal("30")) >= 0)) {
	                                 // ’11년도 이전 차입분으로 상환기간 30년 이상인 경우 
	                                   edSpchRe15   = edSpchRe15.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
	                                		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                 } 
	                                 else if  (((PkgFuncUtils.getXmlTagValue("start_dt", subXmlElData)).compareTo("20150101") < 0) 
	                                	        &&  ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData))).compareTo(new BigDecimal("15")) >= 0))  {
	                                  
	                                	 if (( (new BigDecimal(PkgFuncUtils.getXmlTagValue("fixed_rate_debt", subXmlElData))).compareTo(BigDecimal.ZERO) > 0)  
	                                		  ||  ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("not_defer_debt", subXmlElData))).compareTo(BigDecimal.ZERO) > 0)) {
	                                       //’12.1.1 이후 신규 차입분(차입금 상환기간 연장 포함)으로서 상환기간이 15년 이상인 차입금
	                                       edSPCH_REFX   = edSPCH_REFX.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
	                                    		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                	 }
	                                    else
	                                    {
	                                       //’12.1.1 이후 신규 차입분(차입금 상환 기간 연장 포함)으로서 상환기간이 15년 이상이고
	                                       edSPCH_REEC    = edSPCH_REEC.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
	                                    		   
	                                    		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                    }

	                                 }
	                                 else if  (((PkgFuncUtils.getXmlTagValue("start_dt", subXmlElData)).compareTo("20150101") >= 0)  
	                                	        && ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData))).compareTo(new BigDecimal("15")) >= 0)) {
	                                	   
	                                   if ( ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("fixed_rate_debt", subXmlElData))).compareTo(BigDecimal.ZERO) > 0)  
                               		     &&  ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("not_defer_debt", subXmlElData))).compareTo(BigDecimal.ZERO) > 0)) {
	                                	 
	                                       //’15.1.1 이후 신규 차입분(차입금 상환기간 연장 포함)으로서 상환기간이 15년 이상인 차입금 중 고정금리이면서, 비거치상환대출
	                                       edSPCH_15FX   = edSPCH_15FX.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
	                                    		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                    } else  if  (( (new BigDecimal(PkgFuncUtils.getXmlTagValue("fixed_rate_debt", subXmlElData))).compareTo(BigDecimal.ZERO) > 0)  
                               		     ||  ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("not_defer_debt", subXmlElData))).compareTo(BigDecimal.ZERO) > 0)) {
	                                	 
	                                       //’15.1.1 이후 신규 차입분(차입금 상환기간 연장 포함)으로서 상환기간이 15년 이상인 차입금 중 고정금리이거나 비거치상환대출
	                                       edSPCH_15FB  = edSPCH_15FB.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
	                                    		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                    }
	                                    else
	                                    {
	                                       //’15.1.1 이후 신규 차입분(차입금 상환 기간 연장 포함)으로서 상환기간이 15년 이상이고 기타대출
	                                       edSPCH_15EC    = edSPCH_15EC.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
	                                    		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                    }

	                               }
	                                 else if  (((PkgFuncUtils.getXmlTagValue("start_dt", subXmlElData)).compareTo("20150101") >= 0)  
	                                		    &&  (( (new BigDecimal(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData))).compareTo(new BigDecimal("10")) >= 0) 
	                                		    		  && ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData))).compareTo(new BigDecimal("15")) < 0)))  {
	                                 //’15.1.1 이후 차입분으로 다음에 해당하는 경우 공제한도는 연 300만원을 적용함
	                                 //- 상환기간 10년 이상 15년 미만인 경우
	                                   if  (( (new BigDecimal(PkgFuncUtils.getXmlTagValue("fixed_rate_debt", subXmlElData))).compareTo(BigDecimal.ZERO) > 0)  
	                	                                		  ||  ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("not_defer_debt", subXmlElData))).compareTo(BigDecimal.ZERO) > 0)) { 
	                                       //’12.1.1 이후 신규 차입분(차입금 상환기간 연장 포함)으로서 상환기간이 15년 이상인 차입금 중 고정금리이거나 비거치상환대출
	                                       edSPCH_10FB   = edSPCH_10FB.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
	                                       // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                   }
	                                     
	                               }
		                       }

		                 }
	                }
 

//	                      oraQryUpdate.ParamByName('SPCH_RE06').AsFloat :=  edSpchRe06;
//	                      oraQryUpdate.ParamByName('SPCH_RE10').AsFloat :=  edSpchRe10;
//	                      oraQryUpdate.ParamByName('SPCH_RE20').AsFloat :=  edSpchRe15;
//	                      oraQryUpdate.ParamByName('SPCH_REEC').AsFloat :=  edSPCH_REEC;
//	                      oraQryUpdate.ParamByName('SPCH_REFX').AsFloat :=  edSPCH_REFX;
	                      
		                    yeta2000Vo.setSpchRe06(edSpchRe06);  // 특별공제_11년 이전 장기주택저당차입금15년 ~ 29년
	                        yeta2000Vo.setSpchRe10(edSpchRe10);  // 특별공제_11년 이전 장기주택저당차입금15년 ~ 29년
	                        yeta2000Vo.setSpchRe20(edSpchRe15);  // 특별공제_11년 이전 장기주택저당차입금30년 이상
	                        yeta2000Vo.setSpchReec(edSPCH_REEC); // 특별공제_12장기주택저당차입금_기타
	                        yeta2000Vo.setSpchRefx(edSPCH_REFX); // 특별공제_12장기주택저당차입금_고정 (고정금리이거나, 비거치상환대출)
	                        yeta2000Vo.setSpch15fx(edSPCH_15FX); // 특별공제_15장기주택저당_15고정AND 비거치상환
	                        yeta2000Vo.setSpch15fb(edSPCH_15FB); // 특별공제_15장기주택저당_15고정OR 비거치상환 
	                        yeta2000Vo.setSpch15ec(edSPCH_15EC); // 특별공제_15장기주택저당_15기타대출
	                        yeta2000Vo.setSpch10fb(edSPCH_10FB); // 특별공제_15장기주택저당_10고정 OR 비거치상환
	                        
	   					 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
		                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
		                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
		                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
	                        
	 	                    yetaPayr1200Service.fnPayr06425_PAYR415_2016_01_Update(yeta2000Vo); 
 
		 	                 
		 	                 
	                    // 장기주택 저당 차입금 이자상환액 종료
	                }
	                else if ((strFormCd.equals("J301Y"))  ||  (strFormCd.equals("J301M")))  {
	                	/**+++++++++++   주택마련 저축 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
	                
	                  //  주택마련 저축 시작
	                   //주택마련저축 J301Y 연간합계 J301M 월별 J03 주택마련저축 본인
	                  // Y0040050	B011	0050	청약저축					31
	                   //Y0040060	B011	0060	주택청약종합저축       					32
	                   //Y0040080	B011	0080	근로자주택마련저축     					34
	                    strDatCd = "";

	                    InfcPkgYeta3100VO yetaPrc3100Vo = new InfcPkgYeta3100VO();
		                   
		                   yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
		                   yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
		                   yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
		                   yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
		                   yetaPrc3100Vo.setImdeGbcd("Y0040050");    /** column 소득공제구분코드 : imdeGbcd */
		                   
		                   yetaPayr1200Service.fnPayr06430_Payr418_2015_Delete(yetaPrc3100Vo);
		                    
		                   
		                   yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
		                   yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
		                   yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
		                   yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
		                   yetaPrc3100Vo.setImdeGbcd("Y0040060");    /** column 소득공제구분코드 : imdeGbcd */
		                   
		                   yetaPayr1200Service.fnPayr06430_Payr418_2015_Delete(yetaPrc3100Vo);
		                   
		                  
		                   
		                   yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
		                   yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
		                   yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
		                   yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
		                   yetaPrc3100Vo.setImdeGbcd("Y0040080");    /** column 소득공제구분코드 : imdeGbcd */
		                   
		                   yetaPayr1200Service.fnPayr06430_Payr418_2015_Delete(yetaPrc3100Vo);
		                   
	                  
		                   subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
			                
			                 //인원별 반복구간
			                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
		 
				            	 
			                       subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			                       subXmlElMan  = (Element) subXmlItemMan;
			                       
			                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
			                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			                        //상품별 반복구간
			                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
			                        
			                         subXmlItemData =  subXmlElChildMan.item(k); 
			                         subXmlElData  = (Element) subXmlItemData;
			                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
			                         
			                           if (strDatCd.equals("G0018")) {
			                        	   {
			                        		   String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			   		                 		
			                        		   if (strResid.equals(strDecValue)) { 
		
					                                if ((PkgFuncUtils.getXmlTagValue("saving_gubn", subXmlElData)).equals("1"))  {
					                                    // Y0040050	B011	0050	청약저축					31
					                                      edETCS_COMP = edETCS_COMP.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
					                                      //+   strtofloat(subXmlItemData.NamedItem['sum'].Text);
					                                }
					                                else  if ((PkgFuncUtils.getXmlTagValue("saving_gubn", subXmlElData)).equals("2"))  {
					                                  //Y0040060	B011	0060	주택청약종합저축       					32
					                                   edETWK_HSBM = edETWK_HSBM.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
					                                   // +   strtofloat(subXmlItemData.NamedItem['sum'].Text);
					                                }
					                                else  if ((PkgFuncUtils.getXmlTagValue("saving_gubn", subXmlElData)).equals("4"))  {
					                               
					                                   edETWK_HSVM = edETWK_HSVM.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
					                                      //+   strtofloat(subXmlItemData.NamedItem['sum'].Text);
					                                  //Y0040080	B011	0080	근로자주택마련저축     					34
					                                }
					                                // ETCS_COMP	72			Y	NUMBER (12)	0	기타공제_주택마련저축_청약저축	No
					                                // ETWK_HSVM	73			Y	NUMBER (12)	0	기타공제_주택마련저축_근로자주택마련저축	No
					                                // ETWK_HSBM	74			Y	NUMBER (12)	0	기타공제_주택마련저축_주택청약종합저축	No
					                                // ETWK_HLGM	75			Y	NUMBER (12)	0	기타공제_주택마련저축_장기주택마련저축	No
				 
					                                yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
					        	                     yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
					        	                    yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
					        	                    yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
				
					                                if ((PkgFuncUtils.getXmlTagValue("saving_gubn", subXmlElData)).equals("1"))  {
					                              
					                                    // Y0040050	B011	0050	청약저축					31  edETCS_COMP
					                                	  yetaPrc3100Vo.setImdeGbcd("Y0040050");    /** column 소득공제구분코드 : imdeGbcd */
							        	                    yetaPrc3100Vo.setImdeTxcd("31");    /** column 소득공제구분국세청코드 : imdeTxcd */
					                                     // oraQryInsert.ParamByName('IMDE_GBCD').AsString  :=  'Y0040050';
					                                     // oraQryInsert.ParamByName('IMDE_TXCD').AsString := '31';
				
					                                }
					                                else  if  ((PkgFuncUtils.getXmlTagValue("saving_gubn", subXmlElData)).equals("2"))  {
					                               
					                                  //Y0040060	B011	0060	주택청약종합저축       					32    edETWK_HSBM
					                                	  yetaPrc3100Vo.setImdeGbcd("Y0040060");    /** column 소득공제구분코드 : imdeGbcd */
							        	                    yetaPrc3100Vo.setImdeTxcd("32");    /** column 소득공제구분국세청코드 : imdeTxcd */
					                                     // oraQryInsert.ParamByName('IMDE_GBCD').AsString  :=  'Y0040060';
					                                     // oraQryInsert.ParamByName('IMDE_TXCD').AsString := '32';
				
					                                }
					                                else  if ((PkgFuncUtils.getXmlTagValue("saving_gubn", subXmlElData)).equals("4"))  {
					                               
					                                	  yetaPrc3100Vo.setImdeGbcd("Y0040080");    /** column 소득공제구분코드 : imdeGbcd */
							        	                    yetaPrc3100Vo.setImdeTxcd("34");    /** column 소득공제구분국세청코드 : imdeTxcd */
					                                     // oraQryInsert.ParamByName('IMDE_GBCD').AsString  :=  'Y0040080';
					                                     // oraQryInsert.ParamByName('IMDE_TXCD').AsString := '34';
				
					                                  //Y0040080	B011	0080	근로자주택마련저축     					34     edETWK_HSVM
					                                }
					  
					        	                  
													yetaPrc3100Vo.setFinaSeqn(BigDecimal.ZERO);    /** column 연금_저축일련번호 : finaSeqn */ 
													yetaPrc3100Vo.setFinaCode(PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관코드 : finaCode */
													yetaPrc3100Vo.setFinaName(subXmlElData.getAttribute("trade_nm") );    /** column 금융기관상호 : finaName */
													yetaPrc3100Vo.setAcntNumb(subXmlElData.getAttribute("acc_no") );    /** column 계좌번호 : acntNumb */
													yetaPrc3100Vo.setIcnmYear("");    /** column 납입연차 : icnmYear */
													yetaPrc3100Vo.setPaytAmnt(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));    /** column 불입금액 : paytAmnt */
													yetaPrc3100Vo.setDeduAmnt(BigDecimal.ZERO);    /** column 세액공제금액 : deduAmnt */
													
													yetaPrc3100Vo.setFinaTxcd( PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관국세청코드 : finaTxcd */
//													yetaPrc3100Vo.setKybdr(yeta3100Dto.getKybdr());    /** column 입력자 : kybdr */
//													yetaPrc3100Vo.setInptDt(yeta3100Dto.getInptDt());    /** column 입력일자 : inptDt */
//													yetaPrc3100Vo.setInptAddr(yeta3100Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//													yetaPrc3100Vo.setIsmt(yeta3100Dto.getIsmt());    /** column 수정자 : ismt */
//													yetaPrc3100Vo.setRevnDt(yeta3100Dto.getRevnDt());    /** column 수정일자 : revnDt */
//													yetaPrc3100Vo.setRevnAddr(yeta3100Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
													
													
					                              //  oraQryInsert.ParamByName('IMDE_GBNM').AsString := Cells[4,jRow];
//					                                oraQryInsert.ParamByName('FINA_CODE').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//					                                oraQryInsert.ParamByName('FINA_TXCD').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//					                                oraQryInsert.ParamByName('FINA_NAME').AsString := subXmlItemData.Params.Values['trade_nm'];
//					                                oraQryInsert.ParamByName('ACNT_NUMB').AsString := subXmlItemData.Params.Values['acc_no'];
//					                                oraQryInsert.ParamByName('ICNM_YEAR').AsString := '';
//					                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemData.NamedItem['sum'].Text;
//					                                oraQryInsert.ParamByName('DEDU_AMNT').AsString := '0';
													  yetaPayr1200Service.fnPayr06430_Payr418_2016_Insert(yetaPrc3100Vo);
		
			                        		   }
			                        	   }
			                           }
		
			                       }
			                    
			                 }  
		
			                     // oraQryUpdate.ParamByName('ETCS_COMP').AsFloat :=  edETCS_COMP;
			                     // oraQryUpdate.ParamByName('ETWK_HSBM').AsFloat :=  edETWK_HSBM;
			                     // oraQryUpdate.ParamByName('ETWK_HSVM').AsFloat :=  edETWK_HSVM;
		
			                      yeta2000Vo.setEtcsComp(edETCS_COMP);
			                      yeta2000Vo.setEtwkHsbm(edETWK_HSBM);
			                      yeta2000Vo.setEtwkHsvm(edETWK_HSVM);
			                      
			 					 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
				                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
				                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
				                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
			 	                 
			 	                 yetaPayr1200Service.fnPayr06425_PAYR415_2016_02_Update(yeta2000Vo);
			 	                 


	                }
	                else if  ((strFormCd.equals("J401Y")) || (strFormCd.equals("J401M")))  {
	                	/**+++++++++++   목돈 안드는 전세 이자상환액++++++++++++++++++++++++++++++++++++++++++++++++*/
	                	// 2014년 신규 추가 테이블필드 완료
	                   // 목돈 안드는 전세 이자상환액  - -J401Y 기본  J401M 월별 J04 목돈 안드는 전세이자상환액 본인
	                   // edMonyItre
	                	 subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
	 	                
		                 //인원별 반복구간
		                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
	 
			            	 
		                       subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
		                       subXmlElMan  = (Element) subXmlItemMan;

		                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
		                        //상품별 반복구간
		                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
		                        
		                         subXmlItemData =  subXmlElChildMan.item(k); 
		                         subXmlElData  = (Element) subXmlItemData;
		                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
		                         
	                             if (strDatCd.equals("G0023")) {
	                           
	                              edMonyItre = edMonyItre.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
	                         // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                             }
		                       }

		                 }

	                      
	                      yeta2000Vo.setEtgdCtra(edMonyItre);
	 					  yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
		                  yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
		                  yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
		                  yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
		                  
	 	                  yetaPayr1200Service.fnPayr06425_PAYR415_2016_03_Update(yeta2000Vo);
	 	                 
	 	                 
	                }
	                else if (strFormCd.equals("K101M")) { //TODO 소상공인 로그 안나옴.
	                	/**+++++++++++   소상공인공제 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
	                	//  소상공인공제 시작
	                   //소기업소상공인 공제부금 - - K101M 월별 K01 소기업소상공인공제부금 본인
	                   // 월별상세만존제   edEtchPrep
	                	 subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
	 	                
		                 //인원별 반복구간
		                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
	 

		                	 subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
		                       subXmlElMan  = (Element) subXmlItemMan;
		                       
		                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
		                        //상품별 반복구간
		                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
		                        
		                         subXmlItemData =  subXmlElChildMan.item(k); 
		                         subXmlElData  = (Element) subXmlItemData;
		                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
		                         
	                             if (strDatCd.equals("G0019")) {
	                            
	                              edEtchPrep = edEtchPrep.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
	                               // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                             // edEtchPrepStartDt = edEtchPrepStartDt.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("start_dt", subXmlElData)));   // TODO 공제가입일자
	                             // edEtchPrepEndDt = edEtchPrepEndDt.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));  // TODO 대상기간종료일/개정규칙 적용 신청여부
	                              
	                             }
		                       }

		                 }
		                 
	       

	                   //  oraQryUpdate.ParamByName('ETCH_PREP').AsFloat :=  ;
 
	                     yeta2000Vo.setEtchPrep(edEtchPrep);
//	                     yeta2000Vo.setEdEtchPrepStartDt(edEtchPrepStartDt); //TODO 공제가입일자 VO 
//	                     yeta2000Vo.setEdEtchPrepEndDt(edEtchPrepEndDt); // TODO 대상기간종료일/개정규칙 적용 신청여부
	                     
						 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
		                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
		                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
		                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
		                 
		                 yetaPayr1200Service.fnPayr06425_PAYR415_2016_04_Update(yeta2000Vo);
		                 
	                }
	                else if ((strFormCd.equals("L102Y"))    ||  (strFormCd.equals("L102D"))) {
	                	/**+++++++++++    기부금시작++++++++++++++++++++++++++++++++++++++++++++++++*/
	                	//  기부금시작
	                     // 기부금 L101Y 연간합계 L101D 일별 L01 기부금 본인+가족
	                     //  arrSPCI_PAY   : array[1..10] of array[1..10] of string;
	                     //edSpciFbam, edSpciPltc,edSpciExam,edSpciUnon, edSpciNamt, edSpciYamt, edSPCI_HFAM

	                       strDatCd = "";
	                       ddCnt = 0; 
	  	              
	                       subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
	  	                
	  	                 //인원별 반복구간
	  	                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
	   
	  	                   subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
	                       subXmlElMan  = (Element) subXmlItemMan;
	                       
	                       strResid = subXmlElMan.getAttribute("resid");   //주민번호

	                            
	                         arrSPCI_PAY[ddCnt][0]  = strResid;
	                             
	                             subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
	 	                        //상품별 반복구간
	 	                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
	 	                    	  ldCnt = 0;
	 	                         subXmlItemData =  subXmlElChildMan.item(k); 
	 	                         subXmlElData  = (Element) subXmlItemData;
	 	                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
	 	                          
	                               if (strDatCd.equals("G0020")) {
	                                         //  arrSPCI_PAY   : array[1..10] of array[1..10] of string;
	                                 //edSpciFbam, edSpciPltc,edSpciExam,edSpciUnon, edSpciNamt, edSpciYamt, edSPCI_HFAM
	                                  if ((subXmlElData.getAttribute("donation_cd")).equals("10")) { 
	                                	 
	                                      edSpciFbam = edSpciFbam.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
	                                      // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                      arrSPCI_PAY[ddCnt][1]   =  String.valueOf(new BigDecimal(arrSPCI_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                    		  //floattostr(strtofloat(arrSPCI_PAY[ddCnt][2]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                                  else  if ((subXmlElData.getAttribute("donation_cd")).equals("20")) { 
	                             
	                                      edSpciPltc = edSpciPltc.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
	                                      // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                      arrSPCI_PAY[ddCnt][1]   =   String.valueOf(new BigDecimal(arrSPCI_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                      //floattostr(strtofloat(arrSPCI_PAY[ddCnt][2]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                                  else  if ((subXmlElData.getAttribute("donation_cd")).equals("21")) {  
	                                	  edSpciPltc = edSpciPltc.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
	                                      // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                      arrSPCI_PAY[ddCnt][1]   =   String.valueOf(new BigDecimal(arrSPCI_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
	                                      //floattostr(strtofloat(arrSPCI_PAY[ddCnt][2]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                                  else  if ((subXmlElData.getAttribute("donation_cd")).equals("40")) { 
	                                   
	                                      edSpciNamt = edSpciNamt.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
	                                      // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                      arrSPCI_PAY[ddCnt][1]   =   String.valueOf(new BigDecimal(arrSPCI_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
	                                      //floattostr(strtofloat(arrSPCI_PAY[ddCnt][2]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                                  else  if ((subXmlElData.getAttribute("donation_cd")).equals("41")) { 
	                                  
	                                      edSpciYamt = edSpciYamt.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
	                                      // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                      arrSPCI_PAY[ddCnt][1]   =   String.valueOf(new BigDecimal(arrSPCI_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
	                                      //floattostr(strtofloat(arrSPCI_PAY[ddCnt][2]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                                  else  if ((subXmlElData.getAttribute("donation_cd")).equals("42")) { 
	                               
	                                      edSPCI_HFAM = edSPCI_HFAM.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
	                                      // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                                      arrSPCI_PAY[ddCnt][1]   =   String.valueOf(new BigDecimal(arrSPCI_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
	                                      //floattostr(strtofloat(arrSPCI_PAY[ddCnt][2]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
	                                  }
	                                  else  if ((subXmlElData.getAttribute("donation_cd")).equals("50")) { 
	                                 
	                                  }
	                                  if (strFormCd.equals("L102D")) {
	                                
	                                	  NodeList subXmlEldd =  subXmlElData.getElementsByTagName("amt");
	        	                        	 
	                                	  ldCnt = subXmlEldd.getLength();
	         	                             
	                                      if (ldCnt == 0) { ldCnt = 1;} 
	                                  }

	                                  InfcPkgYeta3180VO yetaPrc3180Vo =  new InfcPkgYeta3180VO();

										yetaPrc3180Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
										yetaPrc3180Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
										yetaPrc3180Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
										yetaPrc3180Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */

										String strEncValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
											
										yetaPrc3180Vo.setRsnoNumb(strEncValue);    /** column 주민등록번호 : rsnoNumb */
										yetaPrc3180Vo.setCtrbSeqn(BigDecimal.ZERO);    /** column 기부내역일련번호 : ctrbSeqn */
									 
 
	                                   
	                                    yetaPrc3180Vo.setCtrbTycd(subXmlElData.getAttribute("donation_cd") );    /** column 기부유형코드 : ctrbTycd */
										yetaPrc3180Vo.setCtrbBsnu(subXmlElData.getAttribute("busnid"));    /** column 기부처사업자번호 : ctrbBsnu */
	                                   
	                                  // oraQryDelete.ParamByName('CTRB_BSNU').AsString := subXmlItemData.Params.Values['busnid']; //기부처사업자번호
	                                  // oraQryDelete.ParamByName('CTRB_TYCD').AsString := subXmlItemData.Params.Values['donation_cd'];      //기부유형코드

	                                   yetaPayr1200Service.fnPayr06430_PAYR440_2015_Delete(yetaPrc3180Vo);    //삭제  
	                                   

	                                   yetaPrc3180Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
										yetaPrc3180Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
										yetaPrc3180Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
										yetaPrc3180Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */
										yetaPrc3180Vo.setCtrbSeqn(BigDecimal.ZERO);    /** column 기부내역일련번호 : ctrbSeqn */
									 
	                                   
									     yetaPrc3180Vo.setCtrbYrmn((String) commandMap.get("srhClutYr"));    /** column 기부연도 : ctrbYrmn */
	                                     // oraQryInsert.ParamByName('CTRB_YRMN').AsString := lblEDAC_RVYY.Caption;      //기부연월- 기부년도
	                                      
	                                      
	                                      if ((subXmlElData.getAttribute("donation_cd")).equals("10")) { 
	                                      
	                                        yetaPrc3180Vo.setCtrbDdcd("B0230010");    /** column 기부유형구분코드 : ctrbDdcd */	
	                                        yetaPrc3180Vo.setCtrbTycd(subXmlElData.getAttribute("donation_cd"));    /** column 기부유형코드 : ctrbTycd */
	                                     
											
	                                          //oraQryInsert.ParamByName('CTRB_DDCD').AsString := 'B0230010';   //기부유형구분코드
	                                          //oraQryInsert.ParamByName('CTRB_TYCD').AsString := subXmlItemData.Params.Values['donation_cd'];        //기부유형코드
	                                      }
	                                      else  if ((subXmlElData.getAttribute("donation_cd")).equals("20")) { 
	                                    	  
	                                    	  
	                                    	   yetaPrc3180Vo.setCtrbDdcd("B0230020");    /** column 기부유형구분코드 : ctrbDdcd */	
		                                        yetaPrc3180Vo.setCtrbTycd(subXmlElData.getAttribute("donation_cd"));    /** column 기부유형코드 : ctrbTycd */
		                                        
	                                        //  oraQryInsert.ParamByName('CTRB_DDCD').AsString := '1';    //기부유형구분코드
	                                        //  oraQryInsert.ParamByName('CTRB_TYCD').AsString :=  subXmlItemData.Params.Values['donation_cd'];      //기부유형코드
	                                      }
	                                      else  if ((subXmlElData.getAttribute("donation_cd")).equals("21")) { 
	                                    	  yetaPrc3180Vo.setCtrbDdcd("B0230021");    /** column 기부유형구분코드 : ctrbDdcd */	
	                                    	  yetaPrc3180Vo.setCtrbTycd(subXmlElData.getAttribute("donation_cd"));    /** column 기부유형코드 : ctrbTycd */
	                                      }
	                                      else  if ((subXmlElData.getAttribute("donation_cd")).equals("40")) { 
	                                       
	                                    	   yetaPrc3180Vo.setCtrbDdcd("B0230040");    /** column 기부유형구분코드 : ctrbDdcd */	
		                                        yetaPrc3180Vo.setCtrbTycd(subXmlElData.getAttribute("donation_cd"));    /** column 기부유형코드 : ctrbTycd */
		                                        
	                                    	//  oraQryInsert.ParamByName('CTRB_DDCD').AsString := '2';     //기부유형구분코드
	                                        //  oraQryInsert.ParamByName('CTRB_TYCD').AsString := subXmlItemData.Params.Values['donation_cd'];      //기부유형코드
	                                      }
	                                      else  if ((subXmlElData.getAttribute("donation_cd")).equals("41")) { 
	                                         
	                                    	   yetaPrc3180Vo.setCtrbDdcd("B0230041");    /** column 기부유형구분코드 : ctrbDdcd */	
		                                        yetaPrc3180Vo.setCtrbTycd(subXmlElData.getAttribute("donation_cd"));    /** column 기부유형코드 : ctrbTycd */
		                                        
	                                    	//  oraQryInsert.ParamByName('CTRB_DDCD').AsString := '3';      //기부유형구분코드
	                                        //   oraQryInsert.ParamByName('CTRB_TYCD').AsString := subXmlItemData.Params.Values['donation_cd'];     //기부유형코드
	                                      }
	                                      else  if ((subXmlElData.getAttribute("donation_cd")).equals("42")) { 
	                                         
	                                    	   yetaPrc3180Vo.setCtrbDdcd("B0230042");    /** column 기부유형구분코드 : ctrbDdcd */	
		                                        yetaPrc3180Vo.setCtrbTycd(subXmlElData.getAttribute("donation_cd"));    /** column 기부유형코드 : ctrbTycd */
		                                        
	                                    	//  oraQryInsert.ParamByName('CTRB_DDCD').AsString := '4';     //기부유형구분코드
	                                        //  oraQryInsert.ParamByName('CTRB_TYCD').AsString :=  subXmlItemData.Params.Values['donation_cd'];      //기부유형코드
	                                      }
	                                      else  if ((subXmlElData.getAttribute("donation_cd")).equals("50")) { 
	                                         
	                                    	   yetaPrc3180Vo.setCtrbDdcd("B0230050");    /** column 기부유형구분코드 : ctrbDdcd */	
		                                        yetaPrc3180Vo.setCtrbTycd(subXmlElData.getAttribute("donation_cd"));    /** column 기부유형코드 : ctrbTycd */
		                                        
	                                    	//  oraQryInsert.ParamByName('CTRB_DDCD').AsString := '5';      //기부유형구분코드
	                                        //  oraQryInsert.ParamByName('CTRB_TYCD').AsString := subXmlItemData.Params.Values['donation_cd'];     //기부유형코드
	                                      }

	                                       
	                                    yetaPrc3180Vo.setCtrbBsnu(subXmlElData.getAttribute("busnid"));    /** column 기부처사업자번호 : ctrbBsnu */
	                                	yetaPrc3180Vo.setCtrbCont("");    /** column 기부내용 : ctrbCont */ 
										
	                                	yetaPrc3180Vo.setCtrbName(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("trade_nm")).substring(0, (MSFSharedUtils.allowNulls(subXmlElData.getAttribute("trade_nm")).length() < 48 ? 
	                                			  																MSFSharedUtils.allowNulls(subXmlElData.getAttribute("trade_nm")).length() :48)));    /** column 기부처명 : ctrbName */ 
										yetaPrc3180Vo.setCtrbTgam(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));    /** column 공제대상기부금액 : ctrbAmnt */
										yetaPrc3180Vo.setCtjaCham(new BigDecimal(PkgFuncUtils.getXmlTagValue("sbdy_apln_sum", subXmlElData)));	/** column 기부장려금신청금액 : ctjaCham */
										yetaPrc3180Vo.setCtrbAmnt(new BigDecimal(PkgFuncUtils.getXmlTagValue("conb_sum", subXmlElData)));	/** column 기부금액 : ctrbAmnt */
										
										//TODO 추가된 서식 : 기부장려금신청금액, 기부금액합계
										//yetaPrc3180Vo.setSbdyAplnSum(new BigDecimal(PkgFuncUtils.getXmlTagValue("sbdy_apln_sum", subXmlElData)));    /** column 기부장려금신청금액 : SbdyAplnSum */
										//yetaPrc3180Vo.setConbSum(new BigDecimal(PkgFuncUtils.getXmlTagValue("conb_sum", subXmlElData)));    /** column 기부금액합계 : ConbSum */
 
										yetaPrc3180Vo.setCrtbCncd(strEncValue);    /** column 기부자관계구분코드 : crtbCncd */
										yetaPrc3180Vo.setCrnrFlag(strEncValue);    /** column 기부자내국인구분코드 : crnrFlag */
										yetaPrc3180Vo.setCbtgName(subXmlElMan.getAttribute("name"));    /** column 기부자성명 : cbtgName */ 
											
										yetaPrc3180Vo.setRsnoNumb(strEncValue);    /** column 주민등록번호 : rsnoNumb */
//										yetaPrc3180Vo.setCtrbCtnt(String.valueOf(ldCnt));    /** column 기부금유형콤보TEMP : ctrbCtnt */
										yetaPrc3180Vo.setCtrbNcnt(BigDecimal.valueOf(ldCnt));	/** column 기부금건수 : ctrbNcnt */
										yetaPrc3180Vo.setReceRati("0");    /** column 영수증유무 : receRati */
										yetaPrc3180Vo.setGuksYeno("Y");
									 
//										yetaPrc3180Vo.setKybdr(yeta3180Dto.getKybdr());    /** column 입력자 : kybdr */
//										yetaPrc3180Vo.setInptDt(yeta3180Dto.getInptDt());    /** column 입력일자 : inptDt */
//										yetaPrc3180Vo.setInptAddr(yeta3180Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//										yetaPrc3180Vo.setIsmt(yeta3180Dto.getIsmt());    /** column 수정자 : ismt */
//										yetaPrc3180Vo.setRevnDt(yeta3180Dto.getRevnDt());    /** column 수정일자 : revnDt */
//										yetaPrc3180Vo.setRevnAddr(yeta3180Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
										
										
//	                                    oraQryInsert.ParamByName('CTRB_CONT').AsString := '';      //기부내용
//	                                    oraQryInsert.ParamByName('CTRB_NAME').AsString := copy(subXmlItemData.Params.Values['trade_nm'],1,46);      //기부처명
//	                                    oraQryInsert.ParamByName('CTRB_BSNU').AsString := subXmlItemData.Params.Values['busnid']; //기부처사업자번호
//
//	                                    oraQryInsert.ParamByName('CRTB_CNCD').AsString := strResid;      //기부자관계구분코드
//	                                    oraQryInsert.ParamByName('CBTG_NAME').AsString := subXmlItemMan.Params.Values['name'];      // 기부자성명
//	                                    oraQryInsert.ParamByName('RSNO_NUMB').AsString := strResid; //주민등록번호
//
//
//	                                    oraQryInsert.ParamByName('CTRB_CTNT').AsString :=  inttostr(ldCnt) ;  //건수
//	                                    oraQryInsert.ParamByName('CTRB_AMNT').AsString :=  subXmlItemData.NamedItem['sum'].Text;//기부금액
//
//
//	                                    oraQryInsert.ParamByName('INPT_USID').AsString := '';
//	                                    oraQryInsert.ParamByName('INPT_ADDR').AsString := ''; 

	                                    yetaPayr1200Service.fnPayr06430_PAYR440_2015_1_Insert(yetaPrc3180Vo); 

	                               }
	                             
	 	                       }
	 	                       ddCnt = ddCnt + 1;
	  	                 }
//	  	                 InfcPkgYeta3180VO yetaPrc3180Vo =  new InfcPkgYeta3180VO();
//	  	                  
//						 yetaPrc3180Vo.setCtrbNcnt(ddCnt1);
//	  	                 yetaPrc3180Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
//						 yetaPrc3180Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
//						 yetaPrc3180Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
//						 yetaPrc3180Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */
	  	                 	
	  	                 
	  	                   yeta2000Vo.setSpciFbam(edSpciFbam);  //A01 특별공제_기부금_법정
	                       yeta2000Vo.setSpciPltc(edSpciPltc);  //A01 특별공제_기부금_정치10만초과대상금액
	                       yeta2000Vo.setSpciExam(edSpciExam);  //A01 특별공제_기부금_특례_공인법인신탁제외
	                       yeta2000Vo.setSpciUnon(edSpciUnon);  //A01 특별공제_기부금_공인법인신탁
	                       yeta2000Vo.setSpciNamt(edSpciNamt);  //A01 특별공제_기부금_종교단체외지정기부금
	                       yeta2000Vo.setSpciYamt(edSpciYamt);  //A01 특별공제_기부금_종교단체지정기부금
	                       yeta2000Vo.setSpciHfam(edSPCI_HFAM); //A01 특별공제_기부금_우리사주조합2015이후
	                       
	                       yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
			               yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
			               yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
			               yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
			                 
	  	                  
	  	                   yetaPayr1200Service.fnPayr06425_PAYR415_2016_10_Update(yeta2000Vo);

//	                       oraQryUpdate.ParamByName('SPCI_FBAM').AsFloat := edSpciFbam;
//	                       oraQryUpdate.ParamByName('SPCI_PLTC').AsFloat := edSpciPltc;
//	                       oraQryUpdate.ParamByName('SPCI_EXAM').AsFloat := edSpciExam;
//	                       oraQryUpdate.ParamByName('SPCI_UNON').AsFloat := edSpciUnon;
//	                       oraQryUpdate.ParamByName('SPCI_NAMT').AsFloat := edSpciNamt;
//	                       oraQryUpdate.ParamByName('SPCI_YAMT').AsFloat := edSpciYamt;
//	                       oraQryUpdate.ParamByName('SPCI_HFAM').AsFloat := edSPCI_HFAM;
 
	                }
	                else if ((strFormCd.equals("N101Y"))  ||  (strFormCd.equals("N101M"))) {
	                	/**+++++++++++   장기집합 투자 증권 저축++++++++++++++++++++++++++++++++++++++++++++++++*/
	                	//  2014 년도 귀속
	                   //장기집합 투자 증권 저축
	                   //Y0040110	B011	0110	장기집합투자증권저축					51
	                    strDatCd  = "";

	                    
	                       InfcPkgYeta3100VO yetaPrc3100Vo = new InfcPkgYeta3100VO();
		                   
		                   yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
		                   yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
		                   yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
		                   yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
		                   yetaPrc3100Vo.setImdeGbcd("Y0040110");    /** column 소득공제구분코드 : imdeGbcd */
		                   
		                   yetaPayr1200Service.fnPayr06430_Payr418_2015_Delete(yetaPrc3100Vo);
		                   
	                    

//	                    oraQryDelete.ParamByName('EDAC_RVYY').AsString :=  lblEDAC_RVYY.Caption;
//	                    oraQryDelete.ParamByName('SETT_GBCD').AsString :=  lblSETT_GBCD.Caption;
//	                    oraQryDelete.ParamByName('PSNL_NUMB').AsString :=  lblPSNL_NUMB.Caption;
//	                    oraQryDelete.ParamByName('IMDE_GBCD').AsString := 'B0110110';   //	장기집합투자증권저축
 
		                   subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
			                
			                 //인원별 반복구간
			                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
		 
				            	 
			                       subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			                       subXmlElMan  = (Element) subXmlItemMan;
			                       
			                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
			                       
			                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			                        //상품별 반복구간
			                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
			                        
			                         subXmlItemData =  subXmlElChildMan.item(k); 
			                         subXmlElData  = (Element) subXmlItemData;
			                         strDatCd = subXmlElData.getAttribute("dat_cd"); 

			                 		 String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			                 		
			                         if (strDatCd.equals("G0029")) {
			                           
			                        	   if (strResid.equals(strDecValue)) { 
		
			                                //Y0040110	B011	0110	장기집합투자증권저축					51
			                                edETEP_SEST = edETEP_SEST.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
			                                        // +   strtofloat(subXmlItemData.NamedItem['sum'].Text);
		
		  
		
			                               yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
			     		                   yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
			     		                   yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
			     		                   yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
			        	                    
			        	                    
			                                //B0110110	B011	0110	장기집합투자증권저축					51
			        	                    yetaPrc3100Vo.setImdeGbcd("Y0040110");    /** column 소득공제구분코드 : imdeGbcd */
			        	                    yetaPrc3100Vo.setImdeTxcd("51");    /** column 소득공제구분국세청코드 : imdeTxcd */
			        	                    
			                               // oraQryInsert.ParamByName('IMDE_GBCD').AsString :=  'Y0040110';
			                               // oraQryInsert.ParamByName('IMDE_TXCD').AsString := '51';
		
		
		
			                              //  oraQryInsert.ParamByName('IMDE_GBNM').AsString := Cells[4,jRow];
//			                                oraQryInsert.ParamByName('FINA_CODE').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//			                                oraQryInsert.ParamByName('FINA_TXCD').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//			                                oraQryInsert.ParamByName('FINA_NAME').AsString := subXmlItemData.Params.Values['trade_nm'];
//			                                oraQryInsert.ParamByName('ACNT_NUMB').AsString := subXmlItemData.Params.Values['secu_no'];
//		
//			                                oraQryInsert.ParamByName('ICNM_YEAR').AsString := '';
			                                
//			                               { subXmlItemDD :=  subXmlItemData.NamedItem['sum'];
//			                                if strtofloat(subXmlItemDD.Params.Values['sum_y1']) > 0 then
//			                                begin
//			                                  oraQryInsert.ParamByName('ICNM_YEAR').AsString := '1';
//			                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemDD.Params.Values['sum_y1'];
//			                                end
//			                                else if strtofloat(subXmlItemDD.Params.Values['sum_y2']) > 0 then
//			                                begin
//			                                  oraQryInsert.ParamByName('ICNM_YEAR').AsString := '2';
//			                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemDD.Params.Values['sum_y2'];
//			                                end
//			                                else if strtofloat(subXmlItemDD.Params.Values['sum_y3']) > 0 then
//			                                begin
//			                                  oraQryInsert.ParamByName('ICNM_YEAR').AsString := '3';
//			                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemDD.Params.Values['sum_y3'];
//			                                end ;  }
		
			                               // oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemData.NamedItem['sum'].Text;
			                               // oraQryInsert.ParamByName('DEDU_AMNT').AsString := subXmlItemData.NamedItem['ddct_bs_ass_amt'].Text;
		  
											yetaPrc3100Vo.setFinaSeqn(BigDecimal.ZERO);    /** column 연금_저축일련번호 : finaSeqn */ 
											yetaPrc3100Vo.setFinaCode(PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관코드 : finaCode */
											yetaPrc3100Vo.setFinaName(subXmlElData.getAttribute("trade_nm") );    /** column 금융기관상호 : finaName */
											yetaPrc3100Vo.setAcntNumb(subXmlElData.getAttribute("acc_no") );    /** column 계좌번호 : acntNumb */
											yetaPrc3100Vo.setIcnmYear("");    /** column 납입연차 : icnmYear */
											yetaPrc3100Vo.setPaytAmnt(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));    /** column 불입금액 : paytAmnt */
											yetaPrc3100Vo.setDeduAmnt(new BigDecimal(PkgFuncUtils.getXmlTagValue("ddct_bs_ass_amt", subXmlElData)));    /** column 세액공제금액 : deduAmnt */
											
											yetaPrc3100Vo.setFinaTxcd( PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관국세청코드 : finaTxcd */
//											yetaPrc3100Vo.setKybdr(yeta3100Dto.getKybdr());    /** column 입력자 : kybdr */
//											yetaPrc3100Vo.setInptDt(yeta3100Dto.getInptDt());    /** column 입력일자 : inptDt */
//											yetaPrc3100Vo.setInptAddr(yeta3100Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//											yetaPrc3100Vo.setIsmt(yeta3100Dto.getIsmt());    /** column 수정자 : ismt */
//											yetaPrc3100Vo.setRevnDt(yeta3100Dto.getRevnDt());    /** column 수정일자 : revnDt */
//											yetaPrc3100Vo.setRevnAddr(yeta3100Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
			 
 

				                            yetaPayr1200Service.fnPayr06430_Payr418_2016_Insert(yetaPrc3100Vo);

			                        	   }
			                         }
			                       } 

			                 }
 

	                    //  oraQryUpdate.ParamByName('ETEP_SEST').AsFloat :=  ;
 
	                     yeta2000Vo.setEtepSest(edETEP_SEST);
	 					 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
		                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
		                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
		                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
	 	                
		                 yetaPayr1200Service.fnPayr06425_PAYR415_2016_05_Update(yeta2000Vo);
	 	                 
	                }else if (strFormCd.equals("O101M")) {
	                	/**+++++++++++   건강보험료 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
	                	//  건강보험료 시작
	                	 subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
	 	                
		                 //인원별 반복구간
		                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
	 

		                  	   subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
		                       subXmlElMan  = (Element) subXmlItemMan;
		                       
		                       strResid = subXmlElMan.getAttribute("resid");   //주민번호

         		
		                      // System.out.println("건강보험료 주민번호 ---  " + strResid);
		                       
		                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
		                       //TODO subXmlElChildSum = subXmlElMan.getElementsByTagName("sum"); sum.getAttribute 가져오기 위해 선언
		                        //상품별 반복구간
		                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
		                        
		                         subXmlItemData =  subXmlElChildMan.item(k); 
		                         subXmlElData  = (Element) subXmlItemData;
		                         strDatCd = subXmlElData.getAttribute("dat_cd");
		                         
		                        // subXmlItemSum =  subXmlElChildSum.item(k);  TODO 건강보험료 sum 속성 가져오기 위해.
		                       //  subXmlElSum = (Element) subXmlItemSum; TODO 건강보험료 sum 속성 가져오기 위해.
		                         
	                             if (strDatCd.equals("G0030")) {
			                           
//	                            	 if (strResid.equals(commandMap.get("resnRegnNum"))) { 
	                            		 
		                            	 edSpciHhLh = edSpciHhLh.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
			                               // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	//				                  	    strHiYrs = subXmlElSum.getAttribute("hi_yrs");
	//				                	    strItrmYrs = subXmlElSum.getAttribute("ltrm_yrs");
	//				                	    strHiNtf = subXmlElSum.getAttribute("hi_ntf");
	//				                	    strItrmNtf = subXmlElSum.getAttribute("ltrm_ntf");
	//				                	    strHiPmt = subXmlElSum.getAttribute("hi_pmt");
	//				                	    strItrmPmt = subXmlElSum.getAttribute("ltrm_pmt");
//	                            	 	 }
		                             }
			                     }
			                 }
		                 
			                 InfcPkgYeta3220VO yetaPrc3220Vo = new InfcPkgYeta3220VO();
			                 
			                 yetaPrc3220Vo.setInsuPayr(edSpciHhLh);

		                     String strEncValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
		                   		        
			                 yetaPrc3220Vo.setRsnoNumb(strEncValue);    /** column 주민등록번호 : rsnoNumb */
			                 yetaPrc3220Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
			                 yetaPrc3220Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
			                 yetaPrc3220Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
			                 yetaPrc3220Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
			                 
			                 yetaPayr1200Service.fnPayr06425_PAYR415_2016_18_Update(yetaPrc3220Vo);
			                 
			                 
		                 	 yeta2000Vo.setSpciHhlh(edSpciHhLh);
		    				 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
			                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
			                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
			                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
			                 
			                 yetaPayr1200Service.fnPayr06425_PAYR415_2016_15_Update(yeta2000Vo);

		               }else if (strFormCd.equals("P101M")) {
			                	/**+++++++++++   국민연금보험료 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
			                	//  국민연금보험료 시작
			                	 subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
			 	                
				                 //인원별 반복구간
				                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
			 

				                	 subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
				                       subXmlElMan  = (Element) subXmlItemMan;
				                       
				                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
				                       //TODO subXmlElChildSum = subXmlElMan.getElementsByTagName("sum"); sum.getAttribute 가져오기 위해 선언
				                        //상품별 반복구간
				                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
				                        
				                         subXmlItemData =  subXmlElChildMan.item(k); 
				                         subXmlElData  = (Element) subXmlItemData;
				                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
				                         
				                         // subXmlItemSum =  subXmlElChildSum.item(k);  TODO 국민연금보험료 sum 속성 가져오기 위해.
					                       //  subXmlElSum = (Element) subXmlItemSum; TODO 국민연금보험료 sum 속성 가져오기 위해.
				                         
			                             if (strDatCd.equals("G0031")) {
			                            
			                            	 edJnatPsnf = edJnatPsnf.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
			                               // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
			                              
//			                                strNtf = subXmlElSum.getAttribute("ntf"); 
//					                	    strPmt = subXmlElSum.getAttribute("pmt");
			                              
			                             }
				                       }

				                 }
				                 
				                 yeta2000Vo.setJnatPsnf(edJnatPsnf);
								 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
				                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
				                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
				                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
				                 
				                 yetaPayr1200Service.fnPayr06425_PAYR415_2016_16_Update(yeta2000Vo);
				                 
			                }
 
	                }
//	               { else if (strFormCd = 'M101Y') OR  (strFormCd = 'M101M') then
//	                begin
//	                  //  2014 년도 종료 
//	                   //장기주식형저축 M101Y 연간합계 M101M 월별 M01 장기주식형저축 본인
//	                   //B0110090	B011	0090	장기주식형저축					41
//	                    strDatCd := '';
//
//	                    oraQryDelete.Close;
//	                    oraQryDelete.SQL.Clear;
//	                    oraQryDelete.SQL.Add(fnPayr06430_Payr418_2014_Delete);
//	                    oraQryDelete.SQL.Add(' AND  IMDE_GBCD =  :IMDE_GBCD  ');
//
//	                    oraQryDelete.ParamByName('EDAC_RVYY').AsString :=  lblEDAC_RVYY.Caption;
//	                    oraQryDelete.ParamByName('SETT_GBCD').AsString :=  lblSETT_GBCD.Caption;
//	                    oraQryDelete.ParamByName('PSNL_NUMB').AsString :=  lblPSNL_NUMB.Caption;
//	                    oraQryDelete.ParamByName('IMDE_GBCD').AsString := 'B0110090';   //	장기주식형저축
//
//	                    oraQryDelete.Execute;
//
//	                   for j := 0 to subXmlItemForm.SubItemCount -1 do
//	                   begin
//
//	                         subXmlItemMan :=  subXmlItemForm.SubItems[j];
//	                         strResid := subXmlItemMan.Params.Values['resid'];   //주민번호
//	                         for k := 0 to subXmlItemMan.SubItemCount -1 do
//	                         begin
//	                          subXmlItemData :=  subXmlItemMan.SubItems[k];
//	                          strDatCd := subXmlItemData.Params.Values['dat_cd'];
//
//	                           if strDatCd  = 'M01' then
//	                           begin
//	                             if strResid = lblRS_NUMB.Caption then
//	                             begin
//
//
//	                                //B0110090	B011	0090	장기주식형저축					41	31
//	                                edETWK_HSVM := edETWK_HSVM +   strtofloat(subXmlItemData.NamedItem['sum'].Text);
//
//
//	                                 strSql := '  INSERT INTO PAYR418          ';
//	                                 strSql := strSql + '(                          ';
//	                                 strSql := strSql + '  PSNL_NUMB,               ';
//	                                 strSql := strSql + '  SETT_GBCD,               ';
//	                                 strSql := strSql + '  EDAC_RVYY,               ';
//	                                 strSql := strSql + '  IMDE_GBCD,               ';
//	                                 strSql := strSql + '  FINA_CODE,               ';
//	                                 strSql := strSql + '  FINA_NAME,               ';
//	                                 strSql := strSql + '  ACNT_NUMB,               ';
//	                                 strSql := strSql + '  ICNM_YEAR,               ';
//	                                 strSql := strSql + '  PAYT_AMNT,               ';
//	                                 strSql := strSql + '  DEDU_AMNT,               ';
//	                                 strSql := strSql + '  INPT_USID,               ';
//	                                 strSql := strSql + '  INPT_DATE,               ';
//	                                 strSql := strSql + '  INPT_ADDR,               ';
//	                                 strSql := strSql + '  IMDE_TXCD,               ';
//	                                 strSql := strSql + '  FINA_TXCD,               ';
//	                                 strSql := strSql + '  FINA_SEQN                ';
//	                                 strSql := strSql + ')                          ';
//	                                 strSql := strSql + 'VALUES (                   ';
//	                                 strSql := strSql + '  :PSNL_NUMB,              ';
//	                                 strSql := strSql + '  :SETT_GBCD,              ';
//	                                 strSql := strSql + '  :EDAC_RVYY,              ';
//	                                 strSql := strSql + '  :IMDE_GBCD,              ';
//	                                 strSql := strSql + '  (SELECT COMM_CODE FROM CMMN010 WHERE COMM_LGCD = ''B012'' AND  COMM_IT03 = :FINA_CODE),              ';
//	                                 strSql := strSql + '  :FINA_NAME,              ';
//	                                 strSql := strSql + '  :ACNT_NUMB,              ';
//	                                 strSql := strSql + '  :ICNM_YEAR,              ';
//	                                 strSql := strSql + '  :PAYT_AMNT,              ';
//	                                 strSql := strSql + '  :DEDU_AMNT,              ';
//	                                 strSql := strSql + '  :INPT_USID,              ';
//	                                 strSql := strSql + '  SYSDATE,                 ';
//	                                 strSql := strSql + '  :INPT_ADDR,              ';
//	                                 strSql := strSql + '  :IMDE_TXCD,              ';
//	                                 strSql := strSql + '  :FINA_TXCD,              ';
//	                                  strSql := strSql + '	  (SELECT (NVL(MAX(FINA_SEQN),0) +  1) AS PSNLNUMB   ';
//	                                     strSql := strSql + '	 FROM PAYR418  AA WHERE AA.EDAC_RVYY = :EDAC_RVYY AND AA.SETT_GBCD = :SETT_GBCD AND  AA.PSNL_NUMB = :PSNL_NUMB)  ';
//	                                 strSql := strSql + ')       ';
//
//	                                oraQryInsert.Close;
//	                                oraQryInsert.SQL.Clear;
//	                                oraQryInsert.SQL.Add(strSql);
//
//
//	                                oraQryInsert.ParamByName('EDAC_RVYY').AsString :=  lblEDAC_RVYY.Caption;         //연말정산귀속년도';
//	                                oraQryInsert.ParamByName('SETT_GBCD').AsString :=   lblSETT_GBCD.Caption;   //정산구분코드';
//	                                oraQryInsert.ParamByName('PSNL_NUMB').AsString :=   lblPSNL_NUMB.Caption;   //단원번호';
//
//	                                //B0110090	B011	0090	장기주식형저축					41
//
//	                                oraQryInsert.ParamByName('IMDE_GBCD').AsString :=  'B0110090';
//	                                oraQryInsert.ParamByName('IMDE_TXCD').AsString := '41';
//
//
//	  
//	                              //  oraQryInsert.ParamByName('IMDE_GBNM').AsString := Cells[4,jRow];
//	                                oraQryInsert.ParamByName('FINA_CODE').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//	                                oraQryInsert.ParamByName('FINA_TXCD').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//	                                oraQryInsert.ParamByName('FINA_NAME').AsString := subXmlItemData.Params.Values['trade_nm'];
//	                                oraQryInsert.ParamByName('ACNT_NUMB').AsString := subXmlItemData.Params.Values['acc_no'];
//
//
//	                                subXmlItemDD :=  subXmlItemData.NamedItem['sum'];
//	                                if strtofloat(subXmlItemDD.Params.Values['sum_y1']) > 0 then
//	                                begin
//	                                  oraQryInsert.ParamByName('ICNM_YEAR').AsString := '1';
//	                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemDD.Params.Values['sum_y1'];
//	                                end
//	                                else if strtofloat(subXmlItemDD.Params.Values['sum_y2']) > 0 then
//	                                begin
//	                                  oraQryInsert.ParamByName('ICNM_YEAR').AsString := '2';
//	                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemDD.Params.Values['sum_y2'];
//	                                end
//	                                else if strtofloat(subXmlItemDD.Params.Values['sum_y3']) > 0 then
//	                                begin
//	                                  oraQryInsert.ParamByName('ICNM_YEAR').AsString := '3';
//	                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemDD.Params.Values['sum_y3'];
//	                                end ;
//	                                oraQryInsert.ParamByName('DEDU_AMNT').AsString := subXmlItemDD.Params.Values['ddct'];
//
//
//	                                oraQryInsert.ParamByName('INPT_USID').AsString := '';
//	                                oraQryInsert.ParamByName('INPT_ADDR').AsString := '';
//
//
//	                                oraQryInsert.Execute;
//
//	                             end
//	                           end
//	                         end;
//
//	                    end;
//
//	                    
//	                      oraQryUpdate.Close;
//	                      oraQryUpdate.SQL.Clear;
//
//	                      oraQryUpdate.SQL.Add('  UPDATE  PAYR415                ');
//	                      oraQryUpdate.SQL.Add('SET                              ');
//	                      oraQryUpdate.SQL.Add('  ETWK_HSVM = :ETWK_HSVM         ');
//	                      oraQryUpdate.SQL.Add('WHERE PSNL_NUMB = :PSNL_NUMB AND ');
//	                      oraQryUpdate.SQL.Add('  SETT_GBCD = :SETT_GBCD AND     ');
//	                      oraQryUpdate.SQL.Add('  EDAC_RVYY = :EDAC_RVYY   ');
//
//	                      oraQryUpdate.ParamByName('ETWK_HSVM').AsFloat :=  edETWK_HSVM;
//
//	                      oraQryUpdate.ParamByName('PSNL_NUMB').AsString := lblPSNL_NUMB.Caption;
//	                      oraQryUpdate.ParamByName('EDAC_RVYY').AsString := lblEDAC_RVYY.Caption;
//	                      oraQryUpdate.ParamByName('SETT_GBCD').AsString := lblSETT_GBCD.Caption;
//
//	                      oraQryUpdate.Execute;
//	                end;   }

//	             }
	             
	           } catch(Exception e) {
	        	  e.printStackTrace();
	              System.out.println(e.toString());
	          }
	         
	          
	             //교육비 저장 
	         InfcPkgYeta3150VO yetaPrc3150Vo =  new InfcPkgYeta3150VO(); 
                
//                yetaPrc3150Vo.setDpobCd(yeta2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//                yetaPrc3150Vo.setEdacRvyy(yeta2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
//                yetaPrc3150Vo.setSettGbcd(yeta2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
//                yetaPrc3150Vo.setSystemkey(yeta2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
				
	         yetaPrc3150Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
	         yetaPrc3150Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
	         yetaPrc3150Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
	         yetaPrc3150Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
                
                yetaPayr1200Service.fnPayr06430_PAYR445_2015_Delete(yetaPrc3150Vo);
                 
               
	         
	              for (int l= 0; l < arrPayr445.length - 1;l++) { 
	            	  
	                if (MSFSharedUtils.paramNotNull(arrPayr445[l][0])) {

 		       		   //암호화 객체 생성
 		       		    String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
 		       		
	                	InfcPkgYeta3150VO yetaPrc315001Vo =  new InfcPkgYeta3150VO(); 
		                
		                yetaPrc315001Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
		                yetaPrc315001Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
		                yetaPrc315001Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
		                yetaPrc315001Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */   
		                yetaPrc315001Vo.setEdacDtnu(BigDecimal.ZERO);    /** column 교육비가족상세일련번호 : edacDtnu */
		                
		                yetaPrc315001Vo.setFmacGbcd(arrPayr445[l][1]);    /** column 가족학력구분코드 : fmacGbcd */
		                yetaPrc315001Vo.setEdacOtam(new BigDecimal(arrPayr445[l][2]));    /** column 교육비지급금액 : edacOtam */ 

	                    String strEncValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(arrPayr445[l][0]).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
	                   		   
		                yetaPrc315001Vo.setRsnoNumb(strEncValue);
		                yetaPrc315001Vo.setGuksYeno("Y");
		                yetaPayr1200Service.fnPayr06430_PAYR445_1_2015_Insert(yetaPrc315001Vo);
		                 
		               //  oraQryInsert.ParamByName('FMAC_GBCD').AsString := arrPayr445[l][2];
		               //  oraQryInsert.ParamByName('EDAC_OTAM').AsString := arrPayr445[l][3];
		               //  oraQryInsert.ParamByName('RSNO_NUMB').AsString := arrPayr445[l][1];
	                }
	              }
	               
	              

	              for (int l= 0; l < arrPayr445.length;l++) { 
	            	  if (MSFSharedUtils.paramNotNull(arrPayr445[l][0])) {
		                 //특수  교육비
		                 edSpciScam  = edSpciScam.add(new BigDecimal(arrPayr445[l][3]));
	            	  }
	              }
	              //   edSpciScam = edSpciScam.add(new BigDecimal(arrPayr445[9][3]));

	              for (int l= 0; l < arrPayr445.length;l++) { 
	            	  if (MSFSharedUtils.paramNotNull(arrPayr445[l][0])) { 
		                 if  (MSFSharedUtils.allowNulls(arrPayr445[l][1]).equals("Y0030010")) {
		              
		                       edSpedEdam  = edSpedEdam.add(new BigDecimal(arrPayr445[l][2]));
		                 }
		                 else if (MSFSharedUtils.allowNulls(arrPayr445[l][1]).equals("Y0030020")) {
		               
		                       edSpedGdam  = edSpedGdam.add(new BigDecimal(arrPayr445[l][2]));
		                 }
		                  else if (MSFSharedUtils.allowNulls(arrPayr445[l][1]).equals("Y0030030")) {
		                
		                        edSpedCvam  = edSpedCvam.add(new BigDecimal(arrPayr445[l][2]));
		                  }
	            	  }
	              }

//	             oraQryUpdate.ParamByName('SPED_SELF').AsFloat := edSpedSelf;
//	             oraQryUpdate.ParamByName('SPED_EDAM').AsFloat := edSpedEdam;
//	             oraQryUpdate.ParamByName('SPED_GDAM').AsFloat := edSpedGdam;
//	             oraQryUpdate.ParamByName('SPED_CVAM').AsFloat := edSpedCvam;
//	             oraQryUpdate.ParamByName('SPCI_SCAM').AsFloat := edSpciScam; 
	           
	              yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
	              yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
	              yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
	              yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
	                   
	              
	             yeta2000Vo.setSpedSelf(edSpedSelf); // 특별공제_교육비_본인
	             yeta2000Vo.setSpedEdam(edSpedEdam); // 특별공제_교육비_취학전아동
	             yeta2000Vo.setSpedGdam(edSpedGdam); // 특별공제_교육비_초중
	             yeta2000Vo.setSpedCvam(edSpedCvam); // 특별공제_교육비_대학교
	             yeta2000Vo.setSpciScam(edSpciScam); // 특별공제_장애인특수교육비

                 
                 yetaPayr1200Service.fnPayr06425_PAYR415_2016_11_Update(yeta2000Vo);
                 
	              
	              
	              //이전년도 및 해당년도 사용분 및  본인추가 공제 사용액 _신용카드 저장

//	              oraQryUpdate.ParamByName('CARD_ET13').AsFloat :=  edCARD_ET13;
//	              oraQryUpdate.ParamByName('CARD_ET14').AsFloat :=  edCARD_ET14;
//	              oraQryUpdate.ParamByName('ETAD_DD13').AsFloat :=  edETAD_DD13;
//	              oraQryUpdate.ParamByName('ETAD_D14L').AsFloat :=  edETAD_D14L;
//	              
//	              oraQryUpdate.ParamByName('CARD_ET15').AsFloat :=  edCARD_ET15;  //기타공제_본인신용카등사용액_2015	None	
//	              oraQryUpdate.ParamByName('ETAD_D15H').AsFloat :=  edETAD_D15H; //기타공제_본인추가공제율사용액2015상반기	None	
//	              oraQryUpdate.ParamByName('ETAD_D15L').AsFloat :=  edETAD_D15L; //기타공제_본인추가공제율사용액2015하반기	None
	             
//	              yeta2000Vo.setCardEt13(edCARD_ET13); //본인 신용카드 사용액 2013
	              yeta2000Vo.setCardEt14(edCARD_ET14); //본인 신용카드 사용액 2014
	              yeta2000Vo.setCardEt15(edCARD_ET15); //본인 신용카드 사용액 2015
	              
//	              yeta2000Vo.setEtadDd13(edETAD_DD13); //본인 추가공제율 사용액 2013
	              yeta2000Vo.setEtadD14l(edETAD_D14L); //본인 추가공제율 사용액 2014 
//	              yeta2000Vo.setEtadD15h(edETAD_D15H); //본인 추가공제율 사용액 2015 하반기
//	              yeta2000Vo.setEtadD15l(edETAD_D15L); //본인 추가공제율 사용액 2015 상반기
	              yeta2000Vo.setEtadD16l(edETAD_D16L); //본인 추가공제율 사용액 2016 상반기
	                 
	              yetaPayr1200Service.fnPayr06425_PAYR415_2016_12_Update(yeta2000Vo);

	               //-----------------
	               // 전통시장 비용 업데이트 

	           //   oraQryUpdate.ParamByName('ETCH_MGVD').AsFloat :=  edETCH_MGVD;

	              yeta2000Vo.setEtchMgvd(edETCH_MGVD); 
	              yetaPayr1200Service.fnPayr06425_PAYR415_2016_13_Update(yeta2000Vo);
	              
	               //대중교통 업데이트
	         
	             // oraQryUpdate.ParamByName('ETCH_BCED').AsFloat :=  edETCH_BCED;

	              yeta2000Vo.setEtchBced(edETCH_BCED); 
	              yetaPayr1200Service.fnPayr06425_PAYR415_2016_14_Update(yeta2000Vo);

	              //--------------------------------

	               // Payr410 업데이트 작업 ....
	               
	              InfcPkgYeta3220SrhVO yetaPrc3220SrhVo = new InfcPkgYeta3220SrhVO(); 
	              
	               
	               yetaPrc3220SrhVo.setDpobCd(yeta2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
	               yetaPrc3220SrhVo.setEdacRvyy(yeta2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
	               yetaPrc3220SrhVo.setSettGbcd(yeta2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
	               yetaPrc3220SrhVo.setSystemkey(yeta2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */  
	                
	               yetaPrc3220SrhVo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
	               yetaPrc3220SrhVo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
	               yetaPrc3220SrhVo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
	               yetaPrc3220SrhVo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
	                  
	  	         
	               List lisYetaPrc3220Vo = yetaPayr1200Service.fnPayr06430_PAYR410_2015_SelectAll(yetaPrc3220SrhVo);

	                
	               if  (lisYetaPrc3220Vo.size() > 0) {

                	   Iterator<Map<String, Object>> iter = lisYetaPrc3220Vo.iterator(); 
    	        	   
    		            while ( iter.hasNext() ) { 
    		            	
    		               Map<String, Object> mapYeta3220 = (Map<String, Object>) iter.next(); 
                          // for(int iCnt = 0; iCnt < listYetaGibu.size();iCnt++) {   
	                 
    		       		   //암호화 객체 생성
    		       		    String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    		       		

    		             	String str3220EncValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(mapYeta3220.get("rsnoNumb")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
    		           		   
    		             	String strEncValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
    		           		   
    		               InfcPkgYeta3220VO yetaPrc3220Vo = new InfcPkgYeta3220VO(); 
	                  

							yetaPrc3220Vo.setDpobCd(yeta2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
							yetaPrc3220Vo.setEdacRvyy(yeta2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
							yetaPrc3220Vo.setSettGbcd(yeta2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
							yetaPrc3220Vo.setSystemkey(yeta2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
						
							yetaPrc3220Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
							yetaPrc3220Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
							yetaPrc3220Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
							yetaPrc3220Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
							 
							//yetaPrc3220Vo.setRelhCode(yeta3220Dto.getRelhCode());    /** column 관계 : relhCode */
							//yetaPrc3220Vo.setKornName(yeta3220Dto.getKornName());    /** column 성명 : kornName */
							//yetaPrc3220Vo.setFrnrCode(yeta3220Dto.getFrnrCode());    /** column 내외국인구분코드 : frnrCode */
							//yetaPrc3220Vo.setBaseDdyn(yeta3220Dto.getBaseDdyn());    /** column 기본공제여부 : baseDdyn */
							//yetaPrc3220Vo.setPsclDdyn(yeta3220Dto.getPsclDdyn());    /** column 장애인공제여부 : psclDdyn */
							//yetaPrc3220Vo.setBrddCtyn(yeta3220Dto.getBrddCtyn());    /** column 자녀양육비공제여부 : brddCtyn */
							//yetaPrc3220Vo.setFaddCtyn(yeta3220Dto.getFaddCtyn());    /** column 부녀자공제여부 : faddCtyn */
							//yetaPrc3220Vo.setRpctDdyn(yeta3220Dto.getRpctDdyn());    /** column 경로우대공제여부 : rpctDdyn */
							//yetaPrc3220Vo.setBithDdyn(yeta3220Dto.getBithDdyn());    /** column 출산입양자공제여부 : bithDdyn */
							//yetaPrc3220Vo.setPantOnyn(yeta3220Dto.getPantOnyn());    /** column 한부모공제여부 : pantOnyn */
							
							 
	                     // oraQryUpdate.ParamByName('INSU_PAYR').AsString  :=  '0';   //건강.고용보험료_국세청';
//	                      oraQryUpdate.ParamByName('INSU_RTYR').AsString  :=  '0';   //보장성보험료_국세청';
//	                      oraQryUpdate.ParamByName('MEDI_COST').AsString  :=  '0';    //의료비_국세청';
//	                      oraQryUpdate.ParamByName('EDUC_COST').AsString  :=  '0';     //교육비_국세청';
//	                      oraQryUpdate.ParamByName('CDTE_CARD').AsString  :=  '0';    //신용카드등_국세청';
//	                      oraQryUpdate.ParamByName('JIBL_CARD').AsString  :=  '0';    //직불카드등_국세청';
//	                      oraQryUpdate.ParamByName('CASH_RECE').AsString  :=  '0';     //현금영수증_국세청';
//	                      oraQryUpdate.ParamByName('GRPY_AMNT').AsString  :=  '0';    //지로납부_국세청 - 대중교통 변경 ';
//	                      oraQryUpdate.ParamByName('MGNT_STVD').AsString  :=  '0';   //전통시장_국세청';
//	                      oraQryUpdate.ParamByName('CTRB_AMNT').AsString  :=   '0';    //기부금액_국세청';

						//yetaPrc3220Vo.setInsuPayr(BigDecimal.ZERO);             //건강.고용보험료_국세청';
						yetaPrc3220Vo.setInsuRtyr(BigDecimal.ZERO);             //보장성보험료_국세청';
						yetaPrc3220Vo.setPsclIurr(BigDecimal.ZERO);             //장애인보장성보험료_국세청';
						yetaPrc3220Vo.setMediCost(BigDecimal.ZERO);              //의료비_국세청';
						yetaPrc3220Vo.setEducCost(BigDecimal.ZERO);               //교육비_국세청';
						yetaPrc3220Vo.setCdteCard(BigDecimal.ZERO);              //신용카드등_국세청';
						yetaPrc3220Vo.setJiblCard(BigDecimal.ZERO);              //직불카드등_국세청';
						yetaPrc3220Vo.setCashRece(BigDecimal.ZERO);               //현금영수증_국세청';
						yetaPrc3220Vo.setGrpyAmnt(BigDecimal.ZERO);              //지로납부_국세청 - 대중교통 변경 ';
						yetaPrc3220Vo.setMgntStvd(BigDecimal.ZERO);             //전통시장_국세청';
						yetaPrc3220Vo.setCtrbAmnt(BigDecimal.ZERO);               //기부금액_국세청';
							
	                      edCARD_MONI = BigDecimal.ZERO;
	                      edCARD_BCED = BigDecimal.ZERO;
	                  
	                   for (int ddCnt01 = 0; ddCnt01 < 10; ddCnt01++) { 
	                	   
	                	   if (MSFSharedUtils.paramNotNull(arrHDRC_PAY[ddCnt01][0])) {
	                			 
		                      if  (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrHDRC_PAY[ddCnt01][0])) { 
		                    		 
		                    	  yetaPrc3220Vo.setInsuRtyr(new BigDecimal(arrHDRC_PAY[ddCnt01][1]));    /** column 보장성보험료_국세청 : insuRtyr */
		                          // oraQryUpdate.ParamByName('INSU_RTYR').AsString  :=  floattostr(strtofloat(arrHDRC_PAY[ddCnt01][1]) + strtofloat(arrHDRC_PAY[ddCnt01][2]));    //보험료_국세청';
		                      }
	                	   }  
	                	   if (MSFSharedUtils.paramNotNull(arrHDRC_PAY[ddCnt01][0])) {
	                			 
			                      if  (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrHDRC_PAY[ddCnt01][0])) { 
			                    	  
			                    	  yetaPrc3220Vo.setPsclIurr(new BigDecimal(arrHDRC_PAY[ddCnt01][2]));    /** column 장애인보장성보험료_국세청 : psclIurr */
			                          // oraQryUpdate.ParamByName('INSU_RTYR').AsString  :=  floattostr(strtofloat(arrHDRC_PAY[ddCnt01][1]) + strtofloat(arrHDRC_PAY[ddCnt01][2]));    //보험료_국세청';
			                      }
		                	   } 
	                	   if (MSFSharedUtils.paramNotNull(arrCASH_PAY[ddCnt01][0])) {  
		                      if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrCASH_PAY[ddCnt01][0])) { 
		                   
		                    	    yetaPrc3220Vo.setMediCost(new BigDecimal(arrCASH_PAY[ddCnt01][1]));    /** column 의료비_국세청 : mediCost */
		                            //oraQryUpdate.ParamByName('MEDI_COST').AsString  :=  arrCASH_PAY[ddCnt01][1] ;    //의료비_국세청';
	
		                      }
	                	   }
	                	   if(MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(strEncValue)){
            				   
            				   yetaPrc3220Vo.setEducCost(edSpedSelf);    /** column 교육비_국세청 : educCost */  
            			   
            			   }else{
            			  
		                	   if (MSFSharedUtils.paramNotNull(arrPayr445[ddCnt01][0])) {
		                		   
		                		   if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrPayr445[ddCnt01][0])) {
		                			  
		                		          if (strEncValue.equals(arrPayr445[ddCnt01][0])) {
		                		        	
		                		        	 yetaPrc3220Vo.setEducCost(edSpedSelf.add(new BigDecimal(arrPayr445[9][3])));    /** column 교육비_국세청 : educCost */  
				                        	 // oraQryUpdate.ParamByName('EDUC_COST').AsString  :=  floattostr( edSpedSelf + strtofloat(arrPayr445[9][3]));     //교육비_국세청';
				                        	 
				                          }
				                          else
				                          {
				                        	  if(MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(strEncValue)){
				                				   
				                				   yetaPrc3220Vo.setEducCost(edSpedSelf);    /** column 교육비_국세청 : educCost */  
				                			   
				                			   }else{
				                				   
				                				   yetaPrc3220Vo.setEducCost((new BigDecimal(arrPayr445[ddCnt01][2])).add(new BigDecimal(arrPayr445[ddCnt01][3])));    /** column 교육비_국세청 : educCost */
				                			   }
				                            // oraQryUpdate.ParamByName('EDUC_COST').AsString  :=   floattostr(strtofloat(arrPayr445[ddCnt01][2]) + strtofloat(arrPayr445[ddCnt01][3]));     //교육비_국세청';
				                          }
		                		   }
			
		                	   } 
            			   }
	                      //일반
	                	   if (MSFSharedUtils.paramNotNull(arrCARD_PAY[ddCnt01][0])) {   
	                		 
		                      if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrCARD_PAY[ddCnt01][0])) { 
		                    		 
		                    	   yetaPrc3220Vo.setCdteCard(new BigDecimal(arrCARD_PAY[ddCnt01][1]));    /** column 신용카드등_국세청 : cdteCard */
		                           // oraQryUpdate.ParamByName('CDTE_CARD').AsString  :=  arrCARD_PAY[ddCnt01][1] ;    //신용카드등_국세청';
	
		                      }
	                	   }   
	                	   
	                	   if (MSFSharedUtils.paramNotNull(arrBCBS_PAY[ddCnt01][0])) {  
		                       if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrBCBS_PAY[ddCnt01][0])) { 
		                      
		                    	     yetaPrc3220Vo.setJiblCard(new BigDecimal(arrBCBS_PAY[ddCnt01][1]));    /** column 직불카드등_국세청 : jiblCard */
		                            // oraQryUpdate.ParamByName('JIBL_CARD').AsString  :=  arrBCBS_PAY[ddCnt01][1] ;   //직불카드등_국세청';
	
		                       }
	                	   } 
	                	   if (MSFSharedUtils.paramNotNull(arrMONI_PAY[ddCnt01][0])) {  
		                       if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrMONI_PAY[ddCnt01][0]) ){ 
		                    
		                    	   yetaPrc3220Vo.setCashRece(new BigDecimal(arrMONI_PAY[ddCnt01][1]));    /** column 현금영수증_국세청 : cashRece */
		                          // oraQryUpdate.ParamByName('CASH_RECE').AsString  :=  arrMONI_PAY[ddCnt01][1] ;    //현금영수증_국세청';
	
		                       }
	                	   }   
	                	   if (MSFSharedUtils.paramNotNull(arrCARD_PAY[ddCnt01][0])) {   
		                      //전통시장
		                       if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrCARD_PAY[ddCnt01][0])) { 
		                     
		                             edCARD_MONI =  edCARD_MONI.add(new BigDecimal(arrCARD_PAY[ddCnt01][2]));
		                            		 // + strtofloat(arrCARD_PAY[ddCnt01][2]);
	
		                       }
	                	   }   
	                	   if (MSFSharedUtils.paramNotNull(arrMONI_PAY[ddCnt01][0])) {    
		                      if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrMONI_PAY[ddCnt01][0])) { 
		                  
		                             edCARD_MONI =  edCARD_MONI.add(new BigDecimal(arrMONI_PAY[ddCnt01][2]));  // + strtofloat(arrMONI_PAY[ddCnt01][2]);
	
		                      }
	                	   }   
	                	   if (MSFSharedUtils.paramNotNull(arrBCBS_PAY[ddCnt01][0])) {    
		                      if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrBCBS_PAY[ddCnt01][0])) { 
		                     
	
		                             edCARD_MONI =  edCARD_MONI.add(new BigDecimal(arrBCBS_PAY[ddCnt01][2])); // + strtofloat(arrBCBS_PAY[ddCnt01][2]);
	
		                      }
	                	   }   
	                      //대중교통
	                	   if (MSFSharedUtils.paramNotNull(arrCARD_PAY[ddCnt01][0])) {    
		                      if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrCARD_PAY[ddCnt01][0])) { 
		                      
		                             edCARD_BCED =  edCARD_BCED.add(new BigDecimal(arrCARD_PAY[ddCnt01][3]));  // + strtofloat(arrCARD_PAY[ddCnt01][3]);
	
		                      }
	                	   } 
	                	   if (MSFSharedUtils.paramNotNull(arrMONI_PAY[ddCnt01][0])) {   
		                      if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrMONI_PAY[ddCnt01][0])) { 
		                     
	
		                             edCARD_BCED =  edCARD_BCED.add(new BigDecimal(arrMONI_PAY[ddCnt01][3]));   // + strtofloat(arrMONI_PAY[ddCnt01][3]);
	
		                      }
	                	   }   
	                	   if (MSFSharedUtils.paramNotNull(arrBCBS_PAY[ddCnt01][0])) {    
		                      if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrBCBS_PAY[ddCnt01][0])) { 
		                     
	
		                             edCARD_BCED =  edCARD_BCED.add(new BigDecimal(arrBCBS_PAY[ddCnt01][3]));   // + strtofloat(arrBCBS_PAY[ddCnt01][3]);
	
		                      }
	                	   }
	                	   if (MSFSharedUtils.paramNotNull(arrSPCI_PAY[ddCnt01][0])) {   
	                		 
		                       if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrSPCI_PAY[ddCnt01][0])) { 
		                    	  
		                    	   yetaPrc3220Vo.setCtrbAmnt(new BigDecimal(arrSPCI_PAY[ddCnt01][1]));    /** column 기부금액_국세청 : ctrbAmnt */ 
		                             //oraQryUpdate.ParamByName('CTRB_AMNT').AsString  :=   arrSPCI_PAY[ddCnt01][1] ;    //기부금액_국세청';
		                       }
	                	   }
	                   }
	                   
	                   yetaPrc3220Vo.setMgntStvd(edCARD_MONI);    /** column 전통시장사용분_국세청 : mgntStvd */
	                   yetaPrc3220Vo.setGrpyAmnt(edCARD_BCED);    /** column 지로납부액_대중교통_국세청 : grpyAmnt */
	                 //  oraQryUpdate.ParamByName('MGNT_STVD').AsString  :=  floattostr( edCARD_MONI);    //전통시장_국세청';
	                 //  oraQryUpdate.ParamByName('GRPY_AMNT').AsString  :=  floattostr( edCARD_BCED);    //대중교통_국세청';

//	               	yetaPrc3220Vo.setInsuRtyr(yeta3220Dto.getInsuRtyr());    /** column 보험료보장성_국세청 : insuRtyr */
//					yetaPrc3220Vo.setPsclIurr(yeta3220Dto.getPsclIurr());    /** column 보험료장애인보장성_국세청 : psclIurr */ 
//					yetaPrc3220Vo.setInsuFetc(yeta3220Dto.getInsuFetc());    /** column 보험료_건강고용등외 : insuFetc */
//					yetaPrc3220Vo.setInsuRtet(yeta3220Dto.getInsuRtet());    /** column 보험료보장성외 : insuRtet */
//					yetaPrc3220Vo.setPsclIurt(yeta3220Dto.getPsclIurt());    /** column 보험료장애인보장성외 : psclIurt */
//					yetaPrc3220Vo.setMediExps(yeta3220Dto.getMediExps());    /** column 의료비외 : mediExps */
//					yetaPrc3220Vo.setEducOtec(yeta3220Dto.getEducOtec());    /** column 교육비외 : educOtec */
//					yetaPrc3220Vo.setCdteCdec(yeta3220Dto.getCdteCdec());    /** column 신용카드외 : cdteCdec */
//					yetaPrc3220Vo.setJiblCdec(yeta3220Dto.getJiblCdec());    /** column 직불카드외 : jiblCdec */
//					yetaPrc3220Vo.setGrpyAtec(yeta3220Dto.getGrpyAtec());    /** column 지로납부액_대중교통외 : grpyAtec */
//					yetaPrc3220Vo.setMgntSdec(yeta3220Dto.getMgntSdec());    /** column 전통시장사용분외 : mgntSdec */
//					yetaPrc3220Vo.setCtrbAmec(yeta3220Dto.getCtrbAmec());    /** column 기부금액외 : ctrbAmec */

					
	                 yetaPrc3220Vo.setRsnoNumb(MSFSharedUtils.defaultNulls(mapYeta3220.get("rsnoNumb"),""));    /** column 주민등록번호 : rsnoNumb */
//	                   oraQryUpdate.ParamByName('RSNO_NUMB').AsString := oraQrySelect03.FieldByName('RSNO_NUMB').AsString;
//						yetaPrc3220Vo.setKybdr(yeta3220Dto.getKybdr());    /** column 입력자 : kybdr */
//						yetaPrc3220Vo.setInptDt(yeta3220Dto.getInptDt());    /** column 입력일자 : inptDt */
//						yetaPrc3220Vo.setInptAddr(yeta3220Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//						yetaPrc3220Vo.setIsmt(yeta3220Dto.getIsmt());    /** column 수정자 : ismt */
//						yetaPrc3220Vo.setRevnDt(yeta3220Dto.getRevnDt());    /** column 수정일자 : revnDt */
//						yetaPrc3220Vo.setRevnAddr(yeta3220Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
	                   
	                 yetaPayr1200Service.fnPayr06430_PAYR410_2016_01_Update(yetaPrc3220Vo);
	                   
	                 }
    		    } 
	          
		        // TODO 정산 전자문서 업데이트 쿼리 
		        yetaPayr1200Service.fnPayr06425_PAYR415_0_2015_Update(yeta2000Vo);

	      } catch(Exception e) {
	    	  e.printStackTrace();
             System.out.println(e.toString());
         }
	     
	      
	      // showMessage('PDF 전자문서 저장이 완료 되었습니다.');
   }
    
   
	 
 private void PayrXmlDataUpdate(InfcPkgYeta2000VO yeta2000Vo, Document xmlDoc, Map commandMap) {
	  
	   List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	  // int i,j,k,l  = 0;
	   boolean boolLogin = false ;
	   String FileName = "";
	   
	   
	   Node xmlItemDoc = null;
	   Element  xmlItemMain  = null;
	   Element  xmlelDoc  = null;
	 
	   NodeList xmlItemForm = null;
	   
	   Node subXmlItemForm = null;
	   Element  subXmlElForm = null; 
	   NodeList subXmlElChildForm = null;
	   
	   Node subXmlItemMan = null;
	   Element subXmlElMan = null;
	   NodeList subXmlElChildMan = null;
	   NodeList subXmlElChildSum = null;
	   
	   Node subXmlItemData = null;
	   Node subXmlItemSum = null;
	   Element subXmlElData = null;
	   Element subXmlElSum = null;
	   
	   NodeList subXmlItemDD = null;
	   
	   String dataType = "";
	   String dataPrDate  = "";
	   String dataYear = "";
	   String dataFrmMm = "";
	   String dataToMm = "";
	   String dataInqrMm = "";
	   
	   String  strFormCd  = "";
	   String strDatCd = "";
	   String strSum = "";
	   
	   
	   //TODO 건강보험료 및 국민연금보험료 변수 
	   String strHiYrs = ""; //건강보험연말정산금액
	   String strItrmYrs = ""; //장기요양연말정산금액
	   String strHiNtf = ""; //건강보험(보수월액)고지금액합계
	   String strItrmNtf = ""; //장기요양(보수월액)고지금액합계
	   String strHiPmt = ""; //건강보험(소득월액)납부금액합계
	   String strItrmPmt = ""; //장기요양(소득월액)납부금액합계
	   
	   String strNtf = ""; //직장가입자 고지금액 합계_국민연금
	   String strPmt = ""; //지역가입자 등 납부금액 합계_국민연금
	   
	   BigDecimal edSpciGurtSum = BigDecimal.ZERO; // 보장성 보험료 총 합계 금액 
	   BigDecimal  edSpciHdrcSum = BigDecimal.ZERO; // 장애인전용보장성보험료 총 합계 금액
	   
	   BigDecimal edSpciGurtSum01 = BigDecimal.ZERO; // 보장성 보험료 총 합계 금액(본인 외)
	   BigDecimal  edSpciHdrcSum01 = BigDecimal.ZERO; // 장애인전용보장성보험료 총 합계 금액(본인 외)
	   
	   BigDecimal edSpciGurtSum02 = BigDecimal.ZERO; // 보장성 보험료 총 합계 금액(본인 외)
	   BigDecimal  edSpciHdrcSum02 = BigDecimal.ZERO; // 장애인전용보장성보험료 총 합계 금액(본인 외)
	   
	   
	   int ddCnt = 0; 
	   BigDecimal ddCnt1 = BigDecimal.ZERO;
	   String schBrith = "";
	   String strBusnid = ""; 
	   String strResid = "";
	   BigDecimal exCASH_UEAM = BigDecimal.ZERO;
	   BigDecimal edSpedSelf = BigDecimal.ZERO;
	   BigDecimal  edSpciScam  = BigDecimal.ZERO;
	   String strEduTp = "";
	   String[][] arrPayr445 = new String[10][4];
	   
	   BigDecimal edEDAC_OTAM01 = BigDecimal.ZERO;
	   BigDecimal edEDAC_OTAM02 = BigDecimal.ZERO;
	   BigDecimal edEDAC_OTAM03 = BigDecimal.ZERO; 
	    
	   BigDecimal edSpedEdam  = BigDecimal.ZERO;
	   BigDecimal edSpedGdam  = BigDecimal.ZERO;
	   BigDecimal edSpedCvam = BigDecimal.ZERO;
	   BigDecimal edPrvm20be  = BigDecimal.ZERO;
       
	   String strSql = "";
	   BigDecimal edPrvm21af   = BigDecimal.ZERO;
	   BigDecimal edJrtrPsct  = BigDecimal.ZERO;
	   BigDecimal edJRTR_CICT  = BigDecimal.ZERO;
	   BigDecimal edTemp      = BigDecimal.ZERO;
	   BigDecimal edETCT_CARD  = BigDecimal.ZERO;
	   BigDecimal edETCH_MGVD = BigDecimal.ZERO;
	   BigDecimal edETCH_UEAM = BigDecimal.ZERO;
	   BigDecimal edETCH_BCBS = BigDecimal.ZERO;
	   BigDecimal edETCH_BCED  = BigDecimal.ZERO; 
	   BigDecimal edSpciRefn  = BigDecimal.ZERO;
	   BigDecimal edSpchRe06  = BigDecimal.ZERO;
	   BigDecimal edSpchRe10 = BigDecimal.ZERO;
	   BigDecimal edSpchRe15 = BigDecimal.ZERO;
	   BigDecimal edSPCH_REFX = BigDecimal.ZERO; 
	   BigDecimal edSPCH_REEC  = BigDecimal.ZERO; 
	   BigDecimal edETCS_COMP = BigDecimal.ZERO; 
	   BigDecimal edETWK_HSBM = BigDecimal.ZERO;
	   BigDecimal edMonyItre  = BigDecimal.ZERO;
	   BigDecimal edEtchPrep  = BigDecimal.ZERO;
	   BigDecimal edSpciHhLh  = BigDecimal.ZERO;
	   BigDecimal edJnatPsnf  = BigDecimal.ZERO;
	   BigDecimal edEtchPrepStartDt = BigDecimal.ZERO;
	   BigDecimal edEtchPrepEndDt = BigDecimal.ZERO;
	   BigDecimal edCARD_MONI = BigDecimal.ZERO; 
	   BigDecimal edCARD_BCED  = BigDecimal.ZERO;
       
	   BigDecimal edSPCH_15FX = BigDecimal.ZERO;
	   BigDecimal edSPCH_15FB = BigDecimal.ZERO;
	   BigDecimal edSPCH_15EC = BigDecimal.ZERO;
	   BigDecimal edSPCH_10FB = BigDecimal.ZERO;
       
	   int ldCnt = 0;
	   
	   BigDecimal edCARD_ET13 = BigDecimal.ZERO;
	   BigDecimal edCARD_ET14  = BigDecimal.ZERO;
	   BigDecimal edETAD_DD13  = BigDecimal.ZERO;
	   BigDecimal edETAD_D14L = BigDecimal.ZERO;
	   
	   BigDecimal edCARD_ET15 = BigDecimal.ZERO;
	   BigDecimal edETAD_D15H = BigDecimal.ZERO;
	   BigDecimal edETAD_D15L = BigDecimal.ZERO;
	   
	   BigDecimal edETAD_D16L = BigDecimal.ZERO; //신용카드 2016년도 상반기 본인 추가공제율
	   
	   BigDecimal edSpciFbam = BigDecimal.ZERO;
	   BigDecimal edSpciPltc = BigDecimal.ZERO;
	   BigDecimal edSpciExam = BigDecimal.ZERO;
	   BigDecimal edSpciUnon = BigDecimal.ZERO;
	   BigDecimal edSpciNamt = BigDecimal.ZERO;
	   BigDecimal edSpciYamt = BigDecimal.ZERO;
	   BigDecimal edSPCI_HFAM = BigDecimal.ZERO;
	 
	   BigDecimal edETWK_HSVM  = BigDecimal.ZERO;
	   BigDecimal edETEP_SEST   = BigDecimal.ZERO;
	   String[][] arrCARD_PAY = new String[10][4];  
	   String[][] arrMONI_PAY = new String[10][4]; 
	   String[][] arrBCBS_PAY = new String[10][4];  
	   String[][] arrSPCI_PAY = new String[10][4];  
	   String[][] arrHDRC_PAY = new String[10][4];  
	   String[][] arrCASH_PAY = new String[10][4];  

	 

	       edSpedSelf = BigDecimal.ZERO;
	       edSpciScam  = BigDecimal.ZERO;
	       edEDAC_OTAM01 = BigDecimal.ZERO;
	       edEDAC_OTAM02  = BigDecimal.ZERO;
	       edEDAC_OTAM03  = BigDecimal.ZERO;
	       edETEP_SEST  = BigDecimal.ZERO;
	      // edETWK_HSVM  = BigDecimal.ZERO;
	       edPrvm21af  = BigDecimal.ZERO;
	       edJrtrPsct  = BigDecimal.ZERO;
	       edJRTR_CICT  = BigDecimal.ZERO;
	       edTemp  = BigDecimal.ZERO;
	       edETCT_CARD  = BigDecimal.ZERO;
	       edETCH_MGVD   = BigDecimal.ZERO;
	       edETCH_BCED  = BigDecimal.ZERO;  //대중교통
	       edETCH_UEAM   = BigDecimal.ZERO;
	       edETCH_BCBS  = BigDecimal.ZERO;
	       edSpciRefn   = BigDecimal.ZERO;

	       edCARD_ET13  = BigDecimal.ZERO;
	       edCARD_ET14  = BigDecimal.ZERO;
	       edETAD_DD13  = BigDecimal.ZERO;
	       edETAD_D14L  = BigDecimal.ZERO;

	       edSpchRe06   = BigDecimal.ZERO;
	       edSpchRe10   = BigDecimal.ZERO;
	       edSpchRe15    = BigDecimal.ZERO;
	       edSPCH_REFX   = BigDecimal.ZERO;
	       edSPCH_REEC   = BigDecimal.ZERO;
	       
	       edSPCH_15FX = BigDecimal.ZERO;
           edSPCH_15FB = BigDecimal.ZERO;
           edSPCH_15EC = BigDecimal.ZERO;
           edSPCH_10FB = BigDecimal.ZERO;

	       edETCS_COMP   = BigDecimal.ZERO;
	       edETWK_HSBM  = BigDecimal.ZERO;
	       edETWK_HSVM  = BigDecimal.ZERO;
	       edMonyItre   = BigDecimal.ZERO; //목돈안드는이자상환금액
	       edEtchPrep  = BigDecimal.ZERO;
	       ldCnt     = 0;

	       edSpciFbam  = BigDecimal.ZERO;
	       edSpciPltc  = BigDecimal.ZERO;
	       edSpciExam   = BigDecimal.ZERO;
	       edSpciUnon   = BigDecimal.ZERO;
	       edSpciNamt   = BigDecimal.ZERO;
	       edSpciYamt   = BigDecimal.ZERO;
	       edSPCI_HFAM   = BigDecimal.ZERO;
	       edCARD_MONI  = BigDecimal.ZERO;
	       edCARD_BCED  = BigDecimal.ZERO;

           //2016 주민번호 암호화에 따른 복호화 처리 루틴 
	        String rrnDecCrypt = "";
	        String tmpRrnDecCrypt = "";
	        for (int m = 0; m < 10 ;m++) { 
	          arrPayr445[m][2] = "0"; 
	          arrPayr445[m][3] = "0"; 
	          arrCARD_PAY[m][1] = "0"; 
	          arrCARD_PAY[m][2] = "0"; 
	          arrCARD_PAY[m][3] = "0"; 
	          arrMONI_PAY[m][1] = "0"; 
	          arrMONI_PAY[m][2] = "0"; 
	          arrMONI_PAY[m][3] = "0"; 
	          arrBCBS_PAY[m][1] = "0"; 
	          arrBCBS_PAY[m][2] = "0"; 
	          arrBCBS_PAY[m][3] = "0"; 
	          arrHDRC_PAY[m][1] = "0"; 
	          arrHDRC_PAY[m][2] = "0"; 
	          arrSPCI_PAY[m][3] = "0"; 
	          arrSPCI_PAY[m][1] = "0"; 
	          arrSPCI_PAY[m][2] = "0"; 
	          arrCASH_PAY[m][1] = "0"; 
	          arrCASH_PAY[m][2] = "0"; 
	        }
	    
	     try {
	         try {
	        	 


		          // FileName := 'C:\EOSDATA\2015\' + trim(lblFILE_SAVE.Caption) + '_' + trim(edKORN_NAME.Text); // + '.xml';
		          // Memo_XML_EUC_KR.Lines.Clear;
		         //  Memo_XML_EUC_KR.Lines.LoadFromFile(ChangeFileExt(FileName, '.xml'));
		         //  CONNXML.LoadFromFile(ChangeFileExt(FileName, '.xml'));
		          // CONNXML.Root.AsString := Memo_XML_EUC_KR.Lines.Text;
		          // ecxmlPdf.LoadFromFile(FileName);
		            xmlItemMain = xmlDoc.getDocumentElement();
		     
		            xmlItemDoc = xmlItemMain.getElementsByTagName("doc").item(0); 
		            xmlelDoc = (Element)xmlItemDoc;	 
		        
		            dataType = PkgFuncUtils.getXmlTagValue("doc_type", xmlelDoc);    //문서종류   
		            dataPrDate =  PkgFuncUtils.getXmlTagValue("seq", xmlelDoc); //일련번호 
		            dataYear = PkgFuncUtils.getXmlTagValue("att_year", xmlelDoc);   //귀속년도 
		            dataFrmMm = PkgFuncUtils.getXmlTagValue("att_FrmMm", xmlelDoc);   //시작월
		            dataToMm = PkgFuncUtils.getXmlTagValue("att_ToMm", xmlelDoc);   //종료월
		            dataInqrMm = PkgFuncUtils.getXmlTagValue("att_inqrMm", xmlelDoc);   //월 기간

		           if (!dataYear.equals("2016")) {
//		              bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Yeta","[연말정산]에러","PDF 전자문서이상","연말정산 귀속년도가 상이합니다. 확인하십시요." )); 
		              //에러처리 
		        		 throw new Exception();  
		           }
		         
		            xmlItemForm =  xmlItemMain.getElementsByTagName("form");    
		           //FORM
		             for(int i=0;i < xmlItemForm.getLength();i++) { 
		         
	                    /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
			    	    // 1. 암호화 객체 생성
			    	     String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			    			
			    	     /********************************************************암호화 처리 를 위해 반드시 해야 함................................*/   
			    	    	
		            	 subXmlItemForm = xmlItemForm.item(i); 
		            	 subXmlElForm  = (Element) subXmlItemForm;
		            	 
		                 strFormCd  = subXmlElForm.getAttribute("form_cd"); 
		               /**+++++++++++보험료(A102Y/A102M)+++++++++++++++++++++++++++++++++++++++++++++++++++*/
		                 //보험료(A102Y/A102M)
		                if ((strFormCd.equals("A102Y")) || (strFormCd.equals("A102M"))) { 
		                //보장성보험(G0001) , 장애인전용보장성 보험(G0002). 기본내역
		                 edSpciGurtSum = BigDecimal.ZERO;
		                 edSpciHdrcSum = BigDecimal.ZERO;
		                 
		                 edSpciGurtSum02 = BigDecimal.ZERO;
		                 edSpciHdrcSum02 = BigDecimal.ZERO;
		                 ddCnt = 0;
		                 subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		                
		                 //인원별 반복구간
		                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
	 
			            	 
		                       subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
		                       subXmlElMan  = (Element) subXmlItemMan;
		                       
		                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
		                      
		                       arrHDRC_PAY[ddCnt][0]  = strResid;

		                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
		                       
		                       edSpciGurtSum01 = BigDecimal.ZERO;
		    	               edSpciHdrcSum01 = BigDecimal.ZERO;
		    	                 
		                        //상품별 반복구간
		                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
		                        
		                         subXmlItemData =  subXmlElChildMan.item(k); 
		                         subXmlElData  = (Element) subXmlItemData;
		                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
		                         
		                         if (strDatCd.equals("G0001")) { //보장성 총 금액
		                        	 
		                        	 edSpciGurtSum = edSpciGurtSum.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
		                        	 edSpciGurtSum01 = edSpciGurtSum01.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
		                        	 arrHDRC_PAY[ddCnt][1] =  String.valueOf(new BigDecimal(arrHDRC_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                        	 
		                         }else if (strDatCd.equals("G0002")) { //장애인전용 총 금액
		                        	
		                        	 edSpciHdrcSum = edSpciHdrcSum.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
		                        	 edSpciHdrcSum01 = edSpciHdrcSum01.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
		                        	 arrHDRC_PAY[ddCnt][2] =  String.valueOf(new BigDecimal(arrHDRC_PAY[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));  
		                         }
		                         
		                       }
		                       ddCnt = ddCnt + 1;
		                       
		                         InfcPkgYeta3220VO yetaPrc3220Vo = new InfcPkgYeta3220VO();
		                         
		                         yetaPrc3220Vo.setInsuRtyr(edSpciGurtSum01);	/** column 보장성보험합계 : insuRtyr */ 
		                         yetaPrc3220Vo.setPsclIurr(edSpciHdrcSum01);  /** column 장애인전용보험합계 : psclIurr */ 

		                 		 String strValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
		                 		
		                         yetaPrc3220Vo.setRsnoNumb(strValue);    /** column 주민등록번호 : rsnoNumb */ 
		                         yetaPrc3220Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
		                         yetaPrc3220Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
		                         yetaPrc3220Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
		                         yetaPrc3220Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
		                         
		                         yetaPayr1200Service.fnPayr06425_YE3220_2016_Update(yetaPrc3220Vo);
		                         
		                 }
		                 
		                 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
		                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
		                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
		                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
		                 yeta2000Vo.setSpciGurt(edSpciGurtSum);  						/** column 보장성보험료금액 : spciGurt */
		                 yeta2000Vo.setSpciHdrc(edSpciHdrcSum); 						/** column 장애인보장성보험료금액 : spciHdrc */
		                 
		                 yetaPayr1200Service.fnPayr06425_PAYR415_2016_Update(yeta2000Vo);

		                //보험료 종료
		                } 
		                else if ((strFormCd.equals("B101Y")) || (strFormCd.equals("B101D"))) {
		               /**+++++++++++의료비시작+++++++++++++++++++++++++++++++++++++++++++++++++++*/
		                 //의료비시작
		                 //의료비 . 기본내역 (B01의료비 ) B03,B04,B05
		                 strDatCd = "";
		                 ldCnt = 0;
		                 subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		                 //인원별 반복구간
		                 for (int j= 0;j < subXmlElChildForm.getLength();j++)  {

		                	   subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
		                       subXmlElMan  = (Element) subXmlItemMan;
		                       
		                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
		                         
		                        arrCASH_PAY[ldCnt][0]  = strResid;
		                       //기관별반복구간 
		                        subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
		                        //상품별 반복구간
		                        for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
		                       
		                         ddCnt = 0;
		                      
		                         subXmlItemData =  subXmlElChildMan.item(k); 
		                         subXmlElData  = (Element) subXmlItemData;
		                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
		                          
		                         exCASH_UEAM = BigDecimal.ZERO;
		                         
		                         if (strDatCd.equals("G0003")) { //의료비
		                         
		                          exCASH_UEAM =   new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)) ;

		                        } else if  (strDatCd.equals("G0025")) {  //의료기기 구입비용
		                       
		                          exCASH_UEAM =   new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)) ;  
		                         }
		                         else if  (strDatCd.equals("G0026")) {   // 안경 또는 콘텍트렌즈 구입비용
		                        
		                         exCASH_UEAM  =  new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)) ;  
		                         }
		                         else if  (strDatCd.equals("G0027")) {  //보청기 또는 장애인 보장구 구입비용
		                         
		                          exCASH_UEAM =  new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)) ;  
		                         }
		                         ddCnt = 0;
		                         if (strFormCd.equals("B101D"))  { 
		                        	 
		                        	 NodeList subXmlEldd =  subXmlElData.getElementsByTagName("amt");
		                        	 
		                            ddCnt =   subXmlEldd.getLength();
		                         }
		                         else
		                         {
		                            ddCnt = 1;
		                         }

		                         arrCASH_PAY[ldCnt][1] =   String.valueOf(new BigDecimal(arrCASH_PAY[ldCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
		                             

		                         InfcPkgYeta3140VO yetaPrc3140Vo = new InfcPkgYeta3140VO();
		                         

									//yetaPrc3140Vo.setMediSeqn(yeta2000Vo.getMediSeqn());    /** column 의료비지급일련번호 : mediSeqn */
									yetaPrc3140Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
									yetaPrc3140Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
									yetaPrc3140Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
									yetaPrc3140Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */
									yetaPrc3140Vo.setVendNumb(subXmlElData.getAttribute("busnid"));    /** column 거래처번호 : vendNumb */

			                 		String strEncValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			                 		
									yetaPrc3140Vo.setRsnoNumb(strEncValue);    /** column 주민등록번호 : rsnoNumb */
									
									yetaPayr1200Service.fnPayr06430_PAYR430_2015_Delete(yetaPrc3140Vo);
									 

			                 		 String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			                 		
									  if (strResid.equals(strDecValue)) {
										          yetaPrc3140Vo.setPsclHpyn("1");/** column 본인등해당여부 : psclHpyn */ 
					                              // oraQryInsert.ParamByName('PSCL_HPYN').AsString := '1';
									  } else   if (((strResid.substring(0,7).equals("1")) || (strResid.substring(0,7).equals("2"))) && (!strResid.equals(strDecValue))) {
				                          
											   schBrith =  ("19").concat(strResid.substring(0,7));
										  
				                               if  (schBrith.compareTo("19511231") <= 0) {
				                               			yetaPrc3140Vo.setPsclHpyn("1"); /** column 본인등해당여부 : psclHpyn */ 
				                               } else {
				                            	   yetaPrc3140Vo.setPsclHpyn("2"); /** column 본인등해당여부 : psclHpyn */ 
				                               }
				                       
					                    }
					                   else
					                   {
					                         	 yetaPrc3140Vo.setPsclHpyn("2"); /** column 본인등해당여부 : psclHpyn */ 
					                            // oraQryInsert.ParamByName('PSCL_HPYN').AsString := '2';
					                   }  //장애인유무는 저장시 다시 확인  필요함. 
	  
								 
									yetaPrc3140Vo.setVendNumb(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("busnid")).replace("-", ""));    /** column 거래처번호 : vendNumb */	
									yetaPrc3140Vo.setVendName(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("trade_nm")));    /** column 거래처명 : vendName */
		                            yetaPrc3140Vo.setMediCfcd("1");    /** column 의료증빙코드 : mediCfcd */
		                            yetaPrc3140Vo.setCashUect(new BigDecimal(ddCnt));    /** column 지급건수 : cashUect */
									yetaPrc3140Vo.setCashUeam(exCASH_UEAM);    /** column 지급금액 : cashUeam */
									yetaPrc3140Vo.setCtifTrea("0");    /** column 난임시술비해당여부 : ctifTrea */
									 
//									yetaPrc3140Vo.setIsmt(yeta3140Dto.getIsmt());    /** column 수정자 : ismt */
//									yetaPrc3140Vo.setRevnDt(yeta3140Dto.getRevnDt());    /** column 수정일자 : revnDt */
//									yetaPrc3140Vo.setRevnAddr(yeta3140Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
	 											
									yetaPayr1200Service.fnPayr06430_PAYR430_2015_Insert(yetaPrc3140Vo);		
	  
		                         

		                     }
		                        ldCnt = ldCnt + 1;     
		                   }
		                 //의료비 종료
		                }
		                else if ((strFormCd.equals("C101Y")) || (strFormCd.equals("C101M")) ||  (strFormCd.equals("C202Y")) 
	                                ||   (strFormCd.equals("C202M")) ||  (strFormCd.equals("C301Y"))  || ( strFormCd.equals("C301M")))  {
		                	/**+++++++++++교육비 시작+++++++++++++++++++++++++++++++++++++++++++++++++++*/
		              
		                  // 교육비 시작
		                     //교육비 - 유초중고,대학,기타
		                    if ((strFormCd.equals("C101Y")) || (strFormCd.equals("C101M"))) {
		                    /**+++++++++++/교육비  기본 타입 있음...초중고 구분등+++++++++++++++++++++++++++++++++++++++++++++++++++*/
		                       //교육비  기본 타입 있음...초중고 구분등
		                     //  {G0004 교육비-유초중고 본인+가족(시도교육청)
		                     //   G0006 교육비-대학 본인+가족
		                     //   G0007 교육비-기타 본인+가족}
		                        ddCnt = 0;
		                        subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		                        for (int j = 0; j < subXmlElChildForm.getLength();j++) { 

		                           strResid = "";

		                           subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			                       subXmlElMan  = (Element) subXmlItemMan;
			                       
			                       strResid = subXmlElMan.getAttribute("resid");   //주민번호 
		                           arrPayr445[ddCnt][0]  = strResid;
		                           
		                             
		                           subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			                        //상품별 반복구간
			                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
		                           
			                    	strEduTp = "";
		                            strDatCd = "";

		                            subXmlItemData =  subXmlElChildMan.item(k); 
			                         subXmlElData  = (Element) subXmlItemData;
			                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
			                         strEduTp =  subXmlElData.getAttribute("edu_tp");  //교육비종류 
		                           

			                 		 String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			                 		
		                            if (strResid.equals(strDecValue)) {
		                         
		                                 if  (strEduTp.equals("H"))  {
		                                   arrPayr445[9][3] =  String.valueOf(new BigDecimal(arrPayr445[9][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                		   //floattostr(strtofloat(arrPayr445[10][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                 // edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                 }
		                                   else if ( strEduTp.equals("J"))  {
		                                 
		                                   arrPayr445[9][3]  =  String.valueOf(new BigDecimal(arrPayr445[9][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                		   //floattostr(strtofloat(arrPayr445[10][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                 // edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                   }
		                                   else if  (strEduTp.equals("K"))  {
		                                 
		                                    arrPayr445[9][3] = String.valueOf(new BigDecimal(arrPayr445[9][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
		                                    		   //floattostr(strtofloat(arrPayr445[10][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  //edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                   }
		                                  else
		                                  {
		                                     edSpedSelf = edSpedSelf.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
		                                     arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[9][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
		                                    		  //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                            }
		                            else
		                            {

		                                 if (strDatCd.equals("G0004")) { 

		                                  if ( strEduTp.equals("1")) {
		                                   arrPayr445[ddCnt][1] = "Y0030010";
		                                   arrPayr445[ddCnt][2] =   String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                		   //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                                  else if ( strEduTp.equals("2")) {
		                                    arrPayr445[ddCnt][1]  = "Y0030020";
		                                    arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
		                                    		//floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                                  else if ( strEduTp.equals("3")) {
		                                  arrPayr445[ddCnt][1]  = "Y0030020";
		                                  arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                		  //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                                  else if ( strEduTp.equals("4")) {
		                                  arrPayr445[ddCnt][1]  = "Y0030020";
		                                  arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                		  //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                                  else if ( strEduTp.equals("8")) {
		                                  arrPayr445[ddCnt][1]  = "Y0030010";
		                                  arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                		  // floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                                  else if ( strEduTp.equals("F")) {
		                                  arrPayr445[ddCnt][1]  = "Y0030010";
		                                  arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                		  //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                                  else if ( strEduTp.equals("G")) {
		                                   arrPayr445[ddCnt][1] = "Y0030010";
		                                   arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                		   //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                                  else if  (strEduTp.equals("H")) {
		                                   arrPayr445[ddCnt][3] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                		   //floattostr(strtofloat(arrPayr445[ddCnt][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                 // edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                  }
		                                   else if ( strEduTp.equals("J")) {
		                                   arrPayr445[ddCnt][3] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                		   
		                                		   // floattostr(strtofloat(arrPayr445[ddCnt][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                 // edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                   }
		                                   else if ( strEduTp.equals("K")) {
		                                    arrPayr445[ddCnt][3] =   String.valueOf(new BigDecimal(arrPayr445[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		//floattostr(strtofloat(arrPayr445[ddCnt][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  //edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                   }
		                                   }
		                                 else if ( strDatCd.equals("G0006")) {
		                                  // C03 교육비-대학 본인+가족
		                                    if ( strEduTp.equals("5")) {
		                                    arrPayr445[ddCnt][1]  = "Y0030030";
		                                    arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		//floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                    else if ( strEduTp.equals("6")) {
		                                    arrPayr445[ddCnt][1]  = "Y0030030";
		                                     arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                    else if ( strEduTp.equals("7")) {
		                                    arrPayr445[ddCnt][1]  = "Y0030030";
		                                     arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
		                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                    else if ( strEduTp.equals("C")) {
		                                    arrPayr445[ddCnt][1]  = "Y0030030";
		                                     arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		 // floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                    else if ( strEduTp.equals("D")) {
		                                    arrPayr445[ddCnt][1]  = "Y0030030";
		                                    arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
		                                    		//floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                    else if ( strEduTp.equals("E")) {
		                                     arrPayr445[ddCnt][1] = "Y0030030";
		                                     arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		 // floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                    else if ( strEduTp.equals("H")) {
		                                       arrPayr445[ddCnt][3] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		   //floattostr(strtofloat(arrPayr445[ddCnt][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                     //edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                    }
		                                     else if ( strEduTp.equals("J")) {
		                                       arrPayr445[ddCnt][3] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		   // floattostr(strtofloat(arrPayr445[ddCnt][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                     //edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                     }
		                                     else if ( strEduTp.equals("K")) {
		                                      arrPayr445[ddCnt][3] =   String.valueOf(new BigDecimal(arrPayr445[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		  //floattostr(strtofloat(arrPayr445[ddCnt][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                   // edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                     }
		                                 }
		                                 else if ( strDatCd.equals("G0007")) {
		                                    // C04 교육비-기타 본인+가족
		                                    if ( strEduTp.equals("1")) {
		                                     arrPayr445[ddCnt][1]  = "Y0030010";
		                                     arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		 // floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                    else if ( strEduTp.equals("2")) {
		                                    arrPayr445[ddCnt][1]  = "Y0030020";
		                                     arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                    else if ( strEduTp.equals("3")) {
		                                    arrPayr445[ddCnt][1]  = "Y0030020";
		                                     arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                    else if ( strEduTp.equals("4")) {
		                                    arrPayr445[ddCnt][1]  = "Y0030020";
		                                    arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		// floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                    else if ( strEduTp.equals("8")) {
		                                    arrPayr445[ddCnt][1]  = "Y0030010";
		                                    arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
		                                    		//floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                    else if ( strEduTp.equals("F")) {
		                                    arrPayr445[ddCnt][1]  = "Y0030010";
		                                     arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		 // floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                    else if ( strEduTp.equals("G")) {
		                                    arrPayr445[ddCnt][1]  = "Y0030010";
		                                     arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
		                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                    else if ( strEduTp.equals("5")) {
		                                    arrPayr445[ddCnt][1]  = "Y0030030";
		                                     arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		 // floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                    else if ( strEduTp.equals("6")) {
		                                     arrPayr445[ddCnt][1]  = "Y0030030";
		                                     arrPayr445[ddCnt][2] = String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		 // floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                    else if ( strEduTp.equals("7")) {
		                                    arrPayr445[ddCnt][1]  = "Y0030030";
		                                     arrPayr445[ddCnt][2] =String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		 // floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                    else if ( strEduTp.equals("C")) {
		                                     arrPayr445[ddCnt][1]  = "Y0030030";
		                                    arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		//floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                    else if ( strEduTp.equals("D")) {
		                                     arrPayr445[ddCnt][1]  = "Y0030030";
		                                     arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                    else if  (strEduTp.equals("E")) {
		                                     arrPayr445[ddCnt][1] = "Y0030030";
		                                     arrPayr445[ddCnt][2] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    }
		                                     else if ( strEduTp.equals("H")) {
		                                     arrPayr445[ddCnt][3] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
		                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    //edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                     }
		                                     else if ( strEduTp.equals("J")) {
		                                     arrPayr445[ddCnt][3] =  String.valueOf(new BigDecimal(arrPayr445[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
		                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    //edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                     }
		                                     else if ( strEduTp.equals("K")) {
		                                     arrPayr445[ddCnt][3] =   String.valueOf(new BigDecimal(arrPayr445[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		 //floattostr(strtofloat(arrPayr445[ddCnt][3])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                    // edSpciScam  := edSpciScam  + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                     }
		                                 }

		                                 }

		                            }
			                       
			                       ddCnt = ddCnt + 1;
		                        }

		                    }
		                    else if ((strFormCd.equals("C202Y")) || (strFormCd.equals("C202M"))) {
		                    	/**+++++++++++/직업훈련비(본인교육비에 해당)  C02 직업훈련비 본인+++++++++++++++++++++++++++++++++++++++++++++++++++*/
		                         //직업훈련비(본인교육비에 해당)  C02 직업훈련비 본인
		                         strDatCd =  "";
		                         //인원별 반복구간
		                         subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		     	                
		    	                 //인원별 반복구간
		    	                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 


			                           subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
				                       subXmlElMan  = (Element) subXmlItemMan;
				                       
				                       strResid = subXmlElMan.getAttribute("resid");   //주민번호 
			                           
			                           subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
		  	                      //과정별반복구간
			                      
			                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {   
		                             
			                    	     subXmlItemData =  subXmlElChildMan.item(k); 
				                         subXmlElData  = (Element) subXmlItemData;
				                         strDatCd = subXmlElData.getAttribute("dat_cd"); 

				                         String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
					                 		
		                                 if (strDatCd.equals("G0005")) {
		                                	 if (strResid.equals(strDecValue)) { 
		                                	 
		                                     edSpedSelf = edSpedSelf.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
//		                                     arrPayr445[9][3] =   String.valueOf(new BigDecimal(arrPayr445[9][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                        //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                	 }
		                                 }
			                       }

		    	                 }
		                    }
		                    else if  ((strFormCd.equals("C301Y")) || ( strFormCd.equals("C301M")))  {
		                    	/**+++++++++++//교복구입비  연간합계 3101M 일별 C06 교복구입비 본인+가족(기본)+++++++++++++++++++++++++++++++++++++++++++++++++++*/
		                         //교복구입비  연간합계 3101M 일별 C06 교복구입비 본인+가족(기본)
		                         strDatCd  = "";
		                         
		                         subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		     	                
		    	                 //인원별 반복구간
		    	                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 


			                           subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
				                       subXmlElMan  = (Element) subXmlItemMan;
				                       
				                       strResid = subXmlElMan.getAttribute("resid");   //주민번호 
			                           
			                           subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
		  	                        // 기관별 반복구간
			                          for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
			                    	 
			                        	 subXmlItemData =  subXmlElChildMan.item(k); 
			 	                         subXmlElData  = (Element) subXmlItemData;
			 	                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
			 	                     
			 	                         String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
				                 		
		                                 if (strDatCd.equals("G0024")) {
		                                	 if (strResid.equals(strDecValue)) { 
		                                		 edSpedSelf = edSpedSelf.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
//		                                		 arrPayr445[9][3] =   String.valueOf(new BigDecimal(arrPayr445[9][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                				 //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                	 }
		                                   else
		                                   {
		                                	   boolean chkData = false;
		                                	   for(int l = 0; l < arrPayr445.length;l++) { 
		                                       
		                                		  if (MSFSharedUtils.paramNotNull(arrPayr445[l][0])) {
			                                           if (arrPayr445[l][0].equals(strResid))  {
			                                             arrPayr445[l][1]  = "Y0030020";
			                                             arrPayr445[l][2] =  String.valueOf(new BigDecimal(arrPayr445[l][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
			                                            		 //floattostr(strtofloat(arrPayr445[ddCnt][2])  + strtofloat(subXmlItemData.NamedItem['sum'].Text));
			                                             chkData = true;
			                                           }
		                                		  } 
		                                	   }
		                                	   
		                                	   if (!chkData) {
		                                		   for(int l = 0; l < arrPayr445.length;l++) {  
			 	                                       if (MSFSharedUtils.paramNull(arrPayr445[l][0])) {
			                                		     arrPayr445[l][0] =  strResid ;
			                                		     arrPayr445[l][1]  = "Y0030020";
			                                             arrPayr445[l][2] =  String.valueOf(new BigDecimal(arrPayr445[l][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
			 	                                	    break;
			 	                                       }
		 	                                	  }
		                                	   }
		                                   }
		                                 }
		                                 
			                          }

		    	                 }

		                    }

		                  //교육비 종료
		                }
		                else if( (strFormCd.equals("D101Y") ) || (strFormCd.equals("D101M"))) {
		                	/**+++++++++++개인연금저축 시작++++++++++++++++++++++++++++++++++++++++++++++++++*/
		                
		                   // 개인연금저축 시작
		                  //개인연금저축 D101Y 연간합계 D101M 월별 D01 개인연금저축 본인
		                  //근로자 본인 명의로 2000.12.31 이전에 가입하여 해당 과세기간에 불입한 금액
		                  //Y0040030	Y004 	0030	개인연금저축					21
		                   strDatCd = "";
		                   
		                   InfcPkgYeta3100VO yetaPrc3100Vo = new InfcPkgYeta3100VO();
		                   
		                   yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
		                   yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
		                   yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
		                   yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
		                   yetaPrc3100Vo.setImdeGbcd("Y0040030");    /** column 소득공제구분코드 : imdeGbcd */
		                   
		                   yetaPayr1200Service.fnPayr06430_Payr418_2015_Delete(yetaPrc3100Vo);
	 
		                    
		                   subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
			                
			                 //인원별 반복구간
			                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 

			                	 subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			                       subXmlElMan  = (Element) subXmlItemMan;
			                       
			                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
			                       
			                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			                        //상품별 반복구간
			                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
			                    	   
			                      
			                    	     subXmlItemData =  subXmlElChildMan.item(k); 
				                         subXmlElData  = (Element) subXmlItemData;
				                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
				                         String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
					                 		
			                              if (strDatCd.equals("G0009")) {
			                        	   if (strResid.equals(strDecValue)) { 
		
			                                 edPrvm20be = edPrvm20be.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
			                                		 //+   strtofloat(subXmlItemData.NamedItem['sum'].Text);
		 
			                                yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
			          	                    yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
			          	                    yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
			          	                    yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
			          	                    yetaPrc3100Vo.setImdeGbcd("Y0040030");    /** column 소득공제구분코드 : imdeGbcd */
											yetaPrc3100Vo.setFinaSeqn(BigDecimal.ZERO);    /** column 연금_저축일련번호 : finaSeqn */ 
											yetaPrc3100Vo.setFinaCode(PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관코드 : finaCode */
											yetaPrc3100Vo.setFinaName(subXmlElData.getAttribute("trade_nm") );    /** column 금융기관상호 : finaName */
											yetaPrc3100Vo.setAcntNumb(subXmlElData.getAttribute("acc_no") );    /** column 계좌번호 : acntNumb */
											yetaPrc3100Vo.setIcnmYear("");    /** column 납입연차 : icnmYear */
											yetaPrc3100Vo.setPaytAmnt(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));    /** column 불입금액 : paytAmnt */
											yetaPrc3100Vo.setDeduAmnt(BigDecimal.ZERO);    /** column 세액공제금액 : deduAmnt */
											yetaPrc3100Vo.setImdeTxcd("21");    /** column 소득공제구분국세청코드 : imdeTxcd */
											yetaPrc3100Vo.setFinaTxcd( PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관국세청코드 : finaTxcd */
//											yetaPrc3100Vo.setKybdr(yeta3100Dto.getKybdr());    /** column 입력자 : kybdr */
//											yetaPrc3100Vo.setInptDt(yeta3100Dto.getInptDt());    /** column 입력일자 : inptDt */
//											yetaPrc3100Vo.setInptAddr(yeta3100Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//											yetaPrc3100Vo.setIsmt(yeta3100Dto.getIsmt());    /** column 수정자 : ismt */
//											yetaPrc3100Vo.setRevnDt(yeta3100Dto.getRevnDt());    /** column 수정일자 : revnDt */
//											yetaPrc3100Vo.setRevnAddr(yeta3100Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
		
		 
			                                  //FINA_SEQN
//			                                oraQryInsert.ParamByName('IMDE_GBCD').AsString := 'B0110030';   // 개인	연금저축
//			                                oraQryInsert.ParamByName('IMDE_TXCD').AsString := '21' ;  //개인 연금저축 구분번호
//			                              //  oraQryInsert.ParamByName('IMDE_GBNM').AsString := Cells[4,jRow];
//			                                oraQryInsert.ParamByName('FINA_CODE').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//			                                oraQryInsert.ParamByName('FINA_TXCD').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//			                                oraQryInsert.ParamByName('FINA_NAME').AsString := subXmlItemData.Params.Values['trade_nm'];
//			                                oraQryInsert.ParamByName('ACNT_NUMB').AsString := subXmlItemData.Params.Values['acc_no'];
//			                                oraQryInsert.ParamByName('ICNM_YEAR').AsString := '';
//			                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemData.NamedItem['sum'].Text;
//			                                oraQryInsert.ParamByName('DEDU_AMNT').AsString := '0';
											yetaPayr1200Service.fnPayr06430_Payr418_2016_Insert(yetaPrc3100Vo);
		
			                        	   }
			                              }
			                       }
		
			                 } 
			               
			                yeta2000Vo.setPrvm20be(edPrvm20be);     
			              
							 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
			                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
			                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
			                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
			                 
			                yetaPayr1200Service.fnPayr06425_Payr415_2016_Update(yeta2000Vo);
			                      
		                  //개인 연금 저축 종료
		                }
		                else if ((strFormCd.equals("E102Y"))  || (strFormCd.equals("E102M")) ) {
		                	/**+++++++++++2012년도 : 연금저축 E101Y 연간합계 E101M+++++++++++++++++++++++++++++++++++++++++++++++++*/
		               
		                    // 2012년도 : 연금저축 E101Y 연간합계 E101M
		                    // 연금 저축 시작
		                    //월별 E01 연금저축 본인
		                    //근로자 본인 명의로 2001.1.1 이후에 가입하여 해당 과세기간에 불입한 금액
		                    //Y0040040  	B011	0040	연금저축					22

		                    strDatCd = "";
		                    
		                    
		                    InfcPkgYeta3100VO yetaPrc3100Vo = new InfcPkgYeta3100VO();
		                   
		                   yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
		                   yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
		                   yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
		                   yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
		                   yetaPrc3100Vo.setImdeGbcd("Y0040040");    /** column 소득공제구분코드 : imdeGbcd */
		                   
		                   yetaPayr1200Service.fnPayr06430_Payr418_2015_Delete(yetaPrc3100Vo);

//		                    oraQryDelete.Close;
//		                    oraQryDelete.SQL.Clear;
//		                    oraQryDelete.SQL.Add(fnPayr06430_Payr418_2016_Delete);
//		                    oraQryDelete.SQL.Add(' AND  IMDE_GBCD = :IMDE_GBCD   ');
	//
//		                    oraQryDelete.ParamByName('EDAC_RVYY').AsString :=  lblEDAC_RVYY.Caption;
//		                    oraQryDelete.ParamByName('SETT_GBCD').AsString :=  lblSETT_GBCD.Caption;
//		                    oraQryDelete.ParamByName('PSNL_NUMB').AsString :=  lblPSNL_NUMB.Caption;
//		                    oraQryDelete.ParamByName('IMDE_GBCD').AsString := 'B0110040';   //	B011	0040	연금저축
	 
		                   subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
			                
			                 //인원별 반복구간
			                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
			                	 
			                
			                	 subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			                       subXmlElMan  = (Element) subXmlItemMan;
			                       
			                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
		                         // 상품별 반복구간
			                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			                        //상품별 반복구간
			                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
			                        
			                         subXmlItemData =  subXmlElChildMan.item(k); 
			                         subXmlElData  = (Element) subXmlItemData;
			                         strDatCd = subXmlElData.getAttribute("dat_cd"); 

			                         String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
				                 		    
		                           if (strDatCd.equals("G0010")) { 
		                        	 
		                           if (strResid.equals(strDecValue)) { 
		                        	 
		                                edPrvm21af = edPrvm21af.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("ddct_bs_ass_amt", subXmlElData))) ;
		                                		//+   strtofloat(subXmlItemData.NamedItem['ddct_bs_ass_amt'].Text);

		                           yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
	        	                     yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
	        	                    yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
	        	                    yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
	        	                    yetaPrc3100Vo.setImdeGbcd("Y0040040");    /** column 소득공제구분코드 : imdeGbcd */
									yetaPrc3100Vo.setFinaSeqn(BigDecimal.ZERO);    /** column 연금_저축일련번호 : finaSeqn */ 
									yetaPrc3100Vo.setFinaCode(PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관코드 : finaCode */
									yetaPrc3100Vo.setFinaName(subXmlElData.getAttribute("trade_nm") );    /** column 금융기관상호 : finaName */
									yetaPrc3100Vo.setAcntNumb(subXmlElData.getAttribute("acc_no") );    /** column 계좌번호 : acntNumb */
									yetaPrc3100Vo.setIcnmYear("");    /** column 납입연차 : icnmYear */
									yetaPrc3100Vo.setPaytAmnt(new BigDecimal(PkgFuncUtils.getXmlTagValue("ddct_bs_ass_amt", subXmlElData)));    /** column 불입금액 : paytAmnt */
									yetaPrc3100Vo.setDeduAmnt(BigDecimal.ZERO);    /** column 세액공제금액 : deduAmnt */
									yetaPrc3100Vo.setImdeTxcd("22");    /** column 소득공제구분국세청코드 : imdeTxcd */
									yetaPrc3100Vo.setFinaTxcd( PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관국세청코드 : finaTxcd */
//									yetaPrc3100Vo.setKybdr(yeta3100Dto.getKybdr());    /** column 입력자 : kybdr */
//									yetaPrc3100Vo.setInptDt(yeta3100Dto.getInptDt());    /** column 입력일자 : inptDt */
//									yetaPrc3100Vo.setInptAddr(yeta3100Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//									yetaPrc3100Vo.setIsmt(yeta3100Dto.getIsmt());    /** column 수정자 : ismt */
//									yetaPrc3100Vo.setRevnDt(yeta3100Dto.getRevnDt());    /** column 수정일자 : revnDt */
//									yetaPrc3100Vo.setRevnAddr(yeta3100Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
	 

		                                  //FINA_SEQN
//		                                oraQryInsert.ParamByName('IMDE_GBCD').AsString := 'B0110040';   //	B011	0040	연금저축
//		                                oraQryInsert.ParamByName('IMDE_TXCD').AsString := '22' ;
//		                              //  oraQryInsert.ParamByName('IMDE_GBNM').AsString := Cells[4,jRow];
//		                                oraQryInsert.ParamByName('FINA_CODE').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//		                                oraQryInsert.ParamByName('FINA_TXCD').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//		                                oraQryInsert.ParamByName('FINA_NAME').AsString := subXmlItemData.Params.Values['trade_nm'];
//		                                oraQryInsert.ParamByName('ACNT_NUMB').AsString := subXmlItemData.Params.Values['acc_no'];
//		                                oraQryInsert.ParamByName('ICNM_YEAR').AsString := '';
//		                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemData.NamedItem['ddct_bs_ass_amt'].Text;
//		                                oraQryInsert.ParamByName('DEDU_AMNT').AsString := '0';

		                                yetaPayr1200Service.fnPayr06430_Payr418_2016_Insert(yetaPrc3100Vo);
		                           }
		                           }
			                       }

			                 }
	 

		                    //  oraQryUpdate.ParamByName('JRTR_ANSV').AsFloat :=  ;
			            	 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
			                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
			                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
			                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
			                 
		                      
		                        yeta2000Vo.setJrtrAnsv(edPrvm21af);  
				              
				                yetaPayr1200Service.fnPayr06425_JrtrAnsv_2016_Update(yeta2000Vo);
				                
				                
		                  //연금저축 종료
		                }
		                else if ((strFormCd.equals("F102Y")) || (strFormCd.equals("F102M"))) {
		                	/**+++++++++++퇴직연금 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		                 
		                    // 퇴직연금 시작
		                    // 2012년도  : 퇴직연금 F101Y 연간합계 F101M
		                    //  월별 F01 퇴직연금 본인
		                    // Y0040010	B011	0010	근로자퇴직연금보장법.	11
		                    // Y0040020	B011	0020	과학기술인공제회	12
		                    // B0110025	B011	0025	확정기여형퇴직연금.	13  ---삭제 ,''B0110025''

		                     strDatCd = "";

		                     
		                     InfcPkgYeta3100VO yetaPrc3100Vo = new InfcPkgYeta3100VO();
			                   
			                   yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
			                   yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
			                   yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
			                   yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
			                   yetaPrc3100Vo.setImdeGbcd("Y0040010");    /** column 소득공제구분코드 : imdeGbcd */
			                   
			                   yetaPayr1200Service.fnPayr06430_Payr418_2015_Delete(yetaPrc3100Vo);
			                
			                   
			                   yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
			                   yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
			                   yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
			                   yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
			                   yetaPrc3100Vo.setImdeGbcd("Y0040020");    /** column 소득공제구분코드 : imdeGbcd */
			                   
			                   yetaPayr1200Service.fnPayr06430_Payr418_2015_Delete(yetaPrc3100Vo);
			                   
		                     
		                   // oraQryDelete.SQL.Add(' AND  IMDE_GBCD IN (''B0110010'',''B0110020'')   ');

		                    
			                   subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
				                
				                 //인원별 반복구간
				                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
			 
					            	 
				                       subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
				                       subXmlElMan  = (Element) subXmlItemMan;
				                       
				                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
				                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
				                        //상품별 반복구간
				                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
				                        
				                         subXmlItemData =  subXmlElChildMan.item(k); 
				                         subXmlElData  = (Element) subXmlItemData;
				                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
				                         
			                           if (strDatCd.equals("G0011")) {
			                        	   
			                        	   String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
					                 		
			                        	   if (strResid.equals(strDecValue)) { 
		
			                                if ((PkgFuncUtils.getXmlTagValue("pension_cd", subXmlElData)).equals("11")) {
			                                     // Y0040010	B011	0010	근로자퇴직연금보장법.	11
			                                      edJrtrPsct = edJrtrPsct.add(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("ddct_bs_ass_amt", subXmlElData),"0"))) ;
			                                    		  // +   strtofloat(subXmlItemData.NamedItem['ddct_bs_ass_amt'].Text);
			                                }
			                                else if ((PkgFuncUtils.getXmlTagValue("pension_cd", subXmlElData)).equals("12")) {
			                                
			                                  // Y0040020	B011	0020	과학기술인공제회	12
			                                   edJRTR_CICT = edJRTR_CICT.add(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("ddct_bs_ass_amt", subXmlElData),"0"))) ;  
			                                		   //+   strtofloat(subXmlItemData.NamedItem['ddct_bs_ass_amt'].Text);
			                                }
			                                //else  if (subXmlItemData.NamedItem['pension_cd'].Text)  = '13' then
			                                //begin
			                                  // edTemp := edTemp +   strtofloat(subXmlItemData.NamedItem['sum'].Text);
			                                  // B0110025	B011	0025	확정기여형퇴직연금.	13     edTemp
			                                //end; 
		
			                                // Y0040010	B011	0010	근로자퇴직연금보장법.	11   edJrtrPsct
			                                // Y0040020	B011	0020	과학기술인공제회	12       edJRTR_CICT
			                                // B0110025	B011	0025	확정기여형퇴직연금.	13     edTemp
		 

			 	                            yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
			         	                     yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
			         	                    yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
			         	                    yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
			         	                   
			         	                   
			                                  //FINA_SEQN
			                                if ((PkgFuncUtils.getXmlTagValue("pension_cd", subXmlElData)).equals("11")) {
			                                	
			                              
			                                     // Y0040010	B011	0010	근로자퇴직연금보장법.	11
			                                	   yetaPrc3100Vo.setImdeGbcd("Y0040010");    /** column 소득공제구분코드 : imdeGbcd */
					         	                   yetaPrc3100Vo.setImdeTxcd(PkgFuncUtils.getXmlTagValue("pension_cd", subXmlElData));    /** column 소득공제구분국세청코드 : imdeTxcd */
					         	                   
			                                     //  oraQryInsert.ParamByName('IMDE_GBCD').AsString := 'Y0040010';    
			                                     //  oraQryInsert.ParamByName('IMDE_TXCD').AsString := subXmlItemData.NamedItem['pension_cd'].Text;
			                                }
			                                else if ((PkgFuncUtils.getXmlTagValue("pension_cd", subXmlElData)).equals("12")) {
			                                  // Y0040020	B011	0020	과학기술인공제회	12
			                                	  yetaPrc3100Vo.setImdeGbcd("Y0040020");    /** column 소득공제구분코드 : imdeGbcd */
					         	                   yetaPrc3100Vo.setImdeTxcd(PkgFuncUtils.getXmlTagValue("pension_cd", subXmlElData));    /** column 소득공제구분국세청코드 : imdeTxcd */
					         	                   
			                                  //  oraQryInsert.ParamByName('IMDE_GBCD').AsString := 'Y0040020';
			                                  //  oraQryInsert.ParamByName('IMDE_TXCD').AsString := subXmlItemData.NamedItem['pension_cd'].Text;
			                                }
//			                                else  if (subXmlItemData.NamedItem['pension_cd'].Text)  = '13' then
//			                                begin
//			                                     oraQryInsert.ParamByName('IMDE_GBCD').AsString := 'B0110025';
//			                                     oraQryInsert.ParamByName('IMDE_TXCD').AsString := subXmlItemData.NamedItem['pension_cd'].Text;
//			                                  // B0110025	B011	0025	확정기여형퇴직연금.	13     edTemp
//			                                end;
		

			 								yetaPrc3100Vo.setFinaSeqn(BigDecimal.ZERO);    /** column 연금_저축일련번호 : finaSeqn */ 
			 								yetaPrc3100Vo.setFinaCode(PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관코드 : finaCode */
			 								yetaPrc3100Vo.setFinaName(subXmlElData.getAttribute("trade_nm") );    /** column 금융기관상호 : finaName */
			 								yetaPrc3100Vo.setAcntNumb(subXmlElData.getAttribute("acc_no") );    /** column 계좌번호 : acntNumb */
			 								yetaPrc3100Vo.setIcnmYear("");    /** column 납입연차 : icnmYear */
			 								yetaPrc3100Vo.setPaytAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("ddct_bs_ass_amt", subXmlElData),"0")));    /** column 불입금액 : paytAmnt */
			 								yetaPrc3100Vo.setDeduAmnt(BigDecimal.ZERO);    /** column 세액공제금액 : deduAmnt */
			 								
			 								yetaPrc3100Vo.setFinaTxcd( PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관국세청코드 : finaTxcd */
//			 								yetaPrc3100Vo.setKybdr(yeta3100Dto.getKybdr());    /** column 입력자 : kybdr */
//			 								yetaPrc3100Vo.setInptDt(yeta3100Dto.getInptDt());    /** column 입력일자 : inptDt */
//			 								yetaPrc3100Vo.setInptAddr(yeta3100Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//			 								yetaPrc3100Vo.setIsmt(yeta3100Dto.getIsmt());    /** column 수정자 : ismt */
//			 								yetaPrc3100Vo.setRevnDt(yeta3100Dto.getRevnDt());    /** column 수정일자 : revnDt */
//			 								yetaPrc3100Vo.setRevnAddr(yeta3100Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
			                             
			 								//  oraQryInsert.ParamByName('IMDE_GBNM').AsString := Cells[4,jRow];
//			                                oraQryInsert.ParamByName('FINA_CODE').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//			                                oraQryInsert.ParamByName('FINA_TXCD').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//			                                oraQryInsert.ParamByName('FINA_NAME').AsString := subXmlItemData.Params.Values['trade_nm'];
//			                                oraQryInsert.ParamByName('ACNT_NUMB').AsString := subXmlItemData.Params.Values['acc_no'];
//			                                oraQryInsert.ParamByName('ICNM_YEAR').AsString := '';
//			                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemData.NamedItem['ddct_bs_ass_amt'].Text;
//			                                oraQryInsert.ParamByName('DEDU_AMNT').AsString := '0';
	 
			 								  yetaPayr1200Service.fnPayr06430_Payr418_2016_Insert(yetaPrc3100Vo);
			                        	   }
			                             }
				                       }
		
				                 }
		 
				            	 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
				                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
				                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
				                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
				                 
//			                      oraQryUpdate.ParamByName('JRTR_PSCT').AsFloat :=  edJrtrPsct;
//			                      oraQryUpdate.ParamByName('JRTR_CICT').AsFloat :=  edJRTR_CICT;
		
			                      yeta2000Vo.setJrtrPsct(edJrtrPsct);
			                      yeta2000Vo.setJrtrCict(edJRTR_CICT);
					              
					             yetaPayr1200Service.fnPayr06425_JrtrCict_2016_Update(yeta2000Vo);

		                   //퇴직연금 종료 
		                }
		                else if ((strFormCd.equals("G104Y")) ||  (strFormCd.equals("G104M")))  {
		                	/**+++++++++++신용카드 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		                 
		                    //  신용카드 시작
		                    //신용카드  연간합계 G102M 월별 G01 신용카드 본인+가족
		                    //종류확인
		                       strDatCd = "";
		                       ddCnt = 0;
		                       subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
		   	                
		  	                   //인원별 반복구간
		  	                   for (int j = 0; j < subXmlElChildForm.getLength();j++) { 

		  	                	   subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			                       subXmlElMan  = (Element) subXmlItemMan;
			                       
			                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
			                       
			                       String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			                 		 
			                       if (strResid.equals(strDecValue)) { 
		                               
			                    	     //2014 년도 신용카드 전체합계
		                                  edCARD_ET14 =  edCARD_ET14.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tot_amt"),"0"))); //일반
		                                  //+ strtofloat(subXmlItemMan.Params.Values['ftyr_tot_amt']);
		                                  edCARD_ET14 =  edCARD_ET14.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_market_tot_amt"),"0"))); //전통시장
		                                        //+ strtofloat(subXmlItemMan.Params.Values['ftyr_market_tot_amt']);
		                                  edCARD_ET14 =  edCARD_ET14.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tmoney_tot_amt"),"0"))); //대중교통 
		                                        ///+ strtofloat(subXmlItemMan.Params.Values['ftyr_tmoney_tot_amt']); 2014년도 본인 신용카드 사용계 총합
		                                  
		                                  //2014 년도 본인추가 공제율
		                                 // edETAD_DD13 =  edETAD_DD13.add(new BigDecimal(subXmlElMan.getAttribute("ftyr_tot_amt") ));
		                                  edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_market_tot_amt"),"0"))); 
		                                  		//+ strtofloat(subXmlItemMan.Params.Values['ftyr_market_tot_amt']);
		                                  edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tmoney_tot_amt"),"0")));
		                                  		//+ strtofloat(subXmlItemMan.Params.Values['ftyr_tmoney_tot_amt']);
		                                  

			                    	     //2015 년도 전체합계
		                                  edCARD_ET15 =  edCARD_ET15.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tot_amt"),"0"))); 
		                                  				//+ strtofloat(subXmlItemMan.Params.Values['pre_tot_amt']);
		                                  edCARD_ET15 =  edCARD_ET15.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_market_tot_amt"),"0"))); 
		                                  				//+ strtofloat(subXmlItemMan.Params.Values['pre_market_tot_amt']);
		                                  edCARD_ET15 =  edCARD_ET15.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tmoney_tot_amt"),"0"))); 
		                                  				//+ strtofloat(subXmlItemMan.Params.Values['pre_tmoney_tot_amt']);
		                                  
			                       
			                       } 
		                            
		                             arrCARD_PAY[ddCnt][0]  = strResid;
		                             // 상품별 반복구간
		                             subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
		 	                        //상품별 반복구간
		 	                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
		 	                        
		 	                         subXmlItemData =  subXmlElChildMan.item(k); 
		 	                         subXmlElData  = (Element) subXmlItemData;
		 	                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
		 	                         
		 	                        if (strDatCd.equals("G0012")) { // if strDatCd  = 'G01' then
		 	                        	
		 	                        	String str1DecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
		 		                 		
		 	                        	
		                                  if ((subXmlElData.getAttribute("use_place_cd") ).equals("1") )  { 
		                                  	 
		                                      edETCT_CARD = edETCT_CARD.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                                      
		                                      arrCARD_PAY[ddCnt][1]   = String.valueOf(new BigDecimal(arrCARD_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
		                                    		  //floattostr(strtofloat(arrCARD_PAY[ddCnt][1]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                                  else  if ((subXmlElData.getAttribute("use_place_cd")).equals("2") )  { 
		                                 
		                                      edETCH_MGVD = edETCH_MGVD.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                                      
		                                      arrCARD_PAY[ddCnt][2]   =  String.valueOf(new BigDecimal(arrCARD_PAY[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		  //floattostr(strtofloat(arrCARD_PAY[ddCnt][2]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));

				 	                        	//2016년도 추가공제율 상반기
				 	                        	if (strResid.equals(str1DecValue)) { 
				                                	  edETAD_D16L =  edETAD_D16L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("first_year_tot_amt"),"0")));
				 	                         	}
		                                  
		                                  }
		                                  else  if ((subXmlElData.getAttribute("use_place_cd")).equals("3") )  { 
		                               
		                                      edETCH_BCED = edETCH_BCED.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));  
		                                      arrCARD_PAY[ddCnt][3]   =  String.valueOf(new BigDecimal(arrCARD_PAY[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		  //floattostr(strtofloat(arrCARD_PAY[ddCnt][3]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));

				 	                        	//2016년도 추가공제율 상반기
				 	                        	if (strResid.equals(str1DecValue)) { 
				                                	  edETAD_D16L =  edETAD_D16L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("first_year_tot_amt"),"0")));
				 	                         	}
		                                  
		                                  }
		 	                        } 
		 	                      
		 	                       }
		 	                      ddCnt = ddCnt + 1;
		  	                   } 

		                      //oraQryUpdate.ParamByName('ETCT_CARD').AsFloat := edETCT_CARD ; 
		  	                 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
			                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
			                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
			                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
			                 
		                      yeta2000Vo.setEtctCard(edETCT_CARD);
		 	                 
		 	                 yetaPayr1200Service.fnPayr06425_PAYR415_2016_06_Update(yeta2000Vo);
		                      

		                   //신용카드 종료
		                }
		                else if (strFormCd.equals("G205M")) {
		                 /**+++++++++++현금 영수증 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		                 
		                   //  현금 영수증 시작
		                  //현금영수증 - - G203M 월별 G02 현금영수증 본인+가족
		                  //종류확인.  기본서직없음. 상세...
		                       strDatCd = "";
		                       ddCnt = 0;
		                       
		                       subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		   	                
		  	                 //인원별 반복구간
		  	                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
		   
		  		            	 
		  	                       subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
		  	                       subXmlElMan  = (Element) subXmlItemMan;
		  	                       
		  	                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
		  	                    
		  	                       String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			                 		
		                            if (strResid.equals(strDecValue)) { 
		                             //2014 년도 전체합계
		                            	edCARD_ET14 =  edCARD_ET14.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tot_amt"),"0") ));
	                                 //+ strtofloat(subXmlItemMan.Params.Values['ftyr_tot_amt']);
		                            	edCARD_ET14 =  edCARD_ET14.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_market_tot_amt"),"0") ));
	                                       //+ strtofloat(subXmlItemMan.Params.Values['ftyr_market_tot_amt']);
		                            	edCARD_ET14 =  edCARD_ET14.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tmoney_tot_amt"),"0") ));
	                                       ///+ strtofloat(subXmlItemMan.Params.Values['ftyr_tmoney_tot_amt']);
		                            	
	                                 //2014 년도 본인추가 공제율
		                            	edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tot_amt"),"0") ));
		                            	edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_market_tot_amt"),"0") )); 
	                                 		//+ strtofloat(subXmlItemMan.Params.Values['ftyr_market_tot_amt']);
		                            	edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tmoney_tot_amt"),"0") ));
	                                 		//+ strtofloat(subXmlItemMan.Params.Values['ftyr_tmoney_tot_amt']);
		                            	
		                    	     //2015 년도 전체합계
		                            	edCARD_ET15 =  edCARD_ET15.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tot_amt"),"0") )); 
	                                 				//+ strtofloat(subXmlItemMan.Params.Values['pre_tot_amt']);
		                            	edCARD_ET15 =  edCARD_ET15.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_market_tot_amt"),"0") )); 
	                                 				//+ strtofloat(subXmlItemMan.Params.Values['pre_market_tot_amt']);
		                            	edCARD_ET15 =  edCARD_ET15.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tmoney_tot_amt"),"0") )); 
	                                 				//+ strtofloat(subXmlItemMan.Params.Values['pre_tmoney_tot_amt']);

//	                          //이전년도 전체합계
//	                          edCARD_ET13 :=  edCARD_ET13 + strtofloat(subXmlItemMan.Params.Values['pre_tot_amt']);
//	                          edCARD_ET13 :=  edCARD_ET13 + strtofloat(subXmlItemMan.Params.Values['pre_market_tot_amt']);
//	                          edCARD_ET13 :=  edCARD_ET13 + strtofloat(subXmlItemMan.Params.Values['pre_tmoney_tot_amt']);
//	                          //이전년도 본인추가 공제율
//	                          edETAD_DD13 :=  edETAD_DD13 + strtofloat(subXmlItemMan.Params.Values['pre_tot_amt']);
//	                          edETAD_DD13 :=  edETAD_DD13 + strtofloat(subXmlItemMan.Params.Values['pre_market_tot_amt']);
//	                          edETAD_DD13 :=  edETAD_DD13 + strtofloat(subXmlItemMan.Params.Values['pre_tmoney_tot_amt']);
		                            	
		                            	
		                            	
		                            }
		                           
		                             arrMONI_PAY[ddCnt][0]  = strResid;
		                         
		                             // 상품별 반복구간
		                             subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
		 	                        //상품별 반복구간
		 	                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
		 	                        
		 	                         subXmlItemData =  subXmlElChildMan.item(k); 
		 	                         subXmlElData  = (Element) subXmlItemData;
		 	                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
		 	                         
		 	                         
		 	                        if (strDatCd.equals("G0013")) { //if strDatCd  = 'G02' then
		 	                        	
		 	                        	String str1DecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
		 		                 		
		 	                        	//2016년도 추가공제율 상반기
		 	                        	if (strResid.equals(str1DecValue)) { 
		                                	  edETAD_D16L =  edETAD_D16L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("first_year_tot_amt"),"0")));
		 	                         	}
		 	                        	
		                                  if ((subXmlElData.getAttribute("use_place_cd")).equals("1") )  { 
		                                  
		                                      edETCH_UEAM = edETCH_UEAM.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                                      

		                                      arrMONI_PAY[ddCnt][1]   =  String.valueOf(new BigDecimal(arrMONI_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                         //floattostr(strtofloat(arrMONI_PAY[ddCnt][1]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                                  else  if ((subXmlElData.getAttribute("use_place_cd")).equals("2") )  { 
		                                  
		                                       edETCH_MGVD = edETCH_MGVD.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));  
		                                       
		                                      arrMONI_PAY[ddCnt][2]   =  String.valueOf(new BigDecimal(arrMONI_PAY[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
		                                      //floattostr(strtofloat(arrMONI_PAY[ddCnt][2]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                                   else  if ((subXmlElData.getAttribute("use_place_cd")).equals("3") )  { 
		                                 
		                                      edETCH_BCED = edETCH_BCED.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));  
		                                      arrMONI_PAY[ddCnt][3]   =  String.valueOf(new BigDecimal(arrMONI_PAY[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		//  floattostr(strtofloat(arrMONI_PAY[ddCnt][3]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                   }
		 	                        }
		 	                      
		 	                       }
		 	                      ddCnt = ddCnt + 1;
		  	                 }
	 
		                     // oraQryUpdate.ParamByName('ETCH_UEAM').AsFloat :=  edETCH_UEAM; 
		  	                 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
			                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
			                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
			                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
			                 
		                      yeta2000Vo.setEtchUeam(edETCH_UEAM);
			 	                 
			 	              yetaPayr1200Service.fnPayr06425_PAYR415_2016_07_Update(yeta2000Vo);
			 	                 
			 	                 
		                   //현금 영수증 종료
		                }
		                else if ((strFormCd.equals("G304Y"))  || (strFormCd.equals("G304M"))) {
		                	/**+++++++++++  직불카드 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		                	//    직불카드 시작
		                 //직불카드등  연간합계 G302M 월별 G03 직불카드 등 본인+가족
		                       strDatCd = "";
		                       ddCnt = 0;
		                       //인별 반복구간
		                       
		  	                 subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		  	                
		  	                 //인원별 반복구간
		  	                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
		   
		  		            	 
		  	                       subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
		  	                       subXmlElMan  = (Element) subXmlItemMan;
		  	                       
		  	                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
		  	                   
		  	                       String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			                 		
		                        if (strResid.equals(strDecValue)) { 
		                             
		                             //2014 년도 전체합계
		                        	edCARD_ET14 =  edCARD_ET14.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tot_amt"),"0") ));
	                                 //+ strtofloat(subXmlItemMan.Params.Values['ftyr_tot_amt']);
		                        	edCARD_ET14 =  edCARD_ET14.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_market_tot_amt"),"0") ));
	                                       //+ strtofloat(subXmlItemMan.Params.Values['ftyr_market_tot_amt']);
		                        	edCARD_ET14 =  edCARD_ET14.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tmoney_tot_amt"),"0") ));
	                                       ///+ strtofloat(subXmlItemMan.Params.Values['ftyr_tmoney_tot_amt']);
		                        	
	                                 //2014 년도 본인추가 공제율
		                        	edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tot_amt"),"0")  ));
		                        	edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_market_tot_amt"),"0")  )); 
	                                 		//+ strtofloat(subXmlItemMan.Params.Values['ftyr_market_tot_amt']);
		                        	edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tmoney_tot_amt"),"0")  ));
	                                 		//+ strtofloat(subXmlItemMan.Params.Values['ftyr_tmoney_tot_amt']);
		                    	   
		                    	     //2015 년도 전체합계
		                        	edCARD_ET15 =  edCARD_ET15.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tot_amt"),"0")  )); 
	                                 				//+ strtofloat(subXmlItemMan.Params.Values['pre_tot_amt']);
		                        	edCARD_ET15 =  edCARD_ET15.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_market_tot_amt"),"0")  )); 
	                                 				//+ strtofloat(subXmlItemMan.Params.Values['pre_market_tot_amt']);
		                        	edCARD_ET15 =  edCARD_ET15.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tmoney_tot_amt"),"0") )); 
	                                 				//+ strtofloat(subXmlItemMan.Params.Values['pre_tmoney_tot_amt']);
	                                 
	                                 //2015 이전년도 본인추가 공제율
//	                                 edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tot_amt"),"0") ));
//	                                 edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_market_tot_amt"),"0") )); 
//	                                 				//+ strtofloat(subXmlItemMan.Params.Values['pre_market_tot_amt']);
//	                                 edETAD_D14L =  edETAD_D14L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tmoney_tot_amt"),"0") )); 
	                                 				//+ strtofloat(subXmlItemMan.Params.Values['pre_tmoney_tot_amt']);
	                                 
//		                                  //이전년도 전체합계
//		                                  edCARD_ET13 :=  edCARD_ET13 + strtofloat(subXmlItemMan.Params.Values['pre_tot_amt']);
//		                                  edCARD_ET13 :=  edCARD_ET13 + strtofloat(subXmlItemMan.Params.Values['pre_market_tot_amt']);
//		                                  edCARD_ET13 :=  edCARD_ET13 + strtofloat(subXmlItemMan.Params.Values['pre_tmoney_tot_amt']);
//		                                  //이전년도 본인추가 공제율
//		                                  edETAD_DD13 :=  edETAD_DD13 + strtofloat(subXmlItemMan.Params.Values['pre_tot_amt']);
//		                                  edETAD_DD13 :=  edETAD_DD13 + strtofloat(subXmlItemMan.Params.Values['pre_market_tot_amt']);
//		                                  edETAD_DD13 :=  edETAD_DD13 + strtofloat(subXmlItemMan.Params.Values['pre_tmoney_tot_amt']);

		                        }
		                             
		                             arrBCBS_PAY[ddCnt][0]  = strResid;
		                             // 상품별 반복구간
		                             subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
		 	                        //상품별 반복구간
		 	                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
		 	                        
		 	                         subXmlItemData =  subXmlElChildMan.item(k); 
		 	                         subXmlElData  = (Element) subXmlItemData;
		 	                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
		 	                         
		 	                        if (strDatCd.equals("G0014")) { //  if strDatCd  = 'G03' then
		 	                        	
		 	                        	 String str2DecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
		 		                 		
		 	                        	//2016년도 추가공제율 상반기
		 	                        	if (strResid.equals(str2DecValue)) { 
		                                	  edETAD_D16L =  edETAD_D16L.add(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("first_year_tot_amt"),"0")));
		 	                         	}

		                                  if ((subXmlElData.getAttribute("use_place_cd")).equals("1") )  { 
		                                
		                                      edETCH_BCBS = edETCH_BCBS.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
		                                      
		                                      arrBCBS_PAY[ddCnt][1]   = String.valueOf(new BigDecimal(arrBCBS_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
		                                    		  //floattostr(strtofloat(arrBCBS_PAY[ddCnt][1]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                                  else  if ((subXmlElData.getAttribute("use_place_cd")).equals("2") )  { 
		                                 
		                                      edETCH_MGVD = edETCH_MGVD.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));  
		                                      
		                                      arrBCBS_PAY[ddCnt][2]   =  String.valueOf(new BigDecimal(arrBCBS_PAY[ddCnt][2]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));  
		                                      //floattostr(strtofloat(arrBCBS_PAY[ddCnt][2]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                                  else  if ((subXmlElData.getAttribute("use_place_cd")).equals("3") )  { 
		                                 
		                                      edETCH_BCED = edETCH_BCED.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                                      
		                                      arrBCBS_PAY[ddCnt][3]   =  String.valueOf(new BigDecimal(arrBCBS_PAY[ddCnt][3]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                      //floattostr(strtofloat(arrBCBS_PAY[ddCnt][4]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		 	                        }
		 	                      
		 	                       }
		 	                      ddCnt = ddCnt + 1;
		  	                 }
		                      

		                    //  oraQryUpdate.ParamByName('ETCH_BCBS').AsFloat :=  edETCH_BCBS;
		  	               yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
			                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
			                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
			                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
			                 
		                      
		                      yeta2000Vo.setEtchBcbs(edETCH_BCBS);
			 	                 
			 	              yetaPayr1200Service.fnPayr06425_PAYR415_2016_08_Update(yeta2000Vo);
			 	              
			 	              
		                    //직불카드 종료
		                }
		                else if ((strFormCd.equals("J101Y")) || (strFormCd.equals("J101M")))  {
		                	/**+++++++++++  주책 임차 차입금 원리금 상환 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		              
		                   //  주책 임차 차입금 원리금 상환 시작
		                   //주택임차차입금 원리금상환액 J101Y 연간합계 J101M 월별 J01 주택임차차입금 원리금 본인
		                      strDatCd = "";
		                        // 인별 반복구간
		                      
		 	                 subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		 	                
		 	                 //인원별 반복구간
		 	                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
		  
		 		            	 
		 	                       subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
		 	                       subXmlElMan  = (Element) subXmlItemMan;
		 	                       
		 	                       strResid = subXmlElMan.getAttribute("resid");   //주민번호

		 	                      subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			                        //상품별 반복구간
			                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
			                        
			                         subXmlItemData =  subXmlElChildMan.item(k); 
			                         subXmlElData  = (Element) subXmlItemData;
			                         strDatCd = subXmlElData.getAttribute("dat_cd"); 

		                               if (strDatCd.equals("G0016")) {

		                                 edSpciRefn = edSpciRefn.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
		                                 // + strtofloat(subXmlItemData.NamedItem['sum'].Text);

		                               }
			                       }

		 	                 } 

		                     // oraQryUpdate.ParamByName('SPCI_REFN').AsFloat :=  edSpciRefn;
	  
		                      
		                     yeta2000Vo.setSpciRefn(edSpciRefn);
		 					 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
			                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
			                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
			                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
			                 
		 	                 yetaPayr1200Service.fnPayr06425_PAYR415_spciRefn_2016_Update(yeta2000Vo);
		 	                 
		 	                 
		                     //  주택 임차 차입금 원리금 상환 종료
		                }
		                else if ((strFormCd.equals("J203Y")) || (strFormCd.equals("J203M")))  {
		                	/**+++++++++++  장기 주택 차입금 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		                
		                  //  장기 주택 차입금 시작
		                  // 장기주택저당차입금 이자상환액 J203Y 연간합계 J203M 월별 J02 장기주택저당차입금 이자상환 본인
		                  //2010년:J201Y -> 2011년:J202Y -> 2012년:J203Y

		                     strDatCd = "";
		                       // 인별 반복구간
		                     subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		 	                
			                 //인원별 반복구간
			                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 

			                	   subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			                       subXmlElMan  = (Element) subXmlItemMan;
			                       
			                       strResid = subXmlElMan.getAttribute("resid");   //주민번호

			                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			                        //상품별 반복구간
			                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
			                        
			                         subXmlItemData =  subXmlElChildMan.item(k); 
			                         subXmlElData  = (Element) subXmlItemData;
			                         strDatCd = subXmlElData.getAttribute("dat_cd"); 

		                               if (strDatCd.equals("G0017")) {

		                                 if ((  (PkgFuncUtils.getXmlTagValue("start_dt", subXmlElData)).compareTo("20120101") < 0) 
		                                		 && (( (new BigDecimal(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData))).compareTo(new BigDecimal("0")) >= 0) 
		                                	 	&& ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData))).compareTo(new BigDecimal("15")) < 0) 
		                                		 )) {
		                                 //’11년도 이전 차입분으로 상환기간 15년 미만인
		                                   edSpchRe06  = edSpchRe06.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                                		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                 }
		                                 else if  (((PkgFuncUtils.getXmlTagValue("start_dt", subXmlElData)).compareTo("20120101") < 0) 
		                                		 && (( (new BigDecimal(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData))).compareTo(new BigDecimal("15")) >= 0)   
		                                				 && ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData))).compareTo(new BigDecimal("29")) < 0)   )) {
		                                 //’11년도 이전 차입분으로 다음에 해당하는 경우 공제한도는 연 1,000만원을 적용함
		                                 //- 상환기간 15년 이상 29년 미만인 경우
		                                   edSpchRe10   = edSpchRe10.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                                		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                 }
		                                 else if  (((PkgFuncUtils.getXmlTagValue("start_dt", subXmlElData)).compareTo("20120101") < 0)   
		                                	    && ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData))).compareTo(new BigDecimal("30")) >= 0)) {
		                                 // ’11년도 이전 차입분으로 상환기간 30년 이상인 경우 
		                                   edSpchRe15   = edSpchRe15.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
		                                		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                 } 
		                                 else if  (((PkgFuncUtils.getXmlTagValue("start_dt", subXmlElData)).compareTo("20150101") < 0) 
		                                	        &&  ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData))).compareTo(new BigDecimal("15")) >= 0))  {
		                                  
		                                	 if (( (new BigDecimal(PkgFuncUtils.getXmlTagValue("fixed_rate_debt", subXmlElData))).compareTo(BigDecimal.ZERO) > 0)  
		                                		  ||  ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("not_defer_debt", subXmlElData))).compareTo(BigDecimal.ZERO) > 0)) {
		                                       //’12.1.1 이후 신규 차입분(차입금 상환기간 연장 포함)으로서 상환기간이 15년 이상인 차입금
		                                       edSPCH_REFX   = edSPCH_REFX.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                                    		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                	 }
		                                    else
		                                    {
		                                       //’12.1.1 이후 신규 차입분(차입금 상환 기간 연장 포함)으로서 상환기간이 15년 이상이고
		                                       edSPCH_REEC    = edSPCH_REEC.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
		                                    		   
		                                    		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                    }

		                                 }
		                                 else if  (((PkgFuncUtils.getXmlTagValue("start_dt", subXmlElData)).compareTo("20150101") >= 0)  
		                                	        && ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData))).compareTo(new BigDecimal("15")) >= 0)) {
		                                	   
		                                   if ( ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("fixed_rate_debt", subXmlElData))).compareTo(BigDecimal.ZERO) > 0)  
	                               		     &&  ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("not_defer_debt", subXmlElData))).compareTo(BigDecimal.ZERO) > 0)) {
		                                	 
		                                       //’15.1.1 이후 신규 차입분(차입금 상환기간 연장 포함)으로서 상환기간이 15년 이상인 차입금 중 고정금리이면서, 비거치상환대출
		                                       edSPCH_15FX   = edSPCH_15FX.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
		                                    		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                    } else  if  (( (new BigDecimal(PkgFuncUtils.getXmlTagValue("fixed_rate_debt", subXmlElData))).compareTo(BigDecimal.ZERO) > 0)  
	                               		     ||  ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("not_defer_debt", subXmlElData))).compareTo(BigDecimal.ZERO) > 0)) {
		                                	 
		                                       //’15.1.1 이후 신규 차입분(차입금 상환기간 연장 포함)으로서 상환기간이 15년 이상인 차입금 중 고정금리이거나 비거치상환대출
		                                       edSPCH_15FB  = edSPCH_15FB.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                                    		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                    }
		                                    else
		                                    {
		                                       //’15.1.1 이후 신규 차입분(차입금 상환 기간 연장 포함)으로서 상환기간이 15년 이상이고 기타대출
		                                       edSPCH_15EC    = edSPCH_15EC.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                                    		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                    }

		                               }
		                                 else if  (((PkgFuncUtils.getXmlTagValue("start_dt", subXmlElData)).compareTo("20150101") >= 0)  
		                                		    &&  (( (new BigDecimal(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData))).compareTo(new BigDecimal("10")) >= 0) 
		                                		    		  && ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData))).compareTo(new BigDecimal("15")) < 0)))  {
		                                 //’15.1.1 이후 차입분으로 다음에 해당하는 경우 공제한도는 연 300만원을 적용함
		                                 //- 상환기간 10년 이상 15년 미만인 경우
		                                   if  (( (new BigDecimal(PkgFuncUtils.getXmlTagValue("fixed_rate_debt", subXmlElData))).compareTo(BigDecimal.ZERO) > 0)  
		                	                                		  ||  ( (new BigDecimal(PkgFuncUtils.getXmlTagValue("not_defer_debt", subXmlElData))).compareTo(BigDecimal.ZERO) > 0)) { 
		                                       //’12.1.1 이후 신규 차입분(차입금 상환기간 연장 포함)으로서 상환기간이 15년 이상인 차입금 중 고정금리이거나 비거치상환대출
		                                       edSPCH_10FB   = edSPCH_10FB.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                                       // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                   }
		                                     
		                               }
			                       }

			                 }
		                }
	 

//		                      oraQryUpdate.ParamByName('SPCH_RE06').AsFloat :=  edSpchRe06;
//		                      oraQryUpdate.ParamByName('SPCH_RE10').AsFloat :=  edSpchRe10;
//		                      oraQryUpdate.ParamByName('SPCH_RE20').AsFloat :=  edSpchRe15;
//		                      oraQryUpdate.ParamByName('SPCH_REEC').AsFloat :=  edSPCH_REEC;
//		                      oraQryUpdate.ParamByName('SPCH_REFX').AsFloat :=  edSPCH_REFX;
			                    yeta2000Vo.setSpchRe06(edSpchRe06);  // 특별공제_11년 이전 장기주택저당차입금15년 ~ 29년
		                        yeta2000Vo.setSpchRe10(edSpchRe10);  // 특별공제_11년 이전 장기주택저당차입금15년 ~ 29년
		                        yeta2000Vo.setSpchRe20(edSpchRe15);  // 특별공제_11년 이전 장기주택저당차입금30년 이상
		                        yeta2000Vo.setSpchReec(edSPCH_REEC); // 특별공제_12장기주택저당차입금_기타
		                        yeta2000Vo.setSpchRefx(edSPCH_REFX); // 특별공제_12장기주택저당차입금_고정 (고정금리이거나, 비거치상환대출)
		                        yeta2000Vo.setSpch15fx(edSPCH_15FX); // 특별공제_15장기주택저당_15고정AND 비거치상환
		                        yeta2000Vo.setSpch15fb(edSPCH_15FB); // 특별공제_15장기주택저당_15고정OR 비거치상환 
		                        yeta2000Vo.setSpch15ec(edSPCH_15EC); // 특별공제_15장기주택저당_15기타대출
		                        yeta2000Vo.setSpch10fb(edSPCH_10FB); // 특별공제_15장기주택저당_10고정 OR 비거치상환
		                        
		   					 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
			                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
			                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
			                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
		                        
		 	                    yetaPayr1200Service.fnPayr06425_PAYR415_2016_01_Update(yeta2000Vo); 
	 
			 	                 
			 	                 
		                    // 장기주택 저당 차입금 이자상환액 종료
		                }
		                else if ((strFormCd.equals("J301Y"))  ||  (strFormCd.equals("J301M")))  {
		                	/**+++++++++++   주택마련 저축 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		                
		                  //  주택마련 저축 시작
		                   //주택마련저축 J301Y 연간합계 J301M 월별 J03 주택마련저축 본인
		                  // Y0040050	B011	0050	청약저축					31
		                   //Y0040060	B011	0060	주택청약종합저축       					32
		                   //Y0040080	B011	0080	근로자주택마련저축     					34
		                    strDatCd = "";

		                    InfcPkgYeta3100VO yetaPrc3100Vo = new InfcPkgYeta3100VO();
			                   
			                   yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
			                   yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
			                   yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
			                   yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
			                   yetaPrc3100Vo.setImdeGbcd("Y0040050");    /** column 소득공제구분코드 : imdeGbcd */
			                   
			                   yetaPayr1200Service.fnPayr06430_Payr418_2015_Delete(yetaPrc3100Vo);
			                    
			                   
			                   yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
			                   yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
			                   yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
			                   yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
			                   yetaPrc3100Vo.setImdeGbcd("Y0040060");    /** column 소득공제구분코드 : imdeGbcd */
			                   
			                   yetaPayr1200Service.fnPayr06430_Payr418_2015_Delete(yetaPrc3100Vo);
			                   
			                  
			                   
			                   yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
			                   yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
			                   yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
			                   yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
			                   yetaPrc3100Vo.setImdeGbcd("Y0040080");    /** column 소득공제구분코드 : imdeGbcd */
			                   
			                   yetaPayr1200Service.fnPayr06430_Payr418_2015_Delete(yetaPrc3100Vo);
			                   
		                  
			                   subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
				                
				                 //인원별 반복구간
				                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
			 
					            	 
				                       subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
				                       subXmlElMan  = (Element) subXmlItemMan;
				                       
				                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
				                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
				                        //상품별 반복구간
				                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
				                        
				                         subXmlItemData =  subXmlElChildMan.item(k); 
				                         subXmlElData  = (Element) subXmlItemData;
				                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
				                         
				                           if (strDatCd.equals("G0018")) {
				                        	   {
				                        		   String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
				   		                 		
				                        		   if (strResid.equals(strDecValue)) { 
			
						                                if ((PkgFuncUtils.getXmlTagValue("saving_gubn", subXmlElData)).equals("1"))  {
						                                    // Y0040050	B011	0050	청약저축					31
						                                      edETCS_COMP = edETCS_COMP.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
						                                      //+   strtofloat(subXmlItemData.NamedItem['sum'].Text);
						                                }
						                                else  if ((PkgFuncUtils.getXmlTagValue("saving_gubn", subXmlElData)).equals("2"))  {
						                                  //Y0040060	B011	0060	주택청약종합저축       					32
						                                   edETWK_HSBM = edETWK_HSBM.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
						                                   // +   strtofloat(subXmlItemData.NamedItem['sum'].Text);
						                                }
						                                else  if ((PkgFuncUtils.getXmlTagValue("saving_gubn", subXmlElData)).equals("4"))  {
						                               
						                                   edETWK_HSVM = edETWK_HSVM.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));
						                                      //+   strtofloat(subXmlItemData.NamedItem['sum'].Text);
						                                  //Y0040080	B011	0080	근로자주택마련저축     					34
						                                }
						                                // ETCS_COMP	72			Y	NUMBER (12)	0	기타공제_주택마련저축_청약저축	No
						                                // ETWK_HSVM	73			Y	NUMBER (12)	0	기타공제_주택마련저축_근로자주택마련저축	No
						                                // ETWK_HSBM	74			Y	NUMBER (12)	0	기타공제_주택마련저축_주택청약종합저축	No
						                                // ETWK_HLGM	75			Y	NUMBER (12)	0	기타공제_주택마련저축_장기주택마련저축	No
					 
						                                yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
						        	                     yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
						        	                    yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
						        	                    yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
					
						                                if ((PkgFuncUtils.getXmlTagValue("saving_gubn", subXmlElData)).equals("1"))  {
						                              
						                                    // Y0040050	B011	0050	청약저축					31  edETCS_COMP
						                                	  yetaPrc3100Vo.setImdeGbcd("Y0040050");    /** column 소득공제구분코드 : imdeGbcd */
								        	                    yetaPrc3100Vo.setImdeTxcd("31");    /** column 소득공제구분국세청코드 : imdeTxcd */
						                                     // oraQryInsert.ParamByName('IMDE_GBCD').AsString  :=  'Y0040050';
						                                     // oraQryInsert.ParamByName('IMDE_TXCD').AsString := '31';
					
						                                }
						                                else  if  ((PkgFuncUtils.getXmlTagValue("saving_gubn", subXmlElData)).equals("2"))  {
						                               
						                                  //Y0040060	B011	0060	주택청약종합저축       					32    edETWK_HSBM
						                                	  yetaPrc3100Vo.setImdeGbcd("Y0040060");    /** column 소득공제구분코드 : imdeGbcd */
								        	                    yetaPrc3100Vo.setImdeTxcd("32");    /** column 소득공제구분국세청코드 : imdeTxcd */
						                                     // oraQryInsert.ParamByName('IMDE_GBCD').AsString  :=  'Y0040060';
						                                     // oraQryInsert.ParamByName('IMDE_TXCD').AsString := '32';
					
						                                }
						                                else  if ((PkgFuncUtils.getXmlTagValue("saving_gubn", subXmlElData)).equals("4"))  {
						                               
						                                	  yetaPrc3100Vo.setImdeGbcd("Y0040080");    /** column 소득공제구분코드 : imdeGbcd */
								        	                    yetaPrc3100Vo.setImdeTxcd("34");    /** column 소득공제구분국세청코드 : imdeTxcd */
						                                     // oraQryInsert.ParamByName('IMDE_GBCD').AsString  :=  'Y0040080';
						                                     // oraQryInsert.ParamByName('IMDE_TXCD').AsString := '34';
					
						                                  //Y0040080	B011	0080	근로자주택마련저축     					34     edETWK_HSVM
						                                }
						  
						        	                  
														yetaPrc3100Vo.setFinaSeqn(BigDecimal.ZERO);    /** column 연금_저축일련번호 : finaSeqn */ 
														yetaPrc3100Vo.setFinaCode(PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관코드 : finaCode */
														yetaPrc3100Vo.setFinaName(subXmlElData.getAttribute("trade_nm") );    /** column 금융기관상호 : finaName */
														yetaPrc3100Vo.setAcntNumb(subXmlElData.getAttribute("acc_no") );    /** column 계좌번호 : acntNumb */
														yetaPrc3100Vo.setIcnmYear("");    /** column 납입연차 : icnmYear */
														yetaPrc3100Vo.setPaytAmnt(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));    /** column 불입금액 : paytAmnt */
														yetaPrc3100Vo.setDeduAmnt(BigDecimal.ZERO);    /** column 세액공제금액 : deduAmnt */
														
														yetaPrc3100Vo.setFinaTxcd( PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관국세청코드 : finaTxcd */
//														yetaPrc3100Vo.setKybdr(yeta3100Dto.getKybdr());    /** column 입력자 : kybdr */
//														yetaPrc3100Vo.setInptDt(yeta3100Dto.getInptDt());    /** column 입력일자 : inptDt */
//														yetaPrc3100Vo.setInptAddr(yeta3100Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//														yetaPrc3100Vo.setIsmt(yeta3100Dto.getIsmt());    /** column 수정자 : ismt */
//														yetaPrc3100Vo.setRevnDt(yeta3100Dto.getRevnDt());    /** column 수정일자 : revnDt */
//														yetaPrc3100Vo.setRevnAddr(yeta3100Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
														
														
						                              //  oraQryInsert.ParamByName('IMDE_GBNM').AsString := Cells[4,jRow];
//						                                oraQryInsert.ParamByName('FINA_CODE').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//						                                oraQryInsert.ParamByName('FINA_TXCD').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//						                                oraQryInsert.ParamByName('FINA_NAME').AsString := subXmlItemData.Params.Values['trade_nm'];
//						                                oraQryInsert.ParamByName('ACNT_NUMB').AsString := subXmlItemData.Params.Values['acc_no'];
//						                                oraQryInsert.ParamByName('ICNM_YEAR').AsString := '';
//						                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemData.NamedItem['sum'].Text;
//						                                oraQryInsert.ParamByName('DEDU_AMNT').AsString := '0';
														  yetaPayr1200Service.fnPayr06430_Payr418_2016_Insert(yetaPrc3100Vo);
			
				                        		   }
				                        	   }
				                           }
			
				                       }
				                    
				                 }  
			
				                     // oraQryUpdate.ParamByName('ETCS_COMP').AsFloat :=  edETCS_COMP;
				                     // oraQryUpdate.ParamByName('ETWK_HSBM').AsFloat :=  edETWK_HSBM;
				                     // oraQryUpdate.ParamByName('ETWK_HSVM').AsFloat :=  edETWK_HSVM;
			
				                      yeta2000Vo.setEtcsComp(edETCS_COMP);
				                      yeta2000Vo.setEtwkHsbm(edETWK_HSBM);
				                      yeta2000Vo.setEtwkHsvm(edETWK_HSVM);
				                      
				 					 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
					                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
					                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
					                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
				 	                 
				 	                 yetaPayr1200Service.fnPayr06425_PAYR415_2016_02_Update(yeta2000Vo);
				 	                 


		                }
		                else if  ((strFormCd.equals("J401Y")) || (strFormCd.equals("J401M")))  {
		                	/**+++++++++++   목돈 안드는 전세 이자상환액++++++++++++++++++++++++++++++++++++++++++++++++*/
		                	// 2014년 신규 추가 테이블필드 완료
		                   // 목돈 안드는 전세 이자상환액  - -J401Y 기본  J401M 월별 J04 목돈 안드는 전세이자상환액 본인
		                   // edMonyItre
		                	 subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		 	                
			                 //인원별 반복구간
			                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
		 
				            	 
			                       subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			                       subXmlElMan  = (Element) subXmlItemMan;

			                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			                        //상품별 반복구간
			                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
			                        
			                         subXmlItemData =  subXmlElChildMan.item(k); 
			                         subXmlElData  = (Element) subXmlItemData;
			                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
			                         
		                             if (strDatCd.equals("G0023")) {
		                           
		                              edMonyItre = edMonyItre.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                         // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                             }
			                       }

			                 }

		                      
		                      yeta2000Vo.setEtgdCtra(edMonyItre);
		 					  yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
			                  yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
			                  yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
			                  yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
			                  
		 	                  yetaPayr1200Service.fnPayr06425_PAYR415_2016_03_Update(yeta2000Vo);
		 	                 
		 	                 
		                }
		                else if (strFormCd.equals("K101M")) { //TODO 소상공인 로그 안나옴.
		                	/**+++++++++++   소상공인공제 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		                	//  소상공인공제 시작
		                   //소기업소상공인 공제부금 - - K101M 월별 K01 소기업소상공인공제부금 본인
		                   // 월별상세만존제   edEtchPrep
		                	 subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		 	                
			                 //인원별 반복구간
			                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
		 

			                	 subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			                       subXmlElMan  = (Element) subXmlItemMan;
			                       
			                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			                        //상품별 반복구간
			                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
			                        
			                         subXmlItemData =  subXmlElChildMan.item(k); 
			                         subXmlElData  = (Element) subXmlItemData;
			                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
			                         
		                             if (strDatCd.equals("G0019")) {
		                            
		                              edEtchPrep = edEtchPrep.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                               // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                             // edEtchPrepStartDt = edEtchPrepStartDt.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("start_dt", subXmlElData)));   // TODO 공제가입일자
		                             // edEtchPrepEndDt = edEtchPrepEndDt.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));  // TODO 대상기간종료일/개정규칙 적용 신청여부
		                              
		                             }
			                       }

			                 }
			                 
		       

		                   //  oraQryUpdate.ParamByName('ETCH_PREP').AsFloat :=  ;
	 
		                     yeta2000Vo.setEtchPrep(edEtchPrep);
//		                     yeta2000Vo.setEdEtchPrepStartDt(edEtchPrepStartDt); //TODO 공제가입일자 VO 
//		                     yeta2000Vo.setEdEtchPrepEndDt(edEtchPrepEndDt); // TODO 대상기간종료일/개정규칙 적용 신청여부
		                     
							 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
			                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
			                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
			                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
			                 
			                 yetaPayr1200Service.fnPayr06425_PAYR415_2016_04_Update(yeta2000Vo);
			                 
		                }
		                else if ((strFormCd.equals("L102Y"))    ||  (strFormCd.equals("L102D"))) {
		                	/**+++++++++++    기부금시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		                	//  기부금시작
		                     // 기부금 L101Y 연간합계 L101D 일별 L01 기부금 본인+가족
		                     //  arrSPCI_PAY   : array[1..10] of array[1..10] of string;
		                     //edSpciFbam, edSpciPltc,edSpciExam,edSpciUnon, edSpciNamt, edSpciYamt, edSPCI_HFAM

		                       strDatCd = "";
		                       ddCnt = 0; 
		  	              
		                       subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		  	                
		  	                 //인원별 반복구간
		  	                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
		   
		  	                   subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
		                       subXmlElMan  = (Element) subXmlItemMan;
		                       
		                       strResid = subXmlElMan.getAttribute("resid");   //주민번호

		                            
		                         arrSPCI_PAY[ddCnt][0]  = strResid;
		                             
		                             subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
		 	                        //상품별 반복구간
		 	                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
		 	                    	  ldCnt = 0;
		 	                         subXmlItemData =  subXmlElChildMan.item(k); 
		 	                         subXmlElData  = (Element) subXmlItemData;
		 	                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
		 	                          
		                               if (strDatCd.equals("G0020")) {
		                                         //  arrSPCI_PAY   : array[1..10] of array[1..10] of string;
		                                 //edSpciFbam, edSpciPltc,edSpciExam,edSpciUnon, edSpciNamt, edSpciYamt, edSPCI_HFAM
		                                  if ((subXmlElData.getAttribute("donation_cd")).equals("10")) { 
		                                	 
		                                      edSpciFbam = edSpciFbam.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                                      // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                      arrSPCI_PAY[ddCnt][1]   =  String.valueOf(new BigDecimal(arrSPCI_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                    		  //floattostr(strtofloat(arrSPCI_PAY[ddCnt][2]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                                  else  if ((subXmlElData.getAttribute("donation_cd")).equals("20")) { 
		                             
		                                      edSpciPltc = edSpciPltc.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                                      // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                      arrSPCI_PAY[ddCnt][1]   =   String.valueOf(new BigDecimal(arrSPCI_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                      //floattostr(strtofloat(arrSPCI_PAY[ddCnt][2]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                                  else  if ((subXmlElData.getAttribute("donation_cd")).equals("21")) {  
		                                	  edSpciPltc = edSpciPltc.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                                      // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                      arrSPCI_PAY[ddCnt][1]   =   String.valueOf(new BigDecimal(arrSPCI_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))));
		                                      //floattostr(strtofloat(arrSPCI_PAY[ddCnt][2]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                                  else  if ((subXmlElData.getAttribute("donation_cd")).equals("40")) { 
		                                   
		                                      edSpciNamt = edSpciNamt.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                                      // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                      arrSPCI_PAY[ddCnt][1]   =   String.valueOf(new BigDecimal(arrSPCI_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
		                                      //floattostr(strtofloat(arrSPCI_PAY[ddCnt][2]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                                  else  if ((subXmlElData.getAttribute("donation_cd")).equals("41")) { 
		                                  
		                                      edSpciYamt = edSpciYamt.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                                      // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                      arrSPCI_PAY[ddCnt][1]   =   String.valueOf(new BigDecimal(arrSPCI_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
		                                      //floattostr(strtofloat(arrSPCI_PAY[ddCnt][2]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                                  else  if ((subXmlElData.getAttribute("donation_cd")).equals("42")) { 
		                               
		                                      edSPCI_HFAM = edSPCI_HFAM.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
		                                      // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		                                      arrSPCI_PAY[ddCnt][1]   =   String.valueOf(new BigDecimal(arrSPCI_PAY[ddCnt][1]).add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)))); 
		                                      //floattostr(strtofloat(arrSPCI_PAY[ddCnt][2]) + strtofloat(subXmlItemData.NamedItem['sum'].Text));
		                                  }
		                                  else  if ((subXmlElData.getAttribute("donation_cd")).equals("50")) { 
		                                 
		                                  }
		                                  if (strFormCd.equals("L102D")) {
		                                
		                                	  NodeList subXmlEldd =  subXmlElData.getElementsByTagName("amt");
		        	                        	 
		                                	  ldCnt = subXmlEldd.getLength();
		         	                             
		                                      if (ldCnt == 0) { ldCnt = 1;} 
		                                  }

		                                  InfcPkgYeta3180VO yetaPrc3180Vo =  new InfcPkgYeta3180VO();

											yetaPrc3180Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
											yetaPrc3180Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
											yetaPrc3180Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
											yetaPrc3180Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */

											String strEncValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
												
											yetaPrc3180Vo.setRsnoNumb(strEncValue);    /** column 주민등록번호 : rsnoNumb */
											yetaPrc3180Vo.setCtrbSeqn(BigDecimal.ZERO);    /** column 기부내역일련번호 : ctrbSeqn */
										 
	 
		                                   
		                                    yetaPrc3180Vo.setCtrbTycd(subXmlElData.getAttribute("donation_cd") );    /** column 기부유형코드 : ctrbTycd */
											yetaPrc3180Vo.setCtrbBsnu(subXmlElData.getAttribute("busnid"));    /** column 기부처사업자번호 : ctrbBsnu */
		                                   
		                                  // oraQryDelete.ParamByName('CTRB_BSNU').AsString := subXmlItemData.Params.Values['busnid']; //기부처사업자번호
		                                  // oraQryDelete.ParamByName('CTRB_TYCD').AsString := subXmlItemData.Params.Values['donation_cd'];      //기부유형코드

		                                   yetaPayr1200Service.fnPayr06430_PAYR440_2015_Delete(yetaPrc3180Vo);    //삭제  
		                                   

		                                   yetaPrc3180Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
											yetaPrc3180Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
											yetaPrc3180Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
											yetaPrc3180Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */
											yetaPrc3180Vo.setCtrbSeqn(BigDecimal.ZERO);    /** column 기부내역일련번호 : ctrbSeqn */
										 
		                                   
										     yetaPrc3180Vo.setCtrbYrmn((String) commandMap.get("srhClutYr"));    /** column 기부연도 : ctrbYrmn */
		                                     // oraQryInsert.ParamByName('CTRB_YRMN').AsString := lblEDAC_RVYY.Caption;      //기부연월- 기부년도
		                                      
		                                      
		                                      if ((subXmlElData.getAttribute("donation_cd")).equals("10")) { 
		                                      
		                                        yetaPrc3180Vo.setCtrbDdcd("B0230010");    /** column 기부유형구분코드 : ctrbDdcd */	
		                                        yetaPrc3180Vo.setCtrbTycd(subXmlElData.getAttribute("donation_cd"));    /** column 기부유형코드 : ctrbTycd */
		                                     
												
		                                          //oraQryInsert.ParamByName('CTRB_DDCD').AsString := 'B0230010';   //기부유형구분코드
		                                          //oraQryInsert.ParamByName('CTRB_TYCD').AsString := subXmlItemData.Params.Values['donation_cd'];        //기부유형코드
		                                      }
		                                      else  if ((subXmlElData.getAttribute("donation_cd")).equals("20")) { 
		                                    	  
		                                    	  
		                                    	   yetaPrc3180Vo.setCtrbDdcd("B0230020");    /** column 기부유형구분코드 : ctrbDdcd */	
			                                        yetaPrc3180Vo.setCtrbTycd(subXmlElData.getAttribute("donation_cd"));    /** column 기부유형코드 : ctrbTycd */
			                                        
		                                        //  oraQryInsert.ParamByName('CTRB_DDCD').AsString := '1';    //기부유형구분코드
		                                        //  oraQryInsert.ParamByName('CTRB_TYCD').AsString :=  subXmlItemData.Params.Values['donation_cd'];      //기부유형코드
		                                      }
		                                      else  if ((subXmlElData.getAttribute("donation_cd")).equals("21")) { 
		                                    	  yetaPrc3180Vo.setCtrbDdcd("B0230021");    /** column 기부유형구분코드 : ctrbDdcd */	
		                                    	  yetaPrc3180Vo.setCtrbTycd(subXmlElData.getAttribute("donation_cd"));    /** column 기부유형코드 : ctrbTycd */
		                                      }
		                                      else  if ((subXmlElData.getAttribute("donation_cd")).equals("40")) { 
		                                       
		                                    	   yetaPrc3180Vo.setCtrbDdcd("B0230040");    /** column 기부유형구분코드 : ctrbDdcd */	
			                                        yetaPrc3180Vo.setCtrbTycd(subXmlElData.getAttribute("donation_cd"));    /** column 기부유형코드 : ctrbTycd */
			                                        
		                                    	//  oraQryInsert.ParamByName('CTRB_DDCD').AsString := '2';     //기부유형구분코드
		                                        //  oraQryInsert.ParamByName('CTRB_TYCD').AsString := subXmlItemData.Params.Values['donation_cd'];      //기부유형코드
		                                      }
		                                      else  if ((subXmlElData.getAttribute("donation_cd")).equals("41")) { 
		                                         
		                                    	   yetaPrc3180Vo.setCtrbDdcd("B0230041");    /** column 기부유형구분코드 : ctrbDdcd */	
			                                        yetaPrc3180Vo.setCtrbTycd(subXmlElData.getAttribute("donation_cd"));    /** column 기부유형코드 : ctrbTycd */
			                                        
		                                    	//  oraQryInsert.ParamByName('CTRB_DDCD').AsString := '3';      //기부유형구분코드
		                                        //   oraQryInsert.ParamByName('CTRB_TYCD').AsString := subXmlItemData.Params.Values['donation_cd'];     //기부유형코드
		                                      }
		                                      else  if ((subXmlElData.getAttribute("donation_cd")).equals("42")) { 
		                                         
		                                    	   yetaPrc3180Vo.setCtrbDdcd("B0230042");    /** column 기부유형구분코드 : ctrbDdcd */	
			                                        yetaPrc3180Vo.setCtrbTycd(subXmlElData.getAttribute("donation_cd"));    /** column 기부유형코드 : ctrbTycd */
			                                        
		                                    	//  oraQryInsert.ParamByName('CTRB_DDCD').AsString := '4';     //기부유형구분코드
		                                        //  oraQryInsert.ParamByName('CTRB_TYCD').AsString :=  subXmlItemData.Params.Values['donation_cd'];      //기부유형코드
		                                      }
		                                      else  if ((subXmlElData.getAttribute("donation_cd")).equals("50")) { 
		                                         
		                                    	   yetaPrc3180Vo.setCtrbDdcd("B0230050");    /** column 기부유형구분코드 : ctrbDdcd */	
			                                        yetaPrc3180Vo.setCtrbTycd(subXmlElData.getAttribute("donation_cd"));    /** column 기부유형코드 : ctrbTycd */
			                                        
		                                    	//  oraQryInsert.ParamByName('CTRB_DDCD').AsString := '5';      //기부유형구분코드
		                                        //  oraQryInsert.ParamByName('CTRB_TYCD').AsString := subXmlItemData.Params.Values['donation_cd'];     //기부유형코드
		                                      }

		                                       
		                                    yetaPrc3180Vo.setCtrbBsnu(subXmlElData.getAttribute("busnid"));    /** column 기부처사업자번호 : ctrbBsnu */
		                                	yetaPrc3180Vo.setCtrbCont("");    /** column 기부내용 : ctrbCont */ 
											
		                                	yetaPrc3180Vo.setCtrbName(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("trade_nm")).substring(0, (MSFSharedUtils.allowNulls(subXmlElData.getAttribute("trade_nm")).length() < 48 ? 
		                                			  																MSFSharedUtils.allowNulls(subXmlElData.getAttribute("trade_nm")).length() :48)));    /** column 기부처명 : ctrbName */ 
											yetaPrc3180Vo.setCtrbTgam(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));    /** column 공제대상기부금액 : ctrbAmnt */
											yetaPrc3180Vo.setCtjaCham(new BigDecimal(PkgFuncUtils.getXmlTagValue("sbdy_apln_sum", subXmlElData)));	/** column 기부장려금신청금액 : ctjaCham */
											yetaPrc3180Vo.setCtrbAmnt(new BigDecimal(PkgFuncUtils.getXmlTagValue("conb_sum", subXmlElData)));	/** column 기부금액 : ctrbAmnt */
											
											//TODO 추가된 서식 : 기부장려금신청금액, 기부금액합계
											//yetaPrc3180Vo.setSbdyAplnSum(new BigDecimal(PkgFuncUtils.getXmlTagValue("sbdy_apln_sum", subXmlElData)));    /** column 기부장려금신청금액 : SbdyAplnSum */
											//yetaPrc3180Vo.setConbSum(new BigDecimal(PkgFuncUtils.getXmlTagValue("conb_sum", subXmlElData)));    /** column 기부금액합계 : ConbSum */
	 
											yetaPrc3180Vo.setCrtbCncd(strEncValue);    /** column 기부자관계구분코드 : crtbCncd */
											yetaPrc3180Vo.setCrnrFlag(strEncValue);    /** column 기부자내국인구분코드 : crnrFlag */
											yetaPrc3180Vo.setCbtgName(subXmlElMan.getAttribute("name"));    /** column 기부자성명 : cbtgName */ 
												
											yetaPrc3180Vo.setRsnoNumb(strEncValue);    /** column 주민등록번호 : rsnoNumb */
//											yetaPrc3180Vo.setCtrbCtnt(String.valueOf(ldCnt));    /** column 기부금유형콤보TEMP : ctrbCtnt */
											yetaPrc3180Vo.setCtrbNcnt(BigDecimal.valueOf(ldCnt));	/** column 기부금건수 : ctrbNcnt */
											yetaPrc3180Vo.setReceRati("0");    /** column 영수증유무 : receRati */
											yetaPrc3180Vo.setGuksYeno("Y");
//											yetaPrc3180Vo.setKybdr(yeta3180Dto.getKybdr());    /** column 입력자 : kybdr */
//											yetaPrc3180Vo.setInptDt(yeta3180Dto.getInptDt());    /** column 입력일자 : inptDt */
//											yetaPrc3180Vo.setInptAddr(yeta3180Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//											yetaPrc3180Vo.setIsmt(yeta3180Dto.getIsmt());    /** column 수정자 : ismt */
//											yetaPrc3180Vo.setRevnDt(yeta3180Dto.getRevnDt());    /** column 수정일자 : revnDt */
//											yetaPrc3180Vo.setRevnAddr(yeta3180Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
											
											
//		                                    oraQryInsert.ParamByName('CTRB_CONT').AsString := '';      //기부내용
//		                                    oraQryInsert.ParamByName('CTRB_NAME').AsString := copy(subXmlItemData.Params.Values['trade_nm'],1,46);      //기부처명
//		                                    oraQryInsert.ParamByName('CTRB_BSNU').AsString := subXmlItemData.Params.Values['busnid']; //기부처사업자번호
	//
//		                                    oraQryInsert.ParamByName('CRTB_CNCD').AsString := strResid;      //기부자관계구분코드
//		                                    oraQryInsert.ParamByName('CBTG_NAME').AsString := subXmlItemMan.Params.Values['name'];      // 기부자성명
//		                                    oraQryInsert.ParamByName('RSNO_NUMB').AsString := strResid; //주민등록번호
	//
	//
//		                                    oraQryInsert.ParamByName('CTRB_CTNT').AsString :=  inttostr(ldCnt) ;  //건수
//		                                    oraQryInsert.ParamByName('CTRB_AMNT').AsString :=  subXmlItemData.NamedItem['sum'].Text;//기부금액
	//
	//
//		                                    oraQryInsert.ParamByName('INPT_USID').AsString := '';
//		                                    oraQryInsert.ParamByName('INPT_ADDR').AsString := ''; 

		                                    yetaPayr1200Service.fnPayr06430_PAYR440_2015_1_Insert(yetaPrc3180Vo); 

		                               }
		                             
		 	                       }
		 	                       ddCnt = ddCnt + 1;
		  	                 }
//		  	                 InfcPkgYeta3180VO yetaPrc3180Vo =  new InfcPkgYeta3180VO();
//		  	                  
//							 yetaPrc3180Vo.setCtrbNcnt(ddCnt1);
//		  	                 yetaPrc3180Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
//							 yetaPrc3180Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
//							 yetaPrc3180Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
//							 yetaPrc3180Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */
		  	                 	
		  	                 
		  	                   yeta2000Vo.setSpciFbam(edSpciFbam);  //A01 특별공제_기부금_법정
		                       yeta2000Vo.setSpciPltc(edSpciPltc);  //A01 특별공제_기부금_정치10만초과대상금액
		                       yeta2000Vo.setSpciExam(edSpciExam);  //A01 특별공제_기부금_특례_공인법인신탁제외
		                       yeta2000Vo.setSpciUnon(edSpciUnon);  //A01 특별공제_기부금_공인법인신탁
		                       yeta2000Vo.setSpciNamt(edSpciNamt);  //A01 특별공제_기부금_종교단체외지정기부금
		                       yeta2000Vo.setSpciYamt(edSpciYamt);  //A01 특별공제_기부금_종교단체지정기부금
		                       yeta2000Vo.setSpciHfam(edSPCI_HFAM); //A01 특별공제_기부금_우리사주조합2015이후
		                       
		                       yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
				               yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
				               yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
				               yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
				                 
		  	                  
		  	                   yetaPayr1200Service.fnPayr06425_PAYR415_2016_10_Update(yeta2000Vo);

//		                       oraQryUpdate.ParamByName('SPCI_FBAM').AsFloat := edSpciFbam;
//		                       oraQryUpdate.ParamByName('SPCI_PLTC').AsFloat := edSpciPltc;
//		                       oraQryUpdate.ParamByName('SPCI_EXAM').AsFloat := edSpciExam;
//		                       oraQryUpdate.ParamByName('SPCI_UNON').AsFloat := edSpciUnon;
//		                       oraQryUpdate.ParamByName('SPCI_NAMT').AsFloat := edSpciNamt;
//		                       oraQryUpdate.ParamByName('SPCI_YAMT').AsFloat := edSpciYamt;
//		                       oraQryUpdate.ParamByName('SPCI_HFAM').AsFloat := edSPCI_HFAM;
	 
		                }
		                else if ((strFormCd.equals("N101Y"))  ||  (strFormCd.equals("N101M"))) {
		                	/**+++++++++++   장기집합 투자 증권 저축++++++++++++++++++++++++++++++++++++++++++++++++*/
		                	//  2014 년도 귀속
		                   //장기집합 투자 증권 저축
		                   //Y0040110	B011	0110	장기집합투자증권저축					51
		                    strDatCd  = "";

		                    
		                       InfcPkgYeta3100VO yetaPrc3100Vo = new InfcPkgYeta3100VO();
			                   
			                   yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
			                   yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
			                   yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
			                   yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
			                   yetaPrc3100Vo.setImdeGbcd("Y0040110");    /** column 소득공제구분코드 : imdeGbcd */
			                   
			                   yetaPayr1200Service.fnPayr06430_Payr418_2015_Delete(yetaPrc3100Vo);
			                   
		                    

//		                    oraQryDelete.ParamByName('EDAC_RVYY').AsString :=  lblEDAC_RVYY.Caption;
//		                    oraQryDelete.ParamByName('SETT_GBCD').AsString :=  lblSETT_GBCD.Caption;
//		                    oraQryDelete.ParamByName('PSNL_NUMB').AsString :=  lblPSNL_NUMB.Caption;
//		                    oraQryDelete.ParamByName('IMDE_GBCD').AsString := 'B0110110';   //	장기집합투자증권저축
	 
			                   subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
				                
				                 //인원별 반복구간
				                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
			 
					            	 
				                       subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
				                       subXmlElMan  = (Element) subXmlItemMan;
				                       
				                       strResid = subXmlElMan.getAttribute("resid");   //주민번호
				                       
				                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
				                        //상품별 반복구간
				                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
				                        
				                         subXmlItemData =  subXmlElChildMan.item(k); 
				                         subXmlElData  = (Element) subXmlItemData;
				                         strDatCd = subXmlElData.getAttribute("dat_cd"); 

				                 		 String strDecValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
				                 		
				                         if (strDatCd.equals("G0029")) {
				                           
				                        	   if (strResid.equals(strDecValue)) { 
			
				                                //Y0040110	B011	0110	장기집합투자증권저축					51
				                                edETEP_SEST = edETEP_SEST.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
				                                        // +   strtofloat(subXmlItemData.NamedItem['sum'].Text);
			
			  
			
				                               yetaPrc3100Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
				     		                   yetaPrc3100Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
				     		                   yetaPrc3100Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
				     		                   yetaPrc3100Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */ 
				        	                    
				        	                    
				                                //B0110110	B011	0110	장기집합투자증권저축					51
				        	                    yetaPrc3100Vo.setImdeGbcd("Y0040110");    /** column 소득공제구분코드 : imdeGbcd */
				        	                    yetaPrc3100Vo.setImdeTxcd("51");    /** column 소득공제구분국세청코드 : imdeTxcd */
				        	                    
				                               // oraQryInsert.ParamByName('IMDE_GBCD').AsString :=  'Y0040110';
				                               // oraQryInsert.ParamByName('IMDE_TXCD').AsString := '51';
			
			
			
				                              //  oraQryInsert.ParamByName('IMDE_GBNM').AsString := Cells[4,jRow];
//				                                oraQryInsert.ParamByName('FINA_CODE').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//				                                oraQryInsert.ParamByName('FINA_TXCD').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//				                                oraQryInsert.ParamByName('FINA_NAME').AsString := subXmlItemData.Params.Values['trade_nm'];
//				                                oraQryInsert.ParamByName('ACNT_NUMB').AsString := subXmlItemData.Params.Values['secu_no'];
//			
//				                                oraQryInsert.ParamByName('ICNM_YEAR').AsString := '';
				                                
//				                               { subXmlItemDD :=  subXmlItemData.NamedItem['sum'];
//				                                if strtofloat(subXmlItemDD.Params.Values['sum_y1']) > 0 then
//				                                begin
//				                                  oraQryInsert.ParamByName('ICNM_YEAR').AsString := '1';
//				                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemDD.Params.Values['sum_y1'];
//				                                end
//				                                else if strtofloat(subXmlItemDD.Params.Values['sum_y2']) > 0 then
//				                                begin
//				                                  oraQryInsert.ParamByName('ICNM_YEAR').AsString := '2';
//				                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemDD.Params.Values['sum_y2'];
//				                                end
//				                                else if strtofloat(subXmlItemDD.Params.Values['sum_y3']) > 0 then
//				                                begin
//				                                  oraQryInsert.ParamByName('ICNM_YEAR').AsString := '3';
//				                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemDD.Params.Values['sum_y3'];
//				                                end ;  }
			
				                               // oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemData.NamedItem['sum'].Text;
				                               // oraQryInsert.ParamByName('DEDU_AMNT').AsString := subXmlItemData.NamedItem['ddct_bs_ass_amt'].Text;
			  
												yetaPrc3100Vo.setFinaSeqn(BigDecimal.ZERO);    /** column 연금_저축일련번호 : finaSeqn */ 
												yetaPrc3100Vo.setFinaCode(PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관코드 : finaCode */
												yetaPrc3100Vo.setFinaName(subXmlElData.getAttribute("trade_nm") );    /** column 금융기관상호 : finaName */
												yetaPrc3100Vo.setAcntNumb(subXmlElData.getAttribute("acc_no") );    /** column 계좌번호 : acntNumb */
												yetaPrc3100Vo.setIcnmYear("");    /** column 납입연차 : icnmYear */
												yetaPrc3100Vo.setPaytAmnt(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData)));    /** column 불입금액 : paytAmnt */
												yetaPrc3100Vo.setDeduAmnt(new BigDecimal(PkgFuncUtils.getXmlTagValue("ddct_bs_ass_amt", subXmlElData)));    /** column 세액공제금액 : deduAmnt */
												
												yetaPrc3100Vo.setFinaTxcd( PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData));    /** column 금융기관국세청코드 : finaTxcd */
//												yetaPrc3100Vo.setKybdr(yeta3100Dto.getKybdr());    /** column 입력자 : kybdr */
//												yetaPrc3100Vo.setInptDt(yeta3100Dto.getInptDt());    /** column 입력일자 : inptDt */
//												yetaPrc3100Vo.setInptAddr(yeta3100Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//												yetaPrc3100Vo.setIsmt(yeta3100Dto.getIsmt());    /** column 수정자 : ismt */
//												yetaPrc3100Vo.setRevnDt(yeta3100Dto.getRevnDt());    /** column 수정일자 : revnDt */
//												yetaPrc3100Vo.setRevnAddr(yeta3100Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
				 
	 

					                            yetaPayr1200Service.fnPayr06430_Payr418_2016_Insert(yetaPrc3100Vo);

				                        	   }
				                         }
				                       } 

				                 }
	 

		                    //  oraQryUpdate.ParamByName('ETEP_SEST').AsFloat :=  ;
	 
		                     yeta2000Vo.setEtepSest(edETEP_SEST);
		 					 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
			                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
			                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
			                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
		 	                
			                 yetaPayr1200Service.fnPayr06425_PAYR415_2016_05_Update(yeta2000Vo);
		 	                 
		                }else if (strFormCd.equals("O101M")) {
		                	/**+++++++++++   건강보험료 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		                	//  건강보험료 시작
		                	 subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		 	                
			                 //인원별 반복구간
			                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
		 

			                  	   subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			                       subXmlElMan  = (Element) subXmlItemMan;
			                       
			                       strResid = subXmlElMan.getAttribute("resid");   //주민번호

	         		
			                      // System.out.println("건강보험료 주민번호 ---  " + strResid);
			                       
			                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			                       //TODO subXmlElChildSum = subXmlElMan.getElementsByTagName("sum"); sum.getAttribute 가져오기 위해 선언
			                        //상품별 반복구간
			                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
			                        
			                         subXmlItemData =  subXmlElChildMan.item(k); 
			                         subXmlElData  = (Element) subXmlItemData;
			                         strDatCd = subXmlElData.getAttribute("dat_cd");
			                         
			                        // subXmlItemSum =  subXmlElChildSum.item(k);  TODO 건강보험료 sum 속성 가져오기 위해.
			                       //  subXmlElSum = (Element) subXmlItemSum; TODO 건강보험료 sum 속성 가져오기 위해.
			                         
		                             if (strDatCd.equals("G0030")) {
				                           
//		                            	 if (strResid.equals(commandMap.get("resnRegnNum"))) { 
		                            		 
			                            	 edSpciHhLh = edSpciHhLh.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
				                               // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
		//				                  	    strHiYrs = subXmlElSum.getAttribute("hi_yrs");
		//				                	    strItrmYrs = subXmlElSum.getAttribute("ltrm_yrs");
		//				                	    strHiNtf = subXmlElSum.getAttribute("hi_ntf");
		//				                	    strItrmNtf = subXmlElSum.getAttribute("ltrm_ntf");
		//				                	    strHiPmt = subXmlElSum.getAttribute("hi_pmt");
		//				                	    strItrmPmt = subXmlElSum.getAttribute("ltrm_pmt");
//		                            	 	 }
			                             }
				                     }
				                 }
			                 
				                 InfcPkgYeta3220VO yetaPrc3220Vo = new InfcPkgYeta3220VO();
				                 
				                 yetaPrc3220Vo.setInsuPayr(edSpciHhLh);

			                     String strEncValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			                   		        
				                 yetaPrc3220Vo.setRsnoNumb(strEncValue);    /** column 주민등록번호 : rsnoNumb */
				                 yetaPrc3220Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
				                 yetaPrc3220Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
				                 yetaPrc3220Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
				                 yetaPrc3220Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
				                 
				                 yetaPayr1200Service.fnPayr06425_PAYR415_2016_18_Update(yetaPrc3220Vo);
				                 
			                 	 yeta2000Vo.setSpciHhlh(edSpciHhLh);
			    				 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
				                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
				                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
				                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
				                 
				                 yetaPayr1200Service.fnPayr06425_PAYR415_2016_15_Update(yeta2000Vo);

			               }else if (strFormCd.equals("P101M")) {
				                	/**+++++++++++   국민연금보험료 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
				                	//  국민연금보험료 시작
				                	 subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
				 	                
					                 //인원별 반복구간
					                 for (int j = 0; j < subXmlElChildForm.getLength();j++) { 
				 

					                	 subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
					                       subXmlElMan  = (Element) subXmlItemMan;
					                       
					                       subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
					                       //TODO subXmlElChildSum = subXmlElMan.getElementsByTagName("sum"); sum.getAttribute 가져오기 위해 선언
					                        //상품별 반복구간
					                       for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
					                        
					                         subXmlItemData =  subXmlElChildMan.item(k); 
					                         subXmlElData  = (Element) subXmlItemData;
					                         strDatCd = subXmlElData.getAttribute("dat_cd"); 
					                         
					                         // subXmlItemSum =  subXmlElChildSum.item(k);  TODO 국민연금보험료 sum 속성 가져오기 위해.
						                       //  subXmlElSum = (Element) subXmlItemSum; TODO 국민연금보험료 sum 속성 가져오기 위해.
					                         
				                             if (strDatCd.equals("G0031")) {
				                            
				                            	 edJnatPsnf = edJnatPsnf.add(new BigDecimal(PkgFuncUtils.getXmlTagValue("sum", subXmlElData))); 
				                               // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
				                              
//				                                strNtf = subXmlElSum.getAttribute("ntf"); 
//						                	    strPmt = subXmlElSum.getAttribute("pmt");
				                              
				                             }
					                       }

					                 }
					                 
					                 yeta2000Vo.setJnatPsnf(edJnatPsnf);
									 yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
					                 yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
					                 yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
					                 yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
					                 
					                 yetaPayr1200Service.fnPayr06425_PAYR415_2016_16_Update(yeta2000Vo);
					                 
				                }
	 
		                }
//		               { else if (strFormCd = 'M101Y') OR  (strFormCd = 'M101M') then
//		                begin
//		                  //  2014 년도 종료 
//		                   //장기주식형저축 M101Y 연간합계 M101M 월별 M01 장기주식형저축 본인
//		                   //B0110090	B011	0090	장기주식형저축					41
//		                    strDatCd := '';
	//
//		                    oraQryDelete.Close;
//		                    oraQryDelete.SQL.Clear;
//		                    oraQryDelete.SQL.Add(fnPayr06430_Payr418_2014_Delete);
//		                    oraQryDelete.SQL.Add(' AND  IMDE_GBCD =  :IMDE_GBCD  ');
	//
//		                    oraQryDelete.ParamByName('EDAC_RVYY').AsString :=  lblEDAC_RVYY.Caption;
//		                    oraQryDelete.ParamByName('SETT_GBCD').AsString :=  lblSETT_GBCD.Caption;
//		                    oraQryDelete.ParamByName('PSNL_NUMB').AsString :=  lblPSNL_NUMB.Caption;
//		                    oraQryDelete.ParamByName('IMDE_GBCD').AsString := 'B0110090';   //	장기주식형저축
	//
//		                    oraQryDelete.Execute;
	//
//		                   for j := 0 to subXmlItemForm.SubItemCount -1 do
//		                   begin
	//
//		                         subXmlItemMan :=  subXmlItemForm.SubItems[j];
//		                         strResid := subXmlItemMan.Params.Values['resid'];   //주민번호
//		                         for k := 0 to subXmlItemMan.SubItemCount -1 do
//		                         begin
//		                          subXmlItemData :=  subXmlItemMan.SubItems[k];
//		                          strDatCd := subXmlItemData.Params.Values['dat_cd'];
	//
//		                           if strDatCd  = 'M01' then
//		                           begin
//		                             if strResid = lblRS_NUMB.Caption then
//		                             begin
	//
	//
//		                                //B0110090	B011	0090	장기주식형저축					41	31
//		                                edETWK_HSVM := edETWK_HSVM +   strtofloat(subXmlItemData.NamedItem['sum'].Text);
	//
	//
//		                                 strSql := '  INSERT INTO PAYR418          ';
//		                                 strSql := strSql + '(                          ';
//		                                 strSql := strSql + '  PSNL_NUMB,               ';
//		                                 strSql := strSql + '  SETT_GBCD,               ';
//		                                 strSql := strSql + '  EDAC_RVYY,               ';
//		                                 strSql := strSql + '  IMDE_GBCD,               ';
//		                                 strSql := strSql + '  FINA_CODE,               ';
//		                                 strSql := strSql + '  FINA_NAME,               ';
//		                                 strSql := strSql + '  ACNT_NUMB,               ';
//		                                 strSql := strSql + '  ICNM_YEAR,               ';
//		                                 strSql := strSql + '  PAYT_AMNT,               ';
//		                                 strSql := strSql + '  DEDU_AMNT,               ';
//		                                 strSql := strSql + '  INPT_USID,               ';
//		                                 strSql := strSql + '  INPT_DATE,               ';
//		                                 strSql := strSql + '  INPT_ADDR,               ';
//		                                 strSql := strSql + '  IMDE_TXCD,               ';
//		                                 strSql := strSql + '  FINA_TXCD,               ';
//		                                 strSql := strSql + '  FINA_SEQN                ';
//		                                 strSql := strSql + ')                          ';
//		                                 strSql := strSql + 'VALUES (                   ';
//		                                 strSql := strSql + '  :PSNL_NUMB,              ';
//		                                 strSql := strSql + '  :SETT_GBCD,              ';
//		                                 strSql := strSql + '  :EDAC_RVYY,              ';
//		                                 strSql := strSql + '  :IMDE_GBCD,              ';
//		                                 strSql := strSql + '  (SELECT COMM_CODE FROM CMMN010 WHERE COMM_LGCD = ''B012'' AND  COMM_IT03 = :FINA_CODE),              ';
//		                                 strSql := strSql + '  :FINA_NAME,              ';
//		                                 strSql := strSql + '  :ACNT_NUMB,              ';
//		                                 strSql := strSql + '  :ICNM_YEAR,              ';
//		                                 strSql := strSql + '  :PAYT_AMNT,              ';
//		                                 strSql := strSql + '  :DEDU_AMNT,              ';
//		                                 strSql := strSql + '  :INPT_USID,              ';
//		                                 strSql := strSql + '  SYSDATE,                 ';
//		                                 strSql := strSql + '  :INPT_ADDR,              ';
//		                                 strSql := strSql + '  :IMDE_TXCD,              ';
//		                                 strSql := strSql + '  :FINA_TXCD,              ';
//		                                  strSql := strSql + '	  (SELECT (NVL(MAX(FINA_SEQN),0) +  1) AS PSNLNUMB   ';
//		                                     strSql := strSql + '	 FROM PAYR418  AA WHERE AA.EDAC_RVYY = :EDAC_RVYY AND AA.SETT_GBCD = :SETT_GBCD AND  AA.PSNL_NUMB = :PSNL_NUMB)  ';
//		                                 strSql := strSql + ')       ';
	//
//		                                oraQryInsert.Close;
//		                                oraQryInsert.SQL.Clear;
//		                                oraQryInsert.SQL.Add(strSql);
	//
	//
//		                                oraQryInsert.ParamByName('EDAC_RVYY').AsString :=  lblEDAC_RVYY.Caption;         //연말정산귀속년도';
//		                                oraQryInsert.ParamByName('SETT_GBCD').AsString :=   lblSETT_GBCD.Caption;   //정산구분코드';
//		                                oraQryInsert.ParamByName('PSNL_NUMB').AsString :=   lblPSNL_NUMB.Caption;   //단원번호';
	//
//		                                //B0110090	B011	0090	장기주식형저축					41
	//
//		                                oraQryInsert.ParamByName('IMDE_GBCD').AsString :=  'B0110090';
//		                                oraQryInsert.ParamByName('IMDE_TXCD').AsString := '41';
	//
	//
//		  
//		                              //  oraQryInsert.ParamByName('IMDE_GBNM').AsString := Cells[4,jRow];
//		                                oraQryInsert.ParamByName('FINA_CODE').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//		                                oraQryInsert.ParamByName('FINA_TXCD').AsString := subXmlItemData.NamedItem['com_cd'].Text;
//		                                oraQryInsert.ParamByName('FINA_NAME').AsString := subXmlItemData.Params.Values['trade_nm'];
//		                                oraQryInsert.ParamByName('ACNT_NUMB').AsString := subXmlItemData.Params.Values['acc_no'];
	//
	//
//		                                subXmlItemDD :=  subXmlItemData.NamedItem['sum'];
//		                                if strtofloat(subXmlItemDD.Params.Values['sum_y1']) > 0 then
//		                                begin
//		                                  oraQryInsert.ParamByName('ICNM_YEAR').AsString := '1';
//		                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemDD.Params.Values['sum_y1'];
//		                                end
//		                                else if strtofloat(subXmlItemDD.Params.Values['sum_y2']) > 0 then
//		                                begin
//		                                  oraQryInsert.ParamByName('ICNM_YEAR').AsString := '2';
//		                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemDD.Params.Values['sum_y2'];
//		                                end
//		                                else if strtofloat(subXmlItemDD.Params.Values['sum_y3']) > 0 then
//		                                begin
//		                                  oraQryInsert.ParamByName('ICNM_YEAR').AsString := '3';
//		                                oraQryInsert.ParamByName('PAYT_AMNT').AsString := subXmlItemDD.Params.Values['sum_y3'];
//		                                end ;
//		                                oraQryInsert.ParamByName('DEDU_AMNT').AsString := subXmlItemDD.Params.Values['ddct'];
	//
	//
//		                                oraQryInsert.ParamByName('INPT_USID').AsString := '';
//		                                oraQryInsert.ParamByName('INPT_ADDR').AsString := '';
	//
	//
//		                                oraQryInsert.Execute;
	//
//		                             end
//		                           end
//		                         end;
	//
//		                    end;
	//
//		                    
//		                      oraQryUpdate.Close;
//		                      oraQryUpdate.SQL.Clear;
	//
//		                      oraQryUpdate.SQL.Add('  UPDATE  PAYR415                ');
//		                      oraQryUpdate.SQL.Add('SET                              ');
//		                      oraQryUpdate.SQL.Add('  ETWK_HSVM = :ETWK_HSVM         ');
//		                      oraQryUpdate.SQL.Add('WHERE PSNL_NUMB = :PSNL_NUMB AND ');
//		                      oraQryUpdate.SQL.Add('  SETT_GBCD = :SETT_GBCD AND     ');
//		                      oraQryUpdate.SQL.Add('  EDAC_RVYY = :EDAC_RVYY   ');
	//
//		                      oraQryUpdate.ParamByName('ETWK_HSVM').AsFloat :=  edETWK_HSVM;
	//
//		                      oraQryUpdate.ParamByName('PSNL_NUMB').AsString := lblPSNL_NUMB.Caption;
//		                      oraQryUpdate.ParamByName('EDAC_RVYY').AsString := lblEDAC_RVYY.Caption;
//		                      oraQryUpdate.ParamByName('SETT_GBCD').AsString := lblSETT_GBCD.Caption;
	//
//		                      oraQryUpdate.Execute;
//		                end;   }

//		             }
		             
		           
	        	 
	         } catch(Exception e) {
	        	  e.printStackTrace();
	              System.out.println(e.toString());
	          }
	         
	         //교육비 저장 
	         InfcPkgYeta3150VO yetaPrc3150Vo =  new InfcPkgYeta3150VO(); 
                
//                yetaPrc3150Vo.setDpobCd(yeta2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//                yetaPrc3150Vo.setEdacRvyy(yeta2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
//                yetaPrc3150Vo.setSettGbcd(yeta2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
//                yetaPrc3150Vo.setSystemkey(yeta2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
				
	         yetaPrc3150Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
	         yetaPrc3150Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
	         yetaPrc3150Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
	         yetaPrc3150Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
                
                yetaPayr1200Service.fnPayr06430_PAYR445_2015_Delete(yetaPrc3150Vo);
                 
               
	         
	              for (int l= 0; l < arrPayr445.length - 1;l++) { 
	            	  
	                if (MSFSharedUtils.paramNotNull(arrPayr445[l][0])) {
	                	InfcPkgYeta3150VO yetaPrc315001Vo =  new InfcPkgYeta3150VO(); 
	                	 String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	                	 
		                yetaPrc315001Vo.setDpobCd((String) commandMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
		                yetaPrc315001Vo.setEdacRvyy((String) commandMap.get("srhClutYr"));    /** column 연말정산귀속년도 : edacRvyy */
		                yetaPrc315001Vo.setSettGbcd((String) commandMap.get("settGbcd"));    /** column 정산구분코드 : settGbcd */
		                yetaPrc315001Vo.setSystemkey((String) commandMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */   
		                yetaPrc315001Vo.setEdacDtnu(BigDecimal.ZERO);    /** column 교육비가족상세일련번호 : edacDtnu */
		                
		                yetaPrc315001Vo.setFmacGbcd(arrPayr445[l][1]);    /** column 가족학력구분코드 : fmacGbcd */
		                yetaPrc315001Vo.setEdacOtam(new BigDecimal(arrPayr445[l][2]));    /** column 교육비지급금액 : edacOtam */ 
		                String strEncValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(arrPayr445[l][0]).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
		                   
		                yetaPrc315001Vo.setRsnoNumb(strEncValue);
		                yetaPrc315001Vo.setGuksYeno("Y");
		                yetaPayr1200Service.fnPayr06430_PAYR445_1_2015_Insert(yetaPrc315001Vo);
		                 
		               //  oraQryInsert.ParamByName('FMAC_GBCD').AsString := arrPayr445[l][2];
		               //  oraQryInsert.ParamByName('EDAC_OTAM').AsString := arrPayr445[l][3];
		               //  oraQryInsert.ParamByName('RSNO_NUMB').AsString := arrPayr445[l][1];
	                }
	              }
	               
	              

	              for (int l= 0; l < arrPayr445.length;l++) { 
	            	  if (MSFSharedUtils.paramNotNull(arrPayr445[l][0])) {
		                 //특수  교육비
		                 edSpciScam  = edSpciScam.add(new BigDecimal(arrPayr445[l][3]));
	            	  }
	              }
	              //edSpciScam = edSpciScam.add(new BigDecimal(arrPayr445[9][3]));

	              for (int l= 0; l < arrPayr445.length;l++) { 
	            	  if (MSFSharedUtils.paramNotNull(arrPayr445[l][0])) { 
		                 if  (MSFSharedUtils.allowNulls(arrPayr445[l][1]).equals("Y0030010")) {
		              
		                       edSpedEdam  = edSpedEdam.add(new BigDecimal(arrPayr445[l][2]));
		                 }
		                 else if (MSFSharedUtils.allowNulls(arrPayr445[l][1]).equals("Y0030020")) {
		               
		                       edSpedGdam  = edSpedGdam.add(new BigDecimal(arrPayr445[l][2]));
		                 }
		                  else if (MSFSharedUtils.allowNulls(arrPayr445[l][1]).equals("Y0030030")) {
		                
		                        edSpedCvam  = edSpedCvam.add(new BigDecimal(arrPayr445[l][2]));
		                  }
	            	  }
	              }

//	             oraQryUpdate.ParamByName('SPED_SELF').AsFloat := edSpedSelf;
//	             oraQryUpdate.ParamByName('SPED_EDAM').AsFloat := edSpedEdam;
//	             oraQryUpdate.ParamByName('SPED_GDAM').AsFloat := edSpedGdam;
//	             oraQryUpdate.ParamByName('SPED_CVAM').AsFloat := edSpedCvam;
//	             oraQryUpdate.ParamByName('SPCI_SCAM').AsFloat := edSpciScam; 
	           
	              yeta2000Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
	              yeta2000Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
	              yeta2000Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
	              yeta2000Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
	                   
	              
	             yeta2000Vo.setSpedSelf(edSpedSelf); // 특별공제_교육비_본인
	             yeta2000Vo.setSpedEdam(edSpedEdam); // 특별공제_교육비_취학전아동
	             yeta2000Vo.setSpedGdam(edSpedGdam); // 특별공제_교육비_초중
	             yeta2000Vo.setSpedCvam(edSpedCvam); // 특별공제_교육비_대학교
	             yeta2000Vo.setSpciScam(edSpciScam); // 특별공제_장애인특수교육비

                 
                 yetaPayr1200Service.fnPayr06425_PAYR415_2016_11_Update(yeta2000Vo);
                 
	              
	              
	              //이전년도 및 해당년도 사용분 및  본인추가 공제 사용액 _신용카드 저장

//	              oraQryUpdate.ParamByName('CARD_ET13').AsFloat :=  edCARD_ET13;
//	              oraQryUpdate.ParamByName('CARD_ET14').AsFloat :=  edCARD_ET14;
//	              oraQryUpdate.ParamByName('ETAD_DD13').AsFloat :=  edETAD_DD13;
//	              oraQryUpdate.ParamByName('ETAD_D14L').AsFloat :=  edETAD_D14L;
//	              
//	              oraQryUpdate.ParamByName('CARD_ET15').AsFloat :=  edCARD_ET15;  //기타공제_본인신용카등사용액_2015	None	
//	              oraQryUpdate.ParamByName('ETAD_D15H').AsFloat :=  edETAD_D15H; //기타공제_본인추가공제율사용액2015상반기	None	
//	              oraQryUpdate.ParamByName('ETAD_D15L').AsFloat :=  edETAD_D15L; //기타공제_본인추가공제율사용액2015하반기	None
	             
//	              yeta2000Vo.setCardEt13(edCARD_ET13); //본인 신용카드 사용액 2013
	              yeta2000Vo.setCardEt14(edCARD_ET14); //본인 신용카드 사용액 2014
	              yeta2000Vo.setCardEt15(edCARD_ET15); //본인 신용카드 사용액 2015
	              
//	              yeta2000Vo.setEtadDd13(edETAD_DD13); //본인 추가공제율 사용액 2013
	              yeta2000Vo.setEtadD14l(edETAD_D14L); //본인 추가공제율 사용액 2014 
//	              yeta2000Vo.setEtadD15h(edETAD_D15H); //본인 추가공제율 사용액 2015 하반기
//	              yeta2000Vo.setEtadD15l(edETAD_D15L); //본인 추가공제율 사용액 2015 상반기
	              yeta2000Vo.setEtadD16l(edETAD_D16L); //본인 추가공제율 사용액 2016 상반기
	                 
	              yetaPayr1200Service.fnPayr06425_PAYR415_2016_12_Update(yeta2000Vo);

	               //-----------------
	               // 전통시장 비용 업데이트 

	           //   oraQryUpdate.ParamByName('ETCH_MGVD').AsFloat :=  edETCH_MGVD;

	              yeta2000Vo.setEtchMgvd(edETCH_MGVD); 
	              yetaPayr1200Service.fnPayr06425_PAYR415_2016_13_Update(yeta2000Vo);
	              
	               //대중교통 업데이트
	         
	             // oraQryUpdate.ParamByName('ETCH_BCED').AsFloat :=  edETCH_BCED;

	              yeta2000Vo.setEtchBced(edETCH_BCED); 
	              yetaPayr1200Service.fnPayr06425_PAYR415_2016_14_Update(yeta2000Vo);

	              //--------------------------------

	               // Payr410 업데이트 작업 ....
	               
	              InfcPkgYeta3220SrhVO yetaPrc3220SrhVo = new InfcPkgYeta3220SrhVO(); 
	              
	               
	               yetaPrc3220SrhVo.setDpobCd(yeta2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
	               yetaPrc3220SrhVo.setEdacRvyy(yeta2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
	               yetaPrc3220SrhVo.setSettGbcd(yeta2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
	               yetaPrc3220SrhVo.setSystemkey(yeta2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */  
	                
	               yetaPrc3220SrhVo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
	               yetaPrc3220SrhVo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
	               yetaPrc3220SrhVo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
	               yetaPrc3220SrhVo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
	                  
	  	         
	               List lisYetaPrc3220Vo = yetaPayr1200Service.fnPayr06430_PAYR410_2015_SelectAll(yetaPrc3220SrhVo);

	                
	               if  (lisYetaPrc3220Vo.size() > 0) {

                	   Iterator<Map<String, Object>> iter = lisYetaPrc3220Vo.iterator(); 
    	        	   
    		            while ( iter.hasNext() ) { 
    		            	
    		               Map<String, Object> mapYeta3220 = (Map<String, Object>) iter.next(); 
                          // for(int iCnt = 0; iCnt < listYetaGibu.size();iCnt++) {   
	                 
    		       		   //암호화 객체 생성
    		       		    String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    		       		

    		             	String str3220EncValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(mapYeta3220.get("rsnoNumb")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
    		           		   
    		             	String strEncValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(commandMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
    		           		   
    		               InfcPkgYeta3220VO yetaPrc3220Vo = new InfcPkgYeta3220VO(); 
	                  

							yetaPrc3220Vo.setDpobCd(yeta2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
							yetaPrc3220Vo.setEdacRvyy(yeta2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
							yetaPrc3220Vo.setSettGbcd(yeta2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
							yetaPrc3220Vo.setSystemkey(yeta2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
						
							yetaPrc3220Vo.setDpobCd((String) commandMap.get("dpobCd")); /** column 사업장코드 : dpobCd */
							yetaPrc3220Vo.setEdacRvyy((String) commandMap.get("srhClutYr")); /** column 귀속년도 : srhClutYr */
							yetaPrc3220Vo.setSettGbcd((String) commandMap.get("settGbcd")); /** column 연말정산구분코드 : settGbcd */
							yetaPrc3220Vo.setSystemkey((String) commandMap.get("systemkey")); /** column 시스템키 : systemkey */
							 
							//yetaPrc3220Vo.setRelhCode(yeta3220Dto.getRelhCode());    /** column 관계 : relhCode */
							//yetaPrc3220Vo.setKornName(yeta3220Dto.getKornName());    /** column 성명 : kornName */
							//yetaPrc3220Vo.setFrnrCode(yeta3220Dto.getFrnrCode());    /** column 내외국인구분코드 : frnrCode */
							//yetaPrc3220Vo.setBaseDdyn(yeta3220Dto.getBaseDdyn());    /** column 기본공제여부 : baseDdyn */
							//yetaPrc3220Vo.setPsclDdyn(yeta3220Dto.getPsclDdyn());    /** column 장애인공제여부 : psclDdyn */
							//yetaPrc3220Vo.setBrddCtyn(yeta3220Dto.getBrddCtyn());    /** column 자녀양육비공제여부 : brddCtyn */
							//yetaPrc3220Vo.setFaddCtyn(yeta3220Dto.getFaddCtyn());    /** column 부녀자공제여부 : faddCtyn */
							//yetaPrc3220Vo.setRpctDdyn(yeta3220Dto.getRpctDdyn());    /** column 경로우대공제여부 : rpctDdyn */
							//yetaPrc3220Vo.setBithDdyn(yeta3220Dto.getBithDdyn());    /** column 출산입양자공제여부 : bithDdyn */
							//yetaPrc3220Vo.setPantOnyn(yeta3220Dto.getPantOnyn());    /** column 한부모공제여부 : pantOnyn */
							
							 
	                     // oraQryUpdate.ParamByName('INSU_PAYR').AsString  :=  '0';   //건강.고용보험료_국세청';
//	                      oraQryUpdate.ParamByName('INSU_RTYR').AsString  :=  '0';   //보장성보험료_국세청';
//	                      oraQryUpdate.ParamByName('MEDI_COST').AsString  :=  '0';    //의료비_국세청';
//	                      oraQryUpdate.ParamByName('EDUC_COST').AsString  :=  '0';     //교육비_국세청';
//	                      oraQryUpdate.ParamByName('CDTE_CARD').AsString  :=  '0';    //신용카드등_국세청';
//	                      oraQryUpdate.ParamByName('JIBL_CARD').AsString  :=  '0';    //직불카드등_국세청';
//	                      oraQryUpdate.ParamByName('CASH_RECE').AsString  :=  '0';     //현금영수증_국세청';
//	                      oraQryUpdate.ParamByName('GRPY_AMNT').AsString  :=  '0';    //지로납부_국세청 - 대중교통 변경 ';
//	                      oraQryUpdate.ParamByName('MGNT_STVD').AsString  :=  '0';   //전통시장_국세청';
//	                      oraQryUpdate.ParamByName('CTRB_AMNT').AsString  :=   '0';    //기부금액_국세청';

				//		yetaPrc3220Vo.setInsuPayr(BigDecimal.ZERO);             //건강.고용보험료_국세청';
						yetaPrc3220Vo.setInsuRtyr(BigDecimal.ZERO);             //보장성보험료_국세청';
						yetaPrc3220Vo.setPsclIurr(BigDecimal.ZERO);             //장애인보장성보험료_국세청';
						yetaPrc3220Vo.setMediCost(BigDecimal.ZERO);              //의료비_국세청';
						yetaPrc3220Vo.setEducCost(BigDecimal.ZERO);               //교육비_국세청';
						yetaPrc3220Vo.setCdteCard(BigDecimal.ZERO);              //신용카드등_국세청';
						yetaPrc3220Vo.setJiblCard(BigDecimal.ZERO);              //직불카드등_국세청';
						yetaPrc3220Vo.setCashRece(BigDecimal.ZERO);               //현금영수증_국세청';
						yetaPrc3220Vo.setGrpyAmnt(BigDecimal.ZERO);              //지로납부_국세청 - 대중교통 변경 ';
						yetaPrc3220Vo.setMgntStvd(BigDecimal.ZERO);             //전통시장_국세청';
						yetaPrc3220Vo.setCtrbAmnt(BigDecimal.ZERO);               //기부금액_국세청';
							
	                      edCARD_MONI = BigDecimal.ZERO;
	                      edCARD_BCED = BigDecimal.ZERO;
	                  
	                   for (int ddCnt01 = 0; ddCnt01 < 10; ddCnt01++) { 
	                	   
	                	   if (MSFSharedUtils.paramNotNull(arrHDRC_PAY[ddCnt01][0])) {
	                			 
		                      if  (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrHDRC_PAY[ddCnt01][0])) { 
		                    		 
		                    	  yetaPrc3220Vo.setInsuRtyr(new BigDecimal(arrHDRC_PAY[ddCnt01][1]));    /** column 보장성보험료_국세청 : insuRtyr */
		                          // oraQryUpdate.ParamByName('INSU_RTYR').AsString  :=  floattostr(strtofloat(arrHDRC_PAY[ddCnt01][1]) + strtofloat(arrHDRC_PAY[ddCnt01][2]));    //보험료_국세청';
		                      }
	                	   }  
	                	   if (MSFSharedUtils.paramNotNull(arrHDRC_PAY[ddCnt01][0])) {
	                			 
			                      if  (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrHDRC_PAY[ddCnt01][0])) { 
			                    	  
			                    	  yetaPrc3220Vo.setPsclIurr(new BigDecimal(arrHDRC_PAY[ddCnt01][2]));    /** column 장애인보장성보험료_국세청 : psclIurr */
			                          // oraQryUpdate.ParamByName('INSU_RTYR').AsString  :=  floattostr(strtofloat(arrHDRC_PAY[ddCnt01][1]) + strtofloat(arrHDRC_PAY[ddCnt01][2]));    //보험료_국세청';
			                      }
		                	   } 
	                	   if (MSFSharedUtils.paramNotNull(arrCASH_PAY[ddCnt01][0])) {  
		                      if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrCASH_PAY[ddCnt01][0])) { 
		                   
		                    	    yetaPrc3220Vo.setMediCost(new BigDecimal(arrCASH_PAY[ddCnt01][1]));    /** column 의료비_국세청 : mediCost */
		                            //oraQryUpdate.ParamByName('MEDI_COST').AsString  :=  arrCASH_PAY[ddCnt01][1] ;    //의료비_국세청';
	
		                      }
	                	   }
	                	   if(MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(strEncValue)){
            				   
            				   yetaPrc3220Vo.setEducCost(edSpedSelf);    /** column 교육비_국세청 : educCost */  
            			   
            			   }else{
            			  
		                	   if (MSFSharedUtils.paramNotNull(arrPayr445[ddCnt01][0])) {
		                		   
		                		   if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrPayr445[ddCnt01][0])) {
		                			  
		                		          if (strEncValue.equals(arrPayr445[ddCnt01][0])) {
		                		        	
		                		        	 yetaPrc3220Vo.setEducCost(edSpedSelf.add(new BigDecimal(arrPayr445[9][3])));    /** column 교육비_국세청 : educCost */  
				                        	 // oraQryUpdate.ParamByName('EDUC_COST').AsString  :=  floattostr( edSpedSelf + strtofloat(arrPayr445[9][3]));     //교육비_국세청';
				                        	 
				                          }
				                          else
				                          {
				                        	  if(MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(strEncValue)){
				                				   
				                				   yetaPrc3220Vo.setEducCost(edSpedSelf);    /** column 교육비_국세청 : educCost */  
				                			   
				                			   }else{
				                				   
				                				   yetaPrc3220Vo.setEducCost((new BigDecimal(arrPayr445[ddCnt01][2])).add(new BigDecimal(arrPayr445[ddCnt01][3])));    /** column 교육비_국세청 : educCost */
				                			   }
				                            // oraQryUpdate.ParamByName('EDUC_COST').AsString  :=   floattostr(strtofloat(arrPayr445[ddCnt01][2]) + strtofloat(arrPayr445[ddCnt01][3]));     //교육비_국세청';
				                          }
		                		   }
			
		                	   } 
            			   }
	                      //일반
	                	   if (MSFSharedUtils.paramNotNull(arrCARD_PAY[ddCnt01][0])) {   
	                		 
		                      if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrCARD_PAY[ddCnt01][0])) { 
		                    		 
		                    	   yetaPrc3220Vo.setCdteCard(new BigDecimal(arrCARD_PAY[ddCnt01][1]));    /** column 신용카드등_국세청 : cdteCard */
		                           // oraQryUpdate.ParamByName('CDTE_CARD').AsString  :=  arrCARD_PAY[ddCnt01][1] ;    //신용카드등_국세청';
	
		                      }
	                	   }   
	                	   
	                	   if (MSFSharedUtils.paramNotNull(arrBCBS_PAY[ddCnt01][0])) {  
		                       if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrBCBS_PAY[ddCnt01][0])) { 
		                      
		                    	     yetaPrc3220Vo.setJiblCard(new BigDecimal(arrBCBS_PAY[ddCnt01][1]));    /** column 직불카드등_국세청 : jiblCard */
		                            // oraQryUpdate.ParamByName('JIBL_CARD').AsString  :=  arrBCBS_PAY[ddCnt01][1] ;   //직불카드등_국세청';
	
		                       }
	                	   } 
	                	   if (MSFSharedUtils.paramNotNull(arrMONI_PAY[ddCnt01][0])) {  
		                       if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrMONI_PAY[ddCnt01][0]) ){ 
		                    
		                    	   yetaPrc3220Vo.setCashRece(new BigDecimal(arrMONI_PAY[ddCnt01][1]));    /** column 현금영수증_국세청 : cashRece */
		                          // oraQryUpdate.ParamByName('CASH_RECE').AsString  :=  arrMONI_PAY[ddCnt01][1] ;    //현금영수증_국세청';
	
		                       }
	                	   }   
	                	   if (MSFSharedUtils.paramNotNull(arrCARD_PAY[ddCnt01][0])) {   
		                      //전통시장
		                       if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrCARD_PAY[ddCnt01][0])) { 
		                     
		                             edCARD_MONI =  edCARD_MONI.add(new BigDecimal(arrCARD_PAY[ddCnt01][2]));
		                            		 // + strtofloat(arrCARD_PAY[ddCnt01][2]);
	
		                       }
	                	   }   
	                	   if (MSFSharedUtils.paramNotNull(arrMONI_PAY[ddCnt01][0])) {    
		                      if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrMONI_PAY[ddCnt01][0])) { 
		                  
		                             edCARD_MONI =  edCARD_MONI.add(new BigDecimal(arrMONI_PAY[ddCnt01][2]));  // + strtofloat(arrMONI_PAY[ddCnt01][2]);
	
		                      }
	                	   }   
	                	   if (MSFSharedUtils.paramNotNull(arrBCBS_PAY[ddCnt01][0])) {    
		                      if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrBCBS_PAY[ddCnt01][0])) { 
		                     
	
		                             edCARD_MONI =  edCARD_MONI.add(new BigDecimal(arrBCBS_PAY[ddCnt01][2])); // + strtofloat(arrBCBS_PAY[ddCnt01][2]);
	
		                      }
	                	   }   
	                      //대중교통
	                	   if (MSFSharedUtils.paramNotNull(arrCARD_PAY[ddCnt01][0])) {    
		                      if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrCARD_PAY[ddCnt01][0])) { 
		                      
		                             edCARD_BCED =  edCARD_BCED.add(new BigDecimal(arrCARD_PAY[ddCnt01][3]));  // + strtofloat(arrCARD_PAY[ddCnt01][3]);
	
		                      }
	                	   } 
	                	   if (MSFSharedUtils.paramNotNull(arrMONI_PAY[ddCnt01][0])) {   
		                      if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrMONI_PAY[ddCnt01][0])) { 
		                     
	
		                             edCARD_BCED =  edCARD_BCED.add(new BigDecimal(arrMONI_PAY[ddCnt01][3]));   // + strtofloat(arrMONI_PAY[ddCnt01][3]);
	
		                      }
	                	   }   
	                	   if (MSFSharedUtils.paramNotNull(arrBCBS_PAY[ddCnt01][0])) {    
		                      if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrBCBS_PAY[ddCnt01][0])) { 
		                     
	
		                             edCARD_BCED =  edCARD_BCED.add(new BigDecimal(arrBCBS_PAY[ddCnt01][3]));   // + strtofloat(arrBCBS_PAY[ddCnt01][3]);
	
		                      }
	                	   }
	                	   if (MSFSharedUtils.paramNotNull(arrSPCI_PAY[ddCnt01][0])) {   
	                		 
		                       if   (MSFSharedUtils.defaultNulls(str3220EncValue,"").equals(arrSPCI_PAY[ddCnt01][0])) { 
		                    	  
		                    	   yetaPrc3220Vo.setCtrbAmnt(new BigDecimal(arrSPCI_PAY[ddCnt01][1]));    /** column 기부금액_국세청 : ctrbAmnt */ 
		                             //oraQryUpdate.ParamByName('CTRB_AMNT').AsString  :=   arrSPCI_PAY[ddCnt01][1] ;    //기부금액_국세청';
		                       }
	                	   }
	                   }
	                   
	                   yetaPrc3220Vo.setMgntStvd(edCARD_MONI);    /** column 전통시장사용분_국세청 : mgntStvd */
	                   yetaPrc3220Vo.setGrpyAmnt(edCARD_BCED);    /** column 지로납부액_대중교통_국세청 : grpyAmnt */
	                 //  oraQryUpdate.ParamByName('MGNT_STVD').AsString  :=  floattostr( edCARD_MONI);    //전통시장_국세청';
	                 //  oraQryUpdate.ParamByName('GRPY_AMNT').AsString  :=  floattostr( edCARD_BCED);    //대중교통_국세청';

//	               	yetaPrc3220Vo.setInsuRtyr(yeta3220Dto.getInsuRtyr());    /** column 보험료보장성_국세청 : insuRtyr */
//					yetaPrc3220Vo.setPsclIurr(yeta3220Dto.getPsclIurr());    /** column 보험료장애인보장성_국세청 : psclIurr */ 
//					yetaPrc3220Vo.setInsuFetc(yeta3220Dto.getInsuFetc());    /** column 보험료_건강고용등외 : insuFetc */
//					yetaPrc3220Vo.setInsuRtet(yeta3220Dto.getInsuRtet());    /** column 보험료보장성외 : insuRtet */
//					yetaPrc3220Vo.setPsclIurt(yeta3220Dto.getPsclIurt());    /** column 보험료장애인보장성외 : psclIurt */
//					yetaPrc3220Vo.setMediExps(yeta3220Dto.getMediExps());    /** column 의료비외 : mediExps */
//					yetaPrc3220Vo.setEducOtec(yeta3220Dto.getEducOtec());    /** column 교육비외 : educOtec */
//					yetaPrc3220Vo.setCdteCdec(yeta3220Dto.getCdteCdec());    /** column 신용카드외 : cdteCdec */
//					yetaPrc3220Vo.setJiblCdec(yeta3220Dto.getJiblCdec());    /** column 직불카드외 : jiblCdec */
//					yetaPrc3220Vo.setGrpyAtec(yeta3220Dto.getGrpyAtec());    /** column 지로납부액_대중교통외 : grpyAtec */
//					yetaPrc3220Vo.setMgntSdec(yeta3220Dto.getMgntSdec());    /** column 전통시장사용분외 : mgntSdec */
//					yetaPrc3220Vo.setCtrbAmec(yeta3220Dto.getCtrbAmec());    /** column 기부금액외 : ctrbAmec */

					
	                 yetaPrc3220Vo.setRsnoNumb(MSFSharedUtils.defaultNulls(mapYeta3220.get("rsnoNumb"),""));    /** column 주민등록번호 : rsnoNumb */
//	                   oraQryUpdate.ParamByName('RSNO_NUMB').AsString := oraQrySelect03.FieldByName('RSNO_NUMB').AsString;
//						yetaPrc3220Vo.setKybdr(yeta3220Dto.getKybdr());    /** column 입력자 : kybdr */
//						yetaPrc3220Vo.setInptDt(yeta3220Dto.getInptDt());    /** column 입력일자 : inptDt */
//						yetaPrc3220Vo.setInptAddr(yeta3220Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//						yetaPrc3220Vo.setIsmt(yeta3220Dto.getIsmt());    /** column 수정자 : ismt */
//						yetaPrc3220Vo.setRevnDt(yeta3220Dto.getRevnDt());    /** column 수정일자 : revnDt */
//						yetaPrc3220Vo.setRevnAddr(yeta3220Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
	                   
	                 yetaPayr1200Service.fnPayr06430_PAYR410_2016_01_Update(yetaPrc3220Vo);
	                   
	                 }
    		    } 
	              

	      } catch(Exception e) {
	    	  e.printStackTrace();
           System.out.println(e.toString());
       }
	     
	      
	      // showMessage('PDF 전자문서 저장이 완료 되었습니다.');
	    
 }
  
    
}
