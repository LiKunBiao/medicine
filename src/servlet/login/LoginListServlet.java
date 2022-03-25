package servlet.login;

import bean.Login;
import bean.Login;
import service.LoginService;
import service.LoginService;

import javax.servlet.http.HttpSession;
import java.util.List;

@javax.servlet.annotation.WebServlet("/LoginListServlet")
public class LoginListServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        request.setCharacterEncoding("utf-8");
        LoginService service = new LoginService();
        List<Login> logins = service.findAllLogin();
        HttpSession session = request.getSession();
        session.setAttribute("logins", logins);
        session.setAttribute("id", 2);
        String usertype = request.getParameter("usertype");
        System.out.println(usertype);
        if(usertype != null)
        {
            if(usertype.equals("普通用户"))
                response.sendRedirect("/ordinaryMain.jsp");
        }
        response.sendRedirect("/managedMain.jsp");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}