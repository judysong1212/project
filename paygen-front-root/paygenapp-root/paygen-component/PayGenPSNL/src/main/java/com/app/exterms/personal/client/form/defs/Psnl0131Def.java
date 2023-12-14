package com.app.exterms.personal.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0110BM;
import com.app.exterms.personal.client.dto.Psnl0131BM;
import com.app.exterms.personal.client.languages.PsnlConstants;
import com.app.exterms.personal.shared.PsnlDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Psnl0131Def  extends TableDef implements PsnlDaoConstants {

    private int row = 0;
    private PsnlConstants psnlLabel = PsnlConstants.INSTANCE;
    
//    //권한 설정 객체 
//	private GWTAuthorization gwtAuthorization;
//	private GWTExtAuth gwtExtAuth;
//	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
//	  
//    private PrgmComBass0300DTO sysComBass0300Dto ;
//    private PrgmComBass0320DTO sysComBass0320Dto ;
//    private PrgmComBass0400DTO sysComBass0400Dto;
//    private PrgmComBass0500DTO sysComBass0500Dto;
//   // private boolean boolDeptCd = false ;
//    
//    public static final String COLUMN_DEF_DEPTCD = "deptCd"; 
//    public static final String COLUMN_DEF_BUSINCD = "businCd"; 
//    public static final String COLUMN_DEF_EMYMTBGNNDT = "emymtBgnnDt"; 
//
//    public static final String FIELD_ID_DEPTCD = COLUMN_DEF_DEPTCD + "$deptCd"; 
//    public static final String FIELD_ID_BUSINCD = COLUMN_DEF_DEPTCD + "$businCd"; 
//    public static final String FIELD_ID_EMYMTBGNNDT = COLUMN_DEF_EMYMTBGNNDT; 
//    
//    protected ColumnDefListenerAdapter changeValueListenerAdapter; 
//    
//    protected ColumnListDef deptCdColumnDef;
//    protected ColumnListDef businCdColumnDef;

    
    public Psnl0131Def(String flag){
    	
    	
    	if("PSNLP010001".equals(flag)) {
    		
//    		// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
//    		gwtAuthorization = GWTAuthorization.getInstance();
//    		gwtExtAuth = GWTExtAuth.getInstance();
//
//    		sysComBass0300Dto = new PrgmComBass0300DTO();
    		
            setTitle("");
            setDaoClass("");
//            setCustomListMethod(CLASS_PSNL0131_DATA_LIST);
//            setColumnsDefinition(getPsnl031ToPsnlP010001ColumnsList());
            setAutoFillGrid(false);
            setShowFilterToolbar(false);
            setCheckBoxOnGridRows(false);
            setEditFieldGrid(true);
            
    	}
	}

    private List<ColumnDef> getPsnl031ToPsnlP010001ColumnsList(){
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** column 순번 : rnum */
        listColumnDefs.add(new ColumnDef("순번", Psnl0110BM.ATTR_RNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Psnl0131BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0131BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 관련근거일련번호 : refeSeilNum */
        listColumnDefs.add(new ColumnDef("관련근거일련번호", Psnl0131BM.ATTR_REFESEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 관련근거등록일자 : refeIndt */
        listColumnDefs.add(new ColumnDef("관련근거등록일자", Psnl0131BM.ATTR_REFEINDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 관련근거담당자명 : refePrchNm */
        listColumnDefs.add(new ColumnDef("관련근거담당자명", Psnl0131BM.ATTR_REFEPRCHNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 관련근거담당전화번호 : refePrchTel */
        listColumnDefs.add(new ColumnDef("관련근거담당전화번호", Psnl0131BM.ATTR_REFEPRCHTEL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 관련근거구분코드 : refeDivCd */
        listColumnDefs.add(new ColumnDef("관련근거구분코드", Psnl0131BM.ATTR_REFEDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 관련근거제목 : refeTitl */
        listColumnDefs.add(new ColumnDef("관련근거제목", Psnl0131BM.ATTR_REFETITL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 관련근거내용 : refeCtnt */
        listColumnDefs.add(new ColumnDef("관련근거내용", Psnl0131BM.ATTR_REFECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : refeDelFg */
        listColumnDefs.add(new ColumnDef("null", Psnl0131BM.ATTR_REFEDELFG, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Psnl0131BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Psnl0131BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Psnl0131BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Psnl0131BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Psnl0131BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Psnl0131BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        
        return listColumnDefs;
    }
}