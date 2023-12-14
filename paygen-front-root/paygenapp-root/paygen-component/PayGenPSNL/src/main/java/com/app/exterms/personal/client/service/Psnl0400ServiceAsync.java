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
package com.app.exterms.personal.client.service;

import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0400DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Psnl0400ServiceAsync {
	
	public void selectExperienceMain(Psnl0400DTO psnl0400DTO, AsyncCallback<List<Psnl0400DTO>> callback);
	
	public void selectExperience(BaseListLoadConfig config, Psnl0400DTO psnl0400DTO, AsyncCallback<BaseListLoadResult<Psnl0400DTO>> callback);
	
	public void insertIssueData(Psnl0400DTO psnl0400DTO, AsyncCallback<String> callback);

	public void insertIssueData(List<Psnl0400DTO> dtosList, AsyncCallback<String> callback);
	
	public void getIssueNumber(Psnl0400DTO psnl0400DTO, AsyncCallback<String> callback);
	

}
