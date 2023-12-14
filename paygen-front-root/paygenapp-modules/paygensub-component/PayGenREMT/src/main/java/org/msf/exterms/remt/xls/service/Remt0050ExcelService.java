package org.msf.exterms.remt.xls.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.retirement.server.vo.Remt1000VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface Remt0050ExcelService {

    /**
     *  엑셀파일을 등록한다. (JXLS)
     * @param  remt1000List
     * @throws Exception
     */
    Long insertXlsRemt0050(List<Remt1000VO> remt1000List, HttpServletRequest request) throws MSFException;
}