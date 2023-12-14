/**
 * 공통화면 팝업 
 */
package com.app.smrmf.core.msfmainapp.client.def;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.dto.MSFLogHist0300BM;
import com.app.smrmf.core.msfmainapp.client.languages.MSFConstants;
import com.app.smrmf.core.msfmainapp.shared.MSFDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class LogHist0300Def  extends TableDef implements MSFDaoConstants {

    private int row = 0;
    private MSFConstants lblMsfConst = MSFConstants.INSTANCE;
    
    public LogHist0300Def(String chkDef){
        
        
        if ("".equals(chkDef)) {
	        setTitle("");
//	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
	        setCustomListMethod(CLASS_COREHIST0300_DATA_LIST);
	        
	        setAutoFillGrid(true);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
	        setColumnsDefinition(getHist0300ColumnsList());  
	      
    	} 
    }
    
	private List<ColumnDef> getHist0300ColumnsList(){
    	
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        row = 0;
        
        
        /** column 사용자접속구분코드 : usrConnectDivCd */
        listColumnDefs.add(new ColumnDef("구분", MSFLogHist0300BM.ATTR_USRCONNECTDIVCD, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        
        /** column 에러발생년도 : errOccrrncYr */
        listColumnDefs.add(new ColumnDef("년도", MSFLogHist0300BM.ATTR_ERROCCRRNCYR, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", MSFLogHist0300BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서", MSFLogHist0300BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
        
        /** column 사용자아이디 : usrId */
        listColumnDefs.add(new ColumnDef("아이디", MSFLogHist0300BM.ATTR_USRID, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 사용자성명 : usrNm */
        listColumnDefs.add(new ColumnDef("성명", MSFLogHist0300BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 에러발생일시 : errOccrrncDtntm */
        listColumnDefs.add(new ColumnDef("에러발생일시", MSFLogHist0300BM.ATTR_ERROCCRRNCDTNTM, ColumnDef.TYPE_STRING , 200, true, true, true){
        	{

        	}
        });
        
        
        /** column 에러명 : errNm */
        listColumnDefs.add(new ColumnDef("에러명", MSFLogHist0300BM.ATTR_ERRNM, ColumnDef.TYPE_STRING , 200, true, true, true){
        	{

        	}
        });
        
        
        /** column 에러메소드명 : errEthdNm */
        listColumnDefs.add(new ColumnDef("에러메소드명", MSFLogHist0300BM.ATTR_ERRETHDNM, ColumnDef.TYPE_STRING , 300, true, true, true){
        	{

        	}
        });

        /** column 에러내용 : errCtnt */
        listColumnDefs.add(new ColumnDef("에러내용", MSFLogHist0300BM.ATTR_ERRCTNT, ColumnDef.TYPE_STRING , 500, true, true, true){
        	{

        	}
        });
        
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", MSFLogHist0300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });


        /** column 에러일련번호 : errSeilNum */
        listColumnDefs.add(new ColumnDef("에러일련번호", MSFLogHist0300BM.ATTR_ERRSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });


        /** column 사용자구분코드 : usrDivCd */
        listColumnDefs.add(new ColumnDef("사용자구분코드", MSFLogHist0300BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });


        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", MSFLogHist0300BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", MSFLogHist0300BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", MSFLogHist0300BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", MSFLogHist0300BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", MSFLogHist0300BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", MSFLogHist0300BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
       
		return listColumnDefs;
    }
}