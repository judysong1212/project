package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Yeta2070Srh_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("Yeta5070_2020_DAO")
public class Yeta5070_2020_DAO  extends EgovAbstractDAO{
	
	 /**
     * Yeta4060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta4060 목록
     * @exception Exception
     */
    public List selectYeta5070List(Yeta2070Srh_2020_VO searchVO) throws Exception {
    	return list("Yeta5070_2020_DAO.selectYeta5070List_D", searchVO);
    }
    
    /**
     * Yeta4060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta4060 총 갯수
     * @exception
     */
    public int selectYeta5070ListTotCnt(Yeta2070Srh_2020_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta5070_2020_DAO.selectYeta5070ListTotCnt_S", searchVO);
    }
}
