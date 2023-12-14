package com.app.smrmf.infc.sysauth.system.server.service.dao;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.sysauth.system.server.vo.InfcPkgSysm0500VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0500DAO.java
 * @Description : Sysm0500 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgSysm0500DAO")
public class InfcPkgSysm0500DAO extends EgovAbstractDAO {

    public String insertYeta2080ToSysm0500(InfcPkgSysm0500VO vo) throws Exception {
        return (String)insert("InfcPkgSysm0500DAO.insertYeta2080ToSysm0500", vo);
    }
    
    public void deleteYeta2080ToSysm0500(InfcPkgSysm0500VO vo) throws Exception {
        delete("InfcPkgSysm0500DAO.deleteYeta2080ToSysm0500", vo);
    }

}
