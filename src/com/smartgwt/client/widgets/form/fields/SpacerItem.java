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
 * A SpacerItem takes up a single cell in the FormLayout, of arbitrary size.
 */
public class SpacerItem extends FormItem {

    public static SpacerItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (SpacerItem) obj;
        } else {
            return new SpacerItem(jsObj);
        }
    }

    public SpacerItem(){
        setAttribute("editorType", "SpacerItem");
    }

    public SpacerItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public SpacerItem(String name) {
        setName(name);
        setAttribute("editorType", "SpacerItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * default height for the spacer
     *
     * @param height height Default value is 20
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHeight(int height) {
        setAttribute("height", height);
    }

    /**
     * default height for the spacer
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getHeight()  {
        return getAttributeAsInt("height");
    }

    /**
     * we never show a separate title cell for spacers
     *
     * @param showTitle showTitle Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle);
    }

    /**
     * we never show a separate title cell for spacers
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
    }

    /**
     * default width for the spacer
     *
     * @param width width Default value is 20
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setWidth(int width) {
        setAttribute("width", width);
    }

    /**
     * default width for the spacer
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}



