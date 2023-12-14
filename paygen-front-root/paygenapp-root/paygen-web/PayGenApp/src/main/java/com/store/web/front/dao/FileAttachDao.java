package com.store.web.front.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.any.smrmf.core.dao.AnyAbstractDAO;
import com.store.web.front.dto.FileUpload;


@Repository
public class FileAttachDao extends AnyAbstractDAO {


   public void insertAttach(FileUpload model){
     // template.insert("front.insertAttach", model);
   }

   @SuppressWarnings("unchecked")
   public List<FileUpload> selectEntireFiles(){
      return null; //template.queryForList("front.selectEntireFiles");
   }

   public FileUpload selectAttachByPhysicalName(String pname){
      return null ; //(FileUpload)template.queryForObject("front.selectAttachByPhysicalName", pname);
   }
}
