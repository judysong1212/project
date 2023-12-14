package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.file.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta1000VO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.file.service.YetaPayr6540Service;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrcFileDAO;

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
@Service("YetaPayr6540Service")
public class YetaPayr6540ServiceImpl extends AbstractServiceImpl  implements YetaPayr6540Service {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(YetaPayr6540ServiceImpl.class);

     
   @Autowired
    @Resource(name="YetaPrcFileDAO")
    private YetaPrcFileDAO yetaPrcFileDAO;
   
   
    
    /** ID Generation */
    //@Resource(name="{egovYeta3900IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
 
   public Map fnPayrHB_ReTax_Total_Select(InfcPkgYeta1000VO vo) throws Exception {
	   Map resultVO = yetaPrcFileDAO.fnPayrHB_ReTax_Total_Select(vo);
     //  if (resultVO == null)
      //     throw processException("info.nodata.msg");
       return resultVO;
   }
   
   public Map fnPayrB_ReTax_Total_Select(InfcPkgYeta1000VO vo) throws Exception {
	   Map resultVO = yetaPrcFileDAO.fnPayrB_ReTax_Total_Select(vo);
     //  if (resultVO == null)
      //     throw processException("info.nodata.msg");
       return resultVO;
   }
     
   
   public List  fnPayrPSNL_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return yetaPrcFileDAO.fnPayrPSNL_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrHC_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return yetaPrcFileDAO.fnPayrHC_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrHD_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return yetaPrcFileDAO.fnPayrHD_ReTax_Total_Select(searchVO);
   } 
  
   
   public List  fnPayrPSNL_ReTax_CA_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return yetaPrcFileDAO.fnPayrPSNL_ReTax_CA_Total_Select(searchVO);
   } 
   
   public List  fnPayrCA_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return yetaPrcFileDAO.fnPayrCA_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrC_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return yetaPrcFileDAO.fnPayrC_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrD_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return yetaPrcFileDAO.fnPayrD_ReTax_Total_Select(searchVO);
   } 
   
   
   public List  fnPayrE_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return yetaPrcFileDAO.fnPayrE_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrF_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return yetaPrcFileDAO.fnPayrF_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrG_ReTax_Total_Select(InfcPkgYeta1000VO searchVO) throws Exception {
       return yetaPrcFileDAO.fnPayrG_ReTax_Total_Select(searchVO);
   } 
    
    
   
   
}
