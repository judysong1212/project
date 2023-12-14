/**
 * 공통화면 팝업 
 */
package com.app.exterms.prgm.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0350BM;
import com.app.exterms.prgm.client.languages.PrgmConstants;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class PrgmComBass0350Def  extends TableDef implements PrgmComDaoConstants {

    private int row = 0;
    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;

    public PrgmComBass0350Def(){
        setTitle("직종-직종세검색");
        setDaoClass(CLASS_SYSCOM_BASS0350VO);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", PrgmComBass0350BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", PrgmComBass0350BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", PrgmComBass0350BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", PrgmComBass0350BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
       
        /** column 직종세코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세코드", PrgmComBass0350BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", PrgmComBass0350BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        
        /** column 호봉등급 : pyspGrdeNm */
        listColumnDefs.add(new ColumnDef("등급", PrgmComBass0350BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 직종세명 : dtilOccuClsNm */
        listColumnDefs.add(new ColumnDef("직종세명", PrgmComBass0350BM.ATTR_DTILOCCUCLSNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세직군구분코드 : dtilOccuJbfmlDivCd */
        listColumnDefs.add(new ColumnDef("직종세직군구분코드", PrgmComBass0350BM.ATTR_DTILOCCUJBFMLDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세사용여부 : dtilOccuClsUseYn */
        listColumnDefs.add(new ColumnDef("직종세사용여부", PrgmComBass0350BM.ATTR_DTILOCCUCLSUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 전환대상여부 : chngTgtYn */
        listColumnDefs.add(new ColumnDef("전환대상여부", PrgmComBass0350BM.ATTR_CHNGTGTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세내용 : dtilOccuClsCtnt */
        listColumnDefs.add(new ColumnDef("직종세내용", PrgmComBass0350BM.ATTR_DTILOCCUCLSCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정렬순서 : dtilOccuClsOrd */
        listColumnDefs.add(new ColumnDef("정렬순서", PrgmComBass0350BM.ATTR_DTILOCCUCLSORD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 최대근속년수코드 : bggLogSvcYrNumCd */
        listColumnDefs.add(new ColumnDef("최대근속년수코드", PrgmComBass0350BM.ATTR_BGGLOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", PrgmComBass0350BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", PrgmComBass0350BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", PrgmComBass0350BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", PrgmComBass0350BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", PrgmComBass0350BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", PrgmComBass0350BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> dtilOccuInttnCd;   /** column 직종세통합코드 : dtilOccuInttnCd */
//
//        private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
//
//        private TextField<String> dtilOccuClsDivCd;   /** column 직종세코드 : dtilOccuClsDivCd */
//
//        private TextField<String> pyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
//
//        private TextField<String> dtilOccuClsNm;   /** column 직종세명 : dtilOccuClsNm */
//
//        private TextField<String> dtilOccuJbfmlDivCd;   /** column 직종세직군구분코드 : dtilOccuJbfmlDivCd */
//
//        private TextField<String> dtilOccuClsUseYn;   /** column 직종세사용여부 : dtilOccuClsUseYn */
//
//        private TextField<String> chngTgtYn;   /** column 전환대상여부 : chngTgtYn */
//
//        private TextField<String> dtilOccuClsCtnt;   /** column 직종세내용 : dtilOccuClsCtnt */
//
//        private TextField<String> dtilOccuClsOrd;   /** column 정렬순서 : dtilOccuClsOrd */
//
//        private TextField<String> bggLogSvcYrNumCd;   /** column 최대근속년수코드 : bggLogSvcYrNumCd */
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
       

        
        setColumnsDefinition(listColumnDefs);
    }
}
