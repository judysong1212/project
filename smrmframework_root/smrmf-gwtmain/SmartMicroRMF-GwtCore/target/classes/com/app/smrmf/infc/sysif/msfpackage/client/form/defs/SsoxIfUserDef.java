/**
 * 공통화면 팝업 
 */
package com.app.smrmf.infc.sysif.msfpackage.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.languages.MSFConstants;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SsoxIfUserBM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0100BM;
import com.app.smrmf.infc.sysif.msfpackage.client.lookup.LookupSysIfBass0400;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class SsoxIfUserDef  extends TableDef implements  MSFPkgDaoConstants {
    private int row = 0;
    
    private MSFConstants lblSysIfConst = MSFConstants.INSTANCE;

    private SysIfBass0400DTO sysIfBass0400Dto;
    
    public SsoxIfUserDef(){
    	
    	sysIfBass0400Dto = new SysIfBass0400DTO();
    	  
        setTitle("SsoxUser");
        setDaoClass("");
        setAutoFillGrid(false);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
            
    	/** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnListDef("부서", SysIfSysm0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false,new LookupSysIfBass0400(sysIfBass0400Dto),SysIfBass0400BM.ATTR_DEPTCD,SysIfBass0400BM.ATTR_DEPTNMRTCHNT){
    		{

    		}
    	}); 
    	/** column 사용자성명 : usrNm */
    	listColumnDefs.add(new ColumnDef("성명", SysIfSysm0100BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{
    			 
    		}
    	});
    	/** column 사용자아이디 : usrId */
    	listColumnDefs.add(new ColumnDef("아이디", SysIfSysm0100BM.ATTR_USRID, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{
    			 
    		}
    	});
        /** column null : userId */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_USERID, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : userName */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_USERNAME, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : userSn */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_USERSN, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : userStat */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_USERSTAT, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : userStatName */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_USERSTATNAME, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : regularity */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_REGULARITY, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : orgId */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_ORGID, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : orgName */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_ORGNAME, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : deptId */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_DEPTID, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : deptName */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_DEPTNAME, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : deptFullname */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_DEPTFULLNAME, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : classId */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_CLASSID, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : className */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_CLASSNAME, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : positionId */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_POSITIONID, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : positionName */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_POSITIONNAME, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : gradeId */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_GRADEID, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : gradeName */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_GRADENAME, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : email */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_EMAIL, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : tel */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_TEL, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : mobile */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_MOBILE, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : joinDay */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_JOINDAY, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : retireDay */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_RETIREDAY, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : addInfo1 */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_ADDINFO1, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : addInfo2 */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_ADDINFO2, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : addInfo3 */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_ADDINFO3, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : addInfo4 */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_ADDINFO4, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : addInfo5 */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_ADDINFO5, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : addInfo6 */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_ADDINFO6, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : addInfo7 */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_ADDINFO7, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : baseSys */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_BASESYS, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : regDay */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_REGDAY, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : updateDay */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_UPDATEDAY, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column null : useYn */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_USEYN, ColumnDef.TYPE_BOOLEAN , 90, false, false, false){
        	{

        	}
        });
        /** column null : rdutyName */
        listColumnDefs.add(new ColumnDef("null", SsoxIfUserBM.ATTR_RDUTYNAME, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });

//        private TextField<String> userId   /** column null : userId */
//
//        private TextField<String> userName   /** column null : userName */
//
//        private TextField<String> userSn   /** column null : userSn */
//
//        private TextField<String> userStat   /** column null : userStat */
//
//        private TextField<String> userStatName   /** column null : userStatName */
//
//        private TextField<String> regularity   /** column null : regularity */
//
//        private TextField<String> orgId   /** column null : orgId */
//
//        private TextField<String> orgName   /** column null : orgName */
//
//        private TextField<String> deptId   /** column null : deptId */
//
//        private TextField<String> deptName   /** column null : deptName */
//
//        private TextField<String> deptFullname   /** column null : deptFullname */
//
//        private TextField<String> classId   /** column null : classId */
//
//        private TextField<String> className   /** column null : className */
//
//        private TextField<String> positionId   /** column null : positionId */
//
//        private TextField<String> positionName   /** column null : positionName */
//
//        private TextField<String> gradeId   /** column null : gradeId */
//
//        private TextField<String> gradeName   /** column null : gradeName */
//
//        private TextField<String> email   /** column null : email */
//
//        private TextField<String> tel   /** column null : tel */
//
//        private TextField<String> mobile   /** column null : mobile */
//
//        private TextField<String> joinDay   /** column null : joinDay */
//
//        private TextField<String> retireDay   /** column null : retireDay */
//
//        private TextField<String> addInfo1   /** column null : addInfo1 */
//
//        private TextField<String> addInfo2   /** column null : addInfo2 */
//
//        private TextField<String> addInfo3   /** column null : addInfo3 */
//
//        private TextField<String> addInfo4   /** column null : addInfo4 */
//
//        private TextField<String> addInfo5   /** column null : addInfo5 */
//
//        private TextField<String> addInfo6   /** column null : addInfo6 */
//
//        private TextField<String> addInfo7   /** column null : addInfo7 */
//
//        private TextField<String> baseSys   /** column null : baseSys */
//
//        private TextField<String> regDay   /** column null : regDay */
//
//        private TextField<String> updateDay   /** column null : updateDay */
//
//        private TextField<String> useYn   /** column null : useYn */
//
//        private TextField<String> rdutyName   /** column null : rdutyName */
//       
        
        setColumnsDefinition(listColumnDefs);
    }
}
