package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfSysb0500SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysb0500VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysb0500DAO.java
 * @Description : Sysb0500 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysb0500DAO")
public class Sysb0500DAO extends EgovAbstractDAO {

	/**
	 * SYSB0500?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Sysb0500VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertSysb0500(SysIfSysb0500VO vo) throws Exception {
        return (String)insert("sysb0500DAO.insertSysb0500_S", vo);
    }

    /**
	 * SYSB0500?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysb0500VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateSysb0500(SysIfSysb0500VO vo) throws Exception {
        update("sysb0500DAO.updateSysb0500_S", vo);
    }

    /**
	 * SYSB0500?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysb0500VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteSysb0500(SysIfSysb0500VO vo) throws Exception {
        delete("sysb0500DAO.deleteSysb0500_S", vo);
    }

    /**
	 * SYSB0500?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Sysb0500VO
	 * @return 조회?�� SYSB0500
	 * @exception Exception
	 */
    public SysIfSysb0500VO selectSysb0500(SysIfSysb0500VO vo) throws Exception {
        return (SysIfSysb0500VO) selectByPk("sysb0500DAO.selectSysb0500_S", vo);
    }

    /**
	 * SYSB0500 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSB0500 목록
	 * @exception Exception
	 */
    public List<?> selectSysb0500List(SysIfSysb0500SrhVO searchVO) throws Exception {
        return list("sysb0500DAO.selectSysb0500List_D", searchVO);
    }

    /**
	 * SYSB0500 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSB0500 �? �??��
	 * @exception
	 */
    public int selectSysb0500ListTotCnt(SysIfSysb0500SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysb0500DAO.selectSysb0500ListTotCnt_S", searchVO);
    }

}
