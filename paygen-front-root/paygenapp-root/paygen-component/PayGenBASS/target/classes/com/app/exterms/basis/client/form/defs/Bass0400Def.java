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
import com.app.exterms.basis.client.dto.Bass0400BM;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass0400Def extends TableDef implements BasisDaoConstants {
    private int row = 0;
    
    private BasisConstants lblBasisConst = BasisConstants.INSTANCE;
    
    public Bass0400Def(){
    	
    	  setTitle(lblBasisConst.title_Bass0400());
          setDaoClass(CLASS_BASS0400_LIST); 
          setCustomListMethod(CLASS_BASS0400_LIST);
          setColumnsDefinition(getAllColumnsList()); 
          setAutoFillGrid(false);
          setShowFilterToolbar(false);
    }

	private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Bass0400BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 100, false, true, true));
        listColumnDefs.add(new ColumnDef("사업장명",  Bass0150BM.ATTR_DPOBNM,   ColumnDef.TYPE_STRING , 100, true, true, true));
        
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Bass0400BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, true, true, true));

        /** column 부서명_한글 : deptNmHan */
        listColumnDefs.add(new ColumnDef("부서명_한글", Bass0400BM.ATTR_DEPTNMHAN, ColumnDef.TYPE_STRING, 150, true, true, true));

        /** column 부서명_단축 : deptNmRtchnt */
        listColumnDefs.add(new ColumnDef("부서명_단축", Bass0400BM.ATTR_DEPTNMRTCHNT, ColumnDef.TYPE_STRING, 150, true, true, true));

        /** column 부서명_영문 : deptNmEng */
        listColumnDefs.add(new ColumnDef("부서명_영문", Bass0400BM.ATTR_DEPTNMENG, ColumnDef.TYPE_STRING, 150, true, true, true));

        /** column 최상위부서코드 : tplvlDeptCd */
        listColumnDefs.add(new ColumnDef("최상위부서코드", Bass0400BM.ATTR_TPLVLDEPTCD, ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** column 최상위부서코드명 : tplvlDeptCdNm */
        listColumnDefs.add(new ColumnDef("최상위부서코드명", Bass0400BM.ATTR_TPLVLDEPTCDNM, ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** column 상위부서코드 : hhrkDeptCd */
        listColumnDefs.add(new ColumnDef("상위부서코드", Bass0400BM.ATTR_HHRKDEPTCD, ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** column 상위부서코드명 : hhrkDeptCdNm */
        listColumnDefs.add(new ColumnDef("상위부서코드명", Bass0400BM.ATTR_HHRKDEPTCDNM, ColumnDef.TYPE_STRING, 90, true, true, true));

        /** column 개편전부서코드 : befDeptCd */
        listColumnDefs.add(new ColumnDef("개편전부서코드", Bass0400BM.ATTR_BEFDEPTCD, ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** column 개편전부서명 : befDeptNm */
        listColumnDefs.add(new ColumnDef("개편전부서명", Bass0400BM.ATTR_BEFDEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** column 개편전부서코드02 : befDeptCd02 */
        listColumnDefs.add(new ColumnDef("개편전부서코드2", Bass0400BM.ATTR_BEFDEPTCD02, ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** column 개편전부서명02 : befDeptNm02 */
        listColumnDefs.add(new ColumnDef("개편전부서명2", Bass0400BM.ATTR_BEFDEPTNM02, ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** column 부서사용여부 : deptUseYn */
        listColumnDefs.add(new ColumnDef("부서사용여부", Bass0400BM.ATTR_DEPTUSEYN, ColumnDef.TYPE_STRING, 90, true, true, true));

        /** column 부서출력여부 : deptDspyYn */
        listColumnDefs.add(new ColumnDef("부서출력여부", Bass0400BM.ATTR_DEPTDSPYYN, ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** column 건강보험기호 : hlthInsrSym */
        listColumnDefs.add(new ColumnDef("건강보험기호", Bass0400BM.ATTR_HLTHINSRSYM, ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** column 국민연금기호 : natPennSym */
        listColumnDefs.add(new ColumnDef("국민연금기호", Bass0400BM.ATTR_NATPENNSYM, ColumnDef.TYPE_STRING, 90, true, true, true));

        /** column 고용보험기호 : umytInsrSym */
        listColumnDefs.add(new ColumnDef("고용보험기호", Bass0400BM.ATTR_UMYTINSRSYM, ColumnDef.TYPE_STRING, 90, true, true, true));

        /** column 산재보험기호 : idtlAccdtInsurSym */
        listColumnDefs.add(new ColumnDef("산재보험기호", Bass0400BM.ATTR_IDTLACCDTINSURSYM, ColumnDef.TYPE_STRING, 90, true, true, true));

        /** column 부서비고내용 : deptNoteCtnt */
        listColumnDefs.add(new ColumnDef("부서비고내용", Bass0400BM.ATTR_DEPTNOTECTNT, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리부서코드 : mangeDeptCd */
        listColumnDefs.add(new ColumnDef("관리부서코드", Bass0400BM.ATTR_MANGEDEPTCD, ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** column 관리부서코드 : mangeDeptCdNm */
        listColumnDefs.add(new ColumnDef("관리부서코드명", Bass0400BM.ATTR_MANGEDEPTCDNM, ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** column 관리부서명_한글 : mangeDeptNmHan */
        listColumnDefs.add(new ColumnDef("부서명_한글", Bass0400BM.ATTR_MANGEDEPTNMHAN, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리부서명_단축 : mangeDeptNmRtchnt */
        listColumnDefs.add(new ColumnDef("부서명_단축", Bass0400BM.ATTR_MANGEDEPTNMRTCHNT, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 단위기관 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기간코드", Bass0400BM.ATTR_PAYR_MANG_DEPT_CD, ColumnDef.TYPE_STRING, 90, true, false, true));
        /** column 부서생성일자 : deptCreDt */
        listColumnDefs.add(new ColumnDef("부서생성일자", Bass0400BM.ATTR_DEPTCREDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 부서폐지일자 : deptEndDt */
        listColumnDefs.add(new ColumnDef("부서폐지일자", Bass0400BM.ATTR_DEPTENDDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        

        return listColumnDefs;
    }
}
