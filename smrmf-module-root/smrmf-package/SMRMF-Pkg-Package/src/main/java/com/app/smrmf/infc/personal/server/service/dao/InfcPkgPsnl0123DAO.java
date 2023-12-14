package com.app.smrmf.infc.personal.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0123SrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0123DAO.java
 * @Description : Psnl0123 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPsnl0123DAO")
public class InfcPkgPsnl0123DAO extends EgovAbstractDAO {

	   
 
    /**
   	 * PSNL0123 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PSNL0123 목록
   	 * @exception Exception
   	 */
       public List selectPsnl0123ToPayr4100List(InfcPkgPsnl0123SrhVO searchVO) throws Exception {
           return list("infcPkgPsnl0123DAO.selectPsnl0123ToPayr4100List_D", searchVO);
       }

       /**
   	 * PSNL0123 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PSNL0123 총 갯수
   	 * @exception
   	 */
       public int selectPsnl0123ToPayr4100ListTotCnt(InfcPkgPsnl0123SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPsnl0123DAO.selectPsnl0123ToPayr4100ListTotCnt_S", searchVO);
       }
       
    

}
