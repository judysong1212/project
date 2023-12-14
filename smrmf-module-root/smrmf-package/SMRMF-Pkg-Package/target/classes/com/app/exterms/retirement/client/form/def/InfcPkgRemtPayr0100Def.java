/**
 * 최근 3개월간 기본급여 및 제수당 
 */
package com.app.exterms.retirement.client.form.def;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.retirement.client.dto.InfcPkgRemt2300BM;
import com.app.exterms.retirement.client.dto.InfcPkgRemtPayr0100BM;
import com.app.exterms.retirement.shared.InfcPkgRemtDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class InfcPkgRemtPayr0100Def  extends TableDef implements InfcPkgRemtDaoConstants {

    private int row = 0;
//    private RemtConstants remtLabel = RemtConstants.INSTANCE;  
    
    public InfcPkgRemtPayr0100Def(String chkData){ 
    	 
   	 //최근3개월간 기본급여및제수당
     if ("REMT0100".equals(chkData)) {
	       //퇴직금계산 
   		    setTitle("");
	        setDaoClass(""); 
	        setCustomListMethod(CLASS_REMT0100_REMT2200_DATALIST);
	        setAutoFillGrid(true); 
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true); 
	        setEditFieldGrid(true);
	        setColumnsDefinition(getRemtPayr0100Pymt());
     
     }
   } 
    
    public List<ColumnDef> getRemtPayr0100Pymt(){
        
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();  
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", InfcPkgRemt2300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		 setReadOnly(true);
        	}
        });
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        listColumnDefs.add(new ColumnDef("퇴직정산구분코드", InfcPkgRemt2300BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		 setReadOnly(true);
        	}
        });
        /** column 정산년월 : clutYrMnth */
        listColumnDefs.add(new ColumnDef("정산년월", InfcPkgRemt2300BM.ATTR_CLUTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		 setReadOnly(true);
        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", InfcPkgRemt2300BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		 setReadOnly(true);
        	}
        });
         
		/** set 지급공제항목명 : payItemNm */
		listColumnDefs.add(new ColumnDef("항목", InfcPkgRemtPayr0100BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		 
	
		/** set item_tm01 : itemTm01 */
		listColumnDefs.add(new ColumnDef("시간", InfcPkgRemtPayr0100BM.ATTR_ITEMTM01, ColumnDef.TYPE_DOUBLE , 40, true, true, true){
			{
				setRegEx("^[+-]?\\d*(\\.?\\d*)$");  
            	setSelectOnFocus(true);
			}
		});
		/** set item_amnt01 : itemAmnt01 */
		listColumnDefs.add(new ColumnDef("금액", InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT01, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				//setReadOnly(true);
				setRegEx("^[+-]?\\d*(\\.?\\d*)$");  
            	setSelectOnFocus(true);
			}
		});
		
		 /** set item_tm02 : itemTm02 */
		listColumnDefs.add(new ColumnDef("시간", InfcPkgRemtPayr0100BM.ATTR_ITEMTM02, ColumnDef.TYPE_DOUBLE , 40, true, true, true){
			{
				setRegEx("^[+-]?\\d*(\\.?\\d*)$");  
            	setSelectOnFocus(true);
			}
		});
		 /** set item_amnt02 : itemAmnt02 */
		listColumnDefs.add(new ColumnDef("금액", InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT02, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				//setReadOnly(true);
				setRegEx("^[+-]?\\d*(\\.?\\d*)$");  
            	setSelectOnFocus(true);
			}
		});
		/** set item_tm03 : itemTm03 */
		listColumnDefs.add(new ColumnDef("시간", InfcPkgRemtPayr0100BM.ATTR_ITEMTM03, ColumnDef.TYPE_DOUBLE , 40, true, true, true){
			{
				setRegEx("^[+-]?\\d*(\\.?\\d*)$");  
            	setSelectOnFocus(true);
			}
		});
		 /** set item_amnt03 : itemAmnt03 */
		listColumnDefs.add(new ColumnDef("금액", InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT03, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				//setReadOnly(true);
				setRegEx("^[+-]?\\d*(\\.?\\d*)$");  
            	setSelectOnFocus(true);
			}
		});
		/** set item_tm04 : itemTm04 */
		listColumnDefs.add(new ColumnDef("시간", InfcPkgRemtPayr0100BM.ATTR_ITEMTM04, ColumnDef.TYPE_DOUBLE , 40, true, true, true){
			{
				setRegEx("^[+-]?\\d*(\\.?\\d*)$");  
            	setSelectOnFocus(true);
			}
		});
		/** set item_amnt04 : itemAmnt04 */
		listColumnDefs.add(new ColumnDef("금액", InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT04, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				//setReadOnly(true);
				setRegEx("^[+-]?\\d*(\\.?\\d*)$");  
            	setSelectOnFocus(true);
			}
		});
		/** set 퇴직금 급여합계 : item_tot-amnt itemTotAmnt */
		listColumnDefs.add(new ColumnDef("합계", InfcPkgRemtPayr0100BM.ATTR_ITEMTOTAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** set 지급공제항목코드 : payItemCd */
		listColumnDefs.add(new ColumnDef("지급공제항목코드", InfcPkgRemtPayr0100BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** set 수당그룹코드 : extpyGrpCd */
		listColumnDefs.add(new ColumnDef("그룹코드", InfcPkgRemtPayr0100BM.ATTR_EXTPYGRPCD, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** set 수당그룹명 : extpyGrpNm */
		listColumnDefs.add(new ColumnDef("그룹명", InfcPkgRemtPayr0100BM.ATTR_EXTPYGRPNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		          
        return listColumnDefs;
    }    
     
}
