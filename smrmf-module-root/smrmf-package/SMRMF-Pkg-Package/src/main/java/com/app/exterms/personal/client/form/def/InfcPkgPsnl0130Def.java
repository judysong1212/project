/**
 * 공통화면 팝업 
 */
package com.app.exterms.personal.client.form.def;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.basis.client.dto.InfcPkgBass0300DTO;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class InfcPkgPsnl0130Def  extends TableDef { //implements PayrDaoConstants {

    private int row = 0;
   // private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    final InfcPkgBass0300DTO sysComBass0300Dto;
    
    public InfcPkgPsnl0130Def(String chkDef){
    	
    	 sysComBass0300Dto = new InfcPkgBass0300DTO(); 
    	 
    	 setTitle("");
    	 
    	  if ("PAYR4100".equals(chkDef)) {
    	        setDaoClass("");
    	      //  setCustomListMethod(CLASS_PAYR1700_DAO_LIST);
    	        setAutoFillGrid(false);
    	        setShowFilterToolbar(false);
    	        setCheckBoxOnGridRows(true); 
    	        setEditFieldGrid(true);
    	       // setEditableGrid(true);
               
            //  setColumnsDefinition(getPayr4100ToPsnl0130());
              
          } else if ("".equals(chkDef)) {
              
              setDaoClass("");
            //  setCustomListMethod(CLASS_PAYR1700_DAO_LIST);
              setAutoFillGrid(false);
              setShowFilterToolbar(false);
              setCheckBoxOnGridRows(true); 
              setEditFieldGrid(true);
             // setEditableGrid(true);
            //  setColumnsDefinition(getPsnl0130());
              
          } else  if ("REMT0100".equals(chkDef)) {
  	        setDaoClass("");
  	       // setCustomListMethod(CLASS_PAYR1700_DAO_LIST);
  	        setAutoFillGrid(false);
  	        setShowFilterToolbar(false);
  	        setCheckBoxOnGridRows(true); 
  	       // setEditFieldGrid(true);
  	       // setEditableGrid(true);
             
            setColumnsDefinition(getRemt0100ToPsnl0130());
            
          } else  if ("REMT0102".equals(chkDef)) {
    	        setDaoClass("");
    	       // setCustomListMethod(CLASS_PAYR1700_DAO_LIST);
    	        setAutoFillGrid(false);
    	        setShowFilterToolbar(false);
    	        setCheckBoxOnGridRows(true); 
    	       // setEditFieldGrid(true);
    	       // setEditableGrid(true);
               
              setColumnsDefinition(getRemt0101ToPsnl0130());
              
          } else  if ("REMT0103".equals(chkDef)) {
  	        setDaoClass("");
  	       // setCustomListMethod(CLASS_PAYR1700_DAO_LIST);
  	        setAutoFillGrid(false);
  	        setShowFilterToolbar(false);
  	        setCheckBoxOnGridRows(true); 
  	       // setEditFieldGrid(true);
  	       // setEditableGrid(true);
             
            setColumnsDefinition(getRemt0103ToPsnl0130());   
        } 
    	    
    }       
     
//	  public List<ColumnDef> getPsnl0130(){
//	      List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
//          
//	      
//	        /** column SYSTEMKEY : systemkey */
//	        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0130BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, false, false, false){
//	            {
//
//	            }
//	        });
//	        /** column 사업장코드 : dpobCd */
//	        listColumnDefs.add(new ColumnDef("사업장코드", Psnl0130BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, false){
//	            {
//
//	            }
//	        });
//	        sysComBass0300Dto.setRpsttvCd("B015"); 
//	        /** column 급여구분코드 : payCd */
//	        listColumnDefs.add(new ColumnListDef("급여구분", Psnl0130BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, true, false,  new LookupSysComBass0300(sysComBass0300Dto),SysComBass0300BM.ATTR_COMMCD,SysComBass0300BM.ATTR_COMMCDNM){
//	            {
//
//	            }
//	        });
//	        /** column 급여구분 : payNm */
//	        listColumnDefs.add(new ColumnDef("급여구분", Psnl0130BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 90, false, false, true){
//	            {
//
//	            }
//	        });
//	        sysComBass0300Dto.setRpsttvCd("B001"); 
//	        /** column 은행코드 : bnkCd */
//	        listColumnDefs.add(new ColumnListDef("은행", Psnl0130BM.ATTR_BNKCD, ColumnDef.TYPE_STRING , 90, true, true, false,  new LookupSysComBass0300(sysComBass0300Dto),SysComBass0300BM.ATTR_COMMCD,SysComBass0300BM.ATTR_COMMCDNM){
//	            {
//
//	            }
//	        });
//	        /** column 은행 : bnkNm */
//	        listColumnDefs.add(new ColumnDef("은행명", Psnl0130BM.ATTR_BNKNM, ColumnDef.TYPE_STRING , 90, false, false, false){
//	            {
//
//	            }
//	        });
//	        /** column 은행계좌번호 : bnkAccuNum */
//	        listColumnDefs.add(new ColumnDef("계좌번호", Psnl0130BM.ATTR_BNKACCUNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
//	            {
//
//	            }
//	        });
//	        /** column 예금주명 : acntHodrNm */
//	        listColumnDefs.add(new ColumnDef("예금주", Psnl0130BM.ATTR_ACNTHODRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
//	            {
//
//	            }
//	        });
//	        /** column 대표계좌여부 : rpsttvAccuYn */
//	        listColumnDefs.add(new ColumnDef("대표계좌", Psnl0130BM.ATTR_RPSTTVACCUYN, ColumnDef.TYPE_BOOLEAN , 60, false, true, true){
//	            {
//
//	            }
//	        });
//	        /** column 계좌비고내용 : accuNoteCtnt */
//	        listColumnDefs.add(new ColumnDef("비고", Psnl0130BM.ATTR_ACCUNOTECTNT, ColumnDef.TYPE_STRING , 100, false, true, true){
//	            {
//
//	            }
//	        });
////    	        /** column 입력자 : kybdr */
////    	        listColumnDefs.add(new ColumnDef("입력자", Psnl0130BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
////    	          {
//	//
////    	          }
////    	        });
////    	        /** column 입력일자 : inptDt */
////    	        listColumnDefs.add(new ColumnDef("입력일자", Psnl0130BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
////    	          {
//	//
////    	          }
////    	        });
////    	        /** column 입력주소 : inptAddr */
////    	        listColumnDefs.add(new ColumnDef("입력주소", Psnl0130BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
////    	          {
//	//
////    	          }
////    	        });
////    	        /** column 수정자 : ismt */
////    	        listColumnDefs.add(new ColumnDef("수정자", Psnl0130BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
////    	          {
//	//
////    	          }
////    	        });
////    	        /** column 수정일자 : revnDt */
////    	        listColumnDefs.add(new ColumnDef("수정일자", Psnl0130BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
////    	          {
//	//
////    	          }
////    	        });
////    	        /** column 수정주소 : revnAddr */
////    	        listColumnDefs.add(new ColumnDef("수정주소", Psnl0130BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
////    	          {
//	//
////    	          }
////    	        });
//
////    	        private TextField<String> systemkey   /** column SYSTEMKEY : systemkey */
//	//
////    	        private TextField<String> dpobCd   /** column 사업장코드 : dpobCd */
//	//
////    	        private TextField<String> payCd   /** column 급여구분코드 : payCd */
//	//
////    	        private TextField<String> bnkCd   /** column 은행코드 : bnkCd */
//	//
////    	        private TextField<String> bnkAccuNum   /** column 은행계좌번호 : bnkAccuNum */
//	//
////    	        private TextField<String> acntHodrNm   /** column 예금주명 : acntHodrNm */
//	//
////    	        private TextField<String> rpsttvAccuYn   /** column 대표계좌여부 : rpsttvAccuYn */
//	//
////    	        private TextField<String> accuNoteCtnt   /** column 계좌비고내용 : accuNoteCtnt */
//	//
////    	        private TextField<String> kybdr   /** column 입력자 : kybdr */
//	//
////    	        private TextField<String> inptDt   /** column 입력일자 : inptDt */
//	//
////    	        private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
//	//
////    	        private TextField<String> ismt   /** column 수정자 : ismt */
//	//
////    	        private TextField<String> revnDt   /** column 수정일자 : revnDt */
//	//
////    	        private TextField<String> revnAddr   /** column 수정주소 : revnAddr */
//
//	        
//
//	        
//	        return listColumnDefs;
//	  }
	  
	   
//	  public List<ColumnDef> getPayr4100ToPsnl0130(){
//          List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
//          
//          
//            /** column SYSTEMKEY : systemkey */
//            listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0130BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, false, false, false){
//                {
//
//                }
//            });
//            /** column 사업장코드 : dpobCd */
//            listColumnDefs.add(new ColumnDef("사업장코드", Psnl0130BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, false){
//                {
//
//                }
//            });
//            sysComBass0300Dto.setRpsttvCd("B015"); 
//            /** column 급여구분코드 : payCd */
//            listColumnDefs.add(new ColumnListDef("급여구분", Psnl0130BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, true, false,  new LookupSysComBass0300(sysComBass0300Dto),SysComBass0300BM.ATTR_COMMCD,SysComBass0300BM.ATTR_COMMCDNM){
//                {
//
//                }
//            });
//            /** column 급여구분 : payNm */
//            listColumnDefs.add(new ColumnDef("급여구분", Psnl0130BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 90, false, false, true){
//                {
//
//                }
//            });
//            sysComBass0300Dto.setRpsttvCd("B001"); 
//            /** column 은행코드 : bnkCd */
//            listColumnDefs.add(new ColumnListDef("은행", Psnl0130BM.ATTR_BNKCD, ColumnDef.TYPE_STRING , 90, true, true, false,  new LookupSysComBass0300(sysComBass0300Dto),SysComBass0300BM.ATTR_COMMCD,SysComBass0300BM.ATTR_COMMCDNM){
//                {
//
//                }
//            });
//            /** column 은행 : bnkNm */
//            listColumnDefs.add(new ColumnDef("은행명", Psnl0130BM.ATTR_BNKNM, ColumnDef.TYPE_STRING , 90, false, false, false){
//                {
//
//                }
//            });
//            /** column 은행계좌번호 : bnkAccuNum */
//            listColumnDefs.add(new ColumnDef("계좌번호", Psnl0130BM.ATTR_BNKACCUNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
//                {
//
//                }
//            });
//            /** column 예금주명 : acntHodrNm */
//            listColumnDefs.add(new ColumnDef("예금주", Psnl0130BM.ATTR_ACNTHODRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
//                {
//
//                }
//            });
//            /** column 대표계좌여부 : rpsttvAccuYn */
//            listColumnDefs.add(new ColumnDef("대표계좌", Psnl0130BM.ATTR_RPSTTVACCUYN, ColumnDef.TYPE_BOOLEAN , 60, false, true, true){
//                {
//
//                }
//            });
//            /** column 계좌비고내용 : accuNoteCtnt */
//            listColumnDefs.add(new ColumnDef("비고", Psnl0130BM.ATTR_ACCUNOTECTNT, ColumnDef.TYPE_STRING , 100, false, true, true){
//                {
//
//                }
//            });
// 
//            
//            return listColumnDefs;
//      }
	  
 
	  
	  public List<ColumnDef> getRemt0100ToPsnl0130(){
          List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
          
            /** column SYSTEMKEY : systemkey */
            listColumnDefs.add(new ColumnDef("항목","", ColumnDef.TYPE_STRING , 90, false, true, false){
                {

                }
            });
            /** column 사업장코드 : dpobCd */
            listColumnDefs.add(new ColumnDef("금액", "", ColumnDef.TYPE_STRING , 90, false, true, false){
                {

                }
            });
          
 
            
            return listColumnDefs;
      }
	  
	  public List<ColumnDef> getRemt0101ToPsnl0130(){
          List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
          
            /** column SYSTEMKEY : systemkey */
            listColumnDefs.add(new ColumnDef("항목","", ColumnDef.TYPE_STRING , 90, false, true, false){
                {

                }
            });
            /** column 사업장코드 : dpobCd */
            listColumnDefs.add(new ColumnDef("금액", "", ColumnDef.TYPE_STRING , 90, false, true, false){
                {

                }
            });
          
 
            
            return listColumnDefs;
      }
	  
	  public List<ColumnDef> getRemt0103ToPsnl0130(){
          List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
          
            /** column SYSTEMKEY : systemkey */
            listColumnDefs.add(new ColumnDef("항목","", ColumnDef.TYPE_STRING , 90, false, true, false){
                {

                }
            });
            /** column 사업장코드 : dpobCd */
            listColumnDefs.add(new ColumnDef("금액", "", ColumnDef.TYPE_STRING , 90, false, true, false){
                {

                }
            });
          
 
            
            return listColumnDefs;
      }
 
}
