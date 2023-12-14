package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3220SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3220VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3220DAO.java
 * @Description : Yeta3220 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("YetaPrc3220DAO")
public class YetaPrc3220DAO extends EgovAbstractDAO {

	

	/**
	 * 가족생성을 등록 한다. YETA3220을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3220VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String fnPayr06430_PAYR410_2014_CREATE_Insert(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
        return (String)insert("yetaPrc3220DAO.fnPayr06430_PAYR410_2014_CREATE_Insert_S", yetaPrc2000Vo);
    }
 
	
	/**
	 * YETA3220을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3220VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3220(InfcPkgYeta3220VO vo) throws Exception {
        return (String)insert("yetaPrc3220DAO.insertYetaPrc3220_S", vo);
    }

    
    /**
	 * YETA3220을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3220VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3220(InfcPkgYeta3220VO vo) throws Exception {
        update("yetaPrc3220DAO.updateYetaPrc3220_S", vo);
    }
	  @Transactional
    public void fnPayr06430_PAYR410_2015_01_Update(InfcPkgYeta3220VO vo) throws Exception {
        update("yetaPrc3220DAO.fnPayr06430_PAYR410_2015_01_Update", vo);
    }   
	  @Transactional
    public void fnPayr06430_PAYR410_2014_INSU_FETC_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
        update("yetaPrc3220DAO.fnPayr06430_PAYR410_2014_INSU_FETC_Update_S", yetaPrc2000Vo);
    }
    
    /**
     * 
     * <pre>
     * 1. 개요 : 부녀자공제란 여성근로소득자 본인인경우 업데이트 처리
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : fnPayr06430_PAYR410_2014_CREATE_Update
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
     * @throws Exception
     */
	  @Transactional
    public void fnPayr06430_PAYR410_2014_CREATE_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
        update("yetaPrc3220DAO.fnPayr06430_PAYR410_2014_CREATE_Update_S", yetaPrc2000Vo);
    } 
    
     
    /**
	 * YETA3220을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3220VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3220(InfcPkgYeta3220VO vo) throws Exception {
        delete("yetaPrc3220DAO.deleteYetaPrc3220_S", vo);
    }
    
    /**
	 * YETA3220을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3220VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06430_PAYR410_CREATE_Delete(InfcPkgYeta3220VO vo) throws Exception {
        delete("yetaPrc3220DAO.fnPayr06430_PAYR410_CREATE_Delete_S", vo);
    } 
    

    /**
	 * YETA3220을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3220VO
	 * @return 조회한 YETA3220
	 * @exception Exception
	 */
    public InfcPkgYeta3220VO selectYeta3220(InfcPkgYeta3220VO vo) throws Exception {
        return (InfcPkgYeta3220VO) selectByPk("yetaPrc3220DAO.selectYetaPrc3220_S", vo);
    }

    /**
	 * YETA3220 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3220 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3220List(InfcPkgYeta3220SrhVO searchVO) throws Exception {
        return list("yetaPrc3220DAO.selectYetaPrc3220List_D", searchVO);
    }

    /**
	 * YETA3220 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3220 총 갯수
	 * @exception
	 */
    public int selectYeta3220ListTotCnt(InfcPkgYeta3220SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yetaPrc3220DAO.selectYetaPrc3220ListTotCnt_S", searchVO);
    }

    public List<?> fnPayr06430_PAYR410_2014_SelectAll(InfcPkgYeta3220SrhVO searchVO) throws Exception {
        return list("yetaPrc3220DAO.fnPayr06430_PAYR410_2014_SelectAll", searchVO);
    }
   
}
