package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass2150SrhVO;
import com.app.exterms.resm.server.vo.Bass2150VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass2150DAO.java
 * @Description : Bass2150 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass2150DAO")
public class Bass2150DAO extends EgovAbstractDAO {

	/**
	 * BASS2150?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass2150VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass2150(Bass2150VO vo) throws Exception {
        return (String)insert("bass2150DAO.insertBass2150_S", vo);
    }

    /**
	 * BASS2150?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2150VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass2150(Bass2150VO vo) throws Exception {
        update("bass2150DAO.updateBass2150_S", vo);
    }

    /**
	 * BASS2150?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2150VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass2150(Bass2150VO vo) throws Exception {
        delete("bass2150DAO.deleteBass2150_S", vo);
    }

    /**
	 * BASS2150?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass2150VO
	 * @return 조회?�� BASS2150
	 * @exception Exception
	 */
    public Bass2150VO selectBass2150(Bass2150VO vo) throws Exception {
        return (Bass2150VO) selectByPk("bass2150DAO.selectBass2150_S", vo);
    }

    /**
	 * BASS2150 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2150 목록
	 * @exception Exception
	 */
    public List<?> selectBass2150List(Bass2150SrhVO searchVO) throws Exception {
        return list("bass2150DAO.selectBass2150List_D", searchVO);
    }

    /**
	 * BASS2150 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2150 �? �??��
	 * @exception
	 */
    public int selectBass2150ListTotCnt(Bass2150SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass2150DAO.selectBass2150ListTotCnt_S", searchVO);
    }

}
