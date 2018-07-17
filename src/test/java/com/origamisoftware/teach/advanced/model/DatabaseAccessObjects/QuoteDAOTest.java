package com.origamisoftware.teach.advanced.model.DatabaseAccessObjects;

import com.origamisoftware.teach.advanced.model.database.QuoteDAO;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static org.junit.Assert.*;

public class QuoteDAOTest {

    public static final Timestamp time = new Timestamp(2018, 01, 01,
            12, 99, 30, 01);
    public static final BigDecimal price = new BigDecimal(101.5);
    private static final int id = 11;

    public static QuoteDAO createQuotes(){
        QuoteDAO quote = new QuoteDAO();
        quote.setId(id);
        quote.setPrice(price);
        quote.setTime(time);
        return quote;
    }

    @Test
    public void testQuotesGettersAndSetters(){
        QuoteDAO quote = createQuotes();
        assertEquals("id matches", id, quote.getId());
        assertEquals("price matches", price, quote.getPrice());
        assertEquals("time matches", time, quote.getTime());
    }
}