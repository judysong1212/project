package com.app.exterms.statistics.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.statistics.server.vo.Stts0100SrhVO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


@Repository("stts0100DAO")
public class Stts0100DAO extends EgovAbstractDAO implements IsSerializable{
	
    public List selectStts0100XlsList(Stts0100SrhVO stts0100SrhVo) throws Exception {
        return list("stts0100DAO.selectPsnl0400ToPsnl0110List", stts0100SrhVo);
    }

}
