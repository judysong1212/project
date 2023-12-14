/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0200BM;
import com.app.exterms.payroll.client.dto.Payr0470BM;
import com.app.exterms.payroll.client.dto.Payr0520BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComPayr0470DTO;
import com.app.exterms.prgm.client.dto.PrgmComPayr0480DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.prgm.client.lookup.LookupPrgmComPayr0470;
import com.app.exterms.prgm.client.lookup.LookupPrgmComPayr0480;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.google.gwt.i18n.client.DateTimeFormat;
/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0520Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;
    
    final PrgmComBass0300DTO sysComBass0300Dto;
    final PrgmComPayr0470DTO sysComPayr0470Dto;
    final PrgmComPayr0480DTO sysComPayr0480Dto;
    
    protected ColumnDefListenerAdapter changeValueListenerAdapter;
    protected ColumnListDef payDducCdColumnDef;
    protected ColumnDef payDducCd;
    
    
    public Payr0520Def(String chkDef){ 

        sysComBass0300Dto = new PrgmComBass0300DTO();  
        sysComPayr0470Dto = new PrgmComPayr0470DTO();
        sysComPayr0480Dto = new PrgmComPayr0480DTO();
         
        setTitle(PayrLabel.titlePayr0520());
        
        if ("PAYR03200_DDUCDIVCD".equals(chkDef)) {
             
              setDaoClass(CLASS_PAYR0520_PAYR03200_DDUCDIVCD_LIST);
              setCustomListMethod(CLASS_PAYR0520_PAYR03200_DDUCDIVCD_LIST);
              setAutoFillGrid(false); 
              setShowFilterToolbar(false);  
              
              addColumnFilter("pymtDducDivCd", PayGenConst.PYMT_DDUC_DIV_CD_03, SimpleColumnFilter.OPERATOR_EQUALS);   
             
            setColumnsDefinition(getPayr0520ToPayr3200DducdDef());
            
        }   else if ("PAYR03200".equals(chkDef)) { 
            setDaoClass(CLASS_PAYR0520_PAYR03200_DATA_LIST);
            setCustomListMethod(CLASS_PAYR0520_PAYR03200_DATA_LIST);
            setAutoFillGrid(false);
            setEditFieldGrid(true);
            setShowFilterToolbar(false);
            setCheckBoxOnGridRows(true);
            
//            changeValueListenerAdapter = new ColumnDefListenerAdapter() {
//                @SuppressWarnings("rawtypes")
//                public void run(Field field, Object valueField) {
//                	
//                	MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
//                	final ModelData formModel = formPanel.getFormBinding().getModel();
//
//                	Long pymtDducSum = (Long)formModel.get(Payr0520BM.ATTR_PYMTDDUCSUM);
//                	Double pymtDducRate = (Double)formModel.get(Payr0520BM.ATTR_PYMTDDUCRATE);
//                	
////                	Window.alert("22"+pymtDducSum);
//                	
//                    if (Payr0520BM.ATTR_PYMTDDUCSUM.equals(field.getItemId())) pymtDducRate = 0d;
//                    if (Payr0520BM.ATTR_PYMTDDUCRATE.equals(field.getItemId())) pymtDducSum = 0l;
//                    
//                    formModel.set(Payr0520BM.ATTR_PYMTDDUCSUM, pymtDducSum);
//                    formModel.set(Payr0520BM.ATTR_PYMTDDUCRATE, pymtDducRate);
//                }
//            };
           
            setColumnsDefinition(getPayr0520ToPayr3200Def()); 
         
        } else if ("PAYR05400_DDUCDIVCD".equals(chkDef)) {
            
            setDaoClass(CLASS_PAYR0520_PAYR05400_EXTPYCD_LIST);
            setCustomListMethod(CLASS_PAYR0520_PAYR05400_EXTPYCD_LIST);
            setAutoFillGrid(false); 
            setShowFilterToolbar(false);  

            addColumnFilter("pymtDducDivCd", PayGenConst.PYMT_DDUC_DIV_CD_02, SimpleColumnFilter.OPERATOR_EQUALS);
           
          setColumnsDefinition(getPayr0520ToPayr5400DducdDef());
          
      } else if ("PAYR05400".equals(chkDef)) { 
          setDaoClass(CLASS_PAYR0520_PAYR05400_DATA_LIST);
          setCustomListMethod(CLASS_PAYR0520_PAYR05400_DATA_LIST);
          setAutoFillGrid(false);
          setEditFieldGrid(true);
          setShowFilterToolbar(false);
          setCheckBoxOnGridRows(true);
          
          changeValueListenerAdapter = new ColumnDefListenerAdapter() {
              @SuppressWarnings("rawtypes")
              public void run(Field field, Object valueField) {
              	
              	MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
              	final ModelData formModel = formPanel.getFormBinding().getModel();
              	
              	Long pymtDducSum = (Long)formModel.get(Payr0520BM.ATTR_PYMTDDUCSUM);
              	Double pymtDducRate = (Double)formModel.get(Payr0520BM.ATTR_PYMTDDUCRATE);
              	
                  if (Payr0520BM.ATTR_PYMTDDUCSUM.equals(field.getItemId())) pymtDducRate = 0d;
                  if (Payr0520BM.ATTR_PYMTDDUCRATE.equals(field.getItemId())) pymtDducSum = 0l;
                  
                  formModel.set(Payr0520BM.ATTR_PYMTDDUCSUM, pymtDducSum);
                  formModel.set(Payr0520BM.ATTR_PYMTDDUCRATE, pymtDducRate);
              }
          };
         
          setColumnsDefinition(getPayr0520ToPayr5400Def()); 
       
      } else { 
              setDaoClass(CLASS_PAYR0520_DATA_LIST);
              setCustomListMethod(CLASS_PAYR0520_DATA_LIST);
              setAutoFillGrid(false);
              setEditFieldGrid(true);
              setShowFilterToolbar(false); 
              setCheckBoxOnGridRows(true);
              //  setEditableGrid(true);  
             
            setColumnsDefinition(getPayr0520Def());
        }
    }
    
public void setitemChange(Field itemField,Object itemCd) {
    
    changeValueListenerAdapter.run(itemField, itemCd);
    
}
    

public List<ColumnDef> getPayr0520Def(){
  
   
    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
      
    /** column 사업장코드 : dpobCd */
    listColumnDefs.add(new ColumnDef("사업장코드", Payr0520BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        {

        }
    });
    /** column SYSTEMKEY : systemkey */
    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0520BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
        {

        }
    });
    
   
    /** column  PAY_YR :  PAY_YR */
  listColumnDefs.add(new ColumnDef("년도", Payr0520BM.ATTR_PAYYR, ColumnDef.TYPE_STRING, 40, false, true, true){
  {

  }
  });    
//    /** column 개별지급공제항목일련번호 : pymtDducItemSilNum */
//    listColumnDefs.add(new ColumnDef("번호", Payr0520BM.ATTR_PYMTDDUCITEMSILNUM, ColumnDef.TYPE_LONG, 40, false, true, true){
//        {
//
//        }
//    });
    /** column 급여항목코드 : payItemCd */
    listColumnDefs.add(new ColumnDef("항목코드", Payr0520BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 60, false, true, true){
        {

        }
    });
    /** column 급여항목 : payItemNm */
    listColumnDefs.add(new ColumnDef("항목", Payr0520BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 80, false, true, true){
        {

        }
    }); 
    sysComBass0300Dto.setRpsttvCd("B008");
    /** column 지급공제구분코드 : pymtDducDivCd */
    listColumnDefs.add(new ColumnListDef("구분", Payr0520BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING, 60, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        {

        }
    });

    /** column 지급공제구분 : pymtDducDivNm */
    listColumnDefs.add(new ColumnDef("구분", Payr0520BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 60, false, false, true){
        {

        }
    });
    /** column 지금공제금액 : pymtDducSum */
    listColumnDefs.add(new ColumnDef("금액", Payr0520BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG, 80, false, true, true){
        {

        }
    });
    /** column 지금공제율 : pymtDducRate */
    listColumnDefs.add(new ColumnDef("율", Payr0520BM.ATTR_PYMTDDUCRATE, ColumnDef.TYPE_DOUBLE, 50, false, true, true){
        {

        }
    });
    /** column 지금공제비과세금액 : pymtDducFreeDtySum */
    listColumnDefs.add(new ColumnDef("비과세", Payr0520BM.ATTR_PYMTDDUCFREEDTYSUM, ColumnDef.TYPE_LONG, 70, false, true, true){
        {

        }
    });
//    /** column 지급공제항목생성구분코드 : pymtDducItemCretnDivCd */
//    listColumnDefs.add(new ColumnDef("지급공제항목생성구분코드", Payr0520BM.ATTR_PYMTDDUCITEMCRETNDIVCD, ColumnDef.TYPE_STRING, 90, false, false, false){
//        {
//
//        }
//    });
//    /** column 지급공제항목생성 : pymtDducItemCretnDivNm */
//    listColumnDefs.add(new ColumnDef("지급공제항목생성구분", Payr0520BM.ATTR_PYMTDDUCITEMCRETNDIVNM, ColumnDef.TYPE_STRING, 90, false, false, false){
//        {
//
//        }
 //   });

    /** column 지급공제항목시작일자 : pymtDducItemBgnnDt */
    listColumnDefs.add(new ColumnDef("시작일자", Payr0520BM.ATTR_PYMTDDUCITEMBGNNDT, ColumnDef.TYPE_DATE, 70, false, true, true){
        {

        }
    });
    /** column 지급공제항목종료일자 : pymtDducItemEndDt */
    listColumnDefs.add(new ColumnDef("종료일자", Payr0520BM.ATTR_PYMTDDUCITEMENDDT, ColumnDef.TYPE_DATE, 70, false, true, true){
        {

        }
    });
    /** column 지급공제항목삭제여부 : pymtDducItemDelYn */
    listColumnDefs.add(new ColumnDef("삭제", Payr0520BM.ATTR_PYMTDDUCITEMDELYN, ColumnDef.TYPE_BOOLEAN, 40, false, true, true){
        {

        }
    });
    
    /** column 지급공제항목비고내용 : pymtDducItemNoteCtnt */
    listColumnDefs.add(new ColumnDef("비고", Payr0520BM.ATTR_PYMTDDUCITEMNOTECTNT, ColumnDef.TYPE_STRING, 120, false, true, true){
        {

        }
    });
    
    /** column  UCST_NOTE_CTNT :  UCST_NOTE_CTNT */
  listColumnDefs.add(new ColumnDef("비고2", Payr0520BM.ATTR_UCSTNOTECTNT, ColumnDef.TYPE_STRING, 120, false, true, true){
  {

  }
  }); 
//    /** column 입력자 : kybdr */
//    listColumnDefs.add(new ColumnDef("입력자", Payr0520BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//      {
//
//      }
//    });
//    /** column 입력일자 : inptDt */
//    listColumnDefs.add(new ColumnDef("입력일자", Payr0520BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//      {
//
//      }
//    });
//    /** column 입력주소 : inptAddr */
//    listColumnDefs.add(new ColumnDef("입력주소", Payr0520BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//      {
//
//      }
//    });
//    /** column 수정자 : ismt */
//    listColumnDefs.add(new ColumnDef("수정자", Payr0520BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//      {
//
//      }
//    });
//    /** column 수정일자 : revnDt */
//    listColumnDefs.add(new ColumnDef("수정일자", Payr0520BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//      {
//
//      }
//    });
//    /** column 수정주소 : revnAddr */
//    listColumnDefs.add(new ColumnDef("수정주소", Payr0520BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//      {
//
//      }
//    });

//    private TextField<String> systemkey   /** column SYSTEMKEY : systemkey */
//
//    private TextField<String> payItemCd   /** column 급여항목코드 : payItemCd */
//
//    private TextField<String> pymtDducItemSilNum   /** column 개별지급공제항목일련번호 : pymtDducItemSilNum */
//
//    private TextField<String> pymtDducDivCd   /** column 지급공제구분코드 : pymtDducDivCd */
//
//    private TextField<String> pymtDducSum   /** column 지금공제금액 : pymtDducSum */
//
//    private TextField<String> pymtDducRate   /** column 지금공제율 : pymtDducRate */
//
//    private TextField<String> pymtDducFreeDtySum   /** column 지금공제비과세금액 : pymtDducFreeDtySum */
//
//    private TextField<String> pymtDducItemCretnDivCd   /** column 지급공제항목생성구분코드 : pymtDducItemCretnDivCd */
//
//    private TextField<String> pymtDducItemNoteCtnt   /** column 지급공제항목비고내용 : pymtDducItemNoteCtnt */
//
//    private TextField<String> pymtDducItemBgnnDt   /** column 지급공제항목시작일자 : pymtDducItemBgnnDt */
//
//    private TextField<String> pymtDducItemEndDt   /** column 지급공제항목종료일자 : pymtDducItemEndDt */
//
//    private TextField<String> pymtDducItemDelYn   /** column 지급공제항목삭제여부 : pymtDducItemDelYn */
//
//    private TextField<String> kybdr   /** column 입력자 : kybdr */
//
//    private TextField<String> inptDt   /** column 입력일자 : inptDt */
//
//    private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
//
//    private TextField<String> ismt   /** column 수정자 : ismt */
//
//    private TextField<String> revnDt   /** column 수정일자 : revnDt */
//
//    private TextField<String> revnAddr   /** column 수정주소 : revnAddr */

    return listColumnDefs; 
}


    public List<ColumnDef> getPayr0520ToPayr3200Def(){
       
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0520BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0520BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Payr0200BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            {

            }
        });
        
        /** column 부서 : deptNm */
        listColumnDefs.add(new ColumnDef("부서명", Payr0200BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 120, false, true, true){
            {
              setReadOnly(true);
            }
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Payr0200BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, false, true, true){
            {

            }
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0200BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, false, true, true){
            {
              
            }
        });
        /** column 주민등록번호 : secRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0200BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
            {
              
            }
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Payr0200BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            {

            }
        });
        
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Payr0200BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            {

            }
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Payr0200BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            {

            }
        });
        
        
        
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0200BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		{
		
		}
		});  
		        
        /** column 호봉등급 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0200BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, false, false, true){
            {

            }
        });
        
        /** column 급여항목코드 : payItemCd */
        /*listColumnDefs.add(new ColumnDef("공제항목코드", Payr0520BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });*/
        
        /** column 지급공제구분 : pymtDducDivNm */
        listColumnDefs.add(new ColumnDef("공제구분", Payr0520BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 60, false, true, true){
        	{
        		
        	}
        });
        
        /** column 급여항목 : payItemNm          */
        /*listColumnDefs.add(new ColumnDef("공제항목", Payr0520BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{
        	    setReadOnly(true);
        	}
        });
        
        listColumnDefs.add(new ColumnListDef("공제항목", Payr0520BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 120, true, true, true,  new LookupPrgmComPayr0470(sysComPayr0470Dto),Payr0470BM.ATTR_PAYDDUCCD,Payr0470BM.ATTR_PAYDDUCNM){
        	{
        		addTrigger(Events.Select, changeValueListenerAdapter);  
        	}
        });
         */
        
        payDducCdColumnDef = new ColumnListDef("공제항목", Payr0520BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 120, true, true, true,  new LookupPrgmComPayr0470(sysComPayr0470Dto),Payr0470BM.ATTR_PAYDDUCCD,Payr0470BM.ATTR_PAYDDUCNM){
            { 
//                addTrigger(Events.Change, changeValueListenerAdapter);  
            }
	     };
	     listColumnDefs.add(payDducCdColumnDef);
        
        
        listColumnDefs.add(new ColumnDef("공제항목", Payr0520BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 90, true, false, true){
	    	{
	    	 
	    	}
    	});
        
        /** column 개별지급공제항목일련번호 : pymtDducItemSilNum */
        listColumnDefs.add(new ColumnDef("개별지급공제항목일련번호", Payr0520BM.ATTR_PYMTDDUCITEMSILNUM, ColumnDef.TYPE_LONG, 90, false, false, true){
        	{

        	}
        });
        /** column 지급공제구분코드 : pymtDducDivCd */
        listColumnDefs.add(new ColumnDef("지급공제구분코드", Payr0520BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });

        /** column 지금공제금액 : pymtDducSum */
        listColumnDefs.add(new ColumnDef("공제금액", Payr0520BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG, 70, true, true, true){
        	{
//        		addTrigger(Events.OnKeyUp, changeValueListenerAdapter);  
        		
        	}
        });
        
        /** column 지금공제율 : pymtDducRate */
        listColumnDefs.add(new ColumnDef("율", Payr0520BM.ATTR_PYMTDDUCRATE, ColumnDef.TYPE_DOUBLE, 70, true, true, true){
        	{
//        		addTrigger(Events.OnKeyUp, changeValueListenerAdapter);  
        	}
        });
        
        /** column 지금공제비과세금액 : pymtDducFreeDtySum */
        listColumnDefs.add(new ColumnDef("비과세금액", Payr0520BM.ATTR_PYMTDDUCFREEDTYSUM, ColumnDef.TYPE_LONG, 70, true, true, true){
        	{

        	}
        });
        /** column 지급공제항목생성구분코드 : pymtDducItemCretnDivCd */
        listColumnDefs.add(new ColumnDef("지급공제항목생성구분코드", Payr0520BM.ATTR_PYMTDDUCITEMCRETNDIVCD, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{

        	}
        });
        /** column 지급공제항목생성 : pymtDducItemCretnDivNm */
        listColumnDefs.add(new ColumnDef("지급공제항목생성구분", Payr0520BM.ATTR_PYMTDDUCITEMCRETNDIVNM, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{

        	}
        });
    
        /** column 지급공제항목시작일자 : pymtDducItemBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Payr0520BM.ATTR_PYMTDDUCITEMBGNNDT, ColumnDef.TYPE_DATE, 80, true, true, true){
        	{
        		setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");
        	}
        });
        /** column 지급공제항목종료일자 : pymtDducItemEndDt */
        listColumnDefs.add(new ColumnDef("종료일자", Payr0520BM.ATTR_PYMTDDUCITEMENDDT, ColumnDef.TYPE_DATE, 80, true, true, true){
        	{
        		setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");
        	}
        });
        /** column 지급공제항목삭제여부 : pymtDducItemDelYn */
        listColumnDefs.add(new ColumnDef("삭제", Payr0520BM.ATTR_PYMTDDUCITEMDELYN, ColumnDef.TYPE_BOOLEAN, 50, true, true, true){
        	{

        	}
        });
        
        /** column 지급공제항목비고내용 : pymtDducItemNoteCtnt */
        listColumnDefs.add(new ColumnDef("비고", Payr0520BM.ATTR_PYMTDDUCITEMNOTECTNT, ColumnDef.TYPE_STRING, 150, true, true, true){
            {

            }
        });
 

        return listColumnDefs; 
    }
    
    public List<ColumnDef> getPayr0520ToPayr3200DducdDef(){
        
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0520BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
            {

            }
        }); 
        /** column 급여항목코드 : payItemCd */
        listColumnDefs.add(new ColumnDef("공제코드", Payr0520BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 80, true, true, true){
            {

            }
        });
        /** column 급여항목 : payItemNm */
        listColumnDefs.add(new ColumnDef("공제명", Payr0520BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 120, true, true, true){
            {

            }
        });
        
        /** column 지급공제항목삭제여부 : pymtDducItemDelYn */
        listColumnDefs.add(new ColumnDef("삭제", Payr0520BM.ATTR_PYMTDDUCITEMDELYN, ColumnDef.TYPE_BOOLEAN, 50, true, true, true){
            {

            }
        }); 
        return listColumnDefs;
    }
    
    public List<ColumnDef> getPayr0520ToPayr5400Def(){
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0520BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0520BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Payr0200BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            {

            }
        });
        /** column 부서 : deptNm */
        listColumnDefs.add(new ColumnDef("부서명", Payr0200BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 120, false, true, true){
            {
              setReadOnly(true);
            }
        });
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Payr0200BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, false, true, true){
            {

            }
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0200BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, false, true, true){
            {
              
            }
        });
        /** column 주민등록번호 : secRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0200BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
            {
              
            }
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Payr0200BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            {

            }
        });
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Payr0200BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            {

            }
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Payr0200BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            {

            }
        });
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0200BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
			
			}
		});  
        /** column 호봉등급 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0200BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, false, false, true){
            {

            }
        });
        /** column 지급공제구분 : pymtDducDivNm */
        listColumnDefs.add(new ColumnDef("수당구분", Payr0520BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 60, false, true, true){
        	{
        		
        	}
        });
        
        /** column 급여항목 : payItemNm          */
        payDducCdColumnDef = new ColumnListDef("수당항목", Payr0520BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 120, true, true, true,  new LookupPrgmComPayr0480(sysComPayr0480Dto),Payr0470BM.ATTR_PYMTEXTPYCD,Payr0470BM.ATTR_PYMTEXTPYNM){
            { 
                addTrigger(Events.Change, changeValueListenerAdapter);  
            }
	     };
	     listColumnDefs.add(payDducCdColumnDef);
        
        
        listColumnDefs.add(new ColumnDef("수당항목", Payr0520BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 90, true, false, true){
	    	{
	    	 
	    	}
    	});
        
        /** column 개별지급공제항목일련번호 : pymtDducItemSilNum */
        listColumnDefs.add(new ColumnDef("개별지급수당항목일련번호", Payr0520BM.ATTR_PYMTDDUCITEMSILNUM, ColumnDef.TYPE_LONG, 90, false, false, true){
        	{

        	}
        });
        /** column 지급공제구분코드 : pymtDducDivCd */
        listColumnDefs.add(new ColumnDef("지급수당구분코드", Payr0520BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });

        /** column 지금공제금액 : pymtDducSum */
        listColumnDefs.add(new ColumnDef("수당금액", Payr0520BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG, 70, true, true, true){
        	{
        		addTrigger(Events.OnKeyUp, changeValueListenerAdapter);  
        	}
        });
        
        /** column 지금공제율 : pymtDducRate */
        listColumnDefs.add(new ColumnDef("율", Payr0520BM.ATTR_PYMTDDUCRATE, ColumnDef.TYPE_DOUBLE, 70, true, true, true){
        	{
        		addTrigger(Events.OnKeyUp, changeValueListenerAdapter);  
        	}
        });
        
        /** column 지금공제비과세금액 : pymtDducFreeDtySum */
        listColumnDefs.add(new ColumnDef("비과세금액", Payr0520BM.ATTR_PYMTDDUCFREEDTYSUM, ColumnDef.TYPE_LONG, 70, true, true, true){
        	{

        	}
        });
        /** column 지급공제항목생성구분코드 : pymtDducItemCretnDivCd */
        listColumnDefs.add(new ColumnDef("지급수당항목생성구분코드", Payr0520BM.ATTR_PYMTDDUCITEMCRETNDIVCD, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{

        	}
        });
        /** column 지급공제항목생성 : pymtDducItemCretnDivNm */
        listColumnDefs.add(new ColumnDef("지급수당항목생성구분", Payr0520BM.ATTR_PYMTDDUCITEMCRETNDIVNM, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{

        	}
        });
    
        /** column 지급공제항목시작일자 : pymtDducItemBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Payr0520BM.ATTR_PYMTDDUCITEMBGNNDT, ColumnDef.TYPE_DATE, 80, true, true, true){
        	{
        		setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");
        	}
        });
        /** column 지급공제항목종료일자 : pymtDducItemEndDt */
        listColumnDefs.add(new ColumnDef("종료일자", Payr0520BM.ATTR_PYMTDDUCITEMENDDT, ColumnDef.TYPE_DATE, 80, true, true, true){
        	{
        		setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");
        	}
        });
        /** column 지급공제항목삭제여부 : pymtDducItemDelYn */
        listColumnDefs.add(new ColumnDef("삭제", Payr0520BM.ATTR_PYMTDDUCITEMDELYN, ColumnDef.TYPE_BOOLEAN, 50, true, true, true){
        	{

        	}
        });
        
        /** column 지급공제항목비고내용 : pymtDducItemNoteCtnt */
        listColumnDefs.add(new ColumnDef("비고", Payr0520BM.ATTR_PYMTDDUCITEMNOTECTNT, ColumnDef.TYPE_STRING, 150, true, true, true){
            {

            }
        });
 

        return listColumnDefs; 
    }
    
public List<ColumnDef> getPayr0520ToPayr5400DducdDef(){
        
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0520BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
            {

            }
        }); 
        /** column 급여항목코드 : payItemCd */
        listColumnDefs.add(new ColumnDef("수당코드", Payr0520BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 80, true, true, true){
            {

            }
        });
        /** column 급여항목 : payItemNm */
        listColumnDefs.add(new ColumnDef("수당명", Payr0520BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 120, true, true, true){
            {

            }
        });
        
        /** column 지급공제항목삭제여부 : pymtDducItemDelYn */
        listColumnDefs.add(new ColumnDef("삭제", Payr0520BM.ATTR_PYMTDDUCITEMDELYN, ColumnDef.TYPE_BOOLEAN, 50, true, true, true){
            {

            }
        }); 
        return listColumnDefs;
    }
}
