package servletperros;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servletperros", urlPatterns = {"/Servletperros"})
public class Servletperros extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servletperr</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1></h1>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {       

        int total = Integer.parseInt(request.getParameter("pgran"))
                + Integer.parseInt(request.getParameter("pmed")) + Integer.parseInt(request.getParameter("ppeq"));

        int gpperros = Integer.parseInt(request.getParameter("pgran"))
                * Integer.parseInt(request.getParameter("h")) * 10000;
        int mpperros = Integer.parseInt(request.getParameter("pmed"))
                * Integer.parseInt(request.getParameter("h")) * 5000;
        int ppperros = Integer.parseInt(request.getParameter("ppeq"))
                * Integer.parseInt(request.getParameter("h")) * 3000;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servletperr</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("");
        if (total == 1) {

            int totall = gpperros + mpperros + ppperros;
            out.println("el total que tienes que pagar por pasear al perro es de: " + totall);

        } else if (total > 1) {

            int totala = gpperros + mpperros + ppperros;
            int totalp = totala - (totala / 10);

            out.println("el total que tienes que pagar por pasear a los perros con descuento es de: " + totalp);
        }
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
