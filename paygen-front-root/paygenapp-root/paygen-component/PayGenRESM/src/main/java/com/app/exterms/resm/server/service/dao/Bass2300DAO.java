package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass2300SrhVO;
import com.app.exterms.resm.server.vo.Bass2300VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass2300DAO.java
 * @Description : Bass2300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass2300DAO")
public class Bass2300DAO extends EgovAbstractDAO {

	/**
	 * BASS2300?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass2300VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass2300(Bass2300VO vo) throws Exception {
        return (String)insert("bass2300DAO.insertBass2300_S", vo);
    }

    /**
	 * BASS2300?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2300VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass2300(Bass2300VO vo) throws Exception {
        update("bass2300DAO.updateBass2300_S", vo);
    }

    /**
	 * BASS2300?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2300VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass2300(Bass2300VO vo) throws Exception {
        delete("bass2300DAO.deleteBass2300_S", vo);
    }

    /**
	 * BASS2300?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass2300VO
	 * @return 조회?�� BASS2300
	 * @exception Exception
	 */
    public Bass2300VO selectBass2300(Bass2300VO vo) throws Exception {
        return (Bass2300VO) selectByPk("bass2300DAO.selectBass2300_S", vo);
    }

    /**
	 * BASS2300 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2300 목록
	 * @exception Exception
	 */
    public List<?> selectBass2300List(Bass2300SrhVO searchVO) throws Exception {
        return list("bass2300DAO.selectBass2300List_D", searchVO);
    }

    /**
	 * BASS2300 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2300 �? �??��
	 * @exception
	 */
    public int selectBass2300ListTotCnt(Bass2300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass2300DAO.selectBass2300ListTotCnt_S", searchVO);
    }

}
