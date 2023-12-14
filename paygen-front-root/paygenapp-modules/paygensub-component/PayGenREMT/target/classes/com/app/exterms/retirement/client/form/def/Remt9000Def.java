/**
 * 공통화면 팝업 
 */
package com.app.exterms.retirement.client.form.def;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.form.PrgmComP0100;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.retirement.client.dto.InfcPkgRemt9000BM;
import com.app.exterms.retirement.client.dto.Remt9000BM;
import com.app.exterms.retirement.client.languages.RemtConstants;
import com.app.exterms.retirement.shared.RemtDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Remt9000Def  extends TableDef implements RemtDaoConstants {

    private int row = 0;
    private RemtConstants RemtLabel = RemtConstants.INSTANCE;

    final PrgmComP0100 sysComP0100 =  new PrgmComP0100(800,600); 
    
    private PrgmComBass0300DTO sysComBass0300Dto ;
   
    
    public Remt9000Def(){
        
        sysComBass0300Dto = new PrgmComBass0300DTO();
        
        setTitle("");
        setDaoClass(CLASS_REMT9000_SAVE);
        setCustomListMethod(CLASS_REMT9000_DATA_LIST);
        setAutoFillGrid(false);
        setShowFilterToolbar(false);
         
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Remt9000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Remt9000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
                
            }
        });
        
        /** column 퇴직금정산관리번호 : sevePayClutMangeNum */
        listColumnDefs.add(new ColumnDef("관리번호", Remt9000BM.ATTR_SEVEPAYCLUTMANGENUM, ColumnDef.TYPE_STRING , 90, false, true, true){
            {
                setReadOnly(true);
            }
        });

        /** column 퇴직정산귀속년도 : calcSevePayPsnBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", Remt9000BM.ATTR_CALCSEVEPAYPSNBLGGYR, ColumnDef.TYPE_STRING , 90, false, true, true){
            {
                
            }
        });
        
        /** HAN_NM */
        listColumnDefs.add(new ColumnDef("성명", Remt9000BM.ATTR_HANNM,  ColumnDef.TYPE_STRING, 80, false, true, true){
            { 
              
                setLov(sysComP0100);
                setTypeTextField(ColumnDef.TEXTFIELD);
                
               // if (MSFSharedUtils.paramNull(Remt9000BM.ATTR_HANNM)) { 
                    getLov().getLovDef().addColumnFilter("hanNm", "TT", SimpleColumnFilter.OPERATOR_EQUALS);  
                    getLov().getLovDef().addColumnFilter("hdofcCodtnCd", PayGenConst.HDOFC_CODTN_CD_01, SimpleColumnFilter.OPERATOR_EQUALS);  
              //  } else {
              //      sysComP0100.hanNm.setValue(Remt9000BM.ATTR_HANNM);
              //      getLov().getLovDef().addColumnFilter("hanNm", Remt9000BM.ATTR_HANNM, SimpleColumnFilter.OPERATOR_EQUALS);  
              //  }
                 
                    PrgmComP0100.getHanNm().addKeyListener(new KeyListener() {
                    	 @Override
                        public void componentKeyDown(ComponentEvent event) {
                          
                            PrgmComP0100.getHanNm().validate();
                            if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                                IColumnFilter filters = null;
                                getLov().getLovDef().setTableColumnFilters(filters);
                                 
                                getLov().getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                                getLov().getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getTypOccuCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                                getLov().getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                                getLov().getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                                getLov().getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                                getLov().getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(PrgmComP0100.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                                getLov().getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(PrgmComP0100.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                                getLov().getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(PrgmComP0100.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                                getLov().getLovWindow().readData();
                            }
                            super.componentKeyDown(event);
                        }
                     });
                    
                    PrgmComP0100.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
                      public void handleEvent(ButtonEvent e) {
                    	  PrgmComP0100.getHanNm().validate();
                          IColumnFilter filters = null;
                          getLov().getLovDef().setTableColumnFilters(filters);
                          getLov().getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                          getLov().getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getTypOccuCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                          getLov().getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                          getLov().getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                          getLov().getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                          getLov().getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(PrgmComP0100.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                          getLov().getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(PrgmComP0100.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                          getLov().getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(PrgmComP0100.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                          getLov().getLovWindow().readData();
                          
                      }
                     });
                     
            }
        });
        /** RESN_REGN_NUM */
        listColumnDefs.add(new ColumnDef("주민등록번호", Remt9000BM.ATTR_RESNREGNNUM,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
               
            }
        });
        
        /** CURR_AFFN_DEPT_CD */
        listColumnDefs.add(new ColumnDef("부서", Remt9000BM.ATTR_CURRAFFNDEPTCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                
            }
        });
        /** CURR_AFFN_DEPT_NM */
        listColumnDefs.add(new ColumnDef("부서명", Remt9000BM.ATTR_CURRAFFNDEPTNM,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                
            }
        });
        
        /** EMYMT_DIV_CD */
        listColumnDefs.add(new ColumnDef("고용구분", Remt9000BM.ATTR_EMYMTDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                
            }
        });
        /** EMYMT_DIV_NM */
        listColumnDefs.add(new ColumnDef("고용구분", Remt9000BM.ATTR_EMYMTDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                
            }
        });
        
        /** TYP_OCCU_CD */
        listColumnDefs.add(new ColumnDef("직종", Remt9000BM.ATTR_TYPOCCUCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                
            }
        });
        /** TYP_OCCU_NM */
        listColumnDefs.add(new ColumnDef("직종명", Remt9000BM.ATTR_TYPOCCUNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                
            }
        });
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Remt9000BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });                                           
                                                   
                              
        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Remt9000BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });    
     
        sysComBass0300Dto.setRpsttvCd("B027"); 
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        listColumnDefs.add(new ColumnListDef("정산구분", Remt9000BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
            {

            }
        });
        /** column 입사일자 : icncDt */
        listColumnDefs.add(new ColumnDef("입사일자", Remt9000BM.ATTR_ICNCDT, ColumnDef.TYPE_DATE , 90, false, true, true){
            {
                setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
            }
        });
        /** column 기산일자 : rkfcdDt */
        listColumnDefs.add(new ColumnDef("기산일자", Remt9000BM.ATTR_RKFCDDT, ColumnDef.TYPE_DATE , 90, false, true, true){
            {
                setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
            }
        });
        /** column 퇴사일자 : rsgtnDt */
        listColumnDefs.add(new ColumnDef("퇴사일자", Remt9000BM.ATTR_RSGTNDT, ColumnDef.TYPE_DATE , 90, false, true, true){
            {
                setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
            }
        });
        /** column 지급일자 : pymtDt */
        listColumnDefs.add(new ColumnDef("지급일자", Remt9000BM.ATTR_PYMTDT, ColumnDef.TYPE_DATE , 90, false, true, true){
            {
                setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
            }
        });
        /** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
        listColumnDefs.add(new ColumnDef("제외2012이전", Remt9000BM.ATTR_EEPNMNTHICM2012BFR, ColumnDef.TYPE_LONG , 90, false, true, true){
            {

            }
        });
        /** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
        listColumnDefs.add(new ColumnDef("제외2013이후", Remt9000BM.ATTR_EEPNMNTHICM2013AFT, ColumnDef.TYPE_LONG , 90, false, true, true){
            {

            }
        });
        /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
        listColumnDefs.add(new ColumnDef("가산2012이전", Remt9000BM.ATTR_ADDMNTHICM2012BFR, ColumnDef.TYPE_LONG , 90, false, true, true){
            {

            }
        });
        /** column 가산월수_2013이후 : addMnthIcm2013Aft */
        listColumnDefs.add(new ColumnDef("가산2013이후", Remt9000BM.ATTR_ADDMNTHICM2013AFT, ColumnDef.TYPE_LONG , 90, false, true, true){
            {

            }
        });
        /** column 퇴직급여액 : retryPayQnty */
        listColumnDefs.add(new ColumnDef("퇴직금액", Remt9000BM.ATTR_RETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, false, true, true){
            {

            }
        });
        /** column 비과세퇴직급여액 : freeDtyRetryPayQnty */
        listColumnDefs.add(new ColumnDef("비과세", Remt9000BM.ATTR_FREEDTYRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, false, true, true){
            {

            }
        });
        /** column 기납부세액 : alpayTxAmnt */
        listColumnDefs.add(new ColumnDef("소득세", Remt9000BM.ATTR_ALPAYTXAMNT, ColumnDef.TYPE_LONG , 90, false, true, true){
            {

            }
        });
        
        /** column 지방소득세 : locIncmTxAmt */
        listColumnDefs.add(new ColumnDef("지방소득세", Remt9000BM.ATTR_LOCINCMTXAMT, ColumnDef.TYPE_LONG , 90, false,	true, true){
        	{

        	}
        });
        /** column 차인지급액 : pernPymtSum */
        listColumnDefs.add(new ColumnDef("지급액", Remt9000BM.ATTR_PERNPYMTSUM, ColumnDef.TYPE_LONG , 90, false, true, true){
        	{

        	}
        });
        
        
        /** column 군경력정산포함여부 : amcrrClutInsnYn */
        listColumnDefs.add(new ColumnDef("군경력", InfcPkgRemt9000BM.ATTR_AMCRRCLUTINSNYN, ColumnDef.TYPE_BOOLEAN , 60, false, true, true){
        	{

        	}
        });
      
        /** column 퇴직금중간정산비고내용 : sevePayCtrClutNoteCtnt */
        listColumnDefs.add(new ColumnDef("비고내용", Remt9000BM.ATTR_SEVEPAYCTRCLUTNOTECTNT, ColumnDef.TYPE_STRING , 150, false, true, true){
            {
                setTypeTextField(ColumnDef.TEXTAREA); 
            }
        });
        
 
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Remt9000BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Remt9000BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Remt9000BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Remt9000BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Remt9000BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Remt9000BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//
        
//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> sevePayClutMangeNum;   /** column 퇴직금정산관리번호 : sevePayClutMangeNum */
//
//        private TextField<String> calcSevePayPsnBlggYr;   /** column 퇴직정산귀속년도 : calcSevePayPsnBlggYr */
//
//        private TextField<String> calcSevePayPsnDivCd;   /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//
//        private TextField<String> icncDt;   /** column 입사일자 : icncDt */
//
//        private TextField<String> rkfcdDt;   /** column 기산일자 : rkfcdDt */
//
//        private TextField<String> rsgtnDt;   /** column 퇴사일자 : rsgtnDt */
//
//        private TextField<String> pymtDt;   /** column 지급일자 : pymtDt */
//
//        private TextField<String> eepnMnthIcm2012Bfr;   /** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
//
//        private TextField<String> eepnMnthIcm2013Aft;   /** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
//
//        private TextField<String> addMnthIcm2012Bfr;   /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
//
//        private TextField<String> addMnthIcm2013Aft;   /** column 가산월수_2013이후 : addMnthIcm2013Aft */
//
//        private TextField<String> retryPayQnty;   /** column 퇴직급여액 : retryPayQnty */
//
//        private TextField<String> freeDtyRetryPayQnty;   /** column 비과세퇴직급여액 : freeDtyRetryPayQnty */
//
//        private TextField<String> alpayTxAmnt;   /** column 기납부소득세 : alpayTxAmnt */
//
//        private TextField<String> locIncmTxAmt;   /** column 지방소득세 : locIncmTxAmt */
//
//        private TextField<String> pernPymtSum;   /** column 차인지급액 : pernPymtSum */
//
//        private TextField<String> sevePayCtrClutNoteCtnt;   /** column 퇴직금중간정산비고내용 : sevePayCtrClutNoteCtnt */
//
//        private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//        private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//        private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//        private TextField<String> ismt;   /** column 수정자 : ismt */
//
//        private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//        private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
        
    
        setColumnsDefinition(listColumnDefs);
    }
}
