package com.app.exterms.yearendtax.server.service.yeta2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.yearendtax.client.dto.yeta2023.Ye169010DTO;
import com.app.exterms.yearendtax.client.service.yeta2023.YetaT83017Service;
import com.app.exterms.yearendtax.server.service.yeta2023.dao.Ye169010a_2023_DAO;
import com.app.exterms.yearendtax.server.vo.Ye169010aSrh_2023_VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

@Service("YetaT83017Service")
public class YetaT83017ServiceImpl  extends AbstractCustomServiceImpl implements YetaT83017Service ,YetaDaoConstants {
	 
	private static final Logger logger = LoggerFactory.getLogger(YetaT83017ServiceImpl.class);
	private static final String calledClass = YetaT83017ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "Ye169010a_2023_DAO")
	private Ye169010a_2023_DAO ye169010ADao;

	@Override
	public Ye169010DTO getYetaP83017ToYe169010List(Ye169010DTO ye169010Dto)	throws MSFException {
		
		Ye169010aSrh_2023_VO ye169010aSrhVo = new Ye169010aSrh_2023_VO();
		MSFSysm0100BM sessionUser;
		
		String method = calledClass + ".getYetaP83017ToYe169010List";

		String windowNm = "표준세액공제";
		String windowId = "YETAP83017";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(ye169010ADao)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
							.getSession().getServletContext());
			ye169010ADao = (Ye169010a_2023_DAO) wac.getBean("Ye169010a_2023_DAO");
		}
		

		/** 조건절 */
		
		ye169010aSrhVo.setDpobCd(sessionUser.getDpobCd());    									/** column 사업장코드 : dpobCd */
		ye169010aSrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye169010Dto.getYrtxBlggYr()));	/** column 귀속연도 : yrtxBlggYr */
		ye169010aSrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(ye169010Dto.getClutSeptCd()));	/** column 연말정산구분코드 : clutSeptCd */
		ye169010aSrhVo.setSystemkey(MSFSharedUtils.allowNulls(ye169010Dto.getSystemkey()));		/** column SYSTEMKEY : systemkey */
		ye169010aSrhVo.setC152StdTxDdcYn(MSFSharedUtils.allowNulls(ye169010Dto.getC152StdTxDdcYn()));	

		Ye169010DTO returnYe169010Dto = new Ye169010DTO();
		List egovResultDataList = new ArrayList();

		try {

			egovResultDataList = ye169010ADao.selectYetaP83017ToYe169010List(ye169010aSrhVo);
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());			

			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";

			if (egovResultDataList != null && egovResultDataList.size() > 0) {
				
				for (int i = 0; i < egovResultDataList.size(); i++) {
					 
					
					Map tempMap = (Map)egovResultDataList.get(i); 
					
					returnYe169010Dto.setYetaSum1(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum1"),"0")));
					returnYe169010Dto.setYetaSum2(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum2"),"0")));
					returnYe169010Dto.setYetaSum3(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum3"),"0")));
					returnYe169010Dto.setYetaSum4(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum4"),"0")));
					returnYe169010Dto.setYetaSum5(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum5"),"0")));
					
					returnYe169010Dto.setYetaSum6(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum6"),"0")));
					returnYe169010Dto.setYetaSum7(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum7"),"0")));
					returnYe169010Dto.setYetaSum8(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum8"),"0")));
					returnYe169010Dto.setYetaSum9(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum9"),"0")));
					returnYe169010Dto.setYetaSum10(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum10"),"0")));
					
					returnYe169010Dto.setYetaSum11(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum11"),"0")));
					returnYe169010Dto.setYetaSum12(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum12"),"0")));
					returnYe169010Dto.setYetaSum13(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum13"),"0")));
					returnYe169010Dto.setYetaSum14(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum14"),"0")));
					returnYe169010Dto.setYetaSum15(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum15"),"0")));
					
					returnYe169010Dto.setYetaSum16(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum16"),"0")));
					returnYe169010Dto.setYetaSum17(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum17"),"0")));
					returnYe169010Dto.setYetaSum18(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum18"),"0")));
					returnYe169010Dto.setYetaSum19(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum19"),"0")));
					returnYe169010Dto.setYetaSum20(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum20"),"0")));
					
					returnYe169010Dto.setYetaSum21(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum21"),"0")));
					returnYe169010Dto.setYetaSum22(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum22"),"0")));
					returnYe169010Dto.setYetaSum23(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum23"),"0")));
					returnYe169010Dto.setYetaSum24(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum24"),"0")));
					returnYe169010Dto.setYetaSum25(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum25"),"0")));
					
					returnYe169010Dto.setYetaSum26(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum26"),"0")));
					returnYe169010Dto.setYetaSum27(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaSum27"),"0")));
					
					
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
			
			// Return operation exception
		}
		
		/** 로그반영
		 * CRUDSBLO 
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");

		return returnYe169010Dto;

	}

}
