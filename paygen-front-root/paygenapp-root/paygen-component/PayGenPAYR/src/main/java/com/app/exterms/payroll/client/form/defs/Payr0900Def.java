/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0900BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0900Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    public Payr0900Def(){
        setTitle(PayrLabel.titlePayr0900());
        setDaoClass(CLASS_PAYR0900_DATA_LIST);
      //  setCustomListMethod(CLASS_BASS0100_LIST);
        setAutoFillGrid(false);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0900BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 원천징수발급번호 : whdgTxIssNum */
        listColumnDefs.add(new ColumnDef("원천징수발급번호", Payr0900BM.ATTR_WHDGTXISSNUM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 원천징수발급년도 : whdgTxIssYr */
        listColumnDefs.add(new ColumnDef("원천징수발급년도", Payr0900BM.ATTR_WHDGTXISSYR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 증명서발급구분코드 : certcIssDivCd */
        listColumnDefs.add(new ColumnDef("증명서발급구분코드", Payr0900BM.ATTR_CERTCISSDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0900BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 원천징수발급일자 : whdgTxIssDt */
        listColumnDefs.add(new ColumnDef("원천징수발급일자", Payr0900BM.ATTR_WHDGTXISSDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 원천징수발급부수 : whdgTxIssNumCpis */
        listColumnDefs.add(new ColumnDef("원천징수발급부수", Payr0900BM.ATTR_WHDGTXISSNUMCPIS, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 원천징수발급용도내용 : whdgTxIssPrpseCtnt */
        listColumnDefs.add(new ColumnDef("원천징수발급용도내용", Payr0900BM.ATTR_WHDGTXISSPRPSECTNT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 원천징수발급기관명 : whdgTxIssIstutNm */
        listColumnDefs.add(new ColumnDef("원천징수발급기관명", Payr0900BM.ATTR_WHDGTXISSISTUTNM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 원천징수발급신청일자 : whdgTxIssAppyDt */
        listColumnDefs.add(new ColumnDef("원천징수발급신청일자", Payr0900BM.ATTR_WHDGTXISSAPPYDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 원천징수발급승인일자 : whdgTxIssAppbnDt */
        listColumnDefs.add(new ColumnDef("원천징수발급승인일자", Payr0900BM.ATTR_WHDGTXISSAPPBNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 원천징수발급상태구분코드 : whdgTxIssCodTNDivCd */
        listColumnDefs.add(new ColumnDef("원천징수발급상태구분코드", Payr0900BM.ATTR_WHDGTXISSCODTNDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 원천징수발급여부 : whdgTxIssYn */
        listColumnDefs.add(new ColumnDef("원천징수발급여부", Payr0900BM.ATTR_WHDGTXISSYN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 원천징수발급삭제여부 : whdgTxIssDelYn */
        listColumnDefs.add(new ColumnDef("원천징수발급삭제여부", Payr0900BM.ATTR_WHDGTXISSDELYN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Payr0900BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Payr0900BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Payr0900BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Payr0900BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Payr0900BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Payr0900BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> whdgTxIssNum   /** column 원천징수발급번호 : whdgTxIssNum */
//
//        private TextField<String> whdgTxIssYr   /** column 원천징수발급년도 : whdgTxIssYr */
//
//        private TextField<String> certcIssDivCd   /** column 증명서발급구분코드 : certcIssDivCd */
//
//        private TextField<String> systemkey   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> whdgTxIssDt   /** column 원천징수발급일자 : whdgTxIssDt */
//
//        private TextField<String> whdgTxIssNumCpis   /** column 원천징수발급부수 : whdgTxIssNumCpis */
//
//        private TextField<String> whdgTxIssPrpseCtnt   /** column 원천징수발급용도내용 : whdgTxIssPrpseCtnt */
//
//        private TextField<String> whdgTxIssIstutNm   /** column 원천징수발급기관명 : whdgTxIssIstutNm */
//
//        private TextField<String> whdgTxIssAppyDt   /** column 원천징수발급신청일자 : whdgTxIssAppyDt */
//
//        private TextField<String> whdgTxIssAppbnDt   /** column 원천징수발급승인일자 : whdgTxIssAppbnDt */
//
//        private TextField<String> whdgTxIssCodTNDivCd   /** column 원천징수발급상태구분코드 : whdgTxIssCodTNDivCd */
//
//        private TextField<String> whdgTxIssYn   /** column 원천징수발급여부 : whdgTxIssYn */
//
//        private TextField<String> whdgTxIssDelYn   /** column 원천징수발급삭제여부 : whdgTxIssDelYn */
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
