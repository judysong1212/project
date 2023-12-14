/**
 * 공통화면 팝업 
 */
package com.app.smrmf.infc.sysif.msfpackage.client.lookup;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.languages.MSFConstants;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400DTO;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class LookupSysIfBass0400  extends TableDef implements MSFPkgDaoConstants {

  
	private MSFConstants lblSysIfConst = MSFConstants.INSTANCE;

    public LookupSysIfBass0400(){
        //setTitle(lblSysmConst.titleSysComPopUpBass0500());
        setDaoClass("");
        setCustomListMethod(MSFPKG_METHOD_LOOKUP_BASS0400_List);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
       
        /** column 사업장코드 : dpobCd */
     //   listColumnDefs.add(new ColumnDef("사업장코드", SysIfBass0400BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 100, false, true, true)); 
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", SysIfBass0400BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, true, true, true));

        /** column 부서명_한글 : deptNmHan */
       // listColumnDefs.add(new ColumnDef("부서명_한글", SysIfBass0400BM.ATTR_DEPTNMHAN, ColumnDef.TYPE_STRING, 150, true, true, true));

        /** column 부서명_단축 : deptNmRtchnt */
        listColumnDefs.add(new ColumnDef("부서명_단축", SysIfBass0400BM.ATTR_DEPTNMRTCHNT, ColumnDef.TYPE_STRING, 150, true, true, true));

          
        
        setColumnsDefinition(listColumnDefs);
    }
    
    public LookupSysIfBass0400(SysIfBass0400DTO sysComBass0400Dto) {
        this();
        addColumnFilter("chkCombo"   , "combo" , SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("deptCd"   , sysComBass0400Dto.getDeptCd(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("payrMangDeptCd"   , sysComBass0400Dto.getPayrMangDeptCd() , SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeDeptCd"   , sysComBass0400Dto.getMangeDeptCd() , SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("deptNm"   , sysComBass0400Dto.getDeptNm() , SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("deptDspyYn"   , sysComBass0400Dto.getDeptDspyYn() , SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("emymtDivCd"   , "" , SimpleColumnFilter.OPERATOR_EQUALS);
         
      
    }
}
