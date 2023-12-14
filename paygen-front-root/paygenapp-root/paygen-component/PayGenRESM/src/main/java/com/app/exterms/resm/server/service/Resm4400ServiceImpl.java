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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.resm.client.dto.Bass0320DTO;
import com.app.exterms.resm.client.service.Resm4400Service;
import com.app.exterms.resm.server.service.dao.ResmIfBass0320DAO;
import com.app.exterms.resm.server.vo.Bass0320SrhVO;
import com.app.exterms.resm.server.vo.Bass0320VO;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
 
@Service("Resm4400Service")
public class Resm4400ServiceImpl extends AbstractCustomServiceImpl  implements  ResmDaoConstants ,Resm4400Service {

	private static final Logger logger = LoggerFactory.getLogger(Resm4400ServiceImpl.class);
	private static final String calledClass = Resm4400ServiceImpl.class.getName();
	
@Autowired
@Resource(name="ResmIfBass0320DAO")
private ResmIfBass0320DAO bass0320DAO;
 

public PagingLoadResult<BaseModel> getSelectBass0320ToBass0320List(ServiceParameters serviceParameters) throws MSFException {

   PagingLoadResult<BaseModel> retval = null;
   String method =  CLASS_RESM1100TOBASS0320_LIST;
   Bass0320SrhVO   bass0320SrhVo = new Bass0320SrhVO();
   Bass0320VO      bass0320Vo = new Bass0320VO();
   List<BaseModel> bmResult = new ArrayList<BaseModel>();
   
   MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
   
   if  (MSFSharedUtils.paramNull(bass0320DAO)) {
   
       WebApplicationContext wac = WebApplicationContextUtils.
               getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

       bass0320DAO = (ResmIfBass0320DAO) wac.getBean("ResmIfBass0320DAO"); 
   }
   
   try {
       //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
      // Bass0320BM          user             = serviceParameters.getUser();
       ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
       IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
       List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
       PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

       //Get paging configuration
       PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

       /** 조건절 */
       bass0320SrhVo.setDpobCd(sessionUser.getDpobCd()); 
       bass0320SrhVo.setTypOccuNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuNm")));    //검색조건처리 
       bass0320SrhVo.setTypOccuUseYn(MSFServerUtils.getFilterValue(columnFilters, "srhTypOccuUseYn") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhTypOccuUseYn")));
       
       //sysComSrhVo.setRpsttvCd(strCriteriaValue); 
    
       //페이징 
       //Get total record count //전체 데이터 갯수를 가지고 온다. 
           if ( pagingValues.executeRecordCount ) { 
               
           //Execute query that returns a single value
           TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            
           int iResultCnt = bass0320DAO.selectBass0320ListTotCnt(bass0320SrhVo);  
         
           SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
           pagingValues.totalRecordCount = iResultCnt;        
           
           logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
       }
   
       TimingInfo millisBeginSelectBass0320List = SmrmfUtils.startTiming(logger);
   
       /**페이지 카운트 처리를 위한 부분 */ 
       bass0320SrhVo.setPageSize(pagingValues.totalRecordCount);  
       
       //Apply paging
       if (pagingValues.start > 0) {
           bass0320SrhVo.setFirstIndex(pagingValues.start);
       }
       if (pagingValues.offsetLimit > 0) {
           bass0320SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
       }

       //Execute query and convert to BaseModel list
       TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
       
       @SuppressWarnings("unchecked")
//       Collection<Map<String, Object>> list ??????
       List list = bass0320DAO.selectBass0320List(bass0320SrhVo);
       
           Iterator<Map<String, Object>> iter = list.iterator();
           
       SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
      
       while ( iter.hasNext() ) {
           Map<String, Object> map = (Map<String, Object>) iter.next();
           String idValue = map.get("typOccuCd").toString();
           BaseModel bm = new BaseModel();

           //bm.setProperties(map);
           for ( int i=0 ; i<tableAttributes.length ; i++ ) {
             //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++   
               Object mapCon = map.get(tableAttributes[i].getName());  
                
               switch ( tableAttributes[i].getType() ) {  
               case ColumnDef.TYPE_DATE: 
               case ColumnDef.TYPE_DATETIME: 
                  
                Date value =  SmrmfUtils.getDateFromString(String.valueOf(mapCon),"  ");
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
                   
                   //길이가 긴데이타가 있어 어쩔수 없이 루틴 추가 schlExpnAdmclExtpyDivCdcommCdNm
                   if (strMapCon.equals("dtiloccuclsdivcddtiloccuclsnm")) {
                       strMapCon = "dtiloccuclsdivcdcommcdnm";
                       
                   } else if (strMapCon.equals("dtiloccuclsdivcddtiloccuclsdivcd")) {
                       strMapCon = "dtiloccuclsdivcdcommcd";
                   }
                        
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
       
       SmrmfUtils.endTiming(logger, millisBeginSelectBass0320List, "selectBass0320List");
   }
   catch (Exception ex) {
       ex.printStackTrace();
       //Return operation exception
       throw MSFServerUtils.getOperationException(method, ex, logger);
   }
   return retval;
} 

@Override
public Long saveBass0320(Bass0320DTO bass0320Dto, ActionDatabase actionDatabase) throws MSFException {
	Long returnCnt = 0L;
	
	String method = calledClass + ".saveBass0320";
	
	String windowNm = "직종관리";
	String windowId = "BASS0320";


	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	
	if("".equals(bass0320Dto.getDpobCd()) || bass0320Dto.getDpobCd() == null){
		bass0320Dto.setDpobCd(sessionUser.getDpobCd());
	}
	
	Bass0320VO bass0320Vo = new Bass0320VO();
	
  	
	try { 
		bass0320Vo.setDpobCd(MSFSharedUtils.allowNulls(bass0320Dto.getDpobCd()));    /** column 사업장코드 : dpobCd */
		bass0320Vo.setTypOccuCd(MSFSharedUtils.allowNulls(bass0320Dto.getTypOccuCd()));    /** column 직종코드 : typOccuCd */
		bass0320Vo.setTypOccuNm(MSFSharedUtils.allowNulls(bass0320Dto.getTypOccuNm()));    /** column 직종명 : typOccuNm */
		bass0320Vo.setTypOccuUseYn(MSFSharedUtils.allowNulls((Boolean.TRUE.equals(bass0320Dto.getTypOccuUseYn()) ? "Y" : "N") ));    /** column 직종사용여부 : typOccuUseYn */
		bass0320Vo.setTypOccuCtnt(MSFSharedUtils.allowNulls(bass0320Dto.getTypOccuCtnt()));    /** column 직종내용 : typOccuCtnt */
		bass0320Vo.setTypOccuOrd(new BigDecimal(MSFSharedUtils.defaultNulls(bass0320Dto.getTypOccuOrd(), "0")));    /** column 정렬순서 : typOccuOrd */
		bass0320Vo.setTypOccuJbfmlDivCd(MSFSharedUtils.allowNulls(bass0320Dto.getTypOccuJbfmlDivCd()));    /** column 직종직군구분코드 : typOccuJbfmlDivCd */
//		bass0320Vo.setPyspGrdeCd((MSFSharedUtils.allowNulls(bass0320Dto.getPyspGrdeCd()));    /** column null : pyspGrdeCd */
		bass0320Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
		//bass0320Vo.setInptDt(bass0320Dto.getInptDt());    /** column 입력일자 : inptDt */
		bass0320Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
		bass0320Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
		//bass0320Vo.setRevnDt(bass0320Dto.getRevnDt());    /** column 수정일자 : revnDt */
		bass0320Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
		
		// 장규민 추가
		bass0320Vo.setChngTypOccuCd(MSFSharedUtils.allowNulls(bass0320Dto.getChngTypOccuCd()));	/** column 이전 직종명 : chngTypOccuCd */
		bass0320Vo.setTypOccuStdt(MSFSharedUtils.allowNulls(bass0320Dto.getTypOccuStdt()));	/** column 시작일자 : typOccuStdt */
		bass0320Vo.setTypOccuEddt(MSFSharedUtils.allowNulls(bass0320Dto.getTypOccuEddt()));	/** column 종료일자 : typOccuEddt*/
		 
		switch(actionDatabase){
			case INSERT :				
				bass0320DAO.insertBass0320(bass0320Vo);
				bass0320DAO.updateXlsBass0320(bass0320Vo);
				break;
			case UPDATE : 
				bass0320DAO.updateBass0320(bass0320Vo);
				break;
			case DELETE : 
				bass0320DAO.deleteBass0320(bass0320Vo);
				break;
		}		
		
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
		
		 returnCnt = 1L;
		 
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		/** 에러 로그 **/			
		MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(),e, windowNm , windowId);
		
		returnCnt = 0L;
	}
	
	return returnCnt;
}

}
