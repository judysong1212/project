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
package com.app.smrmf.sysauth.systemusr.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
import com.app.smrmf.sysauth.systemusr.client.dto.SysmUsr0100DTO;
import com.app.smrmf.sysauth.systemusr.client.service.SysmUsr0050Service;
import com.app.smrmf.sysauth.systemusr.shared.SysmUsrDaoConstants;
import com.app.smrmf.sysm.server.service.dao.Sysm0100DAO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0100SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0100VO;
import com.crypto.service.AnyCryptService;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

import egovframework.rte.psl.dataaccess.util.EgovMap;
@Service("SysmUsr0050Service") 
public class SysmUsr0050ServiceImpl  extends AbstractCustomServiceImpl implements  SysmUsrDaoConstants ,SysmUsr0050Service  {

	private static final Logger logger = LoggerFactory.getLogger(SysmUsr0050ServiceImpl.class);
	private static final String calledClass = SysmUsr0050ServiceImpl.class.getName();
	
	@Autowired 
	@Resource(name="Sysm0100DAO")
	private Sysm0100DAO sysm0100DAO;
	  
	 /** 암호화 모듈 호출  */
    @Resource(name = "AnyCryptService")
    protected AnyCryptService payGenCryptService;
    
	
	   public List<BaseModel> activityOnSysm0100Cud(ServiceParameters serviceParameters) {
		   
		   String method =  calledClass + ".activityOnSysm0100Cud";		
		     
    	   List<BaseModel> lsBmResult = new ArrayList<BaseModel>();
	       String result = "1";  
	       
	       List<BaseModel> listObjects       = serviceParameters.getDataObjects();
	       ActionDatabase actionDatabase     = serviceParameters.getActionDatabase(); 
	       String customMethodName           = serviceParameters.getCustomMethodName();
	       ColumnAttribute[] tableAttributes = serviceParameters.getTableAttributes();
	       Boolean reloadData                = serviceParameters.isReloadData();
	       Boolean noHistory                 = serviceParameters.isNoHistory(); 
	       
	       MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(sysm0100DAO)) {
	        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	        			 getRequiredWebApplicationContext( RemoteServiceUtil.getThreadLocalRequest().getSession().getServletContext());
	                   // getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	sysm0100DAO = (Sysm0100DAO) wac.getBean("Sysm0100DAO" ); 
	        }
	        
	        if  (MSFSharedUtils.paramNull(payGenCryptService)) {
		        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	        			 getRequiredWebApplicationContext( RemoteServiceUtil.getThreadLocalRequest().getSession().getServletContext());
	                   // getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	payGenCryptService = (AnyCryptService) wac.getBean("AnyCryptService" ); 
	        }
	        
	       try {
	             
	            for (BaseModel objectBm : listObjects) { 
	            
	            	String pwdCryptSHA512 = "";
	            	SysIfSysm0100VO sysm0100vo = new SysIfSysm0100VO();
	            	sysm0100vo.setSysDivCd(MSFSharedUtils.defaultNulls(objectBm.get("sysDivCd"),"EXTERM00")) ;
	            	sysm0100vo.setUsrId(MSFSharedUtils.allowNulls(objectBm.get("usrId")));/** set 사용자아이디 : usrId */
	            	sysm0100vo.setUsrNm(MSFSharedUtils.allowNulls(objectBm.get("usrNm")));/** set 사용자성명 : usrNm */
	            	
	            	if (MSFSharedUtils.paramNotNull(objectBm.get("typOccuCd$typOccuCd")) && (!MSFSharedUtils.allowNulls(objectBm.get("typOccuCd$typOccuCd")).equals("!"))) {
	            	    String[] tptypOccuCd = MSFSharedUtils.allowNulls(objectBm.get("typOccuCd$typOccuCd")).split("!"); 
	                    sysm0100vo.setTypOccuCd(tptypOccuCd[0]);    /** column 직종코드 : typOccuCd */
	                    sysm0100vo.setPyspGrdeCd(tptypOccuCd[1]);    /** column 호봉등급코드 : pyspGrdeCd */
	                } else {
	                    sysm0100vo.setTypOccuCd("");    /** column 직종코드 : typOccuCd */
                        sysm0100vo.setPyspGrdeCd("");    /** column 호봉등급코드 : pyspGrdeCd */  
	                }
	            	sysm0100vo.setUsrDivCd(MSFSharedUtils.allowNulls(objectBm.get("usrDivCd$commCd")));/** set 사용자구분코드 : usrDivCd */
	            	sysm0100vo.setSystemkey(MSFSharedUtils.allowNulls(objectBm.get("systemkey")));/** set SYSTEMKEY : systemkey */
	            	sysm0100vo.setDeptCd(MSFSharedUtils.allowNulls(objectBm.get("deptCd$deptCd")));/** set 부서코드 : deptCd */
	            	sysm0100vo.setUsrTel(MSFSharedUtils.allowNulls(objectBm.get("usrTel")));/** set null : usrTel */
	            	sysm0100vo.setEmail(MSFSharedUtils.allowNulls(objectBm.get("email")));/** set 이메일 : email */
	            	
	            	sysm0100vo.setPwd(MSFSharedUtils.allowNulls(objectBm.get("tmpPwd")));/** set 패스워드 : pwd */
	            	//password  add 2015.11.05 
	            	if (MSFSharedUtils.paramNotNull(objectBm.get("pwd"))) {
	            		if (!MSFSharedUtils.allowNulls(objectBm.get("pwd")).equals(MSFSharedUtils.allowNulls(objectBm.get("tmpPwd")))) {
	            			
	            			pwdCryptSHA512 = payGenCryptService.payGenEncryptSHA256(MSFSharedUtils.allowNulls(objectBm.get("pwd")));
		            		
		            		if (!pwdCryptSHA512.equals(MSFSharedUtils.allowNulls(objectBm.get("tmpPwd")))) {
		            			sysm0100vo.setPwd(pwdCryptSHA512);/** set 패스워드 : pwd */
		            		} 
	            		}  	   
	            	} 
	            	
	            	//sysm0100vo.setPwd(MSFSharedUtils.allowNulls(objectBm.get("pwd")));/** set 패스워드 : pwd */
	            	 
	            	sysm0100vo.setUseYn((Boolean.TRUE.equals(objectBm.get("useYn")) ? "Y" : "N"));/** set 사용자사용여부 : useYn */ 
		        	  
		            switch (actionDatabase) {
		            case INSERT: 
		            	sysm0100DAO.insertSysm0100(sysm0100vo); 
		            	break;
		            case UPDATE:  
		                sysm0100DAO.updateSysm0100(sysm0100vo); 
		                break;
		            case DELETE: 
		                sysm0100DAO.deleteSysm0100(sysm0100vo);
		                break;
		            }  
		            
					/** 로그반영
					 * CRUDSBLO
					 * C   //create  
				   	 * R   //read
				   	 * U   //update
				   	 * D   //delete
				   	 * S   //select
				   	 * B   //배치 
				   	 * L   //로그인 
				   	 * O   //로그아웃
				   	 */
			       	MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
		   
               } 
	            
	           // lsBmResult.add(outbm);
	        }
	        catch (Exception ex) {
	            logger.error("EXCEPTION calling activityOnSysm0100Cud(): "+ex); 
	            ex.printStackTrace();
	            result = "0";
	        }
	        finally {
	          
	        }
	        return lsBmResult;
	    }	
	   
	public PagingLoadResult<BaseModel> getSelectSysm0100List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_SYSMUSR0100_LIST;
        SysIfSysm0100SrhVO   sysm0100SrhVo = new SysIfSysm0100SrhVO();
        SysIfSysm0100VO      sysm0100Vo = new SysIfSysm0100VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(sysm0100DAO)) {
        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	sysm0100DAO = (Sysm0100DAO) wac.getBean("Sysm0100DAO" ); 
        }
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0100BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
            sysm0100SrhVo.setDpobCd(sessionUser.getDpobCd());
            sysm0100SrhVo.setSysDivCd("EXTERM00"); //
            sysm0100SrhVo.setUsrNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm")));    //검색조건처리 
            sysm0100SrhVo.setUsrDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrDivCd"))); 
            
            
            
            
            sysm0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))); 
            sysm0100SrhVo.setSearchKeyword(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "searchKeyword"),"N")); 
            
            //sysComSrhVo.setRpsttvCd(strCriteriaValue); 
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	            if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = sysm0100DAO.selectSysm0100ListTotCnt(sysm0100SrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectSysm0100List = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            sysm0100SrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	sysm0100SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	sysm0100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = sysm0100DAO.selectSysm0100List(sysm0100SrhVo);
            
	            Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("usrId").toString();
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
                	//} else if (tableAttributes[i].getName().contains("pwd")) {
                		//암호화 필드 복호화 하지 않음 제외 함.패스워드 처리 로직 
                	//     baseModelValue = "";
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectSysm0100List, "selectSysm0100List");

        } catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	
	
	/** 사용자정보 저장 **/
	@Override
	public int saveSysmUsr0100(SysmUsr0100DTO sysmUsr0100DTO, ActionDatabase actionDatabase)throws MSFException {
		
		String method = calledClass + ".saveSysmUsr0100";
		
		String windowNm = "사용자관리";
		String windowId = "SYSMUSR0100";
		
		int result = 1;
		String pwdCryptSHA512 = "";
		
		//암호화 객체 생성
		String nResult;
		try {
			nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	
		
	    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	    	SysIfSysm0100VO sysm0100vo = new SysIfSysm0100VO();
			 
			try{
				
				sysm0100vo = new SysIfSysm0100VO();
	        	
			   
			  	sysm0100vo.setSysDivCd(MSFSharedUtils.allowNulls("EXTERM00")); 														/** column 시스템구분코드 : sysDivCd */
			  	sysm0100vo.setUsrId(MSFSharedUtils.allowNulls(sysmUsr0100DTO.getUsrId()));	 										/** column 사용자아이디 : usrId */
			  	sysm0100vo.setUsrNm(MSFSharedUtils.allowNulls(sysmUsr0100DTO.getUsrNm()));											/** column 사용자성명 : usrNm */
			  	sysm0100vo.setUsrDivCd(MSFSharedUtils.allowNulls(sysmUsr0100DTO.getUsrDivCd()));									/** column 사용자구분코드 : usrDivCd */
			  	sysm0100vo.setSystemkey(MSFSharedUtils.allowNulls(sysmUsr0100DTO.getSystemkey()));									/** column SYSTEMKEY : systemkey */
			   	sysm0100vo.setDeptCd(MSFSharedUtils.allowNulls(sysmUsr0100DTO.getDeptCd()));   										/** column 부서코드 : deptCd */	
			   	sysm0100vo.setUsrTel(MSFSharedUtils.allowNulls(sysmUsr0100DTO.getUsrTel()));										/** column null : usrTel */
			   	sysm0100vo.setEmail(MSFSharedUtils.allowNulls(sysmUsr0100DTO.getEmail()));											/** column 이메일 : email */
	//		   	sysm0100vo.setPwd(MSFSharedUtils.allowNulls(sysmUsr0100DTO.getPwd()));												/** column 패스워드 : pwd */
			   	sysm0100vo.setPwd(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(sysmUsr0100DTO.getPwd()),AnyCryptUtils.SEC_RRNUMC));	/** column 패스워드 : pwd */	   	
			   	sysm0100vo.setUseYn(MSFSharedUtils.defaultNulls(sysmUsr0100DTO.getUseYn(), "N"));									/** column 사용여부 : USE_YN */
			    sysm0100vo.setTypOccuCd(MSFSharedUtils.allowNulls(sysmUsr0100DTO.getTypOccuCd()));  								/** column 직종코드 : typOccuCd */
			    sysm0100vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(sysmUsr0100DTO.getPyspGrdeCd()));   								/** column 호봉등급코드 : pyspGrdeCd */
			    sysm0100vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(sysmUsr0100DTO.getDtilOccuInttnCd()));      				/** column 직종세통합코드 : dtilOccuInttnCd */						
			    sysm0100vo.setUsrAuthEepnYn(MSFSharedUtils.defaultNulls(sysmUsr0100DTO.getUsrAuthEepnYn(), "N"));					/** column 사용자권한제외여부 : usrAuthEepnYn */   	
			    sysm0100vo.setPyspInsnYn(MSFSharedUtils.defaultNulls(sysmUsr0100DTO.getPyspInsnYn(), "N"));    						/** column 호봉제포함여부 : pyspInsnYn */
			    sysm0100vo.setNotPyspInsnYn(MSFSharedUtils.defaultNulls(sysmUsr0100DTO.getNotPyspInsnYn(), "N"));					/** column 비호봉제포함여부 : notPyspInsnYn */   	
			    sysm0100vo.setServcInptPrcsYn(MSFSharedUtils.defaultNulls(sysmUsr0100DTO.getServcInptPrcsYn(), "N")); 				/** column 복무입력처리여부 : servcInptPrcsYn */
			    sysm0100vo.setYrtxInptPrcsYn(MSFSharedUtils.defaultNulls(sysmUsr0100DTO.getYrtxInptPrcsYn(), "N")); 				/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
			    sysm0100vo.setShttmInsnYn(MSFSharedUtils.defaultNulls(sysmUsr0100DTO.getShttmInsnYn(), "N")); 						/** column 기간제포함여부 : shttmInsnYn */
			    sysm0100vo.setUsrAuthDivCd(MSFSharedUtils.defaultNulls(sysmUsr0100DTO.getUsrAuthDivCd (), "N") );					/** column 사용자권한구분코드 : usrAuthDivCd */
			   	sysm0100vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    											/** column 입력자 : kybdr */
			   	sysm0100vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  		/** column 입력주소 : inptAddr */
			   	sysm0100vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    											/** column 수정자 : ismt */
	    		sysm0100vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  		/** column 수정주소 : revnAddr */
			    
	
	        	
	        	//sysm0100vo.setPwd(MSFSharedUtils.allowNulls(objectBm.get("pwd")));/** set 패스워드 : pwd */
				
				
	            switch (actionDatabase) {
	            case INSERT: 
	            	sysm0100DAO.insertSysmUsr0100(sysm0100vo); 
	            	break;
	            case UPDATE:  
	                sysm0100DAO.updateSysmUsr0100(sysm0100vo); 
	                break;
	//            case DELETE: 
	//                sysm0100DAO.deleteSysm0100(sysm0100vo);
	//                break;
	            }  
	            	
	            	
				
			}catch(Exception e){
				
				result = 0;
				
				e.printStackTrace();
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C:U",e, windowNm , windowId);
				throw MSFServerUtils.getOperationException(this.getClass().getName() + " " + "저장에 실패하였습니다. </BR> 데이터를 확인해 주세요.", e, logger);
				
			}		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return result;
	}
	
	/** 패스워드를 초기화할 근로자의 정보를 가져온다. **/
	public SysmUsr0100DTO getPwdInitUsrInfo(SysmUsr0100DTO sysmUsr0100Dto) throws MSFException {
		
		 
		MSFSysm0100BM sessionUser;
		
		String method = calledClass + ".getPwdInitUsrInfo";
		
		String windowNm = "사용자관리";
		String windowId = "SYSMU0100";
		
		// 1. 암호화 객체 생성
		String nResult;
		try {
			nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		
        if  (MSFSharedUtils.paramNull(sysm0100DAO)) {
	        
        	WebApplicationContext wac = WebApplicationContextUtils.
        			 getRequiredWebApplicationContext( RemoteServiceUtil.getThreadLocalRequest().getSession().getServletContext());
                   // getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	sysm0100DAO = (Sysm0100DAO) wac.getBean("Sysm0100DAO" ); 
        }
        
        
        
		   
        SysIfSysm0100VO   sysm0100Vo = new SysIfSysm0100VO();
        
//        String strUsrDivCd = sysmUsr0100Dto.getUsrDivCd();
        
       
        
		List egovResultDataList = new ArrayList();

			try {
				
				sysm0100Vo.setUsrId(sysmUsr0100Dto.getUsrId());
				
				egovResultDataList =  sysm0100DAO.selectSysm0100Info(sysm0100Vo);
				
				// 2.복호화 리턴받을 값 선언
				String rrnDecCrypt = "";
				
				sysmUsr0100Dto = new SysmUsr0100DTO();
	
				if(egovResultDataList != null && egovResultDataList.size() > 0){
		      		for(int i=0; i<egovResultDataList.size(); i++){
		      			EgovMap eMap  = new EgovMap();
		      			eMap = (EgovMap) egovResultDataList.get(i);
		      			
		      			sysmUsr0100Dto.setUsrId(MSFSharedUtils.allowNulls(eMap.get("usrId")));
		      			sysmUsr0100Dto.setSystemkey(MSFSharedUtils.allowNulls(eMap.get("systemkey")));
		      			
		      			
		      			if(MSFSharedUtils.paramNotNull(eMap.get("yoobhMnthDay"))) {
		      				
		      				String strYoobhMnthDay = MSFSharedUtils.allowNulls(eMap.get("yoobhMnthDay"));
		      				sysmUsr0100Dto.setYoobhMnthDay(strYoobhMnthDay.substring(0, 6));
		      				
		      				
		      			}
		      			
		      			
		      			// TODO 주민번호
		      			String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		      			sysmUsr0100Dto.setResnRegnNum(strValue);
		      		
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
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return sysmUsr0100Dto;
		
	}
	
	
	
	
	
	
	
	
	

    @Override
    public void batchServiceUser() {
        // TODO Auto-generated method stub
//        String encrypted = "";
//        String origin_data = ""; //복호화된 값을 저장할 별수
//        SysComPsnl0100VO userPsnlVo = new SysComPsnl0100VO();
//        
//            try {
//               
//               List list = sysm0100DAO.selectSSoUserList(); 
//               Iterator<Map<String, Object>> iter = list.iterator();
//                
//              
//               while ( iter.hasNext() ) {
//                   Map<String, Object> map = (Map<String, Object>) iter.next();
//                    
//                   if (MSFSharedUtils.paramNotNull(map.get("userSn"))) {
//                       origin_data = crypt.dec( MSFSharedUtils.allowNulls(map.get("userSn")));
//                       
//                       SysComPsnl0100VO tpUserPsnlVo = new SysComPsnl0100VO();
//                       
//                       tpUserPsnlVo.setDpobCd("20144050000001");
//                       tpUserPsnlVo.setResnRegnNum(origin_data);
//                       
//                       userPsnlVo = sysm0100DAO.selectPsnlUser0100(tpUserPsnlVo);  
//                  
//                       SysIfSysm0100VO sysm0100vo = new SysIfSysm0100VO();
//                       sysm0100vo.setSysDivCd("EXTERM00") ;
//                       sysm0100vo.setUsrId(MSFSharedUtils.allowNulls(map.get("userId")));/** set 사용자아이디 : usrId */
//                       sysm0100vo.setUsrNm(MSFSharedUtils.allowNulls(map.get("userName")));/** set 사용자성명 : usrNm */
//                       
//                       sysm0100vo.setUsrDivCd("");/** set 사용자구분코드 : usrDivCd */
//                       sysm0100vo.setSystemkey("");/** set SYSTEMKEY : systemkey */
//                       
//                       sysm0100vo.setTypOccuCd("");    /** column 직종코드 : typOccuCd */
//                       sysm0100vo.setPyspGrdeCd("");    /** column 호봉등급코드 : pyspGrdeCd */   
//                       sysm0100vo.setDeptCd(MSFSharedUtils.allowNulls(map.get("deptId")));/** set 부서코드 : deptCd */
//                       sysm0100vo.setUsrTel(MSFSharedUtils.allowNulls(map.get("tel")));/** set null : usrTel */
//                       sysm0100vo.setEmail(MSFSharedUtils.allowNulls(map.get("email")));/** set 이메일 : email */
//                       sysm0100vo.setPwd("a12345");/** set 패스워드 : pwd */
//                       sysm0100vo.setUseYn("Y");/** set 사용자사용여부 : useYn */
//                       
//                       if (MSFSharedUtils.paramNotNull(userPsnlVo) && MSFSharedUtils.paramNotNull(userPsnlVo.getSystemkey()) ) {
//                         
//                           sysm0100vo.setUsrDivCd(MSFSharedUtils.allowNulls(userPsnlVo.getEmymtDivCd()));/** set 사용자구분코드 : usrDivCd */
//                           sysm0100vo.setSystemkey(MSFSharedUtils.allowNulls(userPsnlVo.getSystemkey()));/** set SYSTEMKEY : systemkey */
//                           
//                           if (MSFSharedUtils.paramNotNull(map.get("usrId"))) {
//                               sysm0100DAO.updateUserSysm0100(sysm0100vo); 
//                           } else {
//                              
//                               sysm0100DAO.insertSysm0100(sysm0100vo); 
//                           }
//                           
//                       }  else {
//                           //공무원담당자...
//                       }   
//                   
//                   }
//               }   
//                   
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
    }
	 
}
