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
 
package com.smartgwt.client.widgets.drawing;



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
 * An abstract class which holds an Array of ColorStop or start/stop colors.
 */
public class Gradient extends DataClass {

    public static Gradient getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new Gradient(jsObj);
    }

    public Gradient(){
        
    }

    public Gradient(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************

    /**
     * 
     *
     * @param colorStops colorStops Default value is null
     */
    public void setColorStops(ColorStop... colorStops) {
        setAttribute("colorStops", colorStops);
    }

    /**
     * 
     *
     *
     * @return ColorStop
     */
    public ColorStop[] getColorStops()  {
        return ColorStop.convertToColorStopArray(getAttributeAsJavaScriptObject("colorStops"));
    }

    /**
     * if both startColor and endColor are set then colorStops is ignored
     *
     * @param endColor endColor Default value is null
     */
    public void setEndColor(String endColor) {
        setAttribute("endColor", endColor);
    }

    /**
     * if both startColor and endColor are set then colorStops is ignored
     *
     *
     * @return String
     */
    public String getEndColor()  {
        return getAttributeAsString("endColor");
    }

    /**
     * if both startColor and endColor are set then colorStops is ignored
     *
     * @param startColor startColor Default value is null
     */
    public void setStartColor(String startColor) {
        setAttribute("startColor", startColor);
    }

    /**
     * if both startColor and endColor are set then colorStops is ignored
     *
     *
     * @return String
     */
    public String getStartColor()  {
        return getAttributeAsString("startColor");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}



