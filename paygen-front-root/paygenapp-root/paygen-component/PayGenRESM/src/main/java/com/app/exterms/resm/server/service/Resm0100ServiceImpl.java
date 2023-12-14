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
package com.app.exterms.resm.server.service;

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

import com.any.smrmf.utils.BeanFinder;
import com.app.exterms.resm.client.dto.Bass0300DTO;
import com.app.exterms.resm.client.service.Resm0100Service;
import com.app.exterms.resm.server.service.dao.ResmIfBass0300DAO;
import com.app.exterms.resm.server.vo.Bass0300SrhVO;
import com.app.exterms.resm.server.vo.Bass0300VO;
import com.app.exterms.resm.server.vo.Bass0350SrhVO;
import com.app.exterms.resm.shared.ResmDaoConstants;
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
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Resm0100Service")
public class Resm0100ServiceImpl extends AbstractCustomServiceImpl implements	ResmDaoConstants, Resm0100Service {
	
	private static final Logger logger = LoggerFactory.getLogger(Resm0100ServiceImpl.class);
	private static final String calledClass = Resm0100ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "ResmIfBass0300DAO")
	private ResmIfBass0300DAO resmIfBass0300DAO;
	
 

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getResm0100DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_RESM0100_BASS0300_DATA_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        Bass0300SrhVO bass0300SrhVO = new Bass0300SrhVO();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        try{
        	
        	resmIfBass0300DAO = (ResmIfBass0300DAO)BeanFinder.getBean("ResmIfBass0300DAO");
        	
        	
	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	            //Get query parameters
	            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	            /** 조건절 */
	            bass0300SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	            bass0300SrhVO.setRpsttvCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd")));
	            bass0300SrhVO.setCommCdNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "commCdNm")));
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = resmIfBass0300DAO.selectBass0300ListTotCnt(bass0300SrhVO);
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginPayr5010ToBass0300DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            bass0300SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	bass0300SrhVO.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	bass0300SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//			            Collection<Map<String, Object>> list ??????
	            List list = resmIfBass0300DAO.selectBass0300List(bass0300SrhVO);
	            
		        Iterator<Map<String, Object>> iter = list.iterator();
		            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
	            while ( iter.hasNext() ) {
	            	
	            	// 1. 암호화 객체 생성
	        		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        		
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("commCd").toString();
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginPayr5010ToBass0300DataList, "getPayr5010DataList");
	       

	        
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }
        return retval;
    }
	
	
	
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public String activityOnSaveBass0300(Bass0300DTO dto, ActionDatabase actionDatabase) throws MSFException {
		
		String method = calledClass + ".activityOnSaveBass0300";
		
		String windowNm = "단가직군관리";
		String windowId = "PAYR5010";
		 
		int returnCnt = 0;
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	
		Bass0300VO bass0300Vo = new Bass0300VO();
		
		if("".equals(dto.getDpobCd()) || dto.getDpobCd() == null){
			dto.setDpobCd(sessionUser.getDpobCd());
		}
		
		 
		bass0300Vo.setDpobCd(MSFSharedUtils.allowNulls(dto.getDpobCd()));    /** column 사업장코드 : dpobCd */
		bass0300Vo.setCommCd(MSFSharedUtils.allowNulls(dto.getCommCd()));    /** column 공통코드 : commCd */
		bass0300Vo.setRpsttvCd(MSFSharedUtils.allowNulls(dto.getRpsttvCd()));    /** column 대표코드 : rpsttvCd */
		bass0300Vo.setDtlCd(MSFSharedUtils.allowNulls(dto.getDtlCd()));    /** column 세부코드 : dtlCd */
		bass0300Vo.setCommCdNm(MSFSharedUtils.allowNulls(dto.getCommCdNm()));    /** column 공통코드명 : commCdNm */
		bass0300Vo.setAbbrNm(MSFSharedUtils.allowNulls(dto.getAbbrNm()));    /** column 약어명 : abbrNm */
		bass0300Vo.setEngNm(MSFSharedUtils.allowNulls(dto.getEngNm()));    /** column 영문명 : engNm */
		bass0300Vo.setMangeItem01(MSFSharedUtils.allowNulls(dto.getMangeItem01()));    /** column 관리항목01 : mangeItem01 */
		bass0300Vo.setMangeItem02(MSFSharedUtils.allowNulls(dto.getMangeItem02()));    /** column 관리항목02 : mangeItem02 */
		bass0300Vo.setMangeItem03(MSFSharedUtils.allowNulls(dto.getMangeItem03()));    /** column 관리항목03 : mangeItem03 */
		bass0300Vo.setMangeItem04(MSFSharedUtils.allowNulls(dto.getMangeItem04()));    /** column 관리항목04 : mangeItem04 */
		bass0300Vo.setMangeItem05(MSFSharedUtils.allowNulls(dto.getMangeItem05()));    /** column 관리항목05 : mangeItem05 */
		bass0300Vo.setMangeItem06(MSFSharedUtils.allowNulls(dto.getMangeItem06()));    /** column 관리항목06 : mangeItem06 */
		bass0300Vo.setMangeItem07(MSFSharedUtils.allowNulls(dto.getMangeItem07()));    /** column 관리항목07 : mangeItem07 */
		bass0300Vo.setMangeItem08(MSFSharedUtils.allowNulls(dto.getMangeItem08()));    /** column 관리항목08 : mangeItem08 */
		bass0300Vo.setMangeItem09(MSFSharedUtils.allowNulls(dto.getMangeItem09()));    /** column 관리항목09 : mangeItem09 */
		bass0300Vo.setMangeItem10(MSFSharedUtils.allowNulls(dto.getMangeItem10()));    /** column 관리항목10 : mangeItem10 */
		bass0300Vo.setMangeItem11(MSFSharedUtils.allowNulls(dto.getMangeItem11()));    /** column 관리항목11 : mangeItem11 */
		bass0300Vo.setMangeItem12(MSFSharedUtils.allowNulls(dto.getMangeItem12()));    /** column 관리항목12 : mangeItem12 */
		bass0300Vo.setMangeItem13(MSFSharedUtils.allowNulls(dto.getMangeItem13()));    /** column 관리항목13 : mangeItem13 */
		bass0300Vo.setMangeItem14(MSFSharedUtils.allowNulls(dto.getMangeItem14()));    /** column 관리항목14 : mangeItem14 */
		bass0300Vo.setMangeItem15(MSFSharedUtils.allowNulls(dto.getMangeItem15()));    /** column 관리항목15 : mangeItem15 */
		bass0300Vo.setMangeItem16(MSFSharedUtils.allowNulls(dto.getMangeItem16()));    /** column 관리항목16 : mangeItem16 */
		bass0300Vo.setMangeItem17(MSFSharedUtils.allowNulls(dto.getMangeItem17()));    /** column 관리항목17 : mangeItem17 */
		bass0300Vo.setMangeItem18(MSFSharedUtils.allowNulls(dto.getMangeItem18()));    /** column 관리항목18 : mangeItem18 */
		bass0300Vo.setMangeItem19(MSFSharedUtils.allowNulls(dto.getMangeItem19()));    /** column 관리항목19 : mangeItem19 */
		bass0300Vo.setMangeItem20(MSFSharedUtils.allowNulls(dto.getMangeItem20()));    /** column 관리항목20 : mangeItem20 */
		bass0300Vo.setCdTreeLvl(MSFSharedUtils.allowNulls(dto.getCdTreeLvl()));    /** column 코드TREE레벨 : cdTreeLvl */
		bass0300Vo.setOrd(new BigDecimal(MSFSharedUtils.defaultNulls(dto.getOrd(),"0")));    /** column 순서 : ord */
		bass0300Vo.setOpnYn(MSFSharedUtils.allowNulls(dto.getOpnYn()));    /** column 오픈여부 : opnYn */
		bass0300Vo.setUseYn(MSFSharedUtils.allowNulls(dto.getUseYn()));    /** column 사용여부 : useYn */
		bass0300Vo.setNote(MSFSharedUtils.allowNulls(dto.getNote()));    /** column 비고 : note */
//		bass0300Vo.setKybdr(MSFSharedUtils.allowNulls(dto.getKybdr()));    /** column 입력자 : kybdr */
//		bass0300Vo.setInptDt(MSFSharedUtils.allowNulls(dto.getInptDt()));    /** column 입력일자 : inptDt */
//		bass0300Vo.setInptAddr(MSFSharedUtils.allowNulls(dto.getInptAddr()));    /** column 입력주소 : inptAddr */
		bass0300Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
	//	bass0300Vo.setRevnDt(MSFSharedUtils.allowNulls(dto.getRevnDt()));    /** column 수정일자 : revnDt */
		bass0300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정자주소 : revnAddr */



		try {
			switch(actionDatabase){
				case INSERT :
					resmIfBass0300DAO.insertBass0300(bass0300Vo);
						returnCnt = 1;
					break;
				case UPDATE : 
					returnCnt = resmIfBass0300DAO.updateBass0300(bass0300Vo);
					break;
				}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(), e, windowNm , windowId);
			
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
		
		return returnCnt+"";
	}
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public String activityOnDeleteBass0300(Bass0300DTO dto) throws MSFException {
		
		String method = calledClass + ".activityOnDeleteBass0300";
		
		String windowNm = "단가직군관리";
		String windowId = "PAYR5010";
		
		int returnCnt = 0;
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if("".equals(dto.getDpobCd()) || dto.getDpobCd() == null){
			dto.setDpobCd(sessionUser.getDpobCd());
		}
		
		 
		Bass0350SrhVO bass0350SrhVo = new Bass0350SrhVO();
		Bass0300VO bass0300Vo = new Bass0300VO();
		
		bass0300Vo.setDpobCd(MSFSharedUtils.allowNulls(dto.getDpobCd()));    /** column 사업장코드 : dpobCd */
		bass0300Vo.setCommCd(MSFSharedUtils.allowNulls(dto.getCommCd()));    /** column 공통코드 : commCd */
		
		try {
			
			bass0350SrhVo.setDpobCd(dto.getDpobCd());    					/** column 사업장코드 : dpobCd */
			bass0350SrhVo.setDtilOccuJbfmlDivCd(dto.getCommCd());
			
//			String strJobSeptDivCd = "";
						
			if(0 < resmIfBass0300DAO.selectBass0350TopListTotCnt(bass0350SrhVo)){
				
				returnCnt = 2;
				
			}else{
				
				returnCnt = resmIfBass0300DAO.deleteBass0300(bass0300Vo);
				
			}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:D",e, windowNm , windowId);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:D" );
		
		return returnCnt+"";
	}
}
