package com.app.smrmf.props.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.service.vo.SysIfMstr010100SrhVO;
import com.app.smrmf.sysm.server.service.vo.SysIfMstr010100VO;
import com.googlecode.ehcache.annotations.Cacheable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Mstr010100DAO.java
 * @Description : Mstr010100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.10.31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PropMstr010100DAO")
public class PropMstr010100DAO extends EgovAbstractDAO {

	@Cacheable(cacheName = "extemsprops-cache")  
    public List<SysIfMstr010100VO> selectPropsMstr010100List(SysIfMstr010100SrhVO searchVO) throws Exception {
        return list("propMstr010100DAO.selectPropsMstr010100List_D", searchVO);
    }
    

}
