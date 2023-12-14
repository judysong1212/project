package com.app.smrmf.pkg.sche.psnl.service;

import java.util.List;

import com.app.exterms.personal.client.dto.InfcPkgPsnl0100DTO;
import com.app.exterms.personal.client.dto.InfcPkgPsnl0123DTO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0100VO;



public interface ScheSvcService {
	
	 List  selectScheLogSvcYrList() throws Exception;
	 
	 List selectPsnl0123ToPanl0100List() throws Exception ; 
	 
	 List selectPsnl0100EndToPanl0100List() throws Exception ; 
	 
	 List selectPsnl0100EndToRePanl0100List() throws Exception ; 
	 
	 int updatePsnl0100LogSvcYrNumCd(InfcPkgPsnl0100VO psnl0100Vo) throws Exception; 
	 
	 int updatePsnl0100ToPsnlStat(InfcPkgPsnl0100DTO psnl0100Dto) throws Exception;
	 
	 int updateSchePsnl0123(InfcPkgPsnl0123DTO psnl0123Dto) throws Exception;
	 
	 
}
