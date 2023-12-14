package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfSysm1000SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm1000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm1000DAO.java
 * @Description : Sysm1000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm1000DAO")
public class Sysm1000DAO extends EgovAbstractDAO {

	/**
	 * SYSM1000?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Sysm1000VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertSysm1000(SysIfSysm1000VO vo) throws Exception {
        return (String)insert("sysm1000DAO.insertSysm1000_S", vo);
    }

    /**
	 * SYSM1000?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm1000VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateSysm1000(SysIfSysm1000VO vo) throws Exception {
        update("sysm1000DAO.updateSysm1000_S", vo);
    }

    /**
	 * SYSM1000?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm1000VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteSysm1000(SysIfSysm1000VO vo) throws Exception {
        delete("sysm1000DAO.deleteSysm1000_S", vo);
    }

    /**
	 * SYSM1000?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Sysm1000VO
	 * @return 조회?�� SYSM1000
	 * @exception Exception
	 */
    public SysIfSysm1000VO selectSysm1000(SysIfSysm1000VO vo) throws Exception {
        return (SysIfSysm1000VO) selectByPk("sysm1000DAO.selectSysm1000_S", vo);
    }

    /**
	 * SYSM1000 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM1000 목록
	 * @exception Exception
	 */
    public List<?> selectSysm1000List(SysIfSysm1000SrhVO searchVO) throws Exception {
        return list("sysm1000DAO.selectSysm1000List_D", searchVO);
    }

    /**
	 * SYSM1000 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM1000 �? �??��
	 * @exception
	 */
    public int selectSysm1000ListTotCnt(SysIfSysm1000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm1000DAO.selectSysm1000ListTotCnt_S", searchVO);
    }

}
