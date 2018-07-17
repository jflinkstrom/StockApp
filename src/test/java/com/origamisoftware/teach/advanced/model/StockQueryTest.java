package com.origamisoftware.teach.advanced.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for StockQuery Class
 */
public class StockQueryTest {

    @Test
    public void testBasicConstruction() throws Exception{
        String symbol = "APPL";
        StockQuery stockQuery = new StockQuery(symbol,"2010-11-11 00:00:00","2011-11-11 00:00:00");
        assertEquals("Verify construction", symbol, stockQuery.getSymbol());
    }

}
