/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0450BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.widget.form.Field;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0450Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    private PrgmComBass0300DTO sysComBass0300Dto ; 
    
    protected ColumnDefListenerAdapter changeValueListenerAdapter;
     
    protected ColumnListDef itemExtpyDivCdColumnDef;   //항목수당구분코드 : 
    
    public static final String FIELD_ID_CD = "payItemCd";
    
    public static final String COLUMN_DEF_ITEMEXTPYDIVCD = "itemExtpyDivCd";

    public static final String FIELD_ID_BASS0300 = COLUMN_DEF_ITEMEXTPYDIVCD + "$commCd";

    public Payr0450Def(String chkDef){ 
     	 
        sysComBass0300Dto = new PrgmComBass0300DTO();
        
    	if ("PAYR0450".equals(chkDef)) {
    		
    		 setTitle(PayrLabel.titlePayr0450());
    	     setDaoClass("");
    	     setCustomListMethod(CLASS_PAYR0450_DATA_LIST);
    	     setAutoFillGrid(false); 
    	     setShowFilterToolbar(false);
    	     setCheckBoxOnGridRows(true);
    	     setEditFieldGrid(true);
	        
	        changeValueListenerAdapter = new ColumnDefListenerAdapter() {
	            @SuppressWarnings("rawtypes")
	            public void run(Field field, Object valueField) {
	              
	                //To get by name the combo box fields
	                Field itemExtpyDivCdField = findFieldByAttributeName(FIELD_ID_BASS0300); 
	                String rpsttvCdValue = "";
	                
	                if ( FIELD_ID_CD.equals(field.getItemId()) ) {

	                    IColumnFilter filters = null;
	                    itemExtpyDivCdColumnDef.getTableDef().setTableColumnFilters(filters); 
	                    //Clear  
	                    GWTUtils.clearField(itemExtpyDivCdField);  
	                    
//	                    BaseModel item = (String)valueField;
//	                    String value = (String)item.get("commCd"); 
	                   
	                    if (PayGenConst.PAYR5600_PYMT_01.equals(valueField)) {
	                     // 장기근속수당 
	                        itemExtpyDivCdColumnDef.getTableDef().setTableColumnFilters(new SimpleColumnFilter("rpsttvCd", "B000", SimpleColumnFilter.OPERATOR_EQUALS));
	                        itemExtpyDivCdColumnDef.setReadOnly(true);
	                    } else  if (PayGenConst.PAYR5600_PYMT_02.equals(valueField)) {
	                     // 정근수당 
	                        itemExtpyDivCdColumnDef.getTableDef().setTableColumnFilters(new SimpleColumnFilter("rpsttvCd", "B000", SimpleColumnFilter.OPERATOR_EQUALS));
	                        itemExtpyDivCdColumnDef.setReadOnly(true);
	                    } else  if (PayGenConst.PAYR5600_PYMT_03.equals(valueField)) {
	                     // 가족수당 
	                        itemExtpyDivCdColumnDef.getTableDef().setTableColumnFilters(new SimpleColumnFilter("rpsttvCd", "B026", SimpleColumnFilter.OPERATOR_EQUALS));
	                        itemExtpyDivCdColumnDef.setReadOnly(false);
	                    } else  if (PayGenConst.PAYR5600_PYMT_04.equals(valueField)) {    
	                     // 학비보조수당  
	                        itemExtpyDivCdColumnDef.getTableDef().setTableColumnFilters(new SimpleColumnFilter("rpsttvCd", "B020", SimpleColumnFilter.OPERATOR_EQUALS));
	                        itemExtpyDivCdColumnDef.setReadOnly(false);
	                    } else {
	                        itemExtpyDivCdColumnDef.getTableDef().setTableColumnFilters(new SimpleColumnFilter("rpsttvCd", "B000", SimpleColumnFilter.OPERATOR_EQUALS));
                            itemExtpyDivCdColumnDef.setReadOnly(true); 
	                    }
	                   
	                    itemExtpyDivCdColumnDef.readData();

	                }   
	            }
	        }; 
	         
	        setColumnsDefinition(getPayr0450Def());
	        
    	} else if ("PAYR0480".equals(chkDef)) {
    		
    	    setTitle(PayrLabel.titlePayr0450());
  	        setDaoClass("");
  	        setCustomListMethod(CLASS_PAYR0450_PAYR5600_DATA_LIST);
  	        setAutoFillGrid(false); 
	        setShowFilterToolbar(false);
	         
	        setColumnsDefinition(getPayr0450ToPayr5500());
    	}  
    }
    
    public void setitemChange(Field itemField,Object itemCd) {
         
        changeValueListenerAdapter.run(itemField, itemCd);
        
    }
    
 public List<ColumnDef> getPayr0450ToPayr5500(){
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        /** column 급여년도 : payYr */
        listColumnDefs.add(new ColumnDef("급여년도", Payr0450BM.ATTR_PAYYR, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0450BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 급여수당코드 : payExtpyCd */
        listColumnDefs.add(new ColumnDef("급여수당코드", Payr0450BM.ATTR_PAYEXTPYCD, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
     
        /** column 급여수당명 : payExtpyNm */
        listColumnDefs.add(new ColumnDef("급여수당명", Payr0450BM.ATTR_PAYEXTPYNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        return listColumnDefs;
    }
 
    
    public List<ColumnDef> getPayr0450Def(){
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
          
        /** column 항목수당일련번호 : payPymtItemListSeilNum */
        listColumnDefs.add(new ColumnDef("항목수당일련번호", Payr0450BM.ATTR_PAYPYMTITEMLISTSEILNUM, ColumnDef.TYPE_LONG, 90, false, false, true){
        	{

        	}
        });
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0450BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 급여년도 : payYr */
        listColumnDefs.add(new ColumnDef("년도", Payr0450BM.ATTR_PAYYR, ColumnDef.TYPE_STRING, 50, false, true, true){
        	{
              setReadOnly(true);
        	}
        });
        
      
        /** column 급여항목코드 : payItemCd */
        listColumnDefs.add(new ColumnDef("수당코드", Payr0450BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{ 
        	  //  addTrigger(Events.Change, changeValueListenerAdapter);
        	}
        });
        
        /** column 급여항목 : payItemNm */
        listColumnDefs.add(new ColumnDef("수당명", Payr0450BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{
        	    setReadOnly(true); 
        	}
        });
        sysComBass0300Dto.setRpsttvCd("B000"); 
        /** column 항목수당구분코드 : itemExtpyDivCd */
        itemExtpyDivCdColumnDef = new ColumnListDef("수당구분", Payr0450BM.ATTR_ITEMEXTPYDIVCD, ColumnDef.TYPE_STRING, 100, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
            {

            }
        };
        listColumnDefs.add(itemExtpyDivCdColumnDef);
        
        /** column 항목수당구분 : itemExtpyDivNm */
        listColumnDefs.add(new ColumnDef("수당구분", Payr0450BM.ATTR_ITEMEXTPYDIVNM, ColumnDef.TYPE_STRING, 90, false,false, false){
        	{

        	}
        });
        
        /** column 시작년수 : styrNum */
        listColumnDefs.add(new ColumnDef("시작년수", Payr0450BM.ATTR_STYRNUM, ColumnDef.TYPE_LONG, 70, false, true, true){
        	{

        	}
        });
        /** column 종료년수 : edyrNum */
        listColumnDefs.add(new ColumnDef("종료년수", Payr0450BM.ATTR_EDYRNUM, ColumnDef.TYPE_LONG, 70, false, true, true){
        	{

        	}
        });
        /** column 지급공제율 : pymtDducRate */
        listColumnDefs.add(new ColumnDef("수당율", Payr0450BM.ATTR_PYMTDDUCRATE, ColumnDef.TYPE_DOUBLE, 60, false, true, true){
        	{

        	}
        });
        /** column 지급공제금액 : pymtDducSum */
        listColumnDefs.add(new ColumnDef("수당금액", Payr0450BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG, 90, false, true, true){
        	{

        	}
        });
      
        /** column 추가가산금액 : addPymtDducSum */
        listColumnDefs.add(new ColumnDef("추가가산금액", Payr0450BM.ATTR_ADDPYMTDDUCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Payr0450BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0450BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        /** column 항목별수당삭제여부 : itemListExtpyDelYn */
        listColumnDefs.add(new ColumnDef("삭제", Payr0450BM.ATTR_ITEMLISTEXTPYDELYN, ColumnDef.TYPE_BOOLEAN, 40, false, true, true){
        	{

        	}
        });
        /** column 항목별수당비고내용 : rmak */
        listColumnDefs.add(new ColumnDef("비고", Payr0450BM.ATTR_RMAK, ColumnDef.TYPE_STRING, 120, false, true, true){
        	{

        	}
        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Payr0450BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Payr0450BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Payr0450BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Payr0450BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Payr0450BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Payr0450BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });

//        private TextField<String> payPymtItemListSeilNum   /** column 항목수당일련번호 : payPymtItemListSeilNum */
//
//        private TextField<String> dpobCd   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> payYr   /** column 급여년도 : payYr */
//
//        private TextField<String> payItemCd   /** column 급여항목코드 : payItemCd */
//
//        private TextField<String> itemExtpyDivCd   /** column 항목수당구분코드 : itemExtpyDivCd */
//
//        private TextField<String> styrNum   /** column 시작년수 : styrNum */
//
//        private TextField<String> edyrNum   /** column 종료년수 : edyrNum */
//
//        private TextField<String> pymtDducRate   /** column 지급공제율 : pymtDducRate */
//
//        private TextField<String> pymtDducSum   /** column 지급공제금액 : pymtDducSum */
//
//        private TextField<String> itemListExtpyDelYn   /** column 항목별수당삭제여부 : itemListExtpyDelYn */
//
//        private TextField<String> rmak   /** column 항목별수당비고내용 : rmak */
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

        
         return listColumnDefs;
    }
     
   
}
