/**
 * 공통화면 팝업 
 */
package com.app.smrmf.core.msfmainapp.client.admin.forms.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.admin.dto.Bord0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.languages.MSFConstants;
import com.app.smrmf.core.msfmainapp.shared.MSFDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Bord0100Def  extends TableDef implements MSFDaoConstants {

    private int row = 0;
    private MSFConstants MSFConLabel = MSFConstants.INSTANCE;

    public Bord0100Def(){
        setTitle("");
        setDaoClass("");
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** column 시스템구분코드 : sysDivCd */
        listColumnDefs.add(new ColumnDef("시스템구분코드", Bord0100BM.ATTR_SYSDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 게시판그룹ID : bullBordGrpId */
        listColumnDefs.add(new ColumnDef("게시판그룹ID", Bord0100BM.ATTR_BULLBORDGRPID, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 게시판 상위그룹ID : bullBordHhrkGrpId */
        listColumnDefs.add(new ColumnDef("게시판 상위그룹ID", Bord0100BM.ATTR_BULLBORDHHRKGRPID, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 깊이 : dpth */
        listColumnDefs.add(new ColumnDef("깊이", Bord0100BM.ATTR_DPTH, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 게시판그룹명 : bullBordGrpNm */
        listColumnDefs.add(new ColumnDef("게시판그룹명", Bord0100BM.ATTR_BULLBORDGRPNM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Bord0100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Bord0100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Bord0100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Bord0100BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Bord0100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Bord0100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> sysDivCd   /** column 시스템구분코드 : sysDivCd */
//
//        private TextField<String> bullBordGrpId   /** column 게시판그룹ID : bullBordGrpId */
//
//        private TextField<String> bullBordHhrkGrpId   /** column 게시판 상위그룹ID : bullBordHhrkGrpId */
//
//        private TextField<String> dpth   /** column 깊이 : dpth */
//
//        private TextField<String> bullBordGrpNm   /** column 게시판그룹명 : bullBordGrpNm */
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
