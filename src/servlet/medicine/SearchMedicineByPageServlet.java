package servlet.medicine;

import bean.Medicine;
import bean.Page;
import service.MedicineService;

import javax.servlet.http.HttpSession;

@javax.servlet.annotation.WebServlet("/SearchMedicineByPageServlet")
public class SearchMedicineByPageServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //1.获取参数
        String key1 = request.getParameter("key1");
        String value1 = request.getParameter("value1");
        String key2 = request.getParameter("key2");
        String value2 = request.getParameter("value2");
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数
        if(currentPage == null || "".equals(currentPage))
            currentPage = "1";
        if(rows == null || "".equals(rows))
            rows = "5";
        //调用service查询
        MedicineService service = new MedicineService();
        Page<Medicine> medicinePage = service.searchMedicineByPage(currentPage, rows, key1, value1, key2, value2);
        System.out.println(medicinePage);
        HttpSession session = request.getSession();
        session.setAttribute("medicinePage", medicinePage);
        session.setAttribute("id", 4);
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