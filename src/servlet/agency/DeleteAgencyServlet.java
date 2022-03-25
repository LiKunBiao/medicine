package servlet.agency;

import service.AgencyService;

@javax.servlet.annotation.WebServlet("/DeleteAgencyServlet")
public class DeleteAgencyServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String ano = request.getParameter("ano");
        AgencyService service = new AgencyService();
        service.deleteAgency(ano);
        response.sendRedirect("/FindAgencyByPageServlet");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}