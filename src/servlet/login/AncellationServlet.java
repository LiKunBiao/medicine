package servlet.login;

import javax.servlet.http.HttpSession;

@javax.servlet.annotation.WebServlet("/AncellationServlet")
public class AncellationServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        HttpSession session = request.getSession();
        session.setAttribute("id", 0);
        response.sendRedirect("/login.jsp");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}