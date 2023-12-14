package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfSysm1100SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm1100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm1100DAO.java
 * @Description : Sysm1100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm1100DAO")
public class Sysm1100DAO extends EgovAbstractDAO {

	/**
	 * SYSM1100?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Sysm1100VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertSysm1100(SysIfSysm1100VO vo) throws Exception {
        return (String)insert("sysm1100DAO.insertSysm1100_S", vo);
    }

    /**
	 * SYSM1100?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm1100VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateSysm1100(SysIfSysm1100VO vo) throws Exception {
        update("sysm1100DAO.updateSysm1100_S", vo);
    }

    /**
	 * SYSM1100?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm1100VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteSysm1100(SysIfSysm1100VO vo) throws Exception {
        delete("sysm1100DAO.deleteSysm1100_S", vo);
    }

    /**
	 * SYSM1100?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Sysm1100VO
	 * @return 조회?�� SYSM1100
	 * @exception Exception
	 */
    public SysIfSysm1100VO selectSysm1100(SysIfSysm1100VO vo) throws Exception {
        return (SysIfSysm1100VO) selectByPk("sysm1100DAO.selectSysm1100_S", vo);
    }

    /**
	 * SYSM1100 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM1100 목록
	 * @exception Exception
	 */
    public List<?> selectSysm1100List(SysIfSysm1100SrhVO searchVO) throws Exception {
        return list("sysm1100DAO.selectSysm1100List_D", searchVO);
    }

    /**
	 * SYSM1100 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM1100 �? �??��
	 * @exception
	 */
    public int selectSysm1100ListTotCnt(SysIfSysm1100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm1100DAO.selectSysm1100ListTotCnt_S", searchVO);
    }

}
