<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="StockQuote" class="com.origamisoftware.teach.advanced.model.StockQuote" scope="request"/>
<jsp:setProperty name="StockQuote" property="*" />

<html>
<head>
    <title>Search Result</title>
</head>
<body>

Your Stock Quote is:

Stock: <%= StockQuote.getSymbol() %>
 On Date: <%= StockQuote.getDate() %>
 For Price: <%= StockQuote.getPrice() %>

</body>
</html>