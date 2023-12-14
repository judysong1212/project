package com.app.smrmf.pkg.yeta.yeta2023.file.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYeta17File_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161005_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161020_2023_VO;
import com.app.smrmf.pkg.yeta.yeta2023.file.service.Yeta8400PayrService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

 
/**
 * 
* <pre>
* 1. 패키지명 : com.msf.exterms.pdf.xml.service.impl
* 2. 타입명 : YetaPayr6425ServiceImpl.java
* 3. 작성일 : Jan 26, 2016 1:37:47 PM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
 */
@Service("Yeta8400PayrService")
public class Yeta8400PayrServiceImpl extends AbstractServiceImpl  implements Yeta8400PayrService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(Yeta8400PayrServiceImpl.class);

     
   @Autowired
    @Resource(name="InfcPkgYeta17File_2023_DAO")
    private InfcPkgYeta17File_2023_DAO infcPkgYeta17FileDAO;
   
   
   public   InfcPkgYe161005_2023_VO selectYe161005(InfcPkgYe161010_2023_VO ye161010VO) throws Exception {
	   InfcPkgYe161005_2023_VO resultVO = infcPkgYeta17FileDAO.selectYe161005(ye161010VO);
     
       return resultVO;
   } 
	   
    /** ID Generation */
    //@Resource(name="{egovYeta8900IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
 
   public Map fnPayrHB_ReTax_Total_Select(InfcPkgYe161020_2023_VO vo) throws Exception {
	   Map resultVO = infcPkgYeta17FileDAO.fnPayrHB_ReTax_Total_Select(vo);
     //  if (resultVO == null)
      //     throw processException("info.nodata.msg");
       return resultVO;
   }
   
   public Map fnPayrB_ReTax_Total_Select(InfcPkgYe161020_2023_VO vo) throws Exception {
	   Map resultVO = infcPkgYeta17FileDAO.fnPayrB_ReTax_Total_Select(vo);
     //  if (resultVO == null)
      //     throw processException("info.nodata.msg");
       return resultVO;
   }
     
   
   public List  fnPayrPSNL_ReTax_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrPSNL_ReTax_Total_Select(searchVO);
   } 
   
   /**
    * 
    * <pre>
    * 1. 개요 : C 레코드 - 기부금 조정명세 레코드  
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : fnPayrHC_ReTax_Total_Select
    * @date : 2017. 1. 20.
    * @author : atres-pc
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	2017. 1. 20.		atres-pc				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @see com.app.smrmf.pkg.yeta.yeta2016.file.service.Yeta1400PayrService#fnPayrHC_ReTax_Total_Select(com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe161020VO)
    * @param searchVO
    * @return
    * @throws Exception
    */
   public List  fnPayrHC_ReTax_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrHC_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrHD_ReTax_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrHD_ReTax_Total_Select(searchVO);
   } 
  
   
   public List  fnPayrPSNL_ReTax_CA_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrPSNL_ReTax_CA_Total_Select(searchVO);
   } 
   
   public List  fnPayrCA_ReTax_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrCA_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrC_ReTax_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrC_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrD_ReTax_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrD_ReTax_Total_Select(searchVO);
   } 
   
   
   public List  fnPayrE_ReTax_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrE_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrF_ReTax_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrF_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrG_ReTax_Total_Select(InfcPkgYe161020_2023_VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrG_ReTax_Total_Select(searchVO);
   } 
    
   
   public int  updateYeta8400ToYe161010(InfcPkgYe161010_2023_VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.updateYeta8400ToYe161010(searchVO);
       
   } 
  
   
}
