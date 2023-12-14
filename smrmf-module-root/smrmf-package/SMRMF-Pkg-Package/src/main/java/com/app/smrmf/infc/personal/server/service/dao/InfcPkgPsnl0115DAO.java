package com.app.smrmf.infc.personal.server.service.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0115VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0130DAO.java
 * @Description : Psnl0130 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014/07/31
 * @version 1.0
 * @param <Psnl0130DTO>
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPsnl0115DAO")
public class InfcPkgPsnl0115DAO extends EgovAbstractDAO implements IsSerializable {

	/**
	 * PSNL0115을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0130VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPsnl0115(InfcPkgPsnl0115VO vo) throws Exception {
        return (String)insert("infcPkgPsnl0115DAO.insertPsnl0115_S", vo);
    }


}