/**
 * 공통화면 팝업 
 */
package com.app.exterms.prgm.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComPsnl0115BM;
import com.app.exterms.prgm.client.languages.PrgmConstants;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class PrgmComPsnl0115Def  extends TableDef implements PrgmComDaoConstants {

    private int row = 0;
    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;

    public PrgmComPsnl0115Def(){
        setTitle("");
        setDaoClass(CLASS_SYSCOM_BASS0300VO);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", PrgmComPsnl0115BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", PrgmComPsnl0115BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 가족일련번호 : famySeilNum */
        listColumnDefs.add(new ColumnDef("가족일련번호", PrgmComPsnl0115BM.ATTR_FAMYSEILNUM, ColumnDef.TYPE_LONG , 90, false, false, true){
            {

            }
        });
        /** column 가족관계구분코드 : famyRelaDivCd */
        listColumnDefs.add(new ColumnDef("가족관계코드", PrgmComPsnl0115BM.ATTR_FAMYRELADIVCD, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 가족관계 : famyRelaDivNm */
        listColumnDefs.add(new ColumnDef("가족관계", PrgmComPsnl0115BM.ATTR_FAMYRELADIVNM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 가족성명 : famyNm */
        listColumnDefs.add(new ColumnDef("성명", PrgmComPsnl0115BM.ATTR_FAMYNM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 가족주민등록번호 : famyResnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", PrgmComPsnl0115BM.ATTR_FAMYRESNREGNNUM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 생년월일 : yoobhMnthDay */
        listColumnDefs.add(new ColumnDef("생년월일", PrgmComPsnl0115BM.ATTR_YOOBHMNTHDAY, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 음양구분코드 : sclcDivCd */
        listColumnDefs.add(new ColumnDef("음양구분코드", PrgmComPsnl0115BM.ATTR_SCLCDIVCD, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 음양구분코드 : sclcDivNm  */
        listColumnDefs.add(new ColumnDef("음양구분", PrgmComPsnl0115BM.ATTR_SCLCDIVNM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 학력구분코드 : acadAbtyDivCd */
        listColumnDefs.add(new ColumnDef("학력구분코드", PrgmComPsnl0115BM.ATTR_ACADABTYDIVCD, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 학력구분코드 : acadAbtyDivNm */
        listColumnDefs.add(new ColumnDef("학력구분", PrgmComPsnl0115BM.ATTR_ACADABTYDIVNM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 학교명 : schlNm */
        listColumnDefs.add(new ColumnDef("학교명", PrgmComPsnl0115BM.ATTR_SCHLNM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 직업명 : crrCd */
        listColumnDefs.add(new ColumnDef("직업명", PrgmComPsnl0115BM.ATTR_CRRCD, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 직업명 : crrNm */
        listColumnDefs.add(new ColumnDef("직업", PrgmComPsnl0115BM.ATTR_CRRNM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 직장명 : wkOfcNm */
        listColumnDefs.add(new ColumnDef("직장명", PrgmComPsnl0115BM.ATTR_WKOFCNM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 직위명 : inbyNm */
        listColumnDefs.add(new ColumnDef("직위명", PrgmComPsnl0115BM.ATTR_INBYNM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 외국인여부 : frgnrYn */
        listColumnDefs.add(new ColumnDef("외국인", PrgmComPsnl0115BM.ATTR_FRGNRYN, ColumnDef.TYPE_BOOLEAN , 90, false, false, true){
            {

            }
        });
        /** column 장애구분코드 : dabtyDivCd */
        listColumnDefs.add(new ColumnDef("장애구분코드", PrgmComPsnl0115BM.ATTR_DABTYDIVCD, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 장애구분 : dabtyDivNm */
        listColumnDefs.add(new ColumnDef("장애구분", PrgmComPsnl0115BM.ATTR_DABTYDIVNM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 장애등급코드 : dabtyGrdeCd */
        listColumnDefs.add(new ColumnDef("장애등급코드", PrgmComPsnl0115BM.ATTR_DABTYGRDECD, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 장애등급코드 : dabtyGrdeNm */
        listColumnDefs.add(new ColumnDef("장애등급", PrgmComPsnl0115BM.ATTR_DABTYGRDENM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 가족사항비고내용 : famyPartNoteCtnt */
        listColumnDefs.add(new ColumnDef("가족사항비고내용", PrgmComPsnl0115BM.ATTR_FAMYPARTNOTECTNT, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 국가코드 : natnCd */
        listColumnDefs.add(new ColumnDef("국가코드", PrgmComPsnl0115BM.ATTR_NATNCD, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 국가 : natnNm */
        listColumnDefs.add(new ColumnDef("국가", PrgmComPsnl0115BM.ATTR_NATNNM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        
        /** column 가족동거여부 : famyChbttYn */
        listColumnDefs.add(new ColumnDef("가족동거여부", PrgmComPsnl0115BM.ATTR_FAMYCHBTTYN, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 가족수당여부 : famyAllwYn */
        listColumnDefs.add(new ColumnDef("가족수당여부", PrgmComPsnl0115BM.ATTR_FAMYALLWYN, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 학비보조여부 : schlExpnAdmclYn */
        listColumnDefs.add(new ColumnDef("학비보조여부", PrgmComPsnl0115BM.ATTR_SCHLEXPNADMCLYN, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 연말정산여부 : yrtxYn */
        listColumnDefs.add(new ColumnDef("연말정산여부", PrgmComPsnl0115BM.ATTR_YRTXYN, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
      

//        private TextField<String> dpobCd   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> systemkey   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> famySeilNum   /** column 가족일련번호 : famySeilNum */
//
//        private TextField<String> famyRelaDivCd   /** column 가족관계구분코드 : famyRelaDivCd */
//
//        private TextField<String> famyNm   /** column 가족성명 : famyNm */
//
//        private TextField<String> famyResnRegnNum   /** column 가족주민등록번호 : famyResnRegnNum */
//
//        private TextField<String> yoobhMnthDay   /** column 생년월일 : yoobhMnthDay */
//
//        private TextField<String> sclcDivCd   /** column 음양구분코드 : sclcDivCd */
//
//        private TextField<String> acadAbtyDivCd   /** column 학력구분코드 : acadAbtyDivCd */
//
//        private TextField<String> schlNm   /** column 학교명 : schlNm */
//
//        private TextField<String> crrCd   /** column 직업명 : crrCd */
//
//        private TextField<String> wkOfcNm   /** column 직장명 : wkOfcNm */
//
//        private TextField<String> inbyNm   /** column 직위명 : inbyNm */
//
//        private TextField<String> frgnrYn   /** column 외국인여부 : frgnrYn */
//
//        private TextField<String> dabtyDivCd   /** column 장애구분코드 : dabtyDivCd */
//
//        private TextField<String> dabtyGrdeCd   /** column 장애등급코드 : dabtyGrdeCd */
//
//        private TextField<String> famyPartNoteCtnt   /** column 가족사항비고내용 : famyPartNoteCtnt */
//
//        private TextField<String> natnCd   /** column 국가코드 : natnCd */
//
//        private TextField<String> famyChbttYn   /** column 가족동거여부 : famyChbttYn */
//
//        private TextField<String> famyAllwYn   /** column 가족수당여부 : famyAllwYn */
//
//        private TextField<String> schlExpnAdmclYn   /** column 학비보조여부 : schlExpnAdmclYn */
//
//        private TextField<String> yrtxYn   /** column 연말정산여부 : yrtxYn */
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
