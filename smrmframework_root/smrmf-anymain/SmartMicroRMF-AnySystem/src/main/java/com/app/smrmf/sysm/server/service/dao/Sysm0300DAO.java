package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.vo.SysIfSysm0300SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0300VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0300DAO.java
 * @Description : Sysm0300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.20
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm0300DAO")
public class Sysm0300DAO extends EgovAbstractDAO {

	/**
	 * SYSM0300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Sysm0300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertSysm0300(SysIfSysm0300VO vo) throws Exception {
        return (String)insert("sysm0300DAO.insertSysm0300_S", vo);
    }

    /**
	 * SYSM0300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Sysm0300VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateSysm0300(SysIfSysm0300VO vo) throws Exception {
        update("sysm0300DAO.updateSysm0300_S", vo);
    }

    /**
	 * SYSM0300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Sysm0300VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteSysm0300(SysIfSysm0300VO vo) throws Exception {
        delete("sysm0300DAO.deleteSysm0300_S", vo);
    }

    /**
	 * SYSM0300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Sysm0300VO
	 * @return 조회한 SYSM0300
	 * @exception Exception
	 */
    public SysIfSysm0300VO selectSysm0300(SysIfSysm0300VO vo) throws Exception {
        return (SysIfSysm0300VO) selectByPk("sysm0300DAO.selectSysm0300_S", vo);
    }

    /**
	 * SYSM0300 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0300 목록
	 * @exception Exception
	 */
    public List selectSysm0300List(SysIfSysm0300SrhVO searchVO) throws Exception {
        return list("sysm0300DAO.selectSysm0300List_D", searchVO);
    }

    /**
	 * SYSM0300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0300 총 갯수
	 * @exception
	 */
    public int selectSysm0300ListTotCnt(SysIfSysm0300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0300DAO.selectSysm0300ListTotCnt_S", searchVO);
    }
    
    
    /**
   	 * SYSM0300 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return SYSM0300 목록
   	 * @exception Exception
   	 */
       public List selectSysm0500ToSysm0300List(SysIfSysm0300SrhVO searchVO) throws Exception {
           return list("sysm0300DAO.selectSysm0500ToSysm0300List_D", searchVO);
       }
       
       
       
       /**
   	 * SYSM0300 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return SYSM0300 총 갯수
   	 * @exception
   	 */
       public int selectSelectSysmMtr0500ToSysm0300ListTotCnt(SysIfSysm0300SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("sysm0300DAO.selectSelectSysmMtr0500ToSysm0300ListTotCnt_S", searchVO);
       }
       
       
       /**
      	 * SYSM0300 목록을 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return SYSM0300 목록
      	 * @exception Exception
      	 */
          public List selectSelectSysmMtr0500ToSysm0300List(SysIfSysm0300SrhVO searchVO) throws Exception {
              return list("sysm0300DAO.selectSelectSysmMtr0500ToSysm0300List_D", searchVO);
          }
    
    

}
