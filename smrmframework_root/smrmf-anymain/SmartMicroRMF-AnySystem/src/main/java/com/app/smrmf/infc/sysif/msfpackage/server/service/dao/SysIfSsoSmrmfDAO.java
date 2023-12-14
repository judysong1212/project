package com.app.smrmf.infc.sysif.msfpackage.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.system.SsoxUserSrhVO;
import com.ext.dao.OtherAbstractDAO;
 
/**
 * @Class Name : Bass0300DAO.java
 * @Description : Bass0300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SysIfSsoSmrmfDAO")
public class SysIfSsoSmrmfDAO extends OtherAbstractDAO  { 
	 
    
     
     /**
 	 * SSOX_USER 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return SSOX_USER 목록
 	 * @exception Exception
 	 */
     public List selectSsoxIfUserList(SsoxUserSrhVO searchVO) throws Exception {
         return list("sysIfSsoSmrmfDAO.selectSsoxIfUserList_D", searchVO);
     }

     /**
 	 * SSOX_USER 총 갯수를 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return SSOX_USER 총 갯수
 	 * @exception
 	 */
     public int selectSsoxIfUserListTotCnt(SsoxUserSrhVO searchVO) {
         return (Integer)getSqlMapClientTemplate().queryForObject("sysIfSsoSmrmfDAO.selectSsoxIfUserListTotCnt_S", searchVO);
     }

        
  
}
