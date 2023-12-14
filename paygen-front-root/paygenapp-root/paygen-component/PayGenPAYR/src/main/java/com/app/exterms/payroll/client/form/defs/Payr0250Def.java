package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0250BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0400BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0320;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0350;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0400;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0500;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass40001;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.google.gwt.i18n.client.DateTimeFormat;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0250Def  extends TableDef implements  PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;
     
    //권한 설정 객체 
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	  
    private PrgmComBass0300DTO sysComBass0300Dto ;
    private PrgmComBass0320DTO sysComBass0320Dto ;
    private PrgmComBass0400DTO sysComBass0400Dto;
    private PrgmComBass0500DTO sysComBass0500Dto;
   // private boolean boolDeptCd = false ;
    
    public static final String COLUMN_DEF_MANGEDEPTCD = "mangeDeptCd"; 
    
    public static final String COLUMN_DEF_DEPTCD = "deptCd"; 
    public static final String COLUMN_DEF_TYPOCCUCD = "typOccuCd"; 
    public static final String COLUMN_DEF_DTILOCCUINTTNCD = "dtilOccuInttnCd"; 
    public static final String COLUMN_DEF_BUSINCD = "businCd"; 

    public static final String FIELD_ID_MANGEDEPTCD = COLUMN_DEF_MANGEDEPTCD + "$mangeDeptCd"; 
    
    public static final String FIELD_ID_DEPTCD = COLUMN_DEF_DEPTCD + "$deptCd"; 
    public static final String FIELD_ID_TYPOCCUCD = COLUMN_DEF_TYPOCCUCD + "$typOccuCd"; 
    public static final String FIELD_ID_DTILOCCUINTTNCD = COLUMN_DEF_DTILOCCUINTTNCD + "$dtilOccuInttnCd"; 
    public static final String FIELD_ID_BUSINCD = COLUMN_DEF_DEPTCD + "$businCd"; 
    
    protected ColumnDefListenerAdapter changeValueListenerAdapter;   //부서정-> 직종/사업
    protected ColumnDefListenerAdapter changeTypOccuCdValueListenerAdapter; //직종->직종세
    protected ColumnDefListenerAdapter changeDtilOccuInttnCdAdapter; //직종->직종세
    //관리부서-> 부서 맵핑 처리 
    protected ColumnDefListenerAdapter changeMangeDeptCdListenerAdapter;    
    
    protected ColumnListDef deptCdColumnDef;
    
    protected ColumnListDef mangeDeptCdColumnDef;
    
    protected ColumnListDef typOccuCdColumnDef; //직종 
    protected ColumnListDef dtilOccuInttnCdColumnDef; //직종세 
    protected ColumnListDef businCdColumnDef;
  
    private  String businApptnYr = "";  //초기화 로딩 팝업 강제 unmask 처리 및 사업장에 따른 정보 처리 
    private  String emymtDivCd = "";  //고용구분에 따른 작업 처리를 위한 처리 부분 
    private  String deptCd = "";   //부서코드 
    private  String payrMangDeptCd = "";   //mange관리부서코드 
   
    private  String mangeDeptCd = "";   //mange관리부서코드 
    
    
    /**
	 * Comment : 
	 * @fn String getMangeDeptCd()
	 * @brief date:2018 2018. 3. 15. user:atres
	 * @return the mangeDeptCd get
	 */
	public String getMangeDeptCd() {
		return mangeDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setMangeDeptCd(String mangeDeptCd)
	 *@brief date:2018 2018. 3. 15. user:atres
	 *@param mangeDeptCd the mangeDeptCd to set
	 */
	public void setMangeDeptCd(String mangeDeptCd) {
		this.mangeDeptCd = mangeDeptCd;
	}

	/**
	 * Comment : 
	 * @fn String getDeptCd()
	 * @brief date:2017 2017. 4. 23. user:paygen
	 * @return the deptCd get
	 */
	public String getDeptCd() {
		return deptCd;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCd(String deptCd)
	 *@brief date:2017 2017. 4. 23. user:paygen
	 *@param deptCd the deptCd to set
	 */
	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}

	/**
	 * Comment : 
	 * @fn String getPayrMangDeptCd()
	 * @brief date:2017 2017. 4. 23. user:paygen
	 * @return the payrMangDeptCd get
	 */
	public String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setPayrMangDeptCd(String payrMangDeptCd)
	 *@brief date:2017 2017. 4. 23. user:paygen
	 *@param payrMangDeptCd the payrMangDeptCd to set
	 */
	public void setPayrMangDeptCd(String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	/**
	 * Comment : 고용구분코드
	 * @fn String getEmymtDivCd()
	 * @brief date:2017 2017. 4. 23. user:paygen
	 * @return the emymtDivCd get
	 */
	public String getEmymtDivCd() {
		return emymtDivCd;
	}

	/**
	 * Comment : 고용구분코드
	 *@fn void setEmymtDivCd(String emymtDivCd)
	 *@brief date:2017 2017. 4. 23. user:paygen
	 *@param emymtDivCd the emymtDivCd to set
	 */
	public void setEmymtDivCd(String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	/**
	 * Comment : 사업년도
	 * @fn String getBusinApptnYr()
	 * @brief date:2017 2017. 2. 23. user:atres-pc
	 * @return the businApptnYr get
	 */
	public String getBusinApptnYr() {
		return businApptnYr;
	}

	/**
	 * Comment : 사업년도 
	 *@fn void setBusinApptnYr(String businApptnYr)
	 *@brief date:2017 2017. 2. 23. user:atres-pc
	 *@param businApptnYr the businApptnYr to set
	 */
	public void setBusinApptnYr(String businApptnYr) {
		this.businApptnYr = businApptnYr;
	}

	public Payr0250Def(){ 
    	  
        // 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
	     gwtAuthorization = GWTAuthorization.getInstance();
	     gwtExtAuth = GWTExtAuth.getInstance();
	     
       	  sysComBass0300Dto = new PrgmComBass0300DTO();
          sysComBass0320Dto = new PrgmComBass0320DTO();
       	  sysComBass0400Dto = new PrgmComBass0400DTO();
          sysComBass0500Dto = new PrgmComBass0500DTO();
          
    	  setTitle(PayrLabel.titlePayr0250());
          setDaoClass(CLASS_PAYR0250_DATA_LIST);
          setCustomListMethod(CLASS_PAYR0250_DATA_LIST);
          setAutoFillGrid(false);
          setShowFilterToolbar(false); 
          setCheckBoxOnGridRows(true); 
		  setEditFieldGrid(true);
          setEditableGrid(true);
		  
          setColumnsDefinition(getPayr0250Def());
		  
    }

    public Payr0250Def(String chkDef){ 
     	 
    	if ("PAYR0250".equals(chkDef)) {
    		
    		 sysComBass0300Dto = new PrgmComBass0300DTO();
    		 sysComBass0320Dto = new PrgmComBass0320DTO();
    		 sysComBass0400Dto = new PrgmComBass0400DTO();
    	     sysComBass0500Dto = new PrgmComBass0500DTO();
    	     
    		 setTitle(PayrLabel.titlePayr0250());
    	     setDaoClass("");
    	     setCustomListMethod(CLASS_PAYR0250_DATA_LIST);
  	        setAutoFillGrid(false); 
	        setShowFilterToolbar(false);
	         
	        setColumnsDefinition(getPayr0250Def());
	        
    	} else if ("PAYR4150".equals(chkDef)) {
    		
    	    setTitle(PayrLabel.titlePayr0250());
  	        setDaoClass("");
  	        setCustomListMethod(CLASS_PAYR0250TOPAYR4150_DATA_LIST);
  	        setAutoFillGrid(false); 
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	         
	        setColumnsDefinition(getPayr0250ToPayr4150());
    	 
	    } else if ("PAYR4250".equals(chkDef)) {
			
		    setTitle(PayrLabel.titlePayr0250());
	        setDaoClass("");
	        setCustomListMethod(CLASS_PAYR0250TOPAYR4250_DATA_LIST);
	        setAutoFillGrid(false); 
	        setShowFilterToolbar(false);
	         
	        setColumnsDefinition(getPayr0250ToPayr4250());
		}  
    }
    
 public List<ColumnDef> getPayr0250ToPayr4150(){
	
	  List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
	  
	  /** column 사업장코드 : dpobCd */
      listColumnDefs.add(new ColumnDef("사업장코드", Payr0250BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{

      	}
      });
      /** column 급여스케줄일련번호 : payScduSeilNum */
      listColumnDefs.add(new ColumnDef("번호", Payr0250BM.ATTR_PAYSCDUSEILNUM, ColumnDef.TYPE_LONG, 50, true, true, true){
        {

        }
      });
      /** column 단위기관코드 : payrMangDeptCd */
      listColumnDefs.add(new ColumnDef("단위기관코드", Payr0250BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{

      	}
      });
      listColumnDefs.add(new ColumnDef("단위기관", Payr0250BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true){
      	{

      	}
      }); 

      /** column 작업년월 : jobYrMnth */
      listColumnDefs.add(new ColumnDef("작업년월", Payr0250BM.ATTR_JOBYRMNTH, ColumnDef.TYPE_STRING, 90, true, true, true){
        {

        }
      });
      /** column 작업명 : jobNm */
      listColumnDefs.add(new ColumnDef("작업명", Payr0250BM.ATTR_JOBNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        {

        }
      });
      
      /** column 급여구분코드 : payCd */
      listColumnDefs.add(new ColumnDef("급여구분코드", Payr0250BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 90, false, false, true){
      	{

      	}
      });
      /** column 급여구분 : payCd */
      listColumnDefs.add(new ColumnDef("급여구분", Payr0250BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 90, true, true, true){
      	{

      	}
      });
      /** column 고용구분코드 : emymtDivCd */
      listColumnDefs.add(new ColumnDef("고용구분코드", Payr0250BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
      	{

      	}
      });
      /** column 고용구분 : emymtDivNm */
      listColumnDefs.add(new ColumnDef("고용구분", Payr0250BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
      	{

      	}
      });
      
      /** column 관리부서 : mangeDeptNm */
      listColumnDefs.add(new ColumnDef("관리부서", Payr0250BM.ATTR_MANGEDEPTCD, ColumnDef.TYPE_STRING, 140, false, false, true){
      	{

      	}
      }); 
      
      /** column 관리부서 : mangeDeptNm */
      listColumnDefs.add(new ColumnDef("관리부서", Payr0250BM.ATTR_MANGEDEPTNM, ColumnDef.TYPE_STRING, 140, true, true, true){
      	{

      	}
      }); 
      
      
     
      /** column 부서코드 : deptCd */
      listColumnDefs.add(new ColumnDef("부서코드", Payr0250BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, false, false, true){
      	{

      	}
      });
      
      /** column 부서 : deptNm */
      listColumnDefs.add(new ColumnDef("부서명", Payr0250BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true){
      	{

      	}
      });
      
      /** column 직종코드 : typOccuCd */
      listColumnDefs.add(new ColumnDef("직종코드", Payr0250BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
          {

          }
      });
      /** column 호봉등급코드 : pyspGrdeCd */
      listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0250BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
          {

          }
      });
      
      /** column 직종 : typOccuNm */
      listColumnDefs.add(new ColumnDef("직종", Payr0250BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, true, true, true){
          {

          }
      });
      
      /** column 호봉등급 : pyspGrdeNm */
      listColumnDefs.add(new ColumnDef("등급", Payr0250BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, true, false, true){
          {

          }
      });
      
      
		      
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0250BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		{
		
		}
		});                                           
		            
		
		/** column 직종세 : dtilOccuClsDivNm */
		listColumnDefs.add(new ColumnDef("직종세", Payr0250BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
		{
		
		}
		});          

      /** column 사업코드 : businCd */
      listColumnDefs.add(new ColumnDef("사업코드", Payr0250BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{

      	}
      });
      
      /** column 사업 : businNm */
      listColumnDefs.add(new ColumnDef("사업명", Payr0250BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, true, true, true){
      	{

      	}
      });
      
      /** column 담당직원번호 : pernChrgEmpIdenNum */
      listColumnDefs.add(new ColumnDef("담당직원번호", Payr0250BM.ATTR_PERNCHRGEMPIDENNUM, ColumnDef.TYPE_STRING, 90, true, false, true){
      	{

      	}
      });
      
      /** column 담당직원 : pernChrgEmpIdenNum */
      listColumnDefs.add(new ColumnDef("담당직원", Payr0250BM.ATTR_PERNCHRGEMPIDENNM, ColumnDef.TYPE_STRING, 90, true, true, true){
      	{

      	}
      });
      
      /** column 지급일자 : pymtDt */
      listColumnDefs.add(new ColumnDef("지급일자", Payr0250BM.ATTR_PYMTDT, ColumnDef.TYPE_DATE, 90, true, true, true){
      	{

      	}
      });
      /** column 반영시작일자 : rflctnBgnnDt */
      listColumnDefs.add(new ColumnDef("시작일자", Payr0250BM.ATTR_RFLCTNBGNNDT, ColumnDef.TYPE_DATE, 90, true, true, true){
      	{

      	}
      });
      /** column 반영종료일자 : rflctnEndDt */
      listColumnDefs.add(new ColumnDef("종료일자", Payr0250BM.ATTR_RFLCTNENDDT, ColumnDef.TYPE_DATE, 90, true, true, true){
      	{

      	}
      });
      /** column 급여마감일자 : payDdlneDt */
      listColumnDefs.add(new ColumnDef("마감일자", Payr0250BM.ATTR_PAYDDLNEDT, ColumnDef.TYPE_DATE, 90, true, true, true){
      	{

      	}
      });
      /** column 지로파일생성일자 : groFlCretnDt */
      listColumnDefs.add(new ColumnDef("지로생성일자", Payr0250BM.ATTR_GROFLCRETNDT, ColumnDef.TYPE_DATE, 90, true, true, true){
      	{

      	}
      });
      
      /** column 부서직종세그룹코드 : deptGpCd */
      listColumnDefs.add(new ColumnDef("부서직종세그룹코드", Payr0250BM.ATTR_DEPTGPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{

      	}
      });
      /** column 호봉제구분코드 : repbtyBusinDivCd */
      listColumnDefs.add(new ColumnDef("호봉제구분코드", Payr0250BM.ATTR_REPBTYBUSINDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
      	{

      	}
      });
      
//      /** column 입력자 : kybdr */
//      listColumnDefs.add(new ColumnDef("입력자", Payr0250BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//      	{
//
//      	}
//      });
//      /** column 입력일자 : inptDt */
//      listColumnDefs.add(new ColumnDef("입력일자", Payr0250BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//      	{
//
//      	}
//      });
//      /** column 입력주소 : inptAddr */
//      listColumnDefs.add(new ColumnDef("입력주소", Payr0250BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//      	{
//
//      	}
//      });
//      /** column 수정자 : ismt */
//      listColumnDefs.add(new ColumnDef("수정자", Payr0250BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//      	{
//
//      	}
//      });
//      /** column 수정일자 : revnDt */
//      listColumnDefs.add(new ColumnDef("수정일자", Payr0250BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//      	{
//
//      	}
//      });
//      /** column 수정주소 : revnAddr */
//      listColumnDefs.add(new ColumnDef("수정주소", Payr0250BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//      	{
//
//      	}
//      });

      
       return listColumnDefs;
 }
 
    public List<ColumnDef>  getPayr0250Def(){
      
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        
        /*****************************************************************
         * 관리부서-> 부서 맵핑 처리 
         *****************************************************************/
        changeMangeDeptCdListenerAdapter = new ColumnDefListenerAdapter() {
            @SuppressWarnings("rawtypes")
            public void run(Field field, Object valueField) {
                //To get by name the combo box fields
                Field mangeDeptCdField = findFieldByAttributeName(FIELD_ID_MANGEDEPTCD);  
                
                if (FIELD_ID_MANGEDEPTCD.equals(field.getItemId())) {

                    //Clear countries and locations
                    GWTUtils.clearField(mangeDeptCdField);  
                    //Reload Countries
                    BaseModel item = (BaseModel)valueField;
                    String mangeDeptCd = MSFSharedUtils.defaultNulls(item.get("mangeDeptCd"),"");
                  //  Date today = new Date(); 
                   // DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy");  
                    setMangeDeptCd(mangeDeptCd);
                    
                  if (MSFConfiguration.EMYMT_DIVCD02.equals(getEmymtDivCd())) {
                	  
	                    
	                    IColumnFilter filters = null;
	                    deptCdColumnDef.getTableDef().setTableColumnFilters(filters);
	                    deptCdColumnDef.getTableDef().addColumnFilter("deptDspyYn","Y", SimpleColumnFilter.OPERATOR_EQUALS); 
	                    deptCdColumnDef.getTableDef().addColumnFilter("payrMangDeptCd", getPayrMangDeptCd(), SimpleColumnFilter.OPERATOR_EQUALS);
	                    deptCdColumnDef.getTableDef().addColumnFilter("chkCombo", "combo" , SimpleColumnFilter.OPERATOR_EQUALS); 
	                    deptCdColumnDef.getTableDef().addColumnFilter("mangeDeptCd", getMangeDeptCd(), SimpleColumnFilter.OPERATOR_EQUALS);
	                    deptCdColumnDef.readData(); 
	                    
                  } else  if (MSFConfiguration.EMYMT_DIVCD01.equals(getEmymtDivCd())) { 
                	  IColumnFilter filters = null;
                	  deptCdColumnDef.getTableDef().setTableColumnFilters(filters);
                    	//단위 기관에 따른 부서 처리 루틴 및 부서에 따른 직종세 처리 추가 
                	  deptCdColumnDef.getTableDef().addColumnFilter("deptDspyYn","Y", SimpleColumnFilter.OPERATOR_EQUALS); 
                	  deptCdColumnDef.getTableDef().addColumnFilter("payrMangDeptCd", getPayrMangDeptCd(), SimpleColumnFilter.OPERATOR_EQUALS);
                	  deptCdColumnDef.getTableDef().addColumnFilter("mangeDeptCd",  getMangeDeptCd(), SimpleColumnFilter.OPERATOR_EQUALS);
                	  deptCdColumnDef.getTableDef().addColumnFilter("chkCombo", "combo" , SimpleColumnFilter.OPERATOR_EQUALS); 
	           
                	  deptCdColumnDef.readData();	 
                    	
                   }
                 } 
  
            }
        };
        
        //We create a Listener Adapter to run custom code when one of the combo boxes changes value.
        //The listener adapter is attached to the combo boxes using the method ColumnDef.addTrigger().
        changeValueListenerAdapter = new ColumnDefListenerAdapter() {
            @SuppressWarnings("rawtypes")
            public void run(Field field, Object valueField) {
                //To get by name the combo box fields
                Field businCdField = findFieldByAttributeName(FIELD_ID_BUSINCD); 
                Field typOccuCdField = findFieldByAttributeName(FIELD_ID_TYPOCCUCD); 
                Field dtilOccuInttnCdField = findFieldByAttributeName(FIELD_ID_DTILOCCUINTTNCD);  
                 
                if (FIELD_ID_DEPTCD.equals(field.getItemId())) {

                    //Clear countries and locations
                    GWTUtils.clearField(businCdField); 
                    GWTUtils.clearField(typOccuCdField); 
                    GWTUtils.clearField(dtilOccuInttnCdField); 
                    //Reload Countries
                    BaseModel item = (BaseModel)valueField;
                    String deptCd = MSFSharedUtils.defaultNulls(item.get("deptCd"),"");
                  //  Date today = new Date(); 
                   // DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy");  
                    setDeptCd(deptCd);
                    
                  if (MSFConfiguration.EMYMT_DIVCD02.equals(getEmymtDivCd())) {
                	  
	                    String strBusinApptnYr =  getBusinApptnYr(); 
	                    IColumnFilter filters = null;
	                    businCdColumnDef.getTableDef().setTableColumnFilters(filters);
	                    businCdColumnDef.getTableDef().addColumnFilter("payrMangDeptCd", getPayrMangDeptCd(), SimpleColumnFilter.OPERATOR_EQUALS);
		                  
	                    businCdColumnDef.getTableDef().addColumnFilter("deptCd", deptCd, SimpleColumnFilter.OPERATOR_EQUALS);
	                    businCdColumnDef.getTableDef().addColumnFilter("chkCombo", "combo" , SimpleColumnFilter.OPERATOR_EQUALS); 
	                   // businCdColumnDef.getTableDef().addColumnFilter("businApptnYr",fmt.format(today), SimpleColumnFilter.OPERATOR_EQUALS); 
	                    businCdColumnDef.getTableDef().addColumnFilter("businApptnYr",strBusinApptnYr, SimpleColumnFilter.OPERATOR_EQUALS); 
	                  
	                    //businCdColumnDef.getTableDef().setTableColumnFilters(new SimpleColumnFilter("businApptnYr", MSFSharedUtils.allowNulls(jobYrMnthField.getValue()).substring(0,4), SimpleColumnFilter.OPERATOR_EQUALS));
	                    //businCdColumnDef.getTableDef().setTableColumnFilters(new SimpleColumnFilter("deptCd", deptCd, SimpleColumnFilter.OPERATOR_EQUALS));
	                    businCdColumnDef.readData(); 
	                    
                  } else  if (MSFConfiguration.EMYMT_DIVCD01.equals(getEmymtDivCd())) { 
                	  IColumnFilter filters = null;
                	  typOccuCdColumnDef.getTableDef().setTableColumnFilters(filters);
                    	//단위 기관에 따른 부서 처리 루틴 및 부서에 따른 직종세 처리 추가 
                	  typOccuCdColumnDef.getTableDef().addColumnFilter("payrMangDeptCd", getPayrMangDeptCd(), SimpleColumnFilter.OPERATOR_EQUALS);
		               
                	  typOccuCdColumnDef.getTableDef().addColumnFilter("deptCd", deptCd, SimpleColumnFilter.OPERATOR_EQUALS);
                	  typOccuCdColumnDef.getTableDef().addColumnFilter("chkCombo", "combo" , SimpleColumnFilter.OPERATOR_EQUALS); 
	           
                	  typOccuCdColumnDef.readData();	 
                    	
                   }
                 } 
  
            }
        };
        
        
        
        changeTypOccuCdValueListenerAdapter = new ColumnDefListenerAdapter() {
            @SuppressWarnings("rawtypes")
            public void run(Field field, Object valueField) {
              
                //To get by name the combo box fields
                Field dtilOccuInttnCdField = findFieldByAttributeName(FIELD_ID_DTILOCCUINTTNCD);  
                
                if (FIELD_ID_TYPOCCUCD.equals(field.getItemId()) ) {

                    //Clear countries and locations
                    GWTUtils.clearField(dtilOccuInttnCdField); 
                    //Reload Countries
                    BaseModel item = (BaseModel)valueField;
                    String typOccuCd = "";
                    if  (MSFSharedUtils.paramNotNull(item)) {
                      typOccuCd = (String)item.get("typOccuCd");
                    }
                    IColumnFilter filters = null;
                    dtilOccuInttnCdColumnDef.getTableDef().setTableColumnFilters(filters);
              	  
                    dtilOccuInttnCdColumnDef.getTableDef().addColumnFilter("payrMangDeptCd", getPayrMangDeptCd(), SimpleColumnFilter.OPERATOR_EQUALS);
                    dtilOccuInttnCdColumnDef.getTableDef().addColumnFilter("deptCd", getDeptCd(), SimpleColumnFilter.OPERATOR_EQUALS);
		            dtilOccuInttnCdColumnDef.getTableDef().addColumnFilter("typOccuCd", typOccuCd, SimpleColumnFilter.OPERATOR_EQUALS);
                    dtilOccuInttnCdColumnDef.getTableDef().addColumnFilter("chkCombo", "combo" , SimpleColumnFilter.OPERATOR_EQUALS); 
                    dtilOccuInttnCdColumnDef.readData();
	                    
                
                 } 
 
            }
        };
        

        changeDtilOccuInttnCdAdapter = new ColumnDefListenerAdapter() {
            @SuppressWarnings("rawtypes")
            public void run(Field field, Object valueField) {
              
//                //To get by name the combo box fields
//                Field businCdField = findFieldByAttributeName(FIELD_ID_BUSINCD);  
//                
//                if (FIELD_ID_DEPTCD.equals(field.getItemId()) ) {
//
//                    //Clear countries and locations
//                    GWTUtils.clearField(businCdField); 
//                    //Reload Countries
//                    BaseModel item = (BaseModel)valueField;
//                    String deptCd = (String)item.get("deptCd");
//                    Date today = new Date(); 
//                    DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy");  
//                    
//                    if (MSFConfiguration.EMYMT_DIVCD02.equals(getEmymtDivCd())) {
//                    	
//	                    String strBusinApptnYr =  getBusinApptnYr();
//	                    
//	                    businCdColumnDef.getTableDef().setTableColumnFilters(new SimpleColumnFilter("deptCd", deptCd, SimpleColumnFilter.OPERATOR_EQUALS));
//	                    businCdColumnDef.getTableDef().addColumnFilter("chkCombo", "combo" , SimpleColumnFilter.OPERATOR_EQUALS); 
//	                   // businCdColumnDef.getTableDef().addColumnFilter("businApptnYr",fmt.format(today), SimpleColumnFilter.OPERATOR_EQUALS); 
//	                    businCdColumnDef.getTableDef().addColumnFilter("businApptnYr",strBusinApptnYr, SimpleColumnFilter.OPERATOR_EQUALS); 
//	                    //MSFSharedUtils.allowNulls(jobYrMnthField.getValue())
//	                    //businCdColumnDef.getTableDef().setTableColumnFilters(new SimpleColumnFilter("businApptnYr", MSFSharedUtils.allowNulls(jobYrMnthField.getValue()).substring(0,4), SimpleColumnFilter.OPERATOR_EQUALS));
//	                    //businCdColumnDef.getTableDef().setTableColumnFilters(new SimpleColumnFilter("deptCd", deptCd, SimpleColumnFilter.OPERATOR_EQUALS));
//	                    businCdColumnDef.readData();
//	                    
//                    } else  if (MSFConfiguration.EMYMT_DIVCD01.equals(getEmymtDivCd())) {
//                    	//단위 기관에 따른 부서 처리 루틴 및 부서에 따른 직종세 처리 추가 
//                    	
//                    	
//                    	
//                    }
//                 } 
 
            }
        };

          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0250BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });

        /** column 단위기관코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관코드", Payr0250BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
      
        /** column 급여스케줄일련번호 : payScduSeilNum */
        listColumnDefs.add(new ColumnDef("번호", Payr0250BM.ATTR_PAYSCDUSEILNUM, ColumnDef.TYPE_LONG,40, false, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        listColumnDefs.add(new ColumnDef("단위기관", Payr0250BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING, 60, false, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        sysComBass0300Dto.setRpsttvCd("B015"); 
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnListDef("급여구분", Payr0250BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 70, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{
        		setReadOnly(true); 
        	}
        });
        /** column 급여구분 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분", Payr0250BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 60, false, false, false){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 작업년월 : jobYrMnth */
        listColumnDefs.add(new ColumnDef("작업년월", Payr0250BM.ATTR_JOBYRMNTH, ColumnDef.TYPE_STRING, 60, true, true, true){
        	{
        	 setMaxLength(7);   
        	 setTypeTextField(ColumnDef.TEXTFIELD);
        	 setTextFdMask("9999.99");
        	}
        });
        /** column 작업명 : jobNm */
        listColumnDefs.add(new ColumnDef("작업명", Payr0250BM.ATTR_JOBNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
//        if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
//            sysComBass0300Dto.setCommCd(MSFConfiguration.EMYMT_DIVCD02);
//        } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//            sysComBass0300Dto.setCommCd(MSFConfiguration.EMYMT_DIVCD01);
//        } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//             sysComBass0300Dto.setCommCd(MSFConfiguration.EMYMT_DIVCD01); 
//        }
//        if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
//            
//            boolDeptCd =  true;
//	    } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//	           if (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))) {
//	              boolDeptCd =  true;
//	           } else {
//	               boolDeptCd =  false;
//	           } 
//	      } else {
//	          boolDeptCd =  false;
//	           
//	     }
        sysComBass0300Dto.setRpsttvCd("A002"); 
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnListDef("고용구분", Payr0250BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 70, true, true, true ,new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{
//            	 if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
//            	        setReadOnly(true);
//                  
//            	 } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//            	     setReadOnly(true);
//            	 }
        		  setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
        	} 
        });
        /** column 고용구분 : emymtDivNm */
        listColumnDefs.add(new ColumnDef("고용구분", Payr0250BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{
              setReadOnly(true);
        	}
        }); 
        
        
        sysComBass0300Dto.setRpsttvCd("A048"); 
        /** column 호봉제구분 : repbtyBusinDivCd */
        listColumnDefs.add(new ColumnListDef("호봉제구분", Payr0250BM.ATTR_REPBTYBUSINDIVCD, ColumnDef.TYPE_STRING, 80, false, true, false ,new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{
//            	 if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
//            	        setReadOnly(true);
//                  
//            	 } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//            	     setReadOnly(true);
//            	 }
        //		  setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
        	} 
        });
        /** column 호봉제구분 : repbtyBusinDivNm */
        listColumnDefs.add(new ColumnDef("호봉제구분", Payr0250BM.ATTR_REPBTYBUSINDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
              setReadOnly(true);
        	}
        }); 
        
        /** 관리부서코드  mangeDeptCd */
      
        sysComBass0400Dto.setDeptDspyYn("Y");
      //  sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());
        /** column 관리부서코드 : mangeDeptCd */
        mangeDeptCdColumnDef = new ColumnListDef("관리부서", Payr0250BM.ATTR_MANGEDEPTCD, ColumnDef.TYPE_STRING, 140, false, true, false,new LookupPrgmComBass40001(sysComBass0400Dto),PrgmComBass0400BM.ATTR_MANGEDEPTCD,PrgmComBass0400BM.ATTR_DEPTNMRTCHNT){
                           { 
                        	     setEmptyText("");
                              // setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
                             //  if (!gwtExtAuth.getReadOnlyDeptCd()) { 
                                   addTrigger(Events.Change, changeMangeDeptCdListenerAdapter);  
                                   addTrigger(Events.OnFocus, changeMangeDeptCdListenerAdapter);
                              // }    
                           }
                    };
                            
       listColumnDefs.add(mangeDeptCdColumnDef);
       sysComBass0400Dto.setDeptDspyYn("");
        /** column 관리부서 : mangeDeptNm */
        listColumnDefs.add(new ColumnDef("관리부서", Payr0250BM.ATTR_MANGEDEPTNM, ColumnDef.TYPE_STRING, 140, false, false, false){
        	{

        	}
        }); 
        
        /** 관리부서코드  mangeDeptCd */
        
        
        
        sysComBass0400Dto.setDeptDspyYn("Y");
        sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());
        /** column 부서코드 : deptCd */
      //  listColumnDefs.add(new ColumnListDef("부서", Payr0250BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 120, true, true, true,new LookupPrgmComBass0400(sysComBass0400Dto),PrgmComBass0400BM.ATTR_DEPTCD,PrgmComBass0400BM.ATTR_DEPTNMRTCHNT){
        deptCdColumnDef = new ColumnListDef("부서", Payr0250BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 140, false, true, true,new LookupPrgmComBass0400(sysComBass0400Dto),PrgmComBass0400BM.ATTR_DEPTCD,PrgmComBass0400BM.ATTR_DEPTNMRTCHNT){
        { 
                        	    //TODO 차후 적용후 풆기 
                              // setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
                             //  if (!gwtExtAuth.getReadOnlyDeptCd()) { 
                                   addTrigger(Events.Change, changeValueListenerAdapter);  
                                   addTrigger(Events.OnFocus, changeValueListenerAdapter);
                              // }    
                           }
                    };
                            
       listColumnDefs.add(deptCdColumnDef);
       sysComBass0400Dto.setDeptDspyYn("");
        /** column 부서 : deptNm */
        listColumnDefs.add(new ColumnDef("부서명", Payr0250BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 140, false, false, true){
        	{

        	}
        }); 
        
        boolean chkbusinShow = true ;
        if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
            chkbusinShow = false;
        } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
            chkbusinShow = true;
        } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
            chkbusinShow = true;
        } else {
            chkbusinShow = true;
        }
        
        /** column 직종코드 : typOccuCd */
        sysComBass0320Dto.setPayrMangDeptCd( MSFMainApp.get().getUser().getPayrMangDeptCd());
        if(MSFMainApp.get().getUser().getAuthCheck().getAuthCheck03().equals("FALSE")) {
        	sysComBass0320Dto.setDeptCd(MSFMainApp.get().getUser().getDeptCd());   
        } else {
        	sysComBass0320Dto.setDeptCd("");  
        }
      
        typOccuCdColumnDef = new ColumnListDef("직종", Payr0250BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 100, false, chkbusinShow, true,new LookupPrgmComBass0320(sysComBass0320Dto),PrgmComBass0350BM.ATTR_TYPOCCUCD,PrgmComBass0350BM.ATTR_TYPOCCUNM) {
      //  listColumnDefs.add(new ColumnListDef("직종", Payr0250BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 100, true, chkbusinShow, true,new LookupPrgmComBass0320(sysComBass0320Dto),PrgmComBass0350BM.ATTR_TYPOCCUCD,PrgmComBass0350BM.ATTR_TYPOCCUNM){
           {
                 addTrigger(Events.Change, changeTypOccuCdValueListenerAdapter);  
            }
        };
        listColumnDefs.add(typOccuCdColumnDef);
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급", Payr0250BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        
        /** column 직종코드 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Payr0250BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 호봉등급코드 : pyspGrdeNm */
        listColumnDefs.add(new ColumnDef("등급", Payr0250BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        }); 
         
      
        dtilOccuInttnCdColumnDef = new ColumnListDef("직종세", Payr0250BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING, 100, false, chkbusinShow, true,new LookupPrgmComBass0350(),PrgmComBass0350BM.ATTR_DTILOCCUINTTNCD,PrgmComBass0350BM.ATTR_DTILOCCUCLSNM) {
            	        
		/** column 직종세통합코드 : dtilOccuInttnCd */
		//listColumnDefs.add(new ColumnListDef("직종세", Payr0250BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 100, true, chkbusinShow, true,new LookupPrgmComBass0350(),PrgmComBass0350BM.ATTR_DTILOCCUINTTNCD,PrgmComBass0350BM.ATTR_DTILOCCUCLSNM){
		{
			// addTrigger(Events.Select, changeDtilOccuInttnCdAdapter);  
		}
		} ;                                           
		                           
		 listColumnDefs.add(dtilOccuInttnCdColumnDef);     
		
		 /** column 직종세 : dtilOccuClsDivNm */
		listColumnDefs.add(new ColumnDef("직종세", Payr0250BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
		{
		
		}
		});                     
		 
        
        chkbusinShow = true ;
        if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
            chkbusinShow = true;
        } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
            chkbusinShow = false;
        } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
            chkbusinShow = false;
        } else {
            chkbusinShow = true;
        }
        
        /** column 사업코드 : businCd */
        Date today = new Date(); 
        // A custom date format
        DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy");  
        sysComBass0500Dto.setBusinApptnYr(fmt.format(today));
        sysComBass0500Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());  //gwtExtAuth.getReadOnlyBusinCd()
        businCdColumnDef = new ColumnListDef("사업", Payr0250BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 130, false, chkbusinShow, true,new LookupPrgmComBass0500(sysComBass0500Dto),PrgmComBass0500BM.ATTR_BUSINCD,PrgmComBass0500BM.ATTR_BUSINNM,chkbusinShow)
        {{
        	
        }};
        
        listColumnDefs.add(businCdColumnDef);
        /** column 사업 : businNm */
        listColumnDefs.add(new ColumnDef("사업명", Payr0250BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 담당직원번호 : pernChrgEmpIdenNum */
        listColumnDefs.add(new ColumnDef("담당직원번호", Payr0250BM.ATTR_PERNCHRGEMPIDENNUM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        	    setReadOnly(true);
        	}
        });
        
        /** column 담당직원 : pernChrgEmpIdenNum */
        listColumnDefs.add(new ColumnDef("담당직원", Payr0250BM.ATTR_PERNCHRGEMPIDENNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        	    setReadOnly(true);
        	}
        });
        
       
        /** column 지급일자 : pymtDt */
        listColumnDefs.add(new ColumnDef("지급일자", Payr0250BM.ATTR_PYMTDT, ColumnDef.TYPE_DATE, 90, true, true, true){
        	{
        	    setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");
        	}
        });
        /** column 반영시작일자 : rflctnBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Payr0250BM.ATTR_RFLCTNBGNNDT, ColumnDef.TYPE_DATE, 90, true, true, true){
        	{
        	    setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
        		setDtFieldMask("9999.99.99");
        	}
        });
        /** column 반영종료일자 : rflctnEndDt */
        listColumnDefs.add(new ColumnDef("종료일자", Payr0250BM.ATTR_RFLCTNENDDT, ColumnDef.TYPE_DATE, 90, true, true, true){
        	{
        	    setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd")); 
        		setDtFieldMask("9999.99.99");
        	}
        });
        /** column 급여마감일자 : payDdlneDt */
        listColumnDefs.add(new ColumnDef("마감일자", Payr0250BM.ATTR_PAYDDLNEDT, ColumnDef.TYPE_DATE, 90, false, true, true){
        	{
        		
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		//setDtFieldMask("9999.99.99");
        		setReadOnly(true);
        	}
        });
        /** column 지로파일생성일자 : groFlCretnDt */
        listColumnDefs.add(new ColumnDef("지로생성일자", Payr0250BM.ATTR_GROFLCRETNDT, ColumnDef.TYPE_DATE, 90, false, true, true){
        	{
        		
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
        		//setDtFieldMask("9999.99.99");
        		setReadOnly(true);
        	}
        });
        
        /** column 부서직종세그룹코드 : deptGpCd */
        listColumnDefs.add(new ColumnDef("부서직종세그룹코드", Payr0250BM.ATTR_DEPTGPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        
         return listColumnDefs;
    }
    
    
    public List<ColumnDef> getPayr0250ToPayr4250(){
   	
   	  List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
   	  
   	  /** column 사업장코드 : dpobCd */
         listColumnDefs.add(new ColumnDef("사업장코드", Payr0250BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
         	{

         	}
         });
         
         /** column 급여스케줄일련번호 : payScduSeilNum */
         listColumnDefs.add(new ColumnDef("번호", Payr0250BM.ATTR_PAYSCDUSEILNUM, ColumnDef.TYPE_LONG, 50, false, false, true){
         	{

         	}
         });

         /** column 단위기관코드 : payrMangDeptCd */
         listColumnDefs.add(new ColumnDef("단위기관코드", Payr0250BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, false, false, true){
         	{

         	}
         });
         listColumnDefs.add(new ColumnDef("단위기관", Payr0250BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING, 80, false, true, true){
         	{

         	}
         });

         /** column 작업년월 : jobYrMnth */
         listColumnDefs.add(new ColumnDef("작업년월", Payr0250BM.ATTR_JOBYRMNTH, ColumnDef.TYPE_STRING, 90, true, true, true){
            {

            }
         });
         /** column 작업명 : jobNm */
         listColumnDefs.add(new ColumnDef("작업명", Payr0250BM.ATTR_JOBNM, ColumnDef.TYPE_STRING, 90, true, true, true){
            {

            }
         });
         
         
         /** column 급여구분코드 : payCd */
         listColumnDefs.add(new ColumnDef("급여구분코드", Payr0250BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 90, false, false, true){
         	{

         	}
         });
         /** column 급여구분 : payCd */
         listColumnDefs.add(new ColumnDef("급여구분", Payr0250BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 80, true, true, true){
         	{

         	}
         });
         /** column 고용구분코드 : emymtDivCd */
         listColumnDefs.add(new ColumnDef("고용구분코드", Payr0250BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
         	{

         	}
         });
         /** column 고용구분 : emymtDivNm */
         listColumnDefs.add(new ColumnDef("고용구분", Payr0250BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
         	{

         	}
         });
         
         /** column 관리부서 : mangeDeptNm */
         listColumnDefs.add(new ColumnDef("관리부서", Payr0250BM.ATTR_MANGEDEPTCD, ColumnDef.TYPE_STRING, 120, false, false, true){
         	{

         	}
         }); 
         
         /** column 관리부서 : mangeDeptNm */
         listColumnDefs.add(new ColumnDef("관리부서", Payr0250BM.ATTR_MANGEDEPTNM, ColumnDef.TYPE_STRING, 120, false, true, true){
         	{

         	}
         }); 
         
         /** column 부서코드 : deptCd */
         listColumnDefs.add(new ColumnDef("부서코드", Payr0250BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 100, false, false, true){
         	{

         	}
         });
         
         /** column 부서 : deptNm */
         listColumnDefs.add(new ColumnDef("부서명", Payr0250BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 100, false, true, true){
         	{

         	}
         });
         

         boolean chkbusinShow = true ;
         if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
             chkbusinShow = false;
         } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
             chkbusinShow = true;
         } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
             chkbusinShow = true;
         } else {
             chkbusinShow = true;
         }
         
         /** column 직종코드 : typOccuCd */
         listColumnDefs.add(new ColumnDef("직종코드", Payr0250BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
             {

             }
         });
         /** column 호봉등급코드 : pyspGrdeCd */
         listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0250BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
             {

             }
         });
         
         /** column 직종 : typOccuNm */
         listColumnDefs.add(new ColumnDef("직종", Payr0250BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, true, chkbusinShow, true){
             {

             }
         });
         /** column 호봉등급 : pyspGrdeNm */
         listColumnDefs.add(new ColumnDef("등급", Payr0250BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, true, false, true){
             {

             }
         });
         
         
         
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0250BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		{
		
		}
		});                                           
		            
		
		/** column 직종세 : dtilOccuClsDivNm */
		listColumnDefs.add(new ColumnDef("직종세", Payr0250BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, chkbusinShow, true){
		{
		
		}
		});                     
		

       
         chkbusinShow = true ;
         if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
             chkbusinShow = true;
         } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
             chkbusinShow = false;
         } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
             chkbusinShow = false;
         } else {
             chkbusinShow = true;
         }
         
         /** column 사업코드 : businCd */
         listColumnDefs.add(new ColumnDef("사업코드", Payr0250BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, false, false, true){
         	{

         	}
         });
         
         /** column 사업 : businNm */
         listColumnDefs.add(new ColumnDef("사업명", Payr0250BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, true, chkbusinShow, true){
         	{

         	}
         });
         
         /** column 담당직원번호 : pernChrgEmpIdenNum */
         listColumnDefs.add(new ColumnDef("담당직원번호", Payr0250BM.ATTR_PERNCHRGEMPIDENNUM, ColumnDef.TYPE_STRING, 90, true, false, true){
         	{

         	}
         });
         
         /** column 담당직원 : pernChrgEmpIdenNum */
         listColumnDefs.add(new ColumnDef("담당직원", Payr0250BM.ATTR_PERNCHRGEMPIDENNM, ColumnDef.TYPE_STRING, 90, true, true, true){
         	{

         	}
         });
         
         /** column 지급일자 : pymtDt */
         listColumnDefs.add(new ColumnDef("지급일자", Payr0250BM.ATTR_PYMTDT, ColumnDef.TYPE_DATE, 90, true, true, true){
         	{

         	}
         });
         /** column 반영시작일자 : rflctnBgnnDt */
         listColumnDefs.add(new ColumnDef("시작일자", Payr0250BM.ATTR_RFLCTNBGNNDT, ColumnDef.TYPE_DATE, 90, true, true, true){
         	{

         	}
         });
         /** column 반영종료일자 : rflctnEndDt */
         listColumnDefs.add(new ColumnDef("종료일자", Payr0250BM.ATTR_RFLCTNENDDT, ColumnDef.TYPE_DATE, 90, true, true, true){
         	{

         	}
         });
         /** column 급여마감일자 : payDdlneDt */
         listColumnDefs.add(new ColumnDef("마감일자", Payr0250BM.ATTR_PAYDDLNEDT, ColumnDef.TYPE_DATE, 90, true, true, true){
         	{

         	}
         });
         /** column 지로파일생성일자 : groFlCretnDt */
         listColumnDefs.add(new ColumnDef("지로생성일자", Payr0250BM.ATTR_GROFLCRETNDT, ColumnDef.TYPE_DATE, 90, true, true, true){
         	{

         	}
         });
         
         /** column 부서직종세그룹코드 : deptGpCd */
         listColumnDefs.add(new ColumnDef("부서직종세그룹코드", Payr0250BM.ATTR_DEPTGPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
         	{

         	}
         });
         /** column 호봉제구분코드 : repbtyBusinDivCd */
         listColumnDefs.add(new ColumnDef("호봉제구분코드", Payr0250BM.ATTR_REPBTYBUSINDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
         	{

         	}
         });
         
//         /** column 입력자 : kybdr */
//         listColumnDefs.add(new ColumnDef("입력자", Payr0250BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//         	{
   //
//         	}
//         });
//         /** column 입력일자 : inptDt */
//         listColumnDefs.add(new ColumnDef("입력일자", Payr0250BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//         	{
   //
//         	}
//         });
//         /** column 입력주소 : inptAddr */
//         listColumnDefs.add(new ColumnDef("입력주소", Payr0250BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//         	{
   //
//         	}
//         });
//         /** column 수정자 : ismt */
//         listColumnDefs.add(new ColumnDef("수정자", Payr0250BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//         	{
   //
//         	}
//         });
//         /** column 수정일자 : revnDt */
//         listColumnDefs.add(new ColumnDef("수정일자", Payr0250BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//         	{
   //
//         	}
//         });
//         /** column 수정주소 : revnAddr */
//         listColumnDefs.add(new ColumnDef("수정주소", Payr0250BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//         	{
   //
//         	}
//         });

         
          return listColumnDefs;
    }
    
}
