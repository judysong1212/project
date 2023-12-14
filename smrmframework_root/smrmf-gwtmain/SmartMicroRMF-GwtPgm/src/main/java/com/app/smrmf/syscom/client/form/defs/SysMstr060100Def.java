/**
 * 공통화면 팝업 
 */
package com.app.smrmf.syscom.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.syscom.client.dto.SysMstr060100BM;
import com.app.smrmf.syscom.client.languages.SysComConstants;
import com.app.smrmf.syscom.shared.SysComDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class SysMstr060100Def  extends TableDef implements SysComDaoConstants {

    private int row = 0;
    private SysComConstants SysComLabel = SysComConstants.INSTANCE;

    public SysMstr060100Def(){
        setTitle("");
        setDaoClass("");
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
      /** column 사업장코드 : dpobCd */
      listColumnDefs.add(new ColumnDef("사업장코드", SysMstr060100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{
  
      	}
      });
      /** column 가족수당가산자녀수_이상 : famyAllwAddChdQntyOvr */
      listColumnDefs.add(new ColumnDef("가족수당가산자녀수_이상", SysMstr060100BM.ATTR_FAMYALLWADDCHDQNTYOVR, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{
  
      	}
      });
      /** column 급여채권압류최저압류금지금액 : payBondFrclrMinPhbnSum */
      listColumnDefs.add(new ColumnDef("급여채권압류최저압류금지금액", SysMstr060100BM.ATTR_PAYBONDFRCLRMINPHBNSUM, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{
  
      	}
      });
      /** column 급여채권압류계산적용월금액 : payBondFrclrCalcMnthSum */
      listColumnDefs.add(new ColumnDef("급여채권압류계산적용월금액", SysMstr060100BM.ATTR_PAYBONDFRCLRCALCMNTHSUM, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{
  
      	}
      });
      /** column 입력자 : kybdr */
      listColumnDefs.add(new ColumnDef("입력자", SysMstr060100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{
  
      	}
      });
      /** column 입력일자 : inptDt */
      listColumnDefs.add(new ColumnDef("입력일자", SysMstr060100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{
  
      	}
      });
      /** column 입력주소 : inptAddr */
      listColumnDefs.add(new ColumnDef("입력주소", SysMstr060100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{
  
      	}
      });
      /** column 수정자 : ismt */
      listColumnDefs.add(new ColumnDef("수정자", SysMstr060100BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{
  
      	}
      });
      /** column 수정일자 : revnDt */
      listColumnDefs.add(new ColumnDef("수정일자", SysMstr060100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{
  
      	}
      });
      /** column 수정주소 : revnAddr */
      listColumnDefs.add(new ColumnDef("수정주소", SysMstr060100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{
  
      	}
      });
  
//      private TextField<String> dpobCd   /** column 사업장코드 : dpobCd */
  //
//      private TextField<String> famyAllwAddChdQntyOvr   /** column 가족수당가산자녀수_이상 : famyAllwAddChdQntyOvr */
  //
//      private TextField<String> payBondFrclrMinPhbnSum   /** column 급여채권압류최저압류금지금액 : payBondFrclrMinPhbnSum */
  //
//      private TextField<String> payBondFrclrCalcMnthSum   /** column 급여채권압류계산적용월금액 : payBondFrclrCalcMnthSum */
  //
//      private TextField<String> kybdr   /** column 입력자 : kybdr */
  //
//      private TextField<String> inptDt   /** column 입력일자 : inptDt */
  //
//      private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
  //
//      private TextField<String> ismt   /** column 수정자 : ismt */
  //
//      private TextField<String> revnDt   /** column 수정일자 : revnDt */
  //
//      private TextField<String> revnAddr   /** column 수정주소 : revnAddr */
        
        setColumnsDefinition(listColumnDefs);
    }
}
