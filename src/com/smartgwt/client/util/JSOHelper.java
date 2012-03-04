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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.core.BaseClass;
import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.core.Function;
import com.smartgwt.client.core.RefDataClass;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.ResultSet;
import com.smartgwt.client.types.ValueEnum;
import com.smartgwt.client.widgets.BaseWidget;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Internal helper class.
 */
public class JSOHelper {

    private JSOHelper() {
    }

    /**
     * Evaluate the passed string as Javascript
     *
     * @param jsFrag the string to evaluate
     * @return the JavaScriptObject upon evaluation
     */
    public static native JavaScriptObject eval(String jsFrag) /*-{
		if(!($wnd.isc.startsWith(jsFrag, '(') && $wnd.isc.endsWith(jsFrag, ')'))) {
            jsFrag = '(' + jsFrag + ')';
        }
        return $wnd.isc.Class.evaluate(jsFrag);
	}-*/;

    public static boolean isJSO(Object object) {
        return object instanceof JavaScriptObject;
    }

    private static Map<JavaScriptObject, Map<String, Object>> attributes;
    private static Map<JavaScriptObject, Object> arrayEntries;

    static {
	attributes = new WeakHashMap<JavaScriptObject, Map<String, Object>>();
	arrayEntries = new WeakHashMap<JavaScriptObject, Object>();
    }

    private static Map<String, Object> getAttributes(JavaScriptObject obj) {
	Map<String, Object> map = attributes.get(obj);
	if(map == null) {
	    map = new HashMap<String, Object>();
	    attributes.put(obj, map);
	}
	return map;
    }

    
    public static String getAttribute(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined || ret == null) ? null : String(ret);
    }-*/
    {
	Object value = getAttributes(elem).get(attr);
	if(value != null) {
	    return String.valueOf(value);
	}
	return null;
    }

    public static void setAttribute(JavaScriptObject elem, String attr, String value) /*-{
	    elem[attr] = value;
    }-*/
    {
	getAttributes(elem).put(attr, value);
    }

    public static JavaScriptObject getAttributeAsJavaScriptObject(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined) ? null : ret;
    }-*/
    {
	return (JavaScriptObject)getAttributes(elem).get(attr);
    }

    public static JavaScriptObject[] getAttributeAsJavaScriptObjectArray(JavaScriptObject elem, String attr) /*-{        
        var arrayJS = elem[attr];
	    return (arrayJS === undefined) ? null : @com.smartgwt.client.util.JSOHelper::toArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrayJS);
    }-*/
    {
	// TODO: do we need some conversion here?
	return (JavaScriptObject[])getAttributes(elem).get(attr);
    }

    // TODO: how could one implement this? Where is it used?
    public static JavaScriptObject[] toArray(JavaScriptObject array) {
        //handle case where a ResultSet is passed
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
    public static native boolean isArray(JavaScriptObject jsObj)/*-{
        return $wnd.isc.isA.Array(jsObj);
    }-*/;
    
    public static Element[] toElementArray(JavaScriptObject array) {
        int length = getJavaScriptObjectArraySize(array);
        Element[] recs = new Element[length];
        for (int i = 0; i < length; i++) {
            recs[i] = getElementValueFromJavaScriptObjectArray(array, i);
        }
        return recs;
    }

    public static void setAttribute(JavaScriptObject elem, String attr, JavaScriptObject[] value) /*-{
	    elem[attr] = value;
    }-*/
    {
	getAttributes(elem).put(attr, value);
    }

    public static void setAttribute(JavaScriptObject elem, String attr, int[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, double[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, String[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, Integer[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, Float[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, Boolean[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, Double[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }
    public static void setAttribute(JavaScriptObject elem, String attr, Long[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, Date[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, ValueEnum[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, Object value) /*-{
        elem[attr] = value;
    }-*/
    {
	getAttributes(elem).put(attr, value);
    }

    public static void setAttribute(JavaScriptObject elem, String attr, JavaScriptObject value) /*-{
	    elem[attr] = value;
    }-*/
    {
	getAttributes(elem).put(attr, value);
    }


    public static void setAttribute(JavaScriptObject elem, String attr, int value) /*-{
	    elem[attr] = value;
    }-*/
    {
	getAttributes(elem).put(attr, value);
    }


    public static void setAttribute(JavaScriptObject elem, String attr, long value) {
        setAttribute(elem, attr, new Double(value).doubleValue());
    }

    public static void setAttribute(JavaScriptObject elem, String attr, Integer value) {
        if (value == null) {
            setNullAttribute(elem, attr);
        } else {
            setAttribute(elem, attr, value.intValue());
        }
    }


    public static void setAttribute(JavaScriptObject elem, String attr, Double value) {
        if (value == null) {
            setNullAttribute(elem, attr);
        } else {
            setAttribute(elem, attr, value.doubleValue());
        }
    }

    public static void setAttribute(JavaScriptObject elem, String attr, Float value) {
        if (value == null) {
            setNullAttribute(elem, attr);
        } else {
            setAttribute(elem, attr, value.floatValue());
        }
    }

    public static void setAttribute(JavaScriptObject elem, String attr, Boolean value) {
        if (value == null) {
            setNullAttribute(elem, attr);
        } else {
            setAttribute(elem, attr, value.booleanValue());
        }
    }

    public static void setNullAttribute(JavaScriptObject elem, String attr) /*-{
	    elem[attr] = null;
    }-*/
    {
	getAttributes(elem).put(attr, null);
    }

    public static void deleteAttribute(JavaScriptObject elem, String attr) /*-{
	      delete elem[attr];
    }-*/
    {
	getAttributes(elem).remove(attr);
    }

    public static void deleteAttributeIfExists(JavaScriptObject elem, String attr) /*-{
          var undef;
	      if (elem[attr] !== undef) delete elem[attr];
    }-*/
    {
	getAttributes(elem).remove(attr);
    }

    public static void setAttribute(JavaScriptObject elem, String attr, boolean value) /*-{
	    elem[attr] = value;
    }-*/
    {
	getAttributes(elem).put(attr, value);
    }

    public static void setAttribute(JavaScriptObject elem, String attr, float value) /*-{
	    elem[attr] = value;
    }-*/
    {
	getAttributes(elem).put(attr, value);
    }

    public static void setAttribute(JavaScriptObject elem, String attr, double value) /*-{
	    elem[attr] = value;
    }-*/
    {
	getAttributes(elem).put(attr, value);
    }

    public static native void setAttribute(JavaScriptObject elem, String attr, Function handler) /*-{
	    elem[attr] = function() {
            handler.@com.smartgwt.client.core.Function::execute()();
        };
    }-*/;

    public static void setAttribute(JavaScriptObject elem, String attr, Date value) {
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

    public static void setObjectAttribute(JavaScriptObject elem, String attr, Object object) /*-{
            elem[attr] = object;
    }-*/
    {
	getAttributes(elem).put(attr, value);
    }

    public static Element getAttributeAsElement(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined) ? null : ret;
    }-*/
    {
	return (Element)getAttributes(elem).get(attr);
    }

    public static Integer getAttributeAsInt(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined || ret == null) ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/
    {
	// TODO: do we need conversion here?
	return (Integer)getAttributes(elem).get(attr);
    }

    public static Double getAttributeAsDouble(JavaScriptObject elem, String attr) /*-{
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
    }-*/
    {
	// TODO: do we need conversion here?
	return (Double)getAttributes(elem).get(attr);
    }

    public static Date getAttributeAsDate(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined || ret == null) ? null: @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/
    {
	// TODO: do we need conversion here?
	return (Date)getAttributes(elem).get(attr);
    }

    public static Float getAttributeAsFloat(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined || ret == null) ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(ret);
    }-*/
    {
	// TODO: do we need conversion here?
	return (Date)getAttributes(elem).get(attr);
    }

    public static int[] getAttributeAsIntArray(JavaScriptObject elem, String attr) {
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

    public static double[] getAttributeAsDoubleArray(JavaScriptObject elem, String attr) {
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

    public static String[] getAttributeAsStringArray(JavaScriptObject elem, String attr) {
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

    public static int getJavaScriptObjectArraySize(JavaScriptObject elem) /*-{
        var length;
	    if (elem) length = elem.length;
	    if (length == null) length = 0;
	    return length;
    }-*/
    {
	Object array = arrayEntries.get(elem);
	if(array == null)
	    return 0;
	return Array.getLength(array);
    }

    public static int getIntValueFromJavaScriptObjectArray(JavaScriptObject elem, int i) /*-{
	    return elem[i];
    }-*/
    {
	return ((int[])arrayEntries.get(elem))[i];
    }

    public static double getDoubleValueFromJavaScriptObjectArray(JavaScriptObject elem, int i) /*-{
	    return elem[i];
    }-*/
    {
	return ((double[])arrayEntries.get(elem))[i];
    }

    public static String getStringValueFromJavaScriptObjectArray(JavaScriptObject elem, int i) /*-{
	    return elem[i];
    }-*/
    {
	return ((String[])arrayEntries.get(elem))[i];
    }

    public static JavaScriptObject getValueFromJavaScriptObjectArray(JavaScriptObject elem, int i) /*-{
	    return elem[i];
    }-*/
    {
	return ((JavaScriptObject[])arrayEntries.get(elem))[i];
    }

    public static boolean getAttributeAsBoolean(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret == null || ret === undefined) ? false : ret;
    }-*/
    {
	Object val = getAttributes(elem).get(attr);
	return val != null && ((Boolean)val).booleanValue();
    }

    public static Object getAttributeAsObject(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined) ? null : ret;
    }-*/
    {
	return getAttributes(elem).get(attr);
    }

    public static Map getAttributeAsMap(JavaScriptObject elem, String attr) {
	    JavaScriptObject value = getAttributeAsJavaScriptObject(elem, attr);
	    if (value == null) return null;
	    return convertToMap(value);
    }

    public static JavaScriptObject[] listToArray(List list) {
        JavaScriptObject[] array = new JavaScriptObject[list.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = (JavaScriptObject) list.get(i);
        }
        return array;
    }

    public static JavaScriptObject arrayConvert(Object[] array) {
        if(array == null) return null;
        JavaScriptObject result = newJSArray(array.length);

        for (int i = 0; i < array.length; i++) {
            arraySet(result, i, array[i]);
        }
        return result;
    }

    public static JavaScriptObject arrayConvert(JavaScriptObject[] array) {
        if(array == null) return null;
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

    public static native int arrayLength(JavaScriptObject array) /*-{
	    return array.length;
    }-*/
    {
	return Array.getLength(arrayEntries.get(array));
    }

    public static Object arrayGetObject(JavaScriptObject array, int index) /*-{
	    return array[index];
    }-*/
    {
	return ((Object[])arrayEntries.get(array))[index];
    }

    public static void arraySet(JavaScriptObject array, int index, Object value) /*-{
	    array[index] = value;
    }-*/
    {
	return ((Object[])arrayEntries.get(array))[index] = value;
    }

    public static native void arraySet(JavaScriptObject array, int index, JavaScriptObject value) /*-{
	    array[index] = value;
    }-*/
    {
	return ((Object[])arrayEntries.get(array))[index] = value;
    }

    /**
     * This is used to access Element array as JavaScriptObject
     */
    public static native Element getElementValueFromJavaScriptObjectArray(JavaScriptObject elem, int i) /*-{
    	return elem[i];
	}-*/;

    public static native JavaScriptObject createObject() /*-{
        return new Object;
    }-*/;

    public static JavaScriptObject convertToJavaScriptArray(int[] array) {
        if(array == null) return null;
        JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; i++) {
            JSOHelper.setArrayValue(jsArray, i, array[i]);
        }
        return jsArray;
    }

    public static JavaScriptObject convertToJavaScriptArray(double[] array) {
        if(array == null) return null;
        JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; i++) {
            JSOHelper.setArrayValue(jsArray, i, array[i]);
        }
        return jsArray;
    }

    public static JavaScriptObject convertToJavaScriptArray(long[] array) {
        if(array == null) return null;
        JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; i++) {
            JSOHelper.setArrayValue(jsArray, i, array[i]);
        }
        return jsArray;
    }

    private static void doAddToMap(Map map, String key, Object value) {
    	 map.put(key, value);
    }

    /**
     * Convert a JavaScriptObject to the appropriate type of JavaObject.
     * Simple JavaScript objects (key:value pairs) will be converted to Map instances.
     * JavaScript Arrays will be returned as a List or an Object Array depending on the listAsArray
     * parameter
     * Conversion is recursive, nested JavaScript objects and arrays will have their members converted
     * as well
     * JavaScript dates will be returned as Java Dates
     * Simple Javascript types such as integers, floats and strings will be returned as the equivalent
     * java object class (String, Integer, etc)
     * 
     * @param object JavaScriptObject to convert
     * @param listAsArray Should arrays be converted to Object[] or List
     * @return converted Java object. May be a Map, a List or an Object[] depending on the underlying JS
     *   type.
     */
    public native static Object convertToJava(JavaScriptObject object, boolean listAsArray) /*-{
    	return $wnd.SmartGWT.convertToJavaObject(object, listAsArray);
    }-*/;
    
    public static Object convertToJava(JavaScriptObject object) {
    	return convertToJava(object, false);
    }
    
    /**
     * Convert a Javascript object containing key:value pairs to a Map.
     * @param jsObj the javascript object
     * @param listAsArray Should arrays be converted to Object[] or List
     * @return the map
     * @throws IllegalArgumentException if unable to convert pass JavaScript object to a map
     */
    public static Map convertToMap(JavaScriptObject jsObj, boolean listAsArray) {
	return new HashMap<String, Object>(getAttributes(jsObj));
    }

    /**
     * Convert a Javascript object containing key:value pairs to a Map.
     * @param jsObj the javascript object
     * @return the map
     * @throws IllegalArgumentException if unable to convert pass JavaScript object to a map
     */
    public static Map convertToMap(JavaScriptObject jsObj)  {
    	return convertToMap(jsObj, false);
    }

    /**
     * Convert a Javascript object to an Object[]. If the Javascript object is not an array
     * in Javascript, a new array will be created containing the converted object as the only entry.
     * @param object
     * @return
     */
    public static Object[] convertToArray(JavaScriptObject object) {
    	Object javaObj = convertToJava(object, true);
    	if (!(javaObj instanceof Object[])) {
    		javaObj = new Object[] {javaObj};
    	}
    	return (Object[])javaObj;
    }
    
    /**
     * Convert a Javascript object to a List. If the Javascript object is not an array
     * in Javascript, a new List will be created containing the converted object as the only entry.
     * @param object
     * @return
     */
    public static List convertToList(JavaScriptObject object) {
    	Object javaObj = convertToJava(object, false);
    	if (!(javaObj instanceof List)) {
    		List list = new ArrayList();
    		list.add(javaObj);
    		javaObj = list;
    	}
    	return (List)javaObj;
    }
 
    public static JavaScriptObject convertToJavaScriptDate(Date date) {
        if(date == null) return null;
        JavaScriptObject dateJS = doConvertToJavaScriptDate(date.getTime());
        return dateJS;
    }

    //explicitly cast Object to String to workaround GWT hosted mode but in certain browsers when originating string is obtained
    //by calling object.toString(). http://code.google.com/p/google-web-toolkit/issues/detail?id=4301
    public static String convertToString(Object obj) {
        if(obj instanceof String) {
            return (String) obj;
        } else {
            throw new IllegalArgumentException("Object " + obj + " is not of type String");
        }
    }

    /**
     * @param obj the object
     * @return true if object is a Java Date
     */
    public static boolean isJavaDate(Object obj) {
        return obj instanceof Date;
    }

    /**
     * @param obj the object
     * @return true if object is a Java Number
     */
    public static boolean isJavaNumber(Object obj) {
        return obj instanceof Number;
    }

    /**
     * @param obj the object
     * @return true if object is a Java Integer
     */
    public static boolean isJavaInteger(Object obj) {
        return obj instanceof Integer;
    }

    /**
     * @param obj the object
     * @return true if object is a Java Float
     */
    public static boolean isJavaFloat(Object obj) {
        return obj instanceof Float;
    }

    /**
     * @param obj the object
     * @return true if object is a Java Double
     */
    public static boolean isJavaDouble(Object obj) {
        return obj instanceof Double;
    }

    /**
     * @param obj the object
     * @return true if object is a Java String
     */
    public static boolean isJavaString(Object obj) {
        return obj instanceof String;
    }

    /**
     * @param obj the object
     * @return true if object is a Java Integer
     */
    public static boolean isJavaBoolean(Object obj) {
        return obj instanceof Boolean;
    }

    private static native JavaScriptObject doConvertToJavaScriptDate(double time) /*-{
        var dateJS = $wnd.Date.create();
        dateJS.setTime(time);
        return dateJS;
    }-*/;

    public static JavaScriptObject convertToJavaScriptArray(Object[] array) {
        if(array == null) return null;
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
                JSOHelper.setArrayValue(jsArray, i, ((JsObject) val).getJsObj());
            } */
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
                JSOHelper.setArrayValue(jsArray, i, convertMapToJavascriptObject((Map)val));
            } else if (val instanceof Object) {
                JSOHelper.setArrayValue(jsArray, i, ((Object) val));
            } 
        }
        return jsArray;

    }


    public static Integer toInteger(int value) {
        return value;
    }

    public static Long toLong(double value) {
        return (long) value;
    }

    public static Float toFloat(float value) {
        return value;
    }

    public static Double toDouble(double value) {
        return value;
    }

    private static double getTime(Date date) {
        return date.getTime();
    }

    public static Date toDate(double millis) {
        return new Date((long) millis);
    }

    public static native JavaScriptObject toDateJS(Date date) /*-{
        var dateJS = $wnd.Date.create();
        dateJS.setTime(@com.smartgwt.client.util.JSOHelper::getTime(Ljava/util/Date;)(date));
        return dateJS;
    }-*/;

    public static Boolean toBoolean(boolean value) {
        return value;
    }
    
    public static native JavaScriptObject createJavaScriptArray() /*-{
        //Important : constructing an from JSNI array using [] or new Array() results in a
        //corrupted array object in the final javascript. The array ends up having the correct elements
        //but the test (myarr instaneof Array) fails because the jsni created array constructor is different.
        //Need to construct array within the scope of the applications iframe by using new $wnd.Array
        return $wnd.Array.create();
    }-*/;

    public static void setArrayValue(JavaScriptObject array, int index, Date value) {
        if(value == null) {
            setArrayValue(array, index, (String)null);
        } else {
            setArrayDateValue(array, index, value.getTime());
        }
    }

    private static native void setArrayDateValue(JavaScriptObject array, int index, double time) /*-{
        var dateJS = $wnd.Date.create();
        dateJS.setTime(time);
        array[index] = dateJS;
    }-*/;

    public static void setArrayValue(JavaScriptObject array, int index, String value) /*-{
        array[index] = value;
    }-*/
    {
	((String[])arrayEntries.get(array))[index] = value;
    }

    public static void setArrayValue(JavaScriptObject array, int index, double value) /*-{
        array[index] = value;
    }-*/
    {
	((double[])arrayEntries.get(array))[index] = value;
    }

    public static void setArrayValue(JavaScriptObject array, int index, long value) {
        Double doubleValue = new Double(value);
        setArrayValue(array, index, doubleValue.doubleValue());
    }

    public static void setArrayValue(JavaScriptObject array, int index, int value) /*-{
        array[index] = value;
    }-*/
    {
	((int[])arrayEntries.get(array))[index] = value;
    }

    public static void setArrayValue(JavaScriptObject array, int index, float value) /*-{
        array[index] = value;
    }-*/
    {
	((float[])arrayEntries.get(array))[index] = value;
    }

    public static void setArrayValue(JavaScriptObject array, int index, boolean value) /*-{
        array[index] = value;
    }-*/
    {
	((boolean[])arrayEntries.get(array))[index] = value;
    }

    public static void setArrayValue(JavaScriptObject array, int index, JavaScriptObject value) /*-{
        array[index] = value;
    }-*/
    {
	((JavaScriptObject[])arrayEntries.get(array))[index] = value;
    }

    public static void setArrayValue(JavaScriptObject array, int index, Object value) /*-{
        array[index] = value;
    }-*/
    {
	((Object[])arrayEntries.get(array))[index] = value;
    }

    public static String getArrayValue(JavaScriptObject array, int index) /*-{
        var result = array[index];
        return (result == null || result === undefined) ? null : result;
    }-*/
    {
	// TODO: special-handling for undefined/NullPointerException?
	return ((String[])arrayEntries.get(array))[index];
    }

    public static JavaScriptObject getJSOArrayValue(JavaScriptObject array, int index) /*-{
        var result = array[index];
        return (result == null || result === undefined) ? null : result;
    }-*/
    {
	// TODO: special-handling for undefined/NullPointerException?
	return ((JavaScriptObject[])arrayEntries.get(array))[index];
    }

    public static Object getObjectArrayValue(JavaScriptObject array, int index) /*-{
        var result = array[index];
        return (result == null || result === undefined) ? null : result;
    }-*/
    {
	// TODO: special-handling for undefined/NullPointerException?
	return ((Object[])arrayEntries.get(array))[index];
    }

    public static int getIntArrayValue(JavaScriptObject array, int index) /*-{
        return array[index];
    }-*/
    {
	// TODO: special-handling for undefined/NullPointerException?
	return ((int[])arrayEntries.get(array))[index];
    }

    public static Integer getIntegerArrayValue(JavaScriptObject array, int index) /*-{
        var ret = array[index];
        return (ret === undefined || ret == null) ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/
    {
	// TODO: special-handling for undefined/NullPointerException?
	return ((int[])arrayEntries.get(array))[index];
    }

    public static Float getFloatArrayValue(JavaScriptObject array, int index) /*-{
        var ret = array[index];
        return (ret === undefined || ret == null) ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(ret);
    }-*/
    {
	// TODO: special-handling for undefined/NullPointerException?
	return ((float[])arrayEntries.get(array))[index];
    }
    
    public static int getArrayLength(JavaScriptObject array) /*-{
        return array.length;
    }-*/
    {
	return Array.getLength(arrayEntries.get(array));
    }

    public static int[] convertToJavaIntArray(JavaScriptObject array) {
        int length = getArrayLength(array);
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getIntArrayValue(array, i);
        }
        return arr;
    }

    public static Integer[] convertToJavaInterArray(JavaScriptObject array) {
        int length = getArrayLength(array);
        Integer[] arr = new Integer[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getIntegerArrayValue(array, i);
        }
        return arr;
    }

    public static String[] convertToJavaStringArray(JavaScriptObject array) {
        if (array == null) return new String[]{};
        int length = getArrayLength(array);
        String[] arr = new String[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getArrayValue(array, i);
        }
        return arr;
    }

    public static Float[] convertToJavaFloatArray(JavaScriptObject array) {
        int length = getArrayLength(array);
        Float[] arr = new Float[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getFloatArrayValue(array, i);
        }
        return arr;
    }


    public static Object[] convertToJavaObjectArray(JavaScriptObject array) {
        if (array == null) return new Object[]{};
        int length = getArrayLength(array);
        Object[] arr = new Object[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getObjectArrayValue(array, i);
        }
        return arr;
    }

    public static RefDataClass[] convertToJavaRefDataClassArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new RefDataClass[]{};
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

    public static native void apply(JavaScriptObject config, JavaScriptObject jsObj) /*-{
        for(var k in config) {
            jsObj[k] = config[k];
        }
    }-*/
    {
	getAttributes(jsObj).putAll(getAttributes(config));
    }

    public static void setAttribute(JavaScriptObject jsObj, String attr, Map valueMap) {
        JavaScriptObject valueJS = convertMapToJavascriptObject(valueMap);
        setAttribute(jsObj, attr, valueJS);
    }

    public static JavaScriptObject convertMapToJavascriptObject(Map valueMap) {    	
        if(valueMap == null) return null;
        JavaScriptObject valueJS = JSOHelper.createObject();
        for (Iterator iterator = valueMap.keySet().iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            if (key == null) {
                SC.logWarn("JSO::convertMapToJavascriptObject : Map contains null key - dropping this entry.");
                continue;
            }
            if(key.equals("__ref")) {
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
            } else if(value instanceof String[]) {
                setAttribute(valueJS, key, convertToJavaScriptArray((String[]) value));
            } else if (value instanceof Map) {
            	JavaScriptObject innerMapJS = convertMapToJavascriptObject((Map) value); 
            	setAttribute(valueJS, key, innerMapJS);
            } else if (value instanceof List){
                setAttribute(valueJS, key, JSOHelper.convertToJavaScriptArray(((List)value).toArray()));
            } else {
                throw new IllegalArgumentException("Unsupported type for attribute " + key + " : " + value);
            }
        }
        return valueJS;
    }

    public static String[] getProperties(JavaScriptObject jsObj) /*-{
        var props = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        for(var k in jsObj) {
            props.push(k);
        }
        return @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(props);
    }-*/
    {
	return getAttributes(jsObj).keySet().toArray(new String[0]);
    }

    public static native String getPropertiesAsString(JavaScriptObject jsObj) /*-{        
        var props = '{';
        for(var k in jsObj) {
            props += '\n' + k;
        }
        return props + '}';
    }-*/
    {
	StringBuilder sb = new StringBuilder();
	sb.append("{");
	for(String attr : getAttributes(jsObj).keySet()) {
	    sb.append("\n" + attr);
	}
	sb.append("}");
	return sb.toString();
    }

    /**
     * Adds all properties and methods from the propertiesObject to the destination object.
     *
     * @param destination the destination object
     * @param propertiesObject the propertiesObject 
     */
    public static void addProperties(JavaScriptObject destination, JavaScriptObject propertiesObject) /*-{
        $wnd.isc.addProperties(destination, propertiesObject);
    }-*/
    {
	// TODO: methods?
	getAttributes(jsObj).putAll(getAttributes(config));
    }
}
