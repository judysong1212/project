package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass2610SrhVO;
import com.app.exterms.resm.server.vo.Bass2610VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass2610DAO.java
 * @Description : Bass2610 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass2610DAO")
public class Bass2610DAO extends EgovAbstractDAO {

	/**
	 * BASS2610?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass2610VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass2610(Bass2610VO vo) throws Exception {
        return (String)insert("bass2610DAO.insertBass2610_S", vo);
    }

    /**
	 * BASS2610?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2610VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass2610(Bass2610VO vo) throws Exception {
        update("bass2610DAO.updateBass2610_S", vo);
    }

    /**
	 * BASS2610?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2610VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass2610(Bass2610VO vo) throws Exception {
        delete("bass2610DAO.deleteBass2610_S", vo);
    }

    /**
	 * BASS2610?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass2610VO
	 * @return 조회?�� BASS2610
	 * @exception Exception
	 */
    public Bass2610VO selectBass2610(Bass2610VO vo) throws Exception {
        return (Bass2610VO) selectByPk("bass2610DAO.selectBass2610_S", vo);
    }

    /**
	 * BASS2610 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2610 목록
	 * @exception Exception
	 */
    public List<?> selectBass2610List(Bass2610SrhVO searchVO) throws Exception {
        return list("bass2610DAO.selectBass2610List_D", searchVO);
    }

    /**
	 * BASS2610 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2610 �? �??��
	 * @exception
	 */
    public int selectBass2610ListTotCnt(Bass2610SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass2610DAO.selectBass2610ListTotCnt_S", searchVO);
    }

}
