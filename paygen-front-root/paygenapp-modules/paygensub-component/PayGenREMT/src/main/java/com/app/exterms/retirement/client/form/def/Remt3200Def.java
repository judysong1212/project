/**
 * 공통화면 팝업 
 */
package com.app.exterms.retirement.client.form.def;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.retirement.client.dto.Remt3200BM;
import com.app.exterms.retirement.client.languages.RemtConstants;
import com.app.exterms.retirement.shared.RemtDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Remt3200Def  extends TableDef implements RemtDaoConstants {

    private int row = 0;
    private RemtConstants RemtLabel = RemtConstants.INSTANCE;

    
    public Remt3200Def(String chkDef){ 
        
  	  if ("REMT0200".equals(chkDef)) {
 	       //퇴직금계산 결과
	  		 setTitle("");
	         setDaoClass(CLASS_REMT0200TOREMT3200_DATA_LIST);
	         setCustomListMethod(CLASS_REMT0200TOREMT3200_DATA_LIST);
	         setAutoFillGrid(true);
	         setShowFilterToolbar(false);
  	         setCheckBoxOnGridRows(true);
  	         setEditFieldGrid(true); 
  	         
  	        setColumnsDefinition(getRemt0200ToRemt3200Def());
    	 }  else {
    		 
    		 setTitle("");
    	      
	           setDaoClass(CLASS_REMT3200_DATA_LIST);
	           setCustomListMethod(CLASS_REMT3200_DATA_LIST);
	           setAutoFillGrid(false);
	           setShowFilterToolbar(false);
	          // setCustomListMethod(MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL);
	           setCheckBoxOnGridRows(true);
	                
	           setColumnsDefinition(getRemt3200Def());
    	 }
  	  
     
      
  }
    

    public List<ColumnDef> getRemt0200ToRemt3200Def(){
       
         
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Remt3200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직정산정산년월 : clutYrMnth */
        listColumnDefs.add(new ColumnDef("정산년월", Remt3200BM.ATTR_CLUTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });  
//        /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
//        listColumnDefs.add(new ColumnDef("귀속년월", Remt3200BM.ATTR_CALCSEVEPSNBLGGYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        listColumnDefs.add(new ColumnDef("퇴직정산구분코드", Remt3200BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Remt3200BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌일련번호 : antyAccuSeilNum */
        listColumnDefs.add(new ColumnDef("번호", Remt3200BM.ATTR_ANTYACCUSEILNUM, ColumnDef.TYPE_LONG , 40, true, true, true){
        	{
               setReadOnly(true);
        	}
        });
        /** column 연금계좌_사업자명 : antyAccuBusoprNm */
        listColumnDefs.add(new ColumnDef("사업자명", Remt3200BM.ATTR_ANTYACCUBUSOPRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 연금계좌_사업자등록번호 : antyAccuBusoprNum */
        listColumnDefs.add(new ColumnDef("사업자등록번호", Remt3200BM.ATTR_ANTYACCUBUSOPRNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
      
        /** column 연금계좌_계좌번호 : antyAccuAccuNum */
        listColumnDefs.add(new ColumnDef("연금계좌", Remt3200BM.ATTR_ANTYACCUACCUNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 연금계좌_입금일자 : antyAccuDepitDt */
        listColumnDefs.add(new ColumnDef("입금일자", Remt3200BM.ATTR_ANTYACCUDEPITDT, ColumnDef.TYPE_DATE , 90, true, true, true){
        	{

        	}
        });
        /** column 연금계좌_입금금액 : antyAccuDepitSum */
        listColumnDefs.add(new ColumnDef("입금금액", Remt3200BM.ATTR_ANTYACCUDEPITSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
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
//        private TextField<String> antyAccuSeilNum;   /** column 연금계좌일련번호 : antyAccuSeilNum */
//
//        private TextField<String> antyAccuBusoprNum;   /** column 연금계좌_사업자등록번호 : antyAccuBusoprNum */
//
//        private TextField<String> antyAccuBusoprNm;   /** column 연금계좌_사업자명 : antyAccuBusoprNm */
//
//        private TextField<String> antyAccuAccuNum;   /** column 연금계좌_계좌번호 : antyAccuAccuNum */
//
//        private TextField<String> antyAccuDepitSum;   /** column 연금계좌_입금금액 : antyAccuDepitSum */
//
//        private TextField<String> antyAccuDepitDt;   /** column 연금계좌_입금일자 : antyAccuDepitDt */
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
   
        return listColumnDefs;
    }

    public List<ColumnDef> getRemt3200Def(){
       
         
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Remt3200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직정산정산년월 : clutYrMnth */
        listColumnDefs.add(new ColumnDef("정산년월", Remt3200BM.ATTR_CLUTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });  
//        /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
//        listColumnDefs.add(new ColumnDef("퇴직정산귀속년월", Remt3200BM.ATTR_CALCSEVEPSNBLGGYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        listColumnDefs.add(new ColumnDef("퇴직정산구분코드", Remt3200BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Remt3200BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌일련번호 : antyAccuSeilNum */
        listColumnDefs.add(new ColumnDef("연금계좌일련번호", Remt3200BM.ATTR_ANTYACCUSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌_사업자등록번호 : antyAccuBusoprNum */
        listColumnDefs.add(new ColumnDef("연금계좌_사업자등록번호", Remt3200BM.ATTR_ANTYACCUBUSOPRNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌_사업자명 : antyAccuBusoprNm */
        listColumnDefs.add(new ColumnDef("연금계좌_사업자명", Remt3200BM.ATTR_ANTYACCUBUSOPRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌_계좌번호 : antyAccuAccuNum */
        listColumnDefs.add(new ColumnDef("연금계좌_계좌번호", Remt3200BM.ATTR_ANTYACCUACCUNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌_입금금액 : antyAccuDepitSum */
        listColumnDefs.add(new ColumnDef("연금계좌_입금금액", Remt3200BM.ATTR_ANTYACCUDEPITSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌_입금일자 : antyAccuDepitDt */
        listColumnDefs.add(new ColumnDef("연금계좌_입금일자", Remt3200BM.ATTR_ANTYACCUDEPITDT, ColumnDef.TYPE_DATE , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Remt3200BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Remt3200BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Remt3200BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Remt3200BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Remt3200BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Remt3200BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
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
//        private TextField<String> antyAccuSeilNum;   /** column 연금계좌일련번호 : antyAccuSeilNum */
//
//        private TextField<String> antyAccuBusoprNum;   /** column 연금계좌_사업자등록번호 : antyAccuBusoprNum */
//
//        private TextField<String> antyAccuBusoprNm;   /** column 연금계좌_사업자명 : antyAccuBusoprNm */
//
//        private TextField<String> antyAccuAccuNum;   /** column 연금계좌_계좌번호 : antyAccuAccuNum */
//
//        private TextField<String> antyAccuDepitSum;   /** column 연금계좌_입금금액 : antyAccuDepitSum */
//
//        private TextField<String> antyAccuDepitDt;   /** column 연금계좌_입금일자 : antyAccuDepitDt */
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
   
        return listColumnDefs;
    }
}
