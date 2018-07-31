<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="StockQuote" class="com.origamisoftware.teach.advanced.model.StockQuote" scope="request"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Stock Quote Data</title>

</head>

<body>
<h2>
    Enter stock symbol, from and until dates (YYYY-MM-DD HH:mm:ss): <br>
</h2>

<P></P>
        <form name="stockform" action="servlet/StockSearchServlet" method="post">
            Symbol: <input type="text" name="symbol" title="symbol"><br>
            From Date: <input type="text" name="from" title="from date"><br>
            Until Date: <input type="text" name="until" title="until date">
            <input type="SUBMIT" value="OK">
            <input type="HIDDEN" name="submit" value="true">
        </form>
</body>
</html>