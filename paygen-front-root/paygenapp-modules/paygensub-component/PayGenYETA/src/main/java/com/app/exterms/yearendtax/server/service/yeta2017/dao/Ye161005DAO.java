package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Ye161005SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye161005VO;
import com.app.exterms.yearendtax.server.vo.Yeta1000SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta2060VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161005DAO.java
 * @Description : Ye161005 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye161005DAO")
public class Ye161005DAO extends EgovAbstractDAO {

	/**
	 * YE161005?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161005VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161005(Ye161005VO vo) throws Exception {
        return (String)insert("ye161005DAO.insertYe161005_S", vo);
    }

    /**
	 * YE161005?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161005VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161005(Ye161005VO vo) throws Exception {
        update("ye161005DAO.updateYe161005_S", vo);
    }

    /**
	 * YE161005?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161005VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161005(Ye161005VO vo) throws Exception {
        delete("ye161005DAO.deleteYe161005_S", vo);
    }

    /**
	 * YE161005?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161005VO
	 * @return 조회?�� YE161005
	 * @exception Exception
	 */
    public Ye161005VO selectYe161005(Ye161005VO vo) throws Exception {
        return (Ye161005VO) selectByPk("ye161005DAO.selectYe161005_S", vo);
    }
    
    public Ye161005VO selectYetaP210002ToYe161005(Ye161005SrhVO vo) throws Exception {
        return (Ye161005VO) selectByPk("ye161005DAO.selectYetaP210002ToYe161005_S", vo);
    }

    /**
	 * YE161005 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161005 목록
	 * @exception Exception
	 */
    public List<?> selectYe161005List(Ye161005SrhVO searchVO) throws Exception {
        return list("ye161005DAO.selectYe161005List_D", searchVO);
    }

    /**
	 * YE161005 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161005 �? �??��
	 * @exception
	 */
    public int selectYe161005ListTotCnt(Ye161005SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye161005DAO.selectYe161005ListTotCnt_S", searchVO);
    }
    
    @Transactional
    public int deleteYeta206001ToYe161005(Ye161005VO vo) throws Exception {
        return update("ye161005DAO.deleteYeta206001ToYe161005_S", vo);
    }
    
    @Transactional
    public int insertYetaS206001ToYe161005(Ye161005VO vo) throws Exception {
        return update("ye161005DAO.insertYetaS206001ToYe161005_S", vo);
    }
    
    @Transactional
    public int updateNumYetaS206001ToYe161005(Ye161005VO vo) throws Exception {
    	return update("ye161005DAO.updateNumYetaS206001ToYe161005_S", vo);
    }
    
    public int updateYetaP210002ToYe161005(Ye161005VO vo) throws Exception {
    	return update("ye161005DAO.updateYetaP210002ToYe161005_S", vo);
    }

    
    public List selectYeta2400ToYe161005List(Ye161005SrhVO searchVO) throws Exception {
        return list("ye161005DAO.selectYeta2400ToYe161005List_D", searchVO);
    }
    
    /**
	 * YETA1000 총 갯수를 조회한다..(연말정산신고 기본정보)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 총 갯수
	 * @exception
	 */
    public int selectYeta2400ToYe161005ListTotCnt(Ye161005SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye161005DAO.selectYeta2400ToYe161005ListTotCnt_S", searchVO);
    }
    
    
    /**
	 * YE161005?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161005VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYeta2400ToYe161005(Ye161005VO vo) throws Exception {
        update("ye161005DAO.updateYeta2400ToYe161005_S", vo);
    }
  
    
}
