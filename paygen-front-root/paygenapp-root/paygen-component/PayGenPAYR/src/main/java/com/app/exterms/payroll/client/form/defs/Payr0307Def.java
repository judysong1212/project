/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0301BM;
import com.app.exterms.payroll.client.dto.Payr0302BM;
import com.app.exterms.payroll.client.dto.Payr0304BM;
import com.app.exterms.payroll.client.dto.Payr0307BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0307Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    private PrgmComBass0300DTO sysComBass0300Dto ;
    
    public Payr0307Def(){
        
        sysComBass0300Dto = new PrgmComBass0300DTO();
        
        setTitle(PayrLabel.titlePayr0307());
        setDaoClass(CLASS_PAYR0307_DATA_LIST);
        setCustomListMethod(CLASS_PAYR0307TOPAYR4200_DATA_LIST);
        setAutoFillGrid(false);
        setShowFilterToolbar(false);
        setEditFieldGrid(true); 
        setEditableGrid(true);

        setColumnsDefinition(getPayr0307Def());
        
    }   
    
    
    
    public Payr0307Def(String chkPayrDef){
          
          sysComBass0300Dto = new PrgmComBass0300DTO();
          
          setTitle(PayrLabel.titlePayr0307());
          
          if ("PAYRP420001".equals(chkPayrDef)) {  
          	 
          	setDaoClass("");
      	    setCustomListMethod(CLASS_PAYR0307TOP420001_DATA_LIST);
      	    setAutoFillGrid(false);
      	    setShowFilterToolbar(false);  
      	    setCheckBoxOnGridRows(false);
      	    setColumnsDefinition(getPayr0307ToPayrP420001ColumnsList());
          
         }else if("PAYRP420002".equals(chkPayrDef)){
      	   
  	       	setDaoClass("");
  	   	    setCustomListMethod(CLASS_PAYR0307TOP420001_DATA_LIST);
  	   	    setAutoFillGrid(false);
  	   	    setShowFilterToolbar(false);  
  	   	    setCheckBoxOnGridRows(false);
  	   	    setColumnsDefinition(getPayr0307ToPayrP420001ColumnsList());
         }
              
    }
    
        
        public List<ColumnDef> getPayr0307Def(){      
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0307BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
            {
        
            }
        });
        /** column 지급년월 : pymtYrMnth */
        listColumnDefs.add(new ColumnDef("지급년월", Payr0307BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        sysComBass0300Dto.setRpsttvCd("B015");
        /** column 급여구분코드  : payCd */
        listColumnDefs.add(new ColumnListDef("급여구분", Payr0307BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 70, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

        	}
        });
        
        /** column 급여구분 : payNm */
        listColumnDefs.add(new ColumnDef("급여구분", Payr0301BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 70, false, false, false){
        	{

        	}
        });
        
        /** column 시스 템키 : systemkey */
        listColumnDefs.add(new ColumnDef("시스템키", Payr0307BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        sysComBass0300Dto.setRpsttvCd("B008"); 
        /** column 지급공제구분 : pymtDducDivCd */
        listColumnDefs.add(new ColumnListDef("지급공제", Payr0307BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING, 70, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
            {
                setReadOnly(true);
            }
        });
        
        /** column 지급공제구분 : pymtDducDivNm */
        listColumnDefs.add(new ColumnDef("지급공제", Payr0302BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 70, false, false, true){
            {
                setReadOnly(true);
            }
        });
        /** column null : payItemCd */
        listColumnDefs.add(new ColumnDef("급여항목코드", Payr0307BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 70, false, false, true){
        	{
        	    setReadOnly(true);
        	}
        });
        /** column 급여항목 : payItemNm */
        listColumnDefs.add(new ColumnDef("급여항목", Payr0302BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{
              setReadOnly(true);
        	}
        }); 
       
        /** column null : pymtDducFreeDtySum */
        listColumnDefs.add(new ColumnDef("비과세금액", Payr0307BM.ATTR_PYMTDDUCFREEDTYSUM, ColumnDef.TYPE_LONG, 70, false, true, true){
        	{
        		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
        	}
        });
        /** column null : pymtDducSum */
        listColumnDefs.add(new ColumnDef("금액", Payr0307BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG, 70, false, true, true){
        	{
        		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
        	}
        });
        /** column 과세금액 : pymtDducTxtnAmnt */
        listColumnDefs.add(new ColumnDef("과세금액", Payr0307BM.ATTR_PYMTDDUCTXTNAMNT, ColumnDef.TYPE_LONG , 70, true, true, true){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column null : mnthPayAdmntYn */
        listColumnDefs.add(new ColumnDef("제외", Payr0307BM.ATTR_MNTHPAYADMNTYN, ColumnDef.TYPE_BOOLEAN, 40, false, true, true){
            {

            }
        });
        /** column null : mnthPayAdmntAssoBssCtnt */
        listColumnDefs.add(new ColumnDef("조정사유", Payr0307BM.ATTR_MNTHPAYADMNTASSOBSSCTNT, ColumnDef.TYPE_STRING, 140, false, true, true){
        	{

        	}
        }); 
 
        /** column null : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관코드", Payr0307BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 단위기관 : payrMangDept */
        listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : payrSeilNum */
        listColumnDefs.add(new ColumnDef("급여일련번호", Payr0307BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        /** column null : mnthPayAdmntSeilNum */
        listColumnDefs.add(new ColumnDef("급여조정일련번호", Payr0307BM.ATTR_MNTHPAYADMNTSEILNUM, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        
        return listColumnDefs;
        
   }
//private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */

//        private TextField<String> pymtYrMnth   /** column null : pymtYrMnth */
//
//        private TextField<String> payCd   /** column null : payCd */
//
//        private TextField<String> systemkey   /** column null : systemkey */
//
//        private TextField<String> payItemCd   /** column null : payItemCd */
//
//        private TextField<String> pymtDducDivCd   /** column null : pymtDducDivCd */
//
//        private TextField<String> pymtDducFreeDtySum   /** column null : pymtDducFreeDtySum */
//
//        private TextField<String> pymtDducSum   /** column null : pymtDducSum */
//
//        private TextField<String> mnthPayAdmntAssoBssCtnt   /** column null : mnthPayAdmntAssoBssCtnt */
//
//        private TextField<String> mnthPayAdmntYn   /** column null : mnthPayAdmntYn */
//
//        private TextField<String> kybdr   /** column null : kybdr */
//
//        private TextField<String> inptDt   /** column null : inptDt */
//
//        private TextField<String> inptAddr   /** column null : inptAddr */
//
//        private TextField<String> ismt   /** column null : ismt */
//
//        private TextField<String> revnDt   /** column null : revnDt */
//
//        private TextField<String> revnAddr   /** column null : revnAddr */
//
//        private TextField<String> payrMangDeptCd   /** column null : payrMangDeptCd */
//
//        private TextField<String> payrSeilNum   /** column null : payrSeilNum */
//
//        private TextField<String> mnthPayAdmntSeilNum   /** column null : mnthPayAdmntSeilNum */

//        private TextField<String> pymtDducTxtnAmnt;   /** column 과세금액 : pymtDducTxtnAmnt */
        

        
        private List<ColumnDef> getPayr0307ToPayrP420001ColumnsList(){
       	 
               List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
                 

               /** column 사업장코드 : dpobCd */
               listColumnDefs.add(new ColumnDef("사업장코드", Payr0307BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
                   {
               
                   }
               });
               /** column 고용구분코드 : emymtDivCd */
               listColumnDefs.add(new ColumnDef("고용구분코드", Payr0304BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
               	{

               	}
               });
               
               /** column 고용구분 : emymtDivNm */
               listColumnDefs.add(new ColumnDef("고용구분", Payr0304BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
               	{

               	}
               });
               
               /** column 부서코드 : deptCd */
               listColumnDefs.add(new ColumnDef("부서코드", Payr0304BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 120, false, false, true){
               	{

               	}
               });
               
               /** column 부서 : deptNm */
               listColumnDefs.add(new ColumnDef("부서명", Payr0304BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true){
               	{

               	}
               });
               
               /** column 한글성명 : hanNm */
               listColumnDefs.add(new ColumnDef("성명", Payr0304BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, true){
               	{

               	}
               });
               /** column 주민등록번호 : resnRegnNum */
               listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 80, true, true, true){
               	{

               	}
               });
               /** column 주민등록번호 : secRegnNum */
               listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
               	{

               	}
               });
               /** column 사업코드 : businCd */
               listColumnDefs.add(new ColumnDef("사업코드", Payr0304BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, false, false, true){
               	{

               	}
               });
               /** column 직종코드 : typOccuCd */
               listColumnDefs.add(new ColumnDef("직종코드", Payr0304BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, false, false, true){
               	{

               	}
               });
               /** column 호봉등급코드 : pyspGrdeCd */
               listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0304BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, false, false, true){
               	{

               	}
               });
               /** column 직종세구분코드 : dtilOccuClsDivCd */
               listColumnDefs.add(new ColumnDef("직종세구분코드", Payr0304BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
               	{

               	}
               });
               
               /** column 직종세통합코드 : dtilOccuInttnCd */
               listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0304BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
               	{

               	}
               });                                           
                       
              
             
               /** column 직종 : typOccuNm */
               listColumnDefs.add(new ColumnDef("직종", Payr0304BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, false, true){
               	{

               	}
               });
               
               /** column 직종세 : dtilOccuClsDivNm */
               listColumnDefs.add(new ColumnDef("직종세", Payr0304BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
               	{

               	}
               });
               
               /** column 사업 : businNm */
               listColumnDefs.add(new ColumnDef("사업명", Payr0304BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, false, true){
                   {

                   }
               });
             
               /** column 지급년월 : pymtYrMnth */
               listColumnDefs.add(new ColumnDef("지급년월", Payr0307BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, false, true, true){
               	{
                      
               	}
               });
               sysComBass0300Dto.setRpsttvCd("B015");
               /** column 급여구분코드  : payCd */
               listColumnDefs.add(new ColumnListDef("급여구분", Payr0307BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 90, false, false, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
               	{

               	}
               });
               
               /** column 급여구분 : payNm */
               listColumnDefs.add(new ColumnDef("급여구분", Payr0301BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 90, false, true, false){
               	{

               	}
               });
               
               /** column 시스 템키 : systemkey */
               listColumnDefs.add(new ColumnDef("시스템키", Payr0307BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
               	{

               	}
               });
               sysComBass0300Dto.setRpsttvCd("B008"); 
               /** column 지급공제구분 : pymtDducDivCd */
               listColumnDefs.add(new ColumnListDef("지급공제구분", Payr0307BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
                   {
                       setReadOnly(true);
                   }
               });
               
               /** column 지급공제구분 : pymtDducDivNm */
               listColumnDefs.add(new ColumnDef("지급공제구분", Payr0302BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
                   {
                       setReadOnly(true);
                   }
               });
               /** column null : payItemCd */
               listColumnDefs.add(new ColumnDef("급여항목코드", Payr0307BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 90, false, false, true){
               	{
               	    setReadOnly(true);
               	}
               });
               /** column 급여항목 : payItemNm */
               listColumnDefs.add(new ColumnDef("급여항목", Payr0302BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 90, false, true, true){
               	{
                     setReadOnly(true);
               	}
               }); 
              
               /** column null : pymtDducFreeDtySum */
               listColumnDefs.add(new ColumnDef("비과세금액", Payr0307BM.ATTR_PYMTDDUCFREEDTYSUM, ColumnDef.TYPE_LONG, 90, false, true, true){
               	{

               	}
               });
               /** column null : pymtDducSum */
               listColumnDefs.add(new ColumnDef("금액", Payr0307BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG, 90, false, true, true){
               	{

               	}
               });
               /** column 과세금액 : pymtDducTxtnAmnt */
               listColumnDefs.add(new ColumnDef("과세금액", Payr0307BM.ATTR_PYMTDDUCTXTNAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
                   {
                    
                   }
               });
               /** column null : mnthPayAdmntYn */
               listColumnDefs.add(new ColumnDef("소득세", Payr0307BM.ATTR_MNTHPAYADMNTYN, ColumnDef.TYPE_BOOLEAN, 60, false, true, true){
                   {

                   }
               });
               /** column null : mnthPayAdmntAssoBssCtnt */
               listColumnDefs.add(new ColumnDef("조정사유", Payr0307BM.ATTR_MNTHPAYADMNTASSOBSSCTNT, ColumnDef.TYPE_STRING, 140, false, true, true){
               	{

               	}
               });
               
               /** column null : payrMangDeptCd */
               listColumnDefs.add(new ColumnDef("단위기관코드", Payr0307BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, true, false, true){
               	{

               	}
               });
               
               /** column 단위기관 : payrMangDept */
               listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
               	{

               	}
               });
               /** column null : payrSeilNum */
               listColumnDefs.add(new ColumnDef("급여일련번호", Payr0307BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG, 90, true, false, true){
               	{

               	}
               });
               /** column null : mnthPayAdmntSeilNum */
               listColumnDefs.add(new ColumnDef("급여조정일련번호", Payr0307BM.ATTR_MNTHPAYADMNTSEILNUM, ColumnDef.TYPE_LONG, 90, true, false, true){
               	{

               	}
               });
               
             /** column 등록일자 : inptDt */
             listColumnDefs.add(new ColumnDef("등록일자", Payr0307BM.ATTR_INPTDT, ColumnDef.TYPE_DATE, 90, true, true, true){
             	{

             	}
             });
               return listColumnDefs;
           }
        
        private List<ColumnDef> getPayr0307ToPayrP420002ColumnsList(){
       	 
       	 
            List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
            
            /** column 지급년월 : pymtYrMnth */
            listColumnDefs.add(new ColumnDef("지급년월", Payr0304BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, true, false, true){
            	{

            	}
            });
            
            sysComBass0300Dto.setRpsttvCd("B015");
            /** column 급여구분코드  : payCd */
            listColumnDefs.add(new ColumnListDef("급여구분", Payr0307BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 90, false, false, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
            	{

            	}
            });
            
            /** column 급여구분 : payNm */
            listColumnDefs.add(new ColumnDef("급여구분", Payr0301BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 90, false, true, false){
            	{

            	}
            });
            
            sysComBass0300Dto.setRpsttvCd("B008"); 
            /** column 지급공제구분 : pymtDducDivCd */
            listColumnDefs.add(new ColumnListDef("지급공제구분", Payr0307BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
                {
                    setReadOnly(true);
                }
            });
            
            /** column 지급공제구분 : pymtDducDivNm */
            listColumnDefs.add(new ColumnDef("지급공제구분", Payr0302BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
                {
                    setReadOnly(true);
                }
            });
            
            /** column null : payItemCd */
            listColumnDefs.add(new ColumnDef("급여항목코드", Payr0307BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{
            	    setReadOnly(true);
            	}
            });
            /** column 급여항목 : payItemNm */
            listColumnDefs.add(new ColumnDef("급여항목", Payr0302BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 90, false, true, true){
            	{
                  setReadOnly(true);
            	}
            }); 
            
            /** column 한글성명 : hanNm */
            listColumnDefs.add(new ColumnDef("성명", Payr0304BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, true){
            	{

            	}
            });
            
            /** column 주민등록번호 : resnRegnNum */
            listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 80, true, true, true){
            	{

            	}
            });
            
            /** column 주민등록번호 : secRegnNum */
            listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
            	{

            	}
            });
            
            /** column 부서코드 : deptCd */
            listColumnDefs.add(new ColumnDef("부서코드", Payr0304BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 120, false, false, true){
            	{

            	}
            });
            
            /** column 부서 : deptNm */
            listColumnDefs.add(new ColumnDef("부서명", Payr0304BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true){
            	{

            	}
            });
            
            /** column null : pymtDducFreeDtySum */
            listColumnDefs.add(new ColumnDef("비과세금액", Payr0307BM.ATTR_PYMTDDUCFREEDTYSUM, ColumnDef.TYPE_LONG, 90, false, true, true){
            	{

            	}
            });
            /** column null : pymtDducSum */
            listColumnDefs.add(new ColumnDef("금액", Payr0307BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG, 90, false, true, true){
            	{

            	}
            });
            /** column 과세금액 : pymtDducTxtnAmnt */
            listColumnDefs.add(new ColumnDef("과세금액", Payr0307BM.ATTR_PYMTDDUCTXTNAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
                {
                 
                }
            });
            /** column null : mnthPayAdmntYn */
            listColumnDefs.add(new ColumnDef("소득세", Payr0307BM.ATTR_MNTHPAYADMNTYN, ColumnDef.TYPE_BOOLEAN, 60, false, true, true){
                {

                }
            });
            /** column null : mnthPayAdmntAssoBssCtnt */
            listColumnDefs.add(new ColumnDef("조정사유", Payr0307BM.ATTR_MNTHPAYADMNTASSOBSSCTNT, ColumnDef.TYPE_STRING, 140, false, true, true){
            	{

            	}
            });
            
            
            
            
            // --------------------------------------------------


            /** column 고용구분코드 : emymtDivCd */
            listColumnDefs.add(new ColumnDef("고용구분코드", Payr0304BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });
            
            /** column 고용구분 : emymtDivNm */
            listColumnDefs.add(new ColumnDef("고용구분", Payr0304BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });
            

            /** column 사업코드 : businCd */
            listColumnDefs.add(new ColumnDef("사업코드", Payr0304BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });
            /** column 직종코드 : typOccuCd */
            listColumnDefs.add(new ColumnDef("직종코드", Payr0304BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });
            /** column 호봉등급코드 : pyspGrdeCd */
            listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0304BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });
            /** column 직종세구분코드 : dtilOccuClsDivCd */
            listColumnDefs.add(new ColumnDef("직종세구분코드", Payr0304BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });
            
            /** column 직종세통합코드 : dtilOccuInttnCd */
            listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0304BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
            	{

            	}
            });                                           
                    
           
          
            /** column 직종 : typOccuNm */
            listColumnDefs.add(new ColumnDef("직종", Payr0304BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });
            
            /** column 직종세 : dtilOccuClsDivNm */
            listColumnDefs.add(new ColumnDef("직종세", Payr0304BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });
            
            /** column 사업 : businNm */
            listColumnDefs.add(new ColumnDef("사업명", Payr0304BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, false, true){
                {

                }
            });
          

            
            /** column 시스 템키 : systemkey */
            listColumnDefs.add(new ColumnDef("시스템키", Payr0307BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });

            
            /** column 사업장코드 : dpobCd */
            listColumnDefs.add(new ColumnDef("사업장코드", Payr0307BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
                {
            
                }
            });
            
            
            /** column null : payrMangDeptCd */
            listColumnDefs.add(new ColumnDef("단위기관코드", Payr0307BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, true, false, true){
            	{

            	}
            });
            
            /** column 단위기관 : payrMangDept */
            listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
            	{

            	}
            });
            /** column null : payrSeilNum */
            listColumnDefs.add(new ColumnDef("급여일련번호", Payr0307BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG, 90, true, false, true){
            	{

            	}
            });
            /** column null : mnthPayAdmntSeilNum */
            listColumnDefs.add(new ColumnDef("급여조정일련번호", Payr0307BM.ATTR_MNTHPAYADMNTSEILNUM, ColumnDef.TYPE_LONG, 90, true, false, true){
            	{

            	}
            });
            
            return listColumnDefs;
        }      
 
 
}
