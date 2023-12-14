package com.app.smrmf.pkg.sche.sysm.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.pkg.sche.sysm.service.vo.CmmanldlastwrkSrhVO;
import com.app.smrmf.pkg.sche.sysm.service.vo.CmmanldlastwrkVO;
import com.ext.dao.OtherAbstractDAO;

/**
 * @Class Name : CmmanldlastwrkDAO.java
 * @Description : Cmmanldlastwrk DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2018.0123
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("CmmanldlastwrkDAO")
public class CmmanldlastwrkDAO extends OtherAbstractDAO {

	/**
	 * CMMANLDLASTWRK?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? CmmanldlastwrkVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertCmmanldlastwrk(CmmanldlastwrkVO vo) throws Exception {
        return (String)insert("cmmanldlastwrkDAO.insertCmmanldlastwrk_S", vo);
    }

    /**
	 * CMMANLDLASTWRK?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? CmmanldlastwrkVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateCmmanldlastwrk(CmmanldlastwrkVO vo) throws Exception {
        update("cmmanldlastwrkDAO.updateCmmanldlastwrk_S", vo);
    }

    /**
	 * CMMANLDLASTWRK?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? CmmanldlastwrkVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteCmmanldlastwrk(CmmanldlastwrkVO vo) throws Exception {
        delete("cmmanldlastwrkDAO.deleteCmmanldlastwrk_S", vo);
    }

    /**
	 * CMMANLDLASTWRK?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? CmmanldlastwrkVO
	 * @return 조회?�� CMMANLDLASTWRK
	 * @exception Exception
	 */
    public CmmanldlastwrkVO selectCmmanldlastwrk(CmmanldlastwrkVO vo) throws Exception {
        return (CmmanldlastwrkVO) selectByPk("cmmanldlastwrkDAO.selectCmmanldlastwrk_S", vo);
    }

    /**
	 * CMMANLDLASTWRK 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return CMMANLDLASTWRK 목록
	 * @exception Exception
	 */
    public List<?> selectCmmanldlastwrkList(CmmanldlastwrkSrhVO searchVO) throws Exception {
        return list("cmmanldlastwrkDAO.selectCmmanldlastwrkList_D", searchVO);
    }

    /**
	 * CMMANLDLASTWRK �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return CMMANLDLASTWRK �? �??��
	 * @exception
	 */
    public int selectCmmanldlastwrkListTotCnt(CmmanldlastwrkSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("cmmanldlastwrkDAO.selectCmmanldlastwrkListTotCnt_S", searchVO);
    }

}
