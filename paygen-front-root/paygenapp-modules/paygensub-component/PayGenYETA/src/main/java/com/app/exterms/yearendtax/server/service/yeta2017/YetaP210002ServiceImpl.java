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

import org.apache.commons.beanutils.BeanUtilsBean;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.yearendtax.client.dto.yeta2017.Ye161005DTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.Ye161010DTO;
import com.app.exterms.yearendtax.client.service.yeta2017.YetaP210002Service;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161005DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161010DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161020DAO;
import com.app.exterms.yearendtax.server.vo.Ye161005SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye161005VO;
import com.app.exterms.yearendtax.server.vo.Ye161010SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye161010VO;
import com.app.exterms.yearendtax.server.vo.Ye161020VO;
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
import com.app.smrmf.infc.sysif.msfpackage.server.utils.SysifPkgServiceUtils;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0350VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

/**
 * 
* <pre>
* 1. 패키지명 : com.app.exterms.yearendtax.server.service
* 2. 타입명 : Yeta0100ServiceImpl.java
* 3. 작성일 : Jan 13, 2016 5:12:49 PM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>	
 */
@Service("YetaP210002Service")
public class YetaP210002ServiceImpl  extends AbstractCustomServiceImpl implements YetaP210002Service  ,YetaDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(YetaP210002ServiceImpl.class);
	private static final String calledClass = YetaP210002ServiceImpl.class.getName();

	
	// 원천세신고기준
	@Autowired
	@Resource(name = "Ye161005DAO")
	private Ye161005DAO ye161005DAO;
	
	@Autowired
	@Resource(name = "Ye161010DAO")
	private Ye161010DAO ye161010DAO;
	
	@Autowired
	@Resource(name = "Ye161020DAO")
	private Ye161020DAO ye161020DAO;
	

	/**
	 * 연말정산대상자내역조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public PagingLoadResult<BaseModel> getYetaP210002ToYe161010List(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		// String method = "getPsnl0100ToRemt0100DataList";
		String method = CLASS_YETAP210002ToYE161010_LIST;
		Ye161010SrhVO ye161010SrhVo = new Ye161010SrhVO();
		Ye161010VO ye161010Vo = new Ye161010VO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(ye161010DAO)) {
	        
	            WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	            ye161010DAO = (Ye161010DAO) wac.getBean("Ye161010DAO" ); 
	        }
	        
	        try {
	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	           // Sysm0400BM          user             = serviceParameters.getUser();
	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

	            //Get paging configuration
	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	            //Get query parameters
	            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	              
	            List<String> listDeptCd = new ArrayList<String>();
	            /** 조건절 */
	            ye161010SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	            ye161010SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
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
	      
	            
	            ye161010SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr"))); //연말정산년
	            ye161010SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));  //연말정산구분코드  
	            
	           
	            ye161010SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	            
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            ye161010SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	            ye161010SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	            ye161010SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            ye161010SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세 
	            
	            ye161010SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드 
	          
	            ye161010SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	            ye161010SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    		//한글성명
	            ye161010SrhVo.setUtDpobCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "utDpobCd")));		//원천신고부서
	            ye161010SrhVo.setUtDpobChk(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "utDpobChk")));		//원천신고부서
	            
	            
		     	SysIfBass0350VO  sysIfBass0350Vo = new SysIfBass0350VO();
		     	
		     	sysIfBass0350Vo.setDpobCd(sessionUser.getDpobCd());
		     	sysIfBass0350Vo.setYmdGb("Y");
		     	sysIfBass0350Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));
		     	sysIfBass0350Vo.setTypOccuCd(ye161010SrhVo.getTypOccuCd());
		     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
		    	sysIfBass0350Vo.setDtilOccuInttnCd(ye161010SrhVo.getDtilOccuInttnCd());
		     	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		     	
		     	sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0350Vo); 
		     
		     	ye161010SrhVo.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
		     	ye161010SrhVo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	             if ( pagingValues.executeRecordCount ) { 
	                    
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = ye161010DAO.selectYetaP210002ToYe161010ListTotCnt(ye161010SrhVo);
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;        
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginPsnl0100ToRemt0100DataList = SmrmfUtils.startTiming(logger);
	        
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
//	            Collection<Map<String, Object>> list  
	            List list =  ye161010DAO.selectYetaP210002ToYe161010List(ye161010SrhVo);
	            
	            Iterator<Map<String, Object>> iter = list.iterator();
	                
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
	            while ( iter.hasNext() ) {
	            	

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

	                         }else if("resnoEncCntn".equals(tableAttributes[i].getName())) {

		                 			// 주민번호(복호화)
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginPsnl0100ToRemt0100DataList, "getPsnl0100ToRemt0100DataList");
	       

		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;
	}
	    	
	
	
	
	
	
	
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 원천신고세기본   
	 * 2. 처리내용 : 원천신고세기본을 저장/삭제 한다.
	 * </pre>
	 * @Method Name : saveYeta161005
	 * @date : Jan 18, 2016
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Jan 18, 2016		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @return
	 */
	@Override
	public int saveYetaP210002ToYeta161005(Ye161005DTO ye161005Dto, ActionDatabase actionDatabase) throws MSFException {
	    	
		String method = calledClass + ".saveYetaP210002ToYeta161005";
	
		String windowNm = "연말정산대상자관리";
		String windowId = "YETA2100";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    		
		int retInt = 0;
		BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  
		
			   
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		
		try { 
			
			Ye161005VO ye16Ta161005Vo = new Ye161005VO(); 
			
			ye16Ta161005Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    							/** column 사업장코드 : dpobCd */
			ye16Ta161005Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161005Dto.getYrtxBlggYr()));    					/** column null : yrtxBlggYr */
			ye16Ta161005Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161005Dto.getClutSeptCd()));    					/** column null : clutSeptCd */
			ye16Ta161005Vo.setWhdgTxRegrstDeptCd(MSFSharedUtils.allowNulls(ye161005Dto.getWhdgTxRegrstDeptCd()));   	/** column 원천세신고부서코드 : whdgTxRegrstDeptCd */
			
			ye16Ta161005Vo.setHhrkWhdgRegrstDeptCd(MSFSharedUtils.allowNulls(ye161005Dto.getHhrkWhdgRegrstDeptCd())); 	/** column 상위원천세신고부서코드 : hhrkWhdgRegrstDeptCd */
			ye16Ta161005Vo.setTxOffcCd(MSFSharedUtils.allowNulls(ye161005Dto.getTxOffcCd()));    						/** column A3_세무서코드 : txOffcCd */
			ye16Ta161005Vo.setPentrSeptCd(MSFSharedUtils.allowNulls(ye161005Dto.getPentrSeptCd()));    					/** column A5_제출자구분 : pentrSeptCd */
			ye16Ta161005Vo.setTxDeptyMangeNum(MSFSharedUtils.allowNulls(ye161005Dto.getTxDeptyMangeNum()));    			/** column A6_세무대리인관리번호 : txDeptyMangeNum */
			ye16Ta161005Vo.setHmtxId(MSFSharedUtils.allowNulls(ye161005Dto.getHmtxId()));    							/** column A7_홈텍스ID : hmtxId */
			ye16Ta161005Vo.setTxPgmCd(MSFSharedUtils.allowNulls(ye161005Dto.getTxPgmCd()));    							/** column A8_세무프로그램코드 : txPgmCd */
			ye16Ta161005Vo.setBusoprRgstnum(MSFSharedUtils.allowNulls(ye161005Dto.getBusoprRgstnum()));    				/** column A9_사업자등록번호 : busoprRgstnum */
			ye16Ta161005Vo.setCorpFmnmNm(MSFSharedUtils.allowNulls(ye161005Dto.getCorpFmnmNm()));    					/** column A10_법인_상호명 : corpFmnmNm */
			ye16Ta161005Vo.setPernChrgDeptNm(MSFSharedUtils.allowNulls(ye161005Dto.getPernChrgDeptNm()));    			/** column A11_담당자부서 : pernChrgDeptNm */
			ye16Ta161005Vo.setPernChrgNm(MSFSharedUtils.allowNulls(ye161005Dto.getPernChrgNm()));    					/** column A12_담당자성명 : pernChrgNm */
			ye16Ta161005Vo.setPernChrgPhnNum(MSFSharedUtils.allowNulls(ye161005Dto.getPernChrgPhnNum()));    			/** column A13_담당자전화번호 : pernChrgPhnNum */
			ye16Ta161005Vo.setUseHanCd(MSFSharedUtils.allowNulls(ye161005Dto.getUseHanCd()));    						/** column A15_사용한글코드 : useHanCd */
			ye16Ta161005Vo.setSumtTgtPridCd(MSFSharedUtils.allowNulls(ye161005Dto.getSumtTgtPridCd()));   	 			/** column B16_제출대상기간코드 : sumtTgtPridCd */
			ye16Ta161005Vo.setCorpNum(MSFSharedUtils.allowNulls(ye161005Dto.getCorpNum()));    							/** column 법인번호 : corpNum */
			ye16Ta161005Vo.setIncmPost(MSFSharedUtils.allowNulls(ye161005Dto.getIncmPost()));    						/** column 소득신고의무자우편번호 : incmPost */
			ye16Ta161005Vo.setIncmAddr(MSFSharedUtils.allowNulls(ye161005Dto.getIncmAddr()));   	 					/** column 소득신고의무자기본주소 : incmAddr */
			ye16Ta161005Vo.setIncmAdtl(MSFSharedUtils.allowNulls(ye161005Dto.getIncmAdtl()));    						/** column 소득신고의무자상세주소 : incmAdtl */

			ye16Ta161005Vo.setReprName(MSFSharedUtils.allowNulls(ye161005Dto.getReprName()));    						/** column 대표자성명 : reprName */
			ye16Ta161005Vo.setResuNumb(AnyCryptUtils.getEncSyncCrypt(nResult, MSFSharedUtils.allowNulls(
					ye161005Dto.getResuNumb()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));    						/** column 주민등록번호 : resuNumb */
			
			
			
			ye16Ta161005Vo.setKybdr(sessionUser.getUsrId());    														/** column 입력자 : kybdr */
			ye16Ta161005Vo.setInptAddr(ye161005Dto.getInptAddr());    													/** column 입력주소 : inptAddr */
			ye16Ta161005Vo.setIsmt(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    						/** column 수정자 : ismt */
			ye16Ta161005Vo.setRevnAddr(ye161005Dto.getRevnAddr());    													/** column 수정주소 : revnAddr */
			
			
        	switch (actionDatabase) {
    		case INSERT:
    			
//    			// insert 경우 데이터 중복 체크 후 작업 진행
//    			if(ActionDatabase.INSERT.equals(actionDatabase)) {
//    				
//    				
//    				int ye161005Check = 0;//ye17Ta2000DAO.selectYeta1100ToYeta2000ListTotCnt(ye16Ta161005Vo);
//    				if(ye161005Check > 0) {
//    					retInt = 3;	// 중복데이터 있을 경우 3리턴하여 메세지 표시
//    				}else {
////    					ye16Ta161005DAO.insertYe161005(ye16Ta161005Vo); 
//    					retInt = 1;
//    					
//    				}
//    			}
    			
    			
    			break;
        	case UPDATE: 
        		ye161005DAO.updateYetaP210002ToYe161005(ye16Ta161005Vo);
        		retInt = 1;
        		break;
        	case DELETE: 
//        		ye16Ta161005DAO.deleteYe161005(ye16Ta161005Vo);
        		retInt = 1;
        		break;
    	} 
			 
			
		}catch (Exception ex) {
			retInt = 0;
			logger.error("EXCEPTION calling saveYeta161005(): "+ex); 
		            
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D", ex, windowNm , windowId);
		            
			throw MSFServerUtils.getOperationException("saveYeta161005", ex, logger);
		} 
		        
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
		 * D:delete		S:select	B:배치 
		 * L:로그인		O:로그아웃
		 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C:U:D"); 

		return retInt;
	}  
	  	
	
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 원천신고세기본   
	 * 2. 처리내용 : 근로자의 원천신고부서를 수정한다.
	 * </pre>
	 * @Method Name : saveYeta2000_YetaDpcd
	 * @date : Jan 18, 2016
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Jan 18, 2016		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @return
	 */
	@Override
	public int saveYetaP210002ToYe161010(List<Ye161010DTO> lsYe161010Dto) throws MSFException {
	    	
		String method = calledClass + ".saveYetaP210002ToYe161010";
	
		String windowNm = "연말정산대상자관리";
		String windowId = "YETA2100";
	    
		int retval = 0;
		BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  
		
			   
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//		System.out.println("삭제자 : " + sessionUser.getDeptNm() + "["+ sessionUser.getUsrNm() + "]");
		
		Ye161010DTO ye161010Dto = new Ye161010DTO();
		Ye161010VO ye161010Vo = new Ye161010VO();
		Ye161020VO ye161020Vo = new Ye161020VO();
		
		try { 
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
			for(int i = 0; i < lsYe161010Dto.size(); i ++) {
			    		
				ye161010Vo = new Ye161010VO();
				
				ye161010Dto = new Ye161010DTO();
				ye161010Dto = lsYe161010Dto.get(i); 
				

				ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    			/** column 사업장코드 : dpobCd */
				ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161010Dto.getYrtxBlggYr()));    	/** column 귀속연도 : yrtxBlggYr */
				ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161010Dto.getClutSeptCd()));   	/** column 연말정산구분코드 : clutSeptCd */
				ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161010Dto.getSystemkey()));    		/** column SYSTEMKEY : systemkey */			
				
				
				// 미반영 선택할 경우 원천징수부서 초기화
				if("N".equals(ye161010Dto.getUtDpobCdChk())) {
					ye161010Vo.setUtDpobCd("");    														/** column 단위사업장코드 : utDpobCd */	
				}else {

					ye161010Vo.setUtDpobCd(MSFSharedUtils.allowNulls(ye161010Dto.getUtDpobCd()));    	/** column 단위사업장코드 : utDpobCd */
				}
				
				
				ye161010Vo.setIsmt(sessionUser.getUsrId());
				ye161010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				ye161010DAO.updateYetaP210002ToYe161010(ye161010Vo);
				
				
				ye161020Vo = new Ye161020VO();
				
				
				ye161020Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161010Vo.getDpobCd()));    		/** column 사업장코드 : dpobCd */
				ye161020Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161010Vo.getYrtxBlggYr()));    /** column 귀속연도 : yrtxBlggYr */
				ye161020Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161010Vo.getClutSeptCd()));   	/** column 연말정산구분코드 : clutSeptCd */
				ye161020Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161010Vo.getSystemkey()));    	/** column SYSTEMKEY : systemkey */	
				ye161020Vo.setUtDpobCd(MSFSharedUtils.allowNulls(ye161010Dto.getUtDpobCd()));    	/** column 단위사업장코드 : utDpobCd */
				
				ye161020Vo.setIsmt(sessionUser.getUsrId());
				ye161020Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				ye161020DAO.updateYetaP210002ToYe161020(ye161020Vo);
				
				
				retval = retval + 1;
				
			}
			
		}catch (Exception ex) {
		        	 
			logger.error("EXCEPTION calling saveYetaP210002ToYe161010(): "+ex); 
		            
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D", ex, windowNm , windowId);
		            
			retval = 0;
			throw MSFServerUtils.getOperationException("saveYetaP210002ToYe161010", ex, logger);
		} 
		        
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
		 * D:delete		S:select	B:배치 
		 * L:로그인		O:로그아웃
		 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C:U:D"); 

		return retval;
	}  
	
	
	
	
	
	
	
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 원천신고세기본   
	 * 2. 처리내용 : 근로자의 원천신고부서를 수정한다.
	 * </pre>
	 * @Method Name : saveYeta2000_YetaDpcd
	 * @date : Jan 18, 2016
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Jan 18, 2016		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @return
	 */
	@Override
	public Ye161005DTO getYe161005Data(Ye161005DTO ye161005Dto) throws MSFException {
	    	
		String method = calledClass + ".getYe161005List";
	
		String windowNm = "연말정산대상자관리";
		String windowId = "YETA2100";
	    	 
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    		
		int retval = 0;
		BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  
		
			   
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		Ye161005DTO returnYe161005Dto = new Ye161005DTO();
		Ye161005SrhVO ye161005SrhVo = new Ye161005SrhVO();
		Ye161005VO ye161005Vo = new Ye161005VO();
		
		try { 
			
			ye161005SrhVo = new Ye161005SrhVO();
			
			ye161005SrhVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    						/** column 사업장코드 : dpobCd */
			ye161005SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161005Dto.getYrtxBlggYr()));    				/** column null : yrtxBlggYr */
			ye161005SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161005Dto.getClutSeptCd()));    				/** column null : clutSeptCd */
			ye161005SrhVo.setWhdgTxRegrstDeptCd(MSFSharedUtils.allowNulls(ye161005Dto.getWhdgTxRegrstDeptCd()));    /** column 원천세신고부서코드 : whdgTxRegrstDeptCd */
				
			ye161005Vo = ye161005DAO.selectYetaP210002ToYe161005(ye161005SrhVo);
			
			
			returnYe161005Dto.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    /** column 사업장코드 : dpobCd */
			returnYe161005Dto.setWhdgTxRegrstDeptCd(MSFSharedUtils.allowNulls(ye161005Vo.getWhdgTxRegrstDeptCd()));    /** column 원천세신고부서코드 : whdgTxRegrstDeptCd */
			returnYe161005Dto.setHhrkWhdgRegrstDeptCd(MSFSharedUtils.allowNulls(ye161005Vo.getHhrkWhdgRegrstDeptCd()));    /** column 상위원천세신고부서코드 : hhrkWhdgRegrstDeptCd */
			returnYe161005Dto.setTxOffcCd(MSFSharedUtils.allowNulls(ye161005Vo.getTxOffcCd()));    /** column A3_세무서코드 : txOffcCd */
			returnYe161005Dto.setPentrSeptCd(MSFSharedUtils.allowNulls(ye161005Vo.getPentrSeptCd()));    /** column A5_제출자구분 : pentrSeptCd */
			returnYe161005Dto.setTxDeptyMangeNum(MSFSharedUtils.allowNulls(ye161005Vo.getTxDeptyMangeNum()));    /** column A6_세무대리인관리번호 : txDeptyMangeNum */
			returnYe161005Dto.setHmtxId(MSFSharedUtils.allowNulls(ye161005Vo.getHmtxId()));    /** column A7_홈텍스ID : hmtxId */
			returnYe161005Dto.setTxPgmCd(MSFSharedUtils.allowNulls(ye161005Vo.getTxPgmCd()));    /** column A8_세무프로그램코드 : txPgmCd */
			returnYe161005Dto.setBusoprRgstnum(MSFSharedUtils.allowNulls(ye161005Vo.getBusoprRgstnum()));    /** column A9_사업자등록번호 : busoprRgstnum */
			returnYe161005Dto.setCorpFmnmNm(MSFSharedUtils.allowNulls(ye161005Vo.getCorpFmnmNm()));    /** column A10_법인_상호명 : corpFmnmNm */
			returnYe161005Dto.setPernChrgDeptNm(MSFSharedUtils.allowNulls(ye161005Vo.getPernChrgDeptNm()));    /** column A11_담당자부서 : pernChrgDeptNm */
			returnYe161005Dto.setPernChrgNm(MSFSharedUtils.allowNulls(ye161005Vo.getPernChrgNm()));    /** column A12_담당자성명 : pernChrgNm */
			returnYe161005Dto.setPernChrgPhnNum(MSFSharedUtils.allowNulls(ye161005Vo.getPernChrgPhnNum()));    /** column A13_담당자전화번호 : pernChrgPhnNum */
			returnYe161005Dto.setUseHanCd(MSFSharedUtils.allowNulls(ye161005Vo.getUseHanCd()));    /** column A15_사용한글코드 : useHanCd */
			returnYe161005Dto.setSumtTgtPridCd(MSFSharedUtils.allowNulls(ye161005Vo.getSumtTgtPridCd()));    /** column B16_제출대상기간코드 : sumtTgtPridCd */
			returnYe161005Dto.setCorpNum(MSFSharedUtils.allowNulls(ye161005Vo.getCorpNum()));    /** column 법인번호 : corpNum */
			returnYe161005Dto.setIncmPost(MSFSharedUtils.allowNulls(ye161005Vo.getIncmPost()));    /** column 소득신고의무자우편번호 : incmPost */
			returnYe161005Dto.setIncmAddr(MSFSharedUtils.allowNulls(ye161005Vo.getIncmAddr()));    /** column 소득신고의무자기본주소 : incmAddr */
			returnYe161005Dto.setIncmAdtl(MSFSharedUtils.allowNulls(ye161005Vo.getIncmAdtl()));    /** column 소득신고의무자상세주소 : incmAdtl */
			returnYe161005Dto.setKybdr(MSFSharedUtils.allowNulls(ye161005Vo.getKybdr()));   			 /** column 입력자 : kybdr */
			returnYe161005Dto.setInptDt(MSFSharedUtils.allowNulls(ye161005Vo.getInptDt()));    			/** column 입력일자 : inptDt */
			returnYe161005Dto.setInptAddr(MSFSharedUtils.allowNulls(ye161005Vo.getInptAddr()));   			 /** column 입력주소 : inptAddr */
			returnYe161005Dto.setIsmt(MSFSharedUtils.allowNulls(ye161005Vo.getIsmt()));   				 /** column 수정자 : ismt */
			returnYe161005Dto.setRevnDt(MSFSharedUtils.allowNulls(ye161005Vo.getRevnDt()));    			/** column 수정일자 : revnDt */
			returnYe161005Dto.setRevnAddr(MSFSharedUtils.allowNulls(ye161005Vo.getRevnAddr()));   			/** column 수정주소 : revnAddr */
			returnYe161005Dto.setReprName(MSFSharedUtils.allowNulls(ye161005Vo.getReprName()));    				/** column 대표자성명 : reprName */
//			returnYe161005Dto.setResuNumb(ye161005Vo.getResuNumb());    /** column 주민등록번호 : resuNumb */
			// 복호화
			String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(ye161005Vo.getResuNumb()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
			returnYe161005Dto.setResuNumb(rrnDecCrypt);    													/** column 주민등록번호 : resuNumb */
			
			returnYe161005Dto.setYetaC171(MSFSharedUtils.convertStringToBoolean(MSFSharedUtils.allowNulls(ye161005Vo.getYetaC171())));    			/** column C171_사업자단위과세자여부 : yetaC171 */
			returnYe161005Dto.setYetaC172(MSFSharedUtils.allowNulls(ye161005Vo.getYetaC172()));    			/** column C172_종사업장일련번호 : yetaC172 */
			returnYe161005Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161005Vo.getYrtxBlggYr()));    		/** column null : yrtxBlggYr */
			returnYe161005Dto.setClutSeptCd(MSFSharedUtils.allowNulls(ye161005Vo.getClutSeptCd()));    		/** column null : clutSeptCd */
			
		
			
			
		}catch (Exception ex) {
		        	 
			logger.error("EXCEPTION calling saveYeta2000_YetaDpcd(): "+ex); 
		            
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D", ex, windowNm , windowId);
		            
			retval = 0;
			throw MSFServerUtils.getOperationException("saveYeta2000_YetaDpcd", ex, logger);
		} 
		        
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
		 * D:delete		S:select	B:배치 
		 * L:로그인		O:로그아웃
		 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C:U:D"); 

		return returnYe161005Dto;
	}
	
	
	

}
