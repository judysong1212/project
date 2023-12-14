package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr2100BM;
import com.app.exterms.insurance.client.dto.Insr2200BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr2200VO.java
 * @Description : Insr2200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr2200Def  extends TableDef implements InsrDaoConstants {
	    private int row = 0;
	    private InsrConstants InsrLabel = InsrConstants.INSTANCE;
	    final PrgmComBass0300DTO sysComBass0300Dto;
	    
	    public Insr2200Def(String chkDef){
	    	
	    	sysComBass0300Dto = new PrgmComBass0300DTO(); 
	    	
	    	if ("INSR2300".equals(chkDef)) {
	    		setTitle("");
		        setDaoClass("");
		        setCustomListMethod(CLASS_INSR2300TOINSR2200_DAO_LIST);
		        setAutoFillGrid(false);
		        setShowFilterToolbar(false);
		        setCheckBoxOnGridRows(true);
		        setFilterFormType(FILTER_FORM_SINGLE);
		        
		        setColumnsDefinition(getInsr2300ToInsr2200());
	    	}else if("INSRP230005".equals(chkDef)) {
	    		setTitle("");
		        setDaoClass("");
		        setCustomListMethod(CLASS_INSR2300TOINSR2200_DAO_LIST);
		        setAutoFillGrid(false);
		        setShowFilterToolbar(false);
		        setCheckBoxOnGridRows(true);
		        setFilterFormType(FILTER_FORM_SINGLE);
		        
		        setColumnsDefinition(getPInsr230005ToInsr2200());
	    	}
	    	else if("INSR2400".equals(chkDef)) {
	    		setTitle("");
		        setDaoClass("");
		        setCustomListMethod(CLASS_INSR2400TOINSR2200_DAO_LIST);
		        setAutoFillGrid(false);
		        setShowFilterToolbar(false);
		        setCheckBoxOnGridRows(true);
		        setFilterFormType(FILTER_FORM_SINGLE);
		        
		        setColumnsDefinition(getInsr2300ToInsr2400());
	    	}
	    }

public List<ColumnDef> getInsr2300ToInsr2200(){
	
	
	  List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 	

	  
	  
	 
	  
	  
		listColumnDefs.add(new ColumnDef("퇴직일자", Insr2200BM.ATTR_RETRYDT, ColumnDef.TYPE_STRING , 60, true, false, true){
			{
		
			}
		});
	  
	  
		/** column 사회보험작성일자 : soctyInsurCmptnDt */
		listColumnDefs.add(new ColumnDef("작성일자", Insr2200BM.ATTR_SOCTYINSURCMPTNDT, ColumnDef.TYPE_STRING , 60, true, false, true){
			{
		
			}
		});
	  
		/** column 사회보험상실신고_ITEM_VALUE08 : socnsrIssRegVal08 */
		listColumnDefs.add(new ColumnDef("상실일자", Insr2200BM.ATTR_SOCNSRISSREGVAL08, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		
	  /** column 한글성명 : hanNm */
	  listColumnDefs.add(new ColumnDef("성명", Insr2200BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, false){
		  {
			  setReadOnly(true);
		  }
	  });

	  /** column 주민등록번호 : resnRegnNum */
	  listColumnDefs.add(new ColumnDef("주민등록번호", Insr2200BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, false){
		  {
			  setReadOnly(true);
		  }
	  });
	  
	  /** column 주민등록번호 : secRegnNum */
	  listColumnDefs.add(new ColumnDef("주민등록번호", Insr2200BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
		  {
			  setReadOnly(true);
		  }
	  });

		 /** column 고용구분코드 : emymtDivCd */
      listColumnDefs.add(new ColumnDef("고용구분", Insr2100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, false, false, false){
          {
              setReadOnly(true);
          }
      });

		
	   /** column 직종코드 : typOccuCd */
	   listColumnDefs.add(new ColumnDef("직종", Insr2100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, false, false){
	       {
	       	  setReadOnly(true);
	       }
	   });
      
	  /** column 피부양자여부 : insr1400Yn */
	  /*				listColumnDefs.add(new ColumnDef("피부양", Insr2100BM.ATTR_INSR1400YN, ColumnDef.TYPE_BOOLEAN , 50, true, true, true){
      					{
      						 setReadOnly(true);
      					}
      				});
	   */


	   /** column 피부양자여부 : insr1600Yn */
		listColumnDefs.add(new ColumnDef("피부양", Insr2200BM.ATTR_INSR1600YN, ColumnDef.TYPE_BOOLEAN , 50, true, false, true){
			{
				 setReadOnly(true);
			}
		});

	  /** column 사회보험가입자전화번호 : socInsrMbrPhnNum */
	  listColumnDefs.add(new ColumnDef("사회보험가입자전화번호", Insr2200BM.ATTR_SOCINSRMBRPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
		  {

		  }
	  });
	  /** column 국민연금신고여부 : natPennRegrstYn */
	  listColumnDefs.add(new ColumnDef("국민", Insr2200BM.ATTR_NATPENNREGRSTYN, ColumnDef.TYPE_BOOLEAN , 30, true, true, true){
		  {

		  }
	  });
	  /** column 건강보험신고여부 : hlthInsrRegrstYn */
	  listColumnDefs.add(new ColumnDef("건강", Insr2200BM.ATTR_HLTHINSRREGRSTYN, ColumnDef.TYPE_BOOLEAN , 30, true, true, true){
		  {

		  }
	  });

	  /** column 고용보험신고여부 : umytInsrRegrstYn */
	  listColumnDefs.add(new ColumnDef("고용", Insr2200BM.ATTR_UMYTINSRREGRSTYN, ColumnDef.TYPE_BOOLEAN , 30, true, true, true){
		  {

		  }
	  });
	  /** column 산재보험신고여부 : idtlAccdtRegrstYn */
	  listColumnDefs.add(new ColumnDef("산재", Insr2200BM.ATTR_IDTLACCDTREGRSTYN, ColumnDef.TYPE_BOOLEAN , 30, true, true, true){
		  {

		  }
	  });


	  /** column 사회보험상실일자 : soctyInsurLssDt */
	  listColumnDefs.add(new ColumnDef("사회보험상실일자", Insr2200BM.ATTR_SOCTYINSURLSSDT, ColumnDef.TYPE_STRING , 90, true, false, true){
		  {

		  }
	  });


	  /** column 부서코드 : deptCd */
	  listColumnDefs.add(new ColumnDef("부서", Insr2200BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, false, true, false){
		  {
			  setReadOnly(true);
		  }
	  });
          

	  /** column 직종세구분 : dtilOccuClsDivCd */
	  listColumnDefs.add(new ColumnDef("직종세", Insr2200BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, true, false){
		  {
			  setReadOnly(true);
		  }
	  });


	  /** column 사업 : businCd */
	  listColumnDefs.add(new ColumnDef("사업", Insr2200BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, true, false){
		  {
			  setReadOnly(true);
		  }
	  });


	  
	  
		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Insr2200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr2200BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});

		/** column 사회보험상실_고용_일련번호 : socInsrLssEmymtNum */
		listColumnDefs.add(new ColumnDef("사회보험상실_고용_일련번호", Insr2200BM.ATTR_SOCINSRLSSEMYMTNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE01 : socnsrIssRegVal0 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE01", Insr2200BM.ATTR_SOCNSRISSREGVAL01, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE02 : socnsrIssRegVal02 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE02", Insr2200BM.ATTR_SOCNSRISSREGVAL02, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE03 : socnsrIssRegVal03 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE03", Insr2200BM.ATTR_SOCNSRISSREGVAL03, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE04 : socnsrIssRegVal04 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE04", Insr2200BM.ATTR_SOCNSRISSREGVAL04, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE05 : socnsrIssRegVal05 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE05", Insr2200BM.ATTR_SOCNSRISSREGVAL05, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE06 : socnsrIssRegVal06 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE06", Insr2200BM.ATTR_SOCNSRISSREGVAL06, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE07 : socnsrIssRegVal07 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE07", Insr2200BM.ATTR_SOCNSRISSREGVAL07, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});

		/** column 사회보험상실신고_ITEM_VALUE09 : socnsrIssRegVal09 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE09", Insr2200BM.ATTR_SOCNSRISSREGVAL09, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE10 : socnsrIssRegVal10 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE10", Insr2200BM.ATTR_SOCNSRISSREGVAL10, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE11 : socnsrIssRegVal11 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE11", Insr2200BM.ATTR_SOCNSRISSREGVAL11, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE12 : socnsrIssRegVal12 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE12", Insr2200BM.ATTR_SOCNSRISSREGVAL12, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE13 : socnsrIssRegVal13 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE13", Insr2200BM.ATTR_SOCNSRISSREGVAL13, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE14 : socnsrIssRegVal14 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE14", Insr2200BM.ATTR_SOCNSRISSREGVAL14, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE15 : socnsrIssRegVal15 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE15", Insr2200BM.ATTR_SOCNSRISSREGVAL15, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE16 : socnsrIssRegVal16 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE16", Insr2200BM.ATTR_SOCNSRISSREGVAL16, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE17 : socnsrIssRegVal17 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE17", Insr2200BM.ATTR_SOCNSRISSREGVAL17, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE18 : socnsrIssRegVal18 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE18", Insr2200BM.ATTR_SOCNSRISSREGVAL18, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE19 : socnsrIssRegVal19 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE19", Insr2200BM.ATTR_SOCNSRISSREGVAL19, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE20 : socnsrIssRegVal20 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE20", Insr2200BM.ATTR_SOCNSRISSREGVAL20, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE21 : socnsrIssRegVal21 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE21", Insr2200BM.ATTR_SOCNSRISSREGVAL21, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE22 : socnsrIssRegVal22 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE22", Insr2200BM.ATTR_SOCNSRISSREGVAL22, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE23 : socnsrIssRegVal23 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE23", Insr2200BM.ATTR_SOCNSRISSREGVAL23, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE24 : socnsrIssRegVal24 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE24", Insr2200BM.ATTR_SOCNSRISSREGVAL24, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE25 : socnsrIssRegVal25 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE25", Insr2200BM.ATTR_SOCNSRISSREGVAL25, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE26 : socnsrIssRegVal26 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE26", Insr2200BM.ATTR_SOCNSRISSREGVAL26, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE27 : socnsrIssRegVal27 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE27", Insr2200BM.ATTR_SOCNSRISSREGVAL27, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE28 : socnsrIssRegVal28 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE28", Insr2200BM.ATTR_SOCNSRISSREGVAL28, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE29 : socnsrIssRegVal29 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE29", Insr2200BM.ATTR_SOCNSRISSREGVAL29, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE30 : socnsrIssRegVal30 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE30", Insr2200BM.ATTR_SOCNSRISSREGVAL30, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE31 : socnsrIssRegVal31 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE31", Insr2200BM.ATTR_SOCNSRISSREGVAL31, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE32 : socnsrIssRegVal32 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE32", Insr2200BM.ATTR_SOCNSRISSREGVAL32, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE33 : socnsrIssRegVal33 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE33", Insr2200BM.ATTR_SOCNSRISSREGVAL33, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE34 : socnsrIssRegVal34 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE34", Insr2200BM.ATTR_SOCNSRISSREGVAL34, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE35 : socnsrIssRegVal35 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE35", Insr2200BM.ATTR_SOCNSRISSREGVAL35, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE36 : socnsrIssRegVal36 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE36", Insr2200BM.ATTR_SOCNSRISSREGVAL36, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE37 : socnsrIssRegVal37 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE37", Insr2200BM.ATTR_SOCNSRISSREGVAL37, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE38 : socnsrIssRegVal38 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE38", Insr2200BM.ATTR_SOCNSRISSREGVAL38, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE39 : socnsrIssRegVal39 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE39", Insr2200BM.ATTR_SOCNSRISSREGVAL39, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE40 : socnsrIssRegVal40 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE40", Insr2200BM.ATTR_SOCNSRISSREGVAL40, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE41 : socnsrIssRegVal41 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE41", Insr2200BM.ATTR_SOCNSRISSREGVAL41, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE42 : socnsrIssRegVal42 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE42", Insr2200BM.ATTR_SOCNSRISSREGVAL42, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE43 : socnsrIssRegVal43 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE43", Insr2200BM.ATTR_SOCNSRISSREGVAL43, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE44 : socnsrIssRegVal44 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE44", Insr2200BM.ATTR_SOCNSRISSREGVAL44, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE45 : socnsrIssRegVal45 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE45", Insr2200BM.ATTR_SOCNSRISSREGVAL45, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE46 : socnsrIssRegVal46 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE46", Insr2200BM.ATTR_SOCNSRISSREGVAL46, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE47 : socnsrIssRegVal47 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE47", Insr2200BM.ATTR_SOCNSRISSREGVAL47, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE48 : socnsrIssRegVal48 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE48", Insr2200BM.ATTR_SOCNSRISSREGVAL48, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE49 : socnsrIssRegVal49 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE49", Insr2200BM.ATTR_SOCNSRISSREGVAL49, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE50 : socnsrIssRegVal50 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE50", Insr2200BM.ATTR_SOCNSRISSREGVAL50, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE51 : socnsrIssRegVal51 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE51", Insr2200BM.ATTR_SOCNSRISSREGVAL51, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE52 : socnsrIssRegVal52 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE52", Insr2200BM.ATTR_SOCNSRISSREGVAL52, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE53 : socnsrIssRegVal53 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE53", Insr2200BM.ATTR_SOCNSRISSREGVAL53, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE54 : socnsrIssRegVal54 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE54", Insr2200BM.ATTR_SOCNSRISSREGVAL54, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE55 : socnsrIssRegVal55 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE55", Insr2200BM.ATTR_SOCNSRISSREGVAL55, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE56 : socnsrIssRegVal56 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE56", Insr2200BM.ATTR_SOCNSRISSREGVAL56, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE57 : socnsrIssRegVal57 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE57", Insr2200BM.ATTR_SOCNSRISSREGVAL57, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE58 : socnsrIssRegVal58 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE58", Insr2200BM.ATTR_SOCNSRISSREGVAL58, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE59 : socnsrIssRegVal59 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE59", Insr2200BM.ATTR_SOCNSRISSREGVAL59, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE60 : socnsrIssRegVal60 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE60", Insr2200BM.ATTR_SOCNSRISSREGVAL60, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE61 : socnsrIssRegVal61 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE61", Insr2200BM.ATTR_SOCNSRISSREGVAL61, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE62 : socnsrIssRegVal62 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE62", Insr2200BM.ATTR_SOCNSRISSREGVAL62, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE63 : socnsrIssRegVal63 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE63", Insr2200BM.ATTR_SOCNSRISSREGVAL63, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE64 : socnsrIssRegVal64 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE64", Insr2200BM.ATTR_SOCNSRISSREGVAL64, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE65 : socnsrIssRegVal65 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE65", Insr2200BM.ATTR_SOCNSRISSREGVAL65, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE66 : socnsrIssRegVal66 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE66", Insr2200BM.ATTR_SOCNSRISSREGVAL66, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE67 : socnsrIssRegVal67 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE67", Insr2200BM.ATTR_SOCNSRISSREGVAL67, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE68 : socnsrIssRegVal68 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE68", Insr2200BM.ATTR_SOCNSRISSREGVAL68, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE69 : socnsrIssRegVal69 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE69", Insr2200BM.ATTR_SOCNSRISSREGVAL69, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE70 : socnsrIssRegVal70 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE70", Insr2200BM.ATTR_SOCNSRISSREGVAL70, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE71 : socnsrIssRegVal71 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE71", Insr2200BM.ATTR_SOCNSRISSREGVAL71, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE72 : socnsrIssRegVal72 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE72", Insr2200BM.ATTR_SOCNSRISSREGVAL72, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE73 : socnsrIssRegVal73 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE73", Insr2200BM.ATTR_SOCNSRISSREGVAL73, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE74 : socnsrIssRegVal74 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE74", Insr2200BM.ATTR_SOCNSRISSREGVAL74, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE75 : socnsrIssRegVal75 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE75", Insr2200BM.ATTR_SOCNSRISSREGVAL75, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE76 : socnsrIssRegVal76 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE76", Insr2200BM.ATTR_SOCNSRISSREGVAL76, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE77 : socnsrIssRegVal77 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE77", Insr2200BM.ATTR_SOCNSRISSREGVAL77, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE78 : socnsrIssRegVal78 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE78", Insr2200BM.ATTR_SOCNSRISSREGVAL78, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE79 : socnsrIssRegVal79 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE79", Insr2200BM.ATTR_SOCNSRISSREGVAL79, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE80 : socnsrIssRegVal80 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE80", Insr2200BM.ATTR_SOCNSRISSREGVAL80, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Insr2200BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Insr2200BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Insr2200BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Insr2200BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Insr2200BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Insr2200BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		return listColumnDefs;


		 
	    }  





public List<ColumnDef> getPInsr230005ToInsr2200(){
	
	
	  List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 	

	  /** column 국민연금신고여부 : natPennRegrstYn */
	  listColumnDefs.add(new ColumnDef("국민", Insr2200BM.ATTR_NATPENNREGRSTYN, ColumnDef.TYPE_BOOLEAN , 40, true, true, true){
		  {

		  }
	  });
	  /** column 건강보험신고여부 : hlthInsrRegrstYn */
	  listColumnDefs.add(new ColumnDef("건강", Insr2200BM.ATTR_HLTHINSRREGRSTYN, ColumnDef.TYPE_BOOLEAN , 40, true, true, true){
		  {

		  }
	  });

	  /** column 고용보험신고여부 : umytInsrRegrstYn */
	  listColumnDefs.add(new ColumnDef("고용", Insr2200BM.ATTR_UMYTINSRREGRSTYN, ColumnDef.TYPE_BOOLEAN , 40, true, true, true){
		  {

		  }
	  });
	  /** column 산재보험신고여부 : idtlAccdtRegrstYn */
	  listColumnDefs.add(new ColumnDef("산재", Insr2200BM.ATTR_IDTLACCDTREGRSTYN, ColumnDef.TYPE_BOOLEAN , 40, true, true, true){
		  {

		  }
	  });
	  
		/** column 사회보험작성일자 : soctyInsurCmptnDt */
		listColumnDefs.add(new ColumnDef("작성일자", Insr2200BM.ATTR_SOCTYINSURCMPTNDT, ColumnDef.TYPE_STRING , 60, true, false, true){
			{
		
			}
		});
	  
	  /** column 한글성명 : hanNm */
	  listColumnDefs.add(new ColumnDef("성명", Insr2200BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, false){
		  {
			  setReadOnly(true);
		  }
	  });

	  /** column 주민등록번호 : resnRegnNum */
	  listColumnDefs.add(new ColumnDef("주민등록번호", Insr2200BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, false){
		  {
			  setReadOnly(true);
		  }
	  });
	  /** column 주민등록번호 : secRegnNum */
	  listColumnDefs.add(new ColumnDef("주민등록번호", Insr2200BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
		  {
			  setReadOnly(true);
		  }
	  });
		 /** column 고용구분코드 : emymtDivCd */
    listColumnDefs.add(new ColumnDef("고용구분", Insr2100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, false, false, false){
        {
            setReadOnly(true);
        }
    });

		
	   /** column 직종코드 : typOccuCd */
	   listColumnDefs.add(new ColumnDef("직종", Insr2100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, false, false){
	       {
	       	  setReadOnly(true);
	       }
	   });
    
	  /** column 피부양자여부 : insr1400Yn */
	  /*				listColumnDefs.add(new ColumnDef("피부양", Insr2100BM.ATTR_INSR1400YN, ColumnDef.TYPE_BOOLEAN , 50, true, true, true){
    					{
    						 setReadOnly(true);
    					}
    				});
	   */



	  /** column 사회보험가입자전화번호 : socInsrMbrPhnNum */
	/*  listColumnDefs.add(new ColumnDef("사회보험가입자전화번호", Insr2200BM.ATTR_SOCINSRMBRPHNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
		  {

		  }
	  });*/



	  /** column 사회보험상실일자 : soctyInsurLssDt */
	  listColumnDefs.add(new ColumnDef("사회보험상실일자", Insr2200BM.ATTR_SOCTYINSURLSSDT, ColumnDef.TYPE_STRING , 90, true, false, true){
		  {

		  }
	  });


	  /** column 부서코드 : deptCd */
	  listColumnDefs.add(new ColumnDef("부서", Insr2200BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, false, false, false){
		  {
			  setReadOnly(true);
		  }
	  });
        

	  /** column 직종세구분 : dtilOccuClsDivCd */
	  listColumnDefs.add(new ColumnDef("직종세", Insr2200BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, false, false){
		  {
			  setReadOnly(true);
		  }
	  });


	  /** column 사업 : businCd */
	  listColumnDefs.add(new ColumnDef("사업", Insr2200BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, false, false){
		  {
			  setReadOnly(true);
		  }
	  });


	  
	  
		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Insr2200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr2200BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});

		/** column 사회보험상실_고용_일련번호 : socInsrLssEmymtNum */
		listColumnDefs.add(new ColumnDef("사회보험상실_고용_일련번호", Insr2200BM.ATTR_SOCINSRLSSEMYMTNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE01 : socnsrIssRegVal0 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE01", Insr2200BM.ATTR_SOCNSRISSREGVAL01, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE02 : socnsrIssRegVal02 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE02", Insr2200BM.ATTR_SOCNSRISSREGVAL02, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE03 : socnsrIssRegVal03 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE03", Insr2200BM.ATTR_SOCNSRISSREGVAL03, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE04 : socnsrIssRegVal04 */
		listColumnDefs.add(new ColumnDef("전화번호", Insr2200BM.ATTR_SOCNSRISSREGVAL04, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE05 : socnsrIssRegVal05 */
		listColumnDefs.add(new ColumnDef("상실일", Insr2200BM.ATTR_SOCNSRISSREGVAL05, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE06 : socnsrIssRegVal06 */
		listColumnDefs.add(new ColumnDef("상실부호", Insr2200BM.ATTR_SOCNSRISSREGVAL06, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE07 : socnsrIssRegVal07 */
		listColumnDefs.add(new ColumnDef("초일취득,당월상실자 납부여부", Insr2200BM.ATTR_SOCNSRISSREGVAL07, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE08 : socnsrIssRegVal08 */
		listColumnDefs.add(new ColumnDef("상실일", Insr2200BM.ATTR_SOCNSRISSREGVAL08, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE09 : socnsrIssRegVal09 */
		listColumnDefs.add(new ColumnDef("상실부호", Insr2200BM.ATTR_SOCNSRISSREGVAL09, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE10 : socnsrIssRegVal10 */
		listColumnDefs.add(new ColumnDef("퇴직전3개월평균보수", Insr2200BM.ATTR_SOCNSRISSREGVAL10, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE11 : socnsrIssRegVal11 */
		listColumnDefs.add(new ColumnDef("당해년도보수총액", Insr2200BM.ATTR_SOCNSRISSREGVAL11, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE12 : socnsrIssRegVal12 */
		listColumnDefs.add(new ColumnDef("당해년도산정월수", Insr2200BM.ATTR_SOCNSRISSREGVAL12, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE13 : socnsrIssRegVal13 */
		listColumnDefs.add(new ColumnDef("전년도정산구분", Insr2200BM.ATTR_SOCNSRISSREGVAL13, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE14 : socnsrIssRegVal14 */
		listColumnDefs.add(new ColumnDef("전년도보수총액", Insr2200BM.ATTR_SOCNSRISSREGVAL14, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE15 : socnsrIssRegVal15 */
		listColumnDefs.add(new ColumnDef("전년도산정월수", Insr2200BM.ATTR_SOCNSRISSREGVAL15, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE16 : socnsrIssRegVal16 */
		listColumnDefs.add(new ColumnDef("상실사유", Insr2200BM.ATTR_SOCNSRISSREGVAL16, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE17 : socnsrIssRegVal17 */
		listColumnDefs.add(new ColumnDef("구체적상실사유", Insr2200BM.ATTR_SOCNSRISSREGVAL17, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE18 : socnsrIssRegVal18 */
		listColumnDefs.add(new ColumnDef("상실일", Insr2200BM.ATTR_SOCNSRISSREGVAL18, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE19 : socnsrIssRegVal19 */
		listColumnDefs.add(new ColumnDef("당해년도보수총액", Insr2200BM.ATTR_SOCNSRISSREGVAL19, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE20 : socnsrIssRegVal20 */
		listColumnDefs.add(new ColumnDef("상실사유", Insr2200BM.ATTR_SOCNSRISSREGVAL20, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE21 : socnsrIssRegVal21 */
		listColumnDefs.add(new ColumnDef("구체적상실사유", Insr2200BM.ATTR_SOCNSRISSREGVAL21, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE22 : socnsrIssRegVal22 */
		listColumnDefs.add(new ColumnDef("상실일", Insr2200BM.ATTR_SOCNSRISSREGVAL22, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE23 : socnsrIssRegVal23 */
		listColumnDefs.add(new ColumnDef("당해년도보수총액", Insr2200BM.ATTR_SOCNSRISSREGVAL23, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE24 : socnsrIssRegVal24 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE24", Insr2200BM.ATTR_SOCNSRISSREGVAL24, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE25 : socnsrIssRegVal25 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE25", Insr2200BM.ATTR_SOCNSRISSREGVAL25, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE26 : socnsrIssRegVal26 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE26", Insr2200BM.ATTR_SOCNSRISSREGVAL26, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE27 : socnsrIssRegVal27 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE27", Insr2200BM.ATTR_SOCNSRISSREGVAL27, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE28 : socnsrIssRegVal28 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE28", Insr2200BM.ATTR_SOCNSRISSREGVAL28, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE29 : socnsrIssRegVal29 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE29", Insr2200BM.ATTR_SOCNSRISSREGVAL29, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE30 : socnsrIssRegVal30 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE30", Insr2200BM.ATTR_SOCNSRISSREGVAL30, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE31 : socnsrIssRegVal31 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE31", Insr2200BM.ATTR_SOCNSRISSREGVAL31, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE32 : socnsrIssRegVal32 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE32", Insr2200BM.ATTR_SOCNSRISSREGVAL32, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE33 : socnsrIssRegVal33 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE33", Insr2200BM.ATTR_SOCNSRISSREGVAL33, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE34 : socnsrIssRegVal34 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE34", Insr2200BM.ATTR_SOCNSRISSREGVAL34, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE35 : socnsrIssRegVal35 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE35", Insr2200BM.ATTR_SOCNSRISSREGVAL35, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE36 : socnsrIssRegVal36 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE36", Insr2200BM.ATTR_SOCNSRISSREGVAL36, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE37 : socnsrIssRegVal37 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE37", Insr2200BM.ATTR_SOCNSRISSREGVAL37, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE38 : socnsrIssRegVal38 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE38", Insr2200BM.ATTR_SOCNSRISSREGVAL38, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE39 : socnsrIssRegVal39 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE39", Insr2200BM.ATTR_SOCNSRISSREGVAL39, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE40 : socnsrIssRegVal40 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE40", Insr2200BM.ATTR_SOCNSRISSREGVAL40, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE41 : socnsrIssRegVal41 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE41", Insr2200BM.ATTR_SOCNSRISSREGVAL41, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE42 : socnsrIssRegVal42 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE42", Insr2200BM.ATTR_SOCNSRISSREGVAL42, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE43 : socnsrIssRegVal43 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE43", Insr2200BM.ATTR_SOCNSRISSREGVAL43, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE44 : socnsrIssRegVal44 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE44", Insr2200BM.ATTR_SOCNSRISSREGVAL44, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE45 : socnsrIssRegVal45 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE45", Insr2200BM.ATTR_SOCNSRISSREGVAL45, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE46 : socnsrIssRegVal46 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE46", Insr2200BM.ATTR_SOCNSRISSREGVAL46, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE47 : socnsrIssRegVal47 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE47", Insr2200BM.ATTR_SOCNSRISSREGVAL47, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE48 : socnsrIssRegVal48 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE48", Insr2200BM.ATTR_SOCNSRISSREGVAL48, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE49 : socnsrIssRegVal49 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE49", Insr2200BM.ATTR_SOCNSRISSREGVAL49, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE50 : socnsrIssRegVal50 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE50", Insr2200BM.ATTR_SOCNSRISSREGVAL50, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE51 : socnsrIssRegVal51 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE51", Insr2200BM.ATTR_SOCNSRISSREGVAL51, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE52 : socnsrIssRegVal52 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE52", Insr2200BM.ATTR_SOCNSRISSREGVAL52, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE53 : socnsrIssRegVal53 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE53", Insr2200BM.ATTR_SOCNSRISSREGVAL53, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE54 : socnsrIssRegVal54 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE54", Insr2200BM.ATTR_SOCNSRISSREGVAL54, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE55 : socnsrIssRegVal55 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE55", Insr2200BM.ATTR_SOCNSRISSREGVAL55, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE56 : socnsrIssRegVal56 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE56", Insr2200BM.ATTR_SOCNSRISSREGVAL56, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE57 : socnsrIssRegVal57 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE57", Insr2200BM.ATTR_SOCNSRISSREGVAL57, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE58 : socnsrIssRegVal58 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE58", Insr2200BM.ATTR_SOCNSRISSREGVAL58, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE59 : socnsrIssRegVal59 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE59", Insr2200BM.ATTR_SOCNSRISSREGVAL59, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE60 : socnsrIssRegVal60 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE60", Insr2200BM.ATTR_SOCNSRISSREGVAL60, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE61 : socnsrIssRegVal61 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE61", Insr2200BM.ATTR_SOCNSRISSREGVAL61, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE62 : socnsrIssRegVal62 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE62", Insr2200BM.ATTR_SOCNSRISSREGVAL62, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE63 : socnsrIssRegVal63 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE63", Insr2200BM.ATTR_SOCNSRISSREGVAL63, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE64 : socnsrIssRegVal64 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE64", Insr2200BM.ATTR_SOCNSRISSREGVAL64, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE65 : socnsrIssRegVal65 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE65", Insr2200BM.ATTR_SOCNSRISSREGVAL65, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE66 : socnsrIssRegVal66 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE66", Insr2200BM.ATTR_SOCNSRISSREGVAL66, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE67 : socnsrIssRegVal67 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE67", Insr2200BM.ATTR_SOCNSRISSREGVAL67, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE68 : socnsrIssRegVal68 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE68", Insr2200BM.ATTR_SOCNSRISSREGVAL68, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE69 : socnsrIssRegVal69 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE69", Insr2200BM.ATTR_SOCNSRISSREGVAL69, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE70 : socnsrIssRegVal70 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE70", Insr2200BM.ATTR_SOCNSRISSREGVAL70, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE71 : socnsrIssRegVal71 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE71", Insr2200BM.ATTR_SOCNSRISSREGVAL71, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE72 : socnsrIssRegVal72 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE72", Insr2200BM.ATTR_SOCNSRISSREGVAL72, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE73 : socnsrIssRegVal73 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE73", Insr2200BM.ATTR_SOCNSRISSREGVAL73, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE74 : socnsrIssRegVal74 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE74", Insr2200BM.ATTR_SOCNSRISSREGVAL74, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE75 : socnsrIssRegVal75 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE75", Insr2200BM.ATTR_SOCNSRISSREGVAL75, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE76 : socnsrIssRegVal76 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE76", Insr2200BM.ATTR_SOCNSRISSREGVAL76, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE77 : socnsrIssRegVal77 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE77", Insr2200BM.ATTR_SOCNSRISSREGVAL77, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE78 : socnsrIssRegVal78 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE78", Insr2200BM.ATTR_SOCNSRISSREGVAL78, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE79 : socnsrIssRegVal79 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE79", Insr2200BM.ATTR_SOCNSRISSREGVAL79, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE80 : socnsrIssRegVal80 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE80", Insr2200BM.ATTR_SOCNSRISSREGVAL80, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Insr2200BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Insr2200BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Insr2200BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Insr2200BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Insr2200BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Insr2200BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		return listColumnDefs;


		 
	    }  
    



public List<ColumnDef> getInsr2300ToInsr2400(){
	
	
	  List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 	

	  
	  /** column 사회보험상실일자 : soctyInsurLssDt */
	  listColumnDefs.add(new ColumnDef("상실일자", Insr2200BM.ATTR_SOCTYINSURLSSDT, ColumnDef.TYPE_STRING , 90, true, false, true){
		  {

		  }
	  });
	  
	  //고용보험상실일자
	  /** column 사회보험상실신고_ITEM_VALUE18 : socnsrIssRegVal18 */
		listColumnDefs.add(new ColumnDef("상실일자", Insr2200BM.ATTR_SOCNSRISSREGVAL18, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
	  
	  
		/** column 사회보험작성일자 : soctyInsurCmptnDt */
		listColumnDefs.add(new ColumnDef("작성일자", Insr2200BM.ATTR_SOCTYINSURCMPTNDT, ColumnDef.TYPE_STRING , 60, true, false, true){
			{
		
			}
		});
	  
	  /** column 한글성명 : hanNm */
	  listColumnDefs.add(new ColumnDef("성명", Insr2200BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, false){
		  {
			  setReadOnly(true);
		  }
	  });

	  /** column 주민등록번호 : resnRegnNum */
	  listColumnDefs.add(new ColumnDef("주민등록번호", Insr2200BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, false){
		  {
			  setReadOnly(true);
		  }
	  });

	  /** column 주민등록번호 : resnRegnNum */
	  listColumnDefs.add(new ColumnDef("주민등록번호", Insr2200BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
		  {
			  setReadOnly(true);
		  }
	  });
		 /** column 고용구분코드 : emymtDivCd */
    listColumnDefs.add(new ColumnDef("고용구분", Insr2100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, false, false, false){
        {
            setReadOnly(true);
        }
    });

		
	   /** column 직종코드 : typOccuCd */
	   listColumnDefs.add(new ColumnDef("직종", Insr2100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, false, false){
	       {
	       	  setReadOnly(true);
	       }
	   });
    
	  /** column 피부양자여부 : insr1400Yn */
	  /*				listColumnDefs.add(new ColumnDef("피부양", Insr2100BM.ATTR_INSR1400YN, ColumnDef.TYPE_BOOLEAN , 50, true, true, true){
    					{
    						 setReadOnly(true);
    					}
    				});
	   */



	  /** column 사회보험가입자전화번호 : socInsrMbrPhnNum */
	  listColumnDefs.add(new ColumnDef("사회보험가입자전화번호", Insr2200BM.ATTR_SOCINSRMBRPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
		  {

		  }
	  });
	  /** column 국민연금신고여부 : natPennRegrstYn */
	  listColumnDefs.add(new ColumnDef("국민", Insr2200BM.ATTR_NATPENNREGRSTYN, ColumnDef.TYPE_BOOLEAN , 40, true, false, true){
		  {

		  }
	  });
	  /** column 건강보험신고여부 : hlthInsrRegrstYn */
	  listColumnDefs.add(new ColumnDef("건강", Insr2200BM.ATTR_HLTHINSRREGRSTYN, ColumnDef.TYPE_BOOLEAN , 40, true, false, true){
		  {

		  }
	  });
	  
	  /** column 이직신고여부 : hlthInsrRegrstYn */
	  listColumnDefs.add(new ColumnDef("이직", Insr2200BM.ATTR_LFLYYN, ColumnDef.TYPE_BOOLEAN , 40, true, true, true){
		  {

		  }
	  });

	  /** column 고용보험신고여부 : umytInsrRegrstYn */
	  listColumnDefs.add(new ColumnDef("고용", Insr2200BM.ATTR_UMYTINSRREGRSTYN, ColumnDef.TYPE_BOOLEAN , 40, true, true, true){
		  {

		  }
	  });
	  /** column 산재보험신고여부 : idtlAccdtRegrstYn */
	  listColumnDefs.add(new ColumnDef("산재", Insr2200BM.ATTR_IDTLACCDTREGRSTYN, ColumnDef.TYPE_BOOLEAN , 40, true, true, true){
		  {

		  }
	  });


	 


	  /** column 부서코드 : deptCd */
	  listColumnDefs.add(new ColumnDef("부서", Insr2200BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, false, true, false){
		  {
			  setReadOnly(true);
		  }
	  });
        

	  /** column 직종세구분 : dtilOccuClsDivCd */
	  listColumnDefs.add(new ColumnDef("직종세", Insr2200BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, true, false){
		  {
			  setReadOnly(true);
		  }
	  });


	  /** column 사업 : businCd */
	  listColumnDefs.add(new ColumnDef("사업", Insr2200BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, true, false){
		  {
			  setReadOnly(true);
		  }
	  });


	  
	  
		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Insr2200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr2200BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});

		/** column 사회보험상실_고용_일련번호 : socInsrLssEmymtNum */
		listColumnDefs.add(new ColumnDef("사회보험상실_고용_일련번호", Insr2200BM.ATTR_SOCINSRLSSEMYMTNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE01 : socnsrIssRegVal0 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE01", Insr2200BM.ATTR_SOCNSRISSREGVAL01, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE02 : socnsrIssRegVal02 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE02", Insr2200BM.ATTR_SOCNSRISSREGVAL02, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE03 : socnsrIssRegVal03 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE03", Insr2200BM.ATTR_SOCNSRISSREGVAL03, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE04 : socnsrIssRegVal04 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE04", Insr2200BM.ATTR_SOCNSRISSREGVAL04, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE05 : socnsrIssRegVal05 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE05", Insr2200BM.ATTR_SOCNSRISSREGVAL05, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE06 : socnsrIssRegVal06 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE06", Insr2200BM.ATTR_SOCNSRISSREGVAL06, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE07 : socnsrIssRegVal07 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE07", Insr2200BM.ATTR_SOCNSRISSREGVAL07, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE08 : socnsrIssRegVal08 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE08", Insr2200BM.ATTR_SOCNSRISSREGVAL08, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE09 : socnsrIssRegVal09 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE09", Insr2200BM.ATTR_SOCNSRISSREGVAL09, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE10 : socnsrIssRegVal10 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE10", Insr2200BM.ATTR_SOCNSRISSREGVAL10, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE11 : socnsrIssRegVal11 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE11", Insr2200BM.ATTR_SOCNSRISSREGVAL11, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE12 : socnsrIssRegVal12 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE12", Insr2200BM.ATTR_SOCNSRISSREGVAL12, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE13 : socnsrIssRegVal13 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE13", Insr2200BM.ATTR_SOCNSRISSREGVAL13, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE14 : socnsrIssRegVal14 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE14", Insr2200BM.ATTR_SOCNSRISSREGVAL14, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE15 : socnsrIssRegVal15 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE15", Insr2200BM.ATTR_SOCNSRISSREGVAL15, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE16 : socnsrIssRegVal16 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE16", Insr2200BM.ATTR_SOCNSRISSREGVAL16, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE17 : socnsrIssRegVal17 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE17", Insr2200BM.ATTR_SOCNSRISSREGVAL17, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE18 : socnsrIssRegVal18 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE18", Insr2200BM.ATTR_SOCNSRISSREGVAL18, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE19 : socnsrIssRegVal19 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE19", Insr2200BM.ATTR_SOCNSRISSREGVAL19, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE20 : socnsrIssRegVal20 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE20", Insr2200BM.ATTR_SOCNSRISSREGVAL20, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE21 : socnsrIssRegVal21 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE21", Insr2200BM.ATTR_SOCNSRISSREGVAL21, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE22 : socnsrIssRegVal22 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE22", Insr2200BM.ATTR_SOCNSRISSREGVAL22, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE23 : socnsrIssRegVal23 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE23", Insr2200BM.ATTR_SOCNSRISSREGVAL23, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE24 : socnsrIssRegVal24 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE24", Insr2200BM.ATTR_SOCNSRISSREGVAL24, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE25 : socnsrIssRegVal25 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE25", Insr2200BM.ATTR_SOCNSRISSREGVAL25, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE26 : socnsrIssRegVal26 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE26", Insr2200BM.ATTR_SOCNSRISSREGVAL26, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE27 : socnsrIssRegVal27 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE27", Insr2200BM.ATTR_SOCNSRISSREGVAL27, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE28 : socnsrIssRegVal28 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE28", Insr2200BM.ATTR_SOCNSRISSREGVAL28, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE29 : socnsrIssRegVal29 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE29", Insr2200BM.ATTR_SOCNSRISSREGVAL29, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE30 : socnsrIssRegVal30 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE30", Insr2200BM.ATTR_SOCNSRISSREGVAL30, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE31 : socnsrIssRegVal31 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE31", Insr2200BM.ATTR_SOCNSRISSREGVAL31, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE32 : socnsrIssRegVal32 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE32", Insr2200BM.ATTR_SOCNSRISSREGVAL32, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE33 : socnsrIssRegVal33 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE33", Insr2200BM.ATTR_SOCNSRISSREGVAL33, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE34 : socnsrIssRegVal34 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE34", Insr2200BM.ATTR_SOCNSRISSREGVAL34, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE35 : socnsrIssRegVal35 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE35", Insr2200BM.ATTR_SOCNSRISSREGVAL35, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE36 : socnsrIssRegVal36 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE36", Insr2200BM.ATTR_SOCNSRISSREGVAL36, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE37 : socnsrIssRegVal37 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE37", Insr2200BM.ATTR_SOCNSRISSREGVAL37, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE38 : socnsrIssRegVal38 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE38", Insr2200BM.ATTR_SOCNSRISSREGVAL38, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE39 : socnsrIssRegVal39 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE39", Insr2200BM.ATTR_SOCNSRISSREGVAL39, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE40 : socnsrIssRegVal40 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE40", Insr2200BM.ATTR_SOCNSRISSREGVAL40, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE41 : socnsrIssRegVal41 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE41", Insr2200BM.ATTR_SOCNSRISSREGVAL41, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE42 : socnsrIssRegVal42 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE42", Insr2200BM.ATTR_SOCNSRISSREGVAL42, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE43 : socnsrIssRegVal43 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE43", Insr2200BM.ATTR_SOCNSRISSREGVAL43, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE44 : socnsrIssRegVal44 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE44", Insr2200BM.ATTR_SOCNSRISSREGVAL44, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE45 : socnsrIssRegVal45 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE45", Insr2200BM.ATTR_SOCNSRISSREGVAL45, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE46 : socnsrIssRegVal46 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE46", Insr2200BM.ATTR_SOCNSRISSREGVAL46, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE47 : socnsrIssRegVal47 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE47", Insr2200BM.ATTR_SOCNSRISSREGVAL47, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE48 : socnsrIssRegVal48 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE48", Insr2200BM.ATTR_SOCNSRISSREGVAL48, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE49 : socnsrIssRegVal49 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE49", Insr2200BM.ATTR_SOCNSRISSREGVAL49, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE50 : socnsrIssRegVal50 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE50", Insr2200BM.ATTR_SOCNSRISSREGVAL50, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE51 : socnsrIssRegVal51 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE51", Insr2200BM.ATTR_SOCNSRISSREGVAL51, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE52 : socnsrIssRegVal52 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE52", Insr2200BM.ATTR_SOCNSRISSREGVAL52, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE53 : socnsrIssRegVal53 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE53", Insr2200BM.ATTR_SOCNSRISSREGVAL53, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE54 : socnsrIssRegVal54 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE54", Insr2200BM.ATTR_SOCNSRISSREGVAL54, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE55 : socnsrIssRegVal55 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE55", Insr2200BM.ATTR_SOCNSRISSREGVAL55, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE56 : socnsrIssRegVal56 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE56", Insr2200BM.ATTR_SOCNSRISSREGVAL56, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE57 : socnsrIssRegVal57 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE57", Insr2200BM.ATTR_SOCNSRISSREGVAL57, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE58 : socnsrIssRegVal58 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE58", Insr2200BM.ATTR_SOCNSRISSREGVAL58, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE59 : socnsrIssRegVal59 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE59", Insr2200BM.ATTR_SOCNSRISSREGVAL59, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE60 : socnsrIssRegVal60 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE60", Insr2200BM.ATTR_SOCNSRISSREGVAL60, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE61 : socnsrIssRegVal61 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE61", Insr2200BM.ATTR_SOCNSRISSREGVAL61, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE62 : socnsrIssRegVal62 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE62", Insr2200BM.ATTR_SOCNSRISSREGVAL62, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE63 : socnsrIssRegVal63 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE63", Insr2200BM.ATTR_SOCNSRISSREGVAL63, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE64 : socnsrIssRegVal64 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE64", Insr2200BM.ATTR_SOCNSRISSREGVAL64, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE65 : socnsrIssRegVal65 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE65", Insr2200BM.ATTR_SOCNSRISSREGVAL65, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE66 : socnsrIssRegVal66 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE66", Insr2200BM.ATTR_SOCNSRISSREGVAL66, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE67 : socnsrIssRegVal67 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE67", Insr2200BM.ATTR_SOCNSRISSREGVAL67, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE68 : socnsrIssRegVal68 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE68", Insr2200BM.ATTR_SOCNSRISSREGVAL68, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE69 : socnsrIssRegVal69 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE69", Insr2200BM.ATTR_SOCNSRISSREGVAL69, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE70 : socnsrIssRegVal70 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE70", Insr2200BM.ATTR_SOCNSRISSREGVAL70, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE71 : socnsrIssRegVal71 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE71", Insr2200BM.ATTR_SOCNSRISSREGVAL71, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE72 : socnsrIssRegVal72 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE72", Insr2200BM.ATTR_SOCNSRISSREGVAL72, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE73 : socnsrIssRegVal73 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE73", Insr2200BM.ATTR_SOCNSRISSREGVAL73, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE74 : socnsrIssRegVal74 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE74", Insr2200BM.ATTR_SOCNSRISSREGVAL74, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE75 : socnsrIssRegVal75 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE75", Insr2200BM.ATTR_SOCNSRISSREGVAL75, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE76 : socnsrIssRegVal76 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE76", Insr2200BM.ATTR_SOCNSRISSREGVAL76, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE77 : socnsrIssRegVal77 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE77", Insr2200BM.ATTR_SOCNSRISSREGVAL77, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE78 : socnsrIssRegVal78 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE78", Insr2200BM.ATTR_SOCNSRISSREGVAL78, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE79 : socnsrIssRegVal79 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE79", Insr2200BM.ATTR_SOCNSRISSREGVAL79, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험상실신고_ITEM_VALUE80 : socnsrIssRegVal80 */
		listColumnDefs.add(new ColumnDef("사회보험상실신고_ITEM_VALUE80", Insr2200BM.ATTR_SOCNSRISSREGVAL80, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Insr2200BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Insr2200BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Insr2200BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Insr2200BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Insr2200BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Insr2200BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		return listColumnDefs;


		 
	    }  
}
