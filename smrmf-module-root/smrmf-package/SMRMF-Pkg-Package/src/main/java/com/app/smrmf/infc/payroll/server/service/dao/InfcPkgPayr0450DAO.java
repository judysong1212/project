package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0450SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0450VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0450DAO.java
 * @Description : Payr0450 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.12.02
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPayr0450DAO")
public class InfcPkgPayr0450DAO extends EgovAbstractDAO {

 
    public String insertPayr0450(InfcPkgPayr0450VO vo) throws Exception {
        return (String)insert("infcPkgPayr0450DAO.insertPayr0450_S", vo);
    }

   
    public void updatePayr0450(InfcPkgPayr0450VO vo) throws Exception {
        update("infcPkgPayr0450DAO.updatePayr0450_S", vo);
    }
 
    public void deletePayr0450(InfcPkgPayr0450VO vo) throws Exception {
        delete("infcPkgPayr0450DAO.deletePayr0450_S", vo);
    }

     
    public InfcPkgPayr0450VO selectPayr0450(InfcPkgPayr0450VO vo) throws Exception {
        return (InfcPkgPayr0450VO) selectByPk("infcPkgPayr0450DAO.selectPayr0450_S", vo);
    }
     
    public List<?> selectPayr0450List(InfcPkgPayr0450SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0450DAO.selectPayr0450List_D", searchVO);
    }
 
    public int selectPayr0450ListTotCnt(InfcPkgPayr0450SrhVO searchVO) {
        return  (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0450DAO.selectPayr0450ListTotCnt_S", searchVO);
    }
    
    /**
     * 
     * <pre>
     * 1. 개요 :  정근수당  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : selectPayr0450ToC9030100
     * @date : 2017. 5. 18.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 5. 18.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @return
     * @throws Exception
     */
    public InfcPkgPayr0450VO selectPayr0450ToC9030100(InfcPkgPayr0450VO vo) throws Exception {
        return (InfcPkgPayr0450VO) selectByPk("infcPkgPayr0450DAO.selectPayr0450ToC9030100_S", vo);
    } 
    
    /**
     * 
     * <pre>
     * 1. 개요 :  근속가산금  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : selectPayr0450ToC9010100
     * @date : 2017. 5. 18.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 5. 18.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @return
     * @throws Exception
     */
    public InfcPkgPayr0450VO selectPayr0450ToC9010100(InfcPkgPayr0450VO vo) throws Exception {
        return (InfcPkgPayr0450VO) selectByPk("infcPkgPayr0450DAO.selectPayr0450ToC9010100_S", vo);
    } 
    public InfcPkgPayr0450VO selectPayr0450ToC9010400(InfcPkgPayr0450VO vo) throws Exception {
        return (InfcPkgPayr0450VO) selectByPk("infcPkgPayr0450DAO.selectPayr0450ToC9010400_S", vo);
    }  
    

} 
