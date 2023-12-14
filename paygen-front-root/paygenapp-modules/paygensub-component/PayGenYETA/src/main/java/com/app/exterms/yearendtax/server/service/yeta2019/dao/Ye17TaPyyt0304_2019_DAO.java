package com.app.exterms.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Pyyt0304Srh_2019_VO;
import com.app.exterms.yearendtax.server.vo.Pyyt0304_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : ye17TaPyyt0304_2019_DAO.java
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

@Repository("Ye17TaPyyt0304_2019_DAO")
public class Ye17TaPyyt0304_2019_DAO extends EgovAbstractDAO {



	
	/**
	 * PYYT0304???�록?�다.
	 * @param vo - ?�록???�보�??�긴 Pyyt0304VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertPyyt0304(Pyyt0304_2019_VO vo) throws Exception {
        return (String)insert("ye17TaPyyt0304_2019_DAO.insertPyyt0304", vo);
    }
	
	
    /**
	 * PYYT0304을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Pyyt0304VO 
	 * @return void??
	 * @exception Exception
	 * PAYR0302수정에 대한 마스터 업데이트부
	 */
    public void updatePyyt0304(Pyyt0304_2019_VO vo) throws Exception {
        update("ye17TaPyyt0304_2019_DAO.updatePyyt0304", vo);
    }

    /**
	 * PYYT0304????��?�다.
	 * @param vo - ??��???�보�??�긴 Pyyt0304VO
	 * @return void??
	 * @exception Exception
	 */
    public void deletePyyt0304(Pyyt0304_2019_VO vo) throws Exception {
        delete("ye17TaPyyt0304_2019_DAO.deletePyyt0304_S", vo);
    }
    
    //
//  /**
//	 * PYYT0304???�정?�다.
//	 * @param vo - ?�정???�보�??�긴 Pyyt0304VO
//	 * @return void??
//	 * @exception Exception
//	 */
//  public void updatePyyt0304(Pyyt0304VO vo) throws Exception {
//      update("ye17TaPyyt0304_2019_DAO.updatePyyt0304_S", vo);
//  }    
    
//
//    /**
//	 * PYYT0304??조회?�다.
//	 * @param vo - 조회???�보�??�긴 Pyyt0304VO
//	 * @return 조회??PYYT0304
//	 * @exception Exception
//	 */
//    public Pyyt0304VO selectPyyt0304(Pyyt0304VO vo) throws Exception {
//        return (Pyyt0304VO) select("ye17TaPyyt0304_2019_DAO.selectPyyt0304_S", vo);
//    }
//
    /**
	 * PYYT0304 목록을 조회한다.
	 * @param searcVO - 조회할 정보가 담긴 searcVO
	 * @return PYYT0304 목록
	 * @exception Exception
	 */
    public List selectPyyt0304List(Pyyt0304Srh_2019_VO searchVO) throws Exception {
        return list("ye17TaPyyt0304_2019_DAO.selectPyyt0304List_D", searchVO);
    }

    /**
	 * PYYT0304 총 갯수를 조회한다..
	 * @param searcVO - 조회할 정보가 담긴 searcVO
	 * @return PYYT0304  총 갯수
	 * @exception
	 */
    public int selectPyyt0304ListTotCnt(Pyyt0304Srh_2019_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye17TaPyyt0304_2019_DAO.selectPyyt0304ListTotCnt_S", searchVO);
    }
    
    
    /**
	 * PYYT0304 총 갯수를 조회한다. ( 데이터 존재 여부 확인)
	 * @param searcVO - 조회할 정보가 담긴 searcVO
	 * @return PYYT0304  총 갯수
	 * @exception
	 */
    public int selectPyyt0304Check(Pyyt0304Srh_2019_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye17TaPyyt0304_2019_DAO.selectPyyt0304ListTotCnt", searchVO);
    }
    
    
    
    
    
    
    
    
    
    /** 급여대장 (기간제)**/
//    @SuppressWarnings("rawtypes")
//    public EgovMap selectPyyt0302XlsList1(Pyyt0304SrhVO pyyt0304SrhVo) {
//        return (EgovMap) selectByPk("ye17TaPyyt0304_2019_DAO.selectPyyt0302XlsList1", pyyt0304SrhVo);
//    } 
    

    
	/**
     * 급여대장 (공무직)
     * @param Pyyt0304SrhVO
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public List<Pyyt0304_2019_VO> selectXlsYeta1900ToPyyt0304List01(Pyyt0304Srh_2019_VO   pyyt0304SrhVo ) {
        return (List<Pyyt0304_2019_VO>)list("ye17TaPyyt0304_2019_DAO.selectXlsYeta4900ToPyyt0304List01", pyyt0304SrhVo);
    }
    
    
	/**
     * 급여대장 (기간제근로자)
     * @param Pyyt0304SrhVO
     * @return
     * @throws Exception
     */  
    @SuppressWarnings("rawtypes")
    public List<EgovMap> selectXlsYeta1900ToPyyt0304List02(Pyyt0304Srh_2019_VO pyyt0304SrhVo) {
        return (List<EgovMap>)list("ye17TaPyyt0304_2019_DAO.selectXlsYeta4900ToPyyt0304List02", pyyt0304SrhVo);
    }
    
    

}
