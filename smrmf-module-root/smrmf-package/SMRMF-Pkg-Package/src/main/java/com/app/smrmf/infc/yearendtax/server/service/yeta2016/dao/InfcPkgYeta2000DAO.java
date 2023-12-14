package com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;

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

@Repository("InfcPkgYeta2000DAO")
public class InfcPkgYeta2000DAO extends EgovAbstractDAO {
	
	
	/**
	 * 연말정산 기본정보를 생성한다.  
	 * @param vo - 등록할 정보가 담긴 Yeta2000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String fnYeta1100_YETA2000_2016_CREATE_Insert(InfcPkgYeta2000VO vo) throws Exception {
        return (String)insert("infcPkgYeta2000DAO.fnYeta1100_YETA2000_2016_CREATE_Insert_S", vo);
    }	
	
	// 연말정산 급여이관 시 업데이트
	@Transactional
	public void fnYeta1100_YETA2000_PAYR_2016_CREATE_Update(InfcPkgYe160401VO yePrc160401Vo) throws Exception {
       update("infcPkgYeta2000DAO.fnYeta1100_YETA2000_PAYR_2016_CREATE_Update", yePrc160401Vo);
   }	
	
	  
	
	

	/**
	 * YETA2000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta2000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta2000(InfcPkgYeta2000VO vo) throws Exception {
        return (String)insert("infcPkgYeta2000DAO.insertYetaPrc2000_S", vo);
    }

	/**
	 * 연말정산 기본정보를 생성한다.  
	 * @param vo - 등록할 정보가 담긴 Yeta2000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String fnPayr06420_PAYR415_2014_CREATE_Insert(InfcPkgYeta2000VO vo) throws Exception {
        return (String)insert("infcPkgYeta2000DAO.fnPayr06420_PAYR415_2014_CREATE_Insert_S", vo);
    }
     
    /**
	 * YETA2000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta2000VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta2000(InfcPkgYeta2000VO vo) throws Exception {
        update("infcPkgYeta2000DAO.updateYetaPrc2000_S", vo);
    }
	  @Transactional
    public void fnPayr06425_PAYR415_0_2015_Update(InfcPkgYeta2000VO vo) throws Exception {
        update("infcPkgYeta2000DAO.fnPayr06425_PAYR415_0_2015_Update", vo);
    }
	  @Transactional
    public void fnPayr06425_PAYR415_2016_Update(InfcPkgYeta2000VO vo) throws Exception {
        update("infcPkgYeta2000DAO.fnPayr06425_PAYR415_2015_Update", vo);
    } 
	  @Transactional
   public void fnPayr06425_Payr415_2016_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_Payr415_2016_Update", vo);
   } 
	  @Transactional
   public void fnPayr06425_JrtrAnsv_2016_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_JrtrAnsv_2016_Update", vo);
   } 
	  @Transactional
   public void fnPayr06425_JrtrCict_2016_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_JrtrCict_2016_Update", vo);
   }
	  @Transactional
   public void fnPayr06425_PAYR415_spciRefn_2016_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_PAYR415_spciRefn_2016_Update", vo);
   }   
    
	  @Transactional
   public void fnPayr06425_PAYR415_2016_01_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_01_Update", vo);
   }  
	  @Transactional
   public void fnPayr06425_PAYR415_2016_02_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_02_Update", vo);
   }  
	  @Transactional 
   public void fnPayr06425_PAYR415_2016_03_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_03_Update", vo);
   }    
	  @Transactional
   public void fnPayr06425_PAYR415_2016_04_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_04_Update", vo);
   }
	  @Transactional
   public void fnPayr06425_PAYR415_2016_05_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_05_Update", vo);
   }     
	  @Transactional
   public void fnPayr06425_PAYR415_2016_06_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_06_Update", vo);
   }   
	  @Transactional
   public void fnPayr06425_PAYR415_2016_07_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_07_Update", vo);
   }  
	  @Transactional
   public void fnPayr06425_PAYR415_2016_08_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_08_Update", vo);
   }  
	  @Transactional
   public void fnPayr06425_PAYR415_2016_10_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_10_Update", vo);
   } 
	  @Transactional
   public void fnPayr06425_PAYR415_2016_11_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_11_Update", vo);
   } 
	  @Transactional
   public void fnPayr06425_PAYR415_2016_12_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_12_Update", vo);
   } 
	  @Transactional 
   public void fnPayr06425_PAYR415_2016_13_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_13_Update", vo);
   }
	  @Transactional
   public void fnPayr06425_PAYR415_2016_14_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_14_Update", vo);
   }
	  
	  @Transactional
   public void fnPayr06425_PAYR415_2016_15_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_15_Update", vo);
   }
	  
	  @Transactional
   public void fnPayr06425_PAYR415_2016_16_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_16_Update", vo);
   }
	  @Transactional
   public void fnPayr06520_PAYR415_2015_CREATE1_Update(InfcPkgYeta2000VO vo) throws Exception {
       update("infcPkgYeta2000DAO.fnPayr06520_PAYR415_2015_CREATE1_Update", vo);
   }
	  
   
    /**
	 * YETA2000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta2000VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta2000(InfcPkgYeta2000VO vo) throws Exception {
        delete("infcPkgYeta2000DAO.deleteYetaPrc2000_S", vo);
    }
    /**
	 * YETA2000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta2000VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06420_PAYR415_CREATE_Delete(InfcPkgYeta2000VO vo) throws Exception {
        delete("infcPkgYeta2000DAO.fnPayr06420_PAYR415_CREATE_Delete_S", vo);
    }  
    

    /**
	 * YETA2000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta2000VO
	 * @return 조회한 YETA2000
	 * @exception Exception
	 */
    public InfcPkgYeta2000VO selectYeta2000(InfcPkgYeta2000VO vo) throws Exception {
        return (InfcPkgYeta2000VO) selectByPk("infcPkgYeta2000DAO.selectYetaPrc2000_S", vo);
    }

    /**
	 * YETA2000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA2000 목록
	 * @exception Exception
	 */
    public List<?> selectYeta2000List(InfcPkgYeta2000SrhVO searchVO) throws Exception {
        return list("infcPkgYeta2000DAO.selectYetaPrc2000List_D", searchVO);
    }

    /**
	 * YETA2000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA2000 총 갯수
	 * @exception
	 */
    public int selectYeta2000ListTotCnt(InfcPkgYeta2000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYeta2000DAO.selectYetaPrc2000ListTotCnt_S", searchVO);
    }

}
