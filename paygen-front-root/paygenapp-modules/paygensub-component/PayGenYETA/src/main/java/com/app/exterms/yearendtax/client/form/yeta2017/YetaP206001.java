/**
 * 이전사업이관
 */
package com.app.exterms.yearendtax.client.form.yeta2017;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0120DTO;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.yearendtax.client.dto.yeta2017.Yeta2060DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.Yeta2060Def;
import com.app.exterms.yearendtax.client.service.yeta2017.Yeta2060Service;
import com.app.exterms.yearendtax.client.service.yeta2017.Yeta2060ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * ==================================================== 디자인화면 수정시 extends 부분을
 * 다음과 같이 수정하여 사용한 후 다시 원복한다. extends MSFPanel -> extends LayoutContainer
 * implements IMSFWindow { 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class YetaP206001 extends MSFFormPanel {

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++++++++++
	 **/

	private ContentPanel cpYetaP206001;

	// -------------- grid 선언 시작 ---------------
	private MSFGridPanel YetaP206001_01GridPanel;
	private MSFGridPanel YetaP206001_02GridPanel;

	private Yeta2060Def Yeta206001MtDef = new Yeta2060Def("Yeta206001_Mt");
	private Yeta2060Def Yeta206001StDef = new Yeta2060Def("Yeta206001_St");
	// -------------- grid 선언 종료 ---------------

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 상태처리
	 * 전역변수 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private ActionDatabase actionDatabase;
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 화면
	 * 렌더링 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	public FormBinding formBinding;

	private Iterator<Record> records;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * Button 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 검색변수
	 * 선언 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	// -------------- 검색 조건 시작 --------------
	private HiddenField<String> deptNmStr;		/** column 사업장팝업을 위한 것 : deptNmStr */
	private HiddenField<String> utDpobCd;		/** column 사업장코드 : utDpobCd */
	private HiddenField<String> deptNmHan;		/** column 사업장이름 : deptNmHan */
	private HiddenField<String> befBusoprRgstnNum;		/** column 이전사업자번호 : befBusoprRgstnNum */
	private HiddenField<String> whdgTxCtypDivCd;	/** column 이전사업자번호 : befBusoprRgstnNum */
	// -------------- 검색 조건 종료 --------------

	// -------------- 서비스 호출 시작 --------------
	private Yeta2060ServiceAsync yeta2060Service = Yeta2060Service.Util.getInstance();
	//	private YetaP2060ServiceAsync YetaP206001Service = YetaP206001Service.Util.getInstance();

	// -------------- 서비스 호출 종료 --------------
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 입력
	 * 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */


	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ 전역변수 선언부 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++++++++++
	 **/
	public YetaP206001(final ActionDatabase actionDatabase,	final MSFPanel caller) {

		this.setBodyBorder(false);
		this.setHeaderVisible(false);
		this.setFrame(false);
		this.actionDatabase = actionDatabase;
		this.setBorders(false);
		this.setAutoHeight(true);

		cpYetaP206001 = new ContentPanel();

		createGridForm();

		mReload();
		cpYetaP206001.setBodyBorder(false);
		cpYetaP206001.setBorders(false);
		cpYetaP206001.setHeaderVisible(false);
		cpYetaP206001.setSize("790px", "640px");

		this.add(cpYetaP206001);
		formBinding = new FormBinding(this, true);

		this.setSize("810px", "730px");
	}

	private void createGridForm() {
		deptNmStr = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		deptNmStr.setName("deptNmStr");
		cpYetaP206001.add(deptNmStr);

		utDpobCd = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		utDpobCd.setName("utDpobCd");
		cpYetaP206001.add(utDpobCd);

		deptNmHan = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		deptNmHan.setName("deptNmHan");
		cpYetaP206001.add(deptNmHan);
		
		befBusoprRgstnNum = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		befBusoprRgstnNum.setName("befBusoprRgstnNum");
		cpYetaP206001.add(befBusoprRgstnNum);
		
		whdgTxCtypDivCd = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		whdgTxCtypDivCd.setName("whdgTxCtypDivCd");
		cpYetaP206001.add(whdgTxCtypDivCd);

		LayoutContainer layoutContainer1 = new LayoutContainer();
		layoutContainer1.setLayout(new ColumnLayout());

		FieldSet fieldMtSet = new FieldSet();
		fieldMtSet.setHeadingHtml("주(총괄납부)사업장");
		fieldMtSet.setBorders(true);
		fieldMtSet.setStyleAttribute("paddingLeft", "5px");

		YetaP206001_01GridPanel = new MSFGridPanel(Yeta206001MtDef, false, false, false, false, false);
		YetaP206001_01GridPanel.setHeaderVisible(false);
		YetaP206001_01GridPanel.setSize(305, 570);
		YetaP206001_01GridPanel.setBorders(true);

		final Grid Yeta206001MGrid = YetaP206001_01GridPanel.getMsfGrid().getGrid();
		Yeta206001MGrid.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {  
				if (YetaP206001_01GridPanel.getCurrentlySelectedItem() != null) { 
					BaseModel bmData = YetaP206001_01GridPanel.getCurrentlySelectedItem();
					sReload(bmData);
				}
			}
		}); 	

		fieldMtSet.add(YetaP206001_01GridPanel);

		layoutContainer1.add(fieldMtSet, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		FieldSet fieldStSet = new FieldSet();
		fieldStSet.setHeadingHtml("종(총괄납부)사업장");
		fieldStSet.setBorders(true);
		fieldStSet.setStyleAttribute("paddingLeft", "5px");

		YetaP206001_02GridPanel = new MSFGridPanel(Yeta206001StDef, false, false, false, false, false);
		YetaP206001_02GridPanel.setHeaderVisible(false);
		YetaP206001_02GridPanel.setSize(460, 570);
		YetaP206001_02GridPanel.setBorders(true);
		
		fieldStSet.add(YetaP206001_02GridPanel);

		layoutContainer1.add(fieldStSet, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);
		btnBar.setStyleAttribute("paddingTop", "10px");
		
		Button btnBassDept = new Button("사업장 추가");
		btnBassDept.setWidth(150);
		btnBassDept.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				deptNmStr.setValue("");
				if (YetaP206001_01GridPanel.getCurrentlySelectedItem() == null) { 
					Window.alert("주사업장을 선택해주세요.");
				}
				else {
					fnPopupCommP150(deptNmStr.getValue());
				}
			}

		});

		btnBar.add(btnBassDept);
		
		Button btnBassSave = new Button("저장");
		btnBassSave.setWidth(150);
		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				if (YetaP206001_02GridPanel.getCurrentlySelectedItem() == null) { 
					Window.alert("사업장을 선택해주세요.");
				}
				else {
					UpdateNumBass0120();
				}
			}

		});
		
		btnBar.add(btnBassSave);

		Button btnBassDel = new Button("삭제");
		btnBassDel.setWidth(150);
		btnBassDel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				if (YetaP206001_02GridPanel.getCurrentlySelectedItem() == null) { 
					Window.alert("사업장을 선택해주세요.");
				}
				else {
					Yeta206001_menuDelete();
				}
			}

		});

		btnBar.add(btnBassDel);

		cpYetaP206001.add(layoutContainer1, new FormData("100%"));
		cpYetaP206001.add(btnBar, new FormData("100%"));

	}

	public void mReload() {

		IColumnFilter filters = null;

		YetaP206001_01GridPanel.getTableDef().setTableColumnFilters(filters);
		YetaP206001_01GridPanel.reload();

	}

	public void sReload(BaseModel bmData) {
		IColumnFilter filters = null;

		YetaP206001_02GridPanel.getTableDef().setTableColumnFilters(filters);
		YetaP206001_02GridPanel.getTableDef().addColumnFilter("utDpobCd",MSFSharedUtils.allowNulls(bmData.get("utDpobCd")), SimpleColumnFilter.OPERATOR_LIKE);
		YetaP206001_02GridPanel.reload();

	}

	private void fnPopupCommP150(String deptNmStr) {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		//검색.처리하면됨. 
		
		PrgmComBass0120DTO prgmComBass0120Dto = new PrgmComBass0120DTO();
		prgmComBass0120Dto.setUtDpobNm(deptNmStr);
		
		MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmComPBass120001Form(prgmComBass0120Dto) ;  //부서

		final FormBinding popBindingCom0140 = popCom0140.getFormBinding();

		popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				
				List<BaseModel>  mapModel = (List<BaseModel>) be.getSource();
				
				if (mapModel != null) { 
					Iterator<BaseModel> iterRecords = (Iterator<BaseModel>) mapModel.iterator();
					
					while (iterRecords.hasNext()) {
						
						BaseModel bmMapModel = (BaseModel) iterRecords.next();
						
						utDpobCd.setValue(MSFSharedUtils.allowNulls(bmMapModel.get("utDpobCd")));
						befBusoprRgstnNum.setValue(MSFSharedUtils.allowNulls(bmMapModel.get("busoprRgstnNum")));
						if (YetaP206001_01GridPanel.getCurrentlySelectedItem() != null) { 
							MessageBox.confirm("종사업장 등록", "선택된 사업장의 사업자번호가 주 사업자 번호로 변경됩니다.<br> 진행 하시겠습니까?",new Listener<MessageBoxEvent>(){
								@Override
								public void handleEvent(MessageBoxEvent be) {
									if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
										BaseModel bmData = YetaP206001_01GridPanel.getCurrentlySelectedItem();
										Yeta2060DTO dto = new Yeta2060DTO();
										dto.setUtDpobCd(utDpobCd.getValue());
										dto.setHhrkUntDpobCd(MSFSharedUtils.allowNulls(bmData.get("utDpobCd")));
										dto.setBusoprRgstnNum(MSFSharedUtils.allowNulls(bmData.get("busoprRgstnNum")));
										dto.setBefBusoprRgstnNum(MSFSharedUtils.allowNulls(befBusoprRgstnNum.getValue()));
										
										dto.setWhdgTxRegrstDeptCd(MSFSharedUtils.allowNulls(bmData.get("utDpobCd")));
										
										if (bmData.get("utDpobCd").equals(utDpobCd.getValue())) {
											MessageBox.info("", "같은 사업장은 입력이 불가능합니다.", null);
											return;
										}
										
										if (whdgTxCtypDivCd.getValue().equals("C0040010")) {
											MessageBox.info("", "본점일괄신고는 입력이 불가능합니다.", null);
											return;
										}

										actionDatabase = ActionDatabase.INSERT;
										yeta2060Service.insertYetaS206001(dto, actionDatabase, new AsyncCallback<Integer>() {
											@Override
											public void onSuccess(Integer result) {	
												MessageBox.info("","저장 되었습니다.", null);

												//상세정보 초기화
												YetaP206001_01GridPanel.reload();
												YetaP206001_02GridPanel.getMsfGrid().clearData();
											}

											@Override
											public void onFailure(Throwable caught) {
												caught.printStackTrace();
												MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),
														MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta2060("+ actionDatabase.name()+ ") : "+ caught),null);
											}

										});
									}
								}
							});

						}
						
					}
				}

			}

		});
	}	

	/**
	 * 데이타를 삭제한다.
	 */
	public void Yeta206001_menuDelete() {

		MessageBox.confirm("사업장 삭제", "선택된 사업장을 삭제 하시겠습니까?<br>",new Listener<MessageBoxEvent>(){
			@Override
			public void handleEvent(MessageBoxEvent be) {
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

					Iterator<BaseModel> itBm = YetaP206001_02GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator(); 
					List<Record>  lsRec  = new ArrayList<Record>();
					List<Yeta2060DTO> listYeta2060Dto = new ArrayList<Yeta2060DTO>();       

					while (itBm.hasNext()) {

						Record rec = new Record(itBm.next());
						lsRec.add(rec);

					}

					setListRecord(lsRec.iterator());

					if (MSFSharedUtils.paramNotNull(records)) {   

						while (records.hasNext()) {

							Record record = (Record) records.next(); 
							BaseModel bmMapModel = (BaseModel)record.getModel();

							// select에 null값이 들어가있으므로 널포인트에러뜸.
							// 그래서 null인것은 false로 강제변환시킴.

							Yeta2060DTO dto = new Yeta2060DTO();

							dto.setUtDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("utDpobCd")));    			/** column 사업장코드 : dpobCd */
							dto.setHhrkUntDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("utDpobCd")));
							dto.setBusoprRgstnNum(MSFSharedUtils.allowNulls(bmMapModel.get("befBusoprRgstnNum")));
							dto.setMtstDpobSeilNumC172("");
							dto.setBefBusoprRgstnNum("");
							dto.setMtstDpobSeilNumC172(MSFSharedUtils.allowNulls(bmMapModel.get("mtstDpobSeilNumC172")));
							
							
							if("0000".equals(dto.getMtstDpobSeilNumC172())) {
								MessageBox.info("경고", "주 사업장과 동일한 종 사업장은 삭제 불가합니다. </br> 데이터를 확인해 주세요.", null);
								return;
							}
							
							listYeta2060Dto.add(dto);
						}
					}   


					if(listYeta2060Dto.size() <= 0 ) {
						MessageBox.info("경고", "삭제할 사업장을 선택해 주세요.", null);
						return;
					}

					yeta2060Service.Yeta206001_Delete(listYeta2060Dto, actionDatabase, new AsyncCallback<Long>() {
						@Override
						public void onSuccess(Long result) {
							if (result == 0) {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), "삭제처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
							} else {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "삭제처리가 완료되었습니다.", null);

							}							
							mReload();
							YetaP206001_02GridPanel.getMsfGrid().clearData();
						}

						@Override
						public void onFailure(Throwable caught) {
							caught.printStackTrace();
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),
									MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta2060("+ actionDatabase.name()+ ") : "+ caught),null);
						}
					});

				}
			}
		});
	}
	
	private void UpdateNumBass0120() {
		if (YetaP206001_02GridPanel.getCurrentlySelectedItem() != null) { 
			MessageBox.confirm("주사업자 수정", "선택된 사업장의 일련번호를 변경합니다.<br> 진행 하시겠습니까?",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						
						BaseModel bmData1 = YetaP206001_01GridPanel.getCurrentlySelectedItem();
						
						Iterator<BaseModel> itBm = YetaP206001_02GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator(); 
						List<Record>  lsRec  = new ArrayList<Record>();
						List<Yeta2060DTO> listYeta2060Dto = new ArrayList<Yeta2060DTO>();       

						while (itBm.hasNext()) {

							Record rec = new Record(itBm.next());
							lsRec.add(rec);

						}

						setListRecord(lsRec.iterator());

						if (MSFSharedUtils.paramNotNull(records)) {   

							while (records.hasNext()) {

								Record record = (Record) records.next(); 
								BaseModel bmMapModel = (BaseModel)record.getModel();

								// select에 null값이 들어가있으므로 널포인트에러뜸.
								// 그래서 null인것은 false로 강제변환시킴.

								Yeta2060DTO dto = new Yeta2060DTO();

								dto.setUtDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("utDpobCd")));
								dto.setMtstDpobSeilNumC172(MSFSharedUtils.allowNulls(bmMapModel.get("mtstDpobSeilNumC172")));
								
								listYeta2060Dto.add(dto);
								
								if (bmData1.get("utDpobCd").equals(bmMapModel.get("utDpobCd"))) {
									MessageBox.info("", "주사업장의 일련번호 변경은 불가능합니다.", null);
									return;
								}

							}
						}   

						if(listYeta2060Dto.size() <= 0 ) {
							MessageBox.info("경고", "삭제할 사업장을 선택해 주세요.", null);
							return;
						}

						
						actionDatabase = ActionDatabase.UPDATE;
						yeta2060Service.Yeta206001NumUpdate(listYeta2060Dto, actionDatabase, new AsyncCallback<Long>() {
							@Override
							public void onSuccess(Long result) {	
								MessageBox.info("","저장 되었습니다.", null);

								//상세정보 초기화
								YetaP206001_02GridPanel.reload();
//								YetaP206001_02GridPanel.getMsfGrid().clearData();
							}

							@Override
							public void onFailure(Throwable caught) {
								caught.printStackTrace();
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),
										MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta2060("+ actionDatabase.name()+ ") : "+ caught),null);
							}

						});
					}
				}
			});

		}
	}

	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	}

	public Iterator<Record> getListRecord() {
		return this.records;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onSuccessSave() {
		// TODO Auto-generated method stub

	}

}
