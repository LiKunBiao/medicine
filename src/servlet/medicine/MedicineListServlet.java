package servlet.medicine;

import bean.Medicine;
import service.MedicineService;

import javax.servlet.http.HttpSession;
import java.util.List;

@javax.servlet.annotation.WebServlet("/MedicineListServlet")
public class MedicineListServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        request.setCharacterEncoding("utf-8");
        MedicineService service = new MedicineService();
        List<Medicine> agencies = service.findAllMedicine();
        HttpSession session = request.getSession();
        session.setAttribute("agencies", agencies);
        session.setAttribute("id", 4);
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