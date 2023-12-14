package com.app.exterms.diligence.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.diligence.client.dto.Dlgn0200DTO;
import com.app.exterms.diligence.server.vo.Dlgn0200SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0200VO;
import com.app.exterms.diligence.server.vo.Dlgn0250SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0250VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


@Repository("dlgn0200DAO")
public class Dlgn0200DAO extends EgovAbstractDAO implements IsSerializable {
	
	@SuppressWarnings("rawtypes")
	public List selectDlgn0210(Dlgn0200DTO dto) throws Exception{
		return list("dlgn0200DAO.selectDlgn0210", dto);
	}
	
//	@SuppressWarnings("rawtypes")
//	public List selectDlgn0200(Dlgn0200DTO dto) throws Exception{
//		return list("dlgn0200DAO.selectDlgn0200", dto);
//	}
	
	@SuppressWarnings("rawtypes")
	public List selectDlgn0200(Dlgn0200SrhVO dlgn0200SrhVo) throws Exception{
		return list("dlgn0200DAO.selectDlgn0200", dlgn0200SrhVo);
	}
//	
//	@SuppressWarnings("rawtypes")
//	public List selectDlgn0200List(Dlgn0200SrhVO dlgn0200SrhVo) throws Exception{
//		return list("dlgn0200DAO.selectDlgn0200List", dlgn0200SrhVo);
//	}
	
	@SuppressWarnings("rawtypes")
	public List selectDlgn0200ToRtnData(Dlgn0200DTO dto) throws Exception{
		return list("dlgn0200DAO.selectDlgn0200ToRtnData", dto);
	}
	
	@Transactional
	public int deleteDlgn0200(Dlgn0200DTO dto) throws Exception{
		return delete("dlgn0200DAO.deleteDlgn0200", dto);
	}
	@Transactional
	public int deleteDlgn0210(Dlgn0200DTO dto) throws Exception{
		return delete("dlgn0200DAO.deleteDlgn0210", dto);
	}
	@Transactional
	public int deleteDlgn0200_S(Dlgn0200DTO dto) throws Exception{
		return delete("dlgn0200DAO.deleteDlgn0200_S", dto);
	}
	@Transactional
	public int deleteDlgn0210_S(Dlgn0200DTO dto) throws Exception{
		return delete("dlgn0200DAO.deleteDlgn0210_S", dto);
	}
	@Transactional
	public String insertDlgn0200(Dlgn0200DTO dto) throws Exception{
		return (String)insert("dlgn0200DAO.insertDlgn0200", dto);
	}
	
	@SuppressWarnings("rawtypes")
	public List afterSelectDlgn0200(Dlgn0200DTO dto) throws Exception{
		return list("dlgn0200DAO.afterSelectDlgn0200", dto);
	}
	
//	public List<Dlgn0200DTO> afterSelectDlgn0200(Dlgn0200DTO dto) throws Exception {
//	       return (List<Dlgn0200DTO>)list("dlgn0200DAO.afterSelectDlgn0200", dto); 
//	} 
	
	@Transactional
	public String insertDlgn0210(Dlgn0200DTO dto) throws Exception{
		return (String)insert("dlgn0200DAO.insertDlgn0210", dto);
	}
	@Transactional
	public int updateDlgn0210(Dlgn0200DTO dto) throws Exception{
		return update("dlgn0200DAO.updateDlgn0210", dto);
	}
	
	
	/**
	 * 급여 마감처리 - 마감풀기
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public int updateDlgn0200PayDdlene(Dlgn0200VO vo) throws Exception{
        return update("dlgn0200DAO.updateDlgn0200PayDdlene_S", vo);
    }
	
	
	/**
     * DLGN0200을 등록한다.
     * @param vo - 등록할 정보가 담긴 Dlgn0200VO
     * @return 등록 결과
     * @exception Exception
     */
	@Transactional
    public String insertDlgn0200(Dlgn0200VO vo) throws Exception {
        return (String)insert("dlgn0200DAO.insertDlgn0200_S", vo);
    }

    /**
     * DLGN0200을 수정한다.
     * @param vo - 수정할 정보가 담긴 Dlgn0200VO
     * @return void형
     * @exception Exception
     */
	@Transactional
    public void updateDlgn0200(Dlgn0200VO vo) throws Exception {
        update("dlgn0200DAO.updateDlgn0200_S", vo);
    }
	
	   /**
	    * DLGN0200을 삭제한다.(엑셀)
	    * @param vo - 삭제할 정보가 담긴 Dlgn0250VO
	    * @return void형 
	    * @exception Exception
	    */
	   @Transactional
	   public void deleteXlsDlgn0200(Dlgn0250VO dlgn0250Vo) throws Exception {
	       delete("dlgn0200DAO.deleteXlsDlgn0200_S", dlgn0250Vo);
	   }
	   
	   /**
	    * DLGN0200을 입력한다.(엑셀)
	    * @param vo - 삭제할 정보가 담긴 Dlgn0250VO
	    * @return return형 
	    * @exception Exception
	    */
	   
		@Transactional
		public String insertXlsDlgn0200(Dlgn0250VO dlgn0250Vo) throws Exception{
			return (String)insert("dlgn0200DAO.insertXlsDlgn0200_S", dlgn0250Vo);
		}	

    /**
     * DLGN0200을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Dlgn0200VO
     * @return void형 
     * @exception Exception
     */
	@Transactional
    public void deleteDlgn0200(Dlgn0200VO vo) throws Exception {
        delete("dlgn0200DAO.deleteDlgn0200_S", vo);
    }

    /**
     * DLGN0200을 조회한다.
     * @param vo - 조회할 정보가 담긴 Dlgn0200VO
     * @return 조회한 DLGN0200
     * @exception Exception
     */
    public Dlgn0200VO selectDlgn0200(Dlgn0200VO vo) throws Exception {
        return (Dlgn0200VO) selectByPk("dlgn0200DAO.selectDlgn0200_S", vo);
    }

    /**
     * 근무실적 생성 관리 데이터  
     * @param dlgn0250SrhVo
     * @return
     * @throws Exception
     */
   @SuppressWarnings("unchecked")
   public List<Dlgn0250VO> selectXlsDlgn0250List(Dlgn0250SrhVO dlgn0250SrhVo) throws Exception {
        return (List<Dlgn0250VO>)list("dlgn0100DAO.selectXlsDlgn0250List_D", dlgn0250SrhVo); 
    }
	
   /**
    * 근무실적 조회 리스트(양식)
    * @param dlgn0250SrhVo
    * @return
    * @throws Exception
    */
   public List<Dlgn0250VO> selectXlsDlgn0250FormList(Dlgn0250SrhVO dlgn0250SrhVo) throws Exception {
       return (List<Dlgn0250VO>)list("dlgn0100DAO.selectXlsFileDlgn0250List_D", dlgn0250SrhVo); 
   } 
   
   /**
    * 근무실적 생성 관리 데이터  
    * @param dlgn0250SrhVo
    * @return
    * @throws Exception
    */
  @SuppressWarnings("unchecked")
  public List<Dlgn0250VO> selectXlsDlgn0200List(Dlgn0250SrhVO dlgn0250SrhVo) throws Exception {
       return (List<Dlgn0250VO>)list("dlgn0200DAO.selectXlsDlgn0200List_D", dlgn0250SrhVo); 
   }
  
//  /**
//   * DLGN0200 총 갯수를 조회한다.
//   * @param searchMap - 조회할 정보가 담긴 Map
//   * @return DLGN0200 총 갯수
//   * @exception
//   */
//  public int selectDlgn0200ListTotCnt(Dlgn0200SrhVO searchVO) {
//      return (Integer)getSqlMapClientTemplate().queryForObject("dlgn0200DAO.selectDlgn0200ListTotCnt", searchVO);
//  }
  
}
