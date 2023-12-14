package com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe167040Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe167040_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167040_2022_DAO.java
 * @Description : Ye167040 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167040_2022_DAO")
public class InfcPkgYe167040_2022_DAO extends EgovAbstractDAO {

	/**
	 * YE167040?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167040VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167040(InfcPkgYe167040_2022_VO vo) throws Exception {
        return (String)insert("infcPkgYe167040_2022_DAO.insertYe167040_S", vo);
    }

    /**
	 * YE167040?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167040VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167040(InfcPkgYe167040_2022_VO vo) throws Exception {
        update("infcPkgYe167040_2022_DAO.updateYe167040_S", vo);
    }

    /**
	 * YE167040?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167040VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167040(InfcPkgYe167040_2022_VO vo) throws Exception {
        delete("infcPkgYe167040_2022_DAO.deleteYe167040_S", vo);
    }

    /**
	 * YE167040?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167040VO
	 * @return 조회?�� YE167040
	 * @exception Exception
	 */
    public InfcPkgYe167040_2022_VO selectYe167040(InfcPkgYe167040_2022_VO vo) throws Exception {
        return (InfcPkgYe167040_2022_VO) selectByPk("infcPkgYe167040_2022_DAO.selectYe167040_S", vo);
    }

    /**
	 * YE167040 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167040 목록
	 * @exception Exception
	 */
    public List<?> selectYe167040List(InfcPkgYe167040Srh_2022_VO searchVO) throws Exception {
        return list("infcPkgYe167040_2022_DAO.selectYe167040List_D", searchVO);
    }

    /**
	 * YE167040 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167040 �? �??��
	 * @exception
	 */
    public int selectYe167040ListTotCnt(InfcPkgYe167040Srh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167040_2022_DAO.selectYe167040ListTotCnt_S", searchVO);
    }

}
