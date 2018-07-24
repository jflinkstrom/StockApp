package com.origamisoftware.teach.advanced.servlet;

import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.services.ServiceFactory;
import com.origamisoftware.teach.advanced.services.StockService;
import com.origamisoftware.teach.advanced.services.StockServiceException;
import com.origamisoftware.teach.advanced.util.DateParser;
import com.origamisoftware.teach.advanced.util.Interval;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

/**
 * Servlet class to retrieve stock quotes from the web
 */
public class StockSearchServlet extends HttpServlet {

    private static final String SYMBOL_PARAMETER_KEY = "symbol";
    private static final String FROM_PARAMETER_KEY = "from";
    private static final String UNTIL_PARAMETER_KEY = "until";
    private static final String INTERVAL_PARAMETER_KEY = "interval";
    /**
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String symbol = request.getParameter(SYMBOL_PARAMETER_KEY);
        String from = request.getParameter(FROM_PARAMETER_KEY);
        String until = request.getParameter(UNTIL_PARAMETER_KEY);
        String interval = request.getParameter(INTERVAL_PARAMETER_KEY);
        String quotes = null;
        Calendar start = null;
        Calendar end = null;

        HttpSession session = request.getSession();

         StockService stock = ServiceFactory.getYahooStockService();

        List<StockQuote> stockquote = null;

        try {
            start = DateParser.getCalendarFromString(from);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            end = DateParser.getCalendarFromString(until);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            stockquote = stock.getQuote(symbol, start, end, Interval.DAY);
        } catch (StockServiceException e) {
            e.printStackTrace();
        }

        StringBuilder builder = new StringBuilder();
        for (StockQuote quote : stockquote){
            builder.append(quote.toString());
        }
            quotes = builder.toString();

        session.setAttribute("quotes", quotes);

        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/stockResults.jsp");
        dispatcher.forward(request, response);
    }
    }