package org.app.exterms.html;

import java.util.HashMap;
import java.util.Map;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.util.Format;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.HtmlContainer;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * An extension of HtmlContainer which provides support for synchronizing the size of widgets
 * with the size of the HTML element they're contained in.  It also adds support for internationalization,
 * caching, and convenience methods for setting the inner HTML of elements.
 * 
 * @author jonathan janisch
 *
 */
public class TemplateContainer extends HtmlContainer
{

	protected Map<String, String> params;

	protected String rawHtml;

	protected Map<String, String> innerHtmls = new HashMap<String, String>();

	protected static Map<String, Response> templateCache = new HashMap<String, Response>();
	
	private String urlCopy; // url in parent is private
	
	private boolean useCache = true;
	
	private boolean rtl;

	public TemplateContainer()
	{
		super();
	}

	public TemplateContainer(Element elem)
	{
		super(elem);
	}

	public TemplateContainer(String html)
	{
		super(html);
	}

	public TemplateContainer(RequestBuilder requestBuilder)
	{
		super(requestBuilder);
		setUrl(requestBuilder.getUrl()); // gxt 2.1.3 bug - fixed in gxt 2.2
	}
	
	public boolean isRtl() {
		return rtl;
	}

	public void setRtl(boolean rtl) {
		this.rtl = rtl;
	}

	public boolean isUseCache()
	{
		return useCache;
	}

	public void setUseCache(boolean useCache)
	{
		this.useCache = useCache;
	}

	@Override
	protected void handleResponseReceived(Request request, Response response)
	{
		// TODO: it's possible the URL may have changed and we cache a response for the wrong URL
		templateCache.put(urlCopy, response);
		super.handleResponseReceived(request, response);
	}

	// Overridden solely because the URL is private
	@Override
	public void setUrl(String url)
	{
		this.urlCopy = url;
		super.setUrl(url);
	}

	// Overridden in order to use cached request
	@Override
	protected void requestData()
	{
		if (useCache && templateCache.containsKey(urlCopy))
		{
			handleResponseReceived(null, templateCache.get(urlCopy));
		}
		else
		{
			super.requestData();
		}
	}

	/**
	 * Convenience method to set the inner HTML of the node as soon as possible.
	 * @param selector
	 * @param html
	 */
	public void setInnerHtml(String selector, String html)
	{
		if (rendered)
		{
			El node = el().selectNode(selector);
			if (node != null)
			{
				node.setInnerHtml(html);
			}
		}
		else
		{
			innerHtmls.put(selector, html);
		}
	}
	
	private void setInnerHtmls()
	{
		for (String key : innerHtmls.keySet())
		{
			setInnerHtml(key, innerHtmls.get(key));
		}
	}

	public void substitute(Map<String, String> params)
	{
		if (this.params == null)
		{
			this.params = params;
		}
		else
		{
			this.params.putAll(params);
		}

		if (rendered && rawHtml != null)
		{
			setHtml(rawHtml);
		}
	}

	@Override
	public void setHtml(String html)
	{
		this.rawHtml = html;

		String markup = html;
		
		Map<String,Object> subMap = new HashMap<String,Object>();
		if (params != null && params.size() > 0)
		{
			subMap.putAll(params);
		}
		
		subMap.put("rtl", isRtl() ? "rtl" : "ltr");
		subMap.put("left", isRtl() ? "right" : "left");
		subMap.put("right", isRtl() ? "left" : "right");
		
		markup = Format.substitute(markup, subMap);

		super.setHtml(markup);
		
		setInnerHtmls();
		syncSizes();
	}

	/**
	 * Inserts the widget into the template as a child of the first element found with the given CSS selector.
	 * The widget's height will be be synchronized to the height of it's containing HTML element. 
	 * 
	 * @param widget
	 * @param selector
	 */
	public void addSyncHeight(Widget widget, String selector)
	{
		addSyncHeight(widget, selector, -1);
	}

	/**
	 * Inserts the widget into the template as a child of the first element found with the given CSS selector.
	 * The widget's height will be be synchronized to the height of it's containing HTML element. 
	 * 
	 * @param widget
	 * @param selector
	 */
	public void addSyncHeight(Widget widget, String selector, int minimumHeight)
	{
		Component component = wrapWidget(widget);
		if (super.add(component))
		{
			component.setData("selector", selector);
			component.setData("minimumHeight", minimumHeight);
			if (rendered)
			{
				renderItem(component, selector);
			}
		}
	}

	/**
	 * Inserts the widget into the template as a child of the first element found with the given CSS selector.
	 * The widget's width will be be synchronized to the height of it's containing HTML element. 
	 * 
	 * @param widget
	 * @param selector
	 */
	public void addSyncWidth(Widget widget, String selector)
	{
		addSyncWidth(widget, selector, -1);
	}

	/**
	 * Inserts the widget into the template as a child of the first element found with the given CSS selector.
	 * The widget's width will be be synchronized to the height of it's containing HTML element. 
	 * 
	 * @param widget
	 * @param selector
	 */
	public void addSyncWidth(Widget widget, String selector, int minimumWidth)
	{
		Component component = wrapWidget(widget);
		if (super.add(component))
		{
			component.setData("selector", selector);
			component.setData("minimumWidth", minimumWidth);
			if (rendered)
			{
				renderItem(component, selector);
			}
		}
	}

	/**
	 * Inserts the widget into the template as a child of the first element found with the given CSS selector.
	 * The widget's size will be be synchronized to the height of it's containing HTML element. 
	 * 
	 * @param widget
	 * @param selector
	 */
	public void addSyncSize(Widget widget, String selector)
	{
		addSyncSize(widget, selector, -1, -1);
	}

	/**
	 * Inserts the widget into the template as a child of the first element found with the given CSS selector.
	 * The widget's size will be be synchronized to the height of it's containing HTML element. 
	 * 
	 * @param widget
	 * @param selector
	 */
	public void addSyncSize(Widget widget, String selector, int minimumWidth, int minimumHeight)
	{
		Component component = wrapWidget(widget);
		if (super.add(component))
		{
			component.setData("selector", selector);
			component.setData("minimumWidth", minimumWidth);
			component.setData("minimumHeight", minimumHeight);
			if (rendered)
			{
				renderItem(component, selector);
			}
		}
	}

	@Override
	protected void onResize(int width, int height)
	{
		super.onResize(width, height);
		syncSizes();
	}

	@Override
	protected void onRender(Element target, int index)
	{
		super.onRender(target, index);
		setInnerHtmls();
		syncSizes();
	}

	public void syncSizes()
	{
		if (rendered)
		{
			// Reset growable nodes to minimum or 1 in the first pass
			// This will perform one layout
			for (Component component : getItems())
			{
				if (component instanceof BoxComponent)
				{

					if (component.getData("minimumHeight") != null)
					{
						int height = Math.max((Integer) component.getData("minimumHeight"), 1);
						((BoxComponent) component).setHeight(height);
					}
					if (component.getData("minimumWidth") != null)
					{
						int width = Math.max((Integer) component.getData("minimumWidth"), 1);
						((BoxComponent) component).setWidth(width);

						if (GXT.isIE7 && component.isRendered() && component instanceof Field)
						{
							El input = component.el().selectNode("input");
							if (input != null)
							{
								input.setWidth(1);
							}
						}
					}
				}
			}

			// Read the size of all "selector" elements. We don't do the write here for performance
			// reasons. rwrw slower than rrww
			for (Component component : getItems())
			{
				if (component instanceof BoxComponent)
				{

					if (component.getData("minimumHeight") != null || component.getData("minimumWidth") != null)
					{

						El node = el().selectNode((String) component.getData("selector"));

						if (node != null)
						{

							if (component.getData("minimumHeight") != null)
							{
								int minHeight = ((Integer) component.getData("minimumHeight")).intValue();
								int nodeHeight = node.getHeight();

								if (minHeight != -1)
								{
									nodeHeight = Math.max(minHeight, nodeHeight);
								}
								component.setData("h", nodeHeight);
								// ((BoxComponent) component).setHeight(nodeHeight);
							}
							if (component.getData("minimumWidth") != null)
							{
								int minWidth = ((Integer) component.getData("minimumWidth")).intValue();
								int nodeWidth = node.getWidth();
								if (minWidth != -1)
								{
									nodeWidth = Math.max(minWidth, nodeWidth);
								}
								component.setData("w", nodeWidth);
								// ((BoxComponent) component).setWidth(nodeWidth);
							}

						}
					}
				}
			}

			// Finally, set the size of the injected widgets to the size of their parent selectors.
			for (Component component : getItems())
			{
				if (component instanceof BoxComponent)
				{
					if (component.getData("h") != null && component.getData("w") != null)
					{
						((BoxComponent) component).setSize(
							(Integer) component.getData("w"),
							(Integer) component.getData("h"));
					}
					else
					{
						if (component.getData("h") != null)
						{
							((BoxComponent) component).setHeight((Integer) component.getData("h"));
						}
						if (component.getData("w") != null)
						{
							((BoxComponent) component).setWidth((Integer) component.getData("w"));
						}
					}
				}
			}
		}
	}
}
