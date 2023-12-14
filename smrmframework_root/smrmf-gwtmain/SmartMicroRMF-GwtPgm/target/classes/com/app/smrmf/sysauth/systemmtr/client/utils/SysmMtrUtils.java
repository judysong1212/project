package com.app.smrmf.sysauth.systemmtr.client.utils;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;

/**
 * @author cyberlhs
 *
 */
public class SysmMtrUtils {
 
 
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





