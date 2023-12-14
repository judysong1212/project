package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass0470SrhVO;
import com.app.exterms.resm.server.vo.Bass0470VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0470DAO.java
 * @Description : Bass0470 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass0470DAO")
public class Bass0470DAO extends EgovAbstractDAO {

	/**
	 * BASS0470?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass0470VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass0470(Bass0470VO vo) throws Exception {
        return (String)insert("bass0470DAO.insertBass0470_S", vo);
    }

    /**
	 * BASS0470?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass0470VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass0470(Bass0470VO vo) throws Exception {
        update("bass0470DAO.updateBass0470_S", vo);
    }

    /**
	 * BASS0470?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass0470VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass0470(Bass0470VO vo) throws Exception {
        delete("bass0470DAO.deleteBass0470_S", vo);
    }

    /**
	 * BASS0470?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass0470VO
	 * @return 조회?�� BASS0470
	 * @exception Exception
	 */
    public Bass0470VO selectBass0470(Bass0470VO vo) throws Exception {
        return (Bass0470VO) selectByPk("bass0470DAO.selectBass0470_S", vo);
    }

    /**
	 * BASS0470 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS0470 목록
	 * @exception Exception
	 */
    public List<?> selectBass0470List(Bass0470SrhVO searchVO) throws Exception {
        return list("bass0470DAO.selectBass0470List_D", searchVO);
    }

    /**
	 * BASS0470 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS0470 �? �??��
	 * @exception
	 */
    public int selectBass0470ListTotCnt(Bass0470SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass0470DAO.selectBass0470ListTotCnt_S", searchVO);
    }

}
