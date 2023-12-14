package com.app.smrmf.pkg.insr.insurance.service;

import java.util.List;

import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3300VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr4200VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr5200VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO;

/**
 * 
 * @Class Name : Payr0305Service.java
 * @Description : Payr0305 Business class
 *                소득세/지방소득세를 계산하여 저장하는 인터페이스 함수 
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface PkgInsrService {
	 
	 
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
     * @param searchVO
     * @return
     * @throws Exception
     */
    List  select4InsureDataList(InfcPkgPayr0250VO searchVO) throws Exception;
    
    PkgInsrAmntVO  select4InsureDataAmnt(InfcPkgPayr0250VO searchVO) throws Exception;
    
    void updatePayrToInsr3300(InfcPkgInsr3300VO vo) throws Exception;  
    
    void updatePayCancelInsr3300(InfcPkgInsr3300VO vo) throws Exception; 
     
    void updatePayrToInsr4200(InfcPkgInsr4200VO vo) throws Exception;  
    
    void updatePayCancelInsr4200(InfcPkgInsr4200VO vo) throws Exception; 
    
    void updatePayrToInsr5200(InfcPkgInsr5200VO vo) throws Exception;  
    
    void updatePayCancelInsr5200(InfcPkgInsr5200VO vo) throws Exception; 
    
    /**
     * 
     * <pre>
     * 1. 개요 : 
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
    PkgInsrAmntVO selectPyar4200ToInsr(PkgInsrAmntVO searchVO) throws Exception ;
}
