package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.model.database.QuoteDAO;
import com.origamisoftware.teach.advanced.model.database.StockSymbolDAO;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import com.origamisoftware.teach.advanced.util.Interval;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * An implementation of the StockService interface that gets
 * stock data from a database.
 */
public class DatabaseStockService implements StockService {
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
    public StockQuote getQuote(String symbol) throws StockServiceException {
        StockQuote stockQuote;

        StockSymbolDAO stockSymbolDAO = DatabaseUtils.findUniqueResultBy("symbol", symbol, StockSymbolDAO.class, true);
        List<QuoteDAO> quotes = DatabaseUtils.findResultsBy("stockSymbolBySymbolId", stockSymbolDAO, QuoteDAO.class, true);

        if (quotes.isEmpty()) {
            throw new StockServiceException("Could not find any stock quotes for: " + symbol);
        }

        QuoteDAO quoteDAO = quotes.get(0);

        DateTime time = DateTime.now();
        stockQuote = new StockQuote(quoteDAO.getPrice(), time, stockSymbolDAO.getSymbol());

        return stockQuote;
    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol   the stock symbol to search for
     * @param from     the date of the first stock quote
     * @param until    the date of the last stock quote
     * @param interval the number of stockquotes to get per a 24 hour period.
     * @return a list of StockQuote instances
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, DateTime from, DateTime until, Interval interval)
            throws StockServiceException {
        List<StockQuote> stockQuotes = null;
        Session session = null;
        Transaction transaction = null;

        try {
            StockSymbolDAO stockSymbolDAO = DatabaseUtils.findUniqueResultBy("symbol", symbol, StockSymbolDAO.class, true);
            session = DatabaseUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Timestamp fromTimeStamp = new Timestamp(from.getMillis());
            Timestamp untilTimestamp = new Timestamp(until.getMillis());
            Criteria criteria = session.createCriteria(QuoteDAO.class);
            criteria.add(Restrictions.eq("stockSymbolBySymbolId", stockSymbolDAO));
            criteria.add(Restrictions.between("time", fromTimeStamp, untilTimestamp));
            List<QuoteDAO> quoteDAOs = (List<QuoteDAO>) criteria.list();
            transaction.commit();
            stockQuotes = new ArrayList<>(quoteDAOs.size());

            for (QuoteDAO quoteDAO : quoteDAOs) {
                DateTime dateTime = DateTime.now();
                stockQuotes.add(new StockQuote(quoteDAO.getPrice(), dateTime,
                        quoteDAO.getStockSymbolBySymbolId().getSymbol()));
            }
        } catch (HibernateException e)  {
            if (transaction != null) {
                transaction.rollback();
            }
            if (session != null) {
                session.close();
            }
            session  = null;

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return stockQuotes;
    }

    /**
     * Returns true of the currentStockQuote has a date that is later by the time
     * specified in the interval value from the previousStockQuote time.
     *
     * @param endDate   the end time
     * @param interval  the period of time that must exist between previousStockQuote and currentStockQuote
     *                  in order for this method to return true.
     * @param startDate the starting date
     * @return
     */
    private boolean isInterval(java.util.Date endDate, Interval interval, java.util.Date startDate) {
        Calendar startDatePlusInterval = Calendar.getInstance();
        startDatePlusInterval.setTime(startDate);
        startDatePlusInterval.add(Calendar.MINUTE, interval.getMinutes());
        return endDate.after(startDatePlusInterval.getTime());
    }
}
