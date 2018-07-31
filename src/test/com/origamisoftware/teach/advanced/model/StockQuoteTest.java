package com.origamisoftware.teach.advanced.model;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * JUnit test for StockQuote class
 */
public class StockQuoteTest {

    private BigDecimal price;
    private DateTime date;
    private String symbol;
    private StockQuote stockQuote;

    @Before
    public void setUp() {
        price = new BigDecimal(100);
        date = DateTime.now();
        symbol = "APPL";
        stockQuote = new StockQuote(price, date, symbol);
    }

    @Test
    public void testGetPrice() { assertEquals("Price is correct", price, stockQuote.getPrice()); }

    @Test
    public void testGetDate() {
        assertEquals("Date is correct", date, stockQuote.getDate());
    }

    @Test
    public void testGetSymbol() {
        assertEquals("Symbol  is correct", symbol, stockQuote.getSymbol());
    }

    @Test
    public void testNull(){
        price = null;
        date = null;
        symbol = null;
        stockQuote = new StockQuote(price, date, symbol);
        assertNull("Price is null", price);
        assertNull("date is null", date);
        assertNull("symbol is null", symbol);
    }
}
