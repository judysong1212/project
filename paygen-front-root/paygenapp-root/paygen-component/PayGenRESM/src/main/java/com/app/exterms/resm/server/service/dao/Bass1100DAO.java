package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass1100SrhVO;
import com.app.exterms.resm.server.vo.Bass1100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass1100DAO.java
 * @Description : Bass1100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass1100DAO")
public class Bass1100DAO extends EgovAbstractDAO {

	/**
	 * BASS1100?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass1100VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass1100(Bass1100VO vo) throws Exception {
        return (String)insert("bass1100DAO.insertBass1100_S", vo);
    }

    /**
	 * BASS1100?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass1100VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass1100(Bass1100VO vo) throws Exception {
        update("bass1100DAO.updateBass1100_S", vo);
    }

    /**
	 * BASS1100?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass1100VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass1100(Bass1100VO vo) throws Exception {
        delete("bass1100DAO.deleteBass1100_S", vo);
    }

    /**
	 * BASS1100?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass1100VO
	 * @return 조회?�� BASS1100
	 * @exception Exception
	 */
    public Bass1100VO selectBass1100(Bass1100VO vo) throws Exception {
        return (Bass1100VO) selectByPk("bass1100DAO.selectBass1100_S", vo);
    }

    /**
	 * BASS1100 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS1100 목록
	 * @exception Exception
	 */
    public List<?> selectBass1100List(Bass1100SrhVO searchVO) throws Exception {
        return list("bass1100DAO.selectBass1100List_D", searchVO);
    }

    /**
	 * BASS1100 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS1100 �? �??��
	 * @exception
	 */
    public int selectBass1100ListTotCnt(Bass1100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass1100DAO.selectBass1100ListTotCnt_S", searchVO);
    }

}
