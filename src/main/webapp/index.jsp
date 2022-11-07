<%@ page import="java.time.LocalDateTime" %>
<%@ page import="ru.javarush.golf.evgeniilozovoi.servletquest.controller.GameServlet" %>
<%@ page import="ru.javarush.golf.evgeniilozovoi.servletquest.parser.JsonSimpleParser" %>
<%@ page import="ru.javarush.golf.evgeniilozovoi.servletquest.parser.Lang" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quest</title>
    <link href="/css/my.css" rel="stylesheet">
    <script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
</head>
<body>
<h1><%= "Привет, это игра-квест написанная на сервлетах" %>
</h1>
<br/>
<h2>Введи свое имя:</h2>
<form action="langServlet">
    <input name="name">
    <h2>Ты готов?</h2>
    <br>
    <p><input type="radio" name="lang" value="RU" checked>RU</p>
    <p><input type="radio" name="lang" value="EN" checked>EN</p>
<br>
    <button type="submit">Да</button>
    <button type="submit" onclick="location.href='index.jsp'">Нет</button>
</form>
    </body>
</html>