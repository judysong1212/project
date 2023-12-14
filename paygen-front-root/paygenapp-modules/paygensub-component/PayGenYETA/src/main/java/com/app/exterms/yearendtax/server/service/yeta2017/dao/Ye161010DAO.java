package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.InfcPsnl0100SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye161010SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye161010VO;
import com.app.exterms.yearendtax.server.vo.Yeta2000SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta2000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161010DAO.java
 * @Description : Ye161010 DAO Class
 * @Modification Information
 *
 * @author DaEun, Bae
 * @since 2017.01.04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye161010DAO")
public class Ye161010DAO extends EgovAbstractDAO {
	
	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
    /**
     * YE161010 목록을 조회한다.
     * @param searcVO - 조회할 정보가 담긴 searcVO
     * @return YE161010 목록
     * @exception Exception
     */
    public List selectYeta2300ToYe161010List(Ye161010SrhVO ye161010SrhVo) throws Exception {
    	return list("ye161010DAO.selectYeta2300ToYe161010List_D", ye161010SrhVo);
    }
    
    public List selectYetaP210002ToYe161010List(Ye161010SrhVO ye161010SrhVo) throws Exception {
    	return list("ye161010DAO.selectYetaP210002ToYe161010List_D", ye161010SrhVo);
    }
    
    

    /**
     * YE161010 총 갯수를 조회한다..
     * @param searcVO - 조회할 정보가 담긴 searcVO
     * @return YE161010  총 갯수
     * @exception
     */
    public int selectYeta2300ToYe161010ListTotCnt(Ye161010SrhVO ye161010SrhVo) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("ye161010DAO.selectYeta2300ToYe161010ListTotCnt_S", ye161010SrhVo);
    }	
    
    public int selectYeta2060ToYe161010ListTotCnt(Ye161010SrhVO ye161010SrhVo) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("ye161010DAO.selectYeta2060ToYe161010ListTotCnt_S", ye161010SrhVo);
    }	
    
    public int selectYetaP210002ToYe161010ListTotCnt(Ye161010SrhVO ye161010SrhVo) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("ye161010DAO.selectYetaP210002ToYe161010ListTotCnt_S", ye161010SrhVo);
    }	
    
    
    
    /**
     * 단위사업장 맵핑
     **/
    public void updateYetaP210002ToYe161010(Ye161010VO vo) throws Exception {
        update("ye161010DAO.updateYetaP210002ToYe161010_S", vo);
    }
	
	
	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 종료
	 * #############################################
	 * **/
	
    /***********************************************************************************
     * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
     ***********************************************************************************/
       
      /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/      
    public void deleteYetaP210001_Ye161010VO_2017_Delete(Ye161010VO vo) throws Exception {
        delete("ye161010DAO.deleteYetaP210001_Ye161010VO_2017_Delete_S", vo);
    }
    
    
    
     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
      ***********************************************************************************/
    
    

	/**
	 * YE161010???�록?�다.
	 * @param vo - ?�록???�보�??�긴 Ye161010VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertYe161010(Ye161010VO vo) throws Exception {
        return (String)insert("ye161010DAO.insertYe161010_S", vo);
    }

    /**
	 * YE161010???�정?�다.
	 * @param vo - ?�정???�보�??�긴 Ye161010VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe161010(Ye161010VO vo) throws Exception {
        update("ye161010DAO.updateYe161010_S", vo);
    }

    /**
	 * YE161010????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye161010VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe161010(Ye161010VO vo) throws Exception {
        delete("ye161010DAO.deleteYe161010_S", vo);
    }
    
    /**
	 * YE161010????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye161010VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYeta2100ToYe161010(Ye161010VO vo) throws Exception {
        delete("ye161010DAO.deleteYe161010_S", vo);
    }

//    /**
//	 * YE161010??조회?�다.
//	 * @param vo - 조회???�보�??�긴 Ye161010VO
//	 * @return 조회??YE161010
//	 * @exception Exception
//	 */
//    public Ye161010VO selectYe161010(Ye161010VO vo) throws Exception {
//        return (Ye161010VO) select("ye161010DAO.selectYe161010_S", vo);
//    }

    
    
	/**
	 * YE161010 목록??조회?�다.
	 * @param searchMap - 조회???�보�??�긴 Map
	 * @return YE161010 목록
	 * @exception Exception
	 */
	public List<?> selectYe161010List(Ye161010SrhVO searchVO) throws Exception {
		return list("ye161010DAO.selectYe161010List_D", searchVO);
	}


	/**
	 * YE161010 �?�?���?조회?�다.
	 * @param searchMap - 조회???�보�??�긴 Map
	 * @return YE161010 �?�?��
	 * @exception
	 */
    public int selectYe161010ListTotCnt(Ye161010SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye161010DAO.selectYe161010ListTotCnt_S", searchVO);
    }
    
    /**
     * YE161010 목록??조회?�다.
     * @param searchMap - 조회???�보�??�긴 Map
     * @return YE161010 목록
     * @exception Exception
     */
    public List<?> selectYe161010ResultList(Ye161010SrhVO searchVO) throws Exception {
    	return list("ye161010DAO.selectYeta2200ResultList_D", searchVO);
    }
    
    
    /**
     * YE161010 �?�?���?조회?�다.
     * @param searchMap - 조회???�보�??�긴 Map
     * @return YE161010 �?�?��
     * @exception
     */
    public int selectYe161010ResultListTotCnt(Ye161010SrhVO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("ye161010DAO.selectYeta2200ResultListCnt_S", searchVO);
    }
    
    /**
     * YETA210001 목록을 조회한다.
     * @param searcVO - 조회할 정보가 담긴 searcVO
     * @return YETA210001 목록
     * @exception Exception
     */
    public List selectYetaP210001ToPsnl0100List(InfcPsnl0100SrhVO   psnl0100SrhVO) throws Exception {
    	return list("ye161010DAO.selectYetaP21001ToPsnl0100List_D", psnl0100SrhVO);
    }

    /**
     * YETA210001 총 갯수를 조회한다..
     * @param searcVO - 조회할 정보가 담긴 searcVO
     * @return YETA210001  총 갯수
     * @exception
     */
    public int selectYetaP210001ToPsnl0100ListTotCnt(InfcPsnl0100SrhVO   psnl0100SrhVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("ye161010DAO.selectP21001ToPsnl0100ListCnt_S", psnl0100SrhVO);
    }
    
    public List<Ye161010VO> selectYeta2300ToYe161010AllList(Ye161010SrhVO  ye161010SrhVo) throws Exception {
    	return list("ye161010DAO.selectYeta2300ToYe161010AllList_D", ye161010SrhVo);
    }
    
    
    /**
	 * YETA2000 총 갯수를 조회한다..(연말정산신고내역) YETA0400.JAVA
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 총 갯수
	 * @exception
	 */
    public int selectYeta2400GirdListTotCnt(Ye161010SrhVO ye161010SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye161010DAO.selectYeta0400GirdListTotCnt_S", ye161010SrhVo);
    }
    
    /**
	 * YETA2000 목록을 조회한다.(연말정산신고내역) YETA0400.JAVA
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 목록
	 * @exception Exception
	 */
    public List selectYeta2400GirdList(Ye161010SrhVO ye161010SrhVo) throws Exception {
        return list("ye161010DAO.selectYeta0400GridToList_D", ye161010SrhVo);
    }
    
    
    /**
	 * YETA2000 총 갯수를 조회한다.(연말정산신고내역) YETA0500.JAVA
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 총 갯수
	 * @exception
	 */
    public int selectYeta0500GirdListTotCnt(Ye161010SrhVO ye161010SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye161010DAO.selectYeta0500GirdListTotCnt_S", ye161010SrhVo);
    }
    
    /**
	 * YETA2000 목록을 조회한다.(연말정산신고내역) YETA0500.JAVA
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 목록
	 * @exception Exception
	 */
    public List selectYeta0500GirdList(Ye161010SrhVO ye161010SrhVo) throws Exception {
        return list("ye161010DAO.selectYeta0500GridToList_D", ye161010SrhVo);
    }
    
    

	
	/** 마감처리할 대상자 리스트를 가져온다. **/
    public List selectFinYe161010List(Ye161010VO ye161010Vo) throws Exception {
        // TODO Auto-generated method stub
        return  list("ye161010DAO.selectFinYeta2000List", ye161010Vo);
    }
    /**
	 * 연말정산 마감 처리를 한다.
	 */
    @Transactional
    public void finishYeta2400Update(Ye161010VO ye161010Vo) throws Exception {
        update("ye161010DAO.finishYeta2000Update_S", ye161010Vo);
    }
	 
	   public List selectYeta2400ToYeta2000XlsList(Ye161010SrhVO ye161010SrhVo) throws Exception {
	        return list("ye161010DAO.selectYeta0400ToYeta2000XlsList", ye161010SrhVo);
	    }
	   
	    /**
		 * yeta0500 화면에서 대상자 내역을 조회하여 엑셀로 출력한다.
		 * @param searchMap - 조회할 정보가 담긴 Map
		 * @return YETA2000 목록
		 * @exception Exception
		 */
	    public List selectYeta2500ToYeta2000XlsList(Ye161010SrhVO ye161010SrhVo) throws Exception {
	        return list("ye161010DAO.selectYeta0500ToYeta2000XlsList", ye161010SrhVo);
	    }
	    
	    /**
		 * YETA2000 목록을 수정한다.(연말정산급여반영 - 당월급여반영) YETA0500.JAVA
		 * @param vo - 조회할 정보가 담긴 Yeta2000VO
		 * @return YETA2000 목록
		 * @exception Exception
		 */
	    @Transactional
	    public void activityOnYeta0500Update(Ye161010VO ye161010Vo) throws Exception {
	    	update("ye161010DAO.activityOnYeta0500Update", ye161010Vo);
	    }
	    
	    /**
		 * YETA2000을 수정한다.(연말정산급여반영 - 저장) YETA0500.JAVA
		 * @param vo - 수정할 정보가 담긴 Yeta2000VO
		 * @return void형
		 * @exception Exception
		 * 분할납부횟수 수정 불가
		 */
	    @Transactional
	    public void saveYeta0500Ye161010_Y(Ye161010VO ye161010Vo) throws Exception {
	    	update("ye161010DAO.updateYeta0500To2000_Y", ye161010Vo);
	    }
	    
	    /**
		 * YETA2000을 수정한다.(연말정산급여반영 - 저장) YETA0500.JAVA
		 * @param vo - 수정할 정보가 담긴 Yeta2000VO
		 * @return void형
		 * @exception Exception
		 * 분할납부횟수 수정 가능
		 */
	    @Transactional
	    public void saveYeta0500Ye161010_N(Ye161010VO ye161010Vo) throws Exception {
	    	update("ye161010DAO.updateYeta0500To2000_N", ye161010Vo);
	    }
	    

}
