package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass2510SrhVO;
import com.app.exterms.resm.server.vo.Bass2510VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass2510DAO.java
 * @Description : Bass2510 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass2510DAO")
public class Bass2510DAO extends EgovAbstractDAO {

	/**
	 * BASS2510?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass2510VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass2510(Bass2510VO vo) throws Exception {
        return (String)insert("bass2510DAO.insertBass2510_S", vo);
    }

    /**
	 * BASS2510?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2510VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass2510(Bass2510VO vo) throws Exception {
        update("bass2510DAO.updateBass2510_S", vo);
    }

    /**
	 * BASS2510?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2510VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass2510(Bass2510VO vo) throws Exception {
        delete("bass2510DAO.deleteBass2510_S", vo);
    }

    /**
	 * BASS2510?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass2510VO
	 * @return 조회?�� BASS2510
	 * @exception Exception
	 */
    public Bass2510VO selectBass2510(Bass2510VO vo) throws Exception {
        return (Bass2510VO) selectByPk("bass2510DAO.selectBass2510_S", vo);
    }

    /**
	 * BASS2510 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2510 목록
	 * @exception Exception
	 */
    public List<?> selectBass2510List(Bass2510SrhVO searchVO) throws Exception {
        return list("bass2510DAO.selectBass2510List_D", searchVO);
    }

    /**
	 * BASS2510 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2510 �? �??��
	 * @exception
	 */
    public int selectBass2510ListTotCnt(Bass2510SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass2510DAO.selectBass2510ListTotCnt_S", searchVO);
    }

}
