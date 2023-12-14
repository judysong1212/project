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
package com.app.exterms.yearendtax.client.service.yeta2022;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2022.PdfA102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfB101yDTO;
//2022연말정산_추가
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfB201yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfC101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfC202yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfC301yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfC401yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfD101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfE102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfF102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfG107yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfG207yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfG307yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfG407yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfJ101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfJ203yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfJ301yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfJ401yDTO;
//2022연말정산_추가
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfJ501yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfK101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfL102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfN101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfO101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfP102yDTO;
//2022연말정산_추가
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfQ101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfQ201yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.PdfQ301yDTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("YetaP720001Service.gwt")
public interface YetaP720001Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static YetaP720001ServiceAsync instance;
		public static YetaP720001ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(YetaP720001Service.class);
			}
			return instance;
		}
	}
    
	/** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfA102Y(List<PdfA102yDTO> listPdfA102yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfB101Y(List<PdfB101yDTO> listPdfB101yDto, ActionDatabase actionDatabase) throws MSFException ;
    //2022연말정산_추가
    public Integer updateYetaP720001ToPdfB201Y(List<PdfB201yDTO> listPdfB201yDto, ActionDatabase actionDatabase) throws MSFException ;
    
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfC101Y(List<PdfC101yDTO> listPdfC101yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfC202Y(List<PdfC202yDTO> listPdfC202yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfC301Y(List<PdfC301yDTO> listPdfC301yDto, ActionDatabase actionDatabase) throws MSFException ;
    
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfC401Y(List<PdfC401yDTO> listPdfC401yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfD101Y(List<PdfD101yDTO> listPdfD101yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfE102Y(List<PdfE102yDTO> listPdfE102yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfF102Y(List<PdfF102yDTO> listPdfF102yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfG107Y(List<PdfG107yDTO> listPdfG107yDto, ActionDatabase actionDatabase) throws MSFException ;
    
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfG207Y(List<PdfG207yDTO> listPdfG207yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 직불카드등  **/
    public Integer updateYetaP720001ToPdfG307Y(List<PdfG307yDTO> listPdfG307yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 제로페이  **/
    public Integer updateYetaP720001ToPdfG407Y(List<PdfG407yDTO> listPdfG407yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfJ101Y(List<PdfJ101yDTO> listPdfJ101yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfJ203Y(List<PdfJ203yDTO> listPdfJ203yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfJ301Y(List<PdfJ301yDTO> listPdfJ301yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfJ401Y(List<PdfJ401yDTO> listPdfJ401yDto, ActionDatabase actionDatabase) throws MSFException ;
    
    //2022연말정산_추가
    public Integer updateYetaP720001ToPdfJ501Y(List<PdfJ501yDTO> listPdfJ501yDto, ActionDatabase actionDatabase) throws MSFException ;
    
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfK101Y(List<PdfK101yDTO> listPdfK101yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfL102Y(List<PdfL102yDTO> listPdfL102yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfN101Y(List<PdfN101yDTO> listPdfN101yDto, ActionDatabase actionDatabase) throws MSFException ;
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfO101Y(List<PdfO101yDTO> listPdfO101yDto, ActionDatabase actionDatabase) throws MSFException ;
    
    /** 연말정산 보장성 보험  **/
    public Integer updateYetaP720001ToPdfP102Y(List<PdfP102yDTO> listPdfP102yDto, ActionDatabase actionDatabase) throws MSFException ;
    
    //2022연말정산_추가
    public Integer updateYetaP720001ToPdfQ101Y(List<PdfQ101yDTO> listPdfPQ101yDto, ActionDatabase actionDatabase) throws MSFException;
    
    public Integer updateYetaP720001ToPdfQ201Y(List<PdfQ201yDTO> listPdfPQ201yDto, ActionDatabase actionDatabase) throws MSFException;
    
    public Integer updateYetaP720001ToPdfQ301Y(List<PdfQ301yDTO> listPdfPQ301yDto, ActionDatabase actionDatabase) throws MSFException;
}
