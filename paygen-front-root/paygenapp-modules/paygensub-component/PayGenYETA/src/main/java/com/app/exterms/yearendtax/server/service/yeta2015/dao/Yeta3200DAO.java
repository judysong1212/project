package com.app.exterms.yearendtax.server.service.yeta2015.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Yeta3200SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3200VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3200DAO.java
 * @Description : Yeta3200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta3200DAO")
public class Yeta3200DAO extends EgovAbstractDAO {


    /**
	 * YETA3200을 수정한다.(비과세감면소득 팝업)
	 * @param vo - 수정할 정보가 담긴 Yeta3200VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
	public void updateYetaP03008To3200(Yeta3200VO vo) {
		update("yeta3200DAO.updateYeta3200_S", vo);
	}
	
	
	/**
	 * YETA3200을 등록한다.(비과세감면소득 팝업)
	 * @param vo - 등록할 정보가 담긴 Yeta3200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYetaP03008To3200(Yeta3200VO vo) throws Exception {
        return (String)insert("yeta3200DAO.insertYeta3200_S", vo);
    }

    /**
	 * YETA3200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3200VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3200(Yeta3200VO vo) throws Exception {
        update("yeta3200DAO.updateYeta3200_S", vo);
    }

    /**
	 * YETA3200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3200VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3200(Yeta3200VO vo) throws Exception {
        delete("yeta3200DAO.deleteYeta3200_S", vo);
    }
	  @Transactional
    public void fnPayr06430_Yeta3200_CREATE_Delete(Yeta3200VO vo) throws Exception {
        delete("yeta3200DAO.fnPayr06430_Yeta3200_CREATE_Delete_S", vo);
    }
    
    
    

    /**
	 * YETA3200을 조회한다.(비과세 및 감면소득)
	 * @param vo - 조회할 정보가 담긴 Yeta3200VO
	 * @return 조회한 YETA3200
	 * @exception Exception
	 */
    public Yeta3200VO selectYeta3200(Yeta3200VO vo) throws Exception {
        return (Yeta3200VO) selectByPk("yeta3200DAO.selectYeta3200_S", vo);
    }

    /**
	 * YETA3200 목록을 조회한다.(비과세 및 감면소득)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3200 목록
	 * @exception Exception
	 */
    public List selectYetaP03001To3200List(Yeta3200SrhVO yeta3200SrhVo) throws Exception {
        return list("yeta3200DAO.selectYeta3200List_D", yeta3200SrhVo);
    }

    /**
	 * YETA3200 총 갯수를 조회한다.(비과세 및 감면소득)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3200 총 갯수
	 * @exception
	 */
    public int selectYetaP03008To3200ListTotCnt(Yeta3200SrhVO yeta3200SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta3200DAO.selectYeta3200ListTotCnt_S", yeta3200SrhVo);
    }

}
