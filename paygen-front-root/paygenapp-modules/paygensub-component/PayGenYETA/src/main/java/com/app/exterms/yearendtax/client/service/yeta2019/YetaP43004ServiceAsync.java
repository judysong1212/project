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
package com.app.exterms.yearendtax.client.service.yeta2019;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2019.Ye162520DTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.Ye162530DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;




/**
 * @Class Name : YetaP23004ServiceAsync.java
 * @since : 2017. 12. 21. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public interface YetaP43004ServiceAsync {
	
	/** 거주자간 주택임차차입금 원리금 상환액 - 금전소비대차계약  팝업 수정 삭제**/
	public void activityOnYetaP43004ToYe162520(List<Ye162520DTO> listYe162520Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback) ;
	
	/** 거주자간 주택임차차입금 원리금 상환액 - 임대차계약  팝업 수정 삭제**/
	public void activityOnYetaP43004ToYe162530(List<Ye162530DTO> listYe162530Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback) ;
	
}
