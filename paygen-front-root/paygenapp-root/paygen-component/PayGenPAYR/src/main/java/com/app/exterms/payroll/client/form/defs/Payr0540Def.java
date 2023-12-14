/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0540BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.google.gwt.i18n.client.DateTimeFormat;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0540Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;
 
     final PrgmComBass0300DTO sysComBass0300Dto;
  
    public Payr0540Def(){
        

        sysComBass0300Dto = new PrgmComBass0300DTO(); 
        
        setTitle(PayrLabel.titlePayr0540());
        setDaoClass(CLASS_PAYR0540_DATA_LIST);
        setCustomListMethod(CLASS_PAYR0540_DATA_LIST);
        setAutoFillGrid(false);
        setShowFilterToolbar(false);
        // setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
         setCheckBoxOnGridRows(true);
         setEditFieldGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0540BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
          
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0540BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 예외처리일련번호 : exptnPrcsSeilNum */
        listColumnDefs.add(new ColumnDef("번호", Payr0540BM.ATTR_EXPTNPRCSSEILNUM, ColumnDef.TYPE_LONG, 40, false, true, true){
        	{
               setReadOnly(true);
        	}
        });
        /** column 급여항목코드 : payItemCd */
        listColumnDefs.add(new ColumnDef("급여항목코드", Payr0540BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
                
        sysComBass0300Dto.setRpsttvCd("B013"); 
        /** column 예외구분코드 : exptnDivCd */
        listColumnDefs.add(new ColumnListDef("예외구분", Payr0540BM.ATTR_EXPTNDIVCD, ColumnDef.TYPE_STRING, 110, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

        	}
        });
        /** column 예외구분 : exptnDivNm */
        listColumnDefs.add(new ColumnDef("예외구분", Payr0540BM.ATTR_EXPTNDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        sysComBass0300Dto.setRpsttvCd("B008"); 
        /** column 지급공제구분코드 : pymtDducDivCd */
        listColumnDefs.add(new ColumnListDef("공제구분", Payr0540BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING, 90, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

        	}
        });
        
        /** column 지급공제구분 : pymtDducDivNm */
        listColumnDefs.add(new ColumnDef("공제구분", Payr0540BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 면제여부 : exmtnYn */
        listColumnDefs.add(new ColumnDef("면제", Payr0540BM.ATTR_EXMTNYN, ColumnDef.TYPE_BOOLEAN, 50, false, true, true){
        	{

        	}
        });
        /** column 예외처리지급금액 : exptnPrcsPymtSum */
        listColumnDefs.add(new ColumnDef("예외금액", Payr0540BM.ATTR_EXPTNPRCSPYMTSUM, ColumnDef.TYPE_LONG, 80, false, true, true){
        	{

        	}
        });
        /** column 예외처리지급비율 : exptnPrcsPymtRto */
        listColumnDefs.add(new ColumnDef("예외비율", Payr0540BM.ATTR_EXPTNPRCSPYMTRTO, ColumnDef.TYPE_DOUBLE, 80, false, true, true){
        	{

        	}
        });
        /** column 예외처리시작일자 : exptnPrcsBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Payr0540BM.ATTR_EXPTNPRCSBGNNDT, ColumnDef.TYPE_DATE, 80, false, true, true){
        	{
        		setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");
        	}
        });
        /** column 예외처리종료일자 : exptnPrcsEndDt */
        listColumnDefs.add(new ColumnDef("종료일자", Payr0540BM.ATTR_EXPTNPRCSENDDT, ColumnDef.TYPE_DATE, 80, false, true, true){
        	{
        		setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");
        	}
        });
        /** column 예외처리내용 : exptnPrcsNoteCtnt */
        listColumnDefs.add(new ColumnDef("예외처리내용", Payr0540BM.ATTR_EXPTNPRCSNOTECTNT, ColumnDef.TYPE_STRING , 120, false, true, true){
            {

            }
        });

        
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Payr0540BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, false, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Payr0540BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Payr0540BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Payr0540BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Payr0540BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Payr0540BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });

//        private TextField<String> systemkey   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> exptnPrcsSeilNum   /** column 예외처리일련번호 : exptnPrcsSeilNum */
//
//        private TextField<String> exptnDivCd   /** column 예외구분코드 : exptnDivCd */
//
//        private TextField<String> pymtDducDivCd   /** column 지급공제구분코드 : pymtDducDivCd */
//
//        private TextField<String> exmtnYn   /** column 면제여부 : exmtnYn */
//
//        private TextField<String> exptnPrcsPymtSum   /** column 예외처리지급금액 : exptnPrcsPymtSum */
//
//        private TextField<String> exptnPrcsPymtRto   /** column 예외처리지급비율 : exptnPrcsPymtRto */
//
//        private TextField<String> exptnPrcsBgnnDt   /** column 예외처리시작일자 : exptnPrcsBgnnDt */
//
//        private TextField<String> exptnPrcsEndDt   /** column 예외처리종료일자 : exptnPrcsEndDt */
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
