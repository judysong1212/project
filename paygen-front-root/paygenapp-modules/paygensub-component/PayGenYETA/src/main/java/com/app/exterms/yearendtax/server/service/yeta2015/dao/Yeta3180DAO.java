package com.app.exterms.yearendtax.server.service.yeta2015.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Yeta3180SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3180VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3180DAO.java
 * @Description : Yeta3180 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta3180DAO")
public class Yeta3180DAO extends EgovAbstractDAO  implements IsSerializable{
	
	
	/**
	 * YETA3180을 등록한다.(기부금내역등록  팝업)
	 * @param vo - 등록할 정보가 담긴 Yeta3180VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYetaP03001To3180(Yeta3180VO vo) throws Exception {
        return (String)insert("yeta3180DAO.insertYeta3180_S", vo);
    }

    /**
	 * YETA3180을 수정한다.(기부금내역등록  팝업)
	 * @param vo - 수정할 정보가 담긴 Yeta3180VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYetaP03001To3180(Yeta3180VO vo) throws Exception {
        update("yeta3180DAO.updateYeta3180_S", vo);
    }

    /**
	 * YETA3180을 삭제한다.(기부금내역등록  팝업)
	 * @param vo - 삭제할 정보가 담긴 Yeta3180VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYetaP03001To3180(Yeta3180VO vo) throws Exception {
        delete("yeta3180DAO.deleteYeta3180_S", vo);
    }
    
    
    
    /**
	 * YETA3180 목록을 조회한다.(기부금내역등록  팝업)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3180 목록
	 * @exception Exception
	 */
    public List<?> selectYetaP03003To3180List(Yeta3180SrhVO searchVO) throws Exception {
        return list("yeta3180DAO.selectYetaP03003To3180List_D", searchVO);
    }

    /**
	 * YETA3180 총 갯수를 조회한다.(기부금내역등록  팝업)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3180 총 갯수
	 * @exception
	 */
    public int selectYetaP03003To3180ListTotCnt(Yeta3180SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta3180DAO.selectYetaP03003To3180ListTotCnt_S", searchVO);
    }
	
	
	
	
	
	
	

	/**
	 * YETA3180을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3180VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertYeta3180(Yeta3180VO vo) throws Exception {
        return (String)insert("yeta3180DAO.insertYeta3180_S", vo);
    }

    /**
	 * YETA3180을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3180VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateYeta3180(Yeta3180VO vo) throws Exception {
        update("yeta3180DAO.updateYeta3180_S", vo);
    }

    /**
	 * YETA3180을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3180VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteYeta3180(Yeta3180VO vo) throws Exception {
        delete("yeta3180DAO.deleteYeta3180_S", vo);
    }

    /**
	 * YETA3180을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3180VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void fnPayr06430_PAYR440_CREATE_Delete(Yeta3180VO vo) throws Exception {
        delete("yeta3180DAO.fnPayr06430_PAYR440_CREATE_Delete_S", vo);
    } 
    
    
    /**
	 * YETA3180을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3180VO
	 * @return 조회한 YETA3180
	 * @exception Exception
	 */
    public Yeta3180VO selectYeta3180(Yeta3180VO vo) throws Exception {
        return (Yeta3180VO) selectByPk("yeta3180DAO.selectYeta3180_S", vo);
    }

    /**
	 * YETA3180 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3180 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3180List(Yeta3180SrhVO searchVO) throws Exception {
        return list("yeta3180DAO.selectYeta3180List_D", searchVO);
    }

    /**
	 * YETA3180 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3180 총 갯수
	 * @exception
	 */
    public int selectYeta3180ListTotCnt(Yeta3180SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta3180DAO.selectYeta3180ListTotCnt_S", searchVO);
    }

}
