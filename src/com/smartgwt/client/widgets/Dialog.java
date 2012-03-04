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
 * Dialogs are a specialized version of {@link com.smartgwt.client.widgets.Window} used for small windows that contain just
 * a text message or a text mesage with some standard buttons. <P> Many typical modal dialogs such as alerts and
 * confirmations are built into the system with convenience APIs - see  say,  warn and  askForValue. <P> Dialogs can be
 * modal or non-modal according to {@link com.smartgwt.client.widgets.Window#getIsModal isModal}. <P> NOTE: If you are
 * building a dialog that will involve more than just buttons and a message, consider starting from the {@link
 * com.smartgwt.client.widgets.Window} class instead, where arbitrary components can be added to the body area via {@link
 * com.smartgwt.client.widgets.Window#addItem Window.addItem}.
 */
public class Dialog extends Window  implements com.smartgwt.client.widgets.events.HasButtonClickHandlers {

    public static Dialog getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (Dialog) obj;
        } else {
            return new Dialog(jsObj);
        }
    }

    public Dialog(){
        scClassName = "Dialog";
    }

    public Dialog(JavaScriptObject jsObj){
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
     * If a toolbar is showing, automatically place keyboard focus in the first button.
     *
     * @param autoFocus autoFocus Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setAutoFocus(Boolean autoFocus)  throws IllegalStateException {
        setAttribute("autoFocus", autoFocus, false);
    }

    /**
     * If a toolbar is showing, automatically place keyboard focus in the first button.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getAutoFocus()  {
        return getAttributeAsBoolean("autoFocus");
    }

    /**
     * 
     *
     * @param defaultWidth defaultWidth Default value is 360
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDefaultWidth(int defaultWidth)  throws IllegalStateException {
        setAttribute("defaultWidth", defaultWidth, false);
    }

    /**
     * 
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getDefaultWidth()  {
        return getAttributeAsInt("defaultWidth");
    }

    /**
     * Icon to show in this dialog - see {@link com.smartgwt.client.widgets.Dialog#getMessage message}.
     *
     * @param icon icon Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setIcon(String icon)  throws IllegalStateException {
        setAttribute("icon", icon, false);
    }

    /**
     * Icon to show in this dialog - see {@link com.smartgwt.client.widgets.Dialog#getMessage message}.
     *
     *
     * @return String
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }

    /**
     * Size of the icon to show in this dialog.
     *
     * @param iconSize iconSize Default value is 32
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setIconSize(int iconSize)  throws IllegalStateException {
        setAttribute("iconSize", iconSize, false);
    }

    /**
     * Size of the icon to show in this dialog.
     *
     *
     * @return int
     */
    public int getIconSize()  {
        return getAttributeAsInt("iconSize");
    }

    /**
     * Message to show in this dialog. <P> If a message is set the primary purpose of the dialog will be assumed to be to show
     * a message with buttons - auto-sizing to the message text will be enabled, and, if {@link
     * com.smartgwt.client.widgets.Dialog#getIcon icon} has also been set, the {@link
     * com.smartgwt.client.widgets.Dialog#getMessageLabel messageLabel} and {@link
     * com.smartgwt.client.widgets.Dialog#getMessageIcon messageIcon} AutoChildren will be created and placed together in the
     * {@link com.smartgwt.client.widgets.Dialog#getMessageStack messageStack} AutoChild, with the toolbar underneath as usual.
     * If any of these behaviors are inconvenient or you want more precise control over a message and some custom widgets,
     * start from the superclass {@link com.smartgwt.client.widgets.Window} instead, and add controls via {@link
     * com.smartgwt.client.widgets.Window#addItem Window.addItem}. <P> The message string may contain "${loadingImage}", if so,
     * the standard loading spinner will appear at that location in the text (see {@link
     * com.smartgwt.client.widgets.Canvas#loadingImageSrc loadingImageSrc}). <P> The message will be styled with the {@link
     * com.smartgwt.client.widgets.Dialog#getMessageStyle messageStyle}.
     *
     * @param message message Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMessage(String message)  throws IllegalStateException {
        setAttribute("message", message, false);
    }

    /**
     * Message to show in this dialog. <P> If a message is set the primary purpose of the dialog will be assumed to be to show
     * a message with buttons - auto-sizing to the message text will be enabled, and, if {@link
     * com.smartgwt.client.widgets.Dialog#getIcon icon} has also been set, the {@link
     * com.smartgwt.client.widgets.Dialog#getMessageLabel messageLabel} and {@link
     * com.smartgwt.client.widgets.Dialog#getMessageIcon messageIcon} AutoChildren will be created and placed together in the
     * {@link com.smartgwt.client.widgets.Dialog#getMessageStack messageStack} AutoChild, with the toolbar underneath as usual.
     * If any of these behaviors are inconvenient or you want more precise control over a message and some custom widgets,
     * start from the superclass {@link com.smartgwt.client.widgets.Window} instead, and add controls via {@link
     * com.smartgwt.client.widgets.Window#addItem Window.addItem}. <P> The message string may contain "${loadingImage}", if so,
     * the standard loading spinner will appear at that location in the text (see {@link
     * com.smartgwt.client.widgets.Canvas#loadingImageSrc loadingImageSrc}). <P> The message will be styled with the {@link
     * com.smartgwt.client.widgets.Dialog#getMessageStyle messageStyle}.
     *
     *
     * @return String
     */
    public String getMessage()  {
        return getAttributeAsString("message");
    }

    /**
     * Whether to show a toolbar of buttons at the bottom of the Dialog.
     *
     * @param showToolbar showToolbar Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowToolbar(Boolean showToolbar) {
        setAttribute("showToolbar", showToolbar, true);
    }

    /**
     * Whether to show a toolbar of buttons at the bottom of the Dialog.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowToolbar()  {
        return getAttributeAsBoolean("showToolbar");
    }

    /**
     * Style of the Dialog background
     *
     * @param styleName styleName Default value is "dialogBackground"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * Style of the Dialog background
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }

    // ********************* Methods ***********************
            
    /**
     * Handle a click on the 'apply' button of this Dialog.   Default implementation is to call <code>saveData()</code>, but
     * NOT close the Dialog.
     */
    public native void applyClick() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.applyClick();
    }-*/;
    /**
     * Add a buttonClick handler.
     * <p>
     * Fires when any button in this Dialog's toolbar is clicked.  Default implementation does nothing.
     *
     * @param handler the buttonClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addButtonClickHandler(com.smartgwt.client.widgets.events.ButtonClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.events.ButtonClickEvent.getType()) == 0) setupButtonClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.events.ButtonClickEvent.getType());
    }

    private native void setupButtonClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({buttonClick:$entry(function(){
                        var param = {"button" : arguments[0], "index" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.events.ButtonClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.buttonClick = $entry(function(){
                   var param = {"button" : arguments[0], "index" : arguments[1]};
                   var event = @com.smartgwt.client.widgets.events.ButtonClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
            
    /**
     * Handle a click on the 'cancel' button of this Dialog. Default implementation is to return null and hide the Dialog.
     * Override to do something else.
     */
    public native void cancelClick() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.cancelClick();
    }-*/;
            
    /**
     * Handles a click on the close button of this window. The default implementation hides the window and returns false to
     * cancel bubbling.  Override this method if you want other actions to be taken.
     */
    public native void closeClick() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.closeClick();
    }-*/;
            
    /**
     * Handle a click on the 'no' button of this Dialog. Default implementation is to return <code>false</code>. Override to do
     * something else.
     */
    public native void noClick() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.noClick();
    }-*/;
            
    /**
     * Handle a click on the 'ok' button of this Dialog. Default implementation is to call <code>saveData()</code>, hide the
     * Dialog, then return <code>true</code>.   Override to do something else.
     */
    public native void okClick() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.okClick();
    }-*/;
            
    /**
     * Method to save this Dialog's data. Called from <code>okClick()</code>,  <code>applyClick()</code>. No default
     * implementation - override to perform some action if required.
     */
    public native void saveData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.saveData();
    }-*/;
            
    /**
     * Handle a click on the 'yes' button of this Dialog. Default implementation is to return <code>true</code>. Override to do
     * something else
     */
    public native void yesClick() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.yesClick();
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
     * @param dialogProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Dialog dialogProperties) /*-{
    	var properties = $wnd.isc.addProperties({},dialogProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.Dialog.addProperties(properties);
    }-*/;
        
    // ***********************************************************        



    /**
     * OK  Button object to fire dialog's "okClick()" method on click.
     */
    public static Button OK = new Button("OK");
    /**
     * APPLY Button object to fire dialog's "applyClick()" method on click.
     */
    public static Button APPLY = new Button("Apply");
    /**
     * YES Button object to fire dialog's "yesClick()" method on click
     */
    public static Button YES = new Button("Yes");
    /**
     * NO  Button object to fire dialog's "noClick()" method on click.
     */
    public static Button NO = new Button("No");
    /**
     * CANCEL  Button object to fire dialog's "cancelClick()" method on click.
     */
    public static Button CANCEL = new Button("Cancel");
    /**
     * DONE  Button object to fire dialog's "doneClick()" method on click.
     */
    public static Button DONE = new Button("Done");

    /**
     * Array of Buttons to show in the {@link com.smartgwt.client.widgets.Dialog#getShowToolbar showToolbar}, if shown.
     * <P> The set of buttons to use is typically set by calling one of the shortcuts.
     *
     * @param toolbarButtons the toolbar buttons
     * @throws IllegalStateException this property cannot be changed after the component has been rendered
     */
    public void setToolbarButtons(Canvas... toolbarButtons) {
        setAttribute("toolbarButtons", replaceButtonsWithDefault(toolbarButtons), false);
    }

    /**
     * Array of Buttons to show in the {@link com.smartgwt.client.widgets.Dialog#getShowToolbar toolbar}, if shown.&#010
     * <P>&#010 The set of buttons to use is typically set by calling one of the shortcuts such as&#010 {@link
     * com.smartgwt.client.util.isc#say isc.say} or {@link com.smartgwt.client.util.isc#confirm isc.confirm}.  A custom set of
     * buttons can be passed to&#010 these shortcuts methods via the "properties" argument, or to a directly created
     * Dialog.&#010 <P>&#010 In both cases, a mixture of {@link com.smartgwt.client.types.DialogButtons built-in buttons},
     * custom buttons,&#010 and other components (such as a {@link com.smartgwt.client.widgets.layout.LayoutSpacer}) can be
     * passed.  Built-in buttons&#010 can be referred to as <code>isc.Dialog.OK</code>, for example:&#010 <pre>&#010
     * isc.Dialog.create({&#010    buttons:[&#010       isc.Dialog.OK, &#010       isc.Dialog.CANCEL, &#010
     * isc.LayoutSpacer.create({width:50}), &#010       { title:"Not now", click:"doSomething()" }&#010    ]&#010 })&#010
     * </pre>&#010 Built-in buttons will call standard methods on the Dialog itself, such as&#010 {@link
     * com.smartgwt.client.widgets.Dialog#cancelClick Dialog.cancelClick}, as explained in the &#010 {@link
     * com.smartgwt.client.types.DialogButtons list of built-in buttons}.
     *
     * @param buttons buttons Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setButtons(Button... buttons)  throws IllegalStateException {
        setAttribute("buttons", replaceButtonsWithDefault(buttons), false);
    }

    /**
    * Style to apply to the message text shown in the center of the dialog
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param messageStyle messageStyle Default value is "normal"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setMessageStyle(String messageStyle)  throws IllegalStateException {
        setAttribute("messageStyle", messageStyle, false);
    }

    private JavaScriptObject[] replaceButtonsWithDefault(Canvas... buttons) {
        JavaScriptObject[] result = new JavaScriptObject[buttons.length];
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i] == Dialog.OK) {
                result[i] = getButton("OK");
            } else if (buttons[i] == Dialog.APPLY) {
                result[i] = getButton("APPLY");
            } else if (buttons[i] == Dialog.CANCEL) {
                result[i] = getButton("CANCEL");
            } else if (buttons[i] == Dialog.DONE) {
                result[i] = getButton("DONE");
            } else if (buttons[i] == Dialog.NO) {
                result[i] = getButton("NO");
            } else if (buttons[i] == Dialog.YES) {
                result[i] = getButton("YES");
            } else {
                result[i] = buttons[i].getOrCreateJsObj();
            }
        }
        return result;
    }
    
    private native JavaScriptObject getButton(String name) /*-{
        return $wnd.isc.Dialog[name];
    }-*/;

}




