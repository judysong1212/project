package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.service.vo.SysComSearchVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0800SrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
//import com.googlecode.ehcache.annotations.Cacheable;

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

@Repository("SysIfBass0300DAO")
public class SysIfBass0300DAO extends EgovAbstractDAO  {

	 

    /**
     * BASS0300 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0300 목록
     * @exception Exception
     */
   
    public List selectSysmMtr0500ToBass0300List(SysComSearchVO searchVO) throws Exception {
        return list("sysIfBass0300DAO.selectSysmMtr0500ToBass0300List_D", searchVO);
    }
     
    
    public int selectSysmMtr0500ToBass0300ListTotCnt(SysComSearchVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysIfBass0300DAO.selectSysmMtr0500ToBass0300ListTotCnt_S", searchVO);
    }
    

    

}
