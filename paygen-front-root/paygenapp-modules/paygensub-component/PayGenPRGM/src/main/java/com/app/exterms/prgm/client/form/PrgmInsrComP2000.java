/**
 * 취득신고 대상자 검색 
 * 인사 멀티 검색 팝업
 */
package com.app.exterms.prgm.client.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0100BM;
import com.app.exterms.prgm.client.form.defs.PrgmComPsnl0100Def;
import com.app.exterms.prgm.client.languages.PrgmConstants;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0320;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnLovDef;
import com.app.smrmf.core.msfmainapp.client.def.LovDef;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class PrgmInsrComP2000  extends Lov implements PrgmComDaoConstants { 
 
    /**######################################################
     * { 시스템 기본설정파일 선언부  시작}
     *#######################################################*/
	 //권한 설정 객체 
	  private  static GWTAuthorization gwtAuthorization;
	  private  static GWTExtAuth gwtExtAuth;

     /**######################################################
     * { 시스템 기본설정파일 선언부  종료}
     *#######################################################*/

  private PrgmConstants SysComLabel = PrgmConstants.INSTANCE; 
   

  //직종콤보
  private static LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
  private static MSFGridPanel typOccuCdGridPanel;
  
  private  static ListStore<BaseModel>  lsEmymtDivCd = new ListStore<BaseModel>();//고용구분 
  
  //--------------------부서 불러 오는 함수 ------------------------------------------------
 private  static ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();// 부서콤보
  //--------------------부서 불러 오는 함수 ------------------------------------------------
    
 //--------------------사업 불러 오는 함수 -------------------------------------------------
 private  static ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();// 사업콤보   
//--------------------사업 불러 오는 함수 -------------------------------------------------
 private  static ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>();//직종
 private static ListStore<BaseModel>  lsHdofcCodtnCd = new ListStore<BaseModel>(); //재직상태 
 
 private  static PrgmComBass0300DTO sysComBass0300Dto; //공통코드  
 private  static PrgmComBass0400DTO sysComBass0400Dto; //부서코드
 private  static PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
   
  /** column  년도 : payYr */
 private static DateField emymtBgnnDt01;
 private static DateField emymtBgnnDt02;
 
 private static ComboBox<BaseModel> typOccuCd; //직종  
 private static ComboBox<BaseModel> emymtDivCd; //고용구분  
  
 private static ComboBox<BaseModel> deptCd ;    //부서 
 private static ComboBox<BaseModel> businCd;    //사업
 private static TextField<String> hanNm;         //성명
 private static TextField<String> resnRegnNum;   //주민번호 
 private static HiddenField<String> systemkey;   //시스템키
 private static ComboBox<BaseModel> hdofcCodtnCd; //재직상태  
  public static Button btnUsrSearch;
  
  
  
   public static DateField getEmymtBgnnDt01() {
	return emymtBgnnDt01;
}

public static void setEmymtBgnnDt01(DateField emymtBgnnDt01) {
	PrgmInsrComP2000.emymtBgnnDt01 = emymtBgnnDt01;
}

public static DateField getEmymtBgnnDt02() {
	return emymtBgnnDt02;
}

public static void setEmymtBgnnDt02(DateField emymtBgnnDt02) {
	PrgmInsrComP2000.emymtBgnnDt02 = emymtBgnnDt02;
}

public static ComboBox<BaseModel> getTypOccuCd() {
	return typOccuCd;
}

public static void setTypOccuCd(ComboBox<BaseModel> typOccuCd) {
	PrgmInsrComP2000.typOccuCd = typOccuCd;
}

public static ComboBox<BaseModel> getEmymtDivCd() {
	return emymtDivCd;
}

public static void setEmymtDivCd(ComboBox<BaseModel> emymtDivCd) {
	PrgmInsrComP2000.emymtDivCd = emymtDivCd;
}

public static ComboBox<BaseModel> getDeptCd() {
	return deptCd;
}

public static void setDeptCd(ComboBox<BaseModel> deptCd) {
	PrgmInsrComP2000.deptCd = deptCd;
}

public static ComboBox<BaseModel> getBusinCd() {
	return businCd;
}

public static void setBusinCd(ComboBox<BaseModel> businCd) {
	PrgmInsrComP2000.businCd = businCd;
}

public static TextField<String> getHanNm() {
	return hanNm;
}

public static void setHanNm(TextField<String> hanNm) {
	PrgmInsrComP2000.hanNm = hanNm;
}

public static TextField<String> getResnRegnNum() {
	return resnRegnNum;
}

public static void setResnRegnNum(TextField<String> resnRegnNum) {
	PrgmInsrComP2000.resnRegnNum = resnRegnNum;
}

public static HiddenField<String> getSystemkey() {
	return systemkey;
}

public static void setSystemkey(HiddenField<String> systemkey) {
	PrgmInsrComP2000.systemkey = systemkey;
}

public static ComboBox<BaseModel> getHdofcCodtnCd() {
	return hdofcCodtnCd;
}

public static void setHdofcCodtnCd(ComboBox<BaseModel> hdofcCodtnCd) {
	PrgmInsrComP2000.hdofcCodtnCd = hdofcCodtnCd;
}

public PrgmInsrComP2000(int width, int height) {
        this();
        this.width  = width;
        this.height = height;
    }

    public PrgmInsrComP2000() { 
        // 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
	     gwtAuthorization =   GWTAuthorization.getInstance();
	     gwtExtAuth =   GWTExtAuth.getInstance();
	    
        lovDef = new LovDef();
        lovDef.setTitle(SysComLabel.titleSysComPopUpInsr2000());  //팝업상단의 타이틀 
        lovDef.setDaoClass("");
        lovDef.setAutoFillGrid(false);   
        lovDef.showFilterForm(); 
        lovDef.setCustomListMethod(PRGMCOM_METHOD_POPUP_INSR_PSNL0100_List);
        lovDef.setCheckBoxOnGridRows(true);
        
        List<ColumnLovDef> listColumnDefs = new ArrayList<ColumnLovDef>();
       
        
        listColumnDefs.add(new ColumnLovDef("사업장코드", PrgmComPsnl0100BM.ATTR_DPOBCD, PrgmComPsnl0100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 100){
            {
                 setIsVisibleInGrid(false);
            }
        });  
        /** SYSTEMKEY */
        listColumnDefs.add(new ColumnLovDef("시스템키", PrgmComPsnl0100BM.ATTR_SYSTEMKEY,PrgmComPsnl0100BM.ATTR_SYSTEMKEY,  ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
       
        /** EMYMT_DIV_CD */
        listColumnDefs.add(new ColumnLovDef("고용구분코드", PrgmComPsnl0100BM.ATTR_EMYMTDIVCD, PrgmComPsnl0100BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
                 setIsVisibleInSearchForm(true);
            }
        });
        /** EMYMT_DIV_NM */
        listColumnDefs.add(new ColumnLovDef("고용구분명", PrgmComPsnl0100BM.ATTR_EMYMTDIVNM, PrgmComPsnl0100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 100){
            {
                 setIsVisibleInSearchForm(true);
            }
        });
        
        /** HAN_NM */
        listColumnDefs.add(new ColumnLovDef("성명", PrgmComPsnl0100BM.ATTR_HANNM,  PrgmComPsnl0100BM.ATTR_HANNM,  ColumnDef.TYPE_STRING, 80){
            {
                 
            }
        });
        
        /** RESN_REGN_NUM */
        listColumnDefs.add(new ColumnLovDef("주민등록번호", PrgmComPsnl0100BM.ATTR_RESNREGNNUM,  PrgmComPsnl0100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90){
            {
                
            }
        });
         
        /** DEPT_CD */
        listColumnDefs.add(new ColumnLovDef("관리부서코드", PrgmComPsnl0100BM.ATTR_DEPTCD, PrgmComPsnl0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** DEPT_NM */
        listColumnDefs.add(new ColumnLovDef("관리부서명", PrgmComPsnl0100BM.ATTR_DEPTNM, PrgmComPsnl0100BM.ATTR_DEPTNM,  ColumnDef.TYPE_STRING, 100 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        
        /** CURR_AFFN_DEPT_CD */
        listColumnDefs.add(new ColumnLovDef("부서코드", PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTCD, PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTCD,  ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** CURR_AFFN_DEPT_NM */
        listColumnDefs.add(new ColumnLovDef("부서명", PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTNM, PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTNM, ColumnDef.TYPE_STRING, 80 ){
            {
                
            }
        }); 
        

        /** BUSIN_CD */
        listColumnDefs.add(new ColumnLovDef("사업코드", PrgmComPsnl0100BM.ATTR_BUSINCD, PrgmComPsnl0100BM.ATTR_BUSINCD,  ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** BUSIN_NM */
        listColumnDefs.add(new ColumnLovDef("사업명", PrgmComPsnl0100BM.ATTR_BUSINNM,  PrgmComPsnl0100BM.ATTR_BUSINNM,ColumnDef.TYPE_STRING, 80 ){
            {
               
            }
        }); 
        /** TYP_OCCU_CD */
        listColumnDefs.add(new ColumnLovDef("직종코드", PrgmComPsnl0100BM.ATTR_TYPOCCUCD,PrgmComPsnl0100BM.ATTR_TYPOCCUCD,  ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** TYP_OCCU_NM */
        listColumnDefs.add(new ColumnLovDef("직종명", PrgmComPsnl0100BM.ATTR_TYPOCCUNM, PrgmComPsnl0100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 80 ){
            {
                
            }
        });
        
        /** SX_DIV_CD */
        listColumnDefs.add(new ColumnLovDef("성별코드", PrgmComPsnl0100BM.ATTR_SXDIVCD, PrgmComPsnl0100BM.ATTR_SXDIVCD,  ColumnDef.TYPE_STRING, 80){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** SX_DIV_NM */
        listColumnDefs.add(new ColumnLovDef("성별", PrgmComPsnl0100BM.ATTR_SXDIVNM, PrgmComPsnl0100BM.ATTR_SXDIVNM, ColumnDef.TYPE_STRING, 80){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** YOOBH_MNTH_DAY */
        listColumnDefs.add(new ColumnLovDef("생년월일", PrgmComPsnl0100BM.ATTR_YOOBHMNTHDAY,PrgmComPsnl0100BM.ATTR_YOOBHMNTHDAY,  ColumnDef.TYPE_STRING, 80){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** SCLC_DIV_CD */
        listColumnDefs.add(new ColumnLovDef("음양구분코드", PrgmComPsnl0100BM.ATTR_SCLCDIVCD,  PrgmComPsnl0100BM.ATTR_SCLCDIVCD, ColumnDef.TYPE_STRING, 80){
            {
                 setIsVisibleInGrid(false);
            }
        });
        
        /** NATN_CD */
        listColumnDefs.add(new ColumnLovDef("국가코드", PrgmComPsnl0100BM.ATTR_NATNCD, PrgmComPsnl0100BM.ATTR_NATNCD,  ColumnDef.TYPE_STRING, 80){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** NATN_Nm */
        listColumnDefs.add(new ColumnLovDef("국가명", PrgmComPsnl0100BM.ATTR_NATNNM,PrgmComPsnl0100BM.ATTR_NATNNM,  ColumnDef.TYPE_STRING, 80){
            {
                 setIsVisibleInGrid(false);
            }
        });
      
      
        /** REPBTY_BUSIN_DIV_CD */
        listColumnDefs.add(new ColumnLovDef("담당업무구분코드", PrgmComPsnl0100BM.ATTR_REPBTYBUSINDIVCD,PrgmComPsnl0100BM.ATTR_REPBTYBUSINDIVCD,   ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** REPBTY_BUSIN_DIV_NM */
        listColumnDefs.add(new ColumnLovDef("담당업무명", PrgmComPsnl0100BM.ATTR_REPBTYBUSINDIVNM, PrgmComPsnl0100BM.ATTR_REPBTYBUSINDIVNM,  ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        }); 
        /** ODTY_CD */
        listColumnDefs.add(new ColumnLovDef("직책코드", PrgmComPsnl0100BM.ATTR_ODTYCD,PrgmComPsnl0100BM.ATTR_ODTYCD,  ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** ODTY_NM */
        listColumnDefs.add(new ColumnLovDef("직책명", PrgmComPsnl0100BM.ATTR_ODTYNM, PrgmComPsnl0100BM.ATTR_ODTYNM,  ColumnDef.TYPE_STRING, 80 ){
            {
                
            }
        });
        /** FRST_EMYMT_DT */
        listColumnDefs.add(new ColumnLovDef("최초고용일자", PrgmComPsnl0100BM.ATTR_FRSTEMYMTDT,PrgmComPsnl0100BM.ATTR_FRSTEMYMTDT,  ColumnDef.TYPE_STRING, 80 ){
            {
                 
            }
        }); 
        /** EMYMT_BGNN_DT */
        listColumnDefs.add(new ColumnLovDef("고용시작일자", PrgmComPsnl0100BM.ATTR_EMYMTBGNNDT, PrgmComPsnl0100BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_STRING, 80 ){
            {
                 
            }
        });
        /** EMYMT_END_DT */
        listColumnDefs.add(new ColumnLovDef("고용종료일자", PrgmComPsnl0100BM.ATTR_EMYMTENDDT, PrgmComPsnl0100BM.ATTR_EMYMTENDDT,  ColumnDef.TYPE_STRING, 80 ){
            {
                 
            }
        });
        /** PYSP_CD */
        listColumnDefs.add(new ColumnLovDef("호봉코드", PrgmComPsnl0100BM.ATTR_PYSPCD, PrgmComPsnl0100BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** PYSP_NM */
        listColumnDefs.add(new ColumnLovDef("호봉", PrgmComPsnl0100BM.ATTR_PYSPNM,PrgmComPsnl0100BM.ATTR_PYSPNM,  ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** LOG_SVC_YR_NUM_CD */
        listColumnDefs.add(new ColumnLovDef("근속년수코드", PrgmComPsnl0100BM.ATTR_LOGSVCYRNUMCD, PrgmComPsnl0100BM.ATTR_LOGSVCYRNUMCD,  ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** LOG_SVC_YR_NUM_NM */
        listColumnDefs.add(new ColumnLovDef("근속년수", PrgmComPsnl0100BM.ATTR_LOGSVCYRNUMNM,PrgmComPsnl0100BM.ATTR_LOGSVCYRNUMNM,  ColumnDef.TYPE_STRING, 80 ){
            {
                 
            }
        });
        /** LOG_SVC_MNTH_ICM_CD */
        listColumnDefs.add(new ColumnLovDef("근속월수코드", PrgmComPsnl0100BM.ATTR_LOGSVCMNTHICMCD,PrgmComPsnl0100BM.ATTR_LOGSVCMNTHICMCD,  ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** LOG_SVC_MNTH_ICM_NM */
        listColumnDefs.add(new ColumnLovDef("근속월수", PrgmComPsnl0100BM.ATTR_LOGSVCMNTHICMNM,PrgmComPsnl0100BM.ATTR_LOGSVCMNTHICMNM,  ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        
        /** HDOFC_CODTN_CD */
        listColumnDefs.add(new ColumnLovDef("재직상태코드", PrgmComPsnl0100BM.ATTR_HDOFCCODTNCD, PrgmComPsnl0100BM.ATTR_HDOFCCODTNCD,  ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** HDOFC_CODTN_NM */
        listColumnDefs.add(new ColumnLovDef("재직상태", PrgmComPsnl0100BM.ATTR_HDOFCCODTNNM, PrgmComPsnl0100BM.ATTR_HDOFCCODTNNM, ColumnDef.TYPE_STRING, 80 ){
            {
                
            }
        });
        /** RETRY_DT */
        listColumnDefs.add(new ColumnLovDef("퇴직일자", PrgmComPsnl0100BM.ATTR_RETRYDT, PrgmComPsnl0100BM.ATTR_RETRYDT, ColumnDef.TYPE_STRING, 80 ){
            {
                 
            }
        });
        /** RETRY_REAS_CTNT */
        listColumnDefs.add(new ColumnLovDef("퇴직사유", PrgmComPsnl0100BM.ATTR_RETRYREASCTNT,PrgmComPsnl0100BM.ATTR_RETRYREASCTNT,   ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** FRGNR_DIV_CD */
        listColumnDefs.add(new ColumnLovDef("외국인구분코드", PrgmComPsnl0100BM.ATTR_FRGNRDIVCD,PrgmComPsnl0100BM.ATTR_FRGNRDIVCD,  ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** FRGNR_DIV_NM */
        listColumnDefs.add(new ColumnLovDef("외국인", PrgmComPsnl0100BM.ATTR_FRGNRDIVNM, PrgmComPsnl0100BM.ATTR_FRGNRDIVNM, ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** PSPT_NUM */
        listColumnDefs.add(new ColumnLovDef("여권번호", PrgmComPsnl0100BM.ATTR_PSPTNUM,PrgmComPsnl0100BM.ATTR_PSPTNUM,  ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** STY_BGNN_DT */
        listColumnDefs.add(new ColumnLovDef("체류시작일자", PrgmComPsnl0100BM.ATTR_STYBGNNDT, PrgmComPsnl0100BM.ATTR_STYBGNNDT, ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
                
            }
        });
        /** STY_END_DT */
        listColumnDefs.add(new ColumnLovDef("체류종료일자", PrgmComPsnl0100BM.ATTR_STYENDDT, PrgmComPsnl0100BM.ATTR_STYENDDT, ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** END_SCHL */
        listColumnDefs.add(new ColumnLovDef("최종학교", PrgmComPsnl0100BM.ATTR_ENDSCHL,PrgmComPsnl0100BM.ATTR_ENDSCHL,  ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** END_DEGR_DIV_CD */
        listColumnDefs.add(new ColumnLovDef("최종학위구분코드", PrgmComPsnl0100BM.ATTR_ENDDEGRDIVCD, PrgmComPsnl0100BM.ATTR_ENDDEGRDIVCD, ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** END_DEGR_DIV_CD */
        listColumnDefs.add(new ColumnLovDef("최종학위명", PrgmComPsnl0100BM.ATTR_ENDDEGRDIVNM,PrgmComPsnl0100BM.ATTR_ENDDEGRDIVNM,   ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** PMTN_SCDU_DT */
        listColumnDefs.add(new ColumnLovDef("승진예정일자", PrgmComPsnl0100BM.ATTR_PMTNSCDUDT, PrgmComPsnl0100BM.ATTR_PMTNSCDUDT, ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** PYSP_PRMTN_SCDU_DT */
        listColumnDefs.add(new ColumnLovDef("호봉승급예정일자", PrgmComPsnl0100BM.ATTR_PYSPPRMTNSCDUDT,PrgmComPsnl0100BM.ATTR_PYSPPRMTNSCDUDT,  ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** REYMN_SCDU_DT */
        listColumnDefs.add(new ColumnLovDef("재고용예정일자", PrgmComPsnl0100BM.ATTR_REYMNSCDUDT, PrgmComPsnl0100BM.ATTR_REYMNSCDUDT, ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
     
        /** CURR_PYSP_APPMT_DT */
        listColumnDefs.add(new ColumnLovDef("현호봉발령일자", PrgmComPsnl0100BM.ATTR_CURRPYSPAPPMTDT,PrgmComPsnl0100BM.ATTR_CURRPYSPAPPMTDT,  ColumnDef.TYPE_STRING, 80 ){
            {
               setIsVisibleInGrid(false);
            }
        });
        /** CURR_DEPT_APPMT_DT */
        listColumnDefs.add(new ColumnLovDef("현부서발령일자", PrgmComPsnl0100BM.ATTR_CURRDEPTAPPMTDT,PrgmComPsnl0100BM.ATTR_CURRDEPTAPPMTDT,  ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        /** PERN_NOTE_CTNT */
        listColumnDefs.add(new ColumnLovDef("비고", PrgmComPsnl0100BM.ATTR_PERNNOTECTNT,PrgmComPsnl0100BM.ATTR_PERNNOTECTNT,  ColumnDef.TYPE_STRING, 80 ){
            {
                 setIsVisibleInGrid(false);
            }
        });
        
        
        lovDef.setListColumns(listColumnDefs); 

        lovDef.addHiddenColumn(new PrgmComPsnl0100Def().getColumnsDefinition()); 
        lovDef.setCustomLayoutContainer(getMsfComP0100Filter()); 
        setInitDate();
    } 


    public static final LayoutContainer getMsfComP0100Filter() {
        
        
        final Date today = new Date(); 
         // A custom date format
        final DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy");  
        
          
        systemkey = new HiddenField<String>();
        
        sysComBass0300Dto = new PrgmComBass0300DTO();
        sysComBass0400Dto = new PrgmComBass0400DTO();
        sysComBass0500Dto = new PrgmComBass0500DTO();
      
      
        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
        //고용구분
        sysComBass0300Dto.setRpsttvCd("A002");
        lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
       
       
       //--------------------부서 불러 오는 함수 ------------------------------------------------
        lsDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
        //--------------------부서 불러 오는 함수 ------------------------------------------------
          
        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
        //재직상태  
        sysComBass0300Dto.setRpsttvCd("A003");
        lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
        
       
        
      /**
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * 직종 콤보박스 처리  시작
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          
         */
               ContentPanel typOccuCdGrid = new ContentPanel();  
               typOccuCdGrid.setVisible(false);
               
               //직종 콤보처리 
              typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
              typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
                      public void handleEvent(ComponentEvent be) {  
                        typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
                         public void handleEvent(StoreEvent<BaseModel> be) {  
                             
                           lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());  
                         }  
                       });  
                      
                     }  
                   });  
         
            typOccuCdGrid.add(typOccuCdGridPanel); 
         
        final FormPanel fp03 = new FormPanel();   
        fp03.setBodyBorder(false); 
        fp03.setHeaderVisible(false);   
        fp03.setLayout(new FlowLayout(2));      
        fp03.setSize(830, 95);
          
          LayoutContainer frmSearchLayer = new LayoutContainer();
          FormLayout layout = new FormLayout();
          layout.setDefaultWidth(850);
          layout.setLabelWidth(70);   
          frmSearchLayer.setLayout(layout);  
            
          /** 여기화면 추가 */
          frmSearchLayer.add(typOccuCdGrid);
          
            
            FieldSet fieldSet = new FieldSet();  
            //fieldSet.setHeading("");  
            fieldSet.setHeadingHtml("");
            LayoutContainer layoutContainer_3 = new LayoutContainer();
            layoutContainer_3.setLayout(new ColumnLayout());
            
            LayoutContainer layoutContainer_4 = new LayoutContainer();
            
            LayoutContainer layoutContainer_6 = new LayoutContainer();
            layoutContainer_6.setLayout(new ColumnLayout());
            
            LayoutContainer layoutContainer_7 = new LayoutContainer(); 
            FormLayout frmLyout = new FormLayout();  
            frmLyout.setLabelWidth(60); 
            frmLyout.setLabelAlign(LabelAlign.RIGHT);    
            layoutContainer_7.setLayout(frmLyout);  
            
            hanNm = new TextField<String>(); 
            hanNm.setName("hanNm");
            hanNm.setFieldLabel("성 명");
            layoutContainer_7.add(hanNm, new FormData("100%"));
            hanNm.setAllowBlank(false);
            layoutContainer_6.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
            layoutContainer_7.setBorders(false);
            
            LayoutContainer layoutContainer_8 = new LayoutContainer();
            frmLyout = new FormLayout();  
            frmLyout.setLabelWidth(0); 
            frmLyout.setLabelAlign(LabelAlign.RIGHT);    
            layoutContainer_8.setLayout(frmLyout); 
            
            resnRegnNum = new TextField<String>();
            resnRegnNum.setName("resnRegnNum");
            layoutContainer_8.add(resnRegnNum, new FormData("100%"));
            resnRegnNum.setFieldLabel("");
            resnRegnNum.setLabelSeparator("");
            layoutContainer_6.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
            layoutContainer_8.setBorders(false);
            layoutContainer_4.add(layoutContainer_6);
            layoutContainer_6.setBorders(false);
            layoutContainer_3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
            layoutContainer_4.setBorders(false);
            
            LayoutContainer layoutContainer_51 = new LayoutContainer(); 
            layoutContainer_51.setLayout(new ColumnLayout()); 
            
            //기간 
            
            LayoutContainer layoutContainer_81 = new LayoutContainer();
            FormLayout frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(60); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_81.setLayout(frmlytSch); 
             
            emymtBgnnDt01 = new DateField();
            emymtBgnnDt01.setName("emymtBgnnDt01");
            new DateFieldMask(emymtBgnnDt01, "9999.99.99"); 
            emymtBgnnDt01.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
            emymtBgnnDt01.setFieldLabel("기간선택");
          //  emymtBgnnDt01.setValue(value); 
            
            layoutContainer_81.add(emymtBgnnDt01, new FormData("100%"));
            layoutContainer_51.add(layoutContainer_81,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
            layoutContainer_81.setBorders(false);
            
            LayoutContainer layoutContainer_91 = new LayoutContainer();
            frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(10); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_91.setLayout(frmlytSch);
            
            emymtBgnnDt02 = new DateField();
            emymtBgnnDt02.setName("emymtBgnnDt02");
            new DateFieldMask(emymtBgnnDt02, "9999.99.99"); 
            emymtBgnnDt02.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
            emymtBgnnDt02.setLabelSeparator("~");
            
            
            layoutContainer_91.add(emymtBgnnDt02, new FormData("100%"));
            layoutContainer_51.add(layoutContainer_91,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
            layoutContainer_91.setBorders(false);
            
            layoutContainer_3.add(layoutContainer_51,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
            layoutContainer_51.setBorders(false);
            
            LayoutContainer layoutContainer_9 = new LayoutContainer();
            frmLyout = new FormLayout();  
            frmLyout.setLabelWidth(60); 
            frmLyout.setLabelAlign(LabelAlign.RIGHT);    
            layoutContainer_9.setLayout(frmLyout);  
            
            
            hdofcCodtnCd = new ComboBox<BaseModel>();
            hdofcCodtnCd.setName("hdofcCodtnCd");
            hdofcCodtnCd.setForceSelection(true);
            hdofcCodtnCd.setMinChars(1);
            hdofcCodtnCd.setDisplayField("commCdNm");
            hdofcCodtnCd.setValueField("commCd");
            hdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
            hdofcCodtnCd.setEmptyText("--재선택--");
            hdofcCodtnCd.setSelectOnFocus(true); 
            hdofcCodtnCd.setReadOnly(false);
            hdofcCodtnCd.setEnabled(true); 
            hdofcCodtnCd.setStore(lsHdofcCodtnCd);
            hdofcCodtnCd.setFieldLabel("재직상태");
            layoutContainer_9.add(hdofcCodtnCd, new FormData("100%"));
            layoutContainer_3.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
            layoutContainer_9.setBorders(false);
            
              LayoutContainer layoutContainer_13 = new LayoutContainer();
              FormLayout frmlytStd = new FormLayout();  
              frmlytStd.setLabelWidth(60); 
              frmlytStd.setLabelAlign(LabelAlign.RIGHT);
              layoutContainer_13.setLayout(frmlytStd);  
              layoutContainer_13.setBorders(false); 
              layoutContainer_3.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
               
            
            fieldSet.add(layoutContainer_3);
            layoutContainer_3.setBorders(false);
          
             
            LayoutContainer lcSchCol = new LayoutContainer();
            lcSchCol.setLayout(new ColumnLayout()); 
            
            LayoutContainer layoutContainer_5 = new LayoutContainer();
            frmLyout = new FormLayout();  
            frmLyout.setLabelWidth(60); 
            frmLyout.setLabelAlign(LabelAlign.RIGHT);    
            layoutContainer_5.setLayout(frmLyout); 
            
            emymtDivCd =  new ComboBox<BaseModel>(); 
            emymtDivCd.setName("emymtDivCd");
            emymtDivCd.setForceSelection(true);
            emymtDivCd.setMinChars(1);
            emymtDivCd.setDisplayField("commCdNm");
            emymtDivCd.setValueField("commCd");
            emymtDivCd.setTriggerAction(TriggerAction.ALL);
            emymtDivCd.setEmptyText("--고용구분선택--");
            emymtDivCd.setSelectOnFocus(true); 
            emymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
            emymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
            emymtDivCd.setStore(lsEmymtDivCd);
            emymtDivCd.setFieldLabel("고용구분"); 
            emymtDivCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                public void handleEvent(StoreEvent<BaseModel> be) {  

                    /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                	//gwtAuthorization.formAuthConfig(fp03, "","emymtDivCd","deptCd","typOccuCd","businCd");
                    /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                     * 권한설정을 위한 콤보처리를 위한 메서드 종료
                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                   
                }
            });   
            emymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
                public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                    //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
                 BaseModel bmPayCd =  se.getSelectedItem(); 
                 if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
                    businCd.setEnabled(true);
                    typOccuCd.setEnabled(false);
                 } else {
                    businCd.setEnabled(false); 
                    typOccuCd.setEnabled(true);
                 }  
                 
                } 
            });
            layoutContainer_5.add(emymtDivCd, new FormData("100%")); 
            layoutContainer_5.setBorders(false);


            LayoutContainer lcSchLeft = new LayoutContainer(); 
              frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(60); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
           // fieldSet.setLayout(layout);  
            lcSchLeft.setLayout(frmlytSch);
             
            
            LayoutContainer lcSchRight = new LayoutContainer(); 
            FormLayout frmlytSchRight = new FormLayout();  
            frmlytSchRight.setLabelWidth(70); 
            frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);    
            lcSchRight.setLayout(frmlytSchRight); 
            
              deptCd = new ComboBox<BaseModel>();
              deptCd.setName("deptCd");
              deptCd.setForceSelection(true);
              deptCd.setMinChars(1);
              deptCd.setDisplayField("deptNmRtchnt");
              deptCd.setValueField("deptCd");
              deptCd.setTriggerAction(TriggerAction.ALL);
              deptCd.setEmptyText("--부서선택--");
              deptCd.setSelectOnFocus(true); 
              deptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
              deptCd.setEnabled(gwtExtAuth.getEnableDeptCd()); 
              deptCd.setStore(lsDeptCd );
              deptCd.setFieldLabel("부서");
              deptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                  public void handleEvent(StoreEvent<BaseModel> be) {  

                      /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                       * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                       * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                       ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                	 // gwtAuthorization.formAuthConfig(fp03, "","emymtDivCd","deptCd","typOccuCd","businCd");
                      /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                       * 권한설정을 위한 콤보처리를 위한 메서드 종료
                       ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                      
                  }
              });   
              deptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
                  public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                      //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
                   BaseModel bmDeptCd =  se.getSelectedItem(); 
                   if (bmDeptCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd.getValue().get("commCd"))) {
                      if (bmDeptCd != null) {
                          sysComBass0500Dto.setDeptCd((String)bmDeptCd.get("deptCd"));
                          sysComBass0500Dto.setBusinApptnYr(fmt.format(today).toString()); 
                       }      
                      //--------------------사업 불러 오는 함수 -------------------------------------------------
                       lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
                      //--------------------사업 불러 오는 함수 -------------------------------------------------
                       businCd.setStore(lsBusinCd);
                       businCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                              public void handleEvent(StoreEvent<BaseModel> be) {  
                                  businCd.setValue(lsBusinCd.getAt(0));  
                              }
                          });    
                   
                   }  
                   
                  } 
              });
            lcSchLeft.add(deptCd, new FormData("100%"));
            
            LayoutContainer layoutContainer = new LayoutContainer();
            layoutContainer.setLayout(new ColumnLayout());
            layoutContainer.setBorders(false);
            
            LayoutContainer layoutContainer_1 = new LayoutContainer();
            frmlytSchRight = new FormLayout();  
            frmlytSchRight.setLabelWidth(60); 
            frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);  
            layoutContainer_1.setLayout(frmlytSchRight);
              
            typOccuCd =  new ComboBox<BaseModel>(); 
            typOccuCd.setName("typOccuCd");
            typOccuCd.setForceSelection(true);
            typOccuCd.setMinChars(1);
            typOccuCd.setDisplayField("typOccuNm");
            typOccuCd.setValueField("typOccuCd");
            typOccuCd.setTriggerAction(TriggerAction.ALL);
            typOccuCd.setEmptyText("--직종선택--");
            typOccuCd.setSelectOnFocus(true); 
            typOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
            typOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd()); 
            typOccuCd.setStore(lsTypOccuCd);
            typOccuCd.setFieldLabel("직종");
            layoutContainer_1.add(typOccuCd, new FormData("100%"));
            layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
            layoutContainer_1.setBorders(false);
            
            LayoutContainer layoutContainer_2 = new LayoutContainer();
             frmlytSchRight = new FormLayout();  
            frmlytSchRight.setLabelWidth(60); 
            frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);    
            layoutContainer_2.setLayout(frmlytSchRight);
            
            businCd = new ComboBox<BaseModel>();
            businCd.setName("businCd");
            businCd.setForceSelection(true);
            businCd.setMinChars(1);
            businCd.setDisplayField("businNm");
            businCd.setValueField("businCd");
            businCd.setTriggerAction(TriggerAction.ALL);
            businCd.setEmptyText("--사업선택--");
            businCd.setSelectOnFocus(true); 
            businCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
            businCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
            businCd.setStore(lsBusinCd);
            businCd.setFieldLabel("사업");
            layoutContainer_2.add(businCd, new FormData("100%"));
            layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
            layoutContainer_2.setBorders(false);
           
           
           
          LayoutContainer layoutContainer_52 = new LayoutContainer(); 
          frmlytSch = new FormLayout();  
          frmlytSch.setLabelWidth(10); 
          frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
          layoutContainer_52.setLayout(frmlytSch);
           
          btnUsrSearch = new Button("검색");
          btnUsrSearch.setIcon(MSFMainApp.ICONS.search());
          layoutContainer_52.add(btnUsrSearch );
          layoutContainer_52.setBorders(false); 
          layoutContainer.add(layoutContainer_52,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
          
          lcSchRight.add(layoutContainer, new FormData("100%"));
            
           lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
           lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 
           lcSchCol.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)); 

            fieldSet.add(lcSchCol,  new FormData("100%"));     
            
            fp03.add(fieldSet);
            
            frmSearchLayer.add(fp03);
          
            return frmSearchLayer ;
      }
    
    private static void setInitDate() { 
    	  
 	    Calendar  intiCal =  Calendar.getInstance(); 
        intiCal.set ( Integer.parseInt( GWTUtils.getStringFromDate(intiCal.getTime(),"yyyy")), Integer.parseInt(GWTUtils.getStringFromDate(intiCal.getTime(),"MM")) - 1, 1 );
        emymtBgnnDt01.setValue(intiCal.getTime());
        int maxDays = intiCal.getActualMaximum(intiCal.DAY_OF_MONTH); 
        Calendar  intieCal =   Calendar.getInstance();
        intieCal.set ( Integer.parseInt( GWTUtils.getStringFromDate(intiCal.getTime(),"yyyy")), Integer.parseInt(GWTUtils.getStringFromDate(intiCal.getTime(),"MM")) - 1, maxDays );
       // intiCal.add(Calendar.DATE, maxDays - 1);
       // GWT.log("일수" + DateTimeFormat.getFormat("yyyy.MM.dd").format(intiCal.getTime()));
        emymtBgnnDt02.setValue(intieCal.getTime());
    }
      
}
