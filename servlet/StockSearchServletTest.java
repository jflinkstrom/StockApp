package com.origamisoftware.teach.advanced.servlet;

import org.junit.Test;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StockSearchServletTest {
    private static final String SYMBOL_PARAMETER_KEY = "symbol";
    private static final String FROM_PARAMETER_KEY = "from";
    private static final String UNTIL_PARAMETER_KEY = "until";
    private static final String INTERVAL_PARAMETER_KEY = "interval";

    /**
     * Unit test for StockSearchServlet using mock
     */
    @Test
    public void testStockSearchServlet() {
        StockSearchServlet stockSearchServlet = new StockSearchServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getParameter(SYMBOL_PARAMETER_KEY)).thenReturn("GOOG");
        when(request.getParameter(FROM_PARAMETER_KEY)).thenReturn("2016-04-23 00:00:00");
        when(request.getParameter(UNTIL_PARAMETER_KEY)).thenReturn("2016-07-23 00:00:00");
        when(request.getParameter(INTERVAL_PARAMETER_KEY)).thenReturn("DAY");
    }
}