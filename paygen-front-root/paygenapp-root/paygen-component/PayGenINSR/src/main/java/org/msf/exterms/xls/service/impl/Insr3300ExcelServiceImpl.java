package org.msf.exterms.xls.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Insr3300ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.Insr3100ServiceImpl;
import com.app.exterms.insurance.server.service.dao.Insr4300DAO;
import com.app.exterms.insurance.server.vo.Insr4300SrhVO;
import com.app.exterms.insurance.server.vo.Insr4300VO;
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

@Service("Insr3300ExcelService")
public class Insr3300ExcelServiceImpl extends AbstractServiceImpl implements Insr3300ExcelService {
    
	private static final Logger logger = LoggerFactory.getLogger(Insr3100ServiceImpl.class);
	
    @Autowired 
    @Resource(name="Insr4300DAO")
    private Insr4300DAO insr4300DAO;
    
    @Autowired 
    @Resource(name="InfcPkgPsnl0127DAO")
    private InfcPkgPsnl0127DAO infcPsnl0127DAO;
    
    @Autowired 
    @Resource(name="InfcPkgPayr0500DAO")
    private InfcPkgPayr0500DAO infcPayr0500DAO;

    public List selectXlsInsr4100List(Insr4300SrhVO insr4300SrhVO) throws Exception {
    	return insr4300DAO.selectXlsInsr4300List(insr4300SrhVO);
	}
    
    
    
    /**
	 * 엑셀파일을 등록한다._jxls
	 * @param  hMap
	 * @throws Exception
	 */
	
	@Override
	public Long updateXlsInsr3300(List<Insr4300VO> insr4300List, HttpServletRequest request) throws MSFException {
		Long result = new Long(0);
		Long iCnt	= new Long(0);
		int cnt = 0;
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		try {

			for(int iPsnlCnt = 0; iPsnlCnt < insr4300List.size(); iPsnlCnt++) {
				
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				
				Insr4300VO insr4300Vo = new Insr4300VO();
				InfcPkgPsnl0127VO psnl0127Vo = new InfcPkgPsnl0127VO();  
                InfcPkgPayr0500VO payr0500Vo = new InfcPkgPayr0500VO();
				
				insr4300Vo = insr4300List.get(iPsnlCnt);
				
				insr4300Vo.setDpobCd(sessionUser.getDpobCd()); //사업장코드				
				insr4300Vo.setAntyDeinYr(insr4300Vo.getAntyDeinYr()); // 연금결정년도
				
				insr4300Vo.setHanNm(insr4300Vo.getHanNm()); //이름
				//insr4300Vo.setResnRegnNum(insr4300Vo.getResnRegnNum()); //주민번호
				
				insr4300Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr4300Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
				
				insr4300Vo.setAntyTotDutyNumDys(new BigDecimal(MSFSharedUtils.defaultNulls(insr4300Vo.getAntyTotDutyNumDys(), "0"))); //총근무일
				insr4300Vo.setAntyIncmTotAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(insr4300Vo.getAntyIncmTotAmnt(), "0"))); //소득총액
				insr4300Vo.setAntyStdIncmMnthAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(insr4300Vo.getAntyStdIncmMnthAmnt(), "0"))); //소득월액
				insr4300Vo.setAntyMnthPrmm(new BigDecimal(MSFSharedUtils.defaultNulls(insr4300Vo.getAntyMnthPrmm(), "0"))); //월보험료
				
				//insr4300Vo.setNatPennAqtnDt(insr4300Vo.getNatPennAqtnDt()); //연금취득일자
				insr4300Vo.setNatApptnYrMnth("201607"); //국민연금급여적용년월
				
				//insr4300Vo.setNatPrcsDt(insr4300Vo.getNatPrcsDt()); //국민연금급여적용일자
				//TODO 임시처리 수정 
				insr4300Vo.setAntyPayRflctnYn("Y");
				//insr4300Vo.setNatPrcsYn("N"); //국민연금급여처리여부
				insr4300Vo.setNatPrcsYn("Y"); //국민연금급여처리여부
			    
				insr4300Vo.setKybdr(sessionUser.getUsrId());
				insr4300Vo.setInptAddr(request.getRemoteAddr());
				insr4300Vo.setIsmt(sessionUser.getUsrId());
				insr4300Vo.setRevnAddr(request.getRemoteAddr());
				
				psnl0127Vo.setDpobCd(sessionUser.getDpobCd());
				psnl0127Vo.setNatPennStdIncmMnthAmnt(insr4300Vo.getAntyStdIncmMnthAmnt());
                psnl0127Vo.setNatPennApptnYn("Y");
               // psnl0127Vo.setResnRegnNum(MSFSharedUtils.allowNulls(insr4300Vo.getResnRegnNum()));
                
                psnl0127Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr4300Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
                
                psnl0127Vo.setIsmt(sessionUser.getUsrId());                                                              
                psnl0127Vo.setRevnAddr(request.getRemoteAddr());                                                  
                                
                payr0500Vo.setDpobCd(sessionUser.getDpobCd());
                payr0500Vo.setNatPennApptnYn("Y");
               // payr0500Vo.setResnRegnNum(MSFSharedUtils.allowNulls(insr4300Vo.getResnRegnNum()));
                payr0500Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr4300Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
                payr0500Vo.setIsmt(sessionUser.getUsrId());
                payr0500Vo.setRevnAddr(request.getRemoteAddr());
				
                
               // insr4300DAO
                if( 0 < insr4300DAO.selectPsnl0100TotCnt(insr4300Vo)){
					insr4300DAO.deleteXlsInsr3300ToInsr4300(insr4300Vo);
					
					
					
					insr4300DAO.insertXlsInsr3300ToInsr4300(insr4300Vo);				
					infcPsnl0127DAO.updateXlsInsr3100ToPsnl0127(psnl0127Vo); 
	                infcPayr0500DAO.updateXlsInsr3100ToPayr0500(payr0500Vo);
	                cnt++;
                }else{
                	logger.error("국민연금 연말정산 PSNL0100  및 INSR4100 테이블 데이터 미존재 : "+insr4300Vo.getHanNm()+"("+insr4300Vo.getResnRegnNum()+")");
                }
			}
			logger.error("총  : "+cnt+"건 적용");
			result = iCnt;
			
		} catch (Exception ex) {
			logger.error("EXCEPTION calling updateXlsInsr3300(): " + ex);
			result = new Long(0);
			throw MSFServerUtils.getOperationException("updateXlsInsr3300", ex, logger);
		} finally {
			
		}
		return result;
	}
}
