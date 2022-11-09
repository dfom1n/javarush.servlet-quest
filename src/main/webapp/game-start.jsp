<%@ page import="java.time.LocalDateTime" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<header>
    <script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</header>
<div class="container bgcont center-block">
    <div class="row background-row">
        <div class="centered-top">
            <div class="p-3 mb-2 bg-light text-dark">
                <h2>
                    ${question}
                </h2>
                <br>
                <h3>
                    <form method="post" action="gameServlet">
                        <c:forEach items="${steps}" var="step">
                            <input type="radio" class="btn-check" name="next" value="${step.getNext()}"
                                   id="${step.getNext()}">
                            <label class="btn btn-secondary" for="${step.getNext()}">${step.getText()}</label>
                        </c:forEach>
                        <p>
                            <br>
                            <button type="submit" class="btn btn-outline-dark" name="win"
                                    value="${question}">${steps == null ? "Again" : "Next"}</button>
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
                        <td><%= "Date: " + LocalDateTime.now().toLocalDate()%>
                        </td>
                    <tr>
                        <td><%= "Ip: " + request.getLocalName() %>
                        </td>
                    </tr>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>
</html>
