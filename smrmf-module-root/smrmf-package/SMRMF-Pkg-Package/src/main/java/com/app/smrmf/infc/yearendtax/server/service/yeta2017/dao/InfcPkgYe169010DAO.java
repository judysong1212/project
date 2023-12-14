package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye169010DAO.java
 * @Description : Ye169010 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe169010DAO")
public class InfcPkgYe169010DAO extends EgovAbstractDAO {
 

	@Transactional
    public String fnYeta2100_YE169010_PAYR_2017_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception {
        return (String)insert("infcPkgYe169010DAO.fnYeta2100_YE169010_PAYR_2017_CREATE_Insert_S", infcPkgYe160401Vo);
    } 
	
	@Transactional  
	public int fnYeta2300_YE169010_Tax_gun_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
                                
    	  return  update("infcPkgYe169010DAO.fnYeta2300_YE169010_Tax_gun_Update_S", infcPkgYe169010Vo); 
		// TODO 해당 테이블 정보에 맞게 수정
		 
	}  
	
	/**
	 * YE169010?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye169010VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe169010(InfcPkgYe169010VO vo) throws Exception {
        return (String)insert("infcPkgYe169010DAO.insertYe169010_S", vo);
    }

    /**
	 * YE169010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye169010VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe169010(InfcPkgYe169010VO vo) throws Exception {
        update("infcPkgYe169010DAO.updateYe169010_S", vo);
    }

    /**
	 * YE169010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye169010VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe169010(InfcPkgYe169010VO vo) throws Exception {
        delete("infcPkgYe169010DAO.deleteYe169010_S", vo);
    }

    /**
	 * YE169010?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye169010VO
	 * @return 조회?�� YE169010
	 * @exception Exception
	 */
    public InfcPkgYe169010VO selectYe169010(InfcPkgYe169010VO vo) throws Exception {
        return (InfcPkgYe169010VO) selectByPk("infcPkgYe169010DAO.selectYe169010_S", vo);
    }

    /**
	 * YE169010 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE169010 목록
	 * @exception Exception
	 */
    public List<?> selectYe169010List(InfcPkgYe169010SrhVO searchVO) throws Exception {
        return list("infcPkgYe169010DAO.selectYe169010List_D", searchVO);
    }

    /**
	 * YE169010 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE169010 �? �??��
	 * @exception
	 */
    public int selectYe169010ListTotCnt(InfcPkgYe169010SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe169010DAO.selectYe169010ListTotCnt_S", searchVO);
    }

}
