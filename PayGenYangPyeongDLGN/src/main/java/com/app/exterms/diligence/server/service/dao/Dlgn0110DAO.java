package com.app.exterms.diligence.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.diligence.client.dto.Dlgn0110DTO;
import com.app.exterms.diligence.server.vo.Dlgn0110ExlVO;
import com.app.exterms.diligence.server.vo.Dlgn0110SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0110VO;
import com.app.exterms.diligence.server.vo.Dlgn0210VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Dlgn0110DAO.java
 * @Description : Dlgn0110 DAO Class
 * @Modification Information
 *
 * @author admin
 * @since 2016.07.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("dlgn0110DAO")
public class Dlgn0110DAO extends EgovAbstractDAO {

	/**
	 * DLGN0110을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Dlgn0110VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertDlgn0110(Dlgn0110VO vo) throws Exception {
        return (String)insert("dlgn0110DAO.insertDlgn0110_S", vo);
    }

    /**
	 * DLGN0110을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Dlgn0110VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateDlgn0110(Dlgn0110VO vo) throws Exception {
        update("dlgn0110DAO.updateDlgn0110_S", vo);
    }

    /**
	 * DLGN0110을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Dlgn0110VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteDlgn0110(Dlgn0110VO vo) throws Exception {
        delete("dlgn0110DAO.deleteDlgn0110_S", vo);
    }

    /**
	 * DLGN0110을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Dlgn0110VO
	 * @return 조회한 DLGN0110
	 * @exception Exception
	 */
    public Dlgn0110VO selectDlgn0110(Dlgn0110VO vo) throws Exception {
        return (Dlgn0110VO) selectByPk("dlgn0110DAO.selectDlgn0110_S", vo);
    }

    /**
	 * DLGN0110 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return DLGN0110 목록
	 * @exception Exception
	 */
    public List<?> selectDlgn0110List(Dlgn0110SrhVO searchVO) throws Exception {
        return list("dlgn0110DAO.selectDlgn0110List_D", searchVO);
    }

    /**
	 * DLGN0110 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return DLGN0110 총 갯수
	 * @exception
	 */
    public int selectDlgn0110ListTotCnt(Dlgn0110SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("dlgn0110DAO.selectDlgn0110ListTotCnt_S", searchVO);
    }
    
    /**
	 * 기본근무관리 엑셀 업로드시 DLGN0110을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Dlgn0110VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public int updateXlsDlgn0100(Dlgn0110ExlVO vo) throws Exception {
        int rtn = 0;
    	rtn = (Integer) update("dlgn0110DAO.updateXlsDlgn0100", vo);
         
         return rtn;
        
    }

    
    public void updateDlgn0210GridDlgn0110(Dlgn0210VO vo) throws Exception {
        update("dlgn0110DAO.updateDlgn0210GridDlgn0110", vo);
    }
    
    //기준일 후 로직
    @SuppressWarnings("rawtypes")
	public List selectDlgn0100List(Dlgn0110SrhVO dlgn0110SrhVo) throws Exception{
		return list("dlgn0110DAO.selectDlgn0100List", dlgn0110SrhVo);
	}
    //기준일 전 로직
    @SuppressWarnings("rawtypes")
	public List selectDlgn0100List_1(Dlgn0110SrhVO dlgn0110SrhVo) throws Exception{
		return list("dlgn0110DAO.selectDlgn0100List_1", dlgn0110SrhVo);
	}
	
	  
	  /**
	   * DLGN0100 총 갯수를 조회한다.
	   * @param searchMap - 조회할 정보가 담긴 Map
	   * @return DLGN0100 총 갯수
	   * @exception
	   */
	  public int selectDlgn0100ListTotCnt(Dlgn0110SrhVO searchVO) {
	      return (Integer)getSqlMapClientTemplate().queryForObject("dlgn0110DAO.selectDlgn0100ListTotCnt", searchVO);
	  }
	  
   public void updateDlgn0100ToDlgn0110(Dlgn0110DTO dto) throws Exception {
        update("dlgn0110DAO.updateDlgn0100ToDlgn0110", dto);
    }	
   
   public void updateDlgn0100ToDlgn0110Pre(Dlgn0110DTO dto) throws Exception {
       update("dlgn0110DAO.updateDlgn0100ToDlgn0110Pre", dto);
   }	
    
}
