/**
 * 공통화면 팝업 
 */
package com.app.exterms.retirement.client.form.def;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.retirement.client.dto.Remt2300BM;
import com.app.exterms.retirement.client.languages.RemtConstants;
import com.app.exterms.retirement.shared.RemtDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Remt2300Def  extends TableDef implements RemtDaoConstants {

    private int row = 0;
    private RemtConstants RemtLabel = RemtConstants.INSTANCE;
  
    public Remt2300Def(String chkDef){ 
        
        setTitle("");

        
      if ("REMT0100".equals(chkDef)) { 
    	  
	        setDaoClass(CLASS_REMT0100_REMT2300_DATA_LIST);
	        setCustomListMethod(CLASS_REMT0100_REMT2300_DATA_LIST);
	        setAutoFillGrid(false);
	        setEditFieldGrid(true);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
        
            setColumnsDefinition(getRemt0100ToRemt2300());
        } else {
              
                setDaoClass(CLASS_REMT3500_DATA_LIST);
                setCustomListMethod(CLASS_REMT3500_DATA_LIST);
                setAutoFillGrid(true);
                setShowFilterToolbar(false);
               // setCustomListMethod(MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL);
                setCheckBoxOnGridRows(true);
             
            setColumnsDefinition(getRemt3500Def());
          
        }  
    } 
    
    public List<ColumnDef> getRemt0100ToRemt2300(){
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Remt2300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        listColumnDefs.add(new ColumnDef("퇴직정산구분코드", Remt2300BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산년월 : clutYrMnth */
        listColumnDefs.add(new ColumnDef("정산년월", Remt2300BM.ATTR_CLUTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Remt2300BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여항목코드 : payItemCd */
        listColumnDefs.add(new ColumnDef("급여항목코드", Remt2300BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여항목 : payItemNm */
        listColumnDefs.add(new ColumnDef("공제항목", Remt2300BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        /** column 지급공제구분코드 : pymtDducDivCd 기본값으로 셋팅 공제*/
        listColumnDefs.add(new ColumnDef("지급공제구분코드", Remt2300BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 지급금액 : pymtSum */
        listColumnDefs.add(new ColumnDef("지급금액", Remt2300BM.ATTR_PYMTSUM, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setRegEx("^[+-]?\\d*(\\.?\\d*)$");  
            	setSelectOnFocus(true);
        	}
        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Remt2300BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Remt2300BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Remt2300BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Remt2300BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Remt2300BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Remt2300BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> calcSevePayPsnDivCd;   /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//
//        private TextField<String> clutYrMnth;   /** column 정산년월 : clutYrMnth */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> payItemCd;   /** column 급여항목코드 : payItemCd */
//        private TextField<String> pymtDducDivCd;   /** column 지급공제구분코드 : pymtDducDivCd */
//
//        private TextField<String> pymtSum;   /** column 지급금액 : pymtSum */
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
 
        
        return listColumnDefs;
    }
    
    public List<ColumnDef> getRemt3500Def(){
      
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           
     
        
        return listColumnDefs;
    }
    
    
}
