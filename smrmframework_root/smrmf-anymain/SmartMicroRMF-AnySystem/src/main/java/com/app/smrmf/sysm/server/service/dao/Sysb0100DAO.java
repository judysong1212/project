package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfSysb0100SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysb0100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysb0100DAO.java
 * @Description : Sysb0100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysb0100DAO")
public class Sysb0100DAO extends EgovAbstractDAO {

	/**
	 * SYSB0100?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Sysb0100VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertSysb0100(SysIfSysb0100VO vo) throws Exception {
        return (String)insert("sysb0100DAO.insertSysb0100_S", vo);
    }

    /**
	 * SYSB0100?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysb0100VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateSysb0100(SysIfSysb0100VO vo) throws Exception {
        update("sysb0100DAO.updateSysb0100_S", vo);
    }

    /**
	 * SYSB0100?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysb0100VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteSysb0100(SysIfSysb0100VO vo) throws Exception {
        delete("sysb0100DAO.deleteSysb0100_S", vo);
    }

    /**
	 * SYSB0100?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Sysb0100VO
	 * @return 조회?�� SYSB0100
	 * @exception Exception
	 */
    public SysIfSysb0100VO selectSysb0100(SysIfSysb0100VO vo) throws Exception {
        return (SysIfSysb0100VO) selectByPk("sysb0100DAO.selectSysb0100_S", vo);
    }

    /**
	 * SYSB0100 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSB0100 목록
	 * @exception Exception
	 */
    public List<?> selectSysb0100List(SysIfSysb0100SrhVO searchVO) throws Exception {
        return list("sysb0100DAO.selectSysb0100List_D", searchVO);
    }

    /**
	 * SYSB0100 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSB0100 �? �??��
	 * @exception
	 */
    public int selectSysb0100ListTotCnt(SysIfSysb0100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysb0100DAO.selectSysb0100ListTotCnt_S", searchVO);
    }

}
