package com.app.smrmf.infc.sysif.msfpackage.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.system.SsomUserSrhVO;
import com.app.smrmf.sysm.server.vo.system.SsoxUserSrhVO;
import com.app.smrmf.sysm.server.vo.system.SsomUserVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : SsomUserDAO.java
 * @Description : SsomUser DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2018.01.24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SysIfSsomUserDAO")
public class SysIfSsomUserDAO extends EgovAbstractDAO {

	/**
	 * SSOM_USER?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? SsomUserVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertSsomUser(SsomUserVO vo) throws Exception {
        return (String)insert("ssomUserDAO.insertSsomUser_S", vo);
    }

    /**
	 * SSOM_USER?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? SsomUserVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateSsomUser(SsomUserVO vo) throws Exception {
        update("ssomUserDAO.updateSsomUser_S", vo);
    }

    /**
	 * SSOM_USER?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? SsomUserVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteSsomUser(SsomUserVO vo) throws Exception {
        delete("ssomUserDAO.deleteSsomUser_S", vo);
    }

    /**
	 * SSOM_USER?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? SsomUserVO
	 * @return 조회?�� SSOM_USER
	 * @exception Exception
	 */
    public SsomUserVO selectSsomUser(SsomUserVO vo) throws Exception {
        return (SsomUserVO) selectByPk("ssomUserDAO.selectSsomUser_S", vo);
    }

    /**
	 * SSOM_USER 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SSOM_USER 목록
	 * @exception Exception
	 */
    public List<?> selectSsomUserList(SsomUserSrhVO searchVO) throws Exception {
        return list("ssomUserDAO.selectSsomUserList_D", searchVO);
    }

    /**
	 * SSOM_USER �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SSOM_USER �? �??��
	 * @exception
	 */
    public int selectSsomUserListTotCnt(SsomUserSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ssomUserDAO.selectSsomUserListTotCnt_S", searchVO);
    }


   
     /**
  	 * SSOX_USER 목록을 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return SSOX_USER 목록
  	 * @exception Exception
  	 */
      public List selectSsomIfUserList(SsoxUserSrhVO searchVO) throws Exception {
          return list("ssomUserDAO.selectSsomIfUserList_D", searchVO);
      }

      /**
  	 * SSOX_USER 총 갯수를 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return SSOX_USER 총 갯수
  	 * @exception
  	 */
      public int selectSsomIfUserListTotCnt(SsoxUserSrhVO searchVO) {
          return (Integer)getSqlMapClientTemplate().queryForObject("ssomUserDAO.selectSsomIfUserListTotCnt_S", searchVO);
      }
}
