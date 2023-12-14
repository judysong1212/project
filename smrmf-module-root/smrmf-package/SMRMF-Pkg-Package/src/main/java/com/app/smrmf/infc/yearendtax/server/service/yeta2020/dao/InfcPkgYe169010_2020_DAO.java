package com.app.smrmf.infc.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe169010Srh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe169010_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye169010_2020_DAO.java
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

@Repository("InfcPkgYe169010_2020_DAO")
public class InfcPkgYe169010_2020_DAO extends EgovAbstractDAO {
 

	@Transactional
    public String fnYeta5100_YE169010_PAYR_2020_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception {
        return (String)insert("infcPkgYe169010_2020_DAO.fnYeta5100_YE169010_PAYR_2020_CREATE_Insert_S", infcPkgYe160401Vo);
    } 
	
	@Transactional  
	public int fnYeta5300_YE169010_Tax_gun_Update(InfcPkgYe169010_2020_VO infcPkgYe169010Vo) throws Exception {
                                
    	  return  update("infcPkgYe169010_2020_DAO.fnYeta5300_YE169010_Tax_gun_Update_S", infcPkgYe169010Vo); 
		// TODO 해당 테이블 정보에 맞게 수정
		 
	}  
	
	/**
	 * YE169010?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye169010VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe169010(InfcPkgYe169010_2020_VO vo) throws Exception {
        return (String)insert("infcPkgYe169010_2020_DAO.insertYe169010_S", vo);
    }

    /**
	 * YE169010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye169010VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe169010(InfcPkgYe169010_2020_VO vo) throws Exception {
        update("infcPkgYe169010_2020_DAO.updateYe169010_S", vo);
    }

    /**
	 * YE169010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye169010VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe169010(InfcPkgYe169010_2020_VO vo) throws Exception {
        delete("infcPkgYe169010_2020_DAO.deleteYe169010_S", vo);
    }

    /**
	 * YE169010?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye169010VO
	 * @return 조회?�� YE169010
	 * @exception Exception
	 */
    public InfcPkgYe169010_2020_VO selectYe169010(InfcPkgYe169010_2020_VO vo) throws Exception {
        return (InfcPkgYe169010_2020_VO) selectByPk("infcPkgYe169010_2020_DAO.selectYe169010_S", vo);
    }

    /**
	 * YE169010 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE169010 목록
	 * @exception Exception
	 */
    public List<?> selectYe169010List(InfcPkgYe169010Srh_2020_VO searchVO) throws Exception {
        return list("infcPkgYe169010_2020_DAO.selectYe169010List_D", searchVO);
    }

    /**
	 * YE169010 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE169010 �? �??��
	 * @exception
	 */
    public int selectYe169010ListTotCnt(InfcPkgYe169010Srh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe169010_2020_DAO.selectYe169010ListTotCnt_S", searchVO);
    }

}