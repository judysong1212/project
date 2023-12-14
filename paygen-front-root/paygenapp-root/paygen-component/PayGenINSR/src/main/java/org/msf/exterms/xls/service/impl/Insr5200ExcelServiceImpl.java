package org.msf.exterms.xls.service.impl;
 
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Insr5200ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.dao.Insr5200DAO;
import com.app.exterms.insurance.server.vo.Insr5200ExcelVO;
import com.app.exterms.insurance.server.vo.Insr5200SrhVO;
import com.app.exterms.insurance.server.vo.Insr5200VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("Insr5200ExcelService")
public class Insr5200ExcelServiceImpl extends AbstractServiceImpl implements Insr5200ExcelService {
    
	private static final Logger logger = LoggerFactory.getLogger(Insr5200ExcelServiceImpl.class);
     
    @Autowired 
    @Resource(name="Insr5200DAO")
    private Insr5200DAO insr5200DAO;
    
//    @Autowired 
//    @Resource(name="InfcPkgPsnl0127DAO")
//    private InfcPkgPsnl0127DAO infcPsnl0127DAO;
//    
//    @Autowired 
//    @Resource(name="InfcPkgPayr0500DAO")
//    private InfcPkgPayr0500DAO infcPayr0500DAO;
//    
//    @Autowired  
//    @Resource(name = "insr5200ExcelUploadService")
//    private MsfExcelService insr5200ExcelUploadService;
//    
//    @Autowired 
//    @Resource(name = "insr5200XSSFExcelUploadService")
//    private MsfExcelService insr5200XSSFExcelUploadService;
    
     
  public List selectXlsInsr5200List(Insr5200SrhVO insr5200SrhVO) throws Exception {
     return insr5200DAO.selectXlsInsr5200List(insr5200SrhVO);
  } 


    @Override
    public Long updateXlsInsr5200(List<Insr5200ExcelVO> insr5200List, HttpServletRequest request)throws MSFException {
		Long result = new Long(0);
		Long iCnt	= new Long(0);
		int chkRegNum = 0;    // 주민번호로 시스템에 건강보험 가입 직원인지 체크  
//		System.out.println("updateXlsInsr4200 ENter ==============================================okokokokokokokokok");
//		System.out.println(" insr5200List.size : " + insr5200List.size());
		
//		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		try {

			for(int iPsnlCnt = 0; iPsnlCnt < insr5200List.size(); iPsnlCnt++) {
				
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				
				int retVal = 0;
				
				Insr5200ExcelVO insr5200ExcelVo = new Insr5200ExcelVO();
				
				Insr5200VO insr5200Vo = new Insr5200VO();
				
				insr5200ExcelVo = insr5200List.get(iPsnlCnt);
				
				insr5200Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr5200ExcelVo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
				
				retVal=insr5200DAO.selectInsr5200RegChkCnt(insr5200Vo);
				
				
				//retVal= 1;
				//System.out.println("retVal=========================="+retVal);
				
				if(retVal > 0){  // 재직중인 인원만 월별 건강대사 테이블 insert
					
					insr5200Vo = new Insr5200VO();
					insr5200ExcelVo = new Insr5200ExcelVO();
					insr5200ExcelVo = insr5200List.get(iPsnlCnt);
					
					
					insr5200Vo.setDpobCd(sessionUser.getDpobCd());    /** column 사업장코드 : dpobCd */
					insr5200Vo.setSystemkey(insr5200ExcelVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
					insr5200Vo.setDducYrMnth(insr5200ExcelVo.getDducYrMnth());    /** column 납부년월 : dducYrMnth */
					insr5200Vo.setEmymtSeilNum( new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getEmymtSeilNum(),"0")));    /** column 고용일련번호 : emymtSeilNum */
					insr5200Vo.setIposYrMnth(insr5200ExcelVo.getIposYrMnth());    /** column 부과년월 : iposYrMnth */
					insr5200Vo.setHanNm(insr5200ExcelVo.getHanNm());    /** column 한글성명 : hanNm */
					insr5200Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr5200ExcelVo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));;    /** column 주민등록번호 : resnRegnNum */
					insr5200Vo.setUmytInsrBgnnDt(insr5200ExcelVo.getUmytInsrBgnnDt());    /** column 고용시작일자 : umytInsrBgnnDt */
					insr5200Vo.setUmytInsrEndDt(insr5200ExcelVo.getUmytInsrEndDt());    /** column 고용종료일자 : umytInsrEndDt */
					insr5200Vo.setMnthAvgPayMnthAmnt( new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getMnthAvgPayMnthAmnt(),"0")));    /** column 월평균보수월액 : mnthAvgPayMnthAmnt */
					insr5200Vo.setCmpttnWkppUneplrtSum( new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getCmpttnWkppUneplrtSum(),"0")));    /** column 산정_근로자실업급여보험금액 : cmpttnWkppUneplrtSum */
					insr5200Vo.setCmpttnEplrUneplrtSum( new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getCmpttnEplrUneplrtSum(),"0")));    /** column 산정_사업주실업급여보험금액 : cmpttnEplrUneplrtSum */
					insr5200Vo.setCmpttnEplrFncdsnInsurSum( new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getCmpttnEplrFncdsnInsurSum(),"0")));    /** column 산정_사업주고안직능보험금액 : cmpttnEplrFncdsnInsurSum */
					insr5200Vo.setRecpttnWkppUneplrtSum( new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getRecpttnWkppUneplrtSum(),"0")));    /** column 재산정_근로자실업급여보험금액 : recpttnWkppUneplrtSum */
					insr5200Vo.setRecpttnEplrUneplrtSum( new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getRecpttnEplrUneplrtSum(),"0")));    /** column 재산정_사업주실럽급여보험금액 : recpttnEplrUneplrtSum */
					insr5200Vo.setRecpttnEplrFncdsnSum( new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getRecpttnEplrFncdsnSum(),"0")));    /** column 재산정_사업주고안직능보험금액 : recpttnEplrFncdsnSum */
					insr5200Vo.setClutPayTotAmnt( new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getClutPayTotAmnt(),"0")));    /** column 정산보수총액 : clutPayTotAmnt */
					insr5200Vo.setClutWkppUneplrtSum( new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getClutWkppUneplrtSum(),"0")));    /** column 정산_근로자실업급여보험금액 : clutWkppUneplrtSum */
					insr5200Vo.setClutEplrUneplrtSum( new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getClutEplrUneplrtSum(),"0")));    /** column 정산_사업주실업급여보험금액 : clutEplrUneplrtSum */
					insr5200Vo.setClutEplrFncdsnSum( new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getClutEplrFncdsnSum(),"0")));    /** column 정산_사업주실업고안직능보험금액 : clutEplrFncdsnSum */
					insr5200Vo.setUmytInsrApmrt( new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getUmytInsrApmrt(),"0")));    /** column 고용보험요율 : umytInsrApmrt */
					insr5200Vo.setPayCalcEmymtInsurSum( new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getPayCalcEmymtInsurSum(),"0")));    /** column 급여산출고용보험금액 : payCalcEmymtInsurSum */
					insr5200Vo.setIndvUneplrtPymtAggrSum( new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getIndvUneplrtPymtAggrSum(),"0")));    /** column 개인실업급여납부보헙합계금액 : indvUneplrtPymtAggrSum */
					insr5200Vo.setEplrUneplrtPymtAggrSum( new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getEplrUneplrtPymtAggrSum(),"0")));    /** column 사업주실업급여보험합계금액 : eplrUneplrtPymtAggrSum */
					insr5200Vo.setEplrFncdsnAggrSum( new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getEplrFncdsnAggrSum(),"0")));    /** column 사업주고안직능보험합계금액 : eplrFncdsnAggrSum */
					insr5200Vo.setUmytPayrDducYrMnth(insr5200ExcelVo.getUmytPayrDducYrMnth());    /** column 고용보험급여공제년월 : umytPayrDducYrMnth */
					insr5200Vo.setUmytInsrPrcsDt(insr5200ExcelVo.getUmytInsrPrcsDt());    /** column 고용보험처리일자 : umytInsrPrcsDt */
					insr5200Vo.setUmytInsrPrcsYn(insr5200ExcelVo.getUmytInsrPrcsYn());    /** column 고용보험처리여부 : umytInsrPrcsYn */
					insr5200Vo.setUmytInsrPrmmSrd( new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getUmytInsrPrmmSrd(),"0")));    /** column 개인실업급여고용보험차액 : umytInsrPrmmSrd */
					insr5200Vo.setDivdPymtDivCd(insr5200ExcelVo.getDivdPymtDivCd());    /** column 분할납부구분코드 : divdPymtDivCd */
					insr5200Vo.setDivdPymt(new Long(MSFSharedUtils.defaultNulls(insr5200ExcelVo.getDivdPymt(),"0")));    /** column 분할납부횟수 : divdPymt */
					insr5200Vo.setKybdr(insr5200ExcelVo.getKybdr());    /** column 입력자 : kybdr */
					insr5200Vo.setInptDt(insr5200ExcelVo.getInptDt());    /** column 입력일자 : inptDt */
					insr5200Vo.setInptAddr(insr5200ExcelVo.getInptAddr());    /** column 입력주소 : inptAddr */
					insr5200Vo.setIsmt(insr5200ExcelVo.getIsmt());    /** column 수정자 : ismt */
					insr5200Vo.setRevnDt(insr5200ExcelVo.getRevnDt());    /** column 수정일자 : revnDt */
					insr5200Vo.setRevnAddr(insr5200ExcelVo.getRevnAddr());    /** column 수정주소 : revnAddr */
					
//					insr3200Vo.setSystemkey(												insr3200Vo.getSystemkey());
//					insr3200Vo.setDpobCd(												   sessionUser.getDpobCd());
//					insr3200Vo.setNofctYrMnth(					MSFSharedUtils.allowNulls(	insr3200Vo.getNofctYrMnth()));
//					insr3200Vo.setNofctDspty(												insr3200Vo.getNofctDspty());
//					insr3200Vo.setEmymtSeilNum(		   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getEmymtSeilNum(),		"0")));
//					insr3200Vo.setDpobMangeNum(					MSFSharedUtils.allowNulls(	insr3200Vo.getDpobMangeNum()));
//					insr3200Vo.setUntIstutCd(					MSFSharedUtils.allowNulls(	insr3200Vo.getUntIstutCd()));
//					insr3200Vo.setAccSgn(						MSFSharedUtils.allowNulls(	insr3200Vo.getAccSgn()));
//					insr3200Vo.setHlthInsrCertNum(				MSFSharedUtils.allowNulls(	insr3200Vo.getHlthInsrCertNum()));
//					insr3200Vo.setHanNm(						MSFSharedUtils.allowNulls(	insr3200Vo.getHanNm()));
//					//insr3200Vo.setResnRegnNum(					MSFSharedUtils.allowNulls(	insr3200Vo.getResnRegnNum()));
//					insr3200Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr3200Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
//					
//					
//					insr3200Vo.setReduReasCd(					MSFSharedUtils.allowNulls(	insr3200Vo.getReduReasCd()));
//					insr3200Vo.setReduReasNm(					MSFSharedUtils.allowNulls(	insr3200Vo.getReduReasNm()));
//					insr3200Vo.setHlthInsrTypOccuCd(			MSFSharedUtils.allowNulls(	insr3200Vo.getHlthInsrTypOccuCd()));
//					insr3200Vo.setPayMnthAmntGrde(				MSFSharedUtils.allowNulls(	insr3200Vo.getPayMnthAmntGrde()));
//					insr3200Vo.setPayMnthAmnt(		   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getPayMnthAmnt(),		  "0")));
//					insr3200Vo.setDducYrMnth(					MSFSharedUtils.allowNulls(	insr3200Vo.getDducYrMnth()));
//					insr3200Vo.setHlthInsrPrcsYn(				MSFSharedUtils.allowNulls(	insr3200Vo.getHlthInsrPrcsYn()));
//					insr3200Vo.setCalcPrmm(			   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getCalcPrmm(),			  "0")));
//					insr3200Vo.setSanCalcPrmm(		   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getSanCalcPrmm(),		  "0")));
//					insr3200Vo.setHlthInsrPrmmSrd(	   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getHlthInsrPrmmSrd(),	  "0")));
//					insr3200Vo.setClutReasCd(					MSFSharedUtils.allowNulls(	insr3200Vo.getClutReasCd()));
//					insr3200Vo.setClutApptnBgnnYrMnth(			MSFSharedUtils.allowNulls(	insr3200Vo.getClutApptnBgnnYrMnth()));
//					insr3200Vo.setClutApptnEndYrMnth(			MSFSharedUtils.allowNulls(	insr3200Vo.getClutApptnEndYrMnth()));
//					insr3200Vo.setClutPrmm(			   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getClutPrmm(),			  "0")));
//					insr3200Vo.setNofctPrmm(		   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getNofctPrmm(),			  "0")));
//					insr3200Vo.setYrtxPrmm(			   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getYrtxPrmm(),			  "0")));
//					insr3200Vo.setAqtnDt(						MSFSharedUtils.allowNulls(	insr3200Vo.getAqtnDt()));
//					insr3200Vo.setLssDt(						MSFSharedUtils.allowNulls(	insr3200Vo.getLssDt()));
//					insr3200Vo.setLgtmRcptnCalcPrmm(   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getLgtmRcptnCalcPrmm(),	  "0")));
//					insr3200Vo.setSanLgtmRcptnCalcPrmm(new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getSanLgtmRcptnCalcPrmm(), "0")));
//					insr3200Vo.setLgtmRcptnInsurSrd(   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getLgtmRcptnInsurSrd(),	  "0")));
//					insr3200Vo.setLgtmRcptnClutReasCd(			MSFSharedUtils.allowNulls(	insr3200Vo.getLgtmRcptnClutReasCd()));
//					insr3200Vo.setLgtmRcptnApptnBgnnYrMnth(		MSFSharedUtils.allowNulls(	insr3200Vo.getLgtmRcptnApptnBgnnYrMnth()));
//					insr3200Vo.setLgtmRcptnApptnEndYrMnth(		MSFSharedUtils.allowNulls(	insr3200Vo.getLgtmRcptnApptnEndYrMnth()));
//					insr3200Vo.setLgtmRcptnClutPrmm(   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getLgtmRcptnClutPrmm(),	  "0")));
//					insr3200Vo.setLgtmRcptnNofctPrmm(  new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getLgtmRcptnNofctPrmm(),   "0")));
//					insr3200Vo.setLgtmRcptnYrtxPrmm(   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getLgtmRcptnYrtxPrmm(),	  "0")));
//					insr3200Vo.setHlthRcptnCalcPrmm(   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getHlthRcptnCalcPrmm(),	  "0")));
//					insr3200Vo.setHlthRcptnClutPrmm(   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getHlthRcptnClutPrmm(),	  "0")));
//					insr3200Vo.setHlthRcptnNofctPrmm(  new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getHlthRcptnNofctPrmm(),   "0")));
//					insr3200Vo.setHlthRcptnYrtxPrmm(   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getHlthRcptnYrtxPrmm(),	  "0")));
//					insr3200Vo.setHlthInsrRefdItrt(	   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getHlthInsrRefdItrt(),	  "0")));
//					insr3200Vo.setLgtmRcptnRefdItrt(   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getLgtmRcptnRefdItrt(),	  "0")));
//					insr3200Vo.setTotPymtPrmm(		   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getTotPymtPrmm(),		  "0")));
//					insr3200Vo.setSrdAggrSum(		   new Long(MSFSharedUtils.defaultNulls(insr3200Vo.getSrdAggrSum(),			  "0")));
//					insr3200Vo.setKybdr(												   sessionUser.getUsrId());
//					insr3200Vo.setInptDt(													insr3200Vo.getInptDt());
//	//				insr3200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//					insr3200Vo.setIsmt(													   sessionUser.getUsrId());
//					insr3200Vo.setRevnDt(													insr3200Vo.getRevnDt());
//	//				insr3200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
					
					insr5200DAO.deleteInsr5200(insr5200Vo);
					insr5200DAO.insertInsr5200(insr5200Vo);
					
					iCnt = iCnt +1L;
				
				} // end if 
				System.out.println("iCnt=========================="+iCnt);
            } // end for
			
			result = iCnt;
			System.out.println("result=========================="+result);
		} catch (Exception ex) {
			logger.error("EXCEPTION calling updateXlsInsr5200(): " + ex);
			result = new Long(0);
			throw MSFServerUtils.getOperationException("updateXlsInsr5200", ex, logger);
		} finally {
			
		}
		return result;
	}
  
}
