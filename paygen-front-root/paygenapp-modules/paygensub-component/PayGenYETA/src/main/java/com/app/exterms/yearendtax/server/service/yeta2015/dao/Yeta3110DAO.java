package com.app.exterms.yearendtax.server.service.yeta2015.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Yeta3110SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3110VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3110DAO.java
 * @Description : Yeta3110 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta3110DAO")
public class Yeta3110DAO extends EgovAbstractDAO {

	/**
	 * YETA3110을 등록한다.(종전근무지 팝업)
	 * @param vo - 등록할 정보가 담긴 Yeta3110VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
	public String insertYetaP03006To3110(Yeta3110VO vo) {
		return (String)insert("yeta3110DAO.insertYeta3110_S", vo);
	}

	
    /**
	 * YETA3110을 수정한다.(종전근무지 팝업)
	 * @param vo - 수정할 정보가 담긴 Yeta3110VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
	public void updateYetaP03006To3110(Yeta3110VO vo) {
		update("yeta3110DAO.updateYeta3110_S", vo);
	}

	
    /**
	 * YETA3110을 삭제한다.(종전근무지 팝업)
	 * @param vo - 삭제할 정보가 담긴 Yeta3110VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
	public void deleteYetaP03006To3110(Yeta3110VO vo) {
		delete("yeta3110DAO.deleteYeta3110_S", vo);
	}
	
	
    /**
	 * YETA3110 목록을 조회한다.(종전근무지 팝업)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3110 목록
	 * @exception Exception
	 */
    public List selectYetaP03001To3170List(Yeta3110SrhVO yeta3110SrhVo) throws Exception {
        return list("yeta3110DAO.selectYeta3110List_D", yeta3110SrhVo);
    }

    /**
	 * YETA3110 총 갯수를 조회한다.(종전근무지 팝업)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3110 총 갯수
	 * @exception
	 */
    public int selectYetaP03006To3110ListTotCnt(Yeta3110SrhVO yeta3110SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta3110DAO.selectYeta3110ListTotCnt_S", yeta3110SrhVo);
    }
	
	
	
	
	/**
	 * YETA3110을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3110VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertYeta3110(Yeta3110VO vo) throws Exception {
        return (String)insert("yeta3110DAO.insertYeta3110_S", vo);
    }

    /**
	 * YETA3110을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3110VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateYeta3110(Yeta3110VO vo) throws Exception {
        update("yeta3110DAO.updateYeta3110_S", vo);
    }

    /**
	 * YETA3110을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3110VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteYeta3110(Yeta3110VO vo) throws Exception {
        delete("yeta3110DAO.deleteYeta3110_S", vo);
    }

    /**
	 * YETA3110을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3110VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void fnPayr06430_PAYR435_CREATE_Delete(Yeta3110VO vo) throws Exception {
        delete("yeta3110DAO.fnPayr06430_PAYR435_CREATE_Delete_S", vo);
    }  
    
    
    /**
	 * YETA3110을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3110VO
	 * @return 조회한 YETA3110
	 * @exception Exception
	 */
    public Yeta3110VO selectYeta3110(Yeta3110VO vo) throws Exception {
        return (Yeta3110VO) selectByPk("yeta3110DAO.selectYeta3110_S", vo);
    }

}
