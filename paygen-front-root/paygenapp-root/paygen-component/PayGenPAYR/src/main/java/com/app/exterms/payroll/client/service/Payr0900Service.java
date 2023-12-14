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

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
/**
 * @Class Name : Payr0900Service.java
 * @Description : Payr0900 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Payr0900Service.gwt")
public interface Payr0900Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Payr0900ServiceAsync instance;
		public static Payr0900ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Payr0900Service.class);
			}
			return instance;
		}
	}
	
//	/**
//	 * PAYR0900을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0900VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0900(Payr0900VO vo);
//    
//    /**
//	 * PAYR0900을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0900VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePayr0900(Payr0900VO vo);
//    
//    /**
//	 * PAYR0900을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0900VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deletePayr0900(Payr0900VO vo);
//    
//    /**
//	 * PAYR0900을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0900VO
//	 * @return 조회한 PAYR0900
//	 * @exception Exception
//	 */
//	public Payr0900VO selectPayr0900(Payr0900VO vo);
//    
//    /**
//	 * PAYR0900 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0900 목록
//	 * @exception Exception
//	 */
//	public List selectPayr0900List(Payr0900SrhVO searchVO);
//    
//    /**
//	 * PAYR0900 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0900 총 갯수
//	 * @exception
//	 */
//	public int selectPayr0900ListTotCnt(Payr0900SrhVO searchVO);
}
