/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.generics;

import com.app.smrmf.core.msfmainapp.client.def.LovDef;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;

import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.widget.form.FormPanel;

public class LovFormWindows extends MSFFormWindows {

    private LovDef lovDef;
    private FormPanel initialForm;

    public LovFormWindows(final String title, final MSFFormPanel formPanel, final String btTitle1, final String btTitle2, LovDef lovDef, FormPanel initialForm) {
        super(title, formPanel, btTitle1, btTitle2);
        this.lovDef = lovDef;
        this.initialForm = initialForm;
    }

    /* (non-Javadoc)
     * Override saveForm to do some extra work, i.e. call confirmRecordUpdated()
     * @see com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows#saveForm(com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel)
     */
    protected void saveForm(MSFFormPanel formPanel) {
        super.saveForm(formPanel);
        confirmRecordUpdated(formPanel);
    }

    private void confirmRecordUpdated(MSFFormPanel formPanel) {
        if (formPanel!=null && formPanel.getFormBinding()!=null && formPanel.getFormBinding().getModel()!=null &&
            initialForm != null && initialForm instanceof MSFFormPanel ) {
            // getForm called it, and binding values into fields.
            BaseModel item = (BaseModel)formPanel.getFormBinding().getModel();
            MSFFormPanel form = (MSFFormPanel)initialForm;
            FormBinding binding = form.getFormBinding();
            lovDef.updateBaseModelForm(item, binding);
        }
    }

}
