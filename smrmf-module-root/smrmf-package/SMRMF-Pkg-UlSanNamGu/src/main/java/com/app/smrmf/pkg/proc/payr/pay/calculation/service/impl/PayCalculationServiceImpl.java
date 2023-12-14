package com.app.smrmf.pkg.proc.payr.pay.calculation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.app.smrmf.pkg.proc.payr.pay.calculation.service.PayCalculationService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : Payr0305ServiceImpl.java
 * @Description : Payr0305 Business Implement class
 *                 급여계산 결과 저장 
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("PayCalculationService")
public class PayCalculationServiceImpl extends AbstractServiceImpl implements  PayCalculationService {
 

	//인사급여 대상자 정보를 가져온다.
	@Autowired
    @Resource(name="PayCalculationDAO")
    private PayCalculationDAO payCalculationDAO;
	
	  
//	//근로소득간이세액표산출
//	@Autowired
//    @Resource(name="Payr0305DAO")
//    private Payr0305DAO payr0305DAO;
	
	
    /** ID Generation */
    //@Resource(name="{egovPayCalculationIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	//급여 - 인사정보(무기계약직)
	 public List<PkgPayrCommCalcVO> selectPsnlPayrInfoList(InfcPkgPayr0250VO vo) throws Exception {
		 
		 return payCalculationDAO.selectPsnlPayrInfoList(vo);
		 
	 }
	 
	
      
      public InfcPkgPayr0302VO selectGHPayr0302C9020100(InfcPkgPayr0302VO vo) throws Exception {
    	  InfcPkgPayr0302VO resultVO = payCalculationDAO.selectGHPayr0302C9020100(vo);
    	     // if (resultVO == null)
    	     //     throw processException("info.nodata.msg");
    	      return resultVO;
	    }
      
	   
	  
	 
	 public List<PkgPayrCommCalcVO> selectPsnlA20PayrInfoList(InfcPkgPayr0250VO vo) throws Exception {
	         
	         return payCalculationDAO.selectPsnlA20PayrInfoList(vo);
	         
	 } 
 
	   

    /**
	 * INSR0200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr0200VO
	 * @return 조회한 INSR0200
	 * @exception Exception
	 */
    public InfcPkgInsr3100VO selectInsr0200Data(InfcPkgInsr3100SrhVO  infcInsr3100SrhVO) throws Exception {
    	InfcPkgInsr3100VO resultVO = payCalculationDAO.selectInsr0200Data(infcInsr3100SrhVO);
       // if (resultVO == null)
       //     throw processException("info.nodata.msg");
        return resultVO;
    }
    
    
    public InfcPkgYeta2000VO seletYeta2000Data(InfcPkgYeta2000SrhVO  infcYeta2000SrhVO) throws Exception {
    	InfcPkgYeta2000VO resultVO = payCalculationDAO.seletYeta2000Data(infcYeta2000SrhVO);
       // if (resultVO == null)
       //     throw processException("info.nodata.msg");
        return resultVO;
    }
	  
	  
		 
	
	    /**
	     *  
	     * <pre>
	     * 1. 개요 : 급여 반영 후 연말정산 업데이트  
	     * 2. 처리내용 : 
	     * </pre>
	     * @Method Name : updateYeta2000
	     * @date : Mar 16, 2016
	     * @author : leeheuisung
	     * @history : 
	     *	-----------------------------------------------------------------------
	     *	변경일				작성자						변경내용  
	     *	----------- ------------------- ---------------------------------------
	     *	Mar 16, 2016		leeheuisung				최초 작성 
	     *	-----------------------------------------------------------------------
	     * 
	     * @see com.app.smrmf.payr.pay.calculation.service.PayCalculationService#updateYeta2000(com.app.smrmf.infc.yearendtax.vo.InfcPkgYeta2000VO)
	     * @param vo
	     * @throws Exception
	     */
	    public void updateYeta2000(InfcPkgYeta2000VO vo) throws Exception {
	    	payCalculationDAO.updateYeta2000(vo);
	    }
	   
	    public InfcPkgYe169010VO seletYeta2017ToPayrData(InfcPkgYe161010SrhVO    infcPkgYe161010SrhVo) throws Exception {
	    	InfcPkgYe169010VO resultVO = payCalculationDAO.seletYeta2017ToPayrData(infcPkgYe161010SrhVo);
	       // if (resultVO == null)
	       //     throw processException("info.nodata.msg");
	        return resultVO;
	    }


	    public void updateYeta2017ToYe161010(InfcPkgYe161010VO    infcPkgYe161010Vo) throws Exception {
		    	payCalculationDAO.updateYeta2017ToYe161010(infcPkgYe161010Vo);
		    }
	    /**
		 * PAYR0300을 조회한다.
		 * @param vo - 조회할 정보가 담긴 Payr0300VO
		 * @return 조회한 PAYR0300
		 * @exception Exception
		 */
	    public InfcPkgPayr0300VO selectPayr0300(InfcPkgPayr0300VO vo) throws Exception {
	        return (InfcPkgPayr0300VO) payCalculationDAO.selectPayr0300(vo);
	    }
	

	    
public List selectPayr0302ToPayr301CalcList(InfcPkgPayr0302VO searchVO) throws Exception {
    return payCalculationDAO.selectPayr0302ToPayr301CalcList(searchVO);
}	     

public InfcPkgPayr0305VO selectPayr0302T0010100(InfcPkgPayr0305VO  payr0305Vo) throws Exception {
	InfcPkgPayr0305VO resultVO = payCalculationDAO.selectPayr0302T0010100(payr0305Vo);
	     // if (resultVO == null)
	     //     throw processException("info.nodata.msg");
	      return resultVO;
}    

   
}
