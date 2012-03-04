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
 
package com.smartgwt.client.widgets.grid;



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
 * A ListGrid is a {@link com.smartgwt.client.widgets.DataBoundComponent} that displays a list of objects in a grid, where
 * each row represents one object and each cell in the row represents one property.
 */
public class ListGrid extends Canvas  implements DataBoundComponent, com.smartgwt.client.widgets.grid.events.HasHeaderClickHandlers, com.smartgwt.client.widgets.grid.events.HasRecordDropHandlers, com.smartgwt.client.widgets.grid.events.HasRecordExpandHandlers, com.smartgwt.client.widgets.grid.events.HasRecordCollapseHandlers, com.smartgwt.client.widgets.grid.events.HasDataArrivedHandlers, com.smartgwt.client.widgets.grid.events.HasDrawAreaChangedHandlers, com.smartgwt.client.widgets.grid.events.HasFieldStateChangedHandlers, com.smartgwt.client.widgets.grid.events.HasEditCompleteHandlers, com.smartgwt.client.widgets.grid.events.HasEditFailedHandlers, com.smartgwt.client.widgets.grid.events.HasEditorExitHandlers, com.smartgwt.client.widgets.grid.events.HasRowEditorEnterHandlers, com.smartgwt.client.widgets.grid.events.HasRowEditorExitHandlers, com.smartgwt.client.widgets.grid.events.HasEditorEnterHandlers, com.smartgwt.client.widgets.grid.events.HasCellSavedHandlers, com.smartgwt.client.widgets.grid.events.HasCellOutHandlers, com.smartgwt.client.widgets.grid.events.HasCellOverHandlers, com.smartgwt.client.widgets.grid.events.HasCellContextClickHandlers, com.smartgwt.client.widgets.grid.events.HasCellMouseDownHandlers, com.smartgwt.client.widgets.grid.events.HasCellMouseUpHandlers, com.smartgwt.client.widgets.grid.events.HasCellClickHandlers, com.smartgwt.client.widgets.grid.events.HasCellDoubleClickHandlers, com.smartgwt.client.widgets.grid.events.HasRowOutHandlers, com.smartgwt.client.widgets.grid.events.HasRowOverHandlers, com.smartgwt.client.widgets.grid.events.HasRowContextClickHandlers, com.smartgwt.client.widgets.grid.events.HasRowMouseDownHandlers, com.smartgwt.client.widgets.grid.events.HasRowMouseUpHandlers, com.smartgwt.client.widgets.grid.events.HasRecordClickHandlers, com.smartgwt.client.widgets.grid.events.HasRecordDoubleClickHandlers, com.smartgwt.client.widgets.grid.events.HasCellHoverHandlers, com.smartgwt.client.widgets.grid.events.HasRowHoverHandlers, com.smartgwt.client.widgets.grid.events.HasSelectionChangedHandlers, com.smartgwt.client.widgets.grid.events.HasSelectionUpdatedHandlers, com.smartgwt.client.widgets.grid.events.HasHeaderDoubleClickHandlers, com.smartgwt.client.widgets.grid.events.HasFilterEditorSubmitHandlers, com.smartgwt.client.widgets.grid.events.HasGroupByHandlers, com.smartgwt.client.widgets.grid.events.HasViewStateChangedHandlers, com.smartgwt.client.widgets.grid.events.HasBodyKeyPressHandlers {

    public static ListGrid getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (ListGrid) obj;
        } else {
            return new ListGrid(jsObj);
        }
    }

    public ListGrid(){
        setModalEditing(true);scClassName = "ListGrid";
    }

    public ListGrid(JavaScriptObject jsObj){
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
     * For use with {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor}:true, allows simple
     * search expressions to be entered into filter fields, as though {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getAllowExpressions allowExpressions} were true. <P> Can also be enabled or
     * disabled on a field-by-field basis via {@link com.smartgwt.client.widgets.grid.ListGridField#getFilterEditorProperties
     * filterEditorProperties}.
     *
     * @param allowFilterExpressions allowFilterExpressions Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAllowFilterExpressions(Boolean allowFilterExpressions)  throws IllegalStateException {
        setAttribute("allowFilterExpressions", allowFilterExpressions, false);
    }

    /**
     * For use with {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor}:true, allows simple
     * search expressions to be entered into filter fields, as though {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getAllowExpressions allowExpressions} were true. <P> Can also be enabled or
     * disabled on a field-by-field basis via {@link com.smartgwt.client.widgets.grid.ListGridField#getFilterEditorProperties
     * filterEditorProperties}.
     *
     *
     * @return Boolean
     */
    public Boolean getAllowFilterExpressions()  {
        return getAttributeAsBoolean("allowFilterExpressions");
    }

    /**
     * Optional css style to apply to the body if {@link com.smartgwt.client.widgets.grid.ListGrid#getAlternateRecordStyles
     * alternateRecordStyles} is true  for this grid. If unset {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBodyStyleName bodyStyleName} will be used to style the body regardless of
     * the {@link com.smartgwt.client.widgets.grid.ListGrid#getAlternateRecordStyles alternateRecordStyles} setting.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the {@link com.smartgwt.client.widgets.grid.ListGrid#getAlternateBodyStyleName alternateBodyStyleName} for this listGrid.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param alternateBodyStyleName new body style name when showing alternateRecordStyles. Default value is null
     */
    public void setAlternateBodyStyleName(String alternateBodyStyleName) {
        setAttribute("alternateBodyStyleName", alternateBodyStyleName, true);
    }

    /**
     * Optional css style to apply to the body if {@link com.smartgwt.client.widgets.grid.ListGrid#getAlternateRecordStyles
     * alternateRecordStyles} is true  for this grid. If unset {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBodyStyleName bodyStyleName} will be used to style the body regardless of
     * the {@link com.smartgwt.client.widgets.grid.ListGrid#getAlternateRecordStyles alternateRecordStyles} setting.
     *
     *
     * @return String
     */
    public String getAlternateBodyStyleName()  {
        return getAttributeAsString("alternateBodyStyleName");
    }

    /**
     * The number of consecutive rows to draw in the same style before alternating, when alternateRowStyles is true.
     *
     * @param alternateRecordFrequency alternateRecordFrequency Default value is 1
     */
    public void setAlternateRecordFrequency(int alternateRecordFrequency) {
        setAttribute("alternateRecordFrequency", alternateRecordFrequency, true);
    }

    /**
     * The number of consecutive rows to draw in the same style before alternating, when alternateRowStyles is true.
     *
     *
     * @return int
     */
    public int getAlternateRecordFrequency()  {
        return getAttributeAsInt("alternateRecordFrequency");
    }

    /**
     * Whether alternating rows should be drawn in alternating styles, in order to create a "ledger" effect for easier reading.
     *  If enabled, the cell style for alternate rows will have "Dark" appended to it.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getAlternateRecordStyles alternateRecordStyles}
     *
     * @param alternateRecordStyles New value for <code>this.alternateRecordStyles</code>. Default value is false
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_lf_grid_cells" target="examples">Grid cells Example</a>
     */
    public void setAlternateRecordStyles(Boolean alternateRecordStyles) {
        setAttribute("alternateRecordStyles", alternateRecordStyles, true);
    }

    /**
     * Whether alternating rows should be drawn in alternating styles, in order to create a "ledger" effect for easier reading.
     *  If enabled, the cell style for alternate rows will have "Dark" appended to it.
     *
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_lf_grid_cells" target="examples">Grid cells Example</a>
     */
    public Boolean getAlternateRecordStyles()  {
        return getAttributeAsBoolean("alternateRecordStyles");
    }

    /**
     * When this attribute is set, editors will be rendered into every row of the grid rather than showing up in a single
     * record at a time. This attribute is only valid when {@link com.smartgwt.client.widgets.grid.ListGrid#getEditByCell
     * editByCell} is false
     *
     * @param alwaysShowEditors alwaysShowEditors Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setAlwaysShowEditors(Boolean alwaysShowEditors)  throws IllegalStateException {
        setAttribute("alwaysShowEditors", alwaysShowEditors, false);
    }

    /**
     * When this attribute is set, editors will be rendered into every row of the grid rather than showing up in a single
     * record at a time. This attribute is only valid when {@link com.smartgwt.client.widgets.grid.ListGrid#getEditByCell
     * editByCell} is false
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean getAlwaysShowEditors()  {
        return getAttributeAsBoolean("alwaysShowEditors");
    }

    /**
     * When animating folder opening / closing, this property can be set to apply an animated acceleration effect. This allows
     * the animation speed to be "weighted", for example expanding or collapsing at a faster rate toward the beginning of the
     * animation than at the end. <P> For a ListGrid, this property applies when {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy grouping} is enabled.
     *
     * @param animateFolderEffect animateFolderEffect Default value is null
     */
    public void setAnimateFolderEffect(AnimationAcceleration animateFolderEffect) {
        setAttribute("animateFolderEffect", animateFolderEffect == null ? null : animateFolderEffect.getValue(), true);
    }

    /**
     * When animating folder opening / closing, this property can be set to apply an animated acceleration effect. This allows
     * the animation speed to be "weighted", for example expanding or collapsing at a faster rate toward the beginning of the
     * animation than at the end. <P> For a ListGrid, this property applies when {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy grouping} is enabled.
     *
     *
     * @return AnimationAcceleration
     */
    public AnimationAcceleration getAnimateFolderEffect()  {
        return EnumUtil.getEnum(AnimationAcceleration.values(), getAttribute("animateFolderEffect"));
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateFolders animateFolders} is true for this grid, this number
     * can be set to designate the maximum number of rows to animate at a time when opening / closing a folder. <P> For a
     * ListGrid, this property applies when {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy grouping} is
     * enabled.
     *
     * @param animateFolderMaxRows animateFolderMaxRows Default value is null
     */
    public void setAnimateFolderMaxRows(Integer animateFolderMaxRows) {
        setAttribute("animateFolderMaxRows", animateFolderMaxRows, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateFolders animateFolders} is true for this grid, this number
     * can be set to designate the maximum number of rows to animate at a time when opening / closing a folder. <P> For a
     * ListGrid, this property applies when {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy grouping} is
     * enabled.
     *
     *
     * @return Integer
     */
    public Integer getAnimateFolderMaxRows()  {
        return getAttributeAsInt("animateFolderMaxRows");
    }

    /**
     * If true, when folders are opened / closed children will be animated into view. <P> For a ListGrid, this property applies
     * when {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy grouping} is enabled.
     *
     * @param animateFolders animateFolders Default value is true
     */
    public void setAnimateFolders(Boolean animateFolders) {
        setAttribute("animateFolders", animateFolders, true);
    }

    /**
     * If true, when folders are opened / closed children will be animated into view. <P> For a ListGrid, this property applies
     * when {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy grouping} is enabled.
     *
     *
     * @return Boolean
     */
    public Boolean getAnimateFolders()  {
        return getAttributeAsBoolean("animateFolders");
    }

    /**
     * When animating folder opening / closing, this property designates the speed of the animation in pixels shown (or hidden)
     * per second. Takes precedence over the  {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderTime
     * animateFolderTime} property, which allows the developer to specify a duration for the animation rather than a speed. <P>
     * For a ListGrid, this property applies when {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy grouping} is
     * enabled.
     *
     * @param animateFolderSpeed animateFolderSpeed Default value is 3000
     * @see com.smartgwt.client.widgets.grid.ListGrid#setAnimateFolderTime
     */
    public void setAnimateFolderSpeed(int animateFolderSpeed) {
        setAttribute("animateFolderSpeed", animateFolderSpeed, true);
    }

    /**
     * When animating folder opening / closing, this property designates the speed of the animation in pixels shown (or hidden)
     * per second. Takes precedence over the  {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderTime
     * animateFolderTime} property, which allows the developer to specify a duration for the animation rather than a speed. <P>
     * For a ListGrid, this property applies when {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy grouping} is
     * enabled.
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.grid.ListGrid#getAnimateFolderTime
     */
    public int getAnimateFolderSpeed()  {
        return getAttributeAsInt("animateFolderSpeed");
    }

    /**
     * When animating folder opening / closing, if {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderSpeed
     * animateFolderSpeed} is not set, this property designates the duration of the animation in ms. <P> For a ListGrid, this
     * property applies when {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy grouping} is enabled.
     *
     * @param animateFolderTime animateFolderTime Default value is 100
     * @see com.smartgwt.client.widgets.grid.ListGrid#setAnimateFolderSpeed
     */
    public void setAnimateFolderTime(int animateFolderTime) {
        setAttribute("animateFolderTime", animateFolderTime, true);
    }

    /**
     * When animating folder opening / closing, if {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderSpeed
     * animateFolderSpeed} is not set, this property designates the duration of the animation in ms. <P> For a ListGrid, this
     * property applies when {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy grouping} is enabled.
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.grid.ListGrid#getAnimateFolderSpeed
     */
    public int getAnimateFolderTime()  {
        return getAttributeAsInt("animateFolderTime");
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is enabled, should records
     * be animated out of view when they are removed by the user?
     *
     * @param animateRemoveRecord animateRemoveRecord Default value is true
     */
    public void setAnimateRemoveRecord(Boolean animateRemoveRecord) {
        setAttribute("animateRemoveRecord", animateRemoveRecord, true);
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is enabled, should records
     * be animated out of view when they are removed by the user?
     *
     *
     * @return Boolean
     */
    public Boolean getAnimateRemoveRecord()  {
        return getAttributeAsBoolean("animateRemoveRecord");
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord animating record removal}, this property 
     * designates the speed of the animation in pixels per second. Takes precedence over the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveTime animateRemoveTime} property, which allows the developer
     * to specify a duration for the animation rather than a speed.
     *
     * @param animateRemoveSpeed animateRemoveSpeed Default value is 200
     * @see com.smartgwt.client.widgets.grid.ListGrid#setAnimateRemoveRecord
     */
    public void setAnimateRemoveSpeed(int animateRemoveSpeed) {
        setAttribute("animateRemoveSpeed", animateRemoveSpeed, true);
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord animating record removal}, this property 
     * designates the speed of the animation in pixels per second. Takes precedence over the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveTime animateRemoveTime} property, which allows the developer
     * to specify a duration for the animation rather than a speed.
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord
     */
    public int getAnimateRemoveSpeed()  {
        return getAttributeAsInt("animateRemoveSpeed");
    }

    /**
     * When animating record removal  {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord (see
     * animateRemoveRecord)}, if  {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveSpeed animateRemoveSpeed} is
     * not set, this property designates the duration of the animation in ms.
     *
     * @param animateRemoveTime animateRemoveTime Default value is 100
     * @see com.smartgwt.client.widgets.grid.ListGrid#setAnimateRemoveRecord
     */
    public void setAnimateRemoveTime(int animateRemoveTime) {
        setAttribute("animateRemoveTime", animateRemoveTime, true);
    }

    /**
     * When animating record removal  {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord (see
     * animateRemoveRecord)}, if  {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveSpeed animateRemoveSpeed} is
     * not set, this property designates the duration of the animation in ms.
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord
     */
    public int getAnimateRemoveTime()  {
        return getAttributeAsInt("animateRemoveTime");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRollOverCanvas showRollOverCanvas} is <code>true</code>
     * setting this property to true ensures that when the rollOver canvas is displayed it animates into view via an {@link
     * com.smartgwt.client.widgets.Canvas#animateShow Canvas.animateShow}. Note that the animation effect may be customized via
     * the standard {@link com.smartgwt.client.widgets.Canvas#getAnimateShowEffect animateShowEffect}, {@link
     * com.smartgwt.client.widgets.Canvas#getAnimateShowTime animateShowTime} and  {@link
     * com.smartgwt.client.widgets.Canvas#getAnimateShowAcceleration animateShowAcceleration}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param animateRollOver animateRollOver Default value is false
     */
    public void setAnimateRollOver(Boolean animateRollOver) {
        setAttribute("animateRollOver", animateRollOver, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRollOverCanvas showRollOverCanvas} is <code>true</code>
     * setting this property to true ensures that when the rollOver canvas is displayed it animates into view via an {@link
     * com.smartgwt.client.widgets.Canvas#animateShow Canvas.animateShow}. Note that the animation effect may be customized via
     * the standard {@link com.smartgwt.client.widgets.Canvas#getAnimateShowEffect animateShowEffect}, {@link
     * com.smartgwt.client.widgets.Canvas#getAnimateShowTime animateShowTime} and  {@link
     * com.smartgwt.client.widgets.Canvas#getAnimateShowAcceleration animateShowAcceleration}.
     *
     *
     * @return Boolean
     */
    public Boolean getAnimateRollOver()  {
        return getAttributeAsBoolean("animateRollOver");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRollOverCanvas showRollOverCanvas} is <code>true</code>
     * setting this property to true ensures that when the rollUnder canvas is displayed it animates into view via an {@link
     * com.smartgwt.client.widgets.Canvas#animateShow Canvas.animateShow}. Note that the animation effect may be customized via
     * the standard {@link com.smartgwt.client.widgets.Canvas#getAnimateShowEffect animateShowEffect}, {@link
     * com.smartgwt.client.widgets.Canvas#getAnimateShowTime animateShowTime} and  {@link
     * com.smartgwt.client.widgets.Canvas#getAnimateShowAcceleration animateShowAcceleration}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param animateRollUnder animateRollUnder Default value is false
     */
    public void setAnimateRollUnder(Boolean animateRollUnder) {
        setAttribute("animateRollUnder", animateRollUnder, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRollOverCanvas showRollOverCanvas} is <code>true</code>
     * setting this property to true ensures that when the rollUnder canvas is displayed it animates into view via an {@link
     * com.smartgwt.client.widgets.Canvas#animateShow Canvas.animateShow}. Note that the animation effect may be customized via
     * the standard {@link com.smartgwt.client.widgets.Canvas#getAnimateShowEffect animateShowEffect}, {@link
     * com.smartgwt.client.widgets.Canvas#getAnimateShowTime animateShowTime} and  {@link
     * com.smartgwt.client.widgets.Canvas#getAnimateShowAcceleration animateShowAcceleration}.
     *
     *
     * @return Boolean
     */
    public Boolean getAnimateRollUnder()  {
        return getAttributeAsBoolean("animateRollUnder");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowSelectionCanvas showSelectionCanvas} is <code>true</code>
     * setting this property to true ensures that when the selection canvas is displayed it animates into view via an {@link
     * com.smartgwt.client.widgets.Canvas#animateShow Canvas.animateShow}.  Note that the animation effect may be customized
     * via the standard {@link com.smartgwt.client.widgets.Canvas#getAnimateShowEffect animateShowEffect}, {@link
     * com.smartgwt.client.widgets.Canvas#getAnimateShowTime animateShowTime} and  {@link
     * com.smartgwt.client.widgets.Canvas#getAnimateShowAcceleration animateShowAcceleration}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param animateSelection animateSelection Default value is false
     */
    public void setAnimateSelection(Boolean animateSelection) {
        setAttribute("animateSelection", animateSelection, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowSelectionCanvas showSelectionCanvas} is <code>true</code>
     * setting this property to true ensures that when the selection canvas is displayed it animates into view via an {@link
     * com.smartgwt.client.widgets.Canvas#animateShow Canvas.animateShow}.  Note that the animation effect may be customized
     * via the standard {@link com.smartgwt.client.widgets.Canvas#getAnimateShowEffect animateShowEffect}, {@link
     * com.smartgwt.client.widgets.Canvas#getAnimateShowTime animateShowTime} and  {@link
     * com.smartgwt.client.widgets.Canvas#getAnimateShowAcceleration animateShowAcceleration}.
     *
     *
     * @return Boolean
     */
    public Boolean getAnimateSelection()  {
        return getAttributeAsBoolean("animateSelection");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowSelectionCanvas showSelectionCanvas} is <code>true</code>
     * setting this property to true ensures that when the selectionUnder canvas is displayed it animates into view via an
     * {@link com.smartgwt.client.widgets.Canvas#animateShow Canvas.animateShow}. Note that the animation effect may be
     * customized via the standard {@link com.smartgwt.client.widgets.Canvas#getAnimateShowEffect animateShowEffect}, {@link
     * com.smartgwt.client.widgets.Canvas#getAnimateShowTime animateShowTime} and  {@link
     * com.smartgwt.client.widgets.Canvas#getAnimateShowAcceleration animateShowAcceleration}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param animateSelectionUnder animateSelectionUnder Default value is false
     */
    public void setAnimateSelectionUnder(Boolean animateSelectionUnder) {
        setAttribute("animateSelectionUnder", animateSelectionUnder, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowSelectionCanvas showSelectionCanvas} is <code>true</code>
     * setting this property to true ensures that when the selectionUnder canvas is displayed it animates into view via an
     * {@link com.smartgwt.client.widgets.Canvas#animateShow Canvas.animateShow}. Note that the animation effect may be
     * customized via the standard {@link com.smartgwt.client.widgets.Canvas#getAnimateShowEffect animateShowEffect}, {@link
     * com.smartgwt.client.widgets.Canvas#getAnimateShowTime animateShowTime} and  {@link
     * com.smartgwt.client.widgets.Canvas#getAnimateShowAcceleration animateShowAcceleration}.
     *
     *
     * @return Boolean
     */
    public Boolean getAnimateSelectionUnder()  {
        return getAttributeAsBoolean("animateSelectionUnder");
    }

    /**
     * Action to perform when the listGrid has keyboard focus (but not editing focus) and a user presses the up or down arrow
     * key. Possible values are: <ul> <li><code>select</code> : select the next row in the list (calls <code>recordClick</code>
     * handler)</li> <li><code>focus</code> : move focus to the next row in the list without changing the selection</li>
     * <li><code>activate</code> : select and activate the next row in the list (calls  <code>recordDoubleClick</code>
     * handler)</li> <li><code>none</code> : no action</li> </ul>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param arrowKeyAction arrowKeyAction Default value is "select"
     */
    public void setArrowKeyAction(String arrowKeyAction) {
        setAttribute("arrowKeyAction", arrowKeyAction, true);
    }

    /**
     * Action to perform when the listGrid has keyboard focus (but not editing focus) and a user presses the up or down arrow
     * key. Possible values are: <ul> <li><code>select</code> : select the next row in the list (calls <code>recordClick</code>
     * handler)</li> <li><code>focus</code> : move focus to the next row in the list without changing the selection</li>
     * <li><code>activate</code> : select and activate the next row in the list (calls  <code>recordDoubleClick</code>
     * handler)</li> <li><code>none</code> : no action</li> </ul>
     *
     *
     * @return String
     */
    public String getArrowKeyAction()  {
        return getAttributeAsString("arrowKeyAction");
    }

    /**
     * If true, for fields where {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} is
     * specified, a valueMap will be automatically created by making a {@link com.smartgwt.client.data.DataSource#fetchData
     * DataSource.fetchData} call against the specified dataSource and extracting a valueMap from the returned records based on
     * the displayField and valueField. <P> If set to false, valueMaps will not be automatically fetched.  In this case,
     * setting field.optionDataSource is effectively a shortcut for setting optionDataSource on the editor via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getEditorProperties editorProperties}. <P> Can also be disabled on a
     * per-field basis with {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap}.
     *
     * @param autoFetchDisplayMap autoFetchDisplayMap Default value is true
     * @see com.smartgwt.client.widgets.grid.ListGridField#setAutoFetchDisplayMap
     * @see com.smartgwt.client.widgets.grid.ListGridField#setOptionDataSource
     */
    public void setAutoFetchDisplayMap(Boolean autoFetchDisplayMap) {
        setAttribute("autoFetchDisplayMap", autoFetchDisplayMap, true);
    }

    /**
     * If true, for fields where {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} is
     * specified, a valueMap will be automatically created by making a {@link com.smartgwt.client.data.DataSource#fetchData
     * DataSource.fetchData} call against the specified dataSource and extracting a valueMap from the returned records based on
     * the displayField and valueField. <P> If set to false, valueMaps will not be automatically fetched.  In this case,
     * setting field.optionDataSource is effectively a shortcut for setting optionDataSource on the editor via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getEditorProperties editorProperties}. <P> Can also be disabled on a
     * per-field basis with {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap}.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap
     * @see com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource
     */
    public Boolean getAutoFetchDisplayMap()  {
        return getAttributeAsBoolean("autoFetchDisplayMap");
    }

    /**
     * When this grid is initially filtered via {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchData
     * autoFetchData}, or filtered by the user  via the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor
     * filterEditor}, this attribute can be used to set the <code>textMatchStyle</code> on the dsRequest passed to
     * <code>fetchData()</code>.
     *
     * @param autoFetchTextMatchStyle autoFetchTextMatchStyle Default value is "substring"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAutoFetchTextMatchStyle(TextMatchStyle autoFetchTextMatchStyle)  throws IllegalStateException {
        setAttribute("autoFetchTextMatchStyle", autoFetchTextMatchStyle == null ? null : autoFetchTextMatchStyle.getValue(), false);
    }

    /**
     * When this grid is initially filtered via {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchData
     * autoFetchData}, or filtered by the user  via the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor
     * filterEditor}, this attribute can be used to set the <code>textMatchStyle</code> on the dsRequest passed to
     * <code>fetchData()</code>.
     *
     *
     * @return TextMatchStyle
     */
    public TextMatchStyle getAutoFetchTextMatchStyle()  {
        return EnumUtil.getEnum(TextMatchStyle.values(), getAttribute("autoFetchTextMatchStyle"));
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid,  and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAutoFitFields canAutoFitFields} is true, this
     * attribute will be shown as the menu  item title for an item to perform a one-time autoFit of all visible fields via the
     * {@link com.smartgwt.client.widgets.grid.ListGrid#autoFitField ListGrid.autoFitField} method.
     *
     * @param autoFitAllText autoFitAllText Default value is "Auto Fit All Columns"
     */
    public void setAutoFitAllText(String autoFitAllText) {
        setAttribute("autoFitAllText", autoFitAllText, true);
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid,  and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAutoFitFields canAutoFitFields} is true, this
     * attribute will be shown as the menu  item title for an item to perform a one-time autoFit of all visible fields via the
     * {@link com.smartgwt.client.widgets.grid.ListGrid#autoFitField ListGrid.autoFitField} method.
     *
     *
     * @return String
     */
    public String getAutoFitAllText()  {
        return getAttributeAsString("autoFitAllText");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths autoFitFieldWidths} is enabled and the
     * calculated field sizes are wide enough that horizontal scrolling would be introduced, this attribute may be set to an
     * array of fieldNames, causing those fields to be clipped rather than forcing horizontal scrollbars to appear. <P> Note:
     * If any {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen columns} are included in this list they
     * will not be clipped.
     *
     * @param autoFitClipFields autoFitClipFields Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAutoFitClipFields(String... autoFitClipFields)  throws IllegalStateException {
        setAttribute("autoFitClipFields", autoFitClipFields, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths autoFitFieldWidths} is enabled and the
     * calculated field sizes are wide enough that horizontal scrolling would be introduced, this attribute may be set to an
     * array of fieldNames, causing those fields to be clipped rather than forcing horizontal scrollbars to appear. <P> Note:
     * If any {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen columns} are included in this list they
     * will not be clipped.
     *
     *
     * @return String
     */
    public String[] getAutoFitClipFields()  {
        return getAttributeAsStringArray("autoFitClipFields");
    }

    /**
     * Should this ListGrid automatically expand to accommodate the size of records and fields? <P> Valid settings are
     * <ul><li><code>"vertical"</code>: expand vertically to accommodate records.</li>     <li><code>"horizontal"</code>:
     * expand horizontally to accommodate fields.</li>     <li><code>"both"</code>: expand horizontally and vertically to
     * accommodate content.</li> </ul> How far the ListGrid will expand may be limited via the following properties: {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxHeight autoFitMaxHeight}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxRecords autoFitMaxRecords}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxWidth autoFitMaxWidth}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns autoFitMaxColumns}. <P> Note that this property causes
     * the grid as a whole to expand to fit records or fields. To have the fields or records themselves expand to fit cell
     * contents, see  {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths autoFitFieldWidths} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFixedRecordHeights fixedRecordHeights}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData}.
     *
     * @param autoFitData One of <code>"vertical"</code>, <code>"horizontal"</code>  or <code>"both"</code>. To disable auto fit behavior, pass in
     * <code>null</code>.. Default value is null
     */
    public void setAutoFitData(Autofit autoFitData) {
        setAttribute("autoFitData", autoFitData == null ? null : autoFitData.getValue(), true);
    }

    /**
     * Should this ListGrid automatically expand to accommodate the size of records and fields? <P> Valid settings are
     * <ul><li><code>"vertical"</code>: expand vertically to accommodate records.</li>     <li><code>"horizontal"</code>:
     * expand horizontally to accommodate fields.</li>     <li><code>"both"</code>: expand horizontally and vertically to
     * accommodate content.</li> </ul> How far the ListGrid will expand may be limited via the following properties: {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxHeight autoFitMaxHeight}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxRecords autoFitMaxRecords}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxWidth autoFitMaxWidth}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns autoFitMaxColumns}. <P> Note that this property causes
     * the grid as a whole to expand to fit records or fields. To have the fields or records themselves expand to fit cell
     * contents, see  {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths autoFitFieldWidths} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFixedRecordHeights fixedRecordHeights}.
     *
     *
     * @return Autofit
     */
    public Autofit getAutoFitData()  {
        return EnumUtil.getEnum(Autofit.values(), getAttribute("autoFitData"));
    }

    /**
     * The field to expand if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths autoFitFieldWidths} and 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldsFillViewport autoFitFieldsFillViewport} are enabled and
     * auto-fitting will not fill all available horizontal space. <P> If unset, will default to the text field with the longest
     * {@link com.smartgwt.client.data.DataSourceField#getLength length} if length is set, otherwise, the first text field with
     * no width specified. <P> Note that expanding {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen
     * columns} is not supported.
     *
     * @param autoFitExpandField autoFitExpandField Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAutoFitExpandField(String autoFitExpandField)  throws IllegalStateException {
        setAttribute("autoFitExpandField", autoFitExpandField, false);
    }

    /**
     * The field to expand if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths autoFitFieldWidths} and 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldsFillViewport autoFitFieldsFillViewport} are enabled and
     * auto-fitting will not fill all available horizontal space. <P> If unset, will default to the text field with the longest
     * {@link com.smartgwt.client.data.DataSourceField#getLength length} if length is set, otherwise, the first text field with
     * no width specified. <P> Note that expanding {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen
     * columns} is not supported.
     *
     *
     * @return String
     */
    public String getAutoFitExpandField()  {
        return getAttributeAsString("autoFitExpandField");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"vertical"</code> or
     * <code>"both"</code>  this property specifies the number of additional records for which the grid  will expand. If more
     * records are present, scrolling will be introduced to reach them as normal.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitExtraRecords autoFitExtraRecords}.
     *
     * @param autoFitExtraRecords Number of extra rows beyond the data-size we'll expand to  accommodate if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData auto fit} is enabled vertically.. Default value is null
     */
    public void setAutoFitExtraRecords(Integer autoFitExtraRecords) {
        setAttribute("autoFitExtraRecords", autoFitExtraRecords, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"vertical"</code> or
     * <code>"both"</code>  this property specifies the number of additional records for which the grid  will expand. If more
     * records are present, scrolling will be introduced to reach them as normal.
     *
     *
     * @return Integer
     */
    public Integer getAutoFitExtraRecords()  {
        return getAttributeAsInt("autoFitExtraRecords");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths autoFitFieldWidths} is enabled, and extra
     * space is available after autofitting all fields, should the grid automatically expand one field to fill the extra space.
     * <P> When enabled, the field to expand may be specified via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitExpandField autoFitExpandField}. <P> Note this logic will not expand
     * a {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen column}.
     *
     * @param autoFitFieldsFillViewport autoFitFieldsFillViewport Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAutoFitFieldsFillViewport(Boolean autoFitFieldsFillViewport)  throws IllegalStateException {
        setAttribute("autoFitFieldsFillViewport", autoFitFieldsFillViewport, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths autoFitFieldWidths} is enabled, and extra
     * space is available after autofitting all fields, should the grid automatically expand one field to fill the extra space.
     * <P> When enabled, the field to expand may be specified via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitExpandField autoFitExpandField}. <P> Note this logic will not expand
     * a {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen column}.
     *
     *
     * @return Boolean
     */
    public Boolean getAutoFitFieldsFillViewport()  {
        return getAttributeAsBoolean("autoFitFieldsFillViewport");
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid,  and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAutoFitFields canAutoFitFields} is true, this
     * attribute will be shown as the menu  item title for an item to perform a one-time autoFit of the field to its title or
     * content via a call to {@link com.smartgwt.client.widgets.grid.ListGrid#autoFitField ListGrid.autoFitField}.
     *
     * @param autoFitFieldText autoFitFieldText Default value is "Auto Fit"
     */
    public void setAutoFitFieldText(String autoFitFieldText) {
        setAttribute("autoFitFieldText", autoFitFieldText, true);
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid,  and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAutoFitFields canAutoFitFields} is true, this
     * attribute will be shown as the menu  item title for an item to perform a one-time autoFit of the field to its title or
     * content via a call to {@link com.smartgwt.client.widgets.grid.ListGrid#autoFitField ListGrid.autoFitField}.
     *
     *
     * @return String
     */
    public String getAutoFitFieldText()  {
        return getAttributeAsString("autoFitFieldText");
    }

    /**
     * Enables autofitting of fields to values or titles. This property may be overridden on a per-field basis via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidth autoFitWidth}. <P> The {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitWidthApproach autoFitWidthApproach} controls whether fitting is to
     * values, titles  or both. This property may also be overridden on a per field basis. <P> If  width is also set on the
     * field, it will be taken as a minimum width. {@link com.smartgwt.client.widgets.grid.ListGrid#getMinFieldWith
     * minFieldWith} will also be respected. <P> Autofitting will be performed: <ul>  <li> whenever the dataset is completely
     * changed or rows are added or removed  <li> whenever a field which is autofitting is changed  <li> on a manual call to
     * {@link com.smartgwt.client.widgets.grid.ListGrid#autoFitField ListGrid.autoFitField} or       {@link
     * com.smartgwt.client.widgets.grid.ListGrid#autoFitFields ListGrid.autoFitFields} </ul> Autofitting behavior continues
     * until the user resizes the field manually, at which point it stops. The user can also perform a one-time auto-fit of
     * fields via the header context menu if {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAutoFitFields
     * canAutoFitFields} is enabled. <P> When autofitting to column values, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDefaultFieldWidth ListGrid.getDefaultFieldWidth} will be called to
     * determine the space required for a field's values. This method uses values from the rendered set of rows to calculate
     * the required column width. The values used not match the complete set of data for the grid when rendering rows
     * incrementally. See {@link com.smartgwt.client.widgets.grid.ListGrid#getShowAllRecords showAllRecords} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio}) to control incremental rendering of rows.
     * <P> Note that for <code>icon</code> type fields, the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitIconFields autoFitIconFields}  property setting may turn on
     * auto-fit-width behavior for specific fields by default, even if <code>autoFitFieldWidths</code> is false for the grid as
     * a whole. <P> By default the  <P> Using this feature has a performance penalty roughly comparable to always rendering 
     * one additional field per field where autofitting is enabled.  Specifically, enabling it for all fields would be
     * comparable to <i>both</i> doubling the number of fields <i>and</i> disabling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowAllColumns horizontal incremental rendering}. In a grid where only half
     * the fields are normally visible and hence only half are normally rendered, this would be roughly 4 times slower
     * overall.<br> This performance penalty is a result of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDefaultFieldWidth ListGrid.getDefaultFieldWidth} having to render out the
     * data set offscreen and measure the rendered content - it does not apply for cases where this method can return a simple
     * fixed values (as with icon fields). <P> Which fields are currently autofitting is saved as part of the  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getViewState view state} of the ListGrid.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths autoFitFieldWidths}. Modifies the default auto-fit-width behavior for fields in this grid. Note that this may be overridden at the field level via  {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidth autoFitWidth}.
     *
     * @param autoFitFieldWidths New value for autoFitFieldWidths. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAutoFitFieldWidths(Boolean autoFitFieldWidths)  throws IllegalStateException {
        setAttribute("autoFitFieldWidths", autoFitFieldWidths, false);
    }

    /**
     * Enables autofitting of fields to values or titles. This property may be overridden on a per-field basis via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidth autoFitWidth}. <P> The {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitWidthApproach autoFitWidthApproach} controls whether fitting is to
     * values, titles  or both. This property may also be overridden on a per field basis. <P> If  width is also set on the
     * field, it will be taken as a minimum width. {@link com.smartgwt.client.widgets.grid.ListGrid#getMinFieldWith
     * minFieldWith} will also be respected. <P> Autofitting will be performed: <ul>  <li> whenever the dataset is completely
     * changed or rows are added or removed  <li> whenever a field which is autofitting is changed  <li> on a manual call to
     * {@link com.smartgwt.client.widgets.grid.ListGrid#autoFitField ListGrid.autoFitField} or       {@link
     * com.smartgwt.client.widgets.grid.ListGrid#autoFitFields ListGrid.autoFitFields} </ul> Autofitting behavior continues
     * until the user resizes the field manually, at which point it stops. The user can also perform a one-time auto-fit of
     * fields via the header context menu if {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAutoFitFields
     * canAutoFitFields} is enabled. <P> When autofitting to column values, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDefaultFieldWidth ListGrid.getDefaultFieldWidth} will be called to
     * determine the space required for a field's values. This method uses values from the rendered set of rows to calculate
     * the required column width. The values used not match the complete set of data for the grid when rendering rows
     * incrementally. See {@link com.smartgwt.client.widgets.grid.ListGrid#getShowAllRecords showAllRecords} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio}) to control incremental rendering of rows.
     * <P> Note that for <code>icon</code> type fields, the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitIconFields autoFitIconFields}  property setting may turn on
     * auto-fit-width behavior for specific fields by default, even if <code>autoFitFieldWidths</code> is false for the grid as
     * a whole. <P> By default the  <P> Using this feature has a performance penalty roughly comparable to always rendering 
     * one additional field per field where autofitting is enabled.  Specifically, enabling it for all fields would be
     * comparable to <i>both</i> doubling the number of fields <i>and</i> disabling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowAllColumns horizontal incremental rendering}. In a grid where only half
     * the fields are normally visible and hence only half are normally rendered, this would be roughly 4 times slower
     * overall.<br> This performance penalty is a result of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDefaultFieldWidth ListGrid.getDefaultFieldWidth} having to render out the
     * data set offscreen and measure the rendered content - it does not apply for cases where this method can return a simple
     * fixed values (as with icon fields). <P> Which fields are currently autofitting is saved as part of the  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getViewState view state} of the ListGrid.
     *
     *
     * @return Boolean
     */
    public Boolean getAutoFitFieldWidths()  {
        return getAttributeAsBoolean("autoFitFieldWidths");
    }

    /**
     * Smart GWT listGrids have special logic to automatically size fields that are displayed as an icon - that is fields with 
     * {@link com.smartgwt.client.types.ListGridFieldType type:"icon"}, fields displaying only {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getShowValueIconOnly value icons}, and boolean fields (which are rendered
     * as a checkmark type icon by default. <P> This attribute controls this behavior - governing whether icon fields should be
     * sized to fit their content (icon), title, or whether to disable this  behavior. Setting this value to
     * <code>"title"</code> or <code>"iconWidth"</code> will cause {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidth autoFitWidth} to be enabled by default for all  icon
     * fields with the {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidthApproach autoFitWidthApproach} set
     * to  <code>"value"</code> or <code>"both"</code> as appropriate. Note that the width required for the icons is calculated
     * by {@link com.smartgwt.client.widgets.grid.ListGrid#getDefaultFieldWidth ListGrid.getDefaultFieldWidth} which performs a
     * simple calculation based on the specified icon width for these types of fields. <P> This setting governs default
     * behavior for icon fields - for specific fields within a grid, this default behavior can be overridden by setting an
     * explicit {@link com.smartgwt.client.widgets.grid.ListGridField#getWidth width} or explicitly enabling {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidth autoFitWidth} and setting {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidthApproach autoFitWidthApproach} on the field in question.
     *
     * @param autoFitIconFields autoFitIconFields Default value is "title"
     * @see com.smartgwt.client.widgets.grid.ListGrid#setAutoFitFieldWidths
     */
    public void setAutoFitIconFields(AutoFitIconFieldType autoFitIconFields) {
        setAttribute("autoFitIconFields", autoFitIconFields == null ? null : autoFitIconFields.getValue(), true);
    }

    /**
     * Smart GWT listGrids have special logic to automatically size fields that are displayed as an icon - that is fields with 
     * {@link com.smartgwt.client.types.ListGridFieldType type:"icon"}, fields displaying only {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getShowValueIconOnly value icons}, and boolean fields (which are rendered
     * as a checkmark type icon by default. <P> This attribute controls this behavior - governing whether icon fields should be
     * sized to fit their content (icon), title, or whether to disable this  behavior. Setting this value to
     * <code>"title"</code> or <code>"iconWidth"</code> will cause {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidth autoFitWidth} to be enabled by default for all  icon
     * fields with the {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidthApproach autoFitWidthApproach} set
     * to  <code>"value"</code> or <code>"both"</code> as appropriate. Note that the width required for the icons is calculated
     * by {@link com.smartgwt.client.widgets.grid.ListGrid#getDefaultFieldWidth ListGrid.getDefaultFieldWidth} which performs a
     * simple calculation based on the specified icon width for these types of fields. <P> This setting governs default
     * behavior for icon fields - for specific fields within a grid, this default behavior can be overridden by setting an
     * explicit {@link com.smartgwt.client.widgets.grid.ListGridField#getWidth width} or explicitly enabling {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidth autoFitWidth} and setting {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidthApproach autoFitWidthApproach} on the field in question.
     *
     *
     * @return AutoFitIconFieldType
     * @see com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths
     */
    public AutoFitIconFieldType getAutoFitIconFields()  {
        return EnumUtil.getEnum(AutoFitIconFieldType.values(), getAttribute("autoFitIconFields"));
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"horizontal"</code> or
     * <code>"both"</code> this property provides the maximum number of columns for which the ListGrid will expand. If more
     * columns are present, scrolling will be introduced to reach them as normal. If unset the ListGrid will expand to
     * accommodate as many columns as are defined for the grid.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns autoFitMaxColumns}.
     *
     * @param autoFitMaxColumns Maximum number of fields we'll expand to accommodate if  {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData
     * auto fit} is enabled horizontally.. Default value is 50
     */
    public void setAutoFitMaxColumns(int autoFitMaxColumns) {
        setAttribute("autoFitMaxColumns", autoFitMaxColumns, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"horizontal"</code> or
     * <code>"both"</code> this property provides the maximum number of columns for which the ListGrid will expand. If more
     * columns are present, scrolling will be introduced to reach them as normal. If unset the ListGrid will expand to
     * accommodate as many columns as are defined for the grid.
     *
     *
     * @return int
     */
    public int getAutoFitMaxColumns()  {
        return getAttributeAsInt("autoFitMaxColumns");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"vertical"</code> or
     * <code>"both"</code> this property provides an upper limit on how far the ListGrid will expand vertically to accommodate
     * its content. If content exceeds this height, scrollbars will be introduced as usual.   In addition to this property,
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxRecords autoFitMaxRecords} allows you to limit vertical
     * expansion based on the number of rows to be rendered.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxHeight autoFitMaxHeight}.
     *
     * @param autoFitMaxHeight Maximum height in px we'll expand to accommodate if  {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData
     * auto fit} is enabled vertically.. Default value is null
     */
    public void setAutoFitMaxHeight(Integer autoFitMaxHeight) {
        setAttribute("autoFitMaxHeight", autoFitMaxHeight, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"vertical"</code> or
     * <code>"both"</code> this property provides an upper limit on how far the ListGrid will expand vertically to accommodate
     * its content. If content exceeds this height, scrollbars will be introduced as usual.   In addition to this property,
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxRecords autoFitMaxRecords} allows you to limit vertical
     * expansion based on the number of rows to be rendered.
     *
     *
     * @return Integer
     */
    public Integer getAutoFitMaxHeight()  {
        return getAttributeAsInt("autoFitMaxHeight");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"vertical"</code> or
     * <code>"both"</code> this property provides the maximum number of records for which the ListGrid will expand. If more
     * records are present, scrolling will be introduced to reach them as normal. If unset, by default the ListGrid will expand
     * to accommodate as many records as are present.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxRecords autoFitMaxRecords}.
     *
     * @param autoFitMaxRecords Maximum number of rows we'll expand to accommodate if  {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData
     * auto fit} is enabled vertically.. Default value is 50
     */
    public void setAutoFitMaxRecords(int autoFitMaxRecords) {
        setAttribute("autoFitMaxRecords", autoFitMaxRecords, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"vertical"</code> or
     * <code>"both"</code> this property provides the maximum number of records for which the ListGrid will expand. If more
     * records are present, scrolling will be introduced to reach them as normal. If unset, by default the ListGrid will expand
     * to accommodate as many records as are present.
     *
     *
     * @return int
     */
    public int getAutoFitMaxRecords()  {
        return getAttributeAsInt("autoFitMaxRecords");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"horizontal"</code> or
     * <code>"both"</code> this property provides an upper limit on how far the ListGrid will expand horizontally to
     * accommodate its content.  If content exceeds this width, scrollbars will be introduced as usual.   In addition to this
     * property, {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns autoFitMaxColumns} allows you to limit 
     * horizontal expansion based on the number of columns to be rendered.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxWidth autoFitMaxWidth}.
     *
     * @param autoFitMaxWidth Width in px we'll expand to accommodate if  {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData auto fit} is
     * enabled horizontally.. Default value is null
     */
    public void setAutoFitMaxWidth(Integer autoFitMaxWidth) {
        setAttribute("autoFitMaxWidth", autoFitMaxWidth, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"horizontal"</code> or
     * <code>"both"</code> this property provides an upper limit on how far the ListGrid will expand horizontally to
     * accommodate its content.  If content exceeds this width, scrollbars will be introduced as usual.   In addition to this
     * property, {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns autoFitMaxColumns} allows you to limit 
     * horizontal expansion based on the number of columns to be rendered.
     *
     *
     * @return Integer
     */
    public Integer getAutoFitMaxWidth()  {
        return getAttributeAsInt("autoFitMaxWidth");
    }

    /**
     * When a user requests column autofitting via the  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderContextMenuItems header contextmenu} or via a  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderAutoFitEvent mouse gesture}, what autofit approach is used.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for the {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitWidthApproach autoFitWidthApproach}.
     *
     * @param autoFitWidthApproach new AutoFitWidth approach. Default value is "value"
     */
    public void setAutoFitWidthApproach(AutoFitWidthApproach autoFitWidthApproach) {
        setAttribute("autoFitWidthApproach", autoFitWidthApproach == null ? null : autoFitWidthApproach.getValue(), true);
    }

    /**
     * When a user requests column autofitting via the  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderContextMenuItems header contextmenu} or via a  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderAutoFitEvent mouse gesture}, what autofit approach is used.
     *
     *
     * @return AutoFitWidthApproach
     */
    public AutoFitWidthApproach getAutoFitWidthApproach()  {
        return EnumUtil.getEnum(AutoFitWidthApproach.values(), getAttribute("autoFitWidthApproach"));
    }

    /**
     * If this ListGrid is editable, should edits be saved out when the user finishes editing a row (or a cell if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell saveByCell} is true). <P> The default of <code>true</code>
     * indicates that edits will be {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell automatically saved} as the
     * user navigates through the grid and/or ${isc.DocUtils.linkForRef('type:EnterKeyEditAction','hits 'Enter'')} to end
     * editing.  See the {@link com.smartgwt.client.docs.Editing Grid Editing} overview for details.  <P> Setting
     * <code>autoSaveEdits</code> false creates a "mass update" / "mass delete" interaction where edits will be retained for
     * all edited cells (across rows if appropriate) until {@link com.smartgwt.client.widgets.grid.ListGrid#saveEdits
     * ListGrid.saveEdits} is called to save a particular row, or {@link com.smartgwt.client.widgets.grid.ListGrid#saveAllEdits
     * ListGrid.saveAllEdits} is called to save all changes in a batch.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param autoSaveEdits autoSaveEdits Default value is true
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setAutoSaveEdits(Boolean autoSaveEdits) {
        setAttribute("autoSaveEdits", autoSaveEdits, true);
    }

    /**
     * If this ListGrid is editable, should edits be saved out when the user finishes editing a row (or a cell if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell saveByCell} is true). <P> The default of <code>true</code>
     * indicates that edits will be {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell automatically saved} as the
     * user navigates through the grid and/or ${isc.DocUtils.linkForRef('type:EnterKeyEditAction','hits 'Enter'')} to end
     * editing.  See the {@link com.smartgwt.client.docs.Editing Grid Editing} overview for details.  <P> Setting
     * <code>autoSaveEdits</code> false creates a "mass update" / "mass delete" interaction where edits will be retained for
     * all edited cells (across rows if appropriate) until {@link com.smartgwt.client.widgets.grid.ListGrid#saveEdits
     * ListGrid.saveEdits} is called to save a particular row, or {@link com.smartgwt.client.widgets.grid.ListGrid#saveAllEdits
     * ListGrid.saveAllEdits} is called to save all changes in a batch.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean getAutoSaveEdits()  {
        return getAttributeAsBoolean("autoSaveEdits");
    }

    /**
     * Has no effect unless {@link com.smartgwt.client.widgets.grid.ListGrid#getShowBackgroundComponent
     * showBackgroundComponent} is <code>true</code>. <P> Canvas created and embedded in the body behind a given record.   When
     * {@link com.smartgwt.client.widgets.grid.ListGridRecord#getBackgroundComponent backgroundComponent} is set, this
     * autoChild canvas  will be constructed (if listGridRecord.backgroundComponent is not already a Canvas) and  it's
     * properties combined with those of listGridRecord.backgroundComponent and then  displayed behind a specific record in the
     * page's z-order, meaning  it will only be visible if the cell styling is transparent.
     *
     * @param backgroundComponent backgroundComponent Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setBackgroundComponent(Canvas backgroundComponent)  throws IllegalStateException {
        setAttribute("backgroundComponent", backgroundComponent == null ? null : backgroundComponent.getOrCreateJsObj(), false);
    }

    /**
     * Has no effect unless {@link com.smartgwt.client.widgets.grid.ListGrid#getShowBackgroundComponent
     * showBackgroundComponent} is <code>true</code>. <P> Canvas created and embedded in the body behind a given record.   When
     * {@link com.smartgwt.client.widgets.grid.ListGridRecord#getBackgroundComponent backgroundComponent} is set, this
     * autoChild canvas  will be constructed (if listGridRecord.backgroundComponent is not already a Canvas) and  it's
     * properties combined with those of listGridRecord.backgroundComponent and then  displayed behind a specific record in the
     * page's z-order, meaning  it will only be visible if the cell styling is transparent.
     *
     *
     * @return Canvas
     */
    public Canvas getBackgroundComponent()  {
        return Canvas.getOrCreateRef(getAttributeAsJavaScriptObject("backgroundComponent"));
    }

    /**
     * {@link com.smartgwt.client.grid.GridRenderer#getBaseStyle base cell style} for this listGrid. If this property is unset,
     * base style may be derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getNormalBaseStyle normalBaseStyle} or
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getTallBaseStyle tallBaseStyle} as described in {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle ListGrid.getBaseStyle}.
     *
     * @param baseStyle baseStyle Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setBaseStyle(String baseStyle)  throws IllegalStateException {
        setAttribute("baseStyle", baseStyle, false);
    }

    /**
     * {@link com.smartgwt.client.grid.GridRenderer#getBaseStyle base cell style} for this listGrid. If this property is unset,
     * base style may be derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getNormalBaseStyle normalBaseStyle} or
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getTallBaseStyle tallBaseStyle} as described in {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle ListGrid.getBaseStyle}.
     *
     *
     * @return Return the base stylename for this cell.  Has the following implementation by default: <ul> <li>If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getEditFailedBaseStyle this.editFailedBaseStyle} is defined, and the     cell
     * is displaying a validation error return this value.</li> <li>If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getEditPendingBaseStyle this.editFailedPendingStyle} is defined, and     the
     * cell is displaying an edit value that has not yet been saved (see      {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits}) return this value.</li> <li>Otherwise return
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordBaseStyleProperty record[listGrid.recordBaseStyleProperty]},  
     * if defined, otherwise {@link com.smartgwt.client.widgets.grid.ListGridField#getBaseStyle field.baseStyle}.</li> </ul> If
     * no custom style is found for the cell as described above, the default baseStyle will be returned. If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle} is specified this will be used. Otherwise for grids
     * showing fixed height rows which match {@link com.smartgwt.client.widgets.grid.ListGrid#getNormalCellHeight
     * normalCellHeight}  {@link com.smartgwt.client.widgets.grid.ListGrid#getNormalBaseStyle normalBaseStyle} will be used.
     * For grids with variable, or modified cell heights, {@link com.smartgwt.client.widgets.grid.ListGrid#getTallBaseStyle
     * tallBaseStyle} will be used.  <P> Note also that enabling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFastCellUpdates fastCellUpdates} will cause the <code>tallBaseStyle</code>
     * to be used rather than {@link com.smartgwt.client.widgets.grid.ListGrid#getNormalBaseStyle normalBaseStyle}.
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }

    /**
     * Background color applied to the ListGrid body (that is, the area of the grid where data values are rendered).<br> Note
     * that this will typically not be visible to the user unless there are few enough rows that there is visible space in the
     * body below the last row. To style data cells, override {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle
     * baseStyle} instead.
     *
     * @param bodyBackgroundColor bodyBackgroundColor Default value is "white"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setBodyBackgroundColor(String bodyBackgroundColor) {
        setAttribute("bodyBackgroundColor", bodyBackgroundColor, true);
    }

    /**
     * Background color applied to the ListGrid body (that is, the area of the grid where data values are rendered).<br> Note
     * that this will typically not be visible to the user unless there are few enough rows that there is visible space in the
     * body below the last row. To style data cells, override {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle
     * baseStyle} instead.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBodyBackgroundColor()  {
        return getAttributeAsString("bodyBackgroundColor");
    }

    /**
     * Overflow setting for the "body", that is, the area of the grid where data values are rendered. <P> By setting both the
     * grid itself and the body to overflow:visible, it is possible to "auto-fit" to the rendered height or width of the rows. 
     * Note that in this case <code>grid.width</code> and <code>grid.height</code> act as minimums.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the {@link com.smartgwt.client.widgets.grid.ListGrid#getBodyOverflow bodyOverflow} for this listGrid.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param bodyOverflow new overflow setting for the body. Default value is Canvas.AUTO
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_autofit_rows" target="examples">Rows Example</a>
     */
    public void setBodyOverflow(Overflow bodyOverflow) {
        setAttribute("bodyOverflow", bodyOverflow == null ? null : bodyOverflow.getValue(), true);
    }

    /**
     * Overflow setting for the "body", that is, the area of the grid where data values are rendered. <P> By setting both the
     * grid itself and the body to overflow:visible, it is possible to "auto-fit" to the rendered height or width of the rows. 
     * Note that in this case <code>grid.width</code> and <code>grid.height</code> act as minimums.
     *
     *
     * @return Overflow
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_autofit_rows" target="examples">Rows Example</a>
     */
    public Overflow getBodyOverflow()  {
        return EnumUtil.getEnum(Overflow.values(), getAttribute("bodyOverflow"));
    }

    /**
     * CSS style used for the body of this grid.  If applying a background-color to the body via a CSS style applied using this
     * property, be sure to set  {@link com.smartgwt.client.widgets.grid.ListGrid#getBodyBackgroundColor bodyBackgroundColor}
     * to <code>null</code>.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the {@link com.smartgwt.client.widgets.grid.ListGrid#getBodyStyleName bodyStyleName} for this listGrid.
     *
     * @param bodyStyleName new body style name. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setBodyStyleName(String bodyStyleName) {
        setAttribute("bodyStyleName", bodyStyleName, true);
    }

    /**
     * CSS style used for the body of this grid.  If applying a background-color to the body via a CSS style applied using this
     * property, be sure to set  {@link com.smartgwt.client.widgets.grid.ListGrid#getBodyBackgroundColor bodyBackgroundColor}
     * to <code>null</code>.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBodyStyleName()  {
        return getAttributeAsString("bodyStyleName");
    }

    /**
     * Image to display for a false value in a boolean field. Default <code>null</code> value means no image will be displayed
     * <P> To turn this off explicitly set {@link com.smartgwt.client.widgets.grid.ListGridField#getSuppressValueIcon
     * suppressValueIcon} to true <P> If this, {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage
     * booleanTrueImage} and {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanPartialImage booleanPartialImage} are
     * undefined, this will be set to {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getUncheckedImage
     * uncheckedImage}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param booleanFalseImage booleanFalseImage Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setBooleanTrueImage
     * @see com.smartgwt.client.widgets.grid.ListGrid#setBooleanPartialImage
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setBooleanFalseImage(String booleanFalseImage) {
        setAttribute("booleanFalseImage", booleanFalseImage, true);
    }

    /**
     * Image to display for a false value in a boolean field. Default <code>null</code> value means no image will be displayed
     * <P> To turn this off explicitly set {@link com.smartgwt.client.widgets.grid.ListGridField#getSuppressValueIcon
     * suppressValueIcon} to true <P> If this, {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage
     * booleanTrueImage} and {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanPartialImage booleanPartialImage} are
     * undefined, this will be set to {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getUncheckedImage
     * uncheckedImage}.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage
     * @see com.smartgwt.client.widgets.grid.ListGrid#getBooleanPartialImage
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public String getBooleanFalseImage()  {
        return getAttributeAsString("booleanFalseImage");
    }

    /**
     * Height for the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanPartialImage booleanPartialImage}. Note: If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} is unset, the {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage checkedImage} will be used to indicate a true value
     * in a boolean field. In this case this property is ignored in favor of {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getValueIconHeight valueIconHeight}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param booleanImageHeight booleanImageHeight Default value is 16
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setBooleanImageHeight(int booleanImageHeight) {
        setAttribute("booleanImageHeight", booleanImageHeight, true);
    }

    /**
     * Height for the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanPartialImage booleanPartialImage}. Note: If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} is unset, the {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage checkedImage} will be used to indicate a true value
     * in a boolean field. In this case this property is ignored in favor of {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getValueIconHeight valueIconHeight}.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public int getBooleanImageHeight()  {
        return getAttributeAsInt("booleanImageHeight");
    }

    /**
     * Width for the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanPartialImage booleanPartialImage}. Note: If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} is unset, the {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage checkedImage} will be used to indicate a true value
     * in a boolean field. In this case this property is ignored in favor of {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getValueIconWidth valueIconWidth}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param booleanImageWidth booleanImageWidth Default value is 16
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setBooleanImageWidth(int booleanImageWidth) {
        setAttribute("booleanImageWidth", booleanImageWidth, true);
    }

    /**
     * Width for the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanPartialImage booleanPartialImage}. Note: If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} is unset, the {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage checkedImage} will be used to indicate a true value
     * in a boolean field. In this case this property is ignored in favor of {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getValueIconWidth valueIconWidth}.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public int getBooleanImageWidth()  {
        return getAttributeAsInt("booleanImageWidth");
    }

    /**
     * Image to display for a partially true value in a boolean field (typically selection). <P> To turn this off explicitly
     * set {@link com.smartgwt.client.widgets.grid.ListGridField#getSuppressValueIcon suppressValueIcon} to true. <P> If this,
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage} are undefined, this will be set to
     * {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getPartialSelectedImage partialSelectedImage}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param booleanPartialImage booleanPartialImage Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setBooleanTrueImage
     * @see com.smartgwt.client.widgets.grid.ListGrid#setBooleanFalseImage
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setBooleanPartialImage(String booleanPartialImage) {
        setAttribute("booleanPartialImage", booleanPartialImage, true);
    }

    /**
     * Image to display for a partially true value in a boolean field (typically selection). <P> To turn this off explicitly
     * set {@link com.smartgwt.client.widgets.grid.ListGridField#getSuppressValueIcon suppressValueIcon} to true. <P> If this,
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage} are undefined, this will be set to
     * {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getPartialSelectedImage partialSelectedImage}.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage
     * @see com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public String getBooleanPartialImage()  {
        return getAttributeAsString("booleanPartialImage");
    }

    /**
     * Image to display for a true value in a boolean field. <P> To turn this off explicitly set {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getSuppressValueIcon suppressValueIcon} to true. <P> If this, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanPartialImage booleanPartialImage} are undefined, this will be set to
     * {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage checkedImage}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param booleanTrueImage booleanTrueImage Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setBooleanFalseImage
     * @see com.smartgwt.client.widgets.grid.ListGrid#setBooleanPartialImage
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setBooleanTrueImage(String booleanTrueImage) {
        setAttribute("booleanTrueImage", booleanTrueImage, true);
    }

    /**
     * Image to display for a true value in a boolean field. <P> To turn this off explicitly set {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getSuppressValueIcon suppressValueIcon} to true. <P> If this, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanPartialImage booleanPartialImage} are undefined, this will be set to
     * {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage checkedImage}.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage
     * @see com.smartgwt.client.widgets.grid.ListGrid#getBooleanPartialImage
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public String getBooleanTrueImage()  {
        return getAttributeAsString("booleanTrueImage");
    }

    /**
     * Indicates whether records can be dropped into this listGrid.
     *
     * @param canAcceptDroppedRecords canAcceptDroppedRecords Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGridRecord#setCanDrag
     * @see com.smartgwt.client.widgets.grid.ListGridRecord#setCanAcceptDrop
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_move_list" target="examples">Drag list (move) Example</a>
     */
    public void setCanAcceptDroppedRecords(Boolean canAcceptDroppedRecords) {
        setAttribute("canAcceptDroppedRecords", canAcceptDroppedRecords, true);
    }

    /**
     * Indicates whether records can be dropped into this listGrid.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGridRecord#getCanDrag
     * @see com.smartgwt.client.widgets.grid.ListGridRecord#getCanAcceptDrop
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_move_list" target="examples">Drag list (move) Example</a>
     */
    public Boolean getCanAcceptDroppedRecords()  {
        return getAttributeAsBoolean("canAcceptDroppedRecords");
    }

    /**
     * Whether the user able to autofit specific columns to their data and/or title via a context menu item or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderAutoFitEvent headerAutoFitEvent}. <P> Autofitting can also be
     * programmatically enabled by setting  autoFitWidth.
     *
     * @param canAutoFitFields canAutoFitFields Default value is true
     */
    public void setCanAutoFitFields(Boolean canAutoFitFields) {
        setAttribute("canAutoFitFields", canAutoFitFields, true);
    }

    /**
     * Whether the user able to autofit specific columns to their data and/or title via a context menu item or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderAutoFitEvent headerAutoFitEvent}. <P> Autofitting can also be
     * programmatically enabled by setting  autoFitWidth.
     *
     *
     * @return Boolean
     */
    public Boolean getCanAutoFitFields()  {
        return getAttributeAsBoolean("canAutoFitFields");
    }

    /**
     * If this is an editable listGrid, and <code>this.confirmCancelEditing</code> is true this property is used as the message
     * to display in the confirmation dismissal prompt.
     *
     * @param cancelEditingConfirmationMessage cancelEditingConfirmationMessage Default value is Cancelling this edit will discard unsaved changes for this record. Continue?
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setCancelEditingConfirmationMessage(String cancelEditingConfirmationMessage) {
        setAttribute("cancelEditingConfirmationMessage", cancelEditingConfirmationMessage, true);
    }

    /**
     * If this is an editable listGrid, and <code>this.confirmCancelEditing</code> is true this property is used as the message
     * to display in the confirmation dismissal prompt.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public String getCancelEditingConfirmationMessage()  {
        return getAttributeAsString("cancelEditingConfirmationMessage");
    }

    /**
     * Can a group be collapsed/expanded? When true a collapse/expand icon is shown ({@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGroupIcon groupIcon}) and clicking the icon or double-clicking the group
     * title will collapse or expand the group. When false the group icon is not shown and double-clicking on the title does
     * not change group state. Additionally {@link com.smartgwt.client.types.GroupStartOpen groupStartOpen} is  initialized to
     * "all".
     *
     * @param canCollapseGroup canCollapseGroup Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public void setCanCollapseGroup(Boolean canCollapseGroup)  throws IllegalStateException {
        setAttribute("canCollapseGroup", canCollapseGroup, false);
    }

    /**
     * Can a group be collapsed/expanded? When true a collapse/expand icon is shown ({@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGroupIcon groupIcon}) and clicking the icon or double-clicking the group
     * title will collapse or expand the group. When false the group icon is not shown and double-clicking on the title does
     * not change group state. Additionally {@link com.smartgwt.client.types.GroupStartOpen groupStartOpen} is  initialized to
     * "all".
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public Boolean getCanCollapseGroup()  {
        return getAttributeAsBoolean("canCollapseGroup");
    }

    /**
     * Indicates whether records can be dragged from this listGrid and dropped elsewhere.
     *
     * @param canDragRecordsOut canDragRecordsOut Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGridRecord#setCanDrag
     * @see com.smartgwt.client.widgets.grid.ListGridRecord#setCanAcceptDrop
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_move_list" target="examples">Drag list (move) Example</a>
     */
    public void setCanDragRecordsOut(Boolean canDragRecordsOut) {
        setAttribute("canDragRecordsOut", canDragRecordsOut, true);
    }

    /**
     * Indicates whether records can be dragged from this listGrid and dropped elsewhere.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGridRecord#getCanDrag
     * @see com.smartgwt.client.widgets.grid.ListGridRecord#getCanAcceptDrop
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_move_list" target="examples">Drag list (move) Example</a>
     */
    public Boolean getCanDragRecordsOut()  {
        return getAttributeAsBoolean("canDragRecordsOut");
    }

    /**
     * If this property is true, users can drag the mouse to select several rows or cells.  This is mutually exclusive with
     * rearranging rows or cells by dragging.
     *
     * @param canDragSelect canDragSelect Default value is false
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_select_list" target="examples">Drag list (select) Example</a>
     */
    public void setCanDragSelect(Boolean canDragSelect) {
        setAttribute("canDragSelect", canDragSelect, true);
    }

    /**
     * If this property is true, users can drag the mouse to select several rows or cells.  This is mutually exclusive with
     * rearranging rows or cells by dragging.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_select_list" target="examples">Drag list (select) Example</a>
     */
    public Boolean getCanDragSelect()  {
        return getAttributeAsBoolean("canDragSelect");
    }

    /**
     * If this property is true, users can drag the mouse to select text within grid rows. This is mutually exclusive with 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getCanDragReorder rearranging rows or cells by dragging}, and with 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getCanDragSelect drag selection of rows}.
     *
     * @param canDragSelectText canDragSelectText Default value is false
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public void setCanDragSelectText(Boolean canDragSelectText) {
        setAttribute("canDragSelectText", canDragSelectText, true);
    }

    /**
     * If this property is true, users can drag the mouse to select text within grid rows. This is mutually exclusive with 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getCanDragReorder rearranging rows or cells by dragging}, and with 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getCanDragSelect drag selection of rows}.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public Boolean getCanDragSelectText()  {
        return getAttributeAsBoolean("canDragSelectText");
    }

    /**
     * Can the user edit cells in this listGrid? Can be set for the listGrid, and overridden for       individual fields.<br>  
     * If 'canEdit' is false at the listGrid level, fields can never be edited - in this case      the canEdit property on
     * individual fields will be ignored.<br>      If 'canEdit' is set to true at the listGrid level, setting the 'canEdit'
     * property to      false at the field level will prevent the field from being edited inline.<br>      If 'canEdit' is not
     * set at the listGrid level, setting 'canEdit' to true at the field       level enables the field to be edited inline.
     *
     * @param canEdit canEdit Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#startEditing
     * @see com.smartgwt.client.widgets.grid.ListGridField#setCanEdit
     * @see com.smartgwt.client.widgets.grid.ListGrid#setRecordEditProperty
     * @see com.smartgwt.client.widgets.grid.ListGrid#canEditCell
     * @see com.smartgwt.client.widgets.grid.ListGrid#setFields
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_editing_row" target="examples">Edit by row Example</a>
     */
    public void setCanEdit(Boolean canEdit) {
        setAttribute("canEdit", canEdit, true);
    }

    /**
     * Can the user edit cells in this listGrid? Can be set for the listGrid, and overridden for       individual fields.<br>  
     * If 'canEdit' is false at the listGrid level, fields can never be edited - in this case      the canEdit property on
     * individual fields will be ignored.<br>      If 'canEdit' is set to true at the listGrid level, setting the 'canEdit'
     * property to      false at the field level will prevent the field from being edited inline.<br>      If 'canEdit' is not
     * set at the listGrid level, setting 'canEdit' to true at the field       level enables the field to be edited inline.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#startEditing
     * @see com.smartgwt.client.widgets.grid.ListGridField#getCanEdit
     * @see com.smartgwt.client.widgets.grid.ListGrid#getRecordEditProperty
     * @see com.smartgwt.client.widgets.grid.ListGrid#canEditCell
     * @see com.smartgwt.client.widgets.grid.ListGrid#getFields
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_editing_row" target="examples">Edit by row Example</a>
     */
    public Boolean getCanEdit()  {
        return getAttributeAsBoolean("canEdit");
    }

    /**
     * If this component is bound to a dataSource, this attribute may be specified to customize what fields from the dataSource
     * may be edited by default. For example the {@link com.smartgwt.client.widgets.form.SearchForm} class has this attribute
     * set to <code>"canFilter"</code> which allows search forms to edit dataSource fields marked as <code>canEdit:false</code>
     * (but not those marked as <code>canFilter:false</code>). <P> Note that if <code>canEdit</code> is explicitly specified on
     * a field in  the {@link com.smartgwt.client.widgets.DataBoundComponent#getFields fields} array, that property will be
     * respected in preference to  the canEditAttribute value. (See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit}, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCanEdit canEdit}). Also note that individual dataBoundComponents may
     * have additional logic around whether a field can be edited - for example {@link
     * com.smartgwt.client.widgets.grid.ListGrid#canEditCell ListGrid.canEditCell} may be overridden.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canEditFieldAttribute canEditFieldAttribute Default value is "canEdit"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanEditFieldAttribute(String canEditFieldAttribute)  throws IllegalStateException {
        setAttribute("canEditFieldAttribute", canEditFieldAttribute, false);
    }

    /**
     * If this component is bound to a dataSource, this attribute may be specified to customize what fields from the dataSource
     * may be edited by default. For example the {@link com.smartgwt.client.widgets.form.SearchForm} class has this attribute
     * set to <code>"canFilter"</code> which allows search forms to edit dataSource fields marked as <code>canEdit:false</code>
     * (but not those marked as <code>canFilter:false</code>). <P> Note that if <code>canEdit</code> is explicitly specified on
     * a field in  the {@link com.smartgwt.client.widgets.DataBoundComponent#getFields fields} array, that property will be
     * respected in preference to  the canEditAttribute value. (See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit}, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCanEdit canEdit}). Also note that individual dataBoundComponents may
     * have additional logic around whether a field can be edited - for example {@link
     * com.smartgwt.client.widgets.grid.ListGrid#canEditCell ListGrid.canEditCell} may be overridden.
     *
     *
     * @return String
     */
    public String getCanEditFieldAttribute()  {
        return getAttributeAsString("canEditFieldAttribute");
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is true, this property
     * indicates whether multiple records can be expanded simultaneously.  If set to false, expanding a record will
     * automatically collapse any record which is already expanded.  The default value is  <code>true</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canExpandMultipleRecords canExpandMultipleRecords Default value is true
     */
    public void setCanExpandMultipleRecords(Boolean canExpandMultipleRecords) {
        setAttribute("canExpandMultipleRecords", canExpandMultipleRecords, true);
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is true, this property
     * indicates whether multiple records can be expanded simultaneously.  If set to false, expanding a record will
     * automatically collapse any record which is already expanded.  The default value is  <code>true</code>.
     *
     *
     * @return Boolean
     */
    public Boolean getCanExpandMultipleRecords()  {
        return getAttributeAsBoolean("canExpandMultipleRecords");
    }

    /**
     * Property name on a record that will be checked to determine whether a record can be expanded.
     *
     * @param canExpandRecordProperty canExpandRecordProperty Default value is "canExpand"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.grid.ListGridRecord#setCanExpand
     */
    public void setCanExpandRecordProperty(String canExpandRecordProperty)  throws IllegalStateException {
        setAttribute("canExpandRecordProperty", canExpandRecordProperty, false);
    }

    /**
     * Property name on a record that will be checked to determine whether a record can be expanded.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGridRecord#getCanExpand
     */
    public String getCanExpandRecordProperty()  {
        return getAttributeAsString("canExpandRecordProperty");
    }

    /**
     * When set to true, shows an additional field at the beginning of the field-list  (respecting RTL) to allow users to
     * expand and collapse individual records. See {@link com.smartgwt.client.widgets.grid.ListGrid#expandRecord
     * ListGrid.expandRecord} and {@link com.smartgwt.client.widgets.grid.ListGrid#getExpansionMode expansionMode} for details
     * on record expansion. <P> If expanded records will be variable height, you should switch on {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getVirtualScrolling virtualScrolling}. <P> Note that expanded records are not
     * currently supported in conjunction  with {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen fields}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canExpandRecords new value for listGrid.canExpandRecords.. Default value is false
     */
    public void setCanExpandRecords(Boolean canExpandRecords) {
        setAttribute("canExpandRecords", canExpandRecords, true);
    }

    /**
     * When set to true, shows an additional field at the beginning of the field-list  (respecting RTL) to allow users to
     * expand and collapse individual records. See {@link com.smartgwt.client.widgets.grid.ListGrid#expandRecord
     * ListGrid.expandRecord} and {@link com.smartgwt.client.widgets.grid.ListGrid#getExpansionMode expansionMode} for details
     * on record expansion. <P> If expanded records will be variable height, you should switch on {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getVirtualScrolling virtualScrolling}. <P> Note that expanded records are not
     * currently supported in conjunction  with {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen fields}.
     *
     *
     * @return Boolean
     */
    public Boolean getCanExpandRecords()  {
        return getAttributeAsBoolean("canExpandRecords");
    }

    /**
     * Whether an interface should be shown to allow user is allowed to dynamically "freeze" or "unfreeze" columns with respect
     * to horizontally scrolling. If unset, this property defaults to <code>true</code> unless:<ul> <li>{@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFixedRecordHeights this.fixedRecordHeights} is <code>false</code></li>
     * <li>{@link com.smartgwt.client.widgets.grid.ListGrid#getBodyOverflow this.bodyOverflow} is <code>"visible"</code></li>
     * <li>{@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData this.autoFitData} is set to
     * <code>"horizontal"</code> or  <code>"both"</code></li> <li>Any field has overflow set to
     * <code>"visible"</code></li></ul> <P> Note that the <code>canFreezeFields</code> setting enables or disables the user
     * interface for freezing and unfreezing fields only.  Fields can be programmatically frozen via setting {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getFrozen field.frozen} to true when the grid is created, or dynamically
     * frozen and unfrozen via {@link com.smartgwt.client.widgets.grid.ListGrid#freezeField ListGrid.freezeField} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#unfreezeField ListGrid.unfreezeField}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter method for {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields}
     *
     * @param canFreezeFields New value for <code>listGrid.canFreezeFields</code>. Default value is null
     * @see com.smartgwt.client.docs.FrozenFields FrozenFields overview and related methods
     */
    public void setCanFreezeFields(Boolean canFreezeFields) {
        setAttribute("canFreezeFields", canFreezeFields, true);
    }

    /**
     * Whether an interface should be shown to allow user is allowed to dynamically "freeze" or "unfreeze" columns with respect
     * to horizontally scrolling. If unset, this property defaults to <code>true</code> unless:<ul> <li>{@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFixedRecordHeights this.fixedRecordHeights} is <code>false</code></li>
     * <li>{@link com.smartgwt.client.widgets.grid.ListGrid#getBodyOverflow this.bodyOverflow} is <code>"visible"</code></li>
     * <li>{@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData this.autoFitData} is set to
     * <code>"horizontal"</code> or  <code>"both"</code></li> <li>Any field has overflow set to
     * <code>"visible"</code></li></ul> <P> Note that the <code>canFreezeFields</code> setting enables or disables the user
     * interface for freezing and unfreezing fields only.  Fields can be programmatically frozen via setting {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getFrozen field.frozen} to true when the grid is created, or dynamically
     * frozen and unfrozen via {@link com.smartgwt.client.widgets.grid.ListGrid#freezeField ListGrid.freezeField} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#unfreezeField ListGrid.unfreezeField}.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.FrozenFields FrozenFields overview and related methods
     */
    public Boolean getCanFreezeFields()  {
        return getAttributeAsBoolean("canFreezeFields");
    }

    /**
     * If false, grouping via context menu will be disabled.
     *
     * @param canGroupBy canGroupBy Default value is true
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public void setCanGroupBy(Boolean canGroupBy) {
        setAttribute("canGroupBy", canGroupBy, true);
    }

    /**
     * If false, grouping via context menu will be disabled.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public Boolean getCanGroupBy()  {
        return getAttributeAsBoolean("canGroupBy");
    }

    /**
     * If true, cellHover and rowHover events will fire when the user leaves the mouse over a  row / cell.
     *
     * @param canHover canHover Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setShowHover
     * @see com.smartgwt.client.widgets.grid.ListGridField#setShowHover
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_value_hover" target="examples">Value hover tips Example</a>
     */
    public void setCanHover(Boolean canHover) {
        setAttribute("canHover", canHover, true);
    }

    /**
     * If true, cellHover and rowHover events will fire when the user leaves the mouse over a  row / cell.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#getShowHover
     * @see com.smartgwt.client.widgets.grid.ListGridField#getShowHover
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_value_hover" target="examples">Value hover tips Example</a>
     */
    public Boolean getCanHover()  {
        return getAttributeAsBoolean("canHover");
    }

    /**
     * When true, indicates that this ListGrid supports sorting on multiple fields.  Note that even when set to true,
     * multi-field sorting may not be available if the grid is databound and the  {@link com.smartgwt.client.data.DataSource}
     * doesn't support it, or if sorting for a field is  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCanSortClientOnly client-only} but not all data is available.
     *
     * @param canMultiSort canMultiSort Default value is true
     */
    public void setCanMultiSort(Boolean canMultiSort) {
        setAttribute("canMultiSort", canMultiSort, true);
    }

    /**
     * When true, indicates that this ListGrid supports sorting on multiple fields.  Note that even when set to true,
     * multi-field sorting may not be available if the grid is databound and the  {@link com.smartgwt.client.data.DataSource}
     * doesn't support it, or if sorting for a field is  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCanSortClientOnly client-only} but not all data is available.
     *
     *
     * @return Boolean
     */
    public Boolean getCanMultiSort()  {
        return getAttributeAsBoolean("canMultiSort");
    }

    /**
     * Indicates whether the field picker item and submenu should be present in the header context menu. This menu allows the
     * user to hide visible fields and show hidden fields. By default only fields explicitly included in the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFields fields} array will be available in this menu, unless {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanPickOmittedFields canPickOmittedFields} is set to true for a databound
     * grid.
     *
     * @param canPickFields canPickFields Default value is true
     */
    public void setCanPickFields(Boolean canPickFields) {
        setAttribute("canPickFields", canPickFields, true);
    }

    /**
     * Indicates whether the field picker item and submenu should be present in the header context menu. This menu allows the
     * user to hide visible fields and show hidden fields. By default only fields explicitly included in the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFields fields} array will be available in this menu, unless {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanPickOmittedFields canPickOmittedFields} is set to true for a databound
     * grid.
     *
     *
     * @return Boolean
     */
    public Boolean getCanPickFields()  {
        return getAttributeAsBoolean("canPickFields");
    }

    /**
     * If this grid has a specified {@link com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource}, and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getUseAllDataSourceFields useAllDataSourceFields} is false, setting this
     * property to true will cause all dataSource fields not included in the specified set of fields to show up in the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanPickFields field picker menu item}. <P> Has no effect if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFields fields} is unset (as in this case all dataSource fields will be
     * displayed by default), or if {@link com.smartgwt.client.widgets.grid.ListGrid#getCanPickFields canPickFields} is false.
     *
     * @param canPickOmittedFields canPickOmittedFields Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanPickOmittedFields(Boolean canPickOmittedFields)  throws IllegalStateException {
        setAttribute("canPickOmittedFields", canPickOmittedFields, false);
    }

    /**
     * If this grid has a specified {@link com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource}, and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getUseAllDataSourceFields useAllDataSourceFields} is false, setting this
     * property to true will cause all dataSource fields not included in the specified set of fields to show up in the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanPickFields field picker menu item}. <P> Has no effect if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFields fields} is unset (as in this case all dataSource fields will be
     * displayed by default), or if {@link com.smartgwt.client.widgets.grid.ListGrid#getCanPickFields canPickFields} is false.
     *
     *
     * @return Boolean
     */
    public Boolean getCanPickOmittedFields()  {
        return getAttributeAsBoolean("canPickOmittedFields");
    }

    /**
     * If set, provide UI for the user to remove records from the grid. This is achieved by rendering an additional field in
     * the listGrid which, when clicked, will call {@link com.smartgwt.client.widgets.grid.ListGrid#removeRecordClick
     * ListGrid.removeRecordClick} which removes the row from the data set (or if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDeferRemoval deferRemoval} is true changes the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#markRecordRemoved ListGrid.markRecordRemoved} status for the record). <P> If
     * deferring removal, the record will appear marked with the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRemovedCSSText removedCSSText}  until the removal is committed via a call
     * to {@link com.smartgwt.client.widgets.grid.ListGrid#saveEdits ListGrid.saveEdits}.  Otherwise, the record will disappear
     * from view. If {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord animateRemoveRecord} is true,  the
     * removed record will appear to shrink out of view when it is removed. <P> By default the field will display the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRemoveIcon removeIcon} next to each record, and will be rendered as the
     * leftmost column. Two mechanisms exist to further modify this field: <ul> <li>To change the position of the remove-field,
     * include an explicitly specified field with     the attribute {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIsRemoveField isRemoveField:true} set. This will then     be used as
     * the remove field instead of adding a field to the beginning of the set of     columns.</li> <li>Additional direct
     * configuration of the remove field may be achieved by modifying     {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRemoveFieldProperties removeFieldProperties}.</li> </ul> If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDeferRemoval deferRemoval} is true, when a record is marked as removed, the
     * the icon will  change to display the {@link com.smartgwt.client.widgets.grid.ListGrid#getUnremoveIcon unremoveIcon} for
     * this row. Clicking on this icon will call {@link com.smartgwt.client.widgets.grid.ListGrid#getUnmarkRemovedRecord
     * unmarkRemovedRecord} to mark the record as no longer pending deletion.
     *
     * @param canRemoveRecords canRemoveRecords Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setCanRemoveRecords(Boolean canRemoveRecords)  throws IllegalStateException {
        setAttribute("canRemoveRecords", canRemoveRecords, false);
    }

    /**
     * If set, provide UI for the user to remove records from the grid. This is achieved by rendering an additional field in
     * the listGrid which, when clicked, will call {@link com.smartgwt.client.widgets.grid.ListGrid#removeRecordClick
     * ListGrid.removeRecordClick} which removes the row from the data set (or if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDeferRemoval deferRemoval} is true changes the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#markRecordRemoved ListGrid.markRecordRemoved} status for the record). <P> If
     * deferring removal, the record will appear marked with the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRemovedCSSText removedCSSText}  until the removal is committed via a call
     * to {@link com.smartgwt.client.widgets.grid.ListGrid#saveEdits ListGrid.saveEdits}.  Otherwise, the record will disappear
     * from view. If {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord animateRemoveRecord} is true,  the
     * removed record will appear to shrink out of view when it is removed. <P> By default the field will display the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRemoveIcon removeIcon} next to each record, and will be rendered as the
     * leftmost column. Two mechanisms exist to further modify this field: <ul> <li>To change the position of the remove-field,
     * include an explicitly specified field with     the attribute {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIsRemoveField isRemoveField:true} set. This will then     be used as
     * the remove field instead of adding a field to the beginning of the set of     columns.</li> <li>Additional direct
     * configuration of the remove field may be achieved by modifying     {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRemoveFieldProperties removeFieldProperties}.</li> </ul> If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDeferRemoval deferRemoval} is true, when a record is marked as removed, the
     * the icon will  change to display the {@link com.smartgwt.client.widgets.grid.ListGrid#getUnremoveIcon unremoveIcon} for
     * this row. Clicking on this icon will call {@link com.smartgwt.client.widgets.grid.ListGrid#getUnmarkRemovedRecord
     * unmarkRemovedRecord} to mark the record as no longer pending deletion.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Boolean getCanRemoveRecords()  {
        return getAttributeAsBoolean("canRemoveRecords");
    }

    /**
     * Indicates whether fields in this listGrid can be reordered by dragging and dropping header fields.
     *
     * @param canReorderFields canReorderFields Default value is true
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_appearance_columnorder" target="examples">Column order Example</a>
     */
    public void setCanReorderFields(Boolean canReorderFields) {
        setAttribute("canReorderFields", canReorderFields, true);
    }

    /**
     * Indicates whether fields in this listGrid can be reordered by dragging and dropping header fields.
     *
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_appearance_columnorder" target="examples">Column order Example</a>
     */
    public Boolean getCanReorderFields()  {
        return getAttributeAsBoolean("canReorderFields");
    }

    /**
     * Indicates whether records can be reordered by dragging within this listGrid.
     *
     * @param canReorderRecords canReorderRecords Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGridRecord#setCanDrag
     * @see com.smartgwt.client.widgets.grid.ListGridRecord#setCanAcceptDrop
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_move_list" target="examples">Drag list (move) Example</a>
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_drag_reorder" target="examples">Drag reorder Example</a>
     */
    public void setCanReorderRecords(Boolean canReorderRecords) {
        setAttribute("canReorderRecords", canReorderRecords, true);
    }

    /**
     * Indicates whether records can be reordered by dragging within this listGrid.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGridRecord#getCanDrag
     * @see com.smartgwt.client.widgets.grid.ListGridRecord#getCanAcceptDrop
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_move_list" target="examples">Drag list (move) Example</a>
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_drag_reorder" target="examples">Drag reorder Example</a>
     */
    public Boolean getCanReorderRecords()  {
        return getAttributeAsBoolean("canReorderRecords");
    }

    /**
     * Indicates whether fields in this listGrid can be resized by dragging header fields.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter method for updating {@link com.smartgwt.client.widgets.grid.ListGrid#getCanResizeFields canResizeFields} at runtime.
     *
     * @param canResizeFields new value for this.canResizeFields. Default value is true
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_appearance_columnsize" target="examples">Column size Example</a>
     */
    public void setCanResizeFields(Boolean canResizeFields) {
        setAttribute("canResizeFields", canResizeFields, true);
    }

    /**
     * Indicates whether fields in this listGrid can be resized by dragging header fields.
     *
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_appearance_columnsize" target="examples">Column size Example</a>
     */
    public Boolean getCanResizeFields()  {
        return getAttributeAsBoolean("canResizeFields");
    }

    /**
     * Controls whether a checkbox for selecting all records appears in the header with  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} set to "checkbox"
     *
     * @param canSelectAll canSelectAll Default value is null
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public void setCanSelectAll(Boolean canSelectAll) {
        setAttribute("canSelectAll", canSelectAll, true);
    }

    /**
     * Controls whether a checkbox for selecting all records appears in the header with  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} set to "checkbox"
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public Boolean getCanSelectAll()  {
        return getAttributeAsBoolean("canSelectAll");
    }

    /**
     * Enables or disables interactive sorting behavior for this listGrid. Does not affect sorting by direct calls to the
     * {@link com.smartgwt.client.widgets.grid.ListGrid#sort sort} or  {@link com.smartgwt.client.widgets.grid.ListGrid#setSort
     * setSort} methods.
     *
     * @param canSort canSort Default value is true
     */
    public void setCanSort(Boolean canSort) {
        setAttribute("canSort", canSort, true);
    }

    /**
     * Enables or disables interactive sorting behavior for this listGrid. Does not affect sorting by direct calls to the
     * {@link com.smartgwt.client.widgets.grid.ListGrid#sort sort} or  {@link com.smartgwt.client.widgets.grid.ListGrid#setSort
     * setSort} methods.
     *
     *
     * @return Boolean
     */
    public Boolean getCanSort()  {
        return getAttributeAsBoolean("canSort");
    }

    /**
     * Should the header be included in the tab-order for the page? If not explicitly specified, the header will be included in
     * the tab order for the page if  setScreenReaderMode is called.
     *
     * @param canTabToHeader canTabToHeader Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Accessibility Accessibility overview and related methods
     */
    public void setCanTabToHeader(Boolean canTabToHeader)  throws IllegalStateException {
        setAttribute("canTabToHeader", canTabToHeader, false);
    }

    /**
     * Should the header be included in the tab-order for the page? If not explicitly specified, the header will be included in
     * the tab order for the page if  setScreenReaderMode is called.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Accessibility Accessibility overview and related methods
     */
    public Boolean getCanTabToHeader()  {
        return getAttributeAsBoolean("canTabToHeader");
    }

    /**
     * The default height of each row in pixels.
     *
     * @param cellHeight cellHeight Default value is 20
     * @see com.smartgwt.client.grid.GridRenderer#getRowHeight
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_appearance_multiline" target="examples">Multiline values Example</a>
     */
    public void setCellHeight(int cellHeight) {
        setAttribute("cellHeight", cellHeight, true);
    }

    /**
     * The default height of each row in pixels.
     *
     *
     * @return int
     * @see com.smartgwt.client.grid.GridRenderer#getRowHeight
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_appearance_multiline" target="examples">Multiline values Example</a>
     */
    public int getCellHeight()  {
        return getAttributeAsInt("cellHeight");
    }

    /**
     * The amount of empty space, in pixels, surrounding each value in its cell.
     *
     * @param cellPadding cellPadding Default value is 2
     */
    public void setCellPadding(int cellPadding) {
        setAttribute("cellPadding", cellPadding, true);
    }

    /**
     * The amount of empty space, in pixels, surrounding each value in its cell.
     *
     *
     * @return int
     */
    public int getCellPadding()  {
        return getAttributeAsInt("cellPadding");
    }

    /**
     * Name of the Smart GWT Class to be used when creating charts.  Must support the Chart interface.
     *
     * @param chartConstructor chartConstructor Default value is "FacetChart"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setChartConstructor(String chartConstructor)  throws IllegalStateException {
        setAttribute("chartConstructor", chartConstructor, false);
    }

    /**
     * Name of the Smart GWT Class to be used when creating charts.  Must support the Chart interface.
     *
     *
     * @return String
     */
    public String getChartConstructor()  {
        return getAttributeAsString("chartConstructor");
    }

    /**
     * Default type of chart to plot.
     *
     * @param chartType chartType Default value is "Column"
     */
    public void setChartType(ChartType chartType) {
        setAttribute("chartType", chartType == null ? null : chartType.getValue(), true);
    }

    /**
     * Default type of chart to plot.
     *
     *
     * @return ChartType
     */
    public ChartType getChartType()  {
        return EnumUtil.getEnum(ChartType.values(), getAttribute("chartType"));
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is set to
     * <code>"checkbox"</code> this property determines the image to display in the checkbox field for an unselected row. If
     * unset, the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage} will be used.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param checkboxFieldFalseImage checkboxFieldFalseImage Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setCheckboxFieldTrueImage
     * @see com.smartgwt.client.widgets.grid.ListGrid#setCheckboxFieldImageWidth
     * @see com.smartgwt.client.widgets.grid.ListGrid#setCheckboxFieldImageHeight
     */
    public void setCheckboxFieldFalseImage(String checkboxFieldFalseImage) {
        setAttribute("checkboxFieldFalseImage", checkboxFieldFalseImage, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is set to
     * <code>"checkbox"</code> this property determines the image to display in the checkbox field for an unselected row. If
     * unset, the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage} will be used.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCheckboxFieldTrueImage
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCheckboxFieldImageWidth
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCheckboxFieldImageHeight
     */
    public String getCheckboxFieldFalseImage()  {
        return getAttributeAsString("checkboxFieldFalseImage");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is set to
     * <code>"checkbox"</code> this property may be set to govern the height of the checkbox image displayed to indicate
     * whether a row is selected. If unset, the checkboxField image will be sized to match the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanImageHeight booleanImageHeight} for this grid.
     *
     * @param checkboxFieldImageHeight checkboxFieldImageHeight Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCheckboxFieldImageHeight(Integer checkboxFieldImageHeight)  throws IllegalStateException {
        setAttribute("checkboxFieldImageHeight", checkboxFieldImageHeight, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is set to
     * <code>"checkbox"</code> this property may be set to govern the height of the checkbox image displayed to indicate
     * whether a row is selected. If unset, the checkboxField image will be sized to match the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanImageHeight booleanImageHeight} for this grid.
     *
     *
     * @return Integer
     */
    public Integer getCheckboxFieldImageHeight()  {
        return getAttributeAsInt("checkboxFieldImageHeight");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is set to
     * <code>"checkbox"</code> this property may be set to govern the width of the checkbox image displayed to indicate whether
     * a row is selected. If unset, the checkboxField image will be sized to match the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanImageWidth booleanImageWidth} for this grid.
     *
     * @param checkboxFieldImageWidth checkboxFieldImageWidth Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCheckboxFieldImageWidth(Integer checkboxFieldImageWidth)  throws IllegalStateException {
        setAttribute("checkboxFieldImageWidth", checkboxFieldImageWidth, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is set to
     * <code>"checkbox"</code> this property may be set to govern the width of the checkbox image displayed to indicate whether
     * a row is selected. If unset, the checkboxField image will be sized to match the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanImageWidth booleanImageWidth} for this grid.
     *
     *
     * @return Integer
     */
    public Integer getCheckboxFieldImageWidth()  {
        return getAttributeAsInt("checkboxFieldImageWidth");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is set to
     * <code>"checkbox"</code> this property determines the image to display in the checkbox field for a partially selected
     * row. If unset, the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanPartialImage booleanPartialImage} will be
     * used.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param checkboxFieldPartialImage checkboxFieldPartialImage Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setCheckboxFieldTrueImage
     * @see com.smartgwt.client.widgets.grid.ListGrid#setCheckboxFieldImageWidth
     * @see com.smartgwt.client.widgets.grid.ListGrid#setCheckboxFieldImageHeight
     */
    public void setCheckboxFieldPartialImage(String checkboxFieldPartialImage) {
        setAttribute("checkboxFieldPartialImage", checkboxFieldPartialImage, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is set to
     * <code>"checkbox"</code> this property determines the image to display in the checkbox field for a partially selected
     * row. If unset, the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanPartialImage booleanPartialImage} will be
     * used.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCheckboxFieldTrueImage
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCheckboxFieldImageWidth
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCheckboxFieldImageHeight
     */
    public String getCheckboxFieldPartialImage()  {
        return getAttributeAsString("checkboxFieldPartialImage");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is set to
     * <code>"checkbox"</code> this property determines the image to display in the checkbox field for a selected row. If
     * unset, the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} will be used.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param checkboxFieldTrueImage checkboxFieldTrueImage Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setCheckboxFieldFalseImage
     * @see com.smartgwt.client.widgets.grid.ListGrid#setCheckboxFieldImageWidth
     * @see com.smartgwt.client.widgets.grid.ListGrid#setCheckboxFieldImageHeight
     */
    public void setCheckboxFieldTrueImage(String checkboxFieldTrueImage) {
        setAttribute("checkboxFieldTrueImage", checkboxFieldTrueImage, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is set to
     * <code>"checkbox"</code> this property determines the image to display in the checkbox field for a selected row. If
     * unset, the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} will be used.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCheckboxFieldFalseImage
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCheckboxFieldImageWidth
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCheckboxFieldImageHeight
     */
    public String getCheckboxFieldTrueImage()  {
        return getAttributeAsString("checkboxFieldTrueImage");
    }

    /**
     * For {@link com.smartgwt.client.types.ExpansionMode expansionModes} that show another grid or tree, what the  child's
     * expansionMode should be. <P>Default value <code>null</code> means no further expansion.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param childExpansionMode childExpansionMode Default value is null
     */
    public void setChildExpansionMode(ExpansionMode childExpansionMode) {
        setAttribute("childExpansionMode", childExpansionMode == null ? null : childExpansionMode.getValue(), true);
    }

    /**
     * For {@link com.smartgwt.client.types.ExpansionMode expansionModes} that show another grid or tree, what the  child's
     * expansionMode should be. <P>Default value <code>null</code> means no further expansion.
     *
     *
     * @return ExpansionMode
     */
    public ExpansionMode getChildExpansionMode()  {
        return EnumUtil.getEnum(ExpansionMode.values(), getAttribute("childExpansionMode"));
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid, this attribute will be shown as the menu item title to clear any existing sort on all fields.  This menu-item is
     * displayed only in the context menu for the sorter button.
     *
     * @param clearAllSortingText clearAllSortingText Default value is "Clear All Sorting"
     */
    public void setClearAllSortingText(String clearAllSortingText) {
        setAttribute("clearAllSortingText", clearAllSortingText, true);
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid, this attribute will be shown as the menu item title to clear any existing sort on all fields.  This menu-item is
     * displayed only in the context menu for the sorter button.
     *
     *
     * @return String
     */
    public String getClearAllSortingText()  {
        return getAttributeAsString("clearAllSortingText");
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid,  and a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor filter-editor} is visible, this
     * attribute will be shown as the menu item title to clear any existing filter.  This menu-item is displayed only in the
     * context menu for the sorter button.
     *
     * @param clearFilterText clearFilterText Default value is "Clear Filter"
     */
    public void setClearFilterText(String clearFilterText) {
        setAttribute("clearFilterText", clearFilterText, true);
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid,  and a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor filter-editor} is visible, this
     * attribute will be shown as the menu item title to clear any existing filter.  This menu-item is displayed only in the
     * context menu for the sorter button.
     *
     *
     * @return String
     */
    public String getClearFilterText()  {
        return getAttributeAsString("clearFilterText");
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid, this attribute will be shown as the menu item title to clear an existing sort on this field.
     *
     * @param clearSortFieldText clearSortFieldText Default value is "Clear Sort"
     */
    public void setClearSortFieldText(String clearSortFieldText) {
        setAttribute("clearSortFieldText", clearSortFieldText, true);
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid, this attribute will be shown as the menu item title to clear an existing sort on this field.
     *
     *
     * @return String
     */
    public String getClearSortFieldText()  {
        return getAttributeAsString("clearSortFieldText");
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid,  and multi-sorting is enabled, this attribute is used as the title for a menu item that opens  a MultiSortDialog
     * to configure the sort-specification for this grid.  This menu-item is displayed only in the context menu for the sorter
     * button.
     *
     * @param configureSortText configureSortText Default value is "Configure Sort"
     */
    public void setConfigureSortText(String configureSortText) {
        setAttribute("configureSortText", configureSortText, true);
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid,  and multi-sorting is enabled, this attribute is used as the title for a menu item that opens  a MultiSortDialog
     * to configure the sort-specification for this grid.  This menu-item is displayed only in the context menu for the sorter
     * button.
     *
     *
     * @return String
     */
    public String getConfigureSortText()  {
        return getAttributeAsString("configureSortText");
    }

    /**
     * If this is an editable listGrid, when the user attempts to cancel an edit, should we display a confirmation prompt
     * before discarding the edited values for the record?
     *
     * @param confirmCancelEditing confirmCancelEditing Default value is false
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setConfirmCancelEditing(Boolean confirmCancelEditing) {
        setAttribute("confirmCancelEditing", confirmCancelEditing, true);
    }

    /**
     * If this is an editable listGrid, when the user attempts to cancel an edit, should we display a confirmation prompt
     * before discarding the edited values for the record?
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean getConfirmCancelEditing()  {
        return getAttributeAsBoolean("confirmCancelEditing");
    }

    /**
     * For editable listGrids, outstanding unsaved edits when the user performs a new filter or sort will be discarded. This
     * flag determines whether we should display a confirmation dialog with options to save or discard the edits, or cancel the
     * action in this case.
     *
     * @param confirmDiscardEdits confirmDiscardEdits Default value is true
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setConfirmDiscardEdits(Boolean confirmDiscardEdits) {
        setAttribute("confirmDiscardEdits", confirmDiscardEdits, true);
    }

    /**
     * For editable listGrids, outstanding unsaved edits when the user performs a new filter or sort will be discarded. This
     * flag determines whether we should display a confirmation dialog with options to save or discard the edits, or cancel the
     * action in this case.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean getConfirmDiscardEdits()  {
        return getAttributeAsBoolean("confirmDiscardEdits");
    }

    /**
     * If <code>this.confirmDiscardEdits</code> is true, this property can be used to customize the error message string
     * displayed to the user in a dialog with options to  cancel the action, or save or discard pending edits in response to
     * sort/filter actions that would otherwise drop unsaved edit values.
     *
     * @param confirmDiscardEditsMessage confirmDiscardEditsMessage Default value is "This action will discard unsaved changes for this list."
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setConfirmDiscardEditsMessage(String confirmDiscardEditsMessage) {
        setAttribute("confirmDiscardEditsMessage", confirmDiscardEditsMessage, true);
    }

    /**
     * If <code>this.confirmDiscardEdits</code> is true, this property can be used to customize the error message string
     * displayed to the user in a dialog with options to  cancel the action, or save or discard pending edits in response to
     * sort/filter actions that would otherwise drop unsaved edit values.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public String getConfirmDiscardEditsMessage()  {
        return getAttributeAsString("confirmDiscardEditsMessage");
    }

    /**
     * How to fetch and manage records retrieve from the server.  See {@link com.smartgwt.client.types.FetchMode}. <P> This
     * setting only applies to the {@link com.smartgwt.client.data.ResultSet} automatically created by calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData ListGrid.fetchData}.  If a pre-existing ResultSet is passed to
     * setData() instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode fetchMode} applies.
     *
     * @param dataFetchMode dataFetchMode Default value is "paged"
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setDataFetchMode(FetchMode dataFetchMode) {
        setAttribute("dataFetchMode", dataFetchMode == null ? null : dataFetchMode.getValue(), true);
    }

    /**
     * How to fetch and manage records retrieve from the server.  See {@link com.smartgwt.client.types.FetchMode}. <P> This
     * setting only applies to the {@link com.smartgwt.client.data.ResultSet} automatically created by calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData ListGrid.fetchData}.  If a pre-existing ResultSet is passed to
     * setData() instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode fetchMode} applies.
     *
     *
     * @return FetchMode
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public FetchMode getDataFetchMode()  {
        return EnumUtil.getEnum(FetchMode.values(), getAttribute("dataFetchMode"));
    }

    /**
     * How should Date type values be displayed in this ListGrid by default? <P> This property specifies the default
     * DateDisplayFormat to apply to Date values displayed in this grid for all fields except those of {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getType type "time"} (See also {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getTimeFormatter timeFormatter}).<br> If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDatetimeFormatter datetimeFormatter} is specified, that will be applied by
     * default to fields of type <code>"datetime"</code>. <P> Note that if {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter dateFormatter} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTimeFormatter timeFormatter} are specified those properties will take
     * precedence over the component level settings. <P> If unset, date values will be formatted according to the system wide  
     * short display format or   short datetime display format for datetime type fields. <P> If this field is editable the
     * dateFormatter will also be passed to the editor created to edit this field as {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter}. In this case you may also need to set
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getDateInputFormat dateInputFormat}.
     *
     * @param dateFormatter dateFormatter Default value is null
     */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter == null ? null : dateFormatter.getValue(), true);
    }

    /**
     * How should Date type values be displayed in this ListGrid by default? <P> This property specifies the default
     * DateDisplayFormat to apply to Date values displayed in this grid for all fields except those of {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getType type "time"} (See also {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getTimeFormatter timeFormatter}).<br> If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDatetimeFormatter datetimeFormatter} is specified, that will be applied by
     * default to fields of type <code>"datetime"</code>. <P> Note that if {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter dateFormatter} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTimeFormatter timeFormatter} are specified those properties will take
     * precedence over the component level settings. <P> If unset, date values will be formatted according to the system wide  
     * short display format or   short datetime display format for datetime type fields. <P> If this field is editable the
     * dateFormatter will also be passed to the editor created to edit this field as {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter}. In this case you may also need to set
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getDateInputFormat dateInputFormat}.
     *
     *
     * @return DateDisplayFormat
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }

    /**
     * Display format to use for fields specified as type 'datetime'.  Default is to use the system-wide default date time
     * format, configured via  Date.setShortDatetimeDisplayFormat.  Specify any valid {@link
     * com.smartgwt.client.types.DateDisplayFormat} to change the display format for datetimes used by this grid.  <P> May also
     * be specified at the field level via {@link com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter
     * dateFormatter} <P> If this field is editable the dateFormatter will also be passed to the editor created to edit this
     * field as {@link com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter}. In this case you may
     * also need to set {@link com.smartgwt.client.widgets.grid.ListGrid#getDateInputFormat dateInputFormat}.
     *
     * @param datetimeFormatter datetimeFormatter Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setDateFormatter
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDatetimeFormatter(DateDisplayFormat datetimeFormatter) {
        setAttribute("datetimeFormatter", datetimeFormatter == null ? null : datetimeFormatter.getValue(), true);
    }

    /**
     * Display format to use for fields specified as type 'datetime'.  Default is to use the system-wide default date time
     * format, configured via  Date.setShortDatetimeDisplayFormat.  Specify any valid {@link
     * com.smartgwt.client.types.DateDisplayFormat} to change the display format for datetimes used by this grid.  <P> May also
     * be specified at the field level via {@link com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter
     * dateFormatter} <P> If this field is editable the dateFormatter will also be passed to the editor created to edit this
     * field as {@link com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter}. In this case you may
     * also need to set {@link com.smartgwt.client.widgets.grid.ListGrid#getDateInputFormat dateInputFormat}.
     *
     *
     * @return DateDisplayFormat
     * @see com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DateDisplayFormat getDatetimeFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("datetimeFormatter"));
    }

    /**
     * When enabled, the field shown by {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords}
     * causes records to be marked for future removal via {@link com.smartgwt.client.widgets.grid.ListGrid#markRecordRemoved
     * ListGrid.markRecordRemoved} instead of immediately being  removed. <P> When a record has been marked for removal, an
     * icon in the <code>canRemoveRecords</code> field allowing it to be unmarked will be displayed. <P> If not explicitly
     * specified by this property, removal of records will be deferred if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits} is false for the grid.
     *
     * @param deferRemoval deferRemoval Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setDeferRemoval(Boolean deferRemoval)  throws IllegalStateException {
        setAttribute("deferRemoval", deferRemoval, false);
    }

    /**
     * When enabled, the field shown by {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords}
     * causes records to be marked for future removal via {@link com.smartgwt.client.widgets.grid.ListGrid#markRecordRemoved
     * ListGrid.markRecordRemoved} instead of immediately being  removed. <P> When a record has been marked for removal, an
     * icon in the <code>canRemoveRecords</code> field allowing it to be unmarked will be displayed. <P> If not explicitly
     * specified by this property, removal of records will be deferred if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits} is false for the grid.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean getDeferRemoval()  {
        return getAttributeAsBoolean("deferRemoval");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is true and {@link
     * com.smartgwt.client.types.ExpansionMode listGrid.expansionMode} is <code>"related"</code>, this property specifies the
     * dataSource for the  related records grid to be shown embedded in expanded records. <P> This property may also be
     * specified on a per-record basis - see  {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordDetailDSProperty
     * recordDetailDSProperty}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param detailDS detailDS Default value is null
     */
    public void setDetailDS(String detailDS) {
        setAttribute("detailDS", detailDS, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is true and {@link
     * com.smartgwt.client.types.ExpansionMode listGrid.expansionMode} is <code>"related"</code>, this property specifies the
     * dataSource for the  related records grid to be shown embedded in expanded records. <P> This property may also be
     * specified on a per-record basis - see  {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordDetailDSProperty
     * recordDetailDSProperty}
     *
     *
     * @return String
     */
    public String getDetailDS()  {
        return getAttributeAsString("detailDS");
    }

    /**
     * The field whose contents to show in the expanded portion of a record when  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is <code>true</code> and  {@link
     * com.smartgwt.client.types.ExpansionMode listGrid.expansionMode} is <code>detailField</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param detailField detailField Default value is null
     */
    public void setDetailField(String detailField) {
        setAttribute("detailField", detailField, true);
    }

    /**
     * The field whose contents to show in the expanded portion of a record when  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is <code>true</code> and  {@link
     * com.smartgwt.client.types.ExpansionMode listGrid.expansionMode} is <code>detailField</code>.
     *
     *
     * @return String
     */
    public String getDetailField()  {
        return getAttributeAsString("detailField");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getConfirmDiscardEdits confirmDiscardEdits} is true this is the
     * title for the save button appearing in the lost edits confirmation dialog. Override this for localization if necessary.
     *
     * @param discardEditsSaveButtonTitle discardEditsSaveButtonTitle Default value is "Save"
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setDiscardEditsSaveButtonTitle(String discardEditsSaveButtonTitle) {
        setAttribute("discardEditsSaveButtonTitle", discardEditsSaveButtonTitle, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getConfirmDiscardEdits confirmDiscardEdits} is true this is the
     * title for the save button appearing in the lost edits confirmation dialog. Override this for localization if necessary.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public String getDiscardEditsSaveButtonTitle()  {
        return getAttributeAsString("discardEditsSaveButtonTitle");
    }

    /**
     * When records are being dragged from within a ListGrid, what sort of drag-tracker should be displayed?<br> Note that if
     * multiple records are being dragged the displayed tracker will be based on the first selected record.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dragTrackerMode dragTrackerMode Default value is "icon"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDragTrackerMode(DragTrackerMode dragTrackerMode)  throws IllegalStateException {
        setAttribute("dragTrackerMode", dragTrackerMode == null ? null : dragTrackerMode.getValue(), false);
    }

    /**
     * When records are being dragged from within a ListGrid, what sort of drag-tracker should be displayed?<br> Note that if
     * multiple records are being dragged the displayed tracker will be based on the first selected record.
     *
     *
     * @return DragTrackerMode
     */
    public DragTrackerMode getDragTrackerMode()  {
        return EnumUtil.getEnum(DragTrackerMode.values(), getAttribute("dragTrackerMode"));
    }

    /**
     * How far should we render rows ahead of the currently visible area?  This is expressed as a ratio from viewport size to
     * rendered area size. <P> Tweaking drawAheadRatio allows you to make tradeoffs between continuous scrolling speed vs
     * initial render time and render time when scrolling by large amounts. <P> NOTE: Only applies when showAllRows is false.
     *
     * @param drawAheadRatio drawAheadRatio Default value is 1.3
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_dataoperations_fetch" target="examples">Databound fetch Example</a>
     */
    public void setDrawAheadRatio(float drawAheadRatio) {
        setAttribute("drawAheadRatio", drawAheadRatio, true);
    }

    /**
     * How far should we render rows ahead of the currently visible area?  This is expressed as a ratio from viewport size to
     * rendered area size. <P> Tweaking drawAheadRatio allows you to make tradeoffs between continuous scrolling speed vs
     * initial render time and render time when scrolling by large amounts. <P> NOTE: Only applies when showAllRows is false.
     *
     *
     * @return float
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_dataoperations_fetch" target="examples">Databound fetch Example</a>
     */
    public float getDrawAheadRatio()  {
        return getAttributeAsFloat("drawAheadRatio");
    }

    /**
     * If drawing all rows would cause less than <code>drawAllMaxCells</code> cells to be rendered, the full dataset will
     * instead be drawn even if {@link com.smartgwt.client.widgets.grid.ListGrid#getShowAllRecords showAllRecords} is false and
     * the viewport size and {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio} setting would
     * normally have caused incremental rendering to be used. <P> The <code>drawAllMaxCells</code> setting prevents incremental
     * rendering from being used in situations where it's really unnecessary, such as a 40 row, 5 column dataset (only 200
     * cells) which happens to be in a grid with a viewport showing only 20 or so rows. Incremental rendering causes a brief
     * "flash" during scrolling as the visible portion of the dataset is redrawn, and a better scrolling experience can be
     * obtained in this situation by drawing the entire dataset up front, which in this example would have negligible effect on
     * initial draw time. <P> <code>drawAllMaxCells:0</code> disables this features.  You may want to disable this feature if
     * performance is an issue and: <ul> <li> you are very frequently redraw a grid <li> you do a lot of computation when
     * rendering each cell (eg formulas) <li> you are showing many grids on one screen and the user won't scroll most of them
     * </ul>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param drawAllMaxCells drawAllMaxCells Default value is 250
     */
    public void setDrawAllMaxCells(int drawAllMaxCells) {
        setAttribute("drawAllMaxCells", drawAllMaxCells, true);
    }

    /**
     * If drawing all rows would cause less than <code>drawAllMaxCells</code> cells to be rendered, the full dataset will
     * instead be drawn even if {@link com.smartgwt.client.widgets.grid.ListGrid#getShowAllRecords showAllRecords} is false and
     * the viewport size and {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio} setting would
     * normally have caused incremental rendering to be used. <P> The <code>drawAllMaxCells</code> setting prevents incremental
     * rendering from being used in situations where it's really unnecessary, such as a 40 row, 5 column dataset (only 200
     * cells) which happens to be in a grid with a viewport showing only 20 or so rows. Incremental rendering causes a brief
     * "flash" during scrolling as the visible portion of the dataset is redrawn, and a better scrolling experience can be
     * obtained in this situation by drawing the entire dataset up front, which in this example would have negligible effect on
     * initial draw time. <P> <code>drawAllMaxCells:0</code> disables this features.  You may want to disable this feature if
     * performance is an issue and: <ul> <li> you are very frequently redraw a grid <li> you do a lot of computation when
     * rendering each cell (eg formulas) <li> you are showing many grids on one screen and the user won't scroll most of them
     * </ul>
     *
     *
     * @return int
     */
    public int getDrawAllMaxCells()  {
        return getAttributeAsInt("drawAllMaxCells");
    }

    /**
     * Determines whether when the user edits a cell in this listGrid the entire row becomes editable, or just the cell that
     * received the edit event. <P> No effect if this.canEdit is false or null.
     *
     * @param editByCell editByCell Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setCanEdit
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_editing_cell" target="examples">Edit by cell Example</a>
     */
    public void setEditByCell(Boolean editByCell) {
        setAttribute("editByCell", editByCell, true);
    }

    /**
     * Determines whether when the user edits a cell in this listGrid the entire row becomes editable, or just the cell that
     * received the edit event. <P> No effect if this.canEdit is false or null.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCanEdit
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_editing_cell" target="examples">Edit by cell Example</a>
     */
    public Boolean getEditByCell()  {
        return getAttributeAsBoolean("editByCell");
    }

    /**
     * Event that will trigger inline editing, see {@link com.smartgwt.client.types.ListGridEditEvent} for options. <P> Note
     * this setting has no effect unless {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit canEdit} has been set to
     * enable editing. <P> See also {@link com.smartgwt.client.widgets.grid.ListGrid#getEditOnFocus editOnFocus} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#startEditing ListGrid.startEditing}.
     *
     * @param editEvent editEvent Default value is "doubleClick"
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_editing_row" target="examples">Edit by row Example</a>
     */
    public void setEditEvent(ListGridEditEvent editEvent) {
        setAttribute("editEvent", editEvent == null ? null : editEvent.getValue(), true);
    }

    /**
     * Event that will trigger inline editing, see {@link com.smartgwt.client.types.ListGridEditEvent} for options. <P> Note
     * this setting has no effect unless {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit canEdit} has been set to
     * enable editing. <P> See also {@link com.smartgwt.client.widgets.grid.ListGrid#getEditOnFocus editOnFocus} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#startEditing ListGrid.startEditing}.
     *
     *
     * @return ListGridEditEvent
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_editing_row" target="examples">Edit by row Example</a>
     */
    public ListGridEditEvent getEditEvent()  {
        return EnumUtil.getEnum(ListGridEditEvent.values(), getAttribute("editEvent"));
    }

    /**
     * A base name for the CSS class applied to cells when editing has failed.<br>  If this listGrid is editable, this style
     * will be applied to any edited cells for which  validation failed.<br>  As with the default 'baseStyle' property, this
     * style will have "Dark", "Over", "Selected",   or "Disabled" appended to it according to the state of the cell.<br> If
     * null, cells for which editing has failed will be rendered using the normal base style classNames, but with custom
     * CSSText applied as derived from <code>this.editFailedCSSText</code>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param editFailedBaseStyle editFailedBaseStyle Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setBaseStyle
     * @see com.smartgwt.client.widgets.grid.ListGrid#setEditFailedCSSText
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setEditFailedBaseStyle(String editFailedBaseStyle) {
        setAttribute("editFailedBaseStyle", editFailedBaseStyle, true);
    }

    /**
     * A base name for the CSS class applied to cells when editing has failed.<br>  If this listGrid is editable, this style
     * will be applied to any edited cells for which  validation failed.<br>  As with the default 'baseStyle' property, this
     * style will have "Dark", "Over", "Selected",   or "Disabled" appended to it according to the state of the cell.<br> If
     * null, cells for which editing has failed will be rendered using the normal base style classNames, but with custom
     * CSSText applied as derived from <code>this.editFailedCSSText</code>
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle
     * @see com.smartgwt.client.widgets.grid.ListGrid#getEditFailedCSSText
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getEditFailedBaseStyle()  {
        return getAttributeAsString("editFailedBaseStyle");
    }

    /**
     * Custom CSS text to be applied to cells when editing has failed.<br>  If this listGrid is editable, this css text will be
     * applied to any edited cells for which  validation failed, on top of the base style for the cell.<br> For further
     * customization of styling for cells that failed editing validation, use <code>this.editFailedBaseStyle</code> instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param editFailedCSSText editFailedCSSText Default value is "color:red;border:1px solid red;"
     * @see com.smartgwt.client.widgets.grid.ListGrid#setEditFailedBaseStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setEditFailedCSSText(String editFailedCSSText) {
        setAttribute("editFailedCSSText", editFailedCSSText, true);
    }

    /**
     * Custom CSS text to be applied to cells when editing has failed.<br>  If this listGrid is editable, this css text will be
     * applied to any edited cells for which  validation failed, on top of the base style for the cell.<br> For further
     * customization of styling for cells that failed editing validation, use <code>this.editFailedBaseStyle</code> instead.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getEditFailedBaseStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getEditFailedCSSText()  {
        return getAttributeAsString("editFailedCSSText");
    }

    /**
     * Should we start editing when the widget has focus and the user presses the "f2" key (if this ListGrid supports editing)?
     * <P> Note that if {@link com.smartgwt.client.widgets.grid.ListGrid#getEditEvent editEvent} is set to <code>"click"</code>
     * or <code>"doubleClick"</code>, the <code>Space</code> or <code>Enter</code> key may also be used to start editing,
     * depending on the value for {@link com.smartgwt.client.widgets.grid.ListGrid#getGenerateClickOnSpace
     * generateClickOnSpace}, {@link com.smartgwt.client.widgets.grid.ListGrid#getGenerateDoubleClickOnSpace
     * generateDoubleClickOnSpace}, {@link com.smartgwt.client.widgets.grid.ListGrid#getGenerateClickOnEnter
     * generateClickOnEnter} and  {@link com.smartgwt.client.widgets.grid.ListGrid#getGenerateDoubleClickOnEnter
     * generateDoubleClickOnEnter}. <P> If {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit canEdit} is false, or
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getEditEvent editEvent} is set to "none" this property has no effect.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param editOnF2Keypress editOnF2Keypress Default value is true
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEditOnF2Keypress(Boolean editOnF2Keypress) {
        setAttribute("editOnF2Keypress", editOnF2Keypress, true);
    }

    /**
     * Should we start editing when the widget has focus and the user presses the "f2" key (if this ListGrid supports editing)?
     * <P> Note that if {@link com.smartgwt.client.widgets.grid.ListGrid#getEditEvent editEvent} is set to <code>"click"</code>
     * or <code>"doubleClick"</code>, the <code>Space</code> or <code>Enter</code> key may also be used to start editing,
     * depending on the value for {@link com.smartgwt.client.widgets.grid.ListGrid#getGenerateClickOnSpace
     * generateClickOnSpace}, {@link com.smartgwt.client.widgets.grid.ListGrid#getGenerateDoubleClickOnSpace
     * generateDoubleClickOnSpace}, {@link com.smartgwt.client.widgets.grid.ListGrid#getGenerateClickOnEnter
     * generateClickOnEnter} and  {@link com.smartgwt.client.widgets.grid.ListGrid#getGenerateDoubleClickOnEnter
     * generateDoubleClickOnEnter}. <P> If {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit canEdit} is false, or
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getEditEvent editEvent} is set to "none" this property has no effect.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean getEditOnF2Keypress()  {
        return getAttributeAsBoolean("editOnF2Keypress");
    }

    /**
     * Should we start editing when this widget receives focus (if this ListGrid supports editing)? <P> Note that this property
     * being set to true will cause editing to occur on a single click, even if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getEditEvent editEvent} is <code>"doubleClick"</code>, because single clicking
     * the grid will place keyboard focus there automatically.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param editOnFocus editOnFocus Default value is null
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEditOnFocus(Boolean editOnFocus) {
        setAttribute("editOnFocus", editOnFocus, true);
    }

    /**
     * Should we start editing when this widget receives focus (if this ListGrid supports editing)? <P> Note that this property
     * being set to true will cause editing to occur on a single click, even if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getEditEvent editEvent} is <code>"doubleClick"</code>, because single clicking
     * the grid will place keyboard focus there automatically.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean getEditOnFocus()  {
        return getAttributeAsBoolean("editOnFocus");
    }


    /**
     * A base name for the CSS class applied to cells containing pending (unsaved) edits<br>  As with the default 'baseStyle'
     * property, this style will have "Dark", "Over", "Selected",   or "Disabled" appended to it according to the state of the
     * cell.  If this property is null, cells with pending edits will pick up custom css text to  be applied on top of the
     * normal base style from <code>this.editPendingCSSText</code>
     *
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return String
     * @throws IllegalStateException if widget has not yet been rendered.
     * @see com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getEditPendingBaseStyle() throws IllegalStateException {
        errorIfNotCreated("editPendingBaseStyle");
        return getAttributeAsString("editPendingBaseStyle");
    }

    /**
     * Custom CSS text to be applied to cells with pending edits that have not yet been  submitted.<br> For further
     * customization of styling for cells with pending edits use <code>this.editPendingBaseStyle</code> instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param editPendingCSSText editPendingCSSText Default value is "color:#0066CC;"
     * @see com.smartgwt.client.widgets.grid.ListGrid#setEditFailedBaseStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setEditPendingCSSText(String editPendingCSSText) {
        setAttribute("editPendingCSSText", editPendingCSSText, true);
    }

    /**
     * Custom CSS text to be applied to cells with pending edits that have not yet been  submitted.<br> For further
     * customization of styling for cells with pending edits use <code>this.editPendingBaseStyle</code> instead.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getEditFailedBaseStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getEditPendingCSSText()  {
        return getAttributeAsString("editPendingCSSText");
    }

    /**
     * The value to display for cells whose value is null or the empty string after applying formatCellValue and valueMap (if
     * any). <p> This is the grid-wide attribute.  You may also set the emptyCellValue on a per-field basis.
     *
     * @param emptyCellValue emptyCellValue Default value is "&nbsp;"
     * @see com.smartgwt.client.widgets.grid.ListGridField#setEmptyCellValue
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_appearance_empty_values" target="examples">Empty values Example</a>
     */
    public void setEmptyCellValue(String emptyCellValue) {
        setAttribute("emptyCellValue", emptyCellValue, true);
    }

    /**
     * The value to display for cells whose value is null or the empty string after applying formatCellValue and valueMap (if
     * any). <p> This is the grid-wide attribute.  You may also set the emptyCellValue on a per-field basis.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGridField#getEmptyCellValue
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_appearance_empty_values" target="examples">Empty values Example</a>
     */
    public String getEmptyCellValue()  {
        return getAttributeAsString("emptyCellValue");
    }

    /**
     * The string to display in the body of a listGrid with an empty data array, if showEmptyMessage is true.
     *
     * @param emptyMessage emptyMessage Default value is "No items to show."
     * @see com.smartgwt.client.widgets.grid.ListGrid#setShowEmptyMessage
     * @see com.smartgwt.client.widgets.grid.ListGrid#setEmptyMessageStyle
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_appearance_empty_grid" target="examples">Empty grid Example</a>
     */
    public void setEmptyMessage(String emptyMessage) {
        setAttribute("emptyMessage", emptyMessage, true);
    }

    /**
     * The string to display in the body of a listGrid with an empty data array, if showEmptyMessage is true.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getShowEmptyMessage
     * @see com.smartgwt.client.widgets.grid.ListGrid#getEmptyMessageStyle
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_appearance_empty_grid" target="examples">Empty grid Example</a>
     */
    public String getEmptyMessage()  {
        return getAttributeAsString("emptyMessage");
    }

    /**
     * The CSS style name applied to the {@link com.smartgwt.client.widgets.grid.ListGrid#getEmptyMessage emptyMessage} if
     * displayed.
     *
     * @param emptyMessageStyle emptyMessageStyle Default value is "emptyMessage"
     */
    public void setEmptyMessageStyle(String emptyMessageStyle) {
        setAttribute("emptyMessageStyle", emptyMessageStyle, true);
    }

    /**
     * The CSS style name applied to the {@link com.smartgwt.client.widgets.grid.ListGrid#getEmptyMessage emptyMessage} if
     * displayed.
     *
     *
     * @return String
     */
    public String getEmptyMessageStyle()  {
        return getAttributeAsString("emptyMessageStyle");
    }

    /**
     * For performance reasons, even when {@link com.smartgwt.client.widgets.grid.ListGrid#getFixedRecordHeights
     * fixedRecordHeights} is set, vertical clipping is not enforced by default for some kinds of content (such as images) on
     * all browsers. Set {@link com.smartgwt.client.widgets.grid.ListGrid#getEnforceVClipping enforceVClipping:true} to enforce
     * clipping for all types of content on all browsers. <P> This additional setting is likely to be phased out as browsers
     * improve.
     *
     * @param enforceVClipping enforceVClipping Default value is false
     */
    public void setEnforceVClipping(Boolean enforceVClipping) {
        setAttribute("enforceVClipping", enforceVClipping, true);
    }

    /**
     * For performance reasons, even when {@link com.smartgwt.client.widgets.grid.ListGrid#getFixedRecordHeights
     * fixedRecordHeights} is set, vertical clipping is not enforced by default for some kinds of content (such as images) on
     * all browsers. Set {@link com.smartgwt.client.widgets.grid.ListGrid#getEnforceVClipping enforceVClipping:true} to enforce
     * clipping for all types of content on all browsers. <P> This additional setting is likely to be phased out as browsers
     * improve.
     *
     *
     * @return Boolean
     */
    public Boolean getEnforceVClipping()  {
        return getAttributeAsBoolean("enforceVClipping");
    }

    /**
     * What to do when a user hits enter while editing a cell: <ul> <li>"nextCell": start editing the next editable cell in
     * this record (or the first     editable cell in the next record if focus is in the last editable cell in the row)
     * <li>"nextRow": start editing the same field in the next row (skipping any rows where      that would be a non-editable
     * cell. <li>"nextRowStart": start editing the first editable cell in the next row. <li>"done": hide the editor (editing is
     * complete) </ul> Note that if this.autoSaveEdits is true, this may cause a save of the current edit values
     *
     * @param enterKeyEditAction enterKeyEditAction Default value is "done"
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEnterKeyEditAction(EnterKeyEditAction enterKeyEditAction) {
        setAttribute("enterKeyEditAction", enterKeyEditAction == null ? null : enterKeyEditAction.getValue(), true);
    }

    /**
     * What to do when a user hits enter while editing a cell: <ul> <li>"nextCell": start editing the next editable cell in
     * this record (or the first     editable cell in the next record if focus is in the last editable cell in the row)
     * <li>"nextRow": start editing the same field in the next row (skipping any rows where      that would be a non-editable
     * cell. <li>"nextRowStart": start editing the first editable cell in the next row. <li>"done": hide the editor (editing is
     * complete) </ul> Note that if this.autoSaveEdits is true, this may cause a save of the current edit values
     *
     *
     * @return EnterKeyEditAction
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public EnterKeyEditAction getEnterKeyEditAction()  {
        return EnumUtil.getEnum(EnterKeyEditAction.values(), getAttribute("enterKeyEditAction"));
    }

    /**
     * In a ListGrid that has a DataSource and has filter criteria that include values for fields declared as {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDSFieldType type "enum"} in the DataSource, by default a newly edited row
     * will use those filter criteria as initial values. <P> For example, if a ListGrid is showing all Accounts that have
     * status:"Active" and a new row is created, the new row will default to status:"Active" unless this flag is set to false.
     *
     * @param enumCriteriaAsInitialValues enumCriteriaAsInitialValues Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEnumCriteriaAsInitialValues(Boolean enumCriteriaAsInitialValues)  throws IllegalStateException {
        setAttribute("enumCriteriaAsInitialValues", enumCriteriaAsInitialValues, false);
    }

    /**
     * In a ListGrid that has a DataSource and has filter criteria that include values for fields declared as {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDSFieldType type "enum"} in the DataSource, by default a newly edited row
     * will use those filter criteria as initial values. <P> For example, if a ListGrid is showing all Accounts that have
     * status:"Active" and a new row is created, the new row will default to status:"Active" unless this flag is set to false.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean getEnumCriteriaAsInitialValues()  {
        return getAttributeAsBoolean("enumCriteriaAsInitialValues");
    }

    /**
     * What to do when a user hits escape while editing a cell:<ul> <li>"cancel": close the editor and discard the current set
     * of edit values <li>"done": just close the editor (the edit is complete, but the edited values are retained). </ul> Note
     * that if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits} is true, this may cause a save
     * of the current edit values
     *
     * @param escapeKeyEditAction escapeKeyEditAction Default value is "cancel"
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEscapeKeyEditAction(EscapeKeyEditAction escapeKeyEditAction) {
        setAttribute("escapeKeyEditAction", escapeKeyEditAction == null ? null : escapeKeyEditAction.getValue(), true);
    }

    /**
     * What to do when a user hits escape while editing a cell:<ul> <li>"cancel": close the editor and discard the current set
     * of edit values <li>"done": just close the editor (the edit is complete, but the edited values are retained). </ul> Note
     * that if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits} is true, this may cause a save
     * of the current edit values
     *
     *
     * @return EscapeKeyEditAction
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public EscapeKeyEditAction getEscapeKeyEditAction()  {
        return EnumUtil.getEnum(EscapeKeyEditAction.values(), getAttribute("escapeKeyEditAction"));
    }

    /**
     * For {@link com.smartgwt.client.types.ExpansionMode expansionModes} that show another grid or tree, is that  component
     * editable? <P>The default value for this property is <code>false</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param expansionCanEdit expansionCanEdit Default value is false
     */
    public void setExpansionCanEdit(Boolean expansionCanEdit) {
        setAttribute("expansionCanEdit", expansionCanEdit, true);
    }

    /**
     * For {@link com.smartgwt.client.types.ExpansionMode expansionModes} that show another grid or tree, is that  component
     * editable? <P>The default value for this property is <code>false</code>.
     *
     *
     * @return Boolean
     */
    public Boolean getExpansionCanEdit()  {
        return getAttributeAsBoolean("expansionCanEdit");
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is true and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getExpansionMode expansionMode} is <i>editor</i>, the prompt to display when
     * an expanded row is collapsed while it's nested editor has changed values.
     *
     * @param expansionEditorSaveDialogPrompt expansionEditorSaveDialogPrompt Default value is "You have unsaved changes - do you want to save them now?"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setExpansionEditorSaveDialogPrompt(String expansionEditorSaveDialogPrompt)  throws IllegalStateException {
        setAttribute("expansionEditorSaveDialogPrompt", expansionEditorSaveDialogPrompt, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is true and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getExpansionMode expansionMode} is <i>editor</i>, the prompt to display when
     * an expanded row is collapsed while it's nested editor has changed values.
     *
     *
     * @return String
     */
    public String getExpansionEditorSaveDialogPrompt()  {
        return getAttributeAsString("expansionEditorSaveDialogPrompt");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is set to <code>true</code>,
     * this property determines the image to display in the expansion field for collapsed rows. If unset, the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage} will be used.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param expansionFieldFalseImage expansionFieldFalseImage Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setExpansionFieldTrueImage
     * @see com.smartgwt.client.widgets.grid.ListGrid#setExpansionFieldImageWidth
     * @see com.smartgwt.client.widgets.grid.ListGrid#setExpansionFieldImageHeight
     */
    public void setExpansionFieldFalseImage(String expansionFieldFalseImage) {
        setAttribute("expansionFieldFalseImage", expansionFieldFalseImage, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is set to <code>true</code>,
     * this property determines the image to display in the expansion field for collapsed rows. If unset, the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage} will be used.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getExpansionFieldTrueImage
     * @see com.smartgwt.client.widgets.grid.ListGrid#getExpansionFieldImageWidth
     * @see com.smartgwt.client.widgets.grid.ListGrid#getExpansionFieldImageHeight
     */
    public String getExpansionFieldFalseImage()  {
        return getAttributeAsString("expansionFieldFalseImage");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is set to <code>true</code>,
     * this property may be set to govern the height of the expansion image displayed to indicate whether a  row is expanded.
     * If unset, the expansionField image will be sized to match the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanImageHeight booleanImageHeight} for this grid.
     *
     * @param expansionFieldImageHeight expansionFieldImageHeight Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setExpansionFieldImageHeight(Integer expansionFieldImageHeight)  throws IllegalStateException {
        setAttribute("expansionFieldImageHeight", expansionFieldImageHeight, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is set to <code>true</code>,
     * this property may be set to govern the height of the expansion image displayed to indicate whether a  row is expanded.
     * If unset, the expansionField image will be sized to match the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanImageHeight booleanImageHeight} for this grid.
     *
     *
     * @return Integer
     */
    public Integer getExpansionFieldImageHeight()  {
        return getAttributeAsInt("expansionFieldImageHeight");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is set to <code>true</code>,
     * this property may be set to govern the width of the expansion image displayed to indicate whether a row  is expanded. If
     * unset, the expansionField image will be sized to match the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanImageWidth booleanImageWidth} for this grid.
     *
     * @param expansionFieldImageWidth expansionFieldImageWidth Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setExpansionFieldImageWidth(Integer expansionFieldImageWidth)  throws IllegalStateException {
        setAttribute("expansionFieldImageWidth", expansionFieldImageWidth, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is set to <code>true</code>,
     * this property may be set to govern the width of the expansion image displayed to indicate whether a row  is expanded. If
     * unset, the expansionField image will be sized to match the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanImageWidth booleanImageWidth} for this grid.
     *
     *
     * @return Integer
     */
    public Integer getExpansionFieldImageWidth()  {
        return getAttributeAsInt("expansionFieldImageWidth");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is set to <code>true</code>,
     * this property determines the image to display in the expansion field for expanded rows. If unset, the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} will be used.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param expansionFieldTrueImage expansionFieldTrueImage Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setExpansionFieldFalseImage
     * @see com.smartgwt.client.widgets.grid.ListGrid#setExpansionFieldImageWidth
     * @see com.smartgwt.client.widgets.grid.ListGrid#setExpansionFieldImageHeight
     */
    public void setExpansionFieldTrueImage(String expansionFieldTrueImage) {
        setAttribute("expansionFieldTrueImage", expansionFieldTrueImage, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is set to <code>true</code>,
     * this property determines the image to display in the expansion field for expanded rows. If unset, the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} will be used.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getExpansionFieldFalseImage
     * @see com.smartgwt.client.widgets.grid.ListGrid#getExpansionFieldImageWidth
     * @see com.smartgwt.client.widgets.grid.ListGrid#getExpansionFieldImageHeight
     */
    public String getExpansionFieldTrueImage()  {
        return getAttributeAsString("expansionFieldTrueImage");
    }

    /**
     * The {@link com.smartgwt.client.types.ExpansionMode} for records in this grid. Default <code>null</code> value means no
     * expansion.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param expansionMode expansionMode Default value is null
     */
    public void setExpansionMode(ExpansionMode expansionMode) {
        setAttribute("expansionMode", expansionMode == null ? null : expansionMode.getValue(), true);
    }

    /**
     * The {@link com.smartgwt.client.types.ExpansionMode} for records in this grid. Default <code>null</code> value means no
     * expansion.
     *
     *
     * @return ExpansionMode
     */
    public ExpansionMode getExpansionMode()  {
        return EnumUtil.getEnum(ExpansionMode.values(), getAttribute("expansionMode"));
    }

    /**
     * Dictates whether the data in this grid should be exported raw by  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#exportClientData exportClientData()}.  If set to true,   data will not be
     * processed by field-formatters during exports. Decreases the time taken for large exports.  This property can also be set
     * at the {@link com.smartgwt.client.widgets.grid.ListGridField#getExportRawValues field level}.
     *
     * @param exportRawValues exportRawValues Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setExportRawValues(Boolean exportRawValues)  throws IllegalStateException {
        setAttribute("exportRawValues", exportRawValues, false);
    }

    /**
     * Dictates whether the data in this grid should be exported raw by  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#exportClientData exportClientData()}.  If set to true,   data will not be
     * processed by field-formatters during exports. Decreases the time taken for large exports.  This property can also be set
     * at the {@link com.smartgwt.client.widgets.grid.ListGridField#getExportRawValues field level}.
     *
     *
     * @return Boolean
     */
    public Boolean getExportRawValues()  {
        return getAttributeAsBoolean("exportRawValues");
    }

    /**
     * <b>Note: This property only has an effect in Internet Explorer</b> <P> Advanced property to improve performance for
     * dynamic styling of gridRenderer cells in Internet Explorer, at the expense of slightly slower initial drawing, and some 
     * limitations on supported styling options. <P> <code>fastCellUpdates</code> speeds up the dynamic styling system used by
     * rollovers, selections, and custom styling that calls {@link com.smartgwt.client.grid.GridRenderer#refreshCellStyle
     * GridRenderer.refreshCellStyle}, at the cost of slightly slower draw() and redraw() times. <P> Notes: <ul> <li>When this
     * property is set, ListGrid cells may be styled using the      {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getTallBaseStyle tallBaseStyle}. See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle ListGrid.getBaseStyle} for      more information.</li> <li>If any
     * cell styles specify a a background image URL, the URL will be resolved relative     to the page location rather than the
     * location of the CSS stylesheet. This means cell     styles with a background URL should either supply a fully qualified
     * path, or the     background image media should be made available at a second location for IE.</li> <li>fastCellUpdates
     * will not work if the styles involved are in an external stylesheet loaded     from a remote host. Either the stylesheet
     * containing cell styles needs to be loaded     from the same host as the main page, or the cell styles need to be inlined
     * in the html      of the bootstrap page.</li> <li>fastCellUpdates will not work if the css styles for cells are defined
     * in     a <code>.css</code> file loaded via <code>@import</code>. Instead the <code>.css</code>     file should be loaded
     * via a <code>&lt;link ...&gt;</code> tag.</li> </ul>
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.grid.GridRenderer#getFastCellUpdates fastCellUpdates}. Has no effect in browsers other than Internet Explorer.
     *
     * @param fastCellUpdates whether to enable fastCellUpdates.. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFastCellUpdates(Boolean fastCellUpdates)  throws IllegalStateException {
        setAttribute("fastCellUpdates", fastCellUpdates, false);
    }

    /**
     * If we're showing the filterEditor ({@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor
     * showFilterEditor} is true), and we're re-filtering on every keypress ({@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFilterOnKeypress filterOnKeypress} is true), this  property is the delay in
     * milliseconds between the user changing the filter and the  filter request being kicked off. If multiple changes are made
     * to the filter  within this fetch delay, only the most recent will actually cause a re-filter
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param fetchDelay fetchDelay Default value is 300
     */
    public void setFetchDelay(int fetchDelay) {
        setAttribute("fetchDelay", fetchDelay, true);
    }

    /**
     * If we're showing the filterEditor ({@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor
     * showFilterEditor} is true), and we're re-filtering on every keypress ({@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFilterOnKeypress filterOnKeypress} is true), this  property is the delay in
     * milliseconds between the user changing the filter and the  filter request being kicked off. If multiple changes are made
     * to the filter  within this fetch delay, only the most recent will actually cause a re-filter
     *
     *
     * @return int
     */
    public int getFetchDelay()  {
        return getAttributeAsInt("fetchDelay");
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid, and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanPickFields this.canPickFields} is true, this attribute
     * will be shown as the title for the menu item which contains a submenu with items  allowing the user to show and hide
     * fields in the grid.
     *
     * @param fieldVisibilitySubmenuTitle fieldVisibilitySubmenuTitle Default value is "Columns"
     */
    public void setFieldVisibilitySubmenuTitle(String fieldVisibilitySubmenuTitle) {
        setAttribute("fieldVisibilitySubmenuTitle", fieldVisibilitySubmenuTitle, true);
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid, and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanPickFields this.canPickFields} is true, this attribute
     * will be shown as the title for the menu item which contains a submenu with items  allowing the user to show and hide
     * fields in the grid.
     *
     *
     * @return String
     */
    public String getFieldVisibilitySubmenuTitle()  {
        return getAttributeAsString("fieldVisibilitySubmenuTitle");
    }

    /**
     * The prompt to show when the mouse hovers over the Filter button in the FilterEditor.
     *
     * @param filterButtonPrompt filterButtonPrompt Default value is "Filter"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFilterButtonPrompt(String filterButtonPrompt)  throws IllegalStateException {
        setAttribute("filterButtonPrompt", filterButtonPrompt, false);
    }

    /**
     * The prompt to show when the mouse hovers over the Filter button in the FilterEditor.
     *
     *
     * @return String
     */
    public String getFilterButtonPrompt()  {
        return getAttributeAsString("filterButtonPrompt");
    }

    /**
     * If we're showing the filterEditor (this.showFilterEditor is true), this property  determines whether this list should be
     * filtered every time the user puts focus in a different field in the filter editor.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param filterByCell filterByCell Default value is null
     */
    public void setFilterByCell(Boolean filterByCell) {
        setAttribute("filterByCell", filterByCell, true);
    }

    /**
     * If we're showing the filterEditor (this.showFilterEditor is true), this property  determines whether this list should be
     * filtered every time the user puts focus in a different field in the filter editor.
     *
     *
     * @return Boolean
     */
    public Boolean getFilterByCell()  {
        return getAttributeAsBoolean("filterByCell");
    }

    /**
     * Height for the filterEditor, if shown.
     *
     * @param filterEditorHeight filterEditorHeight Default value is 22
     */
    public void setFilterEditorHeight(int filterEditorHeight) {
        setAttribute("filterEditorHeight", filterEditorHeight, true);
    }

    /**
     * Height for the filterEditor, if shown.
     *
     *
     * @return int
     */
    public int getFilterEditorHeight()  {
        return getAttributeAsInt("filterEditorHeight");
    }

    /**
     * If we're showing the filterEditor (this.showFilterEditor is true), this property  determines whether this list should be
     * filtered every time the user modifies the value in a field of the filter-editor. Can also be set at the field level.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param filterOnKeypress filterOnKeypress Default value is null
     */
    public void setFilterOnKeypress(Boolean filterOnKeypress) {
        setAttribute("filterOnKeypress", filterOnKeypress, true);
    }

    /**
     * If we're showing the filterEditor (this.showFilterEditor is true), this property  determines whether this list should be
     * filtered every time the user modifies the value in a field of the filter-editor. Can also be set at the field level.
     *
     *
     * @return Boolean
     */
    public Boolean getFilterOnKeypress()  {
        return getAttributeAsBoolean("filterOnKeypress");
    }

    /**
     * Should we horizontally clip cell contents, or allow columns to expand horizontally to show all contents? <P> If we allow
     * columns to expand, the column width is treated as a minimum. <P> NOTE: the header does not automatically respond to
     * expanded field widths
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param fixedFieldWidths fixedFieldWidths Default value is true
     */
    public void setFixedFieldWidths(Boolean fixedFieldWidths) {
        setAttribute("fixedFieldWidths", fixedFieldWidths, true);
    }

    /**
     * Should we horizontally clip cell contents, or allow columns to expand horizontally to show all contents? <P> If we allow
     * columns to expand, the column width is treated as a minimum. <P> NOTE: the header does not automatically respond to
     * expanded field widths
     *
     *
     * @return Boolean
     */
    public Boolean getFixedFieldWidths()  {
        return getAttributeAsBoolean("fixedFieldWidths");
    }

    /**
     * Should we vertically clip cell contents, or allow rows to expand vertically to show all contents? <P> If we allow rows
     * to expand, the row height as derived from {@link com.smartgwt.client.grid.GridRenderer#getRowHeight getRowHeight()} or
     * the default {@link com.smartgwt.client.widgets.grid.ListGrid#getCellHeight cellHeight} is treated as a minimum. <P>
     * <b>NOTE:</b> by default, for performance reasons, clipping is not enforced for some kinds of content (such as images) on
     * all browsers.  Set {@link com.smartgwt.client.widgets.grid.ListGrid#getEnforceVClipping enforceVClipping:true} to
     * enforce clipping for all types of content on all browsers.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param fixedRecordHeights fixedRecordHeights Default value is true
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_autofit_values" target="examples">Cell Values Example</a>
     */
    public void setFixedRecordHeights(Boolean fixedRecordHeights) {
        setAttribute("fixedRecordHeights", fixedRecordHeights, true);
    }

    /**
     * Should we vertically clip cell contents, or allow rows to expand vertically to show all contents? <P> If we allow rows
     * to expand, the row height as derived from {@link com.smartgwt.client.grid.GridRenderer#getRowHeight getRowHeight()} or
     * the default {@link com.smartgwt.client.widgets.grid.ListGrid#getCellHeight cellHeight} is treated as a minimum. <P>
     * <b>NOTE:</b> by default, for performance reasons, clipping is not enforced for some kinds of content (such as images) on
     * all browsers.  Set {@link com.smartgwt.client.widgets.grid.ListGrid#getEnforceVClipping enforceVClipping:true} to
     * enforce clipping for all types of content on all browsers.
     *
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_autofit_values" target="examples">Cell Values Example</a>
     */
    public Boolean getFixedRecordHeights()  {
        return getAttributeAsBoolean("fixedRecordHeights");
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields this.canFreezeFields} is true, this string
     * will be shown as the title for the menu item to freeze a currently unfrozen field. <P> This is a dynamic string - text
     * within <code>\${...}</code> will be evaluated as JS code when the message is displayed, with <code>title</code>
     * available as a variable containing the field title. <P> Default value returns "Freeze " + the field's summary title.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param freezeFieldText freezeFieldText Default value is "Freeze \${title}"
     */
    public void setFreezeFieldText(String freezeFieldText) {
        setAttribute("freezeFieldText", freezeFieldText, true);
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields this.canFreezeFields} is true, this string
     * will be shown as the title for the menu item to freeze a currently unfrozen field. <P> This is a dynamic string - text
     * within <code>\${...}</code> will be evaluated as JS code when the message is displayed, with <code>title</code>
     * available as a variable containing the field title. <P> Default value returns "Freeze " + the field's summary title.
     *
     *
     * @return String
     */
    public String getFreezeFieldText()  {
        return getAttributeAsString("freezeFieldText");
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields this.canFreezeFields} is true, this string
     * will be shown as the title for the menu item to freeze fields on the left of the scrollable body.
     *
     * @param freezeOnLeftText freezeOnLeftText Default value is "Freeze on left"
     */
    public void setFreezeOnLeftText(String freezeOnLeftText) {
        setAttribute("freezeOnLeftText", freezeOnLeftText, true);
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields this.canFreezeFields} is true, this string
     * will be shown as the title for the menu item to freeze fields on the left of the scrollable body.
     *
     *
     * @return String
     */
    public String getFreezeOnLeftText()  {
        return getAttributeAsString("freezeOnLeftText");
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields this.canFreezeFields} is true, this string
     * will be shown as the title for the menu item to freeze fields on the right of the scrollable body.
     *
     * @param freezeOnRightText freezeOnRightText Default value is "Freeze on right"
     */
    public void setFreezeOnRightText(String freezeOnRightText) {
        setAttribute("freezeOnRightText", freezeOnRightText, true);
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields this.canFreezeFields} is true, this string
     * will be shown as the title for the menu item to freeze fields on the right of the scrollable body.
     *
     *
     * @return String
     */
    public String getFreezeOnRightText()  {
        return getAttributeAsString("freezeOnRightText");
    }

    /**
     * If this listGrid contains any frozen fields, this property can be used to apply a custom baseStyle to all cells in those
     * frozen fields. If unset, the standard base style will be used for both frozen and unfrozen cells.
     *
     * @param frozenBaseStyle frozenBaseStyle Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setBaseStyle
     * @see com.smartgwt.client.widgets.grid.ListGridField#setFrozen
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setFrozenBaseStyle(String frozenBaseStyle) {
        setAttribute("frozenBaseStyle", frozenBaseStyle, true);
    }

    /**
     * If this listGrid contains any frozen fields, this property can be used to apply a custom baseStyle to all cells in those
     * frozen fields. If unset, the standard base style will be used for both frozen and unfrozen cells.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle
     * @see com.smartgwt.client.widgets.grid.ListGridField#getFrozen
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getFrozenBaseStyle()  {
        return getAttributeAsString("frozenBaseStyle");
    }

    /**
     * If this listGrid contains any frozen fields, this property can be used to apply a custom headerBaseStyle to the frozen
     * set of fields. If unset, the standard headerBaseStyle will be used for both frozen and unfrozen cells.
     *
     * @param frozenHeaderBaseStyle frozenHeaderBaseStyle Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.grid.ListGrid#setHeaderBaseStyle
     * @see com.smartgwt.client.widgets.grid.ListGridField#setFrozen
     * @see com.smartgwt.client.docs.GridHeader GridHeader overview and related methods
     */
    public void setFrozenHeaderBaseStyle(String frozenHeaderBaseStyle)  throws IllegalStateException {
        setAttribute("frozenHeaderBaseStyle", frozenHeaderBaseStyle, false);
    }

    /**
     * If this listGrid contains any frozen fields, this property can be used to apply a custom headerBaseStyle to the frozen
     * set of fields. If unset, the standard headerBaseStyle will be used for both frozen and unfrozen cells.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getHeaderBaseStyle
     * @see com.smartgwt.client.widgets.grid.ListGridField#getFrozen
     * @see com.smartgwt.client.docs.GridHeader GridHeader overview and related methods
     */
    public String getFrozenHeaderBaseStyle()  {
        return getAttributeAsString("frozenHeaderBaseStyle");
    }

    /**
     * If this listGrid contains any frozen fields, this property can be used to apply a custom headerTitleStyle to the frozen
     * set of fields. If unset, the standard headerTitleStyle will be used for both frozen and unfrozen cells.
     *
     * @param frozenHeaderTitleStyle frozenHeaderTitleStyle Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.grid.ListGrid#setHeaderTitleStyle
     * @see com.smartgwt.client.widgets.grid.ListGridField#setFrozen
     * @see com.smartgwt.client.docs.GridHeader GridHeader overview and related methods
     */
    public void setFrozenHeaderTitleStyle(String frozenHeaderTitleStyle)  throws IllegalStateException {
        setAttribute("frozenHeaderTitleStyle", frozenHeaderTitleStyle, false);
    }

    /**
     * If this listGrid contains any frozen fields, this property can be used to apply a custom headerTitleStyle to the frozen
     * set of fields. If unset, the standard headerTitleStyle will be used for both frozen and unfrozen cells.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getHeaderTitleStyle
     * @see com.smartgwt.client.widgets.grid.ListGridField#getFrozen
     * @see com.smartgwt.client.docs.GridHeader GridHeader overview and related methods
     */
    public String getFrozenHeaderTitleStyle()  {
        return getAttributeAsString("frozenHeaderTitleStyle");
    }

    /**
     * If true, when the user navigates to a cell using arrow keys and hits Enter,  the cell will respond to a click event.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param generateClickOnEnter generateClickOnEnter Default value is false
     */
    public void setGenerateClickOnEnter(Boolean generateClickOnEnter) {
        setAttribute("generateClickOnEnter", generateClickOnEnter, true);
    }

    /**
     * If true, when the user navigates to a cell using arrow keys and hits Enter,  the cell will respond to a click event.
     *
     *
     * @return Boolean
     */
    public Boolean getGenerateClickOnEnter()  {
        return getAttributeAsBoolean("generateClickOnEnter");
    }

    /**
     * If true, when the user navigates to a cell using arrow keys and hits space,  the cell will respond to a click event.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param generateClickOnSpace generateClickOnSpace Default value is true
     */
    public void setGenerateClickOnSpace(Boolean generateClickOnSpace) {
        setAttribute("generateClickOnSpace", generateClickOnSpace, true);
    }

    /**
     * If true, when the user navigates to a cell using arrow keys and hits space,  the cell will respond to a click event.
     *
     *
     * @return Boolean
     */
    public Boolean getGenerateClickOnSpace()  {
        return getAttributeAsBoolean("generateClickOnSpace");
    }

    /**
     * If true, when the user navigates to a cell using arrow keys and hits Enter,  the cell will respond to a double click
     * event.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param generateDoubleClickOnEnter generateDoubleClickOnEnter Default value is true
     */
    public void setGenerateDoubleClickOnEnter(Boolean generateDoubleClickOnEnter) {
        setAttribute("generateDoubleClickOnEnter", generateDoubleClickOnEnter, true);
    }

    /**
     * If true, when the user navigates to a cell using arrow keys and hits Enter,  the cell will respond to a double click
     * event.
     *
     *
     * @return Boolean
     */
    public Boolean getGenerateDoubleClickOnEnter()  {
        return getAttributeAsBoolean("generateDoubleClickOnEnter");
    }

    /**
     * If true, when the user navigates to a cell using arrow keys and hits Space,  the cell will respond to a double click
     * event.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param generateDoubleClickOnSpace generateDoubleClickOnSpace Default value is false
     */
    public void setGenerateDoubleClickOnSpace(Boolean generateDoubleClickOnSpace) {
        setAttribute("generateDoubleClickOnSpace", generateDoubleClickOnSpace, true);
    }

    /**
     * If true, when the user navigates to a cell using arrow keys and hits Space,  the cell will respond to a double click
     * event.
     *
     *
     * @return Boolean
     */
    public Boolean getGenerateDoubleClickOnSpace()  {
        return getAttributeAsBoolean("generateDoubleClickOnSpace");
    }

    /**
     * Array of components that make up this grid. This array controls which standard and/or custom
     *  parts will be displayed within this ListGrid.
     *  <P>
     * ListGrid is a subclass of {@link com.smartgwt.client.widgets.layout.VLayout} and consists of a number of member
     * components. The
     *  standard set of members are automatically generated by the grid, and include (for example)
     *  the header (a Toolbar of buttons for each field) and the body
     *  (a GridRenderer displaying the actual data contained in the grid).<br>
     * The default value of <code>gridComponents</code> is an Array of {@link com.smartgwt.client.types.ListGridComponent}s
     * listing
     *  the standard components in their default order:
     *  
     *  <var class="SmartGwt">
     *  <pre>
     *     [ListGridComponent.FILTER_EDITOR, ListGridComponent.HEADER, ListGridComponent.BODY, 
     *      ListGridComponent.SUMMARY_ROW]
     *  </pre>
     *  </var>
     * 
     *  You can override <code>gridComponents</code> to change the order of standard components.
     *  You can also omit standard components this way, although it more efficient to
     * use the related "show" property if available (eg {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor
     * showFilterEditor}). Note that
     *  this array must contain an entry for the <code>"body"</code> - listGrids with no body showing
     *  are unsupported.<br>
     *  <i>Advanced note:</i> The live components generated for each of these standard 
     *  {@link com.smartgwt.client.types.ListGridComponent} types may differ across different listGrids. For example if this
     * grid has any {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen fields}, the "body" entry will
     * actually
     *  be created as an HLayout containing two GridRenderers (one for frozen fields, 
     *  and one for unfrozen fields). This is really an implementation detail - the "body" entry
     *  in the gridComponents array simply specifies where the UI for the body should render within
     *  the ListGrid layout. 
     *  <P>
     *  By embedding a Canvas directly in this list you can add arbitrary additional components to the
     *  listGrid as members, and have them be displayed alongside the standard automatically generated
     *  parts of the ListGrid. 
     *  <P>
     *  Note that having added controls to gridComponents, you can still call APIs directly on
     *  those controls to change their appearance, and you can also show() and hide() them if
     *  they should not be shown in some circumstances.
     *  <P>
     *  Tip: custom controls need to set layoutAlign:"center" to appear vertically centered.
     *
     * @param gridComponents gridComponents Default value is (see below)
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGridComponents(ListGridComponent... gridComponents)  throws IllegalStateException {
        setAttribute("gridComponents", gridComponents, false);
    }

    /**
     * Array of components that make up this grid. This array controls which standard and/or custom
     *  parts will be displayed within this ListGrid.
     *  <P>
     * ListGrid is a subclass of {@link com.smartgwt.client.widgets.layout.VLayout} and consists of a number of member
     * components. The
     *  standard set of members are automatically generated by the grid, and include (for example)
     *  the header (a Toolbar of buttons for each field) and the body
     *  (a GridRenderer displaying the actual data contained in the grid).<br>
     * The default value of <code>gridComponents</code> is an Array of {@link com.smartgwt.client.types.ListGridComponent}s
     * listing
     *  the standard components in their default order:
     *  
     *  <var class="SmartGwt">
     *  <pre>
     *     [ListGridComponent.FILTER_EDITOR, ListGridComponent.HEADER, ListGridComponent.BODY, 
     *      ListGridComponent.SUMMARY_ROW]
     *  </pre>
     *  </var>
     * 
     *  You can override <code>gridComponents</code> to change the order of standard components.
     *  You can also omit standard components this way, although it more efficient to
     * use the related "show" property if available (eg {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor
     * showFilterEditor}). Note that
     *  this array must contain an entry for the <code>"body"</code> - listGrids with no body showing
     *  are unsupported.<br>
     *  <i>Advanced note:</i> The live components generated for each of these standard 
     *  {@link com.smartgwt.client.types.ListGridComponent} types may differ across different listGrids. For example if this
     * grid has any {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen fields}, the "body" entry will
     * actually
     *  be created as an HLayout containing two GridRenderers (one for frozen fields, 
     *  and one for unfrozen fields). This is really an implementation detail - the "body" entry
     *  in the gridComponents array simply specifies where the UI for the body should render within
     *  the ListGrid layout. 
     *  <P>
     *  By embedding a Canvas directly in this list you can add arbitrary additional components to the
     *  listGrid as members, and have them be displayed alongside the standard automatically generated
     *  parts of the ListGrid. 
     *  <P>
     *  Note that having added controls to gridComponents, you can still call APIs directly on
     *  those controls to change their appearance, and you can also show() and hide() them if
     *  they should not be shown in some circumstances.
     *  <P>
     *  Tip: custom controls need to set layoutAlign:"center" to appear vertically centered.
     *
     *
     * @return ListGridComponent
     */
    public ListGridComponent[] getGridComponents()  {
        return (ListGridComponent[]) EnumUtil.getEnums(ListGridComponent.values(), getAttributeAsStringArray("gridComponents"));
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} is true, this attribute will be
     * set to true on the record object representing the grid summary row.
     *
     * @param gridSummaryRecordProperty gridSummaryRecordProperty Default value is "isGridSummary"
     */
    public void setGridSummaryRecordProperty(String gridSummaryRecordProperty) {
        setAttribute("gridSummaryRecordProperty", gridSummaryRecordProperty, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} is true, this attribute will be
     * set to true on the record object representing the grid summary row.
     *
     *
     * @return String
     */
    public String getGridSummaryRecordProperty()  {
        return getAttributeAsString("gridSummaryRecordProperty");
    }

    /**
     * If this grid is {@link com.smartgwt.client.widgets.grid.ListGrid#getGroupByField grouped}, and  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true, this attribute may be set to an
     * array of groupBy field names for which group summaries should appear. <P> This is particularly useful for listGrids
     * grouped by more than one field as it allows developers to display the group summary for a particular nested group
     * without showing a summary for every level of the tree.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param groupByFieldSummaries groupByFieldSummaries Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setShowGroupSummary
     */
    public void setGroupByFieldSummaries(String... groupByFieldSummaries) {
        setAttribute("groupByFieldSummaries", groupByFieldSummaries, true);
    }

    /**
     * If this grid is {@link com.smartgwt.client.widgets.grid.ListGrid#getGroupByField grouped}, and  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true, this attribute may be set to an
     * array of groupBy field names for which group summaries should appear. <P> This is particularly useful for listGrids
     * grouped by more than one field as it allows developers to display the group summary for a particular nested group
     * without showing a summary for every level of the tree.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary
     */
    public String[] getGroupByFieldSummaries()  {
        return getAttributeAsStringArray("groupByFieldSummaries");
    }

    /**
     * Maximum number of records to which a groupBy can be applied. If there are more records, grouping will not be available
     * via the default header context menu, and calls to  {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy
     * ListGrid.groupBy} will be ignored. <P> The maximum exists because ListGrid grouping is performed in-browser, hence
     * requires loading of all records that match the current filter criteria before records can be grouped.  The default
     * maximum represents a number of records which are safe to load in legacy browsers such as Internet Explorer 8 (modern
     * browsers can handle far more), and is also a good upper limit from the perspective of loading data from a database. <P>
     * Going beyond this limit can cause "script running slowly" errors from legacy browsers (as well as high database load). 
     * To build an interface for grouping that handles arbitrary data volume, use a TreeGrid with {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand loadDataOnDemand} with server-side grouping code.
     *
     * @param groupByMaxRecords groupByMaxRecords Default value is 1000
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public void setGroupByMaxRecords(int groupByMaxRecords) {
        setAttribute("groupByMaxRecords", groupByMaxRecords, true);
    }

    /**
     * Maximum number of records to which a groupBy can be applied. If there are more records, grouping will not be available
     * via the default header context menu, and calls to  {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy
     * ListGrid.groupBy} will be ignored. <P> The maximum exists because ListGrid grouping is performed in-browser, hence
     * requires loading of all records that match the current filter criteria before records can be grouped.  The default
     * maximum represents a number of records which are safe to load in legacy browsers such as Internet Explorer 8 (modern
     * browsers can handle far more), and is also a good upper limit from the perspective of loading data from a database. <P>
     * Going beyond this limit can cause "script running slowly" errors from legacy browsers (as well as high database load). 
     * To build an interface for grouping that handles arbitrary data volume, use a TreeGrid with {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand loadDataOnDemand} with server-side grouping code.
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public int getGroupByMaxRecords()  {
        return getAttributeAsInt("groupByMaxRecords");
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy this.canGroupBy} is true, this string will be
     * shown as the title for the menu item to toggle the group by setting for a field. <P> This is a dynamic string - text
     * within <code>\${...}</code> will be evaluated as JS code when the message is displayed, with <code>title</code>
     * available as a variable containing the field title. <P> Default value returns "Group by " + the field's summary title.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param groupByText groupByText Default value is "Group by \${title}"
     */
    public void setGroupByText(String groupByText) {
        setAttribute("groupByText", groupByText, true);
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy this.canGroupBy} is true, this string will be
     * shown as the title for the menu item to toggle the group by setting for a field. <P> This is a dynamic string - text
     * within <code>\${...}</code> will be evaluated as JS code when the message is displayed, with <code>title</code>
     * available as a variable containing the field title. <P> Default value returns "Group by " + the field's summary title.
     *
     *
     * @return If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy this.canGroupBy} is true, this string will be
     * shown as the title for the menu item to toggle the group by setting for a field.<br> Default implementation evaluates
     * and returns the dynamic {@link com.smartgwt.client.widgets.grid.ListGrid#getGroupByText groupByText} string.
     */
    public String getGroupByText()  {
        return getAttributeAsString("groupByText");
    }

    /**
     * The URL of the base icon for the group icons in this treegrid.
     *
     * @param groupIcon groupIcon Default value is "[SKINIMG]/TreeGrid/opener.gif"
     */
    public void setGroupIcon(String groupIcon) {
        setAttribute("groupIcon", groupIcon, true);
    }

    /**
     * The URL of the base icon for the group icons in this treegrid.
     *
     *
     * @return String
     */
    public String getGroupIcon()  {
        return getAttributeAsString("groupIcon");
    }

    /**
     * Default width and height of group icons for this ListGrid.
     *
     * @param groupIconSize groupIconSize Default value is 16
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public void setGroupIconSize(int groupIconSize) {
        setAttribute("groupIconSize", groupIconSize, true);
    }

    /**
     * Default width and height of group icons for this ListGrid.
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public int getGroupIconSize()  {
        return getAttributeAsInt("groupIconSize");
    }

    /**
     * Default number of pixels by which to indent subgroups relative to parent group.
     *
     * @param groupIndentSize groupIndentSize Default value is 20
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     * @see com.smartgwt.client.widgets.grid.ListGrid#getGroupNodeHTML
     */
    public void setGroupIndentSize(int groupIndentSize) {
        setAttribute("groupIndentSize", groupIndentSize, true);
    }

    /**
     * Default number of pixels by which to indent subgroups relative to parent group.
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     * @see com.smartgwt.client.widgets.grid.ListGrid#getGroupNodeHTML
     */
    public int getGroupIndentSize()  {
        return getAttributeAsInt("groupIndentSize");
    }

    /**
     * Default number of pixels by which to indent all groups.
     *
     * @param groupLeadingIndent groupLeadingIndent Default value is 10
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     * @see com.smartgwt.client.widgets.grid.ListGrid#getGroupNodeHTML
     */
    public void setGroupLeadingIndent(int groupLeadingIndent) {
        setAttribute("groupLeadingIndent", groupLeadingIndent, true);
    }

    /**
     * Default number of pixels by which to indent all groups.
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     * @see com.smartgwt.client.widgets.grid.ListGrid#getGroupNodeHTML
     */
    public int getGroupLeadingIndent()  {
        return getAttributeAsInt("groupLeadingIndent");
    }

    /**
     * The CSS style that group rows will have
     *
     * @param groupNodeStyle groupNodeStyle Default value is "groupNode"
     */
    public void setGroupNodeStyle(String groupNodeStyle) {
        setAttribute("groupNodeStyle", groupNodeStyle, true);
    }

    /**
     * The CSS style that group rows will have
     *
     *
     * @return String
     */
    public String getGroupNodeStyle()  {
        return getAttributeAsString("groupNodeStyle");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true, this attribute will
     * be set to true on each record object representing a group-level summary row.
     *
     * @param groupSummaryRecordProperty groupSummaryRecordProperty Default value is "isGroupSummary"
     */
    public void setGroupSummaryRecordProperty(String groupSummaryRecordProperty) {
        setAttribute("groupSummaryRecordProperty", groupSummaryRecordProperty, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true, this attribute will
     * be set to true on each record object representing a group-level summary row.
     *
     *
     * @return String
     */
    public String getGroupSummaryRecordProperty()  {
        return getAttributeAsString("groupSummaryRecordProperty");
    }

    /**
     * {@link com.smartgwt.client.widgets.grid.ListGridRecord#getCustomStyle customStyle} for the group-level summary row
     * displayed when  {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true.
     *
     * @param groupSummaryStyle groupSummaryStyle Default value is "gridSummaryCell"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGroupSummaryStyle(String groupSummaryStyle)  throws IllegalStateException {
        setAttribute("groupSummaryStyle", groupSummaryStyle, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.grid.ListGridRecord#getCustomStyle customStyle} for the group-level summary row
     * displayed when  {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true.
     *
     *
     * @return String
     */
    public String getGroupSummaryStyle()  {
        return getAttributeAsString("groupSummaryStyle");
    }

    /**
     * Custom properties for the automatically generated <code>groupTitleColumn</code>. <P> See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupTitleColumn showGroupTitleColumn} for an overview of the
     * groupTitleColumn.
     *
     * @param groupTitleColumnProperties groupTitleColumnProperties Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGroupTitleColumnProperties(ListGridField groupTitleColumnProperties)  throws IllegalStateException {
        setAttribute("groupTitleColumnProperties", groupTitleColumnProperties.getJsObj(), false);
    }

    /**
     * Custom properties for the automatically generated <code>groupTitleColumn</code>. <P> See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupTitleColumn showGroupTitleColumn} for an overview of the
     * groupTitleColumn.
     *
     *
     * @return ListGridField
     */
    public ListGridField getGroupTitleColumnProperties()  {
        return new ListGridField(getAttributeAsJavaScriptObject("groupTitleColumnProperties"));
    }

    /**
     * When a list grid is {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy grouped}, each group shows under an auto
     * generated header node. By default the title of the group will be shown, with a hanging indent in this node, and will
     * span all columns in the grid. Setting this property causes the titles of auto-generated group nodes to appear as though
     * they were values of the designated field instead of spanning all columns and record values in the designated
     * groupTitleField will appear indented under  the group title in a manner similar to how a TreeGrid shows a Tree. <P> Note
     * if {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummaryInHeader showGroupSummaryInHeader} is true, the
     * header nodes will not show a single spanning title value by default - instead they will show the summary values for each
     * field. In this case, if groupTitleField is unset, a  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupTitleColumn groupTitleColumn} can be automatically generated to
     * show the title for each group.
     *
     * @param groupTitleField groupTitleField Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public void setGroupTitleField(String groupTitleField)  throws IllegalStateException {
        setAttribute("groupTitleField", groupTitleField, false);
    }

    /**
     * When a list grid is {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy grouped}, each group shows under an auto
     * generated header node. By default the title of the group will be shown, with a hanging indent in this node, and will
     * span all columns in the grid. Setting this property causes the titles of auto-generated group nodes to appear as though
     * they were values of the designated field instead of spanning all columns and record values in the designated
     * groupTitleField will appear indented under  the group title in a manner similar to how a TreeGrid shows a Tree. <P> Note
     * if {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummaryInHeader showGroupSummaryInHeader} is true, the
     * header nodes will not show a single spanning title value by default - instead they will show the summary values for each
     * field. In this case, if groupTitleField is unset, a  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupTitleColumn groupTitleColumn} can be automatically generated to
     * show the title for each group.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public String getGroupTitleField()  {
        return getAttributeAsString("groupTitleField");
    }

    /**
     * Event on a ListGrid header that triggers auto fitting to data and/or title. <P> Note that if sorting is enabled for the
     * field and the headerAutoFitEvent is "click", both sorting and autofit occur on a click.
     *
     * @param headerAutoFitEvent headerAutoFitEvent Default value is "doubleClick"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHeaderAutoFitEvent(AutoFitEvent headerAutoFitEvent)  throws IllegalStateException {
        setAttribute("headerAutoFitEvent", headerAutoFitEvent == null ? null : headerAutoFitEvent.getValue(), false);
    }

    /**
     * Event on a ListGrid header that triggers auto fitting to data and/or title. <P> Note that if sorting is enabled for the
     * field and the headerAutoFitEvent is "click", both sorting and autofit occur on a click.
     *
     *
     * @return AutoFitEvent
     */
    public AutoFitEvent getHeaderAutoFitEvent()  {
        return EnumUtil.getEnum(AutoFitEvent.values(), getAttribute("headerAutoFitEvent"));
    }

    /**
     * BackgroundColor for the header toolbar. Typically this is set to match the color of the header buttons.
     *
     * @param headerBackgroundColor headerBackgroundColor Default value is "#CCCCCC"
     * @see com.smartgwt.client.docs.GridHeader GridHeader overview and related methods
     */
    public void setHeaderBackgroundColor(String headerBackgroundColor) {
        setAttribute("headerBackgroundColor", headerBackgroundColor, true);
    }

    /**
     * BackgroundColor for the header toolbar. Typically this is set to match the color of the header buttons.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.GridHeader GridHeader overview and related methods
     */
    public String getHeaderBackgroundColor()  {
        return getAttributeAsString("headerBackgroundColor");
    }

    /**
     * Set the CSS style used for the header as a whole.
     *
     * @param headerBarStyle headerBarStyle Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.GridHeader GridHeader overview and related methods
     */
    public void setHeaderBarStyle(String headerBarStyle)  throws IllegalStateException {
        setAttribute("headerBarStyle", headerBarStyle, false);
    }

    /**
     * Set the CSS style used for the header as a whole.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.GridHeader GridHeader overview and related methods
     */
    public String getHeaderBarStyle()  {
        return getAttributeAsString("headerBarStyle");
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} to apply to the buttons in the header, and the sorter,
     * for  this ListGrid. Note that, depending on the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor Class} of the header buttons, you may also need to
     * set {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderTitleStyle headerTitleStyle}.
     *
     * @param headerBaseStyle headerBaseStyle Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.GridHeader GridHeader overview and related methods
     */
    public void setHeaderBaseStyle(String headerBaseStyle)  throws IllegalStateException {
        setAttribute("headerBaseStyle", headerBaseStyle, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} to apply to the buttons in the header, and the sorter,
     * for  this ListGrid. Note that, depending on the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor Class} of the header buttons, you may also need to
     * set {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderTitleStyle headerTitleStyle}.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.GridHeader GridHeader overview and related methods
     */
    public String getHeaderBaseStyle()  {
        return getAttributeAsString("headerBaseStyle");
    }

    /**
     * The height of this listGrid's header, in pixels.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Modify the height of a listGrid. To hide the header set height to zero.
     *
     * @param headerHeight new height for the header. Default value is 22
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public void setHeaderHeight(int headerHeight) {
        setAttribute("headerHeight", headerHeight, true);
    }

    /**
     * The height of this listGrid's header, in pixels.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public int getHeaderHeight()  {
        return getAttributeAsInt("headerHeight");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property
     * governs the height of the  auto-generated <code>headerMenuButton</code>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param headerMenuButtonHeight headerMenuButtonHeight Default value is "100%"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHeaderMenuButtonHeight(int headerMenuButtonHeight)  throws IllegalStateException {
        setAttribute("headerMenuButtonHeight", headerMenuButtonHeight, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property
     * governs the height of the  auto-generated <code>headerMenuButton</code>
     *
     *
     * @return int
     */
    public int getHeaderMenuButtonHeight()  {
        return getAttributeAsInt("headerMenuButtonHeight");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property
     * governs the icon shown on the auto-generated <code>headerMenuButton</code>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param headerMenuButtonIcon headerMenuButtonIcon Default value is "[SKIN]/ListGrid/sort_descending.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHeaderMenuButtonIcon(String headerMenuButtonIcon)  throws IllegalStateException {
        setAttribute("headerMenuButtonIcon", headerMenuButtonIcon, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property
     * governs the icon shown on the auto-generated <code>headerMenuButton</code>
     *
     *
     * @return String
     */
    public String getHeaderMenuButtonIcon()  {
        return getAttributeAsString("headerMenuButtonIcon");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property
     * governs the height of the icon shown on the auto-generated <code>headerMenuButton</code>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param headerMenuButtonIconHeight headerMenuButtonIconHeight Default value is 7
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHeaderMenuButtonIconHeight(int headerMenuButtonIconHeight)  throws IllegalStateException {
        setAttribute("headerMenuButtonIconHeight", headerMenuButtonIconHeight, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property
     * governs the height of the icon shown on the auto-generated <code>headerMenuButton</code>
     *
     *
     * @return int
     */
    public int getHeaderMenuButtonIconHeight()  {
        return getAttributeAsInt("headerMenuButtonIconHeight");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property
     * governs the width of the icon shown on the auto-generated <code>headerMenuButton</code>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param headerMenuButtonIconWidth headerMenuButtonIconWidth Default value is 7
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHeaderMenuButtonIconWidth(int headerMenuButtonIconWidth)  throws IllegalStateException {
        setAttribute("headerMenuButtonIconWidth", headerMenuButtonIconWidth, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property
     * governs the width of the icon shown on the auto-generated <code>headerMenuButton</code>
     *
     *
     * @return int
     */
    public int getHeaderMenuButtonIconWidth()  {
        return getAttributeAsInt("headerMenuButtonIconWidth");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property
     * governs the width of the  auto-generated <code>headerMenuButton</code>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param headerMenuButtonWidth headerMenuButtonWidth Default value is 16
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHeaderMenuButtonWidth(int headerMenuButtonWidth)  throws IllegalStateException {
        setAttribute("headerMenuButtonWidth", headerMenuButtonWidth, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property
     * governs the width of the  auto-generated <code>headerMenuButton</code>
     *
     *
     * @return int
     */
    public int getHeaderMenuButtonWidth()  {
        return getAttributeAsInt("headerMenuButtonWidth");
    }

    /**
     * Default height for a {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpan} with no height
     * specified. <P> If <code>headerSpanHeight</code> is not specified (the default), headerSpans will be 1/2 of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderHeight headerHeight}.
     *
     * @param headerSpanHeight headerSpanHeight Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHeaderSpanHeight(Integer headerSpanHeight)  throws IllegalStateException {
        setAttribute("headerSpanHeight", headerSpanHeight, false);
    }

    /**
     * Default height for a {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpan} with no height
     * specified. <P> If <code>headerSpanHeight</code> is not specified (the default), headerSpans will be 1/2 of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderHeight headerHeight}.
     *
     *
     * @return Integer
     */
    public Integer getHeaderSpanHeight()  {
        return getAttributeAsInt("headerSpanHeight");
    }

    /**
     * {@link com.smartgwt.client.widgets.StretchImgButton#getTitleStyle titleStyle} to apply to the buttons in the header, and
     * the sorter, for this ListGrid. Note that this will typically only have an effect if  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor headerButtonConstructor} is set to {@link
     * com.smartgwt.client.widgets.StretchImgButton} or a subclass  thereof.
     *
     * @param headerTitleStyle headerTitleStyle Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.GridHeader GridHeader overview and related methods
     */
    public void setHeaderTitleStyle(String headerTitleStyle)  throws IllegalStateException {
        setAttribute("headerTitleStyle", headerTitleStyle, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.StretchImgButton#getTitleStyle titleStyle} to apply to the buttons in the header, and
     * the sorter, for this ListGrid. Note that this will typically only have an effect if  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor headerButtonConstructor} is set to {@link
     * com.smartgwt.client.widgets.StretchImgButton} or a subclass  thereof.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.GridHeader GridHeader overview and related methods
     */
    public String getHeaderTitleStyle()  {
        return getAttributeAsString("headerTitleStyle");
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHoverComponents showHoverComponents()} is true, the builtin
     * mode to use when automatically creating a hover component for rows in this grid. <P> A number of builtin modes are
     * provided - see {@link com.smartgwt.client.types.HoverMode}.  You can also override {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCellHoverComponent getCellHoverComponent()} to provide a custom hover
     * widget - in that case, this attribute is ignored.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param hoverMode hoverMode Default value is null
     */
    public void setHoverMode(HoverMode hoverMode) {
        setAttribute("hoverMode", hoverMode == null ? null : hoverMode.getValue(), true);
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHoverComponents showHoverComponents()} is true, the builtin
     * mode to use when automatically creating a hover component for rows in this grid. <P> A number of builtin modes are
     * provided - see {@link com.smartgwt.client.types.HoverMode}.  You can also override {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCellHoverComponent getCellHoverComponent()} to provide a custom hover
     * widget - in that case, this attribute is ignored.
     *
     *
     * @return HoverMode
     */
    public HoverMode getHoverMode()  {
        return EnumUtil.getEnum(HoverMode.values(), getAttribute("hoverMode"));
    }

    /**
     * Style to apply to hovers shown over this grid.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param hoverStyle hoverStyle Default value is "gridHover"
     * @see com.smartgwt.client.widgets.grid.ListGrid#setShowHover
     */
    public void setHoverStyle(String hoverStyle) {
        setAttribute("hoverStyle", hoverStyle, true);
    }

    /**
     * Style to apply to hovers shown over this grid.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getShowHover
     */
    public String getHoverStyle()  {
        return getAttributeAsString("hoverStyle");
    }

    /**
     * Default size of thumbnails shown for fieldTypes image and imageFile.  Overrideable on a per-field basis via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getImageSize imageSize} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getImageWidth imageWidth}/{@link
     * com.smartgwt.client.widgets.grid.ListGridField#getImageHeight imageHeight}
     *
     * @param imageSize imageSize Default value is 16
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setImageSize(int imageSize) {
        setAttribute("imageSize", imageSize, true);
    }

    /**
     * Default size of thumbnails shown for fieldTypes image and imageFile.  Overrideable on a per-field basis via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getImageSize imageSize} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getImageWidth imageWidth}/{@link
     * com.smartgwt.client.widgets.grid.ListGridField#getImageHeight imageHeight}
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public int getImageSize()  {
        return getAttributeAsInt("imageSize");
    }

    /**
     * Property name on a record that will be checked to determine whether a record should be included when calculating totals
     * for the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary grid summary}.
     *
     * @param includeInSummaryProperty includeInSummaryProperty Default value is "includeInSummary"
     */
    public void setIncludeInSummaryProperty(String includeInSummaryProperty) {
        setAttribute("includeInSummaryProperty", includeInSummaryProperty, true);
    }

    /**
     * Property name on a record that will be checked to determine whether a record should be included when calculating totals
     * for the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary grid summary}.
     *
     *
     * @return String
     */
    public String getIncludeInSummaryProperty()  {
        return getAttributeAsString("includeInSummaryProperty");
    }

    /**
     * If true, if the user clicks on the scroll buttons at the end of the track or clicks once on the scroll track, there will
     * be an instant redraw of the grid content so that the user doesn't see any blank space.  For drag scrolling or other
     * types of scrolling, the +link{scrollRedrawDelay applies}.
     *
     * @param instantScrollTrackRedraw instantScrollTrackRedraw Default value is true
     */
    public void setInstantScrollTrackRedraw(Boolean instantScrollTrackRedraw) {
        setAttribute("instantScrollTrackRedraw", instantScrollTrackRedraw, true);
    }

    /**
     * If true, if the user clicks on the scroll buttons at the end of the track or clicks once on the scroll track, there will
     * be an instant redraw of the grid content so that the user doesn't see any blank space.  For drag scrolling or other
     * types of scrolling, the +link{scrollRedrawDelay applies}.
     *
     *
     * @return Boolean
     */
    public Boolean getInstantScrollTrackRedraw()  {
        return getAttributeAsBoolean("instantScrollTrackRedraw");
    }

    /**
     * Value to display to the user if showing summary values (through {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} or {@link
     * com.smartgwt.client.types.ListGridFieldType listGridFieldType:"summary"}), and the summary function returns
     * <code>"null"</code> (implying it was unable to calculate a valid summary value).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param invalidSummaryValue invalidSummaryValue Default value is "&amp;nbsp;"
     */
    public void setInvalidSummaryValue(String invalidSummaryValue) {
        setAttribute("invalidSummaryValue", invalidSummaryValue, true);
    }

    /**
     * Value to display to the user if showing summary values (through {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} or {@link
     * com.smartgwt.client.types.ListGridFieldType listGridFieldType:"summary"}), and the summary function returns
     * <code>"null"</code> (implying it was unable to calculate a valid summary value).
     *
     *
     * @return String
     */
    public String getInvalidSummaryValue()  {
        return getAttributeAsString("invalidSummaryValue");
    }


    /**
     * True if this listgrid is grouped, false otherwise
     *
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Boolean
     * @throws IllegalStateException if widget has not yet been rendered.
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public Boolean getIsGrouped() throws IllegalStateException {
        errorIfNotCreated("isGrouped");
        return getAttributeAsBoolean("isGrouped");
    }

    /**
     * If <code>record[this.isSeparatorProperty]</code> is set for some record, the  record will be displayed as a simple
     * separator row.
     *
     * @param isSeparatorProperty isSeparatorProperty Default value is "isSeparator"
     */
    public void setIsSeparatorProperty(String isSeparatorProperty) {
        setAttribute("isSeparatorProperty", isSeparatorProperty, true);
    }

    /**
     * If <code>record[this.isSeparatorProperty]</code> is set for some record, the  record will be displayed as a simple
     * separator row.
     *
     *
     * @return String
     */
    public String getIsSeparatorProperty()  {
        return getAttributeAsString("isSeparatorProperty");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, when
     * auto-fitting fields to  the title width via {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths
     * autoFitFieldWidths} or {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidth autoFitWidth},  should the
     * button be sized such that there is enough space for the heeader menu button to show without covering the field title?
     * <P> If not explicitly specified, this property will be treated as if set to false if  the field title is center aligned
     * otherwise true.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param leaveHeaderMenuButtonSpace leaveHeaderMenuButtonSpace Default value is null
     */
    public void setLeaveHeaderMenuButtonSpace(Boolean leaveHeaderMenuButtonSpace) {
        setAttribute("leaveHeaderMenuButtonSpace", leaveHeaderMenuButtonSpace, true);
    }

    /**
     * Whether to leave a gap for the vertical scrollbar, even when it's not present. <P> Note that if leaveScrollbarGap is
     * false and vertical scrolling is introduced, fields will be resized to fit the smaller body area if possible, in order to
     * avoid horizontal scrolling also being required.
     *
     * @param leaveScrollbarGap leaveScrollbarGap Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_autofit_rows" target="examples">Rows Example</a>
     */
    public void setLeaveScrollbarGap(Boolean leaveScrollbarGap) {
        setAttribute("leaveScrollbarGap", leaveScrollbarGap, true);
    }

    /**
     * Whether to leave a gap for the vertical scrollbar, even when it's not present. <P> Note that if leaveScrollbarGap is
     * false and vertical scrolling is introduced, fields will be resized to fit the smaller body area if possible, in order to
     * avoid horizontal scrolling also being required.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_autofit_rows" target="examples">Rows Example</a>
     */
    public Boolean getLeaveScrollbarGap()  {
        return getAttributeAsBoolean("leaveScrollbarGap");
    }

    /**
     * Property name on a record that will hold the link text for that record. <P> This property is configurable to avoid
     * possible collision with data values in the record. <P> Use {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getLinkTextProperty linkTextProperty} if you have more than one link
     * field and
     *
     * @param linkTextProperty linkTextProperty Default value is "linkText"
     * @see com.smartgwt.client.types.ListGridFieldType
     * @see com.smartgwt.client.types.FieldType
     * @see com.smartgwt.client.widgets.grid.ListGridField#setLinkText
     * @see com.smartgwt.client.widgets.grid.ListGridField#setLinkTextProperty
     */
    public void setLinkTextProperty(String linkTextProperty) {
        setAttribute("linkTextProperty", linkTextProperty, true);
    }

    /**
     * Property name on a record that will hold the link text for that record. <P> This property is configurable to avoid
     * possible collision with data values in the record. <P> Use {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getLinkTextProperty linkTextProperty} if you have more than one link
     * field and
     *
     *
     * @return String
     * @see com.smartgwt.client.types.ListGridFieldType
     * @see com.smartgwt.client.types.FieldType
     * @see com.smartgwt.client.widgets.grid.ListGridField#getLinkText
     * @see com.smartgwt.client.widgets.grid.ListGridField#getLinkTextProperty
     */
    public String getLinkTextProperty()  {
        return getAttributeAsString("linkTextProperty");
    }

    /**
     * If the user is editing the last record in this listGrid, and attempts to navigate  beyond the last row either by tabbing
     * off the last editable field, or using the down arrow key, this property determines what action to take:<ul> <li>"next":
     * start editing a new record at the end of the list. <li>"done": hide the editor <li>"stop": leave focus in the cell being
     * edited <li>"none": no action </ul>
     *
     * @param listEndEditAction listEndEditAction Default value is null
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_editing_new_row" target="examples">Enter new rows Example</a>
     */
    public void setListEndEditAction(RowEndEditAction listEndEditAction) {
        setAttribute("listEndEditAction", listEndEditAction == null ? null : listEndEditAction.getValue(), true);
    }

    /**
     * If the user is editing the last record in this listGrid, and attempts to navigate  beyond the last row either by tabbing
     * off the last editable field, or using the down arrow key, this property determines what action to take:<ul> <li>"next":
     * start editing a new record at the end of the list. <li>"done": hide the editor <li>"stop": leave focus in the cell being
     * edited <li>"none": no action </ul>
     *
     *
     * @return RowEndEditAction
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_editing_new_row" target="examples">Enter new rows Example</a>
     */
    public RowEndEditAction getListEndEditAction()  {
        return EnumUtil.getEnum(RowEndEditAction.values(), getAttribute("listEndEditAction"));
    }

    /**
     * The string to display in the body of a listGrid while data is being loaded. Use <code>"\${loadingImage}"</code> to
     * include {@link com.smartgwt.client.widgets.Canvas#loadingImageSrc a loading image}.
     *
     * @param loadingDataMessage loadingDataMessage Default value is "\${loadingImage}&amp;nbsp;Loading data..."
     * @see com.smartgwt.client.widgets.grid.ListGrid#setLoadingDataMessageStyle
     */
    public void setLoadingDataMessage(String loadingDataMessage) {
        setAttribute("loadingDataMessage", loadingDataMessage, true);
    }

    /**
     * The string to display in the body of a listGrid while data is being loaded. Use <code>"\${loadingImage}"</code> to
     * include {@link com.smartgwt.client.widgets.Canvas#loadingImageSrc a loading image}.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getLoadingDataMessageStyle
     */
    public String getLoadingDataMessage()  {
        return getAttributeAsString("loadingDataMessage");
    }

    /**
     * The CSS style name applied to the loadingDataMessage string if displayed.
     *
     * @param loadingDataMessageStyle loadingDataMessageStyle Default value is "loadingDataMessage"
     */
    public void setLoadingDataMessageStyle(String loadingDataMessageStyle) {
        setAttribute("loadingDataMessageStyle", loadingDataMessageStyle, true);
    }

    /**
     * The CSS style name applied to the loadingDataMessage string if displayed.
     *
     *
     * @return String
     */
    public String getLoadingDataMessageStyle()  {
        return getAttributeAsString("loadingDataMessageStyle");
    }

    /**
     * If you have a databound listGrid and you scroll out of the currently loaded dataset, by default you will see blank rows
     * until the server returns the data for those rows.  The loadingMessage attribute allows you to specify arbitrary html
     * that will be shown in each such "blank" record while the data for that record is loading.
     *
     * @param loadingMessage loadingMessage Default value is "&amp;nbsp;"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLoadingMessage(String loadingMessage)  throws IllegalStateException {
        setAttribute("loadingMessage", loadingMessage, false);
    }

    /**
     * If you have a databound listGrid and you scroll out of the currently loaded dataset, by default you will see blank rows
     * until the server returns the data for those rows.  The loadingMessage attribute allows you to specify arbitrary html
     * that will be shown in each such "blank" record while the data for that record is loading.
     *
     *
     * @return String
     */
    public String getLoadingMessage()  {
        return getAttributeAsString("loadingMessage");
    }

    /**
     * When  AutoTest.getElement is used to parse locator strings generated by link{isc.AutoTest.getLocator()} for a cell in
     * this grid, how should the column be identified? <br> Note that getLocator() will actually store all available
     * information about the column in the generated string -- this attribute effects how a stored string will be parsed only.
     * <P> Valid options area: <ul> <li><code>"fieldName"</code> Attempt to identify by fieldName.</li>
     * <li><code>"index"</code> Attempt to identify by colNum (index in the fields array).</li> </ul> If unset, default
     * behavior is to identify by fieldName (if available), otherwise by index.
     *
     * @param locateColumnsBy locateColumnsBy Default value is null
     */
    public void setLocateColumnsBy(String locateColumnsBy) {
        setAttribute("locateColumnsBy", locateColumnsBy, true);
    }

    /**
     * When  AutoTest.getElement is used to parse locator strings generated by link{isc.AutoTest.getLocator()} for a cell in
     * this grid, how should the column be identified? <br> Note that getLocator() will actually store all available
     * information about the column in the generated string -- this attribute effects how a stored string will be parsed only.
     * <P> Valid options area: <ul> <li><code>"fieldName"</code> Attempt to identify by fieldName.</li>
     * <li><code>"index"</code> Attempt to identify by colNum (index in the fields array).</li> </ul> If unset, default
     * behavior is to identify by fieldName (if available), otherwise by index.
     *
     *
     * @return String
     */
    public String getLocateColumnsBy()  {
        return getAttributeAsString("locateColumnsBy");
    }

    /**
     * When  AutoTest.getElement is used to parse locator strings generated by link{isc.AutoTest.getLocator()} for a cell in
     * this grid, how should the row be identified? <br> Note that getLocator() will actually store all available information
     * about the row in the generated string -- this attribute effects how a stored string will be parsed only. <P> Valid
     * options area: <ul> <li><code>"primaryKey"</code> Only applies to databound grids: If the cell in question has   a
     * primary key cell value, use it to identify cells in autoTest locator strings.</li> <li><code>"titleField"</code> If the
     * cell in question has a value for the   {@link com.smartgwt.client.widgets.grid.ListGrid#getTitleField titleField}, use
     * it to identify cells in autoTest  locator strings</li> <li><code>"targetCellValue"</code> Identify rows by storing the
     * cell value for the target  row / field in autoTest locator strings</li> <li><code>"index"</code>The rowNum will be used
     * to identify the row.</li> </ul> If unset, default behavior is to identify by primary key (if available), otherwise by
     * titleField (if available), otherwise by cell value (if available), and lastly by index.
     *
     * @param locateRowsBy locateRowsBy Default value is null
     */
    public void setLocateRowsBy(String locateRowsBy) {
        setAttribute("locateRowsBy", locateRowsBy, true);
    }

    /**
     * When  AutoTest.getElement is used to parse locator strings generated by link{isc.AutoTest.getLocator()} for a cell in
     * this grid, how should the row be identified? <br> Note that getLocator() will actually store all available information
     * about the row in the generated string -- this attribute effects how a stored string will be parsed only. <P> Valid
     * options area: <ul> <li><code>"primaryKey"</code> Only applies to databound grids: If the cell in question has   a
     * primary key cell value, use it to identify cells in autoTest locator strings.</li> <li><code>"titleField"</code> If the
     * cell in question has a value for the   {@link com.smartgwt.client.widgets.grid.ListGrid#getTitleField titleField}, use
     * it to identify cells in autoTest  locator strings</li> <li><code>"targetCellValue"</code> Identify rows by storing the
     * cell value for the target  row / field in autoTest locator strings</li> <li><code>"index"</code>The rowNum will be used
     * to identify the row.</li> </ul> If unset, default behavior is to identify by primary key (if available), otherwise by
     * titleField (if available), otherwise by cell value (if available), and lastly by index.
     *
     *
     * @return String
     */
    public String getLocateRowsBy()  {
        return getAttributeAsString("locateRowsBy");
    }

    /**
     * When the length of the field specified by {@link com.smartgwt.client.data.DataSourceField#getLength length} exceeds this
     * value, the ListGrid shows an edit field of type {@link com.smartgwt.client.widgets.grid.ListGrid#getLongTextEditorType
     * longTextEditorType} rather than the standard text field when the field enters inline edit mode.
     *
     * @param longTextEditorThreshold longTextEditorThreshold Default value is 255
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setLongTextEditorThreshold(int longTextEditorThreshold) {
        setAttribute("longTextEditorThreshold", longTextEditorThreshold, true);
    }

    /**
     * When the length of the field specified by {@link com.smartgwt.client.data.DataSourceField#getLength length} exceeds this
     * value, the ListGrid shows an edit field of type {@link com.smartgwt.client.widgets.grid.ListGrid#getLongTextEditorType
     * longTextEditorType} rather than the standard text field when the field enters inline edit mode.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public int getLongTextEditorThreshold()  {
        return getAttributeAsInt("longTextEditorThreshold");
    }

    /**
     * When the length of the field specified by {@link com.smartgwt.client.data.DataSourceField#getLength length} exceeds 
     * <code>this.longTextEditorThreshold</code> show an edit field of this type rather than the standard text field when the
     * field enters inline edit mode.
     *
     * @param longTextEditorType longTextEditorType Default value is "PopUpTextAreaItem"
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setLongTextEditorType(String longTextEditorType) {
        setAttribute("longTextEditorType", longTextEditorType, true);
    }

    /**
     * When the length of the field specified by {@link com.smartgwt.client.data.DataSourceField#getLength length} exceeds 
     * <code>this.longTextEditorThreshold</code> show an edit field of this type rather than the standard text field when the
     * field enters inline edit mode.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public String getLongTextEditorType()  {
        return getAttributeAsString("longTextEditorType");
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanExpandMultipleRecords canExpandMultipleRecords} are both true, this
     * property dictates the number of records which can be expanded simultaneously.  If the expanded record count hits the
     * value of this property, further attempts to expand records will result in a popup warning (see {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getMaxExpandedRecordsPrompt maxExpandedRecordsPrompt}) and expansion will be
     * cancelled. <P> The default value is null, meaning there is no limit on the number of expanded records.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maxExpandedRecords maxExpandedRecords Default value is null
     */
    public void setMaxExpandedRecords(Integer maxExpandedRecords) {
        setAttribute("maxExpandedRecords", maxExpandedRecords, true);
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanExpandMultipleRecords canExpandMultipleRecords} are both true, this
     * property dictates the number of records which can be expanded simultaneously.  If the expanded record count hits the
     * value of this property, further attempts to expand records will result in a popup warning (see {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getMaxExpandedRecordsPrompt maxExpandedRecordsPrompt}) and expansion will be
     * cancelled. <P> The default value is null, meaning there is no limit on the number of expanded records.
     *
     *
     * @return Integer
     */
    public Integer getMaxExpandedRecords()  {
        return getAttributeAsInt("maxExpandedRecords");
    }

    /**
     * This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code when the message is displayed.
     * Note that the local variable <code>count</code> will be available and set to this.maxExpandedRecords. The string will be
     * executed in the scope of the ListGrid so <code>this</code> may also be used to determine other information about this
     * grid. <P> Default value returns <P> <code> <i>This grid is limited to <code>[{@link
     * com.smartgwt.client.widgets.grid.ListGrid#getMaxExpandedRecords maxExpandedRecords}]</code> simultaneously  expanded
     * records.  Please collapse some expanded records and retry.</i> </code>
     *
     * @param maxExpandedRecordsPrompt maxExpandedRecordsPrompt Default value is "This grid is limited to \${count} simultaneously expanded records.  Please collapse some expanded records and retry."
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMaxExpandedRecordsPrompt(String maxExpandedRecordsPrompt)  throws IllegalStateException {
        setAttribute("maxExpandedRecordsPrompt", maxExpandedRecordsPrompt, false);
    }

    /**
     * This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code when the message is displayed.
     * Note that the local variable <code>count</code> will be available and set to this.maxExpandedRecords. The string will be
     * executed in the scope of the ListGrid so <code>this</code> may also be used to determine other information about this
     * grid. <P> Default value returns <P> <code> <i>This grid is limited to <code>[{@link
     * com.smartgwt.client.widgets.grid.ListGrid#getMaxExpandedRecords maxExpandedRecords}]</code> simultaneously  expanded
     * records.  Please collapse some expanded records and retry.</i> </code>
     *
     *
     * @return String
     */
    public String getMaxExpandedRecordsPrompt()  {
        return getAttributeAsString("maxExpandedRecordsPrompt");
    }

    /**
     * Minimum size, in pixels, for ListGrid headers.
     *
     * @param minFieldWidth minFieldWidth Default value is 15
     */
    public void setMinFieldWidth(int minFieldWidth) {
        setAttribute("minFieldWidth", minFieldWidth, true);
    }

    /**
     * Minimum size, in pixels, for ListGrid headers.
     *
     *
     * @return int
     */
    public int getMinFieldWidth()  {
        return getAttributeAsInt("minFieldWidth");
    }

    /**
     * If this property is true, any mouse click outside of the open cell editors      will end editing mode, hiding the cell
     * editors and saving any changes to those      cell values.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param modalEditing modalEditing Default value is null
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_editing_modal" target="examples">Modal editing Example</a>
     */
    public void setModalEditing(Boolean modalEditing) {
        setAttribute("modalEditing", modalEditing, true);
    }

    /**
     * If this property is true, any mouse click outside of the open cell editors      will end editing mode, hiding the cell
     * editors and saving any changes to those      cell values.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_editing_modal" target="examples">Modal editing Example</a>
     */
    public Boolean getModalEditing()  {
        return getAttributeAsBoolean("modalEditing");
    }

    /**
     * If true, validation will not occur as a result of cell editing for this grid.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param neverValidate neverValidate Default value is null
     * @see com.smartgwt.client.docs.GridValidation GridValidation overview and related methods
     */
    public void setNeverValidate(Boolean neverValidate) {
        setAttribute("neverValidate", neverValidate, true);
    }

    /**
     * If true, validation will not occur as a result of cell editing for this grid.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.GridValidation GridValidation overview and related methods
     */
    public Boolean getNeverValidate()  {
        return getAttributeAsBoolean("neverValidate");
    }

    /**
     * "Normal" baseStyle for this listGrid. Only applies if {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle
     * baseStyle} is  set to null. <P> If <code>baseStyle</code> is unset, this property will be used as a base cell style if
     * the grid is showing fixed height rows, and the specified cellHeight matches {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getNormalCellHeight normalCellHeight} (and in Internet Explorer, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFastCellUpdates fastCellUpdates} is false). Otherwise {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getTallBaseStyle tallBaseStyle} will be used. <P> Having separate styles
     * defined for fixed vs. variable height rows allows the developer to specify css which is designed to render at a specific
     * height (typically using background images, which won't scale), without breaking support for styling rows of variable
     * height.
     *
     * @param normalBaseStyle normalBaseStyle Default value is "cell"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle
     */
    public void setNormalBaseStyle(String normalBaseStyle)  throws IllegalStateException {
        setAttribute("normalBaseStyle", normalBaseStyle, false);
    }

    /**
     * "Normal" baseStyle for this listGrid. Only applies if {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle
     * baseStyle} is  set to null. <P> If <code>baseStyle</code> is unset, this property will be used as a base cell style if
     * the grid is showing fixed height rows, and the specified cellHeight matches {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getNormalCellHeight normalCellHeight} (and in Internet Explorer, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFastCellUpdates fastCellUpdates} is false). Otherwise {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getTallBaseStyle tallBaseStyle} will be used. <P> Having separate styles
     * defined for fixed vs. variable height rows allows the developer to specify css which is designed to render at a specific
     * height (typically using background images, which won't scale), without breaking support for styling rows of variable
     * height.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle
     */
    public String getNormalBaseStyle()  {
        return getAttributeAsString("normalBaseStyle");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle} is unset, base style will be derived from 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getNormalBaseStyle normalBaseStyle} if this grid has fixed row heights
     * and  the specified {@link com.smartgwt.client.widgets.grid.ListGrid#getCellHeight cellHeight} matches this value.
     * Otherwise {@link com.smartgwt.client.widgets.grid.ListGrid#getTallBaseStyle tallBaseStyle} will be used.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param normalCellHeight normalCellHeight Default value is 20
     */
    public void setNormalCellHeight(int normalCellHeight) {
        setAttribute("normalCellHeight", normalCellHeight, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle} is unset, base style will be derived from 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getNormalBaseStyle normalBaseStyle} if this grid has fixed row heights
     * and  the specified {@link com.smartgwt.client.widgets.grid.ListGrid#getCellHeight cellHeight} matches this value.
     * Otherwise {@link com.smartgwt.client.widgets.grid.ListGrid#getTallBaseStyle tallBaseStyle} will be used.
     *
     *
     * @return int
     */
    public int getNormalCellHeight()  {
        return getAttributeAsInt("normalCellHeight");
    }

    /**
     * Default alias to use for groups with no value
     *
     * @param nullGroupTitle nullGroupTitle Default value is '-none-'
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public void setNullGroupTitle(String nullGroupTitle) {
        setAttribute("nullGroupTitle", nullGroupTitle, true);
    }

    /**
     * Default alias to use for groups with no value
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public String getNullGroupTitle()  {
        return getAttributeAsString("nullGroupTitle");
    }

    /**
     * The CSS style name applied to the {@link com.smartgwt.client.widgets.grid.ListGrid#getOfflineMessage offlineMessage} if
     * displayed.
     *
     * @param offlineMessageStyle offlineMessageStyle Default value is "offlineMessage"
     */
    public void setOfflineMessageStyle(String offlineMessageStyle) {
        setAttribute("offlineMessageStyle", offlineMessageStyle, true);
    }

    /**
     * The CSS style name applied to the {@link com.smartgwt.client.widgets.grid.ListGrid#getOfflineMessage offlineMessage} if
     * displayed.
     *
     *
     * @return String
     */
    public String getOfflineMessageStyle()  {
        return getAttributeAsString("offlineMessageStyle");
    }

    /**
     * Should recycled {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents record components}, be pooled
     * per column or per record. Only applies if {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponentsByCell
     * showRecordComponentsByCell} is true. <P> When {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordComponentPoolingMode recordComponentPoolingMode} is "recycle" and you
     * have components of  different types in different columns, set this property to true to ensure that  components intended
     * for one column are not recycled for use in another column that  should have a different component. <P> If no components
     * applicable to a particular column are available in the pool, the system calls {@link
     * com.smartgwt.client.widgets.grid.ListGrid#createRecordComponent createRecordComponent}.
     *
     * @param poolComponentsPerColumn poolComponentsPerColumn Default value is true
     */
    public void setPoolComponentsPerColumn(Boolean poolComponentsPerColumn) {
        setAttribute("poolComponentsPerColumn", poolComponentsPerColumn, true);
    }

    /**
     * Should recycled {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents record components}, be pooled
     * per column or per record. Only applies if {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponentsByCell
     * showRecordComponentsByCell} is true. <P> When {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordComponentPoolingMode recordComponentPoolingMode} is "recycle" and you
     * have components of  different types in different columns, set this property to true to ensure that  components intended
     * for one column are not recycled for use in another column that  should have a different component. <P> If no components
     * applicable to a particular column are available in the pool, the system calls {@link
     * com.smartgwt.client.widgets.grid.ListGrid#createRecordComponent createRecordComponent}.
     *
     *
     * @return Boolean
     */
    public Boolean getPoolComponentsPerColumn()  {
        return getAttributeAsBoolean("poolComponentsPerColumn");
    }

    /**
     * Whether cell contents should wrap during printing.  Equivalent to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFit autoFit}, but specific to printed output.
     *
     * @param printAutoFit printAutoFit Default value is true
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public void setPrintAutoFit(Boolean printAutoFit) {
        setAttribute("printAutoFit", printAutoFit, true);
    }

    /**
     * Whether cell contents should wrap during printing.  Equivalent to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFit autoFit}, but specific to printed output.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public Boolean getPrintAutoFit()  {
        return getAttributeAsBoolean("printAutoFit");
    }

    /**
     * Style for non-header cells in printed output.  Defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle
     * baseStyle} if null.
     *
     * @param printBaseStyle printBaseStyle Default value is null
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public void setPrintBaseStyle(String printBaseStyle) {
        setAttribute("printBaseStyle", printBaseStyle, true);
    }

    /**
     * Style for non-header cells in printed output.  Defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle
     * baseStyle} if null.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintBaseStyle()  {
        return getAttributeAsString("printBaseStyle");
    }

    /**
     * Style for header cells in printed output.  Defaults to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderBaseStyle headerBaseStyle} if null.
     *
     * @param printHeaderStyle printHeaderStyle Default value is "printHeader"
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public void setPrintHeaderStyle(String printHeaderStyle) {
        setAttribute("printHeaderStyle", printHeaderStyle, true);
    }

    /**
     * Style for header cells in printed output.  Defaults to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderBaseStyle headerBaseStyle} if null.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintHeaderStyle()  {
        return getAttributeAsString("printHeaderStyle");
    }

    /**
     * Advanced property - when generating printHTML for a large ListGrid, rows are printed in batches in order to avoid
     * triggering a native "script is running slowly" browser dialog. <P> For grids with exceptional numbers of columns or
     * complex formatting logic, this number might need to be adjusted downward.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param printMaxRows printMaxRows Default value is 100
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public void setPrintMaxRows(int printMaxRows) {
        setAttribute("printMaxRows", printMaxRows, true);
    }

    /**
     * Advanced property - when generating printHTML for a large ListGrid, rows are printed in batches in order to avoid
     * triggering a native "script is running slowly" browser dialog. <P> For grids with exceptional numbers of columns or
     * complex formatting logic, this number might need to be adjusted downward.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public int getPrintMaxRows()  {
        return getAttributeAsInt("printMaxRows");
    }

    /**
     * Whether cell contents should wrap during printing.  Equivalent to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getWrapCells wrapCells}, but specific to printed output.
     *
     * @param printWrapCells printWrapCells Default value is true
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public void setPrintWrapCells(Boolean printWrapCells) {
        setAttribute("printWrapCells", printWrapCells, true);
    }

    /**
     * Whether cell contents should wrap during printing.  Equivalent to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getWrapCells wrapCells}, but specific to printed output.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public Boolean getPrintWrapCells()  {
        return getAttributeAsBoolean("printWrapCells");
    }

    /**
     * Alternative to {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio}, to be used when the
     * user is rapidly changing the grids viewport (for example drag scrolling through the grid). If unspecified {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio} will be used in all cases
     *
     * @param quickDrawAheadRatio quickDrawAheadRatio Default value is 1.0
     */
    public void setQuickDrawAheadRatio(float quickDrawAheadRatio) {
        setAttribute("quickDrawAheadRatio", quickDrawAheadRatio, true);
    }

    /**
     * Alternative to {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio}, to be used when the
     * user is rapidly changing the grids viewport (for example drag scrolling through the grid). If unspecified {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio} will be used in all cases
     *
     *
     * @return float
     */
    public float getQuickDrawAheadRatio()  {
        return getAttributeAsFloat("quickDrawAheadRatio");
    }

    /**
     * This attribute allows custom base styles to be displayed on a per-record basis. To specify a custom base-style for some
     * record set  <code>record[listGrid.recordBaseStyleProperty]</code> to the desired base style name -  for example if
     * <code>recordBaseStyleProperty</code> is <code>"_baseStyle"</code>, set <code>record._baseStyle</code> to the custom base
     * style name.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param recordBaseStyleProperty recordBaseStyleProperty Default value is "_baseStyle"
     * @see com.smartgwt.client.widgets.grid.ListGrid#setBaseStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setRecordBaseStyleProperty(String recordBaseStyleProperty) {
        setAttribute("recordBaseStyleProperty", recordBaseStyleProperty, true);
    }

    /**
     * This attribute allows custom base styles to be displayed on a per-record basis. To specify a custom base-style for some
     * record set  <code>record[listGrid.recordBaseStyleProperty]</code> to the desired base style name -  for example if
     * <code>recordBaseStyleProperty</code> is <code>"_baseStyle"</code>, set <code>record._baseStyle</code> to the custom base
     * style name.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getRecordBaseStyleProperty()  {
        return getAttributeAsString("recordBaseStyleProperty");
    }

    /**
     * If set to false on a record, selection of that record is disallowed.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param recordCanSelectProperty recordCanSelectProperty Default value is "canSelect"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRecordCanSelectProperty(String recordCanSelectProperty)  throws IllegalStateException {
        setAttribute("recordCanSelectProperty", recordCanSelectProperty, false);
    }

    /**
     * If set to false on a record, selection of that record is disallowed.
     *
     *
     * @return String
     */
    public String getRecordCanSelectProperty()  {
        return getAttributeAsString("recordCanSelectProperty");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents showRecordComponents} is true, this
     * attribute may be used to specify a standard height for record components. If specified every row in the grid will be
     * sized tall enough to accommodate a recordComponent of this size. <P> Note that if this property is unset, the grid will
     * not be able to know row heights in advance, and {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen freezing
     * of columns} is not currently supported in this case.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for the {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordComponentHeight recordComponentHeight}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param recordComponentHeight recordComponent height. Default value is null
     */
    public void setRecordComponentHeight(Integer recordComponentHeight) {
        setAttribute("recordComponentHeight", recordComponentHeight, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents showRecordComponents} is true, this
     * attribute may be used to specify a standard height for record components. If specified every row in the grid will be
     * sized tall enough to accommodate a recordComponent of this size. <P> Note that if this property is unset, the grid will
     * not be able to know row heights in advance, and {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen freezing
     * of columns} is not currently supported in this case.
     *
     *
     * @return Integer
     */
    public Integer getRecordComponentHeight()  {
        return getAttributeAsInt("recordComponentHeight");
    }

    /**
     * The method of {@link com.smartgwt.client.types.RecordComponentPoolingMode component-pooling} to employ for  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents recordComponents}. <P> The default mode is "viewport",
     * which means that recordComponents are destroyed as soon  their record leaves the viewport.   <P> For the most efficient
     * implementation, switch to "recycle" mode, which pools components  when records leave the viewport and re-uses them in
     * other records.  In this mode, you  should implement {@link
     * com.smartgwt.client.widgets.grid.ListGrid#updateRecordComponent updateRecordComponent()} to  apply any changes to make
     * reused components applicable to the new record they appear in,  if necessary.  If you have components of different types
     * in different columns and still want to take advantage of component recycling, you can  set {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getPoolComponentsPerColumn poolComponentsPerColumn} to ensure that components
     * intended for one  column are not recycled for use in another column that should have a different component. <P> Note
     * that, if different records have distinctly different components embedded  in them, or multiple columns in each record
     * embed different components, you should  leave the recordComponentPoolingMode at "viewport" if your dataset is very large
     * or  use "data" otherwise.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param recordComponentPoolingMode recordComponentPoolingMode Default value is "viewport"
     */
    public void setRecordComponentPoolingMode(RecordComponentPoolingMode recordComponentPoolingMode) {
        setAttribute("recordComponentPoolingMode", recordComponentPoolingMode == null ? null : recordComponentPoolingMode.getValue(), true);
    }

    /**
     * The method of {@link com.smartgwt.client.types.RecordComponentPoolingMode component-pooling} to employ for  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents recordComponents}. <P> The default mode is "viewport",
     * which means that recordComponents are destroyed as soon  their record leaves the viewport.   <P> For the most efficient
     * implementation, switch to "recycle" mode, which pools components  when records leave the viewport and re-uses them in
     * other records.  In this mode, you  should implement {@link
     * com.smartgwt.client.widgets.grid.ListGrid#updateRecordComponent updateRecordComponent()} to  apply any changes to make
     * reused components applicable to the new record they appear in,  if necessary.  If you have components of different types
     * in different columns and still want to take advantage of component recycling, you can  set {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getPoolComponentsPerColumn poolComponentsPerColumn} to ensure that components
     * intended for one  column are not recycled for use in another column that should have a different component. <P> Note
     * that, if different records have distinctly different components embedded  in them, or multiple columns in each record
     * embed different components, you should  leave the recordComponentPoolingMode at "viewport" if your dataset is very large
     * or  use "data" otherwise.
     *
     *
     * @return RecordComponentPoolingMode
     */
    public RecordComponentPoolingMode getRecordComponentPoolingMode()  {
        return EnumUtil.getEnum(RecordComponentPoolingMode.values(), getAttribute("recordComponentPoolingMode"));
    }

    /**
     * if {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents showRecordComponents} is true, how should
     * the component appear within the cell. Valid options are  <ul><li><code>"within"</code>: the component will be rendered
     * inside the record / cell.  {@link com.smartgwt.client.widgets.Canvas#getSnapTo snapTo} may be set to specify where the
     * component should render within  the row or cell, and {@link com.smartgwt.client.widgets.Canvas#getSnapOffsetTop
     * snapOffsetTop} / {@link com.smartgwt.client.widgets.Canvas#getSnapOffsetLeft snapOffsetLeft} may  be set to indent
     * recordComponents within their parent cells.  Note that if unset, the component will show up at the top/left edge  for
     * components embedded within an entire row, or for per-cell components, cell  align and valign will be respected.  Note
     * also that, when rendering components "within"  cells, specified component heights will be respected and will change the
     * height of the   row.  However, if you want components to completely fill a cell at it's default height,   set height:
     * "100%" or rows will render at the default height of the component. </li>  <li><code>"expand"</code>: the component will
     * be written into the cell below the  normal cell content, causing the cell to expand vertically to accommodate it.
     * <li><code>null</code>: If this attribute is unset, we will default to showing  recordComponents with position
     * <code>"within"</code> if   {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponentsByCell
     * showRecordComponentsByCell} is true, otherwise using <code>"expand"</code>  logic. </ul>
     *
     * @param recordComponentPosition recordComponentPosition Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setShowRecordComponents
     */
    public void setRecordComponentPosition(EmbeddedPosition recordComponentPosition) {
        setAttribute("recordComponentPosition", recordComponentPosition == null ? null : recordComponentPosition.getValue(), true);
    }

    /**
     * if {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents showRecordComponents} is true, how should
     * the component appear within the cell. Valid options are  <ul><li><code>"within"</code>: the component will be rendered
     * inside the record / cell.  {@link com.smartgwt.client.widgets.Canvas#getSnapTo snapTo} may be set to specify where the
     * component should render within  the row or cell, and {@link com.smartgwt.client.widgets.Canvas#getSnapOffsetTop
     * snapOffsetTop} / {@link com.smartgwt.client.widgets.Canvas#getSnapOffsetLeft snapOffsetLeft} may  be set to indent
     * recordComponents within their parent cells.  Note that if unset, the component will show up at the top/left edge  for
     * components embedded within an entire row, or for per-cell components, cell  align and valign will be respected.  Note
     * also that, when rendering components "within"  cells, specified component heights will be respected and will change the
     * height of the   row.  However, if you want components to completely fill a cell at it's default height,   set height:
     * "100%" or rows will render at the default height of the component. </li>  <li><code>"expand"</code>: the component will
     * be written into the cell below the  normal cell content, causing the cell to expand vertically to accommodate it.
     * <li><code>null</code>: If this attribute is unset, we will default to showing  recordComponents with position
     * <code>"within"</code> if   {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponentsByCell
     * showRecordComponentsByCell} is true, otherwise using <code>"expand"</code>  logic. </ul>
     *
     *
     * @return EmbeddedPosition
     * @see com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents
     */
    public EmbeddedPosition getRecordComponentPosition()  {
        return EnumUtil.getEnum(EmbeddedPosition.values(), getAttribute("recordComponentPosition"));
    }

    /**
     * The name of the ListGridRecord property that specifies the DataSource to use when  {@link
     * com.smartgwt.client.types.ExpansionMode listGrid.expansionMode} is "related".  The default is  {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getDetailDS detailDS}. Note that you can set the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDetailDS detailDS} at the grid level instead if the same dataSource is to
     * be used for all records.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param recordDetailDSProperty recordDetailDSProperty Default value is "detailDS"
     */
    public void setRecordDetailDSProperty(String recordDetailDSProperty) {
        setAttribute("recordDetailDSProperty", recordDetailDSProperty, true);
    }

    /**
     * The name of the ListGridRecord property that specifies the DataSource to use when  {@link
     * com.smartgwt.client.types.ExpansionMode listGrid.expansionMode} is "related".  The default is  {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getDetailDS detailDS}. Note that you can set the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDetailDS detailDS} at the grid level instead if the same dataSource is to
     * be used for all records.
     *
     *
     * @return String
     */
    public String getRecordDetailDSProperty()  {
        return getAttributeAsString("recordDetailDSProperty");
    }

    /**
     * Property name on a record that should be checked to determine whether the record may be edited. <br> This property is
     * configurable to avoid possible collision with data values in record. With the default setting of "_canEdit", a record
     * can be set non-editable by ensuring record._canEdit == false. <br> For controlling editability for the entire grid or
     * for a field, set grid.canEdit or field.canEdit.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param recordEditProperty recordEditProperty Default value is "_canEdit"
     * @see com.smartgwt.client.widgets.grid.ListGrid#setCanEdit
     * @see com.smartgwt.client.widgets.grid.ListGridField#setCanEdit
     * @see com.smartgwt.client.widgets.grid.ListGrid#canEditCell
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setRecordEditProperty(String recordEditProperty) {
        setAttribute("recordEditProperty", recordEditProperty, true);
    }

    /**
     * Property name on a record that should be checked to determine whether the record may be edited. <br> This property is
     * configurable to avoid possible collision with data values in record. With the default setting of "_canEdit", a record
     * can be set non-editable by ensuring record._canEdit == false. <br> For controlling editability for the entire grid or
     * for a field, set grid.canEdit or field.canEdit.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCanEdit
     * @see com.smartgwt.client.widgets.grid.ListGridField#getCanEdit
     * @see com.smartgwt.client.widgets.grid.ListGrid#canEditCell
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public String getRecordEditProperty()  {
        return getAttributeAsString("recordEditProperty");
    }

    /**
     * If showing any record summary fields (IE: fields of {@link com.smartgwt.client.types.ListGridFieldType type:"summary"}),
     * this attribute specifies a custom base style to apply to cells in the summary field
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param recordSummaryBaseStyle recordSummaryBaseStyle Default value is "recordSummaryCell"
     */
    public void setRecordSummaryBaseStyle(String recordSummaryBaseStyle) {
        setAttribute("recordSummaryBaseStyle", recordSummaryBaseStyle, true);
    }

    /**
     * If showing any record summary fields (IE: fields of {@link com.smartgwt.client.types.ListGridFieldType type:"summary"}),
     * this attribute specifies a custom base style to apply to cells in the summary field
     *
     *
     * @return String
     */
    public String getRecordSummaryBaseStyle()  {
        return getAttributeAsString("recordSummaryBaseStyle");
    }

    /**
     * Custom CSS text to be applied to records that have been  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#markRecordRemoved marked for removal}. <P> This CSS text will be applied on
     * top of standard disabled styling for the cell.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param removedCSSText removedCSSText Default value is "text-decoration:line-through;"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setRemovedCSSText(String removedCSSText) {
        setAttribute("removedCSSText", removedCSSText, true);
    }

    /**
     * Custom CSS text to be applied to records that have been  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#markRecordRemoved marked for removal}. <P> This CSS text will be applied on
     * top of standard disabled styling for the cell.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getRemovedCSSText()  {
        return getAttributeAsString("removedCSSText");
    }

    /**
     * The title to use for the {@link com.smartgwt.client.widgets.grid.ListGrid#getRemoveFieldDefaults remove field}.  Note
     * that this text will appear in the column-picker but the not in the field-header because the removeField has {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getShowTitle showTitle} set to false by default.  This can be changed via
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getRemoveFieldProperties removeFieldProperties}.
     *
     * @param removeFieldTitle removeFieldTitle Default value is "[Remove record]"
     */
    public void setRemoveFieldTitle(String removeFieldTitle) {
        setAttribute("removeFieldTitle", removeFieldTitle, true);
    }

    /**
     * The title to use for the {@link com.smartgwt.client.widgets.grid.ListGrid#getRemoveFieldDefaults remove field}.  Note
     * that this text will appear in the column-picker but the not in the field-header because the removeField has {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getShowTitle showTitle} set to false by default.  This can be changed via
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getRemoveFieldProperties removeFieldProperties}.
     *
     *
     * @return String
     */
    public String getRemoveFieldTitle()  {
        return getAttributeAsString("removeFieldTitle");
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is enabled, default icon to
     * show in the auto-generated field that allows removing records.
     *
     * @param removeIcon removeIcon Default value is "[SKIN]/actions/remove.png"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRemoveIcon(String removeIcon)  throws IllegalStateException {
        setAttribute("removeIcon", removeIcon, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is enabled, default icon to
     * show in the auto-generated field that allows removing records.
     *
     *
     * @return String
     */
    public String getRemoveIcon()  {
        return getAttributeAsString("removeIcon");
    }

    /**
     * Default width and height of {@link com.smartgwt.client.widgets.grid.ListGrid#getRemoveIcon remove icons} for this
     * ListGrid.
     *
     * @param removeIconSize removeIconSize Default value is 16
     */
    public void setRemoveIconSize(int removeIconSize) {
        setAttribute("removeIconSize", removeIconSize, true);
    }

    /**
     * Default width and height of {@link com.smartgwt.client.widgets.grid.ListGrid#getRemoveIcon remove icons} for this
     * ListGrid.
     *
     *
     * @return int
     */
    public int getRemoveIconSize()  {
        return getAttributeAsInt("removeIconSize");
    }

    /**
     * True == we redraw the list viewer in real time as fields are being resized.  This can be slow with a large list and/or
     * on some platforms.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param resizeFieldsInRealTime resizeFieldsInRealTime Default value is Browser.isIE && isc.Browser.isWin
     */
    public void setResizeFieldsInRealTime(Boolean resizeFieldsInRealTime) {
        setAttribute("resizeFieldsInRealTime", resizeFieldsInRealTime, true);
    }

    /**
     * True == we redraw the list viewer in real time as fields are being resized.  This can be slow with a large list and/or
     * on some platforms.
     *
     *
     * @return Boolean
     */
    public Boolean getResizeFieldsInRealTime()  {
        return getAttributeAsBoolean("resizeFieldsInRealTime");
    }

    /**
     * If the user is editing a record in this listGrid, and attempts to navigate to a field beyond the end of the row, via tab
     * (or shift-tab off the first editable field), this  property determines what action to take:<ul> <li>"next": start
     * editing the next (or previous) record in the list <li>"same": put focus back into the first editable field of the same
     * record. <li>"done": hide the editor <li>"stop": leave focus in the cell being edited <li>"none": no action </ul>
     *
     * @param rowEndEditAction rowEndEditAction Default value is null
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setRowEndEditAction(RowEndEditAction rowEndEditAction) {
        setAttribute("rowEndEditAction", rowEndEditAction == null ? null : rowEndEditAction.getValue(), true);
    }

    /**
     * If the user is editing a record in this listGrid, and attempts to navigate to a field beyond the end of the row, via tab
     * (or shift-tab off the first editable field), this  property determines what action to take:<ul> <li>"next": start
     * editing the next (or previous) record in the list <li>"same": put focus back into the first editable field of the same
     * record. <li>"done": hide the editor <li>"stop": leave focus in the cell being edited <li>"none": no action </ul>
     *
     *
     * @return RowEndEditAction
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public RowEndEditAction getRowEndEditAction()  {
        return EnumUtil.getEnum(RowEndEditAction.values(), getAttribute("rowEndEditAction"));
    }

    /**
     * The number to start the row-count from - default value is 1.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param rowNumberStart rowNumberStart Default value is 1
     */
    public void setRowNumberStart(int rowNumberStart) {
        setAttribute("rowNumberStart", rowNumberStart, true);
    }

    /**
     * The number to start the row-count from - default value is 1.
     *
     *
     * @return int
     */
    public int getRowNumberStart()  {
        return getAttributeAsInt("rowNumberStart");
    }

    /**
     * The CSS Style name for the {@link com.smartgwt.client.widgets.grid.ListGrid#getRowNumberField rowNumberField}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param rowNumberStyle rowNumberStyle Default value is "cellDark"
     */
    public void setRowNumberStyle(String rowNumberStyle) {
        setAttribute("rowNumberStyle", rowNumberStyle, true);
    }

    /**
     * The CSS Style name for the {@link com.smartgwt.client.widgets.grid.ListGrid#getRowNumberField rowNumberField}.
     *
     *
     * @return String
     */
    public String getRowNumberStyle()  {
        return getAttributeAsString("rowNumberStyle");
    }

    /**
     * Whether edits should be saved whenever the user moves between cells in the current edit row. <P> If unset, defaults to
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getEditByCell this.editByCell}. <P> To avoid automatic saving entirely,
     * set {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits}:false.
     *
     * @param saveByCell saveByCell Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setEditByCell
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setSaveByCell(Boolean saveByCell) {
        setAttribute("saveByCell", saveByCell, true);
    }

    /**
     * Whether edits should be saved whenever the user moves between cells in the current edit row. <P> If unset, defaults to
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getEditByCell this.editByCell}. <P> To avoid automatic saving entirely,
     * set {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits}:false.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#getEditByCell
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean getSaveByCell()  {
        return getAttributeAsBoolean("saveByCell");
    }

    /**
     * For grids with a specified {@link com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource}, this property can
     * be set to  <code>true</code> to prevent the grid from attempting to save / retrieve data from the server.  In this case
     * the grid's data should be specified as an array via  the {@link com.smartgwt.client.widgets.grid.ListGrid#getData data}
     * attribute, and the datasource will simply act as a schema to describe the set of fields visible in the grid.  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanEdit Inline edits}, or removals via the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} mechanism will update the local data
     * array rather than attempting to perform operations against the dataSource.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param saveLocally saveLocally Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.grid.ListGrid#setUseRemoteValidators
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setSaveLocally(Boolean saveLocally)  throws IllegalStateException {
        setAttribute("saveLocally", saveLocally, false);
    }

    /**
     * For grids with a specified {@link com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource}, this property can
     * be set to  <code>true</code> to prevent the grid from attempting to save / retrieve data from the server.  In this case
     * the grid's data should be specified as an array via  the {@link com.smartgwt.client.widgets.grid.ListGrid#getData data}
     * attribute, and the datasource will simply act as a schema to describe the set of fields visible in the grid.  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanEdit Inline edits}, or removals via the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} mechanism will update the local data
     * array rather than attempting to perform operations against the dataSource.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#getUseRemoteValidators
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Boolean getSaveLocally()  {
        return getAttributeAsBoolean("saveLocally");
    }

    /**
     * For editable grids with a specified {@link com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource}, where 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveLocally saveLocally} is false, this attribute may be used to
     * specify standard DSRequest properties to apply to all save operations performed by this grid (whether triggered by user
     * interaction, or explicit saveEdits or saveAllEdits call). <P> An example usage would be to customize the prompt
     * displayed while saving is in progress if {@link com.smartgwt.client.widgets.grid.ListGrid#getWaitForSave waitForSave} is
     * true. <P> Note that for more advanced customization of save operations, {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getAddOperation addOperation} and {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getUpdateOperation updateOperation} are available to developers, allowing
     * specification of an explicit {@link com.smartgwt.client.data.OperationBinding}  for the add / update operation performed
     * on save.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param saveRequestProperties saveRequestProperties Default value is null
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setSaveRequestProperties(DSRequest saveRequestProperties) {
        setAttribute("saveRequestProperties", saveRequestProperties.getJsObj(), true);
    }

    /**
     * For editable grids with a specified {@link com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource}, where 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveLocally saveLocally} is false, this attribute may be used to
     * specify standard DSRequest properties to apply to all save operations performed by this grid (whether triggered by user
     * interaction, or explicit saveEdits or saveAllEdits call). <P> An example usage would be to customize the prompt
     * displayed while saving is in progress if {@link com.smartgwt.client.widgets.grid.ListGrid#getWaitForSave waitForSave} is
     * true. <P> Note that for more advanced customization of save operations, {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getAddOperation addOperation} and {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getUpdateOperation updateOperation} are available to developers, allowing
     * specification of an explicit {@link com.smartgwt.client.data.OperationBinding}  for the add / update operation performed
     * on save.
     *
     *
     * @return DSRequest
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public DSRequest getSaveRequestProperties()  {
        return new DSRequest(getAttributeAsJavaScriptObject("saveRequestProperties"));
    }

    /**
     * While drag scrolling in an incrementally rendered grid, time in milliseconds to wait before redrawing, after the last
     * mouse movement by the user.  See also {@link com.smartgwt.client.grid.GridRenderer#getInstantScrollTrackRedraw
     * instantScrollTrackRedraw} for cases where this delay is skipped.
     *
     * @param scrollRedrawDelay scrollRedrawDelay Default value is 75
     */
    public void setScrollRedrawDelay(int scrollRedrawDelay) {
        setAttribute("scrollRedrawDelay", scrollRedrawDelay, true);
    }

    /**
     * While drag scrolling in an incrementally rendered grid, time in milliseconds to wait before redrawing, after the last
     * mouse movement by the user.  See also {@link com.smartgwt.client.grid.GridRenderer#getInstantScrollTrackRedraw
     * instantScrollTrackRedraw} for cases where this delay is skipped.
     *
     *
     * @return int
     */
    public int getScrollRedrawDelay()  {
        return getAttributeAsInt("scrollRedrawDelay");
    }

    /**
     * How selection of rows should be presented to the user. <P> For <code>selectionAppearance:"checkbox"</code> with multiple
     * selection allowed, you would typically use {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionType
     * selectionType}:"simple" (the default).  Because  <code>selectionType</code> and <code>selectionAppearance</code> are
     * unrelated,  the combination of <code>selectionAppearance:"checkbox"</code> and <code>selectionType:"multiple"</code>
     * results in a grid where multiple selection can only be achieved via shift-click or ctrl-click.   <P> If using
     * <code>"checkbox"</code> for a {@link com.smartgwt.client.widgets.grid.ListGrid}, see also {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCheckboxField checkboxField} for customization APIs. <P> If using
     * <code>"checkbox"</code> for a {@link com.smartgwt.client.widgets.tree.TreeGrid}, an extra icon, {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getExtraIcon TreeGrid.getExtraIcon} is not supported. Additionally only {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSelectionType selectionType}:"simple" and "single" are supported. You can
     * also toggle the display of a disabled checkbox on a treegrid, displayed  when the node can't be selected, via {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowDisabledSelectionCheckbox showDisabledSelectionCheckbox}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Changes selectionAppearance on the fly.
     *
     * @param selectionAppearance new selection appearance. Default value is "rowStyle"
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public void setSelectionAppearance(SelectionAppearance selectionAppearance) {
        setAttribute("selectionAppearance", selectionAppearance == null ? null : selectionAppearance.getValue(), true);
    }

    /**
     * How selection of rows should be presented to the user. <P> For <code>selectionAppearance:"checkbox"</code> with multiple
     * selection allowed, you would typically use {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionType
     * selectionType}:"simple" (the default).  Because  <code>selectionType</code> and <code>selectionAppearance</code> are
     * unrelated,  the combination of <code>selectionAppearance:"checkbox"</code> and <code>selectionType:"multiple"</code>
     * results in a grid where multiple selection can only be achieved via shift-click or ctrl-click.   <P> If using
     * <code>"checkbox"</code> for a {@link com.smartgwt.client.widgets.grid.ListGrid}, see also {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCheckboxField checkboxField} for customization APIs. <P> If using
     * <code>"checkbox"</code> for a {@link com.smartgwt.client.widgets.tree.TreeGrid}, an extra icon, {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getExtraIcon TreeGrid.getExtraIcon} is not supported. Additionally only {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSelectionType selectionType}:"simple" and "single" are supported. You can
     * also toggle the display of a disabled checkbox on a treegrid, displayed  when the node can't be selected, via {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowDisabledSelectionCheckbox showDisabledSelectionCheckbox}.
     *
     *
     * @return SelectionAppearance
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public SelectionAppearance getSelectionAppearance()  {
        return EnumUtil.getEnum(SelectionAppearance.values(), getAttribute("selectionAppearance"));
    }

    /**
     * If specified, the selection object for this list will use this property to mark records as selected.  In other words, if
     * this attribute were set to <code>"isSelected"</code> any records in the listGrid data where <code>"isSelected"</code> is
     * <code>true</code> will show up as selected in the grid. Similarly if records are selected within the grid after the grid
     * has been created, this property will be set to true on the selected records.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param selectionProperty selectionProperty Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setSelectionProperty(String selectionProperty)  throws IllegalStateException {
        setAttribute("selectionProperty", selectionProperty, false);
    }

    /**
     * If specified, the selection object for this list will use this property to mark records as selected.  In other words, if
     * this attribute were set to <code>"isSelected"</code> any records in the listGrid data where <code>"isSelected"</code> is
     * <code>true</code> will show up as selected in the grid. Similarly if records are selected within the grid after the grid
     * has been created, this property will be set to true on the selected records.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSelectionProperty()  {
        return getAttributeAsString("selectionProperty");
    }

    /**
     * Defines a listGrid's clickable-selection behavior.   <P> The default selection appearance is governed by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance}: if selectionAppearance is
     * "checkbox", this will be "simple", otherwise, this will be "multiple".
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Changes selectionType on the fly.
     *
     * @param selectionType New selection style.. Default value is null
     * @see com.smartgwt.client.types.SelectionStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_multiselect" target="examples">Multiple select Example</a>
     */
    public void setSelectionType(SelectionStyle selectionType) {
        setAttribute("selectionType", selectionType == null ? null : selectionType.getValue(), true);
    }

    /**
     * Defines a listGrid's clickable-selection behavior.   <P> The default selection appearance is governed by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance}: if selectionAppearance is
     * "checkbox", this will be "simple", otherwise, this will be "multiple".
     *
     *
     * @return SelectionStyle
     * @see com.smartgwt.client.types.SelectionStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_multiselect" target="examples">Multiple select Example</a>
     */
    public SelectionStyle getSelectionType()  {
        return EnumUtil.getEnum(SelectionStyle.values(), getAttribute("selectionType"));
    }

    /**
     * When the user starts editing a row, should the row also be selected?  <P>  Note that  when this attribute is set to
     * <code>true</code>, other all other rows in the grid  will be deselected when a record is selected due to editing.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param selectOnEdit selectOnEdit Default value is true
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setSelectOnEdit(Boolean selectOnEdit) {
        setAttribute("selectOnEdit", selectOnEdit, true);
    }

    /**
     * When the user starts editing a row, should the row also be selected?  <P>  Note that  when this attribute is set to
     * <code>true</code>, other all other rows in the grid  will be deselected when a record is selected due to editing.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean getSelectOnEdit()  {
        return getAttributeAsBoolean("selectOnEdit");
    }

    /**
     * Whether all columns should be drawn all at once, or only columns visible in the viewport. <P> Drawing all columns causes
     * longer initial rendering time, but allows smoother horizontal scrolling.  With a very large number of columns,
     * showAllColumns will become too slow.
     *
     * @param showAllColumns showAllColumns Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowAllColumns(Boolean showAllColumns)  throws IllegalStateException {
        setAttribute("showAllColumns", showAllColumns, false);
    }

    /**
     * Whether all columns should be drawn all at once, or only columns visible in the viewport. <P> Drawing all columns causes
     * longer initial rendering time, but allows smoother horizontal scrolling.  With a very large number of columns,
     * showAllColumns will become too slow.
     *
     *
     * @return Boolean
     */
    public Boolean getShowAllColumns()  {
        return getAttributeAsBoolean("showAllColumns");
    }

    /**
     * Whether all rows should be drawn all at once, or only rows visible in the viewport. <P> Drawing all rows causes longer
     * initial rendering time, but allows smoother vertical scrolling. With a very large number of rows, showAllRows will
     * become too slow. <P> See also {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio} and
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAllMaxCells drawAllMaxCells}.
     *
     * @param showAllRecords showAllRecords Default value is false
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_autofit_rows" target="examples">Rows Example</a>
     */
    public void setShowAllRecords(Boolean showAllRecords) {
        setAttribute("showAllRecords", showAllRecords, true);
    }

    /**
     * Whether all rows should be drawn all at once, or only rows visible in the viewport. <P> Drawing all rows causes longer
     * initial rendering time, but allows smoother vertical scrolling. With a very large number of rows, showAllRows will
     * become too slow. <P> See also {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio} and
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAllMaxCells drawAllMaxCells}.
     *
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_autofit_rows" target="examples">Rows Example</a>
     */
    public Boolean getShowAllRecords()  {
        return getAttributeAsBoolean("showAllRecords");
    }

    /**
     * If <code>true</code> this grid will create and show per-row backgroundComponents  as detailed {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBackgroundComponent here}.
     *
     * @param showBackgroundComponent showBackgroundComponent Default value is false
     */
    public void setShowBackgroundComponent(Boolean showBackgroundComponent) {
        setAttribute("showBackgroundComponent", showBackgroundComponent, true);
    }

    /**
     * If <code>true</code> this grid will create and show per-row backgroundComponents  as detailed {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBackgroundComponent here}.
     *
     *
     * @return Boolean
     */
    public Boolean getShowBackgroundComponent()  {
        return getAttributeAsBoolean("showBackgroundComponent");
    }

    /**
     * Whether to show a context menu with standard items for all context clicks on rows in the body.
     *
     * @param showCellContextMenus showCellContextMenus Default value is false
     */
    public void setShowCellContextMenus(Boolean showCellContextMenus) {
        setAttribute("showCellContextMenus", showCellContextMenus, true);
    }

    /**
     * Whether to show a context menu with standard items for all context clicks on rows in the body.
     *
     *
     * @return Boolean
     */
    public Boolean getShowCellContextMenus()  {
        return getAttributeAsBoolean("showCellContextMenus");
    }

    /**
     * Whether to include fields marked <code>detail:true</code> from this component's  <code>DataSource</code>. <P> Fields may
     * also be included directly in this component's <code>fields</code> array in which case they will be present regardless of
     * the <code>detail</code> attribute. <p> When this property is <code>true</code>, <code>ListGrid</code>s will include all 
     * detail fields, but they will be initially hidden.  The user may show these fields via the default header context menu
     * ({@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu}). Setting this
     * property to false will completely exclude all detail fields from the list grid's fields array, such that they cannot be
     * shown by the user or programmatically. <P> To override the visibility of individual fields, use the standard {@link
     * com.smartgwt.client.widgets.grid.ListGrid#showField ListGrid.showField}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#hideField ListGrid.hideField} and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#showIf ListGridField.showIf} APIs, for example, set showIf:"true" to show
     * a detail field initially.
     *
     * @param showDetailFields showDetailFields Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setShowDetailFields(Boolean showDetailFields)  throws IllegalStateException {
        setAttribute("showDetailFields", showDetailFields, false);
    }

    /**
     * Whether to include fields marked <code>detail:true</code> from this component's  <code>DataSource</code>. <P> Fields may
     * also be included directly in this component's <code>fields</code> array in which case they will be present regardless of
     * the <code>detail</code> attribute. <p> When this property is <code>true</code>, <code>ListGrid</code>s will include all 
     * detail fields, but they will be initially hidden.  The user may show these fields via the default header context menu
     * ({@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu}). Setting this
     * property to false will completely exclude all detail fields from the list grid's fields array, such that they cannot be
     * shown by the user or programmatically. <P> To override the visibility of individual fields, use the standard {@link
     * com.smartgwt.client.widgets.grid.ListGrid#showField ListGrid.showField}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#hideField ListGrid.hideField} and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#showIf ListGridField.showIf} APIs, for example, set showIf:"true" to show
     * a detail field initially.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Boolean getShowDetailFields()  {
        return getAttributeAsBoolean("showDetailFields");
    }

    /**
     * Indicates whether the text of the emptyMessage property should be displayed if no data is available.
     *
     * @param showEmptyMessage showEmptyMessage Default value is true
     * @see com.smartgwt.client.widgets.grid.ListGrid#setEmptyMessage
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_appearance_empty_grid" target="examples">Empty grid Example</a>
     */
    public void setShowEmptyMessage(Boolean showEmptyMessage) {
        setAttribute("showEmptyMessage", showEmptyMessage, true);
    }

    /**
     * Indicates whether the text of the emptyMessage property should be displayed if no data is available.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#getEmptyMessage
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_appearance_empty_grid" target="examples">Empty grid Example</a>
     */
    public Boolean getShowEmptyMessage()  {
        return getAttributeAsBoolean("showEmptyMessage");
    }

    /**
     * Should this listGrid display a filter row.  If true, this ListGrid
     *  will be drawn with a single editable row, (separate from the body) with a filter button.
     *  <P>
     *  Values entered into this row are used as filter criteria to filter this List's data on
     * enter-keypress or filter button click. {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchTextMatchStyle
     * autoFetchTextMatchStyle} determines
     * the textMatchStyle for the request passed to {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData
     * ListGrid.fetchData}.
     *  <P>
     * Note that if {@link com.smartgwt.client.widgets.grid.ListGrid#filterData ListGrid.filterData} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData ListGrid.fetchData} is called directly
     *  while the filter editor is showing, the filter editor values will be updated to reflect the
     *  new set of criteria. If you wish to retain the user entered filter criteria and 
     *  programmatically modify a subset of field values programmatically this can be achieved by
     *  deriving new criteria by copying the existing set of criteria and adding other changes - 
     *  something like this:
     *  <pre><code>
     *    var newCriteria = myListGrid.getFilterEditorCriteria();
     *    isc.addProperties(newCriteria, {
     *       field1:"new value1",
     *       field2:"new value2"
     *    });
     *    myListGrid.setCriteria(newCriteria);
     *  </code></pre>
     * In this example code we're using {@link com.smartgwt.client.widgets.grid.ListGrid#getFilterEditorCriteria
     * ListGrid.getFilterEditorCriteria} rather than 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getCriteria ListGrid.getCriteria} - this ensures that if the user has
     * typed a new value into
     *  the filter editor, but not yet clicked the filter button, we pick up the value the user
     *  entered.
     *  <P>
     *  If you call <code>filterData()</code> and pass in criteria for dataSource 
     *  fields that are not present in the ListGrid, these criteria will continue to be applied along
     *  with the user visible criteria.
     *  <P>
     *  <b>filterEditor and advanced criteria</b>: If a developer calls <code>filterData()</code>
     *  on a ListGrid and passes in {@link com.smartgwt.client.data.AdvancedCriteria}, expected behavior of the filter 
     *  editor becomes ambiguous, as  AdvancedCriteria supports far more complex filter 
     *  expressions than the ordinary filterEditor is capable of expressing.
     *  <br>
     *  The above example code assumes simple criteria, but if we wanted to apply advanced 
     * criteria to the grid we could call {@link com.smartgwt.client.data.DataSource#combineCriteria
     * DataSource.combineCriteria} rather than doing
     *  a simple addProperties() on the criteria object.
     *  <P>
     *  Default behavior for AdvancedCriteria will combine the AdvancedCriteria with the values 
     *  in the filter editor as follows:
     *  <ul>
     *  <li>If the top level criteria has operator of type "and":<br>
     *   Each field in the top level
     *   criteria array for which a 'canFilter' true field is shown in the listGrid will show up
     *   if the specified operator matches the default filter behavior 
     * (based on the {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchTextMatchStyle autoFetchTextMatchStyle}).<br>
     *   If the user enters values in the filter editor, these will be combined with the
     *   existing AdvancedCriteria by either replacing or adding field level criteria at the top 
     *   level.</li>
     *  <li>If the top level criteria is a single field-criteria:<br>
     *   If the field shows up in the listGrid and is canFilter:true, it will be displayed to
     *   the user (if the operator matches the default filter behavior for the field).<br>
     *   If the user enters new filter criteria in the filterEditor, they will be combined with
     *   this existing criterion via a top level "and" operator, or if the user modifies the
     *   field for which the criterion already existed, it will be replaced.</li>
     *  <li>Otherwise, if there are multiple top level criteria combined with an "or" operator,
     *   these will not be shown in the filter editor. Any filter parameters the user enters will
     *   be added to the existing criteria via an additional top level "and" operator, meaning
     *   the user will essentially filter a subset of the existing criteria</li>
     *  </ul>
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor} property. Allows the filter editor to be shown or hidden at runtime.
     *
     * @param showFilterEditor true if the filter editor should be shown, false if it should be hidden. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_autofit_filter" target="examples">Filter Example</a>
     */
    public void setShowFilterEditor(Boolean showFilterEditor) {
        setAttribute("showFilterEditor", showFilterEditor, true);
    }

    /**
     * Should this listGrid display a filter row.  If true, this ListGrid
     *  will be drawn with a single editable row, (separate from the body) with a filter button.
     *  <P>
     *  Values entered into this row are used as filter criteria to filter this List's data on
     * enter-keypress or filter button click. {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchTextMatchStyle
     * autoFetchTextMatchStyle} determines
     * the textMatchStyle for the request passed to {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData
     * ListGrid.fetchData}.
     *  <P>
     * Note that if {@link com.smartgwt.client.widgets.grid.ListGrid#filterData ListGrid.filterData} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData ListGrid.fetchData} is called directly
     *  while the filter editor is showing, the filter editor values will be updated to reflect the
     *  new set of criteria. If you wish to retain the user entered filter criteria and 
     *  programmatically modify a subset of field values programmatically this can be achieved by
     *  deriving new criteria by copying the existing set of criteria and adding other changes - 
     *  something like this:
     *  <pre><code>
     *    var newCriteria = myListGrid.getFilterEditorCriteria();
     *    isc.addProperties(newCriteria, {
     *       field1:"new value1",
     *       field2:"new value2"
     *    });
     *    myListGrid.setCriteria(newCriteria);
     *  </code></pre>
     * In this example code we're using {@link com.smartgwt.client.widgets.grid.ListGrid#getFilterEditorCriteria
     * ListGrid.getFilterEditorCriteria} rather than 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getCriteria ListGrid.getCriteria} - this ensures that if the user has
     * typed a new value into
     *  the filter editor, but not yet clicked the filter button, we pick up the value the user
     *  entered.
     *  <P>
     *  If you call <code>filterData()</code> and pass in criteria for dataSource 
     *  fields that are not present in the ListGrid, these criteria will continue to be applied along
     *  with the user visible criteria.
     *  <P>
     *  <b>filterEditor and advanced criteria</b>: If a developer calls <code>filterData()</code>
     *  on a ListGrid and passes in {@link com.smartgwt.client.data.AdvancedCriteria}, expected behavior of the filter 
     *  editor becomes ambiguous, as  AdvancedCriteria supports far more complex filter 
     *  expressions than the ordinary filterEditor is capable of expressing.
     *  <br>
     *  The above example code assumes simple criteria, but if we wanted to apply advanced 
     * criteria to the grid we could call {@link com.smartgwt.client.data.DataSource#combineCriteria
     * DataSource.combineCriteria} rather than doing
     *  a simple addProperties() on the criteria object.
     *  <P>
     *  Default behavior for AdvancedCriteria will combine the AdvancedCriteria with the values 
     *  in the filter editor as follows:
     *  <ul>
     *  <li>If the top level criteria has operator of type "and":<br>
     *   Each field in the top level
     *   criteria array for which a 'canFilter' true field is shown in the listGrid will show up
     *   if the specified operator matches the default filter behavior 
     * (based on the {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchTextMatchStyle autoFetchTextMatchStyle}).<br>
     *   If the user enters values in the filter editor, these will be combined with the
     *   existing AdvancedCriteria by either replacing or adding field level criteria at the top 
     *   level.</li>
     *  <li>If the top level criteria is a single field-criteria:<br>
     *   If the field shows up in the listGrid and is canFilter:true, it will be displayed to
     *   the user (if the operator matches the default filter behavior for the field).<br>
     *   If the user enters new filter criteria in the filterEditor, they will be combined with
     *   this existing criterion via a top level "and" operator, or if the user modifies the
     *   field for which the criterion already existed, it will be replaced.</li>
     *  <li>Otherwise, if there are multiple top level criteria combined with an "or" operator,
     *   these will not be shown in the filter editor. Any filter parameters the user enters will
     *   be added to the existing criteria via an additional top level "and" operator, meaning
     *   the user will essentially filter a subset of the existing criteria</li>
     *  </ul>
     *
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_autofit_filter" target="examples">Filter Example</a>
     */
    public Boolean getShowFilterEditor()  {
        return getAttributeAsBoolean("showFilterEditor");
    }

    /**
     * Should this ListGrid show a summary row beneath the last record of the grid. This summary row will contain per-field
     * summary information. See {@link com.smartgwt.client.widgets.grid.ListGridField#getShowGridSummary showGridSummary} and
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getGridSummaryFunction ListGrid.getGridSummaryFunction} for details on
     * how the summary value to be displayed for each column will be calculated. <P> Note that the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSummaryRow summaryRow autoChild} will be created to actually display the
     * summary row.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} attribute
     *
     * @param showGridSummary new value for this.showGridSummary. Default value is false
     */
    public void setShowGridSummary(Boolean showGridSummary) {
        setAttribute("showGridSummary", showGridSummary, true);
    }

    /**
     * Should this ListGrid show a summary row beneath the last record of the grid. This summary row will contain per-field
     * summary information. See {@link com.smartgwt.client.widgets.grid.ListGridField#getShowGridSummary showGridSummary} and
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getGridSummaryFunction ListGrid.getGridSummaryFunction} for details on
     * how the summary value to be displayed for each column will be calculated. <P> Note that the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSummaryRow summaryRow autoChild} will be created to actually display the
     * summary row.
     *
     *
     * @return Boolean
     */
    public Boolean getShowGridSummary()  {
        return getAttributeAsBoolean("showGridSummary");
    }

    /**
     * If this listGrid supports {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy grouping}, setting this
     * property will cause the grid to render an extra row at the end of each group when grouped, containing summary
     * information for the fields. Summary information will be calculated by the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGroupSummary ListGridField.getGroupSummary} method if specified,
     * otherwise via the specified {@link com.smartgwt.client.widgets.grid.ListGridField#getSummaryFunction summaryFunction}.
     *
     * @param showGroupSummary showGroupSummary Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGrid#setGroupByFieldSummaries
     */
    public void setShowGroupSummary(Boolean showGroupSummary) {
        setAttribute("showGroupSummary", showGroupSummary, true);
    }

    /**
     * If this listGrid supports {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy grouping}, setting this
     * property will cause the grid to render an extra row at the end of each group when grouped, containing summary
     * information for the fields. Summary information will be calculated by the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGroupSummary ListGridField.getGroupSummary} method if specified,
     * otherwise via the specified {@link com.smartgwt.client.widgets.grid.ListGridField#getSummaryFunction summaryFunction}.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#getGroupByFieldSummaries
     */
    public Boolean getShowGroupSummary()  {
        return getAttributeAsBoolean("showGroupSummary");
    }

    /**
     * If this grid is {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy grouped}, and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true, setting this property causes
     * field summary values for each group to be displayed directly in the group header node, rather than showing up at the
     * bottom of each expanded group. <P> Note that this means the group header node will be showing multiple field values
     * rather than the default display of a single cell spanning all columns containing the group title. Developers may specify
     * an explicit {@link com.smartgwt.client.widgets.grid.ListGrid#getGroupTitleField groupTitleField}, or rely on the
     * automatically generated {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGroupTitleColumn groupTitleColumn} to
     * have group titles be visible in as well as the summary values. <P> Also note that multi-line group summaries are not
     * supported when showing the group summary in the group header. If multiple  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getSummaryFunction field summary functions} are defined for some field
     * only the first will be displayed when this property is set to true.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummaryInHeader showGroupSummaryInHeader}
     *
     * @param showGroupSummaryInHeader new showGroupSummaryInHeader state. Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public void setShowGroupSummaryInHeader(Boolean showGroupSummaryInHeader) {
        setAttribute("showGroupSummaryInHeader", showGroupSummaryInHeader, true);
    }

    /**
     * If this grid is {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy grouped}, and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true, setting this property causes
     * field summary values for each group to be displayed directly in the group header node, rather than showing up at the
     * bottom of each expanded group. <P> Note that this means the group header node will be showing multiple field values
     * rather than the default display of a single cell spanning all columns containing the group title. Developers may specify
     * an explicit {@link com.smartgwt.client.widgets.grid.ListGrid#getGroupTitleField groupTitleField}, or rely on the
     * automatically generated {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGroupTitleColumn groupTitleColumn} to
     * have group titles be visible in as well as the summary values. <P> Also note that multi-line group summaries are not
     * supported when showing the group summary in the group header. If multiple  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getSummaryFunction field summary functions} are defined for some field
     * only the first will be displayed when this property is set to true.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public Boolean getShowGroupSummaryInHeader()  {
        return getAttributeAsBoolean("showGroupSummaryInHeader");
    }

    /**
     * If this grid is {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy grouped} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummaryInHeader showGroupSummaryInHeader} is true, instead of
     * group header nodes showing up with a single cell value spanning the full set of columns, summaries for each field will
     * show up in the appropriate columns of the  header node. <P> In this case there are 2 options for where the group title
     * will show up. Developers may specify an existing field to put the title values into via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGroupTitleField groupTitleField}. If no groupTitleField is specified, this
     * property may be set to <code>true</code> which causes a <code>groupTitleColumn</code> to be automatically generated.
     * Each group header will show the group title in this column (records within the group will not show a value for this
     * column). The column appears in the leftmost position within the grid (unless {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowRowNumbers showRowNumbers} is true, in which case this column shows up
     * in the second-leftmost position), and by default will auto-fit to its data. <P> To customize this field, developers may
     * modify  {@link com.smartgwt.client.widgets.grid.ListGrid#getGroupTitleColumnProperties groupTitleColumnProperties}
     *
     * @param showGroupTitleColumn showGroupTitleColumn Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowGroupTitleColumn(Boolean showGroupTitleColumn)  throws IllegalStateException {
        setAttribute("showGroupTitleColumn", showGroupTitleColumn, false);
    }

    /**
     * If this grid is {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy grouped} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummaryInHeader showGroupSummaryInHeader} is true, instead of
     * group header nodes showing up with a single cell value spanning the full set of columns, summaries for each field will
     * show up in the appropriate columns of the  header node. <P> In this case there are 2 options for where the group title
     * will show up. Developers may specify an existing field to put the title values into via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGroupTitleField groupTitleField}. If no groupTitleField is specified, this
     * property may be set to <code>true</code> which causes a <code>groupTitleColumn</code> to be automatically generated.
     * Each group header will show the group title in this column (records within the group will not show a value for this
     * column). The column appears in the leftmost position within the grid (unless {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowRowNumbers showRowNumbers} is true, in which case this column shows up
     * in the second-leftmost position), and by default will auto-fit to its data. <P> To customize this field, developers may
     * modify  {@link com.smartgwt.client.widgets.grid.ListGrid#getGroupTitleColumnProperties groupTitleColumnProperties}
     *
     *
     * @return Boolean
     */
    public Boolean getShowGroupTitleColumn()  {
        return getAttributeAsBoolean("showGroupTitleColumn");
    }

    /**
     * Should we show the header for this ListGrid?
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Show or hide the ListGrid header.
     *
     * @param showHeader true to show the header, false to hide it.. Default value is true
     * @see com.smartgwt.client.docs.GridHeader GridHeader overview and related methods
     */
    public void setShowHeader(Boolean showHeader) {
        setAttribute("showHeader", showHeader, true);
    }

    /**
     * Should we show the header for this ListGrid?
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.GridHeader GridHeader overview and related methods
     */
    public Boolean getShowHeader()  {
        return getAttributeAsBoolean("showHeader");
    }

    /**
     * Whether to show a context menu on the header with standard items for showing and hiding fields.
     *
     * @param showHeaderContextMenu showHeaderContextMenu Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.grid.ListGrid#displayHeaderContextMenu
     * @see com.smartgwt.client.widgets.grid.ListGrid#getHeaderContextMenuItems
     * @see com.smartgwt.client.docs.GridHeader GridHeader overview and related methods
     */
    public void setShowHeaderContextMenu(Boolean showHeaderContextMenu)  throws IllegalStateException {
        setAttribute("showHeaderContextMenu", showHeaderContextMenu, false);
    }

    /**
     * Whether to show a context menu on the header with standard items for showing and hiding fields.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#displayHeaderContextMenu
     * @see com.smartgwt.client.widgets.grid.ListGrid#getHeaderContextMenuItems
     * @see com.smartgwt.client.docs.GridHeader GridHeader overview and related methods
     */
    public Boolean getShowHeaderContextMenu()  {
        return getAttributeAsBoolean("showHeaderContextMenu");
    }

    /**
     * If set to true and {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} is
     * true, the {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderMenuButton headerMenuButton} will be displayed when
     * the user rolls over the header buttons in this grid.
     *
     * @param showHeaderMenuButton showHeaderMenuButton Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowHeaderMenuButton(Boolean showHeaderMenuButton)  throws IllegalStateException {
        setAttribute("showHeaderMenuButton", showHeaderMenuButton, false);
    }

    /**
     * If set to true and {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} is
     * true, the {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderMenuButton headerMenuButton} will be displayed when
     * the user rolls over the header buttons in this grid.
     *
     *
     * @return Boolean
     */
    public Boolean getShowHeaderMenuButton()  {
        return getAttributeAsBoolean("showHeaderMenuButton");
    }

    /**
     * If true, and canHover is also true, when the user hovers over a cell, hover text will pop up next to the mouse.  The
     * contents of the hover is determined by {@link com.smartgwt.client.widgets.grid.ListGrid#cellHoverHTML
     * ListGrid.cellHoverHTML}.
     *
     * @param showHover showHover Default value is true
     * @see com.smartgwt.client.widgets.grid.ListGrid#setCanHover
     * @see com.smartgwt.client.widgets.grid.ListGrid#cellHoverHTML
     */
    public void setShowHover(Boolean showHover) {
        setAttribute("showHover", showHover, true);
    }

    /**
     * If true, and canHover is also true, when the user hovers over a cell, hover text will pop up next to the mouse.  The
     * contents of the hover is determined by {@link com.smartgwt.client.widgets.grid.ListGrid#cellHoverHTML
     * ListGrid.cellHoverHTML}.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCanHover
     * @see com.smartgwt.client.widgets.grid.ListGrid#cellHoverHTML
     */
    public Boolean getShowHover()  {
        return getAttributeAsBoolean("showHover");
    }

    /**
     * When set to true and canHover is also true, shows a widget hovering at the mouse point. <P> A number of builtin modes
     * are provided - see {@link com.smartgwt.client.types.HoverMode}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showHoverComponents showHoverComponents Default value is false
     */
    public void setShowHoverComponents(Boolean showHoverComponents) {
        setAttribute("showHoverComponents", showHoverComponents, true);
    }

    /**
     * When set to true and canHover is also true, shows a widget hovering at the mouse point. <P> A number of builtin modes
     * are provided - see {@link com.smartgwt.client.types.HoverMode}.
     *
     *
     * @return Boolean
     */
    public Boolean getShowHoverComponents()  {
        return getAttributeAsBoolean("showHoverComponents");
    }

    /**
     * If set to true, this listGrid should create and show an embedded component in every row of the grid. <P> Developers
     * using this feature should implement the  {@link com.smartgwt.client.widgets.grid.ListGrid#createRecordComponent
     * ListGrid.createRecordComponent} and {@link com.smartgwt.client.widgets.grid.ListGrid#updateRecordComponent
     * ListGrid.updateRecordComponent} methods. <P> createRecordComponent() will be called by the grid as rows are rendered to
     * create the record components to use per record or per cell.  Your implementation should return a component to embed in
     * the record passed in. Note that this method should create and return a new component each time it is called. <P> This
     * feature also supports reusing components in different rows in the grid. If  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordComponentPoolingMode recordComponentPoolingMode} is set to
     * <code>"recycle"</code>, components created by the <code>createRecordComponent</code> method will become available for
     * reuse when they are no longer associated with a record. The system will automatically store these in a pool. When a
     * record with no associated component is rendered, if there are any recordComponents in this pool,  the system will call
     * {@link com.smartgwt.client.widgets.grid.ListGrid#updateRecordComponent ListGrid.updateRecordComponent}, and pass in the
     * component. This allows the developer to apply record-specific attributes to an already created component and render it
     * out into the new record. This greatly improves performance for  large grids as it allows a small number of components to
     * be created and reused rather  than maintaining potentially one record component for every cell in the grid. <P> Record
     * components are refreshed according to the recordComponentPooling mode. If set to  <code>data</code> components will be
     * maintained as long as their associated record remains present in the data set (but this can require a component to be
     * created for every record so is not desirable for large data sets). Otherwise record components are refreshed as they are
     * scrolled into view. Note that you can explicitly refresh record components via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#invalidateRecordComponents ListGrid.invalidateRecordComponents} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#refreshRecordComponent ListGrid.refreshRecordComponent} <P> NOTE:
     * recordComponents can have an impact on row height and therefore may require {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getVirtualScrolling virtualScrolling}. This is not supported in conjunction
     * with {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen fields}. If you are using recordComponents
     * in a listGrid with frozenFields, you can specify an explicit {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordComponentHeight recordComponentHeight} to ensure every row in the
     * grid renders tall enough to accommodate the recordComponents, and as such virtual scrolling is not required.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents showRecordComponents} attribute
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showRecordComponents new value for <code>this.showRecordComponents</code>. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setRecordComponentPosition
     * @see com.smartgwt.client.widgets.grid.ListGrid#setShowRecordComponentsByCell
     * @see com.smartgwt.client.types.RecordComponentPoolingMode
     * @see com.smartgwt.client.widgets.grid.ListGrid#showRecordComponent
     * @see com.smartgwt.client.widgets.grid.ListGrid#createRecordComponent
     * @see com.smartgwt.client.widgets.grid.ListGrid#updateRecordComponent
     */
    public void setShowRecordComponents(Boolean showRecordComponents) {
        setAttribute("showRecordComponents", showRecordComponents, true);
    }

    /**
     * If set to true, this listGrid should create and show an embedded component in every row of the grid. <P> Developers
     * using this feature should implement the  {@link com.smartgwt.client.widgets.grid.ListGrid#createRecordComponent
     * ListGrid.createRecordComponent} and {@link com.smartgwt.client.widgets.grid.ListGrid#updateRecordComponent
     * ListGrid.updateRecordComponent} methods. <P> createRecordComponent() will be called by the grid as rows are rendered to
     * create the record components to use per record or per cell.  Your implementation should return a component to embed in
     * the record passed in. Note that this method should create and return a new component each time it is called. <P> This
     * feature also supports reusing components in different rows in the grid. If  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordComponentPoolingMode recordComponentPoolingMode} is set to
     * <code>"recycle"</code>, components created by the <code>createRecordComponent</code> method will become available for
     * reuse when they are no longer associated with a record. The system will automatically store these in a pool. When a
     * record with no associated component is rendered, if there are any recordComponents in this pool,  the system will call
     * {@link com.smartgwt.client.widgets.grid.ListGrid#updateRecordComponent ListGrid.updateRecordComponent}, and pass in the
     * component. This allows the developer to apply record-specific attributes to an already created component and render it
     * out into the new record. This greatly improves performance for  large grids as it allows a small number of components to
     * be created and reused rather  than maintaining potentially one record component for every cell in the grid. <P> Record
     * components are refreshed according to the recordComponentPooling mode. If set to  <code>data</code> components will be
     * maintained as long as their associated record remains present in the data set (but this can require a component to be
     * created for every record so is not desirable for large data sets). Otherwise record components are refreshed as they are
     * scrolled into view. Note that you can explicitly refresh record components via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#invalidateRecordComponents ListGrid.invalidateRecordComponents} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#refreshRecordComponent ListGrid.refreshRecordComponent} <P> NOTE:
     * recordComponents can have an impact on row height and therefore may require {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getVirtualScrolling virtualScrolling}. This is not supported in conjunction
     * with {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen fields}. If you are using recordComponents
     * in a listGrid with frozenFields, you can specify an explicit {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordComponentHeight recordComponentHeight} to ensure every row in the
     * grid renders tall enough to accommodate the recordComponents, and as such virtual scrolling is not required.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#getRecordComponentPosition
     * @see com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponentsByCell
     * @see com.smartgwt.client.types.RecordComponentPoolingMode
     * @see com.smartgwt.client.widgets.grid.ListGrid#showRecordComponent
     * @see com.smartgwt.client.widgets.grid.ListGrid#createRecordComponent
     * @see com.smartgwt.client.widgets.grid.ListGrid#updateRecordComponent
     */
    public Boolean getShowRecordComponents()  {
        return getAttributeAsBoolean("showRecordComponents");
    }

    /**
     * Should we show different styling for the cell the mouse is over? <br> If true, the cell style will have the suffix
     * "Over" appended.
     *
     * @param showRollOver showRollOver Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowRollOver(Boolean showRollOver) {
        setAttribute("showRollOver", showRollOver, true);
    }

    /**
     * Should we show different styling for the cell the mouse is over? <br> If true, the cell style will have the suffix
     * "Over" appended.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowRollOver()  {
        return getAttributeAsBoolean("showRollOver");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRollOver showRollOver} is true, this property provides an
     * option to show roll over styling with the {@link com.smartgwt.client.widgets.grid.ListGrid#getRollOverCanvas
     * rollOverCanvas} and {@link com.smartgwt.client.widgets.grid.ListGrid#getRollUnderCanvas rollUnderCanvas} rather than
     * using css styling.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showRollOverCanvas showRollOverCanvas Default value is null
     */
    public void setShowRollOverCanvas(Boolean showRollOverCanvas) {
        setAttribute("showRollOverCanvas", showRollOverCanvas, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRollOver showRollOver} is true, this property provides an
     * option to show roll over styling with the {@link com.smartgwt.client.widgets.grid.ListGrid#getRollOverCanvas
     * rollOverCanvas} and {@link com.smartgwt.client.widgets.grid.ListGrid#getRollUnderCanvas rollUnderCanvas} rather than
     * using css styling.
     *
     *
     * @return Boolean
     */
    public Boolean getShowRollOverCanvas()  {
        return getAttributeAsBoolean("showRollOverCanvas");
    }

    /**
     * When set to true, shows an additional field at the beginning of the field-list  (respecting RTL) that displays the
     * current rowNum for each record.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showRowNumbers showRowNumbers Default value is null
     */
    public void setShowRowNumbers(Boolean showRowNumbers) {
        setAttribute("showRowNumbers", showRowNumbers, true);
    }

    /**
     * When set to true, shows an additional field at the beginning of the field-list  (respecting RTL) that displays the
     * current rowNum for each record.
     *
     *
     * @return Boolean
     */
    public Boolean getShowRowNumbers()  {
        return getAttributeAsBoolean("showRowNumbers");
    }

    /**
     * Should the "Selected" style be applied to selected records?
     *
     * @param showSelectedStyle showSelectedStyle Default value is true
     * @see com.smartgwt.client.grid.GridRenderer#getCellStyle
     */
    public void setShowSelectedStyle(Boolean showSelectedStyle) {
        setAttribute("showSelectedStyle", showSelectedStyle, true);
    }

    /**
     * Should the "Selected" style be applied to selected records?
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.grid.GridRenderer#getCellStyle
     */
    public Boolean getShowSelectedStyle()  {
        return getAttributeAsBoolean("showSelectedStyle");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionType selectionType} is set to <code>"single"</code>,
     * setting this property to true means selection will be displayed to the user with the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSelectionCanvas selectionCanvas}  and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSelectionUnderCanvas selectionUnderCanvas} rather than using css styling.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showSelectionCanvas showSelectionCanvas Default value is null
     */
    public void setShowSelectionCanvas(Boolean showSelectionCanvas) {
        setAttribute("showSelectionCanvas", showSelectionCanvas, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionType selectionType} is set to <code>"single"</code>,
     * setting this property to true means selection will be displayed to the user with the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSelectionCanvas selectionCanvas}  and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSelectionUnderCanvas selectionUnderCanvas} rather than using css styling.
     *
     *
     * @return Boolean
     */
    public Boolean getShowSelectionCanvas()  {
        return getAttributeAsBoolean("showSelectionCanvas");
    }

    /**
     * Indicates whether a sorting arrow should appear for the listGrid, and its location. See {@link
     * com.smartgwt.client.types.SortArrow} for details. <P> Clicking the sort arrow reverses the direction of sorting for the
     * current sort column (if any), or sorts the listGrid by its first sortable column. The arrow image on the button
     * indicates the current direction of sorting. If undefined, the sort arrow will show up in the sorted field, and the
     * corner sort button will be displayed if a vertical scrollbar is being displayed
     *
     * @param showSortArrow showSortArrow Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowSortArrow(SortArrow showSortArrow) {
        setAttribute("showSortArrow", showSortArrow == null ? null : showSortArrow.getValue(), true);
    }

    /**
     * Indicates whether a sorting arrow should appear for the listGrid, and its location. See {@link
     * com.smartgwt.client.types.SortArrow} for details. <P> Clicking the sort arrow reverses the direction of sorting for the
     * current sort column (if any), or sorts the listGrid by its first sortable column. The arrow image on the button
     * indicates the current direction of sorting. If undefined, the sort arrow will show up in the sorted field, and the
     * corner sort button will be displayed if a vertical scrollbar is being displayed
     *
     *
     * @return SortArrow
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public SortArrow getShowSortArrow()  {
        return EnumUtil.getEnum(SortArrow.values(), getAttribute("showSortArrow"));
    }

    /**
     * When multiple fields are sorted, set this to false to hide the sort-numeral  displayed by default after the sort-arrows
     * in the header-buttons of sorted fields.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showSortNumerals showSortNumerals Default value is null
     */
    public void setShowSortNumerals(Boolean showSortNumerals) {
        setAttribute("showSortNumerals", showSortNumerals, true);
    }

    /**
     * When multiple fields are sorted, set this to false to hide the sort-numeral  displayed by default after the sort-arrows
     * in the header-buttons of sorted fields.
     *
     *
     * @return Boolean
     */
    public Boolean getShowSortNumerals()  {
        return getAttributeAsBoolean("showSortNumerals");
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans} are in use, whether to show a
     * hierarchical column picker that includes both headerSpans and normal headers, with normal headers indented under
     * headerSpans similarly to how a {@link com.smartgwt.client.widgets.tree.TreeGrid} displays a Tree. <P> If
     * <code>showTreeColumnPicker</code> is false, no column picker will be shown on the headerSpan itself, and the column
     * picker for a clicked on a normal field header will include only normal fields.
     *
     * @param showTreeColumnPicker showTreeColumnPicker Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowTreeColumnPicker(Boolean showTreeColumnPicker)  throws IllegalStateException {
        setAttribute("showTreeColumnPicker", showTreeColumnPicker, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans} are in use, whether to show a
     * hierarchical column picker that includes both headerSpans and normal headers, with normal headers indented under
     * headerSpans similarly to how a {@link com.smartgwt.client.widgets.tree.TreeGrid} displays a Tree. <P> If
     * <code>showTreeColumnPicker</code> is false, no column picker will be shown on the headerSpan itself, and the column
     * picker for a clicked on a normal field header will include only normal fields.
     *
     *
     * @return Boolean
     */
    public Boolean getShowTreeColumnPicker()  {
        return getAttributeAsBoolean("showTreeColumnPicker");
    }

    /**
     * If this list grid is showing any {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen} fields, and a
     * horizontal scrollbar is visible at the bottom of the liquid columns, should an equivalent scrollbar gap be left visible
     * below the frozen columns?<br> Note that if set to <code>true</code> any backgroundColor or border applied to the
     * ListGrid will show up below the bottom row of the frozen column(s).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param shrinkForFreeze shrinkForFreeze Default value is false
     * @see com.smartgwt.client.docs.FrozenFields FrozenFields overview and related methods
     */
    public void setShrinkForFreeze(Boolean shrinkForFreeze) {
        setAttribute("shrinkForFreeze", shrinkForFreeze, true);
    }

    /**
     * If this list grid is showing any {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen} fields, and a
     * horizontal scrollbar is visible at the bottom of the liquid columns, should an equivalent scrollbar gap be left visible
     * below the frozen columns?<br> Note that if set to <code>true</code> any backgroundColor or border applied to the
     * ListGrid will show up below the bottom row of the frozen column(s).
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.FrozenFields FrozenFields overview and related methods
     */
    public Boolean getShrinkForFreeze()  {
        return getAttributeAsBoolean("shrinkForFreeze");
    }

    /**
     * If <code>record[this.singleCellValueProperty]</code> is set for some record, the  record will be displayed as a single
     * cell spanning every column in the grid, with  contents set to the value of
     * <code>record[this.singleCellValueProperty]</code>.
     *
     * @param singleCellValueProperty singleCellValueProperty Default value is "singleCellValue"
     */
    public void setSingleCellValueProperty(String singleCellValueProperty) {
        setAttribute("singleCellValueProperty", singleCellValueProperty, true);
    }

    /**
     * If <code>record[this.singleCellValueProperty]</code> is set for some record, the  record will be displayed as a single
     * cell spanning every column in the grid, with  contents set to the value of
     * <code>record[this.singleCellValueProperty]</code>.
     *
     *
     * @return String
     */
    public String getSingleCellValueProperty()  {
        return getAttributeAsString("singleCellValueProperty");
    }

    /**
     * Where do 'skin' images (those provided with the class) live?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param skinImgDir skinImgDir Default value is "images/ListGrid/"
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public void setSkinImgDir(String skinImgDir) {
        setAttribute("skinImgDir", skinImgDir, true);
    }

    /**
     * Where do 'skin' images (those provided with the class) live?
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public String getSkinImgDir()  {
        return getAttributeAsString("skinImgDir");
    }

    /**
     * Image to show when sorting ascending. See {@link com.smartgwt.client.widgets.ImgProperties} for format.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param sortAscendingImage sortAscendingImage Default value is {...}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setSortAscendingImage(ImgProperties sortAscendingImage) {
        setAttribute("sortAscendingImage", sortAscendingImage.getJsObj(), true);
    }

    /**
     * Image to show when sorting ascending. See {@link com.smartgwt.client.widgets.ImgProperties} for format.
     *
     *
     * @return ImgProperties
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public ImgProperties getSortAscendingImage()  {
        return new ImgProperties(getAttributeAsJavaScriptObject("sortAscendingImage"));
    }

    /**
     * Image to show when sorting descending. See {@link com.smartgwt.client.widgets.ImgProperties} for format.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param sortDescendingImage sortDescendingImage Default value is {...}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setSortDescendingImage(ImgProperties sortDescendingImage) {
        setAttribute("sortDescendingImage", sortDescendingImage.getJsObj(), true);
    }

    /**
     * Image to show when sorting descending. See {@link com.smartgwt.client.widgets.ImgProperties} for format.
     *
     *
     * @return ImgProperties
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public ImgProperties getSortDescendingImage()  {
        return new ImgProperties(getAttributeAsJavaScriptObject("sortDescendingImage"));
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid, this attribute will be shown as the menu item title to sort a field in ascending order.
     *
     * @param sortFieldAscendingText sortFieldAscendingText Default value is "Sort Ascending"
     */
    public void setSortFieldAscendingText(String sortFieldAscendingText) {
        setAttribute("sortFieldAscendingText", sortFieldAscendingText, true);
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid, this attribute will be shown as the menu item title to sort a field in ascending order.
     *
     *
     * @return String
     */
    public String getSortFieldAscendingText()  {
        return getAttributeAsString("sortFieldAscendingText");
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid, this attribute will be shown as the menu item title to sort a field in descending order.
     *
     * @param sortFieldDescendingText sortFieldDescendingText Default value is "Sort Descending"
     */
    public void setSortFieldDescendingText(String sortFieldDescendingText) {
        setAttribute("sortFieldDescendingText", sortFieldDescendingText, true);
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid, this attribute will be shown as the menu item title to sort a field in descending order.
     *
     *
     * @return String
     */
    public String getSortFieldDescendingText()  {
        return getAttributeAsString("sortFieldDescendingText");
    }

    /**
     * When multiple fields are sorted, the Style to apply to the numeral that appears after the  sort-arrows in the
     * header-buttons of sorted fields.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param sortNumeralStyle sortNumeralStyle Default value is "sortNumeral"
     */
    public void setSortNumeralStyle(String sortNumeralStyle) {
        setAttribute("sortNumeralStyle", sortNumeralStyle, true);
    }

    /**
     * When multiple fields are sorted, the Style to apply to the numeral that appears after the  sort-arrows in the
     * header-buttons of sorted fields.
     *
     *
     * @return String
     */
    public String getSortNumeralStyle()  {
        return getAttributeAsString("sortNumeralStyle");
    }

    /**
     * If this is an editable listGrid, this property determines how failure to save due to  validation errors should be
     * displayed to the user. <P> If this property is true, when validation errors occur the errors will be displayed to the
     * user in an alert, and focus will be returned to the first cell to fail validation. <P> If false, this the cells that
     * failed validation will be silently styled with the  editFailedBaseStyle.<br> <b>Note:</b> stopOnErrors being set to true
     * implies that 'waitForSave' is also true. We will not dismiss the editor until save has completed if stopOnErrors is
     * true.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param stopOnErrors stopOnErrors Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGrid#setWaitForSave
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setStopOnErrors(Boolean stopOnErrors) {
        setAttribute("stopOnErrors", stopOnErrors, true);
    }

    /**
     * If this is an editable listGrid, this property determines how failure to save due to  validation errors should be
     * displayed to the user. <P> If this property is true, when validation errors occur the errors will be displayed to the
     * user in an alert, and focus will be returned to the first cell to fail validation. <P> If false, this the cells that
     * failed validation will be silently styled with the  editFailedBaseStyle.<br> <b>Note:</b> stopOnErrors being set to true
     * implies that 'waitForSave' is also true. We will not dismiss the editor until save has completed if stopOnErrors is
     * true.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#getWaitForSave
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean getStopOnErrors()  {
        return getAttributeAsBoolean("stopOnErrors");
    }

    /**
     * Default CSS class
     *
     * @param styleName styleName Default value is "listGrid"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * Default CSS class
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} is true, and a {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSummaryRowDataSource summaryRowDataSource} is specified this property may
     * be used to specify fetch criteria to apply when retrieving summary data to show in the summary row. If unset, and any
     * filter criteria have been specified for the grid, they will be used.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param summaryRowCriteria summaryRowCriteria Default value is null
     */
    public void setSummaryRowCriteria(Criteria summaryRowCriteria) {
        setAttribute("summaryRowCriteria", summaryRowCriteria.getJsObj(), true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} is true, and a {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSummaryRowDataSource summaryRowDataSource} is specified this property may
     * be used to specify fetch criteria to apply when retrieving summary data to show in the summary row. If unset, and any
     * filter criteria have been specified for the grid, they will be used.
     *
     *
     * @return Criteria
     */
    public Criteria getSummaryRowCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("summaryRowCriteria"));
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} is true, by default summary
     * values are calculated on the  client based on the current data-set for the grid (see {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGridSummary ListGrid.getGridSummary} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGridSummaryFunction ListGrid.getGridSummaryFunction}). <P> In some cases
     * however it may make sense to calculate summary values on the server and retrieve them via a dataSource fetch. If set,
     * this property specifies a dataSource to fetch against for the summary row. The dataSource should return a single record
     * with summary data for each field for which summary data should be shown. Note that specifying this property completely
     * bypasses the standard client-side grid summary calculation logic. <P> The fetch may be further customized via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSummaryRowCriteria summaryRowCriteria} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSummaryRowFetchRequestProperties summaryRowFetchRequestProperties}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param summaryRowDataSource summaryRowDataSource Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSummaryRowDataSource(DataSource summaryRowDataSource)  throws IllegalStateException {
        setAttribute("summaryRowDataSource", summaryRowDataSource == null ? null : summaryRowDataSource.getOrCreateJsObj(), false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} is true, by default summary
     * values are calculated on the  client based on the current data-set for the grid (see {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGridSummary ListGrid.getGridSummary} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGridSummaryFunction ListGrid.getGridSummaryFunction}). <P> In some cases
     * however it may make sense to calculate summary values on the server and retrieve them via a dataSource fetch. If set,
     * this property specifies a dataSource to fetch against for the summary row. The dataSource should return a single record
     * with summary data for each field for which summary data should be shown. Note that specifying this property completely
     * bypasses the standard client-side grid summary calculation logic. <P> The fetch may be further customized via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSummaryRowCriteria summaryRowCriteria} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSummaryRowFetchRequestProperties summaryRowFetchRequestProperties}
     *
     *
     * @return DataSource
     */
    public DataSource getSummaryRowDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("summaryRowDataSource"));
    }

    /**
     * Default height for the {@link com.smartgwt.client.widgets.grid.ListGrid#getSummaryRow summary row autoChild}. Note that
     * this height is a minumum - the summary row has {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData
     * autoFitData} set to "vertical" so if multiple rows are visible in the grid summary, the summaryRow component will expand
     * to accomodate them.
     *
     * @param summaryRowHeight summaryRowHeight Default value is 20
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSummaryRowHeight(int summaryRowHeight)  throws IllegalStateException {
        setAttribute("summaryRowHeight", summaryRowHeight, false);
    }

    /**
     * Default height for the {@link com.smartgwt.client.widgets.grid.ListGrid#getSummaryRow summary row autoChild}. Note that
     * this height is a minumum - the summary row has {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData
     * autoFitData} set to "vertical" so if multiple rows are visible in the grid summary, the summaryRow component will expand
     * to accomodate them.
     *
     *
     * @return int
     */
    public int getSummaryRowHeight()  {
        return getAttributeAsInt("summaryRowHeight");
    }

    /**
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle} for the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSummaryRow summaryRow}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param summaryRowStyle summaryRowStyle Default value is "gridSummaryCell"
     */
    public void setSummaryRowStyle(String summaryRowStyle) {
        setAttribute("summaryRowStyle", summaryRowStyle, true);
    }

    /**
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle} for the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSummaryRow summaryRow}
     *
     *
     * @return String
     */
    public String getSummaryRowStyle()  {
        return getAttributeAsString("summaryRowStyle");
    }

    /**
     * "Tall" baseStyle for this listGrid. Only applies if {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle
     * baseStyle} is  set to null. <P> If <code>baseStyle</code> is unset, this property will be used as a base cell style
     * unless the grid is showing fixed height rows with a specified cellHeight that matches {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getNormalCellHeight normalCellHeight}, in which case {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getNormalBaseStyle normalBaseStyle} will be used. Note that in Internet
     * Explorer if {@link com.smartgwt.client.widgets.grid.ListGrid#getFastCellUpdates fastCellUpdates} is true,
     * <code>tallBaseStyle</code> will also be used even if the cellHeight matches the specified <code>normalCellHeight</code>
     * for the grid.
     *
     * @param tallBaseStyle tallBaseStyle Default value is "cell"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle
     */
    public void setTallBaseStyle(String tallBaseStyle)  throws IllegalStateException {
        setAttribute("tallBaseStyle", tallBaseStyle, false);
    }

    /**
     * "Tall" baseStyle for this listGrid. Only applies if {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle
     * baseStyle} is  set to null. <P> If <code>baseStyle</code> is unset, this property will be used as a base cell style
     * unless the grid is showing fixed height rows with a specified cellHeight that matches {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getNormalCellHeight normalCellHeight}, in which case {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getNormalBaseStyle normalBaseStyle} will be used. Note that in Internet
     * Explorer if {@link com.smartgwt.client.widgets.grid.ListGrid#getFastCellUpdates fastCellUpdates} is true,
     * <code>tallBaseStyle</code> will also be used even if the cellHeight matches the specified <code>normalCellHeight</code>
     * for the grid.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle
     */
    public String getTallBaseStyle()  {
        return getAttributeAsString("tallBaseStyle");
    }

    /**
     * Default image to use for the dragTracker when things are dragged within or out of this  list. See {@link
     * com.smartgwt.client.widgets.ImgProperties} for format.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param trackerImage trackerImage Default value is {...}
     * @see com.smartgwt.client.widgets.grid.ListGrid#setDragTrackerMode
     * @see com.smartgwt.client.widgets.grid.ListGrid#getDragTrackerIcon
     */
    public void setTrackerImage(ImgProperties trackerImage) {
        setAttribute("trackerImage", trackerImage.getJsObj(), true);
    }

    /**
     * Default image to use for the dragTracker when things are dragged within or out of this  list. See {@link
     * com.smartgwt.client.widgets.ImgProperties} for format.
     *
     *
     * @return ImgProperties
     * @see com.smartgwt.client.widgets.grid.ListGrid#getDragTrackerMode
     * @see com.smartgwt.client.widgets.grid.ListGrid#getDragTrackerIcon
     */
    public ImgProperties getTrackerImage()  {
        return new ImgProperties(getAttributeAsJavaScriptObject("trackerImage"));
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields this.canFreezeFields} is true, this string
     * will be shown as the title for the menu item to unfreeze a currently frozen field. <P> This is a dynamic string - text
     * within <code>\${...}</code> will be evaluated as JS code when the message is displayed, with <code>title</code>
     * available as a variable containing the field title. <P> Default value returns "Unfreeze " + the field's summary title.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param unfreezeFieldText unfreezeFieldText Default value is "Unfreeze \$title}"
     */
    public void setUnfreezeFieldText(String unfreezeFieldText) {
        setAttribute("unfreezeFieldText", unfreezeFieldText, true);
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields this.canFreezeFields} is true, this string
     * will be shown as the title for the menu item to unfreeze a currently frozen field. <P> This is a dynamic string - text
     * within <code>\${...}</code> will be evaluated as JS code when the message is displayed, with <code>title</code>
     * available as a variable containing the field title. <P> Default value returns "Unfreeze " + the field's summary title.
     *
     *
     * @return String
     */
    public String getUnfreezeFieldText()  {
        return getAttributeAsString("unfreezeFieldText");
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid, and {@link com.smartgwt.client.widgets.grid.ListGrid#getIsGrouped this.isGrouped} is true, this attribute will be
     * shown as the title for the menu item to ungroup the grid.
     *
     * @param ungroupText ungroupText Default value is "Ungroup"
     */
    public void setUngroupText(String ungroupText) {
        setAttribute("ungroupText", ungroupText, true);
    }

    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid, and {@link com.smartgwt.client.widgets.grid.ListGrid#getIsGrouped this.isGrouped} is true, this attribute will be
     * shown as the title for the menu item to ungroup the grid.
     *
     *
     * @return String
     */
    public String getUngroupText()  {
        return getAttributeAsString("ungroupText");
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is enabled, this icon will
     * be shown in the auto generated field fro removing records if the record has been marked as removed via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#markRecordRemoved ListGrid.markRecordRemoved}. At this point, clicking on the
     * icon will unmark the record as removed.
     *
     * @param unremoveIcon unremoveIcon Default value is "[SKIN]/actions/undo.png"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUnremoveIcon(String unremoveIcon)  throws IllegalStateException {
        setAttribute("unremoveIcon", unremoveIcon, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is enabled, this icon will
     * be shown in the auto generated field fro removing records if the record has been marked as removed via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#markRecordRemoved ListGrid.markRecordRemoved}. At this point, clicking on the
     * icon will unmark the record as removed.
     *
     *
     * @return String
     */
    public String getUnremoveIcon()  {
        return getAttributeAsString("unremoveIcon");
    }

    /**
     * Are rollovers cell-level or row-level?
     *
     * @param useCellRollOvers useCellRollOvers Default value is false
     */
    public void setUseCellRollOvers(Boolean useCellRollOvers) {
        setAttribute("useCellRollOvers", useCellRollOvers, true);
    }

    /**
     * Are rollovers cell-level or row-level?
     *
     *
     * @return Boolean
     */
    public Boolean getUseCellRollOvers()  {
        return getAttributeAsBoolean("useCellRollOvers");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveLocally saveLocally} is specified, but this grid is bound to
     * a DataSource which includes remote field validators, by default edits will be saved synchronously and these validators
     * will not be executed.<br> Set this property to <code>true</code> to ensure these remote validators are called when 
     * saving edits in saveLocally mode. Note that since these remote validators need to run on  the server, saving with this
     * property set is asynchronous, even though the data that ultimately gets updated is already present on the client.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param useRemoteValidators useRemoteValidators Default value is null
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setUseRemoteValidators(Boolean useRemoteValidators) {
        setAttribute("useRemoteValidators", useRemoteValidators, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveLocally saveLocally} is specified, but this grid is bound to
     * a DataSource which includes remote field validators, by default edits will be saved synchronously and these validators
     * will not be executed.<br> Set this property to <code>true</code> to ensure these remote validators are called when 
     * saving edits in saveLocally mode. Note that since these remote validators need to run on  the server, saving with this
     * property set is asynchronous, even though the data that ultimately gets updated is already present on the client.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Boolean getUseRemoteValidators()  {
        return getAttributeAsBoolean("useRemoteValidators");
    }

    /**
     * Whether client-side validation checks should be performed when the user moves between cells in the current edit row.  If
     * unset, defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getEditByCell editByCell}. <P> Note that validation
     * always occurs when a row is to be saved, so setting {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell
     * saveByCell}:true forces validation on cell transitions.  To completely disable automatic validation, set {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getNeverValidate neverValidate}:true.
     *
     * @param validateByCell validateByCell Default value is null
     * @see com.smartgwt.client.docs.GridValidation GridValidation overview and related methods
     */
    public void setValidateByCell(Boolean validateByCell) {
        setAttribute("validateByCell", validateByCell, true);
    }

    /**
     * Whether client-side validation checks should be performed when the user moves between cells in the current edit row.  If
     * unset, defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getEditByCell editByCell}. <P> Note that validation
     * always occurs when a row is to be saved, so setting {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell
     * saveByCell}:true forces validation on cell transitions.  To completely disable automatic validation, set {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getNeverValidate neverValidate}:true.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.GridValidation GridValidation overview and related methods
     */
    public Boolean getValidateByCell()  {
        return getAttributeAsBoolean("validateByCell");
    }

    /**
     * If true, validation will be performed on each edited cell when each editor's  "change" handler is fired.
     *
     * @param validateOnChange validateOnChange Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setValidateOnChange
     * @see com.smartgwt.client.docs.GridValidation GridValidation overview and related methods
     */
    public void setValidateOnChange(Boolean validateOnChange) {
        setAttribute("validateOnChange", validateOnChange, true);
    }

    /**
     * If true, validation will be performed on each edited cell when each editor's  "change" handler is fired.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGridField#getValidateOnChange
     * @see com.smartgwt.client.docs.GridValidation GridValidation overview and related methods
     */
    public Boolean getValidateOnChange()  {
        return getAttributeAsBoolean("validateOnChange");
    }

    /**
     * Height for value icons for this listGrid. Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize
     * valueIconSize}. Can be overridden at the field level
     *
     * @param valueIconHeight valueIconHeight Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setValueIconHeight(Integer valueIconHeight) {
        setAttribute("valueIconHeight", valueIconHeight, true);
    }

    /**
     * Height for value icons for this listGrid. Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize
     * valueIconSize}. Can be overridden at the field level
     *
     *
     * @return Integer
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getValueIconHeight()  {
        return getAttributeAsInt("valueIconHeight");
    }

    /**
     * How much padding should there be on the left of valueIcons by default Can be overridden at the field level
     *
     * @param valueIconLeftPadding valueIconLeftPadding Default value is 2
     * @see com.smartgwt.client.widgets.grid.ListGridField#setValueIcons
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setValueIconLeftPadding(int valueIconLeftPadding) {
        setAttribute("valueIconLeftPadding", valueIconLeftPadding, true);
    }

    /**
     * How much padding should there be on the left of valueIcons by default Can be overridden at the field level
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.grid.ListGridField#getValueIcons
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public int getValueIconLeftPadding()  {
        return getAttributeAsInt("valueIconLeftPadding");
    }

    /**
     * How much padding should there be on the right of valueIcons by default
     *
     * @param valueIconRightPadding valueIconRightPadding Default value is 2
     * @see com.smartgwt.client.widgets.grid.ListGridField#setValueIcons
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setValueIconRightPadding(int valueIconRightPadding) {
        setAttribute("valueIconRightPadding", valueIconRightPadding, true);
    }

    /**
     * How much padding should there be on the right of valueIcons by default
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.grid.ListGridField#getValueIcons
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public int getValueIconRightPadding()  {
        return getAttributeAsInt("valueIconRightPadding");
    }

    /**
     * Default width and height of value icons for this ListGrid. Can be overridden at the listGrid level via explicit {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconWidth valueIconWidth} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconHeight valueIconHeight}, or at the field level via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize}, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIconWidth valueIconWidth} and {ListGridField.valueIconHeight}
     *
     * @param valueIconSize valueIconSize Default value is 16
     * @see com.smartgwt.client.widgets.grid.ListGrid#setValueIconWidth
     * @see com.smartgwt.client.widgets.grid.ListGrid#setValueIconHeight
     * @see com.smartgwt.client.widgets.grid.ListGridField#setValueIconSize
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setValueIconSize(int valueIconSize) {
        setAttribute("valueIconSize", valueIconSize, true);
    }

    /**
     * Default width and height of value icons for this ListGrid. Can be overridden at the listGrid level via explicit {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconWidth valueIconWidth} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconHeight valueIconHeight}, or at the field level via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize}, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIconWidth valueIconWidth} and {ListGridField.valueIconHeight}
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.grid.ListGrid#getValueIconWidth
     * @see com.smartgwt.client.widgets.grid.ListGrid#getValueIconHeight
     * @see com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public int getValueIconSize()  {
        return getAttributeAsInt("valueIconSize");
    }

    /**
     * Width for value icons for this listGrid. Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize
     * valueIconSize}. Can be overridden at the field level
     *
     * @param valueIconWidth valueIconWidth Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setValueIconWidth(Integer valueIconWidth) {
        setAttribute("valueIconWidth", valueIconWidth, true);
    }

    /**
     * Width for value icons for this listGrid. Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize
     * valueIconSize}. Can be overridden at the field level
     *
     *
     * @return Integer
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getValueIconWidth()  {
        return getAttributeAsInt("valueIconWidth");
    }

    /**
     * When incremental rendering is switched on and there are variable record heights, the virtual scrolling mechanism manages
     * the differences in scroll height calculations due to the unknown sizes of unrendered rows to make the scrollbar and
     * viewport appear correctly. <P> virtualScrolling is switched on automatically when fixedRecordHeights is false and when
     * using the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents recordComponents subsystem}, as
     * recordComponents expand the rows that contain them. This flag should be manually enabled when calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#addEmbeddedComponent ListGrid.addEmbeddedComponent}(...) if embedded
     * components can cause record sizes to expand beyond specified cellHeight.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param virtualScrolling virtualScrolling Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setVirtualScrolling(Boolean virtualScrolling)  throws IllegalStateException {
        setAttribute("virtualScrolling", virtualScrolling, false);
    }

    /**
     * When incremental rendering is switched on and there are variable record heights, the virtual scrolling mechanism manages
     * the differences in scroll height calculations due to the unknown sizes of unrendered rows to make the scrollbar and
     * viewport appear correctly. <P> virtualScrolling is switched on automatically when fixedRecordHeights is false and when
     * using the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents recordComponents subsystem}, as
     * recordComponents expand the rows that contain them. This flag should be manually enabled when calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#addEmbeddedComponent ListGrid.addEmbeddedComponent}(...) if embedded
     * components can cause record sizes to expand beyond specified cellHeight.
     *
     *
     * @return Boolean
     */
    public Boolean getVirtualScrolling()  {
        return getAttributeAsBoolean("virtualScrolling");
    }

    /**
     * If this is an editable listGrid, this property determines whether the user will be able to dismiss the edit form, or
     * navigate to another cell while the save is in  process (before the asynchronous server response returns).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param waitForSave waitForSave Default value is false
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setWaitForSave(Boolean waitForSave) {
        setAttribute("waitForSave", waitForSave, true);
    }

    /**
     * If this is an editable listGrid, this property determines whether the user will be able to dismiss the edit form, or
     * navigate to another cell while the save is in  process (before the asynchronous server response returns).
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean getWaitForSave()  {
        return getAttributeAsBoolean("waitForSave");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is true, when the user clicks
     * the remove icon for some record, should we show a warning message  (defined as {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getWarnOnRemovalMessage warnOnRemovalMessage}) and allow the user to cancel
     * removal?
     *
     * @param warnOnRemoval warnOnRemoval Default value is false
     */
    public void setWarnOnRemoval(Boolean warnOnRemoval) {
        setAttribute("warnOnRemoval", warnOnRemoval, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is true, when the user clicks
     * the remove icon for some record, should we show a warning message  (defined as {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getWarnOnRemovalMessage warnOnRemovalMessage}) and allow the user to cancel
     * removal?
     *
     *
     * @return Boolean
     */
    public Boolean getWarnOnRemoval()  {
        return getAttributeAsBoolean("warnOnRemoval");
    }

    /**
     * Warning message to show the user on a click on the 'remove' icon  if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is true and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getWarnOnRemoval warnOnRemoval} is true.
     *
     * @param warnOnRemovalMessage warnOnRemovalMessage Default value is "Are you sure you want to delete this record?"
     */
    public void setWarnOnRemovalMessage(String warnOnRemovalMessage) {
        setAttribute("warnOnRemovalMessage", warnOnRemovalMessage, true);
    }

    /**
     * Warning message to show the user on a click on the 'remove' icon  if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is true and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getWarnOnRemoval warnOnRemoval} is true.
     *
     *
     * @return String
     */
    public String getWarnOnRemovalMessage()  {
        return getAttributeAsString("warnOnRemovalMessage");
    }

    /**
     * If a field has {@link com.smartgwt.client.widgets.grid.ListGridField#getDisplayField displayField} specified and has no
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}, this field will display the
     * value from the <code>displayField</code> of each record by default (for more on this behavior see {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}). <P> If such a field is editable,
     * changing the edit value for the field on some record,  without updating the edit value for the associated display field
     * on the same record  would mean the user would continue to see the unchanged display field value. Developers can resolve
     * this situation by programmatically setting an edit value for the display field as well as the data field, or avoid it by
     * specifying an optionDataSource and ensuring {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchDisplayMap
     * autoFetchDisplayMap} is true, or setting an explicit valueMap for the field. <P> By default, when the edit value on a
     * field with a specified displayField and  no optionDataSource is set, we log a warning to notify the developer. This
     * warning may be disabled by setting <code>warnOnUnmappedValueFieldChange</code> to <code>false</code>. <P> Note: There
     * are actually a couple of cases in which the system will automatically derive a new display-field value and apply it to
     * the record: <ol><li>If the edit value was changed by a user actually editing the record  (rather than a programmatic
     * call to setEditValue()), and the edit-item had a valueMap or optionDataSource set, we automatically pick up the display
     * value from that item and store it as an edit-value for the displayField of the record</li>     <li>If the listGrid has a
     * loaded record in its data set whose valueField value matches the edit value for the valueField, we automatically apply
     * the displayField value from that record as an edit value for the displayField on the newly edited record.</li></ol> In
     * either case, the display value for the record is updated automatically  (and the warning would not be logged).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param warnOnUnmappedValueFieldChange warnOnUnmappedValueFieldChange Default value is true
     */
    public void setWarnOnUnmappedValueFieldChange(Boolean warnOnUnmappedValueFieldChange) {
        setAttribute("warnOnUnmappedValueFieldChange", warnOnUnmappedValueFieldChange, true);
    }

    /**
     * If a field has {@link com.smartgwt.client.widgets.grid.ListGridField#getDisplayField displayField} specified and has no
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}, this field will display the
     * value from the <code>displayField</code> of each record by default (for more on this behavior see {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}). <P> If such a field is editable,
     * changing the edit value for the field on some record,  without updating the edit value for the associated display field
     * on the same record  would mean the user would continue to see the unchanged display field value. Developers can resolve
     * this situation by programmatically setting an edit value for the display field as well as the data field, or avoid it by
     * specifying an optionDataSource and ensuring {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchDisplayMap
     * autoFetchDisplayMap} is true, or setting an explicit valueMap for the field. <P> By default, when the edit value on a
     * field with a specified displayField and  no optionDataSource is set, we log a warning to notify the developer. This
     * warning may be disabled by setting <code>warnOnUnmappedValueFieldChange</code> to <code>false</code>. <P> Note: There
     * are actually a couple of cases in which the system will automatically derive a new display-field value and apply it to
     * the record: <ol><li>If the edit value was changed by a user actually editing the record  (rather than a programmatic
     * call to setEditValue()), and the edit-item had a valueMap or optionDataSource set, we automatically pick up the display
     * value from that item and store it as an edit-value for the displayField of the record</li>     <li>If the listGrid has a
     * loaded record in its data set whose valueField value matches the edit value for the valueField, we automatically apply
     * the displayField value from that record as an edit value for the displayField on the newly edited record.</li></ol> In
     * either case, the display value for the record is updated automatically  (and the warning would not be logged).
     *
     *
     * @return Boolean
     */
    public Boolean getWarnOnUnmappedValueFieldChange()  {
        return getAttributeAsBoolean("warnOnUnmappedValueFieldChange");
    }

    /**
     * Should content within cells be allowed to wrap? <P> Even if content is allowed to wrap, if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFixedRecordHeights fixedRecordHeights} is set, the content will be clipped
     * off at the cell boundary.  Either set a larger, fixed {@link com.smartgwt.client.widgets.grid.ListGrid#getCellHeight
     * cellHeight} to reveal more content, or set {@link com.smartgwt.client.widgets.grid.ListGrid#getFixedRecordHeights
     * fixedRecordHeights} to false to allow auto-sizing.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param wrapCells wrapCells Default value is false
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_autofit_values" target="examples">Cell Values Example</a>
     */
    public void setWrapCells(Boolean wrapCells) {
        setAttribute("wrapCells", wrapCells, true);
    }

    /**
     * Should content within cells be allowed to wrap? <P> Even if content is allowed to wrap, if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFixedRecordHeights fixedRecordHeights} is set, the content will be clipped
     * off at the cell boundary.  Either set a larger, fixed {@link com.smartgwt.client.widgets.grid.ListGrid#getCellHeight
     * cellHeight} to reveal more content, or set {@link com.smartgwt.client.widgets.grid.ListGrid#getFixedRecordHeights
     * fixedRecordHeights} to false to allow auto-sizing.
     *
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_autofit_values" target="examples">Cell Values Example</a>
     */
    public Boolean getWrapCells()  {
        return getAttributeAsBoolean("wrapCells");
    }

    // ********************* Methods ***********************
            
    /**
     * Attaches the component to the provided record. If <code>position</code> is specified as  <code>"within"</code> {@link
     * com.smartgwt.client.widgets.Canvas#getSnapTo snapTo} and {@link com.smartgwt.client.widgets.Canvas#getSnapOffsetLeft
     * snapOffsetLeft},  {@link com.smartgwt.client.widgets.Canvas#getSnapOffsetTop snapOffsetTop} may be set to specify where
     * the component will render within the cell or record. If unset, for components embedded within a record we will default
     * to embedding at the top/left coordinate, and for components embedded within a cell, we will respect the align / valign
     * properties for the cell in question. Any  percentage sizing will be interpreted as percentage of row size. <P> Otherwise
     * it will appear to be embedded within the record, underneath the field values. <P> Embedded components become children of
     * the grid and will stay attached to a record through scrolling, sorting and other operations that cause records to shift
     * position. <P> If <code>position</code> is set to <code>"expand"</code>, embedded components may offer a resize
     * interface, eg, by setting {@link com.smartgwt.client.widgets.grid.ListGrid#getCanDragResize canDragResize}:true, and the
     * grid will react accordingly, growing or shrinking the record to match the embedded component's new extents. <P> Embedded
     * components can be explicitly removed with {@link com.smartgwt.client.widgets.grid.ListGrid#removeEmbeddedComponent
     * ListGrid.removeEmbeddedComponent}. <P> If a record is removed from the dataset or is replaced in the dataset, for
     * example, it is eliminated through filtering (removes record) or is successfully edited in a databound grid (replaces
     * record), the component is cleared but not logically removed from the grid. It is the responsibility of code that sets up
     * the embedded component to remove it if the record is removed from the dataSet.  <P> When embedding components will
     * result in variable height records, you should switch on {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getVirtualScrolling virtualScrolling}.
     * @param component component to embed
     * @param record record to attach the component to
     */
    public native void addEmbeddedComponent(Canvas component, ListGridRecord record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addEmbeddedComponent(component.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), record.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Attaches the component to the provided record. If <code>position</code> is specified as  <code>"within"</code> {@link
     * com.smartgwt.client.widgets.Canvas#getSnapTo snapTo} and {@link com.smartgwt.client.widgets.Canvas#getSnapOffsetLeft
     * snapOffsetLeft},  {@link com.smartgwt.client.widgets.Canvas#getSnapOffsetTop snapOffsetTop} may be set to specify where
     * the component will render within the cell or record. If unset, for components embedded within a record we will default
     * to embedding at the top/left coordinate, and for components embedded within a cell, we will respect the align / valign
     * properties for the cell in question. Any  percentage sizing will be interpreted as percentage of row size. <P> Otherwise
     * it will appear to be embedded within the record, underneath the field values. <P> Embedded components become children of
     * the grid and will stay attached to a record through scrolling, sorting and other operations that cause records to shift
     * position. <P> If <code>position</code> is set to <code>"expand"</code>, embedded components may offer a resize
     * interface, eg, by setting {@link com.smartgwt.client.widgets.grid.ListGrid#getCanDragResize canDragResize}:true, and the
     * grid will react accordingly, growing or shrinking the record to match the embedded component's new extents. <P> Embedded
     * components can be explicitly removed with {@link com.smartgwt.client.widgets.grid.ListGrid#removeEmbeddedComponent
     * ListGrid.removeEmbeddedComponent}. <P> If a record is removed from the dataset or is replaced in the dataset, for
     * example, it is eliminated through filtering (removes record) or is successfully edited in a databound grid (replaces
     * record), the component is cleared but not logically removed from the grid. It is the responsibility of code that sets up
     * the embedded component to remove it if the record is removed from the dataSet.  <P> When embedding components will
     * result in variable height records, you should switch on {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getVirtualScrolling virtualScrolling}.
     * @param component component to embed
     * @param record record to attach the component to
     * @param rowNum rowNum of the record to attach the component to
     * @param colNum colNum in which to embed the component
     * @param position positioning with respect to the record or cell (Defaults to "expand").
     */
    public native void addEmbeddedComponent(Canvas component, ListGridRecord record, int rowNum, int colNum, EmbeddedPosition position) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addEmbeddedComponent(component.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), record.@com.smartgwt.client.core.DataClass::getJsObj()(), rowNum, colNum, position.@com.smartgwt.client.types.EmbeddedPosition::getValue()());
    }-*/;
            
    /**
     * Programmatically cause a field to auto-fit horizontally to it's contents or title. <P> Does not establish permanent
     * auto-fitting - use {@link com.smartgwt.client.widgets.grid.ListGrid#setAutoFitWidth ListGrid.setAutoFitWidth} to do so.
     * @param fieldName 
     *
     * @return new width in pixels
     */
    public native int autoFitField(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.autoFitField(fieldName);
    }-*/;
    /**
     * Add a bodyKeyPress handler.
     * <p>
     * Handle a keyPress event on the body.   <P> Default implementation handles navigating between records with arrow keys,
     * and activating records with space and enter.
     *
     * @param handler the bodyKeyPress handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addBodyKeyPressHandler(com.smartgwt.client.widgets.grid.events.BodyKeyPressHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.BodyKeyPressEvent.getType()) == 0) setupBodyKeyPressEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.BodyKeyPressEvent.getType());
    }

    private native void setupBodyKeyPressEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({bodyKeyPress:$debox($entry(function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.grid.events.BodyKeyPressEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.bodyKeyPress = $debox($entry(function(){
                   var param = {};
                   var event = @com.smartgwt.client.widgets.grid.events.BodyKeyPressEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
            
    /**
     * Cancel the current edit without saving.
     */
    public native void cancelEditing() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.cancelEditing();
    }-*/;
    /**
     * Add a cellSaved handler.
     * <p>
     * Fires after user edits have been successfully saved to the server, when the new value doesn't match the value before
     * editing. <p> If you want immediate notification of a changes <b>before</b> changes has been saved to the server,
     * implement {@link com.smartgwt.client.widgets.grid.ListGridField#change field.change()} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#changed field.changed()} instead. <P> You can supply this method on the
     * listGrid instance or on the listGridField(s) that you want to receive cellChanged events for.  If both a field and the
     * listGrid define a cellChanged method and that field receives an edit save, only the one defined on the field is called.
     *
     * @param handler the cellSaved handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addCellSavedHandler(com.smartgwt.client.widgets.grid.events.CellSavedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellSavedEvent.getType()) == 0) setupCellSavedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellSavedEvent.getType());
    }

    private native void setupCellSavedEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({cellChanged:$entry(function(){
                        var param = {"record" : arguments[0], "newValue" : arguments[1], "oldValue" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4], "grid" : arguments[5]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellSavedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.cellChanged = $entry(function(){
                   var param = {"record" : arguments[0], "newValue" : arguments[1], "oldValue" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4], "grid" : arguments[5]};
                   var event = @com.smartgwt.client.widgets.grid.events.CellSavedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
    /**
     * Add a cellClick handler.
     * <p>
     * Called when a cell receives a click event.
     *
     * @param handler the cellClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addCellClickHandler(com.smartgwt.client.widgets.grid.events.CellClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellClickEvent.getType()) == 0) setupCellClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellClickEvent.getType());
    }

    private native void setupCellClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({cellClick:$debox($entry(function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.cellClick = $debox($entry(function(){
                   var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                   var event = @com.smartgwt.client.widgets.grid.events.CellClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a cellContextClick handler.
     * <p>
     * Called when a cell receives a contextclick event.
     *
     * @param handler the cellContextClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addCellContextClickHandler(com.smartgwt.client.widgets.grid.events.CellContextClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellContextClickEvent.getType()) == 0) setupCellContextClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellContextClickEvent.getType());
    }

    private native void setupCellContextClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({cellContextClick:$debox($entry(function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.cellContextClick = $debox($entry(function(){
                   var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                   var event = @com.smartgwt.client.widgets.grid.events.CellContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a cellDoubleClick handler.
     * <p>
     * Called when a cell receives a double click event.
     *
     * @param handler the cellDoubleClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addCellDoubleClickHandler(com.smartgwt.client.widgets.grid.events.CellDoubleClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent.getType()) == 0) setupCellDoubleClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent.getType());
    }

    private native void setupCellDoubleClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({cellDoubleClick:$debox($entry(function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.cellDoubleClick = $debox($entry(function(){
                   var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                   var event = @com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
            
    /**
     * If this listGrid can be edited, this method will return true if the cell passed in has been edited, but the edits have
     * not yet been saved to the ListGrid's data object.
     * @param rowNum index of row to check for changes
     * @param colNum index of the col to check for changes
     *
     * @return returns true if the cell has unsaved edits
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public native Boolean cellHasChanges(int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.cellHasChanges(rowNum, colNum);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
    /**
     * Add a cellHover handler.
     * <p>
     * Called when the mouse hovers over a cell if this.canHover is true.   Returning false will suppress the hover text from
     * being shown if this.showHover is true.
     *
     * @param handler the cellHover handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addCellHoverHandler(com.smartgwt.client.widgets.grid.events.CellHoverHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellHoverEvent.getType()) == 0) setupCellHoverEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellHoverEvent.getType());
    }

    private native void setupCellHoverEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({cellHover:$debox($entry(function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.cellHover = $debox($entry(function(){
                   var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                   var event = @com.smartgwt.client.widgets.grid.events.CellHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a cellMouseDown handler.
     * <p>
     * Called when a cell receives a mousedown event.
     *
     * @param handler the cellMouseDown handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addCellMouseDownHandler(com.smartgwt.client.widgets.grid.events.CellMouseDownHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellMouseDownEvent.getType()) == 0) setupCellMouseDownEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellMouseDownEvent.getType());
    }

    private native void setupCellMouseDownEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({cellMouseDown:$debox($entry(function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellMouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.cellMouseDown = $debox($entry(function(){
                   var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                   var event = @com.smartgwt.client.widgets.grid.events.CellMouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a cellMouseUp handler.
     * <p>
     * Called when a cell receives a mouseup event.
     *
     * @param handler the cellMouseUp handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addCellMouseUpHandler(com.smartgwt.client.widgets.grid.events.CellMouseUpHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellMouseUpEvent.getType()) == 0) setupCellMouseUpEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellMouseUpEvent.getType());
    }

    private native void setupCellMouseUpEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({cellMouseUp:$debox($entry(function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellMouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.cellMouseUp = $debox($entry(function(){
                   var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                   var event = @com.smartgwt.client.widgets.grid.events.CellMouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a cellOut handler.
     * <p>
     * Called when the mouse pointer leaves a cell
     *
     * @param handler the cellOut handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addCellOutHandler(com.smartgwt.client.widgets.grid.events.CellOutHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellOutEvent.getType()) == 0) setupCellOutEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellOutEvent.getType());
    }

    private native void setupCellOutEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({cellOut:$debox($entry(function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.cellOut = $debox($entry(function(){
                   var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                   var event = @com.smartgwt.client.widgets.grid.events.CellOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a cellOver handler.
     * <p>
     * Called when the mouse pointer enters a cell
     *
     * @param handler the cellOver handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addCellOverHandler(com.smartgwt.client.widgets.grid.events.CellOverHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellOverEvent.getType()) == 0) setupCellOverEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellOverEvent.getType());
    }

    private native void setupCellOverEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({cellOver:$debox($entry(function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.cellOver = $debox($entry(function(){
                   var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                   var event = @com.smartgwt.client.widgets.grid.events.CellOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
            
    /**
     * Clear any stored validation errors for some row
     * @param rowNum index of row to clear validation error for
     */
    public native void clearRowErrors(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearRowErrors(rowNum);
    }-*/;
            
    /**
     * This method clears any existing sort on this grid by calling {@link com.smartgwt.client.widgets.grid.ListGrid#setSort
     * ListGrid.setSort} with a null parameter.  The internal list of {@link com.smartgwt.client.data.SortSpecifier}s is
     * removed and the grid is  unsorted.
     */
    public native void clearSort() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearSort();
    }-*/;
            
    /**
     * Collapses a given {@link com.smartgwt.client.widgets.grid.ListGridRecord record} which has been previously expanded
     * using {@link com.smartgwt.client.widgets.grid.ListGrid#expandRecord ListGrid.expandRecord}.
     * @param record record to collapse
     */
    public native void collapseRecord(ListGridRecord record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.collapseRecord(record.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
    /**
     * Add a dataArrived handler.
     * <p>
     * Notification method fired when new data arrives from the server to be displayed in this ListGrid, (for example in
     * response to the user scrolling a new set of rows into view). Only applies to databound listGrids where the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getData data} attribute is a {@link com.smartgwt.client.data.ResultSet}. This
     * ResultSet may have been created manually and applied to the grid via a call to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setData ListGrid.setData} or may have been created and automatically assigned
     * if {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData ListGrid.fetchData} was used to populate the grid.  This
     * method is fired directly in response to {@link com.smartgwt.client.data.ResultSet#addDataArrivedHandler dataArrived()}
     * firing on the data object.
     *
     * @param handler the dataArrived handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDataArrivedHandler(com.smartgwt.client.widgets.grid.events.DataArrivedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.DataArrivedEvent.getType()) == 0) setupDataArrivedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.DataArrivedEvent.getType());
    }

    private native void setupDataArrivedEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({dataArrived:$entry(function(){
                        var param = {"startRow" : arguments[0], "endRow" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.grid.events.DataArrivedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dataArrived = $entry(function(){
                   var param = {"startRow" : arguments[0], "endRow" : arguments[1]};
                   var event = @com.smartgwt.client.widgets.grid.events.DataArrivedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
            
    /**
     * Cancel outstanding edits for the specified rows, discarding edit values, and hiding editors  if appropriate. <P> Note
     * that if this method is called on a new edit row (created via  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#startEditingNew ListGrid.startEditingNew} for example), which has not yet been
     * saved, this method will remove the row entirely. <P> Also note that this method will clear the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#markRecordRemoved removed} state of records that have been marked as removed.
     * @param rowNum Row to cancel
     * @param colNum Column to cancel. Note that this parameter is ignored in ListGrids but                        may be required in
     * subclasses of ListGrid where each cell represents                        one record in the data set (EG CubeGrid)
     */
    public native void discardEdits(int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.discardEdits(rowNum, colNum);
    }-*/;

    /**
     * Cancel outstanding edits for the specified rows, discarding edit values, and hiding editors  if appropriate. <P> Note
     * that if this method is called on a new edit row (created via  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#startEditingNew ListGrid.startEditingNew} for example), which has not yet been
     * saved, this method will remove the row entirely. <P> Also note that this method will clear the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#markRecordRemoved removed} state of records that have been marked as removed.
     * @param rowNum Row to cancel
     * @param colNum Column to cancel. Note that this parameter is ignored in ListGrids but                        may be required in
     * subclasses of ListGrid where each cell represents                        one record in the data set (EG CubeGrid)
     * @param dontHideEditor By default this method will hide the editor if                              it is currently showing for the row in
     * question. Passing in                              this parameter will leave the editor visible (and just reset          
     *                    the edit values underneath the editor).
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public native void discardEdits(int rowNum, int colNum, boolean dontHideEditor) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.discardEdits(rowNum, colNum, dontHideEditor);
    }-*/;
    /**
     * Add a drawAreaChanged handler.
     * <p>
     * Notification method that fires when the drawArea changes due to scrolling.  Receives   the previous drawArea
     * co-ordinates as parameters.  Call {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawArea ListGrid.getDrawArea} to 
     * get the new drawArea co-ordinates. <P> Note that if this grid is showing any {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen fields}, they will not be included in the
     * <code>oldStartCol</code>, <code>oldEndCol</code> range reported by this method. Frozen fields are assumed never to be
     * scrolled out of view.
     *
     * @param handler the drawAreaChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDrawAreaChangedHandler(com.smartgwt.client.widgets.grid.events.DrawAreaChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.DrawAreaChangedEvent.getType()) == 0) setupDrawAreaChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.DrawAreaChangedEvent.getType());
    }

    private native void setupDrawAreaChangedEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({drawAreaChanged:$entry(function(){
                        var param = {"oldStartRow" : arguments[0], "oldEndRow" : arguments[1], "oldStartCol" : arguments[2], "oldEndCol" : arguments[3]};
                        var event = @com.smartgwt.client.widgets.grid.events.DrawAreaChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.drawAreaChanged = $entry(function(){
                   var param = {"oldStartRow" : arguments[0], "oldEndRow" : arguments[1], "oldStartCol" : arguments[2], "oldEndCol" : arguments[3]};
                   var event = @com.smartgwt.client.widgets.grid.events.DrawAreaChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
    /**
     * Add a editComplete handler.
     * <p>
     * Callback fired when inline edits have been successfully saved. <P> No default implementation.
     *
     * @param handler the editComplete handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addEditCompleteHandler(com.smartgwt.client.widgets.grid.events.EditCompleteHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.EditCompleteEvent.getType()) == 0) setupEditCompleteEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.EditCompleteEvent.getType());
    }

    private native void setupEditCompleteEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({editComplete:$entry(function(){
                        var param = {"rowNum" : arguments[0], "colNum" : arguments[1], "newValues" : arguments[2], "oldValues" : arguments[3], "editCompletionEvent" : arguments[4], "dsResponse" : arguments[5]};
                        var event = @com.smartgwt.client.widgets.grid.events.EditCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.editComplete = $entry(function(){
                   var param = {"rowNum" : arguments[0], "colNum" : arguments[1], "newValues" : arguments[2], "oldValues" : arguments[3], "editCompletionEvent" : arguments[4], "dsResponse" : arguments[5]};
                   var event = @com.smartgwt.client.widgets.grid.events.EditCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
    /**
     * Add a editFailed handler.
     * <p>
     * Called when an attempt to save inline edits fails, due to a validation error or other server error. <P> The default
     * implementation of editFailed does nothing for normal validation errors, which are displayed before editFailed() is
     * called.  For any other errors, the default implementation will call {@link
     * com.smartgwt.client.rpc.RPCManager#handleError RPCManager.handleError}, which by default will result in a warning
     * dialog.
     *
     * @param handler the editFailed handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addEditFailedHandler(com.smartgwt.client.widgets.grid.events.EditFailedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.EditFailedEvent.getType()) == 0) setupEditFailedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.EditFailedEvent.getType());
    }

    private native void setupEditFailedEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({editFailed:$entry(function(){
                        var param = {"rowNum" : arguments[0], "colNum" : arguments[1], "newValues" : arguments[2], "oldValues" : arguments[3], "editCompletionEvent" : arguments[4], "dsResponse" : arguments[5]};
                        var event = @com.smartgwt.client.widgets.grid.events.EditFailedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.editFailed = $entry(function(){
                   var param = {"rowNum" : arguments[0], "colNum" : arguments[1], "newValues" : arguments[2], "oldValues" : arguments[3], "editCompletionEvent" : arguments[4], "dsResponse" : arguments[5]};
                   var event = @com.smartgwt.client.widgets.grid.events.EditFailedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
    /**
     * Add a editorEnter handler.
     * <p>
     * Callback fired when the user starts editing a new cell. <P> This callback is typically used to establish dynamic default
     * values via {@link com.smartgwt.client.widgets.grid.ListGrid#setEditValue ListGrid.setEditValue} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setEditValues ListGrid.setEditValues}. <P> Can also be overridden on a
     * per-field basis via {@link com.smartgwt.client.widgets.grid.ListGridField#addEditorEnterHandler field.editorEnter}.
     *
     * @param handler the editorEnter handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addEditorEnterHandler(com.smartgwt.client.widgets.grid.events.EditorEnterHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.EditorEnterEvent.getType()) == 0) setupEditorEnterEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.EditorEnterEvent.getType());
    }

    private native void setupEditorEnterEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({editorEnter:$entry(function(){
                        var param = {"record" : arguments[0], "value" : arguments[1], "rowNum" : arguments[2], "colNum" : arguments[3]};
                        var event = @com.smartgwt.client.widgets.grid.events.EditorEnterEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.editorEnter = $entry(function(){
                   var param = {"record" : arguments[0], "value" : arguments[1], "rowNum" : arguments[2], "colNum" : arguments[3]};
                   var event = @com.smartgwt.client.widgets.grid.events.EditorEnterEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
    /**
     * Add a editorExit handler.
     * <p>
     * Callback fired when the user attempts to navigate away from the current edit cell,  or complete the current edit. <P>
     * Call {@link com.smartgwt.client.widgets.grid.events.EditorExitEvent#cancel()} from within {@link EditorExitHandler#onEditorExit} from this method to cancel the default behavior (Saving / cancelling the current edit / moving to the next
     * edit cell). <P> This callback is typically used to dynamically update values or value maps for related fields (via
     * {@link com.smartgwt.client.widgets.grid.ListGrid#setEditValue ListGrid.setEditValue} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setEditorValueMap ListGrid.setEditorValueMap} respectively, or to implement
     * custom navigation (via {@link com.smartgwt.client.widgets.grid.ListGrid#startEditing startEditing(rowNum,colNum)}. <P>
     * Can be overridden at the field level as field.editorExit.
     *
     * @param handler the editorExit handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addEditorExitHandler(com.smartgwt.client.widgets.grid.events.EditorExitHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.EditorExitEvent.getType()) == 0) setupEditorExitEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.EditorExitEvent.getType());
    }

    private native void setupEditorExitEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({editorExit:$debox($entry(function(){
                        var param = {"editCompletionEvent" : arguments[0], "record" : arguments[1], "newValue" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                        var event = @com.smartgwt.client.widgets.grid.events.EditorExitEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.editorExit = $debox($entry(function(){
                   var param = {"editCompletionEvent" : arguments[0], "record" : arguments[1], "newValue" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                   var event = @com.smartgwt.client.widgets.grid.events.EditorExitEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
            
    /**
     * Complete the current edit by storing the value and hiding the inline editor. Note that if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits} is true, the value will be saved to the
     * server.
     */
    public native void endEditing() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.endEditing();
    }-*/;
            
    /**
     * Expands a given {@link com.smartgwt.client.widgets.grid.ListGridRecord record} by creating a subcomponent and inserting
     * it  in to the record's grid-row.  A number of built-in {@link com.smartgwt.client.types.ExpansionMode expansionModes} 
     * are supported by the default implementation of  {@link com.smartgwt.client.widgets.grid.ListGrid#getExpansionComponent
     * getExpansionComponent()} and you can override that method to provide your own expansion behavior. <P> Once a record has
     * been expanded, the currently visible expansion component may be retrieved via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCurrentExpansionComponent ListGrid.getCurrentExpansionComponent}.
     * @param record record to expand
     */
    public native void expandRecord(ListGridRecord record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.expandRecord(record.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
    /**
     * Add a fieldStateChanged handler.
     * <p>
     * Notification method executed when columns are resized or reordered, or fields are  shown or hidden. Has no default
     * implementation.
     *
     * @param handler the fieldStateChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFieldStateChangedHandler(com.smartgwt.client.widgets.grid.events.FieldStateChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.FieldStateChangedEvent.getType()) == 0) setupFieldStateChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.FieldStateChangedEvent.getType());
    }

    private native void setupFieldStateChangedEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({fieldStateChanged:$entry(function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.grid.events.FieldStateChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.fieldStateChanged = $entry(function(){
                   var param = {};
                   var event = @com.smartgwt.client.widgets.grid.events.FieldStateChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
            
    /**
     * If the filter editor ({@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor}) is visible
     * for this grid,  this method will perform a filter based on the current values in the editor.
     */
    public native void filterByEditor() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterByEditor();
    }-*/;
    /**
     * Add a filterEditorSubmit handler.
     * <p>
     * Optional notification  fired when the  user performs a filter by modifying the filter editor criteria. Will be fired on
     * keypress if filterOnKeypress is true otherwise when the user clicks the filter button or on enter keypress
     *
     * @param handler the filterEditorSubmit handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFilterEditorSubmitHandler(com.smartgwt.client.widgets.grid.events.FilterEditorSubmitHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.FilterEditorSubmitEvent.getType()) == 0) setupFilterEditorSubmitEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.FilterEditorSubmitEvent.getType());
    }

    private native void setupFilterEditorSubmitEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({filterEditorSubmit:$debox($entry(function(){
                        var param = {"criteria" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.grid.events.FilterEditorSubmitEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.filterEditorSubmit = $debox($entry(function(){
                   var param = {"criteria" : arguments[0]};
                   var event = @com.smartgwt.client.widgets.grid.events.FilterEditorSubmitEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
            
    /**
     * If the filter editor ({@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor}) is visible
     * for this grid,  this method will explicitly put focus into the specified field in the filter editor.
     */
    public native void focusInFilterEditor() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.focusInFilterEditor();
    }-*/;

    /**
     * If the filter editor ({@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor}) is visible
     * for this grid,  this method will explicitly put focus into the specified field in the filter editor.
     * @param fieldName Name of the field to put focus into. If unspecified focus will go                             to the first field in the
     * editor
     */
    public native void focusInFilterEditor(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.focusInFilterEditor(fieldName);
    }-*/;
            
    /**
     * Retrieves a copy of the current criteria for this component (may be null)
     *
     * @return current filter criteria
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native Criteria getCriteria() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCriteria();
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.data.Criteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
            
    /**
     * Method to calculate and return the default width of a field. This method is called to calculate the size of each field's
     * content as part of the  {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths field auto fit} behavior.
     * <P> The default implementation varies by {@link com.smartgwt.client.types.ListGridFieldType field type}.  For fields of
     * type <code>"icon"</code>, or fields which show only a  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIcons valueIcon} as a value, and for boolean fields which show a
     * checkbox value, the width will be calculated based on the icon size and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getIconFieldPadding iconFieldPadding}. For other fields the width will be
     * calculated based on the rendered width of content. Note that for  <code>"image"</code> type fields, this method will
     * rely on the {@link com.smartgwt.client.widgets.grid.ListGridField#getImageWidth imageWidth} being specified.
     * @param field Field for which the size should be determined
     *
     * @return default size required for the field's content.
     */
    public native int getDefaultFieldWidth(ListGridField field) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getDefaultFieldWidth(field.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * Get the value for some cell with default formatters applied. <P> This method is useful for cases where a developer
     * wishes to conditionally customize a cell's formatting, but needs to see what the default formatted value would be. <P>
     * For example - a developer might wish to apply a custom  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#formatCellValue formatter} to some <code>link</code> type field, and be
     * able to return the default  active link HTML in some cases. In this case a formatter could check for the conditions in
     * which custom formatting should be applied and run appropriate custom logic to generate a value for display - otherwise
     * return the result of this method to leave the standard formatted-value intact.
     * @param record the cell's record object
     * @param rowNum rowNum for the cell
     * @param colNum colNum for the cell
     *
     * @return Cell value with default formatters applied
     * @see com.smartgwt.client.widgets.grid.ListGridField#formatCellValue
     */
    public native String getDefaultFormattedValue(Record record, int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getDefaultFormattedValue(record.@com.smartgwt.client.core.DataClass::getJsObj()(), rowNum, colNum);
    }-*/;
            
    /**
     * Return "title" HTML to display as a drag tracker when the user drags some record.<br> Default implementation will
     * display the cell value for the title field (see  {@link com.smartgwt.client.widgets.grid.ListGrid#getTitleField
     * ListGrid.getTitleField}) for the record(s) being dragged (including any icons / custom formatting / styling, etc). <p>
     * Note: Only called if {@link com.smartgwt.client.widgets.grid.ListGrid#getDragTrackerMode dragTrackerMode} is set to
     * <code>"title"</code>.
     * @param record First selected record being dragged
     * @param rowNum row index of first record being dragged
     *
     * @return Title for the row. Default implementation looks at the value of the                  title-field cell for the row.
     */
    public native String getDragTrackerTitle(ListGridRecord record, int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getDragTrackerTitle(record.@com.smartgwt.client.core.DataClass::getJsObj()(), rowNum);
    }-*/;
            
    /**
     * Get the drawn height of a row.
     * @param rowNum 
     *
     * @return height
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public native int getDrawnRowHeight(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getDrawnRowHeight(rowNum);
    }-*/;
            
    /**
     * Returns the column number of the most recent mouse event.
     *
     * @return column number, or -2 if beyond last drawn column
     */
    public native int getEventColumn() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getEventColumn();
    }-*/;

    /**
     * Returns the column number of the most recent mouse event.
     * @param x optional x-coordinate to obtain column number for, in lieu of the x                        coordinate of the last mouse
     * event
     *
     * @return column number, or -2 if beyond last drawn column
     */
    public native int getEventColumn(int x) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getEventColumn(x);
    }-*/;
            
    /**
     * Returns the row number of the most recent mouse event.
     *
     * @return row number, or -2 if beyond last drawn row
     */
    public native int getEventRow() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getEventRow();
    }-*/;

    /**
     * Returns the row number of the most recent mouse event.
     * @param y optional y-coordinate to obtain row number, in lieu of the y                        coordinate of the last mouse event
     *
     * @return row number, or -2 if beyond last drawn row
     */
    public native int getEventRow(int y) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getEventRow(y);
    }-*/;
            
    /**
     * Returns a snapshot of the current presentation of this listGrid's fields as  a String object. <P> This object can later
     * be passed to {@link com.smartgwt.client.widgets.grid.ListGrid#setFieldState ListGrid.setFieldState} to reset this grid's
     * fields to the current state. <P> Note that the information stored includes the current width and visibility of each of
     * this  grid's fields, as well as any {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAddFormulaFields formula} or
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAddSummaryFields summary fields} added by the user.
     *
     * @return current state of this grid's fields.
     * @see com.smartgwt.client.widgets.grid.ListGrid#setFieldState
     */
    public native String getFieldState() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getFieldState();
    }-*/;
            
    /**
     * This method returns the data to be displayed in the {@link com.smartgwt.client.widgets.grid.ListGrid#getSummaryRow
     * summaryRow} when {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} is true. <P> By
     * default this will call {@link com.smartgwt.client.widgets.grid.ListGrid#getGridSummary ListGrid.getGridSummary} for each
     * field and generate an array of records containing the resulting values. <P> This method may be overridden for custom
     * grid-summary display, and may return multiple records if more than one summary row is desired.
     */
    public native void getGridSummaryData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getGridSummaryData();
    }-*/;
            
    /**
     * Return the pointer to a particular record by record number. Synonym for {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCellRecord ListGrid.getCellRecord}.
     * @param recordNum row index of record to return.
     *
     * @return Record object for the row.
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCellRecord
     * @see com.smartgwt.client.widgets.grid.ListGrid#getEditedRecord
     */
    public native ListGridRecord getRecord(int recordNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getRecord(recordNum);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.grid.ListGridRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;
            
    /**
     * Get the index of the provided record. <P> This is essentially the same as calling listGrid.data.indexOf(record), except
     * that  the currently visible range of records is checked first.  This is important for responsiveness in functions that
     * respond to user actions when the user is working near the end of a very large dataset (eg 500k records).
     * @param record the record whose index is to be retrieved
     *
     * @return indexindex of the record, or -1 if not found
     */
    public native int getRecordIndex(ListGridRecord record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getRecordIndex(record.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * Return the first selected record in this component.<br><br> This method is appropriate if <code>{@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSelectionType selectionType}</code> is <code>"single"</code>, or if you
     * only care about the first selected record in a multiple-record selection. To access all selected records, use
     * <code>{@link com.smartgwt.client.widgets.grid.ListGrid#getSelection ListGrid.getSelection}</code> instead.
     *
     * @return first selected record, or null if nothing selected
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_dataoperations_remove" target="examples">Databound remove Example</a>
     */
    public native ListGridRecord getSelectedRecord() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedRecord();
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.grid.ListGridRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;
            
    /**
     * Returns a snapshot of the current selection within this listGrid as  a String object.<br> This object can be passed to
     * {@link com.smartgwt.client.widgets.grid.ListGrid#setSelectedState ListGrid.setSelectedState} to reset this grid's
     * selection the current state (assuming the same data is present in the grid).<br>
     *
     * @return current state of this grid's selection
     * @see com.smartgwt.client.widgets.grid.ListGrid#setSelectedState
     */
    public native String getSelectedState() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getSelectedState();
    }-*/;
            
    /**
     * Returns the number of fields involved in this grid's current sort configuration.
     *
     * @return the number of fields this grid is currently sorted on.
     */
    public native int getSortFieldCount() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getSortFieldCount();
    }-*/;
            
    /**
     * When multiple fields are sorted, this method returns the HTML for the sort-numeral that  appears after the sort-arrows
     * in the header-buttons of sorted fields.  If you don't want sort-numerals in the header-buttons, you can override this
     * method to return null or an empty string, or set {@link com.smartgwt.client.widgets.grid.ListGrid#getShowSortNumerals
     * showSortNumerals} to false. <P> Note that the sortIndex passed in is zero based. The default implementation of this
     * method returns an HTML element with the {@link com.smartgwt.client.widgets.grid.ListGrid#getSortNumeralStyle
     * sortNumeralStyle} applied to it, containing the specified sortIndex incremented by 1 (therefore showing the more
     * user-friendly 1-based  numbering system).
     * @param fieldName The name of a sort-field to get the   {@link com.smartgwt.client.widgets.grid.ListGrid#getSortNumeralStyle sortNumeral}
     * HTML for.
     * @param sortIndex The sort index for the field.
     *
     * @return The HTML for this field's sortNumeral
     */
    public native String getSortNumeralHTML(String fieldName, int sortIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getSortNumeralHTML(fieldName, sortIndex);
    }-*/;
            
    /**
     * Returns a snapshot of the current sort state within this listGrid as  a String object.<br> This object can be passed to
     * {@link com.smartgwt.client.widgets.grid.ListGrid#setSortState ListGrid.setSortState} to reset this grid's sort to the
     * current state (assuming the same fields are present in the grid).<br>
     *
     * @return current sort state for the grid.
     * @see com.smartgwt.client.widgets.grid.ListGrid#setSortState
     */
    public native String getSortState() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getSortState();
    }-*/;
            
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} for this
     * grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields this.canFreezeFields} is true, this string
     * will be shown as the title for the menu item to toggle whether a field is frozen or unfrozen. <P> Default implementation
     * evaluates and returns {@link com.smartgwt.client.widgets.grid.ListGrid#getFreezeFieldText freezeFieldText} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getUnfreezeFieldText unfreezeFieldText} depending on whether the field is
     * currently frozen.
     * @param field field to get the menu item title for
     *
     * @return Title to show in the menu item
     */
    public native String getToggleFreezeText(ListGridField field) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getToggleFreezeText(field.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * Returns a snapshot of the current view state of this ListGrid.<br> This includes the field state, sort state and
     * selected state of the grid, returned as a String object.<br> This object can be passed to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setViewState ListGrid.setViewState} to reset this grid's vew state to the
     * current state (assuming the same data / fields are present in the grid).<br>
     *
     * @return current view state for the grid.
     * @see com.smartgwt.client.widgets.grid.ListGrid#setViewState
     */
    public native String getViewState() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getViewState();
    }-*/;
    /**
     * Add a groupBy handler.
     * <p>
     * Callback fired when the listGrid is grouped or ungrouped.  <var class="SmartGwt">This event may be cancelled</var>
     *
     * @param handler the groupBy handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addGroupByHandler(com.smartgwt.client.widgets.grid.events.GroupByHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.GroupByEvent.getType()) == 0) setupGroupByEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.GroupByEvent.getType());
    }

    private native void setupGroupByEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({handleGroupBy:$debox($entry(function(){
                        var param = {"fields" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.grid.events.GroupByEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.handleGroupBy = $debox($entry(function(){
                   var param = {"fields" : arguments[0]};
                   var event = @com.smartgwt.client.widgets.grid.events.GroupByEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
            
    /**
     * Whether the grid as a whole has any unsaved edits, in any row. Note that this method will return true if any rows are
     * {@link com.smartgwt.client.widgets.grid.ListGrid#markRecordRemoved marked as removed} in addition to any rows that have
     * pending unsaved edits.
     *
     * @return returns true of any unsaved edits are present
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public native Boolean hasChanges() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.hasChanges();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Does this grid currently have errors associated with editValues for any row in the grid.
     *
     * @return true if there are unresolved errors, false otherwise
     * @see com.smartgwt.client.widgets.grid.ListGrid#rowHasErrors
     * @see com.smartgwt.client.widgets.grid.ListGrid#cellHasErrors
     * @see com.smartgwt.client.docs.GridValidation GridValidation overview and related methods
     */
    public native Boolean hasErrors() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.hasErrors();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
    /**
     * Add a headerDoubleClick handler.
     * <p>
     * Handle a double click in the list header. <P> By default, calls {@link
     * com.smartgwt.client.widgets.grid.ListGrid#autoFitField ListGrid.autoFitField} if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanAutoFitFields canAutoFitFields} is true and  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitHeaderEvent autoFitHeaderEvent} is <code>"doubleClick"</code>.
     *
     * @param handler the headerDoubleClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addHeaderDoubleClickHandler(com.smartgwt.client.widgets.grid.events.HeaderDoubleClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.HeaderDoubleClickEvent.getType()) == 0) setupHeaderDoubleClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.HeaderDoubleClickEvent.getType());
    }

    private native void setupHeaderDoubleClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({headerDoubleClick:$entry(function(){
                        var param = {"fieldNum" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.grid.events.HeaderDoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.headerDoubleClick = $entry(function(){
                   var param = {"fieldNum" : arguments[0]};
                   var event = @com.smartgwt.client.widgets.grid.events.HeaderDoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
            
    /**
     * Invalidates the currently visible set of {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents
     * recordComponents} and gets fresh ones for the visible rows in the grid according to the  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordComponentPoolingMode recordComponentPoolingMode} <P> See also {@link
     * com.smartgwt.client.widgets.grid.ListGrid#refreshRecordComponent ListGrid.refreshRecordComponent} which allows you to
     * refresh a specific recordComponent
     */
    public native void invalidateRecordComponents() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.invalidateRecordComponents();
    }-*/;
            
    /**
     * Identifies whether the passed-in field is the specially generated {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCheckboxField checkboxField} used when {@link
     * com.smartgwt.client.types.SelectionAppearance} is "checkbox".  Use this method in your custom event handlers to avoid
     * inappropriately performing actions when the checkboxField is clicked on.
     * @param field field to test
     *
     * @return whether the provided field is the checkbox field
     */
    public native Boolean isCheckboxField(ListGridField field) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.isCheckboxField(field.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Identifies whether the passed-in field is the specially generated {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getExpansionField expansionField} used when {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is true.  Use this method in your custom
     * event handlers to avoid inappropriately performing actions when the expansionField is clicked on.
     * @param field field to test
     *
     * @return whether the provided field is the expansion field
     */
    public native Boolean isExpansionField(ListGridField field) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.isExpansionField(field.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Returns true if the record is partially selected.
     * @param record record to check
     *
     * @return true if record is partially selected; false otherwise
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native Boolean isPartiallySelected(ListGridRecord record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.isPartiallySelected(record.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Identifies whether the passed-in field is the specially generated {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRowNumberField rowNumberField} used when {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowRowNumbers showRowNumbers} is true.  Use this method in your custom
     * event handlers to avoid inappropriately performing actions when the rowNumberField is clicked on.
     * @param field field to test
     *
     * @return whether the provided field is the rowNumberField
     */
    public native Boolean isRowNumberField(ListGridField field) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.isRowNumberField(field.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Returns true if the record is selected.
     * @param record record to check
     *
     * @return true if record is selected; false otherwise
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native Boolean isSelected(ListGridRecord record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.isSelected(record.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Returns true if the passed fieldName is in the current sort-specification.
     * @param fieldName The name of a field, visible, hidden or existing only in the dataSource
     *
     * @return True if the passed field is sorted, false otherwise
     */
    public native Boolean isSortField(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.isSortField(fieldName);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Marks the widget as "dirty" so that it will be added to a queue for redraw. Redraw of dirty components is handled by a
     * looping timer and will after a very short delay (typically less than 100ms). In most cases it is recommended that
     * developers use <code>markForRedraw()</code> instead of calling {@link com.smartgwt.client.widgets.Canvas#redraw
     * Canvas.redraw} directly. Since this method queues the redraw, multiple calls to markForRedraw() within a single thread
     * of execution will only lead to a single DOM manipulation which greatly improves application performance.
     */
    public native void markForRedraw() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.markForRedraw();
    }-*/;

    /**
     * Marks the widget as "dirty" so that it will be added to a queue for redraw. Redraw of dirty components is handled by a
     * looping timer and will after a very short delay (typically less than 100ms). In most cases it is recommended that
     * developers use <code>markForRedraw()</code> instead of calling {@link com.smartgwt.client.widgets.Canvas#redraw
     * Canvas.redraw} directly. Since this method queues the redraw, multiple calls to markForRedraw() within a single thread
     * of execution will only lead to a single DOM manipulation which greatly improves application performance.
     * @param reason reason for performing the redraw
     * @see com.smartgwt.client.docs.Drawing Drawing overview and related methods
     */
    public native void markForRedraw(String reason) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.markForRedraw(reason);
    }-*/;
            
    /**
     * Marks a record deleted such that a later call to {@link com.smartgwt.client.widgets.grid.ListGrid#saveEdits
     * ListGrid.saveEdits} or {@link com.smartgwt.client.widgets.grid.ListGrid#saveAllEdits ListGrid.saveAllEdits} will cause a
     * "remove" {@link com.smartgwt.client.data.DSRequest} to be submitted. <P> A removed record is disabled and non-editable,
     * and uses {@link com.smartgwt.client.widgets.grid.ListGrid#getRemovedCSSText removedCSSText} for its CSS style, which by
     * default will show strikethrough text. <P> Contrast this method with removeSelectedData(), which immediately submits a
     * DSRequest to remove the selected records from the dataset. <P> Records that have been marked for removal using this
     * method may be 'unmarked' via a call to {@link com.smartgwt.client.widgets.grid.ListGrid#unmarkRecordRemoved
     * ListGrid.unmarkRecordRemoved}, or by discarding edit values ({@link
     * com.smartgwt.client.widgets.grid.ListGrid#discardEdits ListGrid.discardEdits}).
     * @param rowNum row number for the record to mark
     */
    public native void markRecordRemoved(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.markRecordRemoved(rowNum);
    }-*/;
            
    /**
     * Marks the currently selected records as removed, as though {@link
     * com.smartgwt.client.widgets.grid.ListGrid#markRecordRemoved ListGrid.markRecordRemoved} had been called.
     */
    public native void markSelectionRemoved() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.markSelectionRemoved();
    }-*/;
            
    /**
     * Refresh the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary grid summary}. Note unlike {@link
     * com.smartgwt.client.widgets.grid.ListGrid#recalculateSummaries ListGrid.recalculateSummaries}, this method will not
     * force a refresh of field-level summaries (see {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getRecordSummaryFunction recordSummaryFunction}) or group level summaries
     * (see {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary}).
     */
    public native void recalculateGridSummary() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.recalculateGridSummary();
    }-*/;
    /**
     * Add a recordClick handler.
     * <p>
     * Executed when the listGrid receives a 'click' event on an enabled, non-separator record. The default implementation does
     * nothing -- override to perform some action when any record or field is clicked.<br> A record event handler can be
     * specified either as a function to execute, or as a string of script to evaluate. If the handler is defined as a string
     * of script, all the parameters below will be available as variables for use in the script.<br> To do something specific
     * if a particular field is clicked, add a recordClick method or string of script to that field (same parameters) when
     * you're setting up the list.<br> <b>Notes:</b><ul>  <li>This will not be called if the click is below the last item of
     * the list.</li>  <li>This method is called from the default implementation of  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#rowClick ListGrid.rowClick}, so if that method is overridden  this method may
     * not be fired.</li></ul>
     *
     * @param handler the recordClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRecordClickHandler(com.smartgwt.client.widgets.grid.events.RecordClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RecordClickEvent.getType()) == 0) setupRecordClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RecordClickEvent.getType());
    }

    private native void setupRecordClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({recordClick:$entry(function(){
                        var param = {"viewer" : arguments[0], "record" : arguments[1], "recordNum" : arguments[2], "field" : arguments[3], "fieldNum" : arguments[4], "value" : arguments[5], "rawValue" : arguments[6]};
                        var event = @com.smartgwt.client.widgets.grid.events.RecordClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.recordClick = $entry(function(){
                   var param = {"viewer" : arguments[0], "record" : arguments[1], "recordNum" : arguments[2], "field" : arguments[3], "fieldNum" : arguments[4], "value" : arguments[5], "rawValue" : arguments[6]};
                   var event = @com.smartgwt.client.widgets.grid.events.RecordClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
    /**
     * Add a recordDoubleClick handler.
     * <p>
     * Executed when the listGrid receives a 'doubleClick' event on an enabled, non-separator record. The default
     * implementation does nothing -- override to perform some action when any record or field is double clicked.<br> A record
     * event handler can be specified either as a function to execute, or as a string of script to evaluate. If the handler is
     * defined as a string of script, all the parameters below will be available as variables for use in the script.<br> To do
     * something specific if a particular field is double clicked, add a recordDoubleClick method or string of script to that
     * field (same parameters) when you're setting up the list.<br> <b>Notes:</b><ul> <li>This will not be called if the click
     * is below the last item of the list.</li> <li>This method is called from the default implementation of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#rowDoubleClick ListGrid.rowDoubleClick}, so if that method is overridden this
     * method may not be fired.</li></ul>
     *
     * @param handler the recordDoubleClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRecordDoubleClickHandler(com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent.getType()) == 0) setupRecordDoubleClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent.getType());
    }

    private native void setupRecordDoubleClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({recordDoubleClick:$debox($entry(function(){
                        var param = {"viewer" : arguments[0], "record" : arguments[1], "recordNum" : arguments[2], "field" : arguments[3], "fieldNum" : arguments[4], "value" : arguments[5], "rawValue" : arguments[6]};
                        var event = @com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.recordDoubleClick = $debox($entry(function(){
                   var param = {"viewer" : arguments[0], "record" : arguments[1], "recordNum" : arguments[2], "field" : arguments[3], "fieldNum" : arguments[4], "value" : arguments[5], "rawValue" : arguments[6]};
                   var event = @com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
            
    /**
     * Returns true if the specified record is marked as removed via a call to  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#markRecordRemoved ListGrid.markRecordRemoved}
     * @param rowNum index of row to verify
     *
     * @return true if the specified record has been marked for removal
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public native Boolean recordMarkedAsRemoved(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.recordMarkedAsRemoved(rowNum);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Refresh an individual cell without redrawing the grid. <P> The cell's value, CSS class, and CSS text will be refreshed,
     * to the current values returned by getCellValue(), getCellStyle() and getCellCSSText() respectively.
     * @param rowNum row number of cell to refresh
     * @param colNum column number of cell to refresh
     */
    public native void refreshCell(int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.refreshCell(rowNum, colNum);
    }-*/;
            
    /**
     * Refresh the styling of an individual cell without redrawing the grid. <P> The cell's CSS class and CSS text will be
     * refreshed, to the current values returned by getCellStyle() and getCellCSSText() respectively. <P> The cell's contents
     * (as returned by getCellValue()) will <b>not</b> be refreshed.  To refresh both styling and contents, call refreshCell()
     * instead.
     * @param rowNum row number of cell to refresh
     * @param colNum column number of cell to refresh
     */
    public native void refreshCellStyle(int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.refreshCellStyle(rowNum, colNum);
    }-*/;
            
    /**
     * Re-evaluates {@link com.smartgwt.client.widgets.grid.ListGridField#showIf ListGridField.showIf} for each field,
     * dynamically showing and  hiding the appropriate set of fields
     */
    public native void refreshFields() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.refreshFields();
    }-*/;
            
    /**
     * Discards any currently visible set of {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents
     * recordComponent} and gets a fresh one for the specified record (or cell) according to the  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordComponentPoolingMode recordComponentPoolingMode}. <P> See also {@link
     * com.smartgwt.client.widgets.grid.ListGrid#invalidateRecordComponents ListGrid.invalidateRecordComponents} which allows
     * you to refresh all record components that are currently visible in the grid.
     * @param rowNum Row to refresh
     */
    public native void refreshRecordComponent(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.refreshRecordComponent(rowNum);
    }-*/;

    /**
     * Discards any currently visible set of {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents
     * recordComponent} and gets a fresh one for the specified record (or cell) according to the  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordComponentPoolingMode recordComponentPoolingMode}. <P> See also {@link
     * com.smartgwt.client.widgets.grid.ListGrid#invalidateRecordComponents ListGrid.invalidateRecordComponents} which allows
     * you to refresh all record components that are currently visible in the grid.
     * @param rowNum Row to refresh
     * @param colNum Column to refresh. This parameter should be passed       if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponentsByCell showRecordComponentsByCell} is true.
     */
    public native void refreshRecordComponent(int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.refreshRecordComponent(rowNum, colNum);
    }-*/;
            
    /**
     * Refresh an entire row of cells without redrawing the grid. <P> The cells' values, CSS classes, and CSS text will be
     * refreshed, to the current values returned by getCellValue(), getCellStyle() and getCellCSSText() respectively.
     * @param rowNum row number of cell to refresh
     */
    public native void refreshRow(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.refreshRow(rowNum);
    }-*/;
            
    /**
     * Handler fired when the user clicks the "remove" icon if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is true. Default behavior will remove
     * the record from the data set, or if we're {@link com.smartgwt.client.widgets.grid.ListGrid#getDeferRemoval deferring
     * removal} mark record as removed [or for records already  marked as removed, clear this removed marker]. <P> If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getWarnOnRemoval warnOnRemoval} is set, this method will also show a warning
     * dialog to users allowing them to cancel the removal. <P>
     * @param rowNum Row on which the icon was clicked
     */
    public native void removeRecordClick(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeRecordClick(rowNum);
    }-*/;
            
    /**
     * Reorder a particular field
     * @param fieldNum Number of the field to reorder
     * @param moveToPosition New position for that field
     */
    public native void reorderField(int fieldNum, int moveToPosition) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reorderField(fieldNum, moveToPosition);
    }-*/;
            
    /**
     * Reorder a set of adjacent fields, from start to end exclusive at the end, by distance moveDelta.<br><br> NOTE: start and
     * end coordinates are in terms of the currently visible fields, not the full set of fields.
     * @param start Start of the range of fields to move, inclusive
     * @param end End of the range of fields to move, non-inclusive
     * @param moveDelta Distance to move by
     */
    public native void reorderFields(int start, int end, int moveDelta) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reorderFields(start, end, moveDelta);
    }-*/;
            
    /**
     * Resize a particular field to a new width. Note that this method  will also set {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidth autoFitWidth} to false if it was previously true.
     * @param fieldNum Number of the field to resize
     * @param newWidth New width of the field
     */
    public native void resizeField(int fieldNum, int newWidth) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.resizeField(fieldNum, newWidth);
    }-*/;
    /**
     * Add a rowContextClick handler.
     * <p>
     * Called when a row receives a contextclick event.
     *
     * @param handler the rowContextClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRowContextClickHandler(com.smartgwt.client.widgets.grid.events.RowContextClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RowContextClickEvent.getType()) == 0) setupRowContextClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RowContextClickEvent.getType());
    }

    private native void setupRowContextClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({rowContextClick:$debox($entry(function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.rowContextClick = $debox($entry(function(){
                   var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                   var event = @com.smartgwt.client.widgets.grid.events.RowContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a rowEditorEnter handler.
     * <p>
     * Callback fired when the user starts editing a new row.
     *
     * @param handler the rowEditorEnter handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRowEditorEnterHandler(com.smartgwt.client.widgets.grid.events.RowEditorEnterHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RowEditorEnterEvent.getType()) == 0) setupRowEditorEnterEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RowEditorEnterEvent.getType());
    }

    private native void setupRowEditorEnterEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({rowEditorEnter:$entry(function(){
                        var param = {"record" : arguments[0], "editValues" : arguments[1], "rowNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowEditorEnterEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.rowEditorEnter = $entry(function(){
                   var param = {"record" : arguments[0], "editValues" : arguments[1], "rowNum" : arguments[2]};
                   var event = @com.smartgwt.client.widgets.grid.events.RowEditorEnterEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
    /**
     * Add a rowEditorExit handler.
     * <p>
     * Callback fired when the user attempts to navigate away from the current edit row,  or complete the current edit. <P>
     * Call {@link com.smartgwt.client.widgets.grid.events.RowEditorExitEvent#cancel()} from within {@link RowEditorExitHandler#onRowEditorExit} from this method to cancel the default behavior (Saving / cancelling the current edit / moving to the next
     * edit cell).
     *
     * @param handler the rowEditorExit handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRowEditorExitHandler(com.smartgwt.client.widgets.grid.events.RowEditorExitHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RowEditorExitEvent.getType()) == 0) setupRowEditorExitEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RowEditorExitEvent.getType());
    }

    private native void setupRowEditorExitEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({rowEditorExit:$debox($entry(function(){
                        var param = {"editCompletionEvent" : arguments[0], "record" : arguments[1], "newValues" : arguments[2], "rowNum" : arguments[3]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowEditorExitEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.rowEditorExit = $debox($entry(function(){
                   var param = {"editCompletionEvent" : arguments[0], "record" : arguments[1], "newValues" : arguments[2], "rowNum" : arguments[3]};
                   var event = @com.smartgwt.client.widgets.grid.events.RowEditorExitEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
            
    /**
     * If this listGrid can be edited, this method will return true if the row passed in has been edited, but the edits have
     * not yet been saved to the ListGrid's data object. <P> Note this method will not return true if a record has been marked
     * as {@link com.smartgwt.client.widgets.grid.ListGrid#markRecordRemoved removed}, but has no other changes. Developers can
     * use {@link com.smartgwt.client.widgets.grid.ListGrid#recordMarkedAsRemoved ListGrid.recordMarkedAsRemoved} to check for
     * this case.
     * @param rowNum index of row to check for changes
     *
     * @return true if the row has changes.
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public native Boolean rowHasChanges(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.rowHasChanges(rowNum);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Does the specified row have unresolved errors?
     * @param rowNum rowNum to check for errors
     *
     * @return true if there are unresolved errors, false otherwise
     * @see com.smartgwt.client.widgets.grid.ListGrid#hasErrors
     * @see com.smartgwt.client.widgets.grid.ListGrid#cellHasErrors
     * @see com.smartgwt.client.docs.GridValidation GridValidation overview and related methods
     */
    public native Boolean rowHasErrors(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.rowHasErrors(rowNum);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
    /**
     * Add a rowHover handler.
     * <p>
     * Called when the mouse hovers over a row if this.canHover is true.   Returning false will suppress the hover text from
     * being shown if this.showHover is true.
     *
     * @param handler the rowHover handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRowHoverHandler(com.smartgwt.client.widgets.grid.events.RowHoverHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RowHoverEvent.getType()) == 0) setupRowHoverEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RowHoverEvent.getType());
    }

    private native void setupRowHoverEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({rowHover:$debox($entry(function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.rowHover = $debox($entry(function(){
                   var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                   var event = @com.smartgwt.client.widgets.grid.events.RowHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a rowMouseDown handler.
     * <p>
     * Called when a row receives a mousedown event.
     *
     * @param handler the rowMouseDown handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRowMouseDownHandler(com.smartgwt.client.widgets.grid.events.RowMouseDownHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RowMouseDownEvent.getType()) == 0) setupRowMouseDownEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RowMouseDownEvent.getType());
    }

    private native void setupRowMouseDownEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({rowMouseDown:$debox($entry(function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowMouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.rowMouseDown = $debox($entry(function(){
                   var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                   var event = @com.smartgwt.client.widgets.grid.events.RowMouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a rowMouseUp handler.
     * <p>
     * Called when a row receives a mouseup event.
     *
     * @param handler the rowMouseUp handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRowMouseUpHandler(com.smartgwt.client.widgets.grid.events.RowMouseUpHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RowMouseUpEvent.getType()) == 0) setupRowMouseUpEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RowMouseUpEvent.getType());
    }

    private native void setupRowMouseUpEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({rowMouseUp:$debox($entry(function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowMouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.rowMouseUp = $debox($entry(function(){
                   var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                   var event = @com.smartgwt.client.widgets.grid.events.RowMouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a rowOut handler.
     * <p>
     * Called when the mouse pointer leaves a row
     *
     * @param handler the rowOut handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRowOutHandler(com.smartgwt.client.widgets.grid.events.RowOutHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RowOutEvent.getType()) == 0) setupRowOutEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RowOutEvent.getType());
    }

    private native void setupRowOutEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({rowOut:$debox($entry(function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.rowOut = $debox($entry(function(){
                   var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                   var event = @com.smartgwt.client.widgets.grid.events.RowOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a rowOver handler.
     * <p>
     * Called when the mouse pointer enters a row
     *
     * @param handler the rowOver handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRowOverHandler(com.smartgwt.client.widgets.grid.events.RowOverHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RowOverEvent.getType()) == 0) setupRowOverEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RowOverEvent.getType());
    }

    private native void setupRowOverEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({rowOver:$debox($entry(function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.rowOver = $debox($entry(function(){
                   var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                   var event = @com.smartgwt.client.widgets.grid.events.RowOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a selectionChanged handler.
     * <p>
     * Called when (row-based) selection changes within this grid. Note this method fires for each record for which selection
     * is modified - so when a user clicks inside a grid this method will typically fire twice (once for the old record being
     * deselected, and once for the new record being selected). <P> NOTE: For updating other components based on selections or
     * triggering selection-oriented events within an application, see the {@link
     * com.smartgwt.client.widgets.DataBoundComponent#selectionUpdated selectionUpdated} event which is likely more suitable.
     *
     * @param handler the selectionChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addSelectionChangedHandler(com.smartgwt.client.widgets.grid.events.SelectionChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.SelectionEvent.getType()) == 0) setupSelectionChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.SelectionEvent.getType());
    }

    private native void setupSelectionChangedEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({selectionChanged:$entry(function(){
                        var param = {"record" : arguments[0], "state" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.grid.events.SelectionEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.selectionChanged = $entry(function(){
                   var param = {"record" : arguments[0], "state" : arguments[1]};
                   var event = @com.smartgwt.client.widgets.grid.events.SelectionEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
    /**
     * Add a selectionUpdated handler.
     * <p>
     * Called when selection changes. Note this method fires exactly once for any given change unlike the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#addSelectionChangedHandler selectionChanged} event. <P> This event is fired
     * once after selection/deselection has completed. The result is one event per mouse-down event. For a drag selection there
     * will be two events fired: one when the first record is selected and once when the range is completed. <P> This event is
     * also fired when selection is updated by a direct call to one of the DataBoundComponent select/deselect methods. Calls on
     * the Selection object <b>do not</b> trigger this event.
     *
     * @param handler the selectionUpdated handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addSelectionUpdatedHandler(com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent.getType()) == 0) setupSelectionUpdatedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent.getType());
    }

    private native void setupSelectionUpdatedEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({selectionUpdated:$entry(function(){
                        var param = {"record" : arguments[0], "recordList" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.selectionUpdated = $entry(function(){
                   var param = {"record" : arguments[0], "recordList" : arguments[1]};
                   var event = @com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
            
    /**
     * Setter for  autoFitWidth. Enables or disables dynamic autoFitWidth behavior on the specified field. Note if the field is
     * currently autoFitWidth:true, and this method is disabling autoFit, the field will not be resized by default - if you
     * wish to resize to an explicit width, use {@link com.smartgwt.client.widgets.grid.ListGrid#resizeField
     * ListGrid.resizeField}.
     * @param fieldName field to auto-fit
     * @param autoFit Should autoFitWidth be enabled or disabled?
     */
    public native void setAutoFitWidth(String fieldName, boolean autoFit) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setAutoFitWidth(fieldName, autoFit);
    }-*/;
            
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents showRecordComponents} is true, by default
     * any created record components are destroyed once they are no longer in use (for example in the ListGrid as a whole is
     * destroyed). This method may be used to suppress this behavior for some component. Typical usage might call this method
     * as part of {@link com.smartgwt.client.widgets.grid.ListGrid#createRecordComponent ListGrid.createRecordComponent} to
     * suppress this behavior.
     * @param component component in question.
     * @param dontAutoDestroy If true, the component will not be destroyed automatically when   the grid is destroyed
     */
    public native void setDontAutoDestroyComponent(Canvas component, boolean dontAutoDestroy) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setDontAutoDestroyComponent(component.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), dontAutoDestroy);
    }-*/;
            
    /**
     * Sets some presentation properties (visibility, width, userFormula and userSummary) of the  listGrid fields based on the
     * String object passed in.<br> Used to restore previous state retrieved from the grid by a call to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFieldState ListGrid.getFieldState}.
     * @param fieldState state to apply to the listGrid's fields.
     */
    public native void setFieldState(String fieldState) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFieldState(fieldState);
    }-*/;
            
    /**
     * Update the title of a {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpan} dynamically.
     * @param name name of the headerSpan, as specified via {@link com.smartgwt.client.widgets.grid.HeaderSpan#getName name}.
     * @param newTitle new title for the headerSpan
     */
    public native void setHeaderSpanTitle(String name, String newTitle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setHeaderSpanTitle(name, newTitle);
    }-*/;
            
    /**
     * Reset this grid's selection to match the String object passed in.<br> Used to restore previous state retrieved from the
     * grid by a call to  {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectedState ListGrid.getSelectedState}.
     * @param selectedState Object describing the desired selection state of                                              the grid
     */
    public native void setSelectedState(String selectedState) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setSelectedState(selectedState);
    }-*/;
            
    /**
     * Reset this grid's sort state (sort field and direction or list of  {@link com.smartgwt.client.data.SortSpecifier}s) to
     * match the  String object passed in.<br> Used to restore previous state retrieved from the grid by a call to  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSortState ListGrid.getSortState}.
     * @param sortState Object describing the desired sort state for the grid.
     */
    public native void setSortState(String sortState) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setSortState(sortState);
    }-*/;
            
    /**
     * Reset this grid's view state to match the String object passed in.<br> Used to restore previous state retrieved from the
     * grid by a call to  {@link com.smartgwt.client.widgets.grid.ListGrid#getViewState ListGrid.getViewState}.
     * @param viewState Object describing the desired view state for the grid
     */
    public native void setViewState(String viewState) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setViewState(viewState);
    }-*/;
            
    /**
     * Start inline editing at the provided coordinates. <p> Invoked when a cell is editable and the <code>editEvent</code>
     * occurs on that cell.  Can also be invoked explicitly. <P> If this method is called while editing is already in progress,
     * the value from the current editCell will either be stored locally as a temporary edit value, or saved via 'saveEdits()'
     * depending on <code>this.saveByCell</code>, and the position of the new edit cell.<br> Will update the UI to show the
     * editor for the new cell, and put focus in it unless  explicitly suppressed by the optional <code>suppressFocus</code>
     * parameter.
     *
     * @return true if we are editing the cell, false if not editing for some reason
     * @see com.smartgwt.client.widgets.grid.ListGrid#canEditCell
     * @see com.smartgwt.client.widgets.grid.ListGrid#getEditEvent
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public native Boolean startEditing() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.startEditing();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Start inline editing at the provided coordinates. <p> Invoked when a cell is editable and the <code>editEvent</code>
     * occurs on that cell.  Can also be invoked explicitly. <P> If this method is called while editing is already in progress,
     * the value from the current editCell will either be stored locally as a temporary edit value, or saved via 'saveEdits()'
     * depending on <code>this.saveByCell</code>, and the position of the new edit cell.<br> Will update the UI to show the
     * editor for the new cell, and put focus in it unless  explicitly suppressed by the optional <code>suppressFocus</code>
     * parameter.
     * @param rowNum Row number of the cell to edit.  Defaults to first                                  editable row
     * @param colNum Column number of the cell to edit.  Defaults to first                                  editable column
     * @param suppressFocus If passed this parameter suppresses the default                                   behavior of focusing in the edit form
     * item when                                   the editor is shown.
     *
     * @return true if we are editing the cell, false if not editing for some reason
     * @see com.smartgwt.client.widgets.grid.ListGrid#canEditCell
     * @see com.smartgwt.client.widgets.grid.ListGrid#getEditEvent
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public native Boolean startEditing(int rowNum, int colNum, boolean suppressFocus) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.startEditing(rowNum, colNum, suppressFocus);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Notification that the user is no longer hovering over some cell. Hides the current hover canvas if one is showing.
     */
    public native void stopHover() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.stopHover();
    }-*/;
            
    /**
     * Toggles the sort-direction of the field with the passed name and resorts the grid.
     * @param fieldName The name of a field, visible, hidden or existing only in the    dataSource
     */
    public native void toggleSort(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.toggleSort(fieldName);
    }-*/;
            
    /**
     * Removes the grouping from the listgrid, restoring its original data
     */
    public native void ungroup() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.ungroup();
    }-*/;
            
    /**
     * Reverses a previous call to {@link com.smartgwt.client.widgets.grid.ListGrid#markRecordRemoved
     * ListGrid.markRecordRemoved}. <P> Note that a record that is marked for removal and then un-marked retains any uncommited
     * edits from before it was marked for removal.  These can be discarded with {@link
     * com.smartgwt.client.widgets.grid.ListGrid#discardEdits ListGrid.discardEdits}.
     * @param rowNum index of record to clear the 'removed'
     */
    public native void unmarkRecordRemoved(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.unmarkRecordRemoved(rowNum);
    }-*/;
            
    /**
     * Turn sorting off, typically because data has changed and is no longer sorted. <p> Calling <code>unsort()</code> disables
     * visual indication of which columns are sorted, and calls <code>unsort()</code> on the underlying dataset. <P> Note that
     * a grid viewing a paged dataset may not be able to support <code>unsort()</code> because the sort order is what
     * establishes the row numbering that allows data to be fetched in batches. <P> <code>unsort()</code> is automatically
     * called when records are dropped or the  {@link com.smartgwt.client.widgets.grid.ListGrid#setSort sort-configuration} is
     * altered.
     */
    public native void unsort() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.unsort();
    }-*/;
            
    /**
     * Validate the current set of edit values for the row in question. <P> Called when the user moves to a new edit row, or
     * when an edited record is to be saved if client side validation is enabled for this grid. <P> This method may also be
     * called directly to perform row level validation at any time.
     * @param rowNum index of row to be validated.
     *
     * @return returns true if validation was successful (no errors encountered), false                    otherwise.
     * @see com.smartgwt.client.docs.GridValidation GridValidation overview and related methods
     */
    public native Boolean validateRow(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.validateRow(rowNum);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
    /**
     * Add a viewStateChanged handler.
     * <p>
     * Notification method executed whenever the viewState of this grid changes. View state is accessible via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getViewState ListGrid.getViewState}, and contains field state information,
     * sort information, selection information, hiliting information and grouping information.
     *
     * @param handler the viewStateChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addViewStateChangedHandler(com.smartgwt.client.widgets.grid.events.ViewStateChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.ViewStateChangedEvent.getType()) == 0) setupViewStateChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.ViewStateChangedEvent.getType());
    }

    private native void setupViewStateChangedEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({viewStateChanged:$entry(function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.grid.events.ViewStateChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.viewStateChanged = $entry(function(){
                   var param = {};
                   var event = @com.smartgwt.client.widgets.grid.events.ViewStateChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
            
    /**
     * Compares the specified criteria with the current criteria applied to this component's data object and determines whether
     * the new criteria could be satisfied from the currently cached set of data, or if a new filter/fetch operation will be
     * required. <P> This is equivalent to calling <code>this.data.willFetchData(...)</code>. Always returns true if this
     * component is not showing a set of data from the dataSource.
     * @param newCriteria new criteria to test.
     *
     * @return true if server fetch would be required to satisfy new criteria.
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native Boolean willFetchData(Criteria newCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.willFetchData(newCriteria == null ? null : newCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Compares the specified criteria with the current criteria applied to this component's data object and determines whether
     * the new criteria could be satisfied from the currently cached set of data, or if a new filter/fetch operation will be
     * required. <P> This is equivalent to calling <code>this.data.willFetchData(...)</code>. Always returns true if this
     * component is not showing a set of data from the dataSource.
     * @param newCriteria new criteria to test.
     * @param textMatchStyle New text match style. If not passed assumes       textMatchStyle will not be modified.
     *
     * @return true if server fetch would be required to satisfy new criteria.
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native Boolean willFetchData(Criteria newCriteria, TextMatchStyle textMatchStyle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.willFetchData(newCriteria == null ? null : newCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), textMatchStyle.@com.smartgwt.client.types.TextMatchStyle::getValue()());
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
     * @param listGridProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(ListGrid listGridProperties) /*-{
    	var properties = $wnd.isc.addProperties({},listGridProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.ListGrid.addProperties(properties);
    }-*/;
        
    // ***********************************************************        


	protected void onInit () {
		super.onInit();
		onInit_ListGrid();
	}
    protected native void onInit_ListGrid() /*-{

        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.__getCellCSSText = self.getCellCSSText;
        self.getCellCSSText = $debox($entry(function(record, rowNum, colNum) {
            var jObj = this.__ref;
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return jObj.@com.smartgwt.client.widgets.grid.ListGrid::getCellCSSText(Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(recordJ, rowNum, colNum);
        }));

        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.__getCellStyle = self.getCellStyle;
        self.getCellStyle = $debox($entry(function(record, rowNum, colNum) {
 
            var jObj = this.__ref;
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return jObj.@com.smartgwt.client.widgets.grid.ListGrid::getCellStyle(Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(recordJ, rowNum, colNum);
        }));

        self.__getBaseStyle = self.getBaseStyle;
        self.getBaseStyle = $debox($entry(function(record, rowNum, colNum) {
            var jObj = this.__ref;
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return jObj.@com.smartgwt.client.widgets.grid.ListGrid::getBaseStyle(Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(recordJ, rowNum, colNum);
        }));

        self.__getHeaderContextMenuItems = self.getHeaderContextMenuItems;
        self.getHeaderContextMenuItems = $entry(function(fieldNum) {
            var jObj = this.__ref;
            var fieldNumJ = fieldNum == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(fieldNum);
            var menuItemsJ = jObj.@com.smartgwt.client.widgets.grid.ListGrid::getHeaderContextMenuItems(Ljava/lang/Integer;)(fieldNumJ);
            var menuItemsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(menuItemsJ);
            return menuItemsJS;
        });

        self.__getHeaderSpanContextMenuItems  = self.getHeaderSpanContextMenuItems;
        self.getHeaderSpanContextMenuItems = $entry(function(headerSpan) {
           var jObj = this.__ref;
           var headerSpanJ = @com.smartgwt.client.widgets.grid.HeaderSpan::new(Lcom/google/gwt/core/client/JavaScriptObject;)(headerSpan);
           var menuItemsJ = jObj.@com.smartgwt.client.widgets.grid.ListGrid::getHeaderSpanContextMenuItems(Lcom/smartgwt/client/widgets/grid/HeaderSpan;)(headerSpanJ);
           var menuItemsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(menuItemsJ);
           return menuItemsJS;
        });

        self.__canEditCell = self.canEditCell;
        self.canEditCell = $debox($entry(function(rowNum, colNum) {
            var jObj = this.__ref;
            return jObj.@com.smartgwt.client.widgets.grid.ListGrid::canEditCell(II)(rowNum, colNum);
        }));

        
        self.__getRollOverCanvas = self.getRollOverCanvas;
        self.getRollOverCanvas = $entry(function(rowNum, colNum) {
            var jObj = this.__ref;
            
            var rowNumJ = rowNum == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(rowNum),
            	colNumJ = colNum == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(colNum);

            var componentJ = jObj.@com.smartgwt.client.widgets.grid.ListGrid::getRollOverCanvas(Ljava/lang/Integer;Ljava/lang/Integer;)(rowNumJ, colNumJ);
            return componentJ == null ? null : componentJ.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
        });

        self.__getRollUnderCanvas = self.getRollUnderCanvas;
        self.getRollUnderCanvas = $entry(function(rowNum, colNum) {
            var jObj = this.__ref;
            var rowNumJ = rowNum == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(rowNum),
            	colNumJ = colNum == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(colNum);

            var componentJ = jObj.@com.smartgwt.client.widgets.grid.ListGrid::getRollUnderCanvas(Ljava/lang/Integer;Ljava/lang/Integer;)(rowNumJ, colNumJ);
            return componentJ == null ? null : componentJ.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
        });
        
        self.__createRecordComponent = self.createRecordComponent;
        if (self.__createRecordComponent == null) {
        	self.__createRecordComponent = function () {
        	}
        }
        self.createRecordComponent = $entry(function (record, colNum) {
    		var jObj = this.__ref;
    		var recordJ =  @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var colNumJ = colNum == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(colNum);

            var componentJ = jObj.@com.smartgwt.client.widgets.grid.ListGrid::createRecordComponent(Lcom/smartgwt/client/widgets/grid/ListGridRecord;Ljava/lang/Integer;)(recordJ, colNumJ);
            return componentJ == null ? null : componentJ.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
        });

        self.__showRecordComponent = self.showRecordComponent;
        if(self.__showRecordComponent === undefined) {
           self.__showRecordComponent = function(record, col) {return true;}
        }
        self.showRecordComponent = $entry(function (record, colNum) {
    		var jObj = this.__ref;
    		var recordJ =  @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var colNumJ = colNum == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(colNum);

            var ret = jObj.@com.smartgwt.client.widgets.grid.ListGrid::showRecordComponent(Lcom/smartgwt/client/widgets/grid/ListGridRecord;Ljava/lang/Integer;)(recordJ, colNumJ);
            return ret;
        });

        
        self.__updateRecordComponent = self.updateRecordComponent;
        if (self.__updateRecordComponent == null) {
        	self.__updateRecordComponent = function (record, colNum, component, recordChanged) {
        	    return component;
        	}
    	}
        self.updateRecordComponent = $entry(function (record, colNum, component, recordChanged) {
			var jObj = this.__ref;
    		var recordJ =  @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var colNumJ = colNum == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(colNum);
            var componentJ = component == null ? null : 
               @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
            componentJ = jObj.@com.smartgwt.client.widgets.grid.ListGrid::updateRecordComponent(Lcom/smartgwt/client/widgets/grid/ListGridRecord;Ljava/lang/Integer;Lcom/smartgwt/client/widgets/Canvas;Z)(recordJ, colNumJ, componentJ, recordChanged);
            return componentJ == null ? null : componentJ.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();        	
        });

        self.__getExpansionComponent = self.getExpansionComponent;
        self.getExpansionComponent = $entry(function(record) {
            var jObj = this.__ref;
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var componentJ = jObj.@com.smartgwt.client.widgets.grid.ListGrid::getExpansionComponent(Lcom/smartgwt/client/widgets/grid/ListGridRecord;)(recordJ);
            return componentJ == null ? null : componentJ.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
        });

        self.__getGridSummary = self.getGridSummary;
        self.getGridSummary = $debox($entry(function(field) {
            var jObj = this.__ref;
            var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var val = jObj.@com.smartgwt.client.widgets.grid.ListGrid::getGridSummary(Lcom/smartgwt/client/widgets/grid/ListGridField;)(fieldJ);
            return $wnd.SmartGWT.convertToPrimitiveType(val);
        }));

        self.__canExpandRecord = self.canExpandRecord;
        self.canExpandRecord = $debox($entry(function(record, rowNum) {
            var jObj = this.__ref;
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var retVal = jObj.@com.smartgwt.client.widgets.grid.ListGrid::canExpandRecord(Lcom/smartgwt/client/widgets/grid/ListGridRecord;I)(recordJ, rowNum);
            return retVal;
        }));

        self.__getRelatedDataSource = self.getRelatedDataSource;
        self.getRelatedDataSource = $entry(function(record) {
            var jObj = this.__ref;
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var dataSourceJ = jObj.@com.smartgwt.client.widgets.grid.ListGrid::getRelatedDataSource(Lcom/smartgwt/client/widgets/grid/ListGridRecord;)(recordJ);
            return dataSourceJ == null ? null : dataSourceJ.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        });
        
        self.__getValueIcon = self.getValueIcon;
        //the rowNum parameter is a non public parameter used for checking whether a cell is editable. Not exposed in the SGWT override method but
        //preserving the rownNum passthrough parameter
        self.getValueIcon = $entry(function(field, value, record, rowNum) {
            var jObj = this.__ref;
            if(jObj == null || jObj === undefined) return this.__getValueIcon(field, value, record, rowNum);
            self._jsOverrideCall.getValueIcon = true;
            var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var valueJ = $wnd.SmartGWT.convertToJavaType(value);
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var icon = jObj.@com.smartgwt.client.widgets.grid.ListGrid::getValueIcon(Lcom/smartgwt/client/widgets/grid/ListGridField;Ljava/lang/Object;Lcom/smartgwt/client/widgets/grid/ListGridRecord;)(fieldJ, valueJ, recordJ);
            if (self._fireDefaultMethod.getValueIcon) {
                icon = this.__getValueIcon(field, value, record, rowNum);
            }
            self._jsOverrideCall.getValueIcon = null;
            self._fireDefaultMethod.getValueIcon = null;
            return icon;
        });


        self.__getCellHoverComponent = self.getCellHoverComponent;
        self.getCellHoverComponent = $entry(function(record, rowNum, colNum) {
            var jObj = this.__ref;
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var rowNumJ = rowNum == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(rowNum),
            	colNumJ = colNum == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(colNum);

            var componentJ = jObj.@com.smartgwt.client.widgets.grid.ListGrid::getCellHoverComponent(Lcom/smartgwt/client/data/Record;Ljava/lang/Integer;Ljava/lang/Integer;)(recordJ,rowNumJ,colNumJ);
            return componentJ == null ? null : componentJ.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
        });    
    }-*/;

    /**
     * Returns the appropriate valueIcon for a cell based on the field and the data value for the  cell. Default implementation
     * returns null if {@link com.smartgwt.client.widgets.grid.ListGridField#getSuppressValueIcon suppressValueIcon} is true
     * otherwise looks at {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIcons valueIcons}.
     * @param field field associated with the cell
     * @param value data value for the cell's record in this field.
     * @param record record associated with this cell
     *
     * <b> Note :</b> This is an override point
     *
     * @return the value icon
     */
    public native String getValueIcon(ListGridField field, Object value, ListGridRecord record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if (self._jsOverrideCall.getValueIcon) {
            self._fireDefaultMethod.getValueIcon = true;
            return;
        }
        var valueJS = $wnd.SmartGWT.convertToPrimitiveType(value);
        return self.__getValueIcon(field.@com.smartgwt.client.core.DataClass::getJsObj()(), valueJS, record.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Returns the expansion component derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getExpansionComponent
     * ListGrid.getExpansionComponent} currently visible in some record, or null if the specified record is not showing an
     * expansion component.
     * @param record rowNum or record to get the expansionComponent for
     *
     * @return the currently visible expansion component for the expanded row.
     */
    public native Canvas getCurrentExpansionComponent(Integer record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCurrentExpansionComponent(record);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.Canvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;

    /**
     * Returns the expansion component derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getExpansionComponent
     * ListGrid.getExpansionComponent} currently visible in some record, or null if the specified record is not showing an
     * expansion component.
     * @param record rowNum or record to get the expansionComponent for
     *
     * @return the currently visible expansion component for the expanded row.
     */
    public native Canvas getCurrentExpansionComponent(ListGridRecord record) /*-{
        if (record == null) return null;
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCurrentExpansionComponent(record.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.Canvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;

    
    /**
     * Returns the {@link com.smartgwt.client.data.DataSource} containing data related to the passed record.  Used when {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is true and {@link
     * com.smartgwt.client.types.ExpansionMode} is "related". The default implementation returns the DataSource specified in
     * {@link com.smartgwt.client.widgets.grid.ListGridRecord#getDetailDS detailDS}.
     *
     * <b> Note :</b> This is an override point
     *
     * @param record The record to get the Related dataSource for.
     *
     * @return The related DataSource for the "record" param
     */
    public native DataSource getRelatedDataSource(ListGridRecord record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.__getRelatedDataSource(record.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.BaseClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.data.DataSource::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;
    

    /**
     * Removes an embedded component previously associated with the provided record.
     * If <code>destroyOnUnEmbed</code> is <code>true</code> for the component, it will also be destroyed.
     *
     * @param record record that the component was previously attached to
     */
    public native void removeEmbeddedComponent(ListGridRecord record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeEmbeddedComponent(record.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
    
    /**
     * Removes an embedded component from a grid. The record in which the component is embedded is 
     * automatically derived from the Component passed in. If 
     * <code>destroyOnUnEmbed</code> is <code>true</code> for the component, it will also be destroyed.
     * @param component the embedded component
     */
    public native void removeEmbeddedComponent(Canvas component) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeEmbeddedComponent(component.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;
    

    /**
     * Removes an embedded component previously associated with the provided record and colNum.
     * Only applies to components embedded directly in a specific cell. If 
     * <code>destroyOnUnEmbed</code> is <code>true</code> for the component, it will also be destroyed.
     * @param record record that the component was previously attached to
     * @param colNum the colNum in which it appears
     */
    public native void removeEmbeddedComponent(ListGridRecord record, Integer colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeEmbeddedComponent(record.@com.smartgwt.client.core.DataClass::getJsObj()(), colNum);
    }-*/;
    
    /**
     * If  {@link com.smartgwt.client.widgets.grid.ListGrid#showRollUnderCanvas showRollUnderCanvas} is true, this
     * method will be called to create the canvas to display under the current row when a
     * user moves their mouse under the row.<br>
     * Note that for efficiency this should not typically create a new canvas instance, every time it is called.
     * Instead typically a single rollUnder canvas should be created and updated to reflect the current rollOver row if
     * necessary.
     * <br><b>Note: This is an override point</b>
     *
     * @param rowNum Index of the current roll-over row
     * @param colNum Index of the current roll-over column. This parameter will be null unless useCellRollOvers is true on the grid
     * @return the embedded component
     */
    protected native Canvas getRollUnderCanvas (Integer rowNum, Integer colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        rowNum = rowNum == null ? null : rowNum.@java.lang.Integer::intValue()();
        colNum = colNum == null ? null : colNum.@java.lang.Integer::intValue()();
        var component = self.__getRollUnderCanvas(rowNum, colNum);
        return @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
    }-*/;

    /**
      * When {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents showRecordComponents} is true, this method
     * is called for a row/cell  the first time it is brought into the drawArea, or when there are not yet any components  in
     * the pool.   <P>The colNum parameter is applicable only when  listGrid.getShowRecordComponentsByCell returns true.
     * <br><b>Note: This is an override point</b>
     * @param record record to create a component for
     * @param colNum Column to show the new component in. This parameter will be null unless showRecordComponentsByCell is true on the grid
     * @return the embedded component
     */
    protected native Canvas createRecordComponent (ListGridRecord record, Integer colNum) /*-{
    
      	var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
      	
      	record = record.@com.smartgwt.client.core.DataClass::getJsObj()();
      	colNum = colNum == null ? null : colNum.@java.lang.Integer::intValue()();
      	
      	var component = self.__createRecordComponent(record, colNum);
        return component == null ? null : 
               @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
    }-*/;

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents showRecordComponents} is true, return
     * false from this method  to prevent showRecordComponent behavior for the passed record. Second parameter will only be
     * passed if {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponentsByCell showRecordComponentsByCell} is
     * true.
     * <br><b>Note: This is an override point</b>
     *
     * @param record record being processed
     * @param colNum column index of the cell in which the record component   may be shown. Will be null unless showRecordComponentsByCell is
     * true.
     *
     * @return return false to cancel showRecordComponent behavior
     */
    protected native boolean showRecordComponent(ListGridRecord record, Integer colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        colNum = colNum == null ? null : colNum.@java.lang.Integer::intValue()();
        var retVal =self.__showRecordComponent(record.@com.smartgwt.client.core.DataClass::getJsObj()(), colNum);
        if(retVal == null || retVal === undefined) {
            return false;
        } else {
            return retVal;
        }
    }-*/;

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents showRecordComponents} is true, this method
     * is called for a row/cell  that has already been rendered.  The colNum parameter is applicable only when  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponentsByCell showRecordComponentsByCell}
     *  is true.
     * <br><b>Note: This is an override point</b>
     * @param record record to which the passed component applies
     * @param colNum cell to which the passed component applies. This parameter will be null unless showRecordComponentsByCell has been set for this grid
     * @param component the component to update
     * @param recordChanged was the passed component previously embedded in a different record?
     *
     * @return return the updated embedded component
     */
    public native Canvas updateRecordComponent(ListGridRecord record, Integer colNum, Canvas component, boolean recordChanged) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        record = record.@com.smartgwt.client.core.DataClass::getJsObj()();
        colNum = colNum == null ? null : colNum.@java.lang.Integer::intValue()();
        component = component.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        
        component = self.__updateRecordComponent(record, colNum, component, recordChanged);
        return component == null ? null : @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
        
    }-*/;
    
    /**
     * If  {@link com.smartgwt.client.widgets.grid.ListGrid#showRollOverCanvas showRollOverCanvas} is true, this
     * method will be called to create the canvas to display over the current row when a
     * user moves their mouse over the row.<br>
     * Note that for efficiency this should not typically create a new canvas instance, every time it is called.
     * Instead typically a single rollOver canvas should be created and updated to reflect the current rollOver row if
     * necessary.
     * <br><b>Note: This is an override point</b>
     *
     * @param rowNum Index of the current roll-over row
     * @param colNum Index of the current roll-over column. This parameter will be null unless useCellRollOvers is true for the grid 
     * @return the embedded component
     */
    protected native Canvas getRollOverCanvas(Integer rowNum, Integer colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        rowNum = rowNum == null ? null : rowNum.@java.lang.Integer::intValue()();
        colNum = colNum == null ? null : colNum.@java.lang.Integer::intValue()();
    
        var component = self.__getRollOverCanvas(rowNum, colNum);
        return @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
    }-*/;

    /**
     * Gets the embedded-component to show as a given record's hoverComponent.  This component is then shown instead of the
     * standard Hover-text.
     * <p><br>
     * By default, this method returns one of a set of builtin components, according to the value of listGrid.hoverMode.
     * You can override this method  to return any component you wish to provide as a hoverComponent.
     * <br><b>Note: This is an override point</b>
     *
     * @param record record to get the hoverComponent for
     * @param rowNum the row number
     * @param colNum the column number
     * @return the component to show as a hover
     */
    protected native Canvas getCellHoverComponent(Record record, Integer rowNum, Integer colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.core.DataClass::getJsObj()();
        rowNum = rowNum == null ? null : rowNum.@java.lang.Integer::intValue()();
        colNum = colNum == null ? null : colNum.@java.lang.Integer::intValue()();

        var component = self.__getCellHoverComponent(recordJS, rowNum, colNum);
        return @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
    }-*/;

    /**
     * Expands a given record by creating a subcomponent and inserting it
     * in to the record's grid-row.  A number of built-in {@link com.smartgwt.client.types.ExpansionMode}  are supported by the
     * default implementation of  {@link com.smartgwt.client.widgets.grid.ListGrid#getExpansionComponent} and you can override
     * that method to provide more specific expansionComponents.
     * <br><b>Note: This is an override point</b>
     *
     * @param record record to work with
     * @param rowNum rowNum of the record to work with
     *
     * @return true if the record can be expanded
     */
    public native boolean canExpandRecord(ListGridRecord record, int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.__canExpandRecord(record.@com.smartgwt.client.core.DataClass::getJsObj()(), rowNum);
        if(retVal == null || retVal === undefined) {
            return false;
        } else {
            return retVal;
        }
    }-*/;

    /**
     * Gets the embedded-component to show as a given record's expansionComponent.  This  component is then housed in a VLayout
     * and embedded into a record's row. <P> By default, this method returns one of a set of builtin components, according the
     * value  of {@link com.smartgwt.client.widgets.grid.ListGrid#getExpansionMode expansionMode}.  You can override this
     * method to return any component  you wish to provide as an expansionComponent.
     * <br><b>Note: This is an override point</b>
     *
     * @param record record to get the expansionComponent for
     * @return the embedded component
     */
    protected native Canvas getExpansionComponent(ListGridRecord record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var component = self.__getExpansionComponent(record.@com.smartgwt.client.core.DataClass::getJsObj()());
        return @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
    }-*/;

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} is <code>true</code> this
     * method is called for each field which will show a grid summary value (as described in {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getShowGridSummary showGridSummary} to get the summary value to display
     * below the relevant column. <P> The default implementation is as follows: <ul><li>If this is a databound grid and not all
     * data is loaded, returns null for every field</li>     <li>Otherwise if {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGridSummary} is defined, calls that method passing         in the
     * current data set for the grid</li>     <li>If {@link com.smartgwt.client.widgets.grid.ListGridField#getGridSummary} is
     * undefined, makes use of the          {@link com.smartgwt.client.widgets.grid.ListGrid#getGridSummaryFunction} for the
     * field to          calculate the summary based on the current data set</li> </ul> This method may be overridden to
     * completely customize the summary value displayed for columns in this grid. An example use case would be when summary
     * information is available on the client and does note need to be calculated directly from the data. <b>Note:</b> this
     * method will not be called if ${isc.DocUtils.linkForRef('listGrid.gridSummaryDataSource')} is specified.
     * @param field field for which the summary value should be returned
     *
     * <br><b>Note: This is an override point</b>
     *
     * @return summary value to display for the specified field.
     */
    protected native Object getGridSummary(ListGridField field) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.__getGridSummary(field.@com.smartgwt.client.core.DataClass::getJsObj()());
        var valueJ = $wnd.SmartGWT.convertToJavaType(value);
        return valueJ;
    }-*/;


    /**
     * Return CSS text for styling this cell, which will be applied in addition to the CSS class for the cell, as
     * overrides. <p> "CSS text" means semicolon-separated style settings, suitable for inclusion in a CSS stylesheet or
     * in a STYLE attribute of an HTML element.
     * <br><b>Note: This is an override point</b>
     *
     *
     * @param record cell record as returned by getCellRecord
     * @param rowNum row number for the cell
     * @param colNum column number of the cell
     * @return CSS text for this cell
     */
    protected native String getCellCSSText(ListGridRecord record, int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.__getCellCSSText(record == null ? null : record.@com.smartgwt.client.core.DataClass::getJsObj()(), rowNum, colNum);
    }-*/;

    /**
     * Return the CSS class for a cell. By default this method has the following implementation:<br> - return any custom style
     * for the record (see {@link com.smartgwt.client.grid.GridRenderer#getRecordCustomStyleProperty
     * recordCustomStyleProperty})    if defined.<br> - create a style name based on the result of {@link
     * com.smartgwt.client.grid.GridRenderer#getBaseStyle GridRenderer.getBaseStyle} and the    state of the record.<br> The
     * state of the record is indicated by adding a suffix to the base style. There are four independent boolean states, which
     * are combined in the order given: <ol> <li>"Disabled" : whether the cell is disabled; enable by setting the "enabled"
     * flag on record     returned by getCellRecord <li>"Selected" : whether cell is selected; enable by passing a Selection
     * object as "selection" <li>"Over" : mouse is over this cell; enable with showRollovers <li>"Dark" : alternating color
     * bands; enable with alternateRowStyles </ol> For example, with a baseStyle of "myCell", a cell which is selected, which
     * the mouse is over, and which is in a dark-colored band will get a styleName of myCellSelectedOverDark. <p> Cell Styles
     * customizable by: <ul> <li>attaching a custom style to a record by setting
     * <code>record[this.recordCustomStyleProperty]</code> to some valid CSS style name.   <li>modifying the base style
     * returned by getBaseStyle() [see that method for further      documentation on this] <li>overriding this function </ul>
     * <p> "Selected" style can be ignored by setting {@link com.smartgwt.client.grid.GridRenderer#getShowSelectedStyle
     * showSelectedStyle} to false.
     *
     * <br><b>Note: This is an override point</b>
     *
     * @param record record object for this row and column
     * @param rowNum number of the row
     * @param colNum number of the column
     *
     * @return CSS style for this cell
     * @see com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    protected native String getCellStyle(ListGridRecord record, int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.__getCellStyle(record == null ? null : record.@com.smartgwt.client.core.DataClass::getJsObj()(), rowNum, colNum);
    }-*/;

    /**
     * Can this cell be edited? <P> The default implementation of <code>canEditCell()</code> respects the various property settings affecting
     * editability: {@link com.smartgwt.client.widgets.grid.ListGridField#getCanEdit canEdit} disables editing for a field,
     * a record with the {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordEditProperty recordEditProperty} set to false is not editable,
     * and disabled records are not editable. <P> You can override this method to control editability on a cell-by-cell basis.
     * In order to allow complete control over editing, <code>canEditCell()</code> is called very frequently.  If you see delays on row to row navigation,
     * check that your implementation is efficient <li> If you change the editability of a cell on the fly, for example, during
     * {@link com.smartgwt.client.widgets.grid.ListGrid#editorExit} on another cell, call refreshCell() to show or hide the editor <li>
     * If this ListGrid allows new records to be created, <code>canEditCell()</code> may be called when there is no record available.
     * The values input so far by the user are available via {@link com.smartgwt.client.widgets.grid.ListGrid#getEditValues}.  </ul>
     *
     * <p><b>Note: This is an override point</b>
     *
     * @param rowNum row number for the cell
     * @param colNum column number of the cell
     *
     * @return Whether to allow editing this cell
     */
    protected native boolean canEditCell(int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.__canEditCell(rowNum, colNum);
    }-*/;

    /**
     * If ListGrid.showHeaderContextMenu is true this method returns the menu items to be displayed in the default header context menu.
     * <br>
     * This method will be called each time the menu is displayed, allowing for dynamic content depending on the current state of the fields.
     * <br>
     * The default set of menu items will includes menu items for freezing fields, showing and hiding fields, grouping by fields, or other listGrid features
     * <br><b>Note: This is an override point</b>
     *
     * @param fieldNum index of the field the user clicked in the fields array. Note: if the user right-clicked the sorter button this parameter will be null.
     * @return Array of MenuItem
     */
    protected native MenuItem[] getHeaderContextMenuItems(Integer fieldNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var index = fieldNum == null ? null : fieldNum.@java.lang.Integer::intValue()();
        var menuItemsJS = self.__getHeaderContextMenuItems(index);
        var menuItemsJ = @com.smartgwt.client.widgets.menu.Menu::convertToMenuItemArray(Lcom/google/gwt/core/client/JavaScriptObject;)(menuItemsJS);
        return menuItemsJ;
    }-*/;

    /**
     * Return the menus items that should be shown in a menu triggered from a headerSpan. By default no contextMenu is shown.
     * <br><b>Note: This is an override point</b>
     *
     * @param headerSpan the component representing the headerSpan. This component will have all the properties specified via ListGrid.headerSpans
     * @return an arrow of MenuItem's
     */
    protected native MenuItem[] getHeaderSpanContextMenuItems(HeaderSpan headerSpan) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var headerSpanJS = headerSpan.@com.smartgwt.client.core.DataClass::getJsObj()();
        var menuItemsJS = self.__getHeaderSpanContextMenuItems(headerSpanJS);
        if(menuItemsJS == false) return null;
        var menuItemsJ = @com.smartgwt.client.widgets.menu.Menu::convertToMenuItemArray(Lcom/google/gwt/core/client/JavaScriptObject;)(menuItemsJS);
        return menuItemsJ;
    }-*/;

    /**
     * Return the base stylename for this cell. Has the following implementation by default: <ul> <li>If
     * this.editFailedBaseStyle is defined, and the cell is displaying a validation error return this value.</li> <li>If
     * this.editFailedPendingStyle is defined, and the cell is displaying an edit value that has not yet been saved (see
     * ListGrid.autoSaveEdits) return this value.</li> <li>Otherwise return record[listGrid.recordBaseStyleProperty], if
     * defined, otherwise field.baseStyle, or finally this.baseStyle</li> </ul>
     * <br><b>Note: This is an override point</b>
     *
     * @param record the record
     * @param rowNum the row num
     * @param colNum the colum num
     * @return the CSS class for this cell
     */
    protected native String getBaseStyle(ListGridRecord record, int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.__getBaseStyle(record == null ? null : record.@com.smartgwt.client.core.DataClass::getJsObj()(), rowNum, colNum);
    }-*/;

    /**
     * Set the properties generated field that displays the current row number when {@link #setShowRowNumbers(Boolean) showRowNumbers} is true.
     * For example you can change the default width of the row number column if you have data that exceeds 4 digits to accommodate the width of, say, 10000.
     *
     * @param rowNumberFieldProperties the row number field properties
     */
    public void setRowNumberFieldProperties(ListGridField rowNumberFieldProperties) {
        setAttribute("rowNumberFieldProperties", rowNumberFieldProperties, true);
    }

    /**
     * If {@link ListGrid#setShowGridSummary(Boolean)} is true, and a
     * ${isc.DocUtils.linkForRef('listGrid.summaryDataSource')} is specified this property may be used to customize the fetch
     * request used when retrieving summary data to show in the summary row. An example use case might be specifying a
     * ${isc.DocUtils.linkForRef('DSRequest.OperationId')} to perform a custom fetch operation which retrieved only summary
     * values based on criteria.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param summaryRowFetchRequestProperties summaryRowFetchRequestProperties Default value is null
     */
    public void setSummaryRowFetchRequestProperties(DSRequest summaryRowFetchRequestProperties) {
        setAttribute("summaryRowFetchRequestProperties", summaryRowFetchRequestProperties, true);
    }

    /**
     * If {@link ListGrid#setShowGridSummary(Boolean)} is true, and a
     * ${isc.DocUtils.linkForRef('listGrid.summaryDataSource')} is specified this property may be used to customize the fetch
     * request used when retrieving summary data to show in the summary row. An example use case might be specifying a
     * ${isc.DocUtils.linkForRef('DSRequest.OperationId')} to perform a custom fetch operation which retrieved only summary
     * values based on criteria.
     *
     *
     * @return DSRequest properties
     */
    public DSRequest getSummaryRowFetchRequestProperties()  {
        return DSRequest.getOrCreateRef(getAttributeAsJavaScriptObject("summaryRowFetchRequestProperties"));
    }

    /**
     * If this is an editable listGrid, this property will specify the {@link com.smartgwt.client.widgets.form.fields.DateItem#setInputFormat(String) inputFormat}
     * applied to editors for fields of type "date"
     *
     * 3 character string containing the "M", "D" and "Y" characters to indicate the format of strings being parsed into Date instances via Date.parseInput().
     *
     * <p>
     * As an example - an input format of "MDY" would parse "01/02/1999" to Jan 2nd 1999
     *
     * @param dateInputFormat the dateInputFormat
     */
    public void setDateInputFormat(String dateInputFormat) {
        setAttribute("dateInputFormat", dateInputFormat, true);
    }

    /**
     * An array of field objects, specifying the order, layout, formatting, and sorting behavior of each field in the
     * listGrid object.  In ListGrids, the fields array specifies columns.  Each field in the fields array is a
     * ListGridField object.  Any listGrid that will display data should have at least one visible field. <p> If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource} is also set, this value acts as a set of
     * overrides as explained in {@link com.smartgwt.client.widgets.DataBoundComponent#getFields fields}. Sets the fields array
     * and/or field widths to newFields and sizes, respectively.<br><br> If newFields is specified, it is assumed that
     * the new fields may have nothing in common with the old fields, and the component is substantially rebuilt.
     * Consider the following methods for more efficient, more incremental changes: resizeField, reorderField,
     * showField, hideField, setFieldProperty.
     *
     * @param fields array of fields to draw. Default value is null
     */
    public void setFields(ListGridField... fields) {
        setAttribute("fields", fields, true);
    }

    /**
     * For databound ListGrids, this attribute can be used to customize the {@link com.smartgwt.client.data.ResultSet} object created for this grid when data is fetched
     *
     * @param resultSetProperties the data properties
     */
    public void setDataProperties(ResultSet resultSetProperties) {
        setAttribute("dataProperties", resultSetProperties.getConfig(), true);
    }

    /**
     * A List of ListGridRecord objects, specifying the data to be used to populate the ListGrid.  In ListGrids, the
     * data array specifies rows. Note that ListGrids automatically observe changes to the data List and redraw
     * accordingly. <p> This property is settable directly only as part of a {@link
     * com.smartgwt.client.widgets.grid.ListGrid} constructor.  If you want to change the {@link
     * com.smartgwt.client.widgets.grid.ListGrid}'s data after initial creation, call {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setData}. <p> This property will typically not be explicitly specified
     * for databound ListGrids, where the data is returned from the server via databound component methods such as
     * {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData}. In this case the data objects will be set to a
     * {@link com.smartgwt.client.data.ResultSet} rather than a simple array. Initialize the data object with the given
     * array. Observes methods of the data object so that when the data changes, the listGrid will redraw
     * automatically.
     *
     * @param records data to show in the list. Default value is null
     */
    public void setData(ListGridRecord[] records) {
        setAttribute("data", records, true);
    }

    /**
     * An array of Record objects, specifying the data to be used to populate the DataBoundComponent. 
     *
     * @param data array of Record objects.
     * @see #setData(ListGridRecord[])   
     */
    public void setData(Record[] data) {
        setAttribute("data", data, true);
    }

    /**
     * An List of Record objects, specifying the data to be used to populate the DataBoundComponent. Note that ListGrids automatically observe changes to the data List and redraw accordingly.
     *
     * @param data List of Records
     */
    public void setData(RecordList data) {
        setAttribute("data", data == null ? null : data.getOrCreateJsObj(), true);
    }

    /**
     * Return the grid data as a {@link com.smartgwt.client.data.RecordList}. If the component is bound to a DataSource,
     * the actual type of the RecordList instance will be a {@link com.smartgwt.client.data.ResultSet}.
     *
     * @return the data
     */
    public RecordList getDataAsRecordList() {
        return getRecordList();
    }
    
    /**
     * Synonym for {@link #setData(ListGridRecord[])}
     *
     * @param records the records
     */
    public void setRecords(ListGridRecord[] records) {
        setAttribute("data", records, true);
    }

    /**
     * Returns the current set of records displayed in this grid as an array of ListGridRecord objects. 
     * Note that if the ListGrid is grouped, you can call {@link #getGroupTree()}
     * to get the underlying Tree data representation. You can call {@link #isGrouped()} to test whether the ListGrid is
     * grouped on a field.
     * <p>
     * If this is a DataBound grid this method will return an empty array unless
     * the entire set of data for the current criteria has been loaded into the
     * client, in which case all matching rows will be returned.  
     * For DataBound grids, you can call {@link #getResultSet()} to retrieve
     * the current data set as a ResultSet object.
     *
     * @return an array or records.
     */
    public ListGridRecord[] getRecords() {
        if(isGrouped()) {
            return convertToListGridRecordArray(getAttributeAsJavaScriptObject("originalData"));
        } else {
            return convertToListGridRecordArray(getAttributeAsJavaScriptObject("data"));
        }
    }

    /**
     * Return true if the ListGrid is grouped on a field.
     *
     * @return true if grouped
     */
    public boolean isGrouped() {
        return getGroupTree() != null;
    }

    /**
     * If the ListGrid is grouped, return the underlying tree structure.
     *
     * @return the ListGrid group tree
     */
    public Tree getGroupTree() {
        return Tree.getOrCreateRef(getAttributeAsJavaScriptObject("groupTree"));
    }

    /**
    * Property name on a record that will be checked to determine whether a record is enabled.&#010 <P>&#010 Setting this property on a record will effect the visual style and interactivity of&#010 the record.  If set to <code>false</code> the record (row in a {@link com.smartgwt.client.widgets.grid.ListGrid} or&#010 {@link com.smartgwt.client.widgets.tree.TreeGrid}) will not highlight when the mouse moves over it, nor will it respond to&#010 mouse clicks.
    *
    * @param recordEnabledProperty recordEnabledProperty Default value is "enabled"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setRecordEnabledProperty(String recordEnabledProperty)  throws IllegalStateException {
        setAttribute("recordEnabledProperty", recordEnabledProperty, false);
    }
    /**
     * Property name on a record that will be checked to determine whether a record is enabled.&#010 <P>&#010 Setting this property on a record will effect the visual style and interactivity of&#010 the record.  If set to <code>false</code> the record (row in a {@link com.smartgwt.client.widgets.grid.ListGrid} or&#010 {@link com.smartgwt.client.widgets.tree.TreeGrid}) will not highlight when the mouse moves over it, nor will it respond to&#010 mouse clicks.
     *
     *
     * @return String
     *
     */
    public String getRecordEnabledProperty()  {
        return getAttributeAsString("recordEnabledProperty");
    }

    /**
     * Specifies the field by which this grid should be initially sorted.
     *
     * @param fieldName the field Name
     */
    public void setSortField(String fieldName) {
        setAttribute("sortField", fieldName, true);
    }

    /**
     * The field by which this grid should be initially sorted.
     *
     * @return the sort field
     */
    public String getSortField() {
        return getAttribute("sortField");
    }

    /**
     * Specifies the field by which this grid should be initially sorted. Note that if sortField is initally specified
     * as a number, it will be converted to a string (field name) after list grid initialization.
     *
     * @param fieldIndex the field index
     */
    public void setSortField(int fieldIndex) {
        setAttribute("sortField", fieldIndex, true);
    }

    /**
     * Header spans are a second level of headers that appear above the normal ListGrid headers, spanning one or more
     * listGrid fields in a manner similar to a column-spanning cell in an  HTML table. <P> A header span can be created
     * by simply naming the fields the header should span.  The example below creates a headerSpan that spans the first
     * two fields of the ListGrid. <pre>    isc.ListGrid.create({        headerHeight:40,        fields : [            {
     * name:"field1" },            { name:"field2" },            { name:"field3" }        ],        headerSpans : [
     *       {                 fields: ["field1", "field2"],                title: "Field 1 and 2"            }        ]
     *    }); </pre> Header spans will automatically react to resizing of the headers they span, and will be hidden
     * automatically when all of the spanned fields are hidden. <P> Header spans appear in the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeader header} area of the ListGrid, sharing space with the existing
     * headers, so it's typical to set {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderHeight headerHeight} to
     * approximately double its normal height when using headerSpans. <P> See {@link com.smartgwt.client.widgets.grid.HeaderSpan}
     * for many properties that allow the control of the appearance of headerSpans.  Note that headerSpans are created
     * via the AutoChild pattern, hence you can change the Smart GWT component
     * being used, or any of it's properties. <P> Neither headerSpans themselves nor the fields within them may be drag
     * reordered, but other unspanned headers may be. <P> Note that headerSpans primarily provide a visual cue for
     * grouping multiple headers  together.  If you have an OLAP, data "cube" or multi-dimensional data model, the
     * {@link com.smartgwt.client..CubeGrid} component is the right choice.
     * Update the headerSpans configuration on the grid dynamically.
     *
     * @param headerSpans same configuration block as that passed to                                   {@link
     *                    com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans}.. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHeaderSpans(HeaderSpan... headerSpans) throws IllegalStateException {
        setAttribute("headerSpans", headerSpans, false);
    }

    /**
     * Field to group grid records by. After initialization, use {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy}  to
     * update the grouping field list, instead of modifying groupByField directly.
     *
     * @param field groupByField Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGroupByField(String field) throws IllegalStateException {
        setAttribute("groupByField", field, false);
    }

    /**
     * List of fields to group grid records. If only a single field is used, that field may be specified as a string.
     * After initialization, use {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy}  to update the grouping field
     * list, instead of modifying groupByField directly.
     *
     * @param field groupByField Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGroupByField(String... field) throws IllegalStateException {
        setAttribute("groupByField", field, false);
    }

    /**
     * Get the current grouping of this listGrid as an array of fieldNames.
     * <P>
     * This method returns an arry containing the names of the field(s) by which this
     * grid is grouped (either from {@link #setGroupByField(String... field)} or
     * or from a call to {@link #groupBy(String...)}).
     * If this grid is not currently grouped, this method will return null.
     * @return Current group by field names.
     */
    public String[] getGroupByFields()  {
        JavaScriptObject fields = getGroupByFieldsJS();
        return fields == null ? null : JSOHelper.convertToJavaStringArray(fields);
    }
    private native JavaScriptObject getGroupByFieldsJS() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            return self.getGroupByFields();
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var field = config.groupByField;
            if (field == null) return null;
            if (!$wnd.isc.isAn.Array(field)) {
                field = new $wnd.Array(field);
            }
            return field;
        }
    }-*/;


    /**
     * Describes the default state of ListGrid groups when groupBy is called. Possible values are: <ul> <li>"all": open
     * all groups </li><li>"first": open the first group </li><li>"none": start with all groups closed </li><li>Array of
     * values that should be opened </li> </ul>
     *
     * @param group the group
     */
    public void setGroupStartOpen(GroupStartOpen group) {
        setAttribute("groupStartOpen", group, true);
    }

    /**
     * @param groupValues Array of values that should be opened
     */
    public void setGroupStartOpen(Object... groupValues) {
        setAttribute("groupStartOpen", groupValues, true);
    }

    /**
     * Canvas with properties to apply to the auto-generated Selection Canvas properties when
     * {@link #setShowSelectionCanvas(Boolean) showSelectionCanvas} is true.
     *
     * @param selectionUnderCanvasProperties the selection under Canvas properties
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSelectionCanvasProperties(Canvas selectionCanvasProperties) throws IllegalStateException {
        setAttribute("selectionCanvasProperties", selectionCanvasProperties.getConfig(), false);
    }

    /**
     * Canvas with properties to apply to the auto-generated Selection Under Canvas properties when
     * {@link #setShowSelectionCanvas(Boolean) showSelectionCanvas} is true.
     *
     * @param selectionUnderCanvasProperties the selection under Canvas properties
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSelectionUnderCanvasProperties(Canvas selectionUnderCanvasProperties) throws IllegalStateException {
        setAttribute("selectionUnderCanvasProperties", selectionUnderCanvasProperties.getConfig(), false);
    }

    /**
     * The RollUnder Canvas properties when {@link #setShowRollOver(Boolean) showRollover} is true and
     * {@link #setShowRollOverCanvas(Boolean) showRollOverCanvas} is true. This canvas will be created and displayed behind the current rollOver 
     * cell in the page's z-order, meaning it will only be visible if the cell styling is transparent.
     *
     * @param rollUnderCanvasProperties the roll under Canvas properties
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRollUnderCanvasProperties(Canvas rollUnderCanvasProperties) throws IllegalStateException {
        setAttribute("rollUnderCanvasProperties", rollUnderCanvasProperties.getConfig(), false);
    }
    
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor} is true, this attribute may be
     * used to customize the filter button shown to the right of the filterEditor row.
     *
     * @param filterButtonProperties filterButtonProperties Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFilterButtonProperties(Button filterButtonProperties)  throws IllegalStateException {
        setAttribute("filterButtonProperties", filterButtonProperties == null ? null : filterButtonProperties.getConfig(), false);
    }
    /**
     * Bind to a DataSource.
     * <P>
     * Binding to a DataSource means that the component will use the DataSource to provide default data for 
     * its fields.
     * <P>
     * When binding to a new DataSource, if the component has any existing "fields" or has a dataset, 
     * these will be discarded by default, since it is assumed the new DataSource may represent a completely 
     * unrelated set of objects. If the old "fields" are still relevant, pass them to setDataSource(). 
     * @param dataSource
     * @param fields
     */
    public void setDataSource(DataSource dataSource, ListGridField... fields) {
        if (!isCreated()) {
            setFields(fields);
            setDataSource(dataSource);
        } else {
            JavaScriptObject jsFields = null;
            if (fields != null) {
                jsFields = JSOHelper.createJavaScriptArray();
                for (int i = 0; i < fields.length; i++) {
                    JSOHelper.setArrayValue(jsFields, i, fields[i].getJsObj());
                }
            }
            setDataSourceJS(dataSource.getOrCreateJsObj(), jsFields);
        }
    }
    private native void setDataSourceJS(JavaScriptObject dataSource, JavaScriptObject fields) /*-{
        var self = this.@com.smartgwt.client.widgets.grid.ListGrid::getJsObj()();
        self.setDataSource(dataSource, fields);
    }-*/;

    
    /**
     * An array of listGrid field configuration objects.  When a listGrid is initialized, if this property is set and there is
     * no value for the <code>fields</code> attribute, this.fields will be defaulted to a generated array of field objects
     * duplicated from this array. <P> This property is useful for cases where a standard set of fields will be displayed in
     * multiple listGrids - for example a subclass of ListGrid intended to display a particular type of data:<br> In this
     * example we would not assign a single {@link com.smartgwt.client.widgets.grid.ListGrid#getFields fields} array directly
     * to the class via <code>addProperties()</code> as every generated instance of this class would then point to the same
     * fields array object. This would cause unexpected behavior such as changes to the field order in one grid effecting other
     * grids on the page.<br> Instead we could use <code>addProperties()</code> on our new subclass to set
     * <code>defaultFields</code> to a standard array of fields to display. Each generated instance of the subclass would then
     * show up with default fields duplicated from this array.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param defaultFields defaultFields Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDefaultFields(ListGridField[] defaultFields)  throws IllegalStateException {
        setAttribute("defaultFields", defaultFields, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is true and {@link
     * com.smartgwt.client.types.ExpansionMode listGrid.expansionMode} is <code>"related"</code>, this property specifies the
     * dataSource for the  related records grid to be shown embedded in expanded records. <P> This property may also be
     * specified on a per-record basis - see  {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordDetailDSProperty
     * recordDetailDSProperty}
     *
     *
     * @param detailDS detail datasource
     */
    public void setDetailDS(DataSource detailDS) {
        setAttribute("detailDS", detailDS == null ? null : detailDS.getOrCreateJsObj(), true);
    }
    

    /**
     * An array of listGrid field configuration objects.  When a listGrid is initialized, if this property is set and there is
     * no value for the <code>fields</code> attribute, this.fields will be defaulted to a generated array of field objects
     * duplicated from this array. <P> This property is useful for cases where a standard set of fields will be displayed in
     * multiple listGrids - for example a subclass of ListGrid intended to display a particular type of data:<br> In this
     * example we would not assign a single {@link com.smartgwt.client.widgets.grid.ListGrid#getFields fields} array directly
     * to the class via <code>addProperties()</code> as every generated instance of this class would then point to the same
     * fields array object. This would cause unexpected behavior such as changes to the field order in one grid effecting other
     * grids on the page.<br> Instead we could use <code>addProperties()</code> on our new subclass to set
     * <code>defaultFields</code> to a standard array of fields to display. Each generated instance of the subclass would then
     * show up with default fields duplicated from this array.
     *
     *
     * @return Array of ListGridField Properties
     */
    public ListGridField[] getDefaultFields()  {
        return convertToListGridFieldArray(getAttributeAsJavaScriptObject("defaultFields"));
    }
    
    /**
     * Standard properties to apply to the automatically generated checkbox field, shown when
     * {@link #setSelectionAppearance(),selectionAppearance} is set to "checkbox".
     * <P>
     * Any properties applied to the ListGridField passed in will be overlaid onto the automatically
     * generated checkbox field, allowing the developer to customize this field - for example
     * modifying the appearance for skinning purposes, or setting <code>shouldPrint</code> to
     * include the field in the print-view of the grid.
     * @param checkboxField properties to apply to the checkbox field
     */
    public void setCheckboxFieldProperties (ListGridField checkboxField) {
        JavaScriptObject config = checkboxField.getJsObj();
        setAttribute("checkboxFieldProperties", config, true);
    }

    /**
     * Return the total number of rows in the grid. <P> Note that, when creating new rows via inline editing, this can
     * be more than the total number of rows in the dataset (that is, grid.data.getLength())
     *
     * @return the total rows
     */
    public native int getTotalRows() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getTotalRows();
    }-*/;

    /**
     * Scroll to the specified row number.
     *
     * @param rowNum the row num
     */
    public void scrollToRow(int rowNum) {
        int cellHeight = getCellHeight();
        scrollBodyTo(null, (rowNum - 1) * cellHeight);
    }

    /**
     * Scroll the body of the grid to the specified coordinates.
     *
     * @param left the left position
     * @param top the top position
     */
    public native void scrollBodyTo(Integer left, Integer top)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var body = self.body;
        if (body == null) return;
        var leftJS = left == null ? null : left.@java.lang.Integer::intValue()();
        var topJS = top == null ? null : top.@java.lang.Integer::intValue()();
        body.scrollTo(leftJS, topJS);
     }-*/;
    
    /**
     * Get the current scrollLeft for the body of this ListGrid
     * @return left scroll coordinate. May be null if this component has not been drawn.
     */
    public native Integer getBodyScrollLeft() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var body = self.body;
        if (body == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toInteger(I)(body.getScrollLeft());
    }-*/;

    /**
     * Get the current scrollTop for the body of this ListGrid
     * @return top scroll coordinate. May be null if this component has not been drawn.
     */
    public native Integer getBodyScrollTop() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var body = self.body;
        if (body == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toInteger(I)(body.getScrollTop());
    }-*/;

    /**
     * Force a field to be shown. NOTE: If a field.showIf expression exists, it will be destroyed.
     *
     * @param fieldName the field name
     */
    public native void showField(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showField(fieldName);
    }-*/;

    /**
     * Force a field to be shown. NOTE: If a field.showIf expression exists, it will be destroyed.
     *
     * @param fieldName        the field name
     * @param suppressRelayout if true, don't relayout non-explicit sized fields to fit the available space
     */
    public native void showField(String fieldName, boolean suppressRelayout) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showField(fieldName, suppressRelayout);
    }-*/;

    /**
     * Change the title of a field after the grid is created.
     *
     * @param fieldName name of the field, or index.
     * @param title    new title
     */
    public native void setFieldTitle(String fieldName, String title) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFieldTitle(fieldName, title);
    }-*/;

    /**
     * Change the title of a field after the grid is created.
     *
     * @param fieldNum name of the field, or index.
     * @param title    new title
     */
    public native void setFieldTitle(int fieldNum, String title) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFieldTitle(fieldNum, title);
    }-*/;

    /**
     * Force a field to be hidden. NOTE: If a field.showIf expression exists, it will be destroyed.
     *
     * @param fieldName the field name
     */
    public native void hideField(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideField(fieldName);
    }-*/;

    /**
     * Force a field to be hidden. NOTE: If a field.showIf expression exists, it will be destroyed.
     *
     * @param fieldName        the field name
     * @param suppressRelayout if true, don't relayout non-explicit sized fields to fit the available space
     */
    public native void hideField(String fieldName, boolean suppressRelayout) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideField(fieldName, suppressRelayout);
    }-*/;

    /**
     * Start editing a new row, after the last pre-existing record in the current set of data. This new row will be
     * saved via the "add" DataSource operation. If editing is already underway elsewhere in the grid, startEditingNew()
     * behaves just like {@link com.smartgwt.client.widgets.grid.ListGrid#startEditing()}.
     */
    public native void startEditingNew() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.startEditingNew();
    }-*/;

    /**
     * Start editing a new row, after the last pre-existing record in the current set of data. This new row will be
     * saved via the "add" DataSource operation. If editing is already underway elsewhere in the grid, startEditingNew()
     * behaves just like {@link com.smartgwt.client.widgets.grid.ListGrid#startEditing()}.
     *
     * @param defaultValues the default field values for the new record
     */
    public native void startEditingNew(Map defaultValues) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var defaultValuesJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(defaultValues);
        self.startEditingNew(defaultValuesJS);
    }-*/;

    /**
     * Start editing a new row, after the last pre-existing record in the current set of data. This new row will be
     * saved via the "add" DataSource operation. If editing is already underway elsewhere in the grid, startEditingNew()
     * behaves just like {@link com.smartgwt.client.widgets.grid.ListGrid#startEditing()}.
     *
     * @param defaultRecordValue the default field values for the new record
     */
    public native void startEditingNew(Record defaultRecordValue) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var defaultValuesJS = defaultRecordValue.@com.smartgwt.client.data.Record::getJsObj()();
        delete defaultValuesJS['__ref'];
        self.startEditingNew(defaultValuesJS);
    }-*/;

    /**
     * Given a field or field id, return it's index in the fields array
     *
     * @param fieldName the field name
     * @return index of the field within this.fields
     */
    public native int getFieldNum(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getFieldNum(fieldName);
    }-*/;

    /**
     * Given a column number or field id, return the field name of a field.
     *
     * @param fieldName field name
     * @return Name of the field.
     */
    public native String getFieldName(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getFieldName(fieldName);
    }-*/;

    /**
     * Given a column number or field id, return the field name of a field.
     *
     * @param colNum number or id of the field.
     * @return Name of the field.
     */
    public native String getFieldName(int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getFieldName(colNum);
    }-*/;

    /**
     * Given a column number or field name, return the field definition. <P> When using {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getFields fields}, the field definition may be a mix of information
     * derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getFields fields} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource}.
     *
     * @param fieldName the field name.
     * @return field definition
     */
    public native ListGridField getField(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var field = self.getField(fieldName);

        if(field == null || field === undefined) return null;
        var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);        
        return fieldJ;
    }-*/;

    /**
     * Given a column number or field name, return the field definition. <P> When using {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getFields fields}, the field definition may be a mix of information
     * derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getFields fields} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource}.
     *
     * @param colNum number or id of the field.
     * @return field definition
     */
    public native ListGridField getField(int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var field = self.getField(colNum);
        if(field == null || field === undefined) return null;
        var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
        return fieldJ;
    }-*/;

    /**
     * Get the row that currently has keyboard focus.  Arrow key navigation moves relative to this row.
     *
     * @return rowNum of the current focus row. Returns null if there is no row focused
     */
    public native Integer getFocusRow() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var row = self.getFocusRow();
        return row == null || row === undefined ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(row);
    }-*/;


    /**
     * The selection associated with the listGrid.
     *
     * @return the selection
     * @deprecated use {@link #getSelectedRecords()} instead
     */
    public native ListGridRecord[] getSelection() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var selectionJS =  self.getSelection();
        return @com.smartgwt.client.widgets.grid.ListGrid::convertToListGridRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selectionJS);
    }-*/;

    /**
     * The selection associated with the listGrid.
     *
     * @param excludePartialSelections when true, partially selected records will not be returned. Otherwise, both fully and partially selected records are returned.
     * @return the selection
     * @deprecated use {@link #getSelectedRecords(boolean)} instead
     */
    public native ListGridRecord[] getSelection(boolean excludePartialSelections) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var selectionJS =  self.getSelection(excludePartialSelections);
        return @com.smartgwt.client.widgets.grid.ListGrid::convertToListGridRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selectionJS);
    }-*/;

    /**
     * The selection associated with the listGrid.
     *
     * @return the selection
     */
    public native ListGridRecord[] getSelectedRecords() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var selectionJS =  self.getSelectedRecords();
        return @com.smartgwt.client.widgets.grid.ListGrid::convertToListGridRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selectionJS);
    }-*/;


    /**
     * The selection associated with the listGrid.
     *
     * @param excludePartialSelections when true, partially selected records will not be returned. Otherwise, both fully and partially selected records are returned.
     * @return the selection
     */
    public native ListGridRecord[] getSelectedRecords(boolean excludePartialSelections) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var selectionJS =  self.getSelectedRecords(excludePartialSelections);
        return @com.smartgwt.client.widgets.grid.ListGrid::convertToListGridRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selectionJS);
    }-*/;


    private static ListGridRecord[] convertToListGridRecordArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new ListGridRecord[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        ListGridRecord[] objects = new ListGridRecord[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            ListGridRecord obj = (ListGridRecord) RefDataClass.getRef(componentJS);
            if (obj == null) obj = new ListGridRecord(componentJS);
            objects[i] = obj;
        }
        return objects;
    }

    /**
     * Get the complete array of fields for this ListGrid, including fields that are not currently visible or were specified
     * implicitly via {@link com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource}. <P> This list of fields is
     * only valid once the ListGrid has been {@link com.smartgwt.client.widgets.Canvas#draw} or once {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setFields} has been called explicitly.  If called earlier, only the list of
     * directly specified fields will be returned (the Array passed to create()). <P> This Array should be treated as
     * <b>read-only</b>.  To modify the set of visible fields, use {@link com.smartgwt.client.widgets.grid.ListGrid#showField},
     * {@link com.smartgwt.client.widgets.grid.ListGrid#hideField} and related APIs.  To update properties of individual
     * fields, use {@link com.smartgwt.client.widgets.grid.ListGrid#setFieldProperties} or more specific APIs such as {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setFieldTitle}.
     *
     * @return Array of all fields in the ListGrid
     */
    public native ListGridField[] getAllFields() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var fieldsJS = self.getAllFields();
        return @com.smartgwt.client.widgets.grid.ListGrid::convertToListGridFieldArray(Lcom/google/gwt/core/client/JavaScriptObject;)(fieldsJS);
    }-*/;

    /**
     * The ListGrid fields
     *
     * @return the fields
     */
    public native ListGridField[] getFields() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var fieldsJS = self.getProperty('fields');
        return @com.smartgwt.client.widgets.grid.ListGrid::convertToListGridFieldArray(Lcom/google/gwt/core/client/JavaScriptObject;)(fieldsJS);
    }-*/;

    private static ListGridField[] convertToListGridFieldArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new ListGridField[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        ListGridField[] objects = new ListGridField[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            //ListGridField obj = (ListGridField) RefDataClass.getRef(componentJS);
            //if (obj == null)
            ListGridField obj = new ListGridField(componentJS);
            objects[i] = obj;
        }
        return objects;
    }

    /**
     * Returns the index of the row being edited or -1 if there is no current edit row.
     *
     * @return Index of the current edit row
     */
    public native int getEditRow() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEditRow();
        return ret == null ? -1 : ret;
    }-*/;

    /**
     * Returns the index of the column being edited or -1 if there is no edit col.
     *
     * @return Index of the current edit column
     */
    public native int getEditCol() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEditCol();
        return ret == null ? -1 : ret;
    }-*/;
    
    /**
     * Method to retrieve a live edit form item for an {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit editable}
     * ListGrid. This is the automatically generated editor displayed in a cell while editing the grid. <P> Note that this is
     * an advanced method and developers should be aware of the following issues: <ul><li>Edit form items are only present
     * while a user is actually editing a cell. This method will return null if the user is not editing the grid or the field
     * in question is not editable or not visible. Note that due to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowAllColumns incremental rendering} columns which are not currently
     * scrolled into view may be unrendered, in which case they may have no associated edit item until the user scrolls them
     * into view.</li> <li>The items' values are managed by the ListGrid through the edit-values subsystem. If you want to
     * change an edit value for a field, call {@link com.smartgwt.client.widgets.grid.ListGrid#setEditValue
     * ListGrid.setEditValue} and the grid will handle updating the value in the live item if necessary. You should not need to
     * call <code>setValue();</code> directly on the item and doing so will not always update the edit value for the grid. 
     * </li></ul> In general - bear in mind that this is an advanced usage and if there is an equivalent API available on the
     * ListGrid it is always preferable to use that.
     * @param field fieldName or colNum to get the edit item for.
     *
     * @return the live edit item for the current edit row and specified field, or null if the grid is not currently showing any
     * editors.
     */
    public native FormItem getEditFormItem(Integer field) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEditFormItem(field);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.form.fields.FormItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;
    
    /**
     * Method to retrieve a live edit form item for an {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit editable}
     * ListGrid. This is the automatically generated editor displayed in a cell while editing the grid. <P> Note that this is
     * an advanced method and developers should be aware of the following issues: <ul><li>Edit form items are only present
     * while a user is actually editing a cell. This method will return null if the user is not editing the grid or the field
     * in question is not editable or not visible. Note that due to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowAllColumns incremental rendering} columns which are not currently
     * scrolled into view may be unrendered, in which case they may have no associated edit item until the user scrolls them
     * into view.</li> <li>The items' values are managed by the ListGrid through the edit-values subsystem. If you want to
     * change an edit value for a field, call {@link com.smartgwt.client.widgets.grid.ListGrid#setEditValue
     * ListGrid.setEditValue} and the grid will handle updating the value in the live item if necessary. You should not need to
     * call <code>setValue();</code> directly on the item and doing so will not always update the edit value for the grid. 
     * </li></ul> In general - bear in mind that this is an advanced usage and if there is an equivalent API available on the
     * ListGrid it is always preferable to use that.
     * @param field fieldName or colNum to get the edit item for.
     *
     * @return the live edit item for the current edit row and specified field, or null if the grid is not currently showing any
     * editors.
     */
    public native FormItem getEditFormItem(String field) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEditFormItem(field);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.form.fields.FormItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;

    /**
     * Open the current record detail grid inline,
     *
     * @param record the record
     * @param detailDataSource the detail deta source
     * @deprecated use {@link #setCanExpandRecords(Boolean)} with {@link #setExpansionMode(com.smartgwt.client.types.ExpansionMode)}, or override {@link #getExpansionComponent(ListGridRecord)}
     */
    public native void openRecordDetailGrid(ListGridRecord record, DataSource detailDataSource)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.widgets.grid.ListGridRecord::getJsObj()();
        var datasourceJS = detailDataSource.@com.smartgwt.client.data.DataSource::getOrCreateJsObj()();
        self.openRecordDetailGrid(recordJS, datasourceJS);
     }-*/;

    /**
     * Close the inline detail grid assoicated with the record.
     *
     * @param record the record
     * @deprecated use {@link #setCanExpandRecords(Boolean)} with {@link #setExpansionMode(com.smartgwt.client.types.ExpansionMode)}, or override {@link #getExpansionComponent(ListGridRecord)}
     */
    public native void closeRecord(ListGridRecord record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.widgets.grid.ListGridRecord::getJsObj()();
        self.closeRecord(recordJS);
     }-*/;

    /**
     * Open the record editor associated with the record.
     *
     * @param record the record
     * @deprecated use {@link #setCanExpandRecords(Boolean)} with {@link #setExpansionMode(com.smartgwt.client.types.ExpansionMode)}, or override {@link #getExpansionComponent(ListGridRecord)}
     */
    public native void openRecordEditor(ListGridRecord record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.widgets.grid.ListGridRecord::getJsObj()();
        self.openRecordEditor(recordJS);
     }-*/;

    /**
     * Perform a DataSource "add" operation to add new records to this component's DataSource.
     *
     * @param record new record
     */
    public native void addData(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.addData(recordJS);
    }-*/;

    /**
     * Perform a DataSource "add" operation to add new records to this component's DataSource.
     *
     * @param record new record
     * @param callback  method to call on operation completion
     */
    public native void addData(Record record, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.addData(recordJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    /**
     * Perform a DataSource "add" operation to add new records to this component's DataSource.
     *
     * @param record         new record
     * @param callback          method to call on operation completion
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void addData(Record record, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.addData(recordJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    /**
     * Perform a DataSource "update" operation to update existing records in this component's DataSource.
     *
     * @param record updated record
     */
    public native void updateData(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.updateData(recordJS);
    }-*/;

    /**
     * Perform a DataSource "update" operation to update existing records in this component's DataSource.
     *
     * @param record updated record
     * @param callback      method to call on operation completion
     */
    public native void updateData(Record record, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.updateData(recordJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    /**
     * Perform a DataSource "update" operation to update existing records in this component's DataSource.
     *
     * @param record     updated record
     * @param callback          method to call on operation completion
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void updateData(Record record, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.updateData(recordJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    /**
     * Perform a DataSource "remove" operation to remove records from this component's DataSource.
     *
     * @param record primary key values of record to delete,                                           (or complete
     *             record)
     */
    public native void removeData(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.removeData(recordJS);
    }-*/;

    /**
     * Perform a DataSource "remove" operation to remove records from this component's DataSource.
     *
     * @param record     primary key values of record to delete,                                           (or complete
     *                 record)
     * @param callback method to call on operation completion
     */
    public native void removeData(Record record, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.removeData(recordJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    /**
     * Perform a DataSource "remove" operation to remove records from this component's DataSource.
     *
     * @param record              primary key values of record to delete,                                           (or
     *                          complete record)
     * @param callback          method to call on operation completion
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void removeData(Record record, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();       
        self.removeData(recordJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    /**
     * Remove the currently selected records from this component. If this is a databound grid, the records will be
     * removed directly from the DataSource. <P> If no records are selected, no action is taken. The grid will
     * automatically be updated if the record deletion succeeds.
     */
    public native void removeSelectedData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeSelectedData();
    }-*/;

    /**
     * Remove the currently selected records from this component. If this is a databound grid, the records will be
     * removed directly from the DataSource. <P> If no records are selected, no action is taken. The grid will
     * automatically be updated if the record deletion succeeds.
     *
     * @param callback          callback to fire when the data has been removed
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void removeSelectedData(DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.removeSelectedData($entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    /**
     * Display the current set of records grouped by their values for the given field or fields. With no arguments,
     * disables all grouping. <P> Grouping tranforms the current dataset into a Tree on the fly, then provides a
     * familiar tree interface for exploring the grouped data. <P> Grouping works automatically with any dataset,
     * providing simple default grouping based on each field's declared type.  However, you can use the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGroupValue} API to control how records are grouped, and the
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupTitle} API to control how groups are titled. <P>
     * Grouping can be performed programmatically via this API, or you can set {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy canGroupBy} to enable menus that allow the user to
     * performing grouping. To group a grid automatically, instantiate the grid with a  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGroupByField groupByField} setting. <P> While grouped, the
     * automatically created Tree is available as {@link com.smartgwt.client.widgets.grid.ListGrid#getGroupTree
     * groupTree} and the original dataset is availabe as {@link com.smartgwt.client.widgets.grid.ListGrid#getOriginalData
     * originalData}.
     */
    public native void groupBy(String... fields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        fieldsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(fields);
        self.groupBy(fieldsJS);
    }-*/;

    /**
     * Clear the current criteria used to filter data.
     */
    public native void clearCriteria() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearCriteria();
    }-*/;

    /**
     * Clear the current criteria used to filter data.
     *
     * @param callback          callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void clearCriteria(DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.clearCriteria($entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    /**
     * Check whether a field is currently visible
     *
     * @param fieldName field to be checked
     * @return true if the field is currently visible, false otherwise
     */
    public native boolean fieldIsVisible(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.fieldIsVisible(fieldName);
    }-*/;

    /**
     * Sort the the data  by the first sortable column.
     * <P>&#010 Updates the sortFieldNum and sortDirection to reflect the new sort order of the grid.&#010&#010
     *
     * @return sorting worked
     */
    public native Boolean sort() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.sort();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Sorts a listGrid explicitly by the column given by sortFieldNum, if provided, in &#010 ascending or descending order if specified by sortDirection. If sortFieldNum is not&#010 provided and listGrid.sortFieldNum is undefined, the data will be sorted by the first&#010 sortable column according to {@link com.smartgwt.client.widgets.grid.ListGridField#getSortDirection sortDirection} if specified, or&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getSortDirection sortDirection}.&#010 <P>&#010 Updates the sortFieldNum and sortDirection to reflect the new sort order of the grid.&#010&#010
     *
     * @param sortField     the field name to sort by
     * @param sortDirection the direction to sort in
     * @return sorting worked
     */
    public native Boolean sort(String sortField, SortDirection sortDirection) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.sort(sortField, sortDirection.@com.smartgwt.client.types.SortDirection::getValue()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Sorts a listGrid explicitly by the column given by sortFieldNum, if provided, in &#010 ascending or descending order if specified by sortDirection. If sortFieldNum is not&#010 provided and listGrid.sortFieldNum is undefined, the data will be sorted by the first&#010 sortable column according to {@link com.smartgwt.client.widgets.grid.ListGridField#getSortDirection sortDirection} if specified, or&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getSortDirection sortDirection}.&#010 <P>&#010 Updates the sortFieldNum and sortDirection to reflect the new sort order of the grid.&#010&#010
     *
     * @param sortCol the column number to sort by
     * @param sortDirection the direction to sort in
     * @return sorting worked
     */
    public native Boolean sort(int sortCol, SortDirection sortDirection) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.sort(sortCol, sortDirection.@com.smartgwt.client.types.SortDirection::getValue()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Save a number of outstanding edits for this ListGrid. If no rows are specified, all 
     * outstanding edits will be saved.
     *
     * @return true if a save has been initiated (at least one row had changes, passed client-side validation, 
     *  and a save has been attempted).  false otherwise
     */
    public native boolean saveAllEdits() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.saveAllEdits();
    }-*/;

    /**
     * Save a number of outstanding edits for this ListGrid. If no rows are specified, all 
     * outstanding edits will be saved.
     *
     * 
     * @param callback this callback will be fired on a successful save. Note that if there are no pending edits to be saved this
     * callback will not fire - you can check for this condition using {@link #hasChanges()} or {@link #rowHasChanges()}.
     * Use {@link #addEditFailedHandler(EditFailedHandler)} to find out about failures encountered during saving (on a per-row basis).
     * @return true if a save has been initiated (at least one row had changes, passed client-side validation, and a save has been attempted).  false otherwise
     */
    public native boolean saveAllEdits(Function callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.saveAllEdits(null, callback == null ? null : $entry(function() {
            callback.@com.smartgwt.client.core.Function::execute()();
        }));
    }-*/;

    /**
     * Save a number of outstanding edits for this ListGrid. If no rows are specified, all 
     * outstanding edits will be saved.
     *
     * @param callback this callback will be fired on a successful save of the specified rows. Note that if there are no pending edits to be saved this
     * callback will not fire - you can check for this condition using {@link #hasChanges()} or {@link #rowHasChanges()}.
     * Use {@link #addEditFailedHandler(EditFailedHandler)} to find out about failures encountered during saving (on a per-row basis).
     * @param rows specify which rows to save
     * @return true if a save has been initiated (at least one row had changes, passed client-side validation, and a save has been attempted).  false otherwise
     */
    public native boolean saveAllEdits(Function callback, int[] rows) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var rowsJS = rows == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(rows);
        return self.saveAllEdits(rowsJS, callback == null ? null : $entry(function() {
            callback.@com.smartgwt.client.core.Function::execute()();
        }));
    }-*/;

    /**
     * Cancel outstanding edits, discarding edit values, and hiding editors for the records.
     */
    public native void discardAllEdits() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.discardAllEdits();
    }-*/;

    /**
     * Cancel outstanding edits, discarding edit values, and hiding editors for the record[s] passed in if appropriate.
     * If no rows are passed in all outstanding edit values will be dropped.
     *
     * @param rows which row(s) to drop edits for
     * @param dontHideEditor By default this method will hide the editor if it is currently showing for any row in the grid.
     * Passing true for this parameter will leave the editor visible (and just reset the edit values underneath the editor)
     */
    public native void discardAllEdits(int[] rows, boolean dontHideEditor) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var rowsJS = rows == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(rows);
        self.discardAllEdits(rowsJS, dontHideEditor);
    }-*/;

    /**
     * Freeze the indicated field, so that it remains in place and visible when horizontal scrolling occurs.
     *
     * @param fieldName the field name
     */
    public native void freezeField(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.freezeField(fieldName);
    }-*/;

    /**
     * Freeze the indicated field, so that it remains in place and visible when horizontal scrolling occurs.
     *
     * @param colNum the column num
     */
    public native void freezeField(int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.freezeField(colNum);
    }-*/;

    /**
     * Freeze the indicated fields, so that they remains in place and visible when horizontal scrolling occurs.
     *
     * @param array of colNums to freeze
     */
    public native void freezeFields(int[] colNums) /*-{
        if (colNums == null) return;
        var jsColNums = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(colNums);
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.freezeField(jsColNums);
    }-*/;
    
    /**
     * Freeze the indicated fields, so that they remains in place and visible when horizontal scrolling occurs.
     *
     * @param array of fieldNames to freeze
     */
    public native void freezeFields(String[] fieldNames) /*-{
        if (fieldNames == null) return;
        var jsFieldNames = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(fieldNames);
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.freezeField(jsFieldNames);
    }-*/;

    /**
     * Unfreeze a frozen field, so that it will now scroll along with other fields when horizontal scrolling occurs.
     *
     * @param fieldName the field name
     */
    public native void unfreezeField(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.unfreezeField(fieldName);
    }-*/;

    /**
     * Unfreeze a frozen field, so that it will now scroll along with other fields when horizontal scrolling occurs.
     *
     * @param colNum the column num
     */
    public native void unfreezeField(int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.unfreezeField(colNum);
    }-*/;

    /**
     * Unfreeze the indicated fields, so that it will now scroll along with other fields when horizontal scrolling occurs.
     * 
     * @param array of colNums to unfreeze
     */
    public native void unfreezeFields(int[] colNums) /*-{
        if (colNums == null) return;
        var jsColNums = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(colNums);
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.unfreezeField(jsColNums);
    }-*/;

    /**
     * Unfreeze the indicated fields, so that it will now scroll along with other fields when horizontal scrolling occurs.
     * 
     * @param array of field names to unfreeze
     */
    public native void unfreezeFields(String[] fieldNames) /*-{
        if (fieldNames == null) return;
        var jsFieldNames = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(fieldNames);
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.unfreezeField(jsFieldNames);
    }-*/;


    /**
     * Refresh an individual cell without redrawing the grid. <P> The cell's value, CSS class, and CSS text will be
     * refreshed, to the current values returned by getCellValue(), getCellStyle() and getCellCSSText() respectively.
     *
     * @param rowNum row number of cell to refresh
     * @param colNum column number of cell to refresh
         */
    public native void refreshCell(int rowNum, int colNum, boolean refreshingRow, boolean allowEditCellRefresh) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.refreshCell(rowNum, colNum, refreshingRow, allowEditCellRefresh);
    }-*/;

    /**
     * Get the rows that are currently visible in the viewport, as an array of  [firstRowNum, lastRowNum]. If the grid contains no records, will return [-1,-1];
     *
     * @return the visible rows
     */
    public native Integer[] getVisibleRows() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getVisibleRows();
        return @com.smartgwt.client.util.JSOHelper::convertToJavaInterArray(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
    
    /**
     * Returns the extents of the rows and columns current visible in this grid's viewport.
     *
     * @return The row/col co-ordinates currently visible in the viewport as an array of Integers: [startRow, endRow, startCol, endCol].
     */
    public native Integer[] getDrawArea() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawArea();
        return @com.smartgwt.client.util.JSOHelper::convertToJavaInterArray(Lcom/google/gwt/core/client/JavaScriptObject;)(ret); 
    }-*/;

    /**
     * Get the rows that are currently drawn (exist in the DOM), as an array of [firstRowNum, lastRowNum].   <P> The drawn rows differ from the {@link com.smartgwt.client.widgets.grid.ListGrid#getVisibleRows} because of {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio}.  The drawn rows are the apppropriate range to consider if you need to, eg, using {@link com.smartgwt.client.widgets.grid.ListGrid#refreshCell} to update all the cells in a column. <P> If the grid is undrawn or the {@link com.smartgwt.client.widgets.grid.ListGrid#getEmptyMessage emptyMessage} is currently shown, returns [null,null];
     *
     * @return the drawn rows
     */
    public native Integer[] getDrawnRows() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawnRows();
        return @com.smartgwt.client.util.JSOHelper::convertToJavaInterArray(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Based on the relationship between the DataSource this component is bound to and the DataSource specified as the
     * "schema" argument, call fetchData() to retrieve records in this grid that are related to the passed-in record.
     * <p/>
     * Relationships between DataSources are declared via DataSourceField.foreignKey.
     * <p/>
     * For example, given a DataSource "orders" and another DataSource "orderItems", where "orderItems" declared a field
     * "orderId" pointing to the primary key field of the "orders" DataSource", there is a set of records from the
     * "orderItems" DataSource related to any given record from the "order" DataSource. If this component were bound to
     * "orderItems" and a record from the "orders".
     *
     * @param record     the DataSource record
     * @param dataSource the schema of the DataSource record
     */
    public native void fetchRelatedData(Record record, DataSource dataSource) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var datasourceJS = dataSource.@com.smartgwt.client.data.DataSource::getOrCreateJsObj()();
        self.fetchRelatedData(recordJS, datasourceJS);
    }-*/;

    /**
     * Based on the relationship between the DataSource this component is bound to and the DataSource specified as the
     * "schema" argument, call fetchData() to retrieve records in this grid that are related to the passed-in record.
     * <p/>
     * Relationships between DataSources are declared via DataSourceField.foreignKey.
     * <p/>
     * For example, given a DataSource "orders" and another DataSource "orderItems", where "orderItems" declared a field
     * "orderId" pointing to the primary key field of the "orders" DataSource", there is a set of records from the
     * "orderItems" DataSource related to any given record from the "order" DataSource. If this component were bound to
     * "orderItems" and a record from the "orders".
     *
     * @param record            the DataSource record
     * @param dataSource        the schema of the DataSource record
     * @param callback          callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest that will be issued
     */
    public native void fetchRelatedData(Record record, DataSource dataSource, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var datasourceJS = dataSource.@com.smartgwt.client.data.DataSource::getOrCreateJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();

        self.fetchRelatedData(recordJS, datasourceJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);

    }-*/;

    /**
     * Return the underlying GridRenderer. Note that this method should only be called after the ListGrid has been drawn. Calling it prior
     * to it being rendered will return a null value. If you need to attach listeners to the GridRenderer at ListGrid configuration time,
     * then add a {@link #addDrawHandler(com.smartgwt.client.widgets.events.DrawHandler)} for the ListGrid and access the GridRenderer
     * from within the callback.
     *
     * @return the grid renderer
     */
    public native GridRenderer getGridRenderer() /*-{
        if(this.@com.smartgwt.client.widgets.BaseWidget::isDrawn()()) {
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return @com.smartgwt.client.widgets.grid.GridRenderer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(self.body);
        } else {
            return null;
        }
    }-*/;

    /**
     * Returns the current value of a cell. If the cell has an outstanding edit value,
     * this will be returned, otherwise the underlying value of the record will be returned.
     *
     * @param rowNum the row number
     * @param fieldName the field name
     *
     *
     * @return the edited cell value
     */
    public native Object getEditedCell(int rowNum, String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getEditedCell(rowNum, fieldName);
        var valueJ = $wnd.SmartGWT.convertToJavaType(value);
        return valueJ;
    }-*/;

    /**
     * Returns the current value of a cell. If the cell has an outstanding edit value,
     * this will be returned, otherwise the underlying value of the record will be returned.
     *
     * @param rowNum the row number
     * @param colNum the column number
     *
     *
     * @return the edited cell value
     */
    public native Object getEditedCell(int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getEditedCell(rowNum, colNum);
        var valueJ = $wnd.SmartGWT.convertToJavaType(value);
        return valueJ;
    }-*/;

    /**
     * Returns the current value of a cell. If the cell has an outstanding edit value,
     * this will be returned, otherwise the underlying value of the record will be returned.
     *
     * @param record an Object containing values for all the record's primary keys
     * @param fieldName the field name
     *
     *
     * @return the edited cell value
     */
    public native Object getEditedCell(Record record, String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var value = self.getEditedCell(recordJS, fieldName);
        var valueJ = $wnd.SmartGWT.convertToJavaType(value);
        return valueJ;
    }-*/;

    /**
     * Returns the current value of a cell. If the cell has an outstanding edit value,
     * this will be returned, otherwise the underlying value of the record will be returned.
     *
     * @param record an Object containing values for all the record's primary keys
     * @param colNum the column number
     *
     *
     * @return the edited cell value
     */
    public native Object getEditedCell(Record record, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var value = self.getEditedCell(recordJS, colNum);
        var valueJ = $wnd.SmartGWT.convertToJavaType(value);
        return valueJ;
    }-*/;

    /**
     * Returns the combination of unsaved edits (if any) and original values (if any) for a given row being edited.
     * <p>
     *
     * The returned value is never null, and can be freely modified.
     *
     * @param rowNum the row num
     * @return A copy of the record with unsaved edits included
     */
    public native Record getEditedRecord(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var record = self.getEditedRecord(rowNum);
        if(record == null || record === undefined) return null;
        var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
        return recordJ;
    }-*/;

    /**
     * Returns the current temporary locally stored edit value for some field within a record being edited.
     * 
     * @param rowNum index of the row for which the editValue should be returned
     * @param colNum index of the field for which value should be returned
     * 
     * @return   edit value for the field in question
     */
    public native Object getEditValue(int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getEditValue(rowNum, colNum);
        var valueJ = $wnd.SmartGWT.convertToJavaType(value);
        return valueJ;
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     * 
     * @param rowNum row number
     * @param colNum column number of cell
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, int colNum, String value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, colNum, value);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param colNum column number of cell
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, int colNum, Date value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(value);
        self.setEditValue(rowNum, colNum, valueJS);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param colNum column number of cell
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, int colNum, double value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, colNum, value);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param colNum column number of cell
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, int colNum, boolean value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, colNum, value);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param colNum column number of cell
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, int colNum, float value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, colNum, value);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param colNum column number of cell
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, int colNum, int value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, colNum, value);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param colNum column number of cell
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, int colNum, Record value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, colNum, value == null ? null : value.@com.smartgwt.client.data.Record::getJsObj()());
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param colNum column number of cell
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, int colNum, Record[] value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, colNum, value == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(value));
    }-*/;
    
    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param fieldName  the field name
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, int colNum, JavaScriptObject value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, colNum, value);
    }-*/;


    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param fieldName the field name
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, String fieldName, String value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, fieldName, value);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param fieldName the field name
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, String fieldName, Date value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(value);
        self.setEditValue(rowNum, fieldName, valueJS);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param fieldName the field name
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, String fieldName, double value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, fieldName, value);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param fieldName the field name
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, String fieldName, boolean value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, fieldName, value);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param fieldName the field name
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, String fieldName, float value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, fieldName, value);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param fieldName the field name
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, String fieldName, int value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, fieldName, value);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param fieldName  the field name
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, String fieldName, Record value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, fieldName, value == null ? null : value.@com.smartgwt.client.data.Record::getJsObj()());
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param fieldName  the field name
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, String fieldName, Record[] value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, fieldName, value == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(value));
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param fieldName  the field name
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, String fieldName, JavaScriptObject value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, fieldName, value);
    }-*/;

    /**
     * This method sets up a set of editValues for some row / cell. It differs from setEditValue in that:
     * <ul>
     * <li>it takes values for multiple fields</li>
     * <li>it clears out any previous edit values for the record</li>
     * </ul>
     * 
     * @param rowNum the row num for the record being edited
     * @param values new values for the row
     */
    public native void setEditValues(int rowNum, Map values) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valuesJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(values);
        self.setEditValues(rowNum, valuesJS);
    }-*/;
    
    /**
     * Returns the current temporary locally stored edit value for some field within a record being edited.
     *
     * @param rowNum index of the row for which the editValue should be returned
     * @param fieldName field name for which value should be returned
     *
     * @return   edit value for the field in question
     */
    public native Object getEditValue(int rowNum, String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getEditValue(rowNum, fieldName);
        var valueJ = $wnd.SmartGWT.convertToJavaType(value);
        return valueJ;
    }-*/;
    
    private native JavaScriptObject getEditValueAsJSObj(int rowNum, String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getEditValue(rowNum, fieldName);
        return value;
    }-*/;

    /**
     * Returns the current temporary locally stored edit value for some field within a record being edited.
     *
     * @param rowNum index of the row for which the editValue should be returned
     * @param fieldName field name for which value should be returned
     *
     * @return   edit value for the field in question
     */
    public String getEditValueAsString(int rowNum, String fieldName) {
        return (String)getEditValue(rowNum, fieldName);
    }

    /**
     * Returns the current temporary locally stored edit value for some field within a record being edited.
     *
     * @param rowNum index of the row for which the editValue should be returned
     * @param fieldName field name for which value should be returned
     *
     * @return   edit value for the field in question
     */
    public Integer getEditValueAsInt(int rowNum, String fieldName) {
        return (Integer)getEditValue(rowNum, fieldName);
    }

    /**
     * Returns the current temporary locally stored edit value for some field within a record being edited.
     *
     * @param rowNum index of the row for which the editValue should be returned
     * @param fieldName field name for which value should be returned
     *
     * @return   edit value for the field in question
     */
    public Float getEditValueAsFloat(int rowNum, String fieldName) {
        return (Float) getEditValue(rowNum, fieldName);
    }

    /**
     * Returns the current temporary locally stored edit value for some field within a record being edited.
     *
     * @param rowNum index of the row for which the editValue should be returned
     * @param fieldName field name for which value should be returned
     *
     * @return   edit value for the field in question
     */
    public Date getEditValueAsDate(int rowNum, String fieldName) {
        return (Date) getEditValue(rowNum, fieldName);
    }

    /**
     * Returns the current temporary locally stored edit value for some field within a record being edited.
     *
     * @param rowNum index of the row for which the editValue should be returned
     * @param fieldName field name for which value should be returned
     *
     * @return   edit value for the field in question
     */
    public Boolean getEditValueAsBoolean(int rowNum, String fieldName) {
        return (Boolean) getEditValue(rowNum, fieldName);
    }

    /**
     * Returns the current temporary locally stored edit value for some field within a record being edited.
     *
     * @param rowNum index of the row for which the editValue should be returned
     * @param fieldName field name for which value should be returned
     *
     * @return   edit value for the field in question
     */
    public Record getEditValueAsRecord(int rowNum, String fieldName) {
        JavaScriptObject val = getEditValueAsJSObj(rowNum, fieldName);
        if (val == null) return null;
        return Record.getOrCreateRef(val);
    }

    /**
     * Returns the current temporary locally stored edit value for some field within a record being edited.
     *
     * @param rowNum index of the row for which the editValue should be returned
     * @param fieldName field name for which value should be returned
     *
     * @return   edit value for the field in question
     */
    public Record[] getEditValueAsRecordArray(int rowNum, String fieldName) {
        JavaScriptObject val = getEditValueAsJSObj(rowNum, fieldName);
        if (val == null) return null;
        return Record.convertToRecordArray(val);
    }

    /**
     * Returns the current set of unsaved edits for a given row being edited.
     * 
     * @param rowNum rowNum of the record being edited
     * @return current editValues object for the row. This contains the current edit values in {fieldName1:value1, fieldName2:value2} format
     */
    public native Map getEditValues(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getEditValues(rowNum);
        var valueJ = @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
        return valueJ;
    }-*/;

    /**
     * Returns the current set of unsaved edits for a given row being edited.
     *
     * @param record an Object containing values for all the record's primary keys
     * @return current editValues object for the row. This contains the current edit values in {fieldName1:value1, fieldName2:value2} format
     */
    public native Map getEditValues(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var value = self.getEditValues(recordJS);
        var valueJ = @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
        return valueJ;
    }-*/;


    /**
     * Set the validation errors for some row (replacing any pre-existant validation errors)
     *
     * 
     * @param rowNum row to add validation error for
     * @param errors validation errors for the row. The key of the map must be the field name, and the value can either be a String error message
     * or an array of Strings for multiple errors
     */
    public native void setRowErrors(int rowNum, Map errors) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var errorsJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(errors);
        self.setRowErrors(rowNum, errorsJS);
    }-*/;

    /**
     * Set a validation error for some cell.
     * 
     * @param rowNum row index of cell to add validation error for
     * @param fieldName field name of cell to add validation error for
     * @param errorMessage validation error message
     */
    public native void setFieldError(int rowNum, String fieldName, String errorMessage) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFieldError(rowNum, fieldName, errorMessage);
    }-*/;

    /**
     * Set a validation error for some cell.
     *
     * @param rowNum row index of cell to add validation error for
     * @param fieldName field name of cell to add validation error for
     * @param errorMessages validation error messages
     */
    public native void setFieldError(int rowNum, String fieldName, String[] errorMessages) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var errorsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(errorMessages);
        self.setFieldError(rowNum, fieldName, errorsJS);
    }-*/;

    /**
     * Select a single {@link com.smartgwt.client.data.Record} passed in explicitly, or by index, and deselect everything else. When programmatic selection of records is a requirement and {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionType selectionType}  is "single", use this method rather than {@link com.smartgwt.client.widgets.grid.ListGrid#selectRecord} to  enforce mutually-exclusive record-selection.
     * @param record record to select
     */
    public native void selectSingleRecord(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectSingleRecord(record.@com.smartgwt.client.data.Record::getJsObj()());
    }-*/;

    /**
     * Select a single {@link com.smartgwt.client.data.Record} passed in explicitly, or by index, and deselect everything else. When programmatic selection of records is a requirement and {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionType selectionType}  is "single", use this method rather than {@link com.smartgwt.client.widgets.grid.ListGrid#selectRecord} to  enforce mutually-exclusive record-selection.
     * @param rowNum rowNum (or row number) to select
     */
    public native void selectSingleRecord(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectSingleRecord(rowNum);
    }-*/;

    /**
     * Get the computed value of a {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAddFormulaFields canAddFormulaFields}.
     *
     * @param field  field that has a formula
     * @param record record to use to compute formula value
     * @return formula result
     */
    public native int getFormulaFieldValue(ListGridField field, Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getFormulaFieldValue(field.@com.smartgwt.client.widgets.grid.ListGridField::getJsObj()(), record);
    }-*/;

    /**
     * Get the computed value of a {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAddSummaryFields canAddSummaryFields}.
     *
     * @param field  field that has a summary format
     * @param record record to use to compute formula value
     * @return formula result
     */
    public native int getSummaryFieldValue(ListGridField field, Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getSummaryFieldValue(field.@com.smartgwt.client.widgets.grid.ListGridField::getJsObj()(), record);
    }-*/;


    /**
     * Returns any currently stored validation errors for this row
     *
     * @param rowNum the index of row to check for validation errors
     * @return map of validation errors.  If no validation errors stored for the row, null is returned
     */
    public native Map getRowErrors(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var errorsJS =  self.getRowErrors(rowNum);
        return errorsJS == null ? null : @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(errorsJS);
    }-*/;

    /**
     * Returns the current set of errors for this cell.
     *
     * @param rowNum the index of row to check for validation errors
     * @param fieldName field to check for validation errors
     *
     * @return array of error messages (strings) for the specified cell. If no validation errors are present, returns null.
     */
    public native String[] getCellErrors(int rowNum, String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var errorsJS =  self.getCellErrors(rowNum, fieldName);
        return errorsJS == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(errorsJS);
    }-*/;

    /**
    * Sorting direction of this ListGrid. If specified when the ListGrid is initialized, this property will be the default sorting direction for the {@link com.smartgwt.client.widgets.grid.ListGrid#getSortField sortField}. May be overridden by specifying {@link com.smartgwt.client.widgets.grid.ListGridField#getSortDirection sortDirection}. <P> After initialization, this property will be updated on {@link com.smartgwt.client.widgets.grid.ListGrid#sort} to reflect the current sort direction of the grid.
    *
    * @param sortDirection sortDirection Default value is SortDirection.ASCENDING
    */
    public void setSortDirection(SortDirection sortDirection) {
        if(sortDirection == null) {
            setAttribute("sortDirection", (Boolean)null, true);
        } else {
            setAttribute("sortDirection", sortDirection == SortDirection.ASCENDING, true);
        }
    }
    
    /**
     * Sorting direction of this ListGrid. If specified when the ListGrid is initialized, this property will be the default sorting direction for the {@link com.smartgwt.client.widgets.grid.ListGrid#getSortField sortField}. May be overridden by specifying {@link com.smartgwt.client.widgets.grid.ListGridField#getSortDirection sortDirection}. <P> After initialization, this property will be updated on {@link com.smartgwt.client.widgets.grid.ListGrid#sort} to reflect the current sort direction of the grid.
     *
     * @return sort direction Default value is SortDirection.ASCENDING
     */
    public SortDirection getSortDirection()  {
        Boolean sortDir = getAttributeAsBoolean("sortDirection");
        if(sortDir == null) return null;
        return sortDir ? SortDirection.ASCENDING : SortDirection.DESCENDING;
    }

    /**
     * Sets this component's filter criteria. Default implementation calls this.data.setCriteria()
     * @param  criteria new criteria to show
     */
    public native void setCriteria(Criteria criteria) /*-{
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
                self.setCriteria(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.initialCriteria = (criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
        }
    }-*/;

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor} is true, this method will update the criteria shown in the <code>filterEditor</code> without performing a filter.
     * @param criteria New criteria to show
     */
    public native void setFilterEditorCriteria(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFilterEditorCriteria(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor} is true, this method will return the criteria currently displayed in the <code>filterEditor</code>. Note that these values may differ from the criteria returned by {@link com.smartgwt.client.widgets.grid.ListGrid#getCriteria} if the filter editor values have been modified without performing an actual filter.
     *
     * @return criteria currently displayed in the filterEditor
     */
    public native Criteria getFilterEditorCriteria() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFilterEditorCriteria();
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.data.Criteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor} is true, this method will return the criteria currently displayed in the <code>filterEditor</code>. Note that these values may differ from the criteria returned by {@link com.smartgwt.client.widgets.grid.ListGrid#getCriteria} if the filter editor values have been modified without performing an actual filter.
     *
     * @param omitHiddenFields  By default this method will include criteria applied to fields, including 
     *              criteria that are not actually visible/editable in the filterEditor for the grid.
     *              Pass in this parameter to get only values for visible fields returned.
     * @return criteria currently displayed in the filterEditor
     */
    public native Criteria getFilterEditorCriteria(boolean omitHiddenFields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFilterEditorCriteria(omitHiddenFields);
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.data.Criteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    
    /**
     * Validate the current edit value for the cell in question.  Called when the user moves to a&#010 new edit cell if {@link com.smartgwt.client.widgets.grid.ListGrid#getValidateByCell validateByCell} is true.<br>&#010 This method may also be called directly to perform cell level validation at any time.&#010
     *
     * @param rowNum    index of row to be validated.
     * @param fieldName field name of field to be validated
     * @return returns true if validation was successful (no errors encountered), false  otherwise.
     */
    public native Boolean validateCell(int rowNum, String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.validateCell(rowNum, fieldName);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Validate the current edit value for the cell in question.  Called when the user moves to a&#010 new edit cell if {@link com.smartgwt.client.widgets.grid.ListGrid#getValidateByCell validateByCell} is true.<br>&#010 This method may also be called directly to perform cell level validation at any time.&#010
     *
     * @param rowNum    index of row to be validated.
     * @param colIndex column index of field to be validated
     * @return returns true if validation was successful (no errors encountered), false otherwise.
     */
    public native Boolean validateCell(int rowNum, int colIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.validateCell(rowNum, colIndex);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Given a rowNum and a colNum or fieldName, determine whether we currently have stored &#010 validation errors for the record/field in question.&#010
     *
     * @param rowNum  index of row to check for validation errors
     * @param fieldName name of field to check for validation                                       errors
     * @return true if we have validation errors for the row/col in question
     */
    public native Boolean cellHasErrors(int rowNum, String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.cellHasErrors(rowNum, fieldName);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Given a rowNum and a colNum or fieldName, determine whether we currently have stored &#010 validation errors for the record/field in question.&#010
     *
     * @param rowNum  index of row to check for validation errors
     * @param colIndex index of column to check for validation                                       errors
     * @return true if we have validation errors for the row/col in question
     */
    public native Boolean cellHasErrors(int rowNum, int colIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.cellHasErrors(rowNum, colIndex);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;


    /**
     * Clears any validation errors for some cell.&#010
     *
     * @param rowNum    row index of cell to add validation error for
     * @param fieldName field name of cell to add validation error for
     */
    public native void clearFieldError(int rowNum, String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearFieldError(rowNum, fieldName);
    }-*/;

    /**
     * Clears any validation errors for some cell.&#010
     *
     * @param rowNum    row index of cell to add validation error for
     * @param colIndex col index of cell to add validation error for
     */
    public native void clearFieldError(int rowNum, int colIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearFieldError(rowNum, colIndex);
    }-*/;

    /**
     * Set the value map for a field.&#010 See also the {@link com.smartgwt.client.widgets.grid.ListGrid#setEditorValueMap}&#010 and {@link com.smartgwt.client.widgets.grid.ListGrid#getEditorValueMap} methods which allow further &#010 customization of the valueMap displayed while the field is in edit mode.&#010&#010
     *
     * @param fieldName Name  of field to update
     * @param valueMap ValueMap for the field
     */
    public native void setValueMap(String fieldName, java.util.LinkedHashMap valueMap) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setValueMap(fieldName, @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(valueMap));
    }-*/;

    /**
     * Set the value map for a field.&#010 See also the {@link com.smartgwt.client.widgets.grid.ListGrid#setEditorValueMap}&#010 and {@link com.smartgwt.client.widgets.grid.ListGrid#getEditorValueMap} methods which allow further &#010 customization of the valueMap displayed while the field is in edit mode.&#010&#010
     *
     * @param fieldName Name  of field to update
     * @param valueMap ValueMap for the field
     */
    public native void setValueMap(String fieldName, String... valueMap) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setValueMap(fieldName, @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(valueMap));
    }-*/;
    

    /**
     * Set a valueMap to display for this field while editing.<br>
     * This method sets the +link{ListGridField.editorValueMap, field.editorValueMap} property and may be called
     * at runtime while editing the grid.
     * 
     * @param fieldName Name  of field to update
     * @param valueMap ValueMap for the field
     */
    public native void setEditorValueMap(String fieldName, java.util.LinkedHashMap valueMap) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditorValueMap(fieldName, @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(valueMap));
    }-*/;

    /**
     * Set a valueMap to display for this field while editing.<br>
     * This method sets the +link{ListGridField.editorValueMap, field.editorValueMap} property and may be called
     * at runtime while editing the grid.
     *
     * @param fieldName Name  of field to update
     * @param valueMap ValueMap for the field
     */
    public native void setEditorValueMap(String fieldName, String... valueMap) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditorValueMap(fieldName, @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(valueMap));
    }-*/;
    
    
    /**
     * Given a field with a specified {@link com.smargwt.client.widgets.grid.ListGridField#setValueMap(),valueMap}
     * or {@link com.smartgwt.client.widgets.grid.ListGridField#setDisplayField(),displayField},
     * this method will return the display value for any underlying data value.
     * @param fieldName Name of the field for which the displayValue is required
     * @param value data value for the field
     */
    public native Object getDisplayValue(String fieldName, int value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = self.getDisplayValue(fieldName, value);
        var valueJ = $wnd.SmartGWT.convertToJavaType(valueJS);
        return valueJ;
    }-*/;
    
    /**
     * Given a field with a specified {@link com.smargwt.client.widgets.grid.ListGridField#setValueMap(),valueMap}
     * or {@link com.smartgwt.client.widgets.grid.ListGridField#setDisplayField(),displayField},
     * this method will return the display value for any underlying data value.
     * @param fieldName Name of the field for which the displayValue is required
     * @param value data value for the field
     */    
    public native Object getDisplayValue(String fieldName, float value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = self.getDisplayValue(fieldName, value);
        var valueJ = $wnd.SmartGWT.convertToJavaType(valueJS);
        return valueJ;
    }-*/;
    
    /**
     * Given a field with a specified {@link com.smargwt.client.widgets.grid.ListGridField#setValueMap(),valueMap}
     * or {@link com.smartgwt.client.widgets.grid.ListGridField#setDisplayField(),displayField},
     * this method will return the display value for any underlying data value.
     * @param fieldName Name of the field for which the displayValue is required
     * @param value data value for the field
     */
    public native Object getDisplayValue(String fieldName, String value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = self.getDisplayValue(fieldName, value);
        var valueJ = $wnd.SmartGWT.convertToJavaType(valueJS);
        return valueJ;
    }-*/;
    
    /**
     * Given a field with a specified {@link com.smargwt.client.widgets.grid.ListGridField#setValueMap(),valueMap}
     * or {@link com.smartgwt.client.widgets.grid.ListGridField#setDisplayField(),displayField},
     * this method will return the display value for any underlying data value.
     * @param fieldName Name of the field for which the displayValue is required
     * @param value data value for the field
     */    
    public native Object getDisplayValue(String fieldName, boolean value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = self.getDisplayValue(fieldName, value);
        var valueJ = $wnd.SmartGWT.convertToJavaType(valueJS);
        return valueJ;
    }-*/;
    
    /**
     * Given a field with a specified {@link com.smargwt.client.widgets.grid.ListGridField#setValueMap(),valueMap}
     * or {@link com.smartgwt.client.widgets.grid.ListGridField#setDisplayField(),displayField},
     * this method will return the display value for any underlying data value.
     * @param fieldName Name of the field for which the displayValue is required
     * @param value data value for the field
     */    
    public native Object getDisplayValue(String fieldName, Date value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var dateJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(value);
        var valueJS = self.getDisplayValue(fieldName, dateJS);
        var valueJ = $wnd.SmartGWT.convertToJavaType(valueJS);
        return valueJ;
    }-*/;


    /**
     * &#010  Clear a field value being tracked as an unsaved user edit.<P>&#010  The saved record value will be displayed in the the appropriate cell instead.&#010  Will also discard any validation errors for the specified field / row.&#010&#010
     *
     * @param rowNum   the row number
     * @param fieldName name of field for which the value is to be cleared
     */
    public native void clearEditValue(int rowNum, String fieldName) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.clearEditValue(rowNum, fieldName);
     }-*/;

    /**
     * Returns an array of every rowNum for which we have pending (unsubmitted) edits.
     * 
     * @return array of rowNums for rows with edit values pending submission
     */
    public native int[] getAllEditRows() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var editRowsJS =  self.getAllEditRows();
        if(editRowsJS == null) {
            editRowsJS=[];
        }
        return @com.smartgwt.client.util.JSOHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(editRowsJS);
    }-*/;

    /**
     * Programatically simulate clicking of a row.
     *
     * @param record    record object returned from getCellRecord()
     * @param recordNum index of the row where the click occurred
     * @param fieldNum  index of the col where the click occurred
     */
    public native void rowClick(ListGridRecord record, int recordNum, int fieldNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.rowClick(record.@com.smartgwt.client.core.DataClass::getJsObj()(), recordNum, fieldNum);
    }-*/;

    /**
     * Programatically simulate clicking of a row.<P> Default implementation fires 'editCell' if appropriate, and handles firing the 'recordDoubleClick' event
     *
     * @param record    record object returned from getCellRecord()
     * @param recordNum index of the row where the click occurred
     * @param fieldNum  index of the col where the click occurred
     */
    public native void rowDoubleClick(ListGridRecord record, int recordNum, int fieldNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.rowDoubleClick(record.@com.smartgwt.client.core.DataClass::getJsObj()(), recordNum, fieldNum);
    }-*/;


    /**
     * An array of SortSpecifier objects used to set up the initial sort configuration for
     * this grid.
     *
     * @param initialSort initialSort Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInitialSort(SortSpecifier[] initialSort)  throws IllegalStateException {
        setAttribute("initialSort", initialSort, false);
    }

    /**
     * An array of ${isc.DocUtils.linkForRef('object:SortSpecifier')} objects used to set up the initial sort configuration for
     * this grid.
     *
     *
     * @return Array of SortSpecifier
     */
    public SortSpecifier[] getInitialSort()  {
        return SortSpecifier.convertToArray(getAttributeAsJavaScriptObject("initialSort"));
    }


    /**
     * Returns the ${isc.DocUtils.linkForRef('object:SortSpecifier')} for the passed fieldName, or null if the field is not
     * sorted.
     * @param fieldName The name of a field, visible, hidden or existing only in the dataSource
     *
     * @return True if the passed field is sorted, false otherwise
     */
    public native SortSpecifier getSortSpecifier(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.getSortSpecifier(fieldName);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.data.SortSpecifier::new(Lcom/google/gwt/core/client/JavaScriptObject;)(retVal);
        }
    }-*/;

    /**
     * Adds another SortSpecifierto this grid's sort configuration and resorts.
     * @param sortSpecifier A SortSpecifier object indicating an additional field and direction to sort by
     */
    public native void addSort(SortSpecifier sortSpecifier) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addSort(sortSpecifier.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * This method sorts the grid on one or more fields.  Pass in an array of
     * SortSpecifiers to have the grid's data sorted by the fields in each
     * specifier.property and in  the directions specified.  The grid can be sorted by any combination of fields, including
     * fields specified in the fields array, whether visible or hidden, and  {@link
     * com.smartgwt.client.data.DataSource#getFields 'unused fields from the underlying dataSource'}, if there is one.  If
     * multiple fields are sorted, those that are visible show a directional icon and a small  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSortNumeralStyle 'sort-numeral'}  indicating that field's index in the sort
     * configuration. <P>See {@link com.smartgwt.client.widgets.grid.ListGrid#addSort} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#alterSort} APIs for information on making changes to the current sort
     * configuration.
     * @param sortSpecifiers Array of SortSpecifier objects
     */
    public native void setSort(SortSpecifier[] sortSpecifiers) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setSort(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(sortSpecifiers));
    }-*/;

    /**
     * Return the grids current sort specification.
     *
     * @return sort specifiers
     */
    public native SortSpecifier[] getSort() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var sortSpec = self.getSort();
        if($wnd.isc.isA.String(sortSpec)) {
            return @com.smartgwt.client.data.SortSpecifier::convertToArray(Ljava/lang/String;)(sortSpec);
        } else {
            return @com.smartgwt.client.data.SortSpecifier::convertToArray(Lcom/google/gwt/core/client/JavaScriptObject;)(sortSpec);
        }
    }-*/;

    /**
     * Recalculates values for fields with  {@link com.smartgwt.client.widgets.grid.ListGridField#getRecordSummaryFunction
     * summary-functions} defined and for values  displayed in the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary grid summary} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary group summary rows}.
     */
    public native void recalculateSummaries() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.recalculateSummaries();
    }-*/;

    /**
     * Recalculates values for fields with  {@link com.smartgwt.client.widgets.grid.ListGridField#getRecordSummaryFunction
     * summary-functions} defined and for values  displayed in the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary grid summary} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary group summary rows}.
     * @param records Optional array of records to recalculate summaries for
     */
    public native void recalculateSummaries(Record[] records) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.recalculateSummaries(records == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records));
    }-*/;

    /**
     * Add a onHeaderClick handler.
     * <p>
     * Handler fired when the user clicks a header in this listGrid before any other processing&#010 occurs.&#010 Return false to suppress the default header click handling&#010
     *
     * @param handler the onHeaderClick handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addHeaderClickHandler(com.smartgwt.client.widgets.grid.events.HeaderClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.HeaderClickEvent.getType()) == 0) setupHeaderClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.HeaderClickEvent.getType());
    }

    private native void setupHeaderClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onHeaderClick:$debox($entry(function(){
                    var param = {"fieldNum" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.grid.events.HeaderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onHeaderClick = $debox($entry(function(){
                var param = {"fieldNum" : arguments[0]};
                var event = @com.smartgwt.client.widgets.grid.events.HeaderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        }
    }-*/;
    
    /**
     * Add a sortChanged handler.
     * <p>
     * Notification method executed when the {@link com.smartgwt.client.widgets.grid.ListGrid#setSort sort specifiers} change
     * for this grid.
     *
     * @param handler the sortChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addSortChangedHandler(com.smartgwt.client.widgets.grid.events.SortChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.SortEvent.getType()) == 0) setupSortChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.SortEvent.getType());
    }

    private native void setupSortChangedEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({sortChanged:$entry(function(){
                        var param = {"sortSpecifiers" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.grid.events.SortEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.sortChanged = $entry(function(){
                   var param = {"sortSpecifiers" : arguments[0]};
                   var event = @com.smartgwt.client.widgets.grid.events.SortEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
    
    /**
     * This method overrides {@link com.smartgwt.client.widgets.Canvas#willAcceptDrop} and works as follows:<br> <ul> <li>If
     * {@link com.smartgwt.client.widgets.Canvas#willAcceptDrop} (the superclass definition) returns false, this      method
     * always returns false.  This allows {@link com.smartgwt.client.widgets.Canvas#getDragType dragType} and     {@link
     * com.smartgwt.client.widgets.Canvas#getDropTypes dropTypes} to be used to configure eligibility for drop.  By default,   
     * a ListGrid has no dropTypes configured and so this check will not prevent a drop.</li> <li>If this is a self-drop, that
     * is, the user is dragging a record within this list, this is     an attempted drag-reorder.  If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanReorderRecords canReorderRecords} is      false, this method returns
     * false.</li> <li>If the {@link com.smartgwt.client.util.EventHandler#getDragTarget} is another widget, if     {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanAcceptDroppedRecords canAcceptDroppedRecords} is false this method
     * returns false.</li> <li>If a call to {@link com.smartgwt.client.widgets.grid.ListGrid#getDragData} on the
     * <code>dragTarget</code> fails to return     an record object or an array of records, this method returns false.</li> 
     * <li>If a the drop target record is disabled or has {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getCanAcceptDrop canAcceptDrop}      set to false, return false.</li>
     * </ul> Note that this method may be called repeatedly during a drag-drop interaction to update the UI and notify the user
     * as to when they may validly drop data.
     * 
     * <b> Note :</b> This is an override point
     *
     * @return true if this component will accept a drop of the dragData
     */
    public Boolean willAcceptDrop() {
    	return super.willAcceptDrop();   
    }
    
    /**
     * Add a handler that fires when records are dropped onto this ListGrid.
     * <P>
     * The default behavior is as follows:
     * <P>
     * If this is a self-drop, records are simply reordered.
     * <P>
     * For a drop from another widget, data is handled as though transferDragData() were called
     * on the component from which records were dragged, which depending on the 
     * {@link ListGrid.dragDataAction dragDataAction} specified on the source component, may
     * either remove the source records from the original list
     * (<code>dragDataAction:"move"</code>) or just provide a copy to this list
     * (<code>dragDataAction:"copy"</code>).
     * <P>
     * If this grid is databound, the new records will be added to the dataset by calling
     * dataSource.addData().  For all drops onto databound ListGrids from other databound 
     * components, the {@link com.smartgwt.client.widgets.DataBoundComponent#addDropValues dropValues} 
     * will be added as new attributes of each Record created from the dropped data.
     * <P>
     * For multi-node drops, Queuing is automatically used to combine all DSRequests into a
     * single HTTP Request (see QuickStart Guide, Server Framework chapter).  This allows the
     * server to persist all changes caused by the drop in a single transaction (and this is
     * automatically done when using the built-in server DataSources with Power Edition and
     * above).
     * <P>
     * Note that reordering records has no default effect on a databound grid.
     * <P>
     * The newly dropped data is then selected automatically.
     * <P>
     * If these default persistence behaviors are undesirable, user RecordDropEvent.cancel() to
     * cancel them, and implement your own behavior.
     * <P>
     * NOTE: for a drop beyond the last visible record of a ListGrid, the
     * <code>targetRecord</code> available from the RecordDropEvent will be null and the
     * <code>index</code> will be one higher than the last record in the grid.  This
     * includes a drop into an empty ListGrid, where <code>index</code> will be 0.
     *
     * @param handler the RecordDrop handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRecordDropHandler(com.smartgwt.client.widgets.grid.events.RecordDropHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RecordDropEvent.getType()) == 0) setupRecordDropEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RecordDropEvent.getType());
    }

    private native void setupRecordDropEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onRecordDrop:$debox($entry(function(){
                    var param = {"dropRecords" : arguments[0], "targetRecord" : arguments[1], "index" : arguments[2], "sourceWidget" : arguments[3]};
                    var event = @com.smartgwt.client.widgets.grid.events.RecordDropEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onRecordDrop = $debox($entry(function(){
                var param = {"dropRecords" : arguments[0], "targetRecord" : arguments[1], "index" : arguments[2], "sourceWidget" : arguments[3]};
                var event = @com.smartgwt.client.widgets.grid.events.RecordDropEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        }
    }-*/;
    
    
    /**
     * Add a recordExpand handler.
     * <p>
     * Handler fired when a record is expanded in a grid with <code>canExpandRecords</code> set to  true. Allows the expansion
     * to be cancelled.
     *
     * @param handler the recordExpand handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRecordExpandHandler(com.smartgwt.client.widgets.grid.events.RecordExpandHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RecordExpandEvent.getType()) == 0) setupRecordExpandEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RecordExpandEvent.getType());
    }

    private native void setupRecordExpandEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onExpandRecord:$debox($entry(function(){
                        var param = {"record" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.grid.events.RecordExpandEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onExpandRecord = $debox($entry(function(){
                   var param = {"record" : arguments[0]};
                   var event = @com.smartgwt.client.widgets.grid.events.RecordExpandEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;

    /**
     * Add a recordCollapse handler.
     * <p>
     * Handler fired when a record is collapsed in a grid with <code>canExpandRecords</code> set to  true. Allows the collapse
     * to be cancelled.
     *
     * @param handler the recordCollapse handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRecordCollapseHandler(com.smartgwt.client.widgets.grid.events.RecordCollapseHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RecordCollapseEvent.getType()) == 0) setupRecordCollapseEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RecordCollapseEvent.getType());
    }

    private native void setupRecordCollapseEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onCollapseRecord:$debox($entry(function(){
                        var param = {"record" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.grid.events.RecordCollapseEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onCollapseRecord = $debox($entry(function(){
                   var param = {"record" : arguments[0]};
                   var event = @com.smartgwt.client.widgets.grid.events.RecordCollapseEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;



    /**
     * Preload primary ListGrid skin images.
     */
    public static native void preloadImages() /*-{
        var skinImgDir = $wnd.isc.ListGrid.getInstanceProperty('skinImgDir');
        var canvasSkinImgDir = $wnd.isc.Canvas.getInstanceProperty('skinImgDir');
        var sortAscImg = $wnd.isc.ListGrid.getInstanceProperty('sortAscendingImage').src;
        var sortDescImg = $wnd.isc.ListGrid.getInstanceProperty('sortDescendingImage').src;
        var headerMenuButtonSrc = $wnd.isc.ListGrid.getInstanceProperty('headerMenuButtonSrc');

        @com.smartgwt.client.util.FileLoader::cacheImg(Ljava/lang/String;Ljava/lang/String;)(skinImgDir, sortAscImg);
        @com.smartgwt.client.util.FileLoader::cacheImg(Ljava/lang/String;Ljava/lang/String;)(skinImgDir, sortDescImg);
        @com.smartgwt.client.util.FileLoader::cacheImg(Ljava/lang/String;Ljava/lang/String;)(canvasSkinImgDir, headerMenuButtonSrc);

        var headerButtonImg = $wnd.isc.ListGrid.getInstanceProperty('headerButtonDefaults').src;
        @com.smartgwt.client.util.FileLoader::cacheImgStates(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)(canvasSkinImgDir, headerButtonImg, "Selected,Over,Selected_Over");

        @com.smartgwt.client.util.FileLoader::cacheImg(Ljava/lang/String;Ljava/lang/String;)(canvasSkinImgDir, '[SKIN]/actions/column_preferences.png');
        @com.smartgwt.client.util.FileLoader::cacheImg(Ljava/lang/String;Ljava/lang/String;)(canvasSkinImgDir, '[SKIN]/actions/freezeLeft.png');
        @com.smartgwt.client.util.FileLoader::cacheImg(Ljava/lang/String;Ljava/lang/String;)(canvasSkinImgDir, '[SKIN]/actions/unfreeze.png');
        @com.smartgwt.client.util.FileLoader::cacheImg(Ljava/lang/String;Ljava/lang/String;)(canvasSkinImgDir, '[SKIN]/actions/groupby.png');
        @com.smartgwt.client.util.FileLoader::cacheImg(Ljava/lang/String;Ljava/lang/String;)(canvasSkinImgDir, '[SKIN]/actions/ungroup.png');
        @com.smartgwt.client.util.FileLoader::cacheImg(Ljava/lang/String;Ljava/lang/String;)(canvasSkinImgDir, '[SKIN]/actions/sort_ascending.png');
        @com.smartgwt.client.util.FileLoader::cacheImg(Ljava/lang/String;Ljava/lang/String;)(canvasSkinImgDir, '[SKIN]/actions/sort_descending.png');
    }-*/;
    
    /**
     * Returns a numeric value for the width of some field within this listGrid.
     * @param fieldNum Index of field for which width is to be determined.
     *
     * @return width of the field in px, or null if the width can't be determined
     */
    public native int getFieldWidth(Number fieldNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getFieldWidth(fieldNum);
    }-*/;
 
    /**
     * Returns a numeric value for the width of some field within this listGrid.
     * @param fieldName Name of field for which width is to be determined.
     *
     * @return width of the field in px, or null if the width can't be determined
     */
    public native int getFieldWidth(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getFieldWidth(fieldName);
    }-*/;

    /**
     * If true, shows {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents 'recordComponents'} in cells,
     * rather  than just in records.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showRecordComponentsByCell showRecordComponentsByCell Default value is null
     */
    public void setShowRecordComponentsByCell(Boolean showRecordComponentsByCell) {
        setAttribute("showRecordComponentsByCell", showRecordComponentsByCell, true);
        if(showRecordComponentsByCell) setRecordComponentPosition(EmbeddedPosition.WITHIN);
    }

    /**
     * If true, shows {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents 'recordComponents'} in cells,
     * rather  than just in records.
     *
     *
     * @return Boolean
     */
    public Boolean getShowRecordComponentsByCell()  {
        return getAttributeAsBoolean("showRecordComponentsByCell");
    }

    /**
     * Return the underlying, ungrouped data of this ListGrid as a {@link com.smartgwt.client.data.ResultSet}.
     * Use this method to access the data when the grid is grouped.
     * <p>
     * Note that this method should only be called after initial data has been fetched by this DataBoundComponent.
     *
     * @return ResultSet, or null if the underlying ungrouped data is not a ResultSet
     * @see #fetchData()
     */
    public ResultSet getOriginalResultSet() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("originalData");
        if(dataJS == null) return null;
        if(!ResultSet.isResultSet(dataJS)) {
            SC.logWarn("getOriginalResultSet(): data is not a ResultSet; returning null " +
                "(if ungrouped, use getOriginalResultSet(); if unbound, use getOriginalRecordList(); " +
                "can only be called on DataBoundComponents after initial data has been fetched)");
            return null;
        }
        return new ResultSet(dataJS);
    }

    /**
     * Return the underlying, ungrouped data of this DataBoundComponent as a {@link com.smartgwt.client.data.RecordList}.
     * <p>
     * If this grid {@link #isGrouped is grouped}, 
     * {@link com.smartgwt.client.widgets.DataBoundComponent#getRecordList} will return the 
     * grouped data as a Tree.
     * Use this method to return the underlying Array of Records or 
     * {@link com.smartgwt.client.data.ResultSet}, as if
     * the grid was ungrouped:
     * <pre>isGrouped() ? getOriginalRecordList() : getRecordList()</pre>
     * @return the RecordList
     */
    public RecordList getOriginalRecordList() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("originalData");
        if(dataJS == null) return null;

        if(ResultSet.isResultSet(dataJS)) {
            return getOriginalResultSet();
        }
        return new RecordList(dataJS);
    }

    /**
     * Formatter to apply to values displayed within cells.
     * <br><br>
     * The value passed to this method is either the field value found in the cell record or, if there are unsaved edits, the current user-entered value for the cell.
     * <b>NOTE</b>: unsaved user edits may contain nulls, bad values or values of the wrong type, so formatters used for editable data should be bulletproof.
     * <br><br>
     * Note that this formatter will not be applied to the value displayed within editors for cells - use formatEditorValue to achieve this.
     * <br><br>
     * If formatCellValue is defined at the field level for some cell being edited, the field level method will be used to format the edit value and this method will not be called for that cell.
     *
     * @param formatter Formatter to apply to values displayed within cells
     */
    public native void setCellFormatter(CellFormatter formatter) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self =  this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
             self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        self.formatCellValue = $debox($entry(function(value, record, rowNum, colNum) {
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var valueJ = $wnd.SmartGWT.convertToJavaType(value);
            return formatter.@com.smartgwt.client.widgets.grid.CellFormatter::format(Ljava/lang/Object;Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(valueJ, recordJ, rowNum, colNum);
        }));
    }-*/;

    /**
     * HTML to be shown in hovers over cells in the column described by this field. Note that the "value" passed to the HoverCustomizer
     * callback will be null when the HoverCustomizer is applied to the ListGrid. However when applied to a ListGridField, the appropriate field
     * value will be passed.
     *
     * @param hoverCustomizer the hover customizer
     * @see com.smartgwt.client.widgets.grid.ListGridField#setHoverCustomizer(HoverCustomizer)
     */
    public native void setHoverCustomizer(HoverCustomizer hoverCustomizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self =  this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
             self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        self.cellHoverHTML = $debox($entry(function(record, rowNum, colNum) {
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var valueJ = null;
            return hoverCustomizer.@com.smartgwt.client.widgets.grid.HoverCustomizer::hoverHTML(Ljava/lang/Object;Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(valueJ, recordJ, rowNum, colNum);
        }));
    }-*/;
    

    /**
     * This method allows developers to dynamically customize the form item displayed in an editable grid, based
     * on the cell being edited.
     * Note that {@link ListGridField#setEditorType()} allows a simpler static customization of FormItem properties
     * for a specific field.
     * @param customizer
     */
    public native void setEditorCustomizer(ListGridEditorCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self =  this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
             self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        self.editorCustomizer = customizer;
        
        if (self.customEditorPropertiesFunction) return;
        self.customEditorPropertiesFunction = true;
    
        // disable reuse of form items since type is likely to change
        self.updateEditorItemsInPlace = false;
        
        self.getEditorProperties = $debox($entry(function(editField, editedRecord, rowNum) {
            var editProperties = this.Super("getEditorProperties", arguments);
            
            var editorContext = { 
                defaultProperties:editProperties,
                rowNum:rowNum,
                editField:editField,
                editedRecord:editedRecord
            };
            var editorContextJ = @com.smartgwt.client.widgets.grid.ListGridEditorContext::new(Lcom/google/gwt/core/client/JavaScriptObject;)(editorContext);
            
            var customizerJ = this.editorCustomizer;
            var editorJ = customizer.@com.smartgwt.client.widgets.grid.ListGridEditorCustomizer::getEditor(Lcom/smartgwt/client/widgets/grid/ListGridEditorContext;)(editorContextJ);
            
            var editorJS = editorJ == null ? null : editorJ.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
            // Apply custom properties on top of standard item defaults.
            // This ensures field.type, field-level change handlers etc should be picked up even if
            // an otherwise custom item is provided.
            if (editorJS != editProperties) {
                $wnd.isc.addProperties(editProperties, editorJS);
            }
            return editProperties;
        }));
        
    }-*/;    
    /**
     * Perform a one-time horizontal auto-fit of the fields passed. Fields will be sized to match their contents or title (as
     * specified in {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitWidthApproach autoFitWidthApproach}) Does not
     * establish permanent auto-fitting - use {@link com.smartgwt.client.widgets.grid.ListGrid#setAutoFitWidth
     * ListGrid.setAutoFitWidth} to do so.
     * @param fields Array of fields to auto fit. If this parameter  is not passed, autoFitting will occur on all visible fields unless they
     * are of   the following types:   <ul>   <li>boolean</li>   <li>icon</li>   <li>image</li>   <li>date</li>   <li>time</li>
     *   <li>datetime</li>   </ul>
     */
    public native void autoFitFields(ListGridField... fields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var fieldsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(fields);
        self.autoFitFields(fieldsJS);
    }-*/;

    /**
     * Force an array of fields to be hidden. <P> NOTE: If a field.showIf expression exists, it will be destroyed. <P> When
     * hiding multiple fields, this method should be called rather than calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#hideField ListGrid.hideField} repeatedly for each field to hide.
     * @param fields fields to hide
     */
    public native void hideFields(String... fields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var fieldsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(fields);
        self.hideFields(fieldsJS);
    }-*/;

    /**
     * Force an array of fields to be hidden. <P> NOTE: If a field.showIf expression exists, it will be destroyed. <P> When
     * hiding multiple fields, this method should be called rather than calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#hideField ListGrid.hideField} repeatedly for each field to hide.
     * @param fields fields to hide
     */
    public native void hideFields(ListGridField... fields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var fieldsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(fields);
        self.hideFields(fieldsJS);
    }-*/;

    /**
     * Force an array of fields to be hidden. <P> NOTE: If a field.showIf expression exists, it will be destroyed. <P> When
     * hiding multiple fields, this method should be called rather than calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#hideField ListGrid.hideField} repeatedly for each field to hide.
     * @param fields fields to hide
     * @param suppressRelayout if passed, don't relayout non-explicit sized fields                                       to fit the available space
     */
    public native void hideFields(String[] fields, boolean suppressRelayout) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var fieldsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(fields);
        self.hideFields(fields, suppressRelayout);
    }-*/;

    /**
     * Force an array of fields to be hidden. <P> NOTE: If a field.showIf expression exists, it will be destroyed. <P> When
     * hiding multiple fields, this method should be called rather than calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#hideField ListGrid.hideField} repeatedly for each field to hide.
     * @param fields fields to hide
     * @param suppressRelayout if passed, don't relayout non-explicit sized fields                                       to fit the available space
     */
    public native void hideFields(ListGridField[] fields, boolean suppressRelayout) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var fieldsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(fields);
        self.hideFields(fieldsJS, suppressRelayout);
    }-*/;
    
    /**
     * Force an array of fields to be shown. This method does not add new fields to the grid, it simply changes field
     * visibility. If a field.showIf expression exists, it will be destroyed. <P> Note: for showing multiple fields it is more
     * efficient to call this method than to call {@link com.smartgwt.client.widgets.grid.ListGrid#showField
     * ListGrid.showField} repeatedly.
     * @param field Fields to show.
     */
    public native void showFields(String... fields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var fieldsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(fields);
        self.showFields(fieldsJS);
    }-*/;
    
    /**
     * Force an array of fields to be shown. This method does not add new fields to the grid, it simply changes field
     * visibility. If a field.showIf expression exists, it will be destroyed. <P> Note: for showing multiple fields it is more
     * efficient to call this method than to call {@link com.smartgwt.client.widgets.grid.ListGrid#showField
     * ListGrid.showField} repeatedly.
     * @param field Fields to show.
     */
    public native void showFields(String[] fields, boolean suppressRelayout) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var fieldsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(fields);
        self.showFields(fieldsJS, suppressRelayout);
    }-*/;
    
    /**
     * Force an array of fields to be shown. This method does not add new fields to the grid, it simply changes field
     * visibility. If a field.showIf expression exists, it will be destroyed. <P> Note: for showing multiple fields it is more
     * efficient to call this method than to call {@link com.smartgwt.client.widgets.grid.ListGrid#showField
     * ListGrid.showField} repeatedly.
     * @param field Fields to show.
     */
    public native void showFields(ListGridField... fields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var fieldsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(fields);
        self.showFields(fieldsJS);
    }-*/;
    
    /**
     * Force an array of fields to be shown. This method does not add new fields to the grid, it simply changes field
     * visibility. If a field.showIf expression exists, it will be destroyed. <P> Note: for showing multiple fields it is more
     * efficient to call this method than to call {@link com.smartgwt.client.widgets.grid.ListGrid#showField
     * ListGrid.showField} repeatedly.
     * @param field Fields to show.
     */
    public native void showFields(ListGridField[] fields, boolean suppressRelayout) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var fieldsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(fields);
        self.showFields(fieldsJS, suppressRelayout);
    }-*/;

    /**
     * Chart the data in this listGrid as a multi-series chart. <P> Each row provides a series of data.  Each series of data is
     * labeled by a value from one column, called the <code>labelField</code>.   <P> For example, cell values are sales
     * figures, and fields are "Product", "August", "September", "October".  In this case each row gives a series: sales
     * figures for each of 3 months.  The <code>labelField</code> in this case is the "Product" field, meaning each row
     * represents sales figures for each of 3 months for a particular product.  This dataset can be charted via any
     * multi-series chart: stacked or clustered bar or column chart, line chart with multiple lines, or area chart (stacked
     * lines). <P> By default, all visible fields other than the label field are assumed to be labels for series values, but an
     * explicit list of fields can be provided as <code>dataFields</code>. <P> By default, all data is charted if all data is
     * loaded, otherwise, data visible in the viewport is charted.  An explicit set of rows can be provided via
     * <code>dataRows</code>.
     * @param labelField name of the field
     *
     * @return created Chart instance
     * 
     */
    public native FacetChart chartData(String labelField) /*-{
	    var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
	    var param = self.chartData(labelField);
	    return @com.smartgwt.client.widgets.chart.FacetChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
	}-*/;

    /**
     * Chart the data in this listGrid as a multi-series chart. <P> Each row provides a series of data.  Each series of data is
     * labeled by a value from one column, called the <code>labelField</code>.   <P> For example, cell values are sales
     * figures, and fields are "Product", "August", "September", "October".  In this case each row gives a series: sales
     * figures for each of 3 months.  The <code>labelField</code> in this case is the "Product" field, meaning each row
     * represents sales figures for each of 3 months for a particular product.  This dataset can be charted via any
     * multi-series chart: stacked or clustered bar or column chart, line chart with multiple lines, or area chart (stacked
     * lines). <P> By default, all visible fields other than the label field are assumed to be labels for series values, but an
     * explicit list of fields can be provided as <code>dataFields</code>. <P> By default, all data is charted if all data is
     * loaded, otherwise, data visible in the viewport is charted.  An explicit set of rows can be provided via
     * <code>dataRows</code>.
     * @param labelField name of the field
     * @param dataFields optional list of fields to use as labels.  By      default, all fields are used.
     * @param dataRows set of records to chart.  Can be obtained by eg      {@link com.smartgwt.client.data.ResultSet#getRange
     * grid.data.getRange()}.
     * @param chartProperties properties to pass to the created chart
     * @param labelFieldFirst if true, use the labelField as the "first" set of labels,      for example, as the bar labels in a stacked bar chart,
     * whereas the second set of labels      would appear as the legend.
     *
     * @return created Chart instance
     */
    public native FacetChart chartData(String labelField, String[] dataFields, Record[] dataRows, FacetChart chartProperties, boolean labelFieldFirst) /*-{
	    var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
	    var dataFieldsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(dataFields);
	    var dataRowsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(dataRows);
	    var chartPropertiesJS = chartProperties == null ? null : chartProperties.@com.smartgwt.client.widgets.chart.FacetChart::getConfig()();
	    var chartJS = self.chartData(labelField, dataFieldsJS, dataRowsJS, chartPropertiesJS, labelFieldFirst);
	    return @com.smartgwt.client.widgets.chart.FacetChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(chartJS);
	    
	}-*/;
    
    /**
     * Array of components that make up this grid. This array controls which standard and/or custom
     *  parts will be displayed within this ListGrid.
     *  <P>
     * ListGrid is a subclass of {@link com.smartgwt.client.widgets.layout.VLayout} and consists of a number of member
     * components. The
     *  standard set of members are automatically generated by the grid, and include (for example)
     *  the header (a Toolbar of buttons for each field) and the body
     *  (a GridRenderer displaying the actual data contained in the grid).<br>
     * The default value of <code>gridComponents</code> is an Array of {@link com.smartgwt.client.types.ListGridComponent}s
     * listing
     *  the standard components in their default order:
     *  
     *  <pre>
     *     [ListGridComponent.FILTER_EDITOR, ListGridComponent.HEADER, ListGridComponent.BODY, 
     *      ListGridComponent.SUMMARY_ROW]
     *  </pre>
     * 
     *  You can override <code>gridComponents</code> to change the order of standard components.
     *  You can also omit standard components this way, although it more efficient to
     * use the related "show" property if available (eg {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor
     * showFilterEditor}). Note that
     *  this array must contain an entry for the <code>"body"</code> - listGrids with no body showing
     *  are unsupported.<br>
     *  <i>Advanced note:</i> The live components generated for each of these standard 
     *  {@link com.smartgwt.client.types.ListGridComponent} types may differ across different listGrids. For example if this
     * grid has any {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen fields}, the "body" entry will
     * actually
     *  be created as an HLayout containing two GridRenderers (one for frozen fields, 
     *  and one for unfrozen fields). This is really an implementation detail - the "body" entry
     *  in the gridComponents array simply specifies where the UI for the body should render within
     *  the ListGrid layout. 
     *  <P>
     *  By embedding a Canvas directly in this list you can add arbitrary additional components to the
     *  listGrid as members, and have them be displayed alongside the standard automatically generated
     *  parts of the ListGrid. 
     *  <P>
     *  Note that having added controls to gridComponents, you can still call APIs directly on
     *  those controls to change their appearance, and you can also show() and hide() them if
     *  they should not be shown in some circumstances.
     *  <P>
     *  Tip: custom controls need to set layoutAlign:"center" to appear vertically centered.
     *
     * @param gridComponents gridComponents Default value is (see below)
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGridComponents(Object... gridComponents)  throws IllegalStateException {
        setAttribute("gridComponents", gridComponents, false);
    }




    // ********************* DataBoundComponent Properties / Attributes ***********************

    public void setDataPageSize(int dataPageSize) {
        setAttribute("dataPageSize", dataPageSize, true);
    }

    public int getDataPageSize() {
        return getAttributeAsInt("dataPageSize");
    }

    public void setUseAllDataSourceFields(Boolean useAllDataSourceFields) {
        setAttribute("useAllDataSourceFields", useAllDataSourceFields, true);
    }

    public Boolean getUseAllDataSourceFields() {
        return getAttributeAsBoolean("useAllDataSourceFields");
    }

    public void setShowHiddenFields(Boolean showHiddenFields) {
        setAttribute("showHiddenFields", showHiddenFields, true);
    }

    public Boolean getShowHiddenFields() {
        return getAttributeAsBoolean("showHiddenFields");
    }

    public void setShowComplexFields(Boolean showComplexFields) {
        setAttribute("showComplexFields", showComplexFields, true);
    }

    public Boolean getShowComplexFields() {
        return getAttributeAsBoolean("showComplexFields");
    }

    public void setFetchOperation(String fetchOperation) {
        setAttribute("fetchOperation", fetchOperation, true);
    }

    public String getFetchOperation() {
        return getAttributeAsString("fetchOperation");
    }

    public void setUpdateOperation(String updateOperation) {
        setAttribute("updateOperation", updateOperation, true);
    }

    public String getUpdateOperation() {
        return getAttributeAsString("updateOperation");
    }

    public void setAddOperation(String addOperation) {
        setAttribute("addOperation", addOperation, true);
    }

    public String getAddOperation() {
        return getAttributeAsString("addOperation");
    }

    public void setRemoveOperation(String removeOperation) {
        setAttribute("removeOperation", removeOperation, true);
    }

    public String getRemoveOperation() {
        return getAttributeAsString("removeOperation");
    }

    public void setExportFields(String[] exportFields) {
        setAttribute("exportFields", exportFields, true);
    }

    public String[] getExportFields() {
        return getAttributeAsStringArray("exportFields");
    }

    public void setExportAll(Boolean exportAll) {
        setAttribute("exportAll", exportAll, true);
    }

    public Boolean getExportAll() {
        return getAttributeAsBoolean("exportAll");
    }

    public void setPreventDuplicates(Boolean preventDuplicates) throws IllegalStateException {
        setAttribute("preventDuplicates", preventDuplicates, false);
    }

    public Boolean getPreventDuplicates() {
        return getAttributeAsBoolean("preventDuplicates");
    }

    public void setDuplicateDragMessage(String duplicateDragMessage) throws IllegalStateException {
        setAttribute("duplicateDragMessage", duplicateDragMessage, false);
    }

    public String getDuplicateDragMessage() {
        return getAttributeAsString("duplicateDragMessage");
    }

    public void setAddDropValues(Boolean addDropValues) {
        setAttribute("addDropValues", addDropValues, true);
    }

    public Boolean getAddDropValues() {
        return getAttributeAsBoolean("addDropValues");
    }

    public void setDropValues(Map dropValues) {
        setAttribute("dropValues", dropValues, true);
    }

    public Map getDropValues() {
        return getAttributeAsMap("dropValues");
    }

    public void setUseFlatFields(Boolean useFlatFields) throws IllegalStateException {
        setAttribute("useFlatFields", useFlatFields, false);
    }

    public Boolean getUseFlatFields() {
        return getAttributeAsBoolean("useFlatFields");
    }

    public void setHiliteProperty(String hiliteProperty) {
        setAttribute("hiliteProperty", hiliteProperty, true);
    }

    public String getHiliteProperty() {
        return getAttributeAsString("hiliteProperty");
    }

    /**
     * Shows a HiliteEditor interface allowing end-users to edit the data-hilites currently in use by this DataBoundComponent.
     */
    public native void editHilites() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editHilites();
    }-*/;

    /**
     * Get the current hilites encoded as a String, for saving.
     *
     * @return the hilite state
     */
    public native String getHiliteState()  /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getHiliteState();
    }-*/;

    /**
     * Set the current hilites based on a hiliteState String previously returned from getHilitesState.
     *  
     * @param hiliteState hilites state encoded as a String
     */
    public native void setHiliteState(String hiliteState)  /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.setHiliteState(hiliteState);
    }-*/;

    /**
     * Accepts an array of hilite objects and applies them to this DataBoundComponent. See also {@link #getHilites() getHilites} for a method of
     * retrieving the hilite array for storage, including hilites manually added by the user.
     *
     * @param hilites array of hilite objects
     */
    public native void setHilites(Hilite[] hilites)/*-{
        var isCreated = this.@com.smartgwt.client.widgets.BaseWidget::isCreated()();
        var hilitesJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(hilites);
        if (isCreated) {
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setHilites(hilitesJS);
        } else {
            var obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.hilites = hilitesJS;
        }
    }-*/;

    /**
     * Return the set of hilite-objects currently applied to this DataBoundComponent. These can be saved for
     * storage and then restored to a component later via setHilites().
     *
     * @return array of hilite objects
     */
    public native Hilite[] getHilites()/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var hilitesJS = self.getHilites();
        return @com.smartgwt.client.data.Hilite::convertToHiliteArray(Lcom/google/gwt/core/client/JavaScriptObject;)(hilitesJS);
    }-*/;

    public void setDragDataAction(DragDataAction dragDataAction) {
        setAttribute("dragDataAction", dragDataAction.getValue(), true);
    }

    public DragDataAction getDragDataAction() {
        return EnumUtil.getEnum(DragDataAction.values(), getAttribute("dragDataAction"));
    }

    public void setDragTrackerStyle(String dragTrackerStyle) {
        setAttribute("dragTrackerStyle", dragTrackerStyle, true);
    }

    public String getDragTrackerStyle() {
        return getAttributeAsString("dragTrackerStyle");
    }

    public void setCanAddFormulaFields(Boolean canAddFormulaFields) {
        setAttribute("canAddFormulaFields", canAddFormulaFields, true);
    }

    public native void addSummaryField() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.addSummaryField();
     }-*/;

    public native void addFormulaField() /*-{
       var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
       self.addFormulaField();
    }-*/;

    public Boolean getCanAddFormulaFields() {
        return getAttributeAsBoolean("canAddFormulaFields");
    }

    public void setAddFormulaFieldText(String addFormulaFieldText) {
        setAttribute("addFormulaFieldText", addFormulaFieldText, true);
    }

    public String getAddFormulaFieldText() {
        return getAttributeAsString("addFormulaFieldText");
    }

    public void setEditFormulaFieldText(String editFormulaFieldText) {
        setAttribute("editFormulaFieldText", editFormulaFieldText, true);
    }

    public String getEditFormulaFieldText() {
        return getAttributeAsString("editFormulaFieldText");
    }

    public void setCanAddSummaryFields(Boolean canAddSummaryFields) {
        setAttribute("canAddSummaryFields", canAddSummaryFields, true);
    }

    public Boolean getCanAddSummaryFields() {
        return getAttributeAsBoolean("canAddSummaryFields");
    }

    public void setAddSummaryFieldText(String addSummaryFieldText) {
        setAttribute("addSummaryFieldText", addSummaryFieldText, true);
    }

    public String getAddSummaryFieldText() {
        return getAttributeAsString("addSummaryFieldText");
    }

    public void setEditSummaryFieldText(String editSummaryFieldText) {
        setAttribute("editSummaryFieldText", editSummaryFieldText, true);
    }

    public String getEditSummaryFieldText() {
        return getAttributeAsString("editSummaryFieldText");
    }

    // ********************* Methods ***********************


    public native void selectRecord(Record record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS);
     }-*/;

    public native void selectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record);
     }-*/;

    public native void selectRecord(int record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record, newState);
     }-*/;

    public native void selectRecord(Record record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS, newState);
     }-*/;

    public native void selectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecord(recordsJS);
     }-*/;

    public native void selectRecords(int[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;

    public native void selectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS);
     }-*/;

    public native void selectRecords(Record[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;

    public native void deselectRecord(Record record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.deselectRecord(recordJS);
     }-*/;

    public native void deselectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectRecord(record);
     }-*/;

    public native void deselectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.deselectRecords(recordsJS);
     }-*/;

    public native void deselectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.deselectRecords(recordsJS);
     }-*/;

    public native void selectAllRecords() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.selectAllRecords();
     }-*/;

    public native void deselectAllRecords() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.deselectAllRecords();
     }-*/;

    public native Boolean anySelected() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var retVal =self.anySelected();
         if(retVal == null || retVal === undefined) {
             return null;
         } else {
             return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
         }
     }-*/;

    public native void enableHilite(String hiliteID) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHilite(hiliteID);
     }-*/;

    public native void enableHilite(String hiliteID, boolean enable) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHilite(hiliteID, enable);
     }-*/;

    public native void disableHilite(String hiliteID) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.disableHilite(hiliteID);
     }-*/;

    public native void enableHiliting() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHiliting();
     }-*/;

    public native void enableHiliting(boolean enable) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHiliting(enable);
     }-*/;

    public native void disableHiliting() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.disableHiliting();
     }-*/;

    public native Record[] getDragData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = self.getDragData();
        return @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
     }-*/;

    public native void transferSelectedData(DataBoundComponent source) /*-{
         var self = this.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
         self.transferSelectedData(source.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
     }-*/;

    public native void transferSelectedData(DataBoundComponent source, int index) /*-{
         var self = this.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
         self.transferSelectedData(source.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), index);
     }-*/;

    public native int getRecordIndex(Record record) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         return self.getRecordIndex(record.@com.smartgwt.client.core.DataClass::getJsObj()());
     }-*/;

    public native String getTitleFieldValue(Record record) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         return self.getTitleFieldValue(record);
     }-*/;

    public void setTitleField(String titleField) {
        setAttribute("titleField", titleField, true);
    }

    public String getTitleField() {
        return getAttributeAsString("titleField");
    }

    public void setDataSource(DataSource dataSource) {
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), true);
    }

    public DataSource getDataSource() {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }

    public void setAutoFetchData(Boolean autoFetchData) throws IllegalStateException {
        setAttribute("autoFetchData", autoFetchData, false);
    }

    public Boolean getAutoFetchData() {
        return getAttributeAsBoolean("autoFetchData");
    }

    public void setAutoFetchAsFilter(Boolean autoFetchAsFilter) throws IllegalStateException {
        setAttribute("autoFetchAsFilter", autoFetchAsFilter, false);
    }

    public Boolean getAutoFetchAsFilter() {
        return getAttributeAsBoolean("autoFetchAsFilter");
    }

    public void setInitialCriteria(Criteria initialCriteria) throws IllegalStateException {
        setAttribute("initialCriteria", initialCriteria.getJsObj(), false);
    }

    public Criteria getInitialCriteria() {
        return new Criteria(getAttributeAsJavaScriptObject("initialCriteria"));
    }

    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    public native void fetchData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.fetchData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    public native void filterData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData();
    }-*/;

    public native void filterData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void filterData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.filterData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    public native void filterData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.filterData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    public native void invalidateCache() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.invalidateCache();
    }-*/;

    public ResultSet getResultSet() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        if(dataJS == null) return null;
        if(!ResultSet.isResultSet(dataJS)) {
            SC.logWarn("getResultSet(): data is not a ResultSet; returning null " +
                "(if grouped, use getOriginalResultSet(); if unbound, use getRecordList(); " +
                "can only be called on DataBoundComponents after initial data has been fetched)");
            return null;
        }
        return new ResultSet(dataJS);
    }

    public RecordList getRecordList() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        if(dataJS == null) return null;

        if(ResultSet.isResultSet(dataJS)) {
            return getResultSet();
        }
        return new RecordList(dataJS);
    }

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.widgets.DataBoundComponent#getDataSource DataSource}
     * to  retrieve data that matches the current filter and sort criteria for this component, then  exports the resulting data
     * to a file or window in the requested format. <P> A variety of DSRequest settings, such as  {@link
     * com.smartgwt.client.data.DSRequest#getExportAs exportAs} and {@link com.smartgwt.client.data.DSRequest#getExportFilename
     * exportFilename}, affect the  exporting process: see {@link com.smartgwt.client.data.DSRequest#getExportResults
     * exportResults} for further detail. <P> Note that data exported via this method does not include any client-side
     * formatting and relies on both the Smart GWT server and server-side DataSources.  To export client-data  with formatters
     * applied,  see {@link com.smartgwt.client.widgets.DataBoundComponent#exportClientData exportClientData}, which still
     * requires the Smart GWT server but does not rely on server-side DataSources. <P> For more information on exporting data,
     * see {@link com.smartgwt.client.data.DataSource#exportData DataSource.exportData}.
     */
    public native void exportData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData();
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.widgets.DataBoundComponent#getDataSource DataSource}
     * to  retrieve data that matches the current filter and sort criteria for this component, then  exports the resulting data
     * to a file or window in the requested format. <P> A variety of DSRequest settings, such as  {@link
     * com.smartgwt.client.data.DSRequest#getExportAs exportAs} and {@link com.smartgwt.client.data.DSRequest#getExportFilename
     * exportFilename}, affect the  exporting process: see {@link com.smartgwt.client.data.DSRequest#getExportResults
     * exportResults} for further detail. <P> Note that data exported via this method does not include any client-side
     * formatting and relies on both the Smart GWT server and server-side DataSources.  To export client-data  with formatters
     * applied,  see {@link com.smartgwt.client.widgets.DataBoundComponent#exportClientData exportClientData}, which still
     * requires the Smart GWT server but does not rely on server-side DataSources. <P> For more information on exporting data,
     * see {@link com.smartgwt.client.data.DataSource#exportData DataSource.exportData}.
     * @param requestProperties additional properties to set on the DSRequest                                            that will be issued
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void exportData(DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData(requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
    
   /**
    * Exports this component's data with client-side formatters applied, so is suitable for 
    * direct display to users.  This feature requires the SmartClient server, but does not 
    * rely on any server-side DataSources.
    * <P>To export unformatted data from this component's dataSource, see 
    * {@link com.smartgwt.client.widgets.DataBoundComponent#exportData exportData}
    * which does not include client-side formatters, 
    * but relies on both the SmartClient server and server-side DataSources.
    * @see com.smartgwt.client.data.DataSource#exportClientData
    */
    public native void exportClientData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportClientData();
    }-*/;

   /**
    * Exports this component's data with client-side formatters applied, so is suitable for 
    * direct display to users.  This feature requires the SmartClient server, but does not 
    * rely on any server-side DataSources.
    * <P>To export unformatted data from this component's dataSource, see
    * {@link com.smartgwt.client.widgets.DataBoundComponent#exportData exportData}
    * which does not include client-side formatters, 
    * but relies on both the SmartClient server and server-side DataSources.
    * @param requestProperties Request properties for the export
    * @see com.smartgwt.client.data.DataSource#exportClientData
    */
    public native void exportClientData(DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportClientData(requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Add a fetchData handler.
     * <p>
     * Notification function fired on fetchData() or filterData()
     *
     * @param handler the filterData handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFetchDataHandler(FetchDataHandler handler) {
        if(getHandlerCount(FetchDataEvent.getType()) == 0) setupFetchDataEvent();
        return doAddHandler(handler, FetchDataEvent.getType());
    }

    private native void setupFetchDataEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onFetchData:$debox($entry(function(){
                    var param = {"criteria" : arguments[0], "requestProperties" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.events.FetchDataEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onFetchData = $debox($entry(function(){
                var param = {"criteria" : arguments[0], "requestProperties" : arguments[1]};
                var event = @com.smartgwt.client.widgets.events.FetchDataEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

}




