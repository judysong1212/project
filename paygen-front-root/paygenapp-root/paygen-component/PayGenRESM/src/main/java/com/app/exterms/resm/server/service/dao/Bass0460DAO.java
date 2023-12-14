package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass0460SrhVO;
import com.app.exterms.resm.server.vo.Bass0460VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0460DAO.java
 * @Description : Bass0460 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass0460DAO")
public class Bass0460DAO extends EgovAbstractDAO {

	/**
	 * BASS0460?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass0460VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass0460(Bass0460VO vo) throws Exception {
        return (String)insert("bass0460DAO.insertBass0460_S", vo);
    }

    /**
	 * BASS0460?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass0460VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass0460(Bass0460VO vo) throws Exception {
        update("bass0460DAO.updateBass0460_S", vo);
    }

    /**
	 * BASS0460?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass0460VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass0460(Bass0460VO vo) throws Exception {
        delete("bass0460DAO.deleteBass0460_S", vo);
    }

    /**
	 * BASS0460?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass0460VO
	 * @return 조회?�� BASS0460
	 * @exception Exception
	 */
    public Bass0460VO selectBass0460(Bass0460VO vo) throws Exception {
        return (Bass0460VO) selectByPk("bass0460DAO.selectBass0460_S", vo);
    }

    /**
	 * BASS0460 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS0460 목록
	 * @exception Exception
	 */
    public List<?> selectBass0460List(Bass0460SrhVO searchVO) throws Exception {
        return list("bass0460DAO.selectBass0460List_D", searchVO);
    }

    /**
	 * BASS0460 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS0460 �? �??��
	 * @exception
	 */
    public int selectBass0460ListTotCnt(Bass0460SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass0460DAO.selectBass0460ListTotCnt_S", searchVO);
    }

}
