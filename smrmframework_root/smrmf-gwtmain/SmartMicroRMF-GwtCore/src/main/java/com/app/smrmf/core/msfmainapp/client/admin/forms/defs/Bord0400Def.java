/**
 * 공통화면 팝업 
 */
package com.app.smrmf.core.msfmainapp.client.admin.forms.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.admin.dto.Bord0400BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.languages.MSFConstants;
import com.app.smrmf.core.msfmainapp.shared.MSFDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Bord0400Def  extends TableDef implements MSFDaoConstants {

    private int row = 0;
    private MSFConstants MSFConLabel = MSFConstants.INSTANCE;

    public Bord0400Def(){
        setTitle("");
        setDaoClass("");
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        /** column 시스템구분코드 : sysDivCd */
        listColumnDefs.add(new ColumnDef("시스템구분코드", Bord0400BM.ATTR_SYSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 게시글첨부파일일련번호 : bullBordMsgeAttcFlNum */
        listColumnDefs.add(new ColumnDef("게시글첨부파일일련번호", Bord0400BM.ATTR_BULLBORDMSGEATTCFLNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
            {

            }
        });
        /** column 게시글일련번호 : bullBordMsgeSeilNum */
        listColumnDefs.add(new ColumnDef("게시글일련번호", Bord0400BM.ATTR_BULLBORDMSGESEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
            {

            }
        });
        /** column 게시판_UID : bullBordUid */
        listColumnDefs.add(new ColumnDef("게시판_UID", Bord0400BM.ATTR_BULLBORDUID, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 게시판그룹ID : bullBordGrpId */
        listColumnDefs.add(new ColumnDef("게시판그룹ID", Bord0400BM.ATTR_BULLBORDGRPID, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
            {

            }
        });
        /** column 게시글파일경로 : flRfta */
        listColumnDefs.add(new ColumnDef("게시글파일경로", Bord0400BM.ATTR_FLRFTA, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 파일 이름 : flNm */
        listColumnDefs.add(new ColumnDef("파일 이름", Bord0400BM.ATTR_FLNM, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 파일 크기 : flSz */
        listColumnDefs.add(new ColumnDef("파일 크기", Bord0400BM.ATTR_FLSZ, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 콘텐트 타입 : ctntTyp */
        listColumnDefs.add(new ColumnDef("콘텐트 타입", Bord0400BM.ATTR_CTNTTYP, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 다운로드 수 : dwldNum */
        listColumnDefs.add(new ColumnDef("다운로드 수", Bord0400BM.ATTR_DWLDNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
            {

            }
        });
        /** column 이미지 크기 넓이 : imgSzEtt */
        listColumnDefs.add(new ColumnDef("이미지 크기 넓이", Bord0400BM.ATTR_IMGSZETT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
            {

            }
        });
        /** column 이미지 크기 높이 : imgSzHeit */
        listColumnDefs.add(new ColumnDef("이미지 크기 높이", Bord0400BM.ATTR_IMGSZHEIT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
            {

            }
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Bord0400BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Bord0400BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Bord0400BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Bord0400BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Bord0400BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Bord0400BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
      

//        private TextField<String> sysDivCd;   /** column 시스템구분코드 : sysDivCd */
//
//        private TextField<String> bullBordMsgeAttcFlNum;   /** column 게시글첨부파일일련번호 : bullBordMsgeAttcFlNum */
//
//        private TextField<String> bullBordMsgeSeilNum;   /** column 게시글일련번호 : bullBordMsgeSeilNum */
//
//        private TextField<String> bullBordUid;   /** column 게시판_UID : bullBordUid */
//
//        private TextField<String> bullBordGrpId;   /** column 게시판그룹ID : bullBordGrpId */
//
//        private TextField<String> flNm;   /** column 파일 이름 : flNm */
//
//        private TextField<String> flSz;   /** column 파일 크기 : flSz */
//
//        private TextField<String> ctntTyp;   /** column 콘텐트 타입 : ctntTyp */
//
//        private TextField<String> dwldNum;   /** column 다운로드 수 : dwldNum */
//
//        private TextField<String> imgSzEtt;   /** column 이미지 크기 넓이 : imgSzEtt */
//
//        private TextField<String> imgSzHeit;   /** column 이미지 크기 높이 : imgSzHeit */
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
//        private TextField<String> flRfta;   /** column 게시글파일경로 : flRfta */

        
        setColumnsDefinition(listColumnDefs);
    }
}
