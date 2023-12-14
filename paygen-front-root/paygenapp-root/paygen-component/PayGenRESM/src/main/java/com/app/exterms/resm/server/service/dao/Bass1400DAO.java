package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass1400SrhVO;
import com.app.exterms.resm.server.vo.Bass1400VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass1400DAO.java
 * @Description : Bass1400 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass1400DAO")
public class Bass1400DAO extends EgovAbstractDAO {

	/**
	 * BASS1400?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass1400VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass1400(Bass1400VO vo) throws Exception {
        return (String)insert("bass1400DAO.insertBass1400_S", vo);
    }

    /**
	 * BASS1400?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass1400VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass1400(Bass1400VO vo) throws Exception {
        update("bass1400DAO.updateBass1400_S", vo);
    }

    /**
	 * BASS1400?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass1400VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass1400(Bass1400VO vo) throws Exception {
        delete("bass1400DAO.deleteBass1400_S", vo);
    }

    /**
	 * BASS1400?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass1400VO
	 * @return 조회?�� BASS1400
	 * @exception Exception
	 */
    public Bass1400VO selectBass1400(Bass1400VO vo) throws Exception {
        return (Bass1400VO) selectByPk("bass1400DAO.selectBass1400_S", vo);
    }

    /**
	 * BASS1400 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS1400 목록
	 * @exception Exception
	 */
    public List<?> selectBass1400List(Bass1400SrhVO searchVO) throws Exception {
        return list("bass1400DAO.selectBass1400List_D", searchVO);
    }

    /**
	 * BASS1400 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS1400 �? �??��
	 * @exception
	 */
    public int selectBass1400ListTotCnt(Bass1400SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass1400DAO.selectBass1400ListTotCnt_S", searchVO);
    }

}
