package com.app.smrmf.props.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.smrmf.props.service.PropMstr010100Service;
import com.app.smrmf.sysm.server.service.AbstractAnyServiceImpl;
import com.app.smrmf.sysm.server.service.vo.SysIfMstr010100SrhVO;
import com.app.smrmf.sysm.server.service.vo.SysIfMstr010100VO;

/**
 * @Class Name : Mstr010100ServiceImpl.java
 * @Description : Mstr010100 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2017.10.31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("PropMstr010100Service")
public class PropMstr010100ServiceImpl  extends AbstractAnyServiceImpl  implements
        PropMstr010100Service {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(PropMstr010100ServiceImpl.class);

    @Resource(name="PropMstr010100DAO")
    private PropMstr010100DAO mstr010100DAO;
    
    /** ID Generation */
    //@Resource(name="{egovMstr010100IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
  
    public List<SysIfMstr010100VO> selectPropsMstr010100List(SysIfMstr010100SrhVO searchVO) throws Exception {
        return  mstr010100DAO.selectPropsMstr010100List(searchVO);
    }

    
}
