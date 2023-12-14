package com.app.exterms.personal.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0400DTO;
import com.app.exterms.personal.client.form.defs.Psnl0110Def;
import com.app.exterms.personal.client.service.Psnl0400Service;
import com.app.exterms.personal.client.service.Psnl0400ServiceAsync;
import com.app.exterms.personal.client.utils.PersonalUtil;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * ==================================================== 
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. 
 * extends MSFPanel -> extends LayoutContainer implements IMSFWindow { 
 * 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Psnl0400 extends MSFPanel {

	/**
	 * ###################################################### 
	 * { 시스템 기본설정파일 선언부 시작} 
	 * #######################################################
	 */
	// -------------- 상단 버튼 시작 --------------
	private ButtonBar topPsnl0400Bar;	
	private Button btnPsnl0400Reset;	//초기화 버튼
	private Button btnPsnl0400Sreach;	//조회 버튼
	private Button btnPsnl0400Issue;	//발급 버튼
	// -------------- 상단 버튼 종료 --------------
	
	// -------------- 검색조건 시작 --------------
	private TextField<String> searchHanNm;		// 성명
	private TextField<String> searchResnRegnNum;// 주민번호
	private HiddenField<String >srhSystemkey;	// 시스템키 
	private HiddenField<String >srhHdofcCodtnCd;// 재직구분 
	
	// -------------- 검색조건 종료 --------------

	// -------------- 발급정보 시작 --------------
//	private RadioGroup printType;				//증명서선택
	private RadioGroup outputTypeRadiogroup;	//증명서선택
	private MSFTextField issueNumber; 	//발급번호
	private MSFDateField issueDate; 	//발급일자
	private MSFTextField addr; 			//주소
	private MSFTextField dept; 			//부서
	private MSFTextField currDept; 		//소속
	private MSFTextField businNm; 		//사업명
	private MSFTextField emymtDivCdNm; 	//고용구분
	private MSFTextField typOccuCdNm; 	//직종
	private MSFTextField dtlTypOccuNm; 	//직종세
	private MSFTextField printCnt; 		//매수
	private MSFTextField issueUseType; 	//용도
//    private CheckBox emymtHistoryYn;	//고용이력포함여부
	private MSFTextField issueCompany; 	//발급기관
	private MSFTextField retryReasCtnt;	//퇴직사유
	private String hiddenDpobCd;
	private String hiddenSystemkey;
	// -------------- 발급정보 종료 --------------
	
	// -------------- grid 선언 시작  ---------------
	private Psnl0110Def psnl0110Def  = new Psnl0110Def("PSNL0400");   //그리드 테이블 컬럼 define  
	private MSFGridPanel psnl0400GridPanel;
    private Iterator<Record> records;
	// -------------- grid 선언 종료  ---------------
	
	// -------------- 경력정보 시작 --------------
//	private Grid<Psnl0400DTO> psnl0400Grid;
	private Psnl0400ServiceAsync psnl0400Service = Psnl0400Service.Util.getInstance();
//	private RpcProxy<BaseListLoadResult<Psnl0400DTO>> psnl0400Proxy = new RpcProxy<BaseListLoadResult<Psnl0400DTO>>() {
//		@Override
//		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0400DTO>> callback) {
//			
//			Psnl0400DTO dto = new Psnl0400DTO();
//			dto.setDpobCd(((BaseListLoadConfig)loadConfig).get("dpobCd")+"");
//			dto.setSystemkey(((BaseListLoadConfig)loadConfig).get("systemkey")+"");
//			try{
//				psnl0400Service.selectExperience((BaseListLoadConfig) loadConfig,	dto, callback);
//				
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//		}
//	};
//	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0400Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0400Proxy);
//	private ListStore<Psnl0400DTO> psnl0400Store = new ListStore<Psnl0400DTO>(psnl0400Loader);
	// -------------- 경력정보 종료 --------------
	
	/**
	 * ###################################################### 
	 * { 시스템 기본설정파일 선언부 종료} 
	 * #######################################################
	 */

	private VerticalPanel vp;
	private FormPanel plFrmPsnl0400;
	private FormData formData;
	@SuppressWarnings("unused")
	private String txtForm = "";
	
	private CheckBoxSelectionModel<Psnl0400DTO> sm;

	final TabPanel tabsPsnl = new TabPanel(); // 인사탭정보설정을 위한 tab

	// @Override
	// protected void onRender(Element parent, int index) {
	// super.onRender(parent, index);
	//
	// formData = new FormData("-650");
	// vp = new VerticalPanel();
	// vp.setSpacing(10);
	// createPsnl0100Form(); //화면 기본정보를 설정
	// createSearchForm(); //검색필드를 적용
	// createDetailForm(); //
	// createCheckBoxGrid(); //기본정보필드
	// add(vp);
	// vp.setSize("1010px", "700px");
	// }
	
	//코드 데이터 세팅
	public ContentPanel getViewPanel() {
		if (panel == null) {
			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createPsnl0400Form();	//화면 기본정보를 설정
			createSearchForm(); 	//검색필드를 적용
			createDetailForm(); 	//
			createCheckBoxGrid(); 	//기본정보필드
			//엣지변환
			//vp.setSize("1010px", "700px");
			vp.setSize("1010px", "750px");

			panel = new ContentPanel();
			panel.setBodyBorder(false);
			panel.setBorders(false);
			panel.setHeaderVisible(false);
			panel.add(vp);
		}
		return panel;
	}

	/**
	 * @wbp.parser.constructor
	 */
	public Psnl0400() {
		//엣지변환
		//setSize("1010px", "700px");
		setSize("1010px", "750px");
	}

	public Psnl0400(String txtForm) {
		this.txtForm = txtForm;
	}

	private void createPsnl0400Form() {

		plFrmPsnl0400 = new FormPanel();
		plFrmPsnl0400.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 증명서발급"));
		plFrmPsnl0400.setIcon(MSFMainApp.ICONS.text());
		plFrmPsnl0400.setBodyStyleName("pad-text");
		plFrmPsnl0400.setFrame(true);
		plFrmPsnl0400.setPadding(2);
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("증명서발급","PSNL0400");
				}
			});
		plFrmPsnl0400.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPsnl0400.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

//		ButtonBar buttonBar = new ButtonBar();
		topPsnl0400Bar = new ButtonBar();
		topPsnl0400Bar.setAlignment(HorizontalAlignment.RIGHT);
		// buttonBar.add(new Button("신규", new SelectionListener<ButtonEvent>() {
		// public void componentSelected(ButtonEvent ce) {
		//
		// }
		// }));
		// buttonBar.add(new Button("저장", new SelectionListener<ButtonEvent>() {
		// public void componentSelected(ButtonEvent ce) {
		//
		// }
		// }));

//		Button topBtn = new Button("초기화");
		btnPsnl0400Reset = new Button("초기화");
		btnPsnl0400Reset.setIcon(MSFMainApp.ICONS.new16());
		btnPsnl0400Reset.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//storePaging.insert(new Psnl0100DTO(), 0);
				
				psnl0400GridPanel.getMsfGrid().clearData();
				
				//그리드 선택 없애기
//				psnl0400Grid.getSelectionModel().deselectAll();
//				psnl0400Grid.getStore().removeAll();
				
				//폼 초기화
				resetPsnl0400Form();
			}
		});
		topPsnl0400Bar.add(btnPsnl0400Reset);
		

		btnPsnl0400Sreach = new Button("조회");
		btnPsnl0400Sreach.setIcon(MSFMainApp.ICONS.search16());
		btnPsnl0400Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				String searchName = searchHanNm.getValue() == null ? "" : searchHanNm.getValue().trim();
				String searchResn = searchResnRegnNum.getValue() == null ? "" : searchResnRegnNum.getValue().trim();
				
				if("".equals(searchName) && "".equals(searchResn) ){
					MessageBox.info("", "성명 또는 주민등록번호는 필수입니다.", null);
				}else {
					if("".equals(srhSystemkey.getValue()) || srhSystemkey.getValue() == null) {
						fnPopupPsnl0100();
						return;
					}
					
					if("".equals(srhSystemkey.getValue()) || srhSystemkey.getValue() == null) {
						MessageBox.info("", "대상자를 선택해주세요.", null);
						return;
					}
					
					Psnl0400DTO dto = new Psnl0400DTO();
					
					dto.setHanNm(searchHanNm.getValue());
					dto.setResnRegnNum(searchResnRegnNum.getValue());
					
					searchPsnl0400Form(dto);
				}	
//					psnl0400Service.selectExperienceMain(dto, new AsyncCallback<List<Psnl0400DTO>>() {
//						
//						@Override
//						public void onSuccess(List<Psnl0400DTO> result) {
//							if(result != null && result.size()> 0){
//								addr.setValue(result.get(0).getAddr());
//								dept.setValue(result.get(0).getDeptCd());
//								currDept.setValue(result.get(0).getCurrAffnDeptCd());
//								businNm.setValue(result.get(0).getBusinCd());
//								emymtDivCdNm.setValue(result.get(0).getEmymtDivCd());
//								typOccuCdNm.setValue(result.get(0).getTypOccuCd());
//								dtlTypOccuNm.setValue(result.get(0).getDtilOccuInttnCd());
//								retryReasCtnt.setValue(result.get(0).getRetryReasCtnt());
//								BaseListLoadConfig config = new BaseListLoadConfig();
//								config.set("dpobCd", result.get(0).getDpobCd());
//								config.set("systemkey", result.get(0).getSystemkey());
//								
//								hiddenDpobCd = result.get(0).getDpobCd();
//								hiddenSystemkey = result.get(0).getSystemkey();
//								
//								psnl0400Loader.load(config);
//							}else{
//								addr.setValue("");
//								dept.setValue("");
//								currDept.setValue("");
//								businNm.setValue("");
//								emymtDivCdNm.setValue("");
//								typOccuCdNm.setValue("");
//								dtlTypOccuNm.setValue("");
//								retryReasCtnt.setValue("");
//								//hiddenDpobCd = "";
//								hiddenSystemkey = "";
//							}
//						}
//						
//						@Override
//						public void onFailure(Throwable caught) {
//							MessageBox.alert("", "조회 에러", null);
//						}
//					});
			}
		});
		topPsnl0400Bar.add(btnPsnl0400Sreach);

		btnPsnl0400Issue = new Button("발급", psnl0400ButtonListener);
		btnPsnl0400Issue.setIcon(MSFMainApp.ICONS.print16());
		
		/**
		btnPsnl0400Issue.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				String boxName = "";
				for(int i = 0; i < printType.getAll().size(); i++){
					Radio radio = (Radio)printType.getAll().get(i);
					if(radio.getValue()){
						boxName = radio.getBoxLabel();
						break;
					}
				}
				MessageBox.confirm("발급", boxName+"를 발급 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						if("Yes".equals(be.getButtonClicked().getText())){
							
							Psnl0400DTO dto = new Psnl0400DTO();
							dto.setDpobCd(hiddenDpobCd);
							dto.setSystemkey(hiddenSystemkey);
							dto.setCertcIssDt(PersonalUtil.getConvertDateToString(issueDate,"yyyyMMdd"));
							dto.setIssNumCpis(printCnt.getValue());
							dto.setIssPrpseCtnt(issueUseType.getValue());
							dto.setIssIstutNm(issueCompany.getValue());
							dto.setRetryReasCtnt(retryReasCtnt.getValue());
							dto.setIssCodtnDivCd("A0390002"); //발급코드
							dto.setIssYn("Y");
							dto.setCertcIssDelYn("N");
							if(PersonalUtil.getCheckedRadioValue(printType).equals("PSNLT0400")){ // 재직증명서일경우
								dto.setCertcDivCd("A0380010");
							}else if(PersonalUtil.getCheckedRadioValue(printType).equals("PSNLT0410")){ //경력증명서
								dto.setCertcDivCd("A0380020");
							}else{
								dto.setCertcDivCd("A0380030");
							}
							
							//재직증명서가 아닐경우에 항목을 선택하지 않았을경우
							if(PersonalUtil.getCheckedRadioValue(printType).equals("PSNLT0410")){
								if(psnl0400Grid.getSelectionModel().getSelectedItems().size() <= 0){
									MessageBox.info("", "발급 받으실 항목을 선택하여 주세요.", null);
									return;
								}
							}
							//대상자를선택하지 않은경우 
							if(MSFSharedUtils.paramNull(hiddenSystemkey)) { 
									MessageBox.info("", "발급 대상자를 선택하여 주세요.", null);
									return; 
							}
							
							
							//발급정보 등록하기
							psnl0400Service.insertIssueData(dto, new AsyncCallback<String>() {
								@Override
								public void onSuccess(String result) {
									//result <--발급번호 리턴
									// 재직증명서, 근무사실확인서는 체크 항목 없음, 경력증명서는 선택한 경력만 출력되게끔 파라미터 추가
									String strParam = "/rp ["+hiddenDpobCd+"]["+hiddenSystemkey+"]["+result+"]";
									
									if(PersonalUtil.getCheckedRadioValue(printType).equals("PSNLT0410")){
										String checkedEmymtSeilNumKeys = "";
										String chkkey = "";
										for(final Psnl0400DTO dto : psnl0400Grid.getSelectionModel().getSelectedItems()){
											chkkey += "'"+dto.getEmymtSeilNum()+"',";
										}
										checkedEmymtSeilNumKeys = chkkey.substring(0,chkkey.length()-1);
										strParam += "["+checkedEmymtSeilNumKeys+"]";
									}
									strParam += " /rprnn ["+printCnt.getValue()+"]";
									
									PrintUtils.setPostCall(true);
									PrintUtils.rdaPrint("PSNL", PersonalUtil.getCheckedRadioValue(printType)+".mrd", strParam);
									
								}
								
								@Override
								public void onFailure(Throwable caught) {
									caught.printStackTrace();
									MessageBox.info("", "발급정보 등록오류", null);
								}
							});
						}
					}
				});
			}
		});
		*/
		/**
		btnPsnl0400Issue.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				String boxName = "";
				for(int i = 0; i < outputTypeRadiogroup.getAll().size(); i++){
					Radio radio = (Radio)outputTypeRadiogroup.getAll().get(i);
					if(radio.getValue()){
						boxName = radio.getBoxLabel();
						break;
					}
				}
				MessageBox.confirm("발급", boxName+"를 발급 하시겠습니까?", new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						if("Yes".equals(be.getButtonClicked().getText())){
							
							Psnl0400DTO dto = new Psnl0400DTO();
							dto.setDpobCd(hiddenDpobCd);
							dto.setSystemkey(hiddenSystemkey);
							dto.setCertcIssDt(PersonalUtil.getConvertDateToString(issueDate,"yyyyMMdd"));
							dto.setIssNumCpis(printCnt.getValue());
							dto.setIssPrpseCtnt(issueUseType.getValue());
							dto.setIssIstutNm(issueCompany.getValue());
							dto.setRetryReasCtnt(retryReasCtnt.getValue());
							dto.setIssCodtnDivCd("A0390002"); //발급코드
							dto.setIssYn("Y");
							dto.setCertcIssDelYn("N");
							if(PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup).equals("PSNLT0400")){ // 재직증명서일경우
								dto.setCertcDivCd("A0380010");
							}else if(PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup).equals("PSNLT0410")){ //경력증명서
								dto.setCertcDivCd("A0380020");
							}else{
								dto.setCertcDivCd("A0380030");
							}
							
							//재직증명서가 아닐경우에 항목을 선택하지 않았을경우
							if(PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup).equals("PSNLT0410")){
								if(psnl0400Grid.getSelectionModel().getSelectedItems().size() <= 0){
									MessageBox.info("", "발급 받으실 항목을 선택하여 주세요.", null);
									return;
								}
							}
							//대상자를선택하지 않은경우 
							if(MSFSharedUtils.paramNull(hiddenSystemkey)) { 
									MessageBox.info("", "발급 대상자를 선택하여 주세요.", null);
									return; 
							}
							
							//발급정보 등록하기
							psnl0400Service.insertIssueData(dto, new AsyncCallback<String>() {
								@Override
								public void onSuccess(String result) {
									//result <--발급번호 리턴
									// 재직증명서, 근무사실확인서는 체크 항목 없음, 경력증명서는 선택한 경력만 출력되게끔 파라미터 추가
									String strParam = ""+hiddenDpobCd+"⊥"+hiddenSystemkey+"⊥"+result+"⊥";
									
									if(PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup).equals("PSNLT0410")){
										String checkedEmymtSeilNumKeys = "";
										String chkkey = "";
										for(final Psnl0400DTO dto : psnl0400Grid.getSelectionModel().getSelectedItems()){
											chkkey += "'"+dto.getEmymtSeilNum()+"',";
										}
										checkedEmymtSeilNumKeys = chkkey.substring(0,chkkey.length()-1);
										strParam += ""+checkedEmymtSeilNumKeys+"⊥";
									}
									strParam += ""+printCnt.getValue()+"⊥";
									
									PrintUtils.setPostCall(true);
									PrintUtils.rexPrint("PSNL", PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup)+".reb", strParam);
								}
								
								@Override
								public void onFailure(Throwable caught) {
									caught.printStackTrace();
									MessageBox.info("", "발급정보 등록오류", null);
								}
							});
						}
					}
				});
			}
		});
		*/
		topPsnl0400Bar.add(btnPsnl0400Issue);

		plFrmPsnl0400.add(topPsnl0400Bar);

		vp.add(plFrmPsnl0400);
		//엣지변환
		//plFrmPsnl0400.setSize("990px", "690px");
		plFrmPsnl0400.setSize("990px", "740px");
	}
	
	private SelectionListener<ButtonEvent> psnl0400ButtonListener = new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			
			
			if(PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup).equals("PSNLT0400")
					&& (srhHdofcCodtnCd.getValue() == "A0030020" || "A0030020".equals(srhHdofcCodtnCd.getValue()) )  ) { // 재직증명서일경우
				
				MessageBox.info("경고", "퇴직자의 경우 재직증명서는 발급되지 않습니다.", null);
				return; 
				
			}else {
				
				String boxName = "";
				
				for(int i = 0; i < outputTypeRadiogroup.getAll().size(); i++){
					Radio radio = (Radio)outputTypeRadiogroup.getAll().get(i);
					if(radio.getValue()){
						boxName = radio.getBoxLabel();
						break;
					}
				}
				
				MessageBox.confirm("발급", boxName+"를 발급 하시겠습니까?", new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							String printType = PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup);
							Psnl0400Print(printType, MSFMainApp.getMsg("PayGen.ReportDivisionType"));
						}
					}
				});
				
			}
		}
	};	
	
//	private SelectionListener<ButtonEvent> psnl0400ButtonListener = new SelectionListener<ButtonEvent>() {
//		public void componentSelected(ButtonEvent ce) {
//			String boxName = "";
//			for(int i = 0; i < outputTypeRadiogroup.getAll().size(); i++){
//				Radio radio = (Radio)outputTypeRadiogroup.getAll().get(i);
//				if(radio.getValue()){
//					boxName = radio.getBoxLabel();
//					break;
//				}
//			}
//			
//			MessageBox.confirm("발급", boxName + "를 발급 하시겠습니까?", new Listener<MessageBoxEvent>(){
//				@Override
//				public void handleEvent(MessageBoxEvent be) {
//					if("Yes".equals(be.getButtonClicked().getText())){
//						Psnl0400DTO dto = new Psnl0400DTO();
//						dto.setDpobCd(hiddenDpobCd);
//						dto.setSystemkey(hiddenSystemkey);
//						dto.setCertcIssDt(PersonalUtil.getConvertDateToString(issueDate,"yyyyMMdd"));
//						dto.setIssNumCpis(printCnt.getValue());
//						dto.setIssPrpseCtnt(issueUseType.getValue());
//						dto.setIssIstutNm(issueCompany.getValue());
//						dto.setRetryReasCtnt(retryReasCtnt.getValue());
//						dto.setIssCodtnDivCd("A0390002"); //발급코드
//						dto.setIssYn("Y");
//						dto.setCertcIssDelYn("N");
//						if(PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup).equals("PSNLT0400")){ // 재직증명서일경우
//							dto.setCertcDivCd("A0380010");
//						}else if(PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup).equals("PSNLT0410")){ //경력증명서
//							dto.setCertcDivCd("A0380020");
//						}else{
//							dto.setCertcDivCd("A0380030");
//						}
//						
//						//재직증명서가 아닐경우에 항목을 선택하지 않았을경우
//						if(PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup).equals("PSNLT0410")){
//							if(psnl0400Grid.getSelectionModel().getSelectedItems().size() <= 0){
//								MessageBox.info("", "발급 받으실 항목을 선택하여 주세요.", null);
//								return;
//							}
//						}
//						//대상자를선택하지 않은경우 
//						if(MSFSharedUtils.paramNull(hiddenSystemkey)) { 
//								MessageBox.info("", "발급 대상자를 선택하여 주세요.", null);
//								return; 
//						}
//						String printType = PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup);
//						Psnl0400Print(printType, MSFMainApp.getMsg("PayGen.ReportDivisionType"));
//		}
//	};
	
	
	//경력정보 
	private void createCheckBoxGrid() {
		
//		RowNumberer r = new RowNumberer();
//
//		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//		configs.add(r);
//
////		final CheckBoxSelectionModel<Psnl0400DTO> sm = new CheckBoxSelectionModel<Psnl0400DTO>();
//		
//		sm = new CheckBoxSelectionModel<Psnl0400DTO>();
//		sm.setSelectionMode(SelectionMode.MULTI);
//
//		configs.add(sm.getColumn());
//
//		ColumnConfig column = new ColumnConfig();
//		column.setId("emymtBgnnDt");
//		column.setHeaderText("근무시작일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("emymtEndDt");
//		column.setHeaderText("근무종료일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("childEmymtDivCd");
//		column.setHeaderText("고용구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(200);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("childDeptCd");
//		column.setHeaderText("부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(120);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//		
//		column = new ColumnConfig();
//		column.setId("childBusinCd");
//		column.setHeaderText("사업명");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(120);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//		
//		column = new ColumnConfig();
//		column.setId("typOccuCd");
//		column.setHeaderText("직종명");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(120);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//		
//		column = new ColumnConfig();
//		column.setId("dtilOccuInttnCd");
//		column.setHeaderText("직종세명");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(120);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//		
//		ColumnModel cm = new ColumnModel(configs);
//
//		/*ContentPanel cp = new ContentPanel();
//		cp.setHeaderVisible(false);
//		cp.setFrame(true);
//		cp.setIcon(MSFMainApp.ICONS.table());
//		cp.setLayout(new FitLayout());
//		cp.setSize(600, 150);
//*/
//		
//		
//		psnl0400Grid = new Grid<Psnl0400DTO>(psnl0400Store, cm);
//		psnl0400Grid.setStateId("psnl0400Grid");
//		psnl0400Grid.setStateful(false);
//		psnl0400Grid.setLoadMask(true); // 작업중표시
//		psnl0400Grid.setBorders(true);
//		psnl0400Grid.setSelectionModel(sm);
//		psnl0400Grid.addPlugin(sm);
//		psnl0400Grid.setColumnResize(true);
//		
//		
//		FieldSet fieldSet = new FieldSet();
//		fieldSet.setHeadingHtml("경력정보");
//
//		LayoutContainer lcStdGrid = new LayoutContainer();
//		lcStdGrid.setStyleAttribute("paddingRight", "10px");
//		lcStdGrid.setStyleAttribute("paddingLeft", "10px");
//		
//		FormLayout frmlytStd = new FormLayout();
//		// frmlytStd.setLabelWidth(85);
//		// frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		lcStdGrid.setLayout(frmlytStd);
//
//		ContentPanel cpGrid = new ContentPanel();
//		cpGrid.setBodyBorder(false);
//		cpGrid.setHeaderVisible(false);
//		cpGrid.setLayout(new FitLayout());
////		cpGrid.setSize(935, 200);
//		cpGrid.setSize("945px", "310px");
//
//		cpGrid.add(psnl0400Grid);
//		lcStdGrid.add(cpGrid);
//		fieldSet.add(lcStdGrid);
		
		
		FieldSet fieldSetGrd = new FieldSet();  
		fieldSetGrd.setHeadingHtml("경력정보");
		    
		LayoutContainer lcStdGrid = new LayoutContainer();
		lcStdGrid.setStyleAttribute("paddingLeft", "5px");
		lcStdGrid.setStyleAttribute("paddingRight", "5px");
		FormLayout frmlytStd = new FormLayout();  
		lcStdGrid.setLayout(frmlytStd);  
		    
		ContentPanel cpGrid = new ContentPanel();   
		cpGrid.setBodyBorder(false); 
		cpGrid.setHeaderVisible(false);   
		cpGrid.setLayout(new FitLayout());  
		cpGrid.setSize(945, 300);
		    
		psnl0400GridPanel = new MSFGridPanel(psnl0110Def, false, false, false, false, false);
		psnl0400GridPanel.setHeaderVisible(false);  
		psnl0400GridPanel.setBodyBorder(true);
		psnl0400GridPanel.setBorders(true);
		final Grid psnl0400Grid = psnl0400GridPanel.getMsfGrid().getGrid();
		psnl0400Grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {  
				if (psnl0400GridPanel.getCurrentlySelectedItem() != null) {    
	   			} 
	   		}
		}); 
		cpGrid.add(psnl0400GridPanel); 
	
		lcStdGrid.add(cpGrid);   
		fieldSetGrd.add(lcStdGrid);  

		plFrmPsnl0400.add(fieldSetGrd);

	}

	// TODO 검색조건 시작
	private void createSearchForm() {
		
		srhSystemkey = new HiddenField<String>();
		
		srhHdofcCodtnCd = new HiddenField<String>();
		formData = new FormData("100%");
		// FormPanel panel = new FormPanel();
		// panel.setFrame(true);
		// panel.setHeaderVisible(false);
		// panel.setIcon(MSFMainApp.ICONS.form());
		// panel.setHeadingText("FormPanel");
		// panel.setSize(600, -1);
		// panel.setLabelAlign(LabelAlign.TOP);
		// panel.setButtonAlign(HorizontalAlignment.CENTER);

		// FormPanel form2 = new FormPanel();
		// form2.setFrame(true);
		// form2.setHeadingHtml("Simple Form with FieldSets");
		// form2.setWidth(350);
		plFrmPsnl0400.setLayout(new FlowLayout());

		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
        /****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
		
		// fieldSet.setCheckboxToggle(false);

		LayoutContainer lcSchLeft = new LayoutContainer();
		lcSchLeft.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		// fieldSet.setLayout(layout);
		lcSchLeft.setLayout(frmlytSch);

		LayoutContainer lcSchRight = new LayoutContainer();
		lcSchRight.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSchRight = new FormLayout();
		frmlytSchRight.setLabelWidth(100);
		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight.setLayout(frmlytSchRight);

		searchHanNm = new TextField<String>();
		searchHanNm.setFieldLabel("성 명");
		//searchHanNm.setAllowBlank(false);
		searchHanNm.addKeyListener(new KeyListener(){
			@Override
			public void componentKeyDown(ComponentEvent event) {
				if(event.getKeyCode() == KeyCodes.KEY_ENTER){
					searchHanNm.validate();
					fnPopupPsnl0100();
				}
			}
		});
//		searchHanNm.addKeyListener(new KeyListener() {
//            public void componentKeyUp(ComponentEvent event) {
//                super.componentKeyUp(event);
//                searchHanNm.validate();
//                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//                    fnPopupPsnl0100() ;
//                }
//            }
//         });
		lcSchLeft.add(searchHanNm, new FormData("100%"));

		searchResnRegnNum = new TextField<String>();
		searchResnRegnNum.setFieldLabel("주민등록번호");
		lcSchRight.add(searchResnRegnNum, new FormData("50%"));

		// TextField<String> company = new TextField<String>();
		// company.setFieldLabel("주민등록번호");
		// fieldSet.add(company, formData);
		//
		// TextField<String> email = new TextField<String>();
		// email.setFieldLabel("Email");
		// fieldSet.add(email, formData);

		lcSchCol.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcSchCol.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));

		fieldSet.add(lcSchCol, formData);

		plFrmPsnl0400.add(fieldSet);
		// vp.add(panel);
	}
	
	
	// TODO 발급정보 시작
	private void createDetailForm() {
		formData = new FormData("100%");
		
		plFrmPsnl0400.setLayout(new FlowLayout());

		LayoutContainer lcPrtCol = new LayoutContainer();
		lcPrtCol.setStyleAttribute("paddingRight", "20px");
		FormLayout frmlytSch1 = new FormLayout();
		frmlytSch1.setLabelWidth(100);
		frmlytSch1.setLabelAlign(LabelAlign.RIGHT);
		// fieldSet.setLayout(layout);
		lcPrtCol.setLayout(frmlytSch1);

		LayoutContainer lcPrtCol01 = new LayoutContainer();
		lcPrtCol01.setLayout(new ColumnLayout());

		LayoutContainer lcPrtCol02 = new LayoutContainer();
		lcPrtCol02.setLayout(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("발급정보");
		// fieldSet.setCheckboxToggle(false);

		Radio radio = new Radio();
		radio.setBoxLabel("재직증명서");
		radio.setValue(true);
		radio.setValueAttribute("PSNLT0400");//A0380010
		
		Radio radio2 = new Radio();
		radio2.setValueAttribute("PSNLT0410");//A0380020
		radio2.setBoxLabel("경력증명서");
		
		Radio radio4 = new Radio();
		radio4.setValueAttribute("PSNLT0411");//A0380020
		radio4.setBoxLabel("경력증명서(고용상태포함)");
		

		Radio radio3 = new Radio();
		radio3.setValueAttribute("PSNLT0430");//A0380030
		radio3.setBoxLabel("근무사실확인서");

		outputTypeRadiogroup = new RadioGroup();
		outputTypeRadiogroup.setFieldLabel("증명서선택");
		outputTypeRadiogroup.add(radio);
		outputTypeRadiogroup.add(radio2);
		outputTypeRadiogroup.add(radio4);
		outputTypeRadiogroup.add(radio3);
		
		
		LayoutContainer lcSchLeft = new LayoutContainer();
		lcSchLeft.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		// fieldSet.setLayout(layout);
		lcSchLeft.setLayout(frmlytSch);

		LayoutContainer lcSchRight = new LayoutContainer();
		lcSchRight.setStyleAttribute("paddingRight", "0px");
		FormLayout frmlytSchRight = new FormLayout();
		frmlytSchRight.setLabelWidth(100);
		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight.setLayout(frmlytSchRight);

		lcSchLeft.add(outputTypeRadiogroup, new FormData("100%"));

		LabelField company07 = new LabelField();
		lcSchRight.add(company07, new FormData("100%"));
		
		
		issueNumber = new MSFTextField();
		issueNumber.setFieldLabel("발급번호");
		issueNumber.setEmptyText("--발급시 생성--");
		issueNumber.setReadOnly(true);
		//firstName.setAllowBlank(false);
		lcSchLeft.add(issueNumber, new FormData("100%"));

		issueDate = new MSFDateField();
		issueDate.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		issueDate.setFieldLabel("발급일자");
		issueDate.setValue(new Date());
		issueDate.setReadOnly(true);
		lcSchRight.add(issueDate, new FormData("100%"));

		lcPrtCol01.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		lcPrtCol01.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		lcPrtCol.add(lcPrtCol01, formData);

		addr = new MSFTextField();
		addr.setFieldLabel("주소");
		addr.setReadOnly(true);
		lcPrtCol.add(addr, new FormData("100%"));
		
		
		dept = new MSFTextField();
		dept.setReadOnly(true);
		dept.setFieldLabel("부서");
		
		currDept = new MSFTextField();
		currDept.setReadOnly(true);
		currDept.setFieldLabel("소속");
		
		businNm = new MSFTextField();
		businNm.setReadOnly(true);
		businNm.setFieldLabel("사업명");
		
		LayoutContainer lcLeft = new LayoutContainer();
		LayoutContainer lcCenter = new LayoutContainer();
		LayoutContainer lcRight = new LayoutContainer();
		FormLayout flLeft = new FormLayout();flLeft.setLabelWidth(100);flLeft.setLabelAlign(LabelAlign.RIGHT);
		FormLayout flCenter = new FormLayout();flCenter.setLabelWidth(100);flCenter.setLabelAlign(LabelAlign.RIGHT);
		FormLayout flRight = new FormLayout();flRight.setLabelWidth(100);flRight.setLabelAlign(LabelAlign.RIGHT);
		lcLeft.setLayout(flLeft);
		lcCenter.setLayout(flCenter);
		lcRight.setLayout(flRight);
		
		lcLeft.add(dept,new FormData("100%"));
		lcCenter.add(currDept,new FormData("100%"));
		lcRight.add(businNm,new FormData("100%"));
		
		
		LayoutContainer deptlc = new LayoutContainer();
		deptlc.setLayout(new ColumnLayout());
		deptlc.add(lcLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		deptlc.add(lcCenter, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		deptlc.add(lcRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		lcPrtCol.add(deptlc, new FormData("100%"));

		
		emymtDivCdNm = new MSFTextField();
		emymtDivCdNm.setReadOnly(true);
		emymtDivCdNm.setFieldLabel("고용구분");
		
		typOccuCdNm = new MSFTextField();
		typOccuCdNm.setReadOnly(true);
		typOccuCdNm.setFieldLabel("직종");
		
		dtlTypOccuNm = new MSFTextField();
		dtlTypOccuNm.setReadOnly(true);
		dtlTypOccuNm.setFieldLabel("직종세");
		
		
		LayoutContainer lcLeft1 = new LayoutContainer();
		LayoutContainer lcCenter1 = new LayoutContainer();
		LayoutContainer lcRight1 = new LayoutContainer();
		FormLayout flLeft1 = new FormLayout();flLeft1.setLabelWidth(100);flLeft1.setLabelAlign(LabelAlign.RIGHT);
		FormLayout flCenter1 = new FormLayout();flCenter1.setLabelWidth(100);flCenter1.setLabelAlign(LabelAlign.RIGHT);
		FormLayout flRight1 = new FormLayout();flRight1.setLabelWidth(100);flRight1.setLabelAlign(LabelAlign.RIGHT);
		lcLeft1.setLayout(flLeft1);
		lcCenter1.setLayout(flCenter1);
		lcRight1.setLayout(flRight1);
		
		lcLeft1.add(emymtDivCdNm,new FormData("100%"));
		lcCenter1.add(typOccuCdNm,new FormData("100%"));
		lcRight1.add(dtlTypOccuNm,new FormData("100%"));
		
		
		LayoutContainer deptlc1 = new LayoutContainer();
		deptlc1.setLayout(new ColumnLayout());
		deptlc1.add(lcLeft1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		deptlc1.add(lcCenter1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		deptlc1.add(lcRight1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		lcPrtCol.add(deptlc1, new FormData("100%"));

		printCnt = new MSFTextField();
		printCnt.setFieldLabel("매수");
		printCnt.setValue("1");
		lcPrtCol.add(printCnt, new FormData("10%"));
		
//        LayoutContainer layoutContainer_16 = new LayoutContainer(new ColumnLayout());
//        
//        frmlytSch = new FormLayout();  
//        frmlytSch.setLabelWidth(60); 
//        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//        layoutContainer_16.setLayout(frmlytSch);
//        
//        LayoutContainer layoutContainer_16_1 = new LayoutContainer();
//        
//        frmlytSch = new FormLayout();  
//        frmlytSch.setLabelWidth(100); 
//        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//        layoutContainer_16_1.setLayout(frmlytSch);
        
		issueUseType = new MSFTextField();
		issueUseType.setFieldLabel("용도");
		lcPrtCol.add(issueUseType, new FormData("65%"));
		
		
//		layoutContainer_16.add(layoutContainer_16_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
//		
//        LayoutContainer layoutContainer_16_2 = new LayoutContainer();
//        
//        frmlytSch = new FormLayout();  
//        frmlytSch.setLabelWidth(60); 
//        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//        layoutContainer_16_2.setLayout(frmlytSch);
//        
//        emymtHistoryYn = new CheckBox();
//        emymtHistoryYn.setName("emymtHistoryYn");
//        emymtHistoryYn.setBoxLabel("고용이력포함");
//        emymtHistoryYn.setHideLabel(false);
//        layoutContainer_16_2.add(emymtHistoryYn, new FormData("100%"));
//		
//		
//		layoutContainer_16.add(layoutContainer_16_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
        
//        lcPrtCol.add(layoutContainer_16);



		issueCompany = new MSFTextField();
		issueCompany.setFieldLabel("발급기관");
		lcPrtCol.add(issueCompany, new FormData("65%"));

		retryReasCtnt = new MSFTextField();
		retryReasCtnt.setFieldLabel("퇴직사유");
		retryReasCtnt.setReadOnly(true);
		lcPrtCol.add(retryReasCtnt, new FormData("65%"));
		
		fieldSet.add(lcPrtCol, formData);

		plFrmPsnl0400.add(fieldSet);
		// vp.add(panel);
	}
	
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 인쇄 처리를 위해 추가된 부분 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	/**
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     * 	print Service 선언부 시작
     *  rex 추가로 리포트 타입변경
     *  fileName : 출력파일명 
     *  repType : 출력물 타입 RDA -M2SOFT , REX - CLIPSOFT 
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     **/
	private void Psnl0400Print(String fileName, String repType) {
		   if (PayGenConst.REPORT_DIV_TYPE02.equals(repType)) {
			   RdaPrint(fileName);
		   } else  if (PayGenConst.REPORT_DIV_TYPE01.equals(repType)) {
			   RexPrint(fileName);
		   } else {
			   Window.alert("출력 타입 오류(프로퍼티설정확인)!" + repType);
		   }
	    }
	
	
	//rda
	private void RdaPrint(String fileName) {
		
//		// 출력물 디렉토리 패스경로 인사 : PSNL
//		String strDirPath = "PSNL";
//		
//		// mrd 출력물
//		String rdaFileName = fileName+".mrd";
//		
//		// 보낼 파라미터  
//		
//		// 검색조건
//		String serarchParam = "";
		
		Psnl0400DTO dto = new Psnl0400DTO();
		dto.setDpobCd(hiddenDpobCd);
		dto.setSystemkey(hiddenSystemkey);
		dto.setCertcIssDt(PersonalUtil.getConvertDateToString(issueDate,"yyyyMMdd"));
		dto.setIssNumCpis(printCnt.getValue());
		dto.setIssPrpseCtnt(issueUseType.getValue());
		dto.setIssIstutNm(issueCompany.getValue());
		dto.setRetryReasCtnt(retryReasCtnt.getValue());
		dto.setIssCodtnDivCd("A0390002"); //발급코드
		dto.setIssYn("Y");
		dto.setCertcIssDelYn("N");
		if(PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup).equals("PSNLT0400")){ // 재직증명서일경우
			dto.setCertcDivCd("A0380010");
		}else if(PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup).equals("PSNLT0410")){ //경력증명서
			dto.setCertcDivCd("A0380020");
		}else{
			dto.setCertcDivCd("A0380030");
		}
		
		//경력증명서일 경우 항목 체크
		if(PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup).equals("PSNLT0410")){
			
			if(psnl0400GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().size() <= 0){
				MessageBox.info("", "발급 받으실 항목을 선택하여 주세요.", null);
				return;
				
			}
			
//			if(psnl0400Grid.getSelectionModel().getSelectedItems().size() <= 0){
//				MessageBox.info("", "발급 받으실 항목을 선택하여 주세요.", null);
//				return;
//				
//			}
		}
		//대상자를선택하지 않은경우 
		if(MSFSharedUtils.paramNull(hiddenSystemkey)) { 
				MessageBox.info("", "발급 대상자를 선택하여 주세요.", null);
				return; 
		}
		
		
		//발급정보 등록하기
		psnl0400Service.insertIssueData(dto, new AsyncCallback<String>() {
			@Override
			public void onSuccess(String result) {
				
				//도장 출력을 위해 추가 2014-11-06 //$4
		        String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
		        if(MSFSharedUtils.paramNull(myImgUrl)) {
		           // myImgUrl = "http://105.19.10.32:8080";
					//경로오류 출력 
		        }
		        
				//result <--발급번호 리턴
				// 재직증명서, 근무사실확인서는 체크 항목 없음, 경력증명서는 선택한 경력만 출력되게끔 파라미터 추가
				//String strParam = ""+hiddenDpobCd+"⊥"+hiddenSystemkey+"⊥"+result + myImgUrl +"⊥";
		        								//$1				  //$2				   //$3			   
		        String strParam = "/rp [" + hiddenDpobCd + "]["+ hiddenSystemkey + "][" + result + "]";
		        		
				if(PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup).equals("PSNLT0410")){
					String checkedEmymtSeilNumKeys = "";
					String chkkey = "";
//					for(final Psnl0400DTO dto : psnl0400GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().size()){
//						chkkey += "'"+dto.getEmymtSeilNum()+"',";
//					}
					checkedEmymtSeilNumKeys = chkkey.substring(0,chkkey.length()-1);
					strParam += "["+checkedEmymtSeilNumKeys+"]";	//$4
				}
				strParam +=  "["+ myImgUrl+ "]";					//TODO 경력증명서일 경우 $5, 아니면 $4				
				strParam += " /rprnn ["+printCnt.getValue()+"]";
				
				PrintUtils.setPostCall(true);
				PrintUtils.rdaPrint("PSNL", PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup)+".mrd", strParam);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				MessageBox.info("", "발급정보 등록오류", null);
			}
		});
	}

	//rex
	private void RexPrint(String fileName) {
		
		// 출력물 디렉토리 패스경로 인사 : PSNL  //  급여 : PAYR
//		String strDirPath = "PSNL";
//				
//		// reb 출력물
//		String rexFileName = fileName+".reb";
//				
//		// 보낼 파라미터  
//				
//		// 검색조건
//		String serarchParam = "";
		
		final Psnl0400DTO dto = new Psnl0400DTO();
		dto.setDpobCd(hiddenDpobCd);			
		dto.setSystemkey(hiddenSystemkey);
		dto.setCertcIssDt(PersonalUtil.getConvertDateToString(issueDate,"yyyyMMdd"));
		dto.setIssNumCpis(printCnt.getValue());
		
		
//		// 고용이력 포함 시 해당 발급 이력을 함께 남긴다.
//		// 용도 | 고용이력포함
//		if("Y".equals(emymtHistoryYn)) {
//			dto.setIssPrpseCtnt(issueUseType.getValue() + " | 고용이력포함");
//		}else {
//			dto.setIssPrpseCtnt(issueUseType.getValue());
//		}
		
		dto.setIssPrpseCtnt(MSFSharedUtils.allowNulls(issueUseType.getValue()));
		dto.setIssIstutNm(MSFSharedUtils.allowNulls(issueCompany.getValue()));
		dto.setRetryReasCtnt(MSFSharedUtils.allowNulls(retryReasCtnt.getValue()));
		dto.setIssCodtnDivCd("A0390002"); //발급코드
		dto.setIssYn("Y");
		dto.setCertcIssDelYn("N");
		if(PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup).equals("PSNLT0400")){ // 재직증명서일경우
			dto.setCertcDivCd("A0380010");
		}else if(PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup).equals("PSNLT0410")){ //경력증명서
			dto.setCertcDivCd("A0380020");
		}else if(PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup).equals("PSNLT0411")){ //경력증명서(고용이력포함)
			
			dto.setIssPrpseCtnt(MSFSharedUtils.allowNulls(issueUseType.getValue()) + " (고용상태포함)");
			dto.setCertcDivCd("A0380020");
			
		}else{
			dto.setCertcDivCd("A0380030");
		}
		
		//경력증명서일 경우 항목 체크 -> 2017.01.13 안양으로 인해 재직, 경력, 근무 구분 없이 전체다 경력정보 선택해서 발급하게끔 반영.
//		if(PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup).equals("PSNLT0410")){
//			if(psnl0400Grid.getSelectionModel().getSelectedItems().size() <= 0){
//				MessageBox.info("", "발급 받으실 항목을 선택하여 주세요.", null);
//				return;
//			}
		
			if(psnl0400GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().size() <= 0){
				MessageBox.info("", "발급 받으실 항목을 선택하여 주세요.", null);
				return;
			}
		
//			
			
//		}
		//대상자를선택하지 않은경우 
		if(MSFSharedUtils.paramNull(hiddenSystemkey)) { 
			MessageBox.info("", "발급 대상자를 선택하여 주세요.", null);
			return; 
		}
		
		//발급정보 등록하기
		psnl0400Service.insertIssueData(dto, new AsyncCallback<String>() {
			@Override
			public void onSuccess(String result) {
				//result <--발급번호 리턴
				// 재직증명서, 근무사실확인서는 체크 항목 없음, 경력증명서는 선택한 경력만 출력되게끔 파라미터 추가
				
				//도장 출력을 위해 추가 2014-11-06 //$4
		        String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
		        if(MSFSharedUtils.paramNull(myImgUrl)) {
		           // myImgUrl = "http://105.19.10.32:8080";
					//경로오류 출력 
		        }
		        						   //$1				     //$2				  //$3				
				String strParam = "" + hiddenDpobCd + "⊥" + hiddenSystemkey + "⊥" + result + "⊥";
				String checkedEmymtSeilNumKeys = "";
				String chkkey = "";
				
				Iterator<BaseModel> itBm  = psnl0400GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
                List<Record>  lsRec  = new ArrayList<Record>();
                
                while(itBm.hasNext()) {
                	Record rec  = new Record(itBm.next()); 
                    lsRec.add(rec);
                } 
                setListRecord(lsRec.iterator()); 
                
                if (MSFSharedUtils.paramNotNull(records)) { 
                	while (records.hasNext()) {
                        
        				Record record = (Record) records.next(); 
                        BaseModel bmMapModel = (BaseModel)record.getModel();
                        dto.setEmymtSeilNum( ((Long)bmMapModel.get("emymtSeilNum")).toString());
                        chkkey += "'"+dto.getEmymtSeilNum()+"',";
                        
                	}
                	
                	
                }
				
				
//				for(Psnl0400DTO dto : psnl0400Grid.getSelectionModel().getSelectedItems()){
//					chkkey += "'"+dto.getEmymtSeilNum()+"',";
//				}
				checkedEmymtSeilNumKeys = chkkey.substring(0,chkkey.length()-1);
				strParam += ""+checkedEmymtSeilNumKeys+"⊥";
				
//				if(PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup).equals("PSNLT0410")){
//					String checkedEmymtSeilNumKeys = "";
//					String chkkey = "";
//					for(final Psnl0400DTO dto : psnl0400Grid.getSelectionModel().getSelectedItems()){
//						chkkey += "'"+dto.getEmymtSeilNum()+"',";
//					}
//					checkedEmymtSeilNumKeys = chkkey.substring(0,chkkey.length()-1);
//					strParam += ""+checkedEmymtSeilNumKeys+"⊥";	//TODO REX에서는 checkedEmymtSeilNumKeys 파라미터 안쓰게끔 되있어서 RED랑 똑같이 사용하게끔 수정
//				}
				strParam +=  ""+ myImgUrl+ "⊥";					//TODO 경력증명서일 경우 $5, 아니면 $4		
				strParam += ""+printCnt.getValue()+"⊥";
				
				
				PrintUtils.setPostCall(true);
				PrintUtils.rexPrint("PSNL", PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup)+".crf", strParam);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				MessageBox.info("", "발급정보 등록오류", null);
			}
		});
	}
					
	
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 인쇄 처리를 위해 추가된 부분 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	
	
	//화면 초기화
	public void resetPsnl0400Form() {
		searchHanNm.setValue("");			//성명
		searchResnRegnNum.setValue("");		//주민등록번호
		srhSystemkey.setValue("");			//시스템키
		issueDate.reset();					//발급일자
		addr.setValue("");					//주소
		dept.setValue("");					//부서
		currDept.setValue(""); 				//소속
		businNm.setValue(""); 				//사업명
		emymtDivCdNm.setValue(""); 			//직종
		dtlTypOccuNm.setValue(""); 			//직종세
		printCnt.setValue(""); 				//매수
		issueUseType.setValue(""); 			//용도
		issueCompany.setValue(""); 			//발급기관
		retryReasCtnt.setValue(""); 		//퇴직사유

	}
	
	
	// 조회 
	public void searchPsnl0400Form(Psnl0400DTO dto) {
		psnl0400Service.selectExperienceMain(dto, new AsyncCallback<List<Psnl0400DTO>>() {
			
			@Override
			public void onSuccess(List<Psnl0400DTO> result) {
				if(result != null && result.size()> 0){
					addr.setValue(result.get(0).getAddr());
					dept.setValue(result.get(0).getDeptCd());
					currDept.setValue(result.get(0).getCurrAffnDeptCd());
					businNm.setValue(result.get(0).getBusinCd());
					emymtDivCdNm.setValue(result.get(0).getEmymtDivCd());
					typOccuCdNm.setValue(result.get(0).getTypOccuCd());
					dtlTypOccuNm.setValue(result.get(0).getDtilOccuInttnCd());
					retryReasCtnt.setValue(result.get(0).getRetryReasCtnt());
					BaseListLoadConfig config = new BaseListLoadConfig();
					config.set("dpobCd", result.get(0).getDpobCd());
					config.set("systemkey", result.get(0).getSystemkey());
					
					hiddenDpobCd = result.get(0).getDpobCd();
					hiddenSystemkey = result.get(0).getSystemkey();
					
//					psnl0400Loader.load(config);
					reload();
				}else{
					addr.setValue("");
					dept.setValue("");
					currDept.setValue("");
					businNm.setValue("");
					emymtDivCdNm.setValue("");
					typOccuCdNm.setValue("");
					dtlTypOccuNm.setValue("");
					retryReasCtnt.setValue("");
					//hiddenDpobCd = "";
					hiddenSystemkey = "";
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.alert("", "조회 에러", null);
			}
		});

	}
	
	public void setListRecord(Iterator<Record> records) {
	    this.records = records;
	 } 
	
	
	public void reload() {
		// TODO Auto-generated method stub
		IColumnFilter filters = null;
		psnl0400GridPanel.getTableDef().setTableColumnFilters(filters);
		
		psnl0400GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(hiddenSystemkey), SimpleColumnFilter.OPERATOR_EQUALS);
		
		psnl0400GridPanel.reload();
	}
	
	
	/**
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	* 팝업화면 시작
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	**/
	private void fnPopupPsnl0100() {
	       MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(searchHanNm.getRawValue());  //인사  
	       final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
	      
	       popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
	           public void handleEvent(BaseEvent be) {
	               BaseModel mapModel = (BaseModel)be.getSource();
	               if (!"".equals(mapModel.get("systemkey"))) { 
	            	   srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   		// 시스템키
	            	   searchHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));				// 성명
	            	   searchResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));  // 주민번호 
	            	   srhHdofcCodtnCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("hdofcCodtnCd")));  	// 재직구분 
	               }  
	           }
	       });
	   }
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	


	/************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
	 ************************************************************************/
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 화면별 에러로그 확인 처리 를위해 추가 된 부분....
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : funcLogMessage
	 * @date : 2016. 9. 2.
	 * @author : Administrator
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2016. 9. 2.		Administrator				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param wndName
	 * @param wndId
	 */
	public void funcLogMessage(String wndName, String wndId){
	
		 ShowMessageBM smForm = new ShowMessageBM();
		 smForm.setWindowId(wndId);
		 smForm.setWindowNm(wndName);
		//개별 화면 에러메시지 검색 팝업  
		GWTUtils.funcLogMessage(smForm);
	}  
	/************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
	 ************************************************************************/
 
}
