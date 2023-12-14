package org.msf.exterms.xls.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Insr4500ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.Insr4500ServiceImpl;
import com.app.exterms.insurance.server.service.dao.Insr3100DAO;
import com.app.exterms.insurance.server.vo.Insr3100SrhVO;
import com.app.exterms.insurance.server.vo.Insr3100VO;
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

@Service("insr4500ExcelService")
public class Insr4500ExcelServiceImpl extends AbstractServiceImpl implements Insr4500ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(Insr4500ServiceImpl.class);
	private static final String calledClass = Insr4500ExcelService.class.getName();
	
	@Autowired
	@Resource(name = "Insr3100DAO")
	private Insr3100DAO insr3100DAO;
	
    @Autowired 
    @Resource(name="InfcPkgPsnl0127DAO")
    private InfcPkgPsnl0127DAO infcPsnl0127DAO;
    
    @Autowired 
    @Resource(name="InfcPkgPayr0500DAO")
    private InfcPkgPayr0500DAO infcPayr0500DAO;
	
//	@Autowired
//	@Resource(name = "insr4500ExcelUploadService")
//	private MsfExcelService insr4500ExcelUploadService;
	
	public List selectXlsInsr3100List(Insr3100SrhVO insr3100SrhVO) throws Exception {
		return insr3100DAO.selectXlsInsr3100List(insr3100SrhVO);
	}

//public void updateXlsInsr3100(InputStream file) throws Exception {
//	insr4500ExcelUploadService.uploadExcel("insr3100DAO.deleteXlsInsr3100", "insr3100DAO.insertXlsInsr3100", file, 3, (long) 0);
//}
	/**
	 * 엑셀파일을 등록한다._jxls
	 * @param  hMap
	 * @throws Exception
	 */
	
	@Override
	public Long updateXlsInsr4500(List<Insr3100VO> insr3100List, HttpServletRequest request)throws MSFException {
		Long result = new Long(0);
		Long iCnt	= new Long(0);
		System.out.println(" insr3100List.size : " + insr3100List.size());
		
//		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		try {

			
			for(int iPsnlCnt = 0; iPsnlCnt < insr3100List.size(); iPsnlCnt++) {
				
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				
				Insr3100VO insr3100Vo = new Insr3100VO();
				InfcPkgPsnl0127VO psnl0127Vo = new InfcPkgPsnl0127VO();  
                InfcPkgPayr0500VO payr0500Vo = new InfcPkgPayr0500VO();
				
				insr3100Vo = insr3100List.get(iPsnlCnt);
				
				insr3100Vo.setDpobCd(														 sessionUser.getDpobCd()); 
				insr3100Vo.setNofctYrMnthNum(					  MSFSharedUtils.allowNulls(  insr3100Vo.getNofctYrMnthNum()));
				insr3100Vo.setSystemkey(													  insr3100Vo.getSystemkey());
				insr3100Vo.setDspty(														  insr3100Vo.getDspty());
				insr3100Vo.setEmymtSeilNum(													  insr3100Vo.getEmymtSeilNum());
				insr3100Vo.setHlthInsrSeilNum(	   new BigDecimal(MSFSharedUtils.defaultNulls(insr3100Vo.getHlthInsrSeilNumStr(),		"0")));
				insr3100Vo.setDeptNm(							  MSFSharedUtils.allowNulls(  insr3100Vo.getDeptNm()));
				insr3100Vo.setDpobMangeNum(						  MSFSharedUtils.allowNulls(  insr3100Vo.getDpobMangeNum()));
				insr3100Vo.setAcc(								  MSFSharedUtils.allowNulls(  insr3100Vo.getAcc()));
				insr3100Vo.setUntDpobCd(						  MSFSharedUtils.allowNulls(  insr3100Vo.getUntDpobCd()));
				insr3100Vo.setCertNumHuhd(						  MSFSharedUtils.allowNulls(  insr3100Vo.getCertNumHuhd()));
				insr3100Vo.setNm(								  MSFSharedUtils.allowNulls(  insr3100Vo.getNm()));
				//insr3100Vo.setResnRegnNum(						  MSFSharedUtils.allowNulls(  insr3100Vo.getResnRegnNum()));
				
				insr3100Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr3100Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
				
				insr3100Vo.setHlthYrtxApptnYrMnth(				  MSFSharedUtils.allowNulls(  insr3100Vo.getHlthYrtxApptnYrMnth()));
				insr3100Vo.setHlthInsrYrtxPrcsYn(				  MSFSharedUtils.allowNulls(  insr3100Vo.getHlthInsrYrtxPrcsYn()));
				insr3100Vo.setIposTotPrmmAggr(	   new BigDecimal(MSFSharedUtils.defaultNulls(insr3100Vo.getIposTotPrmmAggr(),		"0")));
				insr3100Vo.setIposTotPrmmHlth(	   new BigDecimal(MSFSharedUtils.defaultNulls(insr3100Vo.getIposTotPrmmHlth(),		"0")));
				insr3100Vo.setIposTotPrmmLgtmRcptn(new BigDecimal(MSFSharedUtils.defaultNulls(insr3100Vo.getIposTotPrmmLgtmRcptn(), "0")));
				insr3100Vo.setYrlyPayTotAmnt(	   new Long(	  MSFSharedUtils.defaultNulls(insr3100Vo.getYrlyPayTotAmnt(),		"0")));
				insr3100Vo.setPayMnthAmnt(		   new Long(	  MSFSharedUtils.defaultNulls(insr3100Vo.getPayMnthAmnt(),			"0")));
				insr3100Vo.setYrtxCalcBkdnGrde(					  MSFSharedUtils.allowNulls(  insr3100Vo.getYrtxCalcBkdnGrde()));
				insr3100Vo.setStdPayMnthAmnt(	   new Long(	  MSFSharedUtils.defaultNulls(insr3100Vo.getStdPayMnthAmnt(),		"0")));
				insr3100Vo.setFixPrmmAggr(		   new BigDecimal(MSFSharedUtils.defaultNulls(insr3100Vo.getFixPrmmAggr(),			"0")));
				insr3100Vo.setFixPrmmHlth(		   new BigDecimal(MSFSharedUtils.defaultNulls(insr3100Vo.getFixPrmmHlth(),			"0")));
				insr3100Vo.setFixPrmmLgtmRcptn(	   new BigDecimal(MSFSharedUtils.defaultNulls(insr3100Vo.getFixPrmmLgtmRcptn(),		"0")));
				insr3100Vo.setClutPrmmAggr(		   new BigDecimal(MSFSharedUtils.defaultNulls(insr3100Vo.getClutPrmmAggr(),			"0")));
				insr3100Vo.setClutPrmmHlth(		   new BigDecimal(MSFSharedUtils.defaultNulls(insr3100Vo.getClutPrmmHlth(),			"0")));
				insr3100Vo.setClutPrmmLgtmRcptn(   new BigDecimal(MSFSharedUtils.defaultNulls(insr3100Vo.getClutPrmmLgtmRcptn(),	"0")));
				insr3100Vo.setMbrAlttAggr(		   new BigDecimal(MSFSharedUtils.defaultNulls(insr3100Vo.getMbrAlttAggr(),			"0")));
				insr3100Vo.setMbrAlttHlth(		   new BigDecimal(MSFSharedUtils.defaultNulls(insr3100Vo.getMbrAlttHlth(),			"0")));
				insr3100Vo.setMbrAlttLgtmRcptn(	   new BigDecimal(MSFSharedUtils.defaultNulls(insr3100Vo.getMbrAlttLgtmRcptn(),		"0")));
				insr3100Vo.setUsrAlttAggr(		   new BigDecimal(MSFSharedUtils.defaultNulls(insr3100Vo.getUsrAlttAggr(),			"0")));
				insr3100Vo.setUsrAlttHlth(		   new BigDecimal(MSFSharedUtils.defaultNulls(insr3100Vo.getUsrAlttHlth(),			"0")));
				insr3100Vo.setUsrAlttLgtmRcptn(	   new BigDecimal(MSFSharedUtils.defaultNulls(insr3100Vo.getUsrAlttLgtmRcptn(),		"0")));
				insr3100Vo.setNofctSspn(						  MSFSharedUtils.allowNulls(  insr3100Vo.getNofctSspn()));
				insr3100Vo.setTypOccuNm(						  MSFSharedUtils.allowNulls(  insr3100Vo.getTypOccuNm()));
				insr3100Vo.setDtilOccuClsNm(					  MSFSharedUtils.allowNulls(  insr3100Vo.getDtilOccuClsNm()));
				insr3100Vo.setHlthYrtxPrcsDt(					  MSFSharedUtils.allowNulls(  insr3100Vo.getHlthYrtxPrcsDt()));
				insr3100Vo.setDivdPymtDivCd(					  MSFSharedUtils.allowNulls(  insr3100Vo.getDivdPymtDivCd()));
				insr3100Vo.setDivdPymt(			   new BigDecimal(MSFSharedUtils.defaultNulls(insr3100Vo.getDivdPymt(),				"0")));
				insr3100Vo.setKybdr(														 sessionUser.getUsrId());
//				insr3100Vo.setInptDt(														  insr3100Vo.getInptDt());
				insr3100Vo.setInptAddr(															 request.getRemoteHost());
				insr3100Vo.setIsmt(															 sessionUser.getUsrId());
//				insr3100Vo.setRevnDt(														  insr3100Vo.getRevnDt());
				insr3100Vo.setRevnAddr(															 request.getRemoteHost());
						
				psnl0127Vo.setDpobCd(sessionUser.getDpobCd());
				psnl0127Vo.setHlthInsrPayTotAmnt( new BigDecimal(MSFSharedUtils.defaultNulls( insr3100Vo.getYrlyPayTotAmnt(),"0")));  // 건강보험 연말정산 급여총액
				psnl0127Vo.setHlthInsrMnthRuntnAmnt( new BigDecimal(MSFSharedUtils.defaultNulls( insr3100Vo.getStdPayMnthAmnt(),"0")));  // 건강보험 연말정산 월평균보수총액
				psnl0127Vo.setHlthInsrGrde(MSFSharedUtils.defaultNulls( insr3100Vo.getYrtxCalcBkdnGrde(),""));  //건강보험 연말정산 등급
				psnl0127Vo.setHlthInsrCertNum(MSFSharedUtils.defaultNulls( insr3100Vo.getCertNumHuhd(),""));  //건강보험 연말정산 증번호
				psnl0127Vo.setHlthInsrApptnYn("Y");
                psnl0127Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr3100Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
                psnl0127Vo.setIsmt(sessionUser.getUsrId());                                                              
                psnl0127Vo.setRevnAddr(request.getRemoteAddr());                                                  
                                
                payr0500Vo.setDpobCd(sessionUser.getDpobCd());
                payr0500Vo.setHlthInsrApptnYn("Y");
                payr0500Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr3100Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
                payr0500Vo.setIsmt(sessionUser.getUsrId());
                payr0500Vo.setRevnAddr(request.getRemoteAddr());
				
	               // insr3100DAO
                if( 0 < insr3100DAO.selectPsnl0100TotCnt(insr3100Vo)){
				
					insr3100DAO.deleteXlsInsr3100(insr3100Vo);
					insr3100DAO.insertXlsInsr3100(insr3100Vo);
					
					infcPsnl0127DAO.updateXlsInsr4100ToPsnl0127(psnl0127Vo); 
	                infcPayr0500DAO.updateXlsInsr4100ToPayr0500(payr0500Vo);
                }else{
                	logger.error("건강보험연말정산  PSNL0100  및 INSR3000 테이블 데이터 미존재 : "+insr3100Vo.getNm()+"("+insr3100Vo.getResnRegnNum()+")");
                }  
                iCnt = iCnt + 1L ;
			}  // for end
			result = iCnt;
		} catch (Exception ex) {
			logger.error("EXCEPTION calling updateXlsInsr4500(): " + ex);
			result = new Long(0);
			throw MSFServerUtils.getOperationException("updateXlsInsr4500", ex, logger);
		} finally {
			
		}
		return result;
	}
}