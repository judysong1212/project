/**
 * 공통화면 팝업 
 */
package com.app.exterms.diligence.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.diligence.client.dto.Dlgn0250BM;
import com.app.exterms.diligence.client.languages.DiligenceConstants;
import com.app.exterms.diligence.shared.DiligenceDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.google.gwt.i18n.client.DateTimeFormat;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Dlgn0250Def  extends TableDef implements DiligenceDaoConstants {

    private int row = 0;
    private DiligenceConstants dlgnLabel = DiligenceConstants.INSTANCE;

    public Dlgn0250Def(){
        setTitle("");
        setDaoClass(CLASS_DLGN0250_DATA_LIST);
        setCustomListMethod(CLASS_DLGN0250_DATA_LIST);
        setAutoFillGrid(false);
        setShowFilterToolbar(false);
        setCheckBoxOnGridRows(true);
        setEditFieldGrid(true);
        setCellModel(true);
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Dlgn0250BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Dlgn0250BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 근태년월 : dilnlazYrMnth */
        listColumnDefs.add(new ColumnDef("근무년월", Dlgn0250BM.ATTR_DILNLAZYRMNTH, ColumnDef.TYPE_STRING , 60, false,true, false){
            {
                setReadOnly(true);
                setTextFdMask("9999.99");
            }
        });
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분", Dlgn0250BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 60, false, false, false){
            {

            }
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분", Dlgn0250BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서", Dlgn0250BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });

        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종", Dlgn0250BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급", Dlgn0250BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세", Dlgn0250BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Dlgn0250BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, false, false, true){
        	{

        	}
        });
        
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업", Dlgn0250BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분", Dlgn0250BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
                setReadOnly(true);
                setEnabled(true);
            }
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분", Dlgn0250BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
                setReadOnly(true);
            }
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서", Dlgn0250BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 90, false, true, false){
            {
                setReadOnly(true);
            }
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종", Dlgn0250BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
                setReadOnly(true);
            }
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급", Dlgn0250BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
                setReadOnly(true);
            }
        });
        /** column 직종세구분코드 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Dlgn0250BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
                setReadOnly(true);
            }
        });
        
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업", Dlgn0250BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
                setReadOnly(true);
            }
        });
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("한글성명", Dlgn0250BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, false){
          {
              setReadOnly(true);
          }
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Dlgn0250BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, false){
          {
              setReadOnly(true);
          }
        });
         
        /** column 주민등록번호 : secRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Dlgn0250BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
          {
              setReadOnly(true);
          }
        });
         
      
        /** column 근무일수 : dilnlazDutyNumDys */
        listColumnDefs.add(new ColumnDef("근무일수", Dlgn0250BM.ATTR_DILNLAZDUTYNUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");  
            	setSelectOnFocus(true);
            }
        });
        /** column 유급휴가일수 : dilnlazPaidHodyNumDys */
        listColumnDefs.add(new ColumnDef("휴가(유급)사용일수", Dlgn0250BM.ATTR_DILNLAZPAIDHODYNUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column 총근무일수 : dilnlazTotDutyNumDys */
        listColumnDefs.add(new ColumnDef("실근무일수", Dlgn0250BM.ATTR_DILNLAZTOTDUTYNUMDYS, ColumnDef.TYPE_STRING , 70, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        
        /** column 총근무시간 : dilnlazTotDutyTm */
        listColumnDefs.add(new ColumnDef("근무시간", Dlgn0250BM.ATTR_DILNLAZTOTDUTYTM, ColumnDef.TYPE_STRING , 70, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        
        /** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
        listColumnDefs.add(new ColumnDef("교통보조일수", Dlgn0250BM.ATTR_DILNLAZTFCASSCSTNUMDYS, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{
        		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
        	}
        });
        /** column 근태_급식비일수 : dilnlazLnchDys */
        listColumnDefs.add(new ColumnDef("급식비일수", Dlgn0250BM.ATTR_DILNLAZLNCHDYS, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{
        		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
        	}
        });
        
        /** column 근태_출장여부 : dilnlazButpYn */
        listColumnDefs.add(new ColumnDef("출장일수", Dlgn0250BM.ATTR_DILNLAZBUTPDYS, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{
        		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
        		setSelectOnFocus(true);
        	}
        });

        /** column 특별휴가일수 : dilnlazSpclHodyNumDys */
        listColumnDefs.add(new ColumnDef("특별휴가", Dlgn0250BM.ATTR_DILNLAZSPCLHODYNUMDYS, ColumnDef.TYPE_STRING , 70, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column 결근일수 : dilnlazAbnceNumDys */
        listColumnDefs.add(new ColumnDef("결근일수", Dlgn0250BM.ATTR_DILNLAZABNCENUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column 결근인정일수 : dilnlazAbnceDutyRcgtnDys */
        listColumnDefs.add(new ColumnDef("결근인정", Dlgn0250BM.ATTR_DILNLAZABNCEDUTYRCGTNDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column 병가일수 : dilnlazSckleaNumDys */
        listColumnDefs.add(new ColumnDef("병가일수", Dlgn0250BM.ATTR_DILNLAZSCKLEANUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column 공가일수 : dilnlazOffvaNumDys */
        listColumnDefs.add(new ColumnDef("공가일수", Dlgn0250BM.ATTR_DILNLAZOFFVANUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column 경조사일수 : dilnlazFmlyEvntNumDys */
        listColumnDefs.add(new ColumnDef("경조사일수", Dlgn0250BM.ATTR_DILNLAZFMLYEVNTNUMDYS, ColumnDef.TYPE_STRING , 70, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column 보건일수 : dilnlazHlthCreNumDys */
        listColumnDefs.add(new ColumnDef("보건일수", Dlgn0250BM.ATTR_DILNLAZHLTHCRENUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
       
       
        
        /** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
        listColumnDefs.add(new ColumnDef("휴일근무", Dlgn0250BM.ATTR_DILNLAZPUBCHODYDUTYNUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        
        
        /** column 총휴일근무시간 : dilnlazPubcHodyDutyTm */
        listColumnDefs.add(new ColumnDef("근무시간", Dlgn0250BM.ATTR_DILNLAZPUBCHODYDUTYTM, ColumnDef.TYPE_STRING , 70, false, false, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            	setReadOnly(true);
            }
        });
        
        /** column 총휴일연장시간 : dilnlazHodyTotNtotTm */
        listColumnDefs.add(new ColumnDef("연장시간", Dlgn0250BM.ATTR_DILNLAZHODYTOTNTOTTM, ColumnDef.TYPE_STRING , 70, false, false, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            	setReadOnly(true);
            }
        });
     
        /** column 총토요근무일수 : dilnlazSatDutyNumDys */
        listColumnDefs.add(new ColumnDef("토요근무", Dlgn0250BM.ATTR_DILNLAZSATDUTYNUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        }); 
        
        /** column 주휴일수 : dilnlazWklyHldyNumDys */
        listColumnDefs.add(new ColumnDef("주휴일수", Dlgn0250BM.ATTR_DILNLAZWKLYHLDYNUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column 유급휴일수 : dilnlazPaidPubcHodyNum */
        listColumnDefs.add(new ColumnDef("연(월)차일수", Dlgn0250BM.ATTR_DILNLAZPAIDPUBCHODYNUM, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        }); 
        
        /** column 연가일수 : dilnlazLvsgNumDys */
        listColumnDefs.add(new ColumnDef("연가(잔여)일수", Dlgn0250BM.ATTR_DILNLAZLVSGNUMDYS, ColumnDef.TYPE_STRING , 90, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
//        /** column 교통보조비일수 : dilnlazTfcAssCstNumDys */
//        listColumnDefs.add(new ColumnDef("교통보조비", Dlgn0250BM.ATTR_DILNLAZTFCASSCSTNUMDYS, ColumnDef.TYPE_STRING , 90, false, true, false){
//            {
//            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
//            	setSelectOnFocus(true);
//            }
//        });
         
     
        /** column 기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
        listColumnDefs.add(new ColumnDef("시간외기본근무", Dlgn0250BM.ATTR_DILNLAZFNDTNTMRSTDUTYTM, ColumnDef.TYPE_STRING , 90, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column 시간외근무시간 : dilnlazTmRstDutyTm */
        listColumnDefs.add(new ColumnDef("시간외근무", Dlgn0250BM.ATTR_DILNLAZTMRSTDUTYTM, ColumnDef.TYPE_STRING , 90, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column 총시간외근무시간 : dilnlazTotTmRstDutyTm */
        listColumnDefs.add(new ColumnDef("총시간외근무시간", Dlgn0250BM.ATTR_DILNLAZTOTTMRSTDUTYTM, ColumnDef.TYPE_STRING , 90, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column 총야근시간 : dilnlazTotNtotTm */
        listColumnDefs.add(new ColumnDef("야간근무", Dlgn0250BM.ATTR_DILNLAZTOTNTOTTM, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        
        /** column 근무시작일자 : dilnlazDutyBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Dlgn0250BM.ATTR_DILNLAZDUTYBGNNDT, ColumnDef.TYPE_DATE , 70, false, true, false){
            {
            	 setMaxLength(10);
         		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
         		setDtFieldMask("9999.99.99");
            }
        });
        /** column 근무종료일자 : dilnlazDutyEndDt */
        listColumnDefs.add(new ColumnDef("종료일자", Dlgn0250BM.ATTR_DILNLAZDUTYENDDT, ColumnDef.TYPE_DATE , 70, false, true, false){
            {
            	 setMaxLength(10);
         		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
         		setDtFieldMask("9999.99.99");
            }
        });
       
        /** column 초과근무시작일자 : dilnlazExceDutyBgnnDt */
        listColumnDefs.add(new ColumnDef("초과근무시작일자", Dlgn0250BM.ATTR_DILNLAZEXCEDUTYBGNNDT, ColumnDef.TYPE_DATE , 90, false, false, false){
            {
            	 setMaxLength(10);
         		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
         		setDtFieldMask("9999.99.99");
            }
        });
        /** column 초과근무종료일자 : dilnlazExceDutyEndDt */
        listColumnDefs.add(new ColumnDef("초과근무종료일자", Dlgn0250BM.ATTR_DILNLAZEXCEDUTYENDDT, ColumnDef.TYPE_DATE , 90, false, false, false){
            {
            	 setMaxLength(10);
         		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
         		setDtFieldMask("9999.99.99");
            }
        });
         
        /** column 총야근일수 : dilnlazTotNtotNumDys */
        listColumnDefs.add(new ColumnDef("총야근일수", Dlgn0250BM.ATTR_DILNLAZTOTNTOTNUMDYS, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
     
       
        
        /** column 마감처리여부 : dilnlazDdlnePrcsYn */
        listColumnDefs.add(new ColumnDef("마감", Dlgn0250BM.ATTR_DILNLAZDDLNEPRCSYN, ColumnDef.TYPE_BOOLEAN , 50, false, true, false){
            {
                setReadOnly(true);
            }
        });
        
        /** column 비고내용 : dilnlazNoteCtnt */
        listColumnDefs.add(new ColumnDef("비고", Dlgn0250BM.ATTR_DILNLAZNOTECTNT, ColumnDef.TYPE_STRING , 90, false, true, false){
            {

            }
        });
       
      
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Dlgn0250BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Dlgn0250BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Dlgn0250BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Dlgn0250BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Dlgn0250BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Dlgn0250BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> dilnlazYrMnth;   /** column 근태년월 : dilnlazYrMnth */
//
//        private TextField<String> payCd;   /** column 급여구분코드 : payCd */
//
//        private TextField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
//
//        private TextField<String> deptCd;   /** column 부서코드 : deptCd */
//
//        private TextField<String> businCd;   /** column 사업코드 : businCd */
//
//        private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
//
//        private TextField<String> dtilOccuClsDivCd;   /** column 직종세구분코드 : dtilOccuClsDivCd */
//
//        private TextField<String> dilnlazDutyBgnnDt;   /** column 근무시작일자 : dilnlazDutyBgnnDt */
//
//        private TextField<String> dilnlazDutyEndDt;   /** column 근무종료일자 : dilnlazDutyEndDt */
//
//        private TextField<String> dilnlazDutyNumDys;   /** column 근무일수 : dilnlazDutyNumDys */
//
//        private TextField<String> dilnlazLvsgNumDys;   /** column 연가일수 : dilnlazLvsgNumDys */
//
//        private TextField<String> dilnlazAbnceNumDys;   /** column 결근일수 : dilnlazAbnceNumDys */
//
//        private TextField<String> dilnlazSckleaNumDys;   /** column 병가일수 : dilnlazSckleaNumDys */
//
//        private TextField<String> dilnlazOffvaNumDys;   /** column 공가일수 : dilnlazOffvaNumDys */
//
//        private TextField<String> dilnlazFmlyEvntNumDys;   /** column 경조사일수 : dilnlazFmlyEvntNumDys */
//
//        private TextField<String> dilnlazHlthCreNumDys;   /** column 보건일수 : dilnlazHlthCreNumDys */
//
//        private TextField<String> dilnlazTotDutyNumDys;   /** column 총근무일수 : dilnlazTotDutyNumDys */
//
//        private TextField<String> dilnlazWklyHldyNumDys;   /** column 주휴일수 : dilnlazWklyHldyNumDys */
//
//        private TextField<String> dilnlazPaidPubcHodyNum;   /** column 유급휴일수 : dilnlazPaidPubcHodyNum */
//
//        private TextField<String> dilnlazDdlnePrcsYn;   /** column 마감처리여부 : dilnlazDdlnePrcsYn */
//
//        private TextField<String> dilnlazNoteCtnt;   /** column 비고내용 : dilnlazNoteCtnt */
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
//        private TextField<String> dilnlazSpclHodyNumDys;   /** column 특별휴가일수 : dilnlazSpclHodyNumDys */
//
//        private TextField<String> dilnlazSatDutyNumDys;   /** column 총토요근무일수 : dilnlazSatDutyNumDys */
//
//        private TextField<String> dilnlazPubcHodyDutyNumDys;   /** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
//
//        private TextField<String> dilnlazAbnceDutyRcgtnDys;   /** column 결근인정일수 : dilnlazAbnceDutyRcgtnDys */
//
//        private TextField<String> pyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
//
//        private TextField<String> dilnlazTotDutyTm;   /** column 총근무시간 : dilnlazTotDutyTm */
//
//        private TextField<String> dilnlazPaidHodyNumDys;   /** column 유급휴가일수 : dilnlazPaidHodyNumDys */
//
//        private TextField<String> dilnlazTfcAssCstNumDys;   /** column 교통보조비일수 : dilnlazTfcAssCstNumDys */    
// 
//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> dilnlazExceDutyYrMnth;   /** column 근태초과근무년월 : dilnlazExceDutyYrMnth */
//
//        private TextField<String> payCd;   /** column 급여구분코드 : payCd */
//
//        private TextField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
//
//        private TextField<String> deptCd;   /** column 부서코드 : deptCd */
//
//        private TextField<String> businCd;   /** column 사업코드 : businCd */
//
//        private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
//
//        private TextField<String> dtilOccuClsDivCd;   /** column 직종세구분코드 : dtilOccuClsDivCd */
//
//        private TextField<String> dilnlazExceDutyBgnnDt;   /** column 초과근무시작일자 : dilnlazExceDutyBgnnDt */
//
//        private TextField<String> dilnlazExceDutyEndDt;   /** column 초과근무종료일자 : dilnlazExceDutyEndDt */
//
//        private TextField<String> dilnlazPubcHodyDutyNumDys;   /** column 휴일근무일수 : dilnlazPubcHodyDutyNumDys */
//
//        private TextField<String> dilnlazSatDutyNumDys;   /** column 토요근무일수 : dilnlazSatDutyNumDys */
//
//        private TextField<String> dilnlazTotNtotNumDys;   /** column 총야근일수 : dilnlazTotNtotNumDys */
//
//        private TextField<String> dilnlazTotNtotTm;   /** column 총야근시간 : dilnlazTotNtotTm */
//
//        private TextField<String> dilnlazFndtnTmRstDutyTm;   /** column 기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
//
//        private TextField<String> dilnlazTmRstDutyTm;   /** column 시간외근무시간 : dilnlazTmRstDutyTm */
//
//        private TextField<String> dilnlazTotTmRstDutyTm;   /** column 총시간외근무시간 : dilnlazTotTmRstDutyTm */
//
//        private TextField<String> dilnlazDdlnePrcsYn;   /** column 마감처리여부 : dilnlazDdlnePrcsYn */
//
//        private TextField<String> dilnlazNoteCtnt;   /** column 비고내용 : dilnlazNoteCtnt */
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
//        private TextField<String> pyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
          
      

        
        setColumnsDefinition(listColumnDefs);
    }
}
