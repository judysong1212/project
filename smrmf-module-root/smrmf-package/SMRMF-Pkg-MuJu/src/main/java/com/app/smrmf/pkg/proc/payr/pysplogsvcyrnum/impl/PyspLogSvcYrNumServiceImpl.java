package com.app.smrmf.pkg.proc.payr.pysplogsvcyrnum.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0300SrhVO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0430DAO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0430SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0430VO;
import com.app.smrmf.pkg.proc.payr.pysplogsvcyrnum.PyspLogSvcYrNumService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : Payr0305ServiceImpl.java
 * @Description : Payr0305 Business Implement class
 *               퇴직금계산 로직 ....
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("PyspLogSvcYrNumService")
public class PyspLogSvcYrNumServiceImpl extends AbstractServiceImpl implements  PyspLogSvcYrNumService {

    @Autowired
    @Resource(name="InfcPkgPayr0430DAO")
    private InfcPkgPayr0430DAO payr0430DAO;
       
    /** ID Generation */
    //@Resource(name="{egovPayr0305IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
    /**
     * PAYR0430을 등록한다.
     * @param vo - 등록할 정보가 담긴 Payr0430VO
     * @return 등록 결과
     * @exception Exception
     */
    public String insertPayr0430(InfcPkgPayr0430VO vo) throws Exception {
      log.debug(vo.toString());
      
      /** ID Generation Service */
      //TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      //String id = egovIdGnrService.getNextStringId();
      //vo.setId(id);
      log.debug(vo.toString());
      
      payr0430DAO.insertPayr0430(vo);
      //TODO 해당 테이블 정보에 맞게 수정     
        return null;
    }

    /**
   * PAYR0430을 수정한다.
   * @param vo - 수정할 정보가 담긴 Payr0430VO
   * @return void형
   * @exception Exception
   */
    public void updatePayr0430(InfcPkgPayr0430VO vo) throws Exception {
        payr0430DAO.updatePayr0430(vo);
    }

    /**
   * PAYR0430을 삭제한다.
   * @param vo - 삭제할 정보가 담긴 Payr0430VO
   * @return void형 
   * @exception Exception
   */
    public void  deletePayr0430(InfcPkgPayr0430VO vo) throws Exception {
        payr0430DAO.deletePayr0430(vo);
    }

    /**
   * PAYR0430을 조회한다.
   * @param vo - 조회할 정보가 담긴 Payr0430VO
   * @return 조회한 PAYR0430
   * @exception Exception
   */
    public InfcPkgPayr0430VO selectPayr0430(InfcPkgPayr0430VO vo) throws Exception {
        InfcPkgPayr0430VO resultVO = payr0430DAO.selectPayr0430(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
   * PAYR0430 목록을 조회한다.
   * @param searchVO - 조회할 정보가 담긴 VO
   * @return PAYR0430 목록
   * @exception Exception
   */
    public List selectPayr0430List(InfcPkgPayr0430SrhVO searchVO) throws Exception {
        return payr0430DAO.selectPayr0430List(searchVO);
    }

    /**
   * PAYR0430 총 갯수를 조회한다.
   * @param searchVO - 조회할 정보가 담긴 VO
   * @return PAYR0430 총 갯수
   * @exception
   */
    public int selectPayr0430ListTotCnt(InfcPkgPayr0430SrhVO searchVO) {
      return payr0430DAO.selectPayr0430ListTotCnt(searchVO);
  }  
    
    
    /**
     * 근속년수 코드 정보리스트를 가지고 온다. 
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return Bass0300 목록
     * @exception Exception
     */
    public  List selectBass0300List(InfcPkgBass0300SrhVO searchVO) throws Exception {
         
         return payr0430DAO.selectBass0300List(searchVO);
     }
    
 
}
