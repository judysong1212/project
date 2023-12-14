package com.app.smrmf.pkg.insr.insurance.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.insurance.server.service.dao.InfcPkgInsr0240DAO;
import com.app.smrmf.infc.insurance.server.service.dao.InfcPkgInsr3300DAO;
import com.app.smrmf.infc.insurance.server.service.dao.InfcPkgInsr4200DAO;
import com.app.smrmf.infc.insurance.server.service.dao.InfcPkgInsr5200DAO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3300VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr4200VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr5200VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO;
import com.app.smrmf.pkg.insr.insurance.service.PkgInsrAmntVO;
import com.app.smrmf.pkg.insr.insurance.service.PkgInsrService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : Payr0305ServiceImpl.java
 * @Description : Payr0305 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("PkgInsrService")
public class PkgInsrServiceImpl extends AbstractServiceImpl implements  PkgInsrService {

 
    //4대보험이력 
    @Autowired
    @Resource(name="InfcPkgInsr0240DAO")
    private InfcPkgInsr0240DAO insr0240DAO; 
  
    
    @Autowired
    @Resource(name="InfcPkgInsr3300DAO")
    private InfcPkgInsr3300DAO insr3300DAO; 
    
    
    @Autowired
    @Resource(name="InfcPkgInsr4200DAO")
    private InfcPkgInsr4200DAO insr4200DAO; 
    
    
    @Autowired
    @Resource(name="InfcPkgInsr5200DAO")
    private InfcPkgInsr5200DAO insr5200DAO; 
    
    
    /** ID Generation */
    //@Resource(name="{egovPayr0305IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService; 
 
    
   /**
    * 
    * <pre>
    * 1. 개요 : 
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : select4InsureDataList
    * @date : 2016. 12. 24.
    * @author : atres-pc
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	2016. 12. 24.		atres-pc				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @see com.app.smrmf.pkg.insr.insurance.service.PkgInsrService#select4InsureDataList(com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO)
    * @param vo
    * @return
    * @throws Exception
    */
	 public List  select4InsureDataList(InfcPkgPayr0250VO vo) throws Exception {
		 
		 return insr0240DAO.select4InsureDataList(vo);
		 
	 } 
	 
     public PkgInsrAmntVO  select4InsureDataAmnt(InfcPkgPayr0250VO vo) throws Exception {
		 
		 return (PkgInsrAmntVO)insr0240DAO.select4InsureDataAmnt(vo);
		 
	 } 
     
     /**
      * 
      * <pre>
      * 1. 개요 : 급여 계산 처리후 작업  
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : updatePayrToInsr3300
      * @date : 2017. 4. 11.
      * @author : paygen
      * @history : 
      *	-----------------------------------------------------------------------
      *	변경일				작성자						변경내용  
      *	----------- ------------------- ---------------------------------------
      *	2017. 4. 11.		paygen				최초 작성 
      *	-----------------------------------------------------------------------
      * 
      * @see com.app.smrmf.pkg.insr.insurance.service.PkgInsrService#updatePayrToInsr3300(com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3300VO)
      * @param vo
      * @throws Exception
      */
     public void updatePayrToInsr3300(InfcPkgInsr3300VO vo) throws Exception {
    	 insr3300DAO.updatePayrToInsr3300(vo);
     }
     
     /**
      *  
      * <pre>
      * 1. 개요 : 급여조정에서 대상자 삭제시 초기화 작업 건간보험처리 안함으로 제외 처리  
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : updatePayCancelInsr3300
      * @date : 2017. 4. 11.
      * @author : paygen
      * @history : 
      *	-----------------------------------------------------------------------
      *	변경일				작성자						변경내용  
      *	----------- ------------------- ---------------------------------------
      *	2017. 4. 11.		paygen				최초 작성 
      *	-----------------------------------------------------------------------
      * 
      * @see com.app.smrmf.pkg.insr.insurance.service.PkgInsrService#updatePayCancelInsr3300(com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3300VO)
      * @param vo
      * @throws Exception
      */
     public void updatePayCancelInsr3300(InfcPkgInsr3300VO vo) throws Exception {
    	 insr3300DAO.updatePayCancelInsr3300(vo);
     }
     
     
     /**
      * 
      * <pre>
      * 1. 개요 : 급여 계산 처리후 작업  
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : updatePayrToInsr3300
      * @date : 2017. 4. 11.
      * @author : paygen
      * @history : 
      *	-----------------------------------------------------------------------
      *	변경일				작성자						변경내용  
      *	----------- ------------------- ---------------------------------------
      *	2017. 4. 11.		paygen				최초 작성 
      *	-----------------------------------------------------------------------
      * 
      * @see com.app.smrmf.pkg.insr.insurance.service.PkgInsrService#updatePayrToInsr3300(com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3300VO)
      * @param vo
      * @throws Exception
      */
     public void updatePayrToInsr4200(InfcPkgInsr4200VO vo) throws Exception {
    	 insr4200DAO.updatePayrToInsr4200(vo);
     }
     
     /**
      *  
      * <pre>
      * 1. 개요 : 급여조정에서 대상자 삭제시 초기화 작업 건간보험처리 안함으로 제외 처리  
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : updatePayCancelInsr3300
      * @date : 2017. 4. 11.
      * @author : paygen
      * @history : 
      *	-----------------------------------------------------------------------
      *	변경일				작성자						변경내용  
      *	----------- ------------------- ---------------------------------------
      *	2017. 4. 11.		paygen				최초 작성 
      *	-----------------------------------------------------------------------
      * 
      * @see com.app.smrmf.pkg.insr.insurance.service.PkgInsrService#updatePayCancelInsr3300(com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3300VO)
      * @param vo
      * @throws Exception
      */
     public void updatePayCancelInsr4200(InfcPkgInsr4200VO vo) throws Exception {
    	 insr4200DAO.updatePayCancelInsr4200(vo);
     }
     
     
     
     /**
      * 
      * <pre>
      * 1. 개요 : 급여 계산 처리후 작업  
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : updatePayrToInsr3300
      * @date : 2017. 4. 11.
      * @author : paygen
      * @history : 
      *	-----------------------------------------------------------------------
      *	변경일				작성자						변경내용  
      *	----------- ------------------- ---------------------------------------
      *	2017. 4. 11.		paygen				최초 작성 
      *	-----------------------------------------------------------------------
      * 
      * @see com.app.smrmf.pkg.insr.insurance.service.PkgInsrService#updatePayrToInsr3300(com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3300VO)
      * @param vo
      * @throws Exception
      */
     public void updatePayrToInsr5200(InfcPkgInsr5200VO vo) throws Exception {
    	 insr5200DAO.updatePayrToInsr5200(vo);
     }
     
     /**
      *  
      * <pre>
      * 1. 개요 : 급여조정에서 대상자 삭제시 초기화 작업 건간보험처리 안함으로 제외 처리  
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : updatePayCancelInsr3300
      * @date : 2017. 4. 11.
      * @author : paygen
      * @history : 
      *	-----------------------------------------------------------------------
      *	변경일				작성자						변경내용  
      *	----------- ------------------- ---------------------------------------
      *	2017. 4. 11.		paygen				최초 작성 
      *	-----------------------------------------------------------------------
      * 
      * @see com.app.smrmf.pkg.insr.insurance.service.PkgInsrService#updatePayCancelInsr3300(com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3300VO)
      * @param vo
      * @throws Exception
      */
     public void updatePayCancelInsr5200(InfcPkgInsr5200VO vo) throws Exception {
    	 insr5200DAO.updatePayCancelInsr5200(vo);
     }
     
     
     /**
      * 
      * <pre>
      * 1. 개요 : 금액처리을 위한 값이 있는지여부 판단하여 메서드 호출 수행 
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : selectPyar4200ToInsr
      * @date : 2017. 4. 11.
      * @author : paygen
      * @history : 
      *	-----------------------------------------------------------------------
      *	변경일				작성자						변경내용  
      *	----------- ------------------- ---------------------------------------
      *	2017. 4. 11.		paygen				최초 작성 
      *	-----------------------------------------------------------------------
      * 
      * @param searchVO
      * @return
      * @throws Exception
      */
     public PkgInsrAmntVO selectPyar4200ToInsr(PkgInsrAmntVO searchVO) throws Exception {
     	  return (PkgInsrAmntVO) insr3300DAO.selectPyar4200ToInsr(searchVO);  
     	   
     }  
    
}
