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
package com.app.exterms.yearendtax.client.service.yeta2023;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2023.PdfA102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfB101yDTO;
//2022연말정산_추가
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfB201yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfC101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfC202yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfC301yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfC401yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfD101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfE102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfF102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfG107yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfG207yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfG307yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfG407yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfJ101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfJ203yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfJ301yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfJ401yDTO;
//2022연말정산_추가
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfJ501yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfK101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfL102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfN101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfO101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfP102yDTO;
//2022연말정산_추가
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfQ101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfQ201yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.PdfQ301yDTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface YetaP820001ServiceAsync {

	public void updateYetaP820001ToPdfA102Y(List<PdfA102yDTO> listPdfA102yDto, ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfB101Y(List<PdfB101yDTO> listPdfB101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);
	//2021연말정산_추가
	public void updateYetaP820001ToPdfB201Y(List<PdfB201yDTO> listPdfB201yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfC101Y(List<PdfC101yDTO> listPdfC101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfC202Y(List<PdfC202yDTO> listPdfC202yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfC301Y(List<PdfC301yDTO> listPdfC301yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfC401Y(List<PdfC401yDTO> listPdfC401yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfD101Y(List<PdfD101yDTO> listPdfD101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfE102Y(List<PdfE102yDTO> listPdfE102yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfF102Y(List<PdfF102yDTO> listPdfF102yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfG107Y(List<PdfG107yDTO> listPdfG107yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfG207Y(List<PdfG207yDTO> listPdfG207yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfG307Y(List<PdfG307yDTO> listPdfG307yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);
	/** 제로페이 **/
	public void updateYetaP820001ToPdfG407Y(List<PdfG407yDTO> listPdfG407yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfJ101Y(List<PdfJ101yDTO> listPdfJ101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfJ203Y(List<PdfJ203yDTO> listPdfJ203yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfJ301Y(List<PdfJ301yDTO> listPdfJ301yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfJ401Y(List<PdfJ401yDTO> listPdfJ401yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);
	//2021연말정산_추가
	public void updateYetaP820001ToPdfJ501Y(List<PdfJ501yDTO> listPdfJ501yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfK101Y(List<PdfK101yDTO> listPdfK101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfL102Y(List<PdfL102yDTO> listPdfL102yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfN101Y(List<PdfN101yDTO> listPdfN101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfO101Y(List<PdfO101yDTO> listPdfO101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP820001ToPdfP102Y(List<PdfP102yDTO> listPdfP102yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);
	
	public void updateYetaP820001ToPdfQ101Y(List<PdfQ101yDTO> listPdfQ101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);
	
	public void updateYetaP820001ToPdfQ201Y(List<PdfQ201yDTO> listPdfQ201yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);
	
	public void updateYetaP820001ToPdfQ301Y(List<PdfQ301yDTO> listPdfQ301yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);
	
	
	
}
