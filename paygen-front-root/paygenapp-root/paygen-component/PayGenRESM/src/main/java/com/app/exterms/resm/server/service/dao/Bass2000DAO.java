package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass2000SrhVO;
import com.app.exterms.resm.server.vo.Bass2000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass2000DAO.java
 * @Description : Bass2000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass2000DAO")
public class Bass2000DAO extends EgovAbstractDAO {

	/**
	 * BASS2000?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass2000VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass2000(Bass2000VO vo) throws Exception {
        return (String)insert("bass2000DAO.insertBass2000_S", vo);
    }

    /**
	 * BASS2000?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2000VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass2000(Bass2000VO vo) throws Exception {
        update("bass2000DAO.updateBass2000_S", vo);
    }

    /**
	 * BASS2000?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2000VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass2000(Bass2000VO vo) throws Exception {
        delete("bass2000DAO.deleteBass2000_S", vo);
    }

    /**
	 * BASS2000?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass2000VO
	 * @return 조회?�� BASS2000
	 * @exception Exception
	 */
    public Bass2000VO selectBass2000(Bass2000VO vo) throws Exception {
        return (Bass2000VO) selectByPk("bass2000DAO.selectBass2000_S", vo);
    }

    /**
	 * BASS2000 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2000 목록
	 * @exception Exception
	 */
    public List<?> selectBass2000List(Bass2000SrhVO searchVO) throws Exception {
        return list("bass2000DAO.selectBass2000List_D", searchVO);
    }

    /**
	 * BASS2000 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2000 �? �??��
	 * @exception
	 */
    public int selectBass2000ListTotCnt(Bass2000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass2000DAO.selectBass2000ListTotCnt_S", searchVO);
    }

}
