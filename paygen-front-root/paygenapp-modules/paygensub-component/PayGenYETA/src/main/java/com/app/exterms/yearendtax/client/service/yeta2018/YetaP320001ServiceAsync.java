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

import com.app.exterms.yearendtax.client.dto.yeta2018.PdfA102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfB101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfC101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfC202yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfC301yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfC401yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfD101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfE102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfF102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfG107yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfG207yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfG307yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfJ101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfJ203yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfJ301yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfJ401yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfK101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfL102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfN101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfO101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfP102yDTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface YetaP320001ServiceAsync {

	public void updateYetaP320001ToPdfA102Y(List<PdfA102yDTO> listPdfA102yDto, ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfB101Y(List<PdfB101yDTO> listPdfB101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfC101Y(List<PdfC101yDTO> listPdfC101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfC202Y(List<PdfC202yDTO> listPdfC202yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfC301Y(List<PdfC301yDTO> listPdfC301yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfC401Y(List<PdfC401yDTO> listPdfC401yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfD101Y(List<PdfD101yDTO> listPdfD101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfE102Y(List<PdfE102yDTO> listPdfE102yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfF102Y(List<PdfF102yDTO> listPdfF102yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfG107Y(List<PdfG107yDTO> listPdfG107yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfG207Y(List<PdfG207yDTO> listPdfG207yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfG307Y(List<PdfG307yDTO> listPdfG307yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfJ101Y(List<PdfJ101yDTO> listPdfJ101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfJ203Y(List<PdfJ203yDTO> listPdfJ203yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfJ301Y(List<PdfJ301yDTO> listPdfJ301yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfJ401Y(List<PdfJ401yDTO> listPdfJ401yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfK101Y(List<PdfK101yDTO> listPdfK101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfL102Y(List<PdfL102yDTO> listPdfL102yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfN101Y(List<PdfN101yDTO> listPdfN101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfO101Y(List<PdfO101yDTO> listPdfO101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP320001ToPdfP102Y(List<PdfP102yDTO> listPdfP102yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);
	
	
	
}
