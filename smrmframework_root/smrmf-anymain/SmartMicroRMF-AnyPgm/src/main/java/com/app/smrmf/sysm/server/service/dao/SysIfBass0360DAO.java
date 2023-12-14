package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.service.vo.SysIfBass0360SrhVO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0360VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0360DAO.java
 * @Description : Bass0360 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.11.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SysIfBass0360DAO")
public class SysIfBass0360DAO extends EgovAbstractDAO {

	/**
	 * BASS0360을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0360VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertBass0360(SysIfBass0360VO vo) throws Exception {
        return (String)insert("sysIfBass0360DAO.insertBass0360_S", vo);
    }

    /**
	 * BASS0360을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0360VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateBass0360(SysIfBass0360VO vo) throws Exception {
        update("sysIfBass0360DAO.updateBass0360_S", vo);
    }

    /**
	 * BASS0360을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0360VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBass0360(SysIfBass0360VO vo) throws Exception {
        delete("sysIfBass0360DAO.deleteBass0360_S", vo);
    }

    /**
	 * BASS0360을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0360VO
	 * @return 조회한 BASS0360
	 * @exception Exception
	 */
    public SysIfBass0360VO selectBass0360(SysIfBass0360VO vo) throws Exception {
        return (SysIfBass0360VO) selectByPk("sysIfBass0360DAO.selectBass0360_S", vo);
    }

    /**
	 * BASS0360 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0360 목록
	 * @exception Exception
	 */
    public List<?> selectBass0360List(SysIfBass0360SrhVO searchVO) throws Exception {
        return list("sysIfBass0360DAO.selectBass0360List_D", searchVO);
    }

    /**
	 * BASS0360 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0360 총 갯수
	 * @exception
	 */
    public int selectBass0360ListTotCnt(SysIfBass0360SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysIfBass0360DAO.selectBass0360ListTotCnt_S", searchVO);
    }

    /**
	 * BASS0360 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0360 목록
	 * @exception Exception
	 */
    public List<?> selectSysm0600TopToBass0360List(SysIfBass0360SrhVO searchVO) throws Exception {
        return list("sysIfBass0360DAO.selectSysm0600TopToBass0360List_D", searchVO);
    }

    /**
	 * BASS0360 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0360 총 갯수
	 * @exception
	 */
    public int selectSysm0600TopToBass0360ListTotCnt(SysIfBass0360SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysIfBass0360DAO.selectSysm0600TopToBass0360ListTotCnt_S", searchVO);
    }
    
    /**
	 * BASS0360 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0360 목록
	 * @exception Exception
	 */
    public List<?> selectSysm0600BtmToBass0360List(SysIfBass0360SrhVO searchVO) throws Exception {
        return list("sysIfBass0360DAO.selectSysm0600BtmToBass0360List_D", searchVO);
    }

    /**
	 * BASS0360 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0360 총 갯수
	 * @exception
	 */
    public int selectSysm0600BtmToBass0360ListTotCnt(SysIfBass0360SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysIfBass0360DAO.selectSysm0600BtmToBass0360ListTotCnt_S", searchVO);
    }
    
    
    /** 신메뉴적용을 위해 처리 */
    
    /**
   	 * BASS0360 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return BASS0360 목록
   	 * @exception Exception
   	 */
       public List<?> selectSysmUsr0500TopToBass0360List(SysIfBass0360SrhVO searchVO) throws Exception {
           return list("sysIfBass0360DAO.selectSysmUsr0500TopToBass0360List_D", searchVO);
       }

       /**
   	 * BASS0360 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return BASS0360 총 갯수
   	 * @exception
   	 */
       public int selectSysmUsr0500TopToBass0360ListTotCnt(SysIfBass0360SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("sysIfBass0360DAO.selectSysmUsr0500TopToBass0360ListTotCnt_S", searchVO);
       }
       
       /**
   	 * BASS0360 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return BASS0360 목록
   	 * @exception Exception
   	 */
       public List<?> selectSysmUsr0500BtmToBass0360List(SysIfBass0360SrhVO searchVO) throws Exception {
           return list("sysIfBass0360DAO.selectSysmUsr0500BtmToBass0360List_D", searchVO);
       }

       /**
   	 * BASS0360 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return BASS0360 총 갯수
   	 * @exception
   	 */
       public int selectSysmUsr0500BtmToBass0360ListTotCnt(SysIfBass0360SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("sysIfBass0360DAO.selectSysmUsr0500BtmToBass0360ListTotCnt_S", searchVO);
       }
       
    
    
    /**
	 * BASS0360 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0360 목록
	 * @exception Exception
	 */
    public List<?> selectSysm0700ToBass0360List(SysIfBass0360SrhVO searchVO) throws Exception {
        return list("sysIfBass0360DAO.selectSysm0700ToBass0360List_D", searchVO);
    }

    /**
	 * BASS0360 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0360 총 갯수
	 * @exception
	 */
    public int selectSysm0700ToBass0360ListTotCnt(SysIfBass0360SrhVO searchVO) { 
        return (Integer)getSqlMapClientTemplate().queryForObject("sysIfBass0360DAO.selectSysm0700ToBass0360ListTotCnt_S", searchVO);
    }
    
    

    /**
  	 * BASS0360 목록을 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return BASS0360 목록
  	 * @exception Exception
  	 */
    public List<?> selectSysmUsr0400ToBass0360List(SysIfBass0360SrhVO searchVO) throws Exception {
        return list("sysIfBass0360DAO.selectSysmUsr0400ToBass0360List_D", searchVO);
    }

    /**
  	 * BASS0360 총 갯수를 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return BASS0360 총 갯수
  	 * @exception
  	 */
    public int selectSysmUsr0400ToBass0360ListTotCnt(SysIfBass0360SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysIfBass0360DAO.selectSysmUsr0400ToBass0360ListTotCnt_S", searchVO);
    }
      
    
}
