package com.app.smrmf.pkg.yeta.yeta2016.file.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYetaFileDAO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta1000VO;
import com.app.smrmf.pkg.yeta.yeta2016.file.service.Yeta1400PayrService;

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
@Service("Yeta1400PayrService")
public class Yeta1400PayrServiceImpl extends AbstractServiceImpl  implements Yeta1400PayrService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(Yeta1400PayrServiceImpl.class);

     
   @Autowired
    @Resource(name="InfcPkgYetaFileDAO")
    private InfcPkgYetaFileDAO infcPkgYetaFileDAO;
   
   
    
    /** ID Generation */
    //@Resource(name="{egovYeta3900IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
 
   public Map fnPayrHB_ReTax_Total_Select(InfcPkgYeta1000VO vo) throws Exception {
	   Map resultVO = infcPkgYetaFileDAO.fnPayrHB_ReTax_Total_Select(vo);
     //  if (resultVO == null)
      //     throw processException("info.nodata.msg");
       return resultVO;
   }
   
   public Map fnPayrB_ReTax_Total_Select(InfcPkgYeta1000VO vo) throws Exception {
	   Map resultVO = infcPkgYetaFileDAO.fnPayrB_ReTax_Total_Select(vo);
     //  if (resultVO == null)
      //     throw processException("info.nodata.msg");
       return resultVO;
   }
     
   
   public List  fnPayrPSNL_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return infcPkgYetaFileDAO.fnPayrPSNL_ReTax_Total_Select(searchVO);
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
    * @see com.app.smrmf.pkg.yeta.yeta2016.file.service.Yeta1400PayrService#fnPayrHC_ReTax_Total_Select(com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta1000VO)
    * @param searchVO
    * @return
    * @throws Exception
    */
   public List  fnPayrHC_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return infcPkgYetaFileDAO.fnPayrHC_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrHD_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return infcPkgYetaFileDAO.fnPayrHD_ReTax_Total_Select(searchVO);
   } 
  
   
   public List  fnPayrPSNL_ReTax_CA_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return infcPkgYetaFileDAO.fnPayrPSNL_ReTax_CA_Total_Select(searchVO);
   } 
   
   public List  fnPayrCA_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return infcPkgYetaFileDAO.fnPayrCA_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrC_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return infcPkgYetaFileDAO.fnPayrC_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrD_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return infcPkgYetaFileDAO.fnPayrD_ReTax_Total_Select(searchVO);
   } 
   
   
   public List  fnPayrE_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return infcPkgYetaFileDAO.fnPayrE_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrF_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return infcPkgYetaFileDAO.fnPayrF_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrG_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return infcPkgYetaFileDAO.fnPayrG_ReTax_Total_Select(searchVO);
   } 
    
    
   
   
}
