package org.msf.exterms.file.web;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.file.service.PsnlP010001FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.personal.server.vo.Psnl0132SrhVO;
import com.app.exterms.personal.server.vo.Psnl0132VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

@Controller
public class PsnlP010001FileController  {
	
    private static final Logger logger = LoggerFactory.getLogger(PsnlP010001FileController.class);  
    private static final String calledClass = PsnlP010001FileController.class.getName();
    
	
    @Resource(name = "multipartResolver")
    private CommonsMultipartResolver multipartResolver;
    
    @Resource(name = "psnlP010001FileService")
    private PsnlP010001FileService psnlP010001FileService;
    
//	
//    private ServletContext sevltContext;
//    
//    private ServletConfig sevltConfig;
//    
//    @Override
//    public void setServletConfig(final ServletConfig servletConfig) {
//        this.sevltConfig = servletConfig;
//    }
//
//    @Override
//    public void setServletContext(final ServletContext servletContext) {
//        this.sevltContext = servletContext;
//    }

    
    
    /** 파일 업로드 **/
    @RequestMapping(value = "/upload/fileUpload.do")
    public String multipartProcess(final HttpServletRequest request, Model model)throws Exception {

    	Psnl0132VO psnl0132Vo = new Psnl0132VO();
    	
	    final long startTime = System.nanoTime();
	    String resultStr = "success";
	    
	    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	    
	    
	    HashMap<String, String> extGlobals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
	     
	    //이미지 저장정보를 가지고 온다.
//	    final HashMap<String, String> extGlobals = ExtConf.getPayGenConfigInfo(sevltConfig , request);   
	  		
	    /*
	     * validate request type
	     */
	    Assert.state(request instanceof MultipartHttpServletRequest, "request !instanceof MultipartHttpServletRequest");
	    final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
	     
	    /*
	     * validate text input
	     */
	  //  Assert.state(request.getParameter("type").equals("genericFileMulti"),
	  //          "type != genericFileMulti");
	     
	    /*
	     * extract files
	     */
	    final Map<String, MultipartFile> files = multiRequest.getFileMap();
	    Assert.notNull(files, "files is null");
	    Assert.state(files.size() > 0, "0 files exist");
	     
	    /*
	     * process files 
	     */
	//    String uploadPath = fileUploadProperties
	//            .getProperty("file.upload.path");
	    String uploadPath =   extGlobals.get("PayGen.fileStorePath") ;     
	    
	    
	    File saveFolder = new File(uploadPath);
	     
	    // 디렉토리 생성
	    if (!saveFolder.exists() || saveFolder.isFile()) {
	        saveFolder.mkdirs();
	    }
	     
	    Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
	    MultipartFile file;
	   // List fileInfoList = new ArrayList();
	   // String filePath;
	    String fileTgtPath;
	    
	    
	    
	    
		// split()을 이용해 ':'을 기준으로 가져온 파일명들을 자른다.
		String refeFlnms = multiRequest.getParameter("fileKeyCode");
		String refeSeilNum = MSFSharedUtils.defaultNulls(String.valueOf(multiRequest.getParameter("refeSeilNum")), "0");
		String refeOrgFlnms[] = refeFlnms.split(":");
		String refeFlSeilNum = "";
	    int i = 0;				// 배열에 있는 값들을 가져오기 위한 index 값
	    Long flsz = new Long(0);
	    while (itr.hasNext()) {
	        Entry<String, MultipartFile> entry = itr.next();
	     
	        file = entry.getValue();
	        if (!"".equals(file.getOriginalFilename())) {
	        	String fileKeyCode = refeOrgFlnms[i].trim();
//	        	String fileKeyCode = multiRequest.getParameter("fileKeyCode").substring(multiRequest.getParameter("fileKeyCode").lastIndexOf("\\")+1);
	        	refeFlSeilNum = fileKeyCode.substring(fileKeyCode.length()-4, fileKeyCode.length());	// 파일명에서 일련번호를 가져온다.
	        	String orgFileNm = file.getOriginalFilename();											// 기존파일명
	    		int pos = orgFileNm.lastIndexOf(".");													// 기존파일명에서 확장자의 위치를 가져온다.
	    		orgFileNm = orgFileNm.substring(pos + 1);												// 확장자만 잘라서 당아줌.
	        	
	        	
	        	
	        	fileTgtPath = uploadPath + "/" +  fileKeyCode + "." + orgFileNm; 
	        	
	        	File saveFile = new File(fileTgtPath);			
	        	saveFile.renameTo(saveFile);					// 파일명 변경하여 저장.
	            file.transferTo(new File(fileTgtPath)); 		// 업로드 한 파일 데이터를 지정한 경로에 저장
	            
	            flsz = saveFile.length();						// 파일 사이즈를 가져옴
	            
	            psnl0132Vo.setDpobCd(MSFSharedUtils.allowNulls(multiRequest.getParameter("dpobCd")));
	            psnl0132Vo.setSystemkey(MSFSharedUtils.allowNulls(multiRequest.getParameter("systemkey")));
	            psnl0132Vo.setRefeSeilNum(new BigDecimal(refeSeilNum));
	            psnl0132Vo.setRefeFlSeilNum(MSFSharedUtils.defaultNulls(refeFlSeilNum, "0"));
	            psnl0132Vo.setRefeFlsz(MSFSharedUtils.defaultNulls(flsz, "0"));
	            
	            psnl0132Vo.setIsmt(sessionUser.getUsrId());    																/** column 수정자 : ismt */
	            psnl0132Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    						/** column 수정주소 : revnAddr */
				
	            
	            int result = psnlP010001FileService.updatePsnl0132_REFE_FLSZ(psnl0132Vo, request);
	            
	            if(result < 1) {
	            	resultStr = "fail";
	            }
	            
	            i++;
	        }
	    }
	     
	    // 여기서는 DB에 파일관련 정보를 저장하지 않고 단순히 success 페이지로 포워딩 하여 재확인 가능토록 함
	   // model.addAttribute("fileInfoList", fileInfoList);
	   // model.addAttribute("uploadPath", uploadPath);
	     
	    final long estimatedTime = System.nanoTime() - startTime;
	    //System.out.println(estimatedTime + " " + getClass().getSimpleName());
	     
	    return resultStr;
      
   }
    
    
    /** 파일 다운로드 **/
	@RequestMapping(value = "/download/downloadFile.do")
    public ModelAndView fileDownload(@ModelAttribute("Psnl0132SrhVO") Psnl0132SrhVO psnl0132SrhVo, ModelMap model, HttpServletRequest request) throws Exception {
 
		
	Psnl0132VO psnl0132Vo = new Psnl0132VO();
		
    // 첨부된 파일의 정보를 가져온다.
	psnl0132Vo = psnlP010001FileService.selectPsnl0132Data(psnl0132SrhVo);
 
    /** 첨부 파일 정보 */
    Map<String, Object> fileInfo = new HashMap<String, Object>();
 
    fileInfo.put("refeOrgFlnm", psnl0132Vo.getRefeOrgFlnm());			// 원본 파일명
    fileInfo.put("refeFlnm", psnl0132Vo.getRefeFlnm());					// 파일명
    fileInfo.put("refeFlcos", psnl0132Vo.getRefeFlcos());				// 파일경로
    
    
    return new ModelAndView("psnlP010001FilelView", "fileInfo", fileInfo);

	}    
}
