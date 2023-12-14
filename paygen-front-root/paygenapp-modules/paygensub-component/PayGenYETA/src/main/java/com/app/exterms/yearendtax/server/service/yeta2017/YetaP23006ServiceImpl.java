/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.app.exterms.yearendtax.server.service.yeta2017;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.yearendtax.client.dto.yeta2017.Ye160404DTO;
import com.app.exterms.yearendtax.client.service.yeta2017.YetaP23006Service;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye160404DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye160405DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye160406DAO;
import com.app.exterms.yearendtax.server.vo.Ye160404SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye160404VO;
import com.app.exterms.yearendtax.server.vo.Ye160405VO;
import com.app.exterms.yearendtax.server.vo.Ye160406VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.pkg.listener.yeta.yeta2017.Yeta2300ListenerAdapter;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;



/**
 * @Class Name : YetaP23006ServiceImpl.java
 * @since : 2017. 12. 13. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Service("YetaP23006Service")
public class YetaP23006ServiceImpl  extends AbstractCustomServiceImpl implements YetaP23006Service , YetaDaoConstants {

	 
	private static final Logger logger = LoggerFactory.getLogger(YetaP23006ServiceImpl.class);
	private static final String calledClass = YetaP23006ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "Ye160404DAO")
	private Ye160404DAO ye160404DAO;
	
	
	@Autowired
	@Resource(name = "Ye160405DAO")
	private Ye160405DAO ye160405DAO;
	
	@Autowired
	@Resource(name = "Ye160406DAO")
	private Ye160406DAO ye160406DAO;
	
	
	
	@Override
	public Long activityOnYetaP23006ToYe160404(List<Ye160404DTO> listYe160404Dto, ActionDatabase actionDatabase) throws MSFException {
			// TODO Auto-generated method stub
			Long result = new Long(0);
			Long iCnt = new Long(0);
			
			MSFSysm0100BM sessionUser;
			String method = calledClass + ".activityOnYetaP23006ToYe160404";
			
			String windowNm = "소득공제신고자료관리";
			String windowId = "YETAP230006";
			Ye160404DTO ye160404Dto = new Ye160404DTO();  
			Ye160404VO ye160404Vo = new Ye160404VO();
			Ye160405VO ye160405Vo = new Ye160405VO();
			Ye160406VO ye160406Vo = new Ye160406VO();
			
			InfcPkgYe161010VO infcPkgYe161010Vo = new InfcPkgYe161010VO(); 
			Yeta2300ListenerAdapter  yeta2300ListenerAdt = new Yeta2300ListenerAdapter();
			
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
			
			try {  
				if (MSFSharedUtils.paramNull(ye160404DAO)) {
					WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
					ye160404DAO = (Ye160404DAO) wac.getBean("Ye160404DAO"); 
				}
				
				if(MSFSharedUtils.paramNull(ye160405DAO)) {
					WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
					ye160405DAO = (Ye160405DAO) wac.getBean("Ye160405DAO"); 
				}
				
				
				if(MSFSharedUtils.paramNull(ye160406DAO)) {
					WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
					ye160406DAO = (Ye160406DAO) wac.getBean("Ye160406DAO"); 
				}
				
				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		            
				for(int iPsnlCnt=0;iPsnlCnt < listYe160404Dto.size();iPsnlCnt++) {
			        
					
					ye160404Dto = new Ye160404DTO(); 
					ye160404Dto = listYe160404Dto.get(iPsnlCnt);
					
					
					/**
					 * 1. 종전근무처 작업
					 * **/
					ye160404Vo = new Ye160404VO();     
					 
					ye160404Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    			/** column 사업장코드 : dpobCd */
					ye160404Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye160404Dto.getYrtxBlggYr()));    	/** column 귀속연도 : yrtxBlggYr */
					ye160404Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye160404Dto.getClutSeptCd()));    	/** column 연말정산구분코드 : clutSeptCd */
					ye160404Vo.setSystemkey(MSFSharedUtils.allowNulls(ye160404Dto.getSystemkey()));    		/** column SYSTEMKEY : systemkey */
					ye160404Vo.setWhdgDebrBusoprRgstnum(MSFSharedUtils.allowNulls(ye160404Dto.getWhdgDebrBusoprRgstnum().replaceAll("-", "")));		/** column D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
					ye160404Vo.setPrcspSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspSeilNum(),"0")));    					/** column D4_종전근무처일련번호 : prcspSeilNum */
					
					ye160404Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult
										, MSFSharedUtils.allowNulls(ye160404Dto.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	/** column D7_소득자주민등록번호 : resnRegnNum */
					ye160404Vo.setPrcspTxpyrAsocYn("Y".equals(ye160404Dto.getPrcspTxpyrAsocYn()) ? "1" : "2" );    									/** column D8_종전근무처납세조합여부 : prcspTxpyrAsocYn */
					ye160404Vo.setPrcspFmnmNm(MSFSharedUtils.allowNulls(ye160404Dto.getPrcspFmnmNm()));    											/** column D9_종전근무처법인_상호명 : prcspFmnmNm */
					ye160404Vo.setPrcspBusoprRgstnum(MSFSharedUtils.allowNulls(ye160404Dto.getPrcspBusoprRgstnum().replaceAll("-", "")));    		/** column D10_종전근무처사업자등록번호 : prcspBusoprRgstnum */
					ye160404Vo.setPrcspDutyBgnnDt(MSFSharedUtils.allowNulls(ye160404Dto.getPrcspDutyBgnnDt()));    									/** column D11_종전근무처근무시간시작일자 : prcspDutyBgnnDt */
					ye160404Vo.setPrcspDutyEndDt(MSFSharedUtils.allowNulls(ye160404Dto.getPrcspDutyEndDt()));    									/** column D12_종전근무처근무시간종료일자 : prcspDutyEndDt */
					ye160404Vo.setPrcspReduBgnnDt(MSFSharedUtils.allowNulls(ye160404Dto.getPrcspReduBgnnDt()));    									/** column D13_종전근무처감면기간시작일자 : prcspReduBgnnDt */
					ye160404Vo.setPrcspReduEndDt(MSFSharedUtils.allowNulls(ye160404Dto.getPrcspReduEndDt()));    									/** column D14_종전근무처감면기간종료일자 : prcspReduEndDt */
					
					ye160404Vo.setPrcspPaySum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspPaySum(),"0")));    					/** column D15_종전근무처급여금액 : prcspPaySum */
					ye160404Vo.setPrcspAllwBnusSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspAllwBnusSum(),"0")));    			/** column D16_종전근무처상여금액 : prcspAllwBnusSum */
					ye160404Vo.setPrcspRcgtnBnusSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspRcgtnBnusSum(),"0")));    		/** column D17_종전근무처인정상여금액 : prcspRcgtnBnusSum */
					ye160404Vo.setPrcspStckEvntPrftSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspStckEvntPrftSum(),"0"))); 	/** column D18_종전근무처주식매수선택권행사이익금액 : prcspStckEvntPrftSum */
					ye160404Vo.setPrcspEmpStkscWdrwSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspEmpStkscWdrwSum(),"0"))); 	/** column D19_종전근무처우리사주조합인출금액 : prcspEmpStkscWdrwSum */
					ye160404Vo.setPrcspEcteRsgtnExceSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspEcteRsgtnExceSum(),"0")));	/** column D20_종전근무처임원퇴직소득한도초과금액 : prcspEcteRsgtnExceSum */
					
					
					ye160404Vo.setPrcspAggrSum(ye160404Vo.getPrcspPaySum().add(ye160404Vo.getPrcspAllwBnusSum ()).add(ye160404Vo.getPrcspRcgtnBnusSum())
							.add( ye160404Vo.getPrcspStckEvntPrftSum ()).add(ye160404Vo.getPrcspEmpStkscWdrwSum()).add(ye160404Vo.getPrcspEcteRsgtnExceSum())); /** column D22_종전근무처합계금액 : prcspAggrSum */
					
					
					ye160404Vo.setFreeDtyAggrSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getFreeDtyAggrSum(),"0")));    				/** column D53_비과세합계금액 : freeDtyAggrSum */
					ye160404Vo.setReduIncmAggrSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getReduIncmAggrSum(),"0")));    			/** column D54_감면소득합계금액 : reduIncmAggrSum */
					ye160404Vo.setPrcspIncmTxSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspIncmTxSum(),"0")));   				/** column D56_종전근무지기납부세액_소득세금액 : prcspIncmTxSum */
					ye160404Vo.setPrcspRgonIncmTxSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspRgonIncmTxSum(),"0")));    		/** column D57_종전근무지기납부세액_지방소득세금액 : prcspRgonIncmTxSum */
					ye160404Vo.setPrcspNnksSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspNnksSum(),"0")));    					/** column D58_종전근무지기납부세액_농특세금액 : prcspNnksSum */
					ye160404Vo.setPrcspHlthPrmmSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspHlthPrmmSum(),"0")));    			/** column 종전근무지건강보험료금액 : prcspHlthPrmmSum */
					ye160404Vo.setPrcspLgtmRcptnSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspLgtmRcptnSum(),"0")));    		/** column 종전근무지장기요양보험료금액 : prcspLgtmRcptnSum */
					ye160404Vo.setPrcspHlthLgcptnAggr(ye160404Vo.getPrcspHlthPrmmSum().add(ye160404Vo.getPrcspLgtmRcptnSum()));    					/** column 종전근무지건강장기요양보험료합계금액 : prcspHlthLgcptnAggr */
					ye160404Vo.setPrcspHlthPrmmDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspHlthPrmmDducSum(),"0")));    	/** column 종전근무지건강보험료공제금액 : prcspHlthPrmmDducSum */
					ye160404Vo.setPrcspEmymtPrmmSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspEmymtPrmmSum(),"0")));    		/** column 종전근무지고용보험료금액 : prcspEmymtPrmmSum */
					ye160404Vo.setPrcspEmytPrmmDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspEmytPrmmDducSum(),"0")));   	/** column 종전근무지고용보험료공제금액 : prcspEmytPrmmDducSum */
					ye160404Vo.setPrcspPrcsYn(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspPrcsYn(), "0"));   								 	/** column 종전근무지처리여부 : prcspPrcsYn */
					ye160404Vo.setPrcspWhdgReipSumtYn(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspWhdgReipSumtYn(), "0"));    					/** column 종전근무지원천징수영수증제출여부 : prcspWhdgReipSumtYn */
					
					ye160404Vo.setPrcspYetaC165(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspYetaC165(),"0")));    				/** column C165_납부특례세액_소득세금액 : prcspYetaC165 */
					ye160404Vo.setPrcspYetaC166(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspYetaC166(),"0")));    				/** column C166_납부특례세액_지방소득세금액 : prcspYetaC166 */
					ye160404Vo.setPrcspYetaC167(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrcspYetaC167(),"0")));    				/** column C167_납부특례세액_농특세금액 : prcspYetaC167 */
					
					ye160404Vo.setKybdr(sessionUser.getUsrId());    																				/** column 입력자 : kybdr */
					ye160404Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    											/** column 입력주소 : inptAddr */
					
					
					
					/**
					 * 2. 종전근무처비과세_감면소득_비과세 작업
					 * **/
					ye160405Vo = new Ye160405VO();
					
					ye160405Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    			/** column 사업장코드 : dpobCd */
					ye160405Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye160404Dto.getYrtxBlggYr()));    	/** column 귀속연도 : yrtxBlggYr */
					ye160405Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye160404Dto.getClutSeptCd()));    	/** column 연말정산구분코드 : clutSeptCd */
					ye160405Vo.setSystemkey(MSFSharedUtils.allowNulls(ye160404Dto.getSystemkey()));    		/** column SYSTEMKEY : systemkey */
					ye160405Vo.setWhdgDebrBusoprRgstnum(MSFSharedUtils.allowNulls(ye160404Dto.getWhdgDebrBusoprRgstnum().replaceAll("-", "")));    /** column D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
					
					ye160405Vo.setTaxmSa01Jong(new BigDecimal("0"));    /** column 비과세소득_A01_종전 : taxmSa01Jong */
					ye160405Vo.setTaxmSb01Jong(new BigDecimal("0"));    /** column 비과세소득_B01_종전 : taxmSb01Jong */
					ye160405Vo.setTaxmSc01Jong(new BigDecimal("0"));    /** column 비과세소득_C01_종전 : taxmSc01Jong */
					ye160405Vo.setTaxmSd01Jong(new BigDecimal("0"));    /** column 비과세소득_D01_종전 : taxmSd01Jong */
					ye160405Vo.setTaxmSe01Jong(new BigDecimal("0"));    /** column 비과세소득_E01_종전 : taxmSe01Jong */
					ye160405Vo.setTaxmSe02Jong(new BigDecimal("0"));    /** column 비과세소득_E02_종전 : taxmSe02Jong */
					ye160405Vo.setTaxmSe10Jong(new BigDecimal("0"));    /** column 비과세소득_E10_종전 : taxmSe10Jong */
					ye160405Vo.setTaxmSf01Jong(new BigDecimal("0"));    /** column 비과세소득_F01_종전 : taxmSf01Jong */
					ye160405Vo.setTaxmSg01Jong(new BigDecimal("0"));    /** column 비과세소득_G01_종전 : taxmSg01Jong */
					ye160405Vo.setTaxmSh01Jong(new BigDecimal("0"));    /** column 비과세소득_H01_종전 : taxmSh01Jong */
					ye160405Vo.setTaxmSh02Jong(new BigDecimal("0"));    /** column 비과세소득_H02_종전 : taxmSh02Jong */
					ye160405Vo.setTaxmSh03Jong(new BigDecimal("0"));    /** column 비과세소득_H03_종전 : taxmSh03Jong */
					ye160405Vo.setTaxmSh04Jong(new BigDecimal("0"));    /** column 비과세소득_H04_종전 : taxmSh04Jong */
					ye160405Vo.setTaxmSh05Jong(new BigDecimal("0"));    /** column 비과세소득_H05_종전 : taxmSh05Jong */
					ye160405Vo.setTaxmSh06Jong(new BigDecimal("0"));    /** column 비과세소득_H06_종전 : taxmSh06Jong */
					ye160405Vo.setTaxmSh07Jong(new BigDecimal("0"));    /** column 비과세소득_H07_종전 : taxmSh07Jong */
					ye160405Vo.setTaxmSh08Jong(new BigDecimal("0"));    /** column 비과세소득_H08_종전 : taxmSh08Jong */
					ye160405Vo.setTaxmSh09Jong(new BigDecimal("0"));    /** column 비과세소득_H09_종전 : taxmSh09Jong */
					ye160405Vo.setTaxmSh10Jong(new BigDecimal("0"));    /** column 비과세소득_H10_종전 : taxmSh10Jong */
					ye160405Vo.setTaxmSh14Jong(new BigDecimal("0"));    /** column 비과세소득_H14_종전 : taxmSh14Jong */
					ye160405Vo.setTaxmSh15Jong(new BigDecimal("0"));    /** column 비과세소득_H15_종전 : taxmSh15Jong */
					ye160405Vo.setTaxmSh11Jong(new BigDecimal("0"));    /** column 비과세소득_H11_종전 : taxmSh11Jong */
					ye160405Vo.setTaxmSh12Jong(new BigDecimal("0"));    /** column 비과세소득_H12_종전 : taxmSh12Jong */
					ye160405Vo.setTaxmSh13Jong(new BigDecimal("0"));    /** column 비과세소득_H13_종전 : taxmSh13Jong */
					ye160405Vo.setTaxmSh16Jong(new BigDecimal("0"));    /** column 비과세소득_H16_종전 : taxmSh16Jong */
					ye160405Vo.setTaxmSi01Jong(new BigDecimal("0"));    /** column 비과세소득_I01_종전 : taxmSi01Jong */
					ye160405Vo.setTaxmSj01Jong(new BigDecimal("0"));    /** column 비과세소득_J01_종전 : taxmSj01Jong */
					ye160405Vo.setTaxmSj10Jong(new BigDecimal("0"));    /** column 비과세소득_J10_종전 : taxmSj10Jong */
					ye160405Vo.setTaxmSk01Jong(new BigDecimal("0"));    /** column 비과세소득_K01_종전 : taxmSk01Jong */
					ye160405Vo.setTaxmSl01Jong(new BigDecimal("0"));    /** column 비과세소득_L01_종전 : taxmSl01Jong */
					ye160405Vo.setTaxmSm01Jong(new BigDecimal("0"));    /** column 비과세소득_M01_종전 : taxmSm01Jong */
					ye160405Vo.setTaxmSm02Jong(new BigDecimal("0"));    /** column 비과세소득_M02_종전 : taxmSm02Jong */
					ye160405Vo.setTaxmSm03Jong(new BigDecimal("0"));    /** column 비과세소득_M03_종전 : taxmSm03Jong */
					ye160405Vo.setTaxmSn01Jong(new BigDecimal("0"));    /** column 비과세소득_N01_종전 : taxmSn01Jong */
					ye160405Vo.setTaxmSo01Jong(new BigDecimal("0"));    /** column 비과세소득_O01_종전 : taxmSo01Jong */
					ye160405Vo.setTaxmSp01Jong(new BigDecimal("0"));    /** column 비과세소득_P01_종전 : taxmSp01Jong */
					ye160405Vo.setTaxmSp02Jong(new BigDecimal("0"));    /** column 비과세소득_P02_종전 : taxmSp02Jong */
					ye160405Vo.setTaxmSq01Jong(new BigDecimal("0"));    /** column 비과세소득_Q01_종전 : taxmSq01Jong */
					ye160405Vo.setTaxmSr01Jong(new BigDecimal("0"));    /** column 비과세소득_R01_종전 : taxmSr01Jong */
					ye160405Vo.setTaxmSr10Jong(new BigDecimal("0"));    /** column 비과세소득_R10_종전 : taxmSr10Jong */
					ye160405Vo.setTaxmSs01Jong(new BigDecimal("0"));    /** column 비과세소득_S01_종전 : taxmSs01Jong */
					ye160405Vo.setTaxmSy02Jong(new BigDecimal("0"));    /** column 비과세소득_Y02_종전 : taxmSy02Jong */
					ye160405Vo.setTaxmSy03Jong(new BigDecimal("0"));    /** column 비과세소득_Y03_종전 : taxmSy03Jong */
					ye160405Vo.setTaxmSy04Jong(new BigDecimal("0"));    /** column 비과세소득_Y04_종전 : taxmSy04Jong */
					ye160405Vo.setTaxmSy21Jong(new BigDecimal("0"));    /** column 비과세소득_Y21_종전 : taxmSy21Jong */
					ye160405Vo.setTaxmSy22Jong(new BigDecimal("0"));    /** column 비과세소득_Y22_종전 : taxmSy22Jong */
					ye160405Vo.setTaxmSt01Jong(new BigDecimal("0"));    /** column 감면소득_T01_종전 : taxmSt01Jong */
					ye160405Vo.setTaxmSt10Jong(new BigDecimal("0"));    /** column 감면소득_T10_종전 : taxmSt10Jong */
					ye160405Vo.setTaxmSt11Jong(new BigDecimal("0"));    /** column 감면소득_T11_종전 : taxmSt11Jong */
					ye160405Vo.setTaxmSt12Jong(new BigDecimal("0"));    /** column 감면소득_T12_종전 : taxmSt12Jong */
					ye160405Vo.setTaxmSt20Jong(new BigDecimal("0"));    /** column 감면소득_T20_종전 : taxmSt20Jong */
					ye160405Vo.setTaxmSr11Jong(new BigDecimal("0"));    /** column 비과세소득_R11_종전 : taxmSr11Jong */
					
					ye160405Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
					ye160405Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */
					
					ye160405Vo.setIsmt(sessionUser.getUsrId());												/** column 수정자 : ismt */
					ye160405Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 		/** column 수정주소 : revnAddr */
					
					
					/**
					 * 3. 종전근무지연금보험료_공적연금 작업
					 * **/
					
					ye160406Vo = new Ye160406VO();
					
					ye160406Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    			/** column 사업장코드 : dpobCd */
					ye160406Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye160404Dto.getYrtxBlggYr()));    	/** column 귀속연도 : yrtxBlggYr */
					ye160406Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye160404Dto.getClutSeptCd()));    	/** column 연말정산구분코드 : clutSeptCd */
					ye160406Vo.setSystemkey(MSFSharedUtils.allowNulls(ye160404Dto.getSystemkey()));    		/** column SYSTEMKEY : systemkey */
					ye160406Vo.setWhdgDebrBusoprRgstnum(MSFSharedUtils.allowNulls(ye160404Dto.getWhdgDebrBusoprRgstnum().replaceAll("-", "")));		/** column D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
					
					ye160406Vo.setNatPennPrmmSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getNatPennPrmmSum(),"0")));    				/** column 국민연금보험료금액 : natPennPrmmSum */
					ye160406Vo.setNatPennAraPrmmSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getNatPennAraPrmmSum(),"0")));			/** column 국민연금지역보험료금액 : natPennAraPrmmSum */
					ye160406Vo.setNatPennDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getNatPennDducSum(),"0")));    				/** column 국민연금공제금액 : natPennDducSum */
					ye160406Vo.setPuoferAnty(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPuoferAnty(),"0")));   						/** column 공적연금_공무원연금금액 : puoferAnty */
					ye160406Vo.setPuoferAntyDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPuoferAntyDducSum(),"0")));  	 		/** column 공적연금_공무원연금공제금액 : puoferAntyDducSum */
					ye160406Vo.setMltymAnty(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getMltymAnty(),"0")));    						/** column 공적연금_군인연금금액 : mltymAnty */
					ye160406Vo.setMltymAntyDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getMltymAntyDducSum(),"0")));    			/** column 공적연금_군인연금공제금액 : mltymAntyDducSum */
					ye160406Vo.setPrtafirSchlFalymmAnty(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrtafirSchlFalymmAnty(),"0")));	/** column 공적연금_사립학교교직원연금금액 : prtafirSchlFalymmAnty */
					ye160406Vo.setPrtafirSchlDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getPrtafirSchlDducSum(),"0"))); 		/** column 공적연금_사립학교직원연금공제금액 : prtafirSchlDducSum */
					ye160406Vo.setSpildtnPstoficAnty(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getSpildtnPstoficAnty(),"0")));    		/** column 공적연금_별정우체국연금금액 : spildtnPstoficAnty */
					ye160406Vo.setSpildtnPstoficDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye160404Dto.getSpildtnPstoficDducSum(),"0")));	/** column 공적연금_별정우체국연금공제금액 : spildtnPstoficDducSum */
					
					ye160406Vo.setKybdr(sessionUser.getUsrId());    																				/** column 입력자 : kybdr */
					ye160406Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    											/** column 입력주소 : inptAddr */
					
					
					
		        	switch (actionDatabase) {
		        		case INSERT:
		        			
		        			ye160404DAO.insertYetaP23006ToYe160404(ye160404Vo); 
		        			ye160405DAO.insertYetaP23006ToYe160405(ye160405Vo); 
		        			ye160406DAO.insertYetaP23006ToYe160406(ye160406Vo); 
		        			
		        			break;
		        			
		            	case UPDATE:
		            		
		            		ye160404Vo.setIsmt(sessionUser.getUsrId());													/** column 수정자 : ismt */
		            		ye160404Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 			/** column 수정주소 : revnAddr */
		            		
		            		ye160404DAO.updateYetaP23006ToYe160404(ye160404Vo);
		            		
		            		
		            		ye160406Vo.setIsmt(sessionUser.getUsrId());													/** column 수정자 : ismt */
		            		ye160406Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 			/** column 수정주소 : revnAddr */
		            		
		            		ye160406DAO.updateYetaP23006ToYe160406(ye160406Vo);
		        			
		            		break;
		            		
		            	case DELETE: 
		            		
		            		ye160406DAO.deleteYetaP23006ToYe160406(ye160406Vo); 
		            		ye160405DAO.deleteYetaP23006ToYe160405(ye160405Vo); 
		            		ye160404DAO.deleteYetaP23006ToYe160404(ye160404Vo); 
		            		
		            		break;
		        	} 
		        		iCnt = iCnt + 1; 
		                    
				} 
				
				BeanUtils.copyProperties(infcPkgYe161010Vo , ye160404Vo);  
				yeta2300ListenerAdt = new Yeta2300ListenerAdapter();
				yeta2300ListenerAdt.fnYeta2300_Ye161010_2017_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE161050");
				
				result = iCnt;
				
		          
			} catch (Exception ex) {
				
				logger.error("EXCEPTION calling activityOnYetaP23006ToYe160404(): "+ ex); 
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), ex, windowNm , windowId);
		            
				result = new Long(0);
				throw MSFServerUtils.getOperationException("activityOnYetaP23006ToYe160404", ex, logger);
			}
			finally {
		          
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
			
			return result;
	}
	
	
	//종전근무지 조회
	public PagingLoadResult<BaseModel> getYetaP23006ToYe160404List(ServiceParameters serviceParameters) throws MSFException {
			
		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETAP23006_TO_YE160404_DATA_LIST;
		Ye160404SrhVO ye160404SrhVo = new Ye160404SrhVO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
		        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(ye160404DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
			ye160404DAO = (Ye160404DAO) wac.getBean("Ye160404DAO");
		}
		        
		try {
			//TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
			ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();		
			PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

			//Get paging configuration
		    PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

		    //Get query parameters
		    //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
		    	
//		    	List<String> listDeptCd = new ArrayList<String>();    
		    
		    /** 조건절 */
		    ye160404SrhVo.setDpobCd(sessionUser.getDpobCd()); 																							/** set 사업장코드 : dpobCd */
		    ye160404SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));							/** set 귀속연도 : yrtxBlggYr */
		    ye160404SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));							/** set 연말정산구분코드 : clutSeptCd */
		    ye160404SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));							/** set SYSTEMKEY : systemkey */
		    ye160404SrhVo.setWhdgDebrBusoprRgstnum(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "whdgDebrBusoprRgstnum")));	/** set D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */	
		    	
//		    	yeta3220SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
//		    	yeta3220SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
////		     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
//		     	
//		    	yeta3220SrhVo.setUsrId(sessionUser.getUsrId());
//	            /******************************** 권한 ************************************************************************/
//	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//	            if ("FALSE".equals(chkDeptCd)) {
//	            	yeta3220SrhVo.setDeptCd(sessionUser.getDeptCd()); 
//	               listDeptCd.add(sessionUser.getDeptCd());
//	               yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
//	               yeta3220SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//	            } else {
//	            	yeta3220SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
//	                     if (yeta3220SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
//	                     	 listDeptCd = null; 
//	                     	yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	                     	yeta3220SrhVo.setDeptCd("");  //부서코드
//	                     } else {
//	                    	 yeta3220SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
//	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	                          yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
//	                     } 
//	            }
//	            
////	            } else {
////	            	
////	            }
//	            
//	            yeta3220SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
//	            yeta3220SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
//	            
//	           /******************************** 권한 ************************************************************************/
//		     	
//		     	
//	            yeta3220SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
//		            
////		       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
////		     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
////		      	yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//		            
//		       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
//		       	yeta3220SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
//		       	yeta3220SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
//		           
////		     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
////		     	yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
////		     	yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
//		             
//		      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
//		      	yeta3220SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//		      	yeta3220SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
//		             
//		      	yeta3220SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
//		           
//		           
//		      	yeta3220SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy"))); //년도
//		      	yeta3220SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
//		      	yeta3220SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
		            
		      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
		    if ( pagingValues.executeRecordCount ) { 
			            	
		    	//Execute query that returns a single value
		    	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		    	int iResultCnt = ye160404DAO.selectYetaP23001ToYe160404ListtTotCnt(ye160404SrhVo);  
		          	
		          	
		              
		          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
		          	
		          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                
		         	pagingValues.totalRecordCount = iResultCnt;	       
		                
		        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
				}
		        
		     	TimingInfo millisBeginYeta3100DataList = SmrmfUtils.startTiming(logger);
		        
		     	/**페이지 카운트 처리를 위한 부분 */ 
		     	ye160404SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		ye160404SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		ye160404SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
		            
		     	@SuppressWarnings("unchecked")
//		            Collection<Map<String, Object>> list ??????
		     	List list = ye160404DAO.selectYetaP23001ToYe160404List(ye160404SrhVo);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
				while (iter.hasNext()) {

					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

					
					Map<String, Object> map = (Map<String, Object>) iter.next();
					String idValue = map.get("systemkey").toString();
		        	BaseModel bm = new BaseModel();
		 
		       	//bm.setProperties(map);
		     	for ( int i=0 ; i<tableAttributes.length ; i++ ) {
		     		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
		     		Object mapCon = map.get(tableAttributes[i].getName());  
		                     
		     		switch ( tableAttributes[i].getType() ) {  
		          		case ColumnDef.TYPE_DATE: 
		          		case ColumnDef.TYPE_DATETIME: 
		                       
		             	Date value =  SmrmfUtils.getDateFromString(String.valueOf(mapCon),"yyyyMMdd");
		            	map.put(tableAttributes[i].getName(), value);
		                     
		            	break;
		            	
		            	//3. 복호화
		          		case ColumnDef.TYPE_STRING: 
		          		          			          			
		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

		          			String rrnDecCrypt = "";
		          	   			
		          			if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
		          		          			
		          		          			
		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;
		          							
		          			}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("degtrResnRegnNum".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("rsnoNumb".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("cnclRsno".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("leasRsno".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("mnrnRsno".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }
		          				
		          		map.put(tableAttributes[i].getName(), strValue);
		          			                    
		          		break;
		                       
		          		case ColumnDef.TYPE_LONG:   
		                     
		          			if (mapCon != null) {  
		          				Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
		                        map.put(tableAttributes[i].getName(), lValue); 
		                    }  
		                       
		                     break;
		                     
		          		case ColumnDef.TYPE_DOUBLE:  
		          			
		                      if (mapCon != null) {      
		                         Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue(); 
		                         map.put(tableAttributes[i].getName(), dbValue); 
		                      }  
		                       
		                   	break;
		     		}
		     		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/    
		     			Object baseModelValue = null;
		            	//콤보박스처리를 위해 추가함
		     			if (tableAttributes[i].getName().contains("$")) {
		     				
		     				String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
		                              
		     				map.put(tableAttributes[i].getName(),map.get(strMapCon));
		                         
		                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
		                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
		     			} else {
		                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
		                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
		     			}
		     		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                    
		                    bm.set(tableAttributes[i].getName(), baseModelValue);
		     	}

		     	bm.set(TableDef.ID_PROPERTY_NAME, idValue);
		     	bmResult.add(bm);
			} 

				retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
		            
				SmrmfUtils.endTiming(logger, millisBeginYeta3100DataList, "getYetaP13006To3100List");
		       
			} catch (Exception ex) {
				ex.printStackTrace();
				//Return operation exception
				throw MSFServerUtils.getOperationException(method, ex, logger);
			}
			return retval;
	}	
	
	
} 
 