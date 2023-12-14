/**
 * 공통화면 팝업 
 */
package com.app.exterms.prgm.client.lookup;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComPayr0480BM;
import com.app.exterms.prgm.client.dto.PrgmComPayr0480DTO;
import com.app.exterms.prgm.client.languages.PrgmConstants;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class LookupPrgmComPayr0480  extends TableDef implements PrgmComDaoConstants {

  
    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;

    public LookupPrgmComPayr0480(){
        setTitle(SysComLabel.titleSysComPopUpPayr0480());
        setDaoClass("");
        setCustomListMethod(PRGMCOM_METHOD_COMBO_PAYR0480_LIST);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
       
        /** column 급여수당코드 : payExtpyCd */
        listColumnDefs.add(new ColumnDef("수당코드", PrgmComPayr0480BM.ATTR_PAYEXTPYCD, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
     
        /** column 급여수당명 : payExtpyNm */
        listColumnDefs.add(new ColumnDef("수당명", PrgmComPayr0480BM.ATTR_PAYEXTPYNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{

        	}
        }); 
          
        
        setColumnsDefinition(listColumnDefs);
    }
    
    public LookupPrgmComPayr0480(PrgmComPayr0480DTO sysComPayr0480Dto) {
        this();
        
        addColumnFilter("pymtDducDivCd"   , sysComPayr0480Dto.getPymtDducDivCd() , SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("payExtpyNm", sysComPayr0480Dto.getPayExtpyNm(), SimpleColumnFilter.OPERATOR_LIKE);
       
      
    }
}
