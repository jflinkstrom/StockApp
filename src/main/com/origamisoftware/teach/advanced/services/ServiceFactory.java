package com.origamisoftware.teach.advanced.services;

/**
 * A factory that returns a Service.
 */
public class ServiceFactory {

    private ServiceFactory() {
    }

    /**
     * @return get a <CODE>StockService</CODE> instance
     */
    public static StockService getStockService(){ return new DatabaseStockService();}

    public static StockService getOnlineStockService(){ return new OnlineStockService();}
    /**
     * @return get a <CODE>UserService</CODE> instance
     */
    public static UserService getUserService() {
        return new DatabaseUserService();
    }
}
