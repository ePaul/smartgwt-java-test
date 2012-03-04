package com.smartgwt.client.widgets.form.fields;

import com.smartgwt.client.core.*;

import com.google.gwt.core.client.JavaScriptObject;

public class BooleanItem extends FormItem {

    public static BooleanItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (BooleanItem) obj;
        } else {
            return new BooleanItem(jsObj);
        }
    }

    public BooleanItem() {
        setType("boolean");
    }

    public BooleanItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public BooleanItem(String name) {
        setName(name);
        setType("boolean");
    }

    public BooleanItem(String name, String title) {
        setName(name);
		setTitle(title);
        setType("boolean");
    }

    /**
     * Return the value tracked by this form item.
     *
     * @return value of this element
     */
    public native Boolean getValueAsBoolean() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret;
        if(self.setValue) {
             ret = self.getValue();
        } else {
            ret = self.value;
        }
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;
}
