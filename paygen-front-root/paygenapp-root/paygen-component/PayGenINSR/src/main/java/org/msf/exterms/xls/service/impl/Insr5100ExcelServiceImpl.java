package org.msf.exterms.xls.service.impl;
 
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.imp.MsfExcelService;
import org.msf.exterms.xls.service.Insr5100ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.dao.Insr5100DAO;
import com.app.exterms.insurance.server.service.dao.Insr5200DAO;
import com.app.exterms.insurance.server.vo.Insr5100SrhVO;
import com.app.exterms.insurance.server.vo.Insr5100VO;
import com.app.exterms.insurance.server.vo.Insr5200VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0500DAO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0500VO;
import com.app.smrmf.infc.personal.server.service.dao.InfcPkgPsnl0127DAO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0127VO;
import com.app.smrmf.props.ExtermsProps;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("Insr5100ExcelService")
public class Insr5100ExcelServiceImpl extends AbstractServiceImpl implements Insr5100ExcelService {
    
	private static final Logger logger = LoggerFactory.getLogger(Insr5100ExcelService.class);
     
    @Autowired 
    @Resource(name="Insr5100DAO")
    private Insr5100DAO insr5100DAO;

    @Autowired 
    @Resource(name="Insr5200DAO")
    private Insr5200DAO insr5200DAO;
    
    @Autowired 
    @Resource(name="InfcPkgPsnl0127DAO")
    private InfcPkgPsnl0127DAO infcPsnl0127DAO;
    
    @Autowired 
    @Resource(name="InfcPkgPayr0500DAO")
    private InfcPkgPayr0500DAO infcPayr0500DAO;
    
    @Autowired  
    @Resource(name = "insr5100ExcelUploadService")
    private MsfExcelService insr5100ExcelUploadService;
    
    @Autowired 
    @Resource(name = "insr5100XSSFExcelUploadService")
    private MsfExcelService insr5100XSSFExcelUploadService;
    
     
  public List selectXlsInsr5100List(Insr5100SrhVO insr5100SrhVO) throws Exception {
      return insr5100DAO.selectXlsInsr5100List(insr5100SrhVO);
  } 

    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    public void insertXlsInsr4300(InputStream file) throws Exception {
       // dlgn0100DAO.insertXlsInsr4300(); //삭제호출 후 파일데이터 인서트  
        insr5100ExcelUploadService.uploadExcel("insr4300DAO.deleteXlsInsr4300_S","insr4300DAO.insertXlsInsr4300_S", file, 2, (long) 0);  
    } 
    
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    public void insertXlsInsr4100(InputStream file) throws Exception {
       // dlgn0100DAO.insertXlsInsr4300(); //삭제호출 후 파일데이터 인서트  
        insr5100ExcelUploadService.uploadExcel("insr4100DAO.updateXlsInsr4100_S", file, 2, (long) 0);  
    } 
    
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    public void insertXlsPsnl0127(InputStream file) throws Exception {
       // dlgn0100DAO.insertXlsInsr4300(); //삭제호출 후 파일데이터 인서트  
        insr5100ExcelUploadService.uploadExcel("pgmPsnl0127DAO.updateXlsPsnl0127_S", file, 2, (long) 0);  
    } 
 
    
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    public void insertXSSFInsr4300(InputStream file) throws Exception {
       // dlgn0100DAO.insertXlsInsr4300(); //삭제호출 후 파일데이터 인서트  
        insr5100XSSFExcelUploadService.uploadXSSFExcel("insr4300DAO.deleteXlsInsr4300_S","insr4300DAO.insertXlsInsr4300_S", file, 2, (long) 0);  
    }
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    public void insertXSSFInsr4100(InputStream file) throws Exception {
       // dlgn0100DAO.insertXlsInsr4300(); //삭제호출 후 파일데이터 인서트  
        insr5100ExcelUploadService.uploadExcel("insr4100DAO.updateXlsInsr4100_S", file, 2, (long) 0);  
    } 
    
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    public void insertXSSFPsnl0127(InputStream file) throws Exception {
       // dlgn0100DAO.insertXlsInsr4300(); //삭제호출 후 파일데이터 인서트  
        insr5100ExcelUploadService.uploadExcel("pgmPsnl0127DAO.updateXlsPsnl0127_S", file, 2, (long) 0);  
    } 
     
    /**
   	 * 엑셀파일을 등록한다._jxls
   	 * @param  hMap
   	 * @throws Exception
   	 */

    @Override
    public Long updateXlsInsr5100(List<Insr5100VO> insr5100List, HttpServletRequest request)throws MSFException {
    	Long result = new Long(0);
    	Long iCnt	= new Long(0);

    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);

    	try {  
    		
    		for(int i = 0; i < insr5100List.size(); i++) {
    			
    			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

    			Insr5100VO insr5100Vo = new Insr5100VO();  
    			Insr5200VO insr5200Vo = new Insr5200VO();
    			
    			InfcPkgPayr0500VO infcPayr0500Vo = new InfcPkgPayr0500VO(); 
    			InfcPkgPsnl0127VO infcPsnl0127Vo = new InfcPkgPsnl0127VO();   

    			
    			insr5100Vo = insr5100List.get(i);
    			
    			insr5200Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr5100Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
    			
    			int retVal = 0;
    			
    			retVal=insr5200DAO.selectInsr5200RegChkCnt(insr5200Vo);
    			
				if(retVal > 0){  // 재직중인 인원만 고용 테이블 insert
    			
	    			insr5100Vo = insr5100List.get(i);
	
	    			insr5100Vo.setDpobCd(sessionUser.getDpobCd());                                            /** column 사업장코드 : dpobCd */
	    			//insr5100Vo.setResnRegnNum(MSFSharedUtils.allowNulls(insr5100Vo.getResnRegnNum()));
	    			
	    			insr5100Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr5100Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
	    			
	    			insr5100Vo.setUmytInsrAqtnDt(insr5100Vo.getUmytInsrAqtnDt());                             /** column 고용보험취득일자 : umytInsrAqtnDt */
	    			insr5100Vo.setIsmt(sessionUser.getUsrId());                                               /** column 수정자 : ismt */ 
	    			insr5100Vo.setRevnAddr(request.getRemoteAddr());                                          /** column 수정주소 : revnAddr */
	    			
	    			Insr5100VO resultVo = insr5100DAO.selectXlsInsr5100(insr5100Vo);
	
	    			infcPsnl0127Vo.setDpobCd(sessionUser.getDpobCd());                                        /** column 사업장코드 : dpobCd */
	    			//infcPsnl0127Vo.setResnRegnNum(MSFSharedUtils.allowNulls(insr5100Vo.getResnRegnNum()));
	    			
	    			infcPsnl0127Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr5100Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
	    			
	    			infcPsnl0127Vo.setUmytInsrApptnYn("Y");                                                   /** column 고용보험적용여부 : umytInsrApptnYn */
	    			infcPsnl0127Vo.setUmytInsrPayTotAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(insr5100Vo.getUmytInsrPayTotAmnt(), "0")));/** column 고용보험보수총액 : umytInsrPayTotAmnt */
	    			insr5100Vo.setSocInsrDducEthdCd(ExtermsProps.getProps("INSR_SOC_INSR_DDUC_0200"));
	    			if(MSFSharedUtils.paramNotNull(resultVo)){
						if( ExtermsProps.getProps("INSR_SOC_INSR_DDUC_0200").equals(MSFSharedUtils.allowNulls(resultVo.getSocInsrDducEthdCd()))) {
							insr5100Vo.setSocInsrDducEthdCd(ExtermsProps.getProps("INSR_SOC_INSR_DDUC_0200"));
							infcPsnl0127Vo.setUmytInsrPayMnthAmnt(BigDecimal.ZERO);                               /** column 고용보험보수월액 : umytInsrPayMnthAmnt */                                                                       /** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
						}else{
							insr5100Vo.setSocInsrDducEthdCd(ExtermsProps.getProps("INSR_SOC_INSR_DDUC_0100"));
							infcPsnl0127Vo.setUmytInsrPayMnthAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(insr5100Vo.getUmytInsrPayMnthAmnt(), "0")));
						}
					} else { 
						
						if((new BigDecimal(MSFSharedUtils.defaultNulls(insr5100Vo.getUmytInsrPayMnthAmnt(), "0"))).compareTo(BigDecimal.ZERO) <= 0)  {
							insr5100Vo.setSocInsrDducEthdCd(ExtermsProps.getProps("INSR_SOC_INSR_DDUC_0200"));
							infcPsnl0127Vo.setUmytInsrPayMnthAmnt(BigDecimal.ZERO);                               /** column 고용보험보수월액 : umytInsrPayMnthAmnt */ 
						}else{
							insr5100Vo.setSocInsrDducEthdCd(ExtermsProps.getProps("INSR_SOC_INSR_DDUC_0100"));
							infcPsnl0127Vo.setUmytInsrPayMnthAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(insr5100Vo.getUmytInsrPayMnthAmnt(), "0")));
						
						}
					}
		    			                           
		    			
	    			infcPsnl0127Vo.setIsmt(sessionUser.getUsrId());                                           /** column 수정자 : ismt */ 
	    			infcPsnl0127Vo.setRevnAddr(request.getRemoteAddr());                                      /** column 수정주소 : revnAddr */
	
	    			//고용보험사용여부 
	    			infcPayr0500Vo.setDpobCd(insr5100Vo.getDpobCd());                                         /** column 사업장코드 : dpobCd */
	    			//infcPayr0500Vo.setResnRegnNum(MSFSharedUtils.allowNulls(insr5100Vo.getResnRegnNum()));           
	    			
	    			infcPayr0500Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr5100Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
	    			
	    			infcPayr0500Vo.setUmytInsrApptnYn("Y");                                                   /** column 고용보험적용여부 : umytInsrApptnYn */
	    			infcPayr0500Vo.setIsmt(sessionUser.getUsrId());                                           /** column 수정자 : ismt */ 
	    			infcPayr0500Vo.setRevnAddr(request.getRemoteAddr());                                      /** column 수정주소 : revnAddr */
	
	    			insr5100DAO.updateXlsInsr5100(insr5100Vo);
	    			infcPsnl0127DAO.updateXlsInsr5100ToPsnl0127(infcPsnl0127Vo); 
	    			infcPayr0500DAO.updateXlsInsr5100ToPayr0500(infcPayr0500Vo);
	    			
	    			  iCnt = iCnt + 1L;

				} // if end
    		} // for end
    		result = iCnt;
    	} catch (Exception ex) {
    		logger.error("EXCEPTION calling updateXlsInsr5100(): " + ex);
    		result = new Long(0);
    		throw MSFServerUtils.getOperationException("updateXlsInsr5100", ex, logger);
    	} finally {

    	}
    	return result;
    }
  
}
