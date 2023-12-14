package com.smrmf.exterms.file.web;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

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
public class ImageFileUpDownController  implements ServletContextAware, ServletConfigAware {
    
    @Resource(name = "multipartResolver")
    CommonsMultipartResolver multipartResolver;
    
    
//    private FileInputStream orgInput;
//    private FileOutputStream tgtOutput;
    
     
//    @Resource(name = "fileUploadProperties")
//    Properties fileUploadProperties;
     
    
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
      
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/upload/ImageFileUpload.do")
    public String multipartProcess(final HttpServletRequest request, Model model)
        throws Exception {
     
    final long startTime = System.nanoTime();
     
  //이미지 저장정보를 가지고 온다.
    final HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(sevltConfig , request);   
  		
    /*
     * validate request type
     */
    Assert.state(request instanceof MultipartHttpServletRequest,
            "request !instanceof MultipartHttpServletRequest");
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
    String uploadPath =   extGlobals.get("PayGen.fileStorePhotoPath") ;      //PayGen.FILE_STORE_PHOTO_PATH;  
    
    
    File saveFolder = new File(uploadPath);
     
    // 디렉토리 생성
    if (!saveFolder.exists() || saveFolder.isFile()) {
        saveFolder.mkdirs();
    }
     
    Iterator<Entry<String, MultipartFile>> itr = files.entrySet()
            .iterator();
    MultipartFile file;
   // List fileInfoList = new ArrayList();
   // String filePath;
    String fileTgtPath;
     
    
    while (itr.hasNext()) {
        Entry<String, MultipartFile> entry = itr.next();
      //  System.out.println("[" + entry.getKey() + "]");
     
        file = entry.getValue();
        if (!"".equals(file.getOriginalFilename())) {
            
//            FileChannel forgInput = null;
//            FileChannel ftgtOutput = null;
            
          //  String systemKey = multiRequest.getParameter("systemKey");
            String imgKeyCode = multiRequest.getParameter("imgKeyCode");
            String frmKey = multiRequest.getParameter("frmKey"); 

//            File originalFile =   new File(file.getOriginalFilename()); 
//            file.transferTo(originalFile); 
              
            if("BASS0100".equals(frmKey)){ //사업장 관리 직인 이미지
               
                fileTgtPath = uploadPath + "/" +  imgKeyCode + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."), file.getOriginalFilename().length());  
                
            }else if("BASS0150".equals(frmKey)){ //관리관리부서관리 이미지

                fileTgtPath = uploadPath + "/" +  imgKeyCode + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."), file.getOriginalFilename().length()); 
            
            }else{ //무기 및 기간제 증명사진 이미지
            
               fileTgtPath = uploadPath + "/" +   imgKeyCode + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."), file.getOriginalFilename().length()); 
            
            }  

            file.transferTo(new File(fileTgtPath)); 
            
//            orgInput = new FileInputStream(originalFile);
//            tgtOutput = new FileOutputStream(fileTgtPath);
//            forgInput  = orgInput.getChannel();
//            ftgtOutput = tgtOutput.getChannel();
// 
//            forgInput.transferTo(0, forgInput.size(), ftgtOutput); 
//            
//            
//            forgInput.close();
//            ftgtOutput.close();
//            orgInput.close();
//            tgtOutput.close();
     
//            FileInfoVO fileInfoVO = new FileInfoVO();
//            fileInfoVO.setFilePath(filePath);
//            fileInfoVO.setFileName(file.getOriginalFilename());
//            fileInfoVO.setFileSize(file.getSize());
//            fileInfoList.add(fileInfoVO);
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
