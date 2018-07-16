package com.origamisoftware.teach.advanced.model.DatabaseAccessObjects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Models the Quotes table
 */
@Entity
public class Quotes {

    private int id;
    private Timestamp time;
    private BigDecimal price;
    private String symbol;

    /**
     * Primary Key - Unique ID for a particular row in the Quotes table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the Quotes table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return a timeStamp instance
     */
    @Basic
    @Column(name = "time", nullable = false, insertable = true, updatable = true)
    public Timestamp getTime() {
        return time;
    }

    /**
     * set the Time
     *
     * @param time a TimeStamp
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     *
     * @return a BigDecimal instance
     */
    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true)
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * set the price
     *
     * @param price a Bigdecimal
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * the quote symbol
     * @return the value of the symbol as a string
     */
    @Basic
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true)
    public String getSymbol() {
        return symbol;
    }

    /**
     * set the symbol
     * @param symbol a String
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quotes Quotes = (Quotes) o;

        if (id != Quotes.id) return false;
        if (time != null ? !time.equals(Quotes.time) : Quotes.time != null) return false;
        if (price != null ? !price.equals(Quotes.price) : Quotes.price != null)
            return false;
        if (symbol != null ? !symbol.equals(Quotes.symbol) : Quotes.symbol != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Quotes{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", time='" + time + '\'' +
                ", price=" + price +
                '}';
    }
}
