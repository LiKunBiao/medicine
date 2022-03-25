package servlet.agency;

import bean.Agency;
import bean.Page;
import service.AgencyService;

import javax.servlet.http.HttpSession;

@javax.servlet.annotation.WebServlet("/FindOrdinaryAgencyServlet")
public class FindOrdinaryAgencyServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //1.获取参数
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数
        if(currentPage == null || "".equals(currentPage))
            currentPage = "1";
        if(rows == null || "".equals(rows))
            rows = "5";
        //调用service查询
        AgencyService service = new AgencyService();
        Page<Agency> agencyPage = service.findAgencyByPage(currentPage, rows, null, null, null, null);
        System.out.println(agencyPage);
        HttpSession session = request.getSession();
        session.setAttribute("agencyPage", agencyPage);
        session.setAttribute("id", 1);
        response.sendRedirect("/ordinaryMain.jsp");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}