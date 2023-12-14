/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0306BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0306Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    public Payr0306Def(){
        setTitle(PayrLabel.titlePayr0306());
        setDaoClass(CLASS_PAYR0306_DATA_LIST);
        setCustomListMethod(CLASS_PAYR0306_DATA_LIST);
        setAutoFillGrid(false);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0306BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
            {
        
            }
        });
 
        /** column 지급년월 : pymtYrMnth */
        listColumnDefs.add(new ColumnDef("지급년월", Payr0306BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0306BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분코드", Payr0306BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });

        /** column 급여구분 : payNm */
        listColumnDefs.add(new ColumnDef("급여구분", Payr0306BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });

        /** column 급여일련번호 : payrSeilNum */
        listColumnDefs.add(new ColumnDef("급여일련번호", Payr0306BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG , 90, false, false, true){
            {

            }
        }); 
        /** column 급여가족사항일련번호 : payFamyRsptSeilNum */
        listColumnDefs.add(new ColumnDef("급여가족사항일련번호", Payr0306BM.ATTR_PAYFAMYRSPTSEILNUM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 급여가족주민번호 : payFamyResnRegnNum */
        listColumnDefs.add(new ColumnDef("급여가족주민번호", Payr0306BM.ATTR_PAYFAMYRESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 급여가족주민번호 : payFamySecRegnNum */
        listColumnDefs.add(new ColumnDef("급여가족주민번호", Payr0306BM.ATTR_FAMYSECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
        	{

        	}
        });
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("한글성명", Payr0306BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 가족관계구분코드 : famyRelaDivCd */
        listColumnDefs.add(new ColumnDef("가족관계구분코드", Payr0306BM.ATTR_FAMYRELADIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 가족수당지급여부 : famyAllwPymtYn */
        listColumnDefs.add(new ColumnDef("가족수당지급여부", Payr0306BM.ATTR_FAMYALLWPYMTYN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 자녀양육비지급여부 : chdnChdRrgEpnsPymtYn */
        listColumnDefs.add(new ColumnDef("자녀양육비지급여부", Payr0306BM.ATTR_CHDNCHDRRGEPNSPYMTYN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 기본공제여부 : fndtnDducYn */
        listColumnDefs.add(new ColumnDef("기본공제여부", Payr0306BM.ATTR_FNDTNDDUCYN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 배우자공제여부 : spueDducYn */
        listColumnDefs.add(new ColumnDef("배우자공제여부", Payr0306BM.ATTR_SPUEDDUCYN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 부녀자공제여부 : wmnDducYn */
        listColumnDefs.add(new ColumnDef("부녀자공제여부", Payr0306BM.ATTR_WMNDDUCYN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 경로우대공제여부 : rftaGvstDducYn */
        listColumnDefs.add(new ColumnDef("경로우대공제여부", Payr0306BM.ATTR_RFTAGVSTDDUCYN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 장애자공제여부 : dabpnDducYn */
        listColumnDefs.add(new ColumnDef("장애자공제여부", Payr0306BM.ATTR_DABPNDDUCYN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 한가족공제여부 : sgpnFmlyDducYn */
        listColumnDefs.add(new ColumnDef("한가족공제여부", Payr0306BM.ATTR_SGPNFMLYDDUCYN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 자녀양육비공제여부 : chdnChdRrgEpnsDducYn */
        listColumnDefs.add(new ColumnDef("자녀양육비공제여부", Payr0306BM.ATTR_CHDNCHDRRGEPNSDDUCYN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 가족수당구분코드 : famyExtpyDivCd */
        listColumnDefs.add(new ColumnDef("가족수당구분코드", Payr0306BM.ATTR_FAMYEXTPYDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
        listColumnDefs.add(new ColumnDef("학비보조수당구분코드", Payr0306BM.ATTR_SCHLEXPNADMCLEXTPYDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 학비보조수당금액 : schlExpnAdmclExtpySum */
        listColumnDefs.add(new ColumnDef("학비보조수당금액", Payr0306BM.ATTR_SCHLEXPNADMCLEXTPYSUM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 가족수당금액 : famyExtpySum */
        listColumnDefs.add(new ColumnDef("가족수당금액", Payr0306BM.ATTR_FAMYEXTPYSUM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Payr0306BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Payr0306BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Payr0306BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Payr0306BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Payr0306BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Payr0306BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//        private TextField<String> pymtYrMnth   /** column 지급년월 : pymtYrMnth */
//
//        private TextField<String> systemkey   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> payFamyRsptSeilNum   /** column 급여가족사항일련번호 : payFamyRsptSeilNum */
//
//        private TextField<String> payFamyResnRegnNum   /** column 급여가족주민번호 : payFamyResnRegnNum */
//
//        private TextField<String> hanNm   /** column 한글성명 : hanNm */
//
//        private TextField<String> famyRelaDivCd   /** column 가족관계구분코드 : famyRelaDivCd */
//
//        private TextField<String> famyAllwPymtYn   /** column 가족수당지급여부 : famyAllwPymtYn */
//
//        private TextField<String> chdnChdRrgEpnsPymtYn   /** column 자녀양육비지급여부 : chdnChdRrgEpnsPymtYn */
//
//        private TextField<String> fndtnDducYn   /** column 기본공제여부 : fndtnDducYn */
//
//        private TextField<String> spueDducYn   /** column 배우자공제여부 : spueDducYn */
//
//        private TextField<String> wmnDducYn   /** column 부녀자공제여부 : wmnDducYn */
//
//        private TextField<String> rftaGvstDducYn   /** column 경로우대공제여부 : rftaGvstDducYn */
//
//        private TextField<String> dabpnDducYn   /** column 장애자공제여부 : dabpnDducYn */
//
//        private TextField<String> sgpnFmlyDducYn   /** column 한가족공제여부 : sgpnFmlyDducYn */
//
//        private TextField<String> chdnChdRrgEpnsDducYn   /** column 자녀양육비공제여부 : chdnChdRrgEpnsDducYn */
//
//        private TextField<String> famyExtpyDivCd   /** column 가족수당구분코드 : famyExtpyDivCd */
//
//        private TextField<String> schlExpnAdmclExtpyDivCd   /** column 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
//
//        private TextField<String> schlExpnAdmclExtpySum   /** column 학비보조수당금액 : schlExpnAdmclExtpySum */
//
//        private TextField<String> famyExtpySum   /** column 가족수당금액 : famyExtpySum */
//
//        private TextField<String> kybdr   /** column 입력자 : kybdr */
//
//        private TextField<String> inptDt   /** column 입력일자 : inptDt */
//
//        private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
//
//        private TextField<String> ismt   /** column 수정자 : ismt */
//
//        private TextField<String> revnDt   /** column 수정일자 : revnDt */
//
//        private TextField<String> revnAddr   /** column 수정주소 : revnAddr */

        
        setColumnsDefinition(listColumnDefs);
    }
}
