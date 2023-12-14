package com.app.smrmf.infc.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe169010aSrh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe169010a_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye169010a_2020_DAO.java
 * @Description : Ye169010a DAO Class
 * @Modification Information
 *
 * @author atres
 * @since atres
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe169010a_2020_DAO")
public class InfcPkgYe169010a_2020_DAO extends EgovAbstractDAO {
 

	@Transactional
    public String fnYeta5100_YE169010a_2020_CREATE_Insert(InfcPkgYe169010a_2020_VO infcPkgYe169010AVo) throws Exception {
        return (String)insert("infcPkgYe169010a_2020_DAO.fnYeta5100_YE169010a_2020_CREATE_Insert_S", infcPkgYe169010AVo);
    } 	
	
	/**
	 * YE169010A?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye169010aVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe169010a(InfcPkgYe169010a_2020_VO vo) throws Exception {
        return (String)insert("infcPkgYe169010a_2020_DAO.insertYe169010a_S", vo);
    }

    /**
	 * YE169010A?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye169010aVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe169010a(InfcPkgYe169010a_2020_VO vo) throws Exception {
        update("infcPkgYe169010a_2020_DAO.updateYe169010a_S", vo);
    }

    /**
	 * YE169010A?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye169010aVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe169010a(InfcPkgYe169010a_2020_VO vo) throws Exception {
        delete("infcPkgYe169010a_2020_DAO.deleteYe169010a_S", vo);
    }

    /**
	 * YE169010A?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye169010aVO
	 * @return 조회?�� YE169010A
	 * @exception Exception
	 */
    public InfcPkgYe169010a_2020_VO selectYe169010a(InfcPkgYe169010a_2020_VO vo) throws Exception {
        return (InfcPkgYe169010a_2020_VO) selectByPk("infcPkgYe169010a_2020_DAO.selectYe169010a_S", vo);
    }

    /**
	 * YE169010A 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE169010A 목록
	 * @exception Exception
	 */
    public List<?> selectYe169010aList(InfcPkgYe169010aSrh_2020_VO searchVO) throws Exception {
        return list("infcPkgYe169010a_2020_DAO.selectYe169010aList_D", searchVO);
    }

    /**
	 * YE169010A �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE169010A �? �??��
	 * @exception
	 */
    public int selectYe169010aListTotCnt(InfcPkgYe169010aSrh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe169010a_2020_DAO.selectYe169010aListTotCnt_S", searchVO);
    }

}
