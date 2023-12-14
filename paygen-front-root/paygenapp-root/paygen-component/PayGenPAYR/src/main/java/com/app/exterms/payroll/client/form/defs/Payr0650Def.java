/**
 * 공통화면 팝업
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0650BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
 extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow {
 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 =====================================================**/
public class Payr0650Def extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;


    public Payr0650Def(String chkDef) {

        if ("PAYR4600LEFT".equals(chkDef)) {

            setTitle(PayrLabel.titlePayr0650());
            setDaoClass(CLASS_PAYR0650_LEFT_DATA_LIST);
            setCustomListMethod(CLASS_PAYR0650_LEFT_DATA_LIST);
            setAutoFillGrid(false);
            setShowFilterToolbar(false);
            setCheckBoxOnGridRows(true);

            setColumnsDefinition(getPayr0650ToPayr4600Left());


        } else if ("PAYR4600RIGHT".equals(chkDef)) {

            setTitle(PayrLabel.titlePayr0650());
            setDaoClass(CLASS_PAYR0650_RIGHT_DATA_LIST);
            setCustomListMethod(CLASS_PAYR0650_RIGHT_DATA_LIST);
            setAutoFillGrid(false);
            setShowFilterToolbar(false);

            setColumnsDefinition(getPayr0650ToPayr4600Right());
        }
    }


    public List<ColumnDef> getPayr0650ToPayr4600Left() {

        List<ColumnDef> listColumnDefs = new ArrayList();

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0650BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 70, true, false, false) {{
        }});

        /** column 일용근로소득귀속년도 : dilWrkrIncmBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", Payr0650BM.ATTR_DILWRKRINCMBLGGYR, ColumnDef.TYPE_STRING, 70, true, true, false) {{
        }});

        /** column 일용근로소득귀속분기구분코드 : dilWrkrBlggQatrDivCd */
        listColumnDefs.add(new ColumnDef("일용근로소득귀속분기구분코드", Payr0650BM.ATTR_DILWRKRINCMBLGGQATRDIVCD, ColumnDef.TYPE_STRING, 70, true, false, false) {{
        }});

        /** column 일용근로소득일련번호 : dilWrkrIncmSeilNum */
        listColumnDefs.add(new ColumnDef("일용근로소득일련번호", Payr0650BM.ATTR_DILWRKRINCMSEILNUM, ColumnDef.TYPE_STRING, 70, true, false, false) {{
        }});

        /** column 일용근로소득귀속분기구분코드 : dilWrkrBlggQatrDivCdARrr*/
        listColumnDefs.add(new ColumnDef("일용근로소득귀속분기구분코드배열", Payr0650BM.ATTR_DILWRKRINCMBLGGQATRDIVCDARR, ColumnDef.TYPE_STRING, 70, true, false, false) {{
        }});

        /** column 일용근로소득귀속분기 : dilWrkrBlggQatrDivNm */
        listColumnDefs.add(new ColumnDef("분기", Payr0650BM.ATTR_DILWRKRINCMBLGGQATRDIVNM, ColumnDef.TYPE_STRING, 60, false, true, false) {{
        }});

        /** column 일용근로소득일련번호 : dilWrkrIncmPymtYrMnth */
        listColumnDefs.add(new ColumnDef("분기", Payr0650BM.ATTR_DILWRKRINCMSEILNUM, ColumnDef.TYPE_STRING, 60, true, false, false) {{
        }});

        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0650BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 70, true, false, false) {{
        }});

        /** column 근로소득지급년월 : dilWrkrIncmPymtYrMnth */
        listColumnDefs.add(new ColumnDef("근로소득지급년월", Payr0650BM.ATTR_DILWRKRINCMPYMTYRMNTH, ColumnDef.TYPE_STRING, 90, true, false, false) {{
        }});

        /** column 소득자성명 : aimenrNm */
        listColumnDefs.add(new ColumnDef("성명", Payr0650BM.ATTR_AIMENRNM, ColumnDef.TYPE_STRING, 70, false, true, false) {{
        }});

        /** column 소득자주민등록번호 : aimenrResnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0650BM.ATTR_AIMENRRESNREGNNUM, ColumnDef.TYPE_STRING, 100, false, true, false) {{
        }});

        /** column 소득자전화번호 : aimenrPhnNum */
        listColumnDefs.add(new ColumnDef("소득자전화번호", Payr0650BM.ATTR_AIMENRPHNNUM, ColumnDef.TYPE_STRING, 90, false, false, false) {{
        }});

        /** column 소득자우편번호 : aimenrZpcd */
        listColumnDefs.add(new ColumnDef("소득자우편번호", Payr0650BM.ATTR_AIMENRZPCD, ColumnDef.TYPE_STRING, 90, false, false, false) {{
        }});

        /** column 소득자도로명주소 : aimenrRoadNmAddr */
        listColumnDefs.add(new ColumnDef("소득자도로명주소", Payr0650BM.ATTR_AIMENRROADNMADDR, ColumnDef.TYPE_STRING, 1000, false, false, false) {{
        }});

        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Payr0650BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, false, false, false) {{
        }});

        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Payr0650BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, false, false, false) {{
        }});

        /** column 부서명 : deptNm */
        listColumnDefs.add(new ColumnDef("부서명", Payr0650BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 1000, false, false, false) {{
        }});

        /** column 사업명 : businNm */
        listColumnDefs.add(new ColumnDef("사업명", Payr0650BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, false, false) {{
        }});

        listColumnDefs.add(new ColumnDef("대표자성명", Payr0650BM.ATTR_DEGTRNM, ColumnDef.TYPE_STRING, 90, false, false, false) {{}});
        listColumnDefs.add(new ColumnDef("법인명_상호", Payr0650BM.ATTR_CORPNMFMNM, ColumnDef.TYPE_STRING, 90, false, false, false) {{}});
        listColumnDefs.add(new ColumnDef("사업자등록번호", Payr0650BM.ATTR_BUSOPRRGSTNNUM, ColumnDef.TYPE_STRING, 90, false, false, false) {{}});
        listColumnDefs.add(new ColumnDef("사업자주민등록번호", Payr0650BM.ATTR_BUSOPRRESNREGNNUM, ColumnDef.TYPE_STRING, 90, false, false, false) {{}});
        listColumnDefs.add(new ColumnDef("법인번호", Payr0650BM.ATTR_CORPNUM, ColumnDef.TYPE_STRING, 90, false, false, false) {{}});
        listColumnDefs.add(new ColumnDef("소득신고의무자우편번호", Payr0650BM.ATTR_INCMREGRSTDEBRZPCD, ColumnDef.TYPE_STRING, 90, false, false, false) {{}});
        listColumnDefs.add(new ColumnDef("소득신고의무자기본주소", Payr0650BM.ATTR_INCMREGRSTDEBRFNDTNADDR, ColumnDef.TYPE_STRING, 90, false, false, false) {{}});
        listColumnDefs.add(new ColumnDef("소득신고의무자상세주소", Payr0650BM.ATTR_INCMREGRSTDEBRDTLPATRADDR, ColumnDef.TYPE_STRING, 90, false, false, false) {{}});
        listColumnDefs.add(new ColumnDef("관할세무서코드", Payr0650BM.ATTR_JURITXOFFCCD, ColumnDef.TYPE_STRING, 90, false, false, false) {{}});
        listColumnDefs.add(new ColumnDef("제출자구분코드", Payr0650BM.ATTR_PENTRCD, ColumnDef.TYPE_STRING, 90, false, false, false) {{}});
        listColumnDefs.add(new ColumnDef("세무대리인번호", Payr0650BM.ATTR_TXDEPTYNUM, ColumnDef.TYPE_STRING, 90, false, false, false) {{}});
        listColumnDefs.add(new ColumnDef("홈텍스ID", Payr0650BM.ATTR_HMTXID, ColumnDef.TYPE_STRING, 90, false, false, false) {{}});
        listColumnDefs.add(new ColumnDef("세무프로그램코드", Payr0650BM.ATTR_TXPGMCD, ColumnDef.TYPE_STRING, 90, false, false, false) {{}});
        listColumnDefs.add(new ColumnDef("담당자부서명", Payr0650BM.ATTR_PERNCHRGDEPTNM, ColumnDef.TYPE_STRING, 90, false, false, false) {{}});
        listColumnDefs.add(new ColumnDef("담당자성명", Payr0650BM.ATTR_PERNCHRGNM, ColumnDef.TYPE_STRING, 90, false, false, false) {{}});
        listColumnDefs.add(new ColumnDef("담당자전화번호", Payr0650BM.ATTR_PERNCHRGPHNNUM, ColumnDef.TYPE_STRING, 90, false, false, false) {{}});
        listColumnDefs.add(new ColumnDef("전자우편주소", Payr0650BM.ATTR_ECTNMAILADDR, ColumnDef.TYPE_STRING, 90, false, false, false) {{}});






        return listColumnDefs;
    }


    public List<ColumnDef> getPayr0650ToPayr4600Right() {

        List<ColumnDef> listColumnDefs = new ArrayList();

        /** column 일용근로소득귀속년도 : dilWrkrIncmBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", Payr0650BM.ATTR_DILWRKRINCMBLGGYR, ColumnDef.TYPE_STRING, 70, true, true, false) {{
        }});

        /** column 일용근로소득귀속분기구분코드 : dilWrkrIncmBlggQatrDivCd */
        listColumnDefs.add(new ColumnDef("일용근로소득귀속분기구분코드", Payr0650BM.ATTR_DILWRKRINCMBLGGQATRDIVCD, ColumnDef.TYPE_STRING, 90, true, false, false) {{
        }});

        /** column 일용근로소득귀속분기 : dilWrkrIncmBlggQatrDivNM */
        listColumnDefs.add(new ColumnDef("분기", Payr0650BM.ATTR_DILWRKRINCMBLGGQATRDIVNM, ColumnDef.TYPE_STRING, 70, true, true, false) {{
        }});

        /** column 급여관리부서코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("급여관리부서코드", Payr0650BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, true, false, false) {{
        }});

        /** column 일용근로소득지급년월 : dilWrkrIncmPymtYrMnth */
        listColumnDefs.add(new ColumnDef("지급년월", Payr0650BM.ATTR_DILWRKRINCMPYMTYRMNTH, ColumnDef.TYPE_STRING, 70, true, true, false) {{
        }});

        /** column 일용근로소득근무년월 : dilWrkrIncmDutyYrMnth */
        listColumnDefs.add(new ColumnDef("근무년월", Payr0650BM.ATTR_DILWRKRINCMDUTYYRMNTH, ColumnDef.TYPE_STRING, 70, true, true, false) {{
        }});

        /** column 일용근로소득근무일수 : dilWrkrIncmDutyNumDys */
        listColumnDefs.add(new ColumnDef("일용근로소득근무일수", Payr0650BM.ATTR_DILWRKRINCMDUTYNUMDYS, ColumnDef.TYPE_STRING, 70, true, false, false) {{
        }});

        /** column 일용근로소득총지급금액 : dilWrkrIncmTotPymtSum */
        listColumnDefs.add(new ColumnDef("총지급금액", Payr0650BM.ATTR_DILWRKRINCMTOTPYMTSUM, ColumnDef.TYPE_LONG, 90, true, true, false) {{
        }});

        /** column 일용근로소득비과세소득금액 : dilWrkrFreeDtyIncmSum */
        listColumnDefs.add(new ColumnDef("비과세", Payr0650BM.ATTR_DILWRKRFREEDTYINCMSUM, ColumnDef.TYPE_LONG, 90, true, true, false) {{
        }});

        /** column 일용근로소득소득세금액 : dilWrkrIncmIncmTxSum */
        listColumnDefs.add(new ColumnDef("소득세", Payr0650BM.ATTR_DILWRKRINCMINCMTXSUM, ColumnDef.TYPE_LONG, 90, true, true, false) {{
        }});

        /** column 일용근로소득지방소득세금액 : dilWrkrRgonIncmTxSum */
        listColumnDefs.add(new ColumnDef("지방소득세", Payr0650BM.ATTR_DILWRKRRGONINCMTXSUM, ColumnDef.TYPE_LONG, 90, true, true, false) {{
        }});

        /** column 일용근로소득자료정리일자 : dilWrkrIncmDataArrgtDt */
        listColumnDefs.add(new ColumnDef("정리일자", Payr0650BM.ATTR_DILWRKRINCMDATAARRGTDT, ColumnDef.TYPE_LONG, 90, true, false, false) {{
        }});

        return listColumnDefs;
    }
}
