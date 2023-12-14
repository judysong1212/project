package com.app.exterms.personal.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0100View01BM;
import com.app.exterms.personal.client.languages.PsnlConstants;
import com.app.exterms.personal.shared.PsnlDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Psnl0100View01Def  extends TableDef implements PsnlDaoConstants {

    private int row = 0;
    private PsnlConstants psnlLabel = PsnlConstants.INSTANCE;

    public Psnl0100View01Def(){
	        setTitle("");
//	        setDaoClass("CLASS_PSNL0100_DATA_LIST");
//	        setCustomListMethod(CLASS_PSNL0100_DATA_LIST);
	        setColumnsDefinition(getPsnl0100ViewColumnsList());
	        setAutoFillGrid(true);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(false);
	        setEditFieldGrid(false);
	        
    
    }
    

    private List<ColumnDef> getPsnl0100ViewColumnsList(){
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        listColumnDefs.add(new ColumnDef("구분", Psnl0100View01BM.ATTR_ITEM01, ColumnDef.TYPE_STRING , 60, false, true, true){
        	{

        	}
        });
        
        listColumnDefs.add(new ColumnDef("내용", Psnl0100View01BM.ATTR_ITEM02, ColumnDef.TYPE_STRING , 60, false, true, true){
        	{

        	}
        });
        
        listColumnDefs.add(new ColumnDef("주민번호", Psnl0100View01BM.ATTR_ITEM03, ColumnDef.TYPE_STRING , 100, false, false, false){
        	{

        	}
        });
        
        
        return listColumnDefs;
    }
}