package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass1000SrhVO;
import com.app.exterms.resm.server.vo.Bass1000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass1000DAO.java
 * @Description : Bass1000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass1000DAO")
public class Bass1000DAO extends EgovAbstractDAO {

	/**
	 * BASS1000?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass1000VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass1000(Bass1000VO vo) throws Exception {
        return (String)insert("bass1000DAO.insertBass1000_S", vo);
    }

    /**
	 * BASS1000?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass1000VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass1000(Bass1000VO vo) throws Exception {
        update("bass1000DAO.updateBass1000_S", vo);
    }

    /**
	 * BASS1000?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass1000VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass1000(Bass1000VO vo) throws Exception {
        delete("bass1000DAO.deleteBass1000_S", vo);
    }

    /**
	 * BASS1000?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass1000VO
	 * @return 조회?�� BASS1000
	 * @exception Exception
	 */
    public Bass1000VO selectBass1000(Bass1000VO vo) throws Exception {
        return (Bass1000VO) selectByPk("bass1000DAO.selectBass1000_S", vo);
    }

    /**
	 * BASS1000 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS1000 목록
	 * @exception Exception
	 */
    public List<?> selectBass1000List(Bass1000SrhVO searchVO) throws Exception {
        return list("bass1000DAO.selectBass1000List_D", searchVO);
    }

    /**
	 * BASS1000 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS1000 �? �??��
	 * @exception
	 */
    public int selectBass1000ListTotCnt(Bass1000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass1000DAO.selectBass1000ListTotCnt_S", searchVO);
    }

}
