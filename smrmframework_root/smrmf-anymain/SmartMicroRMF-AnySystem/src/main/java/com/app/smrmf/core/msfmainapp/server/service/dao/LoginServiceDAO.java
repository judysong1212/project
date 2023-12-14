/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.service.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.app.smrmf.sysm.server.vo.SysIfSysm0100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0100DAO.java
 * @Description : Sysm0100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.19
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("LoginServiceDAO")
public class LoginServiceDAO extends EgovAbstractDAO  {
  
    public static SysIfSysm0100VO selectSysm0100; // vo 필드 추가

	/**
	 * SYSM0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Sysm0100VO
	 * @return 조회한 SYSM0100
	 * @exception Exception
	 */
	public SysIfSysm0100VO selectSysm0100(SysIfSysm0100VO vo) throws Exception {
		return (SysIfSysm0100VO) selectByPk("LoginServiceDAO.selectSysm0100_S", vo);
    }
	 
    @Transactional
    public String insertConfSysm0100(SysIfSysm0100VO vo) throws Exception {
        return (String)insert("LoginServiceDAO.insertConfSysm0100_S", vo);
    }
    
    /**
  	 * SYSM0100을 수정한다.
  	 * @param vo - 수정할 정보가 담긴 Sysm0100VO
  	 * @return void형
  	 * @exception Exception
  	 */
      @Transactional
      public void updatePwdSysm0100(SysIfSysm0100VO vo) throws Exception {
          update("LoginServiceDAO.updatePwdSysm0100_S", vo);
      }

      /**
    	 * SYSM0100을 수정한다.
    	 * @param vo - 수정할 정보가 담긴 Sysm0100VO
    	 * @return void형
    	 * @exception Exception
    	 */
        @Transactional
        public void updateSysm040001() throws Exception {
            update("LoginServiceDAO.updateSysm040001_S", null);
        }
        
        /**
      	 * SYSM0100을 수정한다.
      	 * @param vo - 수정할 정보가 담긴 Sysm0100VO
      	 * @return void형
      	 * @exception Exception
      	 */
          @Transactional
          public void updateSysm040002() throws Exception {
              update("LoginServiceDAO.updateSysm040002_S", null);
          }

          

          /** hieju 수정 _06.28 
           *
           * @param admUser - 수정할 정보가 담긴 Sysm0100VO
           */
        // 로그인 실패횟수를 업데이트한다
          @Transactional
		public void updateLoginCount(SysIfSysm0100VO admUser) {
			update("LoginServiceDAO.updateLoginCount", admUser);
			
		}

		// 로그인 차단 업데이트
          @Transactional
		public void updateLoginLock(SysIfSysm0100VO admUser) {
			update("LoginServiceDAO.updateLoginLock", admUser);
			
		}

    
 
}
