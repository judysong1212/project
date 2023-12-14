package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr1200BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr1200VO.java
 * @Description : Insr1200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr1200Def extends TableDef implements InsrDaoConstants {
	    private int row = 0;
	    private InsrConstants InsrLabel = InsrConstants.INSTANCE;

	    final PrgmComBass0300DTO sysComBass0300Dto;
	    
	    public Insr1200Def(String chkDef){
	    	
	    	 sysComBass0300Dto = new PrgmComBass0300DTO(); 
	    	  
	    	 
	    	 if ("INSR2100".equals(chkDef)) {
	    		    setTitle("");
	    	        setDaoClass("");
	    	        setCustomListMethod(CLASS_INSR2100TOINSR1200_DAO_LIST);
	    	        setAutoFillGrid(false);
	    	        setShowFilterToolbar(false);
	    	        setCheckBoxOnGridRows(true); 
	    	        setEditFieldGrid(true); 
	    	        setFilterFormType(FILTER_FORM_SINGLE);
	              setColumnsDefinition(getInsr2100ToInsr1200());
	              
	          
	          } else if ("INSRP410002".equals(chkDef)) {
	    		    setTitle("");
	    	        setDaoClass("");
	    	        setCustomListMethod(CLASS_INSRP210005TOINSR1200_DAO_LIST);
	    	        setAutoFillGrid(false);
	    	        setShowFilterToolbar(false);
	    	        setCheckBoxOnGridRows(true);   
	              setColumnsDefinition(getInsrP210005ToInsr1200());
	          } 
	    }	
	    
	    public List<ColumnDef> getInsr2100ToInsr1200(){	 
	  	  

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

			/** column 사업장코드 : dpobCd */
			listColumnDefs.add(new ColumnDef("사업장코드", Insr1200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column SYSTEMKEY : systemkey */
			listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr1200BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험작성일자 : soctyInsurCmptnDt */
			listColumnDefs.add(new ColumnDef("사회보험작성일자", Insr1200BM.ATTR_SOCTYINSURCMPTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
			listColumnDefs.add(new ColumnDef("사회보험취득_고용_일련번호", Insr1200BM.ATTR_SOCINSRAQTNEMYMTNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE01 : socnsrAqtnRegVal01 */
			listColumnDefs.add(new ColumnDef("공단구분", Insr1200BM.ATTR_SOCNSRAQTNREGVAL01, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE02 : socnsrAqtnRegVal02 */
			listColumnDefs.add(new ColumnDef("성명", Insr1200BM.ATTR_SOCNSRAQTNREGVAL02, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE03 : socnsrAqtnRegVal03 */
			listColumnDefs.add(new ColumnDef("주민등록번호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL03, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE04 : socnsrAqtnRegVal04 */
			listColumnDefs.add(new ColumnDef("국적", Insr1200BM.ATTR_SOCNSRAQTNREGVAL04, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE05 : socnsrAqtnRegVal05 */
			listColumnDefs.add(new ColumnDef("체류자격", Insr1200BM.ATTR_SOCNSRAQTNREGVAL05, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE06 : socnsrAqtnRegVal06 */
			listColumnDefs.add(new ColumnDef("대표자여부", Insr1200BM.ATTR_SOCNSRAQTNREGVAL06, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE07 : socnsrAqtnRegVal07 */
			listColumnDefs.add(new ColumnDef("소득월액", Insr1200BM.ATTR_SOCNSRAQTNREGVAL07, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE08 : socnsrAqtnRegVal08 */
			listColumnDefs.add(new ColumnDef("취득월납부여부", Insr1200BM.ATTR_SOCNSRAQTNREGVAL08, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE09 : socnsrAqtnRegVal09 */
			listColumnDefs.add(new ColumnDef("취득부호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL09, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE10 : socnsrAqtnRegVal10 */
			listColumnDefs.add(new ColumnDef("자격취득일", Insr1200BM.ATTR_SOCNSRAQTNREGVAL10, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE11 : socnsrAqtnRegVal11 */
			listColumnDefs.add(new ColumnDef("특수직종", Insr1200BM.ATTR_SOCNSRAQTNREGVAL11, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE12 : socnsrAqtnRegVal12 */
			listColumnDefs.add(new ColumnDef("직역연금부호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL12, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 건강_단위사업장기호 : socnsrAqtnRegVal13 */
			listColumnDefs.add(new ColumnDef("단위사업장기호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL13, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 건강_단위사업장명칭 : socnsrAqtnRegVal14 */
			listColumnDefs.add(new ColumnDef("단위사업장명칭", Insr1200BM.ATTR_SOCNSRAQTNREGVAL14, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 건강_보수월액 : socnsrAqtnRegVal15 */
			listColumnDefs.add(new ColumnDef("보수월액", Insr1200BM.ATTR_SOCNSRAQTNREGVAL15, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 건강_취득부호 : socnsrAqtnRegVal16 */
			listColumnDefs.add(new ColumnDef("취득부호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL16, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 건강_자격취득일 : socnsrAqtnRegVal17 */
			listColumnDefs.add(new ColumnDef("자격취득일", Insr1200BM.ATTR_SOCNSRAQTNREGVAL17, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE18 : socnsrAqtnRegVal18 */
			listColumnDefs.add(new ColumnDef("감면", Insr1200BM.ATTR_SOCNSRAQTNREGVAL18, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE19 : socnsrAqtnRegVal19 */
			listColumnDefs.add(new ColumnDef("건강보험증사업장발송여부", Insr1200BM.ATTR_SOCNSRAQTNREGVAL19, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE20 : socnsrAqtnRegVal20 */
			listColumnDefs.add(new ColumnDef("회계", Insr1200BM.ATTR_SOCNSRAQTNREGVAL20, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE21 : socnsrAqtnRegVal21 */
			listColumnDefs.add(new ColumnDef("직종", Insr1200BM.ATTR_SOCNSRAQTNREGVAL21, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 고용_자격취득일 : socnsrAqtnRegVal22 */
			listColumnDefs.add(new ColumnDef("자격취득일", Insr1200BM.ATTR_SOCNSRAQTNREGVAL22, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE23 : socnsrAqtnRegVal23 */
			listColumnDefs.add(new ColumnDef("직종", Insr1200BM.ATTR_SOCNSRAQTNREGVAL23, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE24 : socnsrAqtnRegVal24 */
			listColumnDefs.add(new ColumnDef("주소정근로시간", Insr1200BM.ATTR_SOCNSRAQTNREGVAL24, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE25 : socnsrAqtnRegVal25 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE25", Insr1200BM.ATTR_SOCNSRAQTNREGVAL25, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE26 : socnsrAqtnRegVal26 */
			listColumnDefs.add(new ColumnDef("계약직여부", Insr1200BM.ATTR_SOCNSRAQTNREGVAL26, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE27 : socnsrAqtnRegVal27 */
			listColumnDefs.add(new ColumnDef("계약직종료년월", Insr1200BM.ATTR_SOCNSRAQTNREGVAL27, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE28 : socnsrAqtnRegVal28 */
			listColumnDefs.add(new ColumnDef("월평균보수", Insr1200BM.ATTR_SOCNSRAQTNREGVAL28, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE29 : socnsrAqtnRegVal29 */
			listColumnDefs.add(new ColumnDef("비고", Insr1200BM.ATTR_SOCNSRAQTNREGVAL29, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE30 : socnsrAqtnRegVal30 */
			listColumnDefs.add(new ColumnDef("보험료부과구분부호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL30, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE31 : socnsrAqtnRegVal31 */
			listColumnDefs.add(new ColumnDef("보험료부과구분사유", Insr1200BM.ATTR_SOCNSRAQTNREGVAL31, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 산재_자격취득일 : socnsrAqtnRegVal32 */
			listColumnDefs.add(new ColumnDef("자격취득일", Insr1200BM.ATTR_SOCNSRAQTNREGVAL32, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE33 : socnsrAqtnRegVal33 */
			listColumnDefs.add(new ColumnDef("직종", Insr1200BM.ATTR_SOCNSRAQTNREGVAL33, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE34 : socnsrAqtnRegVal34 */
			listColumnDefs.add(new ColumnDef("주소정근로시간", Insr1200BM.ATTR_SOCNSRAQTNREGVAL34, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE35 : socnsrAqtnRegVal35 */
			listColumnDefs.add(new ColumnDef("계약직여부", Insr1200BM.ATTR_SOCNSRAQTNREGVAL35, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE36 : socnsrAqtnRegVal36 */
			listColumnDefs.add(new ColumnDef("계약직종료년월", Insr1200BM.ATTR_SOCNSRAQTNREGVAL36, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE37 : socnsrAqtnRegVal37 */
			listColumnDefs.add(new ColumnDef("월평균보수", Insr1200BM.ATTR_SOCNSRAQTNREGVAL37, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE38 : socnsrAqtnRegVal38 */
			listColumnDefs.add(new ColumnDef("비고", Insr1200BM.ATTR_SOCNSRAQTNREGVAL38, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE39 : socnsrAqtnRegVal39 */
			listColumnDefs.add(new ColumnDef("보험료부과구분부호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL39, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE40 : socnsrAqtnRegVal40 */
			listColumnDefs.add(new ColumnDef("보험료부과구분사유", Insr1200BM.ATTR_SOCNSRAQTNREGVAL40, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE41 : socnsrAqtnRegVal41 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE41", Insr1200BM.ATTR_SOCNSRAQTNREGVAL41, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE42 : socnsrAqtnRegVal42 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE42", Insr1200BM.ATTR_SOCNSRAQTNREGVAL42, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE43 : socnsrAqtnRegVal43 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE43", Insr1200BM.ATTR_SOCNSRAQTNREGVAL43, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE44 : socnsrAqtnRegVal44 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE44", Insr1200BM.ATTR_SOCNSRAQTNREGVAL44, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE45 : socnsrAqtnRegVal45 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE45", Insr1200BM.ATTR_SOCNSRAQTNREGVAL45, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE46 : socnsrAqtnRegVal46 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE46", Insr1200BM.ATTR_SOCNSRAQTNREGVAL46, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE47 : socnsrAqtnRegVal47 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE47", Insr1200BM.ATTR_SOCNSRAQTNREGVAL47, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE48 : socnsrAqtnRegVal48 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE48", Insr1200BM.ATTR_SOCNSRAQTNREGVAL48, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE49 : socnsrAqtnRegVal49 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE49", Insr1200BM.ATTR_SOCNSRAQTNREGVAL49, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE50 : socnsrAqtnRegVal50 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE50", Insr1200BM.ATTR_SOCNSRAQTNREGVAL50, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE51 : socnsrAqtnRegVal51 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE51", Insr1200BM.ATTR_SOCNSRAQTNREGVAL51, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE52 : socnsrAqtnRegVal52 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE52", Insr1200BM.ATTR_SOCNSRAQTNREGVAL52, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE53 : socnsrAqtnRegVal53 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE53", Insr1200BM.ATTR_SOCNSRAQTNREGVAL53, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE54 : socnsrAqtnRegVal54 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE54", Insr1200BM.ATTR_SOCNSRAQTNREGVAL54, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE55 : socnsrAqtnRegVal55 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE55", Insr1200BM.ATTR_SOCNSRAQTNREGVAL55, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE56 : socnsrAqtnRegVal56 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE56", Insr1200BM.ATTR_SOCNSRAQTNREGVAL56, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE57 : socnsrAqtnRegVal57 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE57", Insr1200BM.ATTR_SOCNSRAQTNREGVAL57, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE58 : socnsrAqtnRegVal58 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE58", Insr1200BM.ATTR_SOCNSRAQTNREGVAL58, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE59 : socnsrAqtnRegVal59 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE59", Insr1200BM.ATTR_SOCNSRAQTNREGVAL59, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE60 : socnsrAqtnRegVal60 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE60", Insr1200BM.ATTR_SOCNSRAQTNREGVAL60, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE61 : socnsrAqtnRegVal61 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE61", Insr1200BM.ATTR_SOCNSRAQTNREGVAL61, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE62 : socnsrAqtnRegVal62 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE62", Insr1200BM.ATTR_SOCNSRAQTNREGVAL62, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE63 : socnsrAqtnRegVal63 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE63", Insr1200BM.ATTR_SOCNSRAQTNREGVAL63, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE64 : socnsrAqtnRegVal64 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE64", Insr1200BM.ATTR_SOCNSRAQTNREGVAL64, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE65 : socnsrAqtnRegVal65 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE65", Insr1200BM.ATTR_SOCNSRAQTNREGVAL65, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE66 : socnsrAqtnRegVal66 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE66", Insr1200BM.ATTR_SOCNSRAQTNREGVAL66, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE67 : socnsrAqtnRegVal67 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE67", Insr1200BM.ATTR_SOCNSRAQTNREGVAL67, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE68 : socnsrAqtnRegVal68 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE68", Insr1200BM.ATTR_SOCNSRAQTNREGVAL68, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE69 : socnsrAqtnRegVal69 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE69", Insr1200BM.ATTR_SOCNSRAQTNREGVAL69, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE70 : socnsrAqtnRegVal70 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE70", Insr1200BM.ATTR_SOCNSRAQTNREGVAL70, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE71 : socnsrAqtnRegVal71 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE71", Insr1200BM.ATTR_SOCNSRAQTNREGVAL71, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE72 : socnsrAqtnRegVal72 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE72", Insr1200BM.ATTR_SOCNSRAQTNREGVAL72, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE73 : socnsrAqtnRegVal73 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE73", Insr1200BM.ATTR_SOCNSRAQTNREGVAL73, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE74 : socnsrAqtnRegVal74 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE74", Insr1200BM.ATTR_SOCNSRAQTNREGVAL74, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE75 : socnsrAqtnRegVal75 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE75", Insr1200BM.ATTR_SOCNSRAQTNREGVAL75, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE76 : socnsrAqtnRegVal76 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE76", Insr1200BM.ATTR_SOCNSRAQTNREGVAL76, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE77 : socnsrAqtnRegVal77 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE77", Insr1200BM.ATTR_SOCNSRAQTNREGVAL77, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE78 : socnsrAqtnRegVal78 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE78", Insr1200BM.ATTR_SOCNSRAQTNREGVAL78, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE79 : socnsrAqtnRegVal79 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE79", Insr1200BM.ATTR_SOCNSRAQTNREGVAL79, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE80 : socnsrAqtnRegVal80 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE80", Insr1200BM.ATTR_SOCNSRAQTNREGVAL80, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
//			/** column 입력자 : kybdr */
//			listColumnDefs.add(new ColumnDef("입력자", Insr1200BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//				{
//			
//				}
//			});
//			/** column 입력일자 : inptDt */
//			listColumnDefs.add(new ColumnDef("입력일자", Insr1200BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//				{
//			
//				}
//			});
//			/** column 수정자 : ismt */
//			listColumnDefs.add(new ColumnDef("수정자", Insr1200BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//				{
//			
//				}
//			});
//			/** column 입력주소 : inptAddr */
//			listColumnDefs.add(new ColumnDef("입력주소", Insr1200BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//				{
//			
//				}
//			});
//			/** column 수정일자 : revnDt */
//			listColumnDefs.add(new ColumnDef("수정일자", Insr1200BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//				{
//			
//				}
//			});
//			/** column 수정주소 : revnAddr */
//			listColumnDefs.add(new ColumnDef("수정주소", Insr1200BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//				{
//			
//				}
//			});
			
			//private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
			//
			//private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
			//
			//private TextField<String> soctyInsurCmptnDt;   /** column 사회보험작성일자 : soctyInsurCmptnDt */
			//
			//private TextField<String> socInsrAqtnEmymtNum;   /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
			//
			//private TextField<String> socnsrAqtnRegVal01;   /** column 사회보험취득신고_ITEM_VALUE01 : socnsrAqtnRegVal01 */
			//
			//private TextField<String> socnsrAqtnRegVal02;   /** column 사회보험취득신고_ITEM_VALUE02 : socnsrAqtnRegVal02 */
			//
			//private TextField<String> socnsrAqtnRegVal03;   /** column 사회보험취득신고_ITEM_VALUE03 : socnsrAqtnRegVal03 */
			//
			//private TextField<String> socnsrAqtnRegVal04;   /** column 사회보험취득신고_ITEM_VALUE04 : socnsrAqtnRegVal04 */
			//
			//private TextField<String> socnsrAqtnRegVal05;   /** column 사회보험취득신고_ITEM_VALUE05 : socnsrAqtnRegVal05 */
			//
			//private TextField<String> socnsrAqtnRegVal06;   /** column 사회보험취득신고_ITEM_VALUE06 : socnsrAqtnRegVal06 */
			//
			//private TextField<String> socnsrAqtnRegVal07;   /** column 사회보험취득신고_ITEM_VALUE07 : socnsrAqtnRegVal07 */
			//
			//private TextField<String> socnsrAqtnRegVal08;   /** column 사회보험취득신고_ITEM_VALUE08 : socnsrAqtnRegVal08 */
			//
			//private TextField<String> socnsrAqtnRegVal09;   /** column 사회보험취득신고_ITEM_VALUE09 : socnsrAqtnRegVal09 */
			//
			//private TextField<String> socnsrAqtnRegVal10;   /** column 사회보험취득신고_ITEM_VALUE10 : socnsrAqtnRegVal10 */
			//
			//private TextField<String> socnsrAqtnRegVal11;   /** column 사회보험취득신고_ITEM_VALUE11 : socnsrAqtnRegVal11 */
			//
			//private TextField<String> socnsrAqtnRegVal12;   /** column 사회보험취득신고_ITEM_VALUE12 : socnsrAqtnRegVal12 */
			//
			//private TextField<String> socnsrAqtnRegVal13;   /** column 사회보험취득신고_ITEM_VALUE13 : socnsrAqtnRegVal13 */
			//
			//private TextField<String> socnsrAqtnRegVal14;   /** column 사회보험취득신고_ITEM_VALUE14 : socnsrAqtnRegVal14 */
			//
			//private TextField<String> socnsrAqtnRegVal15;   /** column 사회보험취득신고_ITEM_VALUE15 : socnsrAqtnRegVal15 */
			//
			//private TextField<String> socnsrAqtnRegVal16;   /** column 사회보험취득신고_ITEM_VALUE16 : socnsrAqtnRegVal16 */
			//
			//private TextField<String> socnsrAqtnRegVal17;   /** column 사회보험취득신고_ITEM_VALUE17 : socnsrAqtnRegVal17 */
			//
			//private TextField<String> socnsrAqtnRegVal18;   /** column 사회보험취득신고_ITEM_VALUE18 : socnsrAqtnRegVal18 */
			//
			//private TextField<String> socnsrAqtnRegVal19;   /** column 사회보험취득신고_ITEM_VALUE19 : socnsrAqtnRegVal19 */
			//
			//private TextField<String> socnsrAqtnRegVal20;   /** column 사회보험취득신고_ITEM_VALUE20 : socnsrAqtnRegVal20 */
			//
			//private TextField<String> socnsrAqtnRegVal21;   /** column 사회보험취득신고_ITEM_VALUE21 : socnsrAqtnRegVal21 */
			//
			//private TextField<String> socnsrAqtnRegVal22;   /** column 사회보험취득신고_ITEM_VALUE22 : socnsrAqtnRegVal22 */
			//
			//private TextField<String> socnsrAqtnRegVal23;   /** column 사회보험취득신고_ITEM_VALUE23 : socnsrAqtnRegVal23 */
			//
			//private TextField<String> socnsrAqtnRegVal24;   /** column 사회보험취득신고_ITEM_VALUE24 : socnsrAqtnRegVal24 */
			//
			//private TextField<String> socnsrAqtnRegVal25;   /** column 사회보험취득신고_ITEM_VALUE25 : socnsrAqtnRegVal25 */
			//
			//private TextField<String> socnsrAqtnRegVal26;   /** column 사회보험취득신고_ITEM_VALUE26 : socnsrAqtnRegVal26 */
			//
			//private TextField<String> socnsrAqtnRegVal27;   /** column 사회보험취득신고_ITEM_VALUE27 : socnsrAqtnRegVal27 */
			//
			//private TextField<String> socnsrAqtnRegVal28;   /** column 사회보험취득신고_ITEM_VALUE28 : socnsrAqtnRegVal28 */
			//
			//private TextField<String> socnsrAqtnRegVal29;   /** column 사회보험취득신고_ITEM_VALUE29 : socnsrAqtnRegVal29 */
			//
			//private TextField<String> socnsrAqtnRegVal30;   /** column 사회보험취득신고_ITEM_VALUE30 : socnsrAqtnRegVal30 */
			//
			//private TextField<String> socnsrAqtnRegVal31;   /** column 사회보험취득신고_ITEM_VALUE31 : socnsrAqtnRegVal31 */
			//
			//private TextField<String> socnsrAqtnRegVal32;   /** column 사회보험취득신고_ITEM_VALUE32 : socnsrAqtnRegVal32 */
			//
			//private TextField<String> socnsrAqtnRegVal33;   /** column 사회보험취득신고_ITEM_VALUE33 : socnsrAqtnRegVal33 */
			//
			//private TextField<String> socnsrAqtnRegVal34;   /** column 사회보험취득신고_ITEM_VALUE34 : socnsrAqtnRegVal34 */
			//
			//private TextField<String> socnsrAqtnRegVal35;   /** column 사회보험취득신고_ITEM_VALUE35 : socnsrAqtnRegVal35 */
			//
			//private TextField<String> socnsrAqtnRegVal36;   /** column 사회보험취득신고_ITEM_VALUE36 : socnsrAqtnRegVal36 */
			//
			//private TextField<String> socnsrAqtnRegVal37;   /** column 사회보험취득신고_ITEM_VALUE37 : socnsrAqtnRegVal37 */
			//
			//private TextField<String> socnsrAqtnRegVal38;   /** column 사회보험취득신고_ITEM_VALUE38 : socnsrAqtnRegVal38 */
			//
			//private TextField<String> socnsrAqtnRegVal39;   /** column 사회보험취득신고_ITEM_VALUE39 : socnsrAqtnRegVal39 */
			//
			//private TextField<String> socnsrAqtnRegVal40;   /** column 사회보험취득신고_ITEM_VALUE40 : socnsrAqtnRegVal40 */
			//
			//private TextField<String> socnsrAqtnRegVal41;   /** column 사회보험취득신고_ITEM_VALUE41 : socnsrAqtnRegVal41 */
			//
			//private TextField<String> socnsrAqtnRegVal42;   /** column 사회보험취득신고_ITEM_VALUE42 : socnsrAqtnRegVal42 */
			//
			//private TextField<String> socnsrAqtnRegVal43;   /** column 사회보험취득신고_ITEM_VALUE43 : socnsrAqtnRegVal43 */
			//
			//private TextField<String> socnsrAqtnRegVal44;   /** column 사회보험취득신고_ITEM_VALUE44 : socnsrAqtnRegVal44 */
			//
			//private TextField<String> socnsrAqtnRegVal45;   /** column 사회보험취득신고_ITEM_VALUE45 : socnsrAqtnRegVal45 */
			//
			//private TextField<String> socnsrAqtnRegVal46;   /** column 사회보험취득신고_ITEM_VALUE46 : socnsrAqtnRegVal46 */
			//
			//private TextField<String> socnsrAqtnRegVal47;   /** column 사회보험취득신고_ITEM_VALUE47 : socnsrAqtnRegVal47 */
			//
			//private TextField<String> socnsrAqtnRegVal48;   /** column 사회보험취득신고_ITEM_VALUE48 : socnsrAqtnRegVal48 */
			//
			//private TextField<String> socnsrAqtnRegVal49;   /** column 사회보험취득신고_ITEM_VALUE49 : socnsrAqtnRegVal49 */
			//
			//private TextField<String> socnsrAqtnRegVal50;   /** column 사회보험취득신고_ITEM_VALUE50 : socnsrAqtnRegVal50 */
			//
			//private TextField<String> socnsrAqtnRegVal51;   /** column 사회보험취득신고_ITEM_VALUE51 : socnsrAqtnRegVal51 */
			//
			//private TextField<String> socnsrAqtnRegVal52;   /** column 사회보험취득신고_ITEM_VALUE52 : socnsrAqtnRegVal52 */
			//
			//private TextField<String> socnsrAqtnRegVal53;   /** column 사회보험취득신고_ITEM_VALUE53 : socnsrAqtnRegVal53 */
			//
			//private TextField<String> socnsrAqtnRegVal54;   /** column 사회보험취득신고_ITEM_VALUE54 : socnsrAqtnRegVal54 */
			//
			//private TextField<String> socnsrAqtnRegVal55;   /** column 사회보험취득신고_ITEM_VALUE55 : socnsrAqtnRegVal55 */
			//
			//private TextField<String> socnsrAqtnRegVal56;   /** column 사회보험취득신고_ITEM_VALUE56 : socnsrAqtnRegVal56 */
			//
			//private TextField<String> socnsrAqtnRegVal57;   /** column 사회보험취득신고_ITEM_VALUE57 : socnsrAqtnRegVal57 */
			//
			//private TextField<String> socnsrAqtnRegVal58;   /** column 사회보험취득신고_ITEM_VALUE58 : socnsrAqtnRegVal58 */
			//
			//private TextField<String> socnsrAqtnRegVal59;   /** column 사회보험취득신고_ITEM_VALUE59 : socnsrAqtnRegVal59 */
			//
			//private TextField<String> socnsrAqtnRegVal60;   /** column 사회보험취득신고_ITEM_VALUE60 : socnsrAqtnRegVal60 */
			//
			//private TextField<String> socnsrAqtnRegVal61;   /** column 사회보험취득신고_ITEM_VALUE61 : socnsrAqtnRegVal61 */
			//
			//private TextField<String> socnsrAqtnRegVal62;   /** column 사회보험취득신고_ITEM_VALUE62 : socnsrAqtnRegVal62 */
			//
			//private TextField<String> socnsrAqtnRegVal63;   /** column 사회보험취득신고_ITEM_VALUE63 : socnsrAqtnRegVal63 */
			//
			//private TextField<String> socnsrAqtnRegVal64;   /** column 사회보험취득신고_ITEM_VALUE64 : socnsrAqtnRegVal64 */
			//
			//private TextField<String> socnsrAqtnRegVal65;   /** column 사회보험취득신고_ITEM_VALUE65 : socnsrAqtnRegVal65 */
			//
			//private TextField<String> socnsrAqtnRegVal66;   /** column 사회보험취득신고_ITEM_VALUE66 : socnsrAqtnRegVal66 */
			//
			//private TextField<String> socnsrAqtnRegVal67;   /** column 사회보험취득신고_ITEM_VALUE67 : socnsrAqtnRegVal67 */
			//
			//private TextField<String> socnsrAqtnRegVal68;   /** column 사회보험취득신고_ITEM_VALUE68 : socnsrAqtnRegVal68 */
			//
			//private TextField<String> socnsrAqtnRegVal69;   /** column 사회보험취득신고_ITEM_VALUE69 : socnsrAqtnRegVal69 */
			//
			//private TextField<String> socnsrAqtnRegVal70;   /** column 사회보험취득신고_ITEM_VALUE70 : socnsrAqtnRegVal70 */
			//
			//private TextField<String> socnsrAqtnRegVal71;   /** column 사회보험취득신고_ITEM_VALUE71 : socnsrAqtnRegVal71 */
			//
			//private TextField<String> socnsrAqtnRegVal72;   /** column 사회보험취득신고_ITEM_VALUE72 : socnsrAqtnRegVal72 */
			//
			//private TextField<String> socnsrAqtnRegVal73;   /** column 사회보험취득신고_ITEM_VALUE73 : socnsrAqtnRegVal73 */
			//
			//private TextField<String> socnsrAqtnRegVal74;   /** column 사회보험취득신고_ITEM_VALUE74 : socnsrAqtnRegVal74 */
			//
			//private TextField<String> socnsrAqtnRegVal75;   /** column 사회보험취득신고_ITEM_VALUE75 : socnsrAqtnRegVal75 */
			//
			//private TextField<String> socnsrAqtnRegVal76;   /** column 사회보험취득신고_ITEM_VALUE76 : socnsrAqtnRegVal76 */
			//
			//private TextField<String> socnsrAqtnRegVal77;   /** column 사회보험취득신고_ITEM_VALUE77 : socnsrAqtnRegVal77 */
			//
			//private TextField<String> socnsrAqtnRegVal78;   /** column 사회보험취득신고_ITEM_VALUE78 : socnsrAqtnRegVal78 */
			//
			//private TextField<String> socnsrAqtnRegVal79;   /** column 사회보험취득신고_ITEM_VALUE79 : socnsrAqtnRegVal79 */
			//
			//private TextField<String> socnsrAqtnRegVal80;   /** column 사회보험취득신고_ITEM_VALUE80 : socnsrAqtnRegVal80 */
			//
			//private TextField<String> kybdr;   /** column 입력자 : kybdr */
			//
			//private TextField<String> inptDt;   /** column 입력일자 : inptDt */
			//
			//private TextField<String> ismt;   /** column 수정자 : ismt */
			//
			//private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
			//
			//private TextField<String> revnDt;   /** column 수정일자 : revnDt */
			//
			//private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
			 return listColumnDefs;
	    }  
	    
	    public List<ColumnDef> getInsrP210005ToInsr1200(){	 
	  

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

			/** column 사업장코드 : dpobCd */
			listColumnDefs.add(new ColumnDef("사업장코드", Insr1200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column SYSTEMKEY : systemkey */
			listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr1200BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험작성일자 : soctyInsurCmptnDt */
			listColumnDefs.add(new ColumnDef("사회보험작성일자", Insr1200BM.ATTR_SOCTYINSURCMPTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
			listColumnDefs.add(new ColumnDef("사회보험취득_고용_일련번호", Insr1200BM.ATTR_SOCINSRAQTNEMYMTNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE01 : socnsrAqtnRegVal01 */
			listColumnDefs.add(new ColumnDef("공단구분", Insr1200BM.ATTR_SOCNSRAQTNREGVAL01, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE02 : socnsrAqtnRegVal02 */
			listColumnDefs.add(new ColumnDef("성명", Insr1200BM.ATTR_SOCNSRAQTNREGVAL02, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE03 : socnsrAqtnRegVal03 */
			listColumnDefs.add(new ColumnDef("주민등록번호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL03, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE04 : socnsrAqtnRegVal04 */
			listColumnDefs.add(new ColumnDef("국적", Insr1200BM.ATTR_SOCNSRAQTNREGVAL04, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE05 : socnsrAqtnRegVal05 */
			listColumnDefs.add(new ColumnDef("체류자격", Insr1200BM.ATTR_SOCNSRAQTNREGVAL05, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE06 : socnsrAqtnRegVal06 */
			listColumnDefs.add(new ColumnDef("대표자여부", Insr1200BM.ATTR_SOCNSRAQTNREGVAL06, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE07 : socnsrAqtnRegVal07 */
			listColumnDefs.add(new ColumnDef("소득월액", Insr1200BM.ATTR_SOCNSRAQTNREGVAL07, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE08 : socnsrAqtnRegVal08 */
			listColumnDefs.add(new ColumnDef("취득월납부여부", Insr1200BM.ATTR_SOCNSRAQTNREGVAL08, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE09 : socnsrAqtnRegVal09 */
			listColumnDefs.add(new ColumnDef("취득부호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL09, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE10 : socnsrAqtnRegVal10 */
			listColumnDefs.add(new ColumnDef("자격취득일", Insr1200BM.ATTR_SOCNSRAQTNREGVAL10, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE11 : socnsrAqtnRegVal11 */
			listColumnDefs.add(new ColumnDef("특수직종", Insr1200BM.ATTR_SOCNSRAQTNREGVAL11, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE12 : socnsrAqtnRegVal12 */
			listColumnDefs.add(new ColumnDef("직역연금부호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL12, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 건강_단위사업장기호 : socnsrAqtnRegVal13 */
			listColumnDefs.add(new ColumnDef("단위사업장기호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL13, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 건강_단위사업장명칭 : socnsrAqtnRegVal14 */
			listColumnDefs.add(new ColumnDef("단위사업장명칭", Insr1200BM.ATTR_SOCNSRAQTNREGVAL14, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 건강_보수월액 : socnsrAqtnRegVal15 */
			listColumnDefs.add(new ColumnDef("보수월액", Insr1200BM.ATTR_SOCNSRAQTNREGVAL15, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 건강_취득부호 : socnsrAqtnRegVal16 */
			listColumnDefs.add(new ColumnDef("취득부호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL16, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 건강_자격취득일 : socnsrAqtnRegVal17 */
			listColumnDefs.add(new ColumnDef("자격취득일", Insr1200BM.ATTR_SOCNSRAQTNREGVAL17, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE18 : socnsrAqtnRegVal18 */
			listColumnDefs.add(new ColumnDef("감면", Insr1200BM.ATTR_SOCNSRAQTNREGVAL18, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE19 : socnsrAqtnRegVal19 */
			listColumnDefs.add(new ColumnDef("건강보험증사업장발송여부", Insr1200BM.ATTR_SOCNSRAQTNREGVAL19, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE20 : socnsrAqtnRegVal20 */
			listColumnDefs.add(new ColumnDef("회계", Insr1200BM.ATTR_SOCNSRAQTNREGVAL20, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE21 : socnsrAqtnRegVal21 */
			listColumnDefs.add(new ColumnDef("직종", Insr1200BM.ATTR_SOCNSRAQTNREGVAL21, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 고용_자격취득일 : socnsrAqtnRegVal22 */
			listColumnDefs.add(new ColumnDef("자격취득일", Insr1200BM.ATTR_SOCNSRAQTNREGVAL22, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE23 : socnsrAqtnRegVal23 */
			listColumnDefs.add(new ColumnDef("직종", Insr1200BM.ATTR_SOCNSRAQTNREGVAL23, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE24 : socnsrAqtnRegVal24 */
			listColumnDefs.add(new ColumnDef("주소정근로시간", Insr1200BM.ATTR_SOCNSRAQTNREGVAL24, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE25 : socnsrAqtnRegVal25 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE25", Insr1200BM.ATTR_SOCNSRAQTNREGVAL25, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE26 : socnsrAqtnRegVal26 */
			listColumnDefs.add(new ColumnDef("계약직여부", Insr1200BM.ATTR_SOCNSRAQTNREGVAL26, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE27 : socnsrAqtnRegVal27 */
			listColumnDefs.add(new ColumnDef("계약직종료년월", Insr1200BM.ATTR_SOCNSRAQTNREGVAL27, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE28 : socnsrAqtnRegVal28 */
			listColumnDefs.add(new ColumnDef("월평균보수", Insr1200BM.ATTR_SOCNSRAQTNREGVAL28, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE29 : socnsrAqtnRegVal29 */
			listColumnDefs.add(new ColumnDef("비고", Insr1200BM.ATTR_SOCNSRAQTNREGVAL29, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE30 : socnsrAqtnRegVal30 */
			listColumnDefs.add(new ColumnDef("보험료부과구분부호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL30, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE31 : socnsrAqtnRegVal31 */
			listColumnDefs.add(new ColumnDef("보험료부과구분사유", Insr1200BM.ATTR_SOCNSRAQTNREGVAL31, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 산재_자격취득일 : socnsrAqtnRegVal32 */
			listColumnDefs.add(new ColumnDef("자격취득일", Insr1200BM.ATTR_SOCNSRAQTNREGVAL32, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE33 : socnsrAqtnRegVal33 */
			listColumnDefs.add(new ColumnDef("직종", Insr1200BM.ATTR_SOCNSRAQTNREGVAL33, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE34 : socnsrAqtnRegVal34 */
			listColumnDefs.add(new ColumnDef("주소정근로시간", Insr1200BM.ATTR_SOCNSRAQTNREGVAL34, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE35 : socnsrAqtnRegVal35 */
			listColumnDefs.add(new ColumnDef("계약직여부", Insr1200BM.ATTR_SOCNSRAQTNREGVAL35, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE36 : socnsrAqtnRegVal36 */
			listColumnDefs.add(new ColumnDef("계약직종료년월", Insr1200BM.ATTR_SOCNSRAQTNREGVAL36, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE37 : socnsrAqtnRegVal37 */
			listColumnDefs.add(new ColumnDef("월평균보수", Insr1200BM.ATTR_SOCNSRAQTNREGVAL37, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE38 : socnsrAqtnRegVal38 */
			listColumnDefs.add(new ColumnDef("비고", Insr1200BM.ATTR_SOCNSRAQTNREGVAL38, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE39 : socnsrAqtnRegVal39 */
			listColumnDefs.add(new ColumnDef("보험료부과구분부호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL39, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE40 : socnsrAqtnRegVal40 */
			listColumnDefs.add(new ColumnDef("보험료부과구분사유", Insr1200BM.ATTR_SOCNSRAQTNREGVAL40, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE41 : socnsrAqtnRegVal41 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE41", Insr1200BM.ATTR_SOCNSRAQTNREGVAL41, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE42 : socnsrAqtnRegVal42 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE42", Insr1200BM.ATTR_SOCNSRAQTNREGVAL42, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE43 : socnsrAqtnRegVal43 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE43", Insr1200BM.ATTR_SOCNSRAQTNREGVAL43, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE44 : socnsrAqtnRegVal44 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE44", Insr1200BM.ATTR_SOCNSRAQTNREGVAL44, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE45 : socnsrAqtnRegVal45 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE45", Insr1200BM.ATTR_SOCNSRAQTNREGVAL45, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE46 : socnsrAqtnRegVal46 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE46", Insr1200BM.ATTR_SOCNSRAQTNREGVAL46, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE47 : socnsrAqtnRegVal47 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE47", Insr1200BM.ATTR_SOCNSRAQTNREGVAL47, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE48 : socnsrAqtnRegVal48 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE48", Insr1200BM.ATTR_SOCNSRAQTNREGVAL48, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE49 : socnsrAqtnRegVal49 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE49", Insr1200BM.ATTR_SOCNSRAQTNREGVAL49, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE50 : socnsrAqtnRegVal50 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE50", Insr1200BM.ATTR_SOCNSRAQTNREGVAL50, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE51 : socnsrAqtnRegVal51 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE51", Insr1200BM.ATTR_SOCNSRAQTNREGVAL51, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE52 : socnsrAqtnRegVal52 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE52", Insr1200BM.ATTR_SOCNSRAQTNREGVAL52, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE53 : socnsrAqtnRegVal53 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE53", Insr1200BM.ATTR_SOCNSRAQTNREGVAL53, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE54 : socnsrAqtnRegVal54 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE54", Insr1200BM.ATTR_SOCNSRAQTNREGVAL54, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE55 : socnsrAqtnRegVal55 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE55", Insr1200BM.ATTR_SOCNSRAQTNREGVAL55, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE56 : socnsrAqtnRegVal56 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE56", Insr1200BM.ATTR_SOCNSRAQTNREGVAL56, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE57 : socnsrAqtnRegVal57 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE57", Insr1200BM.ATTR_SOCNSRAQTNREGVAL57, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE58 : socnsrAqtnRegVal58 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE58", Insr1200BM.ATTR_SOCNSRAQTNREGVAL58, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE59 : socnsrAqtnRegVal59 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE59", Insr1200BM.ATTR_SOCNSRAQTNREGVAL59, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE60 : socnsrAqtnRegVal60 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE60", Insr1200BM.ATTR_SOCNSRAQTNREGVAL60, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE61 : socnsrAqtnRegVal61 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE61", Insr1200BM.ATTR_SOCNSRAQTNREGVAL61, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE62 : socnsrAqtnRegVal62 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE62", Insr1200BM.ATTR_SOCNSRAQTNREGVAL62, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE63 : socnsrAqtnRegVal63 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE63", Insr1200BM.ATTR_SOCNSRAQTNREGVAL63, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE64 : socnsrAqtnRegVal64 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE64", Insr1200BM.ATTR_SOCNSRAQTNREGVAL64, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE65 : socnsrAqtnRegVal65 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE65", Insr1200BM.ATTR_SOCNSRAQTNREGVAL65, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE66 : socnsrAqtnRegVal66 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE66", Insr1200BM.ATTR_SOCNSRAQTNREGVAL66, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE67 : socnsrAqtnRegVal67 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE67", Insr1200BM.ATTR_SOCNSRAQTNREGVAL67, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE68 : socnsrAqtnRegVal68 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE68", Insr1200BM.ATTR_SOCNSRAQTNREGVAL68, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE69 : socnsrAqtnRegVal69 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE69", Insr1200BM.ATTR_SOCNSRAQTNREGVAL69, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE70 : socnsrAqtnRegVal70 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE70", Insr1200BM.ATTR_SOCNSRAQTNREGVAL70, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE71 : socnsrAqtnRegVal71 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE71", Insr1200BM.ATTR_SOCNSRAQTNREGVAL71, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE72 : socnsrAqtnRegVal72 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE72", Insr1200BM.ATTR_SOCNSRAQTNREGVAL72, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE73 : socnsrAqtnRegVal73 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE73", Insr1200BM.ATTR_SOCNSRAQTNREGVAL73, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE74 : socnsrAqtnRegVal74 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE74", Insr1200BM.ATTR_SOCNSRAQTNREGVAL74, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE75 : socnsrAqtnRegVal75 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE75", Insr1200BM.ATTR_SOCNSRAQTNREGVAL75, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE76 : socnsrAqtnRegVal76 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE76", Insr1200BM.ATTR_SOCNSRAQTNREGVAL76, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE77 : socnsrAqtnRegVal77 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE77", Insr1200BM.ATTR_SOCNSRAQTNREGVAL77, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE78 : socnsrAqtnRegVal78 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE78", Insr1200BM.ATTR_SOCNSRAQTNREGVAL78, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE79 : socnsrAqtnRegVal79 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE79", Insr1200BM.ATTR_SOCNSRAQTNREGVAL79, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득신고_ITEM_VALUE80 : socnsrAqtnRegVal80 */
			listColumnDefs.add(new ColumnDef("사회보험취득신고_ITEM_VALUE80", Insr1200BM.ATTR_SOCNSRAQTNREGVAL80, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
//			/** column 입력자 : kybdr */
//			listColumnDefs.add(new ColumnDef("입력자", Insr1200BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//				{
//			
//				}
//			});
//			/** column 입력일자 : inptDt */
//			listColumnDefs.add(new ColumnDef("입력일자", Insr1200BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//				{
//			
//				}
//			});
//			/** column 수정자 : ismt */
//			listColumnDefs.add(new ColumnDef("수정자", Insr1200BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//				{
//			
//				}
//			});
//			/** column 입력주소 : inptAddr */
//			listColumnDefs.add(new ColumnDef("입력주소", Insr1200BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//				{
//			
//				}
//			});
//			/** column 수정일자 : revnDt */
//			listColumnDefs.add(new ColumnDef("수정일자", Insr1200BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//				{
//			
//				}
//			});
//			/** column 수정주소 : revnAddr */
//			listColumnDefs.add(new ColumnDef("수정주소", Insr1200BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//				{
//			
//				}
//			});
			
			//private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
			//
			//private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
			//
			//private TextField<String> soctyInsurCmptnDt;   /** column 사회보험작성일자 : soctyInsurCmptnDt */
			//
			//private TextField<String> socInsrAqtnEmymtNum;   /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
			//
			//private TextField<String> socnsrAqtnRegVal01;   /** column 사회보험취득신고_ITEM_VALUE01 : socnsrAqtnRegVal01 */
			//
			//private TextField<String> socnsrAqtnRegVal02;   /** column 사회보험취득신고_ITEM_VALUE02 : socnsrAqtnRegVal02 */
			//
			//private TextField<String> socnsrAqtnRegVal03;   /** column 사회보험취득신고_ITEM_VALUE03 : socnsrAqtnRegVal03 */
			//
			//private TextField<String> socnsrAqtnRegVal04;   /** column 사회보험취득신고_ITEM_VALUE04 : socnsrAqtnRegVal04 */
			//
			//private TextField<String> socnsrAqtnRegVal05;   /** column 사회보험취득신고_ITEM_VALUE05 : socnsrAqtnRegVal05 */
			//
			//private TextField<String> socnsrAqtnRegVal06;   /** column 사회보험취득신고_ITEM_VALUE06 : socnsrAqtnRegVal06 */
			//
			//private TextField<String> socnsrAqtnRegVal07;   /** column 사회보험취득신고_ITEM_VALUE07 : socnsrAqtnRegVal07 */
			//
			//private TextField<String> socnsrAqtnRegVal08;   /** column 사회보험취득신고_ITEM_VALUE08 : socnsrAqtnRegVal08 */
			//
			//private TextField<String> socnsrAqtnRegVal09;   /** column 사회보험취득신고_ITEM_VALUE09 : socnsrAqtnRegVal09 */
			//
			//private TextField<String> socnsrAqtnRegVal10;   /** column 사회보험취득신고_ITEM_VALUE10 : socnsrAqtnRegVal10 */
			//
			//private TextField<String> socnsrAqtnRegVal11;   /** column 사회보험취득신고_ITEM_VALUE11 : socnsrAqtnRegVal11 */
			//
			//private TextField<String> socnsrAqtnRegVal12;   /** column 사회보험취득신고_ITEM_VALUE12 : socnsrAqtnRegVal12 */
			//
			//private TextField<String> socnsrAqtnRegVal13;   /** column 사회보험취득신고_ITEM_VALUE13 : socnsrAqtnRegVal13 */
			//
			//private TextField<String> socnsrAqtnRegVal14;   /** column 사회보험취득신고_ITEM_VALUE14 : socnsrAqtnRegVal14 */
			//
			//private TextField<String> socnsrAqtnRegVal15;   /** column 사회보험취득신고_ITEM_VALUE15 : socnsrAqtnRegVal15 */
			//
			//private TextField<String> socnsrAqtnRegVal16;   /** column 사회보험취득신고_ITEM_VALUE16 : socnsrAqtnRegVal16 */
			//
			//private TextField<String> socnsrAqtnRegVal17;   /** column 사회보험취득신고_ITEM_VALUE17 : socnsrAqtnRegVal17 */
			//
			//private TextField<String> socnsrAqtnRegVal18;   /** column 사회보험취득신고_ITEM_VALUE18 : socnsrAqtnRegVal18 */
			//
			//private TextField<String> socnsrAqtnRegVal19;   /** column 사회보험취득신고_ITEM_VALUE19 : socnsrAqtnRegVal19 */
			//
			//private TextField<String> socnsrAqtnRegVal20;   /** column 사회보험취득신고_ITEM_VALUE20 : socnsrAqtnRegVal20 */
			//
			//private TextField<String> socnsrAqtnRegVal21;   /** column 사회보험취득신고_ITEM_VALUE21 : socnsrAqtnRegVal21 */
			//
			//private TextField<String> socnsrAqtnRegVal22;   /** column 사회보험취득신고_ITEM_VALUE22 : socnsrAqtnRegVal22 */
			//
			//private TextField<String> socnsrAqtnRegVal23;   /** column 사회보험취득신고_ITEM_VALUE23 : socnsrAqtnRegVal23 */
			//
			//private TextField<String> socnsrAqtnRegVal24;   /** column 사회보험취득신고_ITEM_VALUE24 : socnsrAqtnRegVal24 */
			//
			//private TextField<String> socnsrAqtnRegVal25;   /** column 사회보험취득신고_ITEM_VALUE25 : socnsrAqtnRegVal25 */
			//
			//private TextField<String> socnsrAqtnRegVal26;   /** column 사회보험취득신고_ITEM_VALUE26 : socnsrAqtnRegVal26 */
			//
			//private TextField<String> socnsrAqtnRegVal27;   /** column 사회보험취득신고_ITEM_VALUE27 : socnsrAqtnRegVal27 */
			//
			//private TextField<String> socnsrAqtnRegVal28;   /** column 사회보험취득신고_ITEM_VALUE28 : socnsrAqtnRegVal28 */
			//
			//private TextField<String> socnsrAqtnRegVal29;   /** column 사회보험취득신고_ITEM_VALUE29 : socnsrAqtnRegVal29 */
			//
			//private TextField<String> socnsrAqtnRegVal30;   /** column 사회보험취득신고_ITEM_VALUE30 : socnsrAqtnRegVal30 */
			//
			//private TextField<String> socnsrAqtnRegVal31;   /** column 사회보험취득신고_ITEM_VALUE31 : socnsrAqtnRegVal31 */
			//
			//private TextField<String> socnsrAqtnRegVal32;   /** column 사회보험취득신고_ITEM_VALUE32 : socnsrAqtnRegVal32 */
			//
			//private TextField<String> socnsrAqtnRegVal33;   /** column 사회보험취득신고_ITEM_VALUE33 : socnsrAqtnRegVal33 */
			//
			//private TextField<String> socnsrAqtnRegVal34;   /** column 사회보험취득신고_ITEM_VALUE34 : socnsrAqtnRegVal34 */
			//
			//private TextField<String> socnsrAqtnRegVal35;   /** column 사회보험취득신고_ITEM_VALUE35 : socnsrAqtnRegVal35 */
			//
			//private TextField<String> socnsrAqtnRegVal36;   /** column 사회보험취득신고_ITEM_VALUE36 : socnsrAqtnRegVal36 */
			//
			//private TextField<String> socnsrAqtnRegVal37;   /** column 사회보험취득신고_ITEM_VALUE37 : socnsrAqtnRegVal37 */
			//
			//private TextField<String> socnsrAqtnRegVal38;   /** column 사회보험취득신고_ITEM_VALUE38 : socnsrAqtnRegVal38 */
			//
			//private TextField<String> socnsrAqtnRegVal39;   /** column 사회보험취득신고_ITEM_VALUE39 : socnsrAqtnRegVal39 */
			//
			//private TextField<String> socnsrAqtnRegVal40;   /** column 사회보험취득신고_ITEM_VALUE40 : socnsrAqtnRegVal40 */
			//
			//private TextField<String> socnsrAqtnRegVal41;   /** column 사회보험취득신고_ITEM_VALUE41 : socnsrAqtnRegVal41 */
			//
			//private TextField<String> socnsrAqtnRegVal42;   /** column 사회보험취득신고_ITEM_VALUE42 : socnsrAqtnRegVal42 */
			//
			//private TextField<String> socnsrAqtnRegVal43;   /** column 사회보험취득신고_ITEM_VALUE43 : socnsrAqtnRegVal43 */
			//
			//private TextField<String> socnsrAqtnRegVal44;   /** column 사회보험취득신고_ITEM_VALUE44 : socnsrAqtnRegVal44 */
			//
			//private TextField<String> socnsrAqtnRegVal45;   /** column 사회보험취득신고_ITEM_VALUE45 : socnsrAqtnRegVal45 */
			//
			//private TextField<String> socnsrAqtnRegVal46;   /** column 사회보험취득신고_ITEM_VALUE46 : socnsrAqtnRegVal46 */
			//
			//private TextField<String> socnsrAqtnRegVal47;   /** column 사회보험취득신고_ITEM_VALUE47 : socnsrAqtnRegVal47 */
			//
			//private TextField<String> socnsrAqtnRegVal48;   /** column 사회보험취득신고_ITEM_VALUE48 : socnsrAqtnRegVal48 */
			//
			//private TextField<String> socnsrAqtnRegVal49;   /** column 사회보험취득신고_ITEM_VALUE49 : socnsrAqtnRegVal49 */
			//
			//private TextField<String> socnsrAqtnRegVal50;   /** column 사회보험취득신고_ITEM_VALUE50 : socnsrAqtnRegVal50 */
			//
			//private TextField<String> socnsrAqtnRegVal51;   /** column 사회보험취득신고_ITEM_VALUE51 : socnsrAqtnRegVal51 */
			//
			//private TextField<String> socnsrAqtnRegVal52;   /** column 사회보험취득신고_ITEM_VALUE52 : socnsrAqtnRegVal52 */
			//
			//private TextField<String> socnsrAqtnRegVal53;   /** column 사회보험취득신고_ITEM_VALUE53 : socnsrAqtnRegVal53 */
			//
			//private TextField<String> socnsrAqtnRegVal54;   /** column 사회보험취득신고_ITEM_VALUE54 : socnsrAqtnRegVal54 */
			//
			//private TextField<String> socnsrAqtnRegVal55;   /** column 사회보험취득신고_ITEM_VALUE55 : socnsrAqtnRegVal55 */
			//
			//private TextField<String> socnsrAqtnRegVal56;   /** column 사회보험취득신고_ITEM_VALUE56 : socnsrAqtnRegVal56 */
			//
			//private TextField<String> socnsrAqtnRegVal57;   /** column 사회보험취득신고_ITEM_VALUE57 : socnsrAqtnRegVal57 */
			//
			//private TextField<String> socnsrAqtnRegVal58;   /** column 사회보험취득신고_ITEM_VALUE58 : socnsrAqtnRegVal58 */
			//
			//private TextField<String> socnsrAqtnRegVal59;   /** column 사회보험취득신고_ITEM_VALUE59 : socnsrAqtnRegVal59 */
			//
			//private TextField<String> socnsrAqtnRegVal60;   /** column 사회보험취득신고_ITEM_VALUE60 : socnsrAqtnRegVal60 */
			//
			//private TextField<String> socnsrAqtnRegVal61;   /** column 사회보험취득신고_ITEM_VALUE61 : socnsrAqtnRegVal61 */
			//
			//private TextField<String> socnsrAqtnRegVal62;   /** column 사회보험취득신고_ITEM_VALUE62 : socnsrAqtnRegVal62 */
			//
			//private TextField<String> socnsrAqtnRegVal63;   /** column 사회보험취득신고_ITEM_VALUE63 : socnsrAqtnRegVal63 */
			//
			//private TextField<String> socnsrAqtnRegVal64;   /** column 사회보험취득신고_ITEM_VALUE64 : socnsrAqtnRegVal64 */
			//
			//private TextField<String> socnsrAqtnRegVal65;   /** column 사회보험취득신고_ITEM_VALUE65 : socnsrAqtnRegVal65 */
			//
			//private TextField<String> socnsrAqtnRegVal66;   /** column 사회보험취득신고_ITEM_VALUE66 : socnsrAqtnRegVal66 */
			//
			//private TextField<String> socnsrAqtnRegVal67;   /** column 사회보험취득신고_ITEM_VALUE67 : socnsrAqtnRegVal67 */
			//
			//private TextField<String> socnsrAqtnRegVal68;   /** column 사회보험취득신고_ITEM_VALUE68 : socnsrAqtnRegVal68 */
			//
			//private TextField<String> socnsrAqtnRegVal69;   /** column 사회보험취득신고_ITEM_VALUE69 : socnsrAqtnRegVal69 */
			//
			//private TextField<String> socnsrAqtnRegVal70;   /** column 사회보험취득신고_ITEM_VALUE70 : socnsrAqtnRegVal70 */
			//
			//private TextField<String> socnsrAqtnRegVal71;   /** column 사회보험취득신고_ITEM_VALUE71 : socnsrAqtnRegVal71 */
			//
			//private TextField<String> socnsrAqtnRegVal72;   /** column 사회보험취득신고_ITEM_VALUE72 : socnsrAqtnRegVal72 */
			//
			//private TextField<String> socnsrAqtnRegVal73;   /** column 사회보험취득신고_ITEM_VALUE73 : socnsrAqtnRegVal73 */
			//
			//private TextField<String> socnsrAqtnRegVal74;   /** column 사회보험취득신고_ITEM_VALUE74 : socnsrAqtnRegVal74 */
			//
			//private TextField<String> socnsrAqtnRegVal75;   /** column 사회보험취득신고_ITEM_VALUE75 : socnsrAqtnRegVal75 */
			//
			//private TextField<String> socnsrAqtnRegVal76;   /** column 사회보험취득신고_ITEM_VALUE76 : socnsrAqtnRegVal76 */
			//
			//private TextField<String> socnsrAqtnRegVal77;   /** column 사회보험취득신고_ITEM_VALUE77 : socnsrAqtnRegVal77 */
			//
			//private TextField<String> socnsrAqtnRegVal78;   /** column 사회보험취득신고_ITEM_VALUE78 : socnsrAqtnRegVal78 */
			//
			//private TextField<String> socnsrAqtnRegVal79;   /** column 사회보험취득신고_ITEM_VALUE79 : socnsrAqtnRegVal79 */
			//
			//private TextField<String> socnsrAqtnRegVal80;   /** column 사회보험취득신고_ITEM_VALUE80 : socnsrAqtnRegVal80 */
			//
			//private TextField<String> kybdr;   /** column 입력자 : kybdr */
			//
			//private TextField<String> inptDt;   /** column 입력일자 : inptDt */
			//
			//private TextField<String> ismt;   /** column 수정자 : ismt */
			//
			//private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
			//
			//private TextField<String> revnDt;   /** column 수정일자 : revnDt */
			//
			//private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
			 return listColumnDefs;
	    }   
    
}
