package com.app.smrmf.exterms.sso.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.smrmf.exterms.sso.login.service.SSOLoginService;
import com.app.smrmf.sysm.server.vo.system.LoginVO;
import com.app.smrmf.sysm.server.vo.system.SsomUserVO;
import com.app.smrmf.sysm.server.vo.system.SsoxUserVO;

import egovframework.let.utl.sim.service.EgovFileScrty;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : Sysm0100ServiceImpl.java
 * @Description : Sysm0100 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.26
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("SSOLoginService")
public class SSOLoginServiceImpl extends AbstractServiceImpl implements
        SSOLoginService {

    @Resource(name="SSOLoginDAO")
    private SSOLoginDAO ssoLoginDAO;
    
    /**
 	 * 일반 로그인을 처리한다
 	 * @param vo LoginVO
 	 * @return LoginVO
 	 * @exception Exception
 	 */
     public SsoxUserVO actionSSOLogin(LoginVO vo) throws Exception {
     	
     	// 1. 입력한 비밀번호를 암호화한다.
     	String enpassword = EgovFileScrty.encryptPassword(vo.getPwd());
     	vo.setPwd(enpassword);
     	
     	// 2. 아이디와 암호화된 비밀번호가 DB와 일치하는지 확인한다.
     	SsoxUserVO ssoxUserVo = ssoLoginDAO.actionSSOLogin(vo);
     	
     	// 3. 결과를 리턴한다.
     	if (ssoxUserVo != null && !ssoxUserVo.getUserId().equals("") && !ssoxUserVo.getPwd().equals("")) {
     		return ssoxUserVo;
     	} else {
     		ssoxUserVo = new SsoxUserVO();
     	}
     	
     	return ssoxUserVo;
     }
     
     
     /**
  	 * 올레 일반 로그인을 처리한다
  	 * @param vo LoginVO
  	 * @return LoginVO
  	 * @exception Exception
  	 */
      public SsomUserVO actionOLSSOLogin(LoginVO vo) throws Exception {
      	
      	// 1. 입력한 비밀번호를 암호화한다.
      	String enpassword = EgovFileScrty.encryptPassword(vo.getPwd());
      	vo.setPwd(enpassword);
      	
      	// 2. 아이디와 암호화된 비밀번호가 DB와 일치하는지 확인한다.
      	SsomUserVO ssoxUserVo = ssoLoginDAO.actionOLSSOLogin(vo);
      	
      	// 3. 결과를 리턴한다.
      	if (ssoxUserVo != null && !ssoxUserVo.getSidM().equals("") && !ssoxUserVo.getUidM().equals("")) {
      		return ssoxUserVo;
      	} else {
      		ssoxUserVo = new SsomUserVO();
      	}
      	
      	return ssoxUserVo;
      }
      
     /**
  	 * 일반 로그인을 처리한다
  	 * @param vo LoginVO
  	 * @return LoginVO
  	 * @exception Exception
  	 */
      public SsoxUserVO actionSeolSSOLogin(LoginVO vo) throws Exception {
      	
      	// 1. 입력한 비밀번호를 암호화한다.
      //	String enpassword = EgovFileScrty.encryptPassword(vo.getPwd());
      //	vo.setPwd(enpassword);
      	
      	// 2. 아이디와 암호화된 비밀번호가 DB와 일치하는지 확인한다.
      	SsoxUserVO ssoxUserVO = ssoLoginDAO.actionSeolSSOLogin(vo);
      	
      	// 3. 결과를 리턴한다.
      	if (ssoxUserVO != null && !ssoxUserVO.getUserId().equals("") && !ssoxUserVO.getPwd().equals("")) {
      		return ssoxUserVO;
      	} else {
      		ssoxUserVO = new SsoxUserVO();
      	}
      	
      	return ssoxUserVO;
      }
  
 
//     /**
// 	 * 아이디를 찾는다.
// 	 * @param vo LoginVO
// 	 * @return LoginVO
// 	 * @exception Exception
// 	 */
//     public LoginVO searchId(LoginVO vo) throws Exception {
//
//     	// 1. 이름, 이메일주소가 DB와 일치하는 사용자 ID를 조회한다.
//     	LoginVO loginVO = ssoLoginDAO.searchId(vo);
//     	
//     	// 2. 결과를 리턴한다.
//     	if (loginVO != null && !loginVO.getUsrId().equals("")) {
//     		return loginVO;
//     	} else {
//     		loginVO = new LoginVO();
//     	}
//     	
//     	return loginVO;
//     }
//     
//     /**
// 	 * 비밀번호를 찾는다.
// 	 * @param vo LoginVO
// 	 * @return boolean
// 	 * @exception Exception
// 	 */
//     public boolean searchPassword(LoginVO vo) throws Exception {
//     	
//     	boolean result = true;
//     	
//     	// 1. 아이디, 이름, 이메일주소, 비밀번호 힌트, 비밀번호 정답이 DB와 일치하는 사용자 Password를 조회한다.
//     	LoginVO loginVO = ssoLoginDAO.searchPassword(vo);
//     	if (loginVO == null || loginVO.getPwd() == null || loginVO.getPwd().equals("")) {
//     		return false;
//     	}
//     	
//     	// 2. 임시 비밀번호를 생성한다.(영+영+숫+영+영+숫=6자리)
//     	String newpassword = "";
//     	for (int i = 1; i <= 6; i++) {
//     		// 영자
//     		if (i % 3 != 0) {
//     			newpassword += EgovStringUtil.getRandomStr('a', 'z');
//     		// 숫자
//     		} else {
//     			newpassword += EgovNumberUtil.getRandomNum(0, 9);
//     		}
//     	}
//     	
//     	// 3. 임시 비밀번호를 암호화하여 DB에 저장한다.
//     	LoginVO pwVO = new LoginVO();
//     	String enpassword = EgovFileScrty.encryptPassword(newpassword);
//     	pwVO.setUsrId(vo.getUsrId());
//     	pwVO.setPwd(enpassword); 
//     	ssoLoginDAO.updatePassword(pwVO);
//     	
//     	// TODO - 4. 임시 비밀번호를 이메일 발송한다.(메일연동솔루션 활용)
////     	SndngMailVO sndngMailVO = new SndngMailVO();
////     	sndngMailVO.setDsptchPerson("webmaster");
////     	sndngMailVO.setRecptnPerson(vo.getEmail());
////     	sndngMailVO.setSj("[MOPAS] 임시 비밀번호를 발송했습니다.");
////     	sndngMailVO.setEmailCn("고객님의 임시 비밀번호는 " + newpassword + " 입니다.");
////     	sndngMailVO.setAtchFileId("");
////     	
////     	result = sndngMailRegistService.insertSndngMail(sndngMailVO);
//     	
//     	return result;
//     }  
}
