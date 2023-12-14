package com.app.smrmf.props.service;

import java.util.List;

import com.app.smrmf.sysm.server.service.vo.SysIfMstr010100SrhVO;
import com.app.smrmf.sysm.server.service.vo.SysIfMstr010100VO;

/**
 * @Class Name : Mstr010100Service.java
 * @Description : Mstr010100 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2017.10.31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface PropMstr010100Service {
	
	 
    List<SysIfMstr010100VO> selectPropsMstr010100List(SysIfMstr010100SrhVO searchVO) throws Exception;
    
}
