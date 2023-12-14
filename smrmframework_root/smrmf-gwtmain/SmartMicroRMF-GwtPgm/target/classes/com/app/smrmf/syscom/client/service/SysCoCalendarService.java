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
package com.app.smrmf.syscom.client.service;

import java.util.List;

import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("SysCoCalendarService.gwt")
public interface SysCoCalendarService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static SysCoCalendarServiceAsync instance;
		public static SysCoCalendarServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(SysCoCalendarService.class);
			}
			return instance;
		}
	}
	public List<BaseModel> getSysComComboYearList(SysCoCalendarDTO msfCoCalendarDto);
	
	public List<BaseModel> getSysComComboMonthList(SysCoCalendarDTO msfCoCalendarDto);
	
	

//	/**
//	 * CO_CALENDAR을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 CoCalendarVO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertCoCalendar(MSFCoCalendarVO vo) ;
//    
//    /**
//	 * CO_CALENDAR을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 CoCalendarVO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updateCoCalendar(MSFCoCalendarVO vo) ;
//    
//    /**
//	 * CO_CALENDAR을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 CoCalendarVO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deleteCoCalendar(MSFCoCalendarVO vo) ;
//    
//    /**
//	 * CO_CALENDAR을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 CoCalendarVO
//	 * @return 조회한 CO_CALENDAR
//	 * @exception Exception
//	 */
//	public MSFCoCalendarVO selectCoCalendar(MSFCoCalendarVO vo) ;
//    
//    /**
//	 * CO_CALENDAR 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return CO_CALENDAR 목록
//	 * @exception Exception
//	 */
//	public List selectCoCalendarList(MSFCoCalendarSrhVO searchVO) ;
//    
//    /**
//	 * CO_CALENDAR 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return CO_CALENDAR 총 갯수
//	 * @exception
//	 */
//	public int selectCoCalendarListTotCnt(MSFCoCalendarSrhVO searchVO);
}