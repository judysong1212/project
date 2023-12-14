package org.msf.exterms.xls.web;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.ext.constants.SysmConf;

@Controller
public class PrgmUtilExcelController implements ServletContextAware, ServletConfigAware{
	
    @Resource(name = "multipartResolver")
    CommonsMultipartResolver multipartResolver;
    
	
    private ServletContext sevltContext;
    
    private ServletConfig sevltConfig;
    
    @Override
    public void setServletConfig(final ServletConfig servletConfig) {
        this.sevltConfig = servletConfig;
    }

    @Override
    public void setServletContext(final ServletContext servletContext) {
        this.sevltContext = servletContext;
    }


    private static final Logger logger = LoggerFactory.getLogger(PrgmUtilExcelController.class);  
    private static final String calledClass = PrgmUtilExcelController.class.getName();
    
    
    @RequestMapping(value = "/upload/XlsFileUpload.do")
    public String multipartProcess(final HttpServletRequest request, Model model)throws Exception {
     
	    final long startTime = System.nanoTime();
	     
	    //이미지 저장정보를 가지고 온다.
	    final HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(sevltConfig , request);   
	  		
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
	     
	    
	    while (itr.hasNext()) {
	        Entry<String, MultipartFile> entry = itr.next();
	     
	        file = entry.getValue();
	        if (!"".equals(file.getOriginalFilename())) {
	        	
	        	String imgKeyCode = multiRequest.getParameter("fileKeyCode");
	        	fileTgtPath = uploadPath + "/" +  imgKeyCode;  
	            
//	                fileTgtPath = uploadPath + "/" +  file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."), file.getOriginalFilename().length());  
	            file.transferTo(new File(fileTgtPath)); 
	            
	        }
	    }
	     
	    // 여기서는 DB에 파일관련 정보를 저장하지 않고 단순히 success 페이지로 포워딩 하여 재확인 가능토록 함
	   // model.addAttribute("fileInfoList", fileInfoList);
	   // model.addAttribute("uploadPath", uploadPath);
	     
	    final long estimatedTime = System.nanoTime() - startTime;
	    //System.out.println(estimatedTime + " " + getClass().getSimpleName());
	     
	    return "success";
      
   }
    
    
}
