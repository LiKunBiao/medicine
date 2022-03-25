package servlet.login;

import bean.Login;
import service.LoginService;
import service.LoginService;

@javax.servlet.annotation.WebServlet("/DeleteSelectedLoginServlet")
public class DeleteSelectedLoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String[] usernames = request.getParameterValues("username");
        LoginService service = new LoginService();
        service.deleteSelectLogin(usernames);
        response.sendRedirect("/FindLoginByPageServlet");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}