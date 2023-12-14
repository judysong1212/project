package org.msf.exterms.xls.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Payr5400ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.server.service.dao.Payr0520DAO;
import com.app.exterms.payroll.server.vo.Payr0520VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("payr5400ExcelService")
public class Payr5400ExcelServiceImpl extends AbstractServiceImpl implements Payr5400ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(Payr5400ExcelServiceImpl.class);
	private static final String calledClass = Payr5400ExcelService.class.getName();
    
    
    @Autowired
    @Resource(name="Payr0520DAO")
    private Payr0520DAO payr0520DAO;
     
    public List selectXlsPayr0520List(Payr0520VO payr0520Vo) throws Exception {
    	return payr0520DAO.selectXlsPayr0520List(payr0520Vo);
    } 

	/**
	 * 엑셀파일을 등록한다._jxls
	 * 
	 * @param hMap
	 * @throws Exception
	 */
	
	@Override
	public Long insertXlsPayr5400ToPayr0520(List<Payr0520VO> payr0520List, HttpServletRequest request)throws MSFException {
		
		Long result = new Long(0);
		Long iCnt	= new Long(0);
//		System.out.println(" payr0520List.size : " + payr0520List.size());
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
    
		
		try {
			for(int iPsnlCnt = 0; iPsnlCnt < payr0520List.size(); iPsnlCnt++) {
				
				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				
				Payr0520VO payr0520Vo = new Payr0520VO();
				
				payr0520Vo = payr0520List.get(iPsnlCnt);
				
				
           		payr0520Vo.setDpobCd(sessionUser.getDpobCd());    									/** column 사업장코드 : dpobCd */
           		
				// 암호화
           		payr0520Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(payr0520Vo.getResnRegnNum().replaceAll("-","")),AnyCryptUtils.SEC_RRNUMC));	
           		
           		
             	payr0520Vo.setPayItemCd(MSFSharedUtils.allowNulls(payr0520Vo.getPayItemCd()));    										/** column 급여항목코드 : payItemCd */
             	payr0520Vo.setPymtDducItemSilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0520Vo.getPymtDducItemSilNum(), "0"))); /** column 개별지급공제항목일련번호 : pymtDducItemSilNum */
             	payr0520Vo.setPymtDducDivCd(payr0520Vo.getPymtDducDivCd());    															/** column 지급공제구분코드 : pymtDducDivCd */
              	payr0520Vo.setPymtDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0520Vo.getPymtDducSum(), "0")));    			/** column 지급공제금액 : pymtDducSum */
              	payr0520Vo.setPymtDducRate(new BigDecimal(MSFSharedUtils.defaultNulls(payr0520Vo.getPymtDducRate(), "0")));    			/** column 지급공제율 : pymtDducRate */
              	payr0520Vo.setPymtDducFreeDtySum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0520Vo.getPymtDducFreeDtySum(), "0")));	/** column 지급공제비과세금액 : pymtDducFreeDtySum */
//              	payr0520Vo.setPymtDducItemCretnDivCd(MSFSharedUtils.allowNulls(payr0520Vo.getPymtDducItemCretnDivCd()));    	/** column 지급공제항목생성구분코드 : pymtDducItemCretnDivCd */
              	payr0520Vo.setPymtDducItemBgnnDt(MSFSharedUtils.allowNulls(payr0520Vo.getPymtDducItemBgnnDt()));    					/** column 지급공제항목시작일자 : pymtDducItemBgnnDt */
              	payr0520Vo.setPymtDducItemEndDt(MSFSharedUtils.allowNulls(payr0520Vo.getPymtDducItemEndDt()));    						/** column 지급공제항목종료일자 : pymtDducItemEndDt */
              	payr0520Vo.setPymtDducItemDelYn(MSFSharedUtils.allowNulls(payr0520Vo.getPymtDducItemDelYn()));    						/** column 지급공제항목삭제여부 : pymtDducItemDelYn */
              	payr0520Vo.setPymtDducItemNoteCtnt(MSFSharedUtils.allowNulls(payr0520Vo.getPymtDducItemNoteCtnt()));					/** column 지급공제항목비고내용 : pymtDducItemNoteCtnt */
	      		payr0520Vo.setKybdr(sessionUser.getUsrId());    																		/** column 입력자 : kybdr */
	      		payr0520Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    									/** column 입력주소 : inptAddr */
	      		payr0520Vo.setIsmt(sessionUser.getUsrId());    																			/** column 수정자 : ismt */
	      		payr0520Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    									/** column 수정주소 : revnAddr */
              	
	      		payr0520DAO.xlsDeletePayr0520(payr0520Vo);
	      		payr0520DAO.xlsInsertPayr0520(payr0520Vo);
	      		
	      		iCnt = iCnt + 1;
	      		
			}
			result = iCnt;
		} catch (Exception ex) {
			logger.error("EXCEPTION calling insertXlsPayr5400ToPayr0520(): " + ex);
			result = new Long(0);
			throw MSFServerUtils.getOperationException("insertXlsPayr5400ToPayr0520", ex, logger);
		} finally {

		}
		return result;
	}

   
 
}
