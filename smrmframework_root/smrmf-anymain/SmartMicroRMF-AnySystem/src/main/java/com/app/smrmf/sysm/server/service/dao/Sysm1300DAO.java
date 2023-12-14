package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfSysm1300SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm1300VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm1300DAO.java
 * @Description : Sysm1300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm1300DAO")
public class Sysm1300DAO extends EgovAbstractDAO {

	/**
	 * SYSM1300?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Sysm1300VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertSysm1300(SysIfSysm1300VO vo) throws Exception {
        return (String)insert("sysm1300DAO.insertSysm1300_S", vo);
    }

    /**
	 * SYSM1300?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm1300VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateSysm1300(SysIfSysm1300VO vo) throws Exception {
        update("sysm1300DAO.updateSysm1300_S", vo);
    }

    /**
	 * SYSM1300?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm1300VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteSysm1300(SysIfSysm1300VO vo) throws Exception {
        delete("sysm1300DAO.deleteSysm1300_S", vo);
    }

    /**
	 * SYSM1300?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Sysm1300VO
	 * @return 조회?�� SYSM1300
	 * @exception Exception
	 */
    public SysIfSysm1300VO selectSysm1300(SysIfSysm1300VO vo) throws Exception {
        return (SysIfSysm1300VO) selectByPk("sysm1300DAO.selectSysm1300_S", vo);
    }

    /**
	 * SYSM1300 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM1300 목록
	 * @exception Exception
	 */
    public List<?> selectSysm1300List(SysIfSysm1300SrhVO searchVO) throws Exception {
        return list("sysm1300DAO.selectSysm1300List_D", searchVO);
    }

    /**
	 * SYSM1300 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM1300 �? �??��
	 * @exception
	 */
    public int selectSysm1300ListTotCnt(SysIfSysm1300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm1300DAO.selectSysm1300ListTotCnt_S", searchVO);
    }

}
