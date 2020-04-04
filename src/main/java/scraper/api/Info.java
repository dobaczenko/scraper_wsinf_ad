package scraper.api;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import scraper.api.response.ResponseBuilder;

/**
 * Servlet implementation class Info
 */
public class Info extends HttpServlet implements Servlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(Info.class.getName());

    /**
     * Default constructor.
     */
    public Info() {
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        String[] splits = pathInfo.split("/");
        System.out.println("Api splits: "+splits.length);
        if (splits.length != 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        // url wskazuje na wykonanie operacji
        switch (splits[splits.length-1]) {
            case "abouts":
                //metoda info
                rest_abouts(response);
                break;
                //check_db
                
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
        }
    }

    private void rest_abouts(HttpServletResponse response) {
        try {
            response.setContentType("application/json,charset=UTF-8");
            try ( PrintWriter out = response.getWriter()) {
                out.print(ResponseBuilder.getJson_ResponseInfo());
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, null, e);
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
