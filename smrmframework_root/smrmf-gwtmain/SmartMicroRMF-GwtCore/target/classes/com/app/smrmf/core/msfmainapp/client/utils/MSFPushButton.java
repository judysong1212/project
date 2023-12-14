/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.utils;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PushButton;

public class MSFPushButton extends PushButton{
    private String helperText;

    public MSFPushButton(Image upImage, Image downImage) {
        super(upImage, downImage);

    }

    public void onBrowserEvent(Event event) {
        // Should not act on button if disabled.
        if (isEnabled() == false) {
            // This can happen when events are bubbled up from non-disabled children
            return;
        }

        int type = DOM.eventGetType(event);
        switch (type) {
        case Event.ONMOUSEOUT:
            if (DOM.isOrHasChild(getElement(), DOM.eventGetTarget(event)) &&
                    !DOM.isOrHasChild(getElement(), DOM.eventGetToElement(event))) {
            }
            break;
        case Event.ONMOUSEOVER:
            if (DOM.isOrHasChild(getElement(), DOM.eventGetTarget(event))) {

            }
            break;
        }
        super.onBrowserEvent(event);

    }

    public String getHelperText() {
        return helperText;
    }

    public void setHelperText(String helperText) {
        this.helperText = helperText;
    }


}
