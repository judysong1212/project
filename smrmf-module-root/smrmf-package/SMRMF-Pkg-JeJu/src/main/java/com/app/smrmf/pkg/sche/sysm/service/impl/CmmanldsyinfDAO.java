package com.app.smrmf.pkg.sche.sysm.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.pkg.sche.sysm.service.vo.CmmanldsyinfSrhVO;
import com.app.smrmf.pkg.sche.sysm.service.vo.CmmanldsyinfVO;
import com.ext.dao.OtherAbstractDAO;

/**
 * @Class Name : CmmanldsyinfDAO.java
 * @Description : Cmmanldsyinf DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2018.01.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("CmmanldsyinfDAO")
public class CmmanldsyinfDAO extends OtherAbstractDAO {

	/**
	 * CMMANLDSYINF?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? CmmanldsyinfVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertCmmanldsyinf(CmmanldsyinfVO vo) throws Exception {
        return (String)insert("cmmanldsyinfDAO.insertCmmanldsyinf_S", vo);
    }

    /**
	 * CMMANLDSYINF?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? CmmanldsyinfVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateCmmanldsyinf(CmmanldsyinfVO vo) throws Exception {
        update("cmmanldsyinfDAO.updateCmmanldsyinf_S", vo);
    }

    /**
	 * CMMANLDSYINF?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? CmmanldsyinfVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteCmmanldsyinf(CmmanldsyinfVO vo) throws Exception {
        delete("cmmanldsyinfDAO.deleteCmmanldsyinf_S", vo);
    }

    /**
	 * CMMANLDSYINF?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? CmmanldsyinfVO
	 * @return 조회?�� CMMANLDSYINF
	 * @exception Exception
	 */
    public CmmanldsyinfVO selectCmmanldsyinf(CmmanldsyinfVO vo) throws Exception {
        return (CmmanldsyinfVO) selectByPk("cmmanldsyinfDAO.selectCmmanldsyinf_S", vo);
    }

    /**
	 * CMMANLDSYINF 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return CMMANLDSYINF 목록
	 * @exception Exception
	 */
    public List<?> selectCmmanldsyinfList(CmmanldsyinfSrhVO searchVO) throws Exception {
        return list("cmmanldsyinfDAO.selectCmmanldsyinfList_D", searchVO);
    }

    /**
	 * CMMANLDSYINF �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return CMMANLDSYINF �? �??��
	 * @exception
	 */
    public int selectCmmanldsyinfListTotCnt(CmmanldsyinfSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("cmmanldsyinfDAO.selectCmmanldsyinfListTotCnt_S", searchVO);
    }

}
