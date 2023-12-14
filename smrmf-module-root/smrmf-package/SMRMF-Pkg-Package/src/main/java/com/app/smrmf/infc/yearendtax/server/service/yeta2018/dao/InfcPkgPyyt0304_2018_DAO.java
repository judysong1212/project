package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPyyt0304Srh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPyyt0304_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : Pyyt0304_2018_DAO.java
 * @Description : Pyyt0304 DAO Class
 * @Modification Information
 *
 * @author BaeDaEun
 * @since 2016.12.20
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPyyt0304_2018_DAO")
public class InfcPkgPyyt0304_2018_DAO extends EgovAbstractDAO {



	
	/**
	 * PYYT0304???�록?�다.
	 * @param vo - ?�록???�보�??�긴 Pyyt0304VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertPyyt0304(InfcPkgPyyt0304_2018_VO vo) throws Exception {
        return (String)insert("infcPkgPyyt0304_2018_DAO.insertPyyt0304", vo);
    }
	
	
    /**
	 * PYYT0304을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Pyyt0304VO 
	 * @return void??
	 * @exception Exception
	 * PAYR0302수정에 대한 마스터 업데이트부
	 */
    public void updatePyyt0304(InfcPkgPyyt0304_2018_VO vo) throws Exception {
        update("infcPkgPyyt0304_2018_DAO.updatePyyt0304", vo);
    }

    /**
	 * PYYT0304????��?�다.
	 * @param vo - ??��???�보�??�긴 Pyyt0304VO
	 * @return void??
	 * @exception Exception
	 */
    public void deletePyyt0304(InfcPkgPyyt0304_2018_VO vo) throws Exception {
        delete("infcPkgPyyt0304_2018_DAO.deletePyyt0304_S", vo);
    }
    
    //
//  /**
//	 * PYYT0304???�정?�다.
//	 * @param vo - ?�정???�보�??�긴 Pyyt0304VO
//	 * @return void??
//	 * @exception Exception
//	 */
//  public void updatePyyt0304(Pyyt0304_2018_VO vo) throws Exception {
//      update("infcPkgPyyt0304_2018_DAO.updatePyyt0304_S", vo);
//  }    
    
//
//    /**
//	 * PYYT0304??조회?�다.
//	 * @param vo - 조회???�보�??�긴 Pyyt0304VO
//	 * @return 조회??PYYT0304
//	 * @exception Exception
//	 */
//    public Pyyt0304VO selectPyyt0304(Pyyt0304_2018_VO vo) throws Exception {
//        return (Pyyt0304VO) select("infcPkgPyyt0304_2018_DAO.selectPyyt0304_S", vo);
//    }
//
    /**
	 * PYYT0304 목록을 조회한다.
	 * @param searcVO - 조회할 정보가 담긴 searcVO
	 * @return PYYT0304 목록
	 * @exception Exception
	 */
    public List selectPyyt0304List(InfcPkgPyyt0304Srh_2018_VO searchVO) throws Exception {
        return list("infcPkgPyyt0304_2018_DAO.selectPyyt0304List_D", searchVO);
    }

    /**
	 * PYYT0304 총 갯수를 조회한다..
	 * @param searcVO - 조회할 정보가 담긴 searcVO
	 * @return PYYT0304  총 갯수
	 * @exception
	 */
    public int selectPyyt0304ListTotCnt(InfcPkgPyyt0304Srh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPyyt0304_2018_DAO.selectPyyt0304ListTotCnt_S", searchVO);
    }
    
    
    /**
	 * PYYT0304 총 갯수를 조회한다. ( 데이터 존재 여부 확인)
	 * @param searcVO - 조회할 정보가 담긴 searcVO
	 * @return PYYT0304  총 갯수
	 * @exception
	 */
    public int selectPyyt0304Check(InfcPkgPyyt0304Srh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPyyt0304_2018_DAO.selectPyyt0304ListTotCnt", searchVO);
    }
    
    
    
    
    
    
    
    
    
    /** 급여대장 (기간제)**/
//    @SuppressWarnings("rawtypes")
//    public EgovMap selectPyyt0302XlsList1(Pyyt0304SrhVO infcPkgPyyt0304SrhVo) {
//        return (EgovMap) selectByPk("infcPkgPyyt0304_2018_DAO.selectPyyt0302XlsList1", infcPkgPyyt0304SrhVo);
//    } 
    

    
	/**
     * 급여대장 (무기계약직)
     * @param InfcPkgPyyt0304SrhVO
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public List<InfcPkgPyyt0304_2018_VO> selectXlsYeta1900ToPyyt0304List01(InfcPkgPyyt0304Srh_2018_VO   infcPkgPyyt0304SrhVo ) {
        return (List<InfcPkgPyyt0304_2018_VO>)list("infcPkgPyyt0304_2018_DAO.selectXlsYeta1900ToPyyt0304List01", infcPkgPyyt0304SrhVo);
    }
    
    
	/**
     * 급여대장 (기간제근로자)
     * @param InfcPkgPyyt0304SrhVO
     * @return
     * @throws Exception
     */  
    @SuppressWarnings("rawtypes")
    public List<EgovMap> selectXlsYeta1900ToPyyt0304List02(InfcPkgPyyt0304Srh_2018_VO infcPkgPyyt0304SrhVo) {
        return (List<EgovMap>)list("infcPkgPyyt0304_2018_DAO.selectXlsYeta1900ToPyyt0304List02", infcPkgPyyt0304SrhVo);
    }
    
    

}
