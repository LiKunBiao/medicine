package servlet.agency;

import bean.Agency;
import service.AgencyService;

@javax.servlet.annotation.WebServlet("/FindAgencyByAnoServlet")
public class FindAgencyByAnoServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String ano = request.getParameter("ano");
        AgencyService service = new AgencyService();
        Agency agency = service.findAgencyByAno(ano);
        request.setAttribute("agency", agency);
        request.getRequestDispatcher("/reviseAgency.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}