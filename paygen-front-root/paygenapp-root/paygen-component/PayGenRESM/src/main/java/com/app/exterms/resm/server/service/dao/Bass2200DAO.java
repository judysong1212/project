package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass2200SrhVO;
import com.app.exterms.resm.server.vo.Bass2200VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass2200DAO.java
 * @Description : Bass2200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass2200DAO")
public class Bass2200DAO extends EgovAbstractDAO {

	/**
	 * BASS2200?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass2200VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass2200(Bass2200VO vo) throws Exception {
        return (String)insert("bass2200DAO.insertBass2200_S", vo);
    }

    /**
	 * BASS2200?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2200VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass2200(Bass2200VO vo) throws Exception {
        update("bass2200DAO.updateBass2200_S", vo);
    }

    /**
	 * BASS2200?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2200VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass2200(Bass2200VO vo) throws Exception {
        delete("bass2200DAO.deleteBass2200_S", vo);
    }

    /**
	 * BASS2200?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass2200VO
	 * @return 조회?�� BASS2200
	 * @exception Exception
	 */
    public Bass2200VO selectBass2200(Bass2200VO vo) throws Exception {
        return (Bass2200VO) selectByPk("bass2200DAO.selectBass2200_S", vo);
    }

    /**
	 * BASS2200 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2200 목록
	 * @exception Exception
	 */
    public List<?> selectBass2200List(Bass2200SrhVO searchVO) throws Exception {
        return list("bass2200DAO.selectBass2200List_D", searchVO);
    }

    /**
	 * BASS2200 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2200 �? �??��
	 * @exception
	 */
    public int selectBass2200ListTotCnt(Bass2200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass2200DAO.selectBass2200ListTotCnt_S", searchVO);
    }

}
