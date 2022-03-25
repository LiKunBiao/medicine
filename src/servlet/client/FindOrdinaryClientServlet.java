package servlet.client;

import bean.Client;
import bean.Page;
import service.ClientService;

import javax.servlet.http.HttpSession;

@javax.servlet.annotation.WebServlet("/FindOrdinaryClientServlet")
public class FindOrdinaryClientServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数
        if(currentPage == null || "".equals(currentPage))
            currentPage = "1";
        if(rows == null || "".equals(rows))
            rows = "5";
        //调用service查询
        ClientService service = new ClientService();
        Page<Client> clientPage = service.findClientByPage(currentPage, rows);
        System.out.println(clientPage);
        HttpSession session = request.getSession();
        session.setAttribute("clientPage", clientPage);
        session.setAttribute("id", 3);
        response.sendRedirect("/ordinaryMain.jsp");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}