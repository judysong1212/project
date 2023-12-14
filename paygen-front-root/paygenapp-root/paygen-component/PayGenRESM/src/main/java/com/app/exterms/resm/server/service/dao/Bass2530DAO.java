package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass2530SrhVO;
import com.app.exterms.resm.server.vo.Bass2530VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass2530DAO.java
 * @Description : Bass2530 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass2530DAO")
public class Bass2530DAO extends EgovAbstractDAO {

	/**
	 * BASS2530?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass2530VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass2530(Bass2530VO vo) throws Exception {
        return (String)insert("bass2530DAO.insertBass2530_S", vo);
    }

    /**
	 * BASS2530?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2530VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass2530(Bass2530VO vo) throws Exception {
        update("bass2530DAO.updateBass2530_S", vo);
    }

    /**
	 * BASS2530?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2530VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass2530(Bass2530VO vo) throws Exception {
        delete("bass2530DAO.deleteBass2530_S", vo);
    }

    /**
	 * BASS2530?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass2530VO
	 * @return 조회?�� BASS2530
	 * @exception Exception
	 */
    public Bass2530VO selectBass2530(Bass2530VO vo) throws Exception {
        return (Bass2530VO) selectByPk("bass2530DAO.selectBass2530_S", vo);
    }

    /**
	 * BASS2530 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2530 목록
	 * @exception Exception
	 */
    public List<?> selectBass2530List(Bass2530SrhVO searchVO) throws Exception {
        return list("bass2530DAO.selectBass2530List_D", searchVO);
    }

    /**
	 * BASS2530 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2530 �? �??��
	 * @exception
	 */
    public int selectBass2530ListTotCnt(Bass2530SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass2530DAO.selectBass2530ListTotCnt_S", searchVO);
    }

}
