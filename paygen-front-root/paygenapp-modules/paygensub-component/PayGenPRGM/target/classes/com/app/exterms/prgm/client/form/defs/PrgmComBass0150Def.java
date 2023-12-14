/**
 * 공통화면 팝업 
 */
package com.app.exterms.prgm.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0150BM;
import com.app.exterms.prgm.client.languages.PrgmConstants;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class PrgmComBass0150Def  extends TableDef implements PrgmComDaoConstants {

    private int row = 0;
    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;

    public PrgmComBass0150Def(){
        setTitle(SysComLabel.titleSysComPopUpBass0300());
        setDaoClass(CLASS_SYSCOM_BASS0300VO);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

      /** column 사업장코드 : dpobCd */
      listColumnDefs.add(new ColumnDef("사업장코드", PrgmComBass0150BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 단위기관코드 : payrMangDeptCd */
      listColumnDefs.add(new ColumnDef("단위기관코드", PrgmComBass0150BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 단위기관명 : payMangeDeptNm */
      listColumnDefs.add(new ColumnDef("단위기관명", PrgmComBass0150BM.ATTR_PAYMANGEDEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 대표자주민번호 : degtrResnRegnNum */
      listColumnDefs.add(new ColumnDef("대표자주민번호", PrgmComBass0150BM.ATTR_DEGTRRESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 대표자명 : degtrNm */
      listColumnDefs.add(new ColumnDef("대표자명", PrgmComBass0150BM.ATTR_DEGTRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 사업자등록번호 : busoprRgstnNum */
      listColumnDefs.add(new ColumnDef("사업자등록번호", PrgmComBass0150BM.ATTR_BUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 법인등록번호 : corpRgstnNum */
      listColumnDefs.add(new ColumnDef("법인등록번호", PrgmComBass0150BM.ATTR_CORPRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 법인구분코드 : corpDivCd */
      listColumnDefs.add(new ColumnDef("법인구분코드", PrgmComBass0150BM.ATTR_CORPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 단위기관우편번호 : payMangeDeptZpcd */
      listColumnDefs.add(new ColumnDef("단위기관우편번호", PrgmComBass0150BM.ATTR_PAYMANGEDEPTZPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 단위기관기본주소 : payMangeDeptFNdtnAddr */
      listColumnDefs.add(new ColumnDef("단위기관기본주소", PrgmComBass0150BM.ATTR_PAYMANGEDEPTFNDTNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 단위기관상세주소 : payMangeDeptDtlPatrAddr */
      listColumnDefs.add(new ColumnDef("단위기관상세주소", PrgmComBass0150BM.ATTR_PAYMANGEDEPTDTLPATRADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 단위기관전화번호 : payMangeDeptPhnNum */
      listColumnDefs.add(new ColumnDef("단위기관전화번호", PrgmComBass0150BM.ATTR_PAYMANGEDEPTPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 단위기관팩스번호 : payMangeDeptFaxNum */
      listColumnDefs.add(new ColumnDef("단위기관팩스번호", PrgmComBass0150BM.ATTR_PAYMANGEDEPTFAXNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 단위기관직인문구명 : payMangeDeptSealWrdNm */
      listColumnDefs.add(new ColumnDef("단위기관직인문구명", PrgmComBass0150BM.ATTR_PAYMANGEDEPTSEALWRDNM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 단위기관직인경로 : payMangeDeptSealRftaNm */
      listColumnDefs.add(new ColumnDef("단위기관직인경로", PrgmComBass0150BM.ATTR_PAYMANGEDEPTSEALRFTANM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 단위기관직인파일명 : payMangeDeptSealFlNm */
      listColumnDefs.add(new ColumnDef("단위기관직인파일명", PrgmComBass0150BM.ATTR_PAYMANGEDEPTSEALFLNM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 단위기관기본사용여부 : payMangeDeptFNdtnUseYn */
      listColumnDefs.add(new ColumnDef("단위기관기본사용여부", PrgmComBass0150BM.ATTR_PAYMANGEDEPTFNDTNUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 단위기관총괄담당자 : payMangeDeptWhlePernChrg */
      listColumnDefs.add(new ColumnDef("단위기관총괄담당자", PrgmComBass0150BM.ATTR_PAYMANGEDEPTWHLEPERNCHRG, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 단위기관분임지출관 : payMangeDeptDivTskOffr */
      listColumnDefs.add(new ColumnDef("단위기관분임지출관", PrgmComBass0150BM.ATTR_PAYMANGEDEPTDIVTSKOFFR, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 회계코드 : accCd */
      listColumnDefs.add(new ColumnDef("회계코드", PrgmComBass0150BM.ATTR_ACCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 건강보험기호 : hlthInsrSym */
      listColumnDefs.add(new ColumnDef("건강보험기호", PrgmComBass0150BM.ATTR_HLTHINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 국민연금기호 : natPennSym */
      listColumnDefs.add(new ColumnDef("국민연금기호", PrgmComBass0150BM.ATTR_NATPENNSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 고용보험기호 : umytInsrSym */
      listColumnDefs.add(new ColumnDef("고용보험기호", PrgmComBass0150BM.ATTR_UMYTINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 징수의무자명 : cllnDebrNm */
      listColumnDefs.add(new ColumnDef("징수의무자명", PrgmComBass0150BM.ATTR_CLLNDEBRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 홈텍스ID : hmtxId */
      listColumnDefs.add(new ColumnDef("홈텍스ID", PrgmComBass0150BM.ATTR_HMTXID, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 세무서코드 : txOffcCd */
      listColumnDefs.add(new ColumnDef("세무서코드", PrgmComBass0150BM.ATTR_TXOFFCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 은행코드 : bnkCd */
      listColumnDefs.add(new ColumnDef("은행코드", PrgmComBass0150BM.ATTR_BNKCD, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
      /** column 지로이체코드 : groTnsrCd */
      listColumnDefs.add(new ColumnDef("지로이체코드", PrgmComBass0150BM.ATTR_GROTNSRCD, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{
  
      	}
      });
//      /** column 입력자 : kybdr */
//      listColumnDefs.add(new ColumnDef("입력자", PrgmComBass0150BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//      	{
//  
//      	}
//      });
//      /** column 입력일자 : inptDt */
//      listColumnDefs.add(new ColumnDef("입력일자", PrgmComBass0150BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//      	{
//  
//      	}
//      });
//      /** column 입력주소 : inptAddr */
//      listColumnDefs.add(new ColumnDef("입력주소", PrgmComBass0150BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//      	{
//  
//      	}
//      });
//      /** column 수정자 : ismt */
//      listColumnDefs.add(new ColumnDef("수정자", PrgmComBass0150BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//      	{
//  
//      	}
//      });
//      /** column 수정일자 : revnDt */
//      listColumnDefs.add(new ColumnDef("수정일자", PrgmComBass0150BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//      	{
//  
//      	}
//      });
//      /** column 수정주소 : revnAddr */
//      listColumnDefs.add(new ColumnDef("수정주소", PrgmComBass0150BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//      	{
//  
//      	}
//      });
  
//      private TextField<String> dpobCd   /** column 사업장코드 : dpobCd */
  //
//      private TextField<String> payrMangDeptCd   /** column 단위기관코드 : payrMangDeptCd */
  //
//      private TextField<String> payMangeDeptNm   /** column 단위기관명 : payMangeDeptNm */
  //
//      private TextField<String> degtrResnRegnNum   /** column 대표자주민번호 : degtrResnRegnNum */
  //
//      private TextField<String> degtrNm   /** column 대표자명 : degtrNm */
  //
//      private TextField<String> busoprRgstnNum   /** column 사업자등록번호 : busoprRgstnNum */
  //
//      private TextField<String> corpRgstnNum   /** column 법인등록번호 : corpRgstnNum */
  //
//      private TextField<String> corpDivCd   /** column 법인구분코드 : corpDivCd */
  //
//      private TextField<String> payMangeDeptZpcd   /** column 단위기관우편번호 : payMangeDeptZpcd */
  //
//      private TextField<String> payMangeDeptFNdtnAddr   /** column 단위기관기본주소 : payMangeDeptFNdtnAddr */
  //
//      private TextField<String> payMangeDeptDtlPatrAddr   /** column 단위기관상세주소 : payMangeDeptDtlPatrAddr */
  //
//      private TextField<String> payMangeDeptPhnNum   /** column 단위기관전화번호 : payMangeDeptPhnNum */
  //
//      private TextField<String> payMangeDeptFaxNum   /** column 단위기관팩스번호 : payMangeDeptFaxNum */
  //
//      private TextField<String> payMangeDeptSealWrdNm   /** column 단위기관직인문구명 : payMangeDeptSealWrdNm */
  //
//      private TextField<String> payMangeDeptSealRftaNm   /** column 단위기관직인경로 : payMangeDeptSealRftaNm */
  //
//      private TextField<String> payMangeDeptSealFlNm   /** column 단위기관직인파일명 : payMangeDeptSealFlNm */
  //
//      private TextField<String> payMangeDeptFNdtnUseYn   /** column 단위기관기본사용여부 : payMangeDeptFNdtnUseYn */
  //
//      private TextField<String> payMangeDeptWhlePernChrg   /** column 단위기관총괄담당자 : payMangeDeptWhlePernChrg */
  //
//      private TextField<String> payMangeDeptDivTskOffr   /** column 단위기관분임지출관 : payMangeDeptDivTskOffr */
  //
//      private TextField<String> accCd   /** column 회계코드 : accCd */
  //
//      private TextField<String> hlthInsrSym   /** column 건강보험기호 : hlthInsrSym */
  //
//      private TextField<String> natPennSym   /** column 국민연금기호 : natPennSym */
  //
//      private TextField<String> umytInsrSym   /** column 고용보험기호 : umytInsrSym */
  //
//      private TextField<String> cllnDebrNm   /** column 징수의무자명 : cllnDebrNm */
  //
//      private TextField<String> hmtxId   /** column 홈텍스ID : hmtxId */
  //
//      private TextField<String> txOffcCd   /** column 세무서코드 : txOffcCd */
  //
//      private TextField<String> bnkCd   /** column 은행코드 : bnkCd */
  //
//      private TextField<String> groTnsrCd   /** column 지로이체코드 : groTnsrCd */
  //
//      private TextField<String> kybdr   /** column 입력자 : kybdr */
  //
//      private TextField<String> inptDt   /** column 입력일자 : inptDt */
  //
//      private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
  //
//      private TextField<String> ismt   /** column 수정자 : ismt */
  //
//      private TextField<String> revnDt   /** column 수정일자 : revnDt */
  //
//      private TextField<String> revnAddr   /** column 수정주소 : revnAddr */

        
        setColumnsDefinition(listColumnDefs);
    }
}
