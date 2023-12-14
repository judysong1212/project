package com.app.exterms.personal.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0100BM;
import com.app.exterms.personal.client.dto.Psnl0110BM;
import com.app.exterms.personal.client.dto.Psnl0300BM;
import com.app.exterms.personal.client.dto.Psnl0310BM;
import com.app.exterms.personal.client.languages.PsnlConstants;
import com.app.exterms.personal.shared.PsnlDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Psnl0300Def  extends TableDef implements PsnlDaoConstants {

    private int row = 0;
    private PsnlConstants psnlLabel = PsnlConstants.INSTANCE;
    
    public static final String COLUMN_DEF_HODYAPPTNNUMDYS = "hodyApptnNumDys"; 
    public static final String COLUMN_DEF_HODYUSENUMDYS = "hodyUseNumDys"; 
    public static final String COLUMN_DEF_HODYRSTNUMDYS = "hodyRstNumDys"; 

    public static final String FIELD_ID_HODYAPPTNNUMDYS = COLUMN_DEF_HODYAPPTNNUMDYS; 
    public static final String FIELD_ID_HODYUSENUMDYS = COLUMN_DEF_HODYUSENUMDYS; 
    public static final String FIELD_ID_HODYRSTNUMDYS = COLUMN_DEF_HODYRSTNUMDYS; 
    public static final String FIELD_ID_TT = COLUMN_DEF_HODYAPPTNNUMDYS+"$hodyApptnNumDys"; 
   
    protected ColumnDefListenerAdapter changeValueListenerAdapter; 
  

    public Psnl0300Def(String chkDef){
    	if ("PSNL0300".equals(chkDef)) {
	        setTitle("");
//	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
	        setCustomListMethod(CLASS_PSNL0300_DATA_LIST);
	        
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
	        setColumnsDefinition(getPsnl0300ColumnsList01());  
	      
    	}else if("PSNLP0300".equals(chkDef)) {
	        setTitle("");
//	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
	        setCustomListMethod(CLASS_PSNLP0300_DATA_LIST);
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
	        setColumnsDefinition(getPsnl0300ColumnsList02());  
	      
    	}
//    	else if ("".equals(chkDef)) {
//	        setTitle("");
////	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
//	        setCustomListMethod(CLASS_PSNL0300_DATA_LIST);
//	        setColumnsDefinition(getPsnl0295ToPsnl0126ColumnsList());
//	        setAutoFillGrid(false);
//	        setShowFilterToolbar(false);
//	        setCheckBoxOnGridRows(false);
//	        setEditFieldGrid(false);
////	        setCellModel(true);
//	        
//    	}
    }

    private List<ColumnDef> getPsnl0300ColumnsList01(){ 
    	
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        
        
    	/** column 발령구분코드 : appmtDivCd */
    	listColumnDefs.add(new ColumnDef("발령구분코드", Psnl0300BM.ATTR_APPMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	
    	/** column 발령구분코드 : appmtDivCd */
    	listColumnDefs.add(new ColumnDef("발령구분", Psnl0300BM.ATTR_APPMTDIVCDNM, ColumnDef.TYPE_STRING , 100, true, true, true){
    		{

    		}
    	});
    	
    	/** column 발령일자 : appmtDt */
    	listColumnDefs.add(new ColumnDef("발령일자", Psnl0300BM.ATTR_APPMTDT, ColumnDef.TYPE_STRING , 80, true, true, true){
    		{

    		}
    	});
    	
    	/** column 성명 : hanNm */
    	listColumnDefs.add(new ColumnDef("성명", Psnl0300BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 80, true, true, true){
    		{

    		}
    	});
    	
    	/** column 주민번호 : resnRegnNum */
    	listColumnDefs.add(new ColumnDef("주민번호", Psnl0300BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 80, true, true, true){
    		{

    		}
    	});
    	
    	/** column 상태 : resnRegnNum */
    	listColumnDefs.add(new ColumnDef("상태", Psnl0300BM.ATTR_APPMTFIXYNNM, ColumnDef.TYPE_STRING , 80, true, true, true){
    		{

    		}
    	});
    	
    	/** column 전부서 : bfrDeptCd */
    	listColumnDefs.add(new ColumnDef("전부서", Psnl0300BM.ATTR_BFRDEPTCD, ColumnDef.TYPE_STRING , 110, true, false, true){
    		{

    		}
    	});
    	
    	/** column 전부서 : bfrDeptCd */
    	listColumnDefs.add(new ColumnDef("전부서", Psnl0300BM.ATTR_BFRDEPTNM, ColumnDef.TYPE_STRING , 110, true, true, true){
    		{

    		}
    	});
    	
    	
    	/** column 전사업 : bfrBusinCd */
    	listColumnDefs.add(new ColumnDef("전사업", Psnl0300BM.ATTR_BFRBUSINCD, ColumnDef.TYPE_STRING , 110, true, false, true){
    		{

    		}
    	});
    	
    	/** column 전사업 : bfrBusinCd */
    	listColumnDefs.add(new ColumnDef("전사업", Psnl0300BM.ATTR_BFRBUSINNM, ColumnDef.TYPE_STRING , 110, true, true, true){
    		{

    		}
    	});
    	
    	
    	/** column 전직종 : bfrTypOccuDivCd */
    	listColumnDefs.add(new ColumnDef("전직종", Psnl0300BM.ATTR_BFRTYPOCCUDIVCD, ColumnDef.TYPE_STRING , 110, true, false, true){
    		{

    		}
    	});
    	
    	/** column 전직종 : bfrTypOccuDivCd */
    	listColumnDefs.add(new ColumnDef("전직종", Psnl0300BM.ATTR_BFRTYPOCCUDIVNM, ColumnDef.TYPE_STRING , 110, true, true, true){
    		{

    		}
    	});
    	
    	
    	/** column 전직책 : bfrOdtyDivCd */
    	listColumnDefs.add(new ColumnDef("전직책", Psnl0300BM.ATTR_BFRODTYDIVCD, ColumnDef.TYPE_STRING , 100, true, false, true){
    		{

    		}
    	});
    	
    	/** column 전직책 : bfrOdtyDivCd */
    	listColumnDefs.add(new ColumnDef("전직책", Psnl0300BM.ATTR_BFRODTYDIVNM, ColumnDef.TYPE_STRING , 100, true, true, true){
    		{

    		}
    	});
    	
    	
    	
    	/** column 전호봉 : bfrPyspCd */
    	listColumnDefs.add(new ColumnDef("전호봉", Psnl0300BM.ATTR_BFRPYSPCD, ColumnDef.TYPE_STRING , 100, true, false, true){
    		{

    		}
    	});
    	
    	/** column 전호봉 : bfrPyspCd */
    	listColumnDefs.add(new ColumnDef("전호봉", Psnl0300BM.ATTR_BFRPYSPNM, ColumnDef.TYPE_STRING , 100, true, true, true){
    		{

    		}
    	});
    	
    	
    	/** column 후부서 : aftDeptNm */
    	listColumnDefs.add(new ColumnDef("후부서", Psnl0300BM.ATTR_AFTDEPTCD, ColumnDef.TYPE_STRING , 100, true, false, true){
    		{

    		}
    	});
    	
    	/** column 후부서 : aftDeptNm */
    	listColumnDefs.add(new ColumnDef("후부서", Psnl0300BM.ATTR_AFTDEPTNM, ColumnDef.TYPE_STRING , 100, true, true, true){
    		{

    		}
    	});
    	
    	/** column 후사업 : aftBusinNm */
    	listColumnDefs.add(new ColumnDef("후사업", Psnl0300BM.ATTR_AFTBUSINCD, ColumnDef.TYPE_STRING , 100, true, false, true){
    		{

    		}
    	});
    	
    	
    	/** column 후사업 : aftBusinNm */
    	listColumnDefs.add(new ColumnDef("후사업", Psnl0300BM.ATTR_AFTBUSINNM, ColumnDef.TYPE_STRING , 100, true, true, true){
    		{

    		}
    	});
    	
    	/** column 후직종 : aftTypOccuDivCd */
    	listColumnDefs.add(new ColumnDef("후직종", Psnl0300BM.ATTR_AFTTYPOCCUDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	
    	/** column 후직종 : aftTypOccuDivNm */
    	listColumnDefs.add(new ColumnDef("후직종", Psnl0300BM.ATTR_AFTTYPOCCUDIVNM, ColumnDef.TYPE_STRING , 90, true, true, true){
    		{

    		}
    	});
    	
        /** column 후직종세통합코드 : aftDtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("후직종세", Psnl0310BM.ATTR_AFTDTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        
    	
    	/** column 후직책 : aftOdtyDivNm */
    	listColumnDefs.add(new ColumnDef("후직책", Psnl0300BM.ATTR_AFTODTYDIVCD, ColumnDef.TYPE_STRING , 100, true, false, true){
    		{

    		}
    	});
    	
    	/** column 후직책 : aftOdtyDivNm */
    	listColumnDefs.add(new ColumnDef("후직책", Psnl0300BM.ATTR_AFTODTYDIVNM, ColumnDef.TYPE_STRING , 100, true, true, true){
    		{

    		}
    	});
    	
    	/** column 후호봉 : aftPyspNm */
    	listColumnDefs.add(new ColumnDef("후호봉", Psnl0300BM.ATTR_AFTPYSPCD, ColumnDef.TYPE_STRING , 100, true, false, true){
    		{

    		}
    	});
    	
    	/** column 후호봉 : aftPyspNm */
    	listColumnDefs.add(new ColumnDef("후호봉", Psnl0300BM.ATTR_AFTPYSPNM, ColumnDef.TYPE_STRING , 100, true, true, true){
    		{

    		}
    	});
        
    	/** column 발령근거내용 : appmtBssCtnt */
    	listColumnDefs.add(new ColumnDef("발령근거사유", Psnl0300BM.ATTR_APPMTBSSCTNT, ColumnDef.TYPE_STRING , 150, true, true, true){
    		{

    		}
    	});
    	
    	/** column 발령기관 : appmtIstut */
    	listColumnDefs.add(new ColumnDef("발령기관", Psnl0300BM.ATTR_APPMTISTUT, ColumnDef.TYPE_STRING , 100, true, true, true){
    		{

    		}
    	});
        
        
        
    	  
    	/** column 사업장코드 : dpobCd */
    	listColumnDefs.add(new ColumnDef("사업장코드", Psnl0300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column SYSTEMKEY : systemkey */
    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0300BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 발령번호 : appmtNum */
    	listColumnDefs.add(new ColumnDef("발령번호", Psnl0300BM.ATTR_APPMTNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});

    	/** column 시작일자 : bgnnDt */
    	listColumnDefs.add(new ColumnDef("시작일자", Psnl0300BM.ATTR_BGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 종료일자 : endDt */
    	listColumnDefs.add(new ColumnDef("종료일자", Psnl0300BM.ATTR_ENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnDef("부서코드", Psnl0300BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 사업코드 : businCd */
    	listColumnDefs.add(new ColumnDef("사업코드", Psnl0300BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 직종코드 : typOccuCd */
    	listColumnDefs.add(new ColumnDef("직종코드", Psnl0300BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 직책코드 : odtyCd */
    	listColumnDefs.add(new ColumnDef("직책코드", Psnl0300BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 호봉코드 : pyspCd */
    	listColumnDefs.add(new ColumnDef("호봉코드", Psnl0300BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 호봉등급코드 : pyspGrdeCd */
    	listColumnDefs.add(new ColumnDef("호봉등급코드", Psnl0300BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
        /** column 재직상태코드 : hdofcCodtnCd */
        listColumnDefs.add(new ColumnDef("재직상태코드", Psnl0100BM.ATTR_HDOFCCODTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
    	/** column 근속년수코드 : logSvcYrNumCd */
    	listColumnDefs.add(new ColumnDef("근속년수코드", Psnl0300BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 징계구분코드 : dsnyActDivCd */
    	listColumnDefs.add(new ColumnDef("징계구분코드", Psnl0300BM.ATTR_DSNYACTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 감봉월수 : ctwpMnthNum */
    	listColumnDefs.add(new ColumnDef("감봉월수", Psnl0300BM.ATTR_CTWPMNTHNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
    		{

    		}
    	});
    	/** column 인사발령비고내용 : pernAppmtNoteCtnt */
    	listColumnDefs.add(new ColumnDef("인사발령비고내용", Psnl0300BM.ATTR_PERNAPPMTNOTECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력자 : kybdr */
    	listColumnDefs.add(new ColumnDef("입력자", Psnl0300BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력일자 : inptDt */
    	listColumnDefs.add(new ColumnDef("입력일자", Psnl0300BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력주소 : inptAddr */
    	listColumnDefs.add(new ColumnDef("입력주소", Psnl0300BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정자 : ismt */
    	listColumnDefs.add(new ColumnDef("수정자", Psnl0300BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정일자 : revnDt */
    	listColumnDefs.add(new ColumnDef("수정일자", Psnl0300BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정주소 : revnAddr */
    	listColumnDefs.add(new ColumnDef("수정주소", Psnl0300BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 발령일련번호 : appmtSeilNum */
    	listColumnDefs.add(new ColumnDef("발령일련번호", Psnl0300BM.ATTR_APPMTSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
    		{

    		}
    	});
        
    	/** column 상태 : appmtFixYn */
    	listColumnDefs.add(new ColumnDef("상태", Psnl0300BM.ATTR_APPMTFIXYN, ColumnDef.TYPE_STRING , 60, false, false, false){
    		{

    		}
    	});
    	
      /** column 고용구분코드 : emymtDivCd */
      listColumnDefs.add(new ColumnDef("고용구분", Psnl0100BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 120, false, false, false){
      	{

      	}
      });
    	
        return listColumnDefs;
         
    }
    
    
    
    private List<ColumnDef> getPsnl0300ColumnsList02(){ 
    	
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        
     	/** column 발령구분코드 : appmtDivCd */
    	listColumnDefs.add(new ColumnDef("발령구분", Psnl0300BM.ATTR_APPMTDIVCDNM, ColumnDef.TYPE_STRING , 70, false, true, true){
    		{

    		}
    	});
    	
		/** column 고용구분코드 : emymtDivCd */
		listColumnDefs.add(new ColumnDef("고용구분", Psnl0110BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{

			}
		});
		
		/** column 고용구분코드 : emymtDivCd */
		listColumnDefs.add(new ColumnDef("고용구분", Psnl0110BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 80, false, false, false){
			{

			}
		});
        
     	/** column 성명 : hanNm */
    	listColumnDefs.add(new ColumnDef("성명", Psnl0300BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 60, false, true, true){
    		{

    		}
    	});
    	
    	/** column 주민번호 : resnRegnNum */
    	listColumnDefs.add(new ColumnDef("주민번호", Psnl0300BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 80, false, true, true){
    		{
    			setTextFdMask("999999-9999999");
    		}
    	});
    	
    	/** column 상태 : resnRegnNum */
    	listColumnDefs.add(new ColumnDef("상태", Psnl0300BM.ATTR_APPMTFIXYNNM, ColumnDef.TYPE_STRING , 60, false, true, true){
    		{

    		}
    	});
    	
    	/** column 전부서 : bfrDeptCd */
    	listColumnDefs.add(new ColumnDef("전부서", Psnl0300BM.ATTR_BFRDEPTNM, ColumnDef.TYPE_STRING , 110, false, true, true){
    		{

    		}
    	});
    	
    	
    	/** column 전사업 : bfrBusinCd */
    	listColumnDefs.add(new ColumnDef("전사업", Psnl0300BM.ATTR_BFRBUSINNM, ColumnDef.TYPE_STRING , 110, false, true, true){
    		{

    		}
    	});
    	
    	/** column 전직종 : bfrTypOccuDivCd */
    	listColumnDefs.add(new ColumnDef("전직종", Psnl0300BM.ATTR_BFRTYPOCCUDIVNM, ColumnDef.TYPE_STRING , 110, false, true, true){
    		{

    		}
    	});
    	
    	/** column 전직종 : bfrTypOccuDivCd */
    	listColumnDefs.add(new ColumnDef("전직종", Psnl0300BM.ATTR_BFRTYPOCCUDIVCD, ColumnDef.TYPE_STRING , 110, false, false, false){
    		{

    		}
    	});
    	
   	 	/** column 전직종세통합코드 : bfrDtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("전직종세", Psnl0310BM.ATTR_BFRDTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 90, false, true, true){
        	{

        	}
        });
    	
        /** column 전직종세통합코드 : bfrDtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("전직종세통합코드", Psnl0310BM.ATTR_BFRDTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
    	
    	
    	/** column 전직책 : bfrOdtyDivCd */
    	listColumnDefs.add(new ColumnDef("전직책", Psnl0300BM.ATTR_BFRODTYDIVNM, ColumnDef.TYPE_STRING , 100, false, true, true){
    		{

    		}
    	});
    	
    	/** column 전호봉 : bfrPyspCd */
    	listColumnDefs.add(new ColumnDef("전호봉", Psnl0300BM.ATTR_BFRPYSPNM, ColumnDef.TYPE_STRING , 100, false, true, true){
    		{

    		}
    	});
    	
    	
    	/** column 후부서 : aftDeptNm */
    	listColumnDefs.add(new ColumnDef("후부서", Psnl0300BM.ATTR_AFTDEPTNM, ColumnDef.TYPE_STRING , 100, false, true, true){
    		{

    		}
    	});
    	
    	
    	/** column 후사업 : aftBusinNm */
    	listColumnDefs.add(new ColumnDef("후사업", Psnl0300BM.ATTR_AFTBUSINNM, ColumnDef.TYPE_STRING , 100, false, true, true){
    		{

    		}
    	});
    	
    	
    	/** column 후직종 : aftTypOccuDivNm */
    	listColumnDefs.add(new ColumnDef("후직종", Psnl0300BM.ATTR_AFTTYPOCCUDIVNM, ColumnDef.TYPE_STRING , 90, false, true, true){
    		{

    		}
    	});
    	
        /** column 후직종세통합코드 : aftDtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("후직종세", Psnl0310BM.ATTR_AFTDTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 후직종세통합코드 : aftDtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("후직종세통합코드", Psnl0310BM.ATTR_AFTDTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
    	
    	/** column 후직책 : aftOdtyDivNm */
    	listColumnDefs.add(new ColumnDef("후직책", Psnl0300BM.ATTR_AFTODTYDIVNM, ColumnDef.TYPE_STRING , 100, false, true, true){
    		{

    		}
    	});
    	
    	
    	
    	/** column 후호봉 : aftPyspNm */
    	listColumnDefs.add(new ColumnDef("후호봉", Psnl0300BM.ATTR_AFTPYSPNM, ColumnDef.TYPE_STRING , 100, false, true, true){
    		{

    		}
    	});
    	
    	
    	/** column 발령근거내용 : appmtBssCtnt */
    	listColumnDefs.add(new ColumnDef("발령근거사유", Psnl0300BM.ATTR_APPMTBSSCTNT, ColumnDef.TYPE_STRING , 150, false, true, true){
    		{

    		}
    	});
    	
    	/** column 발령기관 : appmtIstut */
    	listColumnDefs.add(new ColumnDef("발령기관", Psnl0300BM.ATTR_APPMTISTUT, ColumnDef.TYPE_STRING , 100, false, true, true){
    		{

    		}
    	});
        

    	
        // -- 
        
    	/** column 발령구분코드 : appmtDivCd */
    	listColumnDefs.add(new ColumnDef("발령구분코드", Psnl0300BM.ATTR_APPMTDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{

    		}
    	});
    	
   
    	
    	/** column 발령일자 : appmtDt */
    	listColumnDefs.add(new ColumnDef("발령일자", Psnl0300BM.ATTR_APPMTDT, ColumnDef.TYPE_STRING , 80, true, true, true){
    		{

    		}
    	});
    	
   

    	

    	/** column 전부서 : bfrDeptCd */
    	listColumnDefs.add(new ColumnDef("전부서", Psnl0300BM.ATTR_BFRDEPTCD, ColumnDef.TYPE_STRING , 110, true, false, true){
    		{

    		}
    	});
    	

    	
    	/** column 전사업 : bfrBusinCd */
    	listColumnDefs.add(new ColumnDef("전사업", Psnl0300BM.ATTR_BFRBUSINCD, ColumnDef.TYPE_STRING , 110, true, false, true){
    		{

    		}
    	});
    	

    	
    	/** column 전직종 : bfrTypOccuDivCd */
    	listColumnDefs.add(new ColumnDef("전직종", Psnl0300BM.ATTR_BFRTYPOCCUDIVCD, ColumnDef.TYPE_STRING , 110, true, false, true){
    		{

    		}
    	});
    	

    	
    	/** column 전직책 : bfrOdtyDivCd */
    	listColumnDefs.add(new ColumnDef("전직책", Psnl0300BM.ATTR_BFRODTYDIVCD, ColumnDef.TYPE_STRING , 100, true, false, true){
    		{

    		}
    	});
    	

    	
    	
    	/** column 전호봉 : bfrPyspCd */
    	listColumnDefs.add(new ColumnDef("전호봉", Psnl0300BM.ATTR_BFRPYSPCD, ColumnDef.TYPE_STRING , 100, true, false, true){
    		{

    		}
    	});
    	

    	
    	/** column 후부서 : aftDeptNm */
    	listColumnDefs.add(new ColumnDef("후부서", Psnl0300BM.ATTR_AFTDEPTCD, ColumnDef.TYPE_STRING , 100, true, false, true){
    		{

    		}
    	});
    	

    	/** column 후사업 : aftBusinNm */
    	listColumnDefs.add(new ColumnDef("후사업", Psnl0300BM.ATTR_AFTBUSINCD, ColumnDef.TYPE_STRING , 100, true, false, true){
    		{

    		}
    	});
    	
    	

    	/** column 후직종 : aftTypOccuDivNm */
    	listColumnDefs.add(new ColumnDef("후직종", Psnl0300BM.ATTR_AFTTYPOCCUDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	

    	/** column 후직책 : aftOdtyDivNm */
    	listColumnDefs.add(new ColumnDef("후직책", Psnl0300BM.ATTR_AFTODTYDIVCD, ColumnDef.TYPE_STRING , 100, true, false, true){
    		{

    		}
    	});
    	

    	
    	/** column 후호봉 : aftPyspNm */
    	listColumnDefs.add(new ColumnDef("후호봉", Psnl0300BM.ATTR_AFTPYSPCD, ColumnDef.TYPE_STRING , 100, true, false, true){
    		{

    		}
    	});
    	

    	  
    	/** column 사업장코드 : dpobCd */
    	listColumnDefs.add(new ColumnDef("사업장코드", Psnl0300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column SYSTEMKEY : systemkey */
    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0300BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 발령번호 : appmtNum */
    	listColumnDefs.add(new ColumnDef("발령번호", Psnl0300BM.ATTR_APPMTNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});

    	/** column 시작일자 : bgnnDt */
    	listColumnDefs.add(new ColumnDef("시작일자", Psnl0300BM.ATTR_BGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 종료일자 : endDt */
    	listColumnDefs.add(new ColumnDef("종료일자", Psnl0300BM.ATTR_ENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnDef("부서코드", Psnl0300BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 사업코드 : businCd */
    	listColumnDefs.add(new ColumnDef("사업코드", Psnl0300BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 직종코드 : typOccuCd */
    	listColumnDefs.add(new ColumnDef("직종코드", Psnl0300BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 직책코드 : odtyCd */
    	listColumnDefs.add(new ColumnDef("직책코드", Psnl0300BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 호봉코드 : pyspCd */
    	listColumnDefs.add(new ColumnDef("호봉코드", Psnl0300BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 호봉등급코드 : pyspGrdeCd */
    	listColumnDefs.add(new ColumnDef("호봉등급코드", Psnl0300BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 근속년수코드 : logSvcYrNumCd */
    	listColumnDefs.add(new ColumnDef("근속년수코드", Psnl0300BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 징계구분코드 : dsnyActDivCd */
    	listColumnDefs.add(new ColumnDef("징계구분코드", Psnl0300BM.ATTR_DSNYACTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 감봉월수 : ctwpMnthNum */
    	listColumnDefs.add(new ColumnDef("감봉월수", Psnl0300BM.ATTR_CTWPMNTHNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
    		{

    		}
    	});
    	/** column 인사발령비고내용 : pernAppmtNoteCtnt */
    	listColumnDefs.add(new ColumnDef("인사발령비고내용", Psnl0300BM.ATTR_PERNAPPMTNOTECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력자 : kybdr */
    	listColumnDefs.add(new ColumnDef("입력자", Psnl0300BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력일자 : inptDt */
    	listColumnDefs.add(new ColumnDef("입력일자", Psnl0300BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력주소 : inptAddr */
    	listColumnDefs.add(new ColumnDef("입력주소", Psnl0300BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정자 : ismt */
    	listColumnDefs.add(new ColumnDef("수정자", Psnl0300BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정일자 : revnDt */
    	listColumnDefs.add(new ColumnDef("수정일자", Psnl0300BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정주소 : revnAddr */
    	listColumnDefs.add(new ColumnDef("수정주소", Psnl0300BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 발령일련번호 : appmtSeilNum */
    	listColumnDefs.add(new ColumnDef("발령일련번호", Psnl0300BM.ATTR_APPMTSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
    		{

    		}
    	});
        
    	/** column 상태 : appmtFixYn */
    	listColumnDefs.add(new ColumnDef("상태", Psnl0300BM.ATTR_APPMTFIXYN, ColumnDef.TYPE_STRING , 60, false, false, false){
    		{

    		}
    	});
    	
        return listColumnDefs;
         
    }
    
}