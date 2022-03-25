package servlet.client;

import bean.Client;
import service.ClientService;

@javax.servlet.annotation.WebServlet("/AddClientServlet")
public class AddClientServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        Client client = new Client();
        client.setCno(request.getParameter("cno"));
        client.setCname(request.getParameter("cname"));
        client.setCsex(request.getParameter("csex"));
        client.setAno(request.getParameter("ano"));
        client.setCaddress(request.getParameter("caddress"));
        client.setCage(request.getParameter("cage"));
        client.setCdate(request.getParameter("cdate"));
        client.setCphone(request.getParameter("cphone"));
        client.setCremark(request.getParameter("cremark"));
        client.setCsymptom(request.getParameter("csymptom"));
        client.setMno(request.getParameter("mno"));
        ClientService service = new ClientService();
        service.addClient(client);
        response.sendRedirect("/FindClientByPageServlet");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}