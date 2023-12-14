package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr2100BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr2100VO.java
 * @Description : Insr2100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr2100Def  extends TableDef implements InsrDaoConstants {
	  private int row = 0;
	    private InsrConstants InsrLabel = InsrConstants.INSTANCE;
 

	        final PrgmComBass0300DTO sysComBass0300Dto;
	        
	       	
	      	 
	        public Insr2100Def(String chkDef){
	   	    	 
	       	 sysComBass0300Dto = new PrgmComBass0300DTO();  
	       	 
	   	   	 if ("INSR2300".equals(chkDef)) {
	   	   		 
	   	   		 
	   	        setTitle("");
		        setDaoClass("");
		        setCustomListMethod(CLASS_INSR2300TOINSR2100_DAO_LIST);
		        setAutoFillGrid(false);
		        setShowFilterToolbar(false);
		        setCheckBoxOnGridRows(true);
		        setFilterFormType(FILTER_FORM_SINGLE);
		        
	   		   	 
	   	         setColumnsDefinition(getInsr2300ToInsr2100());
	   	             
	   	         }  
	   	//   	    else if ("INSRP410002".equals(chkDef)) {
	   	//   		    setTitle("");
	   	//   	        setDaoClass("");
	   	//   	        setCustomListMethod(CLASS_INSRP410002TOINSR3000_DAO_LIST);
	   	//   	        setAutoFillGrid(false);
	   	//   	        setShowFilterToolbar(false);
	   	//   	        setCheckBoxOnGridRows(true);   
	   	//             setColumnsDefinition(getInsrP410002ToInsr3000());
	   	//         } else if ("INSRP410003".equals(chkDef)) {
	   	//   		    setTitle("");
	   	//   	        setDaoClass("");
	   	//   	        setCustomListMethod(CLASS_INSRP410003TOINSR3000_DAO_LIST);
	   	//   	        setAutoFillGrid(false);
	   	//   	        setShowFilterToolbar(false);
	   	//   	        setCheckBoxOnGridRows(true);   
	   	//             setColumnsDefinition(getInsrP410003ToInsr3000());
	   	//              
	   	//         } 
	      }	
	        
  public List<ColumnDef> getInsr2300ToInsr2100(){	   
	  
	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

				/** column 사업장코드 : dpobCd */
				listColumnDefs.add(new ColumnDef("사업장코드", Insr2100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
					{
				
					}
				});
				/** column SYSTEMKEY : systemkey */
				listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr2100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
					{
				
					}
				});
				/** column 사회보험작성일자 : soctyInsurCmptnDt */
				listColumnDefs.add(new ColumnDef("작성일자", Insr2100BM.ATTR_SOCTYINSURCMPTNDT, ColumnDef.TYPE_STRING , 70, true, true, true){
					{
				
					}
				});
				/** column 사회보험상실_고용_일련번호 : socInsrLssEmymtNum */
				listColumnDefs.add(new ColumnDef("사회보험상실_고용_일련번호", Insr2100BM.ATTR_SOCINSRLSSEMYMTNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
					{
				
					}
				});
				
				
		        /** column 한글성명 : hanNm */
		        listColumnDefs.add(new ColumnDef("성명", Insr2100BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, false){
		          {
		              setReadOnly(true);
		          }
		        });
				
		        /** column 주민등록번호 : resnRegnNum */
		        listColumnDefs.add(new ColumnDef("주민등록번호", Insr2100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, false){
		          {
		              setReadOnly(true);
		          }
		        }); 
		        
		        /** column 주민등록번호 : secRegnNum */
		        listColumnDefs.add(new ColumnDef("주민등록번호", Insr2100BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0,  false,  false, false){
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
				listColumnDefs.add(new ColumnDef("사회보험가입자전화번호", Insr2100BM.ATTR_SOCINSRMBRPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
					{
				
					}
				});
				/** column 국민연금신고여부 : natPennRegrstYn */
				listColumnDefs.add(new ColumnDef("국민", Insr2100BM.ATTR_NATPENNREGRSTYN, ColumnDef.TYPE_BOOLEAN , 40, true, true, true){
					{
				
					}
				});
				/** column 건강보험신고여부 : hlthInsrRegrstYn */
				listColumnDefs.add(new ColumnDef("건강", Insr2100BM.ATTR_HLTHINSRREGRSTYN, ColumnDef.TYPE_BOOLEAN , 40, true, true, true){
					{
				
					}
				});
				
				/** column 고용보험신고여부 : umytInsrRegrstYn */
				listColumnDefs.add(new ColumnDef("고용", Insr2100BM.ATTR_UMYTINSRREGRSTYN, ColumnDef.TYPE_BOOLEAN , 40, true, true, true){
					{
				
					}
				});
				/** column 산재보험신고여부 : idtlAccdtRegrstYn */
				listColumnDefs.add(new ColumnDef("산재", Insr2100BM.ATTR_IDTLACCDTREGRSTYN, ColumnDef.TYPE_BOOLEAN , 40, true, true, true){
					{
				
					}
				});
				
				
				/** column 사회보험상실일자 : soctyInsurLssDt */
				listColumnDefs.add(new ColumnDef("사회보험상실일자", Insr2100BM.ATTR_SOCTYINSURLSSDT, ColumnDef.TYPE_STRING , 90, true, false, true){
					{
				
					}
				});
				
				 /** column 고용구분코드 : emymtDivCd */
			      listColumnDefs.add(new ColumnDef("고용구분", Insr2100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, false, false, false){
			          {
			              setReadOnly(true);
			          }
			      });
			      /** column 부서코드 : deptCd */
			      listColumnDefs.add(new ColumnDef("부서", Insr2100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, false, true, false){
			          {
			              setReadOnly(true);
			          }
			      });
			      
	

					
					
					   /** column 직종코드 : typOccuCd */
			        listColumnDefs.add(new ColumnDef("직종", Insr2100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, false, false, false){
			            {
			            	  setReadOnly(true);
			            }
			        });
			        /** column 호봉등급코드 : pyspGrdeCd */
			        listColumnDefs.add(new ColumnDef("호봉등급코드", Insr2100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
			            {
			            	  setReadOnly(true);
			            }
			        });
			    
			        /** column 직종 : typOccuCd */
			        listColumnDefs.add(new ColumnDef("직종", Insr2100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, false, false){
			            {
			                setReadOnly(true);
			            }
			        });
			        /** column 호봉등급 : pyspGrdeCd */
			        listColumnDefs.add(new ColumnDef("호봉등급", Insr2100BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, false, false, false){
			            {
			                setReadOnly(true);
			            }
			        });
			        /** column 직종세구분코드 : dtilOccuClsDivCd */
			        listColumnDefs.add(new ColumnDef("직종세코드", Insr2100BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
			            {
			            	  setReadOnly(true);
			            }
			        });
			        
					/** column 직종세통합코드 : dtilOccuInttnCd */
					listColumnDefs.add(new ColumnDef("직종세통합코드", Insr2100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
					{
					
					}
					});            
			        
			        /** column 직종세구분 : dtilOccuClsDivCd */
			        listColumnDefs.add(new ColumnDef("직종세", Insr2100BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, true, false){
			            {
			                setReadOnly(true);
			            }
			        });
			        
			        
			        /** column 사업코드 : businCd */
			        listColumnDefs.add(new ColumnDef("사업", Insr2100BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, false, false, false){
			            {
			            	 setReadOnly(true);
			            }
			        }); 
			        
			        
			        /** column 사업 : businCd */
			        listColumnDefs.add(new ColumnDef("사업", Insr2100BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, true, false){
			            {
			                setReadOnly(true);
			            }
			        });
				
				
				
				
				
				
				
				/** column 입력자 : kybdr */
				listColumnDefs.add(new ColumnDef("입력자", Insr2100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
					{
				
					}
				});
				/** column 입력일자 : inptDt */
				listColumnDefs.add(new ColumnDef("입력일자", Insr2100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
					{
				
					}
				});
				/** column 입력주소 : inptAddr */
				listColumnDefs.add(new ColumnDef("입력주소", Insr2100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
					{
				
					}
				});
				/** column 수정자 : ismt */
				listColumnDefs.add(new ColumnDef("수정자", Insr2100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
					{
				
					}
				});
				/** column 수정일자 : revnDt */
				listColumnDefs.add(new ColumnDef("수정일자", Insr2100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
					{
				
					}
				});
				/** column 수정주소 : revnAddr */
				listColumnDefs.add(new ColumnDef("수정주소", Insr2100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
					{
				
					}
				});
				
				//private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
				//
				//private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
				//
				//private TextField<String> soctyInsurCmptnDt;   /** column 사회보험작성일자 : soctyInsurCmptnDt */
				//
				//private TextField<String> socInsrLssEmymtNum;   /** column 사회보험상실_고용_일련번호 : socInsrLssEmymtNum */
				//
				//private TextField<String> socInsrMbrPhnNum;   /** column 사회보험가입자전화번호 : socInsrMbrPhnNum */
				//
				//private TextField<String> hlthInsrRegrstYn;   /** column 건강보험신고여부 : hlthInsrRegrstYn */
				//
				//private TextField<String> natPennRegrstYn;   /** column 국민연금신고여부 : natPennRegrstYn */
				//
				//private TextField<String> umytInsrRegrstYn;   /** column 고용보험신고여부 : umytInsrRegrstYn */
				//
				//private TextField<String> idtlAccdtRegrstYn;   /** column 산재보험신고여부 : idtlAccdtRegrstYn */
				//
				//private TextField<String> soctyInsurLssDt;   /** column 사회보험상실일자 : soctyInsurLssDt */
				//
				//private TextField<String> kybdr;   /** column 입력자 : kybdr */
				//
				//private TextField<String> inptDt;   /** column 입력일자 : inptDt */
				//
				//private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
				//
				//private TextField<String> ismt;   /** column 수정자 : ismt */
				//
				//private TextField<String> revnDt;   /** column 수정일자 : revnDt */
				//
				//private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
				
				 return listColumnDefs;
		 
	    }   
    
}
