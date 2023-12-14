package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass0475SrhVO;
import com.app.exterms.resm.server.vo.Bass0475VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0475DAO.java
 * @Description : Bass0475 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass0475DAO")
public class Bass0475DAO extends EgovAbstractDAO {

	/**
	 * BASS0475?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass0475VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass0475(Bass0475VO vo) throws Exception {
        return (String)insert("bass0475DAO.insertBass0475_S", vo);
    }

    /**
	 * BASS0475?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass0475VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass0475(Bass0475VO vo) throws Exception {
        update("bass0475DAO.updateBass0475_S", vo);
    }

    /**
	 * BASS0475?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass0475VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass0475(Bass0475VO vo) throws Exception {
        delete("bass0475DAO.deleteBass0475_S", vo);
    }

    /**
	 * BASS0475?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass0475VO
	 * @return 조회?�� BASS0475
	 * @exception Exception
	 */
    public Bass0475VO selectBass0475(Bass0475VO vo) throws Exception {
        return (Bass0475VO) selectByPk("bass0475DAO.selectBass0475_S", vo);
    }

    /**
	 * BASS0475 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS0475 목록
	 * @exception Exception
	 */
    public List<?> selectBass0475List(Bass0475SrhVO searchVO) throws Exception {
        return list("bass0475DAO.selectBass0475List_D", searchVO);
    }

    /**
	 * BASS0475 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS0475 �? �??��
	 * @exception
	 */
    public int selectBass0475ListTotCnt(Bass0475SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass0475DAO.selectBass0475ListTotCnt_S", searchVO);
    }

}
