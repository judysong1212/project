/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.InfcPkgPayr0304BM;
import com.app.exterms.payroll.shared.InfcPkgPayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class InfcPkgPayr0304Def  extends TableDef implements InfcPkgPayrDaoConstants {

    private int row = 0;
    //private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    

    public InfcPkgPayr0304Def(String chkPayrDef){
    	
        
      if ("INSRP410003".equals(chkPayrDef)) {  
          setTitle(""); 
          setDaoClass("");
          setCustomListMethod(CLASS_PAYR0304TOINSRP410003_DATA_LIST);
          setAutoFillGrid(false);
          setShowFilterToolbar(false); 
          
          setCheckBoxOnGridRows(true); 

          setColumnsDefinition(getPayr0304ToInsrP410003ColumnsList());
          
      }   
        
    }
    
    

private List<ColumnDef> getPayr0304ToInsrP410003ColumnsList(){
    row = 0;
    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

    /** column 사업장코드 : dpobCd */
    listColumnDefs.add(new ColumnDef("사업장코드", InfcPkgPayr0304BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        {

        }
    });
    
    /** column 지급년도 : pymtYr */
    listColumnDefs.add(new ColumnDef("지급년도", InfcPkgPayr0304BM.ATTR_PYMTYR, ColumnDef.TYPE_STRING, 60, false, true, true){
    	{
          
    	}
    });
    /** column SYSTEMKEY : systemkey */
    listColumnDefs.add(new ColumnDef("SYSTEMKEY", InfcPkgPayr0304BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
  
     
    /** column 고용구분코드 : emymtDivCd */
    listColumnDefs.add(new ColumnDef("고용구분코드", InfcPkgPayr0304BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 고용구분 : emymtDivNm */
    listColumnDefs.add(new ColumnDef("고용구분", InfcPkgPayr0304BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 한글성명 : hanNm */
    listColumnDefs.add(new ColumnDef("성명", InfcPkgPayr0304BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 50, true, true, true){
    	{

    	}
    });
    /** column 주민등록번호 : resnRegnNum */
    listColumnDefs.add(new ColumnDef("주민등록번호", InfcPkgPayr0304BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 80, true, true, true){
    	{

    	}
    });

    /** column 주민등록번호 : secRegnNum */
    listColumnDefs.add(new ColumnDef("주민등록번호", InfcPkgPayr0304BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
    	{

    	}
    });
	
    /** column 부서코드 : deptCd */
    listColumnDefs.add(new ColumnDef("부서코드", InfcPkgPayr0304BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 120, false, false, true){
    	{

    	}
    });
    /** column 사업코드 : businCd */
    listColumnDefs.add(new ColumnDef("사업코드", InfcPkgPayr0304BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    /** column 직종코드 : typOccuCd */
    listColumnDefs.add(new ColumnDef("직종코드", InfcPkgPayr0304BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    /** column 직종세구분코드 : dtilOccuClsDivCd */
    listColumnDefs.add(new ColumnDef("직종세구분코드", InfcPkgPayr0304BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 부서 : deptNm */
    listColumnDefs.add(new ColumnDef("부서명", InfcPkgPayr0304BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true){
    	{

    	}
    });
  

	/** column 건강보험증번호 : hlthInsrCertNum */
	listColumnDefs.add(new ColumnDef("건강보험증번호", InfcPkgPayr0304BM.ATTR_HLTHINSRCERTNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
		{

		}
	});
    /** column 건강보험취득일자 : hlthInsrAqtnDt */
	listColumnDefs.add(new ColumnDef("건강보험취득일자", InfcPkgPayr0304BM.ATTR_HLTHINSRAQTNDT, ColumnDef.TYPE_STRING , 90, true, true, true){
		{

		}
	});
	
    /** column 직종 : typOccuNm */
    listColumnDefs.add(new ColumnDef("직종", InfcPkgPayr0304BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, true, true){
    	{

    	}
    });
    /** column 직종세 : dtilOccuClsDivNm */
    listColumnDefs.add(new ColumnDef("직종세", InfcPkgPayr0304BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
    	{

    	}
    });
    /** column 사업 : businNm */
    listColumnDefs.add(new ColumnDef("사업명", InfcPkgPayr0304BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        {

        }
    });
   
    /** column 호봉코드 : pyspCd */
    listColumnDefs.add(new ColumnDef("호봉코드", InfcPkgPayr0304BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    /** column 호봉등급코드 : pyspGrdeCd */
    listColumnDefs.add(new ColumnDef("호봉등급코드", InfcPkgPayr0304BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
   
    
//  private TextField<String> addIncmTxApptnRtoCd;   /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */

//  private TextField<String> addIncmTxApptnYrMnth;   /** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
    
    return listColumnDefs;
}
  
 
 
}
