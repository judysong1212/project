/**
 * 공통화면 팝업 
 */
package com.app.smrmf.core.msfmainapp.client.def;

import java.util.ArrayList;
import java.util.List;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class ShowMessageDef  extends TableDef  {
   
    public static final String PAYGEN_INFO   = "정보";
    public static final String PAYGEN_WORN   = "경고";
    public static final String PAYGEN_CONFIRM   = "확인";
    public static final String PAYGEN_ERROR   = "에러";
    
    protected List<ColumnDef> listColumnDefs;

    public ShowMessageDef() {
        super();
        setTitle("메시지정보");
        setAutoFillGrid(false); 
        setShowFilterToolbar(false);

       // this.customListMethod = MSFConfiguration.CUSTOM_SERVICE_DATA_HISTORY_LIST; 
        listColumnDefs = new ArrayList<ColumnDef>();
        
        listColumnDefs.add(new ColumnDef("구분",   "division",    ColumnDef.TYPE_STRING,  100, false, true,  false));
        listColumnDefs.add(new ColumnDef("메뉴",      "menu",   ColumnDef.TYPE_STRING,  120, false, true,  false));
        listColumnDefs.add(new ColumnDef("단계", "phase",    ColumnDef.TYPE_STRING,    150, false, true,  false));
        listColumnDefs.add(new ColumnDef("메시지", "message",    ColumnDef.TYPE_STRING,    250, false, true,  false));
        listColumnDefs.add(new ColumnDef("설명/", "content",    ColumnDef.TYPE_STRING,    500, false, true,  false){
        	
        	//white-space:normal !important;
        });
//        listColumnDefs.add("구분",      "division",        ColumnDef.TYPE_STRING,  130, false, true,  false){{
//            //setFormatDate(DateTimeFormat.getFormat("dd.MM.yyyy HH:mm:ss"));
//        }});
        setColumnsDefinition(listColumnDefs);

        setReadOnly(true);
    }
}
