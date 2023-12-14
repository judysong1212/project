/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0300BM;
import com.app.exterms.payroll.client.dto.Payr0301BM;
import com.app.exterms.payroll.client.dto.Payr0304BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.google.gwt.i18n.client.NumberFormat;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0301Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;
 
    public Payr0301Def(){
        this("");
    }
    
    public Payr0301Def(String chkPayrDef){
    	 setTitle(PayrLabel.titlePayr0301()); 
        
        if ("".equals(chkPayrDef)) { 
        	
             setDaoClass(CLASS_PAYR0301_DATA_LIST);
             setCustomListMethod(CLASS_PAYR0301_DATA_LIST);
             setAutoFillGrid(false);
             setShowFilterToolbar(false);
            // setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
             setCheckBoxOnGridRows(true); 

             setColumnsDefinition(getAllColumnsList());
             
        } else if ("PAYR4550".equals(chkPayrDef)) {  
        	
        	 setDaoClass(CLASS_PAYR4550_DAO_LIST);
             setCustomListMethod(CLASS_PAYR4550_DAO_LIST);
             setAutoFillGrid(false);
             setShowFilterToolbar(false);
            // setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
             setCheckBoxOnGridRows(true); 
             setColumnsDefinition(getPayr4550ColumnsList());
     
       } else if ("PAYR4400".equals(chkPayrDef)) {  
    	
      	setDaoClass(CLASS_PAYR4400_DAO_LIST);
        setCustomListMethod(CLASS_PAYR4400_DAO_LIST);
        setAutoFillGrid(true);
        setShowFilterToolbar(false);
       // setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
        setCheckBoxOnGridRows(true); 

        setColumnsDefinition(getPayr4400ColumnsList());
        
       } else if ("PAYR4150".equals(chkPayrDef)) {  
       	
         	setDaoClass("");
           setCustomListMethod(CLASS_PAYR0301TOPAYR4150_DATA_LIST);
           setAutoFillGrid(true);
           setShowFilterToolbar(false);
          // setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
           setCheckBoxOnGridRows(true); 
           setCellModel(true);

           setColumnsDefinition(getPayr0301ToPayr4150ColumnsList());
           
       } else if ("PAYR4250".equals(chkPayrDef)) {  
          	
        	setDaoClass("");
          setCustomListMethod(CLASS_PAYR0301TOPAYR4250_DATA_LIST);
          setAutoFillGrid(false);
          setShowFilterToolbar(false);
         // setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
          setCheckBoxOnGridRows(true); 

          setColumnsDefinition(getPayr0301ToPayr4250ColumnsList());
          
      }   
    }
 
     
  private List<ColumnDef> getAllColumnsList(){
      row = 0;
      List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
      /** column 사업장코드 : dpobCd */
      listColumnDefs.add(new ColumnDef("사업장코드", Payr0300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
          {

          }
      });
      /** column 지급년월 : pymtYrMnth */
      listColumnDefs.add(new ColumnDef("지급년월", Payr0301BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, true, true, true){
      	{
            
      	}
      });
      /** column SYSTEMKEY : systemkey */
      listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0301BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{

      	}
      });
      
      /** column 급여구분코드 : payCd */
      listColumnDefs.add(new ColumnDef("급여구분코드", Payr0301BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{

      	}
      });

      /** column 급여구분 : payNm */
      listColumnDefs.add(new ColumnDef("급여구분", Payr0301BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 90, true, true, true){
      	{

      	}
      });

       
      /** column 고용구분코드 : emymtDivCd */
      listColumnDefs.add(new ColumnDef("고용구분코드", Payr0304BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{

      	}
      });
      
      /** column 고용구분 : emymtDivNm */
      listColumnDefs.add(new ColumnDef("고용구분", Payr0304BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
      	{

      	}
      });
      
      /** column 한글성명 : hanNm */
      listColumnDefs.add(new ColumnDef("한글성명", Payr0304BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 90, true, true, true){
      	{

      	}
      });
      /** column 주민등록번호 : resnRegnNum */
      listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, true){
      	{

      	}
      });
      /** column 주민등록번호 : secRegnNum */
      listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
      	{

      	}
      });
      /** column 부서코드 : deptCd */
      listColumnDefs.add(new ColumnDef("부서코드", Payr0304BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{

      	}
      });
      /** column 사업코드 : businCd */
      listColumnDefs.add(new ColumnDef("사업코드", Payr0304BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{

      	}
      });
      /** column 직종코드 : typOccuCd */
      listColumnDefs.add(new ColumnDef("직종코드", Payr0304BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{

      	}
      });
      /** column 직종세구분코드 : dtilOccuClsDivCd */
      listColumnDefs.add(new ColumnDef("직종세구분코드", Payr0304BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{

      	}
      });
      
      
      
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0304BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		{
		
		}
		});                                           


      /** column 부서 : deptNm */
      listColumnDefs.add(new ColumnDef("부서명", Payr0304BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true){
      	{

      	}
      });
      /** column 사업 : businNm */
      listColumnDefs.add(new ColumnDef("사업명", Payr0304BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, true, true, true){
      	{

      	}
      });
      /** column 직종 : typOccuNm */
      listColumnDefs.add(new ColumnDef("직종", Payr0304BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, true, true, true){
      	{

      	}
      });
      /** column 직종세 : dtilOccuClsDivNm */
      listColumnDefs.add(new ColumnDef("직종세", Payr0304BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{

      	}
      });
      
       
      /** column 단위기관 : payrMangDeptCd */
      listColumnDefs.add(new ColumnDef("단위기관코드", Payr0301BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{

      	}
      });
      
      /** column 단위기관 : payrMangDept */
      listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{

      	}
      });
      
      /** column 급여일련번호 : payrSeilNum */
      listColumnDefs.add(new ColumnDef("급여일련번호", Payr0301BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
      	{

      	}
      });
      /** column 지급총액 : pymtTotAmnt */
      listColumnDefs.add(new ColumnDef("지급금액", Payr0301BM.ATTR_PYMTTOTAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
      	{
      		 //setFormatNumeric(NumberFormat.getFormat("$#,##0.00")); 
      		 //this.setFormatNumeric("########");
      		//setFormatNumeric(NumberFormat.getCurrencyFormat("EUR"));
      	}
      });
      /** column 수당총액 : extpyTotAmnt */
      listColumnDefs.add(new ColumnDef("수당금액", Payr0301BM.ATTR_EXTPYTOTAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
      	{

      	}
      });
      /** column 과세총액 : txtnTotAmnt */
      listColumnDefs.add(new ColumnDef("과세금액", Payr0301BM.ATTR_TXTNTOTAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
      	{

      	}
      });
      /** column 비과세총액 : freeDtyTotAmnt */
      listColumnDefs.add(new ColumnDef("비과세금액", Payr0301BM.ATTR_FREEDTYTOTAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
      	{

      	}
      });
      /** column 공제총액 : dducTotAmnt */
      listColumnDefs.add(new ColumnDef("공제금액", Payr0301BM.ATTR_DDUCTOTAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
      	{

      	}
      });
      /** column 세금총액 : txTotAmnt */
      listColumnDefs.add(new ColumnDef("세금", Payr0301BM.ATTR_TXTOTAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
      	{

      	}
      });
      /** column 퇴직금지급여부 : sevePayPymtYn */
      listColumnDefs.add(new ColumnDef("퇴직금", Payr0301BM.ATTR_SEVEPAYPYMTYN, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
      	{

      	}
      });
      /** column 실지급액 : pernPymtSum */
      listColumnDefs.add(new ColumnDef("실지급액", Payr0301BM.ATTR_PERNPYMTSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
      	{

      	}
      });
      /** column 소득세징수비율 : incmTxCllnRto */
      listColumnDefs.add(new ColumnDef("소득세징수비율", Payr0301BM.ATTR_INCMTXCLLNRTO, ColumnDef.TYPE_DOUBLE , 90, true, false, true){
      	{

      	}
      });
      /** column 은행코드 : bnkCd */
      listColumnDefs.add(new ColumnDef("은행코드", Payr0301BM.ATTR_BNKCD, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{

      	}
      });
      /** column 은행계좌번호 : bnkAccuNum */
      listColumnDefs.add(new ColumnDef("은행계좌번호", Payr0301BM.ATTR_BNKACCUNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{

      	}
      });
      /** column 예금주명 : acntHodrNm */
      listColumnDefs.add(new ColumnDef("예금주명", Payr0301BM.ATTR_ACNTHODRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{

      	}
      });
      /** column 급여마감일자 : payDdlneDt */
      listColumnDefs.add(new ColumnDef("급여마감일자", Payr0301BM.ATTR_PAYDDLNEDT, ColumnDef.TYPE_DATE , 90, true, false, true){
      	{

      	}
      });
      /** column 급여마감여부 : payDdlneYn */
      listColumnDefs.add(new ColumnDef("마감여부", Payr0301BM.ATTR_PAYDDLNEYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
      	{

      	}
      });
       
      
//      /** column 입력자 : kybdr */
//      listColumnDefs.add(new ColumnDef("입력자", Payr0301BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//      	{
//
//      	}
//      });
//      /** column 입력일자 : inptDt */
//      listColumnDefs.add(new ColumnDef("입력일자", Payr0301BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//      	{
//
//      	}
//      });
//      /** column 입력주소 : inptAddr */
//      listColumnDefs.add(new ColumnDef("입력주소", Payr0301BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//      	{
//
//      	}
//      });
//      /** column 수정자 : ismt */
//      listColumnDefs.add(new ColumnDef("수정자", Payr0301BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//      	{
//
//      	}
//      });
//      /** column 수정일자 : revnDt */
//      listColumnDefs.add(new ColumnDef("수정일자", Payr0301BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//      	{
//
//      	}
//      });
//      /** column 수정주소 : revnAddr */
//      listColumnDefs.add(new ColumnDef("수정주소", Payr0301BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//      	{
//
//      	}
//      });

//      private TextField<String> pymtYrMnth   /** column 지급년월 : pymtYrMnth */
//
//      private TextField<String> systemkey   /** column SYSTEMKEY : systemkey */
//
//      private TextField<String> payCd   /** column 급여구분코드 : payCd */
//
//      private TextField<String> payrMangDeptCd   /** column 단위기관코드 : payrMangDeptCd */
//
//      private TextField<String> payrSeilNum   /** column 급여일련번호 : payrSeilNum */
//
//      private TextField<String> pymtTotAmnt   /** column 지급총액 : pymtTotAmnt */
//
//      private TextField<String> extpyTotAmnt   /** column 수당총액 : extpyTotAmnt */
//
//      private TextField<String> txtnTotAmnt   /** column 과세총액 : txtnTotAmnt */
//
//      private TextField<String> freeDtyTotAmnt   /** column 비과세총액 : freeDtyTotAmnt */
//
//      private TextField<String> dducTotAmnt   /** column 공제총액 : dducTotAmnt */
//
//      private TextField<String> txTotAmnt   /** column 세금총액 : txTotAmnt */
//
//      private TextField<String> sevePayPymtYn   /** column 퇴직금지급여부 : sevePayPymtYn */
//
//      private TextField<String> pernPymtSum   /** column 차인지급액 : pernPymtSum */
//
//      private TextField<String> incmTxCllnRto   /** column 소득세징수비율 : incmTxCllnRto */
//
//      private TextField<String> bnkCd   /** column 은행코드 : bnkCd */
//
//      private TextField<String> bnkAccuNum   /** column 은행계좌번호 : bnkAccuNum */
//
//      private TextField<String> acntHodrNm   /** column 예금주명 : acntHodrNm */
//
//      private TextField<String> payDdlneDt   /** column 급여마감일자 : payDdlneDt */
//
//      private TextField<String> payDdlneYn   /** column 급여마감여부 : payDdlneYn */
//
//      private TextField<String> kybdr   /** column 입력자 : kybdr */
//
//      private TextField<String> inptDt   /** column 입력일자 : inptDt */
//
//      private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
//
//      private TextField<String> ismt   /** column 수정자 : ismt */
//
//      private TextField<String> revnDt   /** column 수정일자 : revnDt */
//
//      private TextField<String> revnAddr   /** column 수정주소 : revnAddr */
      
      return listColumnDefs;
  }
  
  
private List<ColumnDef> getPayr4550ColumnsList(){
    row = 0;
    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
    /** column 사업장코드 : dpobCd */
    listColumnDefs.add(new ColumnDef("사업장코드", Payr0300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        {

        }
    });
    /** column 지급년월 : pymtYrMnth */
    listColumnDefs.add(new ColumnDef("년도", Payr0301BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, false, true, true){
    	{
          
    	}
    });
    /** column SYSTEMKEY : systemkey */
    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0301BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
//    
//    /** column 급여구분코드 : payCd */
//    listColumnDefs.add(new ColumnDef("급여구분코드", Payr0301BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//    	{
//
//    	}
//    });
//
//    /** column 급여구분 : payNm */
//    listColumnDefs.add(new ColumnDef("급여구분코드", Payr0301BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 90, true, true, true){
//    	{
//
//    	}
//    });

     
    /** column 고용구분코드 : emymtDivCd */
    listColumnDefs.add(new ColumnDef("고용구분코드", Payr0304BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 100, false, false, true){
    	{

    	}
    });
    
    /** column 고용구분 : emymtDivNm */
    listColumnDefs.add(new ColumnDef("고용구분", Payr0304BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 100, false, true, true){
    	{

    	}
    });
    
    /** column 한글성명 : hanNm */
    listColumnDefs.add(new ColumnDef("한글성명", Payr0304BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 90, false, true, true){
    	{

    	}
    });
    /** column 주민등록번호 : resnRegnNum */
    listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, false, true, true){
    	{

    	}
    });
    /** column 주민등록번호 : secRegnNum */
    listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
    	{

    	}
    });
    /** column 부서코드 : deptCd */
    listColumnDefs.add(new ColumnDef("부서코드", Payr0304BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 150, false, false, true){
    	{

    	}
    });
    /** column 사업코드 : businCd */
    listColumnDefs.add(new ColumnDef("사업코드", Payr0304BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 150, false, false, true){
    	{

    	}
    });
    /** column 직종코드 : typOccuCd */
    listColumnDefs.add(new ColumnDef("직종코드", Payr0304BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    /** column 직종세구분코드 : dtilOccuClsDivCd */
    listColumnDefs.add(new ColumnDef("직종세구분코드", Payr0304BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    
    /** column 직종세통합코드 : dtilOccuInttnCd */
    listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0304BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });  
    
    /** column 부서 : deptNm */
    listColumnDefs.add(new ColumnDef("부서명", Payr0304BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 150, false, true, true){
    	{

    	}
    });
    /** column 직종 : typOccuNm */
    listColumnDefs.add(new ColumnDef("직종", Payr0304BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 100, false, true, true){
        {

        }
    });
   
    /** column 직종세 : dtilOccuClsDivNm */
    listColumnDefs.add(new ColumnDef("직종세", Payr0304BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    /** column 사업 : businNm */
    listColumnDefs.add(new ColumnDef("사업명", Payr0304BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 150, false, true, true){
        {

        }
    });
    
	/** column 고용시작일자 : emymtBgnnDt */
	listColumnDefs.add(new ColumnDef("시작일자", Payr0301BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_DATE , 90, false, true, false){
		{

		}
	});
	
	/** column 고용종료일자 : emymtEndDt */
	listColumnDefs.add(new ColumnDef("종료일자", Payr0301BM.ATTR_EMYMTENDDT, ColumnDef.TYPE_DATE , 90, false, true, false){
		{

		}
	});
    
     
    /** column 단위기관 : payrMangDeptCd */
    listColumnDefs.add(new ColumnDef("단위기관코드", Payr0301BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    
    /** column 단위기관 : payrMangDept */
    listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    
//    /** column 급여일련번호 : payrSeilNum */
//    listColumnDefs.add(new ColumnDef("급여일련번호", Payr0301BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 지급총액 : pymtTotAmnt */
//    listColumnDefs.add(new ColumnDef("지급금액", Payr0301BM.ATTR_PYMTTOTAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
//    	{
//    		 setFormatNumeric(NumberFormat.getFormat("$#,##0.00")); 
//    		 //this.setFormatNumeric("########");
//    		//setFormatNumeric(NumberFormat.getCurrencyFormat("EUR"));
//    	}
//    });
//    /** column 수당총액 : extpyTotAmnt */
//    listColumnDefs.add(new ColumnDef("수당금액", Payr0301BM.ATTR_EXTPYTOTAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
//    	{
//
//    	}
//    });
//    /** column 과세총액 : txtnTotAmnt */
//    listColumnDefs.add(new ColumnDef("과세금액", Payr0301BM.ATTR_TXTNTOTAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
//    	{
//
//    	}
//    });
  
//    /** column 공제총액 : dducTotAmnt */
//    listColumnDefs.add(new ColumnDef("공제금액", Payr0301BM.ATTR_DDUCTOTAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
//    	{
//
//    	}
//    });
    

     
    /** column 총지급금액 : pernPymtSum */
    listColumnDefs.add(new ColumnDef("총실지급액", Payr0301BM.ATTR_PERNPYMTSUM, ColumnDef.TYPE_LONG , 90, false, true, true){
    	{

    	}
    });
    
    /** column 비과세금액 : freeDtyTotAmnt */
    listColumnDefs.add(new ColumnDef("비과세금액", Payr0301BM.ATTR_FREEDTYTOTAMNT, ColumnDef.TYPE_LONG , 90, false, true, true){
    	{

    	}
    });
    
	 /** column 지급총액 : pymtTotAmnt */
	 listColumnDefs.add(new ColumnDef("총급여액", Payr0301BM.ATTR_PYMTTOTAMNT, ColumnDef.TYPE_LONG , 90, false, true, true){
	 	{
	  	
	 	}
	});
	  
    /** set 건강보험료금액 : hlthInsrTotAmnt */
    listColumnDefs.add(new ColumnDef("건강보험", Payr0301BM.ATTR_HLTHINSRTOTAMNT, ColumnDef.TYPE_LONG , 90, false, true, true){
    	{

    	}
    });
    
    /** set 노인장기요양보험료금액 : rcptnINsrTotAmnt */
    listColumnDefs.add(new ColumnDef("노인장기요양보험", Payr0301BM.ATTR_RCPTNINSRTOTAMNT, ColumnDef.TYPE_LONG , 100, false, true, true){
    	{

    	}
    });
    
    /** set 고용보험 : umytInsrTotAmnt */
    listColumnDefs.add(new ColumnDef("고용보험", Payr0301BM.ATTR_UMYTINSRTOTAMNT, ColumnDef.TYPE_LONG , 90, false, true, true){
    	{

    	}
    });
    
    /** set 국민연금 : natInsrTotAmnt */
    listColumnDefs.add(new ColumnDef("국민연금", Payr0301BM.ATTR_NATINSRTOTAMNT, ColumnDef.TYPE_LONG , 100, false, true, true){
    	{

    	}
    });
    
    
    
    /** column 소득세 : txTotAmnt */
    listColumnDefs.add(new ColumnDef("소득세", Payr0301BM.ATTR_TXTOTAMNT, ColumnDef.TYPE_LONG , 90, false, true, true){
    	{

    	}
    });
    /** column 지방소득세 : txTotAmnt */
    listColumnDefs.add(new ColumnDef("지방소득세", Payr0301BM.ATTR_LCTXTOTAMNT, ColumnDef.TYPE_LONG , 90, false, true, true){
    	{

    	}
    });
    
//    /** column 퇴직금지급여부 : sevePayPymtYn */
//    listColumnDefs.add(new ColumnDef("퇴직금지급여부", Payr0301BM.ATTR_SEVEPAYPYMTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
//    	{
//
//    	}
//    });
 
//    /** column 소득세징수비율 : incmTxCllnRto */
//    listColumnDefs.add(new ColumnDef("소득세징수비율", Payr0301BM.ATTR_INCMTXCLLNRTO, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 은행코드 : bnkCd */
//    listColumnDefs.add(new ColumnDef("은행코드", Payr0301BM.ATTR_BNKCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 은행계좌번호 : bnkAccuNum */
//    listColumnDefs.add(new ColumnDef("은행계좌번호", Payr0301BM.ATTR_BNKACCUNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 예금주명 : acntHodrNm */
//    listColumnDefs.add(new ColumnDef("예금주명", Payr0301BM.ATTR_ACNTHODRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 급여마감일자 : payDdlneDt */
//    listColumnDefs.add(new ColumnDef("급여마감일자", Payr0301BM.ATTR_PAYDDLNEDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 급여마감여부 : payDdlneYn */
//    listColumnDefs.add(new ColumnDef("마감여부", Payr0301BM.ATTR_PAYDDLNEYN, ColumnDef.TYPE_STRING , 90, true, true, true){
//    	{
//
//    	}
//    });
     
    
//    /** column 입력자 : kybdr */
//    listColumnDefs.add(new ColumnDef("입력자", Payr0301BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 입력일자 : inptDt */
//    listColumnDefs.add(new ColumnDef("입력일자", Payr0301BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 입력주소 : inptAddr */
//    listColumnDefs.add(new ColumnDef("입력주소", Payr0301BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 수정자 : ismt */
//    listColumnDefs.add(new ColumnDef("수정자", Payr0301BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 수정일자 : revnDt */
//    listColumnDefs.add(new ColumnDef("수정일자", Payr0301BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 수정주소 : revnAddr */
//    listColumnDefs.add(new ColumnDef("수정주소", Payr0301BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });

//    private TextField<String> pymtYrMnth   /** column 지급년월 : pymtYrMnth */
//
//    private TextField<String> systemkey   /** column SYSTEMKEY : systemkey */
//
//    private TextField<String> payCd   /** column 급여구분코드 : payCd */
//
//    private TextField<String> payrMangDeptCd   /** column 단위기관코드 : payrMangDeptCd */
//
//    private TextField<String> payrSeilNum   /** column 급여일련번호 : payrSeilNum */
//
//    private TextField<String> pymtTotAmnt   /** column 지급총액 : pymtTotAmnt */
//
//    private TextField<String> extpyTotAmnt   /** column 수당총액 : extpyTotAmnt */
//
//    private TextField<String> txtnTotAmnt   /** column 과세총액 : txtnTotAmnt */
//
//    private TextField<String> freeDtyTotAmnt   /** column 비과세총액 : freeDtyTotAmnt */
//
//    private TextField<String> dducTotAmnt   /** column 공제총액 : dducTotAmnt */
//
//    private TextField<String> txTotAmnt   /** column 세금총액 : txTotAmnt */
//
//    private TextField<String> sevePayPymtYn   /** column 퇴직금지급여부 : sevePayPymtYn */
//
//    private TextField<String> pernPymtSum   /** column 차인지급액 : pernPymtSum */
//
//    private TextField<String> incmTxCllnRto   /** column 소득세징수비율 : incmTxCllnRto */
//
//    private TextField<String> bnkCd   /** column 은행코드 : bnkCd */
//
//    private TextField<String> bnkAccuNum   /** column 은행계좌번호 : bnkAccuNum */
//
//    private TextField<String> acntHodrNm   /** column 예금주명 : acntHodrNm */
//
//    private TextField<String> payDdlneDt   /** column 급여마감일자 : payDdlneDt */
//
//    private TextField<String> payDdlneYn   /** column 급여마감여부 : payDdlneYn */
//
//    private TextField<String> kybdr   /** column 입력자 : kybdr */
//
//    private TextField<String> inptDt   /** column 입력일자 : inptDt */
//
//    private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
//
//    private TextField<String> ismt   /** column 수정자 : ismt */
//
//    private TextField<String> revnDt   /** column 수정일자 : revnDt */
//
//    private TextField<String> revnAddr   /** column 수정주소 : revnAddr */
    
    return listColumnDefs;
}


private List<ColumnDef> getPayr4400ColumnsList(){
    row = 0;
    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
    /** column 사업장코드 : dpobCd */
    listColumnDefs.add(new ColumnDef("사업장코드", Payr0301BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        {

        }
    });
    /** column 지급년월 : pymtYrMnth */
    listColumnDefs.add(new ColumnDef("지급년월", Payr0301BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, true, true, true){
    	{
          
    	}
    });
    /** column SYSTEMKEY : systemkey */
    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0301BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    
    /** column 급여구분코드 : payCd */
    listColumnDefs.add(new ColumnDef("급여구분코드", Payr0301BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });

    /** column 급여구분 : payNm */
    listColumnDefs.add(new ColumnDef("급여구분", Payr0301BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 90, true, true, true){
    	{

    	}
    });

     
    /** column 고용구분코드 : emymtDivCd */
    listColumnDefs.add(new ColumnDef("고용구분코드", Payr0301BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    
    /** column 고용구분 : emymtDivNm */
    listColumnDefs.add(new ColumnDef("고용구분", Payr0301BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
    	{

    	}
    });
    
    /** column 한글성명 : hanNm */
    listColumnDefs.add(new ColumnDef("한글성명", Payr0301BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 90, true, true, true){
    	{

    	}
    });
    /** column 주민등록번호 : resnRegnNum */
    listColumnDefs.add(new ColumnDef("주민등록번호", Payr0301BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, true){
    	{

    	}
    });
    /** column 주민등록번호 : secRegnNum */
    listColumnDefs.add(new ColumnDef("주민등록번호", Payr0301BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
    	{

    	}
    });
    /** column 부서코드 : deptCd */
    listColumnDefs.add(new ColumnDef("부서코드", Payr0301BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    /** column 사업코드 : businCd */
    listColumnDefs.add(new ColumnDef("사업코드", Payr0301BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    /** column 직종코드 : typOccuCd */
    listColumnDefs.add(new ColumnDef("직종코드", Payr0301BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    /** column 직종세구분코드 : dtilOccuClsDivCd */
    listColumnDefs.add(new ColumnDef("직종세구분코드", Payr0301BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    
    /** column 직종세통합코드 : dtilOccuInttnCd */
    listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0301BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });   
    
    /** column 부서 : deptNm */
    listColumnDefs.add(new ColumnDef("부서명", Payr0301BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true){
    	{

    	}
    });
    /** column 사업 : businNm */
    listColumnDefs.add(new ColumnDef("사업명", Payr0301BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    /** column 직종 : typOccuNm */
    listColumnDefs.add(new ColumnDef("직종", Payr0301BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    /** column 직종세 : dtilOccuClsDivNm */
    listColumnDefs.add(new ColumnDef("직종세", Payr0301BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    
     
    /** column 단위기관 : payrMangDeptCd */
    listColumnDefs.add(new ColumnDef("단위기관코드", Payr0301BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    
    /** column 단위기관 : payrMangDept */
    listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    
    /** column 급여일련번호 : payrSeilNum */
    listColumnDefs.add(new ColumnDef("급여일련번호", Payr0301BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
    	{

    	}
    });
    /** column 지급총액 : pymtTotAmnt */
    listColumnDefs.add(new ColumnDef("지급금액", Payr0301BM.ATTR_PYMTTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
    	{
    		 setFormatNumeric(NumberFormat.getFormat("$#,##0.00")); 
    		 //this.setFormatNumeric("########");
    		//setFormatNumeric(NumberFormat.getCurrencyFormat("EUR"));
    	}
    });
    /** column 수당총액 : extpyTotAmnt */
    listColumnDefs.add(new ColumnDef("수당금액", Payr0301BM.ATTR_EXTPYTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
    	{

    	}
    });
    /** column 과세총액 : txtnTotAmnt */
    listColumnDefs.add(new ColumnDef("과세금액", Payr0301BM.ATTR_TXTNTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
    	{

    	}
    });
    /** column 비과세총액 : freeDtyTotAmnt */
    listColumnDefs.add(new ColumnDef("비과세금액", Payr0301BM.ATTR_FREEDTYTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
    	{

    	}
    });
    /** column 공제총액 : dducTotAmnt */
    listColumnDefs.add(new ColumnDef("공제금액", Payr0301BM.ATTR_DDUCTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
    	{

    	}
    });
    /** column 세금총액 : txTotAmnt */
    listColumnDefs.add(new ColumnDef("세금", Payr0301BM.ATTR_TXTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
    	{

    	}
    });
    /** column 퇴직금지급여부 : sevePayPymtYn */
    listColumnDefs.add(new ColumnDef("퇴직금지급", Payr0301BM.ATTR_SEVEPAYPYMTYN, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
    	{

    	}
    });
    /** column 실지급액 : pernPymtSum */
    listColumnDefs.add(new ColumnDef("지급금액", Payr0301BM.ATTR_PERNPYMTSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
    	{

    	}
    });
    /** column 소득세징수비율 : incmTxCllnRto */
    listColumnDefs.add(new ColumnDef("소득세징수비율", Payr0301BM.ATTR_INCMTXCLLNRTO, ColumnDef.TYPE_DOUBLE , 90, true, false, true){
    	{

    	}
    });
    /** column 은행코드 : bnkCd */
    listColumnDefs.add(new ColumnDef("은행코드", Payr0301BM.ATTR_BNKCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 은행 : bnkNm */
    listColumnDefs.add(new ColumnDef("은행", Payr0301BM.ATTR_BNKNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        {

        }
    });
    /** column 은행계좌번호 : bnkAccuNum */
    listColumnDefs.add(new ColumnDef("은행계좌번호", Payr0301BM.ATTR_BNKACCUNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
    	{

    	}
    });
    /** column 예금주명 : acntHodrNm */
    listColumnDefs.add(new ColumnDef("예금주명", Payr0301BM.ATTR_ACNTHODRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
    	{

    	}
    });
    /** column 급여마감일자 : payDdlneDt */
    listColumnDefs.add(new ColumnDef("급여마감일자", Payr0301BM.ATTR_PAYDDLNEDT, ColumnDef.TYPE_DATE , 90, true, false, true){
    	{

    	}
    });
    /** column 급여마감여부 : payDdlneYn */
    listColumnDefs.add(new ColumnDef("마감여부", Payr0301BM.ATTR_PAYDDLNEYN, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
    	{

    	}
    });
     
    
//    /** column 입력자 : kybdr */
//    listColumnDefs.add(new ColumnDef("입력자", Payr0301BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 입력일자 : inptDt */
//    listColumnDefs.add(new ColumnDef("입력일자", Payr0301BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 입력주소 : inptAddr */
//    listColumnDefs.add(new ColumnDef("입력주소", Payr0301BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 수정자 : ismt */
//    listColumnDefs.add(new ColumnDef("수정자", Payr0301BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 수정일자 : revnDt */
//    listColumnDefs.add(new ColumnDef("수정일자", Payr0301BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 수정주소 : revnAddr */
//    listColumnDefs.add(new ColumnDef("수정주소", Payr0301BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
 
    
    return listColumnDefs;
}


private List<ColumnDef> getPayr0301ToPayr4150ColumnsList(){
    row = 0;
    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
    /** column 사업장코드 : dpobCd */
    listColumnDefs.add(new ColumnDef("사업장코드", Payr0300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        {

        }
    });
    /** column 지급년월 : pymtYrMnth */
    listColumnDefs.add(new ColumnDef("지급년월", Payr0301BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, true, true, true){
    	{
         
    	}
    });
    /** column SYSTEMKEY : systemkey */
    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0301BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    
    /** column 급여구분코드 : payCd */
    listColumnDefs.add(new ColumnDef("급여구분코드", Payr0301BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });

    /** column 급여구분 : payNm */
    listColumnDefs.add(new ColumnDef("급여구분", Payr0301BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 90, true, true, true){
    	{

    	}
    });

     
    /** column 고용구분코드 : emymtDivCd */
    listColumnDefs.add(new ColumnDef("고용구분코드", Payr0304BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    
    /** column 고용구분 : emymtDivNm */
    listColumnDefs.add(new ColumnDef("고용구분", Payr0304BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
    	{

    	}
    });
    
    /** column 한글성명 : hanNm */
    listColumnDefs.add(new ColumnDef("한글성명", Payr0304BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 90, true, true, true){
    	{

    	}
    });
    /** column 주민등록번호 : resnRegnNum */
    listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, true){
    	{

    	}
    });
    /** column 주민등록번호 : secRegnNum */
    listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
    	{

    	}
    });
    /** column 부서코드 : deptCd */
    listColumnDefs.add(new ColumnDef("부서코드", Payr0304BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    /** column 사업코드 : businCd */
    listColumnDefs.add(new ColumnDef("사업코드", Payr0304BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    /** column 직종코드 : typOccuCd */
    listColumnDefs.add(new ColumnDef("직종코드", Payr0304BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    /** column 직종세구분코드 : dtilOccuClsDivCd */
    listColumnDefs.add(new ColumnDef("직종세구분코드", Payr0304BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    
	    
	/** column 직종세통합코드 : dtilOccuInttnCd */
	listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0304BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{
	
	}
	});             

    /** column 부서 : deptNm */
    listColumnDefs.add(new ColumnDef("부서명", Payr0304BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true){
    	{

    	}
    });
    /** column 사업 : businNm */
    listColumnDefs.add(new ColumnDef("사업명", Payr0304BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    /** column 직종 : typOccuNm */
    listColumnDefs.add(new ColumnDef("직종", Payr0304BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    /** column 직종세 : dtilOccuClsDivNm */
    listColumnDefs.add(new ColumnDef("직종세", Payr0304BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, true, false, true){
    	{

    	}
    });
    
     
    /** column 단위기관 : payrMangDeptCd */
    listColumnDefs.add(new ColumnDef("단위기관코드", Payr0301BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    
    /** column 단위기관 : payrMangDept */
    listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    
    /** column 급여일련번호 : payrSeilNum */
    listColumnDefs.add(new ColumnDef("급여일련번호", Payr0301BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
    	{

    	}
    });
    /** column 지급총액 : pymtTotAmnt */
    listColumnDefs.add(new ColumnDef("지급금액", Payr0301BM.ATTR_PYMTTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
    	{
    		 setFormatNumeric(NumberFormat.getFormat("$#,##0.00")); 
    		 //this.setFormatNumeric("########");
    		//setFormatNumeric(NumberFormat.getCurrencyFormat("EUR"));
    	}
    });
    /** column 수당총액 : extpyTotAmnt */
    listColumnDefs.add(new ColumnDef("수당금액", Payr0301BM.ATTR_EXTPYTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
    	{

    	}
    });
    /** column 과세총액 : txtnTotAmnt */
    listColumnDefs.add(new ColumnDef("과세금액", Payr0301BM.ATTR_TXTNTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
    	{

    	}
    });
    /** column 비과세총액 : freeDtyTotAmnt */
    listColumnDefs.add(new ColumnDef("비과세금액", Payr0301BM.ATTR_FREEDTYTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
    	{

    	}
    });
    /** column 공제총액 : dducTotAmnt */
    listColumnDefs.add(new ColumnDef("공제금액", Payr0301BM.ATTR_DDUCTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
    	{

    	}
    });
    /** column 세금총액 : txTotAmnt */
    listColumnDefs.add(new ColumnDef("세금", Payr0301BM.ATTR_TXTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
    	{

    	}
    });
    /** column 퇴직금지급여부 : sevePayPymtYn */
    listColumnDefs.add(new ColumnDef("퇴직금지급", Payr0301BM.ATTR_SEVEPAYPYMTYN, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
    	{

    	}
    });
    /** column 실지급액 : pernPymtSum */
    listColumnDefs.add(new ColumnDef("지급금액", Payr0301BM.ATTR_PERNPYMTSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
    	{

    	}
    });
    /** column 소득세징수비율 : incmTxCllnRto */
    listColumnDefs.add(new ColumnDef("소득세징수비율", Payr0301BM.ATTR_INCMTXCLLNRTO, ColumnDef.TYPE_DOUBLE , 90, true, false, true){
    	{

    	}
    });
    /** column 은행코드 : bnkCd */
    listColumnDefs.add(new ColumnDef("은행코드", Payr0301BM.ATTR_BNKCD, ColumnDef.TYPE_STRING , 90, true, true, true){
    	{

    	}
    });
    /** column 은행계좌번호 : bnkAccuNum */
    listColumnDefs.add(new ColumnDef("은행계좌번호", Payr0301BM.ATTR_BNKACCUNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
    	{

    	}
    });
    /** column 예금주명 : acntHodrNm */
    listColumnDefs.add(new ColumnDef("예금주명", Payr0301BM.ATTR_ACNTHODRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
    	{

    	}
    });
    /** column 급여마감일자 : payDdlneDt */
    listColumnDefs.add(new ColumnDef("급여마감일자", Payr0301BM.ATTR_PAYDDLNEDT, ColumnDef.TYPE_DATE , 90, true, false, true){
    	{

    	}
    });
    /** column 급여마감여부 : payDdlneYn */
    listColumnDefs.add(new ColumnDef("마감여부", Payr0301BM.ATTR_PAYDDLNEYN, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
    	{

    	}
    });
     
    
//    /** column 입력자 : kybdr */
//    listColumnDefs.add(new ColumnDef("입력자", Payr0301BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 입력일자 : inptDt */
//    listColumnDefs.add(new ColumnDef("입력일자", Payr0301BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 입력주소 : inptAddr */
//    listColumnDefs.add(new ColumnDef("입력주소", Payr0301BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 수정자 : ismt */
//    listColumnDefs.add(new ColumnDef("수정자", Payr0301BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 수정일자 : revnDt */
//    listColumnDefs.add(new ColumnDef("수정일자", Payr0301BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 수정주소 : revnAddr */
//    listColumnDefs.add(new ColumnDef("수정주소", Payr0301BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
 
    
    return listColumnDefs;
}


private List<ColumnDef> getPayr0301ToPayr4250ColumnsList(){
    row = 0;
    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
    /** column 사업장코드 : dpobCd */
    listColumnDefs.add(new ColumnDef("사업장코드", Payr0300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        {

        }
    });
    /** column 지급년월 : pymtYrMnth */
    listColumnDefs.add(new ColumnDef("지급년월", Payr0301BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{
          
    	}
    });
    /** column SYSTEMKEY : systemkey */
    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0301BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 급여구분코드 : payCd */
    listColumnDefs.add(new ColumnDef("급여구분코드", Payr0301BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });

    /** column 급여구분 : payNm */
    listColumnDefs.add(new ColumnDef("급여구분", Payr0301BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 90, false, true, true){
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
    
    /** column 한글성명 : hanNm */
    listColumnDefs.add(new ColumnDef("한글성명", Payr0304BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 90, true, true, true){
    	{

    	}
    });
    /** column 주민등록번호 : resnRegnNum */
    listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, true){
    	{

    	}
    });
    /** column 주민등록번호 : secRegnNum */
    listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
    	{

    	}
    });
    /** column 부서코드 : deptCd */
    listColumnDefs.add(new ColumnDef("부서코드", Payr0304BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, false, false, true){
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
    
    /** column 부서 : deptNm */
    listColumnDefs.add(new ColumnDef("부서명", Payr0304BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true){
    	{

    	}
    });
    /** column 사업 : businNm */
    listColumnDefs.add(new ColumnDef("사업명", Payr0304BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, false, true){
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
    
     
    /** column 단위기관 : payrMangDeptCd */
    listColumnDefs.add(new ColumnDef("단위기관코드", Payr0301BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    
    /** column 단위기관 : payrMangDept */
    listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    
    /** column 급여일련번호 : payrSeilNum */
    listColumnDefs.add(new ColumnDef("급여일련번호", Payr0301BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    /** column 지급총액 : pymtTotAmnt */
    listColumnDefs.add(new ColumnDef("지급금액", Payr0301BM.ATTR_PYMTTOTAMNT, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{
    		 setFormatNumeric(NumberFormat.getFormat("$#,##0.00")); 
    		 //this.setFormatNumeric("########");
    		//setFormatNumeric(NumberFormat.getCurrencyFormat("EUR"));
    	}
    });
    /** column 수당총액 : extpyTotAmnt */
    listColumnDefs.add(new ColumnDef("수당금액", Payr0301BM.ATTR_EXTPYTOTAMNT, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    /** column 과세총액 : txtnTotAmnt */
    listColumnDefs.add(new ColumnDef("과세금액", Payr0301BM.ATTR_TXTNTOTAMNT, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    /** column 비과세총액 : freeDtyTotAmnt */
    listColumnDefs.add(new ColumnDef("비과세금액", Payr0301BM.ATTR_FREEDTYTOTAMNT, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    /** column 공제총액 : dducTotAmnt */
    listColumnDefs.add(new ColumnDef("공제금액", Payr0301BM.ATTR_DDUCTOTAMNT, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    /** column 세금총액 : txTotAmnt */
    listColumnDefs.add(new ColumnDef("세금", Payr0301BM.ATTR_TXTOTAMNT, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    /** column 퇴직금지급여부 : sevePayPymtYn */
    listColumnDefs.add(new ColumnDef("퇴직금지급", Payr0301BM.ATTR_SEVEPAYPYMTYN, ColumnDef.TYPE_BOOLEAN , 90, false, false, true){
    	{

    	}
    });
    /** column 실지급액 : pernPymtSum */
    listColumnDefs.add(new ColumnDef("지급금액", Payr0301BM.ATTR_PERNPYMTSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
    	{

    	}
    });
    /** column 소득세징수비율 : incmTxCllnRto */
    listColumnDefs.add(new ColumnDef("소득세징수비율", Payr0301BM.ATTR_INCMTXCLLNRTO, ColumnDef.TYPE_DOUBLE , 90, false, false, true){
    	{

    	}
    });
    /** column 은행코드 : bnkCd */
    listColumnDefs.add(new ColumnDef("은행코드", Payr0301BM.ATTR_BNKCD, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    /** column 은행계좌번호 : bnkAccuNum */
    listColumnDefs.add(new ColumnDef("은행계좌번호", Payr0301BM.ATTR_BNKACCUNUM, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    /** column 예금주명 : acntHodrNm */
    listColumnDefs.add(new ColumnDef("예금주명", Payr0301BM.ATTR_ACNTHODRNM, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    /** column 급여마감일자 : payDdlneDt */
    listColumnDefs.add(new ColumnDef("마감일자", Payr0301BM.ATTR_PAYDDLNEDT, ColumnDef.TYPE_DATE , 80, false, true, true){
    	{

    	}
    });
    /** column 급여마감여부 : payDdlneYn */
    listColumnDefs.add(new ColumnDef("마감", Payr0301BM.ATTR_PAYDDLNEYN, ColumnDef.TYPE_BOOLEAN , 50, false, true, true){
    	{

    	}
    });
     
    
//    /** column 입력자 : kybdr */
//    listColumnDefs.add(new ColumnDef("입력자", Payr0301BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 입력일자 : inptDt */
//    listColumnDefs.add(new ColumnDef("입력일자", Payr0301BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 입력주소 : inptAddr */
//    listColumnDefs.add(new ColumnDef("입력주소", Payr0301BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 수정자 : ismt */
//    listColumnDefs.add(new ColumnDef("수정자", Payr0301BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 수정일자 : revnDt */
//    listColumnDefs.add(new ColumnDef("수정일자", Payr0301BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 수정주소 : revnAddr */
//    listColumnDefs.add(new ColumnDef("수정주소", Payr0301BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
 
    
    return listColumnDefs;
}
  
  
}
