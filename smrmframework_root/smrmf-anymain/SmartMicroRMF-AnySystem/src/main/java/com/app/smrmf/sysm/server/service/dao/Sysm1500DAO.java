package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfSysm1500SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm1500VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm1500DAO.java
 * @Description : Sysm1500 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm1500DAO")
public class Sysm1500DAO extends EgovAbstractDAO {

	/**
	 * SYSM1500?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Sysm1500VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertSysm1500(SysIfSysm1500VO vo) throws Exception {
        return (String)insert("sysm1500DAO.insertSysm1500_S", vo);
    }

    /**
	 * SYSM1500?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm1500VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateSysm1500(SysIfSysm1500VO vo) throws Exception {
        update("sysm1500DAO.updateSysm1500_S", vo);
    }

    /**
	 * SYSM1500?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm1500VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteSysm1500(SysIfSysm1500VO vo) throws Exception {
        delete("sysm1500DAO.deleteSysm1500_S", vo);
    }

    /**
	 * SYSM1500?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Sysm1500VO
	 * @return 조회?�� SYSM1500
	 * @exception Exception
	 */
    public SysIfSysm1500VO selectSysm1500(SysIfSysm1500VO vo) throws Exception {
        return (SysIfSysm1500VO) selectByPk("sysm1500DAO.selectSysm1500_S", vo);
    }

    /**
	 * SYSM1500 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM1500 목록
	 * @exception Exception
	 */
    public List<?> selectSysm1500List(SysIfSysm1500SrhVO searchVO) throws Exception {
        return list("sysm1500DAO.selectSysm1500List_D", searchVO);
    }

    /**
	 * SYSM1500 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM1500 �? �??��
	 * @exception
	 */
    public int selectSysm1500ListTotCnt(SysIfSysm1500SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm1500DAO.selectSysm1500ListTotCnt_S", searchVO);
    }

}
