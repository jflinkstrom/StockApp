<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="quotes" class="com.origamisoftware.teach.advanced.servlet.StockSearchServlet" scope="session">
    <c:set target='${quotes}'  value='${sessionScope.get("quotes")}'/>
</jsp:useBean>
<html>
<head>
    <title>Stock Result</title>
</head>
<body>

<c:out value="${quotes}"/>
</body>
</html>