/**
 * 공통화면 팝업 
 */
package com.app.exterms.retirement.client.form.def;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComPsnl0100BM;
import com.app.exterms.retirement.client.dto.Remt2000BM;
import com.app.exterms.retirement.client.dto.Remt2300BM;
import com.app.exterms.retirement.client.languages.RemtConstants;
import com.app.exterms.retirement.shared.RemtDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.AttributeCustomForm;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Remt2000Def  extends TableDef implements RemtDaoConstants {

    private int row = 0;
    private RemtConstants remtLabel = RemtConstants.INSTANCE;

    
    
    public Remt2000Def(String chkData){ 
    	 
   	 
     if ("REMT0100".equals(chkData)) {
	       //퇴직금계산 
   		    setTitle("");
	        setDaoClass(""); 
	        setCustomListMethod(CLASS_SYSCOM_PSNL0100_REMT0100_DATALIST);
	        setAutoFillGrid(false); 
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        
	        setColumnsDefinition(getMSFPsnl0100ToRemt0100());
   	 } else if ("REMT0150".equals(chkData)) {
	       //퇴직금산정결과조회
		    setTitle("");
	        setDaoClass(""); 
	        setCustomListMethod(CLASS_REMT0150_REMT2000_DATALIST);
	        setAutoFillGrid(false); 
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        
	        setColumnsDefinition(getRemt0150ToRemt2000());
	 } else if ("REMTPYMT0100".equals(chkData)) {
	       //퇴직금지급내역 
		    setTitle("");
	        setDaoClass(""); 
	        setCustomListMethod(CLASS_REMTPYMT0100_REMT2000_DATALIST);
	        setAutoFillGrid(true); 
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        
	        setColumnsDefinition(getRemtPymt0100ToRemt2000());
	 } else  {
   		 
   		setColumnsDefinition(getRemt2000Def());
   		
     }
   } 
   
    private List<ColumnDef> getMSFPsnl0100ToRemt0100() {
    	row = 0;
    	
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        
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
        
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
		listColumnDefs.add(new ColumnDef("퇴직정산구분코드", Remt2000BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직정산구분코드 : calcSevePayPsnDivNm */
		listColumnDefs.add(new ColumnDef("정산구분", Remt2000BM.ATTR_CALCSEVEPAYPSNDIVNM, ColumnDef.TYPE_STRING , 70, true, true, true){
			{
		
			}
		});
		/** column 정산년월 : clutYrMnth */
		listColumnDefs.add(new ColumnDef("정산년월", Remt2000BM.ATTR_CLUTYRMNTH, ColumnDef.TYPE_STRING , 70, true, true, true){
			{
		      
			}
		});
		
        
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
//        /** LOG_SVC_MNTH_ICM_CD */
//        listColumnDefs.add(new ColumnDef("근속월수코드", PrgmComPsnl0100BM.ATTR_LOGSVCMNTHICMCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
//            {
//                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
//            }
//        });
//        /** LOG_SVC_MNTH_ICM_NM */
//        listColumnDefs.add(new ColumnDef("근속월수", PrgmComPsnl0100BM.ATTR_LOGSVCMNTHICMNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
//            {
//                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
//            }
//        }); 
         
         
//        /** SX_DIV_CD */
//        listColumnDefs.add(new ColumnDef("성별코드", PrgmComPsnl0100BM.ATTR_SXDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
//            {
//                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
//            }
//        });
//        /** SX_DIV_NM */
//        listColumnDefs.add(new ColumnDef("성별", PrgmComPsnl0100BM.ATTR_SXDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
//            {
//                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
//            }
//        });
//        /** YOOBH_MNTH_DAY */
//        listColumnDefs.add(new ColumnDef("생년월일", PrgmComPsnl0100BM.ATTR_YOOBHMNTHDAY,  ColumnDef.TYPE_STRING, 80, false, false, false){
//            {
//                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
//            }
//        });
//       
//        
//        /** NATN_CD */
//        listColumnDefs.add(new ColumnDef("국가코드", PrgmComPsnl0100BM.ATTR_NATNCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
//            {
//                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
//            }
//        });
//        /** NATN_Nm */
//        listColumnDefs.add(new ColumnDef("국가명", PrgmComPsnl0100BM.ATTR_NATNNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
//            {
//                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
//            }
//        });
//         
//     
//        /** FRST_EMYMT_DT */
//        listColumnDefs.add(new ColumnDef("최초고용일자", PrgmComPsnl0100BM.ATTR_FRSTEMYMTDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
//            {
//                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
//            }
//        }); 
//        /** EMYMT_BGNN_DT */
//        listColumnDefs.add(new ColumnDef("고용시작일자", PrgmComPsnl0100BM.ATTR_EMYMTBGNNDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
//            {
//                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
//            }
//        });
//        /** EMYMT_END_DT */
//        listColumnDefs.add(new ColumnDef("고용종료일자", PrgmComPsnl0100BM.ATTR_EMYMTENDDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
//            {
//                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
//            }
//        });
//        /** PYSP_CD */
//        listColumnDefs.add(new ColumnDef("호봉코드", PrgmComPsnl0100BM.ATTR_PYSPCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
//            {
//                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
//            }
//        });
//        /** PYSP_NM */
//        listColumnDefs.add(new ColumnDef("호봉", PrgmComPsnl0100BM.ATTR_PYSPNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
//            {
//                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
//            }
//        });
//        
//        /** RETRY_DT */
//        listColumnDefs.add(new ColumnDef("퇴직일자", PrgmComPsnl0100BM.ATTR_RETRYDT,  ColumnDef.TYPE_STRING, 80, false, false, false){
//            {
//                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
//            }
//        });
//        /** RETRY_REAS_CTNT */
//        listColumnDefs.add(new ColumnDef("퇴직사유", PrgmComPsnl0100BM.ATTR_RETRYREASCTNT,  ColumnDef.TYPE_STRING, 80, false, false, false){
//            {
//                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
//            }
//        });
//        /** FRGNR_DIV_CD */
//        listColumnDefs.add(new ColumnDef("외국인구분코드", PrgmComPsnl0100BM.ATTR_FRGNRDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, false){
//            {
//                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
//            }
//        });
       
        
        return listColumnDefs;
    }
    
    public List<ColumnDef> getRemt0150ToRemt2000(){
        
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           

		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Remt2000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Remt2000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
		listColumnDefs.add(new ColumnDef("퇴직정산구분코드", Remt2000BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직정산구분코드 : calcSevePayPsnDivNm */
		listColumnDefs.add(new ColumnDef("정산구분", Remt2000BM.ATTR_CALCSEVEPAYPSNDIVNM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
		
			}
		});
		/** column 정산년월 : clutYrMnth */
		listColumnDefs.add(new ColumnDef("정산년월", Remt2000BM.ATTR_CLUTYRMNTH, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
		      
			}
		});
		/** column 부서코드 : deptCd */
		listColumnDefs.add(new ColumnDef("부서코드", Remt2000BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 부서코드 : deptNm */
		listColumnDefs.add(new ColumnDef("부서", Remt2000BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 120, true, true, true){
			{
		
			}
		});
		/** column 직종코드 : typOccuCd */
		listColumnDefs.add(new ColumnDef("직종코드", Remt2000BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 100, true, false, true){
			{
		
			}
		});
		
		/** column 직종 : typOccuNm */
		listColumnDefs.add(new ColumnDef("직종", Remt2000BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
        
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Remt2000BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		{
		
		}
		});                                           
		        
		
		/** column 직종세 : dtilOccuClsDivNm */
		listColumnDefs.add(new ColumnDef("직종세", Remt2000BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
		{
		
		}
		});            

		/** column 호봉등급코드 : pyspGrdeCd */
		listColumnDefs.add(new ColumnDef("호봉등급코드", Remt2000BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 등급 : pyspGrdeNm */
		listColumnDefs.add(new ColumnDef("등급", Remt2000BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 직위코드 : inbyCd */
		listColumnDefs.add(new ColumnDef("직위코드", Remt2000BM.ATTR_INBYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 급호코드 : pyspCd */
		listColumnDefs.add(new ColumnDef("급호코드", Remt2000BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근속년수코드 : logSvcYrNumCd */
		listColumnDefs.add(new ColumnDef("근속년수코드", Remt2000BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근속월수코드 : logSvcMnthIcmCd */
		listColumnDefs.add(new ColumnDef("근속월수코드", Remt2000BM.ATTR_LOGSVCMNTHICMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 성명 : nm */
		listColumnDefs.add(new ColumnDef("성명", Remt2000BM.ATTR_NM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 입사일자 : icncDt */
		listColumnDefs.add(new ColumnDef("입사일자", Remt2000BM.ATTR_ICNCDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{
		
			}
		});
		
		/** column 기산일자 : rkfcdDt */
		listColumnDefs.add(new ColumnDef("기산일자", Remt2000BM.ATTR_RKFCDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		
		/** column 퇴직일자 : retryDt */
		listColumnDefs.add(new ColumnDef("퇴직일자", Remt2000BM.ATTR_RETRYDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{
		
			}
		});
		/** column 근속년수 : logSvcYrNum */
		listColumnDefs.add(new ColumnDef("근속년수", Remt2000BM.ATTR_LOGSVCYRNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속월수 : logSvcMnthIcm */
		listColumnDefs.add(new ColumnDef("근속월수", Remt2000BM.ATTR_LOGSVCMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 군경력근속년수 : amcrrLogSvcYrNum */
		listColumnDefs.add(new ColumnDef("군경력근속년수", Remt2000BM.ATTR_AMCRRLOGSVCYRNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 군경력근속월수 : amcrrLogSvcMnthIcm */
		listColumnDefs.add(new ColumnDef("군경력근속월수", Remt2000BM.ATTR_AMCRRLOGSVCMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
		listColumnDefs.add(new ColumnDef("제외월수_2012이전", Remt2000BM.ATTR_EEPNMNTHICM2012BFR, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
		listColumnDefs.add(new ColumnDef("제외월수_2013이후", Remt2000BM.ATTR_EEPNMNTHICM2013AFT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 가산월수_2012이전 : addMnthIcm2012Bfr */
		listColumnDefs.add(new ColumnDef("가산월수_2012이전", Remt2000BM.ATTR_ADDMNTHICM2012BFR, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 가산월수_2013이후 : addMnthIcm2013Aft */
		listColumnDefs.add(new ColumnDef("가산월수_2013이후", Remt2000BM.ATTR_ADDMNTHICM2013AFT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 제외일수 : eepnDayIcmDys */
		listColumnDefs.add(new ColumnDef("제외일수", Remt2000BM.ATTR_EEPNDAYICMDYS, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		
		/** column 근속일수 : logSvcNumDys */
		listColumnDefs.add(new ColumnDef("근속일수", Remt2000BM.ATTR_LOGSVCNUMDYS, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 군경력근무일수 : amcrrLogSvcNumDys */
		listColumnDefs.add(new ColumnDef("군경력근무일수", Remt2000BM.ATTR_AMCRRLOGSVCNUMDYS, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		
		/** column 실근무년수 : turtyDutyYrNum */
		listColumnDefs.add(new ColumnDef("실근무년수", Remt2000BM.ATTR_TURTYDUTYYRNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 실근무개월수 : turtyDutyMnthNum */
		listColumnDefs.add(new ColumnDef("실근무개월수", Remt2000BM.ATTR_TURTYDUTYMNTHNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 실근무일수 : turtyDutyNumDys */
		listColumnDefs.add(new ColumnDef("실근무일수", Remt2000BM.ATTR_TURTYDUTYNUMDYS, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		 
		
		/** column 총근속일수 : logSvcNumDys */
		listColumnDefs.add(new ColumnDef("총근속일수", Remt2000BM.ATTR_TOTLOGSVCNUMDYS, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
		
			}
		});
		/** column 급여산정시작일자 : payCmpttnBgnnDt */
		listColumnDefs.add(new ColumnDef("급여산정시작일자", Remt2000BM.ATTR_PAYCMPTTNBGNNDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 급여산정종료일자 : payCmpttnEndDt */
		listColumnDefs.add(new ColumnDef("급여산정종료일자", Remt2000BM.ATTR_PAYCMPTTNENDDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 기본급여합계금액 : fndtnPayAggrSumSum */
		listColumnDefs.add(new ColumnDef("기본급여합계금액", Remt2000BM.ATTR_FNDTNPAYAGGRSUMSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 제수당합계금액 : snryAllwAggrSum */
		listColumnDefs.add(new ColumnDef("제수당합계금액", Remt2000BM.ATTR_SNRYALLWAGGRSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 후생복지비합계금액 : welfWelfSpdgAggrSum */
		listColumnDefs.add(new ColumnDef("후생복지비합계금액", Remt2000BM.ATTR_WELFWELFSPDGAGGRSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 3월간후생복지비 : marPubcWelfAmnt */
		listColumnDefs.add(new ColumnDef("3월간후생복지비", Remt2000BM.ATTR_MARPUBCWELFAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 3월간총임금액 : marTotAmntWag */
		listColumnDefs.add(new ColumnDef("3월간총임금액", Remt2000BM.ATTR_MARTOTAMNTWAG, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 1일평균임금액 : dayAvgAmntWag */
		listColumnDefs.add(new ColumnDef("1일평균임금액", Remt2000BM.ATTR_DAYAVGAMNTWAG, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직금산정금액 : sevePayCmpttnSum */
		listColumnDefs.add(new ColumnDef("퇴직금산정금액", Remt2000BM.ATTR_SEVEPAYCMPTTNSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직금가산금액 : sevePayAddSum */
		listColumnDefs.add(new ColumnDef("퇴직금가산금액", Remt2000BM.ATTR_SEVEPAYADDSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직금가산율 : sevePayAddRate */
		listColumnDefs.add(new ColumnDef("퇴직금가산율", Remt2000BM.ATTR_SEVEPAYADDRATE, ColumnDef.TYPE_DOUBLE , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직금가산적용금액 : sevePayAddApptnSum */
		listColumnDefs.add(new ColumnDef("퇴직금가산적용금액", Remt2000BM.ATTR_SEVEPAYADDAPPTNSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 군경력정산포함여부 : amcrrClutInsnYn */
		listColumnDefs.add(new ColumnDef("군경력정산포함여부", Remt2000BM.ATTR_AMCRRCLUTINSNYN, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
			{
		
			}
		});
		/** column 군경력가산적용금액 : amcrrAddApptnSum */
		listColumnDefs.add(new ColumnDef("군경력가산적용금액", Remt2000BM.ATTR_AMCRRADDAPPTNSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직금지급액 : sevePayCmpttnSum */
		listColumnDefs.add(new ColumnDef("퇴직금지급액", Remt2000BM.ATTR_SEVEPAYPYMTSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
		
			}
		});
		/** column 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
		listColumnDefs.add(new ColumnDef("비과세금액", Remt2000BM.ATTR_SEVEPAYCMPTTNFREEDTYSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
		
			}
		});
		/** column 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
		listColumnDefs.add(new ColumnDef("퇴직금산정과세금액", Remt2000BM.ATTR_SEVEPAYCMPTTNTXTNSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부차감_소득세액 : pymtSubtnIncmTxQnty */
		listColumnDefs.add(new ColumnDef("소득세", Remt2000BM.ATTR_PYMTSUBTNINCMTXQNTY, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
		
			}
		});
		/** column 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
		listColumnDefs.add(new ColumnDef("지방소득세", Remt2000BM.ATTR_PYMTSUBTNRGONINCMTXQNTY, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
		
			}
		});
		/** column 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
		listColumnDefs.add(new ColumnDef("농어촌특별세", Remt2000BM.ATTR_PYMTSUBTNFARVILSPCLQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직금지급공제금액 : sevePayPymtDducSum */
		listColumnDefs.add(new ColumnDef("공제금액", Remt2000BM.ATTR_SEVEPAYPYMTDDUCSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
		
			}
		});
		/** column 퇴직금실지급금액 : sevePayTurtyPymtSum */
		listColumnDefs.add(new ColumnDef("실지급금액", Remt2000BM.ATTR_SEVEPAYTURTYPYMTSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
		
			}
		});
		/** column 퇴직금비고내용 : sevePayNoteCtnt */
		listColumnDefs.add(new ColumnDef("퇴직금비고내용", Remt2000BM.ATTR_SEVEPAYNOTECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직금지급일자 : sevePayPymtDt */
		listColumnDefs.add(new ColumnDef("퇴직금지급일자", Remt2000BM.ATTR_SEVEPAYPYMTDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직금지급여부 : sevePayPymtYn */
		listColumnDefs.add(new ColumnDef("지급", Remt2000BM.ATTR_SEVEPAYPYMTYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
			{
		
			}
		});
		/** column 마감여부 : ddlneYn */
		listColumnDefs.add(new ColumnDef("마감여부", Remt2000BM.ATTR_DDLNEYN, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
			{
		
			}
		});
		/** column 마감일시 : ddlneDt */
		listColumnDefs.add(new ColumnDef("마감일시", Remt2000BM.ATTR_DDLNEDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Remt2000BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Remt2000BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Remt2000BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Remt2000BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Remt2000BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Remt2000BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		
		
//		private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//		private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//		private TextField<String> calcSevePayPsnDivCd;   /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//
//		private TextField<String> clutYrMnth;   /** column 정산년월 : clutYrMnth */
//
//		private TextField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
//
//		private TextField<String> deptCd;   /** column 부서코드 : deptCd */
//
//		private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
//
//		private TextField<String> pyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
//
//		private TextField<String> dtilOccuClsDivCd;   /** column 직종세구분코드 : dtilOccuClsDivCd */
//
//		private TextField<String> businCd;   /** column 사업코드 : businCd */
//
//		private TextField<String> inbyCd;   /** column 직위코드 : inbyCd */
//
//		private TextField<String> pyspCd;   /** column 호봉코드 : pyspCd */
//
//		private TextField<String> logSvcYrNumCd;   /** column 근속년수코드 : logSvcYrNumCd */
//
//		private TextField<String> logSvcMnthIcmCd;   /** column 근속월수코드 : logSvcMnthIcmCd */
//
//		private TextField<String> nm;   /** column 성명 : nm */
//
//		private TextField<String> icncDt;   /** column 입사일자 : icncDt */
//
//		private TextField<String> rkfcdDt;   /** column 기산일자 : rkfcdDt */
//
//		private TextField<String> retryDt;   /** column 퇴직일자 : retryDt */
//
//		private TextField<String> logSvcYrNum;   /** column 근속년수 : logSvcYrNum */
//
//		private TextField<String> logSvcMnthIcm;   /** column 근속월수 : logSvcMnthIcm */
//
//		private TextField<String> amcrrLogSvcYrNum;   /** column 군경력근속년수 : amcrrLogSvcYrNum */
//
//		private TextField<String> amcrrLogSvcMnthIcm;   /** column 군경력근속월수 : amcrrLogSvcMnthIcm */
//
//		private TextField<String> eepnMnthIcm2012Bfr;   /** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
//
//		private TextField<String> eepnMnthIcm2013Aft;   /** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
//
//		private TextField<String> addMnthIcm2012Bfr;   /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
//
//		private TextField<String> addMnthIcm2013Aft;   /** column 가산월수_2013이후 : addMnthIcm2013Aft */
//
//		private TextField<String> eepnDayIcmDys;   /** column 제외일수 : eepnDayIcmDys */
//
//		private TextField<String> logSvcNumDys;   /** column 근속일수 : logSvcNumDys */
//
//		private TextField<String> amcrrLogSvcNumDys;   /** column 군경력근무일수 : amcrrLogSvcNumDys */
//
//		private TextField<String> payCmpttnBgnnDt;   /** column 급여산정시작일자 : payCmpttnBgnnDt */
//
//		private TextField<String> payCmpttnEndDt;   /** column 급여산정종료일자 : payCmpttnEndDt */
//
//		private TextField<String> fndtnPayAggrSumSum;   /** column 기본급여합계금액 : fndtnPayAggrSumSum */
//
//		private TextField<String> snryAllwAggrSum;   /** column 제수당합계금액 : snryAllwAggrSum */
//
//		private TextField<String> welfWelfSpdgAggrSum;   /** column 후생복지비합계금액 : welfWelfSpdgAggrSum */
//
//		private TextField<String> marPubcWelfAmnt;   /** column 3월간후생복지비 : marPubcWelfAmnt */
//
//		private TextField<String> marTotAmntWag;   /** column 3월간총임금액 : marTotAmntWag */
//
//		private TextField<String> dayAvgAmntWag;   /** column 1일평균임금액 : dayAvgAmntWag */
//
//		private TextField<String> sevePayCmpttnSum;   /** column 퇴직금산정금액 : sevePayCmpttnSum */
//
//		private TextField<String> sevePayAddSum;   /** column 퇴직금가산금액 : sevePayAddSum */
//
//		private TextField<String> sevePayAddRate;   /** column 퇴직금가산율 : sevePayAddRate */
//
//		private TextField<String> sevePayAddApptnSum;   /** column 퇴직금가산적용금액 : sevePayAddApptnSum */
//
//		private TextField<String> amcrrClutInsnYn;   /** column 군경력정산포함여부 : amcrrClutInsnYn */
//
//		private TextField<String> amcrrAddApptnSum;   /** column 군경력가산적용금액 : amcrrAddApptnSum */
//
//		private TextField<String> totLogSvcNumDys;   /** column 총근무일수 : totLogSvcNumDys */
//
//		private TextField<String> sevePayPymtSum;   /** column 퇴직금지급액 : sevePayPymtSum */
//
//		private TextField<String> sevePayCmpttnFreeDtySum;   /** column 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
//
//		private TextField<String> sevePayCmpttnTxtnSum;   /** column 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
//
//		private TextField<String> sevePayPymtDducSum;   /** column 퇴직금지급공제금액 : sevePayPymtDducSum */
//
//		private TextField<String> sevePayTurtyPymtSum;   /** column 퇴직금실지급금액 : sevePayTurtyPymtSum */
//
//		private TextField<String> sevePayNoteCtnt;   /** column 퇴직금비고내용 : sevePayNoteCtnt */
//
//		private TextField<String> sevePayPymtDt;   /** column 퇴직금지급일자 : sevePayPymtDt */
//
//		private TextField<String> sevePayPymtYn;   /** column 퇴직금지급여부 : sevePayPymtYn */
//
//		private TextField<String> ddlneYn;   /** column 마감여부 : ddlneYn */
//
//		private TextField<String> ddlneDt;   /** column 마감일시 : ddlneDt */
//
//		private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//		private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//		private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//		private TextField<String> ismt;   /** column 수정자 : ismt */
//
//		private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//		private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
		          
        return listColumnDefs;
    }    
    
  public List<ColumnDef> getRemtPymt0100ToRemt2000(){
        
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Remt2300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        listColumnDefs.add(new ColumnDef("퇴직정산구분코드", Remt2300BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산년월 : clutYrMnth */
        listColumnDefs.add(new ColumnDef("정산년월", Remt2300BM.ATTR_CLUTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Remt2300BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
//        /** column 급여항목코드 : payItemCd */
//        listColumnDefs.add(new ColumnDef("급여항목코드", Remt2300BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
        /** column 급여항목 : payItemNm */
        listColumnDefs.add(new ColumnDef("지급항목", Remt2300BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
//        /** column 지급공제구분코드 : pymtDducDivCd 기본값으로 셋팅 수당*/
//        listColumnDefs.add(new ColumnDef("지급공제구분코드", Remt2300BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
        /** column 지급금액 : pymtSum */
        listColumnDefs.add(new ColumnDef("지급금액", Remt2300BM.ATTR_PYMTSUM, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
		
		 
        return listColumnDefs;
    }   
    
public List<ColumnDef> getRemt2000Def(){
      
         
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           


/** column 사업장코드 : dpobCd */
listColumnDefs.add(new ColumnDef("사업장코드", Remt2000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column SYSTEMKEY : systemkey */
listColumnDefs.add(new ColumnDef("SYSTEMKEY", Remt2000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
listColumnDefs.add(new ColumnDef("퇴직정산구분코드", Remt2000BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 정산년월 : clutYrMnth */
listColumnDefs.add(new ColumnDef("정산년월", Remt2000BM.ATTR_CLUTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 고용구분코드 : emymtDivCd */
listColumnDefs.add(new ColumnDef("고용구분코드", Remt2000BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 부서코드 : deptCd */
listColumnDefs.add(new ColumnDef("부서코드", Remt2000BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 직종코드 : typOccuCd */
listColumnDefs.add(new ColumnDef("직종코드", Remt2000BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 호봉등급코드 : pyspGrdeCd */
listColumnDefs.add(new ColumnDef("호봉등급코드", Remt2000BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 직종세구분코드 : dtilOccuClsDivCd */
listColumnDefs.add(new ColumnDef("직종세구분코드", Remt2000BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});

	/** column 직종세통합코드 : dtilOccuInttnCd */
	listColumnDefs.add(new ColumnDef("직종세통합코드", Remt2000BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{
	
	}
	});                                           
	        
	
	/** column 직종세 : dtilOccuClsDivNm */
	listColumnDefs.add(new ColumnDef("직종세", Remt2000BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
	{
	
	}
	});       
/** column 사업코드 : businCd */
listColumnDefs.add(new ColumnDef("사업코드", Remt2000BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 직위코드 : inbyCd */
listColumnDefs.add(new ColumnDef("직위코드", Remt2000BM.ATTR_INBYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 호봉코드 : pyspCd */
listColumnDefs.add(new ColumnDef("호봉코드", Remt2000BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근속년수코드 : logSvcYrNumCd */
listColumnDefs.add(new ColumnDef("근속년수코드", Remt2000BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근속월수코드 : logSvcMnthIcmCd */
listColumnDefs.add(new ColumnDef("근속월수코드", Remt2000BM.ATTR_LOGSVCMNTHICMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 성명 : nm */
listColumnDefs.add(new ColumnDef("성명", Remt2000BM.ATTR_NM, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입사일자 : icncDt */
listColumnDefs.add(new ColumnDef("입사일자", Remt2000BM.ATTR_ICNCDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 기산일자 : rkfcdDt */
listColumnDefs.add(new ColumnDef("기산일자", Remt2000BM.ATTR_RKFCDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 퇴직일자 : retryDt */
listColumnDefs.add(new ColumnDef("퇴직일자", Remt2000BM.ATTR_RETRYDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근속년수 : logSvcYrNum */
listColumnDefs.add(new ColumnDef("근속년수", Remt2000BM.ATTR_LOGSVCYRNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 근속월수 : logSvcMnthIcm */
listColumnDefs.add(new ColumnDef("근속월수", Remt2000BM.ATTR_LOGSVCMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 군경력근속년수 : amcrrLogSvcYrNum */
listColumnDefs.add(new ColumnDef("군경력근속년수", Remt2000BM.ATTR_AMCRRLOGSVCYRNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 군경력근속월수 : amcrrLogSvcMnthIcm */
listColumnDefs.add(new ColumnDef("군경력근속월수", Remt2000BM.ATTR_AMCRRLOGSVCMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
listColumnDefs.add(new ColumnDef("제외월수_2012이전", Remt2000BM.ATTR_EEPNMNTHICM2012BFR, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
listColumnDefs.add(new ColumnDef("제외월수_2013이후", Remt2000BM.ATTR_EEPNMNTHICM2013AFT, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 가산월수_2012이전 : addMnthIcm2012Bfr */
listColumnDefs.add(new ColumnDef("가산월수_2012이전", Remt2000BM.ATTR_ADDMNTHICM2012BFR, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 가산월수_2013이후 : addMnthIcm2013Aft */
listColumnDefs.add(new ColumnDef("가산월수_2013이후", Remt2000BM.ATTR_ADDMNTHICM2013AFT, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 제외일수 : eepnDayIcmDys */
listColumnDefs.add(new ColumnDef("제외일수", Remt2000BM.ATTR_EEPNDAYICMDYS, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 근속일수 : logSvcNumDys */
listColumnDefs.add(new ColumnDef("근속일수", Remt2000BM.ATTR_LOGSVCNUMDYS, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 군경력근무일수 : amcrrLogSvcNumDys */
listColumnDefs.add(new ColumnDef("군경력근무일수", Remt2000BM.ATTR_AMCRRLOGSVCNUMDYS, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});

/** column 실근무년수 : turtyDutyYrNum */
listColumnDefs.add(new ColumnDef("실근무년수", Remt2000BM.ATTR_TURTYDUTYYRNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 실근무개월수 : turtyDutyMnthNum */
listColumnDefs.add(new ColumnDef("실근무개월수", Remt2000BM.ATTR_TURTYDUTYMNTHNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 실근무일수 : turtyDutyNumDys */
listColumnDefs.add(new ColumnDef("실근무일수", Remt2000BM.ATTR_TURTYDUTYNUMDYS, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
 

/** column 급여산정시작일자 : payCmpttnBgnnDt */
listColumnDefs.add(new ColumnDef("급여산정시작일자", Remt2000BM.ATTR_PAYCMPTTNBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 급여산정종료일자 : payCmpttnEndDt */
listColumnDefs.add(new ColumnDef("급여산정종료일자", Remt2000BM.ATTR_PAYCMPTTNENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 기본급여합계금액 : fndtnPayAggrSumSum */
listColumnDefs.add(new ColumnDef("기본급여합계금액", Remt2000BM.ATTR_FNDTNPAYAGGRSUMSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 제수당합계금액 : snryAllwAggrSum */
listColumnDefs.add(new ColumnDef("제수당합계금액", Remt2000BM.ATTR_SNRYALLWAGGRSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 후생복지비합계금액 : welfWelfSpdgAggrSum */
listColumnDefs.add(new ColumnDef("후생복지비합계금액", Remt2000BM.ATTR_WELFWELFSPDGAGGRSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 3월간후생복지비 : marPubcWelfAmnt */
listColumnDefs.add(new ColumnDef("3월간후생복지비", Remt2000BM.ATTR_MARPUBCWELFAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 3월간총임금액 : marTotAmntWag */
listColumnDefs.add(new ColumnDef("3월간총임금액", Remt2000BM.ATTR_MARTOTAMNTWAG, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 1일평균임금액 : dayAvgAmntWag */
listColumnDefs.add(new ColumnDef("1일평균임금액", Remt2000BM.ATTR_DAYAVGAMNTWAG, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 퇴직금산정금액 : sevePayCmpttnSum */
listColumnDefs.add(new ColumnDef("퇴직금산정금액", Remt2000BM.ATTR_SEVEPAYCMPTTNSUM, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 퇴직금가산금액 : sevePayAddSum */
listColumnDefs.add(new ColumnDef("퇴직금가산금액", Remt2000BM.ATTR_SEVEPAYADDSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 퇴직금가산율 : sevePayAddRate */
listColumnDefs.add(new ColumnDef("퇴직금가산율", Remt2000BM.ATTR_SEVEPAYADDRATE, ColumnDef.TYPE_DOUBLE , 90, true, false, true){
	{

	}
});
/** column 퇴직금가산적용금액 : sevePayAddApptnSum */
listColumnDefs.add(new ColumnDef("퇴직금가산적용금액", Remt2000BM.ATTR_SEVEPAYADDAPPTNSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 군경력정산포함여부 : amcrrClutInsnYn */
listColumnDefs.add(new ColumnDef("군경력정산포함여부", Remt2000BM.ATTR_AMCRRCLUTINSNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 군경력가산적용금액 : amcrrAddApptnSum */
listColumnDefs.add(new ColumnDef("군경력가산적용금액", Remt2000BM.ATTR_AMCRRADDAPPTNSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 총근무일수 : totLogSvcNumDys */
listColumnDefs.add(new ColumnDef("총근무일수", Remt2000BM.ATTR_TOTLOGSVCNUMDYS, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 퇴직금지급액 : sevePayPymtSum */
listColumnDefs.add(new ColumnDef("퇴직금지급액", Remt2000BM.ATTR_SEVEPAYPYMTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
listColumnDefs.add(new ColumnDef("퇴직금산정비과세금액", Remt2000BM.ATTR_SEVEPAYCMPTTNFREEDTYSUM, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
listColumnDefs.add(new ColumnDef("퇴직금산정과세금액", Remt2000BM.ATTR_SEVEPAYCMPTTNTXTNSUM, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 퇴직금지급공제금액 : sevePayPymtDducSum */
listColumnDefs.add(new ColumnDef("퇴직금지급공제금액", Remt2000BM.ATTR_SEVEPAYPYMTDDUCSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 퇴직금실지급금액 : sevePayTurtyPymtSum */
listColumnDefs.add(new ColumnDef("퇴직금실지급금액", Remt2000BM.ATTR_SEVEPAYTURTYPYMTSUM, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 퇴직금비고내용 : sevePayNoteCtnt */
listColumnDefs.add(new ColumnDef("퇴직금비고내용", Remt2000BM.ATTR_SEVEPAYNOTECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 퇴직금지급일자 : sevePayPymtDt */
listColumnDefs.add(new ColumnDef("퇴직금지급일자", Remt2000BM.ATTR_SEVEPAYPYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 퇴직금지급여부 : sevePayPymtYn */
listColumnDefs.add(new ColumnDef("퇴직금지급여부", Remt2000BM.ATTR_SEVEPAYPYMTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 마감여부 : ddlneYn */
listColumnDefs.add(new ColumnDef("마감여부", Remt2000BM.ATTR_DDLNEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 마감일시 : ddlneDt */
listColumnDefs.add(new ColumnDef("마감일시", Remt2000BM.ATTR_DDLNEDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입력자 : kybdr */
listColumnDefs.add(new ColumnDef("입력자", Remt2000BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입력일자 : inptDt */
listColumnDefs.add(new ColumnDef("입력일자", Remt2000BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입력주소 : inptAddr */
listColumnDefs.add(new ColumnDef("입력주소", Remt2000BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정자 : ismt */
listColumnDefs.add(new ColumnDef("수정자", Remt2000BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정일자 : revnDt */
listColumnDefs.add(new ColumnDef("수정일자", Remt2000BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정주소 : revnAddr */
listColumnDefs.add(new ColumnDef("수정주소", Remt2000BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});


//private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//private TextField<String> calcSevePayPsnDivCd;   /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//
//private TextField<String> clutYrMnth;   /** column 정산년월 : clutYrMnth */
//
//private TextField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
//
//private TextField<String> deptCd;   /** column 부서코드 : deptCd */
//
//private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
//
//private TextField<String> pyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
//
//private TextField<String> dtilOccuClsDivCd;   /** column 직종세구분코드 : dtilOccuClsDivCd */
//
//private TextField<String> businCd;   /** column 사업코드 : businCd */
//
//private TextField<String> inbyCd;   /** column 직위코드 : inbyCd */
//
//private TextField<String> pyspCd;   /** column 호봉코드 : pyspCd */
//
//private TextField<String> logSvcYrNumCd;   /** column 근속년수코드 : logSvcYrNumCd */
//
//private TextField<String> logSvcMnthIcmCd;   /** column 근속월수코드 : logSvcMnthIcmCd */
//
//private TextField<String> nm;   /** column 성명 : nm */
//
//private TextField<String> icncDt;   /** column 입사일자 : icncDt */
//
//private TextField<String> rkfcdDt;   /** column 기산일자 : rkfcdDt */
//
//private TextField<String> retryDt;   /** column 퇴직일자 : retryDt */
//
//private TextField<String> logSvcYrNum;   /** column 근속년수 : logSvcYrNum */
//
//private TextField<String> logSvcMnthIcm;   /** column 근속월수 : logSvcMnthIcm */
//
//private TextField<String> amcrrLogSvcYrNum;   /** column 군경력근속년수 : amcrrLogSvcYrNum */
//
//private TextField<String> amcrrLogSvcMnthIcm;   /** column 군경력근속월수 : amcrrLogSvcMnthIcm */
//
//private TextField<String> eepnMnthIcm2012Bfr;   /** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
//
//private TextField<String> eepnMnthIcm2013Aft;   /** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
//
//private TextField<String> addMnthIcm2012Bfr;   /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
//
//private TextField<String> addMnthIcm2013Aft;   /** column 가산월수_2013이후 : addMnthIcm2013Aft */
//
//private TextField<String> eepnDayIcmDys;   /** column 제외일수 : eepnDayIcmDys */
//
//private TextField<String> logSvcNumDys;   /** column 근속일수 : logSvcNumDys */
//
//private TextField<String> turtyDutyYrNum;   /** column 실근무년수 : turtyDutyYrNum */
//
//private TextField<String> turtyDutyMnthNum;   /** column 실근무개월수 : turtyDutyMnthNum */
//
//private TextField<String> turtyDutyNumDys;   /** column 실근무일수 : turtyDutyNumDys */
//
//private TextField<String> amcrrLogSvcNumDys;   /** column 군경력근무일수 : amcrrLogSvcNumDys */
//
//private TextField<String> payCmpttnBgnnDt;   /** column 급여산정시작일자 : payCmpttnBgnnDt */
//
//private TextField<String> payCmpttnEndDt;   /** column 급여산정종료일자 : payCmpttnEndDt */
//
//private TextField<String> fndtnPayAggrSumSum;   /** column 기본급여합계금액 : fndtnPayAggrSumSum */
//
//private TextField<String> snryAllwAggrSum;   /** column 제수당합계금액 : snryAllwAggrSum */
//
//private TextField<String> welfWelfSpdgAggrSum;   /** column 후생복지비합계금액 : welfWelfSpdgAggrSum */
//
//private TextField<String> marPubcWelfAmnt;   /** column 3월간후생복지비 : marPubcWelfAmnt */
//
//private TextField<String> marTotAmntWag;   /** column 3월간총임금액 : marTotAmntWag */
//
//private TextField<String> dayAvgAmntWag;   /** column 1일평균임금액 : dayAvgAmntWag */
//
//private TextField<String> sevePayCmpttnSum;   /** column 퇴직금산정금액 : sevePayCmpttnSum */
//
//private TextField<String> sevePayAddSum;   /** column 퇴직금가산금액 : sevePayAddSum */
//
//private TextField<String> sevePayAddRate;   /** column 퇴직금가산율 : sevePayAddRate */
//
//private TextField<String> sevePayAddApptnSum;   /** column 퇴직금가산적용금액 : sevePayAddApptnSum */
//
//private TextField<String> amcrrClutInsnYn;   /** column 군경력정산포함여부 : amcrrClutInsnYn */
//
//private TextField<String> amcrrAddApptnSum;   /** column 군경력가산적용금액 : amcrrAddApptnSum */
//
//private TextField<String> totLogSvcNumDys;   /** column 총근무일수 : totLogSvcNumDys */
//
//private TextField<String> sevePayPymtSum;   /** column 퇴직금지급액 : sevePayPymtSum */
//
//private TextField<String> sevePayCmpttnFreeDtySum;   /** column 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
//
//private TextField<String> sevePayCmpttnTxtnSum;   /** column 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
//
//private TextField<String> sevePayPymtDducSum;   /** column 퇴직금지급공제금액 : sevePayPymtDducSum */
//
//private TextField<String> sevePayTurtyPymtSum;   /** column 퇴직금실지급금액 : sevePayTurtyPymtSum */
//
//private TextField<String> sevePayNoteCtnt;   /** column 퇴직금비고내용 : sevePayNoteCtnt */
//
//private TextField<String> sevePayPymtDt;   /** column 퇴직금지급일자 : sevePayPymtDt */
//
//private TextField<String> sevePayPymtYn;   /** column 퇴직금지급여부 : sevePayPymtYn */
//
//private TextField<String> ddlneYn;   /** column 마감여부 : ddlneYn */
//
//private TextField<String> ddlneDt;   /** column 마감일시 : ddlneDt */
//
//private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//private TextField<String> ismt;   /** column 수정자 : ismt */
//
//private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
	 
        return listColumnDefs;
    }
}
