/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0350BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0350Def  extends TableDef implements PayrDaoConstants {

   
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    
    public Payr0350Def(String chkPayrDef){
    	
    	
   	 if ("PAYR4220".equals(chkPayrDef)) { 
        	
	   	  setTitle(PayrLabel.titlePayr0350());
	      setDaoClass(CLASS_PAYR4220TOPAYR0350_DATA_LIST);
	      setCustomListMethod(CLASS_PAYR4220TOPAYR0350_DATA_LIST);
	      setAutoFillGrid(false);
	      setShowFilterToolbar(false);
	     // setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
	      setCheckBoxOnGridRows(true); 


           setColumnsDefinition(getPayr4220ToPayr0350ColumnsList());
        
       } else if ("PAYR4210".equals(chkPayrDef)) {  
         	
    	   setTitle(PayrLabel.titlePayr0350());
          setDaoClass("");
          setCustomListMethod(CLASS_PAYR4210TOPAYR0350_DATA_LIST);
          setAutoFillGrid(false);
          setShowFilterToolbar(false);
         // setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
          setCheckBoxOnGridRows(true); 

          setColumnsDefinition(getPayr4210ToPayr0350ColumnsList());
         
       }  else if ("PAYR4220DTL".equals(chkPayrDef)) {  
        	
   	     setTitle(PayrLabel.titlePayr0350());
         setDaoClass("");
         setCustomListMethod(CLASS_PAYR4220TOPAYR0350DTL_DATA_LIST);
         setAutoFillGrid(false);
         setShowFilterToolbar(false);
        // setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
         setCheckBoxOnGridRows(true); 

         setColumnsDefinition(getPayr4210ToPayr0350DtlColumnsList());
        
      } 
  
   	
   	
    }
    

    public List<ColumnDef> getPayr4210ToPayr0350DtlColumnsList(){ 
    	
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0350BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소급년도 : reattyYr */
        listColumnDefs.add(new ColumnDef("소급년도", Payr0350BM.ATTR_REATTYYR, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{

        	}
        });
       
        /** column 소급설정회차번호 : reattyStpDsptyNum */
        listColumnDefs.add(new ColumnDef("회차번호", Payr0350BM.ATTR_REATTYSTPDSPTYNUM, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{

        	}
        });
        
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("지급구분코드", Payr0350BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여구분 : payNm */
        listColumnDefs.add(new ColumnDef("지급구분", Payr0350BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 70, true, false, true){
        	{

        	}
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0350BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        
        
        /** column 고용구분 : emymtDivNm */
        listColumnDefs.add(new ColumnDef("고용구분", Payr0350BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 70, false, false, true){
        	{

        	}
        });
        
      
        /** column 부서 : deptNm */
        listColumnDefs.add(new ColumnDef("부서명", Payr0350BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
       
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Payr0350BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, false, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0350BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 80, true, false, true){
        	{

        	}
        });
        
        /** column org주민등록번호 : secRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0350BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
        	{

        	}
        });
       
        /** column 소급적용금액_1월 : reattyApptnSumJan */
        listColumnDefs.add(new ColumnDef("1월", Payr0350BM.ATTR_REATTYAPPTNSUMJAN, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_2월 : reattyApptnSumFeb */
        listColumnDefs.add(new ColumnDef("2월", Payr0350BM.ATTR_REATTYAPPTNSUMFEB, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_3월 : reattyApptnSumMar */
        listColumnDefs.add(new ColumnDef("3월", Payr0350BM.ATTR_REATTYAPPTNSUMMAR, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_4월 : reattyApptnSumApr */
        listColumnDefs.add(new ColumnDef("4월", Payr0350BM.ATTR_REATTYAPPTNSUMAPR, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_5월 : reattyApptnSumMay */
        listColumnDefs.add(new ColumnDef("5월", Payr0350BM.ATTR_REATTYAPPTNSUMMAY, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_6월 : reattyApptnSumJun */
        listColumnDefs.add(new ColumnDef("6월", Payr0350BM.ATTR_REATTYAPPTNSUMJUN, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_7월 : reattyApptnSumJul */
        listColumnDefs.add(new ColumnDef("7월", Payr0350BM.ATTR_REATTYAPPTNSUMJUL, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_8월 : reattyApptnSumAug */
        listColumnDefs.add(new ColumnDef("8월", Payr0350BM.ATTR_REATTYAPPTNSUMAUG, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_9월 : reattyApptnSumSep */
        listColumnDefs.add(new ColumnDef("9월", Payr0350BM.ATTR_REATTYAPPTNSUMSEP, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_10월 : reattyApptnSumOct */
        listColumnDefs.add(new ColumnDef("10월", Payr0350BM.ATTR_REATTYAPPTNSUMOCT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_11월 : reattyApptnSumNov */
        listColumnDefs.add(new ColumnDef("11월", Payr0350BM.ATTR_REATTYAPPTNSUMNOV, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_12월 : reattyApptnSumDec */
        listColumnDefs.add(new ColumnDef("12월", Payr0350BM.ATTR_REATTYAPPTNSUMDEC, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액합계 : reattyApptnSumAggr */
        listColumnDefs.add(new ColumnDef("합계", Payr0350BM.ATTR_REATTYAPPTNSUMAGGR, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급항목비고내용 : reattyItemNoteCtnt */
        listColumnDefs.add(new ColumnDef("소급항목비고내용", Payr0350BM.ATTR_REATTYITEMNOTECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소급적용년월 : reattyPymtYrMnth */
        listColumnDefs.add(new ColumnDef("소급적용년월", Payr0350BM.ATTR_REATTYPYMTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소급지급처리여부 : reattyPymtPrcsYn */
        listColumnDefs.add(new ColumnDef("소급지급처리여부", Payr0350BM.ATTR_REATTYPYMTPRCSYN, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
        	{

        	}
        });
        /** column 소급마감일자 : reattyDdlneDt */
        listColumnDefs.add(new ColumnDef("마감일자", Payr0350BM.ATTR_REATTYDDLNEDT, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 소급마감여부 : reattyDdlneYn */
        listColumnDefs.add(new ColumnDef("마감", Payr0350BM.ATTR_REATTYDDLNEYN, ColumnDef.TYPE_BOOLEAN , 40, true, true, true){
        	{

        	}
        });
        
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Payr0350BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
       
       
       
        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Payr0350BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
       
        
        
        /** column 사업 : businNm */
        listColumnDefs.add(new ColumnDef("사업명", Payr0350BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, false, true){
            {

            }
        });
        
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0350BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
		        
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0350BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		{
		
		}
		});           

//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Payr0350BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Payr0350BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Payr0350BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Payr0350BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Payr0350BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Payr0350BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });


//      
       
        return listColumnDefs;
     
    }
    
    public List<ColumnDef> getPayr4210ToPayr0350ColumnsList(){ 
    	
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0350BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소급년도 : reattyYr */
        listColumnDefs.add(new ColumnDef("소급년도", Payr0350BM.ATTR_REATTYYR, ColumnDef.TYPE_STRING , 50, true, true, true){
        	{

        	}
        });
       
        /** column 소급설정회차번호 : reattyStpDsptyNum */
        listColumnDefs.add(new ColumnDef("회차번호", Payr0350BM.ATTR_REATTYSTPDSPTYNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("지급구분코드", Payr0350BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여구분 : payNm */
        listColumnDefs.add(new ColumnDef("지급구분", Payr0350BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0350BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        
        
        /** column 고용구분 : emymtDivNm */
        listColumnDefs.add(new ColumnDef("고용구분", Payr0350BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 70, false, true, true){
        	{

        	}
        });
        
      
        /** column 부서 : deptNm */
        listColumnDefs.add(new ColumnDef("부서명", Payr0350BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
       
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Payr0350BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0350BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 80, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : secRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0350BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
        	{

        	}
        });
        /** column 소급적용금액_1월 : reattyApptnSumJan */
        listColumnDefs.add(new ColumnDef("1월", Payr0350BM.ATTR_REATTYAPPTNSUMJAN, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_2월 : reattyApptnSumFeb */
        listColumnDefs.add(new ColumnDef("2월", Payr0350BM.ATTR_REATTYAPPTNSUMFEB, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_3월 : reattyApptnSumMar */
        listColumnDefs.add(new ColumnDef("3월", Payr0350BM.ATTR_REATTYAPPTNSUMMAR, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_4월 : reattyApptnSumApr */
        listColumnDefs.add(new ColumnDef("4월", Payr0350BM.ATTR_REATTYAPPTNSUMAPR, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_5월 : reattyApptnSumMay */
        listColumnDefs.add(new ColumnDef("5월", Payr0350BM.ATTR_REATTYAPPTNSUMMAY, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_6월 : reattyApptnSumJun */
        listColumnDefs.add(new ColumnDef("6월", Payr0350BM.ATTR_REATTYAPPTNSUMJUN, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_7월 : reattyApptnSumJul */
        listColumnDefs.add(new ColumnDef("7월", Payr0350BM.ATTR_REATTYAPPTNSUMJUL, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_8월 : reattyApptnSumAug */
        listColumnDefs.add(new ColumnDef("8월", Payr0350BM.ATTR_REATTYAPPTNSUMAUG, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_9월 : reattyApptnSumSep */
        listColumnDefs.add(new ColumnDef("9월", Payr0350BM.ATTR_REATTYAPPTNSUMSEP, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_10월 : reattyApptnSumOct */
        listColumnDefs.add(new ColumnDef("10월", Payr0350BM.ATTR_REATTYAPPTNSUMOCT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_11월 : reattyApptnSumNov */
        listColumnDefs.add(new ColumnDef("11월", Payr0350BM.ATTR_REATTYAPPTNSUMNOV, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액_12월 : reattyApptnSumDec */
        listColumnDefs.add(new ColumnDef("12월", Payr0350BM.ATTR_REATTYAPPTNSUMDEC, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급적용금액합계 : reattyApptnSumAggr */
        listColumnDefs.add(new ColumnDef("합계", Payr0350BM.ATTR_REATTYAPPTNSUMAGGR, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소급항목비고내용 : reattyItemNoteCtnt */
        listColumnDefs.add(new ColumnDef("비고내용", Payr0350BM.ATTR_REATTYITEMNOTECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소급적용년월 : reattyPymtYrMnth */
        listColumnDefs.add(new ColumnDef("소급지급년월", Payr0350BM.ATTR_REATTYPYMTYRMNTH, ColumnDef.TYPE_STRING , 60, true, false, true){
        	{

        	}
        });
        /** column 소급지급처리여부 : reattyPymtPrcsYn */
        listColumnDefs.add(new ColumnDef("지급여부", Payr0350BM.ATTR_REATTYPYMTPRCSYN, ColumnDef.TYPE_BOOLEAN , 60, true, false, true){
        	{

        	}
        });
        /** column 소급마감일자 : reattyDdlneDt */
        listColumnDefs.add(new ColumnDef("마감일자", Payr0350BM.ATTR_REATTYDDLNEDT, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 소급마감여부 : reattyDdlneYn */
        listColumnDefs.add(new ColumnDef("마감", Payr0350BM.ATTR_REATTYDDLNEYN, ColumnDef.TYPE_BOOLEAN , 40, true, true, true){
        	{

        	}
        });
        
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Payr0350BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
       
       
       
        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Payr0350BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
       
        
        
        /** column 사업 : businNm */
        listColumnDefs.add(new ColumnDef("사업명", Payr0350BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, true, true){
            {

            }
        });
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0350BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });    
        
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0350BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Payr0350BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Payr0350BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Payr0350BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Payr0350BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Payr0350BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Payr0350BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });


//      
       
        return listColumnDefs;
     
    }
    
 public List<ColumnDef> getPayr4220ToPayr0350ColumnsList(){ 
    	
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0350BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소급년도 : reattyYr */
        listColumnDefs.add(new ColumnDef("소급년도", Payr0350BM.ATTR_REATTYYR, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{

        	}
        });
       
        /** column 소급설정회차번호 : reattyStpDsptyNum */
        listColumnDefs.add(new ColumnDef("회차번호", Payr0350BM.ATTR_REATTYSTPDSPTYNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("지급구분코드", Payr0350BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여구분 : payNm */
        listColumnDefs.add(new ColumnDef("지급구분", Payr0350BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 70, true, false, true){
        	{

        	}
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0350BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        
        
        /** column 고용구분 : emymtDivNm */
        listColumnDefs.add(new ColumnDef("고용구분", Payr0350BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 70, false, false, true){
        	{

        	}
        });
        
      
        /** column 부서 : deptNm */
        listColumnDefs.add(new ColumnDef("부서명", Payr0350BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
       
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Payr0350BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0350BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 80, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : secRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0350BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
        	{

        	}
        });
        
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Payr0350BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
       
       
       
        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Payr0350BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
       
        
        
        /** column 사업 : businNm */
        listColumnDefs.add(new ColumnDef("사업명", Payr0350BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, true, true){
            {

            }
        });
        
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0350BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0350BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });   
        
        
        /** column 소급마감일자 : reattyDdlneDt */
        listColumnDefs.add(new ColumnDef("마감일자", Payr0350BM.ATTR_REATTYDDLNEDT, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 소급마감여부 : reattyDdlneYn */
        listColumnDefs.add(new ColumnDef("마감", Payr0350BM.ATTR_REATTYDDLNEYN, ColumnDef.TYPE_BOOLEAN , 40, true, true, true){
        	{

        	}
        });
        return listColumnDefs;
     
    }
}
