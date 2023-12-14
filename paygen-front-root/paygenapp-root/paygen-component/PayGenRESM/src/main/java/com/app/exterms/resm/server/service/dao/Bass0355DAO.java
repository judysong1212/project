package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass0355SrhVO;
import com.app.exterms.resm.server.vo.Bass0355VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0355DAO.java
 * @Description : Bass0355 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass0355DAO")
public class Bass0355DAO extends EgovAbstractDAO {

	/**
	 * BASS0355?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass0355VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass0355(Bass0355VO vo) throws Exception {
        return (String)insert("bass0355DAO.insertBass0355_S", vo);
    }

    /**
	 * BASS0355?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass0355VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass0355(Bass0355VO vo) throws Exception {
        update("bass0355DAO.updateBass0355_S", vo);
    }

    /**
	 * BASS0355?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass0355VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass0355(Bass0355VO vo) throws Exception {
        delete("bass0355DAO.deleteBass0355_S", vo);
    }

    /**
	 * BASS0355?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass0355VO
	 * @return 조회?�� BASS0355
	 * @exception Exception
	 */
    public Bass0355VO selectBass0355(Bass0355VO vo) throws Exception {
        return (Bass0355VO) selectByPk("bass0355DAO.selectBass0355_S", vo);
    }

    /**
	 * BASS0355 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS0355 목록
	 * @exception Exception
	 */
    public List<?> selectBass0355List(Bass0355SrhVO searchVO) throws Exception {
        return list("bass0355DAO.selectBass0355List_D", searchVO);
    }

    /**
	 * BASS0355 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS0355 �? �??��
	 * @exception
	 */
    public int selectBass0355ListTotCnt(Bass0355SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass0355DAO.selectBass0355ListTotCnt_S", searchVO);
    }

}
