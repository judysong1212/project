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
package com.app.exterms.yearendtax.server.service.yeta2016;
 
 
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

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1005DTO;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta2000DTO;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP110002Service;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta161005DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta2000DAO;
import com.app.exterms.yearendtax.server.vo.Ye161005SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye161005VO;
import com.app.exterms.yearendtax.server.vo.Yeta2000SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta2000VO;
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
@Service("YetaP110002Service")
public class YetaP110002ServiceImpl  extends AbstractCustomServiceImpl implements YetaP110002Service  ,YetaDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(YetaP110002ServiceImpl.class);
	private static final String calledClass = YetaP110002ServiceImpl.class.getName();

	
	// 원천세신고기준
	@Autowired
	@Resource(name = "Ye16Ta161005DAO")
	private Ye16Ta161005DAO ye16Ta161005DAO;
	
	
	// 연말정산 기본
	@Autowired
	@Resource(name = "Ye16Ta2000DAO")
	private Ye16Ta2000DAO ye16Ta2000DAO;
	
	
	/**
	 * 연말정산대상자내역조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP110002ToYe16Ta2000List(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		// String method = "getPsnl0100ToRemt0100DataList";
		String method = CLASS_YETAP110002ToYE16TA2000_LIST;
		Yeta2000SrhVO yeta2000SrhVo = new Yeta2000SrhVO();
		Yeta2000VO yeta2000Vo = new Yeta2000VO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(ye16Ta2000DAO)) {
	        
	            WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	            ye16Ta2000DAO = (Ye16Ta2000DAO) wac.getBean("Ye16Ta2000DAO" ); 
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
	            yeta2000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	            yeta2000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	            yeta2000SrhVo.setUsrId(sessionUser.getUsrId());  
	              
	            
	            /******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	            	yeta2000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	               listDeptCd.add(sessionUser.getDeptCd());
	               yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	               yeta2000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else {
	            	    
	            	 yeta2000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
	                     if (yeta2000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
	                     	 listDeptCd = null; 
	                     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                     	yeta2000SrhVo.setDeptCd("");  //부서코드
	                     } else {
	                    	 yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	                          yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                     } 
	                  
	            }
	            
	            yeta2000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
	            yeta2000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));      
//	            String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
//	            if ("FALSE".equals(chkTypOccuCd)) {
//	            	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//	            	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
//	            } else {
//	            	
//	            }
	            
	           /******************************** 권한 ************************************************************************/ 
	      
	            
	            yeta2000SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy"))); //연말정산년
	            yeta2000SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "settGbcd")));  //연말정산구분코드  
	            
	           
	            yeta2000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	            
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            yeta2000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	            yeta2000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
//	            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	            yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	            yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	            yeta2000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            yeta2000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세 
	            
	            yeta2000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드 
	          
	            yeta2000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	            yeta2000SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    		//한글성명
	            yeta2000SrhVo.setYetaDpcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yetaDpcd")));		//원천신고부서
	         	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
//		      	SysIfBass0320VO  sysIfBass0320Vo = new SysIfBass0320VO();
//		     	 List<String> listTypCd = new ArrayList<String>(); 
//		     	 
//		     	sysIfBass0320Vo.setYmdGb("Y");
//		     	sysIfBass0320Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYr")));
//		     	sysIfBass0320Vo.setTypOccuCd(psnl0100SrhVO.getTypOccuCd());
//		     	sysIfBass0320Vo.setTypOccuCdArr(lstTypeOccuCd); 
//		     	
//		     	listTypCd = SysifPkgServiceUtils.funcArrBeforTypOccuCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0320Vo);
		     	
		     	SysIfBass0350VO  sysIfBass0350Vo = new SysIfBass0350VO();
		     //	 List<String> listTyInttnCd = new ArrayList<String>(); 
		     	sysIfBass0350Vo.setDpobCd(sessionUser.getDpobCd());
		     	sysIfBass0350Vo.setYmdGb("Y");
		     	sysIfBass0350Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy")));
		     	sysIfBass0350Vo.setTypOccuCd(yeta2000SrhVo.getTypOccuCd());
		     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
		    	sysIfBass0350Vo.setDtilOccuInttnCd(yeta2000SrhVo.getDtilOccuInttnCd());
		     	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		     	
		     	sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0350Vo); 
		     
		     	yeta2000SrhVo.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
		     	yeta2000SrhVo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
		     	
		     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
//	            String strHdofcCodtnCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"));
//	            
//	            List<String> listHdofcCodtnCd = new ArrayList<String>(); 
//	           
//	            String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
//	            
//	            for (int i=0; i<ray.length; i++){ 
//	                listHdofcCodtnCd.add(ray[i]);
//	            } 
//	            yeta2000SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);    //재직상
//	            yeta2000SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));    //재직상
	            
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	             if ( pagingValues.executeRecordCount ) { 
	                    
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = ye16Ta2000DAO.selectYeta1100ToYeta2000ListTotCnt(yeta2000SrhVo);  
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;        
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginPsnl0100ToRemt0100DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            yeta2000SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	                yeta2000SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	                yeta2000SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list  
	            List list = ye16Ta2000DAO.selectYeta1100ToYeta2000List(yeta2000SrhVo);
	            
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
	    	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/** 원천신고부서 리스트를 가져옴 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BaseModel> getYeta2000YetaDpcdList(Ye16Ta1005DTO yeta161005Dto) throws MSFException {
		
		List<BaseModel> returnValue = new ArrayList<BaseModel>();
		List egovResultDataList = new ArrayList();
		
		String method = calledClass + ".getYeta2000YetaDpcdList";
		

		String windowNm = "원천신고부서";
		String windowId = "YETA1100";
		
		List<String> listDeptCd = new ArrayList<String>(); 
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		try{
			
			Yeta2000SrhVO yeta2000SrhVo = new Yeta2000SrhVO();
			yeta2000SrhVo.setDpobCd(sessionUser.getDpobCd());
			
			
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	yeta2000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
            	listDeptCd.add(sessionUser.getDeptCd());
            	yeta2000SrhVo.setDeptCdArr(listDeptCd);     				//부서코드    
            	yeta2000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	    
            	yeta2000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(yeta161005Dto.getPayrMangDeptCd())) ;   //단위기관코드   
                     if (yeta2000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(yeta161005Dto.getDeptCd()))) { 
                     	 listDeptCd = null; 
                     	 yeta2000SrhVo.setDeptCdArr(listDeptCd);     	//부서코드 
                     	 yeta2000SrhVo.setDeptCd("");  					//부서코드
                     } else {
                    	 yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(yeta161005Dto.getDeptCd()));
                    	 listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta161005Dto.getDeptCd()));  
                    	 yeta2000SrhVo.setDeptCdArr(listDeptCd);    	 //부서코드   
                     } 
            	}
            
//            } else {
//            	
//            }
           /******************************** 권한 ************************************************************************/			
			
			
			egovResultDataList = ye16Ta2000DAO.selectYeta2000YetaDpcdList(yeta2000SrhVo);
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
			
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					BaseModel bm = new BaseModel();
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		bm.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		bm.set(key, tempMap.get(key));
		            	}
		            }
					returnValue.add(bm);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		return returnValue;
	}
	
	/** 원천신고부서 리스트를 가져옴(권한x) **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BaseModel> getYeta2000YetaDpcdListNoAuth() throws MSFException {
		
		List<BaseModel> returnValue = new ArrayList<BaseModel>();
		List egovResultDataList = new ArrayList();
		
		String method = calledClass + ".getYeta2000YetaDpcdList";
		

		String windowNm = "원천신고부서";
		String windowId = "YETA1100";
		
		List<String> listDeptCd = new ArrayList<String>(); 
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		try{
			
			Yeta2000SrhVO yeta2000SrhVo = new Yeta2000SrhVO();
			yeta2000SrhVo.setDpobCd(sessionUser.getDpobCd());
			
			
			egovResultDataList = ye16Ta2000DAO.selectYeta2000YetaDpcdList(yeta2000SrhVo);
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
			
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					BaseModel bm = new BaseModel();
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		bm.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		bm.set(key, tempMap.get(key));
		            	}
		            }
					returnValue.add(bm);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		return returnValue;
	}
	
	
	
	
	/** 원천징수부서에 따른 사업자번호 리스트를 가져옴 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BaseModel> getYeta2000busoprRgstnumList(Ye16Ta1005DTO yeta161005Dto) throws MSFException {
		
		List<BaseModel> returnValue = new ArrayList<BaseModel>();
		List egovResultDataList = new ArrayList();
		
		String method = calledClass + ".getYeta2000busoprRgstnumList";
		

		String windowNm = "원천신고부서";
		String windowId = "YETA1100";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		try{
			
			Ye161005SrhVO ye161005SrhVo = new Ye161005SrhVO();
			ye161005SrhVo.setDpobCd(sessionUser.getDpobCd());
			ye161005SrhVo.setWhdgTxRegrstDeptCd(yeta161005Dto.getWhdgTxRegrstDeptCd());
			
			egovResultDataList = ye16Ta161005DAO.selectYeta2000busoprRgstnumList(ye161005SrhVo);
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
			
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					BaseModel bm = new BaseModel();
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		bm.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		bm.set(key, tempMap.get(key));
		            	}
		            }
					returnValue.add(bm);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		return returnValue;
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
	public int saveYeta161005(Ye16Ta1005DTO ye16Ta1005Dto, ActionDatabase actionDatabase) throws MSFException {
	    	
		String method = calledClass + ".saveYeta161005";
	
		String windowNm = "연말정산대상자관리";
		String windowId = "YETA1100";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    		
		int retInt = 0;
		BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  
		
			   
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//		System.out.println("삭제자 : " + sessionUser.getDeptNm() + "["+ sessionUser.getUsrNm() + "]");
		
		
		try { 
			
			Ye161005VO ye16Ta161005Vo = new Ye161005VO(); 
			
			ye16Ta161005Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    							/** column 사업장코드 : dpobCd */
			ye16Ta161005Vo.setWhdgTxRegrstDeptCd(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getWhdgTxRegrstDeptCd()));    	/** column 원천세신고부서코드 : whdgTxRegrstDeptCd */
			ye16Ta161005Vo.setHhrkWhdgRegrstDeptCd(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getHhrkWhdgRegrstDeptCd())); /** column 상위원천세신고부서코드 : hhrkWhdgRegrstDeptCd */
			ye16Ta161005Vo.setTxOffcCd(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getTxOffcCd()));    						/** column A3_세무서코드 : txOffcCd */
			ye16Ta161005Vo.setPentrSeptCd(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getPentrSeptCd()));    				/** column A5_제출자구분 : pentrSeptCd */
			ye16Ta161005Vo.setTxDeptyMangeNum(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getTxDeptyMangeNum()));    		/** column A6_세무대리인관리번호 : txDeptyMangeNum */
			ye16Ta161005Vo.setHmtxId(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getHmtxId()));    							/** column A7_홈텍스ID : hmtxId */
			ye16Ta161005Vo.setTxPgmCd(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getTxPgmCd()));    						/** column A8_세무프로그램코드 : txPgmCd */
			ye16Ta161005Vo.setBusoprRgstnum(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getBusoprRgstnum()));    			/** column A9_사업자등록번호 : busoprRgstnum */
			ye16Ta161005Vo.setCorpFmnmNm(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getCorpFmnmNm()));    					/** column A10_법인_상호명 : corpFmnmNm */
			ye16Ta161005Vo.setPernChrgDeptNm(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getPernChrgDeptNm()));    			/** column A11_담당자부서 : pernChrgDeptNm */
			ye16Ta161005Vo.setPernChrgNm(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getPernChrgNm()));    					/** column A12_담당자성명 : pernChrgNm */
			ye16Ta161005Vo.setPernChrgPhnNum(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getPernChrgPhnNum()));    			/** column A13_담당자전화번호 : pernChrgPhnNum */
			ye16Ta161005Vo.setUseHanCd(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getUseHanCd()));    						/** column A15_사용한글코드 : useHanCd */
			ye16Ta161005Vo.setSumtTgtPridCd(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getSumtTgtPridCd()));   	 		/** column B16_제출대상기간코드 : sumtTgtPridCd */
			ye16Ta161005Vo.setCorpNum(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getCorpNum()));    						/** column 법인번호 : corpNum */
			ye16Ta161005Vo.setIncmPost(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getIncmPost()));    						/** column 소득신고의무자우편번호 : incmPost */
			ye16Ta161005Vo.setIncmAddr(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getIncmAddr()));   	 					/** column 소득신고의무자기본주소 : incmAddr */
			ye16Ta161005Vo.setIncmAdtl(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getIncmAdtl()));    						/** column 소득신고의무자상세주소 : incmAdtl */
			ye16Ta161005Vo.setKybdr(sessionUser.getUsrId());    														/** column 입력자 : kybdr */
//			ye16Ta161005Vo.setInptDt(ye161005Dto.getInptDt());    /** column 입력일자 : inptDt */
			ye16Ta161005Vo.setInptAddr(ye16Ta1005Dto.getInptAddr());    												/** column 입력주소 : inptAddr */
			ye16Ta161005Vo.setIsmt(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    						/** column 수정자 : ismt */
//			ye16Ta161005Vo.setRevnDt(ye161005Dto.getRevnDt());    /** column 수정일자 : revnDt */
			ye16Ta161005Vo.setRevnAddr(ye16Ta1005Dto.getRevnAddr());    												/** column 수정주소 : revnAddr */
			ye16Ta161005Vo.setReprName(MSFSharedUtils.allowNulls(ye16Ta1005Dto.getReprName()));    						/** column 대표자성명 : reprName */
			ye16Ta161005Vo.setResuNumb(AnyCryptUtils.getEncSyncCrypt(nResult, MSFSharedUtils.allowNulls(
					ye16Ta1005Dto.getResuNumb()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));    						/** column 주민등록번호 : resuNumb */
			
			
        	switch (actionDatabase) {
    		case INSERT:
    			
    			// insert 경우 데이터 중복 체크 후 작업 진행
    			if(ActionDatabase.INSERT.equals(actionDatabase)) {
    				
    				
    				int ye161005Check = ye16Ta161005DAO.selectYeta1100ToYeta2000ListTotCnt(ye16Ta161005Vo);
    				if(ye161005Check > 0) {
    					retInt = 3;	// 중복데이터 있을 경우 3리턴하여 메세지 표시
    				}else {
    					ye16Ta161005DAO.insertYe161005(ye16Ta161005Vo); 
    					retInt = 1;
    					
    				}
    			}
    			
    			
    			break;
        	case UPDATE: 
        		ye16Ta161005DAO.updateYe161005(ye16Ta161005Vo);
        		retInt = 1;
        		break;
        	case DELETE: 
        		ye16Ta161005DAO.deleteYe161005(ye16Ta161005Vo);
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
	public int saveYeta2000_YetaDpcd(List<Ye16Ta2000DTO> listYe16Ta2000Dto) throws MSFException {
	    	
		String method = calledClass + ".saveYeta2000_YetaDpcd";
	
		String windowNm = "연말정산대상자관리";
		String windowId = "YETA1100";
	    
		int retval = 0;
		BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  
		
			   
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		System.out.println("삭제자 : " + sessionUser.getDeptNm() + "["+ sessionUser.getUsrNm() + "]");
		
		Ye16Ta2000DTO ye16Ta2000Dto = new Ye16Ta2000DTO();
		Yeta2000VO yeta2000Vo = new Yeta2000VO();
		
		try { 
			
			for(int i = 0; i < listYe16Ta2000Dto.size(); i ++) {
				
				 
				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			    		
				ye16Ta2000Dto = new Ye16Ta2000DTO();
				ye16Ta2000Dto = listYe16Ta2000Dto.get(i); 
				
				yeta2000Vo.setDpobCd(ye16Ta2000Dto.getDpobCd());
				yeta2000Vo.setEdacRvyy(ye16Ta2000Dto.getEdacRvyy());
				yeta2000Vo.setSettGbcd(ye16Ta2000Dto.getSettGbcd());
				yeta2000Vo.setSystemkey(ye16Ta2000Dto.getSystemkey());
				yeta2000Vo.setYetaDpcd(ye16Ta2000Dto.getYetaDpcd());
				yeta2000Vo.setIsmt(sessionUser.getUsrId());
				yeta2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				ye16Ta2000DAO.updateYeta2000YetaDpcd(yeta2000Vo);
				
				retval = retval + 1;
			}
			
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
	public Ye16Ta1005DTO getYe161005List(Ye16Ta1005DTO yeta161005Dto) throws MSFException {
	    	
		String method = calledClass + ".getYe161005List";
	
		String windowNm = "연말정산대상자관리";
		String windowId = "YETA1100";
	    	 
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    		
		int retval = 0;
		BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  
		
			   
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		System.out.println("삭제자 : " + sessionUser.getDeptNm() + "["+ sessionUser.getUsrNm() + "]");
		
		Ye161005VO ye161005Vo = new Ye161005VO();
		
		try { 
			
			ye161005Vo = new Ye161005VO();
			ye161005Vo.setDpobCd(sessionUser.getDpobCd());
			ye161005Vo.setWhdgTxRegrstDeptCd(yeta161005Dto.getWhdgTxRegrstDeptCd());
			ye161005Vo.setBusoprRgstnum(yeta161005Dto.getBusoprRgstnum());
				
			ye161005Vo = ye16Ta161005DAO.selectYe161005List(ye161005Vo);
			
			
			yeta161005Dto = new Ye16Ta1005DTO();
			yeta161005Dto.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    						/** column 사업장코드 : dpobCd */
			yeta161005Dto.setWhdgTxRegrstDeptCd(MSFSharedUtils.allowNulls(ye161005Vo.getWhdgTxRegrstDeptCd()));    	/** column 원천세신고부서코드 : whdgTxRegrstDeptCd */
			yeta161005Dto.setHhrkWhdgRegrstDeptCd(MSFSharedUtils.allowNulls(ye161005Vo.getHhrkWhdgRegrstDeptCd()));	/** column 상위원천세신고부서코드 : hhrkWhdgRegrstDeptCd */
			yeta161005Dto.setTxOffcCd(MSFSharedUtils.allowNulls(ye161005Vo.getTxOffcCd()));    						/** column A3_세무서코드 : txOffcCd */
			yeta161005Dto.setPentrSeptCd(MSFSharedUtils.allowNulls(ye161005Vo.getPentrSeptCd()));    				/** column A5_제출자구분 : pentrSeptCd */
			yeta161005Dto.setTxDeptyMangeNum(MSFSharedUtils.allowNulls(ye161005Vo.getTxDeptyMangeNum()));    		/** column A6_세무대리인관리번호 : txDeptyMangeNum */
			yeta161005Dto.setHmtxId(MSFSharedUtils.allowNulls(ye161005Vo.getHmtxId()));    							/** column A7_홈텍스ID : hmtxId */
			yeta161005Dto.setTxPgmCd(MSFSharedUtils.allowNulls(ye161005Vo.getTxPgmCd()));    						/** column A8_세무프로그램코드 : txPgmCd */
			yeta161005Dto.setBusoprRgstnum(MSFSharedUtils.allowNulls(ye161005Vo.getBusoprRgstnum()));    			/** column A9_사업자등록번호 : busoprRgstnum */
			yeta161005Dto.setCorpFmnmNm(MSFSharedUtils.allowNulls(ye161005Vo.getCorpFmnmNm()));    					/** column A10_법인_상호명 : corpFmnmNm */
			yeta161005Dto.setPernChrgDeptNm(MSFSharedUtils.allowNulls(ye161005Vo.getPernChrgDeptNm()));    			/** column A11_담당자부서 : pernChrgDeptNm */
			yeta161005Dto.setPernChrgNm(MSFSharedUtils.allowNulls(ye161005Vo.getPernChrgNm()));    					/** column A12_담당자성명 : pernChrgNm */
			yeta161005Dto.setPernChrgPhnNum(MSFSharedUtils.allowNulls(ye161005Vo.getPernChrgPhnNum()));    			/** column A13_담당자전화번호 : pernChrgPhnNum */
			yeta161005Dto.setUseHanCd(MSFSharedUtils.allowNulls(ye161005Vo.getUseHanCd()));    						/** column A15_사용한글코드 : useHanCd */
			yeta161005Dto.setSumtTgtPridCd(MSFSharedUtils.allowNulls(ye161005Vo.getSumtTgtPridCd()));    			/** column B16_제출대상기간코드 : sumtTgtPridCd */
			yeta161005Dto.setCorpNum(MSFSharedUtils.allowNulls(ye161005Vo.getCorpNum()));    						/** column 법인번호 : corpNum */
			yeta161005Dto.setIncmPost(MSFSharedUtils.allowNulls(ye161005Vo.getIncmPost()));    						/** column 소득신고의무자우편번호 : incmPost */
			yeta161005Dto.setIncmAddr(MSFSharedUtils.allowNulls(ye161005Vo.getIncmAddr()));    						/** column 소득신고의무자기본주소 : incmAddr */
			yeta161005Dto.setIncmAdtl(MSFSharedUtils.allowNulls(ye161005Vo.getIncmAdtl()));    						/** column 소득신고의무자상세주소 : incmAdtl */
//			yeta161005Dto.setKybdr(ye161005Dto.getKybdr());    /** column 입력자 : kybdr */
//			yeta161005Dto.setInptDt(ye161005Dto.getInptDt());    /** column 입력일자 : inptDt */
//			yeta161005Dto.setInptAddr(ye161005Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//			yeta161005Dto.setIsmt(ye161005Dto.getIsmt());    /** column 수정자 : ismt */
//			yeta161005Dto.setRevnDt(ye161005Dto.getRevnDt());    /** column 수정일자 : revnDt */
//			yeta161005Dto.setRevnAddr(ye161005Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
			yeta161005Dto.setReprName(MSFSharedUtils.allowNulls(ye161005Vo.getReprName()));    						/** column 대표자성명 : reprName */
			
			// 복호화
			String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(ye161005Vo.getResuNumb()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
			yeta161005Dto.setResuNumb(rrnDecCrypt);    /** column 주민등록번호 : resuNumb */
			
			
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

		return yeta161005Dto;
	}  
	
	
	
	

}
