package com.app.exterms.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.InfcPsnl0100Srh_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye161010_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161010_2019_DAO.java
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

@Repository("Ye161010_2019_DAO")
public class Ye161010_2019_DAO extends EgovAbstractDAO {
	
	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
    /**
     * YE161010 목록을 조회한다.
     * @param searc_2019_VO - 조회할 정보가 담긴 searc_2019_VO
     * @return YE161010 목록
     * @exception Exception
     */
    public List selectYeta4300ToYe161010List(Ye161010Srh_2019_VO ye161010SrhVo) throws Exception {
    	return list("ye161010_2019_DAO.selectYeta4300ToYe161010List_D", ye161010SrhVo);
    }
    
    public List selectYetaP410002ToYe161010List(Ye161010Srh_2019_VO ye161010SrhVo) throws Exception {
    	return list("ye161010_2019_DAO.selectYetaP410002ToYe161010List_D", ye161010SrhVo);
    }
    
    

    /**
     * YE161010 총 갯수를 조회한다..
     * @param searc_2019_VO - 조회할 정보가 담긴 searc_2019_VO
     * @return YE161010  총 갯수
     * @exception
     */
    public int selectYeta4300ToYe161010ListTotCnt(Ye161010Srh_2019_VO ye161010SrhVo) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("ye161010_2019_DAO.selectYeta4300ToYe161010ListTotCnt_S", ye161010SrhVo);
    }	
    
    public int selectYeta4060ToYe161010ListTotCnt(Ye161010Srh_2019_VO ye161010SrhVo) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("ye161010_2019_DAO.selectYeta4060ToYe161010ListTotCnt_S", ye161010SrhVo);
    }	
    
    public int selectYetaP410002ToYe161010ListTotCnt(Ye161010Srh_2019_VO ye161010SrhVo) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("ye161010_2019_DAO.selectYetaP410002ToYe161010ListTotCnt_S", ye161010SrhVo);
    }	
    
    
    
    /**
     * 단위사업장 맵핑
     **/
    public void updateYetaP410002ToYe161010(Ye161010_2019_VO vo) throws Exception {
        update("ye161010_2019_DAO.updateYetaP410002ToYe161010_S", vo);
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
    public void deleteYetaP410001_Ye161010VO_2019_Delete(Ye161010_2019_VO vo) throws Exception {
        delete("ye161010_2019_DAO.deleteYetaP410001_Ye161010VO_2019_Delete_S", vo);
    }
    
    
    
     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
      ***********************************************************************************/
    
    

	/**
	 * YE161010???�록?�다.
	 * @param vo - ?�록???�보�??�긴 Ye161010_2019_VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertYe161010(Ye161010_2019_VO vo) throws Exception {
        return (String)insert("ye161010_2019_DAO.insertYe161010_S", vo);
    }

    /**
	 * YE161010???�정?�다.
	 * @param vo - ?�정???�보�??�긴 Ye161010_2019_VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe161010(Ye161010_2019_VO vo) throws Exception {
        update("ye161010_2019_DAO.updateYe161010_S", vo);
    }

    /**
	 * YE161010????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye161010_2019_VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe161010(Ye161010_2019_VO vo) throws Exception {
        delete("ye161010_2019_DAO.deleteYe161010_S", vo);
    }
    
    /**
	 * YE161010????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye161010_2019_VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYeta4100ToYe161010(Ye161010_2019_VO vo) throws Exception {
        delete("ye161010_2019_DAO.deleteYe161010_S", vo);
    }

//    /**
//	 * YE161010??조회?�다.
//	 * @param vo - 조회???�보�??�긴 Ye161010_2019_VO
//	 * @return 조회??YE161010
//	 * @exception Exception
//	 */
//    public Ye161010_2019_VO selectYe161010(Ye161010_2019_VO vo) throws Exception {
//        return (Ye161010_2019_VO) select("ye161010_2019_DAO.selectYe161010_S", vo);
//    }

    
    
	/**
	 * YE161010 목록??조회?�다.
	 * @param searchMap - 조회???�보�??�긴 Map
	 * @return YE161010 목록
	 * @exception Exception
	 */
	public List<?> selectYe161010List(Ye161010Srh_2019_VO search_2019_VO) throws Exception {
		return list("ye161010_2019_DAO.selectYe161010List_D", search_2019_VO);
	}


	/**
	 * YE161010 �?�?���?조회?�다.
	 * @param searchMap - 조회???�보�??�긴 Map
	 * @return YE161010 �?�?��
	 * @exception
	 */
    public int selectYe161010ListTotCnt(Ye161010Srh_2019_VO search_2019_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye161010_2019_DAO.selectYe161010ListTotCnt_S", search_2019_VO);
    }
    
    /**
     * YE161010 목록??조회?�다.
     * @param searchMap - 조회???�보�??�긴 Map
     * @return YE161010 목록
     * @exception Exception
     */
    public List<?> selectYe161010ResultList(Ye161010Srh_2019_VO search_2019_VO) throws Exception {
    	return list("ye161010_2019_DAO.selectYeta4200ResultList_D", search_2019_VO);
    }
    
    
    /**
     * YE161010 �?�?���?조회?�다.
     * @param searchMap - 조회???�보�??�긴 Map
     * @return YE161010 �?�?��
     * @exception
     */
    public int selectYe161010ResultListTotCnt(Ye161010Srh_2019_VO search_2019_VO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("ye161010_2019_DAO.selectYeta4200ResultListCnt_S", search_2019_VO);
    }
    
    /**
     * YETA210001 목록을 조회한다.
     * @param searc_2019_VO - 조회할 정보가 담긴 searc_2019_VO
     * @return YETA210001 목록
     * @exception Exception
     */
    public List selectYetaP410001ToPsnl0100List(InfcPsnl0100Srh_2019_VO   psnl0100Srh_2019_VO) throws Exception {
    	return list("ye161010_2019_DAO.selectYetaP41001ToPsnl0100List_D", psnl0100Srh_2019_VO);
    }

    /**
     * YETA210001 총 갯수를 조회한다..
     * @param searc_2019_VO - 조회할 정보가 담긴 searc_2019_VO
     * @return YETA210001  총 갯수
     * @exception
     */
    public int selectYetaP410001ToPsnl0100ListTotCnt(InfcPsnl0100Srh_2019_VO   psnl0100Srh_2019_VO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("ye161010_2019_DAO.selectP41001ToPsnl0100ListCnt_S", psnl0100Srh_2019_VO);
    }
    
    public List<Ye161010_2019_VO> selectYeta4300ToYe161010AllList(Ye161010Srh_2019_VO  ye161010SrhVo) throws Exception {
    	return list("ye161010_2019_DAO.selectYeta4300ToYe161010AllList_D", ye161010SrhVo);
    }
    
    
    /**
	 * YETA2000 총 갯수를 조회한다..(연말정산신고내역) YETA0400.JAVA
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 총 갯수
	 * @exception
	 */
    public int selectYeta4400GirdListTotCnt(Ye161010Srh_2019_VO ye161010SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye161010_2019_DAO.selectYeta0400GirdListTotCnt_S", ye161010SrhVo);
    }
    
    /**
	 * YETA2000 목록을 조회한다.(연말정산신고내역) YETA0400.JAVA
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 목록
	 * @exception Exception
	 */
    public List selectYeta4400GirdList(Ye161010Srh_2019_VO ye161010SrhVo) throws Exception {
        return list("ye161010_2019_DAO.selectYeta0400GridToList_D", ye161010SrhVo);
    }
    
    
    /**
	 * YETA2000 총 갯수를 조회한다.(연말정산신고내역) YETA0500.JAVA
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 총 갯수
	 * @exception
	 */
    public int selectYeta0500GirdListTotCnt(Ye161010Srh_2019_VO ye161010SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye161010_2019_DAO.selectYeta0500GirdListTotCnt_S", ye161010SrhVo);
    }
    
    /**
	 * YETA2000 목록을 조회한다.(연말정산신고내역) YETA0500.JAVA
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 목록
	 * @exception Exception
	 */
    public List selectYeta0500GirdList(Ye161010Srh_2019_VO ye161010SrhVo) throws Exception {
        return list("ye161010_2019_DAO.selectYeta0500GridToList_D", ye161010SrhVo);
    }
    
    

	
	/** 마감처리할 대상자 리스트를 가져온다. **/
    public List selectFinYe161010List(Ye161010_2019_VO ye161010Vo) throws Exception {
        // TODO Auto-generated method stub
        return  list("ye161010_2019_DAO.selectFinYeta3000List", ye161010Vo);
    }
    /**
	 * 연말정산 마감 처리를 한다.
	 */
    @Transactional
    public void finishYeta4400Update(Ye161010_2019_VO ye161010Vo) throws Exception {
        update("ye161010_2019_DAO.finishYeta3000Update_S", ye161010Vo);
    }
	 
	   public List selectYeta4400ToYeta3000XlsList(Ye161010Srh_2019_VO ye161010SrhVo) throws Exception {
	        return list("ye161010_2019_DAO.selectYeta0400ToYeta3000XlsList", ye161010SrhVo);
	    }
	   
	    /**
		 * yeta0500 화면에서 대상자 내역을 조회하여 엑셀로 출력한다.
		 * @param searchMap - 조회할 정보가 담긴 Map
		 * @return YETA2000 목록
		 * @exception Exception
		 */
	    public List selectYeta4500ToYeta3000XlsList(Ye161010Srh_2019_VO ye161010SrhVo) throws Exception {
	        return list("ye161010_2019_DAO.selectYeta0500ToYeta3000XlsList", ye161010SrhVo);
	    }
	    
	    /**
		 * YETA2000 목록을 수정한다.(연말정산급여반영 - 당월급여반영) YETA0500.JAVA
		 * @param vo - 조회할 정보가 담긴 Yeta3000_2019_VO
		 * @return YETA2000 목록
		 * @exception Exception
		 */
	    @Transactional
	    public void activityOnYeta0500Update(Ye161010_2019_VO ye161010Vo) throws Exception {
	    	update("ye161010_2019_DAO.activityOnYeta0500Update", ye161010Vo);
	    }
	    
	    /**
		 * YETA2000을 수정한다.(연말정산급여반영 - 저장) YETA0500.JAVA
		 * @param vo - 수정할 정보가 담긴 Yeta3000_2019_VO
		 * @return void형
		 * @exception Exception
		 * 분할납부횟수 수정 불가
		 */
	    @Transactional
	    public void saveYeta0500Ye161010_Y(Ye161010_2019_VO ye161010Vo) throws Exception {
	    	update("ye161010_2019_DAO.updateYeta0500To2000_Y", ye161010Vo);
	    }
	    
	    /**
		 * YETA2000을 수정한다.(연말정산급여반영 - 저장) YETA0500.JAVA
		 * @param vo - 수정할 정보가 담긴 Yeta3000_2019_VO
		 * @return void형
		 * @exception Exception
		 * 분할납부횟수 수정 가능
		 */
	    @Transactional
	    public void saveYeta0500Ye161010_N(Ye161010_2019_VO ye161010Vo) throws Exception {
	    	update("ye161010_2019_DAO.updateYeta0500To2000_N", ye161010Vo);
	    }
	    

}
