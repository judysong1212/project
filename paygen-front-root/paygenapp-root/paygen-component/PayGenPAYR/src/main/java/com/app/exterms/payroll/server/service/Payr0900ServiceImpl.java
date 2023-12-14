/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.app.exterms.payroll.server.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.client.service.Payr0900Service;
import com.app.exterms.payroll.server.service.dao.Payr0900DAO;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;

/**
 * @Class Name : Payr0900ServiceImpl.java
 * @Description : Payr0900 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@Service("Payr0900Service")
public class Payr0900ServiceImpl extends AbstractCustomServiceImpl  implements Payr0900Service {

	private static final Logger logger = LoggerFactory.getLogger(Payr0900ServiceImpl.class);
	private static final String calledClass = Payr0900ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="Payr0900DAO")
    private Payr0900DAO payr0900DAO;
    
    /** ID Generation */
    //@Resource(name="{egovPayr0900IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * PAYR0900을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0900VO
	 * @return 등록 결과
	 * @exception Exception
	 */
 
    

}
