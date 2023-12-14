package com.smrmf.exterms.file.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.ext.constants.SysmConf;


@Controller
public class BoardFileUpDownController implements ServletContextAware, ServletConfigAware { 
    
    private static final Logger logger = LoggerFactory.getLogger(BoardFileUpDownController.class.getName());
    
    @Resource(name = "multipartResolver")
    CommonsMultipartResolver multipartResolver;
    
   
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
    /**
     * 브라우저 구분 얻기.
     * 
     * @param request
     * @return
     */
    private String getBrowser(HttpServletRequest request) {
        String header = request.getHeader("User-Agent");
        if (header.indexOf("MSIE") > -1) {
            return "MSIE";
        } else if (header.indexOf("Trident") > -1) {    // IE11 문자열 깨짐 방지
            return "Trident";
        } else if (header.indexOf("Chrome") > -1) {
            return "Chrome";
        } else if (header.indexOf("Opera") > -1) {
            return "Opera";
        }
        return "Firefox";
    }

    /**
     * Disposition 지정하기.
     * 
     * @param filename
     * @param request
     * @param response
     * @throws Exception
     */
    private void setDisposition(String filename, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String browser = getBrowser(request);
        
        String dispositionPrefix = "attachment; filename=";
        String encodedFilename = null;
        
        if (browser.equals("MSIE")) {
            encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
        } else if (browser.equals("Trident")) {     // IE11 문자열 깨짐 방지
            encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
        } else if (browser.equals("Firefox")) {
            encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
        } else if (browser.equals("Opera")) {
            encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
        } else if (browser.equals("Chrome")) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < filename.length(); i++) {
                char c = filename.charAt(i);
                if (c > '~') {
                    sb.append(URLEncoder.encode("" + c, "UTF-8"));
                } else {
                    sb.append(c);
                }
            }
            encodedFilename = sb.toString();
        } else {
            throw new IOException("Not supported browser");
        }
        
        response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);

        if ("Opera".equals(browser)){
            response.setContentType("application/octet-stream;charset=UTF-8");
        }
    }

    
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/upload/BoardFileUpload.do")
    public String multipartProcess(final HttpServletRequest request, Model model)
        throws Exception {
     
    final long startTime = System.nanoTime();
     
    /*
     * validate request type
     */
    Assert.state(request instanceof MultipartHttpServletRequest,
            "request !instanceof MultipartHttpServletRequest");
    final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
     
    final HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(sevltConfig , request);   
    
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
    String uploadPath =  extGlobals.get("PayGen.fileStorePath");   //Globals.FILE_STORE_PATH
    
    
    File saveFolder = new File(uploadPath);
     
    // 디렉토리 생성
    if (!saveFolder.exists() || saveFolder.isFile()) {
        saveFolder.mkdirs();
    }
     
    Iterator<Entry<String, MultipartFile>> itr = files.entrySet()
            .iterator();
    MultipartFile file;
    List fileInfoList = new ArrayList();
    String filePath;
     
    while (itr.hasNext()) {
        Entry<String, MultipartFile> entry = itr.next();
       // System.out.println("[" + entry.getKey() + "]");
     
        file = entry.getValue();
        if (!"".equals(file.getOriginalFilename())) {
            filePath = uploadPath + "/" + file.getOriginalFilename();
            file.transferTo(new File(filePath));
           
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
 
/**
 * 첨부파일로 등록된 파일에 대하여 다운로드를 제공한다.
 * 
 * @param commandMap
 * @param response
 * @throws Exception
 */ 
@RequestMapping(value = "/down/BoardFileDownload.do")
public void boardFileDownload( Map<String, Object> commandMap, HttpServletRequest request, HttpServletResponse response) throws Exception {   
        
	 final HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(sevltConfig , request);   
     
	  String stordFilePath =  extGlobals.get("PayGen.fileStorePath") + "/";   //EgovProperties.getProperty("Globals.fileStorePath");  Globals.FILE_STORE_PATH
   
      Boolean isAuthenticated = true; // EgovUserDetailsHelper.isAuthenticated();

     if (isAuthenticated) {
         // 저장된 파일명
          String filename =  (String)commandMap.get("filename") ;
         // 첨부된 원 파일명
          String original =  (String)commandMap.get("original") ; 
      // 저장된 파일명
        // String filename =  request.getParameter("filename").getBytes("UTF-8" ;
         // 첨부된 원 파일명
       //  String original =  request.getParameter("original") ;

          
//         if ("".equals(original)) {
//             original = filename;
//         }
//          
//         request.setAttribute("downFile", stordFilePath + filename);
//         request.setAttribute("orginFile", original);
//          
//         EgovFileMngUtil.downFile(request, response);
       
         File uFile = new File(stordFilePath, filename);
         int fSize = (int)uFile.length();

         if (fSize > 0) {
         String mimetype = "application/x-msdownload";

         //response.setBufferSize(fSize);    // OutOfMemeory 발생
         response.setContentType(mimetype);
         //response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fvo.getOrignlFileNm(), "utf-8") + "\"");
         setDisposition(original, request, response);
         response.setContentLength(fSize);

         /*
          * FileCopyUtils.copy(in, response.getOutputStream());
          * in.close(); 
          * response.getOutputStream().flush();
          * response.getOutputStream().close();
          */
         BufferedInputStream in = null;
         BufferedOutputStream out = null;

         try {
             in = new BufferedInputStream(new FileInputStream(uFile));
             out = new BufferedOutputStream(response.getOutputStream());

             FileCopyUtils.copy(in, out);
             out.flush();
             
         } catch (Exception ex) {
             //ex.printStackTrace();
             // 다음 Exception 무시 처리
             // Connection reset by peer: socket write error
             logger.debug("IGNORED: " + ex.getMessage());
         } finally {
             if (in != null) {
                 try {
                     in.close();
                 } catch (Exception ignore) {
                     // no-op
                     logger.debug("IGNORED: " + ignore.getMessage());
                 }
             }
             if (out != null) {
                 try {
                     out.close();
                 } catch (Exception ignore) {
                     // no-op
                   logger.debug("IGNORED: " + ignore.getMessage());
                 }
             }
         }

         } else {
         response.setContentType("application/x-msdownload");
    
             PrintWriter printwriter = response.getWriter();
             printwriter.println("<html>");
             printwriter.println("<br><br><br><h2>Could not get file name:<br>" + original + "</h2>");
             printwriter.println("<br><br><br><center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
             printwriter.println("<br><br><br>&copy; webAccess");
             printwriter.println("</html>");
             printwriter.flush();
             printwriter.close();
         }
     }
   }
    
}
