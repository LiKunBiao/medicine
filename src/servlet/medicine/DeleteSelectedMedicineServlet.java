package servlet.medicine;

import service.MedicineService;

@javax.servlet.annotation.WebServlet("/DeleteSelectedMedicineServlet")
public class DeleteSelectedMedicineServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String[] mnos = request.getParameterValues("mno");
        MedicineService service = new MedicineService();
        service.deleteSelectMedicine(mnos);
        response.sendRedirect("/FindMedicineByPageServlet");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}