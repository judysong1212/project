package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr5400BM;
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
public class Insr5400Def  extends TableDef implements InsrDaoConstants {

	  private int row = 0;
	  private InsrConstants InsrLabel = InsrConstants.INSTANCE;
 
	  public Insr5400Def(String chkDef){
	        	
		  setTitle("");
	      setDaoClass("");
	      setCustomListMethod(CLASS_INSR5400TOINSR5300_DAO_LIST);
		  setEditFieldGrid(true);
	      setAutoFillGrid(false);
	      setShowFilterToolbar(false);
	      setCheckBoxOnGridRows(true); 
         
		  setColumnsDefinition(getInsr5400ToInsr0100());
	  } 	
	        
	  //public List<ColumnDef> getInsr4400ToInsr3150(){	          
	  public List<ColumnDef> getInsr5400ToInsr0100(){

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

	        /** column 사업장코드 : dpobCd */
	    	listColumnDefs.add(new ColumnDef("사업장코드", Insr5400BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 100, false, false, false){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});

	        /** column 고용시작일(귀속년도) : hlthInsrYr -> srhHlthInsrYr */
	    	listColumnDefs.add(new ColumnDef("귀속년도", Insr5400BM.ATTR_SRH_HLTH_INSR_YR, ColumnDef.TYPE_STRING , 70, false, false, false){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});

	    	/** column SYSTEMKEY : systemkey */
	    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr5400BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, false, false, false){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});
	    	/** column 고용일련번호 : emymtSeilNum */
	    	listColumnDefs.add(new ColumnDef("고용일련번호", Insr5400BM.ATTR_EMYMT_SEIL_NUM1, ColumnDef.TYPE_BIGDECIMAL , 90, false, false, false){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});

	    	/** column 부서명 : deptNm */
	    	listColumnDefs.add(new ColumnDef("부서", Insr5400BM.ATTR_DEPT_NM, ColumnDef.TYPE_STRING , 110, true, true, true){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});

	    	/** column 성명 : hlthNm */
	    	listColumnDefs.add(new ColumnDef("성명", Insr5400BM.ATTR_ACNT_HODR_NM, ColumnDef.TYPE_STRING , 50, true, true, true){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});

	    	/** column 주민등록번호 : resnRegnNum */
	    	listColumnDefs.add(new ColumnDef("주민등록번호", Insr5400BM.ATTR_RESN_REGN_NUM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});
	    	
	    	/** column 보험료부과구분 : prmmIposDivCd */
	    	listColumnDefs.add(new ColumnDef("보험료부과구분", Insr5400BM.ATTR_PRMM_IPOS_DIV_CD, ColumnDef.TYPE_STRING , 90, true, true, true){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});



	    	/** column 고용보험사업장코드 : umytDpobCd */
	    	listColumnDefs.add(new ColumnDef("고용보험사업장코드", Insr5400BM.ATTR_UMYT_DPOB_CD, ColumnDef.TYPE_STRING , 100, false, false, false){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});

	    	/** column 고용보험정산년도 : umytInsrClutYr */
	    	listColumnDefs.add(new ColumnDef("고용보험정산년도", Insr5400BM.ATTR_UMYT_INSR_CLUT_YR, ColumnDef.TYPE_STRING , 100, false, false, false){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});

	    	/** column 고용보험시스템키 : umytSystemkey */
	    	listColumnDefs.add(new ColumnDef("고용보험시스템키", Insr5400BM.ATTR_UMYT_SYSTEMKEY, ColumnDef.TYPE_STRING , 100, false, false, false){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});

	    	/** column 고용보험고용일련번호 : emymtSeilNum2 */
	    	listColumnDefs.add(new ColumnDef("고용보험고용일련번호", Insr5400BM.ATTR_EMYMT_SEIL_NUM2, ColumnDef.TYPE_STRING , 100, false, false, false){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});

	    	/** column 고용취득일 : umytInsrAqtnDt */
	        listColumnDefs.add(new ColumnDef("(고용)취득일", Insr5400BM.ATTR_UMYT_INSR_AQTN_DT, ColumnDef.TYPE_STRING , 90, true, true, true){
	            {

	            }
	        });
	    	
	    	/** column 고용상실일 : umytInsrLssDt */
	        listColumnDefs.add(new ColumnDef("(고용)상실일", Insr5400BM.ATTR_UMYT_INSR_LSS_DT, ColumnDef.TYPE_STRING , 90, true, true, true){
	            {

	            }
	        });
	    	
	        /** column 고용보수총액 : umytInsrPayTotAmnt */
	        listColumnDefs.add(new ColumnDef("(고용)보수총액", Insr5400BM.ATTR_UMYT_INSR_PAY_TOT_AMNT, ColumnDef.TYPE_STRING , 90, true, true, true){
	            {

	            }
	        });

	    	/** column 산재보험사업장코드 : idtlDpobCd */
	    	listColumnDefs.add(new ColumnDef("산재보험사업장코드", Insr5400BM.ATTR_IDTL_DPOB_CD, ColumnDef.TYPE_STRING , 100, false, false, false){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});

	    	/** column 산재보험정산년도 : idtlAccdtInsurClutYr */
	    	listColumnDefs.add(new ColumnDef("산재보험정산년도", Insr5400BM.ATTR_IDTL_ACCDT_INSUR_CLUT_YR, ColumnDef.TYPE_STRING , 100, false, false, false){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});

	    	/** column 산재보험시스템키 : idtlSystemkey */
	    	listColumnDefs.add(new ColumnDef("산재보험시스템키", Insr5400BM.ATTR_IDTL_SYSTEMKEY, ColumnDef.TYPE_STRING , 100, false, false, false){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});

	    	/** column 산재보험고용일련번호1 : emymtSeilNum */
	    	listColumnDefs.add(new ColumnDef("산재보험고용일련번호1", Insr5400BM.ATTR_EMYMT_SEIL_NUM1, ColumnDef.TYPE_STRING , 100, false, false, false){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});

	    	/** column 산재취득일 : idtlAccdtInsurAqtnDt */
	    	listColumnDefs.add(new ColumnDef("(산재)취득일", Insr5400BM.ATTR_IDTL_ACCDT_INSUR_AQTN_DT, ColumnDef.TYPE_STRING , 90, true, true, true){
	    		{

	    		}
	    	});	    	
	    	
	    	/** column 산재상실일 : idtlAccdtInsurLssDtc */
	    	listColumnDefs.add(new ColumnDef("(산재)상실일", Insr5400BM.ATTR_IDTL_ACCDT_INSUR_LSS_DT, ColumnDef.TYPE_STRING , 90, true, true, true){
	    		{

	    		}
	    	});	    	
	    	
	    	/** column 산재보수총액 : idtlAccdtPayTotAmnt */
	    	listColumnDefs.add(new ColumnDef("(산재)보수총액", Insr5400BM.ATTR_IDTL_ACCDT_PAY_TOT_AMNT, ColumnDef.TYPE_STRING , 90, true, true, true){
	    		{

	    		}
	    	});

 	
	    	
	    	/** column 직종코드 : typOccuCd */
	    	listColumnDefs.add(new ColumnDef("직종코드", Insr5400BM.ATTR_TYP_OCCU_CD, ColumnDef.TYPE_STRING , 90, false, false, false){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});

	        /** column 직종 : typOccuNm */
	        listColumnDefs.add(new ColumnDef("직종", Insr5400BM.ATTR_TYP_OCCU_NM, ColumnDef.TYPE_STRING , 110, true, true, true){
	            {
	            	 setReadOnly(true);
	            }
	        });

	    	/** column 직종세 : dtilOccuClsDivCd */
	    	listColumnDefs.add(new ColumnDef("직종세", Insr5400BM.ATTR_DTIL_OCCU_CLS_DIV_CD, ColumnDef.TYPE_STRING , 90, false, false, false){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});

	    	/** column 직종세 : dtilOccuClsDivCdNm */
	    	listColumnDefs.add(new ColumnDef("직종세", Insr5400BM.ATTR_DTIL_OCCU_CLS_DIV_CD_NM, ColumnDef.TYPE_STRING , 100, true, true, true){
	    		{
	            	 setReadOnly(true);
	    		}
	    	});
	    	
	    	



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
