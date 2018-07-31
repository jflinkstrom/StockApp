package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.util.Interval;
import com.origamisoftware.teach.advanced.model.StockQuote;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Unit Test for SimpleStockService class
 */
public class SimpleStockServiceTest {
    private SimpleStockService simpleStockService;
    private List<StockQuote> stockQuotes;
    private String symbol;
    private DateTime dateTime;
    private Interval interval;

    @Before
    public final void setUp() {
        simpleStockService = new SimpleStockService();
        symbol = "APPL";
        dateTime = DateTime.now();
        interval = Interval.DAY;
    }

    /**
     * Test verifies getQuote returns correct symbol
     */
    @Test
    public void getQuotePosTest() {
        StockQuote result = simpleStockService.getQuote(symbol);
        assertEquals("Verify getSymbol returns correct string", result.getSymbol(), "APPL");
    }

    /**
     * Test verifies getQuote returns null
     */
    @Test
    public void getQuoteNegTest(){
        StockQuote result = simpleStockService.getQuote(null);
        assertNull(result.getSymbol());
    }

    /**
     * Test verifies second getListQuote is not null
     */
    @Test
    public void getListQuotePosTest(){
        stockQuotes = simpleStockService.getQuote(symbol, dateTime.now().minusDays(10), dateTime, Interval.DAY);
        assertNotNull(stockQuotes);
    }

    @Test(expected = NullPointerException.class)
    public void getListQuoteNegTest(){
        stockQuotes = simpleStockService.getQuote(null, null, null, null);
    }
}