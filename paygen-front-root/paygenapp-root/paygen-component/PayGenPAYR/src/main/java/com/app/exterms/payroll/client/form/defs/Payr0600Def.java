/**
 * 공통화면 팝업
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0600BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * ====================================================
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
 * extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow {
 * 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Payr0600Def extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    public Payr0600Def() {
        setTitle(PayrLabel.titlePayr0600());
        setDaoClass(CLASS_PAYR0600_DATA_LIST);
        setAutoFillGrid(false);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();

        /** column 일용근로소득귀속년도 : dilWrkrIncmBlggYr */
        listColumnDefs.add(new ColumnDef("일용근로소득귀속년도", Payr0600BM.ATTR_DILWRKRINCMBLGGYR, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 일용근로소득귀속분기구분코드 : dilWrkrBlggQatrDivCd */
        listColumnDefs.add(new ColumnDef("일용근로소득귀속분기구분코드", Payr0600BM.ATTR_DILWRKRBLGGQATRDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 단위기관코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관코드", Payr0600BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0600BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 일용근로자소득제출자료건수 : dilWrkrIncmSumtDataNum */
        listColumnDefs.add(new ColumnDef("일용근로자소득제출자료건수", Payr0600BM.ATTR_DILWRKRINCMSUMTDATANUM, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 일용근로자소득제출일자 : dilWrkrIncmSumtDt */
        listColumnDefs.add(new ColumnDef("일용근로자소득제출일자", Payr0600BM.ATTR_DILWRKRINCMSUMTDT, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 대표자성명 : degtrNm */
        listColumnDefs.add(new ColumnDef("대표자성명", Payr0600BM.ATTR_DEGTRNM, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 법인명_상호 : corpNmFmnm */
        listColumnDefs.add(new ColumnDef("법인명_상호", Payr0600BM.ATTR_CORPNMFMNM, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 사업자등록번호 : busoprRgstnNum */
        listColumnDefs.add(new ColumnDef("사업자등록번호", Payr0600BM.ATTR_BUSOPRRGSTNNUM, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0600BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 주민등록번호 : secRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0600BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false) {{
        }});

        /** column 법인번호 : corpNum */
        listColumnDefs.add(new ColumnDef("법인번호", Payr0600BM.ATTR_CORPNUM, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 소득신고의무자우편번호 : incmRegrstDebrZpcd */
        listColumnDefs.add(new ColumnDef("소득신고의무자우편번호", Payr0600BM.ATTR_INCMREGRSTDEBRZPCD, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 소득신고의무자기본주소 : incmRegrstDebrFndtnAddr */
        listColumnDefs.add(new ColumnDef("소득신고의무자기본주소", Payr0600BM.ATTR_INCMREGRSTDEBRFNDTNADDR, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 소득신고의무자상세주소 : incmRegrstDebrDtlPatrAddr */
        listColumnDefs.add(new ColumnDef("소득신고의무자상세주소", Payr0600BM.ATTR_INCMREGRSTDEBRDTLPATRADDR, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 관할세무서코드 : juriTxOffcCd */
        listColumnDefs.add(new ColumnDef("관할세무서코드", Payr0600BM.ATTR_JURITXOFFCCD, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 제출자구분코드 : pentrCd */
        listColumnDefs.add(new ColumnDef("제출자구분코드", Payr0600BM.ATTR_PENTRCD, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 세무대리인번호 : txDeptyNum */
        listColumnDefs.add(new ColumnDef("세무대리인번호", Payr0600BM.ATTR_TXDEPTYNUM, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 홈텍스ID : hmtxId */
        listColumnDefs.add(new ColumnDef("홈텍스ID", Payr0600BM.ATTR_HMTXID, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 세무프로그램코드 : txPgmCd */
        listColumnDefs.add(new ColumnDef("세무프로그램코드", Payr0600BM.ATTR_TXPGMCD, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 담당자부서명 : pernChrgDeptNm */
        listColumnDefs.add(new ColumnDef("담당자부서명", Payr0600BM.ATTR_PERNCHRGDEPTNM, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 담당자성명 : pernChrgNm */
        listColumnDefs.add(new ColumnDef("담당자성명", Payr0600BM.ATTR_PERNCHRGNM, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 담당자전화번호 : pernChrgPhnNum */
        listColumnDefs.add(new ColumnDef("담당자전화번호", Payr0600BM.ATTR_PERNCHRGPHNNUM, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 일용근로자소득제출마감일자 : dilWrkrIncmSumtDdlneDt */
        listColumnDefs.add(new ColumnDef("일용근로자소득제출마감일자", Payr0600BM.ATTR_DILWRKRINCMSUMTDDLNEDT, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 일용근로자소득제출마감여부 : dilWrkrIncmSumtDdlneYn */
        listColumnDefs.add(new ColumnDef("일용근로자소득제출마감여부", Payr0600BM.ATTR_DILWRKRINCMSUMTDDLNEYN, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Payr0600BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Payr0600BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Payr0600BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Payr0600BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Payr0600BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Payr0600BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true) {{
        }});

        setColumnsDefinition(listColumnDefs);
    }
}
