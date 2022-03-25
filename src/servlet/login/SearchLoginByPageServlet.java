package servlet.login;

import bean.Login;
import bean.Page;
import service.LoginService;

import javax.servlet.http.HttpSession;

@javax.servlet.annotation.WebServlet("/SearchLoginByPageServlet")
 public class SearchLoginByPageServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //1.获取参数
        String username = request.getParameter("username");
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数
        if(currentPage == null || "".equals(currentPage))
            currentPage = "1";
        if(rows == null || "".equals(rows))
            rows = "5";
        //调用service查询
        LoginService service = new LoginService();
        Page<Login> loginPage = service.searchLoginByPage(currentPage, rows, username);
        HttpSession session = request.getSession();
        session.setAttribute("loginPage", loginPage);
        System.out.println(loginPage);
        session.setAttribute("id", 2);
        String usertype = request.getParameter("usertype");
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