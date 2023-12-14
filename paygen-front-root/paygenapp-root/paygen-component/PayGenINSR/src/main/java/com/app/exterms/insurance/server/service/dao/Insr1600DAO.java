package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr1550SrhVO;
import com.app.exterms.insurance.server.vo.Insr1600VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;


/**
 * @Class Name : Insr1600DAO.java
 * @Description : Insr1600 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr1600DAO")
public class Insr1600DAO extends EgovAbstractDAO {
	
    public void insertInsr1500(Insr1600VO vo) throws Exception {
       insert("insr1600DAO.insertInsr1600_S", vo);
    }
    
	public int selectInsr1600Check(Insr1600VO vo) throws Exception {
        return (Integer) getSqlMapClientTemplate().queryForObject("insr1600DAO.selectInsr1600CheckCnt_S", vo);
    }
	
    public void updateInsr1600(Insr1600VO vo) throws Exception {
        insert("insr1600DAO.updateInsr1600_S", vo);
     }
    
    public List<EgovMap>  selectXlsInsr1600List(Insr1550SrhVO searchVO) throws Exception {
		return list("insr1600DAO.selectXlsInsr1600List_D", searchVO);
	}
    
    public void updateXlsInsr2150ToInsr1600(Insr1600VO vo) throws Exception {
        update("insr1600DAO.updateXlsInsr2150ToInsr1600_S", vo);
    }
    
    public void deleteInsr1600(Insr1600VO vo) throws Exception {
        delete("insr1600DAO.deleteInsr1600_S", vo);
    }
}
