package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2023.file.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.server.utils.SysifPkgServiceUtils;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta1000VO;
import com.app.smrmf.infc.yearendtax.server.vo.YetaMessageVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161010_2023_VO;
import com.app.smrmf.pkg.yeta.yeta2023.file.Yeta8400PkgFileController;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0350VO;

@Controller
public class Yeta8400FileController {


    private static final Logger logger = LoggerFactory.getLogger(Yeta8400FileController.class);  
 
     

    @RequestMapping(value = "/exp/FileYeta8400Export.do")
    public String expYeta8400Export(@ModelAttribute("InfcPkgYe161010_2023_VO") InfcPkgYe161010_2023_VO  ye161010VO,final HttpServletRequest request,final HttpServletResponse response
            , Map commandMap , Model model) throws Exception {
         
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        String sResult = "";
        int state = 0;
    	  
        Yeta8400PkgFileController yete3400 = new Yeta8400PkgFileController();
        
         
        try	{ 
        	
        	
         List<String> listDeptCd = new ArrayList<String>(); 
         ye161010VO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
         ye161010VO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 

     	 ye161010VO.setDeptCdAuth(MSFSharedUtils.allowNulls(ye161010VO.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
     	 ye161010VO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(ye161010VO.getDtilOccuInttnCd()).replace(",", ""));   
        
     	 ye161010VO.setUsrId(sessionUser.getUsrId());
   	   	 /******************************** 권한 ************************************************************************/
   	   	 String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
   	   	 	
   	   	 if ("FALSE".equals(chkDeptCd)) {
   	   		 
   	   		 ye161010VO.setDeptCd(sessionUser.getDeptCd()); 
   		   	 listDeptCd.add(sessionUser.getDeptCd());
   		   	 ye161010VO.setDeptCdArr(listDeptCd);     //부서코드    
   		   	 ye161010VO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
   		        
   	   	 } else {
   	     	    
   	   		 ye161010VO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(ye161010VO.getPayrMangDeptCd())) ;   //단위기관코드   
   	   	 		
   	   	 	if (ye161010VO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(ye161010VO.getDeptCd()))) { 
   	   	 		listDeptCd = null; 
   	   	 		ye161010VO.setDeptCdArr(listDeptCd);     //부서코드 
   	   	 		ye161010VO.setDeptCd("");  //부서코드
   	   	 	} else {
   	   	 		ye161010VO.setDeptCd(MSFSharedUtils.allowNulls(ye161010VO.getDeptCd()));
   	            listDeptCd = SmrmfUtils.getStrToArrayList(ye161010VO.getDeptCd());  
   	            ye161010VO.setDeptCdArr(listDeptCd);     //부서코드   
   	        } 
   	   	 }
   	     
   	     
   	     
   	   	 /******************************** 권한 ************************************************************************/
   	  	
   	    List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161010VO.getTypOccuCd())); 
   	    ye161010VO.setTypOccuCdArr(lstTypeOccuCd); 
   	    ye161010VO.setTypOccuCd(MSFSharedUtils.allowNulls(ye161010VO.getTypOccuCd()));  	//직종
	        
//	  	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	  	psnl0100SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	  	psnl0100SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	          
	   	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161010VO.getDtilOccuInttnCd())); 
	   	ye161010VO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	   	ye161010VO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(ye161010VO.getDtilOccuInttnCd())); //직종세
	        
		List<String> lstBusinCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161010VO.getBusinCd())); 
		ye161010VO.setBusinCdArr(lstBusinCd);   
		ye161010VO.setBusinCd(MSFSharedUtils.allowNulls(ye161010VO.getBusinCd()));   //사업코드
		
		ye161010VO.setUtDpobCd(MSFSharedUtils.allowNulls(ye161010VO.getUtDpobCd()));				//원천신고부서
		ye161010VO.setBusoprRgstnum(MSFSharedUtils.allowNulls(ye161010VO.getBusoprRgstnum()));	//사업자등록번호
		
		

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
     	sysIfBass0350Vo.setStrDate(MSFSharedUtils.allowNulls(ye161010VO.getYrtxBlggYr()));
     	sysIfBass0350Vo.setTypOccuCd(ye161010VO.getTypOccuCd());
     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
    	sysIfBass0350Vo.setDtilOccuInttnCd(ye161010VO.getDtilOccuInttnCd());
     	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
     	
     	sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0350Vo); 
     
     	ye161010VO.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
     	ye161010VO.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
     	
     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/

     	

		       	 if (ye161010VO.getCreFile().equals("Y0090001")) {
		       		 //근로소득지급명세서 호출 
		       		  state = yete3400.fnYeta8400_Tax_Ye161010_File_Create(request,ye161010VO,response) ;
		//       		 if state = 0 then
		//			          begin
		//			            ShowMessage('근로소득지급명세서 파일생성이 완료되었습니다.');
		//			          end;
		       	 
		       	 } else if (ye161010VO.getCreFile().equals("Y0090002")) {
		       		 //의료비지급명세서 
		       		state = yete3400.fnYeta8400_Tax_Ye164010_File_Create(request,ye161010VO,response) ;
		       	   
		//	          if state = 0 then
		//	          begin
		//	            ShowMessage('의료비지급명세서 파일생성이 완료되었습니다.');
		//	          end;
		       		
		       	 } else if (ye161010VO.getCreFile().equals("Y0090003")) {
		       		 //기부금지급명세서 
		       		state = yete3400.fnYeta8400_Tax_Ye165010_File_Create(request,ye161010VO,  response) ;
		           
		 
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
   

  
 @RequestMapping(value = "/exp/Yeta8400Verifiction.do")
 public String yeta8400Verifiction(@ModelAttribute("InfcPkgYe161010_2023_VO") InfcPkgYe161010_2023_VO  ye161010VO,final HttpServletRequest request,final HttpServletResponse response
         , Map commandMap , Model model) throws Exception {
      
     MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
     
     List<YetaMessageVO>  rtnResult = new ArrayList<YetaMessageVO>();
 	  
     Yeta8400PkgFileController yete3400 = new Yeta8400PkgFileController();
     
     try	{ 
     	
     	
      List<String> listDeptCd = new ArrayList<String>(); 
      ye161010VO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
      ye161010VO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 

      ye161010VO.setDeptCdAuth(MSFSharedUtils.allowNulls(ye161010VO.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
  	  ye161010VO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(ye161010VO.getDtilOccuInttnCd()).replace(",", ""));   
     
  	  ye161010VO.setUsrId(sessionUser.getUsrId());
	   	 /******************************** 권한 ************************************************************************/
	   	 String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	   	 	
	   	 if ("FALSE".equals(chkDeptCd)) {
	   		 
	   		 ye161010VO.setDeptCd(sessionUser.getDeptCd()); 
		   	 listDeptCd.add(sessionUser.getDeptCd());
		   	 ye161010VO.setDeptCdArr(listDeptCd);     //부서코드    
		   	 ye161010VO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
		        
	   	 } else {
	     	    
	   		 ye161010VO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(ye161010VO.getPayrMangDeptCd())) ;   //단위기관코드   
	   	 		
	   	 	if (ye161010VO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(ye161010VO.getDeptCd()))) { 
	   	 		listDeptCd = null; 
	   	 		ye161010VO.setDeptCdArr(listDeptCd);     //부서코드 
	   	 		ye161010VO.setDeptCd("");  //부서코드
	   	 	} else {
	   	 		ye161010VO.setDeptCd(MSFSharedUtils.allowNulls(ye161010VO.getDeptCd()));
	            listDeptCd = SmrmfUtils.getStrToArrayList(ye161010VO.getDeptCd());  
	            ye161010VO.setDeptCdArr(listDeptCd);     //부서코드   
	        } 
	   	 }
	     
	     
	     
	   	 /******************************** 권한 ************************************************************************/
	  	
	    List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161010VO.getTypOccuCd())); 
	    ye161010VO.setTypOccuCdArr(lstTypeOccuCd); 
	    ye161010VO.setTypOccuCd(MSFSharedUtils.allowNulls(ye161010VO.getTypOccuCd()));  	//직종
	        
//	  	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	  	psnl0100SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	  	psnl0100SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	          
	   	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161010VO.getDtilOccuInttnCd())); 
	   	ye161010VO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	   	ye161010VO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(ye161010VO.getDtilOccuInttnCd())); //직종세
	        
		List<String> lstBusinCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161010VO.getBusinCd())); 
		ye161010VO.setBusinCdArr(lstBusinCd);   
		ye161010VO.setBusinCd(MSFSharedUtils.allowNulls(ye161010VO.getBusinCd()));   //사업코드
		
		ye161010VO.setUtDpobCd(MSFSharedUtils.allowNulls(ye161010VO.getUtDpobCd()));				//원천신고부서
		ye161010VO.setBusoprRgstnum(MSFSharedUtils.allowNulls(ye161010VO.getBusoprRgstnum()));	//사업자등록번호 
		

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
     	sysIfBass0350Vo.setStrDate(MSFSharedUtils.allowNulls(ye161010VO.getYrtxBlggYr()));
     	sysIfBass0350Vo.setTypOccuCd(ye161010VO.getTypOccuCd());
     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
    	sysIfBass0350Vo.setDtilOccuInttnCd(ye161010VO.getDtilOccuInttnCd());
     	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
     	
     	sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0350Vo); 
     
     	ye161010VO.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
     	ye161010VO.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
     	
     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
     	

		       	 if (ye161010VO.getCreFile().equals("Y0090001")) {
		       		 //근로소득지급명세서 검증  
		       		rtnResult = yete3400.fnYeta8400_Tax_Ye161010_File_Check(request,ye161010VO,response) ;
		 
		       	 
		       	 } else if (ye161010VO.getCreFile().equals("Y0090002")) {
		       		 //의료비지급명세서 검증 
		       		rtnResult = yete3400.fnYeta8400_Tax_Ye164010_File_Check(request,ye161010VO,response) ;
		       	    
		       		
		       	 } else if (ye161010VO.getCreFile().equals("Y0090003")) {
		       		 //기부금지급명세서 검증 
		       		rtnResult = yete3400.fnYeta8400_Tax_Ye165010_File_Check(request,ye161010VO,  response) ;
		            
		       	 }  
                
                   
     } catch(Exception ex) { 
     	ex.printStackTrace();  
     	
     }  
     
     //jsp 파일 호출로 변경 해야 함. 
     return "";

 }  
 
 
}