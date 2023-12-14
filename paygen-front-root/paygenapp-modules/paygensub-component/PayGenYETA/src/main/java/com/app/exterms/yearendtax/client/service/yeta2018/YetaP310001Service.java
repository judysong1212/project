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
package com.app.exterms.yearendtax.client.service.yeta2018;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2018.Ye161010DTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.Ye161020DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("YetaP310001Service.gwt")
public interface YetaP310001Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static YetaP310001ServiceAsync instance;
		public static YetaP310001ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(YetaP310001Service.class);
			}
			return instance;
		}
	}
	
	/** 연말정산 대상자 생성  **/
    public PagingLoadResult<ShowMessageBM> saveYetaP310001ToYe161010(List<Ye161010DTO> listYe161010Dto, List<Ye161020DTO> listYe161020Dto, ActionDatabase actionDatabase) throws MSFException ;
//    
//    public int deleteYeta1900List(List<Pyyt0302DTO> listPyyt0302Dto) throws MSFException ;
//    
//    public Pyyt0304BM Yeta1900InfoList(Pyyt0304DTO Pyyt0304Dto) throws MSFException ;
//    
    
	
}
