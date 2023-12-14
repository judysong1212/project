package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.insurance.client.dto.Insr0200DTO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr1100DAO.java
 * @Description : Insr1100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("insr0200DAO")
public class Insr0200DAO extends EgovAbstractDAO {

	   @Transactional
		public String insertInsr0240(Insr0200DTO insr2100Dto) throws Exception{
			return (String) insert("insr0200DAO.insertInsr0240",insr2100Dto);
		}
	    @Transactional
		public String insertInsr0250(Insr0200DTO insr2100Dto) throws Exception{
			return (String) insert("insr0200DAO.insertInsr0250",insr2100Dto);
		}
	    @Transactional
		public String insertInsr0260(Insr0200DTO insr2100Dto) throws Exception{
			return (String) insert("insr0200DAO.insertInsr0260",insr2100Dto);
		}
	    @Transactional
		public String insertInsr0270(Insr0200DTO insr2100Dto) throws Exception{
			return (String) insert("insr0200DAO.insertInsr0270",insr2100Dto);
		}
		
	    @Transactional
		public int updateInsr0240EndDt(Insr0200DTO insr2100Dto) throws Exception{
			return update("insr0200DAO.updateInsr0240EndDt",insr2100Dto);
		}
	    @Transactional
		public int updateInsr0250EndDt(Insr0200DTO insr2100Dto) throws Exception{
			return update("insr0200DAO.updateInsr0250EndDt",insr2100Dto);
		}
	    @Transactional
		public int updateInsr0260EndDt(Insr0200DTO insr2100Dto) throws Exception{
			return update("insr0200DAO.updateInsr0260EndDt",insr2100Dto);
		}
	    @Transactional
		public int updateInsr0270EndDt(Insr0200DTO insr2100Dto) throws Exception{
			return update("insr0200DAO.updateInsr0270EndDt",insr2100Dto);
		}
		
	    @Transactional
		public int updateInsr0240(Insr0200DTO insr2100Dto) throws Exception{
			return update("insr0200DAO.updateInsr0240",insr2100Dto);
		}
	    @Transactional
		public int updateInsr0250(Insr0200DTO insr2100Dto) throws Exception{
			return update("insr0200DAO.updateInsr0250",insr2100Dto);
		}
	    @Transactional
		public int updateInsr0260(Insr0200DTO insr2100Dto) throws Exception{
			return update("insr0200DAO.updateInsr0260",insr2100Dto);
		}
	    @Transactional
		public int updateInsr0270(Insr0200DTO insr2100Dto) throws Exception{
			return update("insr0200DAO.updateInsr0270",insr2100Dto);
		}
	    @Transactional
		public int deleteInsr0240(Insr0200DTO insr2100Dto) throws Exception{
			return delete("insr0200DAO.deleteInsr0240",insr2100Dto);
		}
	    @Transactional
		public int deleteInsr0250(Insr0200DTO insr2100Dto) throws Exception{
			return delete("insr0200DAO.deleteInsr0250",insr2100Dto);
		}
	    @Transactional
		public int deleteInsr0260(Insr0200DTO insr2100Dto) throws Exception{
			return delete("insr0200DAO.deleteInsr0260",insr2100Dto);
		}
	    @Transactional
		public int deleteInsr0270(Insr0200DTO insr2100Dto) throws Exception{
			return delete("insr0200DAO.deleteInsr0270",insr2100Dto);
		}
		
		@SuppressWarnings("rawtypes")
		public List selectInsr0240(Insr0200DTO insr2100Dto) {
			return list("insr0200DAO.selectInsr0240", insr2100Dto);
		}
		
		@SuppressWarnings("rawtypes")
		public List selectInsr0250(Insr0200DTO insr2100Dto) {
			return list("insr0200DAO.selectInsr0250", insr2100Dto);
		}
		
		@SuppressWarnings("rawtypes")
		public List selectInsr0260(Insr0200DTO insr2100Dto) {
			return list("insr0200DAO.selectInsr0260", insr2100Dto);
		}
		
		@SuppressWarnings("rawtypes")
		public List selectInsr0270(Insr0200DTO insr2100Dto) {
			return list("insr0200DAO.selectInsr0270", insr2100Dto);
		}
 
}
