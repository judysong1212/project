package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3100SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3100DAO.java
 * @Description : Yeta3100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("YetaPrc3100DAO")
public class YetaPrc3100DAO extends EgovAbstractDAO {

	/**
	 * YETA3100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3100(InfcPkgYeta3100VO vo) throws Exception {
        return (String)insert("yetaPrc3100DAO.insertYetaPrc3100_S", vo);
    }
	  @Transactional
    public String fnPayr06430_Payr418_2014_Insert(InfcPkgYeta3100VO vo) throws Exception {
        return (String)insert("yetaPrc3100DAO.fnPayr06430_Payr418_2014_Insert", vo);
    }
    
   

    /**
	 * YETA3100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3100VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3100(InfcPkgYeta3100VO vo) throws Exception {
        update("yetaPrc3100DAO.updateYetaPrc3100_S", vo);
    }

    /**
	 * YETA3100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3100VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3100(InfcPkgYeta3100VO vo) throws Exception {
        delete("yetaPrc3100DAO.deleteYetaPrc3100_S", vo);
    }
	  @Transactional
    public void fnPayr06430_Payr418_2014_Delete(InfcPkgYeta3100VO vo) throws Exception {
        delete("yetaPrc3100DAO.fnPayr06430_Payr418_2014_Delete", vo);
    }
    
    
    /**
	 * YETA3100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3100VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06430_PAYR418_CREATE_Delete(InfcPkgYeta3100VO vo) throws Exception {
        delete("yetaPrc3100DAO.fnPayr06430_PAYR418_CREATE_Delete_S", vo);
    }
    

    /**
	 * YETA3100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3100VO
	 * @return 조회한 YETA3100
	 * @exception Exception
	 */
    public InfcPkgYeta3100VO selectYeta3100(InfcPkgYeta3100VO vo) throws Exception {
        return (InfcPkgYeta3100VO) selectByPk("yetaPrc3100DAO.selectYetaPrc3100_S", vo);
    }

    /**
	 * YETA3100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3100 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3100List(InfcPkgYeta3100SrhVO searchVO) throws Exception {
        return list("yetaPrc3100DAO.selectYetaPrc3100List_D", searchVO);
    }

    /**
	 * YETA3100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3100 총 갯수
	 * @exception
	 */
    public int selectYeta3100ListTotCnt(InfcPkgYeta3100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yetaPrc3100DAO.selectYetaPrc3100ListTotCnt_S", searchVO);
    }

}
