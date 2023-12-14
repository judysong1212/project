package com.app.exterms.personal.server.service.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.server.vo.Psnl0101VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0101DAO.java
 * @Description : Psnl0101 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0101DAO")
public class Psnl0101DAO extends EgovAbstractDAO  implements IsSerializable {
	
	
	/**
	 * PSNL0101을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0101VO
	 * @return int형
	 * @exception Exception
	 */
	@Transactional
	public int updatePsnl0101(Psnl0101VO vo) throws Exception {
		return update("psnl0101DAO.updatePsnl0101_S", vo);
	}
	
	/**
	 * PSNL0101을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0101VO
	 * @return int형
	 * @exception Exception
	 */
	@Transactional
	public int deletePsnl0101(Psnl0101VO vo) throws Exception {
		return delete("psnl0101DAO.deletePsnl0101", vo);
	}
	    
	/**
	 * PSNL0101을 등록한다.
	 * @param vo - 입력할 정보가 담긴 Psnl0101VO
	 * @exception Exception
	 */
	@Transactional
	public String insertPsnl0101(Psnl0101VO vo) throws Exception {
		return (String) insert("psnl0101DAO.insertPsnl0101_S", vo);

	}    
	    
	    
	

}
