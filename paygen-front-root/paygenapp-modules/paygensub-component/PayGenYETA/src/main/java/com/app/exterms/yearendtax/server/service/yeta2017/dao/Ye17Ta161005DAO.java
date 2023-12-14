package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Ye161005SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye161005VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : ye17Ta160403DAO.java
 * @Description : Ye160403 DAO Class
 * @Modification Information
 *
 * @author DaEun
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye17Ta161005DAO")
public class Ye17Ta161005DAO extends EgovAbstractDAO {
	
	
	/** 원천징수부서에 따른 사업자번호 리스트를 가져옴 **/
    public List selectYeta2000busoprRgstnumList(Ye161005SrhVO ye161005SrhVo) throws Exception {
        // TODO Auto-generated method stub
        return  list("ye17Ta161005DAO.selectYeta2000busoprRgstnumList_D", ye161005SrhVo);
    }
    
    
    /** 선택한 원천신고부서의 정보를 가져옴 **/
    public Ye161005VO selectYe161005List(Ye161005VO ye161005Vo) throws Exception {
        return (Ye161005VO) selectByPk("ye17Ta161005DAO.selectYe161005List_L", ye161005Vo);
    }
    
    /** 데이터 중복 체크 **/
    public int selectYeta1100ToYeta2000ListTotCnt(Ye161005VO ye17Ta161005Vo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye17Ta161005DAO.selectYe161005ListCnt", ye17Ta161005Vo);
    }
    
    
	/**
	 * YE161005을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YE161005VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertYe161005(Ye161005VO vo) throws Exception {
        return (String)insert("ye17Ta161005DAO.insertYe161005Data", vo);
    }
    
    
  /**
	 * YE161005을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YE161005VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateYe161005(Ye161005VO vo) throws Exception {
        update("ye17Ta161005DAO.updateYe161005Data", vo);
    }

   /**
	 * YE161005을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YE161005VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteYe161005(Ye161005VO vo) throws Exception {
        delete("ye17Ta161005DAO.deleteYe161005Data", vo);
    }
	

}
