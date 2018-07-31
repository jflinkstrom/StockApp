package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.util.Interval;
import org.joda.time.DateTime;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of the StockService that returns hard coded data.
 */
 class SimpleStockService implements StockService {

    /**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
    public StockQuote getQuote(String symbol) {
        return new StockQuote(new BigDecimal(100), DateTime.now(), symbol);
    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances
     * @throws   StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, DateTime from, DateTime until, Interval interval) {
        List<StockQuote> stockQuotes = new ArrayList<>();
        while (from.isBefore(until)) {
            stockQuotes.add(new StockQuote(new BigDecimal(100), from, symbol));
            from = from.plusDays(1);
        }
        return stockQuotes;
    }
}
