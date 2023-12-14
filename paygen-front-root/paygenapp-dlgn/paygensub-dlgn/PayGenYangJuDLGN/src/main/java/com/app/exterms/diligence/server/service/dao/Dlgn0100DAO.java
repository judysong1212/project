package com.app.exterms.diligence.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.diligence.client.dto.Dlgn0100DTO;
import com.app.exterms.diligence.server.vo.Dlgn0100SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0100VO;
import com.app.exterms.diligence.server.vo.Dlgn0110SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0250SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0250VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


@Repository("dlgn0100DAO")
public class Dlgn0100DAO extends EgovAbstractDAO implements IsSerializable {
	
	@SuppressWarnings("rawtypes")
	public List selectDlgn0110(Dlgn0100DTO dto) throws Exception{
		return list("dlgn0100DAO.selectDlgn0110", dto);
	}
	
	@SuppressWarnings("rawtypes")
	public List selectDlgn0100(Dlgn0100DTO dto) throws Exception{
		return list("dlgn0100DAO.selectDlgn0100", dto);
	}
	
	@SuppressWarnings("rawtypes")
	public List afterSelectDlgn0100(Dlgn0100DTO dto) throws Exception{
		return list("dlgn0100DAO.afterSelectDlgn0100", dto);
	}
	
//	public List<Dlgn0100DTO> afterSelectDlgn0100(Dlgn0100DTO dto) throws Exception {
//		return (List<Dlgn0100DTO>)list("dlgn0100DAO.afterSelectDlgn0100", dto); 
//	} 
	
	
	@SuppressWarnings("rawtypes")
	public List selectDlgn0100(Dlgn0100SrhVO dlgn0100SrhVO) throws Exception{
		return list("dlgn0100DAO.selectDlgn0100", dlgn0100SrhVO);
	}
	
	@SuppressWarnings("rawtypes")
	public List getPayrMangDeptCd(Dlgn0100DTO dto) throws Exception{
		return list("dlgn0100DAO.getPayrMangDeptCd", dto);
	}
	
	@Transactional
	public int deleteDlgn0100(Dlgn0100DTO dto) throws Exception{
		return delete("dlgn0100DAO.deleteDlgn0100", dto);
	}
	
	@SuppressWarnings("rawtypes")
	public List selectDlgn0100ToRtnData(Dlgn0100DTO dto) throws Exception{
		return list("dlgn0100DAO.selectDlgn0100ToRtnData", dto);
	}
	
	
	@Transactional
	public int deleteDlgn0100_S(Dlgn0100DTO dto) throws Exception{
		return delete("dlgn0100DAO.deleteDlgn0100_S", dto);
	}
	@Transactional
	public int deleteDlgn0110(Dlgn0100DTO dto) throws Exception{
		return delete("dlgn0100DAO.deleteDlgn0110", dto);
	}
	
	@Transactional
	public String insertDlgn0100(Dlgn0100DTO dto) throws Exception{
		return (String)insert("dlgn0100DAO.insertDlgn0100", dto);
	}
	@Transactional //기준일 후
	public String insertDlgn0110(Dlgn0100DTO dto) throws Exception{
		return (String)insert("dlgn0100DAO.insertDlgn0110", dto);
	}
	
	@Transactional //기준일 전
	public String insertDlgn0110Pre(Dlgn0100DTO dto) throws Exception{
		return (String)insert("dlgn0100DAO.insertDlgn0110Pre", dto);
	}
	
	@Transactional
	public int deleteDlgn0110_S(Dlgn0100DTO dto) throws Exception{
		return delete("dlgn0100DAO.deleteDlgn0110_S", dto);
	}

	@Transactional
	public int updateDlgn0110(Dlgn0100DTO dto) throws Exception{
		return update("dlgn0100DAO.updateDlgn0110", dto);
	}
	
	/**
	 * 마감처리및 풀기
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Transactional
   public int updateDlgn0100PayDdlene(Dlgn0100VO vo) throws Exception{
        return update("dlgn0100DAO.updateDlgn0100PayDdlene_S", vo);
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
  * 근무실적 조회 
  * 관리 데이터  
  * @param dlgn0250SrhVo
  * @return
  * @throws Exception
  */
 public List  selectXlsFileDlgn0250List(Dlgn0250SrhVO dlgn0250SrhVo) throws Exception {
     return (List )list("dlgn0100DAO.selectXlsFileDlgn0250List_D", dlgn0250SrhVo); 
 } 
 
   /**
    * 근무실적 관리 데이터 
    * @param dlgn0250SrhVo
    * @return
    * @throws Exception
    */
   public List selectDlgn0250List(Dlgn0250SrhVO dlgn0250SrhVo) throws Exception {
       return  list("dlgn0100DAO.selectDlgn0250List_D", dlgn0250SrhVo); 
   }
   
   /**
    * DLGN0100 총 갯수를 조회한다.
    * @param searchMap - 조회할 정보가 담긴 Map
    * @return DLGN0100 총 갯수
    * @exception
    */
   public int selectDlgn0250ListTotCnt(Dlgn0250SrhVO searchVO) {
       return (Integer)getSqlMapClientTemplate().queryForObject("dlgn0100DAO.selectDlgn0250ListTotCnt_S", searchVO);
   }
   
   /**
    * DLGN0100을 등록한다.
    * @param vo - 등록할 정보가 담긴 Dlgn0100VO
    * @return 등록 결과
    * @exception Exception
    */
   @Transactional
   public String insertDlgn0100(Dlgn0100VO vo) throws Exception {
       return (String)insert("dlgn0100DAO.insertDlgn0100_S", vo);
   }

   /**
    * DLGN0100을 수정한다.
    * @param vo - 수정할 정보가 담긴 Dlgn0100VO
    * @return void형
    * @exception Exception
    */
   @Transactional
   public void updateDlgn0100(Dlgn0100VO vo) throws Exception {
       update("dlgn0100DAO.updateDlgn0100_S", vo);
   }

   /**
    * DLGN0100을 삭제한다.
    * @param vo - 삭제할 정보가 담긴 Dlgn0100VO
    * @return void형 
    * @exception Exception
    */
   @Transactional
   public void deleteDlgn0100(Dlgn0100VO vo) throws Exception {
       delete("dlgn0100DAO.deleteDlgn0100_S", vo);       
   }
   
   
   /**
    * DLGN0100을 삭제한다.(엑셀)
    * @param vo - 삭제할 정보가 담긴 Dlgn0250VO
    * @return void형 
    * @exception Exception
    */
   @Transactional
   public void deleteXlsDlgn0100(Dlgn0250VO dlgn0250Vo) throws Exception {
       delete("dlgn0100DAO.deleteXlsDlgn0100_S", dlgn0250Vo);
   }
   
   /**
    * DLGN0100을 입력한다.(엑셀)
    * @param vo - 삭제할 정보가 담긴 Dlgn0250VO
    * @return return형 
    * @exception Exception
    */
   
	@Transactional
	public String insertXlsDlgn0100(Dlgn0250VO dlgn0250Vo) throws Exception{
		return (String)insert("dlgn0100DAO.insertXlsDlgn0100_S", dlgn0250Vo);
	}
   

   /**
    * DLGN0100을 조회한다.
    * @param vo - 조회할 정보가 담긴 Dlgn0100VO
    * @return 조회한 DLGN0100
    * @exception Exception
    */
   public Dlgn0100VO selectDlgn0100(Dlgn0100VO vo) throws Exception {
       return (Dlgn0100VO) selectByPk("dlgn0100DAO.selectDlgn0100_S", vo);
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
    * DLGN0110 해당 날짜의 주차로 휴일수 확인
    * @param searchMap - 조회할 정보가 담긴 Map
    * @return DLGN0110 해당 날짜의 주차로 휴일수 총 갯수
    * @exception
    */
   public int selectDlgn0110WklyHldyCnt(Dlgn0110SrhVO dlgn0110SrhVO) {
       return (Integer)getSqlMapClientTemplate().queryForObject("dlgn0100DAO.selectDlgn0110WklyHldyCnt_S", dlgn0110SrhVO);
   }

   /**
    * 근무실적 생성 관리 데이터  
    * @param dlgn0250SrhVo
    * @return
    * @throws Exception
    */
  @SuppressWarnings("unchecked")
  public List<Dlgn0250VO> selectXlsDlgn0100List(Dlgn0250SrhVO dlgn0250SrhVo) throws Exception {
       return (List<Dlgn0250VO>)list("dlgn0100DAO.selectXlsDlgn0100List_D", dlgn0250SrhVo); 
   }
  
  /**
   * 근무데이타 체크 
   * @param dlgn0250SrhVo
   * @return
   * @throws Exception
   */
 public int selectDlgn0100Cnt(Dlgn0250SrhVO dlgn0250SrhVo) throws Exception {
      return (Integer)getSqlMapClientTemplate().queryForObject("dlgn0100DAO.selectDlgn0100Cnt", dlgn0250SrhVo);
  }
  
  /**
   * 기본근무관리 양식다운로드 리스트 
   * @param dlgn0250SrhVo
   * @return
   * @throws Exception
   */
 @SuppressWarnings("unchecked")
 public List<Dlgn0250VO> selectXlsDlgn0100ListD(Dlgn0250SrhVO dlgn0250SrhVo) throws Exception {
      return (List<Dlgn0250VO>)list("dlgn0100DAO.selectXlsDlgn0100List_DD", dlgn0250SrhVo); 
  }
	
}
