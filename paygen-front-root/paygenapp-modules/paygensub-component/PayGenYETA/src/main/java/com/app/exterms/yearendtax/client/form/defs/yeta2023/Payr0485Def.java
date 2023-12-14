/**
 * 공통화면 팝업 
 */
package com.app.exterms.yearendtax.client.form.defs.yeta2023;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2023.Payr0485BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0485Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    

    public Payr0485Def(String chkPayrDef){
//    	 setTitle(PayrLabel.titlePayr0304());
       
        
//        if ("".equals(chkPayrDef)) { 
//        	
//        	 setDaoClass(CLASS_PAYR0304_DATA_LIST);
//             setCustomListMethod(CLASS_PAYR0304_DATA_LIST);
//             setAutoFillGrid(false);
//             setShowFilterToolbar(false);
//            // setCustomListMethod(MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL);
//             setCheckBoxOnGridRows(true); 
//
//             setColumnsDefinition(getPayr0304Def());
//         
//       } 
//        else
        if ("PAYR4200".equals(chkPayrDef)) {  
          	
          setDaoClass("");
//          setCustomListMethod(CLASS_PAYR0304TOPAYR4200_DATA_LIST);
          setAutoFillGrid(false);
          setShowFilterToolbar(false); 
          
          setCheckBoxOnGridRows(true); 

          setColumnsDefinition(getPayr0304ToPayr4420ColumnsList());
          
      }
//       else if ("PAYRP410001".equals(chkPayrDef)) {  
//        	
//        setDaoClass("");
//        setCustomListMethod(CLASS_PAYR0304TOP410001_DATA_LIST);
//        setAutoFillGrid(false);
//        setShowFilterToolbar(false);  
//
//        setColumnsDefinition(getPayr0304ToPayrP410001ColumnsList());
//        
//    } 
//      else if ("PAYRP410002".equals(chkPayrDef)) {  
//    	
//	    setDaoClass("");
//	    setCustomListMethod(CLASS_PAYR0304TOP410002_DATA_LIST);
//	    setAutoFillGrid(true);
//	    setShowFilterToolbar(false);  
//	    setCheckBoxOnGridRows(true);
//	    setColumnsDefinition(getPayr0304ToPayrP410002ColumnsList());
//    
//   }
        
        
        
    }
    
    

private List<ColumnDef> getPayr0304ToPayr4420ColumnsList(){
    row = 0;
    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

    /** column 사업장코드 : dpobCd */
    listColumnDefs.add(new ColumnDef("사업장코드", Payr0485BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 고용구분코드 : emymtDivCd */
    listColumnDefs.add(new ColumnDef("고용구분코드", Payr0485BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 급여항목코드 : payItemCd */
    listColumnDefs.add(new ColumnDef("급여항목코드", Payr0485BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 회계계정코드 : accAccCd */
    listColumnDefs.add(new ColumnDef("회계계정코드", Payr0485BM.ATTR_ACCACCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 퇴직적용여부 : sevePayYn */
    listColumnDefs.add(new ColumnDef("퇴직적용여부", Payr0485BM.ATTR_SEVEPAYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 연말정산_기부금코드 : yrtxDotnCd */
    listColumnDefs.add(new ColumnDef("연말정산_기부금코드", Payr0485BM.ATTR_YRTXDOTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */
    listColumnDefs.add(new ColumnDef("연말정산_비과세감면코드", Payr0485BM.ATTR_YRTXFREEDTYREDUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 기간제수당사용여부 : payrTermUseYn */
    listColumnDefs.add(new ColumnDef("기간제수당사용여부", Payr0485BM.ATTR_PAYRTERMUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 수당공제출력여부 : extptDducDspyYn */
    listColumnDefs.add(new ColumnDef("수당공제출력여부", Payr0485BM.ATTR_EXTPTDDUCDSPYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 수당공제사용여부 : extptDducUseYn */
    listColumnDefs.add(new ColumnDef("수당공제사용여부", Payr0485BM.ATTR_EXTPTDDUCUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 수당공제정렬순서 : extptDducRngeOrd */
    listColumnDefs.add(new ColumnDef("수당공제정렬순서", Payr0485BM.ATTR_EXTPTDDUCRNGEORD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
    	{

    	}
    });
    /** column 입력자 : kybdr */
    listColumnDefs.add(new ColumnDef("입력자", Payr0485BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 입력일자 : inptDt */
    listColumnDefs.add(new ColumnDef("입력일자", Payr0485BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 입력주소 : inptAddr */
    listColumnDefs.add(new ColumnDef("입력주소", Payr0485BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 수정자 : ismt */
    listColumnDefs.add(new ColumnDef("수정자", Payr0485BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 수정일자 : revnDt */
    listColumnDefs.add(new ColumnDef("수정일자", Payr0485BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 수정주소 : revnAddr */
    listColumnDefs.add(new ColumnDef("수정주소", Payr0485BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
        
        return listColumnDefs;
    }
    
    


}
