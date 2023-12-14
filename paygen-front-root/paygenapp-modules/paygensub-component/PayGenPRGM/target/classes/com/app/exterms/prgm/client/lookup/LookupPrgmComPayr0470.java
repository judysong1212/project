/**
 * 공통화면 팝업 
 */
package com.app.exterms.prgm.client.lookup;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComPayr0470BM;
import com.app.exterms.prgm.client.dto.PrgmComPayr0470DTO;
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
public class LookupPrgmComPayr0470  extends TableDef implements PrgmComDaoConstants {

  
    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;

    public LookupPrgmComPayr0470(){
        setTitle(SysComLabel.titleSysComPopUpPayr0470());
        setDaoClass("");
        setCustomListMethod(PRGMCOM_METHOD_COMBO_PAYR0470_LIST);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
       
        /** column 급여공제코드 : payDducCd */
        listColumnDefs.add(new ColumnDef("공제코드", PrgmComPayr0470BM.ATTR_PAYDDUCCD, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
       
        /** column 급여공제명 : payDducNm */
        listColumnDefs.add(new ColumnDef("공제명", PrgmComPayr0470BM.ATTR_PAYDDUCNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        }); 
          
        
        setColumnsDefinition(listColumnDefs);
    }
    
    public LookupPrgmComPayr0470(PrgmComPayr0470DTO sysComPayr0470Dto) {
        this();
       
        addColumnFilter("pymtDducDivCd"   , sysComPayr0470Dto.getPymtDducDivCd() , SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("payDducNm", sysComPayr0470Dto.getPayDducNm(), SimpleColumnFilter.OPERATOR_LIKE);
        addColumnFilter("payDducUseYn", sysComPayr0470Dto.getPayDducUseYn(), SimpleColumnFilter.OPERATOR_EQUALS); 
    }
}
