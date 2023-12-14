package com.app.exterms.payroll.server.service.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.app.exterms.payroll.client.dto.Hpe100DTO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("Hpe100DAO")
public class Hpe100DAO extends EgovAbstractDAO {

    /**
     * Hpe100T 목록을 조회한다.
     * @param searcVO - 조회할 정보가 담긴 searcVO
     * @return Hpe100T 목록
     * @exception Exception
     */
    public List selectPayr7100BasisInit(Hpe100DTO hpe100Dto) throws Exception {
    	return list("Hpe100DAO.selectPayr7100BasisInit", hpe100Dto);
    }

    /**
     * Hpe100T 목록을 조회한다.
     * @param searcVO - 조회할 정보가 담긴 searcVO
     * @return Hpe100T 목록
     * @exception Exception
     */
    public List selectPayr7100BasisSave(Hpe100DTO hpe100Dto) throws Exception {
    	return list("Hpe100DAO.selectPayr7100BasisSave", hpe100Dto);
    }

    /**
     * Hpe100T 목록을 조회한다.
     * @param searcVO - 조회할 정보가 담긴 searcVO
     * @return Hpe100T 목록
     * @exception Exception
     */
    public List selectHpe100ToPayr7100DataList(Hpe100DTO hpe100Dto) throws Exception {
    	return list("Hpe100DAO.selectHpe100ToPayr7100DataList", hpe100Dto);
    }

    /**
     * Hpe100T 총 갯수를 조회한다..
     * @param searcVO - 조회할 정보가 담긴 searcVO
     * @return Hpe100T  총 갯수
     * @exception
     */
    public int selectHpe100ToPayr7100DataListTotCnt(Hpe100DTO hpe100Dto) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Hpe100DAO.selectHpe100ToPayr7100DataListTotCnt", hpe100Dto);
    }	

    /**
     * Hpe100T 목록을 조회한다.
     * @param searcVO - 조회할 정보가 담긴 searcVO
     * @return Hpe100T 목록
     * @exception Exception
     */
    public void setPayr7100SummaryData(Hpe100DTO hpe100Dto) throws Exception {
    	update("Hpe100DAO.setPayr7100SummaryData", hpe100Dto);
    }

    /**
     * Hpe100T 목록을 조회한다.
     * @param searcVO - 조회할 정보가 담긴 searcVO
     * @return Hpe100T 목록
     * @exception Exception
     */
    public void UpdateHPE000(Hpe100DTO hpe100Dto) throws Exception {
    	List hpe000List = list("Hpe100DAO.selectPayr7100BasisSave", hpe100Dto);
    	
    	if(hpe000List.size() > 0)
    		update("Hpe100DAO.UpdateHPE000", hpe100Dto);
    	else
    		insert("Hpe100DAO.InsertHPE000", hpe100Dto);
    }

    /**
     * Hpe100T 목록을 조회한다.
     * @param searcVO - 조회할 정보가 담긴 searcVO
     * @return Hpe100T 목록
     * @exception Exception
     */
    public List<Map<String, Object>> selectWorkPayListA(Hpe100DTO hpe100Dto) throws Exception {
    	return list("Hpe100DAO.selectWorkPayListA", hpe100Dto);
    }

    /**
     * Hpe100T 목록을 조회한다.
     * @param searcVO - 조회할 정보가 담긴 searcVO
     * @return Hpe100T 목록
     * @exception Exception
     */
    public List<Map<String, Object>> selectWorkPayListB(Hpe100DTO hpe100Dto) throws Exception {
    	return list("Hpe100DAO.selectWorkPayListB", hpe100Dto);
    }

    /**
     * Hpe100T 목록을 조회한다.
     * @param searcVO - 조회할 정보가 담긴 searcVO
     * @return Hpe100T 목록
     * @exception Exception
     */
    public List<Map<String, Object>> selectWorkPayListC(Hpe100DTO hpe100Dto) throws Exception {
    	return list("Hpe100DAO.selectWorkPayListC", hpe100Dto);
    }
    
    //추가_20200925
    public void setPayr7100DataSave(Hpe100DTO hpe100Dto) throws Exception{
    	List hpe000List = list("Hpe100DAO.selectPayr7100DataList", hpe100Dto);
    	if(hpe000List.size() > 0){
    		update("Hpe100DAO.setPayr7100DataUpdate", hpe100Dto);
    	}else{
    		insert("Hpe100DAO.setPayr7100DataSave", hpe100Dto);
    	}
    }
    
    /**2022.01.19 PDS(전자신고기본정보)조회 추가작업 (START)**/
    /** Hpe100T 목록을 조회한다.
    /** @param searcVO - 조회할 정보가 담긴 searcVO
    /** @return Hpe000T 목록
    /** @exception Exception
    /**/
    public List selectPayr7100Hpe000TList(Hpe100DTO hpe100Dto) throws Exception {
    	return list("Hpe100DAO.Hpe100DAO.selectPayr7100DataList", hpe100Dto);
    }

        
}