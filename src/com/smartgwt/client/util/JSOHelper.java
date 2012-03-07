/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.util;

import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

import com.smartgwt.client.core.BaseClass;
import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.core.Function;
import com.smartgwt.client.core.RefDataClass;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ValueEnum;
import com.smartgwt.client.widgets.BaseWidget;

/**
 * Internal helper class.
 */
public class JSOHelper {

    private JSOHelper() { }

    /**
     * Evaluate the passed string as Javascript.
     *
     * @param   jsFrag  the string to evaluate
     *
     * @return  the JavaScriptObject upon evaluation
     */
    public static native JavaScriptObject eval(String jsFrag) /*-{
        if(!($wnd.isc.startsWith(jsFrag, '(') && $wnd.isc.endsWith(jsFrag, ')'))) {
        jsFrag = '(' + jsFrag + ')';
        }
        return $wnd.isc.Class.evaluate(jsFrag);
    }-*/;

    public static boolean isJSO(final Object object) {
        return object instanceof JavaScriptObject;
    }

    private static class MockJavaScriptObject extends JavaScriptObject {
        // empty

        private Map<String, Object> attributes = new HashMap<String, Object>();

    }

    private static Map<JavaScriptObject, Map<String, Object>> attributes;
    private static Map<JavaScriptObject, Object> arrayEntries;

    static {
        attributes = new WeakHashMap<JavaScriptObject, Map<String, Object>>();
        arrayEntries = new WeakHashMap<JavaScriptObject, Object>();
    }

    private static Map<String, Object> getAttributes(final JavaScriptObject obj) {
        if (obj instanceof MockJavaScriptObject) {
            return ((MockJavaScriptObject) obj).attributes;
        }

        Map<String, Object> map = attributes.get(obj);
        if (map == null) {
            map = new HashMap<String, Object>();
            attributes.put(obj, map);
        }

        return map;
    }

    public static String getAttribute(final JavaScriptObject elem, final String attr) /*-{
        var ret = elem[attr];
        return (ret === undefined || ret == null) ? null : String(ret);
    }-*/ {
        Object value = getAttributes(elem).get(attr);
        if (value != null) {
            return String.valueOf(value);
        }

        return null;
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final String value) /*-{
        elem[attr] = value;
    }-*/ {
        getAttributes(elem).put(attr, value);
    }

    public static JavaScriptObject getAttributeAsJavaScriptObject(final JavaScriptObject elem, final String attr) /*-{
        var ret = elem[attr];
        return (ret === undefined) ? null : ret;
    }-*/ {
        return (JavaScriptObject) getAttributes(elem).get(attr);
    }

    public static JavaScriptObject[] getAttributeAsJavaScriptObjectArray(final JavaScriptObject elem,
            final String attr) /*-{
        var arrayJS = elem[attr];
        return (arrayJS === undefined) ? null : @com.smartgwt.client.util.JSOHelper::toArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrayJS);
    }-*/ {

        // TODO: do we need some conversion here?
        return (JavaScriptObject[]) getAttributes(elem).get(attr);
    }

    // TODO: how could one implement this? Where is it used?
    public static JavaScriptObject[] toArray(JavaScriptObject array) {

        // handle case where a ResultSet is passed
        if (com.smartgwt.client.data.ResultSet.isResultSet(array)) {
            array = JSOHelper.resultSetToArray(array);
        }

        int length = getJavaScriptObjectArraySize(array);
        JavaScriptObject[] recs = new JavaScriptObject[length];
        for (int i = 0; i < length; i++) {
            recs[i] = getValueFromJavaScriptObjectArray(array, i);
        }

        return recs;
    }

    private static native JavaScriptObject resultSetToArray(JavaScriptObject rs) /*-{
        if (!rs.lengthIsKnown() || !rs.allMatchingRowsCached()) return $wnd.Array.create();
        return rs.getRange(0, rs.getLength());
        
    }-*/;

    // TODO: how could one implement this? Where is it used?
    public static native boolean isArray(JavaScriptObject jsObj) /*-{
        return $wnd.isc.isA.Array(jsObj);
    }-*/;

    public static Element[] toElementArray(final JavaScriptObject array) {
        int length = getJavaScriptObjectArraySize(array);
        Element[] recs = new Element[length];
        for (int i = 0; i < length; i++) {
            recs[i] = getElementValueFromJavaScriptObjectArray(array, i);
        }

        return recs;
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final JavaScriptObject[] value) /*-{
        elem[attr] = value;
    }-*/ {
        getAttributes(elem).put(attr, value);
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final int[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final double[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final String[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final Integer[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final Float[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final Boolean[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final Double[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final Long[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final Date[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final ValueEnum[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final Object value) /*-{
        elem[attr] = value;
    }-*/ {
        getAttributes(elem).put(attr, value);
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final JavaScriptObject value) /*-{
        elem[attr] = value;
    }-*/ {
        getAttributes(elem).put(attr, value);
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final int value) /*-{
        elem[attr] = value;
    }-*/ {
        getAttributes(elem).put(attr, value);
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final long value) {
        setAttribute(elem, attr, new Double(value).doubleValue());
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final Integer value) {
        if (value == null) {
            setNullAttribute(elem, attr);
        } else {
            setAttribute(elem, attr, value.intValue());
        }
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final Double value) {
        if (value == null) {
            setNullAttribute(elem, attr);
        } else {
            setAttribute(elem, attr, value.doubleValue());
        }
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final Float value) {
        if (value == null) {
            setNullAttribute(elem, attr);
        } else {
            setAttribute(elem, attr, value.floatValue());
        }
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final Boolean value) {
        if (value == null) {
            setNullAttribute(elem, attr);
        } else {
            setAttribute(elem, attr, value.booleanValue());
        }
    }

    public static void setNullAttribute(final JavaScriptObject elem, final String attr) /*-{
        elem[attr] = null;
    }-*/ {
        getAttributes(elem).put(attr, null);
    }

    public static void deleteAttribute(final JavaScriptObject elem, final String attr) /*-{
        delete elem[attr];
    }-*/ {
        getAttributes(elem).remove(attr);
    }

    public static void deleteAttributeIfExists(final JavaScriptObject elem, final String attr) /*-{
        var undef;
        if (elem[attr] !== undef) delete elem[attr];
    }-*/ {
        getAttributes(elem).remove(attr);
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final boolean value) /*-{
        elem[attr] = value;
    }-*/ {
        getAttributes(elem).put(attr, value);
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final float value) /*-{
        elem[attr] = value;
    }-*/ {
        getAttributes(elem).put(attr, value);
    }

    public static void setAttribute(final JavaScriptObject elem, final String attr, final double value) /*-{
        elem[attr] = value;
    }-*/ {
        getAttributes(elem).put(attr, value);
    }

    public static native void setAttribute(JavaScriptObject elem, String attr, Function handler) /*-{
        elem[attr] = function() {
        handler.@com.smartgwt.client.core.Function::execute()();
        };
    }-*/;

    public static void setAttribute(final JavaScriptObject elem, final String attr, final Date value) {
        if (value == null) {
            setAttribute(elem, attr, (String) null);
        } else {
            setDateAttribute(elem, attr, value.getTime());
        }
    }

    private static native void setDateAttribute(JavaScriptObject elem, String attr, double time) /*-{
        var dateJS = $wnd.Date.create();
        dateJS.setTime(time);
        elem[attr] = dateJS;
    }-*/;

    public static void setObjectAttribute(final JavaScriptObject elem, final String attr, final Object object) /*-{
        elem[attr] = object;
    }-*/ {
        getAttributes(elem).put(attr, object);
    }

    public static Element getAttributeAsElement(final JavaScriptObject elem, final String attr) /*-{
        var ret = elem[attr];
        return (ret === undefined) ? null : ret;
    }-*/ {
        return (Element) getAttributes(elem).get(attr);
    }

    public static Integer getAttributeAsInt(final JavaScriptObject elem, final String attr) /*-{
        var ret = elem[attr];
        return (ret === undefined || ret == null) ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/ {

        // TODO: do we need conversion here?
        return (Integer) getAttributes(elem).get(attr);
    }

    public static Double getAttributeAsDouble(final JavaScriptObject elem, final String attr) /*-{
        var ret = elem[attr];
        if (ret === undefined || ret == null) {
        return null;
        } else {
        if(typeof ret == "object") {
        return ret;
        } else {
        return  @com.smartgwt.client.util.JSOHelper::toDouble(D)(ret);
        }
        }
    }-*/ {

        // TODO: do we need conversion here?
        return (Double) getAttributes(elem).get(attr);
    }

    public static Date getAttributeAsDate(final JavaScriptObject elem, final String attr) /*-{
        var ret = elem[attr];
        return (ret === undefined || ret == null) ? null: @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/ {

        // TODO: do we need conversion here?
        return (Date) getAttributes(elem).get(attr);
    }

    public static Float getAttributeAsFloat(final JavaScriptObject elem, final String attr) /*-{
        var ret = elem[attr];
        return (ret === undefined || ret == null) ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(ret);
    }-*/ {

        // TODO: do we need conversion here?
        return (Float) getAttributes(elem).get(attr);
    }

    public static int[] getAttributeAsIntArray(final JavaScriptObject elem, final String attr) {
        int[] rtn = null;
        JavaScriptObject hold = getAttributeAsJavaScriptObject(elem, attr);

        if (hold != null) {
            rtn = new int[getJavaScriptObjectArraySize(hold)];

            for (int i = 0; i < rtn.length; i++) {
                rtn[i] = getIntValueFromJavaScriptObjectArray(hold, i);
            }
        }

        return rtn;
    }

    public static double[] getAttributeAsDoubleArray(final JavaScriptObject elem, final String attr) {
        double[] rtn = null;
        JavaScriptObject hold = getAttributeAsJavaScriptObject(elem, attr);

        if (hold != null) {
            rtn = new double[getJavaScriptObjectArraySize(hold)];

            for (int i = 0; i < rtn.length; i++) {
                rtn[i] = getDoubleValueFromJavaScriptObjectArray(hold, i);
            }
        }

        return rtn;
    }

    public static String[] getAttributeAsStringArray(final JavaScriptObject elem, final String attr) {
        String[] rtn = null;
        JavaScriptObject hold = getAttributeAsJavaScriptObject(elem, attr);

        if (hold != null) {
            rtn = new String[getJavaScriptObjectArraySize(hold)];

            for (int i = 0; i < rtn.length; i++) {
                rtn[i] = getStringValueFromJavaScriptObjectArray(hold, i);
            }
        }

        return rtn;
    }

    public static int getJavaScriptObjectArraySize(final JavaScriptObject elem) /*-{
        var length;
        if (elem) length = elem.length;
        if (length == null) length = 0;
        return length;
    }-*/ {
        Object array = arrayEntries.get(elem);
        if (array == null) {
            return 0;
        }

        return Array.getLength(array);
    }

    public static int getIntValueFromJavaScriptObjectArray(final JavaScriptObject elem, final int i) /*-{
        return elem[i];
    }-*/ {
        return ((int[]) arrayEntries.get(elem))[i];
    }

    public static double getDoubleValueFromJavaScriptObjectArray(final JavaScriptObject elem, final int i) /*-{
        return elem[i];
    }-*/ {
        return ((double[]) arrayEntries.get(elem))[i];
    }

    public static String getStringValueFromJavaScriptObjectArray(final JavaScriptObject elem, final int i) /*-{
        return elem[i];
    }-*/ {
        return ((String[]) arrayEntries.get(elem))[i];
    }

    public static JavaScriptObject getValueFromJavaScriptObjectArray(final JavaScriptObject elem, final int i) /*-{
        return elem[i];
    }-*/ {
        return ((JavaScriptObject[]) arrayEntries.get(elem))[i];
    }

    public static boolean getAttributeAsBoolean(final JavaScriptObject elem, final String attr) /*-{
        var ret = elem[attr];
        return (ret == null || ret === undefined) ? false : ret;
    }-*/ {
        Object val = getAttributes(elem).get(attr);
        return val != null && ((Boolean) val).booleanValue();
    }

    public static Object getAttributeAsObject(final JavaScriptObject elem, final String attr) /*-{
        var ret = elem[attr];
        return (ret === undefined) ? null : ret;
    }-*/ {
        return getAttributes(elem).get(attr);
    }

    public static Map getAttributeAsMap(final JavaScriptObject elem, final String attr) {
        JavaScriptObject value = getAttributeAsJavaScriptObject(elem, attr);
        if (value == null) {
            return null;
        }

        return convertToMap(value);
    }

    public static JavaScriptObject[] listToArray(final List list) {
        JavaScriptObject[] array = new JavaScriptObject[list.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = (JavaScriptObject) list.get(i);
        }

        return array;
    }

    public static JavaScriptObject arrayConvert(final Object[] array) {
        if (array == null) {
            return null;
        }

        JavaScriptObject result = newJSArray(array.length);

        for (int i = 0; i < array.length; i++) {
            arraySet(result, i, array[i]);
        }

        return result;
    }

    public static JavaScriptObject arrayConvert(final JavaScriptObject[] array) {
        if (array == null) {
            return null;
        }

        JavaScriptObject result = newJSArray(array.length);

        for (int i = 0; i < array.length; i++) {
            arraySet(result, i, array[i]);
        }

        return result;
    }

    // TODO
    private static native JavaScriptObject newJSArray(int length) /*-{
        if (length < 0) {
        return $wnd.Array.create();
        } else {
        var arr = $wnd.Array.create();
        arr.setLength(length);
        return arr;
        }
    }-*/;

    public static int arrayLength(final JavaScriptObject array) /*-{
        return array.length;
    }-*/ {
        return Array.getLength(arrayEntries.get(array));
    }

    public static Object arrayGetObject(final JavaScriptObject array, final int index) /*-{
        return array[index];
    }-*/ {
        return ((Object[]) arrayEntries.get(array))[index];
    }

    public static void arraySet(final JavaScriptObject array, final int index, final Object value) /*-{
        array[index] = value;
    }-*/ {
        ((Object[]) arrayEntries.get(array))[index] = value;
    }

    public static void arraySet(final JavaScriptObject array, final int index, final JavaScriptObject value) /*-{
        array[index] = value;
    }-*/ {
        ((Object[]) arrayEntries.get(array))[index] = value;
    }

    /**
     * This is used to access Element array as JavaScriptObject.
     */
    public static native Element getElementValueFromJavaScriptObjectArray(JavaScriptObject elem, int i) /*-{
        return elem[i];
    }-*/;

    public static JavaScriptObject createObject() /*-{
        return new Object;
    }-*/ {
        return new MockJavaScriptObject();
    }

    public static JavaScriptObject convertToJavaScriptArray(final int[] array) {
        if (array == null) {
            return null;
        }

        JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; i++) {
            JSOHelper.setArrayValue(jsArray, i, array[i]);
        }

        return jsArray;
    }

    public static JavaScriptObject convertToJavaScriptArray(final double[] array) {
        if (array == null) {
            return null;
        }

        JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; i++) {
            JSOHelper.setArrayValue(jsArray, i, array[i]);
        }

        return jsArray;
    }

    public static JavaScriptObject convertToJavaScriptArray(final long[] array) {
        if (array == null) {
            return null;
        }

        JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; i++) {
            JSOHelper.setArrayValue(jsArray, i, array[i]);
        }

        return jsArray;
    }

    private static void doAddToMap(final Map map, final String key, final Object value) {
        map.put(key, value);
    }

    /**
     * Convert a JavaScriptObject to the appropriate type of JavaObject. Simple JavaScript objects (key:value pairs)
     * will be converted to Map instances. JavaScript Arrays will be returned as a List or an Object Array depending on
     * the listAsArray parameter Conversion is recursive, nested JavaScript objects and arrays will have their members
     * converted as well JavaScript dates will be returned as Java Dates Simple Javascript types such as integers,
     * floats and strings will be returned as the equivalent java object class (String, Integer, etc)
     *
     * @param   object       JavaScriptObject to convert
     * @param   listAsArray  Should arrays be converted to Object[] or List
     *
     * @return  converted Java object. May be a Map, a List or an Object[] depending on the underlying JS type.
     */
    public static native Object convertToJava(JavaScriptObject object, boolean listAsArray) /*-{
        return $wnd.SmartGWT.convertToJavaObject(object, listAsArray);
    }-*/;

    public static Object convertToJava(final JavaScriptObject object) {
        return convertToJava(object, false);
    }

    /**
     * Convert a Javascript object containing key:value pairs to a Map.
     *
     * @param   jsObj        the javascript object
     * @param   listAsArray  Should arrays be converted to Object[] or List
     *
     * @return  the map
     *
     * @throws  IllegalArgumentException  if unable to convert pass JavaScript object to a map
     */
    public static Map convertToMap(final JavaScriptObject jsObj, final boolean listAsArray) {
        return new HashMap<String, Object>(getAttributes(jsObj));
    }

    /**
     * Convert a Javascript object containing key:value pairs to a Map.
     *
     * @param   jsObj  the javascript object
     *
     * @return  the map
     *
     * @throws  IllegalArgumentException  if unable to convert pass JavaScript object to a map
     */
    public static Map convertToMap(final JavaScriptObject jsObj) {
        return convertToMap(jsObj, false);
    }

    /**
     * Convert a Javascript object to an Object[]. If the Javascript object is not an array in Javascript, a new array
     * will be created containing the converted object as the only entry.
     *
     * @param   object
     *
     * @return
     */
    public static Object[] convertToArray(final JavaScriptObject object) {
        Object javaObj = convertToJava(object, true);
        if (!(javaObj instanceof Object[])) {
            javaObj = new Object[] {javaObj};
        }

        return (Object[]) javaObj;
    }

    /**
     * Convert a Javascript object to a List. If the Javascript object is not an array in Javascript, a new List will be
     * created containing the converted object as the only entry.
     *
     * @param   object
     *
     * @return
     */
    public static List convertToList(final JavaScriptObject object) {
        Object javaObj = convertToJava(object, false);
        if (!(javaObj instanceof List)) {
            List list = new ArrayList();
            list.add(javaObj);
            javaObj = list;
        }

        return (List) javaObj;
    }

    public static JavaScriptObject convertToJavaScriptDate(final Date date) {
        if (date == null) {
            return null;
        }

        JavaScriptObject dateJS = doConvertToJavaScriptDate(date.getTime());
        return dateJS;
    }

    // explicitly cast Object to String to workaround GWT hosted mode but in certain browsers when originating string
    // is obtained
    // by calling object.toString(). http://code.google.com/p/google-web-toolkit/issues/detail?id=4301
    public static String convertToString(final Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        } else {
            throw new IllegalArgumentException("Object " + obj + " is not of type String");
        }
    }

    /**
     * @param   obj  the object
     *
     * @return  true if object is a Java Date
     */
    public static boolean isJavaDate(final Object obj) {
        return obj instanceof Date;
    }

    /**
     * @param   obj  the object
     *
     * @return  true if object is a Java Number
     */
    public static boolean isJavaNumber(final Object obj) {
        return obj instanceof Number;
    }

    /**
     * @param   obj  the object
     *
     * @return  true if object is a Java Integer
     */
    public static boolean isJavaInteger(final Object obj) {
        return obj instanceof Integer;
    }

    /**
     * @param   obj  the object
     *
     * @return  true if object is a Java Float
     */
    public static boolean isJavaFloat(final Object obj) {
        return obj instanceof Float;
    }

    /**
     * @param   obj  the object
     *
     * @return  true if object is a Java Double
     */
    public static boolean isJavaDouble(final Object obj) {
        return obj instanceof Double;
    }

    /**
     * @param   obj  the object
     *
     * @return  true if object is a Java String
     */
    public static boolean isJavaString(final Object obj) {
        return obj instanceof String;
    }

    /**
     * @param   obj  the object
     *
     * @return  true if object is a Java Integer
     */
    public static boolean isJavaBoolean(final Object obj) {
        return obj instanceof Boolean;
    }

    private static native JavaScriptObject doConvertToJavaScriptDate(double time) /*-{
        var dateJS = $wnd.Date.create();
        dateJS.setTime(time);
        return dateJS;
    }-*/;

    public static JavaScriptObject convertToJavaScriptArray(final Object[] array) {
        if (array == null) {
            return null;
        }

        JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; i++) {
            Object val = array[i];

            if (val instanceof String) {
                JSOHelper.setArrayValue(jsArray, i, (String) val);
            } else if (val instanceof Integer) {
                JSOHelper.setArrayValue(jsArray, i, ((Integer) val).intValue());
            } else if (val instanceof Float) {
                JSOHelper.setArrayValue(jsArray, i, ((Float) val).floatValue());
            } else if (val instanceof Double) {
                JSOHelper.setArrayValue(jsArray, i, ((Double) val).doubleValue());
            } else if (val instanceof Long) {
                JSOHelper.setArrayValue(jsArray, i, ((Long) val).doubleValue());
            } else if (val instanceof Boolean) {
                JSOHelper.setArrayValue(jsArray, i, ((Boolean) val).booleanValue());
            } else if (val instanceof Date) {
                JSOHelper.setArrayValue(jsArray, i, (Date) val);
            } else if (val instanceof ValueEnum) {
                JSOHelper.setArrayValue(jsArray, i, ((ValueEnum) val).getValue());
            } else if (val instanceof JavaScriptObject) {
                JSOHelper.setArrayValue(jsArray, i, ((JavaScriptObject) val));
            } /*else if (val instanceof JsObject) {
               * JSOHelper.setArrayValue(jsArray, i, ((JsObject) val).getJsObj());
               *} */
            else if (val instanceof DataClass) {
                JSOHelper.setArrayValue(jsArray, i, ((DataClass) val).getJsObj());
            } else if (val instanceof BaseClass) {
                JSOHelper.setArrayValue(jsArray, i, ((BaseClass) val).getJsObj());
            } else if (val instanceof BaseWidget) {
                JSOHelper.setArrayValue(jsArray, i, ((BaseWidget) val).getOrCreateJsObj());
            } else if (val instanceof Record) {
                JSOHelper.setArrayValue(jsArray, i, ((Record) val).getJsObj());
            } else if (val instanceof Object[]) {
                JSOHelper.setArrayValue(jsArray, i, convertToJavaScriptArray((Object[]) val));
            } else if (val instanceof Map) {
                JSOHelper.setArrayValue(jsArray, i, convertMapToJavascriptObject((Map) val));
            } else if (val instanceof Object) {
                JSOHelper.setArrayValue(jsArray, i, val);
            }
        }

        return jsArray;

    }

    public static Integer toInteger(final int value) {
        return value;
    }

    public static Long toLong(final double value) {
        return (long) value;
    }

    public static Float toFloat(final float value) {
        return value;
    }

    public static Double toDouble(final double value) {
        return value;
    }

    private static double getTime(final Date date) {
        return date.getTime();
    }

    public static Date toDate(final double millis) {
        return new Date((long) millis);
    }

    public static native JavaScriptObject toDateJS(Date date) /*-{
        var dateJS = $wnd.Date.create();
        dateJS.setTime(@com.smartgwt.client.util.JSOHelper::getTime(Ljava/util/Date;)(date));
        return dateJS;
    }-*/;

    public static Boolean toBoolean(final boolean value) {
        return value;
    }

    public static native JavaScriptObject createJavaScriptArray() /*-{
        //Important : constructing an from JSNI array using [] or new Array() results in a
        //corrupted array object in the final javascript. The array ends up having the correct elements
        //but the test (myarr instaneof Array) fails because the jsni created array constructor is different.
        //Need to construct array within the scope of the applications iframe by using new $wnd.Array
        return $wnd.Array.create();
    }-*/;

    public static void setArrayValue(final JavaScriptObject array, final int index, final Date value) {
        if (value == null) {
            setArrayValue(array, index, (String) null);
        } else {
            setArrayDateValue(array, index, value.getTime());
        }
    }

    private static native void setArrayDateValue(JavaScriptObject array, int index, double time) /*-{
        var dateJS = $wnd.Date.create();
        dateJS.setTime(time);
        array[index] = dateJS;
    }-*/;

    public static void setArrayValue(final JavaScriptObject array, final int index, final String value) /*-{
        array[index] = value;
    }-*/ {
        ((String[]) arrayEntries.get(array))[index] = value;
    }

    public static void setArrayValue(final JavaScriptObject array, final int index, final double value) /*-{
        array[index] = value;
    }-*/ {
        ((double[]) arrayEntries.get(array))[index] = value;
    }

    public static void setArrayValue(final JavaScriptObject array, final int index, final long value) {
        Double doubleValue = new Double(value);
        setArrayValue(array, index, doubleValue.doubleValue());
    }

    public static void setArrayValue(final JavaScriptObject array, final int index, final int value) /*-{
        array[index] = value;
    }-*/ {
        ((int[]) arrayEntries.get(array))[index] = value;
    }

    public static void setArrayValue(final JavaScriptObject array, final int index, final float value) /*-{
        array[index] = value;
    }-*/ {
        ((float[]) arrayEntries.get(array))[index] = value;
    }

    public static void setArrayValue(final JavaScriptObject array, final int index, final boolean value) /*-{
        array[index] = value;
    }-*/ {
        ((boolean[]) arrayEntries.get(array))[index] = value;
    }

    public static void setArrayValue(final JavaScriptObject array, final int index, final JavaScriptObject value) /*-{
        array[index] = value;
    }-*/ {
        ((JavaScriptObject[]) arrayEntries.get(array))[index] = value;
    }

    public static void setArrayValue(final JavaScriptObject array, final int index, final Object value) /*-{
        array[index] = value;
    }-*/ {
        ((Object[]) arrayEntries.get(array))[index] = value;
    }

    public static String getArrayValue(final JavaScriptObject array, final int index) /*-{
        var result = array[index];
        return (result == null || result === undefined) ? null : result;
    }-*/ {

        // TODO: special-handling for undefined/NullPointerException?
        return ((String[]) arrayEntries.get(array))[index];
    }

    public static JavaScriptObject getJSOArrayValue(final JavaScriptObject array, final int index) /*-{
        var result = array[index];
        return (result == null || result === undefined) ? null : result;
    }-*/ {

        // TODO: special-handling for undefined/NullPointerException?
        return ((JavaScriptObject[]) arrayEntries.get(array))[index];
    }

    public static Object getObjectArrayValue(final JavaScriptObject array, final int index) /*-{
        var result = array[index];
        return (result == null || result === undefined) ? null : result;
    }-*/ {

        // TODO: special-handling for undefined/NullPointerException?
        return ((Object[]) arrayEntries.get(array))[index];
    }

    public static int getIntArrayValue(final JavaScriptObject array, final int index) /*-{
        return array[index];
    }-*/ {

        // TODO: special-handling for undefined/NullPointerException?
        return ((int[]) arrayEntries.get(array))[index];
    }

    public static Integer getIntegerArrayValue(final JavaScriptObject array, final int index) /*-{
        var ret = array[index];
        return (ret === undefined || ret == null) ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/ {

        // TODO: special-handling for undefined/NullPointerException?
        return ((int[]) arrayEntries.get(array))[index];
    }

    public static Float getFloatArrayValue(final JavaScriptObject array, final int index) /*-{
        var ret = array[index];
        return (ret === undefined || ret == null) ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(ret);
    }-*/ {

        // TODO: special-handling for undefined/NullPointerException?
        return ((float[]) arrayEntries.get(array))[index];
    }

    public static int getArrayLength(final JavaScriptObject array) /*-{
        return array.length;
    }-*/ {
        return Array.getLength(arrayEntries.get(array));
    }

    public static int[] convertToJavaIntArray(final JavaScriptObject array) {
        int length = getArrayLength(array);
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getIntArrayValue(array, i);
        }

        return arr;
    }

    public static Integer[] convertToJavaInterArray(final JavaScriptObject array) {
        int length = getArrayLength(array);
        Integer[] arr = new Integer[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getIntegerArrayValue(array, i);
        }

        return arr;
    }

    public static String[] convertToJavaStringArray(final JavaScriptObject array) {
        if (array == null) {
            return new String[] {};
        }

        int length = getArrayLength(array);
        String[] arr = new String[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getArrayValue(array, i);
        }

        return arr;
    }

    public static Float[] convertToJavaFloatArray(final JavaScriptObject array) {
        int length = getArrayLength(array);
        Float[] arr = new Float[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getFloatArrayValue(array, i);
        }

        return arr;
    }

    public static Object[] convertToJavaObjectArray(final JavaScriptObject array) {
        if (array == null) {
            return new Object[] {};
        }

        int length = getArrayLength(array);
        Object[] arr = new Object[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getObjectArrayValue(array, i);
        }

        return arr;
    }

    public static RefDataClass[] convertToJavaRefDataClassArray(final JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new RefDataClass[] {};
        }

        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        RefDataClass[] objects = new RefDataClass[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            RefDataClass obj = RefDataClass.getRef(componentJS);
            objects[i] = obj;
        }

        return objects;
    }

    public static void apply(final JavaScriptObject config, final JavaScriptObject jsObj) /*-{
        for(var k in config) {
        jsObj[k] = config[k];
        }
    }-*/ {
        getAttributes(jsObj).putAll(getAttributes(config));
    }

    public static void setAttribute(final JavaScriptObject jsObj, final String attr, final Map valueMap) {
        JavaScriptObject valueJS = convertMapToJavascriptObject(valueMap);
        setAttribute(jsObj, attr, valueJS);
    }

    public static JavaScriptObject convertMapToJavascriptObject(final Map valueMap) {
        if (valueMap == null) {
            return null;
        }

        JavaScriptObject valueJS = JSOHelper.createObject();
        for (Iterator iterator = valueMap.keySet().iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            if (key == null) {
                SC.logWarn("JSO::convertMapToJavascriptObject : Map contains null key - dropping this entry.");
                continue;
            }

            if (key.equals("__ref")) {
                SC.logWarn("JSO::convertMapToJavascriptObject : skipping __ref in map");
                continue;
            }

            Object value = valueMap.get(key);

            if (value instanceof JavaScriptObject) {
                setAttribute(valueJS, key, (JavaScriptObject) value);
            } else if (value instanceof Date) {
                setAttribute(valueJS, key, ((Date) value));
            } else if (value instanceof Number) {
                setAttribute(valueJS, key, ((Number) value).doubleValue());
            } else if (value instanceof String) {
                setAttribute(valueJS, key, ((String) value));
            } else if (value instanceof Boolean) {
                setAttribute(valueJS, key, ((Boolean) value).booleanValue());
            } else if (value == null) {
                setNullAttribute(valueJS, key);
            } else if (value instanceof String[]) {
                setAttribute(valueJS, key, convertToJavaScriptArray((String[]) value));
            } else if (value instanceof Map) {
                JavaScriptObject innerMapJS = convertMapToJavascriptObject((Map) value);
                setAttribute(valueJS, key, innerMapJS);
            } else if (value instanceof List) {
                setAttribute(valueJS, key, JSOHelper.convertToJavaScriptArray(((List) value).toArray()));
            } else {
                throw new IllegalArgumentException("Unsupported type for attribute " + key + " : " + value);
            }
        }

        return valueJS;
    }

    public static String[] getProperties(final JavaScriptObject jsObj) /*-{
        var props = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        for(var k in jsObj) {
        props.push(k);
        }
        return @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(props);
    }-*/ {
        return getAttributes(jsObj).keySet().toArray(new String[0]);
    }

    public static String getPropertiesAsString(final JavaScriptObject jsObj) /*-{
        var props = '{';
        for(var k in jsObj) {
        props += '\n' + k;
        }
        return props + '}';
    }-*/ {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (String attr : getAttributes(jsObj).keySet()) {
            sb.append("\n" + attr);
        }

        sb.append("}");
        return sb.toString();
    }

    /**
     * Adds all properties and methods from the propertiesObject to the destination object.
     *
     * @param  destination       the destination object
     * @param  propertiesObject  the propertiesObject
     */
    public static void addProperties(final JavaScriptObject destination, final JavaScriptObject propertiesObject) /*-{
        $wnd.isc.addProperties(destination, propertiesObject);
    }-*/ {

        // TODO: methods?
        getAttributes(destination).putAll(getAttributes(propertiesObject));
    }
}
