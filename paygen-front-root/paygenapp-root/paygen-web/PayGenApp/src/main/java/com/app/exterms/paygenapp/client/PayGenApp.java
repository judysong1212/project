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
package com.app.exterms.paygenapp.client;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PayGenApp implements EntryPoint {
	
	
  //  public  static final ShowcaseMessages MSG = (ShowcaseMessages) GWT.create(ShowcaseMessages.class);

    private MSFMainApp mainapp;

    public void onModuleLoad() {

        //Get reference to main application
    	mainapp = MSFMainApp.get();

        //To set a custom layout container instead that the view container with linking images
        //LayoutContainer mainPanel = new TestCustomMenuPage();
       // MSFMainApp.setCustomLayoutContent(mainPanel);
         	
        //Start application
    	mainapp.startApplication();

    }
	 
	 
}
