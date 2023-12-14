/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.basis.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.basis.client.dto.Bass0150BM;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass0150Def extends TableDef implements BasisDaoConstants {
    private int row = 0;
    
    private BasisConstants lblBasisConst = BasisConstants.INSTANCE;
    
    public Bass0150Def(){
    	
    	  setTitle(lblBasisConst.title_Bass0150());
          setDaoClass(CLASS_BASS0150_LIST); 
          setCustomListMethod(CLASS_BASS0150_LIST);
          setColumnsDefinition(getAllColumnsList());
          setAutoFillGrid(false);
          setShowFilterToolbar(false);
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        listColumnDefs.add(new ColumnDef("사업장코드",Bass0150BM.ATTR_DPOBCD,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("사업장명", Bass0150BM.ATTR_DPOBNM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        
        listColumnDefs.add(new ColumnDef("단위기관코드",  Bass0150BM.ATTR_PAYRMANGDEPTCD,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("단위기관명",   Bass0150BM.ATTR_PAYMANGEDEPTNM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("대표자주민번호", Bass0150BM.ATTR_DEGTRSECREGNNUM,   ColumnDef.TYPE_STRING , 0, false, false, false));
        listColumnDefs.add(new ColumnDef("대표자주민번호원본", Bass0150BM.ATTR_DEGTRRESNREGNNUM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        
        listColumnDefs.add(new ColumnDef("대표자명",   Bass0150BM.ATTR_DEGTRNM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("사업자등록번호",   Bass0150BM.ATTR_BUSOPRRGSTNNUM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("법인등록번호",   Bass0150BM.ATTR_CORPRGSTNNUM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("법인구분코드",   Bass0150BM.ATTR_CORPDIVCD,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("우편번호",   Bass0150BM.ATTR_PAYMANGEDEPTZPCD,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("기본주소",   Bass0150BM.ATTR_PAYMANGEDEPTFNDTNADDR,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("상세주소",   Bass0150BM.ATTR_PAYMANGEDEPTDTLPATRADDR,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("전화번호",   Bass0150BM.ATTR_PAYMANGEDEPTPHNNUM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("팩스번호",   Bass0150BM.ATTR_PAYMANGEDEPTFAXNUM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("직인문구명",   Bass0150BM.ATTR_PAYMANGEDEPTSEALWRDNM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("직인경로",   Bass0150BM.ATTR_PAYMANGEDEPTSEALRFTANM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("직인파일명",   Bass0150BM.ATTR_PAYMANGEDEPTSEALFLNM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("기본사용여부",   Bass0150BM.ATTR_PAYMANGEDEPTFNDTNUSEYN,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("업무담당자ID",   Bass0150BM.ATTR_PAYMANGEDEPTWHLEPERNCHRG,   ColumnDef.TYPE_STRING , 100, true, false, true));
        listColumnDefs.add(new ColumnDef("업무담당자",   Bass0150BM.ATTR_PAYMANGEDEPTWHLEPERNNM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("분임지출관ID",   Bass0150BM.ATTR_PAYMANGEDEPTDIVTSKOFFR,   ColumnDef.TYPE_STRING , 100, true, false, true));
        listColumnDefs.add(new ColumnDef("분임지출관",   Bass0150BM.ATTR_PAYMANGEDEPTDIVTSKNM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("회계코드",   Bass0150BM.ATTR_ACCCD,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("건강보험기호",   Bass0150BM.ATTR_HLTHINSRSYM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("국민연금기호",   Bass0150BM.ATTR_NATPENNSYM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("고용보험기호",   Bass0150BM.ATTR_UMYTINSRSYM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("산재보험기호",   Bass0150BM.ATTR_IDTLACCDTINSURSYM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("징수의무자명",   Bass0150BM.ATTR_CLLNDEBRNM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("홈텍스ID",   Bass0150BM.ATTR_HMTXID,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("세무서코드",   Bass0150BM.ATTR_TXOFFCCD,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("은행코드",   Bass0150BM.ATTR_BNKCD,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("지로이체코드",   Bass0150BM.ATTR_GROTNSRCD,   ColumnDef.TYPE_STRING , 100, true, true, true));
        listColumnDefs.add(new ColumnDef("입력자",   Bass0150BM.ATTR_KYBDR,   ColumnDef.TYPE_STRING , 100, true, false, false));
        listColumnDefs.add(new ColumnDef("입력일자",   Bass0150BM.ATTR_INPTDT,   ColumnDef.TYPE_STRING , 100, true, false, false));
        listColumnDefs.add(new ColumnDef("입력주소",   Bass0150BM.ATTR_INPTADDR,   ColumnDef.TYPE_STRING , 100, true, false, false));
        listColumnDefs.add(new ColumnDef("수정자",   Bass0150BM.ATTR_ISMT,   ColumnDef.TYPE_STRING , 100, true, false, false));
        listColumnDefs.add(new ColumnDef("수정일자",   Bass0150BM.ATTR_REVNDT,   ColumnDef.TYPE_STRING , 100, true, false, false));
        listColumnDefs.add(new ColumnDef("수정주소",   Bass0150BM.ATTR_REVNADDR,   ColumnDef.TYPE_STRING , 100, true, false, false));
        listColumnDefs.add(new ColumnDef("건강보험영업소기호",   Bass0150BM.ATTR_HLTHINSROFCESYM,   ColumnDef.TYPE_STRING , 110, true, false, false));
        
        return listColumnDefs;
    }
}
