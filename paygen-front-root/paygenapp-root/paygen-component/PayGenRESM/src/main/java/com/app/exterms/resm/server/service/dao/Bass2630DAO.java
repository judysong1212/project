package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass2630SrhVO;
import com.app.exterms.resm.server.vo.Bass2630VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass2630DAO.java
 * @Description : Bass2630 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass2630DAO")
public class Bass2630DAO extends EgovAbstractDAO {

	/**
	 * BASS2630?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass2630VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass2630(Bass2630VO vo) throws Exception {
        return (String)insert("bass2630DAO.insertBass2630_S", vo);
    }

    /**
	 * BASS2630?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2630VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass2630(Bass2630VO vo) throws Exception {
        update("bass2630DAO.updateBass2630_S", vo);
    }

    /**
	 * BASS2630?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2630VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass2630(Bass2630VO vo) throws Exception {
        delete("bass2630DAO.deleteBass2630_S", vo);
    }

    /**
	 * BASS2630?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass2630VO
	 * @return 조회?�� BASS2630
	 * @exception Exception
	 */
    public Bass2630VO selectBass2630(Bass2630VO vo) throws Exception {
        return (Bass2630VO) selectByPk("bass2630DAO.selectBass2630_S", vo);
    }

    /**
	 * BASS2630 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2630 목록
	 * @exception Exception
	 */
    public List<?> selectBass2630List(Bass2630SrhVO searchVO) throws Exception {
        return list("bass2630DAO.selectBass2630List_D", searchVO);
    }

    /**
	 * BASS2630 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2630 �? �??��
	 * @exception
	 */
    public int selectBass2630ListTotCnt(Bass2630SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass2630DAO.selectBass2630ListTotCnt_S", searchVO);
    }

}
