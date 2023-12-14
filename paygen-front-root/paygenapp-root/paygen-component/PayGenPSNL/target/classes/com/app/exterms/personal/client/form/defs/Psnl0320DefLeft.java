package com.app.exterms.personal.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0320BMLeft;
import com.app.exterms.personal.shared.PsnlDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Psnl0320DefLeft  extends TableDef implements PsnlDaoConstants {

//	private int row = 0;
//	private PsnlConstants psnlLabel = PsnlConstants.INSTANCE;

	public Psnl0320DefLeft(){
		setTitle("");
		setDaoClass(CLASS_PSNL0320_DATA_LIST_LEFT);
		setCustomListMethod(CLASS_PSNL0320_DATA_LIST_LEFT);
		setColumnsDefinition(getPsnl0100ToPsnl0320ColumnsList());
		setAutoFillGrid(false);
		setShowFilterToolbar(false);
		setCheckBoxOnGridRows(true);
		setEditFieldGrid(false);
		
	}

	private List<ColumnDef> getPsnl0100ToPsnl0320ColumnsList(){

		//row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

        /** column 사업장코드 : dpopCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Psnl0320BMLeft.ATTR_DPOB_CD, ColumnDef.TYPE_STRING , 100, true, false, false){
			{
				setReadOnly(true);
			}
		});

        /** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0320BMLeft.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 100, true, false, false){
			{
				setReadOnly(true);
			}
		});


        /** column 부서 : deptNm */
		listColumnDefs.add(new ColumnDef("부서", Psnl0320BMLeft.ATTR_DEPT_NM, ColumnDef.TYPE_STRING , 100, true, true, true){
			{
				setReadOnly(true);
			}
		});

		/** column 성명 : hanNm */
		listColumnDefs.add(new ColumnDef("성명", Psnl0320BMLeft.ATTR_HANNM, ColumnDef.TYPE_STRING , 50, true, true, true){
			{
				setReadOnly(true);
			}
		});

		/** column 주민등록번호 : emymtDivCd */
		listColumnDefs.add(new ColumnDef("주민등록번호", Psnl0320BMLeft.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
			{
				setReadOnly(true);
			}
		});

		/** column 재획정일자 : reMrkDt */
		listColumnDefs.add(new ColumnDef("근속기준일자", Psnl0320BMLeft.ATTR_RE_MRK_DT, ColumnDef.TYPE_STRING, 100, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 호봉 : typOccuNm */
        listColumnDefs.add(new ColumnDef("호봉", Psnl0320BMLeft.ATTR_PYSP_CD, ColumnDef.TYPE_STRING, 80, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 호봉 : typOccuNm */
        listColumnDefs.add(new ColumnDef("호봉", Psnl0320BMLeft.ATTR_PYSP_NM, ColumnDef.TYPE_STRING, 80, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        

        /** column 근속년수 : dpobCd */
        listColumnDefs.add(new ColumnDef("근속년수", Psnl0320BMLeft.ATTR_LOG_SVC_YR_NUM_CD, ColumnDef.TYPE_STRING , 80, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 근속년수 : dpobCd */
        listColumnDefs.add(new ColumnDef("근속년수", Psnl0320BMLeft.ATTR_LOG_SVC_YR_NUM_NM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });

        /** column 근속년수 : dpobCd */
        listColumnDefs.add(new ColumnDef("근속월수", Psnl0320BMLeft.ATTR_LOG_SVC_MNTH_ICM_NM, ColumnDef.TYPE_STRING , 80, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Psnl0320BMLeft.ATTR_TYP_OCCU_CD, ColumnDef.TYPE_STRING , 80, true, false, false){
        	{
        		setReadOnly(true);
        	}
        });

        /** column 직종명 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종명", Psnl0320BMLeft.ATTR_TYP_OCCU_NM, ColumnDef.TYPE_STRING , 100, true, false, false){
        	{
        		setReadOnly(true);
        	}
        });

        /** column 직종세명 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세명", Psnl0320BMLeft.ATTR_DTIL_OCCU_CLS_DIV_NM, ColumnDef.TYPE_STRING , 100, true, false, false){
        	{
        		setReadOnly(true);
        	}
        });

        /** column 사업명 : businNm */
        listColumnDefs.add(new ColumnDef("사업명", Psnl0320BMLeft.ATTR_BUSIN_NM, ColumnDef.TYPE_STRING , 100, true, false, false){
        	{
        		setReadOnly(true);
        	}
        });

        /** column 고용시작일자(입사일자) : emymtBgnnDt */
        listColumnDefs.add(new ColumnDef("고용시작일자(입사일자)", Psnl0320BMLeft.ATTR_EMYMT_BGNN_DT, ColumnDef.TYPE_STRING , 100, true, false, false){
        	{
        		setReadOnly(true);
        	}
        });

        /** column 호봉재획정일자 : reMrkDt */
        listColumnDefs.add(new ColumnDef("호봉재획정일자", Psnl0320BMLeft.ATTR_RE_MRK_DT, ColumnDef.TYPE_STRING , 100, true, false, false){
        	{
        		setReadOnly(true);
        	}
        });

        /** column 근속기준일(이사님의 지시에 의해 호봉재획정일자로 맞춘다) : logStdDt */
        listColumnDefs.add(new ColumnDef("근속기준일", Psnl0320BMLeft.ATTR_LOG_STD_DT, ColumnDef.TYPE_STRING , 100, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });

        /** column 입대일자 : enrlntDt */
        listColumnDefs.add(new ColumnDef("입대일자", Psnl0320BMLeft.ATTR_ENRLNT_DT, ColumnDef.TYPE_STRING , 70, true, false, false){
        	{
        		setReadOnly(true);
        	}
        });

        /** column 제대일자 : dsageDt */
        listColumnDefs.add(new ColumnDef("제대일자", Psnl0320BMLeft.ATTR_DSAGE_DT, ColumnDef.TYPE_STRING , 70, true, false, false){
        	{
        		setReadOnly(true);
        	}
        });

        /** column 복무인정기간코드 : servcRcgtnPridCd */
        listColumnDefs.add(new ColumnDef("복무인정기간코드", Psnl0320BMLeft.ATTR_SERVC_RCGTN_PRID_CD, ColumnDef.TYPE_STRING , 80, true, false, false){
        	{
        		setReadOnly(true);
        	}
        });
        return listColumnDefs;
    }
}