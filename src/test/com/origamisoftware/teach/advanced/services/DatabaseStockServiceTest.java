package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.util.DatabaseInitializationException;
import com.origamisoftware.teach.advanced.util.Interval;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for the DatabaseStockService
 */
public class DatabaseStockServiceTest extends DatabaseServiceTest {

    private StockService databaseStockService;

    @Before
    public void setUp() throws DatabaseInitializationException {
        super.setUp();
        databaseStockService = ServiceFactory.getStockService();
    }

    @Test
    public void testGetQuote() throws Exception {
        String symbol = "APPL";
        StockQuote stockQuote = databaseStockService.getQuote(symbol);
        assertNotNull("Verify we can get a stock quote from the db", stockQuote);
        assertEquals("Make sure the symbols match", symbol, stockQuote.getSymbol());
    }

    @Test
    public void testGetQuoteWithIntervalBasic() throws Exception {
        String fromStringDate = "2000-02-10 00:00:01";
        String untilStringDate = "2015-02-03 00:00:01";
        String symbol = "GOOG";
        DateTime fromDate = makeDateFromString(fromStringDate);
        DateTime untilDate = makeDateFromString(untilStringDate);

        List<StockQuote> stockQuotes = databaseStockService.getQuote(symbol, fromDate, untilDate, Interval.DAY);

        assertFalse("verify stock quotes where returned", stockQuotes.isEmpty());
    }

    @Test
    public void testGetQuoteWithinRangeDay() throws Exception {

        String fromDateString = "2015-02-09 00:01:01";
        String endDateString = "2015-02-11 01:08:01";
        String symbol = "AMZN";

        DateTime fromDate = makeDateFromString(fromDateString);
        DateTime untilDate = makeDateFromString(endDateString);

        List<StockQuote> stockQuotes = databaseStockService.getQuote(symbol, fromDate, untilDate, Interval.DAY);
        assertEquals("got back expected number of stockquotes for one day interval", 4, stockQuotes.size());

        stockQuotes = databaseStockService.getQuote(symbol, fromDate, untilDate, Interval.MINUTE);
        assertEquals("got back expected number of stockquotes for one minute interval", 4, stockQuotes.size());
    }

    @Test
    public void testGetQuoteWithinRangeMinute() throws Exception {

        String fromDateString = "2015-02-10 00:02:01";
        String endDateString = "2015-02-10 00:04:01";
        String symbol = "AMZN";

        DateTime fromDate = makeDateFromString(fromDateString);
        DateTime untilDate = makeDateFromString(endDateString);

        List<StockQuote> stockQuotes =
                databaseStockService.getQuote(symbol, fromDate, untilDate, Interval.MINUTE);
        assertEquals("got back expected number of stockquotes for one minute interval", 3, stockQuotes.size());
    }

    /**
     * Handy dandy helper method that converts Strings in the format of   StockData.dateFormat
     * to Calendar instances set to the date expressed in the string.
     *
     * @param dateString a data and time in this format: StockData.dateFormat
     * @return a calendar instance set to the time in the string.
     * @throws ParseException if the string is not in the correct format, we can't tell what
     *                        time it is, and therefore can't make a calender set to that time.
     */
    private DateTime makeDateFromString(String dateString) throws ParseException {
        org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dateTime = formatter.parseDateTime(dateString);
        return dateTime;

    }
}
