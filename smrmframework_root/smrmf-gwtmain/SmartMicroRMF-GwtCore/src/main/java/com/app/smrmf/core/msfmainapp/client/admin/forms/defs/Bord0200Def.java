/**
 * 공통화면 팝업 
 */
package com.app.smrmf.core.msfmainapp.client.admin.forms.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.admin.dto.Bord0200BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.languages.MSFConstants;
import com.app.smrmf.core.msfmainapp.shared.MSFDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Bord0200Def  extends TableDef implements MSFDaoConstants {

    private int row = 0;
    private MSFConstants MSFConLabel = MSFConstants.INSTANCE;

    public Bord0200Def(){
        setTitle("");
        setDaoClass("");
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        /** column 시스템구분코드 : sysDivCd */
        listColumnDefs.add(new ColumnDef("시스템구분코드", Bord0200BM.ATTR_SYSDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 게시판_UID : bullBordUid */
        listColumnDefs.add(new ColumnDef("게시판_UID", Bord0200BM.ATTR_BULLBORDUID, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 게시판그룹ID : bullBordGrpId */
        listColumnDefs.add(new ColumnDef("게시판그룹ID", Bord0200BM.ATTR_BULLBORDGRPID, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 제목 : ttl */
        listColumnDefs.add(new ColumnDef("제목", Bord0200BM.ATTR_TTL, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 게시판_제목_텍스트 : bullBordTtlTxt */
        listColumnDefs.add(new ColumnDef("게시판_제목_텍스트", Bord0200BM.ATTR_BULLBORDTTLTXT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 게시판 설명 : bullBordEpln */
        listColumnDefs.add(new ColumnDef("게시판 설명", Bord0200BM.ATTR_BULLBORDEPLN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 게시물 수 : notMateNum */
        listColumnDefs.add(new ColumnDef("게시물 수", Bord0200BM.ATTR_NOTMATENUM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 페이지 테그 크기 : pageTagSz */
        listColumnDefs.add(new ColumnDef("페이지 테그 크기", Bord0200BM.ATTR_PAGETAGSZ, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 스킨 타입 : sknTyp */
        listColumnDefs.add(new ColumnDef("스킨 타입", Bord0200BM.ATTR_SKNTYP, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 최근 글 설정 : nlsncWrtnStp */
        listColumnDefs.add(new ColumnDef("최근 글 설정", Bord0200BM.ATTR_NLSNCWRTNSTP, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 게시판 정렬 : bullBordRnge */
        listColumnDefs.add(new ColumnDef("게시판 정렬", Bord0200BM.ATTR_BULLBORDRNGE, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 게시판 크기 : bullBordSz */
        listColumnDefs.add(new ColumnDef("게시판 크기", Bord0200BM.ATTR_BULLBORDSZ, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 게시물의 제목 표현방법 : notMateTtlEpsnMensCd */
        listColumnDefs.add(new ColumnDef("게시물의 제목 표현방법", Bord0200BM.ATTR_NOTMATETTLEPSNMENSCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 답변글 사용 : aswrWrtnUseYn */
        listColumnDefs.add(new ColumnDef("답변글 사용", Bord0200BM.ATTR_ASWRWRTNUSEYN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 댓글 사용 : comtUseYn */
        listColumnDefs.add(new ColumnDef("댓글 사용", Bord0200BM.ATTR_COMTUSEYN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 파일 첨부 사용 : flAttcUseYn */
        listColumnDefs.add(new ColumnDef("파일 첨부 사용", Bord0200BM.ATTR_FLATTCUSEYN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 게시판 알림 기능 사용 : bullBordNtfnFuncUseYn */
        listColumnDefs.add(new ColumnDef("게시판 알림 기능 사용", Bord0200BM.ATTR_BULLBORDNTFNFUNCUSEYN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 관리자에게 메일 발송 사용 : adminEmailSndUseYn */
        listColumnDefs.add(new ColumnDef("관리자에게 메일 발송 사용", Bord0200BM.ATTR_ADMINEMAILSNDUSEYN, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 삭제구분플래그 : delDivFlag */
        listColumnDefs.add(new ColumnDef("삭제구분플래그", Bord0200BM.ATTR_DELDIVFLAG, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 리스트 형태 : lstShape */
        listColumnDefs.add(new ColumnDef("리스트 형태", Bord0200BM.ATTR_LSTSHAPE, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 링크 URI : lnkUrl */
        listColumnDefs.add(new ColumnDef("링크 URI", Bord0200BM.ATTR_LNKURL, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 첨부파일 크기 : attcFlSz */
        listColumnDefs.add(new ColumnDef("첨부파일 크기", Bord0200BM.ATTR_ATTCFLSZ, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Bord0200BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Bord0200BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Bord0200BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Bord0200BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Bord0200BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Bord0200BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> sysDivCd   /** column 시스템구분코드 : sysDivCd */
//
//        private TextField<String> bullBordUid   /** column 게시판_UID : bullBordUid */
//
//        private TextField<String> bullBordGrpId   /** column 게시판그룹ID : bullBordGrpId */
//
//        private TextField<String> ttl   /** column 제목 : ttl */
//
//        private TextField<String> bullBordTtlTxt   /** column 게시판_제목_텍스트 : bullBordTtlTxt */
//
//        private TextField<String> bullBordEpln   /** column 게시판 설명 : bullBordEpln */
//
//        private TextField<String> notMateNum   /** column 게시물 수 : notMateNum */
//
//        private TextField<String> pageTagSz   /** column 페이지 테그 크기 : pageTagSz */
//
//        private TextField<String> sknTyp   /** column 스킨 타입 : sknTyp */
//
//        private TextField<String> nlsncWrtnStp   /** column 최근 글 설정 : nlsncWrtnStp */
//
//        private TextField<String> bullBordRnge   /** column 게시판 정렬 : bullBordRnge */
//
//        private TextField<String> bullBordSz   /** column 게시판 크기 : bullBordSz */
//
//        private TextField<String> notMateTtlEpsnMensCd   /** column 게시물의 제목 표현방법 : notMateTtlEpsnMensCd */
//
//        private TextField<String> aswrWrtnUseYn   /** column 답변글 사용 : aswrWrtnUseYn */
//
//        private TextField<String> comtUseYn   /** column 댓글 사용 : comtUseYn */
//
//        private TextField<String> flAttcUseYn   /** column 파일 첨부 사용 : flAttcUseYn */
//
//        private TextField<String> bullBordNtfnFuncUseYn   /** column 게시판 알림 기능 사용 : bullBordNtfnFuncUseYn */
//
//        private TextField<String> adminEmailSndUseYn   /** column 관리자에게 메일 발송 사용 : adminEmailSndUseYn */
//
//        private TextField<String> delDivFlag   /** column 삭제구분플래그 : delDivFlag */
//
//        private TextField<String> lstShape   /** column 리스트 형태 : lstShape */
//
//        private TextField<String> lnkUrl   /** column 링크 URI : lnkUrl */
//
//        private TextField<String> attcFlSz   /** column 첨부파일 크기 : attcFlSz */
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
