package org.msf.exterms.xls.service.impl;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.imp.MsfExcelService;
import org.msf.exterms.xls.service.Insr3100ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.Insr3100ServiceImpl;
import com.app.exterms.insurance.server.service.dao.Insr4100DAO;
import com.app.exterms.insurance.server.service.dao.Insr4200DAO;
import com.app.exterms.insurance.server.service.dao.Insr4300DAO;
import com.app.exterms.insurance.server.vo.Insr4100SrhVO;
import com.app.exterms.insurance.server.vo.Insr4100VO;
import com.app.exterms.insurance.server.vo.Insr4200VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0500DAO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0500VO;
import com.app.smrmf.infc.personal.server.service.dao.InfcPkgPsnl0127DAO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0127VO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("Insr3100ExcelService")
public class Insr3100ExcelServiceImpl extends AbstractServiceImpl implements Insr3100ExcelService {
    
	private static final Logger logger = LoggerFactory.getLogger(Insr3100ServiceImpl.class);
	
    @Autowired 
    @Resource(name="Insr4300DAO")
    private Insr4300DAO insr4300DAO;
    
    @Autowired 
    @Resource(name="Insr4100DAO")
    private Insr4100DAO insr4100DAO;

    @Autowired 
    @Resource(name="Insr4200DAO")
    private Insr4200DAO insr4200DAO;
    
    @Autowired 
    @Resource(name="InfcPkgPsnl0127DAO")
    private InfcPkgPsnl0127DAO infcPsnl0127DAO;
    
    @Autowired 
    @Resource(name="InfcPkgPayr0500DAO")
    private InfcPkgPayr0500DAO infcPayr0500DAO;    
    
    @Autowired  
    @Resource(name = "insr4300ExcelUploadService")
    private MsfExcelService insr4300ExcelUploadService;
    
    @Autowired 
    @Resource(name = "insr4300XSSFExcelUploadService")
    private MsfExcelService insr4300XSSFExcelUploadService;
    
     
  public List selectXlsInsr4100List(Insr4100SrhVO insr4100SrhVO) throws Exception {
      return insr4100DAO.selectXlsInsr4100List(insr4100SrhVO);
  } 

    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    public void insertXlsInsr4300(InputStream file) throws Exception {
       // dlgn0100DAO.insertXlsInsr4300(); //삭제호출 후 파일데이터 인서트  
        insr4300ExcelUploadService.uploadExcel("insr4300DAO.deleteXlsInsr4300_S","insr4300DAO.insertXlsInsr4300_S", file, 2, (long) 0);  
    } 
    
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    public void insertXlsInsr4100(InputStream file) throws Exception {
       // dlgn0100DAO.insertXlsInsr4300(); //삭제호출 후 파일데이터 인서트  
        insr4300ExcelUploadService.uploadExcel("insr4100DAO.updateXlsInsr4100_S", file, 2, (long) 0);  
    } 
    
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    public void insertXlsPsnl0127(InputStream file) throws Exception {
       // dlgn0100DAO.insertXlsInsr4300(); //삭제호출 후 파일데이터 인서트  
        insr4300ExcelUploadService.uploadExcel("pgmPsnl0127DAO.updateXlsPsnl0127_S", file, 2, (long) 0);  
    } 
 
    
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    public void insertXSSFInsr4300(InputStream file) throws Exception {
       // dlgn0100DAO.insertXlsInsr4300(); //삭제호출 후 파일데이터 인서트  
        insr4300XSSFExcelUploadService.uploadXSSFExcel("insr4300DAO.deleteXlsInsr4300_S","insr4300DAO.insertXlsInsr4300_S", file, 2, (long) 0);  
    }
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    public void insertXSSFInsr4100(InputStream file) throws Exception {
       // dlgn0100DAO.insertXlsInsr4300(); //삭제호출 후 파일데이터 인서트  
        insr4300ExcelUploadService.uploadExcel("insr4100DAO.updateXlsInsr4100_S", file, 2, (long) 0);  
    } 
    
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    public void insertXSSFPsnl0127(InputStream file) throws Exception {
       // dlgn0100DAO.insertXlsInsr4300(); //삭제호출 후 파일데이터 인서트  
        insr4300ExcelUploadService.uploadExcel("pgmPsnl0127DAO.updateXlsPsnl0127_S", file, 2, (long) 0);  
    } 
     
  
    /**
	 * 엑셀파일을 등록한다._jxls
	 * @param  hMap
	 * @throws Exception
	 */
	
	@Override
	public Long updateXlsInsr3100(List<Insr4100VO> insr4100List, HttpServletRequest request)throws MSFException {
		Long result = new Long(0);
		Long iCnt	= new Long(0);
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		try {
			
			for(int iPsnlCnt = 0; iPsnlCnt < insr4100List.size(); iPsnlCnt++) {
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				
				Insr4100VO insr4100Vo = new Insr4100VO();
				Insr4200VO insr4200Vo = new Insr4200VO();
				InfcPkgPsnl0127VO psnl0127Vo = new InfcPkgPsnl0127VO();  
                InfcPkgPayr0500VO payr0500Vo = new InfcPkgPayr0500VO();
                
                int retVal = 0;
                
                insr4100Vo = insr4100List.get(iPsnlCnt);
				
                insr4200Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr4100Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
				
				retVal=insr4200DAO.selectInsr4200RegChkCnt(insr4200Vo);
                
				if(retVal > 0){  // 재직중인 인원만 월별 건강대사 테이블 insert
                
		                insr4100Vo = insr4100List.get(iPsnlCnt);
						
						insr4100Vo.setDpobCd(sessionUser.getDpobCd()); //사업장코드				
						insr4100Vo.setSystemkey(insr4100Vo.getSystemkey()); //SYSTEMKEY
						insr4100Vo.getEmymtSeilNum(); //고용일련번호				
						insr4100Vo.setNatPennAqtnDt(insr4100Vo.getNatPennAqtnDt()); //국민연금취득일자
						insr4100Vo.setNatPennLssDt(""); //국민연금상실일자
						insr4100Vo.setKybdr(sessionUser.getUsrId());
						insr4100Vo.setInptAddr(request.getRemoteAddr());
						insr4100Vo.setIsmt(sessionUser.getUsrId());
						insr4100Vo.setRevnAddr(request.getRemoteAddr());
						
						psnl0127Vo.setDpobCd(sessionUser.getDpobCd()); //사업장코드				
						psnl0127Vo.setNatPennGrde(MSFSharedUtils.defaultNulls(insr4100Vo.getNatPennGrde(), ""));       //등급                                    
		 
						 
						psnl0127Vo.setNatPennStdIncmMnthAmnt(new BigDecimal(insr4100Vo.getNatPennStdIncmMnthAmnt()));    /** column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
		 
		                psnl0127Vo.setNatPennApptnYn("Y"); //국민연금적용여부
		                //psnl0127Vo.setResnRegnNum(MSFSharedUtils.allowNulls(insr4100Vo.getResnRegnNum())); //주민번호
		                psnl0127Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr4100Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
		                
		                
		                psnl0127Vo.setIsmt(sessionUser.getUsrId());                                                               
		                psnl0127Vo.setRevnAddr(request.getRemoteAddr());                                                  
		                                
		                payr0500Vo.setDpobCd(sessionUser.getDpobCd());
		                payr0500Vo.setNatPennApptnYn("Y"); //국민연금적용여부
		                payr0500Vo.setIsmt(sessionUser.getUsrId());
		                payr0500Vo.setRevnAddr(request.getRemoteAddr());
		                //payr0500Vo.setResnRegnNum(MSFSharedUtils.allowNulls(insr4100Vo.getResnRegnNum())); //주민번호
		                payr0500Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr4100Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
		                
						//insr4100DAO.deleteXlsInsr3100ToInsr4100(insr4100Vo);
						//insr4100DAO.insertXlsInsr3100ToInsr4100(insr4100Vo);				
						insr4100DAO.updateXlsInsr3100ToInsr4100(insr4100Vo);				
						infcPsnl0127DAO.updateXlsInsr3100ToPsnl0127(psnl0127Vo); 
		                infcPayr0500DAO.updateXlsInsr3100ToPayr0500(payr0500Vo);
				
		                iCnt = iCnt + 1L;
				} //if end
			}// for end
			result = iCnt;
		} catch (Exception ex) {
			logger.error("EXCEPTION calling updateXlsInsr3100(): " + ex);
			result = new Long(0);
			throw MSFServerUtils.getOperationException("updateXlsInsr3100", ex, logger);
		} finally {
			
		}
		return result;
	}
}
