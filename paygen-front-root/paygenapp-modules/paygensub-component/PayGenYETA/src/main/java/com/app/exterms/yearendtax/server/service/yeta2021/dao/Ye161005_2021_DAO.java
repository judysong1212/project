package com.app.exterms.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Ye161005Srh_2021_VO;
import com.app.exterms.yearendtax.server.vo.Ye161005_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161005_2021_DAO.java
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

@Repository("Ye161005_2021_DAO")
public class Ye161005_2021_DAO extends EgovAbstractDAO {

	/**
	 * YE161005?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161005_2021_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161005(Ye161005_2021_VO vo) throws Exception {
        return (String)insert("ye161005_2021_DAO.insertYe161005_S", vo);
    }

    /**
	 * YE161005?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161005_2021_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161005(Ye161005_2021_VO vo) throws Exception {
        update("ye161005_2021_DAO.updateYe161005_S", vo);
    }

    /**
	 * YE161005?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161005_2021_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161005(Ye161005_2021_VO vo) throws Exception {
        delete("ye161005_2021_DAO.deleteYe161005_S", vo);
    }

    /**
	 * YE161005?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161005_2021_VO
	 * @return 조회?�� YE161005
	 * @exception Exception
	 */
    public Ye161005_2021_VO selectYe161005(Ye161005_2021_VO vo) throws Exception {
        return (Ye161005_2021_VO) selectByPk("ye161005_2021_DAO.selectYe161005_S", vo);
    }
    
    public Ye161005_2021_VO selectYetaP610002ToYe161005(Ye161005Srh_2021_VO vo) throws Exception {
        return (Ye161005_2021_VO) selectByPk("ye161005_2021_DAO.selectYetaP610002ToYe161005_S", vo);
    }

    /**
	 * YE161005 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161005 목록
	 * @exception Exception
	 */
    public List<?> selectYe161005List(Ye161005Srh_2021_VO search_2021_VO) throws Exception {
        return list("ye161005_2021_DAO.selectYe161005List_D", search_2021_VO);
    }

    /**
	 * YE161005 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161005 �? �??��
	 * @exception
	 */
    public int selectYe161005ListTotCnt(Ye161005Srh_2021_VO search_2021_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye161005_2021_DAO.selectYe161005ListTotCnt_S", search_2021_VO);
    }
    
    @Transactional
    public int deleteYeta606001ToYe161005(Ye161005_2021_VO vo) throws Exception {
        return update("ye161005_2021_DAO.deleteYeta606001ToYe161005_S", vo);
    }
    
    @Transactional
    public int insertYetaS206001ToYe161005(Ye161005_2021_VO vo) throws Exception {
        return update("ye161005_2021_DAO.insertYetaS206001ToYe161005_S", vo);
    }
    
    @Transactional
    public int updateNumYetaS206001ToYe161005(Ye161005_2021_VO vo) throws Exception {
    	return update("ye161005_2021_DAO.updateNumYetaS206001ToYe161005_S", vo);
    }
    
    public int updateYetaP610002ToYe161005(Ye161005_2021_VO vo) throws Exception {
    	return update("ye161005_2021_DAO.updateYetaP610002ToYe161005_S", vo);
    }

    
    public List selectYeta6400ToYe161005List(Ye161005Srh_2021_VO search_2021_VO) throws Exception {
        return list("ye161005_2021_DAO.selectYeta6400ToYe161005List_D", search_2021_VO);
    }
    
    /**
	 * YETA1000 총 갯수를 조회한다..(연말정산신고 기본정보)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 총 갯수
	 * @exception
	 */
    public int selectYeta6400ToYe161005ListTotCnt(Ye161005Srh_2021_VO search_2021_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye161005_2021_DAO.selectYeta6400ToYe161005ListTotCnt_S", search_2021_VO);
    }
    
    
    /**
	 * YE161005?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161005_2021_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYeta6400ToYe161005(Ye161005_2021_VO vo) throws Exception {
        update("ye161005_2021_DAO.updateYeta6400ToYe161005_S", vo);
    }
  
    
}
