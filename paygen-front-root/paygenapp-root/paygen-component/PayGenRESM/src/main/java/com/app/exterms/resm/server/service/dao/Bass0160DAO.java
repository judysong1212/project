package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass0160SrhVO;
import com.app.exterms.resm.server.vo.Bass0160VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0160DAO.java
 * @Description : Bass0160 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass0160DAO")
public class Bass0160DAO extends EgovAbstractDAO {

	/**
	 * BASS0160?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass0160VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass0160(Bass0160VO vo) throws Exception {
        return (String)insert("bass0160DAO.insertBass0160_S", vo);
    }

    /**
	 * BASS0160?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass0160VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass0160(Bass0160VO vo) throws Exception {
        update("bass0160DAO.updateBass0160_S", vo);
    }

    /**
	 * BASS0160?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass0160VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass0160(Bass0160VO vo) throws Exception {
        delete("bass0160DAO.deleteBass0160_S", vo);
    }

    /**
	 * BASS0160?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass0160VO
	 * @return 조회?�� BASS0160
	 * @exception Exception
	 */
    public Bass0160VO selectBass0160(Bass0160VO vo) throws Exception {
        return (Bass0160VO) selectByPk("bass0160DAO.selectBass0160_S", vo);
    }

    /**
	 * BASS0160 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS0160 목록
	 * @exception Exception
	 */
    public List<?> selectBass0160List(Bass0160SrhVO searchVO) throws Exception {
        return list("bass0160DAO.selectBass0160List_D", searchVO);
    }

    /**
	 * BASS0160 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS0160 �? �??��
	 * @exception
	 */
    public int selectBass0160ListTotCnt(Bass0160SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass0160DAO.selectBass0160ListTotCnt_S", searchVO);
    }

}
