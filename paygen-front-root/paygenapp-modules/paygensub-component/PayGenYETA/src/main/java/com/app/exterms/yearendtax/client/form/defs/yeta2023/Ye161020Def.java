/**
 * 공통화면 팝업 
 */
package com.app.exterms.yearendtax.client.form.defs.yeta2023;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2023.Ye161005BM;
import com.app.exterms.yearendtax.client.dto.yeta2023.Ye161010BM;
import com.app.exterms.yearendtax.client.dto.yeta2023.Ye161020BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Ye161020Def  extends TableDef implements YetaDaoConstants {

	private int row = 0;
//    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    

	public Ye161020Def(String chkPayrDef) {
		// setTitle(PayrLabel.titlePayr0304());

		if ("Ye161020Def".equals(chkPayrDef)) {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETA1900_TO_PYYT0304_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);

			setCheckBoxOnGridRows(true);

			setColumnsDefinition(getYe161020ColumnsList());

		}else if ("YetaP810002".equals(chkPayrDef)) {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETAP810002ToYE161010_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(false);
			setColumnsDefinition(getYetaP810002ToYe161020ColumnsList());

		}else {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETA1900_TO_PYYT0304_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);

			setCheckBoxOnGridRows(true);

			setColumnsDefinition(getYe161020ColumnsList());
		}

	}
    
    

	private List<ColumnDef> getYe161020ColumnsList() {

		row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
	
	    
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
	    /** column 근무기간시작일자 : dtyStrtDt */
	    listColumnDefs.add(new ColumnDef("근무기간시작일자", Ye161020BM.ATTR_DTYSTRTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 근무기간종료일자 : dtyEndDt */
	    listColumnDefs.add(new ColumnDef("근무기간종료일자", Ye161020BM.ATTR_DTYENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
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
	    /** column 입력자 : kybdr */
	    listColumnDefs.add(new ColumnDef("입력자", Ye161020BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 입력일자 : inptDt */
	    listColumnDefs.add(new ColumnDef("입력일자", Ye161020BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 입력주소 : inptAddr */
	    listColumnDefs.add(new ColumnDef("입력주소", Ye161020BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 수정자 : ismt */
	    listColumnDefs.add(new ColumnDef("수정자", Ye161020BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 수정일자 : revnDt */
	    listColumnDefs.add(new ColumnDef("수정일자", Ye161020BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 수정주소 : revnAddr */
	    listColumnDefs.add(new ColumnDef("수정주소", Ye161020BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });

		return listColumnDefs;
	}
    

	private List<ColumnDef> getYetaP810002ToYe161020ColumnsList() {

		row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
	
	    
	    /** column 귀속연도 : yrtxBlggYr */
	    listColumnDefs.add(new ColumnDef("귀속연도", Ye161020BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, false, true, false){
	    	{

	    	}
	    });
	    
	    /** column 연말정산구분코드 : clutSeptCd */
	    listColumnDefs.add(new ColumnDef("정산구분", Ye161020BM.ATTR_CLUTSEPTNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	    	{

	    	}
	    });
	    
	    /** column 당시_고용구분코드 : emymtDivCd */
	    listColumnDefs.add(new ColumnDef("고용구분", Ye161010BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	    	{
	
	    	}
	    });
	    
	    
		  /** column 부서명 : deptCd */
        listColumnDefs.add(new ColumnDef("부서", Ye161010BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, false, true, false){
        	{

        	}
        });
		
        
	    /** column 소득자성명 : fnm */
	    listColumnDefs.add(new ColumnDef("성명", Ye161020BM.ATTR_FNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	    	{

	    	}
	    });
	    
	      /** column 원천세신고부서코드 : whdgTxRegrstDeptCd */
        listColumnDefs.add(new ColumnDef("원천세신고부서", Ye161010BM.ATTR_UTDPOBNM, ColumnDef.TYPE_STRING , 90, false, true, false){
        	{

        	}
        });
        
        /** column 근무기간시작일자 : dtyStrtDt */
	    listColumnDefs.add(new ColumnDef("시작일자", Ye161020BM.ATTR_DTYSTRTDT, ColumnDef.TYPE_DATE, 90, false, true, false){
	    	{

	    	}
	    });
	    /** column 근무기간종료일자 : dtyEndDt */
	    listColumnDefs.add(new ColumnDef("종료일자", Ye161020BM.ATTR_DTYENDDT, ColumnDef.TYPE_DATE , 90, false, true, false){
	    	{

	    	}
	    });
		
		
		
		
		
		//--
	    /** column 사업장코드 : dpobCd */
	    listColumnDefs.add(new ColumnDef("사업장코드", Ye161020BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
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
	    
	    /** column 당시_고용구분코드 : emymtDivCd */
	    listColumnDefs.add(new ColumnDef("당시_고용구분코드", Ye161010BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
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
	    /** column 입력자 : kybdr */
	    listColumnDefs.add(new ColumnDef("입력자", Ye161020BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 입력일자 : inptDt */
	    listColumnDefs.add(new ColumnDef("입력일자", Ye161020BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 입력주소 : inptAddr */
	    listColumnDefs.add(new ColumnDef("입력주소", Ye161020BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 수정자 : ismt */
	    listColumnDefs.add(new ColumnDef("수정자", Ye161020BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 수정일자 : revnDt */
	    listColumnDefs.add(new ColumnDef("수정일자", Ye161020BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 수정주소 : revnAddr */
	    listColumnDefs.add(new ColumnDef("수정주소", Ye161020BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });

		return listColumnDefs;
	}
    

}
