package servlet.agency;

import service.AgencyService;

@javax.servlet.annotation.WebServlet("/DeleteSelectedAgencyServlet")
public class DeleteSelectedAgencyServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String[] anos = request.getParameterValues("ano");
        AgencyService service = new AgencyService();
        service.deleteSelectAgency(anos);
        response.sendRedirect("/FindAgencyByPageServlet");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}