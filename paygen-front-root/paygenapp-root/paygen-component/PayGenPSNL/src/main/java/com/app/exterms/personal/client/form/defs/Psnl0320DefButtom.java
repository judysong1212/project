package com.app.exterms.personal.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0320BMButtom;
import com.app.exterms.personal.client.languages.PsnlConstants;
import com.app.exterms.personal.shared.PsnlDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Psnl0320DefButtom  extends TableDef implements PsnlDaoConstants {

	private int row = 0;
	private PsnlConstants psnlLabel = PsnlConstants.INSTANCE;

	 final PrgmComBass0300DTO sysComBass0300Dto;
	
	public Psnl0320DefButtom(){
		
		 sysComBass0300Dto = new PrgmComBass0300DTO(); 
		
		setTitle("");
		setDaoClass(CLASS_PSNL0320_DATA_LIST_BUTTOM);
		setCustomListMethod(CLASS_PSNL0320_DATA_LIST_BUTTOM);//CLASS_PSNL0320_DATA_LIST_BUTTOM
		setColumnsDefinition(getPsnl0100ToPsnl0250ColumnsList());
		setAutoFillGrid(false);
		setShowFilterToolbar(false);
		setCheckBoxOnGridRows(true);
		setEditFieldGrid(false);
	}

	private List<ColumnDef> getPsnl0100ToPsnl0250ColumnsList(){

		row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

		
		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Psnl0320BMButtom.ATTR_DPOB_CD, ColumnDef.TYPE_STRING , 100, true, false, true){
			{

			}
		});


		/** column 시스템키 : systemkey */
		listColumnDefs.add(new ColumnDef("시스템키", Psnl0320BMButtom.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 100, true, false, true){
			{

			}
		});


        /** column 호봉재획정일련번호 : pyspReMrkSeilNum */
		listColumnDefs.add(new ColumnDef("호봉재획정일련번호", Psnl0320BMButtom.ATTR_PYSP_RE_MRK_SEIL_NUM, ColumnDef.TYPE_STRING , 120, true, false, true){
			{

			}
		});

		/** column 호봉재획정계산일자 : pyspReMrkCalcDt */
		listColumnDefs.add(new ColumnDef("재획정일자", Psnl0320BMButtom.ATTR_RE_MRK_DT, ColumnDef.TYPE_STRING, 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		
		/** column 근속기준시작일자 : logStdBgnDt */
		listColumnDefs.add(new ColumnDef("근속기준일자", Psnl0320BMButtom.ATTR_LOG_STD_BGN_DT, ColumnDef.TYPE_STRING, 90, true, true, true){
			{
				setReadOnly(true);
			}
		});


		/** column 근속기준시작일자 : logStdBgnDt */
		listColumnDefs.add(new ColumnDef("호봉승급예정일자", Psnl0320BMButtom.ATTR_PYSP_PRMTN_SCDU_DT, ColumnDef.TYPE_STRING, 120, true, true, true){
			{
				setReadOnly(true);
			}
		});

		
		/** column 호봉재획정계산일자 : pyspReMrkCalcDt */
		listColumnDefs.add(new ColumnDef("호봉재획정계산일자", Psnl0320BMButtom.ATTR_PYSP_RE_MRK_CALC_DT, ColumnDef.TYPE_STRING, 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		
		/** column 호봉코드 : pyspCd */
		listColumnDefs.add(new ColumnDef("종전호봉", Psnl0320BMButtom.ATTR_M_PYSP_NM, ColumnDef.TYPE_STRING , 60, true, true, true){
			{
				setReadOnly(true);
			}
		});

		/** column 호봉코드 : pyspCd */
		listColumnDefs.add(new ColumnDef("호봉", Psnl0320BMButtom.ATTR_PYSP_NM, ColumnDef.TYPE_STRING , 40, true, true, true){
			{
				setReadOnly(true);
			}
		});
		
		/** column 호봉코드 : pyspCd */
		listColumnDefs.add(new ColumnDef("호봉코드", Psnl0320BMButtom.ATTR_PYSP_CD, ColumnDef.TYPE_STRING , 120, true, false, true){
			{
				setReadOnly(true);
			}
		});

		
		/** column 총근속일수 : totLogSvcDys */
		listColumnDefs.add(new ColumnDef("총근속일수", Psnl0320BMButtom.ATTR_TOT_LOG_SVC_DYS, ColumnDef.TYPE_STRING , 90, true, true, true){
			{

			}
		});

		/** column 근속년수코드 : logSvcYrNumCd */
		listColumnDefs.add(new ColumnDef("근속년수코드", Psnl0320BMButtom.ATTR_LOG_SVC_YR_NUM_CD, ColumnDef.TYPE_STRING , 120, true, false, true){
			{

			}
		});
		/** column 근속년수코드 : logSvcYrNumCd */
		listColumnDefs.add(new ColumnDef("근속년수", Psnl0320BMButtom.ATTR_LOG_SVC_YR_NUM_NM, ColumnDef.TYPE_STRING , 60, true, true, true){
			{

			}
		});
		
		

		/** column 근속월수코드 : logSvcMnthIcmCd */
		listColumnDefs.add(new ColumnDef("근속월수코드", Psnl0320BMButtom.ATTR_LOG_SVC_MNTH_ICM_CD, ColumnDef.TYPE_STRING , 120, true, false, true){
			{

			}
		});
		/** column 근속월수코드 : logSvcMnthIcmCd */
		listColumnDefs.add(new ColumnDef("근속월수", Psnl0320BMButtom.ATTR_LOG_SVC_MNTH_ICM_NM, ColumnDef.TYPE_STRING , 60, true, true, true){
			{

			}
		});
		

		/** column 근속일수 : logSvcDys */
		listColumnDefs.add(new ColumnDef("근속일수", Psnl0320BMButtom.ATTR_LOG_SVC_DYS, ColumnDef.TYPE_STRING , 60, true, true, true){
			{

			}
		});


		
		/** column 원총근속일수 : orgTotLogSvcDys */
		listColumnDefs.add(new ColumnDef("원총근속일수", Psnl0320BMButtom.ATTR_ORG_TOT_LOG_SVC_DYS, ColumnDef.TYPE_STRING , 80, true, true, true){
			{

			}
		});

		/** column 원근속년수코드 : orgLogSvcYrCd */
		listColumnDefs.add(new ColumnDef("원근속년수코드", Psnl0320BMButtom.ATTR_ORG_LOG_SVC_YR_CD, ColumnDef.TYPE_STRING , 120, true, false, true){
			{

			}
		});
		/** column 원근속년수코드 : orgLogSvcYrCd */
		listColumnDefs.add(new ColumnDef("원근속년수", Psnl0320BMButtom.ATTR_ORG_LOG_SVC_YR_NM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{

			}
		});

		/** column 원근속월수코드 : orgLogSvcMnthCd */
		listColumnDefs.add(new ColumnDef("원근속월수코드", Psnl0320BMButtom.ATTR_ORG_LOG_SVC_MNTH_CD, ColumnDef.TYPE_STRING , 120, true, false, true){
			{

			}
		});
		/** column 원근속월수코드 : orgLogSvcMnthCd */
		listColumnDefs.add(new ColumnDef("원근속월수", Psnl0320BMButtom.ATTR_ORG_LOG_SVC_MNTH_NM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{

			}
		});


		/** column 원근속일수 : orgLogSvcDys */
		listColumnDefs.add(new ColumnDef("원근속일수", Psnl0320BMButtom.ATTR_ORG_LOG_SVC_DYS, ColumnDef.TYPE_STRING , 80, true, true, true){
			{

			}
		});


        


		/** column 재획정일자 : reMrkDt */
		listColumnDefs.add(new ColumnDef("재획정일자", Psnl0320BMButtom.ATTR_RE_MRK_DT, ColumnDef.TYPE_STRING , 120, true, false, true){
			{

			}
		});


		/** column 승진예정일자 : pmtnScduDt */
		listColumnDefs.add(new ColumnDef("승진예정일자", Psnl0320BMButtom.ATTR_PMTN_SCDU_DT, ColumnDef.TYPE_STRING , 120, true, false, true){
			{

			}
		});


		/** column 재고용예정일자 : reymnScduDt */
		listColumnDefs.add(new ColumnDef("재고용예정일자", Psnl0320BMButtom.ATTR_REYMN_SCDU_DT, ColumnDef.TYPE_STRING , 120, true, false, true){
			{

			}
		});


		


		/** column 고용인정근속년수 : emymtRcgtnLogSvcYrNum */
		listColumnDefs.add(new ColumnDef("년수", Psnl0320BMButtom.ATTR_EMYMT_RCGTN_LOG_SVC_YR_NUM, ColumnDef.TYPE_STRING , 40, true, true, true){
			{

			}
		});


		/** column 고용인정근속월수 : emymtRcgtnLogSvcMnthNum */
		listColumnDefs.add(new ColumnDef("월수", Psnl0320BMButtom.ATTR_EMYMT_RCGTN_LOG_SVC_MNTH_NUM, ColumnDef.TYPE_STRING , 40, true, true, true){
			{

			}
		});


		/** column 고용인정근속일수 : emymtRcgtnLogSvcDys */
		listColumnDefs.add(new ColumnDef("일수", Psnl0320BMButtom.ATTR_EMYMT_RCGTN_LOG_SVC_DYS, ColumnDef.TYPE_STRING , 40, true, true, true){
			{

			}
		});


		/** column 군경력인정근속년수 : mityCarrRcgtnLogSvcYrNum */
		listColumnDefs.add(new ColumnDef("년수", Psnl0320BMButtom.ATTR_MITY_CARR_RCGTN_LOG_SVC_YR_NUM, ColumnDef.TYPE_STRING , 40, true, true, true){
			{

			}
		});


		/** column 군경력인정근속월수 : mityCarrRcgtnLogSvcMnth */
		listColumnDefs.add(new ColumnDef("월수", Psnl0320BMButtom.ATTR_MITY_CARR_RCGTN_LOG_SVC_MNTH, ColumnDef.TYPE_STRING , 40, true, true, true){
			{

			}
		});


		/** column 군경력인정근속일수 : mityCarrRcgtnLogSvcDys */
		listColumnDefs.add(new ColumnDef("일수", Psnl0320BMButtom.ATTR_MITY_CARR_RCGTN_LOG_SVC_DYS, ColumnDef.TYPE_STRING , 40, true, true, true){
			{

			}
		});


		/** column 경력인정근속년수 : carrRcgtnLogSvcYrNum */
		listColumnDefs.add(new ColumnDef("년수", Psnl0320BMButtom.ATTR_CARR_RCGTN_LOG_SVC_YR_NUM, ColumnDef.TYPE_STRING , 40, true, true, true){
			{

			}
		});


		/** column 경력인정근속월수 : carrRcgtnLogSvcMnthNum */
		listColumnDefs.add(new ColumnDef("월수", Psnl0320BMButtom.ATTR_CARR_RCGTN_LOG_SVC_MNTH_NUM, ColumnDef.TYPE_STRING , 40, true, true, true){
			{

			}
		});


		/** column 경력인정근속일수 : carrRcgtnLogSvcDys */
		listColumnDefs.add(new ColumnDef("일수", Psnl0320BMButtom.ATTR_CARR_RCGTN_LOG_SVC_DYS, ColumnDef.TYPE_STRING , 40, true, true, true){
			{

			}
		});


		/** column 징계감봉월수 : dsnyActCtwpMnthIcm */
		listColumnDefs.add(new ColumnDef("징계감봉월수", Psnl0320BMButtom.ATTR_DSNY_ACT_CTWP_MNTH_ICM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{

			}
		});


		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Psnl0320BMButtom.ATTR_KYBDR, ColumnDef.TYPE_STRING , 120, true, false, true){
			{

			}
		});


		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Psnl0320BMButtom.ATTR_INPT_DT, ColumnDef.TYPE_STRING , 120, true, false, true){
			{

			}
		});


		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Psnl0320BMButtom.ATTR_INPT_ADDR, ColumnDef.TYPE_STRING , 120, true, false, true){
			{

			}
		});


		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Psnl0320BMButtom.ATTR_ISMT, ColumnDef.TYPE_STRING , 120, true, false, true){
			{

			}
		});


		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Psnl0320BMButtom.ATTR_REVN_DT, ColumnDef.TYPE_STRING , 120, true, false, true){
			{

			}
		});


		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Psnl0320BMButtom.ATTR_REVN_ADDR, ColumnDef.TYPE_STRING , 120, true, false, true){
			{

			}
		});
		return listColumnDefs;
	}
}