/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.client.widgets.form.fields;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * A FormItem that displays an uneditable value.
 */
public class StaticTextItem extends FormItem {

    public static StaticTextItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (StaticTextItem) obj;
        } else {
            return new StaticTextItem(jsObj);
        }
    }

    public StaticTextItem(){
        setAttribute("editorType", "StaticTextItem");
    }

    public StaticTextItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public StaticTextItem(String name) {
        setName(name);
        setAttribute("editorType", "StaticTextItem");
    }

    public StaticTextItem(String name, String title) {
        setName(name);
		setTitle(title);
        setAttribute("editorType", "StaticTextItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * If true, text that exceeds the specified size of the form item will be clipped
     *
     * @param clipValue clipValue Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setClipValue(Boolean clipValue) {
        setAttribute("clipValue", clipValue);
    }

    /**
     * If true, text that exceeds the specified size of the form item will be clipped
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getClipValue()  {
        return getAttributeAsBoolean("clipValue");
    }

    /**
     * Display format to use for date type values within this formItem. <P> Note that Fields of type <code>"date"</code>,
     * <code>"datetime"</code> or <code>"time"</code> will be edited using a {@link
     * com.smartgwt.client.widgets.form.fields.DateItem} or {@link com.smartgwt.client.widgets.form.fields.TimeItem} by
     * default, but  this can be overridden - for <code>canEdit:false</code> fields, a {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem} is used by default, and the developer can always specify  a
     * custom {@link com.smartgwt.client.widgets.form.fields.FormItem#getEditorType editorType} as well as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType data type}. <P> The {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter} may also be used to format underlying
     * Date values as times (ommitting the date part entirely). If both <code>dateFormatter</code> and
     * <code>timeFormatter</code> are specified on an item, for fields specified as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type "time"} the <code>timeFormatter</code> will be used,
     * otherwise the <code>dateFormatter</code> <P> If <code>item.dateFormatter</code> and <code>item.timeFormatter</code> is
     * unspecified, date display format may be defined at the component level via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDateFormatter dateFormatter}, or for fields of type
     * <code>"datetime"</code> {@link com.smartgwt.client.widgets.form.DynamicForm#getDatetimeFormatter datetimeFormatter}.
     * Otherwise for fields of type "date", default is to use the system-wide default short date format, configured via 
     * Date.setShortDisplayFormat. For fields of type "datetime" or for Date values in fields whose type does not inherit from
     * the logical "date" type, default is to use the system-wide normal date format configured via 
     * Date.setNormalDisplayFormat  (using "toNormalDate()" on logical <code>"date"</code> type fields is not desirable as this
     * would display the time component of the date object to the user).<br> Specify any valid {@link
     * com.smartgwt.client.types.DateDisplayFormat} to  change the format used by this item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dateFormatter dateFormatter Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setTimeFormatter
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter == null ? null : dateFormatter.getValue());
    }

    /**
     * Display format to use for date type values within this formItem. <P> Note that Fields of type <code>"date"</code>,
     * <code>"datetime"</code> or <code>"time"</code> will be edited using a {@link
     * com.smartgwt.client.widgets.form.fields.DateItem} or {@link com.smartgwt.client.widgets.form.fields.TimeItem} by
     * default, but  this can be overridden - for <code>canEdit:false</code> fields, a {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem} is used by default, and the developer can always specify  a
     * custom {@link com.smartgwt.client.widgets.form.fields.FormItem#getEditorType editorType} as well as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType data type}. <P> The {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter} may also be used to format underlying
     * Date values as times (ommitting the date part entirely). If both <code>dateFormatter</code> and
     * <code>timeFormatter</code> are specified on an item, for fields specified as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type "time"} the <code>timeFormatter</code> will be used,
     * otherwise the <code>dateFormatter</code> <P> If <code>item.dateFormatter</code> and <code>item.timeFormatter</code> is
     * unspecified, date display format may be defined at the component level via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDateFormatter dateFormatter}, or for fields of type
     * <code>"datetime"</code> {@link com.smartgwt.client.widgets.form.DynamicForm#getDatetimeFormatter datetimeFormatter}.
     * Otherwise for fields of type "date", default is to use the system-wide default short date format, configured via 
     * Date.setShortDisplayFormat. For fields of type "datetime" or for Date values in fields whose type does not inherit from
     * the logical "date" type, default is to use the system-wide normal date format configured via 
     * Date.setNormalDisplayFormat  (using "toNormalDate()" on logical <code>"date"</code> type fields is not desirable as this
     * would display the time component of the date object to the user).<br> Specify any valid {@link
     * com.smartgwt.client.types.DateDisplayFormat} to  change the format used by this item.
     *
     *
     * @return DateDisplayFormat
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }

    /**
     * By default HTML values in a staticTextItem will be interpreted by the browser. Setting this flag to true will causes
     * HTML characters to be escaped, meaning the raw value of the field (for example <code>"&lt;b&gt;AAA&lt;/b&gt;"</code>) is
     * displayed to the user rather than the interpreted HTML (for example <code>"<b>AAA</b>"</code>)
     *
     * @param escapeHTML escapeHTML Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setEscapeHTML(Boolean escapeHTML) {
        setAttribute("escapeHTML", escapeHTML);
    }

    /**
     * By default HTML values in a staticTextItem will be interpreted by the browser. Setting this flag to true will causes
     * HTML characters to be escaped, meaning the raw value of the field (for example <code>"&lt;b&gt;AAA&lt;/b&gt;"</code>) is
     * displayed to the user rather than the interpreted HTML (for example <code>"<b>AAA</b>"</code>)
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getEscapeHTML()  {
        return getAttributeAsBoolean("escapeHTML");
    }

    /**
     * Base CSS class for this item
     *
     * @param textBoxStyle textBoxStyle Default value is "staticTextItem"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class for this item
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }

    /**
     * If true, item contents can wrap. If false, all the contents should appear on a single line.
     *
     * @param wrap wrap Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setWrap(Boolean wrap) {
        setAttribute("wrap", wrap);
    }

    /**
     * If true, item contents can wrap. If false, all the contents should appear on a single line.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getWrap()  {
        return getAttributeAsBoolean("wrap");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}



