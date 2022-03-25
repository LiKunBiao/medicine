package servlet.agency;

import bean.Agency;
import bean.Page;
import service.AgencyService;

import javax.servlet.http.HttpSession;

@javax.servlet.annotation.WebServlet("/FindAgencyByPageServlet")
public class FindAgencyByPageServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String key1 = request.getParameter("key1");
        String value1 = request.getParameter("value1");
        String key2 = request.getParameter("key2");
        String value2 = request.getParameter("value2");
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
        Page<Agency> agencyPage = null;
        if(value1 != null || value2 != null)
        {
            agencyPage = service.findAgencyByPage(currentPage, rows, key1, value1, key2, value2);
        }
        else
        {
            agencyPage = service.findAgencyByPage(currentPage, rows, null, null, null, null);
        }

        HttpSession session = request.getSession();
        session.setAttribute("agencyPage", agencyPage);
        session.setAttribute("id", 1);
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