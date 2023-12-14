package com.app.smrmf.infc.diligence.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0100VO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0250SrhVO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0250VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


@Repository("InfcPkgDlgn0100DAO")
public class InfcPkgDlgn0100DAO extends EgovAbstractDAO implements IsSerializable {
	 
	
	/**
	 * 마감처리및 풀기
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Transactional
   public int updateDlgn0100PayDdlene(InfcPkgDlgn0100VO vo) throws Exception{
        return update("infcPkgDlgn0100DAO.updateDlgn0100PayDdlene_S", vo);
    }
	
   
 /**
  * 근무실적 관리 데이터  
  * @param dlgn0250SrhVo
  * @return
  * @throws Exception
  */
 public List<InfcPkgDlgn0250VO> selectXlsDlgn0250List(InfcPkgDlgn0250SrhVO infcDlgn0250SrhVo) throws Exception {
     return (List<InfcPkgDlgn0250VO>)list("infcPkgDlgn0100DAO.selectXlsDlgn0250List_D", infcDlgn0250SrhVo); 
 }
 
 
   /**
    * 근무실적 관리 데이터 
    * @param dlgn0250SrhVo
    * @return
    * @throws Exception
    */
   public List selectDlgn0250List(InfcPkgDlgn0250SrhVO infcDlgn0250SrhVo) throws Exception {
       return  list("infcPkgDlgn0100DAO.selectDlgn0250List_D", infcDlgn0250SrhVo); 
   }
   
   /**
    * DLGN0100 총 갯수를 조회한다.
    * @param searchMap - 조회할 정보가 담긴 Map
    * @return DLGN0100 총 갯수
    * @exception
    */
   public int selectDlgn0250ListTotCnt(InfcPkgDlgn0250SrhVO searchVO) {
       return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgDlgn0100DAO.selectDlgn0250ListTotCnt_S", searchVO);
   }
   
   /**
    * DLGN0100을 등록한다.
    * @param vo - 등록할 정보가 담긴 Dlgn0100VO
    * @return 등록 결과
    * @exception Exception
    */
   @Transactional
   public String insertDlgn0100(InfcPkgDlgn0100VO vo) throws Exception {
       return (String)insert("infcPkgDlgn0100DAO.insertDlgn0100_S", vo);
   }

   /**
    * DLGN0100을 수정한다.
    * @param vo - 수정할 정보가 담긴 Dlgn0100VO
    * @return void형
    * @exception Exception
    */
   @Transactional
   public void updateDlgn0100(InfcPkgDlgn0100VO vo) throws Exception {
       update("infcPkgDlgn0100DAO.updateDlgn0100_S", vo);
   }

   /**
    * DLGN0100을 삭제한다.
    * @param vo - 삭제할 정보가 담긴 Dlgn0100VO
    * @return void형 
    * @exception Exception
    */
   @Transactional
   public void deleteDlgn0100(InfcPkgDlgn0100VO vo) throws Exception {
       delete("infcPkgDlgn0100DAO.deleteDlgn0100_S", vo);
   }

   /**
    * DLGN0100을 조회한다.
    * @param vo - 조회할 정보가 담긴 Dlgn0100VO
    * @return 조회한 DLGN0100
    * @exception Exception
    */
   public InfcPkgDlgn0100VO selectDlgn0100(InfcPkgDlgn0100VO vo) throws Exception {
       return (InfcPkgDlgn0100VO) selectByPk("infcPkgDlgn0100DAO.selectDlgn0100_S", vo);
   }
   
   /**
    * DLGN0100을 조회한다.
    * @param vo - 조회할 정보가 담긴 Dlgn0100VO
    * @return 조회한 DLGN0100
    * @exception Exception
    */
   public InfcPkgDlgn0250VO selectDlgn0250Data(InfcPkgDlgn0250VO searchVO) throws Exception {
       return (InfcPkgDlgn0250VO) selectByPk("infcPkgDlgn0100DAO.selectDlgn0250Data_S", searchVO);
   }
   
   
	
	
}
