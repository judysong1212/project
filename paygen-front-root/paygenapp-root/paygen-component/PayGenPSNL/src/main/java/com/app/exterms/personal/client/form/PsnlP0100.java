package com.app.exterms.personal.client.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0120DTO;
import com.app.exterms.personal.client.service.Psnl0100Service;
import com.app.exterms.personal.client.service.Psnl0100ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0120Service;
import com.app.exterms.personal.client.service.Psnl0120ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class PsnlP0100 extends MSFPanel  {
	
	private static Psnl0100ServiceAsync psnl0100Service = Psnl0100Service.Util.getInstance();
	private static Psnl0120ServiceAsync psnl0120Service = Psnl0120Service.Util.getInstance(); 
	private static EditorGrid<Psnl0120DTO> excelGrid;
	
	public static Dialog getExcelUploadForm(){
		Dialog complex = new Dialog();
		complex.setBodyBorder(false);
		//complex.setHeading("교육일괄등록");
		complex.setWidth(800);  
	    complex.setHeight(600);  
	    complex.setHideOnButtonClick(true); 
	    complex.setButtons("저장");
	    
	    
	    BorderLayout layout = new BorderLayout();
	    
	    complex.setLayout(layout); 
	    
	    
	    BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);  
	    
	    ContentPanel panel = new ContentPanel(); 
	    //panel.setHeaderVisible(false);
	    panel.setHeadingText("교육사항 일괄 등록");
	    
	    final FileUploadField excelFile = new FileUploadField(){
	    	// this is to resolve the "fakepath" issue
	    	/*@Override 
	    	protected void onChange(ComponentEvent ce) {
		    	final String fullPath = getFileInput().getValue();
		    	final int lastIndex = fullPath.lastIndexOf('\\');
		    	final String fileName = fullPath.substring(lastIndex + 1);
		    	setValue(fileName);
	    	}*/
	    };
	    excelFile.setTitle("교육사항 일괄 엑셀");
	    excelFile.setFieldLabel("교육사항 일괄 엑셀");
	   // excelFile.setLabelSeparator("ddd");
	    excelFile.setEmptyText("교욱일괄등록 엑셀 파일을 선택하여주세요.");
	    //excelFile.setName("aaaaa");
	    excelFile.setWidth(770);
	    
	    excelFile.addListener(Events.Change, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent e) {
				
				psnl0100Service.getExcelData(String.valueOf(excelFile.getValue()), new AsyncCallback<List<HashMap<String,String>>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert("", "Excel파일이 아니거나 양식이 잘못되었습니다.", null);
					}

					@Override
					public void onSuccess(List<HashMap<String, String>> result) {
						// TODO Auto-generated method stub
						if(result.size() > 0){
							excelGrid.getStore().removeAll();
							//Info.display("REMOVE = excelGrid.getStore().getCount()", excelGrid.getStore().getCount()+"");
							DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat());
							excelGrid.stopEditing(false);
							for(int i = 0; i < result.size(); i++){
								Psnl0120DTO dto = new Psnl0120DTO();
								dto.setRnum(result.get(i).get("rnum"));
								dto.setRrn(result.get(i).get("rrn"));
//								dto.setEduBgnnDt(dateTimeFormat.parse(result.get(i).get("bgnnDt")));
//								dto.setEduEndDt(dateTimeFormat.parse(result.get(i).get("endDt")));
//								dto.setEduCmpteTm(result.get(i).get("cmpteTm"));
								dto.setEduKndNm(result.get(i).get("kndNm"));
								dto.setEduIstutNm(result.get(i).get("istutNm"));
								dto.setEduNoteCtnt(result.get(i).get("noteCtnt"));
								
								excelGrid.getStore().insert(dto, i);
								
								
							}
							excelGrid.getStore().commitChanges();
						}else{
							MessageBox.alert("", "Excel파일이 아니거나 양식이 잘못되었습니다.", null);
							excelFile.setValue("");
						}
					}
				
				});
				
			}
	    });
	    panel.add(excelFile, new BorderLayoutData(LayoutRegion.CENTER));
	    
	    
	    
	 
	    //그리드 작업
	    List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
	    
	    ColumnConfig column = new ColumnConfig();
		column.setId("rnum");
		column.setHeaderText("순번");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(40);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("rrn");
		column.setHeaderText("주민등록번호");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		DateField dateField = new DateField();
		dateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		//dateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
		column = new ColumnConfig();
		column.setId("eduBgnnDt");
		column.setHeaderText("교육시작일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(new CellEditor(dateField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		DateField dateField2 = new DateField();
		dateField2.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		//dateField2.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
		column = new ColumnConfig();
		column.setId("eduEndDt");
		column.setHeaderText("교육종료일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(90);
		column.setEditor(new CellEditor(dateField2));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("eduCmpteTm");
		column.setHeaderText("교육이수시간");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(90);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("eduKndNm");
		column.setHeaderText("교육종류명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(90);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("eduIstutNm");
		column.setHeaderText("교육기관명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(90);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("eduNoteCtnt");
		column.setHeaderText("비고");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setWidth(90);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		
		ColumnModel cm = new ColumnModel(columns);
		excelGrid = new EditorGrid<Psnl0120DTO>(new ListStore<Psnl0120DTO>(), cm);
		excelGrid.setLoadMask(true);
		excelGrid.setBorders(true);
		excelGrid.setStateful(false);
		excelGrid.setAutoExpandColumn("eduNoteCtnt");
		excelGrid.setHeight(485);
		//excelGrid.getView().setAutoFill(true);
		
		panel.add(excelGrid);
		
		Button b = new Button("저장",new SelectionListener<ButtonEvent>() {
			
			@Override
			public void componentSelected(ButtonEvent ce) {
				// TODO Auto-generated method stub
				Info.display("", excelGrid.getStore().getCount()+"");
				ArrayList<Psnl0120DTO> insertPsnl0120List = new ArrayList<Psnl0120DTO>();
				for ( int i = 0; i < excelGrid.getStore().getCount(); i++){
					insertPsnl0120List.add(excelGrid.getStore().getAt(i));
				}
				
				psnl0120Service.insert0120List(insertPsnl0120List, new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						if("0".equals(result)){
							MessageBox.info("저장실패", "교육사항 정보 저장이 실패 하였습니다.", null);
						}else{
							MessageBox.info("저장완료", "교육사항 정보("+result+")가 저장되었습니다.", null);
						}
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.info("저장실패", "교육사항 정보 저장이 실패 하였습니다.", null);
					}
				});
				
			}
		});
		
		panel.addButton(b);
		
		complex.add(panel, data);
		
		return complex;
	}
	
	
}
