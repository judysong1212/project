package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.vo.SysIfSysm0100SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0100DAO.java
 * @Description : Sysm0100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm0100DAO")
public class Sysm0100DAO extends EgovAbstractDAO {

	/**
	 * SYSM0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SysIfSysm0100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertSysm0100(SysIfSysm0100VO vo) throws Exception {
        return (String)insert("sysm0100DAO.insertSysm0100_S", vo);
    }
    
    @Transactional
    public String insertConfSysm0100(SysIfSysm0100VO vo) throws Exception {
        return (String)insert("sysm0100DAO.insertConfSysm0100_S", vo);
    }


    /**
	 * SYSM0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SysIfSysm0100VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateSysm0100(SysIfSysm0100VO vo) throws Exception {
        update("sysm0100DAO.updateSysm0100_S", vo);
    }
    
    @Transactional
    public String insertSysmUsr0100(SysIfSysm0100VO vo) throws Exception {
        return (String)insert("sysm0100DAO.insertSysmUsr0100_S", vo);
    }
    @Transactional
    public void updateSysmUsr0100(SysIfSysm0100VO vo) throws Exception {
        update("sysm0100DAO.updateSysmUsr0100_S", vo);
    }
    
    /**
	 * SYSM0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SysIfSysm0100VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePwdSysm0100(SysIfSysm0100VO vo) throws Exception {
        update("sysm0100DAO.updatePwdSysm0100_S", vo);
    }


    /**
	 * SYSM0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SysIfSysm0100VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteSysm0100(SysIfSysm0100VO vo) throws Exception {
        delete("sysm0100DAO.deleteSysm0100_S", vo);
    }

    /**
	 * SYSM0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SysIfSysm0100VO
	 * @return 조회한 SYSM0100
	 * @exception Exception
	 */
    public SysIfSysm0100VO selectSysm0100(SysIfSysm0100VO vo) throws Exception {
        return (SysIfSysm0100VO) selectByPk("sysm0100DAO.selectSysm0100_S", vo);
    }

    /**
	 * SYSM0100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0100 목록
	 * @exception Exception
	 */
    public List selectSysm0100List(SysIfSysm0100SrhVO searchVO) throws Exception {
        return list("sysm0100DAO.selectSysm0100List_D", searchVO);
    }

    
    public List selectSysm0100ExlList(SysIfSysm0100SrhVO searchVO) throws Exception {
        return list("sysm0100DAO.selectSysm0100ExlList_D", searchVO);
    }
    

    
    /**
	 * 비밀번호 초기화를 위해 해당 아이디의 정보를 가져온다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0100 목록
	 * @exception Exception
	 */
    public List selectSysm0100Info(SysIfSysm0100VO vo) throws Exception {
        return list("sysm0100DAO.getUsrInfo", vo);
    }

    
    /**
	 * SYSM0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0100 총 갯수
	 * @exception
	 */
    public int selectSysm0100ListTotCnt(SysIfSysm0100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0100DAO.selectSysm0100ListTotCnt_S", searchVO);
    }
    
    
    public List selectSSoUserList() throws Exception {
        return list("sysm0100DAO.selectSSoUserList_D",null);
    }
    
 
    
    public void updateUserSysm0100(SysIfSysm0100VO vo) throws Exception {
        update("sysm0100DAO.updateUserSysm0100_S", vo);
    }


    /**
	 * SYSM0100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0100 목록
	 * @exception Exception
	 */
    public List selectSysm0700ToSysm0100List(SysIfSysm0100SrhVO searchVO) throws Exception {
        return list("sysm0100DAO.selectSysm0700ToSysm0100List_D", searchVO);
    }

    /**
	 * SYSM0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0100 총 갯수
	 * @exception
	 */
    public int selectSysm0700ToSysm0100ListTotCnt(SysIfSysm0100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0100DAO.selectSysm0700ToSysm0100ListTotCnt_S", searchVO);
    }
     
    /**
   	 * SYSM0100 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return SYSM0100 목록
   	 * @exception Exception
   	 */
       public List selectPopupSysm0100List(SysIfSysm0100SrhVO searchVO) throws Exception {
           return list("sysm0100DAO.selectPopupSysm0100List_D", searchVO);
       }

       /**
   	 * SYSM0100 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return SYSM0100 총 갯수
   	 * @exception
   	 */
       public int selectPopupSysm0100ListTotCnt(SysIfSysm0100SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("sysm0100DAO.selectPopupSysm0100ListTotCnt_S", searchVO);
       }  
    

}
