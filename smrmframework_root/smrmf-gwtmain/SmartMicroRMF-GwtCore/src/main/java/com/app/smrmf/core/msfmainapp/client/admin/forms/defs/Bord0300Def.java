/**
 * 공통화면 팝업 
 */
package com.app.smrmf.core.msfmainapp.client.admin.forms.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.admin.dto.Bord0300BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.languages.MSFConstants;
import com.app.smrmf.core.msfmainapp.shared.MSFDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Bord0300Def  extends TableDef implements MSFDaoConstants {

    private int row = 0;
    private MSFConstants MSFConLabel = MSFConstants.INSTANCE;

    public Bord0300Def(){
        setTitle("");
        setDaoClass("");
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        /** column 시스템구분코드 : sysDivCd */
        listColumnDefs.add(new ColumnDef("시스템구분코드", Bord0300BM.ATTR_SYSDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 게시글일련번호 : bullBordMsgeSeilNum */
        listColumnDefs.add(new ColumnDef("게시글일련번호", Bord0300BM.ATTR_BULLBORDMSGESEILNUM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 게시판_UID : bullBordUid */
        listColumnDefs.add(new ColumnDef("게시판_UID", Bord0300BM.ATTR_BULLBORDUID, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 게시판그룹ID : bullBordGrpId */
        listColumnDefs.add(new ColumnDef("게시판그룹ID", Bord0300BM.ATTR_BULLBORDGRPID, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 최상위 글 정보 : tplvlWrtnInfo */
        listColumnDefs.add(new ColumnDef("최상위 글 정보", Bord0300BM.ATTR_TPLVLWRTNINFO, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 글의 답변단계 : wrtnAswrStge */
        listColumnDefs.add(new ColumnDef("글의 답변단계", Bord0300BM.ATTR_WRTNASWRSTGE, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 글의 등록된 순서 : wrtnRgstnOrd */
        listColumnDefs.add(new ColumnDef("글의 등록된 순서", Bord0300BM.ATTR_WRTNRGSTNORD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 답변하는 글의 번호 : aswrWrtnNum */
        listColumnDefs.add(new ColumnDef("답변하는 글의 번호", Bord0300BM.ATTR_ASWRWRTNNUM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 작성자 이름 : ppgPernNm */
        listColumnDefs.add(new ColumnDef("작성자 이름", Bord0300BM.ATTR_PPGPERNNM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 사용자 아이디 : usrId */
        listColumnDefs.add(new ColumnDef("사용자 아이디", Bord0300BM.ATTR_USRID, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 제목 : bullBordMsgeTtl */
        listColumnDefs.add(new ColumnDef("제목", Bord0300BM.ATTR_BULLBORDMSGETTL, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 내용 : bullBordMsgeCtnt */
        listColumnDefs.add(new ColumnDef("내용", Bord0300BM.ATTR_BULLBORDMSGECTNT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 글 비밀번호 : wrtnSecrNum */
        listColumnDefs.add(new ColumnDef("글 비밀번호", Bord0300BM.ATTR_WRTNSECRNUM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 작성자 메일 : ppgPernEmail */
        listColumnDefs.add(new ColumnDef("작성자 메일", Bord0300BM.ATTR_PPGPERNEMAIL, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 조회수 : inqyNum */
        listColumnDefs.add(new ColumnDef("조회수", Bord0300BM.ATTR_INQYNUM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column HTML 사용여부 : htmlUseYn */
        listColumnDefs.add(new ColumnDef("HTML 사용여부", Bord0300BM.ATTR_HTMLUSEYN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 삭제 여부 : bullBordMsgeDelYn */
        listColumnDefs.add(new ColumnDef("삭제 여부", Bord0300BM.ATTR_BULLBORDMSGEDELYN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 공지 시작일 : notiBgnnDt */
        listColumnDefs.add(new ColumnDef("공지 시작일", Bord0300BM.ATTR_NOTIBGNNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 공지 종료일 : notiEndDt */
        listColumnDefs.add(new ColumnDef("공지 종료일", Bord0300BM.ATTR_NOTIENDDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Bord0300BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Bord0300BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Bord0300BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Bord0300BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Bord0300BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Bord0300BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> sysDivCd   /** column 시스템구분코드 : sysDivCd */
//
//        private TextField<String> bullBordMsgeSeilNum   /** column 게시글일련번호 : bullBordMsgeSeilNum */
//
//        private TextField<String> bullBordUid   /** column 게시판_UID : bullBordUid */
//
//        private TextField<String> bullBordGrpId   /** column 게시판그룹ID : bullBordGrpId */
//
//        private TextField<String> tplvlWrtnInfo   /** column 최상위 글 정보 : tplvlWrtnInfo */
//
//        private TextField<String> wrtnAswrStge   /** column 글의 답변단계 : wrtnAswrStge */
//
//        private TextField<String> wrtnRgstnOrd   /** column 글의 등록된 순서 : wrtnRgstnOrd */
//
//        private TextField<String> aswrWrtnNum   /** column 답변하는 글의 번호 : aswrWrtnNum */
//
//        private TextField<String> ppgPernNm   /** column 작성자 이름 : ppgPernNm */
//
//        private TextField<String> usrId   /** column 사용자 아이디 : usrId */
//
//        private TextField<String> bullBordMsgeTtl   /** column 제목 : bullBordMsgeTtl */
//
//        private TextField<String> bullBordMsgeCtnt   /** column 내용 : bullBordMsgeCtnt */
//
//        private TextField<String> wrtnSecrNum   /** column 글 비밀번호 : wrtnSecrNum */
//
//        private TextField<String> ppgPernEmail   /** column 작성자 메일 : ppgPernEmail */
//
//        private TextField<String> inqyNum   /** column 조회수 : inqyNum */
//
//        private TextField<String> htmlUseYn   /** column HTML 사용여부 : htmlUseYn */
//
//        private TextField<String> bullBordMsgeDelYn   /** column 삭제 여부 : bullBordMsgeDelYn */
//
//        private TextField<String> notiBgnnDt   /** column 공지 시작일 : notiBgnnDt */
//
//        private TextField<String> notiEndDt   /** column 공지 종료일 : notiEndDt */
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
