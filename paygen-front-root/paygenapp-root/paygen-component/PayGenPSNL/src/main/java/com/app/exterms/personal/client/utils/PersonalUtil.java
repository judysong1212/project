package com.app.exterms.personal.client.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.client.service.PrgmComBass0300ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**
 * GXT Client Util
 * @author jungmin-mac
 *
 */
public class PersonalUtil {
	private static  List<ModelData> mDtalistCommCombo ;			//공통코드
	private static  List<ModelData> mDtalistDeptCd;    			//부서
	private static  List<ModelData> mDtalistTypOccuCd; 			//직종
	private static  List<ModelData> mDtalistDtilOccuInttnCd;	//직종세
	
	/**
	 * 공통콤보의 데이터를 가져온 후  선택하게 한다.
	 * @param key
	 * @return
	 */
	public static void getComboDataAfterSelect(final String key,final ComboBox<BaseModel> comboBoxObj ,final String cd, final String getX ){
		try{
			List<String> arrRpsttvCd = new ArrayList<String>();
			arrRpsttvCd.add(key);
			PrgmComBass0300DTO sysComBass0300Dto = new PrgmComBass0300DTO(); 
			sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
			PrgmComBass0300Service.Util.getInstance().getPrgmComMultiComboBass0300List(sysComBass0300Dto, new AsyncCallback<HashMap<String,List<BaseModel>>>() {
				
				@Override
				public void onSuccess(HashMap<String, List<BaseModel>> result) {
					if(result != null && result.size() > 0){
						
						comboBoxObj.getStore().add(result.get(key));
						
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
				}
				
				@Override
				public void onFailure(Throwable caught) {
					MessageBox.alert("", "공통코드 에러!", null);
				}
			});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 두날짜 사이에 기간이 인수 day 보다 클경우 false, 작거나 같으면 ture 반환
	 * @param startDate
	 * @param endDate
	 * @param day
	 * @return
	 */
	public static boolean getDiffDateToDate(Date startDate, Date endDate, int day){
		boolean chk = false;
		if(startDate == null || endDate == null){
			return false;
		}
		if((endDate.getTime()-startDate.getTime())/(1000*60*60*24) <= day){
			chk = true;
		}
		
		return chk;
	}
	
	public static void setCheckedRadioValue(RadioGroup radioGroup, String attributeValue){
		
		if(radioGroup != null){
			for(int i = 0; i < radioGroup.getAll().size(); i++){
				Radio radio = (Radio)radioGroup.getAll().get(i);
				if(radio.getValueAttribute().equals(attributeValue)){
					radio.setValue(true);
					break;
				}
			}
		}
	}
	
	public static void setCheckedCheckBoxValue(CheckBoxGroup checkBoxGroup, String attributeValue){
		if(checkBoxGroup != null){
			for(int i =0; i < checkBoxGroup.getAll().size(); i++){
				CheckBox checkBox = (CheckBox)checkBoxGroup.getAll().get(i);
				
				if(checkBox.getValueAttribute().equals(attributeValue)){
					checkBox.setValue(true);
				}
			}
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
//				checkBox.setValue(true);
				v = "Y";
			}else {
//				checkBox.setValue(false);
				v = "N";
			}
		}
		
		return v;
	}
	
	
	/**
	 * 데이터 값을 넘겨받아 체크박스 체크
	 * @param checkBox
	 */
	@SuppressWarnings("null")
	public static void setCheckedCheckBoxYnValue(CheckBox checkBox, String attributeValue){
		if(checkBox != null){
			if(checkBox.getValueAttribute().equals(attributeValue)){
				checkBox.setValue(true);
			}else {
				checkBox.setValue(false);
			}
		}else {
			checkBox.setValue(false);
		}
	}
	
	/**
	 * CheckBoxGroup 을 넘겨받아 체크된 체크박스의 getValueAttribute 을 콤마 기준으로 반환 
	 * ex) 한개일 경우 Y
	 *     두개일 경우 Y,N 
	 * @param checkBoxGroup
	 * @return
	 */
	public static String getCheckedCheckBoxValue(CheckBoxGroup checkBoxGroup){
		String v = "";
		if(checkBoxGroup != null){
			for(int i =0; i < checkBoxGroup.getAll().size(); i++){
				CheckBox checkBox = (CheckBox)checkBoxGroup.getAll().get(i);
				if(checkBox.getValue()){
					v += ","+checkBox.getValueAttribute();
				}
			}
		}
		if(v.indexOf(",")>-1){
			return v.substring(1,v.length());
		}else{
			return v;
		}
	}
	
	/**
	 * RadioGroup 을 넘겨받아 체크된 라디오 getValueAttribute 값 리턴
	 * @param radioGroup
	 * @return
	 */
	public static String getCheckedRadioValue(RadioGroup radioGroup){
		String v = "";
		if(radioGroup != null){
			for(int i = 0; i < radioGroup.getAll().size(); i++){
				Radio radio = (Radio)radioGroup.getAll().get(i);
				if(radio.getValue()){
					v = radio.getValueAttribute();
					break;
				}
			}
		}
		
		return v;
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
	public static String getConvertDateToString(MSFDateField date, String patten){
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
	 * commCdNm 값을 통해 commCd 값을 리턴
	 * @param comboBoxObj
	 * @param value
	 */
	public static String getComboNameToCd(ComboBox<BaseModel> comboBoxObj ,String commCdNm){
		String v = "";
		if(commCdNm != null && !"".equals(commCdNm)){
			
			for(int i = 0; i < comboBoxObj.getStore().getCount(); i++){
				if( commCdNm.equals(comboBoxObj.getStore().getAt(i).get("commCdNm"))){
					v = comboBoxObj.getStore().getAt(i).get("commCd");
					break;
				}
			}
		}
		return v;
	}
	
	/**
	 * 그리드전용 콤보박스 변경시 선택한 콤보 BaseModel 리턴
	 * @param comboBoxObj
	 * @param selectedText
	 * @return
	 */
	public static BaseModel getBaseModelComboDataCdNm(ComboBox<BaseModel> comboBoxObj, String selectedText){
		BaseModel v = new BaseModel();
		
		try{
			for(int i = 0; i < comboBoxObj.getStore().getCount(); i++){
				if(selectedText.equals(comboBoxObj.getStore().getAt(i).get("commCdNm"))){
					v = comboBoxObj.getStore().getAt(i);
					break;
				}
			}
		}catch(Exception e){
			//콤보를 선택시 선택하지 않고 TEXT필드를 선택하였을 경우 java.lang.StringIndexOutOfBoundsException 발생 default 문자를 설정시..
		}
		return v;
	}
	
	/**
	 * 그리드전용 콤보박스 변경시 선택한 콤보 BaseModel 리턴
	 * @param comboBoxObj
	 * @param selectedValue
	 * @return
	 */
	public static BaseModel getBaseModelComboDataCd(ComboBox<BaseModel> comboBoxObj, String selectedValue){
		BaseModel v = new BaseModel();
		
		try{
			for(int i = 0; i < comboBoxObj.getStore().getCount(); i++){
				if(selectedValue.equals(comboBoxObj.getStore().getAt(i).get("commCd"))){
					v = comboBoxObj.getStore().getAt(i);
					break;
				}
			}
		}catch(Exception e){
			//콤보를 선택시 선택하지 않고 TEXT필드를 선택하였을 경우 java.lang.StringIndexOutOfBoundsException 발생 default 문자를 설정시..
		}
		return v;
	}
	
	public static BaseModel getBaseModelComboDataCd(ComboBox<BaseModel> comboBoxObj, String selectedValue, String cdName){
		BaseModel v = new BaseModel();
		
		try{
			for(int i = 0; i < comboBoxObj.getStore().getCount(); i++){
				if(selectedValue.equals(comboBoxObj.getStore().getAt(i).get(cdName))){
					v = comboBoxObj.getStore().getAt(i);
					break;
				}
			}
		}catch(Exception e){
			//콤보를 선택시 선택하지 않고 TEXT필드를 선택하였을 경우 java.lang.StringIndexOutOfBoundsException 발생 default 문자를 설정시..
		}
		return v;
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
	 * 공통 콤보 데이터를 세팅한다.
	 * @param combobx
	 * @param cd
	 * @param noData
	 * @return
	 */
	public static ListStore<BaseModel> setStoreComboData(final ComboBox<BaseModel> combobx, String cd, final boolean noData){
		
		final ListStore<BaseModel> store = new ListStore<BaseModel>(); 
		PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();
		
//		sysComBass0300Service.getCommCodeList(cd, new AsyncCallback<List<BaseModel>>() {
//			@Override
//			public void onSuccess(List<BaseModel> result) {
//				// TODO Auto-generated method stub
//				if(result.size() == 0 && noData ){
//					combobx.setEmptyText("--No Data--");
//				}
//				store.add(result);
//			}
//
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				caught.printStackTrace();
//			}
//		});
		return store;
	}
	
	/**
	 * 공통콤보데이터를 세팅한다.(빼고싶은 코드 항목 추가)
	 * @param combobx
	 * @param cd
	 * @param noData
	 * @param deleteCode 
	 * @return
	 */
	public static ListStore<BaseModel> setStoreComboData(final ComboBox<BaseModel> combobx, String cd, final boolean noData, final String deleteCode){
		
		final ListStore<BaseModel> store = new ListStore<BaseModel>(); 
		PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();
		
//		sysComBass0300Service.getCommCodeList(cd, new AsyncCallback<List<BaseModel>>() {
//			@Override
//			public void onSuccess(List<BaseModel> result) {
//				// TODO Auto-generated method stub
//				if(result.size() == 0 && noData ){
//					combobx.setEmptyText("--No Data--");
//				}
//				List<BaseModel> list = new ArrayList<BaseModel>();
//				if(result.size() > 0){
//					for(int i = 0; i < result.size(); i++){
//						if(!deleteCode.equals(result.get(i).get("commCd"))){
//							list.add(result.get(i));
//						}
//						
//					}
//				}
//				store.add(list);
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				caught.printStackTrace();
//			}
//		});
		return store;
	}
	
	public static ListStore<BaseModel> setSotreComboData(String cd, final String deleteCode){
		final ListStore<BaseModel> store = new ListStore<BaseModel>(); 
		PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();
//		sysComBass0300Service.getCommCodeList(cd, new AsyncCallback<List<BaseModel>>() {
//			@Override
//			public void onSuccess(List<BaseModel> result) {
//				// TODO Auto-generated method stub
//				List<BaseModel> list = new ArrayList<BaseModel>();
//				if(result.size() > 0){
//					for(int i = 0; i < result.size(); i++){
//						if(!deleteCode.equals(result.get(i).get("commCd"))){
//							list.add(result.get(i));
//						}
//					}
//				}
//				store.add(list);
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				caught.printStackTrace();
//			}
//		});
		return store;
	}
	public static PrgmComBass0300DTO getComboList(){
		
		List<String> arrRpsttvCd = new ArrayList<String>();
		 
		arrRpsttvCd.add("A003");
		arrRpsttvCd.add("A005");
		arrRpsttvCd.add("A006");
		arrRpsttvCd.add("A009");
		
		arrRpsttvCd.add("A010");
		arrRpsttvCd.add("A011");
		arrRpsttvCd.add("A012");
		arrRpsttvCd.add("A013");
		//arrRpsttvCd.add("A014"); //자격면허
		
		arrRpsttvCd.add("A015");
		arrRpsttvCd.add("A019");
		
		arrRpsttvCd.add("A020");
		arrRpsttvCd.add("A021");
		arrRpsttvCd.add("A022");
		arrRpsttvCd.add("A023");
		arrRpsttvCd.add("A024");
		arrRpsttvCd.add("A025");
		arrRpsttvCd.add("A026");
		arrRpsttvCd.add("A028"); 	//학위구분
		arrRpsttvCd.add("A029");
		
		arrRpsttvCd.add("A030");
		//arrRpsttvCd.add("A031"); 	//학교
		arrRpsttvCd.add("A036");
		arrRpsttvCd.add("A037");
		
		
		arrRpsttvCd.add("A041");	//직종세
		arrRpsttvCd.add("A042");
		arrRpsttvCd.add("A043"); 	//수업년수         
		arrRpsttvCd.add("A044");
		arrRpsttvCd.add("A045");
		arrRpsttvCd.add("A047");
		arrRpsttvCd.add("A048"); 	//호봉제 구분
		arrRpsttvCd.add("A049"); 	//경력인정구분
		
		arrRpsttvCd.add("B014"); 	//휴가구분
//		arrRpsttvCd.add("Y012"); 	//연말정산 부양관계
		 
		PrgmComBass0300DTO sysComBass0300Dto = new PrgmComBass0300DTO(); 
		sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
		
		return sysComBass0300Dto;
	}
	 

	public static String LPAD(String str, int len, String append) {
		String rtn = str;
		if (str.length() < len) {
			for (int i = (len - str.length()); i > 0; i--) {
				rtn = append + rtn;
			}
		} else {
			rtn = str.substring(0, len);
		}
		return rtn;
	}
	
	
	//추가
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
	 
	 
	 
	    
//		/**
//		 * 
//		 * <pre>
//		 * 1. 개요 : 인사 신규 등록을 위한 팝업 
//		 * 2. 처리내용 : 
//		 * </pre>
//		 * @Method Name : insrPopUpPrgmCom0100Form
//		 * @date : Jun 16, 2016
//		 * @author : leeheuisung
//		 * @history : 
//		 *	-----------------------------------------------------------------------
//		 *	변경일				작성자						변경내용  
//		 *	----------- ------------------- ---------------------------------------
//		 *	Jun 16, 2016		leeheuisung				최초 작성 
//		 *	-----------------------------------------------------------------------
//		 * 
//		 * @param DeptNm
//		 * @return
//		 */
//	 public static final MSFFormPanel insrPopUpPrgmCom0100Form(String UsrName){
//			
//		Lov lov = null;
//		// LovLiveGeneric lovWindow = null;
//		final MSFPanelCustomForm customForm = new MSFPanelCustomForm(new PrgmComPsnl0100Def(), 1, 0);
//		MSFCustomForm sysCom0100Form = customForm.getCustomForm();
//		MSFFormPanel comform = (MSFFormPanel) sysCom0100Form;
//		final PrgminsrComP0100 sysComP0100 = new PrgminsrComP0100(850, 600);
//		customForm.setLov(sysComP0100);
//		lov = customForm.getLov();
//
//		if (MSFSharedUtils.paramNull(UsrName)) {
//			customForm.getLov().getLovDef().addColumnFilter("hanNm", "TT",SimpleColumnFilter.OPERATOR_EQUALS);
//		} else {
//			PrgminsrComP0100.getHanNm().setValue(UsrName);
//			customForm.getLov().getLovDef().addColumnFilter("hanNm", UsrName,SimpleColumnFilter.OPERATOR_EQUALS);
//		}
//			
//		 
//		if (lov != null) {
//			final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(), sysCom0100Form.getTableDef());
//			lovWindow.setInitialForm(sysCom0100Form); // formPanel을적어준다.
//			lovWindow.showButtonNew(false);
//			lovWindow.setSize(lov.getWidth(), lov.getHeight()); // 팝업화면 사이즈
//			lovWindow.show();
//			lov.fixAttributeFormNames();
//
//			PrgminsrComP0100.getHanNm().addKeyListener(new KeyListener() {
//				public void componentKeyUp(ComponentEvent event) {
//					super.componentKeyUp(event);
//					PrgminsrComP0100.getHanNm().validate();
//					if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
//						
//						IColumnFilter filters = null;
//						
//	                    lovWindow.getLovDef().setTableColumnFilters(filters); 
//	                	lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgminsrComP0100.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                	lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgminsrComP0100.getTypOccuCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                 	lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(PrgminsrComP0100.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                 	lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(PrgminsrComP0100.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                 	lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(PrgminsrComP0100.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                 	lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(PrgminsrComP0100.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                 	lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(PrgminsrComP0100.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                 	lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(PrgminsrComP0100.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                 	lovWindow.readData();
//	                 	
//					}
//				}
//			});
//	            
//			PrgminsrComP0100.btnUsrSearch.addListener(Events.Select,new Listener<ButtonEvent>() {
//				public void handleEvent(ButtonEvent e) {
//					
//					PrgminsrComP0100.getHanNm().validate();
//					
//					IColumnFilter filters = null;
//					
//					lovWindow.getLovDef().setTableColumnFilters(filters);
//					lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgminsrComP0100.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//					lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgminsrComP0100.getTypOccuCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//					lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(PrgminsrComP0100.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//					lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(PrgminsrComP0100.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//					lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(PrgminsrComP0100.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//					lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(PrgminsrComP0100.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//					lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(PrgminsrComP0100.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//					lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(PrgminsrComP0100.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//					lovWindow.readData();
//	                  
//				}
//			});
//
//		}
//
//		return comform;
//	}
//	    
	 
	 
//	    public static native void xlsExportDataList(String to, String sframe, List<HashMap<String, String>> arrayList) /*-{
//        
//        var myForm = document.createElement("form");
//        myForm.method="post" ;
//        myForm.action = to;
//        myForm.target = sframe;
//
////        for (var k in param) {
////            var myInput = document.createElement("input") ;
////            myInput.setAttribute("name", k) ;
////            myInput.setAttribute("value", param[k]);
////            myForm.appendChild(myInput) ;
////        }
//        document.body.appendChild(arrayList) ;
//        myForm.submit() ;
//        document.body.removeChild(myForm) ;
//    }-*/;  
//	    
	    
	
	
	
	
}
