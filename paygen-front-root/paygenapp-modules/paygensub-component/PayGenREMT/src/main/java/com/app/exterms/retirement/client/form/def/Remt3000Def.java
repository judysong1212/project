/**
 * 공통화면 팝업 
 */
package com.app.exterms.retirement.client.form.def;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.retirement.client.dto.Remt3000BM;
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
public class Remt3000Def  extends TableDef implements RemtDaoConstants {

    private int row = 0;
    private RemtConstants RemtLabel = RemtConstants.INSTANCE;

    
    public Remt3000Def(String chkDef){ 
        
    	 if ("REMT0200".equals(chkDef)) {
     	       //퇴직정산 대상자 조회 
      		  setTitle("");
      	      
      	        setDaoClass(CLASS_REMT0200_REMT3000_DATA_LIST);
      	        setCustomListMethod(CLASS_REMT0200_REMT3000_DATA_LIST);
      	        setAutoFillGrid(false);
      	        setShowFilterToolbar(false);
      	       // setCustomListMethod(MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL);
      	        setCheckBoxOnGridRows(true);
      	             
      	        setColumnsDefinition(getRemt0200ToRemt3000Def());
          } else {
      		 
      		 setTitle("");
      	      
             setDaoClass(CLASS_REMT3000_DATA_LIST);
             setCustomListMethod(CLASS_REMT3000_DATA_LIST);
             setAutoFillGrid(false);
             setShowFilterToolbar(false);
            // setCustomListMethod(MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL);
             setCheckBoxOnGridRows(true);
                  
             setColumnsDefinition(getRemt3000Def());
      	 }
    	  
       
        
    } 

    



    public List<ColumnDef> getRemt0200ToRemt3000Def(){
        
         
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Remt3000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Remt3000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        listColumnDefs.add(new ColumnDef("퇴직정산구분코드", Remt3000BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        listColumnDefs.add(new ColumnDef("정산구분", Remt3000BM.ATTR_CALCSEVEPAYPSNDIVNM, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{

        	}
        });
//        /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
//        listColumnDefs.add(new ColumnDef("귀속년월", Remt3000BM.ATTR_CALCSEVEPSNBLGGYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });  
//        
        /** column 퇴직정산정산년월 : clutYrMnth */
        listColumnDefs.add(new ColumnDef("정산년월", Remt3000BM.ATTR_CLUTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });  

        /** HAN_NM */
        listColumnDefs.add(new ColumnDef("성명", Remt3000BM.ATTR_HANNM,  ColumnDef.TYPE_STRING, 50, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row));
            }
        });
        
        /** RESN_REGN_NUM */
        listColumnDefs.add(new ColumnDef("주민등록번호", Remt3000BM.ATTR_RESNREGNNUM,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++));
               // setFormatNumeric("######-#######");
            }
        });
        
        /** CURR_AFFN_DEPT_CD */
        listColumnDefs.add(new ColumnDef("부서", Remt3000BM.ATTR_DEPTCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 100,100));
            }
        });
        /** CURR_AFFN_DEPT_NM */
        listColumnDefs.add(new ColumnDef("부서명", Remt3000BM.ATTR_DEPTNM,  ColumnDef.TYPE_STRING, 80, false, true, false){
            {
                
            }
        });
        
        /** EMYMT_DIV_CD */
        listColumnDefs.add(new ColumnDef("고용구분", Remt3000BM.ATTR_EMYMTDIVCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row, 100));
            }
        });
        /** EMYMT_DIV_NM */
        listColumnDefs.add(new ColumnDef("고용구분", Remt3000BM.ATTR_EMYMTDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(0, row, 10));
            }
        });
        
        /** TYP_OCCU_CD */
        listColumnDefs.add(new ColumnDef("직종", Remt3000BM.ATTR_TYPOCCUCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(2, row++, 10));
            }
        });
        /** TYP_OCCU_NM */
        listColumnDefs.add(new ColumnDef("직종", Remt3000BM.ATTR_TYPOCCUNM,  ColumnDef.TYPE_STRING, 80, false, false, false){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        });
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Remt3000BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });                                           
                                                   
                              
        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Remt3000BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });      

        /** BUSIN_CD */
        listColumnDefs.add(new ColumnDef("사업", Remt3000BM.ATTR_BUSINCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(2, row++, 10));
            }
        });
        /** BUSIN_NM */
        listColumnDefs.add(new ColumnDef("사업", Remt3000BM.ATTR_BUSINNM,  ColumnDef.TYPE_STRING, 80, false, true, true){
            {
                setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
            }
        }); 
        
        /** column 영수일자 : reipDt */
        listColumnDefs.add(new ColumnDef("영수일자", Remt3000BM.ATTR_REIPDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 마감여부 : ddlneYn */
        listColumnDefs.add(new ColumnDef("마감여부", Remt3000BM.ATTR_DDLNEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 마감일자 : ddlneDt */
        listColumnDefs.add(new ColumnDef("마감일자", Remt3000BM.ATTR_DDLNEDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        
//        /** column 퇴직정산제출일자 : calcSevePayPsnSumtDt */
//        listColumnDefs.add(new ColumnDef("제출일자", Remt3000BM.ATTR_CALCSEVEPAYPSNSUMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 대표자성명 : degtrNm */
//        listColumnDefs.add(new ColumnDef("대표자성명", Remt3000BM.ATTR_DEGTRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 법인명_상호 : corpNmFmnm */
//        listColumnDefs.add(new ColumnDef("법인명_상호", Remt3000BM.ATTR_CORPNMFMNM, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 사업자등록번호 : busoprRgstnNum */
//        listColumnDefs.add(new ColumnDef("사업자등록번호", Remt3000BM.ATTR_BUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 주민등록번호 : resnRegnNum */
//        listColumnDefs.add(new ColumnDef("주민등록번호", Remt3000BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 법인번호 : corpNum */
//        listColumnDefs.add(new ColumnDef("법인번호", Remt3000BM.ATTR_CORPNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 소득신고의무자우편번호 : incmRegrstDebrZpcd */
//        listColumnDefs.add(new ColumnDef("소득신고의무자우편번호", Remt3000BM.ATTR_INCMREGRSTDEBRZPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 소득신고의무자기본주소 : incmRegrstDebrFndtnAddr */
//        listColumnDefs.add(new ColumnDef("소득신고의무자기본주소", Remt3000BM.ATTR_INCMREGRSTDEBRFNDTNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 소득신고의무자상세주소 : incmRegrstDebrDtlPatrAddr */
//        listColumnDefs.add(new ColumnDef("소득신고의무자상세주소", Remt3000BM.ATTR_INCMREGRSTDEBRDTLPATRADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 관할세무서코드 : juriTxOffcCd */
//        listColumnDefs.add(new ColumnDef("관할세무서코드", Remt3000BM.ATTR_JURITXOFFCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 제출자구분코드 : pentrCd */
//        listColumnDefs.add(new ColumnDef("제출자구분코드", Remt3000BM.ATTR_PENTRCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 세무대리인번호 : txDeptyNum */
//        listColumnDefs.add(new ColumnDef("세무대리인번호", Remt3000BM.ATTR_TXDEPTYNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 홈텍스ID : hmtxId */
//        listColumnDefs.add(new ColumnDef("홈텍스ID", Remt3000BM.ATTR_HMTXID, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 세무프로그램코드 : txPgmCd */
//        listColumnDefs.add(new ColumnDef("세무프로그램코드", Remt3000BM.ATTR_TXPGMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 담당자부서명 : pernChrgDeptNm */
//        listColumnDefs.add(new ColumnDef("담당자부서명", Remt3000BM.ATTR_PERNCHRGDEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 담당자성명 : pernChrgNm */
//        listColumnDefs.add(new ColumnDef("담당자성명", Remt3000BM.ATTR_PERNCHRGNM, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 담당자전화번호 : pernChrgPhnNum */
//        listColumnDefs.add(new ColumnDef("담당자전화번호", Remt3000BM.ATTR_PERNCHRGPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 징수의무자구분코드 : cllnDebrDivCd */
//        listColumnDefs.add(new ColumnDef("징수의무자구분코드", Remt3000BM.ATTR_CLLNDEBRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
       

//       
        return listColumnDefs;
    }

    public List<ColumnDef> getRemt3000Def(){
        
         
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Remt3000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
//        /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
//        listColumnDefs.add(new ColumnDef("퇴직정산귀속년월", Remt3000BM.ATTR_CALCSEVEPSNBLGGYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
        /** column 퇴직정산정산년월 : clutYrMnth */
        listColumnDefs.add(new ColumnDef("정산년월", Remt3000BM.ATTR_CLUTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });  
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        listColumnDefs.add(new ColumnDef("퇴직정산구분코드", Remt3000BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Remt3000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 영수일자 : reipDt */
        listColumnDefs.add(new ColumnDef("영수일자", Remt3000BM.ATTR_REIPDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 마감여부 : ddlneYn */
        listColumnDefs.add(new ColumnDef("마감여부", Remt3000BM.ATTR_DDLNEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 마감일자 : ddlneDt */
        listColumnDefs.add(new ColumnDef("마감일자", Remt3000BM.ATTR_DDLNEDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직정산제출일자 : calcSevePayPsnSumtDt */
        listColumnDefs.add(new ColumnDef("퇴직정산제출일자", Remt3000BM.ATTR_CALCSEVEPAYPSNSUMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 대표자성명 : degtrNm */
        listColumnDefs.add(new ColumnDef("대표자성명", Remt3000BM.ATTR_DEGTRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인명_상호 : corpNmFmnm */
        listColumnDefs.add(new ColumnDef("법인명_상호", Remt3000BM.ATTR_CORPNMFMNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업자등록번호 : busoprRgstnNum */
        listColumnDefs.add(new ColumnDef("사업자등록번호", Remt3000BM.ATTR_BUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Remt3000BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인번호 : corpNum */
        listColumnDefs.add(new ColumnDef("법인번호", Remt3000BM.ATTR_CORPNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득신고의무자우편번호 : incmRegrstDebrZpcd */
        listColumnDefs.add(new ColumnDef("소득신고의무자우편번호", Remt3000BM.ATTR_INCMREGRSTDEBRZPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득신고의무자기본주소 : incmRegrstDebrFndtnAddr */
        listColumnDefs.add(new ColumnDef("소득신고의무자기본주소", Remt3000BM.ATTR_INCMREGRSTDEBRFNDTNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득신고의무자상세주소 : incmRegrstDebrDtlPatrAddr */
        listColumnDefs.add(new ColumnDef("소득신고의무자상세주소", Remt3000BM.ATTR_INCMREGRSTDEBRDTLPATRADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 관할세무서코드 : juriTxOffcCd */
        listColumnDefs.add(new ColumnDef("관할세무서코드", Remt3000BM.ATTR_JURITXOFFCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 제출자구분코드 : pentrCd */
        listColumnDefs.add(new ColumnDef("제출자구분코드", Remt3000BM.ATTR_PENTRCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세무대리인번호 : txDeptyNum */
        listColumnDefs.add(new ColumnDef("세무대리인번호", Remt3000BM.ATTR_TXDEPTYNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 홈텍스ID : hmtxId */
        listColumnDefs.add(new ColumnDef("홈텍스ID", Remt3000BM.ATTR_HMTXID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세무프로그램코드 : txPgmCd */
        listColumnDefs.add(new ColumnDef("세무프로그램코드", Remt3000BM.ATTR_TXPGMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 담당자부서명 : pernChrgDeptNm */
        listColumnDefs.add(new ColumnDef("담당자부서명", Remt3000BM.ATTR_PERNCHRGDEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 담당자성명 : pernChrgNm */
        listColumnDefs.add(new ColumnDef("담당자성명", Remt3000BM.ATTR_PERNCHRGNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 담당자전화번호 : pernChrgPhnNum */
        listColumnDefs.add(new ColumnDef("담당자전화번호", Remt3000BM.ATTR_PERNCHRGPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 징수의무자구분코드 : cllnDebrDivCd */
        listColumnDefs.add(new ColumnDef("징수의무자구분코드", Remt3000BM.ATTR_CLLNDEBRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Remt3000BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Remt3000BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Remt3000BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Remt3000BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Remt3000BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Remt3000BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> calcSevePsnBlggYrMnth;   /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
//
//        private TextField<String> calcSevePayPsnDivCd;   /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> reipDt;   /** column 영수일자 : reipDt */
//
//        private TextField<String> ddlneYn;   /** column 마감여부 : ddlneYn */
//
//        private TextField<String> ddlneDt;   /** column 마감일자 : ddlneDt */
//
//        private TextField<String> calcSevePayPsnSumtDt;   /** column 퇴직정산제출일자 : calcSevePayPsnSumtDt */
//
//        private TextField<String> degtrNm;   /** column 대표자성명 : degtrNm */
//
//        private TextField<String> corpNmFmnm;   /** column 법인명_상호 : corpNmFmnm */
//
//        private TextField<String> busoprRgstnNum;   /** column 사업자등록번호 : busoprRgstnNum */
//
//        private TextField<String> resnRegnNum;   /** column 주민등록번호 : resnRegnNum */
//
//        private TextField<String> corpNum;   /** column 법인번호 : corpNum */
//
//        private TextField<String> incmRegrstDebrZpcd;   /** column 소득신고의무자우편번호 : incmRegrstDebrZpcd */
//
//        private TextField<String> incmRegrstDebrFndtnAddr;   /** column 소득신고의무자기본주소 : incmRegrstDebrFndtnAddr */
//
//        private TextField<String> incmRegrstDebrDtlPatrAddr;   /** column 소득신고의무자상세주소 : incmRegrstDebrDtlPatrAddr */
//
//        private TextField<String> juriTxOffcCd;   /** column 관할세무서코드 : juriTxOffcCd */
//
//        private TextField<String> pentrCd;   /** column 제출자구분코드 : pentrCd */
//
//        private TextField<String> txDeptyNum;   /** column 세무대리인번호 : txDeptyNum */
//
//        private TextField<String> hmtxId;   /** column 홈텍스ID : hmtxId */
//
//        private TextField<String> txPgmCd;   /** column 세무프로그램코드 : txPgmCd */
//
//        private TextField<String> pernChrgDeptNm;   /** column 담당자부서명 : pernChrgDeptNm */
//
//        private TextField<String> pernChrgNm;   /** column 담당자성명 : pernChrgNm */
//
//        private TextField<String> pernChrgPhnNum;   /** column 담당자전화번호 : pernChrgPhnNum */
//
//        private TextField<String> cllnDebrDivCd;   /** column 징수의무자구분코드 : cllnDebrDivCd */
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
//       
        return listColumnDefs;
    }
}
