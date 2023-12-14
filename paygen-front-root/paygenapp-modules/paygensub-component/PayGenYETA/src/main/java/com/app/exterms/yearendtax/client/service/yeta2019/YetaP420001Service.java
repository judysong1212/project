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

import com.app.exterms.yearendtax.client.dto.yeta2019.PdfA102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfB101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfC101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfC202yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfC301yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfC401yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfD101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfE102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfF102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfG107yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfG207yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfG307yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfG407yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfJ101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfJ203yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfJ301yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfJ401yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfK101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfL102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfN101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfO101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfP102yDTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("YetaP420001Service.gwt")
public interface YetaP420001Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static YetaP420001ServiceAsync instance;
		public static YetaP420001ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(YetaP420001Service.class);
			}
			return instance;
		}
	}
    
	/** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfA102Y(List<PdfA102yDTO> listPdfA102yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfB101Y(List<PdfB101yDTO> listPdfB101yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfC101Y(List<PdfC101yDTO> listPdfC101yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfC202Y(List<PdfC202yDTO> listPdfC202yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfC301Y(List<PdfC301yDTO> listPdfC301yDto, ActionDatabase actionDatabase) throws MSFException ;
    
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfC401Y(List<PdfC401yDTO> listPdfC401yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfD101Y(List<PdfD101yDTO> listPdfD101yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfE102Y(List<PdfE102yDTO> listPdfE102yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfF102Y(List<PdfF102yDTO> listPdfF102yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfG107Y(List<PdfG107yDTO> listPdfG107yDto, ActionDatabase actionDatabase) throws MSFException ;
    
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfG207Y(List<PdfG207yDTO> listPdfG207yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 직불카드등  **/
    public Integer updateYetaP420001ToPdfG307Y(List<PdfG307yDTO> listPdfG307yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 제로페이  **/
    public Integer updateYetaP420001ToPdfG407Y(List<PdfG407yDTO> listPdfG407yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfJ101Y(List<PdfJ101yDTO> listPdfJ101yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfJ203Y(List<PdfJ203yDTO> listPdfJ203yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfJ301Y(List<PdfJ301yDTO> listPdfJ301yDto, ActionDatabase actionDatabase) throws MSFException ;
    
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfJ401Y(List<PdfJ401yDTO> listPdfJ401yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfK101Y(List<PdfK101yDTO> listPdfK101yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfL102Y(List<PdfL102yDTO> listPdfL102yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfN101Y(List<PdfN101yDTO> listPdfN101yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfO101Y(List<PdfO101yDTO> listPdfO101yDto, ActionDatabase actionDatabase) throws MSFException ;
    
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP420001ToPdfP102Y(List<PdfP102yDTO> listPdfP102yDto, ActionDatabase actionDatabase) throws MSFException ;
}
