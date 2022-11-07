<%@ page import="java.time.LocalDateTime" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<header>
    <script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
</header>
<body>
<h2>
    ${question}
</h2>
<h3>
    <form method="post" action="gameServlet">
        <c:forEach items="${steps}" var="step">
            <p><input type="radio" name="next" value="${step.getNext()}" checked>
                    ${step.getText()}</p>
        </c:forEach>
        <p>
            <button type="submit" name="win" value="${question}">${steps == null ? "Again" : "Next"}</button>
            <br>
        </p>
    </form>
</h3>
<br>
<br>
<br>
<table>
    <tr>
        <td>Session:</td>
    <tr>
    <td>${name}</td>
    <tr>
        <td><%= "Date: " + LocalDateTime.now().toLocalDate()%></td>
    <tr>
        <td><%= "Ip: " + request.getLocalName() %></td>
    </tr>
    </tr>
</table>
</body>
</html>
