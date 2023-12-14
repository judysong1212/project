package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr1550BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.widget.form.Field;

/**
 * @Class Name : Insr1500VO.java
 * @Description : Insr1500 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr1500Def  extends TableDef implements InsrDaoConstants {
	
	private int row = 0;
	private InsrConstants InsrLabel = InsrConstants.INSTANCE;
	
	protected ColumnListDef insr1550ColumnDef;
	
	final PrgmComBass0300DTO sysComBass0300Dto;
	
	protected ColumnDefListenerAdapter changeValueListenerAdapter; 
	
	public void setitemChange(Field itemField,Object itemCd) {
		changeValueListenerAdapter.run(itemField, itemCd);
	}
	
	public Insr1500Def(String chkDef){
		
		sysComBass0300Dto = new PrgmComBass0300DTO();  
		
		if ("INSRP210001".equals(chkDef)) {
			setTitle("");
 	        setDaoClass("");
 	        setCustomListMethod(CLASS_INSRP210001TOINSR1500_DAO_LIST);
 	        setAutoFillGrid(false);
 	       setEditFieldGrid(true);
 	        setShowFilterToolbar(false);
 	        setCheckBoxOnGridRows(true);
 	         	 
	   	   setColumnsDefinition(getInsrp210001ToInsr1500()) ;
		}
		
		if ("INSR2150".equals(chkDef)) {
			setTitle("");
 	        setDaoClass("");
 	        setCustomListMethod(CLASS_INSRP210001TOINSR1500_DAO_LIST);
 	        setAutoFillGrid(false);
 	        setEditFieldGrid(true);
 	        setShowFilterToolbar(false);
 	        setCheckBoxOnGridRows(true);
 	         	 
	   	   setColumnsDefinition(getINSR2150ToInsr1500()) ;
		}
	}
	       
    public List<ColumnDef> getInsrp210001ToInsr1500(){
    	
    	changeValueListenerAdapter = new ColumnDefListenerAdapter() {
            @SuppressWarnings("rawtypes")
            public void run(Field field, Object valueField) {
            }
        };
    	 
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
		
		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Insr1550BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr1550BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column 가족일련번호 : famySeilNum */
		listColumnDefs.add(new ColumnDef("가족일련번호", Insr1550BM.ATTR_FAMYSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});

		/** column 가족일련번호 : famyRelaDivCd */
		listColumnDefs.add(new ColumnDef("가족관계", Insr1550BM.ATTR_FAMYRELADIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column 가족관계 : famyRelaDivNm */
		listColumnDefs.add(new ColumnDef("가족관계", Insr1550BM.ATTR_FAMYRELADIVNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 가족성명 : famyNm */
		listColumnDefs.add(new ColumnDef("가족성명", Insr1550BM.ATTR_FAMYNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 가족주민등록번호 : famyResnRegnNum */
		listColumnDefs.add(new ColumnDef("주민등록번호", Insr1550BM.ATTR_FAMYRESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 가족주민등록번호 : famySecRegnNum */
		listColumnDefs.add(new ColumnDef("주민등록번호", Insr1550BM.ATTR_FAMYSECREGNNUM, ColumnDef.TYPE_STRING , 0, false, false, false){
			{
				setReadOnly(true);
			}
		});

		sysComBass0300Dto.setRpsttvCd("I010"); 
		/** column 취득상실구분코드 : aqtnLssDivCd */
		listColumnDefs.add(new ColumnListDef("취득상실구분", Insr1550BM.ATTR_AQTNDIVCD, ColumnDef.TYPE_STRING , 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
			{
				setReadOnly(true);
			}
		});
		/** column 취득상실구분 : aqtnLssDivNm */
		listColumnDefs.add(new ColumnDef("취득상실구분", Insr1550BM.ATTR_AQTNDIVNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
	
			}
		});
		/** column 취득일자 : aqtnDt */
		listColumnDefs.add(new ColumnDef("취득일자", Insr1550BM.ATTR_AQTNDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{
	
			}
		});
		/** column 취득상실사유코드 : aqtnLssReasCd 
		sysComBass0300Dto.setRpsttvCd("I011"); 
		listColumnDefs.add(new ColumnListDef("취득상실사유", Insr1550BM.ATTR_AQTNREASCD, ColumnDef.TYPE_STRING , 150, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
			{
	
			}
		});
		*/
		sysComBass0300Dto.setRpsttvCd("I011"); 
		insr1550ColumnDef = new ColumnListDef("취득상실사유", Insr1550BM.ATTR_AQTNREASCD, ColumnDef.TYPE_STRING, 150, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
			{ 
				addTrigger(Events.Change, changeValueListenerAdapter);  
			}
		};
		listColumnDefs.add(insr1550ColumnDef);

		/** column 취득상실사유 : aqtnLssReasNm */
		listColumnDefs.add(new ColumnDef("취득상실사유", Insr1550BM.ATTR_AQTNREASNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
	
			}
		});

		/** column 장애인_국적코드 : dbpsnNatnCd */
		listColumnDefs.add(new ColumnDef("국적", Insr1550BM.ATTR_DBPSNNATNNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});

		sysComBass0300Dto.setRpsttvCd("I012"); 
		/** column 장애인_종별부호코드 : dbpsnAssttnSgnCd */
		listColumnDefs.add(new ColumnListDef("종별부호", Insr1550BM.ATTR_DBPSNASSTTNSGNCD, ColumnDef.TYPE_STRING , 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
			{
				addTrigger(Events.Change, changeValueListenerAdapter);  
			}
		});
		/** column 장애인_종별부호코드 : dbpsnAssttnSgnNm */
		listColumnDefs.add(new ColumnDef("종별부호", Insr1550BM.ATTR_DBPSNASSTTNSGNNM, ColumnDef.TYPE_STRING , 130, true, false, true){
			{
	
			}
		});
		/** column 장애인_등급코드 : dbpsnGrdeCd 
		sysComBass0300Dto.setRpsttvCd("I013"); 
		listColumnDefs.add(new ColumnListDef("등급", Insr1550BM.ATTR_DBPSNGRDECD, ColumnDef.TYPE_STRING , 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
			{
	
			}
		});
		*/
		sysComBass0300Dto.setRpsttvCd("I013"); 
		insr1550ColumnDef = new ColumnListDef("등급", Insr1550BM.ATTR_DBPSNGRDECD, ColumnDef.TYPE_STRING, 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
			{ 
				addTrigger(Events.Change, changeValueListenerAdapter);  
			}
		};
		listColumnDefs.add(insr1550ColumnDef);

		/** column 장애인_등급코드 : dbpsnGrdeNm */
		listColumnDefs.add(new ColumnDef("등급", Insr1550BM.ATTR_DBPSNGRDENM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
	
			}
		});
		/** column 장애인_등록일자 : dbpsnRgstnDt */
		listColumnDefs.add(new ColumnDef("등록일자", Insr1550BM.ATTR_DBPSNRGSTNDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{
	
			}
		});

		sysComBass0300Dto.setRpsttvCd("I004"); 
		/** column 외국인_체류자격코드 : frgnrStyQftntCd */
		listColumnDefs.add(new ColumnListDef("체류자격", Insr1550BM.ATTR_FRGNRSTYQFTNTCD, ColumnDef.TYPE_STRING , 130, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
			{
				addTrigger(Events.Change, changeValueListenerAdapter);  
			}
		});
		/** column 외국인_체류자격코드 : frgnrStyQftntCd */
		listColumnDefs.add(new ColumnDef("체류자격", Insr1550BM.ATTR_FRGNRSTYQFTNTNM, ColumnDef.TYPE_STRING , 120, true, false, true){
			{
	
			}
		});
		/** column 외국인_체류시작일자 : frgnrStyBgnnDt */
		listColumnDefs.add(new ColumnDef("시작일자", Insr1550BM.ATTR_FRGNRSTYBGNNDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{
	
			}
		});
		/** column 외국인_체류종료일자 : frgnrStyEndDt */
		listColumnDefs.add(new ColumnDef("종료일자", Insr1550BM.ATTR_FRGNRSTYENDDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{
	
			}
		});
		/** column 사회보험작성일자 : soctyInsurCmptnDt */
		listColumnDefs.add(new ColumnDef("사회보험작성일자", Insr1550BM.ATTR_FAMYAQTNLSSDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
	
			}
		});
		/** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
		listColumnDefs.add(new ColumnDef("사회보험취득_고용_일련번호", Insr1550BM.ATTR_FAMYAQTNLSSNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
	
			}
		});
		
		/** set 사회보험 취득가족신고여부 : socrAqtnFamyYn */
		listColumnDefs.add(new ColumnDef("취득 신고", Insr1550BM.ATTR_SOCRAQTNFAMYYN, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		
		/** set 사회보험 상실가족신고여부 : socrLssFamyYn */
		listColumnDefs.add(new ColumnDef("상실 신고", Insr1550BM.ATTR_SOCRLSSFAMYYN, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		
		return listColumnDefs;
    }
 
    public List<ColumnDef> getINSR2150ToInsr1500(){
    	
    	changeValueListenerAdapter = new ColumnDefListenerAdapter() {
            @SuppressWarnings("rawtypes")
            public void run(Field field, Object valueField) {
            }
        };
    	 
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();

		/** set 사회보험 취득가족신고여부 : socrAqtnFamyYn */
		listColumnDefs.add(new ColumnDef("신고여부", Insr1550BM.ATTR_SOCRAQTNLSSFAMYYN, ColumnDef.TYPE_STRING , 60, true, true, true){
			{
				setReadOnly(true);
			}
		});
		
		/** set 사회보험 취득가족신고여부 : socrAqtnFamyYn */
		listColumnDefs.add(new ColumnDef("취득 신고", Insr1550BM.ATTR_SOCRAQTNFAMYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		
		/** set 사회보험 상실가족신고여부 : socrLssFamyYn */
		listColumnDefs.add(new ColumnDef("상실 신고", Insr1550BM.ATTR_SOCRLSSFAMYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		
		/** column 가족일련번호 : famyRelaDivCd */
		listColumnDefs.add(new ColumnDef("성명", Insr1550BM.ATTR_USEHANNM, ColumnDef.TYPE_STRING , 60, true, true, true){
			{
				setReadOnly(true);
			}
		});
		
		/** column 가족일련번호 : famyRelaDivCd */
		listColumnDefs.add(new ColumnDef("주민등록번호", Insr1550BM.ATTR_USERESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		
		/** column 가족일련번호 : famyRelaDivCd */
		listColumnDefs.add(new ColumnDef("(사업장)", Insr1550BM.ATTR_INSRDPOBPHNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		
		/** column 가족일련번호 : famyRelaDivCd */
		listColumnDefs.add(new ColumnDef("(가입)", Insr1550BM.ATTR_INSRUSEPHNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		
		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Insr1550BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr1550BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column 가족일련번호 : famySeilNum */
		listColumnDefs.add(new ColumnDef("가족일련번호", Insr1550BM.ATTR_FAMYSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column 가족관계 : famyRelaDivNm */
		listColumnDefs.add(new ColumnDef("가족관계", Insr1550BM.ATTR_FAMYRELADIVNM, ColumnDef.TYPE_STRING , 60, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 가족일련번호 : famyRelaDivCd */
		listColumnDefs.add(new ColumnDef("가족관계", Insr1550BM.ATTR_FAMYRELADIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column 가족성명 : famyNm */
		listColumnDefs.add(new ColumnDef("가족성명", Insr1550BM.ATTR_FAMYNM, ColumnDef.TYPE_STRING , 60, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 가족주민등록번호 : famyResnRegnNum */
		listColumnDefs.add(new ColumnDef("주민등록번호", Insr1550BM.ATTR_FAMYRESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		
		/** column 가족주민등록번호 : famySecRegnNum */
		listColumnDefs.add(new ColumnDef("주민등록번호", Insr1550BM.ATTR_FAMYSECREGNNUM, ColumnDef.TYPE_STRING , 0, false, false, false){
			{
				setReadOnly(true);
			}
		});
		

		
		sysComBass0300Dto.setRpsttvCd("I010"); 
		/** column 취득상실구분코드 : aqtnLssDivCd */
		listColumnDefs.add(new ColumnListDef("구분", Insr1550BM.ATTR_AQTNDIVCD, ColumnDef.TYPE_STRING , 60, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
			{
				setReadOnly(true);
			}
		});
		/** column 취득상실구분 : aqtnLssDivNm */
		listColumnDefs.add(new ColumnDef("취득상실구분", Insr1550BM.ATTR_AQTNDIVNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 취득일자 : aqtnDt */
		listColumnDefs.add(new ColumnDef("년월일", Insr1550BM.ATTR_AQTNDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{
				
			}
		});
		
		sysComBass0300Dto.setRpsttvCd("I011"); 
		insr1550ColumnDef = new ColumnListDef("취득상실사유", Insr1550BM.ATTR_AQTNREASCD, ColumnDef.TYPE_STRING, 150, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
			{ 
				addTrigger(Events.Change, changeValueListenerAdapter);  
			}
		};
		listColumnDefs.add(insr1550ColumnDef);

		/** column 취득상실사유 : aqtnLssReasNm */
		listColumnDefs.add(new ColumnDef("취득상실사유", Insr1550BM.ATTR_AQTNREASNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
	
			}
		});
		
		sysComBass0300Dto.setRpsttvCd("I012"); 
		/** column 장애인_종별부호코드 : dbpsnAssttnSgnCd */
		listColumnDefs.add(new ColumnListDef("종별부호", Insr1550BM.ATTR_DBPSNASSTTNSGNCD, ColumnDef.TYPE_STRING , 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
			{
				addTrigger(Events.Change, changeValueListenerAdapter);  
			}
		});
		/** column 장애인_종별부호코드 : dbpsnAssttnSgnNm */
		listColumnDefs.add(new ColumnDef("종별부호", Insr1550BM.ATTR_DBPSNASSTTNSGNNM, ColumnDef.TYPE_STRING , 130, true, false, true){
			{
	
			}
		});
		/** column 장애인_등급코드 : dbpsnGrdeCd 
		sysComBass0300Dto.setRpsttvCd("I013"); 
		listColumnDefs.add(new ColumnListDef("등급", Insr1550BM.ATTR_DBPSNGRDECD, ColumnDef.TYPE_STRING , 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
			{
	
			}
		});
		*/
		sysComBass0300Dto.setRpsttvCd("I013"); 
		insr1550ColumnDef = new ColumnListDef("등급", Insr1550BM.ATTR_DBPSNGRDECD, ColumnDef.TYPE_STRING, 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
			{ 
				addTrigger(Events.Change, changeValueListenerAdapter);  
			}
		};
		listColumnDefs.add(insr1550ColumnDef);

		/** column 장애인_등급코드 : dbpsnGrdeNm */
		listColumnDefs.add(new ColumnDef("등급", Insr1550BM.ATTR_DBPSNGRDENM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
	
			}
		});
		/** column 장애인_등록일자 : dbpsnRgstnDt */
		listColumnDefs.add(new ColumnDef("등록일자", Insr1550BM.ATTR_DBPSNRGSTNDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{
	
			}
		});
		
		/** column 장애인_국적코드 : dbpsnNatnCd */
		listColumnDefs.add(new ColumnDef("외국인국적", Insr1550BM.ATTR_DBPSNNATNNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});

		sysComBass0300Dto.setRpsttvCd("I004"); 
		/** column 외국인_체류자격코드 : frgnrStyQftntCd */
		listColumnDefs.add(new ColumnListDef("체류자격", Insr1550BM.ATTR_FRGNRSTYQFTNTCD, ColumnDef.TYPE_STRING , 130, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
			{
				addTrigger(Events.Change, changeValueListenerAdapter);  
			}
		});
		/** column 외국인_체류자격코드 : frgnrStyQftntCd */
		listColumnDefs.add(new ColumnDef("체류자격", Insr1550BM.ATTR_FRGNRSTYQFTNTNM, ColumnDef.TYPE_STRING , 120, true, false, true){
			{
	
			}
		});
		/** column 외국인_체류시작일자 : frgnrStyBgnnDt */
		listColumnDefs.add(new ColumnDef("시작일자", Insr1550BM.ATTR_FRGNRSTYBGNNDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{
	
			}
		});
		/** column 외국인_체류종료일자 : frgnrStyEndDt */
		listColumnDefs.add(new ColumnDef("종료일자", Insr1550BM.ATTR_FRGNRSTYENDDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{
	
			}
		});
		/** column 사회보험작성일자 : soctyInsurCmptnDt */
		listColumnDefs.add(new ColumnDef("사회보험작성일자", Insr1550BM.ATTR_FAMYAQTNLSSDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
	
			}
		});
		/** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
		listColumnDefs.add(new ColumnDef("사회보험취득_고용_일련번호", Insr1550BM.ATTR_FAMYAQTNLSSNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
	
			}
		});
		
		

		return listColumnDefs;
    }
}
