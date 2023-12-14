package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass1300SrhVO;
import com.app.exterms.resm.server.vo.Bass1300VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass1300DAO.java
 * @Description : Bass1300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass1300DAO")
public class Bass1300DAO extends EgovAbstractDAO {

	/**
	 * BASS1300?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass1300VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass1300(Bass1300VO vo) throws Exception {
        return (String)insert("bass1300DAO.insertBass1300_S", vo);
    }

    /**
	 * BASS1300?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass1300VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass1300(Bass1300VO vo) throws Exception {
        update("bass1300DAO.updateBass1300_S", vo);
    }

    /**
	 * BASS1300?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass1300VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass1300(Bass1300VO vo) throws Exception {
        delete("bass1300DAO.deleteBass1300_S", vo);
    }

    /**
	 * BASS1300?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass1300VO
	 * @return 조회?�� BASS1300
	 * @exception Exception
	 */
    public Bass1300VO selectBass1300(Bass1300VO vo) throws Exception {
        return (Bass1300VO) selectByPk("bass1300DAO.selectBass1300_S", vo);
    }

    /**
	 * BASS1300 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS1300 목록
	 * @exception Exception
	 */
    public List<?> selectBass1300List(Bass1300SrhVO searchVO) throws Exception {
        return list("bass1300DAO.selectBass1300List_D", searchVO);
    }

    /**
	 * BASS1300 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS1300 �? �??��
	 * @exception
	 */
    public int selectBass1300ListTotCnt(Bass1300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass1300DAO.selectBass1300ListTotCnt_S", searchVO);
    }

}
