package servlet.login;

import bean.Login;
import bean.Login;
import service.LoginService;
import service.LoginService;

@javax.servlet.annotation.WebServlet("/FindLoginByUsernameServlet")
public class FindLoginByUsernameServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String username = request.getParameter("username");
        LoginService service = new LoginService();
        Login login = service.findLoginByUsername(username);
        request.setAttribute("login", login);
        request.getRequestDispatcher("/reviseUser.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}