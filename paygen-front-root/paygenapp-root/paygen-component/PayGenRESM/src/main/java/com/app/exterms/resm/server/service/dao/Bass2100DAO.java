package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass2100SrhVO;
import com.app.exterms.resm.server.vo.Bass2100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass2100DAO.javas
 * @Description : Bass2100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass2100DAO")
public class Bass2100DAO extends EgovAbstractDAO {

	/**
	 * BASS2100?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass2100VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass2100(Bass2100VO vo) throws Exception {
        return (String)insert("bass2100DAO.insertBass2100_S", vo);
    }

    /**
	 * BASS2100?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2100VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass2100(Bass2100VO vo) throws Exception {
        update("bass2100DAO.updateBass2100_S", vo);
    }

    /**
	 * BASS2100?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass2100VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass2100(Bass2100VO vo) throws Exception {
        delete("bass2100DAO.deleteBass2100_S", vo);
    }

    /**
	 * BASS2100?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass2100VO
	 * @return 조회?�� BASS2100
	 * @exception Exception
	 */
    public Bass2100VO selectBass2100(Bass2100VO vo) throws Exception {
        return (Bass2100VO) selectByPk("bass2100DAO.selectBass2100_S", vo);
    }

    /**
	 * BASS2100 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2100 목록
	 * @exception Exception
	 */
    public List<?> selectBass2100List(Bass2100SrhVO searchVO) throws Exception {
        return list("bass2100DAO.selectBass2100List_D", searchVO);
    }

    /**
	 * BASS2100 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS2100 �? �??��
	 * @exception
	 */
    public int selectBass2100ListTotCnt(Bass2100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass2100DAO.selectBass2100ListTotCnt_S", searchVO);
    }

}
