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
package com.app.exterms.yearendtax.client.service.yeta2017;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2017.PdfA102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfB101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfC101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfC202yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfC301yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfC401yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfD101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfE102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfF102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfG106yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfG206yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfG306yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfJ101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfJ203yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfJ301yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfJ401yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfK101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfL102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfN101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfO101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfP102yDTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface YetaP220001ServiceAsync {

	public void updateYetaP220001ToPdfA102Y(List<PdfA102yDTO> listPdfA102yDto, ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfB101Y(List<PdfB101yDTO> listPdfB101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfC101Y(List<PdfC101yDTO> listPdfC101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfC202Y(List<PdfC202yDTO> listPdfC202yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfC301Y(List<PdfC301yDTO> listPdfC301yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfC401Y(List<PdfC401yDTO> listPdfC401yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfD101Y(List<PdfD101yDTO> listPdfD101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfE102Y(List<PdfE102yDTO> listPdfE102yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfF102Y(List<PdfF102yDTO> listPdfF102yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfG106Y(List<PdfG106yDTO> listPdfG106yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfG206Y(List<PdfG206yDTO> listPdfG206yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfG306Y(List<PdfG306yDTO> listPdfG306yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfJ101Y(List<PdfJ101yDTO> listPdfJ101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfJ203Y(List<PdfJ203yDTO> listPdfJ203yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfJ301Y(List<PdfJ301yDTO> listPdfJ301yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfJ401Y(List<PdfJ401yDTO> listPdfJ401yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfK101Y(List<PdfK101yDTO> listPdfK101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfL102Y(List<PdfL102yDTO> listPdfL102yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfN101Y(List<PdfN101yDTO> listPdfN101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfO101Y(List<PdfO101yDTO> listPdfO101yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);

	public void updateYetaP220001ToPdfP102Y(List<PdfP102yDTO> listPdfP102yDto,	ActionDatabase actionDatabase, AsyncCallback<Integer> callback);
	
	
	
}
