package org.msf.exterms.xls.service.impl;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.app.exterms.insurance.server.vo.Insr3200VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.excel.EgovExcelMapping;
import egovframework.rte.fdl.excel.util.EgovExcelUtil;

public class xlsInsr4200Mapping  extends EgovExcelMapping {

//	ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
	//MSFUserInfo userInfo = MSFUserInfoManager.getUserInfo();
//	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(attr.getRequest());
        /**
         * edi연 엑셀파일 맵핑
         */
        @SuppressWarnings("deprecation")
        @Override
        public Object mappingColumn(HSSFRow row) { 
        	
        	 ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();  
        	 MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(attr.getRequest());
        	 
        	HSSFCell cell0 = row.getCell((int) 0);
        	HSSFCell cell1 = row.getCell((int) 1);
        	HSSFCell cell2 = row.getCell((int) 2);
        	HSSFCell cell3 = row.getCell((int) 3);
        	HSSFCell cell4 = row.getCell((int) 4);
        	HSSFCell cell5 = row.getCell((int) 5);
        	HSSFCell cell6 = row.getCell((int) 6);
        	HSSFCell cell7 = row.getCell((int) 7);
        	HSSFCell cell8 = row.getCell((int) 8);
        	HSSFCell cell9 = row.getCell((int) 9);
        	HSSFCell cell10 = row.getCell((int) 10);
        	HSSFCell cell11 = row.getCell((int) 11);
        	HSSFCell cell12 = row.getCell((int) 12);
        	HSSFCell cell13 = row.getCell((int) 13);
        	HSSFCell cell14 = row.getCell((int) 14);
        	HSSFCell cell15 = row.getCell((int) 15);
        	HSSFCell cell16 = row.getCell((int) 16);
        	HSSFCell cell17 = row.getCell((int) 17);
        	HSSFCell cell18 = row.getCell((int) 18);
        	HSSFCell cell19 = row.getCell((int) 19);
        	HSSFCell cell20 = row.getCell((int) 20);
        	HSSFCell cell21 = row.getCell((int) 21);
        	HSSFCell cell22 = row.getCell((int) 22);
        	HSSFCell cell23 = row.getCell((int) 23);
        	HSSFCell cell24 = row.getCell((int) 24);
        	HSSFCell cell25 = row.getCell((int) 25);
        	HSSFCell cell26 = row.getCell((int) 26);
        	HSSFCell cell27 = row.getCell((int) 27);
        	HSSFCell cell28 = row.getCell((int) 28);
        	HSSFCell cell29 = row.getCell((int) 29);
        	HSSFCell cell30 = row.getCell((int) 30);
        	HSSFCell cell31 = row.getCell((int) 31);
        	HSSFCell cell32 = row.getCell((int) 32);
        	HSSFCell cell33 = row.getCell((int) 33);
        	HSSFCell cell34 = row.getCell((int) 34); 

            Insr3200VO insr3200Vo = new Insr3200VO(); 
             
    	    	
            
 //           insr3200Vo.setDpobCd(" " );  /** column 사업장코드 : dpobCd */  
//           insr3200Vo.setDpobCd("20155350000001" );	//김해
//            insr3200Vo.setDpobCd("20163900000001" );	//광명
//            insr3200Vo.setDpobCd("20155370000001" );	//거제 
           insr3200Vo.setDpobCd(sessionUser.getDpobCd());  
         //   insr3200Vo.setDpobCd("20153730000001" ); 

			//insr3200Vo.setSystemkey(EgovExcelUtil.getValue(cell2));    /** column SYSTEMKEY : systemkey */
			//insr3200Vo.setDpobCd(EgovExcelUtil.getValue(cell2));    /** column 사업장코드 : dpobCd */
			insr3200Vo.setNofctYrMnth(EgovExcelUtil.getValue(cell0));    /** column 고지년월 : nofctYrMnth */
			insr3200Vo.setNofctDspty(new Long(EgovExcelUtil.getValue(cell3)));    /** column 고지차수 : nofctDspty */
		//	insr3200Vo.setHlthInsrSeilNum(BigDecimal.ZERO);    /** column 건강보험일련번호 : hlthInsrSeilNum */
			insr3200Vo.setDpobMangeNum(EgovExcelUtil.getValue(cell1));    /** column 사업장관리번호 : dpobMangeNum */
			insr3200Vo.setUntIstutCd(EgovExcelUtil.getValue(cell2));    /** column 단위기관코드 : untIstutCd */
			insr3200Vo.setAccSgn(EgovExcelUtil.getValue(cell4));    /** column 회계부호 : accSgn */
			insr3200Vo.setHlthInsrCertNum(EgovExcelUtil.getValue(cell5));    /** column 건강보험증번호 : hlthInsrCertNum */
			insr3200Vo.setHanNm(EgovExcelUtil.getValue(cell6));    /** column 한글성명 : hanNm */
			insr3200Vo.setResnRegnNum(EgovExcelUtil.getValue(cell7));    /** column 주민등록번호 : resnRegnNum */
			insr3200Vo.setReduReasCd(EgovExcelUtil.getValue(cell8));    /** column 감면사유코드 : reduReasCd */
			insr3200Vo.setHlthInsrTypOccuCd(EgovExcelUtil.getValue(cell9));    /** column 건강보험직종코드 : hlthInsrTypOccuCd */
			insr3200Vo.setPayMnthAmntGrde(EgovExcelUtil.getValue(cell10));    /** column 보수월액등급 : payMnthAmntGrde */
			insr3200Vo.setPayMnthAmnt(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell11),"0")));    /** column 보수월액 : payMnthAmnt */
			insr3200Vo.setCalcPrmm(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell12),"0")));    /** column 산출보험료 : calcPrmm */
			insr3200Vo.setClutReasCd(EgovExcelUtil.getValue(cell13));    /** column 정산사유코드 : clutReasCd */
			insr3200Vo.setClutApptnBgnnYrMnth(EgovExcelUtil.getValue(cell14));    /** column 정산적용시작년월 : clutApptnBgnnYrMnth */
			insr3200Vo.setClutApptnEndYrMnth(EgovExcelUtil.getValue(cell15));    /** column 정산적용종료년월 : clutApptnEndYrMnth */
			insr3200Vo.setClutPrmm(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell16),"0")));    /** column 정산보험료 : clutPrmm */
			insr3200Vo.setNofctPrmm(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell17),"0")));    /** column 고지보험료 : nofctPrmm */
			insr3200Vo.setYrtxPrmm(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell18),"0")));    /** column 연말정산보험료 : yrtxPrmm */
			insr3200Vo.setAqtnDt(EgovExcelUtil.getValue(cell19));    /** column 취득일자 : aqtnDt */
			insr3200Vo.setLssDt(EgovExcelUtil.getValue(cell20));    /** column 상실일자 : lssDt */
			insr3200Vo.setLgtmRcptnCalcPrmm(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell21),"0")));    /** column 요양산출보험료 : lgtmRcptnCalcPrmm */
			insr3200Vo.setLgtmRcptnClutReasCd(EgovExcelUtil.getValue(cell22));    /** column 요양정산사유코드 : lgtmRcptnClutReasCd */
			insr3200Vo.setLgtmRcptnApptnBgnnYrMnth(EgovExcelUtil.getValue(cell23));    /** column 요양정산적용시작년월 : lgtmRcptnApptnBgnnYrMnth */
			insr3200Vo.setLgtmRcptnApptnEndYrMnth(EgovExcelUtil.getValue(cell24));    /** column 요양정산적용종료년월 : lgtmRcptnApptnEndYrMnth */
			insr3200Vo.setLgtmRcptnClutPrmm(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell25),"0")));    /** column 요양정산보험료 : lgtmRcptnClutPrmm */
			insr3200Vo.setLgtmRcptnNofctPrmm(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell26),"0")));    /** column 요양고지보험료 : lgtmRcptnNofctPrmm */
			insr3200Vo.setLgtmRcptnYrtxPrmm(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell27),"0")));    /** column 요양연말정산보험료 : lgtmRcptnYrtxPrmm */
			insr3200Vo.setHlthRcptnCalcPrmm(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell28),"0")));    /** column 건강_요양산출보험료계 : hlthRcptnCalcPrmm */
			insr3200Vo.setHlthRcptnClutPrmm(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell29),"0")));    /** column 건강_요양정산보험료계 : hlthRcptnClutPrmm */
			insr3200Vo.setHlthRcptnNofctPrmm(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell30),"0")));    /** column 건강_요양고지보험료계 : hlthRcptnNofctPrmm */
			insr3200Vo.setHlthRcptnYrtxPrmm(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell31),"0")));    /** column 건강_요양연말정산보험료계 : hlthRcptnYrtxPrmm */
			insr3200Vo.setHlthInsrRefdItrt(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell32),"0")));    /** column 건강환급금이자 : hlthInsrRefdItrt */
			insr3200Vo.setLgtmRcptnRefdItrt(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell33),"0")));    /** column 요양환급금이자 : lgtmRcptnRefdItrt */
			insr3200Vo.setTotPymtPrmm(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell34),"0")));    /** column 총납부보험료 : totPymtPrmm */
			insr3200Vo.setDducYrMnth(EgovExcelUtil.getValue(cell0));    /** column 공제년월 : dducYrMnth */
			insr3200Vo.setKybdr("FileUpdate");    /** column 입력자 : kybdr */
//			insr3200Vo.setInptDt(EgovExcelUtil.getValue(cell2));    /** column 입력일자 : inptDt */
//			insr3200Vo.setInptAddr(EgovExcelUtil.getValue(cell2));    /** column 입력주소 : inptAddr */
//			insr3200Vo.setIsmt(EgovExcelUtil.getValue(cell2));    /** column 수정자 : ismt */
//			insr3200Vo.setRevnDt(EgovExcelUtil.getValue(cell2));    /** column 수정일자 : revnDt */
//			insr3200Vo.setRevnAddr(EgovExcelUtil.getValue(cell2));    /** column 수정주소 : revnAddr */
 
            return insr3200Vo;
        }
}
