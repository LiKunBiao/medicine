package servlet.client;

import bean.Client;
import service.ClientService;

@javax.servlet.annotation.WebServlet("/FindClientByCnoServlet")
public class FindClientByCnoServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String cno = request.getParameter("cno");
        ClientService service = new ClientService();
        Client client = service.findClientByCno(cno);
        request.setAttribute("client", client);
        request.getRequestDispatcher("/reviseClient.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}