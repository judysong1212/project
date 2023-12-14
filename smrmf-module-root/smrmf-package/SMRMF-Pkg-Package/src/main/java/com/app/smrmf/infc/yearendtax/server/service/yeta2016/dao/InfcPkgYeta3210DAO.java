package com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3210SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3210VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3210DAO.java
 * @Description : Yeta3210 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYeta3210DAO")
public class InfcPkgYeta3210DAO extends EgovAbstractDAO {

	/**
	 * YETA3210을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3210VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3210(InfcPkgYeta3210VO vo) throws Exception {
        return (String)insert("infcPkgYeta3210DAO.insertYetaPrc3210_S", vo);
    }
    
    /**
	 * YETA3210을 등록한다.연말정산 급여내역 생성 
	 * @param vo - 등록할 정보가 담긴 Yeta3210VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String fnPayr06420_PAYR417_2014_CREATE_Insert(InfcPkgYeta3210VO vo) throws Exception {
        return (String)insert("infcPkgYeta3210DAO.fnPayr06420_PAYR417_2014_CREATE_Insert_S", vo);
    } 
   
    /**
	 * YETA3210을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3210VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3210(InfcPkgYeta3210VO vo) throws Exception {
        update("infcPkgYeta3210DAO.updateYetaPrc3210_S", vo);
    }

    /**
	 * YETA3210을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3210VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3210(InfcPkgYeta3210VO vo) throws Exception {
        delete("infcPkgYeta3210DAO.deleteYetaPrc3210_S", vo);
    }

    /**
 	 * YETA3210을 삭제한다.
 	 * @param vo - 삭제할 정보가 담긴 Yeta3210VO
 	 * @return void형 
 	 * @exception Exception
 	 */
	  @Transactional
     public void fnPayr06420_PAYR417_CREATE_Delete(InfcPkgYeta3210VO vo) throws Exception {
         delete("infcPkgYeta3210DAO.fnPayr06420_PAYR417_CREATE_Delete_S", vo);
     }
  
    
    /**
	 * YETA3210을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3210VO
	 * @return 조회한 YETA3210
	 * @exception Exception
	 */
    public InfcPkgYeta3210VO selectYeta3210(InfcPkgYeta3210VO vo) throws Exception {
        return (InfcPkgYeta3210VO) selectByPk("infcPkgYeta3210DAO.selectYetaPrc3210_S", vo);
    }

    /**
	 * YETA3210 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3210 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3210List(InfcPkgYeta3210SrhVO searchVO) throws Exception {
        return list("infcPkgYeta3210DAO.selectYetaPrc3210List_D", searchVO);
    }

    /**
	 * YETA3210 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3210 총 갯수
	 * @exception
	 */
    public int selectYeta3210ListTotCnt(InfcPkgYeta3210SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYeta3210DAO.selectYetaPrc3210ListTotCnt_S", searchVO);
    }

}
