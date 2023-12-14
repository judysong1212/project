package org.msf.exterms.file.service;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.personal.server.vo.Psnl0132SrhVO;
import com.app.exterms.personal.server.vo.Psnl0132VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;


public interface PsnlP010001FileService {
	
	 /** 관련 근거 파일정보의 파일크기를 update 처리**/
    int updatePsnl0132_REFE_FLSZ(Psnl0132VO psnl0132Vo, HttpServletRequest request) throws MSFException;
    
    /** 관련 근거 파일정보를 vo로 가져옴**/
    Psnl0132VO selectPsnl0132Data(Psnl0132SrhVO psnl0132SrhVo)  throws MSFException;
	
}
