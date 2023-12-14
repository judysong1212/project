package com.app.smrmf.pkg.proc.remt.retirement.payr.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0410VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2000SrhVO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.Remt0100DlgnVO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.RemtLogSvcDysVO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.RemtPayr0302SrhVO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.RemtPsnl0100SrhVO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.RemtPsnl0100VO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.RemtWfep0100VO;

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

@Repository("RetirementPayrDAO")
public class RetirementPayrDAO extends EgovAbstractDAO {
 

    /**
  	 * 퇴직정산대상자의 기본정보를 불러온다. 
  	 * @param vo - 조회할 정보가 담긴 Remt2000VO
  	 * @return 조회한 REMT2000
  	 * @exception Exception
  	 */ 
      public RemtPsnl0100VO selectRemt0100ToPsnl0100(RemtPsnl0100SrhVO vo)  throws Exception {
          return (RemtPsnl0100VO) selectByPk("retirementPayrDAO.selectRemt0100ToPsnl0100_S", vo);
      }
      
      
      public RemtLogSvcDysVO selectLogSvcDys(RemtLogSvcDysVO vo)  throws Exception {
          return (RemtLogSvcDysVO) selectByPk("retirementPayrDAO.selectLogSvcDys_S", vo);
      } 

      public List<InfcPkgPayr0410VO> selectRemt0100ToPayr4100List( InfcPkgRemt2000SrhVO infcRemt2000SrhVo) throws Exception {
      	 return list("retirementPayrDAO.selectRemt0100ToPayr4100List_D", infcRemt2000SrhVo);
      }
      
      public List<RemtWfep0100VO> selectRemtWfep0100List( RemtPayr0302SrhVO  remtPayr0302SrhVo)   throws Exception {
    	  return list("retirementPayrDAO.selectRemtWfep0100List_D", remtPayr0302SrhVo);
      }

      
      public Remt0100DlgnVO selectRemt0100Dlgn(Remt0100DlgnVO remt0100DlgnVo)  throws Exception {
          return (Remt0100DlgnVO) selectByPk("retirementPayrDAO.selectRemt0100Dlgn_S", remt0100DlgnVo);
      } 
      
      public List<?> selectRemt0100ToPayr0302List(RemtPayr0302SrhVO  remtPayr0302SrhVo)  throws Exception {
    	  return list("retirementPayrDAO.selectRemt0100ToPayr0302List_D", remtPayr0302SrhVo);
      } 
      
       
}
