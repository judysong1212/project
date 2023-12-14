package com.app.smrmf.sysm.server.service;

import com.app.smrmf.sysm.server.service.vo.SysIfBass0320VO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0350VO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0400VO;

public interface SysIfPkgSmrmfService {
	 
	
	SysIfBass0400VO  getFuncBeforComboBass0400List(SysIfBass0400VO sysIfBass0400Vo) throws Exception;
    
	SysIfBass0320VO  getFuncBeforComboBass0320List(SysIfBass0320VO sysComBass0320Vo) throws Exception;

	SysIfBass0350VO getFuncBeforComboBass0350List(SysIfBass0350VO sysIfBass0350Vo) throws Exception; 

    
}
