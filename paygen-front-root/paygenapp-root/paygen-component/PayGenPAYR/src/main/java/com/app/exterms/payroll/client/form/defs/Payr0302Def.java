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
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0302Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    public Payr0302Def(String chkPayrDef){
    	  setTitle(PayrLabel.titlePayr0302());
      
       
       if ("PAYR4200EXTPY".equals(chkPayrDef)) { 
       	
       	  setDaoClass(CLASS_PAYR0302_EXTPY_DATA_LIST);
            setCustomListMethod(CLASS_PAYR0302_EXTPY_DATA_LIST);
            setAutoFillGrid(true);
            setShowFilterToolbar(false); 
            setCheckBoxOnGridRows(false); 
            setCheckBoxOnGridRows(true); 
  	  	    setEditFieldGrid(true);
            setEditableGrid(true);
            
            setColumnsDefinition(getPayr0302ExtpyDef());
        
      } else if ("PAYR4200DDUC".equals(chkPayrDef)) {  
         	
       	 setDaoClass(CLASS_PAYR0302_DDUC_DATA_LIST);
         setCustomListMethod(CLASS_PAYR0302_DDUC_DATA_LIST);
         setAutoFillGrid(true);
         setShowFilterToolbar(false);  
         setCheckBoxOnGridRows(false); 
         setCheckBoxOnGridRows(true); 
		  setEditFieldGrid(true);
         setEditableGrid(true);

         setColumnsDefinition(getPayr0302DducDef());
         
     } 
      
      else   {  
      	
   
         setDaoClass(CLASS_PAYR0302_DATA_LIST);
         setCustomListMethod(CLASS_PAYR0302_DATA_LIST); 
         setAutoFillGrid(true);
         setShowFilterToolbar(false); 
      
         setCheckBoxOnGridRows(true); 

         setColumnsDefinition(getPayr0302Def());
      
  }
   }
    
    public List<ColumnDef>  getPayr0302Def(){
        

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        /** column 지급년월 : pymtYrMnth */
        listColumnDefs.add(new ColumnDef("지급년월", Payr0302BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0302BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 급여항목코드 : payItemCd */
        listColumnDefs.add(new ColumnDef("급여항목코드", Payr0302BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 급여항목 : payItemNm */
        listColumnDefs.add(new ColumnDef("급여항목", Payr0302BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분코드", Payr0302BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 급여구분 : payNm */
        listColumnDefs.add(new ColumnDef("급여구분", Payr0301BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
        /** column 단위기관코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관코드", Payr0302BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 단위기관 : payrMangDept */
        listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여일련번호 : payrSeilNum */
        listColumnDefs.add(new ColumnDef("급여일련번호", Payr0302BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        /** column 급여항목일련번호 : payItemSeilNum */
        listColumnDefs.add(new ColumnDef("급여항목일련번호", Payr0302BM.ATTR_PAYITEMSEILNUM, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        /** column 지급공제구분코드 : pymtDducDivCd */
        listColumnDefs.add(new ColumnDef("지급공제구분코드", Payr0302BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 지급공제구분 : pymtDducDivNm */
        listColumnDefs.add(new ColumnDef("지급공제구분", Payr0302BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
        /** column 지급공제비과세금액 : pymtDducFreeDtySum */
        listColumnDefs.add(new ColumnDef("지급공제비과세금액", Payr0302BM.ATTR_PYMTDDUCFREEDTYSUM, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        /** column 지급공제금액 : pymtDducSum */
        listColumnDefs.add(new ColumnDef("지급공제금액", Payr0302BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        /** column 지급공제과세금액 : pymtDducTxtnAmnt */
        listColumnDefs.add(new ColumnDef("지급공제과세금액", Payr0302BM.ATTR_PYMTDDUCTXTNAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
            {

            }
        });

        /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
        listColumnDefs.add(new ColumnDef("급여지급공제처리플래그", Payr0302BM.ATTR_PAYPYMTDDUCPRCSFLAG, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 급여지급공제소급조정값 : payReattyAdmntVal */
        listColumnDefs.add(new ColumnDef("급여지급공제소급조정값", Payr0302BM.ATTR_PAYREATTYADMNTVAL, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 연말정산_기부금코드 : pyytYrtxDotnCd */
        listColumnDefs.add(new ColumnDef("연말정산_기부금코드", Payr0302BM.ATTR_PYYTYRTXDOTNCD, ColumnDef.TYPE_STRING , 90, false, false, true){
        	{

        	}
        });
        /** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
        listColumnDefs.add(new ColumnDef("연말정산_비과세감면코드", Payr0302BM.ATTR_PYYTYTFEDTYREDUCD, ColumnDef.TYPE_STRING , 90, false, false, true){
        	{

        	}
        });

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0302BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여지급공제변경여부 : pymtDducChgYn */
        listColumnDefs.add(new ColumnDef("급여지급공제변경여부", Payr0302BM.ATTR_PYMTDDUCCHGYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Payr0302BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Payr0302BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Payr0302BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Payr0302BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Payr0302BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Payr0302BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });

 
//
//        private TextField<String> payrMangDeptCd   /** column 단위기관코드 : payrMangDeptCd */
//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> pymtYrMnth;   /** column 지급년월 : pymtYrMnth */
//
//        private TextField<String> payCd;   /** column 급여구분코드 : payCd */
//
//        private TextField<String> payrSeilNum;   /** column 급여일련번호 : payrSeilNum */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> payItemCd;   /** column 급여항목코드 : payItemCd */
//
//        private TextField<String> payItemSeilNum;   /** column 급여항목일련번호 : payItemSeilNum */
//
//        private TextField<String> pymtDducDivCd;   /** column 지급공제구분코드 : pymtDducDivCd */
//
//        private TextField<String> pymtDducFreeDtySum;   /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//
//        private TextField<String> pymtDducSum;   /** column 지급공제금액 : pymtDducSum */
//
//        private TextField<String> payPymtDducPrcsFlag;   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//
//        private TextField<String> payReattyAdmntVal;   /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//
//        private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//        private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//        private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//        private TextField<String> ismt;   /** column 수정자 : ismt */
//
//        private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//        private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
//
//        private TextField<String> pymtDducTxtnAmnt;   /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//        
//        

        
        return listColumnDefs;
    }
    

    public List<ColumnDef>  getPayr0302DducDef(){
        

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** column 급여항목코드 : payItemCd */
        listColumnDefs.add(new ColumnDef("급여항목코드", Payr0302BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 급여항목 : payItemNm */
        listColumnDefs.add(new ColumnDef("항 목", Payr0302BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 지급공제금액 : pymtDducSum */
        listColumnDefs.add(new ColumnDef("공제금액", Payr0302BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG, 100, true, true, true){
        	{
        		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	//setSelectOnFocus(true);
        	}
        });
        /** column 지급공제과세금액 : pymtDducTxtnAmnt */
        listColumnDefs.add(new ColumnDef("과세금액", Payr0302BM.ATTR_PYMTDDUCTXTNAMNT, ColumnDef.TYPE_LONG , 90, false, false, true){
            {
            	setReadOnly(true);
            }
        });
        /** column 지급년월 : pymtYrMnth */
        listColumnDefs.add(new ColumnDef("지급년월", Payr0302BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0302BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
      
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분코드", Payr0302BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 급여구분 : payNm */
        listColumnDefs.add(new ColumnDef("급여구분", Payr0301BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 단위기관코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관코드", Payr0302BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 단위기관 : payrMangDept */
        listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 급여일련번호 : payrSeilNum */
        listColumnDefs.add(new ColumnDef("급여일련번호", Payr0302BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column null : payItemSeilNum */
        listColumnDefs.add(new ColumnDef("급여항목일련번호", Payr0302BM.ATTR_PAYITEMSEILNUM, ColumnDef.TYPE_LONG, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 지급공제구분코드 : pymtDducDivCd */
        listColumnDefs.add(new ColumnDef("지급공제구분코드", Payr0302BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 지급공제구분 : pymtDducDivNm */
        listColumnDefs.add(new ColumnDef("지급공제구분", Payr0302BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 지급공제비과세금액 : pymtDducFreeDtySum */
        listColumnDefs.add(new ColumnDef("비과세", Payr0302BM.ATTR_PYMTDDUCFREEDTYSUM, ColumnDef.TYPE_LONG, 90, false, false, false){
        	{
        		setReadOnly(true);
        	}
        });
      
     
        /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
        listColumnDefs.add(new ColumnDef("급여지급공제처리플래그", Payr0302BM.ATTR_PAYPYMTDDUCPRCSFLAG, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 급여지급공제소급조정값 : payReattyAdmntVal */
        listColumnDefs.add(new ColumnDef("급여지급공제소급조정값", Payr0302BM.ATTR_PAYREATTYADMNTVAL, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 연말정산_기부금코드 : pyytYrtxDotnCd */
        listColumnDefs.add(new ColumnDef("연말정산_기부금코드", Payr0302BM.ATTR_PYYTYRTXDOTNCD, ColumnDef.TYPE_STRING , 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
        listColumnDefs.add(new ColumnDef("연말정산_비과세감면코드", Payr0302BM.ATTR_PYYTYTFEDTYREDUCD, ColumnDef.TYPE_STRING , 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });


        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0302BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, true){
        	{

        	}
        });
        /** column 급여지급공제변경여부 : pymtDducChgYn */
        listColumnDefs.add(new ColumnDef("급여지급공제변경여부", Payr0302BM.ATTR_PYMTDDUCCHGYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        return listColumnDefs;
    }
    
    public List<ColumnDef>  getPayr0302ExtpyDef(){
        

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        
        /** column 급여항목코드 : payItemCd */
        listColumnDefs.add(new ColumnDef("급여항목코드", Payr0302BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 급여항목 : payItemNm */
        listColumnDefs.add(new ColumnDef("항 목", Payr0302BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 지급년월 : pymtYrMnth */
        listColumnDefs.add(new ColumnDef("지급년월", Payr0302BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0302BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
      
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분코드", Payr0302BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 급여구분 : payNm */
        listColumnDefs.add(new ColumnDef("급여구분", Payr0301BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 단위기관코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관코드", Payr0302BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 단위기관 : payrMangDept */
        listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 급여일련번호 : payrSeilNum */
        listColumnDefs.add(new ColumnDef("급여일련번호", Payr0302BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column null : payItemSeilNum */
        listColumnDefs.add(new ColumnDef("급여항목일련번호", Payr0302BM.ATTR_PAYITEMSEILNUM, ColumnDef.TYPE_LONG, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 지급공제구분코드 : pymtDducDivCd */
        listColumnDefs.add(new ColumnDef("지급공제구분코드", Payr0302BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 지급공제구분 : pymtDducDivNm */
        listColumnDefs.add(new ColumnDef("지급공제구분", Payr0302BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 지급공제비과세금액 : pymtDducFreeDtySum */
        listColumnDefs.add(new ColumnDef("비과세", Payr0302BM.ATTR_PYMTDDUCFREEDTYSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 지급공제금액 : pymtDducSum */
        listColumnDefs.add(new ColumnDef("지급금액", Payr0302BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{
        		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	//setSelectOnFocus(true);
        	}
        });
        /** column 지급공제과세금액 : pymtDducTxtnAmnt */
        listColumnDefs.add(new ColumnDef("과세금액", Payr0302BM.ATTR_PYMTDDUCTXTNAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
            {
            	setReadOnly(true);
            }
        });
        /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
        listColumnDefs.add(new ColumnDef("급여지급공제처리플래그", Payr0302BM.ATTR_PAYPYMTDDUCPRCSFLAG, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 급여지급공제소급조정값 : payReattyAdmntVal */
        listColumnDefs.add(new ColumnDef("급여지급공제소급조정값", Payr0302BM.ATTR_PAYREATTYADMNTVAL, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 연말정산_기부금코드 : pyytYrtxDotnCd */
        listColumnDefs.add(new ColumnDef("연말정산_기부금코드", Payr0302BM.ATTR_PYYTYRTXDOTNCD, ColumnDef.TYPE_STRING , 90, false, false, true){
        	{

        	}
        });
        /** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
        listColumnDefs.add(new ColumnDef("연말정산_비과세감면코드", Payr0302BM.ATTR_PYYTYTFEDTYREDUCD, ColumnDef.TYPE_STRING , 90, false, false, true){
        	{

        	}
        });


        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0302BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, true){
        	{

        	}
        });
        /** column 급여지급공제변경여부 : pymtDducChgYn */
        listColumnDefs.add(new ColumnDef("급여지급공제변경여부", Payr0302BM.ATTR_PYMTDDUCCHGYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        return listColumnDefs;
    }
    
    
    
}
