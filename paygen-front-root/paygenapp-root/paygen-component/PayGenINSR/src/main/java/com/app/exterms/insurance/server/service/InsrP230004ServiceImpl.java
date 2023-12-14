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
package com.app.exterms.insurance.server.service;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.insurance.client.service.InsrP230004Service;
import com.app.exterms.insurance.server.service.dao.Insr2200DAO;
import com.app.exterms.insurance.server.vo.Insr2200SrhVO;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;

import egovframework.rte.psl.dataaccess.util.EgovMap;
@Service("InsrP230004Service")
public class InsrP230004ServiceImpl extends AbstractCustomServiceImpl implements InsrP230004Service ,InsrDaoConstants{
	
	private static final Logger logger = LoggerFactory.getLogger(InsrP230004ServiceImpl.class);
	private static final String calledClass = InsrP230004ServiceImpl.class.getName();
			
	@Autowired
    @Resource(name="Insr2200DAO")
    private Insr2200DAO insr2200DAO;
	
	@Override
	public BaseModel activityOnReadInsr230004(BaseModel bm) throws MSFException {
		String method =  CLASS_INSRP230004TOBASS0150_DAO_LIST;
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		BaseModel resultMap = new BaseModel();
		Insr2200SrhVO   insr2200SrhVO = new Insr2200SrhVO();
		
		String windowNm = "사회보험자격상실신고";
		String windowId = "INSRP230004";

		insr2200SrhVO.setDpobCd(sessionUser.getDpobCd());
		insr2200SrhVO.setPayrMangDeptCd((String)bm.get("payrMangDeptCd"));
		
		String emymtDivCd = (String)bm.get("emymtDivCd");
		insr2200SrhVO.setEmymtDivCd(emymtDivCd);
		

		if  (MSFSharedUtils.paramNull(insr2200DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			insr2200DAO = (Insr2200DAO) wac.getBean("Insr2200DAO" ); 
		}

		try {
			
			EgovMap eMap = new EgovMap();
			
			if(emymtDivCd.equals("A0020010")){
				
				eMap = insr2200DAO.selectInsr230004ToBass0150(insr2200SrhVO);
				
			}else if(emymtDivCd.equals("A0020020")){ 
				
				insr2200SrhVO.setDeptCd((String) bm.get("deptCd"));
				String businCd = bm.get("businCd");
				insr2200SrhVO.setBusinCd(businCd);
				insr2200SrhVO.setBusinApptnYr(businCd.substring(0, 4));
				eMap = insr2200DAO.selectInsr230004ToBass0500(insr2200SrhVO);
				
			}
			
			resultMap.set("hlthInsrSym", eMap.get("hlthInsrSym"));
			resultMap.set("natPennSym", eMap.get("natPennSym"));
			resultMap.set("umytInsrSym", eMap.get("umytInsrSym"));
			resultMap.set("idtlAccdtInsurSym", eMap.get("idtlAccdtInsurSym"));
			resultMap.set("payMangeDeptPhnNum", eMap.get("payMangeDeptPhnNum"));
			resultMap.set("payMangeDeptFaxNum", eMap.get("payMangeDeptFaxNum"));
			resultMap.set("payMangeDeptZpcd", eMap.get("payMangeDeptZpcd"));
			resultMap.set("payMangeDeptFNdtnAddr", eMap.get("payMangeDeptFNdtnAddr"));
			resultMap.set("payMangeDeptDtlPatrAddr", eMap.get("payMangeDeptDtlPatrAddr"));
			resultMap.set("hlthInsrOfceSym", eMap.get("hlthInsrOfceSym"));
			resultMap.set("insurPrvaffAgcyIstutNum", eMap.get("insurPrvaffAgcyIstutNum"));
			resultMap.set("insurPrvaffAgcyIstutNm", eMap.get("insurPrvaffAgcyIstutNm"));
			resultMap.set("payMangeDeptNm", eMap.get("payMangeDeptNm"));
	
		} catch (Exception e) {
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");

		return resultMap;
	}
	

}
