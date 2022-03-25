package dao;

import bean.Client;
import bean.Page;

import java.util.List;

public interface ClientDao {
    public List<Client> findAllClient();
    public void addClient(Client Client);
    public List<Client> searchClient(String key1, String value1, String key2, String value2, int start, int rows);
    public void deleteClient(String ano);
    public Client findClientByCno(String ano);
    public void reviseClient(Client Client, String cno);
    public int findTotalCount();
    public List<Client> findByPage(int start, int rows);
}