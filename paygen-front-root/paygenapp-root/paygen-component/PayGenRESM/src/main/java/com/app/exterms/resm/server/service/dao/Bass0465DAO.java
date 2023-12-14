package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass0465SrhVO;
import com.app.exterms.resm.server.vo.Bass0465VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0465DAO.java
 * @Description : Bass0465 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass0465DAO")
public class Bass0465DAO extends EgovAbstractDAO {

	/**
	 * BASS0465?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass0465VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass0465(Bass0465VO vo) throws Exception {
        return (String)insert("bass0465DAO.insertBass0465_S", vo);
    }

    /**
	 * BASS0465?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass0465VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass0465(Bass0465VO vo) throws Exception {
        update("bass0465DAO.updateBass0465_S", vo);
    }

    /**
	 * BASS0465?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass0465VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass0465(Bass0465VO vo) throws Exception {
        delete("bass0465DAO.deleteBass0465_S", vo);
    }

    /**
	 * BASS0465?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass0465VO
	 * @return 조회?�� BASS0465
	 * @exception Exception
	 */
    public Bass0465VO selectBass0465(Bass0465VO vo) throws Exception {
        return (Bass0465VO) selectByPk("bass0465DAO.selectBass0465_S", vo);
    }

    /**
	 * BASS0465 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS0465 목록
	 * @exception Exception
	 */
    public List<?> selectBass0465List(Bass0465SrhVO searchVO) throws Exception {
        return list("bass0465DAO.selectBass0465List_D", searchVO);
    }

    /**
	 * BASS0465 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS0465 �? �??��
	 * @exception
	 */
    public int selectBass0465ListTotCnt(Bass0465SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass0465DAO.selectBass0465ListTotCnt_S", searchVO);
    }

}
