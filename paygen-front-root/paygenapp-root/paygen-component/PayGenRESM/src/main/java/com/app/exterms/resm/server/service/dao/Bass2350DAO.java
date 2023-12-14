package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass2350SrhVO;
import com.app.exterms.resm.server.vo.Bass2350VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass2350DAO.java
 * @Description : Bass2350 DAO Class
 * @Modification Information
 *
 * @author atrres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass2350DAO")
public class Bass2350DAO extends EgovAbstractDAO {

	/**
	 * BASS2350?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass2350VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass2350(Bass2350VO vo) throws Exception {
        return (String)insert("bass2350DAO.insertBass2350_S", vo);
    }

    /**
	 * BASS2350?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2350VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass2350(Bass2350VO vo) throws Exception {
        update("bass2350DAO.updateBass2350_S", vo);
    }

    /**
	 * BASS2350?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2350VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass2350(Bass2350VO vo) throws Exception {
        delete("bass2350DAO.deleteBass2350_S", vo);
    }

    /**
	 * BASS2350?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass2350VO
	 * @return 조회?�� BASS2350
	 * @exception Exception
	 */
    public Bass2350VO selectBass2350(Bass2350VO vo) throws Exception {
        return (Bass2350VO) selectByPk("bass2350DAO.selectBass2350_S", vo);
    }

    /**
	 * BASS2350 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2350 목록
	 * @exception Exception
	 */
    public List<?> selectBass2350List(Bass2350SrhVO searchVO) throws Exception {
        return list("bass2350DAO.selectBass2350List_D", searchVO);
    }

    /**
	 * BASS2350 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2350 �? �??��
	 * @exception
	 */
    public int selectBass2350ListTotCnt(Bass2350SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass2350DAO.selectBass2350ListTotCnt_S", searchVO);
    }

}
