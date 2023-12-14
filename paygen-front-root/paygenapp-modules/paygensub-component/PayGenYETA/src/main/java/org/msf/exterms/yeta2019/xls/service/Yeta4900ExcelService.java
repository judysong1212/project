package org.msf.exterms.yeta2019.xls.service;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.yearendtax.server.vo.Pyyt0302Exl_2019_VO;
import com.app.exterms.yearendtax.server.vo.Pyyt0302_2019_VO;
import com.app.exterms.yearendtax.server.vo.Pyyt0304Srh_2019_VO;
import com.app.exterms.yearendtax.server.vo.Pyyt0304_2019_VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0485SrhVO;

import egovframework.rte.psl.dataaccess.util.EgovMap;


public interface Yeta4900ExcelService {
	
	/**
	 * 급여 다운로드 (양식)
	 */
	List selectXlsPayr0485List(InfcPkgPayr0485SrhVO Payr0485SrhVo) throws Exception;
    /**
     *  급여업로드_엑셀파일을 등록한다. (JXLS)
     */

	List<Pyyt0302_2019_VO> updateXlsYeta490001(Collection<Pyyt0302_2019_VO> yeta4900List, HttpServletRequest request) throws MSFException;

    /**
     *  급여업로드_엑셀파일을 등록한다. (JXLS)
     */

	List<Pyyt0302_2019_VO> updateXlsYeta490002(List<Pyyt0302Exl_2019_VO> yeta4900List, HttpServletRequest request) throws MSFException;
	
    /**
     * 급여대장(공무직)
     * @param psnl0290SrhVo
     * @return
     * @throws Exception
     */
    List<Pyyt0304_2019_VO> selectXlsPyyt0304List01(Pyyt0304Srh_2019_VO   pyyt0304SrhVo ) throws Exception;
	
    /**
     *   급여대장(기간제)
     * @param payr0250SrhVo
     * @return
     * @throws Exception
     */
//    EgovMap selectXlsPyyt0304List1(Pyyt0304SrhVO pyyt0304SrhVo) throws Exception;
    
    List<EgovMap> selectXlsPyyt0304List2(Pyyt0304Srh_2019_VO pyyt0304SrhVo) throws Exception;
    

	
    
}
