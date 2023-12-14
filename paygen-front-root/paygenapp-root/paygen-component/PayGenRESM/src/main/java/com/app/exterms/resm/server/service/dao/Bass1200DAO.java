package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass1200SrhVO;
import com.app.exterms.resm.server.vo.Bass1200VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass1200DAO.java
 * @Description : Bass1200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass1200DAO")
public class Bass1200DAO extends EgovAbstractDAO {

	/**
	 * BASS1200?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass1200VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass1200(Bass1200VO vo) throws Exception {
        return (String)insert("bass1200DAO.insertBass1200_S", vo);
    }

    /**
	 * BASS1200?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass1200VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass1200(Bass1200VO vo) throws Exception {
        update("bass1200DAO.updateBass1200_S", vo);
    }

    /**
	 * BASS1200?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass1200VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass1200(Bass1200VO vo) throws Exception {
        delete("bass1200DAO.deleteBass1200_S", vo);
    }

    /**
	 * BASS1200?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass1200VO
	 * @return 조회?�� BASS1200
	 * @exception Exception
	 */
    public Bass1200VO selectBass1200(Bass1200VO vo) throws Exception {
        return (Bass1200VO) selectByPk("bass1200DAO.selectBass1200_S", vo);
    }

    /**
	 * BASS1200 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS1200 목록
	 * @exception Exception
	 */
    public List<?> selectBass1200List(Bass1200SrhVO searchVO) throws Exception {
        return list("bass1200DAO.selectBass1200List_D", searchVO);
    }

    /**
	 * BASS1200 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS1200 �? �??��
	 * @exception
	 */
    public int selectBass1200ListTotCnt(Bass1200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass1200DAO.selectBass1200ListTotCnt_S", searchVO);
    }

}
