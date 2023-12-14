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
package com.app.exterms.basis.server.service;

import java.util.ArrayList;
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

import com.app.exterms.basis.client.dto.Bass0400DTO;
import com.app.exterms.basis.client.service.Bass0400Service;
import com.app.exterms.basis.server.service.dao.Bass0400DAO;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
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
import com.app.smrmf.infc.basis.server.service.dao.InfcPkgOther0400DAO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0400SrhVO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0400VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Bass0400Service")
public class Bass0400ServiceImpl extends AbstractCustomServiceImpl implements
		BasisDaoConstants, Bass0400Service {
	
	private static final Logger logger = LoggerFactory.getLogger(Bass0400ServiceImpl.class);
	private static final String calledClass = Bass0400ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "Bass0400DAO")
	private Bass0400DAO bass0400DAO;
	
	
	@Autowired
	@Resource(name = "InfcPkgOther0400DAO")
	private InfcPkgOther0400DAO infcOther0400DAO;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectBass0400List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_BASS0400_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        Bass0400DTO srhDto = new Bass0400DTO();
        
        if(MSFSharedUtils.paramNull(bass0400DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
        	bass0400DAO = (Bass0400DAO) wac.getBean("Bass0400DAO");
        }
        try{
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
    		
            String srhDeptNm = MSFServerUtils.getFilterValue(columnFilters, "srhDeptNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDeptNm"));
            String srhDeptUseYn = MSFServerUtils.getFilterValue(columnFilters, "srhDeptUseYn") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDeptUseYn"));
            String srhDpobCd = sessionUser.getDpobCd();
            srhDto.setDeptNmHan(srhDeptNm);
            srhDto.setDeptUseYn(srhDeptUseYn);
            srhDto.setDpobCd(srhDpobCd);
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = bass0400DAO.selectBass0400ListTotCnt(srhDto);
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
            srhDto.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	srhDto.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	srhDto.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            List list = bass0400DAO.selectBass0400List(srhDto);
            Iterator<Map<String, Object>> iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
            
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = String.valueOf(map.get("dpobCd"))+String.valueOf(map.get("deptCd"));
                
                BaseModel bm = new BaseModel();
                
                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                    bm.set(tableAttributes[i].getName(), baseModelValue);
                }
                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                
                bmResult.add(bm);
            }
            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0400List, "selectBass0400List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }

	@SuppressWarnings("incomplete-switch")
	@Override
	public String saveBass0400(Bass0400DTO dto, ActionDatabase actionDatabase) throws MSFException {
		
		int returnCnt = 0;
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		String method = calledClass + ".saveBass0400";
		
		String windowNm = "부서관리";
		String windowId = "BASS0400";
		
		if("".equals(dto.getDpobCd()) || dto.getDpobCd() == null){
			dto.setDpobCd(sessionUser.getDpobCd());
		}
		dto.setIsmt(sessionUser.getUsrId());
		dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		try {
			switch(actionDatabase){
				case INSERT : returnCnt = bass0400DAO.saveBass0400(dto);
					break;
				case UPDATE : returnCnt = bass0400DAO.saveBass0400(dto);
					break;
				case DELETE : returnCnt = bass0400DAO.deleteBass0400(dto);
					break;
				}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(),e, windowNm , windowId);
			
		}
		return returnCnt+"";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BaseModel> getBass0150List() throws MSFException {
		List<BaseModel> returnValue = new ArrayList<BaseModel>();
		List egovResultDataList = new ArrayList();
		
		String method = calledClass + ".getBass0150List";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		String srhDpobCd = sessionUser.getDpobCd();
		
		String windowNm = "부서관리";
		String windowId = "BASS0400";
		
		try{
			Bass0400DTO dto = new Bass0400DTO();
			dto.setDpobCd(srhDpobCd);
			
			egovResultDataList = bass0400DAO.getBass0150List(dto);
			
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

	@Override
	public Long bass0400PiOrgCode() throws MSFException {
		// TODO Auto-generated method stub
		Long rtnComplite = -1L;
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	try {		
		
		 if(MSFSharedUtils.paramNull(infcOther0400DAO)){
	        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
	        	infcOther0400DAO = (InfcPkgOther0400DAO) wac.getBean("InfcPkgOther0400DAO");
	     } 
		 
		 InfcPkgBass0400SrhVO infcBass0400SrhVo = new InfcPkgBass0400SrhVO();
		 InfcPkgBass0400VO infcBass0400Vo = new InfcPkgBass0400VO();
		 
		 List list =  infcOther0400DAO.selectBass0400PiOrgCode(infcBass0400SrhVo);
		  
         Iterator<Map<String, Object>> iter = list.iterator();
          
         while ( iter.hasNext() ) {
             Map<String, Object> tempMap = (Map<String, Object>) iter.next();
           
             //삭제 처리 후 인서트 처리 ...
              
			infcBass0400Vo.setDpobCd(sessionUser.getDpobCd());    /** column 사업장코드 : dpobCd */
			infcBass0400Vo.setDeptCd(MSFSharedUtils.allowNulls(tempMap.get("deptCd")));    /** column 부서코드 : deptCd */
			infcBass0400Vo.setDeptNmHan(MSFSharedUtils.allowNulls(tempMap.get("deptNmHan")));    /** column 부서명_한글 : deptNmHan */
			infcBass0400Vo.setDeptNmRtchnt(MSFSharedUtils.allowNulls(tempMap.get("deptNmRtchnt")));    /** column 부서명_단축 : deptNmRtchnt */
			infcBass0400Vo.setDeptNmEng(MSFSharedUtils.allowNulls(tempMap.get("deptNmEng")));    /** column 부서명_영문 : deptNmEng */
			infcBass0400Vo.setTplvlDeptCd(MSFSharedUtils.allowNulls(tempMap.get("tplvlDeptCd")));    /** column 최상위부서코드 : tplvlDeptCd */
			infcBass0400Vo.setHhrkDeptCd(MSFSharedUtils.allowNulls(tempMap.get("hhrkDeptCd")));    /** column 상위부서코드 : hhrkDeptCd */
			infcBass0400Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(tempMap.get("payrMangDeptCd")));    /** column null : payrMangDeptCd */
			infcBass0400Vo.setDeptUseYn(MSFSharedUtils.allowNulls(tempMap.get("deptUseYn")));    /** column 부서사용여부 : deptUseYn */
			infcBass0400Vo.setNatPennSym(MSFSharedUtils.allowNulls(tempMap.get("natPennSym")));    /** column 국민연금기호 : natPennSym */
			infcBass0400Vo.setHlthInsrSym(MSFSharedUtils.allowNulls(tempMap.get("hlthInsrSym")));    /** column 건강보험기호 : hlthInsrSym */
			infcBass0400Vo.setUmytInsrSym(MSFSharedUtils.allowNulls(tempMap.get("umytInsrSym")));    /** column 고용보험기호 : umytInsrSym */
			infcBass0400Vo.setIdtlAccdtInsurSym(MSFSharedUtils.allowNulls(tempMap.get("idtlAccdtInsurSym")));    /** column 산재보험기호 : idtlAccdtInsurSym */
			infcBass0400Vo.setDeptNoteCtnt(MSFSharedUtils.allowNulls(tempMap.get("deptNoteCtnt")));    /** column 부서비고내용 : deptNoteCtnt */
			infcBass0400Vo.setDeptDspyYn(MSFSharedUtils.allowNulls(tempMap.get("deptDspyYn")));    /** column 부서출력여부 : deptDspyYn */
			infcBass0400Vo.setMangeDeptCd(MSFSharedUtils.allowNulls(tempMap.get("mangeDeptCd")));    /** column 관리부서코드 : mangeDeptCd */
			infcBass0400Vo.setDeptRank(MSFSharedUtils.allowNulls(tempMap.get("deptRank")));    /** column 부서순서 : deptRank */
			infcBass0400Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
			infcBass0400Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
			infcBass0400Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
			infcBass0400Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정자주소 : revnAddr */
			
			int iCnt = 0;
			iCnt = infcOther0400DAO.deleteBass0400(infcBass0400Vo);
			
			if (iCnt >= 0) {
				
				iCnt = infcOther0400DAO.insertBass0400(infcBass0400Vo);
				 
				rtnComplite = Long.parseLong(String.valueOf(iCnt));
				
			} else {
				rtnComplite = -1L;
			}
         
         }
		 
		
	}catch(Exception e){
		e.printStackTrace();
		rtnComplite = -1L;
		throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		
	}
		return rtnComplite;
	}

    
}
