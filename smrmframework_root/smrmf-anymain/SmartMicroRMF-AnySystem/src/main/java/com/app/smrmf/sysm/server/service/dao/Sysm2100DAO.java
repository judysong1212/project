package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfSysm2100SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm2100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm2100DAO.java
 * @Description : Sysm2100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm2100DAO")
public class Sysm2100DAO extends EgovAbstractDAO {

	/**
	 * SYSM2100?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Sysm2100VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertSysm2100(SysIfSysm2100VO vo) throws Exception {
        return (String)insert("sysm2100DAO.insertSysm2100_S", vo);
    }

    /**
	 * SYSM2100?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm2100VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateSysm2100(SysIfSysm2100VO vo) throws Exception {
        update("sysm2100DAO.updateSysm2100_S", vo);
    }

    /**
	 * SYSM2100?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm2100VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteSysm2100(SysIfSysm2100VO vo) throws Exception {
        delete("sysm2100DAO.deleteSysm2100_S", vo);
    }

    /**
	 * SYSM2100?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Sysm2100VO
	 * @return 조회?�� SYSM2100
	 * @exception Exception
	 */
    public SysIfSysm2100VO selectSysm2100(SysIfSysm2100VO vo) throws Exception {
        return (SysIfSysm2100VO) selectByPk("sysm2100DAO.selectSysm2100_S", vo);
    }

    /**
	 * SYSM2100 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM2100 목록
	 * @exception Exception
	 */
    public List<?> selectSysm2100List(SysIfSysm2100SrhVO searchVO) throws Exception {
        return list("sysm2100DAO.selectSysm2100List_D", searchVO);
    }

    /**
	 * SYSM2100 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM2100 �? �??��
	 * @exception
	 */
    public int selectSysm2100ListTotCnt(SysIfSysm2100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm2100DAO.selectSysm2100ListTotCnt_S", searchVO);
    }

}
