/**
 * 공통화면 팝업 
 */
package com.app.exterms.prgm.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.languages.PrgmConstants;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.AttributeCustomForm;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class PrgmComBass0300Def  extends TableDef implements PrgmComDaoConstants {

    private int row = 0;
    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;

    public PrgmComBass0300Def(){
        setTitle(SysComLabel.titleSysComPopUpBass0300());
        setDaoClass(CLASS_SYSCOM_BASS0300VO);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        listColumnDefs.add(new ColumnDef("사업장코드", PrgmComBass0300BM.ATTR_DPOBCD,  ColumnDef.TYPE_STRING, 100, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row));
            }
        });
        listColumnDefs.add(new ColumnDef("코드", PrgmComBass0300BM.ATTR_COMMCD, ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 100));
            }
        });
        listColumnDefs.add(new ColumnDef("대표코드", PrgmComBass0300BM.ATTR_RPSTTVCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        listColumnDefs.add(new ColumnDef("세부코드", PrgmComBass0300BM.ATTR_DTLCD,   ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        listColumnDefs.add(new ColumnDef("코드명", PrgmComBass0300BM.ATTR_COMMCDNM, ColumnDef.TYPE_STRING, 200, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
         
         
        listColumnDefs.add(new ColumnDef("약어명", PrgmComBass0300BM.ATTR_ABBRNM,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("영문명", PrgmComBass0300BM.ATTR_ENGNM, ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목01", PrgmComBass0300BM.ATTR_MANGEITEM01,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목02", PrgmComBass0300BM.ATTR_MANGEITEM02,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목03", PrgmComBass0300BM.ATTR_MANGEITEM03, ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목04", PrgmComBass0300BM.ATTR_MANGEITEM04,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목05", PrgmComBass0300BM.ATTR_MANGEITEM05, ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목06", PrgmComBass0300BM.ATTR_MANGEITEM06,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목07", PrgmComBass0300BM.ATTR_MANGEITEM07,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목08", PrgmComBass0300BM.ATTR_MANGEITEM08, ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목09", PrgmComBass0300BM.ATTR_MANGEITEM09, ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목10", PrgmComBass0300BM.ATTR_MANGEITEM10, ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목11", PrgmComBass0300BM.ATTR_MANGEITEM11,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목12", PrgmComBass0300BM.ATTR_MANGEITEM12,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목13", PrgmComBass0300BM.ATTR_MANGEITEM13,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목14", PrgmComBass0300BM.ATTR_MANGEITEM14,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목15", PrgmComBass0300BM.ATTR_MANGEITEM15,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목16", PrgmComBass0300BM.ATTR_MANGEITEM16,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목17", PrgmComBass0300BM.ATTR_MANGEITEM17,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목18", PrgmComBass0300BM.ATTR_MANGEITEM18,   ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목19", PrgmComBass0300BM.ATTR_MANGEITEM19,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("관리항목20", PrgmComBass0300BM.ATTR_MANGEITEM20,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("트리레벨", PrgmComBass0300BM.ATTR_CDTREELVL,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("정렬순서", PrgmComBass0300BM.ATTR_ORD, ColumnDef.TYPE_LONG, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("오픈여부", PrgmComBass0300BM.ATTR_OPNYN,  ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("사용여부", PrgmComBass0300BM.ATTR_USEYN, ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        });
        
        listColumnDefs.add(new ColumnDef("비고", PrgmComBass0300BM.ATTR_NOTE, ColumnDef.TYPE_STRING, 200, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 150, 60));
            }
        }); 
        
        setColumnsDefinition(listColumnDefs);
    }
}
