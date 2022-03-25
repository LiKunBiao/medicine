package servlet.login;

import service.LoginService;
import service.LoginService;

@javax.servlet.annotation.WebServlet("/DeleteLoginServlet")
public class DeleteLoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String username = request.getParameter("username");
        LoginService service = new LoginService();
        service.deleteLogin(username);
        response.sendRedirect("/FindLoginByPageServlet");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}