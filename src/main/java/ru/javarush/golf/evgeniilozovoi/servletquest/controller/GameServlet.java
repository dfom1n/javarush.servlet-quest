package ru.javarush.golf.evgeniilozovoi.servletquest.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.javarush.golf.evgeniilozovoi.servletquest.repository.StepRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class GameServlet extends HttpServlet {
    private static final Logger log = LogManager.getLogger();
    private StepRepository repository;

    @Override
    public void init() throws ServletException {
        log.info("App start");
        repository = new StepRepository();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        String name = request.getParameter("name");
        if (name != null) {
            session.setAttribute("name", name);
        }
        log.info("Send Attributes");
        sendAttribute(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Get Attributes");
        String nextParam = req.getParameter("next");
        String winParam = req.getParameter("win");
        if (nextParam != null) {
            int nextNumber = Integer.parseInt(nextParam);
            req.setAttribute("steps", repository.getByNext(nextNumber));
            String question = repository.getQuestion(nextNumber);
            req.setAttribute("question", question);
            req.getRequestDispatcher("game-start.jsp").forward(req, resp);
        } else if (winParam != null) {
            if (winParam.equals("Победа")) {
                resp.sendRedirect("index.jsp");
            } else {
                sendAttribute(req, resp);
            }
        }
    }

    private void sendAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("question", repository.getFirstQuestion());
        request.setAttribute("steps", repository.getFirst());
        request.getRequestDispatcher("game-start.jsp").forward(request, response);
    }
}

