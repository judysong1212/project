/**
 * 공통화면 팝업 
 */
package com.app.smrmf.infc.sysif.msfpackage.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SsomIfDeptBM;
import com.app.smrmf.infc.sysif.msfpackage.client.languages.SysIfConstants;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class SsomIfDeptDef  extends TableDef implements MSFPkgDaoConstants {

    private int row = 0;
    private SysIfConstants sysComLabel = SysIfConstants.INSTANCE;

     
    
    public SsomIfDeptDef(){
    	
     
    	  
        setTitle("SsomDept");
        setDaoClass("");
        setAutoFillGrid(false);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
            
       
        /** column null : oucode */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_OUCODE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : ou */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_OU, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : topoucode */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_TOPOUCODE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : parentoucode */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_PARENTOUCODE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : cn */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_CN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : oudivision */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_OUDIVISION, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : orgfullname */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_ORGFULLNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : oulevel */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_OULEVEL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : ouorder */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_OUORDER, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : engou */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_ENGOU, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : telephonenumber */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_TELEPHONENUMBER, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : ouaddress1 */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_OUADDRESS1, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : ouaddress2 */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_OUADDRESS2, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : ouhomepage */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_OUHOMEPAGE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : oufax */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_OUFAX, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : oumail */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_OUMAIL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : issidoonly */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_ISSIDOONLY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : status */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_STATUS, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : sidoadduserid */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_SIDOADDUSERID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : sidoadddate */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_SIDOADDDATE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : sidoaddtime */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_SIDOADDTIME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : sidochangeuserid */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_SIDOCHANGEUSERID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : sidochangedate */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_SIDOCHANGEDATE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : sidochangetime */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_SIDOCHANGETIME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : isvirtual */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_ISVIRTUAL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : virparentoucode */
        listColumnDefs.add(new ColumnDef("null", SsomIfDeptBM.ATTR_VIRPARENTOUCODE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> oucode;   /** column null : oucode */
//
//        private TextField<String> ou;   /** column null : ou */
//
//        private TextField<String> topoucode;   /** column null : topoucode */
//
//        private TextField<String> parentoucode;   /** column null : parentoucode */
//
//        private TextField<String> cn;   /** column null : cn */
//
//        private TextField<String> oudivision;   /** column null : oudivision */
//
//        private TextField<String> orgfullname;   /** column null : orgfullname */
//
//        private TextField<String> oulevel;   /** column null : oulevel */
//
//        private TextField<String> ouorder;   /** column null : ouorder */
//
//        private TextField<String> engou;   /** column null : engou */
//
//        private TextField<String> telephonenumber;   /** column null : telephonenumber */
//
//        private TextField<String> ouaddress1;   /** column null : ouaddress1 */
//
//        private TextField<String> ouaddress2;   /** column null : ouaddress2 */
//
//        private TextField<String> ouhomepage;   /** column null : ouhomepage */
//
//        private TextField<String> oufax;   /** column null : oufax */
//
//        private TextField<String> oumail;   /** column null : oumail */
//
//        private TextField<String> issidoonly;   /** column null : issidoonly */
//
//        private TextField<String> status;   /** column null : status */
//
//        private TextField<String> sidoadduserid;   /** column null : sidoadduserid */
//
//        private TextField<String> sidoadddate;   /** column null : sidoadddate */
//
//        private TextField<String> sidoaddtime;   /** column null : sidoaddtime */
//
//        private TextField<String> sidochangeuserid;   /** column null : sidochangeuserid */
//
//        private TextField<String> sidochangedate;   /** column null : sidochangedate */
//
//        private TextField<String> sidochangetime;   /** column null : sidochangetime */
//
//        private TextField<String> isvirtual;   /** column null : isvirtual */
//
//        private TextField<String> virparentoucode;   /** column null : virparentoucode */
        
        setColumnsDefinition(listColumnDefs);
    }
}
