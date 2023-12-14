package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : SysComBass0300BM.java
 * @Description : SysComBass0300 BaseModel class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfBass0300BM  extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    
    
    public static final String ATTR_DPOBCD  	 = "dpobCd"; 		/** DPOB_CD */
    public static final String ATTR_COMMCD  	 = "commCd"; 		/** COMM_CD */ 
    public static final String ATTR_RPSTTVCD 	 = "rpsttvCd";		/** RPSTTV_CD */
	public static final String ATTR_DTLCD 		 = "dtlCd";			/** DTL_CD */
    public static final String ATTR_COMMCDNM 	 = "commCdNm"; 		/** COMM_CD_NM */ 
    public static final String ATTR_ABBRNM  	 = "abbrNm";  		/** ABBR_NM */ 
    public static final String ATTR_ENGNM  		 = "engNm";  		/** ENG_NM */ 
    public static final String ATTR_MANGEITEM01  = "mangeItem01";  	/** MANGE_ITEM01 */ 
    public static final String ATTR_MANGEITEM02  = "mangeItem02";  	/** MANGE_ITEM02 */
    public static final String ATTR_MANGEITEM03  = "mangeItem03";  	/** MANGE_ITEM03 */ 
    public static final String ATTR_MANGEITEM04  = "mangeItem04";  	/** MANGE_ITEM04 */ 
    public static final String ATTR_MANGEITEM05  = "mangeItem05";  	/** MANGE_ITEM05 */ 
    public static final String ATTR_MANGEITEM06  = "mangeItem06";   /** MANGE_ITEM06 */ 
    public static final String ATTR_MANGEITEM07  = "mangeItem07";   /** MANGE_ITEM07 */ 
    public static final String ATTR_MANGEITEM08  = "mangeItem08";   /** MANGE_ITEM08 */ 
    public static final String ATTR_MANGEITEM09  = "mangeItem09";   /** MANGE_ITEM09 */ 
    public static final String ATTR_MANGEITEM10  = "mangeItem10";  	/** MANGE_ITEM10 */ 
    public static final String ATTR_MANGEITEM11  = "mangeItem11";  	/** MANGE_ITEM11 */ 
    public static final String ATTR_MANGEITEM12  = "mangeItem12";  	/** MANGE_ITEM12 */ 
    public static final String ATTR_MANGEITEM13  = "mangeItem13";  	/** MANGE_ITEM13 */ 
    public static final String ATTR_MANGEITEM14  = "mangeItem14";  	/** MANGE_ITEM14 */ 
    public static final String ATTR_MANGEITEM15  = "mangeItem15";  	/** MANGE_ITEM15 */ 
    public static final String ATTR_MANGEITEM16  = "mangeItem16";  	/** MANGE_ITEM16 */ 
    public static final String ATTR_MANGEITEM17  = "mangeItem17";  	/** MANGE_ITEM17 */ 
    public static final String ATTR_MANGEITEM18  = "mangeItem18";  	/** MANGE_ITEM18 */ 
    public static final String ATTR_MANGEITEM19  = "mangeItem19";  	/** MANGE_ITEM19 */ 
    public static final String ATTR_MANGEITEM20  = "mangeItem20";   /** MANGE_ITEM20 */ 
    public static final String ATTR_CDTREELVL  = "cdTreeLvl";       /** CD_TREE_LVL */ 
    public static final String ATTR_ORD  = "ord";                   /** ORD */     
    public static final String  ATTR_OPNYN  = "opnYn";              /** OPN_YN */ 
    public static final String  ATTR_USEYN  = "useYn";              /** USE_YN */ 
    public static final String  ATTR_NOTE  = "note";                /** NOTE */ 
 
    ////////
    private List<String> arrRpsttvCd = new ArrayList<String>();
      
    
    public SysIfBass0300BM() {
    	
    }
      
    
}
