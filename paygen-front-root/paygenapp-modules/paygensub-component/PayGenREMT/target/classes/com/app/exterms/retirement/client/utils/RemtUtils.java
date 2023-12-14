/**
 * 
 */
package com.app.exterms.retirement.client.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;

/**
 * @author cyberlhs
 *
 */
public class RemtUtils {

    private static  List<ModelData> mDtalistCommCombo ; //공통코드
    private static  List<ModelData> mDtalistDeptCd;    //부서
    private static  List<ModelData> mDtalistTypOccuCd; //직종
    private static  List<ModelData> mDtalistDtilOccuInttnCd; //직종세
    
    
    /**
     * 공통코드 멀티 콤보처리시 처리 루틴 
     * @param lsCommCombo
     * @return
     */
    public static List<ModelData> getLstComboModelData(ListStore<BaseModel>  lsCommCombo) {
       mDtalistCommCombo = new ArrayList<ModelData>();
       for(int i=0; i< lsCommCombo.getCount(); i++) {
        ModelData m = new BaseModel();
        m.set("commCd", lsCommCombo.getAt(i).get("commCd"));
        m.set("commCdNm", lsCommCombo.getAt(i).get("commCdNm")); 
        mDtalistCommCombo.add(m);
       }
       return mDtalistCommCombo;
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
* 직종 멀티 콤보처리 
* @param lsTypOccuCd
* @return List<ModelData>
*/
 public static List<ModelData> getTypOccuCdModelData(ListStore<BaseModel>  lsTypOccuCd) {
     mDtalistTypOccuCd = new ArrayList<ModelData>();
     for(int i=0; i< lsTypOccuCd.getCount(); i++) {
      ModelData m = new BaseModel();
      m.set("typOccuCd", lsTypOccuCd.getAt(i).get("typOccuCd"));
      m.set("pyspGrdeCd",lsTypOccuCd.getAt(i).get("pyspGrdeCd"));
      m.set("typOccuNm", lsTypOccuCd.getAt(i).get("typOccuNm")); 
      mDtalistTypOccuCd.add(m);
     }
     return mDtalistTypOccuCd;
 }
 
 /**
  * 직종세 멀티 콤보처리 
  * @param lsDtilOccuInttnCd
  * @return List<ModelData>
  */
   public static List<ModelData> getDtilOccuInttnCdModelData(ListStore<BaseModel>  lsDtilOccuInttnCd) {
       mDtalistDtilOccuInttnCd = new ArrayList<ModelData>();
       for(int i=0; i< lsDtilOccuInttnCd.getCount(); i++) {
        ModelData m = new BaseModel();
        m.set("dtilOccuInttnCd", lsDtilOccuInttnCd.getAt(i).get("dtilOccuInttnCd"));
        m.set("dtilOccuClsNm", lsDtilOccuInttnCd.getAt(i).get("dtilOccuClsNm")); 
        mDtalistDtilOccuInttnCd.add(m);
       }
       return mDtalistDtilOccuInttnCd;
   }
     
   
 /**
  *  멀티 콤보로 선택된 값의 키를 스트링에 값을 대입
  * @param lsMdData //멀티콤보 체크된 값의 리스트
  * @param findKey  //멀티콤보 체크된 값에 가지고 오고자 하는 값의 키
  * @return
  */
   public static String getStrValToMDMultiCombo(List<ModelData>  lsMdData, String findKey) {
      
       String strReData = "";
       String chkkey = "";
       for (int i=0; i<lsMdData.size(); i++){ 
           chkkey +=  MSFSharedUtils.allowNulls(lsMdData.get(i).get(findKey))+","; 
       } 
       strReData = chkkey.substring(0,chkkey.length()-1); 
       return strReData;
   }
   
   
   /**
	 * DATE 날짜를 String 형으로 변경
	 * @param date
	 * @param patten
	 * @return
	 */
	public static String getConvertDateToString(DateField date, String patten){
		if(date.getValue() != null){
			DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat(patten);
			return dateTimeFormat.format(date.getValue());
		}else{
			return "";
		}
	}
	/**
	 * String 날짜를 DATE 타입으로
	 * @param date
	 * @param patten
	 * @return
	 */
	public static Date getConvertStringToDate(String date, String patten){
		if(date == null || date == "") return null;
		DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat(patten);
		return dateTimeFormat.parse(date);
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
  * 멀티 콤보로 선택된 값의 키를 스트링에 값을 대입
  * @param lsBmData 값을 구하고자 하는 listStore 
  * @param strValueData //멀티콤보의 디스플레이 값 
  * @param findNmKey //선택된  디스틀레이 값의 키 
  * @param findKey //BaseModel 가지고 오고자 하는 값의 키
  * @return
  */
 public static String getStrValToBMMultiCombo(ListStore<BaseModel> lsBmData, String strValueData, String findNmKey, String findKey) {
    
     String strReData = ""; 
     if (MSFSharedUtils.paramNotNull(strValueData)) {
         String[] ray = strValueData.substring(0, strValueData.length()).split(",");
         String chkkey = "";
         for (int i=0; i<ray.length; i++){ 
             BaseModel bmData = lsBmData.findModel(findNmKey, ray[i]);
             chkkey += bmData.get(findKey)+","; 
         }
         strReData = chkkey.substring(0,chkkey.length()-1);
     }  
    
     return strReData;
 } 
 
 
 //출력물처리시 멀티선택건에 대해 값 셋팅 
 public static String getPrintStrToMultiData(ListStore<BaseModel> lsBmData, String strValueData, String findNmKey, String findKey) {
     
     String strReData = ""; 
     if (MSFSharedUtils.paramNotNull(strValueData)) {
         String[] ray = strValueData.substring(0, strValueData.length()).split(",");
         String chkkey = "";
         for (int i=0; i<ray.length; i++){ 
             BaseModel bmData = lsBmData.findModel(findNmKey, ray[i]);
             chkkey += "'" + bmData.get(findKey)+"',"; 
         }
         strReData = chkkey.substring(0,chkkey.length()-1);
     }  
     
     return strReData;
 }  
     
   
}
