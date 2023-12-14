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
package com.app.exterms.yearendtax.server.service.yeta2020;

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

import com.app.exterms.yearendtax.client.dto.yeta2020.Ye161010DTO;
import com.app.exterms.yearendtax.client.dto.yeta2020.Ye161020DTO;
import com.app.exterms.yearendtax.client.dto.yeta2020.Ye161030DTO;
import com.app.exterms.yearendtax.client.dto.yeta2020.Ye161040DTO;
import com.app.exterms.yearendtax.client.dto.yeta2020.Ye161055DTO;
import com.app.exterms.yearendtax.client.dto.yeta2020.Ye161060DTO;
import com.app.exterms.yearendtax.client.dto.yeta2020.Ye161070DTO;
import com.app.exterms.yearendtax.client.dto.yeta2020.Ye161080DTO;
import com.app.exterms.yearendtax.client.dto.yeta2020.Ye161090DTO;
//import com.app.exterms.yearendtax.client.service.yeta2017.Yeta2300Service;
import com.app.exterms.yearendtax.client.service.yeta2020.Yeta5300Service;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye160404_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye161010_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye161020_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye161030_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye161040_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye161050_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye161055_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye161060_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye161070_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye161080_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye161090_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye164010_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye165030_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye166010_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye169010_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye169010a_2020_DAO;
import com.app.exterms.yearendtax.server.vo.Ye160404_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161010_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161020Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161020_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161030Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161030_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161040Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161040_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161050_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161055Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161055_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161060Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161060_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161070Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161070_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161080Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161080_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161090_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye164010_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye169010Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye169010_2020_VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0530VO;
import com.app.smrmf.infc.sysif.msfpackage.server.utils.SysifPkgServiceUtils;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;
import com.app.smrmf.pkg.listener.yeta.yeta2020.Yeta5300ListenerAdapter;
import com.app.smrmf.pkg.yeta.yeta2020.pdfxml.Func_PdfInDdc_Yeta2020_Insert;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0350VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;


/**
 * @Class Name : Yeta2300ServiceImpl.java
 * @since : 2017. 12. 17. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Service("Yeta5300Service")
public class Yeta5300ServiceImpl  extends AbstractCustomServiceImpl implements Yeta5300Service  ,YetaDaoConstants {
	 
	private static final Logger logger = LoggerFactory.getLogger(Yeta5300ServiceImpl.class);
	private static final String calledClass = Yeta5300ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "Ye161010_2020_DAO")
	private Ye161010_2020_DAO ye161010DAO;
	
	// 인적소득
	@Autowired
	@Resource(name = "Ye161020_2020_DAO")
	private Ye161020_2020_DAO ye161020DAO;
	
	@Autowired
	@Resource(name = "Ye160404_2020_DAO")
	private Ye160404_2020_DAO ye160404DAO;
	  
	@Autowired
	@Resource(name = "Ye161030_2020_DAO")
	private Ye161030_2020_DAO ye161030DAO;
	
	@Autowired
	@Resource(name = "Ye161040_2020_DAO")
	private Ye161040_2020_DAO ye161040DAO;
	
	@Autowired
	@Resource(name = "Ye161050_2020_DAO")
	private Ye161050_2020_DAO ye161050DAO;
	
	@Autowired
	@Resource(name = "Ye161055_2020_DAO")
	private Ye161055_2020_DAO ye161055DAO;
	
	@Autowired
	@Resource(name = "Ye161060_2020_DAO")
	private Ye161060_2020_DAO ye161060DAO;
	
	@Autowired
	@Resource(name = "Ye161070_2020_DAO")
	private Ye161070_2020_DAO ye161070DAO;
	
	@Autowired
	@Resource(name = "Ye161080_2020_DAO")
	private Ye161080_2020_DAO ye161080DAO;
	
	// 교육비 내역
	@Autowired
	@Resource(name = "Ye161090_2020_DAO")
	private Ye161090_2020_DAO ye161090DAO;
	
	@Autowired
	@Resource(name = "Ye169010_2020_DAO")
	private Ye169010_2020_DAO ye169010DAO;
	
	@Autowired
	@Resource(name = "Ye169010a_2020_DAO")
	private Ye169010a_2020_DAO ye169010aDAO;
	
	// 의료비 
	@Autowired
	@Resource(name = "Ye164010_2020_DAO")
	private Ye164010_2020_DAO ye164010DAO;
	
	// 기부금
	@Autowired
	@Resource(name = "Ye165030_2020_DAO")
	private Ye165030_2020_DAO ye165030DAO;
	
	// 신용카드
	@Autowired
	@Resource(name = "Ye166010_2020_DAO")
	private Ye166010_2020_DAO ye166010DAO;
	
	
	

	/** 대상자 정보 조회 **/
	public PagingLoadResult<BaseModel> getYeta5300ToYe161010DataList(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETA1300ToYETA2000_LIST;
		Ye161010Srh_2020_VO ye161010SrhVo = new Ye161010Srh_2020_VO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(ye161010DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			ye161010DAO = (Ye161010_2020_DAO) wac.getBean("Ye161010_2020_DAO" ); 
		}

		try {
			
			ColumnAttribute[] tableAttributes = serviceParameters.getTableAttributes();
			IColumnFilter columnFilters = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders = serviceParameters.getColumnOrders();
			PagingLoadConfig pagingLoadConfig = serviceParameters.getPagingLoadConfig();

			// Get paging configuration
			PagingValues pagingValues = MSFServerUtils.getPagingValues(
					pagingLoadConfig, columnOrders);

	    	//Get query parameters
	      	//String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	    	
	    	List<String> listDeptCd = new ArrayList<String>();    
	      	/** 조건절 */
	    	ye161010SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	ye161010SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));	// 정산년도
	    	ye161010SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분
	 
	       	ye161010SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  // 단위기관담당자여부 
	    	ye161010SrhVo.setUsrId(sessionUser.getUsrId());
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	ye161010SrhVo.setDeptCd(sessionUser.getDeptCd()); 
               listDeptCd.add(sessionUser.getDeptCd());
               ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
               ye161010SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	ye161010SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
				if (ye161010SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
					listDeptCd = null; 
					ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
					ye161010SrhVo.setDeptCd("");  //부서코드
				} else {
					ye161010SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
					listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
					ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
				} 
            }
            
            ye161010SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            ye161010SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
           /******************************** 권한 ************************************************************************/
	     	
	     	
            ye161010SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	            
//	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	      	yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            
	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	       	ye161010SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	       	ye161010SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
//	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	     	yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	     	yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	      	ye161010SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	      	ye161010SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	             
	      	ye161010SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	           
	           
	      	ye161010SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr"))); //년도
	      	ye161010SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	      	ye161010SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
	      	
	      	ye161010SrhVo.setUtDpobCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "utDpobCd")));    //원천신고부서
	      	
//	      	yeta2000SrhVo.setPrintType(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "printType")));    //출력대상
	      	
	            
	    	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
	     	SysIfBass0350VO  sysIfBass0350Vo = new SysIfBass0350VO();
	     //	 List<String> listTyInttnCd = new ArrayList<String>(); 
	     	sysIfBass0350Vo.setDpobCd(sessionUser.getDpobCd());
	     	sysIfBass0350Vo.setYmdGb("Y");
	     	sysIfBass0350Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy")));
	     	sysIfBass0350Vo.setTypOccuCd(ye161010SrhVo.getTypOccuCd());
	     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
	    	sysIfBass0350Vo.setDtilOccuInttnCd(ye161010SrhVo.getDtilOccuInttnCd());
	     	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	     	
	     	sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0350Vo); 
	     
	     	ye161010SrhVo.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
	     	ye161010SrhVo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
	     	
	     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = ye161010DAO.selectYeta5300ToYe161010ListTotCnt(ye161010SrhVo);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginYe161010DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	ye161010SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		ye161010SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		ye161010SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = ye161010DAO.selectYeta5300ToYe161010List(ye161010SrhVo);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
			while (iter.hasNext()) {
				

				// 1. 암호화 객체 생성
			 nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			        
				
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
	                       
	          		case ColumnDef.TYPE_LONG:   
	                     
	          			if (mapCon != null) {  
	          				Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
	                        map.put(tableAttributes[i].getName(), lValue); 
	                    }  
	                       
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
	          	    
	          	        } else if("rsnoNumb".equals(tableAttributes[i].getName())) { 
            			// 복호화
            			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
            			strValue = rrnDecCrypt;
                    
	          	        }
	          				
	          		map.put(tableAttributes[i].getName(), strValue);
	          			                    
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
			SmrmfUtils.endTiming(logger, millisBeginYe161010DataList, "getYeta5300ToYe161010DataList");
	       
		} catch (Exception ex) {
			
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
			
		}
		
		return retval;
		
	}
	
	
	
	
	/** 세액계산 정보 조회 **/
	public PagingLoadResult<BaseModel> getYeta5300ToSubTaxList(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETA5300_TO_YE169010_SUBTAX_LIST;
		
		
		Ye169010Srh_2020_VO ye169010SrhVo = new Ye169010Srh_2020_VO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(ye169010DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			ye169010DAO = (Ye169010_2020_DAO) wac.getBean("Ye169010_2020_DAO" ); 
		}
		
		if  (MSFSharedUtils.paramNull(ye169010aDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			ye169010aDAO = (Ye169010a_2020_DAO) wac.getBean("Ye169010a_2020_DAO" ); 
		}

		try {
			
			ColumnAttribute[] tableAttributes = serviceParameters.getTableAttributes();
			IColumnFilter columnFilters = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders = serviceParameters.getColumnOrders();
			PagingLoadConfig pagingLoadConfig = serviceParameters.getPagingLoadConfig();

			// Get paging configuration
			PagingValues pagingValues = MSFServerUtils.getPagingValues(
					pagingLoadConfig, columnOrders);

	    	//Get query parameters
	      	//String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	    	
	    	List<String> listDeptCd = new ArrayList<String>();    
	      	/** 조건절 */
	    	ye169010SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	ye169010SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));	// 정산년도
	    	ye169010SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분
	    	ye169010SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));    /** column SYSTEMKEY : systemkey */
	    	ye169010SrhVo.setC152StdTxDdcYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "c152StdTxDdcYn")));  
	    	
	    	
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = 0;
	          	
	          	if("Y".equals(ye169010SrhVo.getC152StdTxDdcYn())) {
	          		iResultCnt = ye169010aDAO.selectYeta5300ToYe169010aListTotCnt(ye169010SrhVo);
	          	}else {
	          		iResultCnt = ye169010DAO.selectYeta5300ToYe169010ListtTotCnt(ye169010SrhVo);
	          	}
	          	  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginYe161010DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	ye169010SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		ye169010SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		ye169010SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     
//	            Collection<Map<String, Object>> list ??????
	    	List list;
	     	if("Y".equals(ye169010SrhVo.getC152StdTxDdcYn())) {
	     		
		    	list = ye169010aDAO.selectYeta5300ToYe169010aList(ye169010SrhVo);
	     		
          	}else {
          		
          		list = ye169010DAO.selectYeta5300ToYe169010List(ye169010SrhVo);
          	}
	    	
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
			while (iter.hasNext()) {
				

				// 1. 암호화 객체 생성
			 nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			        
				
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
	                       
	          		case ColumnDef.TYPE_LONG:   
	                     
	          			if (mapCon != null) {  
	          				Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
	                        map.put(tableAttributes[i].getName(), lValue); 
	                    }  
	                       
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
	          	    
	          	        } else if("rsnoNumb".equals(tableAttributes[i].getName())) { 
            			// 복호화
            			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
            			strValue = rrnDecCrypt;
                    
	          	        }
	          				
	          		map.put(tableAttributes[i].getName(), strValue);
	          			                    
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
			SmrmfUtils.endTiming(logger, millisBeginYe161010DataList, "getYeta5300ToYe161010DataList");
	       
		} catch (Exception ex) {
			
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
			
		}
		
		return retval;
		
	}
	
	
		
	
	
	/** 인적공제명세 정보 조회 **/
	public PagingLoadResult<BaseModel> getYeta5300ToYe161030List(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA5300_TO_YE161030_DATA_LIST;
		Ye161030Srh_2020_VO   ye161030SrhVo = new Ye161030Srh_2020_VO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(ye161030DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			ye161030DAO = (Ye161030_2020_DAO) wac.getBean("Ye161030_2020_DAO"); 
		}
	        
		try {
			
			ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();		
			PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

			//Get paging configuration
	    	PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	    	
//	    	List<String> listDeptCd = new ArrayList<String>();    
	    	
	      	/** 조건절 */
	    	ye161030SrhVo.setDpobCd(sessionUser.getDpobCd());   			 																/** column 사업장코드 : dpobCd */
	    	ye161030SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));    			/** column 귀속연도 : yrtxBlggYr */
	    	ye161030SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));    			/** column 연말정산구분코드 : clutSeptCd */
	    	ye161030SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));    			/** column SYSTEMKEY : systemkey */
	    	ye161030SrhVo.setTxprDscmNoCntn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "txprDscmNoCntn")));    	/** column 주민등록번호 : txprDscmNoCntn */
	    	
	    	
	            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = ye161030DAO.selectYeta53001ToYe161030ListtTotCnt(ye161030SrhVo);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginPsnl0126DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	ye161030SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		ye161030SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		ye161030SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = ye161030DAO.selectYeta53001ToYe161030List(ye161030SrhVo);
	            
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
	          							
	          			}else if("txprDscmNoCntn".equals(tableAttributes[i].getName())) {

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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta5300To2000List");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	/** 소득공제명세 정보 조회 **/	
	public PagingLoadResult<BaseModel> getYeta5300ToYe161040List(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA5300_TO_YE161040_DATA_LIST;
		Ye161040Srh_2020_VO   ye161040SrhVo = new Ye161040Srh_2020_VO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(ye161040DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			ye161040DAO = (Ye161040_2020_DAO) wac.getBean("Ye161040_2020_DAO"); 
		}
	        
		try {
			
			ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();		
			PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

			//Get paging configuration
	    	PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	    	
//	    	List<String> listDeptCd = new ArrayList<String>();    
	    	
	      	/** 조건절 */
	    	ye161040SrhVo.setDpobCd(sessionUser.getDpobCd());   			 																/** column 사업장코드 : dpobCd */
	    	ye161040SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));    			/** column 귀속연도 : yrtxBlggYr */
	    	ye161040SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));    			/** column 연말정산구분코드 : clutSeptCd */
	    	ye161040SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));    			/** column SYSTEMKEY : systemkey */
	    	ye161040SrhVo.setCdVvalKrnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "cdVvalKrnCd")));    		/** column 소득공제명세자료구분코드 : cdVvalKrnCd */
	    	
	    	
	            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = ye161040DAO.selectYeta5300ToYe161040ListTotCnt(ye161040SrhVo);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginPsnl0126DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	ye161040SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		ye161040SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		ye161040SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = ye161040DAO.selectYeta5300ToYe161040List(ye161040SrhVo);
	            
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
	          							
	          			}else if("txprDscmNoCntn".equals(tableAttributes[i].getName())) {

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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta5300To2000List");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	/** 교육비내역 조회 **/
//	public PagingLoadResult<BaseModel> getYeta5300ToYe161090List(ServiceParameters serviceParameters) throws MSFException {
//			
//
//			PagingLoadResult<BaseModel> retval = null;
//			String method =  CLASS_YETA2300_TO_YE161090_DATA_LIST;
//			Ye161090SrhVO   ye161090SrhVo = new Ye161090SrhVO();
//			List<BaseModel>  bmResult = new ArrayList<BaseModel>();
//			MSFSysm0100BM sessionUser;
//			
//		        
//			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
//				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//			} else {
//				sessionUser = getUser();
//			}
//		      
//			if  (MSFSharedUtils.paramNull(ye161090DAO)) {
//				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//				ye161090DAO = (Ye161090DAO) wac.getBean("Ye161090DAO"); 
//			}
//		        
//			try {
//				//TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
//				ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
//				IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
//				List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();		
//				PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
//
//				//Get paging configuration
//		    	PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
//
//		    	//Get query parameters
//		      	//String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
//		    	
////		    	List<String> listDeptCd = new ArrayList<String>();    
//		      	/** 조건절 */
//		    	ye161090SrhVo.setDpobCd(sessionUser.getDpobCd());    /** column 사업장코드 : dpobCd */
//		    	ye161090SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));    /** column 귀속연도 : yrtxBlggYr */
//		    	ye161090SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));    /** column 연말정산구분코드 : clutSeptCd */
//		    	ye161090SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));    /** column SYSTEMKEY : systemkey */
////		    	ye161090SrhVo.setFamResnoEncCntn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "famResnoEncCntn")));    /** column 가족주민등록번호 : famResnoEncCntn */
//		    	
////		    	yeta3220SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
////		    	yeta3220SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//////		     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
////		     	
////		    	yeta3220SrhVo.setUsrId(sessionUser.getUsrId());
////	            /******************************** 권한 ************************************************************************/
////	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
////	            if ("FALSE".equals(chkDeptCd)) {
////	            	yeta3220SrhVo.setDeptCd(sessionUser.getDeptCd()); 
////	               listDeptCd.add(sessionUser.getDeptCd());
////	               yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
////	               yeta3220SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
////	            } else {
////	            	yeta3220SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
////	                     if (yeta3220SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
////	                     	 listDeptCd = null; 
////	                     	yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
////	                     	yeta3220SrhVo.setDeptCd("");  //부서코드
////	                     } else {
////	                    	 yeta3220SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
////	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
////	                          yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
////	                     } 
////	            }
////	            
//////	            } else {
//////	            	
//////	            }
////	            
////	            yeta3220SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
////	            yeta3220SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
////	            
////	           /******************************** 권한 ************************************************************************/
////		     	
////		     	
////	            yeta3220SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
////		            
//////		       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//////		     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//////		      	yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
////		            
////		       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
////		       	yeta3220SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
////		       	yeta3220SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
////		           
//////		     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//////		     	yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//////		     	yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
////		             
////		      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
////		      	yeta3220SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
////		      	yeta3220SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
////		             
////		      	yeta3220SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
////		           
////		           
////		      	yeta3220SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy"))); //년도
////		      	yeta3220SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
////		      	yeta3220SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
//		            
//		      	// Get total record count //전체 데이터 갯수를 가지고 온다. 
//				if ( pagingValues.executeRecordCount ) { 
//			            	
//					//Execute query that returns a single value
//		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//		                 
//		          	int iResultCnt = ye161090DAO.selectYeta2300ToYe161090ListTotCnt(ye161090SrhVo);  
//		              
//		          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
//		          	
//		          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
//	                if (!pagingValues.pageExecute) { 
//	                    pagingValues.offsetLimit = iResultCnt;       
//	                }
//	                
//		         	pagingValues.totalRecordCount = iResultCnt;	       
//		                
//		        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//				}
//		        
//		     	TimingInfo millisBeginPsnl0126DataList = SmrmfUtils.startTiming(logger);
//		        
//		     	/**페이지 카운트 처리를 위한 부분 */ 
//		     	ye161090SrhVo.setPageSize(pagingValues.totalRecordCount);  
//		            
//		     	//Apply paging
//		     	if (pagingValues.start > 0) {
//		     		ye161090SrhVo.setFirstIndex(pagingValues.start);
//		     	}
//		     	if (pagingValues.offsetLimit > 0) {
//		     		ye161090SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
//		     	}
//
//		     	//Execute query and convert to BaseModel list
//		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
////		            
////		     	@SuppressWarnings("unchecked")
//////		            Collection<Map<String, Object>> list ??????
//		     	List list = ye161090DAO.selectYeta2300ToYe161090List(ye161090SrhVo);
//		            
//				Iterator<Map<String, Object>> iter = list.iterator();
//			            
////				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
//		           
//		        
//				while (iter.hasNext()) { 
//
//					// 1. 암호화 객체 생성
//					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//				        
//					Map<String, Object> map = (Map<String, Object>) iter.next();
//					String idValue = map.get("systemkey").toString();
//		        	BaseModel bm = new BaseModel();
//		 
//		       	//bm.setProperties(map);
//		     	for ( int i=0 ; i<tableAttributes.length ; i++ ) {
//		     		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
//		     		Object mapCon = map.get(tableAttributes[i].getName());  
//		                     
//		     		switch ( tableAttributes[i].getType() ) {  
//		          		case ColumnDef.TYPE_DATE: 
//		          		case ColumnDef.TYPE_DATETIME: 
//		                       
//		             	Date value =  SmrmfUtils.getDateFromString(String.valueOf(mapCon),"yyyyMMdd");
//		            	map.put(tableAttributes[i].getName(), value);
//		                     
//		            	break; 
//		                       
//		          		case ColumnDef.TYPE_LONG:   
//		                     
//		          			if (mapCon != null) {  
//		          				Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
//		                        map.put(tableAttributes[i].getName(), lValue); 
//		                    }  
//		                       
//		                     break;
//		                     
//		                 	//3. 복호화
//		          		case ColumnDef.TYPE_STRING: 
//		          		          			          			
//		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
//
//		          			String rrnDecCrypt = "";
//		          	   			
//		          			if(	"famResnoEncCntn".equals(tableAttributes[i].getName())) {
//		          		          			
//		          				// 주민번호(복호화)
//		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//		          		          		
//		          				strValue = rrnDecCrypt;
//		          							
//		          			}
//		          				
//		          		map.put(tableAttributes[i].getName(), strValue);
//		          			                    
//		          		break;
//     
//		                     
//		          		case ColumnDef.TYPE_DOUBLE:  
//		          			
//		                      if (mapCon != null) {      
//		                         Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue(); 
//		                         map.put(tableAttributes[i].getName(), dbValue); 
//		                      }  
//		                       
//		                   	break;
//		     		}
//		     		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/    
//		     			Object baseModelValue = null;
//		            	//콤보박스처리를 위해 추가함
//		     			if (tableAttributes[i].getName().contains("$")) {
//		     				
//		     				String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
//		                              
//		     				map.put(tableAttributes[i].getName(),map.get(strMapCon));
//		                         
//		                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//		                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
//		     			} else {
//		                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//		                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
//		     			}
//		     		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//		                    
//		                    bm.set(tableAttributes[i].getName(), baseModelValue);
//		     	}
//
//		     	bm.set(TableDef.ID_PROPERTY_NAME, idValue);
//		     	bmResult.add(bm);
//			} 
//
//				retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
//		            
////				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
//		       
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			// Return operation exception
//			throw MSFServerUtils.getOperationException(method, ex, logger);
//		}
//		return retval;
//	}

	
	/** 기본사항 tab 조회 **/
	public Ye161020DTO getYeta5300ToYe161020Data(Ye161020DTO ye161020Dto) throws MSFException {
		

		Ye161020Srh_2020_VO ye161020SrhVo = new Ye161020Srh_2020_VO();
		MSFSysm0100BM sessionUser;

		String method = calledClass + ".getYeta5300ToYe161020Data";

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(ye161020DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
							.getSession().getServletContext());
			ye161020DAO = (Ye161020_2020_DAO) wac.getBean("Ye161020_2020_DAO");
		}
		
		

		/** 조건절 */
		ye161020SrhVo.setDpobCd(ye161020Dto.getDpobCd());   		/** column 사업장코드 : dpobCd */
		ye161020SrhVo.setYrtxBlggYr(ye161020Dto.getYrtxBlggYr());	/** column 귀속연도 : yrtxBlggYr */
		ye161020SrhVo.setClutSeptCd(ye161020Dto.getClutSeptCd());	/** column 연말정산구분코드 : clutSeptCd */
		ye161020SrhVo.setSystemkey(ye161020Dto.getSystemkey());    	/** column SYSTEMKEY : systemkey */

//		int iResultCnt = ye161020DAO.selectYeta2300ToYe161020ListtTotCnt(ye161020SrhVo);
		
		Ye161020DTO returnYe161020Dto = new Ye161020DTO();
		List egovResultDataList = new ArrayList();

		try {
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
			egovResultDataList = ye161020DAO.selectYeta5300ToYe161020Data(ye161020SrhVo);
			
			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";

			if (egovResultDataList != null && egovResultDataList.size() > 0) {
				
				for (int i = 0; i < egovResultDataList.size(); i++) {

					Map tempMap = (Map) egovResultDataList.get(i);
					
					returnYe161020Dto.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    							/** column 사업장코드 : dpobCd */
					returnYe161020Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(tempMap.get("yrtxBlggYr")));						/** column 귀속연도 : yrtxBlggYr */
					returnYe161020Dto.setClutSeptCd(MSFSharedUtils.allowNulls(tempMap.get("clutSeptCd")));    					/** column 연말정산구분코드 : clutSeptCd */
					returnYe161020Dto.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));   		 				/** column SYSTEMKEY : systemkey */
					returnYe161020Dto.setFnm(MSFSharedUtils.allowNulls(tempMap.get("fnm")));    								/** column 소득자성명 : fnm */
					
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(String.valueOf(tempMap.get("resnoEncCntn"))).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					returnYe161020Dto.setResnoEncCntn(rrnDecCrypt);    															/** column 주민등록번호 : resnoEncCntn */
					
					returnYe161020Dto.setNnfClCd(MSFSharedUtils.allowNulls(tempMap.get("nnfClCd")));    						/** column 내외국인구분 : nnfClCd */
					returnYe161020Dto.setTnm(MSFSharedUtils.allowNulls(tempMap.get("tnm")));    								/** column 근무처명 : tnm */
					returnYe161020Dto.setBsnoEncCntn(MSFSharedUtils.allowNulls(tempMap.get("bsnoEncCntn")));    				/** column 사업자등록번호 : bsnoEncCntn */
					returnYe161020Dto.setHshrClCd(MSFSharedUtils.allowNulls(tempMap.get("hshrClCd")));   			 			/** column 세대주여부 : hshrClCd */
					returnYe161020Dto.setRsplNtnInfrNm(MSFSharedUtils.allowNulls(tempMap.get("rsplNtnInfrNm")));    			/** column 국적 : rsplNtnInfrNm */
					returnYe161020Dto.setRsplNtnInfrCd(MSFSharedUtils.allowNulls(tempMap.get("rsplNtnInfrCd")));    			/** column 국적코드 : rsplNtnInfrCd */
					returnYe161020Dto.setRsplNtnInfrItem(MSFSharedUtils.allowNulls(tempMap.get("rsplNtnInfrItem"))); 
					returnYe161020Dto.setDtyStrtDt(MSFSharedUtils.allowNulls(tempMap.get("dtyStrtDt")));    					/** column 근무기간시작일자 : dtyStrtDt */
					returnYe161020Dto.setDtyEndDt(MSFSharedUtils.allowNulls(tempMap.get("dtyEndDt")));    						/** column 근무기간종료일자 : dtyEndDt */
					returnYe161020Dto.setReStrtDt(MSFSharedUtils.allowNulls(tempMap.get("reStrtDt")));    						/** column 감면기간시작일자 : reStrtDt */
					returnYe161020Dto.setReEndDt(MSFSharedUtils.allowNulls(tempMap.get("reEndDt")));    						/** column 감면기간종료일자 : reEndDt */
					returnYe161020Dto.setRsdtClCd(MSFSharedUtils.allowNulls(tempMap.get("rsdtClCd")));    						/** column 거주구분 : rsdtClCd */
					returnYe161020Dto.setRsplNtnNm(MSFSharedUtils.allowNulls(tempMap.get("rsplNtnNm")));    					/** column 거주지국명 : rsplNtnNm */
					returnYe161020Dto.setRsplNtnCd(MSFSharedUtils.allowNulls(tempMap.get("rsplNtnCd")));    					/** column 거주지코드 : rsplNtnCd */
					returnYe161020Dto.setRsplNtnItem(MSFSharedUtils.allowNulls(tempMap.get("rsplNtnItem"))); 
					returnYe161020Dto.setInctxWhtxTxamtMetnCd(MSFSharedUtils.allowNulls(tempMap.get("inctxWhtxTxamtMetnCd")));	/** column 소득세원천징수세액조정구분코드 : inctxWhtxTxamtMetnCd */
					returnYe161020Dto.setFileSbtYn(MSFSharedUtils.allowNulls(tempMap.get("fileSbtYn"))); 						/** set 소득공제신고전자파일제출여부 : fileSbtYn */
					
					returnYe161020Dto.setInpmYn(MSFSharedUtils.allowNulls(tempMap.get("inpmYn")));    							/** column 분납신청여부 : inpmYn */
					returnYe161020Dto.setC152StdTxDdcYn(MSFSharedUtils.allowNulls(tempMap.get("c152StdTxDdcYn")));    			/** column 표준세액공제적용여부 : c152StdTxDdcYn */
//					returnYe161020Dto.setPrifChngYn(MSFSharedUtils.allowNulls(tempMap.get("prifChngYn")));    					/** column 인적공제항목변동여부 : prifChngYn */
//					returnYe161020Dto.set표준세액공제적용여부(MSFSharedUtils.allowNulls(tempMap.get("표준세액공제적용여부")));		/** column 표준세액공제적용여부 : 표준세액공제적용여부 */
					
					
					returnYe161020Dto.setPrcspPaySum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("prcspPaySum"), "0")));		  			/** set D15_종전근무처급여금액 : prcspPaySum */
					returnYe161020Dto.setPrcspIncmTxSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("prcspIncmTxSum"), "0")));			/** set D56_종전근무지기납부세액_소득세금액 : prcspIncmTxSum */
					returnYe161020Dto.setPrcspRgonIncmTxSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("prcspRgonIncmTxSum"), "0")));	/** set D57_종전근무지기납부세액_지방소득세금액 : prcspRgonIncmTxSum */
//					
					returnYe161020Dto.setYeta0c29(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c29"), "0")));						/** set C22_주현근무처_급여금액 : yeta0c29 */
					returnYe161020Dto.setYeta0c63(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c63"), "0")));						/** set C63_정산명세_총급여금액 : yeta0c63 */
					returnYe161020Dto.setYeta0c64(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c64"), "0")));						/** set C64_정산명세_근로소득공제금액 : yeta0c64 */
					returnYe161020Dto.setYeta0c65(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c65"), "0")));   					/** set C65_정산명세_근로소득금액 : yeta0c65 */
					returnYe161020Dto.setYetaC120(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaC120"), "0")));						/** set C120_세액공제_근로소득세액공제금액 : yetaC120 */
					returnYe161020Dto.setYetaC112(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaC112"), "0"))); 						/** set C112_종합소득과세표준금액 : yetaC112 */
					returnYe161020Dto.setYetaC113(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaC113"), "0")));						/** set C113_산출세액 : yetaC113 */
					returnYe161020Dto.setYetaC162(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaC162"), "0")));						/** set C162_주현근무지_기납부세액_소득세금액 : yetaC162 */
					returnYe161020Dto.setYetaC163(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaC163"), "0")));						/** set C163_주현근무지_기납부세액_지방소득세금액 : yetaC163 */					
					
				}
			}

		} catch (Exception ex) {
			
			ex.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
			
		}
		
		/** 로그반영
		 * CRUDSBLO 
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass,"S");

		return returnYe161020Dto;

	}

	
	/** 기본사항 tab 수정 **/ 
	@Override
	public int saveYeta5300ToYe161020tabItem01(Ye161020DTO ye161020Dto)throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		
		Ye161020_2020_VO ye161020Vo = new Ye161020_2020_VO();
		Ye160404_2020_VO ye160404Vo = new Ye160404_2020_VO();
		Ye169010_2020_VO ye169010Vo = new Ye169010_2020_VO();
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";
		
		InfcPkgYe161010_2020_VO infcPkgYe161010Vo = new InfcPkgYe161010_2020_VO(); 
		Yeta5300ListenerAdapter  yeta5300ListenerAdt = new Yeta5300ListenerAdapter();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		String method = calledClass + ".saveYeta5300ToYe161020tabItem01";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		try{
			// ---------- 기본사항 수정 시작 -------------------
			ye161020Vo = new Ye161020_2020_VO();
			
			ye161020Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161020Dto.getDpobCd()));    			/** column 사업장코드 : dpobCd */
			ye161020Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161020Dto.getYrtxBlggYr()));    	/** column 귀속연도 : yrtxBlggYr */
			ye161020Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161020Dto.getClutSeptCd()));    	/** column 연말정산구분코드 : clutSeptCd */
			ye161020Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161020Dto.getSystemkey()));    		/** column SYSTEMKEY : systemkey */
			
			ye161020Vo.setTnm(MSFSharedUtils.allowNulls(ye161020Dto.getTnm()));    					/** column 근무처명 : tnm */
			ye161020Vo.setBsnoEncCntn(MSFSharedUtils.allowNulls(ye161020Dto.getBsnoEncCntn()));    	/** column 사업자등록번호 : bsnoEncCntn */
			ye161020Vo.setHshrClCd(MSFSharedUtils.allowNulls(ye161020Dto.getHshrClCd()));    		/** column 세대주여부 : hshrClCd */
			ye161020Vo.setRsplNtnInfrNm(MSFSharedUtils.allowNulls(ye161020Dto.getRsplNtnInfrNm()));	/** column 국적 : rsplNtnInfrNm */
			ye161020Vo.setRsplNtnInfrCd(MSFSharedUtils.allowNulls(ye161020Dto.getRsplNtnInfrCd()));	/** column 국적코드 : rsplNtnInfrCd */
			ye161020Vo.setDtyStrtDt(MSFSharedUtils.allowNulls(ye161020Dto.getDtyStrtDt()));    		/** column 근무기간시작일자 : dtyStrtDt */
			ye161020Vo.setDtyEndDt(MSFSharedUtils.allowNulls(ye161020Dto.getDtyEndDt()));    		/** column 근무기간종료일자 : dtyEndDt */
			ye161020Vo.setReStrtDt(MSFSharedUtils.allowNulls(ye161020Dto.getReStrtDt()));    		/** column 감면기간시작일자 : reStrtDt */
			ye161020Vo.setReEndDt(MSFSharedUtils.allowNulls(ye161020Dto.getReEndDt()));    			/** column 감면기간종료일자 : reEndDt */
			ye161020Vo.setRsdtClCd(MSFSharedUtils.allowNulls(ye161020Dto.getRsdtClCd()));    		/** column 거주구분 : rsdtClCd */
			ye161020Vo.setRsplNtnNm(MSFSharedUtils.allowNulls(ye161020Dto.getRsplNtnNm()));   		/** column 거주지국명 : rsplNtnNm */
			ye161020Vo.setRsplNtnCd(MSFSharedUtils.allowNulls(ye161020Dto.getRsplNtnCd()));    		/** column 거주지코드 : rsplNtnCd */
	
			/*****************2017귀속추가 ***************************/
			ye161020Vo.setInctxWhtxTxamtMetnCd(ye161020Dto.getInctxWhtxTxamtMetnCd());    			/** column 소득세원천징수세액조정구분코드 : inctxWhtxTxamtMetnCd */
			ye161020Vo.setC152StdTxDdcYn(ye161020Dto.getC152StdTxDdcYn());   			 			/** column 표준세액공제적용여부 : c152StdTxDdcYn */
			ye161020Vo.setInpmYn(ye161020Dto.getInpmYn());    										/** column 분납신청여부 : inpmYn */		
			/*****************2017귀속추가 ***************************/	
			
			ye161020Vo.setIsmt(sessionUser.getUsrId());    											/** column 수정자 : ismt */
			ye161020Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 수정주소 : revnAddr */
			
			ye161020DAO.updateYeta5300Item01ToYe161020(ye161020Vo);
			
			
			// ---------- 소득기본사항 수정 시작 -------------------
			
			// 종전근무처 ye160404 
//			ye160404Vo = new Ye160404VO();
//			
//			ye160404Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161020Dto.getDpobCd()));    				/** column 사업장코드 : dpobCd */
//			ye160404Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161020Dto.getYrtxBlggYr()));    		/** column 귀속연도 : yrtxBlggYr */
//			ye160404Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161020Dto.getClutSeptCd()));    		/** column 연말정산구분코드 : clutSeptCd */
//			ye160404Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161020Dto.getSystemkey()));    			/** column SYSTEMKEY : systemkey */
//			ye160404Vo.setPrcspPaySum(new BigDecimal(MSFSharedUtils.defaultNulls( ye161020Dto.getPrcspPaySum(), "0")));		  			/** set D15_종전근무처급여금액 : prcspPaySum */
//			ye160404Vo.setPrcspIncmTxSum(new BigDecimal(MSFSharedUtils.defaultNulls( ye161020Dto.getPrcspIncmTxSum(), "0")));			/** set D56_종전근무지기납부세액_소득세금액 : prcspIncmTxSum */
//			ye160404Vo.setPrcspRgonIncmTxSum(new BigDecimal(MSFSharedUtils.defaultNulls( ye161020Dto.getPrcspRgonIncmTxSum(), "0")));	/** set D57_종전근무지기납부세액_지방소득세금액 : prcspRgonIncmTxSum */
//			
//			ye160404Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
//			ye160404Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
//			
//			ye160404DAO.updateYeta2300ToYe160404(ye160404Vo);
			
			
			// 주현근무처 ye169010
			ye169010Vo = new Ye169010_2020_VO();
			
			ye169010Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161020Dto.getDpobCd()));    				/** column 사업장코드 : dpobCd */
			ye169010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161020Dto.getYrtxBlggYr()));    		/** column 귀속연도 : yrtxBlggYr */
			ye169010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161020Dto.getClutSeptCd()));    		/** column 연말정산구분코드 : clutSeptCd */
			ye169010Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161020Dto.getSystemkey()));    			/** column SYSTEMKEY : systemkey */
			
			ye169010Vo.setYeta0c29(new BigDecimal(MSFSharedUtils.defaultNulls( ye161020Dto.getYeta0c29(), "0")));	/** set C22_주현근무처_급여금액 : yeta0c22 */
			ye169010Vo.setYeta0c63(new BigDecimal(MSFSharedUtils.defaultNulls( ye161020Dto.getYeta0c63(), "0")));	/** set C63_정산명세_총급여금액 : yeta0c63 */
			ye169010Vo.setYeta0c64(new BigDecimal(MSFSharedUtils.defaultNulls( ye161020Dto.getYeta0c64(), "0")));	/** set C64_정산명세_근로소득공제금액 : yeta0c64 */
			ye169010Vo.setYeta0c65(new BigDecimal(MSFSharedUtils.defaultNulls( ye161020Dto.getYeta0c65(), "0")));   /** set C65_정산명세_근로소득금액 : yeta0c65 */
			ye169010Vo.setYetaC120(new BigDecimal(MSFSharedUtils.defaultNulls( ye161020Dto.getYetaC120(), "0")));	/** set C120_세액공제_근로소득세액공제금액 : yetaC120 */
			ye169010Vo.setYetaC112(new BigDecimal(MSFSharedUtils.defaultNulls( ye161020Dto.getYetaC112(), "0"))); 	/** set C112_종합소득과세표준금액 : yetaC112 */
			ye169010Vo.setYetaC113(new BigDecimal(MSFSharedUtils.defaultNulls( ye161020Dto.getYetaC113(), "0")));	/** set C113_산출세액 : yetaC113 */
			ye169010Vo.setYetaC162(new BigDecimal(MSFSharedUtils.defaultNulls( ye161020Dto.getYetaC162(), "0")));	/** set C162_주현근무지_기납부세액_소득세금액 : yetaC162 */
			ye169010Vo.setYetaC163(new BigDecimal(MSFSharedUtils.defaultNulls( ye161020Dto.getYetaC163(), "0")));	/** set C163_주현근무지_기납부세액_지방소득세금액 : yetaC163 */
		
			ye169010Vo.setIsmt(sessionUser.getUsrId());    												/** column 수정자 : ismt */
			ye169010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 수정주소 : revnAddr */
			
			ye169010DAO.updateYeta5300ToYe169010(ye169010Vo);
			
			BeanUtils.copyProperties(infcPkgYe161010Vo , ye169010Vo);  
			yeta5300ListenerAdt = new Yeta5300ListenerAdapter();
			yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE166020_INSERT");

		
			
			result = 1;
			
		}catch(Exception e){
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			e.printStackTrace();
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			
		}
		// ---------- 기본사항 수정 종료 -------------------
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
		return result;
	}
	
	/** 인적공제 tab 조회 **/
	public Ye161020DTO getYeta5300TabItem02ToYe161020Data(Ye161020DTO ye161020Dto) throws MSFException {
		

		Ye161020Srh_2020_VO ye161020SrhVo = new Ye161020Srh_2020_VO();
		MSFSysm0100BM sessionUser;

		String method = calledClass + ".getYeta5300TabItem02ToYe161020Data";

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(ye161020DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
							.getSession().getServletContext());
			ye161020DAO = (Ye161020_2020_DAO) wac.getBean("Ye161020_2020_DAO");
		}
		
		

		/** 조건절 */
		ye161020SrhVo.setDpobCd(ye161020Dto.getDpobCd());   		/** column 사업장코드 : dpobCd */
		ye161020SrhVo.setYrtxBlggYr(ye161020Dto.getYrtxBlggYr());	/** column 귀속연도 : yrtxBlggYr */
		ye161020SrhVo.setClutSeptCd(ye161020Dto.getClutSeptCd());	/** column 연말정산구분코드 : clutSeptCd */
		ye161020SrhVo.setSystemkey(ye161020Dto.getSystemkey());    	/** column SYSTEMKEY : systemkey */

		int iResultCnt = ye161020DAO.selectYeta5300ToYe161020ListtTotCnt(ye161020SrhVo);
		
		Ye161020DTO returnYe161020Dto = new Ye161020DTO();
		List egovResultDataList = new ArrayList();

		try {
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
			egovResultDataList = ye161020DAO.selectYeta5300ToYe161020Data(ye161020SrhVo);
			
			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";

			if (egovResultDataList != null && egovResultDataList.size() > 0) {
				
				for (int i = 0; i < egovResultDataList.size(); i++) {

					Map tempMap = (Map) egovResultDataList.get(i);
					
//					returnYe161020Dto.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    							/** column 사업장코드 : dpobCd */
//					returnYe161020Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(tempMap.get("yrtxBlggYr")));						/** column 귀속연도 : yrtxBlggYr */
//					returnYe161020Dto.setClutSeptCd(MSFSharedUtils.allowNulls(tempMap.get("clutSeptCd")));    					/** column 연말정산구분코드 : clutSeptCd */
//					returnYe161020Dto.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));   		 				/** column SYSTEMKEY : systemkey */
//					returnYe161020Dto.setFnm(MSFSharedUtils.allowNulls(tempMap.get("fnm")));    								/** column 소득자성명 : fnm */
//					
//					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(String.valueOf(tempMap.get("resnoEncCntn"))).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//					returnYe161020Dto.setResnoEncCntn(rrnDecCrypt);    															/** column 주민등록번호 : resnoEncCntn */
//					
//					returnYe161020Dto.setNnfClCd(MSFSharedUtils.allowNulls(tempMap.get("nnfClCd")));    						/** column 내외국인구분 : nnfClCd */
//					returnYe161020Dto.setTnm(MSFSharedUtils.allowNulls(tempMap.get("tnm")));    								/** column 근무처명 : tnm */
//					returnYe161020Dto.setBsnoEncCntn(MSFSharedUtils.allowNulls(tempMap.get("bsnoEncCntn")));    				/** column 사업자등록번호 : bsnoEncCntn */
//					returnYe161020Dto.setHshrClCd(MSFSharedUtils.allowNulls(tempMap.get("hshrClCd")));   			 			/** column 세대주여부 : hshrClCd */
//					returnYe161020Dto.setRsplNtnInfrNm(MSFSharedUtils.allowNulls(tempMap.get("rsplNtnInfrNm")));    			/** column 국적 : rsplNtnInfrNm */
//					returnYe161020Dto.setRsplNtnInfrCd(MSFSharedUtils.allowNulls(tempMap.get("rsplNtnInfrCd")));    			/** column 국적코드 : rsplNtnInfrCd */
//					returnYe161020Dto.setRsplNtnInfrItem(MSFSharedUtils.allowNulls(tempMap.get("rsplNtnInfrItem"))); 
//					returnYe161020Dto.setDtyStrtDt(MSFSharedUtils.allowNulls(tempMap.get("dtyStrtDt")));    					/** column 근무기간시작일자 : dtyStrtDt */
//					returnYe161020Dto.setDtyEndDt(MSFSharedUtils.allowNulls(tempMap.get("dtyEndDt")));    						/** column 근무기간종료일자 : dtyEndDt */
//					returnYe161020Dto.setReStrtDt(MSFSharedUtils.allowNulls(tempMap.get("reStrtDt")));    						/** column 감면기간시작일자 : reStrtDt */
//					returnYe161020Dto.setReEndDt(MSFSharedUtils.allowNulls(tempMap.get("reEndDt")));    						/** column 감면기간종료일자 : reEndDt */
//					returnYe161020Dto.setRsdtClCd(MSFSharedUtils.allowNulls(tempMap.get("rsdtClCd")));    						/** column 거주구분 : rsdtClCd */
//					returnYe161020Dto.setRsplNtnNm(MSFSharedUtils.allowNulls(tempMap.get("rsplNtnNm")));    					/** column 거주지국명 : rsplNtnNm */
//					returnYe161020Dto.setRsplNtnCd(MSFSharedUtils.allowNulls(tempMap.get("rsplNtnCd")));    					/** column 거주지코드 : rsplNtnCd */
//					returnYe161020Dto.setRsplNtnItem(MSFSharedUtils.allowNulls(tempMap.get("rsplNtnItem"))); 
//					returnYe161020Dto.setInctxWhtxTxamtMetnCd(MSFSharedUtils.allowNulls(tempMap.get("inctxWhtxTxamtMetnCd")));	/** column 소득세원천징수세액조정구분코드 : inctxWhtxTxamtMetnCd */
//					returnYe161020Dto.setInpmYn(MSFSharedUtils.allowNulls(tempMap.get("inpmYn")));    							/** column 분납신청여부 : inpmYn */
					returnYe161020Dto.setAddrMrct(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("addrMrct"), "0"))); 
					returnYe161020Dto.setAddrMccr(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("addrMccr"), "0")));
					returnYe161020Dto.setPrifChngYn(MSFSharedUtils.allowNulls(tempMap.get("prifChngYn")));    					/** column 인적공제항목변동여부 : prifChngYn */
//					returnYe161020Dto.set표준세액공제적용여부(MSFSharedUtils.allowNulls(tempMap.get("표준세액공제적용여부")));		/** column 표준세액공제적용여부 : 표준세액공제적용여부 */
					
				}
			}

		} catch (Exception ex) {
			
			ex.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
			
		}
		
		/** 로그반영
		 * CRUDSBLO 
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass,"S");

		return returnYe161020Dto;

	}


	
	/** 연금보험료공제 tab 조회 **/
	public Ye161055DTO getYeta5300TabItem04ToYe161055Data(Ye161055DTO ye161055Dto) throws MSFException {
		

		Ye161055Srh_2020_VO ye161055SrhVo = new Ye161055Srh_2020_VO();
		MSFSysm0100BM sessionUser;

		String method = calledClass + ".getYeta5300TabItem04ToYe161055Data";

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(ye161055DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
							.getSession().getServletContext());
			ye161055DAO = (Ye161055_2020_DAO) wac.getBean("Ye161055_2020_DAO");
		}
		
		

		/** 조건절 */
		ye161055SrhVo.setDpobCd(ye161055Dto.getDpobCd());   		/** column 사업장코드 : dpobCd */
		ye161055SrhVo.setYrtxBlggYr(ye161055Dto.getYrtxBlggYr());	/** column 귀속연도 : yrtxBlggYr */
		ye161055SrhVo.setClutSeptCd(ye161055Dto.getClutSeptCd());	/** column 연말정산구분코드 : clutSeptCd */
		ye161055SrhVo.setSystemkey(ye161055Dto.getSystemkey());    	/** column SYSTEMKEY : systemkey */

		Ye161055DTO returnYe161055Dto = new Ye161055DTO();
		
		List egovResultDataList = new ArrayList();

		try {
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
			egovResultDataList = ye161055DAO.selectYeta5300ToYe161055List(ye161055SrhVo);
			
			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";

			if (egovResultDataList != null && egovResultDataList.size() > 0) {
				
				for (int i = 0; i < egovResultDataList.size(); i++) {

					Map tempMap = (Map) egovResultDataList.get(i);
					
					returnYe161055Dto.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    														/** column 사업장코드 : dpobCd */
					returnYe161055Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(tempMap.get("yrtxBlggYr")));    												/** column 귀속연도 : yrtxBlggYr */
					returnYe161055Dto.setClutSeptCd(MSFSharedUtils.allowNulls(tempMap.get("clutSeptCd")));    												/** column 연말정산구분코드 : clutSeptCd */
					returnYe161055Dto.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));    												/** column SYSTEMKEY : systemkey */
					returnYe161055Dto.setPiclEmplDivCd(MSFSharedUtils.allowNulls(tempMap.get("piclEmplDivCd")));    										/** column 주종근무지구분코드 : piclEmplDivCd */
					
					returnYe161055Dto.setNpHthrWaInfeeAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("npHthrWaInfeeAmt"), "0")));    			/** column 국민연금보험료_종근무지보험료금액 : npHthrWaInfeeAmt */
					returnYe161055Dto.setNpHthrWaInfeeDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("npHthrWaInfeeDdcAmt"), "0")));    		/** column 국민연금보험료_종근무지보험료공제액 : npHthrWaInfeeDdcAmt */
					returnYe161055Dto.setNpHthrMcurWkarInfeeAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("npHthrMcurWkarInfeeAmt"), "0")));	/** column 국민연금보험료_주근무지보험료금액 : npHthrMcurWkarInfeeAmt */
					returnYe161055Dto.setNpHthrMcurWkarDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("npHthrMcurWkarDdcAmt"), "0")));    	/** column 국민연금보험료_주근무지보험료공제액 : npHthrMcurWkarDdcAmt */
					returnYe161055Dto.setNpHthrAreaInfeeAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("npHthrAreaInfeeAmt"), "0")));    		/** column 국민연금보험료_지역보험료금액 : npHthrAreaInfeeAmt */
					returnYe161055Dto.setNpHthrAreaDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("npHthrAreaDdcAmt"), "0")));    			/** column 국민연금보험료-지역보험료공제액 : npHthrAreaDdcAmt */
					returnYe161055Dto.setHthrPblcPnsnInfeeAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("hthrPblcPnsnInfeeAmt"), "0")));    	/** column 국민연금보험료외_공적연금종근무지보험료금액 : hthrPblcPnsnInfeeAmt */
					returnYe161055Dto.setHthrPblcPnsnInfeeDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("hthrPblcPnsnInfeeDdcAmt"), "0")));	/** column 국민연금보험료외_공적연금종근무지보험료공제액 : hthrPblcPnsnInfeeDdcAmt */
					returnYe161055Dto.setMcurPblcPnsnInfeeAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mcurPblcPnsnInfeeAmt"), "0")));    	/** column 국민연금보험료외_공적연금주근무지보험료금액 : mcurPblcPnsnInfeeAmt */
					returnYe161055Dto.setMcurPblcPnsnInfeeDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mcurPblcPnsnInfeeDdcAmt"), "0")));	/** column 국민연금보험료외_공적연금주근무지보험료공제액 : mcurPblcPnsnInfeeDdcAmt */
					returnYe161055Dto.setPnsnInfeeUseAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("pnsnInfeeUseAmtSum"), "0")));    		/** column 연금보험료보험료합계 : pnsnInfeeUseAmtSum */
					returnYe161055Dto.setPnsnInfeeDdcAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("pnsnInfeeDdcAmtSum"), "0")));    		/** column 연금보험료공제액합계 : pnsnInfeeDdcAmtSum */
					
					
					// 주근무지
					returnYe161055Dto.setNatPennPrmmSum_01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("natPennPrmmSum01"), "0")));    			/** column 국민연금보험료금액 : natPennPrmmSum */
					returnYe161055Dto.setNatPennAraPrmmSum_01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("natPennAraPrmmSum01"), "0")));   		/** column 국민연금지역보험료금액 : natPennAraPrmmSum */
					returnYe161055Dto.setNatPennDducSum_01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("natPennDducSum01"), "0")));    			/** column 국민연금보험료공제금액 : natPennDducSum */
					returnYe161055Dto.setPuoferAnty_01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("puoferAnty01"), "0")));    					/** column 공적연금_공무원연금금액 : puoferAnty */
					returnYe161055Dto.setPuoferAntyDducSum_01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("puoferAntyDducSum01"), "0")));		/** column 공적연금_공무원연금공제금액 : puoferAntyDducSum */
					returnYe161055Dto.setMltymAnty_01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mltymAnty01"), "0")));    					/** column 공적연금_군인연금금액 : mltymAnty */
					returnYe161055Dto.setMltymAntyDducSum_01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mltymAntyDducSum01"), "0")));    		/** column 공적연금_군인연금공제금액 : mltymAntyDducSum */
					returnYe161055Dto.setPrtafirSchlFalymmAnty_01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("prtafirSchlFalymmAnty01"), "0")));/** column 공적연금_사립학교교직원연금금액 : prtafirSchlFalymmAnty */
					returnYe161055Dto.setPrtafirSchlDducSum_01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("prtafirSchlDducSum01"), "0")));    	/** column 공적연금_사립학교직원연금공제금액 : prtafirSchlDducSum */
					returnYe161055Dto.setSpildtnPstoficAnty_01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("spildtnPstoficAnty01"), "0")));    	/** column 공적연금_별정우체국연금금액 : spildtnPstoficAnty */
					returnYe161055Dto.setSpildtnPstoficDducSum_01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("spildtnPstoficDducSum01"), "0")));/** column 공적연금_별정우체국연금공제금액 : spildtnPstoficDducSum */
					
					// 종근무지
					returnYe161055Dto.setNatPennPrmmSum_02(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("natPennPrmmSum02"), "0")));    			/** column 국민연금보험료금액 : natPennPrmmSum */
					returnYe161055Dto.setNatPennAraPrmmSum_02(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("natPennAraPrmmSum02"), "0")));   		/** column 국민연금지역보험료금액 : natPennAraPrmmSum */
					returnYe161055Dto.setNatPennDducSum_02(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("natPennDducSum02"), "0")));    			/** column 국민연금보험료공제금액 : natPennDducSum */
					returnYe161055Dto.setPuoferAnty_02(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("puoferAnty02"), "0")));    					/** column 공적연금_공무원연금금액 : puoferAnty */
					returnYe161055Dto.setPuoferAntyDducSum_02(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("puoferAntyDducSum02"), "0")));		/** column 공적연금_공무원연금공제금액 : puoferAntyDducSum */
					returnYe161055Dto.setMltymAnty_02(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mltymAnty02"), "0")));    					/** column 공적연금_군인연금금액 : mltymAnty */
					returnYe161055Dto.setMltymAntyDducSum_02(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mltymAntyDducSum02"), "0")));    		/** column 공적연금_군인연금공제금액 : mltymAntyDducSum */
					returnYe161055Dto.setPrtafirSchlFalymmAnty_02(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("prtafirSchlFalymmAnty02"), "0")));/** column 공적연금_사립학교교직원연금금액 : prtafirSchlFalymmAnty */
					returnYe161055Dto.setPrtafirSchlDducSum_02(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("prtafirSchlDducSum02"), "0")));    	/** column 공적연금_사립학교직원연금공제금액 : prtafirSchlDducSum */
					returnYe161055Dto.setSpildtnPstoficAnty_02(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("spildtnPstoficAnty02"), "0")));    	/** column 공적연금_별정우체국연금금액 : spildtnPstoficAnty */
					returnYe161055Dto.setSpildtnPstoficDducSum_02(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("spildtnPstoficDducSum02"), "0")));/** column 공적연금_별정우체국연금공제금액 : spildtnPstoficDducSum */
					
				}
			}

		} catch (Exception ex) {
			
			ex.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
			
		}
		
		/** 로그반영
		 * CRUDSBLO 
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass,"S");

		return returnYe161055Dto;

	}
			
	
	/** 연금보험료공제 tab 수정 **/   
	@Override
	public int saveYeta5300ToYe161055tabItem04(Ye161055DTO ye161055Dto)throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		String method = calledClass + ".saveYeta5300ToYe161055tabItem04";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";
		
		Ye161055_2020_VO ye161055Vo = new Ye161055_2020_VO();
		Ye161050_2020_VO ye161050Vo = new Ye161050_2020_VO();
		
		InfcPkgYe161010_2020_VO infcPkgYe161010Vo = new InfcPkgYe161010_2020_VO(); 
		Yeta5300ListenerAdapter  yeta5300ListenerAdt = new Yeta5300ListenerAdapter();
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		try{
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
			
			ye161055Vo = new Ye161055_2020_VO();
			
			ye161055Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161055Dto.getDpobCd()));    														/** column 사업장코드 : dpobCd */
			ye161055Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161055Dto.getYrtxBlggYr()));    												/** column 귀속연도 : yrtxBlggYr */
			ye161055Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161055Dto.getClutSeptCd()));    												/** column 연말정산구분코드 : clutSeptCd */
			ye161055Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161055Dto.getSystemkey()));    													/** column SYSTEMKEY : systemkey */
			ye161055Vo.setPiclEmplDivCd(MSFSharedUtils.allowNulls(ye161055Dto.getPiclEmplDivCd()));												/** column 주종근무지구분코드 : piclEmplDivCd */
			
			
			ye161055Vo.setNatPennPrmmSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161055Dto.getNatPennPrmmSum_01(), "0")));    				/** column 국민연금보험료금액 : natPennPrmmSum */
			ye161055Vo.setNatPennAraPrmmSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161055Dto.getNatPennAraPrmmSum(), "0")));    			/** column 국민연금지역보험료금액 : natPennAraPrmmSum */
			ye161055Vo.setNatPennDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161055Dto.getNatPennDducSum_01(), "0")));    				/** column 국민연금보험료공제금액 : natPennDducSum */
			ye161055Vo.setPuoferAnty(new BigDecimal(MSFSharedUtils.defaultNulls(ye161055Dto.getPuoferAnty_01(), "0")));    						/** column 공적연금_공무원연금금액 : puoferAnty */
			ye161055Vo.setPuoferAntyDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161055Dto.getPuoferAntyDducSum_01(), "0")));    		/** column 공적연금_공무원연금공제금액 : puoferAntyDducSum */
			ye161055Vo.setMltymAnty(new BigDecimal(MSFSharedUtils.defaultNulls(ye161055Dto.getMltymAnty_01(), "0")));    						/** column 공적연금_군인연금금액 : mltymAnty */
			ye161055Vo.setMltymAntyDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161055Dto.getMltymAntyDducSum_01(), "0")));    			/** column 공적연금_군인연금공제금액 : mltymAntyDducSum */
			ye161055Vo.setPrtafirSchlFalymmAnty(new BigDecimal(MSFSharedUtils.defaultNulls(ye161055Dto.getPrtafirSchlFalymmAnty_01(), "0")));	/** column 공적연금_사립학교교직원연금금액 : prtafirSchlFalymmAnty */
			ye161055Vo.setPrtafirSchlDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161055Dto.getPrtafirSchlDducSum_01(), "0")));    		/** column 공적연금_사립학교직원연금공제금액 : prtafirSchlDducSum */
			ye161055Vo.setSpildtnPstoficAnty(new BigDecimal(MSFSharedUtils.defaultNulls(ye161055Dto.getSpildtnPstoficAnty_01(), "0")));    		/** column 공적연금_별정우체국연금금액 : spildtnPstoficAnty */
			ye161055Vo.setSpildtnPstoficDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161055Dto.getSpildtnPstoficDducSum_01(), "0")));	/** column 공적연금_별정우체국연금공제금액 : spildtnPstoficDducSum */
		
			ye161055Vo.setIsmt(sessionUser.getUsrId());    																						/** column 수정자 : ismt */
			ye161055Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    												/** column 수정주소 : revnAddr */
			
			
			
			ye161050Vo = new Ye161050_2020_VO();
			
			ye161050Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161055Dto.getDpobCd()));    														/** column 사업장코드 : dpobCd */
			ye161050Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161055Dto.getYrtxBlggYr()));    												/** column 귀속연도 : yrtxBlggYr */
			ye161050Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161055Dto.getClutSeptCd()));    												/** column 연말정산구분코드 : clutSeptCd */
			ye161050Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161055Dto.getSystemkey()));    													/** column SYSTEMKEY : systemkey */
			
			ye161050Vo.setNpHthrWaInfeeAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161055Dto.getNpHthrWaInfeeAmt(), "0")));    			/** column 국민연금보험료_종근무지보험료금액 : npHthrWaInfeeAmt */
			ye161050Vo.setNpHthrWaInfeeDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161055Dto.getNpHthrWaInfeeDdcAmt(), "0")));    		/** column 국민연금보험료_종근무지보험료공제액 : npHthrWaInfeeDdcAmt */
			ye161050Vo.setNpHthrMcurWkarInfeeAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161055Dto.getNpHthrMcurWkarInfeeAmt(), "0")));    /** column 국민연금보험료_주근무지보험료금액 : npHthrMcurWkarInfeeAmt */
			ye161050Vo.setNpHthrMcurWkarDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161055Dto.getNpHthrMcurWkarDdcAmt(), "0")));    	/** column 국민연금보험료_주근무지보험료공제액 : npHthrMcurWkarDdcAmt */
			ye161050Vo.setNpHthrAreaInfeeAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161055Dto.getNpHthrAreaInfeeAmt(), "0")));    		/** column 국민연금보험료_지역보험료금액 : npHthrAreaInfeeAmt */
			ye161050Vo.setNpHthrAreaDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161055Dto.getNpHthrAreaDdcAmt(), "0")));    			/** column 국민연금보험료-지역보험료공제액 : npHthrAreaDdcAmt */
		
			ye161050Vo.setIsmt(sessionUser.getUsrId());    																						/** column 수정자 : ismt */
			ye161050Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    												/** column 수정주소 : revnAddr */
		
		
			
			ye161055DAO.updateYeta5300ToYe161055(ye161055Vo);
			ye161050DAO.updateYeta5300ToYe161050(ye161050Vo);
			
			BeanUtils.copyProperties(infcPkgYe161010Vo , ye161050Vo);  
			yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE161050");
			
			result = 1;
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
		return result;
	}
	
	
	
	
	/** 특별소득공제 tab 조회 **/
	public Ye161060DTO getYeta5300TabItem05ToYe161060Data(Ye161060DTO ye161060Dto) throws MSFException {
		

		Ye161060Srh_2020_VO ye161060SrhVo = new Ye161060Srh_2020_VO();
		MSFSysm0100BM sessionUser;

		String method = calledClass + ".getYeta5300TabItem05ToYe161060Data";

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(ye161060DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
							.getSession().getServletContext());
			ye161060DAO = (Ye161060_2020_DAO) wac.getBean("Ye161060_2020_DAO");
		}
		
		

		/** 조건절 */
		ye161060SrhVo.setDpobCd(ye161060Dto.getDpobCd());   		/** column 사업장코드 : dpobCd */
		ye161060SrhVo.setYrtxBlggYr(ye161060Dto.getYrtxBlggYr());	/** column 귀속연도 : yrtxBlggYr */
		ye161060SrhVo.setClutSeptCd(ye161060Dto.getClutSeptCd());	/** column 연말정산구분코드 : clutSeptCd */
		ye161060SrhVo.setSystemkey(ye161060Dto.getSystemkey());    	/** column SYSTEMKEY : systemkey */

		Ye161060DTO returnYe161060Dto = new Ye161060DTO();
		
		List egovResultDataList = new ArrayList();

		try {
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
			egovResultDataList = ye161060DAO.selectYeta5300ToYe161060tabItem05List(ye161060SrhVo);
			
			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";

			if (egovResultDataList != null && egovResultDataList.size() > 0) {
				
				for (int i = 0; i < egovResultDataList.size(); i++) {

					Map tempMap = (Map) egovResultDataList.get(i);
					
					returnYe161060Dto.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    															/** column 사업장코드 : dpobCd */
					returnYe161060Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(tempMap.get("yrtxBlggYr")));    													/** column 귀속연도 : yrtxBlggYr */
					returnYe161060Dto.setClutSeptCd(MSFSharedUtils.allowNulls(tempMap.get("clutSeptCd")));    													/** column 연말정산구분코드 : clutSeptCd */
					returnYe161060Dto.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));    													/** column SYSTEMKEY : systemkey */
					
					returnYe161060Dto.setHthrHifeAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("hthrHifeAmt"), "0")));    							/** column 국민건강보험_종근무지보험료금액 : hthrHifeAmt */
					returnYe161060Dto.setHthrHifeDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("hthrHifeDdcAmt"), "0")));    					/** column 국민건강보험_종근무지보험료공제액 : hthrHifeDdcAmt */
					returnYe161060Dto.setMcurHifeAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mcurHifeAmt"), "0")));    							/** column 국민건강보험_주근무지보험료금액 : mcurHifeAmt */
					returnYe161060Dto.setMcurHifeDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mcurHifeDdcAmt"), "0")));    					/** column 국민건강보험_주근무지보험료공제액 : mcurHifeDdcAmt */
					returnYe161060Dto.setMcurHifeAreaAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mcurHifeAreaAmt"), "0")));    					/** column 국민건강보험_지역보험료금액 : mcurHifeAreaAmt */
					returnYe161060Dto.setMcurHifeAreaDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mcurHifeAreaDdcAmt"), "0")));    			/** column 국민건강보험_지역보험료공제금액 : mcurHifeAreaDdcAmt */
					returnYe161060Dto.setHthrUiAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("hthrUiAmt"), "0")));   			 					/** column 고용보험_종근무지보험료금액 : hthrUiAmt */
					returnYe161060Dto.setHthrUiDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("hthrUiDdcAmt"), "0")));    						/** column 고용보험_종근무지보험료공제액 : hthrUiDdcAmt */
					returnYe161060Dto.setMcurUiAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mcurUiAmt"), "0")));    								/** column 고용보험_주근무지보험료금액 : mcurUiAmt */
					returnYe161060Dto.setMcurUiDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mcurUiDdcAmt"), "0")));    						/** column 고용보험_주근무지보험료공제액 : mcurUiDdcAmt */
					returnYe161060Dto.setInfeeUseAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("infeeUseAmtSum"), "0")));    					/** column 건강고용_보험료보험료합계 : infeeUseAmtSum */
					returnYe161060Dto.setInfeeDdcAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("infeeDdcAmtSum"), "0")));    					/** column 건강고용_보험료공제액합계 : infeeDdcAmtSum */
					
					returnYe161060Dto.setBrwLnpbSrmAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("brwLnpbSrmAmt"), "0")));    						/** column 주택임차차입금대출기관차입원리금상환액 : brwLnpbSrmAmt */
					returnYe161060Dto.setBrwLnpbSrmDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("brwLnpbSrmDdcAmt"), "0")));   	 			/** column 주택임차차입금대출기관차입공제액 : brwLnpbSrmDdcAmt */
					returnYe161060Dto.setRsdtLnpbSrmAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("rsdtLnpbSrmAmt"), "0")));    					/** column 주택임차차입금거주자차입원리금상환액 : rsdtLnpbSrmAmt */
					returnYe161060Dto.setRsdtLnpbSrmDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("rsdtLnpbSrmDdcAmt"), "0")));   		 		/** column 주택임차차입금거주자차입공제액 : rsdtLnpbSrmDdcAmt */
					returnYe161060Dto.setLthYr15BlwItrAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lthYr15BlwItrAmt"), "0")));    				/** column 장기주택수정차입금2011년이전차입분중15년미만이자상환액 : lthYr15BlwItrAmt */
					returnYe161060Dto.setLthYr15BlwDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lthYr15BlwDdcAmt"), "0")));    				/** column 장기주택저당차입금2011년이전차입분15년미만공제액 : lthYr15BlwDdcAmt */
					returnYe161060Dto.setLthYr29ItrAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lthYr29ItrAmt"), "0")));    						/** column 장기주택저당차입금2011년이전차입분중15_29년이자상환액 : lthYr29ItrAmt */
					returnYe161060Dto.setLthYr29DdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lthYr29DdcAmt"), "0")));    						/** column 장기주택저당차입금2011년이전차입분15_29년공제액 : lthYr29DdcAmt */
					returnYe161060Dto.setLthY30OverItrAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lthY30OverItrAmt"), "0")));    				/** column 장기주택저당차입금2011이전차입분중30년이상이자상환액 : lthY30OverItrAmt */
					returnYe161060Dto.setLthY30OverDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lthY30OverDdcAmt"), "0")));    				/** column 장기주택저당차입금2011이전차입분20년이상공제액 : lthY30OverDdcAmt */
					returnYe161060Dto.setLthYr2012AfthY15Amt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lthYr2012AfthY15Amt"), "0")));    			/** column 장기주택저당차입금2012이후고정금리이거나비거치상환대출이자상환액 : lthYr2012AfthY15Amt */
					returnYe161060Dto.setLthYr2012AfthY15DdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lthYr2012AfthY15DdcAmt"), "0")));    	/** column 장기주택저당차입금2012이후고정금리이거나비거치산환대출공제액 : lthYr2012AfthY15DdcAmt */
					returnYe161060Dto.setLthYr2012EtcBrwItrAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lthYr2012EtcBrwItrAmt"), "0")));    		/** column 장기주택저당차입금2012이후기타대출이자상환액 : lthYr2012EtcBrwItrAmt */
					returnYe161060Dto.setLthYr2012EtcBrwDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lthYr2012EtcBrwDdcAmt"), "0")));    		/** column 장기주택저당차입금2012이후기타대출공제액 : lthYr2012EtcBrwDdcAmt */
					returnYe161060Dto.setLthYr2015AfthFxnIrItrAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lthYr2015AfthFxnIrItrAmt"), "0"))); 	/** column 장기주택저당차입금2015이후_15이상_고정금리이면서비거치상환대출이자상환액 : lthYr2015AfthFxnIrItrAmt */
					returnYe161060Dto.setLthYr2015AfthFxnIrDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lthYr2015AfthFxnIrDdcAmt"), "0")));	/** column 장기주택저당차입금2015이후_15이상_고정금리이면서비거치상환대출공제액 : lthYr2015AfthFxnIrDdcAmt */
					returnYe161060Dto.setLthYr2015AfthY15Amt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lthYr2015AfthY15Amt"), "0")));    			/** column 장기주택저당차입금2015이후_15이상_고정금리이거나비거치상환대출이자상환액 : lthYr2015AfthY15Amt */
					returnYe161060Dto.setLthYr2015AfthY15DdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lthYr2015AfthY15DdcAmt"), "0")));    	/** column 장기주택저당차입금2015이후_15이상_고정금리이거나비거치상환대출공제액 : lthYr2015AfthY15DdcAmt */
					returnYe161060Dto.setLthYr2015AfthEtcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lthYr2015AfthEtcAmt"), "0")));    			/** column 장기주택저당차입금2015이후_15이상_기타대출이자상환액 : lthYr2015AfthEtcAmt */
					returnYe161060Dto.setLthYr2015AfthEtcDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lthYr2015AfthEtcDdcAmt"), "0")));    	/** column 장기주택저당차입금2015이후_15이상_기타대출공제액 : lthYr2015AfthEtcDdcAmt */
					returnYe161060Dto.setLthYr2015AfthYr15Amt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lthYr2015AfthYr15Amt"), "0")));    		/** column 장기주택저당차입금_2015이후_10_15고정금리이거나비거치상환대출이자상환액 : lthYr2015AfthYr15Amt */
					returnYe161060Dto.setLthYr2015AfthYr15DdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lthYr2015AfthYr15DdcAmt"), "0")));    	/** column 장기주택저당차입금_2015이후_10_15고정금리이거나비거치상환대출공제액 : lthYr2015AfthYr15DdcAmt */
					returnYe161060Dto.setHsngFndsDdcAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("hsngFndsDdcAmtSum"), "0")));    				/** column 주택자금공제액_합계 : hsngFndsDdcAmtSum */
					
					returnYe161060Dto.setConbLglUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbLglUseAmt"), "0")));    						/** column 기부금이월분_법정기부금기부금납입액 : conbLglUseAmt */
					returnYe161060Dto.setConbLglDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbLglDdcAmt"), "0")));    						/** column 기부금이월분_법정기부금기부금공제액 : conbLglDdcAmt */
					returnYe161060Dto.setConbReliOrgOthUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbReliOrgOthUseAmt"), "0")));    		/** column 기부금이월분_지정기부금_종교단체외납입액 : conbReliOrgOthUseAmt */
					returnYe161060Dto.setConbReliOrgOthDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbReliOrgOthDdcAmt"), "0")));    		/** column 기부금이월분_지정기부금_종교단체외공제액 : conbReliOrgOthDdcAmt */
					returnYe161060Dto.setConbReliOrgUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbReliOrgUseAmt"), "0")));   				/** column 기부금이월분_지정기부금_종교단체납입액 : conbReliOrgUseAmt */
					returnYe161060Dto.setConbReliOrgDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbReliOrgDdcAmt"), "0")));    				/** column 기부금이월분_지정기부금_종교단체공제액 : conbReliOrgDdcAmt */
					returnYe161060Dto.setConbUseAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbUseAmtSum"), "0")));    						/** column 기부금이월분_지정기부금납입분합계 : conbUseAmtSum */
					returnYe161060Dto.setConbDdcAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbDdcAmtSum"), "0")));    						/** column 기부금이월분_지정기부금공제합계 : conbDdcAmtSum */
				
				}
			}

		} catch (Exception ex) {
			
			ex.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
			
		}
		
		/** 로그반영
		 * CRUDSBLO 
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass,"S");

		return returnYe161060Dto;

	}
		
	
	/** 특별소득공제tab 보험료 tab 수정 **/ 
	@Override
	public int saveYeta5300ToYe161060tabItem05_1(Ye161060DTO ye161060Dto)throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		String method = calledClass + ".saveYeta5300ToYe161060tabItem05_1";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";
		
		InfcPkgYe161010_2020_VO infcPkgYe161010Vo = new InfcPkgYe161010_2020_VO(); 
		Yeta5300ListenerAdapter  yeta5300ListenerAdt = new Yeta5300ListenerAdapter();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		Ye161060_2020_VO ye161060Vo = new Ye161060_2020_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		ye161060Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161060Dto.getDpobCd()));    											/** column 사업장코드 : dpobCd */
		ye161060Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161060Dto.getYrtxBlggYr()));   	 								/** column 귀속연도 : yrtxBlggYr */
		ye161060Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161060Dto.getClutSeptCd()));    									/** column 연말정산구분코드 : clutSeptCd */
		ye161060Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161060Dto.getSystemkey()));    										/** column SYSTEMKEY : systemkey */
		
		ye161060Vo.setHthrHifeAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getHthrHifeAmt(), "0")));    			/** column 국민건강보험_종근무지보험료금액 : hthrHifeAmt */
		ye161060Vo.setHthrHifeDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getHthrHifeDdcAmt(), "0")));    	/** column 국민건강보험_종근무지보험료공제액 : hthrHifeDdcAmt */
		ye161060Vo.setMcurHifeAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getMcurHifeAmt(), "0")));    			/** column 국민건강보험_주근무지보험료금액 : mcurHifeAmt */
		ye161060Vo.setMcurHifeDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getMcurHifeDdcAmt(), "0")));    	/** column 국민건강보험_주근무지보험료공제액 : mcurHifeDdcAmt */
		ye161060Vo.setMcurHifeAreaAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getMcurHifeAreaAmt(), "0")));    	/** column 국민건강보험_지역보험료금액 : mcurHifeAreaAmt */
		ye161060Vo.setMcurHifeAreaDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getMcurHifeAreaDdcAmt(), "0")));/** column 국민건강보험_지역보험료공제금액 : mcurHifeAreaDdcAmt */
		ye161060Vo.setHthrUiAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getHthrUiAmt(), "0")));    				/** column 고용보험_종근무지보험료금액 : hthrUiAmt */
		ye161060Vo.setHthrUiDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getHthrUiDdcAmt(), "0")));    		/** column 고용보험_종근무지보험료공제액 : hthrUiDdcAmt */
		ye161060Vo.setMcurUiAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getMcurUiAmt(), "0")));    				/** column 고용보험_주근무지보험료금액 : mcurUiAmt */
		ye161060Vo.setMcurUiDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getMcurUiDdcAmt(), "0")));    		/** column 고용보험_주근무지보험료공제액 : mcurUiDdcAmt */
		ye161060Vo.setInfeeUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getInfeeUseAmtSum(), "0")));    	/** column 건강고용_보험료보험료합계 : infeeUseAmtSum */
		ye161060Vo.setInfeeDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getInfeeDdcAmtSum(), "0")));    	/** column 건강고용_보험료공제액합계 : infeeDdcAmtSum */
		
		ye161060Vo.setIsmt(sessionUser.getUsrId());    																			/** column 수정자 : ismt */
		ye161060Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    									/** column 수정주소 : revnAddr */
		
		
		try{
			
			ye161060DAO.updateYeta5300ToYe161060tabItem05_1(ye161060Vo);
			
			BeanUtils.copyProperties(infcPkgYe161010Vo , ye161060Vo);  
			yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE161060");
			
			result = 1;
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
		return result;
	}	

	
	/** 특별소득공제tab 주택자금 tab 수정 **/ 
	@Override
	public int saveYeta5300ToYe161060tabItem05_2(Ye161060DTO ye161060Dto)throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		String method = calledClass + ".saveYeta5300ToYe161060tabItem05_2";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";
		
		InfcPkgYe161010_2020_VO infcPkgYe161010Vo = new InfcPkgYe161010_2020_VO(); 
		Yeta5300ListenerAdapter  yeta5300ListenerAdt = new Yeta5300ListenerAdapter();
		
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		Ye161060_2020_VO ye161060Vo = new Ye161060_2020_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		ye161060Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161060Dto.getDpobCd()));    														/** column 사업장코드 : dpobCd */
		ye161060Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161060Dto.getYrtxBlggYr()));   	 											/** column 귀속연도 : yrtxBlggYr */
		ye161060Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161060Dto.getClutSeptCd()));    												/** column 연말정산구분코드 : clutSeptCd */
		ye161060Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161060Dto.getSystemkey()));    													/** column SYSTEMKEY : systemkey */
	
		ye161060Vo.setBrwLnpbSrmAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getBrwLnpbSrmAmt(), "0")));    					/** column 주택임차차입금대출기관차입원리금상환액 : brwLnpbSrmAmt */
		ye161060Vo.setBrwLnpbSrmDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getBrwLnpbSrmDdcAmt(), "0")));    			/** column 주택임차차입금대출기관차입공제액 : brwLnpbSrmDdcAmt */
		ye161060Vo.setRsdtLnpbSrmAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getRsdtLnpbSrmAmt(), "0")));    				/** column 주택임차차입금거주자차입원리금상환액 : rsdtLnpbSrmAmt */
		ye161060Vo.setRsdtLnpbSrmDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getRsdtLnpbSrmDdcAmt(), "0")));    			/** column 주택임차차입금거주자차입공제액 : rsdtLnpbSrmDdcAmt */
		ye161060Vo.setLthYr15BlwItrAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getLthYr15BlwItrAmt(), "0")));    			/** column 장기주택수정차입금2011년이전차입분중15년미만이자상환액 : lthYr15BlwItrAmt */
		ye161060Vo.setLthYr15BlwDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getLthYr15BlwDdcAmt(), "0")));    			/** column 장기주택저당차입금2011년이전차입분15년미만공제액 : lthYr15BlwDdcAmt */
		ye161060Vo.setLthYr29ItrAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getLthYr29ItrAmt(), "0")));    					/** column 장기주택저당차입금2011년이전차입분중15_29년이자상환액 : lthYr29ItrAmt */
		ye161060Vo.setLthYr29DdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getLthYr29DdcAmt(), "0")));    					/** column 장기주택저당차입금2011년이전차입분15_29년공제액 : lthYr29DdcAmt */
		ye161060Vo.setLthY30OverItrAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getLthY30OverItrAmt(), "0")));    			/** column 장기주택저당차입금2011이전차입분중30년이상이자상환액 : lthY30OverItrAmt */
		ye161060Vo.setLthY30OverDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getLthY30OverDdcAmt(), "0")));    			/** column 장기주택저당차입금2011이전차입분20년이상공제액 : lthY30OverDdcAmt */
		ye161060Vo.setLthYr2012AfthY15Amt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getLthYr2012AfthY15Amt(), "0")));    		/** column 장기주택저당차입금2012이후고정금리이거나비거치상환대출이자상환액 : lthYr2012AfthY15Amt */
		ye161060Vo.setLthYr2012AfthY15DdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getLthYr2012AfthY15DdcAmt(), "0")));    /** column 장기주택저당차입금2012이후고정금리이거나비거치산환대출공제액 : lthYr2012AfthY15DdcAmt */
		ye161060Vo.setLthYr2012EtcBrwItrAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getLthYr2012EtcBrwItrAmt(), "0")));    	/** column 장기주택저당차입금2012이후기타대출이자상환액 : lthYr2012EtcBrwItrAmt */
		ye161060Vo.setLthYr2012EtcBrwDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getLthYr2012EtcBrwDdcAmt(), "0")));    	/** column 장기주택저당차입금2012이후기타대출공제액 : lthYr2012EtcBrwDdcAmt */
		ye161060Vo.setLthYr2015AfthFxnIrItrAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getLthYr2015AfthFxnIrItrAmt(), "0")));/** column 장기주택저당차입금2015이후_15이상_고정금리이면서비거치상환대출이자상환액 : lthYr2015AfthFxnIrItrAmt */
		ye161060Vo.setLthYr2015AfthFxnIrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getLthYr2015AfthFxnIrDdcAmt(), "0")));/** column 장기주택저당차입금2015이후_15이상_고정금리이면서비거치상환대출공제액 : lthYr2015AfthFxnIrDdcAmt */
		ye161060Vo.setLthYr2015AfthY15Amt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getLthYr2015AfthY15Amt(), "0")));    		/** column 장기주택저당차입금2015이후_15이상_고정금리이거나비거치상환대출이자상환액 : lthYr2015AfthY15Amt */
		ye161060Vo.setLthYr2015AfthY15DdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getLthYr2015AfthY15DdcAmt(), "0")));    /** column 장기주택저당차입금2015이후_15이상_고정금리이거나비거치상환대출공제액 : lthYr2015AfthY15DdcAmt */
		ye161060Vo.setLthYr2015AfthEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getLthYr2015AfthEtcAmt(), "0")));    		/** column 장기주택저당차입금2015이후_15이상_기타대출이자상환액 : lthYr2015AfthEtcAmt */
		ye161060Vo.setLthYr2015AfthEtcDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getLthYr2015AfthEtcDdcAmt(), "0")));    /** column 장기주택저당차입금2015이후_15이상_기타대출공제액 : lthYr2015AfthEtcDdcAmt */
		ye161060Vo.setLthYr2015AfthYr15Amt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getLthYr2015AfthYr15Amt(), "0")));    	/** column 장기주택저당차입금_2015이후_10_15고정금리이거나비거치상환대출이자상환액 : lthYr2015AfthYr15Amt */
		ye161060Vo.setLthYr2015AfthYr15DdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161060Dto.getLthYr2015AfthYr15DdcAmt(), "0")));	/** column 장기주택저당차입금_2015이후_10_15고정금리이거나비거치상환대출공제액 : lthYr2015AfthYr15DdcAmt */
		
		ye161060Vo.setIsmt(sessionUser.getUsrId());    																						/** column 수정자 : ismt */
		ye161060Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    												/** column 수정주소 : revnAddr */
		
		try{
			
			ye161060DAO.updateYeta5300ToYe161060tabItem05_2(ye161060Vo);
			
			BeanUtils.copyProperties(infcPkgYe161010Vo , ye161060Vo);  
			yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE161060");
			
			
			
			result = 1;
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");

		
		return result;
	}
	

	
	
	/** 그밖의소득공제1 tab 조회 **/
	public Ye161070DTO getYeta5300TabItem06ToYe161070Data(Ye161070DTO ye161070Dto) throws MSFException {
		

		Ye161070Srh_2020_VO ye161070SrhVo = new Ye161070Srh_2020_VO();
		MSFSysm0100BM sessionUser;

		String method = calledClass + ".getYeta5300TabItem06ToYe161070Data";

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(ye161070DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
							.getSession().getServletContext());
			ye161070DAO = (Ye161070_2020_DAO) wac.getBean("Ye161070_2020_DAO");
		}
		
		

		/** 조건절 */
		ye161070SrhVo.setDpobCd(ye161070Dto.getDpobCd());   		/** column 사업장코드 : dpobCd */
		ye161070SrhVo.setYrtxBlggYr(ye161070Dto.getYrtxBlggYr());	/** column 귀속연도 : yrtxBlggYr */
		ye161070SrhVo.setClutSeptCd(ye161070Dto.getClutSeptCd());	/** column 연말정산구분코드 : clutSeptCd */
		ye161070SrhVo.setSystemkey(ye161070Dto.getSystemkey());    	/** column SYSTEMKEY : systemkey */

		Ye161070DTO returnYe161070Dto = new Ye161070DTO();
		
		List egovResultDataList = new ArrayList();

		try {
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
			egovResultDataList = ye161070DAO.selectYeta5300ToYe161070List(ye161070SrhVo);
			
			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";

			if (egovResultDataList != null && egovResultDataList.size() > 0) {
				
				for (int i = 0; i < egovResultDataList.size(); i++) {

					Map tempMap = (Map) egovResultDataList.get(i);
					
					returnYe161070Dto.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));   									 					/** column 사업장코드 : dpobCd */
					returnYe161070Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(tempMap.get("yrtxBlggYr")));    												/** column 귀속연도 : yrtxBlggYr */
					returnYe161070Dto.setClutSeptCd(MSFSharedUtils.allowNulls(tempMap.get("clutSeptCd")));    												/** column 연말정산구분코드 : clutSeptCd */
					returnYe161070Dto.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));    												/** column SYSTEMKEY : systemkey */
					
					returnYe161070Dto.setYr2000PnsnSvngUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yr2000PnsnSvngUseAmt"), "0")));    	/** column 개인연금저축_2000이전_납입금액 : yr2000PnsnSvngUseAmt */
					returnYe161070Dto.setYr2000PnsnSvngDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yr2000PnsnSvngDdcAmt"), "0")));    	/** column 개인연금저축_2000이전_공제액 : yr2000PnsnSvngDdcAmt */
					
					returnYe161070Dto.setSmceSbizUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("smceSbizUseAmt"), "0")));    				/** column 소기업소상인공제부금납입금액 : smceSbizUseAmt */
					returnYe161070Dto.setSmceSbizDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("smceSbizDdcAmt"), "0")));    				/** column 소기업소상인공제부금공제액 : smceSbizDdcAmt */
					returnYe161070Dto.setSbcSvngUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("sbcSvngUseAmt"), "0")));    					/** column 주택마련저축_청약저축납입금액 : sbcSvngUseAmt */
					returnYe161070Dto.setSbcSvngDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("sbcSvngDdcAmt"), "0")));    					/** column 주택마련저축_청약저축공제액 : sbcSvngDdcAmt */
					returnYe161070Dto.setLbrrPrptSvngUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lbrrPrptSvngUseAmt"), "0")));   		/** column 주택마련저축_근로자주택마련저축납입금액 : lbrrPrptSvngUseAmt */
					returnYe161070Dto.setLbrrPrptSvngDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("lbrrPrptSvngDdcAmt"), "0")));    		/** column 주택마련저축_근로자주택마련저축공제액 : lbrrPrptSvngDdcAmt */
					returnYe161070Dto.setHsngSvngUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("hsngSvngUseAmt"), "0")));    				/** column 주택마련저축_주택청약종합저축납입금액 : hsngSvngUseAmt */
					returnYe161070Dto.setHsngSvngDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("hsngSvngDdcAmt"), "0")));    				/** column 주택마련저축_주택청약종합저축공제액 : hsngSvngDdcAmt */
					returnYe161070Dto.setHsngIncUseAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("hsngIncUseAmtSum"), "0")));    			/** column 주택마련저축_소득공제합계 : hsngIncUseAmtSum */
					returnYe161070Dto.setHsngIncDdcAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("hsngIncDdcAmtSum"), "0")));    			/** column 주택마련저축소득공제액합계 : hsngIncDdcAmtSum */
					
					returnYe161070Dto.setCpiv18AsctUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("cpiv18AsctUseAmt"), "0")));    			/** column 출자투자금액_조합등_2018납입금 : cpiv18AsctUseAmt */
					returnYe161070Dto.setCpiv18AsctDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("cpiv18AsctDdcAmt"), "0")));    			/** column 출자투자금액 조합등_2018공제액 : cpiv18AsctDdcAmt */
					returnYe161070Dto.setCpiv18VntUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("cpiv18VntUseAmt"), "0")));    				/** column 출자투자금액벤처등_2018납입금액 : cpiv18VntUseAmt */
					returnYe161070Dto.setCpiv18VntDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("cpiv18VntDdcAmt"), "0")));    				/** column 출자투자금액벤처등_2018공제액 : cpiv18VntDdcAmt */
					
					returnYe161070Dto.setCpiv19AsctUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("cpiv19AsctUseAmt"), "0")));    			/** column 출자투자금액_조합등_2019납입금 : cpiv19AsctUseAmt */
					returnYe161070Dto.setCpiv19AsctDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("cpiv19AsctDdcAmt"), "0")));    			/** column 출자투자금액 조합등_2019공제액 : cpiv19AsctDdcAmt */
					returnYe161070Dto.setCpiv19VntUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("cpiv19VntUseAmt"), "0")));    				/** column 출자투자금액벤처등_2019납입금액 : cpiv19VntUseAmt */
					returnYe161070Dto.setCpiv19VntDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("cpiv19VntDdcAmt"), "0")));    				/** column 출자투자금액벤처등_2019공제액 : cpiv19VntDdcAmt */
					
					returnYe161070Dto.setCpiv20AsctUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("cpiv20AsctUseAmt"), "0")));    			/** column 출자투자금액_조합등_2020납입금 : cpiv20AsctUseAmt */
					returnYe161070Dto.setCpiv20AsctDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("cpiv20AsctDdcAmt"), "0")));    			/** column 출자투자금액 조합등_2020공제액 : cpiv20AsctDdcAmt */
					returnYe161070Dto.setCpiv20VntUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("cpiv20VntUseAmt"), "0")));    				/** column 출자투자금액벤처등_2020납입금액 : cpiv20VntUseAmt */
					returnYe161070Dto.setCpiv20VntDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("cpiv20VntDdcAmt"), "0")));    				/** column 출자투자금액벤처등_2020공제액 : cpiv20VntDdcAmt */
					
					
					returnYe161070Dto.setIvcpInvmUseAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("ivcpInvmUseAmtSum"), "0")));    			/** column 투자조합출자등소득공제납입금액계 : ivcpInvmUseAmtSum */
					returnYe161070Dto.setIvcpInvmDdcAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("ivcpInvmDdcAmtSum"), "0")));    			/** column 투자조합출자등소득공제공제액계 : ivcpInvmDdcAmtSum */
					
					returnYe161070Dto.setCrdcUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("crdcUseAmt"), "0")));    						/** column 신용카드_전통대중제외사용금액 : crdcUseAmt */
					returnYe161070Dto.setDrtpCardUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("drtpCardUseAmt"), "0")));    				/** column 직불선불카드_전통대중제외사용금액 : drtpCardUseAmt */
					returnYe161070Dto.setCshptUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("cshptUseAmt"), "0")));    						/** column 현금영수증_전통대중제외사용금액 : cshptUseAmt */
					returnYe161070Dto.setZrtdUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("zrtdUseAmt"), "0")));    						/** column 제로페이_전통대중제외사용금액 : zrtdUseAmt */
					returnYe161070Dto.setTdmrUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("tdmrUseAmt"), "0")));    						/** column 전통시장사용금액 : tdmrUseAmt */
					returnYe161070Dto.setPbtUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("pbtUseAmt"), "0")));    							/** column 대중교통이용금액 : pbtUseAmt */
					returnYe161070Dto.setBookShowAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("bookShowAmt"), "0")));    							/** column 도서이용금액 : bookShowAmt */
					returnYe161070Dto.setCrdcSumUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("crdcSumUseAmt"), "0")));    					/** column 신용카드등사용액합계 : crdcSumUseAmt */
					returnYe161070Dto.setRdcSumDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("rdcSumDdcAmt"), "0")));   	 				/** column 신용카드등사용공제액합계 : rdcSumDdcAmt */
					returnYe161070Dto.setPrsCrdcUseAmt1(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("prsCrdcUseAmt1"), "0")));    				/** column 본인신용카드등사용액_2014 : prsCrdcUseAmt1 */
					returnYe161070Dto.setTyYrPrsCrdcUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("tyYrPrsCrdcUseAmt"), "0")));    			/** column 본인신용등사용액_2015 : tyYrPrsCrdcUseAmt */
					returnYe161070Dto.setPyrPrsAddDdcrtUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("pyrPrsAddDdcrtUseAmt"), "0"))); 		/** column 본인추가공제율사용분_2014 : pyrPrsAddDdcrtUseAmt */
					returnYe161070Dto.setTyShfyPrsAddDdcrtUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("tyShfyPrsAddDdcrtUseAmt"), "0")));	/** column 본인추가공제율사용분_2016_상반기 : tyShfyPrsAddDdcrtUseAmt */
					
					returnYe161070Dto.setEmstAsctCntrUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("emstAsctCntrUseAmt"), "0")));    		/** column 우리사주조합출연금액 : emstAsctCntrUseAmt */
					returnYe161070Dto.setEmstAsctCntrDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("emstAsctCntrDdcAmt"), "0")));    		/** column 우리사주조합출연금공제금액 : emstAsctCntrDdcAmt */
					returnYe161070Dto.setEmpMntnSnmcUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("empMntnSnmcUseAmt"), "0")));    			/** column 고용유지중소기업근로자임금삭감액 : empMntnSnmcUseAmt */
					returnYe161070Dto.setEmpMntnSnmcDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("empMntnSnmcDdcAmt"), "0")));    			/** column 고용유지중소기업근로자공제금액 : empMntnSnmcDdcAmt */
					returnYe161070Dto.setLtrmCniSsUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("ltrmCniSsUseAmt"), "0")));    				/** column 장기집합투자증권저축납입금액 : ltrmCniSsUseAmt */
					returnYe161070Dto.setLtrmCniSsDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("ltrmCniSsDdcAmt"), "0")));   	 			/** column 장기집합투자증권저축공제금액 : ltrmCniSsDdcAmt */
					
					
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);

		}
		
		/** 로그반영
		 * CRUDSBLO 
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass,"S");

		return returnYe161070Dto;

	}
		
	
	/** 그밖의소득공제1tab 금액 수정 **/
	@Override
	public int saveYeta5300ToYe161070tabItem06(Ye161070DTO ye161070Dto)throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		String method = calledClass + ".saveYeta5300ToYe161070tabItem06";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";
		
		InfcPkgYe161010_2020_VO infcPkgYe161010Vo = new InfcPkgYe161010_2020_VO(); 
		Yeta5300ListenerAdapter  yeta5300ListenerAdt = new Yeta5300ListenerAdapter();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		Ye161070_2020_VO ye161070Vo = new Ye161070_2020_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		ye161070Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161070Dto.getDpobCd()));    														/** column 사업장코드 : dpobCd */
		ye161070Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161070Dto.getYrtxBlggYr()));    												/** column 귀속연도 : yrtxBlggYr */
		ye161070Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161070Dto.getClutSeptCd()));    												/** column 연말정산구분코드 : clutSeptCd */
		ye161070Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161070Dto.getSystemkey()));    													/** column SYSTEMKEY : systemkey */
		
		ye161070Vo.setYr2000PnsnSvngUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getYr2000PnsnSvngUseAmt(), "0")));		/** column 개인연금저축_2000이전_납입금액 : yr2000PnsnSvngUseAmt */
		ye161070Vo.setYr2000PnsnSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getYr2000PnsnSvngDdcAmt(), "0")));		/** column 개인연금저축_2000이전_공제액 : yr2000PnsnSvngDdcAmt */
		
		ye161070Vo.setSmceSbizUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getSmceSbizUseAmt(), "0")));    				/** column 소기업소상인공제부금납입금액 : smceSbizUseAmt */
		ye161070Vo.setSmceSbizDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getSmceSbizDdcAmt(), "0")));   				/** column 소기업소상인공제부금공제액 : smceSbizDdcAmt */
		
		ye161070Vo.setSbcSvngUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getSbcSvngUseAmt(), "0")));    					/** column 주택마련저축_청약저축납입금액 : sbcSvngUseAmt */
		ye161070Vo.setSbcSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getSbcSvngDdcAmt(), "0")));    					/** column 주택마련저축_청약저축공제액 : sbcSvngDdcAmt */
		ye161070Vo.setLbrrPrptSvngUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getLbrrPrptSvngUseAmt(), "0")));    		/** column 주택마련저축_근로자주택마련저축납입금액 : lbrrPrptSvngUseAmt */
		ye161070Vo.setLbrrPrptSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getLbrrPrptSvngDdcAmt(), "0")));    		/** column 주택마련저축_근로자주택마련저축공제액 : lbrrPrptSvngDdcAmt */
		ye161070Vo.setHsngSvngUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getHsngSvngUseAmt(), "0")));    				/** column 주택마련저축_주택청약종합저축납입금액 : hsngSvngUseAmt */
		ye161070Vo.setHsngSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getHsngSvngDdcAmt(), "0")));    				/** column 주택마련저축_주택청약종합저축공제액 : hsngSvngDdcAmt */
		
		ye161070Vo.setHsngIncUseAmtSum(ye161070Vo.getSbcSvngUseAmt().add(ye161070Vo.getLbrrPrptSvngUseAmt())
																						.add(ye161070Vo.getHsngSvngUseAmt()));   	 		/** column 주택마련저축_소득공제합계 : hsngIncUseAmtSum */
		ye161070Vo.setHsngIncDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getHsngIncDdcAmtSum(), "0")));    			/** column 주택마련저축소득공제액합계 : hsngIncDdcAmtSum */
		
		ye161070Vo.setCpiv16AsctUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv16AsctUseAmt(), "0")));    			/** column 출자투자금액_조합등_2016납입금 : cpiv16AsctUseAmt */
		ye161070Vo.setCpiv16AsctDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv16AsctDdcAmt(), "0")));    			/** column 출자투자금액 조합등_2016공제액 : cpiv16AsctDdcAmt */
		ye161070Vo.setCpiv16VntUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv16VntUseAmt(), "0")));    				/** column 출자투자금액벤처등_2016납입금액 : cpiv16VntUseAmt */
		ye161070Vo.setCpiv16VntDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv16VntDdcAmt(), "0")));    				/** column 출자투자금액벤처등_2016공제액 : cpiv16VntDdcAmt */
		ye161070Vo.setCpiv17AsctUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv17AsctUseAmt(), "0")));    			/** column 출자투자금액_조합등_2017납입금 : cpiv17AsctUseAmt */
		ye161070Vo.setCpiv17AsctDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv17AsctDdcAmt(), "0")));    			/** column 출자투자금액 조합등_2017공제액 : cpiv17AsctDdcAmt */
		ye161070Vo.setCpiv17VntUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv17VntUseAmt(), "0")));    				/** column 출자투자금액벤처등_2017납입금액 : cpiv17VntUseAmt */
		ye161070Vo.setCpiv17VntDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv17VntDdcAmt(), "0")));    				/** column 출자투자금액벤처등_2017공제액 : cpiv17VntDdcAmt */
		ye161070Vo.setCpiv18AsctUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv18AsctUseAmt(), "0")));    			/** column 출자투자금액_조합등_2018납입금 : cpiv18AsctUseAmt */
		ye161070Vo.setCpiv18AsctDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv18AsctDdcAmt(), "0")));    			/** column 출자투자금액 조합등_2018공제액 : cpiv18AsctDdcAmt */
		ye161070Vo.setCpiv18VntUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv18VntUseAmt(), "0")));    				/** column 출자투자금액벤처등_2018납입금액 : cpiv18VntUseAmt */
		ye161070Vo.setCpiv18VntDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv18VntDdcAmt(), "0")));    				/** column 출자투자금액벤처등_2018공제액 : cpiv18VntDdcAmt */
		ye161070Vo.setCpiv19AsctUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv19AsctUseAmt(), "0")));    			/** column 출자투자금액_조합등_2020납입금 : cpiv19AsctUseAmt */
		ye161070Vo.setCpiv19AsctDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv19AsctDdcAmt(), "0")));    			/** column 출자투자금액 조합등_2020공제액 : cpiv19AsctDdcAmt */
		ye161070Vo.setCpiv19VntUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv19VntUseAmt(), "0")));    				/** column 출자투자금액벤처등_2020납입금액 : cpiv19VntUseAmt */
		ye161070Vo.setCpiv19VntDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv19VntDdcAmt(), "0")));    				/** column 출자투자금액벤처등_2020공제액 : cpiv19VntDdcAmt */
		
		ye161070Vo.setIvcpInvmUseAmtSum(ye161070Vo.getCpiv16AsctUseAmt().add(ye161070Vo.getCpiv16VntDdcAmt())
												.add(ye161070Vo.getCpiv17AsctUseAmt()).add(ye161070Vo.getCpiv17VntUseAmt())
												.add(ye161070Vo.getCpiv18AsctUseAmt()).add(ye161070Vo.getCpiv18VntUseAmt()));    			/** column 투자조합출자등소득공제납입금액계 : ivcpInvmUseAmtSum */
		ye161070Vo.setIvcpInvmDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getIvcpInvmDdcAmtSum(), "0")));    			/** column 투자조합출자등소득공제공제액계 : ivcpInvmDdcAmtSum */
		
		ye161070Vo.setCrdcUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCrdcUseAmt(), "0")));   	 					/** column 신용카드_전통대중제외사용금액 : crdcUseAmt */
		ye161070Vo.setDrtpCardUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getDrtpCardUseAmt(), "0")));    				/** column 직불선불카드_전통대중제외사용금액 : drtpCardUseAmt */
		ye161070Vo.setCshptUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCshptUseAmt(), "0")));    						/** column 현금영수증_전통대중제외사용금액 : cshptUseAmt */
		ye161070Vo.setTdmrUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getTdmrUseAmt(), "0")));    						/** column 전통시장사용금액 : tdmrUseAmt */
		ye161070Vo.setPbtUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getPbtUseAmt(), "0")));    							/** column 대중교통이용금액 : pbtUseAmt */
		ye161070Vo.setBookShowAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getBookShowAmt(), "0")));    							/** column 도서이용금액 : bookShowAmt */
		ye161070Vo.setCrdcSumUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCrdcSumUseAmt(), "0")));    					/** column 신용카드등사용액합계 : crdcSumUseAmt */
		ye161070Vo.setRdcSumDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getRdcSumDdcAmt(), "0")));    					/** column 신용카드등사용공제액합계 : rdcSumDdcAmt */
		
		ye161070Vo.setPrsCrdcUseAmt1(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getPrsCrdcUseAmt1(), "0")));    				/** column 본인신용카드등사용액_2014 : prsCrdcUseAmt1 */
		ye161070Vo.setTyYrPrsCrdcUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getTyYrPrsCrdcUseAmt(), "0")));    			/** column 본인신용등사용액_2015 : tyYrPrsCrdcUseAmt */
		ye161070Vo.setPyrPrsAddDdcrtUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getPyrPrsAddDdcrtUseAmt(), "0")));		/** column 본인추가공제율사용분_2014 : pyrPrsAddDdcrtUseAmt */
		ye161070Vo.setTyShfyPrsAddDdcrtUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getTyShfyPrsAddDdcrtUseAmt(), "0")));	/** column 본인추가공제율사용분_2016_상반기 : tyShfyPrsAddDdcrtUseAmt */
		
//		ye161070Vo.setEmstAsctCntrUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getEmstAsctCntrUseAmt(), "0")));    		/** column 우리사주조합출연금액 : emstAsctCntrUseAmt */
//		ye161070Vo.setEmstAsctCntrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getEmstAsctCntrDdcAmt(), "0")));   	 	/** column 우리사주조합출연금공제금액 : emstAsctCntrDdcAmt */
//		ye161070Vo.setEmpMntnSnmcUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getEmpMntnSnmcUseAmt(), "0")));    			/** column 고용유지중소기업근로자임금삭감액 : empMntnSnmcUseAmt */
//		ye161070Vo.setEmpMntnSnmcDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getEmpMntnSnmcDdcAmt(), "0")));    			/** column 고용유지중소기업근로자공제금액 : empMntnSnmcDdcAmt */
//		ye161070Vo.setLtrmCniSsUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getLtrmCniSsUseAmt(), "0")));    				/** column 장기집합투자증권저축납입금액 : ltrmCniSsUseAmt */
//		ye161070Vo.setLtrmCniSsDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getLtrmCniSsDdcAmt(), "0")));    				/** column 장기집합투자증권저축공제금액 : ltrmCniSsDdcAmt */

		ye161070Vo.setIsmt(sessionUser.getUsrId());    																						/** column 수정자 : ismt */
		ye161070Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    												/** column 수정주소 : revnAddr */
		
		try{
			
			ye161070DAO.updateYeta5300ToYe161070tabItem06(ye161070Vo);
			
			BeanUtils.copyProperties(infcPkgYe161010Vo , ye161070Vo);  
			yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE161070");
			
			result = 1;
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
		return result;
	}
	
	 
	/** 그밖의소득공제2tab 금액 수정 **/
	@Override
	public int saveYeta5300ToYe161070tabItem07(Ye161070DTO ye161070Dto)throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		String method = calledClass + ".saveYeta5300ToYe161070tabItem07";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";
		
		InfcPkgYe161010_2020_VO infcPkgYe161010Vo = new InfcPkgYe161010_2020_VO(); 
		Yeta5300ListenerAdapter  yeta5300ListenerAdt = new Yeta5300ListenerAdapter();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		Ye161070_2020_VO ye161070Vo = new Ye161070_2020_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		ye161070Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161070Dto.getDpobCd()));    														/** column 사업장코드 : dpobCd */
		ye161070Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161070Dto.getYrtxBlggYr()));    												/** column 귀속연도 : yrtxBlggYr */
		ye161070Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161070Dto.getClutSeptCd()));    												/** column 연말정산구분코드 : clutSeptCd */
		ye161070Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161070Dto.getSystemkey()));    													/** column SYSTEMKEY : systemkey */
		
//		ye161070Vo.setYr2000PnsnSvngUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getYr2000PnsnSvngUseAmt(), "0")));		/** column 개인연금저축_2000이전_납입금액 : yr2000PnsnSvngUseAmt */
//		ye161070Vo.setYr2000PnsnSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getYr2000PnsnSvngDdcAmt(), "0")));		/** column 개인연금저축_2000이전_공제액 : yr2000PnsnSvngDdcAmt */
//		
//		ye161070Vo.setSmceSbizUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getSmceSbizUseAmt(), "0")));    				/** column 소기업소상인공제부금납입금액 : smceSbizUseAmt */
//		ye161070Vo.setSmceSbizDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getSmceSbizDdcAmt(), "0")));   				/** column 소기업소상인공제부금공제액 : smceSbizDdcAmt */
//		
//		ye161070Vo.setSbcSvngUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getSbcSvngUseAmt(), "0")));    					/** column 주택마련저축_청약저축납입금액 : sbcSvngUseAmt */
//		ye161070Vo.setSbcSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getSbcSvngDdcAmt(), "0")));    					/** column 주택마련저축_청약저축공제액 : sbcSvngDdcAmt */
//		ye161070Vo.setLbrrPrptSvngUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getLbrrPrptSvngUseAmt(), "0")));    		/** column 주택마련저축_근로자주택마련저축납입금액 : lbrrPrptSvngUseAmt */
//		ye161070Vo.setLbrrPrptSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getLbrrPrptSvngDdcAmt(), "0")));    		/** column 주택마련저축_근로자주택마련저축공제액 : lbrrPrptSvngDdcAmt */
//		ye161070Vo.setHsngSvngUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getHsngSvngUseAmt(), "0")));    				/** column 주택마련저축_주택청약종합저축납입금액 : hsngSvngUseAmt */
//		ye161070Vo.setHsngSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getHsngSvngDdcAmt(), "0")));    				/** column 주택마련저축_주택청약종합저축공제액 : hsngSvngDdcAmt */
//		ye161070Vo.setHsngIncUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getHsngIncUseAmtSum(), "0")));   	 		/** column 주택마련저축_소득공제합계 : hsngIncUseAmtSum */
//		ye161070Vo.setHsngIncDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getHsngIncDdcAmtSum(), "0")));    			/** column 주택마련저축소득공제액합계 : hsngIncDdcAmtSum */
//		
//		ye161070Vo.setCpiv14AsctUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv14AsctUseAmt(), "0")));    			/** column 출자투자금액_조합등_2014납입금액 : cpiv14AsctUseAmt */
//		ye161070Vo.setCpiv14AsctDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv14AsctDdcAmt(), "0")));   			/** column 출자투자금액_조합등_2014공제액 : cpiv14AsctDdcAmt */
//		ye161070Vo.setCpiv14VntUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv14VntUseAmt(), "0")));    				/** column 출자투자금액_벤처등_2014납입금액 : cpiv14VntUseAmt */
//		ye161070Vo.setCpiv14VntDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv14VntDdcAmt(), "0")));    				/** column 출자투자금액_벤처등_2014공제액 : cpiv14VntDdcAmt */
//		ye161070Vo.setCpiv15AsctUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv15AsctUseAmt(), "0")));    			/** column 출자투자금액_조합등_2015납입금액 : cpiv15AsctUseAmt */
//		ye161070Vo.setCpiv15AsctDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv15AsctDdcAmt(), "0")));   			/** column 출자투자금액_조합등_2015공제액 : cpiv15AsctDdcAmt */
//		ye161070Vo.setCpiv15VntUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv15VntUseAmt(), "0")));    				/** column 출자투자금액_벤처등_2015납입금액 : cpiv15VntUseAmt */
//		ye161070Vo.setCpiv15VntDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv15VntDdcAmt(), "0")));   				/** column 출자투자금액_벤처등_2015공제액 : cpiv15VntDdcAmt */
//		ye161070Vo.setCpiv16AsctUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv16AsctUseAmt(), "0")));    			/** column 출자투자금액_조합등_2016납입금 : cpiv16AsctUseAmt */
//		ye161070Vo.setCpiv16AsctDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv16AsctDdcAmt(), "0")));    			/** column 출자투자금액 조합등_2016공제액 : cpiv16AsctDdcAmt */
//		ye161070Vo.setCpiv16VntUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv16VntUseAmt(), "0")));    				/** column 출자투자금액벤처등_2016납입금액 : cpiv16VntUseAmt */
//		ye161070Vo.setCpiv16VntDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv16VntDdcAmt(), "0")));    				/** column 출자투자금액벤처등_2016공제액 : cpiv16VntDdcAmt */
//		ye161070Vo.setCpiv17AsctUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv17AsctUseAmt(), "0")));    			/** column 출자투자금액_조합등_2017납입금 : cpiv17AsctUseAmt */
//		ye161070Vo.setCpiv17AsctDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv17AsctDdcAmt(), "0")));    			/** column 출자투자금액 조합등_2017공제액 : cpiv17AsctDdcAmt */
//		ye161070Vo.setCpiv17VntUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv17VntUseAmt(), "0")));    				/** column 출자투자금액벤처등_2017납입금액 : cpiv17VntUseAmt */
//		ye161070Vo.setCpiv17VntDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCpiv17VntDdcAmt(), "0")));    				/** column 출자투자금액벤처등_2017공제액 : cpiv17VntDdcAmt */
//		ye161070Vo.setIvcpInvmUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getIvcpInvmUseAmtSum(), "0")));    			/** column 투자조합출자등소득공제납입금액계 : ivcpInvmUseAmtSum */
//		ye161070Vo.setIvcpInvmDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getIvcpInvmDdcAmtSum(), "0")));    			/** column 투자조합출자등소득공제공제액계 : ivcpInvmDdcAmtSum */
//		
//		ye161070Vo.setCrdcUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCrdcUseAmt(), "0")));   	 					/** column 신용카드_전통대중제외사용금액 : crdcUseAmt */
//		ye161070Vo.setDrtpCardUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getDrtpCardUseAmt(), "0")));    				/** column 직불선불카드_전통대중제외사용금액 : drtpCardUseAmt */
//		ye161070Vo.setCshptUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCshptUseAmt(), "0")));    						/** column 현금영수증_전통대중제외사용금액 : cshptUseAmt */
//		ye161070Vo.setTdmrUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getTdmrUseAmt(), "0")));    						/** column 전통시장사용금액 : tdmrUseAmt */
//		ye161070Vo.setPbtUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getPbtUseAmt(), "0")));    							/** column 대중교통이용금액 : pbtUseAmt */
//		ye161070Vo.setCrdcSumUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getCrdcSumUseAmt(), "0")));    					/** column 신용카드등사용액합계 : crdcSumUseAmt */
//		ye161070Vo.setRdcSumDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getRdcSumDdcAmt(), "0")));    					/** column 신용카드등사용공제액합계 : rdcSumDdcAmt */
//		
//		ye161070Vo.setPrsCrdcUseAmt1(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getPrsCrdcUseAmt1(), "0")));    				/** column 본인신용카드등사용액_2014 : prsCrdcUseAmt1 */
//		ye161070Vo.setTyYrPrsCrdcUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getTyYrPrsCrdcUseAmt(), "0")));    			/** column 본인신용등사용액_2015 : tyYrPrsCrdcUseAmt */
//		ye161070Vo.setPyrPrsAddDdcrtUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getPyrPrsAddDdcrtUseAmt(), "0")));		/** column 본인추가공제율사용분_2014 : pyrPrsAddDdcrtUseAmt */
//		ye161070Vo.setTyShfyPrsAddDdcrtUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getTyShfyPrsAddDdcrtUseAmt(), "0")));	/** column 본인추가공제율사용분_2016_상반기 : tyShfyPrsAddDdcrtUseAmt */
		
		ye161070Vo.setEmstAsctCntrUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getEmstAsctCntrUseAmt(), "0")));    		/** column 우리사주조합출연금액 : emstAsctCntrUseAmt */
		ye161070Vo.setEmstAsctCntrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getEmstAsctCntrDdcAmt(), "0")));   	 	/** column 우리사주조합출연금공제금액 : emstAsctCntrDdcAmt */
		ye161070Vo.setEmpMntnSnmcUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getEmpMntnSnmcUseAmt(), "0")));    			/** column 고용유지중소기업근로자임금삭감액 : empMntnSnmcUseAmt */
		ye161070Vo.setEmpMntnSnmcDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getEmpMntnSnmcDdcAmt(), "0")));    			/** column 고용유지중소기업근로자공제금액 : empMntnSnmcDdcAmt */
		ye161070Vo.setLtrmCniSsUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getLtrmCniSsUseAmt(), "0")));    				/** column 장기집합투자증권저축납입금액 : ltrmCniSsUseAmt */
		ye161070Vo.setLtrmCniSsDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls( ye161070Dto.getLtrmCniSsDdcAmt(), "0")));    				/** column 장기집합투자증권저축공제금액 : ltrmCniSsDdcAmt */

		ye161070Vo.setIsmt(sessionUser.getUsrId());    																						/** column 수정자 : ismt */
		ye161070Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    												/** column 수정주소 : revnAddr */
		
		try{
			
			ye161070DAO.updateYeta5300ToYe161070tabItem07(ye161070Vo);
			
			BeanUtils.copyProperties(infcPkgYe161010Vo , ye161070Vo);  
			yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE161070");
			
			result = 1;
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
		return result;
	}
	

	
	/** 세액감면및세액공제1tab 조회 **/
	public Ye161080DTO getYeta5300TabItem08ToYe161080Data(Ye161080DTO ye161080Dto) throws MSFException {
		

		Ye161080Srh_2020_VO ye161080SrhVo = new Ye161080Srh_2020_VO();
		MSFSysm0100BM sessionUser;

		String method = calledClass + ".getYeta5300TabItem08ToYe161080Data";

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(ye161080DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
							.getSession().getServletContext());
			ye161080DAO = (Ye161080_2020_DAO) wac.getBean("Ye161080_2020_DAO");
		}
		

		/** 조건절 */
		ye161080SrhVo.setDpobCd(ye161080Dto.getDpobCd());   		/** column 사업장코드 : dpobCd */
		ye161080SrhVo.setYrtxBlggYr(ye161080Dto.getYrtxBlggYr());	/** column 귀속연도 : yrtxBlggYr */
		ye161080SrhVo.setClutSeptCd(ye161080Dto.getClutSeptCd());	/** column 연말정산구분코드 : clutSeptCd */
		ye161080SrhVo.setSystemkey(ye161080Dto.getSystemkey());    	/** column SYSTEMKEY : systemkey */

		Ye161080DTO returnYe161080Dto = new Ye161080DTO();
		
		List egovResultDataList = new ArrayList();

		try {
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
			egovResultDataList = ye161080DAO.selectYeta5300ToYe161080tabItem08List(ye161080SrhVo);
			
			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";

			if (egovResultDataList != null && egovResultDataList.size() > 0) {
				
				for (int i = 0; i < egovResultDataList.size(); i++) {

					Map tempMap = (Map) egovResultDataList.get(i);
					
					returnYe161080Dto.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    														/** column 사업장코드 : dpobCd */
					returnYe161080Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(tempMap.get("yrtxBlggYr")));    												/** column 귀속연도 : yrtxBlggYr */
					returnYe161080Dto.setClutSeptCd(MSFSharedUtils.allowNulls(tempMap.get("clutSeptCd")));    												/** column 연말정산구분코드 : clutSeptCd */
					returnYe161080Dto.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));    												/** column SYSTEMKEY : systemkey */
					
					returnYe161080Dto.setSctcHpUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("sctcHpUseAmt"), "0")));    					/** column 연금계좌_과학기술인공제납입금액 : sctcHpUseAmt */
					returnYe161080Dto.setSctcHpDdcTrgtAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("sctcHpDdcTrgtAmt"), "0")));    			/** column 연금계좌_과학기술인공제_공제대상금액 : sctcHpDdcTrgtAmt */
					returnYe161080Dto.setSctcHpDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("sctcHpDdcAmt"), "0")));    					/** column 연금계좌_과학기술인공제_공제세액 : sctcHpDdcAmt */
					returnYe161080Dto.setRtpnUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("rtpnUseAmt"), "0")));    						/** column 연금계좌_근로자퇴직급여보장법_퇴직연금납입금액 : rtpnUseAmt */
					returnYe161080Dto.setRtpnDdcTrgtAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("rtpnDdcTrgtAmt"), "0")));    				/** column 연금계좌_근로자퇴직급여보장법_퇴직연금공제대상금액 : rtpnDdcTrgtAmt */
					returnYe161080Dto.setRtpnDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("rtpnDdcAmt"), "0")));   			 			/** column 연금계좌_근로자퇴직급여보장법_퇴직연금공제세액 : rtpnDdcAmt */
					returnYe161080Dto.setPnsnSvngUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("pnsnSvngUseAmt"), "0")));    				/** column 연금계좌_연금저축납입금액 : pnsnSvngUseAmt */
					returnYe161080Dto.setPnsnSvngDdcTrgtAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("pnsnSvngDdcTrgtAmt"), "0")));			/** column 연금계좌_연금저축공제대상금액 : pnsnSvngDdcTrgtAmt */
					returnYe161080Dto.setPnsnSvngDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("pnsnSvngDdcAmt"), "0")));    				/** column 연금계좌_연금저축공제세액 : pnsnSvngDdcAmt */
					returnYe161080Dto.setPnsnAccUseAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("pnsnAccUseAmtSum"), "0")));    			/** column 연금계좌납입금액합계 : pnsnAccUseAmtSum */
					returnYe161080Dto.setPnsnAccDdcTrgtAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("pnsnAccDdcTrgtAmtSum"), "0")));		/** column 연금계좌공제대상금액합계 : pnsnAccDdcTrgtAmtSum */
					returnYe161080Dto.setPnsnAccDdcAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("pnsnAccDdcAmtSum"), "0")));    			/** column 연금계좌공제세액합계 : pnsnAccDdcAmtSum */
					returnYe161080Dto.setCvrgInscUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("cvrgInscUseAmt"), "0")));    				/** column 보장성보험납입금액 : cvrgInscUseAmt */
					returnYe161080Dto.setCvrgInscDdcTrgtAmt2(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("cvrgInscDdcTrgtAmt2"), "0")));    		/** column 보장성보험공제대상금액 : cvrgInscDdcTrgtAmt2 */
					returnYe161080Dto.setCvrgInscDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("cvrgInscDdcAmt"), "0")));    				/** column 보장성보험공제세액 : cvrgInscDdcAmt */
					returnYe161080Dto.setDsbrEuCvrgUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("dsbrEuCvrgUseAmt"), "0")));    			/** column 장애인전용보장성보험납입금액 : dsbrEuCvrgUseAmt */
					returnYe161080Dto.setDsbrEuCvrgDdcTrgtAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("dsbrEuCvrgDdcTrgtAmt"), "0")));		/** column 장애인전용보장성보험공제대상금액 : dsbrEuCvrgDdcTrgtAmt */
					returnYe161080Dto.setDsbrEuCvrgDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("dsbrEuCvrgDdcAmt"), "0")));    			/** column 장애인전용보장성보험공제세액 : dsbrEuCvrgDdcAmt */
					returnYe161080Dto.setInfeePymUseAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("infeePymUseAmtSum"), "0")));    			/** column 보험료납입금액합계 : infeePymUseAmtSum */
					returnYe161080Dto.setInfeePymDdcTrgtAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("infeePymDdcTrgtAmtSum"), "0"))); 	/** column 보험료공제대상금액합계 : infeePymDdcTrgtAmtSum */
					returnYe161080Dto.setInfeePymDdcAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("infeePymDdcAmtSum"), "0")));    			/** column 보험료공제세액합계 : infeePymDdcAmtSum */
					returnYe161080Dto.setMdxpsLsInsrTrAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mdxpsLsInsrTrAmt"), "0")));    		/** column 의료비_실손보험금보전금액 : mdxpsLsInsrTrAmt  */
					returnYe161080Dto.setMdxpsSftSprcdUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mdxpsSftSprcdUseAmt"), "0")));    		/** column 의료비_난임시술비납입금액 : mdxpsSftSprcdUseAmt */
					returnYe161080Dto.setMdxpsSftSprcdDdcTrgtAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mdxpsSftSprcdDdcTrgtAmt"), "0")));	/** column 의료비_난임시술비공제대상금액 : mdxpsSftSprcdDdcTrgtAmt */
					returnYe161080Dto.setMdxpsSftSprcdDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mdxpsSftSprcdDdcAmt"), "0")));    		/** column 의료비_난임시술비공제세액 : mdxpsSftSprcdDdcAmt */
					returnYe161080Dto.setMdxpsPrsUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mdxpsPrsUseAmt"), "0")));    				/** column 의료비_본인65세이상장애인납입금액 : mdxpsPrsUseAmt */
					returnYe161080Dto.setMdxpsPrsDdcTrgtAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mdxpsPrsDdcTrgtAmt"), "0")));    		/** column 의료비_본인65세이상장애인공제대상금액 : mdxpsPrsDdcTrgtAmt */
					returnYe161080Dto.setMdxpsPrsDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mdxpsPrsDdcAmt"), "0")));    				/** column 의료비_본인65세이상장애인공제세액 : mdxpsPrsDdcAmt */
					returnYe161080Dto.setMdxpsOthUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mdxpsOthUseAmt"), "0")));    				/** column 의료비_그밖의공제대상자납입금액 : mdxpsOthUseAmt */
					returnYe161080Dto.setMdxpsOthDdcTrgtAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mdxpsOthDdcTrgtAmt"), "0")));    		/** column 의료비_그밖의공제대상자공제대상금액 : mdxpsOthDdcTrgtAmt */
					returnYe161080Dto.setMdxpsOthDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mdxpsOthDdcAmt"), "0")));    				/** column 의료비_그밖의공제대상자공제새액 : mdxpsOthDdcAmt */
					returnYe161080Dto.setMdxpsUseAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mdxpsUseAmtSum"), "0")));    				/** column 의료비납입금액합계 : mdxpsUseAmtSum */
					returnYe161080Dto.setMdxpsDdcTrgtAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mdxpsDdcTrgtAmtSum"), "0")));    		/** column 의료비공제대상금액합계 : mdxpsDdcTrgtAmtSum */
					returnYe161080Dto.setMdxpsDdcAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mdxpsDdcAmtSum"), "0")));    				/** column 의료비공제세액합계 : mdxpsDdcAmtSum */
					returnYe161080Dto.setScxpsPrsUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsPrsUseAmt"), "0")));    				/** column 교육비_소득자본인납입금액 : scxpsPrsUseAmt */
					returnYe161080Dto.setScxpsPrsDdcTrgtAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsPrsDdcTrgtAmt"), "0")));    		/** column 교육비_소득자본인공제대상금액 : scxpsPrsDdcTrgtAmt */
					returnYe161080Dto.setScxpsPrsDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsPrsDdcAmt"), "0")));    				/** column 교육비_소득자본인공제세액 : scxpsPrsDdcAmt */
					returnYe161080Dto.setScxpsKidUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsKidUseAmt"), "0")));    				/** column 교육비_취학전아동납입금액 : scxpsKidUseAmt */
					returnYe161080Dto.setScxpsKidDdcTrgtAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsKidDdcTrgtAmt"), "0")));    		/** column 교육비_취학전아동공제대상금액 : scxpsKidDdcTrgtAmt */
					returnYe161080Dto.setScxpsKidDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsKidDdcAmt"), "0")));    				/** column 교육비_취학전아동공제새액 : scxpsKidDdcAmt */
					returnYe161080Dto.setScxpsStdUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsStdUseAmt"), "0")));    				/** column 교육비_초중고등학교납입금액 : scxpsStdUseAmt */
					returnYe161080Dto.setScxpsStdDdcTrgtAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsStdDdcTrgtAmt"), "0")));    		/** column 교육비_초중고등학교공제대상금액 : scxpsStdDdcTrgtAmt */
					returnYe161080Dto.setScxpsStdDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsStdDdcAmt"), "0")));    				/** column 교육비_초중고등학교공제세액 : scxpsStdDdcAmt */
					returnYe161080Dto.setScxpsUndUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsUndUseAmt"), "0")));    				/** column 교육비_대학생납입금액 : scxpsUndUseAmt */
					returnYe161080Dto.setScxpsUndDdcTrgtAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsUndDdcTrgtAmt"), "0")));    		/** column 교육비_대학생공제대상금액 : scxpsUndDdcTrgtAmt */
					returnYe161080Dto.setScxpsUndDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsUndDdcAmt"), "0")));    				/** column 교육비_대상생공제세액 : scxpsUndDdcAmt */
					returnYe161080Dto.setScxpsDsbrUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsDsbrUseAmt"), "0")));    				/** column 교육비_장애인납입금액 : scxpsDsbrUseAmt */
					returnYe161080Dto.setScxpsDsbrDdcTrgtAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsDsbrDdcTrgtAmt"), "0")));   	 	/** column 교육비_장애인공제대상금액 : scxpsDsbrDdcTrgtAmt */
					returnYe161080Dto.setScxpsDsbrDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsDsbrDdcAmt"), "0")));    				/** column 교육비_장애인공제세액 : scxpsDsbrDdcAmt */
					returnYe161080Dto.setScxpsKidCount(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsKidCount"), "0")));    					/** column 교육비_취학전아동인원수 : scxpsKidCount */
					returnYe161080Dto.setScxpsStdCount(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsStdCount"), "0")));    					/** column 교육비_초중고등학교인원수 : scxpsStdCount */
					returnYe161080Dto.setScxpsUndCount(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsUndCount"), "0")));    					/** column 교육비_대학생인원수 : scxpsUndCount */
					returnYe161080Dto.setScxpsDsbrCount(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsDsbrCount"), "0")));    				/** column 교육비_장애인인원수 : scxpsDsbrCount */
					returnYe161080Dto.setScxpsUseAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsUseAmtSum"), "0")));    				/** column 교육비납입금액합계 : scxpsUseAmtSum */
					returnYe161080Dto.setScxpsDdcTrgtAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsDdcTrgtAmtSum"), "0")));    		/** column 교육비공제대상금액합계 : scxpsDdcTrgtAmtSum */
					returnYe161080Dto.setScxpsDdcAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("scxpsDdcAmtSum"), "0")));   	 			/** column 교육비공제세액금액합계 : scxpsDdcAmtSum */
					returnYe161080Dto.setConb10ttswLtUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conb10ttswLtUseAmt"), "0")));    		/** column 기부금_정치자금기부금10이하기부금 : conb10ttswLtUseAmt */
					returnYe161080Dto.setConb10ttswLtDdcTrgtAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conb10ttswLtDdcTrgtAmt"), "0")));	/** column 기부금_정치자금기부금10이하공제대상금액 : conb10ttswLtDdcTrgtAmt */
					returnYe161080Dto.setConb10ttswLtDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conb10ttswLtDdcAmt"), "0")));    		/** column 기부금_정치자금기부금10이하공제세액 : conb10ttswLtDdcAmt */
					returnYe161080Dto.setConb10excsLtUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conb10excsLtUseAmt"), "0")));    		/** column 기부금_정치자금기부금10초과기부금액 : conb10excsLtUseAmt */
					returnYe161080Dto.setConb10excsLtDdcTrgtAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conb10excsLtDdcTrgtAmt"), "0")));	/** column 기부금_정치자금기부금10초과공제대상금액 : conb10excsLtDdcTrgtAmt */
					returnYe161080Dto.setConb10excsLtDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conb10excsLtDdcAmt"), "0")));    		/** column 기부금_정치자금기부금10초과공제세액 : conb10excsLtDdcAmt */
					returnYe161080Dto.setConbLglUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbLglUseAmt"), "0")));    					/** column 기부금_법정기부금납입금액 : conbLglUseAmt */
					returnYe161080Dto.setConbLglDdcTrgtAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbLglDdcTrgtAmt"), "0")));    			/** column 기부금_법정기부금공제대상금액 : conbLglDdcTrgtAmt */
					returnYe161080Dto.setConbLglDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbLglDdcAmt"), "0")));    					/** column 기부금_법정기부금공제세액 : conbLglDdcAmt */
					returnYe161080Dto.setConbEmstAsctUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbEmstAsctUseAmt"), "0")));    		/** column 기부금_우리사주조합기부금납입금액 : conbEmstAsctUseAmt */
					returnYe161080Dto.setConbEmstAsctDdcTrgtAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbEmstAsctDdcTrgtAmt"), "0")));	/** column 기부금_우리사주조합기부금공제대상금액 : conbEmstAsctDdcTrgtAmt */
					returnYe161080Dto.setConbEmstAsctDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbEmstAsctDdcAmt"), "0")));    		/** column 기부금_우리사주조합기부금공제세액 : conbEmstAsctDdcAmt */
					returnYe161080Dto.setConbReliOrgOthUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbReliOrgOthUseAmt"), "0")));    	/** column 기부금_지정기부금종교단체외기부금액 : conbReliOrgOthUseAmt */
					returnYe161080Dto.setConbReliOrgOthDdcTrgtAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbReliOrgOthDdcTrgtAmt"),"0")));/** column 기부금_지정기부금종교단체외공제대상금액 : conbReliOrgOthDdcTrgtAmt */
					returnYe161080Dto.setConbReliOrgOthDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbReliOrgOthDdcAmt"), "0")));    	/** column 기부금_지정기부금종교단체외공제세액 : conbReliOrgOthDdcAmt */
					returnYe161080Dto.setConbReliOrgUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbReliOrgUseAmt"), "0")));   			/** column 기부금_지정기부금종교단체기부금액 : conbReliOrgUseAmt */
					returnYe161080Dto.setConbReliOrgDdcTrgtAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbReliOrgDdcTrgtAmt"), "0")));   	/** column 기부금_지정기부금종교단체공제대상금액 : conbReliOrgDdcTrgtAmt */
					returnYe161080Dto.setConbReliOrgDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbReliOrgDdcAmt"), "0")));    			/** column 기부금_지정기부금종교단체공제세액 : conbReliOrgDdcAmt */
					returnYe161080Dto.setConbUseAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbUseAmtSum"), "0")));    					/** column 기부금납입금액합계 : conbUseAmtSum */
					returnYe161080Dto.setConbDdcTrgtAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbDdcTrgtAmtSum"), "0")));    			/** column 기부금공제대상금액합계 : conbDdcTrgtAmtSum */
					returnYe161080Dto.setConbDdcAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("conbDdcAmtSum"), "0")));    					/** column 기부금공제세액합계 : conbDdcAmtSum */
					returnYe161080Dto.setMedxpsUseAmtSum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("medxpsUseAmtSum"), "0")));
					
				}
			}

		} catch (Exception ex) {
			
			ex.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
			
		}
		
		/** 로그반영
		 * CRUDSBLO 
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass,"S");

		return returnYe161080Dto;

	}
		
	
	/** 세액감면및세액공제1 - 연금계좌및보험료 금액 수정 **/
	@Override
	public int saveYeta5300ToYe161080tabItem08_1(Ye161080DTO ye161080Dto)throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		String method = calledClass + ".saveYeta5300ToYe161060tabItem08_1";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";
		
		InfcPkgYe161010_2020_VO infcPkgYe161010Vo = new InfcPkgYe161010_2020_VO(); 
		Yeta5300ListenerAdapter  yeta5300ListenerAdt = new Yeta5300ListenerAdapter();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		Ye161080_2020_VO ye161080Vo = new Ye161080_2020_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		ye161080Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161080Dto.getDpobCd()));    													/** column 사업장코드 : dpobCd */
		ye161080Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161080Dto.getYrtxBlggYr()));    											/** column 귀속연도 : yrtxBlggYr */
		ye161080Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161080Dto.getClutSeptCd()));    											/** column 연말정산구분코드 : clutSeptCd */
		ye161080Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161080Dto.getSystemkey()));    												/** column SYSTEMKEY : systemkey */
		
//		ye161080Vo.setSctcHpUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getSctcHpUseAmt(), "0")));    				/** column 연금계좌_과학기술인공제납입금액 : sctcHpUseAmt */
//		ye161080Vo.setSctcHpDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getSctcHpDdcTrgtAmt(), "0")));    		/** column 연금계좌_과학기술인공제_공제대상금액 : sctcHpDdcTrgtAmt */
//		ye161080Vo.setSctcHpDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getSctcHpDdcAmt(), "0")));    				/** column 연금계좌_과학기술인공제_공제세액 : sctcHpDdcAmt */
//		ye161080Vo.setRtpnUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getRtpnUseAmt(), "0")));    					/** column 연금계좌_근로자퇴직급여보장법_퇴직연금납입금액 : rtpnUseAmt */
//		ye161080Vo.setRtpnDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getRtpnDdcTrgtAmt(), "0")));    			/** column 연금계좌_근로자퇴직급여보장법_퇴직연금공제대상금액 : rtpnDdcTrgtAmt */
//		ye161080Vo.setRtpnDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getRtpnDdcAmt(), "0")));   		 				/** column 연금계좌_근로자퇴직급여보장법_퇴직연금공제세액 : rtpnDdcAmt */
//		ye161080Vo.setPnsnSvngUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getPnsnSvngUseAmt(), "0")));    			/** column 연금계좌_연금저축납입금액 : pnsnSvngUseAmt */
//		ye161080Vo.setPnsnSvngDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getPnsnSvngDdcTrgtAmt(), "0")));		/** column 연금계좌_연금저축공제대상금액 : pnsnSvngDdcTrgtAmt */
//		ye161080Vo.setPnsnSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getPnsnSvngDdcAmt(), "0")));    			/** column 연금계좌_연금저축공제세액 : pnsnSvngDdcAmt */
//		ye161080Vo.setPnsnAccUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getPnsnAccUseAmtSum(), "0")));    		/** column 연금계좌납입금액합계 : pnsnAccUseAmtSum */
//		ye161080Vo.setPnsnAccDdcTrgtAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getPnsnAccDdcTrgtAmtSum(), "0")));	/** column 연금계좌공제대상금액합계 : pnsnAccDdcTrgtAmtSum */
//		ye161080Vo.setPnsnAccDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getPnsnAccDdcAmtSum(), "0")));    		/** column 연금계좌공제세액합계 : pnsnAccDdcAmtSum */
		ye161080Vo.setCvrgInscUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getCvrgInscUseAmt(), "0")));    			/** column 보장성보험납입금액 : cvrgInscUseAmt */
//		ye161080Vo.setCvrgInscDdcTrgtAmt2(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getCvrgInscDdcTrgtAmt2(), "0"))); 	 	/** column 보장성보험공제대상금액 : cvrgInscDdcTrgtAmt2 */
//		ye161080Vo.setCvrgInscDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getCvrgInscDdcAmt(), "0")));    			/** column 보장성보험공제세액 : cvrgInscDdcAmt */
		ye161080Vo.setDsbrEuCvrgUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getDsbrEuCvrgUseAmt(), "0")));    		/** column 장애인전용보장성보험납입금액 : dsbrEuCvrgUseAmt */
//		ye161080Vo.setDsbrEuCvrgDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getDsbrEuCvrgDdcTrgtAmt(), "0")));	/** column 장애인전용보장성보험공제대상금액 : dsbrEuCvrgDdcTrgtAmt */
//		ye161080Vo.setDsbrEuCvrgDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getDsbrEuCvrgDdcAmt(), "0")));    		/** column 장애인전용보장성보험공제세액 : dsbrEuCvrgDdcAmt */
//		ye161080Vo.setInfeePymUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getInfeePymUseAmtSum(), "0")));    		/** column 보험료납입금액합계 : infeePymUseAmtSum */
//		ye161080Vo.setInfeePymDdcTrgtAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getInfeePymDdcTrgtAmtSum(), "0")));	/** column 보험료공제대상금액합계 : infeePymDdcTrgtAmtSum */
//		ye161080Vo.setInfeePymDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getInfeePymDdcAmtSum(), "0")));    		/** column 보험료공제세액합계 : infeePymDdcAmtSum */

		ye161080Vo.setIsmt(sessionUser.getUsrId());    																					/** column 수정자 : ismt */
		ye161080Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());   	 										/** column 수정주소 : revnAddr */
		
		
		try{
			
			ye161080DAO.updateYeta5300ToYe161080tabItem08_1(ye161080Vo);
			
			BeanUtils.copyProperties(infcPkgYe161010Vo , ye161080Vo);  
			yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE162010");
			
			
			result = 1;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
		return result;
	}
	
	
	/** 세액감면및세액공제1 - 교육비 금액 수정 **/
	@Override
	public int saveYeta5300ToYe161080tabItem08_3(Ye161080DTO ye161080Dto) throws Exception {
		// TODO Auto-generated method stub

		int result = 0;
		String method = calledClass + ".saveYeta5300ToYe161080tabItem08_3";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";
		
		InfcPkgYe161010_2020_VO infcPkgYe161010Vo = new InfcPkgYe161010_2020_VO(); 
		Yeta5300ListenerAdapter  yeta5300ListenerAdt = new Yeta5300ListenerAdapter();
		
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		Ye161080_2020_VO ye161080Vo = new Ye161080_2020_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		ye161080Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161080Dto.getDpobCd()));    													/** column 사업장코드 : dpobCd */
		ye161080Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161080Dto.getYrtxBlggYr()));    											/** column 귀속연도 : yrtxBlggYr */
		ye161080Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161080Dto.getClutSeptCd()));    											/** column 연말정산구분코드 : clutSeptCd */
		ye161080Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161080Dto.getSystemkey()));    												/** column SYSTEMKEY : systemkey */
		
		ye161080Vo.setScxpsPrsUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsPrsUseAmt(), "0")));    /** column 교육비_소득자본인납입금액 : scxpsPrsUseAmt */
//		ye161080Vo.setScxpsPrsDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsPrsDdcTrgtAmt(), "0")));    /** column 교육비_소득자본인공제대상금액 : scxpsPrsDdcTrgtAmt */
//		ye161080Vo.setScxpsPrsDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsPrsDdcAmt(), "0")));    /** column 교육비_소득자본인공제세액 : scxpsPrsDdcAmt */
//		ye161080Vo.setScxpsKidUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsKidUseAmt(), "0")));    /** column 교육비_취학전아동납입금액 : scxpsKidUseAmt */
//		ye161080Vo.setScxpsKidDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsKidDdcTrgtAmt(), "0")));    /** column 교육비_취학전아동공제대상금액 : scxpsKidDdcTrgtAmt */
//		ye161080Vo.setScxpsKidDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsKidDdcAmt(), "0")));    /** column 교육비_취학전아동공제새액 : scxpsKidDdcAmt */
//		ye161080Vo.setScxpsStdUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsStdUseAmt(), "0")));    /** column 교육비_초중고등학교납입금액 : scxpsStdUseAmt */
//		ye161080Vo.setScxpsStdDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsStdDdcTrgtAmt(), "0")));    /** column 교육비_초중고등학교공제대상금액 : scxpsStdDdcTrgtAmt */
//		ye161080Vo.setScxpsStdDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsStdDdcAmt(), "0")));    /** column 교육비_초중고등학교공제세액 : scxpsStdDdcAmt */
//		ye161080Vo.setScxpsUndUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsUndUseAmt(), "0")));    /** column 교육비_대학생납입금액 : scxpsUndUseAmt */
//		ye161080Vo.setScxpsUndDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsUndDdcTrgtAmt(), "0")));    /** column 교육비_대학생공제대상금액 : scxpsUndDdcTrgtAmt */
//		ye161080Vo.setScxpsUndDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsUndDdcAmt(), "0")));    /** column 교육비_대상생공제세액 : scxpsUndDdcAmt */
		ye161080Vo.setScxpsDsbrUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsDsbrUseAmt(), "0")));    /** column 교육비_장애인납입금액 : scxpsDsbrUseAmt */
//		ye161080Vo.setScxpsDsbrDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsDsbrDdcTrgtAmt(), "0")));    /** column 교육비_장애인공제대상금액 : scxpsDsbrDdcTrgtAmt */
//		ye161080Vo.setScxpsDsbrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsDsbrDdcAmt(), "0")));    /** column 교육비_장애인공제세액 : scxpsDsbrDdcAmt */
//		ye161080Vo.setScxpsKidCount(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsKidCount(), "0")));    /** column 교육비_취학전아동인원수 : scxpsKidCount */
//		ye161080Vo.setScxpsStdCount(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsStdCount(), "0")));    /** column 교육비_초중고등학교인원수 : scxpsStdCount */
//		ye161080Vo.setScxpsUndCount(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsUndCount(), "0")));    /** column 교육비_대학생인원수 : scxpsUndCount */
//		ye161080Vo.setScxpsDsbrCount(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsDsbrCount(), "0")));    /** column 교육비_장애인인원수 : scxpsDsbrCount */
//		ye161080Vo.setScxpsUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsUseAmtSum(), "0")));    /** column 교육비납입금액합계 : scxpsUseAmtSum */
//		ye161080Vo.setScxpsDdcTrgtAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsDdcTrgtAmtSum(), "0")));    /** column 교육비공제대상금액합계 : scxpsDdcTrgtAmtSum */
//		ye161080Vo.setScxpsDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getScxpsDdcAmtSum(), "0")));    /** column 교육비공제세액금액합계 : scxpsDdcAmtSum */

		ye161080Vo.setIsmt(sessionUser.getUsrId());    																					/** column 수정자 : ismt */
		ye161080Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());   	 										/** column 수정주소 : revnAddr */
		
		
		try{
			
			ye161080DAO.updateYeta5300ToYe161080tabItem08_3(ye161080Vo);
			
			BeanUtils.copyProperties(infcPkgYe161010Vo , ye161080Vo);  
			yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE161080");
			
			result = 1;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
		return result;
	
	}
	
	
	/** 세액감면및세액공제1 - 교육비(grid) 금액 수정 **/
	@Override
	public Long saveYeta5300ToYe161090tabItem08_3(List<Ye161090DTO> listYe161090Dto, ActionDatabase actionDatabase) throws Exception {
		
		String method = calledClass + ".saveYeta5300ToYe161090tabItem08_3";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		Long result = new Long(1);
		Long iCnt = new Long(0);

		BigDecimal seqn = new BigDecimal(0);
		Ye161090DTO ye161090Dto = new Ye161090DTO();
		Ye161090_2020_VO ye161090Vo = new Ye161090_2020_VO();

		try {

			for (int iYetaCnt = 0; iYetaCnt < listYe161090Dto.size(); iYetaCnt++) {

				// 1. 암호화 객체 생성
        		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        		
        		
        		ye161090Dto = new Ye161090DTO(); 
        		ye161090Dto = listYe161090Dto.get(iYetaCnt);  
        		
        		ye161090Vo = new Ye161090_2020_VO();
        		
        		ye161090Vo.setDpobCd(ye161090Dto.getDpobCd());    																					/** column 사업장코드 : dpobCd */
        		ye161090Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161090Dto.getYrtxBlggYr()));    												/** column 귀속연도 : yrtxBlggYr */
        		ye161090Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161090Dto.getClutSeptCd()));    												/** column 연말정산구분코드 : clutSeptCd */
        		ye161090Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161090Dto.getSystemkey()));    													/** column SYSTEMKEY : systemkey */
        		
        		ye161090Vo.setCdVvalKrnCd(MSFSharedUtils.allowNulls(ye161090Dto.getCdVvalKrnCd()));    												/** column 소득공제명세자료구분코드 : cdVvalKrnCd */
        		
        		ye161090Vo.setFamResnoEncCntn(AnyCryptUtils.getEncSyncCrypt(nResult
        				, MSFSharedUtils.allowNulls(ye161090Dto.getFamResnoEncCntn()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));				/** column 가족주민등록번호 : famResnoEncCntn */
        		ye161090Vo.setScxpsStd(MSFSharedUtils.allowNulls(ye161090Dto.getScxpsStd()));    													/** column 교육비공제대상구분코드 : scxpsStd */
	        	ye161090Vo.setScxpsUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161090Dto.getScxpsUseAmt(), "0")));    						/** column 교육비지출금액 : scxpsUseAmt */
	        	ye161090Vo.setScxpsStdDdcTrgtIndvAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161090Dto.getScxpsStdDdcTrgtIndvAmt(), "0")));	/** column 개별공제대상금액 : scxpsStdDdcTrgtIndvAmt */   
        		
        		ye161090Vo.setIsmt(sessionUser.getUsrId());    																						/** column 수정자 : ismt */
        		ye161090Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    												/** column 수정주소 : revnAddr */
        		
            	
            	
            	switch (actionDatabase) {
				case INSERT:
					
					ye161090Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
					ye161090Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */
					
					ye161090DAO.insertYeta5300ToYe161090(ye161090Vo);
					
					break;
				case UPDATE:
					
					ye161090DAO.updateYeta5300ToYe161090(ye161090Vo);

					break;
				case DELETE:
					
					ye161090DAO.deleteYeta5300ToYe161090(ye161090Vo);
					
					break;
				}
				iCnt = iCnt + 1;
			}

			result = iCnt;

		} catch (Exception e) {
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			
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
	
	
	/** 세액감면및세액공제2tab 조회 **/
	public Ye161080DTO getYeta5300TabItem09ToYe161080Data(Ye161080DTO ye161080Dto) throws MSFException {
		

		Ye161080Srh_2020_VO ye161080SrhVo = new Ye161080Srh_2020_VO();
		MSFSysm0100BM sessionUser;

		String method = calledClass + ".getYeta5300TabItem09ToYe161080Data";

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(ye161080DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
							.getSession().getServletContext());
			ye161080DAO = (Ye161080_2020_DAO) wac.getBean("Ye161080_2020_DAO");
		}
		

		/** 조건절 */
		ye161080SrhVo.setDpobCd(ye161080Dto.getDpobCd());   		/** column 사업장코드 : dpobCd */
		ye161080SrhVo.setYrtxBlggYr(ye161080Dto.getYrtxBlggYr());	/** column 귀속연도 : yrtxBlggYr */
		ye161080SrhVo.setClutSeptCd(ye161080Dto.getClutSeptCd());	/** column 연말정산구분코드 : clutSeptCd */
		ye161080SrhVo.setSystemkey(ye161080Dto.getSystemkey());    	/** column SYSTEMKEY : systemkey */

		Ye161080DTO returnYe161080Dto = new Ye161080DTO();
		
		List egovResultDataList = new ArrayList();

		try {
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
			egovResultDataList = ye161080DAO.selectYeta5300ToYe161080tabItem09List(ye161080SrhVo);
			
			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";

			if (egovResultDataList != null && egovResultDataList.size() > 0) {
				
				for (int i = 0; i < egovResultDataList.size(); i++) {

					Map tempMap = (Map) egovResultDataList.get(i);
					
					returnYe161080Dto.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    												/** column 사업장코드 : dpobCd */
					returnYe161080Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(tempMap.get("yrtxBlggYr")));    										/** column 귀속연도 : yrtxBlggYr */
					returnYe161080Dto.setClutSeptCd(MSFSharedUtils.allowNulls(tempMap.get("clutSeptCd")));    										/** column 연말정산구분코드 : clutSeptCd */
					returnYe161080Dto.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));    										/** column SYSTEMKEY : systemkey */
					
					returnYe161080Dto.setFrgrLbrrEntcPupCd(MSFSharedUtils.allowNulls(tempMap.get("frgrLbrrEntcPupCd")));    						/** column 외국인근로자입국목적코드 : frgrLbrrEntcPupCd */
					
					 
					for(int x = 0; x < returnYe161080Dto.getFrgrLbrrEntcPupCd().length(); x++ ) {
						returnYe161080Dto.setFrgrLbrrEntcPupCd1( returnBool( Character.toString(returnYe161080Dto.getFrgrLbrrEntcPupCd().charAt(0))) ); 
						returnYe161080Dto.setFrgrLbrrEntcPupCd2( returnBool( Character.toString(returnYe161080Dto.getFrgrLbrrEntcPupCd().charAt(1))) ); 
						returnYe161080Dto.setFrgrLbrrEntcPupCd3( returnBool( Character.toString(returnYe161080Dto.getFrgrLbrrEntcPupCd().charAt(2))) ); 
						returnYe161080Dto.setFrgrLbrrEntcPupCd4( returnBool( Character.toString(returnYe161080Dto.getFrgrLbrrEntcPupCd().charAt(3))) ); 
					}
					
					returnYe161080Dto.setFrgrLbrrLbrOfrDt(MSFSharedUtils.allowNulls(tempMap.get("frgrLbrrLbrOfrDt")));    							/** column 외국인그론자기술도입계약_근로제공일자 : frgrLbrrLbrOfrDt */
					returnYe161080Dto.setFrgrLbrrReExryDt(MSFSharedUtils.allowNulls(tempMap.get("frgrLbrrReExryDt")));    							/** column 외국인근로자감면기간만료일자 : frgrLbrrReExryDt */
					returnYe161080Dto.setFrgrLbrrReRcpnDt(MSFSharedUtils.allowNulls(tempMap.get("frgrLbrrReRcpnDt")));    							/** column 외국인근로자외국인근로소득에대한감면접수일자 : frgrLbrrReRcpnDt */
					returnYe161080Dto.setFrgrLbrrReAlfaSbmsDt(MSFSharedUtils.allowNulls(tempMap.get("frgrLbrrReAlfaSbmsDt")));    					/** column 외국인근로자외국인근로소득에대한감면제출일자 : frgrLbrrReAlfaSbmsDt */
					returnYe161080Dto.setFrgrLbrrErinImnRcpnDt(MSFSharedUtils.allowNulls(tempMap.get("frgrLbrrErinImnRcpnDt")));    				/** column 외국인근로자근로소득에대한조세조약상면제접수일자 : frgrLbrrErinImnRcpnDt */
					returnYe161080Dto.setFrgrLbrrErinImnSbmsDt(MSFSharedUtils.allowNulls(tempMap.get("frgrLbrrErinImnSbmsDt")));    				/** column 외국인근로자근로소득에대한조세조약상면제제출일자 : frgrLbrrErinImnSbmsDt */
					returnYe161080Dto.setYupSnmcReStrtDt(MSFSharedUtils.allowNulls(tempMap.get("yupSnmcReStrtDt")));    							/** column 중소기업취업자감면취업일자 : yupSnmcReStrtDt */
					returnYe161080Dto.setYupSnmcReEndDt(MSFSharedUtils.allowNulls(tempMap.get("yupSnmcReEndDt")));    								/** column 중소기업취업자감면기간종료일자 : yupSnmcReEndDt */
					
					returnYe161080Dto.setOvrsSurcIncFmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("ovrsSurcIncFmt"), "0")));			/** column 외국납부세액_국외원천소득 : ovrsSurcIncFmt */
					returnYe161080Dto.setFrgnPmtFcTxamt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("frgnPmtFcTxamt"), "0")));    		/** column 외국납부세액_납세액_외화 : frgnPmtFcTxamt */
					returnYe161080Dto.setFrgnPmtWcTxamt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("frgnPmtWcTxamt"), "0")));    		/** column 외국납부세액_납세액_원화 : frgnPmtWcTxamt */
					returnYe161080Dto.setFrgnPmtTxamtTxpNtnNm(MSFSharedUtils.allowNulls(tempMap.get("frgnPmtTxamtTxpNtnNm")));    					/** column 외국납부세액납세국명 : frgnPmtTxamtTxpNtnNm */
					returnYe161080Dto.setFrgnPmtTxamtPmtDt(MSFSharedUtils.allowNulls(tempMap.get("frgnPmtTxamtPmtDt")));    						/** column 외국납부세액납부일자 : frgnPmtTxamtPmtDt */
					returnYe161080Dto.setFrgnPmtTxamtAlfaSbmsDt(MSFSharedUtils.allowNulls(tempMap.get("frgnPmtTxamtAlfaSbmsDt")));    				/** column 외국납부세액신청서제출일자 : frgnPmtTxamtAlfaSbmsDt */
					returnYe161080Dto.setFrgnPmtTxamtAbrdWkarNm(MSFSharedUtils.allowNulls(tempMap.get("frgnPmtTxamtAbrdWkarNm")));    				/** column 외국납부세액국외근무처명 : frgnPmtTxamtAbrdWkarNm */
					returnYe161080Dto.setFrgnDtyTermStdt(MSFSharedUtils.allowNulls(tempMap.get("frgnDtyTermStdt")));    							/** column 외국납부세액_근무기간시작일자 : frgnDtyTermStdt */
					returnYe161080Dto.setFrgnDtyTermEddt(MSFSharedUtils.allowNulls(tempMap.get("frgnDtyTermEddt")));    							/** column 외국납부세액_근무기간종료일자 : frgnDtyTermEddt */
					returnYe161080Dto.setFrgnPmtTxamtRfoNm(MSFSharedUtils.allowNulls(tempMap.get("frgnPmtTxamtRfoNm")));    						/** column 외국납부세액직책 : frgnPmtTxamtRfoNm */
					returnYe161080Dto.setHsngTennLnpbUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("hsngTennLnpbUseAmt"), "0")));	/** column 주택자금차입금이자세액공제이자상환액 : hsngTennLnpbUseAmt */
					returnYe161080Dto.setHsngTennLnpbDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("hsngTennLnpbDdcAmt"), "0")));	/** column 주택자금차입금이자세액공제세액금액 : hsngTennLnpbDdcAmt */
					returnYe161080Dto.setMmrUseAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mmrUseAmt"), "0")));    					/** column 월세액세액공제지출금액 : mmrUseAmt */
					returnYe161080Dto.setMmrDdcAmt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("mmrDdcAmt"), "0")));    					/** column 월세액세액공제공제세액 : mmrDdcAmt */
					
					returnYe161080Dto.setYetaC114(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaC114"), "0")));    					/** column C114_세액감면_소득세법감면금액 : yetaC114 */
					returnYe161080Dto.setYetaC115(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaC115"), "0")));    					/** column C115_세액감면_조특법_조세조약제외_감면금액 : yetaC115 */
					returnYe161080Dto.setYetaC116(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaC116"), "0")));    					/** column C116_세액감면_조특범30조_감면금액 : yetaC116 */
					returnYe161080Dto.setYetaC117(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaC117"), "0")));    					/** column C117_세액감면_조세조약감면금액 : yetaC117 */
//					returnYe161080Dto.setYetaC119(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yetaC119"), "0")));    					/** column C119_세액감면합계금액 : yetaC119 */
					
					returnYe161080Dto.setTxlgItctAmnt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("txlgItctAmnt"), "0")));    			/** column 세액감면_소득세법감면세액 : txlgItctAmnt */
					returnYe161080Dto.setTxlgBstaAmnt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("txlgBstaAmnt"), "0")));    			/** column 세액감면_취업청년감면대상총급여액 : txlgBstaAmnt */
					returnYe161080Dto.setTxlgWktaAmnt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("txlgWktaAmnt"), "0")));    			/** column 세액감면_취업청년감면근로자총급여액 : txlgWktaAmnt */
					returnYe161080Dto.setTxlgCltaAmnt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("txlgCltaAmnt"), "0")));    			/** column 세액감면_계산감면세액금액 : txlgCltaAmnt */
					returnYe161080Dto.setTxlgFrtaAmnt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("txlgFrtaAmnt"), "0")));   	 		/** column 세액감면_외국인기술자감면세액 : txlgFrtaAmnt */
					returnYe161080Dto.setTxlgTxtyAmnt(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("txlgTxtyAmnt"), "0")));    			/** column 세액감면_조세조약감면세액 : txlgTxtyAmnt */
					
					
				}
			}

		} catch (Exception ex) {
			
			ex.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
			
		}
		
		/** 로그반영
		 * CRUDSBLO 
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass,"S");

		return returnYe161080Dto;

	}
		
	
	/** 세액감면및세액공제2 금액 수정 **/
	@Override
	public int saveYeta5300ToYe161080tabItem09(Ye161080DTO ye161080Dto)throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		String method = calledClass + ".saveYeta5300ToYe161080tabItem09";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";
		
		InfcPkgYe161010_2020_VO infcPkgYe161010Vo = new InfcPkgYe161010_2020_VO(); 
		Yeta5300ListenerAdapter  yeta5300ListenerAdt = new Yeta5300ListenerAdapter();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		Ye161080_2020_VO ye161080Vo = new Ye161080_2020_VO();
		Ye169010_2020_VO ye169010Vo = new Ye169010_2020_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		try{
			
			ye161080Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161080Dto.getDpobCd()));    											/** column 사업장코드 : dpobCd */
			ye161080Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161080Dto.getYrtxBlggYr()));    									/** column 귀속연도 : yrtxBlggYr */
			ye161080Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161080Dto.getClutSeptCd()));    									/** column 연말정산구분코드 : clutSeptCd */
			ye161080Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161080Dto.getSystemkey()));    										/** column SYSTEMKEY : systemkey */
			
			ye161080Vo.setFrgrLbrrEntcPupCd(MSFSharedUtils.allowNulls(ye161080Dto.getFrgrLbrrEntcPupCd()));    						/** column 외국인근로자입국목적코드 : frgrLbrrEntcPupCd */
			ye161080Vo.setFrgrLbrrLbrOfrDt(MSFSharedUtils.allowNulls(ye161080Dto.getFrgrLbrrLbrOfrDt()));    						/** column 외국인그론자기술도입계약_근로제공일자 : frgrLbrrLbrOfrDt */
			ye161080Vo.setFrgrLbrrReExryDt(MSFSharedUtils.allowNulls(ye161080Dto.getFrgrLbrrReExryDt()));    						/** column 외국인근로자감면기간만료일자 : frgrLbrrReExryDt */
			ye161080Vo.setFrgrLbrrReRcpnDt(MSFSharedUtils.allowNulls(ye161080Dto.getFrgrLbrrReRcpnDt()));    						/** column 외국인근로자외국인근로소득에대한감면접수일자 : frgrLbrrReRcpnDt */
			ye161080Vo.setFrgrLbrrReAlfaSbmsDt(MSFSharedUtils.allowNulls(ye161080Dto.getFrgrLbrrReAlfaSbmsDt()));   				/** column 외국인근로자외국인근로소득에대한감면제출일자 : frgrLbrrReAlfaSbmsDt */
			ye161080Vo.setFrgrLbrrErinImnRcpnDt(MSFSharedUtils.allowNulls(ye161080Dto.getFrgrLbrrErinImnRcpnDt()));    				/** column 외국인근로자근로소득에대한조세조약상면제접수일자 : frgrLbrrErinImnRcpnDt */
			ye161080Vo.setFrgrLbrrErinImnSbmsDt(MSFSharedUtils.allowNulls(ye161080Dto.getFrgrLbrrErinImnSbmsDt()));    				/** column 외국인근로자근로소득에대한조세조약상면제제출일자 : frgrLbrrErinImnSbmsDt */
			ye161080Vo.setYupSnmcReStrtDt(MSFSharedUtils.allowNulls(ye161080Dto.getYupSnmcReStrtDt()));    							/** column 중소기업취업자감면취업일자 : yupSnmcReStrtDt */
			ye161080Vo.setYupSnmcReEndDt(MSFSharedUtils.allowNulls(ye161080Dto.getYupSnmcReEndDt()));    							/** column 중소기업취업자감면기간종료일자 : yupSnmcReEndDt */
			
			
			ye161080Vo.setOvrsSurcIncFmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getOvrsSurcIncFmt(), "0")));    	/** column 외국납부세액_국외원천소득 : ovrsSurcIncFmt */
			ye161080Vo.setFrgnPmtFcTxamt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getFrgnPmtFcTxamt(), "0")));    	/** column 외국납부세액_납세액_외화 : frgnPmtFcTxamt */
			ye161080Vo.setFrgnPmtWcTxamt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getFrgnPmtWcTxamt(), "0")));    	/** column 외국납부세액_납세액_원화 : frgnPmtWcTxamt */
			
			ye161080Vo.setFrgnPmtTxamtTxpNtnNm(MSFSharedUtils.allowNulls(ye161080Dto.getFrgnPmtTxamtTxpNtnNm()));    				/** column 외국납부세액납세국명 : frgnPmtTxamtTxpNtnNm */
			ye161080Vo.setFrgnPmtTxamtPmtDt(MSFSharedUtils.allowNulls(ye161080Dto.getFrgnPmtTxamtPmtDt()));    						/** column 외국납부세액납부일자 : frgnPmtTxamtPmtDt */
			ye161080Vo.setFrgnPmtTxamtAlfaSbmsDt(MSFSharedUtils.allowNulls(ye161080Dto.getFrgnPmtTxamtAlfaSbmsDt()));    			/** column 외국납부세액신청서제출일자 : frgnPmtTxamtAlfaSbmsDt */
			ye161080Vo.setFrgnPmtTxamtAbrdWkarNm(MSFSharedUtils.allowNulls(ye161080Dto.getFrgnPmtTxamtAbrdWkarNm()));    			/** column 외국납부세액국외근무처명 : frgnPmtTxamtAbrdWkarNm */
			ye161080Vo.setFrgnDtyTermStdt(MSFSharedUtils.allowNulls(ye161080Dto.getFrgnDtyTermStdt()));    							/** column 외국납부세액_근무기간시작일자 : frgnDtyTermStdt */
			ye161080Vo.setFrgnDtyTermEddt(MSFSharedUtils.allowNulls(ye161080Dto.getFrgnDtyTermEddt()));    							/** column 외국납부세액_근무기간종료일자 : frgnDtyTermEddt */
			ye161080Vo.setFrgnPmtTxamtRfoNm(MSFSharedUtils.allowNulls(ye161080Dto.getFrgnPmtTxamtRfoNm()));    						/** column 외국납부세액직책 : frgnPmtTxamtRfoNm */
			ye161080Vo.setHsngTennLnpbUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getHsngTennLnpbUseAmt(), "0")));/** column 주택자금차입금이자세액공제이자상환액 : hsngTennLnpbUseAmt */
			ye161080Vo.setHsngTennLnpbDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getHsngTennLnpbDdcAmt(), "0")));/** column 주택자금차입금이자세액공제세액금액 : hsngTennLnpbDdcAmt */
			
			
			
			ye161080Vo.setTxlgItctAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getTxlgItctAmnt(), "0")));    /** column 세액감면_소득세법감면세액 : txlgItctAmnt */
			ye161080Vo.setTxlgBstaAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getTxlgBstaAmnt(), "0")));    /** column 세액감면_취업청년감면대상총급여액 : txlgBstaAmnt */
			ye161080Vo.setTxlgWktaAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getTxlgWktaAmnt(), "0")));    /** column 세액감면_취업청년감면근로자총급여액 : txlgWktaAmnt */
			ye161080Vo.setTxlgCltaAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getTxlgCltaAmnt(), "0")));    /** column 세액감면_계산감면세액금액 : txlgCltaAmnt */
			ye161080Vo.setTxlgFrtaAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getTxlgFrtaAmnt(), "0")));    /** column 세액감면_외국인기술자감면세액 : txlgFrtaAmnt */
			ye161080Vo.setTxlgTxtyAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getTxlgTxtyAmnt(), "0")));    /** column 세액감면_조세조약감면세액 : txlgTxtyAmnt */
			
			ye161080Vo.setIsmt(sessionUser.getUsrId());    																	/** column 수정자 : ismt */
			ye161080Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());   	 						/** column 수정주소 : revnAddr */
			
			
			
			
			ye169010Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161080Dto.getDpobCd()));    							/** column 사업장코드 : dpobCd */
			ye169010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161080Dto.getYrtxBlggYr()));    					/** column 귀속연도 : yrtxBlggYr */
			ye169010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161080Dto.getClutSeptCd()));    					/** column 연말정산구분코드 : clutSeptCd */
			ye169010Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161080Dto.getSystemkey()));    						/** column SYSTEMKEY : systemkey */
			
			ye169010Vo.setYetaC114(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getYetaC114(), "0")));    /** column C114_세액감면_소득세법감면금액 : yetaC114 */
			ye169010Vo.setYetaC115(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getYetaC115(), "0")));    /** column C115_세액감면_조특법_조세조약제외_감면금액 : yetaC115 */
			ye169010Vo.setYetaC116(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getYetaC116(), "0")));    /** column C116_세액감면_조특범30조_감면금액 : yetaC116 */
			ye169010Vo.setYetaC117(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getYetaC117(), "0")));    /** column C117_세액감면_조세조약감면금액 : yetaC117 */
			
			ye169010Vo.setIsmt(sessionUser.getUsrId());    															/** column 수정자 : ismt */
			ye169010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());   	 				/** column 수정주소 : revnAddr */
		
		
//		ye161080Vo.setMmrUseAmt(ye161080Dto.getMmrUseAmt());    /** column 월세액세액공제지출금액 : mmrUseAmt */
//		ye161080Vo.setMmrDdcAmt(ye161080Dto.getMmrDdcAmt());    /** column 월세액세액공제공제세액 : mmrDdcAmt */
		
//		ye161080Vo.setCd218(ye161080Dto.getCd218());    /** column 신고인성명 : cd218 */
//		ye161080Vo.setD219(ye161080Dto.getD219());    /** column 외국인근로자단일세율적용신청서제출여부 : d219 */
//		ye161080Vo.setPrcspWorkIncmSumtYn(ye161080Dto.getPrcspWorkIncmSumtYn());    /** column 종근무지근로소득명세서제출여부 : prcspWorkIncmSumtYn */
//		ye161080Vo.setCd226(ye161080Dto.getCd226());    /** column 월세액거주자간주책입차차입금원리금상환액소득세액공제명세서제출여부 : cd226 */
		
//		ye161080Vo.setCd227(ye161080Dto.getCd227());    /** column 의료비지급명세서제출여부 : cd227 */
//		ye161080Vo.setCd228(ye161080Dto.getCd228());    /** column 기부금명세서제출여부 : cd228 */
//		ye161080Vo.setCd225(ye161080Dto.getCd225());    /** column 연금저축등소득세액공제명세서제출여부 : cd225 */
		
		
//		ye161080Vo.setIncmDducWtnnteSumtDt(ye161080Dto.getIncmDducWtnnteSumtDt());    /** column 소득공제신고서제출일자 : incmDducWtnnteSumtDt */
		
		

			
			ye161080DAO.updateYeta5300ToYe161080tabItem09(ye161080Vo);
			ye169010DAO.updateYeta5300ToYe169010tabItem09(ye169010Vo);
			
			
			BeanUtils.copyProperties(infcPkgYe161010Vo , ye161080Vo);  
			yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE161080");
			
			result = 1;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
		return result;
	}
	

	
	/** 추가제출서류tab 조회 **/
	public Ye161080DTO getYeta5300TabItem10ToYe161080Data(Ye161080DTO ye161080Dto) throws MSFException {
		

		Ye161080Srh_2020_VO ye161080SrhVo = new Ye161080Srh_2020_VO();
		MSFSysm0100BM sessionUser;

		String method = calledClass + ".getYeta5300TabItem10ToYe161080Data";

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(ye161080DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
							.getSession().getServletContext());
			ye161080DAO = (Ye161080_2020_DAO) wac.getBean("Ye161080_2020_DAO");
		}
		

		/** 조건절 */
		ye161080SrhVo.setDpobCd(ye161080Dto.getDpobCd());   		/** column 사업장코드 : dpobCd */
		ye161080SrhVo.setYrtxBlggYr(ye161080Dto.getYrtxBlggYr());	/** column 귀속연도 : yrtxBlggYr */
		ye161080SrhVo.setClutSeptCd(ye161080Dto.getClutSeptCd());	/** column 연말정산구분코드 : clutSeptCd */
		ye161080SrhVo.setSystemkey(ye161080Dto.getSystemkey());    	/** column SYSTEMKEY : systemkey */

		Ye161080DTO returnYe161080Dto = new Ye161080DTO();
		
		List egovResultDataList = new ArrayList();

		try {
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
			egovResultDataList = ye161080DAO.selectYeta5300ToYe161080tabItem10List(ye161080SrhVo);
			
			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";

			if (egovResultDataList != null && egovResultDataList.size() > 0) {
				
				for (int i = 0; i < egovResultDataList.size(); i++) {

					Map tempMap = (Map) egovResultDataList.get(i);
					
					returnYe161080Dto.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    							/** column 사업장코드 : dpobCd */
					returnYe161080Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(tempMap.get("yrtxBlggYr")));    					/** column 귀속연도 : yrtxBlggYr */
					returnYe161080Dto.setClutSeptCd(MSFSharedUtils.allowNulls(tempMap.get("clutSeptCd")));    					/** column 연말정산구분코드 : clutSeptCd */
					returnYe161080Dto.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));    					/** column SYSTEMKEY : systemkey */
					
					returnYe161080Dto.setD219(MSFSharedUtils.allowNulls(tempMap.get("d219")));    								/** column 외국인근로자단일세율적용신청서제출여부 : d219 */
					returnYe161080Dto.setPrcspWorkIncmSumtYn(MSFSharedUtils.allowNulls(tempMap.get("prcspWorkIncmSumtYn")));	/** column 종근무지근로소득명세서제출여부 : prcspWorkIncmSumtYn */
					returnYe161080Dto.setCd225(MSFSharedUtils.allowNulls(tempMap.get("cd225")));    							/** column 연금저축등소득세액공제명세서제출여부 : cd225 */
					returnYe161080Dto.setCd226(MSFSharedUtils.allowNulls(tempMap.get("cd226")));    							/** column 월세액거주자간주책입차차입금원리금상환액소득세액공제명세서제출여부 : cd226 */
					returnYe161080Dto.setCd227(MSFSharedUtils.allowNulls(tempMap.get("cd227")));    							/** column 의료비지급명세서제출여부 : cd227 */
					returnYe161080Dto.setCd228(MSFSharedUtils.allowNulls(tempMap.get("cd228")));    							/** column 기부금명세서제출여부 : cd228 */
					returnYe161080Dto.setIncmDducWtnnteSumtDt(MSFSharedUtils.allowNulls(tempMap.get("incmDducWtnnteSumtDt"))); 	/** column 소득공제신고서제출일자 : incmDducWtnnteSumtDt */
					returnYe161080Dto.setFileAppPaprSbtYn(MSFSharedUtils.allowNulls(tempMap.get("fileAppPaprSbtYn")));    		/** column 소득공제신고파일제출여부 : fileAppPaprSbtYn */
					
				}
			}

		} catch (Exception ex) {
			
			ex.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
			
		}
		
		/** 로그반영
		 * CRUDSBLO 
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass,"S");

		return returnYe161080Dto;

	}	
	
	
	/** 추가제출서류 수정 **/
	@Override
	public int saveYeta5300ToYe161080tabItem10(Ye161080DTO ye161080Dto)throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		String method = calledClass + ".saveYeta5300ToYe161080tabItem10";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		Ye161080_2020_VO ye161080Vo = new Ye161080_2020_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		ye161080Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161080Dto.getDpobCd()));    							/** column 사업장코드 : dpobCd */
		ye161080Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161080Dto.getYrtxBlggYr()));    					/** column 귀속연도 : yrtxBlggYr */
		ye161080Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161080Dto.getClutSeptCd()));    					/** column 연말정산구분코드 : clutSeptCd */
		ye161080Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161080Dto.getSystemkey()));    						/** column SYSTEMKEY : systemkey */
		
		
		ye161080Vo.setD219(MSFSharedUtils.allowNulls(ye161080Dto.getD219()));    								/** column 외국인근로자단일세율적용신청서제출여부 : d219 */
		ye161080Vo.setPrcspWorkIncmSumtYn(MSFSharedUtils.allowNulls(ye161080Dto.getPrcspWorkIncmSumtYn()));		/** column 종근무지근로소득명세서제출여부 : prcspWorkIncmSumtYn */
		ye161080Vo.setCd226(MSFSharedUtils.allowNulls(ye161080Dto.getCd226()));    								/** column 월세액거주자간주책입차차입금원리금상환액소득세액공제명세서제출여부 : cd226 */
		
		ye161080Vo.setCd227(MSFSharedUtils.allowNulls(ye161080Dto.getCd227()));    								/** column 의료비지급명세서제출여부 : cd227 */
		ye161080Vo.setCd228(MSFSharedUtils.allowNulls(ye161080Dto.getCd228()));    								/** column 기부금명세서제출여부 : cd228 */
		ye161080Vo.setCd225(MSFSharedUtils.allowNulls(ye161080Dto.getCd225()));    								/** column 연금저축등소득세액공제명세서제출여부 : cd225 */
		
		ye161080Vo.setIncmDducWtnnteSumtDt(MSFSharedUtils.allowNulls(ye161080Dto.getIncmDducWtnnteSumtDt()));	/** column 소득공제신고서제출일자 : incmDducWtnnteSumtDt */
		ye161080Vo.setFileAppPaprSbtYn(MSFSharedUtils.allowNulls(ye161080Dto.getFileAppPaprSbtYn()));    		/** column 소득공제신고파일제출여부 : fileAppPaprSbtYn */		
		
		ye161080Vo.setIsmt(sessionUser.getUsrId());    															/** column 수정자 : ismt */
		ye161080Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());   	 				/** column 수정주소 : revnAddr */
		
		
		
//		ye161080Vo.setFrgrLbrrEntcPupCd(MSFSharedUtils.allowNulls(ye161080Dto.getFrgrLbrrEntcPupCd()));    						/** column 외국인근로자입국목적코드 : frgrLbrrEntcPupCd */
//		ye161080Vo.setFrgrLbrrLbrOfrDt(MSFSharedUtils.allowNulls(ye161080Dto.getFrgrLbrrLbrOfrDt()));    						/** column 외국인그론자기술도입계약_근로제공일자 : frgrLbrrLbrOfrDt */
//		ye161080Vo.setFrgrLbrrReExryDt(MSFSharedUtils.allowNulls(ye161080Dto.getFrgrLbrrReExryDt()));    						/** column 외국인근로자감면기간만료일자 : frgrLbrrReExryDt */
//		ye161080Vo.setFrgrLbrrReRcpnDt(MSFSharedUtils.allowNulls(ye161080Dto.getFrgrLbrrReRcpnDt()));    						/** column 외국인근로자외국인근로소득에대한감면접수일자 : frgrLbrrReRcpnDt */
//		ye161080Vo.setFrgrLbrrReAlfaSbmsDt(MSFSharedUtils.allowNulls(ye161080Dto.getFrgrLbrrReAlfaSbmsDt()));   				/** column 외국인근로자외국인근로소득에대한감면제출일자 : frgrLbrrReAlfaSbmsDt */
//		ye161080Vo.setFrgrLbrrErinImnRcpnDt(MSFSharedUtils.allowNulls(ye161080Dto.getFrgrLbrrErinImnRcpnDt()));    				/** column 외국인근로자근로소득에대한조세조약상면제접수일자 : frgrLbrrErinImnRcpnDt */
//		ye161080Vo.setFrgrLbrrErinImnSbmsDt(MSFSharedUtils.allowNulls(ye161080Dto.getFrgrLbrrErinImnSbmsDt()));    				/** column 외국인근로자근로소득에대한조세조약상면제제출일자 : frgrLbrrErinImnSbmsDt */
//		ye161080Vo.setYupSnmcReStrtDt(MSFSharedUtils.allowNulls(ye161080Dto.getYupSnmcReStrtDt()));    							/** column 중소기업취업자감면취업일자 : yupSnmcReStrtDt */
//		ye161080Vo.setYupSnmcReEndDt(MSFSharedUtils.allowNulls(ye161080Dto.getYupSnmcReEndDt()));    							/** column 중소기업취업자감면기간종료일자 : yupSnmcReEndDt */
//		
//		
//		ye161080Vo.setOvrsSurcIncFmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getOvrsSurcIncFmt(), "0")));    	/** column 외국납부세액_국외원천소득 : ovrsSurcIncFmt */
//		ye161080Vo.setFrgnPmtFcTxamt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getFrgnPmtFcTxamt(), "0")));    	/** column 외국납부세액_납세액_외화 : frgnPmtFcTxamt */
//		ye161080Vo.setFrgnPmtWcTxamt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getFrgnPmtWcTxamt(), "0")));    	/** column 외국납부세액_납세액_원화 : frgnPmtWcTxamt */
//		
//		ye161080Vo.setFrgnPmtTxamtTxpNtnNm(MSFSharedUtils.allowNulls(ye161080Dto.getFrgnPmtTxamtTxpNtnNm()));    				/** column 외국납부세액납세국명 : frgnPmtTxamtTxpNtnNm */
//		ye161080Vo.setFrgnPmtTxamtPmtDt(MSFSharedUtils.allowNulls(ye161080Dto.getFrgnPmtTxamtPmtDt()));    						/** column 외국납부세액납부일자 : frgnPmtTxamtPmtDt */
//		ye161080Vo.setFrgnPmtTxamtAlfaSbmsDt(MSFSharedUtils.allowNulls(ye161080Dto.getFrgnPmtTxamtAlfaSbmsDt()));    			/** column 외국납부세액신청서제출일자 : frgnPmtTxamtAlfaSbmsDt */
//		ye161080Vo.setFrgnPmtTxamtAbrdWkarNm(MSFSharedUtils.allowNulls(ye161080Dto.getFrgnPmtTxamtAbrdWkarNm()));    			/** column 외국납부세액국외근무처명 : frgnPmtTxamtAbrdWkarNm */
//		ye161080Vo.setFrgnDtyTerm(MSFSharedUtils.allowNulls(ye161080Dto.getFrgnDtyTerm()));   									/** column 외국납부세액_근무기간일자 : frgnDtyTerm */
//		ye161080Vo.setFrgnPmtTxamtRfoNm(MSFSharedUtils.allowNulls(ye161080Dto.getFrgnPmtTxamtRfoNm()));    						/** column 외국납부세액직책 : frgnPmtTxamtRfoNm */
//		
//		ye161080Vo.setHsngTennLnpbUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getHsngTennLnpbUseAmt(), "0")));/** column 주택자금차입금이자세액공제이자상환액 : hsngTennLnpbUseAmt */
//		ye161080Vo.setHsngTennLnpbDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161080Dto.getHsngTennLnpbDdcAmt(), "0")));/** column 주택자금차입금이자세액공제세액금액 : hsngTennLnpbDdcAmt */
		
		
//		ye161080Vo.setMmrUseAmt(ye161080Dto.getMmrUseAmt());    /** column 월세액세액공제지출금액 : mmrUseAmt */
//		ye161080Vo.setMmrDdcAmt(ye161080Dto.getMmrDdcAmt());    /** column 월세액세액공제공제세액 : mmrDdcAmt */
		
//		ye161080Vo.setCd218(ye161080Dto.getCd218());    /** column 신고인성명 : cd218 *
		

		
		try{
			
			ye161080DAO.updateYeta5300ToYe161080tabItem10(ye161080Vo);
			
			result = 1;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
		return result;
		
	}
	
	
	
	/** 인적공제 명세 추가 **/
	@Override
	public Long activityOnYeta5300ToYe161030(List<Ye161030DTO> listYe161030Dto, ActionDatabase actionDatabase)  throws MSFException {
		
		Long result = new Long(1);
		Long iCnt = new Long(0);
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";
		
		String method = calledClass + ".activityOnYeta5300ToYe161030";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		InfcPkgYe161010_2020_VO infcPkgYe161010Vo = new InfcPkgYe161010_2020_VO(); 
		Yeta5300ListenerAdapter  yeta5300ListenerAdt = new Yeta5300ListenerAdapter();
		
		  
		try { 
			Ye161020_2020_VO  ye161020Vo = new Ye161020_2020_VO();
			Ye161030_2020_VO  ye161030Vo = new Ye161030_2020_VO();
			Ye161040_2020_VO  ye161040Vo = new Ye161040_2020_VO();
			Ye164010_2020_VO  ye164010Vo = new Ye164010_2020_VO();
			Ye161090_2020_VO  ye161090Vo = new Ye161090_2020_VO();
			
			Ye161030DTO ye161030Dto = new Ye161030DTO();  
			
			
			InfcPkgPayr0530VO  tpPayr0530Vo = new InfcPkgPayr0530VO();
			InfcPkgPayr0530VO  payr0530Vo = new InfcPkgPayr0530VO();
			
			for(int iYetaCnt=0; iYetaCnt < listYe161030Dto.size(); iYetaCnt++) {

				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				
				ye161020Vo = new Ye161020_2020_VO(); 
				
				ye161030Dto = new Ye161030DTO();   
				ye161030Dto = listYe161030Dto.get(iYetaCnt);
				
       		      
				/** 인적공제명세  **/
				ye161030Vo = new Ye161030_2020_VO();
				
	            ye161030Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    					/** column 사업장코드 : dpobCd */
	            ye161030Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161030Dto.getYrtxBlggYr()));				/** column 귀속연도 : yrtxBlggYr */
	            ye161030Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161030Dto.getClutSeptCd()));				/** column 연말정산구분코드 : clutSeptCd */
	            ye161030Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161030Dto.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
	            
	            // 암호화
	            ye161030Vo.setTxprDscmNoCntn(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(ye161030Dto.getTxprDscmNoCntn()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));    /** column 주민등록번호 : txprDscmNoCntn */
	            
	            ye161030Vo.setSuptFmlyRltClCd(MSFSharedUtils.allowNulls(ye161030Dto.getSuptFmlyRltClCd()));				/** column 부양관계코드 : suptFmlyRltClCd */
	            ye161030Vo.setNnfClCd(MSFSharedUtils.allowNulls(ye161030Dto.getNnfClCd()));    							/** column 내외국인구분 : nnfClCd */
	            ye161030Vo.setTxprNm(MSFSharedUtils.allowNulls(ye161030Dto.getTxprNm()));    							/** column 성명 : txprNm */
	            ye161030Vo.setBscDdcClCd((Boolean.TRUE.equals(ye161030Dto.getBscDdcClCd()) ? "1" : "0"));    			/** column 기본공제여부 : bscDdcClCd */
	            ye161030Vo.setWmnDdcClCd((Boolean.TRUE.equals(ye161030Dto.getWmnDdcClCd()) ? "1" : "0"));   			/** column 부녀자여부 : wmnDdcClCd */
	            ye161030Vo.setSnprntFmlyDdcClCd((Boolean.TRUE.equals(ye161030Dto.getSnprntFmlyDdcClCd()) ? "1" : "0"));	/** column 한부모여부 : snprntFmlyDdcClCd */
	            ye161030Vo.setSccDdcClCd(((Boolean.TRUE.equals(ye161030Dto.getSccDdcClCd()) ? "1" : "0")));    			/** column 경로우대여부 : sccDdcClCd */
	            ye161030Vo.setDsbrDdcClCd(MSFSharedUtils.allowNulls(ye161030Dto.getDsbrDdcClCd()));    					/** column 장애인여부 : dsbrDdcClCd */
	            ye161030Vo.setChbtAtprDdcClCd((MSFSharedUtils.allowNulls(ye161030Dto.getChbtAtprDdcClCd())));			/** column 출산입양여부 : chbtAtprDdcClCd */
	            //ye161030Vo.setAge6Lt(((Boolean.TRUE.equals(ye161030Dto.getAge6Lt()) ? "1" : "0")));    					/** column 6세이하여부 : age6Lt */
	            ye161030Vo.setSchoolYn(((Boolean.TRUE.equals(ye161030Dto.getSchoolYn()) ? "1" : "0")));    				/** column 자녀취학여부 : schoolYn */
	            ye161030Vo.setEduDdcDvcd(((Boolean.TRUE.equals(ye161030Dto.getEduDdcDvcd()) ? "1" : "0")));    			/** column 교육비공제구분 : eduDdcDvcd */
	            ye161030Vo.setFamyRelaDivCd(MSFSharedUtils.allowNulls(ye161030Dto.getFamyRelaDivCd()));    				/** column 인사가족관계코드 : famyRelaDivCd */
	            ye161030Vo.setIsmt(sessionUser.getUsrId());    															/** column 수정자 : ismt */
	            ye161030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    					/** column 수정주소 : revnAddr */
	                	
	            
	            /** 의료비  **/
	            ye164010Vo = new Ye164010_2020_VO();
	            
	            ye164010Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161030Vo.getDpobCd()));    				/** column 사업장코드 : dpobCd */
	            ye164010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161030Vo.getYrtxBlggYr()));    		/** column 귀속연도 : yrtxBlggYr */
	            ye164010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161030Vo.getClutSeptCd()));    		/** column 연말정산구분코드 : clutSeptCd */
	            ye164010Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161030Vo.getSystemkey()));    			/** column SYSTEMKEY : systemkey */
	            ye164010Vo.setResnoEncCntn(MSFSharedUtils.allowNulls(ye161030Vo.getTxprDscmNoCntn()));		/** column 의료비공제대상자주민등록번호 : resnoEncCntn */
	            ye164010Vo.setIsmt(sessionUser.getUsrId());    												/** column 수정자 : ismt */
	            ye164010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 수정주소 : revnAddr */
	            
	            /** 교육비 **/
	            ye161090Vo = new Ye161090_2020_VO();
	            
	            ye161090Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161030Vo.getDpobCd()));    				/** column 사업장코드 : dpobCd */
	            ye161090Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161030Vo.getYrtxBlggYr()));    		/** column 귀속연도 : yrtxBlggYr */
	            ye161090Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161030Vo.getClutSeptCd()));    		/** column 연말정산구분코드 : clutSeptCd */
	            ye161090Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161030Vo.getSystemkey()));    			/** column SYSTEMKEY : systemkey */
	            ye161090Vo.setFamResnoEncCntn(MSFSharedUtils.allowNulls(ye161030Vo.getTxprDscmNoCntn()));   /** column 가족주민등록번호 : famResnoEncCntn */
	            ye161090Vo.setIsmt(sessionUser.getUsrId());    												/** column 수정자 : ismt */
	            ye161090Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 수정주소 : revnAddr */
	            
	            
	            
	            /** 인적소득 **/
	            ye161040Vo = new Ye161040_2020_VO();
	            
	            ye161040Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161030Vo.getDpobCd()));    				/** column 사업장코드 : dpobCd */
	            ye161040Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161030Vo.getYrtxBlggYr()));    		/** column 귀속연도 : yrtxBlggYr */
	            ye161040Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161030Vo.getClutSeptCd()));    		/** column 연말정산구분코드 : clutSeptCd */
	            ye161040Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161030Vo.getSystemkey()));    			/** column SYSTEMKEY : systemkey */
	            ye161040Vo.setTxprDscmNoCntn(MSFSharedUtils.allowNulls(ye161030Vo.getTxprDscmNoCntn()));    /** column 주민등록번호 : txprDscmNoCntn */
	            ye161040Vo.setIsmt(sessionUser.getUsrId());    												/** column 수정자 : ismt */
	            ye161040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 수정주소 : revnAddr */
	            
	            
	            tpPayr0530Vo = new InfcPkgPayr0530VO();
	          //TODO 가족수당,학비보조수당적용처리 추가 ..
	            tpPayr0530Vo.setDpobCd(ye161030Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
	            tpPayr0530Vo.setSystemkey(ye161030Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                tpPayr0530Vo.setPayFamyRsptSeilNum(new BigDecimal(payr0530Dto.getPayFamyRsptSeilNum()));    /** column 급여가족사항일련번호 : payFamyRsptSeilNum */
//                payr0530Vo.setPayFamyResnRegnNum(payr0530Dto.getPayFamyResnRegnNum());    /** column 급여가족주민번호 : payFamyResnRegnNum */
                tpPayr0530Vo.setPayFamyResnRegnNum(ye161030Vo.getTxprDscmNoCntn());	/** column 급여가족주민번호 : payFamyResnRegnNum */
                tpPayr0530Vo.setHanNm(ye161030Vo.getTxprNm());    					/** column 한글성명 : hanNm */
                tpPayr0530Vo.setFamyRelaDivCd(ye161030Vo.getFamyRelaDivCd());    	/** column 가족관계구분코드 : famyRelaDivCd */
//                tpPayr0530Vo.setFamyAllwPymtYn((Boolean.TRUE.equals(payr0530Dto.getFamyAllwPymtYn()) ? "Y" : "N"));    /** column 가족수당지급여부 : famyAllwPymtYn */
//                tpPayr0530Vo.setChdnChdRrgEpnsPymtYn((Boolean.TRUE.equals(payr0530Dto.getChdnChdRrgEpnsPymtYn()) ? "Y" : "N"));    /** column 자녀양육비지급여부 : chdnChdRrgEpnsPymtYn */
                tpPayr0530Vo.setFndtnDducYn("Y");    /** column 기본공제여부 : fndtnDducYn */
//                tpPayr0530Vo.setSpueDducYn((Boolean.TRUE.equals(ye161030Vo.getWmnDdcClCd()) ? "Y" : "N"));    /** column 배우자공제여부 : spueDducYn */
//                tpPayr0530Vo.setWmnDducYn((Boolean.TRUE.equals(ye161030Vo.getWmnDducYn()) ? "Y" : "N"));    /** column 부녀자공제여부 : wmnDducYn */
//                tpPayr0530Vo.setRftaGvstDducYn((Boolean.TRUE.equals(ye161030Vo.getRftaGvstDducYn()) ? "Y" : "N"));    /** column 경로우대공제여부 : rftaGvstDducYn */
//                tpPayr0530Vo.setDabpnDducYn((Boolean.TRUE.equals(ye161030Vo.getDabpnDducYn()) ? "Y" : "N"));    /** column 장애자공제여부 : dabpnDducYn */
//                tpPayr0530Vo.setSgpnFmlyDducYn((Boolean.TRUE.equals(ye161030Vo.getSgpnFmlyDducYn()) ? "Y" : "N"));    /** column 한가족공제여부 : sgpnFmlyDducYn */
//                tpPayr0530Vo.setChdnChdRrgEpnsDducYn((Boolean.TRUE.equals(ye161030Vo.getChdnChdRrgEpnsDducYn()) ? "Y" : "N"));    /** column 자녀양육비공제여부 : chdnChdRrgEpnsDducYn */
//                tpPayr0530Vo.setFamyExtpyDivCd(payr0530Dto.getFamyExtpyDivCd());    /** column 가족수당구분코드 : famyExtpyDivCd */
//                tpPayr0530Vo.setSchlExpnAdmclExtpyDivCd(payr0530Dto.getSchlExpnAdmclExtpyDivCd());    /** column 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
//                tpPayr0530Vo.setSchlExpnAdmclExtpySum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530Dto.getSchlExpnAdmclExtpySum(),"0")));    /** column 학비보조수당금액 : schlExpnAdmclExtpySum */
//                tpPayr0530Vo.setFamyExtpySum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530Dto.getFamyExtpySum(),"0")));    /** column 가족수당금액 : famyExtpySum */
//                tpPayr0530Vo.setSchlExpnExtpyPymtBgnnDt(payr0530Dto.getSchlExpnExtpyPymtBgnnDt());    /** column 학비수당지급시작일자 : schlExpnExtpyPymtBgnnDt */
//                tpPayr0530Vo.setSchlExpnExtpyPymtEndDt(payr0530Dto.getSchlExpnExtpyPymtEndDt());    /** column 학비수당지급종료일자 : schlExpnExtpyPymtEndDt */
	            
	            
				switch (actionDatabase) {

				case INSERT:
					
					ye161030Vo.setKybdr(sessionUser.getUsrId());    											/** column 입력자 : kybdr */
					ye161030Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 입력주소 : inptAddr */

					ye161030DAO.insertYeta5300ToYe161030(ye161030Vo);
					
					
					payr0530Vo = new InfcPkgPayr0530VO();
					payr0530Vo = ye161040DAO.selectPayr0530Check(tpPayr0530Vo);
					
//					payr0530Vo.setKybdr(sessionUser.getUsrId());    											/** column 입력자 : kybdr */
//					payr0530Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */
					
					
	                if (MSFSharedUtils.paramNotNull(payr0530Vo) && MSFSharedUtils.paramNotNull(payr0530Vo.getPayFamyResnRegnNum())) {
	                   
	                } else {
	                	ye161040DAO.insertPayr0530(tpPayr0530Vo);
	                }
					
					ye161040Vo.setKybdr(sessionUser.getUsrId());    											/** column 입력자 : kybdr */
					ye161040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 입력주소 : inptAddr */
					
					
					//  기존 삭제 시 누락처리 된 데이터를 위해 삭제 처리
					ye161040DAO.deleteYeta5300ToYe161040(ye161040Vo); 
					// 소득공제명세 데이터 추가 
					ye161040DAO.insertYeta5300ToYe161040_01(ye161040Vo);
					ye161040DAO.insertYeta5300ToYe161040_02(ye161040Vo);
					
					
					yeta5300ListenerAdt = new Yeta5300ListenerAdapter();
					BeanUtils.copyProperties(infcPkgYe161010Vo , ye161030Vo);  
//					yeta2300ListenerAdt.fnYeta2300_Ye161010_2017_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE166020_DELETE");
					yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE166020_NEW");
					yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE161030");
					
					break;
				case UPDATE:
					
					ye161030Vo.setIsmt(sessionUser.getUsrId());    												/** column 수정자 : ismt */
		            ye161030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 수정주소 : revnAddr */
					
					// 그리드 수정할 때만 udpate 사용
					if(ye161030Vo.getTxprDscmNoCntn() != null || !"".equals(ye161030Vo.getTxprDscmNoCntn())) {
						
						ye161030Vo.setIsmt(sessionUser.getUsrId());    											/** column 수정자 : ismt */
						ye161030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 수정주소 : revnAddr */

						ye161030DAO.updateYeta5300ToYe161030(ye161030Vo);
					}
		         
					ye161020Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    				/** column 사업장코드 : dpobCd */
					ye161020Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161030Dto.getYrtxBlggYr()));			/** column 귀속연도 : yrtxBlggYr */
					ye161020Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161030Dto.getClutSeptCd()));			/** column 연말정산구분코드 : clutSeptCd */
					ye161020Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161030Dto.getSystemkey()));    			/** column SYSTEMKEY : systemkey */
			            
					
					ye161020Vo.setPrifChngYn(MSFSharedUtils.allowNulls(ye161030Dto.getPrifChngYn())); 			/** column 인적공제항목변동여부 : prifChngYn */	
					ye161020Vo.setIsmt(sessionUser.getUsrId());    												/** column 수정자 : ismt */
					ye161020Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 수정주소 : revnAddr */
					
					ye161020DAO.updateYeta5300Item02ToYe161020(ye161020Vo);
					
					yeta5300ListenerAdt = new Yeta5300ListenerAdapter();
					BeanUtils.copyProperties(infcPkgYe161010Vo , ye161030Vo);  
					yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE166020_INSERT");
					yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE161030");
					
					break;
				case DELETE:
					
//					yeta3220Vo.setBeforeJumin(MSFSharedUtils.allowNulls(yeta3220Dto.getBeforeJumin().replace("-", "")));	//수정전 주민번호
					
					// 인적공제 관련 내역들을 같이 삭제 처리 해준다.
					// 1. 인적공제 내역 삭제
					ye161030DAO.deleteYeta5300ToYe161030(ye161030Vo);
					
					// 2. 의료비 내역
					ye164010DAO.deleteYeta5300ToYe164010(ye164010Vo);
					
					
					// 3. 교육비 내역
					ye161090DAO.deleteYeta5300ToYe161090(ye161090Vo); 
					
					
					// 4. 소득세액공제 명세 내역
					ye161040DAO.deleteYeta5300ToYe161040(ye161040Vo); 
					
					yeta5300ListenerAdt = new Yeta5300ListenerAdapter();
					BeanUtils.copyProperties(infcPkgYe161010Vo , ye161030Vo);  
					yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE166020_DELETE");
					
					break;
				}

				iCnt = iCnt + 1;
			}

			result = iCnt;
			
			/****************************************************************************************************************
			 * 연말정산 정리 쿼리 메서드 호출 확인 
			 ****************************************************************************************************************/

		} catch (Exception ex) {
	            //logger.error("EXCEPTION calling activityOnVoceMenu(): "+ex); 
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), ex, windowNm , windowId);
			
			result = new Long(0);
			ex.printStackTrace();
			throw MSFServerUtils.getOperationException("activityOnYeta5300ToYe161030", ex, logger);
		
		} finally {
	          
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

	
	/** 소득공제 tab 수정 **/ 
	@Override
	public int saveYeta5300ToYe1610400tabItem03(List<Ye161040DTO> listYe161040Dto_01, List<Ye161040DTO> listYe161040Dto_02)  throws MSFException {
		
		int result = 1;
		
		Ye161040DTO ye161040Dto = new Ye161040DTO();
		Ye161040_2020_VO ye161040Vo = new Ye161040_2020_VO();
		
		InfcPkgYe161010_2020_VO infcPkgYe161010Vo = new InfcPkgYe161010_2020_VO(); 
		Yeta5300ListenerAdapter  yeta5300ListenerAdt = new Yeta5300ListenerAdapter();


		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";
		
		String method = calledClass + ".saveYeta5300ToYe1610400tabItem03";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	 
		try {

			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	                
			for(int iYetaCnt=0; iYetaCnt < listYe161040Dto_01.size(); iYetaCnt++) {
				
				ye161040Vo = new Ye161040_2020_VO();
				ye161040Dto = new Ye161040DTO();  
				ye161040Dto = listYe161040Dto_01.get(iYetaCnt);   
      		        	
				ye161040Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161040Dto.getDpobCd()));    											/** column 사업장코드 : dpobCd */
				ye161040Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161040Dto.getYrtxBlggYr()));    									/** column 귀속연도 : yrtxBlggYr */
				ye161040Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161040Dto.getClutSeptCd()));    									/** column 연말정산구분코드 : clutSeptCd */
				ye161040Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161040Dto.getSystemkey()));    										/** column SYSTEMKEY : systemkey */
				ye161040Vo.setTxprDscmNoCntn(AnyCryptUtils.getEncSyncCrypt(nResult								
						, MSFSharedUtils.allowNulls(ye161040Dto.getTxprDscmNoCntn()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));		/** column 주민등록번호 : txprDscmNoCntn */
				
				ye161040Vo.setCdVvalKrnCd(MSFSharedUtils.allowNulls(ye161040Dto.getCdVvalKrnCd()));    									/** column 소득공제명세자료구분코드 : cdVvalKrnCd */
				
				
				ye161040Vo.setHifeDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getHifeDdcTrgtAmt(), "0")));    	/** column 건강등보험료 : hifeDdcTrgtAmt */
				ye161040Vo.setMcurUiTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getMcurUiTrgtAmt(), "0")));    		/** column 고용보험료 : mcurUiTrgtAmt */
				ye161040Vo.setCvrgInscDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getCvrgInscDdcTrgtAmt(), "0")));/** column 보장성보험료 : cvrgInscDdcTrgtAmt */
				ye161040Vo.setDsbrDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getDsbrDdcTrgtAmt(), "0")));    	/** column 장애인전용보장성보험료 : dsbrDdcTrgtAmt */
				ye161040Vo.setMdxpsDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getMdxpsDdcTrgtAmt(), "0")));    	/** column 의료비금액 : mdxpsDdcTrgtAmt */
				ye161040Vo.setScxpsDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getScxpsDdcTrgtAmt(), "0")));    	/** column 교육비금액 : scxpsDdcTrgtAmt */
				ye161040Vo.setCrdcDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getCrdcDdcTrgtAmt(), "0")));    	/** column 신용카드_전통대중제외금액 : crdcDdcTrgtAmt */
				ye161040Vo.setDrtpCardDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getDrtpCardDdcTrgtAmt(), "0")));/** column 직불카드등_전통대중제외금액 : drtpCardDdcTrgtAmt */
				ye161040Vo.setCshptDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getCshptDdcTrgtAmt(), "0")));    	/** column 현금영수증_전통대중제외금액 : cshptDdcTrgtAmt */
				ye161040Vo.setTdmrDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getTdmrDdcTrgtAmt(), "0")));    	/** column 전통시작사용금액 : tdmrDdcTrgtAmt */
				ye161040Vo.setPbtDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getPbtDdcTrgtAmt(), "0")));    		/** column 대중교통이용금액 : pbtDdcTrgtAmt */
				ye161040Vo.setBookShowAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getBookShowAmt(), "0")));    		/** column 도서이용금액 : bankShowAmt */
				ye161040Vo.setConbDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getConbDdcTrgtAmt(), "0")));    	/** column 기부금액 : conbDdcTrgtAmt */
//				ye161040Vo.setKybdr(ye161040Dto.getKybdr());    /** column 입력자 : kybdr */
//				ye161040Vo.setInptDt(ye161040Dto.getInptDt());    /** column 입력일자 : inptDt */
//				ye161040Vo.setInptAddr(ye161040Dto.getInptAddr());    /** column 입력주소 : inptAddr */
				ye161040Vo.setIsmt(sessionUser.getUsrId());   																			/** column 수정자 : ismt */
				ye161040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    									/** column 수정주소 : revnAddr */
	           
		      
		        ye161040DAO.updateYeta5300ToYe161040(ye161040Vo);
		        
		    	BeanUtils.copyProperties(infcPkgYe161010Vo , ye161040Vo);  
				yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE166020_INSERT");

			}
			 
			
			// TODO 개발로직 추가 필요 수정완료 후 합계 추가하는 부분으로  
//			 yeta2000DAO.updateYeta0300ToYeta2000_Item03(yeta2000Vo);  
			
			
		} catch (Exception ex) {
	            //logger.error("EXCEPTION calling activityOnVoceMenu(): "+ex); 
			result = 0;
			ex.printStackTrace();
			throw MSFServerUtils.getOperationException("saveYeta5300ToYe1610400tabItem03_1", ex, logger);
		
		} finally {
	          
		}
		
		
		try { 
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	                
			for(int iYetaCnt=0; iYetaCnt < listYe161040Dto_02.size(); iYetaCnt++) {
				
				ye161040Vo = new Ye161040_2020_VO();
				ye161040Dto = new Ye161040DTO();  
				ye161040Dto = listYe161040Dto_02.get(iYetaCnt);   
      		        	
				ye161040Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161040Dto.getDpobCd()));    											/** column 사업장코드 : dpobCd */
				ye161040Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161040Dto.getYrtxBlggYr()));    									/** column 귀속연도 : yrtxBlggYr */
				ye161040Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161040Dto.getClutSeptCd()));    									/** column 연말정산구분코드 : clutSeptCd */
				ye161040Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161040Dto.getSystemkey()));    										/** column SYSTEMKEY : systemkey */
				ye161040Vo.setTxprDscmNoCntn(AnyCryptUtils.getEncSyncCrypt(nResult								
						, MSFSharedUtils.allowNulls(ye161040Dto.getTxprDscmNoCntn()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));		/** column 주민등록번호 : txprDscmNoCntn */
				
				ye161040Vo.setCdVvalKrnCd(MSFSharedUtils.allowNulls(ye161040Dto.getCdVvalKrnCd()));    									/** column 소득공제명세자료구분코드 : cdVvalKrnCd */
				
				
				ye161040Vo.setHifeDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getHifeDdcTrgtAmt(), "0")));    	/** column 건강등보험료 : hifeDdcTrgtAmt */
				ye161040Vo.setMcurUiTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getMcurUiTrgtAmt(), "0")));    		/** column 고용보험료 : mcurUiTrgtAmt */
				ye161040Vo.setCvrgInscDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getCvrgInscDdcTrgtAmt(), "0")));/** column 보장성보험료 : cvrgInscDdcTrgtAmt */
				ye161040Vo.setDsbrDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getDsbrDdcTrgtAmt(), "0")));    	/** column 장애인전용보장성보험료 : dsbrDdcTrgtAmt */
				ye161040Vo.setMdxpsDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getMdxpsDdcTrgtAmt(), "0")));    	/** column 의료비금액 : mdxpsDdcTrgtAmt */
				ye161040Vo.setScxpsDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getScxpsDdcTrgtAmt(), "0")));    	/** column 교육비금액 : scxpsDdcTrgtAmt */
				ye161040Vo.setCrdcDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getCrdcDdcTrgtAmt(), "0")));    	/** column 신용카드_전통대중제외금액 : crdcDdcTrgtAmt */
				ye161040Vo.setDrtpCardDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getDrtpCardDdcTrgtAmt(), "0")));/** column 직불카드등_전통대중제외금액 : drtpCardDdcTrgtAmt */
				ye161040Vo.setCshptDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getCshptDdcTrgtAmt(), "0")));    	/** column 현금영수증_전통대중제외금액 : cshptDdcTrgtAmt */
				ye161040Vo.setTdmrDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getTdmrDdcTrgtAmt(), "0")));    	/** column 전통시작사용금액 : tdmrDdcTrgtAmt */
				ye161040Vo.setPbtDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getPbtDdcTrgtAmt(), "0")));    		/** column 대중교통이용금액 : pbtDdcTrgtAmt */
				ye161040Vo.setBookShowAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getBookShowAmt(), "0")));    		/** column 도서이용금액 : bankShowAmt */
				ye161040Vo.setConbDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161040Dto.getConbDdcTrgtAmt(), "0")));    	/** column 기부금액 : conbDdcTrgtAmt */
//				ye161040Vo.setKybdr(ye161040Dto.getKybdr());    /** column 입력자 : kybdr */
//				ye161040Vo.setInptDt(ye161040Dto.getInptDt());    /** column 입력일자 : inptDt */
//				ye161040Vo.setInptAddr(ye161040Dto.getInptAddr());    /** column 입력주소 : inptAddr */
				ye161040Vo.setIsmt(sessionUser.getUsrId());   																			/** column 수정자 : ismt */
				ye161040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    									/** column 수정주소 : revnAddr */
	           
		      
		        ye161040DAO.updateYeta5300ToYe161040(ye161040Vo);

			}
			
			/****************************************************************************************************************
			 * 연말정산 정리 쿼리 메서드 호출 확인 
			 ****************************************************************************************************************/
//			InfcPkgYe161010VO infcPkgYe161010Vo = new InfcPkgYe161010VO(); 
//			
//			BeanUtils.copyProperties(infcPkgYe161010Vo, ye161040Vo);  
//			
//			Yeta2300ListenerAdapter  yeta2300ListenerAdt = new Yeta2300ListenerAdapter(); 
			yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE166020_INSERT");
			
			// TODO 개발로직 추가 필요 수정완료 후 합계 추가하는 부분으로  
//			yeta2000DAO.updateYeta0300ToYeta2000_Item03(yeta2000Vo);  
			
		} catch (Exception ex) {
	            //logger.error("EXCEPTION calling activityOnVoceMenu(): "+ex); 
			result = 0;
			ex.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",ex, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException("saveYeta5300ToYe1610400tabItem03_2", ex, logger);
		
		} finally {

		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
		return result;

	}
	

	private Boolean returnBool (String val) {
		
		Boolean bool = false;
		
		if("Y".equals(val) || val == "Y" ) {
			bool = true;
		}
		
		return bool;
	}
	
	
   @Override
	 public PagingLoadResult<ShowMessageBM> fnYeta5300_Ye161010_2020_CalcTax(List<Ye161010DTO> listYe161010Dto) throws MSFException {

	    PagingLoadResult<ShowMessageBM> retval = null;

	  	String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";
		
    	String method = calledClass + ".fnYeta5300_Ye161010_2020_CalcTax";
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
       
        
        try {  
        
        	// 1. 암호화 객체 생성
		    //String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		        
		    	
        	List<InfcPkgYe161010_2020_VO> listYe161010VO = new ArrayList<InfcPkgYe161010_2020_VO>();
			 
              for (int iCnt = 0;iCnt < listYe161010Dto.size();iCnt++) { 
            	  
            	    Ye161010DTO ye161010Dto = new Ye161010DTO();   
	            	Ye161010_2020_VO  ye161010Vo = new Ye161010_2020_VO(); 
	        		
	            	InfcPkgYe161010_2020_VO infcPkgYe161010Vo = new InfcPkgYe161010_2020_VO();
	            	ye161010Dto = listYe161010Dto.get(iCnt);  
            	    
	            	infcPkgYe161010Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    					/** column 사업장코드 : dpobCd */
	            	infcPkgYe161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161010Dto.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
	            	infcPkgYe161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161010Dto.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
	            	infcPkgYe161010Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161010Dto.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
	            	infcPkgYe161010Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(ye161010Dto.getPayrMangDeptCd()));    	/** column 급여관리부서코드 : payrMangDeptCd */
	            	infcPkgYe161010Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(ye161010Dto.getEmymtDivCd()));    			/** column 당시_고용구분코드 : emymtDivCd */
	            	infcPkgYe161010Vo.setDeptCd(MSFSharedUtils.allowNulls(ye161010Dto.getDeptCd()));    					/** column 당시_부서코드 : deptCd */
	            	infcPkgYe161010Vo.setTypOccuCd(MSFSharedUtils.allowNulls(ye161010Dto.getTypOccuCd()));    				/** column 당시_직종코드 : typOccuCd */
	            	infcPkgYe161010Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(ye161010Dto.getDtilOccuInttnCd()));    	/** column 당시_직종세통합코드 : dtilOccuInttnCd */
	            	infcPkgYe161010Vo.setBusinCd(MSFSharedUtils.allowNulls(ye161010Dto.getBusinCd()));    					/** column 당시_사업코드 : businCd */
	               
	            	infcPkgYe161010Vo.setOdtyCd(ye161010Dto.getOdtyCd());    						/** column 직책코드 : odtyCd */
	            	infcPkgYe161010Vo.setPyspCd(ye161010Dto.getPyspCd());    						/** column 호봉코드 : pyspCd */
	            	infcPkgYe161010Vo.setLogSvcYrNumCd(ye161010Dto.getLogSvcYrNumCd());    		/** column 근속년수코드 : logSvcYrNumCd */
	            	infcPkgYe161010Vo.setLogSvcMnthIcmCd(ye161010Dto.getLogSvcMnthIcmCd());    	/** column 근속월수코드 : logSvcMnthIcmCd */
	            	infcPkgYe161010Vo.setFrstEmymtDt(ye161010Dto.getFrstEmymtDt());    			/** column 최초고용일자 : frstEmymtDt */
	            	infcPkgYe161010Vo.setEmymtBgnnDt(ye161010Dto.getEmymtBgnnDt());    			/** column 고용시작일자 : emymtBgnnDt */
	            	infcPkgYe161010Vo.setEmymtEndDt(ye161010Dto.getEmymtEndDt());    				/** column 고용종료일자 : emymtEndDt */
	            	infcPkgYe161010Vo.setHdofcDivCd(ye161010Dto.getHdofcDivCd());    				/** column 재직구분코드 : hdofcDivCd */
	            	infcPkgYe161010Vo.setRetryDt(ye161010Dto.getRetryDt());    					/** column 퇴직일자 : retryDt */
//					 
	            	listYe161010VO.add(infcPkgYe161010Vo);
	            	 
				 
               } 
               
         
           Yeta5300ListenerAdapter yetaLsAdtr = new Yeta5300ListenerAdapter();
           retval = yetaLsAdtr.fnYeta5300_Ye161010_2020_CalcTax(RemoteServiceUtil.getThreadLocalRequest(),listYe161010VO);
 
        }
        catch (Exception ex) {
        	 
            logger.error("EXCEPTION calling fnYeta5300_Ye161010_2017_CalcTax(): "+ex); 
            
            /** 에러 로그 **/			
            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C",ex, windowNm , windowId);
             
            throw MSFServerUtils.getOperationException("fnYeta5300_Ye161010_2020_CalcTax", ex, logger);
        }
        finally {
          
        }
        
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C");
      
        return retval;
} 
	   
	   
//   /** 소득공제신고자료관리 새로고침 **/
//   public Ye16Ta2000BM resultListYeta2000(Ye16Ta2000BM yeta2000Bm) throws MSFException {
//		
//
//				Yeta2000SrhVO yeta2000SrhVo = new Yeta2000SrhVO();
//				MSFSysm0100BM sessionUser;
//				
//				String method = calledClass + ".resultListYeta2000";
//			
//			String windowNm = "소득공제신고자료관리";
//			String windowId = "YETA1300";
//			
//			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
//				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//			} else {
//				sessionUser = getUser();
//			}
//		
//		
//			if  (MSFSharedUtils.paramNull(yeta2000DAO)) {
//				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//				yeta2000DAO = (Ye16Ta2000DAO) wac.getBean("Ye16Ta2000DAO" ); 
//			}
//			
//			List<String> listDeptCd = new ArrayList<String>();  
//		
//			/** 조건절 */
//			yeta2000SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
//			yeta2000SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(yeta2000Bm.getSettGbcd()));//정산구분
//			yeta2000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//		//	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
//		 	
//			yeta2000SrhVo.setUsrId(sessionUser.getUsrId());
//		 /******************************** 권한 ************************************************************************/
//		 String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//		 if ("FALSE".equals(chkDeptCd)) {
//		 	yeta2000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
//		    listDeptCd.add(sessionUser.getDeptCd());
//		    yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
//		    yeta2000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//		 } else {
//		 	yeta2000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(yeta2000Bm.getPayrMangDeptCd())) ;   //단위기관코드   
//		          if (yeta2000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(yeta2000Bm.getDeptCd()))) { 
//		          	 listDeptCd = null; 
//		          	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//		          	yeta2000SrhVo.setDeptCd("");  //부서코드
//		          } else {
//		         	 yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(yeta2000Bm.getDeptCd()));
//		               listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta2000Bm.getDeptCd()));  
//		               yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
//		          } 
//		 }
//		 
//		//         } else {
//		//         	
//		//         }
//		 
//		 yeta2000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(yeta2000Bm.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
//		 yeta2000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(yeta2000Bm.getDtilOccuInttnCd()).replace(",", ""));   
//		 
//		/******************************** 권한 ************************************************************************/
//		 	
//		 	
//		    yeta2000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(yeta2000Bm.getEmymtDivCd()));       //고용구분코드
//		        
//		//	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//		//	     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//		//	      	yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//		        
//		   	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta2000Bm.getTypOccuCd())); 
//		  	yeta2000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
//		 	yeta2000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(yeta2000Bm.getTypOccuCd()));  //직종
//		       
//		//	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//		//	     	yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//		//	     	yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
//		         
//		  	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta2000Bm.getDtilOccuInttnCd())); 
//		  	yeta2000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//		 	yeta2000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(yeta2000Bm.getDtilOccuInttnCd())); //직종세
//		         
//			yeta2000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(yeta2000Bm.getBusinCd()));   //사업코드
//		       
//		       
//			yeta2000SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta2000Bm.getEdacRvyy())); //년도
//		   	yeta2000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(yeta2000Bm.getSystemkey()));  //시스템키
//		  	yeta2000SrhVo.setHanNm(MSFSharedUtils.allowNulls(yeta2000Bm.getHanNm()));    //한글성명 
//		  	
//			/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
//		//	      	SysIfBass0320VO  sysIfBass0320Vo = new SysIfBass0320VO();
//		//	     	 List<String> listTypCd = new ArrayList<String>(); 
//		//	     	 
//		//	     	sysIfBass0320Vo.setYmdGb("Y");
//		//	     	sysIfBass0320Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYr")));
//		//	     	sysIfBass0320Vo.setTypOccuCd(psnl0100SrhVO.getTypOccuCd());
//		//	     	sysIfBass0320Vo.setTypOccuCdArr(lstTypeOccuCd); 
//		//	     	
//		//	     	listTypCd = SysifPkgServiceUtils.funcArrBeforTypOccuCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0320Vo);
//		 	
//		 	SysIfBass0350VO  sysIfBass0350Vo = new SysIfBass0350VO();
//		 //	 List<String> listTyInttnCd = new ArrayList<String>(); 
//		 	sysIfBass0350Vo.setDpobCd(sessionUser.getDpobCd());
//		 	sysIfBass0350Vo.setYmdGb("Y");
//		 	sysIfBass0350Vo.setStrDate(MSFSharedUtils.allowNulls(yeta2000Bm.getEdacRvyy()));
//		 	sysIfBass0350Vo.setTypOccuCd(yeta2000SrhVo.getTypOccuCd());
//		 	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
//			sysIfBass0350Vo.setDtilOccuInttnCd(yeta2000SrhVo.getDtilOccuInttnCd());
//		 	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//		 	
//		 	try {
//				sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0350Vo);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//		 
//		 	yeta2000SrhVo.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
//		 	yeta2000SrhVo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
//		 	
//		 	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/ 	
//		
//			int iResultCnt = yeta2000DAO.selectYeta0300To2000ListTotCnt(yeta2000SrhVo);  
//			
//			Ye16Ta2000BM returnYeta2000 = new Ye16Ta2000BM();
//			List egovResultDataList = new ArrayList();
//		
//			try {
//				
//				egovResultDataList =  yeta2000DAO.selectYeta0300To2000List(yeta2000SrhVo);
//				
//				// 2.복호화 리턴받을 값 선언
//				String rrnDecCrypt = "";
//		
//				if(egovResultDataList != null && egovResultDataList.size() > 0){
//					for(int i = 0 ; i < egovResultDataList.size(); i++){
//		
//						// 1. 암호화 객체 생성
//						String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//		
//						Map tempMap = (Map)egovResultDataList.get(i);
//						Iterator<String> keys = tempMap.keySet().iterator();
//						while( keys.hasNext() ){
//				            String key = keys.next();
//				            //형 타입이 숫자형일경우 형변환 해준다.
//			            	if(tempMap.get(key) instanceof java.math.BigDecimal){
//			            		returnYeta2000.set(key, String.valueOf(tempMap.get(key)));
//			            	}else{
//			            		
//			            		if("resnRegnNum".equals(key)) {
//			            			// 복호화
//			            			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(String.valueOf(tempMap.get(key))).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//			            			returnYeta2000.set(key, rrnDecCrypt);
//			            			
//			            		}else {
//			            			
//			            			returnYeta2000.set(key, tempMap.get(key));
//			            		}
//			            	}
//			            }
//					}
//				}
//			} catch (Exception ex) {
//				ex.printStackTrace();
//				
//				/** 에러 로그 **/			
//				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
//				
//				// Return operation exception
//			}
//			
//			/** 로그반영
//			 * CRUDSBLO
//			 * C:create		R:read		U:update
//			 * D:delete		S:select	B:배치 
//			 * L:로그인		O:로그아웃
//			 */
//			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
//				
//				return returnYeta2000;
//	}

   /**
* 
* <pre>
* 1. 개요 : 세액 계산을 전체 돌린다.  
* 2. 처리내용 : 
* </pre>
* @Method Name : fnYeta0300Payr06430CalcTax
* @date : Feb 25, 2016
* @author : leeheuisung
* @history : 
*	-----------------------------------------------------------------------
*	변경일				작성자						변경내용  
*	----------- ------------------- ---------------------------------------
*	Feb 25, 2016		leeheuisung				최초 작성 
*	-----------------------------------------------------------------------
* 
* @see com.app.exterms.yearendtax.client.service.yeta2015.Yeta1300Service#fnYeta0300Payr06430CalcTax(java.util.List)
* @param listYeta2000Dto
* @return
* @throws MSFException
*/
   @Override
 public PagingLoadResult<ShowMessageBM> fnYeta5300Ye161010_2020_AllCalcTax(Ye161010DTO ye161010Dto) throws MSFException {

	        PagingLoadResult<ShowMessageBM> retval = null;
	        
	    	String windowNm = "소득공제신고자료관리";
		  String windowId = "YETA5300";
   
    	String method = calledClass + ".fnYeta5300Ye161010_2020_AllCalcTax";
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
       // yeta2200Service = (InfcPkgYeta2200Service)BeanFinder.getBean("InfcPkgYeta2200Service"); 
     
    	
        try {  
        	
        	 
	          Ye161010Srh_2020_VO  ye161010SrhVo = new Ye161010Srh_2020_VO(); 
	          List<InfcPkgYe161010_2020_VO> listPkgYe161010VO = new ArrayList<InfcPkgYe161010_2020_VO>();
	          List<Ye161010_2020_VO> listYe161010VO = new ArrayList<Ye161010_2020_VO>();
	          
	          ye161010SrhVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    					/** column 사업장코드 : dpobCd */
	          ye161010SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161010Dto.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
	          ye161010SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161010Dto.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
            	
        	  
	          listYe161010VO = (List<Ye161010_2020_VO>)ye161010DAO.selectYeta5300ToYe161010AllList(ye161010SrhVo);
			  
              for (int iCnt = 0;iCnt < listYe161010VO.size();iCnt++) { 
            		
            	  // 1. 암호화 객체 생성
  		    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
  		         
	            	
	        		
	            	InfcPkgYe161010_2020_VO infcPkgYe161010Vo = new InfcPkgYe161010_2020_VO();
	            	Ye161010_2020_VO  ye161010Vo = new Ye161010_2020_VO();  
	            	
            	    
	            	 ye161010Vo = (Ye161010_2020_VO) listYe161010VO.get(iCnt); 
					  
					 
	            	 infcPkgYe161010Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161010Vo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
	            	 infcPkgYe161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161010Vo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
	            	 infcPkgYe161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161010Vo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
	            	 infcPkgYe161010Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161010Vo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
	            	infcPkgYe161010Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(ye161010Vo.getPayrMangDeptCd()));    	/** column 급여관리부서코드 : payrMangDeptCd */
	            	infcPkgYe161010Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(ye161010Vo.getEmymtDivCd()));    			/** column 당시_고용구분코드 : emymtDivCd */
	            	infcPkgYe161010Vo.setDeptCd(MSFSharedUtils.allowNulls(ye161010Vo.getDeptCd()));    					/** column 당시_부서코드 : deptCd */
	            	infcPkgYe161010Vo.setTypOccuCd(MSFSharedUtils.allowNulls(ye161010Vo.getTypOccuCd()));    				/** column 당시_직종코드 : typOccuCd */
	            	infcPkgYe161010Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(ye161010Vo.getDtilOccuInttnCd()));    	/** column 당시_직종세통합코드 : dtilOccuInttnCd */
	            	infcPkgYe161010Vo.setBusinCd(MSFSharedUtils.allowNulls(ye161010Vo.getBusinCd()));    					/** column 당시_사업코드 : businCd */
	               
	            	infcPkgYe161010Vo.setOdtyCd(ye161010Vo.getOdtyCd());    						/** column 직책코드 : odtyCd */
	            	infcPkgYe161010Vo.setPyspCd(ye161010Vo.getPyspCd());    						/** column 호봉코드 : pyspCd */
	            	infcPkgYe161010Vo.setLogSvcYrNumCd(ye161010Vo.getLogSvcYrNumCd());    		/** column 근속년수코드 : logSvcYrNumCd */
	            	infcPkgYe161010Vo.setLogSvcMnthIcmCd(ye161010Vo.getLogSvcMnthIcmCd());    	/** column 근속월수코드 : logSvcMnthIcmCd */
	            	infcPkgYe161010Vo.setFrstEmymtDt(ye161010Vo.getFrstEmymtDt());    			/** column 최초고용일자 : frstEmymtDt */
	            	infcPkgYe161010Vo.setEmymtBgnnDt(ye161010Vo.getEmymtBgnnDt());    			/** column 고용시작일자 : emymtBgnnDt */
	            	infcPkgYe161010Vo.setEmymtEndDt(ye161010Vo.getEmymtEndDt());    				/** column 고용종료일자 : emymtEndDt */
	            	infcPkgYe161010Vo.setHdofcDivCd(ye161010Vo.getHdofcDivCd());    				/** column 재직구분코드 : hdofcDivCd */
	            	infcPkgYe161010Vo.setRetryDt(ye161010Vo.getRetryDt());    					/** column 퇴직일자 : retryDt */
 
					 listPkgYe161010VO.add(infcPkgYe161010Vo); 
					 
	               } 
                   
	         
                  Yeta5300ListenerAdapter yetaLsAdtr = new Yeta5300ListenerAdapter();
                  retval = yetaLsAdtr.fnYeta5300_Ye161010_2020_CalcTax(RemoteServiceUtil.getThreadLocalRequest(),listPkgYe161010VO);
   
	        } 
	        catch (Exception ex) {
	        	 
	            logger.error("EXCEPTION calling fnYeta5300Ye161010_2020_AllCalcTax(): "+ex); 
            
            /** 에러 로그 **/			
            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C",ex, windowNm , windowId);
             
            throw MSFServerUtils.getOperationException("fnYeta5300Ye161010_2020_AllCalcTax", ex, logger);
        }
        finally {
          
        }
        
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C");
      
        return retval;
} 
   
   //소득공제신고서 재적용
   @Override
   public PagingLoadResult<ShowMessageBM> fnYeta5300Ye161010_2020_SbtVolUse(Ye161010DTO ye161010Dto) throws MSFException {
	   
	   PagingLoadResult<ShowMessageBM> retval = null;
	   
	   String windowNm = "소득공제신고자료관리";
	   String windowId = "YETA5300";
	   
	   String strReturnPdfCheck = "ok";
	   
	   String method = calledClass + ".fnYeta5300Ye161010_2020_SbtVolUse";
	   MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	   
	   
	   try {  
		   
		   
		   Ye161010Srh_2020_VO  ye161010SrhVo = new Ye161010Srh_2020_VO(); 
		   InfcPkgYe161010_2020_VO pkgYe161010VO = new InfcPkgYe161010_2020_VO();
		   
		   pkgYe161010VO.setDpobCd(MSFSharedUtils.allowNulls(ye161010Dto.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		   pkgYe161010VO.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161010Dto.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		   pkgYe161010VO.setClutSeptCd(MSFSharedUtils.allowNulls(ye161010Dto.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		   pkgYe161010VO.setSystemkey(MSFSharedUtils.allowNulls(ye161010Dto.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
			 
		   Func_PdfInDdc_Yeta2020_Insert funcPdfInDdc = new Func_PdfInDdc_Yeta2020_Insert();
		   strReturnPdfCheck = funcPdfInDdc.pdfInDdc_Yeta2020_Insert(pkgYe161010VO, RemoteServiceUtil.getThreadLocalRequest());
		   
	   } 
	   catch (Exception ex) {
		   
		   logger.error("EXCEPTION calling fnYeta5300Ye161010_2020_AllCalcTax(): "+ex); 
		   
		   /** 에러 로그 **/			
		   MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C",ex, windowNm , windowId);
		   
		   throw MSFServerUtils.getOperationException("fnYeta5300Ye161010_2020_AllCalcTax", ex, logger);
	   }
	   finally {
		   
	   }
	   
	   /** 로그반영
	    * CRUDSBLO
	    * C:create		R:read		U:update
	    * D:delete		S:select	B:배치 
	    * L:로그인		O:로그아웃
	    */
	   MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C");
	   
	   return retval;
   } 
   
   
   @Override
	public Ye161020DTO getYeta5300TxDdcYnToYe161020Data(Ye161020DTO ye161020Dto) throws MSFException {


		Ye161020Srh_2020_VO ye161020SrhVo = new Ye161020Srh_2020_VO();
		MSFSysm0100BM sessionUser;

		String method = calledClass + ".getYeta5300TxDdcYnToYe161020Data";

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(ye161020DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
					.getSession().getServletContext());
			ye161020DAO = (Ye161020_2020_DAO) wac.getBean("Ye161020_2020_DAO");
		}



		/** 조건절 */
		ye161020SrhVo.setDpobCd(ye161020Dto.getDpobCd());   		/** column 사업장코드 : dpobCd */
		ye161020SrhVo.setYrtxBlggYr(ye161020Dto.getYrtxBlggYr());	/** column 귀속연도 : yrtxBlggYr */
		ye161020SrhVo.setClutSeptCd(ye161020Dto.getClutSeptCd());	/** column 연말정산구분코드 : clutSeptCd */
		ye161020SrhVo.setSystemkey(ye161020Dto.getSystemkey());    	/** column SYSTEMKEY : systemkey */

		//	int iResultCnt = ye161020DAO.selectYeta2300ToYe161020ListtTotCnt(ye161020SrhVo);

		Ye161020DTO returnYe161020Dto = new Ye161020DTO();
		List egovResultDataList = new ArrayList();

		try {

			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

			egovResultDataList = ye161020DAO.getYeta5300TxDdcYnToYe161020Data(ye161020SrhVo);

			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";

			if (egovResultDataList != null && egovResultDataList.size() > 0) {

				for (int i = 0; i < egovResultDataList.size(); i++) {

					Map tempMap = (Map) egovResultDataList.get(i);

					returnYe161020Dto.setC152StdTxDdcYn(MSFSharedUtils.allowNulls(tempMap.get("c152StdTxDdcYn")));    							/** column 사업장코드 : dpobCd */

				}
			}

		} catch (Exception ex) {

			ex.printStackTrace();

			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);

		}

		/** 로그반영
		 * CRUDSBLO 
		 * C:create		R:read		U:update
		 * D:delete		S:select	B:배치 
		 * L:로그인		O:로그아웃
		 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass,"S");

		return returnYe161020Dto;
	}
   
	/** 합계 일괄업데이트 **/
	@Override
	public int updateYeta5300All(List<Ye161040DTO> listYe161040Dto)throws MSFException {
		// TODO Auto-generated method stub
		
		int result = 0;
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA5300";
		
		InfcPkgYe161010_2020_VO infcPkgYe161010Vo = new InfcPkgYe161010_2020_VO(); 
		Yeta5300ListenerAdapter  yeta5300ListenerAdt = new Yeta5300ListenerAdapter();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		String method = calledClass + ".saveYeta5300ToYe161020tabItem01";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		try{
			List<InfcPkgYe161010_2020_VO> listYe161010VO = new ArrayList<InfcPkgYe161010_2020_VO>();
            for (int iCnt = 0;iCnt < listYe161040Dto.size();iCnt++) { 
            	
            	infcPkgYe161010Vo = new InfcPkgYe161010_2020_VO(); 

            	Ye161040DTO ye161040Dto = new Ye161040DTO();
				Ye161010_2020_VO ye161010Vo = new Ye161010_2020_VO();

				ye161040Dto = listYe161040Dto.get(iCnt);
          	    
	           	infcPkgYe161010Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    					/** column 사업장코드 : dpobCd */
	           	infcPkgYe161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161040Dto.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
	           	infcPkgYe161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161040Dto.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
	           	infcPkgYe161010Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161040Dto.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
					 
				listYe161010VO.add(infcPkgYe161010Vo);
				
				 yeta5300ListenerAdt = new Yeta5300ListenerAdapter();
				 yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE164010");
				 yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE161090");
				 yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE161050");
				 yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE165010");
				 yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE162010");
				 yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE162510");
				 yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE166020_INSERT");
				 yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE166020_DELETE");
							
			}
			
			result = 1;
			
		}catch(Exception e){
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			e.printStackTrace();
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
   	 * D:delete		S:select	B:배치 
   	 * L:로그인		O:로그아웃
   	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");

		return result;
	}


}
