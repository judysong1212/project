/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.model.model;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.TreeModel;

public class BaseAppModel extends BaseTreeModel {

  protected List<Entry> entries = new ArrayList<Entry>();

  public BaseAppModel() {
//    ExTermsImages g = Resources.IMAGES;
    
//    PersonalModel pslModel = new PersonalModel();
//    
//    for (int i = 0; i < pslModel.getChildren().size(); i++) {
//	      Category cat = (Category) pslModel.getChildren().get(i);  
//	      addCategory(cat); 
//	}
  
//	Category pgm01 = new Category("기초정보관리","BASS0000");
//	pgm01.add("사업장관리", "BASS0100", new Bass0100("사업장관리"));
//	pgm01.add("휴일관리", "BASS0200", new Bass0200("휴일관리"));
//	pgm01.add("코드관리", "BASS0300", new Bass0300("코드관리"));
//	pgm01.add("부서관리", "BASS0400", new Bass0400("부서관리"));
//	pgm01.add("부서별사업관리", "BASS0500", new Bass0500("부서별사업관리")); 
//	pgm01.add("이관작업관리", "BASS0600", new Bass0600("이관작업관리"));  
//	
//	Category pgm02 = new Category("예산관리","BUGT0000");
//	pgm02.add("부서예산관리", "BUGT0100", new Bugt0100("부서예산관리"));
//	pgm02.add("세부사업예산관리", "BUGT0200", new Bugt0200("세부사업예산관리")); 
//	
//	
//	Category pgm03 = new Category("인사관리","PSNL0000");
//	pgm03.add("인사(무기계약직)", "PSNL0100", new Psnl0100("인사(무기계약직)"));
//	pgm03.add("인사(기간제근로자)", "PSNL0200", new Psnl0200("인사(기간제근로자)")); 
//	pgm03.add("인사기본출력", "PSNL0300", new Psnl0300("인사기본출력"));
//	pgm03.add("재발령관리", "PSNL0300", new Psnl0300("재발령관리"));
//    pgm03.add("증명서발급", "PSNL0400", new Psnl0400("증명서발급"));
//    pgm03.add("증명서발급대장", "PSNL0410", new Psnl0410("증명서발급대장")); 
//    pgm03.add("신분증발급", "PSNL0500", new Psnl0500("신분증발급"));  
//    pgm03.add("인사통합출력", "PSNL0300", new Psnl0300("인사통합출력"));
//    
//    Category pgm07 = new Category("4대사회보험전자신고","INSR0000");
//	pgm07.add("사회보험자격취득신고", "INSR1100", new Insr1100("사회보험자격취득신고")); 
//	pgm07.add("사회보험자격상실신고", "INSR5100", new Insr5100("사회보험자격상실신고")); 
////	pgm07.add("자격취득신고대상자조회", "INSR1150", new Insr1150("자격취득신고대상자조회")); 
////	pgm07.add("자격취득신고서관리", "INSR1200", new Insr1200("자격취득신고서관리"));
////	pgm07.add("산재보험취득신고관리", "INSR1250", new Insr1250("산재보험취득신고관리"));
////	pgm07.add("근로내역확인신고서", "INSR1300", new Insr1300("근로내역확인신고서"));
////	pgm07.add("연금자격상실신고서작성", "INSR5100", new Insr5100("연금자격상실신고서작성"));
////	pgm07.add("건강보수총액통보서작성", "INSR5150", new Insr5150("건강보수총액통보서작성"));
////	pgm07.add("고용자격상실신고서작성", "INSR5200", new Insr5200("고용자격상실신고서작성"));
////	pgm07.add("자격상실신고대상자조회", "INSR5250", new Insr5250("자격상실신고대상자조회"));
////	pgm07.add("직장가입자건강취득신고", "INSR5300", new Insr5300("직장가입자건강취득신고"));
////	pgm07.add("연금자격상실신고서관리", "INSR5350", new Insr5350("연금자격상실신고서관리"));
////	pgm07.add("건강보수총액통보서관리", "INSR5400", new Insr5400("건강보수총액통보서관리"));
////	pgm07.add("고용자격상실신고서관리", "INSR5450", new Insr5450("고용자격상실신고서관리"));
////	pgm07.add("산재보험상실신고관리", "INSR5500", new Insr5500("산재보험상실신고관리"));
////	pgm07.add("근로자보수내역전자신고", "INSR5550", new Insr5550("근로자보수내역전자신고"));
//	
//	Category pgm04 = new Category("근태관리","DLGN0000");
//	pgm04.add("근태관리", "Dlgn0100", new Dlgn0100("근태관리")); 
//	
//	
//	Category pgm05 = new Category("급여관리","PAYR0000");
////	pgm05.add("기준정보관리", "PAYR1000",new Psnl0500("신분증발급"));
////	pgm05.add("4대사회보험관리", "PAYR2000",new Psnl0500("신분증발급"));
////	pgm05.add("공제관리", "PAYR3000",new Psnl0500("신분증발급"));
////	pgm05.add("급여관리", "PAYR4000",new Psnl0500("신분증발급")); 
//	
////	pgm05.add("기준정보관리", "PAYR1000");
////	pgm05.add("4대사회보험관리", "PAYR2000");
////	pgm05.add("공제관리", "PAYR3000");
////	pgm05.add("급여관리", "PAYR4000"); 
//	
//	pgm05.add("간이소득세액관리", "PAYR1000",new Payr1100("간이소득세액관리"));
//	pgm05.add("직종등급관리", "PAYR1200",new Payr1200("직종등급관리"));
//	pgm05.add("수당관리", "PAYR1300",new Payr1300("수당관리"));
//	pgm05.add("공제관리", "PAYR1400",new Payr1400("공제관리"));
//	pgm05.add("지급공제항목관리(무기계약직)", "PAYR1500",new Payr1500("지급공제항목관리(무기계약직)"));
//	pgm05.add("지급공제항목관리(기간제근로자)", "PAYR1600",new Payr1600("지급공제항목관리(기간제근로자)"));
//	pgm05.add("급여계좌관리", "PAYR1700",new Payr1700("급여계좌관리"));
//	pgm05.add("급여단가관리", "PAYR2200",new Payr2200("급여단가관리"));
//	pgm05.add("사회보험기준관리", "PAYR2100",new Payr2100("사회보험기준관리")); 
//	pgm05.add("4대사회보험출력", "PAYR2300",new Payr2300("4대사회보험출력"));
//	//pgm05.add("고용보험공제관리", "PAYR2400",new Payr2400("고용보험공제관리")); 
//	//pgm05.add("고용보험공제관리", "PAYR2500",new Payr2500("산재보험납부관리")); 
//	
//	pgm05.add("채권압류공제관리", "PAYR3100",new Payr3100("채권압류공제관리"));
//	pgm05.add("기타공제관리", "PAYR3200",new Payr3200("기타공제관리"));
//	pgm05.add("급여대상자관리", "PAYR4100",new Payr4100("급여대상자관리"));
//	pgm05.add("급여계산관리", "PAYR4150",new Payr4150("급여계산"));
//	pgm05.add("급여내역관리", "PAYR4200",new Payr4200("급여내역관리"));
//	pgm05.add("급여마감관리", "PAYR4250",new Payr4250("급여마감관리"));
//	pgm05.add("급여지급명세서", "PAYR4300",new Payr4300("급여지급명세서"));
//	pgm05.add("급여대장", "PAYR4350",new Payr4350("급여대장"));
//	pgm05.add("급여지로이체명세서", "PAYR4400",new Payr4400("급여지로이체명세서"));
//	pgm05.add("수당지급명세서", "PAYR4450",new Payr4450("수당지급명세서"));
//	pgm05.add("공제내역서", "PAYR4500",new Payr4500("공제내역서"));
//	pgm05.add("근로소득원천영수부", "PAYR4550",new Payr4550("근로소득원천영수부"));
//	pgm05.add("지급조서(분기별)", "PAYR4600",new Payr4600("지급조서(분기별)"));     
//	
//	Category pgm06 = new Category("퇴직금관리","REMT0000");
//	pgm06.add("퇴직정산대상자관리", "REMT0100", new Remt0100("퇴직정산대상자관리"));
//	pgm06.add("퇴직평균임금산출", "REMT0200", new Remt0200("퇴직평균임금산출"));
//	pgm06.add("퇴직정산관리", "REMT0300", new Remt0300("퇴직정산관리"));
//	 
//	
//	
//	Category pgm08 = new Category("연말정산관리","YETA0000");
//	pgm08.add("연말정산대상자관리", "YETA0100", new Yeta0100("연말정산대상자관리"));
//	pgm08.add("전자문서자료추출", "YETA0200", new Yeta0200("전자문서자료추출"));
//	pgm08.add("소득공제신고자료관리", "YETA0300", new Yeta0300("소득공제신고자료관리"));
//	pgm08.add("연말정산신고파일생성", "YETA0400", new Yeta0400("연말정산신고파일생성"));
//	
//	
//	Category pgm09 = new Category("시스템관리","SYSM0000");
//	
//	Category subPgm09 = new Category("시스템관리1","SYSM0001");
//	
//	
//	pgm09.add("사용자관리", "SYSM0100", new Sysm0100("사용자관리")); 
//	pgm09.add("메뉴관리", "SYSM0200", new Sysm0200("메뉴관리"));
//	subPgm09.add("사용자권한관리", "SYSM0300", new Sysm0300("사용자권한관리")); 
//	subPgm09.add("권한그룹관리", "SYSM0400", new Sysm0400("권한그룹관리"));
//	subPgm09.add("메뉴권한그룹관리", "SYSM0500", new Sysm0500("메뉴권한그룹관리")); 
//	 
//	pgm09.add(subPgm09); 
	
//	addCategory(pgm02);
//	addCategory(pgm03);
//	addCategory(pgm04);
//	addCategory(pgm05);
//	addCategory(pgm06);
//	addCategory(pgm07); 
//	addCategory(pgm08); 
//	addCategory(pgm09);  
   // loadEntries(this);
   
  }
  
   public void addCategory(ModelData child) {
//		try{
//			 Class t = Class.forName("com.gxt.riaapp.client.mvc.SmplProgram");
//			}catch(java.lang.ClassNotFoundException e){
//				System.out.println(e.toString());
//			}
		if(child != null)
			add(child);
	}

  public Entry findEntry(String name) {
    if (get(name) != null) {
      return (Entry) get(name);
    }
    for (Entry entry : getEntries()) {
      if (name.equals(entry.getId())) {
        return entry;
      }
    }
    return null;
  }

  public List<Entry> getEntries() {
    return entries;
  }

  private void loadEntries(TreeModel model) {
    for (ModelData child : model.getChildren()) {
      if (child instanceof Entry) {
        entries.add((Entry) child);
      } else if (child instanceof Category) {
        loadEntries((Category) child);
      }
    }
  }
}
