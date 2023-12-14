package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Payr4600ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.server.service.dao.Payr0650DAO;
import com.app.exterms.payroll.server.vo.Payr0650SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;


@Service("payr4600ExcelService")
public class Payr4600ExcelServiceImpl extends AbstractServiceImpl implements Payr4600ExcelService {


    @Autowired
    @Resource(name = "Payr0650DAO")
    private Payr0650DAO payr0650DAO;


    @Override
    public List selectXlsPayr0650List(Payr0650SrhVO payr0650SrhVO) throws Exception{
        return payr0650DAO.selectXlsPayr0650List(payr0650SrhVO);
    }


}
