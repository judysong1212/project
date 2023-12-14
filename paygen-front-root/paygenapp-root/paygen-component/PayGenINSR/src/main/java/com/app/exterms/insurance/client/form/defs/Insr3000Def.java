package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr3000BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr3000VO.java
 * @Description : Insr3000 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr3000Def  extends TableDef implements InsrDaoConstants {
	    private int row = 0;
	    private InsrConstants InsrLabel = InsrConstants.INSTANCE;

	    
	    final PrgmComBass0300DTO sysComBass0300Dto;
	    
	    public Insr3000Def(String chkDef){
	    	
	    	 sysComBass0300Dto = new PrgmComBass0300DTO(); 
	    	 
	    	 if ("INSR4100".equals(chkDef)) {
	    		    setTitle("");
	    	        setDaoClass("");
	    	        setCustomListMethod(CLASS_INSR4100TOINSR3000_DAO_LIST);
	    	        setAutoFillGrid(false);
	    	        setShowFilterToolbar(false);
	    	        setCheckBoxOnGridRows(true); 
	    	        setEditFieldGrid(true); 
	    	        setFilterFormType(FILTER_FORM_SINGLE);
	              setColumnsDefinition(getInsr4100ToInsr3000());
	              
	          } else if ("".equals(chkDef)) {
	        	  setTitle("");
	              setDaoClass("");
	              setCustomListMethod("");
	              setAutoFillGrid(false);
	              setShowFilterToolbar(false);
	              setCheckBoxOnGridRows(true); 
	            //  setEditFieldGrid(true); 
	              setColumnsDefinition(getInsr3000());
	              
	          } else if ("INSRP410002".equals(chkDef)) {
	    		    setTitle("");
	    	        setDaoClass("");
	    	        setCustomListMethod(CLASS_INSRP410002TOINSR3000_DAO_LIST);
	    	        setAutoFillGrid(false);
	    	        setShowFilterToolbar(false);
	    	        setCheckBoxOnGridRows(true);    
	                setColumnsDefinition(getInsrP410002ToInsr3000());
	          } else if ("INSRP410003".equals(chkDef)) {
	    		    setTitle("");
	    	        setDaoClass("");
	    	        setCustomListMethod(CLASS_INSRP410003TOINSR3000_DAO_LIST);
	    	        setAutoFillGrid(false);
	    	        setShowFilterToolbar(false);
	    	        setCheckBoxOnGridRows(true);   
	              setColumnsDefinition(getInsrP410003ToInsr3000());
	              
	              
	          } 
	    }	
	    
	    public List<ColumnDef> getInsr3000(){	 
		     
	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

	        /** column 사업장코드 : dpobCd */
	    	listColumnDefs.add(new ColumnDef("사업장코드", Insr3000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column SYSTEMKEY : systemkey */
	    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr3000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	 
	    	/** column 고용일련번호 : emymtSeilNum */
	    	listColumnDefs.add(new ColumnDef("고용일련번호", Insr3000BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	 sysComBass0300Dto.setRpsttvCd("B015"); 
	    	/** column 사대보험공제방식코드 : socInsrDducEthdCd */
	    	listColumnDefs.add(new ColumnDef("사대보험공제방식코드", Insr3000BM.ATTR_SOCINSRDDUCETHDCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 건강보험취득일자 : hlthInsrAqtnDt */
	    	listColumnDefs.add(new ColumnDef("건강보험취득일자", Insr3000BM.ATTR_HLTHINSRAQTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 건강보험상실일자 : hlthInsrLssDt */
	    	listColumnDefs.add(new ColumnDef("건강보험상실일자", Insr3000BM.ATTR_HLTHINSRLSSDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
//	    	/** column 입력자 : kybdr */
//	    	listColumnDefs.add(new ColumnDef("입력자", Insr3000BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    		{
//
//	    		}
//	    	});
//	    	/** column 입력일자 : inptDt */
//	    	listColumnDefs.add(new ColumnDef("입력일자", Insr3000BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    		{
//
//	    		}
//	    	});
//	    	/** column 입력주소 : inptAddr */
//	    	listColumnDefs.add(new ColumnDef("입력주소", Insr3000BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    		{
//
//	    		}
//	    	});
//	    	/** column 수정자 : ismt */
//	    	listColumnDefs.add(new ColumnDef("수정자", Insr3000BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    		{
//
//	    		}
//	    	});
//	    	/** column 수정일자 : revnDt */
//	    	listColumnDefs.add(new ColumnDef("수정일자", Insr3000BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    		{
//
//	    		}
//	    	});
//	    	/** column 수정주소 : revnAddr */
//	    	listColumnDefs.add(new ColumnDef("수정주소", Insr3000BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    		{
//
//	    		}
//	    	});

//	    	private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//	    	private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//	    	private TextField<String> hlthInsrSeilNum;   /** column 건강보험일련번호 : hlthInsrSeilNum */
//
//	    	private TextField<String> emymtSeilNum;   /** column 고용일련번호 : emymtSeilNum */
//
//	    	private TextField<String> socInsrDducEthdCd;   /** column 사대보험공제방식코드 : socInsrDducEthdCd */
//
//	    	private TextField<String> hlthInsrAqtnDt;   /** column 건강보험취득일자 : hlthInsrAqtnDt */
//
//	    	private TextField<String> hlthInsrLssDt;   /** column 건강보험상실일자 : hlthInsrLssDt */
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
	    public List<ColumnDef> getInsr4100ToInsr3000(){	 
	     
	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 



	    	/** column 사업장코드 : dpobCd */
	    	listColumnDefs.add(new ColumnDef("사업장코드", Insr3000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});
	    	
	    	   
	        /** column 사업코드 : businCd */
	        listColumnDefs.add(new ColumnDef("사업", Insr3000BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	 setReadOnly(true);
	            }
	        });
	        
	    	
	    	 
	        /** column 고용구분코드 : emymtDivCd */
	        listColumnDefs.add(new ColumnDef("고용구분", Insr3000BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	 setReadOnly(true);
	            }
	        });
	        /** column 부서코드 : deptCd */
	        listColumnDefs.add(new ColumnDef("부서", Insr3000BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	 setReadOnly(true);
	            }
	        });
	        
	     
	        
	        /** column 고용구분코드 : emymtDivCd */
	        listColumnDefs.add(new ColumnDef("고용구분", Insr3000BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 부서코드 : deptCd */
	        listColumnDefs.add(new ColumnDef("부서", Insr3000BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        


	    	/** column SYSTEMKEY : systemkey */
	    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr3000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, false, false, false){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});
	    	
	        /** column 한글성명 : hanNm */
	        listColumnDefs.add(new ColumnDef("성명", Insr3000BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 70, true, true, false){
	          {
	              setReadOnly(true);
	          }
	        });
	        /** column 주민등록번호 : resnRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Insr3000BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, false){
	          {
	              setReadOnly(true);
	          }
	        }); 

	        /** column 주민등록번호 : secRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Insr3000BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
	          {
	              setReadOnly(true);
	          }
	        }); 
	    	/** column 고용일련번호 : emymtSeilNum */
	    	listColumnDefs.add(new ColumnDef("고용일련번호", Insr3000BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});
	    	 sysComBass0300Dto.setRpsttvCd("I023");  
	    	/** column 사대보험공제방식코드 : socInsrDducEthdCd */
	    	 listColumnDefs.add(new ColumnListDef("공제방식", Insr3000BM.ATTR_SOCINSRDDUCETHDCD, ColumnDef.TYPE_STRING , 90,  false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
		    	{ 

	    		}
	    	});
	    	
	    	/** column 사대보험공제방식 : socInsrDducEthdNm */
	    	listColumnDefs.add(new ColumnDef("공제방식", Insr3000BM.ATTR_SOCINSRDDUCETHDNM, ColumnDef.TYPE_STRING , 80, true, false, true){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});
	    	
	    	/** column 건강보험변동일자 : hlthInsurFlucDt */
	    	listColumnDefs.add(new ColumnDef("건강보험변동일자", Insr3000BM.ATTR_HLTHINSURFLUCDT, ColumnDef.TYPE_DATE , 90, true, false, true){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});
	    	/** column 건강보험보수총액 : hlthInsrPayTotAmnt */
	    	listColumnDefs.add(new ColumnDef("건강보험보수총액", Insr3000BM.ATTR_HLTHINSRPAYTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});
	    	/** column 건강보험등급 : hlthInsrGrde */
	    	listColumnDefs.add(new ColumnDef("건강보험등급", Insr3000BM.ATTR_HLTHINSRGRDE, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});
	    	/** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
	    	listColumnDefs.add(new ColumnDef("보수월액", Insr3000BM.ATTR_HLTHINSRMNTHRUNTNAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
	    		{

	    		}
	    	});
	    	
	    	/** column 건강보험료 : hlthInsrMnthAmnt */
	    	listColumnDefs.add(new ColumnDef("보험료", Insr3000BM.ATTR_HLTHINSRMNTHAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
	    		{
	    			 setReadOnly(true);
	    		}
	    	}); 
	    	
	    	  /** column 예외처리지급금액 건강보험 : exptnPrcsPymtSum01 */
	        listColumnDefs.add(new ColumnDef("감면금액", Insr3000BM.ATTR_EXPTNPRCSPYMTSUM01, ColumnDef.TYPE_LONG, 80, false, false, true){
	        	{
	        		 setReadOnly(true);
	        	}
	        });
	        /** column 예외처리지급비율 건강보험: exptnPrcsPymtRto01 */
	        listColumnDefs.add(new ColumnDef("감면율", Insr3000BM.ATTR_EXPTNPRCSPYMTRTO01, ColumnDef.TYPE_DOUBLE, 80, false, true, true){
	        	{
	        		 setReadOnly(true);
	        	}
	        }); 
	        
	        sysComBass0300Dto.setRpsttvCd("I007"); 
	        /** column 예외구분코드 : exptnDivCd */
	        listColumnDefs.add(new ColumnListDef("면제사유", Insr3000BM.ATTR_EXPTNDIVCD01, ColumnDef.TYPE_STRING, 110, false, false, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
	        	{
	        		 setReadOnly(true);
	        	}
	        });
	        /** column 예외구분 : exptnDivNm */
	        listColumnDefs.add(new ColumnDef("면제사유", Insr3000BM.ATTR_EXPTNDIVNM01, ColumnDef.TYPE_STRING, 90, false, true, true){
	        	{
	        		 setReadOnly(true);
	        	}
	        });
	        
	        /** column 장기요양보험료 : hlthInsrMnthAmnt */
	    	listColumnDefs.add(new ColumnDef("보험료", Insr3000BM.ATTR_HLTHRCPTNMNTHAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});  
	    	
	    	  
	        /** column 예외처리지급금액 장기요양 : exptnPrcsPymtSum02 */
	        listColumnDefs.add(new ColumnDef("감면금액[장기요양]", Insr3000BM.ATTR_EXPTNPRCSPYMTSUM02, ColumnDef.TYPE_LONG, 80, false, false, true){
	        	{
	        		 setReadOnly(true);
	        	}
	        });
	        /** column 예외처리지급비율 장기요양: exptnPrcsPymtRto02 */
	        listColumnDefs.add(new ColumnDef("감면율", Insr3000BM.ATTR_EXPTNPRCSPYMTRTO02, ColumnDef.TYPE_DOUBLE, 80, false, true, true){
	        	{
	        		 setReadOnly(true);
	        	}
	        });
	        
	        sysComBass0300Dto.setRpsttvCd("I007"); //B013
	        /** column 예외구분코드 : exptnDivCd */
	        listColumnDefs.add(new ColumnListDef("면제사유", Insr3000BM.ATTR_EXPTNDIVCD02, ColumnDef.TYPE_STRING, 110, false, false, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
	        	{
	        		 setReadOnly(true);
	        		 
	        	}
	        });
	        /** column 예외구분 : exptnDivNm */
	        listColumnDefs.add(new ColumnDef("면제사유", Insr3000BM.ATTR_EXPTNDIVNM02, ColumnDef.TYPE_STRING, 90, false, true, true){
	        	{
	        		 setReadOnly(true);
	        	}
	        });
	        
	    	/** column 건강보험증번호 : hlthInsrCertNum */
	    	listColumnDefs.add(new ColumnDef("건강보험증번호", Insr3000BM.ATTR_HLTHINSRCERTNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    		{

	    		}
	    	});
	    	 
	    	/** column 건강보험적용여부 : hlthInsrApptnYn */
	    	listColumnDefs.add(new ColumnDef("건강보험적용여부", Insr3000BM.ATTR_HLTHINSRAPPTNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{
	    			 setReadOnly(true);
	    		}
	    	}); 
	        
	    	
	    	/** column 건강보험취득일자 : hlthInsrAqtnDt */
	    	listColumnDefs.add(new ColumnDef("취득일자", Insr3000BM.ATTR_HLTHINSRAQTNDT, ColumnDef.TYPE_DATE , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 건강보험상실일자 : hlthInsrLssDt */
	    	listColumnDefs.add(new ColumnDef("상실일자", Insr3000BM.ATTR_HLTHINSRLSSDT, ColumnDef.TYPE_DATE , 90, true, true, true){
	    		{
	    			 setReadOnly(true);
	    		}
	    	}); 

	        /** column 직종코드 : typOccuCd */
	        listColumnDefs.add(new ColumnDef("직종", Insr3000BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	  setReadOnly(true);
	            }
	        });
	        /** column 호봉등급코드 : pyspGrdeCd */
	        listColumnDefs.add(new ColumnDef("호봉등급", Insr3000BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	  setReadOnly(true);
	            }
	        });
	        /** column 직종세구분코드 : dtilOccuClsDivCd */
	        listColumnDefs.add(new ColumnDef("직종세", Insr3000BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	  setReadOnly(true);
	            }
	        });
            
            
/** column 직종세통합코드 : dtilOccuInttnCd */
listColumnDefs.add(new ColumnDef("직종세통합코드", Insr3000BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
{

}
});                                           

	        /** column 직종 : typOccuCd */
	        listColumnDefs.add(new ColumnDef("직종", Insr3000BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 호봉등급 : pyspGrdeCd */
	        listColumnDefs.add(new ColumnDef("호봉등급", Insr3000BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 직종세구분 : dtilOccuClsDivCd */
	        listColumnDefs.add(new ColumnDef("직종세", Insr3000BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        
	        /** column 사업 : businCd */
	        listColumnDefs.add(new ColumnDef("사업", Insr3000BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        
	          

//	    	private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//	    	private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//	    	private TextField<String> hlthInsrSeilNum;   /** column 건강보험일련번호 : hlthInsrSeilNum */
//
//	    	private TextField<String> emymtSeilNum;   /** column 고용일련번호 : emymtSeilNum */
//
//	    	private TextField<String> socInsrDducEthdCd;   /** column 사대보험공제방식코드 : socInsrDducEthdCd */
//
//	    	private TextField<String> hlthInsrAqtnDt;   /** column 건강보험취득일자 : hlthInsrAqtnDt */
//
//	    	private TextField<String> hlthInsrLssDt;   /** column 건강보험상실일자 : hlthInsrLssDt */
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
	    
	    /**
         * 
         * @return
         */
	    public List<ColumnDef> getInsrP410002ToInsr3000(){	  

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


	    	/** column 사업장코드 : dpobCd */
	    	listColumnDefs.add(new ColumnDef("사업장코드", Insr3000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});
	    	
	    	
	    	 
	        /** column 고용구분코드 : emymtDivCd */
	        listColumnDefs.add(new ColumnDef("고용구분", Insr3000BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	 setReadOnly(true);
	            }
	        });
	        /** column 부서코드 : deptCd */
	        listColumnDefs.add(new ColumnDef("부서", Insr3000BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	 setReadOnly(true);
	            }
	        });
	        
	        /** column 지급년월 : pymtYrMnth */
	        listColumnDefs.add(new ColumnDef("납부년월", Insr3000BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, true, false, true){
	        	{

	        	}
	        });
	        
	        /** column 고용구분 : emymtDivNm */
	        listColumnDefs.add(new ColumnDef("고용구분", Insr3000BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 부서코드 : deptCd */
	        listColumnDefs.add(new ColumnDef("부서", Insr3000BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        


	    	/** column SYSTEMKEY : systemkey */
	    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr3000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, false, false, false){
	    		{

	    		}
	    	});
	    	
	        /** column 한글성명 : hanNm */
	        listColumnDefs.add(new ColumnDef("성명", Insr3000BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 80, true, true, false){
	          {
	              setReadOnly(true);
	          }
	        });
	        /** column 주민등록번호 : resnRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Insr3000BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, false){
	          {
	              setReadOnly(true);
	          }
	        });
	        
	        /** column 주민등록번호 : secRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Insr3000BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
	          {
	              setReadOnly(true);
	          }
	        });
	         
	        /** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
	        listColumnDefs.add(new ColumnDef("보수월액", Insr3000BM.ATTR_HLTHINSRMNTHRUNTNAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	        	{

	        	}
	        });	
	    	  
 
			/** set 연금보험료 : PYMT_DDUC_D0150100 */
	    	listColumnDefs.add(new ColumnDef("납부보험료", Insr3000BM.ATTR_PYMTDDUCD0010100, ColumnDef.TYPE_LONG , 90, false, true, false){
	    		{

	    		}
	    	});
	    	
	    	/** set 정산보험료 : PYMT_DDUC_D0150200 */
	    	listColumnDefs.add(new ColumnDef("정산보험료", Insr3000BM.ATTR_PYMTDDUCD0010200, ColumnDef.TYPE_LONG , 90, false, true, false){
	    		{

	    		}
	    	});
	    	

	    	/** set 과미납보험료 : pymtDducD0150300 */
	    	listColumnDefs.add(new ColumnDef("과미납보험료", Insr3000BM.ATTR_PYMTDDUCD0010300, ColumnDef.TYPE_LONG , 90, false, true, false){
	    		{

	    		}
	    	});
	    	
	    	/** set 휴직자분할보험료 : pymtDducD0010400 */
	    	listColumnDefs.add(new ColumnDef("휴직자분할납부", Insr3000BM.ATTR_PYMTDDUCD0010400, ColumnDef.TYPE_LONG , 90, false, true, false){
	    		{

	    		}
	    	});
	    	
	    	/** set 건강보험환급금이자 : pymtDducD0010500 */
	    	listColumnDefs.add(new ColumnDef("환급금이자", Insr3000BM.ATTR_PYMTDDUCD0010500, ColumnDef.TYPE_LONG , 90, false, true, false){
	    		{

	    		}
	    	});
	    	
	    	
	    	
	    	  sysComBass0300Dto.setRpsttvCd("B013"); 
		        /** column 예외구분코드 : exptnDivCd */
		        listColumnDefs.add(new ColumnListDef("예외구분", Insr3000BM.ATTR_EXPTNDIVCD01, ColumnDef.TYPE_STRING, 110, false, false, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
		        	{

		        	}
		        });
		        /** column 예외구분 : exptnDivNm */
		        listColumnDefs.add(new ColumnDef("예외구분", Insr3000BM.ATTR_EXPTNDIVNM01, ColumnDef.TYPE_STRING, 90, false, true, true){
		        	{

		        	}
		        });
		        
		        /** column 예외처리지급금액 : exptnPrcsPymtSum */
		        listColumnDefs.add(new ColumnDef("예외금액", Insr3000BM.ATTR_EXPTNPRCSPYMTSUM01, ColumnDef.TYPE_LONG, 80, false, false, true){
		        	{

		        	}
		        });
		        /** column 예외처리지급비율 : exptnPrcsPymtRto */
		        listColumnDefs.add(new ColumnDef("예외비율", Insr3000BM.ATTR_EXPTNPRCSPYMTRTO01, ColumnDef.TYPE_DOUBLE, 80, false, true, true){
		        	{

		        	}
		        }); 

				/** set 연금보험료 : PYMT_DDUC_D0110100 */
		    	listColumnDefs.add(new ColumnDef("납부보험료", Insr3000BM.ATTR_PYMTDDUCD0110100, ColumnDef.TYPE_LONG , 90, false, true, false){
		    		{

		    		}
		    	});
		    	
		    	/** set 정산보험료 : PYMT_DDUC_D0110200 */
		    	listColumnDefs.add(new ColumnDef("정산보험료", Insr3000BM.ATTR_PYMTDDUCD0110200, ColumnDef.TYPE_LONG , 90, false, true, false){
		    		{

		    		}
		    	});
		    	

		    	/** set 과미납보험료 : pymtDducD0110300 */
		    	listColumnDefs.add(new ColumnDef("과미납보험료", Insr3000BM.ATTR_PYMTDDUCD0110300, ColumnDef.TYPE_LONG , 90, false, true, false){
		    		{

		    		}
		    	});
		    	
		    	/** set 휴직자분할보험료 : pymtDducD0110400 */
		    	listColumnDefs.add(new ColumnDef("휴직자분할납부", Insr3000BM.ATTR_PYMTDDUCD0110400, ColumnDef.TYPE_LONG , 90, false, true, false){
		    		{

		    		}
		    	});
		    	
		    	/** set 건강보험환급금이자 : pymtDducD0110500 */
		    	listColumnDefs.add(new ColumnDef("환급금이자", Insr3000BM.ATTR_PYMTDDUCD0110500, ColumnDef.TYPE_LONG , 90, false, true, false){
		    		{

		    		}
		    	});
		    	 
		        
		        sysComBass0300Dto.setRpsttvCd("B013"); 
		        /** column 예외구분코드 : exptnDivCd */
		        listColumnDefs.add(new ColumnListDef("예외구분", Insr3000BM.ATTR_EXPTNDIVCD02, ColumnDef.TYPE_STRING, 110, false, false, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
		        	{

		        	}
		        });
		        /** column 예외구분 : exptnDivNm */
		        listColumnDefs.add(new ColumnDef("예외구분", Insr3000BM.ATTR_EXPTNDIVNM02, ColumnDef.TYPE_STRING, 90, false, true, true){
		        	{

		        	}
		        });
		        
		        /** column 예외처리지급금액 : exptnPrcsPymtSum */
		        listColumnDefs.add(new ColumnDef("예외금액", Insr3000BM.ATTR_EXPTNPRCSPYMTSUM02, ColumnDef.TYPE_LONG, 80, false, false, true){
		        	{

		        	}
		        });
		        /** column 예외처리지급비율 : exptnPrcsPymtRto */
		        listColumnDefs.add(new ColumnDef("예외비율", Insr3000BM.ATTR_EXPTNPRCSPYMTRTO02, ColumnDef.TYPE_DOUBLE, 80, false, true, true){
		        	{

		        	}
		        });
	    	 
	    	/** set 합계 : pymtSducSum */
	    	listColumnDefs.add(new ColumnDef("합계", Insr3000BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG , 90, false, true, false){
	    		{

	    		}
	    	});
	        /** column 직종코드 : typOccuCd */
	        listColumnDefs.add(new ColumnDef("직종", Insr3000BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	  setReadOnly(true);
	            }
	        });
	        /** column 호봉등급코드 : pyspGrdeCd */
	        listColumnDefs.add(new ColumnDef("호봉등급", Insr3000BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	  setReadOnly(true);
	            }
	        });
	        /** column 직종세구분코드 : dtilOccuClsDivCd */
	        listColumnDefs.add(new ColumnDef("직종세", Insr3000BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	  setReadOnly(true);
	            }
	        });
	        
            
            
/** column 직종세통합코드 : dtilOccuInttnCd */
listColumnDefs.add(new ColumnDef("직종세통합코드", Insr3000BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
{

}
});                                           

	      
	        /** column 직종 : typOccuCd */
	        listColumnDefs.add(new ColumnDef("직종", Insr3000BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 호봉등급 : pyspGrdeCd */
	        listColumnDefs.add(new ColumnDef("호봉등급", Insr3000BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 직종세구분 : dtilOccuClsDivCd */
	        listColumnDefs.add(new ColumnDef("직종세", Insr3000BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        
	        
	        /** column 사업코드 : businCd */
	        listColumnDefs.add(new ColumnDef("사업", Insr3000BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	 setReadOnly(true);
	            }
	        }); 
	        
	        
	        /** column 사업 : businCd */
	        listColumnDefs.add(new ColumnDef("사업", Insr3000BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });

	    	 return listColumnDefs;
	    }  
	    
	    public List<ColumnDef> getInsrP410003ToInsr3000(){	  

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


	    	/** column 사업장코드 : dpobCd */
	    	listColumnDefs.add(new ColumnDef("사업장코드", Insr3000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});
	    	
	    	   
	        /** column 사업코드 : businCd */
	        listColumnDefs.add(new ColumnDef("사업", Insr3000BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	 setReadOnly(true);
	            }
	        }); 
	    	 
	        
	        /** column 지급년월 : pymtYrMnth */
	        listColumnDefs.add(new ColumnDef("납부년월", Insr3000BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 60, true, true, true){
	        	{

	        	}
	        });
	        
	    	/** column SYSTEMKEY : systemkey */
	    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr3000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, false, false, false){
	    		{

	    		}
	    	});
	    	
	    	 
	    	 
	        /** column 고용구분코드 : emymtDivCd */
	        listColumnDefs.add(new ColumnDef("고용구분", Insr3000BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	 setReadOnly(true);
	            }
	        });
	        /** column 부서코드 : deptCd */
	        listColumnDefs.add(new ColumnDef("부서", Insr3000BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	 setReadOnly(true);
	            }
	        });
	        
	        
	        /** column 고용구분 : emymtDivNm */
	        listColumnDefs.add(new ColumnDef("고용구분", Insr3000BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 70, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 부서코드 : deptCd */
	        listColumnDefs.add(new ColumnDef("부서", Insr3000BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        
 
	        /** column 한글성명 : hanNm */
	        listColumnDefs.add(new ColumnDef("성명", Insr3000BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 50, true, true, false){
	          {
	              setReadOnly(true);
	          }
	        });
	        /** column 주민등록번호 : resnRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Insr3000BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, false){
	          {
	              setReadOnly(true);
	          }
	        });
	        
	        /** column 주민등록번호 : secRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Insr3000BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
	          {
	              setReadOnly(true);
	          }
	        });
	         
	        /** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
	        listColumnDefs.add(new ColumnDef("보수월액", Insr3000BM.ATTR_HLTHINSRMNTHRUNTNAMNT, ColumnDef.TYPE_LONG , 80, true, true, true){
	        	{

	        	}
	        });	
	    	  
 
			/** set 연금보험료 : PYMT_DDUC_D0150100 */
	    	listColumnDefs.add(new ColumnDef("납부보험료", Insr3000BM.ATTR_PYMTDDUCD0010100, ColumnDef.TYPE_LONG , 80, false, true, false){
	    		{

	    		}
	    	});
	    	
	     
	    	
		    	  /** column 예외처리지급금액 : exptnPrcsPymtSum */
		        listColumnDefs.add(new ColumnDef("예외금액", Insr3000BM.ATTR_EXPTNPRCSPYMTSUM01, ColumnDef.TYPE_LONG, 80, false, false, true){
		        	{
	
		        	}
		        });
		        /** column 예외처리지급비율 : exptnPrcsPymtRto */
		        listColumnDefs.add(new ColumnDef("예외비율", Insr3000BM.ATTR_EXPTNPRCSPYMTRTO01, ColumnDef.TYPE_DOUBLE, 80, false, true, true){
		        	{
	
		        	}
		        }); 
	    	
	    	  sysComBass0300Dto.setRpsttvCd("B013"); 
		        /** column 예외구분코드 : exptnDivCd */
		        listColumnDefs.add(new ColumnListDef("예외구분", Insr3000BM.ATTR_EXPTNDIVCD01, ColumnDef.TYPE_STRING, 110, false, false, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
		        	{

		        	}
		        });
		        /** column 예외구분 : exptnDivNm */
		        listColumnDefs.add(new ColumnDef("예외구분", Insr3000BM.ATTR_EXPTNDIVNM01, ColumnDef.TYPE_STRING, 80, false, true, true){
		        	{

		        	}
		        }); 
		      

				/** set 연금보험료 : PYMT_DDUC_D0110100 */
		    	listColumnDefs.add(new ColumnDef("납부보험료", Insr3000BM.ATTR_PYMTDDUCD0110100, ColumnDef.TYPE_LONG , 80, false, true, false){
		    		{

		    		}
		    	});
		    	 
		    	 /** column 예외처리지급금액 : exptnPrcsPymtSum */
		        listColumnDefs.add(new ColumnDef("예외금액", Insr3000BM.ATTR_EXPTNPRCSPYMTSUM02, ColumnDef.TYPE_LONG, 80, false, false, true){
		        	{

		        	}
		        });
		        /** column 예외처리지급비율 : exptnPrcsPymtRto */
		        listColumnDefs.add(new ColumnDef("예외비율", Insr3000BM.ATTR_EXPTNPRCSPYMTRTO02, ColumnDef.TYPE_DOUBLE, 80, false, true, true){
		        	{

		        	}
		        });
	    	 
		        sysComBass0300Dto.setRpsttvCd("B013"); 
		        /** column 예외구분코드 : exptnDivCd */
		        listColumnDefs.add(new ColumnListDef("예외구분", Insr3000BM.ATTR_EXPTNDIVCD02, ColumnDef.TYPE_STRING, 110, false, false, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
		        	{

		        	}
		        });
		        /** column 예외구분 : exptnDivNm */
		        listColumnDefs.add(new ColumnDef("예외구분", Insr3000BM.ATTR_EXPTNDIVNM02, ColumnDef.TYPE_STRING, 80, false, true, true){
		        	{

		        	}
		        });
		        
		       
//		    	/** set 합계 : pymtSducSum */
//		    	listColumnDefs.add(new ColumnDef("합계", Insr3000BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG , 90, false, true, false){
//		    		{
//	
//		    		}
//		    	});
	        
		    	  /** column 직종코드 : typOccuCd */
		        listColumnDefs.add(new ColumnDef("직종", Insr3000BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, false, false, false){
		            {
		            	  setReadOnly(true);
		            }
		        });
		        /** column 호봉등급코드 : pyspGrdeCd */
		        listColumnDefs.add(new ColumnDef("호봉등급", Insr3000BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
		            {
		            	  setReadOnly(true);
		            }
		        });
		        /** column 직종세구분코드 : dtilOccuClsDivCd */
		        listColumnDefs.add(new ColumnDef("직종세", Insr3000BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
		            {
		            	  setReadOnly(true);
		            }
		        });
                
                
			/** column 직종세통합코드 : dtilOccuInttnCd */
			listColumnDefs.add(new ColumnDef("직종세통합코드", Insr3000BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
			
			}
			});                                           

		        /** column 직종 : typOccuCd */
		        listColumnDefs.add(new ColumnDef("직종", Insr3000BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, true, false){
		            {
		                setReadOnly(true);
		            }
		        });
		        
		        /** column 호봉등급 : pyspGrdeCd */
		        listColumnDefs.add(new ColumnDef("호봉등급", Insr3000BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, false, false, false){
		            {
		                setReadOnly(true);
		            }
		        });
		        /** column 직종세구분 : dtilOccuClsDivCd */
		        listColumnDefs.add(new ColumnDef("직종세", Insr3000BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, true, false){
		            {
		                setReadOnly(true);
		            }
		        });
		        
		        
		        /** column 사업코드 : businCd */
		        listColumnDefs.add(new ColumnDef("사업", Insr3000BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, false, false, false){
		            {
		            	 setReadOnly(true);
		            }
		        }); 
		        
		        
		        /** column 사업 : businCd */
		        listColumnDefs.add(new ColumnDef("사업", Insr3000BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, true, false){
		            {
		                setReadOnly(true);
		            }
		        });

	    	 return listColumnDefs;
	    }  
    
}
