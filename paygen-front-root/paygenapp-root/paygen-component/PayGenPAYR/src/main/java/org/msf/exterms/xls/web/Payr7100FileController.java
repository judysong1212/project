package org.msf.exterms.xls.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.payroll.client.dto.Hpe100DTO;
import com.app.exterms.payroll.server.service.dao.Hpe100DAO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

@Controller
public class Payr7100FileController {
	private static final Logger logger = LoggerFactory.getLogger(Payr7100FileController.class);

	// 원천세신고기준  
	@Autowired
	@Resource(name = "Hpe100DAO")
	private Hpe100DAO hpe100DAO;

	@RequestMapping(value = "/exp/FilePayr7100Export.do")
    public String FilePayr7100Export( @ModelAttribute("Hpe100DTO") Hpe100DTO hpe100Dto
    								, HashMap<String, String> param
    								, final HttpServletRequest request
    								, final HttpServletResponse response
    								, Map commandMap
    								, Model model	) throws Exception {
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        String sResult = "";
        int state = 0;

        try	{
    		List<String> listDeptCd = new ArrayList<String>(); 
    	   	hpe100Dto.setDPOB_CD(sessionUser.getDpobCd());	//사업장코드
    	   	hpe100Dto.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
    	  	
    	   	hpe100Dto.setDeptCdAuth(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDeptCd()));  //권한처리를위해 추가  
    	   	hpe100Dto.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDtilOccuInttnCd()).replace(",", ""));
    	   	hpe100Dto.setREVN_ADDR(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
    	     
    	   	hpe100Dto.setUsrId(sessionUser.getUsrId());
    	   	/******************************** 권한 ************************************************************************/
    	   	String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();

    	   	if ("FALSE".equals(chkDeptCd)) {
    	   		if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(hpe100Dto.getSrhDeptCd(),sessionUser.getDeptCd()))) {
    	   			hpe100Dto.setSrhDeptCd(sessionUser.getDeptCd()); 
    	   			listDeptCd.add(sessionUser.getDeptCd());
    	   			hpe100Dto.setDeptCdArr(listDeptCd);     //부서코드
    	   		} else {
    	   			hpe100Dto.setSrhDeptCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDeptCd()));
    	   			listDeptCd = SmrmfUtils.getStrToArrayList(hpe100Dto.getSrhDeptCd());  
    	   			hpe100Dto.setDeptCdArr(listDeptCd);     //부서코드    
    	   		}
    	   		
    	   		hpe100Dto.setSrhPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
    	   	} else {
    	   		hpe100Dto.setSrhPayrMangDeptCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhPayrMangDeptCd())) ;   //단위기관코드   
    	   	 		
    	   		if (hpe100Dto.getSrhPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDeptCd()))) { 
    	   			listDeptCd = null; 
    	   			hpe100Dto.setDeptCdArr(listDeptCd);     //부서코드 
    	   			hpe100Dto.setSrhDeptCd("");  //부서코드
    	   		} else {
    	   			hpe100Dto.setSrhDeptCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDeptCd()));
    	   			listDeptCd = SmrmfUtils.getStrToArrayList(hpe100Dto.getSrhDeptCd());  
    	   			hpe100Dto.setDeptCdArr(listDeptCd);     //부서코드   
    	   		}
    	   	}
    	     
    	   	/******************************** 권한 ************************************************************************/
    	   	hpe100Dto.setSrhEmymtDivCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhEmymtDivCd()));      		//고용구분코드
    	   	
    	   	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(hpe100Dto.getSrhTypOccuCd())); 
    	   	hpe100Dto.setTypOccuCdArr(lstTypeOccuCd); 
    	   	hpe100Dto.setSrhTypOccuCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhTypOccuCd()));  	//직종
    	   	
    	   	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDtilOccuInttnCd())); 
    	   	hpe100Dto.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
    	   	hpe100Dto.setSrhDtilOccuInttnCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDtilOccuInttnCd())); //직종세
    	        
    	   	List<String> lstBusinCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(hpe100Dto.getSrhBusinCd())); 
    	   	hpe100Dto.setBusinCdArr(lstBusinCd);
    	   	hpe100Dto.setSrhBusinCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhBusinCd()));   //사업코드
    	   	
    	   	hpe100Dto.setSrhUtDpobCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhUtDpobCd()));				//원천신고부서
    	   	hpe100Dto.setDEPT_CD(MSFSharedUtils.defaultNulls(hpe100Dto.getDEPT_CD(), sessionUser.getDeptCd()));
    	   	
    	   	//추가_20200925
    	   	/*hpe100Dto.setTX_OFFC_CD(param.get("TX_OFFC_CD"));*/
    	   	/*hpe100Dto.setTX_OFFC_CD(MSFSharedUtils.allowNulls(param.get("TX_OFFC_CD").toString()));*/
    	   	
    	   	
    	   	
    	   	state = File_Create(request, hpe100Dto, response);
    	   	
    	   	sResult = "success";
                      
        } catch(Exception ex) {
        	ex.printStackTrace(); 
        	sResult = "error";
        } 
   
        response.sendRedirect(sResult);
        return sResult;
 
    }
	
	public int File_Create(HttpServletRequest request, Hpe100DTO hpe100Dto,HttpServletResponse response) throws Exception {

		if  (MSFSharedUtils.paramNull(hpe100DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( request.getSession().getServletContext());
			hpe100DAO = (Hpe100DAO) wac.getBean("Hpe100DAO" ); 
		}
		//추가_20200928
		/*List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		listMap.add(dataMap);*/
		
		//추가_20200928
		/*HashMap<String, String> param = new HashMap<String, String>();*/
		
		int state = 0;
		String companyNum = MSFSharedUtils.defaultNulls(hpe100Dto.getBUSOPR_RGSTN_NUM(), "");
		
		//추가_20200928
		/*dataMap.put("TX_OFFC_CD", hpe100Dto.getTX_OFFC_CD());
		dataMap.put("SUBMIT_DATE", hpe100Dto.getSUBMIT_DATE());
		dataMap.put("TAX_AGENT_NO", hpe100Dto.getTAX_AGENT_NO());
		dataMap.put("HOMETAX_ID", hpe100Dto.getHOMETAX_ID());
		dataMap.put("TAX_PGM_CODE", hpe100Dto.getTAX_PGM_CODE());
		dataMap.put("BUSOPR_RGSTN_NUM", hpe100Dto.getBUSOPR_RGSTN_NUM());
		dataMap.put("DPOB_NM", hpe100Dto.getDPOB_NM());
		dataMap.put("DEPT_NM", hpe100Dto.getDEPT_NM());
		dataMap.put("DEGTR_NM", hpe100Dto.getDEGTR_NM());
		dataMap.put("USR_TEL", hpe100Dto.getUSR_TEL());*/
		
		//추가_20200928_standalone로그
		/*logger.debug("TX_OFFC_CD : " + dataMap.get("TX_OFFC_CD"));
		logger.debug("SUBMIT_DATE : " + dataMap.get("SUBMIT_DATE"));
		logger.debug("SUBMITTER : " + dataMap.get("SUBMITTER"));
		logger.debug("TAX_AGENT_NO : " + dataMap.get("TAX_AGENT_NO"));
		logger.debug("HOMETAX_ID : " + dataMap.get("HOMETAX_ID"));
		logger.debug("TAX_PGM_CODE : " + dataMap.get("TAX_PGM_CODE"));
		logger.debug("BUSOPR_RGSTN_NUM : " + dataMap.get("BUSOPR_RGSTN_NUM"));
		logger.debug("DPOB_NM : " + dataMap.get("DPOB_NM"));
		logger.debug("DEPT_NM : " + dataMap.get("DEPT_NM"));
		logger.debug("DEGTR_NM : " + dataMap.get("DEGTR_NM"));
		logger.debug("USR_TEL : " + dataMap.get("USR_TEL"));*/
		
		
		try {
			hpe100DAO.UpdateHPE000(hpe100Dto);
			
			ArrayList<String> TOT_Record = new ArrayList<String>();
	
			List<Map<String,Object>> listA = hpe100DAO.selectWorkPayListA(hpe100Dto);
			List<Map<String,Object>> listC = hpe100DAO.selectWorkPayListC(hpe100Dto);
			
			//추가_20200928_standalone 로그로 listA, listC확인
			for(int i = 0; i < listA.size(); i++){
				logger.debug(i + "번째 :" +listA.get(i).toString());
			}
			
			for(int i = 0; i < listC.size(); i++){
				logger.debug(i + "번째 :" +listC.get(i).toString());
			}
			/*Iterator<Map<String, Object>> iterator = listA.iterator();
			while(iterator.hasNext()){
				Map<String, Object> element = iterator.next();
				logger.debug("22 : " + element);
			}*/
			
	
			/********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	
			/********************************************************암호화 처리 를 위해 반드시 해야 함................................*/  
			
			//추가_20200928
			/*param.put("TX_OFFC_CD",hpe100Dto.getTX_OFFC_CD());*/
			
			
			
			if(listA != null && listA.size() > 0)	{
				Map<String, Object> map = listA.get(0);
				Map<String, Object> mapA = listA.get(0);
				Map<String, Object> mapB = listA.get(0);
				String data = "";
				
				companyNum = MSFSharedUtils.defaultNulls(map.get("busoprRgstnNum"), "");
				
				data = "A77"
					 + this.csformat(mapA.get("txOffcCd"), 3) //관할세무서
					 + this.csformat(mapA.get("submitDate"), 8) //작업날짜
					 + this.csformat(mapA.get("submitter"), 1) //제출자구분
					 + this.csformat("", 6) //세무대리인관리번호 , 제출자가 세무대리인이 아니기때문에 공란
					 + this.csformat(mapA.get("hometaxId"), 20) //홈텍스아이디
					 + this.csformat(mapA.get("taxPgmCode"), 4) //세무프로그램코드, 4로 크기수정함
					 + this.csformat(mapA.get("busoprRgstnNum"), 10) //사업자등록번호
					 + this.csformat(mapA.get("dpobNm"), 30) //법인명
					 + this.csformat(mapA.get("deptNm"), 30) //담당자부서
					 + this.csformat(mapA.get("usrNm"), 30) //대표자성명이 아닌 담당자성명으로 수정함
					 /*+ this.csformat(mapA.get("degtrNm"), 30)*/
					 + this.csformat(mapA.get("usrTel"), 15) //담당자전화번호
					 + this.cnformat("1", 5) //B레코드수
					 + this.csformat("", 115); //공란
				//data += "\n";
				
				TOT_Record.add(data);
	
				data = "B77"
					 + this.csformat(mapB.get("txOffcCd"), 3) //관할세무서
					 + this.cnformat(1, 6) //일련번호 , B레코드는 한개라서 1 고정
					 + this.csformat(mapB.get("dpobNm"), 40) //법인명
					 + this.csformat(mapB.get("degtrNm"), 30) //대표자이름
					 + this.csformat(mapB.get("busoprRgstnNum"), 10) //사업자등록번호
					 + this.csformat(mapB.get("resnRegnNum"), 13) //주민등록번호
					 + this.csformat(mapB.get("yearYyyy"), 4) //귀속년도
					 + this.csformat(mapB.get("halfYear"), 1) //근무시기
					 + this.cnformat(listC.size(), 10) //C레코드 수
					 + this.cnformat(mapB.get("txtnTotAmnt"), 13) //과세소득
					 + this.cnformat(0, 13) //인정상여
					 //+ this.cnformat(mapB.get("freeDtyTotAmt"), 13) //비과세소득, 2021년 상반기는 인정상여로 변경됨 - > 인정상여는 지자체에서 사용안함, 0원처리
					 + this.csformat("", 134); //공란
				//data += "\n";
	
				TOT_Record.add(data);
				
				int cI = 1;
				for(Map<String,Object> mapC : listC) {
					String rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.defaultNulls(mapC.get("resnRegnNum"),"").replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					
					
					data = "C77"
						 + this.csformat(mapC.get("txOffcCd"), 3)
						 + this.cnformat(cI, 7)
						 + this.csformat(mapC.get("busoprRgstnNum"), 10)
						 + this.csformat(rrnDecCrypt, 13)
						 + this.csformat(mapC.get("hanNm"), 30)
						 + this.csformat("", 20) //전화번호는 공란으로 변경됨
						 + this.csformat(mapC.get("frgnrDivCd"), 1) //null일경우 1 로 처리하기
						 + this.csformat(mapC.get("residentCd"), 1)
						 + this.csformat(mapC.get("natnCd"), 2)
						 + this.csformat(mapC.get("emymtBgnnDt"), 8)
						 + this.csformat(mapC.get("emymtEndDt"), 8)
						 //+ this.cnformat(mapC.get("txtnTotAmnt"), 13) // 2021년 하반기 양식변경 수정처리
						 + this.cnformat(mapC.get("txtnTotAmntA"), 13) // 2021년 하반기 양식변경 수정처리
						 + this.cnformat(mapC.get(0), 13)
						 + this.cnformat(mapC.get("txtnTotAmntB"), 13) // 2021년 하반기 양식변경 수정처리
						 + this.cnformat(mapC.get(0), 13)
						 + this.cnformat(mapC.get("txtnTotAmntC"), 13) // 2021년 하반기 양식변경 수정처리
						 + this.cnformat(mapC.get(0), 13)
						 + this.cnformat(mapC.get("txtnTotAmntD"), 13) // 2021년 하반기 양식변경 수정처리
						 + this.cnformat(mapC.get(0), 13)
						 + this.cnformat(mapC.get("txtnTotAmntE"), 13) // 2021년 하반기 양식변경 수정처리
						 + this.cnformat(mapC.get(0), 13)
						 + this.cnformat(mapC.get("txtnTotAmntF"), 13) // 2021년 하반기 양식변경 수정처리
						 + this.cnformat(mapC.get(0), 13)
						 //+ this.cnformat(mapC.get("freeDtyTotAmt"), 13) //비과세소득, 2021년 상반기는 인정상여로 변경됨 - > 인정상여는 지자체에서 사용안함, 0원처리
						 + this.csformat("", 18);
					//data += "\n";
					
					TOT_Record.add(data);
					cI++;
				}
			}
	
			String term = hpe100Dto.getYEAR_YYYY() + "0" + hpe100Dto.getHALF_YEAR() + "/";
			String fileLocation = "C:/EOSDATA/" + term + "SC" + StringUtils.left(companyNum,7) + "." + StringUtils.right(companyNum,3);
			
			File dir = new File("C:/EOSDATA/" + term);
			File objFile = new File(fileLocation);
			
			//디렉토리가 없으면 생성
			if(!dir.isDirectory()){
				dir.mkdirs();
			}
			
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(fileLocation),"EUC-KR");
			BufferedWriter bw = new BufferedWriter(osw);
	
			for (int iCnt=0;iCnt < TOT_Record.size();iCnt++) {
				String strWr = "";
				
				strWr = TOT_Record.get(iCnt);
				bw.write(strWr);
				
				if ((TOT_Record.size() - 1) != iCnt) {
					bw.newLine(); // 줄바꿈
				}
			}
			bw.close();
	
			// 파일 다운로드
			String strFileName = URLEncoder.encode(new String(objFile.getName().getBytes("8859_1"), "euc-kr"), "euc-kr");
			
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment;filename=" + strFileName + ";");
	
			int nRead = 0;
			byte btReadByte[] = new byte[(int)objFile.length()];
			if(objFile.length() > 0 && objFile.isFile())
			{
				BufferedInputStream objBIS = new BufferedInputStream(new FileInputStream(objFile));
				BufferedOutputStream objBOS = new BufferedOutputStream(response.getOutputStream());
				
				while((nRead = objBIS.read(btReadByte)) != -1)
					objBOS.write(btReadByte, 0, nRead);
				
				objBOS.flush();
				objBOS.close();
				objBIS.close();
			}
		} catch (Exception ex) { 
			ex.printStackTrace();
			state = -1;
		}
		return state;
	}

	private String csformat(Object obj, int leng)throws Exception 	{
		String str = MSFSharedUtils.defaultNulls(obj, "");
		return this.strPad(str, leng, " ", false);
	}
	
	private String cnformat(Object obj, int leng)throws Exception {
		String str = MSFSharedUtils.defaultNulls(obj, "0");
		if(str.indexOf(".") >=0)
			str = str.substring(0, str.indexOf("."));
		
		return this.strPad(str, leng, "0", true);
	}
	
	private String strPad( String str, int size, String padStr, boolean where ) throws Exception {
		if (str == null) str = "";
		
		if (!where && str.getBytes("MS949").length > size && str.getBytes("MS949").length != str.length()) {
			byte[] bytes = str.getBytes("MS949");
			String strbyte=null, strChar=null;
			int j=0, k=0;
			
			for(int i=0; (i < str.length() && j < size) ; i++) {
				byte[] tmpbyte = new byte[1];
				k=j;	// 마지막 index 저장
				tmpbyte[0] = bytes[j];
				strbyte = new String(tmpbyte);
				strChar = str.substring(i, i+1);
				
				if(strChar.equals(strbyte))	{
					//한글이 아님
					j++;
				}
				else {
					//한글
					j = j+2;
				}
			}
			
			int subLen = size;
			// 마지막 byte 가 깨진 글자인지 검사
			if(j-k == 2 && k == size-1)	{
				subLen = subLen-1;
			}
			byte[] bytesSize = new byte[subLen];
			System.arraycopy(bytes, 0, bytesSize, 0, subLen);
			str = new String(bytesSize);
		}
		else if (!where && str.getBytes("MS949").length == size ) {
			return str;
		}
		else if (!where && str.getBytes("MS949").length > size  && str.getBytes("MS949").length == str.length() ) {
			return str.substring(0,size);
		}
		
		if (where && str.length() >= size) {
			return str;
		}
		String res = null;
		StringBuffer sb = new StringBuffer();
		String tmpStr = null;
		int tmpSize = size - str.getBytes("MS949").length;

		for (int i = 0; i < size; i = i + padStr.length()) {
			sb.append(padStr);
		}
		tmpStr = sb.toString().substring(0, tmpSize);

		if(where)
			res = tmpStr.concat(str);
		else
			res = str.concat(tmpStr);
		
		return res;
	}

	private int convertInt(Object obj)	{
		String str = MSFSharedUtils.defaultNulls(obj, "0");
		if(str.indexOf(".") >=0)
			str= str.substring(0, str.indexOf("."));
		
		return Integer.parseInt(str);
	}

	private List<Map<String, Object>> filterList(List<Map<String,Object>> list, String name, Object value)	{
		List<Map<String,Object>> rList = new ArrayList<Map<String,Object>>();
		for(Map<String, Object> map : list){
			if(map.get(name).equals(value))	{
				rList.add(map);
			}
		}
		return rList;
	}
}
