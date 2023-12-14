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

import com.app.exterms.payroll.client.dto.Payr0420DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Payr5100Service.gwt")
public interface Payr5100Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Payr5100ServiceAsync instance;
		public static Payr5100ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Payr5100Service.class);
			}
			return instance;
		}
	}
	

	public Long activityOnPayr5100Insert(Payr0420DTO   payr0420Dto,List<BaseModel> listModels, ActionDatabase actionDatabase);
	
//	/**
//	 * PAYR0420을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0420VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0420(Payr0420VO vo);
//    
//    /**
//	 * PAYR0420을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0420VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public  void updatePayr0420(Payr0420VO vo);
//    
//    /**
//	 * PAYR0420을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0420VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deletePayr0420(Payr0420VO vo);
//    
//    /**
//	 * PAYR0420을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0420VO
//	 * @return 조회한 PAYR0420
//	 * @exception Exception
//	 */
//	public Payr0420VO selectPayr0420(Payr0420VO vo);
//    
//    /**
//	 * PAYR0420 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0420 목록
//	 * @exception Exception
//	 */
//	public List selectPayr0420List(Payr0420SrhVO searchVO);
//    
//    /**
//	 * PAYR0420 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0420 총 갯수
//	 * @exception
//	 */
//	public int selectPayr0420ListTotCnt(Payr0420SrhVO searchVO);	
//	
//
//	/**
//	 * PAYR0440을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0440VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0440(Payr0440VO vo);
//    
//    /**
//	 * PAYR0440을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0440VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePayr0440(Payr0440VO vo);
//    
//    /**
//	 * PAYR0440을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0440VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deletePayr0440(Payr0440VO vo);
//    
//    /**
//	 * PAYR0440을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0440VO
//	 * @return 조회한 PAYR0440
//	 * @exception Exception
//	 */
//	public Payr0440VO selectPayr0440(Payr0440VO vo);
//    
//    /**
//	 * PAYR0440 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0440 목록
//	 * @exception Exception
//	 */
//	public List selectPayr0440List(Payr0440SrhVO searchVO);
//    
//    /**
//	 * PAYR0440 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0440 총 갯수
//	 * @exception
//	 */
//	public int selectPayr0440ListTotCnt(Payr0440SrhVO searchVO);
}
