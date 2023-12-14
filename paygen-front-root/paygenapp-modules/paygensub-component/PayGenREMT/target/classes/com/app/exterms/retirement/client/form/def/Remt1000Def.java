/**
 * 공통화면 팝업 
 */
package com.app.exterms.retirement.client.form.def;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0350BM;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0320;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0350;
import com.app.exterms.retirement.client.dto.Remt1000BM;
import com.app.exterms.retirement.client.languages.RemtConstants;
import com.app.exterms.retirement.shared.RemtDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Remt1000Def  extends TableDef implements RemtDaoConstants {

    private int row = 0;
    private RemtConstants RemtLabel = RemtConstants.INSTANCE;

    private PrgmComBass0300DTO sysComBass0300Dto ;
    
    public Remt1000Def(){
        
        sysComBass0300Dto = new PrgmComBass0300DTO();
        
        setTitle("");
        setDaoClass(CLASS_REMT1000_SAVE); 
        setCustomListMethod(CLASS_REMT1000_DATA_LIST);
        setAutoFillGrid(false);
        setShowFilterToolbar(false);
         
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Remt1000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 퇴직금가산율일련번호 : sevePayAddRateSeilNum */
        listColumnDefs.add(new ColumnDef("번호", Remt1000BM.ATTR_SEVEPAYADDRATESEILNUM, ColumnDef.TYPE_LONG , 40, false, true, true){
            {
              setReadOnly(true);
            }
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnListDef("직종", Remt1000BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 150, true, true, true,new LookupPrgmComBass0320(),PrgmComBass0320BM.ATTR_TYPOCCUCD,PrgmComBass0320BM.ATTR_TYPOCCUNM){
            {

            }
        });

        /** column 직종세 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnListDef("직종세", Remt1000BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING, 90, true, true, true, new LookupPrgmComBass0350(), PrgmComBass0350BM.ATTR_DTILOCCUINTTNCD,PrgmComBass0350BM.ATTR_DTILOCCUCLSNM){
            {

            }
        });

        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Remt1000BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        
        sysComBass0300Dto.setRpsttvCd("R001"); 
        /** column 퇴직금가산율유형코드 : sevePayAddRateFrmCd */
        listColumnDefs.add(new ColumnListDef("가산율유형", Remt1000BM.ATTR_SEVEPAYADDRATEFRMCD, ColumnDef.TYPE_STRING , 120, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
            {

            }
        });
        /** column 퇴직금가산이상 : sevePayAddOvr */
        listColumnDefs.add(new ColumnDef("가산이상", Remt1000BM.ATTR_SEVEPAYADDOVR, ColumnDef.TYPE_LONG , 80, false, true, true){
            {

            }
        });
        /** column 퇴직금가산미만 : sevePayAddUdr */
        listColumnDefs.add(new ColumnDef("가산미만", Remt1000BM.ATTR_SEVEPAYADDUDR, ColumnDef.TYPE_LONG , 80, false, true, true){
            {

            }
        });
        /** column 퇴직금가산금액 : sevePayAddSum */
        listColumnDefs.add(new ColumnDef("가산금액", Remt1000BM.ATTR_SEVEPAYADDSUM, ColumnDef.TYPE_LONG , 80, false, true, true){
            {

            }
        });
        /** column 퇴직금가산율 : sevePayAddRate */
        listColumnDefs.add(new ColumnDef("가산율", Remt1000BM.ATTR_SEVEPAYADDRATE, ColumnDef.TYPE_DOUBLE , 80, false, true, true){
            {

            }
        });
        /** column 퇴직금가산시작일자 : sevePayAddBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Remt1000BM.ATTR_SEVEPAYADDBGNNDT, ColumnDef.TYPE_DATE , 90, false, true, true){
        	{

        	}
        });
        /** column 퇴직금가산종료일자 : sevePayAddEndDt */
        listColumnDefs.add(new ColumnDef("종료일자", Remt1000BM.ATTR_SEVEPAYADDENDDT, ColumnDef.TYPE_DATE , 90, false, true, true){
        	{

        	}
        });
        /** column 퇴직금가산사용여부 : sevePayAddUseYn */
        listColumnDefs.add(new ColumnDef("사용", Remt1000BM.ATTR_SEVEPAYADDUSEYN, ColumnDef.TYPE_BOOLEAN , 60, false, true, true){
        	{

        	}
        });
        /** column 퇴직금비고내용 : sevePayNoteCtnt */
        listColumnDefs.add(new ColumnDef("비고내용", Remt1000BM.ATTR_SEVEPAYNOTECTNT, ColumnDef.TYPE_STRING , 300, false, true, true){
            {
                setTypeTextField(ColumnDef.TEXTAREA); 
            }
        });
        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Remt1000BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Remt1000BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Remt1000BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Remt1000BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Remt1000BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Remt1000BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//


//private TextField<String> sevePayAddBgnnDt;   /** column 퇴직금가산시작일자 : sevePayAddBgnnDt */
//
//private TextField<String> sevePayAddEndDt;   /** column 퇴직금가산종료일자 : sevePayAddEndDt */
//
//private TextField<String> sevePayAddUseYn;   /** column 퇴직금가산사용여부 : sevePayAddUseYn */
        
        setColumnsDefinition(listColumnDefs);
    }
}
