/**
 * 공통화면 팝업 
 */
package com.app.exterms.prgm.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0100BM;
import com.app.exterms.prgm.client.languages.PrgmConstants;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.AttributeCustomForm;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class PrgmComPsnl0100Def  extends TableDef implements PrgmComDaoConstants {

    private int row = 0;
    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;

    final PrgmComBass0300DTO sysComBass0300Dto;
    
    public PrgmComPsnl0100Def(){ 
    	
    	 sysComBass0300Dto = new PrgmComBass0300DTO(); 
    	 
        setTitle(SysComLabel.titleSysComPopUpPsnl0100());
        setDaoClass(CLASS_SYSCOM_PSNL0100VO); 
        setAutoFillGrid(false);
       // setFilterForm(false);
        setShowFilterToolbar(true);
        setFilterForm(true);  
        showFilterForm();  
        
        setColumnsDefinition(getMSFPsnl0100());
    }
    public PrgmComPsnl0100Def(String chkPsnl0100){ 
    	
    	 sysComBass0300Dto = new PrgmComBass0300DTO(); 
    	 
    	if ("PAYR1700".equals(chkPsnl0100)) {
	        setTitle(SysComLabel.titleSysComPopUpPsnl0100());
	        setDaoClass(""); 
	        setCustomListMethod(CLASS_PRGMCOM_PSNL0100_PAYR1700_DATALIST);
	        setAutoFillGrid(false); 
	        setShowFilterToolbar(false);
	         
	        setColumnsDefinition(getMSFPsnl0100ToPayr1700()); 
	        
    	}	else if ("PAYR4100".equals(chkPsnl0100)) {
	        setTitle(SysComLabel.titleSysComPopUpPsnl0100());
	        setDaoClass(""); 
	        setCustomListMethod(CLASS_PRGMCOM_PSNL0100_PAYR4100_DATALIST);
	        setAutoFillGrid(false); 
	        setShowFilterToolbar(false);
	         
	        setColumnsDefinition(getMSFPsnl0100ToPayr4100());
	        
    	}	else if ("PSNL0126".equals(chkPsnl0100)) {
	        setTitle(SysComLabel.titleSysComPopUpPsnl0100());
	        setDaoClass(""); 
	        setCustomListMethod(CLASS_PRGMCOM_PSNL0100_PSNL0126_DATALIST);
	        setAutoFillGrid(false); 
	        setShowFilterToolbar(false);
	         
	        setColumnsDefinition(getMSFPsnl0100ToPsnl0126());
	        
    	}	 
    }
     

    private List<ColumnDef> getMSFPsnl0100ToPayr4100() {
    	row = 0;
    	
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        
        /** HAN_NM */
        listColumnDefs.add(new ColumnDef("성명", PrgmComPsnl0100BM.ATTR_HANNM,  ColumnDef.TYPE_STRING, 50, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row));
            }
        });
        
        /** RESN_REGN_NUM */
        listColumnDefs.add(new ColumnDef("주민등록번호", PrgmComPsnl0100BM.ATTR_RESNREGNNUM,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++));
               // setFormatNumeric("######-#######");
            }
        });
        
        /** CURR_AFFN_DEPT_CD */
        listColumnDefs.add(new ColumnDef("부서", PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 100,100));
            }
        });
        /** CURR_AFFN_DEPT_NM */
        listColumnDefs.add(new ColumnDef("부서명", PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTNM,  ColumnDef.TYPE_STRING, 80, false, true, false){
            {
                
            }
        });
        
        /** EMYMT_DIV_CD */
        listColumnDefs.add(new ColumnDef("고용구분", PrgmComPsnl0100BM.ATTR_EMYMTDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row, 100));
            }
        });
        /** EMYMT_DIV_NM */
        listColumnDefs.add(new ColumnDef("고용구분", PrgmComPsnl0100BM.ATTR_EMYMTDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row, 10));
            }
        });
        
        /** TYP_OCCU_CD */
        listColumnDefs.add(new ColumnDef("직종", PrgmComPsnl0100BM.ATTR_TYPOCCUCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
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

        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", PrgmComPsnl0100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 80, true, false, true){
        	{

        	}
        });                                           
                                                   
                              
        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", PrgmComPsnl0100BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 80, true, true, true){
        	{

        	}
        });    
        /** BUSIN_CD */
        listColumnDefs.add(new ColumnDef("사업", PrgmComPsnl0100BM.ATTR_BUSINCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(2, row++, 10));
            }
        });
        /** BUSIN_NM */
        listColumnDefs.add(new ColumnDef("사업", PrgmComPsnl0100BM.ATTR_BUSINNM,  ColumnDef.TYPE_STRING, 80, false, true, true){
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
        listColumnDefs.add(new ColumnDef("직책", PrgmComPsnl0100BM.ATTR_ODTYNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
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
        listColumnDefs.add(new ColumnDef("재직상태", PrgmComPsnl0100BM.ATTR_HDOFCCODTNNM,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        
        listColumnDefs.add(new ColumnDef("사업장코드", PrgmComPsnl0100BM.ATTR_DPOBCD,  ColumnDef.TYPE_STRING, 100, false, false, false){
            {
                 
            }
        }); 
        
        /** DPOB_NM */
        listColumnDefs.add(new ColumnDef("사업장명", PrgmComPsnl0100BM.ATTR_DPOBNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row++, 10));
            }
        });
        /** SYSTEMKEY */
        listColumnDefs.add(new ColumnDef("시스템키", PrgmComPsnl0100BM.ATTR_SYSTEMKEY,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row++, 10));
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
        listColumnDefs.add(new ColumnDef("생년월일", PrgmComPsnl0100BM.ATTR_YOOBHMNTHDAY,  ColumnDef.TYPE_STRING, 80, false, false, false){
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
        listColumnDefs.add(new ColumnDef("국가명", PrgmComPsnl0100BM.ATTR_NATNNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
         
     
        /** FRST_EMYMT_DT */
        listColumnDefs.add(new ColumnDef("최초고용일자", PrgmComPsnl0100BM.ATTR_FRSTEMYMTDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        }); 
        /** EMYMT_BGNN_DT */
        listColumnDefs.add(new ColumnDef("고용시작일자", PrgmComPsnl0100BM.ATTR_EMYMTBGNNDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** EMYMT_END_DT */
        listColumnDefs.add(new ColumnDef("고용종료일자", PrgmComPsnl0100BM.ATTR_EMYMTENDDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
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
        listColumnDefs.add(new ColumnDef("퇴직일자", PrgmComPsnl0100BM.ATTR_RETRYDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
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
       
        
        return listColumnDefs;
    }
    
 
    
    private List<ColumnDef> getMSFPsnl0100() {
    	row = 0;
    	
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** HAN_NM */
        listColumnDefs.add(new ColumnDef("성명", PrgmComPsnl0100BM.ATTR_HANNM,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row));
            }
        });
        
        /** RESN_REGN_NUM */
        listColumnDefs.add(new ColumnDef("주민등록번호", PrgmComPsnl0100BM.ATTR_RESNREGNNUM,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++));
               // setFormatNumeric("######-#######");
            }
        });
        

        /** EMYMT_DIV_CD */
        listColumnDefs.add(new ColumnDef("고용구분", PrgmComPsnl0100BM.ATTR_EMYMTDIVCD,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row, 100));
            }
        });
        /** EMYMT_DIV_NM */
        listColumnDefs.add(new ColumnDef("고용구분명", PrgmComPsnl0100BM.ATTR_EMYMTDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row, 10));
            }
        });
        /** CURR_AFFN_DEPT_CD */
        listColumnDefs.add(new ColumnDef("부서", PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTCD,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 100,100));
            }
        });
        /** CURR_AFFN_DEPT_NM */
        listColumnDefs.add(new ColumnDef("소속부서명", PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                
            }
        });
        

        /** BUSIN_CD */
        listColumnDefs.add(new ColumnDef("사업", PrgmComPsnl0100BM.ATTR_BUSINCD,  ColumnDef.TYPE_STRING, 80, false, true, true){
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
        /** TYP_OCCU_CD */
        listColumnDefs.add(new ColumnDef("직종", PrgmComPsnl0100BM.ATTR_TYPOCCUCD,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(2, row++, 10));
            }
        });
        /** TYP_OCCU_NM */
        listColumnDefs.add(new ColumnDef("직종명", PrgmComPsnl0100BM.ATTR_TYPOCCUNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
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
        
        /** ODTY_CD */
        listColumnDefs.add(new ColumnDef("직책", PrgmComPsnl0100BM.ATTR_ODTYCD,  ColumnDef.TYPE_STRING, 80, false, true, true){
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
        listColumnDefs.add(new ColumnDef("재직상태", PrgmComPsnl0100BM.ATTR_HDOFCCODTNCD,  ColumnDef.TYPE_STRING, 80, false, true, true){
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
        
        listColumnDefs.add(new ColumnDef("사업장코드", PrgmComPsnl0100BM.ATTR_DPOBCD,  ColumnDef.TYPE_STRING, 100, false, false, false){
            {
                 
            }
        }); 
        
        /** DPOB_NM */
        listColumnDefs.add(new ColumnDef("사업장명", PrgmComPsnl0100BM.ATTR_DPOBNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row++, 10));
            }
        });
        /** SYSTEMKEY */
        listColumnDefs.add(new ColumnDef("시스템키", PrgmComPsnl0100BM.ATTR_SYSTEMKEY,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row++, 10));
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
         
        
       
        /** ENG_NM */
        listColumnDefs.add(new ColumnDef("영문성명", PrgmComPsnl0100BM.ATTR_ENGNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** CHIN_CHAR_NM */
        listColumnDefs.add(new ColumnDef("한문성명", PrgmComPsnl0100BM.ATTR_CHINCHARNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
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
        listColumnDefs.add(new ColumnDef("생년월일", PrgmComPsnl0100BM.ATTR_YOOBHMNTHDAY,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** SCLC_DIV_CD */
        listColumnDefs.add(new ColumnDef("음양구분코드", PrgmComPsnl0100BM.ATTR_SCLCDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
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
        listColumnDefs.add(new ColumnDef("국가명", PrgmComPsnl0100BM.ATTR_NATNNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** DEPT_CD */
        listColumnDefs.add(new ColumnDef("관리부서코드", PrgmComPsnl0100BM.ATTR_DEPTCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** DEPT_NM */
        listColumnDefs.add(new ColumnDef("관리부서명", PrgmComPsnl0100BM.ATTR_DEPTNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
       
        /** REPBTY_BUSIN_DIV_CD */
        listColumnDefs.add(new ColumnDef("담당업무구분코드", PrgmComPsnl0100BM.ATTR_REPBTYBUSINDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** REPBTY_BUSIN_DIV_NM */
        listColumnDefs.add(new ColumnDef("담당업무명", PrgmComPsnl0100BM.ATTR_REPBTYBUSINDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        }); 
     
        /** FRST_EMYMT_DT */
        listColumnDefs.add(new ColumnDef("최초고용일자", PrgmComPsnl0100BM.ATTR_FRSTEMYMTDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        }); 
        /** EMYMT_BGNN_DT */
        listColumnDefs.add(new ColumnDef("고용시작일자", PrgmComPsnl0100BM.ATTR_EMYMTBGNNDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** EMYMT_END_DT */
        listColumnDefs.add(new ColumnDef("고용종료일자", PrgmComPsnl0100BM.ATTR_EMYMTENDDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
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
        listColumnDefs.add(new ColumnDef("퇴직일자", PrgmComPsnl0100BM.ATTR_RETRYDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
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
        /** FRGNR_DIV_NM */
        listColumnDefs.add(new ColumnDef("외국인", PrgmComPsnl0100BM.ATTR_FRGNRDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** PSPT_NUM */
        listColumnDefs.add(new ColumnDef("여권번호", PrgmComPsnl0100BM.ATTR_PSPTNUM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** STY_BGNN_DT */
        listColumnDefs.add(new ColumnDef("체류시작일자", PrgmComPsnl0100BM.ATTR_STYBGNNDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
                
            }
        });
        /** STY_END_DT */
        listColumnDefs.add(new ColumnDef("체류종료일자", PrgmComPsnl0100BM.ATTR_STYENDDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** END_SCHL */
        listColumnDefs.add(new ColumnDef("최종학교", PrgmComPsnl0100BM.ATTR_ENDSCHL,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** END_DEGR_DIV_CD */
        listColumnDefs.add(new ColumnDef("최종학위구분코드", PrgmComPsnl0100BM.ATTR_ENDDEGRDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** END_DEGR_DIV_CD */
        listColumnDefs.add(new ColumnDef("최종학위명", PrgmComPsnl0100BM.ATTR_ENDDEGRDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** PMTN_SCDU_DT */
        listColumnDefs.add(new ColumnDef("승진예정일자", PrgmComPsnl0100BM.ATTR_PMTNSCDUDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** PYSP_PRMTN_SCDU_DT */
        listColumnDefs.add(new ColumnDef("호봉승급예정일자", PrgmComPsnl0100BM.ATTR_PYSPPRMTNSCDUDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** REYMN_SCDU_DT */
        listColumnDefs.add(new ColumnDef("재고용예정일자", PrgmComPsnl0100BM.ATTR_REYMNSCDUDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
      
        /** CURR_PYSP_APPMT_DT */
        listColumnDefs.add(new ColumnDef("현호봉발령일자", PrgmComPsnl0100BM.ATTR_CURRPYSPAPPMTDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** CURR_DEPT_APPMT_DT */
        listColumnDefs.add(new ColumnDef("현부서발령일자", PrgmComPsnl0100BM.ATTR_CURRDEPTAPPMTDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** PERN_NOTE_CTNT */
        listColumnDefs.add(new ColumnDef("비고", PrgmComPsnl0100BM.ATTR_PERNNOTECTNT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        
        return listColumnDefs;
    }
    
    private List<ColumnDef> getMSFPsnl0100ToPayr1700() {
    	row = 0;
    	
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        sysComBass0300Dto.setRpsttvCd("B002"); 
        /** EMYMT_DIV_CD */
        listColumnDefs.add(new ColumnListDef("고용구분", PrgmComPsnl0100BM.ATTR_EMYMTDIVCD,  ColumnDef.TYPE_STRING, 80, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row, 100));
            }
        });
//        /** EMYMT_DIV_NM */
//        listColumnDefs.add(new ColumnDef("고용구분", SysComPsnl0100BM.ATTR_EMYMTDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, true){
//            {
//                setAttributeCustomForm(new AttributeCustomForm(0, row, 10));
//            }
//        });
        
        /** CURR_AFFN_DEPT_CD */
        listColumnDefs.add(new ColumnDef("부서코드", PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 100,100));
            }
        });
        /** CURR_AFFN_DEPT_NM */
        listColumnDefs.add(new ColumnDef("부서", PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTNM,  ColumnDef.TYPE_STRING, 80, true, true, false){
            {
                
            }
        });
        
        /** HAN_NM */
        listColumnDefs.add(new ColumnDef("성명", PrgmComPsnl0100BM.ATTR_HANNM,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row));
            }
        });
        
        /** RESN_REGN_NUM */
        listColumnDefs.add(new ColumnDef("주민등록번호", PrgmComPsnl0100BM.ATTR_RESNREGNNUM,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++));
               // setFormatNumeric("######-#######");
            }
        });

        /** BUSIN_CD */
        listColumnDefs.add(new ColumnDef("사업", PrgmComPsnl0100BM.ATTR_BUSINCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(2, row++, 10));
            }
        });
       
        /** TYP_OCCU_CD */
        listColumnDefs.add(new ColumnDef("직종코드", PrgmComPsnl0100BM.ATTR_TYPOCCUCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(2, row++, 10));
            }
        });
        
        /** TYP_OCCU_NM */
        listColumnDefs.add(new ColumnDef("직종명", PrgmComPsnl0100BM.ATTR_TYPOCCUNM,  ColumnDef.TYPE_STRING, 80, true, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", PrgmComPsnl0100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 80, false, false, true){
        	{

        	}
        });                                           
                                                   
                              
        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", PrgmComPsnl0100BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 80, true, true, true){
        	{

        	}
        });    
        
        /** BUSIN_NM */
        listColumnDefs.add(new ColumnDef("사업명", PrgmComPsnl0100BM.ATTR_BUSINNM,  ColumnDef.TYPE_STRING, 80, true, true, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        }); 
      
       
        
        /** SYSTEMKEY */
        listColumnDefs.add(new ColumnDef("시스템키", PrgmComPsnl0100BM.ATTR_SYSTEMKEY,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row++, 10));
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
        
        listColumnDefs.add(new ColumnDef("사업장코드", PrgmComPsnl0100BM.ATTR_DPOBCD,  ColumnDef.TYPE_STRING, 100, false, false, false){
            {
                 
            }
        }); 
        
        /** DPOB_NM */
        listColumnDefs.add(new ColumnDef("사업장명", PrgmComPsnl0100BM.ATTR_DPOBNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row++, 10));
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
         
        
       
        /** ENG_NM */
        listColumnDefs.add(new ColumnDef("영문성명", PrgmComPsnl0100BM.ATTR_ENGNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** CHIN_CHAR_NM */
        listColumnDefs.add(new ColumnDef("한문성명", PrgmComPsnl0100BM.ATTR_CHINCHARNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
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
        listColumnDefs.add(new ColumnDef("생년월일", PrgmComPsnl0100BM.ATTR_YOOBHMNTHDAY,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** SCLC_DIV_CD */
        listColumnDefs.add(new ColumnDef("음양구분코드", PrgmComPsnl0100BM.ATTR_SCLCDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
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
        listColumnDefs.add(new ColumnDef("국가명", PrgmComPsnl0100BM.ATTR_NATNNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** DEPT_CD */
        listColumnDefs.add(new ColumnDef("관리부서코드", PrgmComPsnl0100BM.ATTR_DEPTCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** DEPT_NM */
        listColumnDefs.add(new ColumnDef("관리부서명", PrgmComPsnl0100BM.ATTR_DEPTNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
       
        /** REPBTY_BUSIN_DIV_CD */
        listColumnDefs.add(new ColumnDef("담당업무구분코드", PrgmComPsnl0100BM.ATTR_REPBTYBUSINDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** REPBTY_BUSIN_DIV_NM */
        listColumnDefs.add(new ColumnDef("담당업무명", PrgmComPsnl0100BM.ATTR_REPBTYBUSINDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        }); 
     
        /** FRST_EMYMT_DT */
        listColumnDefs.add(new ColumnDef("최초고용일자", PrgmComPsnl0100BM.ATTR_FRSTEMYMTDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        }); 
        /** EMYMT_BGNN_DT */
        listColumnDefs.add(new ColumnDef("고용시작일자", PrgmComPsnl0100BM.ATTR_EMYMTBGNNDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** EMYMT_END_DT */
        listColumnDefs.add(new ColumnDef("고용종료일자", PrgmComPsnl0100BM.ATTR_EMYMTENDDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
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
        listColumnDefs.add(new ColumnDef("퇴직일자", PrgmComPsnl0100BM.ATTR_RETRYDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
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
        /** FRGNR_DIV_NM */
        listColumnDefs.add(new ColumnDef("외국인", PrgmComPsnl0100BM.ATTR_FRGNRDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** PSPT_NUM */
        listColumnDefs.add(new ColumnDef("여권번호", PrgmComPsnl0100BM.ATTR_PSPTNUM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** STY_BGNN_DT */
        listColumnDefs.add(new ColumnDef("체류시작일자", PrgmComPsnl0100BM.ATTR_STYBGNNDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
                
            }
        });
        /** STY_END_DT */
        listColumnDefs.add(new ColumnDef("체류종료일자", PrgmComPsnl0100BM.ATTR_STYENDDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** END_SCHL */
        listColumnDefs.add(new ColumnDef("최종학교", PrgmComPsnl0100BM.ATTR_ENDSCHL,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** END_DEGR_DIV_CD */
        listColumnDefs.add(new ColumnDef("최종학위구분코드", PrgmComPsnl0100BM.ATTR_ENDDEGRDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** END_DEGR_DIV_CD */
        listColumnDefs.add(new ColumnDef("최종학위명", PrgmComPsnl0100BM.ATTR_ENDDEGRDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** PMTN_SCDU_DT */
        listColumnDefs.add(new ColumnDef("승진예정일자", PrgmComPsnl0100BM.ATTR_PMTNSCDUDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** PYSP_PRMTN_SCDU_DT */
        listColumnDefs.add(new ColumnDef("호봉승급예정일자", PrgmComPsnl0100BM.ATTR_PYSPPRMTNSCDUDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** REYMN_SCDU_DT */
        listColumnDefs.add(new ColumnDef("재고용예정일자", PrgmComPsnl0100BM.ATTR_REYMNSCDUDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
      
        /** CURR_PYSP_APPMT_DT */
        listColumnDefs.add(new ColumnDef("현호봉발령일자", PrgmComPsnl0100BM.ATTR_CURRPYSPAPPMTDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** CURR_DEPT_APPMT_DT */
        listColumnDefs.add(new ColumnDef("현부서발령일자", PrgmComPsnl0100BM.ATTR_CURRDEPTAPPMTDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** PERN_NOTE_CTNT */
        listColumnDefs.add(new ColumnDef("비고", PrgmComPsnl0100BM.ATTR_PERNNOTECTNT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        
         
      
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", PrgmComPsnl0100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
      
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분코드", PrgmComPsnl0100BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", PrgmComPsnl0100BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        
        return listColumnDefs;
    }
    
    private List<ColumnDef> getMSFPsnl0100ToPsnl0126() {
    	row = 0;
    	
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** HAN_NM */
        listColumnDefs.add(new ColumnDef("성명", PrgmComPsnl0100BM.ATTR_HANNM,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row));
            }
        });
        
        /** RESN_REGN_NUM */
        listColumnDefs.add(new ColumnDef("주민등록번호", PrgmComPsnl0100BM.ATTR_RESNREGNNUM,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++));
               // setFormatNumeric("######-#######");
            }
        });
        

        /** EMYMT_DIV_CD */
        listColumnDefs.add(new ColumnDef("고용구분", PrgmComPsnl0100BM.ATTR_EMYMTDIVCD,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row, 100));
            }
        });
        /** EMYMT_DIV_NM */
        listColumnDefs.add(new ColumnDef("고용구분명", PrgmComPsnl0100BM.ATTR_EMYMTDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row, 10));
            }
        });
        /** CURR_AFFN_DEPT_CD */
        listColumnDefs.add(new ColumnDef("부서", PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTCD,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 100,100));
            }
        });
        /** CURR_AFFN_DEPT_NM */
        listColumnDefs.add(new ColumnDef("소속부서명", PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                
            }
        });
        

        /** BUSIN_CD */
        listColumnDefs.add(new ColumnDef("사업", PrgmComPsnl0100BM.ATTR_BUSINCD,  ColumnDef.TYPE_STRING, 80, false, true, true){
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
        /** TYP_OCCU_CD */
        listColumnDefs.add(new ColumnDef("직종", PrgmComPsnl0100BM.ATTR_TYPOCCUCD,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(2, row++, 10));
            }
        });
        /** TYP_OCCU_NM */
        listColumnDefs.add(new ColumnDef("직종명", PrgmComPsnl0100BM.ATTR_TYPOCCUNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
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
        
        /** ODTY_CD */
        listColumnDefs.add(new ColumnDef("직책", PrgmComPsnl0100BM.ATTR_ODTYCD,  ColumnDef.TYPE_STRING, 80, false, true, true){
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
        listColumnDefs.add(new ColumnDef("재직상태", PrgmComPsnl0100BM.ATTR_HDOFCCODTNCD,  ColumnDef.TYPE_STRING, 80, false, true, true){
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
        
        listColumnDefs.add(new ColumnDef("사업장코드", PrgmComPsnl0100BM.ATTR_DPOBCD,  ColumnDef.TYPE_STRING, 100, false, false, false){
            {
                 
            }
        }); 
        
        /** DPOB_NM */
        listColumnDefs.add(new ColumnDef("사업장명", PrgmComPsnl0100BM.ATTR_DPOBNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row++, 10));
            }
        });
        /** SYSTEMKEY */
        listColumnDefs.add(new ColumnDef("시스템키", PrgmComPsnl0100BM.ATTR_SYSTEMKEY,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row++, 10));
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
         
        
       
        /** ENG_NM */
        listColumnDefs.add(new ColumnDef("영문성명", PrgmComPsnl0100BM.ATTR_ENGNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** CHIN_CHAR_NM */
        listColumnDefs.add(new ColumnDef("한문성명", PrgmComPsnl0100BM.ATTR_CHINCHARNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
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
        listColumnDefs.add(new ColumnDef("생년월일", PrgmComPsnl0100BM.ATTR_YOOBHMNTHDAY,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** SCLC_DIV_CD */
        listColumnDefs.add(new ColumnDef("음양구분코드", PrgmComPsnl0100BM.ATTR_SCLCDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
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
        listColumnDefs.add(new ColumnDef("국가명", PrgmComPsnl0100BM.ATTR_NATNNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** DEPT_CD */
        listColumnDefs.add(new ColumnDef("관리부서코드", PrgmComPsnl0100BM.ATTR_DEPTCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** DEPT_NM */
        listColumnDefs.add(new ColumnDef("관리부서명", PrgmComPsnl0100BM.ATTR_DEPTNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
       
        /** REPBTY_BUSIN_DIV_CD */
        listColumnDefs.add(new ColumnDef("담당업무구분코드", PrgmComPsnl0100BM.ATTR_REPBTYBUSINDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** REPBTY_BUSIN_DIV_NM */
        listColumnDefs.add(new ColumnDef("담당업무명", PrgmComPsnl0100BM.ATTR_REPBTYBUSINDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        }); 
     
        /** FRST_EMYMT_DT */
        listColumnDefs.add(new ColumnDef("최초고용일자", PrgmComPsnl0100BM.ATTR_FRSTEMYMTDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        }); 
        /** EMYMT_BGNN_DT */
        listColumnDefs.add(new ColumnDef("고용시작일자", PrgmComPsnl0100BM.ATTR_EMYMTBGNNDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** EMYMT_END_DT */
        listColumnDefs.add(new ColumnDef("고용종료일자", PrgmComPsnl0100BM.ATTR_EMYMTENDDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
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
        listColumnDefs.add(new ColumnDef("퇴직일자", PrgmComPsnl0100BM.ATTR_RETRYDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
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
        /** FRGNR_DIV_NM */
        listColumnDefs.add(new ColumnDef("외국인", PrgmComPsnl0100BM.ATTR_FRGNRDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** PSPT_NUM */
        listColumnDefs.add(new ColumnDef("여권번호", PrgmComPsnl0100BM.ATTR_PSPTNUM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** STY_BGNN_DT */
        listColumnDefs.add(new ColumnDef("체류시작일자", PrgmComPsnl0100BM.ATTR_STYBGNNDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
                
            }
        });
        /** STY_END_DT */
        listColumnDefs.add(new ColumnDef("체류종료일자", PrgmComPsnl0100BM.ATTR_STYENDDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** END_SCHL */
        listColumnDefs.add(new ColumnDef("최종학교", PrgmComPsnl0100BM.ATTR_ENDSCHL,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** END_DEGR_DIV_CD */
        listColumnDefs.add(new ColumnDef("최종학위구분코드", PrgmComPsnl0100BM.ATTR_ENDDEGRDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** END_DEGR_DIV_CD */
        listColumnDefs.add(new ColumnDef("최종학위명", PrgmComPsnl0100BM.ATTR_ENDDEGRDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** PMTN_SCDU_DT */
        listColumnDefs.add(new ColumnDef("승진예정일자", PrgmComPsnl0100BM.ATTR_PMTNSCDUDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** PYSP_PRMTN_SCDU_DT */
        listColumnDefs.add(new ColumnDef("호봉승급예정일자", PrgmComPsnl0100BM.ATTR_PYSPPRMTNSCDUDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** REYMN_SCDU_DT */
        listColumnDefs.add(new ColumnDef("재고용예정일자", PrgmComPsnl0100BM.ATTR_REYMNSCDUDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
      
        /** CURR_PYSP_APPMT_DT */
        listColumnDefs.add(new ColumnDef("현호봉발령일자", PrgmComPsnl0100BM.ATTR_CURRPYSPAPPMTDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** CURR_DEPT_APPMT_DT */
        listColumnDefs.add(new ColumnDef("현부서발령일자", PrgmComPsnl0100BM.ATTR_CURRDEPTAPPMTDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        /** PERN_NOTE_CTNT */
        listColumnDefs.add(new ColumnDef("비고", PrgmComPsnl0100BM.ATTR_PERNNOTECTNT,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        
        return listColumnDefs;
    }
    
}
