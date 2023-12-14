/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Psnl0123BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Psnl0123Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    final PrgmComBass0300DTO sysComBass0300Dto;
    
    public Psnl0123Def(){
        
        sysComBass0300Dto = new PrgmComBass0300DTO(); 
        
        setTitle("휴직");
        setDaoClass(CLASS_PSNL0123_PAYR4100_DAO_LIST);
        setCustomListMethod(CLASS_PSNL0123_PAYR4100_DAO_LIST);
        setAutoFillGrid(false);
        setShowFilterToolbar(false);
        setCheckBoxOnGridRows(true); 
        setEditFieldGrid(true);
         
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Psnl0123BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0123BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 휴직일련번호 : levfAbncSeilNum */
        listColumnDefs.add(new ColumnDef("번호", Psnl0123BM.ATTR_LEVFABNCSEILNUM, ColumnDef.TYPE_LONG , 50, false, true, true){
            {

            }
        });
        
        sysComBass0300Dto.setRpsttvCd("B014"); 
        /** column 휴직구분코드 : levfAbncDivCd */
        listColumnDefs.add(new ColumnListDef("휴직구분", Psnl0123BM.ATTR_LEVFABNCDIVCD, ColumnDef.TYPE_STRING , 90, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
            {

            }
        });
        /** column 휴직시작일자 : levfAbncBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Psnl0123BM.ATTR_LEVFABNCBGNNDT, ColumnDef.TYPE_DATE , 80, false, true, true){
            {

            }
        });
        /** column 휴직종료일자 : levfAbncEndDt */
        listColumnDefs.add(new ColumnDef("종료일자", Psnl0123BM.ATTR_LEVFABNCENDDT, ColumnDef.TYPE_DATE , 80, false, true, true){
            {

            }
        });
        /** column 실제복직일자 : turtyRntmntDt */
        listColumnDefs.add(new ColumnDef("복직일자", Psnl0123BM.ATTR_TURTYRNTMNTDT, ColumnDef.TYPE_DATE , 80, false, true, true){
            {

            }
        });
        /** column 휴직비고내용 : levfAbncNoteCtnt */
        listColumnDefs.add(new ColumnDef("휴직비고내용", Psnl0123BM.ATTR_LEVFABNCNOTECTNT, ColumnDef.TYPE_STRING , 150, false, true, true){
            {

            }
        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Psnl0123BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Psnl0123BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Psnl0123BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Psnl0123BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Psnl0123BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Psnl0123BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> levfAbncSeilNum;   /** column 휴직일련번호 : levfAbncSeilNum */
//
//        private TextField<String> levfAbncDivCd;   /** column 휴직구분코드 : levfAbncDivCd */
//
//        private TextField<String> levfAbncBgnnDt;   /** column 휴직시작일자 : levfAbncBgnnDt */
//
//        private TextField<String> levfAbncEndDt;   /** column 휴직종료일자 : levfAbncEndDt */
//
//        private TextField<String> turtyRntmntDt;   /** column 실제복직일자 : turtyRntmntDt */
//
//        private TextField<String> levfAbncNoteCtnt;   /** column 휴직비고내용 : levfAbncNoteCtnt */
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
       

        
        setColumnsDefinition(listColumnDefs);
    }
}
