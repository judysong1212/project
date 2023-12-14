package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Insr3150ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.dao.Insr4200DAO;
import com.app.exterms.insurance.server.vo.Insr4200ExcelVO;
import com.app.exterms.insurance.server.vo.Insr4200SrhVO;
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

@Service("Insr3150ExcelService")
public class Insr3150ExcelServiceImpl extends AbstractServiceImpl implements Insr3150ExcelService {
    
	private static final Logger logger = LoggerFactory.getLogger(Insr3150ExcelServiceImpl.class);
	//private static final Logger logger = LoggerFactory.getLogger(Insr3150ServiceImpl.class);
	
    @Autowired 
    @Resource(name="Insr4200DAO")
    private Insr4200DAO insr4200DAO;
    
    @Autowired 
    @Resource(name="InfcPkgPsnl0127DAO")
    private InfcPkgPsnl0127DAO infcPsnl0127DAO;
    
    @Autowired 
    @Resource(name="InfcPkgPayr0500DAO")
    private InfcPkgPayr0500DAO infcPayr0500DAO;

    public List selectXlsInsr4200List(Insr4200SrhVO insr4200SrhVO) throws Exception {
    	return insr4200DAO.selectXlsInsr3150ToInsr4200List(insr4200SrhVO);
	}
    
    
    
    /**
	 * 엑셀파일을 등록한다._jxls
	 * @param  hMap
	 * @throws Exception
	 */
	
	@Override
	public Long updateXlsInsr3150(List<Insr4200ExcelVO> insr4200List, HttpServletRequest request) throws MSFException {
		Long result = new Long(0);
		Long iCnt	= new Long(0);
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		try {

			for(int iPsnlCnt = 0; iPsnlCnt < insr4200List.size(); iPsnlCnt++) {
				
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				
				int retVal = 0;
				
				Insr4200ExcelVO insr4200ExcelVo = new Insr4200ExcelVO();
				
				Insr4200VO insr4200Vo = new Insr4200VO();
				
				insr4200ExcelVo = insr4200List.get(iPsnlCnt);
				
				insr4200ExcelVo = insr4200List.get(iPsnlCnt);
				
				insr4200Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr4200ExcelVo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
				
				retVal=insr4200DAO.selectInsr4200RegChkCnt(insr4200Vo);
				
				if(retVal > 0){  // 재직중인 인원만 월별 건강대사 테이블 insert
				
					insr4200Vo = new Insr4200VO();
					InfcPkgPsnl0127VO psnl0127Vo = new InfcPkgPsnl0127VO();  
	                InfcPkgPayr0500VO payr0500Vo = new InfcPkgPayr0500VO();
					
	                insr4200ExcelVo = insr4200List.get(iPsnlCnt);
					
	                insr4200Vo.setDpobCd(sessionUser.getDpobCd()); //사업장코드
	                insr4200Vo.setDducYrMnth(insr4200ExcelVo.getDducYrMnth()); // 공제년월
					insr4200Vo.setHanNm(insr4200ExcelVo.getHanNm()); //이름
					//insr4200Vo.setResnRegnNum(insr4200Vo.getResnRegnNum());     //주민등록번호			
					
					String tmp = insr4200Vo.getResnRegnNum() ;
					String tmp2 = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr4200ExcelVo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);
	//				System.out.println("System RegNum Encoding =============================================="+tmp2);
					
					insr4200Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr4200ExcelVo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
					
					insr4200Vo.setRegrstIncmTotAmnt(new Long(MSFSharedUtils.defaultNulls(insr4200ExcelVo.getRegrstIncmTotAmnt(), "0")));     //신고소득총액
					insr4200Vo.setDeinStdIncmMnthAmnt(new Long(MSFSharedUtils.defaultNulls(insr4200ExcelVo.getDeinStdIncmMnthAmnt(), "0")));     //결정기준소득월액
					insr4200Vo.setDeinMnthPrmm(new Long(MSFSharedUtils.defaultNulls(insr4200ExcelVo.getDeinMnthPrmm(), "0")));     //결정월보험료
					
					insr4200Vo.setIndvBrdnSum(new Long(MSFSharedUtils.defaultNulls(insr4200ExcelVo.getIndvBrdnSum(), "0")));     //본인부담액
					insr4200Vo.setReattyQnty(new Long(MSFSharedUtils.defaultNulls(insr4200ExcelVo.getReattyQnty(), "0")));     //본인소급보험료
					insr4200Vo.setHmlfClutPrmm(new Long(MSFSharedUtils.defaultNulls(insr4200ExcelVo.getHmlfClutPrmm(), "0")));     //본인정산보험료
					Long hmlfPrmmAggr = insr4200Vo.getIndvBrdnSum()+insr4200Vo.getReattyQnty()+insr4200Vo.getHmlfClutPrmm();
					insr4200Vo.setHmlfPrmmAggr(hmlfPrmmAggr);     //본인보험료계
					
					insr4200Vo.setDpobBrdnSum(new Long(MSFSharedUtils.defaultNulls(insr4200ExcelVo.getDpobBrdnSum(), "0")));     //사업장부담액
					insr4200Vo.setBusoprClutPrmm(new Long(MSFSharedUtils.defaultNulls(insr4200ExcelVo.getBusoprClutPrmm(), "0")));     //사업자정산보험료
					insr4200Vo.setBusoprReattyPrmm(new Long(MSFSharedUtils.defaultNulls(insr4200ExcelVo.getBusoprReattyPrmm(), "0")));     //사업자소급보험료
					Long busoprPrmmAggr = insr4200Vo.getDpobBrdnSum()+insr4200Vo.getBusoprClutPrmm()+insr4200Vo.getBusoprReattyPrmm();
					insr4200Vo.setBusoprPrmmAggr(busoprPrmmAggr);     //사업자보험료계
					
					insr4200Vo.setAggr(new Long(MSFSharedUtils.defaultNulls(insr4200ExcelVo.getAggr(), "0")));      //본인납부보험료계
					insr4200Vo.setFluc(insr4200ExcelVo.getFluc());     //변동구분
					insr4200Vo.setAqtnMnthPymtYn(insr4200ExcelVo.getAqtnMnthPymtYn());     //취득월납부여부
					insr4200Vo.setFlucDt(insr4200ExcelVo.getFlucDt());     //변동일자
					insr4200Vo.setFlucReasCtnt(insr4200ExcelVo.getFlucReasCtnt());     //변동사유내용
					insr4200Vo.setPbcorpOautyDeinYn(insr4200ExcelVo.getPbcorpOautyDeinYn());     //공단직권결정여부
					
					insr4200Vo.setNatPayrDducYrMnth(insr4200ExcelVo.getNatPayrDducYrMnth());     //국민연금급여공제년월
					
					insr4200Vo.setNatInsrPrcsDt(insr4200ExcelVo.getNatInsrPrcsDt());     //국민연금처리일자
					insr4200Vo.setNatInsrPrcsYn("N");     //국민연금처리여부
					insr4200Vo.setNatInsrPrmmSrd(new Long(MSFSharedUtils.defaultNulls(insr4200ExcelVo.getNatInsrPrmmSrd(), "0")));     //국민연금차액
					insr4200Vo.setDivdPymtDivCd("B0300010");     //분할납부구분코드
					insr4200Vo.setDivdPymt(0L);     //분할납부회수
					insr4200Vo.setNatPennSymNum(MSFSharedUtils.defaultNulls(insr4200ExcelVo.getNatPennSymNum(), ""));     //국민연금기호번호 
					
					insr4200Vo.setKybdr(sessionUser.getUsrId());
					insr4200Vo.setInptAddr(request.getRemoteAddr());
					insr4200Vo.setIsmt(sessionUser.getUsrId());
					insr4200Vo.setRevnAddr(request.getRemoteAddr());
					
					psnl0127Vo.setDpobCd(sessionUser.getDpobCd());
	                psnl0127Vo.setNatPennApptnYn("Y");
	                //psnl0127Vo.setResnRegnNum(MSFSharedUtils.allowNulls(insr4200Vo.getResnRegnNum()));
	                psnl0127Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr4200Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
	                
	                psnl0127Vo.setIsmt(sessionUser.getUsrId());                                                              
	                psnl0127Vo.setRevnAddr(request.getRemoteAddr());                                                  
	                                
	                payr0500Vo.setDpobCd(sessionUser.getDpobCd());
	                payr0500Vo.setNatPennApptnYn("Y");
	               // payr0500Vo.setResnRegnNum(MSFSharedUtils.allowNulls(insr4200Vo.getResnRegnNum()));
	                payr0500Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr4200Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
	                
	                payr0500Vo.setIsmt(sessionUser.getUsrId());
	                payr0500Vo.setRevnAddr(request.getRemoteAddr());
					
					insr4200DAO.deleteXlsInsr3150ToInsr4200(insr4200Vo);
					insr4200DAO.insertXlsInsr3150ToInsr4200(insr4200Vo);	
					
					iCnt = iCnt + 1L;

				} // if end
				
			} // for end
			
			result = iCnt;
			
		} catch (Exception ex) {
			logger.error("EXCEPTION calling updateXlsInsr3150(): " + ex);
			result = new Long(0);
			throw MSFServerUtils.getOperationException("updateXlsInsr3150", ex, logger);
		} finally {
			
		}
		return result;
	}
}
