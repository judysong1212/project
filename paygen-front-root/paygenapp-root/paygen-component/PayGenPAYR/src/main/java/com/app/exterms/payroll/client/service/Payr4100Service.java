/*******************************************************************************
     * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by app licable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.app.exterms.payroll.client.service;

import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0500DTO;
import com.app.exterms.payroll.client.dto.Payr0520DTO;
import com.app.exterms.payroll.client.dto.Payr0530DTO;
import com.app.exterms.payroll.client.dto.Payr0540DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Payr4100Service.gwt")
public interface Payr4100Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Payr4100ServiceAsync instance;
		public static Payr4100ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Payr4100Service.class);
			}
			return instance;
		}
	}

	public Long activityOnPayr0530(List<Payr0530DTO> listPayr0530dto, ActionDatabase actionDatabase);
	
	public Long activityOnPayr0520(Payr0520DTO payr0520Dto, ActionDatabase actionDatabase);
	
	public Long activityOnPayr0540( List<Payr0540DTO> listPayr0540dto , ActionDatabase actionDatabase);
	 
	public Long activityOnUpdatePayr4100Save(Payr0500DTO payr0500Dto);

//	/**
//	 * PAYR0500을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0500VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0500(Payr0500VO vo);
//    
// /**
//	 * PAYR0500을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0500VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePayr0500(Payr0500VO vo);
//    
//    /**
//	 * PAYR0500을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0500VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deletePayr0500(Payr0500VO vo);
//    
//    /**
//	 * PAYR0500을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0500VO
//	 * @return 조회한 PAYR0500
//	 * @exception Exception
//	 */
//	public Payr0500VO selectPayr0500(Payr0500VO vo);
//    
//    /**
//	 * PAYR0500 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0500 목록
//	 * @exception Exception
//	 */
//	public List selectPayr0500List(Payr0500SrhVO searchVO);
//    
//    /**
//	 * PAYR0500 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0500 총 갯수
//	 * @exception
//	 */
//	public int selectPayr0500ListTotCnt(Payr0500SrhVO searchVO);
//	
//	
//	/**
//	 * PAYR0520을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0520VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0520(Payr0520VO vo);
//    
//    /**
//	 * PAYR0520을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0520VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePayr0520(Payr0520VO vo);
//    
//    /**
//	 * PAYR0520을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0520VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deletePayr0520(Payr0520VO vo);
//    
//    /**
//	 * PAYR0520을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0520VO
//	 * @return 조회한 PAYR0520
//	 * @exception Exception
//	 */
//	public Payr0520VO selectPayr0520(Payr0520VO vo);
//    
//    /**
//	 * PAYR0520 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0520 목록
//	 * @exception Exception
//	 */
//	public List selectPayr0520List(Payr0520SrhVO searchVO);
//    
//    /**
//	 * PAYR0520 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0520 총 갯수
//	 * @exception
//	 */
//	public int selectPayr0520ListTotCnt(Payr0520SrhVO searchVO);
//	
//	/**
//	 * PAYR0530을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0530VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0530(Payr0530VO vo);
//    
//    /**
//	 * PAYR0530을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0530VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePayr0530(Payr0530VO vo);
//    
//    /**
//	 * PAYR0530을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0530VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deletePayr0530(Payr0530VO vo);
//    
//    /**
//	 * PAYR0530을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0530VO
//	 * @return 조회한 PAYR0530
//	 * @exception Exception
//	 */
//	public Payr0530VO selectPayr0530(Payr0530VO vo);
//    
//    /**
//	 * PAYR0530 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0530 목록
//	 * @exception Exception
//	 */
//	public List selectPayr0530List(Payr0530SrhVO searchVO);
//    
//    /**
//	 * PAYR0530 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0530 총 갯수
//	 * @exception
//	 */
//	public int selectPayr0530ListTotCnt(Payr0530SrhVO searchVO);
//	
//	/**
//	 * PAYR0540을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0540VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0540(Payr0540VO vo);
//    
//    /**
//	 * PAYR0540을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0540VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePayr0540(Payr0540VO vo);
//    
//    /**
//	 * PAYR0540을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0540VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deletePayr0540(Payr0540VO vo);
//    

	
}
