package servlet.medicine;

import service.MedicineService;

@javax.servlet.annotation.WebServlet("/DeleteMedicineServlet")
public class DeleteMedicineServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String mno = request.getParameter("mno");
        MedicineService service = new MedicineService();
        service.deleteMedicine(mno);
        response.sendRedirect("/FindMedicineByPageServlet");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}