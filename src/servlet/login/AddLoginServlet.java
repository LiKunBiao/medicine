package servlet.login;

import bean.Login;
import bean.Login;
import service.LoginService;
import service.LoginService;

@javax.servlet.annotation.WebServlet("/AddLoginServlet")
public class AddLoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        Login login = new Login();
        login.setUsername(request.getParameter("username"));
        login.setPassword(request.getParameter("password"));
        login.setUsertype(request.getParameter("usertype"));
        LoginService service = new LoginService();
        service.addLogin(login);
        String register = request.getParameter("register");
        if(register != null)
            response.sendRedirect("/login.jsp");
        else
            response.sendRedirect("/FindLoginByPageServlet");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}