/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0460BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0460Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE; 

    
    
    public Payr0460Def(String chkDef){ 
     	 
    	if ("PAYR0460".equals(chkDef)) {
    		
    		 setTitle(PayrLabel.titlePayr0460());
    	     setDaoClass("");
    	     setCustomListMethod(CLASS_PAYR0460_DATA_LIST);
  	         setAutoFillGrid(false); 
	         setShowFilterToolbar(false);
	         setCheckBoxOnGridRows(true);
	         setEditFieldGrid(true);
	         
	         setColumnsDefinition(getPayr0460Def());
	         
    	} else if ("PAYR0480".equals(chkDef)) {
    		
    	    setTitle(PayrLabel.titlePayr0460());
  	        setDaoClass("");
  	        setCustomListMethod(CLASS_PAYR0460_PAYR5500_DATA_LIST);
  	        setAutoFillGrid(false); 
	        setShowFilterToolbar(false);
	       
	         
	        setColumnsDefinition(getPayr0460ToPayr5500());
    	}  
    }
    
 public List<ColumnDef> getPayr0460ToPayr5500(){
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        /** column 급여년도 : payYr */
        listColumnDefs.add(new ColumnDef("년도", Payr0460BM.ATTR_PAYYR, ColumnDef.TYPE_STRING, 50, false, true, true){
        	{

        	}
        });
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0460BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 급여수당코드 : payExtpyCd */
        listColumnDefs.add(new ColumnDef("급여수당코드", Payr0460BM.ATTR_PAYEXTPYCD, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
     
        /** column 급여수당명 : payExtpyNm */
        listColumnDefs.add(new ColumnDef("급여수당명", Payr0460BM.ATTR_PAYEXTPYNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{

        	}
        });
        return listColumnDefs;
    }
 
    
    public List<ColumnDef> getPayr0460Def(){
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** column 급여년도 : payYr */
        listColumnDefs.add(new ColumnDef("년도", Payr0460BM.ATTR_PAYYR, ColumnDef.TYPE_STRING, 50, false, true, true){
        	{

        	}
        });
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0460BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 급여항목코드 : payItemCd */
        listColumnDefs.add(new ColumnDef("수당코드", Payr0460BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            {

            }
        });

        /** column 급여항목 : payItemNm */
        listColumnDefs.add(new ColumnDef("수당명", Payr0460BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 100, false, true, true){
            {
              setReadOnly(true);
            }
        });
        /** column 직책_직종세코드 : odtyDtilOccuClsCd */
        listColumnDefs.add(new ColumnDef("직책_직종세코드", Payr0460BM.ATTR_ODTYDTILOCCUCLSCD, ColumnDef.TYPE_STRING, 100, false, false, true){
        	{

        	}
        });
        
        /** column 직책_직종세 : odtyDtilOccuClsNm */
        listColumnDefs.add(new ColumnDef("직책(직종세)", Payr0460BM.ATTR_ODTYDTILOCCUCLSNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{
        	    setReadOnly(true);
        	}
        });
      
        
        /** column 직책_직종세수당금액 : odtyDtilOccuClsSum */
        listColumnDefs.add(new ColumnDef("수당금액", Payr0460BM.ATTR_ODTYDTILOCCUCLSSUM, ColumnDef.TYPE_LONG, 90, false, true, true){
        	{

        	}
        });
        /** column 직책_직종세수당삭제여부 : odtyDtilOccuClsDelYn */
        listColumnDefs.add(new ColumnDef("삭제", Payr0460BM.ATTR_ODTYDTILOCCUCLSDELYN, ColumnDef.TYPE_BOOLEAN, 50, false, true, true){
            {

            }
        });
      
        /** column 직책_직종세수당비고내용 : odtyDtilOccuClsNoteCtnt */
        listColumnDefs.add(new ColumnDef("비고", Payr0460BM.ATTR_ODTYDTILOCCUCLSNOTECTNT, ColumnDef.TYPE_STRING, 250, false, true, true){
        	{

        	}
        });
      

//        private TextField<String> payYr   /** column 급여년도 : payYr */
//
//        private TextField<String> dpobCd   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> odtyDtilOccuClsCd   /** column 직책_직종세코드 : odtyDtilOccuClsCd */
//
//        private TextField<String> payItemCd   /** column 급여항목코드 : payItemCd */
//
//        private TextField<String> odtyDtilOccuClsSum   /** column 직책_직종세수당금액 : odtyDtilOccuClsSum */
//
//        private TextField<String> odtyDtilOccuClsNoteCtnt   /** column 직책_직종세수당비고내용 : odtyDtilOccuClsNoteCtnt */
//
//        private TextField<String> odtyDtilOccuClsDelYn   /** column 직책_직종세수당삭제여부 : odtyDtilOccuClsDelYn */
//
//        private TextField<String> kybdr   /** column 입력자 : kybdr */
//
//        private TextField<String> inptDt   /** column 입력일자 : inptDt */
//
//        private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
//
//        private TextField<String> ismt   /** column 수정자 : ismt */
//
//        private TextField<String> revnDt   /** column 수정일자 : revnDt */
//
//        private TextField<String> revnAddr   /** column 수정주소 : revnAddr */

        return listColumnDefs;
    }
}
