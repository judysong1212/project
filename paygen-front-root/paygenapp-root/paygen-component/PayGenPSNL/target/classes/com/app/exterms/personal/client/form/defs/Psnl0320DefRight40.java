package com.app.exterms.personal.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0320BMRight3;
import com.app.exterms.personal.shared.PsnlDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Psnl0320DefRight40  extends TableDef implements PsnlDaoConstants {

//	private int row = 0;
//	private PsnlConstants psnlLabel = PsnlConstants.INSTANCE;

	public Psnl0320DefRight40(){
		setTitle("");
		setDaoClass(CLASS_PSNL0320_DATA_LIST_RIGHT40);
		setCustomListMethod(CLASS_PSNL0320_DATA_LIST_RIGHT40);
		setColumnsDefinition(getPsnl0122ToPsnl0320ColumnsList());
		setAutoFillGrid(false);
		setShowFilterToolbar(false);
		setCheckBoxOnGridRows(false);
		setEditFieldGrid(true);
	}

	private List<ColumnDef> getPsnl0122ToPsnl0320ColumnsList(){

		//row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

        /** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Psnl0320BMRight3.ATTR_DPOB_CD, ColumnDef.TYPE_STRING , 150, true, false, true){
			{
				setReadOnly(true);
			}
		});

		/** set SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0320BMRight3.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 150, true, false, true){
			{
				setReadOnly(true);
			}
		});

		/** set 징계일련번호 : dsnyActSeilNum */
		listColumnDefs.add(new ColumnDef("징계일련번호", Psnl0320BMRight3.ATTR_DSNY_ACT_SEIL_NUM, ColumnDef.TYPE_STRING , 150, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 징계처분일자 : dsnyActDsplDt */
		listColumnDefs.add(new ColumnDef("징계처분일자", Psnl0320BMRight3.ATTR_DSNY_ACT_DSPL_DT, ColumnDef.TYPE_DATE , 100, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 징계구분 : dsnyActDivCd */
		listColumnDefs.add(new ColumnDef("징계구분", Psnl0320BMRight3.ATTR_DSNY_ACT_DIV_CD, ColumnDef.TYPE_STRING , 150, true, false, true){
			{
				setReadOnly(true);
			}
		});
		
		/** column 징계구분 : dsnyActDivCd */
		listColumnDefs.add(new ColumnDef("징계구분", Psnl0320BMRight3.ATTR_DSNY_ACT_DIV_NM, ColumnDef.TYPE_STRING , 150, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 징계명 : dsnyActNm */
		listColumnDefs.add(new ColumnDef("징계명", Psnl0320BMRight3.ATTR_DSNY_ACT_NM, ColumnDef.TYPE_STRING , 130, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 징계사유 : dsnyActReasCtnt */
		listColumnDefs.add(new ColumnDef("징계사유", Psnl0320BMRight3.ATTR_DSNY_ACT_REAS_CTNT, ColumnDef.TYPE_STRING , 150, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 시행기관(징계수행기관) : dsnyActEctgOrgn */
		listColumnDefs.add(new ColumnDef("시행기관", Psnl0320BMRight3.ATTR_DSNY_ACT_ECTG_ORGN, ColumnDef.TYPE_STRING , 150, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 징계비고내용 : dsnyActNoteCtnt */
		listColumnDefs.add(new ColumnDef("징계비고내용", Psnl0320BMRight3.ATTR_DSNY_ACT_NOTE_CTNT, ColumnDef.TYPE_STRING , 150, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 징계시작일 : dsnyActBgnnDt */
		listColumnDefs.add(new ColumnDef("징계시작일", Psnl0320BMRight3.ATTR_DSNY_ACT_BGNN_DT, ColumnDef.TYPE_DATE , 100, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 징계종료일 : dsnyActEndDt */
		listColumnDefs.add(new ColumnDef("징계종료일", Psnl0320BMRight3.ATTR_DSNY_ACT_END_DT, ColumnDef.TYPE_DATE , 100, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 징계감봉율 : dsnyActCtwpRate */
		listColumnDefs.add(new ColumnDef("징계감봉율", Psnl0320BMRight3.ATTR_DSNY_ACT_CTWP_RATE, ColumnDef.TYPE_DATE , 100, true, false, true){
			{
				setReadOnly(true);
			}
		});
		
        /** column 감봉월수 : dsnyActCtwpMnthIcm */
		listColumnDefs.add(new ColumnDef("감봉월수", Psnl0320BMRight3.ATTR_DSNY_ACT_CTWP_MNTH_ICM, ColumnDef.TYPE_BIGDECIMAL , 100, true, true, true){
			{
				setReadOnly(false);
			}
		});
		
        /** column 징계사면일 : dsnyActAnstyDt */
		listColumnDefs.add(new ColumnDef("징계사면일", Psnl0320BMRight3.ATTR_DSNY_ACT_ANSTY_DT, ColumnDef.TYPE_DATE , 100, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 징계사면구분코드 : dsnyActAnstyDivCd */
		listColumnDefs.add(new ColumnDef("징계사면구분코드", Psnl0320BMRight3.ATTR_DSNY_ACT_ANSTY_DIV_CD, ColumnDef.TYPE_DATE , 100, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Psnl0320BMRight3.ATTR_KYBDR, ColumnDef.TYPE_DATE , 100, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Psnl0320BMRight3.ATTR_INPT_DT, ColumnDef.TYPE_DATE , 100, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Psnl0320BMRight3.ATTR_INPT_ADDR, ColumnDef.TYPE_DATE , 100, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Psnl0320BMRight3.ATTR_ISMT, ColumnDef.TYPE_DATE , 100, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Psnl0320BMRight3.ATTR_REVN_DT, ColumnDef.TYPE_DATE , 100, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Psnl0320BMRight3.ATTR_REVN_ADDR, ColumnDef.TYPE_DATE , 100, true, false, true){
			{
				setReadOnly(true);
			}
		});

		return listColumnDefs;
    }
}