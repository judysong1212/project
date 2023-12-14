package com.app.smrmf.pkg.proc.payr.pay.calculation.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0100VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3100SrhVO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3100VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0300VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0302VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0305VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010VO;
import com.app.smrmf.pkg.payr.payrcalc.service.PkgPayrCommCalcVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0500DAO.java
 * @Description : Payr0500 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PayCalculationDAO")
public class PayCalculationDAO extends EgovAbstractDAO {
 
    //인사.급여기본정보를 가져온다.
    public List<PkgPayrCommCalcVO> selectPsnlPayrInfoList(InfcPkgPayr0250VO searchVO) throws Exception {
        return (List<PkgPayrCommCalcVO>)list("payCalculationDAO.selectPsnlPayrInfoList_D", searchVO);
    }
      
    
    public List<PkgPayrCommCalcVO> selectPsnlA20PayrInfoList(InfcPkgPayr0250VO searchVO) throws Exception {
        return (List<PkgPayrCommCalcVO>)list("payCalculationDAO.selectPsnlA20PayrInfoList_D", searchVO);
    }  
     

    /**
	 * PAYR0300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0300VO
	 * @return 조회한 PAYR0300
	 * @exception Exception
	 */
    public InfcPkgPayr0300VO selectPayr0300(InfcPkgPayr0300VO vo) throws Exception {
        return (InfcPkgPayr0300VO) selectByPk("payCalculationDAO.selectPayr0300_S", vo);
    }
    
    /**
	 * INSR0200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr0200VO
	 * @return 조회한 INSR0200
	 * @exception Exception
	 */
    public InfcPkgInsr3100VO selectInsr0200Data(InfcPkgInsr3100SrhVO  infcInsr3100SrhVO) throws Exception {
        return (InfcPkgInsr3100VO) selectByPk("payCalculationDAO.selectInsr0200_S", infcInsr3100SrhVO);
    } 
    
    /**
	 * INSR0200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr0200VO
	 * @return 조회한 INSR0200
	 * @exception Exception
	 */
    public InfcPkgYeta2000VO seletYeta2000Data(InfcPkgYeta2000SrhVO vo) throws Exception {
        return (InfcPkgYeta2000VO) selectByPk("payCalculationDAO.seletYeta2000Data_S", vo);
    } 
    
    @Transactional
    public void updateYeta2000(InfcPkgYeta2000VO vo) throws Exception {
      update("payCalculationDAO.updatePayCalYeta2000_S", vo);
    } 
    

    public InfcPkgYe169010VO seletYeta2017ToPayrData(InfcPkgYe161010SrhVO    infcPkgYe161010SrhVo) throws Exception {
 		return (InfcPkgYe169010VO) selectByPk("payCalculationDAO.seletYeta2017ToPayrData_S", infcPkgYe161010SrhVo);
     }  
     
 	@Transactional
 	public void updateYeta2017ToYe161010(InfcPkgYe161010VO    infcPkgYe161010Vo) throws Exception {
 	update("payCalculationDAO.updateYeta2017ToYe161010_S", infcPkgYe161010Vo);
 	} 
     
      /**
       * 
       * <pre>
       * 1. 개요 :  김해시청 기말수당 값 가져오는 쿼리  
       * 2. 처리내용 : 
       * </pre>
       * @Method Name : selectGHPayr0302C9020100
       * @date : 2016. 6. 15.
       * @author : Administrator
       * @history : 
       *	-----------------------------------------------------------------------
       *	변경일				작성자						변경내용  
       *	----------- ------------------- ---------------------------------------
       *	2016. 6. 15.		Administrator				최초 작성 
       *	-----------------------------------------------------------------------
       * 
       * @param vo
       * @return
       * @throws Exception
       */
	   public InfcPkgPayr0302VO selectGHPayr0302C9020100(InfcPkgPayr0302VO vo) throws Exception {
	        return (InfcPkgPayr0302VO) selectByPk("payCalculationDAO.selectGHPayr0302C9020100_S", vo);
	    }

	   public InfcPkgDlgn0100VO selectADDlgn0100C9020100(InfcPkgDlgn0100VO vo) throws Exception {
	        return (InfcPkgDlgn0100VO) selectByPk("payCalculationDAO.selectADDlgn0100C9020100_S", vo);
	    }
	   
	   
	   public InfcPkgPayr0305VO selectPayr0302T0010100(InfcPkgPayr0305VO  payr0305Vo) throws Exception {
	        return (InfcPkgPayr0305VO) selectByPk("payCalculationDAO.selectPayr0302T0010100_S", payr0305Vo);
	    }
	   
	   
	    public List selectPayr0302ToPayr301CalcList(InfcPkgPayr0302VO vo) throws Exception {
	        return list("payCalculationDAO.selectPayr0302ToPayr301CalcList_D", vo); 
	    }      
}
