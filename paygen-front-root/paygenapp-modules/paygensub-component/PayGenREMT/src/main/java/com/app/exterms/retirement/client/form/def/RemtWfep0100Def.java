/**
 * 연간 후생복지비
 */
package com.app.exterms.retirement.client.form.def;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.retirement.client.dto.Remt2000BM;
import com.app.exterms.retirement.client.dto.Remt2300BM;
import com.app.exterms.retirement.client.dto.RemtPayr0100BM;
import com.app.exterms.retirement.client.languages.RemtConstants;
import com.app.exterms.retirement.shared.RemtDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class RemtWfep0100Def  extends TableDef implements RemtDaoConstants {

    private int row = 0;
    private RemtConstants remtLabel = RemtConstants.INSTANCE;

    
    
    public RemtWfep0100Def(String chkData){ 
    	 
   	 
     if ("REMT0100".equals(chkData)) {
	       //퇴직금계산 
   		    setTitle("");
	        setDaoClass(""); 
	        setCustomListMethod(CLASS_REMTWFEP0100_REMT2200_DATALIST);
	        setAutoFillGrid(false); 
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(true);
	        setColumnsDefinition(getRemtWfep0100());
   	 }  
   } 
    
    
    public List<ColumnDef> getRemtWfep0100(){
      
         
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();  

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Remt2300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
              setReadOnly(true);
        	}
        });
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        listColumnDefs.add(new ColumnDef("퇴직정산구분코드", Remt2300BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		 setReadOnly(true);
        	}
        });
        /** column 정산년월 : clutYrMnth */
        listColumnDefs.add(new ColumnDef("정산년월", Remt2300BM.ATTR_CLUTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		 setReadOnly(true);
        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Remt2300BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		 setReadOnly(true);
        	}
        });
        
        /** set 지급공제항목코드 : payItemCd */
		listColumnDefs.add(new ColumnDef("지급공제항목코드", RemtPayr0100BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				 setReadOnly(true);
			}
		});
		/** set 지급공제항목명 : payItemNm */
		listColumnDefs.add(new ColumnDef("항목", RemtPayr0100BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING , 200, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		 
		/** set 수당그룹코드 : extpyGrpCd */
		listColumnDefs.add(new ColumnDef("그룹코드", RemtPayr0100BM.ATTR_EXTPYGRPCD, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				 setReadOnly(true);
			}
		});
		/** set 수당그룹명 : extpyGrpNm */
		listColumnDefs.add(new ColumnDef("그룹명", RemtPayr0100BM.ATTR_EXTPYGRPNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				 setReadOnly(true);
			}
		});
		/** column 총근무일수 : totLogSvcNumDys */
		listColumnDefs.add(new ColumnDef("개월", Remt2000BM.ATTR_TOTLOGSVCNUMDYS, ColumnDef.TYPE_STRING , 100, true, true, true){
			{
				 setReadOnly(true);
			}
		});
		/** column 퇴직금지급액 : sevePayPymtSum */
		listColumnDefs.add(new ColumnDef("지급금액", Remt2000BM.ATTR_SEVEPAYPYMTSUM, ColumnDef.TYPE_LONG , 200, true, true, true){
			{
				setRegEx("^[+-]?\\d*(\\.?\\d*)$");  
            	setSelectOnFocus(true);
			}
		});
		 
        return listColumnDefs;
    }
}
