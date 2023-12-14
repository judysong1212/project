package org.msf.exterms.remt.xls.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.msf.exterms.remt.xls.service.Remt0050ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.retirement.server.service.dao.Remt1000DAO;
import com.app.exterms.retirement.server.vo.Remt1000VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("remt0050ExcelService")
public class Remt0050ExcelServiceImpl extends AbstractServiceImpl implements Remt0050ExcelService {

    private static final Logger logger = LoggerFactory.getLogger(Remt0050ExcelServiceImpl.class);

    @Autowired
    @Resource(name = "Remt1000DAO")
    private Remt1000DAO remt1000DAO;

    @Override
    public Long insertXlsRemt0050(List<Remt1000VO> remt1000List,
                                  HttpServletRequest request) throws MSFException {
//        Remt1000VO remt1000vo;
//        List<Remt1000VO> remt1000FullList;   /* remt full list map */
//        Remt1000SrhVO remtVo = new Remt1000SrhVO();
//        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//        List<Remt1000VO> filteredRemt1000List;  /* filtered target insert */
//        List<Remt1000VO> errRemt1000List;   /* error */
//        Boolean diffRun = true;
//
//        try {
//        errRemt1000List = new ArrayList<Remt1000VO>();
//        filteredRemt1000List = new ArrayList<Remt1000VO>();
//
//        remt1000FullList = remt1000DAO.selectXlsRemt1000List(); /* 퇴직금가산율관리 where 사업장코드 조회 */

//        if(remt1000FullList.isEmpty()){
//            logger.info("REMT1000 table is empty!");
//            diffRun = false;    /* 테이블 데이터가 비었으므로, 검증하지 않는다. */
//        }

//        List<Remt1000VO> dtilOccuInttnCdList = remt1000DAO.selectDtilOccuInttnCdList(); /* 직종세통합코드 load - db 입출력 최소화하기 위한.. */
//        logger.setLevel(Level.ALL);
//            /* 데이터 검증 - 직종세통합코드로 검증 */
//        if(diffRun) { /* 테이블에 데이터가 있을시 */
//            for (Remt1000VO currentVO : remt1000List) {
//                for (Remt1000VO diffVO : remt1000FullList) {
//                    if (diffVO.getDtilOccuInttnCd().equals(currentVO.getDtilOccuInttnCd())) { /* 같은 데이터가 있다면 */
//                        logger.info("중복되는 데이터 존재 :: " + currentVO.toString());
//                        currentVO.setSevePayNoteCtnt("동일한 데이터가 존재합니다."); /* 비고에 에러케이스 set */
//                        errRemt1000List.add(currentVO);
//                        //errRemt1000List.add(currentVO); /* 같은 데이터가 존재하므로 error객체에 담기 */
//                        break;  /* 내부 forloop 탈출 */
//                    }
//                }
//                    /* 직종코드 검색 */
//                for(Remt1000VO map : dtilOccuInttnCdList){
//                    if(currentVO.getDtilOccuInttnCd().equals(map.getDtilOccuInttnCd())){
//                        logger.info("직종코드 set // " + currentVO.getDtilOccuInttnCd());
//                        currentVO.setTypOccuCd(map.getTypOccuCd());   /* 직종코드 set */
//                        break; /* 내부 forloop 탈출 */
//                    }
//                }
//                    /* 직종코드가 set 되어있을 시, insert 대상으로 취급 */
//                if(currentVO.getTypOccuCd().isEmpty()){
//                    logger.info("직종세통합코드가 존재하지않음 :: " + currentVO.toString());
//                    currentVO.setSevePayNoteCtnt("직종세통합코드가 존재하지않습니다. 확인해주세요"); /* 비고에 에러케이스 set */
//                    errRemt1000List.add(currentVO);
//                    //errRemt1000List.add(currentVO); /* 직종세통합코드가 존재하지 않으므로 error객체에 담기 */
//                }else {
//                    filteredRemt1000List.add(currentVO);    /* insert객체에 담기 */
//                }
//            }
//        }else{
//            for(Remt1000VO vo : remt1000List) {
//                filteredRemt1000List.add(vo);/* 테이블에 데이터가 없어 그대로 넘긴다 */
//            }
//        }

            /* 데이터 insert */
//        for(Remt1000VO map : filteredRemt1000List) {
//            map.setDpobCd(sessionUser.getDpobCd());
//            map.setKybdr(sessionUser.getUsrId());
//            map.setInptAddr(request.getRemoteHost());
//            map.setIsmt(sessionUser.getUsrId());
//            map.setRevnAddr(request.getRemoteHost());
//            remt1000DAO.insertRemt1000(map);
//        }

//        } catch (Exception ex) {
//            logger.error("EXCEPTION calling updateXlsRemt0050(): "+ex);
//            throw MSFServerUtils.getOperationException("updateXlsRemt0050", ex, logger);
//        }
//        finally {
//
//        }
//        return errRemt1000List;

        Long result = new Long(0);
        Long iCnt = new Long(0);
        Remt1000VO Remt1000VO = new Remt1000VO();

        List<Remt1000VO> errremt1000List = new ArrayList<Remt1000VO>();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);


        try {
            errremt1000List = new ArrayList<Remt1000VO>();

            for(int iPsnlCnt=0;iPsnlCnt < remt1000List.size();iPsnlCnt++) {

                System.out.println("listsize======================"+remt1000List.size());

                Remt1000VO = new Remt1000VO();
                Remt1000VO = remt1000List.get(iPsnlCnt);

                Remt1000VO.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd())); /** set 사업장코드 : dpobCd *///
                Remt1000VO.setInptAddr(Remt1000VO.getInptAddr());
                Remt1000VO.setIsmt(Remt1000VO.getIsmt());
                Remt1000VO.setRevnAddr(Remt1000VO.getRevnAddr());

                remt1000DAO.updateXlsRemt1000(Remt1000VO);
                remt1000DAO.insertXlsRemt1000(Remt1000VO);

                iCnt = iCnt + 1;
            }
            result = new Long(1);

        } catch (Exception ex) {

            logger.error("EXCEPTION calling updateXlsBass0320(): "+ex);

            result = new Long(0);
            throw MSFServerUtils.getOperationException("updateXlsBass0320", ex, logger);
        }
        finally {

        }

        return iCnt;
    }

    public EgovMap voAddtoMap(Remt1000VO currentVO){
        EgovMap returnMap = new EgovMap();
        returnMap.put("dtilOccuInttnCd", currentVO.getDtilOccuInttnCd());           //직종세통합코드
        returnMap.put("sevePayAddRateFrmCd", currentVO.getSevePayAddRateFrmCd());   //가산유형코드
        returnMap.put("sevePayAddOvr", currentVO.getSevePayAddOvr());               //가산이상
        returnMap.put("sevePayAddUdr", currentVO.getSevePayAddUdr());               //가산미만
        returnMap.put("sevePayAddSum", currentVO.getSevePayAddSum());               //가산금액
        returnMap.put("sevePayAddRate", currentVO.getSevePayAddRate());             //가산율
        returnMap.put("sevePayAddBgnnDt", currentVO.getSevePayAddBgnnDt());         //시작일자
        returnMap.put("sevePayAddEndDt", currentVO.getSevePayAddEndDt());           //종료일자
        returnMap.put("sevePayNoteCtnt", currentVO.getSevePayNoteCtnt());           // 비고
        return returnMap;
    }
}
