package com.app.exterms.yearendtax.client.form.defs.yeta2019;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3000BM;
import com.app.exterms.yearendtax.client.dto.yeta2019.Ye169010BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;


/**
 * @Class Name : Ye169010Def.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye169010Def extends TableDef implements YetaDaoConstants {

	private int row = 0;

	// private YetaConstants yetaLabel = YetaConstants.INSTANCE;

	public Ye169010Def(String chkPayrDef) {

		if("Yeta4300".equals(chkPayrDef)) { 
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod("");
	        setCustomListMethod(CLASS_YETA4300_TO_YE169010_SUBTAX_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(false);
		    setColumnsDefinition(getYeta2300ToYe169010ColumnsList());

		}else if("".equals(chkPayrDef)) {
			setTitle("");
	        setDaoClass(""); 
	        setCustomListMethod(CLASS_YETA0300TOSUBTAX_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	       // setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(false);
		    setColumnsDefinition(getYe169010ColumnsList()); 	
		}  
		
	}
	
    private List<ColumnDef> getYe169010ColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye169010BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", Ye169010BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye169010BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye169010BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column C6_근로자_종전근무처수 : yeta00c6 */
        listColumnDefs.add(new ColumnDef("C6_근로자_종전근무처수", Ye169010BM.ATTR_YETA00C6, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C9_근로자_외국인단일세율적용여부 : yeta00c9 */
        listColumnDefs.add(new ColumnDef("C9_근로자_외국인단일세율적용여부", Ye169010BM.ATTR_YETA00C9, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column C9A_근로자_외국법인소속파견근로자여부 : yeta0c9a */
        listColumnDefs.add(new ColumnDef("C9A_근로자_외국법인소속파견근로자여부", Ye169010BM.ATTR_YETA0C9A, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column C15_근로자_연말정산구분코드 : yeta0c15 */
        listColumnDefs.add(new ColumnDef("C15_근로자_연말정산구분코드", Ye169010BM.ATTR_YETA0C15, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column C22_주현근무처_급여금액 : yeta0c22 */
        listColumnDefs.add(new ColumnDef("C22_주현근무처_급여금액", Ye169010BM.ATTR_YETA0C22, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C23_주현근무처_상여금액 : yeta0c23 */
        listColumnDefs.add(new ColumnDef("C23_주현근무처_상여금액", Ye169010BM.ATTR_YETA0C23, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C24_주현근무처_인정상여금액 : yeta0c24 */
        listColumnDefs.add(new ColumnDef("C24_주현근무처_인정상여금액", Ye169010BM.ATTR_YETA0C24, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C25_주현근무처_주식매수선택권행사이익금 : yeta0c25 */
        listColumnDefs.add(new ColumnDef("C25_주현근무처_주식매수선택권행사이익금", Ye169010BM.ATTR_YETA0C25, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C26_주현근무처_우리사주조합인출금액 : yeta0c26 */
        listColumnDefs.add(new ColumnDef("C26_주현근무처_우리사주조합인출금액", Ye169010BM.ATTR_YETA0C26, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C27_주현근무처_임원퇴직소득금액한도초과금액 : yeta0c27 */
        listColumnDefs.add(new ColumnDef("C27_주현근무처_임원퇴직소득금액한도초과금액", Ye169010BM.ATTR_YETA0C27, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C29_주현근무처_소득합계금액 : yeta0c29 */
        listColumnDefs.add(new ColumnDef("C29_주현근무처_소득합계금액", Ye169010BM.ATTR_YETA0C29, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C30_G01_비과세학자금금액 : yetaC30G01 */
        listColumnDefs.add(new ColumnDef("C30_G01_비과세학자금금액", Ye169010BM.ATTR_YETAC30G01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C31_H01_무보수위원수당금액 : yetaC31H01 */
        listColumnDefs.add(new ColumnDef("C31_H01_무보수위원수당금액", Ye169010BM.ATTR_YETAC31H01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C32_H05_경호숭선수당금액 : yetaC32H05 */
        listColumnDefs.add(new ColumnDef("C32_H05_경호숭선수당금액", Ye169010BM.ATTR_YETAC32H05, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C33_H06_유아초중등소득금액 : yetaC33H06 */
        listColumnDefs.add(new ColumnDef("C33_H06_유아초중등소득금액", Ye169010BM.ATTR_YETAC33H06, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C34_H07_고등교육법소득금액 : yetaC34H07 */
        listColumnDefs.add(new ColumnDef("C34_H07_고등교육법소득금액", Ye169010BM.ATTR_YETAC34H07, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C35_H08_특별법소득금액 : yetaC35H08 */
        listColumnDefs.add(new ColumnDef("C35_H08_특별법소득금액", Ye169010BM.ATTR_YETAC35H08, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C36_H09_연구기관등소득금액 : yetaC36H09 */
        listColumnDefs.add(new ColumnDef("C36_H09_연구기관등소득금액", Ye169010BM.ATTR_YETAC36H09, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C37_H10_기업부설연구소소득금액 : yetaC37H10 */
        listColumnDefs.add(new ColumnDef("C37_H10_기업부설연구소소득금액", Ye169010BM.ATTR_YETAC37H10, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C38_H14_보육교사근무환경개선금액 : yetaC38H14 */
        listColumnDefs.add(new ColumnDef("C38_H14_보육교사근무환경개선금액", Ye169010BM.ATTR_YETAC38H14, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C39_H15_사립유치원교사의인건비금액 : yetaC39H15 */
        listColumnDefs.add(new ColumnDef("C39_H15_사립유치원교사의인건비금액", Ye169010BM.ATTR_YETAC39H15, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C40_H11_취재수당금액 : yetaC40H11 */
        listColumnDefs.add(new ColumnDef("C40_H11_취재수당금액", Ye169010BM.ATTR_YETAC40H11, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C41_H12_벽지수당금액 : yetaC41H12 */
        listColumnDefs.add(new ColumnDef("C41_H12_벽지수당금액", Ye169010BM.ATTR_YETAC41H12, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C42_H13_재해관련급여소득금액 : yetaC42H13 */
        listColumnDefs.add(new ColumnDef("C42_H13_재해관련급여소득금액", Ye169010BM.ATTR_YETAC42H13, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C43_H16_정부공공지방이전기관이주수당소득금액 : yetaC43H16 */
        listColumnDefs.add(new ColumnDef("C43_H16_정부공공지방이전기관이주수당소득금액", Ye169010BM.ATTR_YETAC43H16, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C44_I01_외국정부등근무자소득금액 : yetaC44I01 */
        listColumnDefs.add(new ColumnDef("C44_I01_외국정부등근무자소득금액", Ye169010BM.ATTR_YETAC44I01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C45_K01_외국주둔군인등소득금액 : yetaC45K01 */
        listColumnDefs.add(new ColumnDef("C45_K01_외국주둔군인등소득금액", Ye169010BM.ATTR_YETAC45K01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C46_M01_국외근로자소득금액_100 : yetaC46M01 */
        listColumnDefs.add(new ColumnDef("C46_M01_국외근로자소득금액_100", Ye169010BM.ATTR_YETAC46M01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C47_M02_국외근로자소득금액_300 : yetaC47M02 */
        listColumnDefs.add(new ColumnDef("C47_M02_국외근로자소득금액_300", Ye169010BM.ATTR_YETAC47M02, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C48_M03_국외근로자소득금액 : yetaC48M03 */
        listColumnDefs.add(new ColumnDef("C48_M03_국외근로자소득금액", Ye169010BM.ATTR_YETAC48M03, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C49_O01_야간근로수당금액 : yetaC49O01 */
        listColumnDefs.add(new ColumnDef("C49_O01_야간근로수당금액", Ye169010BM.ATTR_YETAC49O01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C50_Q01_출산보육수당금액 : yetaC50Q01 */
        listColumnDefs.add(new ColumnDef("C50_Q01_출산보육수당금액", Ye169010BM.ATTR_YETAC50Q01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C51_R10_근로장학금소득금액 : yetaC51R10 */
        listColumnDefs.add(new ColumnDef("C51_R10_근로장학금소득금액", Ye169010BM.ATTR_YETAC51R10, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C52_S01_주식매수선택권소득금액 : yetaC52S01 */
        listColumnDefs.add(new ColumnDef("C52_S01_주식매수선택권소득금액", Ye169010BM.ATTR_YETAC52S01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C53_T01_외국인기술자소득금액 : yetaC53T01 */
        listColumnDefs.add(new ColumnDef("C53_T01_외국인기술자소득금액", Ye169010BM.ATTR_YETAC53T01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C54_Y02_우리사주조합인출금50_소득금액 : yetaC54Y02 */
        listColumnDefs.add(new ColumnDef("C54_Y02_우리사주조합인출금50_소득금액", Ye169010BM.ATTR_YETAC54Y02, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C55_Y03_우리사주조합인출금75_소득금액 : yetaC55Y03 */
        listColumnDefs.add(new ColumnDef("C55_Y03_우리사주조합인출금75_소득금액", Ye169010BM.ATTR_YETAC55Y03, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C55A_Y04_우리사주조합인출금100_소득금액 : yetaC55aY04 */
        listColumnDefs.add(new ColumnDef("C55A_Y04_우리사주조합인출금100_소득금액", Ye169010BM.ATTR_YETAC55AY04, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C56_Y21_장기미취업자중소기업취업소득금액 : yetaC56Y21 */
        listColumnDefs.add(new ColumnDef("C56_Y21_장기미취업자중소기업취업소득금액", Ye169010BM.ATTR_YETAC56Y21, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C57_Y22_전공의수련보조수당금액 : yetaC57Y22 */
        listColumnDefs.add(new ColumnDef("C57_Y22_전공의수련보조수당금액", Ye169010BM.ATTR_YETAC57Y22, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C58_T10_중소기업취업청년소득세100감면금액 : yetaC58T10 */
        listColumnDefs.add(new ColumnDef("C58_T10_중소기업취업청년소득세100감면금액", Ye169010BM.ATTR_YETAC58T10, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C58A_T11_중소기업취업청년소득세50감면금액 : yetaC58aT11 */
        listColumnDefs.add(new ColumnDef("C58A_T11_중소기업취업청년소득세50감면금액", Ye169010BM.ATTR_YETAC58AT11, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C58B_T12_중소기업취업청년소득세70감면금액 : yetaC58bT12 */
        listColumnDefs.add(new ColumnDef("C58B_T12_중소기업취업청년소득세70감면금액", Ye169010BM.ATTR_YETAC58BT12, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C59_T20_조세조약상교직자감면금액 : yetaC59T20 */
        listColumnDefs.add(new ColumnDef("C59_T20_조세조약상교직자감면금액", Ye169010BM.ATTR_YETAC59T20, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C60_비과세합계금액 : yeta0c60 */
        listColumnDefs.add(new ColumnDef("C60_비과세합계금액", Ye169010BM.ATTR_YETA0C60, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C61_감면소득합계금액 : yeta0c61 */
        listColumnDefs.add(new ColumnDef("C61_감면소득합계금액", Ye169010BM.ATTR_YETA0C61, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C63_정산명세_총급여금액 : yeta0c63 */
        listColumnDefs.add(new ColumnDef("C63_정산명세_총급여금액", Ye169010BM.ATTR_YETA0C63, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C64_정산명세_근로소득공제금액 : yeta0c64 */
        listColumnDefs.add(new ColumnDef("C64_정산명세_근로소득공제금액", Ye169010BM.ATTR_YETA0C64, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C65_정산명세_근로소득금액 : yeta0c65 */
        listColumnDefs.add(new ColumnDef("C65_정산명세_근로소득금액", Ye169010BM.ATTR_YETA0C65, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C66_기본공제_본인공제금액 : yeta0c66 */
        listColumnDefs.add(new ColumnDef("C66_기본공제_본인공제금액", Ye169010BM.ATTR_YETA0C66, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C67_기본공제_배우자공제금액 : yeta0c67 */
        listColumnDefs.add(new ColumnDef("C67_기본공제_배우자공제금액", Ye169010BM.ATTR_YETA0C67, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C68_기본공제_부양공제인원수 : yeta0c68 */
        listColumnDefs.add(new ColumnDef("C68_기본공제_부양공제인원수", Ye169010BM.ATTR_YETA0C68, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C69_기본공제_부양공제금액 : yeta0c69 */
        listColumnDefs.add(new ColumnDef("C69_기본공제_부양공제금액", Ye169010BM.ATTR_YETA0C69, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C70_추가공제_경로우대공제인원수 : yeta0c70 */
        listColumnDefs.add(new ColumnDef("C70_추가공제_경로우대공제인원수", Ye169010BM.ATTR_YETA0C70, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C71_추가공제_경로우대공제금액 : yeta0c71 */
        listColumnDefs.add(new ColumnDef("C71_추가공제_경로우대공제금액", Ye169010BM.ATTR_YETA0C71, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C72_추가공제_장애인공제인원수 : yeta0c72 */
        listColumnDefs.add(new ColumnDef("C72_추가공제_장애인공제인원수", Ye169010BM.ATTR_YETA0C72, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C73_추가공제_장애인공제금액 : yeta0c73 */
        listColumnDefs.add(new ColumnDef("C73_추가공제_장애인공제금액", Ye169010BM.ATTR_YETA0C73, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C74_추가공제_부녀자공제금액 : yeta0c74 */
        listColumnDefs.add(new ColumnDef("C74_추가공제_부녀자공제금액", Ye169010BM.ATTR_YETA0C74, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C75_추가공제_한부모가족공제금액 : yeta0c75 */
        listColumnDefs.add(new ColumnDef("C75_추가공제_한부모가족공제금액", Ye169010BM.ATTR_YETA0C75, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C76_연금보험료_국민연금보험료공제금액 : yeta0c76 */
        listColumnDefs.add(new ColumnDef("C76_연금보험료_국민연금보험료공제금액", Ye169010BM.ATTR_YETA0C76, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C77_연금보험료_공적연금보험료공제_공무원연금 : yeta0c77 */
        listColumnDefs.add(new ColumnDef("C77_연금보험료_공적연금보험료공제_공무원연금", Ye169010BM.ATTR_YETA0C77, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C78_연금보험료_공적연금보험료공제_군인연금 : yeta0c78 */
        listColumnDefs.add(new ColumnDef("C78_연금보험료_공적연금보험료공제_군인연금", Ye169010BM.ATTR_YETA0C78, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C79_연금보험료_공적연금보험료공제_사립학교교직원연금 : yeta0c79 */
        listColumnDefs.add(new ColumnDef("C79_연금보험료_공적연금보험료공제_사립학교교직원연금", Ye169010BM.ATTR_YETA0C79, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C80_연금보험료_공적연금보험료공제_별정우체국연금 : yeta0c80 */
        listColumnDefs.add(new ColumnDef("C80_연금보험료_공적연금보험료공제_별정우체국연금", Ye169010BM.ATTR_YETA0C80, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C81_특별소득공제_보험료_건강보험료 : yeta0c81 */
        listColumnDefs.add(new ColumnDef("C81_특별소득공제_보험료_건강보험료", Ye169010BM.ATTR_YETA0C81, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C82_특별소득공제_보험료_고용보험료 : yeta0c82 */
        listColumnDefs.add(new ColumnDef("C82_특별소득공제_보험료_고용보험료", Ye169010BM.ATTR_YETA0C82, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C83_특별소득공제_주택자금_추택임차차입금_대출기관 : yeta0c83 */
        listColumnDefs.add(new ColumnDef("C83_특별소득공제_주택자금_추택임차차입금_대출기관", Ye169010BM.ATTR_YETA0C83, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C84_특별소득공제_주택자금_주택임차차입금_거주자 : yeta0c84 */
        listColumnDefs.add(new ColumnDef("C84_특별소득공제_주택자금_주택임차차입금_거주자", Ye169010BM.ATTR_YETA0C84, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C85_특별소득공제_주택자금_장기주택저당차입금2011전_15미만 : yeta0c85 */
        listColumnDefs.add(new ColumnDef("C85_특별소득공제_주택자금_장기주택저당차입금2011전_15미만", Ye169010BM.ATTR_YETA0C85, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C86_특별소득공제_주택자금_장기주택저당차입금2011전_15_29 : yeta0c86 */
        listColumnDefs.add(new ColumnDef("C86_특별소득공제_주택자금_장기주택저당차입금2011전_15_29", Ye169010BM.ATTR_YETA0C86, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C87_특별소득공제_주택자금_장기주택저당차입금2011전_30이상 : yeta0c87 */
        listColumnDefs.add(new ColumnDef("C87_특별소득공제_주택자금_장기주택저당차입금2011전_30이상", Ye169010BM.ATTR_YETA0C87, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C88_특별소득공제_차입분2012후_15이상_고정금리비거치식상환대출금액 : yeta0c88 */
        listColumnDefs.add(new ColumnDef("C88_특별소득공제_차입분2012후_15이상_고정금리비거치식상환대출금액", Ye169010BM.ATTR_YETA0C88, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C89_특별소득공제_차입분2012후_15이상_기타대출금액 : yeta0c89 */
        listColumnDefs.add(new ColumnDef("C89_특별소득공제_차입분2012후_15이상_기타대출금액", Ye169010BM.ATTR_YETA0C89, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C90_특별소득공제_차입분2015후_상환15이상_고정금리이고비거치상환대출금액 : yeta0c90 */
        listColumnDefs.add(new ColumnDef("C90_특별소득공제_차입분2015후_상환15이상_고정금리이고비거치상환대출금액", Ye169010BM.ATTR_YETA0C90, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C91_특별소득공제_차입분2015후_상환15이상_고정금리이거나비거치상환대출금액 : yeta0c91 */
        listColumnDefs.add(new ColumnDef("C91_특별소득공제_차입분2015후_상환15이상_고정금리이거나비거치상환대출금액", Ye169010BM.ATTR_YETA0C91, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C92_특별소득공제_차입분2015후_상환15이상_그밖의대출금액 : yeta0c92 */
        listColumnDefs.add(new ColumnDef("C92_특별소득공제_차입분2015후_상환15이상_그밖의대출금액", Ye169010BM.ATTR_YETA0C92, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C93_특별소득공제_차입분2015후_상환10이상_고정금리이거나비거치상환대출금액 : yeta0c93 */
        listColumnDefs.add(new ColumnDef("C93_특별소득공제_차입분2015후_상환10이상_고정금리이거나비거치상환대출금액", Ye169010BM.ATTR_YETA0C93, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C94_특별소득공제_기부금_이월분금액 : yeta0c94 */
        listColumnDefs.add(new ColumnDef("C94_특별소득공제_기부금_이월분금액", Ye169010BM.ATTR_YETA0C94, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C96_특별소득공제_특별소득공제합계 : yeta0c96 */
        listColumnDefs.add(new ColumnDef("C96_특별소득공제_특별소득공제합계", Ye169010BM.ATTR_YETA0C96, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C97_차감소득금액 : yeta0c97 */
        listColumnDefs.add(new ColumnDef("C97_차감소득금액", Ye169010BM.ATTR_YETA0C97, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C98_기타소득공제_개인연금저축소득공제금액 : yeta0c98 */
        listColumnDefs.add(new ColumnDef("C98_기타소득공제_개인연금저축소득공제금액", Ye169010BM.ATTR_YETA0C98, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C99_기타소득공제_소기업소상공인공제부금금액 : yeta0c99 */
        listColumnDefs.add(new ColumnDef("C99_기타소득공제_소기업소상공인공제부금금액", Ye169010BM.ATTR_YETA0C99, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C100_기타소득공제_주택마련저축소득공제_청약저축금액 : yetaC100 */
        listColumnDefs.add(new ColumnDef("C100_기타소득공제_주택마련저축소득공제_청약저축금액", Ye169010BM.ATTR_YETAC100, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C101_기타소득공제_주택마련저축소득공제_주택청약종합저축금액 : yetaC101 */
        listColumnDefs.add(new ColumnDef("C101_기타소득공제_주택마련저축소득공제_주택청약종합저축금액", Ye169010BM.ATTR_YETAC101, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C102_기타소득공제_주택마련저축소득공제_근로자주택마련저축금액 : yetaC102 */
        listColumnDefs.add(new ColumnDef("C102_기타소득공제_주택마련저축소득공제_근로자주택마련저축금액", Ye169010BM.ATTR_YETAC102, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C103_기타소득공제_투자조합출자등소득공제금액 : yetaC103 */
        listColumnDefs.add(new ColumnDef("C103_기타소득공제_투자조합출자등소득공제금액", Ye169010BM.ATTR_YETAC103, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C104_기타소득공제_신용카드등소득공제금액 : yetaC104 */
        listColumnDefs.add(new ColumnDef("C104_기타소득공제_신용카드등소득공제금액", Ye169010BM.ATTR_YETAC104, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C105_기타소득공제_우리사주조합출연금액 : yetaC105 */
        listColumnDefs.add(new ColumnDef("C105_기타소득공제_우리사주조합출연금액", Ye169010BM.ATTR_YETAC105, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C107_기타소득공제_고용유지중소기업근로자소득공제금액 : yetaC107 */
        listColumnDefs.add(new ColumnDef("C107_기타소득공제_고용유지중소기업근로자소득공제금액", Ye169010BM.ATTR_YETAC107, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C108_기타소득공제_목돈안이자상환공제금액 : yetaC108 */
        listColumnDefs.add(new ColumnDef("C108_기타소득공제_목돈안이자상환공제금액", Ye169010BM.ATTR_YETAC108, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C109_기타소득공제_장기집합투자증권저축금액 : yetaC109 */
        listColumnDefs.add(new ColumnDef("C109_기타소득공제_장기집합투자증권저축금액", Ye169010BM.ATTR_YETAC109, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C110_기타소득공제합계금액 : yetaC110 */
        listColumnDefs.add(new ColumnDef("C110_기타소득공제합계금액", Ye169010BM.ATTR_YETAC110, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C111_소득공제종합한도초과금액 : yetaC111 */
        listColumnDefs.add(new ColumnDef("C111_소득공제종합한도초과금액", Ye169010BM.ATTR_YETAC111, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C112_종합소득과세표준금액 : yetaC112 */
        listColumnDefs.add(new ColumnDef("C112_종합소득과세표준금액", Ye169010BM.ATTR_YETAC112, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C113_산출세액 : yetaC113 */
        listColumnDefs.add(new ColumnDef("C113_산출세액", Ye169010BM.ATTR_YETAC113, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C114_세액감면_소득세법감면금액 : yetaC114 */
        listColumnDefs.add(new ColumnDef("C114_세액감면_소득세법감면금액", Ye169010BM.ATTR_YETAC114, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C115_세액감면_조특법_조세조약제외_감면금액 : yetaC115 */
        listColumnDefs.add(new ColumnDef("C115_세액감면_조특법_조세조약제외_감면금액", Ye169010BM.ATTR_YETAC115, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C116_세액감면_조특범20조_감면금액 : yetaC116 */
        listColumnDefs.add(new ColumnDef("C116_세액감면_조특범20조_감면금액", Ye169010BM.ATTR_YETAC116, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C117_세액감면_조세조약감면금액 : yetaC117 */
        listColumnDefs.add(new ColumnDef("C117_세액감면_조세조약감면금액", Ye169010BM.ATTR_YETAC117, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C119_세액감면합계금액 : yetaC119 */
        listColumnDefs.add(new ColumnDef("C119_세액감면합계금액", Ye169010BM.ATTR_YETAC119, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C120_세액공제_근로소득세액공제금액 : yetaC120 */
        listColumnDefs.add(new ColumnDef("C120_세액공제_근로소득세액공제금액", Ye169010BM.ATTR_YETAC120, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C121_세액공제_자녀세액공제인원수 : yetaC121 */
        listColumnDefs.add(new ColumnDef("C121_세액공제_자녀세액공제인원수", Ye169010BM.ATTR_YETAC121, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C122_세액공제_자녀세액공제금액 : yetaC122 */
        listColumnDefs.add(new ColumnDef("C122_세액공제_자녀세액공제금액", Ye169010BM.ATTR_YETAC122, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C123_세액공제_6세이하자녀세액공제인원수 : yetaC123 */
        listColumnDefs.add(new ColumnDef("C123_세액공제_6세이하자녀세액공제인원수", Ye169010BM.ATTR_YETAC123, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C124_세액공제_6세이하자녀세액공제금액 : yetaC124 */
        listColumnDefs.add(new ColumnDef("C124_세액공제_6세이하자녀세액공제금액", Ye169010BM.ATTR_YETAC124, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C125_세액공제_출산입양세액공제인원수 : yetaC125 */
        listColumnDefs.add(new ColumnDef("C125_세액공제_출산입양세액공제인원수", Ye169010BM.ATTR_YETAC125, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C126_세액공제_출산입양세액공제금액 : yetaC126 */
        listColumnDefs.add(new ColumnDef("C126_세액공제_출산입양세액공제금액", Ye169010BM.ATTR_YETAC126, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C127_세액공제_연금계좌_과학기술인공제공제대상금액 : yetaC127 */
        listColumnDefs.add(new ColumnDef("C127_세액공제_연금계좌_과학기술인공제공제대상금액", Ye169010BM.ATTR_YETAC127, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C128_세액공제_연금계좌_과학기술인공제세액공제금액 : yetaC128 */
        listColumnDefs.add(new ColumnDef("C128_세액공제_연금계좌_과학기술인공제세액공제금액", Ye169010BM.ATTR_YETAC128, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C129_세액공제_연금계좌_퇴직급여세액공제대상금액 : yetaC129 */
        listColumnDefs.add(new ColumnDef("C129_세액공제_연금계좌_퇴직급여세액공제대상금액", Ye169010BM.ATTR_YETAC129, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C130_세액공제_연금계좌_퇴직급여세액공제금액 : yetaC130 */
        listColumnDefs.add(new ColumnDef("C130_세액공제_연금계좌_퇴직급여세액공제금액", Ye169010BM.ATTR_YETAC130, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C131_세액공제_연금계좌_연금저축공제대상금액 : yetaC131 */
        listColumnDefs.add(new ColumnDef("C131_세액공제_연금계좌_연금저축공제대상금액", Ye169010BM.ATTR_YETAC131, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C132_세액공제_연금계좌_연금저축세액공제금액 : yetaC132 */
        listColumnDefs.add(new ColumnDef("C132_세액공제_연금계좌_연금저축세액공제금액", Ye169010BM.ATTR_YETAC132, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C133_세액공제_특별세액공제_보장성보험공제대상금액 : yetaC133 */
        listColumnDefs.add(new ColumnDef("C133_세액공제_특별세액공제_보장성보험공제대상금액", Ye169010BM.ATTR_YETAC133, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C134_세액공제_특별세액공제_보장성보럼세액공제금액 : yetaC134 */
        listColumnDefs.add(new ColumnDef("C134_세액공제_특별세액공제_보장성보럼세액공제금액", Ye169010BM.ATTR_YETAC134, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C135_세액공제_특별세액공제_장애인전용공제대상금액 : yetaC135 */
        listColumnDefs.add(new ColumnDef("C135_세액공제_특별세액공제_장애인전용공제대상금액", Ye169010BM.ATTR_YETAC135, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C136_세액공제_특별세액공제_장애인전용세액공제금액 : yetaC136 */
        listColumnDefs.add(new ColumnDef("C136_세액공제_특별세액공제_장애인전용세액공제금액", Ye169010BM.ATTR_YETAC136, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C137_세액공제_특별세액공제_의료비공제대상금액 : yetaC137 */
        listColumnDefs.add(new ColumnDef("C137_세액공제_특별세액공제_의료비공제대상금액", Ye169010BM.ATTR_YETAC137, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C138_세액공제_특별세액공제_의료비세액공제금액 : yetaC138 */
        listColumnDefs.add(new ColumnDef("C138_세액공제_특별세액공제_의료비세액공제금액", Ye169010BM.ATTR_YETAC138, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C139_세액공제_특별세액공제_교육비공제대상금액 : yetaC139 */
        listColumnDefs.add(new ColumnDef("C139_세액공제_특별세액공제_교육비공제대상금액", Ye169010BM.ATTR_YETAC139, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C140_세액공제_특별세액공제_교육비세액공제금액 : yetaC140 */
        listColumnDefs.add(new ColumnDef("C140_세액공제_특별세액공제_교육비세액공제금액", Ye169010BM.ATTR_YETAC140, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C141_세액공제_특별세액공제_기부금정치자금10만이하공제대상금액 : yetaC141 */
        listColumnDefs.add(new ColumnDef("C141_세액공제_특별세액공제_기부금정치자금10만이하공제대상금액", Ye169010BM.ATTR_YETAC141, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C142_세액공제_특별세액공제_기부금정치자금10만이하세액공제금액 : yetaC142 */
        listColumnDefs.add(new ColumnDef("C142_세액공제_특별세액공제_기부금정치자금10만이하세액공제금액", Ye169010BM.ATTR_YETAC142, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C143_세액공제_특별세액공제_기부금정치자금10만초과공제대상금액 : yetaC143 */
        listColumnDefs.add(new ColumnDef("C143_세액공제_특별세액공제_기부금정치자금10만초과공제대상금액", Ye169010BM.ATTR_YETAC143, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C144_세액공제_특별세액공제_기부금정치자금10만초과세액공제금액 : yetaC144 */
        listColumnDefs.add(new ColumnDef("C144_세액공제_특별세액공제_기부금정치자금10만초과세액공제금액", Ye169010BM.ATTR_YETAC144, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C145_세액공제_특별세액공제_법정기부금공제대상금액 : yetaC145 */
        listColumnDefs.add(new ColumnDef("C145_세액공제_특별세액공제_법정기부금공제대상금액", Ye169010BM.ATTR_YETAC145, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C146_세액공제_특별세액공제_법정기부금세액공제금액 : yetaC146 */
        listColumnDefs.add(new ColumnDef("C146_세액공제_특별세액공제_법정기부금세액공제금액", Ye169010BM.ATTR_YETAC146, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C147_세액공제_특별세액공제_우리사주조합기부금공제대상금액 : yetaC147 */
        listColumnDefs.add(new ColumnDef("C147_세액공제_특별세액공제_우리사주조합기부금공제대상금액", Ye169010BM.ATTR_YETAC147, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C148_세액공제_특별세액공제_우리사주조합기부금세액공제금액 : yetaC148 */
        listColumnDefs.add(new ColumnDef("C148_세액공제_특별세액공제_우리사주조합기부금세액공제금액", Ye169010BM.ATTR_YETAC148, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C149_세액공제_특별세액공제_지정기부금_종교단체외공제대상금액 : yetaC149 */
        listColumnDefs.add(new ColumnDef("C149_세액공제_특별세액공제_지정기부금_종교단체외공제대상금액", Ye169010BM.ATTR_YETAC149, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C150_세액공제_특별세액공제_지정기부금_종교단체외세액공제금액 : yetaC150 */
        listColumnDefs.add(new ColumnDef("C150_세액공제_특별세액공제_지정기부금_종교단체외세액공제금액", Ye169010BM.ATTR_YETAC150, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C150A_세액공제_특별세액공제_지정기부금_종교단체공제대상금액 : yetaC150a */
        listColumnDefs.add(new ColumnDef("C150A_세액공제_특별세액공제_지정기부금_종교단체공제대상금액", Ye169010BM.ATTR_YETAC150A, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C150B_세액공제_특별세액공제_지정기부금_종교단체세액공제금액 : yetaC150b */
        listColumnDefs.add(new ColumnDef("C150B_세액공제_특별세액공제_지정기부금_종교단체세액공제금액", Ye169010BM.ATTR_YETAC150B, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C151_세액공제_특별세액공제합계금액 : yetaC151 */
        listColumnDefs.add(new ColumnDef("C151_세액공제_특별세액공제합계금액", Ye169010BM.ATTR_YETAC151, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C152_세액공제_표준세액공제금액 : yetaC152 */
        listColumnDefs.add(new ColumnDef("C152_세액공제_표준세액공제금액", Ye169010BM.ATTR_YETAC152, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C153_세액공제_납세조합공제금액 : yetaC153 */
        listColumnDefs.add(new ColumnDef("C153_세액공제_납세조합공제금액", Ye169010BM.ATTR_YETAC153, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C154_세액공제_주택차입금금액 : yetaC154 */
        listColumnDefs.add(new ColumnDef("C154_세액공제_주택차입금금액", Ye169010BM.ATTR_YETAC154, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C155_세액공제_외국납부금액 : yetaC155 */
        listColumnDefs.add(new ColumnDef("C155_세액공제_외국납부금액", Ye169010BM.ATTR_YETAC155, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C156_세액공제_월세세액공제대상금액 : yetaC156 */
        listColumnDefs.add(new ColumnDef("C156_세액공제_월세세액공제대상금액", Ye169010BM.ATTR_YETAC156, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C157_세액공제_월세세액공제금액 : yetaC157 */
        listColumnDefs.add(new ColumnDef("C157_세액공제_월세세액공제금액", Ye169010BM.ATTR_YETAC157, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C158_세액공제합계금액 : yetaC158 */
        listColumnDefs.add(new ColumnDef("C158_세액공제합계금액", Ye169010BM.ATTR_YETAC158, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C159_결정세액_소득세금액 : yetaC159 */
        listColumnDefs.add(new ColumnDef("C159_결정세액_소득세금액", Ye169010BM.ATTR_YETAC159, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C160_결정세액_지방소득세금액 : yetaC160 */
        listColumnDefs.add(new ColumnDef("C160_결정세액_지방소득세금액", Ye169010BM.ATTR_YETAC160, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C161_결정세액_농특세금액 : yetaC161 */
        listColumnDefs.add(new ColumnDef("C161_결정세액_농특세금액", Ye169010BM.ATTR_YETAC161, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C162_주현근무지_기납부세액_소득세금액 : yetaC162 */
        listColumnDefs.add(new ColumnDef("C162_주현근무지_기납부세액_소득세금액", Ye169010BM.ATTR_YETAC162, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C163_주현근무지_기납부세액_지방소득세금액 : yetaC163 */
        listColumnDefs.add(new ColumnDef("C163_주현근무지_기납부세액_지방소득세금액", Ye169010BM.ATTR_YETAC163, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C164_주현근무지_기납부세액_농특세금액 : yetaC164 */
        listColumnDefs.add(new ColumnDef("C164_주현근무지_기납부세액_농특세금액", Ye169010BM.ATTR_YETAC164, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C165_납부특례세액_소득세금액 : yetaC165 */
        listColumnDefs.add(new ColumnDef("C165_납부특례세액_소득세금액", Ye169010BM.ATTR_YETAC165, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C166_납부특례세액_지방소득세금액 : yetaC166 */
        listColumnDefs.add(new ColumnDef("C166_납부특례세액_지방소득세금액", Ye169010BM.ATTR_YETAC166, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C167_납부특례세액_농특세금액 : yetaC167 */
        listColumnDefs.add(new ColumnDef("C167_납부특례세액_농특세금액", Ye169010BM.ATTR_YETAC167, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C168_차감징수세액_소득세금액 : yetaC168 */
        listColumnDefs.add(new ColumnDef("C168_차감징수세액_소득세금액", Ye169010BM.ATTR_YETAC168, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C169_차감징수세액_지방소득세금액 : yetaC169 */
        listColumnDefs.add(new ColumnDef("C169_차감징수세액_지방소득세금액", Ye169010BM.ATTR_YETAC169, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column C170_차감징수세액_농특세금액 : yetaC170 */
        listColumnDefs.add(new ColumnDef("C170_차감징수세액_농특세금액", Ye169010BM.ATTR_YETAC170, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye169010BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye169010BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye169010BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye169010BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye169010BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye169010BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

			}
		});

		return listColumnDefs;
	}

     
    private List<ColumnDef> getYeta2300ToYe169010ColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye169010BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", Ye169010BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye169010BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye169010BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 구분 : settGbnm */
        listColumnDefs.add(new ColumnDef("구분", Yeta3000BM.ATTR_SETTGBNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
     
        
        /** column 차감징수_소득세 : subtEtax */
        listColumnDefs.add(new ColumnDef("소득세", Yeta3000BM.ATTR_SUBTETAX, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        /** column 차감징수_주민세_지방소득세 : subtInhb */
        listColumnDefs.add(new ColumnDef("지방소득세", Yeta3000BM.ATTR_SUBTINHB, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        /** column 차감징수_농특세 : subtFafv */
        listColumnDefs.add(new ColumnDef("농특세", Yeta3000BM.ATTR_SUBTFAFV, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });

		return listColumnDefs;
	}

}
 
