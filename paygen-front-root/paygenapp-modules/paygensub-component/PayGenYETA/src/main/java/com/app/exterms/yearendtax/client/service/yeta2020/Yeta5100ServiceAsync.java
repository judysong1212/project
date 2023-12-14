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
package com.app.exterms.yearendtax.client.service.yeta2020;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2020.Ye161010DTO;
import com.google.gwt.user.client.rpc.AsyncCallback;




public interface Yeta5100ServiceAsync {
	
    /** 연말정산 대상자 삭제  **/
    public void Yeta5100ToYe160401_Delete(List<Ye161010DTO> listYe161010Dto , AsyncCallback<Long> callback);
	
    /** 급여자료 이관 **/
    public void PayrExec_Yeta_2020_Insert(List<Ye161010DTO> listYe161010Dto, AsyncCallback<Long> callback);

    //단위사업장 맵핑
    public void UpDpobExec_Yeta_2020_Insert(List<Ye161010DTO> listYe161010Dto, AsyncCallback<Long> callback); 
    
    
}
