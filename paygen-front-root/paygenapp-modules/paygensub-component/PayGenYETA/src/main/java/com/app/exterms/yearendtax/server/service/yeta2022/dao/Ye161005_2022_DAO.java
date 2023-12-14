package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Ye161005Srh_2022_VO;
import com.app.exterms.yearendtax.server.vo.Ye161005_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161005_2022_DAO.java
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

@Repository("Ye161005_2022_DAO")
public class Ye161005_2022_DAO extends EgovAbstractDAO {

	/**
	 * YE161005?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161005_2022_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161005(Ye161005_2022_VO vo) throws Exception {
        return (String)insert("ye161005_2022_DAO.insertYe161005_S", vo);
    }

    /**
	 * YE161005?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161005_2022_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161005(Ye161005_2022_VO vo) throws Exception {
        update("ye161005_2022_DAO.updateYe161005_S", vo);
    }

    /**
	 * YE161005?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161005_2022_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161005(Ye161005_2022_VO vo) throws Exception {
        delete("ye161005_2022_DAO.deleteYe161005_S", vo);
    }

    /**
	 * YE161005?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161005_2022_VO
	 * @return 조회?�� YE161005
	 * @exception Exception
	 */
    public Ye161005_2022_VO selectYe161005(Ye161005_2022_VO vo) throws Exception {
        return (Ye161005_2022_VO) selectByPk("ye161005_2022_DAO.selectYe161005_S", vo);
    }
    
    public Ye161005_2022_VO selectYetaP710002ToYe161005(Ye161005Srh_2022_VO vo) throws Exception {
        return (Ye161005_2022_VO) selectByPk("ye161005_2022_DAO.selectYetaP710002ToYe161005_S", vo);
    }

    /**
	 * YE161005 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161005 목록
	 * @exception Exception
	 */
    public List<?> selectYe161005List(Ye161005Srh_2022_VO search_2022_VO) throws Exception {
        return list("ye161005_2022_DAO.selectYe161005List_D", search_2022_VO);
    }

    /**
	 * YE161005 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161005 �? �??��
	 * @exception
	 */
    public int selectYe161005ListTotCnt(Ye161005Srh_2022_VO search_2022_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye161005_2022_DAO.selectYe161005ListTotCnt_S", search_2022_VO);
    }
    
    @Transactional
    public int deleteYeta706001ToYe161005(Ye161005_2022_VO vo) throws Exception {
        return update("ye161005_2022_DAO.deleteYeta706001ToYe161005_S", vo);
    }
    
    @Transactional
    public int insertYetaS206001ToYe161005(Ye161005_2022_VO vo) throws Exception {
        return update("ye161005_2022_DAO.insertYetaS206001ToYe161005_S", vo);
    }
    
    @Transactional
    public int updateNumYetaS206001ToYe161005(Ye161005_2022_VO vo) throws Exception {
    	return update("ye161005_2022_DAO.updateNumYetaS206001ToYe161005_S", vo);
    }
    
    public int updateYetaP710002ToYe161005(Ye161005_2022_VO vo) throws Exception {
    	return update("ye161005_2022_DAO.updateYetaP710002ToYe161005_S", vo);
    }

    
    public List selectYeta7400ToYe161005List(Ye161005Srh_2022_VO search_2022_VO) throws Exception {
        return list("ye161005_2022_DAO.selectYeta7400ToYe161005List_D", search_2022_VO);
    }
    
    /**
	 * YETA1000 총 갯수를 조회한다..(연말정산신고 기본정보)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 총 갯수
	 * @exception
	 */
    public int selectYeta7400ToYe161005ListTotCnt(Ye161005Srh_2022_VO search_2022_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye161005_2022_DAO.selectYeta7400ToYe161005ListTotCnt_S", search_2022_VO);
    }
    
    
    /**
	 * YE161005?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161005_2022_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYeta7400ToYe161005(Ye161005_2022_VO vo) throws Exception {
        update("ye161005_2022_DAO.updateYeta7400ToYe161005_S", vo);
    }
  
    
}
