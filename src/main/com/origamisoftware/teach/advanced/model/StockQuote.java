package com.origamisoftware.teach.advanced.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.math.BigDecimal;

/**
 * A container class that contains stock data.
 */
public class StockQuote extends StockData {

    private BigDecimal price;
    private DateTime date;
    private String symbol;
    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(dateFormat);

    /**
     * Create a new instance of a StockQuote.
     * @param price  the share price for the given date
     * @param date   the date of the share price
     * @param symbol the stock symbol.
     */
    public StockQuote(BigDecimal price, DateTime date, String symbol) {
        this.price = price;
        this.date = date;
        this.symbol = symbol;
    }

    /**
     * @return Get the share price for the given date.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @return The date of the share price
     */
    public DateTime getDate() {
        return date;
    }

    /**
     * @return The stock symbol.
     */
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "StockQuote{" +
                "price=" + price +
                ", date=" + date.toString(dateTimeFormatter) +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
