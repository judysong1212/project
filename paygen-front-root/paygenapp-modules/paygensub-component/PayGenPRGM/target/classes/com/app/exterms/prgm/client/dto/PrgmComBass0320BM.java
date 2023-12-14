package com.app.exterms.prgm.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

 
/**
* <pre>
* 1. 패키지명 : com.app.exterms.prgm.client.dto
* 2. 타입명 : PrgmComBass0320BM.java
* 3. 작성일 : Nov 22, 2015 8:57:15 AM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
*/
public class PrgmComBass0320BM  extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";
 
    /** set 직종 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";
    
 


    /** 생성자 */
     public PrgmComBass0320BM() { super(); } 

    /** 일괄등록 처리   */
     public PrgmComBass0320BM(
    		 String  dpobCd  
    		, String  typOccuCd 
    	  ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     }
    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}
 
    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}
 
     
    /** set 직종 : typOccuNm */
    public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
    /** get 직종 : typOccuNm */
    public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}

   
    
}
