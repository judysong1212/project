package com.app.smrmf.infc.sysif.msfpackage.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.system.SsomDeptSrhVO;
import com.app.smrmf.sysm.server.vo.system.SsomDeptVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : SsomDeptDAO.java
 * @Description : SsomDept DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2018.01.24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SysIfSsomDeptDAO")
public class SysIfSsomDeptDAO extends EgovAbstractDAO {

	/**
	 * SSOM_DEPT?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? SsomDeptVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertSsomDept(SsomDeptVO vo) throws Exception {
        return (String)insert("ssomDeptDAO.insertSsomDept_S", vo);
    }

    /**
	 * SSOM_DEPT?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? SsomDeptVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateSsomDept(SsomDeptVO vo) throws Exception {
        update("ssomDeptDAO.updateSsomDept_S", vo);
    }

    /**
	 * SSOM_DEPT?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? SsomDeptVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteSsomDept(SsomDeptVO vo) throws Exception {
        delete("ssomDeptDAO.deleteSsomDept_S", vo);
    }

    /**
	 * SSOM_DEPT?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? SsomDeptVO
	 * @return 조회?�� SSOM_DEPT
	 * @exception Exception
	 */
    public SsomDeptVO selectSsomDept(SsomDeptVO vo) throws Exception {
        return (SsomDeptVO) selectByPk("ssomDeptDAO.selectSsomDept_S", vo);
    }

    /**
	 * SSOM_DEPT 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SSOM_DEPT 목록
	 * @exception Exception
	 */
    public List<?> selectSsomDeptList(SsomDeptSrhVO searchVO) throws Exception {
        return list("ssomDeptDAO.selectSsomDeptList_D", searchVO);
    }

    /**
	 * SSOM_DEPT �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return SSOM_DEPT �? �??��
	 * @exception
	 */
    public int selectSsomDeptListTotCnt(SsomDeptSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ssomDeptDAO.selectSsomDeptListTotCnt_S", searchVO);
    }

}
