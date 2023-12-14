package com.app.exterms.diligence.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.diligence.client.dto.Dlgn0110DTO;
import com.app.exterms.diligence.server.vo.Dlgn0110ExlVO;
import com.app.exterms.diligence.server.vo.Dlgn0210ExlVO;
import com.app.exterms.diligence.server.vo.Dlgn0210SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0210VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Dlgn0210DAO.java
 * @Description : Dlgn0210 DAO Class
 * @Modification Information
 *
 * @author admin
 * @since 2016.07.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("dlgn0210DAO")
public class Dlgn0210DAO extends EgovAbstractDAO {

	/**
	 * DLGN0210을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Dlgn0210VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertDlgn0210(Dlgn0210VO vo) throws Exception {
        return (String)insert("dlgn0210DAO.insertDlgn0210_S", vo);
    }

    /**
	 * DLGN0210을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Dlgn0210VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateDlgn0210(Dlgn0210VO vo) throws Exception {
        update("dlgn0210DAO.updateDlgn0210_S", vo);
    }

    /**
	 * DLGN0210을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Dlgn0210VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteDlgn0210(Dlgn0210VO vo) throws Exception {
        delete("dlgn0210DAO.deleteDlgn0210_S", vo);
    }

    /**
	 * DLGN0210을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Dlgn0210VO
	 * @return 조회한 DLGN0210
	 * @exception Exception
	 */
    public Dlgn0210VO selectDlgn0210(Dlgn0210VO vo) throws Exception {
        return (Dlgn0210VO) selectByPk("dlgn0210DAO.selectDlgn0210_S", vo);
    }

    /**
	 * DLGN0210 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return DLGN0210 목록
	 * @exception Exception
	 */
    public List<?> selectDlgn0210List(Dlgn0210SrhVO searchVO) throws Exception {
        return list("dlgn0210DAO.selectDlgn0210List_D", searchVO);
    }

    /**
	 * DLGN0210 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return DLGN0210 총 갯수
	 * @exception
	 */
    public int selectDlgn0210ListTotCnt(Dlgn0210SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("dlgn0210DAO.selectDlgn0210ListTotCnt_S", searchVO);
    }
    //2017.04.06 : kim ji eun
    public void updateDlgn0100Todlgn0210Tm(Dlgn0110DTO dto) throws Exception {
        update("dlgn0210DAO.updateDlgn0100Todlgn0210Tm", dto);
    }
    
	  /**
	   * DLGN0200 총 갯수를 조회한다.
	   * @param searchMap - 조회할 정보가 담긴 Map
	   * @return DLGN0200 총 갯수
	   * @exception
	   */
	  public int selectDlgn0200ListTotCnt(Dlgn0210SrhVO searchVO) {
	      return (Integer)getSqlMapClientTemplate().queryForObject("dlgn0210DAO.selectDlgn0200ListTotCnt", searchVO);
	  }
	  
	@SuppressWarnings("rawtypes")
	public List selectDlgn0200List(Dlgn0210SrhVO dlgn0210SrhVo) throws Exception{
		return list("dlgn0210DAO.selectDlgn0200List", dlgn0210SrhVo);
	}
	
    public void updateDlgn0210Grid_02(Dlgn0210VO vo) throws Exception {
        update("dlgn0210DAO.updateDlgn0210Grid_02", vo);
    }
    
    public void updateDlgn0210Grid_Yn(Dlgn0210VO vo) throws Exception {
        update("dlgn0210DAO.updateDlgn0210Grid_Yn", vo);
    }
    
    /**
	 * 기본근무관리 엑셀 업로드시 DLGN0210을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Dlgn0210VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateXlsDlgn0100ToDlgn0210_1(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_1", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_2(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_2", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_3(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_3", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_4(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_4", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_5(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_5", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_6(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_6", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_7(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_7", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_8(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_8", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_9(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_9", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_10(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_10", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_11(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_11", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_12(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_12", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_13(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_13", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_14(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_14", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_15(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_15", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_16(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_16", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_17(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_17", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_18(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_18", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_19(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_19", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_20(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_20", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_21(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_21", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_22(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_22", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_23(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_23", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_24(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_24", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_25(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_25", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_26(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_26", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_27(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_27", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_28(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_28", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_29(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_29", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_30(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_30", vo);
    }
    
    public void updateXlsDlgn0100ToDlgn0210_31(Dlgn0110ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0100ToDlgn0210_31", vo);
    }
    
    /**
	 * 시간외근무관리 엑셀 업로드시 DLGN0210을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Dlgn0210ExlVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateXlsDlgn0200ToDlgn0210Yn(Dlgn0210ExlVO vo) throws Exception {
        update("dlgn0210DAO.updateXlsDlgn0200ToDlgn0210Yn", vo);
    }
    
	/** 시간외근무관리 엑셀 업로드시 DLGN0210을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Dlgn0210ExlVO
	 * @return void형
	 * @exception Exception
	 */
   public void updateXlsDlgn0200ToDlgn0210(Dlgn0210ExlVO vo) throws Exception {
       update("dlgn0210DAO.updateXlsDlgn0200ToDlgn0210", vo);
   }

}
