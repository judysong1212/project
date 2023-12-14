/**
 * 공통화면 팝업 
 */
package com.app.exterms.prgm.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0400BM;
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
public class PrgmComBass0400Def  extends TableDef implements PrgmComDaoConstants {

    private int row = 0;
    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;

    public PrgmComBass0400Def(){
        setTitle(SysComLabel.titleSysComPopUpBass0400());
        setDaoClass(CLASS_SYSCOM_BASS0400VO);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        /** DPOB_CD */
        listColumnDefs.add(new ColumnDef("사업장코드", PrgmComBass0400BM.ATTR_DPOBCD,  ColumnDef.TYPE_STRING, 100, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row));
            }
        });
        listColumnDefs.add(new ColumnDef("부서코드", PrgmComBass0400BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 100));
            }
        });
          
        /** DEPT_NM_HAN */
        listColumnDefs.add(new ColumnDef("부서명", PrgmComBass0400BM.ATTR_DEPTNMHAN,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** DEPT_NM_RTCHNT */
        listColumnDefs.add(new ColumnDef("부서약어명", PrgmComBass0400BM.ATTR_DEPTNMRTCHNT,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** DEPT_NM_ENG */
        listColumnDefs.add(new ColumnDef("부서영문명", PrgmComBass0400BM.ATTR_DEPTNMENG,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** TPLVL_DEPT_CD */
        listColumnDefs.add(new ColumnDef("최상위부서", PrgmComBass0400BM.ATTR_TPLVLDEPTCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** HHRK_DEPT_CD */
        listColumnDefs.add(new ColumnDef("상위부서", PrgmComBass0400BM.ATTR_HHRKDEPTCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** DEPT_USE_YN */
        listColumnDefs.add(new ColumnDef("사용여부", PrgmComBass0400BM.ATTR_DEPTUSEYN,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** NAT_PENN_SYM */
        listColumnDefs.add(new ColumnDef("국민연금기호", PrgmComBass0400BM.ATTR_NATPENNSYM,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** HLTH_INSR_SYM */
        listColumnDefs.add(new ColumnDef("건강보험기호", PrgmComBass0400BM.ATTR_HLTHINSRSYM,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** UMYT_INSR_SYM */
        listColumnDefs.add(new ColumnDef("고용보험기호", PrgmComBass0400BM.ATTR_UMYTINSRSYM,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** IDTL_ACCDT_INSUR_SYM */
        listColumnDefs.add(new ColumnDef("산재보험기호", PrgmComBass0400BM.ATTR_IDTLACCDTINSURSYM,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** DEPT_NOTE_CTNT */
        listColumnDefs.add(new ColumnDef("비고", PrgmComBass0400BM.ATTR_DEPTNOTECTNT,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });

        /** DEPT_DSPY_YN 부서출력여부*/
        listColumnDefs.add(new ColumnDef("부서출력여부", PrgmComBass0400BM.ATTR_DEPTDSPYYN,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** MANGE_DEPT_CD 관리부서코드 */
        listColumnDefs.add(new ColumnDef("관리부서코드", PrgmComBass0400BM.ATTR_MANGEDEPTCD,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** MANGE_DEPT_NM 관리부서명 */
        listColumnDefs.add(new ColumnDef("관리부서명", PrgmComBass0400BM.ATTR_MANGEDEPTNM,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** MANGE_DEPT_NM 관리부서약어명 */
        listColumnDefs.add(new ColumnDef("관리부서약어", PrgmComBass0400BM.ATTR_MANGEDEPTNMRTCHNT,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        }); 
 
        /** column null : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관코드", PrgmComBass0400BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
     
        /** column 부서순서 : deptRank */
        listColumnDefs.add(new ColumnDef("부서순서", PrgmComBass0400BM.ATTR_DEPTRANK, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
     
        
        setColumnsDefinition(listColumnDefs);
    }
}
