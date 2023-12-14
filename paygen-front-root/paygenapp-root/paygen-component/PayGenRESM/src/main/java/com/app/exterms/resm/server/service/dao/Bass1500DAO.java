package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass1500SrhVO;
import com.app.exterms.resm.server.vo.Bass1500VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass1500DAO.java
 * @Description : Bass1500 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass1500DAO")
public class Bass1500DAO extends EgovAbstractDAO {

	/**
	 * BASS1500?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass1500VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass1500(Bass1500VO vo) throws Exception {
        return (String)insert("bass1500DAO.insertBass1500_S", vo);
    }

    /**
	 * BASS1500?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass1500VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass1500(Bass1500VO vo) throws Exception {
        update("bass1500DAO.updateBass1500_S", vo);
    }

    /**
	 * BASS1500?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass1500VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass1500(Bass1500VO vo) throws Exception {
        delete("bass1500DAO.deleteBass1500_S", vo);
    }

    /**
	 * BASS1500?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass1500VO
	 * @return 조회?�� BASS1500
	 * @exception Exception
	 */
    public Bass1500VO selectBass1500(Bass1500VO vo) throws Exception {
        return (Bass1500VO) selectByPk("bass1500DAO.selectBass1500_S", vo);
    }

    /**
	 * BASS1500 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS1500 목록
	 * @exception Exception
	 */
    public List<?> selectBass1500List(Bass1500SrhVO searchVO) throws Exception {
        return list("bass1500DAO.selectBass1500List_D", searchVO);
    }

    /**
	 * BASS1500 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS1500 �? �??��
	 * @exception
	 */
    public int selectBass1500ListTotCnt(Bass1500SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass1500DAO.selectBass1500ListTotCnt_S", searchVO);
    }

}
