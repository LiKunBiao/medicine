package servlet.medicine;

import bean.Medicine;
import service.MedicineService;

@javax.servlet.annotation.WebServlet("/ReviseMedicineServlet")
public class ReviseMedicineServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        Medicine medicine = new Medicine();
        medicine.setMno(request.getParameter("mno"));
        medicine.setMname(request.getParameter("mname"));
        medicine.setMefficacy(request.getParameter("mefficacy"));
        medicine.setMmode(request.getParameter("mmode"));
        MedicineService service = new MedicineService();
        service.reviseMedicine(medicine, request.getParameter("mno"));
        response.sendRedirect("/FindMedicineByPageServlet");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}