package com.app.exterms.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.basis.client.dto.Bass5100DTO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass1100DAO.java
 * @Description : Bass1100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("bass5100DAO")
public class Bass5100DAO extends EgovAbstractDAO {

	   @Transactional
		public String insertBass0240(Bass5100DTO bass5100Dto) throws Exception{
			return (String) insert("bass5100DAO.insertBass0240",bass5100Dto);
		}
	    @Transactional
		public String insertBass0250(Bass5100DTO bass5100Dto) throws Exception{
			return (String) insert("bass5100DAO.insertBass0250",bass5100Dto);
		}
	    @Transactional
		public String insertBass0260(Bass5100DTO bass5100Dto) throws Exception{
			return (String) insert("bass5100DAO.insertBass0260",bass5100Dto);
		}
	    @Transactional
		public String insertBass0270(Bass5100DTO bass5100Dto) throws Exception{
			return (String) insert("bass5100DAO.insertBass0270",bass5100Dto);
		}
		
	    @Transactional
		public int updateBass0240EndDt(Bass5100DTO bass5100Dto) throws Exception{
			return update("bass5100DAO.updateBass0240EndDt",bass5100Dto);
		}
	    @Transactional
		public int updateBass0250EndDt(Bass5100DTO bass5100Dto) throws Exception{
			return update("bass5100DAO.updateBass0250EndDt",bass5100Dto);
		}
	    @Transactional
		public int updateBass0260EndDt(Bass5100DTO bass5100Dto) throws Exception{
			return update("bass5100DAO.updateBass0260EndDt",bass5100Dto);
		}
	    @Transactional
		public int updateBass0270EndDt(Bass5100DTO bass5100Dto) throws Exception{
			return update("bass5100DAO.updateBass0270EndDt",bass5100Dto);
		}
		
	    @Transactional
		public int updateBass0240(Bass5100DTO bass5100Dto) throws Exception{
			return update("bass5100DAO.updateBass0240",bass5100Dto);
		}
	    @Transactional
		public int updateBass0250(Bass5100DTO bass5100Dto) throws Exception{
			return update("bass5100DAO.updateBass0250",bass5100Dto);
		}
	    @Transactional
		public int updateBass0260(Bass5100DTO bass5100Dto) throws Exception{
			return update("bass5100DAO.updateBass0260",bass5100Dto);
		}
	    @Transactional
		public int updateBass0270(Bass5100DTO bass5100Dto) throws Exception{
			return update("bass5100DAO.updateBass0270",bass5100Dto);
		}
	    @Transactional
		public int deleteBass0240(Bass5100DTO bass5100Dto) throws Exception{
			return delete("bass5100DAO.deleteBass0240",bass5100Dto);
		}
	    @Transactional
		public int deleteBass0250(Bass5100DTO bass5100Dto) throws Exception{
			return delete("bass5100DAO.deleteBass0250",bass5100Dto);
		}
	    @Transactional
		public int deleteBass0260(Bass5100DTO bass5100Dto) throws Exception{
			return delete("bass5100DAO.deleteBass0260",bass5100Dto);
		}
	    @Transactional
		public int deleteBass0270(Bass5100DTO bass5100Dto) throws Exception{
			return delete("bass5100DAO.deleteBass0270",bass5100Dto);
		}
		
		@SuppressWarnings("rawtypes")
		public List selectBass0240(Bass5100DTO bass5100Dto) {
			return list("bass5100DAO.selectBass0240", bass5100Dto);
		}
		
		@SuppressWarnings("rawtypes")
		public List selectBass0250(Bass5100DTO bass5100Dto) {
			return list("bass5100DAO.selectBass0250", bass5100Dto);
		}
		
		@SuppressWarnings("rawtypes")
		public List selectBass0260(Bass5100DTO bass5100Dto) {
			return list("bass5100DAO.selectBass0260", bass5100Dto);
		}
		
		@SuppressWarnings("rawtypes")
		public List selectBass0270(Bass5100DTO bass5100Dto) {
			return list("bass5100DAO.selectBass0270", bass5100Dto);
		}
 
}
