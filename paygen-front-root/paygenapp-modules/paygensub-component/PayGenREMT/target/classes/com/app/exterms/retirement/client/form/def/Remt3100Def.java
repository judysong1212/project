/**
 * 공통화면 팝업 
 */
package com.app.exterms.retirement.client.form.def;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.retirement.client.dto.InfcPkgRemt9000BM;
import com.app.exterms.retirement.client.dto.Remt3100BM;
import com.app.exterms.retirement.client.dto.Remt9000BM;
import com.app.exterms.retirement.client.languages.RemtConstants;
import com.app.exterms.retirement.shared.RemtDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.google.gwt.i18n.client.DateTimeFormat;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Remt3100Def  extends TableDef implements RemtDaoConstants {

    private int row = 0;
    private RemtConstants RemtLabel = RemtConstants.INSTANCE;

    public Remt3100Def(String chkDef){ 
   	 
      	 
        if ("REMT0100".equals(chkDef)) {
   	       //퇴직금중간정산 
      	  setTitle("");
   	        setDaoClass(""); 
   	        setCustomListMethod(CLASS_REMT3100_REMT0100_DATALIST);
   	        setAutoFillGrid(false); 
   	        setShowFilterToolbar(false);
   	        setCheckBoxOnGridRows(true);
   	        
   	        setColumnsDefinition(getRemt3100ToRemt0100());
   	        
      	 } else  if ("REMT0200".equals(chkDef)) {
     	       //퇴직정산
          	    setTitle("");
      	        setDaoClass(""); 
      	        setCustomListMethod(CLASS_REMT0200_REMT3100_DATALIST);
      	        setAutoFillGrid(false); 
      	        setShowFilterToolbar(false);
      	        setCheckBoxOnGridRows(true);
      	        
      	        setColumnsDefinition(getRemt0200ToRemt3100());
      	     
        } else if ("REMT0300".equals(chkDef)) {
    	       //퇴직금계산 결과
     		  setTitle("");
     	      
     	        setDaoClass(CLASS_REMT0300_REMT3100_DATA_LIST);
     	        setCustomListMethod(CLASS_REMT0300_REMT3100_DATA_LIST);
     	        setAutoFillGrid(false);
     	        setShowFilterToolbar(false);
     	       // setCustomListMethod(MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL);
     	        setCheckBoxOnGridRows(true);
     	             
     	        setColumnsDefinition(getRemt0300ToRemt3100());
        } else  if ("REMTPYMTSUBTN0200".equals(chkDef)) {
  	       //납부명세 
       	    setTitle("");
   	        setDaoClass(""); 
   	        setCustomListMethod(CLASS_REMTPYMTSUBTN0200_REMT3100_DATALIST);
   	        setAutoFillGrid(true); 
   	        setShowFilterToolbar(false);
   	       // setCheckBoxOnGridRows(true);
   	        
   	        setColumnsDefinition(getRemtPymtSubtn0200ToRemt3100());
   	     
       }
      } 
    
    public List<ColumnDef>  getRemt3100ToRemt0100(){
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Remt9000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
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
        listColumnDefs.add(new ColumnDef("귀속년도", Remt9000BM.ATTR_CALCSEVEPAYPSNBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        listColumnDefs.add(new ColumnDef("퇴직정산구분코드", Remt9000BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        }); 
   
         
        
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        listColumnDefs.add(new ColumnDef("정산구분", Remt9000BM.ATTR_CALCSEVEPAYPSNDIVNM, ColumnDef.TYPE_STRING , 90, false, true, true){
            {

            }
        });
        /** column 입사일자 : icncDt */
        listColumnDefs.add(new ColumnDef("입사일자", Remt9000BM.ATTR_ICNCDT, ColumnDef.TYPE_DATE , 90, false, false, true){
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
       
        /** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
        listColumnDefs.add(new ColumnDef("제외2012이전", Remt9000BM.ATTR_EEPNMNTHICM2012BFR, ColumnDef.TYPE_LONG , 90, false, false, true){
            {

            }
        });
        /** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
        listColumnDefs.add(new ColumnDef("제외2013이후", Remt9000BM.ATTR_EEPNMNTHICM2013AFT, ColumnDef.TYPE_LONG , 90, false, false, true){
            {

            }
        });
        /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
        listColumnDefs.add(new ColumnDef("가산2012이전", Remt9000BM.ATTR_ADDMNTHICM2012BFR, ColumnDef.TYPE_LONG , 90, false, false, true){
            {

            }
        });
        /** column 가산월수_2013이후 : addMnthIcm2013Aft */
        listColumnDefs.add(new ColumnDef("가산2013이후", Remt9000BM.ATTR_ADDMNTHICM2013AFT, ColumnDef.TYPE_LONG , 90, false, false, true){
            {

            }
        });
        
        /** column 퇴직금가산율 : sevePayAddRate */
        listColumnDefs.add(new ColumnDef("가산율", Remt9000BM.ATTR_SEVEPAYADDRATE, ColumnDef.TYPE_DOUBLE , 80, false, true, true){
            {

            }
        });
        
        
        /** column 군경력정산포함여부 : amcrrClutInsnYn */
        listColumnDefs.add(new ColumnDef("군경력", InfcPkgRemt9000BM.ATTR_AMCRRCLUTINSNYN, ColumnDef.TYPE_BOOLEAN , 60, false, true, true){
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
        listColumnDefs.add(new ColumnDef("지방소득세", Remt9000BM.ATTR_LOCINCMTXAMT, ColumnDef.TYPE_LONG , 90, false, true, true){
        	{

        	}
        });
        /** column 차인지급액 : pernPymtSum */
        listColumnDefs.add(new ColumnDef("지급액", Remt9000BM.ATTR_PERNPYMTSUM, ColumnDef.TYPE_LONG , 90, false, true, true){
        	{

        	}
        });
      
        /** column 퇴직금중간정산비고내용 : sevePayCtrClutNoteCtnt */
        listColumnDefs.add(new ColumnDef("비고내용", Remt9000BM.ATTR_SEVEPAYCTRCLUTNOTECTNT, ColumnDef.TYPE_STRING , 150, false, true, true){
            {
                setTypeTextField(ColumnDef.TEXTAREA); 
            }
        });
  
        return listColumnDefs;
    }
    
    
    public List<ColumnDef>  getRemt0200ToRemt3100(){
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Remt3100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직정산정산년월 : clutYrMnth */
        listColumnDefs.add(new ColumnDef("정산년월", Remt3100BM.ATTR_CLUTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });  
        /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
        listColumnDefs.add(new ColumnDef("퇴직정산귀속년월", Remt3100BM.ATTR_CALCSEVEPSNBLGGYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        listColumnDefs.add(new ColumnDef("퇴직정산구분코드", Remt3100BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Remt3100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Remt3100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** DEPT_NM */
        listColumnDefs.add(new ColumnDef("부서명", Remt3100BM.ATTR_DEPTNM,  ColumnDef.TYPE_STRING, 80, false, true, false){
            {
                
            }
        });
        

		/** column 한글성명 : hanNm */
		listColumnDefs.add(new ColumnDef("한글성명", Remt3100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 주민등록번호 : resnRegnNum */
		listColumnDefs.add(new ColumnDef("주민등록번호", Remt3100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
        
        /** EMYMT_DIV_CD */
        listColumnDefs.add(new ColumnDef("고용구분코드", Remt3100BM.ATTR_EMYMTDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                 
            }
        });
        /** EMYMT_DIV_NM */
        listColumnDefs.add(new ColumnDef("고용구분", Remt3100BM.ATTR_EMYMTDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                
            }
        });
        
        /** TYP_OCCU_CD */
        listColumnDefs.add(new ColumnDef("직종코드", Remt3100BM.ATTR_TYPOCCUCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                
            }
        });
        /** TYP_OCCU_NM */
        listColumnDefs.add(new ColumnDef("직종", Remt3100BM.ATTR_TYPOCCUNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
               
            }
        });
        
        
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Remt3100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		{
		
		}
		});                                           
		          
		
		/** column 직종세 : dtilOccuClsDivNm */
		listColumnDefs.add(new ColumnDef("직종세", Remt3100BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
		{
		
		}
		});        

        /** BUSIN_CD */
        listColumnDefs.add(new ColumnDef("사업코드", Remt3100BM.ATTR_BUSINCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
               
            }
        });
        /** BUSIN_NM */
        listColumnDefs.add(new ColumnDef("사업", Remt3100BM.ATTR_BUSINNM,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                
            }
        }); 

		 
		/** column 소득자임원여부 : aimenrEcteYn */
		listColumnDefs.add(new ColumnDef("소득자임원여부", Remt3100BM.ATTR_AIMENRECTEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		
		/** column 확정급여형가입일자 : fixPayJnDt */
		listColumnDefs.add(new ColumnDef("확정급여형가입일자", Remt3100BM.ATTR_FIXPAYJNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 퇴직금_20111231금액 : sevePay20111231Sum */
		listColumnDefs.add(new ColumnDef("퇴직금_20111231금액", Remt3100BM.ATTR_SEVEPAY20111231SUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 외국인구분코드 : frgnrDivCd */
		listColumnDefs.add(new ColumnDef("외국인구분코드", Remt3100BM.ATTR_FRGNRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 거주구분여부 : ridnSeptYn */
		listColumnDefs.add(new ColumnDef("거주구분여부", Remt3100BM.ATTR_RIDNSEPTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 거주지국코드 : ridnCd */
		listColumnDefs.add(new ColumnDef("거주지국코드", Remt3100BM.ATTR_RIDNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 거주지국명 : ridnNm */
		listColumnDefs.add(new ColumnDef("거주지국명", Remt3100BM.ATTR_RIDNNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 귀속년도시작일자 : blggYrBgnnDt */
		listColumnDefs.add(new ColumnDef("귀속년도시작일자", Remt3100BM.ATTR_BLGGYRBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 귀속년도종료일자 : blggYrEndDt */
		listColumnDefs.add(new ColumnDef("귀속년도종료일자", Remt3100BM.ATTR_BLGGYRENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직사유코드 : retryReasCd */
		listColumnDefs.add(new ColumnDef("퇴직사유코드", Remt3100BM.ATTR_RETRYREASCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 중_사업자등록번호 : ctrBusoprRgstnNum */
		listColumnDefs.add(new ColumnDef("중_사업자등록번호", Remt3100BM.ATTR_CTRBUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 중_근무처명 : ctrPaeWorkNm */
		listColumnDefs.add(new ColumnDef("중_근무처명", Remt3100BM.ATTR_CTRPAEWORKNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 중_퇴직급여액 : ctrRetryPayQnty */
		listColumnDefs.add(new ColumnDef("중_퇴직급여액", Remt3100BM.ATTR_CTRRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
		listColumnDefs.add(new ColumnDef("중_비과세퇴직급여액", Remt3100BM.ATTR_CTRFREEDTYRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
		listColumnDefs.add(new ColumnDef("중_과세대상퇴직급여액", Remt3100BM.ATTR_CTRTXTNTGTRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_사업자등록번호 : endBusoprRgstnNum */
		listColumnDefs.add(new ColumnDef("종_사업자등록번호", Remt3100BM.ATTR_ENDBUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 종_근무처명 : endPaeWorkNm */
		listColumnDefs.add(new ColumnDef("종_근무처명", Remt3100BM.ATTR_ENDPAEWORKNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 종_퇴직급여액 : endRetryPayQnty */
		listColumnDefs.add(new ColumnDef("종_퇴직급여액", Remt3100BM.ATTR_ENDRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
		listColumnDefs.add(new ColumnDef("종_비과세퇴직급여액", Remt3100BM.ATTR_ENDFREEDTYRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
		listColumnDefs.add(new ColumnDef("종_과세대상퇴직급여액", Remt3100BM.ATTR_ENDTXTNTGTRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_퇴직급여액 : clutRetryPayQnty */
		listColumnDefs.add(new ColumnDef("정산_퇴직급여액", Remt3100BM.ATTR_CLUTRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
		listColumnDefs.add(new ColumnDef("정산_비과세퇴직급여액", Remt3100BM.ATTR_CLUTFREEDTYRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
		listColumnDefs.add(new ColumnDef("정산_과세대상퇴직급여액", Remt3100BM.ATTR_CLUTTXTNTGTRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_입사일자 : ctrIcncDt */
		listColumnDefs.add(new ColumnDef("중_입사일자", Remt3100BM.ATTR_CTRICNCDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 중_기산일자 : ctrRkfcdDt */
		listColumnDefs.add(new ColumnDef("중_기산일자", Remt3100BM.ATTR_CTRRKFCDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 중_퇴사일자 : ctrRsgtnDt */
		listColumnDefs.add(new ColumnDef("중_퇴사일자", Remt3100BM.ATTR_CTRRSGTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 중_지급일자 : ctrPymtDt */
		listColumnDefs.add(new ColumnDef("중_지급일자", Remt3100BM.ATTR_CTRPYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 중_근속월수 : ctrLogSvcMnthIcm */
		listColumnDefs.add(new ColumnDef("중_근속월수", Remt3100BM.ATTR_CTRLOGSVCMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
		listColumnDefs.add(new ColumnDef("중_제외월수_2012이전", Remt3100BM.ATTR_CTREEPNMNTH12BFR, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_제외월수_2013이후 : ctrEepnMnth13Aft */
		listColumnDefs.add(new ColumnDef("중_제외월수_2013이후", Remt3100BM.ATTR_CTREEPNMNTH13AFT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_가산월수_2012이전 : ctrAddMnth12Bfr */
		listColumnDefs.add(new ColumnDef("중_가산월수_2012이전", Remt3100BM.ATTR_CTRADDMNTH12BFR, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_가산월수_2013이후 : ctrAddMnth13Aft */
		listColumnDefs.add(new ColumnDef("중_가산월수_2013이후", Remt3100BM.ATTR_CTRADDMNTH13AFT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_제외월수 : ctrEepnMnthIcm */
		listColumnDefs.add(new ColumnDef("중_제외월수", Remt3100BM.ATTR_CTREEPNMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_가산월수 : ctrAddMnthIcm */
		listColumnDefs.add(new ColumnDef("중_가산월수", Remt3100BM.ATTR_CTRADDMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_중복월수 : ctrDupMnthIcm */
		listColumnDefs.add(new ColumnDef("중_중복월수", Remt3100BM.ATTR_CTRDUPMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_근속연수 : ctrLogSvc */
		listColumnDefs.add(new ColumnDef("중_근속연수", Remt3100BM.ATTR_CTRLOGSVC, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_입사일자 : endIcncDt */
		listColumnDefs.add(new ColumnDef("종_입사일자", Remt3100BM.ATTR_ENDICNCDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 종_기산일자 : endRkfcdDt */
		listColumnDefs.add(new ColumnDef("종_기산일자", Remt3100BM.ATTR_ENDRKFCDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 종_퇴사일자 : endRsgtnDt */
		listColumnDefs.add(new ColumnDef("종_퇴사일자", Remt3100BM.ATTR_ENDRSGTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 종_지급일자 : endPymtDt */
		listColumnDefs.add(new ColumnDef("종_지급일자", Remt3100BM.ATTR_ENDPYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 종_근속월수 : endLogSvcMnthIcm */
		listColumnDefs.add(new ColumnDef("종_근속월수", Remt3100BM.ATTR_ENDLOGSVCMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_제외월수_2012이전 : endEepnMnth12Bfr */
		listColumnDefs.add(new ColumnDef("종_제외월수_2012이전", Remt3100BM.ATTR_ENDEEPNMNTH12BFR, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_제외월수_2013이후 : endEepnMnth13Aft */
		listColumnDefs.add(new ColumnDef("종_제외월수_2013이후", Remt3100BM.ATTR_ENDEEPNMNTH13AFT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_가산월수_2012이전 : endAddMnth12Bfr */
		listColumnDefs.add(new ColumnDef("종_가산월수_2012이전", Remt3100BM.ATTR_ENDADDMNTH12BFR, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_가산월수_2013이후 : endAddMnth13Aft */
		listColumnDefs.add(new ColumnDef("종_가산월수_2013이후", Remt3100BM.ATTR_ENDADDMNTH13AFT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_제외월수 : endEepnMnthIcm */
		listColumnDefs.add(new ColumnDef("종_제외월수", Remt3100BM.ATTR_ENDEEPNMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_가산월수 : endAddMnthIcm */
		listColumnDefs.add(new ColumnDef("종_가산월수", Remt3100BM.ATTR_ENDADDMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_중복월수 : endDupMnthIcm */
		listColumnDefs.add(new ColumnDef("종_중복월수", Remt3100BM.ATTR_ENDDUPMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_근속연수 : endLogSvcYrNum */
		listColumnDefs.add(new ColumnDef("종_근속연수", Remt3100BM.ATTR_ENDLOGSVCYRNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_입사일자 : clutIcncDt */
		listColumnDefs.add(new ColumnDef("정산_입사일자", Remt3100BM.ATTR_CLUTICNCDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 정산-기산일자 : clutRkfcdDt */
		listColumnDefs.add(new ColumnDef("정산-기산일자", Remt3100BM.ATTR_CLUTRKFCDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_퇴사일자 : clutRsgtnDt */
		listColumnDefs.add(new ColumnDef("정산_퇴사일자", Remt3100BM.ATTR_CLUTRSGTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_지급일자 : clutPymtDt */
		listColumnDefs.add(new ColumnDef("정산_지급일자", Remt3100BM.ATTR_CLUTPYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_근속월수 : clutLogSvcMnthIcm */
		listColumnDefs.add(new ColumnDef("정산_근속월수", Remt3100BM.ATTR_CLUTLOGSVCMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_제외월수 : clutEepnMnthIcm */
		listColumnDefs.add(new ColumnDef("정산_제외월수", Remt3100BM.ATTR_CLUTEEPNMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_가산월수 : clutAddMnthIcm */
		listColumnDefs.add(new ColumnDef("정산_가산월수", Remt3100BM.ATTR_CLUTADDMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_중복월수 : clutDupMnthIcm */
		listColumnDefs.add(new ColumnDef("정산_중복월수", Remt3100BM.ATTR_CLUTDUPMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_근속연수 : clutLogSvcYrNum */
		listColumnDefs.add(new ColumnDef("정산_근속연수", Remt3100BM.ATTR_CLUTLOGSVCYRNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
		listColumnDefs.add(new ColumnDef("근속안분_2012전_입사일자", Remt3100BM.ATTR_LOGPPNL12BEFICNCDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
		listColumnDefs.add(new ColumnDef("근속안분_2012전_기산일자", Remt3100BM.ATTR_LOGPPNL12BEFRKFCDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
		listColumnDefs.add(new ColumnDef("근속안분_2012전_퇴사일자", Remt3100BM.ATTR_LOGPPNL12BEFRSGTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
		listColumnDefs.add(new ColumnDef("근속안분_2012전_지급일자", Remt3100BM.ATTR_LOGPPNL12BEFPYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
		listColumnDefs.add(new ColumnDef("근속안분_2012전_근속월수", Remt3100BM.ATTR_LOGPPNL12BEFLOGMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
		listColumnDefs.add(new ColumnDef("근속안분_2012전_제외월수", Remt3100BM.ATTR_LOGPPNL12BEFEEPNMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
		listColumnDefs.add(new ColumnDef("근속안분_2012전_가산월수", Remt3100BM.ATTR_LOGPPNL12BEFADDMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
		listColumnDefs.add(new ColumnDef("근속안분_2012전_중복월수", Remt3100BM.ATTR_LOGPPNL12BEFDUPMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
		listColumnDefs.add(new ColumnDef("근속안분_2012전_근속년수", Remt3100BM.ATTR_LOGPPNL12BEFLOGYRNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
		listColumnDefs.add(new ColumnDef("근속안분_2013후_입사일자", Remt3100BM.ATTR_LOGPPNL13AFRICNCDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
		listColumnDefs.add(new ColumnDef("근속안분_2013후_기산일자", Remt3100BM.ATTR_LOGPPNL13AFRRKFCDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
		listColumnDefs.add(new ColumnDef("근속안분_2013후_퇴사일자", Remt3100BM.ATTR_LOGPPNL13AFRRSGTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
		listColumnDefs.add(new ColumnDef("근속안분_2013후_지급일자", Remt3100BM.ATTR_LOGPPNL13AFRPYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
		listColumnDefs.add(new ColumnDef("근속안분_2013후_근속월수", Remt3100BM.ATTR_LOGPPNL13AFRLOGMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
		listColumnDefs.add(new ColumnDef("근속안분_2013후_제외월수", Remt3100BM.ATTR_LOGPPNL13AFREEPNMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
		listColumnDefs.add(new ColumnDef("근속안분_2013후_가산월수", Remt3100BM.ATTR_LOGPPNL13AFRADDMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
		listColumnDefs.add(new ColumnDef("근속안분_2013후_중복월수", Remt3100BM.ATTR_LOGPPNL13AFRDUPMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
		listColumnDefs.add(new ColumnDef("근속안분_2013후_근속연수", Remt3100BM.ATTR_LOGPPNL13AFRLOGSVC, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */
		listColumnDefs.add(new ColumnDef("퇴직소득_중간지급금액", Remt3100BM.ATTR_RETRYINCMCTRPYMTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직소득_종료지급금액 : retryIncmEndPymtSum */
		listColumnDefs.add(new ColumnDef("퇴직소득_종료지급금액", Remt3100BM.ATTR_RETRYINCMENDPYMTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직소득_정산금액 : retryIncmClutSum */
		listColumnDefs.add(new ColumnDef("퇴직소득_정산금액", Remt3100BM.ATTR_RETRYINCMCLUTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
		listColumnDefs.add(new ColumnDef("퇴직소득정률공제_정산금액", Remt3100BM.ATTR_RETRYFXRTDDUCCLUTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속년수공제_정산금액 : logYrDducSum */
		listColumnDefs.add(new ColumnDef("근속년수공제_정산금액", Remt3100BM.ATTR_LOGYRDDUCSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
		listColumnDefs.add(new ColumnDef("퇴직소득과세표준_정산금액", Remt3100BM.ATTR_RETRYTXTNSTDCLUTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
		listColumnDefs.add(new ColumnDef("세액_2012전_과세표준안분금액", Remt3100BM.ATTR_TAT12BEFTXTNSTDPPNLSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
		listColumnDefs.add(new ColumnDef("세액_2012전_연평균과세표준금액", Remt3100BM.ATTR_TAT12BEFYRAVGTXSTDSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
		listColumnDefs.add(new ColumnDef("세액_2012전_환산과세표준금액", Remt3100BM.ATTR_TAT12BEFCVSNTXTNSTDSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
		listColumnDefs.add(new ColumnDef("세액_2012전_환산산출세액금액", Remt3100BM.ATTR_TAT12BEFCVSNCALCAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
		listColumnDefs.add(new ColumnDef("세액_2012전_연평균산출세액", Remt3100BM.ATTR_TAT12BEFYRAVGCALCAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_2012전_산출세액", Remt3100BM.ATTR_TAT12BEFCALCTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_2012전_기납부세액", Remt3100BM.ATTR_TAT12BEFALPAYTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_2012전_신고대상세액", Remt3100BM.ATTR_TAT12BEFREGTGTTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
		listColumnDefs.add(new ColumnDef("세액_2013후_과세표준안분금액", Remt3100BM.ATTR_TAT13AFRTXSTDPPNLSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
		listColumnDefs.add(new ColumnDef("세액_2013후_연평균과세표준금액", Remt3100BM.ATTR_TAT13AFRYRAVGSTDSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
		listColumnDefs.add(new ColumnDef("세액_2013후_환산과세표준금액", Remt3100BM.ATTR_TAT13AFRCVSNTXTNSTDSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_2013후_환산산출세액", Remt3100BM.ATTR_TAT13AFRCVSNCALCTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
		listColumnDefs.add(new ColumnDef("세액_2013후_연평균산출세액", Remt3100BM.ATTR_TAT13AFRYRAVGCALCAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_2013후_산출세액", Remt3100BM.ATTR_TAT13AFRCALCTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_2013후_기납부세액", Remt3100BM.ATTR_TAT13AFRALPAYTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
		listColumnDefs.add(new ColumnDef("세액_2013후_신고대상세액", Remt3100BM.ATTR_TAT13AFRREGRSTTGTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
		listColumnDefs.add(new ColumnDef("세액_합계_과세표준안분금액", Remt3100BM.ATTR_TATAGGRTXTNSTDPPNLSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
		listColumnDefs.add(new ColumnDef("세액_합계_연평균과세표준금액", Remt3100BM.ATTR_TATAGGRYRAVGTXTNSTDSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
		listColumnDefs.add(new ColumnDef("세액_합계_환산과세표준금액", Remt3100BM.ATTR_TATAGGRCVSNTXTNSTDSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_합계_환산산출세액", Remt3100BM.ATTR_TATAGGRCVSNCALCTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_합계_연평균산출세액", Remt3100BM.ATTR_TATAGGRYRAVGCALCTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_합계_산출세액", Remt3100BM.ATTR_TATAGGRCALCTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_합계_기납부세액", Remt3100BM.ATTR_TATAGGRALPAYTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_합계_신고대상세액", Remt3100BM.ATTR_TATAGGRREGRSTTGTTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
		listColumnDefs.add(new ColumnDef("이연세액_신고대상세액", Remt3100BM.ATTR_TALREGRSTTGTTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */
		listColumnDefs.add(new ColumnDef("이연세액_계좌입금합계금액", Remt3100BM.ATTR_TALACCUDEPITAGGRSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 이연세액_퇴직급여액 : talRetryPayQnty */
		listColumnDefs.add(new ColumnDef("이연세액_퇴직급여액", Remt3100BM.ATTR_TALRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
		listColumnDefs.add(new ColumnDef("이연세액_이연퇴직소득세액", Remt3100BM.ATTR_TALRETRYINCMTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
		listColumnDefs.add(new ColumnDef("납부신고대상_소득세액", Remt3100BM.ATTR_PYMTREGTGTINCMTXQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
		listColumnDefs.add(new ColumnDef("납부신고대상_지방소득세액", Remt3100BM.ATTR_PYMTREGTGTRGONINCMQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
		listColumnDefs.add(new ColumnDef("납부신고대상_농어촌특별세액", Remt3100BM.ATTR_PYMTREGTGTFARVILSPCLQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
		listColumnDefs.add(new ColumnDef("납부신고대상_합계금액", Remt3100BM.ATTR_PYMTREGRSTTGTAGGRSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부이연_소득세액 : pymtTalcIncmTxQnty */
		listColumnDefs.add(new ColumnDef("납부이연_소득세액", Remt3100BM.ATTR_PYMTTALCINCMTXQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부이연_지방소득세액 : pymtTalcRgonIncmTxQnty */
		listColumnDefs.add(new ColumnDef("납부이연_지방소득세액", Remt3100BM.ATTR_PYMTTALCRGONINCMTXQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부이연-농어촌특별세액 : pymtTalcFarvilSpclQnty */
		listColumnDefs.add(new ColumnDef("납부이연-농어촌특별세액", Remt3100BM.ATTR_PYMTTALCFARVILSPCLQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부이연_합계금액 : pymtTxAllcAggrSum */
		listColumnDefs.add(new ColumnDef("납부이연_합계금액", Remt3100BM.ATTR_PYMTTXALLCAGGRSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부차감_소득세액 : pymtSubtnIncmTxQnty */
		listColumnDefs.add(new ColumnDef("납부차감_소득세액", Remt3100BM.ATTR_PYMTSUBTNINCMTXQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
		listColumnDefs.add(new ColumnDef("납부차감_지방소득세액", Remt3100BM.ATTR_PYMTSUBTNRGONINCMTXQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
		listColumnDefs.add(new ColumnDef("납부차감_농어촌특별세액", Remt3100BM.ATTR_PYMTSUBTNFARVILSPCLQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부차감_합계금액 : pymtSubtnAggrSum */
		listColumnDefs.add(new ColumnDef("납부차감_합계금액", Remt3100BM.ATTR_PYMTSUBTNAGGRSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Remt3100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Remt3100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Remt3100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Remt3100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Remt3100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Remt3100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});

//private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//private TextField<String> calcSevePsnBlggYrMnth;   /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
//
//private TextField<String> calcSevePayPsnDivCd;   /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//
//private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//private TextField<String> deptCd;   /** column 부서코드 : deptCd */
//
//private TextField<String> hanNm;   /** column 한글성명 : hanNm */
//
//private TextField<String> resnRegnNum;   /** column 주민등록번호 : resnRegnNum */
//
//private TextField<String> aimenrEcteYn;   /** column 소득자임원여부 : aimenrEcteYn */

//private TextField<String> fixPayJnDt;   /** column 확정급여형가입일자 : fixPayJnDt */

//private TextField<String> sevePay20111231Sum;   /** column 퇴직금_20111231금액 : sevePay20111231Sum */
//
//private TextField<String> frgnrDivCd;   /** column 외국인구분코드 : frgnrDivCd */
//
//private TextField<String> ridnSeptYn;   /** column 거주구분여부 : ridnSeptYn */
//
//private TextField<String> ridnCd;   /** column 거주지국코드 : ridnCd */
//
//private TextField<String> ridnNm;   /** column 거주지국명 : ridnNm */
//
//private TextField<String> blggYrBgnnDt;   /** column 귀속년도시작일자 : blggYrBgnnDt */
//
//private TextField<String> blggYrEndDt;   /** column 귀속년도종료일자 : blggYrEndDt */
//
//private TextField<String> retryReasCd;   /** column 퇴직사유코드 : retryReasCd */
//
//private TextField<String> ctrBusoprRgstnNum;   /** column 중_사업자등록번호 : ctrBusoprRgstnNum */
//
//private TextField<String> ctrPaeWorkNm;   /** column 중_근무처명 : ctrPaeWorkNm */
//
//private TextField<String> ctrRetryPayQnty;   /** column 중_퇴직급여액 : ctrRetryPayQnty */
//
//private TextField<String> ctrFreeDtyRetryPayQnty;   /** column 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
//
//private TextField<String> ctrTxtnTgtRetryPayQnty;   /** column 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
//
//private TextField<String> endBusoprRgstnNum;   /** column 종_사업자등록번호 : endBusoprRgstnNum */
//
//private TextField<String> endPaeWorkNm;   /** column 종_근무처명 : endPaeWorkNm */
//
//private TextField<String> endRetryPayQnty;   /** column 종_퇴직급여액 : endRetryPayQnty */
//
//private TextField<String> endFreeDtyRetryPayQnty;   /** column 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
//
//private TextField<String> endTxtnTgtRetryPayQnty;   /** column 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
//
//private TextField<String> clutRetryPayQnty;   /** column 정산_퇴직급여액 : clutRetryPayQnty */
//
//private TextField<String> clutFreeDtyRetryPayQnty;   /** column 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
//
//private TextField<String> clutTxtnTgtRetryPayQnty;   /** column 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
//
//private TextField<String> ctrIcncDt;   /** column 중_입사일자 : ctrIcncDt */
//
//private TextField<String> ctrRkfcdDt;   /** column 중_기산일자 : ctrRkfcdDt */
//
//private TextField<String> ctrRsgtnDt;   /** column 중_퇴사일자 : ctrRsgtnDt */
//
//private TextField<String> ctrPymtDt;   /** column 중_지급일자 : ctrPymtDt */
//
//private TextField<String> ctrLogSvcMnthIcm;   /** column 중_근속월수 : ctrLogSvcMnthIcm */
//
//private TextField<String> ctrEepnMnth12Bfr;   /** column 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
//
//private TextField<String> ctrEepnMnth13Aft;   /** column 중_제외월수_2013이후 : ctrEepnMnth13Aft */
//
//private TextField<String> ctrAddMnth12Bfr;   /** column 중_가산월수_2012이전 : ctrAddMnth12Bfr */
//
//private TextField<String> ctrAddMnth13Aft;   /** column 중_가산월수_2013이후 : ctrAddMnth13Aft */
//
//private TextField<String> ctrEepnMnthIcm;   /** column 중_제외월수 : ctrEepnMnthIcm */
//
//private TextField<String> ctrAddMnthIcm;   /** column 중_가산월수 : ctrAddMnthIcm */
//
//private TextField<String> ctrDupMnthIcm;   /** column 중_중복월수 : ctrDupMnthIcm */
//
//private TextField<String> ctrLogSvc;   /** column 중_근속연수 : ctrLogSvc */
//
//private TextField<String> endIcncDt;   /** column 종_입사일자 : endIcncDt */
//
//private TextField<String> endRkfcdDt;   /** column 종_기산일자 : endRkfcdDt */
//
//private TextField<String> endRsgtnDt;   /** column 종_퇴사일자 : endRsgtnDt */
//
//private TextField<String> endPymtDt;   /** column 종_지급일자 : endPymtDt */
//
//private TextField<String> endLogSvcMnthIcm;   /** column 종_근속월수 : endLogSvcMnthIcm */
//
//private TextField<String> endEepnMnth12Bfr;   /** column 종_제외월수_2012이전 : endEepnMnth12Bfr */
//
//private TextField<String> endEepnMnth13Aft;   /** column 종_제외월수_2013이후 : endEepnMnth13Aft */
//
//private TextField<String> endAddMnth12Bfr;   /** column 종_가산월수_2012이전 : endAddMnth12Bfr */
//
//private TextField<String> endAddMnth13Aft;   /** column 종_가산월수_2013이후 : endAddMnth13Aft */
//
//private TextField<String> endEepnMnthIcm;   /** column 종_제외월수 : endEepnMnthIcm */
//
//private TextField<String> endAddMnthIcm;   /** column 종_가산월수 : endAddMnthIcm */
//
//private TextField<String> endDupMnthIcm;   /** column 종_중복월수 : endDupMnthIcm */
//
//private TextField<String> endLogSvcYrNum;   /** column 종_근속연수 : endLogSvcYrNum */
//
//private TextField<String> clutIcncDt;   /** column 정산_입사일자 : clutIcncDt */
//
//private TextField<String> clutRkfcdDt;   /** column 정산-기산일자 : clutRkfcdDt */
//
//private TextField<String> clutRsgtnDt;   /** column 정산_퇴사일자 : clutRsgtnDt */
//
//private TextField<String> clutPymtDt;   /** column 정산_지급일자 : clutPymtDt */
//
//private TextField<String> clutLogSvcMnthIcm;   /** column 정산_근속월수 : clutLogSvcMnthIcm */
//
//private TextField<String> clutEepnMnthIcm;   /** column 정산_제외월수 : clutEepnMnthIcm */
//
//private TextField<String> clutAddMnthIcm;   /** column 정산_가산월수 : clutAddMnthIcm */
//
//private TextField<String> clutDupMnthIcm;   /** column 정산_중복월수 : clutDupMnthIcm */
//
//private TextField<String> clutLogSvcYrNum;   /** column 정산_근속연수 : clutLogSvcYrNum */
//
//private TextField<String> logPpnl12befIcncDt;   /** column 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
//
//private TextField<String> logPpnl12befRkfcdDt;   /** column 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
//
//private TextField<String> logPpnl12befRsgtnDt;   /** column 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
//
//private TextField<String> logPpnl12befPymtDt;   /** column 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
//
//private TextField<String> logPpnl12befLogMnthIcm;   /** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
//
//private TextField<String> logPpnl12befEepnMnthIcm;   /** column 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
//
//private TextField<String> logPpnl12befAddMnthIcm;   /** column 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
//
//private TextField<String> logPpnl12befDupMnthIcm;   /** column 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
//
//private TextField<String> logPpnl12befLogYrNum;   /** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
//
//private TextField<String> logPpnl13afrIcncDt;   /** column 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
//
//private TextField<String> logPpnl13afrRkfcdDt;   /** column 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
//
//private TextField<String> logPpnl13afrRsgtnDt;   /** column 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
//
//private TextField<String> logPpnl13afrPymtDt;   /** column 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
//
//private TextField<String> logPpnl13afrLogMnthIcm;   /** column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
//
//private TextField<String> logPpnl13afrEepnMnthIcm;   /** column 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
//
//private TextField<String> logPpnl13afrAddMnthIcm;   /** column 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
//
//private TextField<String> logPpnl13afrDupMnthIcm;   /** column 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
//
//private TextField<String> logPpnl13afrLogSvc;   /** column 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
//
//private TextField<String> retryIncmCtrPymtSum;   /** column 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */
//
//private TextField<String> retryIncmEndPymtSum;   /** column 퇴직소득_종료지급금액 : retryIncmEndPymtSum */
//
//private TextField<String> retryIncmClutSum;   /** column 퇴직소득_정산금액 : retryIncmClutSum */
//
//private TextField<String> retryFxrtDducClutSum;   /** column 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
//
//private TextField<String> logYrDducSum;   /** column 근속년수공제_정산금액 : logYrDducSum */
//
//private TextField<String> retryTxtnStdClutSum;   /** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
//
//private TextField<String> tat12befTxtnStdPpnlSum;   /** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
//
//private TextField<String> tat12befYravgTxstdSum;   /** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
//
//private TextField<String> tat12befCvsnTxtnStdSum;   /** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
//
//private TextField<String> tat12befCvsnCalcAmnt;   /** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
//
//private TextField<String> tat12befYrAvgCalcAmnt;   /** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
//
//private TextField<String> tat12befCalcTxAmnt;   /** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */
//
//private TextField<String> tat12befAlpayTxAmnt;   /** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
//
//private TextField<String> tat12befRegTgtTxAmnt;   /** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
//
//private TextField<String> tat13afrTxstdPpnlSum;   /** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
//
//private TextField<String> tat13afrYrAvgStdSum;   /** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
//
//private TextField<String> tat13afrCvsnTxtnStdSum;   /** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
//
//private TextField<String> tat13afrCvsnCalcTxAmnt;   /** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
//
//private TextField<String> tat13afrYrAvgCalcAmnt;   /** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
//
//private TextField<String> tat13afrCalcTxAmnt;   /** column 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
//
//private TextField<String> tat13afrAlpayTxAmnt;   /** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
//
//private TextField<String> tat13afrRegrstTgtSum;   /** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
//
//private TextField<String> tatAggrTxtnStdPpnlSum;   /** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
//
//private TextField<String> tatAggrYrAvgTxtnStdSum;   /** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
//
//private TextField<String> tatAggrCvsnTxtnStdSum;   /** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
//
//private TextField<String> tatAggrCvsnCalcTxAmnt;   /** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
//
//private TextField<String> tatAggrYrAvgCalcTxAmnt;   /** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
//
//private TextField<String> tatAggrCalcTxAmnt;   /** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */
//
//private TextField<String> tatAggrAlpayTxAmnt;   /** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
//
//private TextField<String> tatAggrRegrstTgtTxAmnt;   /** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
//
//private TextField<String> talRegrstTgtTxAmnt;   /** column 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
//
//private TextField<String> talAccuDepitAggrSum;   /** column 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */
//
//private TextField<String> talRetryPayQnty;   /** column 이연세액_퇴직급여액 : talRetryPayQnty */
//
//private TextField<String> talRetryIncmTxAmnt;   /** column 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
//
//private TextField<String> pymtRegTgtIncmTxQnty;   /** column 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
//
//private TextField<String> pymtRegTgtRgonIncmQnty;   /** column 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
//
//private TextField<String> pymtRegTgtFarvilSpclQnty;   /** column 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
//
//private TextField<String> pymtRegrstTgtAggrSum;   /** column 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
//
//private TextField<String> pymtTalcIncmTxQnty;   /** column 납부이연_소득세액 : pymtTalcIncmTxQnty */
//
//private TextField<String> pymtTalcRgonIncmTxQnty;   /** column 납부이연_지방소득세액 : pymtTalcRgonIncmTxQnty */
//
//private TextField<String> pymtTalcFarvilSpclQnty;   /** column 납부이연-농어촌특별세액 : pymtTalcFarvilSpclQnty */
//
//private TextField<String> pymtTxAllcAggrSum;   /** column 납부이연_합계금액 : pymtTxAllcAggrSum */
//
//private TextField<String> pymtSubtnIncmTxQnty;   /** column 납부차감_소득세액 : pymtSubtnIncmTxQnty */
//
//private TextField<String> pymtSubtnRgonIncmTxQnty;   /** column 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
//
//private TextField<String> pymtSubtnFarvilSpclQnty;   /** column 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
//
//private TextField<String> pymtSubtnAggrSum;   /** column 납부차감_합계금액 : pymtSubtnAggrSum */
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
    

    public List<ColumnDef>  getRemt0300ToRemt3100(){
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Remt3100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직정산정산년월 : clutYrMnth */
        listColumnDefs.add(new ColumnDef("정산년월", Remt3100BM.ATTR_CLUTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });  
        /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
        listColumnDefs.add(new ColumnDef("귀속년월", Remt3100BM.ATTR_CALCSEVEPSNBLGGYRMNTH, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        listColumnDefs.add(new ColumnDef("퇴직정산구분코드", Remt3100BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직정산구분 : calcSevePayPsnDivNm */
        listColumnDefs.add(new ColumnDef("정산구분", Remt3100BM.ATTR_CALCSEVEPAYPSNDIVNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Remt3100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Remt3100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** DEPT_NM */
        listColumnDefs.add(new ColumnDef("부서명", Remt3100BM.ATTR_DEPTNM,  ColumnDef.TYPE_STRING, 80, false, true, false){
            {
                
            }
        });
        

		/** column 한글성명 : hanNm */
		listColumnDefs.add(new ColumnDef("성명", Remt3100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 주민등록번호 : resnRegnNum */
		listColumnDefs.add(new ColumnDef("주민등록번호", Remt3100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
        
        /** EMYMT_DIV_CD */
        listColumnDefs.add(new ColumnDef("고용구분코드", Remt3100BM.ATTR_EMYMTDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                 
            }
        });
        /** EMYMT_DIV_NM */
        listColumnDefs.add(new ColumnDef("고용구분", Remt3100BM.ATTR_EMYMTDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                
            }
        });
        
        /** TYP_OCCU_CD */
        listColumnDefs.add(new ColumnDef("직종코드", Remt3100BM.ATTR_TYPOCCUCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                
            }
        });
        /** TYP_OCCU_NM */
        listColumnDefs.add(new ColumnDef("직종", Remt3100BM.ATTR_TYPOCCUNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
               
            }
        });
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Remt3100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });                                           
                                                   
                              
            /** column 직종세 : dtilOccuClsDivNm */
            listColumnDefs.add(new ColumnDef("직종세", Remt3100BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            }); 

        /** BUSIN_CD */
        listColumnDefs.add(new ColumnDef("사업코드", Remt3100BM.ATTR_BUSINCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
               
            }
        });
        /** BUSIN_NM */
        listColumnDefs.add(new ColumnDef("사업", Remt3100BM.ATTR_BUSINNM,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                
            }
        }); 

		 
		/** column 소득자임원여부 : aimenrEcteYn */
		listColumnDefs.add(new ColumnDef("임원여부", Remt3100BM.ATTR_AIMENRECTEYN, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
			{
		
			}
		});
		
		/** column 확정급여형가입일자 : fixPayJnDt */
		listColumnDefs.add(new ColumnDef("확정급여형가입일자", Remt3100BM.ATTR_FIXPAYJNDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{

			}
		});
		/** column 퇴직금_20111231금액 : sevePay20111231Sum */
		listColumnDefs.add(new ColumnDef("퇴직금_20111231금액", Remt3100BM.ATTR_SEVEPAY20111231SUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 외국인구분코드 : frgnrDivCd */
		listColumnDefs.add(new ColumnDef("외국인구분코드", Remt3100BM.ATTR_FRGNRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 거주구분여부 : ridnSeptYn */
		listColumnDefs.add(new ColumnDef("거주구분여부", Remt3100BM.ATTR_RIDNSEPTYN, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
			{
		
			}
		});
		/** column 거주지국코드 : ridnCd */
		listColumnDefs.add(new ColumnDef("거주지국코드", Remt3100BM.ATTR_RIDNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 거주지국명 : ridnNm */
		listColumnDefs.add(new ColumnDef("거주지국명", Remt3100BM.ATTR_RIDNNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 귀속년도시작일자 : blggYrBgnnDt */
		listColumnDefs.add(new ColumnDef("귀속년도시작일자", Remt3100BM.ATTR_BLGGYRBGNNDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 귀속년도종료일자 : blggYrEndDt */
		listColumnDefs.add(new ColumnDef("귀속년도종료일자", Remt3100BM.ATTR_BLGGYRENDDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직사유코드 : retryReasCd */
		listColumnDefs.add(new ColumnDef("퇴직사유코드", Remt3100BM.ATTR_RETRYREASCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 중_사업자등록번호 : ctrBusoprRgstnNum */
		listColumnDefs.add(new ColumnDef("중_사업자등록번호", Remt3100BM.ATTR_CTRBUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 중_근무처명 : ctrPaeWorkNm */
		listColumnDefs.add(new ColumnDef("중_근무처명", Remt3100BM.ATTR_CTRPAEWORKNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 중_퇴직급여액 : ctrRetryPayQnty */
		listColumnDefs.add(new ColumnDef("중_퇴직급여액", Remt3100BM.ATTR_CTRRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
		listColumnDefs.add(new ColumnDef("중_비과세퇴직급여액", Remt3100BM.ATTR_CTRFREEDTYRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
		listColumnDefs.add(new ColumnDef("중_과세대상퇴직급여액", Remt3100BM.ATTR_CTRTXTNTGTRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_사업자등록번호 : endBusoprRgstnNum */
		listColumnDefs.add(new ColumnDef("종_사업자등록번호", Remt3100BM.ATTR_ENDBUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
		/** column 종_근무처명 : endPaeWorkNm */
		listColumnDefs.add(new ColumnDef("종_근무처명", Remt3100BM.ATTR_ENDPAEWORKNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
		
			}
		});
	
		/** column 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
		listColumnDefs.add(new ColumnDef("과세퇴직금", Remt3100BM.ATTR_ENDTXTNTGTRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
		
			}
		});
		/** column 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
		listColumnDefs.add(new ColumnDef("비과세퇴직금", Remt3100BM.ATTR_ENDFREEDTYRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
		
			}
		});
		/** column 종_퇴직급여액 : endRetryPayQnty */
		listColumnDefs.add(new ColumnDef("퇴직급여액", Remt3100BM.ATTR_ENDRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_퇴직급여액 : clutRetryPayQnty */
		listColumnDefs.add(new ColumnDef("정산_퇴직급여액", Remt3100BM.ATTR_CLUTRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
		listColumnDefs.add(new ColumnDef("정산_비과세퇴직급여액", Remt3100BM.ATTR_CLUTFREEDTYRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
		listColumnDefs.add(new ColumnDef("정산_과세대상퇴직급여액", Remt3100BM.ATTR_CLUTTXTNTGTRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_입사일자 : ctrIcncDt */
		listColumnDefs.add(new ColumnDef("중_입사일자", Remt3100BM.ATTR_CTRICNCDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 중_기산일자 : ctrRkfcdDt */
		listColumnDefs.add(new ColumnDef("중_기산일자", Remt3100BM.ATTR_CTRRKFCDDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 중_퇴사일자 : ctrRsgtnDt */
		listColumnDefs.add(new ColumnDef("중_퇴사일자", Remt3100BM.ATTR_CTRRSGTNDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 중_지급일자 : ctrPymtDt */
		listColumnDefs.add(new ColumnDef("중_지급일자", Remt3100BM.ATTR_CTRPYMTDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 중_근속월수 : ctrLogSvcMnthIcm */
		listColumnDefs.add(new ColumnDef("중_근속월수", Remt3100BM.ATTR_CTRLOGSVCMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
		listColumnDefs.add(new ColumnDef("중_제외월수_2012이전", Remt3100BM.ATTR_CTREEPNMNTH12BFR, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_제외월수_2013이후 : ctrEepnMnth13Aft */
		listColumnDefs.add(new ColumnDef("중_제외월수_2013이후", Remt3100BM.ATTR_CTREEPNMNTH13AFT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_가산월수_2012이전 : ctrAddMnth12Bfr */
		listColumnDefs.add(new ColumnDef("중_가산월수_2012이전", Remt3100BM.ATTR_CTRADDMNTH12BFR, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_가산월수_2013이후 : ctrAddMnth13Aft */
		listColumnDefs.add(new ColumnDef("중_가산월수_2013이후", Remt3100BM.ATTR_CTRADDMNTH13AFT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_제외월수 : ctrEepnMnthIcm */
		listColumnDefs.add(new ColumnDef("중_제외월수", Remt3100BM.ATTR_CTREEPNMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_가산월수 : ctrAddMnthIcm */
		listColumnDefs.add(new ColumnDef("중_가산월수", Remt3100BM.ATTR_CTRADDMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_중복월수 : ctrDupMnthIcm */
		listColumnDefs.add(new ColumnDef("중_중복월수", Remt3100BM.ATTR_CTRDUPMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 중_근속연수 : ctrLogSvc */
		listColumnDefs.add(new ColumnDef("중_근속연수", Remt3100BM.ATTR_CTRLOGSVC, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_입사일자 : endIcncDt */
		listColumnDefs.add(new ColumnDef("입사일자", Remt3100BM.ATTR_ENDICNCDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{
		
			}
		});
		/** column 종_기산일자 : endRkfcdDt */
		listColumnDefs.add(new ColumnDef("기산일자", Remt3100BM.ATTR_ENDRKFCDDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{
		
			}
		});
		/** column 종_퇴사일자 : endRsgtnDt */
		listColumnDefs.add(new ColumnDef("퇴사일자", Remt3100BM.ATTR_ENDRSGTNDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{
		
			}
		});
		/** column 종_지급일자 : endPymtDt */
		listColumnDefs.add(new ColumnDef("지급일자", Remt3100BM.ATTR_ENDPYMTDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{
		
			}
		});
		/** column 종_근속월수 : endLogSvcMnthIcm */
		listColumnDefs.add(new ColumnDef("종_근속월수", Remt3100BM.ATTR_ENDLOGSVCMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_제외월수_2012이전 : endEepnMnth12Bfr */
		listColumnDefs.add(new ColumnDef("종_제외월수_2012이전", Remt3100BM.ATTR_ENDEEPNMNTH12BFR, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_제외월수_2013이후 : endEepnMnth13Aft */
		listColumnDefs.add(new ColumnDef("종_제외월수_2013이후", Remt3100BM.ATTR_ENDEEPNMNTH13AFT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_가산월수_2012이전 : endAddMnth12Bfr */
		listColumnDefs.add(new ColumnDef("종_가산월수_2012이전", Remt3100BM.ATTR_ENDADDMNTH12BFR, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_가산월수_2013이후 : endAddMnth13Aft */
		listColumnDefs.add(new ColumnDef("종_가산월수_2013이후", Remt3100BM.ATTR_ENDADDMNTH13AFT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_제외월수 : endEepnMnthIcm */
		listColumnDefs.add(new ColumnDef("종_제외월수", Remt3100BM.ATTR_ENDEEPNMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_가산월수 : endAddMnthIcm */
		listColumnDefs.add(new ColumnDef("종_가산월수", Remt3100BM.ATTR_ENDADDMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_중복월수 : endDupMnthIcm */
		listColumnDefs.add(new ColumnDef("종_중복월수", Remt3100BM.ATTR_ENDDUPMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 종_근속연수 : endLogSvcYrNum */
		listColumnDefs.add(new ColumnDef("종_근속연수", Remt3100BM.ATTR_ENDLOGSVCYRNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_입사일자 : clutIcncDt */
		listColumnDefs.add(new ColumnDef("정산_입사일자", Remt3100BM.ATTR_CLUTICNCDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 정산-기산일자 : clutRkfcdDt */
		listColumnDefs.add(new ColumnDef("정산-기산일자", Remt3100BM.ATTR_CLUTRKFCDDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_퇴사일자 : clutRsgtnDt */
		listColumnDefs.add(new ColumnDef("정산_퇴사일자", Remt3100BM.ATTR_CLUTRSGTNDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_지급일자 : clutPymtDt */
		listColumnDefs.add(new ColumnDef("정산_지급일자", Remt3100BM.ATTR_CLUTPYMTDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_근속월수 : clutLogSvcMnthIcm */
		listColumnDefs.add(new ColumnDef("정산_근속월수", Remt3100BM.ATTR_CLUTLOGSVCMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_제외월수 : clutEepnMnthIcm */
		listColumnDefs.add(new ColumnDef("정산_제외월수", Remt3100BM.ATTR_CLUTEEPNMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_가산월수 : clutAddMnthIcm */
		listColumnDefs.add(new ColumnDef("정산_가산월수", Remt3100BM.ATTR_CLUTADDMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_중복월수 : clutDupMnthIcm */
		listColumnDefs.add(new ColumnDef("정산_중복월수", Remt3100BM.ATTR_CLUTDUPMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 정산_근속연수 : clutLogSvcYrNum */
		listColumnDefs.add(new ColumnDef("정산_근속연수", Remt3100BM.ATTR_CLUTLOGSVCYRNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
		listColumnDefs.add(new ColumnDef("근속안분_2012전_입사일자", Remt3100BM.ATTR_LOGPPNL12BEFICNCDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
		listColumnDefs.add(new ColumnDef("근속안분_2012전_기산일자", Remt3100BM.ATTR_LOGPPNL12BEFRKFCDDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
		listColumnDefs.add(new ColumnDef("근속안분_2012전_퇴사일자", Remt3100BM.ATTR_LOGPPNL12BEFRSGTNDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
		listColumnDefs.add(new ColumnDef("근속안분_2012전_지급일자", Remt3100BM.ATTR_LOGPPNL12BEFPYMTDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
		listColumnDefs.add(new ColumnDef("근속안분_2012전_근속월수", Remt3100BM.ATTR_LOGPPNL12BEFLOGMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
		listColumnDefs.add(new ColumnDef("근속안분_2012전_제외월수", Remt3100BM.ATTR_LOGPPNL12BEFEEPNMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
		listColumnDefs.add(new ColumnDef("근속안분_2012전_가산월수", Remt3100BM.ATTR_LOGPPNL12BEFADDMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
		listColumnDefs.add(new ColumnDef("근속안분_2012전_중복월수", Remt3100BM.ATTR_LOGPPNL12BEFDUPMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
		listColumnDefs.add(new ColumnDef("근속안분_2012전_근속년수", Remt3100BM.ATTR_LOGPPNL12BEFLOGYRNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
		listColumnDefs.add(new ColumnDef("근속안분_2013후_입사일자", Remt3100BM.ATTR_LOGPPNL13AFRICNCDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
		listColumnDefs.add(new ColumnDef("근속안분_2013후_기산일자", Remt3100BM.ATTR_LOGPPNL13AFRRKFCDDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
		listColumnDefs.add(new ColumnDef("근속안분_2013후_퇴사일자", Remt3100BM.ATTR_LOGPPNL13AFRRSGTNDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
		listColumnDefs.add(new ColumnDef("근속안분_2013후_지급일자", Remt3100BM.ATTR_LOGPPNL13AFRPYMTDT, ColumnDef.TYPE_DATE , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
		listColumnDefs.add(new ColumnDef("근속안분_2013후_근속월수", Remt3100BM.ATTR_LOGPPNL13AFRLOGMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
		listColumnDefs.add(new ColumnDef("근속안분_2013후_제외월수", Remt3100BM.ATTR_LOGPPNL13AFREEPNMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
		listColumnDefs.add(new ColumnDef("근속안분_2013후_가산월수", Remt3100BM.ATTR_LOGPPNL13AFRADDMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
		listColumnDefs.add(new ColumnDef("근속안분_2013후_중복월수", Remt3100BM.ATTR_LOGPPNL13AFRDUPMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
		listColumnDefs.add(new ColumnDef("근속안분_2013후_근속연수", Remt3100BM.ATTR_LOGPPNL13AFRLOGSVC, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */
		listColumnDefs.add(new ColumnDef("퇴직소득_중간지급금액", Remt3100BM.ATTR_RETRYINCMCTRPYMTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직소득_종료지급금액 : retryIncmEndPymtSum */
		listColumnDefs.add(new ColumnDef("퇴직소득_종료지급금액", Remt3100BM.ATTR_RETRYINCMENDPYMTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직소득_정산금액 : retryIncmClutSum */
		listColumnDefs.add(new ColumnDef("퇴직소득_정산금액", Remt3100BM.ATTR_RETRYINCMCLUTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
		listColumnDefs.add(new ColumnDef("퇴직소득정률공제_정산금액", Remt3100BM.ATTR_RETRYFXRTDDUCCLUTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 근속년수공제_정산금액 : logYrDducSum */
		listColumnDefs.add(new ColumnDef("근속년수공제_정산금액", Remt3100BM.ATTR_LOGYRDDUCSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
		listColumnDefs.add(new ColumnDef("퇴직소득과세표준_정산금액", Remt3100BM.ATTR_RETRYTXTNSTDCLUTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
		listColumnDefs.add(new ColumnDef("세액_2012전_과세표준안분금액", Remt3100BM.ATTR_TAT12BEFTXTNSTDPPNLSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
		listColumnDefs.add(new ColumnDef("세액_2012전_연평균과세표준금액", Remt3100BM.ATTR_TAT12BEFYRAVGTXSTDSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
		listColumnDefs.add(new ColumnDef("세액_2012전_환산과세표준금액", Remt3100BM.ATTR_TAT12BEFCVSNTXTNSTDSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
		listColumnDefs.add(new ColumnDef("세액_2012전_환산산출세액금액", Remt3100BM.ATTR_TAT12BEFCVSNCALCAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
		listColumnDefs.add(new ColumnDef("세액_2012전_연평균산출세액", Remt3100BM.ATTR_TAT12BEFYRAVGCALCAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_2012전_산출세액", Remt3100BM.ATTR_TAT12BEFCALCTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_2012전_기납부세액", Remt3100BM.ATTR_TAT12BEFALPAYTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_2012전_신고대상세액", Remt3100BM.ATTR_TAT12BEFREGTGTTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
		listColumnDefs.add(new ColumnDef("세액_2013후_과세표준안분금액", Remt3100BM.ATTR_TAT13AFRTXSTDPPNLSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
		listColumnDefs.add(new ColumnDef("세액_2013후_연평균과세표준금액", Remt3100BM.ATTR_TAT13AFRYRAVGSTDSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
		listColumnDefs.add(new ColumnDef("세액_2013후_환산과세표준금액", Remt3100BM.ATTR_TAT13AFRCVSNTXTNSTDSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_2013후_환산산출세액", Remt3100BM.ATTR_TAT13AFRCVSNCALCTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
		listColumnDefs.add(new ColumnDef("세액_2013후_연평균산출세액", Remt3100BM.ATTR_TAT13AFRYRAVGCALCAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_2013후_산출세액", Remt3100BM.ATTR_TAT13AFRCALCTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_2013후_기납부세액", Remt3100BM.ATTR_TAT13AFRALPAYTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
		listColumnDefs.add(new ColumnDef("세액_2013후_신고대상세액", Remt3100BM.ATTR_TAT13AFRREGRSTTGTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
		listColumnDefs.add(new ColumnDef("세액_합계_과세표준안분금액", Remt3100BM.ATTR_TATAGGRTXTNSTDPPNLSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
		listColumnDefs.add(new ColumnDef("세액_합계_연평균과세표준금액", Remt3100BM.ATTR_TATAGGRYRAVGTXTNSTDSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
		listColumnDefs.add(new ColumnDef("세액_합계_환산과세표준금액", Remt3100BM.ATTR_TATAGGRCVSNTXTNSTDSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_합계_환산산출세액", Remt3100BM.ATTR_TATAGGRCVSNCALCTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_합계_연평균산출세액", Remt3100BM.ATTR_TATAGGRYRAVGCALCTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_합계_산출세액", Remt3100BM.ATTR_TATAGGRCALCTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_합계_기납부세액", Remt3100BM.ATTR_TATAGGRALPAYTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
		listColumnDefs.add(new ColumnDef("세액_합계_신고대상세액", Remt3100BM.ATTR_TATAGGRREGRSTTGTTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
		listColumnDefs.add(new ColumnDef("이연세액_신고대상세액", Remt3100BM.ATTR_TALREGRSTTGTTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */
		listColumnDefs.add(new ColumnDef("이연세액_계좌입금합계금액", Remt3100BM.ATTR_TALACCUDEPITAGGRSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 이연세액_퇴직급여액 : talRetryPayQnty */
		listColumnDefs.add(new ColumnDef("이연세액_퇴직급여액", Remt3100BM.ATTR_TALRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
		listColumnDefs.add(new ColumnDef("이연세액_이연퇴직소득세액", Remt3100BM.ATTR_TALRETRYINCMTXAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
		listColumnDefs.add(new ColumnDef("납부신고대상_소득세액", Remt3100BM.ATTR_PYMTREGTGTINCMTXQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
		listColumnDefs.add(new ColumnDef("납부신고대상_지방소득세액", Remt3100BM.ATTR_PYMTREGTGTRGONINCMQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
		listColumnDefs.add(new ColumnDef("납부신고대상_농어촌특별세액", Remt3100BM.ATTR_PYMTREGTGTFARVILSPCLQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
		listColumnDefs.add(new ColumnDef("납부신고대상_합계금액", Remt3100BM.ATTR_PYMTREGRSTTGTAGGRSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부이연_소득세액 : pymtTalcIncmTxQnty */
		listColumnDefs.add(new ColumnDef("납부이연_소득세액", Remt3100BM.ATTR_PYMTTALCINCMTXQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부이연_지방소득세액 : pymtTalcRgonIncmTxQnty */
		listColumnDefs.add(new ColumnDef("납부이연_지방소득세액", Remt3100BM.ATTR_PYMTTALCRGONINCMTXQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부이연-농어촌특별세액 : pymtTalcFarvilSpclQnty */
		listColumnDefs.add(new ColumnDef("납부이연-농어촌특별세액", Remt3100BM.ATTR_PYMTTALCFARVILSPCLQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부이연_합계금액 : pymtTxAllcAggrSum */
		listColumnDefs.add(new ColumnDef("납부이연_합계금액", Remt3100BM.ATTR_PYMTTXALLCAGGRSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부차감_소득세액 : pymtSubtnIncmTxQnty */
		listColumnDefs.add(new ColumnDef("소득세", Remt3100BM.ATTR_PYMTSUBTNINCMTXQNTY, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
		
			}
		});
		/** column 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
		listColumnDefs.add(new ColumnDef("지방소득세", Remt3100BM.ATTR_PYMTSUBTNRGONINCMTXQNTY, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
		
			}
		});
		/** column 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
		listColumnDefs.add(new ColumnDef("농어촌특별세", Remt3100BM.ATTR_PYMTSUBTNFARVILSPCLQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		/** column 납부차감_합계금액 : pymtSubtnAggrSum */
		listColumnDefs.add(new ColumnDef("납부차감_합계금액", Remt3100BM.ATTR_PYMTSUBTNAGGRSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
		
			}
		});
		 
 
        return listColumnDefs;
    }
    
  public List<ColumnDef>  getRemtPymtSubtn0200ToRemt3100(){
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Remt3100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직정산정산년월 : clutYrMnth */
        listColumnDefs.add(new ColumnDef("정산년월", Remt3100BM.ATTR_CLUTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });  
        /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
        listColumnDefs.add(new ColumnDef("귀속년월", Remt3100BM.ATTR_CALCSEVEPSNBLGGYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        listColumnDefs.add(new ColumnDef("퇴직정산구분코드", Remt3100BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
       
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Remt3100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 퇴직정산구분 : calcSevePayPsnDivNm */
        listColumnDefs.add(new ColumnDef("납부명세", Remt3100BM.ATTR_CALCSEVEPAYPSNDIVNM, ColumnDef.TYPE_STRING , 200, true, true, true){
        	{

        	}
        });
		/** column 납부차감_소득세액 : pymtSubtnIncmTxQnty */
		listColumnDefs.add(new ColumnDef("소득세", Remt3100BM.ATTR_PYMTSUBTNINCMTXQNTY, ColumnDef.TYPE_LONG , 110, true, true, true){
			{
		
			}
		});
		/** column 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
		listColumnDefs.add(new ColumnDef("지방소득세", Remt3100BM.ATTR_PYMTSUBTNRGONINCMTXQNTY, ColumnDef.TYPE_LONG , 110, true, true, true){
			{
		
			}
		});
		/** column 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
		listColumnDefs.add(new ColumnDef("농어촌특별세", Remt3100BM.ATTR_PYMTSUBTNFARVILSPCLQNTY, ColumnDef.TYPE_LONG , 110, true, true, true){
			{
		
			}
		});
		/** column 납부차감_합계금액 : pymtSubtnAggrSum */
		listColumnDefs.add(new ColumnDef("합계금액", Remt3100BM.ATTR_PYMTSUBTNAGGRSUM, ColumnDef.TYPE_LONG , 120, true, true, true){
			{
		
			}
		});
		 
 
        return listColumnDefs;
    }
}
