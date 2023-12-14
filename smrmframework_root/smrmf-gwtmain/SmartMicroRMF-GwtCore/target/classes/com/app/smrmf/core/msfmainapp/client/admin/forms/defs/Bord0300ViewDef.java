/**
 * 공통화면 팝업 
 */
package com.app.smrmf.core.msfmainapp.client.admin.forms.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.admin.dto.Bord0300BM;
import com.app.smrmf.core.msfmainapp.client.admin.dto.Bord0400BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.languages.MSFConstants;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.RegEx;
import com.app.smrmf.core.msfmainapp.shared.MSFDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Bord0300ViewDef  extends TableDef implements MSFDaoConstants {

    private int row = 0;
    private MSFConstants MSFConLabel = MSFConstants.INSTANCE;

    public Bord0300ViewDef(){
        setTitle("공지사항작성");
        setDaoClass(CLASS_BORD0300VIEW_LIST);
        setCustomListMethod(CLASS_BORD0300VIEW_LIST);
        setAutoFillGrid(false);
        setCheckBoxOnGridRows(true);
        

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           
        /** column 시스템구분코드 : sysDivCd */
        listColumnDefs.add(new ColumnDef("시스템구분코드", Bord0300BM.ATTR_SYSDIVCD, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{

        	}
        });
        /** column 게시글일련번호 : bullBordMsgeSeilNum */
        listColumnDefs.add(new ColumnDef("번호", Bord0300BM.ATTR_BULLBORDMSGESEILNUM, ColumnDef.TYPE_LONG, 70, false, true, true){
        	{
              setReadOnly(true);
        	}
        });
        /** column 게시판_UID : bullBordUid */
        listColumnDefs.add(new ColumnDef("게시판_UID", Bord0300BM.ATTR_BULLBORDUID, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{

        	}
        });
        /** column 게시판그룹ID : bullBordGrpId */
        listColumnDefs.add(new ColumnDef("게시판그룹ID", Bord0300BM.ATTR_BULLBORDGRPID, ColumnDef.TYPE_LONG, 90, false, false, false){
        	{

        	}
        });
        /** column 최상위 글 정보 : tplvlWrtnInfo */
        listColumnDefs.add(new ColumnDef("최상위 글 정보", Bord0300BM.ATTR_TPLVLWRTNINFO, ColumnDef.TYPE_LONG, 90, false, false, false){
        	{

        	}
        });
        /** column 글의 답변단계 : wrtnAswrStge */
        listColumnDefs.add(new ColumnDef("글의 답변단계", Bord0300BM.ATTR_WRTNASWRSTGE, ColumnDef.TYPE_LONG, 90, false, false, false){
        	{

        	}
        });
        /** column 글의 등록된 순서 : wrtnRgstnOrd */
        listColumnDefs.add(new ColumnDef("글의 등록된 순서", Bord0300BM.ATTR_WRTNRGSTNORD, ColumnDef.TYPE_LONG, 90, false, false, false){
        	{

        	}
        });
        /** column 답변하는 글의 번호 : aswrWrtnNum */
        listColumnDefs.add(new ColumnDef("답변하는 글의 번호", Bord0300BM.ATTR_ASWRWRTNNUM, ColumnDef.TYPE_LONG, 90, false, false, false){
        	{

        	}
        });
      
        /** column 제목 : bullBordMsgeTtl */
        listColumnDefs.add(new ColumnDef("제목", Bord0300BM.ATTR_BULLBORDMSGETTL, ColumnDef.TYPE_STRING, 500, false, true, true){
            {

            }
        });
        /** column 내용 : bullBordMsgeCtnt */
        listColumnDefs.add(new ColumnDef("내용", Bord0300BM.ATTR_BULLBORDMSGECTNT, ColumnDef.TYPE_STRING, 630, false, false, true){
            {
                setTypeTextField(ColumnDef.HTMLEDITOR); 
            }
        });
       
        /** column 글 비밀번호 : wrtnSecrNum */
        listColumnDefs.add(new ColumnDef("글 비밀번호", Bord0300BM.ATTR_WRTNSECRNUM, ColumnDef.TYPE_STRING, 90, false, false, false){
            {

            }
        });
        /** column 작성자 메일 : ppgPernEmail */
        listColumnDefs.add(new ColumnDef("메일", Bord0300BM.ATTR_PPGPERNEMAIL, ColumnDef.TYPE_STRING, 130, false, true, true){
            {
                setRegEx(RegEx.EMAIL);
            }
        });
        /** column 조회수 : inqyNum */
        listColumnDefs.add(new ColumnDef("조회수", Bord0300BM.ATTR_INQYNUM, ColumnDef.TYPE_LONG, 60, false, false, false){
            {

            }
        });
        
        /** column 게시글파일경로 : flRfta */
        listColumnDefs.add(new ColumnDef("파일경로", Bord0400BM.ATTR_FLRFTA, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 파일 이름 : flNm */
        listColumnDefs.add(new ColumnDef("파일",Bord0400BM.ATTR_FLNM , ColumnDef.TYPE_STRING , 80, false, true, false){
            {
               //setAttributeFormula("'FILE'");
                 setGridCellRenderer(GWTUtils.createLinkUrlColumnRenderer(
                         Bord0400BM.ATTR_FLNM, Bord0400BM.ATTR_FLNM, "down/BoardFileDownload.do" ));  //Bord0400BM.ATTR_FLRFTA
             
            }
        }); 
        
        /** column 작성자 이름 : ppgPernNm */
        listColumnDefs.add(new ColumnDef("작성자", Bord0300BM.ATTR_PPGPERNNM, ColumnDef.TYPE_STRING, 100, false, true, true){
            {

            }
        });
        /** column 사용자 아이디 : usrId */
        listColumnDefs.add(new ColumnDef("사용자 아이디", Bord0300BM.ATTR_USRID, ColumnDef.TYPE_STRING, 90, false, false, false){
            {

            }
        });
      
        /** column HTML 사용여부 : htmlUseYn */
        listColumnDefs.add(new ColumnDef("HTML 사용여부", Bord0300BM.ATTR_HTMLUSEYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 삭제 여부 : bullBordMsgeDelYn */
        listColumnDefs.add(new ColumnDef("삭제 여부", Bord0300BM.ATTR_BULLBORDMSGEDELYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 공지 시작일 : notiBgnnDt */
        listColumnDefs.add(new ColumnDef("공지 시작일", Bord0300BM.ATTR_NOTIBGNNDT, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{

        	}
        });
        /** column 공지 종료일 : notiEndDt */
        listColumnDefs.add(new ColumnDef("공지 종료일", Bord0300BM.ATTR_NOTIENDDT, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("등록일자", Bord0300BM.ATTR_INPTDT, ColumnDef.TYPE_DATE, 80, true, true, true){
            {

            }
        });
  
        setColumnsDefinition(listColumnDefs);
    }
}
