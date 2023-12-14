package com.web.exterms.mypage.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.exterms.mypage.login.service.MyLoginService;
import com.web.exterms.mypage.login.service.MyPageSessionVO;

import egovframework.com.cmm.LoginVO;
import egovframework.com.utl.fcc.service.EgovNumberUtil;
import egovframework.com.utl.fcc.service.EgovStringUtil;
import egovframework.com.utl.sim.service.EgovFileScrty;
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

@Service("MyLoginService")
public class MyLoginServiceImpl extends AbstractServiceImpl implements
        MyLoginService {

    @Resource(name="MyLoginDAO")
    private MyLoginDAO myLoginDAO;
    
    /**
 	 * 일반 로그인을 처리한다
 	 * @param vo LoginVO
 	 * @return LoginVO
 	 * @exception Exception
 	 */
     public LoginVO actionLogin(LoginVO vo) throws Exception {
     	
     	// 1. 입력한 비밀번호를 암호화한다.
     	String enpassword = EgovFileScrty.encryptPassword(vo.getPwd());
     	vo.setPwd(enpassword);
     	
     	// 2. 아이디와 암호화된 비밀번호가 DB와 일치하는지 확인한다.
     	LoginVO loginVO = myLoginDAO.actionLogin(vo);
     	
     	// 3. 결과를 리턴한다.
     	if (loginVO != null && !loginVO.getUsrId().equals("") && !loginVO.getPwd().equals("")) {
     		return loginVO;
     	} else {
     		loginVO = new LoginVO();
     	}
     	
     	return loginVO;
     }
   
     /**
 	 * 아이디를 찾는다.
 	 * @param vo LoginVO
 	 * @return LoginVO
 	 * @exception Exception
 	 */
     public LoginVO searchId(LoginVO vo) throws Exception {

     	// 1. 이름, 이메일주소가 DB와 일치하는 사용자 ID를 조회한다.
     	LoginVO loginVO = myLoginDAO.searchId(vo);
     	
     	// 2. 결과를 리턴한다.
     	if (loginVO != null && !loginVO.getUsrId().equals("")) {
     		return loginVO;
     	} else {
     		loginVO = new LoginVO();
     	}
     	
     	return loginVO;
     }
     
     /**
 	 * 비밀번호를 찾는다.
 	 * @param vo LoginVO
 	 * @return boolean
 	 * @exception Exception
 	 */
     public boolean searchPassword(LoginVO vo) throws Exception {
     	
     	boolean result = true;
     	
     	// 1. 아이디, 이름, 이메일주소, 비밀번호 힌트, 비밀번호 정답이 DB와 일치하는 사용자 Password를 조회한다.
     	LoginVO loginVO = myLoginDAO.searchPassword(vo);
     	if (loginVO == null || loginVO.getPwd() == null || loginVO.getPwd().equals("")) {
     		return false;
     	}
     	
     	// 2. 임시 비밀번호를 생성한다.(영+영+숫+영+영+숫=6자리)
     	String newpassword = "";
     	for (int i = 1; i <= 6; i++) {
     		// 영자
     		if (i % 3 != 0) {
     			newpassword += EgovStringUtil.getRandomStr('a', 'z');
     		// 숫자
     		} else {
     			newpassword += EgovNumberUtil.getRandomNum(0, 9);
     		}
     	}
     	
     	// 3. 임시 비밀번호를 암호화하여 DB에 저장한다.
     	LoginVO pwVO = new LoginVO();
     	String enpassword = EgovFileScrty.encryptPassword(newpassword);
     	pwVO.setUsrId(vo.getUsrId());
     	pwVO.setPwd(enpassword); 
     	myLoginDAO.updatePassword(pwVO);
     	
     	// TODO - 4. 임시 비밀번호를 이메일 발송한다.(메일연동솔루션 활용)
//     	SndngMailVO sndngMailVO = new SndngMailVO();
//     	sndngMailVO.setDsptchPerson("webmaster");
//     	sndngMailVO.setRecptnPerson(vo.getEmail());
//     	sndngMailVO.setSj("[MOPAS] 임시 비밀번호를 발송했습니다.");
//     	sndngMailVO.setEmailCn("고객님의 임시 비밀번호는 " + newpassword + " 입니다.");
//     	sndngMailVO.setAtchFileId("");
//     	
//     	result = sndngMailRegistService.insertSndngMail(sndngMailVO);
     	
     	return result;
     }

	@SuppressWarnings("rawtypes")
	@Override
	public MyPageSessionVO selectSysm0100(MyPageSessionVO myPageSessionVO)
			throws Exception {
		return myLoginDAO.selectSysm0100(myPageSessionVO);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public MyPageSessionVO getMemberInfo(MyPageSessionVO myPageSessionVO) throws Exception {
		return myLoginDAO.getMemberInfo(myPageSessionVO);
	}

	@Override
	public String insertSyms0100ToSysm0130Info(MyPageSessionVO myPageSessionVO)
			throws Exception {
		return myLoginDAO.insertSyms0100ToSysm0130Info(myPageSessionVO);
	}

	@Override
	public void updatePasswordInfo(MyPageSessionVO myPageSessionVO)
			throws Exception {
		myLoginDAO.updatePassword(myPageSessionVO);
	}  
	
	@Override
	public void updateSysm0100PasswordInfo(MyPageSessionVO myPageSessionVO)
			throws Exception {
		myLoginDAO.updateSysm0100Password(myPageSessionVO);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public MyPageSessionVO selectPasswordInfo(MyPageSessionVO myPageSessionVO)
			throws Exception {
		return myLoginDAO.selectPasswordInfo(myPageSessionVO);
	}
	
	@Override
	public String insertSessionLoginSysm0120(MyPageSessionVO myPageSessionVO)
			throws Exception {
		return myLoginDAO.insertSessionLoginSysm0120(myPageSessionVO);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public MyPageSessionVO selectErrLoginSysm0120(MyPageSessionVO myPageSessionVO)
			throws Exception {
		return myLoginDAO.selectErrLoginSysm0120(myPageSessionVO);
	}
	
	public void updateErrLoginSysm0120(MyPageSessionVO myPageSessionVO)	throws Exception{
		myLoginDAO.updateErrLoginSysm0120(myPageSessionVO);
	}
    
    public String insertErrLoginSysm0120(MyPageSessionVO myPageSessionVO) throws Exception{
    	return myLoginDAO.insertErrLoginSysm0120(myPageSessionVO);
    }
    
    public void updateSysm0100UseInfo(MyPageSessionVO myPageSessionVO)	throws Exception{
		myLoginDAO.updateSysm0100UseInfo(myPageSessionVO);
	}
	
    public void deleteErrLoginSysm0120(MyPageSessionVO myPageSessionVO) throws Exception{
    	myLoginDAO.deleteErrLoginSysm0120(myPageSessionVO);
    }
    
    public void updateSessionChkSysm0120(MyPageSessionVO myPageSessionVO)	throws Exception{
		myLoginDAO.updateSessionChkSysm0120(myPageSessionVO);
	}
	
}
