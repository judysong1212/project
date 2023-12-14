/**
 * 공통화면 팝업 
 */
package com.app.exterms.prgm.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComP0500BM;
import com.app.exterms.prgm.client.languages.PrgmConstants;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class PrgmComP0500Def  extends TableDef implements PrgmComDaoConstants {

    private int row = 0;
    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;

    public PrgmComP0500Def(){
        setTitle(SysComLabel.titleSysComPopUpBass0300());
        setDaoClass(CLASS_SYSCOM_BASS0300VO);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
      

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", PrgmComP0500BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        
        /** column 지급공제구분코드  : pymtDducDivCd */
        listColumnDefs.add(new ColumnDef("지급공제구분코드", PrgmComP0500BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        
        /** column 지급공제구분  : pymtDducDivCd */
        listColumnDefs.add(new ColumnDef("지급공제", PrgmComP0500BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        
        /** column 급여수당코드 : payExtpyCd */
        listColumnDefs.add(new ColumnDef("급여수당코드", PrgmComP0500BM.ATTR_PAYEXTPYCD, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 급여수당명 : payExtpyNm */
        listColumnDefs.add(new ColumnDef("급여수당명", PrgmComP0500BM.ATTR_PAYEXTPYNM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 급여수당그룹코드 : payExtpyGrpCd */
        listColumnDefs.add(new ColumnDef("급여수당그룹코드", PrgmComP0500BM.ATTR_PAYEXTPYGRPCD, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 수당그룹 : payExtpyGrpCd */
        listColumnDefs.add(new ColumnDef("수당공제그룹", PrgmComP0500BM.ATTR_PAYEXTPYGRPNM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        
        /** column 급여수당공제금액 : payExtpySum */
        listColumnDefs.add(new ColumnDef("수당공제금액", PrgmComP0500BM.ATTR_PAYEXTPYSUM, ColumnDef.TYPE_LONG , 90, false, false, true){
            {

            }
        });
        /** column 급여수당공제비율 : payExtpyRto */
        listColumnDefs.add(new ColumnDef("수당공제비율", PrgmComP0500BM.ATTR_PAYEXTPYRTO, ColumnDef.TYPE_DOUBLE , 90, false, false, true){
            {

            }
        });
      
        /** column 사용여부 : payExtpyUseYn */
        listColumnDefs.add(new ColumnDef("사용여부", PrgmComP0500BM.ATTR_PAYEXTPYUSEYN, ColumnDef.TYPE_BOOLEAN , 90, false, false, true){
            {

            }
        });
         
        
        setColumnsDefinition(listColumnDefs);
    }
}
