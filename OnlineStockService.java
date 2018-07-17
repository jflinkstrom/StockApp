package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.util.Interval;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Class defines methods for use with the yahooo finance API
 *
 */
class OnlineStockService implements StockService{

    /**
     * Return the current price for a share of stock for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  StockQuote instance
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
    public StockQuote getQuote(String symbol) throws StockServiceException {
        StockQuote stockQuote = null;
        try {
            Stock stock = YahooFinance.get(symbol);
            stockQuote = new StockQuote(stock.getQuote().getPrice(), Calendar.getInstance().getTime(), symbol);
        } catch (IOException e) {
            throw new StockServiceException(e.getMessage(), e);
        }
        if (stockQuote == null) {
            throw new StockServiceException(symbol + " not found");
        }
        return stockQuote;
    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol   the stock symbol to search for
     * @param from     the date of the first stock quote
     * @param until    the date of the last stock quote
     * @param interval the number of stockquotes to get per day
     * @return a list of StockQuote instances
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, Interval interval) throws StockServiceException {
        yahoofinance.Stock stock = null;
        List<StockQuote> stocks = new ArrayList<StockQuote>();
        List<HistoricalQuote> historicalQuote = null;

        try {
            stock = YahooFinance.get(symbol);
        } catch (IOException e) {
            throw new StockServiceException(symbol + "not found");
        }

        try {
            historicalQuote = stock.getHistory(from, until, yahoofinance.histquotes.Interval.DAILY);
        } catch (IOException e) {
            throw new StockServiceException("stock not found for dates given");
        }
        for (HistoricalQuote historicalQuotes : historicalQuote) {
            BigDecimal price = historicalQuotes.getClose();
            Calendar date = historicalQuotes.getDate();
            StockQuote stockQuote = new StockQuote(price, date.getTime(), symbol);
            stocks.add(stockQuote);
        }
        return stocks;
    }
}