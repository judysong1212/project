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

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0350DTO;
import com.app.exterms.payroll.client.dto.Payr0360DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0100DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Payr4210ServiceAsync {
	
   public void  setPayr4210ToPayCalculation(Payr0360DTO payr0360Dto, ActionDatabase actionDatabase, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback);
	    
   public void  setPayr4210ToPayCalcSeft(Payr0360DTO dtoPayr0360, ArrayList<PrgmComPsnl0100DTO> dtoListPsnl0100, ActionDatabase actionDatabase, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback);
   
   public void activityOnDeletePayr4210( Payr0360DTO payr0360Dto, AsyncCallback<Long> callback);
   
   public void activityOnReadDtlPayr4210ToPayr0360( Payr0360DTO payr0360Dto, AsyncCallback<Payr0360DTO> callback);
   
   public void  setPayr4210TPayr0360Update(Payr0360DTO payr0360Dto, ActionDatabase actionDatabase,   AsyncCallback<Long> callback);
     
   public void setPayr4210ToPayr0350Delete( List<Payr0350DTO> listPayr0350dto, AsyncCallback<Long> callback);
  
//
//	/**
//	 * PAYR0350을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0350VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0350(Payr0350VO vo);
//    
//    /**
//	 * PAYR0350을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0350VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePayr0350(Payr0350VO vo);
//    
//    /**
//	 * PAYR0350을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0350VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deletePayr0350(Payr0350VO vo);
//    
//    /**
//	 * PAYR0350을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0350VO
//	 * @return 조회한 PAYR0350
//	 * @exception Exception
//	 */
//	public Payr0350VO selectPayr0350(Payr0350VO vo);
//    
//    /**
//	 * PAYR0350 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0350 목록
//	 * @exception Exception
//	 */
//	public List selectPayr0350List(Payr0350SrhVO searchVO);
//    
//    /**
//	 * PAYR0350 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0350 총 갯수
//	 * @exception
//	 */
//	public int selectPayr0350ListTotCnt(Payr0350SrhVO searchVO);
//	
//	
//
//	/**
//	 * PAYR0303을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0303VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0303(Payr0303VO vo);
//    
//    /**
//	 * PAYR0303을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0303VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePayr0303(Payr0303VO vo);
//    
//    /**
//	 * PAYR0303을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0303VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deletePayr0303(Payr0303VO vo);
//    
//    /**
//	 * PAYR0303을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0303VO
//	 * @return 조회한 PAYR0303
//	 * @exception Exception
//	 */
//	public Payr0303VO selectPayr0303(Payr0303VO vo);
//    
//    /**
//	 * PAYR0303 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0303 목록
//	 * @exception Exception
//	 */
//	public List selectPayr0303List(Payr0303SrhVO searchVO);
//    
//    /**
//	 * PAYR0303 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0303 총 갯수
//	 * @exception
//	 */
//	public int selectPayr0303ListTotCnt(Payr0303SrhVO searchVO);	
}
