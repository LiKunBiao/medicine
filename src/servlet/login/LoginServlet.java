package servlet.login;

import bean.Login;
import service.LoginService;
import service.LoginService;

import javax.servlet.http.Cookie;

@javax.servlet.annotation.WebServlet("/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        if(remember != null)
        {
            Cookie c1 = new Cookie("username", username);
            Cookie c2 = new Cookie("password", password);
            Cookie c3 = new Cookie("remember", "1");
            response.addCookie(c1);
            response.addCookie(c2);
            response.addCookie(c3);
        }
        else{}
        System.out.println(username);
        System.out.println(" " + password);
        LoginService service = new LoginService();
        Login login = service.login(username, password);
        if(login != null)
        {
            if(login.getUsertype().equals("管理员"))
                response.sendRedirect("/managedMain.jsp");
            else
                response.sendRedirect("/ordinaryMain.jsp");
        }
        else
        {
            response.sendRedirect("/login.jsp");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}