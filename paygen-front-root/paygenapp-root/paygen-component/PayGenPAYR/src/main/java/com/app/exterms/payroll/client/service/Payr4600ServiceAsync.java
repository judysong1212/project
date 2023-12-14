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
package com.app.exterms.payroll.client.service;


import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0600DTO;
import com.app.exterms.payroll.client.dto.Payr0650DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Payr4600ServiceAsync {
    void savePayr4600(Payr0600DTO payr0600DTO, ActionDatabase actionDatabase, AsyncCallback<Long> callback);

    void deletePayr4600(List<Payr0650DTO> payr0600DtoList, ActionDatabase actionDatabase, AsyncCallback<Long> callback);

    void savePayr0600PentrInfo(Payr0600DTO payr0600DTO, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
}
