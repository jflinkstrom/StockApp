package com.origamisoftware.teach.advanced.services;
import com.origamisoftware.teach.advanced.model.StockQuote;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for the DatabaseStockService
 */
 public class DatabaseStockServiceTest {

     private String symbol = "GOOG";
     private String fromString = "2004-08-19";
     private String untilString = "2015-02-03";
     DatabaseStockService databaseStockService = new DatabaseStockService();

     @Test
     public void testGetQuote() throws Exception {
         StockQuote stockQuote = databaseStockService.getQuote(symbol);
         assertNotNull("Verify we can get a stock quote from the db", stockQuote);
         assertEquals("Make sure the symbols match", symbol, stockQuote.getSymbol());
     }

     @Test
     public void testGetQuoteDates() throws Exception{
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
         Date date = simpleDateFormat.parse(fromString);
         Date date2 = simpleDateFormat.parse(untilString);
         Calendar from = Calendar.getInstance();
         from.setTime(date);
         Calendar until = Calendar.getInstance();
         until.setTime(date2);
         until.add(Calendar.DAY_OF_YEAR, 1);

         List<StockQuote> stockQuote = databaseStockService.getQuote(symbol, from, until);
         System.out.println(stockQuote);

         assertNotNull("Verify symbol, and dates in stockQuote are in the db", stockQuote);
     }
 }
