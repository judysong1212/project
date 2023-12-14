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
package com.app.exterms.basis.client.service;


import com.app.exterms.basis.client.dto.Bass6050DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Bass6050ServiceAsync {

    void saveBass6050Save(Bass6050DTO dto, MSFFormPanel.ActionDatabase actionDatabase, AsyncCallback<Long> callback );

}
