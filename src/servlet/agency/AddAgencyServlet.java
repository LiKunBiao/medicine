package servlet.agency;

import bean.Agency;
import service.AgencyService;

@javax.servlet.annotation.WebServlet("/AddAgencyServlet")
public class AddAgencyServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        Agency agency = new Agency();
        agency.setAno(request.getParameter("ano"));
        agency.setAname(request.getParameter("aname"));
        agency.setAsex(request.getParameter("asex"));
        agency.setAphone(request.getParameter("aphone"));
        agency.setAremark(request.getParameter("aremark"));
        AgencyService service = new AgencyService();
        service.addAgency(agency);
        response.sendRedirect("/FindAgencyByPageServlet");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}