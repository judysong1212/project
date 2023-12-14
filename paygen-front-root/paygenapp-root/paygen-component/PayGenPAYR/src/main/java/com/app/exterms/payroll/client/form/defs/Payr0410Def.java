/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0410BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0410Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    public Payr0410Def(String chkDef){
    	
    	if("PAYRP150002".equals(chkDef)){
    		
    		setTitle(PayrLabel.titlePayr0410());
    		setDaoClass(CLASS_PAYR150002TOPAYR0410_DATA_LIST);
    		setCustomListMethod(CLASS_PAYR150002TOPAYR0410_DATA_LIST);
    		setAutoFillGrid(false); 
    		setShowFilterToolbar(false);
    		setCheckBoxOnGridRows(true);
    		setColumnsDefinition(getPayr150002ToPayr0410());
    		
    	}else if("PAYRP150002TARGET".equals(chkDef)){
    		
    		setTitle(PayrLabel.titlePayr0410());
    		//setDaoClass(CLASS_PAYR150002TOPAYR0410_DATA_LIST);
    		//setCustomListMethod(CLASS_PAYR150002TOPAYR0410_DATA_LIST);
    		setAutoFillGrid(false); 
    		setShowFilterToolbar(false);
    		setCheckBoxOnGridRows(true);
    		setColumnsDefinition(getPayr150002ToTarget());
    		
    	}else if("POPUP_PAYR150003_PAYR0410_COPY_1".equals(chkDef)){
    		
    		setTitle(PayrLabel.titlePayr0410());
    		setDaoClass(CLASS_PAYR150003TOPAYR0410_DATA_LIST);
    		setCustomListMethod(CLASS_PAYR150003TOPAYR0410_DATA_LIST);
    		setAutoFillGrid(false); 
    		setShowFilterToolbar(false);
    		setCheckBoxOnGridRows(true);
    		setColumnsDefinition(getPayr150003ToPayr0410Def());
    		
    	}else if("POPUP_PAYR150003_PAYR0410_COPY_2".equals(chkDef)){
    		
    		setTitle(PayrLabel.titlePayr0410());
    		setDaoClass(CLASS_PAYR150003TOPAYR0410_DATA_LIST);
    		setCustomListMethod(CLASS_PAYR150003TOPAYR0410_DATA_LIST);
    		setAutoFillGrid(false); 
    		setShowFilterToolbar(false);
    		setCheckBoxOnGridRows(true);
    		setColumnsDefinition(getPayr150003ToPayr0410Def());
    		
    	}else{
    		
    		setTitle(PayrLabel.titlePayr0410());
    		setDaoClass(CLASS_PAYR0410_DATA_LIST);
    		setCustomListMethod(CLASS_PAYR0410_DATA_LIST);
    		setAutoFillGrid(false); 
    		setShowFilterToolbar(false);
    		setColumnsDefinition(getPayr0410());
    	}
    }
    	public List<ColumnDef> getPayr0410(){

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0410BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });

        /** column 급여년도 : payYr */
        listColumnDefs.add(new ColumnDef("급여년도", Payr0410BM.ATTR_PAYYR, ColumnDef.TYPE_STRING , 90, true, false, true){
            {
        
            }
        });
         
        /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
        listColumnDefs.add(new ColumnDef("직종등급맵핑일련번호", Payr0410BM.ATTR_TYPOCCUGRDEMPPGSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
            {
        
            }
        });
        /** column 급여항목일련번호 : payrItemSeilNum */
        listColumnDefs.add(new ColumnDef("급여항목일련번호", Payr0410BM.ATTR_PAYRITEMSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
            {
        
            }
        });
        
        
        /** column 급여관리부서코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("급여관리부서코드", Payr0410BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
       
        /** column 급여관리부서코드 : payrMangDeptNm */
        listColumnDefs.add(new ColumnDef("관리부서", Payr0410BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분코드", Payr0410BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 급여구분 : payNm */
        listColumnDefs.add(new ColumnDef("급여구분", Payr0410BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
        
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Payr0410BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 직종코드 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Payr0410BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 급여항목코드 : payrImcd */
        listColumnDefs.add(new ColumnDef("항목코드", Payr0410BM.ATTR_PAYRIMCD, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0410BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 호봉등급 : pyspGrdeNm */
        listColumnDefs.add(new ColumnDef("호봉등급", Payr0410BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        }); 
        
        /** column 직종세코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세코드", Payr0410BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0410BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });                                           
             
        
        
        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Payr0410BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 항목명 : itemNm */
        listColumnDefs.add(new ColumnDef("항목명", Payr0410BM.ATTR_ITEMNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
        /** column 지급공제구분코드 : pymtDducDivCd */
        listColumnDefs.add(new ColumnDef("지급공제구분코드", Payr0410BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 지급공제구분 : pymtDducDivNm */
        listColumnDefs.add(new ColumnDef("지급공제구분", Payr0410BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });

        
        /** column 지급공제유형코드 : pymtDducFrmCd */
        listColumnDefs.add(new ColumnDef("지급공제유형코드", Payr0410BM.ATTR_PYMTDDUCFRMCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        

        /** column 지급공제유형 : pymtDducFrmNm */
        listColumnDefs.add(new ColumnDef("지급공제유형", Payr0410BM.ATTR_PYMTDDUCFRMNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
        /** column 지급공제율 : pymtDducRate */
        listColumnDefs.add(new ColumnDef("지급공제율", Payr0410BM.ATTR_PYMTDDUCRATE, ColumnDef.TYPE_DOUBLE, 90, true, true, true){
        	{

        	}
        });
        /** column 지급공제액 : pymtDducSum */
        listColumnDefs.add(new ColumnDef("지급공제액", Payr0410BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 과세구분코드 : txtnDivCd */
        listColumnDefs.add(new ColumnDef("과세구분코드", Payr0410BM.ATTR_TXTNDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 과세구분 : txtnDivNm */
        listColumnDefs.add(new ColumnDef("과세구분", Payr0410BM.ATTR_TXTNDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        /** column 비과세율 : freeDtyRate */
        listColumnDefs.add(new ColumnDef("비과세율", Payr0410BM.ATTR_FREEDTYRATE, ColumnDef.TYPE_DOUBLE, 90, true, true, true){
        	{

        	}
        });
        /** column 비과세금액 : freeDtySum */
        listColumnDefs.add(new ColumnDef("비과세금액", Payr0410BM.ATTR_FREEDTYSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 1월 : jan */
        listColumnDefs.add(new ColumnDef("1월", Payr0410BM.ATTR_JAN, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
        	{

        	}
        });
        /** column 2월 : feb */
        listColumnDefs.add(new ColumnDef("2월", Payr0410BM.ATTR_FEB, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
        	{

        	}
        });
        /** column 3월 : mar */
        listColumnDefs.add(new ColumnDef("3월", Payr0410BM.ATTR_MAR, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
        	{

        	}
        });
        /** column 4월 : apr */
        listColumnDefs.add(new ColumnDef("4월", Payr0410BM.ATTR_APR, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
        	{

        	}
        });
        /** column 5월 : may */
        listColumnDefs.add(new ColumnDef("5월", Payr0410BM.ATTR_MAY, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
        	{

        	}
        });
        /** column 6월 : jun */
        listColumnDefs.add(new ColumnDef("6월", Payr0410BM.ATTR_JUN, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
        	{

        	}
        });
        /** column 7월 : jul */
        listColumnDefs.add(new ColumnDef("7월", Payr0410BM.ATTR_JUL, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
        	{

        	}
        });
        /** column 8월 : aug */
        listColumnDefs.add(new ColumnDef("8월", Payr0410BM.ATTR_AUG, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
        	{

        	}
        });
        /** column 9월 : sep */
        listColumnDefs.add(new ColumnDef("9월", Payr0410BM.ATTR_SEP, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
        	{

        	}
        });
        /** column 10월 : oct */
        listColumnDefs.add(new ColumnDef("10월", Payr0410BM.ATTR_OCT, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
        	{

        	}
        });
        /** column 11월 : nov */
        listColumnDefs.add(new ColumnDef("11월", Payr0410BM.ATTR_NOV, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
        	{

        	}
        });
        /** column 12월 : dec */
        listColumnDefs.add(new ColumnDef("12월", Payr0410BM.ATTR_DEC, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
        	{

        	}
        });
        /** column 정렬순서 : rngeOrd */
        listColumnDefs.add(new ColumnDef("정렬순서", Payr0410BM.ATTR_RNGEORD, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 급여항목사용여부 : payItemUseYn */
        listColumnDefs.add(new ColumnDef("사용여부", Payr0410BM.ATTR_PAYITEMUSEYN, ColumnDef.TYPE_BOOLEAN, 90, true, true, true){
        	{

        	}
        });
        /** column 항목적용시작일자 : itemApptnBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Payr0410BM.ATTR_ITEMAPPTNBGNNDT, ColumnDef.TYPE_DATE, 90, true, true, true){
        	{

        	}
        });
        /** column 항목적용종료일자 : itemApptnEndDt */
        listColumnDefs.add(new ColumnDef("종료일자", Payr0410BM.ATTR_ITEMAPPTNENDDT, ColumnDef.TYPE_DATE, 90, true, true, true){
        	{

        	}
        });
        /** column 일월액구분코드 : dayMnthAmntDivCd */
        listColumnDefs.add(new ColumnDef("일월액구분코드", Payr0410BM.ATTR_DAYMNTHAMNTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 일월액구분 : dayMnthAmntDivNm */
        listColumnDefs.add(new ColumnDef("일월액구분", Payr0410BM.ATTR_DAYMNTHAMNTDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        
        /** column 계산기준구분코드 : calcStdDivCd */
        listColumnDefs.add(new ColumnDef("계산기준구분코드", Payr0410BM.ATTR_CALCSTDDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });

        /** column 계산기준구분 : calcStdDivNm */
        listColumnDefs.add(new ColumnDef("계산기준구분", Payr0410BM.ATTR_CALCSTDDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        
        /** column 계산수식내용 : calcStdFunc */
        listColumnDefs.add(new ColumnDef("계산수식내용", Payr0410BM.ATTR_CALCSTDFUNC, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Payr0410BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        

        /** column 고용구분 : emymtDivNm */
        listColumnDefs.add(new ColumnDef("고용구분", Payr0410BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });

        
        /** column 통상임금여부 : usalyAmntYn */
        listColumnDefs.add(new ColumnDef("통상임금", Payr0410BM.ATTR_USALYAMNTYN, ColumnDef.TYPE_BOOLEAN, 90, false, true, true){
        	{

        	}
        });
       

        /** column 급여항목비고내용 : payItemNoteCtnt */
        listColumnDefs.add(new ColumnDef("비고", Payr0410BM.ATTR_PAYITEMNOTECTNT, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Payr0410BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Payr0410BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Payr0410BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Payr0410BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Payr0410BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Payr0410BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });


        
        return listColumnDefs;
    }
    	
    	public List<ColumnDef> getPayr150002ToPayr0410(){

            List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
              
            /** column 사업장코드 : dpobCd */
            listColumnDefs.add(new ColumnDef("사업장코드", Payr0410BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
            	{

            	}
            });

            /** column 급여년도 : payYr */
            listColumnDefs.add(new ColumnDef("급여년도", Payr0410BM.ATTR_PAYYR, ColumnDef.TYPE_STRING , 90, true, false, true){
                {
            
                }
            });
             
            /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
            listColumnDefs.add(new ColumnDef("직종등급맵핑일련번호", Payr0410BM.ATTR_TYPOCCUGRDEMPPGSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
                {
            
                }
            });
            /** column 급여항목일련번호 : payrItemSeilNum */
            listColumnDefs.add(new ColumnDef("급여항목일련번호", Payr0410BM.ATTR_PAYRITEMSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
                {
            
                }
            });

            
            /** column 급여항목코드 : payrImcd */
            listColumnDefs.add(new ColumnDef("항목코드", Payr0410BM.ATTR_PAYRIMCD, ColumnDef.TYPE_STRING, 60, true, true, true){
            	{

            	}
            });
            
            
            /** column 항목명 : itemNm */
            listColumnDefs.add(new ColumnDef("항목명", Payr0410BM.ATTR_ITEMNM, ColumnDef.TYPE_STRING, 60, true, true, true){
            	{

            	}
            });
            
            
            /** column 급여구분 : payNm */
            listColumnDefs.add(new ColumnDef("급여구분", Payr0410BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 60, true, true, true){
            	{

            	}
            });
            
            
            /** column 직종코드 : typOccuCd */
            listColumnDefs.add(new ColumnDef("직종코드", Payr0410BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, true, false, true){
            	{

            	}
            });
            
            /** column 직종코드 : typOccuNm */
            listColumnDefs.add(new ColumnDef("직종", Payr0410BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, true, true, true){
            	{

            	}
            });
            
           
            
            
            /** column 직종세코드 : dtilOccuClsDivCd */
            listColumnDefs.add(new ColumnDef("직종세코드", Payr0410BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
            	{

            	}
            });
            
            /** column 직종세통합코드 : dtilOccuInttnCd */
            listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0410BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
            	{

            	}
            });                                           
                 
            
            
            /** column 직종세 : dtilOccuClsDivNm */
            listColumnDefs.add(new ColumnDef("직종세", Payr0410BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
            	{

            	}
            });

            
            /** column 급여항목사용여부 : payItemUseYn */
            listColumnDefs.add(new ColumnDef("생성여부", Payr0410BM.ATTR_CREATEYN, ColumnDef.TYPE_BOOLEAN, 60, true, true, true){
            	{

            	}
            });
          
            
            return listColumnDefs;
        }
    	
    	public List<ColumnDef> getPayr150002ToTarget(){

            List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
              
            /** column 사업장코드 : dpobCd */
            listColumnDefs.add(new ColumnDef("사업장코드", Payr0410BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
            	{

            	}
            });

            /** column 급여년도 : payYr */
            listColumnDefs.add(new ColumnDef("급여년도", Payr0410BM.ATTR_PAYYR, ColumnDef.TYPE_STRING , 90, true, false, true){
                {
            
                }
            });
             
            /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
            listColumnDefs.add(new ColumnDef("직종등급맵핑일련번호", Payr0410BM.ATTR_TYPOCCUGRDEMPPGSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
                {
            
                }
            });
            /** column 급여항목일련번호 : payrItemSeilNum */
            listColumnDefs.add(new ColumnDef("급여항목일련번호", Payr0410BM.ATTR_PAYRITEMSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
                {
            
                }
            });

            
            /** column 급여항목코드 : payrImcd */
            listColumnDefs.add(new ColumnDef("항목코드", Payr0410BM.ATTR_PAYRIMCD, ColumnDef.TYPE_STRING, 60, true, true, true){
            	{

            	}
            });
            
            
            /** column 항목명 : itemNm */
            listColumnDefs.add(new ColumnDef("항목명", Payr0410BM.ATTR_ITEMNM, ColumnDef.TYPE_STRING, 90, true, true, true){
            	{

            	}
            });
            
            
            /** column 급여구분 : payNm */
            listColumnDefs.add(new ColumnDef("급여구분", Payr0410BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 60, true, true, true){
            	{

            	}
            });
            
            
            /** column 직종코드 : typOccuCd */
            listColumnDefs.add(new ColumnDef("직종코드", Payr0410BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, true, false, true){
            	{

            	}
            });
            
            /** column 직종코드 : typOccuNm */
            listColumnDefs.add(new ColumnDef("직종", Payr0410BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, true, true, true){
            	{

            	}
            });
            
           
            
            
            /** column 직종세코드 : dtilOccuClsDivCd */
            listColumnDefs.add(new ColumnDef("직종세코드", Payr0410BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
            	{

            	}
            });
            
            /** column 직종세통합코드 : dtilOccuInttnCd */
            listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0410BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
            	{

            	}
            });                                           
                 
            
            
            /** column 직종세 : dtilOccuClsDivNm */
            listColumnDefs.add(new ColumnDef("직종세", Payr0410BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
            	{

            	}
            });

            
            /** column 급여항목사용여부 : payItemUseYn */
            listColumnDefs.add(new ColumnDef("생성여부", Payr0410BM.ATTR_CREATEYN, ColumnDef.TYPE_BOOLEAN, 60, true, false, true){
            	{

            	}
            });
          
            
            return listColumnDefs;
        }
    	
    	public List<ColumnDef> getPayr150003ToPayr0410Def(){

            List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
              
            /** column 사업장코드 : dpobCd */
            listColumnDefs.add(new ColumnDef("사업장코드", Payr0410BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
            	{

            	}
            });

            /** column 급여년도 : payYr */
            listColumnDefs.add(new ColumnDef("급여년도", Payr0410BM.ATTR_PAYYR, ColumnDef.TYPE_STRING , 90, true, false, true){
                {
            
                }
            });
             
            /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
            listColumnDefs.add(new ColumnDef("직종등급맵핑일련번호", Payr0410BM.ATTR_TYPOCCUGRDEMPPGSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
                {
            
                }
            });
            /** column 급여항목일련번호 : payrItemSeilNum */
            listColumnDefs.add(new ColumnDef("급여항목일련번호", Payr0410BM.ATTR_PAYRITEMSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
                {
            
                }
            });
            
            
            /** column 급여관리부서코드 : payrMangDeptCd */
            listColumnDefs.add(new ColumnDef("급여관리부서코드", Payr0410BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, false, false, true){
                {

                }
            });
           
            /** column 급여관리부서코드 : payrMangDeptNm */
            listColumnDefs.add(new ColumnDef("관리부서", Payr0410BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, false, false, true){
                {

                }
            });
            
            /** column 급여구분코드 : payCd */
            listColumnDefs.add(new ColumnDef("급여구분코드", Payr0410BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });
            
            /** column 급여구분 : payNm */
            listColumnDefs.add(new ColumnDef("급여구분", Payr0410BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 90, true, true, true){
            	{

            	}
            });
            
            
            /** column 직종코드 : typOccuCd */
            listColumnDefs.add(new ColumnDef("직종코드", Payr0410BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, true, false, true){
            	{

            	}
            });
            
            /** column 직종코드 : typOccuNm */
            listColumnDefs.add(new ColumnDef("직종", Payr0410BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, true, false, true){
            	{

            	}
            });
            
            /** column 급여항목코드 : payrImcd */
            listColumnDefs.add(new ColumnDef("항목코드", Payr0410BM.ATTR_PAYRIMCD, ColumnDef.TYPE_STRING, 90, true, true, true){
            	{

            	}
            });
            
            /** column 호봉등급코드 : pyspGrdeCd */
            listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0410BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, true, false, true){
            	{

            	}
            });
            
            /** column 호봉등급 : pyspGrdeNm */
            listColumnDefs.add(new ColumnDef("호봉등급", Payr0410BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            }); 
            
            /** column 직종세코드 : dtilOccuClsDivCd */
            listColumnDefs.add(new ColumnDef("직종세코드", Payr0410BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
            	{

            	}
            });
            
            /** column 직종세통합코드 : dtilOccuInttnCd */
            listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0410BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
            	{

            	}
            });                                           
                 
            
            
            /** column 직종세 : dtilOccuClsDivNm */
            listColumnDefs.add(new ColumnDef("직종세", Payr0410BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });
            
            /** column 항목명 : itemNm */
            listColumnDefs.add(new ColumnDef("항목명", Payr0410BM.ATTR_ITEMNM, ColumnDef.TYPE_STRING, 90, true, true, true){
            	{

            	}
            });
            
            /** column 지급공제구분코드 : pymtDducDivCd */
            listColumnDefs.add(new ColumnDef("지급공제구분코드", Payr0410BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
            	{

            	}
            });
            
            /** column 지급공제구분 : pymtDducDivNm */
            listColumnDefs.add(new ColumnDef("지급공제구분", Payr0410BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
            	{

            	}
            });

            
            /** column 지급공제유형코드 : pymtDducFrmCd */
            listColumnDefs.add(new ColumnDef("지급공제유형코드", Payr0410BM.ATTR_PYMTDDUCFRMCD, ColumnDef.TYPE_STRING, 90, true, false, true){
            	{

            	}
            });
            

            /** column 지급공제유형 : pymtDducFrmNm */
            listColumnDefs.add(new ColumnDef("지급공제유형", Payr0410BM.ATTR_PYMTDDUCFRMNM, ColumnDef.TYPE_STRING, 90, true, true, true){
            	{

            	}
            });
            
            /** column 지급공제율 : pymtDducRate */
            listColumnDefs.add(new ColumnDef("지급공제율", Payr0410BM.ATTR_PYMTDDUCRATE, ColumnDef.TYPE_DOUBLE, 90, true, true, true){
            	{

            	}
            });
            /** column 지급공제액 : pymtDducSum */
            listColumnDefs.add(new ColumnDef("지급공제액", Payr0410BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
            	{

            	}
            });
            /** column 과세구분코드 : txtnDivCd */
            listColumnDefs.add(new ColumnDef("과세구분코드", Payr0410BM.ATTR_TXTNDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
            	{

            	}
            });
            
            /** column 과세구분 : txtnDivNm */
            listColumnDefs.add(new ColumnDef("과세구분", Payr0410BM.ATTR_TXTNDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
            	{

            	}
            });
            /** column 비과세율 : freeDtyRate */
            listColumnDefs.add(new ColumnDef("비과세율", Payr0410BM.ATTR_FREEDTYRATE, ColumnDef.TYPE_DOUBLE, 90, true, true, true){
            	{

            	}
            });
            /** column 비과세금액 : freeDtySum */
            listColumnDefs.add(new ColumnDef("비과세금액", Payr0410BM.ATTR_FREEDTYSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
            	{

            	}
            });
            /** column 1월 : jan */
            listColumnDefs.add(new ColumnDef("1월", Payr0410BM.ATTR_JAN, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
            	{

            	}
            });
            /** column 2월 : feb */
            listColumnDefs.add(new ColumnDef("2월", Payr0410BM.ATTR_FEB, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
            	{

            	}
            });
            /** column 3월 : mar */
            listColumnDefs.add(new ColumnDef("3월", Payr0410BM.ATTR_MAR, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
            	{

            	}
            });
            /** column 4월 : apr */
            listColumnDefs.add(new ColumnDef("4월", Payr0410BM.ATTR_APR, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
            	{

            	}
            });
            /** column 5월 : may */
            listColumnDefs.add(new ColumnDef("5월", Payr0410BM.ATTR_MAY, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
            	{

            	}
            });
            /** column 6월 : jun */
            listColumnDefs.add(new ColumnDef("6월", Payr0410BM.ATTR_JUN, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
            	{

            	}
            });
            /** column 7월 : jul */
            listColumnDefs.add(new ColumnDef("7월", Payr0410BM.ATTR_JUL, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
            	{

            	}
            });
            /** column 8월 : aug */
            listColumnDefs.add(new ColumnDef("8월", Payr0410BM.ATTR_AUG, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
            	{

            	}
            });
            /** column 9월 : sep */
            listColumnDefs.add(new ColumnDef("9월", Payr0410BM.ATTR_SEP, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
            	{

            	}
            });
            /** column 10월 : oct */
            listColumnDefs.add(new ColumnDef("10월", Payr0410BM.ATTR_OCT, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
            	{

            	}
            });
            /** column 11월 : nov */
            listColumnDefs.add(new ColumnDef("11월", Payr0410BM.ATTR_NOV, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
            	{

            	}
            });
            /** column 12월 : dec */
            listColumnDefs.add(new ColumnDef("12월", Payr0410BM.ATTR_DEC, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
            	{

            	}
            });
            /** column 정렬순서 : rngeOrd */
            listColumnDefs.add(new ColumnDef("정렬순서", Payr0410BM.ATTR_RNGEORD, ColumnDef.TYPE_LONG, 90, true, true, true){
            	{

            	}
            });
            /** column 급여항목사용여부 : payItemUseYn */
            listColumnDefs.add(new ColumnDef("사용여부", Payr0410BM.ATTR_PAYITEMUSEYN, ColumnDef.TYPE_BOOLEAN, 90, true, true, true){
            	{

            	}
            });
            /** column 항목적용시작일자 : itemApptnBgnnDt */
            listColumnDefs.add(new ColumnDef("시작일자", Payr0410BM.ATTR_ITEMAPPTNBGNNDT, ColumnDef.TYPE_DATE, 90, true, true, true){
            	{

            	}
            });
            /** column 항목적용종료일자 : itemApptnEndDt */
            listColumnDefs.add(new ColumnDef("종료일자", Payr0410BM.ATTR_ITEMAPPTNENDDT, ColumnDef.TYPE_DATE, 90, true, true, true){
            	{

            	}
            });
            /** column 일월액구분코드 : dayMnthAmntDivCd */
            listColumnDefs.add(new ColumnDef("일월액구분코드", Payr0410BM.ATTR_DAYMNTHAMNTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });
            
            /** column 일월액구분 : dayMnthAmntDivNm */
            listColumnDefs.add(new ColumnDef("일월액구분", Payr0410BM.ATTR_DAYMNTHAMNTDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
            	{

            	}
            });
            
            /** column 계산기준구분코드 : calcStdDivCd */
            listColumnDefs.add(new ColumnDef("계산기준구분코드", Payr0410BM.ATTR_CALCSTDDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });

            /** column 계산기준구분 : calcStdDivNm */
            listColumnDefs.add(new ColumnDef("계산기준구분", Payr0410BM.ATTR_CALCSTDDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
            	{

            	}
            });
            
            /** column 계산수식내용 : calcStdFunc */
            listColumnDefs.add(new ColumnDef("계산수식내용", Payr0410BM.ATTR_CALCSTDFUNC, ColumnDef.TYPE_STRING , 90, true, false, true){
                {

                }
            });
            
            /** column 고용구분코드 : emymtDivCd */
            listColumnDefs.add(new ColumnDef("고용구분코드", Payr0410BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });
            

            /** column 고용구분 : emymtDivNm */
            listColumnDefs.add(new ColumnDef("고용구분", Payr0410BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });

            
            /** column 통상임금여부 : usalyAmntYn */
            listColumnDefs.add(new ColumnDef("통상임금", Payr0410BM.ATTR_USALYAMNTYN, ColumnDef.TYPE_BOOLEAN, 90, false, true, true){
            	{

            	}
            });
           

            /** column 급여항목비고내용 : payItemNoteCtnt */
            listColumnDefs.add(new ColumnDef("비고", Payr0410BM.ATTR_PAYITEMNOTECTNT, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });
            
            
//            /** column 입력자 : kybdr */
//            listColumnDefs.add(new ColumnDef("입력자", Payr0410BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//            	{
    //
//            	}
//            });
//            /** column 입력일자 : inptDt */
//            listColumnDefs.add(new ColumnDef("입력일자", Payr0410BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//            	{
    //
//            	}
//            });
//            /** column 입력주소 : inptAddr */
//            listColumnDefs.add(new ColumnDef("입력주소", Payr0410BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//            	{
    //
//            	}
//            });
//            /** column 수정자 : ismt */
//            listColumnDefs.add(new ColumnDef("수정자", Payr0410BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//            	{
    //
//            	}
//            });
//            /** column 수정일자 : revnDt */
//            listColumnDefs.add(new ColumnDef("수정일자", Payr0410BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//            	{
    //
//            	}
//            });
//            /** column 수정주소 : revnAddr */
//            listColumnDefs.add(new ColumnDef("수정주소", Payr0410BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//            	{
    //
//            	}
//            });


            
            return listColumnDefs;
        }
}
