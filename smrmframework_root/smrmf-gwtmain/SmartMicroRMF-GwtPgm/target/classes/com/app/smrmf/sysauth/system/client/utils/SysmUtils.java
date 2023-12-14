package com.app.smrmf.sysauth.system.client.utils;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;

/**
 * @author cyberlhs
 *
 */
public class SysmUtils {
 
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
	
	
}





