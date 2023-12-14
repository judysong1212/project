package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Payr0485Srh_2018_VO;
import com.app.exterms.yearendtax.server.vo.Payr0485_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0485_2018_DAO.java
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

@Repository("InfcPayr0485_2018_DAO")
public class InfcPayr0485_2018_DAO extends EgovAbstractDAO {
	
	
	
  /**
	 * PAYR0485 목록을 조회한다.(엑셀 양식 출력)
	 * @param searchVO - 조회할 정보가 담긴 searchVO
	 * @return PAYR0485 목록
	 * @exception Exception
	 */
  public List selectPayr0485List(Payr0485Srh_2018_VO searchVO) throws Exception {
      return list("InfcPayr0485_2018_DAO.selectPayr0485_S", searchVO);
  }
  
/**
 * PAYR0485 갯수를 조회한다.
 * @param searchMap - 조회할 정보가 Payr0485VO
 * @return PAYR0485 �?�?��
 * @exception
 */
public int selectPayr0485ListTotCnt(Payr0485_2018_VO vO) {
    return (Integer)getSqlMapClientTemplate().queryForObject("InfcPayr0485_2018_DAO.selectPayr0485ListTotCnt", vO);
}

 
}
