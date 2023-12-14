package com.app.exterms.personal.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0320BMRight1;
import com.app.exterms.personal.client.dto.Psnl0320BMRight2;
import com.app.exterms.personal.shared.PsnlDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Psnl0320DefRight30  extends TableDef implements PsnlDaoConstants {

//	private int row = 0;
	final PrgmComBass0300DTO sysComBass0300Dto;

	public Psnl0320DefRight30(){

		sysComBass0300Dto = new PrgmComBass0300DTO();

		setTitle("");
		setDaoClass(CLASS_PSNL0320_DATA_LIST_RIGHT30);
		setCustomListMethod(CLASS_PSNL0320_DATA_LIST_RIGHT30);
		setColumnsDefinition(getPsnl0119ToPsnl0320ColumnsList());
		setAutoFillGrid(false);
		setShowFilterToolbar(false);
		setCheckBoxOnGridRows(false);
		setEditFieldGrid(true);
	}

	private List<ColumnDef> getPsnl0119ToPsnl0320ColumnsList(){

		//row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

        /** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Psnl0320BMRight2.ATTR_DPOB_CD, ColumnDef.TYPE_STRING , 100, true, false, true){
			{
				setReadOnly(true);
			}
		});

		/** set SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0320BMRight2.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

		/** set 경력사항일련번호 : carrRsptSeilNum */
		listColumnDefs.add(new ColumnDef("경력사항일련번호", Psnl0320BMRight2.ATTR_CARR_RSPT_SEIL_NUM, ColumnDef.TYPE_STRING , 150, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 근무처명 : paeWorkNm */
		listColumnDefs.add(new ColumnDef("근무처명", Psnl0320BMRight2.ATTR_PAE_WORK_NM, ColumnDef.TYPE_DATE , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 근무시작일자(경력시작일자) : carrBgnnDt */
		listColumnDefs.add(new ColumnDef("근무시작일자", Psnl0320BMRight2.ATTR_CARR_BGNN_DT, ColumnDef.TYPE_DATE , 80, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 근무종료일자(경력종료일자) : carrEndDt */
		listColumnDefs.add(new ColumnDef("근무종료일자", Psnl0320BMRight2.ATTR_CARR_END_DT, ColumnDef.TYPE_DATE , 80, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 부서명(근무부서명) : dutyDeptNm */                   
		listColumnDefs.add(new ColumnDef("부서명", Psnl0320BMRight2.ATTR_DUTY_DEPT_NM, ColumnDef.TYPE_STRING , 120, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 경력구분 : carrDivCd */
		listColumnDefs.add(new ColumnDef("경력구분", Psnl0320BMRight2.ATTR_CARR_DIV_CD, ColumnDef.TYPE_STRING , 120, true, false, true){
			{
				setReadOnly(true);
			}
		});
		
		
		 /** column 경력구분 : carrDivCd */
		listColumnDefs.add(new ColumnDef("경력구분", Psnl0320BMRight2.ATTR_CARR_DIV_NM, ColumnDef.TYPE_STRING , 120, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 직책명 : odtyNm */
		listColumnDefs.add(new ColumnDef("직책명", Psnl0320BMRight2.ATTR_ODTY_NM, ColumnDef.TYPE_STRING , 120, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 임금일당금액 : amntDlywagSum */
		listColumnDefs.add(new ColumnDef("임금일당금액", Psnl0320BMRight2.ATTR_AMNT_DLYWAG_SUM, ColumnDef.TYPE_STRING , 120, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 경력비고내용 : carrNoteCtnt */
		listColumnDefs.add(new ColumnDef("경력비고내용", Psnl0320BMRight2.ATTR_CARR_NOTE_CTNT, ColumnDef.TYPE_STRING , 120, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 담당업무(담당업무명) : repbtyBusinNm */
		listColumnDefs.add(new ColumnDef("담당업무", Psnl0320BMRight2.ATTR_REPBTY_BUSIN_NM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 경력인정(환산비율) : cvsnRtoDivCd */
		sysComBass0300Dto.setRpsttvCd("A049");
		listColumnDefs.add(new ColumnListDef("경력인정", Psnl0320BMRight1.ATTR_CVSN_RTO_DIV_CD, ColumnDef.TYPE_STRING, 80, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
			{
				setReadOnly(false);
			}
		});

        /** column 가감월수 : ajmtMnthNum */
		listColumnDefs.add(new ColumnDef("가감월수", Psnl0320BMRight2.ATTR_AJMT_MNTH_NUM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
				setReadOnly(false);
			}
		});

        /** column 인정월수 : rcgtnMnthNum */
		listColumnDefs.add(new ColumnDef("인정월수", Psnl0320BMRight2.ATTR_RCGTN_MNTH_NUM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 근무년수 : dutyYrNum */
		listColumnDefs.add(new ColumnDef("근무년수", Psnl0320BMRight2.ATTR_DUTY_YR_NUM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 근무월수 : dutyMnthIcm */
		listColumnDefs.add(new ColumnDef("근무월수", Psnl0320BMRight2.ATTR_DUTY_MNTH_ICM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 근속일수(근무일수) : dutyDayNum */
		listColumnDefs.add(new ColumnDef("근무일수", Psnl0320BMRight2.ATTR_DUTY_DAY_NUM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 근속전체일수 : dutyTotDayNum */
		listColumnDefs.add(new ColumnDef("근속전체일수", Psnl0320BMRight2.ATTR_DUTY_TOT_DAY_NUM, ColumnDef.TYPE_STRING , 80, true, true, true){
			{
				setReadOnly(true);
			}
		});

        /** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Psnl0320BMRight2.ATTR_KYBDR, ColumnDef.TYPE_STRING , 100, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Psnl0320BMRight2.ATTR_INPT_DT, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Psnl0320BMRight2.ATTR_INPT_ADDR, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Psnl0320BMRight2.ATTR_ISMT, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Psnl0320BMRight2.ATTR_REVN_DT, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        /** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Psnl0320BMRight2.ATTR_REVN_ADDR, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				setReadOnly(true);
			}
		});

        return listColumnDefs;
    }
}