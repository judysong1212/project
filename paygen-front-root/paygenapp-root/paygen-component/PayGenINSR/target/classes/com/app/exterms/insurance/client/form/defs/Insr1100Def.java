package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr1100BM;
import com.app.exterms.insurance.client.dto.Insr1200BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.widget.form.Field;

/**
 * @Class Name : Insr1100VO.java
 * @Description : Insr1100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr1100Def  extends TableDef implements InsrDaoConstants {


    private int row = 0;
    private InsrConstants InsrLabel = InsrConstants.INSTANCE; 
    	
    final PrgmComBass0300DTO sysComBass0300Dto;
    
    protected ColumnDefListenerAdapter changeValueListenerAdapter;
   	 
    public Insr1100Def(String chkDef){
	    	 
    	 sysComBass0300Dto = new PrgmComBass0300DTO();  
    	 
	   	 if ("INSR2100".equals(chkDef)) {
	   		 
		   		setTitle("");
		   	    setDaoClass(""); 
		   	    setAutoFillGrid(false);
		   	    setShowFilterToolbar(false);
		   	    setCheckBoxOnGridRows(true);
		   	    setFilterFormType(FILTER_FORM_SINGLE);
	   	        setCustomListMethod(CLASS_INSR2100TOINSR1100_DAO_LIST);
	   	      
	             setColumnsDefinition(getInsr2100ToInsr1100());
	             
	         }else if("INSR2150".equals(chkDef)) {
			   		setTitle("");
			   	    setDaoClass(""); 
			   	    setAutoFillGrid(false);
			   	    setShowFilterToolbar(false);
			   	    setCheckBoxOnGridRows(true);
			   	    setFilterFormType(FILTER_FORM_SINGLE);
		   	        setCustomListMethod(CLASS_INSR2150TOINSR1100_DAO_LIST);
		   	      
		   	        setColumnsDefinition(getInsr2150ToInsr1100()); 
	         }else if("INSR2400".equals(chkDef)) {
			   		setTitle("");
			   	    setDaoClass(""); 
			   	    setAutoFillGrid(false);
			   	    setShowFilterToolbar(false);
			   	    setCheckBoxOnGridRows(true);
			   	    setFilterFormType(FILTER_FORM_SINGLE);
		   	        setCustomListMethod(CLASS_INSR2100TOINSR1100_DAO_LIST);
		   	      
		   	        setColumnsDefinition(getInsr2400ToInsr1100()); 
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
	   	 
	         else if ("INSR210002".equals(chkDef)) {
	        	 
	        	 setDaoClass(CLASS_INSR210002TOINSR12000240_DAO_LIST);
	             setCustomListMethod(CLASS_INSR210002TOINSR12000240_DAO_LIST);
	             setAutoFillGrid(false);
	             setEditFieldGrid(true);
	             setShowFilterToolbar(false);
	             setCheckBoxOnGridRows(true);
	             
	             changeValueListenerAdapter = new ColumnDefListenerAdapter() {
	            	 @SuppressWarnings("rawtypes")
	            	 public void run(Field field, Object valueField) {
	            		 MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
	            		 final ModelData formModel = formPanel.getFormBinding().getModel();

	            		 Long natPennIncome = Long.parseLong(MSFSharedUtils.defaultNulls(formModel.get(Insr1100BM.ATTR_NATPENNINCOME).toString(),"0"));
	            		 double natPennHmlfBrdnApmrt = Double.parseDouble(MSFSharedUtils.defaultNulls(formModel.get(Insr1100BM.ATTR_NATPENNHMLFBRDNAPMRT).toString(),"0"));
	            		 long natPennPremium = (long) (natPennIncome * natPennHmlfBrdnApmrt * 0.01);
	            		 
	            		 Long hlthInsrIncome = Long.parseLong(MSFSharedUtils.defaultNulls(formModel.get(Insr1100BM.ATTR_HLTHINSRINCOME).toString(),"0"));
	            		 double hlthInsrHmlfBrdnApmrt = Double.parseDouble(MSFSharedUtils.defaultNulls(formModel.get(Insr1100BM.ATTR_HLTHINSRHMLFBRDNAPMRT).toString(),"0"));
	            		 long hlthInsrPremium = (long) (hlthInsrIncome * hlthInsrHmlfBrdnApmrt * 0.01);
	            		 
	            		 Long umytInsrIncome = Long.parseLong(MSFSharedUtils.defaultNulls(formModel.get(Insr1100BM.ATTR_UMYTINSRINCOME).toString(),"0"));
	            		 double umytInsrHmlfBrdnApmrt = Double.parseDouble(MSFSharedUtils.defaultNulls(formModel.get(Insr1100BM.ATTR_UMYTINSRHMLFBRDNAPMRT).toString(),"0"));
	            		 long umytInsrPremium = (long) (umytInsrIncome * umytInsrHmlfBrdnApmrt * 0.01);

	            		 Long idtlAccdtIncome = Long.parseLong(MSFSharedUtils.defaultNulls(formModel.get(Insr1100BM.ATTR_IDTLACCDTINCOME).toString(),"0"));
	            		 double idtlInsrHmlfBrdnApmrt = Double.parseDouble(MSFSharedUtils.defaultNulls(formModel.get(Insr1100BM.ATTR_IDTLINSRHMLFBRDNAPMRT).toString(),"0"));
	            		 long idtlAccdtPremium = (long) (idtlAccdtIncome * idtlInsrHmlfBrdnApmrt * 0.01);
	                    
	            		 formModel.set(Insr1100BM.ATTR_NATPENNPREMIUM, natPennPremium);
	            		 formModel.set(Insr1100BM.ATTR_HLTHINSRPREMIUM, hlthInsrPremium);
	            		 formModel.set(Insr1100BM.ATTR_UMYTINSRPREMIUM, umytInsrPremium);
	            		 formModel.set(Insr1100BM.ATTR_IDTLACCDTPREMIUM, idtlAccdtPremium);
	            	 }
	             };
	             
	             setColumnsDefinition(getInsr210002ToInsr1200());
	         }
	         else if ("INSR210005".equals(chkDef)) {
		   		 
			   		setTitle("");
			   	    setDaoClass(""); 
			   	    setAutoFillGrid(false);
			   	    setShowFilterToolbar(false);
			   	    setCheckBoxOnGridRows(true);
			   	    setFilterFormType(FILTER_FORM_SINGLE);
		   	        setCustomListMethod(CLASS_INSR2100TOINSR1100_DAO_LIST);
		   	      
		             setColumnsDefinition(getInsr210005ToInsr1100());
		             
		         }
   }	

    public void setitemChange(Field itemField,Object itemCd) {
        
        changeValueListenerAdapter.run(itemField, itemCd);
        
    }
    
    public List<ColumnDef> getInsr2100ToInsr1100(){	
  

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Insr1100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr1100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험작성일자 : soctyInsurCmptnDt */
		listColumnDefs.add(new ColumnDef("작성일자", Insr1100BM.ATTR_SOCTYINSURCMPTNDT, ColumnDef.TYPE_STRING , 60, true, false, true){
			{
		
			}
		});
		
		/** column [건강]자격취득일 :  */
		listColumnDefs.add(new ColumnDef("취득일자", Insr1200BM.ATTR_SOCNSRAQTNREGVAL17, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		
		/** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
		listColumnDefs.add(new ColumnDef("사회보험취득_고용_일련번호", Insr1100BM.ATTR_SOCINSRAQTNEMYMTNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{
		
			}
		});
		 
    	
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Insr1100BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, false){
          {
              setReadOnly(true);
          }
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Insr1100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, false){
          {
              setReadOnly(true);
          }
        }); 
        
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Insr1100BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
          {
              setReadOnly(true);
          }
        }); 
        
        /** column 핸드폰번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("핸드폰번호", Insr1100BM.ATTR_CELLPHNENUM, ColumnDef.TYPE_STRING, 90, true, false, false){
          {
              setReadOnly(true);
          }
        }); 
        
        /** column 피부양자여부 : insr1400Yn */
		listColumnDefs.add(new ColumnDef("피부양", Insr1100BM.ATTR_INSR1500YN, ColumnDef.TYPE_BOOLEAN , 50, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		
		/** column 국민연금신고여부 : natPennRegrstYn */
		listColumnDefs.add(new ColumnDef("국민", Insr1100BM.ATTR_NATPENNREGRSTYN, ColumnDef.TYPE_BOOLEAN , 30, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column 건강보험신고여부 : hlthInsrRegrstYn */
		listColumnDefs.add(new ColumnDef("건강", Insr1100BM.ATTR_HLTHINSRREGRSTYN, ColumnDef.TYPE_BOOLEAN , 30, true, true, true){
			{
				 setReadOnly(true);
			}
		}); 
		/** column 고용보험신고여부 : umytInsrRegrstYn */
		listColumnDefs.add(new ColumnDef("고용", Insr1100BM.ATTR_UMYTINSRREGRSTYN, ColumnDef.TYPE_BOOLEAN , 30, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column 산재보험신고여부 : idtlAccdtRegrstYn */
		listColumnDefs.add(new ColumnDef("산재", Insr1100BM.ATTR_IDTLACCDTREGRSTYN, ColumnDef.TYPE_BOOLEAN , 30, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		
		
		  /** column 고용구분코드 : emymtDivCd */
      listColumnDefs.add(new ColumnDef("고용구분", Insr1100BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
          {
          	 setReadOnly(true);
          }
      });
      /** column 부서코드 : deptCd */
      listColumnDefs.add(new ColumnDef("부서", Insr1100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
          {
          	 setReadOnly(true);
          }
      });
      
   
      
      /** column 고용구분코드 : emymtDivCd */
      listColumnDefs.add(new ColumnDef("고용구분", Insr1100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, false, false, false){
          {
              setReadOnly(true);
          }
      });
      /** column 부서코드 : deptCd */
      listColumnDefs.add(new ColumnDef("부서", Insr1100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, false, true, false){
          {
              setReadOnly(true);
          }
      });
      
		/** column 국적코드 : natnCd */
		listColumnDefs.add(new ColumnDef("국적코드", Insr1100BM.ATTR_NATNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험대표자여부 : socInsrDegtrYn */
		listColumnDefs.add(new ColumnDef("사회보험대표자여부", Insr1100BM.ATTR_SOCINSRDEGTRYN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험체류자격코드 : socInsrStyQftntCd */
		listColumnDefs.add(new ColumnDef("사회보험체류자격코드", Insr1100BM.ATTR_SOCINSRSTYQFTNTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		
		
		   /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종", Insr1100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
            	  setReadOnly(true);
            }
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Insr1100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
            	  setReadOnly(true);
            }
        });
    
        /** column 직종 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종", Insr1100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
                setReadOnly(true);
            }
        });
        /** column 호봉등급 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급", Insr1100BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
                setReadOnly(true);
            }
        });
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세코드", Insr1100BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
            	  setReadOnly(true);
            }
        });
        
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Insr1100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		{
		
		}
		});            
        
        /** column 직종세구분 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세", Insr1100BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, true, false){
            {
                setReadOnly(true);
            }
        });
        
        
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업", Insr1100BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
            	 setReadOnly(true);
            }
        }); 
        
        
        /** column 사업 : businCd */
        listColumnDefs.add(new ColumnDef("사업", Insr1100BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, true, false){
            {
                setReadOnly(true);
            }
        });
//		/** column 입력자 : kybdr */
//		listColumnDefs.add(new ColumnDef("입력자", Insr1100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//			{
//		
//			}
//		});
//		/** column 입력일자 : inptDt */
//		listColumnDefs.add(new ColumnDef("입력일자", Insr1100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//			{
//		
//			}
//		});
//		/** column 입력주소 : inptAddr */
//		listColumnDefs.add(new ColumnDef("입력주소", Insr1100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//			{
//		
//			}
//		});
//		/** column 수정자 : ismt */
//		listColumnDefs.add(new ColumnDef("수정자", Insr1100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//			{
//		
//			}
//		});
//		/** column 수정일자 : revnDt */
//		listColumnDefs.add(new ColumnDef("수정일자", Insr1100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//			{
//		
//			}
//		});
//		/** column 수정주소 : revnAddr */
//		listColumnDefs.add(new ColumnDef("수정주소", Insr1100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//			{
//		
//			}
//		});
		
//		private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//		
//		private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//		
//		private TextField<String> soctyInsurCmptnDt;   /** column 사회보험작성일자 : soctyInsurCmptnDt */
//		
//		private TextField<String> socInsrAqtnEmymtNum;   /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
//		
//		private TextField<String> natnCd;   /** column 국적코드 : natnCd */
//		
//		private TextField<String> socInsrDegtrYn;   /** column 사회보험대표자여부 : socInsrDegtrYn */
//		
//		private TextField<String> socInsrStyQftntCd;   /** column 사회보험체류자격코드 : socInsrStyQftntCd */
//		
//		private TextField<String> hlthInsrRegrstYn;   /** column 건강보험신고여부 : hlthInsrRegrstYn */
//		
//		private TextField<String> natPennRegrstYn;   /** column 국민연금신고여부 : natPennRegrstYn */
//		
//		private TextField<String> umytInsrRegrstYn;   /** column 고용보험신고여부 : umytInsrRegrstYn */
//		
//		private TextField<String> idtlAccdtRegrstYn;   /** column 산재보험신고여부 : idtlAccdtRegrstYn */
//		
//		private TextField<String> kybdr;   /** column 입력자 : kybdr */
//		
//		private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//		
//		private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//		
//		private TextField<String> ismt;   /** column 수정자 : ismt */
//		
//		private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//		
//		private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
		
		 return listColumnDefs;
    }   
   
    public List<ColumnDef> getInsr2150ToInsr1100(){	
	   

       List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Insr1100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr1100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험작성일자 : soctyInsurCmptnDt */
		/*listColumnDefs.add(new ColumnDef("작성일자", Insr1100BM.ATTR_SOCTYINSURCMPTNDT, ColumnDef.TYPE_DATE , 70, true, true, true){
			{
		
			}
		});*/
		
		/** column [건강]자격취득일 :  */
		listColumnDefs.add(new ColumnDef("취득일자", Insr1200BM.ATTR_SOCNSRAQTNREGVAL17, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		
		
		/** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
		listColumnDefs.add(new ColumnDef("사회보험취득_고용_일련번호", Insr1100BM.ATTR_SOCINSRAQTNEMYMTNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		
   	
       /** column 한글성명 : hanNm */
       listColumnDefs.add(new ColumnDef("성명", Insr1100BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, false){
         {
             setReadOnly(true);
         }
       });
       /** column 주민등록번호 : resnRegnNum */
       listColumnDefs.add(new ColumnDef("주민등록번호", Insr1100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, false){
         {
             setReadOnly(true);
         }
       }); 
       /** column 주민등록번호 : resnRegnNum */
       listColumnDefs.add(new ColumnDef("주민등록번호", Insr1100BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
         {
             setReadOnly(true);
         }
       }); 
       /** column 피부양자여부 : insr1500Yn */
		listColumnDefs.add(new ColumnDef("피부양", Insr1100BM.ATTR_INSR1500YN, ColumnDef.TYPE_BOOLEAN , 50, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		
		/** column 국민연금신고여부 : natPennRegrstYn */
		listColumnDefs.add(new ColumnDef("국민", Insr1100BM.ATTR_NATPENNREGRSTYN, ColumnDef.TYPE_BOOLEAN , 50, true, false, true){
			{
				 setReadOnly(true);
			}
		});
		/** column 건강보험신고여부 : hlthInsrRegrstYn */
		listColumnDefs.add(new ColumnDef("건강", Insr1100BM.ATTR_HLTHINSRREGRSTYN, ColumnDef.TYPE_BOOLEAN , 50, true, false, true){
			{
				 setReadOnly(true);
			}
		}); 
		/** column 고용보험신고여부 : umytInsrRegrstYn */
		listColumnDefs.add(new ColumnDef("고용", Insr1100BM.ATTR_UMYTINSRREGRSTYN, ColumnDef.TYPE_BOOLEAN , 50, true, false, true){
			{
				 setReadOnly(true);
			}
		});
		/** column 산재보험신고여부 : idtlAccdtRegrstYn */
		listColumnDefs.add(new ColumnDef("산재", Insr1100BM.ATTR_IDTLACCDTREGRSTYN, ColumnDef.TYPE_BOOLEAN , 50, true, false, true){
			{
				 setReadOnly(true);
			}
		});
		
		
		  /** column 고용구분코드 : emymtDivCd */
     listColumnDefs.add(new ColumnDef("고용구분", Insr1100BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
         {
         	 setReadOnly(true);
         }
     });
     /** column 부서코드 : deptCd */
     listColumnDefs.add(new ColumnDef("부서", Insr1100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
         {
         	 setReadOnly(true);
         }
     });
     
  
     
     /** column 고용구분코드 : emymtDivCd */
     listColumnDefs.add(new ColumnDef("고용구분", Insr1100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, false, false, false){
         {
             setReadOnly(true);
         }
     });
     /** column 부서코드 : deptCd */
     listColumnDefs.add(new ColumnDef("부서", Insr1100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, false, true, false){
         {
             setReadOnly(true);
         }
     });
     
		/** column 국적코드 : natnCd */
		listColumnDefs.add(new ColumnDef("국적코드", Insr1100BM.ATTR_NATNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험대표자여부 : socInsrDegtrYn */
		listColumnDefs.add(new ColumnDef("사회보험대표자여부", Insr1100BM.ATTR_SOCINSRDEGTRYN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험체류자격코드 : socInsrStyQftntCd */
		listColumnDefs.add(new ColumnDef("사회보험체류자격코드", Insr1100BM.ATTR_SOCINSRSTYQFTNTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		
		
		   /** column 직종코드 : typOccuCd */
       listColumnDefs.add(new ColumnDef("직종", Insr1100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
           	  setReadOnly(true);
           }
       });
       /** column 호봉등급코드 : pyspGrdeCd */
       listColumnDefs.add(new ColumnDef("호봉등급코드", Insr1100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
           	  setReadOnly(true);
           }
       });
   
       /** column 직종 : typOccuCd */
       listColumnDefs.add(new ColumnDef("직종", Insr1100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
               setReadOnly(true);
           }
       });
       /** column 호봉등급 : pyspGrdeCd */
       listColumnDefs.add(new ColumnDef("호봉등급", Insr1100BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
               setReadOnly(true);
           }
       });
       /** column 직종세구분코드 : dtilOccuClsDivCd */
       listColumnDefs.add(new ColumnDef("직종세코드", Insr1100BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
           	  setReadOnly(true);
           }
       });
       
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Insr1100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		{
		
		}
		});            
       
       /** column 직종세구분 : dtilOccuClsDivCd */
       listColumnDefs.add(new ColumnDef("직종세", Insr1100BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, true, false){
           {
               setReadOnly(true);
           }
       });
       
       
       /** column 사업코드 : businCd */
       listColumnDefs.add(new ColumnDef("사업", Insr1100BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
           	 setReadOnly(true);
           }
       }); 
       
       
       /** column 사업 : businCd */
       listColumnDefs.add(new ColumnDef("사업", Insr1100BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, true, false){
           {
               setReadOnly(true);
           }
       });
//		/** column 입력자 : kybdr */
//		listColumnDefs.add(new ColumnDef("입력자", Insr1100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//			{
//		
//			}
//		});
//		/** column 입력일자 : inptDt */
//		listColumnDefs.add(new ColumnDef("입력일자", Insr1100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//			{
//		
//			}
//		});
//		/** column 입력주소 : inptAddr */
//		listColumnDefs.add(new ColumnDef("입력주소", Insr1100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//			{
//		
//			}
//		});
//		/** column 수정자 : ismt */
//		listColumnDefs.add(new ColumnDef("수정자", Insr1100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//			{
//		
//			}
//		});
//		/** column 수정일자 : revnDt */
//		listColumnDefs.add(new ColumnDef("수정일자", Insr1100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//			{
//		
//			}
//		});
//		/** column 수정주소 : revnAddr */
//		listColumnDefs.add(new ColumnDef("수정주소", Insr1100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//			{
//		
//			}
//		});
		
//		private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//		
//		private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//		
//		private TextField<String> soctyInsurCmptnDt;   /** column 사회보험작성일자 : soctyInsurCmptnDt */
//		
//		private TextField<String> socInsrAqtnEmymtNum;   /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
//		
//		private TextField<String> natnCd;   /** column 국적코드 : natnCd */
//		
//		private TextField<String> socInsrDegtrYn;   /** column 사회보험대표자여부 : socInsrDegtrYn */
//		
//		private TextField<String> socInsrStyQftntCd;   /** column 사회보험체류자격코드 : socInsrStyQftntCd */
//		
//		private TextField<String> hlthInsrRegrstYn;   /** column 건강보험신고여부 : hlthInsrRegrstYn */
//		
//		private TextField<String> natPennRegrstYn;   /** column 국민연금신고여부 : natPennRegrstYn */
//		
//		private TextField<String> umytInsrRegrstYn;   /** column 고용보험신고여부 : umytInsrRegrstYn */
//		
//		private TextField<String> idtlAccdtRegrstYn;   /** column 산재보험신고여부 : idtlAccdtRegrstYn */
//		
//		private TextField<String> kybdr;   /** column 입력자 : kybdr */
//		
//		private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//		
//		private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//		
//		private TextField<String> ismt;   /** column 수정자 : ismt */
//		
//		private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//		
//		private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
		
		 return listColumnDefs;
   }   
   
    public List<ColumnDef> getInsr2400ToInsr1100(){	
	   

       List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Insr1100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr1100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험작성일자 : soctyInsurCmptnDt */
		listColumnDefs.add(new ColumnDef("작성일자", Insr1100BM.ATTR_SOCTYINSURCMPTNDT, ColumnDef.TYPE_DATE , 70, true, true, true){
			{
		
			}
		});
		/** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
		listColumnDefs.add(new ColumnDef("사회보험취득_고용_일련번호", Insr1100BM.ATTR_SOCINSRAQTNEMYMTNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{
		
			}
		});
		 
   	
       /** column 한글성명 : hanNm */
       listColumnDefs.add(new ColumnDef("성명", Insr1100BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, false){
         {
             setReadOnly(true);
         }
       });
       /** column 주민등록번호 : resnRegnNum */
       listColumnDefs.add(new ColumnDef("주민등록번호", Insr1100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, false){
         {
             setReadOnly(true);
         }
       }); 
       /** column 주민등록번호 : resnRegnNum */
       listColumnDefs.add(new ColumnDef("주민등록번호", Insr1100BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
         {
             setReadOnly(true);
         }
       }); 
       /** column 피부양자여부 : insr1400Yn */
		listColumnDefs.add(new ColumnDef("피부양", Insr1100BM.ATTR_INSR1400YN, ColumnDef.TYPE_BOOLEAN , 50, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		
		/** column 국민연금신고여부 : natPennRegrstYn */
		listColumnDefs.add(new ColumnDef("국민", Insr1100BM.ATTR_NATPENNREGRSTYN, ColumnDef.TYPE_BOOLEAN , 50, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column 건강보험신고여부 : hlthInsrRegrstYn */
		listColumnDefs.add(new ColumnDef("건강", Insr1100BM.ATTR_HLTHINSRREGRSTYN, ColumnDef.TYPE_BOOLEAN , 50, true, true, true){
			{
				 setReadOnly(true);
			}
		}); 
		/** column 고용보험신고여부 : umytInsrRegrstYn */
		listColumnDefs.add(new ColumnDef("고용", Insr1100BM.ATTR_UMYTINSRREGRSTYN, ColumnDef.TYPE_BOOLEAN , 50, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column 산재보험신고여부 : idtlAccdtRegrstYn */
		listColumnDefs.add(new ColumnDef("산재", Insr1100BM.ATTR_IDTLACCDTREGRSTYN, ColumnDef.TYPE_BOOLEAN , 50, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		
		
		  /** column 고용구분코드 : emymtDivCd */
     listColumnDefs.add(new ColumnDef("고용구분", Insr1100BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
         {
         	 setReadOnly(true);
         }
     });
     /** column 부서코드 : deptCd */
     listColumnDefs.add(new ColumnDef("부서", Insr1100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
         {
         	 setReadOnly(true);
         }
     });
     
  
     
     /** column 고용구분코드 : emymtDivCd */
     listColumnDefs.add(new ColumnDef("고용구분", Insr1100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, false, false, false){
         {
             setReadOnly(true);
         }
     });
     /** column 부서코드 : deptCd */
     listColumnDefs.add(new ColumnDef("부서", Insr1100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, false, true, false){
         {
             setReadOnly(true);
         }
     });
     
		/** column 국적코드 : natnCd */
		listColumnDefs.add(new ColumnDef("국적코드", Insr1100BM.ATTR_NATNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험대표자여부 : socInsrDegtrYn */
		listColumnDefs.add(new ColumnDef("사회보험대표자여부", Insr1100BM.ATTR_SOCINSRDEGTRYN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험체류자격코드 : socInsrStyQftntCd */
		listColumnDefs.add(new ColumnDef("사회보험체류자격코드", Insr1100BM.ATTR_SOCINSRSTYQFTNTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		
		
		   /** column 직종코드 : typOccuCd */
       listColumnDefs.add(new ColumnDef("직종", Insr1100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
           	  setReadOnly(true);
           }
       });
       /** column 호봉등급코드 : pyspGrdeCd */
       listColumnDefs.add(new ColumnDef("호봉등급코드", Insr1100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
           	  setReadOnly(true);
           }
       });
   
       /** column 직종 : typOccuCd */
       listColumnDefs.add(new ColumnDef("직종", Insr1100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
               setReadOnly(true);
           }
       });
       /** column 호봉등급 : pyspGrdeCd */
       listColumnDefs.add(new ColumnDef("호봉등급", Insr1100BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
               setReadOnly(true);
           }
       });
       /** column 직종세구분코드 : dtilOccuClsDivCd */
       listColumnDefs.add(new ColumnDef("직종세코드", Insr1100BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
           	  setReadOnly(true);
           }
       });
       
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Insr1100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		{
		
		}
		});            
       
       /** column 직종세구분 : dtilOccuClsDivCd */
       listColumnDefs.add(new ColumnDef("직종세", Insr1100BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, true, false){
           {
               setReadOnly(true);
           }
       });
       
       
       /** column 사업코드 : businCd */
       listColumnDefs.add(new ColumnDef("사업", Insr1100BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
           	 setReadOnly(true);
           }
       }); 
       
       
       /** column 사업 : businCd */
       listColumnDefs.add(new ColumnDef("사업", Insr1100BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, true, false){
           {
               setReadOnly(true);
           }
       });
//		/** column 입력자 : kybdr */
//		listColumnDefs.add(new ColumnDef("입력자", Insr1100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//			{
//		
//			}
//		});
//		/** column 입력일자 : inptDt */
//		listColumnDefs.add(new ColumnDef("입력일자", Insr1100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//			{
//		
//			}
//		});
//		/** column 입력주소 : inptAddr */
//		listColumnDefs.add(new ColumnDef("입력주소", Insr1100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//			{
//		
//			}
//		});
//		/** column 수정자 : ismt */
//		listColumnDefs.add(new ColumnDef("수정자", Insr1100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//			{
//		
//			}
//		});
//		/** column 수정일자 : revnDt */
//		listColumnDefs.add(new ColumnDef("수정일자", Insr1100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//			{
//		
//			}
//		});
//		/** column 수정주소 : revnAddr */
//		listColumnDefs.add(new ColumnDef("수정주소", Insr1100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//			{
//		
//			}
//		});
		
//		private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//		
//		private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//		
//		private TextField<String> soctyInsurCmptnDt;   /** column 사회보험작성일자 : soctyInsurCmptnDt */
//		
//		private TextField<String> socInsrAqtnEmymtNum;   /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
//		
//		private TextField<String> natnCd;   /** column 국적코드 : natnCd */
//		
//		private TextField<String> socInsrDegtrYn;   /** column 사회보험대표자여부 : socInsrDegtrYn */
//		
//		private TextField<String> socInsrStyQftntCd;   /** column 사회보험체류자격코드 : socInsrStyQftntCd */
//		
//		private TextField<String> hlthInsrRegrstYn;   /** column 건강보험신고여부 : hlthInsrRegrstYn */
//		
//		private TextField<String> natPennRegrstYn;   /** column 국민연금신고여부 : natPennRegrstYn */
//		
//		private TextField<String> umytInsrRegrstYn;   /** column 고용보험신고여부 : umytInsrRegrstYn */
//		
//		private TextField<String> idtlAccdtRegrstYn;   /** column 산재보험신고여부 : idtlAccdtRegrstYn */
//		
//		private TextField<String> kybdr;   /** column 입력자 : kybdr */
//		
//		private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//		
//		private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//		
//		private TextField<String> ismt;   /** column 수정자 : ismt */
//		
//		private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//		
//		private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
		
		 return listColumnDefs;
   }   
   
    public List<ColumnDef> getInsr210002ToInsr1200(){	

       List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

       
       /** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Insr1100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr1100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험작성일자 : soctyInsurCmptnDt */
		listColumnDefs.add(new ColumnDef("작성일자", Insr1100BM.ATTR_SOCTYINSURCMPTNDT, ColumnDef.TYPE_STRING , 70, true, false, true){
			{
		
			}
		});
		/** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
		listColumnDefs.add(new ColumnDef("사회보험취득_고용_일련번호", Insr1100BM.ATTR_SOCINSRAQTNEMYMTNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{
		
			}
		});
       
       
       /** column 부서이름 : deptNm */
       listColumnDefs.add(new ColumnDef("부서", Insr1100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, false, true, false){
    	   {
    		   setReadOnly(true);
    	   }
       });
       /** column 부서코드 : deptCd */
       listColumnDefs.add(new ColumnDef("부서", Insr1100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
           	 setReadOnly(true);
           }
       });
       
       /** column 한글성명 : hanNm */
       listColumnDefs.add(new ColumnDef("성명", Insr1100BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, false){
    	   {
    		   setReadOnly(true);
    	   }
       });
       
       /** column 주민등록번호 : resnRegnNum */
       listColumnDefs.add(new ColumnDef("주민등록번호", Insr1100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, false){
    	   {
    		   setReadOnly(true);
    	   }
       }); 
       /** column 주민등록번호 : resnRegnNum */
       listColumnDefs.add(new ColumnDef("주민등록번호", Insr1100BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
    	   {
    		   setReadOnly(true);
    	   }
       }); 
       /** column [국민]신고 : natPennRegrstYn */
       listColumnDefs.add(new ColumnDef("신고", Insr1100BM.ATTR_NATPENNREGRSTYN, ColumnDef.TYPE_BOOLEAN , 70, true, true, true){
			{
				 setReadOnly(true);
			}
		});
       /** column [국민]소득월액 :  */
       listColumnDefs.add(new ColumnDef("소득월액", Insr1100BM.ATTR_NATPENNINCOME, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				addTrigger(Events.Change, changeValueListenerAdapter);
			}
		});
       /** column [국민]보험료 :  */
       listColumnDefs.add(new ColumnDef("보험료", Insr1100BM.ATTR_NATPENNPREMIUM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
				 setReadOnly(true);
			}
		});
       /** column 국민_본인부담요율 : natPennHmlfBrdnApmrt */
       listColumnDefs.add(new ColumnDef("본인부담요율", Insr1100BM.ATTR_NATPENNHMLFBRDNAPMRT, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
           }
       });
       
       /** column [건강]신고 : hlthInsrRegrstYn */
       listColumnDefs.add(new ColumnDef("신고", Insr1100BM.ATTR_HLTHINSRREGRSTYN, ColumnDef.TYPE_BOOLEAN , 70, true, true, true){
    	   {
    		   setReadOnly(true);
		   }
	   });
       /** column [건강]보수월액 : hlthInsrRegrstYn */
       listColumnDefs.add(new ColumnDef("보수월액", Insr1100BM.ATTR_HLTHINSRINCOME, ColumnDef.TYPE_STRING , 90, true, true, true){
    	   {
    		   addTrigger(Events.Change, changeValueListenerAdapter);
		   }
	   }); 
       /** column [건강]보험료 : hlthInsrRegrstYn */
       listColumnDefs.add(new ColumnDef("보험료", Insr1100BM.ATTR_HLTHINSRPREMIUM, ColumnDef.TYPE_STRING , 80, true, true, true){
    	   {
    		   setReadOnly(true);
		   }
	   });
       /** column 건강_본인부담요율 : hlthInsrHmlfBrdnApmrt */
       listColumnDefs.add(new ColumnDef("본인부담요율", Insr1100BM.ATTR_HLTHINSRHMLFBRDNAPMRT, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
           }
       });
       
       /** column [고용]신고 : umytInsrRegrstYn */
       listColumnDefs.add(new ColumnDef("신고", Insr1100BM.ATTR_UMYTINSRREGRSTYN, ColumnDef.TYPE_BOOLEAN , 70, true, true, true){
    	   {
    		   setReadOnly(true);
		   }
	   });
       /** column [고용]보수월액 : umytInsrRegrstYn */
       listColumnDefs.add(new ColumnDef("보수월액", Insr1100BM.ATTR_UMYTINSRINCOME, ColumnDef.TYPE_STRING , 90, true, true, true){
    	   {
    		   addTrigger(Events.Change, changeValueListenerAdapter);
		   }
	   });
       /** column [고용]보험료 : umytInsrRegrstYn */
       listColumnDefs.add(new ColumnDef("보험료", Insr1100BM.ATTR_UMYTINSRPREMIUM, ColumnDef.TYPE_STRING , 80, true, true, true){
    	   {
    		   setReadOnly(true);
		   }
	   });
       /** column 고용_본인부담요율 : umytInsrHmlfBrdnApmrt */
       listColumnDefs.add(new ColumnDef("본인부담요율", Insr1100BM.ATTR_UMYTINSRHMLFBRDNAPMRT, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
           }
       });
       
       /** column [산재]신고 : idtlAccdtRegrstYn */
       listColumnDefs.add(new ColumnDef("신고", Insr1100BM.ATTR_IDTLACCDTREGRSTYN, ColumnDef.TYPE_BOOLEAN , 70, true, true, true){
    	   {
    		   setReadOnly(true);
		   }
	   });
       /** column [산재]보수월액 : idtlAccdtRegrstYn */
       listColumnDefs.add(new ColumnDef("보수월액", Insr1100BM.ATTR_IDTLACCDTINCOME, ColumnDef.TYPE_STRING , 90, true, true, true){
    	   {
    		   addTrigger(Events.Change, changeValueListenerAdapter);
		   }
	   });
       /** column [산재]보험료 : idtlAccdtRegrstYn */
       listColumnDefs.add(new ColumnDef("보험료", Insr1100BM.ATTR_IDTLACCDTPREMIUM, ColumnDef.TYPE_STRING , 80, true, true, true){
    	   {
    		   setReadOnly(true);
		   }
	   });
       /** column 산재_본인부담요율 : idtlInsrHmlfBrdnApmrt */
       listColumnDefs.add(new ColumnDef("본인부담요율", Insr1100BM.ATTR_IDTLINSRHMLFBRDNAPMRT, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
           }
       });
       
       /** column 직종이름 : typOccuNm */
       listColumnDefs.add(new ColumnDef("직종", Insr1100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, true, false){
    	   {
    		   setReadOnly(true);
    	   }
       });
       /** column 직종코드 : typOccuCd */
       listColumnDefs.add(new ColumnDef("직종", Insr1100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
           	  setReadOnly(true);
           }
       });
       
       /** column 직종세구분이름 : dtilOccuClsDivNm */
       listColumnDefs.add(new ColumnDef("직종세", Insr1100BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, true, false){
           {
               setReadOnly(true);
           }
       });
       /** column 직종세구분코드 : dtilOccuClsDivCd */
       listColumnDefs.add(new ColumnDef("직종세코드", Insr1100BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
           	  setReadOnly(true);
           }
       });
       /** column 직종세통합코드 : dtilOccuInttnCd */
       listColumnDefs.add(new ColumnDef("직종세통합코드", Insr1100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	   {
    		   setReadOnly(true);
    	   }
	   });  
       /** column 사업코드 : businCd */
       listColumnDefs.add(new ColumnDef("사업", Insr1100BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, false, false, false){
    	   {
           	 setReadOnly(true);
           }
       }); 
       /** column 사업 : businNm */
       listColumnDefs.add(new ColumnDef("사업", Insr1100BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, true, false){
    	   {
               setReadOnly(true);
           }
       });
       
       
       
       
       
       
       
       
       /** column 사업장코드 : dpobCd */
       listColumnDefs.add(new ColumnDef("사업장코드", Insr1100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr1100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험작성일자 : soctyInsurCmptnDt */
		listColumnDefs.add(new ColumnDef("작성일자", Insr1100BM.ATTR_SOCTYINSURCMPTNDT, ColumnDef.TYPE_DATE , 70, true, false, true){
			{
		
			}
		});
		/** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
		listColumnDefs.add(new ColumnDef("사회보험취득_고용_일련번호", Insr1100BM.ATTR_SOCINSRAQTNEMYMTNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{
		
			}
		});

		/** column 피부양자여부 : insr1400Yn */
		listColumnDefs.add(new ColumnDef("피부양", Insr1100BM.ATTR_INSR1400YN, ColumnDef.TYPE_BOOLEAN , 50, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column 고용구분코드 : emymtDivCd */
		listColumnDefs.add(new ColumnDef("고용구분", Insr1100BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
			{
				setReadOnly(true);
				}
		});
		/** column 고용구분코드 : emymtDivCd */
		listColumnDefs.add(new ColumnDef("고용구분", Insr1100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, false, false, false){
			{
				setReadOnly(true);
			}
		});
		/** column 국적코드 : natnCd */
		listColumnDefs.add(new ColumnDef("국적코드", Insr1100BM.ATTR_NATNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 사회보험대표자여부 : socInsrDegtrYn */
		listColumnDefs.add(new ColumnDef("사회보험대표자여부", Insr1100BM.ATTR_SOCINSRDEGTRYN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 사회보험체류자격코드 : socInsrStyQftntCd */
		listColumnDefs.add(new ColumnDef("사회보험체류자격코드", Insr1100BM.ATTR_SOCINSRSTYQFTNTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
       /** column 호봉등급코드 : pyspGrdeCd */
       listColumnDefs.add(new ColumnDef("호봉등급코드", Insr1100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
           {
           	  setReadOnly(true);
           }
       });
       /** column 호봉등급 : pyspGrdeCd */
       listColumnDefs.add(new ColumnDef("호봉등급", Insr1100BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, false, false, false){
    	   {
               setReadOnly(true);
           }
       });
       
       return listColumnDefs;
   }

    public List<ColumnDef> getInsr210005ToInsr1100(){	

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr1100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				 setReadOnly(true);
			}
		});
        
        /** column [국민]신고 : natPennRegrstYn */
        listColumnDefs.add(new ColumnDef("국민", Insr1100BM.ATTR_NATPENNREGRSTYN, ColumnDef.TYPE_BOOLEAN , 50, true, true, true){
        	{
 				 setReadOnly(true);
 			}
 		});
        /** column [건강]신고 : hlthInsrRegrstYn */
        listColumnDefs.add(new ColumnDef("건강", Insr1100BM.ATTR_HLTHINSRREGRSTYN, ColumnDef.TYPE_BOOLEAN , 50, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column [고용]신고 : umytInsrRegrstYn */
        listColumnDefs.add(new ColumnDef("고용", Insr1100BM.ATTR_UMYTINSRREGRSTYN, ColumnDef.TYPE_BOOLEAN , 50, true, true, true){
     	   {
     		   setReadOnly(true);
     	   }
 	   	});
        /** column [산재]신고 : idtlAccdtRegrstYn */
        listColumnDefs.add(new ColumnDef("산재", Insr1100BM.ATTR_IDTLACCDTREGRSTYN, ColumnDef.TYPE_BOOLEAN , 50, true, true, true){
     	   {
     		   setReadOnly(true);
 		   }
 	   	});
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Insr1100BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, true){
     	   {
     		   setReadOnly(true);
     	   }
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Insr1100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, true){
     	   {
     		   setReadOnly(true);
     	   }
        }); 
        
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Insr1100BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
     	   {
     		   setReadOnly(true);
     	   }
        }); 
        /** column 국적코드 : natnCd */
		listColumnDefs.add(new ColumnDef("국적", Insr1100BM.ATTR_NATNCD, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 사회보험체류자격코드 : socInsrStyQftntCd */
		listColumnDefs.add(new ColumnDef("체류자격", Insr1100BM.ATTR_SOCINSRSTYQFTNTCD, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 사회보험대표자여부 : socInsrDegtrYn */
		listColumnDefs.add(new ColumnDef("대표자여부", Insr1100BM.ATTR_SOCINSRDEGTRYN, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column [국민]소득월액 :  */
		listColumnDefs.add(new ColumnDef("소득월액", Insr1200BM.ATTR_SOCNSRAQTNREGVAL07, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		
		/** column [국민]취득월납부여부 :  */
		listColumnDefs.add(new ColumnDef("취득월납부여부", Insr1200BM.ATTR_SOCNSRAQTNREGVAL08, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [국민]취득부호 :  */
		listColumnDefs.add(new ColumnDef("취득부호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL09, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [국민]자격취득일 :  */
		listColumnDefs.add(new ColumnDef("자격취득일", Insr1200BM.ATTR_SOCNSRAQTNREGVAL10, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [국민]특수직종 :  */
		listColumnDefs.add(new ColumnDef("특수직종", Insr1200BM.ATTR_SOCNSRAQTNREGVAL11, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [국민]직역연금부호 :  */
		listColumnDefs.add(new ColumnDef("직역연금부호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL12, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [건강]단위사업장기호 :  */
		listColumnDefs.add(new ColumnDef("단위사업장기호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL13, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [건강]단위사업장명칭 :  */
		listColumnDefs.add(new ColumnDef("단위사업장명칭", Insr1200BM.ATTR_SOCNSRAQTNREGVAL14, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [건강]보수월액 :  */
		listColumnDefs.add(new ColumnDef("보수월액", Insr1200BM.ATTR_SOCNSRAQTNREGVAL15, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [건강]취득부호 :  */
		listColumnDefs.add(new ColumnDef("취득부호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL16, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [건강]자격취득일 :  */
		listColumnDefs.add(new ColumnDef("자격취득일", Insr1200BM.ATTR_SOCNSRAQTNREGVAL17, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [건강]감면 :  */
		listColumnDefs.add(new ColumnDef("감면", Insr1200BM.ATTR_SOCNSRAQTNREGVAL18, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [건강]사업장발송여부 :  */
		listColumnDefs.add(new ColumnDef("사업장발송여부", Insr1200BM.ATTR_SOCNSRAQTNREGVAL19, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [건강]회계 :  */
		listColumnDefs.add(new ColumnDef("회계", Insr1200BM.ATTR_SOCNSRAQTNREGVAL20, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [건강]직종 :  */
		listColumnDefs.add(new ColumnDef("직종", Insr1200BM.ATTR_SOCNSRAQTNREGVAL21, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		
		/** column [고용]자격취득일 :  */
		listColumnDefs.add(new ColumnDef("자격취득일", Insr1200BM.ATTR_SOCNSRAQTNREGVAL22, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [고용]직종 :  */
		listColumnDefs.add(new ColumnDef("직종", Insr1200BM.ATTR_SOCNSRAQTNREGVAL23, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [고용]주소정근로시간 :  */
		listColumnDefs.add(new ColumnDef("주소정근로시간", Insr1200BM.ATTR_SOCNSRAQTNREGVAL24, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [고용]계약직여부 :  */
		listColumnDefs.add(new ColumnDef("계약직여부", Insr1200BM.ATTR_SOCNSRAQTNREGVAL25, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [고용]계약직종료년월 :  */
		listColumnDefs.add(new ColumnDef("계약직종료년월", Insr1200BM.ATTR_SOCNSRAQTNREGVAL26, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [고용]월평균보수 :  */
		listColumnDefs.add(new ColumnDef("월평균보수", Insr1200BM.ATTR_SOCNSRAQTNREGVAL27, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [고용]비고 :  */
		listColumnDefs.add(new ColumnDef("비고", Insr1200BM.ATTR_SOCNSRAQTNREGVAL28, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [고용]보험료부과구분부호 :  */
		listColumnDefs.add(new ColumnDef("보험료부과구분부호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL29, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [고용]보험료부과구분사유 :  */
		listColumnDefs.add(new ColumnDef("보험료부과구분사유", Insr1200BM.ATTR_SOCNSRAQTNREGVAL30, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		
		/** column [산재]자격취득일 :  */
		listColumnDefs.add(new ColumnDef("자격취득일", Insr1200BM.ATTR_SOCNSRAQTNREGVAL31, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [산재]직종 :  */
		listColumnDefs.add(new ColumnDef("직종", Insr1200BM.ATTR_SOCNSRAQTNREGVAL32, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [산재]주소정근로시간 :  */
		listColumnDefs.add(new ColumnDef("주소정근로시간", Insr1200BM.ATTR_SOCNSRAQTNREGVAL33, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [산재]계약직여부 :  */
		listColumnDefs.add(new ColumnDef("계약직여부", Insr1200BM.ATTR_SOCNSRAQTNREGVAL34, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [산재]계약직종료년월 :  */
		listColumnDefs.add(new ColumnDef("계약직종료년월", Insr1200BM.ATTR_SOCNSRAQTNREGVAL45, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [산재]월평균보수 :  */
		listColumnDefs.add(new ColumnDef("월평균보수", Insr1200BM.ATTR_SOCNSRAQTNREGVAL36, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [산재]비고 :  */
		listColumnDefs.add(new ColumnDef("비고", Insr1200BM.ATTR_SOCNSRAQTNREGVAL37, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [산재]보험료부과구분부호 :  */
		listColumnDefs.add(new ColumnDef("보험료부과구분부호", Insr1200BM.ATTR_SOCNSRAQTNREGVAL38, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column [산재]보험료부과구분사유 :  */
		listColumnDefs.add(new ColumnDef("보험료부과구분사유", Insr1200BM.ATTR_SOCNSRAQTNREGVAL39, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				 setReadOnly(true);
			}
		});
        
        return listColumnDefs;
    }

    
}
