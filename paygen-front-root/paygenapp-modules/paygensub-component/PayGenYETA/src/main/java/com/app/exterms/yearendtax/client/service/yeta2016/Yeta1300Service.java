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
package com.app.exterms.yearendtax.client.service.yeta2016;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta2000BM;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta2000DTO;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3150DTO;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3220DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Yeta1300Service.gwt")
public interface Yeta1300Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Yeta1300ServiceAsync instance;
		public static Yeta1300ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Yeta1300Service.class);
			}
			return instance;
		}
	}
	
	/**기본사항 tab 수정 **/ 
	public int saveYeta1300To2000tabItem01(Ye16Ta2000DTO Yeta2000Dto) throws Exception;
	
	/** 소득공제 tab 수정 **/
	public int saveYeta1300To2000tabItem03(List<Ye16Ta3220DTO> listYeta3220_1dto, List<Ye16Ta3220DTO> listYeta3220_2dto);
	
	/**연금보험료공제 tab 국민연금보험료외의 연금보험료의 주근무지 금액 수정 **/ 
	public int saveYeta1300To2000tabItem04(Ye16Ta2000DTO Yeta2000Dto) throws Exception;
	
	/**특별소득공제tab 보험료 tab 수정 **/ 
	public int saveYeta1300To2000tabItem05_1(Ye16Ta2000DTO Yeta2000Dto) throws Exception;
	
	/**특별소득공제tab 주택자금 tab 수정 **/ 
	public int saveYeta1300To2000tabItem05_2(Ye16Ta2000DTO Yeta2000Dto) throws Exception;

	/**그밖의소득공제1tab 금액 수정 **/
	public int saveYeta1300To2000tabItem06(Ye16Ta2000DTO Yeta2000Dto) throws Exception;
	
	/**그밖의소득공제2tab 금액 수정 **/
	public int saveYeta1300To2000tabItem07(Ye16Ta2000DTO Yeta2000Dto) throws Exception;
	
	/**세액감면및세액공제1tab - 연금계좌및보험료 금액 수정 **/
	public int saveYeta1300To2000tabItem08_1(Ye16Ta2000DTO Yeta2000Dto) throws Exception;
	
	/**세액감면및세액공제1tab - 교육비 금액 수정 **/
	public int saveYeta1300To2000tabItem08_3(Ye16Ta2000DTO Yeta2000Dto) throws Exception;
	
	/**세액감면및세액공제1tab - 교육비(grid) 금액 수정 **/
	public Long saveYeta1300To2000tabItem08_3(List<Ye16Ta3150DTO> listYeta3150dto, ActionDatabase actionDatabase) throws Exception;
	
	/**세액감면및세액공제2tab 수정 **/
	public int saveYeta1300To2000tabItem09(Ye16Ta2000DTO Yeta2000Dto) throws Exception;
	
	/**추가제출서류tab 수정 **/
	public int saveYeta1300To2000tabItem10(Ye16Ta2000DTO Yeta2000Dto) throws Exception;
	
	/** 인적공제 명세 추가 **/
	public Long activityOnYeta1300ToYeta3220(List<Ye16Ta3220DTO> listYeta3220dto, ActionDatabase actionDatabase);
	
	/** 소득공제신고자료관리 새로고침 **/
	public Ye16Ta2000BM resultListYeta2000 (Ye16Ta2000BM yeta2000Bm);
	
	//세액공제 
	public PagingLoadResult<ShowMessageBM> fnYeta1300Payr06430CalcTax(List<Ye16Ta2000DTO> listYeta2000Dto) throws MSFException;
	
	//세액계산 전체하기 
	public PagingLoadResult<ShowMessageBM> fnYeta1300Payr06430AllCalcTax(Ye16Ta2000DTO yeta2000Dto) throws MSFException;
	
	
}
