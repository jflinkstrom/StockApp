package com.origamisoftware.teach.advanced.model.DatabaseAccessObjects;

import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static org.junit.Assert.*;

public class QuotesTest {

    public static final Timestamp time = new Timestamp(2018, 01, 01,
            12, 99, 30, 01);
    public static final BigDecimal price = new BigDecimal(101.5);
    public static final String symbol = "APPL";
    private static final int id = 11;

    public static Quotes createQuotes(){
        Quotes quote = new Quotes();
        quote.setId(id);
        quote.setSymbol(symbol);
        quote.setPrice(price);
        quote.setTime(time);
        return quote;
    }

    @Test
    public void testQuotesGettersAndSetters(){
        Quotes quote = createQuotes();
        assertEquals("id matches", id, quote.getId());
        assertEquals("price matches", price, quote.getPrice());
        assertEquals("symbol matches", symbol, quote.getSymbol());
        assertEquals("time matches", time, quote.getTime());
    }
}