package com.app.smrmf.infc.insurance.server.service.dao;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3300VO;
import com.app.smrmf.pkg.insr.insurance.service.PkgInsrAmntVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr3300DAO.java
 * @Description : Insr3300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgInsr3300DAO")
public class InfcPkgInsr3300DAO extends EgovAbstractDAO {
 

    /**
     * 
     * <pre>
     * 1. 개요 : 
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
     * @param vo
     * @throws Exception
     */
    public void updatePayrToInsr3300(InfcPkgInsr3300VO vo) throws Exception {
        update("infcPkgInsr3300DAO.updatePayrToInsr3300", vo);
    }
    
    
    /**
     * 
     * <pre>
     * 1. 개요 : 
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
     * @param vo
     * @throws Exception
     */
    public void updatePayCancelInsr3300(InfcPkgInsr3300VO vo) throws Exception {
        update("infcPkgInsr3300DAO.updatePayCancelInsr3300", vo);
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
    	  return (PkgInsrAmntVO) selectByPk("infcPkgInsr3300DAO.selectPyar4200ToInsr_S", searchVO); 
    	   
    }  
}