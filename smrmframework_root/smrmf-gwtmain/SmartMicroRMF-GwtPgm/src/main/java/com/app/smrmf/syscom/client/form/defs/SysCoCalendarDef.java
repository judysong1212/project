/**
 * 공통화면 팝업 
 */
package com.app.smrmf.syscom.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.syscom.client.dto.SysCoCalendarBM;
import com.app.smrmf.syscom.client.languages.SysComConstants;
import com.app.smrmf.syscom.shared.SysComDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class SysCoCalendarDef  extends TableDef implements SysComDaoConstants {

    private int row = 0;
    private SysComConstants SysComLabel = SysComConstants.INSTANCE;

    public SysCoCalendarDef(){
        setTitle("");
        setDaoClass("");
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
      /** column null : calendarDate */
      listColumnDefs.add(new ColumnDef("null", SysCoCalendarBM.ATTR_CALENDARDATE, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column null : year */
      listColumnDefs.add(new ColumnDef("null", SysCoCalendarBM.ATTR_YEAR, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column null : month */
      listColumnDefs.add(new ColumnDef("null", SysCoCalendarBM.ATTR_MONTH, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column null : yyyymm */
      listColumnDefs.add(new ColumnDef("null", SysCoCalendarBM.ATTR_YYYYMM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column null : yymm */
      listColumnDefs.add(new ColumnDef("null", SysCoCalendarBM.ATTR_YYMM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column null : day */
      listColumnDefs.add(new ColumnDef("null", SysCoCalendarBM.ATTR_DAY, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column null : halfYear */
      listColumnDefs.add(new ColumnDef("null", SysCoCalendarBM.ATTR_HALFYEAR, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column null : quarterYear */
      listColumnDefs.add(new ColumnDef("null", SysCoCalendarBM.ATTR_QUARTERYEAR, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column null : dayOfWeek */
      listColumnDefs.add(new ColumnDef("null", SysCoCalendarBM.ATTR_DAYOFWEEK, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column null : offdayKubn */
      listColumnDefs.add(new ColumnDef("null", SysCoCalendarBM.ATTR_OFFDAYKUBN, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
//      /** column null : rgstryUser */
//      listColumnDefs.add(new ColumnDef("null", MSFCoCalendarBM.ATTR_RGSTRYUSER, ColumnDef.TYPE_STRING , 90, true, false, true){
//      	{
  //
//      	}
//      });
//      /** column null : rgstryDt */
//      listColumnDefs.add(new ColumnDef("null", MSFCoCalendarBM.ATTR_RGSTRYDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//      	{
  //
//      	}
//      });
//      /** column null : updateUser */
//      listColumnDefs.add(new ColumnDef("null", MSFCoCalendarBM.ATTR_UPDATEUSER, ColumnDef.TYPE_STRING , 90, true, false, true){
//      	{
  //
//      	}
//      });
//      /** column null : updateDt */
//      listColumnDefs.add(new ColumnDef("null", MSFCoCalendarBM.ATTR_UPDATEDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//      	{
  //
//      	}
//      });
  //
//      private TextField<String> calendarDate   /** column null : calendarDate */
  //
//      private TextField<String> year   /** column null : year */
  //
//      private TextField<String> month   /** column null : month */
  //
//      private TextField<String> yyyymm   /** column null : yyyymm */
  //
//      private TextField<String> yymm   /** column null : yymm */
  //
//      private TextField<String> day   /** column null : day */
  //
//      private TextField<String> halfYear   /** column null : halfYear */
  //
//      private TextField<String> quarterYear   /** column null : quarterYear */
  //
//      private TextField<String> dayOfWeek   /** column null : dayOfWeek */
  //
//      private TextField<String> offdayKubn   /** column null : offdayKubn */
  //
//      private TextField<String> rgstryUser   /** column null : rgstryUser */
  //
//      private TextField<String> rgstryDt   /** column null : rgstryDt */
  //
//      private TextField<String> updateUser   /** column null : updateUser */
  //
//      private TextField<String> updateDt   /** column null : updateDt */

        
        setColumnsDefinition(listColumnDefs);
    }
}
