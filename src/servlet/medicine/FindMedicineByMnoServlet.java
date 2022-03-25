package servlet.medicine;

import bean.Medicine;
import service.MedicineService;

@javax.servlet.annotation.WebServlet("/FindMedicineByMnoServlet")
public class FindMedicineByMnoServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String mno = request.getParameter("mno");
        MedicineService service = new MedicineService();
        Medicine medicine = service.findMedicineByMno(mno);
        request.setAttribute("medicine", medicine);
        request.getRequestDispatcher("/reviseMedicine.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}