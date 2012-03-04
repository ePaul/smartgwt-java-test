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
 * Binary data interface for use in DynamicForms. Allows users to select a single file for upload. In read-only mode
 * (canEdit:false) displays the contents of "imageFile" fields. <P> <b>Editable mode</b> <P> See the {@link
 * com.smartgwt.client.docs.Upload Upload Overview} for information on using this control. <P> <b>Read-only mode</b> <P>
 * Displays one of two UIs, according to the value of  {@link
 * com.smartgwt.client.widgets.form.fields.FileItem#getShowFileInline showFileInline}.  If showFileInline is false, this
 * Item displays the View and Download icons and the filename.  Otherwise, it streams the image-file  and displays it
 * inline.
 * @see com.smartgwt.client.docs.Upload Upload overview and related methods
 */
public class FileItem extends CanvasItem {

    public static FileItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new FileItem(jsObj);
    }

    public FileItem(){
        setAttribute("editorType", "FileItem");
    }

    public FileItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public FileItem(String name) {
        setName(name);
        setAttribute("editorType", "FileItem");
    }

    public FileItem(String name, String title) {
        setName(name);
		setTitle(title);
        setAttribute("editorType", "FileItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * Indicates whether to stream the image and display it inline or to display the View and Download icons.
     *
     * @param showFileInline showFileInline Default value is null
     */
    public void setShowFileInline(Boolean showFileInline) {
        setAttribute("showFileInline", showFileInline);
    }

    /**
     * Indicates whether to stream the image and display it inline or to display the View and Download icons.
     *
     *
     * @return Boolean
     */
    public Boolean getShowFileInline()  {
        return getAttributeAsBoolean("showFileInline");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}




