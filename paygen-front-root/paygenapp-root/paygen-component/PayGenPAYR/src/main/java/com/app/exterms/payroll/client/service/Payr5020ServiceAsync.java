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

import com.app.exterms.payroll.client.dto.Bass0350DTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Payr5020ServiceAsync {
	
	public void bass0350Update(Bass0350DTO bass0350Dto,	AsyncCallback<Long> Callback);
	
}
