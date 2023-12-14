package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass2640SrhVO;
import com.app.exterms.resm.server.vo.Bass2640VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass2640DAO.java
 * @Description : Bass2640 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass2640DAO")
public class Bass2640DAO extends EgovAbstractDAO {

	/**
	 * BASS2640?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass2640VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass2640(Bass2640VO vo) throws Exception {
        return (String)insert("bass2640DAO.insertBass2640_S", vo);
    }

    /**
	 * BASS2640?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2640VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass2640(Bass2640VO vo) throws Exception {
        update("bass2640DAO.updateBass2640_S", vo);
    }

    /**
	 * BASS2640?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2640VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass2640(Bass2640VO vo) throws Exception {
        delete("bass2640DAO.deleteBass2640_S", vo);
    }

    /**
	 * BASS2640?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass2640VO
	 * @return 조회?�� BASS2640
	 * @exception Exception
	 */
    public Bass2640VO selectBass2640(Bass2640VO vo) throws Exception {
        return (Bass2640VO) selectByPk("bass2640DAO.selectBass2640_S", vo);
    }

    /**
	 * BASS2640 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2640 목록
	 * @exception Exception
	 */
    public List<?> selectBass2640List(Bass2640SrhVO searchVO) throws Exception {
        return list("bass2640DAO.selectBass2640List_D", searchVO);
    }

    /**
	 * BASS2640 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2640 �? �??��
	 * @exception
	 */
    public int selectBass2640ListTotCnt(Bass2640SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass2640DAO.selectBass2640ListTotCnt_S", searchVO);
    }

}
