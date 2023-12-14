package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass2650SrhVO;
import com.app.exterms.resm.server.vo.Bass2650VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass2650DAO.java
 * @Description : Bass2650 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass2650DAO")
public class Bass2650DAO extends EgovAbstractDAO {

	/**
	 * BASS2650?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass2650VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass2650(Bass2650VO vo) throws Exception {
        return (String)insert("bass2650DAO.insertBass2650_S", vo);
    }

    /**
	 * BASS2650?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2650VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass2650(Bass2650VO vo) throws Exception {
        update("bass2650DAO.updateBass2650_S", vo);
    }

    /**
	 * BASS2650?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2650VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass2650(Bass2650VO vo) throws Exception {
        delete("bass2650DAO.deleteBass2650_S", vo);
    }

    /**
	 * BASS2650?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass2650VO
	 * @return 조회?�� BASS2650
	 * @exception Exception
	 */
    public Bass2650VO selectBass2650(Bass2650VO vo) throws Exception {
        return (Bass2650VO) selectByPk("bass2650DAO.selectBass2650_S", vo);
    }

    /**
	 * BASS2650 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2650 목록
	 * @exception Exception
	 */
    public List<?> selectBass2650List(Bass2650SrhVO searchVO) throws Exception {
        return list("bass2650DAO.selectBass2650List_D", searchVO);
    }

    /**
	 * BASS2650 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2650 �? �??��
	 * @exception
	 */
    public int selectBass2650ListTotCnt(Bass2650SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass2650DAO.selectBass2650ListTotCnt_S", searchVO);
    }

}
