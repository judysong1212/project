package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr3150SrhVO;
import com.app.exterms.insurance.server.vo.Insr3150VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr3150DAO.java
 * @Description : Insr3150 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.03.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr3150DAO")
public class Insr3150DAO extends EgovAbstractDAO {

	/**
	 * INSR3150을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr3150VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr3150(Insr3150VO vo) throws Exception {
        return (String)insert("insr3150DAO.insertInsr3150_S", vo);
    }

    /**
	 * INSR3150을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr3150VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr3150(Insr3150VO vo) throws Exception {
        update("insr3150DAO.updateInsr3150_S", vo);
    }

    /**
	 * INSR3150을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr3150VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr3150(Insr3150VO vo) throws Exception {
        delete("insr3150DAO.deleteInsr3150_S", vo);
    }

    /**
	 * INSR3150을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr3150VO
	 * @return 조회한 INSR3150
	 * @exception Exception
	 */
    public Insr3150VO selectInsr3150(Insr3150VO vo) throws Exception {
        return (Insr3150VO) selectByPk("insr3150DAO.selectInsr3150_S", vo);
    }
    public Insr3150VO selectInsr4400ToInsr3150(Insr3150VO vo) throws Exception {
        return (Insr3150VO) selectByPk("insr3150DAO.selectInsr4400ToInsr3150_S", vo);
    } 
    

    /**
	 * INSR3150 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3150 목록
	 * @exception Exception
	 */
    public List<?> selectInsr3150List(Insr3150SrhVO searchVO) throws Exception {
        return list("insr3150DAO.selectInsr3150List_D", searchVO);
    }

    /**
	 * INSR3150 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3150 총 갯수
	 * @exception
	 */
    public int selectInsr3150ListTotCnt(Insr3150SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr3150DAO.selectInsr3150ListTotCnt_S", searchVO);
    }
    
    /**
   	 * INSR3150 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR3150 목록
   	 * @exception Exception
   	 */
	public List<?> selectInsr4400ToInsr3150List(Insr3150SrhVO searchVO) throws Exception {
		return list("insr3150DAO.selectInsr4400ToInsr3150List_D", searchVO);
	}

    /**
   	 * INSR3150 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR3150 총 갯수
   	 * @exception
   	 */
	public int selectInsr4400ToInsr3150ListTotCnt(Insr3150SrhVO searchVO) {
		return (Integer)getSqlMapClientTemplate().queryForObject("insr3150DAO.selectInsr4400ToInsr3150ListTotCnt_S", searchVO);
	}
       
	/**
	 * INSR3150 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
     * @return INSR3150 목록
     * @exception Exception
     */
	public List<?> selectXlsInsr4400ToInsr3150List(Insr3150SrhVO searchVO) throws Exception {
		return list("insr3150DAO.selectXlsInsr4400ToInsr3150List_D", searchVO);
	}
	
	/**
	 * INSR3150 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
     * @return INSR3150 목록
     * @exception Exception
     */
	public List<?> selectTxtInsr4400ToInsr3150List(Insr3150SrhVO searchVO) throws Exception {
		return list("insr3150DAO.selectTxtInsr4400ToInsr3150List_D", searchVO);
	}
	
	/**
	 * INSR3150 연간보수총액, 근무월수를 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr3150VO
	 * @return void형
	 * @exception Exception
	 */
	public void updateTxtFileInsr3150(Insr3150VO vo) throws Exception {
		update("insr3150DAO.updateTxtFileInsr3150", vo);
	}
	
	/**************************** 엑셀 업로드 ****************************/
    /**
	 * INSR3150을 삭제한다.(엑셀)
	 * @param vo - 삭제할 정보가 담긴 Insr3150VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteXlsInsr3150(Insr3150VO vo) throws Exception {
        delete("insr3150DAO.deleteXlsInsr3150", vo);
    }
    
	/**
	 * INSR3150을 등록한다.(엑셀)
	 * @param vo - 등록할 정보가 담긴 Insr3150VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertXlsInsr3150(Insr3150VO vo) throws Exception {
        return (String)insert("insr3150DAO.insertXlsInsr3150", vo);
    }
	/**************************** 엑셀 업로드 ****************************/
    
    

}
