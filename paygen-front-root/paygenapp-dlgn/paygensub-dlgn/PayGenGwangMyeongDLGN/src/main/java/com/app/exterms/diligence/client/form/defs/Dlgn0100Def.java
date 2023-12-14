/**
 * 공통화면 팝업 
 */
package com.app.exterms.diligence.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.diligence.client.dto.Dlgn0100BM;
import com.app.exterms.diligence.client.dto.Dlgn0110BM;
import com.app.exterms.diligence.client.languages.DiligenceConstants;
import com.app.exterms.diligence.shared.DiligenceDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.widget.form.Field;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Dlgn0100Def  extends TableDef implements DiligenceDaoConstants {

    private int row = 0;
    final PrgmComBass0300DTO sysComBass0300Dto;
    private DiligenceConstants dlgnLabel = DiligenceConstants.INSTANCE;
    
    public static final String COLUMN_DEF_DILNLAZDUTYTM = "dilnlazDutyTm"; //근무시간
    public static final String COLUMN_DEF_DILNLAZABNCEYN = "dilnlazAbnceYn"; //결근여부
    public static final String COLUMN_DEF_DILNLAZLVSGYN = "dilnlazLvsgYn"; //연차여부
    public static final String COLUMN_DEF_DILNLAZSPCLHODYYN = "dilnlazSpclHodyYn"; //특(휴)여부
    public static final String COLUMN_DEF_DILNLAZSCKLEAYN = "dilnlazSckleaYn"; //병가여부
    public static final String COLUMN_DEF_DILNLAZOFFVAYN = "dilnlazOffvaYn"; //공가여부
    public static final String COLUMN_DEF_DILNLAZFMLYEVNTYN = "dilnlazFmlyEvntYn"; //경조사여부
    public static final String COLUMN_DEF_DILNLAZHLTHCREYN = "dilnlazHlthCreYn"; //보건여부
    
    public static final String FIELD_ID_DILNLAZDUTYTM = COLUMN_DEF_DILNLAZDUTYTM; //근무시간
    public static final String FIELD_ID_DILNLAZABNCEYN = COLUMN_DEF_DILNLAZABNCEYN; // 결근여부
    public static final String FIELD_ID_DILNLAZLVSGYN = COLUMN_DEF_DILNLAZLVSGYN; // 연차여부
    public static final String FIELD_ID_DILNLAZSPCLHODYYN = COLUMN_DEF_DILNLAZSPCLHODYYN; // 특(휴)여부
    public static final String FIELD_ID_DILNLAZSCKLEAYN = COLUMN_DEF_DILNLAZSCKLEAYN; // 병가여부
    public static final String FIELD_ID_DILNLAZOFFVAYN = COLUMN_DEF_DILNLAZOFFVAYN; // 공가여부
    public static final String FIELD_ID_DILNLAZFMLYEVNTYN = COLUMN_DEF_DILNLAZFMLYEVNTYN; // 경조사여부
    public static final String FIELD_ID_DILNLAZHLTHCREYN = COLUMN_DEF_DILNLAZHLTHCREYN; // 보건여부
    
    protected ColumnDefListenerAdapter changeValueListenerAdapter1; //결근
    protected ColumnDefListenerAdapter changeValueListenerAdapter2; //연차
    protected ColumnDefListenerAdapter changeValueListenerAdapter3; //특(휴)
    protected ColumnDefListenerAdapter changeValueListenerAdapter4; //병가
    protected ColumnDefListenerAdapter changeValueListenerAdapter5; //공가
    protected ColumnDefListenerAdapter changeValueListenerAdapter6; //경조사
    protected ColumnDefListenerAdapter changeValueListenerAdapter7; //보건
    protected ColumnDefListenerAdapter changeValueListenerAdapter8; //근무
    
	public Dlgn0100Def(String chkDef) {

		sysComBass0300Dto = new PrgmComBass0300DTO();

		if ("DLGN0100".equals(chkDef)) {
			setTitle("");
			setDaoClass("");
			setDaoClass("");
			setCustomListMethod(CLASS_DLGN0100LIST_01);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditFieldGrid(true);
			setCellModel(true);
			setColumnsDefinition(getDLGN0100ColumnsList01());
		} else if ("DLGN0100_1".equals(chkDef)) {
			setTitle("");
			setDaoClass("");
			setCustomListMethod(CLASS_DLGN0100LIST_01_1);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditFieldGrid(true);
			setCellModel(true);
			setColumnsDefinition(getDLGN0100ColumnsList01_1());
		} else {

			setTitle("");
			setDaoClass("");
			setCustomListMethod("");
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditFieldGrid(true);
			setCellModel(true);
			setColumnsDefinition(getDLGN0200ColumnsList());

		}
	}
	
	private List<ColumnDef> getDLGN0100ColumnsList01() {

		// 결근여부 이벤트 처리
		changeValueListenerAdapter1 = new ColumnDefListenerAdapter() {

			@SuppressWarnings("rawtypes")
			public void run(Field field, Object valueField) {

				MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
				final ModelData formModel = formPanel.getFormBinding().getModel();

				String dilnlazDutyTm = "0:00";
				Boolean dilnlazDutyYn = false;
				Boolean dilnlazAbnceYn = formModel.get(Dlgn0110BM.ATTR_DILNLAZABNCEYN); // 결근

				if (dilnlazAbnceYn == false) {
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, dilnlazDutyTm);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZBUTPYN, dilnlazDutyYn); 		// 출장
				} else {
					dilnlazDutyYn = true;
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, "8:00");
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZBUTPYN, dilnlazDutyYn); 		// 출장
				}
			}
		};
		
		// 연차여부 이벤트 처리
		changeValueListenerAdapter2 = new ColumnDefListenerAdapter() {

			@SuppressWarnings("rawtypes")
			public void run(Field field, Object valueField) {

				MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
				final ModelData formModel = formPanel.getFormBinding().getModel();

				String dilnlazDutyTm = "0:00";
				Boolean dilnlazDutyYn = false;
				Boolean dilnlazLvsgYn = formModel.get(Dlgn0110BM.ATTR_DILNLAZLVSGYN); // 연차

				if (dilnlazLvsgYn == false) {
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, dilnlazDutyTm);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZBUTPYN, dilnlazDutyYn); 		// 출장
				} else {
					dilnlazDutyYn = true;
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, "8:00");
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZBUTPYN, dilnlazDutyYn); 		// 출장
				}
			}
		};
		
		// 특(휴)여부 이벤트처리
		changeValueListenerAdapter3 = new ColumnDefListenerAdapter() {

			@SuppressWarnings("rawtypes")
			public void run(Field field, Object valueField) {

				MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
				final ModelData formModel = formPanel.getFormBinding().getModel();

				String dilnlazDutyTm = "0:00";
				Boolean dilnlazDutyYn = false;
				Boolean dilnlazSpclHodyYn = formModel.get(Dlgn0110BM.ATTR_DILNLAZSPCLHODYYN); // 특(휴)

				if (dilnlazSpclHodyYn == false) {
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, dilnlazDutyTm);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZBUTPYN, dilnlazDutyYn); 		// 출장
				} else {
					dilnlazDutyYn = true;
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, "8:00");
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZBUTPYN, dilnlazDutyYn); 		// 출장
				}
			}

		};
		// 병가여부 이벤트처리
		changeValueListenerAdapter4 = new ColumnDefListenerAdapter() {

			@SuppressWarnings("rawtypes")
			public void run(Field field, Object valueField) {

				MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
				final ModelData formModel = formPanel.getFormBinding().getModel();

				String dilnlazDutyTm = "0:00";
				Boolean dilnlazDutyYn = false;
				Boolean dilnlazSckleaYn = formModel.get(Dlgn0110BM.ATTR_DILNLAZSCKLEAYN); // 병가

				if (dilnlazSckleaYn == false) {
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, dilnlazDutyTm);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZBUTPYN, dilnlazDutyYn); 		// 출장
				} else {
					dilnlazDutyYn = true;
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, "8:00");
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZBUTPYN, dilnlazDutyYn); 		// 출장
				}
			}

		};
		// 공가여부 이벤트처리
		changeValueListenerAdapter5 = new ColumnDefListenerAdapter() {

			@SuppressWarnings("rawtypes")
			public void run(Field field, Object valueField) {

				MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
				final ModelData formModel = formPanel.getFormBinding().getModel();

				String dilnlazDutyTm = "0:00";
				Boolean dilnlazDutyYn = false;
				Boolean dilnlazOffvaYn = formModel.get(Dlgn0110BM.ATTR_DILNLAZOFFVAYN); // 공가

				if (dilnlazOffvaYn == false) {
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, dilnlazDutyTm);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZBUTPYN, dilnlazDutyYn); 		// 출장
				} else {
					dilnlazDutyYn = true;
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, "8:00");
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZBUTPYN, dilnlazDutyYn); 		// 출장
				}
			}

		};
		// 경조사여부 이벤트처리
		changeValueListenerAdapter6 = new ColumnDefListenerAdapter() {

			@SuppressWarnings("rawtypes")
			public void run(Field field, Object valueField) {

				MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
				final ModelData formModel = formPanel.getFormBinding().getModel();

				String dilnlazDutyTm = "0:00";
				Boolean dilnlazDutyYn = false;
				Boolean dilnlazFmlyEvntYn = formModel.get(Dlgn0110BM.ATTR_DILNLAZFMLYEVNTYN); // 경조사

				if (dilnlazFmlyEvntYn == false) {
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, dilnlazDutyTm);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZBUTPYN, dilnlazDutyYn); 		// 출장
				} else {
					dilnlazDutyYn = true;
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, "8:00");
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZBUTPYN, dilnlazDutyYn); 		// 출장
				}
			}

		};
		// 보건여부 이벤트처리
		changeValueListenerAdapter7 = new ColumnDefListenerAdapter() {

			@SuppressWarnings("rawtypes")
			public void run(Field field, Object valueField) {

				MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
				final ModelData formModel = formPanel.getFormBinding().getModel();

				String dilnlazDutyTm = "0:00";
				Boolean dilnlazDutyYn = false;
				Boolean dilnlazHlthCreYn = formModel.get(Dlgn0110BM.ATTR_DILNLAZHLTHCREYN); // 보건

				if (dilnlazHlthCreYn == false) {
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, dilnlazDutyTm);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZBUTPYN, dilnlazDutyYn); 		// 출장
				} else {
					dilnlazDutyYn = true;
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, "8:00");
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZBUTPYN, dilnlazDutyYn); 		// 출장
				}

			}

		};
		
		
		// 근무시간 이벤트 처리
		changeValueListenerAdapter8 = new ColumnDefListenerAdapter() {

			@SuppressWarnings("rawtypes")
			public void run(Field field, Object valueField) {

				MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
				final ModelData formModel = formPanel.getFormBinding().getModel();

				String dilnlazDutyTmStr = (String) valueField; 	// 근무시간
				int idx = dilnlazDutyTmStr.indexOf(":");
				
				dilnlazDutyTmStr = dilnlazDutyTmStr.substring(0,idx);
				
				int dilnlazDutyTm = Integer.parseInt(dilnlazDutyTmStr);  
				
				if (dilnlazDutyTm < 8) {
					
					if(dilnlazDutyTm == 0) {
						formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, false);	// 근무여부
					}
					
					formModel.set(Dlgn0110BM.ATTR_DILNLAZBUTPYN, false); 		// 출장
					
					
				} else {
					
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, true);			// 근무여부
					formModel.set(Dlgn0110BM.ATTR_DILNLAZBUTPYN, true); 		// 출장
					
				}

			}

		};	
		
		
    	row = 0;
		
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Dlgn0100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Dlgn0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근무년월 : dilnlazYrMnth */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Dlgn0110BM.ATTR_DILNLAZYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 급여구분코드 : payCd */
		listColumnDefs.add(new ColumnDef("급여구분코드", Dlgn0100BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
		listColumnDefs.add(new ColumnDef("근태_주휴일수", Dlgn0100BM.ATTR_DILNLAZWKLYHLDYNUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
        /** column 근태_근태일자 : dilnlazApptnDt */
		listColumnDefs.add(new ColumnDef("근태일자", Dlgn0110BM.ATTR_DILNLAZAPPTNDT, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
				
			}
		});
		 /** column 근태_근무시간 : dilnlazDutyTm */
		listColumnDefs.add(new ColumnDef("시간", Dlgn0110BM.ATTR_DILNLAZDUTYTM, ColumnDef.TYPE_STRING , 60, true, true, true){
			{
//				setTypeTextField(ColumnDef.TEXTFIELD);
//	        	setTextFdMask("9:99");
				setSelectOnFocus(true);
				addTrigger(Events.Change, changeValueListenerAdapter8);
		
			}
		});
		 /** column 근태_근무여부 : dilnlazDutyYn */
		listColumnDefs.add(new ColumnDef("근무", Dlgn0110BM.ATTR_DILNLAZDUTYYN, ColumnDef.TYPE_BOOLEAN , 60, true, true, true){
			{
				setReadOnly(true);
				
			}
		});
		 /** column 근태_결근여부 : dilnlazAbnceYn */
		listColumnDefs.add(new ColumnDef("결근", Dlgn0110BM.ATTR_DILNLAZABNCEYN, ColumnDef.TYPE_BOOLEAN , 60, true, true, true){
			{
				addTrigger(Events.Change, changeValueListenerAdapter1);
			}
		});
		 /** column 근태_연차여부 : dilnlazLvsgYn */
		listColumnDefs.add(new ColumnDef("연차", Dlgn0110BM.ATTR_DILNLAZLVSGYN, ColumnDef.TYPE_BOOLEAN , 60, true, true, true){
			{
				addTrigger(Events.Change, changeValueListenerAdapter2);
			}
		});
		 /** column 근태_특(휴)여부 : dilnlazSpclHodyYn */
		listColumnDefs.add(new ColumnDef("특(휴)", Dlgn0110BM.ATTR_DILNLAZSPCLHODYYN, ColumnDef.TYPE_BOOLEAN , 60, true, true, true){
			{
				addTrigger(Events.Change, changeValueListenerAdapter3);
			}
		});
		 /** column 근태_병가여부 : dilnlazSckleaYn */
		listColumnDefs.add(new ColumnDef("병가", Dlgn0110BM.ATTR_DILNLAZSCKLEAYN, ColumnDef.TYPE_BOOLEAN , 60, true, true, true){
			{
				addTrigger(Events.Change, changeValueListenerAdapter4);
			}
		});
		 /** column 근태_공가여부 : dilnlazOffvaYn */
		listColumnDefs.add(new ColumnDef("공가", Dlgn0110BM.ATTR_DILNLAZOFFVAYN, ColumnDef.TYPE_BOOLEAN , 60, true, true, true){
			{
				addTrigger(Events.Change, changeValueListenerAdapter5);
			}
		});
		/** column 근태_경조사여부 : dilnlazFmlyEvntYn */
		listColumnDefs.add(new ColumnDef("경조사", Dlgn0110BM.ATTR_DILNLAZFMLYEVNTYN, ColumnDef.TYPE_BOOLEAN , 60, true, true, true){
			{
				addTrigger(Events.Change, changeValueListenerAdapter6);
			}
		});
		/** column 근태_보건여부 : dilnlazHlthCreYn */
		listColumnDefs.add(new ColumnDef("보건", Dlgn0110BM.ATTR_DILNLAZHLTHCREYN, ColumnDef.TYPE_BOOLEAN , 60, true, true, true){
			{
				addTrigger(Events.Change, changeValueListenerAdapter7);
			}
		});
		/** column 근태_교통비여부 : dilnlazTfcAssCstYn */
		listColumnDefs.add(new ColumnDef("교통비", Dlgn0110BM.ATTR_DILNLAZTFCASSCSTYN, ColumnDef.TYPE_BOOLEAN , 60, false, false, false){
			{
		
			}
		});
		/** column 근태_급식비여부 : dilnlazLnchYn */
		listColumnDefs.add(new ColumnDef("급식비", Dlgn0110BM.ATTR_DILNLAZLNCHYN, ColumnDef.TYPE_BOOLEAN , 60, false, false, false){
			{
		
			}
		});
		
		/** column 근태_출장여부 : dilnlazButpYn */
		listColumnDefs.add(new ColumnDef("출장비", Dlgn0110BM.ATTR_DILNLAZBUTPYN, ColumnDef.TYPE_BOOLEAN , 60, false, true, true){
			{

			}
		});
		
		/** column 휴일여부 : offdayKubn */
		listColumnDefs.add(new ColumnDef("휴일", Dlgn0110BM.ATTR_OFFDAYKUBN, ColumnDef.TYPE_STRING , 60, true, false, true){
			{
		
			}
		});
	    sysComBass0300Dto.setRpsttvCd("N001");
        listColumnDefs.add(new ColumnListDef("복무기타", Dlgn0110BM.ATTR_DILNLAZETCDIVCD, ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Dlgn0100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Dlgn0100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Dlgn0100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Dlgn0100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Dlgn0100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Dlgn0100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		
        return listColumnDefs;
    }

	private List<ColumnDef> getDLGN0100ColumnsList01_1() {
		// 결근여부 이벤트 처리
		changeValueListenerAdapter1 = new ColumnDefListenerAdapter() {

			@SuppressWarnings("rawtypes")
			public void run(Field field, Object valueField) {

				MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
				final ModelData formModel = formPanel.getFormBinding()
						.getModel();

				String dilnlazDutyTm = "0";
				Boolean dilnlazDutyYn = false;
				Boolean dilnlazAbnceYn = formModel
						.get(Dlgn0110BM.ATTR_DILNLAZABNCEYN); // 결근

				if (dilnlazAbnceYn == false) {
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, dilnlazDutyTm);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
				} else {
					dilnlazDutyYn = true;
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, "8:00");
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
				}
			}
		};
		
		// 연차여부 이벤트 처리
		changeValueListenerAdapter2 = new ColumnDefListenerAdapter() {

			@SuppressWarnings("rawtypes")
			public void run(Field field, Object valueField) {

				MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
				final ModelData formModel = formPanel.getFormBinding()
						.getModel();

				String dilnlazDutyTm = "0";
				Boolean dilnlazDutyYn = false;
				Boolean dilnlazLvsgYn = formModel
						.get(Dlgn0110BM.ATTR_DILNLAZLVSGYN); // 연차

				if (dilnlazLvsgYn == false) {
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, dilnlazDutyTm);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
				} else {
					dilnlazDutyYn = true;
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, "8:00");
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
				}
			}
		};
		
		// 특(휴)여부 이벤트처리
		changeValueListenerAdapter3 = new ColumnDefListenerAdapter() {

			@SuppressWarnings("rawtypes")
			public void run(Field field, Object valueField) {

				MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
				final ModelData formModel = formPanel.getFormBinding().getModel();

				String dilnlazDutyTm = "0";
				Boolean dilnlazDutyYn = false;
				Boolean dilnlazSpclHodyYn = formModel.get(Dlgn0110BM.ATTR_DILNLAZSPCLHODYYN); // 특(휴)

				if (dilnlazSpclHodyYn == false) {
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, dilnlazDutyTm);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
				} else {
					dilnlazDutyYn = true;
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, "8:00");
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
				}
			}

		};
		
		// 병가여부 이벤트처리
		changeValueListenerAdapter4 = new ColumnDefListenerAdapter() {

			@SuppressWarnings("rawtypes")
			public void run(Field field, Object valueField) {

				MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
				final ModelData formModel = formPanel.getFormBinding().getModel();

				String dilnlazDutyTm = "0";
				Boolean dilnlazDutyYn = false;
				Boolean dilnlazSckleaYn = formModel.get(Dlgn0110BM.ATTR_DILNLAZSCKLEAYN); // 병가

				if (dilnlazSckleaYn == false) {
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, dilnlazDutyTm);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
				} else {
					dilnlazDutyYn = true;
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, "8:00");
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
				}
			}
		};
		
		// 공가여부 이벤트처리
		changeValueListenerAdapter5 = new ColumnDefListenerAdapter() {

			@SuppressWarnings("rawtypes")
			public void run(Field field, Object valueField) {

				MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
				final ModelData formModel = formPanel.getFormBinding().getModel();

				String dilnlazDutyTm = "0";
				Boolean dilnlazDutyYn = false;
				Boolean dilnlazOffvaYn = formModel.get(Dlgn0110BM.ATTR_DILNLAZOFFVAYN); // 공가

				if (dilnlazOffvaYn == false) {
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, dilnlazDutyTm);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
				} else {
					dilnlazDutyYn = true;
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, "8:00");
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
				}
			}

		};
		// 경조사여부 이벤트처리
		changeValueListenerAdapter6 = new ColumnDefListenerAdapter() {

			@SuppressWarnings("rawtypes")
			public void run(Field field, Object valueField) {

				MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
				final ModelData formModel = formPanel.getFormBinding().getModel();

				String dilnlazDutyTm = "0";
				Boolean dilnlazDutyYn = false;
				Boolean dilnlazFmlyEvntYn = formModel.get(Dlgn0110BM.ATTR_DILNLAZFMLYEVNTYN); // 경조사

				if (dilnlazFmlyEvntYn == false) {
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, dilnlazDutyTm);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
				} else {
					dilnlazDutyYn = true;
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, "8:00");
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
				}
			}
		};
		
		// 보건여부 이벤트처리
		changeValueListenerAdapter7 = new ColumnDefListenerAdapter() {

			@SuppressWarnings("rawtypes")
			public void run(Field field, Object valueField) {

				MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
				final ModelData formModel = formPanel.getFormBinding().getModel();

				String dilnlazDutyTm = "0";
				Boolean dilnlazDutyYn = false;
				Boolean dilnlazHlthCreYn = formModel.get(Dlgn0110BM.ATTR_DILNLAZHLTHCREYN); // 보건

				if (dilnlazHlthCreYn == false) {
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, dilnlazDutyTm);
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
				} else {
					dilnlazDutyYn = true;
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYTM, "8:00");
					formModel.set(Dlgn0110BM.ATTR_DILNLAZDUTYYN, dilnlazDutyYn);
				}
			}
		};
		
		row = 0;
		
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Dlgn0100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Dlgn0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 급여구분코드 : payCd */
		listColumnDefs.add(new ColumnDef("급여구분코드", Dlgn0100BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
		listColumnDefs.add(new ColumnDef("근태_주휴일수", Dlgn0100BM.ATTR_DILNLAZWKLYHLDYNUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
        /** column 근태_근태일자 : dilnlazApptnDt */
		listColumnDefs.add(new ColumnDef("근태일자", Dlgn0110BM.ATTR_DILNLAZAPPTNDT, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
				
			}
		});
		 /** column 근태_근무시간 : dilnlazDutyTm */
		listColumnDefs.add(new ColumnDef("근무시간", Dlgn0110BM.ATTR_DILNLAZDUTYTM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
//				 setTypeTextField(ColumnDef.TEXTFIELD);
//	        	 setTextFdMask("9:99");
	        	 setSelectOnFocus(true);
			}
		});
		 /** column 근태_근무여부 : dilnlazDutyYn */
		listColumnDefs.add(new ColumnDef("근무", Dlgn0110BM.ATTR_DILNLAZDUTYYN, ColumnDef.TYPE_BOOLEAN , 60, true, true, true){
			{
				setReadOnly(true);
			}
		});
		 /** column 근태_결근여부 : dilnlazAbnceYn */
		listColumnDefs.add(new ColumnDef("결근", Dlgn0110BM.ATTR_DILNLAZABNCEYN, ColumnDef.TYPE_BOOLEAN , 60, true, true, true){
			{
				addTrigger(Events.Change, changeValueListenerAdapter1);
			}
		});
		 /** column 근태_연차여부 : dilnlazLvsgYn */
		listColumnDefs.add(new ColumnDef("연차", Dlgn0110BM.ATTR_DILNLAZLVSGYN, ColumnDef.TYPE_BOOLEAN , 60, true, true, true){
			{
				addTrigger(Events.Change, changeValueListenerAdapter2);
			}
		});
		 /** column 근태_특(휴)여부 : dilnlazSpclHodyYn */
		listColumnDefs.add(new ColumnDef("특(휴)", Dlgn0110BM.ATTR_DILNLAZSPCLHODYYN, ColumnDef.TYPE_BOOLEAN , 60, true, true, true){
			{
				addTrigger(Events.Change, changeValueListenerAdapter3);
			}
		});
		 /** column 근태_병가여부 : dilnlazSckleaYn */
		listColumnDefs.add(new ColumnDef("병가", Dlgn0110BM.ATTR_DILNLAZSCKLEAYN, ColumnDef.TYPE_BOOLEAN , 60, true, true, true){
			{
				addTrigger(Events.Change, changeValueListenerAdapter4);
			}
		});
		 /** column 근태_공가여부 : dilnlazOffvaYn */
		listColumnDefs.add(new ColumnDef("공가", Dlgn0110BM.ATTR_DILNLAZOFFVAYN, ColumnDef.TYPE_BOOLEAN , 60, true, true, true){
			{
				addTrigger(Events.Change, changeValueListenerAdapter5);
			}
		});
		/** column 근태_경조사여부 : dilnlazFmlyEvntYn */
		listColumnDefs.add(new ColumnDef("경조사", Dlgn0110BM.ATTR_DILNLAZFMLYEVNTYN, ColumnDef.TYPE_BOOLEAN , 60, true, true, true){
			{
				addTrigger(Events.Change, changeValueListenerAdapter6);
			}
		});
		/** column 근태_보건여부 : dilnlazHlthCreYn */
		listColumnDefs.add(new ColumnDef("보건", Dlgn0110BM.ATTR_DILNLAZHLTHCREYN, ColumnDef.TYPE_BOOLEAN , 60, true, true, true){
			{
				addTrigger(Events.Change, changeValueListenerAdapter7);
			}
		});
		/** column 근태_교통비여부 : dilnlazTfcAssCstYn */
		listColumnDefs.add(new ColumnDef("교통비", Dlgn0110BM.ATTR_DILNLAZTFCASSCSTYN, ColumnDef.TYPE_BOOLEAN , 60,  true, false, true){
			{
		
			}
		});
		/** column 근태_급식비여부 : dilnlazLnchYn */
		listColumnDefs.add(new ColumnDef("급식비", Dlgn0110BM.ATTR_DILNLAZLNCHYN, ColumnDef.TYPE_BOOLEAN , 60,  true, false, true){
			{
		
			}
		});
		/** column 휴일여부 : offdayKubn */
		listColumnDefs.add(new ColumnDef("휴일", Dlgn0110BM.ATTR_OFFDAYKUBN, ColumnDef.TYPE_STRING , 60, true, false, true){
			{
		
			}
		});
	    sysComBass0300Dto.setRpsttvCd("N001");
        listColumnDefs.add(new ColumnListDef("복무기타", Dlgn0110BM.ATTR_DILNLAZETCDIVCD, ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Dlgn0100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Dlgn0100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Dlgn0100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Dlgn0100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Dlgn0100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Dlgn0100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		
        return listColumnDefs;
    }

 private List<ColumnDef> getDLGN0200ColumnsList() {
    		
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Dlgn0100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Dlgn0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태년월 : dilnlazYrMnth */
		listColumnDefs.add(new ColumnDef("근태년월", Dlgn0100BM.ATTR_DILNLAZYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 급여구분코드 : payCd */
		listColumnDefs.add(new ColumnDef("급여구분코드", Dlgn0100BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 고용구분코드 : emymtDivCd */
		listColumnDefs.add(new ColumnDef("고용구분코드", Dlgn0100BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 부서코드 : deptCd */
		listColumnDefs.add(new ColumnDef("부서코드", Dlgn0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사업코드 : businCd */
		listColumnDefs.add(new ColumnDef("사업코드", Dlgn0100BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 직종코드 : typOccuCd */
		listColumnDefs.add(new ColumnDef("직종코드", Dlgn0100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 직종세구분코드 : dtilOccuClsDivCd */
		listColumnDefs.add(new ColumnDef("직종세구분코드", Dlgn0100BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_근무시작일자 : dilnlazDutyBgnnDt */
		listColumnDefs.add(new ColumnDef("근태_근무시작일자", Dlgn0100BM.ATTR_DILNLAZDUTYBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_근무종료일자 : dilnlazDutyEndDt */
		listColumnDefs.add(new ColumnDef("근태_근무종료일자", Dlgn0100BM.ATTR_DILNLAZDUTYENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_근무일수 : dilnlazDutyNumDys */
		listColumnDefs.add(new ColumnDef("근태_근무일수", Dlgn0100BM.ATTR_DILNLAZDUTYNUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_연가일수 : dilnlazLvsgNumDys */
		listColumnDefs.add(new ColumnDef("근태_연가일수", Dlgn0100BM.ATTR_DILNLAZLVSGNUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_결근일수 : dilnlazAbnceNumDys */
		listColumnDefs.add(new ColumnDef("근태_결근일수", Dlgn0100BM.ATTR_DILNLAZABNCENUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_병가일수 : dilnlazSckleaNumDys */
		listColumnDefs.add(new ColumnDef("근태_병가일수", Dlgn0100BM.ATTR_DILNLAZSCKLEANUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_공가일수 : dilnlazOffvaNumDys */
		listColumnDefs.add(new ColumnDef("근태_공가일수", Dlgn0100BM.ATTR_DILNLAZOFFVANUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_경조사일수 : dilnlazFmlyEvntNumDys */
		listColumnDefs.add(new ColumnDef("근태_경조사일수", Dlgn0100BM.ATTR_DILNLAZFMLYEVNTNUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_보건일수 : dilnlazHlthCreNumDys */
		listColumnDefs.add(new ColumnDef("근태_보건일수", Dlgn0100BM.ATTR_DILNLAZHLTHCRENUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_총근무일수 : dilnlazTotDutyNumDys */
		listColumnDefs.add(new ColumnDef("근태_총근무일수", Dlgn0100BM.ATTR_DILNLAZTOTDUTYNUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
		listColumnDefs.add(new ColumnDef("근태_주휴일수", Dlgn0100BM.ATTR_DILNLAZWKLYHLDYNUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_유급휴일수 : dilnlazPaidPubcHodyNum */
		listColumnDefs.add(new ColumnDef("근태_유급휴일수", Dlgn0100BM.ATTR_DILNLAZPAIDPUBCHODYNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
		listColumnDefs.add(new ColumnDef("근태_마감처리여부", Dlgn0100BM.ATTR_DILNLAZDDLNEPRCSYN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_비고내용 : dilnlazNoteCtnt */
		listColumnDefs.add(new ColumnDef("근태_비고내용", Dlgn0100BM.ATTR_DILNLAZNOTECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Dlgn0100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Dlgn0100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Dlgn0100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Dlgn0100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Dlgn0100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Dlgn0100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
		listColumnDefs.add(new ColumnDef("근태_특별휴가일수", Dlgn0100BM.ATTR_DILNLAZSPCLHODYNUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 총토요근무일수 : dilnlazSatDutyNumDys */
		listColumnDefs.add(new ColumnDef("총토요근무일수", Dlgn0100BM.ATTR_DILNLAZSATDUTYNUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
		listColumnDefs.add(new ColumnDef("총휴일근무일수", Dlgn0100BM.ATTR_DILNLAZPUBCHODYDUTYNUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
		listColumnDefs.add(new ColumnDef("근태_결근인정일수", Dlgn0100BM.ATTR_DILNLAZABNCEDUTYRCGTNDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 호봉등급코드 : pyspGrdeCd */
		listColumnDefs.add(new ColumnDef("호봉등급코드", Dlgn0100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_총근무시간 : dilnlazTotDutyTm */
		listColumnDefs.add(new ColumnDef("근태_총근무시간", Dlgn0100BM.ATTR_DILNLAZTOTDUTYTM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
		listColumnDefs.add(new ColumnDef("근태_유급휴가일수", Dlgn0100BM.ATTR_DILNLAZPAIDHODYNUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
		listColumnDefs.add(new ColumnDef("근태_교통보조비일수", Dlgn0100BM.ATTR_DILNLAZTFCASSCSTNUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Dlgn0100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근태_급식비일수 : dilnlazLnchDys */
		listColumnDefs.add(new ColumnDef("근태_급식비일수", Dlgn0100BM.ATTR_DILNLAZLNCHDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		
		//private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
		//
		//private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
		//
		//private TextField<String> dilnlazYrMnth;   /** column 근태년월 : dilnlazYrMnth */
		//
		//private TextField<String> payCd;   /** column 급여구분코드 : payCd */
		//
		//private TextField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
		//
		//private TextField<String> deptCd;   /** column 부서코드 : deptCd */
		//
		//private TextField<String> businCd;   /** column 사업코드 : businCd */
		//
		//private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
		//
		//private TextField<String> dtilOccuClsDivCd;   /** column 직종세구분코드 : dtilOccuClsDivCd */
		//
		//private TextField<String> dilnlazDutyBgnnDt;   /** column 근태_근무시작일자 : dilnlazDutyBgnnDt */
		//
		//private TextField<String> dilnlazDutyEndDt;   /** column 근태_근무종료일자 : dilnlazDutyEndDt */
		//
		//private TextField<String> dilnlazDutyNumDys;   /** column 근태_근무일수 : dilnlazDutyNumDys */
		//
		//private TextField<String> dilnlazLvsgNumDys;   /** column 근태_연가일수 : dilnlazLvsgNumDys */
		//
		//private TextField<String> dilnlazAbnceNumDys;   /** column 근태_결근일수 : dilnlazAbnceNumDys */
		//
		//private TextField<String> dilnlazSckleaNumDys;   /** column 근태_병가일수 : dilnlazSckleaNumDys */
		//
		//private TextField<String> dilnlazOffvaNumDys;   /** column 근태_공가일수 : dilnlazOffvaNumDys */
		//
		//private TextField<String> dilnlazFmlyEvntNumDys;   /** column 근태_경조사일수 : dilnlazFmlyEvntNumDys */
		//
		//private TextField<String> dilnlazHlthCreNumDys;   /** column 근태_보건일수 : dilnlazHlthCreNumDys */
		//
		//private TextField<String> dilnlazTotDutyNumDys;   /** column 근태_총근무일수 : dilnlazTotDutyNumDys */
		//
		//private TextField<String> dilnlazWklyHldyNumDys;   /** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
		//
		//private TextField<String> dilnlazPaidPubcHodyNum;   /** column 근태_유급휴일수 : dilnlazPaidPubcHodyNum */
		//
		//private TextField<String> dilnlazDdlnePrcsYn;   /** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
		//
		//private TextField<String> dilnlazNoteCtnt;   /** column 근태_비고내용 : dilnlazNoteCtnt */
		//
		//private TextField<String> kybdr;   /** column 입력자 : kybdr */
		//
		//private TextField<String> inptDt;   /** column 입력일자 : inptDt */
		//
		//private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
		//
		//private TextField<String> ismt;   /** column 수정자 : ismt */
		//
		//private TextField<String> revnDt;   /** column 수정일자 : revnDt */
		//
		//private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
		//
		//private TextField<String> dilnlazSpclHodyNumDys;   /** column 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
		//
		//private TextField<String> dilnlazSatDutyNumDys;   /** column 총토요근무일수 : dilnlazSatDutyNumDys */
		//
		//private TextField<String> dilnlazPubcHodyDutyNumDys;   /** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
		//
		//private TextField<String> dilnlazAbnceDutyRcgtnDys;   /** column 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
		//
		//private TextField<String> pyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
		//
		//private TextField<String> dilnlazTotDutyTm;   /** column 근태_총근무시간 : dilnlazTotDutyTm */
		//
		//private TextField<String> dilnlazPaidHodyNumDys;   /** column 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
		//
		//private TextField<String> dilnlazTfcAssCstNumDys;   /** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
		//
		//private TextField<String> dtilOccuInttnCd;   /** column 직종세통합코드 : dtilOccuInttnCd */
		//
		//private TextField<String> dilnlazLnchDys;   /** column 근태_급식비일수 : dilnlazLnchDys */

        
        setColumnsDefinition(listColumnDefs);
        
        return listColumnDefs;
    }
}
