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
//package com.app.exterms.yearendtax.client.service;
package com.app.exterms.insurance.client.service;

import java.util.List;

import com.app.exterms.insurance.client.dto.Insr5400DTO;
import com.google.gwt.user.client.rpc.AsyncCallback;



public interface Insr5400ServiceAsync {
	
	/** 그리드 수정 **/
	public void	saveInsr5400To5300Grid(List<Insr5400DTO> listInsr5400dto, AsyncCallback<Integer> callback) ;
	
	
}
