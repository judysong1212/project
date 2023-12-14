package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass0450SrhVO;
import com.app.exterms.resm.server.vo.Bass0450VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0450DAO.java
 * @Description : Bass0450 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass0450DAO")
public class Bass0450DAO extends EgovAbstractDAO {

	/**
	 * BASS0450?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass0450VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass0450(Bass0450VO vo) throws Exception {
        return (String)insert("bass0450DAO.insertBass0450_S", vo);
    }

    /**
	 * BASS0450?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass0450VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass0450(Bass0450VO vo) throws Exception {
        update("bass0450DAO.updateBass0450_S", vo);
    }

    /**
	 * BASS0450?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass0450VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass0450(Bass0450VO vo) throws Exception {
        delete("bass0450DAO.deleteBass0450_S", vo);
    }

    /**
	 * BASS0450?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass0450VO
	 * @return 조회?�� BASS0450
	 * @exception Exception
	 */
    public Bass0450VO selectBass0450(Bass0450VO vo) throws Exception {
        return (Bass0450VO) selectByPk("bass0450DAO.selectBass0450_S", vo);
    }

    /**
	 * BASS0450 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS0450 목록
	 * @exception Exception
	 */
    public List<?> selectBass0450List(Bass0450SrhVO searchVO) throws Exception {
        return list("bass0450DAO.selectBass0450List_D", searchVO);
    }

    /**
	 * BASS0450 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS0450 �? �??��
	 * @exception
	 */
    public int selectBass0450ListTotCnt(Bass0450SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass0450DAO.selectBass0450ListTotCnt_S", searchVO);
    }

}
