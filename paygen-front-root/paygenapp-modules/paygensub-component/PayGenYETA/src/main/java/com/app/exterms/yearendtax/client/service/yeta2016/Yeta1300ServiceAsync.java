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
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;


public interface Yeta1300ServiceAsync {

	
	/**기본사항 tab 수정 **/ 
	public void saveYeta1300To2000tabItem01(Ye16Ta2000DTO Ye16Ta2000Dto, AsyncCallback<Integer> callback);
	
	/**소득공제 tab 수정 **/ 
	public void saveYeta1300To2000tabItem03(List<Ye16Ta3220DTO> listYeta3220_1dto, List<Ye16Ta3220DTO> listYeta3220_2dto, AsyncCallback<Integer> callback);
	
	/**연금보험료공제 tab의 국민연금보험료외의 연금보험료의 주근무지 금액을 저장한다. **/ 
	public void saveYeta1300To2000tabItem04(Ye16Ta2000DTO Yeta2000Dto, AsyncCallback<Integer> callback);
	
	/**특별소득공제tab 보험료 tab 저장 **/ 
	public void saveYeta1300To2000tabItem05_1(Ye16Ta2000DTO Yeta2000Dto, AsyncCallback<Integer> callback);
	
	/**특별소득공제tab 주택자금 tab 저장 **/ 
	public void saveYeta1300To2000tabItem05_2(Ye16Ta2000DTO Yeta2000Dto, AsyncCallback<Integer> callback);

	/**그밖의소득공제1tab 금액 수정 **/
	public void saveYeta1300To2000tabItem06(Ye16Ta2000DTO Yeta2000Dto, AsyncCallback<Integer> callback);
	
	/**그밖의소득공제2tab 금액 수정 **/
	public void saveYeta1300To2000tabItem07(Ye16Ta2000DTO Yeta2000Dto, AsyncCallback<Integer> callback);
	
	/**세액감면및세액공제1tab - 연금계좌및보험료 금액 수정 **/
	public void saveYeta1300To2000tabItem08_1(Ye16Ta2000DTO Yeta2000Dto, AsyncCallback<Integer> callback);
	
	/**세액감면및세액공제1tab - 교육비 금액 수정 **/
	public void saveYeta1300To2000tabItem08_3(Ye16Ta2000DTO Yeta2000Dto, AsyncCallback<Integer> callback);
	
	/**세액감면및세액공제1tab - 교육비(grid) 금액 수정 **/
	public void saveYeta1300To2000tabItem08_3(List<Ye16Ta3150DTO> listYeta3150dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
	/**세액감면및세액공제2tab 금액 수정 **/
	public void saveYeta1300To2000tabItem09(Ye16Ta2000DTO Yeta2000Dto, AsyncCallback<Integer> callback);
	
	/**추가제출서류tab 금액 수정 **/
	public void saveYeta1300To2000tabItem10(Ye16Ta2000DTO Yeta2000Dto, AsyncCallback<Integer> callback);
	
	/** 인적공제 명세 추가 **/
	public void activityOnYeta1300ToYeta3220(List<Ye16Ta3220DTO> listYeta3220dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
	//세액공
	public void fnYeta1300Payr06430CalcTax(List<Ye16Ta2000DTO> listYeta2000Dto, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback);
	
	//세액공제 전체 계산 
		public void fnYeta1300Payr06430AllCalcTax(Ye16Ta2000DTO yeta2000Dto, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback);
	
	
	/** 소득공제신고자료관리 새로고침 **/
	public void resultListYeta2000(Ye16Ta2000BM yeta2000Bm, AsyncCallback<Ye16Ta2000BM> callback);
	
	//	   /**
//     * REMT1000을 등록한다.
//     * @param vo - 등록할 정보가 담긴 Remt1000VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    String insertRemt1000(Remt1000VO vo) throws Exception;
//    
//    /**
//     * REMT1000을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Remt1000VO
//     * @return void형
//     * @exception Exception
//     */
//    void updateRemt1000(Remt1000VO vo) throws Exception;
//    
//    /**
//     * REMT1000을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Remt1000VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deleteRemt1000(Remt1000VO vo) throws Exception;
//    
//    /**
//     * REMT1000을 조회한다.
//     * @param vo - 조회할 정보가 담긴 Remt1000VO
//     * @return 조회한 REMT1000
//     * @exception Exception
//     */
//    Remt1000VO selectRemt1000(Remt1000VO vo) throws Exception;
//    
//    /**
//     * REMT1000 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT1000 목록
//     * @exception Exception
//     */
//    List selectRemt1000List(Remt1000SrhVO searchVO) throws Exception;
//    
//    /**
//     * REMT1000 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT1000 총 갯수
//     * @exception
//     */
//    int selectRemt1000ListTotCnt(Remt1000SrhVO searchVO);
}
