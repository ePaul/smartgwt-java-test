
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

package com.smartgwt.client;

import java.util.Date;
import com.google.gwt.i18n.client.DateTimeFormat;

/**
 * Class that returns meta information like version number, major version, minor version and build date.
 */
public final class Version {
    /**
     * @return the library version
     */
    public static String getVersion() {
        return "3.0p";
    }

    /**
     * @return the library major version
     */
    public static String getMajor() {
        return "3.0p.0".split("\\.")[0];
    }

    /**
     * @return the library minor version
     */
    public static String getMinor() {
        return "3.0p.0".split("\\.")[1];
    }

    /**
     * @return the library patch version
     */
    public static String getPatch() {
        return "3.0p.0.0".split("\\.")[2];
    }

    /**
     * @return the library build time
     */
    public static Date getBuildDate() {
        return DateTimeFormat.getFormat("MM/dd/yyyy hh:mm Z").parse("03/03/2012 06:05 +0000");
    }
}