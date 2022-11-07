package ru.javarush.golf.evgeniilozovoi.servletquest.filter;

import ru.javarush.golf.evgeniilozovoi.servletquest.parser.JsonSimpleParser;
import ru.javarush.golf.evgeniilozovoi.servletquest.parser.Lang;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LangFilter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lang = req.getParameter("lang");
        if ("EN".equals(lang)) {
            JsonSimpleParser.setLanguage(Lang.EN);
        } else {
            JsonSimpleParser.setLanguage(Lang.RU);
        }
        req.getRequestDispatcher("gameServlet").forward(req, resp);
    }
}
