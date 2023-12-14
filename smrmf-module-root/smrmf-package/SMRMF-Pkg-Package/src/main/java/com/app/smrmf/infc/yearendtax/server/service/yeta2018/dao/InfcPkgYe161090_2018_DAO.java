package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161090Srh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161090_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe164010_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161090_2018_DAO.java
 * @Description : Ye161090 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe161090_2018_DAO")
public class InfcPkgYe161090_2018_DAO extends EgovAbstractDAO {

	
	//교육비 
	@Transactional
    public String PdfYeta3200_C101Y_YE161090_Insert(InfcPkgYe161090_2018_VO infcPkgYe161090Vo) throws Exception {
        return (String)insert("infcPkgYe161090_2018_DAO.PdfYeta3200_C101Y_YE161090_Insert_S", infcPkgYe161090Vo);
    }
	
	
	@Transactional
    public String PdfYeta3200_C101Y_YE161090_Delete(InfcPkgYe161090_2018_VO infcPkgYe161090Vo) throws Exception {
           delete("infcPkgYe161090_2018_DAO.PdfYeta3200_C101Y_YE161090_Delete_S", infcPkgYe161090Vo);
           
           return "";
    }
	
	
	//직업훈련비 
		@Transactional
	    public String PdfYeta3200_C202Y_YE161090_Insert(InfcPkgYe161090_2018_VO infcPkgYe161090Vo) throws Exception {
	        return (String)insert("infcPkgYe161090_2018_DAO.PdfYeta3200_C202Y_YE161090_Insert_S", infcPkgYe161090Vo);
	    }
		
		
		@Transactional
	    public String PdfYeta3200_C202Y_YE161090_Delete(InfcPkgYe161090_2018_VO infcPkgYe161090Vo) throws Exception {
	           delete("infcPkgYe161090_2018_DAO.PdfYeta3200_C202Y_YE161090_Delete_S", infcPkgYe161090Vo);
	           
	           return "";
	    }
	
		
		//교복구입비 
				@Transactional
			    public String PdfYeta3200_C301Y_YE161090_Insert(InfcPkgYe161090_2018_VO infcPkgYe161090Vo) throws Exception {
			        return (String)insert("infcPkgYe161090_2018_DAO.PdfYeta3200_C301Y_YE161090_Insert_S", infcPkgYe161090Vo);
			    }
				
				
				@Transactional
			    public String PdfYeta3200_C301Y_YE161090_Delete(InfcPkgYe161090_2018_VO infcPkgYe161090Vo) throws Exception {
			           delete("infcPkgYe161090_2018_DAO.PdfYeta3200_C301Y_YE161090_Delete_S", infcPkgYe161090Vo);
			           
			           return "";
			    }
				

				//학자금대출 
						@Transactional
					    public String PdfYeta3200_C401Y_YE161090_Insert(InfcPkgYe161090_2018_VO infcPkgYe161090Vo) throws Exception {
					        return (String)insert("infcPkgYe161090_2018_DAO.PdfYeta3200_C401Y_YE161090_Insert_S", infcPkgYe161090Vo);
					    }
						
						
						@Transactional
					    public String PdfYeta3200_C401Y_YE161090_Delete(InfcPkgYe161090_2018_VO infcPkgYe161090Vo) throws Exception {
					           delete("infcPkgYe161090_2018_DAO.PdfYeta3200_C401Y_YE161090_Delete_S", infcPkgYe161090Vo);
					           
					           return "";
					    }			
			
	 
	
	
	/**
	 * YE161090?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161090VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161090(InfcPkgYe161090_2018_VO vo) throws Exception {
        return (String)insert("infcPkgYe161090_2018_DAO.insertYe161090_S", vo);
    }

    /**
	 * YE161090?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161090VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161090(InfcPkgYe161090_2018_VO vo) throws Exception {
        update("infcPkgYe161090_2018_DAO.updateYe161090_S", vo);
    }

    /**
	 * YE161090?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161090VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161090(InfcPkgYe161090_2018_VO vo) throws Exception {
        delete("infcPkgYe161090_2018_DAO.deleteYe161090_S", vo);
    }

    /**
	 * YE161090?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161090VO
	 * @return 조회?�� YE161090
	 * @exception Exception
	 */
    public InfcPkgYe161090_2018_VO selectYe161090(InfcPkgYe161090_2018_VO vo) throws Exception {
        return (InfcPkgYe161090_2018_VO) selectByPk("infcPkgYe161090_2018_DAO.selectYe161090_S", vo);
    }

    /**
	 * YE161090 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161090 목록
	 * @exception Exception
	 */
    public List<?> selectYe161090List(InfcPkgYe161090Srh_2018_VO searchVO) throws Exception {
        return list("infcPkgYe161090_2018_DAO.selectYe161090List_D", searchVO);
    }

    /**
	 * YE161090 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161090 �? �??��
	 * @exception
	 */
    public int selectYe161090ListTotCnt(InfcPkgYe161090Srh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe161090_2018_DAO.selectYe161090ListTotCnt_S", searchVO);
    }

}
