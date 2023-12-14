package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfSysm1400SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm1400VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm1400DAO.java
 * @Description : Sysm1400 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm1400DAO")
public class Sysm1400DAO extends EgovAbstractDAO {

	/**
	 * SYSM1400?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Sysm1400VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertSysm1400(SysIfSysm1400VO vo) throws Exception {
        return (String)insert("sysm1400DAO.insertSysm1400_S", vo);
    }

    /**
	 * SYSM1400?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm1400VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateSysm1400(SysIfSysm1400VO vo) throws Exception {
        update("sysm1400DAO.updateSysm1400_S", vo);
    }

    /**
	 * SYSM1400?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm1400VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteSysm1400(SysIfSysm1400VO vo) throws Exception {
        delete("sysm1400DAO.deleteSysm1400_S", vo);
    }

    /**
	 * SYSM1400?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Sysm1400VO
	 * @return 조회?�� SYSM1400
	 * @exception Exception
	 */
    public SysIfSysm1400VO selectSysm1400(SysIfSysm1400VO vo) throws Exception {
        return (SysIfSysm1400VO) selectByPk("sysm1400DAO.selectSysm1400_S", vo);
    }

    /**
	 * SYSM1400 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM1400 목록
	 * @exception Exception
	 */
    public List<?> selectSysm1400List(SysIfSysm1400SrhVO searchVO) throws Exception {
        return list("sysm1400DAO.selectSysm1400List_D", searchVO);
    }

    /**
	 * SYSM1400 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM1400 �? �??��
	 * @exception
	 */
    public int selectSysm1400ListTotCnt(SysIfSysm1400SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm1400DAO.selectSysm1400ListTotCnt_S", searchVO);
    }

}
