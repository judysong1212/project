package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass2600SrhVO;
import com.app.exterms.resm.server.vo.Bass2600VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass2600DAO.java
 * @Description : Bass2600 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass2600DAO")
public class Bass2600DAO extends EgovAbstractDAO {

	/**
	 * BASS2600?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass2600VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass2600(Bass2600VO vo) throws Exception {
        return (String)insert("bass2600DAO.insertBass2600_S", vo);
    }

    /**
	 * BASS2600?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2600VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass2600(Bass2600VO vo) throws Exception {
        update("bass2600DAO.updateBass2600_S", vo);
    }

    /**
	 * BASS2600?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2600VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass2600(Bass2600VO vo) throws Exception {
        delete("bass2600DAO.deleteBass2600_S", vo);
    }

    /**
	 * BASS2600?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass2600VO
	 * @return 조회?�� BASS2600
	 * @exception Exception
	 */
    public Bass2600VO selectBass2600(Bass2600VO vo) throws Exception {
        return (Bass2600VO) selectByPk("bass2600DAO.selectBass2600_S", vo);
    }

    /**
	 * BASS2600 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2600 목록
	 * @exception Exception
	 */
    public List<?> selectBass2600List(Bass2600SrhVO searchVO) throws Exception {
        return list("bass2600DAO.selectBass2600List_D", searchVO);
    }

    /**
	 * BASS2600 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2600 �? �??��
	 * @exception
	 */
    public int selectBass2600ListTotCnt(Bass2600SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass2600DAO.selectBass2600ListTotCnt_S", searchVO);
    }

}
