/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0480BM;
import com.app.exterms.payroll.client.dto.Payr0485BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.form.Field;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0485Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;
    
    final PrgmComBass0300DTO sysComBass0300Dto;
    
    private ArrayList<String> alList = new ArrayList<String>();
    
    public Payr0485Def(){
        this("");
    }
    
    protected ColumnDefListenerAdapter changeValueListenerAdapter; 
    
    public Payr0485Def(String chkPayrDef){
    	
    	setTitle(PayrLabel.titlePayr0480());
        sysComBass0300Dto = new PrgmComBass0300DTO(); 
    	
        if ("".equals(chkPayrDef)) { 
        	 
            setDaoClass(CLASS_PAYR0480_DATA_LIST);
            setCustomListMethod(CLASS_PAYR0480_DATA_LIST);
            setAutoFillGrid(false);
            setShowFilterToolbar(false);
           // setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
            setCheckBoxOnGridRows(true); 
            setEditFieldGrid(true);
           // setEditableGrid(true);
            
            setColumnsDefinition(getPayr0480Def());
             
        } else if ("PAYR1450".equals(chkPayrDef)) {  
        	
        	 setDaoClass(CLASS_PAYR1450TOPAYR0485_DATA_LIST);
             setCustomListMethod(CLASS_PAYR1450TOPAYR0485_DATA_LIST);
             setAutoFillGrid(true);
             setShowFilterToolbar(false);
            // setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
             setCheckBoxOnGridRows(true); 
             setColumnsDefinition(getPayr1450ToPayr0485Def());
       }   
    }
    
    public List<ColumnDef> getPayr1450ToPayr0485Def(){
   	 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0485BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        sysComBass0300Dto.setRpsttvCd("A002");
        //sysComBass0300Dto.setMangeItem01("D");
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnListDef("고용구분코드", Payr0485BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true ,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

        	}
        });
        listColumnDefs.add(new ColumnDef("고용구분코드", Payr0485BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{

        	}
        });
                
        
        
        
        /** column 지급공제 : payDducGrpNm */
        listColumnDefs.add(new ColumnDef("지급공제", Payr0485BM.ATTR_PAYDDUCGRPNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 지급공제 : payDducGrpNm */
        listColumnDefs.add(new ColumnDef("지급공제", Payr0485BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        
        /** column 급여수당그룹명 : payExtpyGrpNm */
        listColumnDefs.add(new ColumnDef("그룹", Payr0485BM.ATTR_PAYEXTPYGRPNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        /** column 급여항목코드 : payItemCd */
        listColumnDefs.add(new ColumnDef("코드", Payr0485BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
       
        /** column 항목 : PayExtpyNm */
        listColumnDefs.add(new ColumnDef("항목", Payr0485BM.ATTR_PAYEXTPYNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        /** column 비과세감면 : YrtxFreeDtyReduNm */
        listColumnDefs.add(new ColumnDef("비과세감면", Payr0485BM.ATTR_YRTXFREEDTYREDUNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        /** column 비과세감면코드 : YrtxFreeDtyReduCd */
        listColumnDefs.add(new ColumnDef("비과세감면코드", Payr0485BM.ATTR_YRTXFREEDTYREDUCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 기부금유형 : YrtxDotnCd */
        listColumnDefs.add(new ColumnDef("기부금유형", Payr0485BM.ATTR_YRTXDOTNCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 기부금유형 : YrtxDotnNm */
        listColumnDefs.add(new ColumnDef("기부금유형", Payr0485BM.ATTR_YRTXDOTNNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        /** column DISPLAY여부 : ExtptDducDspyYn */
        listColumnDefs.add(new ColumnDef("화면출력", Payr0485BM.ATTR_EXTPTDDUCDSPYYN, ColumnDef.TYPE_BOOLEAN, 90, false, true, true){
        	{

        	}
        });
        /** column 급여공제사용여부 : ExtptDducUseYn */
        listColumnDefs.add(new ColumnDef("사용", Payr0485BM.ATTR_EXTPTDDUCUSEYN, ColumnDef.TYPE_BOOLEAN, 50, false, true, true){
        	{

        	}
        }); 
        /** column 급여공제사용여부 : PayrTermUseYn */
        listColumnDefs.add(new ColumnDef("기간제출력", Payr0485BM.ATTR_PAYRTERMUSEYN, ColumnDef.TYPE_BOOLEAN, 50, false, false, true){
        	{

        	}
        }); 
        /** column 퇴직정산포함 : SevePayYn */
        listColumnDefs.add(new ColumnDef("퇴직정산포함", Payr0485BM.ATTR_SEVEPAYYN, ColumnDef.TYPE_BOOLEAN, 50, false, false, true){
        	{

        	}
        });
        /** column 회계계정 : AccAccCd */
        listColumnDefs.add(new ColumnDef("회계계정코드", Payr0485BM.ATTR_ACCACCCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 회계계정 : AccAccNm */
        listColumnDefs.add(new ColumnDef("회계계정", Payr0485BM.ATTR_ACCACCNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        
        return listColumnDefs;
       
        
    }
    
    public List<ColumnDef> getPayr0480Def(){
    	
    	changeValueListenerAdapter = new ColumnDefListenerAdapter() {
           	
    		@SuppressWarnings("rawtypes")
    		public void run(Field field, Object valueField) {
    			// WRITE HERE YOUR CODE, Object triggered the listener (i.e. Field)  
    			 MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
    			 final ModelData formModel = formPanel.getFormBinding().getModel();
    		  
//    			 yrtxFreeDtyReduNm = MSFSharedUtils.allowNulls(Payr0480BM.ATTR_YRTXFREEDTYREDUNM);  	//비과세감면명
//    			 yrtxFreeDtyReduCd = MSFSharedUtils.allowNulls(Payr0480BM.ATTR_YRTXFREEDTYREDUCD);  	//비과세감면코드
    			 
//    			 System.out.println("비과세 감면 ===========>" + yrtxFreeDtyReduNm);
//    			 System.out.println("비과세 감면 ===========>"+ yrtxFreeDtyReduCd);
    			 
//    			 fnPopupBass0300("B023");	//공통코드 팝업 호출
    			
    			  MSFFormPanel popCom0130 = PrgmComPopupUtils.lovPopUpPrgmCom0130Form("B023");  //공통  
    			       
    				final FormBinding popBindingCom0130 = popCom0130.getFormBinding();
    			      
    				popBindingCom0130.addListener(Events.Change, new Listener<BaseEvent>() {
    					public void handleEvent(BaseEvent be) {
    						BaseModel mapModel = (BaseModel)be.getSource();
    						if (!"".equals(mapModel.get("commCd"))) { 
    							
    							
    							String yrtxFreeDtyReduNm = MSFSharedUtils.allowNulls(mapModel.get("commCdNm"));  	//비과세감면 명
    							String yrtxFreeDtyReduCd = MSFSharedUtils.allowNulls(mapModel.get("commCd"));	//비과세감면 코드
//    							
//    							System.out.println("비과세 감면 ===========>" + MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));
//    			    			 System.out.println("비과세 감면 ===========>"+ MSFSharedUtils.allowNulls(mapModel.get("commCd")));
//    			    			 
//    			    			 System.out.println("비과세 감면 ===========>" + yrtxFreeDtyReduNm);
//    			    			 System.out.println("비과세 감면 ===========>"+ yrtxFreeDtyReduCd);
    			    			 
    							formModel.set(Payr0480BM.ATTR_YRTXFREEDTYREDUNM, yrtxFreeDtyReduNm);
    							formModel.set(Payr0480BM.ATTR_YRTXFREEDTYREDUCD, yrtxFreeDtyReduCd);
    							
    							//데이터 넣은 후 refresh 필수로 해주어야 함.
    							getMsfGridPanel().getMsfGrid().getGrid().getView().refresh(true);
    						} 
    					}
    				});
    			}
    		};
    	 
    	
    	
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0480BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
      
        sysComBass0300Dto.setRpsttvCd("B008"); 
        sysComBass0300Dto.setMangeItem02("Y");
        /** column 지급공제구분 : pymtDducDivCd */
        listColumnDefs.add(new ColumnListDef("지급공제", Payr0480BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING , 145, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
            {

            }
        });
        sysComBass0300Dto.setMangeItem02("");
        /** column 지급공제구분 : pymtDducDivCd */
        listColumnDefs.add(new ColumnDef("지급공제", Payr0480BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {
//            	addTrigger(Events.CellClick, changeValueListenerAdapter);
            }
        });
        
        
        sysComBass0300Dto.setRpsttvCd("B025");
        sysComBass0300Dto.setMangeItem01("C");
        /** column 급여수당그룹코드 : payExtpyGrpCd */
        listColumnDefs.add(new ColumnListDef("수당그룹", Payr0480BM.ATTR_PAYEXTPYGRPCD, ColumnDef.TYPE_STRING, 150, false, true, true ,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{
        	   
        	}
        });
         
        
        /** column 급여수당그룹: payExtpyGrpNm */
        listColumnDefs.add(new ColumnDef("수당그룹", Payr0480BM.ATTR_PAYEXTPYGRPNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 급여수당코드 : payExtpyCd */
        listColumnDefs.add(new ColumnDef("수당코드", Payr0480BM.ATTR_PAYEXTPYCD, ColumnDef.TYPE_STRING, 100, false, true, true){
        	{

        	}
        });
     
        /** column 급여수당명 : payExtpyNm */
        listColumnDefs.add(new ColumnDef("수당명", Payr0480BM.ATTR_PAYEXTPYNM, ColumnDef.TYPE_STRING, 150, false, true, true){
        	{

        	}
        });
        
        sysComBass0300Dto.setRpsttvCd("B022"); 
        sysComBass0300Dto.setMangeItem01("");
        /** column 급여수당지급시기구분코드 : payExtpyPymtPrdDivCd */
        listColumnDefs.add(new ColumnListDef("수당지급시기", Payr0480BM.ATTR_PAYEXTPYPYMTPRDDIVCD, ColumnDef.TYPE_STRING, 160, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

        	}
        });
        /** column 지급시기구분 : payExtpyPymtPrdDivNm */
        listColumnDefs.add(new ColumnDef("지급시기구분", Payr0480BM.ATTR_PAYEXTPYPYMTPRDDIVNM, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{

        	}
        });
        /** column 기간제수당사용여부 : payrTermUseYn */
        listColumnDefs.add(new ColumnDef("기간제", Payr0480BM.ATTR_PAYRTERMUSEYN, ColumnDef.TYPE_BOOLEAN , 50, false, true, true){
        	{

        	}
        });
        
        /** column 통상임금여부 : usalyAmntYn */
        listColumnDefs.add(new ColumnDef("통상임금", Payr0480BM.ATTR_USALYAMNTYN, ColumnDef.TYPE_BOOLEAN , 60, false, true, true){
        	{

        	}
        });
        /** column 수당사용 : payExtpyUseYn */
        listColumnDefs.add(new ColumnDef("사용", Payr0480BM.ATTR_PAYEXTPYUSEYN, ColumnDef.TYPE_BOOLEAN, 50, false, true, true){
        	{

        	}
        });
        /** column 수정가능 : payRevnPsbyYn */
        listColumnDefs.add(new ColumnDef("수정가능", Payr0480BM.ATTR_PAYREVNPSBYYN, ColumnDef.TYPE_BOOLEAN, 60, false, false, true){
        	{

        	}
        });
        
        /** column 퇴직적용여부 : sevePayYn */
        listColumnDefs.add(new ColumnDef("퇴직", Payr0480BM.ATTR_SEVEPAYYN, ColumnDef.TYPE_BOOLEAN , 50, false, true, true){
            {

            }
        });
        
        /** column 회계계정코드 : accAccCd */
        listColumnDefs.add(new ColumnDef("계정코드", Payr0480BM.ATTR_ACCACCCD, ColumnDef.TYPE_STRING, 120, false, false, true){
        	{

        	}
        });
        /** column 회계계정 : accAccNm */
        listColumnDefs.add(new ColumnDef("계정", Payr0480BM.ATTR_ACCACCNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */
        listColumnDefs.add(new ColumnDef("비과세감면", Payr0480BM.ATTR_YRTXFREEDTYREDUCD, ColumnDef.TYPE_STRING, 110, true, false, true){
        	{

        	}
        });
        /** column 연말정산_비과세감면코드 : yrtxFreeDtyReduNm */
        listColumnDefs.add(new ColumnDef("비과세감면", Payr0480BM.ATTR_YRTXFREEDTYREDUNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{
        		addTrigger(Events.KeyUp, changeValueListenerAdapter);
        		
        	}
        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Payr0480BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Payr0480BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Payr0480BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Payr0480BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Payr0480BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Payr0480BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });

  
        return listColumnDefs;
    }
    
    
    public void setitemChange(Field itemField,Object itemCd) {
        
        changeValueListenerAdapter.run(itemField, itemCd);
        
    }
    
}
