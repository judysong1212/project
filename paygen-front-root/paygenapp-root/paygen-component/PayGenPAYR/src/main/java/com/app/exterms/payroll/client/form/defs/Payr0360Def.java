/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0360BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0360Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    public Payr0360Def(String chkPayrDef){
    	
    	
    	 if ("".equals(chkPayrDef)) { 
         	
		    setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_PAYR4210TOPAYR0360_DATA_LIST);
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	       // setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
	        setCheckBoxOnGridRows(true); 

            //setColumnsDefinition(getPayr0304Def());
         
        } else if ("PAYR4210".equals(chkPayrDef)) {  
          	
    	   setTitle("");
           setDaoClass("");
           setCustomListMethod(CLASS_PAYR4210TOPAYR0360_DATA_LIST);
           setAutoFillGrid(false);
           setShowFilterToolbar(false);
          // setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
           setCheckBoxOnGridRows(true); 

           setColumnsDefinition(getPayr4210ToPayr0360ColumnsList());
          
        } 
    	 
    }   
    	 
       public List<ColumnDef> getPayr4210ToPayr0360ColumnsList(){
    	        
    	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


    	        /** column 사업장코드 : dpobCd */
    	        listColumnDefs.add(new ColumnDef("사업장코드", Payr0360BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	        	{

    	        	}
    	        });
    	     
    	        /** column 소급년도 : reattyYr */
    	        listColumnDefs.add(new ColumnDef("소급년도", Payr0360BM.ATTR_REATTYYR, ColumnDef.TYPE_STRING , 60, true, true, true){
    	        	{

    	        	}
    	        });
    	        /** column 소급설정회차번호 : reattyStpDsptyNum */
    	        listColumnDefs.add(new ColumnDef("회차번호", Payr0360BM.ATTR_REATTYSTPDSPTYNUM, ColumnDef.TYPE_STRING , 60, true, true, true){
    	        	{

    	        	}
    	        });
    	        /** column 소급적용년월 : reattyApptnYrMnth */
    	        listColumnDefs.add(new ColumnDef("소급년월", Payr0360BM.ATTR_REATTYAPPTNYRMNTH, ColumnDef.TYPE_STRING , 60, true, true, true){
    	        	{

    	        	}
    	        });
    	        /** column 소급지급일자 : reattyPymtDt */
    	        listColumnDefs.add(new ColumnDef("지급일자", Payr0360BM.ATTR_REATTYPYMTDT, ColumnDef.TYPE_DATE , 80, true, true, true){
    	        	{

    	        	}
    	        });
    	        /** column 급여구분코드 : payCd */
    	        listColumnDefs.add(new ColumnDef("지급구분코드", Payr0360BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	        	{

    	        	}
    	        });
    	        
    	        /** column 급여구분코드 : payCd */
    	        listColumnDefs.add(new ColumnDef("지급구분", Payr0360BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 70, true, true, true){
    	        	{

    	        	}
    	        });
    	        /** column 고용구분코드 : emymtDivCd */
    	        listColumnDefs.add(new ColumnDef("고용구분코드", Payr0360BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	        	{

    	        	}
    	        });
    	        /** column 고용구분 : emymtDivNm */
    	        listColumnDefs.add(new ColumnDef("고용구분", Payr0360BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 70, false, true, true){
    	        	{

    	        	}
    	        });
    	        
    	        /** column 급여관리부서코드 : payrMangDeptCd */
    	        listColumnDefs.add(new ColumnDef("단위기관코드", Payr0360BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	        	{

    	        	}
    	        });
    	        /** column 부서코드 : deptCd */
    	        listColumnDefs.add(new ColumnDef("부서코드", Payr0360BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	        	{

    	        	}
    	        });
    	        /** column 부서 : deptNm */
    	        listColumnDefs.add(new ColumnDef("부서명", Payr0360BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true){
    	        	{

    	        	}
    	        });
    	      
    	     
    	       
    	        /** column 직종코드 : typOccuCd */
    	        listColumnDefs.add(new ColumnDef("직종코드", Payr0360BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	        	{

    	        	}
    	        });
    	        
    	        /** column 직종 : typOccuNm */
    	        listColumnDefs.add(new ColumnDef("직종", Payr0360BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, false, true){
    	        	{

    	        	}
    	        });
    	       
    	        /** column 직종세구분코드 : dtilOccuClsDivCd */
    	        listColumnDefs.add(new ColumnDef("직종세구분코드", Payr0360BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	        	{

    	        	}
    	        });
    	       
                
			/** column 직종세통합코드 : dtilOccuInttnCd */
			listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0360BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
			
			}
			});       

    	        /** column 직종세 : dtilOccuClsDivNm */
    	        listColumnDefs.add(new ColumnDef("직종세", Payr0360BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
    	        	{

    	        	}
    	        });
    	        /** column 사업코드 : businCd */
    	        listColumnDefs.add(new ColumnDef("사업코드", Payr0360BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	        	{

    	        	}
    	        });
    	        
    	        
    	        /** column 사업 : businNm */
    	        listColumnDefs.add(new ColumnDef("사업명", Payr0360BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, false, true){
    	            {

    	            }
    	        });
    	        
    	        /** column 호봉등급코드 : pyspGrdeCd */
    	        listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0360BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	        	{

    	        	}
    	        });
    	        
    	        /** column 지급월설정_01 : pymtMnthStp01 */
    	        listColumnDefs.add(new ColumnDef("01", Payr0360BM.ATTR_PYMTMNTHSTP01, ColumnDef.TYPE_BOOLEAN , 30, true, true, true){
    	        	{

    	        	}
    	        });
    	        /** column 지급월설정_02 : pymtMnthStp02 */
    	        listColumnDefs.add(new ColumnDef("02", Payr0360BM.ATTR_PYMTMNTHSTP02, ColumnDef.TYPE_BOOLEAN , 30, true, true, true){
    	        	{

    	        	}
    	        });
    	        /** column 지급월설정_03 : pymtMnthStp03 */
    	        listColumnDefs.add(new ColumnDef("03", Payr0360BM.ATTR_PYMTMNTHSTP03, ColumnDef.TYPE_BOOLEAN , 30, true, true, true){
    	        	{

    	        	}
    	        });
    	        /** column 지급월설정_04 : pymtMnthStp04 */
    	        listColumnDefs.add(new ColumnDef("04", Payr0360BM.ATTR_PYMTMNTHSTP04, ColumnDef.TYPE_BOOLEAN , 30, true, true, true){
    	        	{

    	        	}
    	        });
    	        /** column 지급월설정_05 : pymtMnthStp05 */
    	        listColumnDefs.add(new ColumnDef("05", Payr0360BM.ATTR_PYMTMNTHSTP05, ColumnDef.TYPE_BOOLEAN , 30, true, true, true){
    	        	{

    	        	}
    	        });
    	        /** column 지급월설정_06 : pymtMnthStp06 */
    	        listColumnDefs.add(new ColumnDef("06", Payr0360BM.ATTR_PYMTMNTHSTP06, ColumnDef.TYPE_BOOLEAN , 30, true, true, true){
    	        	{

    	        	}
    	        });
    	        /** column 지급월설정_07 : pymtMnthStp07 */
    	        listColumnDefs.add(new ColumnDef("07", Payr0360BM.ATTR_PYMTMNTHSTP07, ColumnDef.TYPE_BOOLEAN , 30, true, true, true){
    	        	{

    	        	}
    	        });
    	        /** column 지급월설정_08 : pymtMnthStp08 */
    	        listColumnDefs.add(new ColumnDef("08", Payr0360BM.ATTR_PYMTMNTHSTP08, ColumnDef.TYPE_STRING , 30, true, true, true){
    	        	{

    	        	}
    	        });
    	        /** column 지급월설정_09 : pymtMnthStp09 */
    	        listColumnDefs.add(new ColumnDef("09", Payr0360BM.ATTR_PYMTMNTHSTP09, ColumnDef.TYPE_BOOLEAN , 30, true, true, true){
    	        	{

    	        	}
    	        });
    	        /** column 지급월설정_10 : pymtMnthStp10 */
    	        listColumnDefs.add(new ColumnDef("10", Payr0360BM.ATTR_PYMTMNTHSTP10, ColumnDef.TYPE_BOOLEAN , 30, true, true, true){
    	        	{

    	        	}
    	        });
    	        /** column 지급월설정_11 : pymtMnthStp11 */
    	        listColumnDefs.add(new ColumnDef("11", Payr0360BM.ATTR_PYMTMNTHSTP11, ColumnDef.TYPE_STRING , 30, true, true, true){
    	        	{

    	        	}
    	        });
    	        /** column 지급월설정_12 : pymtMnthStp12 */
    	        listColumnDefs.add(new ColumnDef("12", Payr0360BM.ATTR_PYMTMNTHSTP12, ColumnDef.TYPE_BOOLEAN , 30, true, true, true){
    	        	{

    	        	}
    	        });
    	        /** column TGT_SYSTEMKEY : tgtSystemkey */
    	        listColumnDefs.add(new ColumnDef("TGT_SYSTEMKEY", Payr0360BM.ATTR_TGTSYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
    	        	{

    	        	}
    	        });
    	        /** column 소급설정내용 : reattyStpNoteCtnt */
    	        listColumnDefs.add(new ColumnDef("소급설정내용", Payr0360BM.ATTR_REATTYSTPNOTECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
    	        	{

    	        	}
    	        });
//    	        /** column 입력자 : kybdr */
//    	        listColumnDefs.add(new ColumnDef("입력자", Payr0360BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//    	        	{
//
//    	        	}
//    	        });
//    	        /** column 입력일자 : inptDt */
//    	        listColumnDefs.add(new ColumnDef("입력일자", Payr0360BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//    	        	{
//
//    	        	}
//    	        });
//    	        /** column 입력주소 : inptAddr */
//    	        listColumnDefs.add(new ColumnDef("입력주소", Payr0360BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//    	        	{
//
//    	        	}
//    	        });
//    	        /** column 수정자 : ismt */
//    	        listColumnDefs.add(new ColumnDef("수정자", Payr0360BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//    	        	{
//
//    	        	}
//    	        });
//    	        /** column 수정일자 : revnDt */
//    	        listColumnDefs.add(new ColumnDef("수정일자", Payr0360BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//    	        	{
//
//    	        	}
//    	        });
//    	        /** column 수정주소 : revnAddr */
//    	        listColumnDefs.add(new ColumnDef("수정주소", Payr0360BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//    	        	{
//
//    	        	}
//    	        });

//    	        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
    	//
//    	        private TextField<String> payCd;   /** column 급여구분코드 : payCd */
    	//
//    	        private TextField<String> reattyYr;   /** column 소급년도 : reattyYr */
    	//
//    	        private TextField<String> reattyStpDsptyNum;   /** column 소급설정회차번호 : reattyStpDsptyNum */
    	//
//    	        private TextField<String> reattyApptnYr;   /** column 소급적용년월 : reattyApptnYr */
    	//
//    	        private TextField<String> reattyPymtDt;   /** column 소급지급일자 : reattyPymtDt */
    	//
//    	        private TextField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
    	//
//    	        private TextField<String> payrMangDeptCd;   /** column 급여관리부서코드 : payrMangDeptCd */
    	//
//    	        private TextField<String> deptCd;   /** column 부서코드 : deptCd */
    	//
//    	        private TextField<String> businCd;   /** column 사업코드 : businCd */
    	//
//    	        private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
    	//
//    	        private TextField<String> dtilOccuClsDivCd;   /** column 직종세구분코드 : dtilOccuClsDivCd */
    	//
//    	        private TextField<String> pymtMnthStp01;   /** column 지급월설정_01 : pymtMnthStp01 */
    	//
//    	        private TextField<String> pymtMnthStp02;   /** column 지급월설정_02 : pymtMnthStp02 */
    	//
//    	        private TextField<String> pymtMnthStp03;   /** column 지급월설정_03 : pymtMnthStp03 */
    	//
//    	        private TextField<String> pymtMnthStp04;   /** column 지급월설정_04 : pymtMnthStp04 */
    	//
//    	        private TextField<String> pymtMnthStp05;   /** column 지급월설정_05 : pymtMnthStp05 */
    	//
//    	        private TextField<String> pymtMnthStp06;   /** column 지급월설정_06 : pymtMnthStp06 */
    	//
//    	        private TextField<String> pymtMnthStp07;   /** column 지급월설정_07 : pymtMnthStp07 */
    	//
//    	        private TextField<String> pymtMnthStp08;   /** column 지급월설정_08 : pymtMnthStp08 */
    	//
//    	        private TextField<String> pymtMnthStp09;   /** column 지급월설정_09 : pymtMnthStp09 */
    	//
//    	        private TextField<String> pymtMnthStp10;   /** column 지급월설정_10 : pymtMnthStp10 */
    	//
//    	        private TextField<String> pymtMnthStp11;   /** column 지급월설정_11 : pymtMnthStp11 */
    	//
//    	        private TextField<String> pymtMnthStp12;   /** column 지급월설정_12 : pymtMnthStp12 */
    	//
//    	        private TextField<String> tgtSystemkey;   /** column TGT_SYSTEMKEY : tgtSystemkey */
    	//
//    	        private TextField<String> kybdr;   /** column 입력자 : kybdr */
    	//
//    	        private TextField<String> inptDt;   /** column 입력일자 : inptDt */
    	//
//    	        private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
    	//
//    	        private TextField<String> ismt;   /** column 수정자 : ismt */
    	//
//    	        private TextField<String> revnDt;   /** column 수정일자 : revnDt */
    	//
//    	        private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
//    	      
    	       
    	        
    	        return listColumnDefs;
    	    }
   
}
