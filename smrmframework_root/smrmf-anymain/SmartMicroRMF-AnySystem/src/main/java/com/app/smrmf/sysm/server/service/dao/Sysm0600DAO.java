package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfSysm0600SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0600VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0600DAO.java
 * @Description : Sysm0600 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm0600DAO")
public class Sysm0600DAO extends EgovAbstractDAO {

	/**
	 * SYSM0600?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Sysm0600VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertSysm0600(SysIfSysm0600VO vo) throws Exception {
        return (String)insert("sysm0600DAO.insertSysm0600_S", vo);
    }

    /**
	 * SYSM0600?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm0600VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateSysm0600(SysIfSysm0600VO vo) throws Exception {
        update("sysm0600DAO.updateSysm0600_S", vo);
    }

    /**
	 * SYSM0600?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm0600VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteSysm0600(SysIfSysm0600VO vo) throws Exception {
        delete("sysm0600DAO.deleteSysm0600_S", vo);
    }

    /**
	 * SYSM0600?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Sysm0600VO
	 * @return 조회?�� SYSM0600
	 * @exception Exception
	 */
    public SysIfSysm0600VO selectSysm0600(SysIfSysm0600VO vo) throws Exception {
        return (SysIfSysm0600VO) selectByPk("sysm0600DAO.selectSysm0600_S", vo);
    }

    /**
	 * SYSM0600 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM0600 목록
	 * @exception Exception
	 */
    public List<?> selectSysm0600List(SysIfSysm0600SrhVO searchVO) throws Exception {
        return list("sysm0600DAO.selectSysm0600List_D", searchVO);
    }

    /**
	 * SYSM0600 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM0600 �? �??��
	 * @exception
	 */
    public int selectSysm0600ListTotCnt(SysIfSysm0600SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0600DAO.selectSysm0600ListTotCnt_S", searchVO);
    }

}
