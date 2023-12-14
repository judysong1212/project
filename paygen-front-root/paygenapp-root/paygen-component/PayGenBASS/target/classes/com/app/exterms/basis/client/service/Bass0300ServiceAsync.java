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
package com.app.exterms.basis.client.service;

import java.util.List;

import com.app.exterms.basis.client.dto.Bass0300DTOMng;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Bass0300ServiceAsync {
	
	
	/*############################## 코드관리 서비스 시작 ######################################*/
	
	public void selectBass0300WorkList(BaseListLoadConfig config, Bass0300DTOMng dto, AsyncCallback<BaseListLoadResult<Bass0300DTOMng>> callback );
	public void selectBass0300CodeList(BaseListLoadConfig config, Bass0300DTOMng dto, AsyncCallback<BaseListLoadResult<Bass0300DTOMng>> callback );
	public void selectBass0300DtlCodeList(BaseListLoadConfig config, Bass0300DTOMng dto, AsyncCallback<BaseListLoadResult<Bass0300DTOMng>> callback );
	
	public void saveBass0300(List<Bass0300DTOMng> changeList, AsyncCallback<String> callback);
	public void deleteBass0300(List<Bass0300DTOMng> delList, AsyncCallback<Integer> callback);
	
	public void getWorkList(Bass0300DTOMng dtoParam, AsyncCallback<List<BaseModel>> callback);
	
	/*############################## 코드관리 서비스 끝 ######################################*/
	
//	/**
//	 * BASS0300을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Bass0300VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    String insertBass0300(Bass0300DTO vo);
//    
//    /**
//	 * BASS0300을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Bass0300VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    void updateBass0300(Bass0300DTO vo);
//    
//    /**
//	 * BASS0300을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Bass0300VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    void deleteBass0300(Bass0300DTO vo);
//    
//    /**
//	 * BASS0300을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Bass0300VO
//	 * @return 조회한 BASS0300
//	 * @exception Exception
//	 */
//    Bass0300BM selectBass0300(Bass0300DTO vo);
//    
//    /**
//	 * BASS0300 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return BASS0300 목록
//	 * @exception Exception
//	 */
//    List<Bass0300BM> selectBass0300List(Bass0300DTO searchVO);
//    
//    /**
//	 * BASS0300 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return BASS0300 총 갯수
//	 * @exception
//	 */
//    int selectBass0300ListTotCnt(Bass0300DTO searchVO);
}
