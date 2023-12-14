package com.app.exterms.prgm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.prgm.server.vo.PrgmPayr0400SrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : SysPayr0400DAO.java
 * @Description : SysPayr0400 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PrgmComPayr0400DAO")
public class PrgmComPayr0400DAO extends EgovAbstractDAO {

	 
    
    /**
   	 * PAYR0400 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0400 목록
   	 * @exception Exception
   	 */
    //  @Cacheable(value = "typOccuCdCache")  
       public List selectPrgmPayr0400TypOccuCdList(PrgmPayr0400SrhVO searchVO) throws Exception {
           return list("prgmPayr0400DAO.selectPrgmPayr0400TypOccuCdList_D", searchVO);
       }

       /**
   	 * PAYR0400 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0400 총 갯수
   	 * @exception
   	 */
      // @Cacheable(value = "typOccuCdCache")  
       public int selectPrgmPayr0400TypOccuCdListTotCnt(PrgmPayr0400SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("prgmPayr0400DAO.selectPrgmPayr0400TypOccuCdListTotCnt_S", searchVO);
       }
    
    
    

}
