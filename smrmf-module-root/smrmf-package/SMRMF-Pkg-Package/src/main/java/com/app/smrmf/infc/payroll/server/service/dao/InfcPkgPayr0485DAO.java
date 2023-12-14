package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0485SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0485VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0485DAO.java
 * @Description : Payr0485 DAO Class
 * @Modification Information
 *
 * @author BaeDaEun
 * @since 2016.12..20
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPayr0485DAO")
public class InfcPkgPayr0485DAO extends EgovAbstractDAO {
	
	
	
  /**
	 * PAYR0485 목록을 조회한다.(엑셀 양식 출력)
	 * @param searchVO - 조회할 정보가 담긴 searchVO
	 * @return PAYR0485 목록
	 * @exception Exception
	 */
  public List selectPayr0485List(InfcPkgPayr0485SrhVO searchVO) throws Exception {
      return list("infcPkgPayr0485DAO.selectPayr0485_S", searchVO);
  }
  
/**
 * PAYR0485 갯수를 조회한다.
 * @param searchMap - 조회할 정보가 Payr0485VO
 * @return PAYR0485 �?�?��
 * @exception
 */
public int selectPayr0485ListTotCnt(InfcPkgPayr0485VO vO) {
    return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0485DAO.selectPayr0485ListTotCnt", vO);
}

/***************************************************************************************************
* 출력물 데이타 인서트 임시 
***************************************************************************************************/

@Transactional
public String mutilInsertPayr4150ToPayr0485_01() throws Exception {
    return (String)insert("infcPkgPayr0485DAO.mutilInsertPayr4150ToPayr0485_01_S", null);
}

@Transactional
public String mutilInsertPayr4150ToPayr0485_02() throws Exception {
    return (String)insert("infcPkgPayr0485DAO.mutilInsertPayr4150ToPayr0485_02_S", null);
}

@Transactional
public String mutilInsertPayr4150ToPayr0485_03() throws Exception {
    return (String)insert("infcPkgPayr0485DAO.mutilInsertPayr4150ToPayr0485_03_S", null);
}

@Transactional
public String mutilInsertPayr4150ToPayr0485_04() throws Exception {
    return (String)insert("infcPkgPayr0485DAO.mutilInsertPayr4150ToPayr0485_04_S", null);
}

 
}
