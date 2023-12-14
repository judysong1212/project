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
package com.app.exterms.diligence.client.service;

import java.util.HashMap;
import java.util.List;

import com.app.exterms.diligence.client.dto.Dlgn0250DTO;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Dlgn0250ServiceAsync {
	
	
//    public BaseListLoadResult<Dlgn0250DTO> searchWorkDayMemberInfo(BaseListLoadConfig config, Dlgn0250DTO dto) throws Exception ;
//    
//    public BaseListLoadResult<Dlgn0250DTO> getMemberWorkTimeInfo(BaseListLoadConfig config, Dlgn0250DTO dto) throws Exception ;
//    
//    public int generateWorkTime(Dlgn0250DTO dto) throws Exception;
//    
//    public int saveWorkTime(List<Dlgn0250DTO> list) throws Exception;
//    
//    public int deleteWorkTime(List<Dlgn0250DTO> list) throws Exception;
//    
//    public List<BaseModel> getPayrMangDeptCd(Dlgn0250DTO dto) throws Exception;
    
	public void xlsExportData(ServiceParameters params, AsyncCallback<String> callback); 
	

    public void activityOnDlgn0250(List<Dlgn0250DTO> listDlgn0250dto, ActionDatabase actionDatabase, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback) ;
     
    //신규생성
    public void createDlgn0250WorkPerfm( HashMap<String, String> param, ActionDatabase actionDatabase, AsyncCallback<Long> callback) ;
      
}
