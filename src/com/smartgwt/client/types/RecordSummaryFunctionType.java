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
 
package com.smartgwt.client.types;

/**
 * Function to produce a summary value based on field values within a record. Example usage is record-level summaries in 
 * {@link com.smartgwt.client.types.ListGridFieldType "summary" type ListGrid fields}. <P> SummaryFunctions may be
 * specified in one of 2 ways:<ul> <li>as an explicit function or executable stringMethod. Takes 3 parameters:
 * <br><code>record</code> the record for which the value is being calculated <br><code>fields</code> Array of
 * listGridFields from which summaries should be calculated <br><code>summaryField</code> pointer to the summary type field
 * on which the summary function is being run.</li> <li>As a registered RecordSummaryFunction identifier</li></ul> Note
 * that {@link com.smartgwt.client.data.DataSource#registerRecordSummaryFunction DataSource.registerRecordSummaryFunction}
 * may be used to expand the set of registered RecordSummaryFunctions.
 */
public enum RecordSummaryFunctionType implements ValueEnum {
    /**
     * Iterates through each field, picking up the numeric field values from the record and summing them.
     */
    SUM("sum"),
    /**
     * Iterates through each field, picking up the numeric field values from the record and calculating the mean value.
     */
    AVG("avg"),
    /**
     * Iterates through each field, picking up the numeric field values from the record and calculating the maximum value.
     */
    MAX("max"),
    /**
     * Iterates through each field, picking up the numeric field values from the record and calculating the minimum value.
     */
    MIN("min"),
    /**
     * Iterates through each field, picking up the numeric field values from the record and multiplying them together.
     */
    MULTIPLIER("multiplier");

    private String value;

    RecordSummaryFunctionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
