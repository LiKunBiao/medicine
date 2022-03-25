package servlet.medicine;

import bean.Medicine;
import bean.Page;
import service.MedicineService;

import javax.servlet.http.HttpSession;

@javax.servlet.annotation.WebServlet("/FindOrdinaryMedicineServlet")
public class FindOrdinaryMedicineServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //1.获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数
        if(currentPage == null || "".equals(currentPage))
            currentPage = "1";
        if(rows == null || "".equals(rows))
            rows = "5";
        //调用service查询
        MedicineService service = new MedicineService();
        Page<Medicine> medicinePage = service.findMedicineByPage(currentPage, rows);
        System.out.println(medicinePage);
        HttpSession session = request.getSession();
        session.setAttribute("medicinePage", medicinePage);
        session.setAttribute("id", 4);
        response.sendRedirect("/ordinaryMain.jsp");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}