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
 * DrawItem subclass to render embedded images.
 */
public class DrawImage extends DrawItem {

    public static DrawImage getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (DrawImage) obj;
        } else {
            return new DrawImage(jsObj);
        }
    }

    public DrawImage(){
        scClassName = "DrawImage";
    }

    public DrawImage(JavaScriptObject jsObj){
        super(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Height in pixels.
     *
     * @param height height Default value is 16
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setHeight(int height)  throws IllegalStateException {
        setAttribute("height", height, false);
    }

    /**
     * Height in pixels.
     *
     *
     * @return int
     */
    public int getHeight()  {
        return getAttributeAsInt("height");
    }

    /**
     * Left coordinate in pixels relative to the DrawPane, or owning DrawGroup.
     *
     * @param left left Default value is 0
     */
    public void setLeft(int left) {
        setAttribute("left", left, true);
    }

    /**
     * Left coordinate in pixels relative to the DrawPane, or owning DrawGroup.
     *
     *
     * @return int
     */
    public int getLeft()  {
        return getAttributeAsInt("left");
    }

    /**
     * URL to the image file.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the URL of the image displayed.
     *
     * @param src new URL. Default value is "blank.png"
     */
    public void setSrc(String src) {
        setAttribute("src", src, true);
    }

    /**
     * URL to the image file.
     *
     *
     * @return String
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }

    /**
     * Title (tooltip hover text) for this image.
     *
     * @param title title Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setTitle(String title)  throws IllegalStateException {
        setAttribute("title", title, false);
    }

    /**
     * Title (tooltip hover text) for this image.
     *
     *
     * @return String
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    /**
     * Top coordinate in pixels relative to the DrawPane, or owning DrawGroup.
     *
     * @param top top Default value is 0
     */
    public void setTop(int top) {
        setAttribute("top", top, true);
    }

    /**
     * Top coordinate in pixels relative to the DrawPane, or owning DrawGroup.
     *
     *
     * @return int
     */
    public int getTop()  {
        return getAttributeAsInt("top");
    }

    /**
     * Width in pixels.
     *
     * @param width width Default value is 16
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setWidth(int width)  throws IllegalStateException {
        setAttribute("width", width, false);
    }

    /**
     * Width in pixels.
     *
     *
     * @return int
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }

    // ********************* Methods ***********************
            
    /**
     * Move the drawImage by the specified delta
     * @param dX number of pixels to move horizontally
     * @param dY number of pixels to move vertically
     */
    public native void moveBy(int dX, int dY) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveBy(dX, dY);
    }-*/;
            
    /**
     * Move the drawImage to the specified position
     * @param left new left coordinate
     * @param top new top coordinate
     */
    public native void moveTo(int left, int top) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveTo(left, top);
    }-*/;

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}



