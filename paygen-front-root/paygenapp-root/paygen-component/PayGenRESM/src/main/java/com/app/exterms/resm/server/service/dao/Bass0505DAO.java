package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.resm.server.vo.Bass0505SrhVO;
import com.app.exterms.resm.server.vo.Bass0505VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0505DAO.java
 * @Description : Bass0505 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass0505DAO")
public class Bass0505DAO extends EgovAbstractDAO {

	/**
	 * BASS0505?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Bass0505VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertBass0505(Bass0505VO vo) throws Exception {
        return (String)insert("bass0505DAO.insertBass0505_S", vo);
    }

    /**
	 * BASS0505?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass0505VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateBass0505(Bass0505VO vo) throws Exception {
        update("bass0505DAO.updateBass0505_S", vo);
    }

    /**
	 * BASS0505?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Bass0505VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteBass0505(Bass0505VO vo) throws Exception {
        delete("bass0505DAO.deleteBass0505_S", vo);
    }

    /**
	 * BASS0505?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Bass0505VO
	 * @return 조회?�� BASS0505
	 * @exception Exception
	 */
    public Bass0505VO selectBass0505(Bass0505VO vo) throws Exception {
        return (Bass0505VO) selectByPk("bass0505DAO.selectBass0505_S", vo);
    }

    /**
	 * BASS0505 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS0505 목록
	 * @exception Exception
	 */
    public List<?> selectBass0505List(Bass0505SrhVO searchVO) throws Exception {
        return list("bass0505DAO.selectBass0505List_D", searchVO);
    }

    /**
	 * BASS0505 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return BASS0505 �? �??��
	 * @exception
	 */
    public int selectBass0505ListTotCnt(Bass0505SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass0505DAO.selectBass0505ListTotCnt_S", searchVO);
    }

}
