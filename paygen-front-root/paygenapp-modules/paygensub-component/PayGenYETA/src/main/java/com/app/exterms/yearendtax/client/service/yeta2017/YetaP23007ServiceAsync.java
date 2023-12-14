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
package com.app.exterms.yearendtax.client.service.yeta2017;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2017.Ye162010DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;


public interface YetaP23007ServiceAsync {
	
	/** 연금저축소득공제 등록 팝업 수정 및 삭제 **/
	public void activityOnYetaP23007ToYe162010(List<Ye162010DTO> listYe162010Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback) ;

}