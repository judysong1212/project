package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass2400SrhVO;
import com.app.exterms.resm.server.vo.Bass2400VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass2400DAO.java
 * @Description : Bass2400 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass2400DAO")
public class Bass2400DAO extends EgovAbstractDAO {

	/**
	 * BASS2400?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass2400VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass2400(Bass2400VO vo) throws Exception {
        return (String)insert("bass2400DAO.insertBass2400_S", vo);
    }

    /**
	 * BASS2400?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2400VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass2400(Bass2400VO vo) throws Exception {
        update("bass2400DAO.updateBass2400_S", vo);
    }

    /**
	 * BASS2400?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2400VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass2400(Bass2400VO vo) throws Exception {
        delete("bass2400DAO.deleteBass2400_S", vo);
    }

    /**
	 * BASS2400?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass2400VO
	 * @return 조회?�� BASS2400
	 * @exception Exception
	 */
    public Bass2400VO selectBass2400(Bass2400VO vo) throws Exception {
        return (Bass2400VO) selectByPk("bass2400DAO.selectBass2400_S", vo);
    }

    /**
	 * BASS2400 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2400 목록
	 * @exception Exception
	 */
    public List<?> selectBass2400List(Bass2400SrhVO searchVO) throws Exception {
        return list("bass2400DAO.selectBass2400List_D", searchVO);
    }

    /**
	 * BASS2400 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2400 �? �??��
	 * @exception
	 */
    public int selectBass2400ListTotCnt(Bass2400SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass2400DAO.selectBass2400ListTotCnt_S", searchVO);
    }

}
