package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass2050SrhVO;
import com.app.exterms.resm.server.vo.Bass2050VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass2050DAO.java
 * @Description : Bass2050 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass2050DAO")
public class Bass2050DAO extends EgovAbstractDAO {

	/**
	 * BASS2050?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass2050VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass2050(Bass2050VO vo) throws Exception {
        return (String)insert("bass2050DAO.insertBass2050_S", vo);
    }

    /**
	 * BASS2050?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2050VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass2050(Bass2050VO vo) throws Exception {
        update("bass2050DAO.updateBass2050_S", vo);
    }

    /**
	 * BASS2050?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2050VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass2050(Bass2050VO vo) throws Exception {
        delete("bass2050DAO.deleteBass2050_S", vo);
    }

    /**
	 * BASS2050?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass2050VO
	 * @return 조회?�� BASS2050
	 * @exception Exception
	 */
    public Bass2050VO selectBass2050(Bass2050VO vo) throws Exception {
        return (Bass2050VO) selectByPk("bass2050DAO.selectBass2050_S", vo);
    }

    /**
	 * BASS2050 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2050 목록
	 * @exception Exception
	 */
    public List<?> selectBass2050List(Bass2050SrhVO searchVO) throws Exception {
        return list("bass2050DAO.selectBass2050List_D", searchVO);
    }

    /**
	 * BASS2050 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2050 �? �??��
	 * @exception
	 */
    public int selectBass2050ListTotCnt(Bass2050SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass2050DAO.selectBass2050ListTotCnt_S", searchVO);
    }

}
