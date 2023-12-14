package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfSysm1200SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm1200VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm1200DAO.java
 * @Description : Sysm1200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm1200DAO")
public class Sysm1200DAO extends EgovAbstractDAO {

	/**
	 * SYSM1200?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Sysm1200VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertSysm1200(SysIfSysm1200VO vo) throws Exception {
        return (String)insert("sysm1200DAO.insertSysm1200_S", vo);
    }

    /**
	 * SYSM1200?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm1200VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateSysm1200(SysIfSysm1200VO vo) throws Exception {
        update("sysm1200DAO.updateSysm1200_S", vo);
    }

    /**
	 * SYSM1200?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm1200VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteSysm1200(SysIfSysm1200VO vo) throws Exception {
        delete("sysm1200DAO.deleteSysm1200_S", vo);
    }

    /**
	 * SYSM1200?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Sysm1200VO
	 * @return 조회?�� SYSM1200
	 * @exception Exception
	 */
    public SysIfSysm1200VO selectSysm1200(SysIfSysm1200VO vo) throws Exception {
        return (SysIfSysm1200VO) selectByPk("sysm1200DAO.selectSysm1200_S", vo);
    }

    /**
	 * SYSM1200 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM1200 목록
	 * @exception Exception
	 */
    public List<?> selectSysm1200List(SysIfSysm1200SrhVO searchVO) throws Exception {
        return list("sysm1200DAO.selectSysm1200List_D", searchVO);
    }

    /**
	 * SYSM1200 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM1200 �? �??��
	 * @exception
	 */
    public int selectSysm1200ListTotCnt(SysIfSysm1200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm1200DAO.selectSysm1200ListTotCnt_S", searchVO);
    }

}
