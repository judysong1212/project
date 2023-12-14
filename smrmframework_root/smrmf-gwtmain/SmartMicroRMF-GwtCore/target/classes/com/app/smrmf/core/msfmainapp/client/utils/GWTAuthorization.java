/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.utils;

import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.TextField;


  

public class GWTAuthorization {
     
   private static GWTAuthorization oneAuthorization;  
	 
   //권한항목 선언 - 검색
   private static String GWT_SRH_DEPTCD = "srhDeptCd";  //부서코드검색
   private static String GWT_SRH_DEPTCD01 = "searchCurrDeptCd";  //부서코드검색
   private static String GWT_SRH_DEPTCD02 = "srhCurrAffnDeptCd";  //부서코드검색
   
   
   private static String GWT_SRH_DEPTNM = "srhDeptNm";  //부서코드명 
   private static String GWT_SRH_DEPTNM01 = "srhCurrAffnDeptNm";  //부서코드명 
   private static String GWT_SRH_PAYRMANGDEPTCD = "srhPayrMangDeptCd";  //단위기관
   private static String GWT_SRH_EMYMTDIVCD = "srhEmymtDivCd";  // 고용구분 
   private static String GWT_SRH_EMYMTDIVCD01 = "searchEmymtDivCd";  // 고용구분 
   private static String GWT_SRH_TYPOCCUCD = "srhTypOccuCd";  //직종 
   private static String GWT_SRH_DTILOCCUINTTNCD = "srhDtilOccuInttnCd";  // 직종세부
   private static String GWT_SRH_BUSINCD = "srhBusinCd";  //사업 
   private static String GWT_SRH_BUSINCD01 = "searchBusinCd";  //사업 
   //권한항목 선언 - 생성 
   private static String GWT_CRE_PAYRMANGDEPTCD = "crePayrMangDeptCd";  // 단위기관
   private static String GWT_CRE_EMYMTDIVCD = "creEmymtDivCd";  //    고용구분 
   private static String GWT_CRE_DEPTCD = "creDeptCd";  //     부서 
   private static String GWT_CRE_TYPOCCUCD = "creTypOccuCd";  // 직종
   private static String GWT_CRE_DTILOCCUINTTNCD = "creDtilOccuInttnCd";  // 직종세 
   private static String GWT_CRE_BUSINCD = "creBusinCd";  //사업
   
  // private static String GWT_CRE_PAYRMANGDEPTCD = "crePayrMangDeptCd";  // 단위기관
   private static String GWT_CRE_EMYMTDIVCD01 = "midEmymtDivCd";  //    고용구분 
   private static String GWT_CRE_DEPTCD01 = "midCurrDeptCd";  //     부서 
   private static String GWT_CRE_TYPOCCUCD01 = "midTypOccuCd";  // 직종
  // private static String GWT_CRE_DTILOCCUINTTNCD = "creDtilOccuInttnCd";  // 직종세 
   private static String GWT_CRE_BUSINCD01 = "midBusinCd";  //사업
   
   //객체구분코드 
   private static String GWT_FILD_COMBOX = "ComboBox";  //콤보 
   private static String GWT_FILD_MSFCOMBOX = "MSFComboBox";  //콤보 
   private static String GWT_FILD_MULTICOMBOX = "MultiComBox";  //멀티 콤보 
   private static String GWT_FILD_TEXTFIELD = "TextField";  //텍스트 
   private static String GWT_FILD_MSFTXTFLD = "MSFTextField";  //텍스트 
   
   
   private  GWTAuthorization () {
	
   }
   
   public static GWTAuthorization getInstance() {
       if(oneAuthorization==null) {
    	   oneAuthorization = new GWTAuthorization();
       }
       return oneAuthorization;
   }
   
   public void formAuthFieldConfig(final Field<?>[] lstFields) {    
   			for (int iCnt= 0;iCnt < lstFields.length;iCnt++) { 
   			   Field<?>  f = lstFields[iCnt]; 
   			   if (f instanceof ComboBox<?>) { 
   				 if  (GWT_SRH_DEPTCD.equals(f.getName()) || GWT_CRE_DEPTCD.equals(f.getName()) ||  GWT_SRH_DEPTNM.equals(f.getName())) {//부서 
				
   					 setAuthCmbDeptCd(f,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_COMBOX);
				  
   				  } else if (GWT_SRH_EMYMTDIVCD.equals(f.getName()) || GWT_CRE_EMYMTDIVCD.equals(f.getName())) {//고용구분 
					   
   					  setAuthCmbEmymtDivCd(f,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_COMBOX);
   					
				   } else if (GWT_SRH_PAYRMANGDEPTCD.equals(f.getName()) || GWT_CRE_PAYRMANGDEPTCD.equals(f.getName())) {//단위기관 
					   
					   setAuthCmbPayrMangDeptCd(f,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_COMBOX);
					   
				   } else if (GWT_SRH_TYPOCCUCD.equals(f.getName()) || GWT_CRE_TYPOCCUCD.equals(f.getName())) {//직종 
					   
					   setAuthCmbTypOccuCd(f,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_COMBOX);
					   
				   } else if (GWT_SRH_DTILOCCUINTTNCD.equals(f.getName()) || GWT_CRE_DTILOCCUINTTNCD.equals(f.getName())) {//직종세 
					   
					   setAuthCmbDtilOccuClsDivCd(f,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_COMBOX);
					   
				   } else if (GWT_SRH_BUSINCD.equals(f.getName()) || GWT_CRE_BUSINCD.equals(f.getName())) {//사업 
					   
				   }
			   } else  if (f instanceof MSFMultiComboBox<?>) {
				   if  (GWT_SRH_DEPTCD.equals(f.getName()) || GWT_CRE_DEPTCD.equals(f.getName()) ||  GWT_SRH_DEPTNM.equals(f.getName())) {//부서 
					
					   setAuthCmbDeptCd(f,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_MULTICOMBOX);
				   
				   } else if (GWT_SRH_EMYMTDIVCD.equals(f.getName()) || GWT_CRE_EMYMTDIVCD.equals(f.getName())) {//고용구분 
					   setAuthCmbEmymtDivCd(f,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_MULTICOMBOX);
				   } else if (GWT_SRH_PAYRMANGDEPTCD.equals(f.getName()) || GWT_CRE_PAYRMANGDEPTCD.equals(f.getName())) {//단위기관 
					   
					   setAuthCmbPayrMangDeptCd(f,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_MULTICOMBOX);
					   
				   } else if (GWT_SRH_TYPOCCUCD.equals(f.getName()) || GWT_CRE_TYPOCCUCD.equals(f.getName())) {//직종 
					   
					   setAuthCmbTypOccuCd(f,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_MULTICOMBOX);
					   
				   } else if (GWT_SRH_DTILOCCUINTTNCD.equals(f.getName()) || GWT_CRE_DTILOCCUINTTNCD.equals(f.getName())) {//직종세 
					   
					   setAuthCmbDtilOccuClsDivCd(f,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_MULTICOMBOX);
					   
				   } else if (GWT_SRH_BUSINCD.equals(f.getName()) || GWT_CRE_BUSINCD.equals(f.getName())) {//사업 
					   
				   }
			   } else  if (f instanceof TextField<?>) { 
				   if  (GWT_SRH_DEPTCD.equals(f.getName()) || GWT_SRH_DEPTCD02.equals(f.getName())    || GWT_SRH_DEPTNM01.equals(f.getName()) 
						    || GWT_SRH_DEPTCD01.equals(f.getName())  || GWT_CRE_DEPTCD.equals(f.getName()) ||  GWT_SRH_DEPTNM.equals(f.getName())) {//부서 
					
					   setAuthCmbDeptCd(f,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_TEXTFIELD);
				   
				   } else if (GWT_SRH_EMYMTDIVCD.equals(f.getName()) || GWT_CRE_EMYMTDIVCD.equals(f.getName())) {//고용구분 
					   setAuthCmbEmymtDivCd(f,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_TEXTFIELD);
				   } else if (GWT_SRH_PAYRMANGDEPTCD.equals(f.getName()) || GWT_CRE_PAYRMANGDEPTCD.equals(f.getName())) {//단위기관 
					   
					   setAuthCmbPayrMangDeptCd(f,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_TEXTFIELD);
					   
				   } else if (GWT_SRH_TYPOCCUCD.equals(f.getName()) || GWT_CRE_TYPOCCUCD.equals(f.getName())) {//직종 
					   
					   setAuthCmbTypOccuCd(f,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_TEXTFIELD);
					   
				   } else if (GWT_SRH_DTILOCCUINTTNCD.equals(f.getName()) || GWT_CRE_DTILOCCUINTTNCD.equals(f.getName())) {//직종세

					   setAuthCmbDtilOccuClsDivCd(f,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_TEXTFIELD);
					   
				   } else if (GWT_SRH_BUSINCD.equals(f.getName()) || GWT_CRE_BUSINCD.equals(f.getName())) {//사업 
					   
				   }
			   }
   			  
				  
				   
				   
	       }	 	  
   }
     
   /**
    * 
    * <pre>
    * 1. 개요 : 화면 검색조건 등록조건 셋팅 처리를위한 루틴  
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : formOAuthFieldConfig
    * @date : 2018. 4. 19.
    * @author : atres
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	2018. 4. 19.		atres				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @param fldField
    * @param bm
    * @param frmType
    */
   public void formOAuthFieldConfig(final Field<?> fldField,ListStore<BaseModel> bm,String frmType) {    
		 
			   if (frmType.equals(GWT_FILD_COMBOX) || frmType.equals(GWT_FILD_MSFCOMBOX)) { 
				 if  (GWT_SRH_DEPTCD.equals(fldField.getName()) || GWT_CRE_DEPTCD.equals(fldField.getName()) ||  GWT_SRH_DEPTNM.equals(fldField.getName())) {//부서 
			
					 setAuthCmbDeptCd(fldField,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_COMBOX);
			  
				  } else if (GWT_SRH_EMYMTDIVCD.equals(fldField.getName()) || GWT_CRE_EMYMTDIVCD.equals(fldField.getName())) {//고용구분 
				   
					  setAuthCmbEmymtDivCd(fldField,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_COMBOX);
					
			   } else if (GWT_SRH_PAYRMANGDEPTCD.equals(fldField.getName()) || GWT_CRE_PAYRMANGDEPTCD.equals(fldField.getName())) {//단위기관 
				   
				   setAuthCmbPayrMangDeptCd(fldField,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_COMBOX);
				   
			   } else if (GWT_SRH_TYPOCCUCD.equals(fldField.getName()) || GWT_CRE_TYPOCCUCD.equals(fldField.getName())) {//직종 
				   
				   setAuthCmbTypOccuCd(fldField,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_COMBOX);
				   
			   } else if (GWT_SRH_DTILOCCUINTTNCD.equals(fldField.getName()) || GWT_CRE_DTILOCCUINTTNCD.equals(fldField.getName())) {//직종세 
				   
				   setAuthCmbDtilOccuClsDivCd(fldField,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_COMBOX);
				   
			   } else if (GWT_SRH_BUSINCD.equals(fldField.getName()) || GWT_CRE_BUSINCD.equals(fldField.getName())) {//사업 
				   
			   }
		   } else  if (frmType.equals(GWT_FILD_MULTICOMBOX)) {
			   if  (GWT_SRH_DEPTCD.equals(fldField.getName()) || GWT_CRE_DEPTCD.equals(fldField.getName()) ||  GWT_SRH_DEPTNM.equals(fldField.getName())) {//부서 
				
				   setAuthCmbDeptCd(fldField,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_MULTICOMBOX);
			   
			   } else if (GWT_SRH_EMYMTDIVCD.equals(fldField.getName()) || GWT_CRE_EMYMTDIVCD.equals(fldField.getName())) {//고용구분 
				   setAuthCmbEmymtDivCd(fldField,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_MULTICOMBOX);
			   } else if (GWT_SRH_PAYRMANGDEPTCD.equals(fldField.getName()) || GWT_CRE_PAYRMANGDEPTCD.equals(fldField.getName())) {//단위기관 
				   
				   setAuthCmbPayrMangDeptCd(fldField,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_MULTICOMBOX);
				   
			   } else if (GWT_SRH_TYPOCCUCD.equals(fldField.getName()) || GWT_CRE_TYPOCCUCD.equals(fldField.getName())) {//직종 
				   
				   setAuthCmbTypOccuCd(fldField,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_MULTICOMBOX);
				   
			   } else if (GWT_SRH_DTILOCCUINTTNCD.equals(fldField.getName()) || GWT_CRE_DTILOCCUINTTNCD.equals(fldField.getName())) {//직종세 
				   
				   setAuthCmbDtilOccuClsDivCd(fldField,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_MULTICOMBOX);
				   
			   } else if (GWT_SRH_BUSINCD.equals(fldField.getName()) || GWT_CRE_BUSINCD.equals(fldField.getName())) {//사업 
				   
			   }
		   } else  if (frmType.equals(GWT_FILD_TEXTFIELD) || frmType.equals(GWT_FILD_MSFTXTFLD)) { 
			   if  (GWT_SRH_DEPTCD.equals(fldField.getName()) || GWT_SRH_DEPTCD02.equals(fldField.getName())    || GWT_SRH_DEPTNM01.equals(fldField.getName()) 
					    || GWT_SRH_DEPTCD01.equals(fldField.getName())  || GWT_CRE_DEPTCD.equals(fldField.getName()) ||  GWT_SRH_DEPTNM.equals(fldField.getName())) {//부서 
				
				   setAuthCmbDeptCd(fldField,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_TEXTFIELD);
			   
			   } else if (GWT_SRH_EMYMTDIVCD.equals(fldField.getName()) || GWT_CRE_EMYMTDIVCD.equals(fldField.getName())) {//고용구분 
				   setAuthCmbEmymtDivCd(fldField,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_TEXTFIELD);
			   } else if (GWT_SRH_PAYRMANGDEPTCD.equals(fldField.getName()) || GWT_CRE_PAYRMANGDEPTCD.equals(fldField.getName())) {//단위기관 
				   
				   setAuthCmbPayrMangDeptCd(fldField,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_TEXTFIELD);
				   
			   } else if (GWT_SRH_TYPOCCUCD.equals(fldField.getName()) || GWT_CRE_TYPOCCUCD.equals(fldField.getName())) {//직종 
				   
				   setAuthCmbTypOccuCd(fldField,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_TEXTFIELD);
				   
			   } else if (GWT_SRH_DTILOCCUINTTNCD.equals(fldField.getName()) || GWT_CRE_DTILOCCUINTTNCD.equals(fldField.getName())) {//직종세

				   setAuthCmbDtilOccuClsDivCd(fldField,MSFMainApp.get().getUser().getUsrDivCd(),GWT_FILD_TEXTFIELD);
				   
			   } else if (GWT_SRH_BUSINCD.equals(fldField.getName()) || GWT_CRE_BUSINCD.equals(fldField.getName())) {//사업 
				   
			   }
		   }
			  
			  
			   
			   
      }	 	  
   
   
   /**
  	 * <pre>
  	 * 1. 개요 : 부서 권한처리 루틴 
  	 * 2. 처리내용 : 
  	 * </pre>
  	 * @Method Name : setAuthCmbDeptCd
  	 * @date : Nov 27, 2015
  	 * @author : leeheuisung
  	 * @history : 
  	 *	-----------------------------------------------------------------------
  	 *	변경일				작성자						변경내용  
  	 *	----------- ------------------- ---------------------------------------
  	 *	Nov 27, 2015		leeheuisung				최초 작성 
  	 *	-----------------------------------------------------------------------
  	 * 
  	 * @param fldNm     //객체명
  	 * @param usrDivCd  //사용자구분코드 
	 * @param feildDiv  //필드구분 
	 */ 	
	private void setAuthCmbDeptCd(final Field<?> fldNm,String usrDivCd,String fieldDiv) {
		  
	       if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(usrDivCd)) || (MSFConfiguration.AUTH_USR_DIV_40.equals(usrDivCd))) {
              //기간제업무담당자- 기간제업무담당자 
	    	   initAuthDeptCd(fldNm,fieldDiv); 
           } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(usrDivCd)) {
            //무기계약직업무담당자- 무기계약직업무담당자
               //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size()); 
        	   initAuthDeptCd(fldNm,fieldDiv); 
        	    
           } else  if (MSFConfiguration.AUTH_USR_DIV_25.equals(usrDivCd)) {
               //[겸직] 무기계약직및 기간제 동일처리 필요한 부분 
                  //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
        	   initAuthDeptCd(fldNm,fieldDiv); 
                 
           } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(usrDivCd)) {
             //무기계약직업무담당자- 무기계약직업무담당자
        	  
           } else  if (MSFConfiguration.AUTH_USR_DIV_60.equals(usrDivCd)) { 
        	   
           } else   { 
        	   
           }  
	  }
	
	
	  /**
	 * <pre>
	 * 1. 개요 :  부서 관련 권한 설정 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : initAuthDeptCd
	 * @date : Nov 27, 2015
	 * @author : leeheuisung
	 * @history : 
	 *  private static String GWT_FILD_COMBOX = "ComBox";  //콤보 
     *  private static String GWT_FILD_MULTICOMBOX = "MultiComBox";  //멀티 콤보 
     * private static String GWT_FILD_TEXTFIELD = "TextField";  //텍스트 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Nov 27, 2015		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param fldNm 객체명 
	 * @param fieldDiv 필드구분 
	 */ 	
	private void initAuthDeptCd(final Field<?> fldNm ,String fieldDiv) {
		
	 	 String deptCd = MSFMainApp.get().getUser().getDeptCd();
	 	 
		 if (GWT_FILD_COMBOX.equals(fieldDiv)) {//콤보 
			 if (!fldNm.isEnabled()) { 
				  BaseModel bmSelect = (BaseModel) ((ComboBox) fldNm).getStore().findModel("deptCd",deptCd); 
                 ((ComboBox) fldNm).setValue(bmSelect);  
			  } 
		 } else  if (GWT_FILD_MULTICOMBOX.equals(fieldDiv)) {//멀티 콤보 
			 if (!fldNm.isEnabled()) {  
				 ModelData mdSelect = (ModelData) ((MSFMultiComboBox) fldNm).getStore().findModel("deptCd",deptCd);
	             if (MSFSharedUtils.paramNotNull(mdSelect)) {
	                 ((MSFMultiComboBox) fldNm).getListView().setChecked(mdSelect, true); 
	                 ((MSFMultiComboBox) fldNm).setValue(mdSelect.get("deptNmRtchnt")); 
	             }    
			  }  
		 } else  if (GWT_FILD_TEXTFIELD.equals(fieldDiv)) {//텍스트 
			 if (!fldNm.isEnabled()) {   
			   if (fldNm.getName().endsWith("eptCd")  ) { 
	 			 ((TextField) fldNm).setValue(MSFMainApp.get().getUser().getDeptCd());
	 			 fldNm.fireEvent(Events.Add);
	 		   } else  if ( fldNm.getName().endsWith("eptNm")) {       
	 			  ((TextField) fldNm).setValue(MSFMainApp.get().getUser().getDeptNm());
		       }
			 }
		 }
		 
	  }
	     
   
	private void setAuthCmbEmymtDivCd(final Field<?> fldNm,String usrDivCd,String fieldDiv) {
		  
	   if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(usrDivCd)) || (MSFConfiguration.AUTH_USR_DIV_40.equals(usrDivCd))) {
           //기간제업무담당자- 기간제업무담당자 
	    	   initAuthEmymtDivCd(fldNm,fieldDiv,MSFConfiguration.EMYMT_DIVCD02); 
        } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(usrDivCd)) {
         //무기계약직업무담당자- 무기계약직업무담당자
            //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size()); 
        	  initAuthEmymtDivCd(fldNm,fieldDiv,MSFConfiguration.EMYMT_DIVCD01); 
     	    
        } else  if (MSFConfiguration.AUTH_USR_DIV_25.equals(usrDivCd)) {
            //[겸직] 무기계약직및 기간제 동일처리 필요한 부분 
               //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
        	 initAuthEmymtDivCd(fldNm,fieldDiv,MSFConfiguration.EMYMT_DIVCD01); 
              
        } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(usrDivCd)) {
          //무기계약직업무담당자- 무기계약직업무담당자
        	 initAuthEmymtDivCd(fldNm,fieldDiv,MSFConfiguration.EMYMT_DIVCD01); 
        } else  if (MSFConfiguration.AUTH_USR_DIV_60.equals(usrDivCd)) { 
        	 initAuthEmymtDivCd(fldNm,fieldDiv,MSFConfiguration.EMYMT_DIVCD01); 
        } else   { 
     	   
        }  
	  }
	
	private void initAuthEmymtDivCd(final Field<?> fldNm ,String fieldDiv,String EmymtDivCd) {
		
	 	 String deptCd = MSFMainApp.get().getUser().getDeptCd();
	 	BaseModel bmSelect = new BaseModel();
	 	
	 	bmSelect = (BaseModel) ((ComboBox) fldNm).getStore().findModel("commCd",EmymtDivCd); 
        ((ComboBox) fldNm).setValue(bmSelect);  
        
		 if (GWT_FILD_COMBOX.equals(fieldDiv)) {//콤보 
			 if (!fldNm.isEnabled()) { 
				bmSelect = (BaseModel) ((ComboBox) fldNm).getStore().findModel("commCd",EmymtDivCd); 
                ((ComboBox) fldNm).setValue(bmSelect);  
			  } 
		 } else  if (GWT_FILD_MULTICOMBOX.equals(fieldDiv)) {//멀티 콤보 
//			 if (!fldNm.isEnabled()) {  
//				 ModelData mdSelect = (ModelData) ((MSFMultiComboBox) fldNm).getStore().findModel("deptCd",deptCd);
//	             if (MSFSharedUtils.paramNotNull(mdSelect)) {
//	                 ((MSFMultiComboBox) fldNm).getListView().setChecked(mdSelect, true); 
//	                 ((MSFMultiComboBox) fldNm).setValue(mdSelect.get("deptNmRtchnt")); 
//	             }    
//			  }  
		 } else  if (GWT_FILD_TEXTFIELD.equals(fieldDiv)) {//텍스트 
//			 if (!fldNm.isEnabled()) {   
//			   if (fldNm.getName().endsWith("eptCd")  ) { 
//	 			 ((TextField) fldNm).setValue(MSFMainApp.get().getUser().getDeptCd());
//	 			 fldNm.fireEvent(Events.Add);
//	 		   } else  if ( fldNm.getName().endsWith("eptNm")) {       
//	 			  ((TextField) fldNm).setValue(MSFMainApp.get().getUser().getDeptNm());
//		       }
//			 }
		 }
		 
	  } 
	
	 
	  private void setAuthCmbPayrMangDeptCd(final Field<?> fldNm,String usrDivCd,String fieldDiv) {
			  
		   if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(usrDivCd)) || (MSFConfiguration.AUTH_USR_DIV_40.equals(usrDivCd))) {
	           //기간제업무담당자- 기간제업무담당자 
		    	   initAuthPayrMangDeptCd(fldNm,fieldDiv,MSFMainApp.get().getUser().getPayrMangDeptCd()); 
	        } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(usrDivCd)) {
	         //무기계약직업무담당자- 무기계약직업무담당자
	            //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size()); 
	        	initAuthPayrMangDeptCd(fldNm,fieldDiv,MSFMainApp.get().getUser().getPayrMangDeptCd()); 
	     	    
	        } else  if (MSFConfiguration.AUTH_USR_DIV_25.equals(usrDivCd)) {
	            //[겸직] 무기계약직및 기간제 동일처리 필요한 부분 
	               //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
	        	 initAuthPayrMangDeptCd(fldNm,fieldDiv,MSFMainApp.get().getUser().getPayrMangDeptCd()); 
	              
	        } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(usrDivCd)) {
	          //무기계약직업무담당자- 무기계약직업무담당자
	        	 initAuthPayrMangDeptCd(fldNm,fieldDiv,MSFMainApp.get().getUser().getPayrMangDeptCd()); 
	        } else  if (MSFConfiguration.AUTH_USR_DIV_60.equals(usrDivCd)) { 
	        	 initAuthPayrMangDeptCd(fldNm,fieldDiv,MSFMainApp.get().getUser().getPayrMangDeptCd()); 
	        } else   { 
	     	   
	        }  
		  }
		
		private void initAuthPayrMangDeptCd(final Field<?> fldNm ,String fieldDiv,String payrMangDeptCd) {
			
		 	 String deptCd = MSFMainApp.get().getUser().getDeptCd();
		 	BaseModel bmSelect = new BaseModel();
		 	
		 	bmSelect = (BaseModel) ((ComboBox) fldNm).getStore().findModel("payrMangDeptCd",payrMangDeptCd); 
            ((ComboBox) fldNm).setValue(bmSelect);   
             
			if (GWT_FILD_COMBOX.equals(fieldDiv)) {//콤보 
			  if (!fldNm.isEnabled()) { 
				    bmSelect = (BaseModel) ((ComboBox) fldNm).getStore().findModel("payrMangDeptCd",payrMangDeptCd); 
 	                ((ComboBox) fldNm).setValue(bmSelect);   
			  } 
			} else  if (GWT_FILD_MULTICOMBOX.equals(fieldDiv)) {//멀티 콤보 
//				 if (!fldNm.isEnabled()) {  
//					 ModelData mdSelect = (ModelData) ((MSFMultiComboBox) fldNm).getStore().findModel("deptCd",deptCd);
//		             if (MSFSharedUtils.paramNotNull(mdSelect)) {
//		                 ((MSFMultiComboBox) fldNm).getListView().setChecked(mdSelect, true); 
//		                 ((MSFMultiComboBox) fldNm).setValue(mdSelect.get("deptNmRtchnt")); 
//		             }    
//				  }  
			 } else  if (GWT_FILD_TEXTFIELD.equals(fieldDiv)) {//텍스트 
//				 if (!fldNm.isEnabled()) {   
//				   if (fldNm.getName().endsWith("eptCd")  ) { 
//		 			 ((TextField) fldNm).setValue(MSFMainApp.get().getUser().getDeptCd());
//		 			 fldNm.fireEvent(Events.Add);
//		 		   } else  if ( fldNm.getName().endsWith("eptNm")) {       
//		 			  ((TextField) fldNm).setValue(MSFMainApp.get().getUser().getDeptNm());
//			       }
//				 }
			 }
			 
		  }
		

		private void setAuthCmbTypOccuCd(final Field<?> fldNm,String usrDivCd,String fieldDiv) {
			  
		   if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(usrDivCd)) || (MSFConfiguration.AUTH_USR_DIV_40.equals(usrDivCd))) {
	           //기간제업무담당자- 기간제업무담당자 
		    	  
	        } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(usrDivCd)) {
	         //무기계약직업무담당자- 무기계약직업무담당자
	            //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size()); 
	        	 initAuthTypOccuCd(fldNm,fieldDiv,""); 
	        	 
	        } else  if (MSFConfiguration.AUTH_USR_DIV_25.equals(usrDivCd)) {
	            //[겸직] 무기계약직및 기간제 동일처리 필요한 부분 
	               //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
	        	 initAuthTypOccuCd(fldNm,fieldDiv,""); 
	              
	        } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(usrDivCd)) {
	          //무기계약직업무담당자- 무기계약직업무담당자
	        	 
	        } else  if (MSFConfiguration.AUTH_USR_DIV_60.equals(usrDivCd)) { 
	        	 
	        } else   { 
	     	   
	        }  
		  }
		

		public void setAuthTypOccuCd(final Field<?> fldNm,String usrDivCd,String fieldDiv,String typOccuCd) {
			  
		   if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(usrDivCd)) || (MSFConfiguration.AUTH_USR_DIV_40.equals(usrDivCd))) {
	           //기간제업무담당자- 기간제업무담당자 
		    	  
	        } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(usrDivCd)) {
	         //무기계약직업무담당자- 무기계약직업무담당자
	            //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size()); 
	        	 initAuthTypOccuCd(fldNm,fieldDiv,typOccuCd); 
	        	 
	        } else  if (MSFConfiguration.AUTH_USR_DIV_25.equals(usrDivCd)) {
	            //[겸직] 무기계약직및 기간제 동일처리 필요한 부분 
	               //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
	        	 initAuthTypOccuCd(fldNm,fieldDiv,typOccuCd); 
	              
	        } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(usrDivCd)) {
	          //무기계약직업무담당자- 무기계약직업무담당자
	        	 
	        } else  if (MSFConfiguration.AUTH_USR_DIV_60.equals(usrDivCd)) { 
	        	 
	        } else   { 
	     	   
	        }  
		  }
		
		private void initAuthTypOccuCd(final Field<?> fldNm ,String fieldDiv,String typOccuCd) {
			
		 	String deptCd = MSFMainApp.get().getUser().getDeptCd();
		 	BaseModel bmSelect = new BaseModel();
		 	 
             
			if (GWT_FILD_COMBOX.equals(fieldDiv)) {//콤보 
			  if (!fldNm.isEnabled()) { 
				   if ("".equals(typOccuCd)) {
					   bmSelect = (BaseModel) ((ComboBox) fldNm).getStore().getAt(0);
					   ((ComboBox) fldNm).setValue(bmSelect);
				   } else {
				    bmSelect = (BaseModel) ((ComboBox) fldNm).getStore().findModel("typOccuCd",typOccuCd); 
 	                ((ComboBox) fldNm).setValue(bmSelect);   
				   }  
			  } 
			} else  if (GWT_FILD_MULTICOMBOX.equals(fieldDiv)) {//멀티 콤보 
				 if (!fldNm.isEnabled()) {  
				   if ("".equals(typOccuCd)) {
					   
					  // List<ModelData> lsMdSelect = (List<ModelData>) ((MSFMultiComboBox) fldNm).getStore().getAt(0);
					   ModelData  mdSelect = ((MSFMultiComboBox) fldNm).getStore().getAt(0); 
	                  // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
	                   //    for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
	                      //     ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
	//                           if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
	                       //        mdSelect = tpMdSelect;
	                           // } 
	                      // }  
					   if (MSFSharedUtils.paramNotNull(mdSelect)) {
	                       ((MSFMultiComboBox) fldNm).getListView().setChecked(mdSelect, true); 
	                       ((MSFMultiComboBox) fldNm).setValue(mdSelect.get("typOccuNm"));
					   }   
	                 //  }
				   } else {
					   List<ModelData> lsMdSelect = (List<ModelData>) ((MSFMultiComboBox) fldNm).getStore().findModels("typOccuCd",typOccuCd);
					   ModelData  mdSelect = null; 
	                   if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
	                       for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
	                           ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
	//                           if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
	                               mdSelect = tpMdSelect;
	                           // } 
	                       }  
	                       if (MSFSharedUtils.paramNotNull(mdSelect)) {
		                       ((MSFMultiComboBox) fldNm).getListView().setChecked(mdSelect, true); 
		                       ((MSFMultiComboBox) fldNm).setValue(mdSelect.get("typOccuNm"));
	                       }
	                   }
				    }
				   
				 }
			 } else  if (GWT_FILD_TEXTFIELD.equals(fieldDiv)) {//텍스트 
//				 if (!fldNm.isEnabled()) {   
//				   if (fldNm.getName().endsWith("eptCd")  ) { 
//		 			 ((TextField) fldNm).setValue(MSFMainApp.get().getUser().getDeptCd());
//		 			 fldNm.fireEvent(Events.Add);
//		 		   } else  if ( fldNm.getName().endsWith("eptNm")) {       
//		 			  ((TextField) fldNm).setValue(MSFMainApp.get().getUser().getDeptNm());
//			       }
//				 }
			 }
			 
		  }
		
		
		private void setAuthCmbDtilOccuClsDivCd(final Field<?> fldNm,String usrDivCd,String fieldDiv) {
			  
			   if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(usrDivCd)) || (MSFConfiguration.AUTH_USR_DIV_40.equals(usrDivCd))) {
		           //기간제업무담당자- 기간제업무담당자 
			    	  
		        } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(usrDivCd)) {
		         //무기계약직업무담당자- 무기계약직업무담당자
		            //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size()); 
		        	 initAuthDtilOccuClsDivCd(fldNm,fieldDiv,""); 
		        	 
		        } else  if (MSFConfiguration.AUTH_USR_DIV_25.equals(usrDivCd)) {
		            //[겸직] 무기계약직및 기간제 동일처리 필요한 부분 
		               //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
		        	 initAuthDtilOccuClsDivCd(fldNm,fieldDiv,""); 
		              
		        } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(usrDivCd)) {
		          //무기계약직업무담당자- 무기계약직업무담당자
		        	 
		        } else  if (MSFConfiguration.AUTH_USR_DIV_60.equals(usrDivCd)) { 
		        	 
		        } else   { 
		     	   
		        }  
			  }
		
		 public void setAuthDtilOccuClsDivCd(final Field<?> fldNm,String usrDivCd,String fieldDiv,String dtilOccuClsDivCd) {
			  
			   if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(usrDivCd)) || (MSFConfiguration.AUTH_USR_DIV_40.equals(usrDivCd))) {
		           //기간제업무담당자- 기간제업무담당자 
			    	  
		        } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(usrDivCd)) {
		         //무기계약직업무담당자- 무기계약직업무담당자
		            //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size()); 
		        	 initAuthDtilOccuClsDivCd(fldNm,fieldDiv,dtilOccuClsDivCd); 
		        	 
		        } else  if (MSFConfiguration.AUTH_USR_DIV_25.equals(usrDivCd)) {
		            //[겸직] 무기계약직및 기간제 동일처리 필요한 부분 
		               //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
		        	 initAuthDtilOccuClsDivCd(fldNm,fieldDiv,dtilOccuClsDivCd); 
		              
		        } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(usrDivCd)) {
		          //무기계약직업무담당자- 무기계약직업무담당자
		        	 
		        } else  if (MSFConfiguration.AUTH_USR_DIV_60.equals(usrDivCd)) { 
		        	 
		        } else   { 
		     	   
		        }  
			  }
			
			private void initAuthDtilOccuClsDivCd(final Field<?> fldNm ,String fieldDiv,String dtilOccuClsDivCd) {
				
			    String deptCd = MSFMainApp.get().getUser().getDeptCd();
			 	BaseModel bmSelect = new BaseModel();
			 	 
	             
				if (GWT_FILD_COMBOX.equals(fieldDiv)) {//콤보 
				  if (!fldNm.isEnabled()) { 
					  if ("".equals(dtilOccuClsDivCd)) {
						   bmSelect = (BaseModel) ((ComboBox) fldNm).getStore().getAt(0);
						   ((ComboBox) fldNm).setValue(bmSelect);
					   } else {
						    bmSelect = (BaseModel) ((ComboBox) fldNm).getStore().findModel("dtilOccuInttnCd",dtilOccuClsDivCd); 
		 	                ((ComboBox) fldNm).setValue(bmSelect);   
					   }
				  } 
				} else  if (GWT_FILD_MULTICOMBOX.equals(fieldDiv)) {//멀티 콤보 
					 if (!fldNm.isEnabled()) {  
						 if ("".equals(dtilOccuClsDivCd)) {
							// List<ModelData> lsMdSelect = (List<ModelData>) ;
							   ModelData  mdSelect = ((MSFMultiComboBox) fldNm).getStore().getAt(0); 
			                //   if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
			                  //     for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
			                  //         ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//			                           if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
			                       //        mdSelect = tpMdSelect;
			                           // } 
			                      // }  
							   if (MSFSharedUtils.paramNotNull(mdSelect)) {
			                       ((MSFMultiComboBox) fldNm).getListView().setChecked(mdSelect, true); 
			                       ((MSFMultiComboBox) fldNm).setValue(mdSelect.get("dtilOccuClsNm"));
							   }    
			                 //  } 
						 } else {
							 List<ModelData> lsMdSelect = (List<ModelData>) ((MSFMultiComboBox) fldNm).getStore().findModels("dtilOccuInttnCd",dtilOccuClsDivCd);
							   ModelData  mdSelect = null; 
			                   if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
			                       for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
			                           ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//			                           if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
			                               mdSelect = tpMdSelect;
			                           // } 
			                       }  
			                       if (MSFSharedUtils.paramNotNull(mdSelect)) {
				                       ((MSFMultiComboBox) fldNm).getListView().setChecked(mdSelect, true); 
				                       ((MSFMultiComboBox) fldNm).setValue(mdSelect.get("dtilOccuClsNm"));
			                       }
			                   } 
						 }
					   
					  }  
				 } else  if (GWT_FILD_TEXTFIELD.equals(fieldDiv)) {//텍스트 
//					 if (!fldNm.isEnabled()) {   
//					   if (fldNm.getName().endsWith("eptCd")  ) { 
//			 			 ((TextField) fldNm).setValue(MSFMainApp.get().getUser().getDeptCd());
//			 			 fldNm.fireEvent(Events.Add);
//			 		   } else  if ( fldNm.getName().endsWith("eptNm")) {       
//			 			  ((TextField) fldNm).setValue(MSFMainApp.get().getUser().getDeptNm());
//				       }
//					 }
				 }
				 
			  }
			
	  /**
	 * <pre>
	 * 1. 개요 : 필드 객체를 리스트에 담은 메서드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : addFieldList
	 * @date : Nov 27, 2015
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Nov 27, 2015		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param fldArr 필드객체 배열 
	 * @return List<Field<?>>
	 */ 	
//	public final List<Field<?>> addFieldList(final Field<?>[] fldArr) {
//			  
//			  List<Field<?>> fldArrField = null;
//			  
//			  for(int iCnt=0; iCnt < fldArr.length;iCnt++) {
//				  fldArrField.add(fldArr[iCnt]);
//			  }
//			  
//			  return fldArrField;
//			  
//	  }
	
//    public  void formAuthConfig(Component cmp, String payrMangDeptCd, String emymtDivCd, String deptCd,String typOccuCd ,String businCd) {
//        formAuthConfig( cmp,  payrMangDeptCd,  emymtDivCd,  deptCd, typOccuCd,"", businCd);
//    }
//    /**
//     * 보내는값 - formPanel, 고용구분, 부서코드,직종코드,사업코드
//     * @param cmp
//     * @param fieldName
//     */
//    @SuppressWarnings("rawtypes")
//    public   void formAuthConfig(Component cmp, String payrMangDeptCd, String emymtDivCd, String deptCd,String typOccuCd,String dtilOccuClsDivCd,String businCd) {
//      /**
//       * D0010010   D001    0010    무기계약직업무담당자 //무기계약직업무담당자 중 환경미환원인경우 처리를 위해 추가된 부분 처리 ...
//        D0010020    D001    0020    기간제업무담당자
//         public static final String AUTH_USR_DIV_25 = "D0010025";  //  D001    0025    [겸직]무기계약직기간제담당자
//        D0010030    D001    0030    무기계약직총괄업무담당자
//        
//        D0010040    D001    0040    기간제총괄업무담당자
//        D0010040    D001    0050    공통업무담당자 - 기초및 공통설정업무를 담당  --추가예정
//        D0010040    D001    0060    통합업무담당자 - 전체업무권한 담당자.    --설정(인사급여)
//        D0010070    D001    0070    무기계약직근로자
//        D0010080    D001    0080    기간제근로자
//        D0010090    D001    0090    시스템마스터관리자
//       */
//        //if ( cmp==null || MSFSharedUtils.paramNull(emymtDivCd) ) {
//        if ( MSFSharedUtils.paramNull(cmp)) {
//            return ;
//        }
//      
//        if ( cmp instanceof FormPanel ) {  
//            
//            if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
//                //기간제업무담당자- 기간제업무담당자
//                   //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
//                              for (Field<?>  f : ((FormPanel) cmp).getFields()) {
//                               
//                                  if (f instanceof ComboBox<?>) {
//                                      //고용구분
//                                      if (emymtDivCd.equals(f.getName())) {
//                                       f.setEnabled(false);
//                                       GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                      
//                                       BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD02); 
//                                       ((ComboBox) f).setValue(bmSelect);
//                                      //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                      } else if (deptCd.equals(f.getName())) {
//                                       //부서 
//                                          f.setEnabled(false);
//                                          BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                          ((ComboBox) f).setValue(bmSelect); 
//                                      } else if (typOccuCd.equals(f.getName())) {
//                                          //직종
//                                          f.setEnabled(false);
//                                      } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                          //직종세
//                                          f.setEnabled(false);
//                                      } else if (payrMangDeptCd.equals(f.getName())) {
//                                          //단위기관 
//                                          f.setEnabled(false);
//                                          BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                          ((ComboBox) f).setValue(bmSelect); 
//                                      }
//                                      //else if (businCd.equals(f.getName())) {
//                                          //사업
//                                       //   f.setEnabled(false);
//                                      //}
//                                      
//                                  } else  if (f instanceof MSFMultiComboBox<?>) {
//                                      if (deptCd.equals(f.getName())) {
//                                          //부서 
//                                            f.setEnabled(false); 
//                                            ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                            if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                                ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                                ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                            }    
//                                         } else if (typOccuCd.equals(f.getName())) {
//                                             //직종
//                                             f.setEnabled(false);
//                                         } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                             //직종세
//                                             f.setEnabled(false);
//                                         } 
//                                  } else  if (f instanceof TextField<?>) {
//                                      //부서가 텍스트 인경우 처리 ..
//                                      if (deptCd.equals(f.getName())) {
//                                          //부서 
//                                            // f.setEnabled(false);
//                                            // BaseModel bmSelect = (BaseModel) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                           //  ((ComboBox) f).setValue(bmSelect); 
//                                         } 
//                                    //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                                  }
//                                 
//                                  
//                              }
//               } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//                //무기계약직업무담당자- 무기계약직업무담당자
//                   //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
//                   if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                           && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
//                 
//                      
//                        for (Field<?>  f : ((FormPanel) cmp).getFields()) {
//                            
//                            if (f instanceof ComboBox<?>) {
//                                //고용구분
//                                if (emymtDivCd.equals(f.getName())) {
//                                 f.setEnabled(false);
//                                 GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                
//                                 BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                 ((ComboBox) f).setValue(bmSelect);
//                                //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                } else if (deptCd.equals(f.getName())) {
//                                 //부서 - 단위부서 및 관리부서에 따른 처리 필요 확인. 
//                                    f.setEnabled(false); 
//                                    BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                    ((ComboBox) f).setValue(bmSelect); 
//                                } else if (typOccuCd.equals(f.getName())) {
//                                    //직종
//                                    BaseModel  bmSelect = new BaseModel();
//                                    f.setEnabled(false); 
//                                    List<BaseModel> bmSelects = (List<BaseModel>) ((ComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd()); 
//                                    
//                                    for(int iTyCnt = 0;iTyCnt < bmSelects.size();iTyCnt++){
//                                        BaseModel tpBmSelect = new BaseModel();
//                                        tpBmSelect = bmSelects.get(iTyCnt);
//                                        if (tpBmSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                             bmSelect = tpBmSelect;
//                                        } 
//                                    }  
//                                    ((ComboBox) f).setValue(bmSelect); 
//                                } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                    //직종세
//                                    f.setEnabled(false);      
//                                } else if (businCd.equals(f.getName())) {
//                                    //사업
//                                    f.setEnabled(false);
//                                } else if (payrMangDeptCd.equals(f.getName())) {
//                                    //단위기관 
//                                    f.setEnabled(false);
//                                    BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                    ((ComboBox) f).setValue(bmSelect); 
//                                }
//                            } else  if (f instanceof MSFMultiComboBox<?>) {
//                                if (deptCd.equals(f.getName())) {
//                                    //부서 
//                                      f.setEnabled(false); 
//                                      ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                      if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                          ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                          ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                      }    
//                                   } else if (typOccuCd.equals(f.getName())) {
//                                       //직종 
//                                       f.setEnabled(false); 
//                                       ModelData  mdSelect = null; 
//                                       List<ModelData> lsMdSelect = (List<ModelData>) ((MSFMultiComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd());
//                                       
//                                       if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//                                           for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//                                               ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//                                               if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                   mdSelect = tpMdSelect;
//                                               } 
//                                           }  
//                                       
//                                           ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                           ((MSFMultiComboBox) f).setValue(mdSelect.get("typOccuNm"));
//                                       } 
//                                       
//                                   } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                       //직종세
//                                       f.setEnabled(false);      
//                                   }    
//                            } else  if (f instanceof TextField<?>) {
//                              //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                            }  
//                        }
//                        
//                    } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                              && (!MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))
//                            ) {
//                        // 다른 직종인 경우에도 처리를 위해 추가 함. 
//                        for (Field<?>  f : ((FormPanel) cmp).getFields()) {
//                            
//                            if (f instanceof ComboBox<?>) {
//                                //고용구분
//                                if (emymtDivCd.equals(f.getName())) {
//                                 f.setEnabled(false);
//                                 GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                
//                                 BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                 ((ComboBox) f).setValue(bmSelect);
//                                //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                } else if (deptCd.equals(f.getName())) {
//                                 //부서 - 단위부서 및 관리부서에 따른 처리 필요 확인. 
//                                    f.setEnabled(false);
//                                    BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                    ((ComboBox) f).setValue(bmSelect); 
//                                } else if (typOccuCd.equals(f.getName())) {
//                                    //직종
//                                    BaseModel  bmSelect = new BaseModel();
//                                    f.setEnabled(false); 
//                                    List<BaseModel> bmSelects = (List<BaseModel>) ((ComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd()); 
//                                    
//                                    for(int iTyCnt = 0;iTyCnt < bmSelects.size();iTyCnt++){
//                                        BaseModel tpBmSelect = new BaseModel();
//                                        tpBmSelect = bmSelects.get(iTyCnt);
//                                        if (tpBmSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                             bmSelect = tpBmSelect;
//                                        } 
//                                    }  
//                                    ((ComboBox) f).setValue(bmSelect); 
//                                } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                    //직종세
//                                    f.setEnabled(false);    
//                                } else if (businCd.equals(f.getName())) {
//                                    //사업
//                                    f.setEnabled(false);
//                                } else if (payrMangDeptCd.equals(f.getName())) {
//                                    //단위기관 
//                                    f.setEnabled(false);
//                                    BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                    ((ComboBox) f).setValue(bmSelect); 
//                                }
//                            } else  if (f instanceof MSFMultiComboBox<?>) {
//                                if (deptCd.equals(f.getName())) {
//                                    //부서 
//                                      f.setEnabled(false); 
//                                      ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                      if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                          ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                          ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                      }    
//                                   } else if (typOccuCd.equals(f.getName())) {
//                                       //직종 
//                                       f.setEnabled(false); 
//                                       ModelData  mdSelect = null; 
//                                       List<ModelData> lsMdSelect = (List<ModelData>) ((MSFMultiComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd());
//                                       
//                                       if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//                                           for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//                                               ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//                                               if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                   mdSelect = tpMdSelect;
//                                               } 
//                                           }  
//                                       
//                                           ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                           ((MSFMultiComboBox) f).setValue(mdSelect.get("typOccuNm"));
//                                       } 
//                                       
//                                   } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                       //직종세
//                                       f.setEnabled(false);      
//                                   }    
//                            } else  if (f instanceof TextField<?>) {
//                              //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                            }  
//                        }
//                        
//                        
//                    } else {
//                          for (Field<?>  f : ((FormPanel) cmp).getFields()) {
//                           
//                              if (f instanceof ComboBox<?>) {
//                                  //고용구분
//                                  if (emymtDivCd.equals(f.getName())) {
//                                   f.setEnabled(false);
//                                   GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                  
//                                   BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                   ((ComboBox) f).setValue(bmSelect);
//                                  //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                  } else if (deptCd.equals(f.getName())) {
//                                   //부서 - 단위부서 및 관리부서에 따른 처리 필요 확인. 
//                                     // f.setEnabled(false); 
//                                      BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                      ((ComboBox) f).setValue(bmSelect); 
////                                      } else if (typOccuCd.equals(f.getName())) {
////                                          //직종
////                                          f.setEnabled(false);
////                                      }
//                                  } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                      //직종세
//                                    //  f.setEnabled(false);    
//                                  } else if (businCd.equals(f.getName())) {
//                                      //사업
//                                      f.setEnabled(false);
//                                  } else if (payrMangDeptCd.equals(f.getName())) {
//                                      //단위기관 
//                                      f.setEnabled(false);
//                                      BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                      ((ComboBox) f).setValue(bmSelect); 
//                                  }
//                              } else  if (f instanceof MSFMultiComboBox<?>) {
//                                  if (deptCd.equals(f.getName())) {
//                                      //부서 
//                                      //  f.setEnabled(false); 
//                                        ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                        if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                            ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                            ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                        }    
//                                     } else if (typOccuCd.equals(f.getName())) {
//                                         //직종 
//                                         f.setEnabled(false); 
//                                         ModelData  mdSelect = null; 
//                                         List<ModelData> lsMdSelect = (List<ModelData>) ((MSFMultiComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd());
//                                         
//                                         if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//                                             for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//                                                 ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//                                                 if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                     mdSelect = tpMdSelect;
//                                                 } 
//                                             }  
//                                         
//                                             ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                             ((MSFMultiComboBox) f).setValue(mdSelect.get("typOccuNm"));
//                                         } 
//                                         
//                                     } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                         //직종세
//                                         f.setEnabled(true);      
//                                     }    
//                              } else  if (f instanceof TextField<?>) {
//                                //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                              }
//    
//                          }
//                    }
//               } else  if (MSFConfiguration.AUTH_USR_DIV_25.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//                   //[겸직] 무기계약직및 기간제 동일처리 필요한 부분 
//                      //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
//                      if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                              && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
//                     
//                           for (Field<?>  f : ((FormPanel) cmp).getFields()) {
//                               
//                               if (f instanceof ComboBox<?>) {
//                                   //고용구분
//                                   if (emymtDivCd.equals(f.getName())) {
//                                   // f.setEnabled(false);
//                                    GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                   
//                                    BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                    ((ComboBox) f).setValue(bmSelect);
//                                   //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                   } else if (deptCd.equals(f.getName())) {
//                                    //부서 - 단위부서 및 관리부서에 따른 처리 필요 확인. 
//                                       f.setEnabled(false);
//                                       BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                       ((ComboBox) f).setValue(bmSelect); 
//                                   } else if (typOccuCd.equals(f.getName())) {
//                                       //직종
//                                       BaseModel  bmSelect = new BaseModel();
//                                       f.setEnabled(false); 
//                                       List<BaseModel> bmSelects = (List<BaseModel>) ((ComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd()); 
//                                       
//                                       for(int iTyCnt = 0;iTyCnt < bmSelects.size();iTyCnt++){
//                                           BaseModel tpBmSelect = new BaseModel();
//                                           tpBmSelect = bmSelects.get(iTyCnt);
//                                           if (tpBmSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                bmSelect = tpBmSelect;
//                                           } 
//                                       }  
//                                       ((ComboBox) f).setValue(bmSelect); 
//                                   } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                       //직종세
//                                       f.setEnabled(false);     
//                                   } else if (businCd.equals(f.getName())) {
//                                       //사업
//                                       f.setEnabled(false);
//                                   } else if (payrMangDeptCd.equals(f.getName())) {
//                                       //단위기관 
//                                       f.setEnabled(false);
//                                       BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                       ((ComboBox) f).setValue(bmSelect); 
//                                   }
//                               } else  if (f instanceof MSFMultiComboBox<?>) {
//                                   if (deptCd.equals(f.getName())) {
//                                       //부서 
//                                         f.setEnabled(false); 
//                                         ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                         if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                             ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                             ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                         }    
//                                      } else if (typOccuCd.equals(f.getName())) {
//                                          //직종 
//                                          f.setEnabled(false); 
//                                          ModelData  mdSelect = null; 
//                                          List<ModelData> lsMdSelect = (List<ModelData>) ((MSFMultiComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd());
//                                          if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//                                              for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//                                                  ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//                                                  if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                      mdSelect = tpMdSelect;
//                                                  } 
//                                              }  
//                                          
//                                              ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                              ((MSFMultiComboBox) f).setValue(mdSelect.get("typOccuNm"));
//                                          } 
//                                      } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                          //직종세
//                                          f.setEnabled(false);      
//                                      }     
//                               } else  if (f instanceof TextField<?>) {
//                                 //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                               }  
//                           }
//                           
//                       } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                                 && (!MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))
//                               ) {
//                           // 다른 직종인 경우에도 처리를 위해 추가 함. 
//                           for (Field<?>  f : ((FormPanel) cmp).getFields()) {
//                               
//                               if (f instanceof ComboBox<?>) {
//                                   //고용구분
//                                   if (emymtDivCd.equals(f.getName())) {
//                                   // f.setEnabled(false);
//                                    GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                   
//                                    BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                    ((ComboBox) f).setValue(bmSelect);
//                                   //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                   } else if (deptCd.equals(f.getName())) {
//                                    //부서 - 단위부서 및 관리부서에 따른 처리 필요 확인. 
//                                       f.setEnabled(false);
//                                       BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                       ((ComboBox) f).setValue(bmSelect); 
//                                   } else if (typOccuCd.equals(f.getName())) {
//                                       //직종
//                                       BaseModel  bmSelect = new BaseModel();
//                                       f.setEnabled(false); 
//                                       List<BaseModel> bmSelects = (List<BaseModel>) ((ComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd()); 
//                                       
//                                       for(int iTyCnt = 0;iTyCnt < bmSelects.size();iTyCnt++){
//                                           BaseModel tpBmSelect = new BaseModel();
//                                           tpBmSelect = bmSelects.get(iTyCnt);
//                                           if (tpBmSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                bmSelect = tpBmSelect;
//                                           } 
//                                       }  
//                                       ((ComboBox) f).setValue(bmSelect); 
//                                   } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                       //직종세
//                                       f.setEnabled(false);     
//                                   } else if (businCd.equals(f.getName())) {
//                                       //사업
//                                       f.setEnabled(false);
//                                   } else if (payrMangDeptCd.equals(f.getName())) {
//                                       //단위기관 
//                                       f.setEnabled(false);
//                                       BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                       ((ComboBox) f).setValue(bmSelect); 
//                                   }
//                               } else  if (f instanceof MSFMultiComboBox<?>) {
//                                   if (deptCd.equals(f.getName())) {
//                                       //부서 
//                                         f.setEnabled(false); 
//                                         ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                         if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                             ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                             ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                         }    
//                                      }  else if (typOccuCd.equals(f.getName())) {
//                                          //직종 
//                                          f.setEnabled(false); 
//                                          ModelData  mdSelect = null; 
//                                          List<ModelData> lsMdSelect = (List<ModelData>) ((MSFMultiComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd());
//                                          if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//                                              for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//                                                  ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//                                                  if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                      mdSelect = tpMdSelect;
//                                                  } 
//                                              }  
//                                          
//                                              ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                              ((MSFMultiComboBox) f).setValue(mdSelect.get("typOccuNm"));
//                                          } 
//                                      } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                          //직종세
//                                          f.setEnabled(false);      
//                                      }  
//                               } else  if (f instanceof TextField<?>) {
//                                 //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                               }  
//                           }
//                           
//                           
//                       } else {
//                             for (Field<?>  f : ((FormPanel) cmp).getFields()) {
//                              
//                                 if (f instanceof ComboBox<?>) {
//                                     //고용구분
//                                     if (emymtDivCd.equals(f.getName())) {
//                                     // f.setEnabled(false);
//                                      GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                     
//                                      BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                      ((ComboBox) f).setValue(bmSelect);
//                                     //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                     } else if (deptCd.equals(f.getName())) {
//                                      //부서 - 단위부서 및 관리부서에 따른 처리 필요 확인. 
//                                        // f.setEnabled(false); 
//                                         BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                         ((ComboBox) f).setValue(bmSelect); 
////                                         } else if (typOccuCd.equals(f.getName())) {
////                                             //직종
////                                             f.setEnabled(false);
////                                         }
//                                    // } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                         //직종세
//                                     //    f.setEnabled(false);
//                                     } else if (businCd.equals(f.getName())) {
//                                         //사업
//                                         f.setEnabled(false);
//                                     } else if (payrMangDeptCd.equals(f.getName())) {
//                                         //단위기관 
//                                         f.setEnabled(false);
//                                         BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                         ((ComboBox) f).setValue(bmSelect); 
//                                     }
//                                 } else  if (f instanceof MSFMultiComboBox<?>) {
//                                     if (deptCd.equals(f.getName())) {
//                                         //부서 
//                                       //    f.setEnabled(false); 
//                                           ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                           if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                               ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                               ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                           }    
//                                        }      
//                                 } else  if (f instanceof TextField<?>) {
//                                   //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                                 }
//       
//                             }
//                       }       
//              } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//                //무기계약직업무담당자- 무기계약직업무담당자
//                
//                              for (Field<?>  f : ((FormPanel) cmp).getFields()) {
//                               
//                                  if (f instanceof ComboBox<?>) {
//                                      //고용구분
//                                      if (emymtDivCd.equals(f.getName())) {
//                                       f.setEnabled(false);
//                                       GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                      
//                                       BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                       ((ComboBox) f).setValue(bmSelect);
//                                      //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                      } else if (deptCd.equals(f.getName())) {
//                                       //부서 - 단위부서 및 관리부서에 따른 처리 필요 확인. 
//                                         // f.setEnabled(false);
//                                         // BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                         // ((ComboBox) f).setValue(bmSelect); 
////                                      } else if (typOccuCd.equals(f.getName())) {
////                                          //직종
////                                          f.setEnabled(false);
////                                      }
//                                     // } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                          //직종세
//                                      //    f.setEnabled(false);     
//                                      } else if (businCd.equals(f.getName())) {
//                                          //사업
//                                          f.setEnabled(false);
//                                      } else if (payrMangDeptCd.equals(f.getName())) {
//                                          //단위기관 
//                                        //  f.setEnabled(false);
//                                          BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                          ((ComboBox) f).setValue(bmSelect); 
//                                      }
//                                  } else  if (f instanceof MSFMultiComboBox<?>) {
////                                      if (deptCd.equals(f.getName())) {
////                                          //부서 
////                                            f.setEnabled(false); 
////                                            ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
////                                             if (MSFSharedUtils.paramNotNull(mdSelect)) {
////                                      ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
////                                      ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
////                                  }    
////                                         }     
//                                  } else  if (f instanceof TextField<?>) {
//                                    //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                                  }
//                                 
//        
//                              } 
//              } else  if (MSFConfiguration.AUTH_USR_DIV_60.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//                  //무기계약직업무담당자- 무기계약직업무담당자
//                  
//                                for (Field<?>  f : ((FormPanel) cmp).getFields()) {
//                                 
//                                    if (f instanceof ComboBox<?>) {
//                                        //고용구분
//                                        if (emymtDivCd.equals(f.getName())) {
//                                        // f.setEnabled(false);
//                                         GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                        
//                                         BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                         ((ComboBox) f).setValue(bmSelect);
//                                        //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                        } else if (deptCd.equals(f.getName())) {
//                                         //부서 - 단위부서 및 관리부서에 따른 처리 필요 확인. 
//                                           // f.setEnabled(false);
//                                           // BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                           // ((ComboBox) f).setValue(bmSelect); 
////                                        } else if (typOccuCd.equals(f.getName())) {
////                                            //직종
////                                            f.setEnabled(false);
////                                        }
//                                       // } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                            //직종세
//                                        //    f.setEnabled(false);     
//                                        //} else if (businCd.equals(f.getName())) {
//                                            //사업
//                                        //    f.setEnabled(false);
//                                        } else if (payrMangDeptCd.equals(f.getName())) {
//                                            //단위기관 
//                                         //   f.setEnabled(false);
//                                            BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                            ((ComboBox) f).setValue(bmSelect); 
//                                        }
//                                    } else  if (f instanceof MSFMultiComboBox<?>) {
////                                        if (deptCd.equals(f.getName())) {
////                                            //부서 
////                                              f.setEnabled(false); 
////                                              ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
////                                               if (MSFSharedUtils.paramNotNull(mdSelect)) {
////                                        ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
////                                        ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
////                                    }    
////                                           }     
//                                    } else  if (f instanceof TextField<?>) {
//                                      //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                                    }
//                                   
//          
//                                }                
//               }
// 
//        } 
//    }
//    
//    @SuppressWarnings("rawtypes")
//    public    void formAuthPopConfig(Component cmp, String payrMangDeptCd, String emymtDivCd, String[] deptCd,String typOccuCd,String businCd) {
//        formAuthPopConfig(cmp, payrMangDeptCd, emymtDivCd, deptCd, typOccuCd,"", businCd);
//    }
//    /**
//     * 보내는값 - formPanel, 고용구분, 부서코드,직종코드,사업코드
//     * @param cmp
//     * @param fieldName
//     */
//    @SuppressWarnings("rawtypes")
//    public    void formAuthPopConfig(Component cmp, String payrMangDeptCd, String emymtDivCd, String[] deptCd,String typOccuCd,String dtilOccuClsDivCd, String businCd) {
//      /**
//       * D0010010   D001    0010    무기계약직업무담당자 //무기계약직업무담당자 중 환경미환원인경우 처리를 위해 추가된 부분 처리 ...
//        D0010020    D001    0020    기간제업무담당자
//        D0010030    D001    0030    무기계약직총괄업무담당자
//        D0010040    D001    0040    기간제총괄업무담당자
//        D0010040    D001    0050    공통업무담당자 - 기초및 공통설정업무를 담당  --추가예정
//        D0010040    D001    0060    통합업무담당자 - 전체업무권한 담당자.    --설정(인사급여)
//        D0010070    D001    0070    무기계약직근로자
//        D0010080    D001    0080    기간제근로자
//        D0010090    D001    0090    시스템마스터관리자
//       */
//       
//       // if ( cmp==null || MSFSharedUtils.paramNull(emymtDivCd) ) {
//        if ( MSFSharedUtils.paramNull(cmp) ) {
//            return ;
//        }
//       
//        if ( cmp instanceof FormPanel ) {  
//          
//            if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
//                //기간제업무담당자- 기간제업무담당자
//                   //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
//                              for (Field<?>  f : ((FormPanel) cmp).getFields()) {
//                               
//                                  if (f instanceof ComboBox<?>) {
//                                      //고용구분
//                                      if (emymtDivCd.equals(f.getName())) {
//                                       f.setEnabled(false);
//                                       GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount()); 
//                                       BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD02); 
//                                       ((ComboBox) f).setValue(bmSelect);
//                                      //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                      } else if (typOccuCd.equals(f.getName())) {
//                                          //직종
//                                          f.setEnabled(false);
//                                      } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                          //직종세
//                                          f.setEnabled(false);
//                                      }  else if (payrMangDeptCd.equals(f.getName())) {
//                                          //단위기관 
//                                          f.setEnabled(false);
//                                          BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                          ((ComboBox) f).setValue(bmSelect); 
//                                      }
//                                      //else if (businCd.equals(f.getName())) {
//                                          //사업
//                                       //   f.setEnabled(false);
//                                      //}
//                                      
//                                  } else  if (f instanceof TextField<?>) {
//                                      //부서가 텍스트 인경우 처리 ..
//                                   if (deptCd[0].equals(f.getName())) {
//                                      //부서 
//                                         for (int iCnt = 0; iCnt < deptCd.length;iCnt++) {
//                                              
//                                             for (Field<?>  suf : ((FormPanel) cmp).getFields()) {
//                                                 if (suf instanceof TextField<?>) {
//                                                     
//                                                     if (deptCd[iCnt].equals(suf.getName())) { 
//                                                         suf.setEnabled(false); 
//                                                         if (deptCd[iCnt].endsWith("Cd")) {
//                                                             ((TextField) suf).setValue(MSFMainApp.get().getUser().getDeptCd());
//                                                             suf.fireEvent(Events.Add);
//                                                         } else if (deptCd[iCnt].endsWith("Nm")) {
//                                                             ((TextField) suf).setValue(MSFMainApp.get().getUser().getDeptNm());
//                                                         } 
//                                                     }
//                                                    
//                                                 }
//                                             }
//                                         }
//                                       
//                                   } 
//                                    //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                                  }
//                                 
//                                  
//                              }
//               } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//                //무기계약직업무담당자- 무기계약직업무담당자
//                  
//                   //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
//                   if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                           && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
//                      
//                        for (Field<?>  f : ((FormPanel) cmp).getFields()) {
//                       
//                            if (f instanceof ComboBox<?>) {
//                                //고용구분
//                                if (emymtDivCd.equals(f.getName())) {
//                                 f.setEnabled(false);
//                                 GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                
//                                 BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                 ((ComboBox) f).setValue(bmSelect);
//                                //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                }  else if (typOccuCd.equals(f.getName())) {
//                                    //직종
//                                	 
//                                    BaseModel  bmSelect = new BaseModel();
//                                    f.setEnabled(false); 
//                                    List<BaseModel> bmSelects = (List<BaseModel>) ((ComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd()); 
//                                    
//                                    for(int iTyCnt = 0;iTyCnt < bmSelects.size();iTyCnt++){
//                                        BaseModel tpBmSelect = new BaseModel();
//                                        tpBmSelect = bmSelects.get(iTyCnt);
//                                        if (tpBmSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                             bmSelect = tpBmSelect;
//                                        } 
//                                    }  
//                                    
//                                    if (MSFSharedUtils.paramNotNull(bmSelect)) {
//                                    	
//                                    	bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("typOccuCd",(MSFMainApp.get().getUser().getTypOccuCd().concat("!").concat(MSFMainApp.get().getUser().getPyspGrdeCd()))); 
//                                         
//                                    }
//                                    
//                                    
//                                    ((ComboBox) f).setValue(bmSelect); 
//                                    
//                                } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                    //직종세
//                                    f.setEnabled(false);
//                                } else if (businCd.equals(f.getName())) {
//                                    //사업
//                                    f.setEnabled(false);
//                                } else if (payrMangDeptCd.equals(f.getName())) {
//                                    //단위기관 
//                                    f.setEnabled(false);
//                                    BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                    ((ComboBox) f).setValue(bmSelect); 
//                                }
//                                
//                            } else  if (f instanceof MSFMultiComboBox<?>) {
//                                 if (deptCd.equals(f.getName())) {
//                                    //부서 
//                                      f.setEnabled(false); 
//                                      ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                      if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                          ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                          ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                      }    
//                                   }  else if (typOccuCd.equals(f.getName())) {
//                                       //직종 
//                                       f.setEnabled(false); 
//                                       ModelData  mdSelect = null; 
//                                       List<ModelData> lsMdSelect = (List<ModelData>) ((MSFMultiComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd());
//                                       
//                                       if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//                                           for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//                                               ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//                                               if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                   mdSelect = tpMdSelect;
//                                               } 
//                                           }  
//                                       
//                                           ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                           ((MSFMultiComboBox) f).setValue(mdSelect.get("typOccuNm"));
//                                       } 
//                                   } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                       //직종세
//                                       f.setEnabled(false);      
//                                   }       
//                                
//                            } else  if (f instanceof TextField<?>) {
//                               
//                                if (deptCd[0].equals(f.getName())) {
//                                    //부서 
//                                    
//                                       for (int iCnt = 0; iCnt < deptCd.length;iCnt++) {
//                                           for (Field<?>  suf : ((FormPanel) cmp).getFields()) {
//                                               if (suf instanceof TextField<?>) {
//                                                   
//                                                   if (deptCd[iCnt].equals(suf.getName())) { 
//                                                       suf.setEnabled(false); 
//                                                       if (deptCd[iCnt].endsWith("Cd")) {
//                                                           ((TextField) suf).setValue(MSFMainApp.get().getUser().getDeptCd());
//                                                       } else if (deptCd[iCnt].endsWith("Nm")) {
//                                                           ((TextField) suf).setValue(MSFMainApp.get().getUser().getDeptNm());
//                                                       } 
//                                                   }
//                                                  
//                                               }
//                                           }
//                                       }
//                                 }    
//                              //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                            }  
//                        }
//                        
//                    } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                              && (!MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))
//                            ) {
//                        // 다른 직종인 경우에도 처리를 위해 추가 함. 
//                        for (Field<?>  f : ((FormPanel) cmp).getFields()) {
//                            
//                            if (f instanceof ComboBox<?>) {
//                                //고용구분
//                                if (emymtDivCd.equals(f.getName())) {
//                                 f.setEnabled(false);
//                                 GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                
//                                 BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                 ((ComboBox) f).setValue(bmSelect);
//                                //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                }  else if (typOccuCd.equals(f.getName())) {
//                                    //직종
//                                    BaseModel  bmSelect = new BaseModel();
//                                    f.setEnabled(false); 
//                                    List<BaseModel> bmSelects = (List<BaseModel>) ((ComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd()); 
//                                    
//                                    for(int iTyCnt = 0;iTyCnt < bmSelects.size();iTyCnt++){
//                                        BaseModel tpBmSelect = new BaseModel();
//                                        tpBmSelect = bmSelects.get(iTyCnt);
//                                        if (tpBmSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                             bmSelect = tpBmSelect;
//                                        } 
//                                    }   
//                                    
//                                    if (MSFSharedUtils.paramNotNull(bmSelect)) {
//                                    	
//                                    	bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("typOccuCd",(MSFMainApp.get().getUser().getTypOccuCd().concat("!").concat(MSFMainApp.get().getUser().getPyspGrdeCd()))); 
//                                         
//                                    }
//                                    
//                                    ((ComboBox) f).setValue(bmSelect); 
//                                    
//                                } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                    //직종세
//                                    f.setEnabled(false);
//                                } else if (businCd.equals(f.getName())) {
//                                    //사업
//                                    f.setEnabled(false);
//                                } else if (payrMangDeptCd.equals(f.getName())) {
//                                    //단위기관 
//                                    f.setEnabled(false);
//                                    BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                    ((ComboBox) f).setValue(bmSelect); 
//                                }
//                            } else  if (f instanceof MSFMultiComboBox<?>) {
//                                if (deptCd.equals(f.getName())) {
//                                    //부서 
//                                      f.setEnabled(false); 
//                                      ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                      if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                          ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                          ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                      }    
//                                   }  else if (typOccuCd.equals(f.getName())) {
//                                       //직종 
//                                       f.setEnabled(false); 
//                                       ModelData  mdSelect = null; 
//                                       List<ModelData> lsMdSelect = (List<ModelData>) ((MSFMultiComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd());
//                                       
//                                       if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//                                           for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//                                               ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//                                               if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                   mdSelect = tpMdSelect;
//                                               } 
//                                           }  
//                                       
//                                           ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                           ((MSFMultiComboBox) f).setValue(mdSelect.get("typOccuNm"));
//                                       } 
//                                       
//                                   } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                       //직종세
//                                       f.setEnabled(false);      
//                                   }      
//                            } else  if (f instanceof TextField<?>) {
//                                if (deptCd[0].equals(f.getName())) {
//                                    //부서 
//                                       for (int iCnt = 0; iCnt < deptCd.length;iCnt++) {
//                                           for (Field<?>  suf : ((FormPanel) cmp).getFields()) {
//                                               if (suf instanceof TextField<?>) {
//                                                   
//                                                   if (deptCd[iCnt].equals(suf.getName())) { 
//                                                       suf.setEnabled(false); 
//                                                     
//                                                       if (deptCd[iCnt].endsWith("Cd")) {
//                                                           ((TextField) suf).setValue(MSFMainApp.get().getUser().getDeptCd());
//                                                       } else if (deptCd[iCnt].endsWith("Nm")) {
//                                                           ((TextField) suf).setValue(MSFMainApp.get().getUser().getDeptNm());
//                                                       } 
//                                                   }
//                                                  
//                                               }
//                                           }
//                                       }
//                                 }    
//                              //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                            }  
//                        }
//                        
//                        
//                    } else {
//                          for (Field<?>  f : ((FormPanel) cmp).getFields()) {
//                           
//                              if (f instanceof ComboBox<?>) {
//                                  //고용구분
//                                  if (emymtDivCd.equals(f.getName())) {
//                                   f.setEnabled(false);
//                                   GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                  
//                                   BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                   ((ComboBox) f).setValue(bmSelect);
//                                  //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                  }   else if (businCd.equals(f.getName())) {
//                                      //사업
//                                      f.setEnabled(false);
//                                  } else if (payrMangDeptCd.equals(f.getName())) {
//                                      //단위기관 
//                                      f.setEnabled(false);
//                                      BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                      ((ComboBox) f).setValue(bmSelect); 
//                                  }
//                                  
//                              } else  if (f instanceof TextField<?>) {
//                                  if (deptCd[0].equals(f.getName())) {
//                                      //부서 
//                                         for (int iCnt = 0; iCnt < deptCd.length;iCnt++) {
//                                             for (Field<?>  suf : ((FormPanel) cmp).getFields()) {
//                                                 if (suf instanceof TextField<?>) {
//                                                     
//                                                     if (deptCd[iCnt].equals(suf.getName())) { 
//                                                        //suf.setEnabled(false);  
//                                                         if (deptCd[iCnt].endsWith("Cd")) {
//                                                             ((TextField) suf).setValue(MSFMainApp.get().getUser().getDeptCd());
//                                                         } else if (deptCd[iCnt].endsWith("Nm")) {
//                                                             ((TextField) suf).setValue(MSFMainApp.get().getUser().getDeptNm());
//                                                         } 
//                                                     }
//                                                    
//                                                 }
//                                             }
//                                         }
//                                   }    
//                                //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                              }
//    
//                          }
//                    }         
//           
//               } else  if (MSFConfiguration.AUTH_USR_DIV_25.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//                   //[겸직] 무기계약직 및 기간제 겸직
//                     
//                      //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
//                      if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                              && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
//                         
//                           for (Field<?>  f : ((FormPanel) cmp).getFields()) {
//                          
//                               if (f instanceof ComboBox<?>) {
//                                   //고용구분
//                                   if (emymtDivCd.equals(f.getName())) {
//                                  //  f.setEnabled(false);
//                                    GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                   
//                                    BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                    ((ComboBox) f).setValue(bmSelect);
//                                   //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                   }  else if (typOccuCd.equals(f.getName())) {
//                                       //직종
//                                       BaseModel  bmSelect = new BaseModel();
//                                       f.setEnabled(false); 
//                                       List<BaseModel> bmSelects = (List<BaseModel>) ((ComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd()); 
//                                       
//                                       for(int iTyCnt = 0;iTyCnt < bmSelects.size();iTyCnt++){
//                                           BaseModel tpBmSelect = new BaseModel();
//                                           tpBmSelect = bmSelects.get(iTyCnt);
//                                           if (tpBmSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                bmSelect = tpBmSelect;
//                                           } 
//                                       } 
//                                       
//                                       if (MSFSharedUtils.paramNotNull(bmSelect)) {
//                                       	
//                                       	bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("typOccuCd",(MSFMainApp.get().getUser().getTypOccuCd().concat("!").concat(MSFMainApp.get().getUser().getPyspGrdeCd()))); 
//                                            
//                                       }
//                                       
//                                       ((ComboBox) f).setValue(bmSelect); 
//                                       
//                                   } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                       //직종세
//                                       f.setEnabled(true);
//                                   } else if (businCd.equals(f.getName())) {
//                                       //사업
//                                       f.setEnabled(false);
//                                   } else if (payrMangDeptCd.equals(f.getName())) {
//                                       //단위기관 
//                                       f.setEnabled(false);
//                                       BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                       ((ComboBox) f).setValue(bmSelect); 
//                                   }
//                               } else  if (f instanceof MSFMultiComboBox<?>) {
//                                   if (deptCd.equals(f.getName())) {
//                                       //부서 
//                                         f.setEnabled(false); 
//                                         ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                         if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                             ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                             ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                         }    
//                                      }  else if (typOccuCd.equals(f.getName())) {
//                                          //직종 
//                                          f.setEnabled(false); 
//                                          ModelData  mdSelect = null; 
//                                          List<ModelData> lsMdSelect = (List<ModelData>) ((MSFMultiComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd());
//                                          
//                                          if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//                                              for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//                                                  ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//                                                  if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                      mdSelect = tpMdSelect;
//                                                  } 
//                                              }  
//                                          
//                                              ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                              ((MSFMultiComboBox) f).setValue(mdSelect.get("typOccuNm"));
//                                          } 
//                                      } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                          //직종세
//                                          f.setEnabled(false);      
//                                      }       
//                               } else  if (f instanceof TextField<?>) {
//                                  
//                                   if (deptCd[0].equals(f.getName())) {
//                                       //부서 
//                                       
//                                          for (int iCnt = 0; iCnt < deptCd.length;iCnt++) {
//                                              for (Field<?>  suf : ((FormPanel) cmp).getFields()) {
//                                                  if (suf instanceof TextField<?>) {
//                                                      
//                                                      if (deptCd[iCnt].equals(suf.getName())) { 
//                                                          suf.setEnabled(false); 
//                                                          if (deptCd[iCnt].endsWith("Cd")) {
//                                                              ((TextField) suf).setValue(MSFMainApp.get().getUser().getDeptCd());
//                                                          } else if (deptCd[iCnt].endsWith("Nm")) {
//                                                              ((TextField) suf).setValue(MSFMainApp.get().getUser().getDeptNm());
//                                                          } 
//                                                      }
//                                                     
//                                                  }
//                                              }
//                                          }
//                                    }    
//                                 //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                               }  
//                           }
//                           
//                       } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                                 && (!MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))
//                               ) {
//                           // 다른 직종인 경우에도 처리를 위해 추가 함. 
//                           for (Field<?>  f : ((FormPanel) cmp).getFields()) {
//                               
//                               if (f instanceof ComboBox<?>) {
//                                   //고용구분
//                                   if (emymtDivCd.equals(f.getName())) {
//                                  //  f.setEnabled(false);
//                                    GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                   
//                                    BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                    ((ComboBox) f).setValue(bmSelect);
//                                   //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                   }  else if (typOccuCd.equals(f.getName())) {
//                                       //직종
//                                       BaseModel  bmSelect = new BaseModel();
//                                       f.setEnabled(false); 
//                                       List<BaseModel> bmSelects = (List<BaseModel>) ((ComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd()); 
//                                       
//                                       for(int iTyCnt = 0;iTyCnt < bmSelects.size();iTyCnt++){
//                                           BaseModel tpBmSelect = new BaseModel();
//                                           tpBmSelect = bmSelects.get(iTyCnt);
//                                           if (tpBmSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                bmSelect = tpBmSelect;
//                                           } 
//                                       }  
//                                       if (MSFSharedUtils.paramNotNull(bmSelect)) {
//                                       	
//                                       	bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("typOccuCd",(MSFMainApp.get().getUser().getTypOccuCd().concat("!").concat(MSFMainApp.get().getUser().getPyspGrdeCd()))); 
//                                            
//                                       }
//                                       
//                                       ((ComboBox) f).setValue(bmSelect); 
//                                       
//                                   } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                       //직종세
//                                       f.setEnabled(true);
//                                   } else if (businCd.equals(f.getName())) {
//                                       //사업
//                                       f.setEnabled(false);
//                                   } else if (payrMangDeptCd.equals(f.getName())) {
//                                       //단위기관 
//                                       f.setEnabled(false);
//                                       BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                       ((ComboBox) f).setValue(bmSelect); 
//                                   }
//                               } else  if (f instanceof MSFMultiComboBox<?>) {
//                                   if (deptCd.equals(f.getName())) {
//                                       //부서 
//                                         f.setEnabled(false); 
//                                         ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                         if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                             ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                             ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                         }    
//                                      }  else if (typOccuCd.equals(f.getName())) {
//                                          //직종 
//                                          f.setEnabled(false); 
//                                          ModelData  mdSelect = null; 
//                                          List<ModelData> lsMdSelect = (List<ModelData>) ((MSFMultiComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd());
//                                          
//                                          if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//                                              for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//                                                  ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//                                                  if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                      mdSelect = tpMdSelect;
//                                                  } 
//                                              }  
//                                          
//                                              ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                              ((MSFMultiComboBox) f).setValue(mdSelect.get("typOccuNm"));
//                                          } 
//                                      } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                          //직종세
//                                          f.setEnabled(false);      
//                                      }      
//                               } else  if (f instanceof TextField<?>) {
//                                   if (deptCd[0].equals(f.getName())) {
//                                       //부서 
//                                          for (int iCnt = 0; iCnt < deptCd.length;iCnt++) {
//                                              for (Field<?>  suf : ((FormPanel) cmp).getFields()) {
//                                                  if (suf instanceof TextField<?>) {
//                                                      
//                                                      if (deptCd[iCnt].equals(suf.getName())) { 
//                                                          suf.setEnabled(false); 
//                                                        
//                                                          if (deptCd[iCnt].endsWith("Cd")) {
//                                                              ((TextField) suf).setValue(MSFMainApp.get().getUser().getDeptCd());
//                                                          } else if (deptCd[iCnt].endsWith("Nm")) {
//                                                              ((TextField) suf).setValue(MSFMainApp.get().getUser().getDeptNm());
//                                                          } 
//                                                      }
//                                                     
//                                                  }
//                                              }
//                                          }
//                                    }    
//                                 //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                               }  
//                           }
//                           
//                           
//                       } else {
//                             for (Field<?>  f : ((FormPanel) cmp).getFields()) {
//                              
//                                 if (f instanceof ComboBox<?>) {
//                                     //고용구분
//                                     if (emymtDivCd.equals(f.getName())) {
//                                 //    f.setEnabled(false);
//                                      GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                     
//                                      BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                      ((ComboBox) f).setValue(bmSelect);
//                                     //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                     }   else if (businCd.equals(f.getName())) {
//                                         //사업
//                                         f.setEnabled(false);
//                                     } else if (payrMangDeptCd.equals(f.getName())) {
//                                         //단위기관 
//                                         f.setEnabled(false);
//                                         BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                         ((ComboBox) f).setValue(bmSelect); 
//                                     }
//                                 } else  if (f instanceof MSFMultiComboBox<?>) {
//                                     if (deptCd.equals(f.getName())) {
//                                         //부서 
//                                           f.setEnabled(false); 
//                                           ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                           if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                               ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                               ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                           }    
//                                        }  else if (typOccuCd.equals(f.getName())) {
//                                            //직종 
////                                            f.setEnabled(false); 
////                                            ModelData  mdSelect = null; 
////                                            List<ModelData> lsMdSelect = (List<ModelData>) ((MSFMultiComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd());
////                                            
////                                     if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
////                                            for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
////                                                ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
////                                                if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
////                                                    mdSelect = tpMdSelect;
////                                                } 
////                                            }  
////                                        
////                                            ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
////                                            ((MSFMultiComboBox) f).setValue(mdSelect.get("typOccuNm"));
////                                         } 
//                                     
//                                        } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                            //직종세
//                                          //  f.setEnabled(true);      
//                                        }     
//                                     
//                                 } else  if (f instanceof TextField<?>) {
//                                     if (deptCd[0].equals(f.getName())) {
//                                         //부서 
//                                            for (int iCnt = 0; iCnt < deptCd.length;iCnt++) {
//                                                for (Field<?>  suf : ((FormPanel) cmp).getFields()) {
//                                                    if (suf instanceof TextField<?>) {
//                                                        
//                                                        if (deptCd[iCnt].equals(suf.getName())) { 
//                                                           //suf.setEnabled(false);  
//                                                            if (deptCd[iCnt].endsWith("Cd")) {
//                                                                ((TextField) suf).setValue(MSFMainApp.get().getUser().getDeptCd());
//                                                            } else if (deptCd[iCnt].endsWith("Nm")) {
//                                                                ((TextField) suf).setValue(MSFMainApp.get().getUser().getDeptNm());
//                                                            } 
//                                                        }
//                                                       
//                                                    }
//                                                }
//                                            }
//                                      }    
//                                   //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                                 }
//       
//                             }
//                       }  
//                      
//               } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//                //무기계약직업무담당자- 무기계약직총괄업무담당자
//                
//                              for (Field<?>  f : ((FormPanel) cmp).getFields()) {
//                               
//                                  if (f instanceof ComboBox<?>) {
//                                      //고용구분
//                                      if (emymtDivCd.equals(f.getName())) {
//                                       f.setEnabled(false);
//                                       GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                      
//                                       BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                       ((ComboBox) f).setValue(bmSelect);
//                                      //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                      
//                                      } else if (businCd.equals(f.getName())) {
//                                          //사업
//                                          f.setEnabled(false);
//                                      } else if (payrMangDeptCd.equals(f.getName())) {
//                                          //단위기관 
//                                        //  f.setEnabled(false);
//                                          BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                          ((ComboBox) f).setValue(bmSelect); 
//                                      }
//                                  } else  if (f instanceof MSFMultiComboBox<?>) {
//                                      
//                                  } else  if (f instanceof TextField<?>) {
//                                      if (deptCd[0].equals(f.getName())) {
//                                          //부서 
//                                             for (int iCnt = 0; iCnt < deptCd.length;iCnt++) {
//                                                 for (Field<?>  suf : ((FormPanel) cmp).getFields()) {
//                                                     if (suf instanceof TextField<?>) {
//                                                         
//                                                         if (deptCd[iCnt].equals(suf.getName())) { 
//                                                         //    suf.setEnabled(false); 
////                                                             if (deptCd[iCnt].endsWith("Cd")) {
////                                                                 ((TextField) suf).setValue(MSFMainApp.get().getUser().getDeptCd());
////                                                             } else if (deptCd[iCnt].endsWith("Nm")) {
////                                                                 ((TextField) suf).setValue(MSFMainApp.get().getUser().getDeptNm());
////                                                             } 
//                                                         }
//                                                        
//                                                     }
//                                                 }
//                                             }
//                                       }    
//                                    //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                                  }
//                                 
//        
//                              } 
//               } else  if (MSFConfiguration.AUTH_USR_DIV_60.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//                   //무기계약직업무담당자- 무기계약직업무담당자
//                   
//                                 for (Field<?>  f : ((FormPanel) cmp).getFields()) {
//                                  
//                                     if (f instanceof ComboBox<?>) {
//                                         //고용구분
//                                         if (emymtDivCd.equals(f.getName())) {
//                                         // f.setEnabled(false);
//                                          GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                         
//                                          BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                          ((ComboBox) f).setValue(bmSelect);
//                                         //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                         
//                                      //   } else if (businCd.equals(f.getName())) {
//                                      //       //사업
//                                     //        f.setEnabled(false);
//                                         } else if (payrMangDeptCd.equals(f.getName())) {
//                                             //단위기관 
//                                          //   f.setEnabled(false);
//                                             BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                             ((ComboBox) f).setValue(bmSelect); 
//                                         }
//                                     } else  if (f instanceof MSFMultiComboBox<?>) {
//                                         
//                                     } else  if (f instanceof TextField<?>) {
//                                        // if (deptCd[0].equals(f.getName())) {
//                                             //부서 
//                                          //      for (int iCnt = 0; iCnt < deptCd.length;iCnt++) {
//                                           //         for (Field<?>  suf : ((FormPanel) cmp).getFields()) {
//                                            //            if (suf instanceof TextField<?>) {
//                                                            
//                                               //             if (deptCd[iCnt].equals(suf.getName())) { 
//                                                            //    suf.setEnabled(false); 
////                                                                if (deptCd[iCnt].endsWith("Cd")) {
////                                                                    ((TextField) suf).setValue(MSFMainApp.get().getUser().getDeptCd());
////                                                                } else if (deptCd[iCnt].endsWith("Nm")) {
////                                                                    ((TextField) suf).setValue(MSFMainApp.get().getUser().getDeptNm());
////                                                                } 
//                                                         //   }
//                                                           
//                                                      //  }
//                                                  //  }
//                                              //  }
//                                        //  }    
//                                       //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                                     }
//                                    
//           
//                                 }                
//               }
// 
//        } 
//    }
//    
//   
//    @SuppressWarnings("rawtypes")
//    public    void formAuthBtnConfig(Component cmp) {
//      /**
//       * D0010010   D001    0010    무기계약직업무담당자 //무기계약직업무담당자 중 환경미환원인경우 처리를 위해 추가된 부분 처리 ...
//        D0010020    D001    0020    기간제업무담당자
//        D0010020    D001    0025    겸직업무담당자
//        D0010030    D001    0030    무기계약직총괄업무담당자
//        D0010040    D001    0040    기간제총괄업무담당자
//        D0010040    D001    0050    공통업무담당자 - 기초및 공통설정업무를 담당  --추가예정
//        D0010040    D001    0060    통합업무담당자 - 전체업무권한 담당자.    --설정(인사급여)
//        D0010070    D001    0070    무기계약직근로자
//        D0010080    D001    0080    기간제근로자
//        D0010090    D001    0090    시스템마스터관리자
//       */
//       
//       // if ( cmp==null || MSFSharedUtils.paramNull(emymtDivCd) ) {
//        if ( MSFSharedUtils.paramNull(cmp) ) {
//            return ;
//        }
//       
//        if (cmp instanceof Button) {  
//          
//            if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
//                //기간제업무담당자- 기간제업무담당자
//                   cmp.setEnabled(false);
//               } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//                //무기계약직업무담당자- 무기계약직업무담당자
//                  
//                   //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
//                   if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                           && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
//                      
//                       cmp.setEnabled(false);
//                        
//                    } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                              && (!MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))
//                            ) {
//                        // 다른 직종인 경우에도 처리를 위해 추가 함. 
//                       
//                        cmp.setEnabled(false);
//                        
//                    } else {
//                        // cmp.setEnabled(false);  
//                    }      
//              } else  if (MSFConfiguration.AUTH_USR_DIV_25.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//               //겸직 
//                  if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                          && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
//                     
//                      cmp.setEnabled(false);
//                       
//                   } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                             && (!MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))
//                           ) {
//                       // 다른 직종인 경우에도 처리를 위해 추가 함. 
//                      
//                       cmp.setEnabled(false);
//                       
//                   } else {
//                       // cmp.setEnabled(false);  
//                   }      
//              } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//                //무기계약직업무담당자- 무기계약직업무담당자
//                
//                     
//              } else  if (MSFConfiguration.AUTH_USR_DIV_60.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//                  
//              }
//             
// 
//        } 
//    }
//    
//    
//    /** 사용안함 추후 확인 */
//    @SuppressWarnings("rawtypes")
//    public    void formComponentDisable(Component cmp, String payrMangDeptCd, String emymtDivCd, String[] deptCd,String typOccuCd,String businCd, Boolean boolDisable) {
//      
//       
//       // if ( cmp==null || MSFSharedUtils.paramNull(emymtDivCd) ) {
//        if ( MSFSharedUtils.paramNull(cmp) ) {
//            return ;
//        }
//       
//        if ( cmp instanceof FormPanel ) { 
//            for (Field<?>  f : ((FormPanel) cmp).getFields()) { 
//                    if (f instanceof ComboBox<?>) {
//                        //고용구분
//                        if (emymtDivCd.equals(f.getName())) {
//                         f.setEnabled(false); 
//                        //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                        } else if (deptCd.equals(f.getName())) {
//                         //부서 
//                            f.setEnabled(false); 
//                        } else if (typOccuCd.equals(f.getName())) {
//                            //직종
//                            f.setEnabled(false);
//                        } else if (payrMangDeptCd.equals(f.getName())) {
//                            //단위기관 
//                            f.setEnabled(false);
//                        }
//                        //else if (businCd.equals(f.getName())) {
//                            //사업
//                         //   f.setEnabled(false);
//                        //}
//                    } else  if (f instanceof MSFMultiComboBox<?>) {     
//                        if (deptCd.equals(f.getName())) {
//                            //부서 
//                              f.setEnabled(false);  
//                           }  else if (typOccuCd.equals(f.getName())) {
//                               //직종 
//                               f.setEnabled(false); 
//                              
//                           }
////                           else if (dtilOccuClsDivCd.equals(f.getName())) {
////                               //직종세
////                               f.setEnabled(false);      
////                           }   
//                    } else  if (f instanceof TextField<?>) {
//                        //부서가 텍스트 인경우 처리 ..
//                        if (deptCd.equals(f.getName())) {
//                            //부서 
//                            for (int iCnt = 0; iCnt < deptCd.length;iCnt++) {
//                                for (Field<?>  suf : ((FormPanel) cmp).getFields()) {
//                                    if (suf instanceof TextField<?>) {
//                                        
//                                        if (deptCd[iCnt].equals(suf.getName())) { 
//                                           suf.setEnabled(false);  
//                                        }
//                                       
//                                    }
//                                }
//                            }
//                               
//                           } 
//                      //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                    }
//           
//            }
//        }
//           
//    }
    
    /**
     * 권한에 따른 부서코드를 가져온다. 
     * @return String
     */
    public  String getStrGWTAuthDept() {
        
        String deptCd = "";
        String chkDeptCd = MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getAuthCheck().getAuthCheck03());   //부서 
        
        if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
            //기간제업무담당자- 기간제업무담당자
                deptCd = MSFMainApp.get().getUser().getDeptCd();
           } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
            //무기계약직업무담당자- 무기계약직업무담당자
               //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size()); 
        	   if ("TRUE".equals(chkDeptCd)) {
        		    deptCd = "";   
	       		} else {
	       			deptCd = MSFMainApp.get().getUser().getDeptCd();    
	       		  
	       		}
        	    
           } else  if (MSFConfiguration.AUTH_USR_DIV_25.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
               //[겸직] 무기계약직및 기간제 동일처리 필요한 부분 
                  //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
        	     if ("TRUE".equals(chkDeptCd)) {
       		        deptCd = "";   
	       		  } else {
	       			deptCd = MSFMainApp.get().getUser().getDeptCd();    
	       		  
	       		  } 
                 
           } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
             //무기계약직업무담당자- 무기계약직업무담당자
               deptCd = "";
           } else  if (MSFConfiguration.AUTH_USR_DIV_60.equals(MSFMainApp.get().getUser().getUsrDivCd())) { 
               deptCd = "";
            } else   { 
                deptCd = "";
             }
        
            return deptCd;
    }
    
    
    public    BaseModel getBmGWTAuthDept() {
        
        BaseModel bmDept = new BaseModel();
        String chkDeptCd = MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getAuthCheck().getAuthCheck03());   //부서 
        if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
            //기간제업무담당자- 기간제업무담당자
               bmDept.set("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
               bmDept.set("deptNm",MSFMainApp.get().getUser().getDeptNm()); 
           } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
            //무기계약직업무담당자- 무기계약직업무담당자
               //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
//               if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                       && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
//                   bmDept.set("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                   bmDept.set("deptNm",MSFMainApp.get().getUser().getDeptNm());  
//                } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                          && (!MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))
//                        ) {
//                   
//                    bmDept.set("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                    bmDept.set("deptNm",MSFMainApp.get().getUser().getDeptNm());  
//                } else {
//                    bmDept.set("deptCd",""); 
//                    bmDept.set("deptNm",""); 
//                }
        	   if ("TRUE".equals(chkDeptCd)) {
        		   bmDept.set("deptCd",""); 
                   bmDept.set("deptNm","");   
	       		} else {
	       			bmDept.set("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
	                bmDept.set("deptNm",MSFMainApp.get().getUser().getDeptNm());  
	       			 
	       		  
	       		}
        	   
           } else  if (MSFConfiguration.AUTH_USR_DIV_25.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
               //[겸직] 무기계약직및 기간제 동일처리 필요한 부분 
                  //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
//                  if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                          && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
//                 
//                      bmDept.set("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                      bmDept.set("deptNm",MSFMainApp.get().getUser().getDeptNm());     
//                       
//                   } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                             && (!MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))
//                           ) {
//                       // 다른 직종인 경우에도 처리를 위해 추가 함. 
//                       bmDept.set("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                       bmDept.set("deptNm",MSFMainApp.get().getUser().getDeptNm());  
//                       
//                       
//                   } else {
//                       bmDept.set("deptCd",""); 
//                       bmDept.set("deptNm",""); 
//                   }    
        	   
        	   if ("TRUE".equals(chkDeptCd)) {
        		   bmDept.set("deptCd",""); 
                   bmDept.set("deptNm","");   
	       		} else {
	       			bmDept.set("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
	                bmDept.set("deptNm",MSFMainApp.get().getUser().getDeptNm());  
	       			 
	       		  
	       		}
                 
           } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
             //무기계약직업무담당자- 무기계약직업무담당자
               bmDept.set("deptCd",""); 
               bmDept.set("deptNm",""); 
           } else  if (MSFConfiguration.AUTH_USR_DIV_60.equals(MSFMainApp.get().getUser().getUsrDivCd())) {  
               bmDept.set("deptCd",""); 
               bmDept.set("deptNm",""); 
           } else {
               bmDept.set("deptCd",""); 
               bmDept.set("deptNm",""); 
           } 
        
        
           return bmDept;
    }
     
    /**
     * 겸임인경우 직종 콤보 활성화 비활성화 체크 
     */
    
    public    Boolean getCheckOccuDisabled() {
        Boolean checkOccuDis =  false;
        
        if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
            //기간제업무담당자- 기간제업무담당자
                checkOccuDis =  false;
           } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
            //무기계약직업무담당자- 무기계약직업무담당자
               checkOccuDis =  false;
           } else  if (MSFConfiguration.AUTH_USR_DIV_25.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
               //[겸직] 무기계약직및 기간제 동일처리 필요한 부분 
               checkOccuDis =  false;
           } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
             //무기계약직업무담당자- 무기계약직업무담당자
               checkOccuDis =  true;
           } else  if (MSFConfiguration.AUTH_USR_DIV_60.equals(MSFMainApp.get().getUser().getUsrDivCd())) {  
               checkOccuDis =  true; 
           } else {
               checkOccuDis =  true;  
           }
         return checkOccuDis ;
    }
    
//    
//    public    void formAuthFieldConfig(List<Field<?>> lstFields, String payrMangDeptCd, String emymtDivCd, String deptCd,String typOccuCd ,String businCd) {
//    	formAuthFieldConfig( lstFields,  payrMangDeptCd,  emymtDivCd,  deptCd, typOccuCd,"", businCd);
//    }
//    /**
//     * 보내는값 - formPanel, 고용구분, 부서코드,직종코드,사업코드
//     * @param cmp
//     * @param fieldName
//     */
//    @SuppressWarnings("rawtypes")
//    public    void formAuthFieldConfig(List<Field<?>> lstFields, String payrMangDeptCd, String emymtDivCd, String deptCd,String typOccuCd,String dtilOccuClsDivCd,String businCd) {
//      /**
//       * D0010010   D001    0010    무기계약직업무담당자 //무기계약직업무담당자 중 환경미환원인경우 처리를 위해 추가된 부분 처리 ...
//        D0010020    D001    0020    기간제업무담당자
//         public static final String AUTH_USR_DIV_25 = "D0010025";  //  D001    0025    [겸직]무기계약직기간제담당자
//        D0010030    D001    0030    무기계약직총괄업무담당자
//        
//        D0010040    D001    0040    기간제총괄업무담당자
//        D0010040    D001    0050    공통업무담당자 - 기초및 공통설정업무를 담당  --추가예정
//        D0010040    D001    0060    통합업무담당자 - 전체업무권한 담당자.    --설정(인사급여)
//        D0010070    D001    0070    무기계약직근로자
//        D0010080    D001    0080    기간제근로자
//        D0010090    D001    0090    시스템마스터관리자
//       */
//        //if ( cmp==null || MSFSharedUtils.paramNull(emymtDivCd) ) {
//        if ( MSFSharedUtils.paramNull(lstFields)) {
//            return ;
//        }
//      
//      //  if ( cmp instanceof FormPanel ) {  
//            
//            if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
//                //기간제업무담당자- 기간제업무담당자
//                   //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
//                              for (Field<?>  f : lstFields) {
//                               
//                                  if (f instanceof ComboBox<?>) {
//                                      //고용구분
//                                      if (emymtDivCd.equals(f.getName())) {
//                                       f.setEnabled(false);
//                                       GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                      
//                                       BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD02); 
//                                       ((ComboBox) f).setValue(bmSelect);
//                                      //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                      } else if (deptCd.equals(f.getName())) {
//                                       //부서 
//                                          f.setEnabled(false);
//                                          BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                          ((ComboBox) f).setValue(bmSelect); 
//                                      } else if (typOccuCd.equals(f.getName())) {
//                                          //직종
//                                          f.setEnabled(false);
//                                      } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                          //직종세
//                                          f.setEnabled(false);
//                                      } else if (payrMangDeptCd.equals(f.getName())) {
//                                          //단위기관 
//                                          f.setEnabled(false);
//                                          BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                          ((ComboBox) f).setValue(bmSelect); 
//                                      }
//                                      //else if (businCd.equals(f.getName())) {
//                                          //사업
//                                       //   f.setEnabled(false);
//                                      //}
//                                      
//                                  } else  if (f instanceof MSFMultiComboBox<?>) {
//                                      if (deptCd.equals(f.getName())) {
//                                          //부서 
//                                            f.setEnabled(false); 
//                                            ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                            if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                                ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                                ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                            }    
//                                         } else if (typOccuCd.equals(f.getName())) {
//                                             //직종
//                                             f.setEnabled(false);
//                                         } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                             //직종세
//                                             f.setEnabled(false);
//                                         } 
//                                  } else  if (f instanceof TextField<?>) {
//                                      //부서가 텍스트 인경우 처리 ..
//                                      if (deptCd.equals(f.getName())) {
//                                          //부서 
//                                            // f.setEnabled(false);
//                                            // BaseModel bmSelect = (BaseModel) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                           //  ((ComboBox) f).setValue(bmSelect); 
//                                         } 
//                                    //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                                  }
//                                 
//                                  
//                              }
//               } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//                //무기계약직업무담당자- 무기계약직업무담당자
//                   //   GWT.log("Field count: " + lstFields.size());
//                   if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                           && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
//                 
//                      
//                        for (Field<?>  f : lstFields) {
//                            
//                            if (f instanceof ComboBox<?>) {
//                                //고용구분
//                                if (emymtDivCd.equals(f.getName())) {
//                                 f.setEnabled(false);
//                                 GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                
//                                 BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                 ((ComboBox) f).setValue(bmSelect);
//                                //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                } else if (deptCd.equals(f.getName())) {
//                                 //부서 - 단위부서 및 관리부서에 따른 처리 필요 확인. 
//                                    f.setEnabled(false);
//                                    BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                    ((ComboBox) f).setValue(bmSelect); 
//                                } else if (typOccuCd.equals(f.getName())) {
//                                    //직종
//                                    BaseModel  bmSelect = new BaseModel();
//                                    f.setEnabled(false); 
//                                    List<BaseModel> bmSelects = (List<BaseModel>) ((ComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd()); 
//                                    
//                                    for(int iTyCnt = 0;iTyCnt < bmSelects.size();iTyCnt++){
//                                        BaseModel tpBmSelect = new BaseModel();
//                                        tpBmSelect = bmSelects.get(iTyCnt);
//                                        if (tpBmSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                             bmSelect = tpBmSelect;
//                                        } 
//                                    }  
//                                    ((ComboBox) f).setValue(bmSelect); 
//                                } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                    //직종세
//                                    f.setEnabled(false);      
//                                } else if (businCd.equals(f.getName())) {
//                                    //사업
//                                    f.setEnabled(false);
//                                } else if (payrMangDeptCd.equals(f.getName())) {
//                                    //단위기관 
//                                    f.setEnabled(false);
//                                    BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                    ((ComboBox) f).setValue(bmSelect); 
//                                }
//                            } else  if (f instanceof MSFMultiComboBox<?>) {
//                                if (deptCd.equals(f.getName())) {
//                                    //부서 
//                                      f.setEnabled(false); 
//                                      ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                      if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                          ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                          ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                      }    
//                                   } else if (typOccuCd.equals(f.getName())) {
//                                       //직종 
//                                       f.setEnabled(false); 
//                                       ModelData  mdSelect = null; 
//                                       List<ModelData> lsMdSelect = (List<ModelData>) ((MSFMultiComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd());
//                                       
//                                       if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//                                           for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//                                               ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//                                               if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                   mdSelect = tpMdSelect;
//                                               } 
//                                           }  
//                                       
//                                           ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                           ((MSFMultiComboBox) f).setValue(mdSelect.get("typOccuNm"));
//                                       } 
//                                       
//                                   } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                       //직종세
//                                       f.setEnabled(false);      
//                                   }    
//                            } else  if (f instanceof TextField<?>) {
//                              //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                            }  
//                        }
//                        
//                    } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                              && (!MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))
//                            ) {
//                        // 다른 직종인 경우에도 처리를 위해 추가 함. 
//                        for (Field<?>  f : lstFields) {
//                            
//                            if (f instanceof ComboBox<?>) {
//                                //고용구분
//                                if (emymtDivCd.equals(f.getName())) {
//                                 f.setEnabled(false);
//                                 GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                
//                                 BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                 ((ComboBox) f).setValue(bmSelect);
//                                //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                } else if (deptCd.equals(f.getName())) {
//                                 //부서 - 단위부서 및 관리부서에 따른 처리 필요 확인. 
//                                    f.setEnabled(false);
//                                    BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                    ((ComboBox) f).setValue(bmSelect); 
//                                } else if (typOccuCd.equals(f.getName())) {
//                                    //직종
//                                    BaseModel  bmSelect = new BaseModel();
//                                    f.setEnabled(false); 
//                                    List<BaseModel> bmSelects = (List<BaseModel>) ((ComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd()); 
//                                    
//                                    for(int iTyCnt = 0;iTyCnt < bmSelects.size();iTyCnt++){
//                                        BaseModel tpBmSelect = new BaseModel();
//                                        tpBmSelect = bmSelects.get(iTyCnt);
//                                        if (tpBmSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                             bmSelect = tpBmSelect;
//                                        } 
//                                    }  
//                                    ((ComboBox) f).setValue(bmSelect); 
//                                } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                    //직종세
//                                    f.setEnabled(false);    
//                                } else if (businCd.equals(f.getName())) {
//                                    //사업
//                                    f.setEnabled(false);
//                                } else if (payrMangDeptCd.equals(f.getName())) {
//                                    //단위기관 
//                                    f.setEnabled(false);
//                                    BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                    ((ComboBox) f).setValue(bmSelect); 
//                                }
//                            } else  if (f instanceof MSFMultiComboBox<?>) {
//                                if (deptCd.equals(f.getName())) {
//                                    //부서 
//                                      f.setEnabled(false); 
//                                      ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                      if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                          ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                          ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                      }    
//                                   } else if (typOccuCd.equals(f.getName())) {
//                                       //직종 
//                                       f.setEnabled(false); 
//                                       ModelData  mdSelect = null; 
//                                       List<ModelData> lsMdSelect = (List<ModelData>) ((MSFMultiComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd());
//                                       
//                                       if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//                                           for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//                                               ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//                                               if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                   mdSelect = tpMdSelect;
//                                               } 
//                                           }  
//                                       
//                                           ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                           ((MSFMultiComboBox) f).setValue(mdSelect.get("typOccuNm"));
//                                       } 
//                                       
//                                   } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                       //직종세
//                                       f.setEnabled(false);      
//                                   }    
//                            } else  if (f instanceof TextField<?>) {
//                              //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                            }  
//                        }
//                        
//                        
//                    } else {
//                          for (Field<?>  f : lstFields) {
//                           
//                              if (f instanceof ComboBox<?>) {
//                                  //고용구분
//                                  if (emymtDivCd.equals(f.getName())) {
//                                   f.setEnabled(false);
//                                   GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                  
//                                   BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                   ((ComboBox) f).setValue(bmSelect);
//                                  //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                  } else if (deptCd.equals(f.getName())) {
//                                   //부서 - 단위부서 및 관리부서에 따른 처리 필요 확인. 
//                                     // f.setEnabled(false); 
//                                      BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                      ((ComboBox) f).setValue(bmSelect); 
////                                      } else if (typOccuCd.equals(f.getName())) {
////                                          //직종
////                                          f.setEnabled(false);
////                                      }
//                                  } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                      //직종세
//                                    //  f.setEnabled(false);    
//                                  } else if (businCd.equals(f.getName())) {
//                                      //사업
//                                      f.setEnabled(false);
//                                  } else if (payrMangDeptCd.equals(f.getName())) {
//                                      //단위기관 
//                                      f.setEnabled(false);
//                                      BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                      ((ComboBox) f).setValue(bmSelect); 
//                                  }
//                              } else  if (f instanceof MSFMultiComboBox<?>) {
//                                  if (deptCd.equals(f.getName())) {
//                                      //부서 
//                                      //  f.setEnabled(false); 
//                                        ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                        if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                            ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                            ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                        }    
//                                     } else if (typOccuCd.equals(f.getName())) {
//                                         //직종 
//                                         f.setEnabled(false); 
//                                         ModelData  mdSelect = null; 
//                                         List<ModelData> lsMdSelect = (List<ModelData>) ((MSFMultiComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd());
//                                         
//                                         if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//                                             for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//                                                 ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//                                                 if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                     mdSelect = tpMdSelect;
//                                                 } 
//                                             }  
//                                         
//                                             ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                             ((MSFMultiComboBox) f).setValue(mdSelect.get("typOccuNm"));
//                                         } 
//                                         
//                                     } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                         //직종세
//                                         f.setEnabled(true);      
//                                     }    
//                              } else  if (f instanceof TextField<?>) {
//                                //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                              }
//    
//                          }
//                    }
//               } else  if (MSFConfiguration.AUTH_USR_DIV_25.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//                   //[겸직] 무기계약직및 기간제 동일처리 필요한 부분 
//                      //   GWT.log("Field count: " + lstFields.size());
//                      if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                              && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
//                     
//                           for (Field<?>  f : lstFields) {
//                               
//                               if (f instanceof ComboBox<?>) {
//                                   //고용구분
//                                   if (emymtDivCd.equals(f.getName())) {
//                                   // f.setEnabled(false);
//                                    GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                   
//                                    BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                    ((ComboBox) f).setValue(bmSelect);
//                                   //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                   } else if (deptCd.equals(f.getName())) {
//                                    //부서 - 단위부서 및 관리부서에 따른 처리 필요 확인. 
//                                       f.setEnabled(false);
//                                       BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                       ((ComboBox) f).setValue(bmSelect); 
//                                   } else if (typOccuCd.equals(f.getName())) {
//                                       //직종
//                                       BaseModel  bmSelect = new BaseModel();
//                                       f.setEnabled(false); 
//                                       List<BaseModel> bmSelects = (List<BaseModel>) ((ComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd()); 
//                                       
//                                       for(int iTyCnt = 0;iTyCnt < bmSelects.size();iTyCnt++){
//                                           BaseModel tpBmSelect = new BaseModel();
//                                           tpBmSelect = bmSelects.get(iTyCnt);
//                                           if (tpBmSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                bmSelect = tpBmSelect;
//                                           } 
//                                       }  
//                                       ((ComboBox) f).setValue(bmSelect); 
//                                   } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                       //직종세
//                                       f.setEnabled(false);     
//                                   } else if (businCd.equals(f.getName())) {
//                                       //사업
//                                       f.setEnabled(false);
//                                   } else if (payrMangDeptCd.equals(f.getName())) {
//                                       //단위기관 
//                                       f.setEnabled(false);
//                                       BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                       ((ComboBox) f).setValue(bmSelect); 
//                                   }
//                               } else  if (f instanceof MSFMultiComboBox<?>) {
//                                   if (deptCd.equals(f.getName())) {
//                                       //부서 
//                                         f.setEnabled(false); 
//                                         ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                         if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                             ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                             ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                         }    
//                                      } else if (typOccuCd.equals(f.getName())) {
//                                          //직종 
//                                          f.setEnabled(false); 
//                                          ModelData  mdSelect = null; 
//                                          List<ModelData> lsMdSelect = (List<ModelData>) ((MSFMultiComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd());
//                                          if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//                                              for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//                                                  ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//                                                  if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                      mdSelect = tpMdSelect;
//                                                  } 
//                                              }  
//                                          
//                                              ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                              ((MSFMultiComboBox) f).setValue(mdSelect.get("typOccuNm"));
//                                          } 
//                                      } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                          //직종세
//                                          f.setEnabled(false);      
//                                      }     
//                               } else  if (f instanceof TextField<?>) {
//                                 //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                               }  
//                           }
//                           
//                       } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                                 && (!MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))
//                               ) {
//                           // 다른 직종인 경우에도 처리를 위해 추가 함. 
//                           for (Field<?>  f : lstFields) {
//                               
//                               if (f instanceof ComboBox<?>) {
//                                   //고용구분
//                                   if (emymtDivCd.equals(f.getName())) {
//                                   // f.setEnabled(false);
//                                    GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                   
//                                    BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                    ((ComboBox) f).setValue(bmSelect);
//                                   //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                   } else if (deptCd.equals(f.getName())) {
//                                    //부서 - 단위부서 및 관리부서에 따른 처리 필요 확인. 
//                                       f.setEnabled(false);
//                                       BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                       ((ComboBox) f).setValue(bmSelect); 
//                                   } else if (typOccuCd.equals(f.getName())) {
//                                       //직종
//                                       BaseModel  bmSelect = new BaseModel();
//                                       f.setEnabled(false); 
//                                       List<BaseModel> bmSelects = (List<BaseModel>) ((ComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd()); 
//                                       
//                                       for(int iTyCnt = 0;iTyCnt < bmSelects.size();iTyCnt++){
//                                           BaseModel tpBmSelect = new BaseModel();
//                                           tpBmSelect = bmSelects.get(iTyCnt);
//                                           if (tpBmSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                bmSelect = tpBmSelect;
//                                           } 
//                                       }  
//                                       ((ComboBox) f).setValue(bmSelect); 
//                                   } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                       //직종세
//                                       f.setEnabled(false);     
//                                   } else if (businCd.equals(f.getName())) {
//                                       //사업
//                                       f.setEnabled(false);
//                                   } else if (payrMangDeptCd.equals(f.getName())) {
//                                       //단위기관 
//                                       f.setEnabled(false);
//                                       BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                       ((ComboBox) f).setValue(bmSelect); 
//                                   }
//                               } else  if (f instanceof MSFMultiComboBox<?>) {
//                                   if (deptCd.equals(f.getName())) {
//                                       //부서 
//                                         f.setEnabled(false); 
//                                         ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                         if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                             ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                             ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                         }    
//                                      }  else if (typOccuCd.equals(f.getName())) {
//                                          //직종 
//                                          f.setEnabled(false); 
//                                          ModelData  mdSelect = null; 
//                                          List<ModelData> lsMdSelect = (List<ModelData>) ((MSFMultiComboBox) f).getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd());
//                                          if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//                                              for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//                                                  ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//                                                  if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//                                                      mdSelect = tpMdSelect;
//                                                  } 
//                                              }  
//                                          
//                                              ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                              ((MSFMultiComboBox) f).setValue(mdSelect.get("typOccuNm"));
//                                          } 
//                                      } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                          //직종세
//                                          f.setEnabled(false);      
//                                      }  
//                               } else  if (f instanceof TextField<?>) {
//                                 //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                               }  
//                           }
//                           
//                           
//                       } else {
//                             for (Field<?>  f : lstFields) {
//                              
//                                 if (f instanceof ComboBox<?>) {
//                                     //고용구분
//                                     if (emymtDivCd.equals(f.getName())) {
//                                     // f.setEnabled(false);
//                                      GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                     
//                                      BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                      ((ComboBox) f).setValue(bmSelect);
//                                     //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                     } else if (deptCd.equals(f.getName())) {
//                                      //부서 - 단위부서 및 관리부서에 따른 처리 필요 확인. 
//                                        // f.setEnabled(false); 
//                                         BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                         ((ComboBox) f).setValue(bmSelect); 
////                                         } else if (typOccuCd.equals(f.getName())) {
////                                             //직종
////                                             f.setEnabled(false);
////                                         }
//                                    // } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                         //직종세
//                                     //    f.setEnabled(false);
//                                     } else if (businCd.equals(f.getName())) {
//                                         //사업
//                                         f.setEnabled(false);
//                                     } else if (payrMangDeptCd.equals(f.getName())) {
//                                         //단위기관 
//                                         f.setEnabled(false);
//                                         BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                         ((ComboBox) f).setValue(bmSelect); 
//                                     }
//                                 } else  if (f instanceof MSFMultiComboBox<?>) {
//                                     if (deptCd.equals(f.getName())) {
//                                         //부서 
//                                       //    f.setEnabled(false); 
//                                           ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
//                                           if (MSFSharedUtils.paramNotNull(mdSelect)) {
//                                               ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
//                                               ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
//                                           }    
//                                        }      
//                                 } else  if (f instanceof TextField<?>) {
//                                   //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                                 }
//       
//                             }
//                       }       
//              } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//                //무기계약직업무담당자- 무기계약직업무담당자
//                
//                              for (Field<?>  f : lstFields) {
//                               
//                                  if (f instanceof ComboBox<?>) {
//                                      //고용구분
//                                      if (emymtDivCd.equals(f.getName())) {
//                                       f.setEnabled(false);
//                                       GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                      
//                                       BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                       ((ComboBox) f).setValue(bmSelect);
//                                      //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                      } else if (deptCd.equals(f.getName())) {
//                                       //부서 - 단위부서 및 관리부서에 따른 처리 필요 확인. 
//                                         // f.setEnabled(false);
//                                         // BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                         // ((ComboBox) f).setValue(bmSelect); 
////                                      } else if (typOccuCd.equals(f.getName())) {
////                                          //직종
////                                          f.setEnabled(false);
////                                      }
//                                     // } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                          //직종세
//                                      //    f.setEnabled(false);     
//                                      } else if (businCd.equals(f.getName())) {
//                                          //사업
//                                          f.setEnabled(false);
//                                      } else if (payrMangDeptCd.equals(f.getName())) {
//                                          //단위기관 
//                                         // f.setEnabled(false);
//                                          BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                          ((ComboBox) f).setValue(bmSelect); 
//                                      }
//                                  } else  if (f instanceof MSFMultiComboBox<?>) {
////                                      if (deptCd.equals(f.getName())) {
////                                          //부서 
////                                            f.setEnabled(false); 
////                                            ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
////                                             if (MSFSharedUtils.paramNotNull(mdSelect)) {
////                                      ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
////                                      ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
////                                  }    
////                                         }     
//                                  } else  if (f instanceof TextField<?>) {
//                                    //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                                  }
//                                 
//        
//                              } 
//              } else  if (MSFConfiguration.AUTH_USR_DIV_60.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//                  //무기계약직업무담당자- 무기계약직업무담당자
//                  
//                                for (Field<?>  f : lstFields) {
//                                 
//                                    if (f instanceof ComboBox<?>) {
//                                        //고용구분
//                                        if (emymtDivCd.equals(f.getName())) {
//                                        // f.setEnabled(false);
//                                         GWT.log("fieldCheck: " +  ((ComboBox) f).getStore().getCount());
//                                        
//                                         BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("commCd",MSFConfiguration.EMYMT_DIVCD01); 
//                                         ((ComboBox) f).setValue(bmSelect);
//                                        //    GWT.log("fieldCheck: " + f.getName() + " -> " + f.getFieldLabel());
//                                        } else if (deptCd.equals(f.getName())) {
//                                         //부서 - 단위부서 및 관리부서에 따른 처리 필요 확인. 
//                                           // f.setEnabled(false);
//                                           // BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()); 
//                                           // ((ComboBox) f).setValue(bmSelect); 
////                                        } else if (typOccuCd.equals(f.getName())) {
////                                            //직종
////                                            f.setEnabled(false);
////                                        }
//                                       // } else if (dtilOccuClsDivCd.equals(f.getName())) {
//                                            //직종세
//                                        //    f.setEnabled(false);     
//                                        //} else if (businCd.equals(f.getName())) {
//                                            //사업
//                                        //    f.setEnabled(false);
//                                        } else if (payrMangDeptCd.equals(f.getName())) {
//                                            //단위기관 
//                                          //  f.setEnabled(false);
//                                            BaseModel bmSelect = (BaseModel) ((ComboBox) f).getStore().findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()); 
//                                            ((ComboBox) f).setValue(bmSelect); 
//                                        }
//                                    } else  if (f instanceof MSFMultiComboBox<?>) {
////                                        if (deptCd.equals(f.getName())) {
////                                            //부서 
////                                              f.setEnabled(false); 
////                                              ModelData mdSelect = (ModelData) ((MSFMultiComboBox) f).getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
////                                               if (MSFSharedUtils.paramNotNull(mdSelect)) {
////                                        ((MSFMultiComboBox) f).getListView().setChecked(mdSelect, true); 
////                                        ((MSFMultiComboBox) f).setValue(mdSelect.get("deptNmRtchnt")); 
////                                    }    
////                                           }     
//                                    } else  if (f instanceof TextField<?>) {
//                                      //  GWT.log("field2: " + f.getName() + " -> " + f.getFieldLabel());
//                                    }
//                                   
//          
//                                }                
//               }
// 
//       
//    }
    
      
}
