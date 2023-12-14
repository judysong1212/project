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

import com.app.exterms.yearendtax.client.dto.yeta2019.Ye161010DTO;
import com.google.gwt.user.client.rpc.AsyncCallback;



public interface Yeta4500ServiceAsync {
	
	/** 당월급여반영 **/
	public void activityOnYeta4500List(List<Ye161010DTO> listYe161010dto, AsyncCallback<Long> callback) ;
	
	/** 그리드 수정 **/
	public void saveYeta4500Grid(List<Ye161010DTO> listYe161010dto, AsyncCallback<Long> callback) ;
	
	
}
