package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Payr4600ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.payroll.server.vo.Payr0650SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Payr4600ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Payr4600ExcelController.class);
    private static final String calledClass = Payr4600ExcelController.class.getName();


    @Resource(name = "payr4600ExcelService")
    private Payr4600ExcelService payr4600ExcelService;

    /**
     * 엑셀파일로 출력한다.(일용근로소득지급내역)
     *
     * @param param 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value = "/exp/XlsPayr4600Export.do")
    public ModelAndView xlsPayr4500Export(@RequestParam HashMap<String, String> param, HttpServletRequest request)
            throws Exception {

        String method = calledClass + ".xlsPayr4600Export";

        String windowNm = "일용근로소득지급내역";
        String windowId = "PAYR4600";

        Payr0650SrhVO payr0650SrhVO = new Payr0650SrhVO();

        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        Map<String, Object> map = new HashMap();

        // 1. 암호화 객체 생성
        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest());

        try {

            /* 조건절 */
            payr0650SrhVO.setDilWrkrIncmBlggYr(MSFSharedUtils.allowNulls(param.get("dilWrkrIncmBlggYr")));
            payr0650SrhVO.setDilWrkrIncmBlggQatrDivCdArr(SmrmfUtils.getStrToArrayList(param.get("srhDilWrkrIncmBlggQatrDivCdArr")));
            payr0650SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
            payr0650SrhVO.setBusinCd(MSFSharedUtils.allowNulls(param.get("businCd")));
            payr0650SrhVO.setSystemkeyArr(SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("systemkeyArr"))));

            List listPayr4500 = payr4600ExcelService.selectXlsPayr0650List(payr0650SrhVO);

            String strValue = "";
            List<EgovMap> excelList = new ArrayList();

            for (int i = 0; i < listPayr4500.size(); i++) {
                EgovMap eMap;
                eMap = (EgovMap) listPayr4500.get(i);

                strValue = AnyCryptUtils.getDecSyncCrypt(nResult, MSFSharedUtils.allowNulls(eMap.get("aimenrResnRegnNum")).replace("-", ""), AnyCryptUtils.SEC_RRNUMC);
                eMap.put("aimenrResnRegnNum", strValue);

                excelList.add(eMap);
            }

            map = new HashMap<String, Object>();
            map.put("listPayr0650", excelList);

            /* 로그반영
             * CRUDSBLO
             * C:create		R:read		U:update
             * D:delete		S:select	B:배치
             * L:로그인		O:로그아웃
             */
            MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");

        } catch (Exception e) {
            e.printStackTrace();

            /* 에러 로그 */
            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, "S", e, windowNm, windowId);

        }

        return new ModelAndView("payr4600ExcelView", map);

    }

}
