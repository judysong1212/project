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
package com.app.exterms.payroll.client.service;

import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0250DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Payr4050Service.gwt")
public interface Payr4050Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Payr4050ServiceAsync instance;
		public static Payr4050ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Payr4050Service.class);
			}
			return instance;
		}
	}
	
	public Long activityOnPayr4050Save(List<Payr0250DTO> listPayr0250dto, ActionDatabase actionDatabase) throws MSFException;
//	/**
//	 * PAYR0250을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0250VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0250(Payr0250VO vo);
//    
//    /**
//	 * PAYR0250을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0250VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePayr0250(Payr0250VO vo);
    
    /**
	 * PAYR0250을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0250VO
	 * @return void형 
	 * @exception Exception
	 */
	public Long deletePayr0250(List<BaseModel> listModels,ActionDatabase actionDatabase) throws MSFException;
    
    /**
	 * PAYR0250을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0250VO
	 * @return 조회한 PAYR0250
	 * @exception Exception
	 */
//	public Payr0250VO selectPayr0250(Payr0250VO vo);
//    
//    /**
//	 * PAYR0250 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0250 목록
//	 * @exception Exception
//	 */
//	public List selectPayr0250List(Payr0250SrhVO searchVO);
//    
//    /**
//	 * PAYR0250 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0250 총 갯수
//	 * @exception
//	 */
//	public int selectPayr0250ListTotCnt(Payr0250SrhVO searchVO);
	
	public Long checkSysm0700Auth(Payr0250DTO payr0250dto, ActionDatabase actionDatabase) throws MSFException;
}
