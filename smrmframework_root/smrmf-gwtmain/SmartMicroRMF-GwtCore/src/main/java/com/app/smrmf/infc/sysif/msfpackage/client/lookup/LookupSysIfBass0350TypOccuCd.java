/**
 * 공통화면 팝업 
 */
package com.app.smrmf.infc.sysif.msfpackage.client.lookup;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.languages.MSFConstants;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0350BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0350DTO;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class LookupSysIfBass0350TypOccuCd  extends TableDef implements MSFPkgDaoConstants {

  
	 private MSFConstants lblSysIfConst = MSFConstants.INSTANCE;

    public LookupSysIfBass0350TypOccuCd(){
     //   setTitle(lblSysmConst.titleSysComComboBass0350());
        setDaoClass("");     
        setCustomListMethod(MSFPKG_METHOD_COMBO_BASS0350TypOccuCd_List);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        /** column 사업장코드 : dpobCd */
//        listColumnDefs.add(new ColumnDef("사업장코드", Bass0350BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, true, true){
//        	{
//
//        	}
//        });
       
        /** column 직종  : typOccuCd  */
        listColumnDefs.add(new ColumnDef("직종코드", SysIfBass0350BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", SysIfBass0350BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
          
        
        setColumnsDefinition(listColumnDefs);
    }
    
    public LookupSysIfBass0350TypOccuCd(SysIfBass0350DTO sysIfBass0350Dto) {
        this();
       // addColumnFilter("typOccuCd"   , sysComBass0350Dto.getTypOccuCd() , SimpleColumnFilter.OPERATOR_EQUALS);
        
      
    }
}
