package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3190SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3190VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3190DAO.java
 * @Description : Yeta3190 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("YetaPrc3190DAO")
public class YetaPrc3190DAO extends EgovAbstractDAO {

	/**
	 * YETA3190을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3190VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3190(InfcPkgYeta3190VO vo) throws Exception {
        return (String)insert("yetaPrc3190DAO.insertYetaPrc3190_S", vo);
    }
    
    /**
     * 
     * <pre>
     * 1. 개요 : 이월기부금  443 인서트
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : fnPayr06430_PAYR443_2014_CREATE_Insert
     * @date : Jan 25, 2016
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Jan 25, 2016		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param yetaPrc2000Vo
     * @return
     * @throws Exception
     */
	  @Transactional
    public String fnPayr06430_PAYR443_2014_CREATE_Insert(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
        return (String)insert("yetaPrc3190DAO.fnPayr06430_PAYR443_2014_CREATE_Insert_S", yetaPrc2000Vo);
    }
     

    /**
	 * YETA3190을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3190VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3190(InfcPkgYeta3190VO vo) throws Exception {
        update("yetaPrc3190DAO.updateYetaPrc3190_S", vo);
    }

    /**
	 * YETA3190을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3190VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3190(InfcPkgYeta3190VO vo) throws Exception {
        delete("yetaPrc3190DAO.deleteYetaPrc3190_S", vo);
    }
    
    /**
  	 * YETA3190을 삭제한다.
  	 * @param vo - 삭제할 정보가 담긴 Yeta3190VO
  	 * @return void형 
  	 * @exception Exception
  	 */
	  @Transactional
      public void fnPayr06430_PAYR443_CREATE_Delete(InfcPkgYeta3190VO vo) throws Exception {
          delete("yetaPrc3190DAO.fnPayr06430_PAYR443_CREATE_Delete_S", vo);
      } 
    

    /**
	 * YETA3190을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3190VO
	 * @return 조회한 YETA3190
	 * @exception Exception
	 */
    public InfcPkgYeta3190VO selectYeta3190(InfcPkgYeta3190VO vo) throws Exception {
        return (InfcPkgYeta3190VO) selectByPk("yetaPrc3190DAO.selectYetaPrc3190_S", vo);
    }

    /**
	 * YETA3190 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3190 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3190List(InfcPkgYeta3190SrhVO searchVO) throws Exception {
        return list("yetaPrc3190DAO.selectYetaPrc3190List_D", searchVO);
    }

    /**
	 * YETA3190 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3190 총 갯수
	 * @exception
	 */
    public int selectYeta3190ListTotCnt(InfcPkgYeta3190SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yetaPrc3190DAO.selectYetaPrc3190ListTotCnt_S", searchVO);
    }

}
