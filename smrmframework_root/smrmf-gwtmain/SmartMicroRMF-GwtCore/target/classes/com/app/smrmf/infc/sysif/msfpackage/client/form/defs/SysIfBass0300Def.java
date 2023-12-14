/**
 * 공통화면 팝업 
 */
package com.app.smrmf.infc.sysif.msfpackage.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.AttributeCustomForm;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.languages.MSFConstants;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300BM;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class SysIfBass0300Def  extends TableDef implements MSFPkgDaoConstants {

    private int row = 0;
    private MSFConstants lblSysIfConst = MSFConstants.INSTANCE;

    public SysIfBass0300Def(String chkDef){
    	
    	if("SYSMMTR0500".equals(chkDef)){
    	      	  
    	      	  setTitle("");
    	          setDaoClass(CLASS_SYSMMTR0500TOBASS0300_LIST); 
    	          setCustomListMethod(CLASS_SYSMMTR0500TOBASS0300_LIST);
    	             
    	      	  setShowFilterToolbar(false);   
    	      	  setAutoFillGrid(true);
    	            
    	   	      setColumnsDefinition(getSysmMtr0700ToBass0300ColumnsList()); 
    	   } 
    	        
//    	        else if("BASS0360".equals(chkDef)){
//    	    		setTitle("사용 직종세정보");
//    	            setDaoClass(""); 
//    	            setCustomListMethod(CLASS_BASS0450TOBASS0360_LIST);
//    	      	  	setAutoFillGrid(false);
//    	            setShowFilterToolbar(false);   
//    	   	      	setEditFieldGrid(false);
//    	   	      	setColumnsDefinition(getRightUpColumnsList()); 
//    	    	}else if("BASS0350".equals(chkDef)){
//    	    		setTitle("미사용 직종세정보");
//    	            setDaoClass(""); 
//    	            setCustomListMethod(CLASS_BASS0450TOBASS0350_LIST);
//    	      	  	setAutoFillGrid(false);
//    	            setShowFilterToolbar(false);   
//    	   	      	setEditFieldGrid(false);
//    	   	      	setColumnsDefinition(getRightDownColumnsList()); 
//    	    	} 
    }    	 
    
    
    private List<ColumnDef> getSysmMtr0700ToBass0300ColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        listColumnDefs.add(new ColumnDef("사업장코드", SysIfBass0300BM.ATTR_DPOBCD,  ColumnDef.TYPE_STRING, 100, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row));
            }
        });
        listColumnDefs.add(new ColumnDef("코드", SysIfBass0300BM.ATTR_COMMCD, ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 100));
            }
        });
        listColumnDefs.add(new ColumnDef("대표코드", SysIfBass0300BM.ATTR_RPSTTVCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        listColumnDefs.add(new ColumnDef("세부코드", SysIfBass0300BM.ATTR_DTLCD,   ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        listColumnDefs.add(new ColumnDef("코드명", SysIfBass0300BM.ATTR_COMMCDNM, ColumnDef.TYPE_STRING, 200, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
         
         
        listColumnDefs.add(new ColumnDef("약어명", SysIfBass0300BM.ATTR_ABBRNM,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("영문명", SysIfBass0300BM.ATTR_ENGNM, ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목01", SysIfBass0300BM.ATTR_MANGEITEM01,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목02", SysIfBass0300BM.ATTR_MANGEITEM02,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목03", SysIfBass0300BM.ATTR_MANGEITEM03, ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목04", SysIfBass0300BM.ATTR_MANGEITEM04,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목05", SysIfBass0300BM.ATTR_MANGEITEM05, ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목06", SysIfBass0300BM.ATTR_MANGEITEM06,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목07", SysIfBass0300BM.ATTR_MANGEITEM07,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목08", SysIfBass0300BM.ATTR_MANGEITEM08, ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목09", SysIfBass0300BM.ATTR_MANGEITEM09, ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목10", SysIfBass0300BM.ATTR_MANGEITEM10, ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목11", SysIfBass0300BM.ATTR_MANGEITEM11,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목12", SysIfBass0300BM.ATTR_MANGEITEM12,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목13", SysIfBass0300BM.ATTR_MANGEITEM13,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목14", SysIfBass0300BM.ATTR_MANGEITEM14,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목15", SysIfBass0300BM.ATTR_MANGEITEM15,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목16", SysIfBass0300BM.ATTR_MANGEITEM16,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목17", SysIfBass0300BM.ATTR_MANGEITEM17,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목18", SysIfBass0300BM.ATTR_MANGEITEM18,   ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목19", SysIfBass0300BM.ATTR_MANGEITEM19,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목20", SysIfBass0300BM.ATTR_MANGEITEM20,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("트리레벨", SysIfBass0300BM.ATTR_CDTREELVL,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("정렬순서", SysIfBass0300BM.ATTR_ORD, ColumnDef.TYPE_LONG, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("오픈여부", SysIfBass0300BM.ATTR_OPNYN,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("사용여부", SysIfBass0300BM.ATTR_USEYN, ColumnDef.TYPE_BOOLEAN, 200, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("비고", SysIfBass0300BM.ATTR_NOTE, ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        }); 
        
 
        return listColumnDefs;
    }
    
     
}
