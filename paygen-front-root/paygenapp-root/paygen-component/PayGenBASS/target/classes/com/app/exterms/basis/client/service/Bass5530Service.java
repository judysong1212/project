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

import com.app.exterms.basis.client.dto.Bass5530DTO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Bass5530Service.gwt")
public interface Bass5530Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Bass5530ServiceAsync instance;
		public static Bass5530ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Bass5530Service.class);
			}
			return instance;
		}
	}
	
	
   public Long activityOnBass5530Save(List<Bass5530DTO>  bass5530dto);
    
   public Long activityOnBass5530Delete(List<BaseModel> listModels);
     
     
	
//	/**
//	 * PAYR0480을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0480VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0480(Payr0480VO vo);
//    
//    /**
//	 * PAYR0480을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0480VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePayr0480(Payr0480VO vo);
//    
//    /**
//	 * PAYR0480을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0480VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deletePayr0480(Payr0480VO vo);
//    
//    /**
//	 * PAYR0480을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0480VO
//	 * @return 조회한 PAYR0480
//	 * @exception Exception
//	 */
//	public Payr0480VO selectPayr0480(Payr0480VO vo);
//    
//    /**
//	 * PAYR0480 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0480 목록
//	 * @exception Exception
//	 */
//	public List selectPayr0480List(Payr0480SrhVO searchVO);
//    
//    /**
//	 * PAYR0480 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0480 총 갯수
//	 * @exception
//	 */
//	public int selectPayr0480ListTotCnt(Payr0480SrhVO searchVO);
}
