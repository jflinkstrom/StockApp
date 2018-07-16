package com.origamisoftware.teach.advanced.services;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * JUnit test for <CODE>ServiceFactory</CODE>
 */
public class ServiceFactoryTest {

    @Test
    public void testGetInstance() {
        StockService stockService = ServiceFactory.getStockService();
        UserService userService = ServiceFactory.getUserService();
        assertNotNull(stockService);
        assertNotNull(userService);
    }
}
