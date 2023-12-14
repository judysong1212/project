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
package com.app.smrmf.sysauth.systemmtr.server.service;

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
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.sysauth.systemmtr.client.dto.SysMtrSysm0050DTO;
import com.app.smrmf.sysauth.systemmtr.client.dto.SysMtrSysm0051DTO;
import com.app.smrmf.sysauth.systemmtr.client.service.SysmMtr0100Service;
import com.app.smrmf.sysauth.systemmtr.shared.SysmMtrDaoConstants;
import com.app.smrmf.sysm.server.service.dao.Sysm0050DAO;
import com.app.smrmf.sysm.server.service.dao.Sysm0051DAO;
import com.app.smrmf.sysm.server.service.dao.Sysm0100DAO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0050SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0050VO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0051VO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0100SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0100VO;
import com.crypto.service.AnyCryptService;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
@Service("SysmMtr0100Service") 
public class SysmMtr0100ServiceImpl  extends AbstractCustomServiceImpl implements  SysmMtrDaoConstants ,SysmMtr0100Service  {

	private static final Logger logger = LoggerFactory.getLogger(SysmMtr0100ServiceImpl.class);
	private static final String calledClass = SysmMtr0100ServiceImpl.class.getName();
	
	@Autowired 
	@Resource(name="Sysm0100DAO")
	private Sysm0100DAO sysm0100DAO;
	
	@Autowired 
	@Resource(name="Sysm0050DAO")
	private Sysm0050DAO sysm0050DAO;
	
	@Autowired 
	@Resource(name="Sysm0051DAO")
	private Sysm0051DAO sysm0051DAO;
	  
	
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
	            	
	             	sysm0100vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    			/** column 입력자 : kybdr */
//	    			sysm0100vo.setInptDt(psnl0115Dto.getInptDt());    /** column 입력일자 : inptDt */
	            	sysm0100vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 	/** column 입력주소 : inptAddr */
	            	sysm0100vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    			/** column 수정자 : ismt */
//	    			sysm0100vo.setRevnDt(psnl0115Dto.getRevnDt());    /** column 수정일자 : revnDt */
	            	sysm0100vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 	/** column 수정주소 : revnAddr */ 
	    			
	            	
		        	  
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
	   
	public PagingLoadResult<BaseModel> getSelectSysmEx0100List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_SYSMEX0100_LIST;
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
	
	/** 시스템정보 저장/삭제 처리 **/
	@Override
	public int saveSysMtr0050(SysMtrSysm0050DTO dto, ActionDatabase actionDatabase)throws MSFException {
		int returnCnt = 0;
	//	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		String method = calledClass + ".saveSysMtr0050";
		
		String windowNm = "시스템사업장관리";
		String windowId = "SYSMMTR0100";

		 
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		SysIfSysm0050VO sysm0050Vo = new SysIfSysm0050VO();
		SysIfSysm0051VO sysm0051Vo = new SysIfSysm0051VO();
		SysIfSysm0050SrhVO sysm0050SrhVo = new SysIfSysm0050SrhVO();
		
		
				
		

		sysm0050Vo.setSysDpobCd(MSFSharedUtils.allowNulls(dto.getSysDpobCd()));    /** column 시스템사업장코드 : sysDpobCd */
		sysm0050Vo.setSysDpobNm(MSFSharedUtils.allowNulls(dto.getSysDpobNm()));    /** column 시스템사업장명 : sysDpobNm */
		sysm0050Vo.setSysDpobKey(MSFSharedUtils.allowNulls(dto.getSysDpobKey()));    /** column 시스템사업장KEY : sysDpobKey */
		sysm0050Vo.setUseSysDivCd(MSFSharedUtils.allowNulls(dto.getUseSysDivCd()));    /** column 사용시스템구분코드 : useSysDivCd */
		sysm0050Vo.setSysDpobUseYn(MSFSharedUtils.allowNulls(dto.getSysDpobUseYn()));    /** column 시스템사업장사용여부 : sysDpobUseYn */
		sysm0050Vo.setSysDpobBgnDt(MSFSharedUtils.allowNulls(dto.getSysDpobBgnDt()));    /** column 시스템사업장개시일자 : sysDpobBgnDt */
		sysm0050Vo.setSysDpobEdDt(MSFSharedUtils.allowNulls(dto.getSysDpobEdDt()));    /** column 시스템사업장종료일자 : sysDpobEdDt */
		sysm0050Vo.setSysDpobCtnt(MSFSharedUtils.allowNulls(dto.getSysDpobCtnt()));    /** column 시스템사업장내용 : sysDpobCtnt */
		 
		
		sysm0050Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
		sysm0050Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));
		
		
		try {
			switch(actionDatabase){
				case INSERT : 
					sysm0050SrhVo = new SysIfSysm0050SrhVO();
					sysm0050SrhVo.setSysDpobCd(sysm0050Vo.getSysDpobCd());
					
					
					 int i = sysm0050DAO.selectSysm0050ListTotCnt(sysm0050SrhVo);
					 
					 if(i > 0 ) {
						 
						 returnCnt = 3;
						 
					 }else {
						 
						 sysm0050Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
						 sysm0050Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));
						 sysm0050DAO.insertSysm0050(sysm0050Vo);
								
						 returnCnt = 1;
						 
					 }
					
					break;
					
				case UPDATE : 
						sysm0050DAO.updateSysm0050(sysm0050Vo);
						
						returnCnt = 1;
						
					break;
					
				case DELETE : 
					
					sysm0050SrhVo = new SysIfSysm0050SrhVO();
					sysm0050SrhVo.setSysDpobCd(sysm0050Vo.getSysDpobCd());
					int iCnt = sysm0050DAO.selectSysmMtrToBass0100ListTotCnt(sysm0050SrhVo);
					
					if(iCnt > 0 ) {
						
						returnCnt = 13;
          				
					}else {
						
				 
						sysm0050DAO.deleteSysm0050(sysm0050Vo);	// 시스템정보 삭제
						
						returnCnt = 1;
					}
					
					break;
					
			} 
		}catch (Exception e) {
			// TODO Auto-generated catch block
			
			returnCnt = 0;
			
			e.printStackTrace();
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), e, windowNm, windowId);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
		
		return returnCnt;
	}

	@Override
	public int delChkSysMtr0050(List<SysMtrSysm0051DTO> dtoList,
			ActionDatabase actionDatabase) throws MSFException {
		// TODO Auto-generated method stub
		return 0;
	}	
	 
	 
}
