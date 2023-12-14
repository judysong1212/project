package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfSysm0130SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0130VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0130DAO.java
 * @Description : Sysm0130 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm0130DAO")
public class Sysm0130DAO extends EgovAbstractDAO {

	/**
	 * SYSM0130?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Sysm0130VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertSysm0130(SysIfSysm0130VO vo) throws Exception {
        return (String)insert("sysm0130DAO.insertSysm0130_S", vo);
    }

    /**
	 * SYSM0130?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm0130VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateSysm0130(SysIfSysm0130VO vo) throws Exception {
        update("sysm0130DAO.updateSysm0130_S", vo);
    }

    /**
	 * SYSM0130?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Sysm0130VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteSysm0130(SysIfSysm0130VO vo) throws Exception {
        delete("sysm0130DAO.deleteSysm0130_S", vo);
    }

    /**
	 * SYSM0130?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Sysm0130VO
	 * @return 조회?�� SYSM0130
	 * @exception Exception
	 */
    public SysIfSysm0130VO selectSysm0130(SysIfSysm0130VO vo) throws Exception {
        return (SysIfSysm0130VO) selectByPk("sysm0130DAO.selectSysm0130_S", vo);
    }

    /**
	 * SYSM0130 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM0130 목록
	 * @exception Exception
	 */
    public List<?> selectSysm0130List(SysIfSysm0130SrhVO searchVO) throws Exception {
        return list("sysm0130DAO.selectSysm0130List_D", searchVO);
    }

    /**
	 * SYSM0130 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SYSM0130 �? �??��
	 * @exception
	 */
    public int selectSysm0130ListTotCnt(SysIfSysm0130SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0130DAO.selectSysm0130ListTotCnt_S", searchVO);
    }

}
