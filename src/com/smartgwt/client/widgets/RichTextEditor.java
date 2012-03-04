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
 
package com.smartgwt.client.widgets;



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
 * RichTextEditing component.  Provides a rich-text editing area along with UI for executing rich-text commands on the
 * text.<br> The HTML generated from this component may vary by browser, and, as with any HTML  value created on the
 * client, we recommend values be sanitized on the server before  storing and displaying to other users.<br> Note: This
 * component has limited support on the Safari browser.
 */
public class RichTextEditor extends VLayout {

    public static RichTextEditor getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (RichTextEditor) obj;
        } else {
            return new RichTextEditor(jsObj);
        }
    }

    public RichTextEditor(){
        scClassName = "RichTextEditor";
    }

    public RichTextEditor(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Initial value for the edit area.    Use <code>getValue()</code> and  <code>setValue()</code> to update at runtime.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Updates the current value of the edit area.
     *
     * @param value value Default value is ""
     */
    public void setValue(String value) {
        setAttribute("value", value, true);
    }

    /**
     * Initial value for the edit area.    Use <code>getValue()</code> and  <code>setValue()</code> to update at runtime.
     *
     *
     * @return Retrieves the current value of the edit area.
     */
    public String getValue()  {
        return getAttributeAsString("value");
    }

    // ********************* Methods ***********************
            
    /**
     * Display a warning if Rich Text Editing is not fully supported in this browser. Default behavior logs a warning to the
     * devloper console - Override this if a user-visible warning is required
     */
    public native void doWarn() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.doWarn();
    }-*/;
            
    /**
     * Does this browser support the full RichTextEditor feature set. Returns false for browsers in which some features are not
     * natively supported - currently Safari and Opera.
     *
     * @return false if this browser doesn't fully support RichTextEditing
     */
    public native Boolean richEditorSupported() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.richEditorSupported();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript). 
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param richTextEditorProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(RichTextEditor richTextEditorProperties) /*-{
    	var properties = $wnd.isc.addProperties({},richTextEditorProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.RichTextEditor.addProperties(properties);
    }-*/;
        
    // ***********************************************************        


    /**
     * An array of control group names specifying which groups of controls should be included in the editor toolbar.
     *
     * @param controlGroups the control groups. default is {"fontControls", "formatControls", "styleControls",
     *                      "colorControls"}
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setControlGroups(String... controlGroups) {
        setAttribute("controlGroups", controlGroups, false);
    }

}



