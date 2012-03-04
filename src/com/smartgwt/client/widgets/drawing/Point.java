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
 * X/Y position in pixels, specified as an Array with two members, for example: [30, 50]
 */
public class Point extends RefDataClass {

    public static Point getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new Point(jsObj);
    }

    public Point(){
        
    }

    public Point(JavaScriptObject jsObj){
        super(jsObj);
    }

    public Point(int x, int y) {
        setX(x);
		setY(y);
        
    }

    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        



    public JavaScriptObject getAsJSArray() {         
        return JSOHelper.convertToJavaScriptArray(new int[]{getX(),getY()});     
    } 
    
    /*
     * Overriding this method so that it returns an array of int values instead of an
     *  object with 2 values, x and y.
     */
    public JavaScriptObject getJsObj() {
        return this.getAsJSArray();
    }

    /**
     * The x coordinate of this point.
     *
     * @param x x Default value is 0
     */
    private void setX(int x) {
        setAttribute("x", x);
    }

    /**
     * The x coordinate of this point.
     *
     *
     * @return int
     */
    public int getX()  {
        return getAttributeAsInt("x");
    }

    /**
     * The y coordinate of this point.
     *
     * @param y y Default value is 0
     */
    private void setY(int y) {
        setAttribute("y", y);
    }

    /**
     * The y coordinate of this point.
     *
     *
     * @return int
     */
    public int getY()  {
        return getAttributeAsInt("y");
    }

    public static Point[] convertToPointArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new Point[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        Point[] objects = new Point[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            Point obj = (Point) RefDataClass.getRef(componentJS);
            if (obj == null) obj = new Point(componentJS);
            objects[i] = obj;
        }
        return objects;
    }

}






