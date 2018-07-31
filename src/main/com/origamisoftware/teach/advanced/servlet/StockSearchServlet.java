package com.origamisoftware.teach.advanced.servlet;

import com.origamisoftware.teach.advanced.model.StockQuery;
import com.origamisoftware.teach.advanced.services.ServiceFactory;
import com.origamisoftware.teach.advanced.services.StockService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;

/**
 * Servlet class to retrieve stock quotes from the web
 */
public class StockSearchServlet extends HttpServlet {

    private StockService stockService;

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

        HttpSession session = request.getSession();

        try {
            StockQuery stockQuery = new StockQuery(symbol, from, until);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        stockService = ServiceFactory.getOnlineStockService();

        session.setAttribute("symbol", SYMBOL_PARAMETER_KEY);
        session.setAttribute("from", FROM_PARAMETER_KEY);
        session.setAttribute("until", UNTIL_PARAMETER_KEY);

        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher =
                servletContext.getRequestDispatcher("/StockQuoteResults.jsp");
        dispatcher.forward(request, response);
    }
    }