/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0301BM;
import com.app.exterms.payroll.client.dto.Payr0304BM;
import com.app.exterms.payroll.client.dto.Payr0305BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0305Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    public Payr0305Def(){
        setTitle(PayrLabel.titlePayr0305());
        setDaoClass(CLASS_PAYR0305_DATA_LIST); 
        setCustomListMethod(CLASS_PAYR0305_DATA_LIST);
        setAutoFillGrid(false);
        setShowFilterToolbar(false);
       // setCustomListMethod(MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL);
        setCheckBoxOnGridRows(true); 
 

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0305BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
            {
        
            }
        });
        
        /** column 지급년월 : pymtYrMnth */
        listColumnDefs.add(new ColumnDef("지급년월", Payr0305BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분코드", Payr0305BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 급여구분 : payNm */
        listColumnDefs.add(new ColumnDef("급여구분", Payr0301BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Payr0304BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 고용구분 : emymtDivNm */
        listColumnDefs.add(new ColumnDef("고용구분", Payr0304BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("한글성명", Payr0304BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : secRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Payr0304BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 부서 : deptNm */
        listColumnDefs.add(new ColumnDef("부서명", Payr0304BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0305BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 단위기관코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관코드", Payr0305BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 단위기관 : payrMangDept */
        listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여일련번호 : payrSeilNum */
        listColumnDefs.add(new ColumnDef("급여일련번호", Payr0305BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        /** column 근로소득과세금액 : workIncmTxtnSum */
        listColumnDefs.add(new ColumnDef("근로소득과세금액", Payr0305BM.ATTR_WORKINCMTXTNSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 급여구간중간금액 : paySectiCtrSum */
        listColumnDefs.add(new ColumnDef("급여구간중간금액", Payr0305BM.ATTR_PAYSECTICTRSUM, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        /** column 연간총급여액 : yrlyTotPayQNty */
        listColumnDefs.add(new ColumnDef("연간총급여액", Payr0305BM.ATTR_YRLYTOTPAYQNTY, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        /** column 근로소득공제금액 : eandIncmDducSum */
        listColumnDefs.add(new ColumnDef("근로소득공제금액", Payr0305BM.ATTR_EANDINCMDDUCSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 근로소득금액 : eandIncmSum */
        listColumnDefs.add(new ColumnDef("근로소득금액", Payr0305BM.ATTR_EANDINCMSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        
        /** column 인적공제인원수 : hmnDducNumPeplNum */
        listColumnDefs.add(new ColumnDef("인적공제인원수", Payr0305BM.ATTR_HMNDDUCNUMPEPLNUM, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        /** column 인적공제20세이하자녀수 : hmnDducTwenSqntsChdnNum */
        listColumnDefs.add(new ColumnDef("인적공제20세이하자녀수", Payr0305BM.ATTR_HMNDDUCTWENSQNTSCHDNNUM, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        /** column 인적공제금액 : hmnDducSum */
        listColumnDefs.add(new ColumnDef("인적공제금액", Payr0305BM.ATTR_HMNDDUCSUM, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        /** column 연금보험료공제금액 : antyPrmmDducSum */
        listColumnDefs.add(new ColumnDef("연금보험료공제금액", Payr0305BM.ATTR_ANTYPRMMDDUCSUM, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        /** column 특별소득공제등금액 : spclIncmDducEtcSum */
        listColumnDefs.add(new ColumnDef("특별소득공제등금액", Payr0305BM.ATTR_SPCLINCMDDUCETCSUM, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        /** column 과세표준금액 : txtnStdSum */
        listColumnDefs.add(new ColumnDef("과세표준금액", Payr0305BM.ATTR_TXTNSTDSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 과세표준적용세율 : txtnStdApptnTxrt */
        listColumnDefs.add(new ColumnDef("과세표준적용세율", Payr0305BM.ATTR_TXTNSTDAPPTNTXRT, ColumnDef.TYPE_DOUBLE, 90, true, false, true){
        	{

        	}
        });
        /** column 과세표준누진공제금액 : txtnStdPgivDducSum */
        listColumnDefs.add(new ColumnDef("과세표준누진공제금액", Payr0305BM.ATTR_TXTNSTDPGIVDDUCSUM, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        /** column 산출세액 : calcTxAmnt */
        listColumnDefs.add(new ColumnDef("산출세액", Payr0305BM.ATTR_CALCTXAMNT, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 근로소득세액공제액 : eandIncmTxAmnt */
        listColumnDefs.add(new ColumnDef("근로소득세액공제액", Payr0305BM.ATTR_EANDINCMTXAMNT, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        /** column 결정세액 : deinTxAmnt */
        listColumnDefs.add(new ColumnDef("결정세액", Payr0305BM.ATTR_DEINTXAMNT, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 간이세액 : txtbSimfTxs */
        listColumnDefs.add(new ColumnDef("간이세액", Payr0305BM.ATTR_TXTBSIMFTXS, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        
        /** column 추가소득세율 : addIncmTxRate */
        listColumnDefs.add(new ColumnDef("추가소득세율", Payr0305BM.ATTR_ADDINCMTXRATE, ColumnDef.TYPE_DOUBLE , 90, true, true, true){
        	{

        	}
        });
        /** column 실소득세액 : turtyIncmTxQnty */
        listColumnDefs.add(new ColumnDef("실소득세액", Payr0305BM.ATTR_TURTYINCMTXQNTY, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });

        
        /** column 지방소득세 : locIncmTxAmt */
        listColumnDefs.add(new ColumnDef("지방소득세", Payr0305BM.ATTR_LOCINCMTXAMT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Payr0305BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Payr0305BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Payr0305BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Payr0305BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Payr0305BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Payr0305BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//        private TextField<String> pymtYrMnth   /** column 지급년월 : pymtYrMnth */
//
//        private TextField<String> payCd   /** column 급여구분코드 : payCd */
//
//        private TextField<String> systemkey   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> payrMangDeptCd   /** column 단위기관코드 : payrMangDeptCd */
//
//        private TextField<String> payrSeilNum   /** column 급여일련번호 : payrSeilNum */
//
//        private TextField<String> workIncmTxtnSum   /** column 근로소득과세금액 : workIncmTxtnSum */
//
//        private TextField<String> paySectiCtrSum   /** column 급여구간중간금액 : paySectiCtrSum */
//
//        private TextField<String> yrlyTotPayQNty   /** column 연간총급여액 : yrlyTotPayQNty */
//
//        private TextField<String> eandIncmDducSum   /** column 근로소득공제금액 : eandIncmDducSum */
//
//        private TextField<String> hmnDducNumPeplNum   /** column 인적공제인원수 : hmnDducNumPeplNum */
//
//        private TextField<String> hmnDducTwenSqntsChdnNum   /** column 인적공제20세이하자녀수 : hmnDducTwenSqntsChdnNum */
//
//        private TextField<String> hmnDducSum   /** column 인적공제금액 : hmnDducSum */
//
//        private TextField<String> antyPrmmDducSum   /** column 연금보험료공제금액 : antyPrmmDducSum */
//
//        private TextField<String> spclIncmDducEtcSum   /** column 특별소득공제등금액 : spclIncmDducEtcSum */
//
//        private TextField<String> txtnStdSum   /** column 과세표준금액 : txtnStdSum */
//
//        private TextField<String> txtnStdApptnTxrt   /** column 과세표준적용세율 : txtnStdApptnTxrt */
//
//        private TextField<String> txtnStdPgivDducSum   /** column 과세표준누진공제금액 : txtnStdPgivDducSum */
//
//        private TextField<String> calcTxAmnt   /** column 산출세액 : calcTxAmnt */
//
//        private TextField<String> eandIncmTxAmnt   /** column 근로소득세액공제액 : eandIncmTxAmnt */
//
//        private TextField<String> deinTxAmnt   /** column 결정세액 : deinTxAmnt */
//
//        private TextField<String> txtbSimfTxs   /** column 간이세액 : txtbSimfTxs */
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
        
 //       private TextField<String> addIncmTxRate;   /** column 추가소득세율 : addIncmTxRate */

   //     private TextField<String> turtyIncmTxQnty;   /** column 실소득세액 : turtyIncmTxQnty */

        
        setColumnsDefinition(listColumnDefs);
    }
}
