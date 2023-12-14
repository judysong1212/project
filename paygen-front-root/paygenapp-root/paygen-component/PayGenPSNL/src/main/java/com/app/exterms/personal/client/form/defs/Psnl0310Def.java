package com.app.exterms.personal.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0310BM;
import com.app.exterms.personal.client.languages.PsnlConstants;
import com.app.exterms.personal.shared.PsnlDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Psnl0310Def  extends TableDef implements PsnlDaoConstants {

    private int row = 0;
    private PsnlConstants psnlLabel = PsnlConstants.INSTANCE;
    

    public Psnl0310Def(String chkDef){
    	if ("PSNL0310".equals(chkDef)) {
	        setTitle("");
//	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
	        
	        //TODO 추후 수정
	        setCustomListMethod(CLASS_PSNL0300_DATA_LIST);
	        
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
	        setColumnsDefinition(getPsnl0310ColumnsList());  
	      
    	}
//    	else if ("".equals(chkDef)) {
//	        setTitle("");
////	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
//	        setCustomListMethod(CLASS_PSNL0300_DATA_LIST);
//	        setColumnsDefinition(getPsnl0295ToPsnl0126ColumnsList());
//	        setAutoFillGrid(false);
//	        setShowFilterToolbar(false);
//	        setCheckBoxOnGridRows(false);
//	        setEditFieldGrid(false);
////	        setCellModel(true);
//	        
//    	}
    }

    private List<ColumnDef> getPsnl0310ColumnsList(){ 
    	
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Psnl0310BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0310BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 발령일련번호 : appmtSeilNum */
        listColumnDefs.add(new ColumnDef("발령일련번호", Psnl0310BM.ATTR_APPMTSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 발령구분코드 : appmtDivCd */
        listColumnDefs.add(new ColumnDef("발령구분코드", Psnl0310BM.ATTR_APPMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 발령일자 : appmtDt */
        listColumnDefs.add(new ColumnDef("발령일자", Psnl0310BM.ATTR_APPMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 전_부서코드 : bfrDeptCd */
        listColumnDefs.add(new ColumnDef("전_부서코드", Psnl0310BM.ATTR_BFRDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 전_사업코드 : bfrBusinCd */
        listColumnDefs.add(new ColumnDef("전_사업코드", Psnl0310BM.ATTR_BFRBUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 전_직종구분코드 : bfrTypOccuDivCd */
        listColumnDefs.add(new ColumnDef("전_직종구분코드", Psnl0310BM.ATTR_BFRTYPOCCUDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 전_직책구분코드 : bfrOdtyDivCd */
        listColumnDefs.add(new ColumnDef("전_직책구분코드", Psnl0310BM.ATTR_BFRODTYDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 전호봉코드 : bfrPyspCd */
        listColumnDefs.add(new ColumnDef("전호봉코드", Psnl0310BM.ATTR_BFRPYSPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 전호봉등급코드 : bfrPyspGrdeCd */
        listColumnDefs.add(new ColumnDef("전호봉등급코드", Psnl0310BM.ATTR_BFRPYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 전근속년수코드 : bfrLogSvcYrNumCd */
        listColumnDefs.add(new ColumnDef("전근속년수코드", Psnl0310BM.ATTR_BFRLOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 후_부서코드 : aftDeptCd */
        listColumnDefs.add(new ColumnDef("후_부서코드", Psnl0310BM.ATTR_AFTDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 후_사업코드 : aftBusinCd */
        listColumnDefs.add(new ColumnDef("후_사업코드", Psnl0310BM.ATTR_AFTBUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 후_직종구분코드 : aftTypOccuDivCd */
        listColumnDefs.add(new ColumnDef("후_직종구분코드", Psnl0310BM.ATTR_AFTTYPOCCUDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 후_직책구분코드 : aftOdtyDivCd */
        listColumnDefs.add(new ColumnDef("후_직책구분코드", Psnl0310BM.ATTR_AFTODTYDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 후_호봉코드 : aftPyspCd */
        listColumnDefs.add(new ColumnDef("후_호봉코드", Psnl0310BM.ATTR_AFTPYSPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 후_호봉등급코드 : aftPyspGrdeCd */
        listColumnDefs.add(new ColumnDef("후_호봉등급코드", Psnl0310BM.ATTR_AFTPYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 후_근속년수코드 : aftLogSvcYrNumCd */
        listColumnDefs.add(new ColumnDef("후_근속년수코드", Psnl0310BM.ATTR_AFTLOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 발령확정여부 : appmtFixYn */
        listColumnDefs.add(new ColumnDef("발령확정여부", Psnl0310BM.ATTR_APPMTFIXYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 배치실행일자 : confrtnPrtcDt */
        listColumnDefs.add(new ColumnDef("배치실행일자", Psnl0310BM.ATTR_CONFRTNPRTCDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 배치처리여부 : confrtnPrcsYn */
        listColumnDefs.add(new ColumnDef("배치처리여부", Psnl0310BM.ATTR_CONFRTNPRCSYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Psnl0310BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Psnl0310BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Psnl0310BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Psnl0310BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Psnl0310BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Psnl0310BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 전_직종통합코드 : befTypOccuInttnCd */
        listColumnDefs.add(new ColumnDef("전_직종통합코드", Psnl0310BM.ATTR_BEFTYPOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 후_직종통합코드 : aftTypOccuInttnCd */
        listColumnDefs.add(new ColumnDef("후_직종통합코드", Psnl0310BM.ATTR_AFTTYPOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분코드", Psnl0310BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 전직종세통합코드 : bfrDtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("전직종세통합코드", Psnl0310BM.ATTR_BFRDTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 전근속월수코드 : bfrLogSvcMnthCd */
        listColumnDefs.add(new ColumnDef("전근속월수코드", Psnl0310BM.ATTR_BFRLOGSVCMNTHCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 후직종세통합코드 : aftDtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("후직종세통합코드", Psnl0310BM.ATTR_AFTDTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 후근속월수코드 : aftLogSvcMnthCd */
        listColumnDefs.add(new ColumnDef("후근속월수코드", Psnl0310BM.ATTR_AFTLOGSVCMNTHCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        return listColumnDefs;
         
    }
    
}