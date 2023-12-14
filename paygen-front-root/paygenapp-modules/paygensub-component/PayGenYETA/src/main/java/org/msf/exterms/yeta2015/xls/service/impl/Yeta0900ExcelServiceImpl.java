package org.msf.exterms.yeta2015.xls.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.yeta2015.xls.service.Yeta0900ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.yearendtax.server.service.yeta2015.dao.Yeta3900DAO;
import com.app.exterms.yearendtax.server.vo.Yeta3900SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3900VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("yeta0900ExcelService")
public class Yeta0900ExcelServiceImpl extends AbstractServiceImpl implements Yeta0900ExcelService {
	
//	private static final Logger logger = LoggerFactory.getLogger(Yeta0900ServiceImpl.class);
	private static final String calledClass = Yeta0900ExcelService.class.getName();
    
    @Autowired 
    @Resource(name="Yeta3900DAO")
    private Yeta3900DAO yeta3900DAO;

    
    //엑셀파일 저장_jxls(양식)
	public List  selectXlsFileYeta3900List(Yeta3900SrhVO Yeta3900SrhVo) throws Exception {
		return yeta3900DAO.selectXlsFileYeta3900List(Yeta3900SrhVo);
	}

	 /**
	  *  엑셀파일을 등록한다._jxls
	  * @param  hMap
	  * @throws Exception
	  */

	@Override
	public Long updateXlsYeta3900(List<Yeta3900VO> yeta3900List, HttpServletRequest request)throws MSFException {
		
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
    	
	        
	        try
	        {
	            for(int iPsnlCnt = 0; iPsnlCnt < yeta3900List.size(); iPsnlCnt++)
	            {
	            	
	            	// 1. 암호화 객체 생성
	            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	            	
	                Yeta3900VO yeta3900Vo = new Yeta3900VO();
	                yeta3900Vo = (Yeta3900VO)yeta3900List.get(iPsnlCnt);
	                yeta3900Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
	                yeta3900Vo.setPymtYrMnth(MSFSharedUtils.allowNulls(yeta3900Vo.getPymtYrMnth()));
//	                yeta3900Vo.setResnRegnNum(MSFSharedUtils.allowNulls(yeta3900Vo.getResnRegnNum()));
	                // 암호화
	                yeta3900Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(yeta3900Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
	        		
	                yeta3900Vo.setPayCd(MSFSharedUtils.allowNulls(yeta3900Vo.getPayCd()));
	                yeta3900Vo.setPayItemCd(MSFSharedUtils.allowNulls(yeta3900Vo.getPayItemCd()));
	                yeta3900Vo.setPayItemSeilNum(new BigDecimal(MSFSharedUtils.allowNulls(yeta3900Vo.getPayItemSeilNum())));
	                yeta3900Vo.setPymtDducSum(new BigDecimal(MSFSharedUtils.allowNulls(yeta3900Vo.getPymtDducSum())));
	                yeta3900Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.allowNulls(yeta3900Vo.getPymtDducTxtnAmnt())));
	                yeta3900Vo.setPymtDducFreeDtySum(new BigDecimal(MSFSharedUtils.allowNulls(yeta3900Vo.getPymtDducFreeDtySum())));
	                yeta3900Vo.setPayPymtDt(MSFSharedUtils.allowNulls(yeta3900Vo.getPayPymtDt()));
	                yeta3900Vo.setPayItemNm(MSFSharedUtils.allowNulls(yeta3900Vo.getPayItemNm()));
	                
	                yeta3900Vo.setKybdr(sessionUser.getUsrId());		/** column 입력자 : kybdr */
	                yeta3900Vo.setInptAddr(request.getRemoteHost());	/** column 입력주소 : inptAddr */
	                yeta3900Vo.setIsmt(sessionUser.getUsrId());    		/** column 수정자 : ismt */
	                yeta3900Vo.setRevnAddr(request.getRemoteHost());    /** column 수정주소 : revnAddr */  
	                
	                yeta3900DAO.deleteXlsYeta3900(yeta3900Vo);
	                yeta3900DAO.insertXlsYeta3900(yeta3900Vo);
	            }
	            result = iCnt;
	          
	        } catch (Exception ex) {
//	            logger.error("EXCEPTION calling updateXlsYeta0900(): "+ex); 	            
	            result = new Long(0);
//	            throw MSFServerUtils.getOperationException("updateXlsYeta0900", ex, logger);
	        }
	        finally {
	          
	        }
		return result;
	}  
}