package com.app.smrmf.pkg.sche.payr.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("PayrScheSvcDAO") 
public class PayrScheSvcDAO extends EgovAbstractDAO {
	 
	  public List  selectFamyTgtUnCheckList() throws Exception {
	        return  list("payrScheSvcDAO.selectFamyTgtUnCheckList_D", null);
	    }
	   
//	    /**
//	   	 * PSNL0123을 조회한다.
//	   	 * @param vo - 조회할 정보가 담긴 Psnl0123VO
//	   	 * @return 조회한 PSNL0123
//	   	 * @exception Exception
//	   	 */
//       public List selectPsnl0123ToPanl0100List() throws Exception {
//           return list("payrScheSvcDAO.selectPsnl0123_D", null);  
//       }
//	       
//       public List selectPsnl0100EndToPanl0100List() throws Exception {
//           return list("payrScheSvcDAO.selectPsnl0100EndToPanl0100List_D", null);  
//       }   
//       
//       public List selectPsnl0100EndToRePanl0100List() throws Exception {
//           return list("payrScheSvcDAO.selectPsnl0100EndToRePanl0100List_D", null);  
//       }   
//       
//	    
//	  @Transactional
//      public int updatePsnl0100LogSvcYrNumCd(InfcPkgPsnl0100VO psnl0100Vo) throws Exception{
//        return update("payrScheSvcDAO.updatePsnl0100LogSvcYrNumCd", psnl0100Vo);
//     }
//	  
//
//	    @Transactional
//	    public int updatePsnl0100ToPsnlStat(InfcPkgPsnl0100DTO psnl0100Dto) throws Exception{
//	        return update("payrScheSvcDAO.Psnl0100ToPsnlStat", psnl0100Dto);
//	    }
//	    
//	    @Transactional
//	    public int updateSchePsnl0123(InfcPkgPsnl0123DTO psnl0123Dto) throws Exception{
//	        return update("payrScheSvcDAO.updateSchePsnl0123", psnl0123Dto);
//	    }   
	    
}
