package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr1500SrhVO;
import com.app.exterms.insurance.server.vo.Insr1500VO;
import com.app.exterms.insurance.server.vo.Insr1550SrhVO;
import com.app.exterms.insurance.server.vo.Insr1550VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;


/**
 * @Class Name : Insr1500DAO.java
 * @Description : Insr1500 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr1500DAO")
public class Insr1500DAO extends EgovAbstractDAO {
	
	public int selectInsrP210001ToInsr1500ListTotCnt(Insr1550SrhVO searchVO) {
		return (Integer)getSqlMapClientTemplate().queryForObject("insr1500DAO.selectInsrP210001ToInsr1500ListTotCnt_S", searchVO);
	}
       
	public List<?> selectInsrP210001ToInsr1500List(Insr1550SrhVO searchVO) throws Exception {
		return list("insr1500DAO.selectInsrP210001ToInsr1500List_D", searchVO);
	}
	
    public Insr1500VO selectInsr1500(Insr1550VO vo) throws Exception {
        return (Insr1500VO) selectByPk("insr1500DAO.selectInsr1500_S", vo);
    }
	
	public int selectInsr1500Check(Insr1550VO vo) throws Exception {
        return (Integer) getSqlMapClientTemplate().queryForObject("insr1500DAO.selectInsr1500CheckCnt_S", vo);
    }
	
	public int selectInsr2300To1500Check(Insr1500VO vo) throws Exception {
        return (Integer) getSqlMapClientTemplate().queryForObject("insr1500DAO.selectInsr2300To1500CheckCnt_S", vo);
    }
	
	public int selectInsr15501600Check(Insr1550VO vo) throws Exception {
        return (Integer) getSqlMapClientTemplate().queryForObject("insr1500DAO.selectInsr15501600CheckCnt_S", vo);
    }
 
    public String insertInsr1500(Insr1550VO vo) throws Exception {
        return (String)insert("insr1500DAO.insertInsr1500_S", vo);
    }
    
    public String insertInsr1550(Insr1550VO vo) throws Exception {
        return (String)insert("insr1500DAO.insertInsr1550_S", vo);
    }
    public String insertInsr1600(Insr1550VO vo) throws Exception {
        return (String)insert("insr1500DAO.insertInsr1600_S", vo);
    }

    public int selectInsr1550Check(Insr1550VO vo) throws Exception {
        return (Integer) getSqlMapClientTemplate().queryForObject("insr1500DAO.selectInsr1550CheckCnt_S", vo);
    }
    
    public void updateInsr1550(Insr1550VO vo) throws Exception {
        update("insr1500DAO.updateInsr1550_S", vo);
    }
    
    public void updateXlsInsr1550(Insr1550VO vo) throws Exception {
        update("insr1500DAO.updateXlsInsr1550_S", vo);
    }
    public void updateInsr1600(Insr1550VO vo) throws Exception {
        update("insr1500DAO.updateInsr1600_S", vo);
    }
    
    public void deleteInsr15501600(Insr1550VO vo) throws Exception {
        delete("insr1500DAO.deleteInsr15501600_S", vo);
    }

  /*  public Insr1550VO selectInsr1500(Insr1550VO vo) throws Exception {
        return (Insr1550VO) selectByPk("insr1500DAO.selectInsr1500_S", vo);
    }*/
    
	public List<EgovMap>  selectXlsInsr1550List(Insr1550SrhVO searchVO) throws Exception {
		return list("insr1500DAO.selectXlsInsr1550List_D", searchVO);
	}
	
      
    /*
    public List<?> selectInsr1500List(Insr1550SrhVO searchVO) throws Exception {
        return list("insr1500DAO.selectInsr1500List_D", searchVO);
    }

    public int selectInsr1500ListTotCnt(Insr1550SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr1500DAO.selectInsr1500ListTotCnt_S", searchVO);
    }
    */
    
    public Insr1500VO selectInsr1500Aqtn(Insr1500SrhVO searchVO) throws Exception {
        return (Insr1500VO) selectByPk("insr1500DAO.selectInsr1500Aqtn_S", searchVO);
    }
    
	public List<EgovMap> selectInsr1550List(Insr1550SrhVO searchVO) throws Exception {
		return list ("insr1500DAO.selectInsr1550List_S", searchVO);
	}
	
	public List<EgovMap> selectInsr1550List2(Insr1550SrhVO searchVO) throws Exception {
		return list ("insr1500DAO.selectInsr1550List2_S", searchVO);
	}
	
    public void insertInsr1500Lss(Insr1500VO vo) throws Exception {
        insert("insr1500DAO.insertInsr1500Lss_S", vo);
    }
    
    public void updateInsr1500Lss(Insr1500VO vo) throws Exception {
        update("insr1500DAO.updateInsr1500Lss", vo);
    }
    
    public void updateInsr1500(Insr1550VO vo) throws Exception {
        update("insr1500DAO.updateInsr1500", vo);
    }
    
    
    
    
    public void updateXlsInsr2150ToInsr1550(Insr1550VO vo) throws Exception {
        update("insr1500DAO.updateXlsInsr2150ToInsr1550_S", vo);
    }
    
}
