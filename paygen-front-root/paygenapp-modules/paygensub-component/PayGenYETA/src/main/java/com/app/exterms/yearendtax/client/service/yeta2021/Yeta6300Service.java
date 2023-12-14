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
package com.app.exterms.yearendtax.client.service.yeta2021;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2021.Ye161010DTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.Ye161020DTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.Ye161030DTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.Ye161040DTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.Ye161055DTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.Ye161060DTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.Ye161070DTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.Ye161080DTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.Ye161090DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;



/**
 * @Class Name : Yeta2300Service.java
 * @since : 2017. 12. 17. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Yeta6300Service.gwt")
public interface Yeta6300Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Yeta6300ServiceAsync instance;
		public static Yeta6300ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Yeta6300Service.class);
			}
			return instance;
		}
	}
	
	/** 기본사항 tab 수정 **/ 
	public int saveYeta6300ToYe161020tabItem01(Ye161020DTO ye161020Dto) throws Exception;
	
	/** 기본사항 tab 조회 **/
	public Ye161020DTO getYeta6300ToYe161020Data(Ye161020DTO ye161020Dto) throws MSFException;

	
	/** 인적공제 tab 수정 **/
	public Long activityOnYeta6300ToYe161030(List<Ye161030DTO> listYe161030Dto, ActionDatabase actionDatabase);
	
	/** 인적공제 tab 조회 **/
	public Ye161020DTO getYeta6300TabItem02ToYe161020Data(Ye161020DTO ye161020Dto) throws MSFException;
	
	
	/** 소득공제 tab 수정 **/
	public int saveYeta6300ToYe1610400tabItem03(List<Ye161040DTO> listYe161040Dto_01, List<Ye161040DTO> listYe161040Dto_02);
	
	
	/**연금보험료공제 tab 수정 **/ 
	public int saveYeta6300ToYe161055tabItem04(Ye161055DTO ye161055Dto) throws Exception;
	
	/** 연금보험료공제 tab 조회 **/
	public Ye161055DTO getYeta6300TabItem04ToYe161055Data(Ye161055DTO ye161055Dto) throws MSFException;	
	
	
	/** 특별소득공제tab 보험료 tab 수정 **/ 
	public int saveYeta6300ToYe161060tabItem05_1(Ye161060DTO ye161060Dto) throws Exception;
	
	/** 특별소득공제tab 주택자금 tab 수정 **/ 
	public int saveYeta6300ToYe161060tabItem05_2(Ye161060DTO ye161060Dto) throws Exception;
	
	/** 특별소득공제 tab 조회 **/
	public Ye161060DTO getYeta6300TabItem05ToYe161060Data(Ye161060DTO ye161060Dto) throws MSFException;		
	

	/** 그밖의소득공제1tab 금액 수정 **/
	public int saveYeta6300ToYe161070tabItem06(Ye161070DTO ye161070Dto) throws Exception;
	
	/**그밖의소득공제2tab 금액 수정 **/
	public int saveYeta6300ToYe161070tabItem07(Ye161070DTO ye161070Dto) throws Exception;

	/** 그밖의소득공제1tab 조회 **/
	public Ye161070DTO getYeta6300TabItem06ToYe161070Data(Ye161070DTO ye161070Dto) throws MSFException;		
	

	
	
	/**세액감면및세액공제1tab - 연금계좌및보험료 금액 수정 **/
	public int saveYeta6300ToYe161080tabItem08_1(Ye161080DTO ye161080Dto) throws Exception;
	
	/**세액감면및세액공제1tab - 교육비(grid) 금액 수정 **/
	public Long saveYeta6300ToYe161090tabItem08_3(List<Ye161090DTO> listYe161090Dto, ActionDatabase actionDatabase) throws Exception;
	
	/**세액감면및세액공제1tab - 교육비 금액 수정 **/
	public int saveYeta6300ToYe161080tabItem08_3(Ye161080DTO ye161080Dto) throws Exception;
	
	/** 세액감면및세액공제1tab 조회 **/
	public Ye161080DTO getYeta6300TabItem08ToYe161080Data(Ye161080DTO ye161080Dto) throws MSFException;			
	
	/** 세액감면및세액공제2tab 수정 **/
	public int saveYeta6300ToYe161080tabItem09(Ye161080DTO ye161080Dto) throws Exception;
	
	/** 세액감면및세액공제2tab 조회 **/
	public Ye161080DTO getYeta6300TabItem09ToYe161080Data(Ye161080DTO ye161080Dto) throws MSFException;		
	
	/** 추가제출서류tab 수정 **/
	public int saveYeta6300ToYe161080tabItem10(Ye161080DTO ye161080Dto) throws Exception;
	
	/** 추가제출서류 tab 조회 **/
	public Ye161080DTO getYeta6300TabItem10ToYe161080Data(Ye161080DTO ye161080Dto) throws MSFException;		

	
//	/** 소득공제신고자료관리 새로고침 **/
//	public Yeta2000BM resultListYeta2000 (Yeta2000BM yeta2000Bm);
	
	//세액공제 
	public PagingLoadResult<ShowMessageBM> fnYeta6300_Ye161010_2021_CalcTax(List<Ye161010DTO> listYe161010Dto) throws MSFException;
	
	//세액계산 전체하기 
	public PagingLoadResult<ShowMessageBM> fnYeta6300Ye161010_2021_AllCalcTax(Ye161010DTO ye161010Dto) throws MSFException;
	
	//소득공제 신고서 재적용
	public PagingLoadResult<ShowMessageBM> fnYeta6300Ye161010_2021_SbtVolUse(Ye161010DTO ye161010Dto) throws MSFException;
	
	public Ye161020DTO getYeta6300TxDdcYnToYe161020Data(Ye161020DTO ye161020Dto) throws MSFException;
	
	
	/** 합계 일괄업데이트 **/
	public int updateYeta6300All(List<Ye161040DTO> listYe161040Dto) throws MSFException;
	
	
	
}
