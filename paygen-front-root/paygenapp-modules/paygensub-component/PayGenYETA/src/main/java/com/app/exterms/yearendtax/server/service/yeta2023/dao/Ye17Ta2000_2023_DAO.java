package com.app.exterms.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.InfcPsnl0100Srh_2023_VO;
import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2023_VO;
import com.app.exterms.yearendtax.server.vo.Yeta3000Srh_2023_VO;
import com.app.exterms.yearendtax.server.vo.Yeta3000_2023_VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3000_2023_DAO.java
 * @Description : Yeta3000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye17Ta2000_2023_DAO")
public class Ye17Ta2000_2023_DAO extends EgovAbstractDAO implements IsSerializable {
    /**
	 * YETA2000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3000VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void fnYeta1100_YETA2000_2016_CREATE_Delete(Yeta3000_2023_VO vo) throws Exception {
        delete("ye17Ta2000_2023_DAO.fnYeta1100_YETA2000_2016_CREATE_Delete_S", vo);
    }  
    
    
    /**
	 * YETA1100 목록을 조회한다.
	 * @param searcVO - 조회할 정보가 담긴 searcVO
	 * @return YETA1000 목록
	 * @exception Exception
	 */
    public List selectYeta1100ToYeta3000List(Yeta3000Srh_2023_VO yeta2000SrhVo) throws Exception {
        return list("ye17Ta2000_2023_DAO.selectYeta1100ToYeta3000List_D", yeta2000SrhVo);
    }

    /**
	 * YETA1000 총 갯수를 조회한다..
	 * @param searcVO - 조회할 정보가 담긴 searcVO
	 * @return YETA1000  총 갯수
	 * @exception
	 */
    public int selectYeta1100ToYeta3000ListTotCnt(Yeta3000Srh_2023_VO yeta2000SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye17Ta2000_2023_DAO.selectYeta1100ToYeta3000ListTotCnt_S", yeta2000SrhVo);
    }
    
    
    /**
	 * YETA2000 원천징수의무부서코드를 수정한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3000VO
	 * @return YETA2000 목록
	 * @exception Exception
	 */
    @Transactional
    public void updateYeta3000YetaDpcd(Yeta3000_2023_VO vo) throws Exception {
    	update("ye17Ta2000_2023_DAO.updateYeta3000YetaDpcd_S", vo);
    }
    
	
	
	
	/** 마감처리할 대상자 리스트를 가져온다. **/
    public List selectFinYeta3000List(Yeta3000_2023_VO yeta2000VO) throws Exception {
        // TODO Auto-generated method stub
        return  list("ye17Ta2000_2023_DAO.selectFinYeta3000List", yeta2000VO);
    }
    /**
	 * 연말정산 마감 처리를 한다.
	 */
    @Transactional
    public void finishYeta0400List(Yeta3000_2023_VO vo) throws Exception {
        update("ye17Ta2000_2023_DAO.finishYeta3000_S", vo);
    }
	
    
    
	
	/** 원천징수부서 리스트를 가져옴 **/
    public List selectYeta3000YetaDpcdList(Yeta3000Srh_2023_VO yeta2000SrhVo) throws Exception {
        // TODO Auto-generated method stub
        return  list("ye17Ta2000_2023_DAO.selectYeta3000YetaDpcdList_D", yeta2000SrhVo);
    }
	
	
    /**
	 * YETA1000 목록을 조회한다.
	 * @param searcVO - 조회할 정보가 담긴 searcVO
	 * @return YETA1000 목록
	 * @exception Exception
	 */
    public List selectYetaP110001List(InfcPsnl0100Srh_2023_VO   psnl0100SrhVO) throws Exception {
        return list("ye17Ta2000_2023_DAO.selectPsnl0100List_D", psnl0100SrhVO);
    }

    /**
	 * YETA1000 총 갯수를 조회한다..
	 * @param searcVO - 조회할 정보가 담긴 searcVO
	 * @return YETA1000  총 갯수
	 * @exception
	 */
    public int selectYetaP110001ListTotCnt(InfcPsnl0100Srh_2023_VO   psnl0100SrhVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye17Ta2000_2023_DAO.selectPsnl0100ListCnt_S", psnl0100SrhVO);
    }
    
	
    /**
	 * YETA2000을 조회한다.(YETA0300)
	 * @param srhVo - 조회할 정보가 담긴 Yeta3000SrhVO
	 * @return 조회한 YETA2000
	 * @exception Exception
	 */
    public List selectYeta0300To2000List(Yeta3000Srh_2023_VO Yeta3000SrhVo) throws Exception {
        return list("ye17Ta2000_2023_DAO.selectYeta0300To2000List", Yeta3000SrhVo);
    }
    
    /**
	 * YETA2000 총 갯수를 조회한다.(YETA0300)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA2000 총 갯수
	 * @exception
	 */
    public int selectYeta0300To2000ListTotCnt(Yeta3000Srh_2023_VO Yeta3000SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye17Ta2000_2023_DAO.selectYeta0300To2000ListTotCnt_S", Yeta3000SrhVo);
    }
    
    /**
   	 * YETA2000을 조회한다.(YETA0300)
   	 * @param srhVo - 조회할 정보가 담긴 Yeta3000SrhVO
   	 * @return 조회한 YETA2000
   	 * @exception Exception
   	 */
       public List selectYeta0300ToYeta3000List(Yeta3000Srh_2023_VO Yeta3000SrhVo) throws Exception {
           return list("ye17Ta2000_2023_DAO.selectYeta0300ToYeta3000List", Yeta3000SrhVo);
       }
       
       /**
   	 * YETA2000 총 갯수를 조회한다.(YETA0300)
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return YETA2000 총 갯수
   	 * @exception
   	 */
       public int selectYeta0300ToYeta3000ListTotCnt(Yeta3000Srh_2023_VO Yeta3000SrhVo) {
           return (Integer)getSqlMapClientTemplate().queryForObject("ye17Ta2000_2023_DAO.selectYeta0300ToYeta3000ListTotCnt_S", Yeta3000SrhVo);
       }
       
    
    
    /**
	 * YETA2000 총 갯수를 조회한다..(연말정산신고내역) YETA0400.JAVA
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 총 갯수
	 * @exception
	 */
    public int selectYeta8400GirdListTotCnt(Ye161010Srh_2023_VO ye161010SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye17Ta2000_2023_DAO.selectYeta8400GirdListTotCnt_S", ye161010SrhVo);
    }
    
    /**
	 * YETA2000 목록을 조회한다.(연말정산신고내역) YETA0400.JAVA
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 목록
	 * @exception Exception
	 */
    public List selectYeta8400GirdList(Ye161010Srh_2023_VO ye161010SrhVo) throws Exception {
        return list("ye17Ta2000_2023_DAO.selectYeta8400GridToList_D", ye161010SrhVo);
    }
    
    
    /**
	 * YETA2000 총 갯수를 조회한다.(연말정산신고내역) YETA0500.JAVA
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 총 갯수
	 * @exception
	 */
    public int selectYeta0500GirdListTotCnt(Yeta3000Srh_2023_VO Yeta3000SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye17Ta2000_2023_DAO.selectYeta0500GirdListTotCnt_S", Yeta3000SrhVo);
    }
    
    /**
	 * YETA2000 목록을 조회한다.(연말정산신고내역) YETA0500.JAVA
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 목록
	 * @exception Exception
	 */
    public List selectYeta0500GirdList(Yeta3000Srh_2023_VO Yeta3000SrhVo) throws Exception {
        return list("ye17Ta2000_2023_DAO.selectYeta0500GridToList_D", Yeta3000SrhVo);
    }
    
    /**
	 * YETA2000 목록을 수정한다.(연말정산급여반영 - 당월급여반영) YETA0500.JAVA
	 * @param vo - 조회할 정보가 담긴 Yeta3000VO
	 * @return YETA2000 목록
	 * @exception Exception
	 */
    @Transactional
    public void activityOnYeta0500List(Yeta3000_2023_VO vo) throws Exception {
    	update("ye17Ta2000_2023_DAO.updateYeta0500List", vo);
    }
    
    /**
	 * YETA2000을 수정한다.(연말정산급여반영 - 저장) YETA0500.JAVA
	 * @param vo - 수정할 정보가 담긴 Yeta3000VO
	 * @return void형
	 * @exception Exception
	 * 분할납부횟수 수정 불가
	 */
    @Transactional
    public void saveYeta0500Yeta3000_Y(Yeta3000_2023_VO vo) throws Exception {
    	update("ye17Ta2000_2023_DAO.updateYeta0500To2000_Y", vo);
    }
    
    /**
	 * YETA2000을 수정한다.(연말정산급여반영 - 저장) YETA0500.JAVA
	 * @param vo - 수정할 정보가 담긴 Yeta3000VO
	 * @return void형
	 * @exception Exception
	 * 분할납부횟수 수정 가능
	 */
    @Transactional
    public void saveYeta0500Yeta3000_N(Yeta3000_2023_VO vo) throws Exception {
    	update("ye17Ta2000_2023_DAO.updateYeta0500To2000_N", vo);
    }
    
    
    
    /***************************************************/
    /********** 소득공제신고자료관리 저장 쿼리 시작 ****************/
    /***************************************************/
    
    /**
	 * YETA2000을 수정한다.(기본사항)
	 * @param vo - 수정할 정보가 담긴 Yeta3000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem01(Yeta3000_2023_VO vo) throws Exception {
    	update("ye17Ta2000_2023_DAO.updateYeta0300To2000tabItem01", vo);
    }
    
    /**
	 * YETA2000을 수정한다.(인적공제)
	 * @param vo - 수정할 정보가 담긴 Yeta3000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem02(Yeta3000_2023_VO vo) throws Exception {
    	update("ye17Ta2000_2023_DAO.updateYeta0300To2000tabItem02", vo);
    }
    
    
    /**
	 * YETA2000을 수정한다.(국민연금보험료외의 연금보험료 주근무지 금액)
	 * @param vo - 수정할 정보가 담긴 Yeta3000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem04(Yeta3000_2023_VO vo) throws Exception {
    	update("ye17Ta2000_2023_DAO.updateYeta0300To2000tabItem04", vo);
    }
    
    /**
	 * YETA2000을 수정한다.(특별소득공제의 보험료 금액)
	 * @param vo - 수정할 정보가 담긴 Yeta3000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem05_1(Yeta3000_2023_VO vo) throws Exception {
    	update("ye17Ta2000_2023_DAO.updateYeta0300To2000tabItem05_1", vo);
    }
    
    
    /**
	 * YETA2000을 수정한다.(특별소득공제의 주택자금 금액)
	 * @param vo - 수정할 정보가 담긴 Yeta3000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem05_2(Yeta3000_2023_VO vo) throws Exception {
    	update("ye17Ta2000_2023_DAO.updateYeta0300To2000tabItem05_2", vo);
    }
    
    
    /**
	 * YETA2000을 수정한다.(그밖의소득공제1의 금액)
	 * @param vo - 수정할 정보가 담긴 Yeta3000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem06(Yeta3000_2023_VO vo) throws Exception {
    	update("ye17Ta2000_2023_DAO.updateYeta0300To2000tabItem06", vo);
    }
    
    
    /**
	 * YETA2000을 수정한다.(그밖의소득공제2의 금액)
	 * @param vo - 수정할 정보가 담긴 Yeta3000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem07(Yeta3000_2023_VO vo) throws Exception {
    	update("ye17Ta2000_2023_DAO.updateYeta0300To2000tabItem07", vo);
    }
    
    /**
	 * YETA2000을 수정한다.(세액감면및세액공제1 - 연금계좌및보험료 금액)
	 * @param vo - 수정할 정보가 담긴 Yeta3000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem08_1(Yeta3000_2023_VO vo) throws Exception {
    	update("ye17Ta2000_2023_DAO.updateYeta0300To2000tabItem08_1", vo);
    }
    
    
    /**
	 * YETA2000을 수정한다.(세액감면및세액공제1 - 의료비 금액)
	 * @param vo - 수정할 정보가 담긴 Yeta3000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem08_3(Yeta3000_2023_VO vo) throws Exception {
    	update("ye17Ta2000_2023_DAO.updateYeta0300To2000tabItem08_3", vo);
    }
    
    
    /**
	 * YETA2000을 수정한다.(세액감면및세액공제2 금액)
	 * @param vo - 수정할 정보가 담긴 Yeta3000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem09(Yeta3000_2023_VO vo) throws Exception {
    	update("ye17Ta2000_2023_DAO.updateYeta0300To2000tabItem09", vo);
    }
    
    /**
	 * YETA2000을 수정한다.(추가제출서류)
	 * @param vo - 수정할 정보가 담긴 Yeta3000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem10(Yeta3000_2023_VO vo) throws Exception {
    	update("ye17Ta2000_2023_DAO.updateYeta0300To2000tabItem10", vo);
    }
    /***************************************************/
    /************* 소득공제신고자료관리 저장 쿼리 종료 *************/
    /***************************************************/
     
    

	/**
	 * YETA2000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertYeta3000(Yeta3000_2023_VO vo) throws Exception {
        return (String)insert("ye17Ta2000_2023_DAO.insertYeta3000_S", vo);
    }

    /**
	 * YETA2000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateYeta3000(Yeta3000_2023_VO vo) throws Exception {
        update("ye17Ta2000_2023_DAO.updateYeta3000_S", vo);
    }
    
    @Transactional
    public void updateYeta0300ToYeta3000_Item03(Yeta3000_2023_VO vo) throws Exception {
        update("ye17Ta2000_2023_DAO.updateYeta0300ToYeta3000_Item03", vo);
    }
    
    /**
	 * YETA2000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3000VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteYeta3000(Yeta3000_2023_VO vo) throws Exception {
        delete("ye17Ta2000_2023_DAO.deleteYeta3000_S", vo);
    }
    /**
	 * YETA2000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3000VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void fnPayr06420_PAYR415_CREATE_Delete(Yeta3000_2023_VO vo) throws Exception {
        delete("ye17Ta2000_2023_DAO.fnPayr06420_PAYR415_CREATE_Delete_S", vo);
    }  
    

    /**
	 * YETA2000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3000VO
	 * @return 조회한 YETA2000
	 * @exception Exception
	 */
    public Yeta3000_2023_VO selectYeta3000(Yeta3000_2023_VO vo) throws Exception {
        return (Yeta3000_2023_VO) selectByPk("ye17Ta2000_2023_DAO.selectYeta3000_S", vo);
    }

    /**
	 * YETA2000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA2000 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3000List(Yeta3000Srh_2023_VO searchVO) throws Exception {
        return list("ye17Ta2000_2023_DAO.selectYeta3000List_D", searchVO);
    }

    /**
	 * YETA2000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA2000 총 갯수
	 * @exception
	 */
    public int selectYeta3000ListTotCnt(Yeta3000Srh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye17Ta2000_2023_DAO.selectYeta3000ListTotCnt_S", searchVO);
    }
    
    /**
	 * ye17Ta0100 화면에서 대상자 내역을 조회하여 엑셀로 출력한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA2000 목록
	 * @exception Exception
	 */
    public List selectYeta0100ToYeta3000XlsList(Yeta3000Srh_2023_VO searchVO) throws Exception {
        return list("ye17Ta2000_2023_DAO.selectYeta0100ToYeta3000XlsList", searchVO);
    }
    
	/**
	 * YETA0400 화면에서 대상자 내역을 조회하여 엑셀로 출력한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA2000 목록
	 * @exception Exception
	 */
   public List selectYeta0400ToYeta3000XlsList(Yeta3000Srh_2023_VO Yeta3000SrhVo) throws Exception {
       return list("ye17Ta2000_2023_DAO.selectYeta0400ToYeta3000XlsList", Yeta3000SrhVo);
   }
    
    /**
	 * ye17Ta0500 화면에서 대상자 내역을 조회하여 엑셀로 출력한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA2000 목록
	 * @exception Exception
	 */
    public List selectYeta8500ToYeta3000XlsList(Yeta3000Srh_2023_VO searchVO) throws Exception {
        return list("ye17Ta2000_2023_DAO.selectYeta8500ToYeta3000XlsList", searchVO);
    }
    

    /**
	 * ye17Ta0100 화면에서 생성내역을 보여준다 .YETA2000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA2000 목록
	 * @exception Exception
	 */
    public List<?> selectYeta0100ToYeta3000List(Yeta3000Srh_2023_VO searchVO) throws Exception {
        return list("ye17Ta2000_2023_DAO.selectYeta0100ToYeta3000List_D", searchVO);
    }

    /**
	 * ye17Ta0100 화면에서 생성내역을 보여준다 .
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA2000 총 갯수
	 * @exception
	 */
    public int selectYeta0100ToYeta3000ListTotCnt(Yeta3000Srh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye17Ta2000_2023_DAO.selectYeta0100ToYeta3000ListTotCnt_S", searchVO);
    }
    
    /**
   	 * 2016년도 적용으로 수정 
   	 * ye17Ta0100 화면에서 생성내역을 보여준다 .YETA2000 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return YETA2000 목록
   	 * @exception Exception
   	 */
       public List<?> selectYeta1200ToYeta3000List(Yeta3000Srh_2023_VO searchVO) throws Exception {
           return list("ye17Ta2000_2023_DAO.selectYeta1200ToYeta3000List_D", searchVO);
       }

       /**
        * 2016년도 적용으로 수정 
   	 * ye17Ta0100 화면에서 생성내역을 보여준다 .
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return YETA2000 총 갯수
   	 * @exception
   	 */
       public int selectYeta1200ToYeta3000ListTotCnt(Yeta3000Srh_2023_VO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("ye17Ta2000_2023_DAO.selectYeta1200ToYeta3000ListTotCnt_S", searchVO);
       }
       
       
       public List<?> fnPayr06430_PAYR450_DelSelect(Yeta3000Srh_2023_VO searchVO) throws Exception {
           return list("ye17Ta2000_2023_DAO.fnPayr06430_PAYR450_DelSelect_D", searchVO);
       }
       
       
       /**
      	 * ye17Ta0100 화면에서 생성내역을 보여준다 .YETA2000 목록을 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return YETA2000 목록
      	 * @exception Exception
      	 */
          public List<Yeta3000_2023_VO> selectYeta0300AllToYeta3000List(Yeta3000Srh_2023_VO searchVO) throws Exception {
              return list("ye17Ta2000_2023_DAO.selectYeta0300AllToYeta3000List_D", searchVO);
          }
     

}
