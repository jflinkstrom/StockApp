package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuery;
import com.origamisoftware.teach.advanced.model.StockQuote;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for OnlineStockService
 */
public class OnlineStockServiceTest {
    private static final String symbol = "GOOG";
    private static final String from = "2000-02-10";
    private static final String until = "2015-02-03";
    private static OnlineStockService service;

    @Before
    public final void setUp() throws StockServiceException {
        service = (OnlineStockService) ServiceFactory.getOnlineStockService();
    }

    @Test
    public void getQuoteSymbolTest() throws StockServiceException {
        StockQuote result = service.getQuote(symbol);
        assertNotNull(result);
    }

    @Test
    public void getQuoteSymbolListTest() throws Exception {
        StockQuery stockQuery = new StockQuery(symbol, from, until);
        List<StockQuote> result = service.getQuote(symbol, stockQuery.getFrom(), stockQuery.getUntil(),
                com.origamisoftware.teach.advanced.util.Interval.DAY);
        assertNotNull(result);
    }
}
