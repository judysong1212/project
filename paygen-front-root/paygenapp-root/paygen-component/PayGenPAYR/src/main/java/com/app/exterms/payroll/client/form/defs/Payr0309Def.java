/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0309BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0309Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;
 
    public Payr0309Def(){
         
        setTitle("");
        setDaoClass("");
        setCustomListMethod("");
        setAutoFillGrid(false);
        setShowFilterToolbar(false);
        setEditFieldGrid(true);
       // setEditableGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          


        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0309BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0309BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 지급년월 : pymtYrMnth */
        listColumnDefs.add(new ColumnDef("지급년월", Payr0309BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분코드", Payr0309BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여일련번호 : payrSeilNum */
        listColumnDefs.add(new ColumnDef("급여일련번호", Payr0309BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 건강보험변동일자 : hlthInsurFlucDt */
        listColumnDefs.add(new ColumnDef("건강보험변동일자", Payr0309BM.ATTR_HLTHINSURFLUCDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 건강보험보수총액 : hlthInsrPayTotAmnt */
        listColumnDefs.add(new ColumnDef("건강보험보수총액", Payr0309BM.ATTR_HLTHINSRPAYTOTAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
        listColumnDefs.add(new ColumnDef("건강보험보수월액", Payr0309BM.ATTR_HLTHINSRMNTHRUNTNAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 건강보험등급 : hlthInsrGrde */
        listColumnDefs.add(new ColumnDef("건강보험등급", Payr0309BM.ATTR_HLTHINSRGRDE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 건강보험증번호 : hlthInsrCertNum */
        listColumnDefs.add(new ColumnDef("건강보험증번호", Payr0309BM.ATTR_HLTHINSRCERTNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금변동일자 : natPennInsurFlucDt */
        listColumnDefs.add(new ColumnDef("국민연금변동일자", Payr0309BM.ATTR_NATPENNINSURFLUCDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
        listColumnDefs.add(new ColumnDef("국민연금기준소득월액", Payr0309BM.ATTR_NATPENNSTDINCMMNTHAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금등급 : natPennGrde */
        listColumnDefs.add(new ColumnDef("국민연금등급", Payr0309BM.ATTR_NATPENNGRDE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 건강보험적용여부 : hlthInsrApptnYn */
        listColumnDefs.add(new ColumnDef("건강보험적용여부", Payr0309BM.ATTR_HLTHINSRAPPTNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금적용여부 : natPennApptnYn */
        listColumnDefs.add(new ColumnDef("국민연금적용여부", Payr0309BM.ATTR_NATPENNAPPTNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용보험적용여부 : umytInsrApptnYn */
        listColumnDefs.add(new ColumnDef("고용보험적용여부", Payr0309BM.ATTR_UMYTINSRAPPTNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 산재보험적용여부 : idtlAccdtInsurApptnYn */
        listColumnDefs.add(new ColumnDef("산재보험적용여부", Payr0309BM.ATTR_IDTLACCDTINSURAPPTNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
      
        /** column 고용보험변동일자 : umytInsrFlucDt */
        listColumnDefs.add(new ColumnDef("고용보험변동일자", Payr0309BM.ATTR_UMYTINSRFLUCDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용보험보수총액 : umytInsrPayTotAmnt */
        listColumnDefs.add(new ColumnDef("고용보험보수총액", Payr0309BM.ATTR_UMYTINSRPAYTOTAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 고용보험보수월액 : umytInsrPayMnthAmnt */
        listColumnDefs.add(new ColumnDef("고용보험보수월액", Payr0309BM.ATTR_UMYTINSRPAYMNTHAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 산재보험변동일자 : idtlAccdtFlucDt */
        listColumnDefs.add(new ColumnDef("산재보험변동일자", Payr0309BM.ATTR_IDTLACCDTFLUCDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 산재보험보수총액 : idtlAccdtPayTotAmnt */
        listColumnDefs.add(new ColumnDef("산재보험보수총액", Payr0309BM.ATTR_IDTLACCDTPAYTOTAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 산재보험보수월액 : idtlAccdtPayMnthAmnt */
        listColumnDefs.add(new ColumnDef("산재보험보수월액", Payr0309BM.ATTR_IDTLACCDTPAYMNTHAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Payr0309BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Payr0309BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Payr0309BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Payr0309BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Payr0309BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Payr0309BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> pymtYrMnth;   /** column 지급년월 : pymtYrMnth */
//
//        private TextField<String> payCd;   /** column 급여구분코드 : payCd */
//
//        private TextField<String> payrSeilNum;   /** column 급여일련번호 : payrSeilNum */
//
//        private TextField<String> hlthInsurFlucDt;   /** column 건강보험변동일자 : hlthInsurFlucDt */
//
//        private TextField<String> hlthInsrPayTotAmnt;   /** column 건강보험보수총액 : hlthInsrPayTotAmnt */
//
//        private TextField<String> hlthInsrMnthRuntnAmnt;   /** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
//
//        private TextField<String> hlthInsrGrde;   /** column 건강보험등급 : hlthInsrGrde */
//
//        private TextField<String> hlthInsrCertNum;   /** column 건강보험증번호 : hlthInsrCertNum */
//
//        private TextField<String> natPennInsurFlucDt;   /** column 국민연금변동일자 : natPennInsurFlucDt */
//
//        private TextField<String> natPennStdIncmMnthAmnt;   /** column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
//
//        private TextField<String> natPennGrde;   /** column 국민연금등급 : natPennGrde */
//
//        private TextField<String> hlthInsrApptnYn;   /** column 건강보험적용여부 : hlthInsrApptnYn */
//
//        private TextField<String> natPennApptnYn;   /** column 국민연금적용여부 : natPennApptnYn */
//
//        private TextField<String> umytInsrApptnYn;   /** column 고용보험적용여부 : umytInsrApptnYn */
//
//        private TextField<String> idtlAccdtInsurApptnYn;   /** column 산재보험적용여부 : idtlAccdtInsurApptnYn */
//
//        private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//        private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//        private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//        private TextField<String> ismt;   /** column 수정자 : ismt */
//
//        private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//        private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
//
//        private TextField<String> umytInsrFlucDt;   /** column 고용보험변동일자 : umytInsrFlucDt */
//
//        private TextField<String> umytInsrPayTotAmnt;   /** column 고용보험보수총액 : umytInsrPayTotAmnt */
//
//        private TextField<String> umytInsrPayMnthAmnt;   /** column 고용보험보수월액 : umytInsrPayMnthAmnt */
//
//        private TextField<String> idtlAccdtFlucDt;   /** column 산재보험변동일자 : idtlAccdtFlucDt */
//
//        private TextField<String> idtlAccdtPayTotAmnt;   /** column 산재보험보수총액 : idtlAccdtPayTotAmnt */
//
//        private TextField<String> idtlAccdtPayMnthAmnt;   /** column 산재보험보수월액 : idtlAccdtPayMnthAmnt */
       
    }
}
