package com.app.smrmf.pkg.yeta.yeta2023.pdfxml.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYe160401DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYe160402DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYe160403DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.*;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfA102y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfB101y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfB201y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfC101y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfC202y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfC301y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfC401y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfD101y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfE102y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfF102y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG104y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG106y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG107y_2023_VO;

//2021연말정산_추가
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG107m_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG205m_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG205y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG206m_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG206y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG207m_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG207y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG304m_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG304y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG306m_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG306y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG307m_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG307y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG407m_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG407y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfJ101y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfJ203m_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfJ203ySrh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfJ203y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfJ301y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfJ401y_2023_VO;
//2021연말정산_추가
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfJ501y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfK101m_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfK101y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfL102y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfN101y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfO101m_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfO101y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfP101m_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfP101y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfP102m_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfP102y_2023_VO;

//2021연말정산_추가
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfQ101y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfQ201y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfQ301y_2023_VO;

//2023연말정산_추가
/*import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfR101m_2023_VO;*/

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfYE162015_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161040_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161050_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161055_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161060_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161070_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161080_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161090_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162020_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162030_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162040_2023_VO;
//2021연말정산_추가
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162510_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe164010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe165010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe165020_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe165030_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe166020_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe166030_2023_VO;

//2021연말정산_추가
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe166040_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167020_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167030_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167040_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167050_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167060_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167070_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167110_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167120_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167130_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167140_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167150_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167210_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167220_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167230_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167240_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167310_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167320_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167410_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167420_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167430_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167440_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167510_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167520_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167530_2023_VO;
import com.app.smrmf.pkg.yeta.yeta2023.pdfxml.service.Yeta8200XmlService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;


/**
 * 
 * <pre>
 * 1. 패키지명 : com.msf.exterms.pdf.xml.service.impl
 * 2. 타입명 : YetaPayr6425ServiceImpl.java
 * 3. 작성일 : Jan 26, 2016 1:37:47 PM
 * 4. 작성자 : leeheuisung
 * 5. 설명 :
 * </pre>
 */
@Service("Yeta8200XmlService")
public class Yeta8200XmlServiceImpl extends AbstractServiceImpl  implements  Yeta8200XmlService {

	private static final Logger LOGGER = LoggerFactory.getLogger(Yeta8200XmlServiceImpl.class);


	@Autowired
	@Resource(name="InfcPkgPdfA102y_2023_DAO")
	private InfcPkgPdfA102y_2023_DAO pdfA102yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfB101y_2023_DAO")
	private InfcPkgPdfB101y_2023_DAO pdfB101yDAO;
	
	//2023연말정산
	@Autowired
	@Resource(name="InfcPkgPdfB201y_2023_DAO")
	private InfcPkgPdfB201y_2023_DAO pdfB201yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfC101y_2023_DAO")
	private InfcPkgPdfC101y_2023_DAO pdfC101yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfC202y_2023_DAO")
	private InfcPkgPdfC202y_2023_DAO pdfC202yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfC301y_2023_DAO")
	private InfcPkgPdfC301y_2023_DAO pdfC301yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfC401y_2023_DAO")
	private InfcPkgPdfC401y_2023_DAO pdfC401yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfD101y_2023_DAO")
	private InfcPkgPdfD101y_2023_DAO pdfD101yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfE102y_2023_DAO")
	private InfcPkgPdfE102y_2023_DAO pdfE102yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfF102y_2023_DAO")
	private InfcPkgPdfF102y_2023_DAO pdfF102yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfG104y_2023_DAO")
	private InfcPkgPdfG104y_2023_DAO pdfG104yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfG107y_2023_DAO")
	private InfcPkgPdfG107y_2023_DAO pdfG107yDAO;
	
	//2023연말정산_추가
	@Autowired
	@Resource(name="InfcPkgPdfG107m_2023_DAO")
	private InfcPkgPdfG107m_2023_DAO pdfG107mDAO;
	
	
	
	@Autowired
	@Resource(name="InfcPkgPdfG205m_2023_DAO")
	private InfcPkgPdfG205m_2023_DAO pdfG205mDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfG205y_2023_DAO")
	private InfcPkgPdfG205y_2023_DAO pdfG205yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfG207m_2023_DAO")
	private InfcPkgPdfG207m_2023_DAO pdfG207mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG207y_2023_DAO")
	private InfcPkgPdfG207y_2023_DAO pdfG207yDAO;
		
	@Autowired
	@Resource(name="InfcPkgPdfG304y_2023_DAO")
	private InfcPkgPdfG304y_2023_DAO pdfG304yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfG304m_2023_DAO")
	private InfcPkgPdfG304m_2023_DAO pdfG304mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG307y_2023_DAO")
	private InfcPkgPdfG307y_2023_DAO pdfG307yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfG307m_2023_DAO")
	private InfcPkgPdfG307m_2023_DAO pdfG307mDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfG407y_2023_DAO")
	private InfcPkgPdfG407y_2023_DAO pdfG407yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfG407m_2023_DAO")
	private InfcPkgPdfG407m_2023_DAO pdfG407mDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfJ101y_2023_DAO")
	private InfcPkgPdfJ101y_2023_DAO pdfJ101yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfJ203y_2023_DAO")
	private InfcPkgPdfJ203y_2023_DAO pdfJ203yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfJ203m_2023_DAO")
	private InfcPkgPdfJ203m_2023_DAO pdfJ203mDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfJ301y_2023_DAO")
	private InfcPkgPdfJ301y_2023_DAO pdfJ301yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfJ401y_2023_DAO")
	private InfcPkgPdfJ401y_2023_DAO pdfJ401yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfJ501y_2023_DAO")
	private InfcPkgPdfJ501y_2023_DAO pdfJ501yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfK101m_2023_DAO")
	private InfcPkgPdfK101m_2023_DAO pdfK101mDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfK101y_2023_DAO")
	private InfcPkgPdfK101y_2023_DAO pdfK101yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfL102y_2023_DAO")
	private InfcPkgPdfL102y_2023_DAO pdfL102yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfN101y_2023_DAO")
	private InfcPkgPdfN101y_2023_DAO pdfN101yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfO101m_2023_DAO")
	private InfcPkgPdfO101m_2023_DAO pdfO101mDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfO101y_2023_DAO")
	private InfcPkgPdfO101y_2023_DAO pdfO101yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfP101m_2023_DAO")
	private InfcPkgPdfP101m_2023_DAO pdfP101mDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfP101y_2023_DAO")
	private InfcPkgPdfP101y_2023_DAO pdfP101yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfP102m_2023_DAO")
	private InfcPkgPdfP102m_2023_DAO pdfP102mDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfP102y_2023_DAO")
	private InfcPkgPdfP102y_2023_DAO pdfP102yDAO;
	
	//2023연말정산_추가
	@Autowired
	@Resource(name="InfcPkgPdfQ101y_2023_DAO")
	private InfcPkgPdfQ101y_2023_DAO pdfQ101yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfQ201y_2023_DAO")
	private InfcPkgPdfQ201y_2023_DAO pdfQ201yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfQ301y_2023_DAO")
	private InfcPkgPdfQ301y_2023_DAO pdfQ301yDAO;
	
	//2023연말정산추가
	/*@Autowired
	@Resource(name="InfcPkgPdfR101m_2023_DAO")
	private InfcPkgPdfR101m_2023_DAO pdfR101mDAO;*/
	
	
	@Autowired
	@Resource(name="InfcPkgPdfYE162015_2023_DAO")
	private InfcPkgPdfYE162015_2023_DAO pdfYE162015DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167010_2023_DAO")
	private InfcPkgYe167010_2023_DAO ye167010DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167020_2023_DAO")
	private InfcPkgYe167020_2023_DAO ye167020DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167030_2023_DAO")
	private InfcPkgYe167030_2023_DAO ye167030DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167040_2023_DAO")
	private InfcPkgYe167040_2023_DAO ye167040DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167050_2023_DAO")
	private InfcPkgYe167050_2023_DAO ye167050DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167060_2023_DAO")
	private InfcPkgYe167060_2023_DAO ye167060DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167070_2023_DAO")
	private InfcPkgYe167070_2023_DAO ye167070DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167530_2023_DAO")
	private InfcPkgYe167530_2023_DAO ye167530DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167110_2023_DAO")
	private InfcPkgYe167110_2023_DAO ye167110DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167120_2023_DAO")
	private InfcPkgYe167120_2023_DAO ye167120DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167130_2023_DAO")
	private InfcPkgYe167130_2023_DAO ye167130DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167140_2023_DAO")
	private InfcPkgYe167140_2023_DAO ye167140DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167150_2023_DAO")
	private InfcPkgYe167150_2023_DAO ye167150DAO;

	@Autowired
	@Resource(name="InfcPkgYe167210_2023_DAO")
	private InfcPkgYe167210_2023_DAO ye167210DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167220_2023_DAO")
	private InfcPkgYe167220_2023_DAO ye167220DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167230_2023_DAO")
	private InfcPkgYe167230_2023_DAO ye167230DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167240_2023_DAO")
	private InfcPkgYe167240_2023_DAO ye167240DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167310_2023_DAO")
	private InfcPkgYe167310_2023_DAO ye167310DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167320_2023_DAO")
	private InfcPkgYe167320_2023_DAO ye167320DAO;

	@Autowired
	@Resource(name="InfcPkgYe167410_2023_DAO")
	private InfcPkgYe167410_2023_DAO ye167410DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167420_2023_DAO")
	private InfcPkgYe167420_2023_DAO ye167420DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167430_2023_DAO")
	private InfcPkgYe167430_2023_DAO ye167430DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167440_2023_DAO")
	private InfcPkgYe167440_2023_DAO ye167440DAO;

	@Autowired
	@Resource(name="InfcPkgYe167510_2023_DAO")
	private InfcPkgYe167510_2023_DAO ye167510DAO;
	
	@Autowired
	@Resource(name="InfcPkgYe167520_2023_DAO")
	private InfcPkgYe167520_2023_DAO ye167520DAO;
	
	/***************************************
	 * 연말정산 테이블  dao
	 ***************************************/
	@Autowired
	@Resource(name = "InfcPkgYe160401DAO")
	private InfcPkgYe160401DAO infcPkgYe160401DAO; //현근무지급여지급명세
	@Autowired
	@Resource(name = "InfcPkgYe160402DAO")
	private InfcPkgYe160402DAO  infcPkgYe160402DAO;//현근무지비과세_감면소득_과세
	@Autowired
	@Resource(name = "InfcPkgYe160403DAO")
	private InfcPkgYe160403DAO  infcPkgYe160403DAO;//현근무지비과세_감면소득_비과세
	@Autowired
	@Resource(name = "InfcPkgYe160404_2023_DAO")
	private InfcPkgYe160404_2023_DAO  infcPkgYe160404DAO;//D_종전근무처
	@Autowired
	@Resource(name = "InfcPkgYe160405_2023_DAO")
	private InfcPkgYe160405_2023_DAO  infcPkgYe160405DAO;//D_종전근무처비과세_감면소득_비과세
	@Autowired
	@Resource(name = "InfcPkgYe160406_2023_DAO")
	private InfcPkgYe160406_2023_DAO  infcPkgYe160406DAO;//종전근무지연금보험료_공적연금
	@Autowired
	@Resource(name = "InfcPkgYe160510_2023_DAO")
	private InfcPkgYe160510_2023_DAO  infcPkgYe160510DAO;//근무지별비과세_감면소득
	            
	@Autowired
	@Resource(name = "InfcPkgYe161005_2023_DAO")
	private InfcPkgYe161005_2023_DAO  infcPkgYe161005DAO;//A_원천세신고기본
	            
	@Autowired
	@Resource(name = "InfcPkgYe161010_2023_DAO")
	private InfcPkgYe161010_2023_DAO  infcPkgYe161010DAO;// 연말정산대상자기본
	@Autowired
	@Resource(name = "InfcPkgYe161020_2023_DAO")
	private InfcPkgYe161020_2023_DAO  infcPkgYe161020DAO;//A_인적소득공제기본
	@Autowired
	@Resource(name = "InfcPkgYe161030_2023_DAO")
	private InfcPkgYe161030_2023_DAO  infcPkgYe161030DAO;//E_인적공제명세
	@Autowired
	@Resource(name = "InfcPkgYe161040_2023_DAO")
	private InfcPkgYe161040_2023_DAO  infcPkgYe161040DAO;//E_소득세액공제명세
	@Autowired
	@Resource(name = "InfcPkgYe161050_2023_DAO")
	private InfcPkgYe161050_2023_DAO  infcPkgYe161050DAO;//C_연금보험료공제
	@Autowired
	@Resource(name = "InfcPkgYe161055_2023_DAO")
	private InfcPkgYe161055_2023_DAO  infcPkgYe161055DAO;//C_연금보험료_공적연금상세
	@Autowired
	@Resource(name = "InfcPkgYe161060_2023_DAO")
	private InfcPkgYe161060_2023_DAO  infcPkgYe161060DAO;//C_특별소득공제
	@Autowired
	@Resource(name = "InfcPkgYe161070_2023_DAO")
	private InfcPkgYe161070_2023_DAO  infcPkgYe161070DAO;//C_그밖의소득공제
	@Autowired
	@Resource(name = "InfcPkgYe161080_2023_DAO")
	private InfcPkgYe161080_2023_DAO  infcPkgYe161080DAO;//C_세액감면및공제
	@Autowired
	@Resource(name = "InfcPkgYe161090_2023_DAO")
	private InfcPkgYe161090_2023_DAO  infcPkgYe161090DAO;//C_교육비내역
	@Autowired
	@Resource(name = "InfcPkgYe162010_2023_DAO")
	private InfcPkgYe162010_2023_DAO  infcPkgYe162010DAO;//F_연금저축계좌
	@Autowired
	@Resource(name = "InfcPkgYe162020_2023_DAO")
	private InfcPkgYe162020_2023_DAO  infcPkgYe162020DAO;//F_퇴직연금계좌명세
	@Autowired
	@Resource(name = "InfcPkgYe162030_2023_DAO")
	private InfcPkgYe162030_2023_DAO  infcPkgYe162030DAO;//F_주택마련저축
	@Autowired
	@Resource(name = "InfcPkgYe162040_2023_DAO")
	private InfcPkgYe162040_2023_DAO  infcPkgYe162040DAO;//F_장기집합투자증권저축_B1013
	@Autowired
	@Resource(name = "InfcPkgYe162510_2023_DAO")
	private InfcPkgYe162510_2023_DAO  infcPkgYe162510DAO;//G_월세액소득공제명세
	@Autowired
	@Resource(name = "InfcPkgYe162520_2023_DAO")
	private InfcPkgYe162520_2023_DAO  infcPkgYe162520DAO;//G_거주자간_금전소비대차
	@Autowired
	@Resource(name = "InfcPkgYe162530_2023_DAO")
	private InfcPkgYe162530_2023_DAO  infcPkgYe162530DAO;//G_임대차계약
	@Autowired
	@Resource(name = "InfcPkgYe164010_2023_DAO")
	private InfcPkgYe164010_2023_DAO infcPkgYe164010DAO; //A_의료비지급명세
	
	@Autowired
	@Resource(name = "InfcPkgYe166030_2023_DAO")
	private InfcPkgYe166030_2023_DAO infcPkgYe166030DAO; //실손보험금 2023연말정산
	
	@Autowired
	@Resource(name = "InfcPkgYe165010_2023_DAO")
	private InfcPkgYe165010_2023_DAO  infcPkgYe165010DAO;//I_해당연도기부금명세
	@Autowired
	@Resource(name = "InfcPkgYe165020_2023_DAO")
	private InfcPkgYe165020_2023_DAO  infcPkgYe165020DAO;//I_기부자관계코드별기부금합계
	@Autowired
	@Resource(name = "InfcPkgYe165030_2023_DAO")
	private InfcPkgYe165030_2023_DAO  infcPkgYe165030DAO;//H_기부금조정명세
	@Autowired
	@Resource(name = "InfcPkgYe165030Temp_2023_DAO")
	private InfcPkgYe165030Temp_2023_DAO infcPkgYe165030TempDAO;    //H_기부금조정명세_TEMP	 
	@Autowired
	@Resource(name = "InfcPkgYe166010_2023_DAO")
	private InfcPkgYe166010_2023_DAO  infcPkgYe166010DAO;//신용카드등소득공제명세
	@Autowired
	@Resource(name = "InfcPkgYe166020_2023_DAO")
	private InfcPkgYe166020_2023_DAO  infcPkgYe166020DAO;//신용카드등소득공제상세
		 
	@Autowired
	@Resource(name = "InfcPkgYe169010_2023_DAO")
	private InfcPkgYe169010_2023_DAO infcPkgYe169010DAO; //C_주현근무처
	@Autowired
	@Resource(name = "InfcPkgYe169010a_2023_DAO")
	private InfcPkgYe169010a_2023_DAO infcPkgYe169010aDAO; //C_주현근무처_표준공제 
	
	//2023연말정산_추가
	@Autowired
	@Resource(name = "InfcPkgYe166040_2023_DAO")
	private InfcPkgYe166040_2023_DAO infcPkgYe166040DAO; //C_주현근무처
	

	@Override
	public void yeta8200_PDF_A102Y_2023_Delete(InfcPkgPdfA102y_2023_VO yetaPdfA102yVo) throws Exception {
		pdfA102yDAO.deletePdfA102y(yetaPdfA102yVo);
	}

	@Override
	public String yeta8200_PDF_A102Y_2023_Insert(InfcPkgPdfA102y_2023_VO yetaPdfA102yVo) throws Exception {
		pdfA102yDAO.insertPdfA102y(yetaPdfA102yVo);
		return null;

	}

	@Override
	public void yeta8200_PDF_B101Y_2023_Delete(InfcPkgPdfB101y_2023_VO yetaPdfB101yVo) throws Exception {
		pdfB101yDAO.deletePdfB101y(yetaPdfB101yVo);
	}

	@Override
	public String yeta8200_PDF_B101Y_2023_Insert(InfcPkgPdfB101y_2023_VO yetaPdfB101yVo) throws Exception {
		pdfB101yDAO.insertPdfB101y(yetaPdfB101yVo);
		return null;
	}
	
	//2023연말정산
	@Override
	public void yeta8200_PDF_B201Y_2023_Delete(InfcPkgPdfB201y_2023_VO yetaPdfB201yVo) throws Exception {
		pdfB201yDAO.deletePdfB201y(yetaPdfB201yVo);
	}

	@Override
	public String yeta8200_PDF_B201Y_2023_Insert(InfcPkgPdfB201y_2023_VO yetaPdfB201yVo) throws Exception {
		pdfB201yDAO.insertPdfB201y(yetaPdfB201yVo);
		return null;
	}

	
		
	@Override
	public void yeta8200_PDF_C101Y_2023_Delete(InfcPkgPdfC101y_2023_VO yetaPdfC101yVo) throws Exception {
		pdfC101yDAO.deletePdfC101y(yetaPdfC101yVo);
		
	}

	@Override
	public String yeta8200_PDF_C101Y_2023_Insert(InfcPkgPdfC101y_2023_VO yetaPdfC101yVo) throws Exception {
		pdfC101yDAO.insertPdfC101y(yetaPdfC101yVo);
		return null;
	}

	@Override
	public void yeta8200_PDF_C202Y_2023_Delete(InfcPkgPdfC202y_2023_VO yetaPdfC202yVo) throws Exception {
		pdfC202yDAO.deletePdfC202y(yetaPdfC202yVo);
		
	}

	@Override
	public String yeta8200_PDF_C202Y_2023_Insert(InfcPkgPdfC202y_2023_VO yetaPdfC202yVo) throws Exception {
		pdfC202yDAO.insertPdfC202y(yetaPdfC202yVo);
		return null;
	}

	@Override
	public void yeta8200_PDF_C301Y_2023_Delete(InfcPkgPdfC301y_2023_VO yetaPdfC301yVo) throws Exception {
		pdfC301yDAO.deletePdfC301y(yetaPdfC301yVo);
		
	}

	@Override
	public String yeta8200_PDF_C301Y_2023_Insert(InfcPkgPdfC301y_2023_VO yetaPdfC301yVo) throws Exception {
		pdfC301yDAO.insertPdfC301y(yetaPdfC301yVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_C401Y_2023_Delete(InfcPkgPdfC401y_2023_VO yetaPdfC401yVo) throws Exception {
		pdfC401yDAO.deletePdfC401y(yetaPdfC401yVo);
		
	}
	
	@Override
	public String yeta8200_PDF_C401Y_2023_Insert(InfcPkgPdfC401y_2023_VO yetaPdfC401yVo) throws Exception {
		pdfC401yDAO.insertPdfC401y(yetaPdfC401yVo);
		return null;
	}

	@Override
	public void yeta8200_PDF_D101Y_2023_Delete(InfcPkgPdfD101y_2023_VO yetaPdfD101yVo) throws Exception {
		pdfD101yDAO.deletePdfD101y(yetaPdfD101yVo);
		
	}

	@Override
	public String yeta8200_PDF_D101Y_2023_Insert(InfcPkgPdfD101y_2023_VO yetaPdfD101yVo) throws Exception {
		pdfD101yDAO.insertPdfD101y(yetaPdfD101yVo);
		return null;
	}

	@Override
	public void yeta8200_PDF_E102Y_2023_Delete(InfcPkgPdfE102y_2023_VO yetaPdfE102yVo) throws Exception {
		pdfE102yDAO.deletePdfE102y(yetaPdfE102yVo);
		
	}

	@Override
	public String yeta8200_PDF_E102Y_2023_Insert(InfcPkgPdfE102y_2023_VO yetaPdfE102yVo) throws Exception {
		pdfE102yDAO.insertPdfE102y(yetaPdfE102yVo);
		return null;
	}

	@Override
	public void yeta8200_PDF_F102Y_2023_Delete(InfcPkgPdfF102y_2023_VO yetaPdfF102yVo) throws Exception {
		pdfF102yDAO.deletePdfF102y(yetaPdfF102yVo);
		
	}

	@Override
	public String yeta8200_PDF_F102Y_2023_Insert(InfcPkgPdfF102y_2023_VO yetaPdfF102yVo) throws Exception {
		pdfF102yDAO.insertPdfF102y(yetaPdfF102yVo);
		return null;
	}

	@Override
	public void yeta8200_PDF_G104Y_2023_Delete(InfcPkgPdfG104y_2023_VO yetaPdfG104yVo) throws Exception {
		pdfG104yDAO.deletePdfG104y(yetaPdfG104yVo);
		
	}

	@Override
	public String yeta8200_PDF_G104Y_2023_Insert(InfcPkgPdfG104y_2023_VO yetaPdfG104yVo) throws Exception {
		pdfG104yDAO.insertPdfG104y(yetaPdfG104yVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_G107Y_2023_Delete(InfcPkgPdfG107y_2023_VO yetaPdfG107yVo) throws Exception {
		pdfG107yDAO.deletePdfG107y(yetaPdfG107yVo);
		
	}
	
	@Override
	public String yeta8200_PDF_G107Y_2023_Insert(InfcPkgPdfG107y_2023_VO yetaPdfG107yVo) throws Exception {
		pdfG107yDAO.insertPdfG107y(yetaPdfG107yVo);
		return null;
	}
	
	//2023연말정산_추가
	@Override
	public void yeta8200_PDF_G107M_2023_Delete(InfcPkgPdfG107m_2023_VO yetaPdfG107mVo) throws Exception {
		pdfG107mDAO.deletePdfG107m(yetaPdfG107mVo);
		
	}
	
	@Override
	public String yeta8200_PDF_G107M_2023_Insert(InfcPkgPdfG107m_2023_VO yetaPdfG107mVo) throws Exception {
		pdfG107mDAO.insertPdfG107m(yetaPdfG107mVo);
		return null;
	}
	
	@Override
	public String yeta8200_PDF_G107M_2023_Update(InfcPkgPdfG107m_2023_VO yetaPdfG107mVo) throws Exception {
		pdfG107mDAO.updatePdfG107m(yetaPdfG107mVo);
		return null;
	}
	
	@Override
	public String yeta8200_PDF_G207M_2023_Update(InfcPkgPdfG207m_2023_VO yetaPdfG207mVo) throws Exception {
		pdfG207mDAO.updatePdfG207m(yetaPdfG207mVo);
		return null;
	}
	
	@Override
	public String yeta8200_PDF_G307M_2023_Update(InfcPkgPdfG307m_2023_VO yetaPdfG307mVo) throws Exception {
		pdfG307mDAO.updatePdfG307m(yetaPdfG307mVo);
		return null;
	}
	
	@Override
	public String yeta8200_PDF_G407M_2023_Update(InfcPkgPdfG407m_2023_VO yetaPdfG407mVo) throws Exception {
		pdfG407mDAO.updatePdfG407m(yetaPdfG407mVo);
		return null;
	}
	
	
	
	
	

	@Override
	public void yeta8200_PDF_G205M_2023_Delete(InfcPkgPdfG205m_2023_VO yetaPdfG205mVo) throws Exception {
		pdfG205mDAO.deletePdfG205m(yetaPdfG205mVo);
		
	}

	@Override
	public String yeta8200_PDF_G205M_2023_Insert(InfcPkgPdfG205m_2023_VO yetaPdfG205mVo) throws Exception {
		pdfG205mDAO.insertPdfG205m(yetaPdfG205mVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_G205Y_2023_Delete(InfcPkgPdfG205y_2023_VO yetaPdfG205yVo) throws Exception {
		pdfG205yDAO.deletePdfG205y(yetaPdfG205yVo);
		
	}
	
	@Override
	public String yeta8200_PDF_G205Y_2023_Insert(InfcPkgPdfG205y_2023_VO yetaPdfG205yVo) throws Exception {
		pdfG205yDAO.insertPdfG205y(yetaPdfG205yVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_G207M_2023_Delete(InfcPkgPdfG207m_2023_VO yetaPdfG207mVo) throws Exception {
		pdfG207mDAO.deletePdfG207m(yetaPdfG207mVo);
		
	}
	
	@Override
	public String yeta8200_PDF_G207M_2023_Insert(InfcPkgPdfG207m_2023_VO yetaPdfG207mVo) throws Exception {
		pdfG207mDAO.insertPdfG207m(yetaPdfG207mVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_G207Y_2023_Delete(InfcPkgPdfG207y_2023_VO yetaPdfG207yVo) throws Exception {
		pdfG207yDAO.deletePdfG207y(yetaPdfG207yVo);
		
	}
	
	@Override
	public String yeta8200_PDF_G207Y_2023_Insert(InfcPkgPdfG207y_2023_VO yetaPdfG207yVo) throws Exception {
		pdfG207yDAO.insertPdfG207y(yetaPdfG207yVo);
		return null;
	}

	@Override
	public void yeta8200_PDF_G304Y_2023_Delete(InfcPkgPdfG304y_2023_VO yetaPdfG304yVo) throws Exception {
		pdfG304yDAO.deletePdfG304y(yetaPdfG304yVo);
		
	}

	@Override
	public String yeta8200_PDF_G304Y_2023_Insert(InfcPkgPdfG304y_2023_VO yetaPdfG304yVo) throws Exception {
		pdfG304yDAO.insertPdfG304y(yetaPdfG304yVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_G304M_2023_Delete(InfcPkgPdfG304m_2023_VO yetaPdfG304mVo) throws Exception {
		pdfG304mDAO.deletePdfG304m(yetaPdfG304mVo);
		
	}
	
	@Override
	public String yeta8200_PDF_G304M_2023_Insert(InfcPkgPdfG304m_2023_VO yetaPdfG304mVo) throws Exception {
		pdfG304mDAO.insertPdfG304m(yetaPdfG304mVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_G307Y_2023_Delete(InfcPkgPdfG307y_2023_VO yetaPdfG307yVo) throws Exception {
		pdfG307yDAO.deletePdfG307y(yetaPdfG307yVo);
		
	}
	
	@Override
	public String yeta8200_PDF_G307Y_2023_Insert(InfcPkgPdfG307y_2023_VO yetaPdfG307yVo) throws Exception {
		pdfG307yDAO.insertPdfG307y(yetaPdfG307yVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_G307M_2023_Delete(InfcPkgPdfG307m_2023_VO yetaPdfG307mVo) throws Exception {
		pdfG307mDAO.deletePdfG307m(yetaPdfG307mVo);
		
	}
	
	@Override
	public String yeta8200_PDF_G307M_2023_Insert(InfcPkgPdfG307m_2023_VO yetaPdfG307mVo) throws Exception {
		pdfG307mDAO.insertPdfG307m(yetaPdfG307mVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_G407Y_2023_Delete(InfcPkgPdfG407y_2023_VO yetaPdfG407yVo) throws Exception {
		pdfG407yDAO.deletePdfG407y(yetaPdfG407yVo);
		
	}
	
	@Override
	public String yeta8200_PDF_G407Y_2023_Insert(InfcPkgPdfG407y_2023_VO yetaPdfG407yVo) throws Exception {
		pdfG407yDAO.insertPdfG407y(yetaPdfG407yVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_G407M_2023_Delete(InfcPkgPdfG407m_2023_VO yetaPdfG407mVo) throws Exception {
		pdfG407mDAO.deletePdfG407m(yetaPdfG407mVo);
		
	}
	
	@Override
	public String yeta8200_PDF_G407M_2023_Insert(InfcPkgPdfG407m_2023_VO yetaPdfG407mVo) throws Exception {
		pdfG407mDAO.insertPdfG407m(yetaPdfG407mVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_J101Y_2023_Delete(InfcPkgPdfJ101y_2023_VO yetaPdfJ101yVo) throws Exception {
		pdfJ101yDAO.deletePdfJ101y(yetaPdfJ101yVo);
		
	}

	@Override
	public String yeta8200_PDF_J101Y_2023_Insert(	InfcPkgPdfJ101y_2023_VO yetaPdfJ101yVo) throws Exception {
		pdfJ101yDAO.insertPdfJ101y(yetaPdfJ101yVo);
		return null;
	}

	@Override
	public void yeta8200_PDF_J203Y_2023_Delete(InfcPkgPdfJ203y_2023_VO yetaPdfJ203yVo)	throws Exception {
		pdfJ203yDAO.deletePdfJ203y(yetaPdfJ203yVo);
		
	}

	@Override
	public String yeta8200_PDF_J203Y_2023_Insert(	InfcPkgPdfJ203y_2023_VO yetaPdfJ203yVo) throws Exception {
		pdfJ203yDAO.insertPdfJ203y(yetaPdfJ203yVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_J203M_2023_Delete(InfcPkgPdfJ203m_2023_VO yetaPdfJ203mVo)	throws Exception {
		pdfJ203mDAO.deletePdfJ203m(yetaPdfJ203mVo);
		
	}
	
	@Override
	public String yeta8200_PDF_J203M_2023_Insert(InfcPkgPdfJ203m_2023_VO yetaPdfJ203mVo) throws Exception {
		pdfJ203mDAO.insertPdfJ203m(yetaPdfJ203mVo);
		return null;
	}

	@Override
	public void yeta8200_PDF_J301Y_2023_Delete(InfcPkgPdfJ301y_2023_VO yetaPdfJ103yVo)	throws Exception {
		pdfJ301yDAO.deletePdfJ301y(yetaPdfJ103yVo);
	}

	@Override
	public String yeta8200_PDF_J301Y_2023_Insert(InfcPkgPdfJ301y_2023_VO yetaPdfJ103yVo) throws Exception {
		pdfJ301yDAO.insertPdfJ301y(yetaPdfJ103yVo);
		return null;
	}

	@Override
	public void yeta8200_PDF_J401Y_2023_Delete(InfcPkgPdfJ401y_2023_VO yetaPdfJ401yVo) throws Exception {
		pdfJ401yDAO.deletePdfJ401y(yetaPdfJ401yVo);
		
	}

	@Override
	public String yeta8200_PDF_J401Y_2023_Insert(InfcPkgPdfJ401y_2023_VO yetaPdfJ401yVo) throws Exception {
		pdfJ401yDAO.insertPdfJ401y(yetaPdfJ401yVo);
		return null;
	}
	
	//2023연말정산_추가
	@Override
	public void yeta8200_PDF_J501Y_2023_Delete(InfcPkgPdfJ501y_2023_VO yetaPdfJ501yVo) throws Exception {
		pdfJ501yDAO.deletePdfJ501y(yetaPdfJ501yVo);
		
	}
	
	@Override
	public String yeta8200_PDF_J501Y_2023_Insert(InfcPkgPdfJ501y_2023_VO yetaPdfJ501yVo) throws Exception {
		pdfJ501yDAO.insertPdfJ501y(yetaPdfJ501yVo);
		return null;
	}
	
	

	@Override
	public void yeta8200_PDF_K101M_2023_Delete(InfcPkgPdfK101m_2023_VO yetaPdfK101mVo) throws Exception {
		pdfK101mDAO.deletePdfK101m(yetaPdfK101mVo);
		
	}

	@Override
	public String yeta8200_PDF_K101M_2023_Insert(InfcPkgPdfK101m_2023_VO yetaPdfK101mVo) throws Exception {
		pdfK101mDAO.insertPdfK101m(yetaPdfK101mVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_K101Y_2023_Delete(InfcPkgPdfK101y_2023_VO yetaPdfK101yVo) throws Exception {
		pdfK101yDAO.deletePdfK101y(yetaPdfK101yVo);
		
	}
	
	@Override
	public String yeta8200_PDF_K101Y_2023_Insert(InfcPkgPdfK101y_2023_VO yetaPdfK101yVo) throws Exception {
		pdfK101yDAO.insertPdfK101y(yetaPdfK101yVo);
		return null;
	}

	@Override
	public void yeta8200_PDF_L102Y_2023_Delete(InfcPkgPdfL102y_2023_VO yetaPdfL102yVo) throws Exception {
		pdfL102yDAO.deletePdfL102y(yetaPdfL102yVo);
		
	}

	@Override
	public String yeta8200_PDF_L102Y_2023_Insert(InfcPkgPdfL102y_2023_VO yetaPdfL102yVo) throws Exception {
		pdfL102yDAO.insertPdfL102y(yetaPdfL102yVo);
		return null;
	}

	@Override
	public void yeta8200_PDF_N101Y_2023_Delete(InfcPkgPdfN101y_2023_VO yetaPdfN101yVo) throws Exception {
		pdfN101yDAO.deletePdfN101y(yetaPdfN101yVo);
		
	}

	@Override
	public String yeta8200_PDF_N101Y_2023_Insert(InfcPkgPdfN101y_2023_VO yetaPdfN101yVo) throws Exception {
		pdfN101yDAO.insertPdfN101y(yetaPdfN101yVo);
		return null;
	}

	@Override
	public void yeta8200_PDF_O101M_2023_Delete(InfcPkgPdfO101m_2023_VO yetaPdfO101mVo) throws Exception {
		pdfO101mDAO.deletePdfO101m(yetaPdfO101mVo);
		
	}

	@Override
	public String yeta8200_PDF_O101M_2023_Insert(InfcPkgPdfO101m_2023_VO yetaPdfO101mVo) throws Exception {
		pdfO101mDAO.insertPdfO101m(yetaPdfO101mVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_O101Y_2023_Delete(InfcPkgPdfO101y_2023_VO yetaPdfO101yVo) throws Exception {
		pdfO101yDAO.deletePdfO101y(yetaPdfO101yVo);
		
	}
	
	@Override
	public String yeta8200_PDF_O101Y_2023_Insert(InfcPkgPdfO101y_2023_VO yetaPdfO101yVo) throws Exception {
		pdfO101yDAO.insertPdfO101y(yetaPdfO101yVo);
		return null;
	}

	@Override
	public void yeta8200_PDF_P101M_2023_Delete(InfcPkgPdfP101m_2023_VO yetaPdfP101mVo)	throws Exception {
		pdfP101mDAO.deletePdfP101m(yetaPdfP101mVo);
		
	}

	@Override
	public String yeta8200_PDF_P101M_2023_Insert(InfcPkgPdfP101m_2023_VO yetaPdfP101mVo) throws Exception {
		pdfP101mDAO.insertPdfP101m(yetaPdfP101mVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_P101Y_2023_Delete(InfcPkgPdfP101y_2023_VO yetaPdfP101yVo)	throws Exception {
		pdfP101yDAO.deletePdfP101y(yetaPdfP101yVo);
		
	}
	
	@Override
	public String yeta8200_PDF_P101Y_2023_Insert(InfcPkgPdfP101y_2023_VO yetaPdfP101yVo) throws Exception {
		pdfP101yDAO.insertPdfP101y(yetaPdfP101yVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_P102M_2023_Delete(InfcPkgPdfP102m_2023_VO yetaPdfP102mVo)	throws Exception {
		pdfP102mDAO.deletePdfP102m(yetaPdfP102mVo);
		
	}
	
	@Override
	public String yeta8200_PDF_P102M_2023_Insert(InfcPkgPdfP102m_2023_VO yetaPdfP102mVo) throws Exception {
		pdfP102mDAO.insertPdfP102m(yetaPdfP102mVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_P102Y_2023_Delete(InfcPkgPdfP102y_2023_VO yetaPdfP102yVo)	throws Exception {
		pdfP102yDAO.deletePdfP102y(yetaPdfP102yVo);
		
	}
	
	@Override
	public String yeta8200_PDF_P102Y_2023_Insert(InfcPkgPdfP102y_2023_VO yetaPdfP102yVo) throws Exception {
		pdfP102yDAO.insertPdfP102y(yetaPdfP102yVo);
		return null;
	}
	
	//2023연말정산_추가
	@Override
	public void yeta8200_PDF_Q101Y_2023_Delete(InfcPkgPdfQ101y_2023_VO yetaPdfQ101yVo) throws Exception {
		pdfQ101yDAO.deletePdfQ101y(yetaPdfQ101yVo);
		
	}
	
	@Override
	public String yeta8200_PDF_Q101Y_2023_Insert(InfcPkgPdfQ101y_2023_VO yetaPdfQ101yVo) throws Exception {
		pdfQ101yDAO.insertPdfQ101y(yetaPdfQ101yVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_Q201Y_2023_Delete(InfcPkgPdfQ201y_2023_VO yetaPdfQ201yVo) throws Exception {
		pdfQ201yDAO.deletePdfQ201y(yetaPdfQ201yVo);
		
	}
	
	@Override
	public String yeta8200_PDF_Q201Y_2023_Insert(InfcPkgPdfQ201y_2023_VO yetaPdfQ201yVo) throws Exception {
		pdfQ201yDAO.insertPdfQ201y(yetaPdfQ201yVo);
		return null;
	}
	
	@Override
	public void yeta8200_PDF_Q301Y_2023_Delete(InfcPkgPdfQ301y_2023_VO yetaPdfQ301yVo) throws Exception {
		pdfQ301yDAO.deletePdfQ301y(yetaPdfQ301yVo);
		
	}
	
	@Override
	public String yeta8200_PDF_Q301Y_2023_Insert(InfcPkgPdfQ301y_2023_VO yetaPdfQ301yVo) throws Exception {
		pdfQ301yDAO.insertPdfQ301y(yetaPdfQ301yVo);
		return null;
	}
	
	
	
	//2023연말정산추가
	/*@Override
	public void yeta8200_PDF_R101M_2023_Delete(InfcPkgPdfR101m_2023_VO yetaPdfR101mVo) throws Exception {
		pdfR101mDAO.deletePdfR101m(yetaPdfR101mVo);
	}

	@Override
	public String yeta8200_PDF_R101M_2023_Insert(InfcPkgPdfR101m_2023_VO yetaPdfR101mVo) throws Exception {
		pdfR101mDAO.insertPdfR101m(yetaPdfR101mVo);
		return null;
	}*/
	
	
	
	

	@Override
	public void yeta8200_PDF_YE162015_2023_Delete(InfcPkgPdfYE162015_2023_VO yetaPdfYE162015Vo) throws Exception {
		pdfYE162015DAO.deletePdfYE162015(yetaPdfYE162015Vo);
	}

	@Override
	public String yeta8200_PDF_YE162015_2023_Insert(InfcPkgPdfYE162015_2023_VO yetaPdfYE162015Vo) throws Exception {
		pdfYE162015DAO.insertPdfYE162015(yetaPdfYE162015Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167010_2023_Delete(InfcPkgYe167010_2023_VO yetaYE167010Vo) throws Exception {
		ye167010DAO.deleteYe167010(yetaYE167010Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167010_2023_Insert(InfcPkgYe167010_2023_VO yetaYE167010Vo) throws Exception {
		ye167010DAO.insertYe167010(yetaYE167010Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167020_2023_Delete(InfcPkgYe167020_2023_VO yetaYE167020Vo) throws Exception {
		ye167020DAO.deleteYe167020(yetaYE167020Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167020_2023_Insert(InfcPkgYe167020_2023_VO yetaYE167020Vo) throws Exception {
		ye167020DAO.insertYe167020(yetaYE167020Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167030_2023_Delete(InfcPkgYe167030_2023_VO yetaYE167030Vo) throws Exception {
		ye167030DAO.deleteYe167030(yetaYE167030Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167030_2023_Insert(InfcPkgYe167030_2023_VO yetaYE167030Vo) throws Exception {
		ye167030DAO.insertYe167030(yetaYE167030Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167040_2023_Delete(InfcPkgYe167040_2023_VO yetaYE167040Vo) throws Exception {
		ye167040DAO.deleteYe167040(yetaYE167040Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167040_2023_Insert(InfcPkgYe167040_2023_VO yetaYE167040Vo) throws Exception {
		ye167040DAO.insertYe167040(yetaYE167040Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167050_2023_Delete(InfcPkgYe167050_2023_VO yetaYE167050Vo) throws Exception {
		ye167050DAO.deleteYe167050(yetaYE167050Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167050_2023_Insert(InfcPkgYe167050_2023_VO yetaYE167050Vo) throws Exception {
		ye167050DAO.insertYe167050(yetaYE167050Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167060_2023_Delete(InfcPkgYe167060_2023_VO yetaYE167060Vo) throws Exception {
		ye167060DAO.deleteYe167060(yetaYE167060Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167060_2023_Insert(InfcPkgYe167060_2023_VO yetaYE167060Vo) throws Exception {
		ye167060DAO.insertYe167060(yetaYE167060Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167070_2023_Delete(InfcPkgYe167070_2023_VO yetaYE167070Vo) throws Exception {
		ye167070DAO.deleteYe167070(yetaYE167070Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167070_2023_Insert(InfcPkgYe167070_2023_VO yetaYE167070Vo) throws Exception {
		ye167070DAO.insertYe167070(yetaYE167070Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167530_2023_Delete(InfcPkgYe167530_2023_VO yetaYE167530Vo) throws Exception {
		ye167530DAO.deleteYe167530(yetaYE167530Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167530_2023_Insert(InfcPkgYe167530_2023_VO yetaYE167530Vo) throws Exception {
		ye167530DAO.insertYe167530(yetaYE167530Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167110_2023_Delete(InfcPkgYe167110_2023_VO yetaYE167110Vo) throws Exception {
		ye167110DAO.deleteYe167110(yetaYE167110Vo);	
	}

	@Override
	public String yeta8200_PDF_YE167110_2023_Insert(InfcPkgYe167110_2023_VO yetaYE167110Vo) throws Exception {
		ye167110DAO.insertYe167110(yetaYE167110Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167120_2023_Delete(InfcPkgYe167120_2023_VO yetaYE167120Vo) throws Exception {
		ye167120DAO.deleteYe167120(yetaYE167120Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167120_2023_Insert(InfcPkgYe167120_2023_VO yetaYE167120Vo) throws Exception {
		ye167120DAO.insertYe167120(yetaYE167120Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167130_2023_Delete(InfcPkgYe167130_2023_VO yetaYE167130Vo) throws Exception {
		ye167130DAO.deleteYe167130(yetaYE167130Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167130_2023_Insert(InfcPkgYe167130_2023_VO yetaYE167130Vo) throws Exception {
		ye167130DAO.insertYe167130(yetaYE167130Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167140_2023_Delete(InfcPkgYe167140_2023_VO yetaYE167140Vo) throws Exception {
		ye167140DAO.deleteYe167140(yetaYE167140Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167140_2023_Insert(InfcPkgYe167140_2023_VO yetaYE167140Vo) throws Exception {
		ye167140DAO.insertYe167140(yetaYE167140Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167150_2023_Delete(InfcPkgYe167150_2023_VO yetaYE167150Vo) throws Exception {
		ye167150DAO.deleteYe167150(yetaYE167150Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167150_2023_Insert(InfcPkgYe167150_2023_VO yetaYE167150Vo) throws Exception {
		ye167150DAO.insertYe167150(yetaYE167150Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167210_2023_Delete(InfcPkgYe167210_2023_VO yetaYE167210Vo) throws Exception {
		ye167210DAO.deleteYe167210(yetaYE167210Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167210_2023_Insert(InfcPkgYe167210_2023_VO yetaYE167210Vo) throws Exception {
		ye167210DAO.insertYe167210(yetaYE167210Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167220_2023_Delete(InfcPkgYe167220_2023_VO yetaYE167220Vo) throws Exception {
		ye167220DAO.deleteYe167220(yetaYE167220Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167220_2023_Insert(InfcPkgYe167220_2023_VO yetaYE167220Vo) throws Exception {
		ye167220DAO.insertYe167220(yetaYE167220Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167230_2023_Delete(InfcPkgYe167230_2023_VO yetaYE167230Vo) throws Exception {
		ye167230DAO.deleteYe167230(yetaYE167230Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167230_2023_Insert(InfcPkgYe167230_2023_VO yetaYE167230Vo) throws Exception {
		ye167230DAO.insertYe167230(yetaYE167230Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167240_2023_Delete(InfcPkgYe167240_2023_VO yetaYE167240Vo) throws Exception {
		ye167240DAO.deleteYe167240(yetaYE167240Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167240_2023_Insert(InfcPkgYe167240_2023_VO yetaYE167240Vo) throws Exception {
		ye167240DAO.insertYe167240(yetaYE167240Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167310_2023_Delete(InfcPkgYe167310_2023_VO yetaYE167310Vo) throws Exception {
		ye167310DAO.deleteYe167310(yetaYE167310Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167310_2023_Insert(InfcPkgYe167310_2023_VO yetaYE167310Vo) throws Exception {
		ye167310DAO.insertYe167310(yetaYE167310Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167320_2023_Delete(InfcPkgYe167320_2023_VO yetaYE167320Vo) throws Exception {
		ye167320DAO.deleteYe167320(yetaYE167320Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167320_2023_Insert(InfcPkgYe167320_2023_VO yetaYE167320Vo) throws Exception {
		ye167320DAO.insertYe167320(yetaYE167320Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167410_2023_Delete(InfcPkgYe167410_2023_VO yetaYE167410Vo) throws Exception {
		ye167410DAO.deleteYe167410(yetaYE167410Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167410_2023_Insert(InfcPkgYe167410_2023_VO yetaYE167410Vo) throws Exception {
		ye167410DAO.insertYe167410(yetaYE167410Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167420_2023_Delete(InfcPkgYe167420_2023_VO yetaYE167420Vo) throws Exception {
		ye167420DAO.deleteYe167420(yetaYE167420Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167420_2023_Insert(InfcPkgYe167420_2023_VO yetaYE167420Vo) throws Exception {
		ye167420DAO.insertYe167420(yetaYE167420Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167430_2023_Delete(InfcPkgYe167430_2023_VO yetaYE167430Vo) throws Exception {
		ye167430DAO.deleteYe167430(yetaYE167430Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167430_2023_Insert(InfcPkgYe167430_2023_VO yetaYE167430Vo) throws Exception {
		ye167430DAO.insertYe167430(yetaYE167430Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167440_2023_Delete(InfcPkgYe167440_2023_VO yetaYE167440Vo) throws Exception {
		ye167440DAO.deleteYe167440(yetaYE167440Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167440_2023_Insert(InfcPkgYe167440_2023_VO yetaYE167440Vo) throws Exception {
		ye167440DAO.insertYe167440(yetaYE167440Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167510_2023_Delete(InfcPkgYe167510_2023_VO yetaYE167510Vo) throws Exception {
		ye167510DAO.deleteYe167510(yetaYE167510Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167510_2023_Insert(InfcPkgYe167510_2023_VO yetaYE167510Vo) throws Exception {
		ye167510DAO.insertYe167510(yetaYE167510Vo);
		return null;
	}

	@Override
	public void yeta8200_PDF_YE167520_2023_Delete(InfcPkgYe167520_2023_VO yetaYE167520Vo) throws Exception {
		ye167520DAO.deleteYe167520(yetaYE167520Vo);
		
	}

	@Override
	public String yeta8200_PDF_YE167520_2023_Insert(InfcPkgYe167520_2023_VO yetaYE167520Vo) throws Exception {
		ye167520DAO.insertYe167520(yetaYE167520Vo);
		return null;
	}

	
	/*********************************************************************************************** 
	 * 2017년도 간소화 자료 업데이트 부분처리 서비스 시작 정산데이타 반영부 처리 메서드 시작
	 ***********************************************************************************************/
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 :보장성,장애인보장성 보험료 개별적업데이트   
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : PdfYeta2023_A102Y_YE161040_Update
	 * @date : 2023. 1. 22.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2023. 1. 22.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @see com.app.smrmf.pkg.yeta.yeta2023.pdfxml.service.Yeta8200XmlService#PdfYeta2023_A102Y_YE161040_Update(com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO)
	 * @param ye161010VO
	 * @return
	 * @throws Exception
	 */
	public int PdfYeta2023_A102Y_YE161040_Update(InfcPkgYe161040_2023_VO ye161040VO) throws Exception {
	 
		return infcPkgYe161040DAO.PdfYeta2023_A102Y_YE161040_Update(ye161040VO);
			 
	} 
	
	
	public String fnYeta8200_A102Y_YE161080_2023_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception {
		 
		return infcPkgYe161080DAO.fnYeta8200_A102Y_YE161080_2023_Update(infcPkgYe161080Vo);
			 
	} 
	
	
	//의료비 
	public String PdfYeta8200_B101Y_YE164010_Delete(InfcPkgYe164010_2023_VO infcPkgYe164010Vo) throws Exception {
		 
		return infcPkgYe164010DAO.PdfYeta8200_B101Y_YE164010_Delete(infcPkgYe164010Vo);
			 
	} 
	
	public String PdfYeta8200_B101Y_YE164010_Insert(InfcPkgYe164010_2023_VO infcPkgYe164010Vo) throws Exception {
		 
		return infcPkgYe164010DAO.PdfYeta8200_B101Y_YE164010_Insert(infcPkgYe164010Vo);
			 
	} 
	
	public int PdfYeta2023_B101Y_YE161040_Update(InfcPkgYe161040_2023_VO ye161040VO) throws Exception {
		 
		return infcPkgYe161040DAO.PdfYeta2023_B101Y_YE161040_Update(ye161040VO);
			 
	} 
	
	// 의료비정리 합계
	public int fnYeta8200_B101Y_YE161080_2023_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception {
		 
		return infcPkgYe161080DAO.fnYeta8200_B101Y_YE161080_2023_Update(infcPkgYe161080Vo);
			 
	} 
	
	//실손의료보험비 추가20201211 2023연말정산
		public String PdfYeta8200_B201Y_YE166030_Delete(InfcPkgYe166030_2023_VO infcPkgYe166030Vo) throws Exception {
			 
			return infcPkgYe166030DAO.PdfYeta8200_B201Y_YE166030_Delete(infcPkgYe166030Vo);
				 
		} 
		
		public String PdfYeta8200_B201Y_YE166030_Insert(InfcPkgYe166030_2023_VO infcPkgYe166030Vo) throws Exception {
			 
			return infcPkgYe166030DAO.PdfYeta8200_B201Y_YE166030_Insert(infcPkgYe166030Vo);
				 
		}
		
		public int PdfYeta2023_B201Y_YE161040_Update(InfcPkgYe161040_2023_VO ye161040VO) throws Exception {
			 
			return infcPkgYe161040DAO.PdfYeta2023_B201Y_YE161040_Update(ye161040VO);
				 
		} 
		
		
		public int fnYeta8200_B201Y_YE161080_2023_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception {
			 
			return infcPkgYe161080DAO.fnYeta8200_B201Y_YE161080_2023_Update(infcPkgYe161080Vo);
				 
		}
		
		
		//2023연말정산_월세액 추가 20201230
		public String PdfYeta8200_J501Y_YE162510_Delete(InfcPkgYe162510_2023_VO infcPkgYe162510Vo) throws Exception {
			 
			return infcPkgYe162510DAO.PdfYeta8200_J501Y_YE162510_Delete(infcPkgYe162510Vo);
				 
		} 
		
		public String PdfYeta8200_J501Y_YE162510_Insert(InfcPkgYe162510_2023_VO infcPkgYe162510Vo) throws Exception {
			 
			return infcPkgYe162510DAO.PdfYeta8200_J501Y_YE162510_Insert(infcPkgYe162510Vo);
				 
		}
		
		public String fnYeta8200_J501Y_YE161080_2023_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception {
			 
			return infcPkgYe161080DAO.fnYeta8200_J501Y_YE161080_2023_Update(infcPkgYe161080Vo);
				 
		}
	
	
	 
	//교육비
	
	public String PdfYeta8200_C101Y_YE161090_Delete(InfcPkgYe161090_2023_VO infcPkgYe161090Vo) throws Exception {
		 
		return infcPkgYe161090DAO.PdfYeta8200_C101Y_YE161090_Delete(infcPkgYe161090Vo);
			 
	} 
	
	public String PdfYeta8200_C101Y_YE161090_Insert(InfcPkgYe161090_2023_VO infcPkgYe161090Vo) throws Exception {
		 
		return infcPkgYe161090DAO.PdfYeta8200_C101Y_YE161090_Insert(infcPkgYe161090Vo);
			 
	} 
	
	public int PdfYeta2023_C101Y_YE161040_Update(InfcPkgYe161040_2023_VO ye161040VO) throws Exception {
		 
		return infcPkgYe161040DAO.PdfYeta2023_C101Y_YE161040_Update(ye161040VO);
			 
	} 
	
	public String fnYeta8200_C101Y_YE161080_2023_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception {
		 
		return infcPkgYe161080DAO.fnYeta8200_C101Y_YE161080_2023_Update(infcPkgYe161080Vo);
			 
	} 	
	
	
	
	//직업훈련비
	
		public String PdfYeta8200_C202Y_YE161090_Delete(InfcPkgYe161090_2023_VO infcPkgYe161090Vo) throws Exception {
			 
			return infcPkgYe161090DAO.PdfYeta8200_C202Y_YE161090_Delete(infcPkgYe161090Vo);
				 
		} 
		
		public String PdfYeta8200_C202Y_YE161090_Insert(InfcPkgYe161090_2023_VO infcPkgYe161090Vo) throws Exception {
			 
			return infcPkgYe161090DAO.PdfYeta8200_C202Y_YE161090_Insert(infcPkgYe161090Vo);
				 
		} 
		
//교복구입비

	public String PdfYeta8200_C301Y_YE161090_Delete(InfcPkgYe161090_2023_VO infcPkgYe161090Vo) throws Exception {
		 
		return infcPkgYe161090DAO.PdfYeta8200_C301Y_YE161090_Delete(infcPkgYe161090Vo);
			 
	} 
	
	public String PdfYeta8200_C301Y_YE161090_Insert(InfcPkgYe161090_2023_VO infcPkgYe161090Vo) throws Exception {
		 
		return infcPkgYe161090DAO.PdfYeta8200_C301Y_YE161090_Insert(infcPkgYe161090Vo);
			 
	} 
	
		//학자금대출
	
		public String PdfYeta8200_C401Y_YE161090_Delete(InfcPkgYe161090_2023_VO infcPkgYe161090Vo) throws Exception {
			 
			return infcPkgYe161090DAO.PdfYeta8200_C401Y_YE161090_Delete(infcPkgYe161090Vo);
				 
		} 
		
		public String PdfYeta8200_C401Y_YE161090_Insert(InfcPkgYe161090_2023_VO infcPkgYe161090Vo) throws Exception {
			 
			return infcPkgYe161090DAO.PdfYeta8200_C401Y_YE161090_Insert(infcPkgYe161090Vo);
				 
		} 

		//개인연금저축 

		public String PdfYeta8200_D101Y_YE162010_Delete(InfcPkgYe162010_2023_VO infcPkgYe162010Vo) throws Exception {
			 
			return infcPkgYe162010DAO.PdfYeta8200_D101Y_YE162010_Delete(infcPkgYe162010Vo);
				 
		} 
		
		public String PdfYeta8200_D101Y_YE162010_Insert(InfcPkgYe162010_2023_VO infcPkgYe162010Vo) throws Exception {
			 
			return infcPkgYe162010DAO.PdfYeta8200_D101Y_YE162010_Insert(infcPkgYe162010Vo);
				 
		} 
		 
	 
		public String fnYeta8200_D101Y_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.fnYeta8200_D101Y_YE161070_2023_Update(infcPkgYe161070Vo);
				 
		} 	
		
		
   //연금저축 
		
		public String PdfYeta8200_E102Y_YE162010_Delete(InfcPkgYe162010_2023_VO infcPkgYe162010Vo) throws Exception {
			 
			return infcPkgYe162010DAO.PdfYeta8200_E102Y_YE162010_Delete(infcPkgYe162010Vo);
				 
		} 
		
		public String PdfYeta8200_E102Y_YE162010_Insert(InfcPkgYe162010_2023_VO infcPkgYe162010Vo) throws Exception {
			 
			return infcPkgYe162010DAO.PdfYeta8200_E102Y_YE162010_Insert(infcPkgYe162010Vo);
				 
		} 
		 
	 
		public String fnYeta8200_E102Y_YE161080_2023_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception {
			 
			return infcPkgYe161080DAO.fnYeta8200_E102Y_YE161080_2023_Update(infcPkgYe161080Vo);
				 
		} 	
		 
		
		
		//퇴직연금

		public String PdfYeta8200_F102Y_YE162020_Delete(InfcPkgYe162020_2023_VO infcPkgYe162020Vo) throws Exception {
			 
			return infcPkgYe162020DAO.PdfYeta8200_F102Y_YE162020_Delete(infcPkgYe162020Vo);
				 
		} 
		
		public String PdfYeta8200_F102Y_YE162020_Insert(InfcPkgYe162020_2023_VO infcPkgYe162020Vo) throws Exception {
			 
			return infcPkgYe162020DAO.PdfYeta8200_F102Y_YE162020_Insert(infcPkgYe162020Vo);
				 
		} 
		 
	 
		public String fnYeta8200_F102Y_YE161080_2023_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception {
			 
			return infcPkgYe161080DAO.fnYeta8200_F102Y_YE161080_2023_Update(infcPkgYe161080Vo);
				 
		} 
		
		//YE161040 소득공제명세에 신용카드 
		
		public int PdfYeta2023_G107Y_YE161040_Update(InfcPkgYe161040_2023_VO ye161040VO) throws Exception {
			 
			return infcPkgYe161040DAO.PdfYeta2023_G107Y_YE161040_Update(ye161040VO);
				 
		} 
		
		public String PdfYeta8200_G107Y_YE166020_Update(InfcPkgYe166020_2023_VO infcPkgYe166020Vo) throws Exception {
			 
			return infcPkgYe166020DAO.PdfYeta8200_G107Y_YE166020_Update(infcPkgYe166020Vo);
				 
		} 
		
		public String fnYeta8200_G107Y_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.fnYeta8200_G107Y_YE161070_2023_Update(infcPkgYe161070Vo);
				 
		}
		
		//YE161040 소득공제명세에 현금영수증  
	
		public int PdfYeta2023_G207Y_YE161040_Update(InfcPkgYe161040_2023_VO ye161040VO) throws Exception {
			 
			return infcPkgYe161040DAO.PdfYeta2023_G207Y_YE161040_Update(ye161040VO);
				 
		} 
	 
		public String fnYeta8200_G207Y_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.fnYeta8200_G207Y_YE161070_2023_Update(infcPkgYe161070Vo);
				 
		} 
		
		
		//YE161040 소득공제명세에 직불카드   
		public int PdfYeta2023_G307Y_YE161040_Update(InfcPkgYe161040_2023_VO ye161040VO) throws Exception {
			 
			return infcPkgYe161040DAO.PdfYeta2023_G307Y_YE161040_Update(ye161040VO);
				 
		} 
	 
		public String fnYeta8200_G307Y_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.fnYeta8200_G307Y_YE161070_2023_Update(infcPkgYe161070Vo);
				 
		}
		
		//YE161040 소득공제명세에 제로페이   
		public int PdfYeta2023_G407Y_YE161040_Update(InfcPkgYe161040_2023_VO ye161040VO) throws Exception {
			 
			return infcPkgYe161040DAO.PdfYeta2023_G407Y_YE161040_Update(ye161040VO);
				 
		} 
	 
		public String fnYeta8200_G407Y_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.fnYeta8200_G407Y_YE161070_2023_Update(infcPkgYe161070Vo);
				 
		}
		
		//주책임차차입금원리금상환액 
		public String fnYeta8200_J101Y_YE161060_2023_Update(InfcPkgYe161060_2023_VO infcPkgYe161060Vo) throws Exception {
			 
			return infcPkgYe161060DAO.fnYeta8200_J101Y_YE161060_2023_Update(infcPkgYe161060Vo);
				 
		} 
		
		//장기주택저당차입금 
		public List<InfcPkgPdfJ203y_2023_VO> PdfYeta8200_F102Y_PDF_J203Y_Select(InfcPkgPdfJ203ySrh_2023_VO yetaPdfJ203yVo) throws Exception {
			 
			return (List<InfcPkgPdfJ203y_2023_VO>)pdfJ203yDAO.PdfYeta8200_F102Y_PDF_J203Y_Select(yetaPdfJ203yVo);
				 
		} 
		
			
		public String fnYeta8200_J203Y_YE161060_2023_Update(InfcPkgYe161060_2023_VO infcPkgYe161060Vo) throws Exception {
			 
			return infcPkgYe161060DAO.fnYeta8200_J203Y_YE161060_2023_Update(infcPkgYe161060Vo);
				 
		} 
		
		
		//주택마련 
		public String PdfYeta8200_J301Y_YE162030_Delete(InfcPkgYe162030_2023_VO infcPkgYe162030Vo) throws Exception {
			 
			return infcPkgYe162030DAO.PdfYeta8200_J301Y_YE162030_Delete(infcPkgYe162030Vo);
				 
		} 
		
		public String PdfYeta8200_J301Y_YE162030_Insert(InfcPkgYe162030_2023_VO infcPkgYe162030Vo) throws Exception {
			 
			return infcPkgYe162030DAO.PdfYeta8200_J301Y_YE162030_Insert(infcPkgYe162030Vo);
				 
		} 
		 
	 
		public String fnYeta8200_J301Y_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.fnYeta8200_J301Y_YE161070_2023_Update(infcPkgYe161070Vo);
				 
		} 
		//소상공인공제  
		public String fnYeta8200_K101M_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.fnYeta8200_K101M_YE161070_2023_Update(infcPkgYe161070Vo);
				 
		} 
		
		//기부금 
		public String PdfYeta8200_L102Y_YE165010_Delete(InfcPkgYe165010_2023_VO infcPkgYe165010Vo) throws Exception {
			 
			return infcPkgYe165010DAO.PdfYeta8200_L102Y_YE165010_Delete(infcPkgYe165010Vo);
				 
		} 
		
		public String PdfYeta8200_L102Y_YE165010_Insert(InfcPkgYe165010_2023_VO infcPkgYe165010Vo) throws Exception {
			 
			return infcPkgYe165010DAO.PdfYeta8200_L102Y_YE165010_Insert(infcPkgYe165010Vo);
				 
		} 
		 //
		public String PdfYeta8200_L102Y_YE165020_Delete(InfcPkgYe165020_2023_VO infcPkgYe165020Vo) throws Exception {
			 
			return infcPkgYe165020DAO.PdfYeta8200_L102Y_YE165020_Delete(infcPkgYe165020Vo);

		} 
		
		public String PdfYeta8200_L102Y_YE165020_Insert(InfcPkgYe165020_2023_VO infcPkgYe165020Vo) throws Exception {
			 
			return infcPkgYe165020DAO.PdfYeta8200_L102Y_YE165020_Insert(infcPkgYe165020Vo);
				 
		}
		//
		public String PdfYeta8200_L102Y_YE165030_Delete(InfcPkgYe165030_2023_VO infcPkgYe165030Vo) throws Exception {
			 
			return infcPkgYe165030DAO.PdfYeta8200_L102Y_YE165030_Delete(infcPkgYe165030Vo);
				 
		} 
		
		public String PdfYeta8200_L102Y_YE165030_Insert(InfcPkgYe165030_2023_VO infcPkgYe165030Vo) throws Exception {
			 
			return infcPkgYe165030DAO.PdfYeta8200_L102Y_YE165030_Insert(infcPkgYe165030Vo);
				 
		} 
		
		
		
		//2023연말정산_추가
		public String PdfYeta8200_Q101Y_YE166040_Delete(InfcPkgYe166040_2023_VO infcPkgYe166040Vo) throws Exception {
			 
			return infcPkgYe166040DAO.PdfYeta8200_Q101Y_YE166040_Delete(infcPkgYe166040Vo);
				 
		} 
		
		public String PdfYeta8200_Q101Y_YE166040_Insert(InfcPkgYe166040_2023_VO infcPkgYe166040Vo) throws Exception {
			 
			return infcPkgYe166040DAO.PdfYeta8200_Q101Y_YE166040_Insert(infcPkgYe166040Vo);
				 
		}
		
		public String fnYeta8200_Q101Y_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.fnYeta8200_Q101Y_YE161070_2023_Update(infcPkgYe161070Vo);
				 
		}
		
		//2023연말정산_추가
		public String PdfYeta8200_Q201Y_YE166040_Delete(InfcPkgYe166040_2023_VO infcPkgYe166040Vo) throws Exception {
			 
			return infcPkgYe166040DAO.PdfYeta8200_Q201Y_YE166040_Delete(infcPkgYe166040Vo);
				 
		} 
		
		public String PdfYeta8200_Q201Y_YE166040_Insert(InfcPkgYe166040_2023_VO infcPkgYe166040Vo) throws Exception {
			 
			return infcPkgYe166040DAO.PdfYeta8200_Q201Y_YE166040_Insert(infcPkgYe166040Vo);
				 
		}
		
		public String fnYeta8200_Q201Y_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.fnYeta8200_Q201Y_YE161070_2023_Update(infcPkgYe161070Vo);
				 
		}
		
		
		
		//2023연말정산_추가
		public String PdfYeta8200_Q301Y_YE166040_Delete(InfcPkgYe166040_2023_VO infcPkgYe166040Vo) throws Exception {
			 
			return infcPkgYe166040DAO.PdfYeta8200_Q301Y_YE166040_Delete(infcPkgYe166040Vo);
				 
		} 
		
		public String PdfYeta8200_Q301Y_YE166040_Insert(InfcPkgYe166040_2023_VO infcPkgYe166040Vo) throws Exception {
			 
			return infcPkgYe166040DAO.PdfYeta8200_Q301Y_YE166040_Insert(infcPkgYe166040Vo);
				 
		}
		
		public String fnYeta8200_Q301Y_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.fnYeta8200_Q301Y_YE161070_2023_Update(infcPkgYe161070Vo);
				 
		}
		
		
		
		
		
		
		
		
		public int fnYeta8200_L102Y_YE161080_2023_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception {
			 
			return infcPkgYe161080DAO.fnYeta8200_L102Y_YE161080_2023_Update(infcPkgYe161080Vo);
				 
		}  
		
		public int fnYeta8200_L102Y_YE161040_2023_Update(InfcPkgYe161040_2023_VO infcPkgYe161040Vo) throws Exception {
			 
			return infcPkgYe161040DAO.fnYeta8200_L102Y_YE161040_2023_Update(infcPkgYe161040Vo);
				 
		}  
 
		
		
		public String fnYeta8200_L102Y_YE161060_2023_Update(InfcPkgYe161060_2023_VO infcPkgYe161060Vo) throws Exception {
			 
			return infcPkgYe161060DAO.fnYeta8200_L102Y_YE161060_2023_Update(infcPkgYe161060Vo);
				 
		}   
		
		//장기집합 투자 증권 
		public String PdfYeta8200_N101Y_YE162040_Delete(InfcPkgYe162040_2023_VO infcPkgYe162040Vo) throws Exception {
			 
			return infcPkgYe162040DAO.PdfYeta8200_N101Y_YE162040_Delete(infcPkgYe162040Vo);
				 
		} 
		
		public String PdfYeta8200_N101Y_YE162040_Insert(InfcPkgYe162040_2023_VO infcPkgYe162040Vo) throws Exception {
			 
			return infcPkgYe162040DAO.PdfYeta8200_N101Y_YE162040_Insert(infcPkgYe162040Vo);
				 
		} 
		 
	 
		public String fnYeta8200_N101Y_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.fnYeta8200_N101Y_YE161070_2023_Update(infcPkgYe161070Vo);
				 
		} 
		
		
		//건강보험료 금액
		public String PdfYeta2023_O101M_YE161040_Update(InfcPkgYe161040_2023_VO infcPkgYe161040Vo) throws Exception {
			 
			return infcPkgYe161040DAO.PdfYeta2023_O101M_YE161040_Update(infcPkgYe161040Vo);
				 
		} 
		
		public String fnYeta8200_O101M_YE161060_2023_Update(InfcPkgYe161060_2023_VO infcPkgYe161060Vo) throws Exception {
			 
			return infcPkgYe161060DAO.fnYeta8200_O101M_YE161060_2023_Update(infcPkgYe161060Vo);
				 
		}  
		
		//YE161055 국민연금 주사업장 
		public String PdfYeta2023_P102M_YE161055_Update(InfcPkgYe161055_2023_VO infcPkgYe161055Vo) throws Exception {
			 
			return infcPkgYe161055DAO.PdfYeta2023_P102M_YE161055_Update(infcPkgYe161055Vo);
				 
		} 
		
		public int fnYeta8200_P102M_YE161050_2023_Update(InfcPkgYe161050_2023_VO infcPkgYe161050Vo) throws Exception {
			 
			return infcPkgYe161050DAO.fnYeta8200_P102M_YE161050_2023_Update(infcPkgYe161050Vo);
				 
		}

		public int PdfYeta8200_AllDelete(InfcPkgYe161010_2023_VO ye161010vo)throws Exception {
			return infcPkgYe161010DAO.PdfYeta8200_AllDelete(ye161010vo);
		}

		 
	/*********************************************************************************************** 
	 * 2023년도 간소화 자료 업데이트 부분처리 서비스 시작 정산데이타 반영부 처리 메서드 종료
	 ***********************************************************************************************/
}
