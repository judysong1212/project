package com.app.smrmf.ssocom.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.vo.system.SsoxUserSrhVO;
import com.app.smrmf.sysm.server.vo.system.SsoxUserVO;
import com.ext.dao.OtherAbstractDAO;

/**
 * @Class Name : SsoxUserDAO.java
 * @Description : SsoxUser DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.08.28
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SsoxSmrmfDAO")
public class SsoxSmrmfDAO extends OtherAbstractDAO {

	/**
	 * SSOX_USER을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SsoxUserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertSsoxUser(SsoxUserVO vo) throws Exception {
        return (String)insert("ssoxUserDAO.insertSsoxUser_S", vo);
    }

    /**
	 * SSOX_USER을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SsoxUserVO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateSsoxUser(SsoxUserVO vo) throws Exception {
        update("ssoxUserDAO.updateSsoxUser_S", vo);
    }

    /**
	 * SSOX_USER을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SsoxUserVO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteSsoxUser(SsoxUserVO vo) throws Exception {
        delete("ssoxUserDAO.deleteSsoxUser_S", vo);
    }

    /**
	 * SSOX_USER을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SsoxUserVO
	 * @return 조회한 SSOX_USER
	 * @exception Exception
	 */
    public SsoxUserVO selectSsoxUser(SsoxUserVO vo) throws Exception {
        return (SsoxUserVO) selectByPk("ssoxUserDAO.selectSsoxUser_S", vo);
    }

    /**
	 * SSOX_USER 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SSOX_USER 목록
	 * @exception Exception
	 */
    public List selectSsoxUserList(SsoxUserSrhVO searchVO) throws Exception {
        return list("ssoxUserDAO.selectSsoxUserList_D", searchVO);
    }

    /**
	 * SSOX_USER 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SSOX_USER 총 갯수
	 * @exception
	 */
    public int selectSsoxUserListTotCnt(SsoxUserSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ssoxUserDAO.selectSsoxUserListTotCnt_S", searchVO);
    }

    
    /**
  	 * SSOX_USER 목록을 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return SSOX_USER 목록
  	 * @exception Exception
  	 */
      public List selectMagicSsoUserList(SsoxUserSrhVO searchVO) throws Exception {
          return list("ssoxUserDAO.selectMagicSsoUserList_D", searchVO);
      }

      /**
  	 * SSOX_USER 총 갯수를 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return SSOX_USER 총 갯수
  	 * @exception
  	 */
      public int selectMagicSsoUserListTotCnt(SsoxUserSrhVO searchVO) {
          return (Integer)getSqlMapClientTemplate().queryForObject("ssoxUserDAO.selectMagicSsoUserListTotCnt_S", searchVO);
      }
      
    
}
