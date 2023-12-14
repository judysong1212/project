/**
 * 공통화면 팝업 
 */
package com.app.smrmf.syscom.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.syscom.client.dto.SysComCmmn0320BM;
import com.app.smrmf.syscom.client.languages.SysComConstants;
import com.app.smrmf.syscom.shared.SysComDaoConstants;


public class SysComCmmn0320Def  extends TableDef implements SysComDaoConstants {

    private int row = 0;
    private SysComConstants SysComLabel = SysComConstants.INSTANCE;

    public SysComCmmn0320Def(){
        setTitle(SysComLabel.titleSysComPopUpCmmn0320());
        setDaoClass(CLASS_SYSCOM_CMMN0320VO);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
 

		/** column 법정동코드 : cutdogCd */
		listColumnDefs.add(new ColumnDef("법정동코드", SysComCmmn0320BM.ATTR_CUTDOGCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 도로명시도 : roadNmCtapv */
		listColumnDefs.add(new ColumnDef("도로명시도", SysComCmmn0320BM.ATTR_ROADNMCTAPV, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 도로명시군구 : roadNmCtatgu */
		listColumnDefs.add(new ColumnDef("도로명시군구", SysComCmmn0320BM.ATTR_ROADNMCTATGU, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 도로명읍면 : roadNmTat */
		listColumnDefs.add(new ColumnDef("도로명읍면", SysComCmmn0320BM.ATTR_ROADNMTAT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 도로명리 : roadNmLi */
		listColumnDefs.add(new ColumnDef("도로명리", SysComCmmn0320BM.ATTR_ROADNMLI, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 도로명산구분 : roadNmSan */
		listColumnDefs.add(new ColumnDef("도로명산구분", SysComCmmn0320BM.ATTR_ROADNMSAN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 도로명지번본번 : roadNmLtnumBobn */
		listColumnDefs.add(new ColumnDef("도로명지번본번", SysComCmmn0320BM.ATTR_ROADNMLTNUMBOBN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{
		
			}
		});
		/** column 도로명지번부번 : roadNmLtnumBubn */
		listColumnDefs.add(new ColumnDef("도로명지번부번", SysComCmmn0320BM.ATTR_ROADNMLTNUMBUBN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{
		
			}
		});
		/** column 도로명코드 : roadNmCd */
		listColumnDefs.add(new ColumnDef("도로명코드", SysComCmmn0320BM.ATTR_ROADNMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 도로명 : roadNm */
		listColumnDefs.add(new ColumnDef("도로명", SysComCmmn0320BM.ATTR_ROADNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 도로명지하구분 : roadNmUngr */
		listColumnDefs.add(new ColumnDef("도로명지하구분", SysComCmmn0320BM.ATTR_ROADNMUNGR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 건물번호본번 : buildNumBobn */
		listColumnDefs.add(new ColumnDef("건물번호본번", SysComCmmn0320BM.ATTR_BUILDNUMBOBN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 건물번호부본 : buildNumBubn */
		listColumnDefs.add(new ColumnDef("건물번호부본", SysComCmmn0320BM.ATTR_BUILDNUMBUBN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 건물명 : buildNm */
		listColumnDefs.add(new ColumnDef("건물명", SysComCmmn0320BM.ATTR_BUILDNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 상세건물명 : dtlPatrBuildNm */
		listColumnDefs.add(new ColumnDef("상세건물명", SysComCmmn0320BM.ATTR_DTLPATRBUILDNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 건물관리번호 : buildMangeNum */
		listColumnDefs.add(new ColumnDef("건물관리번호", SysComCmmn0320BM.ATTR_BUILDMANGENUM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 읍면동일련번호 : tatdSeilNum */
		listColumnDefs.add(new ColumnDef("읍면동일련번호", SysComCmmn0320BM.ATTR_TATDSEILNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 행정동코드 : adsttDongCd */
		listColumnDefs.add(new ColumnDef("행정동코드", SysComCmmn0320BM.ATTR_ADSTTDONGCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 행정동명 : adsttDongNm */
		listColumnDefs.add(new ColumnDef("행정동명", SysComCmmn0320BM.ATTR_ADSTTDONGNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 우편번호 : zpcd */
		listColumnDefs.add(new ColumnDef("신우편번호", SysComCmmn0320BM.ATTR_ZPCD, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 우편번호일련번호 : zpcdSeilNum */
		listColumnDefs.add(new ColumnDef("우편번호일련번호", SysComCmmn0320BM.ATTR_ZPCDSEILNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 다량배달처명 : lotDsttnNm */
		listColumnDefs.add(new ColumnDef("다량배달처명", SysComCmmn0320BM.ATTR_LOTDSTTNNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 이동사유코드 : mvReasCd */
		listColumnDefs.add(new ColumnDef("이동사유코드", SysComCmmn0320BM.ATTR_MVREASCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 변경일자 : chngDt */
		listColumnDefs.add(new ColumnDef("변경일자", SysComCmmn0320BM.ATTR_CHNGDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 변경전도로명주소 : chngBfrRoadNmAddr */
		listColumnDefs.add(new ColumnDef("변경전도로명주소", SysComCmmn0320BM.ATTR_CHNGBFRROADNMADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 시군구용건물명 : ctatguBuildNm */
		listColumnDefs.add(new ColumnDef("시군구용건물명", SysComCmmn0320BM.ATTR_CTATGUBUILDNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 공동주택구분 : jonHus */
		listColumnDefs.add(new ColumnDef("공동주택구분", SysComCmmn0320BM.ATTR_JONHUS, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 기초구역번호 : baseArNum */
		listColumnDefs.add(new ColumnDef("신우편번호", SysComCmmn0320BM.ATTR_BASEARNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 상세주소여부 : dtlAddrYn */
		listColumnDefs.add(new ColumnDef("상세주소여부", SysComCmmn0320BM.ATTR_DTLADDRYN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 비고1 : postCtnt01 */
		listColumnDefs.add(new ColumnDef("비고1", SysComCmmn0320BM.ATTR_POSTCTNT01, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 비고2 : postCtnt02 */
		listColumnDefs.add(new ColumnDef("비고2", SysComCmmn0320BM.ATTR_POSTCTNT02, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", SysComCmmn0320BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", SysComCmmn0320BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", SysComCmmn0320BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", SysComCmmn0320BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", SysComCmmn0320BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", SysComCmmn0320BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});

        /** 기본주소 */
        listColumnDefs.add(new ColumnDef("기본주소", SysComCmmn0320BM.ATTR_FNDTNADDR, ColumnDef.TYPE_STRING, 200, false, true, true){
            {
               
            }
        });
        /** 상세주소 */
        listColumnDefs.add(new ColumnDef("상세주소", SysComCmmn0320BM.ATTR_DTLPATRADDR, ColumnDef.TYPE_STRING, 200, false, true, true){
            {
               
            }
        });
        setColumnsDefinition(listColumnDefs);
    }
}
