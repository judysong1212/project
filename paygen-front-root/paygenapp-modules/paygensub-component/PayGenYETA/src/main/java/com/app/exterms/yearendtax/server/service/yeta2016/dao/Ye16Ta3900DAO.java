package com.app.exterms.yearendtax.server.service.yeta2016.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Yeta3900SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3900VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;



@Repository("Ye16Ta3900DAO")
public class Ye16Ta3900DAO extends EgovAbstractDAO  implements IsSerializable{

	// 급여업로드폼(양식)
    @SuppressWarnings("unchecked")
	public List<Yeta3900VO> selectXlsFileYeta3900List(Yeta3900SrhVO ye16Ta3900SrhVO) throws Exception {
        return (List<Yeta3900VO>)list("ye16Ta3900DAO.selectXlsFileYeta3900List_D", ye16Ta3900SrhVO); 
    }
    
	/**
	 * YETA3900 엑실파일 업로드(삭제)
	 * @param searchMap - 삭제할 정보가 담긴 Map
	 * @exception Exception
	 */
    @Transactional
    public int deleteXlsYeta3900(Yeta3900VO vo) throws Exception{
		return delete("ye16Ta3900DAO.deleteXlsYeta3900_S",vo);		
	}
    
	/**
	 * YETA3900 엑실파일 업로드(입력)
	 * @param searchMap - 입력할 정보가 담긴 Map
	 * @exception Exception
	 */
    @Transactional
    public String insertXlsYeta3900(Yeta3900VO vo) throws Exception{
		return (String)insert("ye16Ta3900DAO.insertXlsYeta3900_S",vo);		
	}	
}