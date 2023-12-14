package com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao;

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

@Repository("InfcPkgYeta3220DAO")
public class InfcPkgYeta3220DAO extends EgovAbstractDAO {
	
	
	/**
	 * 가족생성을 등록 한다. YETA3220을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3220VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String fnYeta1100_YETA3220_2016_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
        return (String)insert("infcPkgYeta3220DAO.fnYeta1100_YETA3220_2016_CREATE_Insert_S", infcPkgYeta2000Vo);
    }
	
	/**
	 * 가족생성을 등록 한다. YETA3220을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3220VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String fnYeta2100_YETA3220_2017_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
        return (String)insert("infcPkgYeta3220DAO.fnYeta1100_YETA3220_2016_CREATE_Insert_S", infcPkgYeta2000Vo);
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
	public void fnYeta1100_YETA3220_2016_INSU_FETC_CREATE_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
		update("infcPkgYeta3220DAO.fnYeta1100_YETA3220_2016_INSU_FETC_Update_S", infcPkgYeta2000Vo);
	} 
	
	@Transactional
	public void fnYeta2100_YETA3220_2017_INSU_FETC_CREATE_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
		update("infcPkgYeta3220DAO.fnYeta1100_YETA3220_2016_INSU_FETC_Update_S", infcPkgYeta2000Vo);
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
    public void fnYeta1100_YETA3220_2016_CREATE_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
        update("infcPkgYeta3220DAO.fnYeta1100_YETA3220_2016_CREATE_Update_S", infcPkgYeta2000Vo);
    } 	
		
	@Transactional
    public void fnYeta2100_YETA3220_2017_CREATE_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
        update("infcPkgYeta3220DAO.fnYeta1100_YETA3220_2016_CREATE_Update_S", infcPkgYeta2000Vo);
    } 	
	
		
	

	/**
	 * 가족생성을 등록 한다. YETA3220을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3220VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String fnPayr06430_PAYR410_2014_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
        return (String)insert("infcPkgYeta3220DAO.fnPayr06430_PAYR410_2014_CREATE_Insert_S", infcPkgYeta2000Vo);
    }
 
	
	/**
	 * YETA3220을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3220VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3220(InfcPkgYeta3220VO vo) throws Exception {
        return (String)insert("infcPkgYeta3220DAO.insertYetaPrc3220_S", vo);
    }

    
    /**
	 * YETA3220을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3220VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3220(InfcPkgYeta3220VO vo) throws Exception {
        update("infcPkgYeta3220DAO.updateYetaPrc3220_S", vo);
    }
	  @Transactional
    public void fnPayr06430_PAYR410_2016_01_Update(InfcPkgYeta3220VO vo) throws Exception {
        update("infcPkgYeta3220DAO.fnPayr06430_PAYR410_2016_01_Update", vo);
    }   
	  
      @Transactional
    public void fnPayr06425_YE3220_2016_Update(InfcPkgYeta3220VO vo) throws Exception {
        update("infcPkgYeta3220DAO.fnPayr06425_YE3220_2016_Update", vo);
    } 
	  @Transactional
    public void fnPayr06430_PAYR410_2015_INSU_FETC_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
        update("infcPkgYeta3220DAO.fnPayr06430_PAYR410_2015_INSU_FETC_Update_S", infcPkgYeta2000Vo);
    }
	  
      @Transactional
    public void fnPayr06425_PAYR415_2016_18_Update(InfcPkgYeta3220VO vo) throws Exception {
        update("infcPkgYeta3220DAO.fnPayr06425_PAYR415_2016_18_Update", vo);
    }
    
 // TODO 빠짐 확인 후 처리 해야 함  
  @Transactional
    public void fnPayr06430_PAYR410_2015_01_Update(InfcPkgYeta3220VO vo) throws Exception {
        update("infcPkgYeta3220DAO.fnPayr06430_PAYR410_2015_01_Update", vo);
    } 
  // TODO 빠짐 확인 후 처리 해야 함 
	  @Transactional
    public void fnPayr06430_PAYR410_2014_INSU_FETC_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
        update("infcPkgYeta3220DAO.fnPayr06430_PAYR410_2014_INSU_FETC_Update_S", infcPkgYeta2000Vo);
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
     * @param infcPkgYeta2000Vo
     * @throws Exception
     */
	  @Transactional
    public void fnPayr06430_PAYR410_2014_CREATE_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
        update("infcPkgYeta3220DAO.fnPayr06430_PAYR410_2014_CREATE_Update_S", infcPkgYeta2000Vo);
    } 
    
     
    /**
	 * YETA3220을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3220VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3220(InfcPkgYeta3220VO vo) throws Exception {
        delete("infcPkgYeta3220DAO.deleteYetaPrc3220_S", vo);
    }
    
    /**
	 * YETA3220을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3220VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06430_PAYR410_CREATE_Delete(InfcPkgYeta3220VO vo) throws Exception {
        delete("infcPkgYeta3220DAO.fnPayr06430_PAYR410_CREATE_Delete_S", vo);
    } 
    

    /**
	 * YETA3220을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3220VO
	 * @return 조회한 YETA3220
	 * @exception Exception
	 */
    public InfcPkgYeta3220VO selectYeta3220(InfcPkgYeta3220VO vo) throws Exception {
        return (InfcPkgYeta3220VO) selectByPk("infcPkgYeta3220DAO.selectYetaPrc3220_S", vo);
    }

    /**
	 * YETA3220 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3220 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3220List(InfcPkgYeta3220SrhVO searchVO) throws Exception {
        return list("infcPkgYeta3220DAO.selectYetaPrc3220List_D", searchVO);
    }

    /**
	 * YETA3220 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3220 총 갯수
	 * @exception
	 */
    public int selectYeta3220ListTotCnt(InfcPkgYeta3220SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYeta3220DAO.selectYetaPrc3220ListTotCnt_S", searchVO);
    }

    public List<?> fnPayr06430_PAYR410_2015_SelectAll(InfcPkgYeta3220SrhVO searchVO) throws Exception {
        return list("infcPkgYeta3220DAO.fnPayr06430_PAYR410_2015_SelectAll", searchVO);
    }
   
}
