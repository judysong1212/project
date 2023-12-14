package com.app.exterms.yearendtax.server.service.yeta2015.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Yeta2000SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta2000VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta2000DAO.java
 * @Description : Yeta2000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta2000DAO")
public class Yeta2000DAO extends EgovAbstractDAO implements IsSerializable {
	
    /**
	 * YETA2000을 조회한다.(YETA0300)
	 * @param srhVo - 조회할 정보가 담긴 Yeta2000SrhVO
	 * @return 조회한 YETA2000
	 * @exception Exception
	 */
    public List selectYeta0300To2000List(Yeta2000SrhVO Yeta2000SrhVo) throws Exception {
        return list("yeta2000DAO.selectYeta0300To2000List", Yeta2000SrhVo);
    }
    
    /**
	 * YETA2000 총 갯수를 조회한다.(YETA0300)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA2000 총 갯수
	 * @exception
	 */
    public int selectYeta0300To2000ListTotCnt(Yeta2000SrhVO Yeta2000SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta2000DAO.selectYeta0300To2000ListTotCnt_S", Yeta2000SrhVo);
    }
    
    /**
   	 * YETA2000을 조회한다.(YETA0300)
   	 * @param srhVo - 조회할 정보가 담긴 Yeta2000SrhVO
   	 * @return 조회한 YETA2000
   	 * @exception Exception
   	 */
       public List selectYeta0300ToYeta2000List(Yeta2000SrhVO Yeta2000SrhVo) throws Exception {
           return list("yeta2000DAO.selectYeta0300ToYeta2000List", Yeta2000SrhVo);
       }
       
       /**
   	 * YETA2000 총 갯수를 조회한다.(YETA0300)
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return YETA2000 총 갯수
   	 * @exception
   	 */
       public int selectYeta0300ToYeta2000ListTotCnt(Yeta2000SrhVO Yeta2000SrhVo) {
           return (Integer)getSqlMapClientTemplate().queryForObject("yeta2000DAO.selectYeta0300ToYeta2000ListTotCnt_S", Yeta2000SrhVo);
       }
       
    
    
    /**
	 * YETA2000 총 갯수를 조회한다..(연말정산신고내역) YETA0400.JAVA
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 총 갯수
	 * @exception
	 */
    public int selectYeta0400GirdListTotCnt(Yeta2000SrhVO Yeta2000SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta2000DAO.selectYeta0400GirdListTotCnt_S", Yeta2000SrhVo);
    }
    
    /**
	 * YETA2000 목록을 조회한다.(연말정산신고내역) YETA0400.JAVA
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 목록
	 * @exception Exception
	 */
    public List selectYeta0400GirdList(Yeta2000SrhVO Yeta2000SrhVo) throws Exception {
        return list("yeta2000DAO.selectYeta0400GridToList_D", Yeta2000SrhVo);
    }
    
    
    /**
	 * YETA2000 총 갯수를 조회한다.(연말정산신고내역) YETA0500.JAVA
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 총 갯수
	 * @exception
	 */
    public int selectYeta0500GirdListTotCnt(Yeta2000SrhVO Yeta2000SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta2000DAO.selectYeta0500GirdListTotCnt_S", Yeta2000SrhVo);
    }
    
    /**
	 * YETA2000 목록을 조회한다.(연말정산신고내역) YETA0500.JAVA
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 목록
	 * @exception Exception
	 */
    public List selectYeta0500GirdList(Yeta2000SrhVO Yeta2000SrhVo) throws Exception {
        return list("yeta2000DAO.selectYeta0500GridToList_D", Yeta2000SrhVo);
    }
    
    /**
	 * YETA2000 목록을 수정한다.(연말정산급여반영 - 당월급여반영) YETA0500.JAVA
	 * @param vo - 조회할 정보가 담긴 Yeta2000VO
	 * @return YETA2000 목록
	 * @exception Exception
	 */
    @Transactional
    public void activityOnYeta0500List(Yeta2000VO vo) throws Exception {
    	update("yeta2000DAO.updateYeta0500List", vo);
    }
    
    /**
	 * YETA2000을 수정한다.(연말정산급여반영 - 저장) YETA0500.JAVA
	 * @param vo - 수정할 정보가 담긴 Yeta2000VO
	 * @return void형
	 * @exception Exception
	 * 분할납부횟수 수정 불가
	 */
    @Transactional
    public void saveYeta0500Yeta2000_Y(Yeta2000VO vo) throws Exception {
    	update("yeta2000DAO.updateYeta0500To2000_Y", vo);
    }
    
    /**
	 * YETA2000을 수정한다.(연말정산급여반영 - 저장) YETA0500.JAVA
	 * @param vo - 수정할 정보가 담긴 Yeta2000VO
	 * @return void형
	 * @exception Exception
	 * 분할납부횟수 수정 가능
	 */
    @Transactional
    public void saveYeta0500Yeta2000_N(Yeta2000VO vo) throws Exception {
    	update("yeta2000DAO.updateYeta0500To2000_N", vo);
    }
    
    
    
    /***************************************************/
    /********** 소득공제신고자료관리 저장 쿼리 시작 ****************/
    /***************************************************/
    
    /**
	 * YETA2000을 수정한다.(기본사항)
	 * @param vo - 수정할 정보가 담긴 Yeta2000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem01(Yeta2000VO vo) throws Exception {
    	update("yeta2000DAO.updateYeta0300To2000tabItem01", vo);
    }
    
    /**
	 * YETA2000을 수정한다.(인적공제)
	 * @param vo - 수정할 정보가 담긴 Yeta2000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem02(Yeta2000VO vo) throws Exception {
    	update("yeta2000DAO.updateYeta0300To2000tabItem02", vo);
    }
    
    
    /**
	 * YETA2000을 수정한다.(국민연금보험료외의 연금보험료 주근무지 금액)
	 * @param vo - 수정할 정보가 담긴 Yeta2000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem04(Yeta2000VO vo) throws Exception {
    	update("yeta2000DAO.updateYeta0300To2000tabItem04", vo);
    }
    
    /**
	 * YETA2000을 수정한다.(특별소득공제의 보험료 금액)
	 * @param vo - 수정할 정보가 담긴 Yeta2000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem05_1(Yeta2000VO vo) throws Exception {
    	update("yeta2000DAO.updateYeta0300To2000tabItem05_1", vo);
    }
    
    
    /**
	 * YETA2000을 수정한다.(특별소득공제의 주택자금 금액)
	 * @param vo - 수정할 정보가 담긴 Yeta2000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem05_2(Yeta2000VO vo) throws Exception {
    	update("yeta2000DAO.updateYeta0300To2000tabItem05_2", vo);
    }
    
    
    /**
	 * YETA2000을 수정한다.(그밖의소득공제1의 금액)
	 * @param vo - 수정할 정보가 담긴 Yeta2000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem06(Yeta2000VO vo) throws Exception {
    	update("yeta2000DAO.updateYeta0300To2000tabItem06", vo);
    }
    
    
    /**
	 * YETA2000을 수정한다.(그밖의소득공제2의 금액)
	 * @param vo - 수정할 정보가 담긴 Yeta2000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem07(Yeta2000VO vo) throws Exception {
    	update("yeta2000DAO.updateYeta0300To2000tabItem07", vo);
    }
    
    /**
	 * YETA2000을 수정한다.(세액감면및세액공제1 - 연금계좌및보험료 금액)
	 * @param vo - 수정할 정보가 담긴 Yeta2000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem08_1(Yeta2000VO vo) throws Exception {
    	update("yeta2000DAO.updateYeta0300To2000tabItem08_1", vo);
    }
    
    
    /**
	 * YETA2000을 수정한다.(세액감면및세액공제1 - 의료비 금액)
	 * @param vo - 수정할 정보가 담긴 Yeta2000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem08_3(Yeta2000VO vo) throws Exception {
    	update("yeta2000DAO.updateYeta0300To2000tabItem08_3", vo);
    }
    
    
    /**
	 * YETA2000을 수정한다.(세액감면및세액공제2 금액)
	 * @param vo - 수정할 정보가 담긴 Yeta2000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem09(Yeta2000VO vo) throws Exception {
    	update("yeta2000DAO.updateYeta0300To2000tabItem09", vo);
    }
    
    /**
	 * YETA2000을 수정한다.(추가제출서류)
	 * @param vo - 수정할 정보가 담긴 Yeta2000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0300To2000tabItem10(Yeta2000VO vo) throws Exception {
    	update("yeta2000DAO.updateYeta0300To2000tabItem10", vo);
    }
    /***************************************************/
    /************* 소득공제신고자료관리 저장 쿼리 종료 *************/
    /***************************************************/
     
    

	/**
	 * YETA2000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta2000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertYeta2000(Yeta2000VO vo) throws Exception {
        return (String)insert("yeta2000DAO.insertYeta2000_S", vo);
    }

    /**
	 * YETA2000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta2000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateYeta2000(Yeta2000VO vo) throws Exception {
        update("yeta2000DAO.updateYeta2000_S", vo);
    }
    
    @Transactional
    public void updateYeta0300ToYeta2000_Item03(Yeta2000VO vo) throws Exception {
        update("yeta2000DAO.updateYeta0300ToYeta2000_Item03", vo);
    }
    
    /**
	 * YETA2000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta2000VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteYeta2000(Yeta2000VO vo) throws Exception {
        delete("yeta2000DAO.deleteYeta2000_S", vo);
    }
    /**
	 * YETA2000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta2000VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void fnPayr06420_PAYR415_CREATE_Delete(Yeta2000VO vo) throws Exception {
        delete("yeta2000DAO.fnPayr06420_PAYR415_CREATE_Delete_S", vo);
    }  
    

    /**
	 * YETA2000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta2000VO
	 * @return 조회한 YETA2000
	 * @exception Exception
	 */
    public Yeta2000VO selectYeta2000(Yeta2000VO vo) throws Exception {
        return (Yeta2000VO) selectByPk("yeta2000DAO.selectYeta2000_S", vo);
    }

    /**
	 * YETA2000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA2000 목록
	 * @exception Exception
	 */
    public List<?> selectYeta2000List(Yeta2000SrhVO searchVO) throws Exception {
        return list("yeta2000DAO.selectYeta2000List_D", searchVO);
    }

    /**
	 * YETA2000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA2000 총 갯수
	 * @exception
	 */
    public int selectYeta2000ListTotCnt(Yeta2000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta2000DAO.selectYeta2000ListTotCnt_S", searchVO);
    }
    
    /**
	 * yeta0100 화면에서 대상자 내역을 조회하여 엑셀로 출력한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA2000 목록
	 * @exception Exception
	 */
    public List selectYeta0100ToYeta2000XlsList(Yeta2000SrhVO searchVO) throws Exception {
        return list("yeta2000DAO.selectYeta0100ToYeta2000XlsList", searchVO);
    }
    public List selectYeta1100ToYeta2000XlsList(Yeta2000SrhVO searchVO) throws Exception {
        return list("ye16Ta2000DAO.selectYeta0100ToYeta2000XlsList", searchVO);
    }
    
    
	/**
	 * YETA0400 화면에서 대상자 내역을 조회하여 엑셀로 출력한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA2000 목록
	 * @exception Exception
	 */
    public List selectYeta0400ToYeta2000XlsList(Yeta2000SrhVO Yeta2000SrhVo) throws Exception {
        return list("yeta2000DAO.selectYeta0400ToYeta2000XlsList", Yeta2000SrhVo);
    }
    public List selectYeta1400ToYeta2000XlsList(Yeta2000SrhVO Yeta2000SrhVo) throws Exception {
        return list("ye16Ta2000DAO.selectYeta0400ToYeta2000XlsList", Yeta2000SrhVo);
    }
   
    
    /**
	 * yeta0500 화면에서 대상자 내역을 조회하여 엑셀로 출력한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA2000 목록
	 * @exception Exception
	 */
    public List selectYeta0500ToYeta2000XlsList(Yeta2000SrhVO searchVO) throws Exception {
        return list("yeta2000DAO.selectYeta0500ToYeta2000XlsList", searchVO);
    }
    

    /**
	 * yeta0100 화면에서 생성내역을 보여준다 .YETA2000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA2000 목록
	 * @exception Exception
	 */
    public List<?> selectYeta0100ToYeta2000List(Yeta2000SrhVO searchVO) throws Exception {
        return list("yeta2000DAO.selectYeta0100ToYeta2000List_D", searchVO);
    }

    /**
	 * yeta0100 화면에서 생성내역을 보여준다 .
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA2000 총 갯수
	 * @exception
	 */
    public int selectYeta0100ToYeta2000ListTotCnt(Yeta2000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta2000DAO.selectYeta0100ToYeta2000ListTotCnt_S", searchVO);
    }
    
    /**
   	 * yeta0100 화면에서 생성내역을 보여준다 .YETA2000 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return YETA2000 목록
   	 * @exception Exception
   	 */
       public List<?> selectYeta0200ToYeta2000List(Yeta2000SrhVO searchVO) throws Exception {
           return list("yeta2000DAO.selectYeta0200ToYeta2000List_D", searchVO);
       }

       /**
   	 * yeta0100 화면에서 생성내역을 보여준다 .
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return YETA2000 총 갯수
   	 * @exception
   	 */
       public int selectYeta0200ToYeta2000ListTotCnt(Yeta2000SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("yeta2000DAO.selectYeta0200ToYeta2000ListTotCnt_S", searchVO);
       }
       
       
       public List<?> fnPayr06430_PAYR450_DelSelect(Yeta2000SrhVO searchVO) throws Exception {
           return list("yeta2000DAO.fnPayr06430_PAYR450_DelSelect_D", searchVO);
       }
       
       
       /**
      	 * yeta0100 화면에서 생성내역을 보여준다 .YETA2000 목록을 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return YETA2000 목록
      	 * @exception Exception
      	 */
          public List<Yeta2000VO> selectYeta0300AllToYeta2000List(Yeta2000SrhVO searchVO) throws Exception {
              return list("yeta2000DAO.selectYeta0300AllToYeta2000List_D", searchVO);
          }
     

}
