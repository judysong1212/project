package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr4100BM;
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
public class Insr4100Def  extends TableDef implements InsrDaoConstants {
	    private int row = 0;
	    private InsrConstants InsrLabel = InsrConstants.INSTANCE;

	    
	  //  private SummaryColumnConfig<Double> natPennStdIncmMnthAmnt = new SummaryColumnConfig<Double>(Insr4100BM.ATTR_NATPENNSTDINCMMNTHAMNT, "기준소득월액", 90);  
	  //  private SummaryColumnConfig<Double> natPennMnthAmnt = new SummaryColumnConfig<Double>(Insr4100BM.ATTR_NATPENNMNTHAMNT, "보험료[기준소득월액]", 100);  
	     
	    public Insr4100Def(String chkDef){
	    	
	    	  if ("INSR3100".equals(chkDef)) {
	    	        setDaoClass("");
	    	        setCustomListMethod(CLASS_INSR3100TOINSR4100_DAO_LIST);
	    	        setAutoFillGrid(false);
	    	        setShowFilterToolbar(false);
	    	        setCheckBoxOnGridRows(true); 
	    	        setEditFieldGrid(true);
	    	        setCellModel(true);
	    	       // setEditableGrid(true);
	               
	              setColumnsDefinition(getInsr3100ToInsr4100());
	              
	    	  } else if ("INSRP310001".equals(chkDef)) {
	    	        setDaoClass("");
	    	        setCustomListMethod(CLASS_INSRP310001TOINSR4100_DAO_LIST);
	    	        setAutoFillGrid(false);
	    	        setShowFilterToolbar(false);
	    	        setCheckBoxOnGridRows(true); 
	    	       // setEditFieldGrid(true); 
	               
	              setColumnsDefinition(getInsrP310001ToInsr4100());
	         
	    	  }   else if ("".equals(chkDef)) {
	              
	              setDaoClass("");
	              setCustomListMethod("");
	              setAutoFillGrid(false);
	              setShowFilterToolbar(false);
	              setCheckBoxOnGridRows(true); 
	              setEditFieldGrid(true); 
	              setColumnsDefinition(getInsr4100());
	              
	          } 
	    }	
	    
	    public List<ColumnDef> getInsr3100ToInsr4100(){	  

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


	    	/** column 사업장코드 : dpobCd */
	    	listColumnDefs.add(new ColumnDef("사업장코드", Insr4100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, false){
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
	        listColumnDefs.add(new ColumnDef("고용구분", Insr4100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, false, true, false){
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
	        


	    	/** column SYSTEMKEY : systemkey */
	    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr4100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, false, false, false){
	    		{

	    		}
	    	});
	    	
	        /** column 한글성명 : hanNm */
	        listColumnDefs.add(new ColumnDef("성명", Insr4100BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 70, true, true, false){
	          {
	              setReadOnly(true);
	          }
	        });
	        /** column 주민등록번호 : resnRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Insr4100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, false){
	          {
	              setReadOnly(true);
	          }
	        });
	        
	        /** column 주민등록번호 : secRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Insr4100BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
	          {
	              setReadOnly(true);
	          }
	        });
	         
	    	
//	        /** set 고용일련번호 : emymtSeilNum */
//	    	listColumnDefs.add(new ColumnDef("연금일련번호", Insr4100BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_LONG , 90, false, false, false){
//	    		{
//
//	    		}
//	    	});
	    	/** column 고용일련번호 : emymtSeilNum */
	    	listColumnDefs.add(new ColumnDef("고용일련번호", Insr4100BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_LONG , 90, false, false, false){
	    		{

	    		}
	    	});
	    	
	    	/** column 국민연금변동일자 : natPennInsurFlucDt */
	    	listColumnDefs.add(new ColumnDef("국민연금변동일자", Insr4100BM.ATTR_NATPENNINSURFLUCDT, ColumnDef.TYPE_STRING , 90, false, false, false){
	    		{

	    		}
	    	});
	    	
	    	/** column 국민연금등급 : natPennGrde */
	    	listColumnDefs.add(new ColumnDef("등급", Insr4100BM.ATTR_NATPENNGRDE, ColumnDef.TYPE_STRING , 50, false, true, false){
	    		{
//	    			  setGridCellRenderer(GWTUtils.createLinkUrlColumnRenderer(
//	                          Bord0400BM.ATTR_FLNM, Bord0400BM.ATTR_FLNM, "down/BoardFileDownload.do" ));  //Bord0400BM.ATTR_FLRFTA
	    		}
	    	});
	    	/** column 국민연금등급 : natPennGrdeAmnt */
	    	listColumnDefs.add(new ColumnDef("보험료[등급]", Insr4100BM.ATTR_NATPENNGRDEAMNT, ColumnDef.TYPE_LONG , 90, false, true, false){
	    		{
	    			setReadOnly(true);
	    		}
	    	});
	    	
	    	/** column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
	    	listColumnDefs.add(new ColumnDef("기준소득월액", Insr4100BM.ATTR_NATPENNSTDINCMMNTHAMNT, ColumnDef.TYPE_LONG , 90, false, true, false){
	    		{  
	    		  
	    			
//	    			natPennStdIncmMnthAmnt.setRenderer(new GridCellRenderer<BaseModel>() {  
//	    			      public Long render(BaseModel model, String property, ColumnData config, int rowIndex, int colIndex,  
//	    			          ListStore<BaseModel> store, Grid<BaseModel> grid) {  
//	    			        return model.get(property, 0L) ;  
//	    			      }  
//	    			    });  
//	    			natPennStdIncmMnthAmnt.setSummaryType(SummaryType.SUM);  
//	    			natPennStdIncmMnthAmnt.setSummaryRenderer(new SummaryRenderer() {  
//	    			      public String render(Number value, Map<String, Number> data) {  
//	    			        return NumberFormat.getFormat("#,##0;(#,##0)").format(value.doubleValue());  
//	    			      }  
//	    			    });  
//	    			natPennStdIncmMnthAmnt.setEditor(new CellEditor(new NumberField())); 
//	    			     
//	    		    setSummaryColumnConfig(natPennStdIncmMnthAmnt);
	    		}
	    	});
	    	
	    	/** column 국민연금기준소득월액 : natPennMnthAmnt */
	    	listColumnDefs.add(new ColumnDef("보험료[기준소득월액]", Insr4100BM.ATTR_NATPENNMNTHAMNT, ColumnDef.TYPE_LONG , 100, false, true, false){
	    		{
	    			setReadOnly(true);
//	    			natPennMnthAmnt.setRenderer(new GridCellRenderer<BaseModel>() {  
//	    			      public Long render(BaseModel model, String property, ColumnData config, int rowIndex, int colIndex,  
//	    			          ListStore<BaseModel> store, Grid<BaseModel> grid) {  
//	    			        return model.get(property, 0L) ;  
//	    			      }  
//	    			    });  
//	    			natPennMnthAmnt.setSummaryType(SummaryType.SUM);  
//	    			natPennMnthAmnt.setSummaryRenderer(new SummaryRenderer() {  
//	    			      public String render(Number value, Map<String, Number> data) {  
//	    			        return NumberFormat.getFormat("#,##0;(#,##0)").format(value.doubleValue());  
//	    			      }  
//	    			    });  
//	    			natPennMnthAmnt.setEditor(new CellEditor(new NumberField())); 
//	    			     
//	    		    setSummaryColumnConfig(natPennMnthAmnt);
	    		}
	    	});
	    	 
	    	/** column 국민연금적용여부 : natPennApptnYn */
	    	listColumnDefs.add(new ColumnDef("국민연금적용여부", Insr4100BM.ATTR_NATPENNAPPTNYN, ColumnDef.TYPE_STRING , 90, false, false, false){
	    		{

	    		}
	    	});

	    	/** column 국민연금취득일자 : natPennAqtnDt */
	    	listColumnDefs.add(new ColumnDef("취득일자", Insr4100BM.ATTR_NATPENNAQTNDT, ColumnDef.TYPE_DATE , 80, true, true, true){
	    		{
	    			 
	    		}
	    	});
	    	/** column 국민연금상실일자 : natPennLssDt */
	    	listColumnDefs.add(new ColumnDef("상실일자", Insr4100BM.ATTR_NATPENNLSSDT, ColumnDef.TYPE_DATE , 80, false, true, false){
	    		{
	    			  setReadOnly(true);
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
	        /** column 직종 : typOccuCd */
	        listColumnDefs.add(new ColumnDef("직종", Insr4100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 호봉등급 : pyspGrdeCd */
	        listColumnDefs.add(new ColumnDef("호봉등급", Insr4100BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 직종세구분 : dtilOccuClsDivCd */
	        listColumnDefs.add(new ColumnDef("직종세", Insr4100BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        
	        /** column 사업 : businCd */
	        listColumnDefs.add(new ColumnDef("사업", Insr4100BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        
 

	    	 return listColumnDefs;
	    }     
	/**
	 *          
	 * @return
	 */
     public List<ColumnDef> getInsr4100(){	  

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


	    	/** column 사업장코드 : dpobCd */
	    	listColumnDefs.add(new ColumnDef("사업장코드", Insr4100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column SYSTEMKEY : systemkey */
	    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr4100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
//	    	/** column 국민연금일련번호 : natPennSeilNum */
//	    	listColumnDefs.add(new ColumnDef("국민연금일련번호", Insr4100BM.ATTR_NATPENNSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//	    		{
//
//	    		}
//	    	});
	    	/** column 고용일련번호 : emymtSeilNum */
	    	listColumnDefs.add(new ColumnDef("고용일련번호", Insr4100BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 국민연금취득일자 : natPennAqtnDt */
	    	listColumnDefs.add(new ColumnDef("국민연금취득일자", Insr4100BM.ATTR_NATPENNAQTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 국민연금상실일자 : natPennLssDt */
	    	listColumnDefs.add(new ColumnDef("국민연금상실일자", Insr4100BM.ATTR_NATPENNLSSDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력자 : kybdr */
	    	listColumnDefs.add(new ColumnDef("입력자", Insr4100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력일자 : inptDt */
	    	listColumnDefs.add(new ColumnDef("입력일자", Insr4100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력주소 : inptAddr */
	    	listColumnDefs.add(new ColumnDef("입력주소", Insr4100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정자 : ismt */
	    	listColumnDefs.add(new ColumnDef("수정자", Insr4100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정일자 : revnDt */
	    	listColumnDefs.add(new ColumnDef("수정일자", Insr4100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정주소 : revnAddr */
	    	listColumnDefs.add(new ColumnDef("수정주소", Insr4100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});

//	    	private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//	    	private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//	    	private TextField<String> natPennSeilNum;   /** column 국민연금일련번호 : natPennSeilNum */
//
//	    	private TextField<String> emymtSeilNum;   /** column 고용일련번호 : emymtSeilNum */
//
//	    	private TextField<String> natPennAqtnDt;   /** column 국민연금취득일자 : natPennAqtnDt */
//
//	    	private TextField<String> natPennLssDt;   /** column 국민연금상실일자 : natPennLssDt */
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
//	    	

	    	 return listColumnDefs;
	    }   
     
        /**
         * 
         * @return
         */
	    public List<ColumnDef> getInsrP310001ToInsr4100(){	  

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


	    	/** column 사업장코드 : dpobCd */
	    	listColumnDefs.add(new ColumnDef("사업장코드", Insr4100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, false){
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
	        listColumnDefs.add(new ColumnDef("고용구분", Insr4100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, false, true, false){
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
	        


	    	/** column SYSTEMKEY : systemkey */
	    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr4100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, false, false, false){
	    		{

	    		}
	    	});
	    	
	        /** column 한글성명 : hanNm */
	        listColumnDefs.add(new ColumnDef("성명", Insr4100BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 80, true, true, false){
	          {
	              setReadOnly(true);
	          }
	        });
	        /** column 주민등록번호 : resnRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Insr4100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, false){
	          {
	              setReadOnly(true);
	          }
	        });
	         
	        /** column 주민등록번호 : secRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Insr4100BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
	          {
	              setReadOnly(true);
	          }
	        });
	    	 
	    	
	    	/** column 국민연금등급 : natPennGrde */
	    	listColumnDefs.add(new ColumnDef("등급", Insr4100BM.ATTR_NATPENNGRDE, ColumnDef.TYPE_STRING , 90, false, true, false){
	    		{

	    		}
	    	});
	    	 
	    	
	    	/** column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
	    	listColumnDefs.add(new ColumnDef("기준소득월액", Insr4100BM.ATTR_NATPENNSTDINCMMNTHAMNT, ColumnDef.TYPE_LONG , 90, false, true, false){
	    		{

	    		}
	    	});
	    	  

			/** set 연금보험료 : PYMT_DDUC_D0150100 */
	    	listColumnDefs.add(new ColumnDef("연금보험료", Insr4100BM.ATTR_PYMTDDUCD0150100, ColumnDef.TYPE_LONG , 90, false, true, false){
	    		{

	    		}
	    	});
	    	
	    	/** set 정산보험료 : PYMT_DDUC_D0150200 */
	    	listColumnDefs.add(new ColumnDef("정산보험료", Insr4100BM.ATTR_PYMTDDUCD0150200, ColumnDef.TYPE_LONG , 90, false, true, false){
	    		{

	    		}
	    	});
	    	
	    	/** set 소급보험료 : pymtDducD0150300 */
	    	listColumnDefs.add(new ColumnDef("소급보험료", Insr4100BM.ATTR_PYMTDDUCD0150300, ColumnDef.TYPE_LONG , 90, false, true, false){
	    		{

	    		}
	    	});
	    	 
	    	/** set 합계 : pymtDducSum */
	    	listColumnDefs.add(new ColumnDef("합계", Insr4100BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG , 90, false, true, false){
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
	      
	        /** column 직종 : typOccuCd */
	        listColumnDefs.add(new ColumnDef("직종", Insr4100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 호봉등급 : pyspGrdeCd */
	        listColumnDefs.add(new ColumnDef("호봉등급", Insr4100BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 직종세구분 : dtilOccuClsDivCd */
	        listColumnDefs.add(new ColumnDef("직종세", Insr4100BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        
	        /** column 사업 : businCd */
	        listColumnDefs.add(new ColumnDef("사업", Insr4100BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        
 

	    	 return listColumnDefs;
	    }  
	    
	  
    
}
