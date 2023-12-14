/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;

public class FileUploadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String attachmentsPath = 
            MSFServerUtils.getLocalizedMessage(getServletConfig(), req, "PayGen.ExTermUpload", "")+"/";
        
        String baseDir = getServletContext().getRealPath(attachmentsPath);
        resp.setContentType("text/html");
        FileItem uploadItem = getFileItem(req);
        
        if(uploadItem == null) {
            resp.getWriter().write("NO-SCRIPT-DATA");
            return;
        }
        if(uploadItem.getSize()>3000000) {
            resp.getWriter().write("TOO-MUCH-SIZE");
            return;
        }
        
        Long timeStamp = System.currentTimeMillis();
        try {
            FileOutputStream fcheck = null;
            byte[] buf = uploadItem.get();
            //fcheck = new FileOutputStream(baseDir+getFileName(uploadItem.getName()));
            fcheck = new FileOutputStream(baseDir+"/"+timeStamp+"."+uploadItem.getName());
            for (int i = 0; i < buf.length; i++) {
                fcheck.write(buf[i]);
            }
            fcheck.flush();
            fcheck.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Errore save file");
            resp.getWriter().write("ERROR-WRITE-FILE");
            return;
        }       
        resp.getWriter().write(timeStamp+"."+uploadItem.getName());
        return;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private FileItem getFileItem(HttpServletRequest req) {
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        try {
            List items = upload.parseRequest(req);
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if (!item.isFormField()) {
                    return item;
                }
            }
//            while(it.hasNext()) {
//                FileItem item = (FileItem) it.next();
//                if(!item.isFormField() && "uploadFormElement".equals(item.getFieldName())) {
//                    return item;
//                }
//            }
        }
        catch(FileUploadException e){
            return null;
        }
        
        return null;
    }

//    private String getFileName(String fileName) {
//        if (!GWT.isScript()) { 
//            fileName.replace('/', '\\');
//            int ipos = fileName.lastIndexOf("\\");        
//            if (ipos>=0){
//                fileName = fileName.substring(ipos+1, fileName.length());
//            }
//        }
//        return fileName;
//    }
//    
}