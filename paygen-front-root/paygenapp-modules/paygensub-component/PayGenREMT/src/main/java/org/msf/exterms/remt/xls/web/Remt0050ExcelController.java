package org.msf.exterms.remt.xls.web;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.msf.exterms.remt.xls.service.Remt0050ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import com.app.exterms.prgm.server.utils.PrgmComUtils;
import com.app.exterms.retirement.server.vo.Remt1000SrhVO;
import com.app.exterms.retirement.server.vo.Remt1000VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;

@Controller
public class Remt0050ExcelController {

    private static final Logger logger = LoggerFactory.getLogger(Remt0050ExcelController.class);
    private static final String calledClass = Remt0050ExcelController.class.getName();


    @Resource(name = "remt0050ExcelService")
    private Remt0050ExcelService remt0050ExcelService;

    /**
     * EgovPropertyService
     */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.
     *
     * @param param
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value = "/exp/XlsFileRemt0050Export.do")
    public ModelAndView xlsFileRemt0050Export(@RequestParam HashMap<String, String> param, HttpServletRequest request, ModelMap model)
            throws Exception {

        String method = calledClass + ".xlsFileRemt0050Export";

        String windowNm = "퇴직가산율관리";
        String windowId = "REMT0050";

        Remt1000SrhVO remt1000SrhVo = new Remt1000SrhVO();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();
        Map<String, Object> map = new HashMap<String, Object>();

        try {

            remt1000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
            remt1000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부
            remt1000SrhVo.setUsrId(sessionUser.getUsrId());
            remt1000SrhVo.setClutYrMnth01(MSFSharedUtils.allowNulls(param.get("clutYrMnth01"))); //지급년월
            remt1000SrhVo.setClutYrMnth02(MSFSharedUtils.allowNulls(param.get("clutYrMnth02"))); //지급년월
            remt1000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd")));   //단위기관코드


            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
                remt1000SrhVo.setDeptCd(sessionUser.getDeptCd());
                listDeptCd.add(sessionUser.getDeptCd());
                remt1000SrhVo.setDeptCdArr(listDeptCd);     //부서코드
                remt1000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
            } else {

                remt1000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd")));   //단위기관코드
                if (remt1000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
                    listDeptCd = null;
                    remt1000SrhVo.setDeptCdArr(listDeptCd);     //부서코드
                    remt1000SrhVo.setDeptCd("");  //부서코드
                } else {
                    remt1000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
                    listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));
                    remt1000SrhVo.setDeptCdArr(listDeptCd);     //부서코드
                }

            }

            remt1000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(param.get("deptCd")).replace(",", ""));  //권한처리를위해 추가
            remt1000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")).replace(",", ""));

            /******************************** 권한 ************************************************************************/

            /** 로그반영
             * CRUDSBLO
             * C:create		R:read		U:update
             * D:delete		S:select	B:배치
             * L:로그인		O:로그아웃
             */
            MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");

        } catch (Exception e) {
            e.printStackTrace();

            /** 에러 로그 **/
            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, "S", e, windowNm, windowId);

        }

        return new ModelAndView("remt0050ExcelView", map);

    }


    /**
     * 엑셀파일을 업로드한다.
     *
     * @param file
     * @return sResult
     * @throws InvalidFormatException, IOException, SAXException
     */
    @RequestMapping(value = "/imp/XlsReadRemt0050Import.do", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("remt0050flUp") MultipartFile file
            , Model model
            , final HttpServletRequest request, final HttpServletResponse response
    ) throws InvalidFormatException, IOException, SAXException {
        String realPath = request.getSession().getServletContext().getRealPath("");
        String xmlConfig = "/upXmlConfig/REMT/Remt0050Mapping.xml";

        String windowNm = "퇴직가산율입력";
        String windowId = "REMT0050";

        String method = calledClass + ".handleFormUpload";
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);

        String sResult = "";            //결과 상태값
        InputStream inputXML = null;    //XML
        InputStream inputXLS = null;    //엑셀파일

        List<Remt1000VO> remt1000List = new ArrayList<Remt1000VO>();
        Map<String, List> beans = new HashMap<String, List>();

        beans.put("remt1000List", remt1000List);


        try {

            inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
            XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
            inputXLS = new BufferedInputStream(file.getInputStream());
//			System.out.println("xml경로 " + realPath.concat("/WEB-INF" + xmlConfig));

            XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);

            if(xlsReadStatus.isStatusOK()) {
                //엑셀 업로드 서비스 호출
                long result ;

                if( remt1000List == null || remt1000List.size() <= 0 ){
                    PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
                }else{
                    //엑셀 업로드 서비스 호출(delete 후에 insert함)
                    long excelCount = remt1000List.size();

                    result = remt0050ExcelService.insertXlsRemt0050(remt1000List, request);

                    if(result==0L){
                        //엑셀 업로드 서비스 호출(delete 후에 insert함)
                        sResult = "error";

                        PrgmComUtils.responseAlert(response, "올바른 엑셀 양식인지 또는 엑셀 업로드 대상자가 시스템 등록된 인원인지 확인해주세요." );

                    }else if(result > 0L){
                        sResult = "success";

                        if(result == excelCount){
                            PrgmComUtils.responseAlert(response, "업로드가 완료되었습니다." );
                        }else{
                            PrgmComUtils.responseAlert(response, "엑셀업로드 "+ excelCount+"중에  총"+ result +"건 입력되었습니다. 엑셀데이타를 확인해주세요." );
                        }
                    }
                }

            }else {
                sResult =  "error";
            }


        }catch(Exception e) {
            PrgmComUtils.responseAlert(response, "엑셀 업로드중 오류가 발생하였습니다. 확인후 다시 업로드해주세요." );
            e.printStackTrace();

            /** 에러 로그 **/
            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C:U:D",e, windowNm , windowId);

        }finally {
            IOUtils.closeQuietly(inputXML);
            IOUtils.closeQuietly(inputXLS);
        }

        return sResult;
    }

}
