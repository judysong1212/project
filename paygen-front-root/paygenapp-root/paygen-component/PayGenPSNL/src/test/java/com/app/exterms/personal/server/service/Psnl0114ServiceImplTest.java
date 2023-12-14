/**
 * 
 */
package com.app.exterms.personal.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.server.service.dao.Psnl0114DAO;
import com.app.exterms.personal.server.vo.Psnl0114VO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;


/**
 * @author ace2267
 *
 */
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/context-*.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class Psnl0114ServiceImplTest {
	
	private  Log log = LogFactory.getLog(getClass());
	
	
	
    protected static String usingDBMS = "oracle";

    @Resource(name = "jdbcProperties")
    protected Properties jdbcProperties;

    @Autowired
    @Resource(name = "dataSource")
    protected  DataSource dataSource;
	
   
    @Autowired
    @Resource(name="psnl0114DAO")
    private Psnl0114DAO psnl0114DAO;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/*
    @Mock
    private Psnl0114Service psnl0114ServiceMock;
	
	@InjectMocks
	private Psnl0114DAO psnl0114DAOMock = new Psnl0114DAO();*/
	
	private BaseListLoadConfig config ; 
	
	private static HashMap<String, String> params = new HashMap<String, String>();

	private static Psnl0114VO psnl0114Vo = new Psnl0114VO();
	
	private static Psnl0114VO psnl0114VoUp = new Psnl0114VO();
	
	private static Psnl0114VO psnl0114VoDel = new Psnl0114VO();
	
	private List egovResultDataList  = new ArrayList();
	/**
	 * @throws java.lang.Exception
	 */
	// 해당 테스트케이스 CLASS 시작시에 한번만 시작 ( Static으로 반드시 작성할것 )
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	        // 테스트 조회용 MOCK 파라미터  
		    params = new HashMap<String, String>();
	        params.put("systemkey","19960016");
	        params.put("dpobCd","20144050000001");

			
	        // 저장용 VO MOCK
	        psnl0114Vo = new Psnl0114VO();
	        
			psnl0114Vo.setDpobCd("20144050000001");						/** column 사업장코드 : dpobCd */
			psnl0114Vo.setSystemkey("19960016");    			/** column SYSTEMKEY : systemkey */
			psnl0114Vo.setJnDt("20170628");		/** column 가입일자 : jnDt */
			psnl0114Vo.setJnOpztnNm("테트스가입단체");    			/** column 가입단체명 : jnOpztnNm */
			psnl0114Vo.setOdtyNm("A0150002");    					/** column 직책코드 : odtyNm */
			psnl0114Vo.setWirlDt("");  /** column 탈퇴일자 : wirlDt */
			
			psnl0114Vo.setJnPayrDducDivCd("D9500400");	/** column 급여공제구분코드 : jnPayrDducDivCd */
			psnl0114Vo.setJnPayrDducYn("Y");    						/** column 단체급여공제여부 : jnPayrDducYn */
			psnl0114Vo.setJnCntbDducDivCd("B0230042");	/** column 기부금공제구분코드 : jnCntbDducDivCd */
			psnl0114Vo.setJnCntbMknm("천사기부금");    			/** column 기부금표기명 : jnCntbMknm */
			psnl0114Vo.setTxemRducDivCd("");    	/** column 비과세감면구분코드 : txemRducDivCd */
			psnl0114Vo.setJnCtnt("테스트비고");    					/** column 단체비고내용 : jnCtnt */
	
	        // 업데이트 VO MOCK
			psnl0114VoUp = new Psnl0114VO();
	        
			psnl0114VoUp.setDpobCd("20144050000001");						/** column 사업장코드 : dpobCd */
			psnl0114VoUp.setSystemkey("19960016");    			/** column SYSTEMKEY : systemkey */
			psnl0114VoUp.setOpztnSeilNum(new BigDecimal(1));
			psnl0114VoUp.setJnDt("20170628");		/** column 가입일자 : jnDt */
			psnl0114VoUp.setJnOpztnNm("테트스가입단체");    			/** column 가입단체명 : jnOpztnNm */
			psnl0114VoUp.setOdtyNm("A0150002");    					/** column 직책코드 : odtyNm */
			psnl0114VoUp.setWirlDt("");  /** column 탈퇴일자 : wirlDt */
			
			psnl0114VoUp.setJnPayrDducDivCd("D9500400");	/** column 급여공제구분코드 : jnPayrDducDivCd */
			psnl0114VoUp.setJnPayrDducYn("Y");    						/** column 단체급여공제여부 : jnPayrDducYn */
			psnl0114VoUp.setJnCntbDducDivCd("B0230042");	/** column 기부금공제구분코드 : jnCntbDducDivCd */
			psnl0114VoUp.setJnCntbMknm("천사기부금");    			/** column 기부금표기명 : jnCntbMknm */
			psnl0114VoUp.setTxemRducDivCd("");    	/** column 비과세감면구분코드 : txemRducDivCd */
			psnl0114VoUp.setJnCtnt("테스트비고up");    					/** column 단체비고내용 : jnCtnt */
			
			// 삭제 VO MOCK
			psnl0114VoDel = new Psnl0114VO();
	        
			psnl0114VoDel.setDpobCd("20144050000001");						/** column 사업장코드 : dpobCd */
			psnl0114VoDel.setSystemkey("19960016");    			/** column SYSTEMKEY : systemkey */
			psnl0114VoDel.setOpztnSeilNum(new BigDecimal(1));
			psnl0114VoDel.setJnDt("20170628");		/** column 가입일자 : jnDt */
			psnl0114VoDel.setJnOpztnNm("테트스가입단체");    			/** column 가입단체명 : jnOpztnNm */
			psnl0114VoDel.setOdtyNm("A0150002");    					/** column 직책코드 : odtyNm */
			psnl0114VoDel.setWirlDt("");  /** column 탈퇴일자 : wirlDt */
			
			psnl0114VoDel.setJnPayrDducDivCd("D9500400");	/** column 급여공제구분코드 : jnPayrDducDivCd */
			psnl0114VoDel.setJnPayrDducYn("Y");    						/** column 단체급여공제여부 : jnPayrDducYn */
			psnl0114VoDel.setJnCntbDducDivCd("B0230042");	/** column 기부금공제구분코드 : jnCntbDducDivCd */
			psnl0114VoDel.setJnCntbMknm("천사기부금");    			/** column 기부금표기명 : jnCntbMknm */
			psnl0114VoDel.setTxemRducDivCd("");    	/** column 비과세감면구분코드 : txemRducDivCd */
			psnl0114VoDel.setJnCtnt("테스트비고");    					/** column 단체비고내용 : jnCtnt */
			
	
	
	}
	
	


	/**
	 * @throws java.lang.Exception
	 */
	// 해당 테스트케이스 CLASS 종료시에 한번만 시작 ( Static으로 반드시 작성할것 )
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	
		 
		
	}

	
	private static boolean setUpfinished = false;
	
	/**
	 * @throws java.lang.Exception
	 */
	// 해당 @Test 테스트케이스 함수마다 시작전 시작
	@Before
	public void setUp() throws Exception {

	   log.debug("@Before=================== testSelectPsnl0114 setUp");
	
	   // -------- 테스트 마다 실행할 로직 
		  JdbcTestUtils.executeSqlScript(
	               new JdbcTemplate(dataSource), new ClassPathResource(
	                   "META-INF/testdata/sample_schema_ddl_oracle.sql"),
	               true);

	      JdbcTestUtils.executeSqlScript(
	               new JdbcTemplate(dataSource), new ClassPathResource(
	                   "META-INF/testdata/sample_schema_initdata_oracle.sql"), true);
	      
	   
	   if (setUpfinished ) 
	        return;
	   // ---------한번만 실행할 로직 start 
	   log.debug("@Before once =================== testSelectPsnl0114 setUp");

	   

		 // ---------한번만 실행할 로직 end 
	      setUpfinished = true;

	}

	
	/**
	 * @throws java.lang.Exception
	 */
	// 해당 @Test 테스트케이스 함수마다 종료전 시작
	@After
	public void tearDown() throws Exception {
		log.debug("@After=================== testSelectPsnl0114 tearDown");
	
	    // -------- 테스트 마다 실행할 로직 
		
	      JdbcTestUtils.executeSqlScript(
	               new JdbcTemplate(dataSource), new ClassPathResource(
	                   "META-INF/testdata/sample_schema_enddata_oracle.sql"), true);
		
		
		
		if (setUpfinished ) 
		        return;
		  // ---------한번만 실행할 로직 start 
		 log.debug("@After once =================== testSelectPsnl0114 setUp");
		 
		 
		 
		 
		   
		 // ---------한번만 실행할 로직 end 
	      setUpfinished = true;
	
	}


	/**
	 * Test method for {@link com.app.exterms.personal.server.service.Psnl0114ServiceImpl#savePsnl0114(java.util.ArrayList)}.
	 */
	
	

	/**
	 * Test method for {@link com.app.exterms.personal.server.service.Psnl0114ServiceImpl#selectPsnl0114(com.extjs.gxt.ui.client.data.BaseListLoadConfig, java.util.HashMap)}.
	 */
	@Test
	public final void testSelectPsnl0114() {
		egovResultDataList = new ArrayList();
		
		try{
			egovResultDataList= psnl0114DAO.selectPsnl0114(params);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		assertNotNull(egovResultDataList);
		assertEquals(1,egovResultDataList.size());

	}
	


	
	@Test
	public final void testSavePsnl0114() {
		//fail("Not yet implemented"); // TODO
		
		egovResultDataList = new ArrayList();
		int rtnVal = 0;
		
		try{
			psnl0114DAO.insertPsnl0114(psnl0114Vo);
		}catch(Exception ex){
			ex.printStackTrace();
		}

		try{
			egovResultDataList= psnl0114DAO.selectPsnl0114(params);
		}catch(Exception ex){
			ex.printStackTrace();
		}

		assertEquals(2,egovResultDataList.size());
		
		
		
		try{
			rtnVal =	psnl0114DAO.updatePsnl0114(psnl0114VoUp);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		egovResultDataList = new ArrayList();
		
		try{
			egovResultDataList= psnl0114DAO.selectPsnl0114(params);
		}catch(Exception ex){
			ex.printStackTrace();
		}

		assertEquals(1,rtnVal);
		
		assertEquals(2,egovResultDataList.size());
		
		
		
		
		try{
			rtnVal = psnl0114DAO.deletePsnl0114(psnl0114VoDel);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		egovResultDataList = new ArrayList();
		
		try{
			egovResultDataList= psnl0114DAO.selectPsnl0114(params);
		}catch(Exception ex){
			ex.printStackTrace();
		}

		assertEquals(1,rtnVal);
		
		assertEquals(1,egovResultDataList.size());
		

	}

	
	
	/**
	 * Test method for {@link com.app.exterms.personal.server.service.Psnl0114ServiceImpl#getPayrDducCd()}.
	 */
	@Test
	public final void testGetPayrDducCd() {
		//fail("Not yet implemented"); // TODO
		egovResultDataList = new ArrayList();
		try{
			egovResultDataList = psnl0114DAO.getPayrDducCd();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	
		log.debug("testGetPayrDducCdList.toString==========="+egovResultDataList.toString());
	}

	
	
	
}
