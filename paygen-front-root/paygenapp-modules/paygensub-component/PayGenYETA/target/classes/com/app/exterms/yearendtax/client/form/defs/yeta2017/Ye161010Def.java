/**
 * 공통화면 팝업 
 */
package com.app.exterms.yearendtax.client.form.defs.yeta2017;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2017.InfcPsnl0100BM;
import com.app.exterms.yearendtax.client.dto.yeta2017.Ye160401BM;
import com.app.exterms.yearendtax.client.dto.yeta2017.Ye161010BM;
import com.app.exterms.yearendtax.client.dto.yeta2017.Ye161020BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Ye161010Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    

	public Ye161010Def(String chkPayrDef) {

		if("Yeta2100".equals(chkPayrDef)){
			setDaoClass("");
			setCustomListMethod(CLASS_YETA2100_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(false);
			
			setColumnsDefinition(getYeta2100ColumnsList());
			
		}else if("YETA2200".equals(chkPayrDef)){
			setDaoClass("");
			setCustomListMethod(CLASS_YETA2200_DATA_LIST);
			setAutoFillGrid(true);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditFieldGrid(false);
			
			setColumnsDefinition(getYeta2200ToYe161010List());
			
		}else if("YETA2300".equals(chkPayrDef)){
			setDaoClass("");
			setCustomListMethod(CLASS_YETA2300_TO_YE161010_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditFieldGrid(false);
			setColumnsDefinition(getYeta2300ToYe161010List());
			
		}else{
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA2200_RESULT_DATA_LIST);
	  	  	setAutoFillGrid(true);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(false); 
		    setEditFieldGrid(false);
		    
		    setColumnsDefinition(getYe161010ColumnsList()); 
		}

	}
	
	private List<ColumnDef> getYeta2100ColumnsList() {

		row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
		
		
		
	    /** column 귀속연도 : yrtxBlggYr */
	    listColumnDefs.add(new ColumnDef("귀속연도", Ye161010BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 150, true, true, true){
	    	{
	
	    	}
	    });
	    
	    /** column 연말정산구분코드 : clutSeptCd */
	    listColumnDefs.add(new ColumnDef("정산구분", Ye161010BM.ATTR_CLUTSEPTNM, ColumnDef.TYPE_STRING , 100, true, true, true){
	    	{
	
	    	}
	    });
	    
	    /** column 부서코드 : deptCd */
	    listColumnDefs.add(new ColumnDef("부서", InfcPsnl0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 150, true, true, true){
	    	{
	
	    	}
	    });  
		
        /** column 한글성명 : fnm */
        listColumnDefs.add(new ColumnDef("성명", Ye161020BM.ATTR_FNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 주민등록번호 : resnoEncCntn */
        listColumnDefs.add(new ColumnDef("주민번호", Ye161020BM.ATTR_RESNOENCCNTN, ColumnDef.TYPE_STRING , 150, true, false, true){
        	{

        	}
        });    
        
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민번호", InfcPsnl0100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
	    /** column 근무기간시작일자 : dtyStrtDt */
	    listColumnDefs.add(new ColumnDef("시작일자", Ye161020BM.ATTR_DTYSTRTDT, ColumnDef.TYPE_STRING , 100, true, true, true){
	    	{

	    	}
	    });
	    /** column 근무기간종료일자 : dtyEndDt */
	    listColumnDefs.add(new ColumnDef("종료일자", Ye161020BM.ATTR_DTYENDDT, ColumnDef.TYPE_STRING , 100, true, true, true){
	    	{

	    	}
	    });
	    
	    
		/** column 급여지급금액총액 : payPymtSumTotAmnt */
		listColumnDefs.add(new ColumnDef("총급여합계(연간)", Ye160401BM.ATTR_PAYPYMTSUMTOTAMNT, ColumnDef.TYPE_LONG, 100, true, true, true){
			{

			}
		});
		
		/** column 현근무지상여금_과세 : buamTxam */
		listColumnDefs.add(new ColumnDef("상여(연간)", Ye160401BM.ATTR_BUAMTXAM, ColumnDef.TYPE_LONG , 100, true, true, true){
			{

			}
		});
		
		/** column 현근무지국민연금금액 : natnPsnf */
		listColumnDefs.add(new ColumnDef("국민연금", Ye160401BM.ATTR_NATNPSNF, ColumnDef.TYPE_LONG , 100, true, true, true){
			{

			}
		});
		
		
		/** column 현근무지건강요양보험료합계금액 : currWorkRcpAggrSum */
		listColumnDefs.add(new ColumnDef("건강보험", Ye160401BM.ATTR_CURRWORKRCPAGGRSUM, ColumnDef.TYPE_LONG , 100, true, true, true){
			{

			}
		});
		
		/** column 현근무지고용보험료금액 : spciEmpf */
		listColumnDefs.add(new ColumnDef("고용보험", Ye160401BM.ATTR_SPCIEMPF, ColumnDef.TYPE_LONG , 100, true, true, true){
			{

			}
		});

		/** column 현근무지소득세 : earnTaxn */
		listColumnDefs.add(new ColumnDef("소득세", Ye160401BM.ATTR_EARNTAXN, ColumnDef.TYPE_LONG , 100, true, true, true){
			{

			}
		});
		/** column 현근무지지방소득세 : ihtxTaxn */
		listColumnDefs.add(new ColumnDef("지방소득세", Ye160401BM.ATTR_IHTXTAXN, ColumnDef.TYPE_LONG , 120, true, true, true){
			{

			}
		});
		
		/** column 현근무지농특세 : nnksSsum */
		listColumnDefs.add(new ColumnDef("농특세", Ye160401BM.ATTR_NNKSSSUM, ColumnDef.TYPE_BIGDECIMAL , 100, true, true, true){
			{

			}
		});
	    
        /** column 재직상태코드 : hdofcCodtnCd */
        listColumnDefs.add(new ColumnDef("재직", InfcPsnl0100BM.ATTR_HDOFCCODTNNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
	    /** column 직종코드 : typOccuCd */
	    listColumnDefs.add(new ColumnDef("직종", InfcPsnl0100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 150, true, true, true){
	    	{
	
	    	}
	    });
	    
	    /** column 직종세구분코드 : dtilOccuClsDivCd */
	    listColumnDefs.add(new ColumnDef("직종세", InfcPsnl0100BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 150, true, true, true){
	    	{
	
	    	}
	    });
        
	    /** column 사업코드 : businCd */
	    listColumnDefs.add(new ColumnDef("사업", InfcPsnl0100BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 150, true, true, true){
	    	{
	
	    	}
	    });        
	    
	    /** column 사업장코드 : dpobCd */
	    listColumnDefs.add(new ColumnDef("사업장코드", Ye161010BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });

	    /** column 연말정산구분코드 : clutSeptCd */
	    listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye161010BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column SYSTEMKEY : systemkey */
	    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye161010BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 급여관리부서코드 : payrMangDeptCd */
	    listColumnDefs.add(new ColumnDef("급여관리부서코드", Ye161010BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 당시_고용구분코드 : emymtDivCd */
	    listColumnDefs.add(new ColumnDef("당시_고용구분코드", Ye161010BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 당시_부서코드 : deptCd */
	    listColumnDefs.add(new ColumnDef("당시_부서코드", Ye161010BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 당시_직종코드 : typOccuCd */
	    listColumnDefs.add(new ColumnDef("당시_직종코드", Ye161010BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 당시_직종세통합코드 : dtilOccuInttnCd */
	    listColumnDefs.add(new ColumnDef("당시_직종세통합코드", Ye161010BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 당시_사업코드 : businCd */
	    listColumnDefs.add(new ColumnDef("당시_사업코드", Ye161010BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 생성직원번호 : pernChrgEmpIdenNum */
	    listColumnDefs.add(new ColumnDef("생성직원번호", Ye161010BM.ATTR_PERNCHRGEMPIDENNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 마감여부 : closFlag */
	    listColumnDefs.add(new ColumnDef("마감여부", Ye161010BM.ATTR_CLOSFLAG, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 마감건수 : closCont */
	    listColumnDefs.add(new ColumnDef("마감건수", Ye161010BM.ATTR_CLOSCONT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 마감일자 : closDate */
	    listColumnDefs.add(new ColumnDef("마감일자", Ye161010BM.ATTR_CLOSDATE, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 연말정산제출일자 : edacPrdt */
	    listColumnDefs.add(new ColumnDef("연말정산제출일자", Ye161010BM.ATTR_EDACPRDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    
	    /** column 사업장코드 : dpobCd */
	    listColumnDefs.add(new ColumnDef("사업장코드", Ye161020BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 귀속연도 : yrtxBlggYr */
	    listColumnDefs.add(new ColumnDef("귀속연도", Ye161020BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 연말정산구분코드 : clutSeptCd */
	    listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye161020BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column SYSTEMKEY : systemkey */
	    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye161020BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 소득자성명 : fnm */
	    listColumnDefs.add(new ColumnDef("소득자성명", Ye161020BM.ATTR_FNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 주민등록번호 : resnoEncCntn */
	    listColumnDefs.add(new ColumnDef("주민등록번호", Ye161020BM.ATTR_RESNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 근무처명 : tnm */
	    listColumnDefs.add(new ColumnDef("근무처명", Ye161020BM.ATTR_TNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 사업자등록번호 : bsnoEncCntn */
	    listColumnDefs.add(new ColumnDef("사업자등록번호", Ye161020BM.ATTR_BSNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 세대주여부 : hshrClCd */
	    listColumnDefs.add(new ColumnDef("세대주여부", Ye161020BM.ATTR_HSHRCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 국적 : rsplNtnInfrNm */
	    listColumnDefs.add(new ColumnDef("국적", Ye161020BM.ATTR_RSPLNTNINFRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 국적코드 : rsplNtnInfrCd */
	    listColumnDefs.add(new ColumnDef("국적코드", Ye161020BM.ATTR_RSPLNTNINFRCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 감면기간시작일자 : reStrtDt */
	    listColumnDefs.add(new ColumnDef("감면기간시작일자", Ye161020BM.ATTR_RESTRTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 감면기간종료일자 : reEndDt */
	    listColumnDefs.add(new ColumnDef("감면기간종료일자", Ye161020BM.ATTR_REENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 거주구분 : rsdtClCd */
	    listColumnDefs.add(new ColumnDef("거주구분", Ye161020BM.ATTR_RSDTCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 거주지국명 : rsplNtnNm */
	    listColumnDefs.add(new ColumnDef("거주지국명", Ye161020BM.ATTR_RSPLNTNNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 거주지코드 : rsplNtnCd */
	    listColumnDefs.add(new ColumnDef("거주지코드", Ye161020BM.ATTR_RSPLNTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 소득세원천징수세액조정구분코드 : inctxWhtxTxamtMetnCd */
	    listColumnDefs.add(new ColumnDef("소득세원천징수세액조정구분코드", Ye161020BM.ATTR_INCTXWHTXTXAMTMETNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 분납신청여부 : inpmYn */
	    listColumnDefs.add(new ColumnDef("분납신청여부", Ye161020BM.ATTR_INPMYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 인적공제항목변동여부 : prifChngYn */
	    listColumnDefs.add(new ColumnDef("인적공제항목변동여부", Ye161020BM.ATTR_PRIFCHNGYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 기본공제인원수 : bscDdcnFpCnt */
	    listColumnDefs.add(new ColumnDef("기본공제인원수", Ye161020BM.ATTR_BSCDDCNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 경로우대인원수 : sccNfpCnt */
	    listColumnDefs.add(new ColumnDef("경로우대인원수", Ye161020BM.ATTR_SCCNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 출산입양인원수 : chbtAdopNfpCnt */
	    listColumnDefs.add(new ColumnDef("출산입양인원수", Ye161020BM.ATTR_CHBTADOPNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 부녀자인원수 : wmnNfpCnt */
	    listColumnDefs.add(new ColumnDef("부녀자인원수", Ye161020BM.ATTR_WMNNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 한부모인원수 : snprntNfpCnt */
	    listColumnDefs.add(new ColumnDef("한부모인원수", Ye161020BM.ATTR_SNPRNTNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 자애인인원수 : dsbrNfpCnt */
	    listColumnDefs.add(new ColumnDef("자애인인원수", Ye161020BM.ATTR_DSBRNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 6세이하인원수 : age6ltNfpCnt */
	    listColumnDefs.add(new ColumnDef("6세이하인원수", Ye161020BM.ATTR_AGE6LTNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 소득공제신고전자파일제출여부 : fileSbtYn */
	    listColumnDefs.add(new ColumnDef("소득공제신고전자파일제출여부", Ye161020BM.ATTR_FILESBTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 소득공제신고전자파일적용여부 : fileAppYn */
	    listColumnDefs.add(new ColumnDef("소득공제신고전자파일적용여부", Ye161020BM.ATTR_FILEAPPYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 서식코드 : formCd */
	    listColumnDefs.add(new ColumnDef("서식코드", Ye161020BM.ATTR_FORMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 발급일자일련번호 : issDtSeilNum */
	    listColumnDefs.add(new ColumnDef("발급일자일련번호", Ye161020BM.ATTR_ISSDTSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{

	    	}
	    });    

		return listColumnDefs;
	}
	
	private List<ColumnDef> getYeta2200ToYe161010List() {

		row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
		
		
		/** column 부서코드 : deptCd */
	    listColumnDefs.add(new ColumnDef("부서", InfcPsnl0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, true, true, true){
	    	{
	
	    	}
	    }); 
		
	    /** column 귀속연도 : yrtxBlggYr */
	    listColumnDefs.add(new ColumnDef("귀속연도", Ye161010BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 60, true, false, true){
	    	{
	
	    	}
	    });
	    
	    /** column 한글성명 : fnm */
        listColumnDefs.add(new ColumnDef("성명", Ye161020BM.ATTR_FNM, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{
        		
        	}
        });
        
        /** column 생년월일 : yoobhMnthDay */
        listColumnDefs.add(new ColumnDef("생년월일", InfcPsnl0100BM.ATTR_YOOBHMNTHDAY, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{
        		
        	}
        });
        
        /** column 제출구분 : fileSbtNm */
        listColumnDefs.add(new ColumnDef("신고서", Ye161020BM.ATTR_DDCFILESBTNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{
        		
        	}
        });
        
        /** column 제출구분 : fileSbtNm */
        listColumnDefs.add(new ColumnDef("자료", Ye161020BM.ATTR_FILESBTNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{
        		
        	}
        });
	    
	    /** column 연말정산구분코드 : clutSeptCd */
	    listColumnDefs.add(new ColumnDef("정산구분코드", Ye161010BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 70, true, false, true){
	    	{
	
	    	}
	    });
	    
	    /** column 연말정산구분코드 : clutSeptCd */
	    listColumnDefs.add(new ColumnDef("정산구분", Ye161010BM.ATTR_CLUTSEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	    		
	    	}
	    });
        
        /** column 주민등록번호 : resnoEncCntn */
        listColumnDefs.add(new ColumnDef("주민번호", Ye161020BM.ATTR_RESNOENCCNTN, ColumnDef.TYPE_STRING , 150, true, false, true){
        	{

        	}
        });    
        
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민번호", InfcPsnl0100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 100, true, false, true){
        	{

        	}
        });
        
	    /** column 근무기간시작일자 : dtyStrtDt */
	    listColumnDefs.add(new ColumnDef("시작일자", Ye161020BM.ATTR_DTYSTRTDT, ColumnDef.TYPE_STRING , 100, true, false, true){
	    	{

	    	}
	    });
	    /** column 근무기간종료일자 : dtyEndDt */
	    listColumnDefs.add(new ColumnDef("종료일자", Ye161020BM.ATTR_DTYENDDT, ColumnDef.TYPE_STRING , 100, true, false, true){
	    	{

	    	}
	    });
	    
	    
		/** column 급여지급금액총액 : payPymtSumTotAmnt */
		listColumnDefs.add(new ColumnDef("급여총액", Ye160401BM.ATTR_PAYPYMTSUMTOTAMNT, ColumnDef.TYPE_LONG, 100, true, false, true){
			{

			}
		});
		
		/** column 현근무지상여금_과세 : buamTxam */
		listColumnDefs.add(new ColumnDef("상여총액", Ye160401BM.ATTR_BUAMTXAM, ColumnDef.TYPE_LONG , 100, true, false, true){
			{

			}
		});
		
		/** column 현근무지국민연금금액 : natnPsnf */
		listColumnDefs.add(new ColumnDef("국민연금", Ye160401BM.ATTR_NATNPSNF, ColumnDef.TYPE_LONG , 100, true, false, true){
			{

			}
		});
		
		
		/** column 현근무지건강요양보험료합계금액 : currWorkRcpAggrSum */
		listColumnDefs.add(new ColumnDef("건강보험", Ye160401BM.ATTR_CURRWORKRCPAGGRSUM, ColumnDef.TYPE_LONG , 100, true, false, true){
			{

			}
		});
		
		/** column 현근무지고용보험료금액 : spciEmpf */
		listColumnDefs.add(new ColumnDef("고용보험", Ye160401BM.ATTR_SPCIEMPF, ColumnDef.TYPE_LONG , 100, true, false, true){
			{

			}
		});

		/** column 현근무지소득세 : earnTaxn */
		listColumnDefs.add(new ColumnDef("소득세", Ye160401BM.ATTR_EARNTAXN, ColumnDef.TYPE_LONG , 100, true, false, true){
			{

			}
		});
		/** column 현근무지지방소득세 : ihtxTaxn */
		listColumnDefs.add(new ColumnDef("지방소득세", Ye160401BM.ATTR_IHTXTAXN, ColumnDef.TYPE_LONG , 120, true, false, true){
			{

			}
		});
		
		/** column 현근무지농특세 : nnksSsum */
		listColumnDefs.add(new ColumnDef("농특세", Ye160401BM.ATTR_NNKSSSUM, ColumnDef.TYPE_BIGDECIMAL , 100, true, false, true){
			{

			}
		});
	    
        /** column 재직상태코드 : hdofcCodtnCd */
        listColumnDefs.add(new ColumnDef("재직", InfcPsnl0100BM.ATTR_HDOFCCODTNNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
	    /** column 직종코드 : typOccuCd */
	    listColumnDefs.add(new ColumnDef("직종", InfcPsnl0100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    
	    /** column 직종세구분코드 : dtilOccuClsDivCd */
	    listColumnDefs.add(new ColumnDef("직종세", InfcPsnl0100BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
        
	    /** column 사업코드 : businCd */
	    listColumnDefs.add(new ColumnDef("사업", InfcPsnl0100BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });        
	    
	    /** column 사업장코드 : dpobCd */
	    listColumnDefs.add(new ColumnDef("사업장코드", Ye161010BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });

	    /** column 연말정산구분코드 : clutSeptCd */
	    listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye161010BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column SYSTEMKEY : systemkey */
	    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye161010BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 급여관리부서코드 : payrMangDeptCd */
	    listColumnDefs.add(new ColumnDef("급여관리부서코드", Ye161010BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 당시_고용구분코드 : emymtDivCd */
	    listColumnDefs.add(new ColumnDef("당시_고용구분코드", Ye161010BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 당시_부서코드 : deptCd */
	    listColumnDefs.add(new ColumnDef("당시_부서코드", Ye161010BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 당시_직종코드 : typOccuCd */
	    listColumnDefs.add(new ColumnDef("당시_직종코드", Ye161010BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 당시_직종세통합코드 : dtilOccuInttnCd */
	    listColumnDefs.add(new ColumnDef("당시_직종세통합코드", Ye161010BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 당시_사업코드 : businCd */
	    listColumnDefs.add(new ColumnDef("당시_사업코드", Ye161010BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 생성직원번호 : pernChrgEmpIdenNum */
	    listColumnDefs.add(new ColumnDef("생성직원번호", Ye161010BM.ATTR_PERNCHRGEMPIDENNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 마감여부 : closFlag */
	    listColumnDefs.add(new ColumnDef("마감여부", Ye161010BM.ATTR_CLOSFLAG, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 마감건수 : closCont */
	    listColumnDefs.add(new ColumnDef("마감건수", Ye161010BM.ATTR_CLOSCONT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 마감일자 : closDate */
	    listColumnDefs.add(new ColumnDef("마감일자", Ye161010BM.ATTR_CLOSDATE, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 연말정산제출일자 : edacPrdt */
	    listColumnDefs.add(new ColumnDef("연말정산제출일자", Ye161010BM.ATTR_EDACPRDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    
	    /** column 사업장코드 : dpobCd */
	    listColumnDefs.add(new ColumnDef("사업장코드", Ye161020BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 귀속연도 : yrtxBlggYr */
	    listColumnDefs.add(new ColumnDef("귀속연도", Ye161020BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 연말정산구분코드 : clutSeptCd */
	    listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye161020BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column SYSTEMKEY : systemkey */
	    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye161020BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 소득자성명 : fnm */
	    listColumnDefs.add(new ColumnDef("소득자성명", Ye161020BM.ATTR_FNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 주민등록번호 : resnoEncCntn */
	    listColumnDefs.add(new ColumnDef("주민등록번호", Ye161020BM.ATTR_RESNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 근무처명 : tnm */
	    listColumnDefs.add(new ColumnDef("근무처명", Ye161020BM.ATTR_TNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 사업자등록번호 : bsnoEncCntn */
	    listColumnDefs.add(new ColumnDef("사업자등록번호", Ye161020BM.ATTR_BSNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 세대주여부 : hshrClCd */
	    listColumnDefs.add(new ColumnDef("세대주여부", Ye161020BM.ATTR_HSHRCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 국적 : rsplNtnInfrNm */
	    listColumnDefs.add(new ColumnDef("국적", Ye161020BM.ATTR_RSPLNTNINFRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 국적코드 : rsplNtnInfrCd */
	    listColumnDefs.add(new ColumnDef("국적코드", Ye161020BM.ATTR_RSPLNTNINFRCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 감면기간시작일자 : reStrtDt */
	    listColumnDefs.add(new ColumnDef("감면기간시작일자", Ye161020BM.ATTR_RESTRTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 감면기간종료일자 : reEndDt */
	    listColumnDefs.add(new ColumnDef("감면기간종료일자", Ye161020BM.ATTR_REENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 거주구분 : rsdtClCd */
	    listColumnDefs.add(new ColumnDef("거주구분", Ye161020BM.ATTR_RSDTCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 거주지국명 : rsplNtnNm */
	    listColumnDefs.add(new ColumnDef("거주지국명", Ye161020BM.ATTR_RSPLNTNNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 거주지코드 : rsplNtnCd */
	    listColumnDefs.add(new ColumnDef("거주지코드", Ye161020BM.ATTR_RSPLNTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 소득세원천징수세액조정구분코드 : inctxWhtxTxamtMetnCd */
	    listColumnDefs.add(new ColumnDef("소득세원천징수세액조정구분코드", Ye161020BM.ATTR_INCTXWHTXTXAMTMETNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 분납신청여부 : inpmYn */
	    listColumnDefs.add(new ColumnDef("분납신청여부", Ye161020BM.ATTR_INPMYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 인적공제항목변동여부 : prifChngYn */
	    listColumnDefs.add(new ColumnDef("인적공제항목변동여부", Ye161020BM.ATTR_PRIFCHNGYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 기본공제인원수 : bscDdcnFpCnt */
	    listColumnDefs.add(new ColumnDef("기본공제인원수", Ye161020BM.ATTR_BSCDDCNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 경로우대인원수 : sccNfpCnt */
	    listColumnDefs.add(new ColumnDef("경로우대인원수", Ye161020BM.ATTR_SCCNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 출산입양인원수 : chbtAdopNfpCnt */
	    listColumnDefs.add(new ColumnDef("출산입양인원수", Ye161020BM.ATTR_CHBTADOPNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 부녀자인원수 : wmnNfpCnt */
	    listColumnDefs.add(new ColumnDef("부녀자인원수", Ye161020BM.ATTR_WMNNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 한부모인원수 : snprntNfpCnt */
	    listColumnDefs.add(new ColumnDef("한부모인원수", Ye161020BM.ATTR_SNPRNTNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 자애인인원수 : dsbrNfpCnt */
	    listColumnDefs.add(new ColumnDef("자애인인원수", Ye161020BM.ATTR_DSBRNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 6세이하인원수 : age6ltNfpCnt */
	    listColumnDefs.add(new ColumnDef("6세이하인원수", Ye161020BM.ATTR_AGE6LTNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 소득공제신고전자파일제출여부 : fileSbtYn */
	    listColumnDefs.add(new ColumnDef("소득공제신고전자파일제출여부", Ye161020BM.ATTR_FILESBTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 소득공제신고전자파일적용여부 : fileAppYn */
	    listColumnDefs.add(new ColumnDef("소득공제신고전자파일적용여부", Ye161020BM.ATTR_FILEAPPYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 서식코드 : formCd */
	    listColumnDefs.add(new ColumnDef("서식코드", Ye161020BM.ATTR_FORMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 발급일자일련번호 : issDtSeilNum */
	    listColumnDefs.add(new ColumnDef("발급일자일련번호", Ye161020BM.ATTR_ISSDTSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{

	    	}
	    });    

		return listColumnDefs;
	}
	
	private List<ColumnDef> getYe161010ColumnsList() {

		row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
	
	    
	    /** column 소등공제구분코드 : commCd */
        listColumnDefs.add(new ColumnDef("소등공제구분", Ye161020BM.ATTR_COMMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		
        	}
        });
        
        /** column 소등공제구분 : commNm */
        listColumnDefs.add(new ColumnDef("소등공제구분", Ye161020BM.ATTR_COMMNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		
        	}
        });
        
        /** column 제출일자 :  */
        listColumnDefs.add(new ColumnDef("제출일자", Ye161020BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		
        	}
        });
        
        /** column 제출여부 :  */
        listColumnDefs.add(new ColumnDef("제출여부", Ye161020BM.ATTR_FILESBTYN, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		
        	}
        });
        
        /** column 정산반영 :  */
        listColumnDefs.add(new ColumnDef("정산반영", Ye161020BM.ATTR_PDFDATAPPYN, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		
        	}
        });
        	    

		return listColumnDefs;
	}
	
	private List<ColumnDef> getYeta2300ToYe161010List() {

		row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
		
		
		  /** column 부서명 : deptCd */
        listColumnDefs.add(new ColumnDef("부서", Ye161010BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", InfcPsnl0100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", InfcPsnl0100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        

        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종", Ye161010BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세", Ye161010BM.ATTR_DTILOCCUINTTNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
		
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업", Ye161010BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
		
		//-- 
		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Ye161010BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 귀속연도 : yrtxBlggYr */
		listColumnDefs.add(new ColumnDef("귀속연도", Ye161010BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 연말정산구분코드 : clutSeptCd */
		listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye161010BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye161010BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 급여관리부서코드 : payrMangDeptCd */
		listColumnDefs.add(new ColumnDef("급여관리부서코드", Ye161010BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 당시_고용구분코드 : emymtDivCd */
		listColumnDefs.add(new ColumnDef("당시_고용구분코드", Ye161010BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 당시_부서코드 : deptCd */
		listColumnDefs.add(new ColumnDef("당시_부서코드", Ye161010BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 당시_직종코드 : typOccuCd */
		listColumnDefs.add(new ColumnDef("당시_직종코드", Ye161010BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		
		/** column 당시_직종코드 : typOccuCd */
		listColumnDefs.add(new ColumnDef("당시_직종코드", Ye161010BM.ATTR_TYPNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		
		
		/** column 당시_직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("당시_직종세통합코드", Ye161010BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 당시_사업코드 : businCd */
		listColumnDefs.add(new ColumnDef("당시_사업코드", Ye161010BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 생성직원번호 : pernChrgEmpIdenNum */
		listColumnDefs.add(new ColumnDef("생성직원번호", Ye161010BM.ATTR_PERNCHRGEMPIDENNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 마감 : closFlag */
		listColumnDefs.add(new ColumnDef("마감여부", Ye161010BM.ATTR_CLOSFLAG, ColumnDef.TYPE_BOOLEAN, 90, false, true, false){
			{

			}
		});
		/** column 마감건수 : closCont */
		listColumnDefs.add(new ColumnDef("마감건수", Ye161010BM.ATTR_CLOSCONT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 마감일자 : closDate */
		listColumnDefs.add(new ColumnDef("마감일자", Ye161010BM.ATTR_CLOSDATE, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 연말정산제출일자 : edacPrdt */
		listColumnDefs.add(new ColumnDef("연말정산제출일자", Ye161010BM.ATTR_EDACPRDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Ye161010BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Ye161010BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Ye161010BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Ye161010BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Ye161010BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Ye161010BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 단위사업장코드 : utDpobCd */
		listColumnDefs.add(new ColumnDef("단위사업장코드", Ye161010BM.ATTR_UTDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});

		return listColumnDefs;
	}
	

}
