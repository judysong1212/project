package  com.app.smrmf.pkg.proc.dlgn.manage.commute;

import java.util.List;

import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0100SrhVO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0100VO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0200SrhVO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0200VO;

/**
 * 
 * @Class Name : ManageCommuteService.java
 * @Description : ManageCommute Business class
 *                근태을 합산하여 저장하는 인터페이스 함수 
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface ManageCommuteService {
	

  /**
  * DLGN0100 목록을 조회한다.
  * @param searchVO - 조회할 정보가 담긴 VO
  * @return DLGN0100 목록
  * @exception Exception
  */
 List selectInfcDlgn0110TotList(InfcPkgDlgn0100SrhVO searchVO) throws Exception;
 
    
/**
* DLGN0100을 수정한다.
* @param vo - 수정할 정보가 담긴 InfcDlgn0100VO
* @return void형
* @exception Exception
*/
void updateManageCommuteInfcDlgn0100(InfcPkgDlgn0100VO vo) throws Exception;

 
/**
 * DLGN0200 목록을 조회한다.
 * @param searchVO - 조회할 정보가 담긴 VO
 * @return DLGN0200 목록
 * @exception Exception
 */
List selectInfcDlgn0210TotList(InfcPkgDlgn0200SrhVO searchVO) throws Exception;

   
/**
* DLGN0200을 수정한다.
* @param vo - 수정할 정보가 담긴 InfcDlgn0200VO
* @return void형
* @exception Exception
*/
void updateManageCommuteInfcDlgn0200(InfcPkgDlgn0200VO vo) throws Exception;

/**
 * DLGN0100 목록을 조회한다.
 * @param searchVO - 조회할 정보가 담긴 VO
 * @return DLGN0100 목록
 * @exception Exception
 */
List selectInfcDlgn0110HHMiTotList(InfcPkgDlgn0100SrhVO searchVO) throws Exception;

/**
 * DLGN0200 목록을 조회한다.
 * @param searchVO - 조회할 정보가 담긴 VO
 * @return DLGN0200 목록
 * @exception Exception
 */
List selectInfcDlgn0210HHMiTotList(InfcPkgDlgn0200SrhVO searchVO) throws Exception;

  
    
//    /**
//     * DLGN0100을 등록한다.
//     * @param vo - 등록할 정보가 담긴 InfcDlgn0100VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    String insertInfcDlgn0100(InfcDlgn0100VO vo) throws Exception;
//    
//    /**
//     * DLGN0100을 수정한다.
//     * @param vo - 수정할 정보가 담긴 InfcDlgn0100VO
//     * @return void형
//     * @exception Exception
//     */
//    void updateInfcDlgn0100(InfcDlgn0100VO vo) throws Exception;
//    
//    /**
//     * DLGN0100을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 InfcDlgn0100VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deleteInfcDlgn0100(InfcDlgn0100VO vo) throws Exception;
//    
//    /**
//     * DLGN0100을 조회한다.
//     * @param vo - 조회할 정보가 담긴 InfcDlgn0100VO
//     * @return 조회한 DLGN0100
//     * @exception Exception
//     */
//    InfcDlgn0100VO selectInfcDlgn0100(InfcDlgn0100VO vo) throws Exception;
//    
//    /**
//     * DLGN0100 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return DLGN0100 목록
//     * @exception Exception
//     */
//    List selectInfcDlgn0100List(InfcDlgn0100SrhVO searchVO) throws Exception;
//    
//    /**
//     * DLGN0100 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return DLGN0100 총 갯수
//     * @exception
//     */
//    int selectInfcDlgn0100ListTotCnt(InfcDlgn0100SrhVO searchVO);
//    
//
//    /**
//     * DLGN0200을 등록한다.
//     * @param vo - 등록할 정보가 담긴 InfcDlgn0200VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    String insertInfcDlgn0200(InfcDlgn0200VO vo) throws Exception;
//    
//    /**
//     * DLGN0200을 수정한다.
//     * @param vo - 수정할 정보가 담긴 InfcDlgn0200VO
//     * @return void형
//     * @exception Exception
//     */
//    void updateInfcDlgn0200(InfcDlgn0200VO vo) throws Exception;
//    
//    /**
//     * DLGN0200을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 InfcDlgn0200VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deleteInfcDlgn0200(InfcDlgn0200VO vo) throws Exception;
//    
//    /**
//     * DLGN0200을 조회한다.
//     * @param vo - 조회할 정보가 담긴 InfcDlgn0200VO
//     * @return 조회한 DLGN0200
//     * @exception Exception
//     */
//    InfcDlgn0200VO selectInfcDlgn0200(InfcDlgn0200VO vo) throws Exception;
//    
//    /**
//     * DLGN0200 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return DLGN0200 목록
//     * @exception Exception
//     */
//    List selectInfcDlgn0200List(InfcDlgn0200SrhVO searchVO) throws Exception;
//    
//    /**
//     * DLGN0200 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return DLGN0200 총 갯수
//     * @exception
//     */
//    int selectInfcDlgn0200ListTotCnt(InfcDlgn0200SrhVO searchVO);
    
}
