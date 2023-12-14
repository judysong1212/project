package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr4100BM;
import com.app.exterms.insurance.client.dto.Insr4300BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr4100VO.java
 * @Description : Insr4100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr4300Def  extends TableDef implements InsrDaoConstants {
	    private int row = 0;
	    private InsrConstants InsrLabel = InsrConstants.INSTANCE;

	    
	  //  private SummaryColumnConfig<Double> natPennStdIncmMnthAmnt = new SummaryColumnConfig<Double>(Insr4100BM.ATTR_NATPENNSTDINCMMNTHAMNT, "기준소득월액", 90);  
	  //  private SummaryColumnConfig<Double> natPennMnthAmnt = new SummaryColumnConfig<Double>(Insr4100BM.ATTR_NATPENNMNTHAMNT, "보험료[기준소득월액]", 100);  
	     
	    public Insr4300Def(String chkDef){
	    	  if ("INSR3200".equals(chkDef)) {
	    	        setDaoClass("");
	    	        setCustomListMethod(CLASS_INSR3200TOINSR4300_DAO_LIST);
	    	        setAutoFillGrid(false);
	    	        setShowFilterToolbar(false);
	    	        setCheckBoxOnGridRows(true); 
	    	       // setEditFieldGrid(true);
	    	       // setEditableGrid(true);
	               
	              setColumnsDefinition(getInsr3200ToInsr4300());
	          
	              
	          }  
	    }	
	    
	 
	    /**
         * 
         * @return
         */
	    public List<ColumnDef> getInsr3200ToInsr4300(){	  

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


	        
	        /** column 사업장코드 : dpobCd */
	    	listColumnDefs.add(new ColumnDef("사업장코드", Insr4300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column SYSTEMKEY : systemkey */
	    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr4300BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고용일련번호 : emymtSeilNum */
	    	listColumnDefs.add(new ColumnDef("고용일련번호", Insr4300BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 연금결정년도 : antyDeinYr */
	    	listColumnDefs.add(new ColumnDef("결정년도", Insr4300BM.ATTR_ANTYDEINYR, ColumnDef.TYPE_STRING , 60, true, true, true){
	    		{

	    		}
	    	});
	    	
	   	 
	        /** column 고용구분코드 : emymtDivCd */
	        listColumnDefs.add(new ColumnDef("고용구분", Insr4100BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	 setReadOnly(true);
	            }
	        });
	        /** column 부서코드 : deptCd */
	        listColumnDefs.add(new ColumnDef("부서", Insr4100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	 setReadOnly(true);
	            }
	        });
	        
	     
	        
	        /** column 고용구분코드 : emymtDivNm */
	        listColumnDefs.add(new ColumnDef("고용구분", Insr4100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 부서코드 : deptNm */
	        listColumnDefs.add(new ColumnDef("부서", Insr4100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        
	    	/** column 한글성명 : hanNm */
	    	listColumnDefs.add(new ColumnDef("한글성명", Insr4300BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 70, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 주민등록번호 : resnRegnNum */
	    	listColumnDefs.add(new ColumnDef("주민등록번호", Insr4300BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 주민등록번호 : secRegnNum */
	    	listColumnDefs.add(new ColumnDef("주민등록번호", Insr4300BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING , 90, false, false, false){
	    		{

	    		}
	    	});
	    	/** column 연금총근무일수 : antyTotDutyNumDys */
	    	listColumnDefs.add(new ColumnDef("총근무일수", Insr4300BM.ATTR_ANTYTOTDUTYNUMDYS, ColumnDef.TYPE_LONG , 80, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 연금소득총액 : antyIncmTotAmnt */
	    	listColumnDefs.add(new ColumnDef("소득총액", Insr4300BM.ATTR_ANTYINCMTOTAMNT, ColumnDef.TYPE_LONG , 80, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 연금기준소득월액 : antyStdIncmMnthAmnt */
	    	listColumnDefs.add(new ColumnDef("기준소득월액", Insr4300BM.ATTR_ANTYSTDINCMMNTHAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 연금월보험료 : antyMnthPrmm */
	    	listColumnDefs.add(new ColumnDef("월보험료", Insr4300BM.ATTR_ANTYMNTHPRMM, ColumnDef.TYPE_LONG , 80, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 종전기준소득월액 : bfrStdIncmMnthAmnt */
	    	listColumnDefs.add(new ColumnDef("종전기준소득월액", Insr4300BM.ATTR_BFRSTDINCMMNTHAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 과세자료결정여부 : txtnDataDeinYn */
	    	listColumnDefs.add(new ColumnDef("과세자료결정여부", Insr4300BM.ATTR_TXTNDATADEINYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 공단직권결정여부 : pbcorpOautyDeinYn */
	    	listColumnDefs.add(new ColumnDef("공단직권결정여부", Insr4300BM.ATTR_PBCORPOAUTYDEINYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 연금급여반영여부 : antyPayRflctnYn */
	    	listColumnDefs.add(new ColumnDef("연금급여반영여부", Insr4300BM.ATTR_ANTYPAYRFLCTNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	}); 
	    	

	        /** column 직종코드 : typOccuCd */
	        listColumnDefs.add(new ColumnDef("직종", Insr4100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	  setReadOnly(true);
	            }
	        });
	        /** column 호봉등급코드 : pyspGrdeCd */
	        listColumnDefs.add(new ColumnDef("호봉등급", Insr4100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	  setReadOnly(true);
	            }
	        });
	        /** column 직종세구분코드 : dtilOccuClsDivCd */
	        listColumnDefs.add(new ColumnDef("직종세", Insr4100BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	  setReadOnly(true);
	            }
	        });
	        /** column 직종세통합코드 : dtilOccuInttnCd */
	        listColumnDefs.add(new ColumnDef("직종세통합코드", Insr4100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });                                           
	             
	        /** column 직종 : typOccuNm */
	        listColumnDefs.add(new ColumnDef("직종", Insr4100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 호봉등급 : pyspGrdeNm */
	        listColumnDefs.add(new ColumnDef("호봉등급", Insr4100BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 직종세구분 : dtilOccuClsDivNm */
	        listColumnDefs.add(new ColumnDef("직종세", Insr4100BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });

	    	   
	        /** column 사업코드 : businCd */
	        listColumnDefs.add(new ColumnDef("사업", Insr4100BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	 setReadOnly(true);
	            }
	        });
	        
	        /** column 사업 : businNm */
	        listColumnDefs.add(new ColumnDef("사업", Insr4100BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        
//	    	private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//	    	private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//	    	private TextField<String> natPennSeilNum;   /** column 국민연금일련번호 : natPennSeilNum */
//
//	    	private TextField<String> antyDeinYr;   /** column 연금결정년도 : antyDeinYr */
//
//	    	private TextField<String> hanNm;   /** column 한글성명 : hanNm */
//
//	    	private TextField<String> resnRegnNum;   /** column 주민등록번호 : resnRegnNum */
//
//	    	private TextField<String> antyTotDutyNumDys;   /** column 연금총근무일수 : antyTotDutyNumDys */
//
//	    	private TextField<String> antyIncmTotAmnt;   /** column 연금소득총액 : antyIncmTotAmnt */
//
//	    	private TextField<String> antyStdIncmMnthAmnt;   /** column 연금기준소득월액 : antyStdIncmMnthAmnt */
//
//	    	private TextField<String> antyMnthPrmm;   /** column 연금월보험료 : antyMnthPrmm */
//
//	    	private TextField<String> bfrStdIncmMnthAmnt;   /** column 종전기준소득월액 : bfrStdIncmMnthAmnt */
//
//	    	private TextField<String> txtnDataDeinYn;   /** column 과세자료결정여부 : txtnDataDeinYn */
//
//	    	private TextField<String> pbcorpOautyDeinYn;   /** column 공단직권결정여부 : pbcorpOautyDeinYn */
//
//	    	private TextField<String> antyPayRflctnYn;   /** column 연금급여반영여부 : antyPayRflctnYn */
//
//	    	private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//	    	private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//	    	private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//	    	private TextField<String> ismt;   /** column 수정자 : ismt */
//
//	    	private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//	    	private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
	        
	    	 
	    	 return listColumnDefs;
	    } 
    
}
