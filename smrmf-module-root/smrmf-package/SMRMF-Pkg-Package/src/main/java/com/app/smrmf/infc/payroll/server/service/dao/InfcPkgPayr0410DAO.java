package com.app.smrmf.infc.payroll.server.service.dao;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0410VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0400DAO.java
 * @Description : Payr0400 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPayr0410DAO")
public class InfcPkgPayr0410DAO extends EgovAbstractDAO {

	  
    /**
	 * PAYR0400을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0400VO
	 * @return 조회한 PAYR0400
	 * @exception Exception
	 */
    public InfcPkgPayr0410VO selectPayr0410ToPayrCalcList(InfcPkgPayr0410VO vo) throws Exception {
        return (InfcPkgPayr0410VO) selectByPk("infcPkgPayr0410DAO.selectPayr0410ToPayrCalcList_S", vo);
    }
 
}
