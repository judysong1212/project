package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010aSrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010aVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye169010aDAO.java
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

@Repository("InfcPkgYe169010aDAO")
public class InfcPkgYe169010aDAO extends EgovAbstractDAO {
 

	@Transactional
    public String fnYeta2100_YE169010a_2017_CREATE_Insert(InfcPkgYe169010aVO infcPkgYe169010AVo) throws Exception {
        return (String)insert("infcPkgYe169010aDAO.fnYeta2100_YE169010a_2017_CREATE_Insert_S", infcPkgYe169010AVo);
    } 	
	
	/**
	 * YE169010A?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye169010aVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe169010a(InfcPkgYe169010aVO vo) throws Exception {
        return (String)insert("infcPkgYe169010aDAO.insertYe169010a_S", vo);
    }

    /**
	 * YE169010A?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye169010aVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe169010a(InfcPkgYe169010aVO vo) throws Exception {
        update("infcPkgYe169010aDAO.updateYe169010a_S", vo);
    }

    /**
	 * YE169010A?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye169010aVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe169010a(InfcPkgYe169010aVO vo) throws Exception {
        delete("infcPkgYe169010aDAO.deleteYe169010a_S", vo);
    }

    /**
	 * YE169010A?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye169010aVO
	 * @return 조회?�� YE169010A
	 * @exception Exception
	 */
    public InfcPkgYe169010aVO selectYe169010a(InfcPkgYe169010aVO vo) throws Exception {
        return (InfcPkgYe169010aVO) selectByPk("infcPkgYe169010aDAO.selectYe169010a_S", vo);
    }

    /**
	 * YE169010A 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE169010A 목록
	 * @exception Exception
	 */
    public List<?> selectYe169010aList(InfcPkgYe169010aSrhVO searchVO) throws Exception {
        return list("infcPkgYe169010aDAO.selectYe169010aList_D", searchVO);
    }

    /**
	 * YE169010A �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE169010A �? �??��
	 * @exception
	 */
    public int selectYe169010aListTotCnt(InfcPkgYe169010aSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe169010aDAO.selectYe169010aListTotCnt_S", searchVO);
    }

}
