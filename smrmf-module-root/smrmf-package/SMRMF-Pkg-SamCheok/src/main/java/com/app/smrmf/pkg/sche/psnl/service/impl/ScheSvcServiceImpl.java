package com.app.smrmf.pkg.sche.psnl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.personal.client.dto.InfcPkgPsnl0100DTO;
import com.app.exterms.personal.client.dto.InfcPkgPsnl0123DTO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0100VO;
import com.app.smrmf.pkg.sche.psnl.service.ScheSvcService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("ScheSvcService") 
public class ScheSvcServiceImpl extends AbstractServiceImpl implements  ScheSvcService {

	
	@Autowired
    @Resource(name="PsnlScheSvcDAO")
    private PsnlScheSvcDAO psnlScheSvcDAO;
	
	public List  selectScheLogSvcYrList() throws Exception {
		 
		 return psnlScheSvcDAO.selectScheLogSvcYrList();
		 
	 } 
	 
	public List selectPsnl0123ToPanl0100List() throws Exception {
		
		return psnlScheSvcDAO.selectPsnl0123ToPanl0100List();
	}
	
	public List selectPsnl0100EndToPanl0100List() throws Exception {
		
		return psnlScheSvcDAO.selectPsnl0100EndToPanl0100List();
	}
	
	public List selectPsnl0100EndToRePanl0100List() throws Exception {
		
		return psnlScheSvcDAO.selectPsnl0100EndToRePanl0100List();
	}
	
	
	
     public int updatePsnl0100LogSvcYrNumCd(InfcPkgPsnl0100VO psnl0100Vo) throws Exception{
        return psnlScheSvcDAO.updatePsnl0100LogSvcYrNumCd(psnl0100Vo);
     } 
     
     public int updatePsnl0100ToPsnlStat(InfcPkgPsnl0100DTO psnl0100Dto) throws Exception{
         return psnlScheSvcDAO.updatePsnl0100ToPsnlStat( psnl0100Dto);
      }
     
     public int updateSchePsnl0123(InfcPkgPsnl0123DTO psnl0123Dto) throws Exception{
         return psnlScheSvcDAO.updateSchePsnl0123( psnl0123Dto);
      }
      
       
}
