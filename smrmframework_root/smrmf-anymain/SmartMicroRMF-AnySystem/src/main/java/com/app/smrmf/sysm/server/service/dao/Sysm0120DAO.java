package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfSysm0120SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0120VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0120DAO.java
 * @Description : Sysm0120 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm0120DAO")
public class Sysm0120DAO extends EgovAbstractDAO {

	/**
	 * SYSM0120?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Sysm0120VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertSysm0120(SysIfSysm0120VO vo) throws Exception {
        return (String)insert("sysm0120DAO.insertSysm0120_S", vo);
    }

    /**
	 * SYSM0120?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm0120VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateSysm0120(SysIfSysm0120VO vo) throws Exception {
        update("sysm0120DAO.updateSysm0120_S", vo);
    }

    /**
	 * SYSM0120?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm0120VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteSysm0120(SysIfSysm0120VO vo) throws Exception {
        delete("sysm0120DAO.deleteSysm0120_S", vo);
    }

    /**
	 * SYSM0120?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Sysm0120VO
	 * @return 조회?�� SYSM0120
	 * @exception Exception
	 */
    public SysIfSysm0120VO selectSysm0120(SysIfSysm0120VO vo) throws Exception {
        return (SysIfSysm0120VO) selectByPk("sysm0120DAO.selectSysm0120_S", vo);
    }

    /**
	 * SYSM0120 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM0120 목록
	 * @exception Exception
	 */
    public List<?> selectSysm0120List(SysIfSysm0120SrhVO searchVO) throws Exception {
        return list("sysm0120DAO.selectSysm0120List_D", searchVO);
    }

    /**
	 * SYSM0120 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM0120 �? �??��
	 * @exception
	 */
    public int selectSysm0120ListTotCnt(SysIfSysm0120SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0120DAO.selectSysm0120ListTotCnt_S", searchVO);
    }

}
