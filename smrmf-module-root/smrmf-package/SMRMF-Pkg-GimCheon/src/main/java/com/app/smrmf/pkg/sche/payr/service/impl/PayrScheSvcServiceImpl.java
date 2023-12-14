package com.app.smrmf.pkg.sche.payr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.pkg.sche.payr.service.PayrScheSvcService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("PayrScheSvcService") 
public class PayrScheSvcServiceImpl extends AbstractServiceImpl implements  PayrScheSvcService {

	
	@Autowired
    @Resource(name="PayrScheSvcDAO")
    private PayrScheSvcDAO payrScheSvcDAO;
	
	public List  selectFamyTgtUnCheckList() throws Exception {
		 
		 return payrScheSvcDAO.selectFamyTgtUnCheckList();
		 
	 } 
	 
//	public List selectPsnl0123ToPanl0100List() throws Exception {
//		
//		return payrScheSvcDAO.selectPsnl0123ToPanl0100List();
//	}
//	
//	public List selectPsnl0100EndToPanl0100List() throws Exception {
//		
//		return payrScheSvcDAO.selectPsnl0100EndToPanl0100List();
//	}
//	
//	public List selectPsnl0100EndToRePanl0100List() throws Exception {
//		
//		return payrScheSvcDAO.selectPsnl0100EndToRePanl0100List();
//	}
//	
//	
//	
//     public int updatePsnl0100LogSvcYrNumCd(InfcPkgPsnl0100VO psnl0100Vo) throws Exception{
//        return payrScheSvcDAO.updatePsnl0100LogSvcYrNumCd(psnl0100Vo);
//     } 
//     
//     public int updatePsnl0100ToPsnlStat(InfcPkgPsnl0100DTO psnl0100Dto) throws Exception{
//         return payrScheSvcDAO.updatePsnl0100ToPsnlStat( psnl0100Dto);
//      }
//     
//     public int updateSchePsnl0123(InfcPkgPsnl0123DTO psnl0123Dto) throws Exception{
//         return payrScheSvcDAO.updateSchePsnl0123( psnl0123Dto);
//      }
      
       
}
