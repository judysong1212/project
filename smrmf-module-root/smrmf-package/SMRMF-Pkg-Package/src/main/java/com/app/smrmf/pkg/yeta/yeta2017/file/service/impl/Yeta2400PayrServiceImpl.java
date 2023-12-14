package com.app.smrmf.pkg.yeta.yeta2017.file.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYeta17FileDAO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161005VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161020VO;
import com.app.smrmf.pkg.yeta.yeta2017.file.service.Yeta2400PayrService;

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
@Service("Yeta2400PayrService")
public class Yeta2400PayrServiceImpl extends AbstractServiceImpl  implements Yeta2400PayrService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(Yeta2400PayrServiceImpl.class);

     
   @Autowired
    @Resource(name="InfcPkgYeta17FileDAO")
    private InfcPkgYeta17FileDAO infcPkgYeta17FileDAO;
   
   
   public   InfcPkgYe161005VO selectYe161005(InfcPkgYe161010VO ye161010VO) throws Exception {
	   InfcPkgYe161005VO resultVO = infcPkgYeta17FileDAO.selectYe161005(ye161010VO);
     
       return resultVO;
   } 
	   
    /** ID Generation */
    //@Resource(name="{egovYeta3900IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
 
   public Map fnPayrHB_ReTax_Total_Select(InfcPkgYe161020VO vo) throws Exception {
	   Map resultVO = infcPkgYeta17FileDAO.fnPayrHB_ReTax_Total_Select(vo);
     //  if (resultVO == null)
      //     throw processException("info.nodata.msg");
       return resultVO;
   }
   
   public Map fnPayrB_ReTax_Total_Select(InfcPkgYe161020VO vo) throws Exception {
	   Map resultVO = infcPkgYeta17FileDAO.fnPayrB_ReTax_Total_Select(vo);
     //  if (resultVO == null)
      //     throw processException("info.nodata.msg");
       return resultVO;
   }
     
   
   public List  fnPayrPSNL_ReTax_Total_Select(InfcPkgYe161020VO searchVO) throws Exception {
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
   public List  fnPayrHC_ReTax_Total_Select(InfcPkgYe161020VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrHC_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrHD_ReTax_Total_Select(InfcPkgYe161020VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrHD_ReTax_Total_Select(searchVO);
   } 
  
   
   public List  fnPayrPSNL_ReTax_CA_Total_Select(InfcPkgYe161020VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrPSNL_ReTax_CA_Total_Select(searchVO);
   } 
   
   public List  fnPayrCA_ReTax_Total_Select(InfcPkgYe161020VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrCA_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrC_ReTax_Total_Select(InfcPkgYe161020VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrC_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrD_ReTax_Total_Select(InfcPkgYe161020VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrD_ReTax_Total_Select(searchVO);
   } 
   
   
   public List  fnPayrE_ReTax_Total_Select(InfcPkgYe161020VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrE_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrF_ReTax_Total_Select(InfcPkgYe161020VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrF_ReTax_Total_Select(searchVO);
   } 
   
   public List  fnPayrG_ReTax_Total_Select(InfcPkgYe161020VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.fnPayrG_ReTax_Total_Select(searchVO);
   } 
    
   
   public int  updateYeta2400ToYe161010(InfcPkgYe161010VO searchVO) throws Exception {
       return infcPkgYeta17FileDAO.updateYeta2400ToYe161010(searchVO);
       
   } 
  
   
}
