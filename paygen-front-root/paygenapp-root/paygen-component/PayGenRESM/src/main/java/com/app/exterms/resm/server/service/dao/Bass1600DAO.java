package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass1600SrhVO;
import com.app.exterms.resm.server.vo.Bass1600VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass1600DAO.java
 * @Description : Bass1600 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass1600DAO")
public class Bass1600DAO extends EgovAbstractDAO {

	/**
	 * BASS1600?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass1600VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass1600(Bass1600VO vo) throws Exception {
        return (String)insert("bass1600DAO.insertBass1600_S", vo);
    }

    /**
	 * BASS1600?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass1600VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass1600(Bass1600VO vo) throws Exception {
        update("bass1600DAO.updateBass1600_S", vo);
    }

    /**
	 * BASS1600?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass1600VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass1600(Bass1600VO vo) throws Exception {
        delete("bass1600DAO.deleteBass1600_S", vo);
    }

    /**
	 * BASS1600?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass1600VO
	 * @return 조회?�� BASS1600
	 * @exception Exception
	 */
    public Bass1600VO selectBass1600(Bass1600VO vo) throws Exception {
        return (Bass1600VO) selectByPk("bass1600DAO.selectBass1600_S", vo);
    }

    /**
	 * BASS1600 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS1600 목록
	 * @exception Exception
	 */
    public List<?> selectBass1600List(Bass1600SrhVO searchVO) throws Exception {
        return list("bass1600DAO.selectBass1600List_D", searchVO);
    }

    /**
	 * BASS1600 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS1600 �? �??��
	 * @exception
	 */
    public int selectBass1600ListTotCnt(Bass1600SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass1600DAO.selectBass1600ListTotCnt_S", searchVO);
    }

}
