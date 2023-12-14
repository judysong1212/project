package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165030TempSrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165030TempVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye165030TempDAO.java
 * @Description : Ye165030Temp DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe165030TempDAO")
public class InfcPkgYe165030TempDAO extends EgovAbstractDAO {

	
	@Transactional
    public String fnYeta2100_YE165030_TEMP_2017_CREATE_Insert(InfcPkgYe165030TempVO infcPkgYe165030TempVo) throws Exception {
        return (String)insert("infcPkgYe165030TempDAO.fnYeta2100_YE165030_TEMP_2017_CREATE_Insert_S", infcPkgYe165030TempVo);
    }
	
	
	
	/**
	 * YE165030_TEMP?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye165030TempVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe165030Temp(InfcPkgYe165030TempVO vo) throws Exception {
        return (String)insert("infcPkgYe165030TempDAO.insertYe165030Temp_S", vo);
    }

    /**
	 * YE165030_TEMP?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165030TempVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe165030Temp(InfcPkgYe165030TempVO vo) throws Exception {
        update("infcPkgYe165030TempDAO.updateYe165030Temp_S", vo);
    }

    /**
	 * YE165030_TEMP?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165030TempVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe165030Temp(InfcPkgYe165030TempVO vo) throws Exception {
        delete("infcPkgYe165030TempDAO.deleteYe165030Temp_S", vo);
    }

    /**
	 * YE165030_TEMP?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye165030TempVO
	 * @return 조회?�� YE165030_TEMP
	 * @exception Exception
	 */
    public InfcPkgYe165030TempVO selectYe165030Temp(InfcPkgYe165030TempVO vo) throws Exception {
        return (InfcPkgYe165030TempVO) selectByPk("infcPkgYe165030TempDAO.selectYe165030Temp_S", vo);
    }

    /**
	 * YE165030_TEMP 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165030_TEMP 목록
	 * @exception Exception
	 */
    public List<?> selectYe165030TempList(InfcPkgYe165030TempSrhVO searchVO) throws Exception {
        return list("infcPkgYe165030TempDAO.selectYe165030TempList_D", searchVO);
    }

    /**
	 * YE165030_TEMP �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165030_TEMP �? �??��
	 * @exception
	 */
    public int selectYe165030TempListTotCnt(InfcPkgYe165030TempSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe165030TempDAO.selectYe165030TempListTotCnt_S", searchVO);
    }

}
