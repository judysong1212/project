package com.app.exterms.yearendtax.client.form.defs.yeta2016;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3170BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;

public class Ye16Ta3170Def extends TableDef implements YetaDaoConstants{
	
	private int row = 0;
	final PrgmComBass0300DTO sysComBass0300Dto;
	
	protected ColumnDefListenerAdapter changeValueListenerAdapter; 
	
	public static final String COLUMN_DEF_CTRBDDCD = "ctrbDdcd"; 
	public static final String COLUMN_DEF_CTRBTYCD = "ctrbTycd"; 

	public static final String FIELD_ID_CTRBDDCD = COLUMN_DEF_CTRBDDCD + "$ctrbDdcd";
	public static final String FIELD_ID_CTRBTYCD = COLUMN_DEF_CTRBTYCD + "$ctrbTycd"; 
	
    protected ColumnListDef ctrbDdcdColumnDef;
    protected ColumnListDef ctrbTycdColumnDef;
    
    
	public Ye16Ta3170Def(String chkDef) {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		
		if("YETAP13001".equals(chkDef)) {
//		setTitle("이월기부금 등록");
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETAP03001TOYETA3170_DATA_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setColumnsDefinition(getColumnsListYetaP13001ToYe16Ta3170()); 
		}
	}

	private List<ColumnDef> getColumnsListYetaP13001ToYe16Ta3170() {
		
   	 //We create a Listener Adapter to run custom code when one of the combo boxes changes value.
        //The listener adapter is attached to the combo boxes using the method ColumnDef.addTrigger().
//        changeValueListenerAdapter = new ColumnDefListenerAdapter() {
//        	
//            @SuppressWarnings("rawtypes")
//            public void run(Field field, Object valueField) {
//                // WRITE HERE YOUR CODE, Object triggered the listener (i.e. Field) 
//                //To get by name the combo box fields
//                Field ctrbTycdField = findFieldByAttributeName(FIELD_ID_CTRBTYCD); 
//                
//                if (FIELD_ID_CTRBDDCD.equals(field.getItemId())) {
//                    //Clear countries and locations
//                    GWTUtils.clearField(ctrbTycdField); 
//                    //Reload Countries
//                    BaseModel item = (BaseModel)valueField;
//                    //String typOccuCd = ((String)item.get("typOccuCd")).substring(0, ((String)item.get("typOccuCd")).indexOf("!"));
//                    String ctrbDdcd =  item.get("ctrbDdcd") ;
//                    ctrbTycdColumnDef.getTableDef().setTableColumnFilters(new SimpleColumnFilter("ctrbDdcd", ctrbDdcd, SimpleColumnFilter.OPERATOR_EQUALS));
//                    ctrbTycdColumnDef.readData();
//                 }
//            }
//        };
    	
    		
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("년도", Ye16Ta3170BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 60, true, false, true){
        	{

        	}
        });
        
        /** column 기부조정명세기부연도 : ctrbYrmn */
        listColumnDefs.add(new ColumnDef("년도", Ye16Ta3170BM.ATTR_CTRBYRMN, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        

        /** column 정산구분코드 : settGbnm */
        listColumnDefs.add(new ColumnListDef("정산구분코드", Ye16Ta3170BM.ATTR_SETTGBNM, ColumnDef.TYPE_STRING , 100,  true, false, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

        	}
        });
        sysComBass0300Dto.setRpsttvCd("B023");
        sysComBass0300Dto.setMangeItem01("Y");
        /** column 기부조정명세유형구분코드 : ctrbDdcd */
        listColumnDefs.add(new ColumnListDef("유형", Ye16Ta3170BM.ATTR_CTRBDDCD, ColumnDef.TYPE_STRING , 100,  true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

        	}
        });   
        sysComBass0300Dto.setMangeItem01("");
//      listColumnDefs.add(new ColumnDef("기부조정명세유형구분코드", Ye16Ta3170BM.ATTR_CTRBDDCD, ColumnDef.TYPE_STRING , 100, true, false, true){
//    	{
//
//    	}
//    });
//        listColumnDefs.add(new ColumnListDef("유형",   Ye16Ta3170BM.ATTR_CTRBDDCD,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
//        	{
//
//            }
//        });
        

//        ctrbDdcdColumnDef = new ColumnListDef("유형", Ye16Ta3170BM.ATTR_CTRBDDCD, ColumnDef.TYPE_STRING , 100, true, true, true, new LookupPrgmComBass0300(sysComBass0300Dto), PrgmComBass0300BM.ATTR_COMMCD, PrgmComBass0300BM.ATTR_COMMCDNM)
//    	{{  
////    		addTrigger(Events.Select, changeValueListenerAdapter);  
//    	}};
//    	listColumnDefs.add(ctrbDdcdColumnDef);
       
        
        /** column 기부조정명세유형코드 : ctrbTycd */
//   	 	listColumnDefs.add(new ColumnListDef("코드", Ye16Ta3170BM.ATTR_CTRBTYCD,   ColumnDef.TYPE_STRING, 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
//        	{
//        		
//            }
//        });
        listColumnDefs.add(new ColumnDef("코드", Ye16Ta3170BM.ATTR_CTRBTYCD, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{
        		//저장하고 나서 보여줌
        		setReadOnly(true);
        	}
        });

//    	ctrbTycdColumnDef = new ColumnListDef("코드", Ye16Ta3170BM.ATTR_CTRBTYCD, ColumnDef.TYPE_STRING , 90, true, true, true, new LookupPrgmComBass0300(sysComBass0300Dto), PrgmComBass0300BM.ATTR_DTLCD, PrgmComBass0300BM.ATTR_MANGEITEM01)
//    	{{ 
//
//    	}};
//    	listColumnDefs.add(ctrbTycdColumnDef);
        /** column 기부조정명세기부금액 : ctrbAmnt */
        listColumnDefs.add(new ColumnDef("기부금액", Ye16Ta3170BM.ATTR_CTRBAMNT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        /** column 전년도_공제금액 : bfyrDeam */
        listColumnDefs.add(new ColumnDef("전년도공제금액", Ye16Ta3170BM.ATTR_BFYRDEAM, ColumnDef.TYPE_LONG , 100, true, false, true){
        	{

        	}
        });
        
        /** column 공제대상금액 : detrAmnt */
        listColumnDefs.add(new ColumnDef("공제대상금액", Ye16Ta3170BM.ATTR_DETRAMNT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        /** column 해당연도공제금액 : dyyrDeam */
        listColumnDefs.add(new ColumnDef("해당연도공제금액", Ye16Ta3170BM.ATTR_DYYRDEAM, ColumnDef.TYPE_LONG , 150, true, true, true){
        	{

        	}
        });
        /** column 해당년도_미공제소멸금액 : dyyrOtam */
        listColumnDefs.add(new ColumnDef("소멸금액", Ye16Ta3170BM.ATTR_DYYROTAM, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        /** column 해당년도_미공제이월금액 : ayyrNtam */
        listColumnDefs.add(new ColumnDef("이월금액", Ye16Ta3170BM.ATTR_AYYRNTAM, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3170BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
   
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3170BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3170BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부조정명세일련번호 : ctrbSeqn */
        listColumnDefs.add(new ColumnDef("기부조정명세일련번호", Ye16Ta3170BM.ATTR_CTRBSEQN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
  
  
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye16Ta3170BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta3170BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta3170BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye16Ta3170BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta3170BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta3170BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
 
          
          return listColumnDefs;
	}

}
