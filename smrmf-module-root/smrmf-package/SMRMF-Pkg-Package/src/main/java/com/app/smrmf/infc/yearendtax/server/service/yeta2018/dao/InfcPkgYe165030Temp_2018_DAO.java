package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161030_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe165030TempSrh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe165030Temp_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye165030Temp_2018_DAO.java
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

@Repository("InfcPkgYe165030Temp_2018_DAO")
public class InfcPkgYe165030Temp_2018_DAO extends EgovAbstractDAO {

	
	@Transactional
    public String fnYeta3100_YE165030_TEMP_2018_CREATE_Insert(InfcPkgYe165030Temp_2018_VO infcPkgYe165030TempVo) throws Exception {
        return (String)insert("infcPkgYe165030Temp_2018_DAO.fnYeta3100_YE165030_TEMP_2018_CREATE_Insert_S", infcPkgYe165030TempVo);
    }
	
	
	
	/**
	 * YE165030_TEMP?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye165030TempVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe165030Temp(InfcPkgYe165030Temp_2018_VO vo) throws Exception {
        return (String)insert("infcPkgYe165030Temp_2018_DAO.insertYe165030Temp_S", vo);
    }

    /**
	 * YE165030_TEMP?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165030TempVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe165030Temp(InfcPkgYe165030Temp_2018_VO vo) throws Exception {
        update("infcPkgYe165030Temp_2018_DAO.updateYe165030Temp_S", vo);
    }

    /**
	 * YE165030_TEMP?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165030TempVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe165030Temp(InfcPkgYe165030Temp_2018_VO vo) throws Exception {
        delete("infcPkgYe165030Temp_2018_DAO.deleteYe165030Temp_S", vo);
    }

    /**
	 * YE165030_TEMP?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye165030TempVO
	 * @return 조회?�� YE165030_TEMP
	 * @exception Exception
	 */
    public InfcPkgYe165030Temp_2018_VO selectYe165030Temp(InfcPkgYe165030Temp_2018_VO vo) throws Exception {
        return (InfcPkgYe165030Temp_2018_VO) selectByPk("infcPkgYe165030Temp_2018_DAO.selectYe165030Temp_S", vo);
    }

    /**
	 * YE165030_TEMP 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165030_TEMP 목록
	 * @exception Exception
	 */
    public List<?> selectYe165030TempList(InfcPkgYe165030TempSrh_2018_VO searchVO) throws Exception {
        return list("infcPkgYe165030Temp_2018_DAO.selectYe165030TempList_D", searchVO);
    }

    /**
	 * YE165030_TEMP �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165030_TEMP �? �??��
	 * @exception
	 */
    public int selectYe165030TempListTotCnt(InfcPkgYe165030TempSrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe165030Temp_2018_DAO.selectYe165030TempListTotCnt_S", searchVO);
    }

}
