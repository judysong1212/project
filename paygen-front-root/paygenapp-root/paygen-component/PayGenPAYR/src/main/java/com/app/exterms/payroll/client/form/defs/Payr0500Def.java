/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0500BM;
import com.app.exterms.payroll.client.dto.Psnl0111BM;
import com.app.exterms.payroll.client.dto.Psnl0127BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0100BM;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.smrmf.core.msfmainapp.client.def.AttributeCustomForm;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0500Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    
    private PrgmComBass0300DTO sysComBass0300Dto ;
    
    public Payr0500Def(String chkPayrDef){
    
    	sysComBass0300Dto = new PrgmComBass0300DTO();
    	
       
	      if ("PAYRP410004".equals(chkPayrDef)) {  
	    	  setTitle(""); 
	         setDaoClass(CLASS_PAYRP410004TOPAYR0500_DATA_LIST);
	         setCustomListMethod(CLASS_PAYRP410004TOPAYR0500_DATA_LIST);
	         setAutoFillGrid(false);
	         setShowFilterToolbar(false);  
	         setCheckBoxOnGridRows(true);  
			 setEditFieldGrid(true);
	         //setEditableGrid(true);
	
	         setColumnsDefinition(getPayrP410004ToPayr0500ColumnsList());
	         
	     } else {
	    	 setTitle(PayrLabel.titlePayr0500());
	         setDaoClass(CLASS_PAYR0500_DATA_LIST);
	         setCustomListMethod(CLASS_PAYR0500_DATA_LIST);
	         setAutoFillGrid(false);
	         setShowFilterToolbar(false);
	        // setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
	         setCheckBoxOnGridRows(false);
	         
	         setColumnsDefinition(getPayr0500ColumnsList());
	         
	     }
    } 
    
    private List<ColumnDef> getPayrP410004ToPayr0500ColumnsList(){     
  	  
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0500BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{
        		  setReadOnly(true);
        	}
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0500BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{
        		  setReadOnly(true);
        	}
        });
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Payr0500BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{
        		  setReadOnly(true);
        	}
        });

        /** column 고용구분 : emymtDivNm */
        listColumnDefs.add(new ColumnDef("고용구분", Payr0500BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 120, false, true, false){
        	{
        		  setReadOnly(true);
        	}
        });

        /** CURR_AFFN_DEPT_CD */
        listColumnDefs.add(new ColumnDef("부서", PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 100,100));
                setReadOnly(true);
            }
        });
        /** CURR_AFFN_DEPT_NM */
        listColumnDefs.add(new ColumnDef("부서", PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTNM,  ColumnDef.TYPE_STRING, 200, false, true, false){
            {
            	  setReadOnly(true);
            }
        });
        
        /** HAN_NM */
        listColumnDefs.add(new ColumnDef("성명", PrgmComPsnl0100BM.ATTR_HANNM,  ColumnDef.TYPE_STRING, 80, false, true, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row));
                setReadOnly(true);
            }
        });
        
        /** RESN_REGN_NUM */
        listColumnDefs.add(new ColumnDef("주민등록번호", PrgmComPsnl0100BM.ATTR_RESNREGNNUM,  ColumnDef.TYPE_STRING, 80, false, true, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++));
                setReadOnly(true);
               // setFormatNumeric("######-#######");
            }
        });
        /** SEC_REGN_NUM */
        listColumnDefs.add(new ColumnDef("주민등록번호", PrgmComPsnl0100BM.ATTR_SECREGNNUM,  ColumnDef.TYPE_STRING, 0, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++));
                setReadOnly(true);
               // setFormatNumeric("######-#######");
            }
        });
        
        /** column 단위기관코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관코드", Payr0500BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{
        		  setReadOnly(true);
        	}
        });
      
        /** column 단위기관 : payrMangDeptNm */
        listColumnDefs.add(new ColumnDef("단위기관", Payr0500BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{
        		  setReadOnly(true);
        	}
        });
        
        /** column 근속기준일자 : logSvcStdDt */
        listColumnDefs.add(new ColumnDef("근속기준일자", Payr0500BM.ATTR_LOGSVCSTDDT, ColumnDef.TYPE_DATE, 90, false, false, false){
        	{

        	}
        });
        /** column 부녀자여부 : wmnYn */
        listColumnDefs.add(new ColumnDef("부녀자여부", Payr0500BM.ATTR_WMNYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 퇴직정산여부 : retryClutYn */
        listColumnDefs.add(new ColumnDef("퇴직정산여부", Payr0500BM.ATTR_RETRYCLUTYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 급여대상자여부 : payRcptYn */
        listColumnDefs.add(new ColumnDef("급여대상자여부", Payr0500BM.ATTR_PAYRCPTYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 배우자유무 : spueYn */
        listColumnDefs.add(new ColumnDef("배우자유무", Payr0500BM.ATTR_SPUEYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 건강보험적용여부 : hlthInsrApptnYn */
        listColumnDefs.add(new ColumnDef("건강보험적용여부", Payr0500BM.ATTR_HLTHINSRAPPTNYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 국민연금적용여부 : natPennApptnYn */
        listColumnDefs.add(new ColumnDef("국민연금적용여부", Payr0500BM.ATTR_NATPENNAPPTNYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 고용보험적용여부 : umytInsrApptnYn */
        listColumnDefs.add(new ColumnDef("고용보험적용여부", Payr0500BM.ATTR_UMYTINSRAPPTNYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 산재보험적용여부 : idtlAccdtInsurApptnYn */
        listColumnDefs.add(new ColumnDef("산재보험적용여부", Payr0500BM.ATTR_IDTLACCDTINSURAPPTNYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 부양가족수20_자녀 : suprtFamyNumTwenChDn */
        listColumnDefs.add(new ColumnDef("부양가족수20_자녀", Payr0500BM.ATTR_SUPRTFAMYNUMTWENCHDN, ColumnDef.TYPE_LONG, 90, false, false, false){
        	{

        	}
        });
        /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdnYn */
        listColumnDefs.add(new ColumnDef("부양가족수_3_이상자녀", Payr0500BM.ATTR_SUPRTFAMYNUMTREOVRCHDNYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 부양가족수_기타 : suprtFamyNumEtc */
        listColumnDefs.add(new ColumnDef("부양가족수_기타", Payr0500BM.ATTR_SUPRTFAMYNUMETC, ColumnDef.TYPE_LONG, 90, false, false, false){
        	{

        	}
        });
        /** column 자녀학비보조여부 : chdnSchlExpnAdmclYn */
        listColumnDefs.add(new ColumnDef("자녀학비보조여부", Payr0500BM.ATTR_CHDNSCHLEXPNADMCLYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 근속수당적용여부 : logSvcExtpyApptnYn */
        listColumnDefs.add(new ColumnDef("근속수당적용여부", Payr0500BM.ATTR_LOGSVCEXTPYAPPTNYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
  
        
        /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */ 
        sysComBass0300Dto.setRpsttvCd("B029");  
        listColumnDefs.add(new ColumnListDef("소득세율", Payr0500BM.ATTR_ADDINCMTXAPPTNRTOCD, ColumnDef.TYPE_STRING, 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

        	}
        }); 
        
        /** column 추가소득세적용비율 : addIncmTxApptnRtoNm */
        listColumnDefs.add(new ColumnDef("소득세율", Payr0500BM.ATTR_ADDINCMTXAPPTNRTONM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		  setReadOnly(true);
        	}
        });
        
        /** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
        listColumnDefs.add(new ColumnDef("소득세율년월", Payr0500BM.ATTR_ADDINCMTXAPPTNYRMNTH, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		 setMaxLength(7);   
            	 setTypeTextField(ColumnDef.TEXTFIELD);
            	 setTextFdMask("9999.99");
        	}
        });
        /** column 추가소득세적용여부 : addIncmTxApptnYn */
        listColumnDefs.add(new ColumnDef("적용여부", Payr0500BM.ATTR_ADDINCMTXAPPTNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		  setReadOnly(true);
        	}
        }); 
       
        
        /** TYP_OCCU_CD */
        listColumnDefs.add(new ColumnDef("직종", PrgmComPsnl0100BM.ATTR_TYPOCCUCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(2, row++, 10));
            }
        });
        /** TYP_OCCU_NM */
        listColumnDefs.add(new ColumnDef("직종", PrgmComPsnl0100BM.ATTR_TYPOCCUNM,  ColumnDef.TYPE_STRING, 100, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
                setReadOnly(true);
            }
        });

        
        /** set 호봉등급코드 : pyspGrdeCd */  
        listColumnDefs.add(new ColumnDef("호봉등급코드", PrgmComPsnl0100BM.ATTR_PYSPGRDECD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(2, row++, 10));
            }
        });

        /** set 직종세구분코드 : dtilOccuClsDivCd */ 
        listColumnDefs.add(new ColumnDef("직종세구분", PrgmComPsnl0100BM.ATTR_DTILOCCUCLSDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(2, row++, 10));
            }
        });
        
        
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", PrgmComPsnl0100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		{
		
		}
		});                                           
		         
		
		/** column 직종세 : dtilOccuClsDivNm */
		listColumnDefs.add(new ColumnDef("직종세", PrgmComPsnl0100BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
		{
		
		}
		});            
        
        /** BUSIN_CD */
        listColumnDefs.add(new ColumnDef("사업", PrgmComPsnl0100BM.ATTR_BUSINCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(2, row++, 10));
            }
        });
        /** BUSIN_NM */
        listColumnDefs.add(new ColumnDef("사업명", PrgmComPsnl0100BM.ATTR_BUSINNM,  ColumnDef.TYPE_STRING, 150, false, true, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
                setReadOnly(true);
            }
        }); 
        
        
        return listColumnDefs;
    }
      
  private List<ColumnDef> getPayr0500ColumnsList(){     
    	  
     
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           
        /** HAN_NM */
        listColumnDefs.add(new ColumnDef("성명", PrgmComPsnl0100BM.ATTR_HANNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row));
            }
        });
        
        /** RESN_REGN_NUM */
        listColumnDefs.add(new ColumnDef("주민등록번호", PrgmComPsnl0100BM.ATTR_RESNREGNNUM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++));
                //setFormatNumeric("######-#######");
            }
        });
        
        /** SEC_REGN_NUM */
        listColumnDefs.add(new ColumnDef("주민등록번호", PrgmComPsnl0100BM.ATTR_SECREGNNUM,  ColumnDef.TYPE_STRING, 0, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++));
                //setFormatNumeric("######-#######");
            }
        });
        
        /** CURR_AFFN_DEPT_CD */
        listColumnDefs.add(new ColumnDef("부서", PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 100,100));
            }
        });
        /** CURR_AFFN_DEPT_NM */
        listColumnDefs.add(new ColumnDef("부서", PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                
            }
        });
        
//        /** EMYMT_DIV_CD */
//        listColumnDefs.add(new ColumnDef("고용구분", PrgmComPsnl0100BM.ATTR_EMYMTDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
//            {
//                setAttributeCustomForm(new AttributeCustomForm(0, row, 100));
//            }
//        });
//        /** EMYMT_DIV_NM */
//        listColumnDefs.add(new ColumnDef("고용구분", PrgmComPsnl0100BM.ATTR_EMYMTDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
//            {
//                setAttributeCustomForm(new AttributeCustomForm(0, row, 10));
//            }
//        });
        
        /** set 호봉등급코드 : pyspGrdeCd */  
        listColumnDefs.add(new ColumnDef("호봉등급코드", PrgmComPsnl0100BM.ATTR_PYSPGRDECD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(2, row++, 10));
            }
        });

        /** set 직종세구분코드 : dtilOccuClsDivCd */ 
        listColumnDefs.add(new ColumnDef("직종세구분", PrgmComPsnl0100BM.ATTR_DTILOCCUCLSDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(2, row++, 10));
            }
        });
        
        
        
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", PrgmComPsnl0100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		{
		
		}
		});                                           
		         
		
		/** column 직종세 : dtilOccuClsDivNm */
		listColumnDefs.add(new ColumnDef("직종세", PrgmComPsnl0100BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
		{
		
		}
		});            
        
        /** TYP_OCCU_CD */
        listColumnDefs.add(new ColumnDef("직종", PrgmComPsnl0100BM.ATTR_TYPOCCUCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(2, row++, 10));
            }
        });
        /** TYP_OCCU_NM */
        listColumnDefs.add(new ColumnDef("직종", PrgmComPsnl0100BM.ATTR_TYPOCCUNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });

        /** BUSIN_CD */
        listColumnDefs.add(new ColumnDef("사업", PrgmComPsnl0100BM.ATTR_BUSINCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(2, row++, 10));
            }
        });
        /** BUSIN_NM */
        listColumnDefs.add(new ColumnDef("사업명", PrgmComPsnl0100BM.ATTR_BUSINNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        }); 
       
        
        /** ODTY_CD */
        listColumnDefs.add(new ColumnDef("직책", PrgmComPsnl0100BM.ATTR_ODTYCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(3, row++, 10));
            }
        });
        /** ODTY_NM */
        listColumnDefs.add(new ColumnDef("직책명", PrgmComPsnl0100BM.ATTR_ODTYNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** HDOFC_CODTN_CD */
        listColumnDefs.add(new ColumnDef("재직상태", PrgmComPsnl0100BM.ATTR_HDOFCCODTNCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(3, row++, 10));
            }
        });
        
        /** HDOFC_CODTN_NM */
        listColumnDefs.add(new ColumnDef("재직상태", PrgmComPsnl0100BM.ATTR_HDOFCCODTNNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        
        

        /** LOG_SVC_YR_NUM_CD */
        listColumnDefs.add(new ColumnDef("근속년수코드", PrgmComPsnl0100BM.ATTR_LOGSVCYRNUMCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** LOG_SVC_YR_NUM_NM */
        listColumnDefs.add(new ColumnDef("근속년수", PrgmComPsnl0100BM.ATTR_LOGSVCYRNUMNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** LOG_SVC_MNTH_ICM_CD */
        listColumnDefs.add(new ColumnDef("근속월수코드", PrgmComPsnl0100BM.ATTR_LOGSVCMNTHICMCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** LOG_SVC_MNTH_ICM_NM */
        listColumnDefs.add(new ColumnDef("근속월수", PrgmComPsnl0100BM.ATTR_LOGSVCMNTHICMNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        }); 
        
     
         
        /** SX_DIV_CD */
        listColumnDefs.add(new ColumnDef("성별코드", PrgmComPsnl0100BM.ATTR_SXDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** SX_DIV_NM */
        listColumnDefs.add(new ColumnDef("성별", PrgmComPsnl0100BM.ATTR_SXDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** YOOBH_MNTH_DAY */
        listColumnDefs.add(new ColumnDef("생년월일", PrgmComPsnl0100BM.ATTR_YOOBHMNTHDAY,  ColumnDef.TYPE_DATE, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
       
        
        /** NATN_CD */
        listColumnDefs.add(new ColumnDef("국가코드", PrgmComPsnl0100BM.ATTR_NATNCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** NATN_Nm */
        listColumnDefs.add(new ColumnDef("국가", PrgmComPsnl0100BM.ATTR_NATNNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
         
     
        /** FRST_EMYMT_DT */
        listColumnDefs.add(new ColumnDef("최초고용일", PrgmComPsnl0100BM.ATTR_FRSTEMYMTDT,  ColumnDef.TYPE_DATE, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        }); 
        /** EMYMT_BGNN_DT */
        listColumnDefs.add(new ColumnDef("고용시작일", PrgmComPsnl0100BM.ATTR_EMYMTBGNNDT,  ColumnDef.TYPE_DATE, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** EMYMT_END_DT */
        listColumnDefs.add(new ColumnDef("고용종료일", PrgmComPsnl0100BM.ATTR_EMYMTENDDT,  ColumnDef.TYPE_DATE, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** PYSP_CD */
        listColumnDefs.add(new ColumnDef("호봉코드", PrgmComPsnl0100BM.ATTR_PYSPCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** PYSP_NM */
        listColumnDefs.add(new ColumnDef("호봉", PrgmComPsnl0100BM.ATTR_PYSPNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        
        /** RETRY_DT */
        listColumnDefs.add(new ColumnDef("퇴직일자", PrgmComPsnl0100BM.ATTR_RETRYDT,  ColumnDef.TYPE_DATE, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** RETRY_REAS_CTNT */
        listColumnDefs.add(new ColumnDef("퇴직사유", PrgmComPsnl0100BM.ATTR_RETRYREASCTNT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** FRGNR_DIV_CD */
        listColumnDefs.add(new ColumnDef("외국인구분코드", PrgmComPsnl0100BM.ATTR_FRGNRDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0500BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{

        	}
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0500BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{

        	}
        });
       
        
        /**  column 노조가입여부 : unnMbspSttYn */
        listColumnDefs.add(new ColumnDef("노조가입여부", Payr0500BM.ATTR_UNNMBSPSTTYN, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{

        	}
        });
        
        /** column 단위기관코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관코드", Payr0500BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{

        	}
        });
      
        /** column 단위기관 : payrMangDeptNm */
        listColumnDefs.add(new ColumnDef("단위기관", Payr0500BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Payr0500BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{

        	}
        });

        /** column 고용구분 : emymtDivNm */
        listColumnDefs.add(new ColumnDef("고용구분", Payr0500BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{

        	}
        });
        /** column 근속기준일자 : logSvcStdDt */
        listColumnDefs.add(new ColumnDef("근속기준일자", Payr0500BM.ATTR_LOGSVCSTDDT, ColumnDef.TYPE_DATE, 90, false, false, false){
        	{

        	}
        });
        /** column 부녀자여부 : wmnYn */
        listColumnDefs.add(new ColumnDef("부녀자여부", Payr0500BM.ATTR_WMNYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 퇴직정산여부 : retryClutYn */
        listColumnDefs.add(new ColumnDef("퇴직정산여부", Payr0500BM.ATTR_RETRYCLUTYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 급여대상자여부 : payRcptYn */
        listColumnDefs.add(new ColumnDef("급여대상자여부", Payr0500BM.ATTR_PAYRCPTYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 배우자유무 : spueYn */
        listColumnDefs.add(new ColumnDef("배우자유무", Payr0500BM.ATTR_SPUEYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 건강보험적용여부 : hlthInsrApptnYn */
        listColumnDefs.add(new ColumnDef("건강보험적용여부", Payr0500BM.ATTR_HLTHINSRAPPTNYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 국민연금적용여부 : natPennApptnYn */
        listColumnDefs.add(new ColumnDef("국민연금적용여부", Payr0500BM.ATTR_NATPENNAPPTNYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 고용보험적용여부 : umytInsrApptnYn */
        listColumnDefs.add(new ColumnDef("고용보험적용여부", Payr0500BM.ATTR_UMYTINSRAPPTNYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 산재보험적용여부 : idtlAccdtInsurApptnYn */
        listColumnDefs.add(new ColumnDef("산재보험적용여부", Payr0500BM.ATTR_IDTLACCDTINSURAPPTNYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 부양가족수20_자녀 : suprtFamyNumTwenChDn */
        listColumnDefs.add(new ColumnDef("부양가족수20_자녀", Payr0500BM.ATTR_SUPRTFAMYNUMTWENCHDN, ColumnDef.TYPE_LONG, 90, false, false, false){
        	{

        	}
        });
        /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdnYn */
        listColumnDefs.add(new ColumnDef("부양가족수_3_이상자녀", Payr0500BM.ATTR_SUPRTFAMYNUMTREOVRCHDNYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 부양가족수_기타 : suprtFamyNumEtc */
        listColumnDefs.add(new ColumnDef("부양가족수_기타", Payr0500BM.ATTR_SUPRTFAMYNUMETC, ColumnDef.TYPE_LONG, 90, false, false, false){
        	{

        	}
        });
        /** column 자녀학비보조여부 : chdnSchlExpnAdmclYn */
        listColumnDefs.add(new ColumnDef("자녀학비보조여부", Payr0500BM.ATTR_CHDNSCHLEXPNADMCLYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        /** column 근속수당적용여부 : logSvcExtpyApptnYn */
        listColumnDefs.add(new ColumnDef("근속수당적용여부", Payr0500BM.ATTR_LOGSVCEXTPYAPPTNYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
  
        /** column 호주성명 : hfmlyNm */
        listColumnDefs.add(new ColumnDef("호주성명", Psnl0111BM.ATTR_HFMLYNM, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 호주와의관계코드 : hfmlyRelaCd */
        listColumnDefs.add(new ColumnDef("호주와의관계코드", Psnl0111BM.ATTR_HFMLYRELACD, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 호주와의관계 : hfmlyRelaNm */
        listColumnDefs.add(new ColumnDef("호주와의관계", Psnl0111BM.ATTR_HFMLYRELANM, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 출생지주소 : bthcAddr */
        listColumnDefs.add(new ColumnDef("출생지주소", Psnl0111BM.ATTR_BTHCADDR, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 집우편번호 : husZpcd */
        listColumnDefs.add(new ColumnDef("집우편번호", Psnl0111BM.ATTR_HUSZPCD, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 집기본주소 : husFndtnAddr */
        listColumnDefs.add(new ColumnDef("집기본주소", Psnl0111BM.ATTR_HUSFNDTNADDR, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 집상세주소 : husDtlPatrAddr */
        listColumnDefs.add(new ColumnDef("집상세주소", Psnl0111BM.ATTR_HUSDTLPATRADDR, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 집도로명우편번호 : husRoadNmZpcd */
        listColumnDefs.add(new ColumnDef("집도로명우편번호", Psnl0111BM.ATTR_HUSROADNMZPCD, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 집도로명기본주소 : husRoadNmFndtnAddr */
        listColumnDefs.add(new ColumnDef("집도로명기본주소", Psnl0111BM.ATTR_HUSROADNMFNDTNADDR, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 집도로명상세주소 : husRoadNmDtlPatrAddr */
        listColumnDefs.add(new ColumnDef("집도로명상세주소", Psnl0111BM.ATTR_HUSROADNMDTLPATRADDR, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 집전화번호 : husPhnNum */
        listColumnDefs.add(new ColumnDef("집전화번호", Psnl0111BM.ATTR_HUSPHNNUM, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 집도로명영문주소 : husRoadNmEngAddr */
        listColumnDefs.add(new ColumnDef("집도로명영문주소", Psnl0111BM.ATTR_HUSROADNMENGADDR, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 직장우편번호 : wkOfcZpcd */
        listColumnDefs.add(new ColumnDef("직장우편번호", Psnl0111BM.ATTR_WKOFCZPCD, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 직장기본주소 : wkOfcFndtnAddr */
        listColumnDefs.add(new ColumnDef("직장기본주소", Psnl0111BM.ATTR_WKOFCFNDTNADDR, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 직장상세주소 : wkOfcDtlPatrAddr */
        listColumnDefs.add(new ColumnDef("직장상세주소", Psnl0111BM.ATTR_WKOFCDTLPATRADDR, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 회사전화번호 : cmpyPhnNum */
        listColumnDefs.add(new ColumnDef("회사전화번호", Psnl0111BM.ATTR_CMPYPHNNUM, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 회사팩스번호 : cmpyFaxNum */
        listColumnDefs.add(new ColumnDef("회사팩스번호", Psnl0111BM.ATTR_CMPYFAXNUM, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 차량번호 : carNum */
        listColumnDefs.add(new ColumnDef("차량번호", Psnl0111BM.ATTR_CARNUM, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 차종 : carMdl */
        listColumnDefs.add(new ColumnDef("차종", Psnl0111BM.ATTR_CARMDL, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 핸드폰번호 : cellPhneNum */
        listColumnDefs.add(new ColumnDef("핸드폰번호", Psnl0111BM.ATTR_CELLPHNENUM, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 이메일주소 : emailAddr */
        listColumnDefs.add(new ColumnDef("이메일주소", Psnl0111BM.ATTR_EMAILADDR, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        
       
        /** column 사회보험년도 : soctyInsurYr */
        listColumnDefs.add(new ColumnDef("사회보험년도", Psnl0127BM.ATTR_SOCTYINSURYR, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 건강보험변동일자 : hlthInsurFlucDt */
        listColumnDefs.add(new ColumnDef("건강보험변동일자", Psnl0127BM.ATTR_HLTHINSURFLUCDT, ColumnDef.TYPE_DATE , 90, false, false, false){
        	{

        	}
        });
        /** column 건강보험보수총액 : hlthInsrPayTotAmnt */
        listColumnDefs.add(new ColumnDef("건강보험보수총액", Psnl0127BM.ATTR_HLTHINSRPAYTOTAMNT, ColumnDef.TYPE_LONG , 90, false, false, false){
        	{

        	}
        });
        /** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
        listColumnDefs.add(new ColumnDef("건강보험보수월액", Psnl0127BM.ATTR_HLTHINSRMNTHRUNTNAMNT, ColumnDef.TYPE_LONG , 90, false, false, false){
        	{

        	}
        });
        /** column 건강보험등급 : hlthInsrGrde */
        listColumnDefs.add(new ColumnDef("건강보험등급", Psnl0127BM.ATTR_HLTHINSRGRDE, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 건강보험증번호 : hlthInsrCertNum */
        listColumnDefs.add(new ColumnDef("건강보험증번호", Psnl0127BM.ATTR_HLTHINSRCERTNUM, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 국민연금변동일자 : natPennInsurFlucDt */
        listColumnDefs.add(new ColumnDef("국민연금변동일자", Psnl0127BM.ATTR_NATPENNINSURFLUCDT, ColumnDef.TYPE_DATE , 90, false, false, false){
        	{

        	}
        });
        /** column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
        listColumnDefs.add(new ColumnDef("국민연금기준소득월액", Psnl0127BM.ATTR_NATPENNSTDINCMMNTHAMNT, ColumnDef.TYPE_LONG , 90, false, false, false){
        	{

        	}
        });
        /** column 국민연금등급 : natPennGrde */
        listColumnDefs.add(new ColumnDef("국민연금등급", Psnl0127BM.ATTR_NATPENNGRDE, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 건강보험적용여부 : hlthInsrApptnYn */
        listColumnDefs.add(new ColumnDef("건강보험적용여부", Psnl0127BM.ATTR_HLTHINSRAPPTNYN, ColumnDef.TYPE_BOOLEAN , 90, false, false, false){
        	{

        	}
        });
        /** column 국민연금적용여부 : natPennApptnYn */
        listColumnDefs.add(new ColumnDef("국민연금적용여부", Psnl0127BM.ATTR_NATPENNAPPTNYN, ColumnDef.TYPE_BOOLEAN , 90, false, false, false){
        	{

        	}
        });
        /** column 고용보험적용여부 : umytInsrApptnYn */
        listColumnDefs.add(new ColumnDef("고용보험적용여부", Psnl0127BM.ATTR_UMYTINSRAPPTNYN, ColumnDef.TYPE_BOOLEAN , 90, false, false, false){
        	{

        	}
        });
        /** column 산재보험적용여부 : idtlAccdtInsurApptnYn */
        listColumnDefs.add(new ColumnDef("산재보험적용여부", Psnl0127BM.ATTR_IDTLACCDTINSURAPPTNYN, ColumnDef.TYPE_BOOLEAN , 90, false, false, false){
        	{

        	}
        });
        
        /** column 고용보험변동일자 : umytInsrFlucDt */
        listColumnDefs.add(new ColumnDef("고용보험변동일자", Psnl0127BM.ATTR_UMYTINSRFLUCDT, ColumnDef.TYPE_DATE , 90, false, false, false){
            {

            }
        });
        /** column 고용보험보수총액 : umytInsrPayTotAmnt */
        listColumnDefs.add(new ColumnDef("고용보험보수총액", Psnl0127BM.ATTR_UMYTINSRPAYTOTAMNT, ColumnDef.TYPE_LONG , 90, false, false, false){
            {

            }
        });
        /** column 고용보험보수월액 : umytInsrPayMnthAmnt */
        listColumnDefs.add(new ColumnDef("고용보험보수월액", Psnl0127BM.ATTR_UMYTINSRPAYMNTHAMNT, ColumnDef.TYPE_LONG , 90, false, false, false){
            {

            }
        });
        /** column 산재보험변동일자 : idtlAccdtFlucDt */
        listColumnDefs.add(new ColumnDef("산재보험변동일자", Psnl0127BM.ATTR_IDTLACCDTFLUCDT, ColumnDef.TYPE_DATE , 90, false, false, false){
            {

            }
        });
        /** column 산재보험보수총액 : idtlAccdtPayTotAmnt */
        listColumnDefs.add(new ColumnDef("산재보험보수총액", Psnl0127BM.ATTR_IDTLACCDTPAYTOTAMNT, ColumnDef.TYPE_LONG , 90, false, false, false){
            {

            }
        });
        /** column 산재보험보수월액 : idtlAccdtPayMnthAmnt */
        listColumnDefs.add(new ColumnDef("산재보험보수월액", Psnl0127BM.ATTR_IDTLACCDTPAYMNTHAMNT, ColumnDef.TYPE_LONG , 90, false, false, false){
            {

            }
        });
        
        /** column 월급여일당금액 : mnthPayDlywagSum */
        listColumnDefs.add(new ColumnDef("월급여일당금액", Payr0500BM.ATTR_MNTHPAYDLYWAGSUM, ColumnDef.TYPE_LONG , 90, false, false, false){
            {

            }
        });

        /** payrIncmExceYn  */
        listColumnDefs.add(new ColumnDef("소득세제외", Payr0500BM.ATTR_PAYRINCMEXCEYN ,  ColumnDef.TYPE_BOOLEAN, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        }); 
        
        /** dayWorkYn */
        listColumnDefs.add(new ColumnDef("일용직구분", Payr0500BM.ATTR_DAYWORKYN,  ColumnDef.TYPE_BOOLEAN, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        }); 
        
        /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
        listColumnDefs.add(new ColumnDef("소득세율코드", Payr0500BM.ATTR_ADDINCMTXAPPTNRTOCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 추가소득세적용비율 : addIncmTxApptnRtoNm */
        listColumnDefs.add(new ColumnDef("소득세율", Payr0500BM.ATTR_ADDINCMTXAPPTNRTONM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
        listColumnDefs.add(new ColumnDef("소득세율년월", Payr0500BM.ATTR_ADDINCMTXAPPTNYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 추가소득세적용여부 : addIncmTxApptnYn */
        listColumnDefs.add(new ColumnDef("적용여부", Payr0500BM.ATTR_ADDINCMTXAPPTNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 추가소득세적용비율코드 : befIncmTxApptnRtoCd */
        listColumnDefs.add(new ColumnDef("소득세율코드", Payr0500BM.ATTR_BEFINCMTXAPPTNRTOCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        
        /** column 추가소득세적용년월 : befIncmTxApptnYrMnth */
        listColumnDefs.add(new ColumnDef("소득세율년월", Payr0500BM.ATTR_BEFINCMTXAPPTNYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 추가소득세적용여부 : befIncmTxApptnYn */
        listColumnDefs.add(new ColumnDef("적용여부", Payr0500BM.ATTR_BEFINCMTXAPPTNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 현재년도적용갯수 : addfIncmTxApptnCnt */
        listColumnDefs.add(new ColumnDef("적용갯수", Payr0500BM.ATTR_ADDINCMTXAPPTNCNT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        
        
        return listColumnDefs;
    }
     
}
