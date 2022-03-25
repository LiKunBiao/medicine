package servlet.login;

import bean.Login;
import service.LoginService;

@javax.servlet.annotation.WebServlet("/ReviseLoginServlet")
public class ReviseLoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        Login login = new Login();
        login.setPassword(request.getParameter("password"));
        login.setUsername(request.getParameter("username"));
        login.setUsertype(request.getParameter("usertype"));
        LoginService service = new LoginService();
        service.reviseLogin(login, request.getParameter("username"));
        response.sendRedirect("/FindLoginByPageServlet");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}