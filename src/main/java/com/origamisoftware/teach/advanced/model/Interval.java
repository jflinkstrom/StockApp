package com.origamisoftware.teach.advanced.model;

/**
 * Interval represents the number of StockQuotes for a given time period
 */
public enum Interval {
    /** every 24 hours */
    DAILY,
    /** every 12 hours */
    HALFDAY,
    /** every hour */
    HOURLY
}