package com.app.exterms.personal.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0320BMRight1;
import com.app.exterms.personal.shared.PsnlDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;
import com.extjs.gxt.ui.client.widget.form.Field;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Psnl0320DefRight10  extends TableDef implements PsnlDaoConstants {

//	private int row = 0;
//	private PsnlConstants psnlLabel = PsnlConstants.INSTANCE;
	final PrgmComBass0300DTO sysComBass0300Dto;

	protected ColumnDefListenerAdapter changeValueListenerAdapter;
	
	public Psnl0320DefRight10(){
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		
		setTitle("");
		setDaoClass(CLASS_PSNL0320_DATA_LIST_RIGHT10);
		setCustomListMethod(CLASS_PSNL0320_DATA_LIST_RIGHT10);
		setColumnsDefinition(getPsnl0110ToPsnl0320ColumnsList());
		setAutoFillGrid(false);
		setEditFieldGrid(true);
		setShowFilterToolbar(false);
		setCheckBoxOnGridRows(false);
		

//		 setAutoFillGrid(false);
//         setEditFieldGrid(true);
//         setShowFilterToolbar(false);
//         setCheckBoxOnGridRows(true);
		
		
		
//		changeValueListenerAdapter = new ColumnDefListenerAdapter() {
//       	 @SuppressWarnings("rawtypes")
//       	 public void run(Field field, Object valueField) {
//       		 MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
//       		 final ModelData formModel = formPanel.getFormBinding().getModel();
//       		 
//       		
//       		 
//       		 //Window.alert(""+Psnl0320BMRight1.ATTR_CVSN_RTO_DIV_CD);
//
////       		 Long natPennIncome = Long.parseLong(MSFSharedUtils.defaultNulls(formModel.get(Insr1100BM.ATTR_NATPENNINCOME).toString(),"0"));
////       		 double natPennHmlfBrdnApmrt = Double.parseDouble(MSFSharedUtils.defaultNulls(formModel.get(Insr1100BM.ATTR_NATPENNHMLFBRDNAPMRT).toString(),"0"));
////       		 long natPennPremium = (long) (natPennIncome * natPennHmlfBrdnApmrt * 0.01);
////       		 
////       		 Long hlthInsrIncome = Long.parseLong(MSFSharedUtils.defaultNulls(formModel.get(Insr1100BM.ATTR_HLTHINSRINCOME).toString(),"0"));
////       		 double hlthInsrHmlfBrdnApmrt = Double.parseDouble(MSFSharedUtils.defaultNulls(formModel.get(Insr1100BM.ATTR_HLTHINSRHMLFBRDNAPMRT).toString(),"0"));
////       		 long hlthInsrPremium = (long) (hlthInsrIncome * hlthInsrHmlfBrdnApmrt * 0.01);
////       		 
////       		 Long umytInsrIncome = Long.parseLong(MSFSharedUtils.defaultNulls(formModel.get(Insr1100BM.ATTR_UMYTINSRINCOME).toString(),"0"));
////       		 double umytInsrHmlfBrdnApmrt = Double.parseDouble(MSFSharedUtils.defaultNulls(formModel.get(Insr1100BM.ATTR_UMYTINSRHMLFBRDNAPMRT).toString(),"0"));
////       		 long umytInsrPremium = (long) (umytInsrIncome * umytInsrHmlfBrdnApmrt * 0.01);
////
////       		 Long idtlAccdtIncome = Long.parseLong(MSFSharedUtils.defaultNulls(formModel.get(Insr1100BM.ATTR_IDTLACCDTINCOME).toString(),"0"));
////       		 double idtlInsrHmlfBrdnApmrt = Double.parseDouble(MSFSharedUtils.defaultNulls(formModel.get(Insr1100BM.ATTR_IDTLINSRHMLFBRDNAPMRT).toString(),"0"));
////       		 long idtlAccdtPremium = (long) (idtlAccdtIncome * idtlInsrHmlfBrdnApmrt * 0.01);
//               
//       		// formModel.set(Psnl0320BMRight1.ATTR_DUTY_YR_NUM, "zzzz");
//       		// formModel.set(Insr1100BM.ATTR_HLTHINSRPREMIUM, hlthInsrPremium);
//       		 //formModel.set(Insr1100BM.ATTR_UMYTINSRPREMIUM, umytInsrPremium);
//       		 //formModel.set(Insr1100BM.ATTR_IDTLACCDTPREMIUM, idtlAccdtPremium);
//       	 }
//        };
//		
		
	}

public void setitemChange(Field itemField,Object itemCd) {
        
        changeValueListenerAdapter.run(itemField, itemCd);
        
    }
	
	private List<ColumnDef> getPsnl0110ToPsnl0320ColumnsList(){

		//row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

        /** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Psnl0320BMRight1.ATTR_DPOB_CD, ColumnDef.TYPE_STRING , 100, true, false, true){
			{
				setReadOnly(true);
			}
		});

		/** set SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0320BMRight1.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

		/** set 고용일련번호 : emymtSeilNum */
		listColumnDefs.add(new ColumnDef("고용일련번호", Psnl0320BMRight1.ATTR_EMYMT_SEIL_NUM, ColumnDef.TYPE_STRING , 50, false, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 고용구분코드 : emymtDivCd */
		listColumnDefs.add(new ColumnDef("고용구분코드", Psnl0320BMRight1.ATTR_EMYMT_DIV_CD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 고용구분 : emymtDivNm */
		listColumnDefs.add(new ColumnDef("고용구분", Psnl0320BMRight1.ATTR_EMYMT_DIV_NM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});


        /** column 고용유형코드 : emymtTypCd */
		listColumnDefs.add(new ColumnDef("고용유형코드", Psnl0320BMRight1.ATTR_EMYMT_TYP_CD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 고용유형 : emymtTypNm */
		listColumnDefs.add(new ColumnDef("고용유형", Psnl0320BMRight1.ATTR_EMYMT_TYP_NM, ColumnDef.TYPE_STRING , 60, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 시작일자(고용시작일자) : emymtBgnnDt */
		listColumnDefs.add(new ColumnDef("시작일자", Psnl0320BMRight1.ATTR_EMYMT_BGNN_DT, ColumnDef.TYPE_DATE , 70, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 종료일자(고용종료일자) : emymtEndDt */
		listColumnDefs.add(new ColumnDef("종료일자", Psnl0320BMRight1.ATTR_EMYMT_END_DT, ColumnDef.TYPE_DATE , 70, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 부서코드 : deptCd */
		listColumnDefs.add(new ColumnDef("부서코드", Psnl0320BMRight1.ATTR_DEPT_CD, ColumnDef.TYPE_STRING , 120, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 부서 : deptNm */
		listColumnDefs.add(new ColumnDef("부서", Psnl0320BMRight1.ATTR_DEPT_NM, ColumnDef.TYPE_STRING , 120, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 현근무지명 : currPaeWorkNm */
		listColumnDefs.add(new ColumnDef("현근무지명", Psnl0320BMRight1.ATTR_CURR_PAE_WORK_NM, ColumnDef.TYPE_STRING , 120, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 사업코드 : businCd */
		listColumnDefs.add(new ColumnDef("사업코드", Psnl0320BMRight1.ATTR_BUSIN_CD, ColumnDef.TYPE_STRING , 120, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 직종 : typeOccuNm */
		listColumnDefs.add(new ColumnDef("직종", Psnl0320BMRight1.ATTR_TYP_OCCU_NM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 직종코드 : typOccuCd */
		listColumnDefs.add(new ColumnDef("직종코드", Psnl0320BMRight1.ATTR_TYP_OCCU_CD, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 직종세구분 : dtilOccuInttnNm */
		listColumnDefs.add(new ColumnDef("직종세구분", Psnl0320BMRight1.ATTR_DTIL_OCCU_CLS_DIV_NM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 직종세구분코드 : dtilOccuClsDivCd */
		listColumnDefs.add(new ColumnDef("직종세구분코드", Psnl0320BMRight1.ATTR_DTIL_OCCU_CLS_DIV_CD, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 직책코드 : odtyCd */
		listColumnDefs.add(new ColumnDef("직책코드", Psnl0320BMRight1.ATTR_ODTY_CD, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 급여지급구분코드 : payPymtDivCd */
		listColumnDefs.add(new ColumnDef("급여지급구분코드", Psnl0320BMRight1.ATTR_PAY_PYMT_DIV_CD, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 고용금액 : emymtSum */
		listColumnDefs.add(new ColumnDef("고용금액", Psnl0320BMRight1.ATTR_EMYMT_SUM, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 고용사유내용 : emymtReasCtnt */
		listColumnDefs.add(new ColumnDef("고용사유내용", Psnl0320BMRight1.ATTR_EMYMT_REAS_CTNT, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 증번호 : certNumHuhd */
		listColumnDefs.add(new ColumnDef("증번호", Psnl0320BMRight1.ATTR_CERT_NUM_HUHD, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 경감시작일자 : rducBgnnDt */
		listColumnDefs.add(new ColumnDef("경감시작일자", Psnl0320BMRight1.ATTR_RDUC_BGNN_DT, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Psnl0320BMRight1.ATTR_KYBDR, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Psnl0320BMRight1.ATTR_INPT_DT, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Psnl0320BMRight1.ATTR_INPT_ADDR, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Psnl0320BMRight1.ATTR_ISMT, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Psnl0320BMRight1.ATTR_REVN_DT, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Psnl0320BMRight1.ATTR_REVN_ADDR, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 경감종료일자 : rducEndDt */
		listColumnDefs.add(new ColumnDef("경감종료일자", Psnl0320BMRight1.ATTR_RDUC_END_DT, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

		/** column 호봉등급코드 : pyspGrdeCd */
		listColumnDefs.add(new ColumnDef("호봉등급코드", Psnl0320BMRight1.ATTR_PYSP_GRDE_CD, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

		/* column 이건몰까 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("DTIL_OCCU_INTTN_CD", Psnl0320BMRight1.ATTR_DTIL_OCCU_INTTN_CD, ColumnDef.TYPE_STRING , 150, true, false, true){
			{
				setReadOnly(true);
			}
		});

		/* column 환산비율구분코드 : cvsnRtoDivCd */
		//Yeta3140Def.java 에서 참조
		//listColumnDefs.add(new ColumnListDef("의료증빙코드",   Yeta3140BM.ATTR_MEDICFCD,   ColumnDef.TYPE_STRING, 180, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
		sysComBass0300Dto.setRpsttvCd("A049");
		listColumnDefs.add(new ColumnListDef("환산비율구분코드", Psnl0320BMRight1.ATTR_CVSN_RTO_DIV_CD, ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
			{
				setReadOnly(false);
			}
		});

        /** column 근무년수 : dutyYrNum */
		listColumnDefs.add(new ColumnDef("근무년수", Psnl0320BMRight1.ATTR_DUTY_YR_NUM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 근무월수 : dutyMnthIcm */
		listColumnDefs.add(new ColumnDef("근무월수", Psnl0320BMRight1.ATTR_DUTY_MNTH_ICM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 근무일수 : dutyDayNum */
		listColumnDefs.add(new ColumnDef("근무일수", Psnl0320BMRight1.ATTR_DUTY_DAY_NUM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 근속전체일수 : dutyTotDayNum */
		listColumnDefs.add(new ColumnDef("근속전체일수", Psnl0320BMRight1.ATTR_DUTY_TOT_DAY_NUM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
				setReadOnly(true);
			}
		});

        return listColumnDefs;
    }
}