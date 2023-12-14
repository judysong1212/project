package com.app.smrmf.pkg.proc.dlgn.manage.commute.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0100SrhVO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0100VO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0200SrhVO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0200VO;
import com.app.smrmf.pkg.proc.dlgn.manage.commute.ManageCommuteService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : Payr0305ServiceImpl.java
 * @Description : Payr0305 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("ManageCommuteService")
public class ManageCommuteServiceImpl extends AbstractServiceImpl implements  ManageCommuteService {
 
    
    //인사급여 대상자 정보를 가져온다.
    @Autowired
    @Resource(name="ManageCommuteDAO")
    private  ManageCommuteDAO  manageCommuteDAO;
    
//	@Autowired 
//    @Resource(name="dlgn0100DAO")
//    private InfcDlgn0100DAO dlgn0100DAO;
//    
//	@Autowired 
//    @Resource(name="dlgn0200DAO")
//    private InfcDlgn0200DAO dlgn0200DAO;
    
    
    /** ID Generation */
    //@Resource(name="{egovPayr0305IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
 
  /**
  * DLGN0100 목록을 조회한다.
  * @param searchVO - 조회할 정보가 담긴 VO
  * @return DLGN0100 목록
  * @exception Exception
  */
 public List selectInfcDlgn0110TotList(InfcPkgDlgn0100SrhVO searchVO) throws Exception {
     return manageCommuteDAO.selectInfcDlgn0110TotList(searchVO);
 }
    
/**
* DLGN0100을 수정한다.
* @param vo - 수정할 정보가 담긴 InfcDlgn0100VO
* @return void형
* @exception Exception
*/
public void updateManageCommuteInfcDlgn0100(InfcPkgDlgn0100VO vo) throws Exception {
    manageCommuteDAO.updateManageCommuteInfcDlgn0100(vo);
}
 

/**
 * DLGN0100 목록을 조회한다.
 * @param searchVO - 조회할 정보가 담긴 VO
 * @return DLGN0100 목록
 * @exception Exception
 */
public List selectInfcDlgn0210TotList(InfcPkgDlgn0200SrhVO searchVO) throws Exception {
    return manageCommuteDAO.selectInfcDlgn0210TotList(searchVO);
}
   
/**
* DLGN0100을 수정한다.
* @param vo - 수정할 정보가 담긴 InfcDlgn0100VO
* @return void형
* @exception Exception
*/
public void updateManageCommuteInfcDlgn0200(InfcPkgDlgn0200VO vo) throws Exception {
   manageCommuteDAO.updateManageCommuteInfcDlgn0200(vo);
}


/**
* DLGN0100 목록을 조회한다.
* @param searchVO - 조회할 정보가 담긴 VO
* @return DLGN0100 목록
* @exception Exception
*/
public List selectInfcDlgn0110HHMiTotList(InfcPkgDlgn0100SrhVO searchVO) throws Exception {
   return manageCommuteDAO.selectInfcDlgn0110HHMiTotList(searchVO);
}

/**
* DLGN0100 목록을 조회한다.
* @param searchVO - 조회할 정보가 담긴 VO
* @return DLGN0100 목록
* @exception Exception
*/
public List selectInfcDlgn0110HHMiTotList2(InfcPkgDlgn0100SrhVO searchVO) throws Exception {
   return manageCommuteDAO.selectInfcDlgn0110HHMiTotList2(searchVO);
}


/**
 * DLGN0100 목록을 조회한다.
 * @param searchVO - 조회할 정보가 담긴 VO
 * @return DLGN0100 목록
 * @exception Exception
 */
public List selectInfcDlgn0210HHMiTotList(InfcPkgDlgn0200SrhVO searchVO) throws Exception {
    return manageCommuteDAO.selectInfcDlgn0210HHMiTotList(searchVO);
}
      
//    /**
//     * DLGN0100을 등록한다.
//     * @param vo - 등록할 정보가 담긴 InfcDlgn0100VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    public String insertInfcDlgn0100(InfcDlgn0100VO vo) throws Exception {
//        log.debug(vo.toString());
//        
//        /** ID Generation Service */
//        //TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//        //String id = egovIdGnrService.getNextStringId();
//        //vo.setId(id);
//        log.debug(vo.toString());
//        
//        dlgn0100DAO.insertInfcDlgn0100(vo);
//        //TODO 해당 테이블 정보에 맞게 수정     
//        return null;
//    }
//
//    /**
//     * DLGN0100을 수정한다.
//     * @param vo - 수정할 정보가 담긴 InfcDlgn0100VO
//     * @return void형
//     * @exception Exception
//     */
//    public void updateInfcDlgn0100(InfcDlgn0100VO vo) throws Exception {
//        dlgn0100DAO.updateInfcDlgn0100(vo);
//    }
//
//    /**
//     * DLGN0100을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 InfcDlgn0100VO
//     * @return void형 
//     * @exception Exception
//     */
//    public void deleteInfcDlgn0100(InfcDlgn0100VO vo) throws Exception {
//        dlgn0100DAO.deleteInfcDlgn0100(vo);
//    }
//
//    /**
//     * DLGN0100을 조회한다.
//     * @param vo - 조회할 정보가 담긴 InfcDlgn0100VO
//     * @return 조회한 DLGN0100
//     * @exception Exception
//     */
//    public InfcDlgn0100VO selectInfcDlgn0100(InfcDlgn0100VO vo) throws Exception {
//        InfcDlgn0100VO resultVO = dlgn0100DAO.selectInfcDlgn0100(vo);
//        if (resultVO == null)
//            throw processException("info.nodata.msg");
//        return resultVO;
//    }
//
//    /**
//     * DLGN0100 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return DLGN0100 목록
//     * @exception Exception
//     */
//    public List selectInfcDlgn0100List(InfcDlgn0100SrhVO searchVO) throws Exception {
//        return dlgn0100DAO.selectInfcDlgn0100List(searchVO);
//    }
//
//    /**
//     * DLGN0100 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return DLGN0100 총 갯수
//     * @exception
//     */
//    public int selectInfcDlgn0100ListTotCnt(InfcDlgn0100SrhVO searchVO) {
//        return dlgn0100DAO.selectInfcDlgn0100ListTotCnt(searchVO);
//    }
//    
//    
//
//    /**
//     * DLGN0200을 등록한다.
//     * @param vo - 등록할 정보가 담긴 InfcDlgn0200VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    public String insertInfcDlgn0200(InfcDlgn0200VO vo) throws Exception {
//        log.debug(vo.toString());
//        
//        /** ID Generation Service */
//        //TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//        //String id = egovIdGnrService.getNextStringId();
//        //vo.setId(id);
//        log.debug(vo.toString());
//        
//        dlgn0200DAO.insertInfcDlgn0200(vo);
//        //TODO 해당 테이블 정보에 맞게 수정     
//        return null;
//    }
//
//    /**
//     * DLGN0200을 수정한다.
//     * @param vo - 수정할 정보가 담긴 InfcDlgn0200VO
//     * @return void형
//     * @exception Exception
//     */
//    public void updateInfcDlgn0200(InfcDlgn0200VO vo) throws Exception {
//        dlgn0200DAO.updateInfcDlgn0200(vo);
//    }
//
//    /**
//     * DLGN0200을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 InfcDlgn0200VO
//     * @return void형 
//     * @exception Exception
//     */
//    public void deleteInfcDlgn0200(InfcDlgn0200VO vo) throws Exception {
//        dlgn0200DAO.deleteInfcDlgn0200(vo);
//    }
//
//    /**
//     * DLGN0200을 조회한다.
//     * @param vo - 조회할 정보가 담긴 InfcDlgn0200VO
//     * @return 조회한 DLGN0200
//     * @exception Exception
//     */
//    public InfcDlgn0200VO selectInfcDlgn0200(InfcDlgn0200VO vo) throws Exception {
//        InfcDlgn0200VO resultVO = dlgn0200DAO.selectInfcDlgn0200(vo);
//        if (resultVO == null)
//            throw processException("info.nodata.msg");
//        return resultVO;
//    }
//
//    /**
//     * DLGN0200 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return DLGN0200 목록
//     * @exception Exception
//     */
//    public List selectInfcDlgn0200List(InfcDlgn0200SrhVO searchVO) throws Exception {
//        return dlgn0200DAO.selectInfcDlgn0200List(searchVO);
//    }
//
//    /**
//     * DLGN0200 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return DLGN0200 총 갯수
//     * @exception
//     */
//    public int selectInfcDlgn0200ListTotCnt(InfcDlgn0200SrhVO searchVO) {
//        return dlgn0200DAO.selectInfcDlgn0200ListTotCnt(searchVO);
//    } 
    
    
}
