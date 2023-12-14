package org.msf.exterms.xls.service.impl;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.imp.MsfExcelService;
import org.msf.exterms.xls.service.Insr4100ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.dao.Insr3000DAO;
import com.app.exterms.insurance.server.service.dao.Insr3200DAO;
import com.app.exterms.insurance.server.vo.Insr3000SrhVO;
import com.app.exterms.insurance.server.vo.Insr3000VO;
import com.app.exterms.insurance.server.vo.Insr3200VO;
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

@Service("Insr4100ExcelService")
public class Insr4100ExcelServiceImpl extends AbstractServiceImpl implements Insr4100ExcelService {
    
	private static final Logger logger = LoggerFactory.getLogger(Insr4100ExcelServiceImpl.class);
     
    @Autowired 
    @Resource(name="Insr3000DAO")
    private Insr3000DAO insr3000DAO;
    
    @Autowired 
    @Resource(name="Insr3200DAO")
    private Insr3200DAO insr3200DAO;
    
    @Autowired 
    @Resource(name="InfcPkgPsnl0127DAO")
    private InfcPkgPsnl0127DAO infcPsnl0127DAO;
    
    @Autowired 
    @Resource(name="InfcPkgPayr0500DAO")
    private InfcPkgPayr0500DAO infcPayr0500DAO;
    
    @Autowired  
    @Resource(name = "insr3000ExcelUploadService")
    private MsfExcelService insr3000ExcelUploadService;
    
    @Autowired 
    @Resource(name = "insr3000XSSFExcelUploadService")
    private MsfExcelService insr3000XSSFExcelUploadService;
    
     
  public List selectXlsInsr3000List(Insr3000SrhVO insr3000SrhVO) throws Exception {
      return insr3000DAO.selectXlsInsr3000List(insr3000SrhVO);
  } 

    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    public void insertXlsInsr4300(InputStream file) throws Exception {
       // dlgn0100DAO.insertXlsInsr4300(); //삭제호출 후 파일데이터 인서트  
        insr3000ExcelUploadService.uploadExcel("insr4300DAO.deleteXlsInsr4300_S","insr4300DAO.insertXlsInsr4300_S", file, 2, (long) 0);  
    } 
    
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    public void insertXlsInsr4100(InputStream file) throws Exception {
       // dlgn0100DAO.insertXlsInsr4300(); //삭제호출 후 파일데이터 인서트  
        insr3000ExcelUploadService.uploadExcel("insr4100DAO.updateXlsInsr4100_S", file, 2, (long) 0);  
    } 
    
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    public void insertXlsPsnl0127(InputStream file) throws Exception {
       // dlgn0100DAO.insertXlsInsr4300(); //삭제호출 후 파일데이터 인서트  
        insr3000ExcelUploadService.uploadExcel("pgmPsnl0127DAO.updateXlsPsnl0127_S", file, 2, (long) 0);  
    } 
 
    
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    public void insertXSSFInsr4300(InputStream file) throws Exception {
       // dlgn0100DAO.insertXlsInsr4300(); //삭제호출 후 파일데이터 인서트  
        insr3000XSSFExcelUploadService.uploadXSSFExcel("insr4300DAO.deleteXlsInsr4300_S","insr4300DAO.insertXlsInsr4300_S", file, 2, (long) 0);  
    }
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    public void insertXSSFInsr4100(InputStream file) throws Exception {
       // dlgn0100DAO.insertXlsInsr4300(); //삭제호출 후 파일데이터 인서트  
        insr3000ExcelUploadService.uploadExcel("insr4100DAO.updateXlsInsr4100_S", file, 2, (long) 0);  
    } 
    
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    public void insertXSSFPsnl0127(InputStream file) throws Exception {
       // dlgn0100DAO.insertXlsInsr4300(); //삭제호출 후 파일데이터 인서트  
        insr3000ExcelUploadService.uploadExcel("pgmPsnl0127DAO.updateXlsPsnl0127_S", file, 2, (long) 0);  
    } 
     
    /**
	 * 엑셀파일을 등록한다._jxls
	 * @param  hMap
	 * @throws Exception
	 */
	
	@Override
	public Long updateXlsInsr4100(List<Insr3000VO> insr3000List, HttpServletRequest request)throws MSFException {
		Long result = new Long(0);
		Long iCnt	= new Long(0);

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		try {  

			for(int iPsnlCnt = 0; iPsnlCnt < insr3000List.size(); iPsnlCnt++) {
				
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				
				Insr3000VO insr3000Vo = new Insr3000VO();
				Insr3200VO insr3200Vo = new Insr3200VO();
				InfcPkgPsnl0127VO psnl0127Vo = new InfcPkgPsnl0127VO();  
                InfcPkgPayr0500VO payr0500Vo = new InfcPkgPayr0500VO();
	
                int retVal = 0;
                
                insr3000Vo = insr3000List.get(iPsnlCnt);
                
                insr3200Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr3000Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
				
				retVal=insr3200DAO.selectInsr3000RegChkCnt(insr3200Vo);
                

				if(retVal > 0){  // 재직중인 인원만 월별 건강대사 테이블 insert
					
					insr3000Vo = insr3000List.get(iPsnlCnt);
					
					insr3000Vo.setDpobCd(sessionUser.getDpobCd()); //
					//insr3000Vo.setResnRegnNum(MSFSharedUtils.allowNulls(insr3000Vo.getResnRegnNum()));
					
					insr3000Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr3000Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
					
					insr3000Vo.setHlthInsrAqtnDt(MSFSharedUtils.allowNulls(insr3000Vo.getHlthInsrAqtnDt()));                                         /** column 건강보험취득일자 : hlthInsrAqtnDt */
					insr3000Vo.setIsmt(sessionUser.getUsrId());
					insr3000Vo.setRevnAddr(request.getRemoteAddr());
					
					
					Insr3000VO resultVo = insr3000DAO.selectXlsInsr3000(insr3000Vo);
					psnl0127Vo.setDpobCd(sessionUser.getDpobCd());
					psnl0127Vo.setHlthInsrPayTotAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(insr3000Vo.getHlthInsrPayTotAmnt(), "0")));          /** column 건강보험보수총액 : hlthInsrPayTotAmnt */
					insr3000Vo.setSocInsrDducEthdCd(ExtermsProps.getProps("INSR_SOC_INSR_DDUC_0100"));
					//if(MSFSharedUtils.paramNotNull(resultVo)){
					//	if( ExtermsProps.getProps("INSR_SOC_INSR_DDUC_0200").equals(MSFSharedUtils.allowNulls(resultVo.getSocInsrDducEthdCd()))) {
						//	insr3000Vo.setSocInsrDducEthdCd(ExtermsProps.getProps("INSR_SOC_INSR_DDUC_0200"));
						//	psnl0127Vo.setHlthInsrMnthRuntnAmnt(BigDecimal.ZERO);                                                                        /** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
						//}else{
						//	insr3000Vo.setSocInsrDducEthdCd(ExtermsProps.getProps("INSR_SOC_INSR_DDUC_0100"));
					psnl0127Vo.setHlthInsrMnthRuntnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(insr3000Vo.getHlthInsrMnthRuntnAmnt(), "0")));/** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
						//}
					//} else { 
						
					//	if((new BigDecimal(MSFSharedUtils.defaultNulls(insr3000Vo.getHlthInsrMnthRuntnAmnt(), "0"))).compareTo(BigDecimal.ZERO) <= 0)  {
						//	insr3000Vo.setSocInsrDducEthdCd(ExtermsProps.getProps("INSR_SOC_INSR_DDUC_0200"));
						// 	psnl0127Vo.setHlthInsrMnthRuntnAmnt(BigDecimal.ZERO);     
						//}else{
						//	insr3000Vo.setSocInsrDducEthdCd(ExtermsProps.getProps("INSR_SOC_INSR_DDUC_0100"));
						//	psnl0127Vo.setHlthInsrMnthRuntnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(insr3000Vo.getHlthInsrMnthRuntnAmnt(), "0")));/** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
						
						//}
					//}
					psnl0127Vo.setHlthInsrGrde(MSFSharedUtils.allowNulls(insr3000Vo.getHlthInsrGrde()));                                             /** column 건강보험등급 : hlthInsrGrde */
	                psnl0127Vo.setHlthInsrCertNum(MSFSharedUtils.allowNulls(insr3000Vo.getHlthInsrCertNum()));                                       /** column 건강보험증번호 : hlthInsrCertNum */ 
	                //psnl0127Vo.setResnRegnNum(MSFSharedUtils.allowNulls(insr3000Vo.getResnRegnNum()));               
	                psnl0127Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr3000Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
	                
	                psnl0127Vo.setHlthInsrApptnYn("Y"); //건강보험적용여부 업데이트 처리함               
	                psnl0127Vo.setIsmt(sessionUser.getUsrId());                                                                                      /** column 수정자 : ismt */ 
	                psnl0127Vo.setRevnAddr(request.getRemoteAddr());                                                                                 /** column 수정주소 : revnAddr */
	                                
	                //건강보험관리 저장시 PAYR0500 건강보험적용여부 업데이트
	                payr0500Vo.setDpobCd(sessionUser.getDpobCd());
	                payr0500Vo.setHlthInsrApptnYn("Y");
	                payr0500Vo.setIsmt(sessionUser.getUsrId());
	                payr0500Vo.setRevnAddr(request.getRemoteAddr());
	                //payr0500Vo.setResnRegnNum(MSFSharedUtils.allowNulls(insr3000Vo.getResnRegnNum()));
	                
	                payr0500Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr3000Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
	
	                insr3000DAO.updateXlsInsr4100ToInsr3000(insr3000Vo);
	                infcPsnl0127DAO.updateXlsInsr4100ToPsnl0127(psnl0127Vo); 
	                infcPayr0500DAO.updateXlsInsr4100ToPayr0500(payr0500Vo);
	                
	                iCnt = iCnt + 1L;
			
				}// if end
                
			} // for end 
			result = iCnt;
		} catch (Exception ex) {
			logger.error("EXCEPTION calling updateXlsInsr4100(): " + ex);
			result = new Long(0);
			throw MSFServerUtils.getOperationException("updateXlsInsr4100", ex, logger);
		} finally {
			
		}
		return result;
	}
}
