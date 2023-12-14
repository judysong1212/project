package com.app.exterms.personal.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.client.dto.Psnl0400DTO;
import com.app.exterms.personal.server.vo.Psnl0110SrhVO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


@Repository("psnl0400DAO")
public class Psnl0400DAO extends EgovAbstractDAO implements IsSerializable{
	
	@SuppressWarnings("rawtypes")
	public List selectExperienceMain(Psnl0400DTO psnl0400dto) {
		return list("psnl0400DAO.selectExperienceMain", psnl0400dto);
	}
	
	
	// def 를 이용한 증명서발급 조회
    public int selectPsnl0400ToPsnl0110ListCnt(Psnl0110SrhVO psnl0110SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0400DAO.selectPsnl0400ToPsnl0110ListCnt", psnl0110SrhVo);
    }
    
    public List selectPsnl0400ToPsnl0110List(Psnl0110SrhVO psnl0110SrhVo) throws Exception {
        return list("psnl0400DAO.selectPsnl0400ToPsnl0110List", psnl0110SrhVo);
    }

    @Transactional
	public String insertIssueData(Psnl0400DTO dto) throws Exception{
		return (String) insert("psnl0400DAO.insertIssueData",dto);
	}
	
	public String getIssueNumber(Psnl0400DTO dto) throws Exception{
		return (String)getSqlMapClientTemplate().queryForObject("psnl0400DAO.getIssueNumber", dto);             
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public List selectExperience(Psnl0400DTO dto) {
		return list("psnl0400DAO.selectExperience", dto);
	}

}
