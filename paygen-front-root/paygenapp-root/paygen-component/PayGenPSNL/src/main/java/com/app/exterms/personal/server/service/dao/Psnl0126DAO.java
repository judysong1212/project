package com.app.exterms.personal.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.client.dto.Psnl0126DTO;
import com.app.exterms.personal.server.vo.Psnl0126DefaultVO;
import com.app.exterms.personal.server.vo.Psnl0126SrhVO;
import com.app.exterms.personal.server.vo.Psnl0126VO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0126VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0126DAO.java
 * @Description : Psnl0126 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0126DAO")
public class Psnl0126DAO extends EgovAbstractDAO  implements IsSerializable {
	
	/**
	 * PSNL0126 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0126 목록
	 * @exception Exception
	 */
    public List selectPsnl0126List(Psnl0126SrhVO searchVO) throws Exception {
        return list("psnl0126DAO.selectPsnl0126List_P", searchVO);
    }

    /**
	 * PSNL0126 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0126 총 갯수
	 */
    public int selectPsnl0126ListTotCnt(Psnl0126SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0126DAO.selectPsnl0126ListTotCnt_S", searchVO);
    }
    

	/**
	 * PSNL0126을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0126VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPsnl0126(Psnl0126VO vo) throws Exception {
        return (String)insert("psnl0126DAO.insertPsnl0126_S", vo);
    }
    
    
  /**
	 * PSNL0126을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0126VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePsnl0126(Psnl0126VO vo) throws Exception {
        update("psnl0126DAO.updatePsnl0126_S", vo);
    }
    
    public void updatePsnl0126_hodyNumDysSysCalc(Psnl0126VO vo) throws Exception {
        update("psnl0126DAO.updatePsnl0126_hodyNumDysSysCalc", vo);
    }

   /**
	 * PSNL0126을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0126VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePsnl0126(Psnl0126VO vo) throws Exception {
        delete("psnl0126DAO.deletePsnl0126_S", vo);
    }
    
    
    /**
     * 휴가일수산정 엑셀 생성 데이터
     * @param psnl0126SrhVO
     * @return
     * @throws Exception
     */
	public List selectXlsFilePsnl0126List(Psnl0126SrhVO psnl0126SrhVO) throws Exception {
        return list("psnl0126DAO.selectXlsFilePsnl0126List_D", psnl0126SrhVO); 
    }
	/**
	 * 엑셀양식저장
	 * */
	public List selectXlsTmpPsnl0126List(Psnl0126SrhVO psnl0126SrhVO) throws Exception {
        return list("psnl0126DAO.selectXlsTmpPsnl0126List_D", psnl0126SrhVO); 
    }
    
	/**
	 * PSNL0126 휴가일수산정 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0126 목록
	 * @exception Exception
	 */
    public List selectPsnl0126HolidayCount(Psnl0126SrhVO searchVO) throws Exception {
        return list("psnl0126DAO.selectPsnl0126HolidayCountList", searchVO);
    }
    
    
	/**
	 * PSNL0126 엑실파일 업로드(삭제)
	 * @param searchMap - 삭제할 정보가 담긴 Map
	 * @exception Exception
	 */
    public int deleteXlsPsnl0126(Psnl0126VO vo) throws Exception{
		return delete("psnl0126DAO.deleteXlsPsnl0126_S",vo);
		
	}
    
	/**
	 * PSNL0126 엑실파일 업로드(입력)
	 * @param searchMap - 입력할 정보가 담긴 Map
	 * @exception Exception
	 */
    public String insertXlsPsnl0126(Psnl0126VO vo) throws Exception{
		return (String)insert("psnl0126DAO.insertXlsPsnl0126_S",vo);
		
	}

//    /**
//	 * PSNL0126을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Psnl0126VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    @Transactional
//    public void updatePsnl0126(InfcPsnl0126VO vo) throws Exception {
//        update("psnl0126DAO.updatePsnl0126_S", vo);
//    }
//
//    /**
//	 * PSNL0126을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Psnl0126VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    @Transactional
//    public void deletePsnl0126(InfcPsnl0126VO vo) throws Exception {
//        delete("psnl0126DAO.deletePsnl0126_S", vo);
//    }

    /**
	 * PSNL0126을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0126VO
	 * @return 조회한 PSNL0126
	 * @exception Exception
	 */
    public InfcPkgPsnl0126VO selectPsnl0126(InfcPkgPsnl0126VO vo) throws Exception {
        return (InfcPkgPsnl0126VO) selectByPk("psnl0126DAO.selectPsnl0126_S", vo);
    }
    
    /**
	 * PSNL0126 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0126 목록
	 * @exception Exception
	 */
    public List selectPsnl0126List(Psnl0126DefaultVO searchVO) throws Exception {
        return list("psnl0126DAO.selectPsnl0126List_D", searchVO);
    }

    /**
	 * PSNL0126 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0126 총 갯수
	 * @exception
	 */
    public int selectPsnl0126ListTotCnt(Psnl0126DefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0126DAO.selectPsnl0126ListTotCnt_S", searchVO);
    }
    
    public List selectPsnl0126HolidayCountPsnlP029001(Psnl0126SrhVO searchVO) throws Exception {
        return list("psnl0126DAO.selectPsnlP029001HolidayCountList", searchVO);
    }

	public void updatePsnlP029001ToPsnl0126_hodyNumDysSysCalc(Psnl0126DTO returnPsnl0126Dto)throws Exception {
		update("psnl0126DAO.updatePsnlP029001ToPsnl0126_hodyNumDysSysCalc", returnPsnl0126Dto);
		
	}
	
	public List selectPsnl0126HolidayCountPsnlP029002(Psnl0126VO VO) throws Exception {
        return list("psnl0126DAO.selectPsnlP029002HolidayCountList", VO);
    }

	public void updatePsnlP029002ToPsnl0126_hodyNumDysSysCalc(Psnl0126DTO returnPsnl0126Dto)throws Exception {
		update("psnl0126DAO.updatePsnlP029001ToPsnl0126_hodyNumDysSysCalc", returnPsnl0126Dto);
		
	}

	public List selectPsnl0126ToPsnlP029002ExlDataListChk(Psnl0126VO psnl0126Vo) throws Exception  {
		return list("psnl0126DAO.selectPsnl0126ToPsnlP029002ExlDataListChk", psnl0126Vo);
	}
	
	/**
	 * PSNL0126 엑실파일 업로드(삭제)
	 * @param searchMap - 삭제할 정보가 담긴 Map
	 * @exception Exception
	 */
    public int deleteXlsPsnlP029002(Psnl0126VO vo) throws Exception{
		return delete("psnl0126DAO.deleteXlsPsnlP029002_S",vo);
		
	}
    
	/**
	 * PSNL0126 엑실파일 업로드(입력)
	 * @param searchMap - 입력할 정보가 담긴 Map
	 * @exception Exception
	 */
    public String insertXlsPsnlP029002(Psnl0126VO vo) throws Exception{
		return (String)insert("psnl0126DAO.insertXlsPsnlP029002_S",vo);
		
	}

}
