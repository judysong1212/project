package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass2500SrhVO;
import com.app.exterms.resm.server.vo.Bass2500VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass2500DAO.java
 * @Description : Bass2500 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass2500DAO")
public class Bass2500DAO extends EgovAbstractDAO {

	/**
	 * BASS2500?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass2500VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass2500(Bass2500VO vo) throws Exception {
        return (String)insert("bass2500DAO.insertBass2500_S", vo);
    }

    /**
	 * BASS2500?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2500VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass2500(Bass2500VO vo) throws Exception {
        update("bass2500DAO.updateBass2500_S", vo);
    }

    /**
	 * BASS2500?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2500VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass2500(Bass2500VO vo) throws Exception {
        delete("bass2500DAO.deleteBass2500_S", vo);
    }

    /**
	 * BASS2500?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass2500VO
	 * @return 조회?�� BASS2500
	 * @exception Exception
	 */
    public Bass2500VO selectBass2500(Bass2500VO vo) throws Exception {
        return (Bass2500VO) selectByPk("bass2500DAO.selectBass2500_S", vo);
    }

    /**
	 * BASS2500 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2500 목록
	 * @exception Exception
	 */
    public List<?> selectBass2500List(Bass2500SrhVO searchVO) throws Exception {
        return list("bass2500DAO.selectBass2500List_D", searchVO);
    }

    /**
	 * BASS2500 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2500 �? �??��
	 * @exception
	 */
    public int selectBass2500ListTotCnt(Bass2500SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass2500DAO.selectBass2500ListTotCnt_S", searchVO);
    }

}
