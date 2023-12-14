package com.app.smrmf.sysauth.systemusr.client.utils;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.app.smrmf.core.msfmainapp.client.generics.LovLiveGeneric;
import com.app.smrmf.core.msfmainapp.client.generics.MSFCustomForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFPanelCustomForm;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.infc.sysif.msfpackage.client.form.SysIfP0990;
import com.app.smrmf.syscom.client.form.defs.SsoxUserDef;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;

/**
 * @author cyberlhs
 *
 */
public class SysmUsrUtils {
 
	private static  List<ModelData> mDtalistDeptCd;    			//부서
	/**
	 * Cd 값을 통해 콤보박스를 선택한다. 3번째 인수는 어떤값을 가져올지 코드네임명을 넣는다.
	 * @param comboBoxObj
	 * @param value
	 */
	public static void setSelectedComboValue(ComboBox<BaseModel> comboBoxObj ,String cd, String getX){
		boolean chkCombo = false;
		String commCd = "commCd";
		if(cd != null && !"".equals(cd)){
			commCd = getX == null ? "commCd" : getX;
			for(int i = 0; i < comboBoxObj.getStore().getCount(); i++){
				if( cd.equals(comboBoxObj.getStore().getAt(i).get(commCd))){
					comboBoxObj.setValue(comboBoxObj.getStore().getAt(i));
					chkCombo = true;
					break;
				}
			}
		}
		if(!chkCombo){
			comboBoxObj.setValue(new BaseModel());
		}
	}
	
	/**
	 * commCd 값을 통해 콤보박스를 선택한다. 
	 * @param comboBoxObj
	 * @param value
	 */
	public static void setSelectedComboValue(ComboBox<BaseModel> comboBoxObj ,String commCd){
		boolean chkCombo = false;
		if(commCd != null && !"".equals(commCd)){
			for(int i = 0; i < comboBoxObj.getStore().getCount(); i++){
				if( commCd.equals(comboBoxObj.getStore().getAt(i).get("commCd"))){
					comboBoxObj.setValue(comboBoxObj.getStore().getAt(i));
					chkCombo = true;
					break;
				}
			}
		}
		if(!chkCombo){
			comboBoxObj.setValue(new BaseModel());
		}
	}
	 /**
	  * 부서 멀티 콤보처리 
	  * @param lsDeptCd
	  * @return
	  */
	   public static List<ModelData> getDeptCdModelData(ListStore<BaseModel>  lsDeptCd) {
	        mDtalistDeptCd = new ArrayList<ModelData>();
	       for(int i=0; i< lsDeptCd.getCount(); i++) {
	        ModelData m = new BaseModel();
	        m.set("deptCd", lsDeptCd.getAt(i).get("deptCd"));
	        m.set("deptNmRtchnt", lsDeptCd.getAt(i).get("deptNmRtchnt")); 
	        mDtalistDeptCd.add(m);
	       }
	       return mDtalistDeptCd;
	   }
	   
	   
	   

		/**
		 * 콤보박스의 선택된 Value 값을 리턴한다.
		 * @param comboBoxObj
		 * @param getSelectedText
		 * @return
		 */
		public static String getSelectedComboValue(ComboBox<BaseModel> comboBoxObj){
			String v = "";
			
			if(comboBoxObj != null && comboBoxObj.getValue() != null){
				v = comboBoxObj.getValue().get("commCd") == null ? "" : String.valueOf(comboBoxObj.getValue().get("commCd"));
			}
			
			return v;
		}

		
		
		public static String getSelectedComboValue(ComboBox<BaseModel> comboBoxObj, String getX){
			String v = "";
			if(comboBoxObj != null && comboBoxObj.getValue() != null){
				v = comboBoxObj.getValue().get(getX) == null ? "" : String.valueOf(comboBoxObj.getValue().get(getX));
			}
			return v;
		}
		
	   
	   
	   /**
	    * 임시 사용안함.    
	    * @return
	    */
	    	public static final MSFFormPanel lovPopUpMsfSysComP0990Form(){ 
	    		
	    		Lov lov = null;     
	    		//LovLiveGeneric lovWindow = null; 
	    		final MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new SsoxUserDef(), 1, 0);
	    		MSFCustomForm sysComP0990Form = customForm.getCustomForm();    
	    		MSFFormPanel comform = (MSFFormPanel)sysComP0990Form;
	    		final SysIfP0990 sysComP0990 =  new SysIfP0990(850,600); 
	    		customForm.setLov(sysComP0990);
	    		lov = customForm.getLov();   
	    		
//	    		if (MSFSharedUtils.paramNull(UsrName)) {
//	    		    customForm.getLov().getLovDef().addColumnFilter("hanNm", "TT", SimpleColumnFilter.OPERATOR_EQUALS);   
//	    		} else {
//	    			sysComP0990.hanNm.setValue(UsrName);
//	    		    customForm.getLov().getLovDef().addColumnFilter("hanNm", UsrName, SimpleColumnFilter.OPERATOR_EQUALS);  
//	    		}
	    		
	    	 
	            if (lov != null) {
	                final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),sysComP0990Form.getTableDef());
	                lovWindow.setInitialForm(sysComP0990Form);   //formPanel을적어준다.
	                lovWindow.showButtonNew(false); 
	                lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
	                lovWindow.show();
	                lov.fixAttributeFormNames(); 
	       
//	                sysComP0100.hanNm.addKeyListener(new KeyListener() {
//	                    public void componentKeyUp(ComponentEvent event) {
//	                        super.componentKeyUp(event);
//	                        sysComP0100.hanNm.validate();
//	                        if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
//	                            IColumnFilter filters = null;
//	                            lovWindow.getLovDef().setTableColumnFilters(filters);
//	                             
//	                            lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.deptCd,"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                            lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.typOccuCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                            lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.emymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                            lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.businCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                            lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.hdofcCodtnCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                            lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(sysComP0100.hanNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                            lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(sysComP0100.resnRegnNum.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                            lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(sysComP0100.systemkey.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                            lovWindow.readData();
//	                        }
//	                    }
//	                 });
//	                
//	                sysComP0100.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
//	                  public void handleEvent(ButtonEvent e) {
//	                      sysComP0100.hanNm.validate();
//	                      IColumnFilter filters = null;
//	                      lovWindow.getLovDef().setTableColumnFilters(filters);
//	                      lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.deptCd,"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                      lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.typOccuCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                      lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.emymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                      lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.businCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                      lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.hdofcCodtnCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                      lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(sysComP0100.hanNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                      lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(sysComP0100.resnRegnNum.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                      lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(sysComP0100.systemkey.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                      lovWindow.readData();
//	                      
//	                  }
//	                 });
	                
	        	} 
	    	        
	    	    return comform;
	    		 
	    	}	   
	   
	   
	    	/**
	    	 * CheckBox 값을 넘겨받아 체크된 체크박스의 값을 Y/N으로 리턴
	    	 * @param checkBox
	    	 * @return v
	    	 */
	    	public static String getCheckedCheckBoxYnValue(CheckBox checkBox){
	    		
	    		String v = "";
	    		
	    		if(checkBox != null){
	    			if((Boolean.TRUE).equals(checkBox.getValue())) {
	    				v = "Y";
	    			}else {
	    				v = "N";
	    			}
	    		}
	    		
	    		return v;
	    	}	   
	   
	   
	   
	   
	
}





