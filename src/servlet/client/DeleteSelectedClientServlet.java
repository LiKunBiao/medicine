package servlet.client;

import service.ClientService;

@javax.servlet.annotation.WebServlet("/DeleteSelectedClientServlet")
public class DeleteSelectedClientServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String[] cnos = request.getParameterValues("cno");
        ClientService service = new ClientService();
        service.deleteSelectClient(cnos);
        response.sendRedirect("/FindClientByPageServlet");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}