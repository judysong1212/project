/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget; 

import java.util.List;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.util.BaseEventPreview;
import com.extjs.gxt.ui.client.widget.CheckBoxListView;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ListModelPropertyEditor;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;

public class MSFMultiExComboBox<D extends ModelData> extends ComboBox<D> {

	private String valueFieldSeparator = ";";
	private String rawSeparator = ", ";

	@SuppressWarnings("unchecked")
	public MSFMultiExComboBox() {
		messages = new ComboBoxMessages();
		setView(new CheckBoxListView<D>());
		setPropertyEditor(new ListModelPropertyEditor<D>());
		monitorWindowResize = true;
		windowResizeDelay = 0;
		initComponent();
		setTriggerAction(TriggerAction.ALL);
	}

	private void bindStore(ListStore<D> store, boolean initial) {
		if (this.store != null && !initial) {
			this.store.removeStoreListener(getStoreListener());
			if (store == null) {
				this.store = null;
				if (getView() != null) {
					getView().setStore(null);
				}
			}
		}
		if (store != null) {
			this.store = store;
			if (store.getLoader() == null) {
				setMode("local");
			}
			if (getView() != null) {
				getView().setStore(store);
			}
			store.addStoreListener(getStoreListener());
		}
	}

	@Override
	public void collapse() {
		super.collapse();

		String text = "";

		for (D d : getSelection()) {

			if (text.length() > 0) {
				text += rawSeparator;
			}

			text += d.get(getDisplayField());
		}

		setRawValue(text);
		updateHiddenValue();
	}

	private void createList(boolean remove, LayoutContainer list) {
		RootPanel.get().add(list);

		setInitialized(true);

		if (getPagingToolBar() != null) {
			setFooter(list.el().createChild("<div class='" + getListStyle() + "-ft'></div>"));
			getPagingToolBar().setBorders(false);
			getPagingToolBar().render(getFooter().dom);
			setAssetHeight(getAssetHeight() + getFooter().getHeight());
		}

		if (remove) {
			RootPanel.get().remove(list);
		}
	}

	@Override
	protected void doForce() {
		return;
	}

	private native int getAssetHeight() /*-{
	//	return this.@com.app.smrmf.core.msfmainapp.client.widget.MSFMultiExComboBox::assetHeight;
	}-*/;

	private native BaseEventPreview getEventPreview() /*-{
		//return this.@com.app.smrmf.core.msfmainapp.client.widget.MSFMultiExComboBox::eventPreview;
	}-*/;

	private native El getFooter() /*-{
		//return this.@com.app.smrmf.core.msfmainapp.client.widget.MSFMultiExComboBox::footer;
	}-*/;

	private native InputElement getHiddenInput() /*-{
		//return this.@com.app.smrmf.core.msfmainapp.client.widget.MSFMultiExComboBox::hiddenInput;
	}-*/;

	public String getRawSeparator() {
		return rawSeparator;
	}

	@Override
	public List<D> getSelection() {
		return ((CheckBoxListView<D>) getView()).getChecked();
	}

	private native StoreListener<D> getStoreListener() /*-{
		//return this.@com.app.smrmf.core.msfmainapp.client.widget.MSFMultiExComboBox::storeListener;
	}-*/;

	@Override
	public D getValue() {
		return null;
	}

	public String getValueFieldSeparator() {
		return valueFieldSeparator;
	}

	 
	@Override
	protected void initList() {

		ListView<D> listView = getView();

		if (listView == null) {
			setView(new CheckBoxListView<D>());
		}

		String style = getListStyle();
		listView.setStyleAttribute("overflowX", "hidden");
		listView.setStyleName(style + "-inner");
		listView.setStyleAttribute("padding", "0px");
		listView.setSelectOnOver(true);
		listView.setBorders(false);
		listView.setStyleAttribute("backgroundColor", "white");
		listView.setSelectStyle(getSelectedStyle());
		listView.setLoadingText(getLoadingText());

		if (getTemplate() == null) {
			listView.setDisplayProperty(getDisplayField());
		} else {
			listView.setTemplate(getTemplate());
		}

		setAssetHeight(0);

		LayoutContainer list = new LayoutContainer() {
			@Override
			protected void onRender(Element parent, int index) {
				super.onRender(parent, index);
				getEventPreview().getIgnoreList().add(getElement());
			}
		};
		list.setScrollMode(Scroll.NONE);
		list.setShim(true);
		list.setShadow(true);
		list.setBorders(true);
		list.setStyleName(style);
		list.hide();

		assert store != null : "ComboBox needs a store";

		list.add(listView);

		setList(list);

		if (getPageSize() > 0) {
			PagingToolBar pageTb = new PagingToolBar(getPageSize());
			pageTb.bind((PagingLoader<?>) store.getLoader());
			setPagingToolBar(pageTb);
		}

		if (!isLazyRender()) {
			createList(true, list);
		}

		bindStore(store, true);
	};

	private native void setAssetHeight(int assetHeight) /*-{
	//	this.@com.app.smrmf.core.msfmainapp.client.widget.MSFMultiExComboBox::assetHeight = assetHeight;
	}-*/;

	private native void setFooter(El footer) /*-{
	//	this.@com.app.smrmf.core.msfmainapp.client.widget.MSFMultiExComboBox::footer = footer;
	}-*/;

	private native void setInitialized(boolean initialized) /*-{
	//	this.@com.app.smrmf.core.msfmainapp.client.widget.MSFMultiExComboBox::initialized = initialized;
	}-*/;

	private native void setList(LayoutContainer list)/*-{
	//	this.@com.app.smrmf.core.msfmainapp.client.widget.MSFMultiExComboBox::list = list;
	}-*/;

	private native void setMode(String mode)/*-{
	//	this.@com.app.smrmf.core.msfmainapp.client.widget.MSFMultiExComboBox::mode = mode;
	}-*/;

	private native void setPagingToolBar(PagingToolBar pageTb)/*-{
	//	this.@com.app.smrmf.core.msfmainapp.client.widget.MSFMultiExComboBox::pageTb = pageTb;
	}-*/;

	public void setRawSeparator(String rawSeparator) {
		this.rawSeparator = rawSeparator;
	}

	@Override
	public void setSelection(List<D> selection) {

		for (D d : selection) {
			((CheckBoxListView<D>) getView()).setChecked(d, true);
		}

		super.setSelection(selection);
	}

	@Override
	public void setValue(D value) {
		return;
	}

	public void setValueFieldSeparator(String valueFieldSeparator) {
		this.valueFieldSeparator = valueFieldSeparator;
	}

	private void updateHiddenValue() {
		if (getHiddenInput() != null) {

			String v = "";

			for (D d : getSelection()) {

				if (v.length() > 0) {
					v += valueFieldSeparator;
				}

				v += d.get(getValueField());
			}

			getHiddenInput().setValue(v);
		}
	}

}


 