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
package com.app.exterms.yearendtax.client.service.yeta2022;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161010DTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161020DTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161030DTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161040DTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161055DTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161060DTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161070DTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161080DTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161090DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;



public interface Yeta7300ServiceAsync {

	
	/** 기본사항 tab 수정 **/ 
	public void saveYeta7300ToYe161020tabItem01(Ye161020DTO ye161020Dto, AsyncCallback<Integer> callback);
	
	/** 기본사항 tab 조회 **/
	public void getYeta7300ToYe161020Data(Ye161020DTO ye161020Dto, AsyncCallback<Ye161020DTO> callback);
	
	/** 인적공제 tab 조회 **/ 
	public void getYeta7300TabItem02ToYe161020Data(Ye161020DTO ye161020Dto, AsyncCallback<Ye161020DTO> callback);
	
	/** 인적공제 tab 수정 **/
	public void activityOnYeta7300ToYe161030(List<Ye161030DTO> listYe161030Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
	/** 소득공제 tab 수정 **/ 
	public void saveYeta7300ToYe1610400tabItem03(List<Ye161040DTO> listYe161040Dto_01, List<Ye161040DTO> listYe161040Dto_02, AsyncCallback<Integer> callback);
	
	/** 연금보험료공제 tab 수정 **/ 
	public void saveYeta7300ToYe161055tabItem04(Ye161055DTO ye161055Dto, AsyncCallback<Integer> callback);
	
	/** 연금보험료공제 tab 조회 **/ 
	public void getYeta7300TabItem04ToYe161055Data(Ye161055DTO ye161055Dto, AsyncCallback<Ye161055DTO> callback);
	
	
	/** 특별소득공제tab 보험료 tab 수정 **/ 
	public void saveYeta7300ToYe161060tabItem05_1(Ye161060DTO ye161060Dto, AsyncCallback<Integer> callback);
	
	/** 특별소득공제tab 주택자금 tab 수정 **/ 
	public void saveYeta7300ToYe161060tabItem05_2(Ye161060DTO ye161060Dto, AsyncCallback<Integer> callback);
	
	/** 특별소득공제 tab 조회 **/ 
	public void getYeta7300TabItem05ToYe161060Data(Ye161060DTO ye161060Dto, AsyncCallback<Ye161060DTO> callback);	
	
	

	/**그밖의소득공제1tab 금액 수정 **/
	public void saveYeta7300ToYe161070tabItem06(Ye161070DTO ye161070Dto, AsyncCallback<Integer> callback);
	
	/**그밖의소득공제2tab 금액 수정 **/
	public void saveYeta7300ToYe161070tabItem07(Ye161070DTO ye161070Dto, AsyncCallback<Integer> callback);
	
	
	/** 그밖의소득공제1tab 조회 **/
	public void getYeta7300TabItem06ToYe161070Data(Ye161070DTO ye161070Dto, AsyncCallback<Ye161070DTO> callback);	
	
	
	

	/**세액감면및세액공제1tab - 연금계좌및보험료 금액 수정 **/
	public void saveYeta7300ToYe161080tabItem08_1(Ye161080DTO ye161080Dto, AsyncCallback<Integer> callback);
//	
	/**세액감면및세액공제1tab - 교육비 금액 수정 **/
	public void saveYeta7300ToYe161080tabItem08_3(Ye161080DTO ye161080Dto, AsyncCallback<Integer> callback);
//	
	/**세액감면및세액공제1tab - 교육비(grid) 금액 수정 **/
	public void saveYeta7300ToYe161090tabItem08_3(List<Ye161090DTO> listYe161090Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
	/** 세액감면및세액공제1tab 조회 **/
	public void getYeta7300TabItem08ToYe161080Data(Ye161080DTO ye161080Dto, AsyncCallback<Ye161080DTO> callback);	
	
	/** 세액감면및세액공제2tab 금액 수정 **/
	public void saveYeta7300ToYe161080tabItem09(Ye161080DTO ye161080Dto, AsyncCallback<Integer> callback);
	
	/** 세액감면및세액공제2tab 조회 **/
	public void getYeta7300TabItem09ToYe161080Data(Ye161080DTO ye161080Dto, AsyncCallback<Ye161080DTO> callback);	
	
	
	/** 추가제출서류tab 금액 수정 **/
	public void saveYeta7300ToYe161080tabItem10(Ye161080DTO ye161080Dto, AsyncCallback<Integer> callback);
	
	/** 추가제출서류tab 조회 **/
	public void getYeta7300TabItem10ToYe161080Data(Ye161080DTO ye161080Dto, AsyncCallback<Ye161080DTO> callback);	
	

	
	//세액공
	public void fnYeta7300_Ye161010_2022_CalcTax(List<Ye161010DTO> listYe161010Dto, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback);
	
	//세액공제 전체 계산 
	public void fnYeta7300Ye161010_2022_AllCalcTax(Ye161010DTO ye161010Dto, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback);
		
	//소득공제 신고서 재적용
	public void fnYeta7300Ye161010_2022_SbtVolUse(Ye161010DTO ye161010Dto,  AsyncCallback<PagingLoadResult<ShowMessageBM>> callback);
	
	public void getYeta7300TxDdcYnToYe161020Data(Ye161020DTO ye161020Dto, AsyncCallback<Ye161020DTO> callback);
//	/** 소득공제신고자료관리 새로고침 **/
//	public void resultListYeta2000(Yeta2000BM yeta2000Bm, AsyncCallback<Yeta2000BM> callback);
	
	/** 합계 일괄업데이트 **/
	public void updateYeta7300All(List<Ye161040DTO> listYe161040Dto, AsyncCallback<Integer> callback);
	
}
