package servlet.medicine;

import bean.Medicine;
import service.MedicineService;

@javax.servlet.annotation.WebServlet("/AddMedicineServlet")
public class AddMedicineServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        Medicine medicine = new Medicine();
        medicine.setMno(request.getParameter("mno"));
        medicine.setMmode(request.getParameter("mmode"));
        medicine.setMefficacy(request.getParameter("mefficacy"));
        medicine.setMname(request.getParameter("mname"));
        MedicineService service = new MedicineService();
        service.addMedicine(medicine);
        response.sendRedirect("/FindMedicineByPageServlet");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}