package com.app.exterms.personal.server.service.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.client.dto.Psnl0110DTO;
import com.app.exterms.personal.server.vo.Psnl0110SrhVO;
import com.app.exterms.personal.server.vo.Psnl0110VO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0360SrhVO;
import com.ibatis.sqlmap.client.SqlMapClient;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : Psnl0110DAO.java
 * @Description : Psnl0110 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.05.27
 * @version 1.0
 * @see
 *    
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0110DAO")
public class Psnl0110DAO extends EgovAbstractDAO {

	/**
	 * PSNL0110을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0110VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	//TODO psnl123, 300 Impl에서 DTO넣어서 호출해서 사용중.. 일단 그냥 두고 사용하는걸로..
    @Transactional
    public String insertPsnl0110(Psnl0110DTO dto) throws Exception {
        return (String)insert("psnl0110DAO.insertPsnl0110", dto);
    }
    
    public String insertPsnl0100ToPsnl0110(Psnl0110VO psnl0110Vo) throws Exception {
        return (String)insert("psnl0110DAO.insertPsnl0100ToPsnl0110", psnl0110Vo);
    }
    
    @Transactional
    public String insertPsnl0110(Psnl0110VO psnl0110Vo) throws Exception {
        return (String)insert("psnl0110DAO.insertPsnl0110Vo", psnl0110Vo);
    }

    
    /**
	 * PSNL0110을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0110VO
	 * @return void형
	 * @exception Exception
	 */
    
//    @Transactional
//    public int updatePsnl0110(Psnl0110DTO dto) throws Exception {
//        return update("psnl0110DAO.updatePsnl0110", dto);
//    }
    
    @Transactional
    public int updatePsnl0110(Psnl0110VO psnl0110Vo) throws Exception {
        return update("psnl0110DAO.updatePsnl0110", psnl0110Vo);
    }
    
//    @Transactional
//    public int updatePsnl0100ToPsnl0110(Psnl0110DTO dto) throws Exception {
//        return update("psnl0110DAO.updatePsnl0100ToPsnl0110", dto);
//    }   
    
    @Transactional
    public int updatePsnl0100ToPsnl0110(Psnl0110VO psnl0110Vo) throws Exception {
        return update("psnl0110DAO.updatePsnl0100ToPsnl0110", psnl0110Vo);
    }   
    

    //고용시작종료일
//    @Transactional
//    public int updateEmymtEndDate(Psnl0110DTO dto) throws Exception{
//    	return update("psnl0110DAO.updateEmymtEndDate", dto);
//    }
    @Transactional
    public int updateEmymtEndDate(Psnl0110VO psnl0110Vo) throws Exception{
    	return update("psnl0110DAO.updateEmymtEndDate", psnl0110Vo);
    }
    
    //고용날짜
//    @Transactional
//    public int updateEmymtEndNull(Psnl0110DTO dto) throws Exception{
//    	return update("psnl0110DAO.updateEmymtEndNull", dto);
//    }
    
    @Transactional
    public int updateEmymtEndNull(Psnl0110VO psnl0110Vo) throws Exception{
    	return update("psnl0110DAO.updateEmymtEndNull", psnl0110Vo);
    }
    
    
    /**
	 * PSNL0110을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0110VO
	 * @return void형 
	 * @exception Exception
	 */
    
//    @Transactional
//    public int deletePsnl0110(Psnl0110DTO dto) throws Exception {
//        return delete("psnl0110DAO.deletePsnl0110", dto);
//    }
    
    @Transactional
    public int deletePsnl0110(Psnl0110VO psnl0110Vo) throws Exception {
        return delete("psnl0110DAO.deletePsnl0110", psnl0110Vo);
    }
    
    
    /**
	 * PSNL0110을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0110VO
	 * @return void형 
	 * @exception Exception
	 */
    
    @Transactional
    public int deletePsnl0100ToPsnl0110(Psnl0110DTO dto) throws Exception {
        return delete("psnl0110DAO.deletePsnl0100ToPsnl0110", dto);
    }
    

    /**
	 * PSNL0110을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0110VO
	 * @return 조회한 PSNL0110
	 * @exception Exception
	 */
    //20210520_양평 근무시간 조회시 적용
    @SuppressWarnings("rawtypes")
	public List selectPsnl0110(HashMap<String, String> hMap) throws Exception {
        return list("psnl0110DAO.selectPsnl0110", hMap);
    }
    
    
    /**
	 * PSNL0110을 조회한다.(인사관리)
	 * @param vo - 조회할 정보가 담긴 Psnl0110VO
	 * @return 조회한 PSNL0110
	 * @exception Exception
	 */
    public List selectPsnl0100ToPsnl0110List(Psnl0110SrhVO psnl0110SrhVo) throws Exception {
        return list("psnl0110DAO.selectPsnl0100ToPsnl0110List", psnl0110SrhVo);
    }
    
    /**
	 * PSNL0110을 조회한다.(인사관리 - 기간제고용이력)
	 * @param vo - 조회할 정보가 담긴 Psnl0110SrhVO
	 * @return 조회한 PSNL0110
	 * @exception Exception
	 */
    public List selectPsnl0110List(Psnl0110SrhVO psnl0110SrhVo) throws Exception {
        return list("psnl0110DAO.selectPsnl0110List", psnl0110SrhVo);
    }
    public int selectPsnl0110ListCnt(Psnl0110SrhVO psnl0110SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0110DAO.selectPsnl0110ListCnt_S", psnl0110SrhVo);
    }
    
    /**
	 * PSNL0110, INSR2100을 조회한다.(인사관리-사회보험내력)
	 * @param vo - 조회할 정보가 담긴 Psnl0110VO
	 * @return 조회한 PSNL0110
	 * @exception Exception
	 */
    public List selectPsnl0110Insr1200List(Psnl0110SrhVO psnl0110SrhVo) throws Exception {
        return list("psnl0110DAO.selectPsnl0110Insr1200List", psnl0110SrhVo);
    }
    
    
    //근속
//    public EgovMap getLogSvcData(Psnl0110DTO dto) throws Exception {
//        return (EgovMap) selectByPk("psnl0110DAO.getLogSvcData", dto);
//    }
    public EgovMap getLogSvcData(Psnl0110VO psnl0110Vo) throws Exception {
        return (EgovMap) selectByPk("psnl0110DAO.getLogSvcData", psnl0110Vo);
    }
    
    
//    @Transactional
//    public int updateYearMst(HashMap<String, String> hMap) throws Exception{
//    	return update("psnl0110DAO.updateYearMst", hMap);
//    }
    @Transactional
    public int updateYearMst(Psnl0110VO psnl0110Vo) throws Exception{
    	return update("psnl0110DAO.updateYearMst", psnl0110Vo);
    }
    
//    @Transactional
//    public int updateMonthMst(HashMap<String, String> hMap) throws Exception{
//    	return update("psnl0110DAO.updateMonthMst", hMap);
//    }
    @Transactional
    public int updateMonthMst(Psnl0110VO psnl0110Vo) throws Exception{
    	return update("psnl0110DAO.updateMonthMst", psnl0110Vo);
    }
    
    
//    @Transactional
//    public int mergeIntoPayr0500(Psnl0110DTO dto) throws Exception{
//    	return update("psnl0110DAO.mergeIntoPayr0500", dto);
//    }
    
    @Transactional
    public int mergeIntoPayr0500(Psnl0110VO psnl0110Vo) throws Exception{
    	return update("psnl0110DAO.mergeIntoPayr0500", psnl0110Vo);
    }
    
    @SuppressWarnings("deprecation")
    public int selectPsnl0110Chk2017Enter01(HashMap hMap) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0110DAO.selectPsnl0110Chk2017EnterCnt_S_01", hMap);
    }
    
    @SuppressWarnings("deprecation")
    public int selectPsnl0110Chk2017Enter02(HashMap hMap) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0110DAO.selectPsnl0110Chk2017EnterCnt_S_02", hMap);
    }
    
    // 고용 이력 중 가장 최신의 데이터를 가져온다.(신규고용, 재고용, 직제개편, 전보, 연장계약, 공무직전환  중 )
    public Psnl0110VO selectPsnl0110MaxData(Psnl0110SrhVO psnl0110SrhVo) {
        // TODO Auto-generated method stub
        return  (Psnl0110VO) selectByPk("psnl0110DAO.selectPsnl0110MaxData", psnl0110SrhVo);
    }
    
    // 고용 정보 변경에 따른 PAYR0500 단위기관코드 업데이트 처리
    public int updatePayrMangDeptCdPayr0500(Psnl0110VO psnl0110Vo) throws Exception{
    	return update("psnl0110DAO.updatePayrMangDeptCdPayr0500", psnl0110Vo);
    }
    
    // 단위기관, 부서, 직종, 직종세에 해당하는 코드가 BASS0360 테이블에 있는 지 체크
    @SuppressWarnings("deprecation")
	public int selectBass0360PayrMangDeptCdTotCnt(InfcPkgBass0360SrhVO infcPkgBass0360SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0110DAO.selectBass0360PayrMangDeptCdTotCnt", infcPkgBass0360SrhVo);
    }
    
    /**
	 * PSNL0110을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0110VO
	 * @return 조회한 PSNL0110
	 * @exception Exception
	 */
//    @SuppressWarnings("rawtypes")
//	public EgovMap selectInsrPsnl0110(Psnl0110DTO dto) throws Exception {
//        return (EgovMap) selectByPk("psnl0110DAO.selectInsrPsnl0110", dto);
//    } 
//    
    @SuppressWarnings("rawtypes")
	public EgovMap selectInsrPsnl0110(Psnl0110VO psnl0110Vo) throws Exception {
        return (EgovMap) selectByPk("psnl0110DAO.selectInsrPsnl0110", psnl0110Vo);
    } 
    
    
    
    /**
	 * PSNL0110을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0110VO
	 * @return 조회한 PSNL0110
	 * @exception Exception
	 */
    public List selectPsnl0110ExlDataListChk(Psnl0110VO psnl0110Vo) throws Exception {
        return list("psnl0110DAO.selectPsnlExlDataListChk", psnl0110Vo);
    }
    
    
	public void insertXlsData(List<Psnl0110VO> psnl0110VoList) throws Exception {

		SqlMapClient smc = getSqlMapClient();
		

		try {
			
			Psnl0110VO psnl0110Vo;
			
			smc.startTransaction();
			smc.startBatch();

			for (int i = 0; i < psnl0110VoList.size(); i++) {
				
				// 중복데이터 입력 방지를 위해 삭제 후 신규 등록처리
				psnl0110Vo = psnl0110VoList.get(i);
				smc.delete("psnl0110DAO.deletePsnl0110Vo", psnl0110Vo);
				smc.insert("psnl0110DAO.insertPsnl0110Vo", psnl0110Vo);
				
			}
			
			smc.executeBatch();
			smc.commitTransaction();


		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			smc.endTransaction();
			
		}
	}
	

	
//	
//	public String batchInsertData(final List<Psnl0110VO> psnl0110Vo) throws Exception {
//
//
//
//		// ibatis의 SqlExecutor을 사용
//
//		return getSqlMapClientTemplate().execute(
//
//			
//
//			new SqlMapClientCallback<Object> () {
//
//				int dataCount = 0;	// 저장한 데이터 건수
//
//				int batchCount = 0;	// 30건씩 배치 처리한 건수
//
//				int totalCount = psnl0110Vo.size();	// 전체 데이터의 건수
//
//
//
//
//				/* (non-Javadoc)
//
//				 * @see org.springframework.orm.ibatis.SqlMapClientCallback#doInSqlMapClient(com.ibatis.sqlmap.client.SqlMapExecutor)
//
//				 */
//
//				@Override
//
//				public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
//
//			
//
//					try {
//
//						// 배치처리 시작
//
//						executor.startBatch ();
//
//						Map<String, Object> eachData;
//
//
//
//						for (int idx = 0; idx < totalCount; idx++) {
//
//							eachData = dataVector.elementAt(idx);
//
//							// 데이터 저장
//
//							executor.insert("sqlQuery.batchInsert", eachData);
//
//							dataCount++;
//
//
//
//							// 저장건수 30건 마다 배치 처리
//
//							if ((dataCount % 30) == 0) {
//
//								executor.executeBatch();
//
//								batchCount++;
//
//							}					
//
//						}
//
//						// 저장하지 않은 데이터 건수가 남아있다면 남은거 처리
//
//						if ((batchCount * 30) < totalCount) {
//
//							executor.executeBatch();
//
//						}
//
//					} catch (Exception e) {
//
//						throw new SQLException(e.getMessage());
//
//					}
//
//					return dataCount;
//
//				}
//
//			}
//
//		);
//
//	}
	
}
