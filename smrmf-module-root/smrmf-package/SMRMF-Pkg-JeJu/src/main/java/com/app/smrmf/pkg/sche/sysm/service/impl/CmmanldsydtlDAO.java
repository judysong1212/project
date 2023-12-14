package com.app.smrmf.pkg.sche.sysm.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.pkg.sche.sysm.service.vo.CmmanldsydtlSrhVO;
import com.app.smrmf.pkg.sche.sysm.service.vo.CmmanldsydtlVO;
import com.ext.dao.OtherAbstractDAO;

/**
 * @Class Name : CmmanldsydtlDAO.java
 * @Description : Cmmanldsydtl DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2018.01.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("CmmanldsydtlDAO")
public class CmmanldsydtlDAO extends OtherAbstractDAO {

	/**
	 * CMMANLDSYDTL?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? CmmanldsydtlVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertCmmanldsydtl(CmmanldsydtlVO vo) throws Exception {
        return (String)insert("cmmanldsydtlDAO.insertCmmanldsydtl_S", vo);
    }

    /**
	 * CMMANLDSYDTL?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? CmmanldsydtlVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateCmmanldsydtl(CmmanldsydtlVO vo) throws Exception {
        update("cmmanldsydtlDAO.updateCmmanldsydtl_S", vo);
    }

    /**
	 * CMMANLDSYDTL?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? CmmanldsydtlVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteCmmanldsydtl(CmmanldsydtlVO vo) throws Exception {
        delete("cmmanldsydtlDAO.deleteCmmanldsydtl_S", vo);
    }

    /**
	 * CMMANLDSYDTL?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? CmmanldsydtlVO
	 * @return 조회?�� CMMANLDSYDTL
	 * @exception Exception
	 */
    public CmmanldsydtlVO selectCmmanldsydtl(CmmanldsydtlVO vo) throws Exception {
        return (CmmanldsydtlVO) selectByPk("cmmanldsydtlDAO.selectCmmanldsydtl_S", vo);
    }

    /**
	 * CMMANLDSYDTL 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return CMMANLDSYDTL 목록
	 * @exception Exception
	 */
    public List<?> selectCmmanldsydtlList(CmmanldsydtlSrhVO searchVO) throws Exception {
        return list("cmmanldsydtlDAO.selectCmmanldsydtlList_D", searchVO);
    }

    /**
	 * CMMANLDSYDTL �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return CMMANLDSYDTL �? �??��
	 * @exception
	 */
    public int selectCmmanldsydtlListTotCnt(CmmanldsydtlSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("cmmanldsydtlDAO.selectCmmanldsydtlListTotCnt_S", searchVO);
    }

}
