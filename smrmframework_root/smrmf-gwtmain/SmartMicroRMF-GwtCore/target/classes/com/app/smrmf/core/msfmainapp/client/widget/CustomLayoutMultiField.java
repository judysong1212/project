/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.widget.Layout;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.MultiField;
import com.extjs.gxt.ui.client.widget.layout.LayoutData;
import com.google.gwt.user.client.Element;

/**
 * A multifield with the possibility to have a custom layout, allows for more flexible placing of child field elements.
 */
public class CustomLayoutMultiField<D> extends MultiField<D> {

    protected Layout layout;

    protected List<LayoutData> layoutData;

    /**
     * Creates a new multi-field.
     */
    public CustomLayoutMultiField() {
        super();
        layoutData = new ArrayList<LayoutData>();
    }

    /**
     * Creates a new multi-field.
     * 
     * @param fieldLabel
     *            the field label
     * @param fields
     *            the field(s) to add
     */
    public CustomLayoutMultiField(String fieldLabel, Field<?>... fields) {
        super(fieldLabel, fields);
    }

    @Override
    public void add(Field<?> field) {
        super.add(field);
        layoutData.add(null);
    }

    /**
     * Adds a field with layout data to be used with a custom layout.
     * 
     * @param field
     *            the field to add
     * @param data
     *            the layout data
     */
    public void add(Field<?> field, LayoutData data) {
        super.add(field);
        layoutData.add(data);
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    @Override
    protected void onRender(Element target, int index) {

        // if no custom layout is set do the default
        if (layout == null) {
            super.onRender(target, index);
        } else {

            lc = new LayoutContainer(layout);

            if (GXT.isIE) {
                lc.setStyleAttribute("position", "relative");
            }

            for (int i = 0, len = fields.size(); i < len; i++) {
                final Field<?> f = fields.get(i);

                final LayoutData data = layoutData.get(i);
                lc.add(f, data);
            }

            lc.render(target, index);
            lc.layout();
            setElement(lc.getElement());
        }
    }

    @Override
    protected void onResize(int width, int height) {
        if (layout == null) {
            super.onResize(width, height);
        } else {

            if (mask) {
                mask(maskMessage, maskMessageStyleName);
            }
            if (errorIcon != null && errorIcon.isAttached()) {
                alignErrorIcon();
            }
            if (GXT.isIE) {
                el().repaint();
            }
        }
    }

    @Override
    public void reset() {
      for (Field<?> f : fields) {
          if (!(f instanceof LabelField)) {
              f.reset();
          }
      }
      clearInvalid();
    }

    @Override
    public void clear() {
      for (Field<?> f : fields) {
          if (!(f instanceof LabelField)) {
              f.clear();
          }
      }
      clearInvalid();
    }

}
