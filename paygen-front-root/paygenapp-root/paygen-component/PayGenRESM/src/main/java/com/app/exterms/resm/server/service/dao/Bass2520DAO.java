package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass2520SrhVO;
import com.app.exterms.resm.server.vo.Bass2520VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass2520DAO.java
 * @Description : Bass2520 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass2520DAO")
public class Bass2520DAO extends EgovAbstractDAO {

	/**
	 * BASS2520?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass2520VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass2520(Bass2520VO vo) throws Exception {
        return (String)insert("bass2520DAO.insertBass2520_S", vo);
    }

    /**
	 * BASS2520?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2520VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass2520(Bass2520VO vo) throws Exception {
        update("bass2520DAO.updateBass2520_S", vo);
    }

    /**
	 * BASS2520?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2520VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass2520(Bass2520VO vo) throws Exception {
        delete("bass2520DAO.deleteBass2520_S", vo);
    }

    /**
	 * BASS2520?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass2520VO
	 * @return 조회?�� BASS2520
	 * @exception Exception
	 */
    public Bass2520VO selectBass2520(Bass2520VO vo) throws Exception {
        return (Bass2520VO) selectByPk("bass2520DAO.selectBass2520_S", vo);
    }

    /**
	 * BASS2520 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2520 목록
	 * @exception Exception
	 */
    public List<?> selectBass2520List(Bass2520SrhVO searchVO) throws Exception {
        return list("bass2520DAO.selectBass2520List_D", searchVO);
    }

    /**
	 * BASS2520 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2520 �? �??��
	 * @exception
	 */
    public int selectBass2520ListTotCnt(Bass2520SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass2520DAO.selectBass2520ListTotCnt_S", searchVO);
    }

}
