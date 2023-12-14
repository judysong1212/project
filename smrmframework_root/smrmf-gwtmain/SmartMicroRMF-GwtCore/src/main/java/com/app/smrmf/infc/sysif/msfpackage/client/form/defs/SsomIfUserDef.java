/**
 * 공통화면 팝업 
 */
package com.app.smrmf.infc.sysif.msfpackage.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SsomIfUserBM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0100BM;
import com.app.smrmf.infc.sysif.msfpackage.client.languages.SysIfConstants;
import com.app.smrmf.infc.sysif.msfpackage.client.lookup.LookupSysIfBass0400;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class SsomIfUserDef  extends TableDef implements MSFPkgDaoConstants {

    private int row = 0;
    private SysIfConstants sysComLabel = SysIfConstants.INSTANCE;

    private SysIfBass0400DTO sysComBass0400Dto;
    
    public SsomIfUserDef(){
    	
    	sysComBass0400Dto = new SysIfBass0400DTO();
    	  
        setTitle("SsoxUser");
        setDaoClass("");
        setAutoFillGrid(false);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
            
    	/** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnListDef("부서", SysIfSysm0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false,new LookupSysIfBass0400(sysComBass0400Dto),SysIfBass0400BM.ATTR_DEPTCD,SysIfBass0400BM.ATTR_DEPTNMRTCHNT){
    		{

    		}
    	}); 

        /** column null : nid */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_NID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : cn */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_CN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : ou */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_OU, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : oucode */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_OUCODE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : parentoucode */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_PARENTOUCODE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : topoucode */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_TOPOUCODE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : uidM */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_UIDM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : displayname */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_DISPLAYNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : description */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_DESCRIPTION, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : userfullname */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_USERFULLNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : givenname */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_GIVENNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : positioncode */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_POSITIONCODE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : position */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_POSITION, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : titlecode */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_TITLECODE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : title */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_TITLE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : titleorposition */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_TITLEORPOSITION, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : mail */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_MAIL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : othermail */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_OTHERMAIL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : telephonenumber */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_TELEPHONENUMBER, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : fax */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_FAX, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : orgfullname */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_ORGFULLNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : orderrank */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_ORDERRANK, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column null : homepostaladdress1 */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_HOMEPOSTALADDRESS1, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : homepostaladdress2 */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_HOMEPOSTALADDRESS2, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : homefaxphonenumber */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_HOMEFAXPHONENUMBER, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : homephone */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_HOMEPHONE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : mobile */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_MOBILE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : pager */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_PAGER, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : jobtitle */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_JOBTITLE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : nickname */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_NICKNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : empnumber */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_EMPNUMBER, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : homepageurl */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_HOMEPAGEURL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : photopath */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_PHOTOPATH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : gender */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_GENDER, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : weddingdate */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_WEDDINGDATE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : birthday */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_BIRTHDAY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : carnumber */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_CARNUMBER, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : status */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_STATUS, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : isother */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_ISOTHER, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : otherperiod */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_OTHERPERIOD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : otheroucode */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_OTHEROUCODE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : otherou */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_OTHEROU, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : sidM */
        listColumnDefs.add(new ColumnDef("null", SsomIfUserBM.ATTR_SIDM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> nid;   /** column null : nid */
//
//        private TextField<String> cn;   /** column null : cn */
//
//        private TextField<String> ou;   /** column null : ou */
//
//        private TextField<String> oucode;   /** column null : oucode */
//
//        private TextField<String> parentoucode;   /** column null : parentoucode */
//
//        private TextField<String> topoucode;   /** column null : topoucode */
//
//        private TextField<String> uidM;   /** column null : uidM */
//
//        private TextField<String> displayname;   /** column null : displayname */
//
//        private TextField<String> description;   /** column null : description */
//
//        private TextField<String> userfullname;   /** column null : userfullname */
//
//        private TextField<String> givenname;   /** column null : givenname */
//
//        private TextField<String> positioncode;   /** column null : positioncode */
//
//        private TextField<String> position;   /** column null : position */
//
//        private TextField<String> titlecode;   /** column null : titlecode */
//
//        private TextField<String> title;   /** column null : title */
//
//        private TextField<String> titleorposition;   /** column null : titleorposition */
//
//        private TextField<String> mail;   /** column null : mail */
//
//        private TextField<String> othermail;   /** column null : othermail */
//
//        private TextField<String> telephonenumber;   /** column null : telephonenumber */
//
//        private TextField<String> fax;   /** column null : fax */
//
//        private TextField<String> orgfullname;   /** column null : orgfullname */
//
//        private TextField<String> orderrank;   /** column null : orderrank */
//
//        private TextField<String> homepostaladdress1;   /** column null : homepostaladdress1 */
//
//        private TextField<String> homepostaladdress2;   /** column null : homepostaladdress2 */
//
//        private TextField<String> homefaxphonenumber;   /** column null : homefaxphonenumber */
//
//        private TextField<String> homephone;   /** column null : homephone */
//
//        private TextField<String> mobile;   /** column null : mobile */
//
//        private TextField<String> pager;   /** column null : pager */
//
//        private TextField<String> jobtitle;   /** column null : jobtitle */
//
//        private TextField<String> nickname;   /** column null : nickname */
//
//        private TextField<String> empnumber;   /** column null : empnumber */
//
//        private TextField<String> homepageurl;   /** column null : homepageurl */
//
//        private TextField<String> photopath;   /** column null : photopath */
//
//        private TextField<String> gender;   /** column null : gender */
//
//        private TextField<String> weddingdate;   /** column null : weddingdate */
//
//        private TextField<String> birthday;   /** column null : birthday */
//
//        private TextField<String> carnumber;   /** column null : carnumber */
//
//        private TextField<String> status;   /** column null : status */
//
//        private TextField<String> isother;   /** column null : isother */
//
//        private TextField<String> otherperiod;   /** column null : otherperiod */
//
//        private TextField<String> otheroucode;   /** column null : otheroucode */
//
//        private TextField<String> otherou;   /** column null : otherou */
//
//        private TextField<String> sidM;   /** column null : sidM */
        setColumnsDefinition(listColumnDefs);
    }
}
