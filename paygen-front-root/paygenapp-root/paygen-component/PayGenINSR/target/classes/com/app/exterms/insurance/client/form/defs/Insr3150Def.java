package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr3150BM;
import com.app.exterms.insurance.client.dto.Insr4100BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr3200VO.java
 * @Description : Insr3200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr3150Def  extends TableDef implements InsrDaoConstants {
	  private int row = 0;
	    private InsrConstants InsrLabel = InsrConstants.INSTANCE;
 
	        public Insr3150Def(String chkDef){
		    	
		    	  if ("INSR4400".equals(chkDef)) {
		    		  setTitle(""); 
		    	        setDaoClass("");
		    	        setCustomListMethod(CLASS_INSR4400TOINSR3150_DAO_LIST);
		    	        setAutoFillGrid(false);
		    	        setShowFilterToolbar(false);
		    	        setCheckBoxOnGridRows(true); 
		    	      //  setEditFieldGrid(true);
		    	       // setEditableGrid(true);
		               
		              setColumnsDefinition(getInsr4400ToInsr3150());
		              
		    	  } 
	        } 	
	        
 public List<ColumnDef> getInsr4400ToInsr3150(){	          

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


	        /** column 사업장코드 : dpobCd */
	    	listColumnDefs.add(new ColumnDef("사업장코드", Insr3150BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 건간보험정산귀속년도 : hlthInsrYr */
	    	listColumnDefs.add(new ColumnDef("귀속년도", Insr3150BM.ATTR_HLTHINSRYR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column SYSTEMKEY : systemkey */
	    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr3150BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고용일련번호 : emymtSeilNum */
	    	listColumnDefs.add(new ColumnDef("고용번호", Insr3150BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 차수 : dspty */
	    	listColumnDefs.add(new ColumnDef("차수", Insr3150BM.ATTR_DSPTY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 사업장관리번호 : dpobMangeNum */
	    	listColumnDefs.add(new ColumnDef("사업장관리번호", Insr3150BM.ATTR_DPOBMANGENUM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 회계 : acc */
	    	listColumnDefs.add(new ColumnDef("회계", Insr3150BM.ATTR_ACC, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 단위사업장코드 : untDpobCd */
	    	listColumnDefs.add(new ColumnDef("단위사업장", Insr3150BM.ATTR_UNTDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
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
	        
	     
	        
	        /** column 고용구분코드 : emymtDivCd */
	        listColumnDefs.add(new ColumnDef("고용구분", Insr4100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, false, false, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 부서코드 : deptCd */
	        listColumnDefs.add(new ColumnDef("부서", Insr4100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        
	    	/** column 성명 : hlthNm */
	    	listColumnDefs.add(new ColumnDef("성명", Insr3150BM.ATTR_HLTHNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 주민등록번호 : resnRegnNum */
	    	listColumnDefs.add(new ColumnDef("주민등록번호", Insr3150BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 주민등록번호 : secRegnNum */
	    	listColumnDefs.add(new ColumnDef("주민등록번호", Insr3150BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING , 0, false, false, false){
	    		{

	    		}
	    	});
	    	/** column 증번호 : certNumHuhd */
	    	listColumnDefs.add(new ColumnDef("증번호", Insr3150BM.ATTR_CERTNUMHUHD, ColumnDef.TYPE_STRING , 90, true, true, true){
	    		{

	    		}
	    	});
	    	
	    	/** column 건강보험취득일자 : hlthInsrAqtnDt */
	    	listColumnDefs.add(new ColumnDef("취득일자", Insr3150BM.ATTR_HLTHINSRAQTNDT, ColumnDef.TYPE_STRING , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 보험료부과월수_건강 : iposPrmmMnthHlth */
	    	listColumnDefs.add(new ColumnDef("건강", Insr3150BM.ATTR_IPOSPRMMMNTHHLTH, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 보험료부과월수_장기 : iposPrmmMnthRcptn */
	    	listColumnDefs.add(new ColumnDef("장기요양", Insr3150BM.ATTR_IPOSPRMMMNTHRCPTN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 부과한총보험료_계 : iposTotPrmmAggr */
	    	listColumnDefs.add(new ColumnDef("계", Insr3150BM.ATTR_IPOSTOTPRMMAGGR, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 부과한총보험료_건강 : iposTotPrmmHlth */
	    	listColumnDefs.add(new ColumnDef("건강", Insr3150BM.ATTR_IPOSTOTPRMMHLTH, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 부과한총보험료_장기요양 : iposTotPrmmLgtmRcptn */
	    	listColumnDefs.add(new ColumnDef("장기요양", Insr3150BM.ATTR_IPOSTOTPRMMLGTMRCPTN, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 연간보수총액 : yrlyPayTotAmnt */
	    	listColumnDefs.add(new ColumnDef("연간보수총액", Insr3150BM.ATTR_YRLYPAYTOTAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 근무월수 : dutyMnthIcm */
	    	listColumnDefs.add(new ColumnDef("근무월수", Insr3150BM.ATTR_DUTYMNTHICM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 고지유예 : nofctSspn */
	    	listColumnDefs.add(new ColumnDef("고지유예", Insr3150BM.ATTR_NOFCTSSPN, ColumnDef.TYPE_STRING , 90, true, true, true){
	    		{

	    		}
	    	});
//	    	/** column 입력자 : kybdr */
//	    	listColumnDefs.add(new ColumnDef("입력자", Insr3150BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    		{
//
//	    		}
//	    	});
//	    	/** column 입력일자 : inptDt */
//	    	listColumnDefs.add(new ColumnDef("입력일자", Insr3150BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    		{
//
//	    		}
//	    	});
//	    	/** column 입력주소 : inptAddr */
//	    	listColumnDefs.add(new ColumnDef("입력주소", Insr3150BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    		{
//
//	    		}
//	    	});
//	    	/** column 수정자 : ismt */
//	    	listColumnDefs.add(new ColumnDef("수정자", Insr3150BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    		{
//
//	    		}
//	    	});
//	    	/** column 수정일자 : revnDt */
//	    	listColumnDefs.add(new ColumnDef("수정일자", Insr3150BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    		{
//
//	    		}
//	    	});
//	    	/** column 수정주소 : revnAddr */
//	    	listColumnDefs.add(new ColumnDef("수정주소", Insr3150BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    		{
//
//	    		}
//	    	});
//
//	    	private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//	    	private TextField<String> hlthInsrYr;   /** column 건간보험정산귀속년도 : hlthInsrYr */
//
//	    	private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
// 
//
//	    	private TextField<String> dspty;   /** column 차수 : dspty */
//
//	    	private TextField<String> dpobMangeNum;   /** column 사업장관리번호 : dpobMangeNum */
//
//	    	private TextField<String> acc;   /** column 회계 : acc */
//
//	    	private TextField<String> untDpobCd;   /** column 단위사업장코드 : untDpobCd */
//
//	    	private TextField<String> certNumHuhd;   /** column 증번호 : certNumHuhd */
//
//	    	private TextField<String> hlthNm;   /** column 성명 : hlthNm */
//
//	    	private TextField<String> resnRegnNum;   /** column 주민등록번호 : resnRegnNum */
//
//	    	private TextField<String> hlthInsrAqtnDt;   /** column 건강보험취득일자 : hlthInsrAqtnDt */
//
//	    	private TextField<String> iposPrmmMnthHlth;   /** column 보험료부과월수_건강 : iposPrmmMnthHlth */
//
//	    	private TextField<String> iposPrmmMnthRcptn;   /** column 보험료부과월수_장기 : iposPrmmMnthRcptn */
//
//	    	private TextField<String> iposTotPrmmAggr;   /** column 부과한총보험료_계 : iposTotPrmmAggr */
//
//	    	private TextField<String> iposTotPrmmHlth;   /** column 부과한총보험료_건강 : iposTotPrmmHlth */
//
//	    	private TextField<String> iposTotPrmmLgtmRcptn;   /** column 부과한총보험료_장기요양 : iposTotPrmmLgtmRcptn */
//
//	    	private TextField<String> yrlyPayTotAmnt;   /** column 연간보수총액 : yrlyPayTotAmnt */
//
//	    	private TextField<String> dutyMnthIcm;   /** column 근무월수 : dutyMnthIcm */
//
//	    	private TextField<String> nofctSspn;   /** column 고지유예 : nofctSspn */
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
