package servlet.client;

import service.ClientService;

@javax.servlet.annotation.WebServlet("/DeleteClientServlet")
public class DeleteClientServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String cno = request.getParameter("cno");
        ClientService service = new ClientService();
        service.deleteClient(cno);
        response.sendRedirect("/FindClientByPageServlet");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}