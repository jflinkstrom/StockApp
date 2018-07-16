package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;
import org.junit.Test;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Unit Test for SimpleStockService class
 */
public class SimpleStockServiceTest {

    private SimpleStockService simpleStockService = new SimpleStockService();
    private String symbol = "APPL";
    private Date date = new Date();

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
        Calendar from = Calendar.getInstance();
        from.setTime(date);

        Calendar until = Calendar.getInstance();
        until.setTime(date);
        until.add(Calendar.DAY_OF_YEAR, 1);

        List<StockQuote> stockQuote = simpleStockService.getQuote(symbol, from, until);

        assertNotNull(stockQuote);
    }
}